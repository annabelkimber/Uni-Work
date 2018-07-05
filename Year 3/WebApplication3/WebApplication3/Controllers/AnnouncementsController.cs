using Microsoft.AspNetCore.Authorization;
using Microsoft.AspNetCore.Identity;
using Microsoft.AspNetCore.Mvc;
using Microsoft.EntityFrameworkCore;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using WebApplication3.Data;
using WebApplication3.Models;

namespace WebApplication3.Controllers
{
    [Authorize]
    public class AnnouncementsController : Controller
    {
        private readonly ApplicationDbContext _context;
        private readonly UserManager<ApplicationUser> _um;

        public object ApplicationDbContext { get; private set; }

        public AnnouncementsController(ApplicationDbContext context,
            UserManager<ApplicationUser> um)
        {
            _context = context;
            _um = um;
        }

        // GET: Announcements
        public async Task<IActionResult> Index()
        {
            ApplicationUser user = GetCurrentAnnouncement();
            return View(await _context.Announcements.ToListAsync());

        }

        private async Task<GalleryViewModel> GetGalleryViewModelFromAnnoucement(Announcements announcements)
        {
            GalleryViewModel viewModel = new GalleryViewModel();

            viewModel.Announcement = announcements;

            //Now get comments from database
            IEnumerable<Comments> comments = await _context.Comments
                .Where(x => x.Announcement == announcements).ToListAsync();

            viewModel.Comments = comments;
            return viewModel;
        }
        // GET: Announcements/Details/5
        public async Task<IActionResult> Details(int? id)
        {
            if (id == null)
            {
                return NotFound();
            }

            Announcements announcements = await _context.Announcements
                .SingleOrDefaultAsync(m => m.Id == id);

            //adds a counter to the announcements
            //for every click the counter increases by 1
            announcements.StatsCounter++;
            await _context.SaveChangesAsync();

            if (announcements == null)
            {
                return NotFound();
            }
            GalleryViewModel viewModel = await GetGalleryViewModelFromAnnoucement(announcements);

            return View(viewModel);
        }

        [HttpPost]
        [ValidateAntiForgeryToken]
        public async Task<IActionResult> Details([Bind("AnnounceID, CommentBody")]
            GalleryViewModel viewModel)
        {
            //throws an error if the add comment box is null or contains an empty string
            if (viewModel.CommentBody == null || viewModel.CommentBody.Equals(""))
            {
                if(_context.Announcements.FirstOrDefault(x => x.Id == viewModel.AnnounceID) != null)
                {
                    return RedirectToAction("Details", new { id = viewModel.AnnounceID });
                }else return NotFound();
            }
            if (ModelState.IsValid)
            {
                Comments comments = new Comments();

                comments.CommentBody = viewModel.CommentBody;

                Announcements announcements = await _context.Announcements
                    .SingleOrDefaultAsync(m => m.Id == viewModel.AnnounceID);

                //if there are no announcements then you can't add a comment
                if (announcements == null)
                {
                    return NotFound();
                }
                //adds comments to the database, 
                comments.Announcement = announcements;
                _context.Comments.Add(comments);
                await _context.SaveChangesAsync();
                //shows the model where the comments are linked to the announcement
                viewModel = await GetGalleryViewModelFromAnnoucement(announcements);

            }
            return View(viewModel);
        }


        // GET: Announcements/Create
        [Authorize(Policy = "CanCreatePost")]
        public IActionResult Create()
        {
            return View();
        }

        // POST: Announcements/Create
        // To protect from overposting attacks, please enable the specific properties you want to bind to, for 
        // more details see http://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public async Task<IActionResult> Create([Bind("Id,AnnouceTitle,AnnouceBody")] Announcements announcements)
        {
            if (ModelState.IsValid)
            {
                //adds an announcement to the database 
                ApplicationUser user = GetCurrentAnnouncement();
                announcements.User = user;
                announcements.DatePosted = DateTime.Now;
                _context.Add(announcements);
                await _context.SaveChangesAsync();
                return RedirectToAction(nameof(Index));
            }
            return View(announcements);
        }

        private ApplicationUser GetCurrentAnnouncement()
        {
            var userId = _um.GetUserId(HttpContext.User);
            ApplicationUser user = _context.Users
                .FirstOrDefault(x => x.Id == userId);
            return user;
        }

        // GET: Announcements/Edit/5
        [Authorize (Policy = "CanEditPost")]
        public async Task<IActionResult> Edit(int? id)
        {
            //makes sure you can't edit an announcement that isn't there
            if (id == null)
            {
                return NotFound();
            }

            //returns not found if the annoucement is null
            var announcements = await _context.Announcements.SingleOrDefaultAsync(m => m.Id == id);
            if (announcements == null)
            {
                return NotFound();
            }
            return View(announcements);
        }

        // POST: Announcements/Edit/5
        // To protect from overposting attacks, please enable the specific properties you want to bind to, for 
        // more details see http://go.microsoft.com/fwlink/?LinkId=317598.
        //[Authorize(Roles = "Member")]
        [HttpPost]
        [ValidateAntiForgeryToken]
        public async Task<IActionResult> Edit(int id, [Bind("Id,AnnouceTitle,AnnouceBody,DatePosted")] Announcements announcements)
        {
            if (id != announcements.Id)
            {
                return NotFound();
            }

            if (ModelState.IsValid)
            {
                try
                {
                    //updates the announcement body in the database - 'edditing' the announcement
                    _context.Update(announcements);
                    await _context.SaveChangesAsync();
                }
                catch (DbUpdateConcurrencyException)
                {
                    if (!AnnouncementsExists(announcements.Id))
                    {
                        return NotFound();
                    }
                    else
                    {
                        throw;
                    }
                }
                return RedirectToAction(nameof(Index));
            }
            return View(announcements);
        }

        // GET: Announcements/Delete/5
        [Authorize(Policy = "CanDeletePost")]
        public async Task<IActionResult> Delete(int? id)
        {
            if (id == null)
            {
                return NotFound();
            }

            var announcements = await _context.Announcements
                .SingleOrDefaultAsync(m => m.Id == id);

            var comments = _context.Comments
                .Where(x => x.Announcement.Id == id);
               

            if (announcements == null)
            {
                return NotFound();
            } if (comments == null)
            {
                return NotFound();
            }

            return View(announcements);
        }

        // POST: Announcements/Delete/5

        [HttpPost, ActionName("Delete")]
        [ValidateAntiForgeryToken]
        public async Task<IActionResult> DeleteConfirmed(int id)
        {
            var announcements = await _context.Announcements
                .SingleOrDefaultAsync(m => m.Id == id);

            //Deletes the comments so that the annouoncement can be deleted without affected referential integrity 
            var comments = _context.Comments
                .Where(x => x.Announcement.Id == id);
            foreach(var comment in comments)
            {
                _context.Comments.Remove(comment);
            }
            //once the comment has been deleted, it deletes the announcement
            _context.Announcements.Remove(announcements);
            await _context.SaveChangesAsync();
            return RedirectToAction(nameof(Index));
        }

        private bool AnnouncementsExists(int id)
        {
            return _context.Announcements.Any(e => e.Id == id);
        }
        
        /*[ValidateAntiForgeryToken]*/
        //Additional feature - search function 
        public async Task<IActionResult> Search()
        {
            string query = HttpContext.Request.Query["q"].ToString();
            if (!String.IsNullOrEmpty(query))
            {
                //searches through a list of annoucements to see if the inputted string is contained within any of the announcement titles
                //if it is, they are displayed as a list
                List<Announcements> announcements = await _context.Announcements.Where(s => s.AnnouceTitle.Contains(query)).ToListAsync();
                return View("Index", announcements);
            }
            return RedirectToAction(nameof(Index));            
        }
    }
}

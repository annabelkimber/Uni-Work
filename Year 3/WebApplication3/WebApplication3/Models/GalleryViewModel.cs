using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;

namespace WebApplication3.Models
{
    public class GalleryViewModel 
    {
        public Announcements Announcement { get; set; }
        public IEnumerable<Comments> Comments { get; set; }

        public int AnnounceID { get; set; }

        [Required]
        [Display(Name = "Comment")]
        public string CommentBody { get; set; }

        public virtual ApplicationUser User { get; set; }
    }
}

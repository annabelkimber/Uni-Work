using Microsoft.AspNetCore.Identity;
using Microsoft.Extensions.Logging;
using System;
using System.Linq;
using System.Security.Claims;
using System.Threading.Tasks;
using WebApplication3.Data;
using WebApplication3.Models;

namespace WebApplication3
{
    public class DbInitializer
    {
        public static async Task Initialize(ApplicationDbContext context, UserManager<ApplicationUser> userManager,
            RoleManager<IdentityRole> rm, ILogger<DbInitializer> logger)
        {
            context.Database.EnsureCreated();
            //Seeding annoucements to the database
            if (!context.Announcements.Any())
            {

                Announcements annouce1 = new Announcements()
                {
                    AnnouceTitle = "Announcement One",
                    AnnouceBody = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. In sagittis, nibh convallis euismod porttitor, "
                    + "urna nisi bibendum ex, vitae dictum felis dolor non tortor. Integer lacinia mi vitae elit euismod cursus. "
                    + "Nam felis ligula, consectetur eget scelerisque vel,"
                    + "scelerisque et nunc. Phasellus tincidunt suscipit turpis, sit amet vehicula elit egestas id.",
                };
                context.Add(annouce1);

                Announcements annouce2 = new Announcements()
                {
                    AnnouceTitle = "Announcement Two",
                    AnnouceBody = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. In sagittis, nibh convallis euismod porttitor, "
                    + "urna nisi bibendum ex, vitae dictum felis dolor non tortor. Integer lacinia mi vitae elit euismod cursus. "
                    + "Nam felis ligula, consectetur eget scelerisque vel,"
                    + "scelerisque et nunc. Phasellus tincidunt suscipit turpis, sit amet vehicula elit egestas id.",
                };
                context.Add(annouce2);

                Announcements annouce3 = new Announcements()
                {
                    AnnouceTitle = "Announcement Three",
                    AnnouceBody = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. In sagittis, nibh convallis euismod porttitor, " 
                    + "urna nisi bibendum ex, vitae dictum felis dolor non tortor. Integer lacinia mi vitae elit euismod cursus. " 
                    + "Nam felis ligula, consectetur eget scelerisque vel," 
                    + "scelerisque et nunc. Phasellus tincidunt suscipit turpis, sit amet vehicula elit egestas id.",
                };
                context.Add(annouce3);

                context.SaveChanges();
            }
            //Seeding comment to the database - however could not get it to work
                Comments comment1 = new Comments()
                {
                    Announcement = context.Announcements.Find(4029),
                    CommentBody = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. In sagittis, nibh convallis euismod porttitor, "
                    + "urna nisi bibendum ex, vitae dictum felis dolor non tortor. Integer lacinia mi vitae elit euismod cursus. "
                    + "Nam felis ligula, consectetur eget scelerisque vel,"
                    + "scelerisque et nunc. Phasellus tincidunt suscipit turpis, sit amet vehicula elit egestas id.",
                };

            context.SaveChanges();


            // Look for any users.
            if (context.Users.Any())
            {
                return; // DB has been seeded
            }

            //Seeding customers to the database
            string[] customers =
            {
                "Customer1@email.com",
                "Customer2@email.com",
                "Customer3@email.com",
                "Customer4@email.com",
                "Customer5@email.com",
            };
            foreach(string user in customers)
            {
                await CreateDefaultUserAndCustomerRole(userManager, rm, logger, user);
            }
            string[] members =
            {
                "Member1@email.com"
            };
            foreach (string user in members)
            {
                await CreateDefaultUserAndRoleForApplication(userManager, rm, logger, user);
            }

            if (!context.RoleClaims.Any())
            {
                IdentityRole Member = context.Roles.FirstOrDefault(x => x.Name == "Member");
                Claim createPost = new Claim("CanCreatePost", "CanCreatePost");
                Claim edit = new Claim("CanEditPost", "CanEditPost");
                Claim delete = new Claim("CanDeletePost", "CanDeletePost");
                Claim comment = new Claim("CanCommentPost", "CanCommentPost");
                await rm.AddClaimAsync(Member, edit);
                await rm.AddClaimAsync(Member, createPost);
                await rm.AddClaimAsync(Member, delete);
                await rm.AddClaimAsync(Member, comment);
               //await rm.AddClaimAsync(Member, new Claim("canEdit", "canEdit"));
            }

        }

        //Creates an member role
        private static async Task CreateDefaultUserAndRoleForApplication(UserManager<ApplicationUser> um, RoleManager<IdentityRole> rm, 
            ILogger<DbInitializer> logger, string email)
        {
            const string memberRole = "Member";
            if(!rm.RoleExistsAsync(memberRole).Result) await CreateDefaultRole(rm, logger, memberRole);
            var user = await CreateDefaultUser(um, logger, email);
            await SetPasswordForDefaultUser(um, logger, email, user);
            await AddDefaultRoleToDefaultUser(um, logger, email, memberRole, user);
        }




        //Creates a customer role
        private static async Task CreateDefaultUserAndCustomerRole(UserManager<ApplicationUser> um, RoleManager<IdentityRole> rm,
    ILogger<DbInitializer> logger, string email)
        {
            const string customerRole = "Customer";
            if (!rm.RoleExistsAsync(customerRole).Result) await CreateDefaultRole(rm, logger, customerRole);
            var user = await CreateDefaultUser(um, logger, email);
            await SetPasswordForDefaultUser(um, logger, email, user);
            await AddDefaultRoleToDefaultUser(um, logger, email, customerRole, user);
        }


        private static async Task CreateDefaultRole(RoleManager<IdentityRole> rm, ILogger<DbInitializer> logger, string roleName)
        {
            logger.LogInformation($"Create the role `{roleName}` for application");
            var ir = await rm.CreateAsync(new IdentityRole(roleName));
            if (ir.Succeeded)
            {
                logger.LogDebug($"Created the role `{roleName}` successfully");
            }
            else
            {
                var exception = new ApplicationException($"Default role `{roleName}` cannot be created");
                logger.LogError(exception, GetIdentiryErrorsInCommaSeperatedList(ir));
                throw exception;
            }
        }

        //Creating a default user 
        private static async Task<ApplicationUser> CreateDefaultUser(UserManager<ApplicationUser> um, ILogger<DbInitializer> logger, string email)
        {
            logger.LogInformation($"Create default user with email `{email}` for application");
            var user = new ApplicationUser(email);

            var ir = await um.CreateAsync(user);
            if (ir.Succeeded)
            {
                logger.LogDebug($"Created default user `{email}` successfully");
            }
            else
            {
                var exception = new ApplicationException($"Default user `{email}` cannot be created");
                logger.LogError(exception, GetIdentiryErrorsInCommaSeperatedList(ir));
                throw exception;
            }

            var createdUser = await um.FindByEmailAsync(email);
            return createdUser;
        }

        //Sets the password to 'password' for all seeded accounts
        private static async Task SetPasswordForDefaultUser(UserManager<ApplicationUser> um, ILogger<DbInitializer> logger, string email, ApplicationUser user)
        {
            logger.LogInformation($"Set password for default user `{email}`");
            const string password = "password";
            var ir = await um.AddPasswordAsync(user, password);
            if (ir.Succeeded)
            {
                logger.LogTrace($"Set password `{password}` for default user `{email}` successfully");
            }
            else
            {
                var exception = new ApplicationException($"Password for the user `{email}` cannot be set");
                logger.LogError(exception, GetIdentiryErrorsInCommaSeperatedList(ir));
                throw exception;
            }
        }

        private static async Task AddDefaultRoleToDefaultUser(UserManager<ApplicationUser> um, ILogger<DbInitializer> logger, string email, string administratorRole, ApplicationUser user)
        {
            logger.LogInformation($"Add default user `{email}` to role '{administratorRole}'");
            var ir = await um.AddToRoleAsync(user, administratorRole);
            if (ir.Succeeded)
            {
                logger.LogDebug($"Added the role '{administratorRole}' to default user `{email}` successfully");
            }
            else
            {
                var exception = new ApplicationException($"The role `{administratorRole}` cannot be set for the user `{email}`");
                logger.LogError(exception, GetIdentiryErrorsInCommaSeperatedList(ir));
                throw exception;
            }
        }

        private static string GetIdentiryErrorsInCommaSeperatedList(IdentityResult ir)
        {
            string errors = null;
            foreach (var identityError in ir.Errors)
            {
                errors += identityError.Description;
                errors += ", ";
            }
            return errors;
        }
    }
}
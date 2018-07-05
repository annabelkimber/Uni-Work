using Microsoft.AspNetCore.Identity;

namespace WebApplication3.Models
{
    // Add profile data for application users by adding properties to the ApplicationUser class
    public class ApplicationUser : IdentityUser
    {
        public ApplicationUser() : base()
        {

        }
        public ApplicationUser(string userName) : base(userName)
        {
            base.Email = userName;
        }
    }
}

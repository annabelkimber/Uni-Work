//using Microsoft.AspNetCore.Identity;
//using System;
//using System.Collections.Generic;
//using System.Linq;
//using System.Threading.Tasks;

//namespace WebApplication3.Configuration
//{
//    public class UserRoleSeed
//    {
//        private readonly RoleManager<IdentityRole> _roleManager;

//        public UserRoleSeed(RoleManager<IdentityRole> roleManager)
//        {
//            _roleManager = roleManager;

//        }

//        public async void Seed()
//        {

//            if ((await _roleManager.FindByNameAsync("Member")) == null)
//            {
//                await _roleManager.CreateAsync(new IdentityRole { Name = "Member" });
//            }
//            if ((await _roleManager.FindByNameAsync("Customer")) == null)
//            {
//                await _roleManager.CreateAsync(new IdentityRole { Name = "Customer" });
//            }
//        }
   
//    }
//}

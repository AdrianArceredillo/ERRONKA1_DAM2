using System;
using System.Collections.Generic;
using System.Data.Entity.ModelConfiguration.Conventions;
using System.Data.Entity;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Grafikoak_Joseba.Models
{
    internal class HJAADbContext : DbContext
    {
        public HJAADbContext() : base(nameOrConnectionString: "HJAADbContext") { }
        public DbSet<product_template> Products { get; set; }
        public DbSet<sale_order_line> Sales { get; set; }
        public DbSet<purchase_order> Purchases { get; set; }
        public DbSet<res_partner> Suppliers { get; set; }
        public DbSet<res_users> Workers { get; set; }


        protected override void OnModelCreating(DbModelBuilder modelBuilder)
        {
            modelBuilder.HasDefaultSchema("public");
            modelBuilder.Conventions.Remove<PluralizingTableNameConvention>();
        }
    }
}


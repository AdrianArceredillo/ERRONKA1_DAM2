using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Data.Entity;
using System.Data.Entity.ModelConfiguration.Conventions;

namespace PruebaGrafico0.Models
{
    public class PruebaErronkaDbContext : DbContext
    {
        public PruebaErronkaDbContext() : base(nameOrConnectionString: "PruebaErronkaDbContext")
        { }
        public DbSet<sale_order_line> Salmentak { get; set; }
        public DbSet<sale_order> SalmentakGeneral { get; set; }
        public DbSet<product_template> Produktuak { get; set; }
        public DbSet<purchase_order_line> Erosketak { get; set; }
        public DbSet<res_partner> Bezeroak { get; set; }
        protected override void OnModelCreating(DbModelBuilder modelBuilder)
        {
            modelBuilder.HasDefaultSchema("public");
            modelBuilder.Conventions.Remove<PluralizingTableNameConvention>();
        }
    }
}

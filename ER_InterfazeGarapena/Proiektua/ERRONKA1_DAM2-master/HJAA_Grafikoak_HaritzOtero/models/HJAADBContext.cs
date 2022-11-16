using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.Data.Entity.ModelConfiguration.Conventions;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace HJAA_Grafikoak_HaritzOtero.models
{
    internal class HJAADBContext : DbContext
    {
        public HJAADBContext() : base(nameOrConnectionString: "HJAADBContext")
        { }
        public DbSet <product_template> product_template { get; set; }

        public DbSet <stock_quant> stock_quant { get; set; }

        public DbSet<product_product> product_product { get; set; }



        protected override void OnModelCreating(DbModelBuilder modelBuilder)
        {
            modelBuilder.HasDefaultSchema("public");
            modelBuilder.Conventions.Remove<PluralizingTableNameConvention>();
            modelBuilder.Entity<product_product>()
                .HasRequired(p => p.product_template)
                .WithMany(a => a.product_product)
                .HasForeignKey(b => b.product_tmpl_id);

        }
    }
}

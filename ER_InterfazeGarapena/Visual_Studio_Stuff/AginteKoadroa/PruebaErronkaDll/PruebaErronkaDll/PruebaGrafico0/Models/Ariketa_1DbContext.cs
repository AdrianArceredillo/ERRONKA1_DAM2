using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Data.Entity;
using System.Data.Entity.ModelConfiguration.Conventions;

namespace PruebaGrafico0.Models
{
    public class Ariketa_1DbContext : DbContext
    {
        public Ariketa_1DbContext() : base(nameOrConnectionString: "Ariketa_1DbContext")
        { }
        public DbSet<Producto> Producto { get; set; }
        public DbSet<Compra> Compra { get; set; }
        protected override void OnModelCreating(DbModelBuilder modelBuilder)
        {
            modelBuilder.HasDefaultSchema("public");
            modelBuilder.Conventions.Remove<PluralizingTableNameConvention>();
        }
    }
}

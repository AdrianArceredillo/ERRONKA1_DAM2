using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Grafikoak_Joseba.Models
{
    internal class sale_order_line
    {//PROBA
        [Key]
        public int id { get; set; }
        public string name { get; set; }
        public int qty_invoiced { get; set; }
        public int product_uom_qty { get; set; }
        public int price_total { get; set; }
        public DateTime create_date { get; set; }
        public int untaxed_amount_invoiced { get; set; }
        public int salesman_id { get; set; } //Forein Key

        [ForeignKey("salesman_id")]
        public virtual res_users Workers { get; set; }
    }
}



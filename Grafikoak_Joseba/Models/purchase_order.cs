using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Grafikoak_Joseba.Models
{//aa
    internal class purchase_order
    {
        [Key]
        public int id { get; set; }
        public string name { get; set; }
        public double amount_total { get; set; }
        public DateTime date_order { get; set; }
        public DateTime date_planned { get; set; }

        public int partner_id { get; set; } //Forein Key

        [ForeignKey("partner_id")]
        public virtual res_partner Suppliers { get; set; }

    }
}




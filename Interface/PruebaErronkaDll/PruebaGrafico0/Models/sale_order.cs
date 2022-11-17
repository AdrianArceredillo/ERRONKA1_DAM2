using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace PruebaGrafico0.Models
{
    public class sale_order
    {
        [Key]
        public int id { get; set; }
        public string name { get; set; }
        public DateTime date_order { get; set; }
        public DateTime create_date { get; set; }
        public int user_id { get; set; }
        public int partner_id { get; set; }
        public int amount_total { get; set; }
        public int company_id { get; set; }
        
        [ForeignKey("partner_id")]
        public res_partner res_Partner { get; set; }
        //public product_template product_Template { get; set; }
    }
}

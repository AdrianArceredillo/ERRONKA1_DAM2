using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Grafikoak_Joseba.Models
{
    internal class res_partner
    {
        public int id { get; set; }
        public string name { get; set; }
        public virtual List<purchase_order> Purchases { get; set; }



    }
}

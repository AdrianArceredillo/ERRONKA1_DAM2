using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Grafikoak_Joseba.Models
{
    internal class res_users
    {
        public int id { get; set; }
        public string login { get; set; }
        public virtual List<sale_order_line> Sales { get; set; }

    }
}

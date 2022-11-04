using PruebaGrafico0.LoginForm;
using PruebaGrafico0.BezeroBakoitzarenGastuak;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using System.Windows.Forms;
using PruebaGrafico0.SalmentakEpeak;

namespace PruebaGrafico0
{
    internal static class Program
    {
        /// <summary>
        /// Punto de entrada principal para la aplicación.
        /// </summary>
        [STAThread]
        static void Main()
        {
            Application.EnableVisualStyles();
            Application.SetCompatibleTextRenderingDefault(false);

            //----------------------------
            //Formularios de la aplicación
            //----------------------------

            //Application.Run(new frmLogin());
            //Application.Run(new Form1());
            //Application.Run(new frmBezeroBakoitzarenGastuak());   //run this
            Application.Run(new frmSalmentakEpeak());
        }
    }
}

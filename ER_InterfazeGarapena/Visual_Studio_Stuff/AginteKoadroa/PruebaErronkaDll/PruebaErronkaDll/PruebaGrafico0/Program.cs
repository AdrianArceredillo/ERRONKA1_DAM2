using PruebaGrafico0.LoginForm;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using System.Windows.Forms;

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

            Application.Run(new frmLogin());
            //Application.Run(new Form1());
        }
    }
}


package org.jamessipac.controlador;

import org.jamessipac.modelo.Conexion;
import com.mysql.cj.protocol.Resultset;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
/**
 * DiagramaDeVentas representa la clase en la cual muestra un grafico con las ventas realizadas por días
 * @author James Sipac
 * @since 10 de septiembre de 2022
 */
public class DiagramaDeVentas {
    /**
     * Este metodo sirve para poder realizar un grafico con las ventar realizadas en ese dia
     * @param fecha Parametro para poder saber cual es el grafico que queremos ver
     */
    public static void graficar(String fecha){
        Connection con;
        Conexion cn=new Conexion();
        PreparedStatement ps;
        ResultSet rs;
        try {
            String sql="SELECT total FROM ventas WHERE fecha=?";
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.setString(1, fecha);
            rs=ps.executeQuery();
            DefaultPieDataset dataSet=new DefaultPieDataset();
            while (rs.next()) {                
                dataSet.setValue(rs.getString("total"), rs.getDouble("total"));
            }
            JFreeChart jf=ChartFactory.createPieChart3D("Reporte de Venta", dataSet);
            ChartFrame f=new ChartFrame("Total de ventas por día", jf);
            f.setSize(1000, 500);
            f.setLocationRelativeTo(null);
            f.setVisible(true);
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }
}

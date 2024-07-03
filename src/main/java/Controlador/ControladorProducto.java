package Controlador;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.ClassProducto;
import model.TblProductocl3;

/**
 * Servlet implementation class ControladorProducto
 */
public class ControladorProducto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControladorProducto() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		TblProductocl3 producto = new TblProductocl3();
	    ClassProducto crud = new ClassProducto();
	    List<TblProductocl3> listadoproducto = crud.ListadoProducto();
	    request.setAttribute("listadodeproductos", listadoproducto);

	    String accion = request.getParameter("accion");
	    if (accion != null) {
	        switch (accion) {
	            case "Actualizar":
	                int id = Integer.parseInt(request.getParameter("id"));
	                producto.setIdproductoscl3(id);
	                TblProductocl3 buscarid = crud.BuscarProducto(producto);
	                request.setAttribute("ID", buscarid.getIdproductoscl3());
	                request.setAttribute("nombre", buscarid.getNombrecl3());
	                request.setAttribute("preciocomp", buscarid.getPreciocompcl3());
	                request.setAttribute("precioven", buscarid.getPrecioventacl3());
	                request.setAttribute("estado", buscarid.getEstadocl3());
	                request.setAttribute("descrip", buscarid.getDescripcl3());
	                break;
	        }
	    }

	    // Siempre redirige a RegistrarProducto.jsp
	    request.getRequestDispatcher("RegistrarProducto.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		String nombre = request.getParameter("nombre");
        double preciocomp;
        double precioven;
        String estado = request.getParameter("estado");
        String descrip = request.getParameter("descrip");

        try {
            preciocomp = Double.parseDouble(request.getParameter("preciocomp"));
            precioven = Double.parseDouble(request.getParameter("precioven"));
        } catch (NumberFormatException e) {
            // Manejo de errores para precios no válidos
            request.setAttribute("mensajeRegistro", "Error: Precio no válido.");
            request.getRequestDispatcher("RegistrarProducto.jsp").forward(request, response);
            return;
        }

        TblProductocl3 producto = new TblProductocl3();
        ClassProducto crud = new ClassProducto();
        
        producto.setNombrecl3(nombre);
        producto.setPreciocompcl3(preciocomp);
        producto.setPrecioventacl3(precioven);
        producto.setEstadocl3(estado);
        producto.setDescripcl3(descrip);
        
        crud.RegistrarProducto(producto);

        // Redirige a sí mismo para evitar reenvíos del formulario al recargar
        response.sendRedirect("ControladorProducto");
    }
}
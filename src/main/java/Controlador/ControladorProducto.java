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

    public ControladorProducto() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String accion = request.getParameter("accion");
        ClassProducto crud = new ClassProducto();

        if (accion != null) {
            switch (accion) {
                case "Actualizar":
                    // Recupera el ID del producto de la solicitud
                    int idProducto = Integer.parseInt(request.getParameter("id"));
                    
                    // Llama al m�todo para obtener el producto por ID
                    TblProductocl3 producto = crud.ObtenerProductoPorId(idProducto);
                    
                    // Establece el producto en la solicitud y redirige a la p�gina de actualizaci�n
                    request.setAttribute("producto", producto);
                    request.getRequestDispatcher("Actualizar.jsp").forward(request, response);
                    return;

                case "Eliminar":
                    int idEliminar = Integer.parseInt(request.getParameter("id"));
                    
                    // Elimina el producto por ID
                    TblProductocl3 productoEliminar = crud.ObtenerProductoPorId(idEliminar);
                    if (productoEliminar != null) {
                        crud.EliminarProducto(productoEliminar);
                    }
                    
                    // Actualiza la lista despu�s de eliminar
                    List<TblProductocl3> listado = crud.ListadoProducto();
                    request.setAttribute("listadodeproductos", listado);
                    request.getRequestDispatcher("RegistrarProducto.jsp").forward(request, response);
                    return;

                default:
                    // Cualquier otra acci�n puede ser manejada aqu�
                    break;
            }
        } else {
            // Si no hay acci�n, muestra la lista de productos
            List<TblProductocl3> listadoproducto = crud.ListadoProducto();
            request.setAttribute("listadodeproductos", listadoproducto);
            request.getRequestDispatcher("RegistrarProducto.jsp").forward(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String accion = request.getParameter("accion");
        ClassProducto crud = new ClassProducto();

        if ("Registrar".equals(accion)) {
            // Registrar un nuevo producto
            String nombre = request.getParameter("nombre");
            double preciocomp;
            double precioven;
            String estado = request.getParameter("estado");
            String descrip = request.getParameter("descrip");

            try {
                preciocomp = Double.parseDouble(request.getParameter("preciocomp"));
                precioven = Double.parseDouble(request.getParameter("precioven"));
            } catch (NumberFormatException e) {
                // Manejo de errores para precios no v�lidos
                request.setAttribute("mensajeRegistro", "Error: Precio no v�lido.");
                request.getRequestDispatcher("RegistrarProducto.jsp").forward(request, response);
                return;
            }

            TblProductocl3 producto = new TblProductocl3();
            producto.setNombrecl3(nombre);
            producto.setPreciocompcl3(preciocomp);
            producto.setPrecioventacl3(precioven);
            producto.setEstadocl3(estado);
            producto.setDescripcl3(descrip);

            crud.RegistrarProducto(producto);

        } else if ("Actualizar".equals(accion)) {
            // Actualizar un producto existente
            int idProducto = Integer.parseInt(request.getParameter("id"));
            String nombre = request.getParameter("nombre");
            double preciocomp;
            double precioven;
            String estado = request.getParameter("estado");
            String descrip = request.getParameter("descrip");

            try {
                preciocomp = Double.parseDouble(request.getParameter("preciocomp"));
                precioven = Double.parseDouble(request.getParameter("precioven"));
            } catch (NumberFormatException e) {
                // Manejo de errores para precios no v�lidos
                request.setAttribute("mensajeActualizacion", "Error: Precio no v�lido.");
                request.getRequestDispatcher("Actualizar.jsp").forward(request, response);
                return;
            }

            TblProductocl3 producto = crud.ObtenerProductoPorId(idProducto);
            if (producto != null) {
                producto.setNombrecl3(nombre);
                producto.setPreciocompcl3(preciocomp);
                producto.setPrecioventacl3(precioven);
                producto.setEstadocl3(estado);
                producto.setDescripcl3(descrip);
                crud.ActualizarProducto(producto);
            }

        }

        // Redirige a s� mismo para evitar reenv�os del formulario al recargar
        response.sendRedirect("ControladorProducto");
    }
}
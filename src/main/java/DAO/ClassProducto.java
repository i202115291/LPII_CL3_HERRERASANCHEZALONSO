package DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import Interfaces.IProducto;
import model.TblProductocl3;

public class ClassProducto implements IProducto{

	@Override
	public void RegistrarProducto(TblProductocl3 producto) {
		// TODO Auto-generated method stub
		EntityManagerFactory fabr=Persistence.createEntityManagerFactory("LPII_CL3_HERRERASANCHEZALONSO");
	    //permite gestionar entidades
		EntityManager em=fabr.createEntityManager();
		//iniciar transaccion
		em.getTransaction().begin();
		//registramos
		em.persist(producto);
		//emitimos mensaje por consola
		System.out.println("Producto registrado en la BD correctamente");
		//confirmamos
		em.getTransaction().commit();
		//cerramos la transaccion
		em.close();
	}

	@Override
	public void ActualizarProducto(TblProductocl3 producto) {
	    EntityManagerFactory fabr = Persistence.createEntityManagerFactory("LPII_CL3_HERRERASANCHEZALONSO");
	    EntityManager em = fabr.createEntityManager();

	    try {
	        em.getTransaction().begin();
	        // Actualiza el producto en la base de datos
	        em.merge(producto);
	        em.getTransaction().commit();
	    } catch (Exception e) {
	        em.getTransaction().rollback();
	        throw e;
	    } finally {
	        em.close();
	    }
	}
	
	public void EliminarProducto(TblProductocl3 producto) {
	    EntityManagerFactory fabr = Persistence.createEntityManagerFactory("LPII_CL3_HERRERASANCHEZALONSO");
	    EntityManager em = fabr.createEntityManager();

	    try {
	        em.getTransaction().begin();
	        // Recupera el producto por su ID y luego elimínalo
	        TblProductocl3 elim = em.find(TblProductocl3.class, producto.getIdproductoscl3());
	        if (elim != null) {
	            em.remove(elim);
	            System.out.println("Producto eliminado de la base de datos");
	        } else {
	            System.out.println("Producto no encontrado");
	        }
	        em.getTransaction().commit();
	    } catch (Exception e) {
	        em.getTransaction().rollback();
	        throw e;
	    } finally {
	        em.close();
	    }
	}
	
	@Override
	public TblProductocl3 BuscarProducto(TblProductocl3 producto) {
		//establecemos la conexion con la unidad de persistencia..
		EntityManagerFactory fabr=Persistence.createEntityManagerFactory("LPII_CL3_HERRERASANCHEZALONSO");
		//gestionar las entidads
		EntityManager em=fabr.createEntityManager();
		//iniciamos la transaccion
		em.getTransaction().begin();
		//recuperamos el codigo a buscar
		TblProductocl3 busprod=em.find(TblProductocl3.class,producto.getIdproductoscl3());
		//confirmamos 
		em.getTransaction().commit();
		//cerramos
		em.close();
		return busprod;
	}  //fin del metodo buscar cliente...

	@Override
	public List<TblProductocl3> ListadoProducto() {
		// TODO Auto-generated method stub
		//establecemos la conexion con la unidad de persistencia..
        EntityManagerFactory fabr=Persistence.createEntityManagerFactory("LPII_CL3_HERRERASANCHEZALONSO");
        //gestionamos las entidads
        EntityManager em=fabr.createEntityManager();
        //iniciamos la transaccion
        em.getTransaction().begin();
        //recuperamos los productos de la base de datos
        //***********utilizando jpql
        List<TblProductocl3> listadoproducto=em.createQuery("select p from TblProductocl3 p",TblProductocl3.class).getResultList();
        //confirmamos la transaccion
        em.getTransaction().commit();
        //cerramos
        em.close();
		return listadoproducto;
	}
	
	@Override
	public TblProductocl3 ObtenerProductoPorId(int idProducto) {
	    EntityManagerFactory emf = Persistence.createEntityManagerFactory("LPII_CL3_HERRERASANCHEZALONSO");
	    EntityManager em = emf.createEntityManager();

	    try {
	        // Busca el producto por ID
	        TblProductocl3 producto = em.find(TblProductocl3.class, idProducto);
	        return producto;
	    } catch (Exception e) {
	        e.printStackTrace();
	        return null; // Manejo de errores básico
	    } finally {
	        em.close();
	    }
	}

}


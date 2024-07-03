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
		// TODO Auto-generated method stub
		EntityManagerFactory fabr=Persistence.createEntityManagerFactory("LPII_CL3_HERRERASANCHEZALONSO");
		//permite gestionar entidades
		EntityManager em=fabr.createEntityManager();
		//iniciar transaccion
		em.getTransaction().begin();
		//actualizamos
		em.merge(producto);
		//comfirmamos 
		em.getTransaction().commit();
		//cerramos
		em.close();
	}
	
	public void EliminarProducto(TblProductocl3 producto) {
		//establecemos la conexion con unidad de persistencia.
		EntityManagerFactory fabr=Persistence.createEntityManagerFactory("LPII_CL3_HERRERASANCHEZALONSO");
		//gestionar las entidades
		EntityManager em=fabr.createEntityManager();
		//iniciamos la transaccion
		em.getTransaction().begin();
		//recuperamos el codigo a eliminar
		TblProductocl3 elim=em.merge(producto);
		//procedemos a eliminar el registro
		em.remove(elim);
		//emitimos mensaje por consola
		System.out.println("Producto eliminado de la base de datos");
		//confirmamos
		em.getTransaction().commit();
		//cerramos
		em.close();
		
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

}


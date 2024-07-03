package Interfaces;

import java.util.List;

import model.TblProductocl3;

public interface IProducto {
	
	public void RegistrarProducto(TblProductocl3 producto);
	public void ActualizarProducto(TblProductocl3 producto);
	public void EliminarProducto(TblProductocl3 producto);
	public TblProductocl3 BuscarProducto(TblProductocl3 producto);
	public List<TblProductocl3> ListadoProducto();

}

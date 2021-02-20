package edu.dao;

import java.util.List;

import edu.entity.Cliente;

public interface ClienteDao {

	public List<Cliente> listaClientes();

	public void insertarCliente(Cliente elCliente);
	
	//public void actualizarCliente(Cliente elCliente);

	public Cliente obtenerCliente(int id);
}

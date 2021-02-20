package edu.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import edu.entity.Cliente;

@Repository
public class ClienteRepositorio implements ClienteDao {

	@Autowired
	private SessionFactory sessionFactory;
			
	@Override
	@Transactional
	public List<Cliente> listaClientes() {
		//obtener la sesion
		Session mySesion= sessionFactory.getCurrentSession();
		//Crear la consulta
		Query<Cliente> queryClientes= mySesion.createQuery("from Cliente", Cliente.class);
		//Obtener la lista de cliente
		List<Cliente> clientes=queryClientes.getResultList();
		return clientes;
	}

	@Override
	@Transactional
	public void insertarCliente(Cliente elCliente) {
		Session mySession = sessionFactory.getCurrentSession();
		mySession.save(elCliente);
	}
	
	@Override
	@Transactional
	public Cliente obtenerCliente(int clienteID) {
		Session mySession = sessionFactory.getCurrentSession();
		Cliente clienteObtenido= mySession.get(Cliente.class, clienteID);
		return clienteObtenido;
	}

}

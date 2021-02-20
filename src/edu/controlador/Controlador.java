package edu.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import edu.dao.ClienteDao;
import edu.entity.Cliente;

@Controller
@RequestMapping("/cliente")
public class Controlador {

	@Autowired
	private ClienteDao clienteDAO;
	
	@RequestMapping("/lista")
	public String listaCliente(Model elModelo) {
		//Obtener los clientes desde el dao
		List<Cliente> losClientes= clienteDAO.listaClientes();
		//agregar los clientes al modelo
		elModelo.addAttribute("clientes", losClientes);
		return "lista-cliente";
	}
	
	@RequestMapping("/muestraFormularioAgregar")
	public String formularioCliente(Model elModelo) {
		//nuevo cliente
		Cliente clienteCreado = new Cliente();
		//se agrega el nuevo cliente al modelo
		elModelo.addAttribute("nuevoCliente", clienteCreado);
		return "formCliente";
	}
	
	@PostMapping("/insertaCliente")
	public String insertarCliente(@ModelAttribute("cliente") Cliente elCliente) {
		//Insertar cliente en la base de datos
		clienteDAO.insertarCliente(elCliente);
		return "redirect:/cliente/lista";
	}
	
	@GetMapping("/muestraFormularioActualizar")
	public String actualizarCliente(@RequestParam("clienteID") int id, Model elModelo) {
		//Obtener cliente en la base de datos
		Cliente clienteCreado= clienteDAO.obtenerCliente(id);
		//Darle un atributo al modelo que le pasamos;
		elModelo.addAttribute("nuevoCliente",clienteCreado);
		return "formCliente";
	}
	//TENGO QUE AGREGAR EL METODO DE EDITAR PARA EL FORMULARIO
}

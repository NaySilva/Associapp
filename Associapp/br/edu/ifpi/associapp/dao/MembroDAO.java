package br.edu.ifpi.associapp.dao;

import java.util.List;

import br.edu.ifpi.associapp.modelo.Familia;
import br.edu.ifpi.associapp.modelo.Membro;

public interface MembroDAO {
	
	public Membro inserirMembro(Membro m, Familia f);
	public Membro retornarMembroPorId(int id);
	public void removerMembro(int id);
	public List<Membro> listaMembros();
	

}
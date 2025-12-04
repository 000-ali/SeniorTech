package service;

import repository.TutorialRepositorio;
import Modelo.Tutorial;
import java.util.ArrayList;

public class TutorialService {

    private TutorialRepositorio repo = new TutorialRepositorio();

    public void cadastrar(Tutorial t) throws Exception {
        repo.salvar(t);
    }

    public ArrayList<Tutorial> buscar(String termo) throws Exception {
        return repo.buscar(termo);
    }

    public void atualizar(Tutorial t) throws Exception {
        repo.atualizar(t);
    }

    public void excluir(int id) throws Exception {
        repo.deletar(id);
    }
}

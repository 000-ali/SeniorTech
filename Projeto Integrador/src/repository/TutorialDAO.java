package repository;

import Modelo.Tutorial;
import java.util.ArrayList;

public interface TutorialDAO {

    void salvar(Tutorial t) throws Exception;

    ArrayList<Tutorial> buscar(String termo) throws Exception;

    void atualizar(Tutorial t) throws Exception;

    void deletar(int idTutorial) throws Exception;
}

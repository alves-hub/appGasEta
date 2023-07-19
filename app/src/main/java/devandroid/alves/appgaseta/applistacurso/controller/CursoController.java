package devandroid.alves.appgaseta.applistacurso.controller;

import java.util.ArrayList;
import java.util.List;

import devandroid.alves.appgaseta.applistacurso.model.Curso;

public class CursoController {

    //declarando lista
    private List listCursos;

    //metodo para pegar lista
    public List getListaCursos(){
        //estanciando uma lista passando um objeto Curso
        listCursos = new ArrayList<Curso>();

        listCursos.add(new Curso("Administração"));
        listCursos.add(new Curso("RH"));
        listCursos.add(new Curso("Desenvolvimento"));
        listCursos.add(new Curso("Enfermagem"));
        listCursos.add(new Curso("Culinária"));
        listCursos.add(new Curso("Costureira"));

        return listCursos;
    }

    public ArrayList<String> dadosParaSpinner(){

        ArrayList<String> dados = new ArrayList<>();

        for (int i = 0; i < getListaCursos().size(); i++) {
            Curso objeto = (Curso) getListaCursos().get(i);
            dados.add(objeto.getCursoDesejado());
        }

        return dados;
    }
}

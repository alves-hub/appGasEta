package devandroid.alves.appgaseta.applistacurso.model;

public class Curso {

    private String cursoDesejado;

    public Curso(String nomeCursoDesejado) {
        this.cursoDesejado = nomeCursoDesejado;
    }

    public String getCursoDesejado() {
        return cursoDesejado;
    }
    public void setCursoDesejado(String cursoDesejado) {
        this.cursoDesejado = cursoDesejado;
    }
}

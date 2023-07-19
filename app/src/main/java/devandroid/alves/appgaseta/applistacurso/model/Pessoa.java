package devandroid.alves.appgaseta.applistacurso.model;

public class Pessoa {
    // construtor da class pessoa
    // atributos da class pessoa - objetos - molde -odelo -template
    // metodos de acesso Getts and Setts

    private String primeiroNome;
    private String sobreNome;
    private String cursoDesejado;
    private String numeroTelefone;

    public Pessoa(){}

    public String getPrimeiroNome() {
        return primeiroNome;
    }

    public void setPrimeiroNome(String primeiroNome) {
        this.primeiroNome = primeiroNome;
    }

    public String getSobreNome() {
        return sobreNome;
    }

    public void setSobreNome(String sobreNome) {
        this.sobreNome = sobreNome;
    }

    public String getCursoDesejado() {
        return cursoDesejado;
    }

    public void setCursoDesejado(String cursoDesejado) {
        this.cursoDesejado = cursoDesejado;
    }

    public String getNumeroTelefone() {
        return numeroTelefone;
    }

    public void setNumeroTelefone(String numeroTelefone) {
        this.numeroTelefone = numeroTelefone;
    }

    //to String - para textos - string de caracteres
    @Override
    public String toString() {
        return "Pessoa{" +
                "primeiroNome='" + primeiroNome + '\'' +
                ", sobreNome='" + sobreNome + '\'' +
                ", cursoDesejado='" + cursoDesejado + '\'' +
                ", numeroTelefone='" + numeroTelefone + '\'' +
                '}';
    }
}

/*
Alunos: Alana Motta da Cruz
        Lucca Carraro Pinilla Eduardo
        Lyene de Souza Benvenutti
Disciplina: Fundamentos da Programação Orientada a Objetos
Entrega Semana 8
*/

public class Cavalo extends Animal { // Subclasse de Animal

    private static final long serialVersionUID = 1L; // Identificador
    private boolean temFerradura; // Atributo sobre se o cavalo tem ferradura no casco (true or false)
    private boolean temDenteDeLobo; // Atributo sobre se o cavalo tem dente de lobo (true or false)

    public Cavalo(String nome, String dono, int idade, boolean temFerradura, boolean temDenteDeLobo) {
        super(nome, dono, idade); // Palavra-chave super para reaproveitar o código da superclasse
        this.setTemFerradura(temFerradura); // Define se o cavalo tem ferradura a partir do parâmetro passado
        this.setTemDenteDeLobo(temDenteDeLobo); // Define se o cavalo tem dente de lobo a partir do parâmetro passado
        this.setEspecie("Cavalo"); // Define a espécie como cavalo
    }

    public boolean isTemFerradura() {
        return temFerradura;
    }

    public void setTemFerradura(boolean temFerradura) {
        this.temFerradura = temFerradura;
    }

    public boolean isTemDenteDeLobo() {
        return temDenteDeLobo;
    }

    public void setTemDenteDeLobo(boolean temDenteDeLobo) {
        this.temDenteDeLobo = temDenteDeLobo;
    }

    @Override
    public String toString() { // Sobrescreve o método toString da superclasse
        String retorno = "";
        String booleano;
        retorno = super.toString(); // Palavra-chave super para reaproveitar o código da superclasse
        booleano = this.isTemFerradura()? "Sim" : "Não"; // If-else reduzido para ferradura
        retorno += "Tem ferradura: " + booleano + "\n";
        booleano = this.isTemDenteDeLobo()? "Sim" : "Não"; // If-else reduzido para dente de lobo
        retorno += "Tem dente de lobo: " + booleano + "\n";
        return retorno;
    }

    @Override
    public String som() { // Implementa o método abstrato da superclasse
        return "Relincha! Iihhh";
    }

    @Override
    public String alimentacao() { // Implementa o método abstrato da superclasse
        return "O cavalo alimenta-se de ração, aveia e alfafa.";
    }

    @Override
    public String cuidados() { // Implementa o método abstrato da superclasse
        return "O cavalo precisa correr e trotar como cuidados básicos, além dos cuidados com os cascos.";
    }
}
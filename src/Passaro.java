/*
Alunos: Alana Motta da Cruz
        Lucca Carraro Pinilla Eduardo
        Lyene de Souza Benvenutti
Disciplina: Fundamentos da Programação Orientada a Objetos
Entrega Semana 8
*/

public class Passaro extends Animal { // Subclasse de Animal

    private static final long serialVersionUID = 1L; // Identificador
    private String corPlumagem; // Atributo cor da plumagem do pássaro
    private boolean sabeFalar; // Atributo sobre se o pássaro sabe falar (true or false)

    public Passaro(String nome, String dono, int idade, String corPlumagem, boolean sabeFalar) {
        super(nome, dono, idade); // Palavra-chave super para reaproveitar o código da superclasse
        this.setCorPlumagem(corPlumagem); // Define a cor da plumagem a partir do parâmetro passado
        this.setSabeFalar(sabeFalar); // Define se o pássaro sabe falar a partir do parâmetro passado
        this.setEspecie("Pássaro"); // Define a espécie como pássaro
    }

    public String getCorPlumagem() {
        return corPlumagem;
    }

    public void setCorPlumagem(String corPlumagem) {
        this.corPlumagem = corPlumagem;
    }

    public boolean isSabeFalar() {
        return sabeFalar;
    }

    public void setSabeFalar(boolean sabeFalar) {
        this.sabeFalar = sabeFalar;
    }

    @Override
    public String toString() { // Sobrescreve o método toString da superclasse
        String retorno = "";
        String booleano;
        retorno = super.toString(); // Palavra-chave super para reaproveitar o código da superclasse
        retorno += "Cor da plumagem: " + this.getCorPlumagem() + "\n";
        booleano = this.isSabeFalar()? "Sim" : "Não"; // If-else reduzido para sabeFalar
        retorno += "Sabe falar: " + booleano + "\n";
        return retorno;
    }

    @Override
    public String som() { // Implementa o método abstrato da superclasse
        return "Pia! Piu piu!";
    }

    @Override
    public String alimentacao() { // Implementa o método abstrato da superclasse
        return "O pássaro alimenta-se de alpiste e frutas.";
    }

    @Override
    public String cuidados() { // Implementa o método abstrato da superclasse
        return "O pássaro precisa de abrigo e estímulos como cuidados básicos.";
    }
}
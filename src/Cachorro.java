/*
Alunos: Alana Motta da Cruz
        Lucca Carraro Pinilla Eduardo
        Lyene de Souza Benvenutti
Disciplina: Fundamentos da Programação Orientada a Objetos
Entrega Semana 8
*/

public class Cachorro extends Animal { // Subclasse de Animal

    private static final long serialVersionUID = 1L; // Identificador
    private String porte; // Atributo porte do cachorro (pequeno, médio ou grande)
    private String comprimentoPelo; // Atributo comprimento do pelo do cachorro (curto ou longo)

    public Cachorro(String nome, String dono, int idade, String porte, String comprimentoPelo) { // Construtor da classe Cachorro
        super(nome, dono, idade); // Palavra-chave super para reaproveitar o código da superclasse
        this.setPorte(porte); // Define o porte a partir do parâmetro passado
        this.setComprimentoPelo(comprimentoPelo); // Define o comprimento do pelo a partir do parâmetro passado
        this.setEspecie("Cachorro"); // Define a espécie como cachorro
    }

    public String getPorte() {
        return porte;
    }

    public void setPorte(String porte) {
        this.porte = porte;
    }

    public String getComprimentoPelo() {
        return comprimentoPelo;
    }

    public void setComprimentoPelo(String comprimentoPelo) {
        this.comprimentoPelo = comprimentoPelo;
    }

    @Override
    public String toString() { // Sobrescreve o método toString da superclasse
        String retorno = "";
        retorno = super.toString(); // Palavra-chave super para reaproveitar o código da superclasse
        retorno += "Porte: " + this.getPorte() + "\n";
        retorno += "Comprimento do pelo: " + this.getComprimentoPelo() + "\n";
        return retorno;
    }

    @Override
    public String som() { // Implementa o método abstrato da superclasse
        return "Late! Au au!";
    }

    @Override
    public String alimentacao() { // Implementa o método abstrato da superclasse
        return "O cachorro alimenta-se de ração e carnes.";
    }

    @Override
    public String cuidados() { // Implementa o método abstrato da superclasse
        return "O cachorro precisa de tosa e banho como cuidados básicos.";
    }
}


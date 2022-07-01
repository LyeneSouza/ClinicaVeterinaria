/*
Alunos: Alana Motta da Cruz
        Lucca Carraro Pinilla Eduardo
        Lyene de Souza Benvenutti
Disciplina: Fundamentos da Programação Orientada a Objetos
Entrega Semana 8
*/

import java.io.Serializable; // Importa a classe Serializable

public abstract class Animal implements Serializable { // Implementa a classe Serializable para permitir persistência de dados

    private static final long serialVersionUID = 1L; // Identificador
    private String nome; // Atributo nome do animal
    private String dono; // Atributo nome do dono do animal
    private int idade; // Atributo idade do animal
    protected String especie; // Atributo espécie do animal (cachorro, pássaro ou cavalo)

    public Animal(String nome, String dono, int idade) { // Construtor da classe Animal
        this.setNome(nome); // Define o nome a partir do parâmetro passado
        this.setDono(dono); // Define o nome do dono a partir do parâmetro passado
        this.setIdade(idade); // Define a idade a partir do parâmetro passado
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDono() {
        return dono;
    }

    public void setDono(String dono) {
        this.dono = dono;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String toString() { // Método para retornar os dados do objeto em formato de String
        String retorno = "";
        retorno += "Nome: " + this.getNome() + "\n";
        retorno += "Idade: " + this.getIdade() + " anos\n";
        retorno += "Dono: " + this.getDono() + "\n";
        retorno += "Espécie: " + this.getEspecie() + "\n";
        retorno += "Som: " + som() + "\n";
        retorno += "Alimentação: " + alimentacao() + "\n";
        retorno += "Cuidados: " + cuidados() + "\n";
        return retorno;
    }

    public abstract String som(); // Método abstrato referente ao som do animal

    public abstract String alimentacao(); // Método abstrato referente à alimentação do animal

    public abstract String cuidados(); // Método abstrato referente aos cuidados do animal
}
/*
Alunos: Alana Motta da Cruz
        Lucca Carraro Pinilla Eduardo
        Lyene de Souza Benvenutti
Disciplina: Fundamentos da Programação Orientada a Objetos
Entrega Semana 8
*/

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class ClinicaVeterinaria {
    private ArrayList<Animal> animais; // Relação de agregação com a classe Animal

    public ClinicaVeterinaria() { // Construtor

        this.setAnimais(new ArrayList<Animal>()); // Instancia a lista de animais
    }

    public ArrayList<Animal> getAnimais() {
        return animais;
    }

    public void setAnimais(ArrayList<Animal> animais) {
        this.animais = animais;
    }

    public String[] leValores(String[] dadosIn) { // Lê os valores do usuário
        String[] dadosOut = new String[dadosIn.length]; // Instancia a lista dadosOut do mesmo tamanho da lista dadosIn

        for (int i = 0; i < dadosIn.length; i++) { // Para cada índice do dadosIn, ele atribui um valor passado pelo usuário no dadosOut
            dadosOut[i] = JOptionPane.showInputDialog("Entre com " + dadosIn[i] + ": "); // Abre a janelinha com input
        }

        return dadosOut; // Cria um array com as respostas do usuário
    }

    public Passaro lePassaro(){ // Lê um objeto do tipo Pássaro

        String[] valores = new String [5]; // Instancia um array de Strings com tamanho fixo de 5
        String[] nomeVal = {"Nome", "Dono", "Idade", "Cor da plumagem", "Sabe falar (s/n)"}; // O que vai aparecer para o usuário em cada pergunta
        valores = leValores(nomeVal); // Invoca o método leValores

        int idade = this.retornaInteiro(nomeVal[2], valores[2]); // Retorna um valor inteiro para idade
        boolean sabeFalar = this.retornaBoolean(nomeVal[4], valores[4]); // Retorna um valor boolean para sabeFalar

        Passaro passaro = new Passaro(valores[0], valores[1], idade, valores[3], sabeFalar); // Instancia o objeto pássaro
        return passaro; // Retorna um objeto do tipo Pássaro
    }

    public Cachorro leCachorro() { // Lê um objeto do tipo Cachorro

        String[] valores = new String[5]; // Instancia um array de Strings com tamanho fixo de 5
        String[] nomeVal = {"Nome", "Dono", "Idade", "Porte (pequeno, médio ou grande)", "Comprimento do pelo (curto ou longo)"}; // O que vai aparecer para o usuário em cada pergunta
        valores = leValores(nomeVal); // Invoca o método leValores

        int idade = this.retornaInteiro(nomeVal[2], valores[2]); // Retorna um valor inteiro para idade

        Cachorro cachorro = new Cachorro(valores[0], valores[1], idade, valores[3], valores[4]); // Instancia o objeto cachorro
        return cachorro; // Retorna um objeto do tipo Cachorro
    }

    public Cavalo leCavalo() { // Lê um objeto do tipo Cavalo
        String[] valores = new String[5]; // Instancia um array de Strings com tamanho fixo de 5
        String[] nomeVal = {"Nome", "Dono", "Idade", "Tem ferradura (s/n)", "Tem dente de lobo (s/n)"}; // O que vai aparecer para o usuário em cada pergunta
        valores = leValores(nomeVal); // Invoca o método leValores

        int idade = this.retornaInteiro(nomeVal[2], valores[2]); // Retorna um valor inteiro para idade
        boolean temFerradura = this.retornaBoolean(nomeVal[3], valores[3]); // Retorna um valor boolean para temFerradura
        boolean temDente = this.retornaBoolean(nomeVal[4], valores[4]); // Retorna um valor boolean para temDente

        Cavalo cavalo = new Cavalo(valores[0], valores[1], idade, temFerradura, temDente); // Instancia o objeto cavalo
        return cavalo; // Retorna um objeto do tipo Cavalo
    }

    private boolean intValido(String s) { // Transforma String em inteiro
        try {
            Integer.parseInt(s); // Tenta transformar uma string em inteiro
            return true;
        } catch (NumberFormatException e) { // Se não consegue transformar, gera erro
            return false;
        }
    }
    public int retornaInteiro(String pergunta, String resposta) { // Retorna um valor inteiro
        //Tenta converter o valor de resposta para inteiro, senão permanece no loop
        while (!this.intValido(resposta)) { // Enquanto o intValido for falso
            resposta = JOptionPane.showInputDialog(null, "Valor de " + pergunta + " incorreto!\n\nDigite um número inteiro por favor."); // Abre a janelinha com input
        }
        return Integer.parseInt(resposta); // Retorna o inteiro obtido a partir da String passada por parâmetro
    }

    private boolean booleanValido(String valor) { // Verifica se o valor é booleano
        String entrada = valor.toLowerCase(); // Deixa a resposta em lower case
        if (entrada.equals("s") || entrada.equals("n")) { // Se o valor for s ou n, retorna true
            return true;
        } else { // Senão, retorna false
            return false;
        }
    }

    public boolean retornaBoolean(String pergunta, String resposta) { // Retorna um boolean
        while (!this.booleanValido(resposta)) { // Enquanto a resposta for diferente de s ou n
            resposta = JOptionPane.showInputDialog(null, "Resposta para " + pergunta + " inválida!\n\nDigite s para sim e n para não por favor."); // Abre a janleinha com input
        }
        String valor = resposta.toLowerCase(); // Deixa a resposta em lower case
        if (valor.equals("s")) {
            return true;
        } else {
            return false;
        }
    }

    public void salvaAnimais (ArrayList<Animal> animais) { // Método para salvar os animais cadastrados no arquivo
        ObjectOutputStream outputStream = null;
        try {
            outputStream = new ObjectOutputStream(new FileOutputStream("clinicaVet.dados")); // Instância
            for (int i = 0; i < animais.size(); i++) {
                outputStream.writeObject(animais.get(i)); // O animal na posição i será escrito no buffer, aguardando para ir para o arquivo clinicaVet.dados
            }
        } catch (FileNotFoundException ex) { // Em caso de exceção do tipo arquivo não encontrado
            JOptionPane.showMessageDialog(null, "Impossível criar o arquivo!"); // Abre a janelinha com a mensagem
            ex.printStackTrace(); // Exibe a mensagem stack trace
        } catch (IOException ex) { // Em caso de outra exceção do tipo IO (input/output)
            ex.printStackTrace(); // Exibe a mensagem stack trace
        } finally { // Fecha o arquivo ObjectOutputStream - sempre vai ser executado, nesse caso
            try {
                if (outputStream != null) { // Se o outputStream não for nulo
                    outputStream.flush(); // Sai do buffer e grava no arquivo clinicaVet.dados
                    outputStream.close(); // Fecha o arquivo clinicaVet.dados
                }
            } catch (IOException ex) { // Em caso de exceção do tipo IO (input/output)
                ex.printStackTrace(); // Exibe a mensagem stack trace
            }
        }
    }
    @SuppressWarnings("finally") // "Previne" warnings
    public ArrayList<Animal> recuperaAnimais() { // Método para recuperar os animais excluídos
        ArrayList<Animal> animaisTemp = new ArrayList<Animal>(); // Instância da lista de animais temporários

        ObjectInputStream inputStream = null;

        try {
            inputStream = new ObjectInputStream(new FileInputStream("clinicaVet.dados")); // Instância
            Object obj = null;
            while ((obj = inputStream.readObject()) != null) { // Enquanto tiver objetos no arquivo clinicaVet.dados
                if (obj instanceof Animal) { // Verifica se o objeto é do tipo Animal
                    animaisTemp.add((Animal)obj); // Adiciona o objeto na lista temporária de animais
                }
            }
        } catch (EOFException ex) { // Quando o EOF (end of file) é alcançado
            System.out.println("Fim de arquivo."); // Imprime no console
        } catch (ClassNotFoundException ex) { // Em caso de exceção do tipo classe não encontrada
            ex.printStackTrace(); // Exibe a mensagem stack trace
        } catch (FileNotFoundException ex) { // Em caso de exceção do tipo arquivo não encontrado
            JOptionPane.showMessageDialog(null, "Arquivo com animais inexistente!"); // Abre a janelinha com a mensagem
            ex.printStackTrace(); // Exibe a mensagem stack trace
        } catch (IOException ex) { // Em caso de outra exceção do tipo IO (input/output)
            ex.printStackTrace(); // Exibe a mensagem stack trace
        } finally { // Fecha o arquivo ObjectInputStream
            try {
                if (inputStream != null) { // Se o inputStream não for nulo
                    inputStream.close(); // Fecha o arquivo clinicaVet.dados
                }
            } catch (final IOException ex) { // Em caso de exceção do tipo IO (input/output)
                ex.printStackTrace(); // Exibe a mensagem stack trace
            }
            return animaisTemp;
        }
    }
    public void menuClinicaVet() {
        String menu = "";
        String entrada;
        int opc1, opc2;
        do { // Executa pelo menos um vez
            menu = "Controle da Clínica Veterinária\n" +
                    "Opções:\n" + 
                    "1. Entrar com novos animais\n" +
                    "2. Exibir os animais cadastrados\n" +
                    "3. Limpar os animais cadastrados\n" +
                    "4. Gravar os animais adicionados\n" +
                    "5. Recuperar os animais excluídos\n" +
                    "0. Sair do aplicativo";
            entrada = JOptionPane.showInputDialog (menu + "\n\n"); // Abre a janelinha com input
            opc1 = this.retornaInteiro("Opção de menu", entrada); // Verifica a conversão do input (String) para inteiro

            switch (opc1) {
                case 1:// Entrar com novos dados de animais
                    menu = "Entrada de um novo animal\n" +
                        "Opções:\n" + 
                        "1. Cachorro\n" +
                        "2. Pássaro\n" +
                        "3. Cavalo\n";

                    entrada = JOptionPane.showInputDialog(menu + "\n\n"); // Abre a janelinha com input
                    opc2 = this.retornaInteiro("Opção de menu", entrada); // Verifica a conversão do input (String) para inteiro

                    switch (opc2) {
                        case 1: getAnimais().add((Animal)leCachorro()); // Adiciona o objeto cachorro na lista de animais
                            break;
                        case 2: getAnimais().add((Animal)lePassaro()); // Adiciona o objeto pássaro na lista de animais
                            break;
                        case 3: getAnimais().add((Animal)leCavalo()); // Adiciona o objeto cavalo na lista de animais
                            break;
                        default:
                            JOptionPane.showMessageDialog(null, "Entrada inválida!"); // Em caso de ser digitado outro número
                    }

                    break;
                case 2: // Exibir os dados cadastrados
                    if (getAnimais().size() == 0) { // Se a lista de animais estiver vazia
                        JOptionPane.showMessageDialog(null, "Não há animais cadastrados. Entre com novos dados."); // Abre a janelinha com a mensagem
                        break;
                    }
                    String dados = "";
                    for (int i = 0; i < getAnimais().size(); i++) { // Exibe os dados de cada animal cadastrado
                        dados += getAnimais().get(i).toString() + "---------------\n";
                    }
                    JOptionPane.showMessageDialog(null, dados); // Abre a janelinha com a mensagem
                    break;
                case 3: // Limpar os dados cadastrados
                    if (getAnimais().size() == 0) { // Se a lista de animais estiver vazia
                        JOptionPane.showMessageDialog(null, "Não há animais cadastrados. Entre com novos dados"); // Abre a janelinha com a mensagem
                        break;
                    }
                    getAnimais().clear(); // Limpa a lista de animais
                    JOptionPane.showMessageDialog(null, "Dados LIMPOS com sucesso!"); // Abre a janelinha com a mensagem
                    break;
                case 4: // Gravar os dados cadastrados
                    if (getAnimais().size() == 0) { // Se a lista de animais estiver vazia
                        JOptionPane.showMessageDialog(null, "Não há animais cadastrados. Entre com novos dados"); // Abre a janelinha com a mensagem
                        break;
                    }
                    salvaAnimais(getAnimais()); // Invoca o método para salvar os animais no arquivo
                    JOptionPane.showMessageDialog(null, "Dados SALVOS com sucesso!"); // Abre a janelinha com a mensagem
                    break;
                case 5: // Recuperar os dados excluídos
                    setAnimais(recuperaAnimais()); // Invoca o método para recuperar os animais excluídos
                    if (getAnimais().size() == 0) { // Se a lista de animais estiver vazia
                        JOptionPane.showMessageDialog(null,"Não há dados para apresentar."); // Abre a janelinha com a mensagem
                        break;
                    }
                    JOptionPane.showMessageDialog(null,"Dados RECUPERADOS com sucesso!"); // Abre a janelinha com a mensagem
                    break;
                case 0: // Finalizar o aplicativo
                    JOptionPane.showMessageDialog(null, "Aplicativo CLÍNICA VETERINÁRIA encerrado."); // Abre a janelinha com a mensagem
                    break;
                default: // Caso a resposta seja diferentes das opções oferecidas
                    JOptionPane.showMessageDialog(null, "Opção inválida."); // Abre a janelinha com a mensagem
            }
        } while (opc1 != 0); // Enquanto não finalizar o aplicativo escolhendo a opção 0
    }
    public static void main (String[] args) { // Método principal, de execução
        ClinicaVeterinaria clinica = new ClinicaVeterinaria(); // Instância
        clinica.menuClinicaVet(); // Invoca o método para abrir o menu
    }
}
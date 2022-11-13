import java.lang.System;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util. *;

class Pessoa{
    String nome;
    String cpf;
    public Pessoa(String nome, String cpf){
        this.nome = nome;
        this.cpf = cpf;
    }

    public String getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}


class Enfermeira extends Pessoa{
    public Enfermeira(String nome, String cpf) {
        super(nome, cpf);
    }

    @Override
    public String getNome() {
        return super.getNome();
    }

    @Override
    public String getCpf() {
        return super.getCpf();
    }

    @Override
    public void setCpf(String cpf) {
        super.setCpf(cpf);
    }

    @Override
    public void setNome(String nome) {
        super.setNome(nome);
    }
}



class Cidadao extends Pessoa{



    public Cidadao(String nome, String cpf) {
        super(nome, cpf);
    }


    @Override
    public String getNome() {
        return super.getNome();
    }

    @Override
    public String getCpf() {
        return super.getCpf();
    }

    @Override
    public void setNome(String nome) {
        super.setNome(nome);
    }

    @Override
    public void setCpf(String cpf) {
        super.setCpf(cpf);
    }
}




public class Main{



    public static void main(String[] arg){
        int opt = 1;
        int i = 1;
        List<Enfermeira> listEnf = new ArrayList<>();
        List<Cidadao> listCid = new ArrayList<>();
        Scanner sc = new Scanner (System.in);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd. MMM. yyyy");

        System.out.println("Informe o nome da Enfermeira\n");
        String name = sc.nextLine();
        System.out.println("Informe o cpf da Enfemeira\n");
        String cpf = sc.nextLine();
        Enfermeira aux = new Enfermeira(name,cpf);
        listEnf.add(aux);

        while(i == 1){

            System.out.println("[1] - Vacinar Cidadão\n[2] - Listar Cidadões\n[Qualquer Outra Tecla para sair]");
            opt = sc.nextInt();

            switch (opt){
                case 1:
                    System.out.println("entrouCase");
                    //Inputs e formatações - Obs: resolver situação do scanner skipping
                    System.out.println("Informe o cpf do Cidadão:\n");
                    String cpfC = sc.nextLine();
                    System.out.println("Informe o nome do Cidadão\n");
                    String nameC = sc.nextLine();
                    System.out.println("Informe a data da Primeira Dose -\n \bInformar em dd-mm-yyyy\b \n");
                    String date1 = sc.nextLine();
                    LocalDate date1f = LocalDate.parse(date1,dtf);
                    System.out.println("Informe a data da Segunda Dose -\n \bInformar em dd-mm-yyyy\b \n");
                    String date2 = sc.nextLine();
                    LocalDate date2f = LocalDate.parse(date2,dtf);
                    LocalDate proxVacina = new LocalDate(date1f.getYear(), date1f.getMonthValue()+4, date1f.getDayOfMonth());
                    if (proxVacina.compareTo(date2f) < 0){
                        System.out.println("Não pode dar 2 dose");
                    }else{
                        System.out.println("Informe a data da Terceira Dose -\n \bInformar em dd-mm-yyyy\b \n");
                        String date3 = sc.nextLine();
                        LocalDate date3f = LocalDate.parse(date2,dtf);
                        LocalDate proxVacina2 = new LocalDate(date2f.getYear(), date2f.getMonthValue()+4, date2f.getDayOfMonth());
                        if (proxVacina2.compareTo(date3f) < 0){
                            System.out.println("Não pode dar 3 dose");
                        }else{
                                    System.out.println("Funcionou Porra");
                        }
                    }
                    break;
                case 2:
                    break;
                default:
                    break;
            }

            System.out.println("[1] - Fazer uma nova operação\n[2] - Sair");
            i = sc.nextInt();
            if (i == 1){

            }else {
                sc.close();
                break;
            }

        }


    }
}


/*
* Problema private acess do localdate
* dados enfermeira
* */



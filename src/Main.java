import java.lang.System;
import java.util. *;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

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

    public void msgBemVindo(){
        System.out.println("Seja Bem-vindo(a) " + this.nome);
    }
}


class Cidadao extends Pessoa {

    LocalDate vacina1;
    LocalDate vacina2;
    LocalDate vacina3;
    LocalDate vacina4;

    public Cidadao(String nome, String cpf) {
        super(nome, cpf);
    }

    public void set(String cpf, String nome) {
        super.setNome(nome);
        super.setCpf(cpf);
    }

    public void setvcn(LocalDate vacina1, LocalDate vacina2, LocalDate vacina3, LocalDate vacina4) {
        this.vacina1 = vacina1;
        this.vacina2 = vacina2;
        this.vacina3 = vacina3;
        this.vacina4 = vacina4;
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
    public String toString() {
        return "nome: " + nome + " cpf: " + cpf + " data primeira vacina: " + vacina1 + " data segunda vacina: " + vacina2 + " data terceira vacina: " + vacina3 + " data quarta vacina: " + vacina4;
    }




    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

        public static void main(String[] arg){
            int opt = 1;
            int i = 1;
            int ii = 1;
            List<Cidadao> listCid = new ArrayList<>();
            Scanner sc = new Scanner (System.in);
            System.out.println("Informe o nome da Enfermeira\n");
            String name = sc.nextLine();
            System.out.println("Informe o cpf da Enfemeira\n");
            String cpf = sc.nextLine();
            Enfermeira myEnf = new Enfermeira(name,cpf);
            myEnf.msgBemVindo();

            while(i == 1){

                System.out.println("[1] - Vacinar Cidadão\n[2] - Listar Cidadões\n[Qualquer Outra Tecla para sair]");
                opt = sc.nextInt();

                switch (opt){
                    case 1:
                        Scanner sc2 = new Scanner (System.in);
                        System.out.println("Informe o cpf do Cidadão");
                        String nomeCid = sc2.nextLine();
                        System.out.println("Informe o nome do Cidadão");
                        String cpfCid = sc2.nextLine();


                        while(ii == 1){
                            System.out.println("Informe a data da Primeira Vacina");
                            LocalDate vc1 = LocalDate.parse(sc2.nextLine(), DateTimeFormatter.ofPattern("dd/MM/uuuu"));
                            System.out.println("Informe a data da Segunda Vacina");
                            LocalDate vc2 = LocalDate.parse(sc2.nextLine(), DateTimeFormatter.ofPattern("dd/MM/uuuu"));
                            LocalDate prox = vc1.plusDays(121);
                            clearScreen();

                            if(vc2.isAfter(prox)){
                                System.out.println("Informe a data da Terceira Vacina");
                                LocalDate vc3 = LocalDate.parse(sc2.nextLine(), DateTimeFormatter.ofPattern("dd/MM/uuuu"));
                                clearScreen();
                                LocalDate prox2 = vc2.plusDays(121);
                                if (vc3.isAfter(prox2)){
                                    System.out.println("Informe a data da Quarta Vacina");
                                    LocalDate vc4 = LocalDate.parse(sc2.nextLine(), DateTimeFormatter.ofPattern("dd/MM/uuuu"));
                                    LocalDate prox3 = vc3.plusDays(121);
                                    clearScreen();
                                    if (vc4.isAfter(prox3)){
                                        Cidadao myCid = new Cidadao(nomeCid, cpfCid);
                                        myCid.setvcn(vc1,vc2,vc3,vc4);
                                        listCid.add(myCid);
                                        ii = 0;
                                    }else{
                                        System.out.println("Periodo entre vacinas não é válido, tente novamente");
                                    }
                                }
                            }else{
                                System.out.println("Periodo entre vacinas não é válido, tente novamente");

                            }

                        }
                        break;
                    case 2:

                        System.out.println(listCid);

                        break;
                    default:
                        System.out.println("Saindo");
                        break;
                }

                System.out.println("[1] - Fazer uma nova operação\n[2] - Sair");
                i = sc.nextInt();

            }
        }
    }




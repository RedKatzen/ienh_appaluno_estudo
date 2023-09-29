package br.com.ienh;

import br.com.ienh.database.OperacoesAluno;
import br.com.ienh.util.Scan;

public class Programa {
    
    public static void run(){
        int opcaoUsuario = Scan.lerInt();

        switch(opcaoUsuario){
            case 1:
                OperacoesAluno.insereAluno();
                break;
            case 2:
                OperacoesAluno.consultaAlunos();
                break;
            default:
                break;
        } 

    }

}

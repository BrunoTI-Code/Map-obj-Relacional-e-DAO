/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cadastrobd;

import java.sql.SQLException;
import java.util.List;
import cadatrobd.model.PessoaFisica;
import cadatrobd.model.PessoaFisicaDAO;
import cadatrobd.model.PessoaJuridica;
import cadatrobd.model.PessoaJuridicaDAO;
import cadastrobd.model.Util.ConectorBD;
import java.sql.Connection;

/**
 *
 * @author Administrador
 */
public class CadastroBDTeste {

    public static void main(String[] args) {
        try {
            Connection conn = ConectorBD.getConnection();
            PessoaFisicaDAO pfDAO = new PessoaFisicaDAO();
            PessoaJuridicaDAO pjDAO = new PessoaJuridicaDAO();

            // Criar uma pessoa física
            PessoaFisica pf = new PessoaFisica(8, "Leonardo", "Rua k, 60", "Rio de Janeiro", "RJ",
                    "1234-5678", "Leonardo@gmail.com", "12345678910");

            // Persistir a pessoa física no banco de dados
            pfDAO.incluir(pf);
            System.out.println("Pessoa fisica criada:");
            pf.exibir();
            System.out.println();

            // Alterar os dados da pessoa fisica no banco
            pfDAO.alterar(pf, "Leonardo Kened", "Rua L, 50", "São Paulo", "SP",
                    "9939-8458", "LeonardoKened@email.com", "12345828900");
            System.out.println("---------------------------------");
            System.out.println("Dados da pessoa fisica alterados.");
            System.out.println("---------------------------------");
            System.out.println();

            // Consultar todas as pessoas físicas do banco de dados e listar no console
            List<PessoaFisica> pessoasFisicas = pfDAO.getPessoas();
            System.out.println("Todas as pessoas fisicas:");
            for (PessoaFisica pessoaFisica : pessoasFisicas) {
                pessoaFisica.exibir();
            }
            System.out.println();

            // Excluir a pessoa física criada anteriormente no banco
            System.out.println("---------------------------------");
            pfDAO.excluir(pf.getId());
            System.out.println("---------------------------------");
            System.out.println();

            // Criar uma pessoa jurídica
            PessoaJuridica pj = new PessoaJuridica(9, "Empresa Variente", "Av. São Luiz, 1900",
                    "Volta Redonda", "RJ", "1234-5678", "Variente@gmail.com", "12347578901234");

            // Persistir a pessoa jurídica no banco de dados
            pjDAO.incluir(pj);
            System.out.println("Pessoa juridica criada:");
            pj.exibir();
            System.out.println();

            // Alterar os dados da pessoa jurídica no banco
            pjDAO.alterar(pj, "Empresa Junina", "Av. Retiro, 50", "Barra do Pirai", "RJ",
                    "9876-5432", "Junina@gmail.com", "98765432176276");
            System.out.println("---------------------------------");
            System.out.println("Dados da pessoa juridica alterados.");
            System.out.println("---------------------------------");
            System.out.println();

            // Consultar todas as pessoas jurídicas do banco de dados e listar no console
            List<PessoaJuridica> pessoasJuridicas = pjDAO.getPessoas();
            System.out.println("Todas as pessoas juridicas:");
            for (PessoaJuridica pessoaJuridica : pessoasJuridicas) {
                pessoaJuridica.exibir();
            }
            System.out.println();

            // Excluir a pessoa jurídica criada anteriormente no banco
            System.out.println("---------------------------------");
            pjDAO.excluir(pj.getId());
            System.out.println("---------------------------------");
            System.out.println();

            ConectorBD.close(conn);

        } catch (SQLException e) {
            System.out.println("Ocorreu um erro: " + e.getMessage());
        }
    }
}

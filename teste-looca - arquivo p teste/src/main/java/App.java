import DataAcessObject.AlertaDAO;
import DataAcessObject.ComputadorDAO;
import DataAcessObject.StatusPcDAO;
import DataAcessObject.UsuarioDAO;
import Entidades.*;
import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.discos.DiscoGrupo;
import com.github.britooo.looca.api.group.discos.Volume;
import com.github.britooo.looca.api.group.memoria.Memoria;
import com.github.britooo.looca.api.group.sistema.Sistema;
import com.github.britooo.looca.api.group.processador.Processador;
import com.github.britooo.looca.api.util.Conversor;

import java.time.LocalDateTime;
import java.util.*;

import java.io.File;
import java.util.Arrays;
import java.util.List;

public class App {
    public static void main(String[] args) {
        // Fazer o login do usuário tambem. //// juhrs vai fazer
        System.out.println("""
                      
                                                              `╙N╖
                                                                  ╙▓╖
                                                                    ╙▓W
                                                                      ╙▓▓
                                                                        ▓▓W
                                                                         ▓▓▓
                                                                         └▓▓▓,
                                                                          ▓▓▓▓
                                                                          ]▓▓▓▓
                                                                          ]▓▓▓▓
                                                          ,               ]▓▓▓▓U
                                                     ,╓g▓▓▓▓▓▓▓▓▓W        ╫▓▓▓▓[
                                                 ,g▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓       ╓▓▓▓▓▓[
                                              ,@▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓╜      ,▓▓▓▓▓▓
                                            a▓▓▓▓▓▓▓▀╜``               ╓▓▓▓▓▓▓▓
                                          ╓▓▓▓▓▓╜                     á▓▓▓▓▓▓▓`
                                         ▓▓▓▓╜                        ▓▓▓▓▓▓▓╛
                                       ,▓▓▓`             ,▓▓▓▓W       ╙▓▓▓▓▓`
                                      ╓▓▓╜               ▓▓▓▓▓▓▓,
                                       ▓▓                 ▓▓▓▓▓▓▓▓W
                                      ╫▓                   "▓▓▓▓▓▓▓▓,                                 .
                                      ▓                      `▓▓▓▓▓▓▓▓W                             /`
                                    j▓                         ╨▓▓▓▓▓▓▓▓╗,                     ,e╜
                                    ][                            ╙▓▓▓▓▓▓▓▓▓Ww,,         ,,╥@Ñ╜
                                    ][                                "╙▀▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▀╜`
                                     [
                                     ╟
                  
                  \s
                  
                  \s
                    /$$$$$$                                /$$                                                 /$$                 /$$           \s
                   /$$__  $$                              | $$                                                |__/                | $$           \s
                  | $$  \\__/  /$$$$$$  /$$  /$$$$$$       | $$$$$$$   /$$$$$$  /$$$$$$/$$$$          /$$    /$$/$$ /$$$$$$$   /$$$$$$$  /$$$$$$  \s
                  |  $$$$$$  /$$__  $$|__/ |____  $$      | $$__  $$ /$$__  $$| $$_  $$_  $$ /$$$$$$|  $$  /$$/ $$| $$__  $$ /$$__  $$ /$$__  $$ \s
                   \\____  $$| $$$$$$$$ /$$  /$$$$$$$      | $$  \\ $$| $$$$$$$$| $$ \\ $$ \\ $$|______/ \\  $$/$$/| $$| $$  \\ $$| $$  | $$| $$  \\ $$ \s
                   /$$  \\ $$| $$_____/| $$ /$$__  $$      | $$  | $$| $$_____/| $$ | $$ | $$     aloysio@elera.io     \\  $$$/ | $$| $$  | $$| $$  | $$| $$  | $$ \s
                  |  $$$$$$/|  $$$$$$$| $$|  $$$$$$$      | $$$$$$$/|  $$$$$$$| $$ | $$ | $$           \\  $/  | $$| $$  | $$|  $$$$$$$|  $$$$$$/$$
                   \\______/  \\_______/| $$ \\_______/      |_______/  \\_______/|__/ |__/ |__/            \\_/   |__/|__/  |__/ \\_______/ \\______/__/
                                 /$$  | $$                                                                                                       \s
                                |  $$$$$$/                                                                                                       \s
                                 \\______/                                                                                                        \s
                
        
                """);

        // objetos que foram criados na mão
        Looca looca = new Looca();
        Computador computador = new Computador();
        StatusPc idCaptura = new StatusPc();
        StatusPc memoriaUso = new StatusPc();
        StatusPc processadorUso = new StatusPc();
        StatusPc discoDisponivel = new StatusPc();
        StatusPc dtHoraCaptura = new StatusPc();
        Usuario usuario = new Usuario();
        Scanner entrada = new Scanner(System.in);
        Alerta alerta = new Alerta();
        boolean autenticado = false;
        long TEMPO = (0);

        // Objetos do looca
        Memoria memoria = looca.getMemoria();
        Processador processador = looca.getProcessador();
        DiscoGrupo disco = looca.getGrupoDeDiscos();
        Sistema sistema = looca.getSistema();


        // Variáveis que guardam as informações para o cadastro
        String nomeProcessador = processador.getNome();
        computador.setProcessador(nomeProcessador);

        String sistemaOperacional = sistema.getSistemaOperacional();
        computador.setSO(sistemaOperacional);


        Long memoriaTotal = (memoria.getTotal());
        computador.setMemoriaTot(memoriaTotal);

        Long discoTotal = (disco.getTamanhoTotal());
        computador.setDiscoTotal((discoTotal));

        Integer qtdDicos = disco.getVolumes().size();
        computador.setQtdDiscos(qtdDicos);

        do {
            UsuarioDAO.pegarUsuario(usuario);
            System.out.println("Digite a usuário: ");
            String emailLogin = entrada.nextLine();

            System.out.println("Digite a senha: ");
            String senhaLogin = entrada.nextLine();

            if (!Objects.equals(emailLogin, usuario.getEmail()) || !Objects.equals(senhaLogin, usuario.getSenha())) {
                System.out.println("""
                                                 ╓▓╩╙╙╙╙╙╙╙╙╙╙╙╙╙╙╙╙╙╙╙╙╙╙╙╙╙▓w                            
                                               æ▓"  ╓╓╓╓╓╓╓╓╓╓╓╓╓╓╓╓╓╓╓╓╓╓╓╖  "▓W  
                                             g▓`  g▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓W   ▓▓
                                          ,▓▀   Æ▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓,  ▀▓,
                                        ,▓▀  ,▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▀""▀▓▓▓▓▓▓▓▓▓▓▓▓▓▓,  ╙▓╖
                                      ╓▓╜  ╓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▀╜▀▓▓      ▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓╖  ╙▓▄
                                    æ▓"  ╔▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓     ▓      ▓╜   ▀▓▓▓▓▓▓▓▓▓▓▓W  "▓W
                                  g▓`  g▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓     ╟      ▌     ▓▓▓▓▓▓▓▓▓▓▓▓▓W   ▀▓
                                ╔▓   Æ▓▓▓▓▓▓▓▓▓▓▓▓▓╜  `▓▓     ╟      ▌     ▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓,  ▓▓
                                ╟▌  ▓▓▓▓▓▓▓▓▓▓▓▓▓▓Γ     ▓     ╟      ▌     ▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓  ▐▓
                                ╟▌  ▓▓▓▓▓▓▓▓▓▓▓▓▓▓Γ     ▓     ╟      ▌     ▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓  ▐▓
                                ╟▌  ▓▓▓▓▓▓▓▓▓▓▓▓▓▓Γ     ▓     ╟      ▌     ▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓  ▐▓
                                ╟▌  ▓▓▓▓▓▓▓▓▓▓▓▓▓▓Γ     ▓     ╟      ▌     ▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓  ▐▓
                                ╟▌  ▓▓▓▓▓▓▓▓▓▓▓▓▓▓Γ     ▓     ╚      ▌     ▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓  ▐▓
                                ╟▌  ▓▓▓▓▓▓▓▓▓▓▓▓▓▓Γ     `            `     ▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓  ▐▓
                                ╟▌  ▓▓▓▓▓▓▓▓▓▓▓▓▓▓Γ                        ▓▓▓╜    ╙▓▓▓▓▓▓▓▓  ▐▓
                                ╟▌  ▓▓▓▓▓▓▓▓▓▓▓▓▓▓Γ                        ▓╜      ╔▓▓▓▓▓▓▓▓  ▐▓
                                ╟▌  ▓▓▓▓▓▓▓▓▓▓▓▓▓▓Γ                              ,▓▓▓▓▓▓▓▓▓▓  ▐▓
                                ╟▌  ▓▓▓▓▓▓▓▓▓▓▓▓▓▓Γ                             ▓▓▓▓▓▓▓▓▓▓▓▓  ▐▓
                                ╟▌  ▓▓▓▓▓▓▓▓▓▓▓▓▓▓L                           φ▓▓▓▓▓▓▓▓▓▓▓▓▓  ▐▓
                                "▓W   ▓▓▓▓▓▓▓▓▓▓▓▓▓                         g▓▓▓▓▓▓▓▓▓▓▓▓▓`  æ▓╜
                                   ▓@   ▀▓▓▓▓▓▓▓▓▓▓▓                      æ▓▓▓▓▓▓▓▓▓▓▓▓▓`  g▓`
                                     ▀▓,  ╙▓▓▓▓▓▓▓▓▓▓╖                  ╔▓▓▓▓▓▓▓▓▓▓▓▓▀  ,φ▓
                                       ╙▓╖  ╙▓▓▓▓▓▓▓▓▓▓▓╖,           ╓@▓▓▓▓▓▓▓▓▓▓▓▓╝  ,▓▀
                                         ╙▓w  ╙▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓╜  ╓▓╩
                                           "▓W   ▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓`  æ▓"
                                              ▓@   ▀▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓   g▓`
                                                ▀▓,                          ,φ▓
                                                  ╙▓ÑÑÑÑÑÑÑÑÑÑÑÑÑÑÑÑÑÑÑÑÑÑÑÑ▓▀
                                                  
                                                  
                         /$$   /$$                                        /$$                                                                         /$$                       /$$                              /$$ /$$       /$$                     /$$
                        | $$  | $$                                       |__/                                                                        | $$                      |__/                             | $$|__/      | $$                    | $$
                        | $$  | $$  /$$$$$$$ /$$   /$$ /$$$$$$   /$$$$$$  /$$  /$$$$$$         /$$$$$$  /$$   /$$        /$$$$$$$  /$$$$$$  /$$$$$$$ | $$$$$$$   /$$$$$$        /$$ /$$$$$$$  /$$    /$$/$$$$$$ | $$ /$$  /$$$$$$$  /$$$$$$   /$$$$$$$| $$
                        | $$  | $$ /$$_____/| $$  | $$|____  $$ /$$__  $$| $$ /$$__  $$       /$$__  $$| $$  | $$       /$$_____/ /$$__  $$| $$__  $$| $$__  $$ |____  $$      | $$| $$__  $$|  $$  /$$/____  $$| $$| $$ /$$__  $$ /$$__  $$ /$$_____/| $$
                        | $$  | $$|  $$$$$$ | $$  | $$ /$$$$$$$| $$  \\__/| $$| $$  \\ $$      | $$  \\ $$| $$  | $$      |  $$$$$$ | $$$$$$$$| $$  \\ $$| $$  \\ $$  /$$$$$$$      | $$| $$  \\ $$ \\  $$/$$/ /$$$$$$$| $$| $$| $$  | $$| $$  \\ $$|  $$$$$$ |__/
                        | $$  | $$ \\____  $$| $$  | $$/$$__  $$| $$      | $$| $$  | $$      | $$  | $$| $$  | $$       \\____  $$| $$_____/| $$  | $$| $$  | $$ /$$__  $$      | $$| $$  | $$  \\  $$$/ /$$__  $$| $$| $$| $$  | $$| $$  | $$ \\____  $$   \s
                        |  $$$$$$/ /$$$$$$$/|  $$$$$$/  $$$$$$$| $$      | $$|  $$$$$$/      |  $$$$$$/|  $$$$$$/       /$$$$$$$/|  $$$$$$$| $$  | $$| $$  | $$|  $$$$$$$      | $$| $$  | $$   \\  $/ |  $$$$$$$| $$| $$|  $$$$$$$|  $$$$$$/ /$$$$$$$/ /$$
                         \\______/ |_______/  \\______/ \\_______/|__/      |__/ \\______/        \\______/  \\______/       |_______/  \\_______/|__/  |__/|__/  |__/ \\_______/      |__/|__/  |__/    \\_/   \\_______/|__/|__/ \\_______/ \\______/ |_______/ |__/
                                                                                                                                                                                                                                                         \s
                                                                                                                                                                                                                                                         \s
                                                                                                                                                                                                                                                         \s
                        """);
            } else {
                System.out.println("""
                                        ,▄█▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓█▄,        
                                     ╓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓█▀▀"`             "▀▀▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓█▄
                                   ▄█▓▓▓▓▓▓▓▓▓▓▓▓▀▀                          ╙▀█▓▓▓▓▓▓▓▓▓▓▓█▄
                                 ╓█▓▓▓▓▓▓▓▓▓▓█▀`                                 ▀█▓▓▓▓▓▓▓▓▓▓█▄
                                ▓▓▓▓▓▓▓▓▓▓▓▓`                                      `▀▓▓▓▓▓▓▓▓▓▓▓
                              ╓█▓▓▓▓▓▓▓▓▓▀                                            ▀▓▓▓▓▓▓▓▓▓▓▄
                             ╔▓▓▓▓▓▓▓▓▓█`                                               ▓▓▓▓▓▓▓▓▓▓▄
                            ╔▓▓▓▓▓▓▓▓▓▀                                                  ▀▓▓▓▓▓▓▓▓▓▌
                           ╒▓▓▓▓▓▓▓▓▓▀                                        ▄██▄        ╙▓▓▓▓▓▓▓▓▓▌
                           █▓▓▓▓▓▓▓▓▌                                      ,▄▓▓▓▓▓▓▄       ▐▓▓▓▓▓▓▓▓▓
                          ▐▓▓▓▓▓▓▓▓▓                                     ╓▓▓▓▓▓▓▓▓▓▓▓▓      ▓▓▓▓▓▓▓▓▓▌
                          ▓▓▓▓▓▓▓▓▓                                    ▄▓▓▓▓▓▓▓▓▓▓▓▓▀        ▓▓▓▓▓▓▓▓▓
                         j▓▓▓▓▓▓▓▓▓                                  ▄█▓▓▓▓▓▓▓▓▓▓█▀          ▓▓▓▓▓▓▓▓▓L
                         ▐▓▓▓▓▓▓▓▓▌           ╓▓█▄                 ▄▓▓▓▓▓▓▓▓▓▓▓█"            ▐▓▓▓▓▓▓▓▓▌
                         ▐▓▓▓▓▓▓▓▓▌         ▄█▓▓▓▓█▄            ,▓▓▓▓▓▓▓▓▓▓▓▓▀"              ▐▓▓▓▓▓▓▓▓▌
                         ▐▓▓▓▓▓▓▓▓▓       ▄▓▓▓▓▓▓▓▓▓▓▄        ╓▓▓▓▓▓▓▓▓▓▓▓▓▀                 ▐▓▓▓▓▓▓▓▓▌
                          ▓▓▓▓▓▓▓▓▓        ▀▓▓▓▓▓▓▓▓▓▓▓▄,   ▄█▓▓▓▓▓▓▓▓▓▓▓▀                   ▓▓▓▓▓▓▓▓▓M
                          ▓▓▓▓▓▓▓▓▓▌         ▀▓▓▓▓▓▓▓▓▓▓▓▓▄█▓▓▓▓▓▓▓▓▓▓█╜                    ╒▓▓▓▓▓▓▓▓▓
                          ▐▓▓▓▓▓▓▓▓▓           ▀▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓`                      █▓▓▓▓▓▓▓▓▌
                           ▓▓▓▓▓▓▓▓▓█            ▀█▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▀                        ▓▓▓▓▓▓▓▓▓█
                            █▓▓▓▓▓▓▓▓█             ╙█▓▓▓▓▓▓▓▓▓▓▓▀                         ▓▓▓▓▓▓▓▓▓▓
                             ▓▓▓▓▓▓▓▓▓█,             ╙▓▓▓▓▓▓▓█▀                         ,▓▓▓▓▓▓▓▓▓▓`
                              █▓▓▓▓▓▓▓▓▓▄              `▀▓▓▓`                          ▄▓▓▓▓▓▓▓▓▓▓`
                               ▀▓▓▓▓▓▓▓▓▓▓▄                                          ▄█▓▓▓▓▓▓▓▓▓▓
                                ╙▓▓▓▓▓▓▓▓▓▓▓▄,                                    ,▄█▓▓▓▓▓▓▓▓▓▓▀
                                  ▀▓▓▓▓▓▓▓▓▓▓▓█▄,                              ,▄█▓▓▓▓▓▓▓▓▓▓▓▀
                                    ▀▓▓▓▓▓▓▓▓▓▓▓▓▓▓▄╖                      ╓▄▓▓▓▓▓▓▓▓▓▓▓▓▓▓▀
                                      ▀▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓█▓▄▄▄╖,,,,,,╓▄▄▄▓█▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓█▀
                                         ▀█▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓█▀
                                         
                          /$$$$$$                                                                                                     /$$   /$$     /$$       /$$           /$$         /$$$ \s
                         /$$__  $$                                                                                                   |__/  | $$    |__/      | $$          | $$        |_  $$\s
                        | $$  \\ $$  /$$$$$$$  /$$$$$$   /$$$$$$$ /$$$$$$$  /$$$$$$         /$$$$$$   /$$$$$$   /$$$$$$  /$$$$$$/$$$$  /$$ /$$$$$$   /$$  /$$$$$$$  /$$$$$$ | $$       /$$\\  $$
                        | $$$$$$$$ /$$_____/ /$$__  $$ /$$_____//$$_____/ /$$__  $$       /$$__  $$ /$$__  $$ /$$__  $$| $$_  $$_  $$| $$|_  $$_/  | $$ /$$__  $$ /$$__  $$| $$      |__/ | $$
                        | $$__  $$| $$      | $$$$$$$$|  $$$$$$|  $$$$$$ | $$  \\ $$      | $$  \\ $$| $$$$$$$$| $$  \\__/| $$ \\ $$ \\ $$| $$  | $$    | $$| $$  | $$| $$  \\ $$|__/           | $$
                        | $$  | $$| $$      | $$_____/ \\____  $$\\____  $$| $$  | $$      | $$  | $$| $$_____/| $$      | $$ | $$ | $$| $$  | $$ /$$| $$| $$  | $$| $$  | $$           /$$ /$$/
                        | $$  | $$|  $$$$$$$|  $$$$$$$ /$$$$$$$//$$$$$$$/|  $$$$$$/      | $$$$$$$/|  $$$$$$$| $$      | $$ | $$ | $$| $$  |  $$$$/| $$|  $$$$$$$|  $$$$$$/ /$$      |__/$$$/\s
                        |__/  |__/ \\_______/ \\_______/|_______/|_______/  \\______/       | $$____/  \\_______/|__/      |__/ |__/ |__/|__/   \\___/  |__/ \\_______/ \\______/ |__/        |___/ \s
                                                                                         | $$                                                                                                \s
                                                                                         | $$                                                                                                \s
                                                                                         |__/                                                                                                \s                 
                        """);
                computador.gerarTextoInicio();

                System.out.println("""
                        #$-------------------------------------------------------$#                       
                        #            Deseja cadastrar a máquina atual?            #
                        #         1 - Sim, quero cadastrar minha máquina.         #
                        #         2 - Não, obrigado.                              #
                        #$-------------------------------------------------------$#
                        """);
                Integer opcao = entrada.nextInt();

                if(opcao.equals(2)){
                    System.out.println("""
                             /$$$$$$$$        /$$                           /$$       /$$           /$$$ \s
                            |__  $$__/       | $$                          | $$      | $$          |_  $$\s
                               | $$  /$$$$$$$| $$$$$$$   /$$$$$$  /$$   /$$| $$      | $$ /$$        \\  $$
                               | $$ /$$_____/| $$__  $$ |____  $$| $$  | $$| $$      |__/|__/         | $$
                               | $$| $$      | $$  \\ $$  /$$$$$$$| $$  | $$|__/       /$$             | $$
                               | $$| $$      | $$  | $$ /$$__  $$| $$  | $$          | $$ /$$         /$$/
                               | $$|  $$$$$$$| $$  | $$|  $$$$$$$|  $$$$$$/ /$$      | $$|__/       /$$$/\s
                               |__/ \\_______/|__/  |__/ \\_______/ \\______/ |__/      |__/          |___/ \s
                                                                                                         \s
                                                                                                         \s
                                                                                                         \s
                            """);

                    break;

                } else {
                    System.out.println("Defina um intervalo de captura em milisegundos: ");
                    Long temp = entrada.nextLong();
                    TEMPO = (temp);
                }

                ComputadorDAO.cadastrarComputador(computador);
                ComputadorDAO.pegarIdComputador(computador);
                StatusPcDAO.pegarIdCaptura(idCaptura);
                StatusPcDAO.exibirInformacoesMaquina(nomeProcessador, sistemaOperacional, memoriaTotal, discoTotal, qtdDicos);

                Integer pontosMontagem = disco.getVolumes().size();

                Timer timer = new Timer();
                TimerTask tarefa = new TimerTask() {
                    @Override
                    public void run() {
                        try {
                            LocalDateTime data = LocalDateTime.now();
                            dtHoraCaptura.setDtHoraCaptura(String.valueOf(data));

                            Long memoriaEmUso = memoria.getEmUso();
                            memoriaUso.setMemoriaUso(memoriaEmUso);

                            Double processadorEmUso = processador.getUso();
                            processadorUso.setProcessadorEmUso(processadorEmUso);

                            Long discoEmUso = disco.getVolumes().get(0).getDisponivel();
                            discoDisponivel.setDiscoDisponivel(discoEmUso);

                            StatusPcDAO.cadastrarCapturas(memoriaUso, processadorUso, discoDisponivel, dtHoraCaptura, computador);

                            if (disco.getVolumes().size() > pontosMontagem){
                                System.out.println("ATENÇÃO!\nDISCO DESCONHECIDO CONECTADO ");
                            } else {
                                System.out.println("QUANTIDADE DE DISCOS ESTÁ DE ACORDO :)");
                            }


                        } catch (Exception e ){
                            e.printStackTrace();
                        }
                    }
                };
                timer.scheduleAtFixedRate(tarefa, TEMPO, TEMPO);
                autenticado = true;


                ProgramScanner programScanner = new ProgramScanner();

                System.out.println("COMEÇOU O PROCESSO DE VERIFICAÇÃO DE ARQUIVOS E PASTAS PROIBIDOS");

                try {
                    programScanner.scanForBlacklistedApps();
                    // Se chegou aqui, nenhum programa proibido foi encontrado
                    System.out.println("A máquina está segura para uso.");
                } catch (ProgramScanner.ProgramProibidoEncontradoException e) {
                    System.out.println(e.getMessage());

                    LocalDateTime data = LocalDateTime.now();
                    alerta.setDtHoraAlerta(String.valueOf(data));
                    alerta.setDescricao("Arquivo suspeito encontrado");
                    alerta.setCaminhoAqrquivo(programScanner.getAbsoluteFilePath());
                    AlertaDAO.cadastrarAlerta(alerta, computador);

                    System.out.println("CADASTROU O ALERTA DE ARQUIVO OU PASTA PROIBIDA");
                }

            }
        } while(!autenticado);

        // Caminho da raiz do disco (pode variar dependendo do sistema operacional)

    }
}

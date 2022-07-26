package PiedraPapelTijeras;

import java.util.Scanner;

public class Juego {
  private static final String EXPLICACION = "\n----EXPLICACION----\n" +
      "Piedra gana a Tijeras\n" +
      "Papel gana a Piedra\n" +
      "Tijeras gana Papel";
  private static final byte PUNTOS_MAXIMOS = 3;
  private static final String EL_JUEGO_A_EMPEZADO = "-----EL JUEGO HA EMPEZADO-----";
  private static final String TIRA_JUGADOR = "P para piedra, L para papel, T para tijera\n";

  private static final byte AVISO_TIRAR= 2;
  public static void main(String[] args) {
    explicacionJuego();
    pulsaParaContinuar();
    boolean victoria = false;
    boolean finish= false;
    byte puntosBot = 0;
    byte puntosJugador = 0;
    char bot;
    char jugador;
    System.out.println(EL_JUEGO_A_EMPEZADO);
    do {
      jugador = tiradaDelJugador();
      bot = tiradaDelBot();
      mostrarJugada(jugador, bot);
      byte rondaGanada = decidirGanador(jugador,bot);
      if(rondaGanada == 1){
        puntosJugador++;
      }else if(rondaGanada==2){
        puntosBot++;
      } else {
        System.out.println("\tEMPATE");
      }
      mostrarMarcador(puntosJugador, puntosBot);
      if(puntosJugador==PUNTOS_MAXIMOS||puntosBot==PUNTOS_MAXIMOS){
        finish = true;
        victoria = puntosJugador > puntosBot;
      }
    } while (!finish);
    if(victoria){
      System.out.println("Has ganado!!");
    }else{
      System.out.println("Has perdido");
    }
  }

  private static void mostrarMarcador(byte puntosJugador, byte puntosBot) {
    if(puntosJugador<puntosBot){
      System.out.println("(Bot): "+puntosBot+"/"+puntosJugador+": (Jugador)");
    } else if (puntosJugador > puntosBot) {
      System.out.println("(Jugador): "+puntosJugador+"/"+puntosBot+" :(Bot)");
    } else {
      System.out.println("(Jugador): " + puntosJugador + "/" + puntosBot + " :(Bot)");
    }
    System.out.println();
  }

  private static byte decidirGanador(char jugador, char bot) {
    byte jugada;
    if (jugador == bot) {
      jugada = 0; //EMPATE
    }
    else if ((jugador == 'P' && bot == 'T') || (jugador == 'L' && bot == 'P') || (jugador == 'T' && bot == 'L')) {
      jugada = 1;//JUGADOR GANA
    }
    else {
      jugada = 2; //BOT GANA
    }
    return jugada;
  }

  private static void mostrarJugada(char jugador, char bot) {
    System.out.println("(Tú): "+jugador+" / "+bot+" :(Bot)");
  }

  private static char tiradaDelJugador() {
    System.out.println(TIRA_JUGADOR);
    Scanner ent = new Scanner(System.in);
    char tirada = '?';
    byte intentos = 1;
    do {
      System.out.print("Tira:");
      tirada = ent.nextLine().charAt(0);
      if (intentos > AVISO_TIRAR) {
        System.err.println("Tienes que tirar P(Piedra), L(PAPEL) o T(TIJERAS)...");
      }
      tirada = Character.toUpperCase(tirada);
      intentos++;
    } while (tirada != 'P'&& tirada != 'L' && tirada != 'T');
    System.out.println();
    return tirada;
  }

  private static char tiradaDelBot() {
    double r = 1 + Math.random() * 3;
    int random = (int) r;
    char tirada;
    switch (random) {
      case 1:
        tirada = 'P';
        break;
      case 2:
        tirada = 'L';
        break;
      case 3:
        tirada = 'T';
        break;
      default:
        tirada = '?';
        break;
    }
    return tirada;
  }

  private static void pulsaParaContinuar() {
    System.out.println();
    System.out.println("Pulse cualquier tecla para continuar...");
    Scanner ent = new Scanner(System.in);
    ent.nextLine();
  }

  private static void explicacionJuego() {
    System.out.println(EXPLICACION);
  }
}

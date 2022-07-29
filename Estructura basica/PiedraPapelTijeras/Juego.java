package PiedraPapelTijeras;

import java.util.Scanner;

public class Juego {
  private static final String EXPLICACION = "\n----EXPLICACION----\n" +
      "Piedra gana a Tijeras\n" +
      "Papel gana a Piedra\n" +
      "Tijeras gana Papel";
  private static final byte PUNTOS_MAXIMOS = 3;
  private static final String EL_JUEGO_A_EMPEZADO = "-----EL JUEGO HA EMPEZADO-----";
  private static final String TIRA_JUGADOR = "P para piedra, L para papel, T para tijera o S para SALIR\n";
  private static final char PIEDRA = 'P';
  private static final char PAPEL = 'L';
  private static final char TIJERA = 'T';
  private static final char SALIR = 'S';
  private static final byte EMPATE = 0;
  private static final byte GANA_JUGADOR = 1;
  private static final byte GANA_BOT = 2;
  private static final char[] JUGADAS = {PIEDRA,PAPEL,TIJERA,SALIR};

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
      if (jugador == SALIR) {
        finish = true;
      }
      else if(bot == SALIR){
        finish = true;
      }
      else {
        mostrarJugada(jugador, bot);
        byte rondaGanada = decidirGanador(jugador, bot);
        if (rondaGanada == GANA_JUGADOR) {
          puntosJugador++;
        } else if (rondaGanada == GANA_BOT) {
          puntosBot++;
        } else {
          System.out.println("\tEMPATE");
        }
        mostrarMarcador(puntosJugador, puntosBot);
        if (puntosJugador == PUNTOS_MAXIMOS || puntosBot == PUNTOS_MAXIMOS) {
          finish = true;
          victoria = puntosJugador > puntosBot;
        }
      }

    } while (!finish);
    if(victoria){
      System.out.println("Has ganado!!");
    } else if (jugador == SALIR) {
      System.out.println("Te has rendido...");
    }else if(bot == SALIR){
      System.out.println("El BOT se ha rendido XDD");
    }
    else {
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
      jugada = EMPATE; //EMPATE
    }
    else if ((jugador == PIEDRA && bot == TIJERA) || (jugador == PAPEL && bot == PIEDRA) || (jugador == TIJERA && bot == PAPEL)) {
      jugada = GANA_JUGADOR;//JUGADOR GANA
    }
    else {
      jugada = GANA_BOT; //BOT GANA
    }
    return jugada;
  }

  private static void mostrarJugada(char player, char ia) {
    String jugador = charToString(player);
    String bot = charToString(ia);
    System.out.println("(Tú): "+jugador+" / "+bot+" :(Bot)");
  }

  private static String charToString(char player) {
    String aux = null;
    if(player == PIEDRA){
      aux = "PIEDRA";
    }else if(player == PAPEL){
      aux = "PAPEL";
    } else if (player == TIJERA) {
      aux = "TIJERA";
    }
    return aux;
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
        System.err.println("Tienes que tirar P(Piedra), L(PAPEL) , T(TIJERAS) o S(SALIR)...");
      }
      tirada = Character.toUpperCase(tirada);
      intentos++;
    } while (tirada != PIEDRA && tirada != PAPEL && tirada != TIJERA && tirada != SALIR);
    System.out.println();
    return tirada;
  }

  private static char tiradaDelBot() {
    double r = 1 + Math.random() * JUGADAS.length ;
    int random = (int) r;
    char tirada;
    switch (random) {
      case 1:
        tirada = PIEDRA;
        break;
      case 2:
        tirada = PAPEL;
        break;
      case 3:
        tirada = TIJERA;
        break;
      default:
        tirada = SALIR;
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

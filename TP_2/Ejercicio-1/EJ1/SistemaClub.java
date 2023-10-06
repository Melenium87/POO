package EJ1;

import java.util.ArrayList;

public class SistemaClub {
    private ArrayList<Socio> socios;
    private Suscripcion suscripcionBasica;
    private Suscripcion suscripcionIntermedia;
    private Suscripcion suscripcionDestacada;

    private SistemaClub() {
        suscripcionBasica = new Suscripcion(Suscripcion.Nivel.BASICA, 100);
        suscripcionIntermedia = new Suscripcion(Suscripcion.Nivel.INTERMEDIA, 200);
        suscripcionDestacada = new Suscripcion(Suscripcion.Nivel.DESTACADA, 300);
    }
    public void agregarSocio(String nombre, String apellido, String dni, String direccion,
                             String email, String suscripcion) {
        Suscripcion.Nivel nivelSuscripcion = Suscripcion.Nivel.valueOf(suscripcion.toUpperCase());
        Socio nuevoSocio = new Socio(nombre, apellido, dni, direccion, email, nivelSuscripcion);
        socios.add(nuevoSocio);
    }
    public void reporteMensual(int mes) {
        System.out.println("--- REPORTE MENSUAL mes %d ---");
        for (Socio socio : socios) {
            int mesInscripcion = socio.getFechaInscripcion().getMonthValue();
            if (mesInscripcion == mes) {

            }
        }
    }
}

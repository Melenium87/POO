package EJ1;

import java.time.LocalDate;

public class Socio {
    private String nombre;
    private String apellido;
    private String dni;
    private String direccion;
    private String email;
    private Suscripcion.Nivel suscripcion;
    private LocalDate fechaInscripcion;

    public Socio(String nombre, String apellido, String dni, String direccion,
                 String email, Suscripcion.Nivel suscripcion) {
        setNombre(nombre);
        setApellido(apellido);
        setDni(dni);
        setDireccion(direccion);
        setEmail(email);
        setSuscripcion(suscripcion);
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getNombre() {
        return nombre;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public String getApellido() {
        return apellido;
    }
    public void setDni(String dni) {
        this.dni = dni;
    }
    public String getDni() {
        return dni;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public String getDireccion() {
        return direccion;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getEmail() {
        return email;
    }

    public void setSuscripcion(Suscripcion.Nivel suscripcion) {
        this.suscripcion = suscripcion;
    }

    public Suscripcion.Nivel getSuscripcion() {
        return suscripcion;
    }

    public void setFechaInscripcion(LocalDate fechaInscripcion) {
        this.fechaInscripcion = fechaInscripcion;
    }
    public LocalDate getFechaInscripcion() {
        return fechaInscripcion;
    }
}

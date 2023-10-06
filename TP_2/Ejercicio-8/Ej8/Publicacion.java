package Ej8;


public class Publicacion {
    private String nombre;
    private String editor;
    private String telefonoProveedor;

    public Publicacion(String nombre, String editor, String telefonoProveedor) {
        this.nombre = nombre;
        this.editor = editor;
        this.telefonoProveedor = telefonoProveedor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEditor() {
        return editor;
    }

    public void setEditor(String editor) {
        this.editor = editor;
    }

    public String getTelefonoProveedor() {
        return telefonoProveedor;
    }

    public void setTelefonoProveedor(String telefonoProveedor) {
        this.telefonoProveedor = telefonoProveedor;
    }
}

package EstructuraContraseña;


public class Contraseña {
    private String password;
    private int longitud=8;

    public Contraseña()
    {
        generarIntentoDeContra();
    }
    public Contraseña(int longitud)
    {
        if (longitud>=7){
            this.longitud=longitud;
            generarIntentoDeContra();
        }
        else{
            System.out.println("La longitud debe ser mayor o igual a 7\nSe seguira el proceso con 8 caracteres");
            generarIntentoDeContra();
        }
    }

    private void generarIntentoDeContraRecursivo(int intento)
    {
        String cadena="ABCDEFGHIJKLMNÑOPQRSTUVWXYZabcdefghijklmnñopqrstuvwxyz1234567890";
        StringBuilder contra=new StringBuilder();
        intento++;
        for (int i=0;i<longitud;i++)
        {
            double aleatorio= Math.random()*cadena.length();
            int posicion= (int)aleatorio;
            char letra= cadena.charAt(posicion);
            contra.append(letra);
        }
        password=contra.toString();
        if(!verificarPassword())
        {
            System.out.println("Intento: "+intento+ "  Password: "+password+" -Debil");
            while(!verificarPassword()){

                generarIntentoDeContraRecursivo(intento);

            }
        }
        else{
            System.out.println("Password: "+password+" -Fuerte");
        }
    }
    public void generarIntentoDeContra()
    {
        int i=0;
        generarIntentoDeContraRecursivo(i);
    }
    public void cambiarLongitud(int longitud)
    {
        if (longitud>=7){
            this.longitud=longitud;
            generarIntentoDeContra();
        }
        else{
            System.out.println("La longitud debe ser mayor o igual a 7");
        }
    }

    public boolean verificarPassword()
    {

        String letras="abcdefghijklmnñopqrstuvwxyz";
        int mayus=0;
        int min=0;
        int num=0;
        for(Character c:password.toCharArray())
        {
            if(Character.isDigit(c))
            {
                num++;
            }
            else {
                for (Character l : letras.toCharArray()) {
                    if (c == l) {
                        min++;
                    }
                    if (c == Character.toUpperCase(l)) {
                        mayus++;
                    }

                }
            }
        }
        if (mayus>2&&min>1&&num>1){

            return true;
        }
        return false;
    }

    public void generarPassword()
    {
        String cadena="ABCDEFGHIJKLMNÑOPQRSTUVWXYZabcdefghijklmnñopqrstuvwxyz1234567890";
        StringBuilder contra=new StringBuilder();
        for (int i=0;i<4;i++)
        {
            double aleatorio= Math.random()*27;
            int posicion= (int)aleatorio;
            char letra= cadena.charAt(posicion);
            contra.append(letra);
        }
        for (int i=0;i<longitud-5;i++)
        {
            double aleatorio= Math.random()*27;
            int posicion= (int)aleatorio;
            char letra= cadena.charAt(posicion+27);
            contra.append(letra);
        }
        for (int i=0;i<3;i++)
        {
            double aleatorio= Math.random()*10;
            int posicion= (int)aleatorio;
            char letra= cadena.charAt(posicion+54);
            contra.append(letra);
        }


        password=contra.toString();
        if (!verificarPassword()){

            System.out.println("Password: "+password+" -Debil");
        }
        else {
            System.out.println("Password: "+password+" -Fuerte");
        }
    }
}

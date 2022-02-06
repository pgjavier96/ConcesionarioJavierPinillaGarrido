package es.pinillagarrido.coches;

import android.os.Parcel;
import android.os.Parcelable;


public class Car implements Parcelable {
    private int ref;
    private String combustible;
    private int km;
    private String cambio;
    private int potencia;
    private int npuertas;
    private String color;
    private int ano;
    private String titulo;
    private String descripcion;
    private String url;
    private String imagenes;
    private int precio;
    private String localizacion;

    public Car() {
    }

    public Car(int ref, String combustible, int km, String cambio, int potencia, int npuertas, String color, int ano, String titulo, String descripcion, String url, String imagenes, int precio, String localizacion) {
        this.ref = ref;
        this.combustible = combustible;
        this.km = km;
        this.cambio = cambio;
        this.potencia = potencia;
        this.npuertas = npuertas;
        this.color = color;
        this.ano = ano;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.url = url;
        this.imagenes = imagenes;
        this.precio = precio;
        this.localizacion = localizacion;
    }

    protected Car(Parcel in) {
        ref = in.readInt();
        combustible = in.readString();
        km = in.readInt();
        cambio = in.readString();
        potencia = in.readInt();
        npuertas = in.readInt();
        color = in.readString();
        ano = in.readInt();
        titulo = in.readString();
        descripcion = in.readString();
        url = in.readString();
        imagenes = in.readString();
        precio = in.readInt();
        localizacion = in.readString();
    }

    public static final Creator<Car> CREATOR = new Creator<Car>() {
        @Override
        public Car createFromParcel(Parcel in) {
            return new Car(in);
        }

        @Override
        public Car[] newArray(int size) {
            return new Car[size];
        }
    };

    public int getRef() {
        return ref;
    }

    public void setRef(int ref) {
        this.ref = ref;
    }

    public String getCombustible() {
        return combustible;
    }

    public void setCombustible(String combustible) {
        this.combustible = combustible;
    }

    public int getKm() {
        return km;
    }

    public void setKm(int km) {
        this.km = km;
    }

    public String getCambio() {
        return cambio;
    }

    public void setCambio(String cambio) {
        this.cambio = cambio;
    }

    public int getPotencia() {
        return potencia;
    }

    public void setPotencia(int potencia) {
        this.potencia = potencia;
    }

    public int getNpuertas() {
        return npuertas;
    }

    public void setNpuertas(int npuertas) {
        this.npuertas = npuertas;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getImagenes() {
        return imagenes;
    }

    public void setImagenes(String imagenes) {
        this.imagenes = imagenes;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public String getLocalizacion() {
        return localizacion;
    }

    public void setLocalizacion(String localizacion) {
        this.localizacion = localizacion;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(ref);
        dest.writeString(combustible);
        dest.writeInt(km);
        dest.writeString(cambio);
        dest.writeInt(potencia);
        dest.writeInt(npuertas);
        dest.writeString(color);
        dest.writeInt(ano);
        dest.writeString(titulo);
        dest.writeString(descripcion);
        dest.writeString(url);
        dest.writeString(imagenes);
        dest.writeInt(precio);
        dest.writeString(localizacion);
    }


}

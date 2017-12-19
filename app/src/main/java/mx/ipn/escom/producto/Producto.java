package mx.ipn.escom.producto;

import android.os.Parcel;
import android.os.Parcelable;

public class Producto implements Parcelable{
    private String idDispositivo;
    private String nb_dispositivo;
    private String marca;
    private int idInventario;

    public Producto(String idDis, String nombre, String marc, int idInv){
        idDispositivo = idDis;
        nb_dispositivo = nombre;
        marca = marc;
        idInventario = idInv;
    }

    public String getIdDispositivo(){
        return idDispositivo;
    }

    public String getNb_dispositivo(){
        return nb_dispositivo;
    }

    public String getMarca(){
        return marca;
    }

    public int getIdInventario(){
        return idInventario;
    }

    protected Producto(Parcel in) {
        super();
        readFromParcel(in);
    }

    public static final Creator<Producto> CREATOR = new Creator<Producto>() {
        @Override
        public Producto createFromParcel(Parcel in) {
            return new Producto(in);
        }

        @Override
        public Producto[] newArray(int size) {
            return new Producto[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    public void readFromParcel(Parcel in) {
        idDispositivo = in.readString();
        nb_dispositivo = in.readString();
        marca = in.readString();
        idInventario = in.readInt();
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(idDispositivo);
        parcel.writeString(nb_dispositivo);
        parcel.writeString(marca);
        parcel.writeInt(idInventario);
    }

    @Override
    public String toString(){
        return idDispositivo+" "+nb_dispositivo+" "+marca+" - "+idInventario;
    }
}

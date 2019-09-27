package br.com.digitalhouse.revisaoactivitys.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Animal implements Parcelable {
    private int image;
    private String nome;

    public Animal(int image, String nome) {
        this.image = image;
        this.nome = nome;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    protected Animal(Parcel in) {
        image = in.readInt();
        nome = in.readString();
    }

    public static final Creator<Animal> CREATOR = new Creator<Animal>() {
        @Override
        public Animal createFromParcel(Parcel in) {
            return new Animal(in);
        }

        @Override
        public Animal[] newArray(int size) {
            return new Animal[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(image);
        parcel.writeString(nome);
    }
}

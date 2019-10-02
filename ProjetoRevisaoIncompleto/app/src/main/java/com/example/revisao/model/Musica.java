package com.example.revisao.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

public class Musica implements Parcelable {

    private String nomecantor,nomemusica, letradamusica;

    public Musica(){

    }

    public Musica(String nomecantor, String nomemusica, String letradamusica) {
        this.nomecantor = nomecantor;
        this.nomemusica = nomemusica;
        this.letradamusica = letradamusica;
    }

    protected Musica(Parcel in) {
        nomecantor = in.readString();
        nomemusica = in.readString();
        letradamusica = in.readString();
    }

    public static final Creator<Musica> CREATOR = new Creator<Musica>() {
        @Override
        public Musica createFromParcel(Parcel in) {
            return new Musica(in);
        }

        @Override
        public Musica[] newArray(int size) {
            return new Musica[size];
        }
    };

    public String getNomecantor() {
        return nomecantor;
    }

    public void setNomecantor(String nomecantor) {
        this.nomecantor = nomecantor;
    }

    public String getNomemusica() {
        return nomemusica;
    }

    public void setNomemusica(String nomemusica) {
        this.nomemusica = nomemusica;
    }

    public String getLetradamusica() {
        return letradamusica;
    }

    public void setLetradamusica(String letradamusica) {
        this.letradamusica = letradamusica;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nomecantor);
        dest.writeString(nomemusica);
        dest.writeString(letradamusica);
    }

    public List<Musica> retornarListaMusica() {
        ArrayList<Musica> listaMusica = new ArrayList();
        listaMusica.add(new Musica("Milionário e José Rico", "Boate Azul",
                "Doente de amor procurei remédio na vida noturna\n" +
                "Como uma flor da noite em uma boate aqui na zona sul\n" +
                "A dor do amor é com outro amor que a gente cura\n" +
                "Vim curar a dor deste mal de amor na boate azul\n" +
                "E quando a noite vai se agonizando no clarão da aurora\n" +
                "Os integrantes da vida noturna se foram dormir\n" +
                "E a dama da noite que estava comigo também foi embora\n" +
                "Fecharam-se as portas sozinho de novo tive que sair\n" +
                "Sair de que jeito, se nem sei o rumo para onde vou\n" +
                "Muito vagamente me lembro que estou\n" +
                "Em uma boate aqui na zona sul\n" +
                "Eu bebi demais e não consigo me lembrar se quer\n" +
                "Qual era o nome daquela mulher\n" +
                "A flor da noite na boate azul\n" +
                "E quando a noite vai se agonizando no clarão da aurora\n" +
                "Os integrantes da vida noturna se foram dormir\n" +
                "E a dama da noite que estava comigo também foi embora\n" +
                "Fecharam-se as portas sozinho de novo tive que sair\n" +
                "Sair de que jeito, se nem sei o rumo para onde vou\n" +
                "Muito vagamente me lembro que estou\n" +
                "Em uma boate aqui na zona sul\n" +
                "Eu bebi demais e não consigo me lembrar se quer\n" +
                "Qual era o nome daquela mulher\n" +
                "A flor da noite na boate azul"));
        listaMusica.add(new Musica("Chitãozinho e Xororó", "Evidências",
                "Quando eu digo que deixei de te amar\n" +
                "É porque eu te amo\n" +
                "Quando eu digo que não quero mais você\n" +
                "É porque eu te quero\n" +
                "Eu tenho medo de te dar meu coração\n" +
                "E confessar que eu estou em tuas mãos\n" +
                "Mas não posso imaginar\n" +
                "O que vai ser de mim\n" +
                "Se eu te perder um dia\n" +
                "Eu me afasto e me defendo de você\n" +
                "Mas depois me entrego\n" +
                "Faço tipo, falo coisas que eu não sou\n" +
                "Mas depois eu nego\n" +
                "Mas a verdade\n" +
                "É que eu sou louco por você\n" +
                "E tenho medo de pensar em te perder\n" +
                "Eu preciso aceitar que não dá mais\n" +
                "Pra separar as nossas vidas\n" +
                "E nessa loucura de dizer que não te quero\n" +
                "Vou negando as aparências\n" +
                "Disfarçando as evidências\n" +
                "Mas pra que viver fingindo\n" +
                "Se eu não posso enganar meu coração\n" +
                "Eu sei que te amo\n" +
                "Chega de mentiras\n" +
                "De negar o meu desejo\n" +
                "Eu te quero mais que tudo\n" +
                "Eu preciso do seu beijo\n" +
                "Eu entrego a minha vida\n" +
                "Pra você fazer o que quiser de mim\n" +
                "Só quero ouvir você dizer que sim\n" +
                "Diz que é verdade, que tem saudade\n" +
                "Que ainda você pensa muito em mim\n" +
                "Diz que é verdade, que tem saudade\n" +
                "Que ainda você quer viver pra mim"));
        listaMusica.add(new Musica("Zé Neto e Cristiano", "Largado as Traças",
                "Um, dois, três, vai\n" +
                "Meu orgulho caiu quando subiu o álcool\n" +
                "Aí deu ruim pra mim\n" +
                "E, pra piorar, 'tá tocando um modão\n" +
                "De arrastar o chifre no asfalto\n" +
                "'Tô tentando te esquecer\n" +
                "Mas meu coração não entende\n" +
                "De novo, eu fechando esse bar\n" +
                "Afogando a saudade num querosene\n" +
                "Vou beijando esse copo, abraçando as garrafas\n" +
                "Solidão é companheira nesse risca faca\n" +
                "Enquanto 'cê não volta, eu 'tô largado às traças\n" +
                "Maldito sentimento que nunca se acaba\n" +
                "Vou beijando esse copo, abraçando as garrafas\n" +
                "Solidão é companheira nesse risca faca\n" +
                "Enquanto 'cê não volta, eu 'tô largado às traças\n" +
                "Maldito sentimento que nunca se acaba\n" +
                "Ô ô ô, ô ô ô\n" +
                "A falta de você, bebida não ameniza\n" +
                "Ô ô ô, ô ô ô\n" +
                "Ô ô ô, ô ô ô\n" +
                "A falta de você, bebida não ameniza\n" +
                "Ô ô ô, ô ô ô\n" +
                "'Tô tentando apagar fogo com gasolina\n" +
                "Ô ô ô, ô ô ô\n" +
                "A falta de você, bebida não ameniza\n" +
                "Ô ô ô, ô ô ô\n" +
                "'Tô tentando apagar fogo com gasolina"));
        listaMusica.add(new Musica("Gusttavo Lima", "Cem Mil",
                "Não fale mais o meu nome\n" +
                "Não me telefone\n" +
                "Por favor, não pergunte por mim\n" +
                "Vê se me esquece e some\n" +
                "Se eu te ver de longe\n" +
                "Viro a cara, finjo que não vi\n" +
                "Mas eu não vou mentir\n" +
                "'Tá doendo lá no fundo\n" +
                "Sem você, eu não consigo mais dormir\n" +
                "Vamos fazer assim\n" +
                "Melhor não me procurar\n" +
                "Porque eu morro de medo de te perdoar\n" +
                "Eu 'to falando mal de você, iê\n" +
                "Que você nunca soube fazer, iê\n" +
                "Cem mil, com quem quiser, eu aposto\n" +
                "Se ela bater o dedo, eu volto\n" +
                "Eu 'to falando mal de você, iê\n" +
                "Que você nunca soube fazer, iê\n" +
                "Cem mil, com quem quiser, eu aposto\n" +
                "Se ela bater o dedo, eu volto\n" +
                "Ela não vale um real\n" +
                "Mas eu adoro\n" +
                "Eu 'to falando mal de você, iê\n" +
                "Que você nunca soube fazer, iê\n" +
                "Cem mil, com quem quiser, eu aposto\n" +
                "Se ela bater o dedo, eu volto\n" +
                "Eu 'to falando mal de você, iê\n" +
                "Que você nunca soube fazer, iê\n" +
                "Cem mil, com quem quiser, eu aposto\n" +
                "Se ela bater o dedo, eu volto\n" +
                "Eu 'to falando mal de você, iê\n" +
                "Que você nunca soube fazer, iê\n" +
                "Cem mil, com quem quiser, eu aposto\n" +
                "Se ela bater o dedo, eu volto\n" +
                "Ela não vale um real\n" +
                "Mas eu adoro"));
        listaMusica.add(new Musica("João Mineiro a Marciano", "A Bailarina",
                "Ela era quase criança nos sonhos bons de menina\n" +
                "Queria ser bem famosa, queria ser bailarina\n" +
                "E despediu-se bem nova, contra a vontade dos pais\n" +
                "E foi tentar a carreira, não retornou nunca mais\n" +
                "Para contar sua história, não preciso tanto\n" +
                "Ela foi sempre enganada e as coisas mudaram\n" +
                "No fim perdeu a carreira, tornou-se na vida\n" +
                "Uma famosa amante que todos amaram\n" +
                "A bailarina venceu e tem fama demais\n" +
                "Apenas é diferente o caminho porém\n" +
                "Ela não dança no palco, recebe um por vez\n" +
                "Naquele quarto bonito a plateia vem\n" +
                "De vez em quando ela chora lembra do sonho passado\n" +
                "Pois se soubesse de tudo ela não tinha tentado\n" +
                "Nesse bailado de agora é muito triste a canção\n" +
                "Abraça o fã que lhe paga, a fama foi ilusão"));

        return listaMusica;
    }
}

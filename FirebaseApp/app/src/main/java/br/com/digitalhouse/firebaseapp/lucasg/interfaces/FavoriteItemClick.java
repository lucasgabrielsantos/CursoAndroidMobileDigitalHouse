package br.com.digitalhouse.firebaseapp.lucasg.interfaces;

import br.com.digitalhouse.firebaseapp.lucasg.model.Result;

public interface FavoriteItemClick {

    void addFavoriteClickListener(Result result);
    void removeFavoriteClickListener(Result result);
}

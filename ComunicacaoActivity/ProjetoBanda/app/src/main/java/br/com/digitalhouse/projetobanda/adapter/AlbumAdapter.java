package br.com.digitalhouse.projetobanda.adapter;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import java.util.List;

import br.com.digitalhouse.projetobanda.model.Album;

public class AlbumAdapter extends FragmentStatePagerAdapter {


    public List<Album> albumList;

    public AlbumAdapter(FragmentManager fm, List<Album> albumList) {
        super(fm);
        this.albumList = albumList;

    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return albumList.get(position).getNome();
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return albumList.get(position).getFragment();
    }

    @Override
    public int getCount() {
        return albumList.size();
    }

}



package com.cuttingedge.PokeApp;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.cuttingedge.adapter2recycler.Adapter.ModularAdapter;
import com.cuttingedge.adapter2recycler.Modules.AdapterModule;
import com.cuttingedge.adapter2recycler.Modules.DragAndDropPlugin;
import com.cuttingedge.adapter2recycler.Modules.SwipePlugin;

/**
 * Created by Robbe Sneyders
 *
 * Module to handle behaviour of Pokemon item in the example app
 */
public abstract class PokemonModule<VH extends PokemonModule.PokemonViewHolder, P extends Pokemon>
        extends AdapterModule<PokemonModule.PokemonViewHolder, Pokemon>
        implements SwipePlugin<Pokemon>, DragAndDropPlugin {


    /*************************
     * AdapterModule methods *
     *************************/

    public PokemonModule(ModularAdapter adapter) {
        super(adapter);
    }

    @Override
    public PokemonViewHolder onCreateViewHolder(ViewGroup parent) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_row, parent, false);
        return new PokemonViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(PokemonViewHolder viewHolder, Pokemon pokemon) {
        viewHolder.vText.setText(pokemon.name);
        viewHolder.vIcon.setImageDrawable(pokemon.icon);
    }


    /*********************************
     * SwipePlugin methods *
     *********************************/

    @Override
    public int getSwipeDirs() {
        return ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT;
    }

    @Override
    public int getUndoDirs() {
        return ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT;
    }


    /*************************************
     * DragAndDropPlugin methods *
     *************************************/

    @Override
    public boolean keepDragInSection() {
        return true;
    }


    public static class PokemonViewHolder extends RecyclerView.ViewHolder {
        public ImageView vIcon;
        public TextView vText;

        public PokemonViewHolder(View view) {
            super(view);
            vText = (TextView) view.findViewById(R.id.textView);
            vIcon = (ImageView) view.findViewById(R.id.imageView);
        }
    }
}
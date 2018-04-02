package com.alberto.marvel.ui.characters.adapter;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.alberto.marvel.R;
import com.alberto.marvel.common.model.response.ResultResponse;
import com.bumptech.glide.Glide;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CharactersAdapter extends RecyclerView.Adapter<CharactersAdapter.MyViewHolder> {

    private List<ResultResponse> charactersList;
    private Context context;
    private OnItemClickListener onItemClickListener;

    public interface OnItemClickListener {
        void onItemClick(ResultResponse character);
    }

    public CharactersAdapter(List<ResultResponse> charactersList) {
        this.charactersList = charactersList;
    }

    @Override
    public CharactersAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.row_characters, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        ResultResponse character = charactersList.get(position);
        ImageView imageView = holder.ivCharacter;
        Glide.with(context)
                .load(character.getImageUrl())
                .centerCrop()
                .into(imageView);
        holder.tvTitle.setText(character.getName());
    }

    @Override
    public int getItemCount() {
        return charactersList.size();
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.ivCharacter)
        ImageView ivCharacter;
        @BindView(R.id.tvTitle)
        TextView tvTitle;

        public MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        @OnClick(R.id.rlCharacter)
        public void onClick() {
            int position = getAdapterPosition();
            if (position != RecyclerView.NO_POSITION) {
                ResultResponse character = charactersList.get(position);
                onItemClickListener.onItemClick(character);
            }
        }
    }
}

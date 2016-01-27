package com.alexjlockwood.activity.transitions;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import static com.alexjlockwood.activity.transitions.Constants.ALBUM_IMAGE_URLS;
import static com.alexjlockwood.activity.transitions.Constants.ALBUM_NAMES;

/**
 * Created by anderson.acs on 1/27/2016.
 */
public class CardAdapter extends RecyclerView.Adapter<CardAdapter.CardHolder> {

    private Context context;
    CallbackPicture callbackPicture;

    public CardAdapter(Context context, CallbackPicture callbackPicture) {
        this.context = context;
        this.callbackPicture = callbackPicture;
    }

    @Override
    public CardHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        return new CardHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.album_image_card, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(CardHolder holder, int position) {
        holder.bind(position);
    }

    @Override
    public int getItemCount() {
        return ALBUM_IMAGE_URLS.length;
    }

    public class CardHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private final ImageView mAlbumImage;
        private int mAlbumPosition;

        public CardHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            mAlbumImage = (ImageView) itemView.findViewById(R.id.main_card_album_image);
        }

        public void bind(int position) {
            Picasso.with(context).load(ALBUM_IMAGE_URLS[position]).into(mAlbumImage);
            mAlbumImage.setTransitionName(ALBUM_NAMES[position]);
            mAlbumImage.setTag(ALBUM_NAMES[position]);
            mAlbumPosition = position;
        }

        @Override
        public void onClick(View v) {
           callbackPicture.onClick(mAlbumImage, mAlbumPosition);
        }
    }

    public interface CallbackPicture{
        void onClick(ImageView imageView, int position);
    }
}
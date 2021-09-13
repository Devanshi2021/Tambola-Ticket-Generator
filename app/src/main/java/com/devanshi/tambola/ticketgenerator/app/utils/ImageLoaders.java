package com.devanshi.tambola.ticketgenerator.app.utils;


import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.devanshi.tambola.ticketgenerator.app.R;


import java.io.File;

/**
 * Image loader class which will use Glide to load images.
 */
public class ImageLoaders {


    public static void loadImage(final Context context, final ImageView imageView, final String imageUrl, int placeHolderRes) {
        if (placeHolderRes != R.drawable.bg_clothes) {
            placeHolderRes = R.drawable.bg_clothes;
        }

        Glide
                .with(context)
                .load(imageUrl)
                .centerCrop()
                .placeholder(placeHolderRes)
                .into(imageView);

    }

    public static void loadImage(final Context context, final ImageView imageView, final int resource, int placeHolderRes) {
        placeHolderRes = R.drawable.bg_clothes;

        Glide
                .with(context)
                .load(resource)
                .centerCrop()
                .placeholder(placeHolderRes)
                .into(imageView);

    }



    public static void loadImage(final Context context, final ImageView imageView, final File file, int placeHolderRes) {
        placeHolderRes = R.drawable.bg_clothes;

        Glide
                .with(context)
                .load(file)
                .centerCrop()
                .placeholder(placeHolderRes)
                .into(imageView);
    }
}

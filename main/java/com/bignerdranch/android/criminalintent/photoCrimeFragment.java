package com.bignerdranch.android.criminalintent;

import android.app.Dialog;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;

import static com.bignerdranch.android.criminalintent.PictureUtils.getScaledBitmap;

/**
 * Created by cody on 2/18/2018.
 */

public class photoCrimeFragment extends DialogFragment {

    private static final String ARG_IMAGE = "image";

    private ImageView mImageZoom;

    public static photoCrimeFragment  newInstance(String imageFile) {
        Bundle args = new Bundle();
        args.putSerializable(ARG_IMAGE, imageFile);

        photoCrimeFragment fragment = new photoCrimeFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        String imageFile = (String) getArguments().getSerializable(ARG_IMAGE);

        View v = LayoutInflater.from(getActivity()).inflate(R.layout.dialog_photo, null);

        Bitmap bitmap = getScaledBitmap(imageFile, getActivity());

        mImageZoom = (ImageView) v.findViewById(R.id.photo_view_dialog);
        mImageZoom.setImageBitmap(bitmap);

        return new AlertDialog.Builder(getActivity())
                .setView(v)
                .create();
    }
}

package com.yairn.mad.wicsproject0;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

public class ItemHolder extends RecyclerView.ViewHolder {

    ImageView imageView;
    TextView textView;
    Button button;

    public ItemHolder(View cardItemView) {
        super(cardItemView);

        imageView = cardItemView.findViewById(R.id.itemImageView);
        textView = cardItemView.findViewById(R.id.itemTextView);
        button = cardItemView.findViewById(R.id.itemButton);
    }

    public void setImage(final int resource) {
        Picasso.get().load(resource).fit().into(imageView);
    }

    public void setImage(final String url) {
        Picasso.get().load(url).fit().into(imageView);
    }

    public void setText(String text) {
        textView.setText(text);
    }

    public void setButtonOnClick(int position) {
        switch (position) {
            default:
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        onClickBrowser(v);
                    }
                });
        }
    }

    private void onClickMaps(View view) {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_APP_MAPS);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        try {
            view.getContext().getApplicationContext().startActivity(intent);
        } catch (Exception e) {
            Toast.makeText(view.getContext().getApplicationContext(),
                    "No Maps App Found.", Toast.LENGTH_LONG).show();
        }
    }

    private void onClickBrowser(View view) {
        String url = "https://www.cs.utexas.edu/~wics/";

        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(url));
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        try {
            view.getContext().getApplicationContext().startActivity(intent);
        } catch (Exception e) {
            Toast.makeText(view.getContext().getApplicationContext(),
                    "No Browser App Found.", Toast.LENGTH_LONG).show();
        }
    }
}


package com.alberto.marvel.ui.detail.wrapper;

import android.content.Context;
import android.support.annotation.Nullable;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.alberto.marvel.R;


public class DescriptionWrapper extends LinearLayout {

    private TextView title;
    private TextView description;

    public DescriptionWrapper(Context context) {
        super(context);
        init(context);
    }

    public DescriptionWrapper(Context context, @Nullable String description) {
        super(context);
        init(context);

        title.setText(context.getResources().getString(R.string.description));

        if (description != null && !description.isEmpty()) {
            this.description.setText(description);
        }
    }

    private void init(Context context) {
        inflate(context, R.layout.wrapper_description, this);
        title = (TextView) findViewById(R.id.tvTitleDescription);
        description = (TextView) findViewById(R.id.tvDescription);
    }
}

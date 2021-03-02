package com.tencent.mm.plugin.appbrand.page;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;

public class AppBrandActionMultipleHeaderView extends LinearLayout {
    private ImageView dKU;
    private String nnB;
    private String path;
    private int type;
    private String username;
    private TextView vr;

    public AppBrandActionMultipleHeaderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(134932);
        init(context);
        AppMethodBeat.o(134932);
    }

    @TargetApi(11)
    public AppBrandActionMultipleHeaderView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(134933);
        init(context);
        AppMethodBeat.o(134933);
    }

    private void init(Context context) {
        AppMethodBeat.i(134934);
        ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.gk, this);
        this.dKU = (ImageView) findViewById(R.id.ss);
        this.vr = (TextView) findViewById(R.id.st);
        AppMethodBeat.o(134934);
    }

    public int getType() {
        return this.type;
    }

    public String getH5Url() {
        return this.nnB;
    }

    public String getUsername() {
        return this.username;
    }

    public String getPath() {
        return this.path;
    }

    public ImageView getImageView() {
        return this.dKU;
    }

    public void setImageResource(int i2) {
        AppMethodBeat.i(134935);
        this.dKU.setImageResource(i2);
        AppMethodBeat.o(134935);
    }

    public void setImageDrawable(Drawable drawable) {
        AppMethodBeat.i(134936);
        this.dKU.setImageDrawable(drawable);
        AppMethodBeat.o(134936);
    }

    public void setTextViewText(String str) {
        AppMethodBeat.i(134937);
        this.vr.setText(str);
        AppMethodBeat.o(134937);
    }

    public void setTextViewTextColor(int i2) {
        AppMethodBeat.i(134938);
        this.vr.setTextColor(i2);
        AppMethodBeat.o(134938);
    }
}

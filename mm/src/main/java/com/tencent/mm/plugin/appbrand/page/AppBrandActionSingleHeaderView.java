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

public class AppBrandActionSingleHeaderView extends LinearLayout {
    private ImageView dKU;
    private TextView vr;

    public AppBrandActionSingleHeaderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(134940);
        init(context);
        AppMethodBeat.o(134940);
    }

    @TargetApi(11)
    public AppBrandActionSingleHeaderView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(134941);
        init(context);
        AppMethodBeat.o(134941);
    }

    private void init(Context context) {
        AppMethodBeat.i(134942);
        ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.gl, this);
        this.dKU = (ImageView) findViewById(R.id.sy);
        this.vr = (TextView) findViewById(R.id.sz);
        AppMethodBeat.o(134942);
    }

    public ImageView getImageView() {
        return this.dKU;
    }

    public void setImageResource(int i2) {
        AppMethodBeat.i(134943);
        this.dKU.setImageResource(i2);
        AppMethodBeat.o(134943);
    }

    public void setImageDrawable(Drawable drawable) {
        AppMethodBeat.i(134944);
        this.dKU.setImageDrawable(drawable);
        AppMethodBeat.o(134944);
    }

    public void setTextViewText(String str) {
        AppMethodBeat.i(134945);
        this.vr.setText(str);
        AppMethodBeat.o(134945);
    }

    public void setTextViewTextColor(int i2) {
        AppMethodBeat.i(134946);
        this.vr.setTextColor(i2);
        AppMethodBeat.o(134946);
    }
}

package com.tencent.mm.ui.matrix.recyclerview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;

public class JsonItemView extends LinearLayout {
    public static int Qnf = 12;
    private TextView Qng;
    private TextView Qnh;
    private ImageView Qni;
    private Context mContext;

    public JsonItemView(Context context) {
        this(context, null);
    }

    public JsonItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public JsonItemView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(38898);
        this.mContext = context;
        setOrientation(1);
        LayoutInflater.from(this.mContext).inflate(R.layout.axd, (ViewGroup) this, true);
        this.Qng = (TextView) findViewById(R.id.ixt);
        this.Qnh = (TextView) findViewById(R.id.iyc);
        this.Qni = (ImageView) findViewById(R.id.e4p);
        AppMethodBeat.o(38898);
    }

    public void setTextSize(float f2) {
    }

    public void setRightColor(int i2) {
        AppMethodBeat.i(38899);
        this.Qnh.setTextColor(i2);
        AppMethodBeat.o(38899);
    }

    public final void gWX() {
        AppMethodBeat.i(38900);
        this.Qng.setVisibility(8);
        AppMethodBeat.o(38900);
    }

    public final void au(CharSequence charSequence) {
        AppMethodBeat.i(38901);
        this.Qng.setVisibility(0);
        this.Qng.setText(charSequence);
        AppMethodBeat.o(38901);
    }

    public final void av(CharSequence charSequence) {
        AppMethodBeat.i(38902);
        this.Qnh.setVisibility(0);
        if (charSequence != null) {
            this.Qnh.setText(charSequence);
        }
        AppMethodBeat.o(38902);
    }

    public CharSequence getRightText() {
        AppMethodBeat.i(38903);
        CharSequence text = this.Qnh.getText();
        AppMethodBeat.o(38903);
        return text;
    }

    public final void gWY() {
        AppMethodBeat.i(38904);
        this.Qni.setVisibility(8);
        AppMethodBeat.o(38904);
    }

    public final void CE(boolean z) {
        AppMethodBeat.i(38905);
        this.Qni.setVisibility(0);
        this.Qni.setImageResource(z ? R.drawable.a95 : R.drawable.a94);
        AppMethodBeat.o(38905);
    }

    public void setIconClickListener(View.OnClickListener onClickListener) {
        AppMethodBeat.i(38906);
        this.Qni.setOnClickListener(onClickListener);
        AppMethodBeat.o(38906);
    }

    public final void hm(View view) {
        AppMethodBeat.i(38907);
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null && (layoutParams = generateDefaultLayoutParams()) == null) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("generateDefaultLayoutParams() cannot return null");
            AppMethodBeat.o(38907);
            throw illegalArgumentException;
        }
        addViewInLayout(view, -1, layoutParams);
        AppMethodBeat.o(38907);
    }
}

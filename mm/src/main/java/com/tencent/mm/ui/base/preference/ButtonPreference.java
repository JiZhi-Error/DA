package com.tencent.mm.ui.base.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ae.a;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.ar;

public class ButtonPreference extends Preference {
    private ImageView OXk;
    private String OXl;
    public boolean OXm = true;
    public int OXn;
    private TextView Ws;
    private Drawable icon;
    private Context mContext;
    private int textColor;
    private int uzt;
    private View zlc;

    public ButtonPreference(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(142502);
        setLayoutResource(R.layout.b8j);
        b(context, attributeSet);
        AppMethodBeat.o(142502);
    }

    public ButtonPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(142503);
        setLayoutResource(R.layout.b8j);
        b(context, attributeSet);
        AppMethodBeat.o(142503);
    }

    private void b(Context context, AttributeSet attributeSet) {
        AppMethodBeat.i(142505);
        this.mContext = context;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.C0244a.ButtonPreference);
        this.uzt = obtainStyledAttributes.getColor(2, 0);
        this.textColor = obtainStyledAttributes.getColor(3, 0);
        this.OXl = context.getString(obtainStyledAttributes.getResourceId(1, 0));
        this.icon = obtainStyledAttributes.getDrawable(0);
        obtainStyledAttributes.recycle();
        AppMethodBeat.o(142505);
    }

    public final void gX(String str, int i2) {
        AppMethodBeat.i(142506);
        this.OXl = str;
        this.textColor = i2;
        if (this.Ws != null) {
            this.Ws.setText(str);
            this.Ws.setTextColor(i2);
            if (this.OXm) {
                ao.a(this.Ws.getPaint(), 0.8f);
            }
        }
        AppMethodBeat.o(142506);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.ui.base.preference.Preference
    public final void onBindView(View view) {
        AppMethodBeat.i(142507);
        super.onBindView(view);
        this.OXk = (ImageView) view.findViewById(R.id.dt5);
        this.Ws = (TextView) view.findViewById(R.id.ijq);
        if (!(this.OXk == null || this.icon == null)) {
            this.OXk.setVisibility(0);
            this.OXk.setImageDrawable(ar.e(this.icon, this.uzt));
        }
        if (this.Ws != null) {
            this.Ws.setText(this.OXl);
            this.Ws.setTextColor(this.textColor);
            if (this.OXm) {
                ao.a(this.Ws.getPaint(), 0.8f);
            }
        }
        if (!(this.zlc == null || this.OXn == 0)) {
            this.zlc.setId(this.OXn);
        }
        AppMethodBeat.o(142507);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.ui.base.preference.Preference
    public final View onCreateView(ViewGroup viewGroup) {
        AppMethodBeat.i(142504);
        this.zlc = LayoutInflater.from(super.mContext).inflate(R.layout.bik, (ViewGroup) null);
        View view = this.zlc;
        AppMethodBeat.o(142504);
        return view;
    }
}

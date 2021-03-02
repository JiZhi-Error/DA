package com.tencent.mm.plugin.appbrand.keylogger.stepview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;

public final class b extends LinearLayout {
    private ViewGroup hub;
    private TextView jVn;
    private ImageView lIM;
    private Context mContext;
    private LinearLayout mPH = ((LinearLayout) findViewById(R.id.be3));
    private ViewGroup mPI;

    public b(Context context, boolean z) {
        super(context);
        AppMethodBeat.i(221330);
        LayoutInflater.from(context).inflate(R.layout.c62, this);
        this.mContext = context;
        this.mPH.setOrientation(z ? 0 : 1);
        this.jVn = (TextView) findViewById(R.id.bmr);
        this.lIM = (ImageView) findViewById(R.id.dt5);
        this.hub = (ViewGroup) findViewById(R.id.h8v);
        this.mPI = (ViewGroup) findViewById(R.id.dlm);
        AppMethodBeat.o(221330);
    }

    public final void addView(View view) {
        AppMethodBeat.i(221331);
        this.mPH.addView(view);
        AppMethodBeat.o(221331);
    }

    public final void setHasBorder(boolean z) {
        AppMethodBeat.i(221332);
        if (z) {
            this.hub.setBackground(this.mContext.getDrawable(R.drawable.awj));
            AppMethodBeat.o(221332);
            return;
        }
        this.hub.setBackground(null);
        AppMethodBeat.o(221332);
    }

    public final void setStep(c cVar) {
        AppMethodBeat.i(221333);
        if (cVar == null) {
            this.jVn.setText((CharSequence) null);
            this.lIM.setImageDrawable(null);
            this.mPI.setVisibility(8);
            AppMethodBeat.o(221333);
            return;
        }
        this.jVn.setText(cVar.mPJ);
        this.lIM.setImageResource(a.ye(cVar.mState));
        this.mPI.setVisibility(0);
        AppMethodBeat.o(221333);
    }
}

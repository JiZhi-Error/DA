package com.tencent.mm.plugin.appbrand.keylogger.stepview;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;

public final class d extends LinearLayout {
    private TextView jVn = ((TextView) findViewById(R.id.bmr));
    private ImageView lIM = ((ImageView) findViewById(R.id.dt5));

    public d(Context context) {
        super(context);
        AppMethodBeat.i(221334);
        LayoutInflater.from(context).inflate(R.layout.c61, this);
        AppMethodBeat.o(221334);
    }

    public final void setStep(c cVar) {
        AppMethodBeat.i(221335);
        if (cVar == null) {
            this.jVn.setText((CharSequence) null);
            this.lIM.setImageDrawable(null);
            AppMethodBeat.o(221335);
            return;
        }
        this.jVn.setText(cVar.mPJ);
        this.lIM.setImageResource(a.ye(cVar.mState));
        AppMethodBeat.o(221335);
    }
}

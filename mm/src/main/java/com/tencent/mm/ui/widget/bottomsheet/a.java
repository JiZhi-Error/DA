package com.tencent.mm.ui.widget.bottomsheet;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;

public final class a extends LinearLayout {
    private TextView mPa = ((TextView) findViewById(R.id.ipm));

    public a(Context context) {
        super(context);
        AppMethodBeat.i(143515);
        LayoutInflater.from(context).inflate(R.layout.ld, this);
        AppMethodBeat.o(143515);
    }

    public final void setTitle(String str) {
        AppMethodBeat.i(143516);
        this.mPa.setText(str);
        AppMethodBeat.o(143516);
    }
}

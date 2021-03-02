package com.tencent.mm.ui.widget.bottomsheet;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;

public final class b extends LinearLayout {
    private final TextView QFN = ((TextView) findViewById(R.id.idt));
    private final ImageView lIM = ((ImageView) findViewById(R.id.dt5));
    private final TextView mPa = ((TextView) findViewById(R.id.ipm));

    public b(Context context) {
        super(context);
        AppMethodBeat.i(143518);
        LayoutInflater.from(context).inflate(R.layout.le, this);
        AppMethodBeat.o(143518);
    }

    public final ImageView getIcon() {
        return this.lIM;
    }

    public final void setSubtitle(String str) {
        AppMethodBeat.i(143519);
        this.QFN.setText(str);
        AppMethodBeat.o(143519);
    }

    public final void setTitle(String str) {
        AppMethodBeat.i(143520);
        this.mPa.setText(str);
        AppMethodBeat.o(143520);
    }
}

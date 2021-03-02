package com.tencent.mm.plugin.appbrand.page;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;

public final class al extends RelativeLayout {
    TextView jVh;
    ImageView lIM;
    TextView nsb;
    Button nsc;
    ImageView nsd;

    public al(Context context) {
        super(context);
        AppMethodBeat.i(180353);
        View inflate = LayoutInflater.from(context).inflate(R.layout.fp, this);
        this.lIM = (ImageView) inflate.findViewById(R.id.dt5);
        this.jVh = (TextView) inflate.findViewById(R.id.ft7);
        this.nsb = (TextView) inflate.findViewById(R.id.bl2);
        this.nsc = (Button) inflate.findViewById(R.id.ae_);
        this.nsd = (ImageView) inflate.findViewById(R.id.g6f);
        AppMethodBeat.o(180353);
    }

    public final void setJumpBtnOnClickListener(View.OnClickListener onClickListener) {
        AppMethodBeat.i(180354);
        this.nsc.setOnClickListener(onClickListener);
        AppMethodBeat.o(180354);
    }
}

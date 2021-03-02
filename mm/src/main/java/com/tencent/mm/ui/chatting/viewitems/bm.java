package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ui.chatting.viewitems.c;

final class bm extends c.a {
    protected TextView PQp;
    protected TextView PQq;
    protected Button PQr;
    protected Button PQs;
    protected ImageView PQt;
    protected TextView jBR;

    bm() {
    }

    public final bm hh(View view) {
        AppMethodBeat.i(37551);
        super.create(view);
        this.jBR = (TextView) view.findViewById(R.id.at9);
        this.PQp = (TextView) view.findViewById(R.id.at8);
        this.PQq = (TextView) view.findViewById(R.id.atu);
        this.PQr = (Button) view.findViewById(R.id.awt);
        this.PQs = (Button) view.findViewById(R.id.aws);
        this.PQt = (ImageView) view.findViewById(R.id.ayg);
        this.checkBox = (CheckBox) view.findViewById(R.id.aue);
        this.maskView = view.findViewById(R.id.ax3);
        AppMethodBeat.o(37551);
        return this;
    }
}

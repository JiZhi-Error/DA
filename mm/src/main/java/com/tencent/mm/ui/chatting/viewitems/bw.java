package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ui.chatting.viewitems.c;
import com.tencent.mm.ui.widget.imageview.WeImageView;

final class bw extends c.a {
    TextView PRF;
    RelativeLayout PRG;
    TextView PRH;
    WeImageView PRI;
    ImageView gyr;
    TextView pIN;
    TextView titleTv;

    bw() {
    }

    public final c.a hi(View view) {
        AppMethodBeat.i(233971);
        super.create(view);
        this.PRF = (TextView) view.findViewById(R.id.asl);
        this.PRG = (RelativeLayout) view.findViewById(R.id.as_);
        this.gyr = (ImageView) view.findViewById(R.id.as4);
        this.pIN = (TextView) view.findViewById(R.id.asi);
        this.PRH = (TextView) view.findViewById(R.id.asj);
        this.PRI = (WeImageView) view.findViewById(R.id.as5);
        this.titleTv = (TextView) view.findViewById(R.id.ask);
        this.maskView = view.findViewById(R.id.ax3);
        AppMethodBeat.o(233971);
        return this;
    }

    @Override // com.tencent.mm.ui.chatting.viewitems.c.a
    public final View getMainContainerView() {
        return this.PRG;
    }
}

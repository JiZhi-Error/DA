package com.tencent.mm.plugin.appbrand.widget.desktop;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.widget.desktop.AppBrandDesktopView;

public final class d extends RecyclerView.v {
    public ImageView nnL;
    public ImageView ooB;
    public ViewGroup ooC;
    public TextView ooD;
    public ImageView ooE;
    public ImageView ooF;
    public AppBrandDesktopView.c ooG;
    public TextView titleTv;

    public d(View view) {
        super(view);
        AppMethodBeat.i(49643);
        this.nnL = (ImageView) view.findViewById(R.id.dt5);
        this.ooB = (ImageView) view.findViewById(R.id.dtj);
        this.ooC = (ViewGroup) view.findViewById(R.id.dty);
        this.titleTv = (TextView) view.findViewById(R.id.ipm);
        this.ooD = (TextView) view.findViewById(R.id.ijm);
        this.ooE = (ImageView) view.findViewById(R.id.i5e);
        this.ooF = (ImageView) view.findViewById(R.id.dwa);
        AppMethodBeat.o(49643);
    }
}

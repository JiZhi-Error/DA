package com.tencent.mm.plugin.taskbar.ui;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.taskbar.ui.section.weapp.b;

public final class b extends RecyclerView.v {
    public RelativeLayout FTx;
    public b.a FTy;
    public ImageView nnL;
    public ImageView ooB;
    public ViewGroup ooC;
    public TextView ooD;
    public ImageView ooE;
    public ImageView ooF;
    public TextView titleTv;

    public b(View view) {
        super(view);
        AppMethodBeat.i(238157);
        this.FTx = (RelativeLayout) view.findViewById(R.id.dtm);
        this.nnL = (ImageView) view.findViewById(R.id.dt5);
        this.ooB = (ImageView) view.findViewById(R.id.dtj);
        this.ooC = (ViewGroup) view.findViewById(R.id.dty);
        this.titleTv = (TextView) view.findViewById(R.id.ipm);
        this.ooD = (TextView) view.findViewById(R.id.ijm);
        this.ooE = (ImageView) view.findViewById(R.id.i5e);
        this.ooF = (ImageView) view.findViewById(R.id.dwa);
        AppMethodBeat.o(238157);
    }
}

package com.tencent.mm.plugin.choosemsgfile.b.b;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;

public final class l extends RecyclerView.v {
    public TextView jUO;
    public LinearLayout qnZ;
    public ProgressBar qoa;

    private l(View view) {
        super(view);
        AppMethodBeat.i(123297);
        this.qnZ = (LinearLayout) view.findViewById(R.id.be8);
        this.jUO = (TextView) view.findViewById(R.id.bkp);
        this.qoa = (ProgressBar) view.findViewById(R.id.gll);
        AppMethodBeat.o(123297);
    }

    public static RecyclerView.v o(ViewGroup viewGroup) {
        AppMethodBeat.i(123298);
        l lVar = new l(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.uc, viewGroup, false));
        AppMethodBeat.o(123298);
        return lVar;
    }
}

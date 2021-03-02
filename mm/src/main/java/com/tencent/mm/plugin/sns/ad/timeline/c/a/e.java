package com.tencent.mm.plugin.sns.ad.timeline.c.a;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;

public final class e extends RecyclerView.v {
    public ImageView DzC;
    public FrameLayout DzD;
    public ImageView DzE;
    public TextView DzF;
    public TextView DzG;
    public ViewGroup DzH;
    public TextView DzI;
    public TextView DzJ;

    public e(View view) {
        super(view);
        AppMethodBeat.i(202293);
        if (view != null) {
            this.DzC = (ImageView) view.findViewById(R.id.huy);
            this.DzD = (FrameLayout) view.findViewById(R.id.hux);
            this.DzE = (ImageView) view.findViewById(R.id.hv_);
            this.DzF = (TextView) view.findViewById(R.id.hva);
            this.DzG = (TextView) view.findViewById(R.id.hv9);
            this.DzH = (ViewGroup) view.findViewById(R.id.hv8);
            this.DzI = (TextView) view.findViewById(R.id.hv7);
            this.DzJ = (TextView) view.findViewById(R.id.hv6);
        }
        AppMethodBeat.o(202293);
    }
}

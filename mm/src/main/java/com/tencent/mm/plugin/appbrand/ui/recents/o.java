package com.tencent.mm.plugin.appbrand.ui.recents;

import android.content.Context;
import android.graphics.PointF;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.ae;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class o extends ae {
    private final LinearLayoutManager oel;
    private final int oem = 3000;
    private final int oen;

    public o(Context context, LinearLayoutManager linearLayoutManager) {
        super(context);
        AppMethodBeat.i(49269);
        this.oel = linearLayoutManager;
        this.oen = Math.round(((float) context.getResources().getDisplayMetrics().heightPixels) * 0.75f);
        AppMethodBeat.o(49269);
    }

    @Override // android.support.v7.widget.ae
    public final int cd(int i2) {
        AppMethodBeat.i(49270);
        int cd = super.cd(Math.max(this.oen, Math.min(this.oem, i2)));
        AppMethodBeat.o(49270);
        return cd;
    }

    @Override // android.support.v7.widget.RecyclerView.r
    public final PointF bZ(int i2) {
        AppMethodBeat.i(49271);
        PointF bZ = this.oel.bZ(i2);
        AppMethodBeat.o(49271);
        return bZ;
    }
}

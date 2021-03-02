package com.tencent.mm.plugin.appbrand.jsapi.k.a;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.mapsdk.raster.model.Marker;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.Log;

public final class d extends LinearLayout implements h {
    private Context context;
    Marker maj;
    private ImageView mbg;
    double mbh = -1.0d;
    double mbi = -1.0d;
    double mbj = -1.0d;
    double mbk = -1.0d;
    float mbl = 900.0f;
    float mbm = 900.0f;
    private float mbn = 0.0f;
    boolean mbo;

    public d(Context context2) {
        super(context2);
        AppMethodBeat.i(146555);
        this.context = context2;
        this.mbg = (ImageView) View.inflate(this.context, R.layout.z2, this).findViewById(R.id.iui);
        this.mbg.requestFocus();
        AppMethodBeat.o(146555);
    }

    public final double getLatitude() {
        return this.mbh;
    }

    public final double getLongitude() {
        return this.mbi;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.k.a.h
    public final void L(float f2, float f3) {
        AppMethodBeat.i(146556);
        this.mbn = f3;
        aK(getHeading());
        AppMethodBeat.o(146556);
    }

    private float getHeading() {
        if (this.mbo) {
            return this.mbl;
        }
        return this.mbn;
    }

    private void aK(float f2) {
        AppMethodBeat.i(146557);
        if (this.maj != null) {
            Log.v("MicroMsg.AppbrandMapLocationPoint", "updateRotation rotation:%f", Float.valueOf(f2));
            this.maj.setRotation(f2);
        }
        AppMethodBeat.o(146557);
    }
}

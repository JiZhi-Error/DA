package com.tencent.mm.plugin.card.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.card.model.u;
import com.tencent.mm.sdk.platformtools.Log;

public final class l implements i {
    private long crj = 0;
    public float gmu = -85.0f;
    public float gmv = -1000.0f;

    public final void R(float f2, float f3) {
        AppMethodBeat.i(112700);
        this.gmu = f2;
        this.gmv = f3;
        this.crj = System.currentTimeMillis() / 1000;
        AppMethodBeat.o(112700);
    }

    @Override // com.tencent.mm.ak.i
    public final void onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(112702);
        Log.i("MicroMsg.CardReportLBSManager", "rplbs onGYNetEnd, errType = %d, errCode = %d", Integer.valueOf(i2), Integer.valueOf(i3));
        g.aAg().hqi.b(1253, this);
        AppMethodBeat.o(112702);
    }

    public final void G(String str, String str2, int i2) {
        AppMethodBeat.i(112701);
        if ((System.currentTimeMillis() / 1000) - this.crj > 1800) {
            this.gmu = -85.0f;
            this.gmv = -1000.0f;
            Log.i("MicroMsg.CardReportLBSManager", "checkDataValid time is out");
        }
        if (this.gmu == -85.0f) {
            Log.i("MicroMsg.CardReportLBSManager", "checkDataValid lbsLatitude ==  LocationGeo.INVALID_LAT");
        }
        if (this.gmv == -1000.0f) {
            Log.i("MicroMsg.CardReportLBSManager", "checkDataValid lbsLongitude ==  LocationGeo.INVALID_LNG");
        }
        g.aAg().hqi.a(1253, this);
        g.aAg().hqi.a(new u(this.gmu, this.gmv, str, str2, i2), 0);
        AppMethodBeat.o(112701);
    }
}

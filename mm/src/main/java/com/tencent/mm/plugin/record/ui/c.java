package com.tencent.mm.plugin.record.ui;

import android.content.Context;
import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.gw;
import com.tencent.mm.plugin.record.ui.h;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;

public final class c implements h.a {
    public c(Context context) {
        AppMethodBeat.i(27831);
        gw gwVar = new gw();
        gwVar.dKR.opType = 3;
        gwVar.dKR.context = context;
        EventCenter.instance.publish(gwVar);
        AppMethodBeat.o(27831);
    }

    @Override // com.tencent.mm.plugin.record.ui.h.a
    public final void a(h.a.C1632a aVar) {
        AppMethodBeat.i(27832);
        Log.d("MicroMsg.FavImageServiceProxy", "attachThumb favLocalId %s", Long.valueOf(aVar.BHU));
        gw gwVar = new gw();
        gwVar.dKR.opType = 1;
        gwVar.dKR.dKU = aVar.dKU;
        gwVar.dKR.dKT = aVar.dKT;
        gwVar.dKR.dFW = aVar.BHU;
        gwVar.dKR.dKV = aVar.dKV;
        gwVar.dKR.width = aVar.width;
        gwVar.dKR.height = aVar.height;
        EventCenter.instance.publish(gwVar);
        AppMethodBeat.o(27832);
    }

    @Override // com.tencent.mm.plugin.record.ui.h.a
    public final Bitmap a(h.a.c cVar) {
        AppMethodBeat.i(27833);
        gw gwVar = new gw();
        gwVar.dKR.opType = 0;
        gwVar.dKR.dKT = cVar.dKT;
        gwVar.dKR.dFW = cVar.BHU;
        EventCenter.instance.publish(gwVar);
        Log.d("MicroMsg.FavImageServiceProxy", "getThumb favLocalId %s, retBmp %s", Long.valueOf(cVar.BHU), gwVar.dKS.dKZ);
        Bitmap bitmap = gwVar.dKS.dKZ;
        AppMethodBeat.o(27833);
        return bitmap;
    }

    @Override // com.tencent.mm.plugin.record.ui.h.a
    public final Bitmap a(h.a.b bVar) {
        AppMethodBeat.i(27834);
        gw gwVar = new gw();
        gwVar.dKR.opType = 2;
        gwVar.dKR.dKY = false;
        if (bVar.dKW) {
            gwVar.dKR.dKT = bVar.dKT;
            gwVar.dKR.dKW = bVar.dKW;
        } else {
            gwVar.dKR.dKT = bVar.dKT;
            gwVar.dKR.dFW = bVar.BHU;
            gwVar.dKR.maxWidth = bVar.maxWidth;
            gwVar.dKR.dKX = bVar.dKX;
        }
        EventCenter.instance.publish(gwVar);
        Log.d("MicroMsg.FavImageServiceProxy", "getSuitableBigImg favLocalId %s, dataId %s, retBmp %s, fromCache", Long.valueOf(bVar.BHU), bVar.dKT.dLl, gwVar.dKS.dKZ, Boolean.valueOf(gwVar.dKR.dKW));
        Bitmap bitmap = gwVar.dKS.dKZ;
        AppMethodBeat.o(27834);
        return bitmap;
    }

    @Override // com.tencent.mm.plugin.record.ui.h.a
    public final void eIr() {
        AppMethodBeat.i(27835);
        gw gwVar = new gw();
        gwVar.dKR.opType = 4;
        EventCenter.instance.publish(gwVar);
        AppMethodBeat.o(27835);
    }
}

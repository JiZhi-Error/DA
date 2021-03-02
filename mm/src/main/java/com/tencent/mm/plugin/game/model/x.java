package com.tencent.mm.plugin.game.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.protobuf.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public class x {
    public static c a(g gVar) {
        c cVar = null;
        AppMethodBeat.i(41523);
        if (gVar == null) {
            Log.e("MicroMsg.GamePBData", "Invalid pb object");
            AppMethodBeat.o(41523);
        } else if (Util.isNullOrNil(gVar.hik)) {
            Log.e("MicroMsg.GamePBData", "No AppID field, abort");
            AppMethodBeat.o(41523);
        } else {
            Log.i("MicroMsg.GamePBData", "Parsing AppID: %s", gVar.hik);
            cVar = new c();
            cVar.field_appId = gVar.hik;
            cVar.field_appName = gVar.Name;
            cVar.field_appIconUrl = gVar.xIJ;
            cVar.field_appType = ",1,";
            cVar.field_packageName = gVar.xuk;
            cVar.field_appVersion = gVar.Version;
            cVar.field_appInfoFlag = gVar.xIN;
            if (gVar.xIM != null) {
                cVar.Bl(gVar.xIM.xJL);
                cVar.Bo(gVar.xIM.xJM);
                cVar.mZ(gVar.xIM.xJP);
                cVar.Bp(gVar.xIM.xJN);
                cVar.xEn = gVar.xIM.xJR;
                cVar.nJC = (long) gVar.xIM.xJQ;
                cVar.dNv = gVar.xIM.xJS;
            }
            if (!(gVar.xIM == null || gVar.xIM.xJO == null)) {
                cVar.Bu(gVar.xIM.xJO.xJL);
                cVar.Bv(gVar.xIM.xJO.xNS);
                cVar.Bs(gVar.xIM.xJO.xNT);
                cVar.Bt(gVar.xIM.xJO.xNU);
                cVar.na(gVar.xIM.xJO.xNW);
            }
            cVar.xDV = gVar.Desc;
            cVar.xDU = gVar.xIK;
            cVar.status = gVar.oTW;
            cVar.xDX = gVar.xIB;
            cVar.versionCode = gVar.xIL;
            cVar.dDJ = gVar.xIG;
            cVar.jyX = gVar.xIO;
            cVar.xEg = gVar.xIT;
            if (!(gVar.xIM == null || gVar.xIM.xJO == null)) {
                cVar.xDZ = gVar.xIM.xJO.xNV;
                cVar.xEa = gVar.xIM.xJO.xNX;
                cVar.xEb = gVar.xIM.xJO.xNY;
            }
            cVar.appType = gVar.xIV;
            cVar.xEo = gVar.xIW;
            AppMethodBeat.o(41523);
        }
        return cVar;
    }
}

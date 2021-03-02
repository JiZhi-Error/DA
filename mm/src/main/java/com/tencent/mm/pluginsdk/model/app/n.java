package com.tencent.mm.pluginsdk.model.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.ab;
import com.tencent.mm.ak.c;
import com.tencent.mm.ak.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.r.a;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.et;
import com.tencent.mm.protocal.protobuf.eu;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public final class n implements u {
    private List<String> JVN = new ArrayList();
    public CopyOnWriteArrayList<String> JWp = new CopyOnWriteArrayList<>();
    private volatile boolean JWq = false;

    public n() {
        AppMethodBeat.i(151754);
        a.eAV().a(1, this);
        AppMethodBeat.o(151754);
    }

    public final void add(String str) {
        AppMethodBeat.i(151755);
        Log.d("MicroMsg.AppSettingService", "appId = ".concat(String.valueOf(str)));
        if (Util.isNullOrNil(str)) {
            Log.e("MicroMsg.AppSettingService", "add appId is null");
            AppMethodBeat.o(151755);
            return;
        }
        if (!this.JWp.contains(str)) {
            this.JWp.add(str);
        }
        axe();
        AppMethodBeat.o(151755);
    }

    public final void addAll(List<String> list) {
        AppMethodBeat.i(151756);
        if (list == null || list.size() == 0) {
            Log.e("MicroMsg.AppSettingService", "addAll list is null");
            AppMethodBeat.o(151756);
            return;
        }
        for (String str : list) {
            if (!Util.isNullOrNil(str) && !this.JWp.contains(str)) {
                this.JWp.add(str);
            }
        }
        axe();
        AppMethodBeat.o(151756);
    }

    public static String bdK(String str) {
        AppMethodBeat.i(151757);
        if (str == null || str.length() == 0) {
            Log.e("MicroMsg.AppSettingService", "getOpenIdSync, appId is null");
            AppMethodBeat.o(151757);
            return null;
        }
        g cX = h.cX(str, false);
        if (cX == null) {
            AppMethodBeat.o(151757);
            return null;
        } else if (cX.field_openId == null || cX.field_openId.length() == 0) {
            LinkedList linkedList = new LinkedList();
            linkedList.add(str);
            ad adVar = new ad(linkedList);
            d.a aVar = new d.a();
            aVar.iLN = new et();
            aVar.iLO = new eu();
            aVar.uri = "/cgi-bin/micromsg-bin/appcenter";
            aVar.funcId = 452;
            aVar.iLP = 0;
            aVar.respCmdId = 0;
            d aXF = aVar.aXF();
            et etVar = (et) aXF.iLK.iLR;
            byte[] gmB = adVar.gmB();
            if (gmB != null) {
                etVar.ReqBuf = new SKBuiltinBuffer_t().setBuffer(gmB);
            }
            etVar.oUv = 1;
            c.a e2 = ab.e(aXF);
            Log.i("MicroMsg.AppSettingService", "call getOpenIdSync cgi result, errType = %d, errCode = %d", Integer.valueOf(e2.errType), Integer.valueOf(e2.errCode));
            if (e2.errType == 0 && e2.errCode == 0) {
                adVar.cB(z.a(((eu) e2.iLC).KIk));
                adVar.onGYNetEnd(0, e2.errType, e2.errCode, e2.errMsg, aXF, new byte[0]);
                g o = h.o(str, false, false);
                if (o != null) {
                    String str2 = o.field_openId;
                    AppMethodBeat.o(151757);
                    return str2;
                }
                AppMethodBeat.o(151757);
                return null;
            }
            AppMethodBeat.o(151757);
            return null;
        } else {
            String str3 = cX.field_openId;
            AppMethodBeat.o(151757);
            return str3;
        }
    }

    private void axe() {
        int i2 = 20;
        AppMethodBeat.i(151758);
        if (this.JWq) {
            Log.d("MicroMsg.AppSettingService", "tryDoScene fail, doing Scene");
            AppMethodBeat.o(151758);
        } else if (this.JWp.size() <= 0) {
            Log.d("MicroMsg.AppSettingService", "tryDoScene fail, appIdList is empty");
            AppMethodBeat.o(151758);
        } else {
            Log.d("MicroMsg.AppSettingService", "tryDoScene, appid list size = " + this.JWp.size());
            int size = this.JWp.size();
            if (size <= 20) {
                i2 = size;
            }
            this.JWq = true;
            this.JVN.addAll(this.JWp.subList(0, i2));
            g.aAg().hqi.a(new ab(1, new ad(this.JVN)), 0);
            AppMethodBeat.o(151758);
        }
    }

    @Override // com.tencent.mm.pluginsdk.model.app.u
    public final void a(int i2, int i3, String str, aa aaVar) {
        AppMethodBeat.i(151759);
        if (aaVar.getType() != 1) {
            AppMethodBeat.o(151759);
            return;
        }
        this.JWq = false;
        Log.d("MicroMsg.AppSettingService", "onSceneEnd, list size = " + ((ad) aaVar).JWz.size());
        this.JWp.removeAll(this.JVN);
        this.JVN.clear();
        axe();
        AppMethodBeat.o(151759);
    }
}

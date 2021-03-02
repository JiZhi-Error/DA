package com.tencent.mm.plugin.downloader_app.a;

import android.content.pm.PackageInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.downloader.c.a.a.b;
import com.tencent.mm.plugin.downloader.c.a.a.d;
import com.tencent.mm.plugin.downloader.c.a.a.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public final class g {
    public b qKY;
    private Map<String, i> qKZ;
    private LinkedList<i> qLa;
    public f qLb;
    private String qLc;

    public g(b bVar) {
        AppMethodBeat.i(8896);
        this.qKZ = new HashMap();
        this.qLa = new LinkedList<>();
        this.qLc = "";
        if (bVar == null) {
            this.qKY = new b();
            AppMethodBeat.o(8896);
            return;
        }
        this.qKY = bVar;
        amZ();
        AppMethodBeat.o(8896);
    }

    public g(byte[] bArr) {
        AppMethodBeat.i(8897);
        this.qKZ = new HashMap();
        this.qLa = new LinkedList<>();
        this.qLc = "";
        this.qKY = new b();
        if (bArr == null || bArr.length == 0) {
            AppMethodBeat.o(8897);
            return;
        }
        try {
            this.qKY.parseFrom(bArr);
        } catch (IOException e2) {
            Log.e("MicroMsg.PBAppInfo", "Parsing Failed: %s", e2.getMessage());
        }
        amZ();
        AppMethodBeat.o(8897);
    }

    private void amZ() {
        AppMethodBeat.i(8898);
        this.qLb = this.qKY.qFN;
        if (Util.isNullOrNil(this.qKY.qFM)) {
            AppMethodBeat.o(8898);
            return;
        }
        Iterator<d> it = this.qKY.qFM.iterator();
        while (it.hasNext()) {
            d next = it.next();
            if (next.qFP.qHa == null || next.qFP.qHa.qGP == null) {
                Log.e("MicroMsg.PBAppInfo", "download info is null, appid:%s", next.qFP.qGY.dNI);
            } else {
                i iVar = new i();
                iVar.appId = next.qFP.qGY.dNI;
                iVar.appName = next.qFP.qGY.qGA;
                iVar.iconUrl = next.qFP.qGY.qGB;
                iVar.packageName = next.qFP.qHa.qGP.qGp;
                iVar.qLi = next.qFP.qHa.qGP;
                iVar.jumpUrl = next.qFR != null ? next.qFR.qFO : "";
                if (!Util.isNullOrNil(iVar.jumpUrl)) {
                    this.qLc = iVar.jumpUrl;
                }
                iVar.qLg = next.qFP.qHa.qGP.qGx;
                iVar.qLk = next.qFP.qHc;
                if (j.alA(next.qFP.qGY.dNI) == k.UN_INSTALLED) {
                    iVar.type = 2;
                } else {
                    PackageInfo packageInfo = com.tencent.mm.plugin.appbrand.ac.b.getPackageInfo(MMApplicationContext.getContext(), next.qFP.qHa.qGP.qGp);
                    if (packageInfo == null || packageInfo.versionCode >= next.qFP.qHa.qGP.qGt) {
                        iVar.type = 6;
                    } else {
                        iVar.type = 4;
                    }
                }
                this.qKZ.put(iVar.appId, iVar);
            }
        }
        AppMethodBeat.o(8898);
    }

    public final i alz(String str) {
        AppMethodBeat.i(8899);
        i iVar = this.qKZ.get(str);
        AppMethodBeat.o(8899);
        return iVar;
    }

    public final LinkedList<i> X(LinkedList<String> linkedList) {
        AppMethodBeat.i(8900);
        this.qLa.clear();
        if (!Util.isNullOrNil(linkedList)) {
            Iterator<String> it = linkedList.iterator();
            int i2 = 0;
            int i3 = 0;
            int i4 = 0;
            while (it.hasNext()) {
                i iVar = this.qKZ.get(it.next());
                if (iVar != null) {
                    switch (iVar.type) {
                        case 2:
                            i4++;
                            iVar.position = i4;
                            break;
                        case 4:
                            i3++;
                            iVar.position = i3;
                            break;
                        case 6:
                            i2++;
                            iVar.position = i2;
                            break;
                    }
                    this.qLa.add(iVar);
                }
                i2 = i2;
            }
            i iVar2 = new i(8);
            iVar2.qLj = this.qLb;
            this.qLa.add(iVar2);
        }
        LinkedList<i> linkedList2 = this.qLa;
        AppMethodBeat.o(8900);
        return linkedList2;
    }

    public final boolean cCb() {
        AppMethodBeat.i(8901);
        if (this.qKZ.size() == 0) {
            AppMethodBeat.o(8901);
            return true;
        }
        AppMethodBeat.o(8901);
        return false;
    }
}

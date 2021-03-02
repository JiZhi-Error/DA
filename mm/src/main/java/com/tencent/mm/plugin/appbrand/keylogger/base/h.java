package com.tencent.mm.plugin.appbrand.keylogger.base;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public final class h {
    public final d mPD;
    private List<h> mPE;
    public final String mPF;

    /* access modifiers changed from: package-private */
    public static final class a extends g {
    }

    public interface b {
        void a(h hVar);
    }

    private h(d dVar, String str) {
        this.mPD = dVar;
        this.mPF = str;
    }

    public final List<h> bNa() {
        return this.mPE;
    }

    private void b(h hVar) {
        AppMethodBeat.i(221326);
        if (!a(this.mPD)) {
            Log.e("StepNode", "addChild but not a node group");
            AppMethodBeat.o(221326);
            return;
        }
        if (this.mPE == null) {
            this.mPE = new ArrayList();
        }
        this.mPE.add(hVar);
        AppMethodBeat.o(221326);
    }

    public final a bNb() {
        if (this.mPD instanceof a) {
            return (a) this.mPD;
        }
        return null;
    }

    public static void a(h hVar, b bVar) {
        AppMethodBeat.i(221327);
        if (hVar == null) {
            AppMethodBeat.o(221327);
        } else if (bVar == null) {
            AppMethodBeat.o(221327);
        } else {
            bVar.a(hVar);
            List<h> list = hVar.mPE;
            if (list == null || list.isEmpty()) {
                AppMethodBeat.o(221327);
                return;
            }
            for (int i2 = 0; i2 < list.size(); i2++) {
                a(list.get(i2), bVar);
            }
            AppMethodBeat.o(221327);
        }
    }

    public static h f(List<d> list, String str) {
        String format;
        h hVar;
        AppMethodBeat.i(221328);
        h hVar2 = new h(new a(), "");
        hVar2.b(new h(list.get(0), ""));
        HashMap hashMap = new HashMap();
        for (int i2 = 1; i2 < list.size() - 1; i2++) {
            d dVar = list.get(i2);
            int bMZ = dVar.bMZ();
            if (bMZ <= 0) {
                int bMY = dVar.bMY();
                h hVar3 = new h(dVar, "");
                hVar2.b(hVar3);
                hashMap.put(Integer.valueOf(bMY), hVar3);
            } else {
                h hVar4 = (h) hashMap.get(Integer.valueOf(bMZ));
                if (hVar4 != null && (Util.isNullOrNil(dVar.category()) || Util.isNullOrNil(str) || str.equals(dVar.category()))) {
                    if (!a(hVar4.mPD)) {
                        Log.e("StepNode", "addChild but not a node group");
                        hVar = null;
                    } else {
                        if (hVar4.mPE == null) {
                            hVar4.mPE = new ArrayList();
                        }
                        String str2 = hVar4.mPD.getType() == 3 ? "-" : ".";
                        if (!Util.isNullOrNil(hVar4.mPF)) {
                            format = String.format("%s%s%d", hVar4.mPF, str2, Integer.valueOf(hVar4.mPE.size() + 1));
                        } else {
                            format = String.format("%d", Integer.valueOf(hVar4.mPE.size() + 1));
                        }
                        h hVar5 = new h(dVar, format);
                        hVar4.mPE.add(hVar5);
                        hVar = hVar5;
                    }
                    if (a(dVar)) {
                        hashMap.put(Integer.valueOf(dVar.bMY()), hVar);
                    }
                }
            }
        }
        hVar2.b(new h(list.get(list.size() - 1), ""));
        AppMethodBeat.o(221328);
        return hVar2;
    }

    private static boolean a(d dVar) {
        AppMethodBeat.i(221329);
        if (dVar.getType() == 3 || dVar.getType() == 2) {
            AppMethodBeat.o(221329);
            return true;
        }
        AppMethodBeat.o(221329);
        return false;
    }
}

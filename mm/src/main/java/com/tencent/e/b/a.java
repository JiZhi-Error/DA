package com.tencent.e.b;

import android.content.Context;
import android.os.Build;
import com.tencent.e.c.b.d;
import com.tencent.e.d.a.b;
import com.tencent.e.d.a.c;
import com.tencent.e.d.a.f;
import com.tencent.e.d.a.g;
import com.tencent.e.d.b.e;
import com.tencent.e.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class a {
    public b RKV;
    public Context mContext = null;

    public a(Context context) {
        AppMethodBeat.i(138310);
        this.mContext = context;
        this.RKV = new b(context);
        AppMethodBeat.o(138310);
    }

    public static d hku() {
        boolean z;
        boolean z2;
        int i2;
        AppMethodBeat.i(138311);
        d dVar = new d();
        try {
            dVar.RMk = Build.FINGERPRINT;
            dVar.RMl = com.tencent.e.f.d.hkQ();
            dVar.brand = Build.BRAND;
            dVar.model = Build.MODEL;
            dVar.RMm = Build.VERSION.SDK_INT;
            dVar.RMn = Build.CPU_ABI;
            dVar.platform = com.tencent.e.f.d.bqd("ro.board.platform");
            if (f.hky()) {
                i2 = 2;
            } else {
                List<e.a> hkz = e.hkz();
                if (!com.tencent.e.d.b.a.isEmpty(hkz)) {
                    ArrayList<b> arrayList = new ArrayList(3);
                    arrayList.add(new g());
                    arrayList.add(new com.tencent.e.d.a.d());
                    if (com.tencent.e.d.b.g.hkA()) {
                        arrayList.add(new c());
                    }
                    for (e.a aVar : hkz) {
                        if (aVar != null) {
                            for (b bVar : arrayList) {
                                bVar.a(aVar);
                            }
                        }
                    }
                    Iterator it = arrayList.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            if (((b) it.next()).hkw()) {
                                z = true;
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                }
                z = false;
                if (z) {
                    i2 = 2;
                } else if (com.tencent.e.d.a.e.hkx()) {
                    i2 = 1;
                } else {
                    if (!com.tencent.e.d.a.a.bpZ("/system/bin/debuggerd")) {
                        z2 = true;
                    } else if (!com.tencent.e.d.a.a.bpZ("/system/bin/debuggerd64")) {
                        z2 = true;
                    } else if (!com.tencent.e.d.a.a.bpZ("/system/bin/ddexe")) {
                        z2 = true;
                    } else if (!com.tencent.e.d.a.a.bqa("/system/etc/install-recovery.sh")) {
                        z2 = true;
                    } else if (!com.tencent.e.d.a.a.bqa("/system/bin/install-recovery.sh")) {
                        z2 = true;
                    } else {
                        h.hkR();
                        z2 = false;
                    }
                    i2 = z2 ? 1 : 0;
                }
            }
            dVar.RMo = i2;
        } catch (Exception e2) {
        }
        AppMethodBeat.o(138311);
        return dVar;
    }

    public static com.tencent.e.c.b.b a(Context context, com.tencent.e.a.a aVar, int i2) {
        AppMethodBeat.i(138312);
        if (aVar == null) {
            AppMethodBeat.o(138312);
            return null;
        }
        com.tencent.e.c.b.b bVar = new com.tencent.e.c.b.b();
        bVar.RLC = i2;
        bVar.RLD = null;
        bVar.RLE = aVar.pkgName;
        bVar.RLF = com.tencent.e.f.e.bqe(aVar.RKQ);
        List<byte[]> cS = com.tencent.e.f.a.cS(context, aVar.pkgName);
        if (cS.size() > 1) {
            bVar.RLU = new ArrayList<>();
            for (byte[] bArr : cS) {
                bVar.RLU.add(bArr);
            }
        }
        bVar.RLG = aVar.fileSize;
        bVar.RLH = aVar.RKP;
        bVar.RLI = aVar.versionCode;
        bVar.RLJ = aVar.versionName;
        bVar.RLK = 0;
        if (aVar.appType == 1) {
            bVar.RLK |= 1;
        }
        bVar.RLK |= 2;
        if (!aVar.RKR.startsWith("/data") && !aVar.RKR.startsWith("/system")) {
            bVar.RLK |= 4;
        }
        bVar.RLL = "";
        bVar.RLM = 0;
        bVar.RLN = 0;
        bVar.RLO = 0;
        bVar.RLP = null;
        bVar.RLQ = 0;
        bVar.RLR = false;
        bVar.RLS = 0;
        bVar.RLT = 0;
        AppMethodBeat.o(138312);
        return bVar;
    }
}

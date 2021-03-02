package com.tencent.mm.plugin.appbrand.u.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.permission.d;
import com.tencent.mm.plugin.appbrand.s;
import com.tencent.mm.plugin.appbrand.u.a.e;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;

public final class b extends e {
    private d.c nkp;

    public b(e.a aVar, s sVar) {
        super(aVar, sVar);
    }

    @Override // com.tencent.mm.plugin.appbrand.u.a.e
    public final void bPV() {
        AppMethodBeat.i(147408);
        d dVar = ((com.tencent.luggage.sdk.d.d) this.cAJ.getRuntime()).cCn;
        if (dVar == null) {
            Log.e("MicroMsg.ProxyOnPermissionUpdateListener", "AppRuntimeApiPermissionController null");
            AppMethodBeat.o(147408);
            return;
        }
        this.nkp = new d.c() {
            /* class com.tencent.mm.plugin.appbrand.u.d.b.AnonymousClass1 */

            @Override // com.tencent.mm.plugin.appbrand.permission.d.c
            public final void g(byte[] bArr, byte[] bArr2) {
                AppMethodBeat.i(147407);
                Log.i("MicroMsg.ProxyOnPermissionUpdateListener", "onUpdate");
                HashMap hashMap = new HashMap();
                hashMap.put("fg", bArr);
                hashMap.put("bg", bArr2);
                b.this.aa(hashMap);
                AppMethodBeat.o(147407);
            }
        };
        d.c cVar = this.nkp;
        synchronized (dVar.nxs) {
            try {
                dVar.nxw.add(cVar);
            } finally {
                AppMethodBeat.o(147408);
            }
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.u.a.e
    public final void removeListener() {
        AppMethodBeat.i(147409);
        if (this.nkp == null) {
            AppMethodBeat.o(147409);
        } else if (this.cAJ.getRuntime() == null) {
            AppMethodBeat.o(147409);
        } else {
            d dVar = ((com.tencent.luggage.sdk.d.d) this.cAJ.getRuntime()).cCn;
            if (dVar == null) {
                AppMethodBeat.o(147409);
                return;
            }
            d.c cVar = this.nkp;
            synchronized (dVar.nxs) {
                try {
                    dVar.nxw.remove(cVar);
                } finally {
                    AppMethodBeat.o(147409);
                }
            }
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.u.a.e
    public final int getType() {
        return 3;
    }
}

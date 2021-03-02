package com.tencent.luggage.game.d.a.a;

import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import com.tencent.luggage.game.d.a.a;
import com.tencent.luggage.sdk.b.a.c.b;
import com.tencent.luggage.sdk.b.a.c.d;
import com.tencent.magicbrush.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.aq;
import com.tencent.mm.plugin.appbrand.m.g;
import com.tencent.mm.plugin.appbrand.m.t;
import com.tencent.mm.plugin.appbrand.m.v;
import com.tencent.mm.sdk.platformtools.Log;

public class e extends b<d> implements a {
    private boolean cwq = false;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.appbrand.s] */
    @Override // com.tencent.luggage.sdk.b.a.c.b
    public final /* synthetic */ int a(d dVar) {
        AppMethodBeat.i(130605);
        int pkgVersion = dVar.bqZ().bve().pkgVersion();
        AppMethodBeat.o(130605);
        return pkgVersion;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.appbrand.s] */
    @Override // com.tencent.luggage.sdk.b.a.c.b
    public final /* synthetic */ String b(d dVar) {
        AppMethodBeat.i(130606);
        d dVar2 = dVar;
        String str = "";
        if (this.cwq) {
            str = str + com.tencent.mm.plugin.appbrand.ac.d.afA("wxa_library/NativeGlobal-WAGame.js");
        }
        String UM = dVar2.bqZ().UM("WAGameSubContext.js");
        if (TextUtils.isEmpty(UM)) {
            aq aqVar = new aq("WAGameSubContext.js");
            AppMethodBeat.o(130606);
            throw aqVar;
        }
        String str2 = str + ";" + UM;
        AppMethodBeat.o(130606);
        return str2;
    }

    public e(d dVar, t tVar) {
        super(dVar, tVar);
    }

    @JavascriptInterface
    public int allocNativeGlobal() {
        AppMethodBeat.i(130602);
        this.cwq = true;
        int alloc = super.alloc();
        Log.i("MicroMsg.WAGameJsContextInterfaceLU", "alloc injectNativeGlobal = [%b], ret = [%d]", Boolean.valueOf(this.cwq), Integer.valueOf(alloc));
        this.cwq = false;
        AppMethodBeat.o(130602);
        return alloc;
    }

    @Override // com.tencent.luggage.sdk.b.a.c.b
    public final g MI() {
        boolean z;
        AppMethodBeat.i(130603);
        g MI = super.MI();
        if (MI != null) {
            if (this.cwq) {
                try {
                    v vVar = (v) MI.R(v.class);
                    b bVar = (b) ((d) NY()).S(b.class);
                    if (bVar != null) {
                        bVar.getMagicBrush().d(new e.f(vVar.getIsolatePtr(), vVar.XK(), vVar.getUVLoopPtr()));
                    } else {
                        Log.w("MicroMsg.WAGameJsContextInterfaceLU", "No extension found!");
                    }
                    z = true;
                } catch (NullPointerException e2) {
                    Log.e("MicroMsg.WAGameJsContextInterfaceLU", "injectNativeGlobal failed [%s]", e2);
                    z = false;
                }
            } else {
                z = true;
            }
            Log.i("MicroMsg.WAGameJsContextInterfaceLU", "alloc injectNativeGlobal = [%b], ret = [%b]", Boolean.valueOf(this.cwq), Boolean.valueOf(z));
        }
        AppMethodBeat.o(130603);
        return MI;
    }

    @Override // com.tencent.luggage.sdk.b.a.c.b
    public final void MJ() {
        AppMethodBeat.i(130604);
        super.MJ();
        Log.i("MicroMsg.WAGameJsContextInterfaceLU", "hy: injected WAGameJSContextInterface");
        AppMethodBeat.o(130604);
    }

    @Override // com.tencent.luggage.sdk.b.a.c.b
    public final String MK() {
        return "WAGameSubContext.js";
    }
}

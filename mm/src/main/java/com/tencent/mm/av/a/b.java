package com.tencent.mm.av.a;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.a.a.a;
import com.tencent.mm.av.a.c.j;
import com.tencent.mm.av.a.f.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;

public final class b {
    public com.tencent.mm.av.a.a.b jaJ;
    j jaK;
    private Executor jaL;
    public final Map<Integer, String> jaM = Collections.synchronizedMap(new HashMap());
    public HashMap<Integer, com.tencent.mm.av.a.f.b> jaN = new HashMap<>();

    public b(com.tencent.mm.av.a.a.b bVar) {
        AppMethodBeat.i(130366);
        this.jaJ = bVar;
        this.jaK = bVar.jaZ;
        this.jaL = bVar.jba;
        this.jaJ.jaT.a(this.jaJ.jaV);
        AppMethodBeat.o(130366);
    }

    public final void a(com.tencent.mm.av.a.f.b bVar, boolean z) {
        AppMethodBeat.i(130367);
        aJv();
        this.jaK.execute(bVar);
        if (z && com.tencent.mm.av.a.g.b.bdA()) {
            this.jaL.execute(new d());
        }
        AppMethodBeat.o(130367);
    }

    public final boolean YY() {
        AppMethodBeat.i(130368);
        boolean YY = this.jaK.YY();
        AppMethodBeat.o(130368);
        return YY;
    }

    public final Bitmap OQ(String str) {
        AppMethodBeat.i(130369);
        if (this.jaJ != null) {
            Bitmap EP = this.jaJ.jaS.EP(str);
            AppMethodBeat.o(130369);
            return EP;
        }
        AppMethodBeat.o(130369);
        return null;
    }

    public final void aHn() {
        AppMethodBeat.i(130370);
        if (this.jaJ != null) {
            this.jaJ.jaS.clear();
            this.jaJ.jaT.bdw();
        }
        AppMethodBeat.o(130370);
    }

    private void aJv() {
        AppMethodBeat.i(130371);
        if (this.jaJ.jaZ.isShutdown()) {
            this.jaK = a.tv(this.jaJ.jaP);
        }
        AppMethodBeat.o(130371);
    }

    public final boolean a(c cVar, String str) {
        AppMethodBeat.i(130372);
        if (!Util.isNullOrNil(str)) {
            String str2 = this.jaM.get(Integer.valueOf(cVar.iaH));
            if (Util.isNullOrNil(str2) || !str.equals(str2)) {
                this.jaM.put(Integer.valueOf(cVar.iaH), str);
                AppMethodBeat.o(130372);
                return true;
            }
        }
        AppMethodBeat.o(130372);
        return false;
    }

    public final void a(c cVar) {
        AppMethodBeat.i(130373);
        this.jaM.remove(Integer.valueOf(cVar.iaH));
        Log.d("MicroMsg.imageloader.ImageLoaderManager", "[cpan] remove image weak holder size:%d viewcode:%s", Integer.valueOf(this.jaM.size()), Integer.valueOf(cVar.iaH));
        AppMethodBeat.o(130373);
    }

    public final void a(com.tencent.mm.av.a.f.b bVar) {
        AppMethodBeat.i(130374);
        if (!(this.jaN == null || bVar.jbM == null)) {
            com.tencent.mm.av.a.f.b bVar2 = this.jaN.get(Integer.valueOf(bVar.jbM.iaH));
            if (!(bVar2 == null || bVar2.jbM == null || bVar.jbM.iaH != bVar2.jbM.iaH)) {
                this.jaK.remove(bVar2);
                Log.d("MicroMsg.imageloader.ImageLoaderManager", "remove taks url:%s", bVar2.url);
            }
            this.jaN.put(Integer.valueOf(bVar.jbM.iaH), bVar);
        }
        AppMethodBeat.o(130374);
    }

    public final void a(com.tencent.mm.av.a.f.a aVar) {
        AppMethodBeat.i(212680);
        this.jaK.execute(aVar);
        AppMethodBeat.o(212680);
    }
}

package com.tencent.mm.plugin.music.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ay.f;
import com.tencent.mm.plugin.music.h.a;
import com.tencent.mm.plugin.music.h.d;
import com.tencent.mm.sdk.platformtools.Log;

public final class k extends h {
    private static k AjD;
    public a AjC = null;
    private a AjE;

    private k(a aVar) {
        this.AjC = aVar;
    }

    public static synchronized void a(a aVar) {
        synchronized (k.class) {
            AppMethodBeat.i(137284);
            if (AjD != null) {
                Log.e("MicroMsg.Music.MusicPlayerManager", "music player mgr is init, don't it again");
                AjD.AjC = aVar;
                aVar.a(AjD);
                aVar.init();
                AppMethodBeat.o(137284);
            } else {
                AjD = new k(aVar);
                aVar.a(AjD);
                aVar.init();
                AppMethodBeat.o(137284);
            }
        }
    }

    public static k euj() {
        AppMethodBeat.i(137285);
        if (AjD == null) {
            NullPointerException nullPointerException = new NullPointerException("must init MusicPlayerManager with your impl logic first!!!");
            AppMethodBeat.o(137285);
            throw nullPointerException;
        }
        if (AjD.AjC == null) {
            AjD.AjC = new i();
        }
        k kVar = AjD;
        AppMethodBeat.o(137285);
        return kVar;
    }

    public static boolean isInit() {
        return AjD != null;
    }

    public static synchronized void euk() {
        synchronized (k.class) {
            AppMethodBeat.i(137286);
            if (AjD != null) {
                AjD.finish();
            }
            AppMethodBeat.o(137286);
        }
    }

    @Override // com.tencent.mm.plugin.music.e.c
    public final void s(f fVar) {
        AppMethodBeat.i(137287);
        if (fVar != null) {
            Log.i("MicroMsg.Music.MusicPlayerManager", "MusicType %d", Integer.valueOf(fVar.jeT));
        }
        Log.i("MicroMsg.Music.MusicPlayerManager", "startPlayNewMusic");
        w(this.AjC.k(fVar));
        AppMethodBeat.o(137287);
    }

    /* access modifiers changed from: package-private */
    public final void w(f fVar) {
        AppMethodBeat.i(137288);
        d.V(fVar);
        if (this.AjC.i(fVar)) {
            t(fVar);
            AppMethodBeat.o(137288);
            return;
        }
        Log.e("MicroMsg.Music.MusicPlayerManager", "prepare is fail, not to play or wait for callback onStart");
        AppMethodBeat.o(137288);
    }

    @Override // com.tencent.mm.plugin.music.e.h, com.tencent.mm.plugin.music.e.c
    public final com.tencent.mm.plugin.music.f.a.d etW() {
        AppMethodBeat.i(137289);
        com.tencent.mm.plugin.music.f.a.d etW = super.etW();
        AppMethodBeat.o(137289);
        return etW;
    }

    @Override // com.tencent.mm.plugin.music.e.h, com.tencent.mm.plugin.music.e.c
    public final void bea() {
        AppMethodBeat.i(137290);
        super.bea();
        AppMethodBeat.o(137290);
    }

    @Override // com.tencent.mm.plugin.music.e.h
    public final void release() {
        AppMethodBeat.i(137291);
        Log.i("MicroMsg.Music.MusicPlayerManager", "release");
        super.release();
        AppMethodBeat.o(137291);
    }

    @Override // com.tencent.mm.plugin.music.e.h
    public final void finish() {
        AppMethodBeat.i(137292);
        super.finish();
        this.AjC.release();
        this.AjE = null;
        AppMethodBeat.o(137292);
    }

    @Override // com.tencent.mm.plugin.music.e.h, com.tencent.mm.plugin.music.e.c
    public final void sl(boolean z) {
        AppMethodBeat.i(137293);
        super.sl(z);
        AppMethodBeat.o(137293);
    }

    @Override // com.tencent.mm.plugin.music.e.h
    public final void SP(int i2) {
        AppMethodBeat.i(137294);
        super.SP(i2);
        AppMethodBeat.o(137294);
    }

    @Override // com.tencent.mm.plugin.music.e.h
    public final f etU() {
        AppMethodBeat.i(137295);
        f etU = this.AjC.etU();
        AppMethodBeat.o(137295);
        return etU;
    }

    @Override // com.tencent.mm.plugin.music.e.h
    public final void m(f fVar) {
        AppMethodBeat.i(198179);
        super.m(fVar);
        this.AjC.m(fVar);
        AppMethodBeat.o(198179);
    }

    public static a eul() {
        AppMethodBeat.i(137296);
        if (euj().AjE == null) {
            euj().AjE = new a();
        }
        a aVar = euj().AjE;
        AppMethodBeat.o(137296);
        return aVar;
    }
}

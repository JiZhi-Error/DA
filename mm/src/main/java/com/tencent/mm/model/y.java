package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.api.c;
import com.tencent.mm.kernel.api.f;
import com.tencent.mm.kernel.api.h;
import com.tencent.mm.kernel.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storagebase.h;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public class y implements com.tencent.mm.kernel.api.a, c, f, h, com.tencent.mm.kernel.b.c {
    private static ConcurrentHashMap<String, y> iCA = new ConcurrentHashMap<>();
    private volatile a iCw;
    private volatile Class<? extends bd> iCx;
    private volatile bd iCy;
    private volatile boolean iCz = false;

    public interface a {
        bd createSubCore();
    }

    public y(Class<? extends bd> cls) {
        AppMethodBeat.i(42773);
        this.iCx = cls;
        a(this.iCx.getName(), this);
        AppMethodBeat.o(42773);
    }

    public y(a aVar) {
        this.iCw = aVar;
    }

    public final synchronized bd aTV() {
        bd bdVar;
        AppMethodBeat.i(42774);
        if (this.iCy == null) {
            a(createSubCore());
        }
        bdVar = this.iCy;
        AppMethodBeat.o(42774);
        return bdVar;
    }

    /* JADX DEBUG: Type inference failed for r0v4. Raw type applied. Possible types: java.lang.Class<?>, java.lang.Class<? extends com.tencent.mm.model.bd> */
    public final void a(bd bdVar) {
        AppMethodBeat.i(42775);
        synchronized (this) {
            try {
                this.iCy = bdVar;
                if (this.iCx == null && this.iCy != null) {
                    this.iCx = this.iCy.getClass();
                }
            } finally {
                AppMethodBeat.o(42775);
            }
        }
    }

    private bd createSubCore() {
        AppMethodBeat.i(42776);
        try {
            Log.i("MicroMsg.CompatSubCore", "createSubCore(), %s %s", this.iCx, this.iCw);
            if (this.iCw != null) {
                bd createSubCore = this.iCw.createSubCore();
                AppMethodBeat.o(42776);
                return createSubCore;
            }
            bd bdVar = (bd) this.iCx.newInstance();
            AppMethodBeat.o(42776);
            return bdVar;
        } catch (InstantiationException e2) {
            Log.printErrStackTrace("MicroMsg.CompatSubCore", e2, "", new Object[0]);
            IllegalAccessError illegalAccessError = new IllegalAccessError(e2.getMessage());
            AppMethodBeat.o(42776);
            throw illegalAccessError;
        } catch (IllegalAccessException e3) {
            Log.printErrStackTrace("MicroMsg.CompatSubCore", e3, "", new Object[0]);
            IllegalAccessError illegalAccessError2 = new IllegalAccessError(e3.getMessage());
            AppMethodBeat.o(42776);
            throw illegalAccessError2;
        }
    }

    private synchronized void reset() {
        this.iCy = null;
        this.iCz = false;
    }

    public static y a(String str, y yVar) {
        AppMethodBeat.i(42777);
        y putIfAbsent = iCA.putIfAbsent(str, yVar);
        if (putIfAbsent == null) {
            com.tencent.mm.kernel.a.c.aAu().bC(yVar);
        } else {
            yVar = putIfAbsent;
        }
        Log.i("MicroMsg.CompatSubCore", "registerCompatSubCoreWithNameIfAbsent %s, %s %s", str, yVar, Util.getStack());
        AppMethodBeat.o(42777);
        return yVar;
    }

    public static y Il(String str) {
        AppMethodBeat.i(42778);
        y yVar = iCA.get(str);
        if (yVar == null) {
            Log.i("MicroMsg.CompatSubCore", "compatSubCore is null by name %s", str);
        } else {
            com.tencent.mm.kernel.a.c.aAu().bB(yVar);
        }
        AppMethodBeat.o(42778);
        return yVar;
    }

    public static void aTW() {
        AppMethodBeat.i(42779);
        for (y yVar : iCA.values()) {
            yVar.reset();
        }
        AppMethodBeat.o(42779);
    }

    public static void rN(int i2) {
        AppMethodBeat.i(42780);
        for (y yVar : iCA.values()) {
            bd aTV = yVar.aTV();
            if (aTV != null) {
                aTV.clearPluginData(i2);
            }
        }
        AppMethodBeat.o(42780);
    }

    static {
        AppMethodBeat.i(42788);
        AppMethodBeat.o(42788);
    }

    @Override // com.tencent.mm.kernel.api.a
    public HashMap<Integer, h.b> collectDatabaseFactory() {
        AppMethodBeat.i(42782);
        bd aTV = aTV();
        if (aTV == null) {
            AppMethodBeat.o(42782);
            return null;
        }
        HashMap<Integer, h.b> baseDBFactories = aTV.getBaseDBFactories();
        AppMethodBeat.o(42782);
        return baseDBFactories;
    }

    @Override // com.tencent.mm.kernel.api.c
    public void onAccountInitialized(e.c cVar) {
        AppMethodBeat.i(42783);
        bd aTV = aTV();
        if (aTV == null) {
            AppMethodBeat.o(42783);
            return;
        }
        aTV.onAccountPostReset(cVar.hrc);
        this.iCz = true;
        AppMethodBeat.o(42783);
    }

    @Override // com.tencent.mm.kernel.api.c
    public void onAccountRelease() {
        AppMethodBeat.i(42784);
        bd aTV = aTV();
        if (aTV == null) {
            AppMethodBeat.o(42784);
            return;
        }
        aTV.onAccountRelease();
        AppMethodBeat.o(42784);
    }

    @Override // com.tencent.mm.kernel.api.f
    public final void aAp() {
        AppMethodBeat.i(42785);
        bd aTV = aTV();
        if (aTV == null) {
            AppMethodBeat.o(42785);
        } else if (!this.iCz) {
            AppMethodBeat.o(42785);
        } else {
            aTV.onSdcardMount(com.tencent.mm.compatible.util.e.apn());
            AppMethodBeat.o(42785);
        }
    }

    @Override // com.tencent.mm.kernel.api.f
    public void FU(String str) {
    }

    @Override // com.tencent.mm.kernel.api.h
    public final void aAq() {
        AppMethodBeat.i(42786);
        aTV();
        AppMethodBeat.o(42786);
    }

    public String toString() {
        AppMethodBeat.i(42787);
        String str = super.toString() + " " + this.iCx + " " + this.iCw + " " + this.iCy;
        AppMethodBeat.o(42787);
        return str;
    }

    public static <T extends bd> T at(Class<T> cls) {
        AppMethodBeat.i(42781);
        y Il = Il(cls.getName());
        if (Il == null) {
            Il = new y(cls);
            a(cls.getName(), Il);
        }
        T t = (T) Il.aTV();
        AppMethodBeat.o(42781);
        return t;
    }
}

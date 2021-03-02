package com.tencent.mm.plugin.clean.c;

import android.os.StatFs;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bd;
import com.tencent.mm.plugin.f.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storagebase.h;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public final class d implements bd {
    private static d qpN;
    public long cacheSize;
    public long dataSize;
    public LinkedList<String> pQk;
    public List<Runnable> pQl = new ArrayList();
    public long qpK;
    public HashMap<String, Long> qpL;
    public HashSet<String> qpM;
    public long qpu;
    public long qpv;

    public static d cyM() {
        AppMethodBeat.i(22827);
        if (qpN == null) {
            qpN = new d();
        }
        d dVar = qpN;
        AppMethodBeat.o(22827);
        return dVar;
    }

    private d() {
        AppMethodBeat.i(231658);
        AppMethodBeat.o(231658);
    }

    @Override // com.tencent.mm.model.bd
    public final HashMap<Integer, h.b> getBaseDBFactories() {
        return null;
    }

    @Override // com.tencent.mm.model.bd
    public final void clearPluginData(int i2) {
        AppMethodBeat.i(22828);
        a.cyK();
        AppMethodBeat.o(22828);
    }

    @Override // com.tencent.mm.model.bd
    public final void onAccountPostReset(boolean z) {
        AppMethodBeat.i(22829);
        Log.i("MicroMsg.SubCoreClean", "summerclean onAccountPostReset updated[%b]", Boolean.valueOf(z));
        b.crW().onAccountInitialized(null);
        AppMethodBeat.o(22829);
    }

    @Override // com.tencent.mm.model.bd
    public final void onSdcardMount(boolean z) {
        AppMethodBeat.i(22830);
        Log.i("MicroMsg.SubCoreClean", "summerclean onSdcardMount mounted[%b]", Boolean.valueOf(z));
        AppMethodBeat.o(22830);
    }

    @Override // com.tencent.mm.model.bd
    public final void onAccountRelease() {
        AppMethodBeat.i(22831);
        Log.i("MicroMsg.SubCoreClean", "summerclean onAccountRelease");
        this.qpK = 0;
        this.dataSize = 0;
        this.qpu = 0;
        this.qpv = 0;
        if (this.qpL != null) {
            this.qpL.clear();
        }
        if (this.qpM != null) {
            this.qpM.clear();
        }
        a.cyK();
        b.crW().onAccountRelease();
        AppMethodBeat.o(22831);
    }

    public static long cyN() {
        long j2;
        AppMethodBeat.i(22832);
        try {
            StatFs statFs = new StatFs(com.tencent.mm.loader.j.b.aKD());
            j2 = ((long) statFs.getBlockSize()) * ((long) statFs.getBlockCount());
        } catch (Exception e2) {
            j2 = 0;
        }
        Log.i("MicroMsg.SubCoreClean", "getSdcardFullSize:%d", Long.valueOf(j2));
        if (j2 <= 0) {
            AppMethodBeat.o(22832);
            return 1;
        }
        AppMethodBeat.o(22832);
        return j2;
    }

    public static long cyO() {
        long j2;
        AppMethodBeat.i(22833);
        try {
            StatFs statFs = new StatFs(com.tencent.mm.loader.j.b.aKD());
            j2 = ((long) statFs.getBlockSize()) * ((long) statFs.getAvailableBlocks());
        } catch (Exception e2) {
            j2 = 0;
        }
        if (j2 <= 0) {
            AppMethodBeat.o(22833);
            return 1;
        }
        AppMethodBeat.o(22833);
        return j2;
    }

    public static void cyP() {
        AppMethodBeat.i(22834);
        b.crW().crY();
        AppMethodBeat.o(22834);
    }
}

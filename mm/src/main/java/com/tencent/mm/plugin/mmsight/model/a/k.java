package com.tencent.mm.plugin.mmsight.model.a;

import android.app.ActivityManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.memory.a;
import com.tencent.mm.memory.d;
import com.tencent.mm.memory.f;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.tinker.loader.hotplug.EnvConsts;

public final class k extends a<byte[]> {
    private static int jtg = 0;
    public static final k zwi = new k();

    @Override // com.tencent.mm.memory.e
    public final /* synthetic */ void bU(Object obj) {
        AppMethodBeat.i(148831);
        k((byte[]) obj);
        AppMethodBeat.o(148831);
    }

    @Override // com.tencent.mm.memory.e
    public final /* bridge */ /* synthetic */ long bV(Object obj) {
        return (long) ((byte[]) obj).length;
    }

    /* Return type fixed from 'java.lang.Comparable' to match base method */
    @Override // com.tencent.mm.memory.e
    public final /* synthetic */ Integer bW(Object obj) {
        AppMethodBeat.i(148832);
        byte[] bArr = (byte[]) obj;
        if (bArr == null || bArr.length <= 0) {
            AppMethodBeat.o(148832);
            return 0;
        }
        Integer valueOf = Integer.valueOf(bArr.length);
        AppMethodBeat.o(148832);
        return valueOf;
    }

    /* Return type fixed from 'java.lang.Comparable' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Comparable] */
    @Override // com.tencent.mm.memory.e
    public final /* bridge */ /* synthetic */ Integer c(Integer num) {
        return num;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Comparable] */
    @Override // com.tencent.mm.memory.e
    public final /* synthetic */ d d(Integer num) {
        AppMethodBeat.i(148833);
        f fVar = new f(num.intValue());
        AppMethodBeat.o(148833);
        return fVar;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Comparable] */
    @Override // com.tencent.mm.memory.e
    public final /* synthetic */ Object e(Integer num) {
        AppMethodBeat.i(148834);
        byte[] bArr = new byte[num.intValue()];
        AppMethodBeat.o(148834);
        return bArr;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.tencent.mm.memory.a
    public final /* synthetic */ byte[] e(Integer num) {
        AppMethodBeat.i(148830);
        byte[] h2 = h(num);
        AppMethodBeat.o(148830);
        return h2;
    }

    static {
        AppMethodBeat.i(148835);
        AppMethodBeat.o(148835);
    }

    private k() {
    }

    public final synchronized void k(byte[] bArr) {
        AppMethodBeat.i(148826);
        super.bU(bArr);
        AppMethodBeat.o(148826);
    }

    public final synchronized byte[] h(Integer num) {
        byte[] bArr;
        AppMethodBeat.i(148827);
        bArr = (byte[]) super.e(num);
        if (bArr == null) {
            bArr = new byte[num.intValue()];
        }
        AppMethodBeat.o(148827);
        return bArr;
    }

    @Override // com.tencent.mm.memory.e
    public final long aRP() {
        AppMethodBeat.i(148828);
        if (jtg <= 0) {
            jtg = ((ActivityManager) MMApplicationContext.getContext().getSystemService(EnvConsts.ACTIVITY_MANAGER_SRVNAME)).getLargeMemoryClass();
        }
        if (jtg >= 512) {
            AppMethodBeat.o(148828);
            return 41943040;
        }
        AppMethodBeat.o(148828);
        return 20971520;
    }

    @Override // com.tencent.mm.memory.e
    public final long aRQ() {
        return 10485760;
    }

    @Override // com.tencent.mm.memory.e
    public final void aRR() {
        AppMethodBeat.i(148829);
        super.aRR();
        AppMethodBeat.o(148829);
    }
}

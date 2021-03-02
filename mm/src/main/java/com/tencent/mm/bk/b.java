package com.tencent.mm.bk;

import android.app.ActivityManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.memory.a;
import com.tencent.mm.memory.d;
import com.tencent.mm.memory.f;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.tinker.loader.hotplug.EnvConsts;

public final class b extends a<byte[]> {
    public static final b jtf = new b();
    private static int jtg = 0;

    @Override // com.tencent.mm.memory.e
    public final /* synthetic */ void bU(Object obj) {
        AppMethodBeat.i(127061);
        k((byte[]) obj);
        AppMethodBeat.o(127061);
    }

    @Override // com.tencent.mm.memory.e
    public final /* bridge */ /* synthetic */ long bV(Object obj) {
        return (long) ((byte[]) obj).length;
    }

    /* Return type fixed from 'java.lang.Comparable' to match base method */
    @Override // com.tencent.mm.memory.e
    public final /* synthetic */ Integer bW(Object obj) {
        AppMethodBeat.i(127062);
        byte[] bArr = (byte[]) obj;
        if (bArr == null || bArr.length <= 0) {
            AppMethodBeat.o(127062);
            return 0;
        }
        Integer valueOf = Integer.valueOf(bArr.length);
        AppMethodBeat.o(127062);
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
        AppMethodBeat.i(127063);
        f fVar = new f(num.intValue());
        AppMethodBeat.o(127063);
        return fVar;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Comparable] */
    @Override // com.tencent.mm.memory.e
    public final /* synthetic */ Object e(Integer num) {
        AppMethodBeat.i(127064);
        byte[] bArr = new byte[num.intValue()];
        AppMethodBeat.o(127064);
        return bArr;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.tencent.mm.memory.a
    public final /* synthetic */ byte[] e(Integer num) {
        AppMethodBeat.i(127060);
        byte[] h2 = h(num);
        AppMethodBeat.o(127060);
        return h2;
    }

    static {
        AppMethodBeat.i(127065);
        AppMethodBeat.o(127065);
    }

    private b() {
    }

    public final synchronized void k(byte[] bArr) {
        AppMethodBeat.i(127056);
        super.bU(bArr);
        AppMethodBeat.o(127056);
    }

    public final synchronized byte[] h(Integer num) {
        byte[] bArr;
        AppMethodBeat.i(127057);
        bArr = (byte[]) super.e(num);
        if (bArr == null) {
            bArr = new byte[num.intValue()];
        }
        AppMethodBeat.o(127057);
        return bArr;
    }

    @Override // com.tencent.mm.memory.e
    public final long aRP() {
        AppMethodBeat.i(127058);
        if (jtg <= 0) {
            jtg = ((ActivityManager) MMApplicationContext.getContext().getSystemService(EnvConsts.ACTIVITY_MANAGER_SRVNAME)).getLargeMemoryClass();
        }
        if (jtg >= 512) {
            AppMethodBeat.o(127058);
            return 41943040;
        }
        AppMethodBeat.o(127058);
        return 20971520;
    }

    @Override // com.tencent.mm.memory.e
    public final long aRQ() {
        return 10485760;
    }

    @Override // com.tencent.mm.memory.e
    public final void aRR() {
        AppMethodBeat.i(127059);
        super.aRR();
        AppMethodBeat.o(127059);
    }
}

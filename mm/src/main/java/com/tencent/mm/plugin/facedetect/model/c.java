package com.tencent.mm.plugin.facedetect.model;

import android.app.ActivityManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.memory.a;
import com.tencent.mm.memory.d;
import com.tencent.mm.memory.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.tinker.loader.hotplug.EnvConsts;

public final class c extends a<byte[]> {
    private static int jtg = 0;
    public static final c sQB = new c();

    @Override // com.tencent.mm.memory.e
    public final /* synthetic */ void bU(Object obj) {
        AppMethodBeat.i(103692);
        k((byte[]) obj);
        AppMethodBeat.o(103692);
    }

    @Override // com.tencent.mm.memory.e
    public final /* bridge */ /* synthetic */ long bV(Object obj) {
        return (long) ((byte[]) obj).length;
    }

    /* Return type fixed from 'java.lang.Comparable' to match base method */
    @Override // com.tencent.mm.memory.e
    public final /* synthetic */ Integer bW(Object obj) {
        AppMethodBeat.i(103693);
        byte[] bArr = (byte[]) obj;
        if (bArr == null || bArr.length <= 0) {
            AppMethodBeat.o(103693);
            return 0;
        }
        Integer valueOf = Integer.valueOf(bArr.length);
        AppMethodBeat.o(103693);
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
        AppMethodBeat.i(103694);
        f fVar = new f(num.intValue());
        AppMethodBeat.o(103694);
        return fVar;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Comparable] */
    @Override // com.tencent.mm.memory.e
    public final /* synthetic */ Object e(Integer num) {
        AppMethodBeat.i(103695);
        byte[] bArr = new byte[num.intValue()];
        AppMethodBeat.o(103695);
        return bArr;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.tencent.mm.memory.a
    public final /* synthetic */ byte[] e(Integer num) {
        AppMethodBeat.i(103691);
        byte[] h2 = h(num);
        AppMethodBeat.o(103691);
        return h2;
    }

    static {
        AppMethodBeat.i(103696);
        AppMethodBeat.o(103696);
    }

    public static void dj(int i2, int i3) {
        AppMethodBeat.i(103686);
        Log.i("MicroMsg.FaceByteArrayPool", "preloadCameraData, width: %s, height: %s, count: %s", Integer.valueOf(i2), Integer.valueOf(i3), 5);
        long currentTicks = Util.currentTicks();
        for (int i4 = 0; i4 < 5; i4++) {
            sQB.k(new byte[(((i2 * i3) * 3) / 2)]);
        }
        Log.i("MicroMsg.FaceByteArrayPool", "preloadCameraData used %sms", Long.valueOf(Util.ticksToNow(currentTicks)));
        AppMethodBeat.o(103686);
    }

    private c() {
    }

    public final synchronized void k(byte[] bArr) {
        AppMethodBeat.i(103687);
        super.bU(bArr);
        AppMethodBeat.o(103687);
    }

    public final synchronized byte[] h(Integer num) {
        byte[] bArr;
        AppMethodBeat.i(103688);
        bArr = (byte[]) super.e(num);
        if (bArr == null) {
            Log.v("MicroMsg.FaceByteArrayPool", "hy: getExactSize no data");
            bArr = new byte[num.intValue()];
        } else {
            Log.v("MicroMsg.FaceByteArrayPool", "hy: got exactSize data");
        }
        AppMethodBeat.o(103688);
        return bArr;
    }

    @Override // com.tencent.mm.memory.e
    public final long aRP() {
        AppMethodBeat.i(103689);
        if (jtg <= 0) {
            jtg = ((ActivityManager) MMApplicationContext.getContext().getSystemService(EnvConsts.ACTIVITY_MANAGER_SRVNAME)).getLargeMemoryClass();
        }
        if (jtg >= 512) {
            AppMethodBeat.o(103689);
            return 20971520;
        }
        AppMethodBeat.o(103689);
        return 10485760;
    }

    @Override // com.tencent.mm.memory.e
    public final long aRQ() {
        return 20971520;
    }

    @Override // com.tencent.mm.memory.e
    public final void aRR() {
        AppMethodBeat.i(103690);
        super.aRR();
        AppMethodBeat.o(103690);
    }
}

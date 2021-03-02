package com.tencent.mm.memory;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.tinker.loader.hotplug.EnvConsts;

public final class c extends a<Bitmap> {
    private static int itq = 20971520;
    public static final c itr = new c();

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Comparable] */
    @Override // com.tencent.mm.memory.a, com.tencent.mm.memory.e
    public final /* synthetic */ Object b(Integer num) {
        AppMethodBeat.i(156414);
        Bitmap g2 = g(num);
        AppMethodBeat.o(156414);
        return g2;
    }

    @Override // com.tencent.mm.memory.e
    public final /* synthetic */ void bU(Object obj) {
        AppMethodBeat.i(156408);
        f((Bitmap) obj);
        AppMethodBeat.o(156408);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.memory.e
    @TargetApi(19)
    public final /* synthetic */ long bV(Object obj) {
        int allocationByteCount;
        AppMethodBeat.i(156410);
        Bitmap bitmap = (Bitmap) obj;
        if (bitmap == null) {
            AppMethodBeat.o(156410);
            return 0;
        }
        if (d.oE(19)) {
            allocationByteCount = bitmap.getByteCount();
        } else {
            allocationByteCount = bitmap.getAllocationByteCount();
        }
        long j2 = (long) allocationByteCount;
        AppMethodBeat.o(156410);
        return j2;
    }

    /* Return type fixed from 'java.lang.Comparable' to match base method */
    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.memory.e
    public final /* synthetic */ Integer bW(Object obj) {
        AppMethodBeat.i(156411);
        Integer G = G((Bitmap) obj);
        AppMethodBeat.o(156411);
        return G;
    }

    /* Return type fixed from 'java.lang.Comparable' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Comparable] */
    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.memory.e
    public final /* synthetic */ Integer c(Integer num) {
        AppMethodBeat.i(156409);
        Integer f2 = f(num);
        AppMethodBeat.o(156409);
        return f2;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Comparable] */
    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.memory.e
    public final /* synthetic */ d d(Integer num) {
        AppMethodBeat.i(156412);
        b bVar = new b(num.intValue());
        AppMethodBeat.o(156412);
        return bVar;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.tencent.mm.memory.a
    public final /* synthetic */ Bitmap d(Integer num) {
        AppMethodBeat.i(156407);
        Bitmap g2 = g(num);
        AppMethodBeat.o(156407);
        return g2;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Comparable] */
    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.memory.e
    public final /* synthetic */ Object e(Integer num) {
        AppMethodBeat.i(156413);
        Bitmap createBitmap = Bitmap.createBitmap(1, num.intValue(), k.itA);
        AppMethodBeat.o(156413);
        return createBitmap;
    }

    static {
        AppMethodBeat.i(156415);
        AppMethodBeat.o(156415);
    }

    private c() {
        AppMethodBeat.i(156401);
        int largeMemoryClass = ((ActivityManager) MMApplicationContext.getContext().getSystemService(EnvConsts.ACTIVITY_MANAGER_SRVNAME)).getLargeMemoryClass();
        Log.i("MicroMsg.BitmapPool", "BitmapPool %dMB", Integer.valueOf(largeMemoryClass));
        if (largeMemoryClass > 256) {
            itq = 20971520;
        } else if (largeMemoryClass > 128) {
            itq = 10485760;
        } else {
            itq = 5242880;
        }
        YU();
        AppMethodBeat.o(156401);
    }

    protected static Integer f(Integer num) {
        AppMethodBeat.i(156402);
        Integer valueOf = Integer.valueOf(num.intValue() * 4);
        AppMethodBeat.o(156402);
        return valueOf;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.memory.e
    public final long aRP() {
        return (long) itq;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.memory.e
    public final long aRQ() {
        return 1048576;
    }

    public final synchronized Bitmap g(Integer num) {
        Bitmap bitmap;
        AppMethodBeat.i(156403);
        bitmap = (Bitmap) super.b(num);
        if (bitmap == null || bitmap.isRecycled() || !bitmap.isMutable()) {
            bitmap = null;
            AppMethodBeat.o(156403);
        } else {
            Log.d("MicroMsg.BitmapPool", "get stored element: %s, width: %s, height: %s, size: %s, requireSize: %s", bitmap, Integer.valueOf(bitmap.getWidth()), Integer.valueOf(bitmap.getHeight()), G(bitmap), num);
            AppMethodBeat.o(156403);
        }
        return bitmap;
    }

    private static Integer G(Bitmap bitmap) {
        int allocationByteCount;
        AppMethodBeat.i(156404);
        if (bitmap == null) {
            AppMethodBeat.o(156404);
            return 0;
        }
        if (d.oE(19)) {
            allocationByteCount = bitmap.getByteCount();
        } else {
            allocationByteCount = bitmap.getAllocationByteCount();
        }
        Integer valueOf = Integer.valueOf(allocationByteCount);
        AppMethodBeat.o(156404);
        return valueOf;
    }

    public final synchronized void f(Bitmap bitmap) {
        AppMethodBeat.i(156405);
        if (bitmap != null && bitmap.isMutable() && !bitmap.isRecycled()) {
            Log.i("MicroMsg.BitmapPool", "release: %s", bitmap);
            super.bU(bitmap);
        }
        AppMethodBeat.o(156405);
    }

    @Override // com.tencent.mm.memory.e
    public final void aRR() {
        AppMethodBeat.i(156406);
        super.aRR();
        AppMethodBeat.o(156406);
    }
}

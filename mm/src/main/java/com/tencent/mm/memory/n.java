package com.tencent.mm.memory;

import android.graphics.Bitmap;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class n implements i {
    private static ConcurrentHashMap<Bitmap, Integer> itH = new ConcurrentHashMap<>();
    private boolean DEBUG = false;
    private boolean bNd = true;
    public Bitmap bitmap = null;
    private MMHandler hAk = new MMHandler(Looper.getMainLooper());
    private boolean itF = false;
    private AtomicInteger itG = new AtomicInteger();
    private Runnable itI = new Runnable() {
        /* class com.tencent.mm.memory.n.AnonymousClass1 */

        public final void run() {
            AppMethodBeat.i(156437);
            n.a(n.this);
            AppMethodBeat.o(156437);
        }
    };
    private int itJ = 0;
    private int itK = 0;

    static /* synthetic */ boolean a(n nVar) {
        AppMethodBeat.i(156451);
        boolean aSd = nVar.aSd();
        AppMethodBeat.o(156451);
        return aSd;
    }

    static {
        AppMethodBeat.i(156452);
        AppMethodBeat.o(156452);
    }

    private n(Bitmap bitmap2) {
        AppMethodBeat.i(156438);
        this.bitmap = bitmap2;
        this.itG.set(1);
        if (this.DEBUG) {
            Log.i("MicroMsg.ReleasableBitmap", "bitmap " + bitmap2 + " " + this.bitmap.hashCode() + " mm: " + hashCode() + " this: " + this + " " + Util.getStack().toString());
        }
        this.itF = false;
        getAllocationByteCount();
        AppMethodBeat.o(156438);
    }

    public static n H(Bitmap bitmap2) {
        AppMethodBeat.i(156439);
        if (bitmap2 == null) {
            AppMethodBeat.o(156439);
            return null;
        }
        n nVar = new n(bitmap2);
        AppMethodBeat.o(156439);
        return nVar;
    }

    public final Bitmap aSa() {
        this.bNd = false;
        return this.bitmap;
    }

    @Override // com.tencent.mm.memory.i
    public final void aRW() {
        AppMethodBeat.i(156440);
        this.itG.incrementAndGet();
        if (this.DEBUG) {
            Log.i("MicroMsg.ReleasableBitmap", "addLiveReference, attachCount:" + this.itG + " bitmap:" + this.bitmap + " " + this + " " + Util.getStack().toString());
        }
        AppMethodBeat.o(156440);
    }

    @Override // com.tencent.mm.memory.i
    public final void aRX() {
        AppMethodBeat.i(156441);
        if (this.DEBUG) {
            Log.i("MicroMsg.ReleasableBitmap", "removeLiveReference, attachCount:" + this.itG + " bitmap:" + this.bitmap + " " + this + " " + Util.getStack().toString());
        }
        if (this.itG.get() > 0) {
            this.itG.decrementAndGet();
            if (this.itG.get() < 0) {
                AppMethodBeat.o(156441);
                return;
            } else {
                this.hAk.removeCallbacks(this.itI);
                this.hAk.postDelayed(this.itI, 500);
            }
        }
        AppMethodBeat.o(156441);
    }

    public final Bitmap aSb() {
        AppMethodBeat.i(156442);
        if (this.DEBUG) {
            Log.i("MicroMsg.ReleasableBitmap", "getBitmapReadOnly " + toString() + " " + Util.getStack().toString());
        }
        Bitmap bitmap2 = this.bitmap;
        AppMethodBeat.o(156442);
        return bitmap2;
    }

    public final boolean isRecycled() {
        AppMethodBeat.i(156443);
        if (this.itF || this.bitmap == null || this.bitmap.isRecycled()) {
            AppMethodBeat.o(156443);
            return true;
        }
        AppMethodBeat.o(156443);
        return false;
    }

    public final boolean aSc() {
        AppMethodBeat.i(156444);
        this.itG.decrementAndGet();
        if (this.DEBUG) {
            Log.i("MicroMsg.ReleasableBitmap", "recycle~:" + this.itF + " isMutable:" + this.bNd + " bitmap:" + this.bitmap + " " + hashCode() + " attachCount: " + this.itG + Util.getStack().toString());
        }
        aSd();
        AppMethodBeat.o(156444);
        return true;
    }

    private boolean aSd() {
        AppMethodBeat.i(156445);
        if (this.DEBUG) {
            Log.i("MicroMsg.ReleasableBitmap", "recycleImpl~:" + this.itF + " isMutable:" + this.bNd + " bitmap:" + this.bitmap + " " + hashCode() + " attachCount: " + this.itG + Util.getStack().toString());
        }
        if (this.itF || this.itG.get() > 0) {
            AppMethodBeat.o(156445);
            return false;
        }
        this.itF = true;
        if (this.DEBUG) {
            itH.remove(this.bitmap);
        }
        if (this.bNd) {
            l.aRY().x(this.bitmap);
        }
        AppMethodBeat.o(156445);
        return true;
    }

    private final int aSe() {
        AppMethodBeat.i(156446);
        if (this.bitmap == null || this.bitmap.isRecycled()) {
            Log.i("MicroMsg.ReleasableBitmap", "getByteCount recycle " + this.itJ + " " + toString());
            int i2 = this.itJ;
            AppMethodBeat.o(156446);
            return i2;
        }
        this.itJ = this.bitmap.getByteCount();
        int i3 = this.itJ;
        AppMethodBeat.o(156446);
        return i3;
    }

    public final int getAllocationByteCount() {
        AppMethodBeat.i(156447);
        if (d.oE(19)) {
            int aSe = aSe();
            AppMethodBeat.o(156447);
            return aSe;
        } else if (this.bitmap == null || this.bitmap.isRecycled()) {
            Log.i("MicroMsg.ReleasableBitmap", "getAllocationByteCount recycle " + this.itK + " " + toString());
            int i2 = this.itK;
            AppMethodBeat.o(156447);
            return i2;
        } else {
            this.itK = this.bitmap.getAllocationByteCount();
            int i3 = this.itK;
            AppMethodBeat.o(156447);
            return i3;
        }
    }

    public String toString() {
        AppMethodBeat.i(156448);
        if (this.DEBUG) {
            String str = super.toString() + " code: " + hashCode() + " attachCount: " + this.itG;
            if (this.bitmap != null) {
                str = str + this.bitmap;
            }
            AppMethodBeat.o(156448);
            return str;
        }
        String obj = super.toString();
        AppMethodBeat.o(156448);
        return obj;
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        AppMethodBeat.i(156449);
        if (this.DEBUG) {
            Log.i("MicroMsg.ReleasableBitmap", "bitmap finalize " + toString());
        }
        AppMethodBeat.o(156449);
    }

    public final String aSf() {
        AppMethodBeat.i(156450);
        String str = this + " " + this.bitmap;
        AppMethodBeat.o(156450);
        return str;
    }
}

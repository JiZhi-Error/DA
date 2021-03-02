package com.tencent.mm.platformtools;

import android.graphics.Bitmap;
import android.util.DisplayMetrics;
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ay;
import com.tencent.mm.platformtools.s;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.QueueWorkerThread;
import com.tencent.mm.sdk.platformtools.Util;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Vector;
import junit.framework.Assert;

public final class u {
    private static Vector<WeakReference<a>> jNk = new Vector<>();
    private static LinkedList<a> jNl = new LinkedList<>();

    public interface a {
        void k(String str, Bitmap bitmap);
    }

    static /* synthetic */ boolean c(s sVar) {
        AppMethodBeat.i(151412);
        boolean b2 = b(sVar);
        AppMethodBeat.o(151412);
        return b2;
    }

    static {
        AppMethodBeat.i(151414);
        AppMethodBeat.o(151414);
    }

    public static boolean a(a aVar) {
        AppMethodBeat.i(151404);
        boolean add = jNk.add(new WeakReference<>(aVar));
        AppMethodBeat.o(151404);
        return add;
    }

    public static boolean b(a aVar) {
        AppMethodBeat.i(151405);
        jNl.remove(aVar);
        boolean add = jNl.add(aVar);
        AppMethodBeat.o(151405);
        return add;
    }

    public static boolean c(a aVar) {
        AppMethodBeat.i(151406);
        boolean remove = jNl.remove(aVar);
        AppMethodBeat.o(151406);
        return remove;
    }

    public static Bitmap a(s sVar) {
        AppMethodBeat.i(151407);
        if (!b(sVar)) {
            AppMethodBeat.o(151407);
            return null;
        }
        e aAh = g.aAh();
        if (aAh.hqW == null) {
            aAh.hqW = Boolean.valueOf(aAh.isSDCardAvailable());
        } else {
            long currentTimeMillis = System.currentTimeMillis() - aAh.hqY;
            if (currentTimeMillis <= 0 || currentTimeMillis >= 1000) {
                e.a aVar = aAh.hqX;
                if (aVar.dBz != null && !aVar.dBz.isDone()) {
                    aVar.dBz.cancel(false);
                }
                h.RTc.o(aAh.hqX, 1000);
                aAh.hqY = System.currentTimeMillis();
            }
        }
        if (!aAh.hqW.booleanValue()) {
            Bitmap blF = sVar.blF();
            AppMethodBeat.o(151407);
            return blF;
        } else if (sVar.blE()) {
            Bitmap a2 = b.a(b.INSTANCE, sVar);
            AppMethodBeat.o(151407);
            return a2;
        } else {
            Bitmap b2 = b.b(b.INSTANCE, sVar);
            AppMethodBeat.o(151407);
            return b2;
        }
    }

    public static Bitmap Sq(String str) {
        AppMethodBeat.i(151408);
        Bitmap Sq = b.Sq(str);
        AppMethodBeat.o(151408);
        return Sq;
    }

    public static Bitmap x(String str, int i2, int i3) {
        AppMethodBeat.i(151409);
        Bitmap x = b.x(str, i2, i3);
        AppMethodBeat.o(151409);
        return x;
    }

    public static Bitmap Sr(String str) {
        AppMethodBeat.i(151410);
        Bitmap Sr = b.Sr(str);
        AppMethodBeat.o(151410);
        return Sr;
    }

    private static boolean b(s sVar) {
        AppMethodBeat.i(151411);
        if (sVar == null || Util.isNullOrNil(sVar.blB())) {
            AppMethodBeat.o(151411);
            return false;
        }
        AppMethodBeat.o(151411);
        return true;
    }

    /* access modifiers changed from: package-private */
    public enum b {
        INSTANCE;
        
        private static DisplayMetrics metrics = null;
        private Map<String, c> jNn = new HashMap();
        private Map<String, WeakReference<Bitmap>> jNo = new HashMap();
        private QueueWorkerThread jNp = null;
        private QueueWorkerThread jNq = null;

        private b(String str) {
            AppMethodBeat.i(151391);
            AppMethodBeat.o(151391);
        }

        static /* synthetic */ void a(b bVar, s sVar, Bitmap bitmap) {
            AppMethodBeat.i(151402);
            bVar.b(sVar, bitmap);
            AppMethodBeat.o(151402);
        }

        public static b valueOf(String str) {
            AppMethodBeat.i(151390);
            b bVar = (b) Enum.valueOf(b.class, str);
            AppMethodBeat.o(151390);
            return bVar;
        }

        static {
            AppMethodBeat.i(151403);
            AppMethodBeat.o(151403);
        }

        /* access modifiers changed from: package-private */
        public static class c {
            boolean jNu;
            int jNv;
            int jNw;

            c() {
            }

            public final String toString() {
                AppMethodBeat.i(151388);
                StringBuilder sb = new StringBuilder();
                sb.append("fail[").append(this.jNu).append("],");
                sb.append("tryTimes[").append(this.jNv).append("],");
                sb.append("lastTS[").append(this.jNw).append("]");
                String sb2 = sb.toString();
                AppMethodBeat.o(151388);
                return sb2;
            }
        }

        private Bitmap d(s sVar) {
            Bitmap Sq;
            AppMethodBeat.i(151392);
            Assert.assertTrue("picture strategy here must be validity", u.c(sVar));
            String blB = sVar.blB();
            c cVar = this.jNn.get(blB);
            if (cVar == null) {
                cVar = new c();
            }
            if (cVar.jNu) {
                if (cVar.jNv < 3) {
                    cVar.jNv++;
                } else if (Util.secondsToNow((long) cVar.jNw) < 120) {
                    Log.w("MicroMsg.MMPictureLogic", "download fail interval less than %d s for %s", 120, blB);
                    AppMethodBeat.o(151392);
                    return null;
                } else {
                    cVar.jNv = 0;
                }
                cVar.jNu = false;
                cVar.jNw = (int) Util.nowSecond();
                this.jNn.put(blB, cVar);
            } else if (Util.secondsToNow((long) cVar.jNw) < 120) {
                Log.d("MicroMsg.MMPictureLogic", "downloading interval less than %d s for %s", 120, blB);
                AppMethodBeat.o(151392);
                return null;
            } else {
                cVar.jNv++;
                cVar.jNw = (int) Util.nowSecond();
                this.jNn.put(blB, cVar);
            }
            if (sVar.blD()) {
                s.b blz = sVar.blz();
                if (blz != null) {
                    Sq = blz.So(sVar.blA());
                } else {
                    Sq = Sq(sVar.blA());
                }
                if (Sq != null) {
                    Bitmap a2 = a(sVar, Sq);
                    this.jNn.remove(blB);
                    AppMethodBeat.o(151392);
                    return a2;
                }
                if (this.jNp == null || this.jNp.isDead()) {
                    this.jNp = new QueueWorkerThread(1, "readerapp-pic-logic-download", 3);
                }
                this.jNp.add(new a(sVar));
                AppMethodBeat.o(151392);
                return null;
            }
            if (this.jNq == null || this.jNq.isDead()) {
                this.jNq = new QueueWorkerThread(1, "readerapp-pic-logic-reader", 1);
            }
            this.jNq.add(new C0507b(sVar));
            AppMethodBeat.o(151392);
            return null;
        }

        /* access modifiers changed from: protected */
        public final Bitmap a(s sVar, Bitmap bitmap) {
            AppMethodBeat.i(151393);
            Assert.assertTrue("picture strategy here must be validity", u.c(sVar));
            if (bitmap != null) {
                Bitmap a2 = sVar.a(bitmap, s.a.DISK, sVar.blA());
                if (a2 != bitmap && !bitmap.isRecycled()) {
                    Log.i("MicroMsg.MMPictureLogic", "recycle bitmap:%s", bitmap.toString());
                    bitmap.recycle();
                }
                b(sVar, a2);
                bitmap = a2;
            } else {
                sVar.a(s.a.DISK, null);
            }
            AppMethodBeat.o(151393);
            return bitmap;
        }

        private void b(s sVar, Bitmap bitmap) {
            AppMethodBeat.i(151394);
            Assert.assertTrue("picture strategy here must be validity", u.c(sVar));
            String cacheKey = sVar.getCacheKey();
            Bitmap bitmap2 = this.jNo.containsKey(cacheKey) ? this.jNo.get(cacheKey).get() : null;
            if (bitmap2 == null || bitmap2.isRecycled()) {
                this.jNo.remove(cacheKey);
                this.jNo.put(cacheKey, new WeakReference<>(bitmap));
            }
            AppMethodBeat.o(151394);
        }

        private static DisplayMetrics getDefaultDisplayMetrics() {
            AppMethodBeat.i(151395);
            if (metrics == null) {
                metrics = MMApplicationContext.getContext().getResources().getDisplayMetrics();
            }
            DisplayMetrics displayMetrics = metrics;
            AppMethodBeat.o(151395);
            return displayMetrics;
        }

        public static Bitmap x(String str, int i2, int i3) {
            AppMethodBeat.i(151396);
            if (Util.isNullOrNil(str)) {
                Log.w("MicroMsg.MMPictureLogic", "error input, path is null");
                AppMethodBeat.o(151396);
                return null;
            } else if (i2 <= 0 || i3 <= 0) {
                Log.w("MicroMsg.MMPictureLogic", "error input, targetWidth %d, targetHeight %d", Integer.valueOf(i2), Integer.valueOf(i3));
                AppMethodBeat.o(151396);
                return null;
            } else {
                Bitmap bitmapNative = BitmapUtil.getBitmapNative(str, i2, i3);
                AppMethodBeat.o(151396);
                return bitmapNative;
            }
        }

        public static Bitmap Sq(String str) {
            AppMethodBeat.i(151397);
            DisplayMetrics defaultDisplayMetrics = getDefaultDisplayMetrics();
            Bitmap x = x(str, defaultDisplayMetrics.widthPixels, defaultDisplayMetrics.heightPixels);
            AppMethodBeat.o(151397);
            return x;
        }

        public static Bitmap Sr(String str) {
            AppMethodBeat.i(151398);
            if (Util.isNullOrNil(str)) {
                Log.w("MicroMsg.MMPictureLogic", "error input, path is null");
                AppMethodBeat.o(151398);
                return null;
            }
            Bitmap bitmapNative = BitmapUtil.getBitmapNative(str, 0, 0);
            AppMethodBeat.o(151398);
            return bitmapNative;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: com.tencent.mm.platformtools.u$b$b  reason: collision with other inner class name */
        public static class C0507b implements QueueWorkerThread.ThreadObject {
            public Bitmap iKs = null;
            private s jNt;

            public C0507b(s sVar) {
                AppMethodBeat.i(151385);
                if (!u.c(sVar)) {
                    IllegalArgumentException illegalArgumentException = new IllegalArgumentException("from sdcard, picture strategy here must be validity");
                    AppMethodBeat.o(151385);
                    throw illegalArgumentException;
                }
                this.jNt = sVar;
                AppMethodBeat.o(151385);
            }

            @Override // com.tencent.mm.sdk.platformtools.QueueWorkerThread.ThreadObject
            public final boolean doInBackground() {
                boolean z = false;
                AppMethodBeat.i(151386);
                this.iKs = b.Sq(this.jNt.blA());
                if (this.iKs != null) {
                    this.iKs = b.INSTANCE.a(this.jNt, this.iKs);
                }
                Object[] objArr = new Object[3];
                objArr[0] = this.jNt.blB();
                objArr[1] = this.jNt.blA();
                if (this.iKs != null) {
                    z = true;
                }
                objArr[2] = Boolean.valueOf(z);
                Log.v("MicroMsg.MMPictureLogic", "get url[%s] from[%s] result[%B]", objArr);
                AppMethodBeat.o(151386);
                return true;
            }

            @Override // com.tencent.mm.sdk.platformtools.QueueWorkerThread.ThreadObject
            public final boolean onPostExecute() {
                AppMethodBeat.i(151387);
                if (this.iKs == null) {
                    Log.d("MicroMsg.MMPictureLogic", "can not find bitmap on sdCard, url=%s, try to download it", this.jNt.blB());
                    if (b.INSTANCE.jNp == null || b.INSTANCE.jNp.isDead()) {
                        b.INSTANCE.jNp = new QueueWorkerThread(1, "readerapp-pic-logic-download", 3);
                    }
                    b.INSTANCE.jNp.add(new a(this.jNt));
                } else {
                    b.a(b.INSTANCE, this.jNt.blB(), this.jNt.blC(), this.iKs);
                    this.iKs = null;
                }
                AppMethodBeat.o(151387);
                return false;
            }
        }

        /* access modifiers changed from: package-private */
        public static class a implements QueueWorkerThread.ThreadObject {
            private Bitmap iKs = null;
            private int jNs = 0;
            private s jNt;

            public a(s sVar) {
                AppMethodBeat.i(151382);
                if (!u.c(sVar)) {
                    IllegalArgumentException illegalArgumentException = new IllegalArgumentException("from net, picture strategy here must be validity");
                    AppMethodBeat.o(151382);
                    throw illegalArgumentException;
                }
                this.jNt = sVar;
                AppMethodBeat.o(151382);
            }

            /* JADX WARNING: Removed duplicated region for block: B:42:0x0147 A[SYNTHETIC, Splitter:B:42:0x0147] */
            /* JADX WARNING: Removed duplicated region for block: B:45:0x014c A[SYNTHETIC, Splitter:B:45:0x014c] */
            /* JADX WARNING: Removed duplicated region for block: B:78:0x0295 A[SYNTHETIC, Splitter:B:78:0x0295] */
            /* JADX WARNING: Removed duplicated region for block: B:81:0x029a A[SYNTHETIC, Splitter:B:81:0x029a] */
            @Override // com.tencent.mm.sdk.platformtools.QueueWorkerThread.ThreadObject
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final boolean doInBackground() {
                /*
                // Method dump skipped, instructions count: 821
                */
                throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.platformtools.u.b.a.doInBackground():boolean");
            }

            @Override // com.tencent.mm.sdk.platformtools.QueueWorkerThread.ThreadObject
            public final boolean onPostExecute() {
                AppMethodBeat.i(151384);
                try {
                    ay.a.iDr.dl(this.jNs, 0);
                } catch (Exception e2) {
                    Log.e("MicroMsg.MMPictureLogic", "exception:%s", Util.stackTraceToString(e2));
                }
                b.a(b.INSTANCE, this.jNt.blB(), this.jNt.blC(), this.iKs);
                this.iKs = null;
                AppMethodBeat.o(151384);
                return false;
            }
        }

        static /* synthetic */ Bitmap a(b bVar, s sVar) {
            AppMethodBeat.i(151399);
            Assert.assertTrue("picture strategy here must be validity", u.c(sVar));
            WeakReference<Bitmap> weakReference = bVar.jNo.get(sVar.getCacheKey());
            if (weakReference != null) {
                Bitmap bitmap = weakReference.get();
                if (bitmap == null || bitmap.isRecycled()) {
                    AppMethodBeat.o(151399);
                    return null;
                }
                AppMethodBeat.o(151399);
                return bitmap;
            }
            AppMethodBeat.o(151399);
            return null;
        }

        static /* synthetic */ Bitmap b(b bVar, s sVar) {
            AppMethodBeat.i(151400);
            Assert.assertTrue("picture strategy here must be validity", u.c(sVar));
            WeakReference<Bitmap> weakReference = bVar.jNo.get(sVar.getCacheKey());
            if (weakReference != null) {
                Bitmap bitmap = weakReference.get();
                if (bitmap == null || bitmap.isRecycled()) {
                    Bitmap d2 = bVar.d(sVar);
                    AppMethodBeat.o(151400);
                    return d2;
                }
                AppMethodBeat.o(151400);
                return bitmap;
            }
            Bitmap d3 = bVar.d(sVar);
            AppMethodBeat.o(151400);
            return d3;
        }

        static /* synthetic */ void a(b bVar, String str, String str2, Bitmap bitmap) {
            AppMethodBeat.i(151401);
            a[] aVarArr = (a[]) u.jNl.toArray(new a[u.jNl.size()]);
            for (a aVar : aVarArr) {
                if (aVar != null) {
                    aVar.k(str2, bitmap);
                }
            }
            u.j(str2, bitmap);
            if (bitmap != null) {
                bVar.jNn.remove(str);
                AppMethodBeat.o(151401);
                return;
            }
            c cVar = bVar.jNn.get(str);
            if (cVar != null) {
                cVar.jNu = true;
            }
            AppMethodBeat.o(151401);
        }
    }

    static /* synthetic */ void j(String str, Bitmap bitmap) {
        AppMethodBeat.i(151413);
        Vector vector = new Vector();
        for (int i2 = 0; i2 < jNk.size(); i2++) {
            WeakReference<a> weakReference = jNk.get(i2);
            if (weakReference != null) {
                a aVar = weakReference.get();
                if (aVar != null) {
                    aVar.k(str, bitmap);
                } else {
                    vector.add(weakReference);
                }
            }
        }
        jNk.removeAll(vector);
        AppMethodBeat.o(151413);
    }
}

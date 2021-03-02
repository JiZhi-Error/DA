package com.tencent.mm.pluginsdk.ui.tools;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.os.Message;
import android.util.SparseArray;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.f;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.platformtools.s;
import com.tencent.mm.platformtools.u;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.thread.ThreadPool;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.LinkedList;

public class k {
    private u.a KvA = new u.a() {
        /* class com.tencent.mm.pluginsdk.ui.tools.k.AnonymousClass5 */

        @Override // com.tencent.mm.platformtools.u.a
        public final void k(String str, final Bitmap bitmap) {
            boolean z = false;
            AppMethodBeat.i(152400);
            Object[] objArr = new Object[2];
            objArr[0] = str;
            if (bitmap == null) {
                z = true;
            }
            objArr[1] = Boolean.valueOf(z);
            Log.v("MicroMsg.ImageEngine", "on get picture finish, notifyKey[%s], bitmap is null[%B]", objArr);
            if (bitmap == null) {
                AppMethodBeat.o(152400);
                return;
            }
            k.this.Kvv.put(str, bitmap);
            final ImageView imageView = k.this.Kvt.get(str);
            if (imageView != null) {
                k.this.Kvu.remove(imageView);
                k.this.hAk.post(new Runnable() {
                    /* class com.tencent.mm.pluginsdk.ui.tools.k.AnonymousClass5.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(152399);
                        c.c(imageView, bitmap);
                        AppMethodBeat.o(152399);
                    }
                });
            }
            k.this.Kvt.remove(str);
            AppMethodBeat.o(152400);
        }
    };
    volatile boolean Kvr = false;
    private MMHandler Kvs;
    public HashMap<String, ImageView> Kvt = new HashMap<>();
    public HashMap<ImageView, String> Kvu = new HashMap<>();
    com.tencent.mm.memory.a.b<Bitmap> Kvv;
    private SparseArray<Bitmap> Kvw;
    a<d> Kvx;
    a<b> Kvy;
    private boolean Kvz = true;
    MMHandler hAk;
    public byte[] lock = new byte[0];

    public k(int i2) {
        AppMethodBeat.i(152410);
        com.tencent.f.j.a bqt = com.tencent.f.j.a.bqt("ImageEngine");
        this.Kvs = new MMHandler(bqt);
        this.hAk = new MMHandler(Looper.getMainLooper());
        this.Kvx = new a<d>(bqt) {
            /* class com.tencent.mm.pluginsdk.ui.tools.k.AnonymousClass1 */

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* access modifiers changed from: protected */
            @Override // com.tencent.mm.pluginsdk.ui.tools.k.a
            public final /* synthetic */ d gsy() {
                AppMethodBeat.i(152395);
                d dVar = new d(k.this, (byte) 0);
                AppMethodBeat.o(152395);
                return dVar;
            }
        };
        this.Kvy = new a<b>(com.tencent.f.j.a.hmD()) {
            /* class com.tencent.mm.pluginsdk.ui.tools.k.AnonymousClass2 */

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* access modifiers changed from: protected */
            @Override // com.tencent.mm.pluginsdk.ui.tools.k.a
            public final /* synthetic */ b gsy() {
                AppMethodBeat.i(152396);
                b bVar = new b(k.this, (byte) 0);
                AppMethodBeat.o(152396);
                return bVar;
            }
        };
        this.Kvw = new SparseArray<>();
        this.Kvv = new com.tencent.mm.memory.a.b<>(i2, new f.b<String, Bitmap>() {
            /* class com.tencent.mm.pluginsdk.ui.tools.k.AnonymousClass3 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object, java.lang.Object] */
            @Override // com.tencent.mm.b.f.b
            public final /* synthetic */ void c(String str, Bitmap bitmap, Bitmap bitmap2) {
                AppMethodBeat.i(152397);
                Bitmap bitmap3 = bitmap;
                if (bitmap3 != null) {
                    Log.i("MicroMsg.ImageEngine", "recycle bitmap:%s", bitmap3.toString());
                    bitmap3.recycle();
                }
                AppMethodBeat.o(152397);
            }
        }, getClass());
        u.b(this.KvA);
        AppMethodBeat.o(152410);
    }

    public final void destroy() {
        AppMethodBeat.i(152411);
        Log.d("MicroMsg.ImageEngine", "do destroy");
        this.Kvr = true;
        this.Kvs.getSerial().RUS.quit();
        u.c(this.KvA);
        final SparseArray<Bitmap> sparseArray = this.Kvw;
        final com.tencent.mm.memory.a.b<Bitmap> bVar = this.Kvv;
        this.Kvw = new SparseArray<>();
        this.Kvv = new com.tencent.mm.memory.a.b<>(1, getClass());
        ThreadPool.post(new Runnable() {
            /* class com.tencent.mm.pluginsdk.ui.tools.k.AnonymousClass4 */

            public final void run() {
                AppMethodBeat.i(152398);
                Log.i("MicroMsg.ImageEngine", "begin do recycled");
                for (int i2 = 0; i2 < sparseArray.size(); i2++) {
                    Bitmap bitmap = (Bitmap) sparseArray.valueAt(i2);
                    if (bitmap != null) {
                        Log.d("MicroMsg.ImageEngine", "recycled def bmp %s", bitmap.toString());
                        bitmap.recycle();
                    }
                }
                sparseArray.clear();
                Log.i("MicroMsg.ImageEngine", "clear drawable cache");
                bVar.clear();
                Log.i("MicroMsg.ImageEngine", "end do recycled");
                AppMethodBeat.o(152398);
            }
        }, "ImageEngine_destroy_" + System.currentTimeMillis());
        AppMethodBeat.o(152411);
    }

    /* access modifiers changed from: package-private */
    public abstract class a<T> {
        final int KvG = Math.max(1, 16);
        LinkedList<T> KvH = new LinkedList<>();
        private MMHandler handler;

        /* access modifiers changed from: protected */
        public abstract T gsy();

        public a(com.tencent.f.j.a aVar) {
            this.handler = new MMHandler(aVar, k.this) {
                /* class com.tencent.mm.pluginsdk.ui.tools.k.a.AnonymousClass1 */

                /* JADX DEBUG: Multi-variable search result rejected for r0v1, resolved type: java.util.LinkedList<T> */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // com.tencent.mm.sdk.platformtools.MMHandler
                public final void handleMessage(Message message) {
                    AppMethodBeat.i(152401);
                    a aVar = a.this;
                    Object obj = message.obj;
                    if (obj != null && aVar.KvH.size() < aVar.KvG) {
                        aVar.KvH.add(obj);
                    }
                    AppMethodBeat.o(152401);
                }
            };
        }

        public final T gsz() {
            if (this.KvH.isEmpty()) {
                return gsy();
            }
            return this.KvH.removeFirst();
        }

        public final void eb(T t) {
            this.handler.sendMessage(this.handler.obtainMessage(1, t));
        }
    }

    public static class c extends Drawable {
        static final Paint KvM = new Paint(6);
        WeakReference<Bitmap> KvN = new WeakReference<>(null);
        private boolean KvO = false;
        private boolean KvP = false;
        final Rect Ky = new Rect();

        public c() {
            AppMethodBeat.i(152404);
            AppMethodBeat.o(152404);
        }

        static {
            AppMethodBeat.i(152408);
            AppMethodBeat.o(152408);
        }

        public static void o(ImageView imageView) {
            AppMethodBeat.i(152406);
            c(imageView, null);
            AppMethodBeat.o(152406);
        }

        public final void setAlpha(int i2) {
        }

        public final void setColorFilter(ColorFilter colorFilter) {
        }

        public final int getOpacity() {
            return 0;
        }

        public static void c(ImageView imageView, Bitmap bitmap) {
            c cVar;
            boolean z = true;
            AppMethodBeat.i(152405);
            if (imageView.getDrawable() instanceof c) {
                cVar = (c) imageView.getDrawable();
            } else {
                cVar = new c();
            }
            cVar.KvN = new WeakReference<>(bitmap);
            cVar.KvO = imageView.getScaleType() == ImageView.ScaleType.FIT_XY;
            if (imageView.getScaleType() != ImageView.ScaleType.CENTER_CROP) {
                z = false;
            }
            cVar.KvP = z;
            imageView.setImageDrawable(cVar);
            imageView.postInvalidate();
            AppMethodBeat.o(152405);
        }

        public final void draw(Canvas canvas) {
            boolean z;
            AppMethodBeat.i(152407);
            Bitmap bitmap = this.KvN.get();
            if (bitmap == null || bitmap.isRecycled()) {
                z = false;
            } else {
                copyBounds(this.Ky);
                canvas.drawBitmap(bitmap, (Rect) null, this.Ky, KvM);
                z = true;
            }
            if (z) {
                AppMethodBeat.o(152407);
            } else {
                AppMethodBeat.o(152407);
            }
        }
    }

    class d implements Runnable {
        ImageView dKU;
        Bitmap xqp;

        private d() {
        }

        /* synthetic */ d(k kVar, byte b2) {
            this();
        }

        public final void run() {
            AppMethodBeat.i(152409);
            if (this.dKU != null) {
                if (this.xqp == null || !this.xqp.isRecycled()) {
                    c.c(this.dKU, this.xqp);
                } else {
                    c.o(this.dKU);
                }
            }
            this.dKU = null;
            this.xqp = null;
            k.this.Kvx.eb(this);
            AppMethodBeat.o(152409);
        }
    }

    /* access modifiers changed from: package-private */
    public class b implements Runnable {
        private String[] KvK;
        private String KvL;
        private int targetHeight;
        private int targetWidth;
        private String url;

        private b() {
        }

        /* synthetic */ b(k kVar, byte b2) {
            this();
        }

        private Bitmap bfD(String str) {
            Bitmap bitmap;
            AppMethodBeat.i(152402);
            if (str == null) {
                AppMethodBeat.o(152402);
                return null;
            }
            if (this.targetHeight <= 0 || this.targetWidth <= 0) {
                bitmap = u.Sq(str);
            } else {
                String str2 = str + "_" + this.targetWidth + "_" + this.targetHeight;
                bitmap = u.x(str2, this.targetWidth, this.targetHeight);
                if (bitmap == null) {
                    int exifOrientation = BackwardSupportUtil.ExifHelper.getExifOrientation(str);
                    if (90 == exifOrientation || 270 == exifOrientation) {
                        bitmap = BitmapUtil.extractThumbNail(str, this.targetWidth, this.targetHeight, true);
                    } else {
                        bitmap = BitmapUtil.extractThumbNail(str, this.targetHeight, this.targetWidth, true);
                    }
                    if (bitmap != null) {
                        bitmap = BitmapUtil.rotate(bitmap, (float) exifOrientation);
                        try {
                            BitmapUtil.saveBitmapToImage(bitmap, 100, Bitmap.CompressFormat.PNG, str2, false);
                        } catch (IOException e2) {
                            Log.printErrStackTrace("MicroMsg.ImageEngine", e2, "", new Object[0]);
                        }
                    }
                }
            }
            AppMethodBeat.o(152402);
            return bitmap;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:12:0x0042, code lost:
            r0 = null;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:13:0x0045, code lost:
            if (r7.KvK == null) goto L_0x0062;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:14:0x0047, code lost:
            r1 = 0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:16:0x004b, code lost:
            if (r1 >= r7.KvK.length) goto L_0x0062;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x004d, code lost:
            if (r1 != 0) goto L_0x00d7;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x004f, code lost:
            r0 = bfD(r7.KvK[0]);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x0057, code lost:
            if (r0 == null) goto L_0x0104;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:0x0059, code lost:
            r7.KvB.Kvv.put(r7.KvL, r0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x0062, code lost:
            if (r0 != null) goto L_0x0089;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x006a, code lost:
            if (com.tencent.mm.sdk.platformtools.Util.isNullOrNil(r7.url) != false) goto L_0x0089;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:24:0x006c, code lost:
            r0 = com.tencent.mm.platformtools.u.a(r7.KvB.i(r7.KvL, r7.url, r7.targetWidth, r7.targetHeight));
         */
        /* JADX WARNING: Code restructure failed: missing block: B:25:0x007e, code lost:
            if (r0 == null) goto L_0x0089;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:26:0x0080, code lost:
            r7.KvB.Kvv.put(r7.KvL, r0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:28:0x008a, code lost:
            if (r0 == null) goto L_0x00c5;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:29:0x008c, code lost:
            r3 = r7.KvB.lock;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:30:0x0090, code lost:
            monitor-enter(r3);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:32:?, code lost:
            r0 = r7.KvB.Kvt.get(r7.KvL);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:33:0x009d, code lost:
            if (r0 == null) goto L_0x00bb;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:34:0x009f, code lost:
            r7.KvB.Kvu.remove(r0);
            r1 = r7.KvB.Kvx.gsz();
            r1.dKU = r0;
            r1.xqp = r0;
            r7.KvB.hAk.post(r1);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:35:0x00bb, code lost:
            r7.KvB.Kvt.remove(r7.KvL);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:36:0x00c4, code lost:
            monitor-exit(r3);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:37:0x00c5, code lost:
            r7.KvB.Kvy.eb(r7);
            com.tencent.matrix.trace.core.AppMethodBeat.o(152403);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:42:0x00d7, code lost:
            r3 = com.tencent.mm.pluginsdk.ui.tools.k.t(r7.KvK[r1], r7.url, r7.targetWidth, r7.targetHeight);
            r0 = r7.KvB.Kvv.get(r3);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:43:0x00ef, code lost:
            if (r0 != null) goto L_0x00f9;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:44:0x00f1, code lost:
            r0 = bfD(r7.KvK[r1]);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:45:0x00f9, code lost:
            if (r0 == null) goto L_0x0104;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:46:0x00fb, code lost:
            r7.KvB.Kvv.put(r3, r0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:47:0x0104, code lost:
            r1 = r1 + 1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:48:0x0108, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:50:0x010a, code lost:
            com.tencent.matrix.trace.core.AppMethodBeat.o(152403);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:51:0x010d, code lost:
            throw r0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:59:?, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void run() {
            /*
            // Method dump skipped, instructions count: 270
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.pluginsdk.ui.tools.k.b.run():void");
        }
    }

    /* access modifiers changed from: protected */
    public s i(String str, String str2, int i2, int i3) {
        return null;
    }

    private void b(ImageView imageView, int i2) {
        AppMethodBeat.i(152412);
        if (i2 == 0) {
            c.o(imageView);
            AppMethodBeat.o(152412);
            return;
        }
        Bitmap bitmap = this.Kvw.get(i2);
        if (bitmap == null) {
            bitmap = com.tencent.mm.compatible.f.a.decodeResource(imageView.getResources(), i2);
            this.Kvw.put(i2, bitmap);
        }
        c.c(imageView, bitmap);
        AppMethodBeat.o(152412);
    }

    static String t(String str, String str2, int i2, int i3) {
        AppMethodBeat.i(152413);
        String str3 = Util.nullAs(str, BuildConfig.COMMAND) + "_" + Util.nullAs(str2, BuildConfig.COMMAND) + "_" + i2 + "_" + i3;
        AppMethodBeat.o(152413);
        return str3;
    }

    public final void a(ImageView imageView, String[] strArr, String str, int i2, int i3, int i4) {
        boolean z;
        AppMethodBeat.i(152414);
        if (!this.Kvz) {
            AppMethodBeat.o(152414);
        } else if (this.Kvr) {
            Log.w("MicroMsg.ImageEngine", "on attach, isQuit, return");
            AppMethodBeat.o(152414);
        } else if (imageView == null) {
            Log.w("MicroMsg.ImageEngine", "attach from file path fail, imageview is null");
            AppMethodBeat.o(152414);
        } else if ((strArr == null || strArr.length <= 0) && Util.isNullOrNil(str)) {
            Log.w("MicroMsg.ImageEngine", "attach from file path fail, path and url are null or empty");
            b(imageView, i2);
            AppMethodBeat.o(152414);
        } else {
            String t = t((strArr == null || strArr.length <= 0) ? null : strArr[0], str, i3, i4);
            synchronized (this.lock) {
                try {
                    String str2 = this.Kvu.get(imageView);
                    if (str2 != null) {
                        this.Kvt.remove(str2);
                    }
                    this.Kvu.put(imageView, t);
                } finally {
                    AppMethodBeat.o(152414);
                }
            }
            Bitmap bitmap = this.Kvv.get(t);
            if (bitmap == null || bitmap.isRecycled()) {
                Log.v("MicroMsg.ImageEngine", "get first render bmp fail, key[%s]", t);
                if (strArr != null && strArr.length > 1) {
                    int i5 = 1;
                    while (true) {
                        if (i5 >= strArr.length) {
                            break;
                        }
                        Bitmap bitmap2 = this.Kvv.get(t(strArr[i5], str, i3, i4));
                        Object[] objArr = new Object[2];
                        objArr[0] = t;
                        objArr[1] = Boolean.valueOf(bitmap2 != null);
                        Log.v("MicroMsg.ImageEngine", "get next render bmp, key[%s], result[%B]", objArr);
                        if (bitmap2 != null) {
                            c.c(imageView, bitmap2);
                            z = true;
                            break;
                        }
                        i5++;
                    }
                }
                z = false;
                if (!z) {
                    Log.v("MicroMsg.ImageEngine", "use default res to render");
                    b(imageView, i2);
                }
                synchronized (this.lock) {
                    try {
                        this.Kvt.put(t, imageView);
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                b gsz = this.Kvy.gsz();
                gsz.KvK = strArr;
                gsz.url = str;
                gsz.KvL = t;
                gsz.targetWidth = i3;
                gsz.targetHeight = i4;
                this.Kvs.postAtFrontOfQueue(gsz);
                AppMethodBeat.o(152414);
                return;
            }
            c.c(imageView, bitmap);
            AppMethodBeat.o(152414);
        }
    }
}

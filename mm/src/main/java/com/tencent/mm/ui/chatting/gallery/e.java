package com.tencent.mm.ui.chatting.gallery;

import android.graphics.Bitmap;
import android.os.Build;
import android.support.v4.view.ViewPager;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.f;
import com.tencent.mm.memory.a.b;
import com.tencent.mm.model.bg;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.QueueWorkerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.WxImageView;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/* access modifiers changed from: package-private */
public final class e implements ViewPager.OnPageChangeListener {
    private static long Pye = 0;
    private static int mScreenHeight = 0;
    private static int mScreenWidth = 0;
    Bitmap CQj;
    SparseArray<String> Pyb = new SparseArray<>();
    a Pyc;
    protected f<String, Bitmap> Pyd = new b(400, new f.b<String, Bitmap>() {
        /* class com.tencent.mm.ui.chatting.gallery.e.AnonymousClass1 */

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object, java.lang.Object] */
        @Override // com.tencent.mm.b.f.b
        public final /* synthetic */ void c(String str, Bitmap bitmap, Bitmap bitmap2) {
            AppMethodBeat.i(36049);
            Bitmap bitmap3 = bitmap;
            if (bitmap3 != null && !bitmap3.isRecycled()) {
                Log.i("MicroMsg.ImageGalleryLazyLoader", "recycle bitmap:%s", bitmap3.toString());
                bitmap3.recycle();
            }
            AppMethodBeat.o(36049);
        }
    }, getClass());
    private LinkedList<Integer> Pyf = new LinkedList<>();
    private LinkedList<Integer> Pyg = new LinkedList<>();
    private int afB = -1;
    private MMHandler hAk = new MMHandler();
    private QueueWorkerThread iOL = new QueueWorkerThread(1, "chatting-image-gallery-lazy-loader");
    private int mScrollState = 0;
    SparseArray<WeakReference<View>> xqf = new SparseArray<>();
    HashMap<String, Integer> xqg = new HashMap<>();
    SparseArray<String> xqh = new SparseArray<>();
    SparseArray<Bitmap> xqi = new SparseArray<>();
    protected f<String, Bitmap> xqj = new b(5, new f.b<String, Bitmap>() {
        /* class com.tencent.mm.ui.chatting.gallery.e.AnonymousClass2 */

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object, java.lang.Object] */
        @Override // com.tencent.mm.b.f.b
        public final /* synthetic */ void c(String str, Bitmap bitmap, Bitmap bitmap2) {
            AppMethodBeat.i(36050);
            Bitmap bitmap3 = bitmap;
            Log.i("MicroMsg.ImageGalleryLazyLoader", "preRemoveCallback %s", str);
            if (bitmap3 != null && !bitmap3.isRecycled() && e.this.xqk.indexOfKey(bitmap3.hashCode()) < 0) {
                if (e.this.Pyf.contains(Integer.valueOf(bitmap3.hashCode()))) {
                    e.this.Pyf.remove(Integer.valueOf(bitmap3.hashCode()));
                    AppMethodBeat.o(36050);
                    return;
                }
                Log.i("MicroMsg.ImageGalleryLazyLoader", "recycle bitmap:%s", bitmap3.toString());
                bitmap3.recycle();
            }
            AppMethodBeat.o(36050);
        }
    }, getClass());
    protected SparseIntArray xqk = new SparseIntArray();
    private LinkedList<String> xql = new LinkedList<>();
    private boolean xqn = false;

    public interface a {
        void a(long j2, View view, String str, Bitmap bitmap);

        void a(WxImageView wxImageView, String str, com.davemorrissey.labs.subscaleview.view.a aVar);

        Bitmap ana(int i2);

        Bitmap bmV(String str);
    }

    static /* synthetic */ void a(e eVar, int i2, Bitmap bitmap) {
        AppMethodBeat.i(36072);
        eVar.b(i2, bitmap);
        AppMethodBeat.o(36072);
    }

    static /* synthetic */ boolean f(e eVar) {
        AppMethodBeat.i(36071);
        boolean dSk = eVar.dSk();
        AppMethodBeat.o(36071);
        return dSk;
    }

    static /* synthetic */ void h(e eVar) {
        AppMethodBeat.i(36073);
        eVar.YC();
        AppMethodBeat.o(36073);
    }

    public final void cg(Map<String, Bitmap> map) {
        AppMethodBeat.i(36057);
        for (String str : map.keySet()) {
            Bitmap bitmap = map.get(str);
            if (bitmap != null) {
                this.xqj.put(str, bitmap);
                this.Pyf.push(Integer.valueOf(bitmap.hashCode()));
                Log.i("MicroMsg.ImageGalleryLazyLoader", "we got one cache from preload : %s %s", str, Integer.valueOf(bitmap.hashCode()));
            } else {
                Log.e("MicroMsg.ImageGalleryLazyLoader", "we got one null cache from preload");
            }
        }
        AppMethodBeat.o(36057);
    }

    public e(a aVar) {
        AppMethodBeat.i(36058);
        this.Pyc = aVar;
        AppMethodBeat.o(36058);
    }

    /* access modifiers changed from: package-private */
    public final void dSj() {
        AppMethodBeat.i(36059);
        this.Pyd.a(new f.a<String, Bitmap>() {
            /* class com.tencent.mm.ui.chatting.gallery.e.AnonymousClass3 */
        });
        this.xqj.a(new f.a<String, Bitmap>() {
            /* class com.tencent.mm.ui.chatting.gallery.e.AnonymousClass4 */
        });
        AppMethodBeat.o(36059);
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public final void onPageScrollStateChanged(int i2) {
        AppMethodBeat.i(36060);
        this.mScrollState = i2;
        if (dSk()) {
            int[] iArr = new int[this.xqi.size()];
            for (int i3 = 0; i3 < iArr.length; i3++) {
                iArr[i3] = this.xqi.keyAt(i3);
            }
            for (int i4 : iArr) {
                b(i4, this.xqi.get(i4));
            }
        }
        AppMethodBeat.o(36060);
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public final void onPageSelected(int i2) {
        AppMethodBeat.i(36061);
        if (!((d) this.Pyc).Pwu.Pww.bcY) {
            AppMethodBeat.o(36061);
            return;
        }
        if (this.afB == -1) {
            int i3 = 0;
            while (true) {
                if (i3 != 0) {
                    if (i2 + i3 > i2 + 3 && i2 - i3 < Math.max(i2 - 3, 0)) {
                        break;
                    }
                    if (i2 + i3 <= i2 + 3) {
                        NU(i2 + i3);
                    }
                    if (i2 - i3 >= Math.max(i2 - 3, 0)) {
                        NU(i2 - i3);
                    }
                } else {
                    NU(i2);
                }
                i3++;
            }
        } else if (this.afB > i2) {
            NU(Math.max(i2 - 3, 0));
        } else if (this.afB < i2) {
            NU(i2 + 3);
        }
        this.afB = i2;
        d dVar = (d) this.Pyc;
        if (dVar != null) {
            if (dVar.Pwu.NQ(this.afB) != null) {
                this.CQj = null;
                AppMethodBeat.o(36061);
                return;
            }
            WxImageView NR = dVar.Pwu.NR(this.afB);
            if (NR != null) {
                this.CQj = NR.getFullImageBitmap();
            }
        }
        AppMethodBeat.o(36061);
    }

    private void NU(final int i2) {
        AppMethodBeat.i(36062);
        if (this.Pyd.check(String.valueOf(i2))) {
            AppMethodBeat.o(36062);
            return;
        }
        bg.aAk().postToWorkerDelayed(new Runnable() {
            /* class com.tencent.mm.ui.chatting.gallery.e.AnonymousClass5 */

            public final void run() {
                AppMethodBeat.i(36052);
                if (e.this.Pyc == null) {
                    Log.e("MicroMsg.ImageGalleryLazyLoader", "loader is null!");
                    AppMethodBeat.o(36052);
                    return;
                }
                final Bitmap ana = e.this.Pyc.ana(i2);
                if (ana == null) {
                    AppMethodBeat.o(36052);
                    return;
                }
                e.this.hAk.post(new Runnable() {
                    /* class com.tencent.mm.ui.chatting.gallery.e.AnonymousClass5.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(36051);
                        e.this.Pyd.put(new StringBuilder().append(i2).toString(), ana);
                        AppMethodBeat.o(36051);
                    }
                });
                AppMethodBeat.o(36052);
            }
        }, 300);
        AppMethodBeat.o(36062);
    }

    private boolean dSk() {
        return this.mScrollState == 0;
    }

    private void NT(int i2) {
        AppMethodBeat.i(36063);
        if (this.xqh.get(i2) != null) {
            this.xqf.remove(i2);
            this.xqh.remove(i2);
            this.xqg.remove(this.xqh.get(i2));
            this.xqi.remove(i2);
        }
        AppMethodBeat.o(36063);
    }

    private void a(int i2, View view, String str) {
        AppMethodBeat.i(36064);
        this.xqg.put(str, Integer.valueOf(i2));
        this.xqh.put(i2, str);
        this.xqf.put(i2, new WeakReference<>(view));
        AppMethodBeat.o(36064);
    }

    private void b(int i2, Bitmap bitmap) {
        AppMethodBeat.i(36065);
        if (this.xqf.get(i2) == null) {
            AppMethodBeat.o(36065);
            return;
        }
        this.Pyc.a(0, this.xqf.get(i2).get(), this.xqh.get(i2), bitmap);
        NT(i2);
        AppMethodBeat.o(36065);
    }

    public final boolean c(ImageView imageView, int i2) {
        AppMethodBeat.i(36066);
        Log.i("MicroMsg.ImageGalleryLazyLoader", "loadThumb position %s", Integer.valueOf(i2));
        Bitmap aT = this.Pyd.aT(String.valueOf(i2));
        if (aT == null || aT.isRecycled()) {
            AppMethodBeat.o(36066);
            return false;
        }
        this.Pyc.a(0, imageView, null, aT);
        AppMethodBeat.o(36066);
        return true;
    }

    public final void b(View view, String str, String str2, int i2) {
        AppMethodBeat.i(36067);
        if (this.xql.contains(str)) {
            AppMethodBeat.o(36067);
            return;
        }
        int hashCode = view.hashCode();
        NT(hashCode);
        a(hashCode, view, str);
        if (view instanceof WxImageView) {
            this.Pyb.remove(hashCode);
            this.Pyb.put(hashCode, str2);
        }
        this.xql.add(str);
        this.Pyg.add(Integer.valueOf(i2));
        YC();
        AppMethodBeat.o(36067);
    }

    public final void f(ImageView imageView, String str, int i2) {
        AppMethodBeat.i(36068);
        if (this.xql.contains(str)) {
            AppMethodBeat.o(36068);
            return;
        }
        int hashCode = imageView.hashCode();
        NT(hashCode);
        a(hashCode, imageView, str);
        this.xql.add(str);
        this.Pyg.add(Integer.valueOf(i2));
        YC();
        AppMethodBeat.o(36068);
    }

    private void YC() {
        AppMethodBeat.i(36069);
        if (this.xqn) {
            AppMethodBeat.o(36069);
        } else if (this.xql.size() == 0) {
            AppMethodBeat.o(36069);
        } else {
            final String removeLast = this.xql.removeLast();
            final int intValue = this.Pyg.removeLast().intValue();
            if (!this.xqg.containsKey(removeLast)) {
                AppMethodBeat.o(36069);
                return;
            }
            this.xqn = true;
            this.iOL.add(new QueueWorkerThread.ThreadObject() {
                /* class com.tencent.mm.ui.chatting.gallery.e.AnonymousClass6 */
                private boolean Pyk = false;
                private Bitmap xqp = null;

                @Override // com.tencent.mm.sdk.platformtools.QueueWorkerThread.ThreadObject
                public final boolean onPostExecute() {
                    int i2;
                    AppMethodBeat.i(36054);
                    e.this.xqn = false;
                    if (!this.Pyk) {
                        if (e.this.xqg.containsKey(removeLast)) {
                            int intValue = ((Integer) e.this.xqg.get(removeLast)).intValue();
                            if (!e.f(e.this)) {
                                e.this.xqi.put(intValue, this.xqp);
                            } else {
                                e.a(e.this, intValue, this.xqp);
                            }
                        }
                        e.this.w(removeLast, this.xqp);
                        e.this.e(intValue, this.xqp);
                        Object[] objArr = new Object[1];
                        Bitmap bitmap = this.xqp;
                        if (bitmap == null || bitmap.isRecycled()) {
                            i2 = 0;
                        } else {
                            if (Build.VERSION.SDK_INT >= 12) {
                                i2 = bitmap.getByteCount();
                            } else {
                                i2 = bitmap.getRowBytes() * bitmap.getHeight();
                            }
                            if (i2 < 0) {
                                IllegalStateException illegalStateException = new IllegalStateException("Negative size: ".concat(String.valueOf(bitmap)));
                                AppMethodBeat.o(36054);
                                throw illegalStateException;
                            }
                        }
                        objArr[0] = Integer.valueOf(i2);
                        Log.i("MicroMsg.ImageGalleryLazyLoader", "bmp size : %s", objArr);
                        this.xqp = null;
                    }
                    e.h(e.this);
                    AppMethodBeat.o(36054);
                    return false;
                }

                /* JADX WARNING: Code restructure failed: missing block: B:10:0x004b, code lost:
                    r0 = (android.view.View) r0.get();
                 */
                @Override // com.tencent.mm.sdk.platformtools.QueueWorkerThread.ThreadObject
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public final boolean doInBackground() {
                    /*
                    // Method dump skipped, instructions count: 167
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.chatting.gallery.e.AnonymousClass6.doInBackground():boolean");
                }

                static /* synthetic */ void a(AnonymousClass6 r9, WxImageView wxImageView, String str, String str2, int i2) {
                    com.davemorrissey.labs.subscaleview.view.a aP;
                    boolean z = true;
                    AppMethodBeat.i(233297);
                    if (!(e.this.Pyc == null || wxImageView == null || Util.isNullOrNil(str))) {
                        Object[] objArr = new Object[4];
                        objArr[0] = Integer.valueOf(i2);
                        objArr[1] = Integer.valueOf(e.this.afB);
                        objArr[2] = Boolean.valueOf(e.this.CQj == null);
                        if (e.this.CQj == null || !e.this.CQj.isRecycled()) {
                            z = false;
                        }
                        objArr[3] = Boolean.valueOf(z);
                        Log.i("MicroMsg.ImageGalleryLazyLoader", "alvinluo loadWxImageView position: %d, mLastPosition: %d, previewBitmap == null: %b, recycle: %b", objArr);
                        if (i2 != e.this.afB || e.this.CQj == null || e.this.CQj.isRecycled()) {
                            aP = !Util.isNullOrNil(str2) ? com.davemorrissey.labs.subscaleview.view.a.aP(str2) : null;
                        } else {
                            aP = com.davemorrissey.labs.subscaleview.view.a.m(e.this.CQj);
                        }
                        e.this.Pyc.a(wxImageView, str, aP);
                    }
                    AppMethodBeat.o(233297);
                }
            });
            AppMethodBeat.o(36069);
        }
    }

    public final void e(int i2, Bitmap bitmap) {
        AppMethodBeat.i(36070);
        if (i2 == this.afB || this.afB == -1) {
            Log.i("MicroMsg.ImageGalleryLazyLoader", "alvinluo notifyBitmapLoaded cache bitmap, position: %d", Integer.valueOf(i2));
            this.CQj = bitmap;
        }
        AppMethodBeat.o(36070);
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public final void onPageScrolled(int i2, float f2, int i3) {
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0050  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x005f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void w(java.lang.String r10, android.graphics.Bitmap r11) {
        /*
        // Method dump skipped, instructions count: 146
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.chatting.gallery.e.w(java.lang.String, android.graphics.Bitmap):void");
    }
}

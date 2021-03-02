package com.tencent.mm.plugin.game.e;

import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.av.a.a.c;
import com.tencent.mm.av.q;
import com.tencent.mm.b.f;
import com.tencent.mm.b.g;
import com.tencent.mm.plugin.game.commlib.util.b;
import com.tencent.mm.pluginsdk.model.app.h;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorage;
import com.tencent.mm.sdk.storage.MStorageEventData;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;
import java.lang.ref.WeakReference;

public class e {
    private static final String xZe = (com.tencent.mm.plugin.game.commlib.util.b.c(b.a.ONE_MONTH) + "image/");
    private static e xZf;
    private f<String, Bitmap> xOc = new com.tencent.mm.memory.a.b(6, getClass());
    private f<String, Bitmap> xUC = new com.tencent.mm.memory.a.b(15, getClass());
    private ColorDrawable xZg = new ColorDrawable(android.support.v4.content.b.n(MMApplicationContext.getContext(), R.color.s6));
    private Bitmap xZh;
    private Bitmap xZi;

    public static abstract class b {
        public abstract void a(View view, Bitmap bitmap);
    }

    static /* synthetic */ Bitmap e(Bitmap bitmap, int i2, int i3) {
        AppMethodBeat.i(42556);
        Bitmap d2 = d(bitmap, i2, i3);
        AppMethodBeat.o(42556);
        return d2;
    }

    static {
        AppMethodBeat.i(42557);
        AppMethodBeat.o(42557);
    }

    public static e dWR() {
        AppMethodBeat.i(42539);
        if (xZf == null) {
            synchronized (e.class) {
                try {
                    if (xZf == null) {
                        xZf = new e();
                    }
                } catch (Throwable th) {
                    AppMethodBeat.o(42539);
                    throw th;
                }
            }
        }
        e eVar = xZf;
        AppMethodBeat.o(42539);
        return eVar;
    }

    private e() {
        AppMethodBeat.i(42540);
        try {
            this.xZh = BackwardSupportUtil.BitmapFactory.decodeStream(MMApplicationContext.getContext().getAssets().open("avatar/default_nor_avatar.png"), com.tencent.mm.cb.a.getDensity(null));
            if (this.xZh != null && !this.xZh.isRecycled()) {
                this.xZi = BitmapUtil.getRoundedCornerBitmap(this.xZh, false, 0.5f * ((float) this.xZh.getWidth()));
            }
        } catch (Exception e2) {
            Log.i("MicroMsg.GameImageUtil", e2.getMessage());
        }
        com.tencent.mm.plugin.r.a.eAS().add(new MStorage.IOnStorageChange() {
            /* class com.tencent.mm.plugin.game.e.e.AnonymousClass1 */

            @Override // com.tencent.mm.sdk.storage.MStorage.IOnStorageChange
            public final void onNotifyChange(String str, MStorageEventData mStorageEventData) {
                AppMethodBeat.i(42530);
                if (e.this.xOc.check(str)) {
                    e.this.xOc.x(str, h.c(str, 1, com.tencent.mm.cb.a.getDensity(null)));
                }
                AppMethodBeat.o(42530);
            }
        });
        AppMethodBeat.o(42540);
    }

    public final void o(ImageView imageView, String str) {
        AppMethodBeat.i(42541);
        a(imageView, str, (a) null, (b) null);
        AppMethodBeat.o(42541);
    }

    public final void a(ImageView imageView, String str, a aVar) {
        AppMethodBeat.i(42542);
        a(imageView, str, aVar, (b) null);
        AppMethodBeat.o(42542);
    }

    public final void p(ImageView imageView, String str) {
        AppMethodBeat.i(42543);
        a.C1397a aVar = new a.C1397a();
        aVar.iaT = true;
        a(imageView, str, aVar.dWS(), (b) null);
        AppMethodBeat.o(42543);
    }

    public final void a(ImageView imageView, String str, a aVar, b bVar) {
        AppMethodBeat.i(42544);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(42544);
            return;
        }
        if (aVar == null) {
            aVar = new a.C1397a().dWS();
        }
        if (b(imageView, str, aVar, bVar)) {
            AppMethodBeat.o(42544);
            return;
        }
        c(imageView, str, aVar, bVar);
        AppMethodBeat.o(42544);
    }

    private void c(final ImageView imageView, String str, final a aVar, final b bVar) {
        boolean z;
        AppMethodBeat.i(42546);
        c.a aVar2 = new c.a();
        if (!aVar.xZv) {
            z = true;
        } else {
            z = false;
        }
        aVar2.jbd = z;
        aAO(xZe);
        String str2 = xZe + g.getMessageDigest(str.getBytes());
        aVar2.jbf = aVar.jbf;
        if (!aVar.xZv) {
            aVar2.fullPath = str2;
        } else {
            aVar2.jbf = false;
            com.tencent.mm.pluginsdk.j.a.d.a.bej(str2);
        }
        aVar2.iaT = aVar.iaT;
        aVar2.hZF = false;
        a(imageView, aVar);
        q.bcV().a(str, (ImageView) null, aVar2.bdv(), new com.tencent.mm.av.a.c.h() {
            /* class com.tencent.mm.plugin.game.e.e.AnonymousClass2 */

            @Override // com.tencent.mm.av.a.c.h
            public final void b(String str, View view) {
                AppMethodBeat.i(42532);
                Log.d("MicroMsg.GameImageUtil", "onImageLoadStart, url: ".concat(String.valueOf(str)));
                AppMethodBeat.o(42532);
            }

            @Override // com.tencent.mm.av.a.c.h
            public final Bitmap a(String str, View view, com.tencent.mm.av.a.d.b bVar) {
                return null;
            }

            @Override // com.tencent.mm.av.a.c.h
            public final void b(String str, View view, com.tencent.mm.av.a.d.b bVar) {
                AppMethodBeat.i(42533);
                Log.d("MicroMsg.GameImageUtil", "onImageLoadFinish, url: ".concat(String.valueOf(str)));
                if (!(bVar == null || bVar.bitmap == null)) {
                    final Bitmap bitmap = bVar.bitmap;
                    if (aVar.xZt) {
                        bitmap = e.af(bitmap);
                    }
                    if (aVar.ofi != 0) {
                        bitmap = BitmapUtil.getRoundedCornerBitmap(bitmap, false, (float) aVar.ofi);
                    }
                    if (aVar.xZw > 0.0f) {
                        bitmap = BitmapUtil.getRoundedCornerBitmap(bitmap, false, ((float) bitmap.getWidth()) * aVar.xZw);
                    }
                    if (aVar.jbd) {
                        e.this.xUC.x(str, bitmap);
                    }
                    MMHandlerThread.postToMainThread(new Runnable() {
                        /* class com.tencent.mm.plugin.game.e.e.AnonymousClass2.AnonymousClass1 */

                        public final void run() {
                            AppMethodBeat.i(42531);
                            if (imageView != null) {
                                imageView.setImageBitmap(bitmap);
                            }
                            AppMethodBeat.o(42531);
                        }
                    });
                    if (bVar != null) {
                        bVar.a(view, bitmap);
                    }
                }
                AppMethodBeat.o(42533);
            }
        });
        AppMethodBeat.o(42546);
    }

    private void a(ImageView imageView, a aVar) {
        AppMethodBeat.i(42547);
        if (imageView != null && aVar.xZu) {
            if (aVar.hZB == 0) {
                imageView.setImageDrawable(this.xZg);
                AppMethodBeat.o(42547);
                return;
            }
            imageView.setImageResource(aVar.hZB);
        }
        AppMethodBeat.o(42547);
    }

    public final void a(ImageView imageView, String str, int i2, int i3, int i4) {
        AppMethodBeat.i(42548);
        b(imageView, str, i2, i3, i4);
        AppMethodBeat.o(42548);
    }

    private void b(final ImageView imageView, String str, final int i2, final int i3, final int i4) {
        AppMethodBeat.i(42549);
        a(str, i2, i3, new b() {
            /* class com.tencent.mm.plugin.game.e.e.AnonymousClass3 */

            @Override // com.tencent.mm.plugin.game.e.e.b
            public final void a(View view, final Bitmap bitmap) {
                AppMethodBeat.i(42535);
                if (bitmap != null && !bitmap.isRecycled()) {
                    MMHandlerThread.postToMainThread(new Runnable() {
                        /* class com.tencent.mm.plugin.game.e.e.AnonymousClass3.AnonymousClass1 */

                        public final void run() {
                            AppMethodBeat.i(42534);
                            imageView.setImageBitmap(bitmap);
                            ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
                            float f2 = ((float) i3) / ((float) i2);
                            layoutParams.width = i4;
                            layoutParams.height = (int) (f2 * ((float) i4));
                            imageView.setLayoutParams(layoutParams);
                            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                            AppMethodBeat.o(42534);
                        }
                    });
                }
                AppMethodBeat.o(42535);
            }
        });
        AppMethodBeat.o(42549);
    }

    private void a(String str, int i2, int i3, b bVar) {
        AppMethodBeat.i(42550);
        Log.d("MicroMsg.GameImageUtil", "getBitmapWithWH, start");
        Bitmap aT = this.xUC.aT(str);
        if (aT == null || aT.isRecycled()) {
            c(null, str, new a.C1397a().dWS(), new b(bVar, i2, i3, 0, str) {
                /* class com.tencent.mm.plugin.game.e.e.AnonymousClass4 */
                final /* synthetic */ int val$height;
                final /* synthetic */ String val$url;
                final /* synthetic */ int val$width;
                final /* synthetic */ b xZq;
                final /* synthetic */ int xZr = 0;

                {
                    this.xZq = r3;
                    this.val$width = r4;
                    this.val$height = r5;
                    this.val$url = r7;
                }

                @Override // com.tencent.mm.plugin.game.e.e.b
                public final void a(View view, Bitmap bitmap) {
                    AppMethodBeat.i(42536);
                    Log.d("MicroMsg.GameImageUtil", "getBitmapWithWH, onFinish");
                    if (bitmap != null && !bitmap.isRecycled()) {
                        Bitmap e2 = e.e(bitmap, this.val$width, this.val$height);
                        Log.d("MicroMsg.GameImageUtil", "getBitmapWithWH, resizeBitmap end");
                        if (this.xZr != 0) {
                            e2 = BitmapUtil.getRoundedCornerBitmap(e2, true, (float) this.xZr);
                        }
                        e.this.xUC.x(this.val$url, e2);
                        if (this.xZq != null) {
                            this.xZq.a(view, e2);
                        }
                    }
                    AppMethodBeat.o(42536);
                }
            });
            AppMethodBeat.o(42550);
            return;
        }
        bVar.a(null, aT);
        AppMethodBeat.o(42550);
    }

    private static Bitmap d(Bitmap bitmap, int i2, int i3) {
        int i4;
        Bitmap createBitmap;
        int i5;
        AppMethodBeat.i(42551);
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        if (width == i2 && height == i3) {
            AppMethodBeat.o(42551);
            return bitmap;
        }
        float f2 = ((float) height) / ((float) i3);
        float f3 = ((float) width) / ((float) i2);
        if (f2 < f3) {
            i5 = (int) (f2 * ((float) i2));
            try {
                createBitmap = Bitmap.createBitmap(bitmap, (width - i5) / 2, 0, i5, height);
                i4 = height;
            } catch (IllegalArgumentException e2) {
                AppMethodBeat.o(42551);
                return bitmap;
            }
        } else {
            i4 = (int) (((float) i3) * f3);
            createBitmap = Bitmap.createBitmap(bitmap, 0, (height - i4) / 2, width, i4);
            i5 = width;
        }
        Log.i("MicroMsg.GameImageUtil", "resizeBitmap, bitmapW = %d, bitmapH = %d, newWidth = %d, newHeight = %d", Integer.valueOf(width), Integer.valueOf(height), Integer.valueOf(i5), Integer.valueOf(i4));
        AppMethodBeat.o(42551);
        return createBitmap;
    }

    public final void c(ImageView imageView, final String str, final float f2) {
        Bitmap aT;
        AppMethodBeat.i(42553);
        if (imageView == null || Util.isNullOrNil(str)) {
            AppMethodBeat.o(42553);
        } else if (!this.xOc.check(str) || (aT = this.xOc.aT(str)) == null || aT.isRecycled()) {
            Bitmap c2 = h.c(str, 1, f2);
            if (c2 == null || c2.isRecycled()) {
                imageView.setImageResource(R.drawable.beg);
                final WeakReference weakReference = new WeakReference(imageView);
                com.tencent.mm.plugin.r.a.eAS().add(new MStorage.IOnStorageChange() {
                    /* class com.tencent.mm.plugin.game.e.e.AnonymousClass5 */

                    @Override // com.tencent.mm.sdk.storage.MStorage.IOnStorageChange
                    public final void onNotifyChange(String str, MStorageEventData mStorageEventData) {
                        Bitmap c2;
                        AppMethodBeat.i(42537);
                        if (str.equals(str) && (c2 = h.c(str, 1, f2)) != null) {
                            if (!(weakReference == null || weakReference.get() == null)) {
                                ((ImageView) weakReference.get()).setImageBitmap(c2);
                            }
                            e.this.xOc.put(str, c2);
                            com.tencent.mm.plugin.r.a.eAS().remove(this);
                        }
                        AppMethodBeat.o(42537);
                    }
                });
                AppMethodBeat.o(42553);
                return;
            }
            imageView.setImageBitmap(c2);
            this.xOc.put(str, c2);
            AppMethodBeat.o(42553);
        } else {
            imageView.setImageBitmap(aT);
            AppMethodBeat.o(42553);
        }
    }

    public static class a {
        final int hZB;
        final boolean iaT;
        final boolean jbd;
        final boolean jbf;
        final int ofi;
        final boolean xZt;
        final boolean xZu;
        final boolean xZv;
        final float xZw;

        /* synthetic */ a(C1397a aVar, byte b2) {
            this(aVar);
        }

        private a(C1397a aVar) {
            this.jbd = aVar.jbd;
            this.jbf = aVar.jbf;
            this.iaT = aVar.iaT;
            this.xZt = aVar.xZt;
            this.xZu = aVar.xZu;
            this.xZv = aVar.xZv;
            this.hZB = aVar.hZB;
            this.ofi = aVar.ofi;
            this.xZw = aVar.xZw;
        }

        /* renamed from: com.tencent.mm.plugin.game.e.e$a$a  reason: collision with other inner class name */
        public static class C1397a {
            public int hZB = 0;
            public boolean iaT = false;
            public boolean jbd = true;
            public boolean jbf = true;
            int ofi = 0;
            public boolean xZt = false;
            boolean xZu = true;
            boolean xZv = false;
            public float xZw = 0.0f;

            public final a dWS() {
                AppMethodBeat.i(42538);
                a aVar = new a(this, (byte) 0);
                AppMethodBeat.o(42538);
                return aVar;
            }
        }
    }

    private static boolean aAO(String str) {
        AppMethodBeat.i(42554);
        o oVar = new o(str);
        if (!oVar.exists()) {
            if (!oVar.heq().exists()) {
                o heq = oVar.heq();
                o oVar2 = new o(aa.z(heq.her()) + System.currentTimeMillis());
                if (oVar2.mkdirs()) {
                    oVar2.am(heq);
                } else {
                    Log.e("MicroMsg.GameImageUtil", "mkdir error, %s", aa.z(heq.her()));
                    AppMethodBeat.o(42554);
                    return false;
                }
            }
            if (!oVar.mkdirs() || !oVar.isDirectory()) {
                Log.e("MicroMsg.GameImageUtil", "mkdir error. %s", str);
                AppMethodBeat.o(42554);
                return false;
            }
        }
        AppMethodBeat.o(42554);
        return true;
    }

    private boolean b(ImageView imageView, String str, a aVar, b bVar) {
        AppMethodBeat.i(42545);
        if (!aVar.jbd || aVar.xZv) {
            AppMethodBeat.o(42545);
            return false;
        } else if (!this.xUC.check(str)) {
            AppMethodBeat.o(42545);
            return false;
        } else {
            Bitmap aT = this.xUC.aT(str);
            if (aT == null || aT.isRecycled()) {
                AppMethodBeat.o(42545);
                return false;
            }
            if (imageView != null) {
                imageView.setImageBitmap(aT);
            }
            if (bVar != null) {
                bVar.a(imageView, aT);
            }
            AppMethodBeat.o(42545);
            return true;
        }
    }

    public final Bitmap q(ImageView imageView, String str) {
        AppMethodBeat.i(42552);
        Bitmap a2 = com.tencent.mm.aj.c.a(str, false, -1, null);
        if (a2 == null || a2.isRecycled()) {
            if (this.xZh == null || this.xZh.isRecycled()) {
                try {
                    this.xZh = BackwardSupportUtil.BitmapFactory.decodeStream(MMApplicationContext.getContext().getAssets().open("avatar/default_nor_avatar.png"), com.tencent.mm.cb.a.getDensity(null));
                } catch (Exception e2) {
                }
            }
            if (!(this.xZh == null || this.xZh.isRecycled() || imageView == null)) {
                imageView.setImageBitmap(this.xZh);
            }
            Bitmap bitmap = this.xZh;
            AppMethodBeat.o(42552);
            return bitmap;
        }
        if (imageView != null) {
            imageView.setImageBitmap(a2);
        }
        AppMethodBeat.o(42552);
        return a2;
    }

    static /* synthetic */ Bitmap af(Bitmap bitmap) {
        AppMethodBeat.i(42555);
        if (bitmap == null || bitmap.isRecycled()) {
            AppMethodBeat.o(42555);
            return bitmap;
        }
        int width = bitmap.getHeight() > bitmap.getWidth() ? bitmap.getWidth() : bitmap.getHeight();
        Bitmap centerCropBitmap = BitmapUtil.getCenterCropBitmap(bitmap, width, width, false);
        AppMethodBeat.o(42555);
        return centerCropBitmap;
    }
}

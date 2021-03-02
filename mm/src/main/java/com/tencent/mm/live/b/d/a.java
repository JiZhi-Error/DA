package com.tencent.mm.live.b.d;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.live.core.c.c;
import com.tencent.mm.pluginsdk.ui.a;
import com.tencent.mm.pluginsdk.ui.j;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.ao;
import kotlin.g.b.p;
import kotlin.g.b.z;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, hxF = {"Lcom/tencent/mm/live/model/util/LiveBitmapUtil;", "", "()V", "Companion", "plugin-logic_release"})
public final class a {
    private static final String TAG = TAG;
    public static final C0373a hLg = new C0373a((byte) 0);

    @l(hxD = {1, 1, 16}, hxE = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tJA\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\b\u001a\u00020\t2%\u0010\r\u001a!\u0012\u0015\u0012\u0013\u0018\u00010\u0006¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u000eJA\u0010\u0012\u001a\u00020\u000b2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\b\u001a\u00020\t2%\u0010\r\u001a!\u0012\u0015\u0012\u0013\u0018\u00010\u0006¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u000eR\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\u0014"}, hxF = {"Lcom/tencent/mm/live/model/util/LiveBitmapUtil$Companion;", "", "()V", "TAG", "", "addMaskLayer", "Landroid/graphics/Bitmap;", "src", "maskColor", "", "genBlurBitmapByBm", "", "bm", "callback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "bitmap", "genBlurBitmapByUsername", ch.COL_USERNAME, "plugin-logic_release"})
    /* renamed from: com.tencent.mm.live.b.d.a$a  reason: collision with other inner class name */
    public static final class C0373a {
        private C0373a() {
        }

        public /* synthetic */ C0373a(byte b2) {
            this();
        }

        /* access modifiers changed from: package-private */
        @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
        /* renamed from: com.tencent.mm.live.b.d.a$a$b */
        public static final class b implements Runnable {
            final /* synthetic */ kotlin.g.a.b gWe;
            final /* synthetic */ int hLi;
            final /* synthetic */ String hLl;

            b(String str, kotlin.g.a.b bVar, int i2) {
                this.hLl = str;
                this.gWe = bVar;
                this.hLi = i2;
            }

            public final void run() {
                AppMethodBeat.i(207855);
                if (Util.isNullOrNil(this.hLl)) {
                    kotlin.g.a.b bVar = this.gWe;
                    if (bVar != null) {
                        bVar.invoke(null);
                        AppMethodBeat.o(207855);
                        return;
                    }
                    AppMethodBeat.o(207855);
                    return;
                }
                Bitmap fZ = a.b.gov().fZ(this.hLl);
                if (fZ == null) {
                    j.a gov = a.b.gov();
                    p.g(gov, "AvatarDrawable.Factory.getLoader()");
                    fZ = gov.Wg();
                }
                if (fZ != null) {
                    try {
                        long currentTicks = Util.currentTicks();
                        float f2 = ((float) ao.az(MMApplicationContext.getContext()).y) / ((float) ao.az(MMApplicationContext.getContext()).x);
                        final Bitmap fastblur = BitmapUtil.fastblur(BitmapUtil.extractThumbNail(fZ, fZ.getHeight(), (int) (((float) fZ.getHeight()) / f2), true, false), 20);
                        C0373a aVar = a.hLg;
                        p.g(fastblur, "blurBitmap");
                        C0373a.b(fastblur, this.hLi);
                        c.zx(Util.ticksToNow(currentTicks));
                        MMHandlerThread.postToMainThread(new Runnable(this) {
                            /* class com.tencent.mm.live.b.d.a.C0373a.b.AnonymousClass1 */
                            final /* synthetic */ b hLm;

                            {
                                this.hLm = r1;
                            }

                            public final void run() {
                                AppMethodBeat.i(207852);
                                kotlin.g.a.b bVar = this.hLm.gWe;
                                if (bVar != null) {
                                    bVar.invoke(fastblur);
                                    AppMethodBeat.o(207852);
                                    return;
                                }
                                AppMethodBeat.o(207852);
                            }
                        });
                    } catch (Exception e2) {
                        Log.e(a.TAG, "fastblur failed: " + e2.getMessage());
                        MMHandlerThread.postToMainThread(new Runnable(this) {
                            /* class com.tencent.mm.live.b.d.a.C0373a.b.AnonymousClass2 */
                            final /* synthetic */ b hLm;

                            {
                                this.hLm = r1;
                            }

                            public final void run() {
                                AppMethodBeat.i(207853);
                                kotlin.g.a.b bVar = this.hLm.gWe;
                                if (bVar != null) {
                                    bVar.invoke(null);
                                    AppMethodBeat.o(207853);
                                    return;
                                }
                                AppMethodBeat.o(207853);
                            }
                        });
                    }
                }
                MMHandlerThread.postToMainThread(new Runnable(this) {
                    /* class com.tencent.mm.live.b.d.a.C0373a.b.AnonymousClass3 */
                    final /* synthetic */ b hLm;

                    {
                        this.hLm = r1;
                    }

                    public final void run() {
                        AppMethodBeat.i(207854);
                        kotlin.g.a.b bVar = this.hLm.gWe;
                        if (bVar != null) {
                            bVar.invoke(null);
                            AppMethodBeat.o(207854);
                            return;
                        }
                        AppMethodBeat.o(207854);
                    }
                });
                AppMethodBeat.o(207855);
            }
        }

        public static void a(String str, int i2, kotlin.g.a.b<? super Bitmap, x> bVar) {
            AppMethodBeat.i(207856);
            h.RTc.aX(new b(str, bVar, i2));
            AppMethodBeat.o(207856);
        }

        public static Bitmap b(Bitmap bitmap, int i2) {
            AppMethodBeat.i(207857);
            p.h(bitmap, "src");
            Paint paint = new Paint();
            paint.setAntiAlias(true);
            Canvas canvas = new Canvas(bitmap);
            paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
            canvas.drawColor(i2);
            AppMethodBeat.o(207857);
            return bitmap;
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
        /* renamed from: com.tencent.mm.live.b.d.a$a$a  reason: collision with other inner class name */
        static final class RunnableC0374a implements Runnable {
            final /* synthetic */ kotlin.g.a.b gWe;
            final /* synthetic */ Bitmap hLh;
            final /* synthetic */ int hLi;

            RunnableC0374a(Bitmap bitmap, kotlin.g.a.b bVar, int i2) {
                this.hLh = bitmap;
                this.gWe = bVar;
                this.hLi = i2;
            }

            public final void run() {
                AppMethodBeat.i(207851);
                if (this.hLh == null) {
                    kotlin.g.a.b bVar = this.gWe;
                    if (bVar != null) {
                        bVar.invoke(null);
                        AppMethodBeat.o(207851);
                        return;
                    }
                    AppMethodBeat.o(207851);
                    return;
                }
                try {
                    Bitmap bitmap = this.hLh;
                    float f2 = ((float) ao.az(MMApplicationContext.getContext()).y) / ((float) ao.az(MMApplicationContext.getContext()).x);
                    Bitmap extractThumbNail = BitmapUtil.extractThumbNail(bitmap, bitmap.getHeight(), (int) (((float) bitmap.getHeight()) / f2), true, false);
                    final z.f fVar = new z.f();
                    fVar.SYG = null;
                    try {
                        c cVar = c.hLq;
                        fVar.SYG = (T) c.aHp().b(extractThumbNail, 30.0f);
                    } catch (Throwable th) {
                        fVar.SYG = (T) BitmapUtil.fastblur(extractThumbNail, 30);
                    }
                    if (fVar.SYG != null) {
                        C0373a aVar = a.hLg;
                        C0373a.b(fVar.SYG, this.hLi);
                        MMHandlerThread.postToMainThread(new Runnable(this) {
                            /* class com.tencent.mm.live.b.d.a.C0373a.RunnableC0374a.AnonymousClass1 */
                            final /* synthetic */ RunnableC0374a hLj;

                            {
                                this.hLj = r1;
                            }

                            public final void run() {
                                AppMethodBeat.i(207848);
                                kotlin.g.a.b bVar = this.hLj.gWe;
                                if (bVar != null) {
                                    bVar.invoke(fVar.SYG);
                                    AppMethodBeat.o(207848);
                                    return;
                                }
                                AppMethodBeat.o(207848);
                            }
                        });
                        AppMethodBeat.o(207851);
                        return;
                    }
                    MMHandlerThread.postToMainThread(new Runnable(this) {
                        /* class com.tencent.mm.live.b.d.a.C0373a.RunnableC0374a.AnonymousClass2 */
                        final /* synthetic */ RunnableC0374a hLj;

                        {
                            this.hLj = r1;
                        }

                        public final void run() {
                            AppMethodBeat.i(207849);
                            kotlin.g.a.b bVar = this.hLj.gWe;
                            if (bVar != null) {
                                bVar.invoke(null);
                                AppMethodBeat.o(207849);
                                return;
                            }
                            AppMethodBeat.o(207849);
                        }
                    });
                    AppMethodBeat.o(207851);
                } catch (Exception e2) {
                    Log.e(a.TAG, "fastblur failed: " + e2.getMessage());
                    MMHandlerThread.postToMainThread(new Runnable(this) {
                        /* class com.tencent.mm.live.b.d.a.C0373a.RunnableC0374a.AnonymousClass3 */
                        final /* synthetic */ RunnableC0374a hLj;

                        {
                            this.hLj = r1;
                        }

                        public final void run() {
                            AppMethodBeat.i(207850);
                            kotlin.g.a.b bVar = this.hLj.gWe;
                            if (bVar != null) {
                                bVar.invoke(null);
                                AppMethodBeat.o(207850);
                                return;
                            }
                            AppMethodBeat.o(207850);
                        }
                    });
                    AppMethodBeat.o(207851);
                }
            }
        }

        public static void a(Bitmap bitmap, int i2, kotlin.g.a.b<? super Bitmap, x> bVar) {
            AppMethodBeat.i(207858);
            h.RTc.aX(new RunnableC0374a(bitmap, bVar, i2));
            AppMethodBeat.o(207858);
        }
    }

    static {
        AppMethodBeat.i(207859);
        AppMethodBeat.o(207859);
    }
}

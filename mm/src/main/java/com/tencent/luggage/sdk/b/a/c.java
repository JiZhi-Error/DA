package com.tencent.luggage.sdk.b.a;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Looper;
import android.view.View;
import android.widget.FrameLayout;
import com.google.android.gms.actions.SearchIntents;
import com.tencent.luggage.h.l;
import com.tencent.luggage.sdk.b.a.c.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.jsapi.bc;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.jsapi.i;
import com.tencent.mm.plugin.appbrand.jsapi.k;
import com.tencent.mm.plugin.appbrand.jsapi.p.aa;
import com.tencent.mm.plugin.appbrand.page.a.h;
import com.tencent.mm.plugin.appbrand.page.ac;
import com.tencent.mm.plugin.appbrand.page.ae;
import com.tencent.mm.plugin.appbrand.page.bn;
import com.tencent.mm.plugin.appbrand.page.i;
import com.tencent.mm.plugin.appbrand.s;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vending.g.g;
import java.util.HashMap;

public class c extends ac implements d, k {
    private final Runnable czo = new Runnable() {
        /* class com.tencent.luggage.sdk.b.a.c.AnonymousClass1 */

        public final void run() {
            AppMethodBeat.i(146717);
            c.this.NS();
            AppMethodBeat.o(146717);
        }
    };
    private MMHandler czp;

    public static final class a extends e {
        static final int CTRL_INDEX = 237;
        static final String NAME = "config_navigationBarRightButton";
    }

    static /* synthetic */ void b(c cVar) {
        AppMethodBeat.i(146740);
        cVar.NU();
        AppMethodBeat.o(146740);
    }

    @Override // com.tencent.mm.plugin.appbrand.page.ac
    public /* synthetic */ s NY() {
        AppMethodBeat.i(146737);
        d NQ = NQ();
        AppMethodBeat.o(146737);
        return NQ;
    }

    @Override // com.tencent.mm.plugin.appbrand.page.ac, com.tencent.mm.plugin.appbrand.jsapi.k
    public /* synthetic */ AppBrandRuntime getRuntime() {
        AppMethodBeat.i(146738);
        com.tencent.luggage.sdk.d.d NP = NP();
        AppMethodBeat.o(146738);
        return NP;
    }

    public c(Class<? extends ae> cls) {
        super(cls);
        AppMethodBeat.i(146723);
        AppMethodBeat.o(146723);
    }

    public c() {
        super(bn.class);
        AppMethodBeat.i(146724);
        AppMethodBeat.o(146724);
    }

    public com.tencent.luggage.sdk.d.d NP() {
        AppMethodBeat.i(146725);
        com.tencent.luggage.sdk.d.d dVar = (com.tencent.luggage.sdk.d.d) super.getRuntime();
        AppMethodBeat.o(146725);
        return dVar;
    }

    public d NQ() {
        AppMethodBeat.i(146726);
        d dVar = (d) super.NY();
        AppMethodBeat.o(146726);
        return dVar;
    }

    @Override // com.tencent.mm.plugin.appbrand.page.ac
    public void NR() {
        AppMethodBeat.i(146728);
        super.NR();
        bU(false);
        if (this.czp != null) {
            this.czp.removeCallbacksAndMessages(null);
        }
        AppMethodBeat.o(146728);
    }

    @Override // com.tencent.mm.plugin.appbrand.page.ac
    public boolean dE(String str) {
        int i2 = 0;
        AppMethodBeat.i(229831);
        boolean dE = super.dE(str);
        if (dE) {
            bU(false);
            while (true) {
                if (i2 >= this.noq.getChildCount()) {
                    break;
                }
                View childAt = this.noq.getChildAt(i2);
                if (childAt instanceof i) {
                    this.noq.removeView(childAt);
                    break;
                }
                i2++;
            }
        }
        AppMethodBeat.o(229831);
        return dE;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.f, com.tencent.mm.plugin.appbrand.jsapi.g
    public final void a(bc bcVar, int[] iArr) {
        AppMethodBeat.i(229832);
        if (bcVar instanceof b) {
            Log.i("MicroMsg.AppBrandPageViewLU", "publish onPageNotFound, appId:%s, webviewId:%d, data:%s", getAppId(), Integer.valueOf(getComponentId()), bcVar.getData());
        }
        super.a(bcVar, iArr);
        AppMethodBeat.o(229832);
    }

    public final void bU(boolean z) {
        AppMethodBeat.i(229833);
        removeCallbacks(this.czo);
        if (z) {
            adM("cancelShowErrorPageViewRunnable");
        }
        AppMethodBeat.o(229833);
    }

    public final void NS() {
        AppMethodBeat.i(146731);
        if (!isRunning()) {
            Log.w("MicroMsg.AppBrandPageViewLU", "showErrorPageView but not running, appId[%s] url[%s]", getAppId(), this.lBI);
            AppMethodBeat.o(146731);
            return;
        }
        Log.i("MicroMsg.AppBrandPageViewLU", "showErrorPageView appId:%s, url:%s", getAppId(), this.lBI);
        bRw();
        this.noq.addView(new i(getContext(), NP()));
        AppMethodBeat.o(146731);
    }

    /* access modifiers changed from: package-private */
    public static final class b extends com.tencent.mm.plugin.appbrand.jsapi.s {
        static final int CTRL_INDEX = 429;
        static final String NAME = "onPageNotFound";

        private b() {
        }

        /* synthetic */ b(byte b2) {
            this();
        }
    }

    public com.tencent.mm.vending.g.c<Bitmap> NT() {
        AppMethodBeat.i(146732);
        com.tencent.mm.vending.g.c<_Ret> f2 = g.hdG().f(new com.tencent.mm.vending.c.a<Bitmap, Void>() {
            /* class com.tencent.luggage.sdk.b.a.c.AnonymousClass2 */

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // com.tencent.mm.vending.c.a
            public final /* synthetic */ Bitmap call(Void r12) {
                AppMethodBeat.i(146720);
                Log.d("MicroMsg.AppBrandPageViewLU", "getScreenshotForSharing entered");
                final View contentView = c.this.nmX.getContentView();
                if (contentView == null) {
                    AppMethodBeat.o(146720);
                } else {
                    final int width = c.this.nmX.getWidth();
                    final int height = c.this.nmX.getHeight();
                    final int webScrollX = c.this.nmX.getWebScrollX();
                    final int webScrollY = c.this.nmX.getWebScrollY();
                    if (width == 0 || height == 0) {
                        AppMethodBeat.o(146720);
                    } else {
                        contentView.scrollTo(0, 0);
                        final com.tencent.mm.vending.g.b hdH = g.hdH();
                        c.this.nmX.i(new Runnable() {
                            /* class com.tencent.luggage.sdk.b.a.c.AnonymousClass2.AnonymousClass1 */

                            public final void run() {
                                Bitmap bitmap;
                                int width;
                                int height;
                                AppMethodBeat.i(146719);
                                try {
                                    bitmap = c.this.bRB();
                                } catch (OutOfMemoryError e2) {
                                    Log.e("MicroMsg.AppBrandPageViewLU", "postOnReRendered getScreenshotWithoutDecor oom, appId[%s] url[%s]", c.this.getAppId(), c.this.lBI);
                                    bitmap = null;
                                } catch (NullPointerException e3) {
                                    Log.e("MicroMsg.AppBrandPageViewLU", "postOnReRendered getScreenshotWithoutDecor npe(%s), appId[%s] url[%s]", e3, c.this.getAppId(), c.this.lBI);
                                    bitmap = null;
                                }
                                if (bitmap == null || bitmap.getWidth() <= 0 || bitmap.getHeight() <= 0) {
                                    Object[] objArr = new Object[2];
                                    if (bitmap == null) {
                                        width = -1;
                                    } else {
                                        width = bitmap.getWidth();
                                    }
                                    objArr[0] = Integer.valueOf(width);
                                    if (bitmap == null) {
                                        height = -1;
                                    } else {
                                        height = bitmap.getHeight();
                                    }
                                    objArr[1] = Integer.valueOf(height);
                                    Log.e("MicroMsg.AppBrandPageViewLU", "getScreenshotWithoutDecor bitmap invalid width(%d), height(%d)", objArr);
                                    hdH.G(null);
                                } else {
                                    try {
                                        hdH.G(Bitmap.createBitmap(bitmap, 0, 0, Math.min(bitmap.getWidth(), width), Math.min(bitmap.getHeight(), height)));
                                        try {
                                            bitmap.recycle();
                                        } catch (Throwable th) {
                                        }
                                    } catch (OutOfMemoryError e4) {
                                        Log.e("MicroMsg.AppBrandPageViewLU", "postOnReRendered getScreenshotWithoutDecor cut final bitmap oom, appId[%s] url[%s]", c.this.getAppId(), c.this.lBI);
                                        hdH.G(null);
                                        bitmap.recycle();
                                    } catch (Throwable th2) {
                                    }
                                }
                                c.this.a(new i.e() {
                                    /* class com.tencent.luggage.sdk.b.a.c.AnonymousClass2.AnonymousClass1.AnonymousClass1 */

                                    @Override // com.tencent.mm.plugin.appbrand.jsapi.i.e
                                    public final void NZ() {
                                        AppMethodBeat.i(169429);
                                        c.this.b(this);
                                        contentView.scrollTo(webScrollX, webScrollY);
                                        AppMethodBeat.o(169429);
                                    }
                                });
                                AppMethodBeat.o(146719);
                            }
                        });
                        AppMethodBeat.o(146720);
                    }
                }
                return null;
            }
        });
        AppMethodBeat.o(146732);
        return f2;
    }

    public final void NV() {
        AppMethodBeat.i(229834);
        P(new Runnable() {
            /* class com.tencent.luggage.sdk.b.a.c.AnonymousClass3 */

            public final void run() {
                AppMethodBeat.i(146721);
                if (c.this.nmX == null) {
                    AppMethodBeat.o(146721);
                } else if (c.this.nmX.getWebScrollY() == 0) {
                    AppMethodBeat.o(146721);
                } else {
                    c.a(c.this);
                    c.this.nmX.setVerticalScrollBarEnabled(false);
                    AppMethodBeat.o(146721);
                }
            }
        });
        a(new i.e() {
            /* class com.tencent.luggage.sdk.b.a.c.AnonymousClass4 */

            @Override // com.tencent.mm.plugin.appbrand.jsapi.i.e
            public final void NZ() {
                AppMethodBeat.i(169430);
                c.this.b(this);
                c.b(c.this);
                c.this.nmX.setVerticalScrollBarEnabled(true);
                AppMethodBeat.o(169430);
            }
        });
        AppMethodBeat.o(229834);
    }

    @Override // com.tencent.mm.plugin.appbrand.page.ac
    public final boolean isFullScreen() {
        AppMethodBeat.i(146734);
        h hVar = (h) S(h.class);
        if (hVar == null || !hVar.Nm()) {
            AppMethodBeat.o(146734);
            return false;
        }
        AppMethodBeat.o(146734);
        return true;
    }

    @Override // com.tencent.mm.plugin.appbrand.page.ac
    public final void bV(boolean z) {
        AppMethodBeat.i(146735);
        com.tencent.mm.plugin.appbrand.permission.d dVar = NP().cCn;
        if (dVar.a(NQ(), aa.class) || dVar.a(this, aa.class)) {
            super.bV(z);
            AppMethodBeat.o(146735);
            return;
        }
        super.bV(true);
        AppMethodBeat.o(146735);
    }

    public void NW() {
        boolean z;
        AppMethodBeat.i(146736);
        if (NP().brh().getPageCount() == 1) {
            com.tencent.mm.plugin.appbrand.page.b bVar = this.nqQ;
            if (bVar.nno || !bVar.nnp) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                bRi().setNavHidden(true);
                AppMethodBeat.o(146736);
                return;
            }
        }
        bRi().setNavHidden(false);
        AppMethodBeat.o(146736);
    }

    private MMHandler NX() {
        AppMethodBeat.i(229835);
        if (this.czp == null) {
            this.czp = new MMHandler(Looper.getMainLooper());
        }
        MMHandler mMHandler = this.czp;
        AppMethodBeat.o(229835);
        return mMHandler;
    }

    @Override // com.tencent.mm.plugin.appbrand.page.d
    public final void post(Runnable runnable) {
        AppMethodBeat.i(229836);
        if (NP() == null || !NP().OS()) {
            super.post(runnable);
        } else if (runnable != null) {
            NX().post(runnable);
            AppMethodBeat.o(229836);
            return;
        }
        AppMethodBeat.o(229836);
    }

    @Override // com.tencent.mm.plugin.appbrand.page.d
    public final void c(Runnable runnable, long j2) {
        AppMethodBeat.i(229837);
        if (NP() == null || !NP().OS()) {
            super.c(runnable, j2);
        } else if (runnable != null) {
            NX().postDelayed(runnable, j2);
            AppMethodBeat.o(229837);
            return;
        }
        AppMethodBeat.o(229837);
    }

    @Override // com.tencent.mm.plugin.appbrand.page.d
    public final void removeCallbacks(Runnable runnable) {
        AppMethodBeat.i(229838);
        if (!(this.czp == null || runnable == null)) {
            this.czp.removeCallbacks(runnable);
        }
        super.removeCallbacks(runnable);
        AppMethodBeat.o(229838);
    }

    @Override // com.tencent.mm.plugin.appbrand.page.ac
    public final void dF(String str) {
        AppMethodBeat.i(146729);
        this.nqZ = true;
        boolean a2 = NP().cCn.a(this, b.class);
        Log.i("MicroMsg.AppBrandPageViewLU", "publishPageNotFound appId:%s, hasPermission:%b, url:%s", getAppId(), Boolean.valueOf(a2), str);
        if (!a2) {
            NS();
            AppMethodBeat.o(146729);
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("path", l.dM(str));
        hashMap.put(SearchIntents.EXTRA_QUERY, l.dN(str));
        hashMap.put("rawPath", str);
        hashMap.put("isEntryPage", Boolean.valueOf(Util.nullAsNil(str).equals(NP().brs())));
        a(new b((byte) 0).L(hashMap), (int[]) null);
        c(this.czo, 2000);
        AppMethodBeat.o(146729);
    }

    private void NU() {
        Bitmap bitmap;
        AppMethodBeat.i(146733);
        FrameLayout frameLayout = (FrameLayout) this.noq.findViewById(R.id.pp);
        if (frameLayout != null) {
            frameLayout.setVisibility(8);
            if (frameLayout.getBackground() instanceof BitmapDrawable) {
                bitmap = ((BitmapDrawable) frameLayout.getBackground()).getBitmap();
            } else {
                bitmap = null;
            }
            frameLayout.setBackground(null);
            if (bitmap != null) {
                bitmap.recycle();
            }
        }
        AppMethodBeat.o(146733);
    }

    static /* synthetic */ void a(c cVar) {
        AppMethodBeat.i(146739);
        FrameLayout frameLayout = (FrameLayout) cVar.noq.findViewById(R.id.pp);
        if (frameLayout == null) {
            frameLayout = new FrameLayout(cVar.getContext());
            frameLayout.setId(R.id.pp);
            cVar.noq.addView(frameLayout, -1, -1);
        }
        frameLayout.setBackground(null);
        frameLayout.setVisibility(0);
        frameLayout.bringToFront();
        try {
            Log.d("MicroMsg.AppBrandPageViewLU", "showScreenshotCover get screenshot");
            frameLayout.setBackground(new BitmapDrawable(cVar.getContext().getResources(), cVar.bRB()));
            AppMethodBeat.o(146739);
        } catch (OutOfMemoryError e2) {
            Log.e("MicroMsg.AppBrandPageViewLU", "showScreenshotCover oom, appId = %s, path = %s", cVar.getAppId(), cVar.lBI);
            cVar.NU();
            AppMethodBeat.o(146739);
        }
    }
}

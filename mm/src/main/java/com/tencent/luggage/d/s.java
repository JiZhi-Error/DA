package com.tencent.luggage.d;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import com.tencent.luggage.d.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import me.imid.swipebacklayout.lib.SwipeBackLayout;

public class s extends h implements a {
    private q ctJ;
    public p ctS;
    SwipeBackLayout ctT;
    private String ctU;
    public View mContentView;
    public Bundle mParams;

    public s(j jVar, Bundle bundle) {
        this(jVar, null, bundle);
    }

    public s(j jVar, p pVar, Bundle bundle) {
        super(jVar);
        AppMethodBeat.i(140451);
        this.ctU = null;
        this.ctJ = new q() {
            /* class com.tencent.luggage.d.s.AnonymousClass2 */

            @Override // com.tencent.luggage.d.q
            public final void cV(String str) {
                AppMethodBeat.i(140444);
                if (s.this.LL() != null) {
                    s.this.LL().a(s.this, str);
                }
                AppMethodBeat.o(140444);
            }

            @Override // com.tencent.luggage.d.q
            public final void cW(String str) {
                AppMethodBeat.i(140445);
                if (s.this.LL() != null) {
                    s.this.LL().b(s.this, str);
                }
                s.this.Lh();
                AppMethodBeat.o(140445);
            }

            @Override // com.tencent.luggage.d.q
            public final String LJ() {
                AppMethodBeat.i(140446);
                String a2 = s.a(s.this);
                AppMethodBeat.o(140446);
                return a2;
            }

            @Override // com.tencent.luggage.d.q
            public final WebResourceResponse a(WebResourceRequest webResourceRequest, Bundle bundle) {
                AppMethodBeat.i(140447);
                if (s.this.LL() != null) {
                    WebResourceResponse a2 = s.this.LL().a(webResourceRequest, bundle);
                    AppMethodBeat.o(140447);
                    return a2;
                }
                AppMethodBeat.o(140447);
                return null;
            }
        };
        this.mParams = bundle == null ? new Bundle() : bundle;
        this.ctS = pVar;
        p pVar2 = this.ctS;
        pVar2 = pVar2 == null ? this.ctg.Lq() : pVar2;
        this.ctS = pVar2 == null ? new p(this.mContext, this.ctg.Lr()) : pVar2;
        p pVar3 = this.ctS;
        pVar3.a(this.ctg.Lz(), this);
        pVar3.ctJ = this.ctJ;
        View Lf = Lf();
        this.ctT = new SwipeBackLayout(this.mContext);
        this.ctT.setScrimColor(0);
        this.ctT.addView(Lf);
        this.ctT.setContentView(Lf);
        final boolean[] zArr = {false};
        this.ctT.a(new SwipeBackLayout.a() {
            /* class com.tencent.luggage.d.s.AnonymousClass1 */

            @Override // me.imid.swipebacklayout.lib.SwipeBackLayout.a
            public final void LN() {
                AppMethodBeat.i(140442);
                if (s.this.ctg.Lx().size() <= 1) {
                    s.this.ctT.setEnableGesture(false);
                }
                AppMethodBeat.o(140442);
            }

            @Override // me.imid.swipebacklayout.lib.SwipeBackLayout.a
            public final void n(MotionEvent motionEvent) {
            }

            @Override // me.imid.swipebacklayout.lib.SwipeBackLayout.a
            public final int bS(boolean z) {
                return 1;
            }

            @Override // me.imid.swipebacklayout.lib.SwipeBackLayout.a
            public final void i(int i2, float f2) {
                h hVar;
                AppMethodBeat.i(140443);
                s sVar = s.this;
                int indexOf = sVar.ctg.Lx().indexOf(sVar);
                if (indexOf >= sVar.ctg.Lx().size() - 1) {
                    hVar = null;
                } else {
                    hVar = sVar.ctg.Lx().get(indexOf + 1);
                }
                if (hVar == null) {
                    AppMethodBeat.o(140443);
                    return;
                }
                if (Float.compare(1.0f, f2) <= 0 && !zArr[0]) {
                    View contentView = hVar.getContentView();
                    contentView.clearAnimation();
                    contentView.setTranslationX(0.0f);
                    s.this.ctg.Ly().bR(false);
                    zArr[0] = true;
                }
                Log.i("", "scrollPercent %f", Float.valueOf(f2));
                AppMethodBeat.o(140443);
            }
        });
        this.mContentView = this.ctT;
        AppMethodBeat.o(140451);
    }

    public final Bundle getParams() {
        return this.mParams;
    }

    public final void LK() {
        AppMethodBeat.i(140452);
        if (this.ctT != null) {
            this.ctT.setEnableGesture(false);
        }
        AppMethodBeat.o(140452);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.luggage.d.h
    public View Lf() {
        AppMethodBeat.i(140454);
        View view = this.ctS.getView();
        AppMethodBeat.o(140454);
        return view;
    }

    @Override // com.tencent.luggage.d.h
    public final View getContentView() {
        return this.mContentView;
    }

    @Override // com.tencent.luggage.d.h
    public final void a(h.a aVar) {
        AppMethodBeat.i(140455);
        if (aVar instanceof a) {
            this.cth = aVar;
            AppMethodBeat.o(140455);
            return;
        }
        this.cth = new a(aVar);
        AppMethodBeat.o(140455);
    }

    public final a LL() {
        return (a) this.cth;
    }

    @Override // com.tencent.luggage.d.h
    public void destroy() {
        AppMethodBeat.i(140457);
        Ll();
        p pVar = this.ctS;
        ViewParent parent = pVar.getView().getParent();
        if (parent instanceof ViewGroup) {
            Log.i("Luggage.LuggageWebCore", "removeSelfFromParent");
            ((ViewGroup) parent).removeView(pVar.getView());
        }
        LM();
        AppMethodBeat.o(140457);
    }

    /* access modifiers changed from: protected */
    public String LJ() {
        return "";
    }

    @Override // com.tencent.luggage.d.a
    public final n Lc() {
        return this.ctS;
    }

    public static class a extends h.a {
        public a() {
        }

        protected a(h.a aVar) {
            super(aVar);
        }

        public void a(s sVar, String str) {
            AppMethodBeat.i(140448);
            if (this.ctj instanceof a) {
                ((a) this.ctj).a(sVar, str);
            }
            AppMethodBeat.o(140448);
        }

        public void b(s sVar, String str) {
            AppMethodBeat.i(140449);
            if (this.ctj instanceof a) {
                ((a) this.ctj).b(sVar, str);
            }
            AppMethodBeat.o(140449);
        }

        public WebResourceResponse a(WebResourceRequest webResourceRequest, Bundle bundle) {
            AppMethodBeat.i(140450);
            if (this.ctj instanceof a) {
                WebResourceResponse a2 = ((a) this.ctj).a(webResourceRequest, bundle);
                AppMethodBeat.o(140450);
                return a2;
            }
            AppMethodBeat.o(140450);
            return null;
        }
    }

    @Override // com.tencent.luggage.d.h
    public void g(String str, Bundle bundle) {
        AppMethodBeat.i(140453);
        this.ctS.loadUrl(str);
        AppMethodBeat.o(140453);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.luggage.d.h
    public boolean onBackPressed() {
        AppMethodBeat.i(140456);
        if (this.ctS.ctK.canGoBack()) {
            this.ctS.ctK.goBack();
            AppMethodBeat.o(140456);
            return true;
        }
        AppMethodBeat.o(140456);
        return false;
    }

    public void LM() {
        AppMethodBeat.i(221201);
        this.ctS.destroy();
        AppMethodBeat.o(221201);
    }

    static /* synthetic */ String a(s sVar) {
        AppMethodBeat.i(140458);
        if (sVar.ctU == null) {
            String LJ = sVar.LJ();
            if (TextUtils.isEmpty(LJ)) {
                LJ = "";
            }
            sVar.ctU = LJ;
        }
        String str = sVar.ctU;
        AppMethodBeat.o(140458);
        return str;
    }
}

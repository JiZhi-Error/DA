package com.tencent.mm.plugin.appbrand.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.v4.view.u;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.luggage.sdk.d.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.ac.g;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.h;
import com.tencent.mm.plugin.appbrand.widget.actionbar.e;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.statusbar.b;
import kotlin.g.a.a;
import kotlin.x;

@SuppressLint({"ViewConstructor"})
public class m extends b implements ab, ad {
    private AppBrandRuntime kEc;
    private WxaAttributes.WxaVersionInfo lgq;
    private e nUs;
    private a<x> nUt;

    public m(Context context, AppBrandRuntime appBrandRuntime, WxaAttributes.WxaVersionInfo wxaVersionInfo) {
        super(context);
        AppMethodBeat.i(147671);
        this.kEc = appBrandRuntime;
        this.lgq = wxaVersionInfo;
        setBackgroundColor(getResources().getColor(R.color.f3045c));
        this.nUs = new aj(context);
        this.nUs.setBackgroundColor(com.tencent.mm.cb.a.n(context, R.color.ac_));
        addView(this.nUs.getActionView());
        bWX();
        AppMethodBeat.o(147671);
    }

    /* access modifiers changed from: protected */
    public void bWX() {
        AppBrandInitConfig OU;
        int i2;
        int i3;
        int i4;
        AppMethodBeat.i(227620);
        this.nUs.gz(false);
        AnonymousClass1 r0 = new View.OnClickListener() {
            /* class com.tencent.mm.plugin.appbrand.ui.m.AnonymousClass1 */

            public final void onClick(View view) {
                AppMethodBeat.i(147669);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/ui/AppBrandPluginLoadingSplash$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (m.this.kEc != null) {
                    h.a(m.this.kEc.mAppId, h.d.CLOSE);
                    m.this.kEc.finish();
                } else if (m.this.nUt != null) {
                    m.this.nUt.invoke();
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/ui/AppBrandPluginLoadingSplash$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(147669);
            }
        };
        this.nUs.setCloseButtonClickListener(r0);
        this.nUs.setBackButtonClickListener(r0);
        int color = getContext().getResources().getColor(R.color.f3045c);
        int color2 = getContext().getResources().getColor(R.color.a2x);
        String str = "white";
        if (this.kEc == null) {
            OU = null;
        } else {
            OU = this.kEc.OU();
        }
        if ((OU instanceof AppBrandInitConfigWC) && ((AppBrandInitConfigWC) OU).kHL.isEnable() && ((AppBrandInitConfigWC) OU).kHL.kuZ) {
            i3 = getContext().getResources().getColor(R.color.am);
            i2 = getContext().getResources().getColor(R.color.ae);
            str = "white";
            this.nUs.setLoadingIconVisibility(false);
        } else if (this.lgq != null) {
            if (ao.isDarkMode()) {
                if (!Util.isNullOrNil(this.lgq.lhf)) {
                    i4 = g.cu(this.lgq.lhf, getContext().getResources().getColor(R.color.f3045c));
                } else {
                    i4 = color;
                }
                if (!Util.isNullOrNil(this.lgq.lhe)) {
                    i2 = g.cu(this.lgq.lhe, getContext().getResources().getColor(R.color.a2x));
                } else {
                    i2 = color2;
                }
                str = "white";
                i3 = i4;
            } else {
                if (!Util.isNullOrNil(this.lgq.lhd)) {
                    color = g.cu(this.lgq.lhd, getContext().getResources().getColor(R.color.f3045c));
                }
                if (!Util.isNullOrNil(this.lgq.lhc)) {
                    color2 = g.cu(this.lgq.lhc, getContext().getResources().getColor(R.color.a2x));
                }
                str = "black";
                i2 = color2;
                i3 = color;
            }
            this.nUs.setLoadingIconVisibility(true);
        } else {
            i2 = color2;
            i3 = color;
        }
        b(getContext().getString(R.string.hr), i3, str, i2);
        yu(i3);
        AppMethodBeat.o(227620);
    }

    /* access modifiers changed from: protected */
    public final void b(String str, int i2, String str2, int i3) {
        AppMethodBeat.i(227621);
        this.nUs.setMainTitle(str);
        this.nUs.setForegroundStyle(str2);
        this.nUs.setLoadingIconVisibility(true);
        this.nUs.setForegroundColor(i3);
        S(i2, "black".equals(str2));
        AppMethodBeat.o(227621);
    }

    public void setLoadingIconVisibility(boolean z) {
        AppMethodBeat.i(227622);
        this.nUs.setLoadingIconVisibility(z);
        AppMethodBeat.o(227622);
    }

    @Override // com.tencent.mm.plugin.appbrand.ui.ab
    public final void eo(String str, String str2) {
        AppMethodBeat.i(147672);
        this.nUs.setMainTitle(getContext().getString(R.string.hr));
        AppMethodBeat.o(147672);
    }

    @Override // com.tencent.mm.plugin.appbrand.ui.ab
    public final void z(final a<x> aVar) {
        AppMethodBeat.i(227623);
        post(new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.ui.m.AnonymousClass2 */

            public final void run() {
                AppMethodBeat.i(147670);
                m.this.setVisibility(8);
                if (m.this.getParent() != null) {
                    ((ViewGroup) m.this.getParent()).removeView(m.this);
                }
                m.this.nUs.destroy();
                if (aVar != null) {
                    aVar.invoke();
                }
                AppMethodBeat.o(147670);
            }
        });
        AppMethodBeat.o(227623);
    }

    @Override // com.tencent.mm.plugin.appbrand.ui.ab
    public View getView() {
        return this;
    }

    @Override // com.tencent.mm.plugin.appbrand.ui.ab
    public void setProgress(int i2) {
    }

    @Override // com.tencent.mm.plugin.appbrand.ui.ab
    public final void yu(int i2) {
        AppMethodBeat.i(147674);
        setBackgroundColor(android.support.v4.graphics.b.v(i2, getContext().getResources().getColor(R.color.f3045c)));
        AppMethodBeat.o(147674);
    }

    @Override // com.tencent.mm.plugin.appbrand.ui.ad
    public final void C(a<x> aVar) {
        this.nUt = aVar;
    }

    private boolean OS() {
        AppMethodBeat.i(227624);
        if (this.kEc == null || !(this.kEc instanceof d) || !((d) this.kEc).OS()) {
            AppMethodBeat.o(227624);
            return false;
        }
        AppMethodBeat.o(227624);
        return true;
    }

    public final boolean post(Runnable runnable) {
        AppMethodBeat.i(227625);
        if (runnable == null) {
            AppMethodBeat.o(227625);
            return false;
        } else if (u.aD(this) || !OS()) {
            boolean post = super.post(runnable);
            AppMethodBeat.o(227625);
            return post;
        } else {
            MMHandlerThread.postToMainThread(runnable);
            AppMethodBeat.o(227625);
            return true;
        }
    }

    public final boolean postDelayed(Runnable runnable, long j2) {
        AppMethodBeat.i(227626);
        if (runnable == null) {
            AppMethodBeat.o(227626);
            return false;
        } else if (u.aD(this) || !OS()) {
            boolean postDelayed = super.postDelayed(runnable, j2);
            AppMethodBeat.o(227626);
            return postDelayed;
        } else {
            MMHandlerThread.postToMainThreadDelayed(runnable, j2);
            AppMethodBeat.o(227626);
            return true;
        }
    }
}

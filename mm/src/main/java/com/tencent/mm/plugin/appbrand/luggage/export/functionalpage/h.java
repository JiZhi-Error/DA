package com.tencent.mm.plugin.appbrand.luggage.export.functionalpage;

import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.ui.ab;
import com.tencent.mm.ui.base.q;
import com.tencent.mm.ui.statusbar.b;
import kotlin.g.a.a;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0018\u0010\n\u001a\u00020\u000b2\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\rH\u0016J\u0010\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u000bH\u0014J\b\u0010\u0014\u001a\u00020\u000bH\u0014J\u0012\u0010\u0015\u001a\u00020\u000b2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0012H\u0016J\u0018\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0019H\u0016J\u0010\u0010\u001b\u001a\u00020\u000b2\u0006\u0010\u001c\u001a\u00020\u0010H\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000¨\u0006\u001d"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/FunctionalLoadingSplash;", "Lcom/tencent/mm/ui/statusbar/DrawStatusBarFrameLayout;", "Lcom/tencent/mm/plugin/appbrand/ui/IAppBrandLoadingSplash;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "isHide", "", "progresDialog", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "animateHide", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lkotlin/Function0;", "backgroundColor", "color", "", "getView", "Landroid/view/View;", "onAttachedToWindow", "onDetachedFromWindow", "onViewAdded", "child", "setAppInfo", "icon", "", "name", "setProgress", "progress", "plugin-appbrand-integration_release"})
public final class h extends b implements ab {
    private boolean eea;
    private q naw;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public h(Context context) {
        super(context);
        p.h(context, "context");
        AppMethodBeat.i(50875);
        S(0, true);
        setBackgroundColor(0);
        AppMethodBeat.o(50875);
    }

    @Override // com.tencent.mm.plugin.appbrand.ui.ab
    public final void yu(int i2) {
    }

    public final void onViewAdded(View view) {
        AppMethodBeat.i(50871);
        super.onViewAdded(view);
        if (view != null) {
            if (view.getId() == R.id.t6) {
                ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                if (!(layoutParams instanceof FrameLayout.LayoutParams)) {
                    layoutParams = null;
                }
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
                if (layoutParams2 != null) {
                    layoutParams2.gravity = 17;
                }
                view.setLayoutParams(view.getLayoutParams());
            }
            AppMethodBeat.o(50871);
            return;
        }
        AppMethodBeat.o(50871);
    }

    @Override // com.tencent.mm.ui.statusbar.b
    public final void onAttachedToWindow() {
        AppMethodBeat.i(50872);
        super.onAttachedToWindow();
        if (this.eea) {
            AppMethodBeat.o(50872);
            return;
        }
        Context context = getContext();
        getResources().getString(R.string.zb);
        this.naw = com.tencent.mm.ui.base.h.a(context, getResources().getString(R.string.ekc), false, (DialogInterface.OnCancelListener) null);
        AppMethodBeat.o(50872);
    }

    /* access modifiers changed from: protected */
    public final void onDetachedFromWindow() {
        q qVar;
        AppMethodBeat.i(50873);
        super.onDetachedFromWindow();
        q qVar2 = this.naw;
        if (qVar2 == null) {
            AppMethodBeat.o(50873);
        } else if (!qVar2.isShowing() || (qVar = this.naw) == null) {
            AppMethodBeat.o(50873);
        } else {
            qVar.dismiss();
            AppMethodBeat.o(50873);
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.ui.ab
    public final void eo(String str, String str2) {
        AppMethodBeat.i(50874);
        p.h(str, "icon");
        p.h(str2, "name");
        AppMethodBeat.o(50874);
    }

    @Override // com.tencent.mm.plugin.appbrand.ui.ab
    public final void z(a<x> aVar) {
        q qVar;
        AppMethodBeat.i(228834);
        this.eea = true;
        q qVar2 = this.naw;
        if (!(qVar2 == null || !qVar2.isShowing() || (qVar = this.naw) == null)) {
            qVar.dismiss();
        }
        if (aVar != null) {
            aVar.invoke();
            AppMethodBeat.o(228834);
            return;
        }
        AppMethodBeat.o(228834);
    }

    @Override // com.tencent.mm.plugin.appbrand.ui.ab
    public final View getView() {
        return this;
    }

    @Override // com.tencent.mm.plugin.appbrand.ui.ab
    public final void setProgress(int i2) {
    }
}

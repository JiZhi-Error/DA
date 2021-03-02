package com.tencent.mm.view.popview;

import android.content.Context;
import android.view.View;
import android.view.WindowManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.b.b.ai;
import com.tencent.mm.plugin.appbrand.jsapi.ac.e;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001a\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\u001a\u0010\u0010\u001a\u00020\u00112\u0006\u0010\r\u001a\u00020\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\b\u0010\u0012\u001a\u00020\u0011H\u0016J\u001a\u0010\u0013\u001a\u00020\u00112\u0006\u0010\r\u001a\u00020\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, hxF = {"Lcom/tencent/mm/view/popview/SmileyPopupHelper;", "Lcom/tencent/mm/view/popview/BasePopupHelper;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "lastAnchor", "Landroid/view/View;", "smileyPopView", "Lcom/tencent/mm/view/popview/AbstractPopView;", "windowManager", "Landroid/view/WindowManager;", e.a.NAME, "", "anchor", "item", "", "onMove", "", e.C0599e.NAME, "updatePopupView", "plugin-emojisdk_release"})
public final class d extends a {
    private View Rqc;
    private AbstractPopView Rqz;
    private final Context context;
    private final WindowManager windowManager;

    public d(Context context2) {
        p.h(context2, "context");
        AppMethodBeat.i(184008);
        this.context = context2;
        Object systemService = this.context.getSystemService("window");
        if (systemService == null) {
            t tVar = new t("null cannot be cast to non-null type android.view.WindowManager");
            AppMethodBeat.o(184008);
            throw tVar;
        }
        this.windowManager = (WindowManager) systemService;
        AppMethodBeat.o(184008);
    }

    @Override // com.tencent.mm.view.popview.a
    public final boolean c(View view, Object obj) {
        AppMethodBeat.i(184004);
        p.h(view, "anchor");
        if (!(obj instanceof ai) || !view.isEnabled()) {
            AppMethodBeat.o(184004);
            return false;
        }
        this.Rqc = view;
        e(view, obj);
        AppMethodBeat.o(184004);
        return true;
    }

    @Override // com.tencent.mm.view.popview.a
    public final void d(View view, Object obj) {
        AppMethodBeat.i(184005);
        p.h(view, "anchor");
        if (p.j(this.Rqc, view)) {
            AppMethodBeat.o(184005);
            return;
        }
        this.Rqc = view;
        e(view, obj);
        AppMethodBeat.o(184005);
    }

    private final void e(View view, Object obj) {
        WindowManager.LayoutParams layoutParams;
        AppMethodBeat.i(184006);
        if (!(obj instanceof ai) || !view.isEnabled()) {
            AbstractPopView abstractPopView = this.Rqz;
            if (abstractPopView != null) {
                abstractPopView.setVisibility(8);
                AppMethodBeat.o(184006);
                return;
            }
            AppMethodBeat.o(184006);
            return;
        }
        if (this.Rqz == null) {
            this.Rqz = c.b(this.context, obj);
            WindowManager windowManager2 = this.windowManager;
            AbstractPopView abstractPopView2 = this.Rqz;
            AbstractPopView abstractPopView3 = this.Rqz;
            windowManager2.addView(abstractPopView2, abstractPopView3 != null ? abstractPopView3.getWindowLayoutParams() : null);
        }
        AbstractPopView abstractPopView4 = this.Rqz;
        if (abstractPopView4 != null) {
            abstractPopView4.setVisibility(0);
        }
        c.a(this.Rqz, obj);
        AbstractPopView abstractPopView5 = this.Rqz;
        if (abstractPopView5 != null) {
            abstractPopView5.hI(view);
        }
        WindowManager windowManager3 = this.windowManager;
        AbstractPopView abstractPopView6 = this.Rqz;
        AbstractPopView abstractPopView7 = this.Rqz;
        if (abstractPopView7 != null) {
            layoutParams = abstractPopView7.getWindowLayoutParams();
        } else {
            layoutParams = null;
        }
        windowManager3.updateViewLayout(abstractPopView6, layoutParams);
        AppMethodBeat.o(184006);
    }

    @Override // com.tencent.mm.view.popview.a
    public final void fdM() {
        AppMethodBeat.i(184007);
        this.Rqc = null;
        AbstractPopView abstractPopView = this.Rqz;
        if (abstractPopView != null) {
            this.windowManager.removeView(abstractPopView);
        }
        this.Rqz = null;
        AppMethodBeat.o(184007);
    }
}

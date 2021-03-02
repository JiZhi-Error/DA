package com.tencent.mm.msgsubscription.ui;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewTreeObserver;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000(\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0001H\u0002\u001a\u0014\u0010\u0005\u001a\u00020\u0001*\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0001H\u0002\u001a\f\u0010\u0007\u001a\u00020\b*\u00020\u0003H\u0002\u001a\u001a\u0010\t\u001a\u00020\n*\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\n0\rH\u0002\u001a\f\u0010\u000e\u001a\u00020\n*\u00020\u000bH\u0002¨\u0006\u000f"}, hxF = {"getAppropriateLargeScreenRequestDialogWidth", "", "context", "Landroid/content/Context;", "dialogMeasuredWidth", "dp2Px", "dp", "isLargeScreenEnv", "", "onPreDrawOnce", "", "Landroid/view/View;", "block", "Lkotlin/Function0;", "postRequestLayout", "wxbiz-msgsubscription-sdk_release"})
public final class c {
    static final int dj(Context context) {
        AppMethodBeat.i(174570);
        Resources resources = context.getResources();
        p.g(resources, "this.resources");
        int cR = kotlin.h.a.cR(resources.getDisplayMetrics().density * 375.0f);
        AppMethodBeat.o(174570);
        return cR;
    }

    static final boolean dk(Context context) {
        AppMethodBeat.i(174571);
        Resources resources = context.getResources();
        p.g(resources, "this.resources");
        if ((resources.getConfiguration().screenLayout & 15) >= 3) {
            AppMethodBeat.o(174571);
            return true;
        }
        AppMethodBeat.o(174571);
        return false;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, hxF = {"com/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialogKt$onPreDrawOnce$1", "Landroid/view/ViewTreeObserver$OnPreDrawListener;", "onPreDraw", "", "wxbiz-msgsubscription-sdk_release"})
    public static final class a implements ViewTreeObserver.OnPreDrawListener {
        final /* synthetic */ kotlin.g.a.a hvp;
        final /* synthetic */ View jCH;

        a(View view, kotlin.g.a.a aVar) {
            this.jCH = view;
            this.hvp = aVar;
        }

        public final boolean onPreDraw() {
            AppMethodBeat.i(174568);
            ViewTreeObserver viewTreeObserver = this.jCH.getViewTreeObserver();
            p.g(viewTreeObserver, "this@onPreDrawOnce.viewTreeObserver");
            if (viewTreeObserver.isAlive()) {
                this.jCH.getViewTreeObserver().removeOnPreDrawListener(this);
            }
            this.hvp.invoke();
            AppMethodBeat.o(174568);
            return false;
        }
    }

    static final void a(View view, kotlin.g.a.a<x> aVar) {
        AppMethodBeat.i(174572);
        ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
        p.g(viewTreeObserver, "this.viewTreeObserver");
        if (!viewTreeObserver.isAlive()) {
            AppMethodBeat.o(174572);
            return;
        }
        view.getViewTreeObserver().addOnPreDrawListener(new a(view, aVar));
        AppMethodBeat.o(174572);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class b implements Runnable {
        final /* synthetic */ View jCI;

        b(View view) {
            this.jCI = view;
        }

        public final void run() {
            AppMethodBeat.i(174569);
            this.jCI.requestLayout();
            AppMethodBeat.o(174569);
        }
    }
}

package com.tencent.mm.plugin.festival.finder;

import android.app.Activity;
import android.content.Context;
import android.graphics.PointF;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowInsets;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.of;
import com.tencent.mm.live.c.b;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.festival.finder.w;
import com.tencent.mm.plugin.festival.model.a.a;
import com.tencent.mm.plugin.finder.live.viewmodel.g;
import com.tencent.mm.plugin.finder.report.live.m;
import com.tencent.mm.plugin.finder.report.live.s;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0010\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u0017\u0010\u0018\u001a\u00020\u00192\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0012¢\u0006\u0002\u0010\u001bJ\u0019\u0010\u001c\u001a\u00020\u00192\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0012H\u0002¢\u0006\u0002\u0010\u001bJ\u0010\u0010\u001d\u001a\u00020\u00192\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\u001a\u0010 \u001a\u00020\u00192\u0006\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010$H\u0016R\u000e\u0010\n\u001a\u00020\u000bXD¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000¨\u0006%"}, hxF = {"Lcom/tencent/mm/plugin/festival/finder/FestivalFinderLiveScreenClearPlugin;", "Lcom/tencent/mm/plugin/festival/finder/FestivalFinderBaseLivePlugin;", "Lcom/tencent/mm/plugin/festival/finder/FestivalLiveCanvasClickInterceptorPlugin;", "root", "Landroid/view/ViewGroup;", "pluginLayout", "Lcom/tencent/mm/plugin/festival/finder/FestivalFinderLiveContract$Presenter;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/plugin/festival/finder/FestivalFinderLiveContract$Presenter;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "TAG", "", "clearView", "Landroid/view/View;", "clickTime", "", "downTime", "inCanvasHandDrawMode", "", "restoreScreenOnFairyWandDisappearStart", "screenClickLogicEnabled", "onInterceptCanvasClick", "pointF", "Landroid/graphics/PointF;", "screenAction", "", "clear", "(Ljava/lang/Boolean;)V", "screenClickLogic", "setVisible", "visible", "", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "plugin-festival_release"})
public final class ar extends p implements bn {
    private final String TAG = "MicroMsg.FestivalFinderLiveScreenClearPlugin";
    private boolean Uup;
    private boolean Uuq;
    private boolean Uur;
    private final w.a Uus;
    long hET;
    private final b hOp;
    private long nJh;
    private View utw;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ar(final ViewGroup viewGroup, w.a aVar, b bVar) {
        super(viewGroup, bVar);
        p.h(viewGroup, "root");
        p.h(aVar, "pluginLayout");
        p.h(bVar, "statusMonitor");
        AppMethodBeat.i(262534);
        this.Uus = aVar;
        this.hOp = bVar;
        this.utw = viewGroup;
        this.nJh = SystemClock.elapsedRealtime();
        this.hET = -1;
        this.utw.setOnTouchListener(new View.OnTouchListener(this) {
            /* class com.tencent.mm.plugin.festival.finder.ar.AnonymousClass1 */
            final /* synthetic */ ar Uut;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            {
                this.Uut = r1;
            }

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                AppMethodBeat.i(262526);
                Integer valueOf = motionEvent != null ? Integer.valueOf(motionEvent.getAction()) : null;
                if (valueOf != null && valueOf.intValue() == 0) {
                    this.Uut.hET = SystemClock.elapsedRealtime();
                } else if (valueOf != null && valueOf.intValue() == 1) {
                    if (this.Uut.hET > 0 && SystemClock.elapsedRealtime() - this.Uut.hET <= ((long) ViewConfiguration.getTapTimeout())) {
                        ar.a(this.Uut);
                    }
                    this.Uut.hET = -1;
                }
                AppMethodBeat.o(262526);
                return true;
            }
        });
        viewGroup.setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener() {
            /* class com.tencent.mm.plugin.festival.finder.ar.AnonymousClass2 */

            public final WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
                AppMethodBeat.i(262527);
                ViewGroup.LayoutParams layoutParams = viewGroup.getLayoutParams();
                if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
                    layoutParams = null;
                }
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                if (marginLayoutParams != null) {
                    p.g(windowInsets, "insets");
                    marginLayoutParams.bottomMargin = windowInsets.getSystemWindowInsetBottom();
                    viewGroup.requestLayout();
                }
                AppMethodBeat.o(262527);
                return windowInsets;
            }
        });
        this.Uup = true;
        AppMethodBeat.o(262534);
    }

    public final void n(Boolean bool) {
        boolean z;
        s.h hVar;
        AppMethodBeat.i(262530);
        g liveData = getLiveData();
        if (bool != null) {
            z = bool.booleanValue();
        } else {
            z = !getLiveData().uDR;
        }
        liveData.uDR = z;
        Log.i(this.TAG, "screenAction liveData.screenClear:" + getLiveData().uDR);
        Bundle bundle = new Bundle();
        bundle.putBoolean("PARAM_FINDER_LIVE_SCREEN_CLEAR", getLiveData().uDR);
        this.hOp.statusChange(b.c.hNl, bundle);
        if (this.hOp.getLiveRole() == 0) {
            if (getLiveData().uDR) {
                hVar = s.h.CLICK_CLEAR_SCREEN;
            } else {
                hVar = s.h.CLICK_CLEAR_SCREEN_CANCEL;
            }
            m.vli.a(hVar);
        }
        if (getLiveData().uDR && isLandscape() && Build.VERSION.SDK_INT >= 21) {
            Context context = this.hwr.getContext();
            if (context == null) {
                t tVar = new t("null cannot be cast to non-null type android.app.Activity");
                AppMethodBeat.o(262530);
                throw tVar;
            }
            Window window = ((Activity) context).getWindow();
            p.g(window, "(root.context as Activity).window");
            View decorView = window.getDecorView();
            p.g(decorView, "(root.context as Activity).window.decorView");
            decorView.setSystemUiVisibility(3846);
        }
        AppMethodBeat.o(262530);
    }

    @Override // com.tencent.mm.plugin.finder.live.plugin.d, com.tencent.mm.live.c.a
    public final void rg(int i2) {
        AppMethodBeat.i(262531);
        Log.i(this.TAG, "visibility:" + (i2 == 0));
        super.rg(i2);
        AppMethodBeat.o(262531);
    }

    @Override // com.tencent.mm.plugin.festival.finder.bn
    public final boolean d(PointF pointF) {
        AppMethodBeat.i(262532);
        p.h(pointF, "pointF");
        if (this.Uup) {
            if (!getLiveData().uDR) {
                a aVar = a.UzS;
                of PF = new of().PF(a.hRU());
                com.tencent.mm.plugin.festival.model.a.b bVar = com.tencent.mm.plugin.festival.model.a.b.UzX;
                PF.GK(com.tencent.mm.plugin.festival.model.a.b.hRV()).Tz(z.aTY()).SM(5).SR(1).bfK();
            }
            a(this);
            AppMethodBeat.o(262532);
            return true;
        }
        AppMethodBeat.o(262532);
        return false;
    }

    @Override // com.tencent.mm.live.c.a
    public final void statusChange(b.c cVar, Bundle bundle) {
        boolean z;
        boolean z2 = false;
        AppMethodBeat.i(262533);
        p.h(cVar, "status");
        switch (as.$EnumSwitchMapping$0[cVar.ordinal()]) {
            case 1:
            case 2:
                z = true;
                break;
            case 3:
            case 4:
            case 5:
                z = false;
                break;
            default:
                z = this.Uup;
                break;
        }
        this.Uup = z;
        switch (as.haE[cVar.ordinal()]) {
            case 1:
                if (!this.Uuq) {
                    this.Uuq = true;
                    if (!getLiveData().uDR) {
                        z2 = true;
                    }
                    this.Uur = z2;
                    this.Uus.Fh(true);
                    Log.i(this.TAG, "statusChange: FAIRY_WAND_TOUCH_START, restoreScreenOnFairyWandDisappearStart:" + this.Uur);
                    n(Boolean.TRUE);
                    AppMethodBeat.o(262533);
                    return;
                }
                break;
            case 2:
                this.Uuq = false;
                if (this.Uur) {
                    this.Uur = false;
                    b.C0376b.a(this.hOp, b.c.wsW);
                    break;
                }
                break;
        }
        AppMethodBeat.o(262533);
    }

    static /* synthetic */ void a(ar arVar) {
        AppMethodBeat.i(262529);
        Log.i(arVar.TAG, "screenClickLogic");
        if (SystemClock.elapsedRealtime() - arVar.nJh >= ((long) ViewConfiguration.getDoubleTapTimeout())) {
            arVar.nJh = SystemClock.elapsedRealtime();
            arVar.n(null);
        }
        AppMethodBeat.o(262529);
    }
}

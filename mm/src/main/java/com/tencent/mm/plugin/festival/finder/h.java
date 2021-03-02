package com.tencent.mm.plugin.festival.finder;

import android.content.Context;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Bundle;
import android.os.Looper;
import android.support.v4.view.u;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import com.facebook.internal.FacebookRequestErrorClassification;
import com.facebook.internal.NativeProtocol;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.live.c.b;
import com.tencent.mm.plugin.festival.PluginFestival;
import com.tencent.mm.plugin.festival.finder.bo;
import com.tencent.mm.plugin.festival.finder.k;
import com.tencent.mm.plugin.festival.model.ParcelableFestivalWish;
import com.tencent.mm.plugin.festival.model.ad;
import com.tencent.mm.plugin.festival.model.ag;
import com.tencent.mm.plugin.festival.model.o;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.a.v;
import kotlin.g.b.aa;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000£\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0003\u001d&)\u0018\u0000 @2\u00020\u00012\u00020\u00022\u00020\u0003:\u0003@ABB%\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\b\u0010+\u001a\u00020,H\u0016J\b\u0010-\u001a\u00020.H\u0016J \u0010/\u001a\b\u0012\u0004\u0012\u000201002\u0010\u00102\u001a\f\u0012\u0006\u0012\u0004\u0018\u000101\u0018\u000100H\u0002J\b\u00103\u001a\u000204H\u0016J\b\u00105\u001a\u00020.H\u0016J\u0010\u00106\u001a\u00020,2\u0006\u00107\u001a\u000208H\u0016J\b\u00109\u001a\u00020.H\u0016J\u001a\u0010:\u001a\u00020.2\u0006\u0010;\u001a\u00020<2\b\u0010=\u001a\u0004\u0018\u00010>H\u0016J\b\u0010?\u001a\u00020.H\u0016R\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\u00020\u0010XD¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0013\u001a\n \u0015*\u0004\u0018\u00010\u00140\u00148BX\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0018\u001a\u00020\u0019X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0010\u0010\u001c\u001a\u00020\u001dX\u0004¢\u0006\u0004\n\u0002\u0010\u001eR\u000e\u0010\u001f\u001a\u00020 X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020$X.¢\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u00020&X\u0004¢\u0006\u0004\n\u0002\u0010'R\u0010\u0010(\u001a\u00020)X\u0004¢\u0006\u0004\n\u0002\u0010*¨\u0006C"}, hxF = {"Lcom/tencent/mm/plugin/festival/finder/FestivalCanvasPopupContainerPlugin;", "Lcom/tencent/mm/plugin/festival/finder/FestivalLiveCanvasOverlayElementsPluginBase;", "Lcom/tencent/mm/plugin/festival/model/IForbiddenCallback;", "Lcom/tencent/mm/plugin/festival/finder/FestivalLiveCanvasClickInterceptorPlugin;", "root", "Lcom/tencent/mm/plugin/festival/finder/FestivalPopupContainerFrameLayout;", "canvas", "Lcom/tencent/mm/plugin/festival/finder/FestivalCanvasViewContract$Presenter;", "danmakuContainer", "Lcom/tencent/mm/plugin/festival/finder/FestivalDanmakuContainerContract;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Lcom/tencent/mm/plugin/festival/finder/FestivalPopupContainerFrameLayout;Lcom/tencent/mm/plugin/festival/finder/FestivalCanvasViewContract$Presenter;Lcom/tencent/mm/plugin/festival/finder/FestivalDanmakuContainerContract;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "H", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "TAG", "", "getTAG", "()Ljava/lang/String;", "context", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "getContext", "()Landroid/content/Context;", "elementsViewContact", "Lcom/tencent/mm/plugin/festival/finder/FestivalLiveCanvasOverlayElementsPluginBase$ElementsViewContract;", "getElementsViewContact", "()Lcom/tencent/mm/plugin/festival/finder/FestivalLiveCanvasOverlayElementsPluginBase$ElementsViewContract;", "layoutPool", "com/tencent/mm/plugin/festival/finder/FestivalCanvasPopupContainerPlugin$layoutPool$1", "Lcom/tencent/mm/plugin/festival/finder/FestivalCanvasPopupContainerPlugin$layoutPool$1;", "onLayoutChangeListener", "Landroid/view/View$OnLayoutChangeListener;", "safeInsets", "Landroid/graphics/Rect;", "viewBoundsIndicatorView", "Landroid/view/View;", "viewManager", "com/tencent/mm/plugin/festival/finder/FestivalCanvasPopupContainerPlugin$viewManager$1", "Lcom/tencent/mm/plugin/festival/finder/FestivalCanvasPopupContainerPlugin$viewManager$1;", "viewManagerRunQueue", "com/tencent/mm/plugin/festival/finder/FestivalCanvasPopupContainerPlugin$viewManagerRunQueue$1", "Lcom/tencent/mm/plugin/festival/finder/FestivalCanvasPopupContainerPlugin$viewManagerRunQueue$1;", "canClearScreen", "", "clearScreen", "", "filterStrangerWishList", "", "Lcom/tencent/mm/plugin/festival/proto/FestivalWish;", "_wishList", "getFlagBit", "", "mount", "onInterceptCanvasClick", "pointF", "Landroid/graphics/PointF;", "recoveryScreen", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "unMount", "Companion", "ContainerContractImplBase", "PopupViewManagerContract", "plugin-festival_release"})
public final class h extends bo implements bn, ag {
    @Deprecated
    public static final a UqO = new a((byte) 0);
    private final String TAG = "MicroMsg.FestivalCanvasPopupContainerPlugin";
    private final Rect UqF = new Rect();
    private final View.OnLayoutChangeListener UqG;
    private final e UqH;
    private View UqI;
    private final C1067h UqJ;
    private final g UqK;
    private final bo.a UqL;
    private final k.a UqM;
    private final l UqN;
    private final com.tencent.mm.live.c.b hOp;
    private final MMHandler mQp = new MMHandler(Looper.getMainLooper());

    static {
        AppMethodBeat.i(262133);
        AppMethodBeat.o(262133);
    }

    public static final /* synthetic */ View e(h hVar) {
        AppMethodBeat.i(262135);
        View view = hVar.UqI;
        if (view == null) {
            p.btv("viewBoundsIndicatorView");
        }
        AppMethodBeat.o(262135);
        return view;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public h(FestivalPopupContainerFrameLayout festivalPopupContainerFrameLayout, k.a aVar, l lVar, com.tencent.mm.live.c.b bVar) {
        super(festivalPopupContainerFrameLayout, bVar);
        p.h(festivalPopupContainerFrameLayout, "root");
        p.h(aVar, "canvas");
        p.h(lVar, "danmakuContainer");
        p.h(bVar, "statusMonitor");
        AppMethodBeat.i(262132);
        this.UqM = aVar;
        this.UqN = lVar;
        this.hOp = bVar;
        this.UqG = new f(this, festivalPopupContainerFrameLayout);
        this.UqH = new e();
        festivalPopupContainerFrameLayout.setTouchEnabled(false);
        this.UqJ = new C1067h(festivalPopupContainerFrameLayout);
        this.UqK = new g(this, festivalPopupContainerFrameLayout);
        this.UqL = new d(this);
        AppMethodBeat.o(262132);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/festival/finder/FestivalCanvasPopupContainerPlugin$Companion;", "", "()V", "ON_SCREEN_ITEM_MAX_COUNT", "", "plugin-festival_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @Override // com.tencent.mm.plugin.festival.finder.bo
    public final String getTAG() {
        return this.TAG;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u0006H\n¢\u0006\u0002\b\u000e"}, hxF = {"<anonymous>", "", "<anonymous parameter 0>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", "<anonymous parameter 2>", "<anonymous parameter 3>", "<anonymous parameter 4>", "<anonymous parameter 5>", "<anonymous parameter 6>", "<anonymous parameter 7>", "<anonymous parameter 8>", "onLayoutChange"})
    static final class f implements View.OnLayoutChangeListener {
        final /* synthetic */ h UqP;
        final /* synthetic */ FestivalPopupContainerFrameLayout Uri;

        f(h hVar, FestivalPopupContainerFrameLayout festivalPopupContainerFrameLayout) {
            this.UqP = hVar;
            this.Uri = festivalPopupContainerFrameLayout;
        }

        public final void onLayoutChange(View view, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
            AppMethodBeat.i(262092);
            Rect rect = this.UqP.UqF;
            rect.set(0, 0, this.Uri.getWidth(), this.Uri.getHeight());
            int i10 = rect.top;
            int i11 = this.UqP.UqN.dCY().bottom;
            Context c2 = h.c(this.UqP);
            p.g(c2, "context");
            rect.top = i10 + i11 + c2.getResources().getDimensionPixelSize(R.dimen.bt);
            int i12 = rect.left;
            Context c3 = h.c(this.UqP);
            p.g(c3, "context");
            rect.left = i12 + c3.getResources().getDimensionPixelSize(R.dimen.cc);
            int i13 = rect.right;
            Context c4 = h.c(this.UqP);
            p.g(c4, "context");
            rect.right = i13 - c4.getResources().getDimensionPixelSize(R.dimen.cc);
            rect.bottom = rect.top + this.Uri.getWidth();
            RectF vRectDefault = this.UqP.UqM.getVRectDefault();
            if (!vRectDefault.isEmpty()) {
                rect.bottom = Math.min(kotlin.h.a.cR(vRectDefault.bottom), rect.bottom);
                if (rect.bottom <= rect.top) {
                    rect.bottom = rect.top + this.Uri.getWidth();
                }
            }
            if (this.UqP.UqI != null) {
                ViewGroup.LayoutParams layoutParams = h.e(this.UqP).getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.width = this.UqP.UqF.width();
                    layoutParams.height = this.UqP.UqF.height();
                }
                h.e(this.UqP).setX((float) this.UqP.UqF.left);
                h.e(this.UqP).setY((float) this.UqP.UqF.top);
                h.e(this.UqP).requestLayout();
                h.e(this.UqP).invalidate();
            }
            AppMethodBeat.o(262092);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0006\u0010\u0005\u001a\u00020\u0006J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tH\u0016R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, hxF = {"com/tencent/mm/plugin/festival/finder/FestivalCanvasPopupContainerPlugin$layoutPool$1", "Lcom/tencent/mm/plugin/festival/finder/FestivalCanvasPopupLayoutPool;", "queue", "Ljava/util/LinkedList;", "Landroid/view/View;", "clear", "", "inflate", "view", "Lcom/tencent/mm/plugin/festival/ui/view/FestivalCanvasAvatarPopup;", "recycle", "plugin-festival_release"})
    public static final class e implements j {
        final LinkedList<View> Urh = new LinkedList<>();

        e() {
            AppMethodBeat.i(262091);
            AppMethodBeat.o(262091);
        }

        @Override // com.tencent.mm.plugin.festival.finder.j
        public final void a(com.tencent.mm.plugin.festival.ui.view.a aVar) {
            AppMethodBeat.i(262090);
            p.h(aVar, "view");
            View pollFirst = this.Urh.pollFirst();
            if (pollFirst == null) {
                LayoutInflater.from(aVar.getContext()).inflate(R.layout.cdg, aVar);
                AppMethodBeat.o(262090);
                return;
            }
            aVar.addView(pollFirst, new ViewGroup.LayoutParams(-2, -2));
            AppMethodBeat.o(262090);
        }
    }

    @Override // com.tencent.mm.plugin.festival.finder.bo, com.tencent.mm.live.c.a
    public final void statusChange(b.c cVar, Bundle bundle) {
        AppMethodBeat.i(262126);
        p.h(cVar, "status");
        switch (i.$EnumSwitchMapping$0[cVar.ordinal()]) {
            case 1:
                g gVar = this.UqK;
                if (gVar.a(c.d.STARTED)) {
                    gVar.notifyDataSetChanged();
                }
                AppMethodBeat.o(262126);
                return;
            default:
                super.statusChange(cVar, bundle);
                AppMethodBeat.o(262126);
                return;
        }
    }

    @Override // com.tencent.mm.plugin.festival.finder.p, com.tencent.mm.plugin.finder.live.plugin.d, com.tencent.mm.live.c.a
    public final void mount() {
        AppMethodBeat.i(262127);
        super.mount();
        this.hwr.addOnLayoutChangeListener(this.UqG);
        g gVar = this.UqK;
        if (gVar.a(c.d.MOUNTED)) {
            com.tencent.f.h.RTc.b(new g.b(gVar), "festival_heartbeat_write_cgi_resp_thread");
            o oVar = o.Uyw;
            o.aa(gVar.Urr);
        }
        bq bqVar = bq.UwH;
        AppMethodBeat.o(262127);
    }

    @Override // com.tencent.mm.plugin.festival.finder.p, com.tencent.mm.plugin.finder.live.plugin.d, com.tencent.mm.live.c.a
    public final void unMount() {
        AppMethodBeat.i(262128);
        super.unMount();
        this.mQp.removeCallbacksAndMessages(null);
        g gVar = this.UqK;
        gVar.a(c.d.UNMOUNTED);
        o oVar = o.Uyw;
        o.ab(gVar.Urr);
        C1067h hVar = gVar.UqP.UqJ;
        hVar.UrH = 0;
        hVar.UrF.clear();
        hVar.UrG.clear();
        gVar.Urs.clear();
        gVar.Urt.clear();
        synchronized (gVar.ppH) {
            try {
                gVar.ppH.clear();
                x xVar = x.SXb;
            } catch (Throwable th) {
                AppMethodBeat.o(262128);
                throw th;
            }
        }
        this.hwr.removeOnLayoutChangeListener(this.UqG);
        this.hwr.removeAllViews();
        this.UqH.Urh.clear();
        AppMethodBeat.o(262128);
    }

    @Override // com.tencent.mm.plugin.finder.live.plugin.d
    public final boolean dgK() {
        return true;
    }

    @Override // com.tencent.mm.plugin.finder.live.plugin.d
    public final void epk() {
        AppMethodBeat.i(262129);
        super.epk();
        this.UqK.pause();
        AppMethodBeat.o(262129);
    }

    @Override // com.tencent.mm.plugin.festival.finder.p, com.tencent.mm.plugin.finder.live.plugin.d
    public final void dCW() {
        AppMethodBeat.i(262130);
        super.dCW();
        if (gFa()) {
            this.UqK.resume();
        }
        AppMethodBeat.o(262130);
    }

    @Override // com.tencent.mm.plugin.festival.finder.bn
    public final boolean d(PointF pointF) {
        AppMethodBeat.i(262131);
        p.h(pointF, "pointF");
        if (!gFa() || this.hwr.getVisibility() != 0) {
            AppMethodBeat.o(262131);
            return false;
        } else if (Float.isNaN(pointF.x) || Float.isNaN(pointF.y)) {
            AppMethodBeat.o(262131);
            return false;
        } else {
            ViewGroup viewGroup = this.hwr;
            if (viewGroup == null) {
                t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.festival.finder.FestivalPopupContainerFrameLayout");
                AppMethodBeat.o(262131);
                throw tVar;
            }
            boolean e2 = ((FestivalPopupContainerFrameLayout) viewGroup).e(new PointF(pointF.x - ((FestivalPopupContainerFrameLayout) this.hwr).getX(), pointF.y - ((FestivalPopupContainerFrameLayout) this.hwr).getY()));
            AppMethodBeat.o(262131);
            return e2;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b¢\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/festival/finder/FestivalCanvasPopupContainerPlugin$ContainerContractImplBase;", "Lcom/tencent/mm/plugin/festival/finder/FestivalCanvasPopupContainerContract;", "(Lcom/tencent/mm/plugin/festival/finder/FestivalCanvasPopupContainerPlugin;)V", "addView", "", "child", "Landroid/view/View;", "plugin-festival_release"})
    abstract class b implements g {
        /* JADX WARN: Incorrect args count in method signature: ()V */
        public b() {
        }

        @Override // com.tencent.mm.plugin.festival.finder.g
        public final void addView(View view) {
            p.h(view, "child");
            h.this.hwr.addView(view, new ViewGroup.LayoutParams(-2, -2));
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000F\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\t*\u0002\u0000\b\b\n\u0018\u00002\u00020\u0001:\u0001\u001eJ\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0010\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\rH\u0016J\b\u0010\u0014\u001a\u00020\u000fH\u0016J\b\u0010\u0015\u001a\u00020\u0016H\u0002J\u0010\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0013\u001a\u00020\rH\u0016J\b\u0010\u0018\u001a\u00020\u000fH\u0016J\u0018\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\u001a\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\u0005H\u0016J\u0010\u0010\u001c\u001a\u00020\u00162\u0006\u0010\u0013\u001a\u00020\rH\u0016J\b\u0010\u001d\u001a\u00020\u000fH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\u0006\u001a\f\u0012\b\u0012\u00060\bR\u00020\u00000\u0007X\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\t\u001a\f\u0012\b\u0012\u00060\bR\u00020\u00000\nX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, hxF = {"com/tencent/mm/plugin/festival/finder/FestivalCanvasPopupContainerPlugin$viewManagerRunQueue$1", "Lcom/tencent/mm/plugin/festival/finder/FestivalCanvasPopupContainerPlugin$PopupViewManagerContract$RunQueueContact;", "TAG", "", "pausedUptimeMillis", "", "sortComparator", "Ljava/util/Comparator;", "com/tencent/mm/plugin/festival/finder/FestivalCanvasPopupContainerPlugin$viewManagerRunQueue$1.HandlerAction", "stagingActions", "Lcom/tencent/mm/plugin/festival/util/RemoveRangeArrayList;", "toExecuteActions", "Ljava/util/LinkedList;", "Ljava/lang/Runnable;", "assertDebug", "", "message", "", "callbackUntilTimePassed", "runnable", "clear", "computeScroll", "", "hasCallback", "pause", "postDelayed", NativeProtocol.WEB_DIALOG_ACTION, "delay", "removeCallback", "resume", "HandlerAction", "plugin-festival_release"})
    /* renamed from: com.tencent.mm.plugin.festival.finder.h$h  reason: collision with other inner class name */
    public static final class C1067h {
        private final String TAG = "MicroMsg.FestivalCanvasPopupContainerPlugin.viewManagerRunQueue";
        private final Comparator<a> UrE;
        final com.tencent.mm.plugin.festival.c.k<a> UrF;
        final LinkedList<Runnable> UrG;
        long UrH;
        final /* synthetic */ FestivalPopupContainerFrameLayout Uri;

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0000\n\u0002\u0010\b\n\u0000\n\u0000\n\u0002\b\u0005*\u0002\u0003\u0004\u0010\u0000\u001a\u00020\u00012\u0016\u0010\u0002\u001a\u0012 \u0005*\b\u0018\u00010\u0003R\u00020\u00040\u0003R\u00020\u00042\u0016\u0010\u0006\u001a\u0012 \u0005*\b\u0018\u00010\u0003R\u00020\u00040\u0003R\u00020\u0004H\n¢\u0006\u0004\b\u0007\u0010\b"}, hxF = {"<anonymous>", "", "o1", "com/tencent/mm/plugin/festival/finder/FestivalCanvasPopupContainerPlugin$viewManagerRunQueue$1.HandlerAction", "com/tencent/mm/plugin/festival/finder/FestivalCanvasPopupContainerPlugin$viewManagerRunQueue$1", "kotlin.jvm.PlatformType", "o2", "compare", "(Lcom/tencent/mm/plugin/festival/finder/FestivalCanvasPopupContainerPlugin$viewManagerRunQueue$1$HandlerAction;Lcom/tencent/mm/plugin/festival/finder/FestivalCanvasPopupContainerPlugin$viewManagerRunQueue$1$HandlerAction;)I"})
        /* renamed from: com.tencent.mm.plugin.festival.finder.h$h$b */
        static final class b<T> implements Comparator<a> {
            public static final b UrL = new b();

            static {
                AppMethodBeat.i(262119);
                AppMethodBeat.o(262119);
            }

            b() {
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
            @Override // java.util.Comparator
            public final /* bridge */ /* synthetic */ int compare(a aVar, a aVar2) {
                return (int) (aVar.UrJ - aVar2.UrJ);
            }
        }

        C1067h(FestivalPopupContainerFrameLayout festivalPopupContainerFrameLayout) {
            this.Uri = festivalPopupContainerFrameLayout;
            AppMethodBeat.i(262124);
            festivalPopupContainerFrameLayout.setOnComputeScrollCallback(new kotlin.g.a.a<Boolean>(this) {
                /* class com.tencent.mm.plugin.festival.finder.h.C1067h.AnonymousClass1 */

                @Override // kotlin.g.b.e
                public final kotlin.l.d Rs() {
                    AppMethodBeat.i(262117);
                    kotlin.l.b bp = aa.bp(C1067h.class);
                    AppMethodBeat.o(262117);
                    return bp;
                }

                @Override // kotlin.l.a, kotlin.g.b.e
                public final String getName() {
                    return "computeScroll";
                }

                @Override // kotlin.g.b.e
                public final String getSignature() {
                    return "computeScroll()Z";
                }

                /* Return type fixed from 'java.lang.Object' to match base method */
                @Override // kotlin.g.a.a
                public final /* synthetic */ Boolean invoke() {
                    AppMethodBeat.i(262116);
                    Boolean valueOf = Boolean.valueOf(C1067h.a((C1067h) this.SYl));
                    AppMethodBeat.o(262116);
                    return valueOf;
                }
            });
            this.UrE = b.UrL;
            this.UrF = new com.tencent.mm.plugin.festival.c.k<>();
            this.UrG = new LinkedList<>();
            AppMethodBeat.o(262124);
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000!\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0006*\u0001\u0000\b\u0004\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u0012\u001a\u00020\u0003H\u0002J\t\u0010\u0013\u001a\u00020\u0005H\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0014"}, hxF = {"com/tencent/mm/plugin/festival/finder/FestivalCanvasPopupContainerPlugin$viewManagerRunQueue$1.HandlerAction", "", NativeProtocol.WEB_DIALOG_ACTION, "Ljava/lang/Runnable;", "atUptimeMillis", "", "(Lcom/tencent/mm/plugin/festival/finder/FestivalCanvasPopupContainerPlugin$viewManagerRunQueue$1;Ljava/lang/Runnable;J)V", "getAction", "()Ljava/lang/Runnable;", "getAtUptimeMillis", "()J", "setAtUptimeMillis", "(J)V", "isExecuted", "", "()Z", "setExecuted", "(Z)V", "component1", "component2", "plugin-festival_release"})
        /* renamed from: com.tencent.mm.plugin.festival.finder.h$h$a */
        public final class a {
            boolean UrI;
            long UrJ;
            final /* synthetic */ C1067h UrK;
            final Runnable aBI;

            public a(C1067h hVar, Runnable runnable, long j2) {
                p.h(runnable, NativeProtocol.WEB_DIALOG_ACTION);
                this.UrK = hVar;
                AppMethodBeat.i(262118);
                this.aBI = runnable;
                this.UrJ = j2;
                AppMethodBeat.o(262118);
            }
        }

        private static void gR(Object obj) {
            AppMethodBeat.i(262120);
            if (BuildInfo.DEBUG) {
                IllegalStateException illegalStateException = new IllegalStateException(obj.toString());
                AppMethodBeat.o(262120);
                throw illegalStateException;
            }
            AppMethodBeat.o(262120);
        }

        public final void c(Runnable runnable, long j2) {
            AppMethodBeat.i(262121);
            p.h(runnable, NativeProtocol.WEB_DIALOG_ACTION);
            this.UrF.add(new a(this, runnable, AnimationUtils.currentAnimationTimeMillis() + Math.max(j2, 0L)));
            u.X(this.Uri);
            AppMethodBeat.o(262121);
        }

        /* JADX WARNING: Removed duplicated region for block: B:16:0x0060  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void resume() {
            /*
            // Method dump skipped, instructions count: 109
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.festival.finder.h.C1067h.resume():void");
        }

        public final void pause() {
            AppMethodBeat.i(262123);
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            C1067h hVar = this;
            Log.d(hVar.TAG, "pause, pausedUptimeMillis:" + hVar.UrH);
            if (hVar.UrH <= 0) {
                hVar.UrH = currentAnimationTimeMillis;
            }
            AppMethodBeat.o(262123);
        }

        public static final /* synthetic */ boolean a(C1067h hVar) {
            AppMethodBeat.i(262125);
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            C1067h hVar2 = hVar;
            if (hVar2.UrH > 0) {
                AppMethodBeat.o(262125);
                return false;
            } else if (hVar2.UrF.isEmpty()) {
                AppMethodBeat.o(262125);
                return false;
            } else {
                Collections.sort(hVar2.UrF, hVar2.UrE);
                int size = hVar2.UrF.size();
                int i2 = 0;
                for (int i3 = 0; i3 < size; i3++) {
                    a aVar = (a) hVar2.UrF.get(i3);
                    Runnable runnable = aVar.aBI;
                    if (aVar.UrJ > currentAnimationTimeMillis) {
                        break;
                    }
                    if (((a) hVar2.UrF.get(i3)).UrI) {
                        gR("Executed action in queue!");
                    }
                    if (!((a) hVar2.UrF.get(i3)).UrI) {
                        hVar2.UrG.addLast(runnable);
                        ((a) hVar2.UrF.get(i3)).UrI = true;
                    }
                    i2++;
                }
                if (i2 > 0) {
                    int size2 = hVar2.UrF.size();
                    hVar2.UrF.removeRange(0, i2);
                    if ((hVar2.UrF.size() + i2) - 1 > size2) {
                        gR("fuck removeRange");
                    }
                }
                boolean z = !hVar2.UrF.isEmpty();
                while (true) {
                    if (!hVar.UrG.isEmpty()) {
                        Runnable pollFirst = hVar.UrG.pollFirst();
                        if (pollFirst == null) {
                            p.hyc();
                        }
                        pollFirst.run();
                    } else {
                        AppMethodBeat.o(262125);
                        return z;
                    }
                }
            }
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\bb\u0018\u00002\u00020\u0001:\u0005\u000f\u0010\u0011\u0012\u0013J\b\u0010\u0005\u001a\u00020\u0006H&J\b\u0010\u0007\u001a\u00020\u0006H&J\u0018\u0010\b\u001a\u00020\u00062\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nH&J\b\u0010\f\u001a\u00020\u0006H&J\b\u0010\r\u001a\u00020\u0006H&J\b\u0010\u000e\u001a\u00020\u0006H&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0004¨\u0006\u0014"}, hxF = {"Lcom/tencent/mm/plugin/festival/finder/FestivalCanvasPopupContainerPlugin$PopupViewManagerContract;", "", "isStarted", "", "()Z", "mount", "", "pause", "replace", "wishList", "", "Lcom/tencent/mm/plugin/festival/proto/FestivalWish;", "resume", "start", "unMount", "ITEM_SIZE_LEVEL", "OnScreenViewModel", "OnScreenViewModelQueue", "RunQueueContact", "STATE", "plugin-festival_release"})
    interface c {

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, hxF = {"Lcom/tencent/mm/plugin/festival/finder/FestivalCanvasPopupContainerPlugin$PopupViewManagerContract$STATE;", "", "(Ljava/lang/String;I)V", "INITIALIZED", "MOUNTED", "STARTED", "RESUMED", "PAUSED", "UNMOUNTED", "plugin-festival_release"})
        public enum d {
            INITIALIZED,
            MOUNTED,
            STARTED,
            RESUMED,
            PAUSED,
            UNMOUNTED;

            static {
                AppMethodBeat.i(262084);
                AppMethodBeat.o(262084);
            }

            public static d valueOf(String str) {
                AppMethodBeat.i(262086);
                d dVar = (d) Enum.valueOf(d.class, str);
                AppMethodBeat.o(262086);
                return dVar;
            }
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, hxF = {"Lcom/tencent/mm/plugin/festival/finder/FestivalCanvasPopupContainerPlugin$PopupViewManagerContract$ITEM_SIZE_LEVEL;", "", "dimenId", "", "(Ljava/lang/String;II)V", "getDimenId", "()I", "SMALL", "LARGE", "plugin-festival_release"})
        public enum a {
            SMALL(R.dimen.cj),
            LARGE(R.dimen.cm);
            
            final int UqT;

            public static a valueOf(String str) {
                AppMethodBeat.i(262075);
                a aVar = (a) Enum.valueOf(a.class, str);
                AppMethodBeat.o(262075);
                return aVar;
            }

            private a(int i2) {
                this.UqT = i2;
            }

            static {
                AppMethodBeat.i(262073);
                AppMethodBeat.o(262073);
            }
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, hxF = {"Lcom/tencent/mm/plugin/festival/finder/FestivalCanvasPopupContainerPlugin$PopupViewManagerContract$OnScreenViewModel;", "", "sizeLevel", "Lcom/tencent/mm/plugin/festival/finder/FestivalCanvasPopupContainerPlugin$PopupViewManagerContract$ITEM_SIZE_LEVEL;", "wish", "Lcom/tencent/mm/plugin/festival/proto/FestivalWish;", "(Lcom/tencent/mm/plugin/festival/finder/FestivalCanvasPopupContainerPlugin$PopupViewManagerContract$ITEM_SIZE_LEVEL;Lcom/tencent/mm/plugin/festival/proto/FestivalWish;)V", "getSizeLevel", "()Lcom/tencent/mm/plugin/festival/finder/FestivalCanvasPopupContainerPlugin$PopupViewManagerContract$ITEM_SIZE_LEVEL;", "getWish", "()Lcom/tencent/mm/plugin/festival/proto/FestivalWish;", "component1", "component2", "copy", "equals", "", FacebookRequestErrorClassification.KEY_OTHER, "hashCode", "", "toString", "", "plugin-festival_release"})
        public static final class b {
            final a UqU;
            final com.tencent.mm.plugin.festival.b.c UqV;

            /* JADX WARNING: Code restructure failed: missing block: B:7:0x0020, code lost:
                if (kotlin.g.b.p.j(r3.UqV, r4.UqV) != false) goto L_0x0022;
             */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final boolean equals(java.lang.Object r4) {
                /*
                    r3 = this;
                    r2 = 262079(0x3ffbf, float:3.67251E-40)
                    com.tencent.matrix.trace.core.AppMethodBeat.i(r2)
                    if (r3 == r4) goto L_0x0022
                    boolean r0 = r4 instanceof com.tencent.mm.plugin.festival.finder.h.c.b
                    if (r0 == 0) goto L_0x0027
                    com.tencent.mm.plugin.festival.finder.h$c$b r4 = (com.tencent.mm.plugin.festival.finder.h.c.b) r4
                    com.tencent.mm.plugin.festival.finder.h$c$a r0 = r3.UqU
                    com.tencent.mm.plugin.festival.finder.h$c$a r1 = r4.UqU
                    boolean r0 = kotlin.g.b.p.j(r0, r1)
                    if (r0 == 0) goto L_0x0027
                    com.tencent.mm.plugin.festival.b.c r0 = r3.UqV
                    com.tencent.mm.plugin.festival.b.c r1 = r4.UqV
                    boolean r0 = kotlin.g.b.p.j(r0, r1)
                    if (r0 == 0) goto L_0x0027
                L_0x0022:
                    r0 = 1
                    com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
                L_0x0026:
                    return r0
                L_0x0027:
                    r0 = 0
                    com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
                    goto L_0x0026
                */
                throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.festival.finder.h.c.b.equals(java.lang.Object):boolean");
            }

            public final int hashCode() {
                int i2 = 0;
                AppMethodBeat.i(262078);
                a aVar = this.UqU;
                int hashCode = (aVar != null ? aVar.hashCode() : 0) * 31;
                com.tencent.mm.plugin.festival.b.c cVar = this.UqV;
                if (cVar != null) {
                    i2 = cVar.hashCode();
                }
                int i3 = hashCode + i2;
                AppMethodBeat.o(262078);
                return i3;
            }

            public final String toString() {
                AppMethodBeat.i(262077);
                String str = "OnScreenViewModel(sizeLevel=" + this.UqU + ", wish=" + this.UqV + ")";
                AppMethodBeat.o(262077);
                return str;
            }

            public b(a aVar, com.tencent.mm.plugin.festival.b.c cVar) {
                p.h(aVar, "sizeLevel");
                p.h(cVar, "wish");
                AppMethodBeat.i(262076);
                this.UqU = aVar;
                this.UqV = cVar;
                AppMethodBeat.o(262076);
            }
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0015\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010(\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J4\u0010\u0014\u001a\u00020\u00152)\u0010\u0016\u001a%\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0012\u0004\u0012\u00020\u00150\u0017H\bJ\u0013\u0010\u001b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u001a\u001a\u00020\u0003H\u0002J\u0011\u0010\u001c\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u001dH\u0002J\u0006\u0010\u001e\u001a\u00020\u0015J\u001b\u0010\u001f\u001a\u00020\u00152\u0006\u0010\u001a\u001a\u00020\u00032\b\u0010 \u001a\u0004\u0018\u00010\u0007H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006X\u0004¢\u0006\u0004\n\u0002\u0010\bR\u0011\u0010\t\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0010\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u000bR\u0011\u0010\u0012\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u000b¨\u0006!"}, hxF = {"Lcom/tencent/mm/plugin/festival/finder/FestivalCanvasPopupContainerPlugin$PopupViewManagerContract$OnScreenViewModelQueue;", "", "expectedMaxSize", "", "(I)V", "itemArray", "", "Lcom/tencent/mm/plugin/festival/finder/FestivalCanvasPopupContainerPlugin$PopupViewManagerContract$OnScreenViewModel;", "[Lcom/tencent/mm/plugin/festival/finder/FestivalCanvasPopupContainerPlugin$PopupViewManagerContract$OnScreenViewModel;", "largeSizeCount", "getLargeSizeCount", "()I", "size", "getSize", "sizeCountArray", "", "smallSizeCount", "getSmallSizeCount", "validOnScreenItemCount", "getValidOnScreenItemCount", "forEachIndexed", "", NativeProtocol.WEB_DIALOG_ACTION, "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", FirebaseAnalytics.b.INDEX, "get", "iterator", "", "reverse", "set", "newValue", "plugin-festival_release"})
        /* renamed from: com.tencent.mm.plugin.festival.finder.h$c$c  reason: collision with other inner class name */
        public static final class C1064c {
            final b[] UqW = new b[this.UqY];
            final int[] UqX;
            final int UqY = 4;
            final int size;

            public C1064c() {
                AppMethodBeat.i(262083);
                int length = a.values().length;
                int[] iArr = new int[length];
                for (int i2 = 0; i2 < length; i2++) {
                    iArr[i2] = 0;
                }
                this.UqX = iArr;
                this.size = this.UqY;
                AppMethodBeat.o(262083);
            }

            public final void a(int i2, b bVar) {
                AppMethodBeat.i(262081);
                b bVar2 = this.UqW[i2];
                if (bVar2 != null) {
                    this.UqX[bVar2.UqU.ordinal()] = Math.max(0, this.UqX[bVar2.UqU.ordinal()] - 1);
                }
                this.UqW[i2] = bVar;
                if (bVar != null) {
                    this.UqX[bVar.UqU.ordinal()] = Math.max(0, this.UqX[bVar.UqU.ordinal()]) + 1;
                }
                AppMethodBeat.o(262081);
            }

            @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001d\n\u0000\n\u0002\u0010(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J\t\u0010\u0005\u001a\u00020\u0006H\u0002J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0002H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\b"}, hxF = {"com/tencent/mm/plugin/festival/finder/FestivalCanvasPopupContainerPlugin$PopupViewManagerContract$OnScreenViewModelQueue$iterator$1", "", "Lcom/tencent/mm/plugin/festival/finder/FestivalCanvasPopupContainerPlugin$PopupViewManagerContract$OnScreenViewModel;", FirebaseAnalytics.b.INDEX, "", "hasNext", "", "next", "plugin-festival_release"})
            /* renamed from: com.tencent.mm.plugin.festival.finder.h$c$c$a */
            public static final class a implements Iterator<b>, kotlin.g.b.a.a {
                final /* synthetic */ C1064c UqZ;
                private int index;

                public final void remove() {
                    AppMethodBeat.i(262080);
                    UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
                    AppMethodBeat.o(262080);
                    throw unsupportedOperationException;
                }

                /* JADX WARN: Incorrect args count in method signature: ()V */
                a(C1064c cVar) {
                    this.UqZ = cVar;
                }

                public final boolean hasNext() {
                    return this.index < this.UqZ.UqY;
                }

                /* Return type fixed from 'java.lang.Object' to match base method */
                @Override // java.util.Iterator
                public final /* bridge */ /* synthetic */ b next() {
                    b[] bVarArr = this.UqZ.UqW;
                    int i2 = this.index;
                    this.index = i2 + 1;
                    return bVarArr[i2];
                }
            }

            public final Iterator<b> iterator() {
                AppMethodBeat.i(262082);
                a aVar = new a(this);
                AppMethodBeat.o(262082);
                return aVar;
            }
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010&\u001a\u00020\u0014H\u0003J\b\u0010'\u001a\u00020\u001aH\u0016J\b\u0010(\u001a\u00020\u001aH\u0002J\u0018\u0010)\u001a\u00020\u001a2\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020-H\u0003J\b\u0010.\u001a\u00020\u001aH\u0016J\u0018\u0010/\u001a\u00020\u001a2\u0006\u0010,\u001a\u00020-2\u0006\u00100\u001a\u00020\fH\u0003J\u0018\u00101\u001a\u00020\u001a2\u000e\u00102\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u0019H\u0016J\b\u00103\u001a\u00020\u001aH\u0016J\b\u00104\u001a\u00020\u001aH\u0002J\b\u00105\u001a\u00020\u001aH\u0016J\u0010\u00106\u001a\u00020\u00142\u0006\u00107\u001a\u00020#H\u0002J\b\u00108\u001a\u00020\u001aH\u0016J\u0018\u00109\u001a\u00020\u0014*\u0004\u0018\u00010\t2\b\u0010:\u001a\u0004\u0018\u00010\tH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0003XD¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tXD¢\u0006\u0002\n\u0000R\u0018\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000bX\u0004¢\u0006\u0004\n\u0002\u0010\rR\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\u00020\u00148VX\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R \u0010\u0017\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u0019\u0012\u0004\u0012\u00020\u001a0\u0018X\u0004¢\u0006\u0002\n\u0000R*\u0010\u001b\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0\u001d0\u001cj\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0\u001d`\u001eX\u0004¢\u0006\u0002\n\u0000R*\u0010\u001f\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0\u001d0\u001cj\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0\u001d`\u001eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u00020\u0000X\u0004¢\u0006\u0004\n\u0002\u0010%¨\u0006;"}, hxF = {"com/tencent/mm/plugin/festival/finder/FestivalCanvasPopupContainerPlugin$viewManager$1", "Lcom/tencent/mm/plugin/festival/finder/FestivalCanvasPopupContainerPlugin$PopupViewManagerContract;", "DEQUEUE_INTERVAL", "", "FLASH_STAR_DURATION", "LARGE_ITEM_MAX_COUNT", "", "ON_SCREEN_DURATION", "TAG", "", "containerContracts", "", "Lcom/tencent/mm/plugin/festival/finder/FestivalCanvasPopupContainerContract;", "[Lcom/tencent/mm/plugin/festival/finder/FestivalCanvasPopupContainerContract;", "dataList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/festival/proto/FestivalWish;", "dequeueRunnable", "Ljava/lang/Runnable;", "isCyclePlay", "", "isStarted", "()Z", "onHeartbeatNotify", "Lkotlin/Function1;", "", "", "onPauseListeners", "Ljava/util/HashSet;", "Lkotlin/Function0;", "Lkotlin/collections/HashSet;", "onResumeListeners", "onScreenItems", "Lcom/tencent/mm/plugin/festival/finder/FestivalCanvasPopupContainerPlugin$PopupViewManagerContract$OnScreenViewModelQueue;", "state", "Lcom/tencent/mm/plugin/festival/finder/FestivalCanvasPopupContainerPlugin$PopupViewManagerContract$STATE;", "viewManager", "Lcom/tencent/mm/plugin/festival/finder/FestivalCanvasPopupContainerPlugin$viewManager$1;", "dequeue", "mount", "notifyDataSetChanged", "notifyViewRemoved", "popupView", "Lcom/tencent/mm/plugin/festival/ui/view/FestivalCanvasAvatarPopup;", "model", "Lcom/tencent/mm/plugin/festival/finder/FestivalCanvasPopupContainerPlugin$PopupViewManagerContract$OnScreenViewModel;", "pause", "performShow", "contract", "replace", "wishList", "resume", "scheduleNextDequeue", "start", "toState", "newState", "unMount", "equalsNotEmpty", "that", "plugin-festival_release"})
    public static final class g implements c {
        private final String TAG = "MicroMsg.FestivalCanvasPopupContainerPlugin.viewManager";
        final g UqK = this;
        final /* synthetic */ h UqP;
        final /* synthetic */ FestivalPopupContainerFrameLayout Uri;
        final long Urj = 5500;
        private final long Urk = 1500;
        private final long Urm = 2000;
        private final int Urn = 1;
        c.d Uro = c.d.INITIALIZED;
        final c.C1064c Urp;
        final g[] Urq;
        final kotlin.g.a.b<List<? extends com.tencent.mm.plugin.festival.b.c>, x> Urr;
        final HashSet<kotlin.g.a.a<x>> Urs;
        final HashSet<kotlin.g.a.a<x>> Urt;
        final Runnable Uru;
        boolean Urv;
        final LinkedList<com.tencent.mm.plugin.festival.b.c> ppH;

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", "_wishList", "", "Lcom/tencent/mm/plugin/festival/proto/FestivalWish;", "invoke"})
        static final class d extends q implements kotlin.g.a.b<List<? extends com.tencent.mm.plugin.festival.b.c>, x> {
            final /* synthetic */ g Urx;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            d(g gVar) {
                super(1);
                this.Urx = gVar;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.g.a.b
            public final /* synthetic */ x invoke(List<? extends com.tencent.mm.plugin.festival.b.c> list) {
                AppMethodBeat.i(262102);
                List<? extends com.tencent.mm.plugin.festival.b.c> list2 = list;
                p.h(list2, "_wishList");
                List kR = h.kR(list2);
                List list3 = kR;
                if (!(list3 == null || list3.isEmpty())) {
                    g gVar = this.Urx;
                    List list4 = kR;
                    if (!(list4 == null || list4.isEmpty())) {
                        synchronized (gVar.ppH) {
                            try {
                                gVar.ppH.clear();
                                gVar.ppH.addAll(kR);
                            } catch (Throwable th) {
                                AppMethodBeat.o(262102);
                                throw th;
                            }
                        }
                        gVar.notifyDataSetChanged();
                    }
                }
                x xVar = x.SXb;
                AppMethodBeat.o(262102);
                return xVar;
            }
        }

        g(h hVar, FestivalPopupContainerFrameLayout festivalPopupContainerFrameLayout) {
            this.UqP = hVar;
            this.Uri = festivalPopupContainerFrameLayout;
            AppMethodBeat.i(262115);
            a unused = h.UqO;
            this.Urp = new c.C1064c();
            a unused2 = h.UqO;
            this.Urq = new g[4];
            this.ppH = new LinkedList<>();
            this.Urr = new d(this);
            this.Urs = new HashSet<>();
            this.Urt = new HashSet<>();
            this.Uru = new a(this);
            this.Urv = true;
            int length = this.Urq.length;
            for (final int i2 = 0; i2 < length; i2++) {
                this.Urq[i2] = new b(this) {
                    /* class com.tencent.mm.plugin.festival.finder.h.g.AnonymousClass1 */
                    private final Rect Urw = new Rect();
                    final /* synthetic */ g Urx;

                    {
                        this.Urx = r3;
                        AppMethodBeat.i(262098);
                        AppMethodBeat.o(262098);
                    }

                    @Override // com.tencent.mm.plugin.festival.finder.g
                    public final Rect eWS() {
                        AppMethodBeat.i(262093);
                        Rect rect = this.Urw;
                        this.Urw.set(this.Urx.UqP.UqF);
                        int cR = kotlin.h.a.cR(((float) this.Urw.width()) / ((float) this.Urx.Urq.length));
                        this.Urw.left += i2 * cR;
                        this.Urw.right = cR + this.Urw.left;
                        AppMethodBeat.o(262093);
                        return rect;
                    }

                    @Override // com.tencent.mm.plugin.festival.finder.g
                    public final void as(kotlin.g.a.a<x> aVar) {
                        AppMethodBeat.i(262094);
                        p.h(aVar, "onResume");
                        this.Urx.Urs.add(aVar);
                        AppMethodBeat.o(262094);
                    }

                    @Override // com.tencent.mm.plugin.festival.finder.g
                    public final void at(kotlin.g.a.a<x> aVar) {
                        AppMethodBeat.i(262095);
                        p.h(aVar, "onResume");
                        this.Urx.Urs.remove(aVar);
                        AppMethodBeat.o(262095);
                    }

                    @Override // com.tencent.mm.plugin.festival.finder.g
                    public final void au(kotlin.g.a.a<x> aVar) {
                        AppMethodBeat.i(262096);
                        p.h(aVar, "onPause");
                        this.Urx.Urt.add(aVar);
                        AppMethodBeat.o(262096);
                    }

                    @Override // com.tencent.mm.plugin.festival.finder.g
                    public final void av(kotlin.g.a.a<x> aVar) {
                        AppMethodBeat.i(262097);
                        p.h(aVar, "onPause");
                        this.Urx.Urt.remove(aVar);
                        AppMethodBeat.o(262097);
                    }
                };
            }
            AppMethodBeat.o(262115);
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
        static final class a implements Runnable {
            final /* synthetic */ g Urx;

            a(g gVar) {
                this.Urx = gVar;
            }

            public final void run() {
                AppMethodBeat.i(262099);
                if (this.Urx.fuU()) {
                    this.Urx.fuT();
                }
                AppMethodBeat.o(262099);
            }
        }

        /* access modifiers changed from: package-private */
        public final void fuT() {
            long j2;
            AppMethodBeat.i(262108);
            kotlin.a.e.am(this.Urp.UqW);
            kotlin.a.e.am(this.Urq);
            int i2 = 0;
            Iterator<c.b> it = this.Urp.iterator();
            while (it.hasNext()) {
                if (it.next() != null) {
                    i2++;
                } else {
                    i2 = i2;
                }
            }
            if (i2 <= 0) {
                this.UqP.UqJ.c(this.Uru, 0);
                AppMethodBeat.o(262108);
                return;
            }
            C1067h hVar = this.UqP.UqJ;
            Runnable runnable = this.Uru;
            p.h(runnable, "runnable");
            Iterator<C1067h.a> it2 = hVar.UrF.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    j2 = -1;
                    break;
                }
                C1067h.a next = it2.next();
                if (p.j(next.aBI, runnable)) {
                    j2 = next.UrJ - AnimationUtils.currentAnimationTimeMillis();
                    break;
                }
            }
            if (j2 < 1500) {
                C1067h hVar2 = this.UqP.UqJ;
                Runnable runnable2 = this.Uru;
                p.h(runnable2, "runnable");
                Iterator<E> it3 = hVar2.UrF.iterator();
                p.g(it3, "stagingActions.iterator()");
                while (it3.hasNext()) {
                    if (p.j(it3.next().aBI, runnable2)) {
                        it3.remove();
                    }
                }
            }
            this.UqP.UqJ.c(this.Uru, kotlin.j.d.Pf(Util.nowMilliSecond()).nextLong(1500, 2500));
            AppMethodBeat.o(262108);
        }

        /* access modifiers changed from: package-private */
        public final boolean a(c.d dVar) {
            boolean z = false;
            AppMethodBeat.i(262109);
            if (dVar == c.d.RESUMED) {
                if (this.Uro == c.d.STARTED || this.Uro == c.d.PAUSED) {
                    z = true;
                }
            } else if (dVar.ordinal() > this.Uro.ordinal()) {
                z = true;
            }
            c.d dVar2 = this.Uro;
            if (z) {
                this.Uro = dVar;
            }
            Log.i(this.TAG, "toState(" + dVar + "), " + dVar2 + " -> " + this.Uro);
            AppMethodBeat.o(262109);
            return z;
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
        static final class b implements Runnable {
            final /* synthetic */ g Urx;

            b(g gVar) {
                this.Urx = gVar;
            }

            public final void run() {
                AppMethodBeat.i(262100);
                kotlin.g.a.b<List<? extends com.tencent.mm.plugin.festival.b.c>, x> bVar = this.Urx.Urr;
                o oVar = o.Uyw;
                bVar.invoke(o.hcg());
                AppMethodBeat.o(262100);
            }
        }

        public final void resume() {
            AppMethodBeat.i(262110);
            if (a(c.d.RESUMED)) {
                Iterator<T> it = this.Urs.iterator();
                while (it.hasNext()) {
                    it.next().invoke();
                }
                this.UqP.UqJ.resume();
            }
            AppMethodBeat.o(262110);
        }

        public final void pause() {
            AppMethodBeat.i(262111);
            if (a(c.d.PAUSED)) {
                this.UqP.UqJ.pause();
                Iterator<T> it = this.Urt.iterator();
                while (it.hasNext()) {
                    it.next().invoke();
                }
            }
            AppMethodBeat.o(262111);
        }

        /* access modifiers changed from: package-private */
        public final void notifyDataSetChanged() {
            AppMethodBeat.i(262112);
            if (c.d.STARTED == this.Uro || c.d.RESUMED == this.Uro) {
                c cVar = new c(this);
                if (p.j(Looper.myLooper(), Looper.getMainLooper())) {
                    cVar.run();
                    AppMethodBeat.o(262112);
                    return;
                }
                this.Uri.post(cVar);
            }
            AppMethodBeat.o(262112);
        }

        /* access modifiers changed from: package-private */
        @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
        public static final class c implements Runnable {
            final /* synthetic */ g Urx;

            c(g gVar) {
                this.Urx = gVar;
            }

            public final void run() {
                boolean z;
                AppMethodBeat.i(262101);
                if (c.d.STARTED == this.Urx.Uro || c.d.RESUMED == this.Urx.Uro) {
                    C1067h hVar = this.Urx.UqP.UqJ;
                    Runnable runnable = this.Urx.Uru;
                    p.h(runnable, "runnable");
                    Iterator<C1067h.a> it = hVar.UrF.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            if (p.j(it.next().aBI, runnable)) {
                                z = true;
                                break;
                            }
                        } else {
                            z = false;
                            break;
                        }
                    }
                    if (!z) {
                        this.Urx.UqP.UqJ.c(this.Urx.Uru, 0);
                    }
                }
                AppMethodBeat.o(262101);
            }
        }

        static boolean cA(String str, String str2) {
            AppMethodBeat.i(262113);
            String str3 = str;
            if ((str3 == null || str3.length() == 0) || !p.j(str, str2)) {
                AppMethodBeat.o(262113);
                return false;
            }
            AppMethodBeat.o(262113);
            return true;
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Removed duplicated region for block: B:20:0x0068  */
        /* JADX WARNING: Removed duplicated region for block: B:23:0x00ef  */
        /* JADX WARNING: Removed duplicated region for block: B:27:0x00fd  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean fuU() {
            /*
            // Method dump skipped, instructions count: 281
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.festival.finder.h.g.fuU():boolean");
        }

        /* access modifiers changed from: package-private */
        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/festival/finder/FestivalCanvasPopupContainerPlugin$viewManager$1$performShow$1$4"})
        /* renamed from: com.tencent.mm.plugin.festival.finder.h$g$h  reason: collision with other inner class name */
        public static final class View$OnClickListenerC1066h implements View.OnClickListener {
            final /* synthetic */ g UrA;
            final /* synthetic */ int UrB;
            final /* synthetic */ int UrC;
            final /* synthetic */ g Urx;
            final /* synthetic */ com.tencent.mm.plugin.festival.ui.view.a Ury;
            final /* synthetic */ c.b Urz;

            View$OnClickListenerC1066h(com.tencent.mm.plugin.festival.ui.view.a aVar, g gVar, c.b bVar, g gVar2, int i2, int i3) {
                this.Ury = aVar;
                this.Urx = gVar;
                this.Urz = bVar;
                this.UrA = gVar2;
                this.UrB = i2;
                this.UrC = i3;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(262107);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/festival/finder/FestivalCanvasPopupContainerPlugin$viewManager$1$performShow$$inlined$apply$lambda$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                FestivalPopupContainerFrameLayout festivalPopupContainerFrameLayout = this.Urx.Uri;
                if (!(festivalPopupContainerFrameLayout instanceof FestivalPopupContainerFrameLayout)) {
                    festivalPopupContainerFrameLayout = null;
                }
                if (festivalPopupContainerFrameLayout != null && !festivalPopupContainerFrameLayout.pbB) {
                    this.Ury.getLastTouchUpPoint().set(this.Urx.UqP.UqM.getLastTouchUpPointRaw());
                }
                ParcelableFestivalWish.a aVar = ParcelableFestivalWish.UzR;
                com.tencent.mm.plugin.festival.b.c cVar = this.Urz.UqV;
                p.h(cVar, "pb");
                ParcelableFestivalWish parcelableFestivalWish = new ParcelableFestivalWish(cVar.x, cVar.y, cVar.UAv, cVar.text, cVar.username, cVar.UAz, cVar.UAB, cVar.nickname, cVar.gzC, com.tencent.mm.plugin.festival.c.e.awJ(cVar.createtime), cVar.country, cVar.fuJ, cVar.fuK);
                com.tencent.mm.plugin.festival.model.a.a aVar2 = com.tencent.mm.plugin.festival.model.a.a.UzS;
                com.tencent.mm.plugin.festival.model.a.a.a(parcelableFestivalWish);
                com.tencent.mm.live.c.b bVar2 = this.Urx.UqP.hOp;
                b.c cVar2 = b.c.wsX;
                Bundle bundle = new Bundle();
                bundle.putParcelable("PARAM_FESTIVAL_FINDER_LIVE_PERSONAL_WISH_DATA_MODEL", parcelableFestivalWish);
                if (!Float.isNaN(this.Ury.getLastTouchUpPoint().x) && !Float.isNaN(this.Ury.getLastTouchUpPoint().y)) {
                    bundle.putParcelable("PARAM_FESTIVAL_FINDER_LIVE_PERSONAL_WISH_ANIM_START_POINT", this.Ury.getLastTouchUpPoint());
                }
                bVar2.statusChange(cVar2, bundle);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/festival/finder/FestivalCanvasPopupContainerPlugin$viewManager$1$performShow$$inlined$apply$lambda$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(262107);
            }
        }

        /* access modifiers changed from: package-private */
        @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, hxF = {"<anonymous>", "", "invoke", "com/tencent/mm/plugin/festival/finder/FestivalCanvasPopupContainerPlugin$viewManager$1$performShow$1$1"})
        public static final class e extends q implements kotlin.g.a.a<x> {
            final /* synthetic */ g UrA;
            final /* synthetic */ int UrB;
            final /* synthetic */ int UrC;
            final /* synthetic */ g Urx;
            final /* synthetic */ com.tencent.mm.plugin.festival.ui.view.a Ury;
            final /* synthetic */ c.b Urz;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            e(com.tencent.mm.plugin.festival.ui.view.a aVar, g gVar, c.b bVar, g gVar2, int i2, int i3) {
                super(0);
                this.Ury = aVar;
                this.Urx = gVar;
                this.Urz = bVar;
                this.UrA = gVar2;
                this.UrB = i2;
                this.UrC = i3;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX WARNING: Removed duplicated region for block: B:13:0x0042 A[Catch:{ all -> 0x008d }] */
            /* JADX WARNING: Removed duplicated region for block: B:39:0x0095 A[SYNTHETIC] */
            @Override // kotlin.g.a.a
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final /* synthetic */ kotlin.x invoke() {
                /*
                // Method dump skipped, instructions count: 151
                */
                throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.festival.finder.h.g.e.invoke():java.lang.Object");
            }
        }

        /* access modifiers changed from: package-private */
        @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, hxF = {"<anonymous>", "", "invoke", "com/tencent/mm/plugin/festival/finder/FestivalCanvasPopupContainerPlugin$viewManager$1$performShow$1$2"})
        public static final class f extends q implements kotlin.g.a.a<x> {
            final /* synthetic */ g UrA;
            final /* synthetic */ int UrB;
            final /* synthetic */ int UrC;
            final /* synthetic */ g Urx;
            final /* synthetic */ com.tencent.mm.plugin.festival.ui.view.a Ury;
            final /* synthetic */ c.b Urz;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            f(com.tencent.mm.plugin.festival.ui.view.a aVar, g gVar, c.b bVar, g gVar2, int i2, int i3) {
                super(0);
                this.Ury = aVar;
                this.Urx = gVar;
                this.Urz = bVar;
                this.UrA = gVar2;
                this.UrB = i2;
                this.UrC = i3;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ x invoke() {
                AppMethodBeat.i(262104);
                this.Urx.UqP.UqM.aN(this.Ury.getCenterX(), this.Ury.getCenterY());
                x xVar = x.SXb;
                AppMethodBeat.o(262104);
                return xVar;
            }
        }

        /* access modifiers changed from: package-private */
        @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, hxF = {"<anonymous>", "", "invoke", "com/tencent/mm/plugin/festival/finder/FestivalCanvasPopupContainerPlugin$viewManager$1$performShow$1$3"})
        /* renamed from: com.tencent.mm.plugin.festival.finder.h$g$g  reason: collision with other inner class name */
        public static final class C1065g extends q implements kotlin.g.a.a<x> {
            final /* synthetic */ g UrA;
            final /* synthetic */ int UrB;
            final /* synthetic */ int UrC;
            final /* synthetic */ g Urx;
            final /* synthetic */ com.tencent.mm.plugin.festival.ui.view.a Ury;
            final /* synthetic */ c.b Urz;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            C1065g(com.tencent.mm.plugin.festival.ui.view.a aVar, g gVar, c.b bVar, g gVar2, int i2, int i3) {
                super(0);
                this.Ury = aVar;
                this.Urx = gVar;
                this.Urz = bVar;
                this.UrA = gVar2;
                this.UrB = i2;
                this.UrC = i3;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ x invoke() {
                AppMethodBeat.i(262106);
                this.Urx.UqP.UqJ.c(new Runnable(this) {
                    /* class com.tencent.mm.plugin.festival.finder.h.g.C1065g.AnonymousClass1 */
                    final /* synthetic */ C1065g UrD;

                    {
                        this.UrD = r1;
                    }

                    public final void run() {
                        AppMethodBeat.i(262105);
                        com.tencent.mm.plugin.festival.ui.view.a.c(this.UrD.Ury);
                        AppMethodBeat.o(262105);
                    }
                }, this.Urx.Urj - 300);
                x xVar = x.SXb;
                AppMethodBeat.o(262106);
                return xVar;
            }
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016¨\u0006\u0005"}, hxF = {"com/tencent/mm/plugin/festival/finder/FestivalCanvasPopupContainerPlugin$elementsViewContact$1", "Lcom/tencent/mm/plugin/festival/finder/FestivalLiveCanvasOverlayElementsPluginBase$ElementsViewContract;", "pause", "", "resume", "plugin-festival_release"})
    public static final class d implements bo.a {
        final /* synthetic */ h UqP;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        d(h hVar) {
            this.UqP = hVar;
        }

        @Override // com.tencent.mm.plugin.festival.finder.bo.a
        public final void resume() {
            AppMethodBeat.i(262088);
            this.UqP.UqK.resume();
            AppMethodBeat.o(262088);
        }

        @Override // com.tencent.mm.plugin.festival.finder.bo.a
        public final void pause() {
            AppMethodBeat.i(262089);
            this.UqP.UqK.pause();
            AppMethodBeat.o(262089);
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.festival.finder.bo
    public final bo.a dsw() {
        return this.UqL;
    }

    @Override // com.tencent.mm.plugin.festival.model.ag
    public final int dCX() {
        return 4;
    }

    public static final /* synthetic */ Context c(h hVar) {
        AppMethodBeat.i(262134);
        Context context = hVar.hwr.getContext();
        AppMethodBeat.o(262134);
        return context;
    }

    public static final /* synthetic */ List kR(List list) {
        boolean z;
        boolean z2;
        AppMethodBeat.i(262136);
        List list2 = list;
        if (list2 == null || list2.isEmpty()) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            v vVar = v.SXr;
            AppMethodBeat.o(262136);
            return vVar;
        }
        com.tencent.mm.kernel.b.a ah = com.tencent.mm.kernel.g.ah(PluginFestival.class);
        p.g(ah, "plugin(PluginFestival::class.java)");
        ad festivalWishStorage = ((PluginFestival) ah).getFestivalWishStorage();
        com.tencent.mm.kernel.b.a ah2 = com.tencent.mm.kernel.g.ah(PluginFestival.class);
        p.g(ah2, "plugin(PluginFestival::class.java)");
        String myLiveEncUsername = ((PluginFestival) ah2).getMyLiveEncUsername();
        LinkedList linkedList = new LinkedList();
        HashMap hashMap = new HashMap();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            com.tencent.mm.plugin.festival.b.c cVar = (com.tencent.mm.plugin.festival.b.c) it.next();
            if (cVar != null) {
                String str = cVar.text;
                if (!(str == null || str.length() == 0) && !p.j(myLiveEncUsername, cVar.UAB) && !ad.a(festivalWishStorage, cVar)) {
                    String str2 = cVar.UAB;
                    if (str2 == null || str2.length() == 0) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (!z2) {
                        com.tencent.mm.plugin.festival.b.c cVar2 = (com.tencent.mm.plugin.festival.b.c) hashMap.get(cVar.UAB);
                        if ((cVar2 != null ? com.tencent.mm.plugin.festival.c.e.awJ(cVar2.createtime) : 0) < com.tencent.mm.plugin.festival.c.e.awJ(cVar.createtime)) {
                            String str3 = cVar.UAB;
                            p.g(str3, "wishPB.hashusername");
                            hashMap.put(str3, cVar);
                        }
                    } else {
                        linkedList.add(cVar);
                    }
                }
            }
        }
        linkedList.addAll(hashMap.values());
        LinkedList linkedList2 = linkedList;
        AppMethodBeat.o(262136);
        return linkedList2;
    }
}

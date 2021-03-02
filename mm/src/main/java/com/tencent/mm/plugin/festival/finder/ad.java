package com.tencent.mm.plugin.festival.finder;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Bundle;
import android.os.Looper;
import android.support.v4.view.u;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.live.c.b;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.festival.PluginFestival;
import com.tencent.mm.plugin.festival.finder.k;
import com.tencent.mm.plugin.festival.model.ParcelableFestivalWish;
import com.tencent.mm.plugin.festival.model.ai;
import com.tencent.mm.pluginsdk.ui.a;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import kotlin.g.b.ae;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000k\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\f\u0018\u00002\u00020\u0001:\u0001,B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010!\u001a\u00020\u0014H\u0016J\b\u0010\"\u001a\u00020#H\u0016J\b\u0010$\u001a\u00020#H\u0016J\b\u0010%\u001a\u00020#H\u0016J\u001a\u0010&\u001a\u00020#2\u0006\u0010'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010*H\u0016J\b\u0010+\u001a\u00020#H\u0016R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0004\n\u0002\u0010\rR\u001c\u0010\u000e\u001a\n \u0010*\u0004\u0018\u00010\u000f0\u000f8BX\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u0002\n\u0000R\"\u0010\u0019\u001a\u0004\u0018\u00010\u00182\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018@BX\u000e¢\u0006\b\n\u0000\"\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001c\u001a\b\u0018\u00010\u001dR\u00020\u0000X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u001fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006-"}, hxF = {"Lcom/tencent/mm/plugin/festival/finder/FestivalFinderLiveMyNewWishPopupPlugin;", "Lcom/tencent/mm/plugin/festival/finder/FestivalFinderBaseLivePlugin;", "root", "Landroid/view/ViewGroup;", "canvasPresenter", "Lcom/tencent/mm/plugin/festival/finder/FestivalCanvasViewContract$Presenter;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/plugin/festival/finder/FestivalCanvasViewContract$Presenter;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "H", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "containerContract", "com/tencent/mm/plugin/festival/finder/FestivalFinderLiveMyNewWishPopupPlugin$containerContract$1", "Lcom/tencent/mm/plugin/festival/finder/FestivalFinderLiveMyNewWishPopupPlugin$containerContract$1;", "context", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "getContext", "()Landroid/content/Context;", "isDestroyed", "", "myNewWish", "Lcom/tencent/mm/plugin/festival/model/LocalFestivalWishInfo;", "value", "Lcom/tencent/mm/plugin/festival/ui/view/FestivalCanvasAvatarPopup;", "myNewWishPopup", "setMyNewWishPopup", "(Lcom/tencent/mm/plugin/festival/ui/view/FestivalCanvasAvatarPopup;)V", "northStar", "Lcom/tencent/mm/plugin/festival/finder/FestivalFinderLiveMyNewWishPopupPlugin$NorthStarView;", "popupAvatarSize", "", "popupTotalSize", "canClearScreen", "clearScreen", "", "mount", "recoveryScreen", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "unMount", "NorthStarView", "plugin-festival_release"})
public final class ad extends p {
    final k.a Uqk;
    private final int Uth;
    final int Uti;
    private final b Utj;
    private com.tencent.mm.plugin.festival.ui.view.a Utk;
    ai Utl;
    a Utm;
    boolean aMn;
    final com.tencent.mm.live.c.b hOp;
    final MMHandler mQp = new MMHandler(Looper.getMainLooper());

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ad(ViewGroup viewGroup, k.a aVar, com.tencent.mm.live.c.b bVar) {
        super(viewGroup, bVar);
        p.h(viewGroup, "root");
        p.h(aVar, "canvasPresenter");
        p.h(bVar, "statusMonitor");
        AppMethodBeat.i(262441);
        this.Uqk = aVar;
        this.hOp = bVar;
        Context context = this.hwr.getContext();
        p.g(context, "context");
        this.Uth = context.getResources().getDimensionPixelSize(R.dimen.cm);
        Context context2 = this.hwr.getContext();
        p.g(context2, "context");
        this.Uti = kotlin.h.a.cR(((float) this.Uth) + (((float) context2.getResources().getDimensionPixelSize(R.dimen.aqp)) * 2.0f) + 40.0f);
        rg(8);
        this.Utj = new b(this, viewGroup);
        AppMethodBeat.o(262441);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u00005\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0016\u0010\u000f\u001a\u00020\u00052\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0016J\u0016\u0010\u0011\u001a\u00020\u00052\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0016J\u0010\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0016\u0010\u0016\u001a\u00020\u00052\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0016J\u0016\u0010\u0017\u001a\u00020\u00052\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0016J\u001e\u0010\u0018\u001a\u00020\u00052\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u001a\u001a\u00020\u001bH\u0016R-\u0010\u0002\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0003j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004`\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR-\u0010\t\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0003j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004`\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\bR\u0014\u0010\u000b\u001a\u00020\f8VX\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000e¨\u0006\u001c"}, hxF = {"com/tencent/mm/plugin/festival/finder/FestivalFinderLiveMyNewWishPopupPlugin$containerContract$1", "Lcom/tencent/mm/plugin/festival/finder/FestivalCanvasPopupContainerContract;", "onPauseListeners", "Ljava/util/HashSet;", "Lkotlin/Function0;", "", "Lkotlin/collections/HashSet;", "getOnPauseListeners", "()Ljava/util/HashSet;", "onResumeListeners", "getOnResumeListeners", "safeInsets", "Landroid/graphics/Rect;", "getSafeInsets", "()Landroid/graphics/Rect;", "addPauseListener", "onPause", "addResumeListener", "onResume", "addView", "child", "Landroid/view/View;", "removePauseListener", "removeResumeListener", "uiDelayed", "block", "delay", "", "plugin-festival_release"})
    public static final class b implements g {
        final HashSet<kotlin.g.a.a<x>> Urs = new HashSet<>();
        final HashSet<kotlin.g.a.a<x>> Urt = new HashSet<>();
        final /* synthetic */ ad Utu;
        final /* synthetic */ ViewGroup hOA;

        b(ad adVar, ViewGroup viewGroup) {
            this.Utu = adVar;
            this.hOA = viewGroup;
            AppMethodBeat.i(262428);
            AppMethodBeat.o(262428);
        }

        @Override // com.tencent.mm.plugin.festival.finder.g
        public final Rect eWS() {
            AppMethodBeat.i(262422);
            Rect rect = new Rect(0, 0, this.hOA.getWidth(), this.hOA.getHeight());
            AppMethodBeat.o(262422);
            return rect;
        }

        @Override // com.tencent.mm.plugin.festival.finder.g
        public final void addView(View view) {
            AppMethodBeat.i(262423);
            p.h(view, "child");
            this.hOA.addView(view, new ViewGroup.LayoutParams(-2, -2));
            AppMethodBeat.o(262423);
        }

        @Override // com.tencent.mm.plugin.festival.finder.g
        public final void as(kotlin.g.a.a<x> aVar) {
            AppMethodBeat.i(262424);
            p.h(aVar, "onResume");
            this.Urs.add(aVar);
            AppMethodBeat.o(262424);
        }

        @Override // com.tencent.mm.plugin.festival.finder.g
        public final void at(kotlin.g.a.a<x> aVar) {
            AppMethodBeat.i(262425);
            p.h(aVar, "onResume");
            this.Urs.remove(aVar);
            AppMethodBeat.o(262425);
        }

        @Override // com.tencent.mm.plugin.festival.finder.g
        public final void au(kotlin.g.a.a<x> aVar) {
            AppMethodBeat.i(262426);
            p.h(aVar, "onPause");
            this.Urt.add(aVar);
            AppMethodBeat.o(262426);
        }

        @Override // com.tencent.mm.plugin.festival.finder.g
        public final void av(kotlin.g.a.a<x> aVar) {
            AppMethodBeat.i(262427);
            p.h(aVar, "onPause");
            this.Urt.remove(aVar);
            AppMethodBeat.o(262427);
        }
    }

    /* access modifiers changed from: package-private */
    public final void b(com.tencent.mm.plugin.festival.ui.view.a aVar) {
        AppMethodBeat.i(262435);
        this.Utk = aVar;
        if (aVar == null) {
            rg(8);
            this.hwr.removeAllViews();
            AppMethodBeat.o(262435);
            return;
        }
        rg(0);
        AppMethodBeat.o(262435);
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.live.c.a
    public final void statusChange(b.c cVar, Bundle bundle) {
        AppMethodBeat.i(262436);
        p.h(cVar, "status");
        switch (ae.$EnumSwitchMapping$0[cVar.ordinal()]) {
            case 1:
                this.Utl = null;
                com.tencent.mm.plugin.festival.ui.view.a aVar = this.Utk;
                if (aVar != null) {
                    aVar.rX(false);
                }
                b(null);
                this.Utm = null;
                this.hwr.removeAllViews();
                AppMethodBeat.o(262436);
                return;
            case 2:
                com.tencent.mm.plugin.festival.ui.view.a aVar2 = this.Utk;
                if (aVar2 != null) {
                    aVar2.rX(false);
                }
                b(null);
                this.Utm = null;
                this.hwr.removeAllViews();
                this.ulW = 65535;
                rg(0);
                this.Utl = null;
                h.RTc.aZ(new f(this));
                AppMethodBeat.o(262436);
                return;
            case 3:
                ai aiVar = this.Utl;
                if (aiVar != null) {
                    Context context = this.hwr.getContext();
                    p.g(context, "root.context");
                    com.tencent.mm.plugin.festival.ui.view.a aVar3 = new com.tencent.mm.plugin.festival.ui.view.a(context);
                    b(aVar3);
                    aVar3.setAvatarSize(this.Uth);
                    a.b.z(aVar3.UET, z.aTY());
                    aVar3.setOnDismiss(new c(aiVar, this));
                    aVar3.setOnShowAnimationEnd(new d(aiVar, this));
                    this.hwr.postDelayed(new g(aVar3), 10000);
                    aVar3.setOnClickListener(new e(aVar3, aiVar, this));
                    com.tencent.mm.plugin.festival.ui.view.a.a(aVar3, this.Utj, this.Uqk, aiVar.field_x, aiVar.field_y);
                    AppMethodBeat.o(262436);
                    return;
                }
                AppMethodBeat.o(262436);
                return;
            case 4:
                com.tencent.mm.plugin.festival.ui.view.a aVar4 = this.Utk;
                if (aVar4 != null) {
                    aVar4.a("CanvasTransformed", this.Utj, this.Uqk);
                }
                if (this.Utk != null) {
                    a aVar5 = this.Utm;
                    if (aVar5 != null) {
                        com.tencent.mm.plugin.festival.ui.view.a aVar6 = this.Utk;
                        if (aVar6 == null) {
                            p.hyc();
                        }
                        float centerX = aVar6.getCenterX();
                        com.tencent.mm.plugin.festival.ui.view.a aVar7 = this.Utk;
                        if (aVar7 == null) {
                            p.hyc();
                        }
                        aVar5.aO(centerX, aVar7.getCenterY());
                        AppMethodBeat.o(262436);
                        return;
                    }
                    AppMethodBeat.o(262436);
                    return;
                }
                a aVar8 = this.Utm;
                if (aVar8 != null) {
                    aVar8.fvY();
                    AppMethodBeat.o(262436);
                    return;
                }
                AppMethodBeat.o(262436);
                return;
            case 5:
                ai aiVar2 = this.Utl;
                if (aiVar2 != null) {
                    com.tencent.mm.live.c.b bVar = this.hOp;
                    b.c cVar2 = b.c.wMi;
                    Bundle bundle2 = new Bundle(1);
                    ParcelableFestivalWish.a aVar9 = ParcelableFestivalWish.UzR;
                    bundle2.putParcelable("PARAM_FESTIVAL_FINDER_LIVE_MY_NEW_WISH_PARCELABLE_MODEL", ParcelableFestivalWish.a.a(aiVar2));
                    bVar.statusChange(cVar2, bundle2);
                    AppMethodBeat.o(262436);
                    return;
                }
                break;
        }
        AppMethodBeat.o(262436);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class f implements Runnable {
        final /* synthetic */ ad Utu;

        f(ad adVar) {
            this.Utu = adVar;
        }

        public final void run() {
            AppMethodBeat.i(262433);
            com.tencent.mm.kernel.b.a ah = com.tencent.mm.kernel.g.ah(PluginFestival.class);
            p.g(ah, "MMKernel.plugin(PluginFestival::class.java)");
            ai hRS = ((PluginFestival) ah).getFestivalWishStorage().hRS();
            if (hRS != null) {
                this.Utu.Utl = hRS;
                this.Utu.mQp.post(new a(hRS, this));
                AppMethodBeat.o(262433);
                return;
            }
            AppMethodBeat.o(262433);
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, hxF = {"<anonymous>", "", "run", "com/tencent/mm/plugin/festival/finder/FestivalFinderLiveMyNewWishPopupPlugin$statusChange$1$1$1"})
        static final class a implements Runnable {
            final /* synthetic */ ai Utw;
            final /* synthetic */ f Utx;

            a(ai aiVar, f fVar) {
                this.Utw = aiVar;
                this.Utx = fVar;
            }

            public final void run() {
                AppMethodBeat.i(262432);
                if (!this.Utx.Utu.aMn) {
                    ad adVar = this.Utx.Utu;
                    ad adVar2 = this.Utx.Utu;
                    Context context = this.Utx.Utu.hwr.getContext();
                    p.g(context, "root.context");
                    a aVar = new a(adVar2, context);
                    this.Utx.Utu.hwr.addView(aVar, new ViewGroup.LayoutParams(-2, -2));
                    aVar.fvY();
                    int i2 = this.Utw.field_x;
                    int i3 = this.Utw.field_y;
                    aVar.isStarted = true;
                    aVar.kZy = i2;
                    aVar.kZz = i3;
                    u.X(aVar);
                    adVar.Utm = aVar;
                }
                AppMethodBeat.o(262432);
            }
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class g implements Runnable {
        final /* synthetic */ com.tencent.mm.plugin.festival.ui.view.a Ury;

        g(com.tencent.mm.plugin.festival.ui.view.a aVar) {
            this.Ury = aVar;
        }

        public final void run() {
            AppMethodBeat.i(262434);
            com.tencent.mm.plugin.festival.ui.view.a.c(this.Ury);
            AppMethodBeat.o(262434);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0004\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0007"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/festival/finder/FestivalFinderLiveMyNewWishPopupPlugin$statusChange$2$1$4", "com/tencent/mm/plugin/festival/finder/FestivalFinderLiveMyNewWishPopupPlugin$$special$$inlined$apply$lambda$3"})
    static final class e implements View.OnClickListener {
        final /* synthetic */ com.tencent.mm.plugin.festival.ui.view.a Ury;
        final /* synthetic */ ad Utu;
        final /* synthetic */ ai Utv;

        e(com.tencent.mm.plugin.festival.ui.view.a aVar, ai aiVar, ad adVar) {
            this.Ury = aVar;
            this.Utv = aiVar;
            this.Utu = adVar;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(262431);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/festival/finder/FestivalFinderLiveMyNewWishPopupPlugin$statusChange$$inlined$let$lambda$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            ParcelableFestivalWish.a aVar = ParcelableFestivalWish.UzR;
            ParcelableFestivalWish a2 = ParcelableFestivalWish.a.a(this.Utv);
            com.tencent.mm.plugin.festival.model.a.a aVar2 = com.tencent.mm.plugin.festival.model.a.a.UzS;
            com.tencent.mm.plugin.festival.model.a.a.a(a2);
            com.tencent.mm.live.c.b bVar2 = this.Utu.hOp;
            b.c cVar = b.c.wsX;
            Bundle bundle = new Bundle();
            bundle.putParcelable("PARAM_FESTIVAL_FINDER_LIVE_PERSONAL_WISH_DATA_MODEL", a2);
            if (!Float.isNaN(this.Ury.getLastTouchUpPoint().x) && !Float.isNaN(this.Ury.getLastTouchUpPoint().y)) {
                bundle.putParcelable("PARAM_FESTIVAL_FINDER_LIVE_PERSONAL_WISH_ANIM_START_POINT", this.Ury.getLastTouchUpPoint());
            }
            bVar2.statusChange(cVar, bundle);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/festival/finder/FestivalFinderLiveMyNewWishPopupPlugin$statusChange$$inlined$let$lambda$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(262431);
        }
    }

    @Override // com.tencent.mm.plugin.festival.finder.p, com.tencent.mm.plugin.finder.live.plugin.d, com.tencent.mm.live.c.a
    public final void mount() {
        AppMethodBeat.i(262437);
        this.aMn = false;
        super.mount();
        AppMethodBeat.o(262437);
    }

    @Override // com.tencent.mm.plugin.festival.finder.p, com.tencent.mm.plugin.finder.live.plugin.d, com.tencent.mm.live.c.a
    public final void unMount() {
        AppMethodBeat.i(262438);
        this.aMn = true;
        this.mQp.removeCallbacksAndMessages(null);
        super.unMount();
        AppMethodBeat.o(262438);
    }

    @Override // com.tencent.mm.plugin.finder.live.plugin.d
    public final boolean dgK() {
        return true;
    }

    @Override // com.tencent.mm.plugin.finder.live.plugin.d
    public final void epk() {
        AppMethodBeat.i(262439);
        super.epk();
        Iterator<T> it = this.Utj.Urt.iterator();
        while (it.hasNext()) {
            it.next().invoke();
        }
        AppMethodBeat.o(262439);
    }

    @Override // com.tencent.mm.plugin.festival.finder.p, com.tencent.mm.plugin.finder.live.plugin.d
    public final void dCW() {
        AppMethodBeat.i(262440);
        super.dCW();
        Iterator<T> it = this.Utj.Urs.iterator();
        while (it.hasNext()) {
            it.next().invoke();
        }
        AppMethodBeat.o(262440);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010 \u001a\u00020!H\u0016J\u0010\u0010\"\u001a\u00020!2\u0006\u0010#\u001a\u00020$H\u0014J\u0018\u0010%\u001a\u00020!2\u0006\u0010&\u001a\u00020\b2\u0006\u0010'\u001a\u00020\bH\u0014J\u0006\u0010(\u001a\u00020!J\u0016\u0010)\u001a\u00020!2\u0006\u0010\u001e\u001a\u00020\b2\u0006\u0010\u001f\u001a\u00020\bJ\u0006\u0010*\u001a\u00020!J\u0016\u0010*\u001a\u00020!2\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020,R\u000e\u0010\u0005\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bXD¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bXD¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0015\u001a\u0012\u0012\u0004\u0012\u00020\u00170\u0016j\b\u0012\u0004\u0012\u00020\u0017`\u0018X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u001b\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u000e\u0010\u001e\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000¨\u0006."}, hxF = {"Lcom/tencent/mm/plugin/festival/finder/FestivalFinderLiveMyNewWishPopupPlugin$NorthStarView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "(Lcom/tencent/mm/plugin/festival/finder/FestivalFinderLiveMyNewWishPopupPlugin;Landroid/content/Context;)V", "DURATION", "", "FRAME_COUNT", "", "FRAME_INTERVAL", "TAG", "", "bitmapRect", "Landroid/graphics/Rect;", "centerSafeInsets", "Landroid/graphics/RectF;", "currentFrameIndex", "currentFrameStartUptimeMillis", "drawPaint", "Landroid/graphics/Paint;", "drawRect", "frameList", "Ljava/util/ArrayList;", "Landroid/graphics/Bitmap;", "Lkotlin/collections/ArrayList;", "isStarted", "", "size", "getSize", "()I", "sx", "sy", "computeScroll", "", "onDraw", "canvas", "Landroid/graphics/Canvas;", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "release", "startShining", "updateLocation", "_centerX", "", "_centerY", "plugin-festival_release"})
    @SuppressLint({"ViewConstructor"})
    public final class a extends View {
        private final String TAG = "MicroMsg.Festival.NorthStarView";
        private final int Utn = 36;
        private final int Uto = kotlin.h.a.cR(((float) this.lZa) / ((float) this.Utn));
        private int Utp;
        private long Utq;
        private ArrayList<Bitmap> Utr;
        private final Rect Uts;
        private final RectF Utt;
        final /* synthetic */ ad Utu;
        private final Rect diV;
        boolean isStarted;
        int kZy;
        int kZz;
        private final long lZa = 1500;
        private final Paint qvj;
        private final int size;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(ad adVar, Context context) {
            super(context);
            p.h(context, "context");
            this.Utu = adVar;
            AppMethodBeat.i(262420);
            this.size = context.getResources().getDimensionPixelSize(R.dimen.c3);
            this.diV = new Rect();
            this.Uts = new Rect();
            this.qvj = new Paint(1);
            this.Utt = new RectF();
            AppMethodBeat.o(262420);
        }

        public final int getSize() {
            return this.size;
        }

        /* access modifiers changed from: protected */
        public final void onMeasure(int i2, int i3) {
            AppMethodBeat.i(262415);
            setMeasuredDimension(this.size, this.size);
            AppMethodBeat.o(262415);
        }

        public final void fvY() {
            AppMethodBeat.i(262416);
            aO(this.Utu.Uqk.Y((float) this.kZy), this.Utu.Uqk.Z((float) this.kZz));
            AppMethodBeat.o(262416);
        }

        public final void aO(float f2, float f3) {
            AppMethodBeat.i(262417);
            this.Utt.set(((float) this.Utu.Uti) / 2.0f, ((float) this.Utu.Uti) / 2.0f, ((float) this.Utu.hwr.getWidth()) - (((float) this.Utu.Uti) / 2.0f), ((float) this.Utu.hwr.getHeight()) - (((float) this.Utu.Uti) / 2.0f));
            float p = android.support.v4.b.a.p(f2, this.Utt.left, this.Utt.right);
            float p2 = android.support.v4.b.a.p(f3, this.Utt.top, this.Utt.bottom);
            super.setX(p - (((float) this.size) / 2.0f));
            super.setY(p2 - (((float) this.size) / 2.0f));
            AppMethodBeat.o(262417);
        }

        /* access modifiers changed from: protected */
        public final void onDraw(Canvas canvas) {
            AppMethodBeat.i(262418);
            p.h(canvas, "canvas");
            if (!this.isStarted) {
                AppMethodBeat.o(262418);
                return;
            }
            if (this.Utr != null) {
                ArrayList<Bitmap> arrayList = this.Utr;
                if (arrayList == null) {
                    p.btv("frameList");
                }
                Bitmap bitmap = arrayList.get(this.Utp);
                p.g(bitmap, "frameList[currentFrameIndex]");
                Bitmap bitmap2 = bitmap;
                this.diV.set(0, 0, bitmap2.getWidth(), bitmap2.getHeight());
                this.Uts.set(0, 0, this.size, this.size);
                canvas.drawBitmap(bitmap2, this.diV, this.Uts, this.qvj);
            }
            AppMethodBeat.o(262418);
        }

        public final void computeScroll() {
            AppMethodBeat.i(262419);
            if (!this.isStarted) {
                AppMethodBeat.o(262419);
                return;
            }
            if (this.Utr == null) {
                try {
                    ArrayList<Bitmap> arrayList = new ArrayList<>(this.Utn);
                    int i2 = this.Utn;
                    for (int i3 = 0; i3 < i2; i3++) {
                        Context context = getContext();
                        p.g(context, "context");
                        AssetManager assets = context.getAssets();
                        ae aeVar = ae.SYK;
                        Locale locale = Locale.ENGLISH;
                        p.g(locale, "Locale.ENGLISH");
                        String format = String.format(locale, "festival2021/north_star/northstar_@2x_%05d.png", Arrays.copyOf(new Object[]{Integer.valueOf(i3)}, 1));
                        p.g(format, "java.lang.String.format(locale, format, *args)");
                        arrayList.add(i3, BitmapFactory.decodeStream(assets.open(format)));
                    }
                    this.Utr = arrayList;
                } catch (OutOfMemoryError e2) {
                    Log.e(this.TAG, "computeScroll init frameList oom");
                    AppMethodBeat.o(262419);
                    return;
                }
            }
            if (this.Utq <= 0) {
                this.Utq = AnimationUtils.currentAnimationTimeMillis();
                this.Utp = 0;
            } else if (AnimationUtils.currentAnimationTimeMillis() - this.Utq > ((long) this.Uto)) {
                this.Utq = AnimationUtils.currentAnimationTimeMillis();
                this.Utp = Math.min(this.Utp + 1, this.Utn - 1);
            }
            u.X(this);
            AppMethodBeat.o(262419);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0004"}, hxF = {"<anonymous>", "", "invoke", "com/tencent/mm/plugin/festival/finder/FestivalFinderLiveMyNewWishPopupPlugin$statusChange$2$1$1", "com/tencent/mm/plugin/festival/finder/FestivalFinderLiveMyNewWishPopupPlugin$$special$$inlined$apply$lambda$1"})
    static final class c extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ ad Utu;
        final /* synthetic */ ai Utv;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(ai aiVar, ad adVar) {
            super(0);
            this.Utv = aiVar;
            this.Utu = adVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(262429);
            this.Utu.b(null);
            x xVar = x.SXb;
            AppMethodBeat.o(262429);
            return xVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0004"}, hxF = {"<anonymous>", "", "invoke", "com/tencent/mm/plugin/festival/finder/FestivalFinderLiveMyNewWishPopupPlugin$statusChange$2$1$2", "com/tencent/mm/plugin/festival/finder/FestivalFinderLiveMyNewWishPopupPlugin$$special$$inlined$apply$lambda$2"})
    static final class d extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ ad Utu;
        final /* synthetic */ ai Utv;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(ai aiVar, ad adVar) {
            super(0);
            this.Utv = aiVar;
            this.Utu = adVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(262430);
            a aVar = this.Utu.Utm;
            if (aVar != null) {
                this.Utu.hwr.removeView(aVar);
            }
            this.Utu.Utm = null;
            x xVar = x.SXb;
            AppMethodBeat.o(262430);
            return xVar;
        }
    }
}

package com.tencent.mm.plugin.festival.model;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.a.zj;
import com.tencent.mm.plugin.ball.model.BallInfo;
import com.tencent.mm.plugin.ball.service.FloatBallHelper;
import com.tencent.mm.plugin.festival.finder.FestivalFinderLiveEndUI;
import com.tencent.mm.plugin.festival.model.e;
import com.tencent.mm.plugin.festival.ui.StarryNight;
import com.tencent.mm.pluginsdk.permission.RequestFloatWindowPermissionDialog;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.PhoneStatusWatcher;
import com.tencent.mm.ui.at;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001,B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J;\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172!\u0010\u0018\u001a\u001d\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u00020\u00130\u0019J\u000e\u0010\u001d\u001a\u00020\u00132\u0006\u0010\u001e\u001a\u00020\u0006J1\u0010\u001f\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152!\u0010\u0018\u001a\u001d\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b( \u0012\u0004\u0012\u00020\u00130\u0019J\b\u0010!\u001a\u00020\u0013H\u0002J\u0006\u0010\"\u001a\u00020\u0013J\u0006\u0010#\u001a\u00020\u0013J\u001a\u0010$\u001a\u00020%2\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0002J\u0006\u0010&\u001a\u00020\u0013J\u0010\u0010'\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u0006\u0010(\u001a\u00020\u0013J\u0006\u0010)\u001a\u00020\u0013J\b\u0010*\u001a\u00020\u0013H\u0002J\u0006\u0010+\u001a\u00020\u0013R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u000eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000¨\u0006-"}, hxF = {"Lcom/tencent/mm/plugin/festival/model/FestivalFloatBallHelper;", "Lcom/tencent/mm/plugin/ball/service/FloatBallHelper;", "()V", "TAG", "", EnvConsts.ACTIVITY_MANAGER_SRVNAME, "Landroid/app/Activity;", "isReport", "", "mPhoneCallListener", "Lcom/tencent/mm/sdk/platformtools/PhoneStatusWatcher$PhoneCallListener;", "mPhoneStatusWatcher", "Lcom/tencent/mm/sdk/platformtools/PhoneStatusWatcher;", "mVoipEventListener", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/VoipEvent;", "uiHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "addFloatBall", "", "context", "Landroid/content/Context;", "capture", "Landroid/graphics/Bitmap;", "callback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "addSUc", "bindActivity", "act", "checkPermission", "hadPermission", "closeBall", "closeFestivalFromFloatBall", "create", "createFestivalFloatBallView", "Landroid/view/View;", "destroy", "enterFestivalWishPlaceFromFloatBall", "forceCloseFestivalLiveFloatBall", "removeFloatBall", "setFloatBallViewSize", "unBindActivity", "FestivalCanvasMiniView", "plugin-festival_release"})
public final class h extends FloatBallHelper {
    public static final h Uye;
    private static Activity activity;
    private static final MMHandler hAk = new MMHandler(Looper.getMainLooper());
    private static PhoneStatusWatcher kYD;
    private static final PhoneStatusWatcher.PhoneCallListener kYE = g.Uyj;
    private static final IListener<zj> kYG = new C1070h();
    private static boolean vtY;

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", "hadPermission", "", "invoke"})
    public static final class b extends q implements kotlin.g.a.b<Boolean, x> {
        final /* synthetic */ Context $context;
        final /* synthetic */ Bitmap Uyg = null;
        final /* synthetic */ kotlin.g.a.b gWe;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(Context context, kotlin.g.a.b bVar) {
            super(1);
            this.$context = context;
            this.gWe = bVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(Boolean bool) {
            AppMethodBeat.i(262964);
            if (bool.booleanValue()) {
                if (!h.Uye.ciq()) {
                    Log.i("FestivalFloatBallHelper", "addFloatBall new add");
                    h.Uye.oWE.oWr = true;
                    h.Uye.oWE.nno = false;
                    h.Uye.oWE.state = 2048;
                    BallInfo ballInfo = h.Uye.oWE;
                    h hVar = h.Uye;
                    ballInfo.vk = h.mf(this.$context);
                    BallInfo ballInfo2 = h.Uye.oWE;
                    h hVar2 = h.Uye;
                    ballInfo2.gqx = h.vtY;
                    h hVar3 = h.Uye;
                    if (!h.vtY) {
                        h hVar4 = h.Uye;
                        h.vtY = true;
                    }
                    h.Uye.oWE.oWq = true;
                    h.b(h.Uye);
                    h.Uye.cis();
                } else {
                    Log.i("FestivalFloatBallHelper", "addFloatBall already had");
                }
                this.gWe.invoke(Boolean.TRUE);
            } else {
                this.gWe.invoke(Boolean.FALSE);
            }
            x xVar = x.SXb;
            AppMethodBeat.o(262964);
            return xVar;
        }
    }

    static {
        AppMethodBeat.i(262985);
        h hVar = new h();
        Uye = hVar;
        hVar.G(24, com.tencent.mm.plugin.ball.f.b.cjf());
        AppMethodBeat.o(262985);
    }

    private h() {
    }

    public static void an(Activity activity2) {
        AppMethodBeat.i(262978);
        p.h(activity2, "act");
        Log.i("FestivalFloatBallHelper", "bindActivity");
        activity = activity2;
        AppMethodBeat.o(262978);
    }

    public static void gWM() {
        AppMethodBeat.i(262979);
        activity = null;
        Log.i("FestivalFloatBallHelper", "unBindActivity");
        AppMethodBeat.o(262979);
    }

    public static void create() {
        AppMethodBeat.i(262980);
        Log.i("FestivalFloatBallHelper", "create");
        hAk.post(d.Uyh);
        AppMethodBeat.o(262980);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class d implements Runnable {
        public static final d Uyh = new d();

        static {
            AppMethodBeat.i(262969);
            AppMethodBeat.o(262969);
        }

        d() {
        }

        public final void run() {
            AppMethodBeat.i(262968);
            h hVar = h.Uye;
            PhoneStatusWatcher phoneStatusWatcher = new PhoneStatusWatcher();
            phoneStatusWatcher.begin(MMApplicationContext.getContext());
            h hVar2 = h.Uye;
            phoneStatusWatcher.addPhoneCallListener(h.kYE);
            h.kYD = phoneStatusWatcher;
            h hVar3 = h.Uye;
            h.kYG.alive();
            AppMethodBeat.o(262968);
        }
    }

    public static void destroy() {
        AppMethodBeat.i(262981);
        Log.i("FestivalFloatBallHelper", "destroy");
        hAk.removeCallbacksAndMessages(null);
        PhoneStatusWatcher phoneStatusWatcher = kYD;
        if (phoneStatusWatcher != null) {
            phoneStatusWatcher.removePhoneCallListener(kYE);
            phoneStatusWatcher.end();
        }
        kYG.dead();
        AppMethodBeat.o(262981);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", "state", "", "onPhoneCall"})
    static final class g implements PhoneStatusWatcher.PhoneCallListener {
        public static final g Uyj = new g();

        static {
            AppMethodBeat.i(262976);
            AppMethodBeat.o(262976);
        }

        g() {
        }

        @Override // com.tencent.mm.sdk.platformtools.PhoneStatusWatcher.PhoneCallListener
        public final void onPhoneCall(int i2) {
            AppMethodBeat.i(262975);
            switch (i2) {
                case 0:
                    AppMethodBeat.o(262975);
                    return;
                case 1:
                case 2:
                    Log.i("FestivalFloatBallHelper", "onPhoneCall, removeCurrentBall, state:%s", Integer.valueOf(i2));
                    com.tencent.f.h.RTc.aV(AnonymousClass1.Uyk);
                    break;
            }
            AppMethodBeat.o(262975);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/festival/model/FestivalFloatBallHelper$mVoipEventListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/VoipEvent;", "callback", "", "event", "plugin-festival_release"})
    /* renamed from: com.tencent.mm.plugin.festival.model.h$h  reason: collision with other inner class name */
    public static final class C1070h extends IListener<zj> {
        C1070h() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(zj zjVar) {
            AppMethodBeat.i(262977);
            zj zjVar2 = zjVar;
            if (zjVar2 != null) {
                Log.i("FestivalFloatBallHelper", "receive VoipEvent:[%s, %s]", Integer.valueOf(zjVar2.efx.eft), Integer.valueOf(zjVar2.efx.dKy));
                if (zjVar2.efx.dKy == 7 || zjVar2.efx.dKy == 3) {
                    h.Uye.dqm();
                }
            }
            AppMethodBeat.o(262977);
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\bÂ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0005\u001a\u00020\u0006J\u0006\u0010\u0007\u001a\u00020\bR\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\t"}, hxF = {"Lcom/tencent/mm/plugin/festival/model/FestivalFloatBallHelper$FestivalCanvasMiniView;", "", "()V", "logic", "Lcom/tencent/mm/plugin/festival/ui/FestivalCanvasViewLogic;", "getView", "Landroid/view/View;", "releaseView", "", "plugin-festival_release"})
    public static final class a {
        private static com.tencent.mm.plugin.festival.ui.c Uqw;
        public static final a Uyf = new a();

        static {
            AppMethodBeat.i(262963);
            AppMethodBeat.o(262963);
        }

        private a() {
        }

        public static View getView() {
            AppMethodBeat.i(262961);
            Log.i("FestivalFloatBallHelper", "miniview getView ");
            if (Uqw == null) {
                Context context = MMApplicationContext.getContext();
                p.g(context, "context");
                Uqw = new com.tencent.mm.plugin.festival.ui.c(context);
                int aH = at.aH(MMApplicationContext.getContext(), R.dimen.ct);
                com.tencent.mm.plugin.festival.ui.c cVar = Uqw;
                if (cVar == null) {
                    p.hyc();
                }
                cVar.UBq.setRadiusCorner((float) aH);
                com.tencent.mm.plugin.festival.ui.c cVar2 = Uqw;
                if (cVar2 == null) {
                    p.hyc();
                }
                cVar2.UBq.setVRectOffsetY(0.0f);
                com.tencent.mm.plugin.festival.ui.c cVar3 = Uqw;
                if (cVar3 == null) {
                    p.hyc();
                }
                cVar3.UBq.setTouchable(false);
                com.tencent.mm.plugin.festival.ui.c cVar4 = Uqw;
                if (cVar4 == null) {
                    p.hyc();
                }
                cVar4.UBq.getSensor().pause();
                com.tencent.mm.plugin.festival.ui.c cVar5 = Uqw;
                if (cVar5 == null) {
                    p.hyc();
                }
                cVar5.UBq.setDrawEffect(2);
                if (Uqw == null) {
                    p.hyc();
                }
                com.tencent.mm.plugin.festival.ui.c cVar6 = Uqw;
                if (cVar6 == null) {
                    p.hyc();
                }
                cVar6.resume();
            }
            com.tencent.mm.plugin.festival.ui.c cVar7 = Uqw;
            if (cVar7 == null) {
                p.hyc();
            }
            StarryNight starryNight = cVar7.UBq;
            AppMethodBeat.o(262961);
            return starryNight;
        }

        public static void gWS() {
            AppMethodBeat.i(262962);
            com.tencent.mm.plugin.festival.ui.c cVar = Uqw;
            if (cVar != null) {
                cVar.pause();
            }
            com.tencent.mm.plugin.festival.ui.c cVar2 = Uqw;
            if (cVar2 != null) {
                cVar2.UBq.release();
                AppMethodBeat.o(262962);
                return;
            }
            AppMethodBeat.o(262962);
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/festival/model/FestivalFloatBallHelper$createFestivalFloatBallView$1$1"})
    public static final class e implements View.OnClickListener {
        final /* synthetic */ Context $context$inlined;

        e(Context context) {
            this.$context$inlined = context;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(262970);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/festival/model/FestivalFloatBallHelper$createFestivalFloatBallView$$inlined$apply$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            h hVar = h.Uye;
            h.mg(this.$context$inlined);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/festival/model/FestivalFloatBallHelper$createFestivalFloatBallView$$inlined$apply$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(262970);
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    public static final class f implements View.OnClickListener {
        public static final f Uyi = new f();

        static {
            AppMethodBeat.i(262972);
            AppMethodBeat.o(262972);
        }

        f() {
        }

        public final void onClick(View view) {
            AppMethodBeat.i(262971);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/festival/model/FestivalFloatBallHelper$createFestivalFloatBallView$1$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            h hVar = h.Uye;
            Log.i("FestivalFloatBallHelper", "closeFestivalFromFloatBall");
            i iVar = i.Uyl;
            i.log("closeFestivalFromFloatBall");
            if (hVar.ciq()) {
                hVar.cir();
            }
            h.gWN();
            e.a aVar = e.UxL;
            e.a.gFm();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/festival/model/FestivalFloatBallHelper$createFestivalFloatBallView$1$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(262971);
        }
    }

    static void gWN() {
        AppMethodBeat.i(262982);
        Activity activity2 = activity;
        if (activity2 == null) {
            Log.i("FestivalFloatBallHelper", "closeActivity activity unbinded");
        } else if (activity2.isDestroyed() || activity2.isFinishing()) {
            Log.i("FestivalFloatBallHelper", "closeActivity already destroy isDestroyed: " + activity2.isDestroyed() + " isFinishing:" + activity2.isFinishing());
        } else {
            Log.i("FestivalFloatBallHelper", "closeActivity manual close activity");
            activity2.finish();
        }
        a aVar = a.Uyf;
        a.gWS();
        com.tencent.mm.plugin.festival.finder.at atVar = com.tencent.mm.plugin.festival.finder.at.Uuv;
        com.tencent.mm.plugin.festival.finder.at.a(false, (Boolean) null, (Boolean) null, 15);
        AppMethodBeat.o(262982);
    }

    public final void dqm() {
        AppMethodBeat.i(262983);
        if (!ciq()) {
            Log.i("FestivalFloatBallHelper", "forceCloseFestivalLiveFloatBall not have float ball");
            AppMethodBeat.o(262983);
            return;
        }
        cir();
        gWN();
        AppMethodBeat.o(262983);
    }

    public static void d(Context context, kotlin.g.a.b<? super Boolean, x> bVar) {
        AppMethodBeat.i(262984);
        p.h(context, "context");
        p.h(bVar, "callback");
        if (!com.tencent.mm.compatible.e.b.cx(MMApplicationContext.getContext())) {
            Log.i("FestivalFloatBallHelper", "checkPermission ask for");
            RequestFloatWindowPermissionDialog.a(context, context.getString(R.string.ej9), new c(bVar), false, com.tencent.mm.bq.a.apJ());
            AppMethodBeat.o(262984);
            return;
        }
        Log.i("FestivalFloatBallHelper", "checkPermission had");
        bVar.invoke(Boolean.TRUE);
        AppMethodBeat.o(262984);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0007\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\b"}, hxF = {"com/tencent/mm/plugin/festival/model/FestivalFloatBallHelper$checkPermission$1", "Lcom/tencent/mm/pluginsdk/permission/RequestFloatWindowPermissionDialog$OverlayPermissionResultCallBack;", "onResultAllow", "", "dialog", "Lcom/tencent/mm/pluginsdk/permission/RequestFloatWindowPermissionDialog;", "onResultCancel", "onResultRefuse", "plugin-festival_release"})
    public static final class c implements RequestFloatWindowPermissionDialog.a {
        final /* synthetic */ kotlin.g.a.b gWe;

        c(kotlin.g.a.b bVar) {
            this.gWe = bVar;
        }

        @Override // com.tencent.mm.pluginsdk.permission.RequestFloatWindowPermissionDialog.a
        public final void onResultCancel(RequestFloatWindowPermissionDialog requestFloatWindowPermissionDialog) {
            AppMethodBeat.i(262965);
            Log.i("FestivalFloatBallHelper", "checkPermission ask for onResultCancel");
            this.gWe.invoke(Boolean.FALSE);
            AppMethodBeat.o(262965);
        }

        @Override // com.tencent.mm.pluginsdk.permission.RequestFloatWindowPermissionDialog.a
        public final void onResultAllow(RequestFloatWindowPermissionDialog requestFloatWindowPermissionDialog) {
            AppMethodBeat.i(262966);
            Log.i("FestivalFloatBallHelper", "checkPermission ask for onResultAllow");
            this.gWe.invoke(Boolean.TRUE);
            AppMethodBeat.o(262966);
        }

        @Override // com.tencent.mm.pluginsdk.permission.RequestFloatWindowPermissionDialog.a
        public final void onResultRefuse(RequestFloatWindowPermissionDialog requestFloatWindowPermissionDialog) {
            AppMethodBeat.i(262967);
            Log.i("FestivalFloatBallHelper", "checkPermission ask for onResultRefuse");
            this.gWe.invoke(Boolean.FALSE);
            AppMethodBeat.o(262967);
        }
    }

    public static final /* synthetic */ View mf(Context context) {
        ViewGroup viewGroup = null;
        AppMethodBeat.i(262986);
        View inflate = LayoutInflater.from(context).inflate(R.layout.cdx, (ViewGroup) null);
        RelativeLayout relativeLayout = (RelativeLayout) inflate.findViewById(R.id.jux);
        a aVar = a.Uyf;
        ViewParent parent = a.getView().getParent();
        if (parent instanceof ViewGroup) {
            viewGroup = parent;
        }
        ViewGroup viewGroup2 = viewGroup;
        if (viewGroup2 != null) {
            a aVar2 = a.Uyf;
            viewGroup2.removeView(a.getView());
        }
        a aVar3 = a.Uyf;
        relativeLayout.addView(a.getView(), new ViewGroup.LayoutParams(-1, -1));
        inflate.setOnClickListener(new e(context));
        ((WeImageView) inflate.findViewById(R.id.juw)).setOnClickListener(f.Uyi);
        p.g(inflate, "LayoutInflater.from(cont…)\n            }\n        }");
        AppMethodBeat.o(262986);
        return inflate;
    }

    public static final /* synthetic */ void b(h hVar) {
        AppMethodBeat.i(262987);
        if (hVar.oWE.oWm == null) {
            hVar.oWE.oWm = new Point();
        }
        int aH = at.aH(MMApplicationContext.getContext(), R.dimen.ct);
        hVar.oWE.oWm.x = at.aH(MMApplicationContext.getContext(), R.dimen.a7b) + (aH * 2);
        hVar.oWE.oWm.y = at.aH(MMApplicationContext.getContext(), R.dimen.a7_) + (aH * 2);
        Log.v("MicroMsg.LiveFloatBallHelper", "setLiveViewSize %s, margin: %d", hVar.oWE.oWm, Integer.valueOf(aH));
        AppMethodBeat.o(262987);
    }

    public static final /* synthetic */ void mg(Context context) {
        AppMethodBeat.i(262988);
        i iVar = i.Uyl;
        i.log("enter from floatBall");
        com.tencent.mm.plugin.festival.model.a.b bVar = com.tencent.mm.plugin.festival.model.a.b.UzX;
        com.tencent.mm.plugin.festival.model.a.b.awF(22);
        Intent intent = new Intent(context, FestivalFinderLiveEndUI.class);
        intent.addFlags(872415232);
        g gVar = g.UxZ;
        g.Fl(false);
        Context context2 = MMApplicationContext.getContext();
        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
        com.tencent.mm.hellhoundlib.a.a.a(context2, bl.axQ(), "com/tencent/mm/plugin/festival/model/FestivalFloatBallHelper", "enterFestivalWishPlaceFromFloatBall", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        context2.startActivity((Intent) bl.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(context2, "com/tencent/mm/plugin/festival/model/FestivalFloatBallHelper", "enterFestivalWishPlaceFromFloatBall", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(262988);
    }
}

package com.tencent.mm.plugin.festival.finder;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleOwner;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.hn;
import com.tencent.mm.live.core.core.d.b;
import com.tencent.mm.live.core.core.d.c;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.festival.finder.w;
import com.tencent.mm.plugin.festival.model.h;
import com.tencent.mm.plugin.festival.model.i;
import com.tencent.mm.plugin.festival.model.z;
import com.tencent.mm.plugin.finder.life.UILifecycleObserver;
import com.tencent.mm.plugin.finder.live.view.FinderBaseLivePluginLayout;
import com.tencent.mm.plugin.finder.live.view.FinderLiveMiniView;
import com.tencent.mm.plugin.finder.live.viewmodel.c;
import com.tencent.mm.plugin.finder.live.viewmodel.g;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f*\u0001\u000f\u0018\u0000 12\u00020\u00012\u00020\u0002:\u00011B/\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rJ\u0012\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\fH\u0002J\b\u0010\u0016\u001a\u00020\u0006H\u0016J\b\u0010\u0017\u001a\u00020\nH\u0016J\u0010\u0010\u0018\u001a\u00020\u00142\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\u0018\u0010\u001b\u001a\u00020\u00142\u0006\u0010\u001c\u001a\u00020\f2\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\"\u0010\u001f\u001a\u00020\u00142\u0006\u0010 \u001a\u00020\u001e2\u0006\u0010!\u001a\u00020\u001e2\b\u0010\u0019\u001a\u0004\u0018\u00010\"H\u0016J\b\u0010#\u001a\u00020\fH\u0016J\u0010\u0010$\u001a\u00020\u00142\u0006\u0010%\u001a\u00020&H\u0016J\u0010\u0010'\u001a\u00020\u00142\u0006\u0010%\u001a\u00020&H\u0016J\b\u0010(\u001a\u00020\u0014H\u0016J\u0012\u0010)\u001a\u00020\u00142\b\u0010*\u001a\u0004\u0018\u00010\"H\u0016J\u0010\u0010+\u001a\u00020\u00142\u0006\u0010%\u001a\u00020&H\u0016J\u0010\u0010,\u001a\u00020\u00142\u0006\u0010%\u001a\u00020&H\u0016J\u0010\u0010-\u001a\u00020\u00142\u0006\u0010%\u001a\u00020&H\u0016J\u0010\u0010.\u001a\u00020\u00142\u0006\u0010%\u001a\u00020&H\u0016J\b\u0010/\u001a\u00020\u0014H\u0016J\b\u00100\u001a\u00020\u0014H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0004\n\u0002\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0012X.¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000¨\u00062"}, hxF = {"Lcom/tencent/mm/plugin/festival/finder/FestivalFinderLiveViewCallback;", "Lcom/tencent/mm/plugin/festival/finder/FestivalFinderLiveContract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/life/UILifecycleObserver;", "pluginLayout", "Lcom/tencent/mm/plugin/festival/finder/FestivalFinderLiveVisitorPluginLayout;", EnvConsts.ACTIVITY_MANAGER_SRVNAME, "Lcom/tencent/mm/ui/MMActivity;", "lifeCycle", "Landroid/arch/lifecycle/Lifecycle;", "presenter", "Lcom/tencent/mm/plugin/festival/finder/FestivalFinderLiveContract$Presenter;", "isFromFloatBall", "", "(Lcom/tencent/mm/plugin/festival/finder/FestivalFinderLiveVisitorPluginLayout;Lcom/tencent/mm/ui/MMActivity;Landroid/arch/lifecycle/Lifecycle;Lcom/tencent/mm/plugin/festival/finder/FestivalFinderLiveContract$Presenter;Z)V", "feedChangeListener", "com/tencent/mm/plugin/festival/finder/FestivalFinderLiveViewCallback$feedChangeListener$1", "Lcom/tencent/mm/plugin/festival/finder/FestivalFinderLiveViewCallback$feedChangeListener$1;", "finderLiveData", "Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLiveData;", "activateLive", "", "isRestart", "getActivity", "getPresenter", "initView", "data", "Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLiveDataModel;", "keyboardChange", "show", "height", "", "onActivityResult", "requestCode", "resultCode", "Landroid/content/Intent;", "onBackPressed", "onCreate", "var1", "Landroid/arch/lifecycle/LifecycleOwner;", "onDestroy", "onInit", "onNewIntent", "intent", "onPause", "onResume", "onStart", "onStop", "onUninit", "startLiveVideo", "Companion", "plugin-festival_release"})
public final class FestivalFinderLiveViewCallback implements w.b, UILifecycleObserver {
    @Deprecated
    public static final a UuG = new a((byte) 0);
    private final w.a UtL;
    private final b UuC = new b(this);
    c UuD;
    final FestivalFinderLiveVisitorPluginLayout UuE;
    private final boolean UuF;
    private final MMActivity activity;
    final Lifecycle ufJ;

    static {
        AppMethodBeat.i(262589);
        AppMethodBeat.o(262589);
    }

    public FestivalFinderLiveViewCallback(FestivalFinderLiveVisitorPluginLayout festivalFinderLiveVisitorPluginLayout, MMActivity mMActivity, Lifecycle lifecycle, w.a aVar, boolean z) {
        p.h(festivalFinderLiveVisitorPluginLayout, "pluginLayout");
        p.h(mMActivity, EnvConsts.ACTIVITY_MANAGER_SRVNAME);
        p.h(aVar, "presenter");
        AppMethodBeat.i(262588);
        this.UuE = festivalFinderLiveVisitorPluginLayout;
        this.activity = mMActivity;
        this.ufJ = lifecycle;
        this.UtL = aVar;
        this.UuF = z;
        this.UuE.setPresenter(this.UtL);
        AppMethodBeat.o(262588);
    }

    public static final /* synthetic */ void c(FestivalFinderLiveViewCallback festivalFinderLiveViewCallback) {
        AppMethodBeat.i(262590);
        festivalFinderLiveViewCallback.Fi(true);
        AppMethodBeat.o(262590);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/festival/finder/FestivalFinderLiveViewCallback$Companion;", "", "()V", "TAG", "", "plugin-festival_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0002H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/festival/finder/FestivalFinderLiveViewCallback$feedChangeListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FeedUpdateEvent;", "callback", "", "event", "plugin-festival_release"})
    public static final class b extends IListener<hn> {
        final /* synthetic */ FestivalFinderLiveViewCallback UuH;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        b(FestivalFinderLiveViewCallback festivalFinderLiveViewCallback) {
            this.UuH = festivalFinderLiveViewCallback;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(hn hnVar) {
            AppMethodBeat.i(262578);
            hn hnVar2 = hnVar;
            p.h(hnVar2, "event");
            switch (hnVar2.dLW.type) {
                case 14:
                    a unused = FestivalFinderLiveViewCallback.UuG;
                    Log.i("MicroMsg.FestivalFinderLiveViewCallback", "change role live restart");
                    FestivalFinderLiveVisitorPluginLayout festivalFinderLiveVisitorPluginLayout = this.UuH.UuE;
                    if (festivalFinderLiveVisitorPluginLayout != null) {
                        i iVar = i.Uyl;
                        i.log("restartLiveRoomRelated " + festivalFinderLiveVisitorPluginLayout.getKeyStatusStr());
                        festivalFinderLiveVisitorPluginLayout.getLiveData().reset();
                        t tVar = festivalFinderLiveVisitorPluginLayout.UsO;
                        if (tVar != null) {
                            tVar.unMount();
                        }
                        x xVar = festivalFinderLiveVisitorPluginLayout.UuK;
                        if (xVar != null) {
                            xVar.unMount();
                        }
                        ab abVar = festivalFinderLiveVisitorPluginLayout.UuN;
                        if (abVar != null) {
                            abVar.unMount();
                        }
                        z zVar = festivalFinderLiveVisitorPluginLayout.Uvd;
                        if (zVar != null) {
                            zVar.unMount();
                        }
                        af afVar = festivalFinderLiveVisitorPluginLayout.UuJ;
                        if (afVar != null) {
                            afVar.unMount();
                        }
                        at atVar = at.Uuv;
                        at.a(false, (Boolean) null, Boolean.FALSE, 7);
                    }
                    FestivalFinderLiveViewCallback.c(this.UuH);
                    break;
            }
            AppMethodBeat.o(262578);
            return false;
        }
    }

    static /* synthetic */ void a(FestivalFinderLiveViewCallback festivalFinderLiveViewCallback) {
        AppMethodBeat.i(262580);
        festivalFinderLiveViewCallback.Fi(false);
        AppMethodBeat.o(262580);
    }

    private final void Fi(boolean z) {
        AppMethodBeat.i(262579);
        c cVar = this.UuD;
        if (cVar == null) {
            p.btv("finderLiveData");
        }
        if (cVar != null) {
            at atVar = at.Uuv;
            g a2 = at.a(cVar);
            if (a2 != null) {
                FestivalFinderLiveVisitorPluginLayout festivalFinderLiveVisitorPluginLayout = this.UuE;
                c cVar2 = this.UuD;
                if (cVar2 == null) {
                    p.btv("finderLiveData");
                }
                FinderBaseLivePluginLayout.bindData$default(festivalFinderLiveVisitorPluginLayout, cVar2, a2, false, 4, null);
                at atVar2 = at.Uuv;
                FestivalFinderLiveVisitorPluginLayout festivalFinderLiveVisitorPluginLayout2 = this.UuE;
                p.h(a2, "liveData");
                p.h(festivalFinderLiveVisitorPluginLayout2, "finderBaseLayout");
                Log.i("Finder.FestivalFinderLiveService", "bindCurLive " + a2 + " curLiveRoomData:" + at.ujz);
                String a3 = ((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_live_not_support_switch_video_param, "mp1718");
                p.g(a3, "MMKernel.service(IExptSe…ch_video_param, \"mp1718\")");
                if (a3 == null) {
                    t tVar = new t("null cannot be cast to non-null type java.lang.String");
                    AppMethodBeat.o(262579);
                    throw tVar;
                }
                String lowerCase = a3.toLowerCase();
                p.g(lowerCase, "(this as java.lang.String).toLowerCase()");
                at.uju = lowerCase;
                at.ujs = festivalFinderLiveVisitorPluginLayout2;
                com.tencent.mm.plugin.finder.live.model.b bVar = new com.tencent.mm.plugin.finder.live.model.b(festivalFinderLiveVisitorPluginLayout2);
                bVar.UKk = true;
                at.ujx = bVar;
                if (at.ujz == null) {
                    at.ujK = new com.tencent.mm.plugin.finder.live.model.w("heartBeatLooper", at.hIe, 2);
                    at.ujL = new com.tencent.mm.plugin.finder.live.model.w("keepLiveLooper", at.hId, 2);
                    at.ujG.alive();
                    at.hXn.alive();
                    at.f(a2);
                    at.ujA = 0;
                    at.dMz = false;
                    c.a aVar = com.tencent.mm.live.core.core.d.c.uKx;
                    if (com.tencent.mm.live.core.core.d.c.uKw == null) {
                        com.tencent.mm.live.core.core.d.c.uKw = new com.tencent.mm.live.core.core.d.c();
                    }
                    com.tencent.mm.live.core.core.d.c cVar3 = com.tencent.mm.live.core.core.d.c.uKw;
                    if (cVar3 == null) {
                        p.hyc();
                    }
                    at.hSS = cVar3;
                    Context context = MMApplicationContext.getContext();
                    p.g(context, "MMApplicationContext.getContext()");
                    FinderLiveMiniView finderLiveMiniView = new FinderLiveMiniView(context);
                    at.ujt = finderLiveMiniView;
                    finderLiveMiniView.a(at.hJe, at.ujI);
                    FinderLiveMiniView finderLiveMiniView2 = at.ujt;
                    if (finderLiveMiniView2 != null) {
                        finderLiveMiniView2.bi(a2.hwd, at.dMz);
                    }
                    com.tencent.mm.live.core.core.trtc.a aVar2 = at.hSS;
                    if (aVar2 != null) {
                        aVar2.a(at.ujt);
                    }
                    com.tencent.mm.live.core.core.trtc.a aVar3 = at.hSS;
                    if (aVar3 != null) {
                        aVar3.hAx = atVar2;
                    }
                }
                FestivalFinderLiveVisitorPluginLayout festivalFinderLiveVisitorPluginLayout3 = this.UuE;
                com.tencent.mm.plugin.finder.live.viewmodel.c cVar4 = this.UuD;
                if (cVar4 == null) {
                    p.btv("finderLiveData");
                }
                festivalFinderLiveVisitorPluginLayout3.activate(cVar4, false, this.UuF, z, 0);
                this.UuE.mount();
                AppMethodBeat.o(262579);
                return;
            }
            Log.e("MicroMsg.FestivalFinderLiveViewCallback", "initView liveData null");
            AppMethodBeat.o(262579);
            return;
        }
        AppMethodBeat.o(262579);
    }

    public final void deR() {
        AppMethodBeat.i(262581);
        Log.i("MicroMsg.FestivalFinderLiveViewCallback", "[LiveLifecycle]onUnInit ".concat(String.valueOf(this)));
        this.UuE.unMount();
        AppMethodBeat.o(262581);
    }

    @Override // com.tencent.mm.plugin.finder.life.UILifecycleObserver
    public final void onCreate(LifecycleOwner lifecycleOwner) {
        AppMethodBeat.i(262582);
        p.h(lifecycleOwner, "var1");
        Log.i("MicroMsg.FestivalFinderLiveViewCallback", "onCreate");
        h hVar = h.Uye;
        h.an(this.activity);
        com.tencent.mm.plugin.festival.model.t tVar = com.tencent.mm.plugin.festival.model.t.UyR;
        Log.i("FestivalOperationMgr", "create");
        com.tencent.mm.plugin.festival.model.t.map.clear();
        z zVar = z.Uzb;
        z.a(tVar);
        this.UuC.alive();
        AppMethodBeat.o(262582);
    }

    @Override // com.tencent.mm.plugin.finder.life.UILifecycleObserver
    public final void onStart(LifecycleOwner lifecycleOwner) {
        AppMethodBeat.i(262583);
        p.h(lifecycleOwner, "var1");
        Log.i("MicroMsg.FestivalFinderLiveViewCallback", "onStart");
        b.a aVar = com.tencent.mm.live.core.core.d.b.hCo;
        com.tencent.mm.live.core.core.d.b aEf = b.a.aEf();
        Log.i("MicroMsg.FestivalFinderLiveViewCallback", "startLiveVideo,float mode:" + aEf.hAz.isFloatMode() + ", normal mode:" + aEf.hAz.isNormalMode());
        this.UuE.start();
        AppMethodBeat.o(262583);
    }

    @Override // com.tencent.mm.plugin.finder.life.UILifecycleObserver
    public final void onResume(LifecycleOwner lifecycleOwner) {
        AppMethodBeat.i(262584);
        p.h(lifecycleOwner, "var1");
        Log.i("MicroMsg.FestivalFinderLiveViewCallback", "onResume");
        this.UuE.resume();
        AppMethodBeat.o(262584);
    }

    @Override // com.tencent.mm.plugin.finder.life.UILifecycleObserver
    public final void onPause(LifecycleOwner lifecycleOwner) {
        AppMethodBeat.i(262585);
        p.h(lifecycleOwner, "var1");
        Log.i("MicroMsg.FestivalFinderLiveViewCallback", "onPause");
        this.UuE.pause();
        AppMethodBeat.o(262585);
    }

    @Override // com.tencent.mm.plugin.finder.life.UILifecycleObserver
    public final void onStop(LifecycleOwner lifecycleOwner) {
        AppMethodBeat.i(262586);
        p.h(lifecycleOwner, "var1");
        Log.i("MicroMsg.FestivalFinderLiveViewCallback", "onStop");
        this.UuE.stop();
        AppMethodBeat.o(262586);
    }

    @Override // com.tencent.mm.plugin.finder.life.UILifecycleObserver
    public final void onDestroy(LifecycleOwner lifecycleOwner) {
        AppMethodBeat.i(262587);
        p.h(lifecycleOwner, "var1");
        this.UuC.dead();
        com.tencent.mm.plugin.festival.model.t tVar = com.tencent.mm.plugin.festival.model.t.UyR;
        Log.i("FestivalOperationMgr", "destroy");
        com.tencent.mm.plugin.festival.model.t.map.clear();
        z zVar = z.Uzb;
        z.b(tVar);
        h hVar = h.Uye;
        h.gWM();
        Log.i("MicroMsg.FestivalFinderLiveViewCallback", "onDestroy");
        AppMethodBeat.o(262587);
    }

    @Override // com.tencent.mm.plugin.finder.presenter.base.c
    public final /* bridge */ /* synthetic */ MMFragmentActivity dcl() {
        return this.activity;
    }
}

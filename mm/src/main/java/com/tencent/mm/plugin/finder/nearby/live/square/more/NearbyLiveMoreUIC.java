package com.tencent.mm.plugin.finder.nearby.live.square.more;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.nearby.live.d;
import com.tencent.mm.plugin.finder.nearby.live.e;
import com.tencent.mm.plugin.finder.report.live.c;
import com.tencent.mm.plugin.finder.report.live.k;
import com.tencent.mm.plugin.finder.report.live.s;
import com.tencent.mm.plugin.finder.ui.f;
import com.tencent.mm.plugin.finder.video.r;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderVideoRecycler;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u000b\u001a\u00020\fH\u0016J\u0006\u0010\r\u001a\u00020\u000eJ\u0006\u0010\u000f\u001a\u00020\u000eJ\u0012\u0010\u0010\u001a\u00020\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u000eH\u0016J\b\u0010\u0014\u001a\u00020\u000eH\u0016J\b\u0010\u0015\u001a\u00020\u000eH\u0016J\b\u0010\u0016\u001a\u00020\u000eH\u0016J\b\u0010\u0017\u001a\u00020\u000eH\u0016J\b\u0010\u0018\u001a\u00020\u000eH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX.¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX.¢\u0006\u0002\n\u0000¨\u0006\u001a"}, hxF = {"Lcom/tencent/mm/plugin/finder/nearby/live/square/more/NearbyLiveMoreUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", EnvConsts.ACTIVITY_MANAGER_SRVNAME, "Landroid/support/v7/app/AppCompatActivity;", "(Landroid/support/v7/app/AppCompatActivity;)V", "liveFriendsCallback", "Lcom/tencent/mm/plugin/finder/nearby/live/NearbyLiveViewCallback;", "liveFriendsPresenter", "Lcom/tencent/mm/plugin/finder/nearby/live/NearbyLivePresenter;", "livePostHelper", "Lcom/tencent/mm/plugin/finder/ui/FinderLivePostForNearby;", "getLayoutId", "", "onActionbarClick", "", "onActionbarDoubleClick", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onFinished", "onPause", "onResume", "onUserVisibleFocused", "onUserVisibleUnFocused", "Companion", "plugin-finder_release"})
public final class NearbyLiveMoreUIC extends UIComponent {
    public static final a uRN = new a((byte) 0);
    private f uRi;
    private d uRj;
    private e uRk;

    static {
        AppMethodBeat.i(249219);
        AppMethodBeat.o(249219);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Lcom/tencent/mm/plugin/finder/video/IFinderVideoView;", "invoke"})
    static final class b extends q implements kotlin.g.a.b<r, Boolean> {
        public static final b uRO = new b();

        static {
            AppMethodBeat.i(249210);
            AppMethodBeat.o(249210);
        }

        b() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ Boolean invoke(r rVar) {
            AppMethodBeat.i(249209);
            p.h(rVar, LocaleUtil.ITALIAN);
            Boolean bool = Boolean.TRUE;
            AppMethodBeat.o(249209);
            return bool;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/finder/nearby/live/square/more/NearbyLiveMoreUIC$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NearbyLiveMoreUIC(AppCompatActivity appCompatActivity) {
        super(appCompatActivity);
        p.h(appCompatActivity, EnvConsts.ACTIVITY_MANAGER_SRVNAME);
        AppMethodBeat.i(249218);
        AppMethodBeat.o(249218);
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final int getLayoutId() {
        return R.layout.bfa;
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onCreate(Bundle bundle) {
        AppMethodBeat.i(249211);
        super.onCreate(bundle);
        com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
        bbn dIx = ((FinderReporterUIC) com.tencent.mm.ui.component.a.b(getActivity()).get(FinderReporterUIC.class)).dIx();
        this.uRi = new f(getActivity());
        AppCompatActivity activity = getActivity();
        if (activity == null) {
            t tVar = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
            AppMethodBeat.o(249211);
            throw tVar;
        }
        this.uRj = new a((MMActivity) activity, dIx);
        AppCompatActivity activity2 = getActivity();
        if (activity2 == null) {
            t tVar2 = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
            AppMethodBeat.o(249211);
            throw tVar2;
        }
        MMActivity mMActivity = (MMActivity) activity2;
        d dVar = this.uRj;
        if (dVar == null) {
            p.btv("liveFriendsPresenter");
        }
        this.uRk = new b(mMActivity, dVar, getRootView(), dIx);
        d dVar2 = this.uRj;
        if (dVar2 == null) {
            p.btv("liveFriendsPresenter");
        }
        e eVar = this.uRk;
        if (eVar == null) {
            p.btv("liveFriendsCallback");
        }
        dVar2.a(eVar);
        AppMethodBeat.o(249211);
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onResume() {
        AppMethodBeat.i(249212);
        super.onResume();
        com.tencent.mm.plugin.finder.nearby.report.d dVar = com.tencent.mm.plugin.finder.nearby.report.d.uTq;
        com.tencent.mm.plugin.finder.nearby.report.d.dlB();
        Log.i("NearbyLiveMoreUIC", "onResume()");
        k kVar = k.vkd;
        e eVar = this.uRk;
        if (eVar == null) {
            p.btv("liveFriendsCallback");
        }
        k.a(eVar.getRecyclerView(), s.p.LIVE_AUDIENCE_EXPLORE_FEED_CARD, "80", c.EVENT_ON_RESUME, -100, -100);
        AppMethodBeat.o(249212);
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onPause() {
        AppMethodBeat.i(249213);
        super.onPause();
        Log.i("NearbyLiveMoreUIC", "onPause()");
        k kVar = k.vkd;
        e eVar = this.uRk;
        if (eVar == null) {
            p.btv("liveFriendsCallback");
        }
        k.a(eVar.getRecyclerView(), s.p.LIVE_AUDIENCE_EXPLORE_FEED_CARD, "80", c.EVENT_ON_PAUSE, -100, -100);
        AppMethodBeat.o(249213);
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onUserVisibleFocused() {
        AppMethodBeat.i(249214);
        super.onUserVisibleFocused();
        com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
        ((FinderVideoRecycler) com.tencent.mm.ui.component.a.bi(PluginFinder.class).get(FinderVideoRecycler.class)).J(b.uRO);
        d dVar = this.uRj;
        if (dVar == null) {
            p.btv("liveFriendsPresenter");
        }
        if (dVar != null) {
            dVar.onUserVisibleFocused();
            AppMethodBeat.o(249214);
            return;
        }
        AppMethodBeat.o(249214);
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onUserVisibleUnFocused() {
        AppMethodBeat.i(249215);
        super.onUserVisibleUnFocused();
        if (this.uRj == null) {
            p.btv("liveFriendsPresenter");
        }
        AppMethodBeat.o(249215);
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onFinished() {
        AppMethodBeat.i(249216);
        super.onFinished();
        d dVar = this.uRj;
        if (dVar == null) {
            p.btv("liveFriendsPresenter");
        }
        if (dVar != null) {
            dVar.onFinishing();
            AppMethodBeat.o(249216);
            return;
        }
        AppMethodBeat.o(249216);
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onDestroy() {
        AppMethodBeat.i(249217);
        super.onDestroy();
        d dVar = this.uRj;
        if (dVar == null) {
            p.btv("liveFriendsPresenter");
        }
        if (dVar != null) {
            dVar.onDetach();
            AppMethodBeat.o(249217);
            return;
        }
        AppMethodBeat.o(249217);
    }
}

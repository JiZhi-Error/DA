package com.tencent.mm.plugin.finder.nearby.live.square.tab;

import android.support.v4.app.Fragment;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.report.live.c;
import com.tencent.mm.plugin.finder.report.live.k;
import com.tencent.mm.plugin.finder.report.live.s;
import com.tencent.mm.plugin.finder.video.r;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderVideoRecycler;
import com.tencent.mm.protocal.protobuf.axj;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.component.UIComponent;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u0004\u0018\u00010\nJ\u0006\u0010\u000e\u001a\u00020\u000fJ\u0006\u0010\u0010\u001a\u00020\u000fJ\u0012\u0010\u0011\u001a\u00020\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u000fH\u0016J\b\u0010\u0015\u001a\u00020\u000fH\u0016J\b\u0010\u0016\u001a\u00020\u000fH\u0016J\b\u0010\u0017\u001a\u00020\u000fH\u0016J\b\u0010\u0018\u001a\u00020\u000fH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX.¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a"}, hxF = {"Lcom/tencent/mm/plugin/finder/nearby/live/square/tab/NearbyLiveSquareTabUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "fragment", "Landroid/support/v4/app/Fragment;", "(Landroid/support/v4/app/Fragment;)V", "liveFriendsCallback", "Lcom/tencent/mm/plugin/finder/nearby/live/square/tab/NearbyLiveSquareTabViewCallback;", "liveFriendsPresenter", "Lcom/tencent/mm/plugin/finder/nearby/live/square/tab/NearbyLiveSquareTabPresenter;", "tabInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveTabInfo;", "getLayoutId", "", "getTabInfo", "onActionbarClick", "", "onActionbarDoubleClick", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPause", "onResume", "onUserVisibleFocused", "onUserVisibleUnFocused", "Companion", "plugin-finder_release"})
public final class NearbyLiveSquareTabUIC extends UIComponent {
    public static final a uRT = new a((byte) 0);
    private axj uQK;
    b uRR;
    private c uRS;

    static {
        AppMethodBeat.i(249250);
        AppMethodBeat.o(249250);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Lcom/tencent/mm/plugin/finder/video/IFinderVideoView;", "invoke"})
    static final class b extends q implements kotlin.g.a.b<r, Boolean> {
        public static final b uRU = new b();

        static {
            AppMethodBeat.i(249242);
            AppMethodBeat.o(249242);
        }

        b() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ Boolean invoke(r rVar) {
            AppMethodBeat.i(249241);
            p.h(rVar, LocaleUtil.ITALIAN);
            Boolean bool = Boolean.TRUE;
            AppMethodBeat.o(249241);
            return bool;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/finder/nearby/live/square/tab/NearbyLiveSquareTabUIC$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NearbyLiveSquareTabUIC(Fragment fragment) {
        super(fragment);
        p.h(fragment, "fragment");
        AppMethodBeat.i(249249);
        AppMethodBeat.o(249249);
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final int getLayoutId() {
        return R.layout.bfd;
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x008a  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0099  */
    @Override // com.tencent.mm.ui.component.UIComponent
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onCreate(android.os.Bundle r7) {
        /*
        // Method dump skipped, instructions count: 245
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.nearby.live.square.tab.NearbyLiveSquareTabUIC.onCreate(android.os.Bundle):void");
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onResume() {
        AppMethodBeat.i(249244);
        super.onResume();
        StringBuilder sb = new StringBuilder("onResume() tab:");
        axj axj = this.uQK;
        Log.i("NearbyLiveSquareTabUIC", sb.append(axj != null ? axj.LHR : null).toString());
        k kVar = k.vkd;
        c cVar = this.uRS;
        if (cVar == null) {
            p.btv("liveFriendsCallback");
        }
        k.a(cVar.getRecyclerView(), s.p.LIVE_AUDIENCE_EXPLORE_FEED_CARD, "80", c.EVENT_ON_RESUME, -100, -100);
        AppMethodBeat.o(249244);
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onPause() {
        AppMethodBeat.i(249245);
        super.onPause();
        StringBuilder sb = new StringBuilder("onPause() tab:");
        axj axj = this.uQK;
        Log.i("NearbyLiveSquareTabUIC", sb.append(axj != null ? axj.LHR : null).toString());
        k kVar = k.vkd;
        c cVar = this.uRS;
        if (cVar == null) {
            p.btv("liveFriendsCallback");
        }
        k.a(cVar.getRecyclerView(), s.p.LIVE_AUDIENCE_EXPLORE_FEED_CARD, "80", c.EVENT_ON_PAUSE, -100, -100);
        AppMethodBeat.o(249245);
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onUserVisibleFocused() {
        AppMethodBeat.i(249246);
        super.onUserVisibleFocused();
        com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
        ((FinderVideoRecycler) com.tencent.mm.ui.component.a.bi(PluginFinder.class).get(FinderVideoRecycler.class)).J(b.uRU);
        b bVar = this.uRR;
        if (bVar == null) {
            p.btv("liveFriendsPresenter");
        }
        if (bVar != null) {
            bVar.onUserVisibleFocused();
            AppMethodBeat.o(249246);
            return;
        }
        AppMethodBeat.o(249246);
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onUserVisibleUnFocused() {
        AppMethodBeat.i(249247);
        super.onUserVisibleUnFocused();
        if (this.uRR == null) {
            p.btv("liveFriendsPresenter");
        }
        AppMethodBeat.o(249247);
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onDestroy() {
        AppMethodBeat.i(249248);
        super.onDestroy();
        StringBuilder sb = new StringBuilder("onDestroy() tab:");
        axj axj = this.uQK;
        Log.i("NearbyLiveSquareTabUIC", sb.append(axj != null ? axj.LHR : null).toString());
        b bVar = this.uRR;
        if (bVar == null) {
            p.btv("liveFriendsPresenter");
        }
        if (bVar != null) {
            bVar.onFinishing();
        }
        b bVar2 = this.uRR;
        if (bVar2 == null) {
            p.btv("liveFriendsPresenter");
        }
        if (bVar2 != null) {
            bVar2.onDetach();
            AppMethodBeat.o(249248);
            return;
        }
        AppMethodBeat.o(249248);
    }
}

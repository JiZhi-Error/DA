package com.tencent.mm.plugin.finder.nearby.live.square;

import android.support.v4.app.FragmentActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.finder.nearby.NearbyHomeUIC;
import com.tencent.mm.plugin.finder.nearby.base.AbsNearByFragment;
import com.tencent.mm.plugin.finder.nearby.live.square.more.NearbyLiveSquareMoreFragment;
import com.tencent.mm.plugin.finder.nearby.report.d;
import com.tencent.mm.plugin.finder.report.live.k;
import com.tencent.mm.plugin.finder.report.live.s;
import com.tencent.mm.plugin.finder.ui.f;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.component.a;
import java.util.HashMap;
import java.util.Set;
import kotlin.a.ak;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u0007\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0006H\u0016J\u0018\u0010\t\u001a\u0012\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\f0\u000b\u0018\u00010\nH\u0016J\b\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u000eH\u0016J\b\u0010\u0010\u001a\u00020\u000eH\u0016J\b\u0010\u0011\u001a\u00020\u000eH\u0016J\b\u0010\u0012\u001a\u00020\u000eH\u0016¨\u0006\u0013"}, hxF = {"Lcom/tencent/mm/plugin/finder/nearby/live/square/NearbyLiveSquareFragment;", "Lcom/tencent/mm/plugin/finder/nearby/base/AbsNearByFragment;", "()V", "getClickTabContextId", "", "getCommentScene", "", "getPageName", "getReportType", "importUIComponents", "", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "onMenuClick", "", "onPause", "onResume", "onUserVisibleFocused", "onUserVisibleUnFocused", "plugin-finder_release"})
public class NearbyLiveSquareFragment extends AbsNearByFragment {
    private HashMap _$_findViewCache;

    @Override // com.tencent.mm.plugin.finder.nearby.base.AbsNearByFragment, com.tencent.mm.ui.component.UIComponentFragment
    public void _$_clearFindViewByIdCache() {
        AppMethodBeat.i(249154);
        if (this._$_findViewCache != null) {
            this._$_findViewCache.clear();
        }
        AppMethodBeat.o(249154);
    }

    @Override // com.tencent.mm.plugin.finder.nearby.base.AbsNearByFragment, com.tencent.mm.ui.component.UIComponentFragment, android.support.v4.app.Fragment
    public /* synthetic */ void onDestroyView() {
        AppMethodBeat.i(249155);
        super.onDestroyView();
        _$_clearFindViewByIdCache();
        AppMethodBeat.o(249155);
    }

    public NearbyLiveSquareFragment() {
        super(R.string.fb6, 1001);
    }

    @Override // com.tencent.mm.ui.component.UIComponentFragment
    public final Set<Class<? extends UIComponent>> importUIComponents() {
        AppMethodBeat.i(249148);
        Set<Class<? extends UIComponent>> of = ak.setOf((Object[]) new Class[]{FinderReporterUIC.class, NearbyLiveSquareGuideUIC.class, NearbyLiveSquareTabLayoutUIC.class, NearbyLiveSquareUIC.class});
        AppMethodBeat.o(249148);
        return of;
    }

    @Override // com.tencent.mm.plugin.finder.nearby.base.AbsNearByFragment
    public final void dlk() {
        AppMethodBeat.i(249149);
        super.dlk();
        f fVar = ((NearbyLiveSquareUIC) component(NearbyLiveSquareUIC.class)).uRi;
        if (fVar == null) {
            p.btv("livePostHelper");
        }
        fVar.prepare();
        k kVar = k.vkd;
        k.a(s.af.ENTER_PAGE_EXPLORE);
        AppMethodBeat.o(249149);
    }

    @Override // com.tencent.mm.ui.component.UIComponentFragment
    public final void onUserVisibleFocused() {
        AppMethodBeat.i(249150);
        super.onUserVisibleFocused();
        if (getActivity() != null) {
            d dVar = d.uTq;
            d.b(((NearbyLiveSquareUIC) component(NearbyLiveSquareUIC.class)).dlj());
        }
        AppMethodBeat.o(249150);
    }

    @Override // com.tencent.mm.plugin.finder.nearby.base.AbsNearByFragment, com.tencent.mm.ui.component.UIComponentFragment
    public final void onUserVisibleUnFocused() {
        AppMethodBeat.i(249151);
        super.onUserVisibleUnFocused();
        d dVar = d.uTq;
        d.c(((NearbyLiveSquareUIC) component(NearbyLiveSquareUIC.class)).dlj());
        AppMethodBeat.o(249151);
    }

    @Override // com.tencent.mm.ui.component.UIComponentFragment, android.support.v4.app.Fragment
    public void onPause() {
        AppMethodBeat.i(249152);
        super.onPause();
        Log.i("NearbyLiveSquareUIC", "onPause()");
        FragmentActivity activity = getActivity();
        if (activity != null) {
            a aVar = a.PRN;
            p.g(activity, LocaleUtil.ITALIAN);
            if ((((NearbyHomeUIC) a.ko(activity).get(NearbyHomeUIC.class)).dlj() instanceof NearbyLiveSquareFragment) || (this instanceof NearbyLiveSquareMoreFragment)) {
                d dVar = d.uTq;
                d.c(((NearbyLiveSquareUIC) component(NearbyLiveSquareUIC.class)).dlj());
            }
            AppMethodBeat.o(249152);
            return;
        }
        AppMethodBeat.o(249152);
    }

    @Override // com.tencent.mm.plugin.finder.nearby.base.AbsNearByFragment, com.tencent.mm.ui.component.UIComponentFragment, android.support.v4.app.Fragment
    public void onResume() {
        AppMethodBeat.i(249153);
        super.onResume();
        Log.i("NearbyLiveSquareUIC", "onResume()");
        d dVar = d.uTq;
        d.dlB();
        AppMethodBeat.o(249153);
    }

    @Override // com.tencent.mm.plugin.finder.nearby.base.AbsNearByFragment
    public int getCommentScene() {
        return 94;
    }

    @Override // com.tencent.mm.plugin.finder.nearby.base.AbsNearByFragment
    public int ddN() {
        return 3;
    }

    @Override // com.tencent.mm.plugin.finder.nearby.base.AbsNearByFragment
    public String ack() {
        return "";
    }

    @Override // com.tencent.mm.plugin.finder.nearby.base.AbsNearByFragment
    public final String afB() {
        return "";
    }
}

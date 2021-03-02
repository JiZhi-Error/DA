package com.tencent.mm.plugin.finder.nearby.live.square.tab;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.finder.nearby.base.AbsNearByFragment;
import com.tencent.mm.plugin.finder.nearby.report.d;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.protocal.protobuf.axj;
import com.tencent.mm.ui.component.UIComponent;
import java.util.HashMap;
import java.util.Set;
import kotlin.a.ak;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\nH\u0016J\b\u0010\u000e\u001a\u00020\fH\u0016J\u0018\u0010\u000f\u001a\u0012\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00120\u0011\u0018\u00010\u0010H\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0014H\u0016J&\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\b\u0010\u001e\u001a\u00020\u0014H\u0016J\b\u0010\u001f\u001a\u00020\u0014H\u0016R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006 "}, hxF = {"Lcom/tencent/mm/plugin/finder/nearby/live/square/tab/NearbyLiveSquareTabFragment;", "Lcom/tencent/mm/plugin/finder/nearby/base/AbsNearByFragment;", "()V", "tabInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveTabInfo;", "getTabInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderLiveTabInfo;", "setTabInfo", "(Lcom/tencent/mm/protocal/protobuf/FinderLiveTabInfo;)V", "getClickTabContextId", "", "getCommentScene", "", "getPageName", "getReportType", "importUIComponents", "", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "onActionbarClick", "", "onActionbarDoubleClick", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onUserVisibleFocused", "onUserVisibleUnFocused", "plugin-finder_release"})
public final class NearbyLiveSquareTabFragment extends AbsNearByFragment {
    private HashMap _$_findViewCache;
    public axj uQK;

    @Override // com.tencent.mm.plugin.finder.nearby.base.AbsNearByFragment, com.tencent.mm.ui.component.UIComponentFragment
    public final void _$_clearFindViewByIdCache() {
        AppMethodBeat.i(249233);
        if (this._$_findViewCache != null) {
            this._$_findViewCache.clear();
        }
        AppMethodBeat.o(249233);
    }

    @Override // com.tencent.mm.plugin.finder.nearby.base.AbsNearByFragment, com.tencent.mm.ui.component.UIComponentFragment, android.support.v4.app.Fragment
    public final /* synthetic */ void onDestroyView() {
        AppMethodBeat.i(249234);
        super.onDestroyView();
        _$_clearFindViewByIdCache();
        AppMethodBeat.o(249234);
    }

    public NearbyLiveSquareTabFragment() {
        super(R.string.fb6, 1005);
    }

    @Override // com.tencent.mm.ui.component.UIComponentFragment
    public final Set<Class<? extends UIComponent>> importUIComponents() {
        AppMethodBeat.i(249225);
        Set<Class<? extends UIComponent>> of = ak.setOf((Object[]) new Class[]{FinderReporterUIC.class, NearbyLiveSquareTabUIC.class});
        AppMethodBeat.o(249225);
        return of;
    }

    @Override // com.tencent.mm.plugin.finder.nearby.base.AbsNearByFragment, com.tencent.mm.ui.component.UIComponentFragment, android.support.v4.app.Fragment
    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        AppMethodBeat.i(249226);
        p.h(layoutInflater, "inflater");
        View onCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
        Bundle arguments = getArguments();
        if (arguments != null) {
            ((FinderReporterUIC) component(FinderReporterUIC.class)).tCE = arguments.getInt("key_comment_scene");
        }
        AppMethodBeat.o(249226);
        return onCreateView;
    }

    @Override // com.tencent.mm.ui.component.UIComponentFragment
    public final void onUserVisibleFocused() {
        AppMethodBeat.i(249227);
        super.onUserVisibleFocused();
        d dVar = d.uTq;
        d.b(this);
        AppMethodBeat.o(249227);
    }

    @Override // com.tencent.mm.plugin.finder.nearby.base.AbsNearByFragment, com.tencent.mm.ui.component.UIComponentFragment
    public final void onUserVisibleUnFocused() {
        AppMethodBeat.i(249228);
        super.onUserVisibleUnFocused();
        d dVar = d.uTq;
        d.c(this);
        AppMethodBeat.o(249228);
    }

    @Override // com.tencent.mm.plugin.finder.nearby.base.AbsNearByFragment
    public final void dll() {
        AppMethodBeat.i(249229);
        super.dll();
        b bVar = ((NearbyLiveSquareTabUIC) component(NearbyLiveSquareTabUIC.class)).uRR;
        if (bVar == null) {
            p.btv("liveFriendsPresenter");
        }
        if (bVar != null) {
            bVar.onActionbarClick(false);
            AppMethodBeat.o(249229);
            return;
        }
        AppMethodBeat.o(249229);
    }

    @Override // com.tencent.mm.plugin.finder.nearby.base.AbsNearByFragment
    public final void dlm() {
        AppMethodBeat.i(249230);
        super.dlm();
        b bVar = ((NearbyLiveSquareTabUIC) component(NearbyLiveSquareTabUIC.class)).uRR;
        if (bVar == null) {
            p.btv("liveFriendsPresenter");
        }
        if (bVar != null) {
            bVar.onActionbarClick(true);
            AppMethodBeat.o(249230);
            return;
        }
        AppMethodBeat.o(249230);
    }

    @Override // com.tencent.mm.plugin.finder.nearby.base.AbsNearByFragment
    public final int getCommentScene() {
        AppMethodBeat.i(249231);
        int i2 = ((FinderReporterUIC) component(FinderReporterUIC.class)).tCE;
        AppMethodBeat.o(249231);
        return i2;
    }

    @Override // com.tencent.mm.plugin.finder.nearby.base.AbsNearByFragment
    public final int ddN() {
        return 3;
    }

    @Override // com.tencent.mm.plugin.finder.nearby.base.AbsNearByFragment
    public final String ack() {
        return "1001";
    }

    @Override // com.tencent.mm.plugin.finder.nearby.base.AbsNearByFragment
    public final String afB() {
        AppMethodBeat.i(249232);
        StringBuilder append = new StringBuilder().append(getCommentScene()).append('-');
        axj axj = this.uQK;
        String sb = append.append(axj != null ? Integer.valueOf(axj.LHQ) : "").toString();
        AppMethodBeat.o(249232);
        return sb;
    }
}

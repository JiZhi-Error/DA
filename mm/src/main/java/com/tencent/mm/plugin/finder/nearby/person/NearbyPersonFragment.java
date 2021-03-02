package com.tencent.mm.plugin.finder.nearby.person;

import android.content.Context;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.b.a;
import com.tencent.mm.plugin.finder.nearby.base.AbsNearByFragment;
import com.tencent.mm.plugin.finder.nearby.person.NearbyPersonV1UIC;
import com.tencent.mm.plugin.finder.nearby.report.b;
import com.tencent.mm.plugin.finder.nearby.report.d;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.widget.a.e;
import java.util.HashMap;
import java.util.Set;
import kotlin.a.ak;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u0007\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0006H\u0016J\u0018\u0010\t\u001a\u0012\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\f0\u000b\u0018\u00010\nH\u0016J\b\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u000eH\u0016J\b\u0010\u0010\u001a\u00020\u000eH\u0016J\b\u0010\u0011\u001a\u00020\u000eH\u0016J\b\u0010\u0012\u001a\u00020\u000eH\u0016¨\u0006\u0013"}, hxF = {"Lcom/tencent/mm/plugin/finder/nearby/person/NearbyPersonFragment;", "Lcom/tencent/mm/plugin/finder/nearby/base/AbsNearByFragment;", "()V", "getClickTabContextId", "", "getCommentScene", "", "getPageName", "getReportType", "importUIComponents", "", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "onActionbarClick", "", "onActionbarDoubleClick", "onMenuClick", "onUserVisibleFocused", "onUserVisibleUnFocused", "plugin-finder_release"})
public final class NearbyPersonFragment extends AbsNearByFragment {
    private HashMap _$_findViewCache;

    @Override // com.tencent.mm.plugin.finder.nearby.base.AbsNearByFragment, com.tencent.mm.ui.component.UIComponentFragment
    public final void _$_clearFindViewByIdCache() {
        AppMethodBeat.i(249258);
        if (this._$_findViewCache != null) {
            this._$_findViewCache.clear();
        }
        AppMethodBeat.o(249258);
    }

    @Override // com.tencent.mm.plugin.finder.nearby.base.AbsNearByFragment, com.tencent.mm.ui.component.UIComponentFragment, android.support.v4.app.Fragment
    public final /* synthetic */ void onDestroyView() {
        AppMethodBeat.i(249259);
        super.onDestroyView();
        _$_clearFindViewByIdCache();
        AppMethodBeat.o(249259);
    }

    public NearbyPersonFragment() {
        super(R.string.fb7, 1003);
    }

    @Override // com.tencent.mm.ui.component.UIComponentFragment
    public final Set<Class<? extends UIComponent>> importUIComponents() {
        AppMethodBeat.i(249252);
        Set<Class<? extends UIComponent>> of = ak.setOf(NearbyPersonV1UIC.class);
        AppMethodBeat.o(249252);
        return of;
    }

    @Override // com.tencent.mm.plugin.finder.nearby.base.AbsNearByFragment
    public final void dll() {
        AppMethodBeat.i(249253);
        super.dll();
        if (getActivity() == null) {
            Log.w("MicroMsg.UIComponentFragment", "onActionbarClick()");
            AppMethodBeat.o(249253);
            return;
        }
        component(NearbyPersonV1UIC.class);
        AppMethodBeat.o(249253);
    }

    @Override // com.tencent.mm.plugin.finder.nearby.base.AbsNearByFragment
    public final void dlm() {
        AppMethodBeat.i(249254);
        super.dlm();
        if (getActivity() == null) {
            Log.w("MicroMsg.UIComponentFragment", "onActionbarDoubleClick()");
            AppMethodBeat.o(249254);
            return;
        }
        a bl = new a().bl(((NearbyPersonV1UIC) component(NearbyPersonV1UIC.class)).khv);
        Object obj = new Object();
        com.tencent.mm.hellhoundlib.a.a.a(obj, bl.axQ(), "com/tencent/mm/plugin/finder/nearby/person/NearbyPersonV1UIC", "onActionbarDoubleClick", "()V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
        BackwardSupportUtil.SmoothScrollFactory.scrollToTop((ListView) bl.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(obj, "com/tencent/mm/plugin/finder/nearby/person/NearbyPersonV1UIC", "onActionbarDoubleClick", "()V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
        AppMethodBeat.o(249254);
    }

    @Override // com.tencent.mm.plugin.finder.nearby.base.AbsNearByFragment
    public final void dlk() {
        AppMethodBeat.i(249255);
        super.dlk();
        if (getActivity() == null) {
            Log.w("MicroMsg.UIComponentFragment", "onMenuClick()");
            AppMethodBeat.o(249255);
            return;
        }
        NearbyPersonV1UIC nearbyPersonV1UIC = (NearbyPersonV1UIC) component(NearbyPersonV1UIC.class);
        nearbyPersonV1UIC.uSx = new e((Context) nearbyPersonV1UIC.getActivity(), 1, false);
        e eVar = nearbyPersonV1UIC.uSx;
        if (eVar != null) {
            eVar.a(NearbyPersonV1UIC.s.uSV);
        }
        e eVar2 = nearbyPersonV1UIC.uSx;
        if (eVar2 != null) {
            eVar2.a(new NearbyPersonV1UIC.t(nearbyPersonV1UIC));
        }
        e eVar3 = nearbyPersonV1UIC.uSx;
        if (eVar3 != null) {
            eVar3.a(NearbyPersonV1UIC.u.uSW);
        }
        e eVar4 = nearbyPersonV1UIC.uSx;
        if (eVar4 != null) {
            eVar4.b(NearbyPersonV1UIC.v.uSX);
        }
        e eVar5 = nearbyPersonV1UIC.uSx;
        if (eVar5 != null) {
            eVar5.dGm();
        }
        b bVar = b.uSZ;
        b.a("", 0, "", "", "", 0, 3, 3);
        AppMethodBeat.o(249255);
    }

    @Override // com.tencent.mm.ui.component.UIComponentFragment
    public final void onUserVisibleFocused() {
        AppMethodBeat.i(249256);
        super.onUserVisibleFocused();
        d dVar = d.uTq;
        d.b(this);
        AppMethodBeat.o(249256);
    }

    @Override // com.tencent.mm.plugin.finder.nearby.base.AbsNearByFragment, com.tencent.mm.ui.component.UIComponentFragment
    public final void onUserVisibleUnFocused() {
        AppMethodBeat.i(249257);
        super.onUserVisibleUnFocused();
        d dVar = d.uTq;
        d.c(this);
        AppMethodBeat.o(249257);
    }

    @Override // com.tencent.mm.plugin.finder.nearby.base.AbsNearByFragment
    public final int getCommentScene() {
        return 77;
    }

    @Override // com.tencent.mm.plugin.finder.nearby.base.AbsNearByFragment
    public final int ddN() {
        return 0;
    }

    @Override // com.tencent.mm.plugin.finder.nearby.base.AbsNearByFragment
    public final String ack() {
        return "1003";
    }

    @Override // com.tencent.mm.plugin.finder.nearby.base.AbsNearByFragment
    public final String afB() {
        return "77-1003";
    }
}

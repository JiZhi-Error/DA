package com.tencent.mm.plugin.finder.activity.fragment;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.activity.uic.FinderActivityContentUIC;
import com.tencent.mm.plugin.finder.ui.fragment.FinderHomeTabFragment;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.component.a;
import java.util.HashMap;
import java.util.Set;
import kotlin.a.ak;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0005\u001a\u00020\u0006J\u0018\u0010\u0007\u001a\u0012\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\n0\t\u0018\u00010\bH\u0016J\u0012\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\b\u0010\u000f\u001a\u00020\fH\u0016J\b\u0010\u0010\u001a\u00020\fH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0011"}, hxF = {"Lcom/tencent/mm/plugin/finder/activity/fragment/FinderActivityFragment;", "Lcom/tencent/mm/plugin/finder/ui/fragment/FinderHomeTabFragment;", "()V", "isFirst", "", "getCommentScene", "", "importUIComponents", "", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onResume", "onUserVisibleFocused", "plugin-finder_release"})
public final class FinderActivityFragment extends FinderHomeTabFragment {
    private HashMap _$_findViewCache;
    private boolean isFirst = true;

    @Override // com.tencent.mm.plugin.finder.ui.fragment.FinderHomeTabFragment, com.tencent.mm.ui.component.UIComponentFragment
    public final void _$_clearFindViewByIdCache() {
        AppMethodBeat.i(242006);
        if (this._$_findViewCache != null) {
            this._$_findViewCache.clear();
        }
        AppMethodBeat.o(242006);
    }

    @Override // com.tencent.mm.plugin.finder.ui.fragment.FinderHomeTabFragment, com.tencent.mm.ui.component.UIComponentFragment, android.support.v4.app.Fragment
    public final /* synthetic */ void onDestroyView() {
        AppMethodBeat.i(242007);
        super.onDestroyView();
        _$_clearFindViewByIdCache();
        AppMethodBeat.o(242007);
    }

    @Override // com.tencent.mm.ui.component.UIComponentFragment
    public final Set<Class<? extends UIComponent>> importUIComponents() {
        AppMethodBeat.i(242005);
        Set<Class<? extends UIComponent>> of = ak.setOf((Object[]) new Class[]{FinderReporterUIC.class, FinderActivityContentUIC.class});
        AppMethodBeat.o(242005);
        return of;
    }

    @Override // android.support.v4.app.Fragment
    public final void onCreate(Bundle bundle) {
        AppMethodBeat.i(260070);
        super.onCreate(bundle);
        if (this.dLS == 1) {
            a aVar = a.PRN;
            ((FinderReporterUIC) a.of(this).get(FinderReporterUIC.class)).UVO = true;
        }
        AppMethodBeat.o(260070);
    }

    @Override // com.tencent.mm.ui.component.UIComponentFragment, android.support.v4.app.Fragment
    public final void onResume() {
        AppMethodBeat.i(260071);
        super.onResume();
        AppMethodBeat.o(260071);
    }

    @Override // com.tencent.mm.ui.component.UIComponentFragment
    public final void onUserVisibleFocused() {
        AppMethodBeat.i(260072);
        if (this.isFirst) {
            if (this.dLS == 1) {
                a aVar = a.PRN;
                ((FinderReporterUIC) a.of(this).get(FinderReporterUIC.class)).UVO = false;
            }
            this.isFirst = false;
        }
        super.onUserVisibleFocused();
        AppMethodBeat.o(260072);
    }
}

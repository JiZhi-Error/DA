package com.tencent.mm.plugin.finder.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderNotifyUIC;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.component.UIComponent;
import java.util.HashMap;
import java.util.Set;
import kotlin.a.ak;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u0012\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u0005\u0018\u00010\u0004H\u0016J\u0012\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J&\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\u001a\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\f2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016¨\u0006\u0014"}, hxF = {"Lcom/tencent/mm/plugin/finder/ui/fragment/FinderNotifyFragment;", "Lcom/tencent/mm/plugin/finder/ui/fragment/FinderHomeTabFragment;", "()V", "importUIComponents", "", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "Companion", "plugin-finder_release"})
public final class FinderNotifyFragment extends FinderHomeTabFragment {
    private static final String TAG = TAG;
    public static final a vQQ = new a((byte) 0);
    private HashMap _$_findViewCache;

    @Override // com.tencent.mm.plugin.finder.ui.fragment.FinderHomeTabFragment, com.tencent.mm.ui.component.UIComponentFragment
    public final void _$_clearFindViewByIdCache() {
        AppMethodBeat.i(252937);
        if (this._$_findViewCache != null) {
            this._$_findViewCache.clear();
        }
        AppMethodBeat.o(252937);
    }

    @Override // com.tencent.mm.plugin.finder.ui.fragment.FinderHomeTabFragment, com.tencent.mm.ui.component.UIComponentFragment, android.support.v4.app.Fragment
    public final /* synthetic */ void onDestroyView() {
        AppMethodBeat.i(252938);
        super.onDestroyView();
        _$_clearFindViewByIdCache();
        AppMethodBeat.o(252938);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/finder/ui/fragment/FinderNotifyFragment$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(252936);
        AppMethodBeat.o(252936);
    }

    @Override // com.tencent.mm.ui.component.UIComponentFragment
    public final Set<Class<? extends UIComponent>> importUIComponents() {
        AppMethodBeat.i(252932);
        Set<Class<? extends UIComponent>> of = ak.setOf(FinderNotifyUIC.class);
        AppMethodBeat.o(252932);
        return of;
    }

    @Override // android.support.v4.app.Fragment
    public final void onCreate(Bundle bundle) {
        AppMethodBeat.i(252933);
        super.onCreate(bundle);
        Log.i(TAG, "index:" + this.dLS);
        com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
        ((FinderNotifyUIC) com.tencent.mm.ui.component.a.of(this).get(FinderNotifyUIC.class)).index = this.dLS;
        AppMethodBeat.o(252933);
    }

    @Override // com.tencent.mm.ui.component.UIComponentFragment, android.support.v4.app.Fragment
    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        AppMethodBeat.i(252934);
        p.h(layoutInflater, "inflater");
        Log.i(TAG, " onCreateView");
        View onCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
        AppMethodBeat.o(252934);
        return onCreateView;
    }

    @Override // android.support.v4.app.Fragment
    public final void onViewCreated(View view, Bundle bundle) {
        AppMethodBeat.i(252935);
        p.h(view, "view");
        Log.i(TAG, "onViewCreated");
        super.onViewCreated(view, bundle);
        AppMethodBeat.o(252935);
    }
}

package com.tencent.mm.plugin.finder.ui.sample;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.finder.ui.MMFinderUI;
import com.tencent.mm.plugin.finder.ui.fragment.FinderHomeTabFragment;
import com.tencent.mm.plugin.finder.view.tabcomp.FinderTabProvider;
import com.tencent.mm.plugin.finder.view.tabcomp.IFinderTabProvider;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderTabUIC;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import java.util.HashMap;
import java.util.Set;
import kotlin.a.ak;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \f2\u00020\u0001:\u0004\f\r\u000e\u000fB\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u0012\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u0005\u0018\u00010\u0004H\u0016J\u0012\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\b\u0010\u000b\u001a\u00020\bH\u0002¨\u0006\u0010"}, hxF = {"Lcom/tencent/mm/plugin/finder/ui/sample/FinderSampleTabUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "()V", "importUIComponents", "", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "selectTab", "Companion", "FinderSampleTabFragment", "FinderSampleTabFragmentUIC", "FinderSampleTabUIC", "plugin-finder_release"})
public final class FinderSampleTabUI extends MMFinderUI {
    public static final a vRF = new a((byte) 0);
    private HashMap _$_findViewCache;

    static {
        AppMethodBeat.i(253040);
        AppMethodBeat.o(253040);
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity
    public final void _$_clearFindViewByIdCache() {
        AppMethodBeat.i(253042);
        if (this._$_findViewCache != null) {
            this._$_findViewCache.clear();
        }
        AppMethodBeat.o(253042);
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity
    public final View _$_findCachedViewById(int i2) {
        AppMethodBeat.i(253041);
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i2));
        if (view == null) {
            view = findViewById(i2);
            this._$_findViewCache.put(Integer.valueOf(i2), view);
        }
        AppMethodBeat.o(253041);
        return view;
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/finder/ui/sample/FinderSampleTabUI$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMFragmentActivity
    public final Set<Class<? extends UIComponent>> importUIComponents() {
        AppMethodBeat.i(253038);
        Set<Class<? extends UIComponent>> of = ak.setOf(FinderSampleTabUIC.class);
        AppMethodBeat.o(253038);
        return of;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onCreate(Bundle bundle) {
        AppMethodBeat.i(253039);
        super.onCreate(bundle);
        com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
        ((FinderSampleTabUIC) com.tencent.mm.ui.component.a.b(this).get(FinderSampleTabUIC.class)).aw(1, false);
        AppMethodBeat.o(253039);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\u0012\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016¨\u0006\u000b"}, hxF = {"Lcom/tencent/mm/plugin/finder/ui/sample/FinderSampleTabUI$FinderSampleTabUIC;", "Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderTabUIC;", EnvConsts.ACTIVITY_MANAGER_SRVNAME, "Lcom/tencent/mm/ui/MMActivity;", "(Lcom/tencent/mm/ui/MMActivity;)V", "generateProvider", "Lcom/tencent/mm/plugin/finder/view/tabcomp/IFinderTabProvider;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "plugin-finder_release"})
    public static final class FinderSampleTabUIC extends FinderTabUIC {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public FinderSampleTabUIC(MMActivity mMActivity) {
            super(mMActivity);
            p.h(mMActivity, EnvConsts.ACTIVITY_MANAGER_SRVNAME);
            AppMethodBeat.i(253037);
            Log.i("Finder.FinderTabUIC", "FinderBizTabUIC init cons");
            AppMethodBeat.o(253037);
        }

        @Override // com.tencent.mm.plugin.finder.viewmodel.component.FinderTabUIC, com.tencent.mm.ui.component.UIComponent
        public final void onCreate(Bundle bundle) {
            AppMethodBeat.i(253035);
            super.onCreate(bundle);
            ActionBar supportActionBar = getActivity().getSupportActionBar();
            if (supportActionBar != null) {
                supportActionBar.hide();
                AppMethodBeat.o(253035);
                return;
            }
            AppMethodBeat.o(253035);
        }

        @Override // com.tencent.mm.plugin.finder.viewmodel.component.FinderTabUIC
        public final IFinderTabProvider cXB() {
            AppMethodBeat.i(253036);
            Log.i("Finder.FinderTabUIC", "FinderBizTabUIC generateProvider");
            FinderTabProvider finderTabProvider = new FinderTabProvider();
            AppMethodBeat.o(253036);
            return finderTabProvider;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u0012\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u0005\u0018\u00010\u0004H\u0016¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/finder/ui/sample/FinderSampleTabUI$FinderSampleTabFragment;", "Lcom/tencent/mm/plugin/finder/ui/fragment/FinderHomeTabFragment;", "()V", "importUIComponents", "", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "plugin-finder_release"})
    public static final class FinderSampleTabFragment extends FinderHomeTabFragment {
        private HashMap _$_findViewCache;

        @Override // com.tencent.mm.plugin.finder.ui.fragment.FinderHomeTabFragment, com.tencent.mm.ui.component.UIComponentFragment
        public final void _$_clearFindViewByIdCache() {
            AppMethodBeat.i(253030);
            if (this._$_findViewCache != null) {
                this._$_findViewCache.clear();
            }
            AppMethodBeat.o(253030);
        }

        @Override // com.tencent.mm.plugin.finder.ui.fragment.FinderHomeTabFragment, com.tencent.mm.ui.component.UIComponentFragment, android.support.v4.app.Fragment
        public final /* synthetic */ void onDestroyView() {
            AppMethodBeat.i(253031);
            super.onDestroyView();
            _$_clearFindViewByIdCache();
            AppMethodBeat.o(253031);
        }

        @Override // com.tencent.mm.ui.component.UIComponentFragment
        public final Set<Class<? extends UIComponent>> importUIComponents() {
            AppMethodBeat.i(253029);
            Set<Class<? extends UIComponent>> of = ak.setOf(FinderSampleTabFragmentUIC.class);
            AppMethodBeat.o(253029);
            return of;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u000f\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\b\u001a\u00020\tH\u0016J\u0012\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016¨\u0006\u000e"}, hxF = {"Lcom/tencent/mm/plugin/finder/ui/sample/FinderSampleTabUI$FinderSampleTabFragmentUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", EnvConsts.ACTIVITY_MANAGER_SRVNAME, "Landroid/support/v7/app/AppCompatActivity;", "(Landroid/support/v7/app/AppCompatActivity;)V", "fragment", "Landroid/support/v4/app/Fragment;", "(Landroid/support/v4/app/Fragment;)V", "getLayoutId", "", "onCreateAfter", "", "savedInstanceState", "Landroid/os/Bundle;", "plugin-finder_release"})
    public static final class FinderSampleTabFragmentUIC extends UIComponent {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public FinderSampleTabFragmentUIC(AppCompatActivity appCompatActivity) {
            super(appCompatActivity);
            p.h(appCompatActivity, EnvConsts.ACTIVITY_MANAGER_SRVNAME);
            AppMethodBeat.i(253033);
            AppMethodBeat.o(253033);
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public FinderSampleTabFragmentUIC(Fragment fragment) {
            super(fragment);
            p.h(fragment, "fragment");
            AppMethodBeat.i(253034);
            AppMethodBeat.o(253034);
        }

        @Override // com.tencent.mm.ui.component.UIComponent
        public final void onCreateAfter(Bundle bundle) {
            TextView textView;
            AppMethodBeat.i(253032);
            super.onCreateAfter(bundle);
            StringBuilder sb = new StringBuilder("onCreateAfter ");
            Fragment fragment = getFragment();
            if (fragment == null) {
                t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.ui.fragment.FinderHomeTabFragment");
                AppMethodBeat.o(253032);
                throw tVar;
            }
            StringBuilder append = sb.append(((FinderHomeTabFragment) fragment).title).append("  tabType:");
            Fragment fragment2 = getFragment();
            if (fragment2 == null) {
                t tVar2 = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.ui.fragment.FinderHomeTabFragment");
                AppMethodBeat.o(253032);
                throw tVar2;
            }
            Log.i("SimpleUIComponent", append.append(((FinderHomeTabFragment) fragment2).dLS).toString());
            Fragment fragment3 = getFragment();
            if (fragment3 == null || (textView = (TextView) fragment3.getView().findViewById(R.id.d32)) == null) {
                AppMethodBeat.o(253032);
                return;
            }
            StringBuilder sb2 = new StringBuilder("titleId is :");
            Fragment fragment4 = getFragment();
            if (fragment4 == null) {
                t tVar3 = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.ui.fragment.FinderHomeTabFragment");
                AppMethodBeat.o(253032);
                throw tVar3;
            }
            textView.setText(sb2.append(((FinderHomeTabFragment) fragment4).title).toString());
            AppMethodBeat.o(253032);
        }

        @Override // com.tencent.mm.ui.component.UIComponent
        public final int getLayoutId() {
            return R.layout.akd;
        }
    }
}

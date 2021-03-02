package com.tencent.mm.ui.component;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.PluginReport;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import java.util.HashMap;
import java.util.Set;
import kotlin.a.ak;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\b\u0018\u00002\u00020\u0001:\u0006\u0003\u0004\u0005\u0006\u0007\bB\u0005¢\u0006\u0002\u0010\u0002¨\u0006\t"}, hxF = {"Lcom/tencent/mm/ui/component/Sample;", "", "()V", "ABizUIC", "BBizUIC", "CBizUIC", "MainUIC", "SampleActivity", "SampleFragment", "libmmui_release"})
public final class Sample {

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u0012\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u0005\u0018\u00010\u0004H\u0016¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/ui/component/Sample$SampleActivity;", "Lcom/tencent/mm/ui/component/UIComponentActivity;", "()V", "importUIComponents", "", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "libmmui_release"})
    public static final class SampleActivity extends UIComponentActivity {
        private HashMap _$_findViewCache;

        @Override // com.tencent.mm.ui.component.UIComponentActivity
        public final void _$_clearFindViewByIdCache() {
            AppMethodBeat.i(204808);
            if (this._$_findViewCache != null) {
                this._$_findViewCache.clear();
            }
            AppMethodBeat.o(204808);
        }

        @Override // com.tencent.mm.ui.component.UIComponentActivity
        public final View _$_findCachedViewById(int i2) {
            AppMethodBeat.i(204807);
            if (this._$_findViewCache == null) {
                this._$_findViewCache = new HashMap();
            }
            View view = (View) this._$_findViewCache.get(Integer.valueOf(i2));
            if (view == null) {
                view = findViewById(i2);
                this._$_findViewCache.put(Integer.valueOf(i2), view);
            }
            AppMethodBeat.o(204807);
            return view;
        }

        @Override // com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity
        public void onWindowFocusChanged(boolean z) {
            super.onWindowFocusChanged(z);
            AppMethodBeat.at(this, z);
        }

        @Override // com.tencent.mm.ui.component.UIComponentActivity
        public final Set<Class<? extends UIComponent>> importUIComponents() {
            AppMethodBeat.i(204806);
            Set<Class<? extends UIComponent>> of = ak.setOf((Object[]) new Class[]{MainUIC.class, ABizUIC.class, BBizUIC.class, CBizUIC.class});
            AppMethodBeat.o(204806);
            return of;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u0012\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u0005\u0018\u00010\u0004H\u0016J\u0012\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016¨\u0006\u000b"}, hxF = {"Lcom/tencent/mm/ui/component/Sample$SampleFragment;", "Lcom/tencent/mm/ui/component/UIComponentFragment;", "()V", "importUIComponents", "", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "libmmui_release"})
    public static final class SampleFragment extends UIComponentFragment {
        private HashMap _$_findViewCache;

        @Override // com.tencent.mm.ui.component.UIComponentFragment
        public final void _$_clearFindViewByIdCache() {
            AppMethodBeat.i(204811);
            if (this._$_findViewCache != null) {
                this._$_findViewCache.clear();
            }
            AppMethodBeat.o(204811);
        }

        @Override // com.tencent.mm.ui.component.UIComponentFragment, android.support.v4.app.Fragment
        public final /* synthetic */ void onDestroyView() {
            AppMethodBeat.i(204812);
            super.onDestroyView();
            _$_clearFindViewByIdCache();
            AppMethodBeat.o(204812);
        }

        @Override // com.tencent.mm.ui.component.UIComponentFragment
        public final Set<Class<? extends UIComponent>> importUIComponents() {
            AppMethodBeat.i(204809);
            Set<Class<? extends UIComponent>> of = ak.setOf((Object[]) new Class[]{MainUIC.class, ABizUIC.class, BBizUIC.class, CBizUIC.class});
            AppMethodBeat.o(204809);
            return of;
        }

        @Override // android.support.v4.app.Fragment
        public final void onCreate(Bundle bundle) {
            AppMethodBeat.i(204810);
            super.onCreate(bundle);
            a aVar = a.PRN;
            ((ABizUIC) a.of(this).get(ABizUIC.class)).hashCode();
            a aVar2 = a.PRN;
            Context requireContext = requireContext();
            p.g(requireContext, "requireContext()");
            ((BBizUIC) a.ko(requireContext).get(BBizUIC.class)).hashCode();
            a aVar3 = a.PRN;
            ((CBizUIC) a.bi(PluginReport.class).get(CBizUIC.class)).hashCode();
            AppMethodBeat.o(204810);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u000f\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\b\u001a\u00020\tH\u0016J\u0012\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\b\u0010\u000e\u001a\u00020\u000bH\u0016¨\u0006\u000f"}, hxF = {"Lcom/tencent/mm/ui/component/Sample$MainUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", EnvConsts.ACTIVITY_MANAGER_SRVNAME, "Landroid/support/v7/app/AppCompatActivity;", "(Landroid/support/v7/app/AppCompatActivity;)V", "fragment", "Landroid/support/v4/app/Fragment;", "(Landroid/support/v4/app/Fragment;)V", "getLayoutId", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "libmmui_release"})
    public static final class MainUIC extends UIComponent {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public MainUIC(AppCompatActivity appCompatActivity) {
            super(appCompatActivity);
            p.h(appCompatActivity, EnvConsts.ACTIVITY_MANAGER_SRVNAME);
            AppMethodBeat.i(204804);
            AppMethodBeat.o(204804);
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public MainUIC(Fragment fragment) {
            super(fragment);
            p.h(fragment, "fragment");
            AppMethodBeat.i(204805);
            AppMethodBeat.o(204805);
        }

        @Override // com.tencent.mm.ui.component.UIComponent
        public final int getLayoutId() {
            AppMethodBeat.i(204801);
            int layoutId = super.getLayoutId();
            AppMethodBeat.o(204801);
            return layoutId;
        }

        @Override // com.tencent.mm.ui.component.UIComponent
        public final void onCreate(Bundle bundle) {
            AppMethodBeat.i(204802);
            super.onCreate(bundle);
            AppMethodBeat.o(204802);
        }

        @Override // com.tencent.mm.ui.component.UIComponent
        public final void onDestroy() {
            AppMethodBeat.i(204803);
            super.onDestroy();
            AppMethodBeat.o(204803);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u000f\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0012\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\b\u0010\f\u001a\u00020\tH\u0016¨\u0006\r"}, hxF = {"Lcom/tencent/mm/ui/component/Sample$ABizUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", EnvConsts.ACTIVITY_MANAGER_SRVNAME, "Landroid/support/v7/app/AppCompatActivity;", "(Landroid/support/v7/app/AppCompatActivity;)V", "fragment", "Landroid/support/v4/app/Fragment;", "(Landroid/support/v4/app/Fragment;)V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "libmmui_release"})
    public static final class ABizUIC extends UIComponent {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ABizUIC(AppCompatActivity appCompatActivity) {
            super(appCompatActivity);
            p.h(appCompatActivity, EnvConsts.ACTIVITY_MANAGER_SRVNAME);
            AppMethodBeat.i(204795);
            AppMethodBeat.o(204795);
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ABizUIC(Fragment fragment) {
            super(fragment);
            p.h(fragment, "fragment");
            AppMethodBeat.i(204796);
            AppMethodBeat.o(204796);
        }

        @Override // com.tencent.mm.ui.component.UIComponent
        public final void onCreate(Bundle bundle) {
            AppMethodBeat.i(204793);
            super.onCreate(bundle);
            AppMethodBeat.o(204793);
        }

        @Override // com.tencent.mm.ui.component.UIComponent
        public final void onDestroy() {
            AppMethodBeat.i(204794);
            super.onDestroy();
            AppMethodBeat.o(204794);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u000f\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007¨\u0006\b"}, hxF = {"Lcom/tencent/mm/ui/component/Sample$BBizUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", EnvConsts.ACTIVITY_MANAGER_SRVNAME, "Landroid/support/v7/app/AppCompatActivity;", "(Landroid/support/v7/app/AppCompatActivity;)V", "fragment", "Landroid/support/v4/app/Fragment;", "(Landroid/support/v4/app/Fragment;)V", "libmmui_release"})
    public static final class BBizUIC extends UIComponent {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public BBizUIC(AppCompatActivity appCompatActivity) {
            super(appCompatActivity);
            p.h(appCompatActivity, EnvConsts.ACTIVITY_MANAGER_SRVNAME);
            AppMethodBeat.i(204797);
            AppMethodBeat.o(204797);
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public BBizUIC(Fragment fragment) {
            super(fragment);
            p.h(fragment, "fragment");
            AppMethodBeat.i(204798);
            AppMethodBeat.o(204798);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u000f\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007¨\u0006\b"}, hxF = {"Lcom/tencent/mm/ui/component/Sample$CBizUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", EnvConsts.ACTIVITY_MANAGER_SRVNAME, "Landroid/support/v7/app/AppCompatActivity;", "(Landroid/support/v7/app/AppCompatActivity;)V", "fragment", "Landroid/support/v4/app/Fragment;", "(Landroid/support/v4/app/Fragment;)V", "libmmui_release"})
    public static final class CBizUIC extends UIComponent {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public CBizUIC(AppCompatActivity appCompatActivity) {
            super(appCompatActivity);
            p.h(appCompatActivity, EnvConsts.ACTIVITY_MANAGER_SRVNAME);
            AppMethodBeat.i(204799);
            AppMethodBeat.o(204799);
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public CBizUIC(Fragment fragment) {
            super(fragment);
            p.h(fragment, "fragment");
            AppMethodBeat.i(204800);
            AppMethodBeat.o(204800);
        }
    }
}

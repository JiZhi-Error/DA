package com.tencent.mm.plugin.finder.nearby.video;

import android.arch.lifecycle.ViewModel;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import com.facebook.internal.NativeProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.plugin.finder.nearby.base.AbsNearByFragment;
import com.tencent.mm.plugin.finder.nearby.video.a;
import com.tencent.mm.plugin.finder.report.h;
import com.tencent.mm.plugin.finder.report.k;
import com.tencent.mm.plugin.finder.video.r;
import com.tencent.mm.plugin.finder.viewmodel.FinderGlobalLocationVM;
import com.tencent.mm.plugin.finder.viewmodel.FinderHomeTabStateVM;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderVideoRecycler;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0006\u0018\u0000 02\u00020\u0001:\u00010B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u000f\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\u0006\u0010\u0017\u001a\u00020\u0018J\u0006\u0010\u0019\u001a\u00020\u0018J\"\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u00162\u0006\u0010\u001c\u001a\u00020\u00162\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\u0012\u0010\u001f\u001a\u00020\u00182\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J\b\u0010\"\u001a\u00020\u0018H\u0016J\b\u0010#\u001a\u00020\u0018H\u0016J\b\u0010$\u001a\u00020\u0018H\u0016J\b\u0010%\u001a\u00020\u0018H\u0002J-\u0010&\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u00162\u000e\u0010'\u001a\n\u0012\u0006\b\u0001\u0012\u00020)0(2\u0006\u0010*\u001a\u00020+H\u0016¢\u0006\u0002\u0010,J\b\u0010-\u001a\u00020\u0018H\u0016J\b\u0010.\u001a\u00020\u0018H\u0016J\b\u0010/\u001a\u00020\u0018H\u0016R\u001a\u0010\b\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u000e\u0010\u000e\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u0002\n\u0000¨\u00061"}, hxF = {"Lcom/tencent/mm/plugin/finder/nearby/video/NearbyVideoUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", EnvConsts.ACTIVITY_MANAGER_SRVNAME, "Lcom/tencent/mm/ui/MMFragmentActivity;", "(Lcom/tencent/mm/ui/MMFragmentActivity;)V", "fragment", "Landroid/support/v4/app/Fragment;", "(Landroid/support/v4/app/Fragment;)V", "autoFlingFlag", "", "getAutoFlingFlag", "()Z", "setAutoFlingFlag", "(Z)V", "hasPermissionWhenPause", "locationVM", "Lcom/tencent/mm/plugin/finder/viewmodel/FinderGlobalLocationVM;", "presenter", "Lcom/tencent/mm/plugin/finder/nearby/video/NearbyVideoPresenter;", "viewCallback", "Lcom/tencent/mm/plugin/finder/nearby/video/NearbyVideoViewCallback;", "getLayoutId", "", "onActionbarClick", "", "onActionbarDoubleClick", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onFinished", "onPause", "onPermissionOk", "onRequestPermissionsResult", NativeProtocol.RESULT_ARGS_PERMISSIONS, "", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "onResume", "onUserVisibleFocused", "onUserVisibleUnFocused", "Companion", "plugin-finder_release"})
public final class NearbyVideoUIC extends UIComponent {
    public static final a uTF = new a((byte) 0);
    NearbyVideoPresenter uTB;
    private d uTC;
    private boolean uTD = true;
    private boolean uTE = true;
    private final FinderGlobalLocationVM udf;

    static {
        AppMethodBeat.i(249478);
        AppMethodBeat.o(249478);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Lcom/tencent/mm/plugin/finder/video/IFinderVideoView;", "invoke"})
    static final class b extends q implements kotlin.g.a.b<r, Boolean> {
        public static final b uTG = new b();

        static {
            AppMethodBeat.i(249465);
            AppMethodBeat.o(249465);
        }

        b() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ Boolean invoke(r rVar) {
            AppMethodBeat.i(249464);
            p.h(rVar, LocaleUtil.ITALIAN);
            Boolean bool = Boolean.TRUE;
            AppMethodBeat.o(249464);
            return bool;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/finder/nearby/video/NearbyVideoUIC$Companion;", "", "()V", "REQUEST_STREAM_CODE", "", "TAG", "", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NearbyVideoUIC(MMFragmentActivity mMFragmentActivity) {
        super(mMFragmentActivity);
        p.h(mMFragmentActivity, EnvConsts.ACTIVITY_MANAGER_SRVNAME);
        AppMethodBeat.i(249476);
        com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
        ViewModel viewModel = com.tencent.mm.ui.component.a.bi(PluginFinder.class).get(FinderGlobalLocationVM.class);
        p.g(viewModel, "UICProvider.of(PluginFin…alLocationVM::class.java)");
        this.udf = (FinderGlobalLocationVM) viewModel;
        AppMethodBeat.o(249476);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NearbyVideoUIC(Fragment fragment) {
        super(fragment);
        p.h(fragment, "fragment");
        AppMethodBeat.i(249477);
        com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
        ViewModel viewModel = com.tencent.mm.ui.component.a.bi(PluginFinder.class).get(FinderGlobalLocationVM.class);
        p.g(viewModel, "UICProvider.of(PluginFin…alLocationVM::class.java)");
        this.udf = (FinderGlobalLocationVM) viewModel;
        AppMethodBeat.o(249477);
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final int getLayoutId() {
        return R.layout.bfk;
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onCreate(Bundle bundle) {
        AppMethodBeat.i(249466);
        super.onCreate(bundle);
        AppCompatActivity activity = getActivity();
        if (activity == null) {
            t tVar = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
            AppMethodBeat.o(249466);
            throw tVar;
        }
        NearbyVideoPresenter nearbyVideoPresenter = new NearbyVideoPresenter((MMActivity) activity);
        this.uTB = nearbyVideoPresenter;
        AppCompatActivity activity2 = getActivity();
        if (activity2 == null) {
            t tVar2 = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
            AppMethodBeat.o(249466);
            throw tVar2;
        }
        MMActivity mMActivity = (MMActivity) activity2;
        Fragment fragment = getFragment();
        if (fragment == null) {
            t tVar3 = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.nearby.base.AbsNearByFragment");
            AppMethodBeat.o(249466);
            throw tVar3;
        }
        d dVar = new d(mMActivity, (AbsNearByFragment) fragment, nearbyVideoPresenter, getRootView());
        nearbyVideoPresenter.onAttach((a.b<bo>) dVar);
        this.uTC = dVar;
        AppMethodBeat.o(249466);
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onResume() {
        AppMethodBeat.i(249467);
        super.onResume();
        Log.i("Finder.TimelineLbsUIC", "onResume");
        if (!this.uTD && FinderGlobalLocationVM.dHO()) {
            dlD();
        }
        AppMethodBeat.o(249467);
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onPause() {
        AppMethodBeat.i(249468);
        super.onPause();
        Log.i("Finder.TimelineLbsUIC", "onPause");
        this.uTD = FinderGlobalLocationVM.dHO();
        AppMethodBeat.o(249468);
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onUserVisibleFocused() {
        AppMethodBeat.i(249469);
        Log.i("Finder.TimelineLbsUIC", "onUserVisibleFocused");
        super.onUserVisibleFocused();
        com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
        ((FinderVideoRecycler) com.tencent.mm.ui.component.a.bi(PluginFinder.class).get(FinderVideoRecycler.class)).J(b.uTG);
        com.tencent.mm.ui.component.a aVar2 = com.tencent.mm.ui.component.a.PRN;
        com.tencent.mm.ui.component.a.bi(PluginFinder.class).get(FinderHomeTabStateVM.class);
        NearbyVideoPresenter nearbyVideoPresenter = this.uTB;
        if (nearbyVideoPresenter != null) {
            nearbyVideoPresenter.onUserVisibleFocused();
        }
        this.udf.cxh();
        AppMethodBeat.o(249469);
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onUserVisibleUnFocused() {
        AppMethodBeat.i(249470);
        Log.i("Finder.TimelineLbsUIC", "onUserVisibleUnFocused");
        super.onUserVisibleUnFocused();
        NearbyVideoPresenter nearbyVideoPresenter = this.uTB;
        if (nearbyVideoPresenter != null) {
            nearbyVideoPresenter.onUserVisibleUnFocused();
            AppMethodBeat.o(249470);
            return;
        }
        AppMethodBeat.o(249470);
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onFinished() {
        AppMethodBeat.i(249471);
        super.onFinished();
        NearbyVideoPresenter nearbyVideoPresenter = this.uTB;
        if (nearbyVideoPresenter != null) {
            nearbyVideoPresenter.onFinishing();
            AppMethodBeat.o(249471);
            return;
        }
        AppMethodBeat.o(249471);
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onDestroy() {
        AppMethodBeat.i(249472);
        super.onDestroy();
        NearbyVideoPresenter nearbyVideoPresenter = this.uTB;
        if (nearbyVideoPresenter != null) {
            nearbyVideoPresenter.onDetach();
        }
        h.a(h.veu);
        AppMethodBeat.o(249472);
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onActivityResult(int i2, int i3, Intent intent) {
        NearbyVideoPresenter nearbyVideoPresenter;
        AppMethodBeat.i(249473);
        if (i2 != 501 || i3 != -1 || intent == null || (nearbyVideoPresenter = this.uTB) == null) {
            AppMethodBeat.o(249473);
            return;
        }
        nearbyVideoPresenter.refreshRV(intent);
        AppMethodBeat.o(249473);
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        AppMethodBeat.i(249474);
        p.h(strArr, NativeProtocol.RESULT_ARGS_PERMISSIONS);
        p.h(iArr, "grantResults");
        if (i2 == 79) {
            if (iArr[0] == 0) {
                dlD();
                AppMethodBeat.o(249474);
                return;
            }
            k kVar = k.vfA;
            k.ac(getActivity(), 3);
        }
        AppMethodBeat.o(249474);
    }

    private final void dlD() {
        AppMethodBeat.i(249475);
        if (this.uTE) {
            this.uTE = false;
            NearbyVideoPresenter nearbyVideoPresenter = this.uTB;
            if (nearbyVideoPresenter != null) {
                nearbyVideoPresenter.autoFlingToRefresh(100, false);
            }
            k kVar = k.vfA;
            k.ac(getActivity(), 5);
        }
        AppMethodBeat.o(249475);
    }
}

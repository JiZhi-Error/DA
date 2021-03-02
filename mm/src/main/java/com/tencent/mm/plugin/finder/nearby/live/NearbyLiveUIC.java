package com.tencent.mm.plugin.finder.nearby.live;

import android.content.Intent;
import android.support.v4.app.Fragment;
import com.facebook.internal.NativeProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.report.live.c;
import com.tencent.mm.plugin.finder.report.live.k;
import com.tencent.mm.plugin.finder.report.live.s;
import com.tencent.mm.plugin.finder.ui.f;
import com.tencent.mm.plugin.finder.video.r;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderVideoRecycler;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0006\u0018\u0000 )2\u00020\u0001:\u0001)B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u000f\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\u0006\u0010\u0010\u001a\u00020\u0011J\u0006\u0010\u0012\u001a\u00020\u0011J\"\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u000f2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\u0012\u0010\u0018\u001a\u00020\u00112\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\b\u0010\u001b\u001a\u00020\u0011H\u0016J\b\u0010\u001c\u001a\u00020\u0011H\u0016J\u0006\u0010\u001d\u001a\u00020\u0011J\b\u0010\u001e\u001a\u00020\u0011H\u0016J-\u0010\u001f\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u000f2\u000e\u0010 \u001a\n\u0012\u0006\b\u0001\u0012\u00020\"0!2\u0006\u0010#\u001a\u00020$H\u0016¢\u0006\u0002\u0010%J\b\u0010&\u001a\u00020\u0011H\u0016J\b\u0010'\u001a\u00020\u0011H\u0016J\b\u0010(\u001a\u00020\u0011H\u0016R\u000e\u0010\b\u001a\u00020\tX.¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX.¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX.¢\u0006\u0002\n\u0000¨\u0006*"}, hxF = {"Lcom/tencent/mm/plugin/finder/nearby/live/NearbyLiveUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", EnvConsts.ACTIVITY_MANAGER_SRVNAME, "Lcom/tencent/mm/ui/MMFragmentActivity;", "(Lcom/tencent/mm/ui/MMFragmentActivity;)V", "fragment", "Landroid/support/v4/app/Fragment;", "(Landroid/support/v4/app/Fragment;)V", "liveFriendsCallback", "Lcom/tencent/mm/plugin/finder/nearby/live/NearbyLiveViewCallback;", "liveFriendsPresenter", "Lcom/tencent/mm/plugin/finder/nearby/live/NearbyLivePresenter;", "livePostHelper", "Lcom/tencent/mm/plugin/finder/ui/FinderLivePostForNearby;", "getLayoutId", "", "onActionbarClick", "", "onActionbarDoubleClick", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onFinished", "onMenuClick", "onPause", "onRequestPermissionsResult", NativeProtocol.RESULT_ARGS_PERMISSIONS, "", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "onResume", "onUserVisibleFocused", "onUserVisibleUnFocused", "Companion", "plugin-finder_release"})
public final class NearbyLiveUIC extends UIComponent {
    public static final a uRl = new a((byte) 0);
    f uRi;
    d uRj;
    private e uRk;

    static {
        AppMethodBeat.i(249112);
        AppMethodBeat.o(249112);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Lcom/tencent/mm/plugin/finder/video/IFinderVideoView;", "invoke"})
    static final class b extends q implements kotlin.g.a.b<r, Boolean> {
        public static final b uRm = new b();

        static {
            AppMethodBeat.i(249100);
            AppMethodBeat.o(249100);
        }

        b() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ Boolean invoke(r rVar) {
            AppMethodBeat.i(249099);
            p.h(rVar, LocaleUtil.ITALIAN);
            Boolean bool = Boolean.TRUE;
            AppMethodBeat.o(249099);
            return bool;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/finder/nearby/live/NearbyLiveUIC$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NearbyLiveUIC(MMFragmentActivity mMFragmentActivity) {
        super(mMFragmentActivity);
        p.h(mMFragmentActivity, EnvConsts.ACTIVITY_MANAGER_SRVNAME);
        AppMethodBeat.i(249110);
        AppMethodBeat.o(249110);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NearbyLiveUIC(Fragment fragment) {
        super(fragment);
        p.h(fragment, "fragment");
        AppMethodBeat.i(249111);
        AppMethodBeat.o(249111);
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final int getLayoutId() {
        return R.layout.bfg;
    }

    /* JADX WARNING: Removed duplicated region for block: B:7:0x004f  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x005b  */
    @Override // com.tencent.mm.ui.component.UIComponent
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onCreate(android.os.Bundle r7) {
        /*
        // Method dump skipped, instructions count: 172
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.nearby.live.NearbyLiveUIC.onCreate(android.os.Bundle):void");
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onResume() {
        AppMethodBeat.i(249102);
        super.onResume();
        k kVar = k.vkd;
        e eVar = this.uRk;
        if (eVar == null) {
            p.btv("liveFriendsCallback");
        }
        k.a(eVar.getRecyclerView(), s.p.LIVE_AUDIENCE_EXPLORE_FEED_CARD, "94", c.EVENT_ON_RESUME, -100, -100);
        AppMethodBeat.o(249102);
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onPause() {
        AppMethodBeat.i(249103);
        super.onPause();
        f fVar = this.uRi;
        if (fVar == null) {
            p.btv("livePostHelper");
        }
        if (fVar != null) {
            fVar.reset();
        }
        k kVar = k.vkd;
        e eVar = this.uRk;
        if (eVar == null) {
            p.btv("liveFriendsCallback");
        }
        k.a(eVar.getRecyclerView(), s.p.LIVE_AUDIENCE_EXPLORE_FEED_CARD, "94", c.EVENT_ON_PAUSE, -100, -100);
        AppMethodBeat.o(249103);
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onUserVisibleFocused() {
        AppMethodBeat.i(249104);
        super.onUserVisibleFocused();
        d dVar = this.uRj;
        if (dVar == null) {
            p.btv("liveFriendsPresenter");
        }
        if (dVar != null) {
            dVar.onUserVisibleFocused();
        }
        com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
        ((FinderVideoRecycler) com.tencent.mm.ui.component.a.bi(PluginFinder.class).get(FinderVideoRecycler.class)).J(b.uRm);
        AppMethodBeat.o(249104);
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(249105);
        f fVar = this.uRi;
        if (fVar == null) {
            p.btv("livePostHelper");
        }
        fVar.onActivityResult(i2, i3, intent);
        AppMethodBeat.o(249105);
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        AppMethodBeat.i(249106);
        p.h(strArr, NativeProtocol.RESULT_ARGS_PERMISSIONS);
        p.h(iArr, "grantResults");
        f fVar = this.uRi;
        if (fVar == null) {
            p.btv("livePostHelper");
        }
        fVar.onRequestPermissionsResult(i2, strArr, iArr);
        AppMethodBeat.o(249106);
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onUserVisibleUnFocused() {
        AppMethodBeat.i(249107);
        super.onUserVisibleUnFocused();
        if (this.uRj == null) {
            p.btv("liveFriendsPresenter");
        }
        AppMethodBeat.o(249107);
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onFinished() {
        AppMethodBeat.i(249108);
        super.onFinished();
        d dVar = this.uRj;
        if (dVar == null) {
            p.btv("liveFriendsPresenter");
        }
        if (dVar != null) {
            dVar.onFinishing();
            AppMethodBeat.o(249108);
            return;
        }
        AppMethodBeat.o(249108);
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onDestroy() {
        AppMethodBeat.i(249109);
        super.onDestroy();
        d dVar = this.uRj;
        if (dVar == null) {
            p.btv("liveFriendsPresenter");
        }
        if (dVar != null) {
            dVar.onDetach();
        }
        f fVar = this.uRi;
        if (fVar == null) {
            p.btv("livePostHelper");
        }
        if (fVar != null) {
            Log.i("Finder.FinderLivePostForNearby", "release()");
            fVar.reset();
            g.azz().b(5231, fVar);
            g.azz().b(3761, fVar);
            fVar.vKL = null;
            fVar.vKM = null;
            fVar.uiv = null;
            fVar.vKN = null;
            AppMethodBeat.o(249109);
            return;
        }
        AppMethodBeat.o(249109);
    }
}

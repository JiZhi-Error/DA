package com.tencent.mm.plugin.appbrand.ui.recents;

import android.annotation.SuppressLint;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.api.g;
import com.tencent.mm.plugin.appbrand.app.f;
import com.tencent.mm.plugin.appbrand.appusage.ap;
import com.tencent.mm.plugin.appbrand.report.AppBrandLauncherDesktopReporter;
import com.tencent.mm.plugin.appbrand.service.r;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.ajs;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 \u001b2\u00020\u00012\u00020\u0002:\u0001\u001bB\u0019\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\n\u001a\u00020\u000bH\u0016J\n\u0010\f\u001a\u0004\u0018\u00010\rH\u0014J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\u0012\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\u0010\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0010\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u0018H\u0015J\b\u0010\u0019\u001a\u00020\u001aH\u0002R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/ui/recents/AppBrandLauncherHeaderLiveEntrance;", "Lcom/tencent/mm/plugin/appbrand/ui/recents/AppBrandLauncherListHeaderFolderEntrance;", "Lcom/tencent/mm/plugin/appbrand/appusage/WxaDesktopHeaderEntranceLogic$EntranceInfoUpdateReceiver;", EnvConsts.ACTIVITY_MANAGER_SRVNAME, "Landroid/support/v4/app/FragmentActivity;", "viewGroup", "Landroid/view/ViewGroup;", "(Landroid/support/v4/app/FragmentActivity;Landroid/view/ViewGroup;)V", "configKV", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "getEntranceId", "Lcom/tencent/mm/plugin/appbrand/appusage/WxaDesktopHeaderEntranceLogic$EntranceId;", "getTitle", "", "onAttached", "", "onClick", "v", "Landroid/view/View;", "onEntranceInfoUpdate", "info", "Lcom/tencent/mm/protocal/protobuf/EntranceInfo;", "setIConRes", "imageView", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "wantShowEntry", "", "Companion", "plugin-appbrand-integration_release"})
public final class d extends f implements ap.c {
    public static final a obt = new a((byte) 0);
    private final MultiProcessMMKV obs;

    static {
        AppMethodBeat.i(180700);
        AppMethodBeat.o(180700);
    }

    public d(FragmentActivity fragmentActivity, ViewGroup viewGroup) {
        super(fragmentActivity, viewGroup);
        AppMethodBeat.i(180699);
        MultiProcessMMKV VQ = f.kIs.VQ();
        if (VQ == null) {
            p.hyc();
        }
        this.obs = VQ;
        AppMethodBeat.o(180699);
    }

    @Override // com.tencent.mm.plugin.appbrand.appusage.ap.c
    public final void a(ajs ajs) {
        AppMethodBeat.i(180694);
        p.h(ajs, "info");
        if (!this.obs.getBoolean("kv_want_show_entry", false) && ajs.Ltg == 1) {
            this.obs.putBoolean("kv_want_show_entry", true);
        }
        b(ajs);
        AppMethodBeat.o(180694);
    }

    @Override // com.tencent.mm.plugin.appbrand.appusage.ap.c
    public final ap.b byw() {
        return ap.b.ENTRANCE_ID_LIVE;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.appbrand.ui.recents.f
    public final String getTitle() {
        AppMethodBeat.i(180695);
        String string = getActivity().getString(R.string.qg);
        AppMethodBeat.o(180695);
        return string;
    }

    @Override // com.tencent.mm.plugin.appbrand.ui.recents.f
    public final void onClick(View view) {
        AppMethodBeat.i(180696);
        super.onClick(view);
        g gVar = new g();
        gVar.username = "gh_bc64bb356935@app";
        gVar.iOo = 0;
        gVar.version = 0;
        gVar.scene = 1001;
        gVar.dCw = "";
        ((r) com.tencent.mm.kernel.g.af(r.class)).a(getActivity(), gVar);
        if (this.obG != null) {
            com.tencent.mm.plugin.appbrand.report.f fVar = com.tencent.mm.plugin.appbrand.report.f.nGV;
            FragmentActivity activity = getActivity();
            p.g(activity, EnvConsts.ACTIVITY_MANAGER_SRVNAME);
            AppBrandLauncherDesktopReporter b2 = com.tencent.mm.plugin.appbrand.report.f.b(activity);
            int i2 = this.obG.xGz;
            h.INSTANCE.a(19468, 3, Integer.valueOf(i2), "", "", "", "", Long.valueOf(b2.mSessionId));
        }
        AppMethodBeat.o(180696);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.appbrand.ui.recents.a
    @SuppressLint({"ResourceType"})
    public final void a(WeImageView weImageView) {
        AppMethodBeat.i(180697);
        p.h(weImageView, "imageView");
        weImageView.setVisibility(0);
        weImageView.setImageResource(R.raw.icons_outline_miniprogram_live);
        FragmentActivity activity = getActivity();
        p.g(activity, EnvConsts.ACTIVITY_MANAGER_SRVNAME);
        weImageView.setIconColor(activity.getResources().getColor(R.color.Purple));
        AppMethodBeat.o(180697);
    }

    @Override // com.tencent.mm.plugin.appbrand.ui.recents.f, com.tencent.mm.plugin.appbrand.ui.recents.a
    public final void bSx() {
        boolean z;
        AppMethodBeat.i(180698);
        super.bSx();
        if (!p.j(((b) com.tencent.mm.kernel.g.af(b.class)).a(b.a.clicfg_appbrand_desktop_live_entrance_enable, ""), "1") || !this.obs.getBoolean("kv_want_show_entry", false)) {
            z = false;
        } else {
            z = true;
        }
        setViewEnable(z);
        AppMethodBeat.o(180698);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/ui/recents/AppBrandLauncherHeaderLiveEntrance$Companion;", "", "()V", "KV_WANT_SHOW_ENTRY", "", "TAG", "plugin-appbrand-integration_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }
}

package com.tencent.mm.plugin.appbrand.ui.recents;

import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.appusage.ap;
import com.tencent.mm.plugin.appbrand.report.AppBrandLauncherDesktopReporter;
import com.tencent.mm.plugin.appbrand.service.r;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.ajs;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import kotlin.f;
import kotlin.g;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u001d2\u00020\u00012\u00020\u0002:\u0001\u001dB\u0019\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\n\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0014J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\u0012\u0010\u0014\u001a\u00020\u00132\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\u0010\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u0010\u0010\u001a\u001a\u00020\u00132\u0006\u0010\u001b\u001a\u00020\u001cH\u0014R\u001b\u0010\b\u001a\u00020\t8BX\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000b¨\u0006\u001e"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/ui/recents/AppBrandLauncherHeaderEveryoneUsing;", "Lcom/tencent/mm/plugin/appbrand/ui/recents/AppBrandLauncherListHeaderFolderEntrance;", "Lcom/tencent/mm/plugin/appbrand/appusage/WxaDesktopHeaderEntranceLogic$EntranceInfoUpdateReceiver;", EnvConsts.ACTIVITY_MANAGER_SRVNAME, "Landroid/support/v4/app/FragmentActivity;", "viewGroup", "Landroid/view/ViewGroup;", "(Landroid/support/v4/app/FragmentActivity;Landroid/view/ViewGroup;)V", "configKV", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "getConfigKV", "()Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "configKV$delegate", "Lkotlin/Lazy;", "getEntranceId", "Lcom/tencent/mm/plugin/appbrand/appusage/WxaDesktopHeaderEntranceLogic$EntranceId;", "getTitle", "", "onAttached", "", "onClick", "v", "Landroid/view/View;", "onEntranceInfoUpdate", "info", "Lcom/tencent/mm/protocal/protobuf/EntranceInfo;", "setIConRes", "imageView", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "Companion", "plugin-appbrand-integration_release"})
public final class c extends f implements ap.c {
    public static final a obq = new a((byte) 0);
    private final f obp = g.ah(b.obr);

    static {
        AppMethodBeat.i(229565);
        AppMethodBeat.o(229565);
    }

    private final MultiProcessMMKV bYq() {
        AppMethodBeat.i(229558);
        MultiProcessMMKV multiProcessMMKV = (MultiProcessMMKV) this.obp.getValue();
        AppMethodBeat.o(229558);
        return multiProcessMMKV;
    }

    public c(FragmentActivity fragmentActivity, ViewGroup viewGroup) {
        super(fragmentActivity, viewGroup);
        AppMethodBeat.i(229564);
        AppMethodBeat.o(229564);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.appbrand.ui.recents.f
    public final String getTitle() {
        AppMethodBeat.i(229559);
        String string = getActivity().getString(R.string.qf);
        AppMethodBeat.o(229559);
        return string;
    }

    @Override // com.tencent.mm.plugin.appbrand.ui.recents.f
    public final void onClick(View view) {
        AppMethodBeat.i(229560);
        super.onClick(view);
        com.tencent.mm.plugin.appbrand.api.g gVar = new com.tencent.mm.plugin.appbrand.api.g();
        gVar.username = "gh_a9a5bb48a181@app";
        gVar.iOo = 0;
        gVar.version = 0;
        gVar.scene = 1001;
        gVar.dCw = "";
        ((r) com.tencent.mm.kernel.g.af(r.class)).a(getActivity(), gVar);
        com.tencent.mm.plugin.appbrand.report.f fVar = com.tencent.mm.plugin.appbrand.report.f.nGV;
        FragmentActivity activity = getActivity();
        p.g(activity, EnvConsts.ACTIVITY_MANAGER_SRVNAME);
        AppBrandLauncherDesktopReporter b2 = com.tencent.mm.plugin.appbrand.report.f.b(activity);
        h.INSTANCE.a(19468, 9, "", "", "", "", "", Long.valueOf(b2.mSessionId));
        AppMethodBeat.o(229560);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.appbrand.ui.recents.a
    public final void a(WeImageView weImageView) {
        AppMethodBeat.i(229561);
        p.h(weImageView, "imageView");
        weImageView.setVisibility(0);
        weImageView.setImageResource(R.raw.icons_outline_miniprogram_friends_like);
        FragmentActivity activity = getActivity();
        p.g(activity, EnvConsts.ACTIVITY_MANAGER_SRVNAME);
        weImageView.setIconColor(activity.getResources().getColor(R.color.Blue));
        AppMethodBeat.o(229561);
    }

    @Override // com.tencent.mm.plugin.appbrand.ui.recents.f, com.tencent.mm.plugin.appbrand.ui.recents.a
    public final void bSx() {
        boolean z;
        AppMethodBeat.i(229562);
        super.bSx();
        boolean z2 = bYq().getBoolean("key_show_appbrand_launcher_header_everyone_using_entrance", true);
        if (z2) {
            com.tencent.mm.kernel.c.a af = com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.teenmode.a.b.class);
            p.g(af, "MMKernel.service(ITeenModeService::class.java)");
            if (((com.tencent.mm.plugin.teenmode.a.b) af).Vt()) {
                com.tencent.mm.kernel.c.a af2 = com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.teenmode.a.b.class);
                p.g(af2, "MMKernel.service(ITeenModeService::class.java)");
                z = ((com.tencent.mm.plugin.teenmode.a.b) af2).fvp() == 1;
                setViewEnable(z);
                AppMethodBeat.o(229562);
            }
        }
        z = z2;
        setViewEnable(z);
        AppMethodBeat.o(229562);
    }

    @Override // com.tencent.mm.plugin.appbrand.appusage.ap.c
    public final void a(ajs ajs) {
        boolean z = true;
        AppMethodBeat.i(229563);
        p.h(ajs, "info");
        MultiProcessMMKV bYq = bYq();
        if (ajs.Ltg != 1) {
            z = false;
        }
        bYq.putBoolean("key_show_appbrand_launcher_header_everyone_using_entrance", z);
        AppMethodBeat.o(229563);
    }

    @Override // com.tencent.mm.plugin.appbrand.appusage.ap.c
    public final ap.b byw() {
        return ap.b.ENTRANCE_ID_FRIENDS_USING;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/ui/recents/AppBrandLauncherHeaderEveryoneUsing$Companion;", "", "()V", "KEY_WANT_SHOW_ENTRY", "", "plugin-appbrand-integration_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "invoke"})
    static final class b extends q implements kotlin.g.a.a<MultiProcessMMKV> {
        public static final b obr = new b();

        static {
            AppMethodBeat.i(229557);
            AppMethodBeat.o(229557);
        }

        b() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ MultiProcessMMKV invoke() {
            AppMethodBeat.i(229556);
            MultiProcessMMKV VQ = com.tencent.mm.plugin.appbrand.app.f.kIs.VQ();
            if (VQ == null) {
                p.hyc();
            }
            AppMethodBeat.o(229556);
            return VQ;
        }
    }
}

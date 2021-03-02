package com.tencent.mm.plugin.appbrand.ui.recents;

import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.api.g;
import com.tencent.mm.plugin.appbrand.r.c;
import com.tencent.mm.plugin.appbrand.report.AppBrandLauncherDesktopReporter;
import com.tencent.mm.plugin.appbrand.report.f;
import com.tencent.mm.plugin.appbrand.service.r;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.bzj;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import java.lang.ref.WeakReference;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\n\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0014J\b\u0010\t\u001a\u00020\nH\u0016J\u0012\u0010\u000b\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\b\u0010\u000e\u001a\u00020\nH\u0016J\u0010\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u0011H\u0014J\b\u0010\u0012\u001a\u00020\nH\u0002¨\u0006\u0014"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/ui/recents/AppBrandLauncherHeaderOrderEntrance;", "Lcom/tencent/mm/plugin/appbrand/ui/recents/AppBrandLauncherListHeaderFolderEntrance;", EnvConsts.ACTIVITY_MANAGER_SRVNAME, "Landroid/support/v4/app/FragmentActivity;", "viewGroup", "Landroid/view/ViewGroup;", "(Landroid/support/v4/app/FragmentActivity;Landroid/view/ViewGroup;)V", "getTitle", "", "onAttached", "", "onClick", "v", "Landroid/view/View;", "onResume", "setIConRes", "imageView", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "updateMoreOptionEntryRedDotStatus", "Companion", "plugin-appbrand-integration_release"})
public final class e extends f {
    public static final a obu = new a((byte) 0);

    static {
        AppMethodBeat.i(180709);
        AppMethodBeat.o(180709);
    }

    public e(FragmentActivity fragmentActivity, ViewGroup viewGroup) {
        super(fragmentActivity, viewGroup);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.appbrand.ui.recents.f
    public final String getTitle() {
        AppMethodBeat.i(180703);
        String string = getActivity().getString(R.string.qh);
        AppMethodBeat.o(180703);
        return string;
    }

    @Override // com.tencent.mm.plugin.appbrand.ui.recents.f
    public final void onClick(View view) {
        AppMethodBeat.i(180704);
        super.onClick(view);
        g gVar = new g();
        gVar.username = "gh_af04e9bb7e91@app";
        gVar.iOo = 0;
        gVar.version = 0;
        gVar.scene = 1001;
        gVar.dCw = "";
        ((r) com.tencent.mm.kernel.g.af(r.class)).a(getActivity(), gVar);
        com.tencent.mm.plugin.appbrand.r.g gVar2 = new com.tencent.mm.plugin.appbrand.r.g(true);
        com.tencent.mm.kernel.b aAg = com.tencent.mm.kernel.g.aAg();
        p.g(aAg, "MMKernel.network()");
        aAg.azz().b(gVar2);
        h.INSTANCE.a(18685, 2);
        f fVar = f.nGV;
        FragmentActivity activity = getActivity();
        p.g(activity, EnvConsts.ACTIVITY_MANAGER_SRVNAME);
        AppBrandLauncherDesktopReporter b2 = f.b(activity);
        h.INSTANCE.a(19468, 4, "", "", "", "", "", Long.valueOf(b2.mSessionId));
        AppMethodBeat.o(180704);
    }

    @Override // com.tencent.mm.plugin.appbrand.ui.recents.f, com.tencent.mm.plugin.appbrand.ui.recents.a
    public final void bSx() {
        AppMethodBeat.i(180705);
        super.bSx();
        com.tencent.e.f.h.hkS();
        bYr();
        AppMethodBeat.o(180705);
    }

    @Override // com.tencent.mm.plugin.appbrand.ui.recents.f, com.tencent.mm.plugin.appbrand.ui.recents.a
    public final void onResume() {
        AppMethodBeat.i(180706);
        super.onResume();
        bYr();
        AppMethodBeat.o(180706);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001J(\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0002H\u0016¨\u0006\f"}, hxF = {"com/tencent/mm/plugin/appbrand/ui/recents/AppBrandLauncherHeaderOrderEntrance$updateMoreOptionEntryRedDotStatus$netSceneGetWxaOrderInfo$1", "Lcom/tencent/mm/plugin/appbrand/netscene/NetSceneGetWxaOrderInfo$IOnNetSceneGetWxaOrderInfoCallback;", "Lcom/tencent/mm/plugin/appbrand/netscene/NetSceneGetWxaOrderInfo;", "Lcom/tencent/mm/plugin/appbrand/ui/recents/AppBrandLauncherHeaderOrderEntrance;", "onNetSceneEndCallback", "", "errType", "", "errCode", "errMsg", "", "scene", "plugin-appbrand-integration_release"})
    public static final class b extends c.a<c, e> {
        final /* synthetic */ e obv;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(e eVar, WeakReference weakReference) {
            super(weakReference);
            this.obv = eVar;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, int, java.lang.String, com.tencent.mm.ak.q] */
        @Override // com.tencent.mm.plugin.appbrand.r.c.a
        public final /* synthetic */ void a(int i2, int i3, String str, c cVar) {
            AppMethodBeat.i(180702);
            c cVar2 = cVar;
            p.h(str, "errMsg");
            p.h(cVar2, "scene");
            if (i2 == 0 && i3 == 0) {
                MMHandlerThread.postToMainThread(new a(this, cVar2));
                AppMethodBeat.o(180702);
                return;
            }
            new StringBuilder("NetSceneGetWxaOrderInfo error errType=").append(i2).append("  errCode=").append(i3);
            com.tencent.e.f.h.hkS();
            AppMethodBeat.o(180702);
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
        static final class a implements Runnable {
            final /* synthetic */ b obw;
            final /* synthetic */ c obx;

            a(b bVar, c cVar) {
                this.obw = bVar;
                this.obx = cVar;
            }

            public final void run() {
                AppMethodBeat.i(180701);
                U u = this.obw.nhy.get();
                if (u != null) {
                    com.tencent.mm.bw.a aYK = this.obx.nhw.aYK();
                    if (aYK == null) {
                        t tVar = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.GetWxaOrderInfoResp");
                        AppMethodBeat.o(180701);
                        throw tVar;
                    }
                    u.iR(((bzj) aYK).Mfa);
                    AppMethodBeat.o(180701);
                    return;
                }
                AppMethodBeat.o(180701);
            }
        }
    }

    private final void bYr() {
        AppMethodBeat.i(180707);
        com.tencent.e.f.h.hkS();
        c cVar = new c(new b(this, new WeakReference(this)));
        com.tencent.mm.kernel.b aAg = com.tencent.mm.kernel.g.aAg();
        p.g(aAg, "MMKernel.network()");
        aAg.azz().b(cVar);
        AppMethodBeat.o(180707);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.appbrand.ui.recents.a
    public final void a(WeImageView weImageView) {
        AppMethodBeat.i(180708);
        p.h(weImageView, "imageView");
        weImageView.setVisibility(0);
        weImageView.setImageResource(R.raw.icons_outline_miniprogram_order);
        FragmentActivity activity = getActivity();
        p.g(activity, EnvConsts.ACTIVITY_MANAGER_SRVNAME);
        weImageView.setIconColor(activity.getResources().getColor(R.color.Brand));
        AppMethodBeat.o(180708);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/ui/recents/AppBrandLauncherHeaderOrderEntrance$Companion;", "", "()V", "TAG", "", "plugin-appbrand-integration_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }
}

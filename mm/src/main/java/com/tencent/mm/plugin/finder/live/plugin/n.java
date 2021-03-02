package com.tencent.mm.plugin.finder.live.plugin;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ab.i;
import com.tencent.mm.live.c.b;
import com.tencent.mm.plugin.finder.live.model.o;
import com.tencent.mm.plugin.finder.live.model.s;
import com.tencent.mm.plugin.finder.live.widget.f;
import com.tencent.mm.plugin.finder.report.live.k;
import com.tencent.mm.plugin.finder.report.live.s;
import com.tencent.mm.plugin.finder.utils.ae;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\nH\u0002J\"\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\b2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\u000e\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\nJ \u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\n2\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0019\u001a\u00020\bJ$\u0010\u001a\u001a\u00020\u000e2\b\u0010\u001b\u001a\u0004\u0018\u00010\n2\b\u0010\u001c\u001a\u0004\u0018\u00010\n2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018R\u000e\u0010\u0007\u001a\u00020\bXD¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nXD¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorExceptionPlugin;", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "REQUEST_CODE_FACE_VERIFY", "", "TAG", "", "exceptionWidget", "Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveExceptionWidget;", "initWidget", "", "anchorUserName", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "showAnchorForceQuit", "showCreateLiveDynamicErrPage", "errorPage", "Lcom/tencent/mm/protocal/protobuf/FinderLiveErrorPage;", "errCode", "showFaceVerify", "verifyUrl", "userName", "plugin-finder_release"})
public final class n extends d {
    public final String TAG = "Finder.LiveAnchorExceptionPlugin";
    final com.tencent.mm.live.c.b hOp;
    final int umR = 10000;
    public f umS;

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", "licenseUrl", "", "invoke"})
    static final class a extends q implements kotlin.g.a.b<String, x> {
        final /* synthetic */ n umT;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(n nVar) {
            super(1);
            this.umT = nVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(String str) {
            AppMethodBeat.i(246452);
            String str2 = str;
            p.h(str2, "licenseUrl");
            Intent intent = new Intent();
            intent.putExtra("rawUrl", str2);
            o oVar = o.ujN;
            s finderLiveAssistant = o.getFinderLiveAssistant();
            if (finderLiveAssistant != null) {
                Context context = this.umT.hwr.getContext();
                p.g(context, "root.context");
                finderLiveAssistant.a(context, intent, (Integer) null);
            }
            x xVar = x.SXb;
            AppMethodBeat.o(246452);
            return xVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", "ok", "", "invoke"})
    public static final class b extends q implements kotlin.g.a.b<Boolean, x> {
        final /* synthetic */ n umT;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(n nVar) {
            super(1);
            this.umT = nVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(Boolean bool) {
            AppMethodBeat.i(246453);
            bool.booleanValue();
            b.C0376b.a(this.umT.hOp, b.c.hLD);
            x xVar = x.SXb;
            AppMethodBeat.o(246453);
            return xVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", "ok", "", "invoke"})
    public static final class c extends q implements kotlin.g.a.b<Boolean, x> {
        final /* synthetic */ n umT;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(n nVar) {
            super(1);
            this.umT = nVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(Boolean bool) {
            AppMethodBeat.i(246454);
            bool.booleanValue();
            b.C0376b.a(this.umT.hOp, b.c.hLD);
            x xVar = x.SXb;
            AppMethodBeat.o(246454);
            return xVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", "verify", "", "invoke"})
    public static final class d extends q implements kotlin.g.a.b<Boolean, x> {
        final /* synthetic */ String jDi;
        final /* synthetic */ n umT;
        final /* synthetic */ String umU;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(n nVar, String str, String str2) {
            super(1);
            this.umT = nVar;
            this.umU = str;
            this.jDi = str2;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(Boolean bool) {
            AppMethodBeat.i(246455);
            if (bool.booleanValue()) {
                Intent intent = new Intent();
                intent.putExtra("open_custom_style_url", true);
                intent.putExtra("forceHideShare", true);
                intent.putExtra("show_native_web_view", true);
                intent.putExtra("rawUrl", this.umU);
                intent.putExtra("screen_orientation", 1);
                intent.putExtra("srcUsername", this.jDi);
                com.tencent.mm.br.c.b(this.umT.hwr.getContext(), "webview", ".ui.tools.WebViewUI", intent, this.umT.umR);
                k kVar = k.vkd;
                k.a(s.ad.LIVE_ENTER_VERIFIED_PAGE, this.jDi);
            } else {
                b.C0376b.a(this.umT.hOp, b.c.hLy);
            }
            x xVar = x.SXb;
            AppMethodBeat.o(246455);
            return xVar;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public n(ViewGroup viewGroup, com.tencent.mm.live.c.b bVar) {
        super(viewGroup, bVar);
        p.h(viewGroup, "root");
        p.h(bVar, "statusMonitor");
        AppMethodBeat.i(246458);
        this.hOp = bVar;
        AppMethodBeat.o(246458);
    }

    public final void atI(String str) {
        AppMethodBeat.i(246456);
        if (this.umS == null) {
            this.umS = new f(this.hwr, str, getLiveData().uEu);
            f fVar = this.umS;
            if (fVar != null) {
                fVar.uGl = new a(this);
                AppMethodBeat.o(246456);
                return;
            }
        }
        AppMethodBeat.o(246456);
    }

    @Override // com.tencent.mm.live.c.a
    public final void onActivityResult(int i2, int i3, Intent intent) {
        Bundle bundle;
        String str;
        AppMethodBeat.i(246457);
        super.onActivityResult(i2, i3, intent);
        if (i2 == this.umR) {
            f fVar = this.umS;
            if (fVar != null) {
                fVar.hide();
            }
            if (intent != null) {
                bundle = intent.getBundleExtra("result_data");
            } else {
                bundle = null;
            }
            if (intent == null || (str = intent.getStringExtra("srcUsername")) == null) {
                str = "";
            }
            if (i3 == -1 && bundle != null) {
                String string = bundle.getString("go_next", "");
                String string2 = bundle.getString("result_json");
                if (!Util.isNullOrNil(string2)) {
                    int i4 = new i(string2).getInt(TMQQDownloaderOpenSDKConst.UINTYPE_CODE);
                    if (p.j(string, "roomlive_verify") && i4 == 0) {
                        com.tencent.mm.live.c.b bVar = this.hOp;
                        b.c cVar = b.c.hMx;
                        Bundle bundle2 = new Bundle();
                        bundle2.putBoolean("PARAM_FINDER_LIVE_POST_AFTER_FACE_VERIFY", true);
                        bVar.statusChange(cVar, bundle2);
                        k kVar = k.vkd;
                        k.a(s.ad.LIVE_PASS_VERIFIED_SUCC, str);
                        AppMethodBeat.o(246457);
                        return;
                    }
                }
            }
            k kVar2 = k.vkd;
            k.a(s.ad.LIVE_PASS_VERIFIED_FAIL, str);
            b.C0376b.a(this.hOp, b.c.hLy);
            ae aeVar = ae.vZW;
            ae.a(ae.dEc(), i3, 0, String.valueOf(bundle), getLiveData());
        }
        AppMethodBeat.o(246457);
    }
}

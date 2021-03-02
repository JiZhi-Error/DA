package com.tencent.mm.plugin.appbrand.jsapi.share;

import com.facebook.share.internal.ShareConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.n.c;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.share.ac;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.vfs.o;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0014¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/share/ShareVideoToConversationTask;", "Lcom/tencent/mm/plugin/appbrand/ipc/AppBrandProxyUIProcessTask;", "()V", "handleRequest", "", ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID, "Lcom/tencent/mm/plugin/appbrand/ipc/AppBrandProxyUIProcessTask$ProcessRequest;", "plugin-appbrand-integration_release"})
final class ad extends AppBrandProxyUIProcessTask {

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", "shareResult", "Lcom/tencent/mm/plugin/appbrand/jsapi/share/ShareResult;", "invoke"})
    static final class a extends q implements b<ab, x> {
        final /* synthetic */ ad mtj;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(ad adVar) {
            super(1);
            this.mtj = adVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(ab abVar) {
            AppMethodBeat.i(228572);
            ab abVar2 = abVar;
            p.h(abVar2, "shareResult");
            ad.a(this.mtj, new ShareToConversationResult(abVar2.msX));
            x xVar = x.SXb;
            AppMethodBeat.o(228572);
            return xVar;
        }
    }

    public static final /* synthetic */ void a(ad adVar, AppBrandProxyUIProcessTask.ProcessResult processResult) {
        AppMethodBeat.i(228574);
        adVar.b(processResult);
        AppMethodBeat.o(228574);
    }

    @Override // com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask
    public final void a(AppBrandProxyUIProcessTask.ProcessRequest processRequest) {
        AppMethodBeat.i(228573);
        if (!(processRequest instanceof ShareVideoToConversationRequest)) {
            Log.w("MicroMsg.AppBrand.JsApiShareVideoMessage", "handleRequest, request is not ShareVideoToConversationRequest");
            AppMethodBeat.o(228573);
            return;
        }
        if (((ShareVideoToConversationRequest) processRequest).videoPath.length() == 0) {
            Log.w("MicroMsg.AppBrand.JsApiShareVideoMessage", "handleRequest, fail since videoPath is empty");
            b(new ShareToConversationResult(ab.FAIL.msX));
            AppMethodBeat.o(228573);
            return;
        }
        ac acVar = ac.mta;
        MMActivity bDF = bDF();
        p.g(bDF, "activityContext");
        MMActivity mMActivity = bDF;
        String str = ((ShareVideoToConversationRequest) processRequest).videoPath;
        String str2 = ((ShareVideoToConversationRequest) processRequest).thumbPath;
        a aVar = new a(this);
        p.h(mMActivity, EnvConsts.ACTIVITY_MANAGER_SRVNAME);
        p.h(str, "videoPath");
        p.h(aVar, "shareCallBack");
        ac.a aVar2 = new ac.a(aVar, mMActivity, str, str2);
        o oVar = new o(str);
        Long valueOf = oVar.exists() ? Long.valueOf(oVar.length()) : null;
        Log.d("MicroMsg.AppBrand.JsApiShareVideoMessage", "isVideoLegal2Share, videoSize: ".concat(String.valueOf(valueOf)));
        if (valueOf == null || 0 >= valueOf.longValue()) {
            h.a(mMActivity, mMActivity.getString(R.string.dmn), "", mMActivity.getString(R.string.e2u), new ac.c(aVar2));
            AppMethodBeat.o(228573);
        } else if (((long) c.aqq()) < valueOf.longValue()) {
            h.a(mMActivity, mMActivity.getString(R.string.dn7), "", mMActivity.getString(R.string.e2u), new ac.d(aVar2));
            AppMethodBeat.o(228573);
        } else {
            aVar2.invoke(Boolean.TRUE);
            AppMethodBeat.o(228573);
        }
    }
}

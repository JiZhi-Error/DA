package com.tencent.mm.plugin.appbrand.jsapi.share;

import com.facebook.share.internal.ShareConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.n.c;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.db;
import com.tencent.mm.plugin.appbrand.jsapi.share.w;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.vfs.o;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0014¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/share/ShareFileToConversationTask;", "Lcom/tencent/mm/plugin/appbrand/ipc/AppBrandProxyUIProcessTask;", "()V", "handleRequest", "", ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID, "Lcom/tencent/mm/plugin/appbrand/ipc/AppBrandProxyUIProcessTask$ProcessRequest;", "plugin-appbrand-integration_release"})
final class x extends AppBrandProxyUIProcessTask {

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", "shareResult", "Lcom/tencent/mm/plugin/appbrand/jsapi/share/ShareResult;", "invoke"})
    static final class a extends q implements b<ab, kotlin.x> {
        final /* synthetic */ x msI;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(x xVar) {
            super(1);
            this.msI = xVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ kotlin.x invoke(ab abVar) {
            AppMethodBeat.i(228541);
            ab abVar2 = abVar;
            p.h(abVar2, "shareResult");
            x.a(this.msI, new ShareToConversationResult(abVar2.msX));
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(228541);
            return xVar;
        }
    }

    public static final /* synthetic */ void a(x xVar, AppBrandProxyUIProcessTask.ProcessResult processResult) {
        AppMethodBeat.i(228543);
        xVar.b(processResult);
        AppMethodBeat.o(228543);
    }

    @Override // com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask
    public final void a(AppBrandProxyUIProcessTask.ProcessRequest processRequest) {
        boolean z;
        AppMethodBeat.i(228542);
        if (!(processRequest instanceof ShareFileToConversationRequest)) {
            Log.w("MicroMsg.AppBrand.JsApiShareFileMessage", "handleRequest, request is not ShareFileToConversationRequest");
            AppMethodBeat.o(228542);
            return;
        }
        if (((ShareFileToConversationRequest) processRequest).filePath.length() == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            Log.w("MicroMsg.AppBrand.JsApiShareFileMessage", "handleRequest, fail since filePath is empty");
            b(new ShareToConversationResult(ab.FAIL.msX));
            AppMethodBeat.o(228542);
            return;
        }
        String D = db.D(((ShareFileToConversationRequest) processRequest).filePath, ((ShareFileToConversationRequest) processRequest).gCr, ((ShareFileToConversationRequest) processRequest).fileName);
        w wVar = w.msz;
        MMActivity bDF = bDF();
        p.g(bDF, "activityContext");
        MMActivity mMActivity = bDF;
        String str = ((ShareFileToConversationRequest) processRequest).filePath;
        a aVar = new a(this);
        p.h(mMActivity, EnvConsts.ACTIVITY_MANAGER_SRVNAME);
        p.h(str, "filePath");
        p.h(D, DownloadInfo.FILENAME);
        p.h(aVar, "shareCallBack");
        w.a aVar2 = new w.a(aVar, mMActivity, str, D);
        o oVar = new o(str);
        Long valueOf = oVar.exists() ? Long.valueOf(oVar.length()) : null;
        Log.d("MicroMsg.AppBrand.JsApiShareFileMessage", "isFileLegal2Share, fileSize: ".concat(String.valueOf(valueOf)));
        if (valueOf == null || 0 >= valueOf.longValue()) {
            h.a(mMActivity, mMActivity.getString(R.string.cc6), "", mMActivity.getString(R.string.e2u), new w.c(aVar2));
            AppMethodBeat.o(228542);
            return;
        }
        int aqr = c.aqr();
        if (((long) aqr) < valueOf.longValue()) {
            h.a(mMActivity, mMActivity.getString(R.string.a0o, new Object[]{Util.getSizeKB((long) aqr)}), "", mMActivity.getString(R.string.e2u), new w.d(aVar2));
            AppMethodBeat.o(228542);
            return;
        }
        aVar2.invoke(Boolean.TRUE);
        AppMethodBeat.o(228542);
    }
}

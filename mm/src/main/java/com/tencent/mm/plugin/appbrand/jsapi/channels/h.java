package com.tencent.mm.plugin.appbrand.jsapi.channels;

import com.facebook.share.internal.ShareConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask;
import com.tencent.mm.plugin.i.a.af;
import com.tencent.mm.plugin.i.a.aj;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0014¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/channels/OpenChannelsCreateContactTask;", "Lcom/tencent/mm/plugin/appbrand/ipc/AppBrandProxyUIProcessTask;", "()V", "handleRequest", "", ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID, "Lcom/tencent/mm/plugin/appbrand/ipc/AppBrandProxyUIProcessTask$ProcessRequest;", "plugin-appbrand-integration_release"})
final class h extends AppBrandProxyUIProcessTask {
    public static final /* synthetic */ void a(h hVar, AppBrandProxyUIProcessTask.ProcessResult processResult) {
        AppMethodBeat.i(261662);
        hVar.b(processResult);
        AppMethodBeat.o(261662);
    }

    @Override // com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask
    public final void a(AppBrandProxyUIProcessTask.ProcessRequest processRequest) {
        AppMethodBeat.i(261661);
        if (!(processRequest instanceof OpenChannelsCreateContactRequest)) {
            Log.w("MicroMsg.AppBrand.JsApiOpenChannelsCreateContact", "handleRequest#OpenChannelsCreateContactTask, request is not OpenChannelsCreateContactRequest");
            AppMethodBeat.o(261661);
            return;
        }
        aj ajVar = (aj) g.ah(aj.class);
        if (ajVar != null) {
            ajVar.openChannelsCreateContact(bDF(), new a(this));
            AppMethodBeat.o(261661);
            return;
        }
        AppMethodBeat.o(261661);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "", "kotlin.jvm.PlatformType", "onCallback", "(Ljava/lang/Boolean;)V"})
    static final class a<T> implements af.a<Boolean> {
        final /* synthetic */ h FTI;

        a(h hVar) {
            this.FTI = hVar;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.tencent.mm.plugin.i.a.af.a
        public final /* synthetic */ void bn(Boolean bool) {
            AppMethodBeat.i(261660);
            h.a(this.FTI, new EmptyResult());
            AppMethodBeat.o(261660);
        }
    }
}

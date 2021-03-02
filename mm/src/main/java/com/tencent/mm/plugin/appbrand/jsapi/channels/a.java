package com.tencent.mm.plugin.appbrand.jsapi.channels;

import com.facebook.share.internal.ShareConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask;
import com.tencent.mm.plugin.i.a.af;
import com.tencent.mm.plugin.i.a.aj;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0014¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/channels/EnterFinderTask;", "Lcom/tencent/mm/plugin/appbrand/ipc/AppBrandProxyUIProcessTask;", "()V", "handleRequest", "", ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID, "Lcom/tencent/mm/plugin/appbrand/ipc/AppBrandProxyUIProcessTask$ProcessRequest;", "plugin-appbrand-integration_release"})
final class a extends AppBrandProxyUIProcessTask {

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, hxF = {"<anonymous>", "", "ret", "", "kotlin.jvm.PlatformType", "onCallback", "(Ljava/lang/Integer;)V"})
    static final class b<T> implements af.a<Integer> {
        final /* synthetic */ a lRw;

        b(a aVar) {
            this.lRw = aVar;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.tencent.mm.plugin.i.a.af.a
        public final /* synthetic */ void bn(Integer num) {
            AppMethodBeat.i(228381);
            Integer num2 = num;
            a aVar = this.lRw;
            p.g(num2, "ret");
            a.a(aVar, new EnterFinderResult(num2.intValue()));
            AppMethodBeat.o(228381);
        }
    }

    public static final /* synthetic */ void a(a aVar, AppBrandProxyUIProcessTask.ProcessResult processResult) {
        AppMethodBeat.i(228383);
        aVar.b(processResult);
        AppMethodBeat.o(228383);
    }

    @Override // com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask
    public final void a(AppBrandProxyUIProcessTask.ProcessRequest processRequest) {
        AppMethodBeat.i(228382);
        if (!(processRequest instanceof EnterFinderRequest)) {
            Log.w("MicroMsg.AppBrand.JsApiOpenChannelsBase", "handleRequest#EnterFinderTask, request is not EnterFinderRequest");
            AppMethodBeat.o(228382);
            return;
        }
        aj ajVar = (aj) g.ah(aj.class);
        if (ajVar != null) {
            ajVar.enterFinderUIFromMiniApp(bDF(), ((EnterFinderRequest) processRequest).lRv, new C0655a(this), new b(this));
            AppMethodBeat.o(228382);
            return;
        }
        AppMethodBeat.o(228382);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "", "kotlin.jvm.PlatformType", "onCallback"})
    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.channels.a$a  reason: collision with other inner class name */
    static final class C0655a<T> implements af.a<Object> {
        final /* synthetic */ a lRw;

        C0655a(a aVar) {
            this.lRw = aVar;
        }

        @Override // com.tencent.mm.plugin.i.a.af.a
        public final void bn(Object obj) {
            AppMethodBeat.i(228380);
            a.a(this.lRw, new EnterFinderResult(0));
            AppMethodBeat.o(228380);
        }
    }
}

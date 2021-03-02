package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.plugin.appbrand.appcache.predownload.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J#\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00022\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\tH\u0002¨\u0006\n"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/TaskCallPredownload;", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;", "Lcom/tencent/mm/plugin/appbrand/jsapi/TaskParamsCallPredownload;", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "()V", "invoke", "", "data", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "plugin-appbrand-integration_release"})
final class dd implements com.tencent.mm.ipcinvoker.b<TaskParamsCallPredownload, IPCVoid> {
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, com.tencent.mm.ipcinvoker.d] */
    @Override // com.tencent.mm.ipcinvoker.b
    public final /* synthetic */ void invoke(TaskParamsCallPredownload taskParamsCallPredownload, d<IPCVoid> dVar) {
        AppMethodBeat.i(50422);
        TaskParamsCallPredownload taskParamsCallPredownload2 = taskParamsCallPredownload;
        if (taskParamsCallPredownload2 == null) {
            a.lCL.invoke();
            AppMethodBeat.o(50422);
            return;
        }
        MMHandlerThread.postToMainThread(new b(taskParamsCallPredownload2.username, taskParamsCallPredownload2.path, taskParamsCallPredownload2.scene));
        if (dVar != null) {
            dVar.bn(null);
            AppMethodBeat.o(50422);
            return;
        }
        AppMethodBeat.o(50422);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class b implements Runnable {
        final /* synthetic */ int $scene;
        final /* synthetic */ String hLl;
        final /* synthetic */ String lCM;

        b(String str, String str2, int i2) {
            this.hLl = str;
            this.lCM = str2;
            this.$scene = i2;
        }

        public final void run() {
            AppMethodBeat.i(50421);
            c.a(new c(this.hLl, this.lCM, this.$scene), true, 2);
            AppMethodBeat.o(50421);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class a extends q implements kotlin.g.a.a<x> {
        public static final a lCL = new a();

        static {
            AppMethodBeat.i(50420);
            AppMethodBeat.o(50420);
        }

        a() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(50419);
            Log.e("MicroMsg.AppBrand.JsApiPredownloadMiniProgramPackage", "invoke in mm, NULL data");
            x xVar = x.SXb;
            AppMethodBeat.o(50419);
            return xVar;
        }
    }
}

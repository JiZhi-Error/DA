package com.tencent.mm.plugin.multitask;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.b;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.protobuf.crt;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J%\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00022\u0010\u0010\t\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\nH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005XD¢\u0006\u0002\n\u0000¨\u0006\u000b"}, hxF = {"Lcom/tencent/mm/plugin/multitask/ReportTaskInfoTask;", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;", "Landroid/os/Bundle;", "()V", "TAG", "", "invoke", "", "data", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "plugin-multitask_release"})
public final class j implements b<Bundle, Bundle> {
    private final String TAG = "MicroMsg.MultiTask.ReportTaskInfoTask";

    public j() {
        AppMethodBeat.i(200345);
        Log.i(this.TAG, "create report task info");
        AppMethodBeat.o(200345);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, com.tencent.mm.ipcinvoker.d] */
    @Override // com.tencent.mm.ipcinvoker.b
    public final /* synthetic */ void invoke(Bundle bundle, d<Bundle> dVar) {
        AppMethodBeat.i(200344);
        Bundle bundle2 = bundle;
        if (bundle2 != null) {
            int i2 = bundle2.getInt("reporttype");
            byte[] byteArray = bundle2.getByteArray("reportdata");
            crt crt = new crt();
            if (byteArray != null) {
                try {
                    crt.parseFrom(byteArray);
                } catch (Exception e2) {
                    x xVar = x.SXb;
                }
            }
            ((PluginMultiTask) g.ah(PluginMultiTask.class)).reportInnerMultiTaskInfo(i2, crt);
            AppMethodBeat.o(200344);
            return;
        }
        AppMethodBeat.o(200344);
    }
}

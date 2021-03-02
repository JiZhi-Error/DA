package com.tencent.mm.plugin.multitask;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.b;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.protobuf.cru;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.s;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J%\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00022\u0010\u0010\t\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\nH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005XD¢\u0006\u0002\n\u0000¨\u0006\u000b"}, hxF = {"Lcom/tencent/mm/plugin/multitask/UpdateTaskInfoByTitleTask;", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;", "Landroid/os/Bundle;", "()V", "TAG", "", "invoke", "", "data", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "plugin-multitask_release"})
public final class k implements b<Bundle, Bundle> {
    private final String TAG = "MicroMsg.MultiTask.UpdateTaskInfoByTitleTask";

    public k() {
        AppMethodBeat.i(200347);
        Log.i(this.TAG, "create update task info by title");
        AppMethodBeat.o(200347);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, com.tencent.mm.ipcinvoker.d] */
    @Override // com.tencent.mm.ipcinvoker.b
    public final /* synthetic */ void invoke(Bundle bundle, d<Bundle> dVar) {
        String str;
        AppMethodBeat.i(200346);
        Bundle bundle2 = bundle;
        if (bundle2 != null) {
            String string = bundle2.getString("id");
            int i2 = bundle2.getInt("type");
            byte[] byteArray = bundle2.getByteArray("showData");
            if (!(string == null || byteArray == null)) {
                cru cru = new cru();
                try {
                    cru.parseFrom(byteArray);
                } catch (Exception e2) {
                }
                if (bundle2 == null || (str = bundle2.getString("path")) == null) {
                    str = "";
                }
                p.g(str, "data?.getString(\"path\") ?: \"\"");
                if (!Util.isNullOrNil(str)) {
                    h hVar = h.zZn;
                    String aGJ = h.aGJ(string);
                    if (s.YS(aGJ)) {
                        s.deleteFile(aGJ);
                    }
                    s.nx(str, aGJ);
                }
                ((PluginMultiTask) g.ah(PluginMultiTask.class)).updateTaskInfo(string, i2, cru, bundle2.getByteArray("data"));
            }
            AppMethodBeat.o(200346);
            return;
        }
        AppMethodBeat.o(200346);
    }
}

package com.tencent.mm.plugin.multitask;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.k;
import com.tencent.mm.ipcinvoker.type.IPCBoolean;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\u0011\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0002H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000¨\u0006\t"}, hxF = {"Lcom/tencent/mm/plugin/multitask/HasTaskInfo;", "Lcom/tencent/mm/ipcinvoker/IPCSyncInvokeTask;", "Lcom/tencent/mm/ipcinvoker/type/IPCString;", "Lcom/tencent/mm/ipcinvoker/type/IPCBoolean;", "()V", "TAG", "", "invoke", "id", "plugin-multitask_release"})
public final class c implements k<IPCString, IPCBoolean> {
    private final String TAG = "MicroMsg.MultiTask.GetTaskInfo";

    public c() {
        AppMethodBeat.i(200281);
        Log.i(this.TAG, "create has task info");
        AppMethodBeat.o(200281);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.tencent.mm.ipcinvoker.k
    public final /* synthetic */ IPCBoolean invoke(IPCString iPCString) {
        AppMethodBeat.i(200280);
        IPCString iPCString2 = iPCString;
        p.h(iPCString2, "id");
        String str = iPCString2.value;
        p.g(str, "id.value");
        IPCBoolean iPCBoolean = new IPCBoolean(((PluginMultiTask) g.ah(PluginMultiTask.class)).hasTaskInfoById(str));
        AppMethodBeat.o(200280);
        return iPCBoolean;
    }
}

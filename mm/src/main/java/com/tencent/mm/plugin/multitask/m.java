package com.tencent.mm.plugin.multitask;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.k;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\u0013\u0010\u0007\u001a\u00020\u00032\b\u0010\b\u001a\u0004\u0018\u00010\u0002H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000¨\u0006\t"}, hxF = {"Lcom/tencent/mm/plugin/multitask/getMultiTaskItemPosition;", "Lcom/tencent/mm/ipcinvoker/IPCSyncInvokeTask;", "Landroid/os/Bundle;", "Lcom/tencent/mm/ipcinvoker/type/IPCString;", "()V", "TAG", "", "invoke", "data", "plugin-multitask_release"})
public final class m implements k<Bundle, IPCString> {
    private final String TAG = "MicroMsg.MultiTask.getMultiTaskItemPosition";

    public m() {
        AppMethodBeat.i(200556);
        Log.i(this.TAG, "create multiTaskItemPosition");
        AppMethodBeat.o(200556);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.tencent.mm.ipcinvoker.k
    public final /* synthetic */ IPCString invoke(Bundle bundle) {
        String str;
        String string;
        int i2 = -1;
        AppMethodBeat.i(200555);
        Bundle bundle2 = bundle;
        if (bundle2 == null || (string = bundle2.getString("id")) == null) {
            str = "";
        } else {
            str = string;
        }
        p.g(str, "data?.getString(\"id\") ?: \"\"");
        int i3 = bundle2 != null ? bundle2.getInt("curPos") : -1;
        if (bundle2 != null) {
            i2 = bundle2.getInt("way");
        }
        IPCString iPCString = new IPCString(((PluginMultiTask) g.ah(PluginMultiTask.class)).getInnerMultiTaskItemPosition(str, i3, i2));
        AppMethodBeat.o(200555);
        return iPCString;
    }
}

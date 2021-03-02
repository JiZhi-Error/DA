package com.tencent.mm.plugin.taskbar;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.a.a.c;
import com.tencent.mm.av.q;
import com.tencent.mm.ipcinvoker.b;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.taskbar.ui.section.g;
import com.tencent.mm.protocal.protobuf.cru;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.s;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J%\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00022\u0010\u0010\t\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\nH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005XD¢\u0006\u0002\n\u0000¨\u0006\u000b"}, hxF = {"Lcom/tencent/mm/plugin/taskbar/AddOrUpdateTaskInfoTask;", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;", "Landroid/os/Bundle;", "()V", "TAG", "", "invoke", "", "data", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "plugin-taskbar_release"})
public final class a implements b<Bundle, Bundle> {
    private final String TAG = "MicroMsg.TaskBar.AddTaskInfoTask";

    public a() {
        AppMethodBeat.i(238390);
        Log.i(this.TAG, "create add task info");
        AppMethodBeat.o(238390);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, com.tencent.mm.ipcinvoker.d] */
    @Override // com.tencent.mm.ipcinvoker.b
    public final /* synthetic */ void invoke(Bundle bundle, d<Bundle> dVar) {
        String str;
        AppMethodBeat.i(238389);
        Bundle bundle2 = bundle;
        if (!g.aAc() || bundle2 == null) {
            AppMethodBeat.o(238389);
            return;
        }
        String string = bundle2.getString("id");
        int i2 = bundle2.getInt("type");
        byte[] byteArray = bundle2.getByteArray("showData");
        int i3 = bundle2.getInt("addType");
        boolean z = bundle2.getBoolean("updateBitmapOnly");
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
                f fVar = f.FSa;
                String aGJ = f.aGJ(string);
                if (s.YS(aGJ)) {
                    s.deleteFile(aGJ);
                }
                s.nx(str, aGJ);
                Log.i(this.TAG, "move tempPath:" + str + " to path:" + aGJ);
                g.a aVar = com.tencent.mm.plugin.taskbar.ui.section.g.FVL;
                if (g.a.axi(i2)) {
                    f fVar2 = f.FSa;
                    c cVar = e.Vbn;
                    p.g(cVar, "SNAPSHOT_LOADER_OPTION");
                    q.bcV().OR(f.f(aGJ, cVar));
                }
            }
            if (i3 == 1) {
                ((PluginTaskBar) com.tencent.mm.kernel.g.ah(PluginTaskBar.class)).addOrUpdateTaskInfo(string, i2, cru, bundle2.getByteArray("data"));
                AppMethodBeat.o(238389);
                return;
            } else if (i3 == 2) {
                ((PluginTaskBar) com.tencent.mm.kernel.g.ah(PluginTaskBar.class)).updateTaskInfo(string, i2, cru, bundle2.getByteArray("data"), z);
            }
        }
        AppMethodBeat.o(238389);
    }
}

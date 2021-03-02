package com.tencent.mm.plugin.finder.service;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.cgi.cg;
import com.tencent.mm.plugin.finder.conv.k;
import com.tencent.mm.plugin.finder.storage.ag;
import com.tencent.mm.plugin.i.a.aa;
import com.tencent.mm.protocal.protobuf.azj;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u000b\u001a\u00020\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006J,\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00122\b\u0010\u0014\u001a\u0004\u0018\u00010\u00042\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u0017"}, hxF = {"Lcom/tencent/mm/plugin/finder/service/FinderSessionStatusUpdater;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "TAG", "", "callback", "Lcom/tencent/mm/plugin/findersdk/api/IFinderSessionInfoService$SessionStatusCallback;", "getCallback", "()Lcom/tencent/mm/plugin/findersdk/api/IFinderSessionInfoService$SessionStatusCallback;", "setCallback", "(Lcom/tencent/mm/plugin/findersdk/api/IFinderSessionInfoService$SessionStatusCallback;)V", "doScene", "", "reqItems", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderMsgGetSessionReqItem;", "onSceneEnd", "errType", "", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "plugin-finder_release"})
public final class f implements i {
    static aa.b vwd;
    public static final f vwe = new f();

    static {
        AppMethodBeat.i(251487);
        AppMethodBeat.o(251487);
    }

    private f() {
    }

    @Override // com.tencent.mm.ak.i
    public final void onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(251486);
        g.azz().b(6218, this);
        Log.i("Finder.FinderSessionStatusUpdater", "errType " + i2 + ", errCode " + i3 + ", errMsg " + str);
        if (i2 == 0 && i3 == 0 && (qVar instanceof cg)) {
            aa.b bVar = vwd;
            if (bVar != null) {
                bVar.er(((cg) qVar).cZe());
            }
            LinkedList<azj> cZe = ((cg) qVar).cZe();
            if (cZe != null) {
                for (T t : cZe) {
                    Log.i("Finder.FinderSessionStatusUpdater", "sessionId:" + t.sessionId + " , reject:" + t.LJe + ", enableAction:" + t.LJf);
                    ag sessionInfoStorage = ((PluginFinder) g.ah(PluginFinder.class)).getSessionInfoStorage();
                    String str2 = t.sessionId;
                    p.g(str2, "it.sessionId");
                    int i4 = t.LJe;
                    int i5 = t.LJf;
                    p.h(str2, "sessionId");
                    k avz = sessionInfoStorage.avz(str2);
                    avz.field_rejectMsg = i4;
                    avz.field_actionPermission = i5;
                    if (sessionInfoStorage.updateNotify(avz, false, null)) {
                        sessionInfoStorage.vFa.remove(avz.field_talker);
                        sessionInfoStorage.vFb.remove(avz.field_sessionId);
                        sessionInfoStorage.doNotify(avz.field_sessionId);
                    }
                }
            }
        }
        vwd = null;
        AppMethodBeat.o(251486);
    }
}

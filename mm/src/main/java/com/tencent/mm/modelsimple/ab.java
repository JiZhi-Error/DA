package com.tencent.mm.modelsimple;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.z;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.ecr;
import com.tencent.mm.protocal.protobuf.ecs;
import com.tencent.mm.protocal.protobuf.ect;
import com.tencent.mm.protocal.protobuf.ecu;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.ca;
import java.util.HashSet;
import java.util.LinkedList;

public final class ab extends q implements m {
    private static HashSet<Long> jkA = new HashSet<>();
    private i callback;
    private final String dJw;
    private final d rr;

    static {
        AppMethodBeat.i(150959);
        AppMethodBeat.o(150959);
    }

    public static void av(String str, int i2) {
        AppMethodBeat.i(150951);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(150951);
        } else if (!g.aAf().azp() || (com.tencent.mm.model.ab.JE(str) && !com.tencent.mm.model.ab.IX(str))) {
            AppMethodBeat.o(150951);
        } else {
            g.aAg().hqi.a(new ab(str, i2, 0, (LinkedList<ecu>) null), 0);
            AppMethodBeat.o(150951);
        }
    }

    public static void ab(ca caVar) {
        AppMethodBeat.i(150952);
        g.aAi();
        if (!((Boolean) g.aAh().azQ().get(ar.a.USERINFO_WEIXIN_MUL_TERMINAL_AUTOSYNC_BOOLEAN, Boolean.TRUE)).booleanValue()) {
            Log.i("MicroMsg.NetSceneStatusNotify", "[MicroMsg.MultiTerminalSyncMgr]autoSyncState close");
            AppMethodBeat.o(150952);
        } else if (jkA.contains(Long.valueOf(caVar.field_msgId))) {
            Log.i("MicroMsg.NetSceneStatusNotify", "[MicroMsg.MultiTerminalSyncMgr]sendSyncMultiTerminalCmd: has send cmd: msgSvrId:%d, msgLocalId:%d", Long.valueOf(caVar.field_msgId), Long.valueOf(caVar.field_msgId));
            AppMethodBeat.o(150952);
        } else {
            jkA.add(Long.valueOf(caVar.field_msgId));
            if (!g.aAf().azp()) {
                AppMethodBeat.o(150952);
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("<![CDATA[<downloadList>");
            sb.append("<downloadItem>");
            sb.append("<username>");
            sb.append(caVar.field_talker);
            sb.append("</username>");
            sb.append("<msgsvrid>");
            sb.append(caVar.field_msgSvrId);
            sb.append("</msgsvrid>");
            sb.append("</downloadItem>");
            sb.append("</downloadList>]]>");
            String sb2 = sb.toString();
            Log.i("MicroMsg.NetSceneStatusNotify", "[MicroMsg.MultiTerminalSyncMgr]sendSyncMultiTerminalCmd:msgID:%d,  %s", Long.valueOf(caVar.field_msgId), sb);
            g.aAg().hqi.a(new ab(z.aTY(), 11, "DownloadFile", sb2), 0);
            AppMethodBeat.o(150952);
        }
    }

    public static void b(String str, int i2, String str2, String str3) {
        AppMethodBeat.i(150953);
        if (Util.isNullOrNil(str) || com.tencent.mm.model.ab.JE(str)) {
            AppMethodBeat.o(150953);
        } else if (!g.aAf().azp()) {
            AppMethodBeat.o(150953);
        } else {
            g.aAg().hqi.a(new ab(str, i2, str2, str3), 0);
            AppMethodBeat.o(150953);
        }
    }

    public static boolean bz(String str, String str2) {
        AppMethodBeat.i(223640);
        if (!g.aAf().azp()) {
            Log.e("MicroMsg.NetSceneStatusNotify", "sendHandOffSyncCmd fail due to account has not initialized");
            AppMethodBeat.o(223640);
            return false;
        } else if (!Util.isNullOrNil(str)) {
            g.aAg().hqi.a(new ab(z.aTY(), 11, str2, str), 0);
            AppMethodBeat.o(223640);
            return true;
        } else {
            AppMethodBeat.o(223640);
            return false;
        }
    }

    public ab(String str, int i2, int i3, LinkedList<ecu> linkedList) {
        AppMethodBeat.i(150955);
        this.dJw = str;
        d.a aVar = new d.a();
        aVar.iLN = new ecs();
        aVar.iLO = new ect();
        aVar.uri = "/cgi-bin/micromsg-bin/statusnotify";
        aVar.funcId = 251;
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        ecs ecs = (ecs) this.rr.iLK.iLR;
        ecs.xNH = z.aTY();
        ecs.NcY = i2;
        ecs.xNG = str;
        ecs.KIz = new StringBuilder().append(System.currentTimeMillis()).toString();
        if (linkedList != null && linkedList.size() == i3) {
            ecs.NcZ = i3;
            ecs.Nda.addAll(linkedList);
        }
        Log.d("MicroMsg.NetSceneStatusNotify", "summerstatus toUserName = " + str + " unreadChatListCount = " + ecs.Nda.size());
        AppMethodBeat.o(150955);
    }

    private ab(String str, int i2, String str2, String str3) {
        AppMethodBeat.i(150956);
        this.dJw = str;
        d.a aVar = new d.a();
        aVar.iLN = new ecs();
        aVar.iLO = new ect();
        aVar.uri = "/cgi-bin/micromsg-bin/statusnotify";
        aVar.funcId = 251;
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        ecs ecs = (ecs) this.rr.iLK.iLR;
        ecs.xNH = z.aTY();
        ecs.NcY = i2;
        ecs.xNG = str;
        ecs.KIz = new StringBuilder().append(System.currentTimeMillis()).toString();
        ecs.Ndb = new ecr();
        ecs.Ndb.Name = str2;
        ecs.Ndb.NcX = str3;
        AppMethodBeat.o(150956);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 251;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(com.tencent.mm.network.g gVar, i iVar) {
        AppMethodBeat.i(150957);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(150957);
        return dispatch;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(150958);
        if (!(i3 == 0 && i4 == 0)) {
            Log.d("MicroMsg.NetSceneStatusNotify", "StatusNotify Error. userName=" + this.dJw);
        }
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(150958);
    }
}

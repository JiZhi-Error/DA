package com.tencent.mm.plugin.forcenotify.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.cl;
import com.tencent.mm.plugin.forcenotify.d.a;
import com.tencent.mm.protocal.protobuf.bex;
import com.tencent.mm.protocal.protobuf.bno;
import com.tencent.mm.protocal.protobuf.bnp;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J4\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000e\u001a\u00020\u00022\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0014R\u0014\u0010\u0004\u001a\u00020\u0005XD¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, hxF = {"Lcom/tencent/mm/plugin/forcenotify/model/CgiGetForceNotifyInfoList;", "Lcom/tencent/mm/modelbase/Cgi;", "Lcom/tencent/mm/protocal/protobuf/GetForcePushResponse;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "onCgiBack", "", "errType", "", "errCode", "errMsg", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "plugin-force-notify_release"})
public final class c extends com.tencent.mm.ak.c<bnp> {
    private final String TAG = "MicroMsg.CgiGetForceNotifyInfoList";

    public c() {
        AppMethodBeat.i(149181);
        d.a aVar = new d.a();
        aVar.c(new bno());
        aVar.d(new bnp());
        aVar.MB("/cgi-bin/micromsg-bin/getforcepush");
        aVar.sG(com.tencent.mm.plugin.appbrand.jsapi.pay.l.CTRL_INDEX);
        aVar.sI(0);
        aVar.sJ(0);
        c(aVar.aXF());
        AppMethodBeat.o(149181);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, int, java.lang.String, com.tencent.mm.protocal.protobuf.dpc, com.tencent.mm.ak.q] */
    @Override // com.tencent.mm.ak.c
    public final /* synthetic */ void a(int i2, int i3, String str, bnp bnp, q qVar) {
        int i4;
        AppMethodBeat.i(149180);
        bnp bnp2 = bnp;
        p.h(bnp2, "resp");
        super.a(i2, i3, str, bnp2, qVar);
        if (!g.aAc()) {
            Log.e(this.TAG, "account nor ready");
            AppMethodBeat.o(149180);
            return;
        }
        Log.i(this.TAG, "CgiGetForceNotifyInfoList errType:%d, errCode:%d, errMsg:%s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        if (i2 == 0 && i3 == 0) {
            LinkedList<bex> linkedList = bnp2.LWc;
            if (linkedList != null) {
                Iterator<bex> it = linkedList.iterator();
                while (it.hasNext()) {
                    bex next = it.next();
                    d dVar = new d();
                    dVar.field_UserName = next.UserName;
                    dVar.field_ExpiredTime = ((long) next.KCC) * 1000;
                    dVar.field_CreateTime = ((long) next.CreateTime) * 1000;
                    if (cl.aWz() >= dVar.field_ExpiredTime) {
                        i4 = 0;
                    } else {
                        i4 = 1;
                    }
                    dVar.field_Status = i4;
                    dVar.field_ExtInfo = next.xNU;
                    dVar.field_Description = next.KHk;
                    dVar.field_UserIcon = next.LOD;
                    dVar.field_ForcePushId = next.KHi;
                    Log.i(this.TAG, "ret:%s item:%s", Boolean.valueOf(a.wLU.replace(dVar)), dVar);
                }
            }
            AppMethodBeat.o(149180);
            return;
        }
        Log.e(this.TAG, "report fail");
        AppMethodBeat.o(149180);
    }
}

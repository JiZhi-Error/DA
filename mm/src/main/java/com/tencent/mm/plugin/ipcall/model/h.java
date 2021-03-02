package com.tencent.mm.plugin.ipcall.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.kx;
import com.tencent.mm.protocal.protobuf.dfn;
import com.tencent.mm.protocal.protobuf.dfw;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import java.util.LinkedList;

public final class h extends IListener<kx> {
    public a ypb;

    public interface a {
        void a(dfn dfn);
    }

    public h() {
        AppMethodBeat.i(161381);
        this.__eventId = kx.class.getName().hashCode();
        AppMethodBeat.o(161381);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
    @Override // com.tencent.mm.sdk.event.IListener
    public final /* synthetic */ boolean callback(kx kxVar) {
        AppMethodBeat.i(25381);
        boolean a2 = a(kxVar);
        AppMethodBeat.o(25381);
        return a2;
    }

    private boolean a(kx kxVar) {
        AppMethodBeat.i(25380);
        if (kxVar instanceof kx) {
            byte[] bArr = kxVar.dPZ.dQa;
            if (bArr == null || bArr.length <= 0) {
                AppMethodBeat.o(25380);
                return false;
            } else if (bArr[0] == 101) {
                byte[] bArr2 = new byte[(bArr.length - 1)];
                System.arraycopy(bArr, 1, bArr2, 0, bArr2.length);
                try {
                    dfn dfn = (dfn) new dfn().parseFrom(bArr2);
                    Log.d("MicroMsg.IPCallSvrNotifyListener", "roomId: %d, roomKey: %d, DtmfPayloadType: %d", Integer.valueOf(dfn.LsZ), Long.valueOf(dfn.Lta), Integer.valueOf(dfn.yqb));
                    LinkedList<dfw> linkedList = dfn.MKx;
                    if (linkedList != null) {
                        Iterator<dfw> it = linkedList.iterator();
                        while (it.hasNext()) {
                            dfw next = it.next();
                            Log.d("MicroMsg.IPCallSvrNotifyListener", "userstatus: %d, userstatusKey: %d, memberId: %d", Integer.valueOf(next.MKH), Integer.valueOf(next.MKI), Integer.valueOf(next.MKG));
                        }
                    }
                    if (this.ypb != null) {
                        this.ypb.a(dfn);
                    }
                } catch (Exception e2) {
                    Log.e("MicroMsg.IPCallSvrNotifyListener", "parse PstnNotify error: %s", e2.getMessage());
                }
            }
        }
        AppMethodBeat.o(25380);
        return false;
    }
}

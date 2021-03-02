package com.tencent.mm.plugin.fav.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.afl;
import com.tencent.mm.protocal.protobuf.jw;
import com.tencent.mm.protocal.protobuf.jx;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.LinkedList;

public final class ah extends q implements m {
    private i callback = null;
    private final d rr;
    private LinkedList<Integer> tbl;
    private int tbm = 0;

    public ah(LinkedList<Integer> linkedList) {
        AppMethodBeat.i(103459);
        d.a aVar = new d.a();
        aVar.iLN = new jw();
        aVar.iLO = new jx();
        aVar.uri = "/cgi-bin/micromsg-bin/batchdelfavitem";
        aVar.funcId = 403;
        aVar.iLP = 194;
        aVar.respCmdId = 1000000194;
        this.rr = aVar.aXF();
        this.tbl = linkedList;
        AppMethodBeat.o(103459);
    }

    private boolean cVa() {
        boolean z;
        AppMethodBeat.i(103460);
        if (this.tbl == null || this.tbm >= this.tbl.size()) {
            z = false;
        } else {
            z = true;
        }
        Log.i("MicroMsg.NetSceneBatchDelFavItem", "check need continue, indexOK %B", Boolean.valueOf(z));
        AppMethodBeat.o(103460);
        return z;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        int i2;
        AppMethodBeat.i(103461);
        if (this.tbl == null || this.tbl.isEmpty() || this.tbm >= this.tbl.size()) {
            Log.e("MicroMsg.NetSceneBatchDelFavItem", "klem doScene idList null, begIndex %d", Integer.valueOf(this.tbm));
            AppMethodBeat.o(103461);
            return -1;
        }
        this.callback = iVar;
        Log.i("MicroMsg.NetSceneBatchDelFavItem", "ashutest::do netscene size %d, begIndex %d, total %s", Integer.valueOf(this.tbl.size()), Integer.valueOf(this.tbm), this.tbl);
        jw jwVar = (jw) this.rr.iLK.iLR;
        jwVar.KOn.clear();
        int i3 = 0;
        int i4 = this.tbm;
        while (i4 < this.tbl.size()) {
            int intValue = this.tbl.get(i4).intValue();
            if (intValue > 0) {
                jwVar.KOn.add(Integer.valueOf(intValue));
                i2 = i3 + 1;
            } else {
                i2 = i3;
            }
            if (i2 >= 20) {
                break;
            }
            i4++;
            i3 = i2;
        }
        this.tbm = i4 + 1;
        jwVar.oTz = jwVar.KOn.size();
        Log.i("MicroMsg.NetSceneBatchDelFavItem", "ashutest::do netscene checkd size %d, %s", Integer.valueOf(jwVar.oTz), jwVar.KOn);
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(103461);
        return dispatch;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(103462);
        Log.i("MicroMsg.NetSceneBatchDelFavItem", "netId %d errType %d errCode %d begIndex %d idListSize %d errMsg %s", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(this.tbm), Integer.valueOf(this.tbl.size()), str);
        if (i3 == 0 && i4 == 0) {
            LinkedList<afl> linkedList = ((jx) ((d) sVar).iLL.iLR).oTA;
            if (linkedList == null || linkedList.size() == 0) {
                Log.e("MicroMsg.NetSceneBatchDelFavItem", "klem onGYNet resp list null");
                if (cVa()) {
                    doScene(dispatcher(), this.callback);
                    AppMethodBeat.o(103462);
                    return;
                }
                this.callback.onSceneEnd(i3, i4, str, this);
                AppMethodBeat.o(103462);
                return;
            }
            ArrayList arrayList = new ArrayList();
            Log.i("MicroMsg.NetSceneBatchDelFavItem", "klem onGYNet respList size:%d", Integer.valueOf(linkedList.size()));
            for (int i5 = 0; i5 < linkedList.size(); i5++) {
                afl afl = linkedList.get(i5);
                if (afl.Ret < 0) {
                    Log.w("MicroMsg.NetSceneBatchDelFavItem", "klem onGYNet favId:%d, delete failed", Integer.valueOf(afl.KGZ));
                } else {
                    arrayList.add(Integer.valueOf(afl.KGZ));
                    Log.i("MicroMsg.NetSceneBatchDelFavItem", "klem onGYNet favId:%d deleted", Integer.valueOf(afl.KGZ));
                }
            }
            b.dC(arrayList);
            if (cVa()) {
                doScene(dispatcher(), this.callback);
                AppMethodBeat.o(103462);
                return;
            }
            this.callback.onSceneEnd(i3, i4, str, this);
            AppMethodBeat.o(103462);
        } else if (cVa()) {
            doScene(dispatcher(), this.callback);
            AppMethodBeat.o(103462);
        } else {
            this.callback.onSceneEnd(i3, i4, str, this);
            AppMethodBeat.o(103462);
        }
    }

    @Override // com.tencent.mm.ak.q
    public final q.b securityVerificationChecked(s sVar) {
        return q.b.EOk;
    }

    @Override // com.tencent.mm.ak.q
    public final int securityLimitCount() {
        return 10;
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 403;
    }
}

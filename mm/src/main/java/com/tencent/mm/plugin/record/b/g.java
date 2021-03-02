package com.tencent.mm.plugin.record.b;

import android.util.SparseArray;
import android.util.SparseBooleanArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.k;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.record.a.k;
import com.tencent.mm.protocal.protobuf.aml;
import com.tencent.mm.protocal.protobuf.eji;
import com.tencent.mm.protocal.protobuf.lj;
import com.tencent.mm.protocal.protobuf.lk;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import java.util.LinkedList;

public final class g extends q implements m {
    String BGE = "";
    k BGF = null;
    private SparseArray<aml> BGG = new SparseArray<>();
    private SparseBooleanArray BGH = new SparseBooleanArray();
    private i callback = null;
    private final d rr;
    private int tbm = 0;
    private int tbq = 0;

    public g(k kVar) {
        AppMethodBeat.i(9484);
        d.a aVar = new d.a();
        aVar.iLN = new lj();
        aVar.iLO = new lk();
        aVar.uri = "/cgi-bin/micromsg-bin/batchtranscdnitem";
        aVar.funcId = 632;
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        this.BGF = kVar;
        AppMethodBeat.o(9484);
    }

    private void eIo() {
        AppMethodBeat.i(9485);
        this.BGE = k.b.a(p.a(this.BGF.field_title, this.BGF.field_desc, this.BGF.field_dataProto), null, null);
        AppMethodBeat.o(9485);
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(9486);
        Log.i("MicroMsg.NetSceneTransCDN", "netId %d errType %d errCode %d localErrCode %d begIndex %d errMsg %s", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(this.tbq), Integer.valueOf(this.tbm), str);
        if (i3 == 3 && this.tbq == -100) {
            eIo();
            this.callback.onSceneEnd(0, 0, str, this);
            AppMethodBeat.o(9486);
        } else if (i3 == 0 && i4 == 0) {
            Iterator<eji> it = ((lk) ((d) sVar).iLL.iLR).oTA.iterator();
            while (it.hasNext()) {
                eji next = it.next();
                aml aml = this.BGG.get(next.NiR);
                if (aml != null) {
                    if (this.BGH.get(next.NiR)) {
                        Log.i("MicroMsg.NetSceneTransCDN", "trans end, client id[%d], dataId[%s], isThumb[true], old thumb url[%s], new thumb url[%s], old size[%d], new size[%d]", Integer.valueOf(next.NiR), aml.dLl, aml.iwX, next.KMl, Long.valueOf(aml.LvT), Long.valueOf(next.xui));
                        aml.bgh(next.KMl);
                        aml.bgi(next.AesKey);
                        if (Util.isNullOrNil(next.KMl) || Util.isNullOrNil(next.AesKey) || next.xui <= 0) {
                            Log.w("MicroMsg.NetSceneTransCDN", "match error server return");
                            i3 = 3;
                        } else {
                            aml.Mv(next.xui);
                        }
                    } else {
                        Log.i("MicroMsg.NetSceneTransCDN", "trans end, client id[%d], dataId[%s], isThumb[false], old url[%s], new url[%s], old size[%d], new size[%d]", Integer.valueOf(next.NiR), aml.dLl, aml.KuR, next.KMl, Long.valueOf(aml.LvI), Long.valueOf(next.xui));
                        aml.bgj(next.KMl);
                        aml.bgk(next.AesKey);
                        if (Util.isNullOrNil(next.KMl) || Util.isNullOrNil(next.AesKey) || next.xui <= 0) {
                            Log.w("MicroMsg.NetSceneTransCDN", "match error server return");
                            i3 = 3;
                        } else {
                            aml.Mu(next.xui);
                        }
                    }
                }
            }
            boolean z = this.tbm < this.BGF.field_dataProto.ppH.size();
            Log.i("MicroMsg.NetSceneTransCDN", "check need continue, indexOK %B", Boolean.valueOf(z));
            if (z ? doScene(dispatcher(), this.callback) == -100 : true) {
                Log.i("MicroMsg.NetSceneTransCDN", "do callback");
                eIo();
                this.callback.onSceneEnd(i3, i4, str, this);
            }
            AppMethodBeat.o(9486);
        } else {
            this.callback.onSceneEnd(i3, i4, str, this);
            AppMethodBeat.o(9486);
        }
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 632;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(com.tencent.mm.network.g gVar, i iVar) {
        boolean z;
        AppMethodBeat.i(9487);
        this.callback = iVar;
        lj ljVar = (lj) this.rr.iLK.iLR;
        this.BGG.clear();
        this.BGH.clear();
        if (this.BGF.field_dataProto.ppH.size() == 0) {
            Log.e("MicroMsg.NetSceneTransCDN", "doScene data list null");
            this.tbq = -100;
            AppMethodBeat.o(9487);
            return -100;
        }
        LinkedList linkedList = new LinkedList();
        int i2 = this.tbm;
        while (true) {
            if (i2 >= this.BGF.field_dataProto.ppH.size()) {
                break;
            }
            aml aml = this.BGF.field_dataProto.ppH.get(i2);
            if (aml.LvF && Util.isNullOrNil(aml.KuR)) {
                z = false;
                break;
            }
            if (!Util.isNullOrNil(aml.KuR)) {
                eji eji = new eji();
                eji.KMl = aml.KuR;
                eji.AesKey = aml.Lvp;
                eji.NiS = aml.dataType;
                eji.xui = (long) ((int) aml.LvI);
                eji.NiR = Util.nullAs(aml.dLl, "").hashCode();
                Log.d("MicroMsg.NetSceneTransCDN", "add cdnitem, clientID[%d] dataID[%s] datatype[%d] dataurl[%s] size[%d]", Integer.valueOf(eji.NiR), aml.dLl, Integer.valueOf(eji.NiS), aml.KuR, Long.valueOf(aml.LvI));
                linkedList.add(eji);
                this.BGG.put(eji.NiR, aml);
                this.BGH.put(eji.NiR, false);
            }
            if (!Util.isNullOrNil(aml.iwX)) {
                eji eji2 = new eji();
                eji2.KMl = aml.iwX;
                eji2.AesKey = aml.Lvk;
                eji2.NiS = 2;
                eji2.xui = (long) ((int) aml.LvT);
                eji2.NiR = (Util.nullAs(aml.dLl, "") + "@thumb").hashCode();
                Log.d("MicroMsg.NetSceneTransCDN", "add cdnitem, clientID[%d] thumbID[%s_t] datatype[%d] thumburl[%s] size[%d]", Integer.valueOf(eji2.NiR), aml.dLl, Integer.valueOf(eji2.NiS), aml.iwX, Long.valueOf(aml.LvT));
                linkedList.add(eji2);
                this.BGG.put(eji2.NiR, aml);
                this.BGH.put(eji2.NiR, true);
            }
            if (linkedList.size() >= 20) {
                break;
            }
            i2++;
        }
        z = true;
        this.tbm = i2 + 1;
        ljVar.oTz = linkedList.size();
        ljVar.oTA.clear();
        ljVar.oTA.addAll(linkedList);
        Log.i("MicroMsg.NetSceneTransCDN", "ashutest::data list size %d, need check size %d, nextIndex %d", Integer.valueOf(this.BGF.field_dataProto.ppH.size()), Integer.valueOf(this.BGG.size()), Integer.valueOf(this.tbm));
        if (ljVar.oTz <= 0 || !z) {
            eIo();
            Log.w("MicroMsg.NetSceneTransCDN", "doScene no more data");
            this.tbq = -100;
            AppMethodBeat.o(9487);
            return -100;
        }
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(9487);
        return dispatch;
    }

    @Override // com.tencent.mm.ak.q
    public final q.b securityVerificationChecked(s sVar) {
        return q.b.EOk;
    }

    @Override // com.tencent.mm.ak.q
    public final int securityLimitCount() {
        return 10;
    }
}

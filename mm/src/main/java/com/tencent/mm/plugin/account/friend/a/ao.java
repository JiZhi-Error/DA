package com.tencent.mm.plugin.account.friend.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.z;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.pluginsdk.b;
import com.tencent.mm.protocal.protobuf.cko;
import com.tencent.mm.protocal.protobuf.cpb;
import com.tencent.mm.protocal.protobuf.eno;
import com.tencent.mm.protocal.protobuf.enp;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class ao extends q implements m {
    private i callback;
    private int dKy;
    public final List<String> kfA;
    public final List<String> kfB;
    private final String kfC = ((String) g.aAh().azQ().get(6, (Object) null));
    private int kfD = 0;
    private int kfE = 0;

    public ao(List<String> list, List<String> list2) {
        AppMethodBeat.i(131148);
        this.kfA = list;
        this.kfB = list2;
        this.dKy = 1;
        AppMethodBeat.o(131148);
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(com.tencent.mm.network.g gVar, i iVar) {
        int i2 = 0;
        AppMethodBeat.i(131149);
        this.callback = iVar;
        if ((this.kfA == null || this.kfA.size() == 0) && (this.kfB == null || this.kfB.size() == 0)) {
            Log.i("MicroMsg.NetSceneUploadMContact", "listMobile or listEmile is null or zero");
            AppMethodBeat.o(131149);
            return -1;
        }
        d.a aVar = new d.a();
        aVar.iLN = new eno();
        aVar.iLO = new enp();
        aVar.uri = "/cgi-bin/micromsg-bin/uploadmcontact";
        aVar.funcId = 133;
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        d aXF = aVar.aXF();
        eno eno = (eno) aXF.iLK.iLR;
        eno.KPP = this.kfC;
        eno.UserName = z.aTY();
        eno.KMz = this.dKy;
        int i3 = 200;
        LinkedList<cpb> linkedList = new LinkedList<>();
        LinkedList<cko> linkedList2 = new LinkedList<>();
        while (i3 > 0) {
            if (this.kfA != null && this.kfD < this.kfA.size()) {
                if (this.kfA.get(this.kfD) != null) {
                    cpb cpb = new cpb();
                    cpb.v = this.kfA.get(this.kfD);
                    linkedList.add(cpb);
                }
                this.kfD++;
                i3--;
            }
            if (this.kfB != null && this.kfE < this.kfB.size()) {
                if (this.kfB.get(this.kfE) != null) {
                    cko cko = new cko();
                    cko.v = this.kfB.get(this.kfE);
                    linkedList2.add(cko);
                }
                this.kfE++;
                i3--;
            }
            if ((this.kfB == null || this.kfE >= this.kfB.size()) && (this.kfA == null || this.kfD >= this.kfA.size())) {
                break;
            }
        }
        eno.Mnw = linkedList;
        eno.Nlr = linkedList.size();
        eno.Nlt = linkedList2;
        eno.Nls = linkedList2.size();
        StringBuilder append = new StringBuilder("doscene in:[").append(this.kfB == null ? 0 : this.kfB.size()).append(",");
        if (this.kfA != null) {
            i2 = this.kfA.size();
        }
        Log.v("MicroMsg.NetSceneUploadMContact", append.append(i2).append("] index:[").append(this.kfE).append(",").append(this.kfD).append("] req:[").append(eno.Nlt.size()).append(",").append(eno.Mnw.size()).append("]").toString());
        int dispatch = dispatch(gVar, aXF, this);
        AppMethodBeat.o(131149);
        return dispatch;
    }

    @Override // com.tencent.mm.ak.q
    public final boolean uniqueInNetsceneQueue() {
        return true;
    }

    @Override // com.tencent.mm.ak.q
    public final q.b securityVerificationChecked(s sVar) {
        AppMethodBeat.i(131150);
        eno eno = (eno) ((d) sVar).iLK.iLR;
        int size = eno.Nlt.size() + eno.Mnw.size();
        if (size == 0 || size > 200) {
            Log.e("MicroMsg.NetSceneUploadMContact", "security checked failed : exceed max send count");
            q.b bVar = q.b.EFailed;
            AppMethodBeat.o(131150);
            return bVar;
        } else if (eno.KPP == null || eno.KPP.length() <= 0) {
            Log.e("MicroMsg.NetSceneUploadMContact", "security checked failed : moblie null");
            q.b bVar2 = q.b.EFailed;
            AppMethodBeat.o(131150);
            return bVar2;
        } else if (eno.UserName == null || eno.UserName.length() <= 0) {
            Log.e("MicroMsg.NetSceneUploadMContact", "security checked failed : username null");
            q.b bVar3 = q.b.EFailed;
            AppMethodBeat.o(131150);
            return bVar3;
        } else {
            q.b bVar4 = q.b.EOk;
            AppMethodBeat.o(131150);
            return bVar4;
        }
    }

    @Override // com.tencent.mm.ak.q
    public final int securityLimitCount() {
        return 10;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(131151);
        Log.i("MicroMsg.NetSceneUploadMContact", "onSceneEnd: errType = " + i3 + " errCode = " + i4 + " errMsg = " + str);
        updateDispatchId(i2);
        if (i3 == 0 && i4 == 0) {
            eno eno = (eno) ((d) sVar).iLK.iLR;
            l.aX(aZ(eno.Nlt));
            l.aX(ba(eno.Mnw));
            if ((this.kfB == null || this.kfE >= this.kfB.size()) && (this.kfA == null || this.kfD >= this.kfA.size())) {
                this.callback.onSceneEnd(i3, i4, str, this);
                AppMethodBeat.o(131151);
                return;
            }
            if (doScene(dispatcher(), this.callback) < 0) {
                this.callback.onSceneEnd(i3, i4, str, this);
            }
            AppMethodBeat.o(131151);
            return;
        }
        Log.e("MicroMsg.NetSceneUploadMContact", "onGYNetEnd  errType:" + i3 + " errCode:" + i4);
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(131151);
    }

    private static List<String> aZ(List<cko> list) {
        AppMethodBeat.i(131152);
        ArrayList arrayList = new ArrayList();
        if (list == null || list.size() == 0) {
            Log.i("MicroMsg.NetSceneUploadMContact", "the req emai list is empty");
            AppMethodBeat.o(131152);
            return arrayList;
        }
        for (cko cko : list) {
            arrayList.add(cko.v);
        }
        AppMethodBeat.o(131152);
        return arrayList;
    }

    private static List<String> ba(List<cpb> list) {
        AppMethodBeat.i(131153);
        ArrayList arrayList = new ArrayList();
        if (list == null || list.size() == 0) {
            Log.i("MicroMsg.NetSceneUploadMContact", "the req mobile list is empty");
            AppMethodBeat.o(131153);
            return arrayList;
        }
        for (cpb cpb : list) {
            arrayList.add(com.tencent.mm.b.g.getMessageDigest(b.Ts(cpb.v).getBytes()));
        }
        AppMethodBeat.o(131153);
        return arrayList;
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 133;
    }
}

package com.tencent.mm.plugin.multitalk.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.crn;
import com.tencent.mm.protocal.protobuf.cro;
import com.tencent.mm.sdk.platformtools.Log;

public final class y extends q implements m {
    private i callback;
    byte[] efs;
    int mCmdId;
    private final d rr;
    int rxu;

    public y(int i2, int i3, byte[] bArr) {
        String str;
        AppMethodBeat.i(114616);
        this.rxu = i2;
        this.mCmdId = i3;
        d.a aVar = new d.a();
        aVar.iLN = new crn();
        aVar.iLO = new cro();
        switch (i3) {
            case 1918:
                str = "/cgi-bin/qcwxmultitalk-bin/createtalkroom";
                break;
            case 1919:
                str = "/cgi-bin/qcwxmultitalk-bin/entertalkroom";
                break;
            case 1920:
            case 1921:
            case 1922:
            case 1923:
            case 1924:
            case 1925:
            case 1926:
            case 1930:
            case 1934:
            case 1936:
            default:
                str = "";
                break;
            case 1927:
                str = "/cgi-bin/qcwxmultitalk-bin/exittalkroom";
                break;
            case 1928:
                str = "/cgi-bin/qcwxmultitalk-bin/cancelcreatetalkroom";
                break;
            case 1929:
                str = "/cgi-bin/qcwxmultitalk-bin/rejectentertalkroom";
                break;
            case 1931:
                str = "/cgi-bin/qcwxmultitalk-bin/addmembers";
                break;
            case 1932:
                str = "/cgi-bin/qcwxmultitalk-bin/hellotalkroom";
                break;
            case 1933:
                str = "/cgi-bin/qcwxmultitalk-bin/miscinfo";
                break;
            case 1935:
                str = "/cgi-bin/qcwxmultitalk-bin/voiceackreq";
                break;
            case 1937:
                str = "/cgi-bin/qcwxmultitalk-bin/oiceredirectreq";
                break;
            case 1938:
                str = "/cgi-bin/qcwxmultitalk-bin/getgroupinfobatch";
                break;
            case 1939:
                str = "/cgi-bin/qcwxmultitalk-bin/memberwhisper";
                break;
        }
        Log.i("MicroMsg.MT.NetSceneMultiTalk", "netSceneMultiTalk cmdid %d cgiName %s", Integer.valueOf(i3), str);
        aVar.uri = str;
        aVar.funcId = this.mCmdId;
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        ((crn) this.rr.iLK.iLR).KMS = new SKBuiltinBuffer_t().setBuffer(bArr);
        AppMethodBeat.o(114616);
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(114617);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(114617);
        return dispatch;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(114618);
        Log.d("MicroMsg.MT.NetSceneMultiTalk", "onGYNetEnd  errType:" + i3 + " errCode:" + i4 + " " + this.mCmdId);
        this.efs = z.a(((cro) ((d) sVar).iLL.iLR).KMS);
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(114618);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return this.mCmdId;
    }
}

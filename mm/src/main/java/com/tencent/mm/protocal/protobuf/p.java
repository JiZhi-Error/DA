package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class p extends dpc {
    public int KBJ;
    public int dDN = 268513600;
    public int jTs;
    public int jTt;
    public int jTu;
    public long jTv;
    public long jTw;
    public String jTx;
    public String jTy;
    public String qwn = "请求不成功，请稍候再试";

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(91325);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                b bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(91325);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.ni(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            aVar.aM(2, this.dDN);
            if (this.qwn != null) {
                aVar.e(3, this.qwn);
            }
            aVar.aM(4, this.jTs);
            aVar.aM(5, this.jTt);
            aVar.aM(6, this.jTu);
            aVar.bb(7, this.jTv);
            aVar.bb(8, this.jTw);
            if (this.jTx != null) {
                aVar.e(9, this.jTx);
            }
            if (this.jTy != null) {
                aVar.e(10, this.jTy);
            }
            aVar.aM(11, this.KBJ);
            AppMethodBeat.o(91325);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.BaseResponse != null ? g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0 : 0) + g.a.a.b.b.a.bu(2, this.dDN);
            if (this.qwn != null) {
                nh += g.a.a.b.b.a.f(3, this.qwn);
            }
            int bu = nh + g.a.a.b.b.a.bu(4, this.jTs) + g.a.a.b.b.a.bu(5, this.jTt) + g.a.a.b.b.a.bu(6, this.jTu) + g.a.a.b.b.a.r(7, this.jTv) + g.a.a.b.b.a.r(8, this.jTw);
            if (this.jTx != null) {
                bu += g.a.a.b.b.a.f(9, this.jTx);
            }
            if (this.jTy != null) {
                bu += g.a.a.b.b.a.f(10, this.jTy);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(11, this.KBJ);
            AppMethodBeat.o(91325);
            return bu2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dpc.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dpc.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.BaseResponse == null) {
                b bVar2 = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(91325);
                throw bVar2;
            }
            AppMethodBeat.o(91325);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            p pVar = (p) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        BaseResponse baseResponse = new BaseResponse();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = baseResponse.populateBuilderWithField(aVar4, baseResponse, dpc.getNextFieldNumber(aVar4))) {
                        }
                        pVar.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(91325);
                    return 0;
                case 2:
                    pVar.dDN = aVar3.UbS.zi();
                    AppMethodBeat.o(91325);
                    return 0;
                case 3:
                    pVar.qwn = aVar3.UbS.readString();
                    AppMethodBeat.o(91325);
                    return 0;
                case 4:
                    pVar.jTs = aVar3.UbS.zi();
                    AppMethodBeat.o(91325);
                    return 0;
                case 5:
                    pVar.jTt = aVar3.UbS.zi();
                    AppMethodBeat.o(91325);
                    return 0;
                case 6:
                    pVar.jTu = aVar3.UbS.zi();
                    AppMethodBeat.o(91325);
                    return 0;
                case 7:
                    pVar.jTv = aVar3.UbS.zl();
                    AppMethodBeat.o(91325);
                    return 0;
                case 8:
                    pVar.jTw = aVar3.UbS.zl();
                    AppMethodBeat.o(91325);
                    return 0;
                case 9:
                    pVar.jTx = aVar3.UbS.readString();
                    AppMethodBeat.o(91325);
                    return 0;
                case 10:
                    pVar.jTy = aVar3.UbS.readString();
                    AppMethodBeat.o(91325);
                    return 0;
                case 11:
                    pVar.KBJ = aVar3.UbS.zi();
                    AppMethodBeat.o(91325);
                    return 0;
                default:
                    AppMethodBeat.o(91325);
                    return -1;
            }
        } else {
            AppMethodBeat.o(91325);
            return -1;
        }
    }
}

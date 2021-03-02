package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class cxk extends dpc {
    public int MBS;
    public int MBT;
    public String MBU;
    public String MBV;
    public int MBW;
    public int MBX;
    public int dDN;
    public String jTx;
    public String jTy;
    public String qwn;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(72539);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                b bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(72539);
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
            aVar.aM(4, this.MBS);
            aVar.aM(5, this.MBT);
            if (this.jTx != null) {
                aVar.e(6, this.jTx);
            }
            if (this.jTy != null) {
                aVar.e(7, this.jTy);
            }
            if (this.MBU != null) {
                aVar.e(8, this.MBU);
            }
            if (this.MBV != null) {
                aVar.e(9, this.MBV);
            }
            aVar.aM(10, this.MBW);
            aVar.aM(11, this.MBX);
            AppMethodBeat.o(72539);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.BaseResponse != null ? g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0 : 0) + g.a.a.b.b.a.bu(2, this.dDN);
            if (this.qwn != null) {
                nh += g.a.a.b.b.a.f(3, this.qwn);
            }
            int bu = nh + g.a.a.b.b.a.bu(4, this.MBS) + g.a.a.b.b.a.bu(5, this.MBT);
            if (this.jTx != null) {
                bu += g.a.a.b.b.a.f(6, this.jTx);
            }
            if (this.jTy != null) {
                bu += g.a.a.b.b.a.f(7, this.jTy);
            }
            if (this.MBU != null) {
                bu += g.a.a.b.b.a.f(8, this.MBU);
            }
            if (this.MBV != null) {
                bu += g.a.a.b.b.a.f(9, this.MBV);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(10, this.MBW) + g.a.a.b.b.a.bu(11, this.MBX);
            AppMethodBeat.o(72539);
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
                AppMethodBeat.o(72539);
                throw bVar2;
            }
            AppMethodBeat.o(72539);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            cxk cxk = (cxk) objArr[1];
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
                        cxk.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(72539);
                    return 0;
                case 2:
                    cxk.dDN = aVar3.UbS.zi();
                    AppMethodBeat.o(72539);
                    return 0;
                case 3:
                    cxk.qwn = aVar3.UbS.readString();
                    AppMethodBeat.o(72539);
                    return 0;
                case 4:
                    cxk.MBS = aVar3.UbS.zi();
                    AppMethodBeat.o(72539);
                    return 0;
                case 5:
                    cxk.MBT = aVar3.UbS.zi();
                    AppMethodBeat.o(72539);
                    return 0;
                case 6:
                    cxk.jTx = aVar3.UbS.readString();
                    AppMethodBeat.o(72539);
                    return 0;
                case 7:
                    cxk.jTy = aVar3.UbS.readString();
                    AppMethodBeat.o(72539);
                    return 0;
                case 8:
                    cxk.MBU = aVar3.UbS.readString();
                    AppMethodBeat.o(72539);
                    return 0;
                case 9:
                    cxk.MBV = aVar3.UbS.readString();
                    AppMethodBeat.o(72539);
                    return 0;
                case 10:
                    cxk.MBW = aVar3.UbS.zi();
                    AppMethodBeat.o(72539);
                    return 0;
                case 11:
                    cxk.MBX = aVar3.UbS.zi();
                    AppMethodBeat.o(72539);
                    return 0;
                default:
                    AppMethodBeat.o(72539);
                    return -1;
            }
        } else {
            AppMethodBeat.o(72539);
            return -1;
        }
    }
}

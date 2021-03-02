package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class dkk extends dpc {
    public b MBC;
    public int MBD;
    public int MBE;
    public String MBJ;
    public String MBK;
    public String MBL;
    public int MBM;
    public String MBO;
    public String pWf;
    public int yPI;
    public int yPJ;
    public String yPK;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(91662);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                g.a.a.b bVar = new g.a.a.b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(91662);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.ni(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            aVar.aM(2, this.MBD);
            if (this.yPK != null) {
                aVar.e(3, this.yPK);
            }
            if (this.MBK != null) {
                aVar.e(4, this.MBK);
            }
            if (this.MBL != null) {
                aVar.e(5, this.MBL);
            }
            if (this.MBC != null) {
                aVar.c(6, this.MBC);
            }
            aVar.aM(7, this.MBE);
            aVar.aM(8, this.yPI);
            aVar.aM(9, this.MBM);
            aVar.aM(10, this.yPJ);
            if (this.pWf != null) {
                aVar.e(11, this.pWf);
            }
            if (this.MBO != null) {
                aVar.e(12, this.MBO);
            }
            if (this.MBJ != null) {
                aVar.e(13, this.MBJ);
            }
            AppMethodBeat.o(91662);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.BaseResponse != null ? g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0 : 0) + g.a.a.b.b.a.bu(2, this.MBD);
            if (this.yPK != null) {
                nh += g.a.a.b.b.a.f(3, this.yPK);
            }
            if (this.MBK != null) {
                nh += g.a.a.b.b.a.f(4, this.MBK);
            }
            if (this.MBL != null) {
                nh += g.a.a.b.b.a.f(5, this.MBL);
            }
            if (this.MBC != null) {
                nh += g.a.a.b.b.a.b(6, this.MBC);
            }
            int bu = nh + g.a.a.b.b.a.bu(7, this.MBE) + g.a.a.b.b.a.bu(8, this.yPI) + g.a.a.b.b.a.bu(9, this.MBM) + g.a.a.b.b.a.bu(10, this.yPJ);
            if (this.pWf != null) {
                bu += g.a.a.b.b.a.f(11, this.pWf);
            }
            if (this.MBO != null) {
                bu += g.a.a.b.b.a.f(12, this.MBO);
            }
            if (this.MBJ != null) {
                bu += g.a.a.b.b.a.f(13, this.MBJ);
            }
            AppMethodBeat.o(91662);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dpc.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dpc.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.BaseResponse == null) {
                g.a.a.b bVar2 = new g.a.a.b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(91662);
                throw bVar2;
            }
            AppMethodBeat.o(91662);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            dkk dkk = (dkk) objArr[1];
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
                        dkk.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(91662);
                    return 0;
                case 2:
                    dkk.MBD = aVar3.UbS.zi();
                    AppMethodBeat.o(91662);
                    return 0;
                case 3:
                    dkk.yPK = aVar3.UbS.readString();
                    AppMethodBeat.o(91662);
                    return 0;
                case 4:
                    dkk.MBK = aVar3.UbS.readString();
                    AppMethodBeat.o(91662);
                    return 0;
                case 5:
                    dkk.MBL = aVar3.UbS.readString();
                    AppMethodBeat.o(91662);
                    return 0;
                case 6:
                    dkk.MBC = aVar3.UbS.hPo();
                    AppMethodBeat.o(91662);
                    return 0;
                case 7:
                    dkk.MBE = aVar3.UbS.zi();
                    AppMethodBeat.o(91662);
                    return 0;
                case 8:
                    dkk.yPI = aVar3.UbS.zi();
                    AppMethodBeat.o(91662);
                    return 0;
                case 9:
                    dkk.MBM = aVar3.UbS.zi();
                    AppMethodBeat.o(91662);
                    return 0;
                case 10:
                    dkk.yPJ = aVar3.UbS.zi();
                    AppMethodBeat.o(91662);
                    return 0;
                case 11:
                    dkk.pWf = aVar3.UbS.readString();
                    AppMethodBeat.o(91662);
                    return 0;
                case 12:
                    dkk.MBO = aVar3.UbS.readString();
                    AppMethodBeat.o(91662);
                    return 0;
                case 13:
                    dkk.MBJ = aVar3.UbS.readString();
                    AppMethodBeat.o(91662);
                    return 0;
                default:
                    AppMethodBeat.o(91662);
                    return -1;
            }
        } else {
            AppMethodBeat.o(91662);
            return -1;
        }
    }
}

package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class bvi extends dpc {
    public LinkedList<cbe> Mbs = new LinkedList<>();
    public String Mbt;
    public int Mbu;
    public LinkedList<String> Mbv = new LinkedList<>();
    public int Mbw;
    public long Mbx;
    public int VjM;
    public String VjN;
    public int dDN = 0;
    public String qwn = "ok";
    public String yUF;

    public bvi() {
        AppMethodBeat.i(91512);
        AppMethodBeat.o(91512);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(91513);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                b bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(91513);
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
            aVar.e(4, 8, this.Mbs);
            if (this.Mbt != null) {
                aVar.e(5, this.Mbt);
            }
            aVar.aM(6, this.Mbu);
            if (this.yUF != null) {
                aVar.e(7, this.yUF);
            }
            aVar.e(8, 1, this.Mbv);
            aVar.aM(9, this.Mbw);
            aVar.bb(10, this.Mbx);
            aVar.aM(11, this.VjM);
            if (this.VjN != null) {
                aVar.e(12, this.VjN);
            }
            AppMethodBeat.o(91513);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.BaseResponse != null ? g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0 : 0) + g.a.a.b.b.a.bu(2, this.dDN);
            if (this.qwn != null) {
                nh += g.a.a.b.b.a.f(3, this.qwn);
            }
            int c2 = nh + g.a.a.a.c(4, 8, this.Mbs);
            if (this.Mbt != null) {
                c2 += g.a.a.b.b.a.f(5, this.Mbt);
            }
            int bu = c2 + g.a.a.b.b.a.bu(6, this.Mbu);
            if (this.yUF != null) {
                bu += g.a.a.b.b.a.f(7, this.yUF);
            }
            int c3 = bu + g.a.a.a.c(8, 1, this.Mbv) + g.a.a.b.b.a.bu(9, this.Mbw) + g.a.a.b.b.a.r(10, this.Mbx) + g.a.a.b.b.a.bu(11, this.VjM);
            if (this.VjN != null) {
                c3 += g.a.a.b.b.a.f(12, this.VjN);
            }
            AppMethodBeat.o(91513);
            return c3;
        } else if (i2 == 2) {
            this.Mbs.clear();
            this.Mbv.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dpc.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dpc.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.BaseResponse == null) {
                b bVar2 = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(91513);
                throw bVar2;
            }
            AppMethodBeat.o(91513);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            bvi bvi = (bvi) objArr[1];
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
                        bvi.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(91513);
                    return 0;
                case 2:
                    bvi.dDN = aVar3.UbS.zi();
                    AppMethodBeat.o(91513);
                    return 0;
                case 3:
                    bvi.qwn = aVar3.UbS.readString();
                    AppMethodBeat.o(91513);
                    return 0;
                case 4:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        cbe cbe = new cbe();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = cbe.populateBuilderWithField(aVar5, cbe, dpc.getNextFieldNumber(aVar5))) {
                        }
                        bvi.Mbs.add(cbe);
                    }
                    AppMethodBeat.o(91513);
                    return 0;
                case 5:
                    bvi.Mbt = aVar3.UbS.readString();
                    AppMethodBeat.o(91513);
                    return 0;
                case 6:
                    bvi.Mbu = aVar3.UbS.zi();
                    AppMethodBeat.o(91513);
                    return 0;
                case 7:
                    bvi.yUF = aVar3.UbS.readString();
                    AppMethodBeat.o(91513);
                    return 0;
                case 8:
                    bvi.Mbv.add(aVar3.UbS.readString());
                    AppMethodBeat.o(91513);
                    return 0;
                case 9:
                    bvi.Mbw = aVar3.UbS.zi();
                    AppMethodBeat.o(91513);
                    return 0;
                case 10:
                    bvi.Mbx = aVar3.UbS.zl();
                    AppMethodBeat.o(91513);
                    return 0;
                case 11:
                    bvi.VjM = aVar3.UbS.zi();
                    AppMethodBeat.o(91513);
                    return 0;
                case 12:
                    bvi.VjN = aVar3.UbS.readString();
                    AppMethodBeat.o(91513);
                    return 0;
                default:
                    AppMethodBeat.o(91513);
                    return -1;
            }
        } else {
            AppMethodBeat.o(91513);
            return -1;
        }
    }
}

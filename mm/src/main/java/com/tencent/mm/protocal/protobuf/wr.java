package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class wr extends dpc {
    public String Cpg;
    public String LhF;
    public String LhI;
    public String LhK;
    public String LhL;
    public String LhO;
    public String LhP;
    public String LhQ;
    public LinkedList<Integer> Lhn = new LinkedList<>();
    public int Lhp;
    public String Lhz;
    public int dDN;
    public String desc;
    public String qwn;

    public wr() {
        AppMethodBeat.i(72440);
        AppMethodBeat.o(72440);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(72441);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                b bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(72441);
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
            if (this.LhF != null) {
                aVar.e(4, this.LhF);
            }
            aVar.e(5, 2, this.Lhn);
            if (this.desc != null) {
                aVar.e(6, this.desc);
            }
            if (this.LhO != null) {
                aVar.e(7, this.LhO);
            }
            if (this.Cpg != null) {
                aVar.e(8, this.Cpg);
            }
            if (this.LhI != null) {
                aVar.e(9, this.LhI);
            }
            if (this.LhK != null) {
                aVar.e(10, this.LhK);
            }
            if (this.LhL != null) {
                aVar.e(11, this.LhL);
            }
            aVar.aM(12, this.Lhp);
            if (this.Lhz != null) {
                aVar.e(13, this.Lhz);
            }
            if (this.LhP != null) {
                aVar.e(14, this.LhP);
            }
            if (this.LhQ != null) {
                aVar.e(15, this.LhQ);
            }
            AppMethodBeat.o(72441);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.BaseResponse != null ? g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0 : 0) + g.a.a.b.b.a.bu(2, this.dDN);
            if (this.qwn != null) {
                nh += g.a.a.b.b.a.f(3, this.qwn);
            }
            if (this.LhF != null) {
                nh += g.a.a.b.b.a.f(4, this.LhF);
            }
            int c2 = nh + g.a.a.a.c(5, 2, this.Lhn);
            if (this.desc != null) {
                c2 += g.a.a.b.b.a.f(6, this.desc);
            }
            if (this.LhO != null) {
                c2 += g.a.a.b.b.a.f(7, this.LhO);
            }
            if (this.Cpg != null) {
                c2 += g.a.a.b.b.a.f(8, this.Cpg);
            }
            if (this.LhI != null) {
                c2 += g.a.a.b.b.a.f(9, this.LhI);
            }
            if (this.LhK != null) {
                c2 += g.a.a.b.b.a.f(10, this.LhK);
            }
            if (this.LhL != null) {
                c2 += g.a.a.b.b.a.f(11, this.LhL);
            }
            int bu = c2 + g.a.a.b.b.a.bu(12, this.Lhp);
            if (this.Lhz != null) {
                bu += g.a.a.b.b.a.f(13, this.Lhz);
            }
            if (this.LhP != null) {
                bu += g.a.a.b.b.a.f(14, this.LhP);
            }
            if (this.LhQ != null) {
                bu += g.a.a.b.b.a.f(15, this.LhQ);
            }
            AppMethodBeat.o(72441);
            return bu;
        } else if (i2 == 2) {
            this.Lhn.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dpc.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dpc.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.BaseResponse == null) {
                b bVar2 = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(72441);
                throw bVar2;
            }
            AppMethodBeat.o(72441);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            wr wrVar = (wr) objArr[1];
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
                        wrVar.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(72441);
                    return 0;
                case 2:
                    wrVar.dDN = aVar3.UbS.zi();
                    AppMethodBeat.o(72441);
                    return 0;
                case 3:
                    wrVar.qwn = aVar3.UbS.readString();
                    AppMethodBeat.o(72441);
                    return 0;
                case 4:
                    wrVar.LhF = aVar3.UbS.readString();
                    AppMethodBeat.o(72441);
                    return 0;
                case 5:
                    wrVar.Lhn.add(Integer.valueOf(aVar3.UbS.zi()));
                    AppMethodBeat.o(72441);
                    return 0;
                case 6:
                    wrVar.desc = aVar3.UbS.readString();
                    AppMethodBeat.o(72441);
                    return 0;
                case 7:
                    wrVar.LhO = aVar3.UbS.readString();
                    AppMethodBeat.o(72441);
                    return 0;
                case 8:
                    wrVar.Cpg = aVar3.UbS.readString();
                    AppMethodBeat.o(72441);
                    return 0;
                case 9:
                    wrVar.LhI = aVar3.UbS.readString();
                    AppMethodBeat.o(72441);
                    return 0;
                case 10:
                    wrVar.LhK = aVar3.UbS.readString();
                    AppMethodBeat.o(72441);
                    return 0;
                case 11:
                    wrVar.LhL = aVar3.UbS.readString();
                    AppMethodBeat.o(72441);
                    return 0;
                case 12:
                    wrVar.Lhp = aVar3.UbS.zi();
                    AppMethodBeat.o(72441);
                    return 0;
                case 13:
                    wrVar.Lhz = aVar3.UbS.readString();
                    AppMethodBeat.o(72441);
                    return 0;
                case 14:
                    wrVar.LhP = aVar3.UbS.readString();
                    AppMethodBeat.o(72441);
                    return 0;
                case 15:
                    wrVar.LhQ = aVar3.UbS.readString();
                    AppMethodBeat.o(72441);
                    return 0;
                default:
                    AppMethodBeat.o(72441);
                    return -1;
            }
        } else {
            AppMethodBeat.o(72441);
            return -1;
        }
    }
}

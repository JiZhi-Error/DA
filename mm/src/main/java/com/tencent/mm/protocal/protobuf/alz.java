package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class alz extends dpc {
    public LinkedList<cgi> Lhs = new LinkedList<>();
    public dfb LuC;
    public String LuD;
    public String LuE;
    public String LuF;
    public String LuG;
    public float LuH;
    public String LuI;
    public int sPV;
    public String sPW;

    public alz() {
        AppMethodBeat.i(104361);
        AppMethodBeat.o(104361);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(104362);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                b bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(104362);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.ni(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            aVar.e(2, 8, this.Lhs);
            if (this.LuC != null) {
                aVar.ni(3, this.LuC.computeSize());
                this.LuC.writeFields(aVar);
            }
            if (this.LuD != null) {
                aVar.e(4, this.LuD);
            }
            if (this.LuE != null) {
                aVar.e(5, this.LuE);
            }
            if (this.LuF != null) {
                aVar.e(6, this.LuF);
            }
            if (this.LuG != null) {
                aVar.e(7, this.LuG);
            }
            aVar.E(8, this.LuH);
            aVar.aM(9, this.sPV);
            if (this.sPW != null) {
                aVar.e(10, this.sPW);
            }
            if (this.LuI != null) {
                aVar.e(11, this.LuI);
            }
            AppMethodBeat.o(104362);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.BaseResponse != null ? g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0 : 0) + g.a.a.a.c(2, 8, this.Lhs);
            if (this.LuC != null) {
                nh += g.a.a.a.nh(3, this.LuC.computeSize());
            }
            if (this.LuD != null) {
                nh += g.a.a.b.b.a.f(4, this.LuD);
            }
            if (this.LuE != null) {
                nh += g.a.a.b.b.a.f(5, this.LuE);
            }
            if (this.LuF != null) {
                nh += g.a.a.b.b.a.f(6, this.LuF);
            }
            if (this.LuG != null) {
                nh += g.a.a.b.b.a.f(7, this.LuG);
            }
            int fS = nh + g.a.a.b.b.a.fS(8) + 4 + g.a.a.b.b.a.bu(9, this.sPV);
            if (this.sPW != null) {
                fS += g.a.a.b.b.a.f(10, this.sPW);
            }
            if (this.LuI != null) {
                fS += g.a.a.b.b.a.f(11, this.LuI);
            }
            AppMethodBeat.o(104362);
            return fS;
        } else if (i2 == 2) {
            this.Lhs.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dpc.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dpc.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.BaseResponse == null) {
                b bVar2 = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(104362);
                throw bVar2;
            }
            AppMethodBeat.o(104362);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            alz alz = (alz) objArr[1];
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
                        alz.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(104362);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        cgi cgi = new cgi();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = cgi.populateBuilderWithField(aVar5, cgi, dpc.getNextFieldNumber(aVar5))) {
                        }
                        alz.Lhs.add(cgi);
                    }
                    AppMethodBeat.o(104362);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        dfb dfb = new dfb();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = dfb.populateBuilderWithField(aVar6, dfb, dpc.getNextFieldNumber(aVar6))) {
                        }
                        alz.LuC = dfb;
                    }
                    AppMethodBeat.o(104362);
                    return 0;
                case 4:
                    alz.LuD = aVar3.UbS.readString();
                    AppMethodBeat.o(104362);
                    return 0;
                case 5:
                    alz.LuE = aVar3.UbS.readString();
                    AppMethodBeat.o(104362);
                    return 0;
                case 6:
                    alz.LuF = aVar3.UbS.readString();
                    AppMethodBeat.o(104362);
                    return 0;
                case 7:
                    alz.LuG = aVar3.UbS.readString();
                    AppMethodBeat.o(104362);
                    return 0;
                case 8:
                    alz.LuH = Float.intBitsToFloat(aVar3.UbS.zm());
                    AppMethodBeat.o(104362);
                    return 0;
                case 9:
                    alz.sPV = aVar3.UbS.zi();
                    AppMethodBeat.o(104362);
                    return 0;
                case 10:
                    alz.sPW = aVar3.UbS.readString();
                    AppMethodBeat.o(104362);
                    return 0;
                case 11:
                    alz.LuI = aVar3.UbS.readString();
                    AppMethodBeat.o(104362);
                    return 0;
                default:
                    AppMethodBeat.o(104362);
                    return -1;
            }
        } else {
            AppMethodBeat.o(104362);
            return -1;
        }
    }
}

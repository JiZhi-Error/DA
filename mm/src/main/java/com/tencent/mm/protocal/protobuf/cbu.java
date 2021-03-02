package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class cbu extends dpc {
    public LinkedList<cbv> MhD = new LinkedList<>();
    public dbi MhE;
    public dpp MhF;
    public boolean MhG;
    public jh MhH;
    public int pTZ;
    public String pUa;

    public cbu() {
        AppMethodBeat.i(72502);
        AppMethodBeat.o(72502);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(72503);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                b bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(72503);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.ni(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            aVar.aM(2, this.pTZ);
            if (this.pUa != null) {
                aVar.e(3, this.pUa);
            }
            aVar.e(4, 8, this.MhD);
            if (this.MhE != null) {
                aVar.ni(5, this.MhE.computeSize());
                this.MhE.writeFields(aVar);
            }
            if (this.MhF != null) {
                aVar.ni(6, this.MhF.computeSize());
                this.MhF.writeFields(aVar);
            }
            aVar.cc(7, this.MhG);
            if (this.MhH != null) {
                aVar.ni(8, this.MhH.computeSize());
                this.MhH.writeFields(aVar);
            }
            AppMethodBeat.o(72503);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.BaseResponse != null ? g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0 : 0) + g.a.a.b.b.a.bu(2, this.pTZ);
            if (this.pUa != null) {
                nh += g.a.a.b.b.a.f(3, this.pUa);
            }
            int c2 = nh + g.a.a.a.c(4, 8, this.MhD);
            if (this.MhE != null) {
                c2 += g.a.a.a.nh(5, this.MhE.computeSize());
            }
            if (this.MhF != null) {
                c2 += g.a.a.a.nh(6, this.MhF.computeSize());
            }
            int fS = c2 + g.a.a.b.b.a.fS(7) + 1;
            if (this.MhH != null) {
                fS += g.a.a.a.nh(8, this.MhH.computeSize());
            }
            AppMethodBeat.o(72503);
            return fS;
        } else if (i2 == 2) {
            this.MhD.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dpc.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dpc.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.BaseResponse == null) {
                b bVar2 = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(72503);
                throw bVar2;
            }
            AppMethodBeat.o(72503);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            cbu cbu = (cbu) objArr[1];
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
                        cbu.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(72503);
                    return 0;
                case 2:
                    cbu.pTZ = aVar3.UbS.zi();
                    AppMethodBeat.o(72503);
                    return 0;
                case 3:
                    cbu.pUa = aVar3.UbS.readString();
                    AppMethodBeat.o(72503);
                    return 0;
                case 4:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        cbv cbv = new cbv();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = cbv.populateBuilderWithField(aVar5, cbv, dpc.getNextFieldNumber(aVar5))) {
                        }
                        cbu.MhD.add(cbv);
                    }
                    AppMethodBeat.o(72503);
                    return 0;
                case 5:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        dbi dbi = new dbi();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = dbi.populateBuilderWithField(aVar6, dbi, dpc.getNextFieldNumber(aVar6))) {
                        }
                        cbu.MhE = dbi;
                    }
                    AppMethodBeat.o(72503);
                    return 0;
                case 6:
                    LinkedList<byte[]> awh4 = aVar3.awh(intValue);
                    int size4 = awh4.size();
                    for (int i6 = 0; i6 < size4; i6++) {
                        dpp dpp = new dpp();
                        g.a.a.a.a aVar7 = new g.a.a.a.a(awh4.get(i6), unknownTagHandler);
                        for (boolean z4 = true; z4; z4 = dpp.populateBuilderWithField(aVar7, dpp, dpc.getNextFieldNumber(aVar7))) {
                        }
                        cbu.MhF = dpp;
                    }
                    AppMethodBeat.o(72503);
                    return 0;
                case 7:
                    cbu.MhG = aVar3.UbS.yZ();
                    AppMethodBeat.o(72503);
                    return 0;
                case 8:
                    LinkedList<byte[]> awh5 = aVar3.awh(intValue);
                    int size5 = awh5.size();
                    for (int i7 = 0; i7 < size5; i7++) {
                        jh jhVar = new jh();
                        g.a.a.a.a aVar8 = new g.a.a.a.a(awh5.get(i7), unknownTagHandler);
                        for (boolean z5 = true; z5; z5 = jhVar.populateBuilderWithField(aVar8, jhVar, dpc.getNextFieldNumber(aVar8))) {
                        }
                        cbu.MhH = jhVar;
                    }
                    AppMethodBeat.o(72503);
                    return 0;
                default:
                    AppMethodBeat.o(72503);
                    return -1;
            }
        } else {
            AppMethodBeat.o(72503);
            return -1;
        }
    }
}

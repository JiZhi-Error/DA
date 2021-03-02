package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class dah extends dpc {
    public int HZp;
    public int MFA;
    public LinkedList<dye> MFB = new LinkedList<>();
    public dak MFx;
    public czw MFy;
    public LinkedList<czv> MFz = new LinkedList<>();
    public int rBL;
    public String rBM;

    public dah() {
        AppMethodBeat.i(91591);
        AppMethodBeat.o(91591);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(91592);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                b bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(91592);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.ni(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            aVar.aM(2, this.rBL);
            if (this.rBM != null) {
                aVar.e(3, this.rBM);
            }
            if (this.MFx != null) {
                aVar.ni(4, this.MFx.computeSize());
                this.MFx.writeFields(aVar);
            }
            if (this.MFy != null) {
                aVar.ni(5, this.MFy.computeSize());
                this.MFy.writeFields(aVar);
            }
            aVar.e(6, 8, this.MFz);
            aVar.aM(7, this.MFA);
            aVar.e(8, 8, this.MFB);
            aVar.aM(9, this.HZp);
            AppMethodBeat.o(91592);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.BaseResponse != null ? g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0 : 0) + g.a.a.b.b.a.bu(2, this.rBL);
            if (this.rBM != null) {
                nh += g.a.a.b.b.a.f(3, this.rBM);
            }
            if (this.MFx != null) {
                nh += g.a.a.a.nh(4, this.MFx.computeSize());
            }
            if (this.MFy != null) {
                nh += g.a.a.a.nh(5, this.MFy.computeSize());
            }
            int c2 = nh + g.a.a.a.c(6, 8, this.MFz) + g.a.a.b.b.a.bu(7, this.MFA) + g.a.a.a.c(8, 8, this.MFB) + g.a.a.b.b.a.bu(9, this.HZp);
            AppMethodBeat.o(91592);
            return c2;
        } else if (i2 == 2) {
            this.MFz.clear();
            this.MFB.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dpc.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dpc.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.BaseResponse == null) {
                b bVar2 = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(91592);
                throw bVar2;
            }
            AppMethodBeat.o(91592);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            dah dah = (dah) objArr[1];
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
                        dah.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(91592);
                    return 0;
                case 2:
                    dah.rBL = aVar3.UbS.zi();
                    AppMethodBeat.o(91592);
                    return 0;
                case 3:
                    dah.rBM = aVar3.UbS.readString();
                    AppMethodBeat.o(91592);
                    return 0;
                case 4:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        dak dak = new dak();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = dak.populateBuilderWithField(aVar5, dak, dpc.getNextFieldNumber(aVar5))) {
                        }
                        dah.MFx = dak;
                    }
                    AppMethodBeat.o(91592);
                    return 0;
                case 5:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        czw czw = new czw();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = czw.populateBuilderWithField(aVar6, czw, dpc.getNextFieldNumber(aVar6))) {
                        }
                        dah.MFy = czw;
                    }
                    AppMethodBeat.o(91592);
                    return 0;
                case 6:
                    LinkedList<byte[]> awh4 = aVar3.awh(intValue);
                    int size4 = awh4.size();
                    for (int i6 = 0; i6 < size4; i6++) {
                        czv czv = new czv();
                        g.a.a.a.a aVar7 = new g.a.a.a.a(awh4.get(i6), unknownTagHandler);
                        for (boolean z4 = true; z4; z4 = czv.populateBuilderWithField(aVar7, czv, dpc.getNextFieldNumber(aVar7))) {
                        }
                        dah.MFz.add(czv);
                    }
                    AppMethodBeat.o(91592);
                    return 0;
                case 7:
                    dah.MFA = aVar3.UbS.zi();
                    AppMethodBeat.o(91592);
                    return 0;
                case 8:
                    LinkedList<byte[]> awh5 = aVar3.awh(intValue);
                    int size5 = awh5.size();
                    for (int i7 = 0; i7 < size5; i7++) {
                        dye dye = new dye();
                        g.a.a.a.a aVar8 = new g.a.a.a.a(awh5.get(i7), unknownTagHandler);
                        for (boolean z5 = true; z5; z5 = dye.populateBuilderWithField(aVar8, dye, dpc.getNextFieldNumber(aVar8))) {
                        }
                        dah.MFB.add(dye);
                    }
                    AppMethodBeat.o(91592);
                    return 0;
                case 9:
                    dah.HZp = aVar3.UbS.zi();
                    AppMethodBeat.o(91592);
                    return 0;
                default:
                    AppMethodBeat.o(91592);
                    return -1;
            }
        } else {
            AppMethodBeat.o(91592);
            return -1;
        }
    }
}

package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class akw extends dpc {
    public akz LtF;
    public akt LtG;
    public aku LtH;
    public String LtI;
    public int LtJ;
    public int LtK;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(32202);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                b bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(32202);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.ni(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            if (this.LtF != null) {
                aVar.ni(2, this.LtF.computeSize());
                this.LtF.writeFields(aVar);
            }
            if (this.LtG != null) {
                aVar.ni(3, this.LtG.computeSize());
                this.LtG.writeFields(aVar);
            }
            if (this.LtH != null) {
                aVar.ni(4, this.LtH.computeSize());
                this.LtH.writeFields(aVar);
            }
            if (this.LtI != null) {
                aVar.e(5, this.LtI);
            }
            aVar.aM(6, this.LtJ);
            aVar.aM(7, this.LtK);
            AppMethodBeat.o(32202);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BaseResponse != null ? g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0 : 0;
            if (this.LtF != null) {
                nh += g.a.a.a.nh(2, this.LtF.computeSize());
            }
            if (this.LtG != null) {
                nh += g.a.a.a.nh(3, this.LtG.computeSize());
            }
            if (this.LtH != null) {
                nh += g.a.a.a.nh(4, this.LtH.computeSize());
            }
            if (this.LtI != null) {
                nh += g.a.a.b.b.a.f(5, this.LtI);
            }
            int bu = nh + g.a.a.b.b.a.bu(6, this.LtJ) + g.a.a.b.b.a.bu(7, this.LtK);
            AppMethodBeat.o(32202);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dpc.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dpc.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.BaseResponse == null) {
                b bVar2 = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(32202);
                throw bVar2;
            }
            AppMethodBeat.o(32202);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            akw akw = (akw) objArr[1];
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
                        akw.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(32202);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        akz akz = new akz();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = akz.populateBuilderWithField(aVar5, akz, dpc.getNextFieldNumber(aVar5))) {
                        }
                        akw.LtF = akz;
                    }
                    AppMethodBeat.o(32202);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        akt akt = new akt();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = akt.populateBuilderWithField(aVar6, akt, dpc.getNextFieldNumber(aVar6))) {
                        }
                        akw.LtG = akt;
                    }
                    AppMethodBeat.o(32202);
                    return 0;
                case 4:
                    LinkedList<byte[]> awh4 = aVar3.awh(intValue);
                    int size4 = awh4.size();
                    for (int i6 = 0; i6 < size4; i6++) {
                        aku aku = new aku();
                        g.a.a.a.a aVar7 = new g.a.a.a.a(awh4.get(i6), unknownTagHandler);
                        for (boolean z4 = true; z4; z4 = aku.populateBuilderWithField(aVar7, aku, dpc.getNextFieldNumber(aVar7))) {
                        }
                        akw.LtH = aku;
                    }
                    AppMethodBeat.o(32202);
                    return 0;
                case 5:
                    akw.LtI = aVar3.UbS.readString();
                    AppMethodBeat.o(32202);
                    return 0;
                case 6:
                    akw.LtJ = aVar3.UbS.zi();
                    AppMethodBeat.o(32202);
                    return 0;
                case 7:
                    akw.LtK = aVar3.UbS.zi();
                    AppMethodBeat.o(32202);
                    return 0;
                default:
                    AppMethodBeat.o(32202);
                    return -1;
            }
        } else {
            AppMethodBeat.o(32202);
            return -1;
        }
    }
}

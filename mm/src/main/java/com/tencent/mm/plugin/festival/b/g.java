package com.tencent.mm.plugin.festival.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.dpc;
import g.a.a.c.a;
import java.util.LinkedList;

public final class g extends dpc {
    public b GaF;
    public boolean UAQ;
    public LinkedList<c> UAR = new LinkedList<>();
    public LinkedList<c> UAS = new LinkedList<>();
    public LinkedList<h> UAT = new LinkedList<>();
    public e UAU;
    public LinkedList<c> UAV = new LinkedList<>();
    public LinkedList<j> UAW = new LinkedList<>();
    public LinkedList<i> UAX = new LinkedList<>();
    public LinkedList<String> UAY = new LinkedList<>();
    public int UAZ;
    public String UAt;
    public String UAx;

    public g() {
        AppMethodBeat.i(261972);
        AppMethodBeat.o(261972);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(261973);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse != null) {
                aVar.ni(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            if (this.GaF != null) {
                aVar.c(2, this.GaF);
            }
            aVar.cc(3, this.UAQ);
            aVar.e(4, 8, this.UAR);
            aVar.e(5, 8, this.UAS);
            aVar.e(6, 8, this.UAT);
            if (this.UAU != null) {
                aVar.ni(7, this.UAU.computeSize());
                this.UAU.writeFields(aVar);
            }
            aVar.e(8, 8, this.UAV);
            aVar.e(9, 8, this.UAW);
            if (this.UAt != null) {
                aVar.e(10, this.UAt);
            }
            aVar.e(11, 8, this.UAX);
            if (this.UAx != null) {
                aVar.e(12, this.UAx);
            }
            aVar.e(13, 1, this.UAY);
            aVar.aM(14, this.UAZ);
            AppMethodBeat.o(261973);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BaseResponse != null ? g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0 : 0;
            if (this.GaF != null) {
                nh += g.a.a.b.b.a.b(2, this.GaF);
            }
            int fS = nh + g.a.a.b.b.a.fS(3) + 1 + g.a.a.a.c(4, 8, this.UAR) + g.a.a.a.c(5, 8, this.UAS) + g.a.a.a.c(6, 8, this.UAT);
            if (this.UAU != null) {
                fS += g.a.a.a.nh(7, this.UAU.computeSize());
            }
            int c2 = fS + g.a.a.a.c(8, 8, this.UAV) + g.a.a.a.c(9, 8, this.UAW);
            if (this.UAt != null) {
                c2 += g.a.a.b.b.a.f(10, this.UAt);
            }
            int c3 = c2 + g.a.a.a.c(11, 8, this.UAX);
            if (this.UAx != null) {
                c3 += g.a.a.b.b.a.f(12, this.UAx);
            }
            int c4 = c3 + g.a.a.a.c(13, 1, this.UAY) + g.a.a.b.b.a.bu(14, this.UAZ);
            AppMethodBeat.o(261973);
            return c4;
        } else if (i2 == 2) {
            this.UAR.clear();
            this.UAS.clear();
            this.UAT.clear();
            this.UAV.clear();
            this.UAW.clear();
            this.UAX.clear();
            this.UAY.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dpc.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dpc.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(261973);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            g gVar = (g) objArr[1];
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
                        gVar.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(261973);
                    return 0;
                case 2:
                    gVar.GaF = aVar3.UbS.hPo();
                    AppMethodBeat.o(261973);
                    return 0;
                case 3:
                    gVar.UAQ = aVar3.UbS.yZ();
                    AppMethodBeat.o(261973);
                    return 0;
                case 4:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        c cVar = new c();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = cVar.populateBuilderWithField(aVar5, cVar, dpc.getNextFieldNumber(aVar5))) {
                        }
                        gVar.UAR.add(cVar);
                    }
                    AppMethodBeat.o(261973);
                    return 0;
                case 5:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        c cVar2 = new c();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = cVar2.populateBuilderWithField(aVar6, cVar2, dpc.getNextFieldNumber(aVar6))) {
                        }
                        gVar.UAS.add(cVar2);
                    }
                    AppMethodBeat.o(261973);
                    return 0;
                case 6:
                    LinkedList<byte[]> awh4 = aVar3.awh(intValue);
                    int size4 = awh4.size();
                    for (int i6 = 0; i6 < size4; i6++) {
                        h hVar = new h();
                        g.a.a.a.a aVar7 = new g.a.a.a.a(awh4.get(i6), unknownTagHandler);
                        for (boolean z4 = true; z4; z4 = hVar.populateBuilderWithField(aVar7, hVar, dpc.getNextFieldNumber(aVar7))) {
                        }
                        gVar.UAT.add(hVar);
                    }
                    AppMethodBeat.o(261973);
                    return 0;
                case 7:
                    LinkedList<byte[]> awh5 = aVar3.awh(intValue);
                    int size5 = awh5.size();
                    for (int i7 = 0; i7 < size5; i7++) {
                        e eVar = new e();
                        g.a.a.a.a aVar8 = new g.a.a.a.a(awh5.get(i7), unknownTagHandler);
                        for (boolean z5 = true; z5; z5 = eVar.populateBuilderWithField(aVar8, eVar, dpc.getNextFieldNumber(aVar8))) {
                        }
                        gVar.UAU = eVar;
                    }
                    AppMethodBeat.o(261973);
                    return 0;
                case 8:
                    LinkedList<byte[]> awh6 = aVar3.awh(intValue);
                    int size6 = awh6.size();
                    for (int i8 = 0; i8 < size6; i8++) {
                        c cVar3 = new c();
                        g.a.a.a.a aVar9 = new g.a.a.a.a(awh6.get(i8), unknownTagHandler);
                        for (boolean z6 = true; z6; z6 = cVar3.populateBuilderWithField(aVar9, cVar3, dpc.getNextFieldNumber(aVar9))) {
                        }
                        gVar.UAV.add(cVar3);
                    }
                    AppMethodBeat.o(261973);
                    return 0;
                case 9:
                    LinkedList<byte[]> awh7 = aVar3.awh(intValue);
                    int size7 = awh7.size();
                    for (int i9 = 0; i9 < size7; i9++) {
                        j jVar = new j();
                        g.a.a.a.a aVar10 = new g.a.a.a.a(awh7.get(i9), unknownTagHandler);
                        for (boolean z7 = true; z7; z7 = jVar.populateBuilderWithField(aVar10, jVar, dpc.getNextFieldNumber(aVar10))) {
                        }
                        gVar.UAW.add(jVar);
                    }
                    AppMethodBeat.o(261973);
                    return 0;
                case 10:
                    gVar.UAt = aVar3.UbS.readString();
                    AppMethodBeat.o(261973);
                    return 0;
                case 11:
                    LinkedList<byte[]> awh8 = aVar3.awh(intValue);
                    int size8 = awh8.size();
                    for (int i10 = 0; i10 < size8; i10++) {
                        i iVar = new i();
                        g.a.a.a.a aVar11 = new g.a.a.a.a(awh8.get(i10), unknownTagHandler);
                        for (boolean z8 = true; z8; z8 = iVar.populateBuilderWithField(aVar11, iVar, dpc.getNextFieldNumber(aVar11))) {
                        }
                        gVar.UAX.add(iVar);
                    }
                    AppMethodBeat.o(261973);
                    return 0;
                case 12:
                    gVar.UAx = aVar3.UbS.readString();
                    AppMethodBeat.o(261973);
                    return 0;
                case 13:
                    gVar.UAY.add(aVar3.UbS.readString());
                    AppMethodBeat.o(261973);
                    return 0;
                case 14:
                    gVar.UAZ = aVar3.UbS.zi();
                    AppMethodBeat.o(261973);
                    return 0;
                default:
                    AppMethodBeat.o(261973);
                    return -1;
            }
        } else {
            AppMethodBeat.o(261973);
            return -1;
        }
    }
}

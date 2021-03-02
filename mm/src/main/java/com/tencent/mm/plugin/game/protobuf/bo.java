package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.dpc;
import g.a.a.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class bo extends dpc {
    public ap xLJ;
    public as xLK;
    public at xLL;
    public cl xLM;
    public eg xLN;
    public ax xLO;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(41767);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                b bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(41767);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.ni(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            if (this.xLJ != null) {
                aVar.ni(3, this.xLJ.computeSize());
                this.xLJ.writeFields(aVar);
            }
            if (this.xLK != null) {
                aVar.ni(4, this.xLK.computeSize());
                this.xLK.writeFields(aVar);
            }
            if (this.xLL != null) {
                aVar.ni(5, this.xLL.computeSize());
                this.xLL.writeFields(aVar);
            }
            if (this.xLM != null) {
                aVar.ni(6, this.xLM.computeSize());
                this.xLM.writeFields(aVar);
            }
            if (this.xLN != null) {
                aVar.ni(8, this.xLN.computeSize());
                this.xLN.writeFields(aVar);
            }
            if (this.xLO != null) {
                aVar.ni(9, this.xLO.computeSize());
                this.xLO.writeFields(aVar);
            }
            AppMethodBeat.o(41767);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BaseResponse != null ? g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0 : 0;
            if (this.xLJ != null) {
                nh += g.a.a.a.nh(3, this.xLJ.computeSize());
            }
            if (this.xLK != null) {
                nh += g.a.a.a.nh(4, this.xLK.computeSize());
            }
            if (this.xLL != null) {
                nh += g.a.a.a.nh(5, this.xLL.computeSize());
            }
            if (this.xLM != null) {
                nh += g.a.a.a.nh(6, this.xLM.computeSize());
            }
            if (this.xLN != null) {
                nh += g.a.a.a.nh(8, this.xLN.computeSize());
            }
            if (this.xLO != null) {
                nh += g.a.a.a.nh(9, this.xLO.computeSize());
            }
            AppMethodBeat.o(41767);
            return nh;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dpc.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dpc.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.BaseResponse == null) {
                b bVar2 = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(41767);
                throw bVar2;
            }
            AppMethodBeat.o(41767);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            bo boVar = (bo) objArr[1];
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
                        boVar.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(41767);
                    return 0;
                case 2:
                case 7:
                default:
                    AppMethodBeat.o(41767);
                    return -1;
                case 3:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        ap apVar = new ap();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = apVar.populateBuilderWithField(aVar5, apVar, dpc.getNextFieldNumber(aVar5))) {
                        }
                        boVar.xLJ = apVar;
                    }
                    AppMethodBeat.o(41767);
                    return 0;
                case 4:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        as asVar = new as();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = asVar.populateBuilderWithField(aVar6, asVar, dpc.getNextFieldNumber(aVar6))) {
                        }
                        boVar.xLK = asVar;
                    }
                    AppMethodBeat.o(41767);
                    return 0;
                case 5:
                    LinkedList<byte[]> awh4 = aVar3.awh(intValue);
                    int size4 = awh4.size();
                    for (int i6 = 0; i6 < size4; i6++) {
                        at atVar = new at();
                        g.a.a.a.a aVar7 = new g.a.a.a.a(awh4.get(i6), unknownTagHandler);
                        for (boolean z4 = true; z4; z4 = atVar.populateBuilderWithField(aVar7, atVar, dpc.getNextFieldNumber(aVar7))) {
                        }
                        boVar.xLL = atVar;
                    }
                    AppMethodBeat.o(41767);
                    return 0;
                case 6:
                    LinkedList<byte[]> awh5 = aVar3.awh(intValue);
                    int size5 = awh5.size();
                    for (int i7 = 0; i7 < size5; i7++) {
                        cl clVar = new cl();
                        g.a.a.a.a aVar8 = new g.a.a.a.a(awh5.get(i7), unknownTagHandler);
                        for (boolean z5 = true; z5; z5 = clVar.populateBuilderWithField(aVar8, clVar, dpc.getNextFieldNumber(aVar8))) {
                        }
                        boVar.xLM = clVar;
                    }
                    AppMethodBeat.o(41767);
                    return 0;
                case 8:
                    LinkedList<byte[]> awh6 = aVar3.awh(intValue);
                    int size6 = awh6.size();
                    for (int i8 = 0; i8 < size6; i8++) {
                        eg egVar = new eg();
                        g.a.a.a.a aVar9 = new g.a.a.a.a(awh6.get(i8), unknownTagHandler);
                        for (boolean z6 = true; z6; z6 = egVar.populateBuilderWithField(aVar9, egVar, dpc.getNextFieldNumber(aVar9))) {
                        }
                        boVar.xLN = egVar;
                    }
                    AppMethodBeat.o(41767);
                    return 0;
                case 9:
                    LinkedList<byte[]> awh7 = aVar3.awh(intValue);
                    int size7 = awh7.size();
                    for (int i9 = 0; i9 < size7; i9++) {
                        ax axVar = new ax();
                        g.a.a.a.a aVar10 = new g.a.a.a.a(awh7.get(i9), unknownTagHandler);
                        for (boolean z7 = true; z7; z7 = axVar.populateBuilderWithField(aVar10, axVar, dpc.getNextFieldNumber(aVar10))) {
                        }
                        boVar.xLO = axVar;
                    }
                    AppMethodBeat.o(41767);
                    return 0;
            }
        } else {
            AppMethodBeat.o(41767);
            return -1;
        }
    }
}

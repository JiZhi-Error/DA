package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class asu extends dpc {
    public LinkedList<avn> LDL = new LinkedList<>();
    public LinkedList<avn> LDM = new LinkedList<>();
    public long LDN;
    public int LDO;
    public int LDP;
    public avn LDQ;
    public int UQp;
    public int UQq;
    public b ViG;
    public long hyH;

    public asu() {
        AppMethodBeat.i(209425);
        AppMethodBeat.o(209425);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(209426);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse != null) {
                aVar.ni(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            aVar.e(2, 8, this.LDL);
            aVar.bb(3, this.hyH);
            aVar.e(4, 8, this.LDM);
            aVar.bb(5, this.LDN);
            aVar.aM(6, this.LDO);
            aVar.aM(7, this.LDP);
            if (this.LDQ != null) {
                aVar.ni(8, this.LDQ.computeSize());
                this.LDQ.writeFields(aVar);
            }
            if (this.ViG != null) {
                aVar.c(9, this.ViG);
            }
            aVar.aM(10, this.UQp);
            aVar.aM(11, this.UQq);
            AppMethodBeat.o(209426);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.BaseResponse != null ? g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0 : 0) + g.a.a.a.c(2, 8, this.LDL) + g.a.a.b.b.a.r(3, this.hyH) + g.a.a.a.c(4, 8, this.LDM) + g.a.a.b.b.a.r(5, this.LDN) + g.a.a.b.b.a.bu(6, this.LDO) + g.a.a.b.b.a.bu(7, this.LDP);
            if (this.LDQ != null) {
                nh += g.a.a.a.nh(8, this.LDQ.computeSize());
            }
            if (this.ViG != null) {
                nh += g.a.a.b.b.a.b(9, this.ViG);
            }
            int bu = nh + g.a.a.b.b.a.bu(10, this.UQp) + g.a.a.b.b.a.bu(11, this.UQq);
            AppMethodBeat.o(209426);
            return bu;
        } else if (i2 == 2) {
            this.LDL.clear();
            this.LDM.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dpc.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dpc.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(209426);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            asu asu = (asu) objArr[1];
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
                        asu.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(209426);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        avn avn = new avn();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = avn.populateBuilderWithField(aVar5, avn, dpc.getNextFieldNumber(aVar5))) {
                        }
                        asu.LDL.add(avn);
                    }
                    AppMethodBeat.o(209426);
                    return 0;
                case 3:
                    asu.hyH = aVar3.UbS.zl();
                    AppMethodBeat.o(209426);
                    return 0;
                case 4:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        avn avn2 = new avn();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = avn2.populateBuilderWithField(aVar6, avn2, dpc.getNextFieldNumber(aVar6))) {
                        }
                        asu.LDM.add(avn2);
                    }
                    AppMethodBeat.o(209426);
                    return 0;
                case 5:
                    asu.LDN = aVar3.UbS.zl();
                    AppMethodBeat.o(209426);
                    return 0;
                case 6:
                    asu.LDO = aVar3.UbS.zi();
                    AppMethodBeat.o(209426);
                    return 0;
                case 7:
                    asu.LDP = aVar3.UbS.zi();
                    AppMethodBeat.o(209426);
                    return 0;
                case 8:
                    LinkedList<byte[]> awh4 = aVar3.awh(intValue);
                    int size4 = awh4.size();
                    for (int i6 = 0; i6 < size4; i6++) {
                        avn avn3 = new avn();
                        g.a.a.a.a aVar7 = new g.a.a.a.a(awh4.get(i6), unknownTagHandler);
                        for (boolean z4 = true; z4; z4 = avn3.populateBuilderWithField(aVar7, avn3, dpc.getNextFieldNumber(aVar7))) {
                        }
                        asu.LDQ = avn3;
                    }
                    AppMethodBeat.o(209426);
                    return 0;
                case 9:
                    asu.ViG = aVar3.UbS.hPo();
                    AppMethodBeat.o(209426);
                    return 0;
                case 10:
                    asu.UQp = aVar3.UbS.zi();
                    AppMethodBeat.o(209426);
                    return 0;
                case 11:
                    asu.UQq = aVar3.UbS.zi();
                    AppMethodBeat.o(209426);
                    return 0;
                default:
                    AppMethodBeat.o(209426);
                    return -1;
            }
        } else {
            AppMethodBeat.o(209426);
            return -1;
        }
    }
}

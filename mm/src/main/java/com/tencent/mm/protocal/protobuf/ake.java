package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.a;
import e.a.a.i;
import java.util.LinkedList;

public final class ake extends dpc {
    public LinkedList<i> Ltm = new LinkedList<>();
    public int Ltn;
    public a Lto;
    public int pTZ;
    public String pUa;

    public ake() {
        AppMethodBeat.i(91444);
        AppMethodBeat.o(91444);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(91445);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.BaseResponse != null) {
                aVar.ni(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            aVar.aM(2, this.pTZ);
            if (this.pUa != null) {
                aVar.e(3, this.pUa);
            }
            aVar.e(4, 8, this.Ltm);
            aVar.aM(5, this.Ltn);
            if (this.Lto != null) {
                aVar.ni(6, this.Lto.computeSize());
                this.Lto.writeFields(aVar);
            }
            AppMethodBeat.o(91445);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.BaseResponse != null ? g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0 : 0) + g.a.a.b.b.a.bu(2, this.pTZ);
            if (this.pUa != null) {
                nh += g.a.a.b.b.a.f(3, this.pUa);
            }
            int c2 = nh + g.a.a.a.c(4, 8, this.Ltm) + g.a.a.b.b.a.bu(5, this.Ltn);
            if (this.Lto != null) {
                c2 += g.a.a.a.nh(6, this.Lto.computeSize());
            }
            AppMethodBeat.o(91445);
            return c2;
        } else if (i2 == 2) {
            this.Ltm.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dpc.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dpc.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(91445);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            ake ake = (ake) objArr[1];
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
                        ake.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(91445);
                    return 0;
                case 2:
                    ake.pTZ = aVar3.UbS.zi();
                    AppMethodBeat.o(91445);
                    return 0;
                case 3:
                    ake.pUa = aVar3.UbS.readString();
                    AppMethodBeat.o(91445);
                    return 0;
                case 4:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        i iVar = new i();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = iVar.populateBuilderWithField(aVar5, iVar, dpc.getNextFieldNumber(aVar5))) {
                        }
                        ake.Ltm.add(iVar);
                    }
                    AppMethodBeat.o(91445);
                    return 0;
                case 5:
                    ake.Ltn = aVar3.UbS.zi();
                    AppMethodBeat.o(91445);
                    return 0;
                case 6:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        a aVar6 = new a();
                        g.a.a.a.a aVar7 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = aVar6.populateBuilderWithField(aVar7, aVar6, dpc.getNextFieldNumber(aVar7))) {
                        }
                        ake.Lto = aVar6;
                    }
                    AppMethodBeat.o(91445);
                    return 0;
                default:
                    AppMethodBeat.o(91445);
                    return -1;
            }
        } else {
            AppMethodBeat.o(91445);
            return -1;
        }
    }
}

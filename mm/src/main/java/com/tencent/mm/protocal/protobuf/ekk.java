package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.c.a;
import java.util.LinkedList;

public final class ekk extends dpc {
    public LinkedList<cfz> NjC = new LinkedList<>();
    public cfl Njs;
    public int Nju;
    public int pTZ;
    public String pUa;

    public ekk() {
        AppMethodBeat.i(72610);
        AppMethodBeat.o(72610);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(72611);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse != null) {
                aVar.ni(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            aVar.aM(2, this.pTZ);
            if (this.pUa != null) {
                aVar.e(3, this.pUa);
            }
            aVar.aM(4, this.Nju);
            aVar.e(5, 8, this.NjC);
            if (this.Njs != null) {
                aVar.ni(6, this.Njs.computeSize());
                this.Njs.writeFields(aVar);
            }
            AppMethodBeat.o(72611);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.BaseResponse != null ? g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0 : 0) + g.a.a.b.b.a.bu(2, this.pTZ);
            if (this.pUa != null) {
                nh += g.a.a.b.b.a.f(3, this.pUa);
            }
            int bu = nh + g.a.a.b.b.a.bu(4, this.Nju) + g.a.a.a.c(5, 8, this.NjC);
            if (this.Njs != null) {
                bu += g.a.a.a.nh(6, this.Njs.computeSize());
            }
            AppMethodBeat.o(72611);
            return bu;
        } else if (i2 == 2) {
            this.NjC.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dpc.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dpc.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(72611);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            ekk ekk = (ekk) objArr[1];
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
                        ekk.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(72611);
                    return 0;
                case 2:
                    ekk.pTZ = aVar3.UbS.zi();
                    AppMethodBeat.o(72611);
                    return 0;
                case 3:
                    ekk.pUa = aVar3.UbS.readString();
                    AppMethodBeat.o(72611);
                    return 0;
                case 4:
                    ekk.Nju = aVar3.UbS.zi();
                    AppMethodBeat.o(72611);
                    return 0;
                case 5:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        cfz cfz = new cfz();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = cfz.populateBuilderWithField(aVar5, cfz, dpc.getNextFieldNumber(aVar5))) {
                        }
                        ekk.NjC.add(cfz);
                    }
                    AppMethodBeat.o(72611);
                    return 0;
                case 6:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        cfl cfl = new cfl();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = cfl.populateBuilderWithField(aVar6, cfl, dpc.getNextFieldNumber(aVar6))) {
                        }
                        ekk.Njs = cfl;
                    }
                    AppMethodBeat.o(72611);
                    return 0;
                default:
                    AppMethodBeat.o(72611);
                    return -1;
            }
        } else {
            AppMethodBeat.o(72611);
            return -1;
        }
    }
}

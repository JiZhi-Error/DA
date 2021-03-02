package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class edr extends dpc {
    public int KCC;
    public String MZg;
    public int NaG;
    public long NdN;
    public int NdX;
    public LinkedList<edp> NdY = new LinkedList<>();

    public edr() {
        AppMethodBeat.i(118450);
        AppMethodBeat.o(118450);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(118451);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                b bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(118451);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.ni(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            if (this.MZg != null) {
                aVar.e(2, this.MZg);
            }
            aVar.aM(3, this.NdX);
            aVar.e(4, 8, this.NdY);
            aVar.aM(5, this.NaG);
            aVar.bb(6, this.NdN);
            aVar.aM(7, this.KCC);
            AppMethodBeat.o(118451);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BaseResponse != null ? g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0 : 0;
            if (this.MZg != null) {
                nh += g.a.a.b.b.a.f(2, this.MZg);
            }
            int bu = nh + g.a.a.b.b.a.bu(3, this.NdX) + g.a.a.a.c(4, 8, this.NdY) + g.a.a.b.b.a.bu(5, this.NaG) + g.a.a.b.b.a.r(6, this.NdN) + g.a.a.b.b.a.bu(7, this.KCC);
            AppMethodBeat.o(118451);
            return bu;
        } else if (i2 == 2) {
            this.NdY.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dpc.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dpc.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.BaseResponse == null) {
                b bVar2 = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(118451);
                throw bVar2;
            }
            AppMethodBeat.o(118451);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            edr edr = (edr) objArr[1];
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
                        edr.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(118451);
                    return 0;
                case 2:
                    edr.MZg = aVar3.UbS.readString();
                    AppMethodBeat.o(118451);
                    return 0;
                case 3:
                    edr.NdX = aVar3.UbS.zi();
                    AppMethodBeat.o(118451);
                    return 0;
                case 4:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        edp edp = new edp();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = edp.populateBuilderWithField(aVar5, edp, dpc.getNextFieldNumber(aVar5))) {
                        }
                        edr.NdY.add(edp);
                    }
                    AppMethodBeat.o(118451);
                    return 0;
                case 5:
                    edr.NaG = aVar3.UbS.zi();
                    AppMethodBeat.o(118451);
                    return 0;
                case 6:
                    edr.NdN = aVar3.UbS.zl();
                    AppMethodBeat.o(118451);
                    return 0;
                case 7:
                    edr.KCC = aVar3.UbS.zi();
                    AppMethodBeat.o(118451);
                    return 0;
                default:
                    AppMethodBeat.o(118451);
                    return -1;
            }
        } else {
            AppMethodBeat.o(118451);
            return -1;
        }
    }
}

package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.c.a;
import java.util.LinkedList;

public final class fgb extends dpc {
    public fhj ViA;
    public int pQM;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(259331);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse != null) {
                aVar.ni(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            if (this.ViA != null) {
                aVar.ni(2, this.ViA.computeSize());
                this.ViA.writeFields(aVar);
            }
            aVar.aM(3, this.pQM);
            AppMethodBeat.o(259331);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BaseResponse != null ? g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0 : 0;
            if (this.ViA != null) {
                nh += g.a.a.a.nh(2, this.ViA.computeSize());
            }
            int bu = nh + g.a.a.b.b.a.bu(3, this.pQM);
            AppMethodBeat.o(259331);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dpc.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dpc.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(259331);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            fgb fgb = (fgb) objArr[1];
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
                        fgb.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(259331);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        fhj fhj = new fhj();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = fhj.populateBuilderWithField(aVar5, fhj, dpc.getNextFieldNumber(aVar5))) {
                        }
                        fgb.ViA = fhj;
                    }
                    AppMethodBeat.o(259331);
                    return 0;
                case 3:
                    fgb.pQM = aVar3.UbS.zi();
                    AppMethodBeat.o(259331);
                    return 0;
                default:
                    AppMethodBeat.o(259331);
                    return -1;
            }
        } else {
            AppMethodBeat.o(259331);
            return -1;
        }
    }
}

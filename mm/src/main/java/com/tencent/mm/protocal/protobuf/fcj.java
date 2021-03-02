package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.c.a;
import java.util.LinkedList;

public final class fcj extends dpc {
    public fcd Ljo;
    public LinkedList<fcr> Nym = new LinkedList<>();

    public fcj() {
        AppMethodBeat.i(153315);
        AppMethodBeat.o(153315);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(153316);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse != null) {
                aVar.ni(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            aVar.e(2, 8, this.Nym);
            if (this.Ljo != null) {
                aVar.ni(3, this.Ljo.computeSize());
                this.Ljo.writeFields(aVar);
            }
            AppMethodBeat.o(153316);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.BaseResponse != null ? g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0 : 0) + g.a.a.a.c(2, 8, this.Nym);
            if (this.Ljo != null) {
                nh += g.a.a.a.nh(3, this.Ljo.computeSize());
            }
            AppMethodBeat.o(153316);
            return nh;
        } else if (i2 == 2) {
            this.Nym.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dpc.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dpc.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(153316);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            fcj fcj = (fcj) objArr[1];
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
                        fcj.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(153316);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        fcr fcr = new fcr();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = fcr.populateBuilderWithField(aVar5, fcr, dpc.getNextFieldNumber(aVar5))) {
                        }
                        fcj.Nym.add(fcr);
                    }
                    AppMethodBeat.o(153316);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        fcd fcd = new fcd();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = fcd.populateBuilderWithField(aVar6, fcd, dpc.getNextFieldNumber(aVar6))) {
                        }
                        fcj.Ljo = fcd;
                    }
                    AppMethodBeat.o(153316);
                    return 0;
                default:
                    AppMethodBeat.o(153316);
                    return -1;
            }
        } else {
            AppMethodBeat.o(153316);
            return -1;
        }
    }
}

package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.c.a;
import java.util.LinkedList;

public final class brr extends dpc {
    public ez LYU;
    public bb LYV;
    public LinkedList<fbu> LYW = new LinkedList<>();

    public brr() {
        AppMethodBeat.i(152584);
        AppMethodBeat.o(152584);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(152585);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse != null) {
                aVar.ni(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            if (this.LYU != null) {
                aVar.ni(2, this.LYU.computeSize());
                this.LYU.writeFields(aVar);
            }
            if (this.LYV != null) {
                aVar.ni(3, this.LYV.computeSize());
                this.LYV.writeFields(aVar);
            }
            aVar.e(4, 8, this.LYW);
            AppMethodBeat.o(152585);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BaseResponse != null ? g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0 : 0;
            if (this.LYU != null) {
                nh += g.a.a.a.nh(2, this.LYU.computeSize());
            }
            if (this.LYV != null) {
                nh += g.a.a.a.nh(3, this.LYV.computeSize());
            }
            int c2 = nh + g.a.a.a.c(4, 8, this.LYW);
            AppMethodBeat.o(152585);
            return c2;
        } else if (i2 == 2) {
            this.LYW.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dpc.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dpc.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(152585);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            brr brr = (brr) objArr[1];
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
                        brr.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(152585);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        ez ezVar = new ez();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = ezVar.populateBuilderWithField(aVar5, ezVar, dpc.getNextFieldNumber(aVar5))) {
                        }
                        brr.LYU = ezVar;
                    }
                    AppMethodBeat.o(152585);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        bb bbVar = new bb();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = bbVar.populateBuilderWithField(aVar6, bbVar, dpc.getNextFieldNumber(aVar6))) {
                        }
                        brr.LYV = bbVar;
                    }
                    AppMethodBeat.o(152585);
                    return 0;
                case 4:
                    LinkedList<byte[]> awh4 = aVar3.awh(intValue);
                    int size4 = awh4.size();
                    for (int i6 = 0; i6 < size4; i6++) {
                        fbu fbu = new fbu();
                        g.a.a.a.a aVar7 = new g.a.a.a.a(awh4.get(i6), unknownTagHandler);
                        for (boolean z4 = true; z4; z4 = fbu.populateBuilderWithField(aVar7, fbu, dpc.getNextFieldNumber(aVar7))) {
                        }
                        brr.LYW.add(fbu);
                    }
                    AppMethodBeat.o(152585);
                    return 0;
                default:
                    AppMethodBeat.o(152585);
                    return -1;
            }
        } else {
            AppMethodBeat.o(152585);
            return -1;
        }
    }
}

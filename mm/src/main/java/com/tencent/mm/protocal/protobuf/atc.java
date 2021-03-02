package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.c.a;
import java.util.LinkedList;

public final class atc extends dpc {
    public LinkedList<axj> LDY = new LinkedList<>();
    public awf LDZ;

    public atc() {
        AppMethodBeat.i(209437);
        AppMethodBeat.o(209437);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(209438);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse != null) {
                aVar.ni(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            aVar.e(2, 8, this.LDY);
            if (this.LDZ != null) {
                aVar.ni(3, this.LDZ.computeSize());
                this.LDZ.writeFields(aVar);
            }
            AppMethodBeat.o(209438);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.BaseResponse != null ? g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0 : 0) + g.a.a.a.c(2, 8, this.LDY);
            if (this.LDZ != null) {
                nh += g.a.a.a.nh(3, this.LDZ.computeSize());
            }
            AppMethodBeat.o(209438);
            return nh;
        } else if (i2 == 2) {
            this.LDY.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dpc.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dpc.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(209438);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            atc atc = (atc) objArr[1];
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
                        atc.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(209438);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        axj axj = new axj();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = axj.populateBuilderWithField(aVar5, axj, dpc.getNextFieldNumber(aVar5))) {
                        }
                        atc.LDY.add(axj);
                    }
                    AppMethodBeat.o(209438);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        awf awf = new awf();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = awf.populateBuilderWithField(aVar6, awf, dpc.getNextFieldNumber(aVar6))) {
                        }
                        atc.LDZ = awf;
                    }
                    AppMethodBeat.o(209438);
                    return 0;
                default:
                    AppMethodBeat.o(209438);
                    return -1;
            }
        } else {
            AppMethodBeat.o(209438);
            return -1;
        }
    }
}

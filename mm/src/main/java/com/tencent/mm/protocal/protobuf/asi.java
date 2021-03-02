package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class asi extends dpc {
    public LinkedList<bds> Gbc = new LinkedList<>();
    public b LDs;
    public int LDt;
    public int tUC;

    public asi() {
        AppMethodBeat.i(209415);
        AppMethodBeat.o(209415);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(209416);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse != null) {
                aVar.ni(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            aVar.e(2, 8, this.Gbc);
            aVar.aM(3, this.LDt);
            if (this.LDs != null) {
                aVar.c(4, this.LDs);
            }
            aVar.aM(5, this.tUC);
            AppMethodBeat.o(209416);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.BaseResponse != null ? g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0 : 0) + g.a.a.a.c(2, 8, this.Gbc) + g.a.a.b.b.a.bu(3, this.LDt);
            if (this.LDs != null) {
                nh += g.a.a.b.b.a.b(4, this.LDs);
            }
            int bu = nh + g.a.a.b.b.a.bu(5, this.tUC);
            AppMethodBeat.o(209416);
            return bu;
        } else if (i2 == 2) {
            this.Gbc.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dpc.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dpc.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(209416);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            asi asi = (asi) objArr[1];
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
                        asi.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(209416);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        bds bds = new bds();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = bds.populateBuilderWithField(aVar5, bds, dpc.getNextFieldNumber(aVar5))) {
                        }
                        asi.Gbc.add(bds);
                    }
                    AppMethodBeat.o(209416);
                    return 0;
                case 3:
                    asi.LDt = aVar3.UbS.zi();
                    AppMethodBeat.o(209416);
                    return 0;
                case 4:
                    asi.LDs = aVar3.UbS.hPo();
                    AppMethodBeat.o(209416);
                    return 0;
                case 5:
                    asi.tUC = aVar3.UbS.zi();
                    AppMethodBeat.o(209416);
                    return 0;
                default:
                    AppMethodBeat.o(209416);
                    return -1;
            }
        } else {
            AppMethodBeat.o(209416);
            return -1;
        }
    }
}

package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class csf extends dpc {
    public b AqP;
    public int LDO;
    public LinkedList<csk> Mxo = new LinkedList<>();

    public csf() {
        AppMethodBeat.i(256719);
        AppMethodBeat.o(256719);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(256720);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse != null) {
                aVar.ni(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            if (this.AqP != null) {
                aVar.c(2, this.AqP);
            }
            aVar.e(3, 8, this.Mxo);
            aVar.aM(4, this.LDO);
            AppMethodBeat.o(256720);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BaseResponse != null ? g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0 : 0;
            if (this.AqP != null) {
                nh += g.a.a.b.b.a.b(2, this.AqP);
            }
            int c2 = nh + g.a.a.a.c(3, 8, this.Mxo) + g.a.a.b.b.a.bu(4, this.LDO);
            AppMethodBeat.o(256720);
            return c2;
        } else if (i2 == 2) {
            this.Mxo.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dpc.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dpc.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(256720);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            csf csf = (csf) objArr[1];
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
                        csf.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(256720);
                    return 0;
                case 2:
                    csf.AqP = aVar3.UbS.hPo();
                    AppMethodBeat.o(256720);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        csk csk = new csk();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = csk.populateBuilderWithField(aVar5, csk, dpc.getNextFieldNumber(aVar5))) {
                        }
                        csf.Mxo.add(csk);
                    }
                    AppMethodBeat.o(256720);
                    return 0;
                case 4:
                    csf.LDO = aVar3.UbS.zi();
                    AppMethodBeat.o(256720);
                    return 0;
                default:
                    AppMethodBeat.o(256720);
                    return -1;
            }
        } else {
            AppMethodBeat.o(256720);
            return -1;
        }
    }
}

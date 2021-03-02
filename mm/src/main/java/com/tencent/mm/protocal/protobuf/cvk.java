package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.c.a;
import java.util.LinkedList;

public final class cvk extends dop {
    public int MAL;
    public LinkedList<esj> MAM = new LinkedList<>();
    public int OpCode;

    public cvk() {
        AppMethodBeat.i(32364);
        AppMethodBeat.o(32364);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(32365);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            aVar.aM(2, this.OpCode);
            aVar.aM(3, this.MAL);
            aVar.e(4, 8, this.MAM);
            AppMethodBeat.o(32365);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0) + g.a.a.b.b.a.bu(2, this.OpCode) + g.a.a.b.b.a.bu(3, this.MAL) + g.a.a.a.c(4, 8, this.MAM);
            AppMethodBeat.o(32365);
            return nh;
        } else if (i2 == 2) {
            this.MAM.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(32365);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            cvk cvk = (cvk) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        jr jrVar = new jr();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = jrVar.populateBuilderWithField(aVar4, jrVar, dop.getNextFieldNumber(aVar4))) {
                        }
                        cvk.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(32365);
                    return 0;
                case 2:
                    cvk.OpCode = aVar3.UbS.zi();
                    AppMethodBeat.o(32365);
                    return 0;
                case 3:
                    cvk.MAL = aVar3.UbS.zi();
                    AppMethodBeat.o(32365);
                    return 0;
                case 4:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        esj esj = new esj();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = esj.populateBuilderWithField(aVar5, esj, dop.getNextFieldNumber(aVar5))) {
                        }
                        cvk.MAM.add(esj);
                    }
                    AppMethodBeat.o(32365);
                    return 0;
                default:
                    AppMethodBeat.o(32365);
                    return -1;
            }
        } else {
            AppMethodBeat.o(32365);
            return -1;
        }
    }
}

package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import g.a.a.b;
import java.util.LinkedList;

public final class cxn extends a {
    public cxo MBY;
    public int Ret;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(43119);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.MBY == null) {
                b bVar = new b("Not all required fields were included: OplogRet");
                AppMethodBeat.o(43119);
                throw bVar;
            }
            aVar.aM(1, this.Ret);
            if (this.MBY != null) {
                aVar.ni(2, this.MBY.computeSize());
                this.MBY.writeFields(aVar);
            }
            AppMethodBeat.o(43119);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.Ret) + 0;
            if (this.MBY != null) {
                bu += g.a.a.a.nh(2, this.MBY.computeSize());
            }
            AppMethodBeat.o(43119);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.MBY == null) {
                b bVar2 = new b("Not all required fields were included: OplogRet");
                AppMethodBeat.o(43119);
                throw bVar2;
            }
            AppMethodBeat.o(43119);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            cxn cxn = (cxn) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    cxn.Ret = aVar3.UbS.zi();
                    AppMethodBeat.o(43119);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        cxo cxo = new cxo();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = cxo.populateBuilderWithField(aVar4, cxo, a.getNextFieldNumber(aVar4))) {
                        }
                        cxn.MBY = cxo;
                    }
                    AppMethodBeat.o(43119);
                    return 0;
                default:
                    AppMethodBeat.o(43119);
                    return -1;
            }
        } else {
            AppMethodBeat.o(43119);
            return -1;
        }
    }
}
package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import g.a.a.b;
import java.util.LinkedList;

public final class aif extends a {
    public SKBuiltinBuffer_t KLU;
    public int LrO;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(133169);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.KLU == null) {
                b bVar = new b("Not all required fields were included: Key");
                AppMethodBeat.o(133169);
                throw bVar;
            }
            aVar.aM(1, this.LrO);
            if (this.KLU != null) {
                aVar.ni(2, this.KLU.computeSize());
                this.KLU.writeFields(aVar);
            }
            AppMethodBeat.o(133169);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.LrO) + 0;
            if (this.KLU != null) {
                bu += g.a.a.a.nh(2, this.KLU.computeSize());
            }
            AppMethodBeat.o(133169);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.KLU == null) {
                b bVar2 = new b("Not all required fields were included: Key");
                AppMethodBeat.o(133169);
                throw bVar2;
            }
            AppMethodBeat.o(133169);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            aif aif = (aif) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    aif.LrO = aVar3.UbS.zi();
                    AppMethodBeat.o(133169);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        SKBuiltinBuffer_t sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(aVar4, sKBuiltinBuffer_t, a.getNextFieldNumber(aVar4))) {
                        }
                        aif.KLU = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(133169);
                    return 0;
                default:
                    AppMethodBeat.o(133169);
                    return -1;
            }
        } else {
            AppMethodBeat.o(133169);
            return -1;
        }
    }
}

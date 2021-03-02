package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.c.a;
import java.util.LinkedList;

public final class mb extends dop {
    public String KOX;
    public int KPC;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(32147);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.KOX != null) {
                aVar.e(4, this.KOX);
            }
            aVar.aM(5, this.KPC);
            AppMethodBeat.o(32147);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0;
            if (this.KOX != null) {
                nh += g.a.a.b.b.a.f(4, this.KOX);
            }
            int bu = nh + g.a.a.b.b.a.bu(5, this.KPC);
            AppMethodBeat.o(32147);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(32147);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            mb mbVar = (mb) objArr[1];
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
                        mbVar.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(32147);
                    return 0;
                case 2:
                case 3:
                default:
                    AppMethodBeat.o(32147);
                    return -1;
                case 4:
                    mbVar.KOX = aVar3.UbS.readString();
                    AppMethodBeat.o(32147);
                    return 0;
                case 5:
                    mbVar.KPC = aVar3.UbS.zi();
                    AppMethodBeat.o(32147);
                    return 0;
            }
        } else {
            AppMethodBeat.o(32147);
            return -1;
        }
    }
}

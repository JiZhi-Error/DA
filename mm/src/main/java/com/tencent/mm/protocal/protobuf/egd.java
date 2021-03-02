package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class egd extends a {
    public String Luh;
    public anx NfX;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(124562);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.Luh != null) {
                aVar.e(1, this.Luh);
            }
            if (this.NfX != null) {
                aVar.ni(2, this.NfX.computeSize());
                this.NfX.writeFields(aVar);
            }
            AppMethodBeat.o(124562);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.Luh != null ? g.a.a.b.b.a.f(1, this.Luh) + 0 : 0;
            if (this.NfX != null) {
                f2 += g.a.a.a.nh(2, this.NfX.computeSize());
            }
            AppMethodBeat.o(124562);
            return f2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(124562);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            egd egd = (egd) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    egd.Luh = aVar3.UbS.readString();
                    AppMethodBeat.o(124562);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        anx anx = new anx();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = anx.populateBuilderWithField(aVar4, anx, a.getNextFieldNumber(aVar4))) {
                        }
                        egd.NfX = anx;
                    }
                    AppMethodBeat.o(124562);
                    return 0;
                default:
                    AppMethodBeat.o(124562);
                    return -1;
            }
        } else {
            AppMethodBeat.o(124562);
            return -1;
        }
    }
}

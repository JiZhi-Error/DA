package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class ard extends a {
    public LinkedList<FinderObject> LCW = new LinkedList<>();
    public int gAZ;
    public int tQR;
    public String username;

    public ard() {
        AppMethodBeat.i(209389);
        AppMethodBeat.o(209389);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(209390);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.tQR);
            aVar.e(2, 8, this.LCW);
            if (this.username != null) {
                aVar.e(3, this.username);
            }
            aVar.aM(4, this.gAZ);
            AppMethodBeat.o(209390);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.tQR) + 0 + g.a.a.a.c(2, 8, this.LCW);
            if (this.username != null) {
                bu += g.a.a.b.b.a.f(3, this.username);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(4, this.gAZ);
            AppMethodBeat.o(209390);
            return bu2;
        } else if (i2 == 2) {
            this.LCW.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(209390);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            ard ard = (ard) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    ard.tQR = aVar3.UbS.zi();
                    AppMethodBeat.o(209390);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        FinderObject finderObject = new FinderObject();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = finderObject.populateBuilderWithField(aVar4, finderObject, a.getNextFieldNumber(aVar4))) {
                        }
                        ard.LCW.add(finderObject);
                    }
                    AppMethodBeat.o(209390);
                    return 0;
                case 3:
                    ard.username = aVar3.UbS.readString();
                    AppMethodBeat.o(209390);
                    return 0;
                case 4:
                    ard.gAZ = aVar3.UbS.zi();
                    AppMethodBeat.o(209390);
                    return 0;
                default:
                    AppMethodBeat.o(209390);
                    return -1;
            }
        } else {
            AppMethodBeat.o(209390);
            return -1;
        }
    }
}

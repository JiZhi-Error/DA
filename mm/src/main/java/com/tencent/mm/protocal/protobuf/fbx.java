package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class fbx extends a {
    public LinkedList<ecw> NxX = new LinkedList<>();
    public b NxY;

    public fbx() {
        AppMethodBeat.i(32568);
        AppMethodBeat.o(32568);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(32569);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.e(1, 8, this.NxX);
            if (this.NxY != null) {
                aVar.c(2, this.NxY);
            }
            AppMethodBeat.o(32569);
            return 0;
        } else if (i2 == 1) {
            int c2 = g.a.a.a.c(1, 8, this.NxX) + 0;
            if (this.NxY != null) {
                c2 += g.a.a.b.b.a.b(2, this.NxY);
            }
            AppMethodBeat.o(32569);
            return c2;
        } else if (i2 == 2) {
            this.NxX.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(32569);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            fbx fbx = (fbx) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        ecw ecw = new ecw();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = ecw.populateBuilderWithField(aVar4, ecw, a.getNextFieldNumber(aVar4))) {
                        }
                        fbx.NxX.add(ecw);
                    }
                    AppMethodBeat.o(32569);
                    return 0;
                case 2:
                    fbx.NxY = aVar3.UbS.hPo();
                    AppMethodBeat.o(32569);
                    return 0;
                default:
                    AppMethodBeat.o(32569);
                    return -1;
            }
        } else {
            AppMethodBeat.o(32569);
            return -1;
        }
    }
}

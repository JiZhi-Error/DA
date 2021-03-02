package com.tencent.mm.plugin.product.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class f extends a {
    public j AZY;
    public String AZZ;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(91272);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.AZY != null) {
                aVar.ni(1, this.AZY.computeSize());
                this.AZY.writeFields(aVar);
            }
            if (this.AZZ != null) {
                aVar.e(2, this.AZZ);
            }
            AppMethodBeat.o(91272);
            return 0;
        } else if (i2 == 1) {
            int nh = this.AZY != null ? g.a.a.a.nh(1, this.AZY.computeSize()) + 0 : 0;
            if (this.AZZ != null) {
                nh += g.a.a.b.b.a.f(2, this.AZZ);
            }
            AppMethodBeat.o(91272);
            return nh;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(91272);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            f fVar = (f) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        j jVar = new j();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = jVar.populateBuilderWithField(aVar4, jVar, a.getNextFieldNumber(aVar4))) {
                        }
                        fVar.AZY = jVar;
                    }
                    AppMethodBeat.o(91272);
                    return 0;
                case 2:
                    fVar.AZZ = aVar3.UbS.readString();
                    AppMethodBeat.o(91272);
                    return 0;
                default:
                    AppMethodBeat.o(91272);
                    return -1;
            }
        } else {
            AppMethodBeat.o(91272);
            return -1;
        }
    }
}

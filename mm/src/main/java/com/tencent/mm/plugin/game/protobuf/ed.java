package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import g.a.a.b;
import java.util.LinkedList;

public final class ed extends a {
    public long oUG;
    public long oUH;
    public dy xKg;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(256654);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.xKg == null) {
                b bVar = new b("Not all required fields were included: Tab");
                AppMethodBeat.o(256654);
                throw bVar;
            }
            aVar.bb(1, this.oUG);
            aVar.bb(2, this.oUH);
            if (this.xKg != null) {
                aVar.ni(3, this.xKg.computeSize());
                this.xKg.writeFields(aVar);
            }
            AppMethodBeat.o(256654);
            return 0;
        } else if (i2 == 1) {
            int r = g.a.a.b.b.a.r(1, this.oUG) + 0 + g.a.a.b.b.a.r(2, this.oUH);
            if (this.xKg != null) {
                r += g.a.a.a.nh(3, this.xKg.computeSize());
            }
            AppMethodBeat.o(256654);
            return r;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.xKg == null) {
                b bVar2 = new b("Not all required fields were included: Tab");
                AppMethodBeat.o(256654);
                throw bVar2;
            }
            AppMethodBeat.o(256654);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            ed edVar = (ed) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    edVar.oUG = aVar3.UbS.zl();
                    AppMethodBeat.o(256654);
                    return 0;
                case 2:
                    edVar.oUH = aVar3.UbS.zl();
                    AppMethodBeat.o(256654);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        dy dyVar = new dy();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = dyVar.populateBuilderWithField(aVar4, dyVar, a.getNextFieldNumber(aVar4))) {
                        }
                        edVar.xKg = dyVar;
                    }
                    AppMethodBeat.o(256654);
                    return 0;
                default:
                    AppMethodBeat.o(256654);
                    return -1;
            }
        } else {
            AppMethodBeat.o(256654);
            return -1;
        }
    }
}

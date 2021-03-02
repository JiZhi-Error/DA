package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import g.a.a.b;
import java.util.LinkedList;

public final class ai extends a {
    public dy xKg;
    public LinkedList<ed> xKh = new LinkedList<>();

    public ai() {
        AppMethodBeat.i(256633);
        AppMethodBeat.o(256633);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(256634);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.xKg == null) {
                b bVar = new b("Not all required fields were included: Tab");
                AppMethodBeat.o(256634);
                throw bVar;
            }
            if (this.xKg != null) {
                aVar.ni(1, this.xKg.computeSize());
                this.xKg.writeFields(aVar);
            }
            aVar.e(2, 8, this.xKh);
            AppMethodBeat.o(256634);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.xKg != null ? g.a.a.a.nh(1, this.xKg.computeSize()) + 0 : 0) + g.a.a.a.c(2, 8, this.xKh);
            AppMethodBeat.o(256634);
            return nh;
        } else if (i2 == 2) {
            this.xKh.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.xKg == null) {
                b bVar2 = new b("Not all required fields were included: Tab");
                AppMethodBeat.o(256634);
                throw bVar2;
            }
            AppMethodBeat.o(256634);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            ai aiVar = (ai) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        dy dyVar = new dy();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = dyVar.populateBuilderWithField(aVar4, dyVar, a.getNextFieldNumber(aVar4))) {
                        }
                        aiVar.xKg = dyVar;
                    }
                    AppMethodBeat.o(256634);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        ed edVar = new ed();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = edVar.populateBuilderWithField(aVar5, edVar, a.getNextFieldNumber(aVar5))) {
                        }
                        aiVar.xKh.add(edVar);
                    }
                    AppMethodBeat.o(256634);
                    return 0;
                default:
                    AppMethodBeat.o(256634);
                    return -1;
            }
        } else {
            AppMethodBeat.o(256634);
            return -1;
        }
    }
}

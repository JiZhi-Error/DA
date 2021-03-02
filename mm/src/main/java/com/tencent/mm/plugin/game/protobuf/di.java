package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import g.a.a.b;
import java.util.LinkedList;

public final class di extends a {
    public ep xMW;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(41825);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.xMW == null) {
                b bVar = new b("Not all required fields were included: AppInfo");
                AppMethodBeat.o(41825);
                throw bVar;
            }
            if (this.xMW != null) {
                aVar.ni(1, this.xMW.computeSize());
                this.xMW.writeFields(aVar);
            }
            AppMethodBeat.o(41825);
            return 0;
        } else if (i2 == 1) {
            int nh = this.xMW != null ? g.a.a.a.nh(1, this.xMW.computeSize()) + 0 : 0;
            AppMethodBeat.o(41825);
            return nh;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.xMW == null) {
                b bVar2 = new b("Not all required fields were included: AppInfo");
                AppMethodBeat.o(41825);
                throw bVar2;
            }
            AppMethodBeat.o(41825);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            di diVar = (di) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        ep epVar = new ep();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = epVar.populateBuilderWithField(aVar4, epVar, a.getNextFieldNumber(aVar4))) {
                        }
                        diVar.xMW = epVar;
                    }
                    AppMethodBeat.o(41825);
                    return 0;
                default:
                    AppMethodBeat.o(41825);
                    return -1;
            }
        } else {
            AppMethodBeat.o(41825);
            return -1;
        }
    }
}

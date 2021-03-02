package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class cb extends a {
    public cd xMh;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(256640);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.xMh != null) {
                aVar.ni(1, this.xMh.computeSize());
                this.xMh.writeFields(aVar);
            }
            AppMethodBeat.o(256640);
            return 0;
        } else if (i2 == 1) {
            int nh = this.xMh != null ? g.a.a.a.nh(1, this.xMh.computeSize()) + 0 : 0;
            AppMethodBeat.o(256640);
            return nh;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(256640);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            cb cbVar = (cb) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        cd cdVar = new cd();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = cdVar.populateBuilderWithField(aVar4, cdVar, a.getNextFieldNumber(aVar4))) {
                        }
                        cbVar.xMh = cdVar;
                    }
                    AppMethodBeat.o(256640);
                    return 0;
                default:
                    AppMethodBeat.o(256640);
                    return -1;
            }
        } else {
            AppMethodBeat.o(256640);
            return -1;
        }
    }
}

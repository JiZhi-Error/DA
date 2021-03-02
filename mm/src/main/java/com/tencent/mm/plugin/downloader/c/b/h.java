package com.tencent.mm.plugin.downloader.c.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class h extends a {
    public i qGU;
    public i qGV;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(153068);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.qGU != null) {
                aVar.ni(1, this.qGU.computeSize());
                this.qGU.writeFields(aVar);
            }
            if (this.qGV != null) {
                aVar.ni(2, this.qGV.computeSize());
                this.qGV.writeFields(aVar);
            }
            AppMethodBeat.o(153068);
            return 0;
        } else if (i2 == 1) {
            int nh = this.qGU != null ? g.a.a.a.nh(1, this.qGU.computeSize()) + 0 : 0;
            if (this.qGV != null) {
                nh += g.a.a.a.nh(2, this.qGV.computeSize());
            }
            AppMethodBeat.o(153068);
            return nh;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(153068);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            h hVar = (h) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        i iVar = new i();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = iVar.populateBuilderWithField(aVar4, iVar, a.getNextFieldNumber(aVar4))) {
                        }
                        hVar.qGU = iVar;
                    }
                    AppMethodBeat.o(153068);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        i iVar2 = new i();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = iVar2.populateBuilderWithField(aVar5, iVar2, a.getNextFieldNumber(aVar5))) {
                        }
                        hVar.qGV = iVar2;
                    }
                    AppMethodBeat.o(153068);
                    return 0;
                default:
                    AppMethodBeat.o(153068);
                    return -1;
            }
        } else {
            AppMethodBeat.o(153068);
            return -1;
        }
    }
}

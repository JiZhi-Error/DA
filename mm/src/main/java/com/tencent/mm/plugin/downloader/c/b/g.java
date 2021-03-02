package com.tencent.mm.plugin.downloader.c.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class g extends a {
    public c qGP;
    public j qGQ;
    public boolean qGR;
    public int qGS;
    public boolean qGT;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(153067);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.qGP != null) {
                aVar.ni(1, this.qGP.computeSize());
                this.qGP.writeFields(aVar);
            }
            if (this.qGQ != null) {
                aVar.ni(2, this.qGQ.computeSize());
                this.qGQ.writeFields(aVar);
            }
            aVar.cc(3, this.qGR);
            aVar.aM(4, this.qGS);
            aVar.cc(5, this.qGT);
            AppMethodBeat.o(153067);
            return 0;
        } else if (i2 == 1) {
            int nh = this.qGP != null ? g.a.a.a.nh(1, this.qGP.computeSize()) + 0 : 0;
            if (this.qGQ != null) {
                nh += g.a.a.a.nh(2, this.qGQ.computeSize());
            }
            int fS = nh + g.a.a.b.b.a.fS(3) + 1 + g.a.a.b.b.a.bu(4, this.qGS) + g.a.a.b.b.a.fS(5) + 1;
            AppMethodBeat.o(153067);
            return fS;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(153067);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            g gVar = (g) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        c cVar = new c();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = cVar.populateBuilderWithField(aVar4, cVar, a.getNextFieldNumber(aVar4))) {
                        }
                        gVar.qGP = cVar;
                    }
                    AppMethodBeat.o(153067);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        j jVar = new j();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = jVar.populateBuilderWithField(aVar5, jVar, a.getNextFieldNumber(aVar5))) {
                        }
                        gVar.qGQ = jVar;
                    }
                    AppMethodBeat.o(153067);
                    return 0;
                case 3:
                    gVar.qGR = aVar3.UbS.yZ();
                    AppMethodBeat.o(153067);
                    return 0;
                case 4:
                    gVar.qGS = aVar3.UbS.zi();
                    AppMethodBeat.o(153067);
                    return 0;
                case 5:
                    gVar.qGT = aVar3.UbS.yZ();
                    AppMethodBeat.o(153067);
                    return 0;
                default:
                    AppMethodBeat.o(153067);
                    return -1;
            }
        } else {
            AppMethodBeat.o(153067);
            return -1;
        }
    }
}

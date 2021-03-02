package com.tencent.mm.plugin.downloader.c.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import com.tencent.mm.plugin.downloader.c.b.k;
import g.a.a.b;
import java.util.LinkedList;

public final class d extends a {
    public k qFP;
    public e qFQ;
    public c qFR;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(153044);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.qFP == null) {
                b bVar = new b("Not all required fields were included: app_info");
                AppMethodBeat.o(153044);
                throw bVar;
            }
            if (this.qFP != null) {
                aVar.ni(1, this.qFP.computeSize());
                this.qFP.writeFields(aVar);
            }
            if (this.qFQ != null) {
                aVar.ni(2, this.qFQ.computeSize());
                this.qFQ.writeFields(aVar);
            }
            if (this.qFR != null) {
                aVar.ni(3, this.qFR.computeSize());
                this.qFR.writeFields(aVar);
            }
            AppMethodBeat.o(153044);
            return 0;
        } else if (i2 == 1) {
            int nh = this.qFP != null ? g.a.a.a.nh(1, this.qFP.computeSize()) + 0 : 0;
            if (this.qFQ != null) {
                nh += g.a.a.a.nh(2, this.qFQ.computeSize());
            }
            if (this.qFR != null) {
                nh += g.a.a.a.nh(3, this.qFR.computeSize());
            }
            AppMethodBeat.o(153044);
            return nh;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.qFP == null) {
                b bVar2 = new b("Not all required fields were included: app_info");
                AppMethodBeat.o(153044);
                throw bVar2;
            }
            AppMethodBeat.o(153044);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            d dVar = (d) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        k kVar = new k();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = kVar.populateBuilderWithField(aVar4, kVar, a.getNextFieldNumber(aVar4))) {
                        }
                        dVar.qFP = kVar;
                    }
                    AppMethodBeat.o(153044);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        e eVar = new e();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = eVar.populateBuilderWithField(aVar5, eVar, a.getNextFieldNumber(aVar5))) {
                        }
                        dVar.qFQ = eVar;
                    }
                    AppMethodBeat.o(153044);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        c cVar = new c();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = cVar.populateBuilderWithField(aVar6, cVar, a.getNextFieldNumber(aVar6))) {
                        }
                        dVar.qFR = cVar;
                    }
                    AppMethodBeat.o(153044);
                    return 0;
                default:
                    AppMethodBeat.o(153044);
                    return -1;
            }
        } else {
            AppMethodBeat.o(153044);
            return -1;
        }
    }
}

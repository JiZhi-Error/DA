package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class cxq extends a {
    public String KNW;
    public deq MCc;
    public LinkedList<dyr> MCd = new LinkedList<>();

    public cxq() {
        AppMethodBeat.i(91568);
        AppMethodBeat.o(91568);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(91569);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.MCc != null) {
                aVar.ni(1, this.MCc.computeSize());
                this.MCc.writeFields(aVar);
            }
            aVar.e(2, 8, this.MCd);
            if (this.KNW != null) {
                aVar.e(3, this.KNW);
            }
            AppMethodBeat.o(91569);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.MCc != null ? g.a.a.a.nh(1, this.MCc.computeSize()) + 0 : 0) + g.a.a.a.c(2, 8, this.MCd);
            if (this.KNW != null) {
                nh += g.a.a.b.b.a.f(3, this.KNW);
            }
            AppMethodBeat.o(91569);
            return nh;
        } else if (i2 == 2) {
            this.MCd.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(91569);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            cxq cxq = (cxq) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        deq deq = new deq();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = deq.populateBuilderWithField(aVar4, deq, a.getNextFieldNumber(aVar4))) {
                        }
                        cxq.MCc = deq;
                    }
                    AppMethodBeat.o(91569);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        dyr dyr = new dyr();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = dyr.populateBuilderWithField(aVar5, dyr, a.getNextFieldNumber(aVar5))) {
                        }
                        cxq.MCd.add(dyr);
                    }
                    AppMethodBeat.o(91569);
                    return 0;
                case 3:
                    cxq.KNW = aVar3.UbS.readString();
                    AppMethodBeat.o(91569);
                    return 0;
                default:
                    AppMethodBeat.o(91569);
                    return -1;
            }
        } else {
            AppMethodBeat.o(91569);
            return -1;
        }
    }
}
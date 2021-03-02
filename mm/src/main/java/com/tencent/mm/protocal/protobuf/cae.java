package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class cae extends a {
    public ehf KEN;
    public LinkedList<dyr> KEQ = new LinkedList<>();
    public String KNW;

    public cae() {
        AppMethodBeat.i(91514);
        AppMethodBeat.o(91514);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(91515);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.KEN != null) {
                aVar.ni(1, this.KEN.computeSize());
                this.KEN.writeFields(aVar);
            }
            aVar.e(2, 8, this.KEQ);
            if (this.KNW != null) {
                aVar.e(3, this.KNW);
            }
            AppMethodBeat.o(91515);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.KEN != null ? g.a.a.a.nh(1, this.KEN.computeSize()) + 0 : 0) + g.a.a.a.c(2, 8, this.KEQ);
            if (this.KNW != null) {
                nh += g.a.a.b.b.a.f(3, this.KNW);
            }
            AppMethodBeat.o(91515);
            return nh;
        } else if (i2 == 2) {
            this.KEQ.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(91515);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            cae cae = (cae) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        ehf ehf = new ehf();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = ehf.populateBuilderWithField(aVar4, ehf, a.getNextFieldNumber(aVar4))) {
                        }
                        cae.KEN = ehf;
                    }
                    AppMethodBeat.o(91515);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        dyr dyr = new dyr();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = dyr.populateBuilderWithField(aVar5, dyr, a.getNextFieldNumber(aVar5))) {
                        }
                        cae.KEQ.add(dyr);
                    }
                    AppMethodBeat.o(91515);
                    return 0;
                case 3:
                    cae.KNW = aVar3.UbS.readString();
                    AppMethodBeat.o(91515);
                    return 0;
                default:
                    AppMethodBeat.o(91515);
                    return -1;
            }
        } else {
            AppMethodBeat.o(91515);
            return -1;
        }
    }
}

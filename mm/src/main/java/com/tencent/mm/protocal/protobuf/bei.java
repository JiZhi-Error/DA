package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class bei extends a {
    public cng LIA;
    public String LOd;
    public long id;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(209717);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.bb(1, this.id);
            if (this.LIA != null) {
                aVar.ni(2, this.LIA.computeSize());
                this.LIA.writeFields(aVar);
            }
            if (this.LOd != null) {
                aVar.e(3, this.LOd);
            }
            AppMethodBeat.o(209717);
            return 0;
        } else if (i2 == 1) {
            int r = g.a.a.b.b.a.r(1, this.id) + 0;
            if (this.LIA != null) {
                r += g.a.a.a.nh(2, this.LIA.computeSize());
            }
            if (this.LOd != null) {
                r += g.a.a.b.b.a.f(3, this.LOd);
            }
            AppMethodBeat.o(209717);
            return r;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(209717);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            bei bei = (bei) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    bei.id = aVar3.UbS.zl();
                    AppMethodBeat.o(209717);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        cng cng = new cng();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = cng.populateBuilderWithField(aVar4, cng, a.getNextFieldNumber(aVar4))) {
                        }
                        bei.LIA = cng;
                    }
                    AppMethodBeat.o(209717);
                    return 0;
                case 3:
                    bei.LOd = aVar3.UbS.readString();
                    AppMethodBeat.o(209717);
                    return 0;
                default:
                    AppMethodBeat.o(209717);
                    return -1;
            }
        } else {
            AppMethodBeat.o(209717);
            return -1;
        }
    }
}

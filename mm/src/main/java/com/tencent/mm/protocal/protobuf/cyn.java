package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class cyn extends a {
    public cym MDw;
    public String key;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(220717);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.key != null) {
                aVar.e(1, this.key);
            }
            if (this.MDw != null) {
                aVar.ni(2, this.MDw.computeSize());
                this.MDw.writeFields(aVar);
            }
            AppMethodBeat.o(220717);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.key != null ? g.a.a.b.b.a.f(1, this.key) + 0 : 0;
            if (this.MDw != null) {
                f2 += g.a.a.a.nh(2, this.MDw.computeSize());
            }
            AppMethodBeat.o(220717);
            return f2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(220717);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            cyn cyn = (cyn) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    cyn.key = aVar3.UbS.readString();
                    AppMethodBeat.o(220717);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        cym cym = new cym();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = cym.populateBuilderWithField(aVar4, cym, a.getNextFieldNumber(aVar4))) {
                        }
                        cyn.MDw = cym;
                    }
                    AppMethodBeat.o(220717);
                    return 0;
                default:
                    AppMethodBeat.o(220717);
                    return -1;
            }
        } else {
            AppMethodBeat.o(220717);
            return -1;
        }
    }
}
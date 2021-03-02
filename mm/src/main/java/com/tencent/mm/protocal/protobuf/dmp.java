package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class dmp extends a {
    public cfl IoM;
    public String dQx;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(72577);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.dQx != null) {
                aVar.e(1, this.dQx);
            }
            if (this.IoM != null) {
                aVar.ni(2, this.IoM.computeSize());
                this.IoM.writeFields(aVar);
            }
            AppMethodBeat.o(72577);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.dQx != null ? g.a.a.b.b.a.f(1, this.dQx) + 0 : 0;
            if (this.IoM != null) {
                f2 += g.a.a.a.nh(2, this.IoM.computeSize());
            }
            AppMethodBeat.o(72577);
            return f2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(72577);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            dmp dmp = (dmp) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    dmp.dQx = aVar3.UbS.readString();
                    AppMethodBeat.o(72577);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        cfl cfl = new cfl();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = cfl.populateBuilderWithField(aVar4, cfl, a.getNextFieldNumber(aVar4))) {
                        }
                        dmp.IoM = cfl;
                    }
                    AppMethodBeat.o(72577);
                    return 0;
                default:
                    AppMethodBeat.o(72577);
                    return -1;
            }
        } else {
            AppMethodBeat.o(72577);
            return -1;
        }
    }
}

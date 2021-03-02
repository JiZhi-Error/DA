package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class auh extends a {
    public axj LFb;
    public String dQx;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(209472);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.dQx != null) {
                aVar.e(1, this.dQx);
            }
            if (this.LFb != null) {
                aVar.ni(2, this.LFb.computeSize());
                this.LFb.writeFields(aVar);
            }
            AppMethodBeat.o(209472);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.dQx != null ? g.a.a.b.b.a.f(1, this.dQx) + 0 : 0;
            if (this.LFb != null) {
                f2 += g.a.a.a.nh(2, this.LFb.computeSize());
            }
            AppMethodBeat.o(209472);
            return f2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(209472);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            auh auh = (auh) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    auh.dQx = aVar3.UbS.readString();
                    AppMethodBeat.o(209472);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        axj axj = new axj();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = axj.populateBuilderWithField(aVar4, axj, a.getNextFieldNumber(aVar4))) {
                        }
                        auh.LFb = axj;
                    }
                    AppMethodBeat.o(209472);
                    return 0;
                default:
                    AppMethodBeat.o(209472);
                    return -1;
            }
        } else {
            AppMethodBeat.o(209472);
            return -1;
        }
    }
}

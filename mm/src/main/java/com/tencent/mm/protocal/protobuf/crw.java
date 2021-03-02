package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class crw extends a {
    public String MwX;
    public axy MwY;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(256707);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.MwX != null) {
                aVar.e(1, this.MwX);
            }
            if (this.MwY != null) {
                aVar.ni(2, this.MwY.computeSize());
                this.MwY.writeFields(aVar);
            }
            AppMethodBeat.o(256707);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.MwX != null ? g.a.a.b.b.a.f(1, this.MwX) + 0 : 0;
            if (this.MwY != null) {
                f2 += g.a.a.a.nh(2, this.MwY.computeSize());
            }
            AppMethodBeat.o(256707);
            return f2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(256707);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            crw crw = (crw) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    crw.MwX = aVar3.UbS.readString();
                    AppMethodBeat.o(256707);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        axy axy = new axy();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = axy.populateBuilderWithField(aVar4, axy, a.getNextFieldNumber(aVar4))) {
                        }
                        crw.MwY = axy;
                    }
                    AppMethodBeat.o(256707);
                    return 0;
                default:
                    AppMethodBeat.o(256707);
                    return -1;
            }
        } else {
            AppMethodBeat.o(256707);
            return -1;
        }
    }
}

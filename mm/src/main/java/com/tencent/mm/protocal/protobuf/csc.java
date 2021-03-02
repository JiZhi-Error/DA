package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class csc extends a {
    public String MwX;
    public axy MwY;
    public String Mxj;
    public String Mxk;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(256716);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.MwX != null) {
                aVar.e(1, this.MwX);
            }
            if (this.Mxj != null) {
                aVar.e(2, this.Mxj);
            }
            if (this.Mxk != null) {
                aVar.e(3, this.Mxk);
            }
            if (this.MwY != null) {
                aVar.ni(4, this.MwY.computeSize());
                this.MwY.writeFields(aVar);
            }
            AppMethodBeat.o(256716);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.MwX != null ? g.a.a.b.b.a.f(1, this.MwX) + 0 : 0;
            if (this.Mxj != null) {
                f2 += g.a.a.b.b.a.f(2, this.Mxj);
            }
            if (this.Mxk != null) {
                f2 += g.a.a.b.b.a.f(3, this.Mxk);
            }
            if (this.MwY != null) {
                f2 += g.a.a.a.nh(4, this.MwY.computeSize());
            }
            AppMethodBeat.o(256716);
            return f2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(256716);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            csc csc = (csc) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    csc.MwX = aVar3.UbS.readString();
                    AppMethodBeat.o(256716);
                    return 0;
                case 2:
                    csc.Mxj = aVar3.UbS.readString();
                    AppMethodBeat.o(256716);
                    return 0;
                case 3:
                    csc.Mxk = aVar3.UbS.readString();
                    AppMethodBeat.o(256716);
                    return 0;
                case 4:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        axy axy = new axy();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = axy.populateBuilderWithField(aVar4, axy, a.getNextFieldNumber(aVar4))) {
                        }
                        csc.MwY = axy;
                    }
                    AppMethodBeat.o(256716);
                    return 0;
                default:
                    AppMethodBeat.o(256716);
                    return -1;
            }
        } else {
            AppMethodBeat.o(256716);
            return -1;
        }
    }
}

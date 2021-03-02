package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class azl extends a {
    public azk LJj;
    public String LJk;
    public String LJl;
    public String LJm;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(209613);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.LJj != null) {
                aVar.ni(1, this.LJj.computeSize());
                this.LJj.writeFields(aVar);
            }
            if (this.LJk != null) {
                aVar.e(2, this.LJk);
            }
            if (this.LJl != null) {
                aVar.e(3, this.LJl);
            }
            if (this.LJm != null) {
                aVar.e(4, this.LJm);
            }
            AppMethodBeat.o(209613);
            return 0;
        } else if (i2 == 1) {
            int nh = this.LJj != null ? g.a.a.a.nh(1, this.LJj.computeSize()) + 0 : 0;
            if (this.LJk != null) {
                nh += g.a.a.b.b.a.f(2, this.LJk);
            }
            if (this.LJl != null) {
                nh += g.a.a.b.b.a.f(3, this.LJl);
            }
            if (this.LJm != null) {
                nh += g.a.a.b.b.a.f(4, this.LJm);
            }
            AppMethodBeat.o(209613);
            return nh;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(209613);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            azl azl = (azl) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        azk azk = new azk();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = azk.populateBuilderWithField(aVar4, azk, a.getNextFieldNumber(aVar4))) {
                        }
                        azl.LJj = azk;
                    }
                    AppMethodBeat.o(209613);
                    return 0;
                case 2:
                    azl.LJk = aVar3.UbS.readString();
                    AppMethodBeat.o(209613);
                    return 0;
                case 3:
                    azl.LJl = aVar3.UbS.readString();
                    AppMethodBeat.o(209613);
                    return 0;
                case 4:
                    azl.LJm = aVar3.UbS.readString();
                    AppMethodBeat.o(209613);
                    return 0;
                default:
                    AppMethodBeat.o(209613);
                    return -1;
            }
        } else {
            AppMethodBeat.o(209613);
            return -1;
        }
    }
}

package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import g.a.a.b;
import java.util.LinkedList;

public final class eyv extends a {
    public long KMm;
    public long Nvw;
    public String Nvx;
    public LinkedList<eyw> Nvy = new LinkedList<>();

    public eyv() {
        AppMethodBeat.i(32534);
        AppMethodBeat.o(32534);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(32535);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.Nvx == null) {
                b bVar = new b("Not all required fields were included: TotalMsg");
                AppMethodBeat.o(32535);
                throw bVar;
            }
            aVar.bb(1, this.Nvw);
            aVar.bb(2, this.KMm);
            if (this.Nvx != null) {
                aVar.e(3, this.Nvx);
            }
            aVar.e(4, 8, this.Nvy);
            AppMethodBeat.o(32535);
            return 0;
        } else if (i2 == 1) {
            int r = g.a.a.b.b.a.r(1, this.Nvw) + 0 + g.a.a.b.b.a.r(2, this.KMm);
            if (this.Nvx != null) {
                r += g.a.a.b.b.a.f(3, this.Nvx);
            }
            int c2 = r + g.a.a.a.c(4, 8, this.Nvy);
            AppMethodBeat.o(32535);
            return c2;
        } else if (i2 == 2) {
            this.Nvy.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.Nvx == null) {
                b bVar2 = new b("Not all required fields were included: TotalMsg");
                AppMethodBeat.o(32535);
                throw bVar2;
            }
            AppMethodBeat.o(32535);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            eyv eyv = (eyv) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    eyv.Nvw = aVar3.UbS.zl();
                    AppMethodBeat.o(32535);
                    return 0;
                case 2:
                    eyv.KMm = aVar3.UbS.zl();
                    AppMethodBeat.o(32535);
                    return 0;
                case 3:
                    eyv.Nvx = aVar3.UbS.readString();
                    AppMethodBeat.o(32535);
                    return 0;
                case 4:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        eyw eyw = new eyw();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = eyw.populateBuilderWithField(aVar4, eyw, a.getNextFieldNumber(aVar4))) {
                        }
                        eyv.Nvy.add(eyw);
                    }
                    AppMethodBeat.o(32535);
                    return 0;
                default:
                    AppMethodBeat.o(32535);
                    return -1;
            }
        } else {
            AppMethodBeat.o(32535);
            return -1;
        }
    }
}

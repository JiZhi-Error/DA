package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class bfk extends a {
    public eih LOX;
    public String LOY = "";
    public int LOZ = 0;
    public String LPa = "";
    public boolean LPb = false;
    public boolean LPc = false;
    public long timestamp = 0;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(122493);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.LOX != null) {
                aVar.ni(1, this.LOX.computeSize());
                this.LOX.writeFields(aVar);
            }
            if (this.LPa != null) {
                aVar.e(2, this.LPa);
            }
            aVar.cc(3, this.LPb);
            if (this.LOY != null) {
                aVar.e(4, this.LOY);
            }
            aVar.cc(5, this.LPc);
            aVar.bb(6, this.timestamp);
            aVar.aM(7, this.LOZ);
            AppMethodBeat.o(122493);
            return 0;
        } else if (i2 == 1) {
            int nh = this.LOX != null ? g.a.a.a.nh(1, this.LOX.computeSize()) + 0 : 0;
            if (this.LPa != null) {
                nh += g.a.a.b.b.a.f(2, this.LPa);
            }
            int fS = nh + g.a.a.b.b.a.fS(3) + 1;
            if (this.LOY != null) {
                fS += g.a.a.b.b.a.f(4, this.LOY);
            }
            int fS2 = fS + g.a.a.b.b.a.fS(5) + 1 + g.a.a.b.b.a.r(6, this.timestamp) + g.a.a.b.b.a.bu(7, this.LOZ);
            AppMethodBeat.o(122493);
            return fS2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(122493);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            bfk bfk = (bfk) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        eih eih = new eih();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = eih.populateBuilderWithField(aVar4, eih, a.getNextFieldNumber(aVar4))) {
                        }
                        bfk.LOX = eih;
                    }
                    AppMethodBeat.o(122493);
                    return 0;
                case 2:
                    bfk.LPa = aVar3.UbS.readString();
                    AppMethodBeat.o(122493);
                    return 0;
                case 3:
                    bfk.LPb = aVar3.UbS.yZ();
                    AppMethodBeat.o(122493);
                    return 0;
                case 4:
                    bfk.LOY = aVar3.UbS.readString();
                    AppMethodBeat.o(122493);
                    return 0;
                case 5:
                    bfk.LPc = aVar3.UbS.yZ();
                    AppMethodBeat.o(122493);
                    return 0;
                case 6:
                    bfk.timestamp = aVar3.UbS.zl();
                    AppMethodBeat.o(122493);
                    return 0;
                case 7:
                    bfk.LOZ = aVar3.UbS.zi();
                    AppMethodBeat.o(122493);
                    return 0;
                default:
                    AppMethodBeat.o(122493);
                    return -1;
            }
        } else {
            AppMethodBeat.o(122493);
            return -1;
        }
    }
}

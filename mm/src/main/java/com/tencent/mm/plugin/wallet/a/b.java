package com.tencent.mm.plugin.wallet.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class b extends a {
    public m HEb;
    public int HEc;
    public String HEd;
    public String HEe;
    public String HEf;
    public String HEg;
    public String HEh;
    public String HEi;
    public String HEj;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(91285);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.HEb != null) {
                aVar.ni(1, this.HEb.computeSize());
                this.HEb.writeFields(aVar);
            }
            aVar.aM(2, this.HEc);
            if (this.HEd != null) {
                aVar.e(3, this.HEd);
            }
            if (this.HEe != null) {
                aVar.e(4, this.HEe);
            }
            if (this.HEf != null) {
                aVar.e(5, this.HEf);
            }
            if (this.HEg != null) {
                aVar.e(6, this.HEg);
            }
            if (this.HEh != null) {
                aVar.e(7, this.HEh);
            }
            if (this.HEi != null) {
                aVar.e(8, this.HEi);
            }
            if (this.HEj != null) {
                aVar.e(9, this.HEj);
            }
            AppMethodBeat.o(91285);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.HEb != null ? g.a.a.a.nh(1, this.HEb.computeSize()) + 0 : 0) + g.a.a.b.b.a.bu(2, this.HEc);
            if (this.HEd != null) {
                nh += g.a.a.b.b.a.f(3, this.HEd);
            }
            if (this.HEe != null) {
                nh += g.a.a.b.b.a.f(4, this.HEe);
            }
            if (this.HEf != null) {
                nh += g.a.a.b.b.a.f(5, this.HEf);
            }
            if (this.HEg != null) {
                nh += g.a.a.b.b.a.f(6, this.HEg);
            }
            if (this.HEh != null) {
                nh += g.a.a.b.b.a.f(7, this.HEh);
            }
            if (this.HEi != null) {
                nh += g.a.a.b.b.a.f(8, this.HEi);
            }
            if (this.HEj != null) {
                nh += g.a.a.b.b.a.f(9, this.HEj);
            }
            AppMethodBeat.o(91285);
            return nh;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(91285);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            b bVar = (b) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        m mVar = new m();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = mVar.populateBuilderWithField(aVar4, mVar, a.getNextFieldNumber(aVar4))) {
                        }
                        bVar.HEb = mVar;
                    }
                    AppMethodBeat.o(91285);
                    return 0;
                case 2:
                    bVar.HEc = aVar3.UbS.zi();
                    AppMethodBeat.o(91285);
                    return 0;
                case 3:
                    bVar.HEd = aVar3.UbS.readString();
                    AppMethodBeat.o(91285);
                    return 0;
                case 4:
                    bVar.HEe = aVar3.UbS.readString();
                    AppMethodBeat.o(91285);
                    return 0;
                case 5:
                    bVar.HEf = aVar3.UbS.readString();
                    AppMethodBeat.o(91285);
                    return 0;
                case 6:
                    bVar.HEg = aVar3.UbS.readString();
                    AppMethodBeat.o(91285);
                    return 0;
                case 7:
                    bVar.HEh = aVar3.UbS.readString();
                    AppMethodBeat.o(91285);
                    return 0;
                case 8:
                    bVar.HEi = aVar3.UbS.readString();
                    AppMethodBeat.o(91285);
                    return 0;
                case 9:
                    bVar.HEj = aVar3.UbS.readString();
                    AppMethodBeat.o(91285);
                    return 0;
                default:
                    AppMethodBeat.o(91285);
                    return -1;
            }
        } else {
            AppMethodBeat.o(91285);
            return -1;
        }
    }
}

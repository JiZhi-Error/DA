package com.tencent.mm.plugin.backup.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import g.a.a.b;
import java.util.LinkedList;

public final class r extends a {
    public String ID;
    public long oTV;
    public int oTY;
    public int oTZ;
    public int oUa;
    public long oUb;
    public long oUc;
    public LinkedList<t> oUm = new LinkedList<>();
    public LinkedList<t> oUn = new LinkedList<>();

    public r() {
        AppMethodBeat.i(22122);
        AppMethodBeat.o(22122);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(22123);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.ID == null) {
                b bVar = new b("Not all required fields were included: ID");
                AppMethodBeat.o(22123);
                throw bVar;
            }
            if (this.ID != null) {
                aVar.e(1, this.ID);
            }
            aVar.aM(2, this.oTY);
            aVar.aM(3, this.oTZ);
            aVar.aM(4, this.oUa);
            aVar.bb(5, this.oTV);
            aVar.bb(6, this.oUb);
            aVar.bb(7, this.oUc);
            aVar.e(8, 8, this.oUm);
            aVar.e(9, 8, this.oUn);
            AppMethodBeat.o(22123);
            return 0;
        } else if (i2 == 1) {
            int f2 = (this.ID != null ? g.a.a.b.b.a.f(1, this.ID) + 0 : 0) + g.a.a.b.b.a.bu(2, this.oTY) + g.a.a.b.b.a.bu(3, this.oTZ) + g.a.a.b.b.a.bu(4, this.oUa) + g.a.a.b.b.a.r(5, this.oTV) + g.a.a.b.b.a.r(6, this.oUb) + g.a.a.b.b.a.r(7, this.oUc) + g.a.a.a.c(8, 8, this.oUm) + g.a.a.a.c(9, 8, this.oUn);
            AppMethodBeat.o(22123);
            return f2;
        } else if (i2 == 2) {
            this.oUm.clear();
            this.oUn.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.ID == null) {
                b bVar2 = new b("Not all required fields were included: ID");
                AppMethodBeat.o(22123);
                throw bVar2;
            }
            AppMethodBeat.o(22123);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            r rVar = (r) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    rVar.ID = aVar3.UbS.readString();
                    AppMethodBeat.o(22123);
                    return 0;
                case 2:
                    rVar.oTY = aVar3.UbS.zi();
                    AppMethodBeat.o(22123);
                    return 0;
                case 3:
                    rVar.oTZ = aVar3.UbS.zi();
                    AppMethodBeat.o(22123);
                    return 0;
                case 4:
                    rVar.oUa = aVar3.UbS.zi();
                    AppMethodBeat.o(22123);
                    return 0;
                case 5:
                    rVar.oTV = aVar3.UbS.zl();
                    AppMethodBeat.o(22123);
                    return 0;
                case 6:
                    rVar.oUb = aVar3.UbS.zl();
                    AppMethodBeat.o(22123);
                    return 0;
                case 7:
                    rVar.oUc = aVar3.UbS.zl();
                    AppMethodBeat.o(22123);
                    return 0;
                case 8:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        t tVar = new t();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = tVar.populateBuilderWithField(aVar4, tVar, a.getNextFieldNumber(aVar4))) {
                        }
                        rVar.oUm.add(tVar);
                    }
                    AppMethodBeat.o(22123);
                    return 0;
                case 9:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        t tVar2 = new t();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = tVar2.populateBuilderWithField(aVar5, tVar2, a.getNextFieldNumber(aVar5))) {
                        }
                        rVar.oUn.add(tVar2);
                    }
                    AppMethodBeat.o(22123);
                    return 0;
                default:
                    AppMethodBeat.o(22123);
                    return -1;
            }
        } else {
            AppMethodBeat.o(22123);
            return -1;
        }
    }
}

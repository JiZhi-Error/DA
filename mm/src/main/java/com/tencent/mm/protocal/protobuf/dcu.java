package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class dcu extends a {
    public String MHf;
    public LinkedList<dcv> MIa = new LinkedList<>();
    public String Mgh;
    public String Name;
    public String URL;
    public int oTz;

    public dcu() {
        AppMethodBeat.i(209798);
        AppMethodBeat.o(209798);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(209799);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.Name != null) {
                aVar.e(1, this.Name);
            }
            if (this.Mgh != null) {
                aVar.e(2, this.Mgh);
            }
            if (this.URL != null) {
                aVar.e(3, this.URL);
            }
            aVar.aM(4, this.oTz);
            if (this.MHf != null) {
                aVar.e(5, this.MHf);
            }
            aVar.e(6, 8, this.MIa);
            AppMethodBeat.o(209799);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.Name != null ? g.a.a.b.b.a.f(1, this.Name) + 0 : 0;
            if (this.Mgh != null) {
                f2 += g.a.a.b.b.a.f(2, this.Mgh);
            }
            if (this.URL != null) {
                f2 += g.a.a.b.b.a.f(3, this.URL);
            }
            int bu = f2 + g.a.a.b.b.a.bu(4, this.oTz);
            if (this.MHf != null) {
                bu += g.a.a.b.b.a.f(5, this.MHf);
            }
            int c2 = bu + g.a.a.a.c(6, 8, this.MIa);
            AppMethodBeat.o(209799);
            return c2;
        } else if (i2 == 2) {
            this.MIa.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(209799);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            dcu dcu = (dcu) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    dcu.Name = aVar3.UbS.readString();
                    AppMethodBeat.o(209799);
                    return 0;
                case 2:
                    dcu.Mgh = aVar3.UbS.readString();
                    AppMethodBeat.o(209799);
                    return 0;
                case 3:
                    dcu.URL = aVar3.UbS.readString();
                    AppMethodBeat.o(209799);
                    return 0;
                case 4:
                    dcu.oTz = aVar3.UbS.zi();
                    AppMethodBeat.o(209799);
                    return 0;
                case 5:
                    dcu.MHf = aVar3.UbS.readString();
                    AppMethodBeat.o(209799);
                    return 0;
                case 6:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        dcv dcv = new dcv();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = dcv.populateBuilderWithField(aVar4, dcv, a.getNextFieldNumber(aVar4))) {
                        }
                        dcu.MIa.add(dcv);
                    }
                    AppMethodBeat.o(209799);
                    return 0;
                default:
                    AppMethodBeat.o(209799);
                    return -1;
            }
        } else {
            AppMethodBeat.o(209799);
            return -1;
        }
    }
}

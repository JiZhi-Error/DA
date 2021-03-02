package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class ehr extends a {
    public LinkedList<cty> MJY = new LinkedList<>();
    public String MJZ;
    public LinkedList<String> Nhh = new LinkedList<>();
    public int Nhi;
    public String dNI;
    public String dQx;
    public int version;

    public ehr() {
        AppMethodBeat.i(176151);
        AppMethodBeat.o(176151);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(176152);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.e(1, 1, this.Nhh);
            aVar.e(2, 8, this.MJY);
            if (this.dQx != null) {
                aVar.e(3, this.dQx);
            }
            aVar.aM(4, this.Nhi);
            if (this.MJZ != null) {
                aVar.e(5, this.MJZ);
            }
            if (this.dNI != null) {
                aVar.e(6, this.dNI);
            }
            aVar.aM(7, this.version);
            AppMethodBeat.o(176152);
            return 0;
        } else if (i2 == 1) {
            int c2 = g.a.a.a.c(1, 1, this.Nhh) + 0 + g.a.a.a.c(2, 8, this.MJY);
            if (this.dQx != null) {
                c2 += g.a.a.b.b.a.f(3, this.dQx);
            }
            int bu = c2 + g.a.a.b.b.a.bu(4, this.Nhi);
            if (this.MJZ != null) {
                bu += g.a.a.b.b.a.f(5, this.MJZ);
            }
            if (this.dNI != null) {
                bu += g.a.a.b.b.a.f(6, this.dNI);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(7, this.version);
            AppMethodBeat.o(176152);
            return bu2;
        } else if (i2 == 2) {
            this.Nhh.clear();
            this.MJY.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(176152);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            ehr ehr = (ehr) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    ehr.Nhh.add(aVar3.UbS.readString());
                    AppMethodBeat.o(176152);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        cty cty = new cty();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = cty.populateBuilderWithField(aVar4, cty, a.getNextFieldNumber(aVar4))) {
                        }
                        ehr.MJY.add(cty);
                    }
                    AppMethodBeat.o(176152);
                    return 0;
                case 3:
                    ehr.dQx = aVar3.UbS.readString();
                    AppMethodBeat.o(176152);
                    return 0;
                case 4:
                    ehr.Nhi = aVar3.UbS.zi();
                    AppMethodBeat.o(176152);
                    return 0;
                case 5:
                    ehr.MJZ = aVar3.UbS.readString();
                    AppMethodBeat.o(176152);
                    return 0;
                case 6:
                    ehr.dNI = aVar3.UbS.readString();
                    AppMethodBeat.o(176152);
                    return 0;
                case 7:
                    ehr.version = aVar3.UbS.zi();
                    AppMethodBeat.o(176152);
                    return 0;
                default:
                    AppMethodBeat.o(176152);
                    return -1;
            }
        } else {
            AppMethodBeat.o(176152);
            return -1;
        }
    }
}

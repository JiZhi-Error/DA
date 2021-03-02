package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class anz extends a {
    public int HZA;
    public String LzE;
    public String LzF;
    public aoa field_area_info;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(72475);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.HZA);
            if (this.field_area_info != null) {
                aVar.ni(2, this.field_area_info.computeSize());
                this.field_area_info.writeFields(aVar);
            }
            if (this.LzE != null) {
                aVar.e(3, this.LzE);
            }
            if (this.LzF != null) {
                aVar.e(4, this.LzF);
            }
            AppMethodBeat.o(72475);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.HZA) + 0;
            if (this.field_area_info != null) {
                bu += g.a.a.a.nh(2, this.field_area_info.computeSize());
            }
            if (this.LzE != null) {
                bu += g.a.a.b.b.a.f(3, this.LzE);
            }
            if (this.LzF != null) {
                bu += g.a.a.b.b.a.f(4, this.LzF);
            }
            AppMethodBeat.o(72475);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(72475);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            anz anz = (anz) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    anz.HZA = aVar3.UbS.zi();
                    AppMethodBeat.o(72475);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        aoa aoa = new aoa();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = aoa.populateBuilderWithField(aVar4, aoa, a.getNextFieldNumber(aVar4))) {
                        }
                        anz.field_area_info = aoa;
                    }
                    AppMethodBeat.o(72475);
                    return 0;
                case 3:
                    anz.LzE = aVar3.UbS.readString();
                    AppMethodBeat.o(72475);
                    return 0;
                case 4:
                    anz.LzF = aVar3.UbS.readString();
                    AppMethodBeat.o(72475);
                    return 0;
                default:
                    AppMethodBeat.o(72475);
                    return -1;
            }
        } else {
            AppMethodBeat.o(72475);
            return -1;
        }
    }
}

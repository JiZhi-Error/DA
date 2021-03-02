package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class qa extends a {
    public String HWM;
    public LinkedList<qa> KWT = new LinkedList<>();
    public int iOt;
    public int id;
    public String key;
    public String name;
    public int type;
    public String value;

    public qa() {
        AppMethodBeat.i(124457);
        AppMethodBeat.o(124457);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(124458);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.id);
            aVar.aM(2, this.type);
            if (this.name != null) {
                aVar.e(3, this.name);
            }
            if (this.key != null) {
                aVar.e(4, this.key);
            }
            if (this.value != null) {
                aVar.e(5, this.value);
            }
            aVar.e(6, 8, this.KWT);
            aVar.aM(7, this.iOt);
            if (this.HWM != null) {
                aVar.e(8, this.HWM);
            }
            AppMethodBeat.o(124458);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.id) + 0 + g.a.a.b.b.a.bu(2, this.type);
            if (this.name != null) {
                bu += g.a.a.b.b.a.f(3, this.name);
            }
            if (this.key != null) {
                bu += g.a.a.b.b.a.f(4, this.key);
            }
            if (this.value != null) {
                bu += g.a.a.b.b.a.f(5, this.value);
            }
            int c2 = bu + g.a.a.a.c(6, 8, this.KWT) + g.a.a.b.b.a.bu(7, this.iOt);
            if (this.HWM != null) {
                c2 += g.a.a.b.b.a.f(8, this.HWM);
            }
            AppMethodBeat.o(124458);
            return c2;
        } else if (i2 == 2) {
            this.KWT.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(124458);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            qa qaVar = (qa) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    qaVar.id = aVar3.UbS.zi();
                    AppMethodBeat.o(124458);
                    return 0;
                case 2:
                    qaVar.type = aVar3.UbS.zi();
                    AppMethodBeat.o(124458);
                    return 0;
                case 3:
                    qaVar.name = aVar3.UbS.readString();
                    AppMethodBeat.o(124458);
                    return 0;
                case 4:
                    qaVar.key = aVar3.UbS.readString();
                    AppMethodBeat.o(124458);
                    return 0;
                case 5:
                    qaVar.value = aVar3.UbS.readString();
                    AppMethodBeat.o(124458);
                    return 0;
                case 6:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        qa qaVar2 = new qa();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = qaVar2.populateBuilderWithField(aVar4, qaVar2, a.getNextFieldNumber(aVar4))) {
                        }
                        qaVar.KWT.add(qaVar2);
                    }
                    AppMethodBeat.o(124458);
                    return 0;
                case 7:
                    qaVar.iOt = aVar3.UbS.zi();
                    AppMethodBeat.o(124458);
                    return 0;
                case 8:
                    qaVar.HWM = aVar3.UbS.readString();
                    AppMethodBeat.o(124458);
                    return 0;
                default:
                    AppMethodBeat.o(124458);
                    return -1;
            }
        } else {
            AppMethodBeat.o(124458);
            return -1;
        }
    }
}

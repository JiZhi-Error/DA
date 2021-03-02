package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class yz extends a {
    public String LjZ;
    public String Lka;
    public String Lkb;
    public String Lkc;
    public String Lkd;
    public String Lke;
    public int Scene;
    public int oUv;
    public String yiZ;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(127628);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.Scene);
            aVar.aM(2, this.oUv);
            if (this.LjZ != null) {
                aVar.e(3, this.LjZ);
            }
            if (this.Lka != null) {
                aVar.e(4, this.Lka);
            }
            if (this.yiZ != null) {
                aVar.e(5, this.yiZ);
            }
            if (this.Lkb != null) {
                aVar.e(6, this.Lkb);
            }
            if (this.Lkc != null) {
                aVar.e(7, this.Lkc);
            }
            if (this.Lkd != null) {
                aVar.e(8, this.Lkd);
            }
            if (this.Lke != null) {
                aVar.e(9, this.Lke);
            }
            AppMethodBeat.o(127628);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.Scene) + 0 + g.a.a.b.b.a.bu(2, this.oUv);
            if (this.LjZ != null) {
                bu += g.a.a.b.b.a.f(3, this.LjZ);
            }
            if (this.Lka != null) {
                bu += g.a.a.b.b.a.f(4, this.Lka);
            }
            if (this.yiZ != null) {
                bu += g.a.a.b.b.a.f(5, this.yiZ);
            }
            if (this.Lkb != null) {
                bu += g.a.a.b.b.a.f(6, this.Lkb);
            }
            if (this.Lkc != null) {
                bu += g.a.a.b.b.a.f(7, this.Lkc);
            }
            if (this.Lkd != null) {
                bu += g.a.a.b.b.a.f(8, this.Lkd);
            }
            if (this.Lke != null) {
                bu += g.a.a.b.b.a.f(9, this.Lke);
            }
            AppMethodBeat.o(127628);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(127628);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            yz yzVar = (yz) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    yzVar.Scene = aVar3.UbS.zi();
                    AppMethodBeat.o(127628);
                    return 0;
                case 2:
                    yzVar.oUv = aVar3.UbS.zi();
                    AppMethodBeat.o(127628);
                    return 0;
                case 3:
                    yzVar.LjZ = aVar3.UbS.readString();
                    AppMethodBeat.o(127628);
                    return 0;
                case 4:
                    yzVar.Lka = aVar3.UbS.readString();
                    AppMethodBeat.o(127628);
                    return 0;
                case 5:
                    yzVar.yiZ = aVar3.UbS.readString();
                    AppMethodBeat.o(127628);
                    return 0;
                case 6:
                    yzVar.Lkb = aVar3.UbS.readString();
                    AppMethodBeat.o(127628);
                    return 0;
                case 7:
                    yzVar.Lkc = aVar3.UbS.readString();
                    AppMethodBeat.o(127628);
                    return 0;
                case 8:
                    yzVar.Lkd = aVar3.UbS.readString();
                    AppMethodBeat.o(127628);
                    return 0;
                case 9:
                    yzVar.Lke = aVar3.UbS.readString();
                    AppMethodBeat.o(127628);
                    return 0;
                default:
                    AppMethodBeat.o(127628);
                    return -1;
            }
        } else {
            AppMethodBeat.o(127628);
            return -1;
        }
    }
}

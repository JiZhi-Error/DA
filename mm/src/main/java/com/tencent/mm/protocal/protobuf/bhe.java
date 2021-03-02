package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public class bhe extends a {
    public int LQQ;
    public int LQY;
    public String LQZ;
    public String LRa;
    public String LRb;
    public String LRc;
    public int Scene;
    public String jfi;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(152546);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.LQY);
            if (this.LQZ != null) {
                aVar.e(2, this.LQZ);
            }
            if (this.jfi != null) {
                aVar.e(3, this.jfi);
            }
            if (this.LRa != null) {
                aVar.e(4, this.LRa);
            }
            if (this.LRb != null) {
                aVar.e(5, this.LRb);
            }
            if (this.LRc != null) {
                aVar.e(7, this.LRc);
            }
            aVar.aM(8, this.LQQ);
            aVar.aM(9, this.Scene);
            AppMethodBeat.o(152546);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.LQY) + 0;
            if (this.LQZ != null) {
                bu += g.a.a.b.b.a.f(2, this.LQZ);
            }
            if (this.jfi != null) {
                bu += g.a.a.b.b.a.f(3, this.jfi);
            }
            if (this.LRa != null) {
                bu += g.a.a.b.b.a.f(4, this.LRa);
            }
            if (this.LRb != null) {
                bu += g.a.a.b.b.a.f(5, this.LRb);
            }
            if (this.LRc != null) {
                bu += g.a.a.b.b.a.f(7, this.LRc);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(8, this.LQQ) + g.a.a.b.b.a.bu(9, this.Scene);
            AppMethodBeat.o(152546);
            return bu2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(152546);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            bhe bhe = (bhe) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bhe.LQY = aVar3.UbS.zi();
                    AppMethodBeat.o(152546);
                    return 0;
                case 2:
                    bhe.LQZ = aVar3.UbS.readString();
                    AppMethodBeat.o(152546);
                    return 0;
                case 3:
                    bhe.jfi = aVar3.UbS.readString();
                    AppMethodBeat.o(152546);
                    return 0;
                case 4:
                    bhe.LRa = aVar3.UbS.readString();
                    AppMethodBeat.o(152546);
                    return 0;
                case 5:
                    bhe.LRb = aVar3.UbS.readString();
                    AppMethodBeat.o(152546);
                    return 0;
                case 6:
                default:
                    AppMethodBeat.o(152546);
                    return -1;
                case 7:
                    bhe.LRc = aVar3.UbS.readString();
                    AppMethodBeat.o(152546);
                    return 0;
                case 8:
                    bhe.LQQ = aVar3.UbS.zi();
                    AppMethodBeat.o(152546);
                    return 0;
                case 9:
                    bhe.Scene = aVar3.UbS.zi();
                    AppMethodBeat.o(152546);
                    return 0;
            }
        } else {
            AppMethodBeat.o(152546);
            return -1;
        }
    }
}

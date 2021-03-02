package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class edn extends a {
    public int Gat;
    public String Gav;
    public String NdO;
    public String NdP;
    public String NdQ;
    public int height;
    public int width;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(168761);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.Gat);
            if (this.Gav != null) {
                aVar.e(2, this.Gav);
            }
            if (this.NdO != null) {
                aVar.e(3, this.NdO);
            }
            aVar.aM(4, this.height);
            aVar.aM(5, this.width);
            if (this.NdP != null) {
                aVar.e(6, this.NdP);
            }
            if (this.NdQ != null) {
                aVar.e(7, this.NdQ);
            }
            AppMethodBeat.o(168761);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.Gat) + 0;
            if (this.Gav != null) {
                bu += g.a.a.b.b.a.f(2, this.Gav);
            }
            if (this.NdO != null) {
                bu += g.a.a.b.b.a.f(3, this.NdO);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(4, this.height) + g.a.a.b.b.a.bu(5, this.width);
            if (this.NdP != null) {
                bu2 += g.a.a.b.b.a.f(6, this.NdP);
            }
            if (this.NdQ != null) {
                bu2 += g.a.a.b.b.a.f(7, this.NdQ);
            }
            AppMethodBeat.o(168761);
            return bu2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(168761);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            edn edn = (edn) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    edn.Gat = aVar3.UbS.zi();
                    AppMethodBeat.o(168761);
                    return 0;
                case 2:
                    edn.Gav = aVar3.UbS.readString();
                    AppMethodBeat.o(168761);
                    return 0;
                case 3:
                    edn.NdO = aVar3.UbS.readString();
                    AppMethodBeat.o(168761);
                    return 0;
                case 4:
                    edn.height = aVar3.UbS.zi();
                    AppMethodBeat.o(168761);
                    return 0;
                case 5:
                    edn.width = aVar3.UbS.zi();
                    AppMethodBeat.o(168761);
                    return 0;
                case 6:
                    edn.NdP = aVar3.UbS.readString();
                    AppMethodBeat.o(168761);
                    return 0;
                case 7:
                    edn.NdQ = aVar3.UbS.readString();
                    AppMethodBeat.o(168761);
                    return 0;
                default:
                    AppMethodBeat.o(168761);
                    return -1;
            }
        } else {
            AppMethodBeat.o(168761);
            return -1;
        }
    }
}

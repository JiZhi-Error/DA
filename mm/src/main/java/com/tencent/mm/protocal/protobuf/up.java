package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class up extends a {
    public int LdV;
    public String LdW;
    public String LdX;
    public String LdY;
    public int LdZ;
    public String Lea;
    public un Leb;
    public String Lec;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(113967);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.LdV);
            if (this.LdW != null) {
                aVar.e(2, this.LdW);
            }
            if (this.LdX != null) {
                aVar.e(3, this.LdX);
            }
            if (this.LdY != null) {
                aVar.e(4, this.LdY);
            }
            aVar.aM(5, this.LdZ);
            if (this.Lea != null) {
                aVar.e(6, this.Lea);
            }
            if (this.Leb != null) {
                aVar.ni(7, this.Leb.computeSize());
                this.Leb.writeFields(aVar);
            }
            if (this.Lec != null) {
                aVar.e(8, this.Lec);
            }
            AppMethodBeat.o(113967);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.LdV) + 0;
            if (this.LdW != null) {
                bu += g.a.a.b.b.a.f(2, this.LdW);
            }
            if (this.LdX != null) {
                bu += g.a.a.b.b.a.f(3, this.LdX);
            }
            if (this.LdY != null) {
                bu += g.a.a.b.b.a.f(4, this.LdY);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(5, this.LdZ);
            if (this.Lea != null) {
                bu2 += g.a.a.b.b.a.f(6, this.Lea);
            }
            if (this.Leb != null) {
                bu2 += g.a.a.a.nh(7, this.Leb.computeSize());
            }
            if (this.Lec != null) {
                bu2 += g.a.a.b.b.a.f(8, this.Lec);
            }
            AppMethodBeat.o(113967);
            return bu2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(113967);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            up upVar = (up) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    upVar.LdV = aVar3.UbS.zi();
                    AppMethodBeat.o(113967);
                    return 0;
                case 2:
                    upVar.LdW = aVar3.UbS.readString();
                    AppMethodBeat.o(113967);
                    return 0;
                case 3:
                    upVar.LdX = aVar3.UbS.readString();
                    AppMethodBeat.o(113967);
                    return 0;
                case 4:
                    upVar.LdY = aVar3.UbS.readString();
                    AppMethodBeat.o(113967);
                    return 0;
                case 5:
                    upVar.LdZ = aVar3.UbS.zi();
                    AppMethodBeat.o(113967);
                    return 0;
                case 6:
                    upVar.Lea = aVar3.UbS.readString();
                    AppMethodBeat.o(113967);
                    return 0;
                case 7:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        un unVar = new un();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = unVar.populateBuilderWithField(aVar4, unVar, a.getNextFieldNumber(aVar4))) {
                        }
                        upVar.Leb = unVar;
                    }
                    AppMethodBeat.o(113967);
                    return 0;
                case 8:
                    upVar.Lec = aVar3.UbS.readString();
                    AppMethodBeat.o(113967);
                    return 0;
                default:
                    AppMethodBeat.o(113967);
                    return -1;
            }
        } else {
            AppMethodBeat.o(113967);
            return -1;
        }
    }
}

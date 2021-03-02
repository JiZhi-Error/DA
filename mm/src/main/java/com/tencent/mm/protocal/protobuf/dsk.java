package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class dsk extends a {
    public String LRO;
    public String Lir;
    public String Lis;
    public String LoE;
    public String LoF;
    public cvx MUN;
    public int MUk;
    public String UserName;
    public String jfi;
    public int kdY;
    public String oUJ;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(152685);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.UserName != null) {
                aVar.e(1, this.UserName);
            }
            if (this.oUJ != null) {
                aVar.e(2, this.oUJ);
            }
            if (this.LoE != null) {
                aVar.e(3, this.LoE);
            }
            if (this.LoF != null) {
                aVar.e(4, this.LoF);
            }
            aVar.aM(5, this.kdY);
            if (this.Lir != null) {
                aVar.e(6, this.Lir);
            }
            if (this.Lis != null) {
                aVar.e(7, this.Lis);
            }
            if (this.jfi != null) {
                aVar.e(8, this.jfi);
            }
            aVar.aM(9, this.MUk);
            if (this.MUN != null) {
                aVar.ni(10, this.MUN.computeSize());
                this.MUN.writeFields(aVar);
            }
            if (this.LRO != null) {
                aVar.e(11, this.LRO);
            }
            AppMethodBeat.o(152685);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.UserName != null ? g.a.a.b.b.a.f(1, this.UserName) + 0 : 0;
            if (this.oUJ != null) {
                f2 += g.a.a.b.b.a.f(2, this.oUJ);
            }
            if (this.LoE != null) {
                f2 += g.a.a.b.b.a.f(3, this.LoE);
            }
            if (this.LoF != null) {
                f2 += g.a.a.b.b.a.f(4, this.LoF);
            }
            int bu = f2 + g.a.a.b.b.a.bu(5, this.kdY);
            if (this.Lir != null) {
                bu += g.a.a.b.b.a.f(6, this.Lir);
            }
            if (this.Lis != null) {
                bu += g.a.a.b.b.a.f(7, this.Lis);
            }
            if (this.jfi != null) {
                bu += g.a.a.b.b.a.f(8, this.jfi);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(9, this.MUk);
            if (this.MUN != null) {
                bu2 += g.a.a.a.nh(10, this.MUN.computeSize());
            }
            if (this.LRO != null) {
                bu2 += g.a.a.b.b.a.f(11, this.LRO);
            }
            AppMethodBeat.o(152685);
            return bu2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(152685);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            dsk dsk = (dsk) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    dsk.UserName = aVar3.UbS.readString();
                    AppMethodBeat.o(152685);
                    return 0;
                case 2:
                    dsk.oUJ = aVar3.UbS.readString();
                    AppMethodBeat.o(152685);
                    return 0;
                case 3:
                    dsk.LoE = aVar3.UbS.readString();
                    AppMethodBeat.o(152685);
                    return 0;
                case 4:
                    dsk.LoF = aVar3.UbS.readString();
                    AppMethodBeat.o(152685);
                    return 0;
                case 5:
                    dsk.kdY = aVar3.UbS.zi();
                    AppMethodBeat.o(152685);
                    return 0;
                case 6:
                    dsk.Lir = aVar3.UbS.readString();
                    AppMethodBeat.o(152685);
                    return 0;
                case 7:
                    dsk.Lis = aVar3.UbS.readString();
                    AppMethodBeat.o(152685);
                    return 0;
                case 8:
                    dsk.jfi = aVar3.UbS.readString();
                    AppMethodBeat.o(152685);
                    return 0;
                case 9:
                    dsk.MUk = aVar3.UbS.zi();
                    AppMethodBeat.o(152685);
                    return 0;
                case 10:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        cvx cvx = new cvx();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = cvx.populateBuilderWithField(aVar4, cvx, a.getNextFieldNumber(aVar4))) {
                        }
                        dsk.MUN = cvx;
                    }
                    AppMethodBeat.o(152685);
                    return 0;
                case 11:
                    dsk.LRO = aVar3.UbS.readString();
                    AppMethodBeat.o(152685);
                    return 0;
                default:
                    AppMethodBeat.o(152685);
                    return -1;
            }
        } else {
            AppMethodBeat.o(152685);
            return -1;
        }
    }
}

package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class cbw extends a {
    public int Gaz;
    public int HFB;
    public String LWD;
    public String LjD;
    public long LpD;
    public String MhL;
    public dbf MhM;
    public int MhN;
    public int MhO;
    public String MhP;
    public int pRN;
    public String pTn;
    public int state;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(72505);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.LWD != null) {
                aVar.e(1, this.LWD);
            }
            if (this.LjD != null) {
                aVar.e(2, this.LjD);
            }
            aVar.bb(3, this.LpD);
            aVar.aM(4, this.state);
            if (this.MhL != null) {
                aVar.e(5, this.MhL);
            }
            aVar.aM(6, this.HFB);
            if (this.MhM != null) {
                aVar.ni(7, this.MhM.computeSize());
                this.MhM.writeFields(aVar);
            }
            aVar.aM(8, this.Gaz);
            aVar.aM(9, this.pRN);
            aVar.aM(10, this.MhN);
            aVar.aM(11, this.MhO);
            if (this.MhP != null) {
                aVar.e(12, this.MhP);
            }
            if (this.pTn != null) {
                aVar.e(13, this.pTn);
            }
            AppMethodBeat.o(72505);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.LWD != null ? g.a.a.b.b.a.f(1, this.LWD) + 0 : 0;
            if (this.LjD != null) {
                f2 += g.a.a.b.b.a.f(2, this.LjD);
            }
            int r = f2 + g.a.a.b.b.a.r(3, this.LpD) + g.a.a.b.b.a.bu(4, this.state);
            if (this.MhL != null) {
                r += g.a.a.b.b.a.f(5, this.MhL);
            }
            int bu = r + g.a.a.b.b.a.bu(6, this.HFB);
            if (this.MhM != null) {
                bu += g.a.a.a.nh(7, this.MhM.computeSize());
            }
            int bu2 = bu + g.a.a.b.b.a.bu(8, this.Gaz) + g.a.a.b.b.a.bu(9, this.pRN) + g.a.a.b.b.a.bu(10, this.MhN) + g.a.a.b.b.a.bu(11, this.MhO);
            if (this.MhP != null) {
                bu2 += g.a.a.b.b.a.f(12, this.MhP);
            }
            if (this.pTn != null) {
                bu2 += g.a.a.b.b.a.f(13, this.pTn);
            }
            AppMethodBeat.o(72505);
            return bu2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(72505);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            cbw cbw = (cbw) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    cbw.LWD = aVar3.UbS.readString();
                    AppMethodBeat.o(72505);
                    return 0;
                case 2:
                    cbw.LjD = aVar3.UbS.readString();
                    AppMethodBeat.o(72505);
                    return 0;
                case 3:
                    cbw.LpD = aVar3.UbS.zl();
                    AppMethodBeat.o(72505);
                    return 0;
                case 4:
                    cbw.state = aVar3.UbS.zi();
                    AppMethodBeat.o(72505);
                    return 0;
                case 5:
                    cbw.MhL = aVar3.UbS.readString();
                    AppMethodBeat.o(72505);
                    return 0;
                case 6:
                    cbw.HFB = aVar3.UbS.zi();
                    AppMethodBeat.o(72505);
                    return 0;
                case 7:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        dbf dbf = new dbf();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = dbf.populateBuilderWithField(aVar4, dbf, a.getNextFieldNumber(aVar4))) {
                        }
                        cbw.MhM = dbf;
                    }
                    AppMethodBeat.o(72505);
                    return 0;
                case 8:
                    cbw.Gaz = aVar3.UbS.zi();
                    AppMethodBeat.o(72505);
                    return 0;
                case 9:
                    cbw.pRN = aVar3.UbS.zi();
                    AppMethodBeat.o(72505);
                    return 0;
                case 10:
                    cbw.MhN = aVar3.UbS.zi();
                    AppMethodBeat.o(72505);
                    return 0;
                case 11:
                    cbw.MhO = aVar3.UbS.zi();
                    AppMethodBeat.o(72505);
                    return 0;
                case 12:
                    cbw.MhP = aVar3.UbS.readString();
                    AppMethodBeat.o(72505);
                    return 0;
                case 13:
                    cbw.pTn = aVar3.UbS.readString();
                    AppMethodBeat.o(72505);
                    return 0;
                default:
                    AppMethodBeat.o(72505);
                    return -1;
            }
        } else {
            AppMethodBeat.o(72505);
            return -1;
        }
    }
}

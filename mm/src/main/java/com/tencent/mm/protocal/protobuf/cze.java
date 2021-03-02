package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class cze extends a {
    public String KXA;
    public String MEr;
    public int MEs;
    public int MEt;
    public int MaY;
    public String Mba;
    public chl MlQ;
    public aah MlR;
    public int Scene;
    public String SessionId;
    public int xMB;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(117889);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.KXA != null) {
                aVar.e(1, this.KXA);
            }
            if (this.MlQ != null) {
                aVar.ni(2, this.MlQ.computeSize());
                this.MlQ.writeFields(aVar);
            }
            if (this.SessionId != null) {
                aVar.e(3, this.SessionId);
            }
            if (this.Mba != null) {
                aVar.e(4, this.Mba);
            }
            if (this.MEr != null) {
                aVar.e(5, this.MEr);
            }
            aVar.aM(6, this.MEs);
            aVar.aM(7, this.MaY);
            aVar.aM(8, this.MEt);
            aVar.aM(9, this.Scene);
            aVar.aM(10, this.xMB);
            if (this.MlR != null) {
                aVar.ni(11, this.MlR.computeSize());
                this.MlR.writeFields(aVar);
            }
            AppMethodBeat.o(117889);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.KXA != null ? g.a.a.b.b.a.f(1, this.KXA) + 0 : 0;
            if (this.MlQ != null) {
                f2 += g.a.a.a.nh(2, this.MlQ.computeSize());
            }
            if (this.SessionId != null) {
                f2 += g.a.a.b.b.a.f(3, this.SessionId);
            }
            if (this.Mba != null) {
                f2 += g.a.a.b.b.a.f(4, this.Mba);
            }
            if (this.MEr != null) {
                f2 += g.a.a.b.b.a.f(5, this.MEr);
            }
            int bu = f2 + g.a.a.b.b.a.bu(6, this.MEs) + g.a.a.b.b.a.bu(7, this.MaY) + g.a.a.b.b.a.bu(8, this.MEt) + g.a.a.b.b.a.bu(9, this.Scene) + g.a.a.b.b.a.bu(10, this.xMB);
            if (this.MlR != null) {
                bu += g.a.a.a.nh(11, this.MlR.computeSize());
            }
            AppMethodBeat.o(117889);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(117889);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            cze cze = (cze) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    cze.KXA = aVar3.UbS.readString();
                    AppMethodBeat.o(117889);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        chl chl = new chl();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = chl.populateBuilderWithField(aVar4, chl, a.getNextFieldNumber(aVar4))) {
                        }
                        cze.MlQ = chl;
                    }
                    AppMethodBeat.o(117889);
                    return 0;
                case 3:
                    cze.SessionId = aVar3.UbS.readString();
                    AppMethodBeat.o(117889);
                    return 0;
                case 4:
                    cze.Mba = aVar3.UbS.readString();
                    AppMethodBeat.o(117889);
                    return 0;
                case 5:
                    cze.MEr = aVar3.UbS.readString();
                    AppMethodBeat.o(117889);
                    return 0;
                case 6:
                    cze.MEs = aVar3.UbS.zi();
                    AppMethodBeat.o(117889);
                    return 0;
                case 7:
                    cze.MaY = aVar3.UbS.zi();
                    AppMethodBeat.o(117889);
                    return 0;
                case 8:
                    cze.MEt = aVar3.UbS.zi();
                    AppMethodBeat.o(117889);
                    return 0;
                case 9:
                    cze.Scene = aVar3.UbS.zi();
                    AppMethodBeat.o(117889);
                    return 0;
                case 10:
                    cze.xMB = aVar3.UbS.zi();
                    AppMethodBeat.o(117889);
                    return 0;
                case 11:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        aah aah = new aah();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = aah.populateBuilderWithField(aVar5, aah, a.getNextFieldNumber(aVar5))) {
                        }
                        cze.MlR = aah;
                    }
                    AppMethodBeat.o(117889);
                    return 0;
                default:
                    AppMethodBeat.o(117889);
                    return -1;
            }
        } else {
            AppMethodBeat.o(117889);
            return -1;
        }
    }
}

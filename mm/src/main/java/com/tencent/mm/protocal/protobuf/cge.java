package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class cge extends a {
    public String KXA;
    public int MaY;
    public String Mba;
    public chl MlQ;
    public aah MlR;
    public int Scene;
    public String SessionId;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(187875);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.KXA != null) {
                aVar.e(1, this.KXA);
            }
            if (this.MlQ != null) {
                aVar.ni(2, this.MlQ.computeSize());
                this.MlQ.writeFields(aVar);
            }
            aVar.aM(3, this.Scene);
            if (this.MlR != null) {
                aVar.ni(4, this.MlR.computeSize());
                this.MlR.writeFields(aVar);
            }
            aVar.aM(5, this.MaY);
            if (this.Mba != null) {
                aVar.e(6, this.Mba);
            }
            if (this.SessionId != null) {
                aVar.e(7, this.SessionId);
            }
            AppMethodBeat.o(187875);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.KXA != null ? g.a.a.b.b.a.f(1, this.KXA) + 0 : 0;
            if (this.MlQ != null) {
                f2 += g.a.a.a.nh(2, this.MlQ.computeSize());
            }
            int bu = f2 + g.a.a.b.b.a.bu(3, this.Scene);
            if (this.MlR != null) {
                bu += g.a.a.a.nh(4, this.MlR.computeSize());
            }
            int bu2 = bu + g.a.a.b.b.a.bu(5, this.MaY);
            if (this.Mba != null) {
                bu2 += g.a.a.b.b.a.f(6, this.Mba);
            }
            if (this.SessionId != null) {
                bu2 += g.a.a.b.b.a.f(7, this.SessionId);
            }
            AppMethodBeat.o(187875);
            return bu2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(187875);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            cge cge = (cge) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    cge.KXA = aVar3.UbS.readString();
                    AppMethodBeat.o(187875);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        chl chl = new chl();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = chl.populateBuilderWithField(aVar4, chl, a.getNextFieldNumber(aVar4))) {
                        }
                        cge.MlQ = chl;
                    }
                    AppMethodBeat.o(187875);
                    return 0;
                case 3:
                    cge.Scene = aVar3.UbS.zi();
                    AppMethodBeat.o(187875);
                    return 0;
                case 4:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        aah aah = new aah();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = aah.populateBuilderWithField(aVar5, aah, a.getNextFieldNumber(aVar5))) {
                        }
                        cge.MlR = aah;
                    }
                    AppMethodBeat.o(187875);
                    return 0;
                case 5:
                    cge.MaY = aVar3.UbS.zi();
                    AppMethodBeat.o(187875);
                    return 0;
                case 6:
                    cge.Mba = aVar3.UbS.readString();
                    AppMethodBeat.o(187875);
                    return 0;
                case 7:
                    cge.SessionId = aVar3.UbS.readString();
                    AppMethodBeat.o(187875);
                    return 0;
                default:
                    AppMethodBeat.o(187875);
                    return -1;
            }
        } else {
            AppMethodBeat.o(187875);
            return -1;
        }
    }
}

package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class le extends a {
    public String KOS;
    public String KOX;
    public cpl KOY;
    public cat KOZ;
    public int Ret;
    public String oTI;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(82393);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.Ret);
            if (this.KOX != null) {
                aVar.e(2, this.KOX);
            }
            if (this.KOY != null) {
                aVar.ni(3, this.KOY.computeSize());
                this.KOY.writeFields(aVar);
            }
            if (this.KOS != null) {
                aVar.e(4, this.KOS);
            }
            if (this.oTI != null) {
                aVar.e(5, this.oTI);
            }
            if (this.KOZ != null) {
                aVar.ni(6, this.KOZ.computeSize());
                this.KOZ.writeFields(aVar);
            }
            AppMethodBeat.o(82393);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.Ret) + 0;
            if (this.KOX != null) {
                bu += g.a.a.b.b.a.f(2, this.KOX);
            }
            if (this.KOY != null) {
                bu += g.a.a.a.nh(3, this.KOY.computeSize());
            }
            if (this.KOS != null) {
                bu += g.a.a.b.b.a.f(4, this.KOS);
            }
            if (this.oTI != null) {
                bu += g.a.a.b.b.a.f(5, this.oTI);
            }
            if (this.KOZ != null) {
                bu += g.a.a.a.nh(6, this.KOZ.computeSize());
            }
            AppMethodBeat.o(82393);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(82393);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            le leVar = (le) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    leVar.Ret = aVar3.UbS.zi();
                    AppMethodBeat.o(82393);
                    return 0;
                case 2:
                    leVar.KOX = aVar3.UbS.readString();
                    AppMethodBeat.o(82393);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        cpl cpl = new cpl();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = cpl.populateBuilderWithField(aVar4, cpl, a.getNextFieldNumber(aVar4))) {
                        }
                        leVar.KOY = cpl;
                    }
                    AppMethodBeat.o(82393);
                    return 0;
                case 4:
                    leVar.KOS = aVar3.UbS.readString();
                    AppMethodBeat.o(82393);
                    return 0;
                case 5:
                    leVar.oTI = aVar3.UbS.readString();
                    AppMethodBeat.o(82393);
                    return 0;
                case 6:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        cat cat = new cat();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = cat.populateBuilderWithField(aVar5, cat, a.getNextFieldNumber(aVar5))) {
                        }
                        leVar.KOZ = cat;
                    }
                    AppMethodBeat.o(82393);
                    return 0;
                default:
                    AppMethodBeat.o(82393);
                    return -1;
            }
        } else {
            AppMethodBeat.o(82393);
            return -1;
        }
    }
}
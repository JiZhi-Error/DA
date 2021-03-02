package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class sm extends a {
    public String KDR;
    public String KGL;
    public sk LaA;
    public String Lav;
    public b Law;
    public sn Lax;
    public sl Lay;
    public so Laz;
    public String pPy;
    public String pPz;
    public int ybm;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(226006);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.ybm);
            if (this.pPy != null) {
                aVar.e(2, this.pPy);
            }
            if (this.pPz != null) {
                aVar.e(3, this.pPz);
            }
            if (this.KDR != null) {
                aVar.e(4, this.KDR);
            }
            if (this.Lav != null) {
                aVar.e(5, this.Lav);
            }
            if (this.Law != null) {
                aVar.c(6, this.Law);
            }
            if (this.KGL != null) {
                aVar.e(7, this.KGL);
            }
            if (this.Lax != null) {
                aVar.ni(101, this.Lax.computeSize());
                this.Lax.writeFields(aVar);
            }
            if (this.Lay != null) {
                aVar.ni(102, this.Lay.computeSize());
                this.Lay.writeFields(aVar);
            }
            if (this.Laz != null) {
                aVar.ni(103, this.Laz.computeSize());
                this.Laz.writeFields(aVar);
            }
            if (this.LaA != null) {
                aVar.ni(107, this.LaA.computeSize());
                this.LaA.writeFields(aVar);
            }
            AppMethodBeat.o(226006);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.ybm) + 0;
            if (this.pPy != null) {
                bu += g.a.a.b.b.a.f(2, this.pPy);
            }
            if (this.pPz != null) {
                bu += g.a.a.b.b.a.f(3, this.pPz);
            }
            if (this.KDR != null) {
                bu += g.a.a.b.b.a.f(4, this.KDR);
            }
            if (this.Lav != null) {
                bu += g.a.a.b.b.a.f(5, this.Lav);
            }
            if (this.Law != null) {
                bu += g.a.a.b.b.a.b(6, this.Law);
            }
            if (this.KGL != null) {
                bu += g.a.a.b.b.a.f(7, this.KGL);
            }
            if (this.Lax != null) {
                bu += g.a.a.a.nh(101, this.Lax.computeSize());
            }
            if (this.Lay != null) {
                bu += g.a.a.a.nh(102, this.Lay.computeSize());
            }
            if (this.Laz != null) {
                bu += g.a.a.a.nh(103, this.Laz.computeSize());
            }
            if (this.LaA != null) {
                bu += g.a.a.a.nh(107, this.LaA.computeSize());
            }
            AppMethodBeat.o(226006);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(226006);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            sm smVar = (sm) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    smVar.ybm = aVar3.UbS.zi();
                    AppMethodBeat.o(226006);
                    return 0;
                case 2:
                    smVar.pPy = aVar3.UbS.readString();
                    AppMethodBeat.o(226006);
                    return 0;
                case 3:
                    smVar.pPz = aVar3.UbS.readString();
                    AppMethodBeat.o(226006);
                    return 0;
                case 4:
                    smVar.KDR = aVar3.UbS.readString();
                    AppMethodBeat.o(226006);
                    return 0;
                case 5:
                    smVar.Lav = aVar3.UbS.readString();
                    AppMethodBeat.o(226006);
                    return 0;
                case 6:
                    smVar.Law = aVar3.UbS.hPo();
                    AppMethodBeat.o(226006);
                    return 0;
                case 7:
                    smVar.KGL = aVar3.UbS.readString();
                    AppMethodBeat.o(226006);
                    return 0;
                case 101:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        sn snVar = new sn();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = snVar.populateBuilderWithField(aVar4, snVar, a.getNextFieldNumber(aVar4))) {
                        }
                        smVar.Lax = snVar;
                    }
                    AppMethodBeat.o(226006);
                    return 0;
                case 102:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        sl slVar = new sl();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = slVar.populateBuilderWithField(aVar5, slVar, a.getNextFieldNumber(aVar5))) {
                        }
                        smVar.Lay = slVar;
                    }
                    AppMethodBeat.o(226006);
                    return 0;
                case 103:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        so soVar = new so();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = soVar.populateBuilderWithField(aVar6, soVar, a.getNextFieldNumber(aVar6))) {
                        }
                        smVar.Laz = soVar;
                    }
                    AppMethodBeat.o(226006);
                    return 0;
                case 107:
                    LinkedList<byte[]> awh4 = aVar3.awh(intValue);
                    int size4 = awh4.size();
                    for (int i6 = 0; i6 < size4; i6++) {
                        sk skVar = new sk();
                        g.a.a.a.a aVar7 = new g.a.a.a.a(awh4.get(i6), unknownTagHandler);
                        for (boolean z4 = true; z4; z4 = skVar.populateBuilderWithField(aVar7, skVar, a.getNextFieldNumber(aVar7))) {
                        }
                        smVar.LaA = skVar;
                    }
                    AppMethodBeat.o(226006);
                    return 0;
                default:
                    AppMethodBeat.o(226006);
                    return -1;
            }
        } else {
            AppMethodBeat.o(226006);
            return -1;
        }
    }
}

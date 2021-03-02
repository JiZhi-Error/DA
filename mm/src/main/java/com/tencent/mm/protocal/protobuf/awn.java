package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class awn extends a {
    public String KDS;
    public int LFG;
    public avn LHl;
    public avn LHm;
    public axd LHn;
    public LinkedList<awm> LHo = new LinkedList<>();
    public fgx Vjl;
    public int status;

    public awn() {
        AppMethodBeat.i(209537);
        AppMethodBeat.o(209537);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(209538);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.KDS != null) {
                aVar.e(1, this.KDS);
            }
            aVar.aM(2, this.LFG);
            if (this.LHl != null) {
                aVar.ni(3, this.LHl.computeSize());
                this.LHl.writeFields(aVar);
            }
            if (this.LHm != null) {
                aVar.ni(4, this.LHm.computeSize());
                this.LHm.writeFields(aVar);
            }
            aVar.aM(5, this.status);
            if (this.LHn != null) {
                aVar.ni(6, this.LHn.computeSize());
                this.LHn.writeFields(aVar);
            }
            aVar.e(7, 8, this.LHo);
            if (this.Vjl != null) {
                aVar.ni(8, this.Vjl.computeSize());
                this.Vjl.writeFields(aVar);
            }
            AppMethodBeat.o(209538);
            return 0;
        } else if (i2 == 1) {
            int f2 = (this.KDS != null ? g.a.a.b.b.a.f(1, this.KDS) + 0 : 0) + g.a.a.b.b.a.bu(2, this.LFG);
            if (this.LHl != null) {
                f2 += g.a.a.a.nh(3, this.LHl.computeSize());
            }
            if (this.LHm != null) {
                f2 += g.a.a.a.nh(4, this.LHm.computeSize());
            }
            int bu = f2 + g.a.a.b.b.a.bu(5, this.status);
            if (this.LHn != null) {
                bu += g.a.a.a.nh(6, this.LHn.computeSize());
            }
            int c2 = bu + g.a.a.a.c(7, 8, this.LHo);
            if (this.Vjl != null) {
                c2 += g.a.a.a.nh(8, this.Vjl.computeSize());
            }
            AppMethodBeat.o(209538);
            return c2;
        } else if (i2 == 2) {
            this.LHo.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(209538);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            awn awn = (awn) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    awn.KDS = aVar3.UbS.readString();
                    AppMethodBeat.o(209538);
                    return 0;
                case 2:
                    awn.LFG = aVar3.UbS.zi();
                    AppMethodBeat.o(209538);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        avn avn = new avn();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = avn.populateBuilderWithField(aVar4, avn, a.getNextFieldNumber(aVar4))) {
                        }
                        awn.LHl = avn;
                    }
                    AppMethodBeat.o(209538);
                    return 0;
                case 4:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        avn avn2 = new avn();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = avn2.populateBuilderWithField(aVar5, avn2, a.getNextFieldNumber(aVar5))) {
                        }
                        awn.LHm = avn2;
                    }
                    AppMethodBeat.o(209538);
                    return 0;
                case 5:
                    awn.status = aVar3.UbS.zi();
                    AppMethodBeat.o(209538);
                    return 0;
                case 6:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        axd axd = new axd();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = axd.populateBuilderWithField(aVar6, axd, a.getNextFieldNumber(aVar6))) {
                        }
                        awn.LHn = axd;
                    }
                    AppMethodBeat.o(209538);
                    return 0;
                case 7:
                    LinkedList<byte[]> awh4 = aVar3.awh(intValue);
                    int size4 = awh4.size();
                    for (int i6 = 0; i6 < size4; i6++) {
                        awm awm = new awm();
                        g.a.a.a.a aVar7 = new g.a.a.a.a(awh4.get(i6), unknownTagHandler);
                        for (boolean z4 = true; z4; z4 = awm.populateBuilderWithField(aVar7, awm, a.getNextFieldNumber(aVar7))) {
                        }
                        awn.LHo.add(awm);
                    }
                    AppMethodBeat.o(209538);
                    return 0;
                case 8:
                    LinkedList<byte[]> awh5 = aVar3.awh(intValue);
                    int size5 = awh5.size();
                    for (int i7 = 0; i7 < size5; i7++) {
                        fgx fgx = new fgx();
                        g.a.a.a.a aVar8 = new g.a.a.a.a(awh5.get(i7), unknownTagHandler);
                        for (boolean z5 = true; z5; z5 = fgx.populateBuilderWithField(aVar8, fgx, a.getNextFieldNumber(aVar8))) {
                        }
                        awn.Vjl = fgx;
                    }
                    AppMethodBeat.o(209538);
                    return 0;
                default:
                    AppMethodBeat.o(209538);
                    return -1;
            }
        } else {
            AppMethodBeat.o(209538);
            return -1;
        }
    }
}

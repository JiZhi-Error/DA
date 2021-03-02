package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.c.a;
import java.util.LinkedList;

public final class art extends dop {
    public aov LAI;
    public String LAt;
    public LinkedList<String> LDj = new LinkedList<>();
    public int LDk;
    public LinkedList<aps> LDl = new LinkedList<>();
    public LinkedList<apq> LDm = new LinkedList<>();
    public LinkedList<apo> LDn = new LinkedList<>();

    public art() {
        AppMethodBeat.i(209398);
        AppMethodBeat.o(209398);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(209399);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.LAI != null) {
                aVar.ni(2, this.LAI.computeSize());
                this.LAI.writeFields(aVar);
            }
            aVar.e(3, 1, this.LDj);
            aVar.aM(4, this.LDk);
            if (this.LAt != null) {
                aVar.e(5, this.LAt);
            }
            aVar.e(6, 8, this.LDl);
            aVar.e(7, 8, this.LDm);
            aVar.e(8, 8, this.LDn);
            AppMethodBeat.o(209399);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0;
            if (this.LAI != null) {
                nh += g.a.a.a.nh(2, this.LAI.computeSize());
            }
            int c2 = nh + g.a.a.a.c(3, 1, this.LDj) + g.a.a.b.b.a.bu(4, this.LDk);
            if (this.LAt != null) {
                c2 += g.a.a.b.b.a.f(5, this.LAt);
            }
            int c3 = c2 + g.a.a.a.c(6, 8, this.LDl) + g.a.a.a.c(7, 8, this.LDm) + g.a.a.a.c(8, 8, this.LDn);
            AppMethodBeat.o(209399);
            return c3;
        } else if (i2 == 2) {
            this.LDj.clear();
            this.LDl.clear();
            this.LDm.clear();
            this.LDn.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(209399);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            art art = (art) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        jr jrVar = new jr();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = jrVar.populateBuilderWithField(aVar4, jrVar, dop.getNextFieldNumber(aVar4))) {
                        }
                        art.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(209399);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        aov aov = new aov();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = aov.populateBuilderWithField(aVar5, aov, dop.getNextFieldNumber(aVar5))) {
                        }
                        art.LAI = aov;
                    }
                    AppMethodBeat.o(209399);
                    return 0;
                case 3:
                    art.LDj.add(aVar3.UbS.readString());
                    AppMethodBeat.o(209399);
                    return 0;
                case 4:
                    art.LDk = aVar3.UbS.zi();
                    AppMethodBeat.o(209399);
                    return 0;
                case 5:
                    art.LAt = aVar3.UbS.readString();
                    AppMethodBeat.o(209399);
                    return 0;
                case 6:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        aps aps = new aps();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = aps.populateBuilderWithField(aVar6, aps, dop.getNextFieldNumber(aVar6))) {
                        }
                        art.LDl.add(aps);
                    }
                    AppMethodBeat.o(209399);
                    return 0;
                case 7:
                    LinkedList<byte[]> awh4 = aVar3.awh(intValue);
                    int size4 = awh4.size();
                    for (int i6 = 0; i6 < size4; i6++) {
                        apq apq = new apq();
                        g.a.a.a.a aVar7 = new g.a.a.a.a(awh4.get(i6), unknownTagHandler);
                        for (boolean z4 = true; z4; z4 = apq.populateBuilderWithField(aVar7, apq, dop.getNextFieldNumber(aVar7))) {
                        }
                        art.LDm.add(apq);
                    }
                    AppMethodBeat.o(209399);
                    return 0;
                case 8:
                    LinkedList<byte[]> awh5 = aVar3.awh(intValue);
                    int size5 = awh5.size();
                    for (int i7 = 0; i7 < size5; i7++) {
                        apo apo = new apo();
                        g.a.a.a.a aVar8 = new g.a.a.a.a(awh5.get(i7), unknownTagHandler);
                        for (boolean z5 = true; z5; z5 = apo.populateBuilderWithField(aVar8, apo, dop.getNextFieldNumber(aVar8))) {
                        }
                        art.LDn.add(apo);
                    }
                    AppMethodBeat.o(209399);
                    return 0;
                default:
                    AppMethodBeat.o(209399);
                    return -1;
            }
        } else {
            AppMethodBeat.o(209399);
            return -1;
        }
    }
}

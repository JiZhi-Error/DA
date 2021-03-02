package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class hp extends a {
    public ho KLA;
    public bhx KLB;
    public String KLC;
    public String KLD;
    public String KLE;
    public drf KLF;
    public hw KLG;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(123544);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.KLA != null) {
                aVar.ni(1, this.KLA.computeSize());
                this.KLA.writeFields(aVar);
            }
            if (this.KLB != null) {
                aVar.ni(2, this.KLB.computeSize());
                this.KLB.writeFields(aVar);
            }
            if (this.KLC != null) {
                aVar.e(3, this.KLC);
            }
            if (this.KLD != null) {
                aVar.e(4, this.KLD);
            }
            if (this.KLE != null) {
                aVar.e(5, this.KLE);
            }
            if (this.KLF != null) {
                aVar.ni(6, this.KLF.computeSize());
                this.KLF.writeFields(aVar);
            }
            if (this.KLG != null) {
                aVar.ni(7, this.KLG.computeSize());
                this.KLG.writeFields(aVar);
            }
            AppMethodBeat.o(123544);
            return 0;
        } else if (i2 == 1) {
            int nh = this.KLA != null ? g.a.a.a.nh(1, this.KLA.computeSize()) + 0 : 0;
            if (this.KLB != null) {
                nh += g.a.a.a.nh(2, this.KLB.computeSize());
            }
            if (this.KLC != null) {
                nh += g.a.a.b.b.a.f(3, this.KLC);
            }
            if (this.KLD != null) {
                nh += g.a.a.b.b.a.f(4, this.KLD);
            }
            if (this.KLE != null) {
                nh += g.a.a.b.b.a.f(5, this.KLE);
            }
            if (this.KLF != null) {
                nh += g.a.a.a.nh(6, this.KLF.computeSize());
            }
            if (this.KLG != null) {
                nh += g.a.a.a.nh(7, this.KLG.computeSize());
            }
            AppMethodBeat.o(123544);
            return nh;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(123544);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            hp hpVar = (hp) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        ho hoVar = new ho();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = hoVar.populateBuilderWithField(aVar4, hoVar, a.getNextFieldNumber(aVar4))) {
                        }
                        hpVar.KLA = hoVar;
                    }
                    AppMethodBeat.o(123544);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        bhx bhx = new bhx();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = bhx.populateBuilderWithField(aVar5, bhx, a.getNextFieldNumber(aVar5))) {
                        }
                        hpVar.KLB = bhx;
                    }
                    AppMethodBeat.o(123544);
                    return 0;
                case 3:
                    hpVar.KLC = aVar3.UbS.readString();
                    AppMethodBeat.o(123544);
                    return 0;
                case 4:
                    hpVar.KLD = aVar3.UbS.readString();
                    AppMethodBeat.o(123544);
                    return 0;
                case 5:
                    hpVar.KLE = aVar3.UbS.readString();
                    AppMethodBeat.o(123544);
                    return 0;
                case 6:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        drf drf = new drf();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = drf.populateBuilderWithField(aVar6, drf, a.getNextFieldNumber(aVar6))) {
                        }
                        hpVar.KLF = drf;
                    }
                    AppMethodBeat.o(123544);
                    return 0;
                case 7:
                    LinkedList<byte[]> awh4 = aVar3.awh(intValue);
                    int size4 = awh4.size();
                    for (int i6 = 0; i6 < size4; i6++) {
                        hw hwVar = new hw();
                        g.a.a.a.a aVar7 = new g.a.a.a.a(awh4.get(i6), unknownTagHandler);
                        for (boolean z4 = true; z4; z4 = hwVar.populateBuilderWithField(aVar7, hwVar, a.getNextFieldNumber(aVar7))) {
                        }
                        hpVar.KLG = hwVar;
                    }
                    AppMethodBeat.o(123544);
                    return 0;
                default:
                    AppMethodBeat.o(123544);
                    return -1;
            }
        } else {
            AppMethodBeat.o(123544);
            return -1;
        }
    }
}

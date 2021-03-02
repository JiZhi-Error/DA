package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class aae extends a {
    public cfl IoL;
    public cfl IoM;
    public LinkedList<cfz> Llq = new LinkedList<>();
    public String subtitle;
    public String title;

    public aae() {
        AppMethodBeat.i(72460);
        AppMethodBeat.o(72460);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(72461);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.title != null) {
                aVar.e(1, this.title);
            }
            if (this.subtitle != null) {
                aVar.e(2, this.subtitle);
            }
            aVar.e(3, 8, this.Llq);
            if (this.IoL != null) {
                aVar.ni(4, this.IoL.computeSize());
                this.IoL.writeFields(aVar);
            }
            if (this.IoM != null) {
                aVar.ni(5, this.IoM.computeSize());
                this.IoM.writeFields(aVar);
            }
            AppMethodBeat.o(72461);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.title != null ? g.a.a.b.b.a.f(1, this.title) + 0 : 0;
            if (this.subtitle != null) {
                f2 += g.a.a.b.b.a.f(2, this.subtitle);
            }
            int c2 = f2 + g.a.a.a.c(3, 8, this.Llq);
            if (this.IoL != null) {
                c2 += g.a.a.a.nh(4, this.IoL.computeSize());
            }
            if (this.IoM != null) {
                c2 += g.a.a.a.nh(5, this.IoM.computeSize());
            }
            AppMethodBeat.o(72461);
            return c2;
        } else if (i2 == 2) {
            this.Llq.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(72461);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            aae aae = (aae) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    aae.title = aVar3.UbS.readString();
                    AppMethodBeat.o(72461);
                    return 0;
                case 2:
                    aae.subtitle = aVar3.UbS.readString();
                    AppMethodBeat.o(72461);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        cfz cfz = new cfz();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = cfz.populateBuilderWithField(aVar4, cfz, a.getNextFieldNumber(aVar4))) {
                        }
                        aae.Llq.add(cfz);
                    }
                    AppMethodBeat.o(72461);
                    return 0;
                case 4:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        cfl cfl = new cfl();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = cfl.populateBuilderWithField(aVar5, cfl, a.getNextFieldNumber(aVar5))) {
                        }
                        aae.IoL = cfl;
                    }
                    AppMethodBeat.o(72461);
                    return 0;
                case 5:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        cfl cfl2 = new cfl();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = cfl2.populateBuilderWithField(aVar6, cfl2, a.getNextFieldNumber(aVar6))) {
                        }
                        aae.IoM = cfl2;
                    }
                    AppMethodBeat.o(72461);
                    return 0;
                default:
                    AppMethodBeat.o(72461);
                    return -1;
            }
        } else {
            AppMethodBeat.o(72461);
            return -1;
        }
    }
}

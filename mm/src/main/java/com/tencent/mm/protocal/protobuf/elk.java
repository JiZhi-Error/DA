package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class elk extends a {
    public LinkedList<eli> KDk = new LinkedList<>();
    public int MMP;
    public String Nkr;
    public String Nks;
    public cig Nkt;
    public int Nku;
    public elj Nkv;
    public elj Nkw;
    public String desc;
    public String title;

    public elk() {
        AppMethodBeat.i(72617);
        AppMethodBeat.o(72617);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(72618);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.title != null) {
                aVar.e(1, this.title);
            }
            if (this.desc != null) {
                aVar.e(2, this.desc);
            }
            if (this.Nkr != null) {
                aVar.e(3, this.Nkr);
            }
            if (this.Nks != null) {
                aVar.e(4, this.Nks);
            }
            if (this.Nkt != null) {
                aVar.ni(5, this.Nkt.computeSize());
                this.Nkt.writeFields(aVar);
            }
            aVar.e(6, 8, this.KDk);
            aVar.aM(7, this.MMP);
            aVar.aM(8, this.Nku);
            if (this.Nkv != null) {
                aVar.ni(9, this.Nkv.computeSize());
                this.Nkv.writeFields(aVar);
            }
            if (this.Nkw != null) {
                aVar.ni(10, this.Nkw.computeSize());
                this.Nkw.writeFields(aVar);
            }
            AppMethodBeat.o(72618);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.title != null ? g.a.a.b.b.a.f(1, this.title) + 0 : 0;
            if (this.desc != null) {
                f2 += g.a.a.b.b.a.f(2, this.desc);
            }
            if (this.Nkr != null) {
                f2 += g.a.a.b.b.a.f(3, this.Nkr);
            }
            if (this.Nks != null) {
                f2 += g.a.a.b.b.a.f(4, this.Nks);
            }
            if (this.Nkt != null) {
                f2 += g.a.a.a.nh(5, this.Nkt.computeSize());
            }
            int c2 = f2 + g.a.a.a.c(6, 8, this.KDk) + g.a.a.b.b.a.bu(7, this.MMP) + g.a.a.b.b.a.bu(8, this.Nku);
            if (this.Nkv != null) {
                c2 += g.a.a.a.nh(9, this.Nkv.computeSize());
            }
            if (this.Nkw != null) {
                c2 += g.a.a.a.nh(10, this.Nkw.computeSize());
            }
            AppMethodBeat.o(72618);
            return c2;
        } else if (i2 == 2) {
            this.KDk.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(72618);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            elk elk = (elk) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    elk.title = aVar3.UbS.readString();
                    AppMethodBeat.o(72618);
                    return 0;
                case 2:
                    elk.desc = aVar3.UbS.readString();
                    AppMethodBeat.o(72618);
                    return 0;
                case 3:
                    elk.Nkr = aVar3.UbS.readString();
                    AppMethodBeat.o(72618);
                    return 0;
                case 4:
                    elk.Nks = aVar3.UbS.readString();
                    AppMethodBeat.o(72618);
                    return 0;
                case 5:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        cig cig = new cig();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = cig.populateBuilderWithField(aVar4, cig, a.getNextFieldNumber(aVar4))) {
                        }
                        elk.Nkt = cig;
                    }
                    AppMethodBeat.o(72618);
                    return 0;
                case 6:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        eli eli = new eli();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = eli.populateBuilderWithField(aVar5, eli, a.getNextFieldNumber(aVar5))) {
                        }
                        elk.KDk.add(eli);
                    }
                    AppMethodBeat.o(72618);
                    return 0;
                case 7:
                    elk.MMP = aVar3.UbS.zi();
                    AppMethodBeat.o(72618);
                    return 0;
                case 8:
                    elk.Nku = aVar3.UbS.zi();
                    AppMethodBeat.o(72618);
                    return 0;
                case 9:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        elj elj = new elj();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = elj.populateBuilderWithField(aVar6, elj, a.getNextFieldNumber(aVar6))) {
                        }
                        elk.Nkv = elj;
                    }
                    AppMethodBeat.o(72618);
                    return 0;
                case 10:
                    LinkedList<byte[]> awh4 = aVar3.awh(intValue);
                    int size4 = awh4.size();
                    for (int i6 = 0; i6 < size4; i6++) {
                        elj elj2 = new elj();
                        g.a.a.a.a aVar7 = new g.a.a.a.a(awh4.get(i6), unknownTagHandler);
                        for (boolean z4 = true; z4; z4 = elj2.populateBuilderWithField(aVar7, elj2, a.getNextFieldNumber(aVar7))) {
                        }
                        elk.Nkw = elj2;
                    }
                    AppMethodBeat.o(72618);
                    return 0;
                default:
                    AppMethodBeat.o(72618);
                    return -1;
            }
        } else {
            AppMethodBeat.o(72618);
            return -1;
        }
    }
}

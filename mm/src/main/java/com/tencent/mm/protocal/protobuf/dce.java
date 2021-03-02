package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class dce extends a {
    public String MGW;
    public LinkedList<dcf> MGX = new LinkedList<>();
    public LinkedList<dcl> MGY = new LinkedList<>();
    public LinkedList<dcl> MGZ = new LinkedList<>();

    public dce() {
        AppMethodBeat.i(209778);
        AppMethodBeat.o(209778);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(209779);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.MGW != null) {
                aVar.e(1, this.MGW);
            }
            aVar.e(2, 8, this.MGX);
            aVar.e(3, 8, this.MGY);
            aVar.e(4, 8, this.MGZ);
            AppMethodBeat.o(209779);
            return 0;
        } else if (i2 == 1) {
            int f2 = (this.MGW != null ? g.a.a.b.b.a.f(1, this.MGW) + 0 : 0) + g.a.a.a.c(2, 8, this.MGX) + g.a.a.a.c(3, 8, this.MGY) + g.a.a.a.c(4, 8, this.MGZ);
            AppMethodBeat.o(209779);
            return f2;
        } else if (i2 == 2) {
            this.MGX.clear();
            this.MGY.clear();
            this.MGZ.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(209779);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            dce dce = (dce) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    dce.MGW = aVar3.UbS.readString();
                    AppMethodBeat.o(209779);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        dcf dcf = new dcf();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = dcf.populateBuilderWithField(aVar4, dcf, a.getNextFieldNumber(aVar4))) {
                        }
                        dce.MGX.add(dcf);
                    }
                    AppMethodBeat.o(209779);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        dcl dcl = new dcl();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = dcl.populateBuilderWithField(aVar5, dcl, a.getNextFieldNumber(aVar5))) {
                        }
                        dce.MGY.add(dcl);
                    }
                    AppMethodBeat.o(209779);
                    return 0;
                case 4:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        dcl dcl2 = new dcl();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = dcl2.populateBuilderWithField(aVar6, dcl2, a.getNextFieldNumber(aVar6))) {
                        }
                        dce.MGZ.add(dcl2);
                    }
                    AppMethodBeat.o(209779);
                    return 0;
                default:
                    AppMethodBeat.o(209779);
                    return -1;
            }
        } else {
            AppMethodBeat.o(209779);
            return -1;
        }
    }
}

package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class baw extends a {
    public LinkedList<bax> LKA = new LinkedList<>();
    public LinkedList<cnt> LKB = new LinkedList<>();
    public bav LKz;
    public long uUw;

    public baw() {
        AppMethodBeat.i(184206);
        AppMethodBeat.o(184206);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(184207);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.bb(1, this.uUw);
            if (this.LKz != null) {
                aVar.ni(2, this.LKz.computeSize());
                this.LKz.writeFields(aVar);
            }
            aVar.e(3, 8, this.LKA);
            aVar.e(4, 8, this.LKB);
            AppMethodBeat.o(184207);
            return 0;
        } else if (i2 == 1) {
            int r = g.a.a.b.b.a.r(1, this.uUw) + 0;
            if (this.LKz != null) {
                r += g.a.a.a.nh(2, this.LKz.computeSize());
            }
            int c2 = r + g.a.a.a.c(3, 8, this.LKA) + g.a.a.a.c(4, 8, this.LKB);
            AppMethodBeat.o(184207);
            return c2;
        } else if (i2 == 2) {
            this.LKA.clear();
            this.LKB.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(184207);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            baw baw = (baw) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    baw.uUw = aVar3.UbS.zl();
                    AppMethodBeat.o(184207);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        bav bav = new bav();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = bav.populateBuilderWithField(aVar4, bav, a.getNextFieldNumber(aVar4))) {
                        }
                        baw.LKz = bav;
                    }
                    AppMethodBeat.o(184207);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        bax bax = new bax();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = bax.populateBuilderWithField(aVar5, bax, a.getNextFieldNumber(aVar5))) {
                        }
                        baw.LKA.add(bax);
                    }
                    AppMethodBeat.o(184207);
                    return 0;
                case 4:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        cnt cnt = new cnt();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = cnt.populateBuilderWithField(aVar6, cnt, a.getNextFieldNumber(aVar6))) {
                        }
                        baw.LKB.add(cnt);
                    }
                    AppMethodBeat.o(184207);
                    return 0;
                default:
                    AppMethodBeat.o(184207);
                    return -1;
            }
        } else {
            AppMethodBeat.o(184207);
            return -1;
        }
    }
}

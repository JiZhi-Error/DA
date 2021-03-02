package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class bdo extends a {
    public String Bvg;
    public int LNm;
    public int LNn;
    public b LNo;
    public LinkedList<String> LNp = new LinkedList<>();
    public aaw LNq;
    public int count;
    public String path;
    public String qGB;
    public String title;
    public int xGz;

    public bdo() {
        AppMethodBeat.i(209701);
        AppMethodBeat.o(209701);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(184212);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.xGz);
            aVar.aM(2, this.count);
            if (this.title != null) {
                aVar.e(3, this.title);
            }
            if (this.qGB != null) {
                aVar.e(4, this.qGB);
            }
            aVar.aM(5, this.LNm);
            if (this.path != null) {
                aVar.e(6, this.path);
            }
            if (this.Bvg != null) {
                aVar.e(7, this.Bvg);
            }
            aVar.aM(8, this.LNn);
            if (this.LNo != null) {
                aVar.c(9, this.LNo);
            }
            aVar.e(10, 1, this.LNp);
            if (this.LNq != null) {
                aVar.ni(11, this.LNq.computeSize());
                this.LNq.writeFields(aVar);
            }
            AppMethodBeat.o(184212);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.xGz) + 0 + g.a.a.b.b.a.bu(2, this.count);
            if (this.title != null) {
                bu += g.a.a.b.b.a.f(3, this.title);
            }
            if (this.qGB != null) {
                bu += g.a.a.b.b.a.f(4, this.qGB);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(5, this.LNm);
            if (this.path != null) {
                bu2 += g.a.a.b.b.a.f(6, this.path);
            }
            if (this.Bvg != null) {
                bu2 += g.a.a.b.b.a.f(7, this.Bvg);
            }
            int bu3 = bu2 + g.a.a.b.b.a.bu(8, this.LNn);
            if (this.LNo != null) {
                bu3 += g.a.a.b.b.a.b(9, this.LNo);
            }
            int c2 = bu3 + g.a.a.a.c(10, 1, this.LNp);
            if (this.LNq != null) {
                c2 += g.a.a.a.nh(11, this.LNq.computeSize());
            }
            AppMethodBeat.o(184212);
            return c2;
        } else if (i2 == 2) {
            this.LNp.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(184212);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            bdo bdo = (bdo) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    bdo.xGz = aVar3.UbS.zi();
                    AppMethodBeat.o(184212);
                    return 0;
                case 2:
                    bdo.count = aVar3.UbS.zi();
                    AppMethodBeat.o(184212);
                    return 0;
                case 3:
                    bdo.title = aVar3.UbS.readString();
                    AppMethodBeat.o(184212);
                    return 0;
                case 4:
                    bdo.qGB = aVar3.UbS.readString();
                    AppMethodBeat.o(184212);
                    return 0;
                case 5:
                    bdo.LNm = aVar3.UbS.zi();
                    AppMethodBeat.o(184212);
                    return 0;
                case 6:
                    bdo.path = aVar3.UbS.readString();
                    AppMethodBeat.o(184212);
                    return 0;
                case 7:
                    bdo.Bvg = aVar3.UbS.readString();
                    AppMethodBeat.o(184212);
                    return 0;
                case 8:
                    bdo.LNn = aVar3.UbS.zi();
                    AppMethodBeat.o(184212);
                    return 0;
                case 9:
                    bdo.LNo = aVar3.UbS.hPo();
                    AppMethodBeat.o(184212);
                    return 0;
                case 10:
                    bdo.LNp.add(aVar3.UbS.readString());
                    AppMethodBeat.o(184212);
                    return 0;
                case 11:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        aaw aaw = new aaw();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = aaw.populateBuilderWithField(aVar4, aaw, a.getNextFieldNumber(aVar4))) {
                        }
                        bdo.LNq = aaw;
                    }
                    AppMethodBeat.o(184212);
                    return 0;
                default:
                    AppMethodBeat.o(184212);
                    return -1;
            }
        } else {
            AppMethodBeat.o(184212);
            return -1;
        }
    }
}

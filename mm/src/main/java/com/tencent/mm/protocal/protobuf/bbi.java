package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class bbi extends a {
    public LinkedList<bdo> GaM = new LinkedList<>();
    public b LKL;
    public String LKM;
    public long LKN;
    public int MQX;
    public int VjD;
    public boolean VjE;
    public long feedId;
    public int pRN;
    public int priority;
    public int type;

    public bbi() {
        AppMethodBeat.i(184209);
        AppMethodBeat.o(184209);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(184210);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.priority);
            aVar.aM(2, this.type);
            if (this.LKL != null) {
                aVar.c(3, this.LKL);
            }
            aVar.e(4, 8, this.GaM);
            if (this.LKM != null) {
                aVar.e(5, this.LKM);
            }
            aVar.aM(6, this.pRN);
            aVar.aM(7, this.MQX);
            aVar.aM(8, this.VjD);
            aVar.cc(9, this.VjE);
            aVar.bb(100, this.feedId);
            aVar.bb(101, this.LKN);
            AppMethodBeat.o(184210);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.priority) + 0 + g.a.a.b.b.a.bu(2, this.type);
            if (this.LKL != null) {
                bu += g.a.a.b.b.a.b(3, this.LKL);
            }
            int c2 = bu + g.a.a.a.c(4, 8, this.GaM);
            if (this.LKM != null) {
                c2 += g.a.a.b.b.a.f(5, this.LKM);
            }
            int bu2 = c2 + g.a.a.b.b.a.bu(6, this.pRN) + g.a.a.b.b.a.bu(7, this.MQX) + g.a.a.b.b.a.bu(8, this.VjD) + g.a.a.b.b.a.fS(9) + 1 + g.a.a.b.b.a.r(100, this.feedId) + g.a.a.b.b.a.r(101, this.LKN);
            AppMethodBeat.o(184210);
            return bu2;
        } else if (i2 == 2) {
            this.GaM.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(184210);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            bbi bbi = (bbi) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    bbi.priority = aVar3.UbS.zi();
                    AppMethodBeat.o(184210);
                    return 0;
                case 2:
                    bbi.type = aVar3.UbS.zi();
                    AppMethodBeat.o(184210);
                    return 0;
                case 3:
                    bbi.LKL = aVar3.UbS.hPo();
                    AppMethodBeat.o(184210);
                    return 0;
                case 4:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        bdo bdo = new bdo();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = bdo.populateBuilderWithField(aVar4, bdo, a.getNextFieldNumber(aVar4))) {
                        }
                        bbi.GaM.add(bdo);
                    }
                    AppMethodBeat.o(184210);
                    return 0;
                case 5:
                    bbi.LKM = aVar3.UbS.readString();
                    AppMethodBeat.o(184210);
                    return 0;
                case 6:
                    bbi.pRN = aVar3.UbS.zi();
                    AppMethodBeat.o(184210);
                    return 0;
                case 7:
                    bbi.MQX = aVar3.UbS.zi();
                    AppMethodBeat.o(184210);
                    return 0;
                case 8:
                    bbi.VjD = aVar3.UbS.zi();
                    AppMethodBeat.o(184210);
                    return 0;
                case 9:
                    bbi.VjE = aVar3.UbS.yZ();
                    AppMethodBeat.o(184210);
                    return 0;
                case 100:
                    bbi.feedId = aVar3.UbS.zl();
                    AppMethodBeat.o(184210);
                    return 0;
                case 101:
                    bbi.LKN = aVar3.UbS.zl();
                    AppMethodBeat.o(184210);
                    return 0;
                default:
                    AppMethodBeat.o(184210);
                    return -1;
            }
        } else {
            AppMethodBeat.o(184210);
            return -1;
        }
    }
}

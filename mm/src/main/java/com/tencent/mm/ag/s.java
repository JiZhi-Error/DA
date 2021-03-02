package com.tencent.mm.ag;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public class s extends a {
    public String dHc;
    public String dHp;
    public long dTS;
    public int iAf;
    public String iAg;
    public String iAh;
    public v iAi;
    public LinkedList<String> iAj = new LinkedList<>();
    public int iwg;
    public long msgId;
    public int type;
    public String userName;

    public s() {
        AppMethodBeat.i(116415);
        AppMethodBeat.o(116415);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(116416);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.bb(1, this.msgId);
            aVar.bb(2, this.dTS);
            if (this.dHp != null) {
                aVar.e(3, this.dHp);
            }
            aVar.aM(4, this.iAf);
            aVar.aM(5, this.type);
            if (this.userName != null) {
                aVar.e(6, this.userName);
            }
            if (this.dHc != null) {
                aVar.e(7, this.dHc);
            }
            if (this.iAg != null) {
                aVar.e(8, this.iAg);
            }
            if (this.iAh != null) {
                aVar.e(9, this.iAh);
            }
            aVar.aM(10, this.iwg);
            if (this.iAi != null) {
                aVar.ni(11, this.iAi.computeSize());
                this.iAi.writeFields(aVar);
            }
            aVar.e(12, 1, this.iAj);
            AppMethodBeat.o(116416);
            return 0;
        } else if (i2 == 1) {
            int r = g.a.a.b.b.a.r(1, this.msgId) + 0 + g.a.a.b.b.a.r(2, this.dTS);
            if (this.dHp != null) {
                r += g.a.a.b.b.a.f(3, this.dHp);
            }
            int bu = r + g.a.a.b.b.a.bu(4, this.iAf) + g.a.a.b.b.a.bu(5, this.type);
            if (this.userName != null) {
                bu += g.a.a.b.b.a.f(6, this.userName);
            }
            if (this.dHc != null) {
                bu += g.a.a.b.b.a.f(7, this.dHc);
            }
            if (this.iAg != null) {
                bu += g.a.a.b.b.a.f(8, this.iAg);
            }
            if (this.iAh != null) {
                bu += g.a.a.b.b.a.f(9, this.iAh);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(10, this.iwg);
            if (this.iAi != null) {
                bu2 += g.a.a.a.nh(11, this.iAi.computeSize());
            }
            int c2 = bu2 + g.a.a.a.c(12, 1, this.iAj);
            AppMethodBeat.o(116416);
            return c2;
        } else if (i2 == 2) {
            this.iAj.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(116416);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            s sVar = (s) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    sVar.msgId = aVar3.UbS.zl();
                    AppMethodBeat.o(116416);
                    return 0;
                case 2:
                    sVar.dTS = aVar3.UbS.zl();
                    AppMethodBeat.o(116416);
                    return 0;
                case 3:
                    sVar.dHp = aVar3.UbS.readString();
                    AppMethodBeat.o(116416);
                    return 0;
                case 4:
                    sVar.iAf = aVar3.UbS.zi();
                    AppMethodBeat.o(116416);
                    return 0;
                case 5:
                    sVar.type = aVar3.UbS.zi();
                    AppMethodBeat.o(116416);
                    return 0;
                case 6:
                    sVar.userName = aVar3.UbS.readString();
                    AppMethodBeat.o(116416);
                    return 0;
                case 7:
                    sVar.dHc = aVar3.UbS.readString();
                    AppMethodBeat.o(116416);
                    return 0;
                case 8:
                    sVar.iAg = aVar3.UbS.readString();
                    AppMethodBeat.o(116416);
                    return 0;
                case 9:
                    sVar.iAh = aVar3.UbS.readString();
                    AppMethodBeat.o(116416);
                    return 0;
                case 10:
                    sVar.iwg = aVar3.UbS.zi();
                    AppMethodBeat.o(116416);
                    return 0;
                case 11:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        v vVar = new v();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = vVar.populateBuilderWithField(aVar4, vVar, a.getNextFieldNumber(aVar4))) {
                        }
                        sVar.iAi = vVar;
                    }
                    AppMethodBeat.o(116416);
                    return 0;
                case 12:
                    sVar.iAj.add(aVar3.UbS.readString());
                    AppMethodBeat.o(116416);
                    return 0;
                default:
                    AppMethodBeat.o(116416);
                    return -1;
            }
        } else {
            AppMethodBeat.o(116416);
            return -1;
        }
    }
}

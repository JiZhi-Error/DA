package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class cyl extends a {
    public int MDm = 0;
    public String MDn;
    public int MDo = -1;
    public cyi MDp;
    public String MDq = "";
    public boolean MDr = false;
    public String MDs = "";
    public boolean MDt = false;
    public int MDu = 0;
    public long endTime = 0;
    public int iOu = -1;
    public String kvy = "";
    public long seq = 0;
    public String sessionId;
    public long startTime = 0;
    public String userName = "";

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(122525);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.sessionId != null) {
                aVar.e(1, this.sessionId);
            }
            aVar.bb(2, this.seq);
            aVar.aM(3, this.MDm);
            if (this.MDn != null) {
                aVar.e(4, this.MDn);
            }
            aVar.aM(5, this.MDo);
            aVar.bb(6, this.startTime);
            aVar.bb(7, this.endTime);
            if (this.MDp != null) {
                aVar.ni(8, this.MDp.computeSize());
                this.MDp.writeFields(aVar);
            }
            if (this.MDq != null) {
                aVar.e(9, this.MDq);
            }
            aVar.cc(10, this.MDr);
            if (this.userName != null) {
                aVar.e(11, this.userName);
            }
            if (this.MDs != null) {
                aVar.e(12, this.MDs);
            }
            aVar.aM(13, this.iOu);
            aVar.cc(14, this.MDt);
            aVar.aM(15, this.MDu);
            if (this.kvy != null) {
                aVar.e(16, this.kvy);
            }
            AppMethodBeat.o(122525);
            return 0;
        } else if (i2 == 1) {
            int f2 = (this.sessionId != null ? g.a.a.b.b.a.f(1, this.sessionId) + 0 : 0) + g.a.a.b.b.a.r(2, this.seq) + g.a.a.b.b.a.bu(3, this.MDm);
            if (this.MDn != null) {
                f2 += g.a.a.b.b.a.f(4, this.MDn);
            }
            int bu = f2 + g.a.a.b.b.a.bu(5, this.MDo) + g.a.a.b.b.a.r(6, this.startTime) + g.a.a.b.b.a.r(7, this.endTime);
            if (this.MDp != null) {
                bu += g.a.a.a.nh(8, this.MDp.computeSize());
            }
            if (this.MDq != null) {
                bu += g.a.a.b.b.a.f(9, this.MDq);
            }
            int fS = bu + g.a.a.b.b.a.fS(10) + 1;
            if (this.userName != null) {
                fS += g.a.a.b.b.a.f(11, this.userName);
            }
            if (this.MDs != null) {
                fS += g.a.a.b.b.a.f(12, this.MDs);
            }
            int bu2 = fS + g.a.a.b.b.a.bu(13, this.iOu) + g.a.a.b.b.a.fS(14) + 1 + g.a.a.b.b.a.bu(15, this.MDu);
            if (this.kvy != null) {
                bu2 += g.a.a.b.b.a.f(16, this.kvy);
            }
            AppMethodBeat.o(122525);
            return bu2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(122525);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            cyl cyl = (cyl) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    cyl.sessionId = aVar3.UbS.readString();
                    AppMethodBeat.o(122525);
                    return 0;
                case 2:
                    cyl.seq = aVar3.UbS.zl();
                    AppMethodBeat.o(122525);
                    return 0;
                case 3:
                    cyl.MDm = aVar3.UbS.zi();
                    AppMethodBeat.o(122525);
                    return 0;
                case 4:
                    cyl.MDn = aVar3.UbS.readString();
                    AppMethodBeat.o(122525);
                    return 0;
                case 5:
                    cyl.MDo = aVar3.UbS.zi();
                    AppMethodBeat.o(122525);
                    return 0;
                case 6:
                    cyl.startTime = aVar3.UbS.zl();
                    AppMethodBeat.o(122525);
                    return 0;
                case 7:
                    cyl.endTime = aVar3.UbS.zl();
                    AppMethodBeat.o(122525);
                    return 0;
                case 8:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        cyi cyi = new cyi();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = cyi.populateBuilderWithField(aVar4, cyi, a.getNextFieldNumber(aVar4))) {
                        }
                        cyl.MDp = cyi;
                    }
                    AppMethodBeat.o(122525);
                    return 0;
                case 9:
                    cyl.MDq = aVar3.UbS.readString();
                    AppMethodBeat.o(122525);
                    return 0;
                case 10:
                    cyl.MDr = aVar3.UbS.yZ();
                    AppMethodBeat.o(122525);
                    return 0;
                case 11:
                    cyl.userName = aVar3.UbS.readString();
                    AppMethodBeat.o(122525);
                    return 0;
                case 12:
                    cyl.MDs = aVar3.UbS.readString();
                    AppMethodBeat.o(122525);
                    return 0;
                case 13:
                    cyl.iOu = aVar3.UbS.zi();
                    AppMethodBeat.o(122525);
                    return 0;
                case 14:
                    cyl.MDt = aVar3.UbS.yZ();
                    AppMethodBeat.o(122525);
                    return 0;
                case 15:
                    cyl.MDu = aVar3.UbS.zi();
                    AppMethodBeat.o(122525);
                    return 0;
                case 16:
                    cyl.kvy = aVar3.UbS.readString();
                    AppMethodBeat.o(122525);
                    return 0;
                default:
                    AppMethodBeat.o(122525);
                    return -1;
            }
        } else {
            AppMethodBeat.o(122525);
            return -1;
        }
    }
}

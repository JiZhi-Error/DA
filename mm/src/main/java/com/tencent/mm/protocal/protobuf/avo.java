package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.c.a;
import java.util.LinkedList;

public final class avo extends dop {
    public aov LAI;
    public long LGk;
    public int LGl;
    public String LGm;
    public awg LGn;
    public int LGo;
    public long hFK;
    public String hwg;
    public long liveId;
    public int opType;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(209508);
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
            aVar.bb(3, this.liveId);
            aVar.bb(4, this.hFK);
            aVar.bb(5, this.LGk);
            aVar.aM(6, this.LGl);
            if (this.LGm != null) {
                aVar.e(7, this.LGm);
            }
            if (this.LGn != null) {
                aVar.ni(8, this.LGn.computeSize());
                this.LGn.writeFields(aVar);
            }
            aVar.aM(9, this.LGo);
            aVar.aM(10, this.opType);
            if (this.hwg != null) {
                aVar.e(11, this.hwg);
            }
            AppMethodBeat.o(209508);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0;
            if (this.LAI != null) {
                nh += g.a.a.a.nh(2, this.LAI.computeSize());
            }
            int r = nh + g.a.a.b.b.a.r(3, this.liveId) + g.a.a.b.b.a.r(4, this.hFK) + g.a.a.b.b.a.r(5, this.LGk) + g.a.a.b.b.a.bu(6, this.LGl);
            if (this.LGm != null) {
                r += g.a.a.b.b.a.f(7, this.LGm);
            }
            if (this.LGn != null) {
                r += g.a.a.a.nh(8, this.LGn.computeSize());
            }
            int bu = r + g.a.a.b.b.a.bu(9, this.LGo) + g.a.a.b.b.a.bu(10, this.opType);
            if (this.hwg != null) {
                bu += g.a.a.b.b.a.f(11, this.hwg);
            }
            AppMethodBeat.o(209508);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(209508);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            avo avo = (avo) objArr[1];
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
                        avo.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(209508);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        aov aov = new aov();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = aov.populateBuilderWithField(aVar5, aov, dop.getNextFieldNumber(aVar5))) {
                        }
                        avo.LAI = aov;
                    }
                    AppMethodBeat.o(209508);
                    return 0;
                case 3:
                    avo.liveId = aVar3.UbS.zl();
                    AppMethodBeat.o(209508);
                    return 0;
                case 4:
                    avo.hFK = aVar3.UbS.zl();
                    AppMethodBeat.o(209508);
                    return 0;
                case 5:
                    avo.LGk = aVar3.UbS.zl();
                    AppMethodBeat.o(209508);
                    return 0;
                case 6:
                    avo.LGl = aVar3.UbS.zi();
                    AppMethodBeat.o(209508);
                    return 0;
                case 7:
                    avo.LGm = aVar3.UbS.readString();
                    AppMethodBeat.o(209508);
                    return 0;
                case 8:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        awg awg = new awg();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = awg.populateBuilderWithField(aVar6, awg, dop.getNextFieldNumber(aVar6))) {
                        }
                        avo.LGn = awg;
                    }
                    AppMethodBeat.o(209508);
                    return 0;
                case 9:
                    avo.LGo = aVar3.UbS.zi();
                    AppMethodBeat.o(209508);
                    return 0;
                case 10:
                    avo.opType = aVar3.UbS.zi();
                    AppMethodBeat.o(209508);
                    return 0;
                case 11:
                    avo.hwg = aVar3.UbS.readString();
                    AppMethodBeat.o(209508);
                    return 0;
                default:
                    AppMethodBeat.o(209508);
                    return -1;
            }
        } else {
            AppMethodBeat.o(209508);
            return -1;
        }
    }
}

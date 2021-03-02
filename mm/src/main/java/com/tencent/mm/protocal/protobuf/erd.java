package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class erd extends a {
    public LinkedList<pd> KVY = new LinkedList<>();
    public int LCp = 0;
    public String NoL = "";
    public String NoM = "";
    public int NoN;
    public long NoO = 0;
    public LinkedList<cgd> NoP = new LinkedList<>();
    public boolean NoQ = true;
    public int aHK;
    public String dMl = "";
    public int eventId = 0;
    public String id = "";
    public long timestamp = 0;
    public int type = -1;
    public String typeName = "";

    public erd() {
        AppMethodBeat.i(220727);
        AppMethodBeat.o(220727);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(220728);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.id != null) {
                aVar.e(1, this.id);
            }
            if (this.NoL != null) {
                aVar.e(2, this.NoL);
            }
            if (this.typeName != null) {
                aVar.e(3, this.typeName);
            }
            if (this.dMl != null) {
                aVar.e(4, this.dMl);
            }
            if (this.NoM != null) {
                aVar.e(5, this.NoM);
            }
            aVar.aM(6, this.eventId);
            aVar.aM(7, this.aHK);
            aVar.aM(8, this.NoN);
            aVar.bb(9, this.timestamp);
            aVar.bb(10, this.NoO);
            aVar.aM(11, this.LCp);
            aVar.e(12, 8, this.KVY);
            aVar.e(13, 8, this.NoP);
            aVar.cc(14, this.NoQ);
            aVar.aM(15, this.type);
            AppMethodBeat.o(220728);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.id != null ? g.a.a.b.b.a.f(1, this.id) + 0 : 0;
            if (this.NoL != null) {
                f2 += g.a.a.b.b.a.f(2, this.NoL);
            }
            if (this.typeName != null) {
                f2 += g.a.a.b.b.a.f(3, this.typeName);
            }
            if (this.dMl != null) {
                f2 += g.a.a.b.b.a.f(4, this.dMl);
            }
            if (this.NoM != null) {
                f2 += g.a.a.b.b.a.f(5, this.NoM);
            }
            int bu = f2 + g.a.a.b.b.a.bu(6, this.eventId) + g.a.a.b.b.a.bu(7, this.aHK) + g.a.a.b.b.a.bu(8, this.NoN) + g.a.a.b.b.a.r(9, this.timestamp) + g.a.a.b.b.a.r(10, this.NoO) + g.a.a.b.b.a.bu(11, this.LCp) + g.a.a.a.c(12, 8, this.KVY) + g.a.a.a.c(13, 8, this.NoP) + g.a.a.b.b.a.fS(14) + 1 + g.a.a.b.b.a.bu(15, this.type);
            AppMethodBeat.o(220728);
            return bu;
        } else if (i2 == 2) {
            this.KVY.clear();
            this.NoP.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(220728);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            erd erd = (erd) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    erd.id = aVar3.UbS.readString();
                    AppMethodBeat.o(220728);
                    return 0;
                case 2:
                    erd.NoL = aVar3.UbS.readString();
                    AppMethodBeat.o(220728);
                    return 0;
                case 3:
                    erd.typeName = aVar3.UbS.readString();
                    AppMethodBeat.o(220728);
                    return 0;
                case 4:
                    erd.dMl = aVar3.UbS.readString();
                    AppMethodBeat.o(220728);
                    return 0;
                case 5:
                    erd.NoM = aVar3.UbS.readString();
                    AppMethodBeat.o(220728);
                    return 0;
                case 6:
                    erd.eventId = aVar3.UbS.zi();
                    AppMethodBeat.o(220728);
                    return 0;
                case 7:
                    erd.aHK = aVar3.UbS.zi();
                    AppMethodBeat.o(220728);
                    return 0;
                case 8:
                    erd.NoN = aVar3.UbS.zi();
                    AppMethodBeat.o(220728);
                    return 0;
                case 9:
                    erd.timestamp = aVar3.UbS.zl();
                    AppMethodBeat.o(220728);
                    return 0;
                case 10:
                    erd.NoO = aVar3.UbS.zl();
                    AppMethodBeat.o(220728);
                    return 0;
                case 11:
                    erd.LCp = aVar3.UbS.zi();
                    AppMethodBeat.o(220728);
                    return 0;
                case 12:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        pd pdVar = new pd();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = pdVar.populateBuilderWithField(aVar4, pdVar, a.getNextFieldNumber(aVar4))) {
                        }
                        erd.KVY.add(pdVar);
                    }
                    AppMethodBeat.o(220728);
                    return 0;
                case 13:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        cgd cgd = new cgd();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = cgd.populateBuilderWithField(aVar5, cgd, a.getNextFieldNumber(aVar5))) {
                        }
                        erd.NoP.add(cgd);
                    }
                    AppMethodBeat.o(220728);
                    return 0;
                case 14:
                    erd.NoQ = aVar3.UbS.yZ();
                    AppMethodBeat.o(220728);
                    return 0;
                case 15:
                    erd.type = aVar3.UbS.zi();
                    AppMethodBeat.o(220728);
                    return 0;
                default:
                    AppMethodBeat.o(220728);
                    return -1;
            }
        } else {
            AppMethodBeat.o(220728);
            return -1;
        }
    }
}

package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class avk extends a {
    public String LGb;
    public int LGc;
    public String LGd;
    public String LGe;
    public awx LGf;
    public LinkedList<awx> LGg = new LinkedList<>();
    public String LnW;
    public String Lob;
    public int Loh;

    public avk() {
        AppMethodBeat.i(209503);
        AppMethodBeat.o(209503);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(209504);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.Loh);
            if (this.LGb != null) {
                aVar.e(2, this.LGb);
            }
            aVar.aM(3, this.LGc);
            if (this.LnW != null) {
                aVar.e(4, this.LnW);
            }
            if (this.LGd != null) {
                aVar.e(5, this.LGd);
            }
            if (this.LGe != null) {
                aVar.e(6, this.LGe);
            }
            if (this.Lob != null) {
                aVar.e(7, this.Lob);
            }
            if (this.LGf != null) {
                aVar.ni(8, this.LGf.computeSize());
                this.LGf.writeFields(aVar);
            }
            aVar.e(9, 8, this.LGg);
            AppMethodBeat.o(209504);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.Loh) + 0;
            if (this.LGb != null) {
                bu += g.a.a.b.b.a.f(2, this.LGb);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(3, this.LGc);
            if (this.LnW != null) {
                bu2 += g.a.a.b.b.a.f(4, this.LnW);
            }
            if (this.LGd != null) {
                bu2 += g.a.a.b.b.a.f(5, this.LGd);
            }
            if (this.LGe != null) {
                bu2 += g.a.a.b.b.a.f(6, this.LGe);
            }
            if (this.Lob != null) {
                bu2 += g.a.a.b.b.a.f(7, this.Lob);
            }
            if (this.LGf != null) {
                bu2 += g.a.a.a.nh(8, this.LGf.computeSize());
            }
            int c2 = bu2 + g.a.a.a.c(9, 8, this.LGg);
            AppMethodBeat.o(209504);
            return c2;
        } else if (i2 == 2) {
            this.LGg.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(209504);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            avk avk = (avk) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    avk.Loh = aVar3.UbS.zi();
                    AppMethodBeat.o(209504);
                    return 0;
                case 2:
                    avk.LGb = aVar3.UbS.readString();
                    AppMethodBeat.o(209504);
                    return 0;
                case 3:
                    avk.LGc = aVar3.UbS.zi();
                    AppMethodBeat.o(209504);
                    return 0;
                case 4:
                    avk.LnW = aVar3.UbS.readString();
                    AppMethodBeat.o(209504);
                    return 0;
                case 5:
                    avk.LGd = aVar3.UbS.readString();
                    AppMethodBeat.o(209504);
                    return 0;
                case 6:
                    avk.LGe = aVar3.UbS.readString();
                    AppMethodBeat.o(209504);
                    return 0;
                case 7:
                    avk.Lob = aVar3.UbS.readString();
                    AppMethodBeat.o(209504);
                    return 0;
                case 8:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        awx awx = new awx();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = awx.populateBuilderWithField(aVar4, awx, a.getNextFieldNumber(aVar4))) {
                        }
                        avk.LGf = awx;
                    }
                    AppMethodBeat.o(209504);
                    return 0;
                case 9:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        awx awx2 = new awx();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = awx2.populateBuilderWithField(aVar5, awx2, a.getNextFieldNumber(aVar5))) {
                        }
                        avk.LGg.add(awx2);
                    }
                    AppMethodBeat.o(209504);
                    return 0;
                default:
                    AppMethodBeat.o(209504);
                    return -1;
            }
        } else {
            AppMethodBeat.o(209504);
            return -1;
        }
    }
}

package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class efz extends a {
    public String KWx;
    public LinkedList<ega> KWy = new LinkedList<>();
    public long KWz;
    public String Lug;
    public String Luh;
    public egb NfT;
    public egd NfU;

    public efz() {
        AppMethodBeat.i(124556);
        AppMethodBeat.o(124556);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(124557);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.Lug != null) {
                aVar.e(1, this.Lug);
            }
            if (this.NfT != null) {
                aVar.ni(2, this.NfT.computeSize());
                this.NfT.writeFields(aVar);
            }
            if (this.KWx != null) {
                aVar.e(3, this.KWx);
            }
            aVar.e(4, 8, this.KWy);
            if (this.Luh != null) {
                aVar.e(5, this.Luh);
            }
            aVar.bb(6, this.KWz);
            if (this.NfU != null) {
                aVar.ni(7, this.NfU.computeSize());
                this.NfU.writeFields(aVar);
            }
            AppMethodBeat.o(124557);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.Lug != null ? g.a.a.b.b.a.f(1, this.Lug) + 0 : 0;
            if (this.NfT != null) {
                f2 += g.a.a.a.nh(2, this.NfT.computeSize());
            }
            if (this.KWx != null) {
                f2 += g.a.a.b.b.a.f(3, this.KWx);
            }
            int c2 = f2 + g.a.a.a.c(4, 8, this.KWy);
            if (this.Luh != null) {
                c2 += g.a.a.b.b.a.f(5, this.Luh);
            }
            int r = c2 + g.a.a.b.b.a.r(6, this.KWz);
            if (this.NfU != null) {
                r += g.a.a.a.nh(7, this.NfU.computeSize());
            }
            AppMethodBeat.o(124557);
            return r;
        } else if (i2 == 2) {
            this.KWy.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(124557);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            efz efz = (efz) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    efz.Lug = aVar3.UbS.readString();
                    AppMethodBeat.o(124557);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        egb egb = new egb();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = egb.populateBuilderWithField(aVar4, egb, a.getNextFieldNumber(aVar4))) {
                        }
                        efz.NfT = egb;
                    }
                    AppMethodBeat.o(124557);
                    return 0;
                case 3:
                    efz.KWx = aVar3.UbS.readString();
                    AppMethodBeat.o(124557);
                    return 0;
                case 4:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        ega ega = new ega();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = ega.populateBuilderWithField(aVar5, ega, a.getNextFieldNumber(aVar5))) {
                        }
                        efz.KWy.add(ega);
                    }
                    AppMethodBeat.o(124557);
                    return 0;
                case 5:
                    efz.Luh = aVar3.UbS.readString();
                    AppMethodBeat.o(124557);
                    return 0;
                case 6:
                    efz.KWz = aVar3.UbS.zl();
                    AppMethodBeat.o(124557);
                    return 0;
                case 7:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        egd egd = new egd();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = egd.populateBuilderWithField(aVar6, egd, a.getNextFieldNumber(aVar6))) {
                        }
                        efz.NfU = egd;
                    }
                    AppMethodBeat.o(124557);
                    return 0;
                default:
                    AppMethodBeat.o(124557);
                    return -1;
            }
        } else {
            AppMethodBeat.o(124557);
            return -1;
        }
    }
}

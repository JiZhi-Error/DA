package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import g.a.a.b;
import java.util.LinkedList;

public final class aod extends a {
    public int KKA;
    public String LzG;
    public long LzH;
    public String LzI;
    public LinkedList<aob> LzJ = new LinkedList<>();
    public bgn LzK;
    public int oUq;

    public aod() {
        AppMethodBeat.i(110849);
        AppMethodBeat.o(110849);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(110850);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.LzG == null) {
                b bVar = new b("Not all required fields were included: Rid");
                AppMethodBeat.o(110850);
                throw bVar;
            } else if (this.LzI == null) {
                b bVar2 = new b("Not all required fields were included: MimeType");
                AppMethodBeat.o(110850);
                throw bVar2;
            } else {
                if (this.LzG != null) {
                    aVar.e(1, this.LzG);
                }
                aVar.bb(2, this.LzH);
                aVar.aM(3, this.oUq);
                if (this.LzI != null) {
                    aVar.e(4, this.LzI);
                }
                aVar.e(5, 8, this.LzJ);
                if (this.LzK != null) {
                    aVar.ni(6, this.LzK.computeSize());
                    this.LzK.writeFields(aVar);
                }
                aVar.aM(7, this.KKA);
                AppMethodBeat.o(110850);
                return 0;
            }
        } else if (i2 == 1) {
            int f2 = (this.LzG != null ? g.a.a.b.b.a.f(1, this.LzG) + 0 : 0) + g.a.a.b.b.a.r(2, this.LzH) + g.a.a.b.b.a.bu(3, this.oUq);
            if (this.LzI != null) {
                f2 += g.a.a.b.b.a.f(4, this.LzI);
            }
            int c2 = f2 + g.a.a.a.c(5, 8, this.LzJ);
            if (this.LzK != null) {
                c2 += g.a.a.a.nh(6, this.LzK.computeSize());
            }
            int bu = c2 + g.a.a.b.b.a.bu(7, this.KKA);
            AppMethodBeat.o(110850);
            return bu;
        } else if (i2 == 2) {
            this.LzJ.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.LzG == null) {
                b bVar3 = new b("Not all required fields were included: Rid");
                AppMethodBeat.o(110850);
                throw bVar3;
            } else if (this.LzI == null) {
                b bVar4 = new b("Not all required fields were included: MimeType");
                AppMethodBeat.o(110850);
                throw bVar4;
            } else {
                AppMethodBeat.o(110850);
                return 0;
            }
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            aod aod = (aod) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    aod.LzG = aVar3.UbS.readString();
                    AppMethodBeat.o(110850);
                    return 0;
                case 2:
                    aod.LzH = aVar3.UbS.zl();
                    AppMethodBeat.o(110850);
                    return 0;
                case 3:
                    aod.oUq = aVar3.UbS.zi();
                    AppMethodBeat.o(110850);
                    return 0;
                case 4:
                    aod.LzI = aVar3.UbS.readString();
                    AppMethodBeat.o(110850);
                    return 0;
                case 5:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        aob aob = new aob();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = aob.populateBuilderWithField(aVar4, aob, a.getNextFieldNumber(aVar4))) {
                        }
                        aod.LzJ.add(aob);
                    }
                    AppMethodBeat.o(110850);
                    return 0;
                case 6:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        bgn bgn = new bgn();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = bgn.populateBuilderWithField(aVar5, bgn, a.getNextFieldNumber(aVar5))) {
                        }
                        aod.LzK = bgn;
                    }
                    AppMethodBeat.o(110850);
                    return 0;
                case 7:
                    aod.KKA = aVar3.UbS.zi();
                    AppMethodBeat.o(110850);
                    return 0;
                default:
                    AppMethodBeat.o(110850);
                    return -1;
            }
        } else {
            AppMethodBeat.o(110850);
            return -1;
        }
    }
}

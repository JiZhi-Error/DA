package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class dlt extends a {
    public String MPn;
    public LinkedList<edn> MPo = new LinkedList<>();
    public String MPp;
    public dlr MPq;
    public String MPr;
    public int MPs;
    public int VjK;
    public String description;
    public String iwu;
    public String iwv;
    public String iww;
    public int pTI;
    public String title;
    public String yUK;
    public String yUL;

    public dlt() {
        AppMethodBeat.i(168759);
        AppMethodBeat.o(168759);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(168760);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.title != null) {
                aVar.e(1, this.title);
            }
            if (this.iwv != null) {
                aVar.e(2, this.iwv);
            }
            if (this.iww != null) {
                aVar.e(3, this.iww);
            }
            if (this.description != null) {
                aVar.e(4, this.description);
            }
            if (this.MPn != null) {
                aVar.e(9, this.MPn);
            }
            aVar.e(10, 8, this.MPo);
            aVar.aM(11, this.pTI);
            if (this.yUK != null) {
                aVar.e(12, this.yUK);
            }
            if (this.yUL != null) {
                aVar.e(13, this.yUL);
            }
            if (this.MPp != null) {
                aVar.e(14, this.MPp);
            }
            if (this.iwu != null) {
                aVar.e(15, this.iwu);
            }
            if (this.MPq != null) {
                aVar.ni(16, this.MPq.computeSize());
                this.MPq.writeFields(aVar);
            }
            if (this.MPr != null) {
                aVar.e(17, this.MPr);
            }
            aVar.aM(18, this.MPs);
            aVar.aM(100, this.VjK);
            AppMethodBeat.o(168760);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.title != null ? g.a.a.b.b.a.f(1, this.title) + 0 : 0;
            if (this.iwv != null) {
                f2 += g.a.a.b.b.a.f(2, this.iwv);
            }
            if (this.iww != null) {
                f2 += g.a.a.b.b.a.f(3, this.iww);
            }
            if (this.description != null) {
                f2 += g.a.a.b.b.a.f(4, this.description);
            }
            if (this.MPn != null) {
                f2 += g.a.a.b.b.a.f(9, this.MPn);
            }
            int c2 = f2 + g.a.a.a.c(10, 8, this.MPo) + g.a.a.b.b.a.bu(11, this.pTI);
            if (this.yUK != null) {
                c2 += g.a.a.b.b.a.f(12, this.yUK);
            }
            if (this.yUL != null) {
                c2 += g.a.a.b.b.a.f(13, this.yUL);
            }
            if (this.MPp != null) {
                c2 += g.a.a.b.b.a.f(14, this.MPp);
            }
            if (this.iwu != null) {
                c2 += g.a.a.b.b.a.f(15, this.iwu);
            }
            if (this.MPq != null) {
                c2 += g.a.a.a.nh(16, this.MPq.computeSize());
            }
            if (this.MPr != null) {
                c2 += g.a.a.b.b.a.f(17, this.MPr);
            }
            int bu = c2 + g.a.a.b.b.a.bu(18, this.MPs) + g.a.a.b.b.a.bu(100, this.VjK);
            AppMethodBeat.o(168760);
            return bu;
        } else if (i2 == 2) {
            this.MPo.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(168760);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            dlt dlt = (dlt) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    dlt.title = aVar3.UbS.readString();
                    AppMethodBeat.o(168760);
                    return 0;
                case 2:
                    dlt.iwv = aVar3.UbS.readString();
                    AppMethodBeat.o(168760);
                    return 0;
                case 3:
                    dlt.iww = aVar3.UbS.readString();
                    AppMethodBeat.o(168760);
                    return 0;
                case 4:
                    dlt.description = aVar3.UbS.readString();
                    AppMethodBeat.o(168760);
                    return 0;
                case 9:
                    dlt.MPn = aVar3.UbS.readString();
                    AppMethodBeat.o(168760);
                    return 0;
                case 10:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        edn edn = new edn();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = edn.populateBuilderWithField(aVar4, edn, a.getNextFieldNumber(aVar4))) {
                        }
                        dlt.MPo.add(edn);
                    }
                    AppMethodBeat.o(168760);
                    return 0;
                case 11:
                    dlt.pTI = aVar3.UbS.zi();
                    AppMethodBeat.o(168760);
                    return 0;
                case 12:
                    dlt.yUK = aVar3.UbS.readString();
                    AppMethodBeat.o(168760);
                    return 0;
                case 13:
                    dlt.yUL = aVar3.UbS.readString();
                    AppMethodBeat.o(168760);
                    return 0;
                case 14:
                    dlt.MPp = aVar3.UbS.readString();
                    AppMethodBeat.o(168760);
                    return 0;
                case 15:
                    dlt.iwu = aVar3.UbS.readString();
                    AppMethodBeat.o(168760);
                    return 0;
                case 16:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        dlr dlr = new dlr();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = dlr.populateBuilderWithField(aVar5, dlr, a.getNextFieldNumber(aVar5))) {
                        }
                        dlt.MPq = dlr;
                    }
                    AppMethodBeat.o(168760);
                    return 0;
                case 17:
                    dlt.MPr = aVar3.UbS.readString();
                    AppMethodBeat.o(168760);
                    return 0;
                case 18:
                    dlt.MPs = aVar3.UbS.zi();
                    AppMethodBeat.o(168760);
                    return 0;
                case 100:
                    dlt.VjK = aVar3.UbS.zi();
                    AppMethodBeat.o(168760);
                    return 0;
                default:
                    AppMethodBeat.o(168760);
                    return -1;
            }
        } else {
            AppMethodBeat.o(168760);
            return -1;
        }
    }
}

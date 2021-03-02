package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import g.a.a.b;
import java.util.LinkedList;

public final class dbq extends a {
    public fbl MGA;
    public fbe MGB;
    public fbi MGz;
    public String xJD;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(110851);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.xJD == null) {
                b bVar = new b("Not all required fields were included: PkgId");
                AppMethodBeat.o(110851);
                throw bVar;
            }
            if (this.xJD != null) {
                aVar.e(1, this.xJD);
            }
            if (this.MGz != null) {
                aVar.ni(2, this.MGz.computeSize());
                this.MGz.writeFields(aVar);
            }
            if (this.MGA != null) {
                aVar.ni(3, this.MGA.computeSize());
                this.MGA.writeFields(aVar);
            }
            if (this.MGB != null) {
                aVar.ni(4, this.MGB.computeSize());
                this.MGB.writeFields(aVar);
            }
            AppMethodBeat.o(110851);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.xJD != null ? g.a.a.b.b.a.f(1, this.xJD) + 0 : 0;
            if (this.MGz != null) {
                f2 += g.a.a.a.nh(2, this.MGz.computeSize());
            }
            if (this.MGA != null) {
                f2 += g.a.a.a.nh(3, this.MGA.computeSize());
            }
            if (this.MGB != null) {
                f2 += g.a.a.a.nh(4, this.MGB.computeSize());
            }
            AppMethodBeat.o(110851);
            return f2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.xJD == null) {
                b bVar2 = new b("Not all required fields were included: PkgId");
                AppMethodBeat.o(110851);
                throw bVar2;
            }
            AppMethodBeat.o(110851);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            dbq dbq = (dbq) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    dbq.xJD = aVar3.UbS.readString();
                    AppMethodBeat.o(110851);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        fbi fbi = new fbi();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = fbi.populateBuilderWithField(aVar4, fbi, a.getNextFieldNumber(aVar4))) {
                        }
                        dbq.MGz = fbi;
                    }
                    AppMethodBeat.o(110851);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        fbl fbl = new fbl();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = fbl.populateBuilderWithField(aVar5, fbl, a.getNextFieldNumber(aVar5))) {
                        }
                        dbq.MGA = fbl;
                    }
                    AppMethodBeat.o(110851);
                    return 0;
                case 4:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        fbe fbe = new fbe();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = fbe.populateBuilderWithField(aVar6, fbe, a.getNextFieldNumber(aVar6))) {
                        }
                        dbq.MGB = fbe;
                    }
                    AppMethodBeat.o(110851);
                    return 0;
                default:
                    AppMethodBeat.o(110851);
                    return -1;
            }
        } else {
            AppMethodBeat.o(110851);
            return -1;
        }
    }
}

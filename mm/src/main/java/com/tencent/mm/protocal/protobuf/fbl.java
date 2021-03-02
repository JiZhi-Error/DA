package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import g.a.a.b;
import java.util.LinkedList;

public final class fbl extends a {
    public String Md5;
    public String Nvi;
    public int NxA;
    public int NxB;
    public String NxG;
    public fbd NxH;
    public fbk NxI;
    public String xuc;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(110863);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.NxG == null) {
                b bVar = new b("Not all required fields were included: EntranceDomain");
                AppMethodBeat.o(110863);
                throw bVar;
            } else if (this.Nvi == null) {
                b bVar2 = new b("Not all required fields were included: Charset");
                AppMethodBeat.o(110863);
                throw bVar2;
            } else {
                if (this.NxG != null) {
                    aVar.e(4, this.NxG);
                }
                if (this.Nvi != null) {
                    aVar.e(12, this.Nvi);
                }
                if (this.NxH != null) {
                    aVar.ni(9, this.NxH.computeSize());
                    this.NxH.writeFields(aVar);
                }
                if (this.NxI != null) {
                    aVar.ni(10, this.NxI.computeSize());
                    this.NxI.writeFields(aVar);
                }
                if (this.Md5 != null) {
                    aVar.e(5, this.Md5);
                }
                if (this.xuc != null) {
                    aVar.e(6, this.xuc);
                }
                aVar.aM(7, this.NxA);
                aVar.aM(8, this.NxB);
                AppMethodBeat.o(110863);
                return 0;
            }
        } else if (i2 == 1) {
            int f2 = this.NxG != null ? g.a.a.b.b.a.f(4, this.NxG) + 0 : 0;
            if (this.Nvi != null) {
                f2 += g.a.a.b.b.a.f(12, this.Nvi);
            }
            if (this.NxH != null) {
                f2 += g.a.a.a.nh(9, this.NxH.computeSize());
            }
            if (this.NxI != null) {
                f2 += g.a.a.a.nh(10, this.NxI.computeSize());
            }
            if (this.Md5 != null) {
                f2 += g.a.a.b.b.a.f(5, this.Md5);
            }
            if (this.xuc != null) {
                f2 += g.a.a.b.b.a.f(6, this.xuc);
            }
            int bu = f2 + g.a.a.b.b.a.bu(7, this.NxA) + g.a.a.b.b.a.bu(8, this.NxB);
            AppMethodBeat.o(110863);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.NxG == null) {
                b bVar3 = new b("Not all required fields were included: EntranceDomain");
                AppMethodBeat.o(110863);
                throw bVar3;
            } else if (this.Nvi == null) {
                b bVar4 = new b("Not all required fields were included: Charset");
                AppMethodBeat.o(110863);
                throw bVar4;
            } else {
                AppMethodBeat.o(110863);
                return 0;
            }
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            fbl fbl = (fbl) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 4:
                    fbl.NxG = aVar3.UbS.readString();
                    AppMethodBeat.o(110863);
                    return 0;
                case 5:
                    fbl.Md5 = aVar3.UbS.readString();
                    AppMethodBeat.o(110863);
                    return 0;
                case 6:
                    fbl.xuc = aVar3.UbS.readString();
                    AppMethodBeat.o(110863);
                    return 0;
                case 7:
                    fbl.NxA = aVar3.UbS.zi();
                    AppMethodBeat.o(110863);
                    return 0;
                case 8:
                    fbl.NxB = aVar3.UbS.zi();
                    AppMethodBeat.o(110863);
                    return 0;
                case 9:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        fbd fbd = new fbd();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = fbd.populateBuilderWithField(aVar4, fbd, a.getNextFieldNumber(aVar4))) {
                        }
                        fbl.NxH = fbd;
                    }
                    AppMethodBeat.o(110863);
                    return 0;
                case 10:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        fbk fbk = new fbk();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = fbk.populateBuilderWithField(aVar5, fbk, a.getNextFieldNumber(aVar5))) {
                        }
                        fbl.NxI = fbk;
                    }
                    AppMethodBeat.o(110863);
                    return 0;
                case 11:
                default:
                    AppMethodBeat.o(110863);
                    return -1;
                case 12:
                    fbl.Nvi = aVar3.UbS.readString();
                    AppMethodBeat.o(110863);
                    return 0;
            }
        } else {
            AppMethodBeat.o(110863);
            return -1;
        }
    }
}

package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import g.a.a.b;
import java.util.LinkedList;

public final class fbg extends a {
    public String Md5;
    public int NxA;
    public int NxB;
    public fbj NxC;
    public String xuc;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(110857);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.Md5 == null) {
                b bVar = new b("Not all required fields were included: Md5");
                AppMethodBeat.o(110857);
                throw bVar;
            } else if (this.xuc == null) {
                b bVar2 = new b("Not all required fields were included: DownloadUrl");
                AppMethodBeat.o(110857);
                throw bVar2;
            } else {
                if (this.Md5 != null) {
                    aVar.e(1, this.Md5);
                }
                if (this.xuc != null) {
                    aVar.e(2, this.xuc);
                }
                aVar.aM(3, this.NxA);
                aVar.aM(4, this.NxB);
                if (this.NxC != null) {
                    aVar.ni(5, this.NxC.computeSize());
                    this.NxC.writeFields(aVar);
                }
                AppMethodBeat.o(110857);
                return 0;
            }
        } else if (i2 == 1) {
            int f2 = this.Md5 != null ? g.a.a.b.b.a.f(1, this.Md5) + 0 : 0;
            if (this.xuc != null) {
                f2 += g.a.a.b.b.a.f(2, this.xuc);
            }
            int bu = f2 + g.a.a.b.b.a.bu(3, this.NxA) + g.a.a.b.b.a.bu(4, this.NxB);
            if (this.NxC != null) {
                bu += g.a.a.a.nh(5, this.NxC.computeSize());
            }
            AppMethodBeat.o(110857);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.Md5 == null) {
                b bVar3 = new b("Not all required fields were included: Md5");
                AppMethodBeat.o(110857);
                throw bVar3;
            } else if (this.xuc == null) {
                b bVar4 = new b("Not all required fields were included: DownloadUrl");
                AppMethodBeat.o(110857);
                throw bVar4;
            } else {
                AppMethodBeat.o(110857);
                return 0;
            }
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            fbg fbg = (fbg) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    fbg.Md5 = aVar3.UbS.readString();
                    AppMethodBeat.o(110857);
                    return 0;
                case 2:
                    fbg.xuc = aVar3.UbS.readString();
                    AppMethodBeat.o(110857);
                    return 0;
                case 3:
                    fbg.NxA = aVar3.UbS.zi();
                    AppMethodBeat.o(110857);
                    return 0;
                case 4:
                    fbg.NxB = aVar3.UbS.zi();
                    AppMethodBeat.o(110857);
                    return 0;
                case 5:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        fbj fbj = new fbj();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = fbj.populateBuilderWithField(aVar4, fbj, a.getNextFieldNumber(aVar4))) {
                        }
                        fbg.NxC = fbj;
                    }
                    AppMethodBeat.o(110857);
                    return 0;
                default:
                    AppMethodBeat.o(110857);
                    return -1;
            }
        } else {
            AppMethodBeat.o(110857);
            return -1;
        }
    }
}

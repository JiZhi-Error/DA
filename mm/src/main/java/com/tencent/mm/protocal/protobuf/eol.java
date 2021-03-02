package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class eol extends a {
    public LinkedList<egi> Nmk = new LinkedList<>();
    public LinkedList<egi> Nml = new LinkedList<>();
    public LinkedList<abz> Nmm = new LinkedList<>();
    public String title;

    public eol() {
        AppMethodBeat.i(114083);
        AppMethodBeat.o(114083);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(114084);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.title != null) {
                aVar.e(1, this.title);
            }
            aVar.e(2, 8, this.Nmk);
            aVar.e(3, 8, this.Nml);
            aVar.e(4, 8, this.Nmm);
            AppMethodBeat.o(114084);
            return 0;
        } else if (i2 == 1) {
            int f2 = (this.title != null ? g.a.a.b.b.a.f(1, this.title) + 0 : 0) + g.a.a.a.c(2, 8, this.Nmk) + g.a.a.a.c(3, 8, this.Nml) + g.a.a.a.c(4, 8, this.Nmm);
            AppMethodBeat.o(114084);
            return f2;
        } else if (i2 == 2) {
            this.Nmk.clear();
            this.Nml.clear();
            this.Nmm.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(114084);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            eol eol = (eol) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    eol.title = aVar3.UbS.readString();
                    AppMethodBeat.o(114084);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        egi egi = new egi();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = egi.populateBuilderWithField(aVar4, egi, a.getNextFieldNumber(aVar4))) {
                        }
                        eol.Nmk.add(egi);
                    }
                    AppMethodBeat.o(114084);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        egi egi2 = new egi();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = egi2.populateBuilderWithField(aVar5, egi2, a.getNextFieldNumber(aVar5))) {
                        }
                        eol.Nml.add(egi2);
                    }
                    AppMethodBeat.o(114084);
                    return 0;
                case 4:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        abz abz = new abz();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = abz.populateBuilderWithField(aVar6, abz, a.getNextFieldNumber(aVar6))) {
                        }
                        eol.Nmm.add(abz);
                    }
                    AppMethodBeat.o(114084);
                    return 0;
                default:
                    AppMethodBeat.o(114084);
                    return -1;
            }
        } else {
            AppMethodBeat.o(114084);
            return -1;
        }
    }
}

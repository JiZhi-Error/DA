package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import g.a.a.b;
import java.util.LinkedList;

public final class fbi extends a {
    public fbf NxD;
    public String jfi;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(110859);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.jfi == null) {
                b bVar = new b("Not all required fields were included: AppId");
                AppMethodBeat.o(110859);
                throw bVar;
            } else if (this.NxD == null) {
                b bVar2 = new b("Not all required fields were included: PkgConfig");
                AppMethodBeat.o(110859);
                throw bVar2;
            } else {
                if (this.jfi != null) {
                    aVar.e(1, this.jfi);
                }
                if (this.NxD != null) {
                    aVar.ni(2, this.NxD.computeSize());
                    this.NxD.writeFields(aVar);
                }
                AppMethodBeat.o(110859);
                return 0;
            }
        } else if (i2 == 1) {
            int f2 = this.jfi != null ? g.a.a.b.b.a.f(1, this.jfi) + 0 : 0;
            if (this.NxD != null) {
                f2 += g.a.a.a.nh(2, this.NxD.computeSize());
            }
            AppMethodBeat.o(110859);
            return f2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.jfi == null) {
                b bVar3 = new b("Not all required fields were included: AppId");
                AppMethodBeat.o(110859);
                throw bVar3;
            } else if (this.NxD == null) {
                b bVar4 = new b("Not all required fields were included: PkgConfig");
                AppMethodBeat.o(110859);
                throw bVar4;
            } else {
                AppMethodBeat.o(110859);
                return 0;
            }
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            fbi fbi = (fbi) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    fbi.jfi = aVar3.UbS.readString();
                    AppMethodBeat.o(110859);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        fbf fbf = new fbf();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = fbf.populateBuilderWithField(aVar4, fbf, a.getNextFieldNumber(aVar4))) {
                        }
                        fbi.NxD = fbf;
                    }
                    AppMethodBeat.o(110859);
                    return 0;
                default:
                    AppMethodBeat.o(110859);
                    return -1;
            }
        } else {
            AppMethodBeat.o(110859);
            return -1;
        }
    }
}

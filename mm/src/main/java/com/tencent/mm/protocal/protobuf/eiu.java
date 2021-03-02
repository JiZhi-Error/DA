package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class eiu extends a {
    public String Nil;
    public String Nim;
    public LinkedList<any> Nin = new LinkedList<>();

    public eiu() {
        AppMethodBeat.i(153008);
        AppMethodBeat.o(153008);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(153009);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.Nil != null) {
                aVar.e(1, this.Nil);
            }
            if (this.Nim != null) {
                aVar.e(2, this.Nim);
            }
            aVar.e(3, 8, this.Nin);
            AppMethodBeat.o(153009);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.Nil != null ? g.a.a.b.b.a.f(1, this.Nil) + 0 : 0;
            if (this.Nim != null) {
                f2 += g.a.a.b.b.a.f(2, this.Nim);
            }
            int c2 = f2 + g.a.a.a.c(3, 8, this.Nin);
            AppMethodBeat.o(153009);
            return c2;
        } else if (i2 == 2) {
            this.Nin.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(153009);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            eiu eiu = (eiu) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    eiu.Nil = aVar3.UbS.readString();
                    AppMethodBeat.o(153009);
                    return 0;
                case 2:
                    eiu.Nim = aVar3.UbS.readString();
                    AppMethodBeat.o(153009);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        any any = new any();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = any.populateBuilderWithField(aVar4, any, a.getNextFieldNumber(aVar4))) {
                        }
                        eiu.Nin.add(any);
                    }
                    AppMethodBeat.o(153009);
                    return 0;
                default:
                    AppMethodBeat.o(153009);
                    return -1;
            }
        } else {
            AppMethodBeat.o(153009);
            return -1;
        }
    }
}

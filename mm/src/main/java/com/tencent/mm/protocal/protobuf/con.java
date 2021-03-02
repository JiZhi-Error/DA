package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import g.a.a.b;
import java.util.LinkedList;

public final class con extends a {
    public dqi Lqp;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(101822);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.Lqp == null) {
                b bVar = new b("Not all required fields were included: MemberName");
                AppMethodBeat.o(101822);
                throw bVar;
            }
            if (this.Lqp != null) {
                aVar.ni(1, this.Lqp.computeSize());
                this.Lqp.writeFields(aVar);
            }
            AppMethodBeat.o(101822);
            return 0;
        } else if (i2 == 1) {
            int nh = this.Lqp != null ? g.a.a.a.nh(1, this.Lqp.computeSize()) + 0 : 0;
            AppMethodBeat.o(101822);
            return nh;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.Lqp == null) {
                b bVar2 = new b("Not all required fields were included: MemberName");
                AppMethodBeat.o(101822);
                throw bVar2;
            }
            AppMethodBeat.o(101822);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            con con = (con) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        dqi dqi = new dqi();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = dqi.populateBuilderWithField(aVar4, dqi, a.getNextFieldNumber(aVar4))) {
                        }
                        con.Lqp = dqi;
                    }
                    AppMethodBeat.o(101822);
                    return 0;
                default:
                    AppMethodBeat.o(101822);
                    return -1;
            }
        } else {
            AppMethodBeat.o(101822);
            return -1;
        }
    }
}

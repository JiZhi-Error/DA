package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import g.a.a.b;
import java.util.LinkedList;

public final class qv extends a {
    public String KTt;
    public LinkedList<String> KXK = new LinkedList<>();

    public qv() {
        AppMethodBeat.i(124465);
        AppMethodBeat.o(124465);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(124466);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.KTt == null) {
                b bVar = new b("Not all required fields were included: brand_user_name");
                AppMethodBeat.o(124466);
                throw bVar;
            }
            if (this.KTt != null) {
                aVar.e(2, this.KTt);
            }
            aVar.e(3, 1, this.KXK);
            AppMethodBeat.o(124466);
            return 0;
        } else if (i2 == 1) {
            int f2 = (this.KTt != null ? g.a.a.b.b.a.f(2, this.KTt) + 0 : 0) + g.a.a.a.c(3, 1, this.KXK);
            AppMethodBeat.o(124466);
            return f2;
        } else if (i2 == 2) {
            this.KXK.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.KTt == null) {
                b bVar2 = new b("Not all required fields were included: brand_user_name");
                AppMethodBeat.o(124466);
                throw bVar2;
            }
            AppMethodBeat.o(124466);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            qv qvVar = (qv) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 2:
                    qvVar.KTt = aVar3.UbS.readString();
                    AppMethodBeat.o(124466);
                    return 0;
                case 3:
                    qvVar.KXK.add(aVar3.UbS.readString());
                    AppMethodBeat.o(124466);
                    return 0;
                default:
                    AppMethodBeat.o(124466);
                    return -1;
            }
        } else {
            AppMethodBeat.o(124466);
            return -1;
        }
    }
}

package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class dvy extends dop {
    public String KTt;
    public int MWH;
    public int MWI;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(124553);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.KTt == null) {
                b bVar = new b("Not all required fields were included: brand_user_name");
                AppMethodBeat.o(124553);
                throw bVar;
            }
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.KTt != null) {
                aVar.e(2, this.KTt);
            }
            aVar.aM(3, this.MWH);
            aVar.aM(4, this.MWI);
            AppMethodBeat.o(124553);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0;
            if (this.KTt != null) {
                nh += g.a.a.b.b.a.f(2, this.KTt);
            }
            int bu = nh + g.a.a.b.b.a.bu(3, this.MWH) + g.a.a.b.b.a.bu(4, this.MWI);
            AppMethodBeat.o(124553);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.KTt == null) {
                b bVar2 = new b("Not all required fields were included: brand_user_name");
                AppMethodBeat.o(124553);
                throw bVar2;
            }
            AppMethodBeat.o(124553);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            dvy dvy = (dvy) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        jr jrVar = new jr();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = jrVar.populateBuilderWithField(aVar4, jrVar, dop.getNextFieldNumber(aVar4))) {
                        }
                        dvy.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(124553);
                    return 0;
                case 2:
                    dvy.KTt = aVar3.UbS.readString();
                    AppMethodBeat.o(124553);
                    return 0;
                case 3:
                    dvy.MWH = aVar3.UbS.zi();
                    AppMethodBeat.o(124553);
                    return 0;
                case 4:
                    dvy.MWI = aVar3.UbS.zi();
                    AppMethodBeat.o(124553);
                    return 0;
                default:
                    AppMethodBeat.o(124553);
                    return -1;
            }
        } else {
            AppMethodBeat.o(124553);
            return -1;
        }
    }
}

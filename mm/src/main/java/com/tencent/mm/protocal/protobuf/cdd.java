package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class cdd extends dop {
    public String Lpg;
    public String MiU;
    public LinkedList<String> MiV = new LinkedList<>();

    public cdd() {
        AppMethodBeat.i(124516);
        AppMethodBeat.o(124516);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(124517);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.Lpg == null) {
                b bVar = new b("Not all required fields were included: corp_id");
                AppMethodBeat.o(124517);
                throw bVar;
            } else if (this.MiU == null) {
                b bVar2 = new b("Not all required fields were included: bizchat_name");
                AppMethodBeat.o(124517);
                throw bVar2;
            } else {
                if (this.BaseRequest != null) {
                    aVar.ni(1, this.BaseRequest.computeSize());
                    this.BaseRequest.writeFields(aVar);
                }
                if (this.Lpg != null) {
                    aVar.e(2, this.Lpg);
                }
                if (this.MiU != null) {
                    aVar.e(3, this.MiU);
                }
                aVar.e(4, 1, this.MiV);
                AppMethodBeat.o(124517);
                return 0;
            }
        } else if (i2 == 1) {
            int nh = this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0;
            if (this.Lpg != null) {
                nh += g.a.a.b.b.a.f(2, this.Lpg);
            }
            if (this.MiU != null) {
                nh += g.a.a.b.b.a.f(3, this.MiU);
            }
            int c2 = nh + g.a.a.a.c(4, 1, this.MiV);
            AppMethodBeat.o(124517);
            return c2;
        } else if (i2 == 2) {
            this.MiV.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.Lpg == null) {
                b bVar3 = new b("Not all required fields were included: corp_id");
                AppMethodBeat.o(124517);
                throw bVar3;
            } else if (this.MiU == null) {
                b bVar4 = new b("Not all required fields were included: bizchat_name");
                AppMethodBeat.o(124517);
                throw bVar4;
            } else {
                AppMethodBeat.o(124517);
                return 0;
            }
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            cdd cdd = (cdd) objArr[1];
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
                        cdd.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(124517);
                    return 0;
                case 2:
                    cdd.Lpg = aVar3.UbS.readString();
                    AppMethodBeat.o(124517);
                    return 0;
                case 3:
                    cdd.MiU = aVar3.UbS.readString();
                    AppMethodBeat.o(124517);
                    return 0;
                case 4:
                    cdd.MiV.add(aVar3.UbS.readString());
                    AppMethodBeat.o(124517);
                    return 0;
                default:
                    AppMethodBeat.o(124517);
                    return -1;
            }
        } else {
            AppMethodBeat.o(124517);
            return -1;
        }
    }
}

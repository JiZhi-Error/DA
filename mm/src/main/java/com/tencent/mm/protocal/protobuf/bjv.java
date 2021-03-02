package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class bjv extends dop {
    public int EX;
    public String Lpg;
    public String data;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(124508);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.Lpg == null) {
                b bVar = new b("Not all required fields were included: corp_id");
                AppMethodBeat.o(124508);
                throw bVar;
            } else if (this.data == null) {
                b bVar2 = new b("Not all required fields were included: data");
                AppMethodBeat.o(124508);
                throw bVar2;
            } else {
                if (this.BaseRequest != null) {
                    aVar.ni(1, this.BaseRequest.computeSize());
                    this.BaseRequest.writeFields(aVar);
                }
                if (this.Lpg != null) {
                    aVar.e(2, this.Lpg);
                }
                aVar.aM(3, this.EX);
                if (this.data != null) {
                    aVar.e(4, this.data);
                }
                AppMethodBeat.o(124508);
                return 0;
            }
        } else if (i2 == 1) {
            int nh = this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0;
            if (this.Lpg != null) {
                nh += g.a.a.b.b.a.f(2, this.Lpg);
            }
            int bu = nh + g.a.a.b.b.a.bu(3, this.EX);
            if (this.data != null) {
                bu += g.a.a.b.b.a.f(4, this.data);
            }
            AppMethodBeat.o(124508);
            return bu;
        } else if (i2 == 2) {
            byte[] bArr = (byte[]) objArr[0];
            g.a.a.a.a aVar2 = new g.a.a.a.a(bArr, unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.Lpg == null) {
                b bVar3 = new b("Not all required fields were included: corp_id");
                AppMethodBeat.o(124508);
                throw bVar3;
            } else if (bArr == null) {
                b bVar4 = new b("Not all required fields were included: data");
                AppMethodBeat.o(124508);
                throw bVar4;
            } else {
                AppMethodBeat.o(124508);
                return 0;
            }
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            bjv bjv = (bjv) objArr[1];
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
                        bjv.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(124508);
                    return 0;
                case 2:
                    bjv.Lpg = aVar3.UbS.readString();
                    AppMethodBeat.o(124508);
                    return 0;
                case 3:
                    bjv.EX = aVar3.UbS.zi();
                    AppMethodBeat.o(124508);
                    return 0;
                case 4:
                    bjv.data = aVar3.UbS.readString();
                    AppMethodBeat.o(124508);
                    return 0;
                default:
                    AppMethodBeat.o(124508);
                    return -1;
            }
        } else {
            AppMethodBeat.o(124508);
            return -1;
        }
    }
}

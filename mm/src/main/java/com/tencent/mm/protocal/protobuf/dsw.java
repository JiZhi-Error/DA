package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class dsw extends dop {
    public cat KPD;
    public String MUY;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(32423);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.KPD == null) {
                b bVar = new b("Not all required fields were included: HardDevice");
                AppMethodBeat.o(32423);
                throw bVar;
            }
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.KPD != null) {
                aVar.ni(2, this.KPD.computeSize());
                this.KPD.writeFields(aVar);
            }
            if (this.MUY != null) {
                aVar.e(3, this.MUY);
            }
            AppMethodBeat.o(32423);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0;
            if (this.KPD != null) {
                nh += g.a.a.a.nh(2, this.KPD.computeSize());
            }
            if (this.MUY != null) {
                nh += g.a.a.b.b.a.f(3, this.MUY);
            }
            AppMethodBeat.o(32423);
            return nh;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.KPD == null) {
                b bVar2 = new b("Not all required fields were included: HardDevice");
                AppMethodBeat.o(32423);
                throw bVar2;
            }
            AppMethodBeat.o(32423);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            dsw dsw = (dsw) objArr[1];
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
                        dsw.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(32423);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        cat cat = new cat();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = cat.populateBuilderWithField(aVar5, cat, dop.getNextFieldNumber(aVar5))) {
                        }
                        dsw.KPD = cat;
                    }
                    AppMethodBeat.o(32423);
                    return 0;
                case 3:
                    dsw.MUY = aVar3.UbS.readString();
                    AppMethodBeat.o(32423);
                    return 0;
                default:
                    AppMethodBeat.o(32423);
                    return -1;
            }
        } else {
            AppMethodBeat.o(32423);
            return -1;
        }
    }
}

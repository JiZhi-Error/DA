package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class wh extends dop {
    public String KHM;
    public String KHN;
    public String Lhy;
    public String Lhz;
    public int yRL;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(91412);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.KHM == null) {
                b bVar = new b("Not all required fields were included: f2f_id");
                AppMethodBeat.o(91412);
                throw bVar;
            } else if (this.KHN == null) {
                b bVar2 = new b("Not all required fields were included: trans_id");
                AppMethodBeat.o(91412);
                throw bVar2;
            } else if (this.Lhz == null) {
                b bVar3 = new b("Not all required fields were included: receiver_open_id");
                AppMethodBeat.o(91412);
                throw bVar3;
            } else {
                if (this.BaseRequest != null) {
                    aVar.ni(1, this.BaseRequest.computeSize());
                    this.BaseRequest.writeFields(aVar);
                }
                if (this.KHM != null) {
                    aVar.e(2, this.KHM);
                }
                if (this.KHN != null) {
                    aVar.e(3, this.KHN);
                }
                if (this.Lhy != null) {
                    aVar.e(4, this.Lhy);
                }
                if (this.Lhz != null) {
                    aVar.e(5, this.Lhz);
                }
                aVar.aM(6, this.yRL);
                AppMethodBeat.o(91412);
                return 0;
            }
        } else if (i2 == 1) {
            int nh = this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0;
            if (this.KHM != null) {
                nh += g.a.a.b.b.a.f(2, this.KHM);
            }
            if (this.KHN != null) {
                nh += g.a.a.b.b.a.f(3, this.KHN);
            }
            if (this.Lhy != null) {
                nh += g.a.a.b.b.a.f(4, this.Lhy);
            }
            if (this.Lhz != null) {
                nh += g.a.a.b.b.a.f(5, this.Lhz);
            }
            int bu = nh + g.a.a.b.b.a.bu(6, this.yRL);
            AppMethodBeat.o(91412);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.KHM == null) {
                b bVar4 = new b("Not all required fields were included: f2f_id");
                AppMethodBeat.o(91412);
                throw bVar4;
            } else if (this.KHN == null) {
                b bVar5 = new b("Not all required fields were included: trans_id");
                AppMethodBeat.o(91412);
                throw bVar5;
            } else if (this.Lhz == null) {
                b bVar6 = new b("Not all required fields were included: receiver_open_id");
                AppMethodBeat.o(91412);
                throw bVar6;
            } else {
                AppMethodBeat.o(91412);
                return 0;
            }
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            wh whVar = (wh) objArr[1];
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
                        whVar.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(91412);
                    return 0;
                case 2:
                    whVar.KHM = aVar3.UbS.readString();
                    AppMethodBeat.o(91412);
                    return 0;
                case 3:
                    whVar.KHN = aVar3.UbS.readString();
                    AppMethodBeat.o(91412);
                    return 0;
                case 4:
                    whVar.Lhy = aVar3.UbS.readString();
                    AppMethodBeat.o(91412);
                    return 0;
                case 5:
                    whVar.Lhz = aVar3.UbS.readString();
                    AppMethodBeat.o(91412);
                    return 0;
                case 6:
                    whVar.yRL = aVar3.UbS.zi();
                    AppMethodBeat.o(91412);
                    return 0;
                default:
                    AppMethodBeat.o(91412);
                    return -1;
            }
        } else {
            AppMethodBeat.o(91412);
            return -1;
        }
    }
}

package com.tencent.mm.game.report.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.dop;
import com.tencent.mm.protocal.protobuf.jr;
import g.a.a.c.a;
import java.util.LinkedList;

public final class e extends dop {
    public String hik;
    public int hil;
    public int him;
    public int hin;
    public String hio;
    public String hip;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(176000);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.hik != null) {
                aVar.e(2, this.hik);
            }
            aVar.aM(3, this.hil);
            aVar.aM(4, this.him);
            aVar.aM(5, this.hin);
            if (this.hio != null) {
                aVar.e(6, this.hio);
            }
            if (this.hip != null) {
                aVar.e(7, this.hip);
            }
            AppMethodBeat.o(176000);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0;
            if (this.hik != null) {
                nh += g.a.a.b.b.a.f(2, this.hik);
            }
            int bu = nh + g.a.a.b.b.a.bu(3, this.hil) + g.a.a.b.b.a.bu(4, this.him) + g.a.a.b.b.a.bu(5, this.hin);
            if (this.hio != null) {
                bu += g.a.a.b.b.a.f(6, this.hio);
            }
            if (this.hip != null) {
                bu += g.a.a.b.b.a.f(7, this.hip);
            }
            AppMethodBeat.o(176000);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(176000);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            e eVar = (e) objArr[1];
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
                        eVar.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(176000);
                    return 0;
                case 2:
                    eVar.hik = aVar3.UbS.readString();
                    AppMethodBeat.o(176000);
                    return 0;
                case 3:
                    eVar.hil = aVar3.UbS.zi();
                    AppMethodBeat.o(176000);
                    return 0;
                case 4:
                    eVar.him = aVar3.UbS.zi();
                    AppMethodBeat.o(176000);
                    return 0;
                case 5:
                    eVar.hin = aVar3.UbS.zi();
                    AppMethodBeat.o(176000);
                    return 0;
                case 6:
                    eVar.hio = aVar3.UbS.readString();
                    AppMethodBeat.o(176000);
                    return 0;
                case 7:
                    eVar.hip = aVar3.UbS.readString();
                    AppMethodBeat.o(176000);
                    return 0;
                default:
                    AppMethodBeat.o(176000);
                    return -1;
            }
        } else {
            AppMethodBeat.o(176000);
            return -1;
        }
    }
}

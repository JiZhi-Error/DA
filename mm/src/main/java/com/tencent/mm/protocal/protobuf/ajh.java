package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class ajh extends dop {
    public b LoA;
    public String LoB;
    public b Loz;
    public String token;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(214286);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.Loz != null) {
                aVar.c(2, this.Loz);
            }
            if (this.LoA != null) {
                aVar.c(3, this.LoA);
            }
            if (this.token != null) {
                aVar.e(4, this.token);
            }
            if (this.LoB != null) {
                aVar.e(101, this.LoB);
            }
            AppMethodBeat.o(214286);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0;
            if (this.Loz != null) {
                nh += g.a.a.b.b.a.b(2, this.Loz);
            }
            if (this.LoA != null) {
                nh += g.a.a.b.b.a.b(3, this.LoA);
            }
            if (this.token != null) {
                nh += g.a.a.b.b.a.f(4, this.token);
            }
            if (this.LoB != null) {
                nh += g.a.a.b.b.a.f(101, this.LoB);
            }
            AppMethodBeat.o(214286);
            return nh;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(214286);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            ajh ajh = (ajh) objArr[1];
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
                        ajh.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(214286);
                    return 0;
                case 2:
                    ajh.Loz = aVar3.UbS.hPo();
                    AppMethodBeat.o(214286);
                    return 0;
                case 3:
                    ajh.LoA = aVar3.UbS.hPo();
                    AppMethodBeat.o(214286);
                    return 0;
                case 4:
                    ajh.token = aVar3.UbS.readString();
                    AppMethodBeat.o(214286);
                    return 0;
                case 101:
                    ajh.LoB = aVar3.UbS.readString();
                    AppMethodBeat.o(214286);
                    return 0;
                default:
                    AppMethodBeat.o(214286);
                    return -1;
            }
        } else {
            AppMethodBeat.o(214286);
            return -1;
        }
    }
}

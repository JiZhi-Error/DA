package com.tencent.mm.plugin.gamelife.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.dop;
import com.tencent.mm.protocal.protobuf.jr;
import g.a.a.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class p extends dop {
    public a ybe;
    public boolean ybr;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(225903);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.ybe == null) {
                b bVar = new b("Not all required fields were included: black_list_info");
                AppMethodBeat.o(225903);
                throw bVar;
            }
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.ybe != null) {
                aVar.ni(2, this.ybe.computeSize());
                this.ybe.writeFields(aVar);
            }
            aVar.cc(3, this.ybr);
            AppMethodBeat.o(225903);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0;
            if (this.ybe != null) {
                nh += g.a.a.a.nh(2, this.ybe.computeSize());
            }
            int fS = nh + g.a.a.b.b.a.fS(3) + 1;
            AppMethodBeat.o(225903);
            return fS;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.ybe == null) {
                b bVar2 = new b("Not all required fields were included: black_list_info");
                AppMethodBeat.o(225903);
                throw bVar2;
            }
            AppMethodBeat.o(225903);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            p pVar = (p) objArr[1];
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
                        pVar.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(225903);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        a aVar5 = new a();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = aVar5.populateBuilderWithField(aVar6, aVar5, dop.getNextFieldNumber(aVar6))) {
                        }
                        pVar.ybe = aVar5;
                    }
                    AppMethodBeat.o(225903);
                    return 0;
                case 3:
                    pVar.ybr = aVar3.UbS.yZ();
                    AppMethodBeat.o(225903);
                    return 0;
                default:
                    AppMethodBeat.o(225903);
                    return -1;
            }
        } else {
            AppMethodBeat.o(225903);
            return -1;
        }
    }
}

package com.tencent.mm.plugin.gamelife.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.dop;
import com.tencent.mm.protocal.protobuf.jr;
import g.a.a.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class r extends dop {
    public String session_id;
    public boolean yaY;
    public long ybs;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(225905);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.session_id == null) {
                b bVar = new b("Not all required fields were included: session_id");
                AppMethodBeat.o(225905);
                throw bVar;
            }
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.session_id != null) {
                aVar.e(2, this.session_id);
            }
            aVar.bb(3, this.ybs);
            aVar.cc(4, this.yaY);
            AppMethodBeat.o(225905);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0;
            if (this.session_id != null) {
                nh += g.a.a.b.b.a.f(2, this.session_id);
            }
            int r = nh + g.a.a.b.b.a.r(3, this.ybs) + g.a.a.b.b.a.fS(4) + 1;
            AppMethodBeat.o(225905);
            return r;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.session_id == null) {
                b bVar2 = new b("Not all required fields were included: session_id");
                AppMethodBeat.o(225905);
                throw bVar2;
            }
            AppMethodBeat.o(225905);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            r rVar = (r) objArr[1];
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
                        rVar.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(225905);
                    return 0;
                case 2:
                    rVar.session_id = aVar3.UbS.readString();
                    AppMethodBeat.o(225905);
                    return 0;
                case 3:
                    rVar.ybs = aVar3.UbS.zl();
                    AppMethodBeat.o(225905);
                    return 0;
                case 4:
                    rVar.yaY = aVar3.UbS.yZ();
                    AppMethodBeat.o(225905);
                    return 0;
                default:
                    AppMethodBeat.o(225905);
                    return -1;
            }
        } else {
            AppMethodBeat.o(225905);
            return -1;
        }
    }
}

package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import com.tencent.mm.protocal.protobuf.dop;
import com.tencent.mm.protocal.protobuf.jr;
import g.a.a.c.a;
import java.util.LinkedList;

public final class ak extends dop {
    public String hik;
    public String xKj;
    public b xKk;
    public b xKl;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(41729);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.hik == null) {
                g.a.a.b bVar = new g.a.a.b("Not all required fields were included: AppID");
                AppMethodBeat.o(41729);
                throw bVar;
            } else if (this.xKj == null) {
                g.a.a.b bVar2 = new g.a.a.b("Not all required fields were included: GroupID");
                AppMethodBeat.o(41729);
                throw bVar2;
            } else {
                if (this.BaseRequest != null) {
                    aVar.ni(1, this.BaseRequest.computeSize());
                    this.BaseRequest.writeFields(aVar);
                }
                if (this.hik != null) {
                    aVar.e(2, this.hik);
                }
                if (this.xKj != null) {
                    aVar.e(3, this.xKj);
                }
                if (this.xKk != null) {
                    aVar.c(4, this.xKk);
                }
                if (this.xKl != null) {
                    aVar.c(5, this.xKl);
                }
                AppMethodBeat.o(41729);
                return 0;
            }
        } else if (i2 == 1) {
            int nh = this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0;
            if (this.hik != null) {
                nh += g.a.a.b.b.a.f(2, this.hik);
            }
            if (this.xKj != null) {
                nh += g.a.a.b.b.a.f(3, this.xKj);
            }
            if (this.xKk != null) {
                nh += g.a.a.b.b.a.b(4, this.xKk);
            }
            if (this.xKl != null) {
                nh += g.a.a.b.b.a.b(5, this.xKl);
            }
            AppMethodBeat.o(41729);
            return nh;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.hik == null) {
                g.a.a.b bVar3 = new g.a.a.b("Not all required fields were included: AppID");
                AppMethodBeat.o(41729);
                throw bVar3;
            } else if (this.xKj == null) {
                g.a.a.b bVar4 = new g.a.a.b("Not all required fields were included: GroupID");
                AppMethodBeat.o(41729);
                throw bVar4;
            } else {
                AppMethodBeat.o(41729);
                return 0;
            }
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            ak akVar = (ak) objArr[1];
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
                        akVar.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(41729);
                    return 0;
                case 2:
                    akVar.hik = aVar3.UbS.readString();
                    AppMethodBeat.o(41729);
                    return 0;
                case 3:
                    akVar.xKj = aVar3.UbS.readString();
                    AppMethodBeat.o(41729);
                    return 0;
                case 4:
                    akVar.xKk = aVar3.UbS.hPo();
                    AppMethodBeat.o(41729);
                    return 0;
                case 5:
                    akVar.xKl = aVar3.UbS.hPo();
                    AppMethodBeat.o(41729);
                    return 0;
                default:
                    AppMethodBeat.o(41729);
                    return -1;
            }
        } else {
            AppMethodBeat.o(41729);
            return -1;
        }
    }
}

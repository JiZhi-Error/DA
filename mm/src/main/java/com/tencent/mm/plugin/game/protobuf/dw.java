package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.dop;
import com.tencent.mm.protocal.protobuf.jr;
import g.a.a.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class dw extends dop {
    public String hik;
    public String keh;
    public String xIG;
    public boolean xIT;
    public String xLl;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(41836);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.xLl == null) {
                b bVar = new b("Not all required fields were included: Lang");
                AppMethodBeat.o(41836);
                throw bVar;
            } else if (this.hik == null) {
                b bVar2 = new b("Not all required fields were included: AppID");
                AppMethodBeat.o(41836);
                throw bVar2;
            } else {
                if (this.BaseRequest != null) {
                    aVar.ni(1, this.BaseRequest.computeSize());
                    this.BaseRequest.writeFields(aVar);
                }
                if (this.xLl != null) {
                    aVar.e(2, this.xLl);
                }
                if (this.hik != null) {
                    aVar.e(3, this.hik);
                }
                if (this.xIG != null) {
                    aVar.e(4, this.xIG);
                }
                if (this.keh != null) {
                    aVar.e(5, this.keh);
                }
                aVar.cc(6, this.xIT);
                AppMethodBeat.o(41836);
                return 0;
            }
        } else if (i2 == 1) {
            int nh = this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0;
            if (this.xLl != null) {
                nh += g.a.a.b.b.a.f(2, this.xLl);
            }
            if (this.hik != null) {
                nh += g.a.a.b.b.a.f(3, this.hik);
            }
            if (this.xIG != null) {
                nh += g.a.a.b.b.a.f(4, this.xIG);
            }
            if (this.keh != null) {
                nh += g.a.a.b.b.a.f(5, this.keh);
            }
            int fS = nh + g.a.a.b.b.a.fS(6) + 1;
            AppMethodBeat.o(41836);
            return fS;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.xLl == null) {
                b bVar3 = new b("Not all required fields were included: Lang");
                AppMethodBeat.o(41836);
                throw bVar3;
            } else if (this.hik == null) {
                b bVar4 = new b("Not all required fields were included: AppID");
                AppMethodBeat.o(41836);
                throw bVar4;
            } else {
                AppMethodBeat.o(41836);
                return 0;
            }
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            dw dwVar = (dw) objArr[1];
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
                        dwVar.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(41836);
                    return 0;
                case 2:
                    dwVar.xLl = aVar3.UbS.readString();
                    AppMethodBeat.o(41836);
                    return 0;
                case 3:
                    dwVar.hik = aVar3.UbS.readString();
                    AppMethodBeat.o(41836);
                    return 0;
                case 4:
                    dwVar.xIG = aVar3.UbS.readString();
                    AppMethodBeat.o(41836);
                    return 0;
                case 5:
                    dwVar.keh = aVar3.UbS.readString();
                    AppMethodBeat.o(41836);
                    return 0;
                case 6:
                    dwVar.xIT = aVar3.UbS.yZ();
                    AppMethodBeat.o(41836);
                    return 0;
                default:
                    AppMethodBeat.o(41836);
                    return -1;
            }
        } else {
            AppMethodBeat.o(41836);
            return -1;
        }
    }
}

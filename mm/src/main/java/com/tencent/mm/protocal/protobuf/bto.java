package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class bto extends dop {
    public int Height;
    public String Mae;
    public String URL;
    public int Width;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(82416);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.URL == null) {
                b bVar = new b("Not all required fields were included: URL");
                AppMethodBeat.o(82416);
                throw bVar;
            } else if (this.Mae == null) {
                b bVar2 = new b("Not all required fields were included: UserAgent");
                AppMethodBeat.o(82416);
                throw bVar2;
            } else {
                if (this.BaseRequest != null) {
                    aVar.ni(1, this.BaseRequest.computeSize());
                    this.BaseRequest.writeFields(aVar);
                }
                if (this.URL != null) {
                    aVar.e(2, this.URL);
                }
                if (this.Mae != null) {
                    aVar.e(3, this.Mae);
                }
                aVar.aM(4, this.Width);
                aVar.aM(5, this.Height);
                AppMethodBeat.o(82416);
                return 0;
            }
        } else if (i2 == 1) {
            int nh = this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0;
            if (this.URL != null) {
                nh += g.a.a.b.b.a.f(2, this.URL);
            }
            if (this.Mae != null) {
                nh += g.a.a.b.b.a.f(3, this.Mae);
            }
            int bu = nh + g.a.a.b.b.a.bu(4, this.Width) + g.a.a.b.b.a.bu(5, this.Height);
            AppMethodBeat.o(82416);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.URL == null) {
                b bVar3 = new b("Not all required fields were included: URL");
                AppMethodBeat.o(82416);
                throw bVar3;
            } else if (this.Mae == null) {
                b bVar4 = new b("Not all required fields were included: UserAgent");
                AppMethodBeat.o(82416);
                throw bVar4;
            } else {
                AppMethodBeat.o(82416);
                return 0;
            }
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            bto bto = (bto) objArr[1];
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
                        bto.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(82416);
                    return 0;
                case 2:
                    bto.URL = aVar3.UbS.readString();
                    AppMethodBeat.o(82416);
                    return 0;
                case 3:
                    bto.Mae = aVar3.UbS.readString();
                    AppMethodBeat.o(82416);
                    return 0;
                case 4:
                    bto.Width = aVar3.UbS.zi();
                    AppMethodBeat.o(82416);
                    return 0;
                case 5:
                    bto.Height = aVar3.UbS.zi();
                    AppMethodBeat.o(82416);
                    return 0;
                default:
                    AppMethodBeat.o(82416);
                    return -1;
            }
        } else {
            AppMethodBeat.o(82416);
            return -1;
        }
    }
}

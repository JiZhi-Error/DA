package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.c.a;
import java.util.LinkedList;

public final class czx extends dop {
    public String KPJ;
    public String Ljk;
    public String Lkp;
    public String Lkq;
    public String Lkr;
    public String Lks;
    public String jfi;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(91580);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.jfi != null) {
                aVar.e(2, this.jfi);
            }
            if (this.Lkp != null) {
                aVar.e(3, this.Lkp);
            }
            if (this.KPJ != null) {
                aVar.e(4, this.KPJ);
            }
            if (this.Lkq != null) {
                aVar.e(5, this.Lkq);
            }
            if (this.Lkr != null) {
                aVar.e(6, this.Lkr);
            }
            if (this.Lks != null) {
                aVar.e(7, this.Lks);
            }
            if (this.Ljk != null) {
                aVar.e(8, this.Ljk);
            }
            AppMethodBeat.o(91580);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0;
            if (this.jfi != null) {
                nh += g.a.a.b.b.a.f(2, this.jfi);
            }
            if (this.Lkp != null) {
                nh += g.a.a.b.b.a.f(3, this.Lkp);
            }
            if (this.KPJ != null) {
                nh += g.a.a.b.b.a.f(4, this.KPJ);
            }
            if (this.Lkq != null) {
                nh += g.a.a.b.b.a.f(5, this.Lkq);
            }
            if (this.Lkr != null) {
                nh += g.a.a.b.b.a.f(6, this.Lkr);
            }
            if (this.Lks != null) {
                nh += g.a.a.b.b.a.f(7, this.Lks);
            }
            if (this.Ljk != null) {
                nh += g.a.a.b.b.a.f(8, this.Ljk);
            }
            AppMethodBeat.o(91580);
            return nh;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(91580);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            czx czx = (czx) objArr[1];
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
                        czx.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(91580);
                    return 0;
                case 2:
                    czx.jfi = aVar3.UbS.readString();
                    AppMethodBeat.o(91580);
                    return 0;
                case 3:
                    czx.Lkp = aVar3.UbS.readString();
                    AppMethodBeat.o(91580);
                    return 0;
                case 4:
                    czx.KPJ = aVar3.UbS.readString();
                    AppMethodBeat.o(91580);
                    return 0;
                case 5:
                    czx.Lkq = aVar3.UbS.readString();
                    AppMethodBeat.o(91580);
                    return 0;
                case 6:
                    czx.Lkr = aVar3.UbS.readString();
                    AppMethodBeat.o(91580);
                    return 0;
                case 7:
                    czx.Lks = aVar3.UbS.readString();
                    AppMethodBeat.o(91580);
                    return 0;
                case 8:
                    czx.Ljk = aVar3.UbS.readString();
                    AppMethodBeat.o(91580);
                    return 0;
                default:
                    AppMethodBeat.o(91580);
                    return -1;
            }
        } else {
            AppMethodBeat.o(91580);
            return -1;
        }
    }
}

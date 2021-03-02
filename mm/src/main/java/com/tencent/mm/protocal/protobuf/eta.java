package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class eta extends dop {
    public int Llx;
    public long MKf;
    public int MKg;
    public String Nqu;
    public b Nqv;
    public b Nqw;
    public String Nqx;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(125498);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.Nqu == null) {
                g.a.a.b bVar = new g.a.a.b("Not all required fields were included: ToBizUserName");
                AppMethodBeat.o(125498);
                throw bVar;
            } else if (this.Nqw == null) {
                g.a.a.b bVar2 = new g.a.a.b("Not all required fields were included: CapInfo");
                AppMethodBeat.o(125498);
                throw bVar2;
            } else {
                if (this.BaseRequest != null) {
                    aVar.ni(1, this.BaseRequest.computeSize());
                    this.BaseRequest.writeFields(aVar);
                }
                aVar.aM(2, this.MKg);
                if (this.Nqu != null) {
                    aVar.e(3, this.Nqu);
                }
                aVar.aM(4, this.Llx);
                if (this.Nqv != null) {
                    aVar.c(5, this.Nqv);
                }
                if (this.Nqw != null) {
                    aVar.c(6, this.Nqw);
                }
                aVar.bb(7, this.MKf);
                if (this.Nqx != null) {
                    aVar.e(8, this.Nqx);
                }
                AppMethodBeat.o(125498);
                return 0;
            }
        } else if (i2 == 1) {
            int nh = (this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0) + g.a.a.b.b.a.bu(2, this.MKg);
            if (this.Nqu != null) {
                nh += g.a.a.b.b.a.f(3, this.Nqu);
            }
            int bu = nh + g.a.a.b.b.a.bu(4, this.Llx);
            if (this.Nqv != null) {
                bu += g.a.a.b.b.a.b(5, this.Nqv);
            }
            if (this.Nqw != null) {
                bu += g.a.a.b.b.a.b(6, this.Nqw);
            }
            int r = bu + g.a.a.b.b.a.r(7, this.MKf);
            if (this.Nqx != null) {
                r += g.a.a.b.b.a.f(8, this.Nqx);
            }
            AppMethodBeat.o(125498);
            return r;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.Nqu == null) {
                g.a.a.b bVar3 = new g.a.a.b("Not all required fields were included: ToBizUserName");
                AppMethodBeat.o(125498);
                throw bVar3;
            } else if (this.Nqw == null) {
                g.a.a.b bVar4 = new g.a.a.b("Not all required fields were included: CapInfo");
                AppMethodBeat.o(125498);
                throw bVar4;
            } else {
                AppMethodBeat.o(125498);
                return 0;
            }
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            eta eta = (eta) objArr[1];
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
                        eta.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(125498);
                    return 0;
                case 2:
                    eta.MKg = aVar3.UbS.zi();
                    AppMethodBeat.o(125498);
                    return 0;
                case 3:
                    eta.Nqu = aVar3.UbS.readString();
                    AppMethodBeat.o(125498);
                    return 0;
                case 4:
                    eta.Llx = aVar3.UbS.zi();
                    AppMethodBeat.o(125498);
                    return 0;
                case 5:
                    eta.Nqv = aVar3.UbS.hPo();
                    AppMethodBeat.o(125498);
                    return 0;
                case 6:
                    eta.Nqw = aVar3.UbS.hPo();
                    AppMethodBeat.o(125498);
                    return 0;
                case 7:
                    eta.MKf = aVar3.UbS.zl();
                    AppMethodBeat.o(125498);
                    return 0;
                case 8:
                    eta.Nqx = aVar3.UbS.readString();
                    AppMethodBeat.o(125498);
                    return 0;
                default:
                    AppMethodBeat.o(125498);
                    return -1;
            }
        } else {
            AppMethodBeat.o(125498);
            return -1;
        }
    }
}

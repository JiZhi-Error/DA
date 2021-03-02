package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class cdx extends dop {
    public String Mjs;
    public String Mju;
    public String Mjv;
    public b Mjw;
    public int Mjx;
    public String Mjy;
    public String dmc;
    public String hik;
    public String scope;
    public String signature;
    public String url;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(82433);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.url != null) {
                aVar.e(2, this.url);
            }
            if (this.hik != null) {
                aVar.e(3, this.hik);
            }
            if (this.Mjs != null) {
                aVar.e(4, this.Mjs);
            }
            if (this.dmc != null) {
                aVar.e(5, this.dmc);
            }
            if (this.Mju != null) {
                aVar.e(6, this.Mju);
            }
            if (this.signature != null) {
                aVar.e(7, this.signature);
            }
            if (this.Mjv != null) {
                aVar.e(8, this.Mjv);
            }
            if (this.Mjw != null) {
                aVar.c(9, this.Mjw);
            }
            aVar.aM(10, this.Mjx);
            if (this.scope != null) {
                aVar.e(11, this.scope);
            }
            if (this.Mjy != null) {
                aVar.e(12, this.Mjy);
            }
            AppMethodBeat.o(82433);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0;
            if (this.url != null) {
                nh += g.a.a.b.b.a.f(2, this.url);
            }
            if (this.hik != null) {
                nh += g.a.a.b.b.a.f(3, this.hik);
            }
            if (this.Mjs != null) {
                nh += g.a.a.b.b.a.f(4, this.Mjs);
            }
            if (this.dmc != null) {
                nh += g.a.a.b.b.a.f(5, this.dmc);
            }
            if (this.Mju != null) {
                nh += g.a.a.b.b.a.f(6, this.Mju);
            }
            if (this.signature != null) {
                nh += g.a.a.b.b.a.f(7, this.signature);
            }
            if (this.Mjv != null) {
                nh += g.a.a.b.b.a.f(8, this.Mjv);
            }
            if (this.Mjw != null) {
                nh += g.a.a.b.b.a.b(9, this.Mjw);
            }
            int bu = nh + g.a.a.b.b.a.bu(10, this.Mjx);
            if (this.scope != null) {
                bu += g.a.a.b.b.a.f(11, this.scope);
            }
            if (this.Mjy != null) {
                bu += g.a.a.b.b.a.f(12, this.Mjy);
            }
            AppMethodBeat.o(82433);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(82433);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            cdx cdx = (cdx) objArr[1];
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
                        cdx.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(82433);
                    return 0;
                case 2:
                    cdx.url = aVar3.UbS.readString();
                    AppMethodBeat.o(82433);
                    return 0;
                case 3:
                    cdx.hik = aVar3.UbS.readString();
                    AppMethodBeat.o(82433);
                    return 0;
                case 4:
                    cdx.Mjs = aVar3.UbS.readString();
                    AppMethodBeat.o(82433);
                    return 0;
                case 5:
                    cdx.dmc = aVar3.UbS.readString();
                    AppMethodBeat.o(82433);
                    return 0;
                case 6:
                    cdx.Mju = aVar3.UbS.readString();
                    AppMethodBeat.o(82433);
                    return 0;
                case 7:
                    cdx.signature = aVar3.UbS.readString();
                    AppMethodBeat.o(82433);
                    return 0;
                case 8:
                    cdx.Mjv = aVar3.UbS.readString();
                    AppMethodBeat.o(82433);
                    return 0;
                case 9:
                    cdx.Mjw = aVar3.UbS.hPo();
                    AppMethodBeat.o(82433);
                    return 0;
                case 10:
                    cdx.Mjx = aVar3.UbS.zi();
                    AppMethodBeat.o(82433);
                    return 0;
                case 11:
                    cdx.scope = aVar3.UbS.readString();
                    AppMethodBeat.o(82433);
                    return 0;
                case 12:
                    cdx.Mjy = aVar3.UbS.readString();
                    AppMethodBeat.o(82433);
                    return 0;
                default:
                    AppMethodBeat.o(82433);
                    return -1;
            }
        } else {
            AppMethodBeat.o(82433);
            return -1;
        }
    }
}

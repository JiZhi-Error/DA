package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class cej extends dop {
    public LinkedList<cey> MjC = new LinkedList<>();
    public String Mjs;
    public String Mju;
    public String Mjv;
    public b Mjw;
    public int Mjx;
    public String Mjy;
    public String dNI;
    public String dmc;
    public String signature;
    public String url;

    public cej() {
        AppMethodBeat.i(82444);
        AppMethodBeat.o(82444);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(82445);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.url != null) {
                aVar.e(2, this.url);
            }
            if (this.dNI != null) {
                aVar.e(3, this.dNI);
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
            aVar.e(11, 8, this.MjC);
            if (this.Mjy != null) {
                aVar.e(12, this.Mjy);
            }
            AppMethodBeat.o(82445);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0;
            if (this.url != null) {
                nh += g.a.a.b.b.a.f(2, this.url);
            }
            if (this.dNI != null) {
                nh += g.a.a.b.b.a.f(3, this.dNI);
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
            int bu = nh + g.a.a.b.b.a.bu(10, this.Mjx) + g.a.a.a.c(11, 8, this.MjC);
            if (this.Mjy != null) {
                bu += g.a.a.b.b.a.f(12, this.Mjy);
            }
            AppMethodBeat.o(82445);
            return bu;
        } else if (i2 == 2) {
            this.MjC.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(82445);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            cej cej = (cej) objArr[1];
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
                        cej.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(82445);
                    return 0;
                case 2:
                    cej.url = aVar3.UbS.readString();
                    AppMethodBeat.o(82445);
                    return 0;
                case 3:
                    cej.dNI = aVar3.UbS.readString();
                    AppMethodBeat.o(82445);
                    return 0;
                case 4:
                    cej.Mjs = aVar3.UbS.readString();
                    AppMethodBeat.o(82445);
                    return 0;
                case 5:
                    cej.dmc = aVar3.UbS.readString();
                    AppMethodBeat.o(82445);
                    return 0;
                case 6:
                    cej.Mju = aVar3.UbS.readString();
                    AppMethodBeat.o(82445);
                    return 0;
                case 7:
                    cej.signature = aVar3.UbS.readString();
                    AppMethodBeat.o(82445);
                    return 0;
                case 8:
                    cej.Mjv = aVar3.UbS.readString();
                    AppMethodBeat.o(82445);
                    return 0;
                case 9:
                    cej.Mjw = aVar3.UbS.hPo();
                    AppMethodBeat.o(82445);
                    return 0;
                case 10:
                    cej.Mjx = aVar3.UbS.zi();
                    AppMethodBeat.o(82445);
                    return 0;
                case 11:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        cey cey = new cey();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = cey.populateBuilderWithField(aVar5, cey, dop.getNextFieldNumber(aVar5))) {
                        }
                        cej.MjC.add(cey);
                    }
                    AppMethodBeat.o(82445);
                    return 0;
                case 12:
                    cej.Mjy = aVar3.UbS.readString();
                    AppMethodBeat.o(82445);
                    return 0;
                default:
                    AppMethodBeat.o(82445);
                    return -1;
            }
        } else {
            AppMethodBeat.o(82445);
            return -1;
        }
    }
}

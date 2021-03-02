package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.c.a;
import java.util.LinkedList;

public final class yf extends dop {
    public int Ljf;
    public LinkedList<dqi> Ljg = new LinkedList<>();
    public String Ljh;
    public String Lji;
    public int Scene;
    public String hik;
    public String xNG;
    public String xNU;
    public int xub;

    public yf() {
        AppMethodBeat.i(124468);
        AppMethodBeat.o(124468);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(124469);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            aVar.aM(2, this.xub);
            if (this.xNG != null) {
                aVar.e(3, this.xNG);
            }
            if (this.xNU != null) {
                aVar.e(4, this.xNU);
            }
            if (this.hik != null) {
                aVar.e(5, this.hik);
            }
            aVar.aM(6, this.Ljf);
            aVar.e(7, 8, this.Ljg);
            if (this.Ljh != null) {
                aVar.e(8, this.Ljh);
            }
            if (this.Lji != null) {
                aVar.e(9, this.Lji);
            }
            aVar.aM(10, this.Scene);
            AppMethodBeat.o(124469);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0) + g.a.a.b.b.a.bu(2, this.xub);
            if (this.xNG != null) {
                nh += g.a.a.b.b.a.f(3, this.xNG);
            }
            if (this.xNU != null) {
                nh += g.a.a.b.b.a.f(4, this.xNU);
            }
            if (this.hik != null) {
                nh += g.a.a.b.b.a.f(5, this.hik);
            }
            int bu = nh + g.a.a.b.b.a.bu(6, this.Ljf) + g.a.a.a.c(7, 8, this.Ljg);
            if (this.Ljh != null) {
                bu += g.a.a.b.b.a.f(8, this.Ljh);
            }
            if (this.Lji != null) {
                bu += g.a.a.b.b.a.f(9, this.Lji);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(10, this.Scene);
            AppMethodBeat.o(124469);
            return bu2;
        } else if (i2 == 2) {
            this.Ljg.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(124469);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            yf yfVar = (yf) objArr[1];
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
                        yfVar.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(124469);
                    return 0;
                case 2:
                    yfVar.xub = aVar3.UbS.zi();
                    AppMethodBeat.o(124469);
                    return 0;
                case 3:
                    yfVar.xNG = aVar3.UbS.readString();
                    AppMethodBeat.o(124469);
                    return 0;
                case 4:
                    yfVar.xNU = aVar3.UbS.readString();
                    AppMethodBeat.o(124469);
                    return 0;
                case 5:
                    yfVar.hik = aVar3.UbS.readString();
                    AppMethodBeat.o(124469);
                    return 0;
                case 6:
                    yfVar.Ljf = aVar3.UbS.zi();
                    AppMethodBeat.o(124469);
                    return 0;
                case 7:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        dqi dqi = new dqi();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = dqi.populateBuilderWithField(aVar5, dqi, dop.getNextFieldNumber(aVar5))) {
                        }
                        yfVar.Ljg.add(dqi);
                    }
                    AppMethodBeat.o(124469);
                    return 0;
                case 8:
                    yfVar.Ljh = aVar3.UbS.readString();
                    AppMethodBeat.o(124469);
                    return 0;
                case 9:
                    yfVar.Lji = aVar3.UbS.readString();
                    AppMethodBeat.o(124469);
                    return 0;
                case 10:
                    yfVar.Scene = aVar3.UbS.zi();
                    AppMethodBeat.o(124469);
                    return 0;
                default:
                    AppMethodBeat.o(124469);
                    return -1;
            }
        } else {
            AppMethodBeat.o(124469);
            return -1;
        }
    }
}

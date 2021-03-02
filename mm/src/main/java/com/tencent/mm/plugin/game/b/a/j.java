package com.tencent.mm.plugin.game.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.dop;
import com.tencent.mm.protocal.protobuf.jr;
import g.a.a.c.a;
import java.util.LinkedList;

public final class j extends dop {
    public int errorCode;
    public String oTJ;
    public int oTW;
    public String oUj;
    public String xuB;
    public String xuC;
    public String xuk;
    public String xun;
    public String xuo;
    public String xup;
    public String xuq;
    public String xur;
    public int xus;
    public String xuz;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(204105);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.xuk != null) {
                aVar.e(2, this.xuk);
            }
            aVar.aM(3, this.xus);
            aVar.aM(4, this.oTW);
            if (this.xuz != null) {
                aVar.e(5, this.xuz);
            }
            if (this.xuB != null) {
                aVar.e(6, this.xuB);
            }
            if (this.xuC != null) {
                aVar.e(7, this.xuC);
            }
            aVar.aM(8, this.errorCode);
            if (this.xup != null) {
                aVar.e(9, this.xup);
            }
            if (this.xuo != null) {
                aVar.e(10, this.xuo);
            }
            if (this.xun != null) {
                aVar.e(11, this.xun);
            }
            if (this.xuq != null) {
                aVar.e(12, this.xuq);
            }
            if (this.xur != null) {
                aVar.e(13, this.xur);
            }
            if (this.oTJ != null) {
                aVar.e(14, this.oTJ);
            }
            if (this.oUj != null) {
                aVar.e(15, this.oUj);
            }
            AppMethodBeat.o(204105);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0;
            if (this.xuk != null) {
                nh += g.a.a.b.b.a.f(2, this.xuk);
            }
            int bu = nh + g.a.a.b.b.a.bu(3, this.xus) + g.a.a.b.b.a.bu(4, this.oTW);
            if (this.xuz != null) {
                bu += g.a.a.b.b.a.f(5, this.xuz);
            }
            if (this.xuB != null) {
                bu += g.a.a.b.b.a.f(6, this.xuB);
            }
            if (this.xuC != null) {
                bu += g.a.a.b.b.a.f(7, this.xuC);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(8, this.errorCode);
            if (this.xup != null) {
                bu2 += g.a.a.b.b.a.f(9, this.xup);
            }
            if (this.xuo != null) {
                bu2 += g.a.a.b.b.a.f(10, this.xuo);
            }
            if (this.xun != null) {
                bu2 += g.a.a.b.b.a.f(11, this.xun);
            }
            if (this.xuq != null) {
                bu2 += g.a.a.b.b.a.f(12, this.xuq);
            }
            if (this.xur != null) {
                bu2 += g.a.a.b.b.a.f(13, this.xur);
            }
            if (this.oTJ != null) {
                bu2 += g.a.a.b.b.a.f(14, this.oTJ);
            }
            if (this.oUj != null) {
                bu2 += g.a.a.b.b.a.f(15, this.oUj);
            }
            AppMethodBeat.o(204105);
            return bu2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(204105);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            j jVar = (j) objArr[1];
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
                        jVar.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(204105);
                    return 0;
                case 2:
                    jVar.xuk = aVar3.UbS.readString();
                    AppMethodBeat.o(204105);
                    return 0;
                case 3:
                    jVar.xus = aVar3.UbS.zi();
                    AppMethodBeat.o(204105);
                    return 0;
                case 4:
                    jVar.oTW = aVar3.UbS.zi();
                    AppMethodBeat.o(204105);
                    return 0;
                case 5:
                    jVar.xuz = aVar3.UbS.readString();
                    AppMethodBeat.o(204105);
                    return 0;
                case 6:
                    jVar.xuB = aVar3.UbS.readString();
                    AppMethodBeat.o(204105);
                    return 0;
                case 7:
                    jVar.xuC = aVar3.UbS.readString();
                    AppMethodBeat.o(204105);
                    return 0;
                case 8:
                    jVar.errorCode = aVar3.UbS.zi();
                    AppMethodBeat.o(204105);
                    return 0;
                case 9:
                    jVar.xup = aVar3.UbS.readString();
                    AppMethodBeat.o(204105);
                    return 0;
                case 10:
                    jVar.xuo = aVar3.UbS.readString();
                    AppMethodBeat.o(204105);
                    return 0;
                case 11:
                    jVar.xun = aVar3.UbS.readString();
                    AppMethodBeat.o(204105);
                    return 0;
                case 12:
                    jVar.xuq = aVar3.UbS.readString();
                    AppMethodBeat.o(204105);
                    return 0;
                case 13:
                    jVar.xur = aVar3.UbS.readString();
                    AppMethodBeat.o(204105);
                    return 0;
                case 14:
                    jVar.oTJ = aVar3.UbS.readString();
                    AppMethodBeat.o(204105);
                    return 0;
                case 15:
                    jVar.oUj = aVar3.UbS.readString();
                    AppMethodBeat.o(204105);
                    return 0;
                default:
                    AppMethodBeat.o(204105);
                    return -1;
            }
        } else {
            AppMethodBeat.o(204105);
            return -1;
        }
    }
}

package com.tencent.mm.plugin.game.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.dop;
import com.tencent.mm.protocal.protobuf.jr;
import g.a.a.c.a;
import java.util.LinkedList;

public final class e extends dop {
    public String jfi;
    public String oTJ;
    public String oUj;
    public String xuk;
    public String xun;
    public String xuo;
    public String xup;
    public String xuq;
    public String xur;
    public int xus;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(204101);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.oTJ != null) {
                aVar.e(2, this.oTJ);
            }
            if (this.oUj != null) {
                aVar.e(3, this.oUj);
            }
            if (this.xun != null) {
                aVar.e(4, this.xun);
            }
            if (this.xuo != null) {
                aVar.e(5, this.xuo);
            }
            if (this.xup != null) {
                aVar.e(6, this.xup);
            }
            if (this.xuk != null) {
                aVar.e(7, this.xuk);
            }
            if (this.jfi != null) {
                aVar.e(8, this.jfi);
            }
            if (this.xuq != null) {
                aVar.e(9, this.xuq);
            }
            if (this.xur != null) {
                aVar.e(10, this.xur);
            }
            aVar.aM(11, this.xus);
            AppMethodBeat.o(204101);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0;
            if (this.oTJ != null) {
                nh += g.a.a.b.b.a.f(2, this.oTJ);
            }
            if (this.oUj != null) {
                nh += g.a.a.b.b.a.f(3, this.oUj);
            }
            if (this.xun != null) {
                nh += g.a.a.b.b.a.f(4, this.xun);
            }
            if (this.xuo != null) {
                nh += g.a.a.b.b.a.f(5, this.xuo);
            }
            if (this.xup != null) {
                nh += g.a.a.b.b.a.f(6, this.xup);
            }
            if (this.xuk != null) {
                nh += g.a.a.b.b.a.f(7, this.xuk);
            }
            if (this.jfi != null) {
                nh += g.a.a.b.b.a.f(8, this.jfi);
            }
            if (this.xuq != null) {
                nh += g.a.a.b.b.a.f(9, this.xuq);
            }
            if (this.xur != null) {
                nh += g.a.a.b.b.a.f(10, this.xur);
            }
            int bu = nh + g.a.a.b.b.a.bu(11, this.xus);
            AppMethodBeat.o(204101);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(204101);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            e eVar = (e) objArr[1];
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
                        eVar.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(204101);
                    return 0;
                case 2:
                    eVar.oTJ = aVar3.UbS.readString();
                    AppMethodBeat.o(204101);
                    return 0;
                case 3:
                    eVar.oUj = aVar3.UbS.readString();
                    AppMethodBeat.o(204101);
                    return 0;
                case 4:
                    eVar.xun = aVar3.UbS.readString();
                    AppMethodBeat.o(204101);
                    return 0;
                case 5:
                    eVar.xuo = aVar3.UbS.readString();
                    AppMethodBeat.o(204101);
                    return 0;
                case 6:
                    eVar.xup = aVar3.UbS.readString();
                    AppMethodBeat.o(204101);
                    return 0;
                case 7:
                    eVar.xuk = aVar3.UbS.readString();
                    AppMethodBeat.o(204101);
                    return 0;
                case 8:
                    eVar.jfi = aVar3.UbS.readString();
                    AppMethodBeat.o(204101);
                    return 0;
                case 9:
                    eVar.xuq = aVar3.UbS.readString();
                    AppMethodBeat.o(204101);
                    return 0;
                case 10:
                    eVar.xur = aVar3.UbS.readString();
                    AppMethodBeat.o(204101);
                    return 0;
                case 11:
                    eVar.xus = aVar3.UbS.zi();
                    AppMethodBeat.o(204101);
                    return 0;
                default:
                    AppMethodBeat.o(204101);
                    return -1;
            }
        } else {
            AppMethodBeat.o(204101);
            return -1;
        }
    }
}

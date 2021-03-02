package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class arx extends dop {
    public long Gcy;
    public long LDo;
    public String finderUsername;
    public int scene;
    public b tVM;
    public aov uli;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(168976);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.finderUsername != null) {
                aVar.e(2, this.finderUsername);
            }
            aVar.bb(3, this.Gcy);
            if (this.tVM != null) {
                aVar.c(4, this.tVM);
            }
            if (this.uli != null) {
                aVar.ni(5, this.uli.computeSize());
                this.uli.writeFields(aVar);
            }
            aVar.bb(6, this.LDo);
            aVar.aM(7, this.scene);
            AppMethodBeat.o(168976);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0;
            if (this.finderUsername != null) {
                nh += g.a.a.b.b.a.f(2, this.finderUsername);
            }
            int r = nh + g.a.a.b.b.a.r(3, this.Gcy);
            if (this.tVM != null) {
                r += g.a.a.b.b.a.b(4, this.tVM);
            }
            if (this.uli != null) {
                r += g.a.a.a.nh(5, this.uli.computeSize());
            }
            int r2 = r + g.a.a.b.b.a.r(6, this.LDo) + g.a.a.b.b.a.bu(7, this.scene);
            AppMethodBeat.o(168976);
            return r2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(168976);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            arx arx = (arx) objArr[1];
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
                        arx.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(168976);
                    return 0;
                case 2:
                    arx.finderUsername = aVar3.UbS.readString();
                    AppMethodBeat.o(168976);
                    return 0;
                case 3:
                    arx.Gcy = aVar3.UbS.zl();
                    AppMethodBeat.o(168976);
                    return 0;
                case 4:
                    arx.tVM = aVar3.UbS.hPo();
                    AppMethodBeat.o(168976);
                    return 0;
                case 5:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        aov aov = new aov();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = aov.populateBuilderWithField(aVar5, aov, dop.getNextFieldNumber(aVar5))) {
                        }
                        arx.uli = aov;
                    }
                    AppMethodBeat.o(168976);
                    return 0;
                case 6:
                    arx.LDo = aVar3.UbS.zl();
                    AppMethodBeat.o(168976);
                    return 0;
                case 7:
                    arx.scene = aVar3.UbS.zi();
                    AppMethodBeat.o(168976);
                    return 0;
                default:
                    AppMethodBeat.o(168976);
                    return -1;
            }
        } else {
            AppMethodBeat.o(168976);
            return -1;
        }
    }
}

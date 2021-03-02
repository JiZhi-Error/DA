package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class boi extends dop {
    public int LWx;
    public LinkedList<ade> LWy = new LinkedList<>();
    public String sJI;
    public String sJJ;
    public int scene;
    public String version;

    public boi() {
        AppMethodBeat.i(220706);
        AppMethodBeat.o(220706);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(220707);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.sJI == null) {
                b bVar = new b("Not all required fields were included: rversion");
                AppMethodBeat.o(220707);
                throw bVar;
            } else if (this.sJJ == null) {
                b bVar2 = new b("Not all required fields were included: buildTag");
                AppMethodBeat.o(220707);
                throw bVar2;
            } else {
                if (this.BaseRequest != null) {
                    aVar.ni(1, this.BaseRequest.computeSize());
                    this.BaseRequest.writeFields(aVar);
                }
                aVar.aM(2, this.LWx);
                aVar.aM(3, this.scene);
                if (this.version != null) {
                    aVar.e(4, this.version);
                }
                if (this.sJI != null) {
                    aVar.e(5, this.sJI);
                }
                if (this.sJJ != null) {
                    aVar.e(6, this.sJJ);
                }
                aVar.e(7, 8, this.LWy);
                AppMethodBeat.o(220707);
                return 0;
            }
        } else if (i2 == 1) {
            int nh = (this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0) + g.a.a.b.b.a.bu(2, this.LWx) + g.a.a.b.b.a.bu(3, this.scene);
            if (this.version != null) {
                nh += g.a.a.b.b.a.f(4, this.version);
            }
            if (this.sJI != null) {
                nh += g.a.a.b.b.a.f(5, this.sJI);
            }
            if (this.sJJ != null) {
                nh += g.a.a.b.b.a.f(6, this.sJJ);
            }
            int c2 = nh + g.a.a.a.c(7, 8, this.LWy);
            AppMethodBeat.o(220707);
            return c2;
        } else if (i2 == 2) {
            this.LWy.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.sJI == null) {
                b bVar3 = new b("Not all required fields were included: rversion");
                AppMethodBeat.o(220707);
                throw bVar3;
            } else if (this.sJJ == null) {
                b bVar4 = new b("Not all required fields were included: buildTag");
                AppMethodBeat.o(220707);
                throw bVar4;
            } else {
                AppMethodBeat.o(220707);
                return 0;
            }
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            boi boi = (boi) objArr[1];
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
                        boi.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(220707);
                    return 0;
                case 2:
                    boi.LWx = aVar3.UbS.zi();
                    AppMethodBeat.o(220707);
                    return 0;
                case 3:
                    boi.scene = aVar3.UbS.zi();
                    AppMethodBeat.o(220707);
                    return 0;
                case 4:
                    boi.version = aVar3.UbS.readString();
                    AppMethodBeat.o(220707);
                    return 0;
                case 5:
                    boi.sJI = aVar3.UbS.readString();
                    AppMethodBeat.o(220707);
                    return 0;
                case 6:
                    boi.sJJ = aVar3.UbS.readString();
                    AppMethodBeat.o(220707);
                    return 0;
                case 7:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        ade ade = new ade();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = ade.populateBuilderWithField(aVar5, ade, dop.getNextFieldNumber(aVar5))) {
                        }
                        boi.LWy.add(ade);
                    }
                    AppMethodBeat.o(220707);
                    return 0;
                default:
                    AppMethodBeat.o(220707);
                    return -1;
            }
        } else {
            AppMethodBeat.o(220707);
            return -1;
        }
    }
}

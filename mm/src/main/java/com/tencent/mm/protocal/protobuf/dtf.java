package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.c.a;
import java.util.LinkedList;

public final class dtf extends dop {
    public int KXD;
    public String KZR;
    public String Lmp;
    public String MVs;
    public String dNI;
    public int scene;
    public int source;
    public String url;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(91683);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.Lmp != null) {
                aVar.e(2, this.Lmp);
            }
            if (this.dNI != null) {
                aVar.e(3, this.dNI);
            }
            if (this.url != null) {
                aVar.e(4, this.url);
            }
            if (this.MVs != null) {
                aVar.e(5, this.MVs);
            }
            aVar.aM(6, this.scene);
            aVar.aM(7, this.source);
            if (this.KZR != null) {
                aVar.e(8, this.KZR);
            }
            aVar.aM(9, this.KXD);
            AppMethodBeat.o(91683);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0;
            if (this.Lmp != null) {
                nh += g.a.a.b.b.a.f(2, this.Lmp);
            }
            if (this.dNI != null) {
                nh += g.a.a.b.b.a.f(3, this.dNI);
            }
            if (this.url != null) {
                nh += g.a.a.b.b.a.f(4, this.url);
            }
            if (this.MVs != null) {
                nh += g.a.a.b.b.a.f(5, this.MVs);
            }
            int bu = nh + g.a.a.b.b.a.bu(6, this.scene) + g.a.a.b.b.a.bu(7, this.source);
            if (this.KZR != null) {
                bu += g.a.a.b.b.a.f(8, this.KZR);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(9, this.KXD);
            AppMethodBeat.o(91683);
            return bu2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(91683);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            dtf dtf = (dtf) objArr[1];
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
                        dtf.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(91683);
                    return 0;
                case 2:
                    dtf.Lmp = aVar3.UbS.readString();
                    AppMethodBeat.o(91683);
                    return 0;
                case 3:
                    dtf.dNI = aVar3.UbS.readString();
                    AppMethodBeat.o(91683);
                    return 0;
                case 4:
                    dtf.url = aVar3.UbS.readString();
                    AppMethodBeat.o(91683);
                    return 0;
                case 5:
                    dtf.MVs = aVar3.UbS.readString();
                    AppMethodBeat.o(91683);
                    return 0;
                case 6:
                    dtf.scene = aVar3.UbS.zi();
                    AppMethodBeat.o(91683);
                    return 0;
                case 7:
                    dtf.source = aVar3.UbS.zi();
                    AppMethodBeat.o(91683);
                    return 0;
                case 8:
                    dtf.KZR = aVar3.UbS.readString();
                    AppMethodBeat.o(91683);
                    return 0;
                case 9:
                    dtf.KXD = aVar3.UbS.zi();
                    AppMethodBeat.o(91683);
                    return 0;
                default:
                    AppMethodBeat.o(91683);
                    return -1;
            }
        } else {
            AppMethodBeat.o(91683);
            return -1;
        }
    }
}
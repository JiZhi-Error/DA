package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.c.a;
import java.util.LinkedList;

public final class cea extends dop {
    public int LEg;
    public String MjD;
    public String MjE;
    public int MjF;
    public String MjG;
    public String MjH;
    public String dNI;
    public String packageName;
    public int qwp;
    public int scene;
    public String url;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(123602);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.dNI != null) {
                aVar.e(2, this.dNI);
            }
            if (this.MjD != null) {
                aVar.e(3, this.MjD);
            }
            aVar.aM(4, this.scene);
            if (this.url != null) {
                aVar.e(5, this.url);
            }
            if (this.MjE != null) {
                aVar.e(6, this.MjE);
            }
            aVar.aM(7, this.qwp);
            aVar.aM(8, this.LEg);
            aVar.aM(9, this.MjF);
            if (this.MjG != null) {
                aVar.e(10, this.MjG);
            }
            if (this.packageName != null) {
                aVar.e(11, this.packageName);
            }
            if (this.MjH != null) {
                aVar.e(12, this.MjH);
            }
            AppMethodBeat.o(123602);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0;
            if (this.dNI != null) {
                nh += g.a.a.b.b.a.f(2, this.dNI);
            }
            if (this.MjD != null) {
                nh += g.a.a.b.b.a.f(3, this.MjD);
            }
            int bu = nh + g.a.a.b.b.a.bu(4, this.scene);
            if (this.url != null) {
                bu += g.a.a.b.b.a.f(5, this.url);
            }
            if (this.MjE != null) {
                bu += g.a.a.b.b.a.f(6, this.MjE);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(7, this.qwp) + g.a.a.b.b.a.bu(8, this.LEg) + g.a.a.b.b.a.bu(9, this.MjF);
            if (this.MjG != null) {
                bu2 += g.a.a.b.b.a.f(10, this.MjG);
            }
            if (this.packageName != null) {
                bu2 += g.a.a.b.b.a.f(11, this.packageName);
            }
            if (this.MjH != null) {
                bu2 += g.a.a.b.b.a.f(12, this.MjH);
            }
            AppMethodBeat.o(123602);
            return bu2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(123602);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            cea cea = (cea) objArr[1];
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
                        cea.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(123602);
                    return 0;
                case 2:
                    cea.dNI = aVar3.UbS.readString();
                    AppMethodBeat.o(123602);
                    return 0;
                case 3:
                    cea.MjD = aVar3.UbS.readString();
                    AppMethodBeat.o(123602);
                    return 0;
                case 4:
                    cea.scene = aVar3.UbS.zi();
                    AppMethodBeat.o(123602);
                    return 0;
                case 5:
                    cea.url = aVar3.UbS.readString();
                    AppMethodBeat.o(123602);
                    return 0;
                case 6:
                    cea.MjE = aVar3.UbS.readString();
                    AppMethodBeat.o(123602);
                    return 0;
                case 7:
                    cea.qwp = aVar3.UbS.zi();
                    AppMethodBeat.o(123602);
                    return 0;
                case 8:
                    cea.LEg = aVar3.UbS.zi();
                    AppMethodBeat.o(123602);
                    return 0;
                case 9:
                    cea.MjF = aVar3.UbS.zi();
                    AppMethodBeat.o(123602);
                    return 0;
                case 10:
                    cea.MjG = aVar3.UbS.readString();
                    AppMethodBeat.o(123602);
                    return 0;
                case 11:
                    cea.packageName = aVar3.UbS.readString();
                    AppMethodBeat.o(123602);
                    return 0;
                case 12:
                    cea.MjH = aVar3.UbS.readString();
                    AppMethodBeat.o(123602);
                    return 0;
                default:
                    AppMethodBeat.o(123602);
                    return -1;
            }
        } else {
            AppMethodBeat.o(123602);
            return -1;
        }
    }
}

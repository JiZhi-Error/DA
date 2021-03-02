package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.c.a;
import java.util.LinkedList;

public final class cef extends dop {
    public int HTO;
    public LinkedList<String> MjM = new LinkedList<>();
    public String MjN;
    public LinkedList<String> MjO = new LinkedList<>();
    public String Mju;
    public String Mjv;
    public String Mjy;
    public String dNI;
    public String dmc;
    public int scene;
    public String signature;
    public String url;

    public cef() {
        AppMethodBeat.i(82438);
        AppMethodBeat.o(82438);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(82439);
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
            aVar.e(4, 1, this.MjM);
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
            aVar.aM(9, this.scene);
            if (this.MjN != null) {
                aVar.e(10, this.MjN);
            }
            aVar.e(11, 1, this.MjO);
            if (this.Mjy != null) {
                aVar.e(12, this.Mjy);
            }
            aVar.aM(13, this.HTO);
            AppMethodBeat.o(82439);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0;
            if (this.url != null) {
                nh += g.a.a.b.b.a.f(2, this.url);
            }
            if (this.dNI != null) {
                nh += g.a.a.b.b.a.f(3, this.dNI);
            }
            int c2 = nh + g.a.a.a.c(4, 1, this.MjM);
            if (this.dmc != null) {
                c2 += g.a.a.b.b.a.f(5, this.dmc);
            }
            if (this.Mju != null) {
                c2 += g.a.a.b.b.a.f(6, this.Mju);
            }
            if (this.signature != null) {
                c2 += g.a.a.b.b.a.f(7, this.signature);
            }
            if (this.Mjv != null) {
                c2 += g.a.a.b.b.a.f(8, this.Mjv);
            }
            int bu = c2 + g.a.a.b.b.a.bu(9, this.scene);
            if (this.MjN != null) {
                bu += g.a.a.b.b.a.f(10, this.MjN);
            }
            int c3 = bu + g.a.a.a.c(11, 1, this.MjO);
            if (this.Mjy != null) {
                c3 += g.a.a.b.b.a.f(12, this.Mjy);
            }
            int bu2 = c3 + g.a.a.b.b.a.bu(13, this.HTO);
            AppMethodBeat.o(82439);
            return bu2;
        } else if (i2 == 2) {
            this.MjM.clear();
            this.MjO.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(82439);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            cef cef = (cef) objArr[1];
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
                        cef.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(82439);
                    return 0;
                case 2:
                    cef.url = aVar3.UbS.readString();
                    AppMethodBeat.o(82439);
                    return 0;
                case 3:
                    cef.dNI = aVar3.UbS.readString();
                    AppMethodBeat.o(82439);
                    return 0;
                case 4:
                    cef.MjM.add(aVar3.UbS.readString());
                    AppMethodBeat.o(82439);
                    return 0;
                case 5:
                    cef.dmc = aVar3.UbS.readString();
                    AppMethodBeat.o(82439);
                    return 0;
                case 6:
                    cef.Mju = aVar3.UbS.readString();
                    AppMethodBeat.o(82439);
                    return 0;
                case 7:
                    cef.signature = aVar3.UbS.readString();
                    AppMethodBeat.o(82439);
                    return 0;
                case 8:
                    cef.Mjv = aVar3.UbS.readString();
                    AppMethodBeat.o(82439);
                    return 0;
                case 9:
                    cef.scene = aVar3.UbS.zi();
                    AppMethodBeat.o(82439);
                    return 0;
                case 10:
                    cef.MjN = aVar3.UbS.readString();
                    AppMethodBeat.o(82439);
                    return 0;
                case 11:
                    cef.MjO.add(aVar3.UbS.readString());
                    AppMethodBeat.o(82439);
                    return 0;
                case 12:
                    cef.Mjy = aVar3.UbS.readString();
                    AppMethodBeat.o(82439);
                    return 0;
                case 13:
                    cef.HTO = aVar3.UbS.zi();
                    AppMethodBeat.o(82439);
                    return 0;
                default:
                    AppMethodBeat.o(82439);
                    return -1;
            }
        } else {
            AppMethodBeat.o(82439);
            return -1;
        }
    }
}

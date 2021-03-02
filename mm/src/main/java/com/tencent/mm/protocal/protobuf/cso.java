package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class cso extends a {
    public String Djf;
    public String MxA;
    public String MxB;
    public String MxC;
    public String MxD;
    public String Mxy;
    public String Mxz;
    public String appId;
    public String dSF;
    public css jfy;
    public String lDR;
    public String lDS;
    public int musicType;
    public String name;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(208709);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.jfy != null) {
                aVar.ni(1, this.jfy.computeSize());
                this.jfy.writeFields(aVar);
            }
            aVar.aM(2, this.musicType);
            if (this.Djf != null) {
                aVar.e(3, this.Djf);
            }
            if (this.name != null) {
                aVar.e(4, this.name);
            }
            if (this.lDR != null) {
                aVar.e(5, this.lDR);
            }
            if (this.lDS != null) {
                aVar.e(6, this.lDS);
            }
            if (this.Mxy != null) {
                aVar.e(7, this.Mxy);
            }
            if (this.Mxz != null) {
                aVar.e(8, this.Mxz);
            }
            if (this.dSF != null) {
                aVar.e(9, this.dSF);
            }
            if (this.MxA != null) {
                aVar.e(10, this.MxA);
            }
            if (this.MxB != null) {
                aVar.e(11, this.MxB);
            }
            if (this.MxC != null) {
                aVar.e(12, this.MxC);
            }
            if (this.appId != null) {
                aVar.e(13, this.appId);
            }
            if (this.MxD != null) {
                aVar.e(14, this.MxD);
            }
            AppMethodBeat.o(208709);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.jfy != null ? g.a.a.a.nh(1, this.jfy.computeSize()) + 0 : 0) + g.a.a.b.b.a.bu(2, this.musicType);
            if (this.Djf != null) {
                nh += g.a.a.b.b.a.f(3, this.Djf);
            }
            if (this.name != null) {
                nh += g.a.a.b.b.a.f(4, this.name);
            }
            if (this.lDR != null) {
                nh += g.a.a.b.b.a.f(5, this.lDR);
            }
            if (this.lDS != null) {
                nh += g.a.a.b.b.a.f(6, this.lDS);
            }
            if (this.Mxy != null) {
                nh += g.a.a.b.b.a.f(7, this.Mxy);
            }
            if (this.Mxz != null) {
                nh += g.a.a.b.b.a.f(8, this.Mxz);
            }
            if (this.dSF != null) {
                nh += g.a.a.b.b.a.f(9, this.dSF);
            }
            if (this.MxA != null) {
                nh += g.a.a.b.b.a.f(10, this.MxA);
            }
            if (this.MxB != null) {
                nh += g.a.a.b.b.a.f(11, this.MxB);
            }
            if (this.MxC != null) {
                nh += g.a.a.b.b.a.f(12, this.MxC);
            }
            if (this.appId != null) {
                nh += g.a.a.b.b.a.f(13, this.appId);
            }
            if (this.MxD != null) {
                nh += g.a.a.b.b.a.f(14, this.MxD);
            }
            AppMethodBeat.o(208709);
            return nh;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(208709);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            cso cso = (cso) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        css css = new css();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = css.populateBuilderWithField(aVar4, css, a.getNextFieldNumber(aVar4))) {
                        }
                        cso.jfy = css;
                    }
                    AppMethodBeat.o(208709);
                    return 0;
                case 2:
                    cso.musicType = aVar3.UbS.zi();
                    AppMethodBeat.o(208709);
                    return 0;
                case 3:
                    cso.Djf = aVar3.UbS.readString();
                    AppMethodBeat.o(208709);
                    return 0;
                case 4:
                    cso.name = aVar3.UbS.readString();
                    AppMethodBeat.o(208709);
                    return 0;
                case 5:
                    cso.lDR = aVar3.UbS.readString();
                    AppMethodBeat.o(208709);
                    return 0;
                case 6:
                    cso.lDS = aVar3.UbS.readString();
                    AppMethodBeat.o(208709);
                    return 0;
                case 7:
                    cso.Mxy = aVar3.UbS.readString();
                    AppMethodBeat.o(208709);
                    return 0;
                case 8:
                    cso.Mxz = aVar3.UbS.readString();
                    AppMethodBeat.o(208709);
                    return 0;
                case 9:
                    cso.dSF = aVar3.UbS.readString();
                    AppMethodBeat.o(208709);
                    return 0;
                case 10:
                    cso.MxA = aVar3.UbS.readString();
                    AppMethodBeat.o(208709);
                    return 0;
                case 11:
                    cso.MxB = aVar3.UbS.readString();
                    AppMethodBeat.o(208709);
                    return 0;
                case 12:
                    cso.MxC = aVar3.UbS.readString();
                    AppMethodBeat.o(208709);
                    return 0;
                case 13:
                    cso.appId = aVar3.UbS.readString();
                    AppMethodBeat.o(208709);
                    return 0;
                case 14:
                    cso.MxD = aVar3.UbS.readString();
                    AppMethodBeat.o(208709);
                    return 0;
                default:
                    AppMethodBeat.o(208709);
                    return -1;
            }
        } else {
            AppMethodBeat.o(208709);
            return -1;
        }
    }
}

package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import g.a.a.b;
import java.util.LinkedList;

public final class ec extends a {
    public String IconUrl;
    public String Title;
    public int oUv;
    public String xIy;
    public String xJd;
    public String xMX;
    public String xNA;
    public ea xNB;
    public eb xNC;
    public boolean xND;
    public int xNE;
    public String xNv;
    public String xNw;
    public String xNx;
    public String xNy;
    public String xNz;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(256653);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.xMX == null) {
                b bVar = new b("Not all required fields were included: Key");
                AppMethodBeat.o(256653);
                throw bVar;
            }
            if (this.xMX != null) {
                aVar.e(1, this.xMX);
            }
            if (this.Title != null) {
                aVar.e(2, this.Title);
            }
            if (this.xNv != null) {
                aVar.e(11, this.xNv);
            }
            if (this.xNw != null) {
                aVar.e(12, this.xNw);
            }
            if (this.xNx != null) {
                aVar.e(13, this.xNx);
            }
            if (this.xNy != null) {
                aVar.e(14, this.xNy);
            }
            if (this.IconUrl != null) {
                aVar.e(3, this.IconUrl);
            }
            if (this.xNz != null) {
                aVar.e(4, this.xNz);
            }
            if (this.xJd != null) {
                aVar.e(9, this.xJd);
            }
            if (this.xNA != null) {
                aVar.e(10, this.xNA);
            }
            aVar.aM(5, this.oUv);
            if (this.xIy != null) {
                aVar.e(6, this.xIy);
            }
            if (this.xNB != null) {
                aVar.ni(7, this.xNB.computeSize());
                this.xNB.writeFields(aVar);
            }
            if (this.xNC != null) {
                aVar.ni(8, this.xNC.computeSize());
                this.xNC.writeFields(aVar);
            }
            aVar.cc(15, this.xND);
            aVar.aM(16, this.xNE);
            AppMethodBeat.o(256653);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.xMX != null ? g.a.a.b.b.a.f(1, this.xMX) + 0 : 0;
            if (this.Title != null) {
                f2 += g.a.a.b.b.a.f(2, this.Title);
            }
            if (this.xNv != null) {
                f2 += g.a.a.b.b.a.f(11, this.xNv);
            }
            if (this.xNw != null) {
                f2 += g.a.a.b.b.a.f(12, this.xNw);
            }
            if (this.xNx != null) {
                f2 += g.a.a.b.b.a.f(13, this.xNx);
            }
            if (this.xNy != null) {
                f2 += g.a.a.b.b.a.f(14, this.xNy);
            }
            if (this.IconUrl != null) {
                f2 += g.a.a.b.b.a.f(3, this.IconUrl);
            }
            if (this.xNz != null) {
                f2 += g.a.a.b.b.a.f(4, this.xNz);
            }
            if (this.xJd != null) {
                f2 += g.a.a.b.b.a.f(9, this.xJd);
            }
            if (this.xNA != null) {
                f2 += g.a.a.b.b.a.f(10, this.xNA);
            }
            int bu = f2 + g.a.a.b.b.a.bu(5, this.oUv);
            if (this.xIy != null) {
                bu += g.a.a.b.b.a.f(6, this.xIy);
            }
            if (this.xNB != null) {
                bu += g.a.a.a.nh(7, this.xNB.computeSize());
            }
            if (this.xNC != null) {
                bu += g.a.a.a.nh(8, this.xNC.computeSize());
            }
            int fS = bu + g.a.a.b.b.a.fS(15) + 1 + g.a.a.b.b.a.bu(16, this.xNE);
            AppMethodBeat.o(256653);
            return fS;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.xMX == null) {
                b bVar2 = new b("Not all required fields were included: Key");
                AppMethodBeat.o(256653);
                throw bVar2;
            }
            AppMethodBeat.o(256653);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            ec ecVar = (ec) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    ecVar.xMX = aVar3.UbS.readString();
                    AppMethodBeat.o(256653);
                    return 0;
                case 2:
                    ecVar.Title = aVar3.UbS.readString();
                    AppMethodBeat.o(256653);
                    return 0;
                case 3:
                    ecVar.IconUrl = aVar3.UbS.readString();
                    AppMethodBeat.o(256653);
                    return 0;
                case 4:
                    ecVar.xNz = aVar3.UbS.readString();
                    AppMethodBeat.o(256653);
                    return 0;
                case 5:
                    ecVar.oUv = aVar3.UbS.zi();
                    AppMethodBeat.o(256653);
                    return 0;
                case 6:
                    ecVar.xIy = aVar3.UbS.readString();
                    AppMethodBeat.o(256653);
                    return 0;
                case 7:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        ea eaVar = new ea();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = eaVar.populateBuilderWithField(aVar4, eaVar, a.getNextFieldNumber(aVar4))) {
                        }
                        ecVar.xNB = eaVar;
                    }
                    AppMethodBeat.o(256653);
                    return 0;
                case 8:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        eb ebVar = new eb();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = ebVar.populateBuilderWithField(aVar5, ebVar, a.getNextFieldNumber(aVar5))) {
                        }
                        ecVar.xNC = ebVar;
                    }
                    AppMethodBeat.o(256653);
                    return 0;
                case 9:
                    ecVar.xJd = aVar3.UbS.readString();
                    AppMethodBeat.o(256653);
                    return 0;
                case 10:
                    ecVar.xNA = aVar3.UbS.readString();
                    AppMethodBeat.o(256653);
                    return 0;
                case 11:
                    ecVar.xNv = aVar3.UbS.readString();
                    AppMethodBeat.o(256653);
                    return 0;
                case 12:
                    ecVar.xNw = aVar3.UbS.readString();
                    AppMethodBeat.o(256653);
                    return 0;
                case 13:
                    ecVar.xNx = aVar3.UbS.readString();
                    AppMethodBeat.o(256653);
                    return 0;
                case 14:
                    ecVar.xNy = aVar3.UbS.readString();
                    AppMethodBeat.o(256653);
                    return 0;
                case 15:
                    ecVar.xND = aVar3.UbS.yZ();
                    AppMethodBeat.o(256653);
                    return 0;
                case 16:
                    ecVar.xNE = aVar3.UbS.zi();
                    AppMethodBeat.o(256653);
                    return 0;
                default:
                    AppMethodBeat.o(256653);
                    return -1;
            }
        } else {
            AppMethodBeat.o(256653);
            return -1;
        }
    }
}

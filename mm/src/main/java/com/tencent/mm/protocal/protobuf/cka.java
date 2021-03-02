package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import g.a.a.b;
import java.util.LinkedList;

public final class cka extends a {
    public String Cfy;
    public ain Cgj;
    public erc Lce;
    public float dTj;
    public String kHV;
    public float latitude;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(140927);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.Cfy == null) {
                b bVar = new b("Not all required fields were included: cityName");
                AppMethodBeat.o(140927);
                throw bVar;
            } else if (this.kHV == null) {
                b bVar2 = new b("Not all required fields were included: poiName");
                AppMethodBeat.o(140927);
                throw bVar2;
            } else if (this.Lce == null) {
                b bVar3 = new b("Not all required fields were included: matrix");
                AppMethodBeat.o(140927);
                throw bVar3;
            } else {
                if (this.Cfy != null) {
                    aVar.e(1, this.Cfy);
                }
                if (this.kHV != null) {
                    aVar.e(2, this.kHV);
                }
                if (this.Lce != null) {
                    aVar.ni(4, this.Lce.computeSize());
                    this.Lce.writeFields(aVar);
                }
                aVar.E(5, this.dTj);
                aVar.E(6, this.latitude);
                if (this.Cgj != null) {
                    aVar.ni(7, this.Cgj.computeSize());
                    this.Cgj.writeFields(aVar);
                }
                AppMethodBeat.o(140927);
                return 0;
            }
        } else if (i2 == 1) {
            int f2 = this.Cfy != null ? g.a.a.b.b.a.f(1, this.Cfy) + 0 : 0;
            if (this.kHV != null) {
                f2 += g.a.a.b.b.a.f(2, this.kHV);
            }
            if (this.Lce != null) {
                f2 += g.a.a.a.nh(4, this.Lce.computeSize());
            }
            int fS = f2 + g.a.a.b.b.a.fS(5) + 4 + g.a.a.b.b.a.fS(6) + 4;
            if (this.Cgj != null) {
                fS += g.a.a.a.nh(7, this.Cgj.computeSize());
            }
            AppMethodBeat.o(140927);
            return fS;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.Cfy == null) {
                b bVar4 = new b("Not all required fields were included: cityName");
                AppMethodBeat.o(140927);
                throw bVar4;
            } else if (this.kHV == null) {
                b bVar5 = new b("Not all required fields were included: poiName");
                AppMethodBeat.o(140927);
                throw bVar5;
            } else if (this.Lce == null) {
                b bVar6 = new b("Not all required fields were included: matrix");
                AppMethodBeat.o(140927);
                throw bVar6;
            } else {
                AppMethodBeat.o(140927);
                return 0;
            }
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            cka cka = (cka) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    cka.Cfy = aVar3.UbS.readString();
                    AppMethodBeat.o(140927);
                    return 0;
                case 2:
                    cka.kHV = aVar3.UbS.readString();
                    AppMethodBeat.o(140927);
                    return 0;
                case 3:
                default:
                    AppMethodBeat.o(140927);
                    return -1;
                case 4:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        erc erc = new erc();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = erc.populateBuilderWithField(aVar4, erc, a.getNextFieldNumber(aVar4))) {
                        }
                        cka.Lce = erc;
                    }
                    AppMethodBeat.o(140927);
                    return 0;
                case 5:
                    cka.dTj = Float.intBitsToFloat(aVar3.UbS.zm());
                    AppMethodBeat.o(140927);
                    return 0;
                case 6:
                    cka.latitude = Float.intBitsToFloat(aVar3.UbS.zm());
                    AppMethodBeat.o(140927);
                    return 0;
                case 7:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        ain ain = new ain();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = ain.populateBuilderWithField(aVar5, ain, a.getNextFieldNumber(aVar5))) {
                        }
                        cka.Cgj = ain;
                    }
                    AppMethodBeat.o(140927);
                    return 0;
            }
        } else {
            AppMethodBeat.o(140927);
            return -1;
        }
    }
}

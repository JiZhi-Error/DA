package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import g.a.a.b;
import java.util.LinkedList;

public final class ejf extends a {
    public long GGA;
    public long GGz;
    public long GJB;
    public int Gze;
    public int Gzu;
    public int Gzv;
    public float Gzw;
    public aeo NiP;
    public ekn NiQ;
    public long endTimeMs;
    public String path;
    public long startTimeMs;
    public int type;
    public float volume;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(201302);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.path == null) {
                b bVar = new b("Not all required fields were included: path");
                AppMethodBeat.o(201302);
                throw bVar;
            }
            if (this.path != null) {
                aVar.e(1, this.path);
            }
            aVar.aM(2, this.type);
            aVar.bb(3, this.startTimeMs);
            aVar.bb(4, this.endTimeMs);
            aVar.bb(5, this.GGz);
            aVar.bb(6, this.GGA);
            aVar.bb(7, this.GJB);
            aVar.aM(8, this.Gzu);
            aVar.aM(9, this.Gzv);
            aVar.E(10, this.Gzw);
            aVar.E(11, this.volume);
            if (this.NiP != null) {
                aVar.ni(12, this.NiP.computeSize());
                this.NiP.writeFields(aVar);
            }
            aVar.aM(13, this.Gze);
            if (this.NiQ != null) {
                aVar.ni(14, this.NiQ.computeSize());
                this.NiQ.writeFields(aVar);
            }
            AppMethodBeat.o(201302);
            return 0;
        } else if (i2 == 1) {
            int f2 = (this.path != null ? g.a.a.b.b.a.f(1, this.path) + 0 : 0) + g.a.a.b.b.a.bu(2, this.type) + g.a.a.b.b.a.r(3, this.startTimeMs) + g.a.a.b.b.a.r(4, this.endTimeMs) + g.a.a.b.b.a.r(5, this.GGz) + g.a.a.b.b.a.r(6, this.GGA) + g.a.a.b.b.a.r(7, this.GJB) + g.a.a.b.b.a.bu(8, this.Gzu) + g.a.a.b.b.a.bu(9, this.Gzv) + g.a.a.b.b.a.fS(10) + 4 + g.a.a.b.b.a.fS(11) + 4;
            if (this.NiP != null) {
                f2 += g.a.a.a.nh(12, this.NiP.computeSize());
            }
            int bu = f2 + g.a.a.b.b.a.bu(13, this.Gze);
            if (this.NiQ != null) {
                bu += g.a.a.a.nh(14, this.NiQ.computeSize());
            }
            AppMethodBeat.o(201302);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.path == null) {
                b bVar2 = new b("Not all required fields were included: path");
                AppMethodBeat.o(201302);
                throw bVar2;
            }
            AppMethodBeat.o(201302);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            ejf ejf = (ejf) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    ejf.path = aVar3.UbS.readString();
                    AppMethodBeat.o(201302);
                    return 0;
                case 2:
                    ejf.type = aVar3.UbS.zi();
                    AppMethodBeat.o(201302);
                    return 0;
                case 3:
                    ejf.startTimeMs = aVar3.UbS.zl();
                    AppMethodBeat.o(201302);
                    return 0;
                case 4:
                    ejf.endTimeMs = aVar3.UbS.zl();
                    AppMethodBeat.o(201302);
                    return 0;
                case 5:
                    ejf.GGz = aVar3.UbS.zl();
                    AppMethodBeat.o(201302);
                    return 0;
                case 6:
                    ejf.GGA = aVar3.UbS.zl();
                    AppMethodBeat.o(201302);
                    return 0;
                case 7:
                    ejf.GJB = aVar3.UbS.zl();
                    AppMethodBeat.o(201302);
                    return 0;
                case 8:
                    ejf.Gzu = aVar3.UbS.zi();
                    AppMethodBeat.o(201302);
                    return 0;
                case 9:
                    ejf.Gzv = aVar3.UbS.zi();
                    AppMethodBeat.o(201302);
                    return 0;
                case 10:
                    ejf.Gzw = Float.intBitsToFloat(aVar3.UbS.zm());
                    AppMethodBeat.o(201302);
                    return 0;
                case 11:
                    ejf.volume = Float.intBitsToFloat(aVar3.UbS.zm());
                    AppMethodBeat.o(201302);
                    return 0;
                case 12:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        aeo aeo = new aeo();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = aeo.populateBuilderWithField(aVar4, aeo, a.getNextFieldNumber(aVar4))) {
                        }
                        ejf.NiP = aeo;
                    }
                    AppMethodBeat.o(201302);
                    return 0;
                case 13:
                    ejf.Gze = aVar3.UbS.zi();
                    AppMethodBeat.o(201302);
                    return 0;
                case 14:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        ekn ekn = new ekn();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = ekn.populateBuilderWithField(aVar5, ekn, a.getNextFieldNumber(aVar5))) {
                        }
                        ejf.NiQ = ekn;
                    }
                    AppMethodBeat.o(201302);
                    return 0;
                default:
                    AppMethodBeat.o(201302);
                    return -1;
            }
        } else {
            AppMethodBeat.o(201302);
            return -1;
        }
    }
}

package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class cjk extends a {
    public azk MoJ;
    public String MoK;
    public LinkedList<cjl> mediaList = new LinkedList<>();
    public int soundTrackType;
    public String vMV;
    public String vMX;
    public boolean wCu;
    public boolean wCv;

    public cjk() {
        AppMethodBeat.i(169078);
        AppMethodBeat.o(169078);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(169079);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.e(1, 8, this.mediaList);
            if (this.MoJ != null) {
                aVar.ni(2, this.MoJ.computeSize());
                this.MoJ.writeFields(aVar);
            }
            if (this.vMX != null) {
                aVar.e(3, this.vMX);
            }
            if (this.vMV != null) {
                aVar.e(4, this.vMV);
            }
            if (this.MoK != null) {
                aVar.e(5, this.MoK);
            }
            aVar.cc(6, this.wCu);
            aVar.cc(7, this.wCv);
            aVar.aM(8, this.soundTrackType);
            AppMethodBeat.o(169079);
            return 0;
        } else if (i2 == 1) {
            int c2 = g.a.a.a.c(1, 8, this.mediaList) + 0;
            if (this.MoJ != null) {
                c2 += g.a.a.a.nh(2, this.MoJ.computeSize());
            }
            if (this.vMX != null) {
                c2 += g.a.a.b.b.a.f(3, this.vMX);
            }
            if (this.vMV != null) {
                c2 += g.a.a.b.b.a.f(4, this.vMV);
            }
            if (this.MoK != null) {
                c2 += g.a.a.b.b.a.f(5, this.MoK);
            }
            int fS = c2 + g.a.a.b.b.a.fS(6) + 1 + g.a.a.b.b.a.fS(7) + 1 + g.a.a.b.b.a.bu(8, this.soundTrackType);
            AppMethodBeat.o(169079);
            return fS;
        } else if (i2 == 2) {
            this.mediaList.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(169079);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            cjk cjk = (cjk) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        cjl cjl = new cjl();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = cjl.populateBuilderWithField(aVar4, cjl, a.getNextFieldNumber(aVar4))) {
                        }
                        cjk.mediaList.add(cjl);
                    }
                    AppMethodBeat.o(169079);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        azk azk = new azk();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = azk.populateBuilderWithField(aVar5, azk, a.getNextFieldNumber(aVar5))) {
                        }
                        cjk.MoJ = azk;
                    }
                    AppMethodBeat.o(169079);
                    return 0;
                case 3:
                    cjk.vMX = aVar3.UbS.readString();
                    AppMethodBeat.o(169079);
                    return 0;
                case 4:
                    cjk.vMV = aVar3.UbS.readString();
                    AppMethodBeat.o(169079);
                    return 0;
                case 5:
                    cjk.MoK = aVar3.UbS.readString();
                    AppMethodBeat.o(169079);
                    return 0;
                case 6:
                    cjk.wCu = aVar3.UbS.yZ();
                    AppMethodBeat.o(169079);
                    return 0;
                case 7:
                    cjk.wCv = aVar3.UbS.yZ();
                    AppMethodBeat.o(169079);
                    return 0;
                case 8:
                    cjk.soundTrackType = aVar3.UbS.zi();
                    AppMethodBeat.o(169079);
                    return 0;
                default:
                    AppMethodBeat.o(169079);
                    return -1;
            }
        } else {
            AppMethodBeat.o(169079);
            return -1;
        }
    }
}

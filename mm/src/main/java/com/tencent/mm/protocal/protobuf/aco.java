package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class aco extends a {
    public dlh Lnm;
    public float Lnn;
    public LinkedList<Integer> Lno = new LinkedList<>();
    public boolean Lnp;
    public int Lnq;
    public boolean Lnr;
    public int audioBitrate;
    public int audioChannelCount;
    public int audioSampleRate;
    public int fps;
    public int iTg;
    public int iiH;
    public String rpE;
    public int targetHeight;
    public int targetWidth;
    public int videoBitrate;
    public int xlg;
    public int xlh;

    public aco() {
        AppMethodBeat.i(201290);
        AppMethodBeat.o(201290);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(201291);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.rpE != null) {
                aVar.e(1, this.rpE);
            }
            aVar.aM(4, this.xlg);
            aVar.aM(5, this.xlh);
            if (this.Lnm != null) {
                aVar.ni(6, this.Lnm.computeSize());
                this.Lnm.writeFields(aVar);
            }
            aVar.E(7, this.Lnn);
            aVar.aM(8, this.targetWidth);
            aVar.aM(9, this.targetHeight);
            aVar.aM(10, this.videoBitrate);
            aVar.aM(11, this.fps);
            aVar.aM(12, this.iiH);
            aVar.aM(13, this.audioBitrate);
            aVar.aM(14, this.audioSampleRate);
            aVar.aM(15, this.audioChannelCount);
            aVar.e(16, 2, this.Lno);
            aVar.aM(17, this.iTg);
            aVar.cc(18, this.Lnp);
            aVar.aM(19, this.Lnq);
            aVar.cc(20, this.Lnr);
            AppMethodBeat.o(201291);
            return 0;
        } else if (i2 == 1) {
            int f2 = (this.rpE != null ? g.a.a.b.b.a.f(1, this.rpE) + 0 : 0) + g.a.a.b.b.a.bu(4, this.xlg) + g.a.a.b.b.a.bu(5, this.xlh);
            if (this.Lnm != null) {
                f2 += g.a.a.a.nh(6, this.Lnm.computeSize());
            }
            int fS = f2 + g.a.a.b.b.a.fS(7) + 4 + g.a.a.b.b.a.bu(8, this.targetWidth) + g.a.a.b.b.a.bu(9, this.targetHeight) + g.a.a.b.b.a.bu(10, this.videoBitrate) + g.a.a.b.b.a.bu(11, this.fps) + g.a.a.b.b.a.bu(12, this.iiH) + g.a.a.b.b.a.bu(13, this.audioBitrate) + g.a.a.b.b.a.bu(14, this.audioSampleRate) + g.a.a.b.b.a.bu(15, this.audioChannelCount) + g.a.a.a.c(16, 2, this.Lno) + g.a.a.b.b.a.bu(17, this.iTg) + g.a.a.b.b.a.fS(18) + 1 + g.a.a.b.b.a.bu(19, this.Lnq) + g.a.a.b.b.a.fS(20) + 1;
            AppMethodBeat.o(201291);
            return fS;
        } else if (i2 == 2) {
            this.Lno.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(201291);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            aco aco = (aco) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    aco.rpE = aVar3.UbS.readString();
                    AppMethodBeat.o(201291);
                    return 0;
                case 2:
                case 3:
                default:
                    AppMethodBeat.o(201291);
                    return -1;
                case 4:
                    aco.xlg = aVar3.UbS.zi();
                    AppMethodBeat.o(201291);
                    return 0;
                case 5:
                    aco.xlh = aVar3.UbS.zi();
                    AppMethodBeat.o(201291);
                    return 0;
                case 6:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        dlh dlh = new dlh();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = dlh.populateBuilderWithField(aVar4, dlh, a.getNextFieldNumber(aVar4))) {
                        }
                        aco.Lnm = dlh;
                    }
                    AppMethodBeat.o(201291);
                    return 0;
                case 7:
                    aco.Lnn = Float.intBitsToFloat(aVar3.UbS.zm());
                    AppMethodBeat.o(201291);
                    return 0;
                case 8:
                    aco.targetWidth = aVar3.UbS.zi();
                    AppMethodBeat.o(201291);
                    return 0;
                case 9:
                    aco.targetHeight = aVar3.UbS.zi();
                    AppMethodBeat.o(201291);
                    return 0;
                case 10:
                    aco.videoBitrate = aVar3.UbS.zi();
                    AppMethodBeat.o(201291);
                    return 0;
                case 11:
                    aco.fps = aVar3.UbS.zi();
                    AppMethodBeat.o(201291);
                    return 0;
                case 12:
                    aco.iiH = aVar3.UbS.zi();
                    AppMethodBeat.o(201291);
                    return 0;
                case 13:
                    aco.audioBitrate = aVar3.UbS.zi();
                    AppMethodBeat.o(201291);
                    return 0;
                case 14:
                    aco.audioSampleRate = aVar3.UbS.zi();
                    AppMethodBeat.o(201291);
                    return 0;
                case 15:
                    aco.audioChannelCount = aVar3.UbS.zi();
                    AppMethodBeat.o(201291);
                    return 0;
                case 16:
                    aco.Lno.add(Integer.valueOf(aVar3.UbS.zi()));
                    AppMethodBeat.o(201291);
                    return 0;
                case 17:
                    aco.iTg = aVar3.UbS.zi();
                    AppMethodBeat.o(201291);
                    return 0;
                case 18:
                    aco.Lnp = aVar3.UbS.yZ();
                    AppMethodBeat.o(201291);
                    return 0;
                case 19:
                    aco.Lnq = aVar3.UbS.zi();
                    AppMethodBeat.o(201291);
                    return 0;
                case 20:
                    aco.Lnr = aVar3.UbS.yZ();
                    AppMethodBeat.o(201291);
                    return 0;
            }
        } else {
            AppMethodBeat.o(201291);
            return -1;
        }
    }
}

package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class aio extends a {
    public int BOX;
    public dlg BPU;
    public boolean BPa;
    public LinkedList<jn> Lna = new LinkedList<>();
    public String LrT;
    public int LrU;
    public int LrV;
    public int LrW;
    public int LrX;
    public int LrY;
    public edo LrZ;
    public int Lsa;
    public long Lsb;
    public LinkedList<String> Lsc = new LinkedList<>();
    public b Lsd;
    public int Lse;
    public int Lsf;
    public int Lsg;
    public int Lsh;
    public boolean aXa;
    public long endTime;
    public int idq;
    public String iiv;
    public boolean iqf;
    public String musicUrl;
    public long startTime;
    public String thumbPath;
    public long timeStamp;
    public String videoPath;

    public aio() {
        AppMethodBeat.i(101528);
        AppMethodBeat.o(101528);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(101529);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.videoPath == null) {
                g.a.a.b bVar = new g.a.a.b("Not all required fields were included: videoPath");
                AppMethodBeat.o(101529);
                throw bVar;
            } else if (this.thumbPath == null) {
                g.a.a.b bVar2 = new g.a.a.b("Not all required fields were included: thumbPath");
                AppMethodBeat.o(101529);
                throw bVar2;
            } else {
                if (this.videoPath != null) {
                    aVar.e(1, this.videoPath);
                }
                aVar.bb(2, this.startTime);
                aVar.bb(3, this.endTime);
                if (this.LrT != null) {
                    aVar.e(4, this.LrT);
                }
                aVar.aM(5, this.idq);
                if (this.thumbPath != null) {
                    aVar.e(6, this.thumbPath);
                }
                if (this.iiv != null) {
                    aVar.e(7, this.iiv);
                }
                aVar.aM(8, this.BOX);
                if (this.musicUrl != null) {
                    aVar.e(9, this.musicUrl);
                }
                aVar.cc(10, this.aXa);
                aVar.cc(11, this.BPa);
                aVar.aM(12, this.LrU);
                aVar.aM(13, this.LrV);
                aVar.aM(14, this.LrW);
                aVar.aM(15, this.LrX);
                aVar.e(16, 8, this.Lna);
                aVar.bb(17, this.timeStamp);
                aVar.aM(18, this.LrY);
                aVar.cc(19, this.iqf);
                if (this.BPU != null) {
                    aVar.ni(20, this.BPU.computeSize());
                    this.BPU.writeFields(aVar);
                }
                if (this.LrZ != null) {
                    aVar.ni(21, this.LrZ.computeSize());
                    this.LrZ.writeFields(aVar);
                }
                aVar.aM(22, this.Lsa);
                aVar.bb(23, this.Lsb);
                aVar.e(24, 1, this.Lsc);
                if (this.Lsd != null) {
                    aVar.c(25, this.Lsd);
                }
                aVar.aM(26, this.Lse);
                aVar.aM(27, this.Lsf);
                aVar.aM(28, this.Lsg);
                aVar.aM(29, this.Lsh);
                AppMethodBeat.o(101529);
                return 0;
            }
        } else if (i2 == 1) {
            int f2 = (this.videoPath != null ? g.a.a.b.b.a.f(1, this.videoPath) + 0 : 0) + g.a.a.b.b.a.r(2, this.startTime) + g.a.a.b.b.a.r(3, this.endTime);
            if (this.LrT != null) {
                f2 += g.a.a.b.b.a.f(4, this.LrT);
            }
            int bu = f2 + g.a.a.b.b.a.bu(5, this.idq);
            if (this.thumbPath != null) {
                bu += g.a.a.b.b.a.f(6, this.thumbPath);
            }
            if (this.iiv != null) {
                bu += g.a.a.b.b.a.f(7, this.iiv);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(8, this.BOX);
            if (this.musicUrl != null) {
                bu2 += g.a.a.b.b.a.f(9, this.musicUrl);
            }
            int fS = bu2 + g.a.a.b.b.a.fS(10) + 1 + g.a.a.b.b.a.fS(11) + 1 + g.a.a.b.b.a.bu(12, this.LrU) + g.a.a.b.b.a.bu(13, this.LrV) + g.a.a.b.b.a.bu(14, this.LrW) + g.a.a.b.b.a.bu(15, this.LrX) + g.a.a.a.c(16, 8, this.Lna) + g.a.a.b.b.a.r(17, this.timeStamp) + g.a.a.b.b.a.bu(18, this.LrY) + g.a.a.b.b.a.fS(19) + 1;
            if (this.BPU != null) {
                fS += g.a.a.a.nh(20, this.BPU.computeSize());
            }
            if (this.LrZ != null) {
                fS += g.a.a.a.nh(21, this.LrZ.computeSize());
            }
            int bu3 = fS + g.a.a.b.b.a.bu(22, this.Lsa) + g.a.a.b.b.a.r(23, this.Lsb) + g.a.a.a.c(24, 1, this.Lsc);
            if (this.Lsd != null) {
                bu3 += g.a.a.b.b.a.b(25, this.Lsd);
            }
            int bu4 = bu3 + g.a.a.b.b.a.bu(26, this.Lse) + g.a.a.b.b.a.bu(27, this.Lsf) + g.a.a.b.b.a.bu(28, this.Lsg) + g.a.a.b.b.a.bu(29, this.Lsh);
            AppMethodBeat.o(101529);
            return bu4;
        } else if (i2 == 2) {
            this.Lna.clear();
            this.Lsc.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.videoPath == null) {
                g.a.a.b bVar3 = new g.a.a.b("Not all required fields were included: videoPath");
                AppMethodBeat.o(101529);
                throw bVar3;
            } else if (this.thumbPath == null) {
                g.a.a.b bVar4 = new g.a.a.b("Not all required fields were included: thumbPath");
                AppMethodBeat.o(101529);
                throw bVar4;
            } else {
                AppMethodBeat.o(101529);
                return 0;
            }
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            aio aio = (aio) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    aio.videoPath = aVar3.UbS.readString();
                    AppMethodBeat.o(101529);
                    return 0;
                case 2:
                    aio.startTime = aVar3.UbS.zl();
                    AppMethodBeat.o(101529);
                    return 0;
                case 3:
                    aio.endTime = aVar3.UbS.zl();
                    AppMethodBeat.o(101529);
                    return 0;
                case 4:
                    aio.LrT = aVar3.UbS.readString();
                    AppMethodBeat.o(101529);
                    return 0;
                case 5:
                    aio.idq = aVar3.UbS.zi();
                    AppMethodBeat.o(101529);
                    return 0;
                case 6:
                    aio.thumbPath = aVar3.UbS.readString();
                    AppMethodBeat.o(101529);
                    return 0;
                case 7:
                    aio.iiv = aVar3.UbS.readString();
                    AppMethodBeat.o(101529);
                    return 0;
                case 8:
                    aio.BOX = aVar3.UbS.zi();
                    AppMethodBeat.o(101529);
                    return 0;
                case 9:
                    aio.musicUrl = aVar3.UbS.readString();
                    AppMethodBeat.o(101529);
                    return 0;
                case 10:
                    aio.aXa = aVar3.UbS.yZ();
                    AppMethodBeat.o(101529);
                    return 0;
                case 11:
                    aio.BPa = aVar3.UbS.yZ();
                    AppMethodBeat.o(101529);
                    return 0;
                case 12:
                    aio.LrU = aVar3.UbS.zi();
                    AppMethodBeat.o(101529);
                    return 0;
                case 13:
                    aio.LrV = aVar3.UbS.zi();
                    AppMethodBeat.o(101529);
                    return 0;
                case 14:
                    aio.LrW = aVar3.UbS.zi();
                    AppMethodBeat.o(101529);
                    return 0;
                case 15:
                    aio.LrX = aVar3.UbS.zi();
                    AppMethodBeat.o(101529);
                    return 0;
                case 16:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        jn jnVar = new jn();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = jnVar.populateBuilderWithField(aVar4, jnVar, a.getNextFieldNumber(aVar4))) {
                        }
                        aio.Lna.add(jnVar);
                    }
                    AppMethodBeat.o(101529);
                    return 0;
                case 17:
                    aio.timeStamp = aVar3.UbS.zl();
                    AppMethodBeat.o(101529);
                    return 0;
                case 18:
                    aio.LrY = aVar3.UbS.zi();
                    AppMethodBeat.o(101529);
                    return 0;
                case 19:
                    aio.iqf = aVar3.UbS.yZ();
                    AppMethodBeat.o(101529);
                    return 0;
                case 20:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        dlg dlg = new dlg();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = dlg.populateBuilderWithField(aVar5, dlg, a.getNextFieldNumber(aVar5))) {
                        }
                        aio.BPU = dlg;
                    }
                    AppMethodBeat.o(101529);
                    return 0;
                case 21:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        edo edo = new edo();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = edo.populateBuilderWithField(aVar6, edo, a.getNextFieldNumber(aVar6))) {
                        }
                        aio.LrZ = edo;
                    }
                    AppMethodBeat.o(101529);
                    return 0;
                case 22:
                    aio.Lsa = aVar3.UbS.zi();
                    AppMethodBeat.o(101529);
                    return 0;
                case 23:
                    aio.Lsb = aVar3.UbS.zl();
                    AppMethodBeat.o(101529);
                    return 0;
                case 24:
                    aio.Lsc.add(aVar3.UbS.readString());
                    AppMethodBeat.o(101529);
                    return 0;
                case 25:
                    aio.Lsd = aVar3.UbS.hPo();
                    AppMethodBeat.o(101529);
                    return 0;
                case 26:
                    aio.Lse = aVar3.UbS.zi();
                    AppMethodBeat.o(101529);
                    return 0;
                case 27:
                    aio.Lsf = aVar3.UbS.zi();
                    AppMethodBeat.o(101529);
                    return 0;
                case 28:
                    aio.Lsg = aVar3.UbS.zi();
                    AppMethodBeat.o(101529);
                    return 0;
                case 29:
                    aio.Lsh = aVar3.UbS.zi();
                    AppMethodBeat.o(101529);
                    return 0;
                default:
                    AppMethodBeat.o(101529);
                    return -1;
            }
        } else {
            AppMethodBeat.o(101529);
            return -1;
        }
    }
}

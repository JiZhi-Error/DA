package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class dwz extends dpc {
    public SKBuiltinBuffer_t LZV;
    public SKBuiltinBuffer_t LZW;
    public SKBuiltinBuffer_t LZX;
    public int MRg;
    public int MWY;
    public SKBuiltinBuffer_t MWZ;
    public SKBuiltinBuffer_t MXa;
    public SKBuiltinBuffer_t MXb;
    public SKBuiltinBuffer_t MXc;
    public SKBuiltinBuffer_t MXd;
    public int MXe;
    public String MXf;
    public int jeU;
    public float jeW;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(32445);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                b bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(32445);
                throw bVar;
            } else if (this.MWZ == null) {
                b bVar2 = new b("Not all required fields were included: SongName");
                AppMethodBeat.o(32445);
                throw bVar2;
            } else if (this.MXa == null) {
                b bVar3 = new b("Not all required fields were included: SongSinger");
                AppMethodBeat.o(32445);
                throw bVar3;
            } else if (this.LZW == null) {
                b bVar4 = new b("Not all required fields were included: SongAlbum");
                AppMethodBeat.o(32445);
                throw bVar4;
            } else if (this.LZX == null) {
                b bVar5 = new b("Not all required fields were included: SongAlbumUrl");
                AppMethodBeat.o(32445);
                throw bVar5;
            } else if (this.MXb == null) {
                b bVar6 = new b("Not all required fields were included: SongWifiUrl");
                AppMethodBeat.o(32445);
                throw bVar6;
            } else if (this.MXc == null) {
                b bVar7 = new b("Not all required fields were included: SongWapLinkUrl");
                AppMethodBeat.o(32445);
                throw bVar7;
            } else if (this.MXd == null) {
                b bVar8 = new b("Not all required fields were included: SongWebUrl");
                AppMethodBeat.o(32445);
                throw bVar8;
            } else if (this.LZV == null) {
                b bVar9 = new b("Not all required fields were included: SongLyric");
                AppMethodBeat.o(32445);
                throw bVar9;
            } else {
                if (this.BaseResponse != null) {
                    aVar.ni(1, this.BaseResponse.computeSize());
                    this.BaseResponse.writeFields(aVar);
                }
                aVar.aM(2, this.jeU);
                aVar.aM(3, this.MWY);
                aVar.E(4, this.jeW);
                if (this.MWZ != null) {
                    aVar.ni(5, this.MWZ.computeSize());
                    this.MWZ.writeFields(aVar);
                }
                if (this.MXa != null) {
                    aVar.ni(6, this.MXa.computeSize());
                    this.MXa.writeFields(aVar);
                }
                if (this.LZW != null) {
                    aVar.ni(7, this.LZW.computeSize());
                    this.LZW.writeFields(aVar);
                }
                if (this.LZX != null) {
                    aVar.ni(8, this.LZX.computeSize());
                    this.LZX.writeFields(aVar);
                }
                if (this.MXb != null) {
                    aVar.ni(9, this.MXb.computeSize());
                    this.MXb.writeFields(aVar);
                }
                if (this.MXc != null) {
                    aVar.ni(10, this.MXc.computeSize());
                    this.MXc.writeFields(aVar);
                }
                if (this.MXd != null) {
                    aVar.ni(11, this.MXd.computeSize());
                    this.MXd.writeFields(aVar);
                }
                if (this.LZV != null) {
                    aVar.ni(12, this.LZV.computeSize());
                    this.LZV.writeFields(aVar);
                }
                aVar.aM(13, this.MRg);
                aVar.aM(14, this.MXe);
                if (this.MXf != null) {
                    aVar.e(15, this.MXf);
                }
                AppMethodBeat.o(32445);
                return 0;
            }
        } else if (i2 == 1) {
            int nh = (this.BaseResponse != null ? g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0 : 0) + g.a.a.b.b.a.bu(2, this.jeU) + g.a.a.b.b.a.bu(3, this.MWY) + g.a.a.b.b.a.fS(4) + 4;
            if (this.MWZ != null) {
                nh += g.a.a.a.nh(5, this.MWZ.computeSize());
            }
            if (this.MXa != null) {
                nh += g.a.a.a.nh(6, this.MXa.computeSize());
            }
            if (this.LZW != null) {
                nh += g.a.a.a.nh(7, this.LZW.computeSize());
            }
            if (this.LZX != null) {
                nh += g.a.a.a.nh(8, this.LZX.computeSize());
            }
            if (this.MXb != null) {
                nh += g.a.a.a.nh(9, this.MXb.computeSize());
            }
            if (this.MXc != null) {
                nh += g.a.a.a.nh(10, this.MXc.computeSize());
            }
            if (this.MXd != null) {
                nh += g.a.a.a.nh(11, this.MXd.computeSize());
            }
            if (this.LZV != null) {
                nh += g.a.a.a.nh(12, this.LZV.computeSize());
            }
            int bu = nh + g.a.a.b.b.a.bu(13, this.MRg) + g.a.a.b.b.a.bu(14, this.MXe);
            if (this.MXf != null) {
                bu += g.a.a.b.b.a.f(15, this.MXf);
            }
            AppMethodBeat.o(32445);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dpc.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dpc.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.BaseResponse == null) {
                b bVar10 = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(32445);
                throw bVar10;
            } else if (this.MWZ == null) {
                b bVar11 = new b("Not all required fields were included: SongName");
                AppMethodBeat.o(32445);
                throw bVar11;
            } else if (this.MXa == null) {
                b bVar12 = new b("Not all required fields were included: SongSinger");
                AppMethodBeat.o(32445);
                throw bVar12;
            } else if (this.LZW == null) {
                b bVar13 = new b("Not all required fields were included: SongAlbum");
                AppMethodBeat.o(32445);
                throw bVar13;
            } else if (this.LZX == null) {
                b bVar14 = new b("Not all required fields were included: SongAlbumUrl");
                AppMethodBeat.o(32445);
                throw bVar14;
            } else if (this.MXb == null) {
                b bVar15 = new b("Not all required fields were included: SongWifiUrl");
                AppMethodBeat.o(32445);
                throw bVar15;
            } else if (this.MXc == null) {
                b bVar16 = new b("Not all required fields were included: SongWapLinkUrl");
                AppMethodBeat.o(32445);
                throw bVar16;
            } else if (this.MXd == null) {
                b bVar17 = new b("Not all required fields were included: SongWebUrl");
                AppMethodBeat.o(32445);
                throw bVar17;
            } else if (this.LZV == null) {
                b bVar18 = new b("Not all required fields were included: SongLyric");
                AppMethodBeat.o(32445);
                throw bVar18;
            } else {
                AppMethodBeat.o(32445);
                return 0;
            }
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            dwz dwz = (dwz) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        BaseResponse baseResponse = new BaseResponse();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = baseResponse.populateBuilderWithField(aVar4, baseResponse, dpc.getNextFieldNumber(aVar4))) {
                        }
                        dwz.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(32445);
                    return 0;
                case 2:
                    dwz.jeU = aVar3.UbS.zi();
                    AppMethodBeat.o(32445);
                    return 0;
                case 3:
                    dwz.MWY = aVar3.UbS.zi();
                    AppMethodBeat.o(32445);
                    return 0;
                case 4:
                    dwz.jeW = Float.intBitsToFloat(aVar3.UbS.zm());
                    AppMethodBeat.o(32445);
                    return 0;
                case 5:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        SKBuiltinBuffer_t sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = sKBuiltinBuffer_t.populateBuilderWithField(aVar5, sKBuiltinBuffer_t, dpc.getNextFieldNumber(aVar5))) {
                        }
                        dwz.MWZ = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(32445);
                    return 0;
                case 6:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        SKBuiltinBuffer_t sKBuiltinBuffer_t2 = new SKBuiltinBuffer_t();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = sKBuiltinBuffer_t2.populateBuilderWithField(aVar6, sKBuiltinBuffer_t2, dpc.getNextFieldNumber(aVar6))) {
                        }
                        dwz.MXa = sKBuiltinBuffer_t2;
                    }
                    AppMethodBeat.o(32445);
                    return 0;
                case 7:
                    LinkedList<byte[]> awh4 = aVar3.awh(intValue);
                    int size4 = awh4.size();
                    for (int i6 = 0; i6 < size4; i6++) {
                        SKBuiltinBuffer_t sKBuiltinBuffer_t3 = new SKBuiltinBuffer_t();
                        g.a.a.a.a aVar7 = new g.a.a.a.a(awh4.get(i6), unknownTagHandler);
                        for (boolean z4 = true; z4; z4 = sKBuiltinBuffer_t3.populateBuilderWithField(aVar7, sKBuiltinBuffer_t3, dpc.getNextFieldNumber(aVar7))) {
                        }
                        dwz.LZW = sKBuiltinBuffer_t3;
                    }
                    AppMethodBeat.o(32445);
                    return 0;
                case 8:
                    LinkedList<byte[]> awh5 = aVar3.awh(intValue);
                    int size5 = awh5.size();
                    for (int i7 = 0; i7 < size5; i7++) {
                        SKBuiltinBuffer_t sKBuiltinBuffer_t4 = new SKBuiltinBuffer_t();
                        g.a.a.a.a aVar8 = new g.a.a.a.a(awh5.get(i7), unknownTagHandler);
                        for (boolean z5 = true; z5; z5 = sKBuiltinBuffer_t4.populateBuilderWithField(aVar8, sKBuiltinBuffer_t4, dpc.getNextFieldNumber(aVar8))) {
                        }
                        dwz.LZX = sKBuiltinBuffer_t4;
                    }
                    AppMethodBeat.o(32445);
                    return 0;
                case 9:
                    LinkedList<byte[]> awh6 = aVar3.awh(intValue);
                    int size6 = awh6.size();
                    for (int i8 = 0; i8 < size6; i8++) {
                        SKBuiltinBuffer_t sKBuiltinBuffer_t5 = new SKBuiltinBuffer_t();
                        g.a.a.a.a aVar9 = new g.a.a.a.a(awh6.get(i8), unknownTagHandler);
                        for (boolean z6 = true; z6; z6 = sKBuiltinBuffer_t5.populateBuilderWithField(aVar9, sKBuiltinBuffer_t5, dpc.getNextFieldNumber(aVar9))) {
                        }
                        dwz.MXb = sKBuiltinBuffer_t5;
                    }
                    AppMethodBeat.o(32445);
                    return 0;
                case 10:
                    LinkedList<byte[]> awh7 = aVar3.awh(intValue);
                    int size7 = awh7.size();
                    for (int i9 = 0; i9 < size7; i9++) {
                        SKBuiltinBuffer_t sKBuiltinBuffer_t6 = new SKBuiltinBuffer_t();
                        g.a.a.a.a aVar10 = new g.a.a.a.a(awh7.get(i9), unknownTagHandler);
                        for (boolean z7 = true; z7; z7 = sKBuiltinBuffer_t6.populateBuilderWithField(aVar10, sKBuiltinBuffer_t6, dpc.getNextFieldNumber(aVar10))) {
                        }
                        dwz.MXc = sKBuiltinBuffer_t6;
                    }
                    AppMethodBeat.o(32445);
                    return 0;
                case 11:
                    LinkedList<byte[]> awh8 = aVar3.awh(intValue);
                    int size8 = awh8.size();
                    for (int i10 = 0; i10 < size8; i10++) {
                        SKBuiltinBuffer_t sKBuiltinBuffer_t7 = new SKBuiltinBuffer_t();
                        g.a.a.a.a aVar11 = new g.a.a.a.a(awh8.get(i10), unknownTagHandler);
                        for (boolean z8 = true; z8; z8 = sKBuiltinBuffer_t7.populateBuilderWithField(aVar11, sKBuiltinBuffer_t7, dpc.getNextFieldNumber(aVar11))) {
                        }
                        dwz.MXd = sKBuiltinBuffer_t7;
                    }
                    AppMethodBeat.o(32445);
                    return 0;
                case 12:
                    LinkedList<byte[]> awh9 = aVar3.awh(intValue);
                    int size9 = awh9.size();
                    for (int i11 = 0; i11 < size9; i11++) {
                        SKBuiltinBuffer_t sKBuiltinBuffer_t8 = new SKBuiltinBuffer_t();
                        g.a.a.a.a aVar12 = new g.a.a.a.a(awh9.get(i11), unknownTagHandler);
                        for (boolean z9 = true; z9; z9 = sKBuiltinBuffer_t8.populateBuilderWithField(aVar12, sKBuiltinBuffer_t8, dpc.getNextFieldNumber(aVar12))) {
                        }
                        dwz.LZV = sKBuiltinBuffer_t8;
                    }
                    AppMethodBeat.o(32445);
                    return 0;
                case 13:
                    dwz.MRg = aVar3.UbS.zi();
                    AppMethodBeat.o(32445);
                    return 0;
                case 14:
                    dwz.MXe = aVar3.UbS.zi();
                    AppMethodBeat.o(32445);
                    return 0;
                case 15:
                    dwz.MXf = aVar3.UbS.readString();
                    AppMethodBeat.o(32445);
                    return 0;
                default:
                    AppMethodBeat.o(32445);
                    return -1;
            }
        } else {
            AppMethodBeat.o(32445);
            return -1;
        }
    }
}

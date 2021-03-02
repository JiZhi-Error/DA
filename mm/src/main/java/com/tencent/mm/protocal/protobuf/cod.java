package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class cod extends a {
    public String Ghs;
    public int Mur;
    public long Mus;
    public String Mut;
    public aua Muu;
    public ayi Muv;
    public int bitrate;
    public String coverUrl;
    public String decodeKey;
    public int fileSize;
    public String full_thumb_url;
    public String full_thumb_url_token;
    public aty half_rect;
    public float height;
    public int hot_flag;
    public String md5sum;
    public int mediaType;
    public LinkedList<coe> spec = new LinkedList<>();
    public String thumbUrl;
    public String url;
    public String viB;
    public float width;

    public cod() {
        AppMethodBeat.i(209761);
        AppMethodBeat.o(209761);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(209762);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.url != null) {
                aVar.e(1, this.url);
            }
            if (this.thumbUrl != null) {
                aVar.e(2, this.thumbUrl);
            }
            aVar.aM(3, this.mediaType);
            aVar.aM(4, this.Mur);
            aVar.E(5, this.width);
            aVar.E(6, this.height);
            if (this.md5sum != null) {
                aVar.e(7, this.md5sum);
            }
            aVar.aM(8, this.fileSize);
            aVar.aM(9, this.bitrate);
            if (this.decodeKey != null) {
                aVar.e(10, this.decodeKey);
            }
            if (this.coverUrl != null) {
                aVar.e(11, this.coverUrl);
            }
            aVar.bb(12, this.Mus);
            if (this.viB != null) {
                aVar.e(13, this.viB);
            }
            if (this.Ghs != null) {
                aVar.e(14, this.Ghs);
            }
            if (this.Mut != null) {
                aVar.e(15, this.Mut);
            }
            aVar.e(16, 8, this.spec);
            if (this.Muu != null) {
                aVar.ni(17, this.Muu.computeSize());
                this.Muu.writeFields(aVar);
            }
            if (this.Muv != null) {
                aVar.ni(18, this.Muv.computeSize());
                this.Muv.writeFields(aVar);
            }
            aVar.aM(19, this.hot_flag);
            if (this.half_rect != null) {
                aVar.ni(20, this.half_rect.computeSize());
                this.half_rect.writeFields(aVar);
            }
            if (this.full_thumb_url != null) {
                aVar.e(21, this.full_thumb_url);
            }
            if (this.full_thumb_url_token != null) {
                aVar.e(22, this.full_thumb_url_token);
            }
            AppMethodBeat.o(209762);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.url != null ? g.a.a.b.b.a.f(1, this.url) + 0 : 0;
            if (this.thumbUrl != null) {
                f2 += g.a.a.b.b.a.f(2, this.thumbUrl);
            }
            int bu = f2 + g.a.a.b.b.a.bu(3, this.mediaType) + g.a.a.b.b.a.bu(4, this.Mur) + g.a.a.b.b.a.fS(5) + 4 + g.a.a.b.b.a.fS(6) + 4;
            if (this.md5sum != null) {
                bu += g.a.a.b.b.a.f(7, this.md5sum);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(8, this.fileSize) + g.a.a.b.b.a.bu(9, this.bitrate);
            if (this.decodeKey != null) {
                bu2 += g.a.a.b.b.a.f(10, this.decodeKey);
            }
            if (this.coverUrl != null) {
                bu2 += g.a.a.b.b.a.f(11, this.coverUrl);
            }
            int r = bu2 + g.a.a.b.b.a.r(12, this.Mus);
            if (this.viB != null) {
                r += g.a.a.b.b.a.f(13, this.viB);
            }
            if (this.Ghs != null) {
                r += g.a.a.b.b.a.f(14, this.Ghs);
            }
            if (this.Mut != null) {
                r += g.a.a.b.b.a.f(15, this.Mut);
            }
            int c2 = r + g.a.a.a.c(16, 8, this.spec);
            if (this.Muu != null) {
                c2 += g.a.a.a.nh(17, this.Muu.computeSize());
            }
            if (this.Muv != null) {
                c2 += g.a.a.a.nh(18, this.Muv.computeSize());
            }
            int bu3 = c2 + g.a.a.b.b.a.bu(19, this.hot_flag);
            if (this.half_rect != null) {
                bu3 += g.a.a.a.nh(20, this.half_rect.computeSize());
            }
            if (this.full_thumb_url != null) {
                bu3 += g.a.a.b.b.a.f(21, this.full_thumb_url);
            }
            if (this.full_thumb_url_token != null) {
                bu3 += g.a.a.b.b.a.f(22, this.full_thumb_url_token);
            }
            AppMethodBeat.o(209762);
            return bu3;
        } else if (i2 == 2) {
            this.spec.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(209762);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            cod cod = (cod) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    cod.url = aVar3.UbS.readString();
                    AppMethodBeat.o(209762);
                    return 0;
                case 2:
                    cod.thumbUrl = aVar3.UbS.readString();
                    AppMethodBeat.o(209762);
                    return 0;
                case 3:
                    cod.mediaType = aVar3.UbS.zi();
                    AppMethodBeat.o(209762);
                    return 0;
                case 4:
                    cod.Mur = aVar3.UbS.zi();
                    AppMethodBeat.o(209762);
                    return 0;
                case 5:
                    cod.width = Float.intBitsToFloat(aVar3.UbS.zm());
                    AppMethodBeat.o(209762);
                    return 0;
                case 6:
                    cod.height = Float.intBitsToFloat(aVar3.UbS.zm());
                    AppMethodBeat.o(209762);
                    return 0;
                case 7:
                    cod.md5sum = aVar3.UbS.readString();
                    AppMethodBeat.o(209762);
                    return 0;
                case 8:
                    cod.fileSize = aVar3.UbS.zi();
                    AppMethodBeat.o(209762);
                    return 0;
                case 9:
                    cod.bitrate = aVar3.UbS.zi();
                    AppMethodBeat.o(209762);
                    return 0;
                case 10:
                    cod.decodeKey = aVar3.UbS.readString();
                    AppMethodBeat.o(209762);
                    return 0;
                case 11:
                    cod.coverUrl = aVar3.UbS.readString();
                    AppMethodBeat.o(209762);
                    return 0;
                case 12:
                    cod.Mus = aVar3.UbS.zl();
                    AppMethodBeat.o(209762);
                    return 0;
                case 13:
                    cod.viB = aVar3.UbS.readString();
                    AppMethodBeat.o(209762);
                    return 0;
                case 14:
                    cod.Ghs = aVar3.UbS.readString();
                    AppMethodBeat.o(209762);
                    return 0;
                case 15:
                    cod.Mut = aVar3.UbS.readString();
                    AppMethodBeat.o(209762);
                    return 0;
                case 16:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        coe coe = new coe();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = coe.populateBuilderWithField(aVar4, coe, a.getNextFieldNumber(aVar4))) {
                        }
                        cod.spec.add(coe);
                    }
                    AppMethodBeat.o(209762);
                    return 0;
                case 17:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        aua aua = new aua();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = aua.populateBuilderWithField(aVar5, aua, a.getNextFieldNumber(aVar5))) {
                        }
                        cod.Muu = aua;
                    }
                    AppMethodBeat.o(209762);
                    return 0;
                case 18:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        ayi ayi = new ayi();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = ayi.populateBuilderWithField(aVar6, ayi, a.getNextFieldNumber(aVar6))) {
                        }
                        cod.Muv = ayi;
                    }
                    AppMethodBeat.o(209762);
                    return 0;
                case 19:
                    cod.hot_flag = aVar3.UbS.zi();
                    AppMethodBeat.o(209762);
                    return 0;
                case 20:
                    LinkedList<byte[]> awh4 = aVar3.awh(intValue);
                    int size4 = awh4.size();
                    for (int i6 = 0; i6 < size4; i6++) {
                        aty aty = new aty();
                        g.a.a.a.a aVar7 = new g.a.a.a.a(awh4.get(i6), unknownTagHandler);
                        for (boolean z4 = true; z4; z4 = aty.populateBuilderWithField(aVar7, aty, a.getNextFieldNumber(aVar7))) {
                        }
                        cod.half_rect = aty;
                    }
                    AppMethodBeat.o(209762);
                    return 0;
                case 21:
                    cod.full_thumb_url = aVar3.UbS.readString();
                    AppMethodBeat.o(209762);
                    return 0;
                case 22:
                    cod.full_thumb_url_token = aVar3.UbS.readString();
                    AppMethodBeat.o(209762);
                    return 0;
                default:
                    AppMethodBeat.o(209762);
                    return -1;
            }
        } else {
            AppMethodBeat.o(209762);
            return -1;
        }
    }
}

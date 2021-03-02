package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public class FinderMedia extends a {
    public int bitrate;
    public ayg codec_info;
    public String coverUrl;
    public String cover_url_token;
    public String decodeKey;
    public int fileSize;
    public int full_bitrate;
    public int full_file_size;
    public float full_height;
    public String full_md5sum;
    public String full_thumb_url;
    public String full_thumb_url_token;
    public String full_url;
    public float full_width;
    public aty half_rect;
    public float height;
    public aua hls_spec;
    public int hot_flag;
    public awl live_spec;
    public String md5sum;
    public int mediaType;
    public LinkedList<ayh> spec = new LinkedList<>();
    public String thumbUrl;
    public String thumb_url_token;
    public String url;
    public String url_token;
    public int videoDuration;
    public float width;

    public FinderMedia() {
        AppMethodBeat.i(184202);
        AppMethodBeat.o(184202);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(169005);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.url != null) {
                aVar.e(1, this.url);
            }
            if (this.thumbUrl != null) {
                aVar.e(2, this.thumbUrl);
            }
            aVar.aM(3, this.mediaType);
            aVar.aM(4, this.videoDuration);
            aVar.E(5, this.width);
            aVar.E(6, this.height);
            if (this.md5sum != null) {
                aVar.e(7, this.md5sum);
            }
            aVar.aM(8, this.fileSize);
            aVar.aM(9, this.bitrate);
            aVar.e(10, 8, this.spec);
            if (this.coverUrl != null) {
                aVar.e(11, this.coverUrl);
            }
            if (this.decodeKey != null) {
                aVar.e(12, this.decodeKey);
            }
            if (this.url_token != null) {
                aVar.e(13, this.url_token);
            }
            if (this.thumb_url_token != null) {
                aVar.e(14, this.thumb_url_token);
            }
            if (this.cover_url_token != null) {
                aVar.e(15, this.cover_url_token);
            }
            if (this.codec_info != null) {
                aVar.ni(16, this.codec_info.computeSize());
                this.codec_info.writeFields(aVar);
            }
            if (this.live_spec != null) {
                aVar.ni(17, this.live_spec.computeSize());
                this.live_spec.writeFields(aVar);
            }
            if (this.hls_spec != null) {
                aVar.ni(18, this.hls_spec.computeSize());
                this.hls_spec.writeFields(aVar);
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
            if (this.full_url != null) {
                aVar.e(23, this.full_url);
            }
            aVar.E(24, this.full_width);
            aVar.E(25, this.full_height);
            if (this.full_md5sum != null) {
                aVar.e(26, this.full_md5sum);
            }
            aVar.aM(27, this.full_file_size);
            aVar.aM(28, this.full_bitrate);
            AppMethodBeat.o(169005);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.url != null ? g.a.a.b.b.a.f(1, this.url) + 0 : 0;
            if (this.thumbUrl != null) {
                f2 += g.a.a.b.b.a.f(2, this.thumbUrl);
            }
            int bu = f2 + g.a.a.b.b.a.bu(3, this.mediaType) + g.a.a.b.b.a.bu(4, this.videoDuration) + g.a.a.b.b.a.fS(5) + 4 + g.a.a.b.b.a.fS(6) + 4;
            if (this.md5sum != null) {
                bu += g.a.a.b.b.a.f(7, this.md5sum);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(8, this.fileSize) + g.a.a.b.b.a.bu(9, this.bitrate) + g.a.a.a.c(10, 8, this.spec);
            if (this.coverUrl != null) {
                bu2 += g.a.a.b.b.a.f(11, this.coverUrl);
            }
            if (this.decodeKey != null) {
                bu2 += g.a.a.b.b.a.f(12, this.decodeKey);
            }
            if (this.url_token != null) {
                bu2 += g.a.a.b.b.a.f(13, this.url_token);
            }
            if (this.thumb_url_token != null) {
                bu2 += g.a.a.b.b.a.f(14, this.thumb_url_token);
            }
            if (this.cover_url_token != null) {
                bu2 += g.a.a.b.b.a.f(15, this.cover_url_token);
            }
            if (this.codec_info != null) {
                bu2 += g.a.a.a.nh(16, this.codec_info.computeSize());
            }
            if (this.live_spec != null) {
                bu2 += g.a.a.a.nh(17, this.live_spec.computeSize());
            }
            if (this.hls_spec != null) {
                bu2 += g.a.a.a.nh(18, this.hls_spec.computeSize());
            }
            int bu3 = bu2 + g.a.a.b.b.a.bu(19, this.hot_flag);
            if (this.half_rect != null) {
                bu3 += g.a.a.a.nh(20, this.half_rect.computeSize());
            }
            if (this.full_thumb_url != null) {
                bu3 += g.a.a.b.b.a.f(21, this.full_thumb_url);
            }
            if (this.full_thumb_url_token != null) {
                bu3 += g.a.a.b.b.a.f(22, this.full_thumb_url_token);
            }
            if (this.full_url != null) {
                bu3 += g.a.a.b.b.a.f(23, this.full_url);
            }
            int fS = bu3 + g.a.a.b.b.a.fS(24) + 4 + g.a.a.b.b.a.fS(25) + 4;
            if (this.full_md5sum != null) {
                fS += g.a.a.b.b.a.f(26, this.full_md5sum);
            }
            int bu4 = fS + g.a.a.b.b.a.bu(27, this.full_file_size) + g.a.a.b.b.a.bu(28, this.full_bitrate);
            AppMethodBeat.o(169005);
            return bu4;
        } else if (i2 == 2) {
            this.spec.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(169005);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            FinderMedia finderMedia = (FinderMedia) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    finderMedia.url = aVar3.UbS.readString();
                    AppMethodBeat.o(169005);
                    return 0;
                case 2:
                    finderMedia.thumbUrl = aVar3.UbS.readString();
                    AppMethodBeat.o(169005);
                    return 0;
                case 3:
                    finderMedia.mediaType = aVar3.UbS.zi();
                    AppMethodBeat.o(169005);
                    return 0;
                case 4:
                    finderMedia.videoDuration = aVar3.UbS.zi();
                    AppMethodBeat.o(169005);
                    return 0;
                case 5:
                    finderMedia.width = Float.intBitsToFloat(aVar3.UbS.zm());
                    AppMethodBeat.o(169005);
                    return 0;
                case 6:
                    finderMedia.height = Float.intBitsToFloat(aVar3.UbS.zm());
                    AppMethodBeat.o(169005);
                    return 0;
                case 7:
                    finderMedia.md5sum = aVar3.UbS.readString();
                    AppMethodBeat.o(169005);
                    return 0;
                case 8:
                    finderMedia.fileSize = aVar3.UbS.zi();
                    AppMethodBeat.o(169005);
                    return 0;
                case 9:
                    finderMedia.bitrate = aVar3.UbS.zi();
                    AppMethodBeat.o(169005);
                    return 0;
                case 10:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        ayh ayh = new ayh();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = ayh.populateBuilderWithField(aVar4, ayh, a.getNextFieldNumber(aVar4))) {
                        }
                        finderMedia.spec.add(ayh);
                    }
                    AppMethodBeat.o(169005);
                    return 0;
                case 11:
                    finderMedia.coverUrl = aVar3.UbS.readString();
                    AppMethodBeat.o(169005);
                    return 0;
                case 12:
                    finderMedia.decodeKey = aVar3.UbS.readString();
                    AppMethodBeat.o(169005);
                    return 0;
                case 13:
                    finderMedia.url_token = aVar3.UbS.readString();
                    AppMethodBeat.o(169005);
                    return 0;
                case 14:
                    finderMedia.thumb_url_token = aVar3.UbS.readString();
                    AppMethodBeat.o(169005);
                    return 0;
                case 15:
                    finderMedia.cover_url_token = aVar3.UbS.readString();
                    AppMethodBeat.o(169005);
                    return 0;
                case 16:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        ayg ayg = new ayg();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = ayg.populateBuilderWithField(aVar5, ayg, a.getNextFieldNumber(aVar5))) {
                        }
                        finderMedia.codec_info = ayg;
                    }
                    AppMethodBeat.o(169005);
                    return 0;
                case 17:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        awl awl = new awl();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = awl.populateBuilderWithField(aVar6, awl, a.getNextFieldNumber(aVar6))) {
                        }
                        finderMedia.live_spec = awl;
                    }
                    AppMethodBeat.o(169005);
                    return 0;
                case 18:
                    LinkedList<byte[]> awh4 = aVar3.awh(intValue);
                    int size4 = awh4.size();
                    for (int i6 = 0; i6 < size4; i6++) {
                        aua aua = new aua();
                        g.a.a.a.a aVar7 = new g.a.a.a.a(awh4.get(i6), unknownTagHandler);
                        for (boolean z4 = true; z4; z4 = aua.populateBuilderWithField(aVar7, aua, a.getNextFieldNumber(aVar7))) {
                        }
                        finderMedia.hls_spec = aua;
                    }
                    AppMethodBeat.o(169005);
                    return 0;
                case 19:
                    finderMedia.hot_flag = aVar3.UbS.zi();
                    AppMethodBeat.o(169005);
                    return 0;
                case 20:
                    LinkedList<byte[]> awh5 = aVar3.awh(intValue);
                    int size5 = awh5.size();
                    for (int i7 = 0; i7 < size5; i7++) {
                        aty aty = new aty();
                        g.a.a.a.a aVar8 = new g.a.a.a.a(awh5.get(i7), unknownTagHandler);
                        for (boolean z5 = true; z5; z5 = aty.populateBuilderWithField(aVar8, aty, a.getNextFieldNumber(aVar8))) {
                        }
                        finderMedia.half_rect = aty;
                    }
                    AppMethodBeat.o(169005);
                    return 0;
                case 21:
                    finderMedia.full_thumb_url = aVar3.UbS.readString();
                    AppMethodBeat.o(169005);
                    return 0;
                case 22:
                    finderMedia.full_thumb_url_token = aVar3.UbS.readString();
                    AppMethodBeat.o(169005);
                    return 0;
                case 23:
                    finderMedia.full_url = aVar3.UbS.readString();
                    AppMethodBeat.o(169005);
                    return 0;
                case 24:
                    finderMedia.full_width = Float.intBitsToFloat(aVar3.UbS.zm());
                    AppMethodBeat.o(169005);
                    return 0;
                case 25:
                    finderMedia.full_height = Float.intBitsToFloat(aVar3.UbS.zm());
                    AppMethodBeat.o(169005);
                    return 0;
                case 26:
                    finderMedia.full_md5sum = aVar3.UbS.readString();
                    AppMethodBeat.o(169005);
                    return 0;
                case 27:
                    finderMedia.full_file_size = aVar3.UbS.zi();
                    AppMethodBeat.o(169005);
                    return 0;
                case 28:
                    finderMedia.full_bitrate = aVar3.UbS.zi();
                    AppMethodBeat.o(169005);
                    return 0;
                default:
                    AppMethodBeat.o(169005);
                    return -1;
            }
        } else {
            AppMethodBeat.o(169005);
            return -1;
        }
    }
}

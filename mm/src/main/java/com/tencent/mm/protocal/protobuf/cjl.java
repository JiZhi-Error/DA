package com.tencent.mm.protocal.protobuf;

import android.support.constraint.ConstraintLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.appbrand.jsapi.bv;
import com.tencent.mm.plugin.appbrand.jsapi.h.h;
import com.tencent.mm.plugin.appbrand.jsapi.pay.b;
import com.tencent.mm.plugin.appbrand.jsapi.pay.n;
import com.tencent.mm.plugin.appbrand.jsapi.pay.s;
import com.tencent.mm.plugin.appbrand.jsapi.r.f;
import com.tencent.mm.plugin.appbrand.jsapi.share.d;
import com.tencent.qqmusic.mediaplayer.PlayerException;
import com.tencent.thumbplayer.core.common.TPCodecParamers;
import java.util.LinkedList;

public final class cjl extends a {
    public acn MfU;
    public int MoL;
    public String MoM;
    public String MoN;
    public boolean MoO;
    public String MoP;
    public long MoQ;
    public String MoR;
    public String MoS;
    public String MoT;
    public aty MoU;
    public String MoV;
    public String MoW;
    public car MoX;
    public boolean MoY;
    public FinderMediaReportObject MoZ;
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
    public String full_url;
    public float full_width;
    public float height;
    public int hot_flag;
    public String md5sum;
    public String mediaId;
    public int mediaType;
    public LinkedList<ayh> spec = new LinkedList<>();
    public String thumbUrl;
    public String thumb_url_token;
    public cjx uOR;
    public String url;
    public String url_token;
    public int videoDuration;
    public float width;

    public cjl() {
        AppMethodBeat.i(209729);
        AppMethodBeat.o(209729);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(169080);
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
            if (this.mediaId != null) {
                aVar.e(10, this.mediaId);
            }
            aVar.aM(11, this.MoL);
            if (this.MoM != null) {
                aVar.e(12, this.MoM);
            }
            if (this.MoN != null) {
                aVar.e(13, this.MoN);
            }
            aVar.cc(14, this.MoO);
            if (this.uOR != null) {
                aVar.ni(15, this.uOR.computeSize());
                this.uOR.writeFields(aVar);
            }
            aVar.e(16, 8, this.spec);
            if (this.coverUrl != null) {
                aVar.e(17, this.coverUrl);
            }
            if (this.decodeKey != null) {
                aVar.e(20, this.decodeKey);
            }
            if (this.url_token != null) {
                aVar.e(21, this.url_token);
            }
            if (this.thumb_url_token != null) {
                aVar.e(22, this.thumb_url_token);
            }
            if (this.cover_url_token != null) {
                aVar.e(23, this.cover_url_token);
            }
            if (this.MfU != null) {
                aVar.ni(24, this.MfU.computeSize());
                this.MfU.writeFields(aVar);
            }
            if (this.codec_info != null) {
                aVar.ni(25, this.codec_info.computeSize());
                this.codec_info.writeFields(aVar);
            }
            if (this.MoP != null) {
                aVar.e(30, this.MoP);
            }
            aVar.bb(31, this.MoQ);
            if (this.MoR != null) {
                aVar.e(32, this.MoR);
            }
            if (this.MoS != null) {
                aVar.e(33, this.MoS);
            }
            if (this.MoT != null) {
                aVar.e(34, this.MoT);
            }
            if (this.full_url != null) {
                aVar.e(35, this.full_url);
            }
            aVar.E(36, this.full_width);
            aVar.E(37, this.full_height);
            if (this.full_md5sum != null) {
                aVar.e(38, this.full_md5sum);
            }
            aVar.aM(39, this.full_file_size);
            aVar.aM(40, this.full_bitrate);
            if (this.MoU != null) {
                aVar.ni(41, this.MoU.computeSize());
                this.MoU.writeFields(aVar);
            }
            if (this.MoV != null) {
                aVar.e(42, this.MoV);
            }
            if (this.MoW != null) {
                aVar.e(43, this.MoW);
            }
            if (this.MoX != null) {
                aVar.ni(44, this.MoX.computeSize());
                this.MoX.writeFields(aVar);
            }
            aVar.cc(45, this.MoY);
            aVar.aM(46, this.hot_flag);
            if (this.MoZ != null) {
                aVar.ni(100, this.MoZ.computeSize());
                this.MoZ.writeFields(aVar);
            }
            AppMethodBeat.o(169080);
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
            int bu2 = bu + g.a.a.b.b.a.bu(8, this.fileSize) + g.a.a.b.b.a.bu(9, this.bitrate);
            if (this.mediaId != null) {
                bu2 += g.a.a.b.b.a.f(10, this.mediaId);
            }
            int bu3 = bu2 + g.a.a.b.b.a.bu(11, this.MoL);
            if (this.MoM != null) {
                bu3 += g.a.a.b.b.a.f(12, this.MoM);
            }
            if (this.MoN != null) {
                bu3 += g.a.a.b.b.a.f(13, this.MoN);
            }
            int fS = bu3 + g.a.a.b.b.a.fS(14) + 1;
            if (this.uOR != null) {
                fS += g.a.a.a.nh(15, this.uOR.computeSize());
            }
            int c2 = fS + g.a.a.a.c(16, 8, this.spec);
            if (this.coverUrl != null) {
                c2 += g.a.a.b.b.a.f(17, this.coverUrl);
            }
            if (this.decodeKey != null) {
                c2 += g.a.a.b.b.a.f(20, this.decodeKey);
            }
            if (this.url_token != null) {
                c2 += g.a.a.b.b.a.f(21, this.url_token);
            }
            if (this.thumb_url_token != null) {
                c2 += g.a.a.b.b.a.f(22, this.thumb_url_token);
            }
            if (this.cover_url_token != null) {
                c2 += g.a.a.b.b.a.f(23, this.cover_url_token);
            }
            if (this.MfU != null) {
                c2 += g.a.a.a.nh(24, this.MfU.computeSize());
            }
            if (this.codec_info != null) {
                c2 += g.a.a.a.nh(25, this.codec_info.computeSize());
            }
            if (this.MoP != null) {
                c2 += g.a.a.b.b.a.f(30, this.MoP);
            }
            int r = c2 + g.a.a.b.b.a.r(31, this.MoQ);
            if (this.MoR != null) {
                r += g.a.a.b.b.a.f(32, this.MoR);
            }
            if (this.MoS != null) {
                r += g.a.a.b.b.a.f(33, this.MoS);
            }
            if (this.MoT != null) {
                r += g.a.a.b.b.a.f(34, this.MoT);
            }
            if (this.full_url != null) {
                r += g.a.a.b.b.a.f(35, this.full_url);
            }
            int fS2 = r + g.a.a.b.b.a.fS(36) + 4 + g.a.a.b.b.a.fS(37) + 4;
            if (this.full_md5sum != null) {
                fS2 += g.a.a.b.b.a.f(38, this.full_md5sum);
            }
            int bu4 = fS2 + g.a.a.b.b.a.bu(39, this.full_file_size) + g.a.a.b.b.a.bu(40, this.full_bitrate);
            if (this.MoU != null) {
                bu4 += g.a.a.a.nh(41, this.MoU.computeSize());
            }
            if (this.MoV != null) {
                bu4 += g.a.a.b.b.a.f(42, this.MoV);
            }
            if (this.MoW != null) {
                bu4 += g.a.a.b.b.a.f(43, this.MoW);
            }
            if (this.MoX != null) {
                bu4 += g.a.a.a.nh(44, this.MoX.computeSize());
            }
            int fS3 = bu4 + g.a.a.b.b.a.fS(45) + 1 + g.a.a.b.b.a.bu(46, this.hot_flag);
            if (this.MoZ != null) {
                fS3 += g.a.a.a.nh(100, this.MoZ.computeSize());
            }
            AppMethodBeat.o(169080);
            return fS3;
        } else if (i2 == 2) {
            this.spec.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(169080);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            cjl cjl = (cjl) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    cjl.url = aVar3.UbS.readString();
                    AppMethodBeat.o(169080);
                    return 0;
                case 2:
                    cjl.thumbUrl = aVar3.UbS.readString();
                    AppMethodBeat.o(169080);
                    return 0;
                case 3:
                    cjl.mediaType = aVar3.UbS.zi();
                    AppMethodBeat.o(169080);
                    return 0;
                case 4:
                    cjl.videoDuration = aVar3.UbS.zi();
                    AppMethodBeat.o(169080);
                    return 0;
                case 5:
                    cjl.width = Float.intBitsToFloat(aVar3.UbS.zm());
                    AppMethodBeat.o(169080);
                    return 0;
                case 6:
                    cjl.height = Float.intBitsToFloat(aVar3.UbS.zm());
                    AppMethodBeat.o(169080);
                    return 0;
                case 7:
                    cjl.md5sum = aVar3.UbS.readString();
                    AppMethodBeat.o(169080);
                    return 0;
                case 8:
                    cjl.fileSize = aVar3.UbS.zi();
                    AppMethodBeat.o(169080);
                    return 0;
                case 9:
                    cjl.bitrate = aVar3.UbS.zi();
                    AppMethodBeat.o(169080);
                    return 0;
                case 10:
                    cjl.mediaId = aVar3.UbS.readString();
                    AppMethodBeat.o(169080);
                    return 0;
                case 11:
                    cjl.MoL = aVar3.UbS.zi();
                    AppMethodBeat.o(169080);
                    return 0;
                case 12:
                    cjl.MoM = aVar3.UbS.readString();
                    AppMethodBeat.o(169080);
                    return 0;
                case 13:
                    cjl.MoN = aVar3.UbS.readString();
                    AppMethodBeat.o(169080);
                    return 0;
                case 14:
                    cjl.MoO = aVar3.UbS.yZ();
                    AppMethodBeat.o(169080);
                    return 0;
                case 15:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        cjx cjx = new cjx();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = cjx.populateBuilderWithField(aVar4, cjx, a.getNextFieldNumber(aVar4))) {
                        }
                        cjl.uOR = cjx;
                    }
                    AppMethodBeat.o(169080);
                    return 0;
                case 16:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        ayh ayh = new ayh();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = ayh.populateBuilderWithField(aVar5, ayh, a.getNextFieldNumber(aVar5))) {
                        }
                        cjl.spec.add(ayh);
                    }
                    AppMethodBeat.o(169080);
                    return 0;
                case 17:
                    cjl.coverUrl = aVar3.UbS.readString();
                    AppMethodBeat.o(169080);
                    return 0;
                case 18:
                case 19:
                case 26:
                case 27:
                case 28:
                case 29:
                case 47:
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE:
                case 49:
                case 50:
                case 51:
                case 52:
                case 53:
                case 54:
                case 55:
                case 56:
                case n.CTRL_INDEX:
                case 58:
                case bv.CTRL_INDEX:
                case 60:
                case PlayerException.EXCEPTION_TYPE_INITLIB /*{ENCODED_INT: 61}*/:
                case 62:
                case 63:
                case 64:
                case 65:
                case 66:
                case 67:
                case 68:
                case 69:
                case 70:
                case 71:
                case 72:
                case d.CTRL_INDEX:
                case 74:
                case 75:
                case WXMediaMessage.IMediaObject.TYPE_MUSIC_VIDEO:
                case TPCodecParamers.TP_PROFILE_H264_MAIN /*{ENCODED_INT: 77}*/:
                case h.a.CTRL_INDEX:
                case 79:
                case PlayerException.EXCEPTION_TYPE_CONNECT_FAIL /*{ENCODED_INT: 80}*/:
                case 81:
                case PlayerException.EXCEPTION_TYPE_ERROR_CREATE_JAVA_DATASOURCE /*{ENCODED_INT: 82}*/:
                case 83:
                case f.CTRL_INDEX:
                case s.CTRL_INDEX:
                case b.CTRL_INDEX:
                case 87:
                case TPCodecParamers.TP_PROFILE_H264_EXTENDED /*{ENCODED_INT: 88}*/:
                case PlayerException.EXCEPTION_IN_CHECK_STATE /*{ENCODED_INT: 89}*/:
                case 90:
                case PlayerException.EXCEPTION_IN_PREPARE /*{ENCODED_INT: 91}*/:
                case 92:
                case PlayerException.EXCEPTION_IN_PAUSE /*{ENCODED_INT: 93}*/:
                case 94:
                case PlayerException.EXCEPTION_IN_SEEK /*{ENCODED_INT: 95}*/:
                case PlayerException.EXCEPTION_IN_SETAUDIOEFFECT /*{ENCODED_INT: 96}*/:
                case PlayerException.EXCEPTION_IN_RELEASE /*{ENCODED_INT: 97}*/:
                case 98:
                case 99:
                default:
                    AppMethodBeat.o(169080);
                    return -1;
                case 20:
                    cjl.decodeKey = aVar3.UbS.readString();
                    AppMethodBeat.o(169080);
                    return 0;
                case 21:
                    cjl.url_token = aVar3.UbS.readString();
                    AppMethodBeat.o(169080);
                    return 0;
                case 22:
                    cjl.thumb_url_token = aVar3.UbS.readString();
                    AppMethodBeat.o(169080);
                    return 0;
                case 23:
                    cjl.cover_url_token = aVar3.UbS.readString();
                    AppMethodBeat.o(169080);
                    return 0;
                case 24:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        acn acn = new acn();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = acn.populateBuilderWithField(aVar6, acn, a.getNextFieldNumber(aVar6))) {
                        }
                        cjl.MfU = acn;
                    }
                    AppMethodBeat.o(169080);
                    return 0;
                case 25:
                    LinkedList<byte[]> awh4 = aVar3.awh(intValue);
                    int size4 = awh4.size();
                    for (int i6 = 0; i6 < size4; i6++) {
                        ayg ayg = new ayg();
                        g.a.a.a.a aVar7 = new g.a.a.a.a(awh4.get(i6), unknownTagHandler);
                        for (boolean z4 = true; z4; z4 = ayg.populateBuilderWithField(aVar7, ayg, a.getNextFieldNumber(aVar7))) {
                        }
                        cjl.codec_info = ayg;
                    }
                    AppMethodBeat.o(169080);
                    return 0;
                case 30:
                    cjl.MoP = aVar3.UbS.readString();
                    AppMethodBeat.o(169080);
                    return 0;
                case 31:
                    cjl.MoQ = aVar3.UbS.zl();
                    AppMethodBeat.o(169080);
                    return 0;
                case 32:
                    cjl.MoR = aVar3.UbS.readString();
                    AppMethodBeat.o(169080);
                    return 0;
                case 33:
                    cjl.MoS = aVar3.UbS.readString();
                    AppMethodBeat.o(169080);
                    return 0;
                case 34:
                    cjl.MoT = aVar3.UbS.readString();
                    AppMethodBeat.o(169080);
                    return 0;
                case 35:
                    cjl.full_url = aVar3.UbS.readString();
                    AppMethodBeat.o(169080);
                    return 0;
                case 36:
                    cjl.full_width = Float.intBitsToFloat(aVar3.UbS.zm());
                    AppMethodBeat.o(169080);
                    return 0;
                case 37:
                    cjl.full_height = Float.intBitsToFloat(aVar3.UbS.zm());
                    AppMethodBeat.o(169080);
                    return 0;
                case 38:
                    cjl.full_md5sum = aVar3.UbS.readString();
                    AppMethodBeat.o(169080);
                    return 0;
                case 39:
                    cjl.full_file_size = aVar3.UbS.zi();
                    AppMethodBeat.o(169080);
                    return 0;
                case 40:
                    cjl.full_bitrate = aVar3.UbS.zi();
                    AppMethodBeat.o(169080);
                    return 0;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_RIGHT_CREATOR:
                    LinkedList<byte[]> awh5 = aVar3.awh(intValue);
                    int size5 = awh5.size();
                    for (int i7 = 0; i7 < size5; i7++) {
                        aty aty = new aty();
                        g.a.a.a.a aVar8 = new g.a.a.a.a(awh5.get(i7), unknownTagHandler);
                        for (boolean z5 = true; z5; z5 = aty.populateBuilderWithField(aVar8, aty, a.getNextFieldNumber(aVar8))) {
                        }
                        cjl.MoU = aty;
                    }
                    AppMethodBeat.o(169080);
                    return 0;
                case 42:
                    cjl.MoV = aVar3.UbS.readString();
                    AppMethodBeat.o(169080);
                    return 0;
                case 43:
                    cjl.MoW = aVar3.UbS.readString();
                    AppMethodBeat.o(169080);
                    return 0;
                case 44:
                    LinkedList<byte[]> awh6 = aVar3.awh(intValue);
                    int size6 = awh6.size();
                    for (int i8 = 0; i8 < size6; i8++) {
                        car car = new car();
                        g.a.a.a.a aVar9 = new g.a.a.a.a(awh6.get(i8), unknownTagHandler);
                        for (boolean z6 = true; z6; z6 = car.populateBuilderWithField(aVar9, car, a.getNextFieldNumber(aVar9))) {
                        }
                        cjl.MoX = car;
                    }
                    AppMethodBeat.o(169080);
                    return 0;
                case 45:
                    cjl.MoY = aVar3.UbS.yZ();
                    AppMethodBeat.o(169080);
                    return 0;
                case 46:
                    cjl.hot_flag = aVar3.UbS.zi();
                    AppMethodBeat.o(169080);
                    return 0;
                case 100:
                    LinkedList<byte[]> awh7 = aVar3.awh(intValue);
                    int size7 = awh7.size();
                    for (int i9 = 0; i9 < size7; i9++) {
                        FinderMediaReportObject finderMediaReportObject = new FinderMediaReportObject();
                        g.a.a.a.a aVar10 = new g.a.a.a.a(awh7.get(i9), unknownTagHandler);
                        for (boolean z7 = true; z7; z7 = finderMediaReportObject.populateBuilderWithField(aVar10, finderMediaReportObject, a.getNextFieldNumber(aVar10))) {
                        }
                        cjl.MoZ = finderMediaReportObject;
                    }
                    AppMethodBeat.o(169080);
                    return 0;
            }
        } else {
            AppMethodBeat.o(169080);
            return -1;
        }
    }
}

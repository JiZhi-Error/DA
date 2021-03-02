package com.tencent.tinker.a.b.a;

import android.support.constraint.ConstraintLayout;
import com.facebook.internal.FacebookRequestErrorClassification;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiGetBackgroundAudioState;
import com.tencent.mm.plugin.appbrand.jsapi.bv;
import com.tencent.mm.plugin.appbrand.jsapi.h.h;
import com.tencent.mm.plugin.appbrand.jsapi.k.c;
import com.tencent.mm.plugin.appbrand.jsapi.k.g;
import com.tencent.mm.plugin.appbrand.jsapi.k.r;
import com.tencent.mm.plugin.appbrand.jsapi.p.z;
import com.tencent.mm.plugin.appbrand.jsapi.pay.b;
import com.tencent.mm.plugin.appbrand.jsapi.pay.n;
import com.tencent.mm.plugin.appbrand.jsapi.pay.s;
import com.tencent.mm.plugin.appbrand.jsapi.share.d;
import com.tencent.qqmusic.mediaplayer.PlayerException;
import com.tencent.rtmp.TXLiveConstants;
import com.tencent.smtt.sdk.TbsListener;
import com.tencent.thumbplayer.api.TPOptionalID;
import com.tencent.thumbplayer.core.common.TPCodecParamers;
import com.tencent.tinker.a.a.j;
import com.tencent.tinker.a.b.b.a;

public final class f extends e {
    private final h Shp;
    private final c Shq;
    private final boolean Shr = true;

    public f(h hVar, c cVar) {
        super(null);
        this.Shp = hVar;
        this.Shq = cVar;
    }

    @Override // com.tencent.tinker.a.b.a.e
    public final void a(int i2, int i3, int i4, int i5, int i6, long j2) {
        if (this.Shr) {
            i6 = this.Shq.arY(i6);
        }
        switch (i3) {
            case -1:
            case 0:
            case 14:
                this.Shp.c((short) i3);
                return;
            case 36:
            case 110:
            case 111:
            case 112:
            case 113:
            case 114:
                this.Shp.a(b.mG(i3, b.mH(0, 0)), (short) i4, b.W(0, 0, 0, 0));
                return;
            case 40:
                if (this.Shr) {
                    int i7 = i6 - this.Shp.apk;
                    if (i7 == ((byte) i7)) {
                        this.Shp.c(b.mG(i3, i7 & 255));
                        return;
                    } else if (i7 != ((short) i7)) {
                        this.Shp.a(42, (short) i7, (short) (i7 >> 16));
                        return;
                    } else {
                        this.Shp.b(41, (short) i7);
                        return;
                    }
                } else {
                    int i8 = i6 - this.Shp.apk;
                    if (i8 != ((byte) i8)) {
                        throw new j("Target out of range: " + a.asc(i8) + ", perhaps you need to enable force jumbo mode.");
                    }
                    this.Shp.c(b.mG(i3, i8 & 255));
                    return;
                }
            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_RIGHT_CREATOR:
                if (this.Shr) {
                    int i9 = i6 - this.Shp.apk;
                    if (i9 != ((short) i9)) {
                        this.Shp.a(42, (short) i9, (short) (i9 >> 16));
                        return;
                    }
                    h hVar = this.Shp;
                    hVar.b((short) i3, (short) i9);
                    return;
                }
                short mI = b.mI(i6, this.Shp.apk);
                this.Shp.b((short) i3, mI);
                return;
            case 42:
                int i10 = i6 - this.Shp.apk;
                this.Shp.a((short) i3, (short) i10, (short) (i10 >> 16));
                return;
            default:
                throw new IllegalStateException("unexpected opcode: " + a.asb(i3));
        }
    }

    @Override // com.tencent.tinker.a.b.a.e
    public final void a(int i2, int i3, int i4, int i5, int i6, long j2, int i7) {
        if (this.Shr) {
            i6 = this.Shq.arY(i6);
        }
        switch (i3) {
            case 10:
            case 11:
            case 12:
            case 13:
            case 15:
            case 16:
            case 17:
            case 29:
            case 30:
            case 39:
                this.Shp.c(b.mG(i3, i7));
                return;
            case 14:
            case 32:
            case 33:
            case 35:
            case 37:
            case 40:
            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_RIGHT_CREATOR:
            case 42:
            case 45:
            case 46:
            case 47:
            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE:
            case 49:
            case 50:
            case 51:
            case 52:
            case 53:
            case 54:
            case 55:
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
            case TPCodecParamers.TP_PROFILE_H264_MAIN:
            case h.a.CTRL_INDEX:
            case 79:
            case PlayerException.EXCEPTION_TYPE_CONNECT_FAIL:
            case 81:
            case PlayerException.EXCEPTION_TYPE_ERROR_CREATE_JAVA_DATASOURCE:
            case 83:
            case com.tencent.mm.plugin.appbrand.jsapi.r.f.CTRL_INDEX:
            case s.CTRL_INDEX:
            case b.CTRL_INDEX:
            case 87:
            case TPCodecParamers.TP_PROFILE_H264_EXTENDED:
            case PlayerException.EXCEPTION_IN_CHECK_STATE:
            case 90:
            case PlayerException.EXCEPTION_IN_PREPARE:
            case 92:
            case PlayerException.EXCEPTION_IN_PAUSE:
            case 94:
            case PlayerException.EXCEPTION_IN_SEEK:
            default:
                throw new IllegalStateException("unexpected opcode: " + a.asb(i3));
            case 18:
                short s = (short) i3;
                h hVar = this.Shp;
                if (j2 < -8 || j2 > 7) {
                    throw new j("Literal out of range: " + a.OI(j2));
                }
                hVar.c(b.mG(s, b.mH(i7, ((int) j2) & 15)));
                return;
            case 19:
            case 22:
                this.Shp.b(b.mG(i3, i7), b.OH(j2));
                return;
            case 20:
            case 23:
                if (j2 != ((long) ((int) j2))) {
                    throw new j("Literal out of range: " + a.OI(j2));
                }
                int i8 = (int) j2;
                this.Shp.a(b.mG(i3, i7), (short) i8, (short) (i8 >> 16));
                return;
            case 21:
            case 25:
                this.Shp.b(b.mG(i3, i7), (short) ((int) (j2 >> (i3 == 21 ? 16 : '0'))));
                return;
            case 24:
                h hVar2 = this.Shp;
                hVar2.c(b.mG(i3, i7));
                hVar2.c((short) ((int) j2));
                hVar2.c((short) ((int) (j2 >> 16)));
                hVar2.c((short) ((int) (j2 >> 32)));
                hVar2.c((short) ((int) (j2 >> 48)));
                return;
            case 26:
                if (this.Shr) {
                    if (i4 > 65535) {
                        this.Shp.a(b.mG(27, i7), (short) i4, (short) (i4 >> 16));
                        return;
                    } else {
                        this.Shp.b(b.mG(i3, i7), (short) i4);
                        return;
                    }
                } else if (i4 > 65535) {
                    throw new j("string index out of bound: " + a.arZ(i4) + ", perhaps you need to enable force jumbo mode.");
                } else {
                    this.Shp.b(b.mG(i3, i7), (short) i4);
                    return;
                }
            case 27:
                this.Shp.a(b.mG(i3, i7), (short) i4, (short) (i4 >> 16));
                return;
            case 28:
            case 31:
            case 34:
            case PlayerException.EXCEPTION_IN_SETAUDIOEFFECT:
            case PlayerException.EXCEPTION_IN_RELEASE:
            case 98:
            case 99:
            case 100:
            case 101:
            case 102:
            case 103:
            case 104:
            case 105:
            case 106:
            case 107:
            case 108:
            case 109:
                this.Shp.b(b.mG(i3, i7), (short) i4);
                return;
            case 36:
            case 110:
            case 111:
            case 112:
            case 113:
            case 114:
                this.Shp.a(b.mG(i3, b.mH(0, 1)), (short) i4, b.W(i7, 0, 0, 0));
                return;
            case 38:
            case 43:
            case 44:
                switch (i3) {
                    case 43:
                    case 44:
                        h hVar3 = this.Shp;
                        hVar3.mF(i6, hVar3.apk);
                        break;
                }
                int i9 = i6 - this.Shp.apk;
                this.Shp.a(b.mG(i3, i7), (short) i9, (short) (i9 >> 16));
                return;
            case 56:
            case n.CTRL_INDEX:
            case 58:
            case bv.CTRL_INDEX:
            case 60:
            case PlayerException.EXCEPTION_TYPE_INITLIB:
                this.Shp.b(b.mG(i3, i7), b.mI(i6, this.Shp.apk));
                return;
        }
    }

    @Override // com.tencent.tinker.a.b.a.e
    public final void a(int i2, int i3, int i4, int i5, int i6, long j2, int i7, int i8) {
        if (this.Shr) {
            i6 = this.Shq.arY(i6);
        }
        switch (i3) {
            case 1:
            case 4:
            case 7:
            case 33:
            case 123:
            case 124:
            case 125:
            case 126:
            case TPOptionalID.OPTION_ID_BEFORE_BOOL_ENABLE_AUDIO_PASSTHROUGH:
            case 128:
            case 129:
            case 130:
            case TPCodecParamers.TP_PROFILE_MPEG2_AAC_HE:
            case 132:
            case 133:
            case g.CTRL_INDEX:
            case c.CTRL_INDEX:
            case r.CTRL_INDEX:
            case 137:
            case 138:
            case com.tencent.mm.plugin.appbrand.jsapi.p.b.CTRL_INDEX:
            case 140:
            case 141:
            case TbsListener.ErrorCode.NEEDDOWNLOAD_3:
            case TbsListener.ErrorCode.NEEDDOWNLOAD_4:
            case TbsListener.ErrorCode.NEEDDOWNLOAD_FALSE_6:
            case TbsListener.ErrorCode.NONEEDDOWNLOAD_OTHER_PROCESS_DOWNLOADING:
            case 178:
            case 179:
            case TXLiveConstants.RENDER_ROTATION_180:
            case 181:
            case 182:
            case 183:
            case 184:
            case 185:
            case 186:
            case 187:
            case 188:
            case 189:
            case FacebookRequestErrorClassification.EC_INVALID_TOKEN:
            case 191:
            case 192:
            case 193:
            case 194:
            case 195:
            case 196:
            case 197:
            case z.CTRL_INDEX:
            case 199:
            case 200:
            case 201:
            case 202:
            case 203:
            case 204:
            case 205:
            case 206:
            case 207:
                this.Shp.c(b.mG((short) i3, b.mH(i7, i8)));
                return;
            case 2:
            case 5:
            case 8:
                this.Shp.b(b.mG(i3, i7), b.arV(i8));
                return;
            case 3:
            case 6:
            case 9:
                this.Shp.a((short) i3, b.arU(i7), b.arV(i8));
                return;
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
            case 28:
            case 29:
            case 30:
            case 31:
            case 34:
            case 37:
            case 38:
            case 39:
            case 40:
            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_RIGHT_CREATOR:
            case 42:
            case 43:
            case 44:
            case 45:
            case 46:
            case 47:
            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE:
            case 49:
            case 56:
            case n.CTRL_INDEX:
            case 58:
            case bv.CTRL_INDEX:
            case 60:
            case PlayerException.EXCEPTION_TYPE_INITLIB:
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
            case TPCodecParamers.TP_PROFILE_H264_MAIN:
            case h.a.CTRL_INDEX:
            case 79:
            case PlayerException.EXCEPTION_TYPE_CONNECT_FAIL:
            case 81:
            case PlayerException.EXCEPTION_IN_SETAUDIOEFFECT:
            case PlayerException.EXCEPTION_IN_RELEASE:
            case 98:
            case 99:
            case 100:
            case 101:
            case 102:
            case 103:
            case 104:
            case 105:
            case 106:
            case 107:
            case 108:
            case 109:
            case 115:
            case 116:
            case 117:
            case 118:
            case 119:
            case 120:
            case 121:
            case 122:
            case 144:
            case 145:
            case 146:
            case TbsListener.ErrorCode.NEEDDOWNLOAD_8:
            case 148:
            case 149:
            case 150:
            case 151:
            case 152:
            case 153:
            case 154:
            case 155:
            case 156:
            case 157:
            case 158:
            case JsApiGetBackgroundAudioState.CTRL_INDEX:
            case 160:
            case 161:
            case TbsListener.ErrorCode.STARTDOWNLOAD_3:
            case TbsListener.ErrorCode.STARTDOWNLOAD_4:
            case TbsListener.ErrorCode.STARTDOWNLOAD_5:
            case TbsListener.ErrorCode.STARTDOWNLOAD_6:
            case 166:
            case TbsListener.ErrorCode.STARTDOWNLOAD_8:
            case 168:
            case 169:
            case TbsListener.ErrorCode.NEEDDOWNLOAD_TRUE:
            case TbsListener.ErrorCode.NEEDDOWNLOAD_FALSE_1:
            case 172:
            case TbsListener.ErrorCode.NEEDDOWNLOAD_FALSE_3:
            case TbsListener.ErrorCode.NEEDDOWNLOAD_FALSE_4:
            case TbsListener.ErrorCode.NEEDDOWNLOAD_FALSE_5:
            default:
                throw new IllegalStateException("unexpected opcode: " + a.asb(i3));
            case 32:
            case 35:
            case PlayerException.EXCEPTION_TYPE_ERROR_CREATE_JAVA_DATASOURCE:
            case 83:
            case com.tencent.mm.plugin.appbrand.jsapi.r.f.CTRL_INDEX:
            case s.CTRL_INDEX:
            case b.CTRL_INDEX:
            case 87:
            case TPCodecParamers.TP_PROFILE_H264_EXTENDED:
            case PlayerException.EXCEPTION_IN_CHECK_STATE:
            case 90:
            case PlayerException.EXCEPTION_IN_PREPARE:
            case 92:
            case PlayerException.EXCEPTION_IN_PAUSE:
            case 94:
            case PlayerException.EXCEPTION_IN_SEEK:
                this.Shp.b(b.mG(i3, b.mH(i7, i8)), (short) i4);
                return;
            case 36:
            case 110:
            case 111:
            case 112:
            case 113:
            case 114:
                this.Shp.a(b.mG(i3, b.mH(0, 2)), (short) i4, b.W(i7, i8, 0, 0));
                return;
            case 50:
            case 51:
            case 52:
            case 53:
            case 54:
            case 55:
                this.Shp.b(b.mG(i3, b.mH(i7, i8)), b.mI(i6, this.Shp.apk));
                return;
            case 208:
            case 209:
            case 210:
            case 211:
            case 212:
            case 213:
            case 214:
            case 215:
                this.Shp.b(b.mG(i3, b.mH(i7, i8)), b.OH(j2));
                return;
            case 216:
            case 217:
            case 218:
            case TbsListener.ErrorCode.RENAME_EXCEPTION:
            case TbsListener.ErrorCode.COPY_INSTALL_SUCCESS:
            case TbsListener.ErrorCode.INCRUPDATE_INSTALL_SUCCESS:
            case TbsListener.ErrorCode.UNLZMA_FAIURE:
            case TbsListener.ErrorCode.EXCEED_LZMA_RETRY_NUM:
            case TbsListener.ErrorCode.EXCEED_INCR_UPDATE:
            case TbsListener.ErrorCode.CREATE_TEMP_CONF_ERROR:
            case 226:
                h hVar = this.Shp;
                short mG = b.mG(i3, i7);
                if (j2 != ((long) ((byte) ((int) j2)))) {
                    throw new j("Literal out of range: " + a.OI(j2));
                }
                hVar.b(mG, b.mG(i8, ((int) j2) & 255));
                return;
        }
    }

    @Override // com.tencent.tinker.a.b.a.e
    public final void a(int i2, int i3, int i4, int i5, int i6, long j2, int i7, int i8, int i9) {
        switch (i3) {
            case 36:
            case 110:
            case 111:
            case 112:
            case 113:
            case 114:
                this.Shp.a(b.mG(i3, b.mH(0, 3)), (short) i4, b.W(i7, i8, i9, 0));
                return;
            case 37:
            case 38:
            case 39:
            case 40:
            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_RIGHT_CREATOR:
            case 42:
            case 43:
            case 44:
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
            case PlayerException.EXCEPTION_TYPE_INITLIB:
            case 62:
            case 63:
            case 64:
            case 65:
            case 66:
            case 67:
            case PlayerException.EXCEPTION_TYPE_ERROR_CREATE_JAVA_DATASOURCE:
            case 83:
            case com.tencent.mm.plugin.appbrand.jsapi.r.f.CTRL_INDEX:
            case s.CTRL_INDEX:
            case b.CTRL_INDEX:
            case 87:
            case TPCodecParamers.TP_PROFILE_H264_EXTENDED:
            case PlayerException.EXCEPTION_IN_CHECK_STATE:
            case 90:
            case PlayerException.EXCEPTION_IN_PREPARE:
            case 92:
            case PlayerException.EXCEPTION_IN_PAUSE:
            case 94:
            case PlayerException.EXCEPTION_IN_SEEK:
            case PlayerException.EXCEPTION_IN_SETAUDIOEFFECT:
            case PlayerException.EXCEPTION_IN_RELEASE:
            case 98:
            case 99:
            case 100:
            case 101:
            case 102:
            case 103:
            case 104:
            case 105:
            case 106:
            case 107:
            case 108:
            case 109:
            case 115:
            case 116:
            case 117:
            case 118:
            case 119:
            case 120:
            case 121:
            case 122:
            case 123:
            case 124:
            case 125:
            case 126:
            case TPOptionalID.OPTION_ID_BEFORE_BOOL_ENABLE_AUDIO_PASSTHROUGH:
            case 128:
            case 129:
            case 130:
            case TPCodecParamers.TP_PROFILE_MPEG2_AAC_HE:
            case 132:
            case 133:
            case g.CTRL_INDEX:
            case c.CTRL_INDEX:
            case r.CTRL_INDEX:
            case 137:
            case 138:
            case com.tencent.mm.plugin.appbrand.jsapi.p.b.CTRL_INDEX:
            case 140:
            case 141:
            case TbsListener.ErrorCode.NEEDDOWNLOAD_3:
            case TbsListener.ErrorCode.NEEDDOWNLOAD_4:
            default:
                throw new IllegalStateException("unexpected opcode: " + a.asb(i3));
            case 45:
            case 46:
            case 47:
            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE:
            case 49:
            case 68:
            case 69:
            case 70:
            case 71:
            case 72:
            case d.CTRL_INDEX:
            case 74:
            case 75:
            case WXMediaMessage.IMediaObject.TYPE_MUSIC_VIDEO:
            case TPCodecParamers.TP_PROFILE_H264_MAIN:
            case h.a.CTRL_INDEX:
            case 79:
            case PlayerException.EXCEPTION_TYPE_CONNECT_FAIL:
            case 81:
            case 144:
            case 145:
            case 146:
            case TbsListener.ErrorCode.NEEDDOWNLOAD_8:
            case 148:
            case 149:
            case 150:
            case 151:
            case 152:
            case 153:
            case 154:
            case 155:
            case 156:
            case 157:
            case 158:
            case JsApiGetBackgroundAudioState.CTRL_INDEX:
            case 160:
            case 161:
            case TbsListener.ErrorCode.STARTDOWNLOAD_3:
            case TbsListener.ErrorCode.STARTDOWNLOAD_4:
            case TbsListener.ErrorCode.STARTDOWNLOAD_5:
            case TbsListener.ErrorCode.STARTDOWNLOAD_6:
            case 166:
            case TbsListener.ErrorCode.STARTDOWNLOAD_8:
            case 168:
            case 169:
            case TbsListener.ErrorCode.NEEDDOWNLOAD_TRUE:
            case TbsListener.ErrorCode.NEEDDOWNLOAD_FALSE_1:
            case 172:
            case TbsListener.ErrorCode.NEEDDOWNLOAD_FALSE_3:
            case TbsListener.ErrorCode.NEEDDOWNLOAD_FALSE_4:
            case TbsListener.ErrorCode.NEEDDOWNLOAD_FALSE_5:
                this.Shp.b(b.mG(i3, i7), b.mG(i8, i9));
                return;
        }
    }

    @Override // com.tencent.tinker.a.b.a.e
    public final void a(int i2, int i3, int i4, int i5, int i6, long j2, int i7, int i8, int i9, int i10) {
        switch (i3) {
            case 36:
            case 110:
            case 111:
            case 112:
            case 113:
            case 114:
                this.Shp.a(b.mG(i3, b.mH(0, 4)), (short) i4, b.W(i7, i8, i9, i10));
                return;
            default:
                throw new IllegalStateException("unexpected opcode: " + a.asb(i3));
        }
    }

    @Override // com.tencent.tinker.a.b.a.e
    public final void a(int i2, int i3, int i4, int i5, int i6, long j2, int i7, int i8, int i9, int i10, int i11) {
        switch (i3) {
            case 36:
            case 110:
            case 111:
            case 112:
            case 113:
            case 114:
                this.Shp.a(b.mG(i3, b.mH(i11, 5)), (short) i4, b.W(i7, i8, i9, i10));
                return;
            default:
                throw new IllegalStateException("unexpected opcode: " + a.asb(i3));
        }
    }

    @Override // com.tencent.tinker.a.b.a.e
    public final void b(int i2, int i3, int i4, int i5, int i6, long j2, int i7, int i8) {
        switch (i3) {
            case 37:
            case 116:
            case 117:
            case 118:
            case 119:
            case 120:
                this.Shp.a(b.mG(i3, i8), (short) i4, b.arU(i7));
                return;
            default:
                throw new IllegalStateException("unexpected opcode: " + a.asb(i3));
        }
    }

    @Override // com.tencent.tinker.a.b.a.e
    public final void a(int i2, int i3, int[] iArr, int[] iArr2) {
        int i4 = 0;
        int hoX = this.Shp.hoX();
        this.Shp.c((short) i3);
        this.Shp.c(b.arS(iArr2.length));
        for (int i5 : iArr) {
            this.Shp.writeInt(i5);
        }
        if (this.Shr) {
            int length = iArr2.length;
            while (i4 < length) {
                this.Shp.writeInt(this.Shq.arY(iArr2[i4]) - hoX);
                i4++;
            }
            return;
        }
        int length2 = iArr2.length;
        while (i4 < length2) {
            this.Shp.writeInt(iArr2[i4] - hoX);
            i4++;
        }
    }

    @Override // com.tencent.tinker.a.b.a.e
    public final void a(int i2, int i3, int i4, int[] iArr) {
        int i5 = 0;
        int hoX = this.Shp.hoX();
        this.Shp.c((short) i3);
        this.Shp.c(b.arS(iArr.length));
        this.Shp.writeInt(i4);
        if (this.Shr) {
            int length = iArr.length;
            while (i5 < length) {
                this.Shp.writeInt(this.Shq.arY(iArr[i5]) - hoX);
                i5++;
            }
            return;
        }
        int length2 = iArr.length;
        while (i5 < length2) {
            this.Shp.writeInt(iArr[i5] - hoX);
            i5++;
        }
    }

    @Override // com.tencent.tinker.a.b.a.e
    public final void a(int i2, int i3, Object obj, int i4, int i5) {
        int i6 = 0;
        this.Shp.c((short) i3);
        this.Shp.c((short) i5);
        this.Shp.writeInt(i4);
        switch (i5) {
            case 1:
                h hVar = this.Shp;
                byte[] bArr = (byte[]) obj;
                boolean z = true;
                int i7 = 0;
                for (byte b2 : bArr) {
                    if (z) {
                        i7 = b2 & 255;
                        z = false;
                    } else {
                        i7 |= b2 << 8;
                        hVar.c((short) i7);
                        z = true;
                    }
                }
                if (!z) {
                    hVar.c((short) i7);
                    return;
                }
                return;
            case 2:
                h hVar2 = this.Shp;
                short[] sArr = (short[]) obj;
                int length = sArr.length;
                while (i6 < length) {
                    hVar2.c(sArr[i6]);
                    i6++;
                }
                return;
            case 3:
            case 5:
            case 6:
            case 7:
            default:
                throw new j("bogus element_width: " + a.asa(i5));
            case 4:
                h hVar3 = this.Shp;
                int[] iArr = (int[]) obj;
                int length2 = iArr.length;
                while (i6 < length2) {
                    hVar3.writeInt(iArr[i6]);
                    i6++;
                }
                return;
            case 8:
                h hVar4 = this.Shp;
                long[] jArr = (long[]) obj;
                int length3 = jArr.length;
                while (i6 < length3) {
                    long j2 = jArr[i6];
                    hVar4.c((short) ((int) j2));
                    hVar4.c((short) ((int) (j2 >> 16)));
                    hVar4.c((short) ((int) (j2 >> 32)));
                    hVar4.c((short) ((int) (j2 >> 48)));
                    i6++;
                }
                return;
        }
    }
}

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
import com.tencent.mm.plugin.appbrand.jsapi.pay.n;
import com.tencent.mm.plugin.appbrand.jsapi.pay.s;
import com.tencent.mm.plugin.appbrand.jsapi.r.f;
import com.tencent.mm.plugin.appbrand.jsapi.share.d;
import com.tencent.qqmusic.mediaplayer.PlayerException;
import com.tencent.rtmp.TXLiveConstants;
import com.tencent.smtt.sdk.TbsListener;
import com.tencent.thumbplayer.api.TPOptionalID;
import com.tencent.thumbplayer.core.common.TPCodecParamers;
import com.tencent.tinker.a.a.j;
import com.tencent.tinker.a.b.b.a;

public final class b {
    public static short mG(int i2, int i3) {
        if ((i2 & -256) != 0) {
            throw new IllegalArgumentException("bogus lowByte");
        } else if ((i3 & -256) == 0) {
            return (short) ((i3 << 8) | i2);
        } else {
            throw new IllegalArgumentException("bogus highByte");
        }
    }

    public static short W(int i2, int i3, int i4, int i5) {
        if ((i2 & -16) != 0) {
            throw new IllegalArgumentException("bogus nibble0");
        } else if ((i3 & -16) != 0) {
            throw new IllegalArgumentException("bogus nibble1");
        } else if ((i4 & -16) != 0) {
            throw new IllegalArgumentException("bogus nibble2");
        } else if ((i5 & -16) == 0) {
            return (short) ((i3 << 4) | i2 | (i4 << 8) | (i5 << 12));
        } else {
            throw new IllegalArgumentException("bogus nibble3");
        }
    }

    public static int mH(int i2, int i3) {
        if ((i2 & -16) != 0) {
            throw new IllegalArgumentException("bogus lowNibble");
        } else if ((i3 & -16) == 0) {
            return (i3 << 4) | i2;
        } else {
            throw new IllegalArgumentException("bogus highNibble");
        }
    }

    public static short arS(int i2) {
        if ((-65536 & i2) == 0) {
            return (short) i2;
        }
        throw new IllegalArgumentException("bogus unsigned code unit");
    }

    public static int arT(int i2) {
        return (i2 >> 8) & 255;
    }

    public static short OH(long j2) {
        if (j2 == ((long) ((short) ((int) j2)))) {
            return (short) ((int) j2);
        }
        throw new j("Literal out of range: " + a.OI(j2));
    }

    public static short arU(int i2) {
        if ((-65536 & i2) == 0) {
            return (short) i2;
        }
        throw new j("Register A out of range: " + a.OI((long) i2));
    }

    public static short arV(int i2) {
        if ((-65536 & i2) == 0) {
            return (short) i2;
        }
        throw new j("Register B out of range: " + a.OI((long) i2));
    }

    public static int arW(int i2) {
        switch (i2) {
            case -1:
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
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
            case 29:
            case 30:
            case 33:
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
            case 208:
            case 209:
            case 210:
            case 211:
            case 212:
            case 213:
            case 214:
            case 215:
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
            case 256:
            case 512:
            case 768:
                return 1;
            case 26:
            case 27:
                return 3;
            case 28:
            case 31:
            case 32:
            case 34:
            case 35:
            case 36:
            case 37:
                return 2;
            case PlayerException.EXCEPTION_TYPE_ERROR_CREATE_JAVA_DATASOURCE:
            case 83:
            case f.CTRL_INDEX:
            case s.CTRL_INDEX:
            case com.tencent.mm.plugin.appbrand.jsapi.pay.b.CTRL_INDEX:
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
                return 5;
            case 110:
            case 111:
            case 112:
            case 113:
            case 114:
            case 116:
            case 117:
            case 118:
            case 119:
            case 120:
                return 4;
            default:
                return 0;
        }
    }

    public static short mI(int i2, int i3) {
        int i4 = i2 - i3;
        if (i4 == ((short) i4)) {
            return (short) i4;
        }
        throw new j("Target out of range: " + a.asc(i4) + ", perhaps you need to enable force jumbo mode.");
    }
}

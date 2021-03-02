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
import com.tencent.mm.plugin.appbrand.jsapi.p.b;
import com.tencent.mm.plugin.appbrand.jsapi.p.z;
import com.tencent.mm.plugin.appbrand.jsapi.pay.n;
import com.tencent.mm.plugin.appbrand.jsapi.pay.s;
import com.tencent.mm.plugin.appbrand.jsapi.r.f;
import com.tencent.qqmusic.mediaplayer.PlayerException;
import com.tencent.rtmp.TXLiveConstants;
import com.tencent.smtt.sdk.TbsListener;
import com.tencent.thumbplayer.api.TPOptionalID;
import com.tencent.thumbplayer.core.common.TPCodecParamers;
import com.tencent.tinker.a.a.j;
import com.tencent.tinker.a.b.b.a;

public final class d {
    private final g Shn;

    public d(g gVar) {
        this.Shn = gVar;
    }

    public final void a(e eVar) {
        boolean z;
        g gVar = this.Shn;
        gVar.Shk.mSize = 0;
        gVar.apk = 0;
        while (true) {
            g gVar2 = this.Shn;
            if (gVar2.apk < gVar2.Shs.length) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                int i2 = this.Shn.apk;
                int read = this.Shn.read();
                int i3 = read & 255;
                if (i3 == 0 || i3 == 255) {
                    i3 = read;
                }
                switch (i3) {
                    case -1:
                        eVar.a(i2, read, 0, 1, 0, 0);
                        break;
                    case 0:
                    case 14:
                        eVar.a(i2, read & 255, 0, 1, 0, (long) b.arT(read));
                        break;
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
                    case b.CTRL_INDEX:
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
                        eVar.a(i2, read & 255, 0, 1, 0, 0, (read >> 8) & 15, (read >> 12) & 15);
                        break;
                    case 2:
                    case 5:
                    case 8:
                        eVar.a(i2, read & 255, 0, 1, 0, 0, b.arT(read), this.Shn.read());
                        break;
                    case 3:
                    case 6:
                    case 9:
                        eVar.a(i2, read & 255, 0, 1, 0, (long) b.arT(read), this.Shn.read(), this.Shn.read());
                        break;
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
                        eVar.a(i2, read & 255, 0, 1, 0, 0, b.arT(read));
                        break;
                    case 18:
                        eVar.a(i2, read & 255, 0, 1, 0, (long) ((((read >> 12) & 15) << 28) >> 28), (read >> 8) & 15);
                        break;
                    case 19:
                    case 22:
                        eVar.a(i2, read & 255, 0, 1, 0, (long) ((short) this.Shn.read()), b.arT(read));
                        break;
                    case 20:
                    case 23:
                        eVar.a(i2, read & 255, 0, 1, 0, (long) this.Shn.readInt(), b.arT(read));
                        break;
                    case 21:
                    case 25:
                        int i4 = read & 255;
                        eVar.a(i2, i4, 0, 1, 0, ((long) ((short) this.Shn.read())) << (i4 == 21 ? 16 : '0'), b.arT(read));
                        break;
                    case 24:
                        eVar.a(i2, read & 255, 0, 1, 0, this.Shn.readLong(), b.arT(read));
                        break;
                    case 26:
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
                        int i5 = read & 255;
                        eVar.a(i2, i5, this.Shn.read(), b.arW(i5), 0, 0, b.arT(read));
                        break;
                    case 27:
                        int i6 = read & 255;
                        eVar.a(i2, i6, this.Shn.readInt(), b.arW(i6), 0, 0, b.arT(read));
                        break;
                    case 32:
                    case 35:
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
                        int i7 = read & 255;
                        eVar.a(i2, i7, this.Shn.read(), b.arW(i7), 0, 0, (read >> 8) & 15, (read >> 12) & 15);
                        break;
                    case 36:
                    case 110:
                    case 111:
                    case 112:
                    case 113:
                    case 114:
                        int i8 = read & 255;
                        int i9 = (read >> 8) & 15;
                        int i10 = (read >> 12) & 15;
                        int read2 = this.Shn.read();
                        int read3 = this.Shn.read();
                        int i11 = read3 & 15;
                        int i12 = (read3 >> 4) & 15;
                        int i13 = (read3 >> 8) & 15;
                        int i14 = (read3 >> 12) & 15;
                        int arW = b.arW(i8);
                        switch (i10) {
                            case 0:
                                eVar.a(i2, i8, read2, arW, 0, 0);
                                continue;
                            case 1:
                                eVar.a(i2, i8, read2, arW, 0, 0, i11);
                                continue;
                            case 2:
                                eVar.a(i2, i8, read2, arW, 0, 0, i11, i12);
                                continue;
                            case 3:
                                eVar.a(i2, i8, read2, arW, 0, 0, i11, i12, i13);
                                continue;
                            case 4:
                                eVar.a(i2, i8, read2, arW, 0, 0, i11, i12, i13, i14);
                                continue;
                            case 5:
                                eVar.a(i2, i8, read2, arW, 0, 0, i11, i12, i13, i14, i9);
                                continue;
                            default:
                                throw new j("bogus registerCount: " + new String(new char[]{Character.forDigit(i10 & 15, 16)}));
                        }
                    case 37:
                    case 116:
                    case 117:
                    case 118:
                    case 119:
                    case 120:
                        int i15 = read & 255;
                        eVar.b(i2, i15, this.Shn.read(), b.arW(i15), 0, 0, this.Shn.read(), b.arT(read));
                        break;
                    case 38:
                    case 43:
                    case 44:
                        int i16 = read & 255;
                        int arT = b.arT(read);
                        int readInt = i2 + this.Shn.readInt();
                        switch (i16) {
                            case 43:
                            case 44:
                                this.Shn.mF(readInt + 1, i2);
                                break;
                        }
                        eVar.a(i2, i16, 0, 1, readInt, 0, arT);
                        break;
                    case 40:
                        eVar.a(i2, read & 255, 0, 1, i2 + ((byte) b.arT(read)), 0);
                        break;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_RIGHT_CREATOR:
                        eVar.a(i2, read & 255, 0, 1, i2 + ((short) this.Shn.read()), (long) b.arT(read));
                        break;
                    case 42:
                        eVar.a(i2, read & 255, 0, 1, i2 + this.Shn.readInt(), (long) b.arT(read));
                        break;
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
                    case com.tencent.mm.plugin.appbrand.jsapi.share.d.CTRL_INDEX:
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
                        int arT2 = b.arT(read);
                        int read4 = this.Shn.read();
                        eVar.a(i2, read & 255, 0, 1, 0, 0, arT2, read4 & 255, b.arT(read4));
                        break;
                    case 50:
                    case 51:
                    case 52:
                    case 53:
                    case 54:
                    case 55:
                        eVar.a(i2, read & 255, 0, 1, i2 + ((short) this.Shn.read()), 0, (read >> 8) & 15, (read >> 12) & 15);
                        break;
                    case 56:
                    case n.CTRL_INDEX:
                    case 58:
                    case bv.CTRL_INDEX:
                    case 60:
                    case PlayerException.EXCEPTION_TYPE_INITLIB:
                        eVar.a(i2, read & 255, 0, 1, i2 + ((short) this.Shn.read()), 0, b.arT(read));
                        break;
                    case 208:
                    case 209:
                    case 210:
                    case 211:
                    case 212:
                    case 213:
                    case 214:
                    case 215:
                        eVar.a(i2, read & 255, 0, 1, 0, (long) ((short) this.Shn.read()), (read >> 8) & 15, (read >> 12) & 15);
                        break;
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
                        int arT3 = b.arT(read);
                        int read5 = this.Shn.read();
                        eVar.a(i2, read & 255, 0, 1, 0, (long) ((byte) b.arT(read5)), arT3, read5 & 255);
                        break;
                    case 256:
                        int hoX = this.Shn.hoX();
                        int read6 = this.Shn.read();
                        int readInt2 = this.Shn.readInt();
                        int[] iArr = new int[read6];
                        for (int i17 = 0; i17 < read6; i17++) {
                            iArr[i17] = this.Shn.readInt() + hoX;
                        }
                        eVar.a(i2, read, readInt2, iArr);
                        break;
                    case 512:
                        int hoX2 = this.Shn.hoX();
                        int read7 = this.Shn.read();
                        int[] iArr2 = new int[read7];
                        int[] iArr3 = new int[read7];
                        for (int i18 = 0; i18 < read7; i18++) {
                            iArr2[i18] = this.Shn.readInt();
                        }
                        for (int i19 = 0; i19 < read7; i19++) {
                            iArr3[i19] = this.Shn.readInt() + hoX2;
                        }
                        eVar.a(i2, read, iArr2, iArr3);
                        break;
                    case 768:
                        int read8 = this.Shn.read();
                        int readInt3 = this.Shn.readInt();
                        switch (read8) {
                            case 1:
                                byte[] bArr = new byte[readInt3];
                                int i20 = 0;
                                int i21 = 0;
                                boolean z2 = true;
                                while (i21 < readInt3) {
                                    if (z2) {
                                        i20 = this.Shn.read();
                                    }
                                    bArr[i21] = (byte) (i20 & 255);
                                    i21++;
                                    i20 >>= 8;
                                    z2 = !z2;
                                }
                                eVar.a(i2, read, bArr, bArr.length, 1);
                                continue;
                            case 2:
                                short[] sArr = new short[readInt3];
                                for (int i22 = 0; i22 < readInt3; i22++) {
                                    sArr[i22] = (short) this.Shn.read();
                                }
                                eVar.a(i2, read, sArr, sArr.length, 2);
                                continue;
                            case 3:
                            case 5:
                            case 6:
                            case 7:
                            default:
                                throw new j("bogus element_width: " + a.asa(read8));
                            case 4:
                                int[] iArr4 = new int[readInt3];
                                for (int i23 = 0; i23 < readInt3; i23++) {
                                    iArr4[i23] = this.Shn.readInt();
                                }
                                eVar.a(i2, read, iArr4, iArr4.length, 4);
                                continue;
                            case 8:
                                long[] jArr = new long[readInt3];
                                for (int i24 = 0; i24 < readInt3; i24++) {
                                    jArr[i24] = this.Shn.readLong();
                                }
                                eVar.a(i2, read, jArr, jArr.length, 8);
                                continue;
                        }
                    default:
                        throw new IllegalStateException("Unknown opcode: " + a.arZ(i3));
                }
            } else {
                return;
            }
        }
    }
}

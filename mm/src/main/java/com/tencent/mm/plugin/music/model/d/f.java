package com.tencent.mm.plugin.music.model.d;

import android.text.TextUtils;
import com.facebook.internal.FacebookRequestErrorClassification;
import com.pay.tool.APPluginConstants;
import com.tencent.liteav.TXLiteAVCode;
import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.aa;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.q;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiGetBackgroundAudioState;
import com.tencent.mm.plugin.appbrand.jsapi.lab.JsApiSetLabInfo;
import com.tencent.mm.plugin.appbrand.jsapi.p.z;
import com.tencent.mm.plugin.music.c.b;
import com.tencent.mm.plugin.music.cache.g;
import com.tencent.mm.plugin.music.e.d;
import com.tencent.mm.plugin.music.e.k;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.crv;
import com.tencent.mm.protocal.protobuf.dnu;
import com.tencent.mm.protocal.protobuf.dnv;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.rtmp.TXLiveConstants;
import com.tencent.smtt.sdk.TbsListener;
import com.tencent.tav.decoder.EncoderWriter;
import java.util.ArrayList;

public final class f implements d {
    private g AlB = new g();
    private d AlC = new d();
    private a AlD = new a();
    private com.tencent.mm.ay.d AlE = null;

    public f() {
        AppMethodBeat.i(63156);
        AppMethodBeat.o(63156);
    }

    @Override // com.tencent.mm.plugin.music.e.d
    public final void v(com.tencent.mm.ay.f fVar) {
        AppMethodBeat.i(63157);
        e.a(fVar, false);
        AppMethodBeat.o(63157);
    }

    @Override // com.tencent.mm.plugin.music.e.d
    public final void etX() {
        AppMethodBeat.i(63160);
        d dVar = this.AlC;
        Log.i("MicroMsg.Music.MusicPlayerReportImpl", "initIdKeyStatDataForMusicPlayer");
        dVar.Alm = false;
        dVar.Aln = false;
        dVar.Alo = false;
        dVar.Alp = false;
        dVar.Alq = false;
        dVar.Alr = false;
        dVar.Als = false;
        dVar.Alt = false;
        dVar.Alu = false;
        dVar.Alv = 0;
        AppMethodBeat.o(63160);
    }

    @Override // com.tencent.mm.plugin.music.e.d
    public final void a(b bVar) {
        this.AlC.Alw = bVar;
    }

    @Override // com.tencent.mm.plugin.music.e.d
    public final void c(com.tencent.mm.ay.f fVar, int i2, int i3) {
        int i4;
        boolean z;
        int i5;
        int i6;
        int i7;
        AppMethodBeat.i(63161);
        d dVar = this.AlC;
        IDKey iDKey = new IDKey();
        iDKey.SetID(JsApiSetLabInfo.CTRL_INDEX);
        iDKey.SetKey(3);
        iDKey.SetValue(1);
        IDKey iDKey2 = new IDKey();
        iDKey2.SetID(JsApiSetLabInfo.CTRL_INDEX);
        int i8 = fVar.jeT;
        Log.i("MicroMsg.Music.MusicPlayIdKeyReport", "getMusicPlayerErrIdKeyByMusicType, musicType:".concat(String.valueOf(i8)));
        switch (i8) {
            case 0:
                i4 = 60;
                break;
            case 1:
                i4 = 61;
                break;
            case 2:
            case 3:
            default:
                i4 = 6;
                break;
            case 4:
                i4 = 62;
                break;
            case 5:
                i4 = 63;
                break;
            case 6:
                i4 = 64;
                break;
            case 7:
                i4 = 5;
                break;
            case 8:
                i4 = 65;
                break;
            case 9:
                i4 = 66;
                break;
        }
        iDKey2.SetKey(i4);
        iDKey2.SetValue(1);
        IDKey iDKey3 = new IDKey();
        iDKey3.SetID(JsApiSetLabInfo.CTRL_INDEX);
        if (i2 == -1) {
            iDKey3.SetKey(12);
        } else if (i2 == 6) {
            iDKey3.SetKey(46);
        } else if (i2 == -2) {
            iDKey3.SetKey(13);
        } else if (i2 == 5) {
            iDKey3.SetKey(16);
        } else if (i2 == 4) {
            iDKey3.SetKey(14);
        } else if (i2 == 20) {
            iDKey3.SetKey(11);
        } else if (i2 == 21) {
            iDKey3.SetKey(47);
        } else if (i2 == 19) {
            iDKey3.SetKey(FacebookRequestErrorClassification.EC_INVALID_TOKEN);
        }
        iDKey3.SetValue(1);
        ArrayList<IDKey> arrayList = new ArrayList<>();
        IDKey iDKey4 = new IDKey();
        iDKey4.SetID(JsApiSetLabInfo.CTRL_INDEX);
        iDKey4.SetValue(1);
        if (i2 != 19 && (dVar.getMimeType() == null || !dVar.getMimeType().contains("text/html"))) {
            if (i2 == 21) {
                int i9 = fVar.jeT;
                Log.i("MicroMsg.Music.MusicPlayIdKeyReport", "getMusicPlayerPlayErrIdKeyByMusicType, musicType:".concat(String.valueOf(i9)));
                switch (i9) {
                    case 0:
                        i7 = JsApiGetBackgroundAudioState.CTRL_INDEX;
                        break;
                    case 1:
                        i7 = 160;
                        break;
                    case 2:
                    case 3:
                    case 5:
                    default:
                        i7 = 188;
                        break;
                    case 4:
                        i7 = 161;
                        break;
                    case 6:
                        i7 = TbsListener.ErrorCode.STARTDOWNLOAD_3;
                        break;
                    case 7:
                        i7 = TbsListener.ErrorCode.STARTDOWNLOAD_4;
                        break;
                    case 8:
                        i7 = TbsListener.ErrorCode.STARTDOWNLOAD_5;
                        break;
                    case 9:
                        i7 = TbsListener.ErrorCode.STARTDOWNLOAD_6;
                        break;
                }
                iDKey4.SetKey(i7);
                arrayList.add(iDKey4);
            } else if (i2 == -1 || i2 == 6 || i2 == -2 || i2 == 5 || i2 == 4) {
                int i10 = fVar.jeT;
                Log.i("MicroMsg.Music.MusicPlayIdKeyReport", "getMusicPlayerNetworkErrIdKeyByMusicType, musicType:".concat(String.valueOf(i10)));
                switch (i10) {
                    case 0:
                        i6 = 151;
                        break;
                    case 1:
                        i6 = 152;
                        break;
                    case 2:
                    case 3:
                    case 5:
                    default:
                        i6 = 188;
                        break;
                    case 4:
                        i6 = 153;
                        break;
                    case 6:
                        i6 = 154;
                        break;
                    case 7:
                        i6 = 155;
                        break;
                    case 8:
                        i6 = 156;
                        break;
                    case 9:
                        i6 = 157;
                        break;
                }
                iDKey4.SetKey(i6);
                arrayList.add(iDKey4);
            }
        }
        arrayList.add(iDKey);
        arrayList.add(iDKey2);
        arrayList.add(iDKey3);
        Log.i("MicroMsg.Music.MusicPlayerReportImpl", "hasStatForHttpErr:%b, hasStatForUrlErr:%b, hasStatForNetworkErr:%b, hasStatForHttpRangeErr:%b, hasStatDownloadExceptionErr:%b", Boolean.valueOf(dVar.Alm), Boolean.valueOf(dVar.Alo), Boolean.valueOf(dVar.Alr), Boolean.valueOf(dVar.Aln), Boolean.valueOf(dVar.Alp));
        if (i2 == -1 && !dVar.Alm) {
            dVar.Alm = true;
            int i11 = 0;
            if (dVar.Alw != null) {
                i11 = dVar.Alw.Ajd;
            }
            if (i11 == 403) {
                IDKey iDKey5 = new IDKey();
                iDKey5.SetID(JsApiSetLabInfo.CTRL_INDEX);
                iDKey5.SetValue(1);
                iDKey5.SetKey(c.SU(700));
                arrayList.add(iDKey5);
            }
            h.INSTANCE.b(arrayList, true);
            h.INSTANCE.a(14777, 0, Integer.valueOf(fVar.jeT), 1, Integer.valueOf(i2), Integer.valueOf(i11), 0);
        }
        if (i2 == 6 && !dVar.Aln) {
            dVar.Aln = true;
            h.INSTANCE.b(arrayList, true);
            h.INSTANCE.a(14777, 0, Integer.valueOf(fVar.jeT), 1, Integer.valueOf(i2), 0, 0);
        }
        if (i2 == -2 && !dVar.Alo) {
            dVar.Alo = true;
            h.INSTANCE.b(arrayList, true);
            h.INSTANCE.a(14777, 0, Integer.valueOf(fVar.jeT), 1, Integer.valueOf(i2), 0, 0);
        }
        if (i2 == 5 && !dVar.Alp) {
            dVar.Alp = true;
            h.INSTANCE.b(arrayList, true);
            int i12 = 0;
            if (dVar.Alw != null) {
                i12 = dVar.Alw.dvm;
            }
            h.INSTANCE.a(14777, 0, Integer.valueOf(fVar.jeT), 1, Integer.valueOf(i2), 0, Integer.valueOf(i12));
        }
        if (i2 == 19 && !dVar.Alq) {
            dVar.Alq = true;
            h.INSTANCE.b(arrayList, true);
            h.INSTANCE.a(14777, 0, Integer.valueOf(fVar.jeT), 1, Integer.valueOf(i2), 0, 0);
        }
        if (i2 == 4 && !dVar.Alr) {
            dVar.Alr = true;
            h.INSTANCE.b(arrayList, true);
            h.INSTANCE.a(14777, 0, Integer.valueOf(fVar.jeT), 1, Integer.valueOf(i2), 0, 0);
        }
        if (i2 == 20 && !dVar.Als) {
            dVar.Als = true;
            dVar.Alv = i3;
            ArrayList<IDKey> arrayList2 = new ArrayList<>();
            arrayList2.add(iDKey3);
            h.INSTANCE.b(arrayList2, true);
        }
        if (i2 == 21 && !dVar.Alt && dVar.Als) {
            dVar.Alt = true;
            if (dVar.getMimeType() == null || !dVar.getMimeType().contains("text/html")) {
                IDKey iDKey6 = new IDKey();
                iDKey6.SetID(JsApiSetLabInfo.CTRL_INDEX);
                iDKey6.SetValue(1);
                iDKey6.SetKey(c.SU(i3));
                arrayList.add(iDKey6);
                switch (i3) {
                    case 704:
                    case 705:
                    case 706:
                        z = true;
                        break;
                    default:
                        z = false;
                        break;
                }
                if (z) {
                    IDKey iDKey7 = new IDKey();
                    iDKey7.SetID(JsApiSetLabInfo.CTRL_INDEX);
                    iDKey7.SetValue(1);
                    int i13 = fVar.jeT;
                    Log.i("MicroMsg.Music.MusicPlayIdKeyReport", "getMusicPlayerDecodeErrIdKeyByMusicType, musicType:".concat(String.valueOf(i13)));
                    switch (i13) {
                        case 0:
                            i5 = 194;
                            break;
                        case 1:
                            i5 = 195;
                            break;
                        case 2:
                        case 3:
                        case 5:
                        default:
                            i5 = 188;
                            break;
                        case 4:
                            i5 = 196;
                            break;
                        case 6:
                            i5 = 197;
                            break;
                        case 7:
                            i5 = z.CTRL_INDEX;
                            break;
                        case 8:
                            i5 = 199;
                            break;
                        case 9:
                            i5 = 200;
                            break;
                    }
                    iDKey7.SetKey(i5);
                    arrayList.add(iDKey7);
                }
            } else {
                i3 = 701;
                IDKey iDKey8 = new IDKey();
                iDKey8.SetID(JsApiSetLabInfo.CTRL_INDEX);
                iDKey8.SetValue(1);
                iDKey8.SetKey(c.SU(701));
                arrayList.add(iDKey8);
            }
            h.INSTANCE.b(arrayList, true);
            h.INSTANCE.a(14777, 0, Integer.valueOf(fVar.jeT), 0, Integer.valueOf(i2), Integer.valueOf(i3), 0);
        }
        AppMethodBeat.o(63161);
    }

    @Override // com.tencent.mm.plugin.music.e.d
    public final void a(com.tencent.mm.ay.f fVar, String str) {
        int i2;
        AppMethodBeat.i(63162);
        d dVar = this.AlC;
        if (TextUtils.isEmpty(str) && dVar.Alw != null) {
            str = dVar.getMimeType();
        }
        Log.i("MicroMsg.Music.MusicPlayerReportImpl", "idKeyReportMusicMimeType mineType:%s, hasStatForMimeType:%b", str, Boolean.valueOf(dVar.Alu));
        if (!TextUtils.isEmpty(str) && !dVar.Alu) {
            Log.i("MicroMsg.Music.MusicPlayerReportImpl", "idKeyReportMusicMimeType OK");
            dVar.Alu = true;
            IDKey iDKey = new IDKey();
            iDKey.SetID(JsApiSetLabInfo.CTRL_INDEX);
            if ("audio/3gpp".equalsIgnoreCase(str)) {
                i2 = 70;
            } else if ("audio/amr-wb".equalsIgnoreCase(str)) {
                i2 = 71;
            } else if ("audio/mpeg".equalsIgnoreCase(str) || str.equalsIgnoreCase("audio/mp3")) {
                i2 = 72;
            } else if (EncoderWriter.OUTPUT_AUDIO_MIME_TYPE.equalsIgnoreCase(str) || str.startsWith("audio/mp4")) {
                i2 = 73;
            } else if ("audio/qcelp".equalsIgnoreCase(str)) {
                i2 = 74;
            } else if ("audio/vorbis".equalsIgnoreCase(str)) {
                i2 = 75;
            } else if ("audio/opus".equalsIgnoreCase(str)) {
                i2 = 76;
            } else if ("audio/g711-alaw".equalsIgnoreCase(str)) {
                i2 = 77;
            } else if ("audio/g711-mlaw".equalsIgnoreCase(str)) {
                i2 = 78;
            } else if ("audio/raw".equalsIgnoreCase(str)) {
                i2 = 79;
            } else if ("audio/flac".equalsIgnoreCase(str)) {
                i2 = 80;
            } else if ("audio/gsm".equalsIgnoreCase(str)) {
                i2 = 81;
            } else if ("audio/ac3".equalsIgnoreCase(str)) {
                i2 = 82;
            } else if ("audio/eac3".equalsIgnoreCase(str)) {
                i2 = 83;
            } else if ("audio/x-ms-wma".equalsIgnoreCase(str)) {
                i2 = 84;
            } else if ("audio/x-wav".equalsIgnoreCase(str)) {
                i2 = 85;
            } else if ("audio/x-ape".equalsIgnoreCase(str) || "application/x-ape".equalsIgnoreCase(str)) {
                i2 = 86;
            } else {
                i2 = 87;
            }
            iDKey.SetKey(i2);
            iDKey.SetValue(1);
            ArrayList<IDKey> arrayList = new ArrayList<>();
            arrayList.add(iDKey);
            h.INSTANCE.b(arrayList, true);
            if (fVar != null) {
                int aHV = c.aHV(str);
                h.INSTANCE.a(14486, 0, Integer.valueOf(fVar.jeT), Integer.valueOf(aHV), str);
            }
        }
        AppMethodBeat.o(63162);
    }

    @Override // com.tencent.mm.plugin.music.e.d
    public final void a(com.tencent.mm.ay.f fVar, long j2, long j3, long j4) {
        AppMethodBeat.i(63165);
        if (fVar != null) {
            Log.i("MicroMsg.Music.MusicWechatReportService", "scene:%d, endPosition:%d, totalPlayTime:%d, duration:%d", Integer.valueOf(fVar.jeT), Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4));
            if (fVar.jeT == 10) {
                ad(j2, j3);
            }
        }
        AppMethodBeat.o(63165);
    }

    @Override // com.tencent.mm.plugin.music.e.d
    public final void a(com.tencent.mm.ay.d dVar) {
        AppMethodBeat.i(63166);
        Log.i("MicroMsg.Music.MusicWechatReportService", "reportMusicPlayerTime");
        if (dVar != null) {
            Log.i("MicroMsg.Music.MusicWechatReportService", "MusicReportInfo h5CurrentMusicIDOfReport:%s, h5ReportListIDOfReport:%s", dVar.jeR, dVar.jeS);
        }
        com.tencent.mm.ay.f etU = k.euj().etU();
        if (!k.euj().etW().bec() || etU == null || etU.jeT != 10) {
            this.AlE = dVar;
            Log.i("MicroMsg.Music.MusicWechatReportService", "report music info");
            ad(0, 0);
            AppMethodBeat.o(63166);
            return;
        }
        this.AlE = dVar;
        Log.i("MicroMsg.Music.MusicWechatReportService", "H5 music is playing, not report first");
        AppMethodBeat.o(63166);
    }

    private void ad(long j2, long j3) {
        AppMethodBeat.i(63167);
        d.a aVar = new d.a();
        aVar.iLN = new dnu();
        aVar.iLO = new dnv();
        aVar.uri = "/cgi-bin/mmbiz-bin/reportmusic";
        aVar.funcId = 2718;
        com.tencent.mm.ak.d aXF = aVar.aXF();
        dnu dnu = (dnu) aXF.iLK.iLR;
        dnu.MQP = new crv();
        if (this.AlE != null) {
            dnu.MQP.MwU = this.AlE.jeR;
            dnu.MQQ = this.AlE.jeS;
            this.AlE = null;
        }
        dnu.MQP.MwV = String.valueOf(j3);
        dnu.MQP.MwW = String.valueOf(j2);
        aa.a(aXF, new aa.a() {
            /* class com.tencent.mm.plugin.music.model.d.f.AnonymousClass1 */

            @Override // com.tencent.mm.ak.aa.a
            public final int a(int i2, int i3, String str, com.tencent.mm.ak.d dVar, q qVar) {
                AppMethodBeat.i(63155);
                Log.i("MicroMsg.Music.MusicWechatReportService", "reportMusicInfo callback errType:%d errCode:%d msg:%s", Integer.valueOf(i2), Integer.valueOf(i3), str);
                AppMethodBeat.o(63155);
                return 0;
            }
        });
        AppMethodBeat.o(63167);
    }

    @Override // com.tencent.mm.plugin.music.e.d
    public final void b(com.tencent.mm.ay.f fVar, int i2) {
        int i3;
        int i4;
        boolean z;
        int i5;
        int i6;
        int i7;
        AppMethodBeat.i(63158);
        IDKey iDKey = new IDKey();
        iDKey.SetID(JsApiSetLabInfo.CTRL_INDEX);
        iDKey.SetKey(4);
        iDKey.SetValue(1);
        IDKey iDKey2 = new IDKey();
        iDKey2.SetID(JsApiSetLabInfo.CTRL_INDEX);
        int i8 = fVar.jeT;
        Log.i("MicroMsg.Music.MusicPlayIdKeyReport", "getQQMusicPlayerErrIdKeyByMusicType, musicType:".concat(String.valueOf(i8)));
        switch (i8) {
            case 0:
                i3 = 49;
                break;
            case 1:
                i3 = 50;
                break;
            case 2:
            case 3:
            default:
                i3 = 9;
                break;
            case 4:
                i3 = 51;
                break;
            case 5:
                i3 = 52;
                break;
            case 6:
                i3 = 53;
                break;
            case 7:
                i3 = 54;
                break;
            case 8:
                i3 = 55;
                break;
            case 9:
                i3 = 56;
                break;
            case 10:
                i3 = 7;
                break;
            case 11:
                i3 = 8;
                break;
        }
        iDKey2.SetKey(i3);
        iDKey2.SetValue(1);
        IDKey iDKey3 = new IDKey();
        iDKey3.SetID(JsApiSetLabInfo.CTRL_INDEX);
        iDKey3.SetKey(c.ST(i2));
        iDKey3.SetValue(1);
        IDKey iDKey4 = new IDKey();
        iDKey4.SetID(JsApiSetLabInfo.CTRL_INDEX);
        iDKey4.SetValue(1);
        ArrayList<IDKey> arrayList = new ArrayList<>();
        int i9 = 0;
        int i10 = 0;
        if (i2 == 80) {
            int i11 = fVar.jeT;
            Log.i("MicroMsg.Music.MusicPlayIdKeyReport", "getQQMusicPlayerNetworkErrIdKeyByMusicType, musicType:".concat(String.valueOf(i11)));
            switch (i11) {
                case 0:
                    i7 = TbsListener.ErrorCode.STARTDOWNLOAD_8;
                    break;
                case 1:
                    i7 = 168;
                    break;
                case 2:
                case 3:
                case 5:
                default:
                    i7 = 188;
                    break;
                case 4:
                    i7 = 169;
                    break;
                case 6:
                    i7 = TbsListener.ErrorCode.NEEDDOWNLOAD_TRUE;
                    break;
                case 7:
                    i7 = TbsListener.ErrorCode.NEEDDOWNLOAD_FALSE_1;
                    break;
                case 8:
                    i7 = 172;
                    break;
                case 9:
                    i7 = TbsListener.ErrorCode.NEEDDOWNLOAD_FALSE_3;
                    break;
                case 10:
                    i7 = TbsListener.ErrorCode.NEEDDOWNLOAD_FALSE_4;
                    break;
                case 11:
                    i7 = TbsListener.ErrorCode.NEEDDOWNLOAD_FALSE_5;
                    break;
            }
            iDKey4.SetKey(i7);
            arrayList.add(iDKey4);
            i9 = 1;
            int aHE = g.aHE(fVar.playUrl);
            i4 = g.aHF(fVar.playUrl);
            if (g.aHE(fVar.playUrl) == 403) {
                IDKey iDKey5 = new IDKey();
                iDKey5.SetID(JsApiSetLabInfo.CTRL_INDEX);
                iDKey5.SetValue(1);
                iDKey5.SetKey(c.ST(700));
                arrayList.add(iDKey5);
                i10 = aHE;
            } else {
                i10 = aHE;
            }
        } else if (g.aHA(fVar.playUrl) == null || !g.aHA(fVar.playUrl).contains("text/html")) {
            if (i2 != 70) {
                switch (i2) {
                    case 62:
                    case 63:
                    case 64:
                    case 67:
                    case 74:
                        z = true;
                        break;
                    default:
                        z = false;
                        break;
                }
                if (z) {
                    IDKey iDKey6 = new IDKey();
                    iDKey6.SetID(JsApiSetLabInfo.CTRL_INDEX);
                    iDKey6.SetValue(1);
                    int i12 = fVar.jeT;
                    Log.i("MicroMsg.Music.MusicPlayIdKeyReport", "getQQMusicPlayerDecodeErrIdKeyByMusicType, musicType:".concat(String.valueOf(i12)));
                    switch (i12) {
                        case 0:
                            i6 = 202;
                            break;
                        case 1:
                            i6 = 203;
                            break;
                        case 2:
                        case 3:
                        case 5:
                        default:
                            i6 = 188;
                            break;
                        case 4:
                            i6 = 204;
                            break;
                        case 6:
                            i6 = 205;
                            break;
                        case 7:
                            i6 = 206;
                            break;
                        case 8:
                            i6 = 207;
                            break;
                        case 9:
                            i6 = 208;
                            break;
                        case 10:
                            i6 = 209;
                            break;
                        case 11:
                            i6 = 210;
                            break;
                    }
                    iDKey6.SetKey(i6);
                    arrayList.add(iDKey6);
                }
                int i13 = fVar.jeT;
                Log.i("MicroMsg.Music.MusicPlayIdKeyReport", "getQQMusicPlayerPlayErrIdKeyByMusicType, musicType:".concat(String.valueOf(i13)));
                switch (i13) {
                    case 0:
                        i5 = 178;
                        break;
                    case 1:
                        i5 = 179;
                        break;
                    case 2:
                    case 3:
                    case 5:
                    default:
                        i5 = 188;
                        break;
                    case 4:
                        i5 = TXLiveConstants.RENDER_ROTATION_180;
                        break;
                    case 6:
                        i5 = 181;
                        break;
                    case 7:
                        i5 = 182;
                        break;
                    case 8:
                        i5 = 183;
                        break;
                    case 9:
                        i5 = 184;
                        break;
                    case 10:
                        i5 = 185;
                        break;
                    case 11:
                        i5 = 186;
                        break;
                }
                iDKey4.SetKey(i5);
                arrayList.add(iDKey4);
            }
            i4 = 0;
        } else {
            i10 = 701;
            IDKey iDKey7 = new IDKey();
            iDKey7.SetID(JsApiSetLabInfo.CTRL_INDEX);
            iDKey7.SetValue(1);
            iDKey7.SetKey(c.ST(701));
            arrayList.add(iDKey7);
            i4 = 0;
        }
        h.INSTANCE.a(14777, 1, Integer.valueOf(fVar.jeT), Integer.valueOf(i9), Integer.valueOf(i2), Integer.valueOf(i10), Integer.valueOf(i4));
        arrayList.add(iDKey);
        arrayList.add(iDKey2);
        arrayList.add(iDKey3);
        h.INSTANCE.b(arrayList, true);
        AppMethodBeat.o(63158);
    }

    @Override // com.tencent.mm.plugin.music.e.d
    public final void c(com.tencent.mm.ay.f fVar, int i2) {
        int i3;
        AppMethodBeat.i(63159);
        IDKey iDKey = new IDKey();
        iDKey.SetID(JsApiSetLabInfo.CTRL_INDEX);
        if (i2 == 2) {
            i3 = 92;
        } else if (i2 == 3) {
            i3 = 93;
        } else if (i2 == 4) {
            i3 = 94;
        } else if (i2 == 5) {
            i3 = 95;
        } else if (i2 == 6) {
            i3 = 96;
        } else if (i2 == 7) {
            i3 = 97;
        } else if (i2 == 8) {
            i3 = 98;
        } else if (i2 == 9) {
            i3 = 99;
        } else {
            i3 = 100;
        }
        iDKey.SetKey(i3);
        iDKey.SetValue(1);
        ArrayList<IDKey> arrayList = new ArrayList<>();
        arrayList.add(iDKey);
        h.INSTANCE.b(arrayList, true);
        String aHA = g.aHA(fVar.playUrl);
        Log.i("MicroMsg.Music.QQMusicPlayerReportImpl", "mineTypeStr:%s", aHA);
        if (fVar == null || TextUtils.isEmpty(aHA)) {
            Log.e("MicroMsg.Music.QQMusicPlayerReportImpl", "music is null or mineTypeStr is empty");
            AppMethodBeat.o(63159);
            return;
        }
        int aHV = c.aHV(aHA);
        h.INSTANCE.a(14486, 1, Integer.valueOf(fVar.jeT), Integer.valueOf(aHV), aHA);
        AppMethodBeat.o(63159);
    }

    @Override // com.tencent.mm.plugin.music.e.d
    public final void SN(int i2) {
        AppMethodBeat.i(63163);
        if (i2 == 300 || i2 == 301 || i2 == 302 || i2 == 303) {
            IDKey iDKey = new IDKey();
            iDKey.SetID(JsApiSetLabInfo.CTRL_INDEX);
            iDKey.SetKey(15);
            iDKey.SetValue(1);
            ArrayList<IDKey> arrayList = new ArrayList<>();
            arrayList.add(iDKey);
            h.INSTANCE.b(arrayList, true);
        }
        AppMethodBeat.o(63163);
    }

    @Override // com.tencent.mm.plugin.music.e.d
    public final void d(com.tencent.mm.ay.f fVar, int i2, int i3) {
        int i4;
        int i5;
        int i6;
        AppMethodBeat.i(63164);
        IDKey iDKey = new IDKey();
        iDKey.SetID(797);
        iDKey.SetKey(2);
        iDKey.SetValue(1);
        IDKey iDKey2 = new IDKey();
        iDKey2.SetID(797);
        int i7 = fVar.jeT;
        Log.i("MicroMsg.Music.ExoPlayIdkeyReport", "getExoMusicPlayerErrIdKeyByMusicType, musicType:".concat(String.valueOf(i7)));
        switch (i7) {
            case 0:
                i4 = 62;
                break;
            case 1:
                i4 = 63;
                break;
            case 2:
            case 3:
            case 5:
            default:
                i4 = 71;
                break;
            case 4:
                i4 = 64;
                break;
            case 6:
                i4 = 65;
                break;
            case 7:
                i4 = 66;
                break;
            case 8:
                i4 = 67;
                break;
            case 9:
                i4 = 68;
                break;
            case 10:
                i4 = 69;
                break;
            case 11:
                i4 = 70;
                break;
        }
        iDKey2.SetKey(i4);
        iDKey2.SetValue(1);
        IDKey iDKey3 = new IDKey();
        iDKey3.SetID(797);
        Log.i("MicroMsg.Music.ExoPlayIdkeyReport", "getExoMusicPlayerErrTypeIdKey, errType:".concat(String.valueOf(i2)));
        switch (i2) {
            case -4999:
                i5 = 9;
                break;
            case TXLiteAVCode.ERR_REQUEST_ACC_BY_HOST_IP:
                i5 = 8;
                break;
            case TXLiteAVCode.ERR_MIX_PARAM_INVALID:
                i5 = 7;
                break;
            case TXLiteAVCode.ERR_USER_DEFINE_RECORD_ID_INVALID:
                i5 = 6;
                break;
            case TXLiteAVCode.ERR_CUSTOM_STREAM_INVALID:
                i5 = 5;
                break;
            case TXLiteAVCode.ERR_REQUEST_QUERY_CONFIG_TIMEOUT:
                i5 = 4;
                break;
            case -4000:
                i5 = 3;
                break;
            default:
                i5 = 9;
                break;
        }
        iDKey3.SetKey(i5);
        iDKey3.SetValue(1);
        IDKey iDKey4 = new IDKey();
        iDKey4.SetID(797);
        Log.i("MicroMsg.Music.ExoPlayIdkeyReport", "getExoMusicPlayerErrIdKey, errCode:".concat(String.valueOf(i3)));
        switch (i3) {
            case APPluginConstants.ERROR_IO_SSLException_SSLPeerUnverifiedException:
                i6 = 25;
                break;
            case APPluginConstants.ERROR_IO_SSLException_SSLKeyException:
                i6 = 24;
                break;
            case APPluginConstants.ERROR_IO_SSLException_SSLHandshakeException:
                i6 = 23;
                break;
            case APPluginConstants.ERROR_IO_ProtocolException:
                i6 = 22;
                break;
            case APPluginConstants.ERROR_IO_InvalidPropertiesFormatException:
                i6 = 21;
                break;
            case -13:
                i6 = 20;
                break;
            case -12:
                i6 = 19;
                break;
            case -11:
                i6 = 18;
                break;
            case -10:
                i6 = 17;
                break;
            case -3:
                i6 = 16;
                break;
            case -2:
                i6 = 15;
                break;
            case -1:
                i6 = 14;
                break;
            default:
                i6 = 14;
                break;
        }
        iDKey4.SetKey(i6);
        iDKey4.SetValue(1);
        ArrayList<IDKey> arrayList = new ArrayList<>();
        arrayList.add(iDKey);
        arrayList.add(iDKey2);
        arrayList.add(iDKey3);
        arrayList.add(iDKey4);
        h.INSTANCE.b(arrayList, true);
        AppMethodBeat.o(63164);
    }
}

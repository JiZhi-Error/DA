package com.tencent.mm.an;

import com.facebook.internal.ServerProtocol;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.mars.stn.StnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.i.b;
import com.tencent.mm.i.c;
import com.tencent.mm.i.d;
import com.tencent.mm.i.e;
import com.tencent.mm.i.f;
import com.tencent.mm.i.h;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ay;
import com.tencent.mm.platformtools.ac;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.tc;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.s;
import com.tencent.recovery.wx.util.EncryptUtil;
import java.io.ByteArrayOutputStream;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

public final class a implements CdnLogic.AppCallback, CdnLogic.DownloadCallback, CdnLogic.SessionCallback, CdnLogic.UploadCallback, CdnLogic.VideoStreamingCallback {
    private static int iRb = 7340033;
    private static int iRc = 100;
    private static int iRd = 101;
    private static int iRe = 102;
    private static int iRf = 103;
    private tc iRg = null;
    private b.a iRh = null;
    b.a iRi = null;
    private int iRj = 0;
    private int iRk = 0;
    private String iRl = "";
    private MTimerHandler iRm = null;
    AbstractC0257a iRn;
    public AbstractC0257a iRo;

    /* renamed from: com.tencent.mm.an.a$a  reason: collision with other inner class name */
    public interface AbstractC0257a {
        int a(String str, c cVar, d dVar);

        int d(String str, int i2, int i3, String str2);

        int p(String str, int i2, int i3);

        int q(String str, int i2, int i3);
    }

    public a(String str, b.a aVar) {
        AppMethodBeat.i(150333);
        if (MMApplicationContext.isMMProcess()) {
            this.iRm = new MTimerHandler(g.aAk().getLooper(), (MTimerHandler.CallBack) new MTimerHandler.CallBack() {
                /* class com.tencent.mm.an.a.AnonymousClass1 */

                @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
                public final boolean onTimerExpired() {
                    AppMethodBeat.i(150332);
                    if (a.this.iRj == 0 && a.this.iRk == 0) {
                        AppMethodBeat.o(150332);
                        return false;
                    }
                    Log.i("MicroMsg.CdnTransportEngine", "CdnDataFlowStat id:%s send:%d recv:%d", a.this.iRl, Integer.valueOf(a.this.iRj), Integer.valueOf(a.this.iRk));
                    if (ay.a.iDr == null) {
                        Log.e("MicroMsg.CdnTransportEngine", "getNetStat null");
                        AppMethodBeat.o(150332);
                        return false;
                    }
                    ay.a.iDr.dl(a.this.iRk, a.this.iRj);
                    a.this.iRj = 0;
                    a.this.iRk = 0;
                    AppMethodBeat.o(150332);
                    return true;
                }
            }, true);
        }
        this.iRi = aVar;
        CdnLogic.Initialize(str, this, "1", "BFEDFFB5EA28509F9C89ED83FA7FDDA8881435D444E984D53A98AD8E9410F1145EDD537890E10456190B22E6E5006455EFC6C12E41FDA985F38FBBC7213ECB810E3053D4B8D74FFBC70B4600ABD728202322AFCE1406046631261BD5EE3D44721082FEAB74340D73645DC0D02A293B962B9D47E4A64100BD7524DE00D9D3B5C1", EncryptUtil.KEY_E, "cdnwx2013usrname");
        Log.i("MicroMsg.CdnTransportEngine", "summersafecdn CdnTransportEngine init[%s] infoPath[%s], stack[%s]", Integer.valueOf(hashCode()), str, Util.getStack());
        AppMethodBeat.o(150333);
    }

    public final void a(AbstractC0257a aVar) {
        int i2 = 0;
        AppMethodBeat.i(223536);
        this.iRn = aVar;
        Object[] objArr = new Object[2];
        objArr[0] = Integer.valueOf(hashCode());
        if (aVar != null) {
            i2 = aVar.hashCode();
        }
        objArr[1] = Integer.valueOf(i2);
        Log.i("MicroMsg.CdnTransportEngine", "set tp player cdn callback hash[%d] onlineVideoCallback[%d]", objArr);
        AppMethodBeat.o(223536);
    }

    public final void a(b.a aVar) {
        int i2 = 0;
        AppMethodBeat.i(223537);
        this.iRh = aVar;
        Object[] objArr = new Object[2];
        objArr[0] = Integer.valueOf(hashCode());
        if (aVar != null) {
            i2 = aVar.hashCode();
        }
        objArr[1] = Integer.valueOf(i2);
        Log.i("MicroMsg.CdnTransportEngine", "set tp player cdn callback hash[%d] cdnTransCallback[%d]", objArr);
        AppMethodBeat.o(223537);
    }

    public static int keep_callFromJni(int i2, int i3, byte[] bArr) {
        AppMethodBeat.i(150334);
        if (i2 == iRc) {
            c.outputJniLog(bArr, "MicroMsg.CdnEngine", i3);
        }
        AppMethodBeat.o(150334);
        return 0;
    }

    private static CdnLogic.C2CDownloadRequest a(com.tencent.mm.i.g gVar) {
        boolean z = true;
        AppMethodBeat.i(150335);
        CdnLogic.C2CDownloadRequest c2CDownloadRequest = new CdnLogic.C2CDownloadRequest();
        c2CDownloadRequest.fileid = gVar.field_fileId;
        c2CDownloadRequest.aeskey = gVar.field_aesKey;
        c2CDownloadRequest.fileType = gVar.field_fileType;
        c2CDownloadRequest.fileKey = gVar.field_mediaId;
        c2CDownloadRequest.fileSize = gVar.field_totalLen;
        c2CDownloadRequest.setSavePath(gVar.field_fullpath);
        c2CDownloadRequest.isStorageMode = gVar.field_needStorage;
        c2CDownloadRequest.isSmallVideo = gVar.field_smallVideoFlag == 1;
        if (gVar.field_largesvideo <= 0) {
            z = false;
        }
        c2CDownloadRequest.isLargeSVideo = z;
        c2CDownloadRequest.limitRate = gVar.field_limitrate;
        c2CDownloadRequest.isAutoStart = gVar.field_autostart;
        c2CDownloadRequest.chatType = gVar.field_chattype;
        c2CDownloadRequest.isSilentTask = gVar.field_isSilentTask;
        c2CDownloadRequest.requestVideoFormat = gVar.field_requestVideoFormat;
        c2CDownloadRequest.isColdSnsData = gVar.isColdSnsData;
        c2CDownloadRequest.isHotSnsVideo = gVar.isHotSnsVideo;
        c2CDownloadRequest.signalQuality = gVar.field_signalQuality;
        c2CDownloadRequest.snsScene = gVar.field_snsScene;
        c2CDownloadRequest.requestVideoFormat = gVar.field_requestVideoFormat;
        c2CDownloadRequest.isHLSVideo = gVar.isHLSVideo;
        c2CDownloadRequest.hlsVideoFlag = gVar.hlsVideoFlag;
        c2CDownloadRequest.videofileid = gVar.field_videoFileId;
        c2CDownloadRequest.bigfileSignature = gVar.field_svr_signature;
        if (Util.isNullOrNil(c2CDownloadRequest.bigfileSignature)) {
            c2CDownloadRequest.bigfileSignature = "";
        }
        c2CDownloadRequest.fakeBigfileSignature = gVar.field_fake_bigfile_signature;
        if (Util.isNullOrNil(c2CDownloadRequest.fakeBigfileSignature)) {
            c2CDownloadRequest.fakeBigfileSignature = "";
        }
        c2CDownloadRequest.fakeBigfileSignatureAeskey = gVar.field_fake_bigfile_signature_aeskey;
        if (Util.isNullOrNil(c2CDownloadRequest.fakeBigfileSignatureAeskey)) {
            c2CDownloadRequest.fakeBigfileSignatureAeskey = "";
        }
        c2CDownloadRequest.msgExtra = gVar.field_wxmsgparam;
        if (Util.isNullOrNil(c2CDownloadRequest.msgExtra)) {
            c2CDownloadRequest.msgExtra = "";
        }
        c2CDownloadRequest.queueTimeoutSeconds = gVar.gqC;
        c2CDownloadRequest.transforTimeoutSeconds = gVar.gqD;
        c2CDownloadRequest.preloadRatio = gVar.field_preloadRatio;
        c2CDownloadRequest.certificateVerifyPolicy = gVar.certificateVerifyPolicy;
        c2CDownloadRequest.expectImageFormat = gVar.expectImageFormat;
        c2CDownloadRequest.marscdnBizType = gVar.fuQ;
        c2CDownloadRequest.useMultithread = gVar.field_use_multithread;
        AppMethodBeat.o(150335);
        return c2CDownloadRequest;
    }

    public static int NT(String str) {
        AppMethodBeat.i(150337);
        CdnLogic.cancelTask(str);
        AppMethodBeat.o(150337);
        return 0;
    }

    public final int c(com.tencent.mm.i.g gVar) {
        AppMethodBeat.i(150338);
        CdnLogic.C2CDownloadRequest a2 = a(gVar);
        if (ac.jOV && ac.jPa.length() > 0) {
            a2.debugIP = ac.jPa;
            Log.w("MicroMsg.CdnTransportEngine", "debugip " + a2.debugIP);
        }
        int startC2CDownload = CdnLogic.startC2CDownload(a2, this);
        AppMethodBeat.o(150338);
        return startC2CDownload;
    }

    public static int NU(String str) {
        AppMethodBeat.i(150339);
        CdnLogic.cancelTask(str);
        AppMethodBeat.o(150339);
        return 0;
    }

    public static String NV(String str) {
        AppMethodBeat.i(150340);
        String calcFileMD5 = CdnLogic.calcFileMD5(s.k(str, false));
        AppMethodBeat.o(150340);
        return calcFileMD5;
    }

    public static String baG() {
        AppMethodBeat.i(150341);
        String createAeskey = CdnLogic.createAeskey();
        AppMethodBeat.o(150341);
        return createAeskey;
    }

    public static int NW(String str) {
        AppMethodBeat.i(150342);
        int calcFileCrc32 = CdnLogic.calcFileCrc32(s.k(str, false));
        AppMethodBeat.o(150342);
        return calcFileCrc32;
    }

    public static String NX(String str) {
        AppMethodBeat.i(150343);
        String calcMP4IdentifyMD5 = CdnLogic.calcMP4IdentifyMD5(s.k(str, false));
        AppMethodBeat.o(150343);
        return calcMP4IdentifyMD5;
    }

    public final int a(String str, String str2, String str3, int i2, String str4, String str5) {
        AppMethodBeat.i(150344);
        Log.i("MicroMsg.CdnTransportEngine", "startURLDownload: mediaid:%s, savepath:%s", str, str3);
        CdnLogic.C2CDownloadRequest c2CDownloadRequest = new CdnLogic.C2CDownloadRequest();
        c2CDownloadRequest.fileKey = str;
        c2CDownloadRequest.url = str2;
        c2CDownloadRequest.setSavePath(str3);
        c2CDownloadRequest.aeskey = str4;
        c2CDownloadRequest.customHeader = "authkey:" + str5 + APLogFileUtil.SEPARATOR_LINE;
        c2CDownloadRequest.fileType = i2;
        int startSNSDownload = CdnLogic.startSNSDownload(c2CDownloadRequest, this, this, 0);
        AppMethodBeat.o(150344);
        return startSNSDownload;
    }

    public final int a(String str, String str2, String str3, int i2, int i3, int i4, String[] strArr, boolean z, boolean z2, boolean z3) {
        AppMethodBeat.i(223538);
        Object[] objArr = new Object[7];
        objArr[0] = str;
        objArr[1] = str3;
        objArr[2] = Integer.valueOf(i2);
        objArr[3] = Integer.valueOf(i3);
        objArr[4] = Integer.valueOf(i4);
        objArr[5] = Integer.valueOf(strArr == null ? 0 : strArr.length);
        objArr[6] = Boolean.valueOf(z);
        Log.i("MicroMsg.CdnTransportEngine", "startURLDownload: mediaid:%s, savepath:%s, filetype:%d, timeout:%d, %d, ip.size:%d, gzip:%b", objArr);
        CdnLogic.C2CDownloadRequest c2CDownloadRequest = new CdnLogic.C2CDownloadRequest();
        c2CDownloadRequest.fileKey = str;
        c2CDownloadRequest.url = str2;
        c2CDownloadRequest.setSavePath(str3);
        c2CDownloadRequest.queueTimeoutSeconds = i3;
        c2CDownloadRequest.transforTimeoutSeconds = i4;
        c2CDownloadRequest.ocIpList = strArr;
        if (!z) {
            c2CDownloadRequest.customHeader = "Accept-Encoding:";
        }
        c2CDownloadRequest.fileType = i2;
        c2CDownloadRequest.taskStartTime = System.currentTimeMillis();
        if (com.tencent.mm.i.a.gqa == c2CDownloadRequest.fileType) {
            if (z3) {
                c2CDownloadRequest.useNewdns = true;
            }
            if (z2) {
                Log.i("MicroMsg.CdnTransportEngine", "use cronet download pkg mediaId:%s, url:%s", str, str2);
                int startCronetFileDownload = CdnLogic.startCronetFileDownload(c2CDownloadRequest, this);
                AppMethodBeat.o(223538);
                return startCronetFileDownload;
            }
            Log.i("MicroMsg.CdnTransportEngine", "use normal download pkg mediaId:%s, url:%s", str, str2);
            int startHttpsDownload = CdnLogic.startHttpsDownload(c2CDownloadRequest, this);
            AppMethodBeat.o(223538);
            return startHttpsDownload;
        }
        int startURLDownload = CdnLogic.startURLDownload(c2CDownloadRequest, this);
        AppMethodBeat.o(223538);
        return startURLDownload;
    }

    public final int a(h hVar) {
        AppMethodBeat.i(223539);
        CdnLogic.C2CDownloadRequest c2CDownloadRequest = new CdnLogic.C2CDownloadRequest();
        c2CDownloadRequest.fileType = 20202;
        c2CDownloadRequest.fileKey = hVar.field_mediaId;
        c2CDownloadRequest.url = hVar.url;
        c2CDownloadRequest.referer = hVar.referer;
        c2CDownloadRequest.setSavePath(hVar.field_fullpath);
        c2CDownloadRequest.fileSize = 0;
        c2CDownloadRequest.isColdSnsData = hVar.isColdSnsData;
        c2CDownloadRequest.isHotSnsVideo = hVar.isHotSnsVideo;
        c2CDownloadRequest.isHLSVideo = hVar.isHLSVideo;
        c2CDownloadRequest.hlsVideoFlag = hVar.hlsVideoFlag;
        c2CDownloadRequest.signalQuality = hVar.signalQuality;
        c2CDownloadRequest.snsScene = hVar.snsScene;
        c2CDownloadRequest.preloadRatio = hVar.field_preloadRatio;
        c2CDownloadRequest.preloadMinSize = hVar.preloadMinSize;
        c2CDownloadRequest.requestVideoFormat = hVar.field_requestVideoFormat;
        c2CDownloadRequest.connectionCount = hVar.connectionCount;
        c2CDownloadRequest.concurrentCount = hVar.concurrentCount;
        if (ac.jOV && ac.jPa.length() > 0) {
            c2CDownloadRequest.debugIP = ac.jPa;
            Log.w("MicroMsg.CdnTransportEngine", "debugip " + c2CDownloadRequest.debugIP);
        }
        int startSNSDownload = CdnLogic.startSNSDownload(c2CDownloadRequest, this, this, hVar.gqU);
        AppMethodBeat.o(223539);
        return startSNSDownload;
    }

    public final int b(h hVar) {
        AppMethodBeat.i(223540);
        CdnLogic.C2CDownloadRequest c2CDownloadRequest = new CdnLogic.C2CDownloadRequest();
        c2CDownloadRequest.fileType = CdnLogic.kMediaTypeAppVideo;
        c2CDownloadRequest.fileKey = hVar.field_mediaId;
        c2CDownloadRequest.url = hVar.url;
        c2CDownloadRequest.referer = hVar.referer;
        c2CDownloadRequest.setSavePath(hVar.field_fullpath);
        c2CDownloadRequest.fileSize = 0;
        c2CDownloadRequest.isColdSnsData = hVar.isColdSnsData;
        c2CDownloadRequest.isHotSnsVideo = hVar.isHotSnsVideo;
        c2CDownloadRequest.isHLSVideo = hVar.isHLSVideo;
        c2CDownloadRequest.hlsVideoFlag = hVar.hlsVideoFlag;
        c2CDownloadRequest.signalQuality = hVar.signalQuality;
        c2CDownloadRequest.snsScene = hVar.snsScene;
        c2CDownloadRequest.preloadRatio = hVar.field_preloadRatio;
        c2CDownloadRequest.preloadMinSize = hVar.preloadMinSize;
        c2CDownloadRequest.requestVideoFormat = hVar.field_requestVideoFormat;
        c2CDownloadRequest.connectionCount = hVar.connectionCount;
        c2CDownloadRequest.marscdnAppType = 205;
        if (ac.jOV && ac.jPa.length() > 0) {
            c2CDownloadRequest.debugIP = ac.jPa;
            Log.w("MicroMsg.CdnTransportEngine", "debugip " + c2CDownloadRequest.debugIP);
        }
        int startSNSDownload = CdnLogic.startSNSDownload(c2CDownloadRequest, this, this, hVar.gqU);
        AppMethodBeat.o(223540);
        return startSNSDownload;
    }

    public final int c(h hVar) {
        AppMethodBeat.i(223541);
        CdnLogic.C2CDownloadRequest c2CDownloadRequest = new CdnLogic.C2CDownloadRequest();
        c2CDownloadRequest.fileType = CdnLogic.kMediaTypeAppVideo;
        c2CDownloadRequest.fileKey = hVar.field_mediaId;
        c2CDownloadRequest.url = hVar.url;
        c2CDownloadRequest.referer = hVar.referer;
        c2CDownloadRequest.setSavePath(hVar.field_fullpath);
        c2CDownloadRequest.fileSize = 0;
        c2CDownloadRequest.isColdSnsData = hVar.isColdSnsData;
        c2CDownloadRequest.isHotSnsVideo = hVar.isHotSnsVideo;
        c2CDownloadRequest.isHLSVideo = hVar.isHLSVideo;
        c2CDownloadRequest.hlsVideoFlag = hVar.hlsVideoFlag;
        c2CDownloadRequest.signalQuality = hVar.signalQuality;
        c2CDownloadRequest.snsScene = hVar.snsScene;
        c2CDownloadRequest.preloadRatio = hVar.field_preloadRatio;
        c2CDownloadRequest.preloadMinSize = hVar.preloadMinSize;
        c2CDownloadRequest.requestVideoFormat = hVar.field_requestVideoFormat;
        c2CDownloadRequest.connectionCount = hVar.connectionCount;
        c2CDownloadRequest.snsCipherKey = hVar.snsCipherKey;
        c2CDownloadRequest.marscdnAppType = 251;
        c2CDownloadRequest.videoflagPolicy = hVar.grb;
        c2CDownloadRequest.concurrentCount = hVar.concurrentCount;
        if (hVar.videoFlag == null || (hVar.videoFlag.indexOf(120) < 0 && hVar.videoFlag.indexOf(88) < 0)) {
            c2CDownloadRequest.requestVideoFlag = hVar.videoFlag;
        } else {
            c2CDownloadRequest.requestVideoFlag = hVar.videoFlag.substring(1);
        }
        if (ac.jOV && ac.jPa.length() > 0) {
            c2CDownloadRequest.debugIP = ac.jPa;
            Log.w("MicroMsg.CdnTransportEngine", "debugip " + c2CDownloadRequest.debugIP);
        }
        int startSNSDownload = CdnLogic.startSNSDownload(c2CDownloadRequest, this, this, hVar.gqU);
        AppMethodBeat.o(223541);
        return startSNSDownload;
    }

    public final int a(f fVar) {
        AppMethodBeat.i(150348);
        CdnLogic.C2CDownloadRequest c2CDownloadRequest = new CdnLogic.C2CDownloadRequest();
        c2CDownloadRequest.fileType = 20201;
        c2CDownloadRequest.fileKey = fVar.field_mediaId;
        c2CDownloadRequest.url = fVar.url;
        c2CDownloadRequest.referer = fVar.referer;
        c2CDownloadRequest.isColdSnsData = fVar.isColdSnsData;
        c2CDownloadRequest.signalQuality = fVar.signalQuality;
        c2CDownloadRequest.snsScene = fVar.snsScene;
        c2CDownloadRequest.concurrentCount = 6;
        c2CDownloadRequest.marscdnBizType = fVar.fuQ;
        c2CDownloadRequest.marscdnAppType = fVar.appType;
        c2CDownloadRequest.fileType = fVar.fileType;
        c2CDownloadRequest.msgType = 2;
        c2CDownloadRequest.feedId = fVar.dRS;
        c2CDownloadRequest.feedPicCount = fVar.gqv;
        c2CDownloadRequest.batchSnsReqImageDatas = fVar.gqo;
        if (ac.jOV && ac.jPa.length() > 0) {
            c2CDownloadRequest.debugIP = ac.jPa;
            Log.w("MicroMsg.CdnTransportEngine", "debugip " + c2CDownloadRequest.debugIP);
        }
        int startSNSDownload = CdnLogic.startSNSDownload(c2CDownloadRequest, this, this, 0);
        AppMethodBeat.o(150348);
        return startSNSDownload;
    }

    public final int a(e eVar) {
        AppMethodBeat.i(223542);
        if (Util.isNullOrNil(eVar.field_mediaId) || Util.isNullOrNil(eVar.url) || Util.isNullOrNil(eVar.gqq)) {
            Log.e("MicroMsg.CdnTransportEngine", "invalid param.");
            AppMethodBeat.o(223542);
            return -1;
        }
        CdnLogic.C2CDownloadRequest c2CDownloadRequest = new CdnLogic.C2CDownloadRequest();
        c2CDownloadRequest.fileType = 20201;
        c2CDownloadRequest.fileKey = eVar.field_mediaId;
        c2CDownloadRequest.url = eVar.url;
        c2CDownloadRequest.referer = eVar.referer;
        c2CDownloadRequest.setSavePath(eVar.gqq);
        c2CDownloadRequest.fileSize = 0;
        c2CDownloadRequest.isColdSnsData = eVar.isColdSnsData;
        c2CDownloadRequest.signalQuality = eVar.signalQuality;
        c2CDownloadRequest.snsScene = eVar.snsScene;
        c2CDownloadRequest.snsCipherKey = eVar.snsCipherKey;
        c2CDownloadRequest.concurrentCount = 6;
        c2CDownloadRequest.marscdnBizType = eVar.fuQ;
        c2CDownloadRequest.marscdnAppType = eVar.appType;
        c2CDownloadRequest.fileType = eVar.fileType;
        c2CDownloadRequest.requestVideoFormat = eVar.field_requestVideoFormat;
        if (ac.jOV && ac.jPa.length() > 0) {
            c2CDownloadRequest.debugIP = ac.jPa;
            Log.w("MicroMsg.CdnTransportEngine", "debugip " + c2CDownloadRequest.debugIP);
        }
        int startSNSDownload = CdnLogic.startSNSDownload(c2CDownloadRequest, this, this, 0);
        AppMethodBeat.o(223542);
        return startSNSDownload;
    }

    public static int NY(String str) {
        AppMethodBeat.i(150350);
        Log.i("MicroMsg.CdnTransportEngine", "stopHttpsDownload: mediaid:".concat(String.valueOf(str)));
        CdnLogic.cancelTask(str);
        AppMethodBeat.o(150350);
        return 0;
    }

    public final int a(String str, String str2, String str3, String str4, Map<String, String> map, boolean z, int i2, int i3, boolean z2, boolean z3, String[] strArr) {
        AppMethodBeat.i(150351);
        Log.i("MicroMsg.CdnTransportEngine", "startGamePackageDownload: mediaid:".concat(String.valueOf(str)));
        CdnLogic.C2CDownloadRequest c2CDownloadRequest = new CdnLogic.C2CDownloadRequest();
        c2CDownloadRequest.fileKey = str;
        c2CDownloadRequest.url = str3;
        c2CDownloadRequest.bakup_url = str4;
        c2CDownloadRequest.setSavePath(str2);
        c2CDownloadRequest.queueTimeoutSeconds = i2;
        c2CDownloadRequest.transforTimeoutSeconds = i3;
        c2CDownloadRequest.ocIpList = strArr;
        c2CDownloadRequest.is_resume_task = z2;
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                c2CDownloadRequest.serialized_verify_headers += entry.getKey();
                c2CDownloadRequest.serialized_verify_headers += ":";
                c2CDownloadRequest.serialized_verify_headers += entry.getValue();
                c2CDownloadRequest.serialized_verify_headers += ";";
            }
        }
        c2CDownloadRequest.allow_mobile_net_download = z;
        c2CDownloadRequest.wifiAutoStart = z3;
        c2CDownloadRequest.maxHttpRedirectCount = 18;
        c2CDownloadRequest.customHeader = String.format("X-Forwarded-Access-Type:%s\r\n", NetStatusUtil.getFormatedNetType(MMApplicationContext.getContext()));
        int startHttpMultiSocketDownloadTask = CdnLogic.startHttpMultiSocketDownloadTask(c2CDownloadRequest, this);
        AppMethodBeat.o(150351);
        return startHttpMultiSocketDownloadTask;
    }

    public static int NZ(String str) {
        AppMethodBeat.i(150352);
        Log.i("MicroMsg.CdnTransportEngine", "stopGamePackageDownload: mediaid:".concat(String.valueOf(str)));
        CdnLogic.cancelTask(str);
        AppMethodBeat.o(150352);
        return 0;
    }

    public final int a(com.tencent.mm.i.g gVar, int i2) {
        AppMethodBeat.i(150353);
        CdnLogic.C2CDownloadRequest a2 = a(gVar);
        if (ac.jOV && ac.jPa.length() > 0) {
            a2.debugIP = ac.jPa;
            Log.w("MicroMsg.CdnTransportEngine", "debugip " + a2.debugIP);
        }
        int startVideoStreamingDownload = CdnLogic.startVideoStreamingDownload(a2, this, this, i2);
        AppMethodBeat.o(150353);
        return startVideoStreamingDownload;
    }

    public final int d(h hVar) {
        AppMethodBeat.i(223543);
        CdnLogic.C2CDownloadRequest c2CDownloadRequest = new CdnLogic.C2CDownloadRequest();
        c2CDownloadRequest.fileKey = hVar.field_mediaId;
        c2CDownloadRequest.fileType = 90;
        c2CDownloadRequest.url = hVar.url;
        c2CDownloadRequest.referer = hVar.referer;
        c2CDownloadRequest.setSavePath(hVar.field_fullpath);
        c2CDownloadRequest.preloadRatio = hVar.field_preloadRatio;
        c2CDownloadRequest.preloadMinSize = hVar.preloadMinSize;
        c2CDownloadRequest.concurrentCount = hVar.concurrentCount;
        c2CDownloadRequest.maxHttpRedirectCount = 20;
        if (ac.jOV && ac.jPa.length() > 0) {
            c2CDownloadRequest.debugIP = ac.jPa;
            Log.w("MicroMsg.CdnTransportEngine", "debugip " + c2CDownloadRequest.debugIP);
        }
        int startHttpVideoStreamingDownload = CdnLogic.startHttpVideoStreamingDownload(c2CDownloadRequest, this, this, hVar.gqU);
        AppMethodBeat.o(223543);
        return startHttpVideoStreamingDownload;
    }

    public static int c(String str, d dVar) {
        AppMethodBeat.i(150356);
        Log.i("MicroMsg.CdnTransportEngine", "[stopVideoStreamingDownload] mediaId=%s %s", str, Util.getStack());
        CdnLogic.C2CDownloadResult c2CDownloadResult = new CdnLogic.C2CDownloadResult();
        int cancelDownloadTaskWithResult = CdnLogic.cancelDownloadTaskWithResult(str, c2CDownloadResult);
        a(c2CDownloadResult, dVar);
        AppMethodBeat.o(150356);
        return cancelDownloadTaskWithResult;
    }

    public static int requestVideoData(String str, long j2, long j3, int i2) {
        AppMethodBeat.i(223544);
        int requestVideoData = CdnLogic.requestVideoData(str, j2, j3, i2);
        AppMethodBeat.o(223544);
        return requestVideoData;
    }

    public static boolean isVideoDataAvailable(String str, long j2, long j3) {
        AppMethodBeat.i(150358);
        boolean isVideoDataAvailable = CdnLogic.isVideoDataAvailable(str, j2, j3);
        AppMethodBeat.o(150358);
        return isVideoDataAvailable;
    }

    public final boolean baH() {
        return this.iRg == null;
    }

    private static CdnLogic.CdnInfo a(tc tcVar) {
        AppMethodBeat.i(150359);
        CdnLogic.CdnInfo cdnInfo = new CdnLogic.CdnInfo();
        if (tcVar == null) {
            AppMethodBeat.o(150359);
            return cdnInfo;
        }
        cdnInfo.ver = tcVar.Lbi;
        cdnInfo.uin = tcVar.rBx;
        cdnInfo.frontid = tcVar.Lbk;
        cdnInfo.zoneid = tcVar.Lbp;
        cdnInfo.nettype = c.cX(MMApplicationContext.getContext());
        cdnInfo.authkey = z.a(tcVar.Lbo);
        if (tcVar.Lbl >= 2) {
            cdnInfo.frontip1 = z.a(tcVar.Lbm.get(0));
            cdnInfo.frontip2 = z.a(tcVar.Lbm.get(1));
            Log.i("MicroMsg.CdnTransportEngine", "frontip %s, %s", cdnInfo.frontip1, cdnInfo.frontip2);
        }
        if (tcVar.Lbq >= 2) {
            cdnInfo.zoneip1 = z.a(tcVar.Lbr.get(0));
            cdnInfo.zoneip2 = z.a(tcVar.Lbr.get(1));
            Log.i("MicroMsg.CdnTransportEngine", "zoneip %s, %s", cdnInfo.frontip1, cdnInfo.frontip2);
        }
        if (tcVar.Lbu > 0) {
            int i2 = tcVar.Lbs.get(0).Lbw;
            cdnInfo.frontports = new int[i2];
            for (int i3 = 0; i3 < i2; i3++) {
                cdnInfo.frontports[i3] = tcVar.Lbs.get(0).Lbx.get(i3).intValue();
            }
        }
        if (tcVar.Lbv > 0) {
            int i4 = tcVar.Lbt.get(0).Lbw;
            cdnInfo.zoneports = new int[i4];
            for (int i5 = 0; i5 < i4; i5++) {
                cdnInfo.zoneports[i5] = tcVar.Lbt.get(0).Lbx.get(i5).intValue();
            }
        }
        AppMethodBeat.o(150359);
        return cdnInfo;
    }

    public final boolean a(tc tcVar, tc tcVar2, tc tcVar3, byte[] bArr, byte[] bArr2, tc tcVar4) {
        AppMethodBeat.i(150360);
        Log.i("MicroMsg.CdnTransportEngine", "summersafecdn cdntra setCDNDnsInfo old [%s]  new [%s], safecdn [%s], stack[%s]", this.iRg, tcVar, tcVar4, Util.getStack());
        if (tcVar == null && bArr == null) {
            AppMethodBeat.o(150360);
            return false;
        }
        this.iRg = tcVar;
        try {
            CdnLogic.setLegacyCdnInfo(a(tcVar), a(tcVar2), a(tcVar3), a(tcVar4), bArr, bArr2);
            CdnLogic.setDebugIP("");
            AppMethodBeat.o(150360);
            return true;
        } catch (Exception e2) {
            Log.e("MicroMsg.CdnTransportEngine", "tocdninfo failed:" + e2.getLocalizedMessage());
            AppMethodBeat.o(150360);
            return false;
        }
    }

    private static int Oa(String str) {
        int i2;
        AppMethodBeat.i(150361);
        Log.i("MicroMsg.CdnTransportEngine", "ipFromString %s ->", str);
        try {
            if (str.contains(".") || str.contains(":")) {
                i2 = 0;
                for (byte b2 : InetAddress.getByName(str).getAddress()) {
                    try {
                        i2 = (i2 << 8) | (b2 & 255);
                    } catch (NullPointerException | UnknownHostException e2) {
                    }
                }
                Log.i("MicroMsg.CdnTransportEngine", "<- ipFromString %s --> %d", str, Integer.valueOf(i2));
                AppMethodBeat.o(150361);
                return i2;
            }
            Log.w("MicroMsg.CdnTransportEngine", "invalid ip str.");
            AppMethodBeat.o(150361);
            return 0;
        } catch (UnknownHostException e3) {
            i2 = 0;
        } catch (NullPointerException e4) {
            i2 = 0;
        }
    }

    private static d a(CdnLogic.C2CDownloadResult c2CDownloadResult, d dVar) {
        AppMethodBeat.i(150362);
        if (dVar == null) {
            dVar = new d();
        }
        dVar.field_retCode = c2CDownloadResult.errorCode;
        dVar.field_argInfo = c2CDownloadResult.argInfo;
        dVar.field_fileLength = c2CDownloadResult.fileSize;
        dVar.field_fileId = c2CDownloadResult.fileid;
        dVar.field_transInfo = c2CDownloadResult.transforMsg;
        dVar.traceMsg = c2CDownloadResult.traceMsg;
        dVar.field_convert2baseline = false;
        dVar.field_recvedBytes = c2CDownloadResult.recvedBytes;
        dVar.field_videoFormat = c2CDownloadResult.videoFormat;
        dVar.field_videoFlag = c2CDownloadResult.videoFlag;
        dVar.field_enQueueTime = c2CDownloadResult.enQueueTime;
        dVar.field_startTime = c2CDownloadResult.startTime;
        dVar.field_endTime = c2CDownloadResult.endTime;
        dVar.field_firstRequestCost = c2CDownloadResult.firstRequestCost;
        dVar.field_firstRequestSize = c2CDownloadResult.firstRequestSize;
        dVar.field_firstRequestDownloadSize = c2CDownloadResult.firstRequestDownloadSize;
        dVar.field_firstRequestCompleted = c2CDownloadResult.firstRequestCompleted;
        dVar.field_averageSpeed = c2CDownloadResult.averageSpeed;
        dVar.field_averageConnectCost = c2CDownloadResult.averageConnectCost;
        dVar.field_firstConnectCost = c2CDownloadResult.firstConnectCost;
        dVar.field_netConnectTimes = c2CDownloadResult.netConnectTimes;
        dVar.field_moovRequestTimes = c2CDownloadResult.moovRequestTimes;
        dVar.field_moovCost = c2CDownloadResult.moovCost;
        dVar.field_moovSize = c2CDownloadResult.moovSize;
        dVar.field_moovCompleted = c2CDownloadResult.moovCompleted;
        dVar.field_moovFailReason = c2CDownloadResult.moovFailReason;
        dVar.field_previousCompletedSize = c2CDownloadResult.previousCompletedSize;
        dVar.field_averageRequestSize = c2CDownloadResult.averageRequestSize;
        dVar.field_averageRequestCost = c2CDownloadResult.averageRequestCost;
        dVar.field_requestTotalCount = c2CDownloadResult.requestTotalCount;
        dVar.field_requestCompletedCount = c2CDownloadResult.requestCompletedCount;
        dVar.field_requestTimeoutCount = c2CDownloadResult.requestTimeoutCount;
        dVar.svrFallbackCount = c2CDownloadResult.svrFallbackCount;
        dVar.field_httpStatusCode = c2CDownloadResult.httpStatusCode;
        dVar.field_httpResponseHeader = c2CDownloadResult.httpResponseHeader;
        dVar.field_delayTime = c2CDownloadResult.delayTime;
        dVar.field_dnsCostTime = c2CDownloadResult.dnsCostTime;
        dVar.field_connectCostTime = c2CDownloadResult.connectCostTime;
        dVar.field_waitResponseCostTime = c2CDownloadResult.waitResponseCostTime;
        dVar.field_receiveCostTime = c2CDownloadResult.receiveCostTime;
        dVar.field_clientIP = c2CDownloadResult.clientIP;
        dVar.field_serverIP = c2CDownloadResult.serverIP;
        dVar.field_clientHostIP = Oa(c2CDownloadResult.clientIP);
        dVar.field_serverHostIP = Oa(c2CDownloadResult.serverIP);
        dVar.field_xErrorNo = c2CDownloadResult.xErrorNo;
        dVar.field_cSeqCheck = c2CDownloadResult.cSeqCheck;
        dVar.field_usePrivateProtocol = c2CDownloadResult.usePrivateProtocol;
        dVar.field_isCrossNet = c2CDownloadResult.crossNet;
        dVar.field_clientIP = c2CDownloadResult.clientIP;
        dVar.field_detailErrorType = c2CDownloadResult.detailErrorType;
        dVar.field_detailErrorCode = c2CDownloadResult.detailErrorCode;
        if (c2CDownloadResult.usedSvrIps != null && c2CDownloadResult.usedSvrIps.length > 0) {
            dVar.field_usedSvrIps = (String[]) c2CDownloadResult.usedSvrIps.clone();
            dVar.gqm = c2CDownloadResult.usedSvrIps[c2CDownloadResult.usedSvrIps.length - 1];
            dVar.lastSvrPort = c2CDownloadResult.lastSvrPort;
            dVar.lastNetType = c2CDownloadResult.lastNetType;
        }
        dVar.field_isResume = c2CDownloadResult.isResume;
        dVar.gqn = c2CDownloadResult.isSnsImageProtocolAvailable;
        dVar.index = c2CDownloadResult.picIndex;
        dVar.cachePath = c2CDownloadResult.picCachePath;
        dVar.dRS = c2CDownloadResult.batchPicFeedId;
        dVar.fileKey = c2CDownloadResult.batchImageFileKey;
        dVar.gqo = c2CDownloadResult.batchImageNeedRetry;
        dVar.transportProtocol = c2CDownloadResult.transportProtocol;
        dVar.transportProtocolError = c2CDownloadResult.transportProtocolError;
        dVar.traceId = c2CDownloadResult.traceId;
        Log.d("MicroMsg.CdnTransportEngine", "trace_id " + dVar.traceId);
        AppMethodBeat.o(150362);
        return dVar;
    }

    public final int keep_onUploadProgress(String str, c cVar) {
        AppMethodBeat.i(150363);
        cVar.field_isUploadTask = true;
        if (this.iRi != null) {
            Log.v("MicroMsg.CdnTransportEngine", "klem keep_onUploadProgress mediaId:%s, totalLen%d, offset%d", str, Long.valueOf(cVar.field_toltalLength), Long.valueOf(cVar.field_finishedLength));
            this.iRi.a(str, cVar, null);
        }
        AppMethodBeat.o(150363);
        return 0;
    }

    public final int keep_onUploadError(String str, d dVar) {
        AppMethodBeat.i(150364);
        if (this.iRi != null) {
            a(dVar);
            this.iRi.a(str, null, dVar);
        }
        AppMethodBeat.o(150364);
        return 0;
    }

    public final int keep_onUploadSuccessed(String str, d dVar) {
        AppMethodBeat.i(150365);
        if (this.iRi != null) {
            Log.v("MicroMsg.CdnTransportEngine", "klem keep_onUploadSuccessed mediaId:%s", str);
            a(dVar);
            this.iRi.a(str, null, dVar);
        }
        AppMethodBeat.o(150365);
        return 0;
    }

    public final int keep_onDownloadProgress(String str, c cVar) {
        int i2;
        AppMethodBeat.i(150366);
        cVar.field_isUploadTask = false;
        if (this.iRn != null) {
            i2 = this.iRn.a(str, cVar, null);
        } else {
            i2 = 0;
        }
        if (i2 == 0 && this.iRo != null) {
            i2 = this.iRo.a(str, cVar, null);
        }
        if (i2 == 0 && this.iRh != null) {
            i2 = this.iRh.a(str, cVar, null);
        }
        if (i2 == 0 && this.iRi != null) {
            this.iRi.a(str, cVar, null);
        }
        AppMethodBeat.o(150366);
        return 0;
    }

    public final int keep_onDownloadError(String str, d dVar) {
        int i2;
        AppMethodBeat.i(150367);
        if (this.iRn != null) {
            i2 = this.iRn.a(str, null, dVar);
        } else {
            i2 = 0;
        }
        if (i2 == 0 && this.iRo != null) {
            i2 = this.iRo.a(str, null, dVar);
        }
        if (i2 == 0 && this.iRh != null) {
            i2 = this.iRh.a(str, null, dVar);
        }
        if (i2 == 0 && this.iRi != null) {
            a(dVar);
            this.iRi.a(str, null, dVar);
        }
        AppMethodBeat.o(150367);
        return 0;
    }

    public final int keep_onDownloadSuccessed(String str, d dVar) {
        int i2;
        AppMethodBeat.i(150368);
        if (this.iRn != null) {
            i2 = this.iRn.a(str, null, dVar);
        } else {
            i2 = 0;
        }
        if (i2 == 0 && this.iRo != null) {
            i2 = this.iRo.a(str, null, dVar);
        }
        if (i2 == 0 && this.iRh != null) {
            i2 = this.iRh.a(str, null, dVar);
        }
        if (i2 == 0 && this.iRi != null) {
            a(dVar);
            this.iRi.a(str, null, dVar);
        }
        AppMethodBeat.o(150368);
        return 0;
    }

    public final void keep_cdnGetSkeyBuf(String str, ByteArrayOutputStream byteArrayOutputStream) {
        AppMethodBeat.i(150369);
        if (this.iRi != null) {
            this.iRi.a(str, byteArrayOutputStream);
        }
        AppMethodBeat.o(150369);
    }

    public final byte[] keep_cdnDecodePrepareResponse(String str, byte[] bArr) {
        AppMethodBeat.i(150370);
        if (this.iRi != null) {
            byte[] f2 = this.iRi.f(str, bArr);
            AppMethodBeat.o(150370);
            return f2;
        }
        AppMethodBeat.o(150370);
        return null;
    }

    public final void keep_onMoovReady(String str, long j2, long j3, String str2) {
        int i2;
        AppMethodBeat.i(184253);
        Log.i("MicroMsg.CdnTransportEngine", "keep_onMoovReady %s, %d, %d, %s, hash[%d]", str, Long.valueOf(j2), Long.valueOf(j3), str2, Integer.valueOf(hashCode()));
        if (this.iRn != null) {
            i2 = this.iRn.d(str, (int) j2, (int) j3, str2);
        } else {
            i2 = 0;
        }
        if (i2 == 0 && this.iRo != null) {
            i2 = this.iRo.d(str, (int) j2, (int) j3, str2);
        }
        if (i2 == 0) {
            Log.e("MicroMsg.CdnTransportEngine", "cdn call on moov ready but onlineVideoCallback is null.hash[%d]", Integer.valueOf(hashCode()));
            com.tencent.mm.plugin.report.service.h.INSTANCE.dN(com.tencent.mm.plugin.appbrand.jsapi.nfc.f.CTRL_INDEX, 29);
        }
        AppMethodBeat.o(184253);
    }

    public final void keep_onDataAvailable(String str, long j2, long j3) {
        int i2 = 0;
        AppMethodBeat.i(150372);
        Log.i("MicroMsg.CdnTransportEngine", "keep_onDataAvailable %s, %d, %d", str, Long.valueOf(j2), Long.valueOf(j3));
        if (this.iRn != null) {
            i2 = this.iRn.p(str, (int) j2, (int) j3);
        }
        if (i2 == 0 && this.iRo != null) {
            this.iRo.p(str, (int) j2, (int) j3);
        }
        AppMethodBeat.o(150372);
    }

    public final void keep_onDownloadToEnd(String str, long j2, long j3) {
        int i2 = 0;
        AppMethodBeat.i(150373);
        Log.i("MicroMsg.CdnTransportEngine", "keep_onDownloadToEnd %s, %d, %d", str, Long.valueOf(j2), Long.valueOf(j3));
        if (this.iRn != null) {
            i2 = this.iRn.p(str, (int) j2, (int) j3);
        }
        if (i2 == 0 && this.iRo != null) {
            this.iRo.q(str, (int) j2, (int) j3);
        }
        AppMethodBeat.o(150373);
    }

    private static void a(d dVar) {
        AppMethodBeat.i(150374);
        if (dVar != null && !Util.isNullOrNil(dVar.field_transInfo)) {
            int indexOf = dVar.field_transInfo.indexOf("@,");
            if (indexOf > 0) {
                dVar.gqk = dVar.field_transInfo.substring(indexOf + 2);
                dVar.field_transInfo = dVar.field_transInfo.substring(0, indexOf);
            }
            Log.v("MicroMsg.CdnTransportEngine", "transinfo:%s, report_part2:%s", dVar.field_transInfo, dVar.gqk);
        }
        AppMethodBeat.o(150374);
    }

    public final void keep_cdnSendAndRecvData(String str, int i2, int i3) {
        AppMethodBeat.i(150375);
        if (i2 < 0 || i3 < 0) {
            AppMethodBeat.o(150375);
            return;
        }
        this.iRj += i2;
        this.iRk += i3;
        if (!Util.isNullOrNil(str)) {
            this.iRl = str;
        }
        if (this.iRj + this.iRk > 51200 && this.iRm != null) {
            this.iRm.startTimer(500);
        }
        AppMethodBeat.o(150375);
    }

    public final void keep_OnRequestDoGetCdnDnsInfo(int i2) {
        AppMethodBeat.i(150376);
        g.aAf();
        if (com.tencent.mm.kernel.a.azo()) {
            f.baN().sU(i2);
        }
        AppMethodBeat.o(150376);
    }

    @Override // com.tencent.mars.cdn.CdnLogic.AppCallback
    public final void requestGetCDN(int i2) {
        AppMethodBeat.i(150377);
        if (!MMApplicationContext.isMMProcess()) {
            AppMethodBeat.o(150377);
            return;
        }
        Log.i("MicroMsg.CdnTransportEngine", "requestgetcdn scene %d", Integer.valueOf(i2));
        keep_OnRequestDoGetCdnDnsInfo(i2);
        AppMethodBeat.o(150377);
    }

    @Override // com.tencent.mars.cdn.CdnLogic.AppCallback
    public final void reportFlow(int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(150378);
        if (!MMApplicationContext.isMMProcess()) {
            AppMethodBeat.o(150378);
            return;
        }
        Log.i("MicroMsg.CdnTransportEngine", "ReportFlow, wifi:s:%d, r:%d, mobile:s:%d, r:%d", Integer.valueOf(i3), Integer.valueOf(i2), Integer.valueOf(i5), Integer.valueOf(i4));
        keep_cdnSendAndRecvData("dummy clientmsgid", i3 + i5, i2 + i4);
        AppMethodBeat.o(150378);
    }

    @Override // com.tencent.mars.cdn.CdnLogic.AppCallback
    public final String[] resolveHost(String str, boolean z, int[] iArr) {
        AppMethodBeat.i(150379);
        if (!MMApplicationContext.isMMProcess()) {
            AppMethodBeat.o(150379);
            return null;
        }
        Log.i("MicroMsg.CdnTransportEngine", "try resolve host %s, isdc %b", str, Boolean.valueOf(z));
        ArrayList arrayList = new ArrayList();
        iArr[0] = com.tencent.mm.network.d.a(str, z, arrayList);
        String[] strArr = (String[]) arrayList.toArray(new String[0]);
        Log.i("MicroMsg.CdnTransportEngine", "resolved dnstype %d iplist %s", Integer.valueOf(iArr[0]), Arrays.toString(strArr));
        AppMethodBeat.o(150379);
        return strArr;
    }

    @Override // com.tencent.mars.cdn.CdnLogic.AppCallback
    public final void onBadNetworkProbed() {
        AppMethodBeat.i(150380);
        Log.w("MicroMsg.CdnTransportEngine", "bad network probed by CDN, try analyze STN network.");
        StnLogic.startNetworkAnalysis();
        AppMethodBeat.o(150380);
    }

    @Override // com.tencent.mars.cdn.CdnLogic.UploadCallback
    public final void onUploadProgressChanged(String str, long j2, long j3) {
        AppMethodBeat.i(150381);
        c cVar = new c();
        cVar.field_finishedLength = j2;
        cVar.field_toltalLength = j3;
        cVar.field_status = 0;
        cVar.field_mtlnotify = false;
        keep_onUploadProgress(str, cVar);
        AppMethodBeat.o(150381);
    }

    @Override // com.tencent.mars.cdn.CdnLogic.UploadCallback
    public final void onC2CUploadCompleted(String str, CdnLogic.C2CUploadResult c2CUploadResult) {
        AppMethodBeat.i(150382);
        Log.i("MicroMsg.CdnTransportEngine", "onC2CUploadCompleted filekey %s error %d", str, Integer.valueOf(c2CUploadResult.errorCode));
        d dVar = new d();
        dVar.field_retCode = c2CUploadResult.errorCode;
        dVar.field_toUser = c2CUploadResult.touser;
        dVar.field_UploadHitCacheType = c2CUploadResult.hitCache;
        dVar.field_fileId = c2CUploadResult.fileid;
        dVar.field_aesKey = c2CUploadResult.aeskey;
        dVar.field_filemd5 = c2CUploadResult.filemd5;
        dVar.field_thumbfilemd5 = c2CUploadResult.thumbfilemd5;
        dVar.field_mp4identifymd5 = c2CUploadResult.mp4identifymd5;
        dVar.field_transInfo = c2CUploadResult.transforMsg;
        dVar.field_fileLength = (long) c2CUploadResult.fileSize;
        dVar.field_midimgLength = c2CUploadResult.midfileSize;
        dVar.field_thumbimgLength = c2CUploadResult.thumbfileSize;
        dVar.field_needSendMsgField = !c2CUploadResult.sendmsgFromCDN;
        dVar.field_exist_whencheck = c2CUploadResult.existOnSvr;
        if (c2CUploadResult.skeyrespbuf != null) {
            dVar.field_sKeyrespbuf = (byte[]) c2CUploadResult.skeyrespbuf.clone();
        }
        dVar.field_videoFileId = c2CUploadResult.videofileid;
        dVar.field_filecrc = c2CUploadResult.fileCrc32;
        dVar.field_upload_by_safecdn = c2CUploadResult.uploadBySafecdn;
        dVar.field_isVideoReduced = c2CUploadResult.isVideoReduced;
        if (c2CUploadResult.usedSvrIps != null) {
            dVar.field_usedSvrIps = (String[]) c2CUploadResult.usedSvrIps.clone();
        }
        dVar.field_fileUrl = c2CUploadResult.fileUrl;
        dVar.field_thumbUrl = c2CUploadResult.thumbfileUrl;
        dVar.emojiMD5 = c2CUploadResult.emojiMD5;
        dVar.field_isResume = c2CUploadResult.isResume;
        dVar.field_delayTime = c2CUploadResult.delayTime;
        dVar.field_connectCostTime = c2CUploadResult.connectCostTime;
        dVar.field_waitResponseCostTime = c2CUploadResult.waitResponseCostTime;
        dVar.field_receiveCostTime = c2CUploadResult.receiveCostTime;
        dVar.field_clientIP = c2CUploadResult.clientIP;
        dVar.field_serverIP = c2CUploadResult.serverIP;
        dVar.field_clientHostIP = Oa(c2CUploadResult.clientIP);
        dVar.field_serverHostIP = Oa(c2CUploadResult.serverIP);
        dVar.transportProtocol = c2CUploadResult.transportProtocol;
        dVar.transportProtocolError = c2CUploadResult.transportProtocolError;
        dVar.field_detailErrorType = c2CUploadResult.detailErrorType;
        dVar.field_detailErrorCode = c2CUploadResult.detailErrorCode;
        if (dVar.field_retCode != 0) {
            com.tencent.mm.g.b.a.z zVar = new com.tencent.mm.g.b.a.z();
            com.tencent.mm.g.b.a.z ib = zVar.ib(str);
            ib.ena = 0;
            ib.enb = c2CUploadResult.detailErrorType;
            ib.enc = c2CUploadResult.detailErrorCode;
            ib.ene = c2CUploadResult.errorCode;
            ib.eng = c2CUploadResult.filetype;
            ib.enh = 0;
            ib.eni = 0;
            ib.ic(c2CUploadResult.systemErrorDescribe);
            zVar.bfK();
            Log.i("MicroMsg.CdnTransportEngine", "reportstr %s", zVar.abW());
            keep_onUploadError(str, dVar);
            AppMethodBeat.o(150382);
            return;
        }
        keep_onUploadSuccessed(str, dVar);
        AppMethodBeat.o(150382);
    }

    @Override // com.tencent.mars.cdn.CdnLogic.SessionCallback
    public final byte[] getSessionRequestBuf(String str, byte[] bArr) {
        AppMethodBeat.i(150383);
        if (!MMApplicationContext.isMMProcess()) {
            AppMethodBeat.o(150383);
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        keep_cdnGetSkeyBuf(str, byteArrayOutputStream);
        if (byteArrayOutputStream.size() > 0) {
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            AppMethodBeat.o(150383);
            return byteArray;
        }
        AppMethodBeat.o(150383);
        return null;
    }

    @Override // com.tencent.mars.cdn.CdnLogic.SessionCallback
    public final byte[] decodeSessionResponseBuf(String str, byte[] bArr) {
        AppMethodBeat.i(150384);
        if (!MMApplicationContext.isMMProcess()) {
            AppMethodBeat.o(150384);
            return null;
        }
        byte[] keep_cdnDecodePrepareResponse = keep_cdnDecodePrepareResponse(str, bArr);
        AppMethodBeat.o(150384);
        return keep_cdnDecodePrepareResponse;
    }

    @Override // com.tencent.mars.cdn.CdnLogic.DownloadCallback
    public final void onDownloadProgressChanged(String str, long j2, long j3, boolean z) {
        AppMethodBeat.i(150385);
        c cVar = new c();
        cVar.field_finishedLength = j2;
        cVar.field_toltalLength = j3;
        cVar.field_status = 0;
        cVar.field_mtlnotify = z;
        keep_onDownloadProgress(str, cVar);
        AppMethodBeat.o(150385);
    }

    @Override // com.tencent.mars.cdn.CdnLogic.DownloadCallback
    public final void onC2CDownloadCompleted(String str, CdnLogic.C2CDownloadResult c2CDownloadResult) {
        String str2;
        AppMethodBeat.i(150386);
        Log.i("MicroMsg.CdnTransportEngine", "onC2CDownloadCompleted filekey %s error %d", str, Integer.valueOf(c2CDownloadResult.errorCode));
        d a2 = a(c2CDownloadResult, (d) null);
        if (c2CDownloadResult.fromCronet && c2CDownloadResult.cronetTaskResult != null) {
            Object[] objArr = new Object[3];
            objArr[0] = c2CDownloadResult.cronetTaskResult.useHttp2 ? ServerProtocol.DIALOG_RETURN_SCOPES_TRUE : "false";
            if (c2CDownloadResult.cronetTaskResult.useQuic) {
                str2 = ServerProtocol.DIALOG_RETURN_SCOPES_TRUE;
            } else {
                str2 = "false";
            }
            objArr[1] = str2;
            objArr[2] = Integer.valueOf(c2CDownloadResult.cronetTaskResult.statusCode);
            Log.i("MicroMsg.CdnTransportEngine", "cronet this task is from cronet ,use http2 %s, use quic %s, status code %d ", objArr);
            Log.i("MicroMsg.CdnTransportEngine", "cronet webperformance ip:%s, protocol:%s", c2CDownloadResult.cronetTaskResult.performance.peerIP, c2CDownloadResult.cronetTaskResult.performance.protocol);
            a2.fromCronet = true;
            a2.cronetTaskResult = new CdnLogic.CronetTaskResult();
            a2.cronetTaskResult.useQuic = c2CDownloadResult.cronetTaskResult.useQuic;
            a2.cronetTaskResult.useHttp2 = c2CDownloadResult.cronetTaskResult.useHttp2;
            a2.cronetTaskResult.statusCode = c2CDownloadResult.cronetTaskResult.statusCode;
            a2.cronetTaskResult.statusText = c2CDownloadResult.cronetTaskResult.statusText;
            a2.cronetTaskResult.performance = c2CDownloadResult.cronetTaskResult.performance;
            a2.field_httpStatusCode = c2CDownloadResult.cronetTaskResult.statusCode;
        }
        long currentTimeMillis = System.currentTimeMillis() - c2CDownloadResult.taskStartTime;
        if (com.tencent.mm.i.a.gqa == c2CDownloadResult.fileType) {
            if (c2CDownloadResult.fromCronet) {
                Log.i("MicroMsg.CdnTransportEngine", "cronet task use cronet download time ".concat(String.valueOf(currentTimeMillis)));
                com.tencent.mm.plugin.report.service.h.INSTANCE.n(1173, 97, 1);
                com.tencent.mm.plugin.report.service.h.INSTANCE.n(1173, 99, currentTimeMillis);
                if (c2CDownloadResult.cronetTaskResult != null) {
                    if (c2CDownloadResult.cronetTaskResult.useQuic) {
                        com.tencent.mm.plugin.report.service.h.INSTANCE.n(1173, 94, 1);
                        com.tencent.mm.plugin.report.service.h.INSTANCE.n(1173, 95, currentTimeMillis);
                        Log.i("MicroMsg.CdnTransportEngine", "cronet task use cronet quic download time ".concat(String.valueOf(currentTimeMillis)));
                    } else if (c2CDownloadResult.cronetTaskResult.useHttp2) {
                        com.tencent.mm.plugin.report.service.h.INSTANCE.n(1173, 91, 1);
                        com.tencent.mm.plugin.report.service.h.INSTANCE.n(1173, 92, currentTimeMillis);
                        Log.i("MicroMsg.CdnTransportEngine", "cronet task use cronet http2 download time ".concat(String.valueOf(currentTimeMillis)));
                    } else {
                        com.tencent.mm.plugin.report.service.h.INSTANCE.n(1173, 88, 1);
                        com.tencent.mm.plugin.report.service.h.INSTANCE.n(1173, 89, currentTimeMillis);
                        Log.i("MicroMsg.CdnTransportEngine", "cronet task use cronet http1.x download time ".concat(String.valueOf(currentTimeMillis)));
                    }
                }
            } else {
                Log.i("MicroMsg.CdnTransportEngine", "cronet task use normal download time ".concat(String.valueOf(currentTimeMillis)));
                com.tencent.mm.plugin.report.service.h.INSTANCE.n(1173, 100, 1);
                com.tencent.mm.plugin.report.service.h.INSTANCE.n(1173, 98, currentTimeMillis);
            }
        }
        if (a2.field_retCode != 0) {
            com.tencent.mm.g.b.a.z zVar = new com.tencent.mm.g.b.a.z();
            com.tencent.mm.g.b.a.z ib = zVar.ib(str);
            ib.ena = 1;
            ib.enb = c2CDownloadResult.detailErrorType;
            ib.enc = c2CDownloadResult.detailErrorCode;
            ib.ene = c2CDownloadResult.errorCode;
            ib.eng = c2CDownloadResult.fileType;
            ib.enh = c2CDownloadResult.tryWritenBytes;
            ib.eni = c2CDownloadResult.availableBytes;
            ib.ic(c2CDownloadResult.systemErrorDescribe).enk = c2CDownloadResult.currentFileSize;
            zVar.bfK();
            Log.i("MicroMsg.CdnTransportEngine", "reportstr %s", zVar.abW());
            keep_onDownloadError(str, a2);
            AppMethodBeat.o(150386);
            return;
        }
        keep_onDownloadSuccessed(str, a2);
        AppMethodBeat.o(150386);
    }

    @Override // com.tencent.mars.cdn.CdnLogic.VideoStreamingCallback
    public final void onM3U8Ready(String str, String str2) {
        AppMethodBeat.i(223545);
        Log.i("MicroMsg.CdnTransportEngine", "onM3U8Ready %s, %d, hash[%d]", str, Integer.valueOf(str2.length()), Integer.valueOf(hashCode()));
        Log.e("MicroMsg.CdnTransportEngine", "cdn call on m3u8 ready but onlineVideoCallback is null.hash[%d]", Integer.valueOf(hashCode()));
        com.tencent.mm.plugin.report.service.h.INSTANCE.dN(com.tencent.mm.plugin.appbrand.jsapi.nfc.f.CTRL_INDEX, 29);
        AppMethodBeat.o(223545);
    }

    @Override // com.tencent.mars.cdn.CdnLogic.VideoStreamingCallback
    public final void onMoovReadyWithFlag(String str, long j2, long j3, String str2) {
        AppMethodBeat.i(184254);
        keep_onMoovReady(str, j2, j3, str2);
        AppMethodBeat.o(184254);
    }

    @Override // com.tencent.mars.cdn.CdnLogic.VideoStreamingCallback
    public final void onDataAvailable(String str, long j2, long j3) {
        AppMethodBeat.i(150388);
        keep_onDataAvailable(str, j2, j3);
        AppMethodBeat.o(150388);
    }

    @Override // com.tencent.mars.cdn.CdnLogic.VideoStreamingCallback
    public final void onDownloadToEnd(String str, long j2, long j3) {
        AppMethodBeat.i(150389);
        keep_onDownloadToEnd(str, j2, j3);
        AppMethodBeat.o(150389);
    }

    @Override // com.tencent.mars.cdn.CdnLogic.VideoStreamingCallback
    public final void onPreloadCompletedWithResult(String str, long j2, long j3, CdnLogic.C2CDownloadResult c2CDownloadResult) {
        AppMethodBeat.i(150390);
        c2CDownloadResult.recvedBytes = (long) ((int) j2);
        d a2 = a(c2CDownloadResult, (d) null);
        int i2 = 0;
        if (this.iRh != null) {
            i2 = this.iRh.a(str, a2);
        }
        if (i2 == 0 && this.iRi != null) {
            this.iRi.a(str, a2);
        }
        AppMethodBeat.o(150390);
    }

    public final int b(com.tencent.mm.i.g gVar) {
        boolean z = true;
        AppMethodBeat.i(150336);
        CdnLogic.C2CUploadRequest c2CUploadRequest = new CdnLogic.C2CUploadRequest();
        c2CUploadRequest.fileKey = gVar.field_mediaId;
        c2CUploadRequest.setFilePath(gVar.field_fullpath);
        c2CUploadRequest.setThumbfilePath(gVar.field_thumbpath);
        c2CUploadRequest.fileSize = gVar.field_totalLen;
        c2CUploadRequest.fileType = gVar.field_fileType;
        c2CUploadRequest.forwardAeskey = gVar.field_aesKey;
        c2CUploadRequest.forwardFileid = gVar.field_fileId;
        c2CUploadRequest.midfileSize = gVar.field_midFileLength;
        c2CUploadRequest.queueTimeoutSeconds = gVar.gqC;
        c2CUploadRequest.transforTimeoutSeconds = gVar.gqD;
        c2CUploadRequest.toUser = gVar.field_talker;
        c2CUploadRequest.sendmsgFromCDN = gVar.field_sendmsg_viacdn;
        c2CUploadRequest.needCompressImage = gVar.field_needCompressImage;
        c2CUploadRequest.chatType = gVar.field_chattype;
        c2CUploadRequest.apptype = gVar.field_appType;
        c2CUploadRequest.bizscene = gVar.field_bzScene;
        c2CUploadRequest.marscdnBizType = gVar.fuQ;
        c2CUploadRequest.checkExistOnly = gVar.field_onlycheckexist;
        c2CUploadRequest.isSmallVideo = gVar.field_smallVideoFlag == 1;
        c2CUploadRequest.isLargeSVideo = gVar.field_largesvideo;
        c2CUploadRequest.videoSource = gVar.field_videosource;
        if (gVar.field_advideoflag != 1) {
            z = false;
        }
        c2CUploadRequest.isSnsAdVideo = z;
        c2CUploadRequest.isStorageMode = gVar.field_needStorage;
        c2CUploadRequest.isStreamMedia = gVar.field_isStreamMedia;
        c2CUploadRequest.enableHitCheck = gVar.field_enable_hitcheck;
        c2CUploadRequest.forceNoSafeCdn = gVar.field_force_aeskeycdn;
        c2CUploadRequest.trySafeCdn = gVar.field_trysafecdn;
        c2CUploadRequest.setMidimgPath(gVar.field_midimgpath);
        c2CUploadRequest.bigfileSignature = gVar.field_svr_signature;
        if (Util.isNullOrNil(c2CUploadRequest.bigfileSignature)) {
            c2CUploadRequest.bigfileSignature = "";
        }
        c2CUploadRequest.fakeBigfileSignature = gVar.field_fake_bigfile_signature;
        if (Util.isNullOrNil(c2CUploadRequest.fakeBigfileSignature)) {
            c2CUploadRequest.fakeBigfileSignature = "";
        }
        c2CUploadRequest.fakeBigfileSignatureAeskey = gVar.field_fake_bigfile_signature_aeskey;
        if (Util.isNullOrNil(c2CUploadRequest.fakeBigfileSignatureAeskey)) {
            c2CUploadRequest.fakeBigfileSignatureAeskey = "";
        }
        c2CUploadRequest.lastError = gVar.lastError;
        c2CUploadRequest.emojiExtinfo = gVar.emojiExtinfo;
        c2CUploadRequest.snsVersion = gVar.snsVersion;
        c2CUploadRequest.fileBuffer = gVar.fileBuffer;
        c2CUploadRequest.thumbnailBuffer = gVar.thumbnailBuffer;
        c2CUploadRequest.customHeader = gVar.customHeader;
        c2CUploadRequest.useMultithread = gVar.field_use_multithread;
        if (ac.jOV && ac.jPa.length() > 0) {
            c2CUploadRequest.debugIP = ac.jPa;
            Log.w("MicroMsg.CdnTransportEngine", "debugip " + c2CUploadRequest.debugIP);
        }
        if (c2CUploadRequest.sendmsgFromCDN) {
            int startSSUpload = CdnLogic.startSSUpload(c2CUploadRequest, this, this);
            AppMethodBeat.o(150336);
            return startSSUpload;
        }
        int startC2CUpload = CdnLogic.startC2CUpload(c2CUploadRequest, this);
        AppMethodBeat.o(150336);
        return startC2CUpload;
    }
}

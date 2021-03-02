package com.tencent.mm.bk;

import android.annotation.TargetApi;
import android.text.TextUtils;
import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.compatible.i.d;
import com.tencent.mm.ipcinvoker.k;
import com.tencent.mm.ipcinvoker.type.IPCBoolean;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.kernel.g;
import com.tencent.mm.media.i.d;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.modelvideo.r;
import com.tencent.mm.plugin.appbrand.jsapi.nfc.f;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.s;
import java.util.ArrayList;

@TargetApi(16)
public final class e {
    private static final Object jtt = new Object();
    private static volatile boolean jtu = false;

    static /* synthetic */ void D(int i2, long j2) {
        AppMethodBeat.i(127100);
        C(i2, j2);
        AppMethodBeat.o(127100);
    }

    static /* synthetic */ void b(String str, String str2, VideoTransPara videoTransPara, long j2) {
        AppMethodBeat.i(127099);
        a(str, str2, videoTransPara, j2);
        AppMethodBeat.o(127099);
    }

    static {
        AppMethodBeat.i(127101);
        AppMethodBeat.o(127101);
    }

    public static boolean QW(String str) {
        AppMethodBeat.i(127091);
        Log.i("MicroMsg.TransferUtil", "Check video format：h265 or h264？");
        boolean isH265Video = r.isH265Video(str);
        AppMethodBeat.o(127091);
        return isH265Video;
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x010f A[Catch:{ all -> 0x0175 }] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x012a  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0134  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.tencent.mm.modelcontrol.VideoTransPara QX(java.lang.String r14) {
        /*
        // Method dump skipped, instructions count: 377
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.bk.e.QX(java.lang.String):com.tencent.mm.modelcontrol.VideoTransPara");
    }

    public static VideoTransPara a(VideoTransPara videoTransPara, String str) {
        AppMethodBeat.i(127093);
        VideoTransPara c2 = com.tencent.mm.modelcontrol.e.baZ().c(videoTransPara);
        if (c2 == null) {
            Log.i("MicroMsg.TransferUtil", "get C2C album video para is null. old para %s", videoTransPara);
            VideoTransPara QY = QY(str);
            AppMethodBeat.o(127093);
            return QY;
        }
        Log.d("MicroMsg.TransferUtil", "compress new para is %s", c2);
        if (videoTransPara.videoBitrate <= 640000 || c2.videoBitrate > videoTransPara.videoBitrate) {
            Log.i("MicroMsg.TransferUtil", "new bitrate is bigger than old bitrate %s %s", c2, videoTransPara);
            VideoTransPara QY2 = QY(str);
            AppMethodBeat.o(127093);
            return QY2;
        } else if (videoTransPara.fps < 45 || videoTransPara.duration * 1000 < 180000) {
            AppMethodBeat.o(127093);
            return c2;
        } else {
            VideoTransPara QY3 = QY(str);
            AppMethodBeat.o(127093);
            return QY3;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x007a, code lost:
        r6[0] = r3;
        r6[1] = r2;
        r1.release();
     */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00a6  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.tencent.mm.modelcontrol.VideoTransPara QY(java.lang.String r11) {
        /*
        // Method dump skipped, instructions count: 178
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.bk.e.QY(java.lang.String):com.tencent.mm.modelcontrol.VideoTransPara");
    }

    public static int hj(String str) {
        int i2 = 0;
        AppMethodBeat.i(127095);
        d dVar = new d();
        dVar.setDataSource(str);
        String extractMetadata = dVar.extractMetadata(9);
        dVar.release();
        if (extractMetadata == null) {
            AppMethodBeat.o(127095);
        } else {
            try {
                i2 = Integer.valueOf(extractMetadata).intValue();
                AppMethodBeat.o(127095);
            } catch (Exception e2) {
                Log.e("MicroMsg.TransferUtil", "getDuration error %s", e2.getMessage());
                AppMethodBeat.o(127095);
            }
        }
        return i2;
    }

    static class a implements k<IPCVoid, IPCBoolean> {
        private a() {
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.tencent.mm.ipcinvoker.k
        public final /* synthetic */ IPCBoolean invoke(IPCVoid iPCVoid) {
            boolean z;
            AppMethodBeat.i(127090);
            if (((com.tencent.mm.plugin.zero.b.a) g.af(com.tencent.mm.plugin.zero.b.a.class)).aqJ().getInt("HEVCTranscodeMediaCodec", 1) == 1) {
                z = true;
            } else {
                z = false;
            }
            IPCBoolean iPCBoolean = new IPCBoolean(z);
            AppMethodBeat.o(127090);
            return iPCBoolean;
        }
    }

    public static int a(final String str, final String str2, final VideoTransPara videoTransPara) {
        boolean z;
        long j2;
        com.tencent.mm.media.i.d a2;
        g gVar;
        int i2;
        AppMethodBeat.i(127096);
        Log.i("MicroMsg.TransferUtil", "Begin to local tranfer");
        final long currentTicks = Util.currentTicks();
        jtu = false;
        AnonymousClass1 r4 = new d.b() {
            /* class com.tencent.mm.bk.e.AnonymousClass1 */

            @Override // com.tencent.mm.media.i.d.b
            public final void Hn(String str) {
                AppMethodBeat.i(127089);
                Log.i("MicroMsg.TransferUtil", "mediaCodecRemuxer remux onFinish");
                if (Util.isNullOrNil(str)) {
                    Log.e("MicroMsg.TransferUtil", "MediaCodecRemuxer remux failed, ret path is null, retry x264");
                    h.INSTANCE.idkeyStat(354, 244, 1, false);
                    try {
                        e.b(str, str2, videoTransPara, currentTicks);
                    } catch (Exception e2) {
                        Log.i("MicroMsg.TransferUtil", "fallbackTransferWithVideoTransfer error!!!");
                        e.D(-1, currentTicks);
                    }
                    synchronized (e.jtt) {
                        try {
                            e.jtt.notifyAll();
                            boolean unused = e.jtu = true;
                        } catch (Exception e3) {
                            Log.printErrStackTrace("MicroMsg.TransferUtil", e3, "wait mediaCodecRemuxer error", new Object[0]);
                        }
                        try {
                        } catch (Throwable th) {
                            AppMethodBeat.o(127089);
                            throw th;
                        }
                    }
                    AppMethodBeat.o(127089);
                    return;
                }
                e.D(0, currentTicks);
                synchronized (e.jtt) {
                    try {
                        e.jtt.notifyAll();
                        boolean unused2 = e.jtu = true;
                    } catch (Exception e4) {
                        Log.printErrStackTrace("MicroMsg.TransferUtil", e4, "wait mediaCodecRemuxer error", new Object[0]);
                    }
                    try {
                    } catch (Throwable th2) {
                        AppMethodBeat.o(127089);
                        throw th2;
                    }
                }
                AppMethodBeat.o(127089);
            }
        };
        boolean z2 = true;
        try {
            if (MMApplicationContext.isMMProcess()) {
                z2 = ((com.tencent.mm.plugin.zero.b.a) g.af(com.tencent.mm.plugin.zero.b.a.class)).aqJ().getInt("HEVCTranscodeMediaCodec", 1) == 1;
            } else {
                IPCBoolean iPCBoolean = (IPCBoolean) com.tencent.mm.ipcinvoker.h.a(MainProcessIPCService.dkO, new IPCVoid(), a.class);
                if (iPCBoolean != null) {
                    z2 = iPCBoolean.value;
                }
            }
            int i3 = ae.gKE.gHK;
            if (i3 != -1) {
                z = i3 == 1;
            } else {
                z = !z2;
            }
            Log.i("MicroMsg.TransferUtil", "serverConfigMediaCodec: %s, dynamicConfigX264: %s, useX264: %s", Boolean.valueOf(z2), Integer.valueOf(i3), Boolean.valueOf(z));
            if (z) {
                gVar = new g();
                gVar.b(str, str2, videoTransPara);
                gVar.jtJ = true;
                gVar.jtK = z;
                a2 = null;
                j2 = 300000;
            } else {
                com.tencent.mm.plugin.sight.base.a aNx = com.tencent.mm.plugin.sight.base.e.aNx(str);
                if (aNx != null && aNx.frameRate > 0) {
                    videoTransPara.fps = (int) Math.min(30.0f, (float) aNx.frameRate);
                    Log.i("MicroMsg.TransferUtil", "transfer h265 use 30fps, newPara.fps:%s, mediaInfo.frameRate:%s", Integer.valueOf(videoTransPara.fps), Integer.valueOf(aNx.frameRate));
                    if (aNx.videoDuration > 0) {
                        j2 = (long) (aNx.videoDuration * 3);
                        a2 = com.tencent.mm.media.i.d.ihF.a(str, str2, videoTransPara.width, videoTransPara.height, videoTransPara.videoBitrate, videoTransPara.fps, videoTransPara.idF, videoTransPara.idG, r4);
                        gVar = null;
                    }
                }
                j2 = 300000;
                a2 = com.tencent.mm.media.i.d.ihF.a(str, str2, videoTransPara.width, videoTransPara.height, videoTransPara.videoBitrate, videoTransPara.fps, videoTransPara.idF, videoTransPara.idG, r4);
                gVar = null;
            }
            int i4 = 0;
            if (gVar != null && z) {
                try {
                    i4 = gVar.AM((long) hj(str));
                    C(i4, currentTicks);
                } catch (Exception e2) {
                    i2 = -1;
                    Log.e("MicroMsg.TransferUtil", "Local tranfer to H264 error: %s", e2.getMessage());
                    b.jtf.aRR();
                } catch (Throwable th) {
                    b.jtf.aRR();
                    AppMethodBeat.o(127096);
                    throw th;
                }
            } else if (a2 != null) {
                try {
                    Log.i("MicroMsg.TransferUtil", "start mediaCodecRemuxer remux callbackHasTriggered:%s waitDuration:%s", Boolean.valueOf(jtu), Long.valueOf(j2));
                    a2.aMG();
                    if (!jtu) {
                        synchronized (jtt) {
                            try {
                                long a3 = (long) ((b) g.af(b.class)).a(b.a.clicfg_c2c_video_transfer_wait_timeout, -1);
                                if (a3 > 0) {
                                    Log.i("MicroMsg.TransferUtil", "force set wait timeout %s", Long.valueOf(a3));
                                    j2 = a3;
                                }
                                jtt.wait(j2);
                            } catch (Exception e3) {
                                Log.printErrStackTrace("MicroMsg.TransferUtil", e3, "wait mediaCodecRemux error", new Object[0]);
                            }
                            try {
                            } catch (Throwable th2) {
                                AppMethodBeat.o(127096);
                                throw th2;
                            }
                        }
                    }
                    Log.i("MicroMsg.TransferUtil", "mediaCodecRemuxLock wait finish");
                } catch (Exception e4) {
                    Log.i("MicroMsg.TransferUtil", "MediaCodecRemuxer remux, retry x264, error:%s", e4.getMessage());
                    a(str, str2, videoTransPara, currentTicks);
                }
            }
            if (videoTransPara == null) {
                Log.e("MicroMsg.TransferUtil", "checkRemuxResult newPara == null");
            } else if (TextUtils.isEmpty(str2)) {
                Log.e("MicroMsg.TransferUtil", "checkRemuxResult path is empty, destPath:[%s]", str2);
            } else {
                PInt pInt = new PInt();
                PInt pInt2 = new PInt();
                PInt pInt3 = new PInt();
                PInt pInt4 = new PInt();
                PInt pInt5 = new PInt();
                com.tencent.mm.plugin.sight.base.e.a(str2, pInt, pInt2, pInt3, pInt4, pInt5);
                float f2 = Util.getFloat(((com.tencent.mm.plugin.zero.b.a) g.af(com.tencent.mm.plugin.zero.b.a.class)).aqJ().getValue("MMSightCheckSendVideoBitrateLimit"), 1.3f);
                int i5 = pInt5.value;
                int i6 = videoTransPara.videoBitrate;
                if (((float) i5) < f2 * ((float) i6)) {
                    Log.i("MicroMsg.TransferUtil", "checkRemuxResult success currentBitrate:[%d], maxBitrate:[%d]", Integer.valueOf(i5), Integer.valueOf(i6));
                } else {
                    long currentTimeMillis = System.currentTimeMillis();
                    Log.w("MicroMsg.TransferUtil", "checkRemuxResult fail currentBitrate:[%d], maxBitrate:[%d]", Integer.valueOf(i5), Integer.valueOf(i6));
                    String str3 = str2 + ".check_temp";
                    s.nw(str2, str3);
                    s.deleteFile(str2);
                    int remuxingVFS = SightVideoJNI.remuxingVFS(str3, str2, videoTransPara.width, videoTransPara.height, videoTransPara.videoBitrate, videoTransPara.iSV, 8, videoTransPara.iSU, 25.0f, (float) videoTransPara.fps, null, 0, false, 0, 51);
                    h.INSTANCE.n(986, 119, 1);
                    Log.i("MicroMsg.TransferUtil", "checkRemuxResult speedTime:[%s], remuxingVFS ret:[%d]", Long.valueOf(System.currentTimeMillis() - currentTimeMillis), Integer.valueOf(remuxingVFS));
                }
            }
            String aFm = com.tencent.mm.plugin.sight.base.e.aFm(str);
            String aFm2 = com.tencent.mm.plugin.sight.base.e.aFm(str2);
            if (!s.YS(str2)) {
                h.INSTANCE.idkeyStat(354, 243, 1, false);
                Log.e("MicroMsg.TransferUtil", "dst path(%s) does not exist file", str2);
            }
            Log.i("MicroMsg.TransferUtil", "tranferToH264 result \nsrcPath:[%s], srcPathVal:[%s], \ndstPath:[%s], dstPathVal:[%s]", str, aFm, str2, aFm2);
            b.jtf.aRR();
            i2 = i4;
            AppMethodBeat.o(127096);
            return i2;
        } catch (Exception e5) {
            Log.e("MicroMsg.TransferUtil", "Local tranfer init failed: %s", e5.getMessage());
            AppMethodBeat.o(127096);
            return -1;
        }
    }

    private static void a(String str, String str2, VideoTransPara videoTransPara, long j2) {
        AppMethodBeat.i(127097);
        Log.printInfoStack("MicroMsg.TransferUtil", "fallbackTransferWithVideoTransfer, srcPath:%s, dstPath:%s, newPara:%s", str, str2, videoTransPara);
        g gVar = new g();
        gVar.b(str, str2, videoTransPara);
        gVar.jtJ = true;
        gVar.jtK = true;
        int AM = gVar.AM((long) hj(str));
        Log.i("MicroMsg.TransferUtil", "fallbackTransferWithVideoTransfer, finish, segRet:%s", Integer.valueOf(AM));
        C(AM, j2);
        AppMethodBeat.o(127097);
    }

    private static void C(int i2, long j2) {
        AppMethodBeat.i(127098);
        if (i2 < 0) {
            Log.i("MicroMsg.TransferUtil", "Local tranfer to H264 failed：%s", Integer.valueOf(i2));
        }
        Log.i("MicroMsg.TransferUtil", "Transfer Finish");
        long currentTicks = Util.currentTicks() - j2;
        Log.i("MicroMsg.TransferUtil", "totalTime：%d", Long.valueOf(currentTicks));
        ArrayList<IDKey> arrayList = new ArrayList<>();
        IDKey iDKey = new IDKey();
        iDKey.SetID(f.CTRL_INDEX);
        iDKey.SetKey(253);
        iDKey.SetValue(currentTicks);
        IDKey iDKey2 = new IDKey();
        iDKey2.SetID(f.CTRL_INDEX);
        iDKey2.SetKey(254);
        iDKey2.SetValue(1);
        arrayList.add(iDKey);
        arrayList.add(iDKey2);
        h.INSTANCE.b(arrayList, false);
        AppMethodBeat.o(127098);
    }
}

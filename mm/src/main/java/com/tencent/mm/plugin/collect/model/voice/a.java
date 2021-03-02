package com.tencent.mm.plugin.collect.model.voice;

import com.facebook.appevents.AppEventsConstants;
import com.tencent.f.h;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.bp;
import com.tencent.mm.g.a.ci;
import com.tencent.mm.g.a.qk;
import com.tencent.mm.kernel.g;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.plugin.appbrand.jsapi.offlinevoice.d;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorageEx;
import com.tencent.mm.storage.ar;
import com.tencent.mm.vfs.s;
import java.util.concurrent.ConcurrentLinkedQueue;

public class a implements MStorageEx.IOnStorageChange {
    public static final String mjC = (com.tencent.mm.loader.j.b.aKA() + "files/wxofflinevoicenew/");
    public static boolean qwT = false;
    public static float qwU = 0.9f;
    public static float qwV = 10.0f;
    public static final String qwW = (mjC + "libreadMoney.so");
    public static final String qwX = (mjC + "woman_putonghua.pos");
    private static a qxd;
    private Object lock = new Object();
    public d qwY;
    public c qwZ;
    public b qxa;
    private String qxb;
    private int qxc = 0;
    public IListener<bp> qxe = new IListener<bp>() {
        /* class com.tencent.mm.plugin.collect.model.voice.a.AnonymousClass1 */

        {
            AppMethodBeat.i(160791);
            this.__eventId = bp.class.getName().hashCode();
            AppMethodBeat.o(160791);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(bp bpVar) {
            AppMethodBeat.i(63859);
            boolean a2 = a(bpVar);
            AppMethodBeat.o(63859);
            return a2;
        }

        private boolean a(bp bpVar) {
            AppMethodBeat.i(63858);
            Log.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "CheckResUpdateCacheFileEvent callback");
            if (bpVar.dEN.dEO == 60) {
                synchronized (a.this.lock) {
                    try {
                        Log.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "CheckResUpdateCacheFileEvent resTyep:%s subType:%s md5:%s fileVersion:%s", Integer.valueOf(bpVar.dEN.dEO), Integer.valueOf(bpVar.dEN.subType), bpVar.dEN.dER, Integer.valueOf(bpVar.dEN.dEP));
                        if (bpVar.dEN.subType != 1) {
                            if (bpVar.dEN.subType == 3) {
                                Log.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "CheckResUpdateCacheFileEvent subType == RES_SUB_TYPE_RES");
                                if (s.YS(a.qwX)) {
                                    Log.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", " file exists，first delete exist file");
                                    s.deleteFile(a.qwX);
                                }
                                s.nw(bpVar.dEN.filePath, a.qwX);
                                a.fD(AppEventsConstants.EVENT_PARAM_VALUE_NO, bpVar.dEN.dER);
                            }
                            if (a.qwT) {
                                Log.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "CheckResUpdateCacheFileEvent OFF_LINE == true, do not reInit Synthesizer");
                                AppMethodBeat.o(63858);
                            } else {
                                a.b(a.this);
                            }
                        }
                    } finally {
                        AppMethodBeat.o(63858);
                    }
                }
                return false;
            }
            AppMethodBeat.o(63858);
            return false;
        }
    };
    public IListener<qk> qxf = new IListener<qk>() {
        /* class com.tencent.mm.plugin.collect.model.voice.a.AnonymousClass2 */

        {
            AppMethodBeat.i(160792);
            this.__eventId = qk.class.getName().hashCode();
            AppMethodBeat.o(160792);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(qk qkVar) {
            AppMethodBeat.i(63861);
            boolean czO = czO();
            AppMethodBeat.o(63861);
            return czO;
        }

        private boolean czO() {
            AppMethodBeat.i(63860);
            Log.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "ReInitVoiceOffLineSynthesizerEvent");
            synchronized (a.this.lock) {
                try {
                    com.tencent.mm.plugin.collect.a.a.czp();
                    com.tencent.mm.plugin.collect.a.a.czr();
                    a.b(a.this);
                } finally {
                    AppMethodBeat.o(63860);
                }
            }
            return false;
        }
    };
    private boolean qxg = false;

    public interface c {
        void a(int i2, String str, String str2, String str3, int i3, String str4, byte[] bArr);
    }

    public a() {
        AppMethodBeat.i(63867);
        AppMethodBeat.o(63867);
    }

    static /* synthetic */ void b(a aVar) {
        AppMethodBeat.i(63883);
        aVar.czH();
        AppMethodBeat.o(63883);
    }

    static {
        AppMethodBeat.i(63884);
        AppMethodBeat.o(63884);
    }

    public static a czG() {
        AppMethodBeat.i(63868);
        synchronized (a.class) {
            try {
                if (qxd == null) {
                    qxd = new a();
                }
            } catch (Throwable th) {
                AppMethodBeat.o(63868);
                throw th;
            }
        }
        a aVar = qxd;
        AppMethodBeat.o(63868);
        return aVar;
    }

    @Override // com.tencent.mm.sdk.storage.MStorageEx.IOnStorageChange
    public void onNotifyChange(int i2, MStorageEx mStorageEx, Object obj) {
        AppMethodBeat.i(63869);
        if (this.qxg) {
            Log.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "onNotifyChange()：is already init()");
            AppMethodBeat.o(63869);
            return;
        }
        com.tencent.mm.plugin.collect.a.a.czp();
        com.tencent.mm.plugin.collect.a.a.czr();
        Log.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "onNotifyChange()");
        kN(true);
        this.qxg = true;
        g.aAh().azQ().remove(this);
        AppMethodBeat.o(63869);
    }

    public final void kN(boolean z) {
        AppMethodBeat.i(63870);
        Log.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", " begin initTTS()，delay：%s", Boolean.valueOf(z));
        if (z) {
            h.RTc.a(new Runnable() {
                /* class com.tencent.mm.plugin.collect.model.voice.a.AnonymousClass3 */

                public final void run() {
                    AppMethodBeat.i(63862);
                    a.this.init();
                    AppMethodBeat.o(63862);
                }
            }, 10000, "initTTS");
            AppMethodBeat.o(63870);
            return;
        }
        h.RTc.b(new Runnable() {
            /* class com.tencent.mm.plugin.collect.model.voice.a.AnonymousClass4 */

            public final void run() {
                AppMethodBeat.i(63863);
                a.this.init();
                AppMethodBeat.o(63863);
            }
        }, "initTTS");
        AppMethodBeat.o(63870);
    }

    public final void init() {
        AppMethodBeat.i(63871);
        synchronized (this.lock) {
            try {
                if (qwT) {
                    Log.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "initTTS() OFF_LINE == true");
                    return;
                }
                com.tencent.mm.plugin.collect.a.a.czp();
                com.tencent.mm.plugin.collect.a.a.czr();
                this.qxf.alive();
                if (!czI()) {
                    Log.e("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "initTTS() fail!! ");
                    qwT = false;
                } else {
                    Log.e("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "initTTS() success!! ");
                    qwT = true;
                }
                AppMethodBeat.o(63871);
            } finally {
                AppMethodBeat.o(63871);
            }
        }
    }

    private void czH() {
        AppMethodBeat.i(63872);
        if (czI()) {
            qwT = true;
            Log.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "reInitSynthesizer() success!!");
            AppMethodBeat.o(63872);
            return;
        }
        qwT = false;
        Log.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "reInitSynthesizer() fail!!");
        AppMethodBeat.o(63872);
    }

    /* JADX WARNING: Removed duplicated region for block: B:42:0x01e3  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x0276  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean czI() {
        /*
        // Method dump skipped, instructions count: 812
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.collect.model.voice.a.czI():boolean");
    }

    private static void czJ() {
        AppMethodBeat.i(63874);
        s.deleteFile(qwX);
        fD(AppEventsConstants.EVENT_PARAM_VALUE_NO, "");
        AppMethodBeat.o(63874);
    }

    private boolean czK() {
        AppMethodBeat.i(63875);
        if (s.YS(qwX)) {
            boolean czM = czM();
            AppMethodBeat.o(63875);
            return czM;
        } else if (czL()) {
            AppMethodBeat.o(63875);
            return true;
        } else {
            AppMethodBeat.o(63875);
            return false;
        }
    }

    private boolean czL() {
        AppMethodBeat.i(63876);
        com.tencent.mm.pluginsdk.j.a.a.b.gnC();
        String kC = com.tencent.mm.pluginsdk.j.a.a.b.kC(60, 3);
        boolean YS = s.YS(kC);
        Log.d("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "cacheFile:%s", kC);
        Log.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "checkDefaultResFromCache() %s no exist, cacheExist: %s", qwX, Boolean.valueOf(YS));
        if (YS) {
            long nw = s.nw(kC, qwX);
            fD(AppEventsConstants.EVENT_PARAM_VALUE_NO, "");
            Log.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "copyFile VOICE_DEFAULT_RES_PATH result == %s", Long.valueOf(nw));
            if (!Util.isEqual(nw, -1)) {
                com.tencent.mm.pluginsdk.j.a.a.b.gnC();
                String gnD = com.tencent.mm.pluginsdk.j.a.a.b.gnD();
                fD(AppEventsConstants.EVENT_PARAM_VALUE_NO, gnD);
                Log.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "checkDefaultResEnviroment() getOriginalMd5() resMd5:%s", gnD);
                boolean akN = akN(gnD);
                AppMethodBeat.o(63876);
                return akN;
            }
        }
        AppMethodBeat.o(63876);
        return false;
    }

    private boolean akN(String str) {
        AppMethodBeat.i(63877);
        Log.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "verifyDefaultRes() resMd5:%s", Util.nullAs(str, BuildConfig.COMMAND));
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(63877);
            return true;
        }
        Log.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "verifyDefaultRes() %s md5:%s", qwX, s.bhK(qwX));
        if (str.equalsIgnoreCase(s.bhK(qwX))) {
            AppMethodBeat.o(63877);
            return true;
        }
        com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(1143, 30, 1, false);
        czJ();
        Log.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "verifyDefaultRes autoDownloadDefaultResNum:%s", Integer.valueOf(this.qxc));
        if (this.qxc < 5) {
            this.qxc++;
            boolean czL = czL();
            AppMethodBeat.o(63877);
            return czL;
        }
        AppMethodBeat.o(63877);
        return false;
    }

    private boolean czM() {
        AppMethodBeat.i(63878);
        boolean akN = akN(aay(AppEventsConstants.EVENT_PARAM_VALUE_NO));
        AppMethodBeat.o(63878);
        return akN;
    }

    public final void a(ci ciVar) {
        AppMethodBeat.i(63879);
        C0929a aVar = new C0929a(ciVar);
        this.qxa.a(aVar);
        this.qwY.start(aVar.dFy);
        Log.d("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "produceVoice() %s", aVar.dFy);
        AppMethodBeat.o(63879);
    }

    public final String czN() {
        String str;
        AppMethodBeat.i(63880);
        if (Util.isEqual(this.qxb, "woman_putonghua")) {
            str = AppEventsConstants.EVENT_PARAM_VALUE_NO;
        } else {
            str = this.qxb;
        }
        AppMethodBeat.o(63880);
        return str;
    }

    public static String bIg() {
        AppMethodBeat.i(213155);
        String str = (String) g.aAh().azQ().get(ar.a.USERINFO_VOICE_OFFLINE_RES_ID_STRING_SYNC, AppEventsConstants.EVENT_PARAM_VALUE_NO);
        AppMethodBeat.o(213155);
        return str;
    }

    public static void aaw(String str) {
        AppMethodBeat.i(213156);
        g.aAh().azQ().set(ar.a.USERINFO_VOICE_OFFLINE_RES_ID_STRING_SYNC, str);
        EventCenter.instance.publish(new qk());
        AppMethodBeat.o(213156);
    }

    public static int l(final String str, final String str2, final String str3, final String str4) {
        AppMethodBeat.i(213157);
        CdnLogic.C2CDownloadRequest c2CDownloadRequest = new CdnLogic.C2CDownloadRequest();
        final String str5 = mjC + str4 + ".pos";
        c2CDownloadRequest.fileKey = str4;
        c2CDownloadRequest.url = str2;
        c2CDownloadRequest.setSavePath(str5);
        c2CDownloadRequest.fileType = 101;
        c2CDownloadRequest.taskStartTime = Util.nowMilliSecond();
        final long j2 = c2CDownloadRequest.taskStartTime;
        Log.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "voice resource download beginTime : %s", Long.valueOf(c2CDownloadRequest.taskStartTime));
        int startURLDownload = CdnLogic.startURLDownload(c2CDownloadRequest, new CdnLogic.DownloadCallback() {
            /* class com.tencent.mm.plugin.collect.model.voice.a.AnonymousClass5 */

            @Override // com.tencent.mars.cdn.CdnLogic.DownloadCallback
            public final void onDownloadProgressChanged(String str, long j2, long j3, boolean z) {
            }

            @Override // com.tencent.mars.cdn.CdnLogic.DownloadCallback
            public final void onC2CDownloadCompleted(String str, CdnLogic.C2CDownloadResult c2CDownloadResult) {
                AppMethodBeat.i(213153);
                Log.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "voice resource download end , cost：%s", Long.valueOf(Util.nowMilliSecond() - j2));
                if (!(c2CDownloadResult == null || c2CDownloadResult.cronetTaskResult == null || c2CDownloadResult.cronetTaskResult.performance == null)) {
                    Log.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "voice resource download end, url:%s, statusCode:%d, profile:%s", str2, Integer.valueOf(c2CDownloadResult.cronetTaskResult.statusCode), c2CDownloadResult.cronetTaskResult.performance);
                }
                Log.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "voice resource download result.errorCode ：%s， tempFilePath ：%s , md5：%s , file downaload md5:%s ", Integer.valueOf(c2CDownloadResult.errorCode), str5, str4, s.bhK(str5));
                if (c2CDownloadResult.errorCode != 0) {
                    Log.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "voice resource download failed:%s", Integer.valueOf(c2CDownloadResult.errorCode));
                    AppMethodBeat.o(213153);
                } else if (!s.YS(str5)) {
                    Log.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "  download File fail:%s", str5);
                    AppMethodBeat.o(213153);
                } else if (!str4.equalsIgnoreCase(s.bhK(str5))) {
                    Log.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "download md5 check failed，md5 :%s    ,  download md5:%s", str4, s.bhK(str5));
                    AppMethodBeat.o(213153);
                } else {
                    s.boN(a.mjC);
                    String str2 = a.mjC + str + ".pos";
                    if (s.YS(str2)) {
                        Log.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", " has this voice resource before ，first delete exist file");
                        s.deleteFile(str2);
                    }
                    s.nw(str5, str2);
                    s.deleteFile(str5);
                    Log.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "copyFile form %s  to   %s", str5, str2);
                    d.bIh().h(str, str2, str4, str3);
                    Log.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "save config  posID： %s，voicePath：%s ， md5 ：%s , version:%s", str, str2, str4, str3);
                    Log.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "currentResID %s、download ResID %s", a.bIg(), str);
                    if (a.bIg().equals(str)) {
                        Log.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "set currentResID  for new resource");
                        a.aaw(str);
                    }
                    AppMethodBeat.o(213153);
                }
            }
        });
        AppMethodBeat.o(213157);
        return startURLDownload;
    }

    public class b implements c {
        private c qxl;
        private ConcurrentLinkedQueue<C0929a> qxm = new ConcurrentLinkedQueue<>();

        public b(c cVar) {
            AppMethodBeat.i(63864);
            this.qxl = cVar;
            AppMethodBeat.o(63864);
        }

        public final void a(C0929a aVar) {
            AppMethodBeat.i(63865);
            this.qxm.add(aVar);
            AppMethodBeat.o(63865);
        }

        @Override // com.tencent.mm.plugin.collect.model.voice.c
        public final void o(int i2, byte[] bArr) {
            AppMethodBeat.i(63866);
            Object[] objArr = new Object[2];
            objArr[0] = Integer.valueOf(i2);
            objArr[1] = Boolean.valueOf(this.qxl == null);
            Log.i("MicroMsg.F2fRcvVoiceOffLineLogic.Listener", "onGetResult() errorCode:%s (voiceLlistener == null):%s", objArr);
            if (this.qxl != null) {
                C0929a poll = this.qxm.poll();
                this.qxl.a(i2, poll.dFw, poll.dFx, poll.dFy, poll.dFu, a.czG().czN(), bArr);
                if (i2 < 0) {
                    com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(1143, 20, 1, false);
                }
            }
            AppMethodBeat.o(63866);
        }
    }

    /* renamed from: com.tencent.mm.plugin.collect.model.voice.a$a  reason: collision with other inner class name */
    public class C0929a {
        public int dFu;
        public String dFv;
        public String dFw;
        public String dFx;
        public String dFy;
        public long gY;
        public int source;

        public C0929a(ci ciVar) {
            this.dFu = ciVar.dFt.dFu;
            this.dFv = ciVar.dFt.dFv;
            this.dFw = ciVar.dFt.dFw;
            this.dFx = ciVar.dFt.dFx;
            this.gY = ciVar.dFt.gY;
            this.source = ciVar.dFt.source;
            this.dFy = ciVar.dFt.dFy;
        }
    }

    private static String aay(String str) {
        AppMethodBeat.i(63881);
        String string = MultiProcessMMKV.getMMKV("voice_offline_res_new").getString(str + "_md5", "");
        AppMethodBeat.o(63881);
        return string;
    }

    public static void fD(String str, String str2) {
        AppMethodBeat.i(63882);
        MultiProcessMMKV.getMMKV("voice_offline_res_new").edit().putString(str + "_md5", Util.nullAs(str2, "")).commit();
        AppMethodBeat.o(63882);
    }

    public static String aaz(String str) {
        AppMethodBeat.i(213154);
        String string = MultiProcessMMKV.getMMKV("voice_offline_res_new").getString(str + "_version", "");
        AppMethodBeat.o(213154);
        return string;
    }
}

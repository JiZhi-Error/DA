package com.tencent.thumbplayer.g.a.a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.telephony.PhoneStateListener;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hardcoder.HardCoderJNI;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.tav.core.ExportErrorStatus;
import com.tencent.tav.coremedia.TimeUtil;
import com.tencent.thumbplayer.api.TPPlayerMgr;
import com.tencent.thumbplayer.api.report.ITPBusinessReportManager;
import com.tencent.thumbplayer.api.report.TPDefaultReportInfo;
import com.tencent.thumbplayer.api.report.TPVodReportInfo;
import com.tencent.thumbplayer.core.common.TPSystemInfo;
import com.tencent.thumbplayer.core.downloadproxy.api.TPDownloadProxyHelper;
import com.tencent.thumbplayer.g.a.a.d;
import com.tencent.thumbplayer.utils.e;
import com.tencent.thumbplayer.utils.g;
import com.tencent.thumbplayer.utils.h;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import org.json.JSONObject;

public class c implements ITPBusinessReportManager, com.tencent.thumbplayer.g.a.a {
    private static boolean SbQ = false;
    private static com.tencent.thumbplayer.utils.c SbU = null;
    private PhoneStateListener GUP = new PhoneStateListener() {
        /* class com.tencent.thumbplayer.g.a.a.c.AnonymousClass1 */

        public final void onSignalStrengthsChanged(SignalStrength signalStrength) {
            int i2;
            int i3 = 0;
            AppMethodBeat.i(189523);
            super.onSignalStrengthsChanged(signalStrength);
            if (c.this.mContext == null) {
                AppMethodBeat.o(189523);
                return;
            }
            TelephonyManager telephonyManager = (TelephonyManager) c.this.mContext.getSystemService("phone");
            if (telephonyManager == null) {
                g.e("TPReportManager", "getSystemService TELEPHONY_SERVICE err.");
                AppMethodBeat.o(189523);
                return;
            }
            try {
                String[] split = signalStrength.toString().split(" ");
                int networkType = telephonyManager.getNetworkType();
                if (networkType != 13 || split.length <= 9) {
                    if (networkType == 8 || networkType == 10 || networkType == 9 || networkType == 3) {
                        String networkOperator = telephonyManager.getNetworkOperator();
                        if (networkOperator != null && !networkOperator.startsWith("46000") && !networkOperator.startsWith("46002") && !networkOperator.startsWith("46007")) {
                            if (networkOperator.equals("46001")) {
                                i3 = signalStrength.getCdmaDbm();
                            } else if (networkOperator.equals("46003")) {
                                i2 = signalStrength.getEvdoDbm();
                                i3 = i2;
                            }
                        }
                        i2 = 0;
                        i3 = i2;
                    } else {
                        i3 = (signalStrength.getGsmSignalStrength() * 2) + ExportErrorStatus.APPEND_VIDEO_SAMPLE_SWAP_BUFFERS;
                    }
                } else if (com.tencent.thumbplayer.utils.b.isNumeric(split[9])) {
                    i3 = com.tencent.thumbplayer.utils.b.bqF(split[9]);
                }
                c.this.mHZ = i3;
                AppMethodBeat.o(189523);
            } catch (Throwable th) {
                g.e("TPReportManager", th);
                AppMethodBeat.o(189523);
            }
        }
    };
    private int RVX = 0;
    private boolean RXs = false;
    private HandlerThread SbR;
    private b SbS;
    private final Object SbT = new Object();
    private TPDefaultReportInfo SbV = null;
    private d SbW = null;
    private int SbX = 1;
    private int SbY = 0;
    private boolean SbZ = true;
    private boolean Sca = true;
    private long Scb = 0;
    private long Scc = 0;
    private int Scd = 0;
    private int Sce = 0;
    private int Scf = 0;
    private boolean Scg = false;
    private boolean Sch = false;
    private String Sci = AppEventsConstants.EVENT_PARAM_VALUE_NO;
    private String Scj = "";
    private String Sck = "";
    private int Scl = 0;
    private long Scm = 0;
    private AbstractC2207c Scn = new a();
    private d.a Sco = null;
    private d.l Scp = null;
    private final e Scq = new e(this, (byte) 0);
    private e.a Scr = new e.a() {
        /* class com.tencent.thumbplayer.g.a.a.c.AnonymousClass2 */

        @Override // com.tencent.thumbplayer.utils.e.a
        public final void d(int i2, int i3, int i4, Object obj) {
            int i5;
            AppMethodBeat.i(189524);
            g.i("TPReportManager", "OnGlobalEventChangeListener eventId: ".concat(String.valueOf(i2)));
            switch (i2) {
                case TPPlayerMgr.EVENT_ID_APP_ENTER_BACKGROUND:
                    i5 = 2100;
                    break;
                case TPPlayerMgr.EVENT_ID_APP_ENTER_FOREGROUND:
                    i5 = 2101;
                    break;
                default:
                    AppMethodBeat.o(189524);
                    return;
            }
            c.this.SbS.obtainMessage(i5, null).sendToTarget();
            AppMethodBeat.o(189524);
        }
    };
    private int cFx = -1;
    private Context mContext;
    private int mDownloadType = 0;
    private int mHZ = 0;
    private boolean mIsExit = false;

    /* access modifiers changed from: package-private */
    /* renamed from: com.tencent.thumbplayer.g.a.a.c$c  reason: collision with other inner class name */
    public interface AbstractC2207c {
        void a(int i2, a aVar);
    }

    static /* synthetic */ void a(c cVar, a aVar, boolean z) {
        AppMethodBeat.i(189582);
        cVar.a(aVar, z);
        AppMethodBeat.o(189582);
    }

    static /* synthetic */ void b(a aVar) {
        AppMethodBeat.i(189581);
        a(aVar);
        AppMethodBeat.o(189581);
    }

    static /* synthetic */ void b(c cVar) {
        AppMethodBeat.i(189575);
        cVar.hol();
        AppMethodBeat.o(189575);
    }

    static /* synthetic */ void b(c cVar, a aVar, boolean z) {
        AppMethodBeat.i(189583);
        cVar.b(aVar, z);
        AppMethodBeat.o(189583);
    }

    static /* synthetic */ void k(c cVar, Map map) {
        AppMethodBeat.i(189557);
        cVar.cp(map);
        AppMethodBeat.o(189557);
    }

    static /* synthetic */ void p(c cVar, Map map) {
        AppMethodBeat.i(189562);
        cVar.cq(map);
        AppMethodBeat.o(189562);
    }

    /* access modifiers changed from: package-private */
    public class e {
        int JON;
        boolean RWM;
        long ScA;
        int ScB;
        int ScC;
        int ScD;
        boolean ScE;
        boolean ScF;
        String ScG;
        String ScH;
        String ScI;
        long Sct;
        int Scu;
        long Scv;
        long Scw;
        int Scx;
        int Scy;
        long Scz;
        String cdnIp;
        String cdnUip;
        String pkK;

        private e() {
            this.Sct = 0;
            this.Scu = 0;
            this.Scv = 0;
            this.Scw = 0;
            this.Scx = 0;
            this.Scy = 0;
            this.Scz = 0;
            this.ScA = 0;
            this.ScB = 0;
            this.JON = 0;
            this.ScC = 0;
            this.ScD = 0;
            this.ScE = false;
            this.ScF = false;
            this.RWM = false;
            this.ScG = "";
            this.pkK = "";
            this.cdnIp = "";
            this.cdnUip = "";
            this.ScH = "";
            this.ScI = "";
        }

        /* synthetic */ e(c cVar, byte b2) {
            this();
        }
    }

    public c(Context context) {
        AppMethodBeat.i(189529);
        this.mContext = context.getApplicationContext();
        AppMethodBeat.o(189529);
    }

    private void cp(Map<String, Object> map) {
        AppMethodBeat.i(189530);
        g.i("TPReportManager", "onSeekComplete");
        this.Scg = false;
        if (map == null) {
            AppMethodBeat.o(189530);
        } else if (this.Scp == null) {
            AppMethodBeat.o(189530);
        } else {
            this.Scp.SeP = b(map, "etime", System.currentTimeMillis());
            this.Scp.SeN = b(map, "petime", 0) / 1000;
            this.Scp.Sdd = this.Sci;
            long j2 = this.Scp.SeP - this.Scp.SeO;
            if (j2 > 1200) {
                this.Scf++;
                this.Sce = (int) (j2 + ((long) this.Sce));
            }
            d.m mVar = this.SbW.ScR;
            mVar.SeQ++;
            mVar.SeS = this.Sce;
            mVar.SeR = this.Scf;
            if (mVar.SeT.size() < 20) {
                mVar.SeT.add(this.Scp);
                h hVar = new h();
                d.l lVar = this.Scp;
                hVar.put("format", lVar.ScY);
                hVar.put("pstime", lVar.SeM);
                hVar.put("petime", lVar.SeN);
                hVar.put("lstime", lVar.SeO);
                hVar.put("letime", lVar.SeP);
                hVar.put(TMQQDownloaderOpenSDKConst.UINTYPE_CODE, lVar.Sdd);
                this.Scn.a(40, hVar);
            }
            this.Scp = null;
            AppMethodBeat.o(189530);
        }
    }

    private void cq(Map<String, Object> map) {
        AppMethodBeat.i(189531);
        g.i("TPReportManager", "onBufferingEnd");
        this.RXs = false;
        if (!this.Scq.RWM) {
            this.Scq.Sct = System.currentTimeMillis();
        }
        if (map == null) {
            AppMethodBeat.o(189531);
            return;
        }
        long b2 = b(map, "etime", System.currentTimeMillis());
        int i2 = (int) (b2 - this.Scq.Scz);
        if (i2 <= 1200) {
            AppMethodBeat.o(189531);
        } else if (this.Scg) {
            AppMethodBeat.o(189531);
        } else {
            this.Scq.Scx++;
            this.Scq.ScA = b2;
            this.Scq.Scy += (int) (this.Scq.ScA - this.Scq.Scz);
            if (this.Sco == null) {
                AppMethodBeat.o(189531);
                return;
            }
            this.Sco.Sdb = b(map, "etime", 0);
            this.Sco.Sdd = this.Sci;
            d.b bVar = this.SbW.ScQ;
            bVar.Sdf++;
            bVar.Sdg += i2;
            if (bVar.Sdh.size() < 20) {
                bVar.Sdh.add(this.Sco);
                h hVar = new h();
                d.a aVar = this.Sco;
                hVar.put("scene", aVar.ScV);
                hVar.put("levent", aVar.ScW);
                hVar.put("reason", aVar.ScX);
                hVar.put("format", aVar.ScY);
                hVar.put("ptime", aVar.ScZ);
                hVar.put("stime", aVar.Sda);
                hVar.put("etime", aVar.Sdb);
                hVar.put("url", aVar.Sdc);
                hVar.put(TMQQDownloaderOpenSDKConst.UINTYPE_CODE, aVar.Sdd);
                this.Scn.a(35, hVar);
            }
            this.Sco = null;
            AppMethodBeat.o(189531);
        }
    }

    private void cr(Map<String, Object> map) {
        AppMethodBeat.i(189532);
        g.i("TPReportManager", "onPlayEnd");
        if (map == null || this.SbZ) {
            AppMethodBeat.o(189532);
            return;
        }
        if (this.RXs) {
            cq(new com.tencent.thumbplayer.utils.f().S("etime", Long.valueOf(System.currentTimeMillis())).map);
        }
        if (this.Scg) {
            cp(new com.tencent.thumbplayer.utils.f().S("etime", Long.valueOf(System.currentTimeMillis())).map);
        }
        if (this.Scq.Sct > 0) {
            this.Scq.Scu += (int) (System.currentTimeMillis() - this.Scq.Sct);
            this.Scq.Sct = 0;
        }
        this.Scg = false;
        h hVar = new h();
        this.SbW.ScQ.c(hVar);
        this.SbW.ScQ.reset();
        this.SbW.ScR.c(hVar);
        this.SbW.ScR.reset();
        d.i iVar = this.SbW.ScS;
        iVar.Sdb = b(map, "etime", System.currentTimeMillis());
        iVar.ScX = T(map, "reason");
        iVar.Sdd = this.Sci;
        if (this.Scb > 0) {
            this.Scc += iVar.Sdb - this.Scb;
            this.Scb = 0;
        }
        iVar.SeH = ((float) this.Scc) / 1000.0f;
        iVar.c(hVar);
        this.Scn.a(50, hVar);
        this.SbZ = true;
        this.Sci = AppEventsConstants.EVENT_PARAM_VALUE_NO;
        this.Scb = 0;
        this.Scc = 0;
        this.Scf = 0;
        this.Sce = 0;
        e eVar = this.Scq;
        eVar.Sct = 0;
        eVar.Scu = 0;
        eVar.Scv = 0;
        eVar.Scw = 0;
        eVar.Scx = 0;
        eVar.Scy = 0;
        eVar.Scz = 0;
        eVar.ScA = 0;
        eVar.ScB = 0;
        eVar.JON = 0;
        eVar.ScC = 0;
        eVar.ScD = 0;
        eVar.ScE = false;
        eVar.ScF = false;
        eVar.RWM = false;
        eVar.ScG = "";
        eVar.pkK = "";
        eVar.cdnIp = "";
        eVar.cdnUip = "";
        eVar.ScH = "";
        eVar.ScI = "";
        hom();
        AppMethodBeat.o(189532);
    }

    private static void a(a aVar) {
        AppMethodBeat.i(189533);
        g.i("TPReportManager", "onReportEvent: " + aVar.toString());
        AppMethodBeat.o(189533);
    }

    private void hol() {
        AppMethodBeat.i(189534);
        g.i("TPReportManager", "onLivePeriodReport");
        this.Scn.a(263, new h());
        AppMethodBeat.o(189534);
    }

    private void hom() {
        AppMethodBeat.i(189535);
        g.i("TPReportManager", "removeCacheEvent: mFlowId: " + this.Scj);
        if (SbU != null && !TextUtils.isEmpty(this.Scj)) {
            SbU.bqG(this.Scj);
        }
        AppMethodBeat.o(189535);
    }

    private void a(a aVar, boolean z) {
        int i2;
        int i3 = 1;
        AppMethodBeat.i(189536);
        d.n nVar = this.SbW.ScU;
        if (nVar == null) {
            AppMethodBeat.o(189536);
            return;
        }
        if (this.SbV != null && (this.SbV instanceof TPVodReportInfo) && z) {
            nVar.SeU = ((TPVodReportInfo) this.SbV).currentPlayState;
            nVar.SeV = ((TPVodReportInfo) this.SbV).optimizedPlay;
            nVar.SeW = ((TPVodReportInfo) this.SbV).hasSubtitles ? 1 : 0;
            nVar.SeZ = ((TPVodReportInfo) this.SbV).bizId;
            nVar.Sfb = ((TPVodReportInfo) this.SbV).clipCount;
            nVar.Sfc = ((TPVodReportInfo) this.SbV).videoStatus;
            nVar.Sed = this.SbV.freeType;
        }
        if (this.Scq.ScF) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        nVar.SeY = i2;
        if (!this.Scq.ScE) {
            i3 = 0;
        }
        nVar.SeX = i3;
        nVar.Sfa = 0;
        aVar.put("freetype", nVar.Sed);
        aVar.put("currentplay", nVar.SeU);
        aVar.put("optimizedplay", nVar.SeV);
        aVar.put("subtitles", nVar.SeW);
        aVar.put("selsubtitles", nVar.SeX);
        aVar.put("multitrack", nVar.SeY);
        aVar.put("bizid", nVar.SeZ);
        aVar.put("hevclv", nVar.Sfa);
        aVar.put("clip", nVar.Sfb);
        aVar.put("status", nVar.Sfc);
        AppMethodBeat.o(189536);
    }

    /* JADX WARNING: Removed duplicated region for block: B:45:0x0136  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void b(com.tencent.thumbplayer.g.a.a.a r9, boolean r10) {
        /*
        // Method dump skipped, instructions count: 779
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.thumbplayer.g.a.a.c.b(com.tencent.thumbplayer.g.a.a.a, boolean):void");
    }

    @Override // com.tencent.thumbplayer.api.report.ITPBusinessReportManager
    public void setReportInfoGetter(TPDefaultReportInfo tPDefaultReportInfo) {
        this.SbV = tPDefaultReportInfo;
    }

    @Override // com.tencent.thumbplayer.api.report.ITPBusinessReportManager
    public void reportEvent(int i2, Map<String, Object> map) {
        int i3;
        AppMethodBeat.i(189538);
        if (map == null) {
            map = new HashMap<>();
        }
        switch (i2) {
            case 1000:
                i3 = 2000;
                break;
            case 1001:
                i3 = 2001;
                break;
            case 1100:
                i3 = 2003;
                break;
            default:
                AppMethodBeat.o(189538);
                return;
        }
        this.SbS.obtainMessage(i3, map).sendToTarget();
        AppMethodBeat.o(189538);
    }

    @Override // com.tencent.thumbplayer.g.a.a
    public final void b(int i2, int i3, int i4, String str, Object obj) {
        int i5;
        AppMethodBeat.i(189541);
        switch (i2) {
            case 100:
                i5 = 999;
                break;
            case 101:
                i5 = 1000;
                break;
            case 102:
                i5 = 1001;
                break;
            case 103:
                i5 = 1002;
                break;
            case 104:
                i5 = 1003;
                break;
            case 105:
                i5 = 1012;
                break;
            case 106:
                i5 = 1004;
                break;
            case 107:
                i5 = 1005;
                break;
            case 108:
                i5 = 1006;
                break;
            case 109:
                i5 = 1007;
                break;
            case 110:
                i5 = 1008;
                break;
            case 111:
                i5 = 1009;
                break;
            case 112:
                i5 = 1010;
                break;
            case 113:
                i5 = 1011;
                break;
            case 114:
                i5 = 1013;
                break;
            case 115:
                i5 = 1014;
                break;
            case 116:
                i5 = HardCoderJNI.FUNC_REG_SYSTEM_EVENT_CALLBACK;
                break;
            case 117:
                i5 = HardCoderJNI.FUNC_GPU_HIGH_FREQ;
                break;
            case 118:
                i5 = 2002;
                break;
            case 119:
                i5 = 1019;
                break;
            case 120:
                i5 = 1020;
                break;
            case 121:
                i5 = 1021;
                break;
            case 124:
                i5 = 1022;
                break;
            case 200:
                i5 = HardCoderJNI.FUNC_CANCEL_GPU_HIGH_FREQ;
                break;
            case 201:
                i5 = 1018;
                break;
            default:
                AppMethodBeat.o(189541);
                return;
        }
        this.SbS.obtainMessage(i5, obj).sendToTarget();
        AppMethodBeat.o(189541);
    }

    /* access modifiers changed from: package-private */
    public class b extends Handler {
        b(Looper looper) {
            super(looper);
        }

        public final void handleMessage(Message message) {
            AppMethodBeat.i(189526);
            Map map = null;
            if (message.obj instanceof Map) {
                map = (Map) message.obj;
            }
            switch (message.what) {
                case 100:
                    c.a(c.this);
                    AppMethodBeat.o(189526);
                    return;
                case 999:
                    c.a(c.this, map);
                    AppMethodBeat.o(189526);
                    return;
                case 1000:
                    c.b(c.this, map);
                    AppMethodBeat.o(189526);
                    return;
                case 1001:
                    c.c(c.this, map);
                    AppMethodBeat.o(189526);
                    return;
                case 1002:
                    c.d(c.this, map);
                    AppMethodBeat.o(189526);
                    return;
                case 1003:
                    c.e(c.this, map);
                    AppMethodBeat.o(189526);
                    return;
                case 1004:
                    c.g(c.this, map);
                    AppMethodBeat.o(189526);
                    return;
                case 1005:
                    c.h(c.this, map);
                    AppMethodBeat.o(189526);
                    return;
                case 1006:
                    c.i(c.this, map);
                    AppMethodBeat.o(189526);
                    return;
                case 1007:
                    c.j(c.this, map);
                    AppMethodBeat.o(189526);
                    return;
                case 1008:
                    c.k(c.this, map);
                    AppMethodBeat.o(189526);
                    return;
                case 1009:
                    c.l(c.this, map);
                    AppMethodBeat.o(189526);
                    return;
                case 1010:
                    c.m(c.this, map);
                    AppMethodBeat.o(189526);
                    return;
                case 1011:
                    c.n(c.this, map);
                    AppMethodBeat.o(189526);
                    return;
                case 1012:
                    c.f(c.this, map);
                    AppMethodBeat.o(189526);
                    return;
                case 1013:
                    c.o(c.this, map);
                    AppMethodBeat.o(189526);
                    return;
                case 1014:
                    c.p(c.this, map);
                    AppMethodBeat.o(189526);
                    return;
                case HardCoderJNI.FUNC_REG_SYSTEM_EVENT_CALLBACK:
                    c.q(c.this, map);
                    AppMethodBeat.o(189526);
                    return;
                case HardCoderJNI.FUNC_GPU_HIGH_FREQ:
                    if (message.obj instanceof String) {
                        c.a(c.this, (String) message.obj);
                        AppMethodBeat.o(189526);
                        return;
                    }
                    break;
                case HardCoderJNI.FUNC_CANCEL_GPU_HIGH_FREQ:
                    c.r(c.this, map);
                    AppMethodBeat.o(189526);
                    return;
                case 1018:
                    c.s(c.this, map);
                    AppMethodBeat.o(189526);
                    return;
                case 1019:
                    c.x(c.this, map);
                    AppMethodBeat.o(189526);
                    return;
                case 1020:
                    c.z(c.this, map);
                    AppMethodBeat.o(189526);
                    return;
                case 1021:
                    c.A(c.this, map);
                    AppMethodBeat.o(189526);
                    return;
                case 1022:
                    c.y(c.this, map);
                    AppMethodBeat.o(189526);
                    return;
                case 2000:
                    c.t(c.this, map);
                    AppMethodBeat.o(189526);
                    return;
                case 2001:
                    c.u(c.this, map);
                    AppMethodBeat.o(189526);
                    return;
                case 2002:
                    c.v(c.this, map);
                    AppMethodBeat.o(189526);
                    return;
                case 2003:
                    c.w(c.this, map);
                    AppMethodBeat.o(189526);
                    return;
                case 2100:
                    c.c(c.this);
                    AppMethodBeat.o(189526);
                    return;
                case 2101:
                    c.d(c.this);
                    AppMethodBeat.o(189526);
                    return;
                case 3000:
                    c.b(c.this);
                    AppMethodBeat.o(189526);
                    return;
                case 4000:
                    c.hon();
                    break;
            }
            AppMethodBeat.o(189526);
        }
    }

    private static int T(Map<String, Object> map, String str) {
        AppMethodBeat.i(189542);
        if (map == null) {
            AppMethodBeat.o(189542);
            return 0;
        }
        Object obj = map.get(str);
        if (obj != null) {
            int intValue = ((Integer) obj).intValue();
            AppMethodBeat.o(189542);
            return intValue;
        }
        AppMethodBeat.o(189542);
        return 0;
    }

    private static long b(Map<String, Object> map, String str, long j2) {
        AppMethodBeat.i(189543);
        if (map == null) {
            AppMethodBeat.o(189543);
            return j2;
        }
        Object obj = map.get(str);
        if (obj != null) {
            long longValue = ((Long) obj).longValue();
            AppMethodBeat.o(189543);
            return longValue;
        }
        AppMethodBeat.o(189543);
        return j2;
    }

    private static String f(Map<String, Object> map, String str, String str2) {
        AppMethodBeat.i(189544);
        if (map == null) {
            AppMethodBeat.o(189544);
            return str2;
        }
        Object obj = map.get(str);
        if (obj != null) {
            String str3 = (String) obj;
            AppMethodBeat.o(189544);
            return str3;
        }
        AppMethodBeat.o(189544);
        return str2;
    }

    private static boolean U(Map<String, Object> map, String str) {
        AppMethodBeat.i(189545);
        if (map == null) {
            AppMethodBeat.o(189545);
            return false;
        }
        Object obj = map.get(str);
        if (obj != null) {
            boolean booleanValue = ((Boolean) obj).booleanValue();
            AppMethodBeat.o(189545);
            return booleanValue;
        }
        AppMethodBeat.o(189545);
        return false;
    }

    @SuppressLint({"MissingPermission"})
    private int bAX() {
        NetworkInfo activeNetworkInfo;
        int i2;
        int i3 = 0;
        AppMethodBeat.i(189546);
        if (this.mContext == null) {
            AppMethodBeat.o(189546);
        } else {
            try {
                ConnectivityManager connectivityManager = (ConnectivityManager) this.mContext.getSystemService("connectivity");
                if (!(connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null || !activeNetworkInfo.isConnected())) {
                    switch (activeNetworkInfo.getType()) {
                        case 0:
                            switch (activeNetworkInfo.getSubtype()) {
                                case 1:
                                case 2:
                                case 4:
                                case 7:
                                case 11:
                                    i2 = 2;
                                    break;
                                case 3:
                                case 5:
                                case 6:
                                case 8:
                                case 9:
                                case 10:
                                case 12:
                                case 14:
                                case 15:
                                    i2 = 3;
                                    break;
                                case 13:
                                    i2 = 4;
                                    break;
                                default:
                                    i2 = 0;
                                    break;
                            }
                            i3 = i2;
                            break;
                        case 1:
                            i3 = 1;
                            break;
                        case 9:
                            i3 = 10;
                            break;
                    }
                }
            } catch (Exception e2) {
                g.e("TPReportManager", e2);
            }
            AppMethodBeat.o(189546);
        }
        return i3;
    }

    class a implements AbstractC2207c {
        a() {
        }

        @Override // com.tencent.thumbplayer.g.a.a.c.AbstractC2207c
        public final void a(int i2, a aVar) {
            AppMethodBeat.i(189525);
            boolean z = true;
            if (i2 > 30) {
                z = false;
            }
            c.a(c.this, aVar, i2, z);
            c.b(aVar);
            AppMethodBeat.o(189525);
        }
    }

    /* access modifiers changed from: package-private */
    public class f implements AbstractC2207c {
        f() {
        }

        @Override // com.tencent.thumbplayer.g.a.a.c.AbstractC2207c
        public final void a(int i2, a aVar) {
            AppMethodBeat.i(189528);
            boolean z = true;
            if (i2 > 30) {
                z = false;
            }
            c.a(c.this, aVar, i2, z);
            c.a(c.this, aVar, z);
            c.b(aVar);
            AppMethodBeat.o(189528);
        }
    }

    /* access modifiers changed from: package-private */
    public class d implements AbstractC2207c {
        d() {
        }

        @Override // com.tencent.thumbplayer.g.a.a.c.AbstractC2207c
        public final void a(int i2, a aVar) {
            AppMethodBeat.i(189527);
            h hVar = new h();
            boolean z = true;
            if (i2 > 30 && i2 != 263) {
                z = false;
            }
            switch (i2) {
                case 30:
                    i2 = 205;
                    break;
                case 50:
                    c.this.SbS.removeMessages(3000);
                    i2 = 263;
                    break;
                case 150:
                    c.this.SbS.removeMessages(3000);
                    break;
                case 263:
                    c.this.SbS.removeMessages(3000);
                    c.this.SbS.sendEmptyMessageDelayed(3000, Util.MILLSECONDS_OF_MINUTE);
                    break;
                default:
                    AppMethodBeat.o(189527);
                    return;
            }
            c.a(c.this, hVar, i2, z);
            c.b(c.this, hVar, z);
            if (i2 != 205) {
                hVar.put("loadingtime", 0);
            }
            g.i("TPReportManager", "liveExParam.prePlayLengthInt: " + c.this.SbW.ScT.SdZ);
            c.b(hVar);
            AppMethodBeat.o(189527);
        }
    }

    @Override // com.tencent.thumbplayer.g.a.a
    public final void aSs() {
        AppMethodBeat.i(189539);
        this.SbR = new HandlerThread("TP-ReportThread");
        this.SbR.start();
        this.SbS = new b(this.SbR.getLooper());
        this.SbW = new d();
        if (this.mContext != null) {
            TelephonyManager telephonyManager = (TelephonyManager) this.mContext.getSystemService("phone");
            if (telephonyManager == null) {
                g.e("TPReportManager", "getSystemService TELEPHONY_SERVICE err.");
            } else {
                com.tencent.mm.hellhoundlib.b.a bl = com.tencent.mm.hellhoundlib.b.c.a(256, new com.tencent.mm.hellhoundlib.b.a()).bl(this.GUP);
                com.tencent.mm.hellhoundlib.a.a.a(telephonyManager, bl.axQ(), "com/tencent/thumbplayer/tplayer/plugins/report/TPReportManager", "signalStrengthRegister", "()V", "android/telephony/TelephonyManager_EXEC_", "listen", "(Landroid/telephony/PhoneStateListener;I)V");
                telephonyManager.listen((PhoneStateListener) bl.pG(0), ((Integer) bl.pG(1)).intValue());
                com.tencent.mm.hellhoundlib.a.a.a(telephonyManager, "com/tencent/thumbplayer/tplayer/plugins/report/TPReportManager", "signalStrengthRegister", "()V", "android/telephony/TelephonyManager_EXEC_", "listen", "(Landroid/telephony/PhoneStateListener;I)V");
            }
        }
        com.tencent.thumbplayer.utils.e.a(this.Scr);
        synchronized (c.class) {
            try {
                if (SbU == null) {
                    SbU = new com.tencent.thumbplayer.utils.c(this.mContext, "TPReportCache");
                }
                if (!SbQ) {
                    this.SbS.obtainMessage(4000).sendToTarget();
                }
                SbQ = true;
            } finally {
                AppMethodBeat.o(189539);
            }
        }
    }

    @Override // com.tencent.thumbplayer.g.a.a
    public final void onDetach() {
        AppMethodBeat.i(189540);
        g.i("TPReportManager", "release: ");
        if (this.mContext != null) {
            TelephonyManager telephonyManager = (TelephonyManager) this.mContext.getSystemService("phone");
            if (telephonyManager == null) {
                g.e("TPReportManager", "getSystemService TELEPHONY_SERVICE err.");
            } else {
                com.tencent.mm.hellhoundlib.b.a bl = com.tencent.mm.hellhoundlib.b.c.a(0, new com.tencent.mm.hellhoundlib.b.a()).bl(this.GUP);
                com.tencent.mm.hellhoundlib.a.a.a(telephonyManager, bl.axQ(), "com/tencent/thumbplayer/tplayer/plugins/report/TPReportManager", "signalStrengthUnRegister", "()V", "android/telephony/TelephonyManager_EXEC_", "listen", "(Landroid/telephony/PhoneStateListener;I)V");
                telephonyManager.listen((PhoneStateListener) bl.pG(0), ((Integer) bl.pG(1)).intValue());
                com.tencent.mm.hellhoundlib.a.a.a(telephonyManager, "com/tencent/thumbplayer/tplayer/plugins/report/TPReportManager", "signalStrengthUnRegister", "()V", "android/telephony/TelephonyManager_EXEC_", "listen", "(Landroid/telephony/PhoneStateListener;I)V");
            }
        }
        com.tencent.thumbplayer.utils.e.b(this.Scr);
        if (this.SbR != null) {
            if (Build.VERSION.SDK_INT >= 18) {
                this.SbR.quitSafely();
            } else {
                synchronized (this.SbT) {
                    try {
                        this.mIsExit = false;
                        this.SbS.sendEmptyMessage(100);
                        while (!this.mIsExit) {
                            try {
                                this.SbT.wait(5000, 0);
                            } catch (InterruptedException e2) {
                                g.e("TPReportManager", e2);
                            }
                        }
                    } catch (Throwable th) {
                        AppMethodBeat.o(189540);
                        throw th;
                    }
                }
                this.SbR.quit();
            }
            this.SbR = null;
        }
        g.i("TPReportManager", "release: end!");
        AppMethodBeat.o(189540);
    }

    static /* synthetic */ void a(c cVar, Map map) {
        AppMethodBeat.i(189547);
        g.i("TPReportManager", "onPlayerCreateStart");
        if (map != null) {
            cVar.SbW.ScK.SeI = b(map, "stime", System.currentTimeMillis());
        }
        AppMethodBeat.o(189547);
    }

    static /* synthetic */ void b(c cVar, Map map) {
        AppMethodBeat.i(189548);
        g.i("TPReportManager", "onPlayerCreateDone");
        if (map != null) {
            h hVar = new h();
            d.j jVar = cVar.SbW.ScK;
            jVar.SeJ = b(map, "etime", System.currentTimeMillis());
            jVar.Sdd = cVar.Sci;
            jVar.c(hVar);
        }
        AppMethodBeat.o(189548);
    }

    static /* synthetic */ void c(c cVar, Map map) {
        AppMethodBeat.i(189549);
        g.i("TPReportManager", "onStartPrepare");
        cVar.Scj = f(map, "flowid", "");
        cVar.Sch = U(map, "p2p");
        if (cVar.SbV != null) {
            cVar.cFx = cVar.SbV.getPlayType();
        }
        if (cVar.cFx == 1) {
            cVar.Scn = new d();
        } else if (cVar.cFx == 0) {
            cVar.Scn = new f();
        }
        h hVar = new h();
        cVar.SbW.ScK.c(hVar);
        cVar.Scn.a(5, hVar);
        cVar.Scq.Scv = System.currentTimeMillis();
        d.C2208d dVar = cVar.SbW.ScM;
        dVar.SdT = cVar.Scq.pkK;
        if (TextUtils.isEmpty(dVar.SdT)) {
            dVar.SdT = f(map, "url", "");
        }
        if (cVar.SbV != null) {
            dVar.SdU = cVar.SbV.cdnUrlIndex;
        }
        dVar.SdU = T(map, "urlindex");
        dVar.Sda = b(map, "stime", 0);
        AppMethodBeat.o(189549);
    }

    static /* synthetic */ void d(c cVar, Map map) {
        AppMethodBeat.i(189550);
        g.i("TPReportManager", "onPrepareDone");
        if (map != null) {
            cVar.Scq.Scw = System.currentTimeMillis();
            cVar.Scq.ScF = U(map, "multitrack");
            h hVar = new h();
            if (T(map, "playertype") == 1) {
                cVar.RVX = 0;
            } else {
                cVar.RVX = 1;
            }
            cVar.Sck = f(map, "definition", "");
            cVar.Scm = b(map, FFmpegMetadataRetriever.METADATA_KEY_DURATION, 0);
            cVar.Scl = (int) b(map, "rate", 0);
            String f2 = f(map, "fmt", "");
            if (f2 == null || !f2.contains("hls")) {
                cVar.mDownloadType = 1;
            } else {
                cVar.mDownloadType = 3;
            }
            d.C2208d dVar = cVar.SbW.ScM;
            dVar.Sdb = b(map, "etime", 0);
            dVar.Sdd = cVar.Sci;
            hVar.put("stime", dVar.Sda);
            hVar.put("etime", dVar.Sdb);
            hVar.put("fileopenedtime", dVar.SdR);
            hVar.put("firstpacketreadtime", dVar.SdS);
            hVar.put("url", dVar.SdT);
            hVar.put("urlindex", dVar.SdU);
            hVar.put(TMQQDownloaderOpenSDKConst.UINTYPE_CODE, dVar.Sdd);
            cVar.Scn.a(30, hVar);
            cVar.SbZ = false;
        }
        AppMethodBeat.o(189550);
    }

    static /* synthetic */ void e(c cVar, Map map) {
        AppMethodBeat.i(189551);
        g.i("TPReportManager", "onStartPlayer");
        cVar.SbZ = false;
        if (map != null) {
            cVar.Scq.Sct = System.currentTimeMillis();
            d.e eVar = cVar.SbW.ScN;
            eVar.Sda = b(map, "stime", 0);
            if (cVar.Scb > 0) {
                cVar.Scc += System.currentTimeMillis() - eVar.Sda;
            }
            cVar.Scb = eVar.Sda;
            if (cVar.cFx == 1) {
                cVar.SbS.removeMessages(3000);
                cVar.SbS.sendEmptyMessageDelayed(3000, Util.MILLSECONDS_OF_MINUTE);
            }
        }
        AppMethodBeat.o(189551);
    }

    static /* synthetic */ void f(c cVar, Map map) {
        AppMethodBeat.i(189552);
        g.i("TPReportManager", "onRenderingStart");
        if (map != null) {
            h hVar = new h();
            d.e eVar = cVar.SbW.ScN;
            eVar.Sdb = b(map, "etime", 0);
            eVar.Sdd = cVar.Sci;
            hVar.put("stime", eVar.Sda);
            hVar.put("etime", eVar.Sdb);
            hVar.put(TMQQDownloaderOpenSDKConst.UINTYPE_CODE, eVar.Sdd);
            cVar.Scn.a(32, hVar);
        }
        AppMethodBeat.o(189552);
    }

    static /* synthetic */ void g(c cVar, Map map) {
        AppMethodBeat.i(189553);
        g.i("TPReportManager", "onPlayerPause");
        if (map != null) {
            if (cVar.Scb > 0) {
                cVar.Scc = (b(map, "stime", System.currentTimeMillis()) - cVar.Scb) + cVar.Scc;
                cVar.Scb = 0;
            }
            if (cVar.Scq.Sct > 0) {
                cVar.Scq.Scu += (int) (System.currentTimeMillis() - cVar.Scq.Sct);
                cVar.Scq.Sct = 0;
            }
        }
        AppMethodBeat.o(189553);
    }

    static /* synthetic */ void h(c cVar, Map map) {
        AppMethodBeat.i(189554);
        g.i("TPReportManager", "onPlayerStop");
        if (map != null) {
            if (cVar.Scb > 0) {
                cVar.Scc = (b(map, "etime", System.currentTimeMillis()) - cVar.Scb) + cVar.Scc;
                cVar.Scb = 0;
            }
            if (cVar.Scq.Sct > 0) {
                cVar.Scq.Scu += (int) (System.currentTimeMillis() - cVar.Scq.Sct);
                cVar.Scq.Sct = 0;
            }
            map.put("reason", 1);
            cVar.cr(map);
        }
        AppMethodBeat.o(189554);
    }

    static /* synthetic */ void i(c cVar, Map map) {
        AppMethodBeat.i(189555);
        g.i("TPReportManager", "onPlayerError");
        if (map != null) {
            if (cVar.Scq.Sct > 0) {
                cVar.Scq.Scu += (int) (System.currentTimeMillis() - cVar.Scq.Sct);
                cVar.Scq.Sct = 0;
            }
            cVar.Sci = f(map, TMQQDownloaderOpenSDKConst.UINTYPE_CODE, AppEventsConstants.EVENT_PARAM_VALUE_NO);
            if (cVar.cFx == 1) {
                cVar.Scn.a(150, new h());
                AppMethodBeat.o(189555);
                return;
            }
            map.put("reason", 3);
            cVar.cr(map);
        }
        AppMethodBeat.o(189555);
    }

    static /* synthetic */ void j(c cVar, Map map) {
        AppMethodBeat.i(189556);
        g.i("TPReportManager", "onStartSeek");
        if (map != null) {
            if (cVar.RXs) {
                cVar.cq(new com.tencent.thumbplayer.utils.f().S("etime", Long.valueOf(System.currentTimeMillis())).map);
            }
            if (cVar.Scg) {
                cVar.cp(new com.tencent.thumbplayer.utils.f().S("etime", Long.valueOf(System.currentTimeMillis())).S("petime", Long.valueOf(b(map, "pstime", 0) / 1000)).map);
            }
            cVar.Scg = true;
            cVar.SbY = 1;
            cVar.Scp = new d.l();
            cVar.Scp.SeO = b(map, "stime", System.currentTimeMillis());
            d.c cVar2 = cVar.SbW.ScJ;
            cVar.Scp.ScY = cVar2.SdO;
            cVar.Scp.SeM = b(map, "pstime", 0) / 1000;
        }
        AppMethodBeat.o(189556);
    }

    static /* synthetic */ void l(c cVar, Map map) {
        AppMethodBeat.i(189558);
        g.i("TPReportManager", "onPlayComplete");
        if (map != null) {
            map.put("reason", 0);
            cVar.cr(map);
        }
        AppMethodBeat.o(189558);
    }

    static /* synthetic */ void m(c cVar, Map map) {
        AppMethodBeat.i(189559);
        g.i("TPReportManager", "onPlayerRelease");
        if (map != null) {
            map.put("reason", 1);
            cVar.cr(map);
        }
        AppMethodBeat.o(189559);
    }

    static /* synthetic */ void n(c cVar, Map map) {
        AppMethodBeat.i(189560);
        g.i("TPReportManager", "onPlayerReset");
        if (map != null) {
            map.put("reason", 1);
            cVar.cr(map);
        }
        AppMethodBeat.o(189560);
    }

    static /* synthetic */ void o(c cVar, Map map) {
        AppMethodBeat.i(189561);
        g.i("TPReportManager", "onBufferingStart");
        if (map != null) {
            cVar.RXs = true;
            if (!cVar.Scg) {
                if (cVar.Scq.Sct > 0) {
                    cVar.Scq.Scu += (int) (System.currentTimeMillis() - cVar.Scq.Sct);
                    cVar.Scq.Sct = 0;
                }
                cVar.Scq.Scz = b(map, "stime", System.currentTimeMillis());
                cVar.Sco = new d.a();
                cVar.Sco.Sda = cVar.Scq.Scz;
                cVar.Sco.ScY = T(map, "format");
                cVar.Sco.ScY = cVar.SbW.ScJ.SdO;
                cVar.Sco.ScX = T(map, "reason");
                cVar.Sco.ScW = cVar.SbY;
                cVar.Sco.ScV = cVar.SbX;
                cVar.Sco.ScZ = b(map, "ptime", 0) / 1000;
                cVar.Sco.Sdc = f(map, "url", "");
            }
        }
        AppMethodBeat.o(189561);
    }

    static /* synthetic */ void q(c cVar, Map map) {
        float f2;
        Object obj;
        AppMethodBeat.i(189563);
        if (map != null) {
            if (map == null || (obj = map.get("scene")) == null) {
                f2 = 1.0f;
            } else {
                f2 = ((Float) obj).floatValue();
            }
            if (f2 != 1.0f) {
                cVar.SbX = 2;
                AppMethodBeat.o(189563);
                return;
            }
            cVar.SbX = 1;
        }
        AppMethodBeat.o(189563);
    }

    static /* synthetic */ void r(c cVar, Map map) {
        AppMethodBeat.i(189564);
        if (map != null) {
            cVar.Scd = T(map, "speed");
            cVar.Scq.ScC += cVar.Scd;
            cVar.Scq.ScD++;
            if (cVar.Scd > cVar.Scq.JON) {
                cVar.Scq.JON = cVar.Scd;
            }
            String f2 = f(map, "spanId", "");
            if (!TextUtils.isEmpty(f2)) {
                try {
                    JSONObject jSONObject = new JSONObject(f2);
                    if (jSONObject.has("spanId")) {
                        cVar.Scq.ScH = jSONObject.getString("spanId");
                    }
                    AppMethodBeat.o(189564);
                    return;
                } catch (Exception e2) {
                    g.e("TPReportManager", e2);
                }
            }
        }
        AppMethodBeat.o(189564);
    }

    static /* synthetic */ void s(c cVar, Map map) {
        String substring;
        AppMethodBeat.i(189565);
        if (map != null) {
            cVar.Scq.pkK = f(map, "url", "");
            cVar.Scq.cdnIp = f(map, "cdnip", "");
            cVar.Scq.cdnUip = f(map, "cdnuip", "");
            if (!TextUtils.isEmpty(cVar.Scq.pkK) && cVar.Scq.pkK.contains("sid=")) {
                int indexOf = cVar.Scq.pkK.indexOf("sid=");
                int indexOf2 = cVar.Scq.pkK.indexOf("&", indexOf);
                e eVar = cVar.Scq;
                if (indexOf2 >= 0) {
                    substring = cVar.Scq.pkK.substring(indexOf + 4, indexOf2);
                } else {
                    substring = cVar.Scq.pkK.substring(indexOf + 4);
                }
                eVar.ScI = substring;
            }
        }
        AppMethodBeat.o(189565);
    }

    static /* synthetic */ void t(c cVar, Map map) {
        AppMethodBeat.i(189566);
        g.i("TPReportManager", "onGetCdn");
        if (map != null) {
            h hVar = new h();
            d.f fVar = cVar.SbW.ScL;
            fVar.SdV = f(map, "ip", "");
            fVar.Sda = b(map, "stime", 0);
            fVar.Sdb = b(map, "etime", 0);
            fVar.Sdd = f(map, TMQQDownloaderOpenSDKConst.UINTYPE_CODE, AppEventsConstants.EVENT_PARAM_VALUE_NO);
            hVar.put("stime", fVar.Sda);
            hVar.put("etime", fVar.Sdb);
            hVar.put("ip", fVar.SdV);
            hVar.put(TMQQDownloaderOpenSDKConst.UINTYPE_CODE, fVar.Sdd);
            cVar.Scn.a(15, hVar);
            if (!TextUtils.isEmpty(fVar.Sdd) && !fVar.Sdd.equals(AppEventsConstants.EVENT_PARAM_VALUE_NO) && !fVar.Sdd.equals("0.0")) {
                cVar.Sci = fVar.Sdd;
            }
        }
        AppMethodBeat.o(189566);
    }

    static /* synthetic */ void u(c cVar, Map map) {
        AppMethodBeat.i(189567);
        g.i("TPReportManager", "on302Redirect");
        if (map != null) {
            h hVar = new h();
            d.k kVar = cVar.SbW.ScP;
            kVar.SeG = T(map, "vt");
            kVar.SeL = T(map, "t302");
            kVar.SeK = f(map, "url", "");
            kVar.Sda = b(map, "stime", 0);
            kVar.Sdb = b(map, "etime", 0);
            kVar.Sdd = f(map, TMQQDownloaderOpenSDKConst.UINTYPE_CODE, AppEventsConstants.EVENT_PARAM_VALUE_NO);
            hVar.put("etime", kVar.Sdb);
            hVar.put("url", kVar.SeK);
            hVar.put("vt", kVar.SeG);
            hVar.put("t302", kVar.SeL);
            hVar.put(TMQQDownloaderOpenSDKConst.UINTYPE_CODE, kVar.Sdd);
            cVar.Scn.a(34, hVar);
        }
        AppMethodBeat.o(189567);
    }

    static /* synthetic */ void v(c cVar, Map map) {
        AppMethodBeat.i(189568);
        g.i("TPReportManager", "onLoadSubtitle");
        if (map != null) {
            cVar.Scq.ScE = true;
            h hVar = new h();
            d.h hVar2 = cVar.SbW.ScO;
            if (cVar.SbV != null) {
                hVar2.SeG = cVar.SbV.subtitleCdnType;
                hVar2.SdU = cVar.SbV.subtitleUrlIndex;
            }
            hVar2.Sdg = T(map, "tduration");
            hVar2.SeF = f(map, "url", "");
            hVar2.Sda = b(map, "stime", 0);
            hVar2.Sdb = b(map, "etime", 0);
            hVar2.Sdd = f(map, TMQQDownloaderOpenSDKConst.UINTYPE_CODE, AppEventsConstants.EVENT_PARAM_VALUE_NO);
            hVar.put("stime", hVar2.Sda);
            hVar.put("etime", hVar2.Sdb);
            hVar.put("bufferduration", hVar2.Sdg);
            hVar.put("url", hVar2.SeF);
            hVar.put("vt", hVar2.SeG);
            hVar.put("urlindex", hVar2.SdU);
            hVar.put(TMQQDownloaderOpenSDKConst.UINTYPE_CODE, hVar2.Sdd);
            cVar.Scn.a(33, hVar);
        }
        AppMethodBeat.o(189568);
    }

    static /* synthetic */ void w(c cVar, Map map) {
        AppMethodBeat.i(189569);
        if (map != null) {
            cVar.Sci = f(map, TMQQDownloaderOpenSDKConst.UINTYPE_CODE, AppEventsConstants.EVENT_PARAM_VALUE_NO);
            if (cVar.SbV != null) {
                cVar.cFx = cVar.SbV.getPlayType();
            }
            if (cVar.cFx == 1) {
                cVar.Scn.a(150, new h());
                AppMethodBeat.o(189569);
                return;
            }
            map.put("reason", 3);
            cVar.SbZ = false;
            cVar.cr(map);
        }
        AppMethodBeat.o(189569);
    }

    static /* synthetic */ void x(c cVar, Map map) {
        AppMethodBeat.i(189570);
        if (map != null) {
            d.g gVar = cVar.SbW.ScT;
            long b2 = b(map, "stime", System.currentTimeMillis());
            gVar.SeE = (int) (b2 - cVar.Scq.Scv);
            cVar.SbW.ScM.SdS = b2;
        }
        AppMethodBeat.o(189570);
    }

    static /* synthetic */ void y(c cVar, Map map) {
        AppMethodBeat.i(189571);
        if (map != null) {
            cVar.SbW.ScM.SdR = b(map, "stime", System.currentTimeMillis());
        }
        AppMethodBeat.o(189571);
    }

    static /* synthetic */ void z(c cVar, Map map) {
        AppMethodBeat.i(189572);
        g.i("TPReportManager", "onSwitchDef");
        if (map != null) {
            cVar.Scq.ScG = f(map, "switch", "");
            cVar.Scq.RWM = true;
            if (cVar.cFx == 1) {
                cVar.SbS.removeMessages(3000);
                cVar.hol();
                cVar.Scq.Scv = 0;
                cVar.Scq.Scw = 0;
            }
        }
        AppMethodBeat.o(189572);
    }

    static /* synthetic */ void A(c cVar, Map map) {
        AppMethodBeat.i(189573);
        g.i("TPReportManager", "onSwitchDefEnd");
        if (map != null) {
            cVar.Scq.ScG = f(map, "switch", "");
            cVar.Scq.RWM = false;
            if (cVar.cFx == 1) {
                cVar.Scn.a(30, new h());
                cVar.SbS.removeMessages(3000);
                cVar.SbS.sendEmptyMessageDelayed(3000, Util.MILLSECONDS_OF_MINUTE);
                cVar.Scq.Sct = System.currentTimeMillis();
            }
        }
        AppMethodBeat.o(189573);
    }

    static /* synthetic */ void a(c cVar) {
        AppMethodBeat.i(189574);
        g.d("TPReportManager", "handleReportThreadExit");
        synchronized (cVar.SbT) {
            try {
                cVar.mIsExit = true;
                cVar.SbT.notify();
            } finally {
                AppMethodBeat.o(189574);
            }
        }
    }

    static /* synthetic */ void a(c cVar, String str) {
        String str2;
        long j2;
        AppMethodBeat.i(189576);
        if (TextUtils.isEmpty(str)) {
            g.i("TPReportManager", "onHandleHlsTag, tag is null");
            AppMethodBeat.o(189576);
        } else if (!str.startsWith("#EXT-X-PROGRAM-DATE-TIME:")) {
            g.i("TPReportManager", "onHandleHlsTag, tag is not start with #EXT-X-PROGRAM-DATE-TIME:");
            AppMethodBeat.o(189576);
        } else {
            try {
                String substring = str.substring(25);
                int indexOf = substring.indexOf(43);
                if (indexOf != -1) {
                    str2 = substring.substring(0, indexOf).replace('T', ' ');
                } else {
                    g.i("TPReportManager", "handleOnPlayerPrivaterHlsM3u8Tag , player_m3u8_tag , tag do not contains time zone");
                    str2 = substring.replace('T', ' ');
                }
            } catch (Exception e2) {
                g.e("TPReportManager", e2);
                str2 = "";
            }
            if (TextUtils.isEmpty(str2)) {
                g.i("TPReportManager", "onHandleHlsTag , player_m3u8_tag , dataTime is null ");
                AppMethodBeat.o(189576);
                return;
            }
            try {
                Date parse = new SimpleDateFormat(TimeUtil.YYYY2MM2DD_HH1MM1SS).parse(str2);
                if (parse != null) {
                    j2 = parse.getTime();
                    long currentTimeMillis = System.currentTimeMillis();
                    g.i("TPReportManager", "onHandleHlsTag , player_m3u8_tag , sysCurTime: " + currentTimeMillis + ", time:" + j2 + ", delay:" + (currentTimeMillis - j2));
                    cVar.Scq.ScB = (int) (currentTimeMillis - j2);
                    AppMethodBeat.o(189576);
                }
            } catch (Exception e3) {
                g.e("TPReportManager", e3);
            }
            j2 = 0;
            long currentTimeMillis2 = System.currentTimeMillis();
            g.i("TPReportManager", "onHandleHlsTag , player_m3u8_tag , sysCurTime: " + currentTimeMillis2 + ", time:" + j2 + ", delay:" + (currentTimeMillis2 - j2));
            cVar.Scq.ScB = (int) (currentTimeMillis2 - j2);
            AppMethodBeat.o(189576);
        }
    }

    static /* synthetic */ void c(c cVar) {
        AppMethodBeat.i(189577);
        g.i("TPReportManager", "onAppBackground");
        if (cVar.SbZ || cVar.cFx == 1 || !cVar.Sca) {
            AppMethodBeat.o(189577);
            return;
        }
        cVar.Sca = false;
        h hVar = new h();
        cVar.SbW.ScQ.c(hVar);
        cVar.SbW.ScR.c(hVar);
        d.i iVar = cVar.SbW.ScS;
        iVar.Sdb = System.currentTimeMillis();
        iVar.ScX = 2;
        iVar.Sdd = cVar.Sci;
        if (cVar.Scq.Sct > 0) {
            cVar.Scq.Scu += (int) (System.currentTimeMillis() - cVar.Scq.Sct);
            cVar.Scq.Sct = 0;
        }
        if (cVar.Scb > 0) {
            cVar.Scc += iVar.Sdb - cVar.Scb;
            cVar.Scb = 0;
        }
        iVar.SeH = ((float) cVar.Scc) / 1000.0f;
        iVar.c(hVar);
        d.c cVar2 = cVar.SbW.ScJ;
        cVar2.Sdi = 50;
        cVar2.c(hVar);
        if (cVar.cFx == 0) {
            cVar.a((a) hVar, false);
        } else if (cVar.cFx == 1) {
            cVar.b((a) hVar, false);
        }
        if (SbU != null && !TextUtils.isEmpty(cVar.Scj)) {
            g.i("TPReportManager", "Cache report event. mFlowId: " + cVar.Scj);
            SbU.a(cVar.Scj, hVar.getProperties());
        }
        AppMethodBeat.o(189577);
    }

    static /* synthetic */ void d(c cVar) {
        AppMethodBeat.i(189578);
        g.i("TPReportManager", "onAppForeground");
        if (!cVar.Sca) {
            cVar.Sca = true;
            cVar.hom();
        }
        AppMethodBeat.o(189578);
    }

    static /* synthetic */ void hon() {
        AppMethodBeat.i(189579);
        g.i("TPReportManager", "onReportLastEvent");
        if (SbU != null) {
            try {
                ArrayList arrayList = (ArrayList) SbU.hoo();
                if (arrayList != null) {
                    for (int i2 = 0; i2 < arrayList.size(); i2++) {
                        try {
                            Properties properties = (Properties) arrayList.get(i2);
                            if (properties != null) {
                                a(new h(properties));
                            }
                        } catch (Exception e2) {
                            g.e("TPReportManager", e2);
                        }
                    }
                }
            } catch (Exception e3) {
                g.e("TPReportManager", e3);
                AppMethodBeat.o(189579);
                return;
            }
        }
        AppMethodBeat.o(189579);
    }

    static /* synthetic */ void a(c cVar, a aVar, int i2, boolean z) {
        int i3 = 1;
        AppMethodBeat.i(189580);
        d.c cVar2 = cVar.SbW.ScJ;
        cVar2.Sdi = i2;
        cVar2.Sdj++;
        cVar2.Sdl = cVar.Scj;
        cVar2.Sdm = cVar.Scj;
        cVar2.Sdx = cVar.mHZ;
        cVar2.Sdz = cVar.Scd;
        cVar2.Sdy = cVar.bAX();
        cVar2.SdA = TPSystemInfo.getDeviceName();
        cVar2.SdB = cVar.mContext == null ? AppEventsConstants.EVENT_PARAM_VALUE_NO : cVar.mContext.getResources().getDisplayMetrics().heightPixels + "*" + cVar.mContext.getResources().getDisplayMetrics().widthPixels;
        cVar2.SdD = String.format("Android %s", TPSystemInfo.getOsVersion());
        cVar2.SdE = TPDownloadProxyHelper.getNativeLibVersion();
        cVar2.SdG = "2.9.0.1112";
        cVar2.SdH = cVar.RVX;
        cVar2.Sdw = cVar.Sch ? 1 : 0;
        cVar2.SdK = cVar.cFx;
        if (cVar.SbV != null && z) {
            cVar2.SdC = cVar.SbV.testId;
            cVar2.SdJ = cVar.SbV.cdnId;
            cVar2.SdL = cVar.SbV.dlType;
            cVar2.Sdq = cVar.SbV.loginType;
            cVar2.SdO = cVar.SbV.mediaFormat;
            cVar2.SdP = cVar.SbV.mediaRate;
            cVar2.SdI = cVar.SbV.configId;
            cVar2.Sdk = cVar.SbV.platform;
            if (!cVar.SbV.isOnline) {
                i3 = 0;
            }
            cVar2.Sdv = i3;
            cVar2.SdQ = cVar.SbV.mediaDuration;
            cVar2.Sdn = cVar.SbV.uin;
            cVar2.Sdo = cVar.SbV.qqOpenId;
            cVar2.Sdp = cVar.SbV.wxOpenId;
            cVar2.Sdr = cVar.SbV.guid;
            cVar2.Sds = cVar.SbV.uip;
            cVar2.Sdt = cVar.SbV.cdnUip;
            cVar2.Sdu = cVar.SbV.cdnIp;
            cVar2.SdF = cVar.SbV.appVersion;
            cVar2.SdM = cVar.SbV.vid;
            cVar2.SdN = cVar.SbV.mediaResolution;
            cVar2.scenesId = cVar.SbV.scenesId;
            if (cVar.SbV.reportInfoProperties != null) {
                for (Map.Entry entry : cVar.SbV.reportInfoProperties.entrySet()) {
                    Object key = entry.getKey();
                    Object value = entry.getValue();
                    if (value == null) {
                        aVar.put(key.toString(), "");
                    } else {
                        aVar.put(key.toString(), value.toString());
                    }
                }
            }
            cVar.cFx = cVar.SbV.getPlayType();
        }
        if (cVar2.Sdk <= 0) {
            cVar2.Sdk = (long) com.tencent.thumbplayer.d.a.getPlatform();
        }
        if (TextUtils.isEmpty(cVar2.Sdn)) {
            cVar2.Sdn = com.tencent.thumbplayer.d.a.hnn();
        }
        if (TextUtils.isEmpty(cVar2.Sdr)) {
            cVar2.Sdr = com.tencent.thumbplayer.d.a.getGuid();
        }
        if (TextUtils.isEmpty(cVar2.SdF)) {
            cVar2.SdF = com.tencent.thumbplayer.d.a.getAppVersionName(cVar.mContext);
        }
        if (TextUtils.isEmpty(cVar2.Sds)) {
            cVar2.Sds = cVar.Scq.cdnUip;
        }
        if (TextUtils.isEmpty(cVar2.Sdt)) {
            cVar2.Sdt = cVar.Scq.cdnUip;
        }
        if (TextUtils.isEmpty(cVar2.Sdu)) {
            cVar2.Sdu = cVar.Scq.cdnIp;
        }
        if (cVar2.SdL <= 0) {
            cVar2.SdL = cVar.mDownloadType;
        }
        if (TextUtils.isEmpty(cVar2.SdN)) {
            cVar2.SdN = cVar.Sck;
        }
        if (cVar2.SdQ <= 0.0f) {
            cVar2.SdQ = ((float) cVar.Scm) / 1000.0f;
        }
        if (cVar2.SdP <= 0) {
            cVar2.SdP = cVar.Scl;
        }
        cVar2.c(aVar);
        AppMethodBeat.o(189580);
    }
}

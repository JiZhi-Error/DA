package com.tencent.wecall.talkroom.model;

import android.media.AudioManager;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.aq;
import com.tencent.mm.plugin.multi.talk;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.pb.common.b.a.a.a;
import com.tencent.pb.common.b.h;
import com.tencent.pb.talkroom.sdk.MultiTalkGroup;
import com.tencent.smtt.sdk.TbsListener;
import com.tencent.smtt.sdk.TbsOnlineSDKExtensionEntry;
import com.tencent.tinker.loader.shareutil.ShareConstants;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import com.tencent.wecall.talkroom.a.i;
import com.tencent.wecall.talkroom.a.j;
import com.tencent.wecall.talkroom.a.k;
import com.tencent.wecall.talkroom.a.l;
import com.tencent.wecall.talkroom.a.m;
import com.tencent.wecall.talkroom.a.n;
import com.tencent.wecall.talkroom.a.o;
import com.tencent.wecall.talkroom.model.g;
import com.tencent.youtu.sdkkitframework.common.CommonUtils;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicInteger;

public final class f implements Handler.Callback, com.tencent.g.a.d, com.tencent.pb.common.b.b {
    private static com.tencent.pb.talkroom.sdk.e RCV = null;
    private static int SuD = CommonUtils.MAX_TIMEOUT_MS;
    public static List<Integer> Sux = new ArrayList();
    public static String[] Svj = {"GLOBAL_TOPIC_NETWORK_CHANGE", "topic_bind_mobile_other"};
    boolean GUf = false;
    public long HgX;
    int RCJ;
    private com.tencent.g.a.a Spf;
    private final int SuA = 2;
    private final int SuB = 3;
    private final int SuC = 4;
    private boolean SuE = false;
    private boolean SuF = false;
    private String SuG;
    public String SuH;
    private int SuI = 0;
    private int SuJ = 0;
    private int SuK = 0;
    private long SuL = 0;
    private boolean SuM = true;
    private int SuN = 0;
    private int SuO = 0;
    int SuP = 0;
    int SuQ = -1;
    private int SuR = -1;
    private int SuS = -1;
    private int SuT = -1;
    private int SuU = -1;
    private int SuV = -1;
    private int SuW = -1;
    private int SuX = -1;
    public h SuY = h.Sws;
    b SuZ;
    AbstractC2225f Suw;
    private Map<String, e> Suy = new HashMap();
    private final int Suz = 1;
    private talk.a Sva;
    private TimerTask Svb;
    private TimerTask Svc;
    private Timer Svd = new Timer("TalkRoomService_HelloTimer");
    private TimerTask Sve;
    private Timer Svf = new Timer("TalkRoomService_talkDurationTimer");
    g Svg = new g();
    private int Svh = 0;
    private boolean Svi = false;
    public String Svk = null;
    HashSet<Long> Svl = new HashSet<>();
    public boolean Svm = false;
    public boolean Svn = true;
    public boolean Svo = true;
    private short[] Svp = null;
    private String[] Svq = null;
    private short[] Svr = null;
    private String[] Svs = null;
    private int Svt = 0;
    public boolean Svu = false;
    public boolean Svv = true;
    private Runnable Svw = new Runnable() {
        /* class com.tencent.wecall.talkroom.model.f.AnonymousClass8 */

        public final void run() {
            AppMethodBeat.i(62550);
            if (f.this.fGt() && f.this.yIP) {
                com.tencent.pb.common.c.b.d("TalkRoomService", "syscall", "finishtalk becos holdtimeout");
                h.asL(-2003);
                f.this.SuY.asO(401);
                f.this.aY(f.this.xOr, 3, 108);
            }
            AppMethodBeat.o(62550);
        }
    };
    private com.tencent.pb.common.b.d Svx = null;
    private Runnable Svy = new Runnable() {
        /* class com.tencent.wecall.talkroom.model.f.AnonymousClass9 */

        public final void run() {
            com.tencent.wecall.talkroom.a.e eVar = null;
            AppMethodBeat.i(62587);
            Object[] objArr = new Object[6];
            objArr[0] = "beginSenceCircle state: ";
            objArr[1] = Integer.valueOf(f.this.state);
            objArr[2] = " mCircleScene: ";
            objArr[3] = f.this.Svx == null ? null : Integer.valueOf(f.this.Svx.getType());
            objArr[4] = " mIsAck: ";
            objArr[5] = Boolean.valueOf(f.this.SuE);
            com.tencent.pb.common.c.b.d("TalkRoomService", objArr);
            if (f.this.Svx == null) {
                f.this.mHandler.removeCallbacks(f.this.Svy);
                com.tencent.pb.common.c.b.w("TalkRoomService", "beginSenceCircle removeCallbacks");
                AppMethodBeat.o(62587);
            } else if (!f.this.fGt()) {
                f.this.mHandler.removeCallbacks(f.this.Svy);
                com.tencent.pb.common.c.b.w("TalkRoomService", "beginSenceCircle removeCallbacks");
                AppMethodBeat.o(62587);
            } else {
                if (f.this.Svx != null && f.this.Svx.getType() == 202 && f.this.state == 3) {
                    com.tencent.wecall.talkroom.a.e eVar2 = (com.tencent.wecall.talkroom.a.e) f.this.Svx;
                    if (f.a(f.this, eVar2.xOr, eVar2.yvK, eVar2.HgX, f.asJ(eVar2.SwU))) {
                        eVar = new com.tencent.wecall.talkroom.a.e(eVar2);
                        com.tencent.pb.common.c.b.w("TalkRoomService", "beginSenceCircle enter");
                    }
                }
                if (eVar != null) {
                    com.tencent.pb.common.b.e.hiW().a(eVar);
                    AppMethodBeat.o(62587);
                    return;
                }
                f.this.mHandler.removeCallbacks(f.this.Svy);
                com.tencent.pb.common.c.b.w("TalkRoomService", "beginSenceCircle removeCallbacks");
                AppMethodBeat.o(62587);
            }
        }
    };
    Handler mHandler;
    boolean mIsMute = false;
    int state = 0;
    public String xOr;
    boolean yIP = false;
    public int yvK;

    class d {
        long HgX;
        String xOr;
        int yvK;
    }

    /* renamed from: com.tencent.wecall.talkroom.model.f$f  reason: collision with other inner class name */
    public interface AbstractC2225f {
    }

    static /* synthetic */ void a(f fVar, int i2, a.bb[] bbVarArr, a.ay ayVar, byte[] bArr, boolean z, String str, int i3, long j2, int i4, int i5, byte[] bArr2, int[] iArr, int i6, int i7) {
        AppMethodBeat.i(199697);
        fVar.a(i2, bbVarArr, ayVar, bArr, z, str, i3, j2, i4, i5, bArr2, iArr, i6, i7);
        AppMethodBeat.o(199697);
    }

    static /* synthetic */ boolean a(f fVar, String str, int i2, long j2, boolean z) {
        AppMethodBeat.i(62784);
        boolean b2 = fVar.b(str, i2, j2, z);
        AppMethodBeat.o(62784);
        return b2;
    }

    static /* synthetic */ boolean asJ(int i2) {
        AppMethodBeat.i(62786);
        boolean asI = asI(i2);
        AppMethodBeat.o(62786);
        return asI;
    }

    static /* synthetic */ void k(f fVar) {
        AppMethodBeat.i(62782);
        fVar.hrm();
        AppMethodBeat.o(62782);
    }

    static {
        AppMethodBeat.i(62787);
        AppMethodBeat.o(62787);
    }

    /* access modifiers changed from: package-private */
    public class e {
        String groupId;
        int roomId;
        long ypH;

        e() {
        }
    }

    public enum b {
        OK,
        NOT_AUTH,
        NOT_BIND,
        NOT_MATCH,
        NO_NETWORK,
        BUSY,
        NOT_VALID_STATE,
        GROUP_NOT_VALID,
        UNINIT_SERVICE_FAILED,
        INIT_ENGINE_FAILED;

        public static b valueOf(String str) {
            AppMethodBeat.i(62685);
            b bVar = (b) Enum.valueOf(b.class, str);
            AppMethodBeat.o(62685);
            return bVar;
        }

        static {
            AppMethodBeat.i(62686);
            AppMethodBeat.o(62686);
        }
    }

    class a {
        int RDt;
        String[] SvT;
        a.be SvU;
        long SvV;
        String SvW;
        boolean SvX;
        String SvY;
        String groupId;
        int type;

        a() {
        }
    }

    public final boolean handleMessage(Message message) {
        String str;
        AppMethodBeat.i(62722);
        switch (message.what) {
            case 1:
                Object obj = message.obj;
                if (this.state != 4) {
                    if (obj instanceof d) {
                        d dVar = (d) obj;
                        if (dVar.xOr != null) {
                            com.tencent.pb.common.c.b.d("TalkRoomService", "handlerInviteTimeOut");
                            if (dVar.xOr.equals(this.xOr) && dVar.yvK == this.yvK && dVar.HgX == this.HgX) {
                                h.hrz();
                                this.SuY.asO(501);
                                c(dVar.xOr, dVar.yvK, dVar.HgX, 7);
                                com.tencent.pb.common.c.b.w("TalkRoomService", "handlerInviteTimeOut groupRoomInfo.mGroupId: ", dVar.xOr);
                                break;
                            }
                        } else {
                            com.tencent.pb.common.c.b.w("TalkRoomService", "handlerInviteTimeOut groupRoomInfo.mGroupId is null");
                            break;
                        }
                    } else {
                        com.tencent.pb.common.c.b.w("TalkRoomService", "handlerInviteTimeOut obj is not GroupRoomInfo");
                        break;
                    }
                } else {
                    com.tencent.pb.common.c.b.w("TalkRoomService", "handlerInviteTimeOut state: ", Integer.valueOf(this.state));
                    break;
                }
            case 2:
                Object obj2 = message.obj;
                if (this.state == 1) {
                    if (obj2 instanceof a) {
                        a aVar = (a) obj2;
                        if (com.tencent.pb.common.c.f.nG(aVar.groupId, this.xOr)) {
                            String str2 = aVar.groupId;
                            String[] strArr = aVar.SvT;
                            a.be beVar = aVar.SvU;
                            int i2 = aVar.RDt;
                            int i3 = aVar.type;
                            long j2 = aVar.SvV;
                            String str3 = aVar.SvW;
                            boolean z = aVar.SvX;
                            String str4 = aVar.SvY;
                            this.SuY.hrx();
                            String str5 = "";
                            TalkRoom brg = c.hqY().brg(str2);
                            if (brg != null) {
                                if (brg.Suh == null) {
                                    str = "";
                                } else {
                                    str = brg.Suh.name;
                                }
                                str5 = str;
                            }
                            boolean a2 = com.tencent.pb.common.b.e.hiW().a(new com.tencent.wecall.talkroom.a.d(str2, strArr, this.SuZ.hqV(), str5, beVar, i2, i3, j2, str3, z, str4));
                            this.SuY.ag("create", "req", String.valueOf(a2), String.valueOf(this.state));
                            com.tencent.pb.common.c.b.w("TalkRoomService", "sendCreateSence groupId: ", str2, " routeId:", Integer.valueOf(i2), " type: ", Integer.valueOf(i3), " playId: ", Long.valueOf(j2), " name: ", str5, " ret: ", Boolean.valueOf(a2));
                            break;
                        }
                    } else {
                        com.tencent.pb.common.c.b.w("TalkRoomService", "handlerCreateGroup obj is not CreateGroupObj");
                        break;
                    }
                } else {
                    com.tencent.pb.common.c.b.w("TalkRoomService", "handlerCreateGroup state: ", Integer.valueOf(this.state));
                    break;
                }
                break;
            case 3:
                Object obj3 = message.obj;
                if (this.state == 3) {
                    if (obj3 instanceof c) {
                        c cVar = (c) obj3;
                        if (b(cVar.groupId, cVar.roomId, cVar.ypH, false)) {
                            a(cVar.groupId, cVar.roomId, cVar.ypH, cVar.RDt, cVar.vkj, cVar.Swk);
                            break;
                        }
                    } else {
                        com.tencent.pb.common.c.b.w("TalkRoomService", "handlerCreateGroup obj is not CreateGroupObj");
                        break;
                    }
                } else {
                    com.tencent.pb.common.c.b.w("TalkRoomService", "handlerEnterGroup state: ", Integer.valueOf(this.state));
                    break;
                }
                break;
            case 4:
                com.tencent.pb.common.c.e.hjp();
                break;
        }
        AppMethodBeat.o(62722);
        return true;
    }

    public f() {
        AppMethodBeat.i(62723);
        com.tencent.pb.common.b.e.hiW().a(201, this);
        com.tencent.pb.common.b.e.hiW().a(202, this);
        com.tencent.pb.common.b.e.hiW().a(203, this);
        com.tencent.pb.common.b.e.hiW().a(204, this);
        com.tencent.pb.common.b.e.hiW().a(205, this);
        com.tencent.pb.common.b.e.hiW().a(206, this);
        com.tencent.pb.common.b.e.hiW().a(207, this);
        com.tencent.pb.common.b.e.hiW().a(208, this);
        com.tencent.pb.common.b.e.hiW().a(210, this);
        com.tencent.pb.common.b.e.hiW().a(209, this);
        com.tencent.pb.common.b.e.hiW().a(211, this);
        com.tencent.pb.common.b.e.hiW().a(212, this);
        com.tencent.pb.common.b.e.hiW().a(213, this);
        com.tencent.pb.common.b.e.hiW().a(214, this);
        com.tencent.pb.common.b.e.hiW().a(800, this);
        com.tencent.pb.common.b.e.hiW().a(801, this);
        com.tencent.pb.common.b.e.hiW().a(802, this);
        c hqY = c.hqY();
        g gVar = this.Svg;
        Throwable th = new Throwable("trace caller");
        try {
            th.getStackTrace();
        } catch (Exception e2) {
            com.tencent.pb.common.c.b.d("TalkRoomManager", "setTalkServerCallback caller stack: ", th);
        }
        hqY.Suo = gVar;
        HandlerThread handlerThread = new HandlerThread("TalkRoomService");
        handlerThread.start();
        this.mHandler = new Handler(handlerThread.getLooper(), this);
        hrf();
        if (this.Spf == null) {
            this.Spf = (com.tencent.g.a.a) com.tencent.g.f.bqW("EventCenter");
        }
        com.tencent.pb.common.c.b.d("TalkRoomService", "syscall", "register", Boolean.TRUE);
        this.Spf.a(this, Svj);
        AppMethodBeat.o(62723);
    }

    private void hrf() {
        AppMethodBeat.i(199683);
        this.SuR = -1;
        this.SuS = -1;
        this.SuT = -1;
        this.SuU = -1;
        this.SuV = -1;
        this.SuW = -1;
        this.SuX = -1;
        com.tencent.pb.common.c.b.w("TalkRoomService", "multitalk voiceMsg local seq reset");
        AppMethodBeat.o(199683);
    }

    /* access modifiers changed from: package-private */
    public final boolean hrg() {
        AppMethodBeat.i(62724);
        com.tencent.pb.common.c.b.d("TalkRoomService", "initService");
        com.tencent.pb.talkroom.sdk.e eVar = RCV;
        if (eVar != null) {
            eVar.emM();
        }
        this.SuZ = new b();
        this.Svk = this.xOr;
        hrf();
        this.Sva = new talk.a() {
            /* class com.tencent.wecall.talkroom.model.f.AnonymousClass1 */

            @Override // com.tencent.mm.plugin.multi.talk.a
            public final void keep_OnOpenSuccess() {
                TalkRoom brg;
                List<d> hqP;
                int[] iArr = null;
                AppMethodBeat.i(62603);
                f.this.SuY.yqT = 1;
                com.tencent.pb.common.c.b.d("TalkRoomService", "engine OnOpenSuccess");
                if (f.this.state != 4) {
                    com.tencent.pb.common.c.b.w("TalkRoomService", "has exit the talkroom state:%d", Integer.valueOf(f.this.state));
                    AppMethodBeat.o(62603);
                    return;
                }
                try {
                    f fVar = f.this;
                    c hqY = c.hqY();
                    String str = f.this.xOr;
                    if (!(TextUtils.isEmpty(str) || (brg = hqY.brg(str)) == null || (hqP = brg.hqP()) == null)) {
                        int[] iArr2 = new int[hqP.size()];
                        StringBuffer stringBuffer = new StringBuffer();
                        for (int i2 = 0; i2 < hqP.size(); i2++) {
                            d dVar = hqP.get(i2);
                            if (dVar != null) {
                                iArr2[i2] = dVar.getMemberId();
                                stringBuffer.append(iArr2[i2]);
                                stringBuffer.append(",");
                            }
                        }
                        com.tencent.pb.common.c.b.w("TalkRoomManager", "getAllMemberIds memberIds: ", stringBuffer.toString());
                        iArr = iArr2;
                    }
                    f.a(fVar, iArr);
                    if (f.this.SuZ != null) {
                        b bVar = f.this.SuZ;
                        boolean hrs = f.hrs();
                        if (com.tencent.pb.common.a.a.RCk && bVar.Suj != null) {
                            if (hrs) {
                                bVar.Suj.setAppCmd(401);
                            } else {
                                bVar.Suj.setAppCmd(402);
                            }
                        }
                    }
                    f.this.SuF = true;
                    b unused = f.this.SuZ;
                    com.tencent.pb.talkroom.sdk.e hrt = f.hrt();
                    if (hrt != null) {
                        hrt.emO();
                    }
                    talk talk = f.this.SuZ.Suj;
                    if (com.tencent.pb.common.a.a.RCk) {
                        AtomicInteger atomicInteger = new AtomicInteger();
                        AtomicInteger atomicInteger2 = new AtomicInteger();
                        try {
                            talk.getSampleRate(atomicInteger, atomicInteger2);
                        } catch (Throwable th) {
                            com.tencent.pb.common.c.b.w("VoipAdapterUtil", "adapterInitv2engineSampleRate:  ", th);
                        }
                        int i3 = atomicInteger.get();
                        int i4 = atomicInteger2.get();
                        talk.VOICE_SAMPLERATE = i3;
                        talk.VOICE_FRAME_DURATION = i4;
                        com.tencent.pb.common.c.b.w("VoipAdapterUtil", "adapterInitv2engineSampleRate getSampleRate:", Integer.valueOf(talk.VOICE_SAMPLERATE), Integer.valueOf(talk.VOICE_FRAME_DURATION));
                    }
                    new Handler(Looper.getMainLooper()).post(new Runnable() {
                        /* class com.tencent.wecall.talkroom.model.f.AnonymousClass1.AnonymousClass1 */

                        public final void run() {
                            AppMethodBeat.i(62789);
                            try {
                                com.tencent.pb.common.c.b.i("TalkRoomService", "initMediaComponent");
                                f.e(f.this);
                                AppMethodBeat.o(62789);
                            } catch (Throwable th) {
                                com.tencent.pb.common.c.b.w("TalkRoomService", "keep_OnOpenSuccess initMediaComponent:  ", th);
                                AppMethodBeat.o(62789);
                            }
                        }
                    });
                    h hVar = f.this.SuY;
                    if (hVar.SwH == 0) {
                        hVar.Sww = 0;
                    } else {
                        hVar.Sww = System.currentTimeMillis() - hVar.SwH;
                    }
                    com.tencent.pb.common.c.b.d(h.TAG, "endFirstSendPcm", Long.valueOf(hVar.Sww), Long.valueOf(hVar.SwH));
                    g gVar = f.this.Svg;
                    g.AnonymousClass6 r1 = new Runnable() {
                        /* class com.tencent.wecall.talkroom.model.g.AnonymousClass6 */

                        public final void run() {
                            AppMethodBeat.i(62633);
                            synchronized (g.this.callbacks) {
                                try {
                                    for (a aVar : g.this.callbacks) {
                                        aVar.bgz();
                                    }
                                } finally {
                                    AppMethodBeat.o(62633);
                                }
                            }
                        }
                    };
                    if (Looper.myLooper() == Looper.getMainLooper()) {
                        r1.run();
                        AppMethodBeat.o(62603);
                        return;
                    }
                    gVar.handler.post(r1);
                    AppMethodBeat.o(62603);
                } catch (Throwable th2) {
                    com.tencent.pb.common.c.b.w("TalkRoomService", "keep_OnOpenSuccess:  ", th2);
                    AppMethodBeat.o(62603);
                }
            }

            @Override // com.tencent.mm.plugin.multi.talk.a
            public final void keep_OnError(int i2) {
                int i3 = -401;
                AppMethodBeat.i(62604);
                int i4 = 207;
                int i5 = -3007;
                int i6 = 103;
                switch (i2) {
                    case -4:
                        i4 = 206;
                        i5 = -3006;
                        i6 = 115;
                        i3 = -400;
                        break;
                    case -3:
                        i4 = 205;
                        i5 = -3005;
                        i6 = 114;
                        break;
                    case -2:
                        i4 = 204;
                        i5 = -3004;
                        i6 = 113;
                        break;
                    case -1:
                        i4 = 203;
                        i5 = -3003;
                        i6 = 112;
                        break;
                    default:
                        i3 = -400;
                        break;
                }
                new Handler(Looper.getMainLooper()).post(new a(i3, i4, i5, i6, i2));
                AppMethodBeat.o(62604);
            }

            /* renamed from: com.tencent.wecall.talkroom.model.f$1$a */
            class a implements Runnable {
                int SvB;
                int SvC;
                int SvD;
                int SvE;
                int SvF;

                a(int i2, int i3, int i4, int i5, int i6) {
                    this.SvB = i2;
                    this.SvD = i3;
                    this.SvE = i4;
                    this.SvF = i5;
                    this.SvC = i6;
                }

                public final void run() {
                    AppMethodBeat.i(62585);
                    com.tencent.pb.common.c.b.i("TalkRoomService", "keep_OnError handler");
                    h.asN(this.SvE);
                    f.this.SuY.asO(this.SvD);
                    com.tencent.pb.common.c.b.d("TalkRoomService", "engine exitTalkRoom engineCallback OnError:", Integer.valueOf(this.SvC));
                    f.this.a(f.this.xOr, f.this.yvK, f.this.HgX, this.SvF, true);
                    f.this.Svg.n(this.SvB, null);
                    AppMethodBeat.o(62585);
                }
            }

            @Override // com.tencent.mm.plugin.multi.talk.a
            public final void keep_OnNotify(int i2) {
                AppMethodBeat.i(62605);
                com.tencent.pb.common.c.b.w("TalkRoomService", "keep_OnNotify eventCode: ", Integer.valueOf(i2));
                if (i2 == 5) {
                    f.this.SuY.Swu = 1;
                    h hVar = f.this.SuY;
                    if (hVar.SwH == 0) {
                        hVar.Swv = 0;
                    } else {
                        hVar.Swv = System.currentTimeMillis() - hVar.SwH;
                    }
                    com.tencent.pb.common.c.b.d(h.TAG, "endRecvFirstPcm", Long.valueOf(hVar.SwH), Long.valueOf(hVar.Swv));
                    f.this.SuN = 1;
                    f.j(f.this);
                }
                AppMethodBeat.o(62605);
            }

            @Override // com.tencent.mm.plugin.multi.talk.a
            public final void keep_OnReportEngineRecv(String str, int i2) {
                AppMethodBeat.i(62606);
                com.tencent.pb.common.c.b.d("TalkRoomService", "keep_OnReportEngineRecv:", Integer.valueOf(i2), str);
                h.brr(com.tencent.pb.common.c.f.bpK(f.this.Svk) + "," + str);
                AppMethodBeat.o(62606);
            }

            @Override // com.tencent.mm.plugin.multi.talk.a
            public final void keep_OnReportEngineSend(String str) {
                AppMethodBeat.i(62607);
                com.tencent.pb.common.c.b.d("TalkRoomService", "keep_OnReportEngineSend:", str);
                h.brs(com.tencent.pb.common.c.f.bpK(f.this.Svk) + "," + str);
                AppMethodBeat.o(62607);
            }

            @Override // com.tencent.mm.plugin.multi.talk.a
            public final void keep_OnReportChannel(String str) {
                AppMethodBeat.i(62608);
                com.tencent.pb.common.c.b.d("TalkRoomService", "keep_OnReportChannel:", str);
                h.brt(com.tencent.pb.common.c.f.bpK(f.this.Svk) + "," + str);
                AppMethodBeat.o(62608);
            }
        };
        AppMethodBeat.o(62724);
        return true;
    }

    public final void Eh(boolean z) {
        AppMethodBeat.i(62725);
        this.SuY.groupId = this.xOr;
        this.SuY.RDo = this.SuH;
        if (com.tencent.pb.common.c.f.eP(this.SuY.groupId)) {
            this.SuY.groupId = "";
        }
        if (com.tencent.pb.common.c.f.eP(this.SuY.RDo)) {
            this.SuY.RDo = "";
        }
        this.SuY.HaK = 1;
        this.SuY.roomId = this.yvK;
        this.SuY.ypH = this.HgX;
        hrf();
        com.tencent.pb.common.c.b.d("TalkRoomService", "uninitService isUpload: ", Boolean.valueOf(z));
        fuc();
        and();
        int i2 = TbsOnlineSDKExtensionEntry.EXTENSION_INIT_FAILURE;
        if (this.SuZ != null) {
            try {
                this.Svh = this.SuZ.hqX();
                i2 = this.SuZ.Close();
            } catch (Throwable th) {
                com.tencent.pb.common.c.b.w("TalkRoomService", "uninitService", th);
            }
            com.tencent.pb.common.c.b.w("TalkRoomService", "uninitService mid", Integer.valueOf(i2));
        }
        if (this.SuZ != null) {
            try {
                i2 = this.SuZ.uninitLive();
            } catch (Exception e2) {
                com.tencent.pb.common.c.b.w("TalkRoomService", "uninitService 2", e2);
            }
        }
        this.SuZ = null;
        com.tencent.pb.common.c.b.w("TalkRoomService", "steve:uninitService set engine null!");
        if (z) {
            String hru = this.SuY.hru();
            if (!TextUtils.isEmpty(this.SuY.groupId) || !TextUtils.isEmpty(this.SuY.RDo)) {
                h.brq(hru);
                this.mHandler.removeMessages(4);
                this.mHandler.sendEmptyMessageDelayed(4, 0);
            }
            this.SuY.reset();
            hrr();
        }
        com.tencent.pb.common.c.b.d("TalkRoomService", "uninitService end error", Integer.valueOf(i2));
        AppMethodBeat.o(62725);
    }

    public final void hrh() {
        AppMethodBeat.i(62726);
        try {
            com.tencent.pb.common.c.b.w("TalkRoomService", "stopHoldeOnPusher ");
            if (this.Svw != null) {
                this.mHandler.removeCallbacks(this.Svw);
            }
            AppMethodBeat.o(62726);
        } catch (Throwable th) {
            com.tencent.pb.common.c.b.w("TalkRoomService", " stopTimer: ", th);
            AppMethodBeat.o(62726);
        }
    }

    private void and() {
        AppMethodBeat.i(62727);
        this.Suy.remove(this.xOr);
        this.Svh = 0;
        this.mIsMute = false;
        setState(0);
        this.SuF = false;
        a(this.SuH, 0, 0, (String) null, (String) null);
        this.SuH = null;
        this.RCJ = 0;
        this.SuI = 0;
        this.SuJ = 0;
        this.SuK = 0;
        this.SuM = true;
        this.Svn = true;
        this.SuL = 0;
        this.SuN = 0;
        this.SuE = false;
        this.Svu = false;
        this.Svv = true;
        hrh();
        this.mHandler.removeMessages(1);
        if (this.SuZ != null) {
            this.SuZ.hqW();
        }
        hrm();
        hrl();
        hrn();
        hrq();
        this.yIP = false;
        this.Svm = false;
        this.SuO = 0;
        AppMethodBeat.o(62727);
    }

    /* access modifiers changed from: package-private */
    public final void setState(int i2) {
        AppMethodBeat.i(62728);
        com.tencent.pb.common.c.b.w("TalkRoomService", "setState newState: ", Integer.valueOf(i2));
        if (this.state == i2) {
            AppMethodBeat.o(62728);
            return;
        }
        this.state = i2;
        this.Svg.onStateChanged(i2);
        AppMethodBeat.o(62728);
    }

    static String[] kj(List<String> list) {
        AppMethodBeat.i(62729);
        if (list == null || list.size() <= 0) {
            String[] strArr = new String[0];
            AppMethodBeat.o(62729);
            return strArr;
        }
        String[] strArr2 = new String[list.size()];
        int i2 = 0;
        for (String str : list) {
            strArr2[i2] = str;
            i2++;
        }
        AppMethodBeat.o(62729);
        return strArr2;
    }

    public final b a(String str, int i2, long j2, int i3, int i4, String str2, int i5) {
        AppMethodBeat.i(183718);
        com.tencent.pb.common.c.b.w("TalkRoomService", "enterTalkRoom", str, str2, Integer.valueOf(this.yvK), Integer.valueOf(i2), Long.valueOf(this.HgX), Long.valueOf(j2), Integer.valueOf(i4), "needConfirm", Boolean.FALSE);
        this.SuP = i5;
        if (!com.tencent.pb.a.a.a.hjr()) {
            com.tencent.pb.common.c.b.w("TalkRoomService", "enterTalkRoom isAuthed: ", Boolean.valueOf(com.tencent.pb.a.a.a.hjr()), " isBindMobile: ", Boolean.valueOf(com.tencent.pb.a.a.a.hjs()));
            h.a(str, "", this.yvK, this.HgX, "enter", "req", "false", String.valueOf(i4), "noAuth");
            b bVar = b.NOT_AUTH;
            AppMethodBeat.o(183718);
            return bVar;
        }
        h.isNetworkConnected();
        if (asI(i4) && i4 != 100 && fGt()) {
            h.a(str, "", this.yvK, this.HgX, "enter", "req", "false", String.valueOf(i4), "isBusy");
            com.tencent.pb.common.c.b.w("TalkRoomService", "enterTalkRoom isBusy");
            b bVar2 = b.BUSY;
            AppMethodBeat.o(183718);
            return bVar2;
        } else if (!dy(i4, str)) {
            com.tencent.pb.common.c.b.w("TalkRoomService", "exitTalkRoom enterTalkRoom isValidEnterState is false enterType: ", Integer.valueOf(i4), " state: ", Integer.valueOf(this.state));
            h.a(str, "", this.yvK, this.HgX, "enter", "req", "false", String.valueOf(i4), "isNotValidEnterState");
            b bVar3 = b.NOT_VALID_STATE;
            AppMethodBeat.o(183718);
            return bVar3;
        } else if (TextUtils.isEmpty(str)) {
            com.tencent.pb.common.c.b.w("TalkRoomService", "exitTalkRoom enterTalkRoom groupId is null");
            h.a(str, "", this.yvK, this.HgX, "enter", "req", "false", String.valueOf(i4), "groupIdnull");
            b bVar4 = b.GROUP_NOT_VALID;
            AppMethodBeat.o(183718);
            return bVar4;
        } else {
            if (asI(i4)) {
                this.SuY.reset();
                Eh(false);
            }
            hrg();
            if (!fuf()) {
                com.tencent.pb.common.c.b.w("TalkRoomService", "exitTalkRoom enterTalkRoom initEngine fail");
                if (asI(i4)) {
                    h.a(str, "", this.yvK, this.HgX, "enter", "req", "false", "initEnginefail");
                    Eh(false);
                } else {
                    this.SuY.ag("enter", "req", "false", "initEnginefail");
                }
                b bVar5 = b.INIT_ENGINE_FAILED;
                AppMethodBeat.o(183718);
                return bVar5;
            }
            this.xOr = str;
            if (!asI(i4)) {
                e bro = bro(str);
                this.yvK = bro == null ? 0 : bro.roomId;
                this.HgX = bro == null ? 0 : bro.ypH;
            } else {
                this.yvK = i2;
                this.HgX = j2;
            }
            this.Svk = str;
            this.RCJ = i3;
            setState(3);
            this.GUf = asI(i4);
            if (this.GUf) {
                this.SuY.hrv();
            }
            if (!this.GUf || c.hqY().dG(this.xOr, true)) {
                a(str, this.yvK, this.HgX, i3, i4, str2);
            } else {
                c cVar = new c();
                cVar.groupId = str;
                cVar.roomId = i2;
                cVar.ypH = j2;
                cVar.vkj = i4;
                cVar.RDt = i3;
                cVar.Swk = str2;
                Message obtain = Message.obtain();
                obtain.what = 3;
                obtain.obj = cVar;
                this.mHandler.sendMessageDelayed(obtain, 0);
            }
            b bVar6 = b.OK;
            AppMethodBeat.o(183718);
            return bVar6;
        }
    }

    private void a(String str, int i2, long j2, int i3, int i4, String str2) {
        AppMethodBeat.i(62731);
        com.tencent.pb.common.c.b.w("TalkRoomService", "sendEnterGroupScence groupId: ", str, " roomId: ", Integer.valueOf(i2), " roomKey: ", Long.valueOf(j2), " enterType: ", Integer.valueOf(i4), " isSenceCircle: ", Boolean.TRUE, " wXgroupId: ", str2);
        if (i2 == 0 || j2 == 0) {
            com.tencent.pb.common.c.b.e("TalkRoomService", "roomId or roomkey is 0..return.");
            AppMethodBeat.o(62731);
            return;
        }
        if (!asI(i4)) {
            this.SuY.hry();
        }
        this.SuY.hrx();
        com.tencent.wecall.talkroom.a.e eVar = new com.tencent.wecall.talkroom.a.e(str, i2, j2, this.SuZ.hqV(), i3, i4, str2);
        com.tencent.pb.common.b.e.hiW().a(eVar);
        c(eVar);
        AppMethodBeat.o(62731);
    }

    /* access modifiers changed from: package-private */
    public class c {
        int RDt;
        String Swk;
        String groupId;
        int roomId;
        int vkj;
        long ypH;

        c() {
        }
    }

    private boolean dy(int i2, String str) {
        AppMethodBeat.i(62732);
        if (i2 == 100) {
            AppMethodBeat.o(62732);
            return true;
        } else if (asI(i2)) {
            if (this.state == 0) {
                AppMethodBeat.o(62732);
                return true;
            }
            AppMethodBeat.o(62732);
            return false;
        } else if (i2 == 1) {
            boolean brp = brp(str);
            AppMethodBeat.o(62732);
            return brp;
        } else {
            AppMethodBeat.o(62732);
            return false;
        }
    }

    public final boolean c(String str, int i2, long j2, int i3) {
        AppMethodBeat.i(62733);
        com.tencent.pb.common.c.b.w("TalkRoomService", "rejectTalkRoom groupId: ", str, " mGroupId: ", this.xOr, " roomId: ", Integer.valueOf(i2), " roomKey: ", Long.valueOf(j2), " reason: ", Integer.valueOf(i3));
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(62733);
            return false;
        }
        if (3 == (1 == i3 ? (char) 1 : 3) && i3 != 7) {
            hri();
        }
        boolean a2 = com.tencent.pb.common.b.e.hiW().a(new i(str, i2, j2, i3));
        if (b(str, i2, j2, false)) {
            this.SuY.ag("reject", "req", String.valueOf(a2), String.valueOf(this.state));
        } else {
            h.a(str, i2, j2, "reject", "req", String.valueOf(a2), String.valueOf(this.state));
        }
        a(str, i2, j2, false);
        com.tencent.pb.common.c.b.w("TalkRoomService", "rejectTalkRoom ret: ", Boolean.valueOf(a2));
        AppMethodBeat.o(62733);
        return a2;
    }

    private int hri() {
        AppMethodBeat.i(62734);
        if (this.SuL == 0) {
            AppMethodBeat.o(62734);
            return 0;
        }
        int currentTimeMillis = (int) ((System.currentTimeMillis() - this.SuL) / 1000);
        AppMethodBeat.o(62734);
        return currentTimeMillis;
    }

    private boolean hL(String str, int i2) {
        AppMethodBeat.i(62735);
        com.tencent.pb.common.c.b.w("TalkRoomService", "cancelCreateTalkRoom clientGroupId: ", str);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(62735);
            return false;
        }
        boolean a2 = com.tencent.pb.common.b.e.hiW().a(new com.tencent.wecall.talkroom.a.c(str, i2, this.RCJ));
        this.SuY.ag("cancel", "req", String.valueOf(a2), String.valueOf(this.state));
        a(str, this.yvK, this.HgX, true);
        com.tencent.pb.common.c.b.w("TalkRoomService", "cancelCreateTalkRoom ret: ", Boolean.valueOf(a2));
        AppMethodBeat.o(62735);
        return a2;
    }

    public final boolean a(String str, int i2, long j2, int i3, boolean z) {
        AppMethodBeat.i(62736);
        com.tencent.pb.common.c.b.w("TalkRoomService", "exitTalkRoom", str, Integer.valueOf(i2), Long.valueOf(j2), Integer.valueOf(i3));
        if (TextUtils.isEmpty(str)) {
            com.tencent.pb.common.c.b.d("TalkRoomService", "exitTalkRoom: has exited");
            AppMethodBeat.o(62736);
            return false;
        }
        boolean a2 = com.tencent.pb.common.b.e.hiW().a(new com.tencent.wecall.talkroom.a.f(str, i2, j2, i3));
        this.SuY.ag("exit", "req", String.valueOf(a2), String.valueOf(this.state));
        a(str, i2, j2, z);
        com.tencent.pb.common.c.b.w("TalkRoomService", "exitTalkRoom ret: ", Boolean.valueOf(a2));
        AppMethodBeat.o(62736);
        return a2;
    }

    private static int b(int i2, int i3, com.tencent.pb.talkroom.sdk.b bVar) {
        AppMethodBeat.i(62738);
        int i4 = -100;
        try {
            com.tencent.pb.talkroom.sdk.e eVar = RCV;
            if (eVar != null) {
                i4 = eVar.a(i2, i3, bVar);
            }
        } catch (Exception e2) {
            com.tencent.pb.common.c.b.w("TalkRoomService", "startPlayer: ", Integer.valueOf(i2), Integer.valueOf(i3), e2);
        }
        com.tencent.pb.common.c.b.d("TalkRoomService", "startPlayer samplerate: ", " frameDuration: ", Integer.valueOf(i3), " ret: ", Integer.valueOf(i4));
        AppMethodBeat.o(62738);
        return i4;
    }

    private static int b(int i2, int i3, com.tencent.pb.talkroom.sdk.c cVar) {
        AppMethodBeat.i(62740);
        int i4 = -100;
        try {
            com.tencent.pb.talkroom.sdk.e eVar = RCV;
            if (eVar != null) {
                i4 = eVar.a(i2, i3, cVar);
            }
        } catch (Exception e2) {
            com.tencent.pb.common.c.b.w("TalkRoomService", "startRecord: ", e2);
        }
        com.tencent.pb.common.c.b.d("TalkRoomService", "startRecord samplerate: ", " frameDuration: ", Integer.valueOf(i3), " ret: ", Integer.valueOf(i4));
        AppMethodBeat.o(62740);
        return i4;
    }

    private void fuc() {
        AppMethodBeat.i(62741);
        com.tencent.pb.common.c.b.d("TalkRoomService", "releaseConpent");
        try {
            ZZ();
        } catch (Throwable th) {
            com.tencent.pb.common.c.b.w("TalkRoomService", "releaseConpent ", th);
        }
        try {
            hrj();
            AppMethodBeat.o(62741);
        } catch (Throwable th2) {
            com.tencent.pb.common.c.b.w("TalkRoomService", "releaseConpent ", th2);
            AppMethodBeat.o(62741);
        }
    }

    @Override // com.tencent.pb.common.b.b
    public final void a(int i2, int i3, String str, com.tencent.pb.common.b.d dVar) {
        com.tencent.wecall.talkroom.a.h hVar;
        com.tencent.wecall.talkroom.a.g gVar;
        com.tencent.wecall.talkroom.a.c cVar;
        i iVar;
        com.tencent.wecall.talkroom.a.a aVar;
        o oVar;
        com.tencent.wecall.talkroom.a.f fVar;
        com.tencent.wecall.talkroom.a.b bVar;
        com.tencent.wecall.talkroom.a.e eVar;
        com.tencent.wecall.talkroom.a.d dVar2;
        AppMethodBeat.i(62742);
        Object[] objArr = new Object[6];
        objArr[0] = "CLTNOT onNetSceneEnd errCode:";
        objArr[1] = Integer.valueOf(i3);
        objArr[2] = " errType: ";
        objArr[3] = Integer.valueOf(i2);
        objArr[4] = " scene.getType(): ";
        objArr[5] = dVar != null ? Integer.valueOf(dVar.getType()) : "";
        com.tencent.pb.common.c.b.d("TalkRoomService", objArr);
        if (i2 == 1 || i2 == 2) {
            Map N = com.tencent.pb.common.c.a.N(201, -1004, 202, -1107, 203, -1205, 204, -1304, 205, -1403, 207, -1502, 209, -1512, 206, -1522, 208, -1532, 210, -1542);
            int type = dVar.getType();
            if (N.containsKey(Integer.valueOf(type))) {
                h.asK(((Integer) N.get(Integer.valueOf(type))).intValue());
            }
        }
        if (i3 == -1) {
            try {
                if (dVar.getType() == 201) {
                    com.tencent.wecall.talkroom.a.d dVar3 = (com.tencent.wecall.talkroom.a.d) dVar;
                    if (com.tencent.pb.common.c.f.nG(this.SuH, dVar3.SuH)) {
                        this.SuY.asO(301);
                        this.SuY.ag("create", "resp", "-1", String.valueOf(this.state));
                        hL(dVar3.SuH, 1001);
                        if (!dVar3.SwT) {
                            this.Spf.c("TOPIC_ASYNC_CREATE_ROOM_DONE", 0, null);
                        }
                        this.Svg.n(-100, null);
                    }
                    AppMethodBeat.o(62742);
                } else if (dVar.getType() == 209) {
                    this.Svg.hK(((com.tencent.wecall.talkroom.a.g) dVar).xOr, i3);
                    AppMethodBeat.o(62742);
                } else if (dVar.getType() == 206) {
                    com.tencent.wecall.talkroom.a.a aVar2 = (com.tencent.wecall.talkroom.a.a) dVar;
                    if (!b(aVar2.xOr, aVar2.yvK, aVar2.HgX, false)) {
                        h.a(aVar2.xOr, aVar2.yvK, aVar2.HgX, "ack", "resp", "-1", String.valueOf(this.state));
                    }
                    this.Svg.a(aVar2.SwS, c.hqY().brn(aVar2.xOr));
                    AppMethodBeat.o(62742);
                } else if (dVar.getType() == 204) {
                    com.tencent.wecall.talkroom.a.b bVar2 = (com.tencent.wecall.talkroom.a.b) dVar;
                    if (b(bVar2.xOr, bVar2.yvK, bVar2.HgX, false)) {
                        this.SuY.ag("add", "resp", "-1", String.valueOf(this.state));
                        this.Svg.n(-300, null);
                    }
                    AppMethodBeat.o(62742);
                } else if (dVar.getType() == 202) {
                    com.tencent.wecall.talkroom.a.e eVar2 = (com.tencent.wecall.talkroom.a.e) dVar;
                    if (b(eVar2.xOr, eVar2.yvK, eVar2.HgX, asI(eVar2.SwU)) && this.state == 3) {
                        this.SuY.asO(302);
                        this.Svg.n(-200, null);
                    }
                    AppMethodBeat.o(62742);
                } else if (dVar.getType() == 212) {
                    this.Svg.ki(null);
                    AppMethodBeat.o(62742);
                } else if (dVar.getType() == 213) {
                    if (com.tencent.pb.common.c.f.equals(((j) dVar).xOr, this.xOr)) {
                        this.SuY.ag("sendmsg", "resp", "-1", String.valueOf(this.state));
                        this.Svg.n(-700, null);
                    }
                    AppMethodBeat.o(62742);
                } else if (dVar.getType() == 211) {
                    com.tencent.wecall.talkroom.a.h hVar2 = (com.tencent.wecall.talkroom.a.h) dVar;
                    if (b(hVar2.groupId, hVar2.roomId, hVar2.ypH, false)) {
                        this.SuY.ag("redirect", "resp", "-1", String.valueOf(this.state));
                    }
                    AppMethodBeat.o(62742);
                } else if (dVar.getType() == 214) {
                    n nVar = (n) dVar;
                    if (b(nVar.xOr, nVar.yvK, nVar.HgX, false)) {
                        this.Svg.n(-800, null);
                    }
                    AppMethodBeat.o(62742);
                } else if (dVar.getType() == 800) {
                    l lVar = (l) dVar;
                    if (b(lVar.xOr, lVar.yvK, lVar.HgX, false)) {
                        this.Svg.n(-1600, null);
                    }
                    AppMethodBeat.o(62742);
                } else if (dVar.getType() == 801) {
                    k kVar = (k) dVar;
                    if (b(kVar.xOr, kVar.yvK, kVar.HgX, false)) {
                        this.Svg.n(-1601, null);
                    }
                    AppMethodBeat.o(62742);
                } else {
                    if (dVar.getType() == 802) {
                        m mVar = (m) dVar;
                        if (b(mVar.xOr, mVar.yvK, mVar.HgX, false)) {
                            this.Svg.n(-1602, null);
                        }
                    }
                    AppMethodBeat.o(62742);
                }
            } catch (Exception e2) {
                com.tencent.pb.common.c.b.w("TalkRoomService", "cancelCreateTalkRoom: ", e2);
                AppMethodBeat.o(62742);
            }
        } else {
            if (!(dVar.getType() != 201 || (dVar2 = (com.tencent.wecall.talkroom.a.d) dVar) == null || dVar2.RCH == null)) {
                a.ab abVar = (a.ab) dVar2.RCH;
                com.tencent.pb.common.c.b.w("TalkRoomService", "handleCreateVoiceGroupEnd errCode: ", Integer.valueOf(i3), Integer.valueOf(dVar2.mType), dVar2.SuH);
                boolean z = !dVar2.SwT;
                Map N2 = com.tencent.pb.common.c.a.N(14000, -1001, 14001, -1002, 14002, -1009);
                if (N2.containsKey(Integer.valueOf(i3))) {
                    h.asK(((Integer) N2.get(Integer.valueOf(i3))).intValue());
                }
                if (i3 != 14002) {
                    Sux = null;
                    if (i3 != 0) {
                        if (!com.tencent.pb.common.c.f.nG(this.SuH, dVar2.SuH)) {
                            com.tencent.pb.common.c.b.w("TalkRoomService", "handleCreateVoiceGroupEnd mClientGroupId is not same mClientGroupId: ", this.SuH, " createScene.mClientGroupId: ", dVar2.SuH, " errCode: ", Integer.valueOf(i3));
                            if (z) {
                                this.Spf.c("TOPIC_ASYNC_CREATE_ROOM_DONE", 0, null);
                            }
                        } else {
                            if (i3 != -1) {
                                this.SuY.asO(TbsListener.ErrorCode.ERROR_TBSINSTALLER_ISTBSCORELEGAL_01);
                                this.SuY.ag("create", "resp", String.valueOf(i3), String.valueOf(this.state));
                            }
                            if (this.state != 1) {
                                com.tencent.pb.common.c.b.w("TalkRoomService", "handleCreateVoiceGroupEnd state is error: ", Integer.valueOf(this.state), "  errCode: ", Integer.valueOf(i3), dVar2.SuH);
                                if (z) {
                                    this.Spf.c("TOPIC_ASYNC_CREATE_ROOM_DONE", 0, null);
                                }
                            } else {
                                a(this.xOr, this.yvK, this.HgX, true);
                                if (i3 == 14051) {
                                    this.Svg.n(-900, null);
                                } else if (i3 == 14052) {
                                    this.Svg.n(-1100, null);
                                } else if (i3 == 14053) {
                                    this.Svg.n(-1300, abVar);
                                } else if (i3 == 14504) {
                                    this.Svg.n(-1400, null);
                                } else {
                                    this.Svg.n(-100, null);
                                }
                                if (z) {
                                    this.Spf.c("TOPIC_ASYNC_CREATE_ROOM_DONE", 0, null);
                                }
                            }
                        }
                    } else if (!com.tencent.pb.common.c.f.nG(this.SuH, abVar.RDo)) {
                        com.tencent.pb.common.c.b.w("TalkRoomService", "handleCreateVoiceGroupEnd mClientGroupId is not same mClientGroupId: ", this.SuH, " resp.clientGroupId: ", abVar.RDo, Integer.valueOf(abVar.GXO), Long.valueOf(abVar.GXP));
                        a(abVar.groupId, abVar.GXO, abVar.GXP, 110, false);
                        if (z) {
                            this.Spf.c("TOPIC_ASYNC_CREATE_ROOM_DONE", 0, null);
                        }
                    } else {
                        this.SuY.ag("create", "resp", String.valueOf(i3), String.valueOf(this.state));
                        if (this.state != 1) {
                            h.asK(-1003);
                            com.tencent.pb.common.c.b.w("TalkRoomService", "handleCreateVoiceGroupEnd state != STATE_CREATING_TAKLROOM: ", Integer.valueOf(this.state), abVar.RDo, Integer.valueOf(abVar.GXO), Long.valueOf(abVar.GXP));
                            if (z) {
                                this.Spf.c("TOPIC_ASYNC_CREATE_ROOM_DONE", 0, null);
                            }
                        } else if (abVar.REL == null || abVar.REL.length == 0) {
                            com.tencent.pb.common.c.b.w("TalkRoomService", "handleCreateVoiceGroupEnd resp.addrlist is null,errCode: ", Integer.valueOf(i3), abVar.RDo, Integer.valueOf(abVar.GXO), Long.valueOf(abVar.GXP));
                            h.asK(-1605);
                            this.SuY.Hre = TbsListener.ErrorCode.ERROR_GETSTRINGARRAY_JARFILE;
                            a(abVar.groupId, abVar.GXO, abVar.GXP, 116, true);
                            if (z) {
                                this.Spf.c("TOPIC_ASYNC_CREATE_ROOM_DONE", 0, null);
                            }
                            this.Svg.n(-100, null);
                        } else {
                            a(abVar.RDo, abVar.GXO, abVar.GXP, abVar.groupId, abVar.RDq.RFQ);
                            this.Svk = abVar.groupId;
                            this.RCJ = abVar.RDt;
                            setState(4);
                            a(abVar.REL, abVar.RES, abVar.RET);
                            a(abVar.groupId, abVar.RDo, abVar.RDt, abVar.GXO, abVar.GXP, abVar.RDX, abVar.REM, abVar.RDq, false, true);
                            if (this.Svg != null) {
                                g gVar2 = this.Svg;
                                g.AnonymousClass9 r6 = new Runnable(c.hqY().brn(abVar.groupId)) {
                                    /* class com.tencent.wecall.talkroom.model.g.AnonymousClass9 */
                                    final /* synthetic */ MultiTalkGroup zNr;

                                    {
                                        this.zNr = r2;
                                    }

                                    public final void run() {
                                        AppMethodBeat.i(62589);
                                        synchronized (g.this.callbacks) {
                                            try {
                                                for (a aVar : g.this.callbacks) {
                                                    aVar.p(this.zNr);
                                                }
                                            } finally {
                                                AppMethodBeat.o(62589);
                                            }
                                        }
                                    }
                                };
                                if (Looper.myLooper() == Looper.getMainLooper()) {
                                    r6.run();
                                } else {
                                    gVar2.handler.post(r6);
                                }
                            }
                            byte[] bArr = new byte[abVar.REO.length];
                            for (int i4 = 0; i4 < abVar.REO.length; i4++) {
                                bArr[i4] = (byte) abVar.REO[i4];
                            }
                            int[] iArr = new int[abVar.REY.length];
                            for (int i5 = 0; i5 < abVar.REY.length; i5++) {
                                iArr[i5] = abVar.REY[i5];
                            }
                            com.tencent.pb.common.c.b.w("TalkRoomService", "handleCreateTalkRoomEnd, general policy cnt:", Integer.valueOf(abVar.REY.length));
                            if (abVar.REY.length > talk.zGz) {
                                com.tencent.pb.common.c.b.w("TalkRoomService", " redirect type:", Integer.valueOf(iArr[talk.zGz]), " SimpleRedirect value:", Integer.valueOf(talk.zGz));
                            }
                            a(0, abVar.RDX, abVar.RDY, bArr, (abVar.REN & 2) != 0, abVar.groupId, abVar.GXO, abVar.GXP, abVar.REU, abVar.REW, abVar.REX, iArr, abVar.REa, this.SuP);
                            if (abVar.RER != 0) {
                                com.tencent.pb.common.c.b.i("TalkRoomService", "get helloFreqSeconds:" + abVar.RER);
                                SuD = abVar.RER * 1000;
                            }
                            hrk();
                            N(abVar.groupId, abVar.GXO, abVar.GXP);
                            if (z) {
                                HashMap hashMap = new HashMap();
                                hashMap.put("result", Boolean.TRUE);
                                hashMap.put("shareUrl", new String(abVar.RDq.RFK, Charset.forName(ProtocolPackage.ServerEncoding)));
                                hashMap.put("smsShortUrl", new String(abVar.RDq.RFL, Charset.forName(ProtocolPackage.ServerEncoding)));
                                hashMap.put("groupId", abVar.groupId);
                                this.Spf.c("TOPIC_ASYNC_CREATE_ROOM_DONE", 0, hashMap);
                            }
                            com.tencent.pb.common.c.b.w("TalkRoomService", "handleCreateVoiceGroupEnd", this.xOr, Integer.valueOf(this.yvK), Long.valueOf(this.HgX));
                        }
                    }
                }
            }
            if (!(dVar.getType() != 202 || (eVar = (com.tencent.wecall.talkroom.a.e) dVar) == null || eVar.RCH == null)) {
                a(i3, (a.ac) eVar.RCH, eVar);
            }
            if (!(dVar.getType() != 204 || (bVar = (com.tencent.wecall.talkroom.a.b) dVar) == null || bVar.RCH == null)) {
                a.z zVar = (a.z) bVar.RCH;
                com.tencent.pb.common.c.b.w("TalkRoomService", "handleAddVoiceGroupMemberEnd", this.xOr, Integer.valueOf(this.yvK), Long.valueOf(this.HgX), " errCode: ", Integer.valueOf(i3));
                Map N3 = com.tencent.pb.common.c.a.N(14600, -1301, 14601, -1302, 14602, -1303, 14651, -1309);
                if (N3.containsKey(Integer.valueOf(i3))) {
                    h.asK(((Integer) N3.get(Integer.valueOf(i3))).intValue());
                }
                if (i3 == 0) {
                    Object[] objArr2 = new Object[2];
                    objArr2[0] = "handleAddVoiceGroupMemberEnd  resp.members length: ";
                    objArr2[1] = Integer.valueOf(zVar.REK == null ? 0 : zVar.REK.length);
                    com.tencent.pb.common.c.b.w("TalkRoomService", objArr2);
                    if (!b(zVar.groupId, zVar.GXO, zVar.GXP, false)) {
                        com.tencent.pb.common.c.b.w("TalkRoomService", "handleAddVoiceGroupMemberEnd isCurrentRoom false resp.groupId: ", zVar.groupId, this.xOr, " resp.roomid: ", Integer.valueOf(zVar.GXO), Integer.valueOf(this.yvK));
                        h.asK(-1308);
                    } else {
                        this.SuY.ag("add", "resp", String.valueOf(i3), String.valueOf(this.state));
                    }
                    a(zVar.groupId, null, this.RCJ, zVar.GXO, zVar.GXP, zVar.REK, null, zVar.RDq, true, true);
                } else if (b(bVar.xOr, bVar.yvK, bVar.HgX, false)) {
                    this.SuY.ag("add", "resp", String.valueOf(i3), String.valueOf(this.state));
                    if (i3 == 14651) {
                        com.tencent.pb.common.c.b.e("TalkRoomService", "handleAddVoiceGroupMemberEnd errCode =%d, groupId=%s,roomid=%d,roomkey=%s", 14651, zVar.groupId, Integer.valueOf(zVar.GXO), Long.valueOf(zVar.GXP));
                        this.Svg.n(-301, zVar);
                    } else {
                        this.Svg.n(-300, null);
                    }
                }
            }
            if (!(dVar.getType() != 203 || (fVar = (com.tencent.wecall.talkroom.a.f) dVar) == null || fVar.RCH == null)) {
                com.tencent.pb.common.c.b.d("TalkRoomService", "handleExitVoiceRoomEnd", ((a.ad) fVar.RCH).groupId, this.xOr, Integer.valueOf(this.yvK), Long.valueOf(this.HgX), " errCode: ", Integer.valueOf(i3));
                Map N4 = com.tencent.pb.common.c.a.N(14400, -1201, 14401, -1202, 14402, -1203, 14403, -1204);
                if (N4.containsKey(Integer.valueOf(i3))) {
                    h.asK(((Integer) N4.get(Integer.valueOf(i3))).intValue());
                }
                if (i3 != 0) {
                    com.tencent.pb.common.c.b.w("TalkRoomService", "handleExitVoiceRoomEnd fail errCode is ", Integer.valueOf(i3));
                }
            }
            if (!(dVar.getType() != 205 || (oVar = (o) dVar) == null || oVar.RCH == null)) {
                com.tencent.pb.common.c.b.d("TalkRoomService", "handleHelloEnd", ((a.ao) oVar.RCH).groupId, this.xOr, Integer.valueOf(this.yvK), Long.valueOf(this.HgX), Integer.valueOf(i3), Integer.valueOf(i2));
                hrl();
                int i6 = 0;
                if (i3 == 14800) {
                    i6 = -1401;
                } else if (i3 == 14801) {
                    i6 = -1402;
                }
                if (i6 != 0) {
                    this.SuY.asO(aq.CTRL_INDEX);
                    h.asK(i6);
                }
            }
            if (!(dVar.getType() != 206 || (aVar = (com.tencent.wecall.talkroom.a.a) dVar) == null || aVar.RCH == null)) {
                com.tencent.pb.common.c.b.w("TalkRoomService", "CLTNOT handleAckEnd errCode is ", Integer.valueOf(i3), " groupId: ", aVar.xOr, " roomid: ", Integer.valueOf(aVar.yvK), " roomKey: ", Long.valueOf(aVar.HgX));
                if (i3 == 18950) {
                    if (!b(aVar.xOr, aVar.yvK, aVar.HgX, false)) {
                        h.a(aVar.xOr, aVar.yvK, aVar.HgX, "ack", "resp", String.valueOf(i3), String.valueOf(this.state));
                    }
                    MultiTalkGroup brn = c.hqY().brn(aVar.xOr);
                    com.tencent.pb.common.c.b.w("TalkRoomService", "CLTNOT handleAckEnd onMisscMultiTalk mGroupId:", aVar.xOr, " multiTalkGroup: ", brn);
                    if (brn != null) {
                        this.Svg.a(aVar.SwS, brn);
                    }
                } else {
                    if (i3 == 0) {
                        this.SuE = true;
                    }
                    if (!fGt()) {
                        com.tencent.pb.common.c.b.w("TalkRoomService", "CLTNOT handleAckEnd is working groupId: ", aVar.xOr);
                        this.SuY.reset();
                        Eh(false);
                        this.SuY.ag("ack", "resp", String.valueOf(i3), String.valueOf(this.state));
                        this.GUf = false;
                        this.xOr = aVar.xOr;
                        this.Svk = this.xOr;
                        this.yvK = aVar.yvK;
                        this.HgX = aVar.HgX;
                        this.RCJ = aVar.RCJ;
                        setState(2);
                        this.SuL = System.currentTimeMillis();
                        h hVar3 = this.SuY;
                        com.tencent.pb.common.c.b.d(h.TAG, "beginNotifyTime");
                        hVar3.SwI = System.currentTimeMillis();
                        if (i3 == 18900) {
                            h.asK(-1521);
                        }
                    } else if (com.tencent.pb.common.c.f.equals(aVar.xOr, this.xOr)) {
                        com.tencent.pb.common.c.b.w("TalkRoomService", "CLTNOT handleAckEnd groupid same return ", this.xOr);
                    }
                    e eVar3 = new e();
                    eVar3.groupId = aVar.xOr;
                    eVar3.roomId = aVar.yvK;
                    eVar3.ypH = aVar.HgX;
                    this.Suy.put(aVar.xOr, eVar3);
                    MultiTalkGroup brn2 = c.hqY().brn(aVar.xOr);
                    com.tencent.pb.common.c.b.w("TalkRoomService", "CLTNOT handleAckEnd onInviteMultiTalk mGroupId:", aVar.xOr, " multiTalkGroup: ", brn2);
                    if (brn2 != null) {
                        g gVar3 = this.Svg;
                        g.AnonymousClass3 r62 = new Runnable(brn2) {
                            /* class com.tencent.wecall.talkroom.model.g.AnonymousClass3 */
                            final /* synthetic */ MultiTalkGroup zNr;

                            {
                                this.zNr = r2;
                            }

                            public final void run() {
                                AppMethodBeat.i(62792);
                                synchronized (g.this.callbacks) {
                                    try {
                                        for (a aVar : g.this.callbacks) {
                                            aVar.b(this.zNr);
                                        }
                                    } finally {
                                        AppMethodBeat.o(62792);
                                    }
                                }
                            }
                        };
                        if (Looper.myLooper() == Looper.getMainLooper()) {
                            r62.run();
                        } else {
                            gVar3.handler.post(r62);
                        }
                    } else {
                        a(aVar.xOr, aVar.yvK, aVar.HgX, false, false, false);
                    }
                }
            }
            if (!(dVar.getType() != 207 || (iVar = (i) dVar) == null || iVar.RCH == null)) {
                if (i3 == 18100) {
                    h.asK(-1501);
                }
                com.tencent.pb.common.c.b.w("TalkRoomService", "handleRejectEnd  errCode is ", Integer.valueOf(i3));
            }
            if (!(dVar.getType() != 208 || (cVar = (com.tencent.wecall.talkroom.a.c) dVar) == null || cVar.RCH == null)) {
                if (i3 == 18300) {
                    h.asK(-1531);
                }
                com.tencent.pb.common.c.b.w("TalkRoomService", "handleCancelCreateEnd errCode is ", Integer.valueOf(i3));
            }
            if (!(dVar.getType() != 209 || (gVar = (com.tencent.wecall.talkroom.a.g) dVar) == null || gVar.RCH == null)) {
                a.ae aeVar = (a.ae) gVar.RCH;
                if (i3 == 17900) {
                    h.asK(-1511);
                }
                if (i3 != 0) {
                    this.Svg.hK(gVar.xOr, i3);
                    com.tencent.pb.common.c.b.w("TalkRoomService", "handleNetSceneModifyVoiceGroupEnd fail errCode is ", Integer.valueOf(i3));
                } else {
                    TalkRoom brg = c.hqY().brg(aeVar.groupId);
                    if (brg != null) {
                        com.tencent.pb.common.c.b.w("TalkRoomService", "handleVoiceGroupMemberChange handleModifyVoiceGroupEnd");
                        a(aeVar.groupId, null, brg.hqM(), TalkRoom.hqN(), TalkRoom.fHV(), null, null, aeVar.RDq, true, false);
                    } else {
                        a(aeVar.groupId, null, 0, 0, 0, null, null, aeVar.RDq, true, false);
                    }
                    this.Svg.hK(aeVar.groupId, 0);
                }
            }
            if (dVar.getType() == 210) {
                com.tencent.pb.common.c.b.d("TalkRoomService", "talkHoldonResp", Integer.valueOf(i2), Integer.valueOf(i3));
                if (i3 == 19100) {
                    h.asK(-1541);
                }
            }
            if (dVar.getType() == 211 && (hVar = (com.tencent.wecall.talkroom.a.h) dVar) != null) {
                a(i2, i3, dVar.RCH, hVar);
            }
            if (dVar.getType() == 212) {
                a(i3, (a.al) dVar.RCH);
            }
            if (dVar.getType() == 213) {
                j jVar = (j) dVar;
                com.tencent.pb.common.c.b.w("TalkRoomService", "handleSendMsg errCode: ", Integer.valueOf(i3));
                if (i3 != 0) {
                    if (com.tencent.pb.common.c.f.equals(jVar.xOr, this.xOr)) {
                        this.SuY.ag("sendmsg", "resp", String.valueOf(i3), String.valueOf(this.state));
                        this.Svg.n(-700, null);
                    }
                } else if (com.tencent.pb.common.c.f.equals(jVar.xOr, this.xOr)) {
                    this.SuY.ag("sendmsg", "resp", String.valueOf(i3), String.valueOf(this.state));
                    g gVar4 = this.Svg;
                    g.AnonymousClass24 r5 = new Runnable() {
                        /* class com.tencent.wecall.talkroom.model.g.AnonymousClass24 */

                        public final void run() {
                            AppMethodBeat.i(62602);
                            synchronized (g.this.callbacks) {
                                try {
                                    for (a aVar : g.this.callbacks) {
                                        aVar.hre();
                                    }
                                } finally {
                                    AppMethodBeat.o(62602);
                                }
                            }
                        }
                    };
                    if (Looper.myLooper() == Looper.getMainLooper()) {
                        r5.run();
                    } else {
                        gVar4.handler.post(r5);
                    }
                }
            }
            if (dVar.getType() == 214) {
                a.aj ajVar = (a.aj) dVar.RCH;
                n nVar2 = (n) dVar;
                com.tencent.pb.common.c.b.w("TalkRoomService", "handleSwitchVideoGroup errCode: ", Integer.valueOf(i3));
                if (!b(nVar2.xOr, nVar2.yvK, nVar2.HgX, false)) {
                    com.tencent.pb.common.c.b.w("TalkRoomService", "handleSwitchVideoGroup isCurrentRoom is not same", nVar2.xOr, Integer.valueOf(nVar2.yvK));
                } else {
                    if (this.SuZ != null) {
                        int[] iArr2 = {ajVar.LGa, ajVar.RFa, ajVar.RFb, ajVar.RFc, ajVar.RFd, ajVar.RFe};
                        com.tencent.pb.common.c.b.d("TalkRoomService", "setMVSvrCfg:small:br:,WH:,FPS:,big:br:,WH:,Fps:", Integer.valueOf(iArr2[0]), Integer.valueOf(iArr2[1]), Integer.valueOf(iArr2[2]), Integer.valueOf(iArr2[3]), Integer.valueOf(iArr2[4]), Integer.valueOf(iArr2[5]));
                        b bVar3 = this.SuZ;
                        if (bVar3.Suj == null) {
                            com.tencent.pb.common.c.b.w("simon:TalkRoomContext", "steve:setMVSvrCfg null, pMVSvrCfg:", iArr2, ", engine:", bVar3.Suj);
                        } else {
                            bVar3.Suj.setMVSvrCfg(iArr2, 6);
                        }
                    }
                    if (ajVar.RFh == 0) {
                        if (i3 == 0) {
                            g gVar5 = this.Svg;
                            g.AnonymousClass18 r63 = new Runnable(ajVar.LGa) {
                                /* class com.tencent.wecall.talkroom.model.g.AnonymousClass18 */
                                final /* synthetic */ int Swp;

                                {
                                    this.Swp = r2;
                                }

                                public final void run() {
                                    AppMethodBeat.i(62586);
                                    synchronized (g.this.callbacks) {
                                        try {
                                            for (a aVar : g.this.callbacks) {
                                                aVar.asH(this.Swp);
                                            }
                                        } finally {
                                            AppMethodBeat.o(62586);
                                        }
                                    }
                                }
                            };
                            if (Looper.myLooper() == Looper.getMainLooper()) {
                                r63.run();
                            } else {
                                gVar5.handler.post(r63);
                            }
                        } else if (i3 == 24301) {
                            this.Svg.n(-1700, Integer.valueOf(ajVar.RFg));
                        } else {
                            this.Svg.n(-800, null);
                        }
                    } else if (ajVar.RFh == 1) {
                        g gVar6 = this.Svg;
                        g.AnonymousClass19 r52 = new Runnable(i3) {
                            /* class com.tencent.wecall.talkroom.model.g.AnonymousClass19 */
                            final /* synthetic */ int Swq;

                            {
                                this.Swq = r2;
                            }

                            public final void run() {
                                AppMethodBeat.i(62556);
                                synchronized (g.this.callbacks) {
                                    try {
                                        for (a aVar : g.this.callbacks) {
                                            aVar.Rd(this.Swq);
                                        }
                                    } finally {
                                        AppMethodBeat.o(62556);
                                    }
                                }
                            }
                        };
                        if (Looper.myLooper() == Looper.getMainLooper()) {
                            r52.run();
                        } else {
                            gVar6.handler.post(r52);
                        }
                    }
                }
            }
            if (dVar.getType() == 800) {
                l lVar2 = (l) dVar;
                com.tencent.pb.common.c.b.w("TalkRoomService", "handleSubscribeLargeVideo errCode: ", Integer.valueOf(i3));
                if (!b(lVar2.xOr, lVar2.yvK, lVar2.HgX, false)) {
                    com.tencent.pb.common.c.b.w("TalkRoomService", "handleSubscribeLargeVideo isCurrentRoom is not same", lVar2.xOr, Integer.valueOf(lVar2.yvK));
                } else if (i3 == 0) {
                    g gVar7 = this.Svg;
                    g.AnonymousClass20 r53 = new Runnable() {
                        /* class com.tencent.wecall.talkroom.model.g.AnonymousClass20 */

                        public final void run() {
                            AppMethodBeat.i(62590);
                            synchronized (g.this.callbacks) {
                                try {
                                    for (a aVar : g.this.callbacks) {
                                        aVar.enG();
                                    }
                                } finally {
                                    AppMethodBeat.o(62590);
                                }
                            }
                        }
                    };
                    if (Looper.myLooper() == Looper.getMainLooper()) {
                        r53.run();
                    } else {
                        gVar7.handler.post(r53);
                    }
                } else {
                    this.Svg.n(-1600, null);
                }
            }
            if (dVar.getType() == 801) {
                k kVar2 = (k) dVar;
                com.tencent.pb.common.c.b.w("TalkRoomService", "handleSubscribeGeneralVideo errCode: ", Integer.valueOf(i3));
                if (!b(kVar2.xOr, kVar2.yvK, kVar2.HgX, false)) {
                    com.tencent.pb.common.c.b.w("TalkRoomService", "handleSubscribeGeneralVideo isCurrentRoom is not same", kVar2.xOr, Integer.valueOf(kVar2.yvK));
                } else if (i3 == 0) {
                    g gVar8 = this.Svg;
                    g.AnonymousClass21 r54 = new Runnable() {
                        /* class com.tencent.wecall.talkroom.model.g.AnonymousClass21 */

                        public final void run() {
                            AppMethodBeat.i(62554);
                            synchronized (g.this.callbacks) {
                                try {
                                    for (a aVar : g.this.callbacks) {
                                        aVar.enH();
                                    }
                                } finally {
                                    AppMethodBeat.o(62554);
                                }
                            }
                        }
                    };
                    if (Looper.myLooper() == Looper.getMainLooper()) {
                        r54.run();
                    } else {
                        gVar8.handler.post(r54);
                    }
                } else {
                    this.Svg.n(-1601, null);
                }
            }
            if (dVar.getType() == 802) {
                m mVar2 = (m) dVar;
                com.tencent.pb.common.c.b.w("TalkRoomService", "handleSubscribeScreenSharingVideo errCode: ", Integer.valueOf(i3));
                if (!b(mVar2.xOr, mVar2.yvK, mVar2.HgX, false)) {
                    com.tencent.pb.common.c.b.w("TalkRoomService", "handleSubscribeScreenSharingVideo isCurrentRoom is not same", mVar2.xOr, Integer.valueOf(mVar2.yvK));
                    AppMethodBeat.o(62742);
                    return;
                } else if (i3 == 0) {
                    g gVar9 = this.Svg;
                    g.AnonymousClass22 r55 = new Runnable() {
                        /* class com.tencent.wecall.talkroom.model.g.AnonymousClass22 */

                        public final void run() {
                            AppMethodBeat.i(62591);
                            synchronized (g.this.callbacks) {
                                try {
                                    for (a aVar : g.this.callbacks) {
                                        aVar.enI();
                                    }
                                } finally {
                                    AppMethodBeat.o(62591);
                                }
                            }
                        }
                    };
                    if (Looper.myLooper() == Looper.getMainLooper()) {
                        r55.run();
                        AppMethodBeat.o(62742);
                        return;
                    }
                    gVar9.handler.post(r55);
                    AppMethodBeat.o(62742);
                    return;
                } else {
                    this.Svg.n(-1602, null);
                }
            }
            AppMethodBeat.o(62742);
        }
    }

    public final int c(byte[] bArr, int i2, int i3, int i4, int i5, int i6) {
        int i7;
        AppMethodBeat.i(199684);
        int i8 = -1;
        if (this.yIP && this.SuZ != null) {
            try {
                com.tencent.pb.common.c.b.d("TalkRoomService", "sendVideo ", Integer.valueOf(i3), Integer.valueOf(i4));
                b bVar = this.SuZ;
                if (bArr == null || bVar.Suj == null) {
                    com.tencent.pb.common.c.b.w("simon:TalkRoomContext", "steve:sendVideo null, buffer:", bArr, ", engine:", bVar.Suj);
                    i7 = -1;
                    com.tencent.pb.common.c.b.d("TalkRoomService", "sendVideo finished, ", Boolean.valueOf(this.yIP), " ret: ", Integer.valueOf(i7), " engine: ", this.SuZ);
                    i8 = i7;
                } else {
                    i7 = bVar.Suj.SendVideo(bArr, i2, i3, i4, i5, i6);
                    com.tencent.pb.common.c.b.d("TalkRoomService", "sendVideo finished, ", Boolean.valueOf(this.yIP), " ret: ", Integer.valueOf(i7), " engine: ", this.SuZ);
                    i8 = i7;
                }
            } catch (Exception e2) {
                com.tencent.pb.common.c.b.w("TalkRoomService", "sendVideo error: ", e2);
                i7 = -1;
            }
        }
        AppMethodBeat.o(199684);
        return i8;
    }

    public final int d(byte[] bArr, int i2, int i3, int i4, int i5) {
        int i6;
        AppMethodBeat.i(199685);
        int i7 = -1;
        if (this.yIP && this.SuZ != null) {
            try {
                com.tencent.pb.common.c.b.d("TalkRoomService", "sendScreen ", Integer.valueOf(i3), Integer.valueOf(i4));
                b bVar = this.SuZ;
                if (bArr == null || bVar.Suj == null) {
                    com.tencent.pb.common.c.b.w("simon:TalkRoomContext", "steve:sendScreen null, buffer:", bArr, ", engine:", bVar.Suj);
                    i6 = -1;
                    com.tencent.pb.common.c.b.d("TalkRoomService", "sendScreen finished, ", Boolean.valueOf(this.yIP), " ret: ", Integer.valueOf(i6), " engine: ", this.SuZ);
                    i7 = i6;
                } else {
                    i6 = bVar.Suj.SendScreen(bArr, i2, i3, i4, i5);
                    com.tencent.pb.common.c.b.d("TalkRoomService", "sendScreen finished, ", Boolean.valueOf(this.yIP), " ret: ", Integer.valueOf(i6), " engine: ", this.SuZ);
                    i7 = i6;
                }
            } catch (Exception e2) {
                com.tencent.pb.common.c.b.w("TalkRoomService", "sendScreen error: ", e2);
                i6 = -1;
            }
        }
        AppMethodBeat.o(199685);
        return i7;
    }

    public final com.tencent.pb.talkroom.sdk.g b(byte[] bArr, int i2, int i3, int i4, int i5, int[] iArr) {
        com.tencent.pb.talkroom.sdk.g gVar;
        AppMethodBeat.i(62744);
        com.tencent.pb.talkroom.sdk.g gVar2 = new com.tencent.pb.talkroom.sdk.g();
        if (this.yIP && this.SuZ != null) {
            try {
                com.tencent.pb.common.c.b.d("TalkRoomService", "videoTrans ", Integer.valueOf(i3), Integer.valueOf(i4));
                b bVar = this.SuZ;
                if (bArr == null || bVar.Suj == null) {
                    com.tencent.pb.common.c.b.w("simon:TalkRoomContext", "steve:videoTrans null, recordData:", bArr, ", engine:", bVar.Suj);
                    gVar = null;
                    com.tencent.pb.common.c.b.d("TalkRoomService", "videoTrans finished, ", Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Boolean.valueOf(this.yIP), " multiTalkVideoRGBinfo: ", gVar, " engine: ", this.SuZ);
                    AppMethodBeat.o(62744);
                    return gVar;
                }
                int videoTrans = bVar.Suj.videoTrans(bArr, i2, i3, i4, i5, iArr);
                gVar = new com.tencent.pb.talkroom.sdk.g();
                gVar.zKJ = iArr;
                gVar.zKK = bVar.Suj.field_localImgWidth;
                gVar.zKL = bVar.Suj.field_localImgHeight;
                gVar.ret = videoTrans;
                com.tencent.pb.common.c.b.d("TalkRoomService", "videoTrans finished, ", Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Boolean.valueOf(this.yIP), " multiTalkVideoRGBinfo: ", gVar, " engine: ", this.SuZ);
                AppMethodBeat.o(62744);
                return gVar;
            } catch (Exception e2) {
                com.tencent.pb.common.c.b.w("TalkRoomService", "videoTrans error: ", e2);
            }
        }
        gVar = gVar2;
        com.tencent.pb.common.c.b.d("TalkRoomService", "videoTrans finished, ", Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Boolean.valueOf(this.yIP), " multiTalkVideoRGBinfo: ", gVar, " engine: ", this.SuZ);
        AppMethodBeat.o(62744);
        return gVar;
    }

    public final int screenTrans(byte[] bArr, int i2, int i3, int i4, byte[] bArr2, int i5, int i6, int i7) {
        int i8;
        AppMethodBeat.i(199686);
        if (this.yIP && this.SuZ != null) {
            try {
                com.tencent.pb.common.c.b.d("TalkRoomService", "sendScreen ", Integer.valueOf(i2), Integer.valueOf(i3));
                b bVar = this.SuZ;
                if (bArr == null || bVar.Suj == null) {
                    com.tencent.pb.common.c.b.w("simon:TalkRoomContext", "steve:screenTrans null, buf:", bArr, ", engine:", bVar.Suj);
                    i8 = -1;
                    com.tencent.pb.common.c.b.d("TalkRoomService", "screenTrans finished, ", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Boolean.valueOf(this.yIP), " engine: ", this.SuZ);
                    AppMethodBeat.o(199686);
                    return i8;
                }
                i8 = bVar.Suj.screenTrans(bArr, i2, i3, i4, bArr2, i5, i6, i7);
                com.tencent.pb.common.c.b.d("TalkRoomService", "screenTrans finished, ", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Boolean.valueOf(this.yIP), " engine: ", this.SuZ);
                AppMethodBeat.o(199686);
                return i8;
            } catch (Exception e2) {
                com.tencent.pb.common.c.b.w("TalkRoomService", "videoTrans error: ", e2);
            }
        }
        i8 = 0;
        com.tencent.pb.common.c.b.d("TalkRoomService", "screenTrans finished, ", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Boolean.valueOf(this.yIP), " engine: ", this.SuZ);
        AppMethodBeat.o(199686);
        return i8;
    }

    public final com.tencent.pb.talkroom.sdk.f R(int[] iArr) {
        com.tencent.pb.talkroom.sdk.f fVar;
        int length;
        AppMethodBeat.i(62745);
        com.tencent.pb.talkroom.sdk.f fVar2 = new com.tencent.pb.talkroom.sdk.f();
        if (this.yIP && this.SuZ != null) {
            try {
                com.tencent.pb.common.c.b.d("TalkRoomService", "receiveVideo");
                b bVar = this.SuZ;
                fVar = new com.tencent.pb.talkroom.sdk.f();
                if (iArr == null || bVar.Suj == null) {
                    com.tencent.pb.common.c.b.w("simon:TalkRoomContext", "steve:receiveVideo null, imgBuffer:", iArr, ", engine:", bVar.Suj);
                    com.tencent.pb.common.c.b.d("TalkRoomService", "receiveVideo finished, ", Boolean.valueOf(this.yIP), " decInfo: ", fVar, " engine: ", this.SuZ);
                    fVar2 = fVar;
                } else {
                    fVar.ret = bVar.Suj.videoDecode(iArr);
                    fVar.RHd = iArr;
                    fVar.RHe = bVar.Suj.field_remoteImgLength;
                    fVar.RHf = bVar.Suj.field_remoteImgWidth;
                    fVar.RHg = bVar.Suj.field_remoteImgHeight;
                    fVar.RHh = bVar.Suj.field_remoteImgChannel & 16383;
                    fVar.RHi = 0;
                    fVar.RHb = c.hqY().hJ(a.hqJ().xOr, fVar.RHh);
                    Object[] objArr = new Object[4];
                    objArr[0] = "steve:receiveVideo imgBuffer size:";
                    if (iArr == null) {
                        length = 0;
                    } else {
                        length = iArr.length;
                    }
                    objArr[1] = Integer.valueOf(length);
                    objArr[2] = " MultiTalkVideoDecodeInfo: ";
                    objArr[3] = fVar;
                    com.tencent.pb.common.c.b.d("simon:TalkRoomContext", objArr);
                    com.tencent.pb.common.c.b.d("TalkRoomService", "receiveVideo finished, ", Boolean.valueOf(this.yIP), " decInfo: ", fVar, " engine: ", this.SuZ);
                    fVar2 = fVar;
                }
            } catch (Exception e2) {
                com.tencent.pb.common.c.b.w("TalkRoomService", "receiveVideo error: ", e2);
                fVar = fVar2;
            }
        }
        AppMethodBeat.o(62745);
        return fVar2;
    }

    public final com.tencent.pb.talkroom.sdk.f a(byte[] bArr, int[] iArr, int i2) {
        com.tencent.pb.talkroom.sdk.f fVar;
        int length;
        AppMethodBeat.i(199687);
        com.tencent.pb.talkroom.sdk.f fVar2 = new com.tencent.pb.talkroom.sdk.f();
        if (this.yIP && this.SuZ != null) {
            try {
                com.tencent.pb.common.c.b.d("TalkRoomService", "receiveScreen");
                b bVar = this.SuZ;
                fVar = new com.tencent.pb.talkroom.sdk.f();
                if (bArr == null || iArr == null || bVar.Suj == null) {
                    com.tencent.pb.common.c.b.w("simon:TalkRoomContext", "steve:receiveScreen null, imgBuffer32:", iArr, ", engine:", bVar.Suj);
                    com.tencent.pb.common.c.b.d("TalkRoomService", "receiveScreen finished, ", Boolean.valueOf(this.yIP), " decInfo: ", fVar, " engine: ", this.SuZ);
                    fVar2 = fVar;
                } else {
                    fVar.ret = bVar.Suj.screenDecode(bArr, iArr, i2);
                    fVar.RHj = bArr;
                    fVar.RHd = iArr;
                    fVar.RHe = bVar.Suj.field_remoteImgLength_screen;
                    fVar.RHf = bVar.Suj.field_remoteImgWidth_screen;
                    fVar.RHg = bVar.Suj.field_remoteImgHeight_screen;
                    fVar.RHh = bVar.Suj.field_remoteImgChannel_screen & 16383;
                    fVar.RHi = bVar.Suj.field_remoteImgOrien_screen;
                    com.tencent.pb.common.c.b.d("simon:TalkRoomContext", "weiranli: receiveScreen channel:", Integer.valueOf(bVar.Suj.field_remoteImgChannel_screen));
                    com.tencent.pb.common.c.b.d("simon:TalkRoomContext", "weiranli: receiveScreen field_remoteImgOrien:", Integer.valueOf(bVar.Suj.field_remoteImgOrien_screen));
                    fVar.RHb = c.hqY().hJ(a.hqJ().xOr, fVar.RHh);
                    Object[] objArr = new Object[4];
                    objArr[0] = "steve:receiveScreen imgBuffer32 size:";
                    if (iArr == null) {
                        length = 0;
                    } else {
                        length = iArr.length;
                    }
                    objArr[1] = Integer.valueOf(length);
                    objArr[2] = " MultiTalkVideoDecodeInfo: ";
                    objArr[3] = fVar;
                    com.tencent.pb.common.c.b.d("simon:TalkRoomContext", objArr);
                    com.tencent.pb.common.c.b.d("TalkRoomService", "receiveScreen finished, ", Boolean.valueOf(this.yIP), " decInfo: ", fVar, " engine: ", this.SuZ);
                    fVar2 = fVar;
                }
            } catch (Exception e2) {
                com.tencent.pb.common.c.b.w("TalkRoomService", "receiveScreen error: ", e2);
                fVar = fVar2;
            }
        }
        AppMethodBeat.o(199687);
        return fVar2;
    }

    private void a(int i2, a.al alVar) {
        AppMethodBeat.i(199688);
        com.tencent.pb.common.c.b.w("TalkRoomService", "handleGetGroupInfoBatch errCode: ", Integer.valueOf(i2));
        if (i2 != 0) {
            this.Svg.ki(null);
            AppMethodBeat.o(199688);
            return;
        }
        a.ba[] baVarArr = alVar.RFi;
        if (baVarArr == null || baVarArr.length == 0) {
            com.tencent.pb.common.c.b.w("TalkRoomService", "handleGetGroupInfoBatch resp.groupInfoList is null");
            AppMethodBeat.o(199688);
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (a.ba baVar : baVarArr) {
            if (baVar != null) {
                a(baVar.groupId, null, 0, baVar.GXO, baVar.GXP, baVar.REK, null, null, false, false);
                arrayList.add(c.hqY().brn(baVar.groupId));
            }
        }
        com.tencent.pb.common.c.b.w("TalkRoomService", "handleGetGroupInfoBatch multiTalkGrouplist size: ", Integer.valueOf(arrayList.size()));
        this.Svg.ki(arrayList);
        AppMethodBeat.o(199688);
    }

    private void a(int i2, int i3, Object obj, com.tencent.wecall.talkroom.a.h hVar) {
        AppMethodBeat.i(62747);
        com.tencent.pb.common.c.b.d("TalkRoomService", "handleRedirectResp", Integer.valueOf(i2), Integer.valueOf(i3));
        if (i3 != 0 || obj == null) {
            com.tencent.pb.common.c.b.e("TalkRoomService", "handleRedirectResp err", Integer.valueOf(i2), Integer.valueOf(i3));
            if (b(hVar.groupId, hVar.roomId, hVar.ypH, false)) {
                this.SuY.ag("redirect", "resp", "-1", String.valueOf(this.state));
            }
            AppMethodBeat.o(62747);
            return;
        }
        a.an anVar = (a.an) obj;
        if (!b(anVar.groupId, anVar.GXO, anVar.GXP, false)) {
            com.tencent.pb.common.c.b.e("TalkRoomService", "handleRedirectResp roomid error", Integer.valueOf(anVar.GXO), Integer.valueOf(this.yvK));
            AppMethodBeat.o(62747);
            return;
        }
        this.SuY.ag("redirect", "resp", String.valueOf(i3), String.valueOf(this.state));
        a(anVar.groupId, null, this.RCJ, anVar.GXO, anVar.GXP, anVar.REK, anVar.REM, anVar.RDq, false, false);
        a(anVar.REL, anVar.RES, anVar.RET);
        com.tencent.pb.common.c.b.d("TalkRoomService", "handleRedirectResp redirect type:", Integer.valueOf(this.SuO));
        if (this.SuO == 0) {
            byte[] bArr = new byte[anVar.REO.length];
            for (int i4 = 0; i4 < anVar.REO.length; i4++) {
                bArr[i4] = (byte) anVar.REO[i4];
            }
            int[] iArr = new int[anVar.REY.length];
            for (int i5 = 0; i5 < anVar.REY.length; i5++) {
                iArr[i5] = anVar.REY[i5];
            }
            if (this.SuZ != null) {
                com.tencent.pb.common.c.b.d("TalkRoomService", "handleRedirectResp redirect engine close ret:", Integer.valueOf(this.SuZ.Close()));
                a(0, anVar.REK, anVar.RDY, bArr, (anVar.REN & 2) != 0, anVar.groupId, anVar.GXO, anVar.GXP, anVar.REU, anVar.REW, anVar.REX, iArr, anVar.REa, this.SuP);
                AppMethodBeat.o(62747);
                return;
            }
            com.tencent.pb.common.c.b.d("TalkRoomService", "handleRedirectResp engine close but nullptr");
            AppMethodBeat.o(62747);
            return;
        }
        int lx = k.lx(com.tencent.pb.common.c.c.Hhs);
        com.tencent.pb.common.c.b.i("TalkRoomService", "amyfwang,Redirect::netType:", Integer.valueOf(lx));
        b bVar = this.SuZ;
        String[] strArr = this.Svq;
        short[] sArr = this.Svp;
        String[] strArr2 = this.Svs;
        short[] sArr2 = this.Svr;
        if (bVar.Suj != null) {
            bVar.Suj.Redirect(strArr, sArr, strArr2, sArr2, lx);
        }
        AppMethodBeat.o(62747);
    }

    private void a(int i2, a.ac acVar, com.tencent.wecall.talkroom.a.e eVar) {
        AppMethodBeat.i(199689);
        com.tencent.pb.common.c.b.d("TalkRoomService", "handleEnterTalkRoomEnd", eVar.xOr, Integer.valueOf(eVar.yvK), Long.valueOf(eVar.HgX), " errCode: ", Integer.valueOf(i2), " state: ", Integer.valueOf(this.state));
        Map N = com.tencent.pb.common.c.a.N(14200, -1101, 14201, -1102, 14202, -1103, 14203, -1104, 14204, -1105, 14205, -1111, 14287, -1112);
        if (N.containsKey(Integer.valueOf(i2))) {
            h.asK(((Integer) N.get(Integer.valueOf(i2))).intValue());
        }
        if (i2 == 14255) {
            com.tencent.pb.common.c.b.e("TalkRoomService", "handleEnterTalkRoomEnd errCode =%d, groupId=%s,roomid=%d,roomkey=%s", 14255, acVar.groupId, Integer.valueOf(acVar.GXO), Long.valueOf(acVar.GXP));
            this.Svg.n(-14255, acVar);
            AppMethodBeat.o(199689);
        } else if (i2 == 14287) {
            com.tencent.pb.common.c.b.e("TalkRoomService", "handleEnterTalkRoomEnd errCode =%d, groupId=%s,roomid=%d,roomkey=%s", 14287, acVar.groupId, Integer.valueOf(acVar.GXO), Long.valueOf(acVar.GXP));
            this.Svg.n(-14287, acVar);
            AppMethodBeat.o(199689);
        } else if (i2 == 14256) {
            com.tencent.pb.common.c.b.e("TalkRoomService", "handleEnterTalkRoomEnd errCode =%d, groupId=%s,roomid=%d,roomkey=%s", 14256, acVar.groupId, Integer.valueOf(acVar.GXO), Long.valueOf(acVar.GXP));
            this.Svg.n(-14256, acVar);
            AppMethodBeat.o(199689);
        } else if (i2 == 0 || i2 == 14204) {
            if (i2 == 14204 && this.state == 4) {
                com.tencent.pb.common.c.b.w("TalkRoomService", "handleEnterTalkRoomEnd errCode == EmRetCode.E_Talk_Enter_AlreadyEnter", acVar.groupId, Integer.valueOf(acVar.GXO), Long.valueOf(acVar.GXP));
                AppMethodBeat.o(199689);
            } else if (!b(acVar.groupId, acVar.GXO, acVar.GXP, asI(acVar.vkj))) {
                com.tencent.pb.common.c.b.w("TalkRoomService", "handleEnterTalkRoomEnd isCurrentRoom is false,state: ", Integer.valueOf(this.state), " resp.groupId锟斤拷", acVar.groupId, " mGroupId: ", this.xOr, Integer.valueOf(acVar.GXO), Integer.valueOf(this.yvK), Long.valueOf(acVar.GXP), Long.valueOf(this.HgX));
                a(acVar.groupId, acVar.GXO, acVar.GXP, 111, false);
                h.asK(-1110);
                AppMethodBeat.o(199689);
            } else if (this.state != 3) {
                com.tencent.pb.common.c.b.w("TalkRoomService", "handleEnterTalkRoomEnd state is error: ", Integer.valueOf(this.state), acVar.groupId, Integer.valueOf(acVar.GXO), Long.valueOf(acVar.GXP));
                AppMethodBeat.o(199689);
            } else {
                this.SuY.ag("enter", "resp", String.valueOf(i2), String.valueOf(this.state));
                if (acVar.REL == null || acVar.REL.length == 0) {
                    com.tencent.pb.common.c.b.w("TalkRoomService", "handleEnterTalkRoomEnd resp.addrlist is null,errCode: ", Integer.valueOf(i2), acVar.groupId, Integer.valueOf(acVar.GXO), Long.valueOf(acVar.GXP));
                    h.asK(-1605);
                    this.SuY.Hre = TbsListener.ErrorCode.ERROR_GETSTRINGARRAY_JARFILE;
                    a(acVar.groupId, acVar.GXO, acVar.GXP, 116, true);
                    this.Svg.n(-200, null);
                    AppMethodBeat.o(199689);
                    return;
                }
                this.xOr = acVar.groupId;
                this.Svk = acVar.groupId;
                this.yvK = acVar.GXO;
                this.HgX = acVar.GXP;
                setState(4);
                a(acVar.REL, acVar.RES, acVar.RET);
                a(acVar.groupId, null, this.RCJ, acVar.GXO, acVar.GXP, acVar.REK, acVar.REM, acVar.RDq, false, true);
                g gVar = this.Svg;
                g.AnonymousClass10 r4 = new Runnable(c.hqY().brn(acVar.groupId)) {
                    /* class com.tencent.wecall.talkroom.model.g.AnonymousClass10 */
                    final /* synthetic */ MultiTalkGroup zNr;

                    {
                        this.zNr = r2;
                    }

                    public final void run() {
                        AppMethodBeat.i(62555);
                        synchronized (g.this.callbacks) {
                            try {
                                for (a aVar : g.this.callbacks) {
                                    aVar.q(this.zNr);
                                }
                            } finally {
                                AppMethodBeat.o(62555);
                            }
                        }
                    }
                };
                if (Looper.myLooper() == Looper.getMainLooper()) {
                    r4.run();
                } else {
                    gVar.handler.post(r4);
                }
                byte[] bArr = new byte[acVar.REO.length];
                for (int i3 = 0; i3 < acVar.REO.length; i3++) {
                    bArr[i3] = (byte) acVar.REO[i3];
                }
                int[] iArr = new int[acVar.REY.length];
                for (int i4 = 0; i4 < acVar.REY.length; i4++) {
                    iArr[i4] = acVar.REY[i4];
                }
                com.tencent.pb.common.c.b.w("TalkRoomService", "handleEnterTalkRoomEnd, general policy cnt:", Integer.valueOf(acVar.REY.length), " redirect type:", Integer.valueOf(iArr[talk.zGz]), " SimpleRedirect value:", Integer.valueOf(talk.zGz));
                a(0, acVar.REK, acVar.RDY, bArr, (acVar.REN & 2) != 0, acVar.groupId, acVar.GXO, acVar.GXP, acVar.REU, acVar.REW, acVar.REX, iArr, acVar.REa, this.SuP);
                if (acVar.RER != 0) {
                    com.tencent.pb.common.c.b.i("TalkRoomService", "get helloFreqSeconds:" + acVar.RER);
                    SuD = acVar.RER * 1000;
                }
                hrk();
                com.tencent.pb.common.c.b.w("TalkRoomService", "handleVoiceGroupMemberChange handleEnterTalkRoomEnd", this.xOr, Integer.valueOf(this.yvK), Long.valueOf(this.HgX));
                AppMethodBeat.o(199689);
            }
        } else if (!b(eVar.xOr, eVar.yvK, eVar.HgX, asI(eVar.SwU))) {
            com.tencent.pb.common.c.b.w("TalkRoomService", "handleEnterTalkRoomEnd isCurrentRoom is false errCode:", Integer.valueOf(i2), " enterScene.mGroupId: ", eVar.xOr, " mGroupId: ", this.xOr, Integer.valueOf(eVar.yvK), Integer.valueOf(this.yvK), Long.valueOf(eVar.HgX), Long.valueOf(this.HgX));
            AppMethodBeat.o(199689);
        } else if (3 != this.state) {
            com.tencent.pb.common.c.b.w("TalkRoomService", "handleEnterTalkRoomEnd state is error: ", Integer.valueOf(this.state), " errCode: ", Integer.valueOf(i2), eVar.xOr, Integer.valueOf(eVar.yvK), Long.valueOf(eVar.HgX));
            AppMethodBeat.o(199689);
        } else {
            this.SuY.ag("enter", "resp", String.valueOf(i2), String.valueOf(this.state));
            this.SuY.asO(TbsListener.ErrorCode.ERROR_TBSINSTALLER_ISTBSCORELEGAL_02);
            com.tencent.pb.common.c.b.w("TalkRoomService", "exitTalkRoom handleEnterTalkRoomEnd fail errCode: ", Integer.valueOf(i2), eVar.xOr, Integer.valueOf(eVar.yvK), Long.valueOf(eVar.HgX));
            a(eVar.xOr, eVar.yvK, eVar.HgX, true);
            if (i2 == 14251) {
                this.Svg.n(-1000, null);
                AppMethodBeat.o(199689);
            } else if (i2 == 14252) {
                this.Svg.n(-1200, null);
                AppMethodBeat.o(199689);
            } else if (i2 == 14253) {
                int i5 = 60;
                if (acVar != null) {
                    i5 = Integer.valueOf(acVar.REQ);
                }
                this.Svg.n(-1500, i5);
                AppMethodBeat.o(199689);
            } else {
                this.Svg.n(-200, null);
                AppMethodBeat.o(199689);
            }
        }
    }

    private void a(String str, String str2, int i2, int i3, long j2, a.bb[] bbVarArr, a.bc[] bcVarArr, a.az azVar, boolean z, boolean z2) {
        Integer valueOf;
        AppMethodBeat.i(199690);
        a(str, i3, j2, bbVarArr);
        c hqY = c.hqY();
        if (i2 == 0) {
            valueOf = null;
        } else {
            valueOf = Integer.valueOf(i2);
        }
        boolean a2 = hqY.a(str, str2, valueOf, i3, j2, azVar, bbVarArr, bcVarArr, z, this.xOr != null && this.xOr.equals(str));
        Object[] objArr = new Object[16];
        objArr[0] = "engine handleVoiceGroupMemberChange";
        objArr[1] = str;
        objArr[2] = this.xOr;
        objArr[3] = Integer.valueOf(i3);
        objArr[4] = Integer.valueOf(this.yvK);
        objArr[5] = Long.valueOf(j2);
        objArr[6] = Long.valueOf(this.HgX);
        objArr[7] = Boolean.valueOf(a2);
        objArr[8] = " isCurrentRoom: ";
        objArr[9] = Boolean.valueOf(b(str, i3, j2, false));
        objArr[10] = " members.length: ";
        objArr[11] = Integer.valueOf(bbVarArr != null ? bbVarArr.length : 0);
        objArr[12] = " isCallBackEngine: ";
        objArr[13] = Boolean.valueOf(z2);
        objArr[14] = " mFirstGetAudioData: ";
        objArr[15] = Boolean.valueOf(this.SuM);
        com.tencent.pb.common.c.b.d("TalkRoomService", objArr);
        if (c.hqY().dG(this.xOr, false)) {
            com.tencent.pb.common.c.b.w("TalkRoomService", "handleVoiceGroupMemberChange isGroupActive mFirstGetAudioData: ", Boolean.valueOf(this.SuM), " mGroupId: ", this.xOr, " roomId: ", Integer.valueOf(i3));
            if (this.SuM) {
                this.SuM = false;
                this.yIP = true;
                this.Svi = k.hrC();
                this.SuK = this.SuI;
                hrp();
            }
        }
        if (bbVarArr == null) {
            AppMethodBeat.o(199690);
            return;
        }
        if (z2 && b(str, i3, j2, false) && bbVarArr.length > 0 && this.SuZ != null) {
            a(bbVarArr);
        }
        AppMethodBeat.o(199690);
    }

    private void a(a.bb[] bbVarArr) {
        AppMethodBeat.i(199691);
        if (bbVarArr == null) {
            com.tencent.pb.common.c.b.w("TalkRoomService", "onMebersChangedToEngine members is null");
            AppMethodBeat.o(199691);
            return;
        }
        int[] iArr = new int[bbVarArr.length];
        StringBuffer stringBuffer = new StringBuffer();
        for (int i2 = 0; i2 < bbVarArr.length; i2++) {
            iArr[i2] = bbVarArr[i2].qrD;
            stringBuffer.append(bbVarArr[i2].qrD);
            stringBuffer.append(",");
        }
        com.tencent.pb.common.c.b.w("TalkRoomService", "engine handleVoiceGroupMemberChange engine.OnMembersChanged memberid: ", stringBuffer.toString());
        if (this.SuZ == null) {
            com.tencent.pb.common.c.b.w("TalkRoomService", "onMebersChangedToEngine engine is null");
            AppMethodBeat.o(199691);
            return;
        }
        this.SuZ.OnMembersChanged(iArr);
        AppMethodBeat.o(199691);
    }

    private static void a(String str, int i2, long j2, a.bb[] bbVarArr) {
        AppMethodBeat.i(199692);
        if (bbVarArr == null) {
            com.tencent.pb.common.c.b.w("TalkRoomService", "printMembersLog members is null groupId: ", str, "  roomid: ", Integer.valueOf(i2), "  roomKey", Long.valueOf(j2));
            AppMethodBeat.o(199692);
            return;
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (a.bb bbVar : bbVarArr) {
            if (bbVar != null) {
                stringBuffer.append(" memberId:" + bbVar.qrD + " uuid: " + bbVar.dLN + " status: " + bbVar.status + "   mem.inviteTime:" + bbVar.RGf + "  mem.reason: " + bbVar.bDZ + "  mem.inviteuuid: " + bbVar.RGr + "\n");
            }
        }
        com.tencent.pb.common.c.b.w("TalkRoomService", "printMembersLog groupId: ", str, "  romid: ", Integer.valueOf(i2), "  roomKey", Long.valueOf(j2), "  members.length: ", Integer.valueOf(bbVarArr.length), "  ", stringBuffer.toString());
        AppMethodBeat.o(199692);
    }

    private void a(a.q[] qVarArr, a.q[] qVarArr2, int i2) {
        AppMethodBeat.i(199693);
        Object[] objArr = new Object[2];
        objArr[0] = "handleRelayData addrs length: ";
        objArr[1] = Integer.valueOf(qVarArr == null ? 0 : qVarArr.length);
        com.tencent.pb.common.c.b.d("TalkRoomService", objArr);
        if (qVarArr == null || qVarArr.length <= 0) {
            AppMethodBeat.o(199693);
            return;
        }
        this.Svq = new String[qVarArr.length];
        this.Svp = new short[qVarArr.length];
        this.Svs = new String[qVarArr2.length];
        this.Svr = new short[qVarArr2.length];
        this.Svt = i2;
        com.tencent.pb.common.c.b.w("TalkRoomService", "handleRelayData tcpStartTime: ", Integer.valueOf(this.Svt));
        int i3 = 0;
        for (a.q qVar : qVarArr) {
            this.Svq[i3] = qVar.RDU;
            this.Svp[i3] = (short) qVar.port;
            com.tencent.pb.common.c.b.w("TalkRoomService", "handleRelayData ip: ", qVar.RDU, " addr.port: ", Integer.valueOf(qVar.port));
            i3++;
        }
        int i4 = 0;
        for (a.q qVar2 : qVarArr2) {
            this.Svs[i4] = qVar2.RDU;
            this.Svr[i4] = (short) qVar2.port;
            com.tencent.pb.common.c.b.w("TalkRoomService", "handleRelayData tcpIp: ", qVar2.RDU, " tcpAddr.port: ", Integer.valueOf(qVar2.port));
            i4++;
        }
        com.tencent.pb.common.c.b.d("TalkRoomService", "handleRelayData", Arrays.toString(this.Svq), Arrays.toString(this.Svp), this.xOr, this.xOr, Integer.valueOf(this.yvK), Long.valueOf(this.HgX), Arrays.toString(this.Svs), Arrays.toString(this.Svr), Integer.valueOf(this.Svt));
        AppMethodBeat.o(199693);
    }

    public final int dc(byte[] bArr) {
        a.r rVar;
        boolean z;
        boolean z2;
        a.s sVar;
        a.t tVar;
        int length;
        AppMethodBeat.i(62753);
        try {
            rVar = (a.r) com.google.a.a.e.a(new a.r(), bArr, bArr.length);
        } catch (Exception e2) {
            h.asK(-1601);
            rVar = null;
        }
        if (rVar == null) {
            if (!TextUtils.isEmpty(this.xOr) || !TextUtils.isEmpty(this.SuH)) {
                this.SuY.ag("notify", "pasrefail");
            } else {
                h.a(this.yvK, this.HgX, "notify", "pasrefail");
            }
            com.tencent.pb.common.c.b.w("TalkRoomService", "CLTNOT onVoiceGroupChange groupChg null");
            AppMethodBeat.o(62753);
            return -2;
        }
        com.tencent.pb.common.c.b.w("TalkRoomService", "CLTNOT onVoiceGroupChange ", this.xOr, Integer.valueOf(this.yvK), Long.valueOf(this.HgX), Long.valueOf(rVar.msgId), Integer.valueOf(rVar.RDV), Integer.valueOf(rVar.jlm));
        long j2 = rVar.msgId;
        if (this.Svl.contains(Long.valueOf(j2))) {
            z = true;
        } else {
            this.Svl.add(Long.valueOf(j2));
            z = false;
        }
        if (z) {
            com.tencent.pb.common.c.b.d("TalkRoomService", "CLTNOT onVoiceGroupChange isMsgDouble error: msgId:", Long.valueOf(rVar.msgId));
            if (b(rVar.groupId, rVar.GXO, rVar.GXP, false)) {
                this.SuY.ag("notify", "repeat", String.valueOf(rVar.RDV));
            } else {
                h.a(rVar.groupId, rVar.GXO, rVar.GXP, "notify", "repeat", String.valueOf(rVar.RDV));
            }
            AppMethodBeat.o(62753);
            return -3;
        }
        int i2 = rVar.RDV;
        int i3 = rVar.jlm;
        switch (i2) {
            case 1:
                if (i3 <= this.SuR) {
                    com.tencent.pb.common.c.b.w("TalkRoomService", "voiceMsg type ", Integer.valueOf(i2), " seq ", Integer.valueOf(i3), " is smaller than the latest handled msg seq ", Integer.valueOf(this.SuR));
                    z2 = false;
                    break;
                } else {
                    this.SuR = i3;
                    com.tencent.pb.common.c.b.w("voiceMsg type ", Integer.valueOf(i2), " seq ", Integer.valueOf(i3), " update local seq");
                    z2 = true;
                    break;
                }
            case 4:
                if (i3 <= this.SuS) {
                    com.tencent.pb.common.c.b.w("TalkRoomService", "voiceMsg type ", Integer.valueOf(i2), " seq ", Integer.valueOf(i3), " is smaller than the latest handled msg seq ", Integer.valueOf(this.SuS));
                    z2 = false;
                    break;
                } else {
                    this.SuS = i3;
                    com.tencent.pb.common.c.b.w("voiceMsg type ", Integer.valueOf(i2), " seq ", Integer.valueOf(i3), " update local seq");
                    z2 = true;
                    break;
                }
            case 8:
                if (i3 <= this.SuT) {
                    com.tencent.pb.common.c.b.w("TalkRoomService", "voiceMsg type ", Integer.valueOf(i2), " seq ", Integer.valueOf(i3), " is smaller than the latest handled msg seq ", Integer.valueOf(this.SuT));
                    z2 = false;
                    break;
                } else {
                    this.SuT = i3;
                    com.tencent.pb.common.c.b.w("voiceMsg type ", Integer.valueOf(i2), " seq ", Integer.valueOf(i3), " update local seq");
                    z2 = true;
                    break;
                }
            case 256:
                if (i3 <= this.SuU) {
                    com.tencent.pb.common.c.b.w("TalkRoomService", "voiceMsg type ", Integer.valueOf(i2), " seq ", Integer.valueOf(i3), " is smaller than the latest handled msg seq ", Integer.valueOf(this.SuU));
                    z2 = false;
                    break;
                } else {
                    this.SuU = i3;
                    com.tencent.pb.common.c.b.w("voiceMsg type ", Integer.valueOf(i2), " seq ", Integer.valueOf(i3), " update local seq");
                    z2 = true;
                    break;
                }
            case 512:
                if (i3 <= this.SuV) {
                    com.tencent.pb.common.c.b.w("TalkRoomService", "voiceMsg type ", Integer.valueOf(i2), " seq ", Integer.valueOf(i3), " is smaller than the latest handled msg seq ", Integer.valueOf(this.SuV));
                    z2 = false;
                    break;
                } else {
                    this.SuV = i3;
                    com.tencent.pb.common.c.b.w("voiceMsg type ", Integer.valueOf(i2), " seq ", Integer.valueOf(i3), " update local seq");
                    z2 = true;
                    break;
                }
            case 1024:
                if (i3 <= this.SuW) {
                    com.tencent.pb.common.c.b.w("TalkRoomService", "voiceMsg type ", Integer.valueOf(i2), " seq ", Integer.valueOf(i3), " is smaller than the latest handled msg seq ", Integer.valueOf(this.SuW));
                    z2 = false;
                    break;
                } else {
                    this.SuW = i3;
                    com.tencent.pb.common.c.b.w("voiceMsg type ", Integer.valueOf(i2), " seq ", Integer.valueOf(i3), " update local seq");
                    z2 = true;
                    break;
                }
            case 2048:
                if (i3 <= this.SuX) {
                    com.tencent.pb.common.c.b.w("TalkRoomService", "voiceMsg type ", Integer.valueOf(i2), " seq ", Integer.valueOf(i3), " is smaller than the latest handled msg seq ", Integer.valueOf(this.SuX));
                    z2 = false;
                    break;
                } else {
                    this.SuX = i3;
                    com.tencent.pb.common.c.b.w("voiceMsg type ", Integer.valueOf(i2), " seq ", Integer.valueOf(i3), " update local seq");
                    z2 = true;
                    break;
                }
            default:
                com.tencent.pb.common.c.b.w(" unknow voiceMsg type ", Integer.valueOf(i2), " seq ", Integer.valueOf(i3));
                z2 = false;
                break;
        }
        if (!z2) {
            com.tencent.pb.common.c.b.w("TalkRoomService", "onVoiceGroupChange update msg seq fail type:", Integer.valueOf(rVar.RDV));
        } else {
            if (b(rVar.groupId, rVar.GXO, rVar.GXP, false)) {
                this.SuY.ag("notify", "succ", String.valueOf(rVar.RDV));
            }
            if (rVar.RDV == 2) {
                a(rVar.groupId, null, rVar.RDt, rVar.GXO, rVar.GXP, rVar.RDX, rVar.RDW, rVar.RDq, true, true);
            } else if (rVar.RDV == 4) {
                a(rVar.groupId, null, rVar.RDt, rVar.GXO, rVar.GXP, rVar.RDX, rVar.RDW, rVar.RDq, true, true);
                if (!(rVar.RDZ == 0 && rVar.REa == 0)) {
                    b bVar = this.SuZ;
                    int i4 = rVar.RDZ;
                    int i5 = rVar.REa;
                    if (com.tencent.pb.common.a.a.RCk && bVar.Suj != null) {
                        bVar.Suj.SetAVEncryptType(i4, i5);
                    }
                }
            } else if (rVar.RDV == 16) {
                a(rVar.groupId, null, rVar.RDt, rVar.GXO, rVar.GXP, rVar.RDX, rVar.RDW, rVar.RDq, true, false);
            } else if (rVar.RDV == 1) {
                com.tencent.pb.common.c.b.w("TalkRoomService", "handlerCreateGroupChange groupChg.groupId: ", rVar.groupId, " roomId: ", Integer.valueOf(rVar.GXO), " roomkey: ", Long.valueOf(rVar.GXP));
                if (com.tencent.pb.a.a.a.hjr()) {
                    com.tencent.pb.a.a.a.hjs();
                    if (!fGt() || !com.tencent.pb.common.c.f.equals(rVar.groupId, this.xOr)) {
                        a(rVar.groupId, null, rVar.RDt, rVar.GXO, rVar.GXP, rVar.RDX, rVar.RDW, rVar.RDq, false, true);
                        String str = rVar.groupId;
                        int i6 = rVar.GXO;
                        long j3 = rVar.GXP;
                        int i7 = rVar.RDt;
                        int i8 = rVar.REb;
                        if (TextUtils.isEmpty(str)) {
                            com.tencent.pb.common.c.b.w("TalkRoomService", "CLTNOT ackTalkRoom groupId is null");
                        } else {
                            com.tencent.pb.common.c.b.d("TalkRoomService", "CLTNOT ackTalkRoom groupId: ", str, Integer.valueOf(i6), Long.valueOf(j3), Integer.valueOf(i8), Boolean.valueOf(com.tencent.pb.common.b.e.hiW().a(new com.tencent.wecall.talkroom.a.a(str, i6, j3, i7, i8))));
                        }
                        com.tencent.pb.common.c.b.w("TalkRoomService", "handlerCreateGroupChange start ui");
                    } else {
                        com.tencent.pb.common.c.b.w("TalkRoomService", "CLTNOT handlerCreateGroupChange return is same groupId: ", this.xOr);
                    }
                } else {
                    com.tencent.pb.common.c.b.w("TalkRoomService", "CLTNOT handlerCreateGroupChange isAuthed is false");
                }
            } else if (rVar.RDV == 8) {
                com.tencent.pb.common.c.b.w("TalkRoomService", "handleCancelCreateVoiceGroupChange groupChg.groupId: ", rVar.groupId, " mGroupId: ", this.xOr);
                if (b(rVar.groupId, rVar.GXO, rVar.GXP, false)) {
                    a(rVar.groupId, null, rVar.RDt, rVar.GXO, rVar.GXP, rVar.RDX, rVar.RDW, rVar.RDq, true, false);
                    a(rVar.groupId, rVar.GXO, rVar.GXP, false, false, true);
                } else {
                    a(rVar.groupId, null, rVar.RDt, rVar.GXO, rVar.GXP, rVar.RDX, rVar.RDW, rVar.RDq, true, false);
                }
            } else if (rVar.RDV == 128) {
                Object[] objArr = new Object[6];
                objArr[0] = "handleMemberWhisper groupChg.groupChg.groupId: ";
                objArr[1] = rVar.groupId;
                objArr[2] = " mGroupId: ";
                objArr[3] = this.xOr;
                objArr[4] = " groupChg.whisperBuf size: ";
                if (rVar.REc == null) {
                    length = 0;
                } else {
                    length = rVar.REc.length;
                }
                objArr[5] = Integer.valueOf(length);
                com.tencent.pb.common.c.b.d("TalkRoomService", objArr);
                g gVar = this.Svg;
                g.AnonymousClass23 r3 = new Runnable(rVar.groupId, rVar.REc) {
                    /* class com.tencent.wecall.talkroom.model.g.AnonymousClass23 */
                    final /* synthetic */ byte[] Swr;
                    final /* synthetic */ String qun;

                    {
                        this.qun = r2;
                        this.Swr = r3;
                    }

                    public final void run() {
                        AppMethodBeat.i(62687);
                        synchronized (g.this.callbacks) {
                            try {
                                for (a aVar : g.this.callbacks) {
                                    aVar.F(this.qun, this.Swr);
                                }
                            } finally {
                                AppMethodBeat.o(62687);
                            }
                        }
                    }
                };
                if (Looper.myLooper() == Looper.getMainLooper()) {
                    r3.run();
                } else {
                    gVar.handler.post(r3);
                }
            } else if (rVar.RDV == 256) {
                if (!b(rVar.groupId, rVar.GXO, rVar.GXP, false)) {
                    com.tencent.pb.common.c.b.w("TalkRoomService", "handleVideoMember is not same room ", rVar.groupId, Integer.valueOf(rVar.GXO));
                } else if (rVar.REc == null) {
                    com.tencent.pb.common.c.b.w("TalkRoomService", "handleVideoMember whisperBuf is null", rVar.groupId, Integer.valueOf(rVar.GXO));
                } else {
                    try {
                        byte[] bArr2 = rVar.REc;
                        tVar = (a.t) com.google.a.a.e.a(new a.t(), bArr2, bArr2.length);
                    } catch (com.google.a.a.d e3) {
                        com.tencent.pb.common.c.b.w("TalkRoomService", "handleVideoMember ", e3);
                        tVar = null;
                    }
                    if (tVar == null || tVar.REg == null) {
                        com.tencent.pb.common.c.b.w("TalkRoomService", "handleVideoMember notify is null", rVar.groupId, Integer.valueOf(rVar.GXO));
                    } else {
                        ArrayList arrayList = new ArrayList();
                        a.as[] asVarArr = tVar.REg;
                        for (a.as asVar : asVarArr) {
                            if (asVar != null) {
                                arrayList.add(asVar);
                            }
                        }
                        com.tencent.pb.common.c.b.d("TalkRoomService", "handleVideoMember groupid: ", this.xOr, " roomId: ", Integer.valueOf(this.yvK), " videoUserNames: ", arrayList);
                        g gVar2 = this.Svg;
                        g.AnonymousClass11 r2 = new Runnable(arrayList) {
                            /* class com.tencent.wecall.talkroom.model.g.AnonymousClass11 */
                            final /* synthetic */ List zHo;

                            {
                                this.zHo = r2;
                            }

                            public final void run() {
                                AppMethodBeat.i(62552);
                                synchronized (g.this.callbacks) {
                                    try {
                                        for (a aVar : g.this.callbacks) {
                                            aVar.fz(this.zHo);
                                        }
                                    } finally {
                                        AppMethodBeat.o(62552);
                                    }
                                }
                            }
                        };
                        if (Looper.myLooper() == Looper.getMainLooper()) {
                            r2.run();
                        } else {
                            gVar2.handler.post(r2);
                        }
                    }
                }
            } else if (rVar.RDV == 1024) {
                if (!b(rVar.groupId, rVar.GXO, rVar.GXP, false)) {
                    com.tencent.pb.common.c.b.w("TalkRoomService", "handleOtherDevice is not same room ", rVar.groupId, Integer.valueOf(rVar.GXO));
                } else if (!(this.state == 3 || this.state == 4)) {
                    c(rVar.groupId, rVar.GXO, rVar.GXP, 1);
                    this.Svg.n(-1400, null);
                }
            } else if (rVar.RDV == 512) {
                if (!b(rVar.groupId, rVar.GXO, rVar.GXP, false)) {
                    com.tencent.pb.common.c.b.w("TalkRoomService", "handleVideoSubscribes is not same room ", rVar.groupId, Integer.valueOf(rVar.GXO));
                } else if (rVar.REc == null) {
                    com.tencent.pb.common.c.b.w("TalkRoomService", "handleVideoSubscribes whisperBuf is null", rVar.groupId, Integer.valueOf(rVar.GXO));
                } else {
                    try {
                        byte[] bArr3 = rVar.REc;
                        sVar = (a.s) com.google.a.a.e.a(new a.s(), bArr3, bArr3.length);
                    } catch (com.google.a.a.d e4) {
                        com.tencent.pb.common.c.b.w("TalkRoomService", "handleVideoSubscribes ", e4);
                        sVar = null;
                    }
                    if (sVar == null) {
                        com.tencent.pb.common.c.b.w("TalkRoomService", "handleVideoMember notify is null", rVar.groupId, Integer.valueOf(rVar.GXO));
                    } else {
                        g gVar3 = this.Svg;
                        g.AnonymousClass1 r22 = new Runnable(sVar.REf) {
                            /* class com.tencent.wecall.talkroom.model.g.AnonymousClass1 */
                            final /* synthetic */ int Swl;

                            {
                                this.Swl = r2;
                            }

                            public final void run() {
                                AppMethodBeat.i(62588);
                                synchronized (g.this.callbacks) {
                                    try {
                                        for (a aVar : g.this.callbacks) {
                                            aVar.Ri(this.Swl);
                                        }
                                    } finally {
                                        AppMethodBeat.o(62588);
                                    }
                                }
                            }
                        };
                        if (Looper.myLooper() == Looper.getMainLooper()) {
                            r22.run();
                        } else {
                            gVar3.handler.post(r22);
                        }
                    }
                }
            } else if (rVar.RDV == 2048) {
                com.tencent.pb.common.c.b.w("TalkRoomService", "onVoiceGroupChange, chgtype: audiostream");
                if (!b(rVar.groupId, rVar.GXO, rVar.GXP, false)) {
                    com.tencent.pb.common.c.b.w("TalkRoomService", "handleAudioStreamChange is not same room ", rVar.groupId, Integer.valueOf(rVar.GXO));
                } else {
                    com.tencent.pb.common.c.b.d("TalkRoomService", "handleAudioStreamChange audio_stream_type", Integer.valueOf(rVar.audioStreamType));
                    this.SuZ.Suj.setAppCmd(TbsListener.ErrorCode.THROWABLE_QBSDK_INIT, new byte[]{(byte) (rVar.audioStreamType & 255), (byte) ((rVar.audioStreamType >> 8) & 255), (byte) ((rVar.audioStreamType >> 16) & 255), (byte) ((rVar.audioStreamType >> 24) & 255)}, 4);
                }
            } else {
                com.tencent.pb.common.c.b.w("TalkRoomService", "onVoiceGroupChange, unknow chgtype:", Integer.valueOf(rVar.RDV), Long.valueOf(rVar.msgId));
            }
        }
        AppMethodBeat.o(62753);
        return 0;
    }

    private void a(String str, int i2, long j2, boolean z) {
        AppMethodBeat.i(62754);
        a(str, i2, j2, z, true, true);
        AppMethodBeat.o(62754);
    }

    public final void a(String str, int i2, long j2, boolean z, boolean z2, boolean z3) {
        MultiTalkGroup brn;
        AppMethodBeat.i(62755);
        com.tencent.pb.common.c.b.w("TalkRoomService", "closeVoiceGroup groupId: ", str, " mGroupId: ", this.xOr, " roomId: ", Integer.valueOf(i2), " mRoomId: ", Integer.valueOf(this.yvK), " roomKey: ", Long.valueOf(j2), " mRoomKey: ", Long.valueOf(this.HgX));
        c.hqY().brh(str);
        if (z) {
            N(str, i2, j2);
        }
        this.Suy.remove(str);
        if (b(str, i2, j2, false)) {
            com.tencent.pb.common.c.b.d("TalkRoomService", "closeVoiceGroup isCurrentRoom groupId: ", str, " roomId: ", Integer.valueOf(i2), " roomKey: ", Long.valueOf(j2));
            Eh(true);
            this.Svg.dH(str, z2);
        }
        if (z3 && (brn = c.hqY().brn(str)) != null) {
            this.Svg.f(brn);
        }
        AppMethodBeat.o(62755);
    }

    public final boolean fGt() {
        AppMethodBeat.i(62756);
        com.tencent.pb.common.c.b.w("TalkRoomService", "state: ", Integer.valueOf(this.state));
        if (this.state != 0) {
            AppMethodBeat.o(62756);
            return true;
        }
        AppMethodBeat.o(62756);
        return false;
    }

    public final e bro(String str) {
        AppMethodBeat.i(62757);
        e eVar = this.Suy.get(str);
        AppMethodBeat.o(62757);
        return eVar;
    }

    public final boolean brp(String str) {
        AppMethodBeat.i(62758);
        if (this.Suy.get(str) != null) {
            AppMethodBeat.o(62758);
            return true;
        }
        AppMethodBeat.o(62758);
        return false;
    }

    private void hrk() {
        AppMethodBeat.i(62759);
        com.tencent.pb.common.c.b.w("TalkRoomService", "hello timer start~~");
        if (this.Svb != null) {
            com.tencent.pb.common.c.b.w("TalkRoomService", "dealWithInit enter talkroom not first time");
            AppMethodBeat.o(62759);
            return;
        }
        try {
            this.Svb = new TimerTask() {
                /* class com.tencent.wecall.talkroom.model.f.AnonymousClass2 */

                public final void run() {
                    AppMethodBeat.i(62720);
                    if (f.this.yvK == 0 || f.this.xOr == null) {
                        com.tencent.pb.common.c.b.w("TalkRoomService", "talkNoopTimer error: roomId %d, talkUsername %s", Integer.valueOf(f.this.yvK), f.this.xOr);
                        f.k(f.this);
                        AppMethodBeat.o(62720);
                        return;
                    }
                    f.a(f.this, f.j(f.this));
                    AppMethodBeat.o(62720);
                }
            };
            this.Svd.schedule(this.Svb, 0, (long) SuD);
            AppMethodBeat.o(62759);
        } catch (Exception e2) {
            com.tencent.pb.common.c.b.w("TalkRoomService", "startNooper: ", e2);
            AppMethodBeat.o(62759);
        }
    }

    private void hrl() {
        AppMethodBeat.i(62760);
        try {
            com.tencent.pb.common.c.b.w("TalkRoomService", "cancelHelloTimeOutTask");
            if (this.Svc != null) {
                this.Svc.cancel();
            }
        } catch (Exception e2) {
            com.tencent.pb.common.c.b.w("TalkRoomService", "cancelHelloTimeOutTask: ", e2);
        }
        this.Svc = null;
        AppMethodBeat.o(62760);
    }

    private void hrm() {
        AppMethodBeat.i(62761);
        try {
            com.tencent.pb.common.c.b.w("TalkRoomService", "cancelHelloTimerTask");
            if (this.Svb != null) {
                this.Svb.cancel();
            }
        } catch (Exception e2) {
            com.tencent.pb.common.c.b.w("TalkRoomService", "cancelHelloTimerTask: ", e2);
        }
        this.Svb = null;
        AppMethodBeat.o(62761);
    }

    private void hrn() {
        AppMethodBeat.i(62762);
        try {
            com.tencent.pb.common.c.b.w("TalkRoomService", "cancelTalkDurationTimerTask");
            if (this.Sve != null) {
                this.Sve.cancel();
            }
        } catch (Exception e2) {
            com.tencent.pb.common.c.b.w("TalkRoomService", "cancelTalkDurationTimerTask: ", e2);
        }
        this.Sve = null;
        AppMethodBeat.o(62762);
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0095  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x00cc  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0076  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(final int r21, final com.tencent.pb.common.b.a.a.a.bb[] r22, final com.tencent.pb.common.b.a.a.a.ay r23, final byte[] r24, final boolean r25, final java.lang.String r26, final int r27, final long r28, final int r30, final int r31, final byte[] r32, final int[] r33, final int r34, final int r35) {
        /*
        // Method dump skipped, instructions count: 259
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.wecall.talkroom.model.f.a(int, com.tencent.pb.common.b.a.a.a$bb[], com.tencent.pb.common.b.a.a.a$ay, byte[], boolean, java.lang.String, int, long, int, int, byte[], int[], int, int):void");
    }

    private boolean a(a.bb[] bbVarArr, a.ay ayVar, byte[] bArr, boolean z, int i2, long j2, int i3, int i4, byte[] bArr2, int[] iArr, int i5, int i6) {
        AppMethodBeat.i(199695);
        if (this.state != 4) {
            com.tencent.pb.common.c.b.w("TalkRoomService", "dealWithInit state is error: ", Integer.valueOf(this.state));
            AppMethodBeat.o(199695);
            return false;
        }
        this.SuO = iArr[talk.zGz];
        com.tencent.pb.common.c.b.w("TalkRoomService", "dealWithInit general policy cnt:", Integer.valueOf(iArr.length), ", redirect type:", this.SuO + " wifigateway:" + i6);
        boolean b2 = b(bbVarArr, ayVar, bArr, z, i2, j2, i3, i4, bArr2, iArr, i5, i6);
        AppMethodBeat.o(199695);
        return b2;
    }

    /* access modifiers changed from: package-private */
    public final boolean fuf() {
        int i2;
        int i3;
        int i4;
        int length;
        AppMethodBeat.i(62765);
        com.tencent.pb.common.c.b.d("TalkRoomService", "initEngine", this.xOr, Integer.valueOf(this.yvK), Long.valueOf(this.HgX), Integer.valueOf(this.state));
        try {
            b bVar = this.SuZ;
            if (!com.tencent.pb.common.a.a.RCk) {
                i2 = 0;
            } else {
                String absolutePath = com.tencent.pb.common.c.c.Hhs.getDir(ShareConstants.SO_PATH, 0).getAbsolutePath();
                com.tencent.pb.talkroom.sdk.e eVar = RCV;
                if (eVar != null) {
                    i4 = eVar.aon();
                    i3 = eVar.emN();
                } else {
                    i3 = 0;
                    i4 = 0;
                }
                int lx = k.lx(com.tencent.pb.common.c.c.Hhs);
                com.tencent.pb.common.c.b.i("simon:TalkRoomContext", "protocalInit netType:", Integer.valueOf(lx), " cpuFlag:", Integer.valueOf(i4), "libPath:", absolutePath);
                if (bVar.Suj == null) {
                    i2 = -1;
                } else {
                    i2 = bVar.Suj.init(i3, lx, i4, absolutePath + FilePathGenerator.ANDROID_DIR_SEP);
                    Object[] objArr = new Object[4];
                    objArr[0] = "protocalInit";
                    objArr[1] = Integer.valueOf(i2);
                    objArr[2] = "field_capInfo length: ";
                    if (bVar.Suj.field_capInfo == null) {
                        length = 0;
                    } else {
                        length = bVar.Suj.field_capInfo.length;
                    }
                    objArr[3] = Integer.valueOf(length);
                    com.tencent.pb.common.c.b.i("simon:TalkRoomContext", objArr);
                }
            }
        } catch (Exception e2) {
            com.tencent.pb.common.c.b.w("TalkRoomService", "initEngine", e2);
            i2 = -99999;
        }
        if (i2 < 0) {
            h.asN(-3001);
            this.SuY.asO(201);
            this.SuZ = null;
            com.tencent.pb.common.c.b.w("TalkRoomService", "initEngine engine.protocalInit error", Integer.valueOf(i2));
            AppMethodBeat.o(62765);
            return false;
        }
        AppMethodBeat.o(62765);
        return true;
    }

    public final void rt(boolean z) {
        AppMethodBeat.i(62766);
        try {
            ZZ();
            hrj();
            if (z) {
                hro();
                bFT();
            }
            com.tencent.pb.common.c.b.w("TalkRoomService", "setRecordDevActive active: ", Boolean.valueOf(z));
            AppMethodBeat.o(62766);
        } catch (Throwable th) {
            com.tencent.pb.common.c.b.w("TalkRoomService", "setRecordDevActive active: ", Boolean.valueOf(z), th);
            AppMethodBeat.o(62766);
        }
    }

    private void bFT() {
        AppMethodBeat.i(62767);
        ZZ();
        int b2 = b(talk.VOICE_SAMPLERATE, talk.VOICE_FRAME_DURATION, new com.tencent.pb.talkroom.sdk.c() {
            /* class com.tencent.wecall.talkroom.model.f.AnonymousClass5 */

            @Override // com.tencent.pb.talkroom.sdk.c
            public final void ag(byte[] bArr, int i2) {
                AppMethodBeat.i(62659);
                try {
                    if (!f.this.SuF) {
                        AppMethodBeat.o(62659);
                        return;
                    }
                    if (f.this.mIsMute) {
                        for (int i3 = 0; i3 < bArr.length; i3++) {
                            bArr[i3] = 0;
                        }
                    }
                    if (f.this.SuF) {
                        b bVar = f.this.SuZ;
                        short s = (short) i2;
                        if (com.tencent.pb.common.a.a.RCk && bVar.Suj != null) {
                            bVar.Suj.SendAudio(bArr, s, 0);
                        }
                        if (f.this.Svn) {
                            f.this.Svn = false;
                            com.tencent.pb.common.c.b.w("TalkRoomService", "onRecPcmDataCallBack len: ", Integer.valueOf(i2));
                        }
                    }
                    AppMethodBeat.o(62659);
                } catch (Exception e2) {
                    com.tencent.pb.common.c.b.w("TalkRoomService", "initMediaComponent record", e2);
                    AppMethodBeat.o(62659);
                }
            }
        });
        if (b2 <= 0) {
            this.SuY.asO(101);
            h.asL(-2001);
            this.Svg.n(-500, null);
        }
        if (b2 > 0) {
            this.SuY.Swt &= -2;
        } else {
            this.SuY.Swt |= 1;
        }
        com.tencent.pb.common.c.b.w("TalkRoomService", "audioAdapter startRecord ret: ", Integer.valueOf(b2));
        AppMethodBeat.o(62767);
    }

    private void hro() {
        AppMethodBeat.i(62768);
        hrj();
        final AtomicInteger atomicInteger = new AtomicInteger();
        final AtomicInteger atomicInteger2 = new AtomicInteger();
        int b2 = b(talk.VOICE_SAMPLERATE, talk.VOICE_FRAME_DURATION, new com.tencent.pb.talkroom.sdk.b() {
            /* class com.tencent.wecall.talkroom.model.f.AnonymousClass6 */

            @Override // com.tencent.pb.talkroom.sdk.b
            public final int af(byte[] bArr, int i2) {
                int i3;
                AppMethodBeat.i(62788);
                if (!f.this.SuF) {
                    AppMethodBeat.o(62788);
                    return 0;
                }
                try {
                    b bVar = f.this.SuZ;
                    short s = (short) i2;
                    AtomicInteger atomicInteger = atomicInteger;
                    AtomicInteger atomicInteger2 = atomicInteger2;
                    if (!com.tencent.pb.common.a.a.RCk || bVar.Suj == null) {
                        i3 = 1;
                    } else {
                        i3 = bVar.Suj.GetAudioData(bArr, s, atomicInteger, atomicInteger2);
                    }
                    if (f.this.Svo && i3 >= 0) {
                        f.this.Svo = false;
                        com.tencent.pb.common.c.b.w("TalkRoomService", "onPlayPcmDataCallBack len: ", Integer.valueOf(i2), " ret: ", Integer.valueOf(i3));
                    }
                    AppMethodBeat.o(62788);
                    return i3;
                } catch (Exception e2) {
                    com.tencent.pb.common.c.b.w("TalkRoomService", "initMediaComponent play", e2);
                    AppMethodBeat.o(62788);
                    return -1;
                }
            }
        });
        if (b2 <= 0) {
            this.SuY.asO(101);
            h.asL(-2001);
            this.SuY.Swt |= 1;
            this.Svg.n(-500, null);
        }
        com.tencent.pb.common.c.b.w("TalkRoomService", "audioAdapter startPlayer ret: ", Integer.valueOf(b2));
        AppMethodBeat.o(62768);
    }

    private void hrp() {
        AppMethodBeat.i(62769);
        if (this.Sve != null) {
            com.tencent.pb.common.c.b.w("TalkRoomService", "refreashTalkingTime mTalkDurationTimerTask is null");
            AppMethodBeat.o(62769);
            return;
        }
        com.tencent.pb.common.c.b.w("TalkRoomService", "refreashTalkingTime mTalkRoomTalkingCallBack: ", this.Suw, " mIsHoldOn: ", Boolean.valueOf(this.Svu));
        this.Sve = new TimerTask() {
            /* class com.tencent.wecall.talkroom.model.f.AnonymousClass7 */

            public final void run() {
                AppMethodBeat.i(62661);
                if (!f.this.Svu) {
                    f.this.SuI++;
                    if (f.this.Svi) {
                        f.this.SuK++;
                    }
                    if (f.this.SuQ == 3 || f.this.SuQ == 2) {
                        f.this.SuJ++;
                        f.this.SuY.Hrs = f.this.SuJ;
                    }
                    f.this.SuY.Swx = f.this.SuI * 1000;
                    f.this.SuY.Hrr = f.this.SuI;
                }
                if (f.this.Suw != null) {
                    int unused = f.this.SuI;
                }
                AppMethodBeat.o(62661);
            }
        };
        this.Svf.scheduleAtFixedRate(this.Sve, 1000, 1000);
        AppMethodBeat.o(62769);
    }

    private boolean b(a.bb[] bbVarArr, a.ay ayVar, byte[] bArr, boolean z, int i2, long j2, int i3, int i4, byte[] bArr2, int[] iArr, int i5, int i6) {
        int[] iArr2;
        int i7;
        int i8;
        int i9;
        AppMethodBeat.i(199696);
        com.tencent.pb.common.c.b.d("TalkRoomService", "connectToCompenent myRoomMemId roomid:", Integer.valueOf(i2), " roomKey: ", Long.valueOf(j2), " groupId: ", this.xOr, " ip: ", Arrays.toString(this.Svq), " ports: ", Arrays.toString(this.Svp), " tcpIp: ", Arrays.toString(this.Svs), " tcpPorts: ", Arrays.toString(this.Svr), " tcpStartTime: ", Integer.valueOf(this.Svt), " audio_encrypt_type: ", Integer.valueOf(i3), " video_encrypt_type: ", Integer.valueOf(i5));
        String hjq = com.tencent.pb.a.a.a.hjq();
        int i10 = -1;
        if (bbVarArr == null || bbVarArr.length <= 0) {
            iArr2 = null;
            i7 = -1;
        } else {
            int[] iArr3 = new int[bbVarArr.length];
            for (int i11 = 0; i11 < bbVarArr.length; i11++) {
                iArr3[i11] = bbVarArr[i11].qrD;
                if (com.tencent.pb.common.c.f.equals(bbVarArr[i11].dLN, hjq)) {
                    i10 = bbVarArr[i11].qrD;
                }
            }
            iArr2 = iArr3;
            i7 = i10;
        }
        int bri = c.hqY().bri(this.xOr);
        this.SuY.qrD = i7;
        try {
            b bVar = this.SuZ;
            talk.a aVar = this.Sva;
            c hqY = c.hqY();
            String str = this.xOr;
            TalkRoom brg = hqY.brg(str);
            if (brg == null) {
                com.tencent.pb.common.c.b.w("TalkRoomManager", "getMyUuid TalkRoom is null  groupId: ", str);
                i9 = 0;
            } else {
                d brf = brg.brf(com.tencent.pb.a.a.a.hjq());
                if (brf == null) {
                    com.tencent.pb.common.c.b.w("TalkRoomManager", "getMyUuid talkRoomMember is null  groupId: ", str);
                    i9 = 0;
                } else {
                    a.bb bbVar = brf.Sup;
                    if (bbVar == null) {
                        com.tencent.pb.common.c.b.w("TalkRoomManager", "getMyUuid voiceGroupMem is null  groupId: ", str);
                        i9 = 0;
                    } else {
                        com.tencent.pb.common.c.b.d("TalkRoomManager", "getMyUuid groupId: ", str, " uuid: ", Integer.valueOf(bbVar.KBb));
                        i9 = bbVar.KBb;
                    }
                }
            }
            String[] strArr = this.Svq;
            short[] sArr = this.Svp;
            String[] strArr2 = this.Svs;
            short[] sArr2 = this.Svr;
            int i12 = this.Svt;
            i iVar = null;
            if (ayVar != null) {
                iVar = new i(ayVar.RFx, ayVar.iTa, ayVar.iTb, ayVar.RFy, ayVar.RFz, ayVar.RFA, ayVar.RFB, ayVar.RFC, ayVar.RFD, ayVar.RFE, ayVar.RFF, ayVar.RFG);
            } else {
                com.tencent.pb.common.c.b.w("simon:TalkRoomContext", "voiceConf is null");
            }
            int lx = k.lx(com.tencent.pb.common.c.c.Hhs);
            if (bVar.Suj == null) {
                i8 = -1;
            } else {
                i8 = bVar.Suj.Open(aVar, iVar, i9, i7, i2, j2, strArr, sArr, 0, iArr2, bArr, z, lx, strArr2, sArr2, i12, i3, i4, bArr2, iArr, i5, i6);
            }
        } catch (Throwable th) {
            com.tencent.pb.common.c.b.w("TalkRoomService", "connectToCompenent", th);
            i8 = -99999;
        }
        g gVar = this.Svg;
        g.AnonymousClass5 r4 = new Runnable(i8) {
            /* class com.tencent.wecall.talkroom.model.g.AnonymousClass5 */
            final /* synthetic */ int val$errCode;

            {
                this.val$errCode = r2;
            }

            public final void run() {
                AppMethodBeat.i(183723);
                synchronized (g.this.callbacks) {
                    try {
                        for (a aVar : g.this.callbacks) {
                            aVar.asG(this.val$errCode);
                        }
                    } finally {
                        AppMethodBeat.o(183723);
                    }
                }
            }
        };
        if (Looper.myLooper() == Looper.getMainLooper()) {
            r4.run();
        } else {
            gVar.handler.post(r4);
        }
        com.tencent.pb.common.c.b.d("TalkRoomService", "connectToCompenent ret =", Integer.valueOf(i8), Integer.valueOf(i7), Integer.valueOf(bri));
        if (i8 < 0) {
            h.asN(-3002);
        }
        if (i8 == 0) {
            this.SuY.Hrh = 1;
        }
        if (i8 == 0) {
            AppMethodBeat.o(199696);
            return true;
        }
        AppMethodBeat.o(199696);
        return false;
    }

    private boolean b(String str, int i2, long j2, boolean z) {
        AppMethodBeat.i(62771);
        if (z) {
            boolean nG = com.tencent.pb.common.c.f.nG(str, this.xOr);
            AppMethodBeat.o(62771);
            return nG;
        }
        com.tencent.pb.common.c.b.w("TalkRoomService", "isCurrentRoom groupId: ", str, " mGroupId: ", this.xOr, "roomId: ", Integer.valueOf(i2), " mRoomId: ", Integer.valueOf(this.yvK), " roomKey: ", Long.valueOf(j2), " mRoomKey: ", Long.valueOf(this.HgX));
        if (com.tencent.pb.common.c.f.nG(str, this.xOr) && i2 == this.yvK && j2 == this.HgX) {
            AppMethodBeat.o(62771);
            return true;
        }
        AppMethodBeat.o(62771);
        return false;
    }

    private void N(String str, int i2, long j2) {
        AppMethodBeat.i(62772);
        try {
            com.tencent.pb.common.c.b.w("TalkRoomService", "addCallLog groupId: ", str, " mIsOutCall: ", Boolean.valueOf(this.GUf), " mTalkDuration: ", Integer.valueOf(this.SuI), " msgKey: ", c.hqY().M(str, i2, j2));
            AppMethodBeat.o(62772);
        } catch (Throwable th) {
            com.tencent.pb.common.c.b.w("TalkRoomService", "handleRoomExit: ", th);
            AppMethodBeat.o(62772);
        }
    }

    public final boolean aY(String str, int i2, int i3) {
        AppMethodBeat.i(62773);
        com.tencent.pb.common.c.b.w("TalkRoomService", "finishCurrentTalk groupId: ", str, " rejectReason: ", Integer.valueOf(i2), " exitReason: ", Integer.valueOf(i3));
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(62773);
            return false;
        }
        if (i2 == 1 || i3 == 100) {
            this.SuY.hrw();
        }
        int i4 = this.yvK;
        long j2 = this.HgX;
        int i5 = a.hqJ().state;
        if (j.bru(str)) {
            this.SuY.asO(TbsListener.ErrorCode.TEST_THROWABLE_ISNOT_NULL);
            boolean hL = a.hqJ().hL(str, 1000);
            AppMethodBeat.o(62773);
            return hL;
        } else if (i5 == 2) {
            boolean c2 = a.hqJ().c(str, i4, j2, i2);
            AppMethodBeat.o(62773);
            return c2;
        } else {
            com.tencent.pb.common.c.a.M(102, 103, 104, 105, 106, 107, 108).contains(Integer.valueOf(i3));
            boolean a2 = a.hqJ().a(str, i4, j2, i3, true);
            AppMethodBeat.o(62773);
            return a2;
        }
    }

    private void hrq() {
        AppMethodBeat.i(62774);
        this.mHandler.removeCallbacks(this.Svy);
        this.Svx = null;
        AppMethodBeat.o(62774);
    }

    private void c(com.tencent.pb.common.b.d dVar) {
        AppMethodBeat.i(62775);
        this.mHandler.removeCallbacks(this.Svy);
        this.Svx = dVar;
        this.mHandler.postDelayed(this.Svy, 3000);
        AppMethodBeat.o(62775);
    }

    @Override // com.tencent.g.a.d
    public final void hH(String str, int i2) {
        AppMethodBeat.i(62776);
        if (com.tencent.pb.common.c.f.equals("GLOBAL_TOPIC_NETWORK_CHANGE", str) && fGt() && (this.yIP || this.SuF)) {
            switch (i2) {
                case 21:
                    switch (k.lx(com.tencent.pb.common.c.c.Hhs)) {
                        case 4:
                            this.Svi = true;
                            break;
                        default:
                            this.Svi = false;
                            break;
                    }
                    if (this.yvK == 0 || this.HgX == 0) {
                        com.tencent.pb.common.c.b.w("TalkRoomService", "sendRedirect mRoomId valid(session ended)");
                        AppMethodBeat.o(62776);
                        return;
                    }
                    com.tencent.pb.common.c.b.w("TalkRoomService", "sendRedirect", this.xOr, Integer.valueOf(this.yvK));
                    this.SuY.hrx();
                    boolean a2 = com.tencent.pb.common.b.e.hiW().a(new com.tencent.wecall.talkroom.a.h(this.xOr, this.yvK, this.HgX, c.hqY().bri(this.xOr), this.SuO));
                    this.SuY.ag("redirect", "req", String.valueOf(a2), String.valueOf(this.state));
                    com.tencent.pb.common.c.b.w("TalkRoomService", "sendRedirect ret: ", Boolean.valueOf(a2));
                    AppMethodBeat.o(62776);
                    return;
                case 33:
                    b bVar = this.SuZ;
                    int lx = k.lx(com.tencent.pb.common.c.c.Hhs);
                    if (com.tencent.pb.common.a.a.RCk && bVar.Suj != null) {
                        bVar.Suj.onNetworkChange(lx);
                        break;
                    } else {
                        AppMethodBeat.o(62776);
                        return;
                    }
                    break;
            }
        }
        AppMethodBeat.o(62776);
    }

    private static boolean asI(int i2) {
        return i2 != 1;
    }

    private void a(String str, int i2, long j2, String str2, String str3) {
        this.yvK = i2;
        this.HgX = j2;
        this.xOr = str2;
        this.SuH = str;
        this.SuG = str3;
    }

    private static void hrr() {
        AppMethodBeat.i(62777);
        try {
            AudioManager audioManager = (AudioManager) com.tencent.pb.common.c.c.Hhs.getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE);
            audioManager.setMode(0);
            com.tencent.pb.common.c.b.w("TalkRoomService", "resumeAudioConfig mode: ", Integer.valueOf(audioManager.getMode()), " isSpeaker: ", Boolean.valueOf(audioManager.isSpeakerphoneOn()));
            AppMethodBeat.o(62777);
        } catch (Throwable th) {
            com.tencent.pb.common.c.b.w("TalkRoomService", "resumeAudioConfig ", th);
            AppMethodBeat.o(62777);
        }
    }

    public static boolean hrs() {
        boolean z;
        AppMethodBeat.i(62778);
        try {
            z = ((AudioManager) com.tencent.pb.common.c.c.Hhs.getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE)).isSpeakerphoneOn();
        } catch (Exception e2) {
            com.tencent.pb.common.c.b.w("TalkRoomService", "isSpeakerOn ", e2);
            z = false;
        }
        com.tencent.pb.common.c.b.d("TalkRoomService", "isSpeakerOn ret: ", Boolean.valueOf(z));
        AppMethodBeat.o(62778);
        return z;
    }

    public static void a(com.tencent.pb.talkroom.sdk.e eVar) {
        RCV = eVar;
    }

    public static com.tencent.pb.talkroom.sdk.e hrt() {
        return RCV;
    }

    private boolean hrj() {
        boolean z;
        AppMethodBeat.i(62737);
        try {
            com.tencent.pb.talkroom.sdk.e eVar = RCV;
            if (eVar != null) {
                this.SuY.HaY = eVar.emR();
                this.SuY.HaN = eVar.emU();
                z = eVar.emP();
                com.tencent.pb.common.c.b.d("TalkRoomService", "stopPlayer ret: ", Boolean.valueOf(z));
                AppMethodBeat.o(62737);
                return z;
            }
        } catch (Exception e2) {
            com.tencent.pb.common.c.b.w("TalkRoomService", "stopPlayer: ", e2);
        }
        z = false;
        com.tencent.pb.common.c.b.d("TalkRoomService", "stopPlayer ret: ", Boolean.valueOf(z));
        AppMethodBeat.o(62737);
        return z;
    }

    private boolean ZZ() {
        boolean z;
        AppMethodBeat.i(62739);
        try {
            com.tencent.pb.talkroom.sdk.e eVar = RCV;
            if (eVar != null) {
                this.SuY.HaQ = eVar.emS();
                this.SuY.HaM = eVar.emT();
                z = eVar.emQ();
                com.tencent.pb.common.c.b.d("TalkRoomService", "stopRecord ret: ", Boolean.valueOf(z));
                AppMethodBeat.o(62739);
                return z;
            }
        } catch (Exception e2) {
            com.tencent.pb.common.c.b.w("TalkRoomService", "stopRecord: ", e2);
        }
        z = false;
        com.tencent.pb.common.c.b.d("TalkRoomService", "stopRecord ret: ", Boolean.valueOf(z));
        AppMethodBeat.o(62739);
        return z;
    }

    static /* synthetic */ void a(f fVar, int[] iArr) {
        AppMethodBeat.i(62779);
        if (iArr == null) {
            com.tencent.pb.common.c.b.w("TalkRoomService", "onMebersChangedToEngineByIds members is null");
            AppMethodBeat.o(62779);
            return;
        }
        Object[] objArr = new Object[2];
        objArr[0] = "engine onMebersChangedToEngineByIds members.length: ";
        objArr[1] = Integer.valueOf(iArr == null ? 0 : iArr.length);
        com.tencent.pb.common.c.b.w("TalkRoomService", objArr);
        if (fVar.SuZ == null) {
            com.tencent.pb.common.c.b.w("TalkRoomService", "onMebersChangedToEngine engine is null");
            AppMethodBeat.o(62779);
            return;
        }
        fVar.SuZ.OnMembersChanged(iArr);
        AppMethodBeat.o(62779);
    }

    static /* synthetic */ void e(f fVar) {
        AppMethodBeat.i(62780);
        if (fVar.SuZ == null) {
            com.tencent.pb.common.c.b.e("TalkRoomService", "the engine should not be null.");
            AppMethodBeat.o(62780);
            return;
        }
        com.tencent.pb.common.c.b.d("TalkRoomService", "initMediaComponent");
        com.tencent.pb.common.c.e.U(411, 1, "1");
        fVar.hro();
        fVar.bFT();
        AppMethodBeat.o(62780);
    }

    static /* synthetic */ o j(f fVar) {
        AppMethodBeat.i(62781);
        if (TextUtils.isEmpty(fVar.xOr)) {
            com.tencent.pb.common.c.b.w("TalkRoomService", "doHelloVoiceRoom mGroupId is null");
            AppMethodBeat.o(62781);
            return null;
        }
        int bri = c.hqY().bri(fVar.xOr);
        com.tencent.pb.common.c.b.w("TalkRoomService", "doHelloVoiceRoom mGroupId: ", fVar.xOr, " mRoomId: ", Integer.valueOf(fVar.yvK), " mRoomKey: ", Long.valueOf(fVar.HgX), " selfMemberId: ", Integer.valueOf(bri), " mCallData: ", Integer.valueOf(fVar.SuN));
        o oVar = new o(fVar.xOr, fVar.yvK, fVar.HgX, bri, fVar.SuN);
        com.tencent.pb.common.b.e.hiW().a(oVar);
        AppMethodBeat.o(62781);
        return oVar;
    }

    static /* synthetic */ void a(f fVar, final o oVar) {
        AppMethodBeat.i(62783);
        if (fVar.Svc == null) {
            fVar.Svc = new TimerTask() {
                /* class com.tencent.wecall.talkroom.model.f.AnonymousClass3 */

                public final void run() {
                    AppMethodBeat.i(62600);
                    if (oVar == null) {
                        com.tencent.pb.common.c.b.w("TalkRoomService", "doHelloTimeOutTask scene is null");
                        AppMethodBeat.o(62600);
                    } else if (!f.a(f.this, oVar.xOr, oVar.yvK, oVar.HgX, false)) {
                        com.tencent.pb.common.c.b.w("TalkRoomService", "doHelloTimeOutTask isCurrentRoom is false scene.mGroupId: ", oVar.xOr, " scene.mRoomId: ", Integer.valueOf(oVar.yvK), " scene.mRoomKey: ", Long.valueOf(oVar.HgX));
                        AppMethodBeat.o(62600);
                    } else {
                        com.tencent.pb.common.c.b.w("TalkRoomService", "doHelloTimeOutTask mGroupId: ", f.this.xOr, " mRoomId: ", Integer.valueOf(f.this.yvK), " mRoomKey: ", Long.valueOf(f.this.HgX));
                        f.this.SuY.asO(TbsListener.ErrorCode.ERROR_QBSDK_INIT_ERROR_RET_TYPE_NOT_BUNDLE);
                        h.asK(-1606);
                        f.this.a(oVar.xOr, oVar.yvK, oVar.HgX, 117, true);
                        f.this.Svg.n(-600, null);
                        AppMethodBeat.o(62600);
                    }
                }
            };
            fVar.Svd.schedule(fVar.Svc, 120000);
        }
        AppMethodBeat.o(62783);
    }
}

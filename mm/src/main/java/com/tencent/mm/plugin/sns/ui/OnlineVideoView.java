package com.tencent.mm.plugin.sns.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.an.e;
import com.tencent.mm.app.j;
import com.tencent.mm.g.a.cz;
import com.tencent.mm.g.a.oq;
import com.tencent.mm.g.a.vj;
import com.tencent.mm.g.a.vm;
import com.tencent.mm.g.a.wn;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.d;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.platformtools.p;
import com.tencent.mm.plugin.n.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.ay;
import com.tencent.mm.plugin.sns.model.c;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.ui.an;
import com.tencent.mm.pluginsdk.ui.i;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerTextureView;
import com.tencent.mm.pluginsdk.ui.tools.VideoTextureView;
import com.tencent.mm.pluginsdk.ui.tools.j;
import com.tencent.mm.protocal.protobuf.cnb;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.FileProviderHelper;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.system.AndroidMediaUtil;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.bp;
import com.tencent.mm.ui.widget.MMPinProgressBtn;
import com.tencent.mm.ui.widget.a.f;
import com.tencent.mm.vfs.s;

public class OnlineVideoView extends RelativeLayout implements d.a, an.a, j.a {
    private bp DEv;
    private IListener DOo;
    private MTimerHandler Ehq;
    private j.e EtE;
    private int EtH;
    String EtI;
    private boolean EtJ;
    private a EtK;
    protected volatile an EtL;
    private boolean EtM;
    private boolean EtN;
    private int EtO;
    private int EtP;
    private long EtQ;
    private long EtR;
    protected boolean EtS;
    private long EtT;
    public volatile boolean EtU;
    protected Activity EtV;
    protected boolean EtW;
    private c.b EtX;
    private IListener EtY;
    private IListener EtZ;
    private boolean Etz;
    private long Eua;
    private int Eub;
    private long Euc;
    private int Eud;
    private boolean Eue;
    final String TAG;
    private String dJX;
    private String dRS;
    private int duration;
    private cnb ebR;
    private boolean ecA;
    private int ecB;
    private int ecz;
    private String filePath;
    private boolean guh;
    private TextView hPF;
    private int iXu;
    private volatile boolean isInit;
    boolean isPreview;
    private Context mContext;
    private ProgressBar mEz;
    d pNk;
    MMHandler qaC;
    protected j qbJ;
    private MTimerHandler qbP;
    private int scene;
    private String sessionId;
    ImageView tiQ;
    private RelativeLayout tjk;
    private TextView tmU;
    private boolean tmZ;
    private boolean tna;
    private int tnb;
    private MMPinProgressBtn tne;
    private int videoHeight;
    private int videoWidth;
    private b zrF;

    public interface a {
        void onCompletion();

        void onStart(int i2);

        void xv(int i2);
    }

    static /* synthetic */ void C(OnlineVideoView onlineVideoView) {
        AppMethodBeat.i(203348);
        onlineVideoView.fgm();
        AppMethodBeat.o(203348);
    }

    static /* synthetic */ void E(OnlineVideoView onlineVideoView) {
        AppMethodBeat.i(203350);
        onlineVideoView.fgp();
        AppMethodBeat.o(203350);
    }

    static /* synthetic */ void G(OnlineVideoView onlineVideoView) {
        AppMethodBeat.i(203351);
        onlineVideoView.cWZ();
        AppMethodBeat.o(203351);
    }

    static /* synthetic */ void b(OnlineVideoView onlineVideoView, int i2) {
        AppMethodBeat.i(203346);
        onlineVideoView.ZA(i2);
        AppMethodBeat.o(203346);
    }

    static /* synthetic */ void b(OnlineVideoView onlineVideoView, int i2, boolean z) {
        AppMethodBeat.i(203347);
        onlineVideoView.aV(i2, z);
        AppMethodBeat.o(203347);
    }

    static /* synthetic */ void t(OnlineVideoView onlineVideoView) {
        AppMethodBeat.i(203342);
        onlineVideoView.d(true, 1.0f);
        AppMethodBeat.o(203342);
    }

    static /* synthetic */ void u(OnlineVideoView onlineVideoView) {
        AppMethodBeat.i(203343);
        onlineVideoView.hideLoading();
        AppMethodBeat.o(203343);
    }

    public OnlineVideoView(Context context) {
        this(context, null);
    }

    public OnlineVideoView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public OnlineVideoView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(98060);
        this.TAG = "MicroMsg.OnlineVideoView[" + hashCode() + ']';
        this.EtH = 0;
        this.isPreview = false;
        this.tmZ = false;
        this.guh = false;
        this.ebR = null;
        this.EtJ = false;
        this.EtL = null;
        this.EtN = false;
        this.duration = 0;
        this.EtO = 0;
        this.EtP = 0;
        this.EtQ = 0;
        this.EtR = 0;
        this.tnb = 0;
        this.pNk = null;
        this.EtS = true;
        this.qaC = new MMHandler(Looper.getMainLooper());
        this.scene = 0;
        this.EtT = 0;
        this.sessionId = "";
        this.dRS = "";
        this.filePath = "";
        this.videoWidth = 0;
        this.videoHeight = 0;
        this.isInit = false;
        this.EtU = false;
        this.EtW = false;
        this.Ehq = new MTimerHandler(new MTimerHandler.CallBack() {
            /* class com.tencent.mm.plugin.sns.ui.OnlineVideoView.AnonymousClass18 */

            @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
            public final boolean onTimerExpired() {
                boolean z;
                AppMethodBeat.i(98059);
                if (OnlineVideoView.this.EtL == null || OnlineVideoView.this.qbJ == null) {
                    AppMethodBeat.o(98059);
                    return false;
                }
                if (((View) OnlineVideoView.this.qbJ).getAlpha() < 1.0f) {
                    Log.i(OnlineVideoView.this.TAG, "onlineVideoTimer switchVideoModel");
                    OnlineVideoView.t(OnlineVideoView.this);
                }
                if (OnlineVideoView.this.qbJ.isPlaying()) {
                    OnlineVideoView.u(OnlineVideoView.this);
                }
                try {
                    if (!Util.isNullOrNil(OnlineVideoView.this.EtL.jpT)) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (!z) {
                        AppMethodBeat.o(98059);
                        return false;
                    }
                    int currentPosition = OnlineVideoView.this.qbJ.getCurrentPosition() / 1000;
                    OnlineVideoView.this.Zz(currentPosition);
                    boolean ub = OnlineVideoView.this.EtL.ub(currentPosition);
                    AppMethodBeat.o(98059);
                    return ub;
                } catch (Exception e2) {
                    Log.e(OnlineVideoView.this.TAG, "online video timer check error : " + e2.toString());
                    AppMethodBeat.o(98059);
                    return false;
                }
            }
        }, true);
        this.qbP = new MTimerHandler(new MTimerHandler.CallBack() {
            /* class com.tencent.mm.plugin.sns.ui.OnlineVideoView.AnonymousClass2 */

            @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
            public final boolean onTimerExpired() {
                AppMethodBeat.i(203320);
                if (OnlineVideoView.this.qbJ == null) {
                    AppMethodBeat.o(203320);
                    return false;
                }
                if (((View) OnlineVideoView.this.qbJ).getAlpha() < 1.0f) {
                    Log.i(OnlineVideoView.this.TAG, "offlineVideoTimer switchVideoModel");
                    OnlineVideoView.t(OnlineVideoView.this);
                }
                if (OnlineVideoView.this.qbJ.isPlaying()) {
                    OnlineVideoView.u(OnlineVideoView.this);
                    OnlineVideoView.this.Zz(OnlineVideoView.this.qbJ.getCurrentPosition() / 1000);
                }
                AppMethodBeat.o(203320);
                return true;
            }
        }, true);
        this.EtX = new c.b() {
            /* class com.tencent.mm.plugin.sns.ui.OnlineVideoView.AnonymousClass3 */

            {
                AppMethodBeat.i(160700);
                AppMethodBeat.o(160700);
            }

            @Override // com.tencent.mm.plugin.sns.model.c.b
            public final void aOG(String str) {
            }

            @Override // com.tencent.mm.plugin.sns.model.c.b
            public final void ci(String str, boolean z) {
            }

            @Override // com.tencent.mm.plugin.sns.model.c.b
            public final void eZJ() {
            }

            @Override // com.tencent.mm.plugin.sns.model.c.b
            public final void cj(final String str, final boolean z) {
                AppMethodBeat.i(203322);
                OnlineVideoView.this.qaC.postDelayed(new Runnable() {
                    /* class com.tencent.mm.plugin.sns.ui.OnlineVideoView.AnonymousClass3.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(203321);
                        Log.i(OnlineVideoView.this.TAG, "%d weixin download finish[%b], go to prepare video", Integer.valueOf(OnlineVideoView.this.hashCode()), Boolean.valueOf(z));
                        if (OnlineVideoView.this.ebR != null && z && Util.isEqual(OnlineVideoView.this.ebR.Id, str)) {
                            ay.kk(OnlineVideoView.this.dJX, "");
                            String a2 = ay.a(OnlineVideoView.this.dJX, OnlineVideoView.this.ebR);
                            if (!Util.isNullOrNil(a2)) {
                                OnlineVideoView.this.cq(a2, false);
                            }
                        }
                        AppMethodBeat.o(203321);
                    }
                }, 100);
                AppMethodBeat.o(203322);
            }
        };
        this.EtY = new IListener<wn>() {
            /* class com.tencent.mm.plugin.sns.ui.OnlineVideoView.AnonymousClass4 */

            {
                AppMethodBeat.i(160701);
                this.__eventId = wn.class.getName().hashCode();
                AppMethodBeat.o(160701);
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
            @Override // com.tencent.mm.sdk.event.IListener
            public final /* synthetic */ boolean callback(wn wnVar) {
                AppMethodBeat.i(98045);
                wn wnVar2 = wnVar;
                Log.i(OnlineVideoView.this.TAG, "%d sns video menu event local id[%s, %s], enable:%s", Integer.valueOf(OnlineVideoView.this.hashCode()), wnVar2.ecy.dJX, OnlineVideoView.this.dJX, Boolean.valueOf(OnlineVideoView.this.EtW));
                if (!Util.isEqual(wnVar2.ecy.dJX, OnlineVideoView.this.dJX) || !OnlineVideoView.this.EtW) {
                    AppMethodBeat.o(98045);
                } else {
                    if (wnVar2.ecy.dKy == 1) {
                        OnlineVideoView.a(OnlineVideoView.this, wnVar2.ecy.ecB);
                    } else if (wnVar2.ecy.dKy == 2) {
                        OnlineVideoView.a(OnlineVideoView.this, wnVar2.ecy.ecz, wnVar2.ecy.ecA);
                    } else if (wnVar2.ecy.dKy == 3) {
                        OnlineVideoView.v(OnlineVideoView.this);
                    }
                    AppMethodBeat.o(98045);
                }
                return false;
            }
        };
        this.EtZ = new IListener<vm>() {
            /* class com.tencent.mm.plugin.sns.ui.OnlineVideoView.AnonymousClass5 */

            {
                AppMethodBeat.i(160702);
                this.__eventId = vm.class.getName().hashCode();
                AppMethodBeat.o(160702);
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
            @Override // com.tencent.mm.sdk.event.IListener
            public final /* synthetic */ boolean callback(vm vmVar) {
                AppMethodBeat.i(98047);
                final vm vmVar2 = vmVar;
                Log.i(OnlineVideoView.this.TAG, "%d sns flip ui event. local id[%s, %s] opcode %d hadUiEvent %b", Integer.valueOf(OnlineVideoView.this.hashCode()), vmVar2.ebJ.dJX, OnlineVideoView.this.dJX, Integer.valueOf(vmVar2.ebJ.dKy), Boolean.valueOf(OnlineVideoView.this.EtN));
                if (vmVar2.ebJ.dKy == 2) {
                    if (vmVar2.ebJ.context != null && vmVar2.ebJ.context == OnlineVideoView.this.mContext) {
                        OnlineVideoView.this.EtN = false;
                        OnlineVideoView.this.fgi();
                        OnlineVideoView.this.onDestroy();
                    }
                    AppMethodBeat.o(98047);
                } else {
                    if (vmVar2.ebJ.dKy == 1) {
                        OnlineVideoView.this.qaC.post(new Runnable() {
                            /* class com.tencent.mm.plugin.sns.ui.OnlineVideoView.AnonymousClass5.AnonymousClass1 */

                            public final void run() {
                                AppMethodBeat.i(203323);
                                if (!Util.isEqual(vmVar2.ebJ.dJX, OnlineVideoView.this.dJX)) {
                                    OnlineVideoView.this.EtN = false;
                                    OnlineVideoView.this.fgi();
                                    OnlineVideoView.this.onDestroy();
                                    AppMethodBeat.o(203323);
                                } else if (!OnlineVideoView.this.EtN) {
                                    OnlineVideoView.this.EtN = true;
                                    OnlineVideoView.this.onResume();
                                    AppMethodBeat.o(203323);
                                } else {
                                    OnlineVideoView.this.requestLayout();
                                    AppMethodBeat.o(203323);
                                }
                            }
                        });
                    }
                    AppMethodBeat.o(98047);
                }
                return false;
            }
        };
        this.DOo = new IListener<oq>() {
            /* class com.tencent.mm.plugin.sns.ui.OnlineVideoView.AnonymousClass6 */

            {
                AppMethodBeat.i(203324);
                this.__eventId = oq.class.getName().hashCode();
                AppMethodBeat.o(203324);
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
            @Override // com.tencent.mm.sdk.event.IListener
            public final /* synthetic */ boolean callback(oq oqVar) {
                AppMethodBeat.i(203326);
                boolean a2 = a(oqVar);
                AppMethodBeat.o(203326);
                return a2;
            }

            private boolean a(oq oqVar) {
                AppMethodBeat.i(203325);
                if (OnlineVideoView.this.EtL == null) {
                    Log.w(OnlineVideoView.this.TAG, "%d online video helper is null.", Integer.valueOf(OnlineVideoView.this.hashCode()));
                    AppMethodBeat.o(203325);
                } else {
                    Log.w(OnlineVideoView.this.TAG, "OnlineVideoEvent is received, the OnlineVideoEvent opcode is " + oqVar.dUF.dKy);
                    Log.w(OnlineVideoView.this.TAG, "OnlineVideoEvent is received, the OnlineVideoEvent length is " + oqVar.dUF.length);
                    Log.w(OnlineVideoView.this.TAG, "OnlineVideoEvent is received, the OnlineVideoEvent offset is " + oqVar.dUF.offset);
                    Log.w(OnlineVideoView.this.TAG, "OnlineVideoEvent is received, the OnlineVideoEvent mediaId is " + oqVar.dUF.mediaId);
                    Log.w(OnlineVideoView.this.TAG, "OnlineVideoEvent is received, the OnlineVideoEvent retCode is " + oqVar.dUF.retCode);
                    Log.w(OnlineVideoView.this.TAG, "OnlineVideoEvent is received, the OnlineVideoEvent startDownload is " + oqVar.dUF.dUG);
                    try {
                        if (!OnlineVideoView.this.EtL.aQW(oqVar.dUF.mediaId)) {
                            AppMethodBeat.o(203325);
                        } else if (oqVar.dUF.retCode == -21112) {
                            OnlineVideoView onlineVideoView = OnlineVideoView.this;
                            h.INSTANCE.idkeyStat(354, 218, 1, false);
                            onlineVideoView.qaC.post(new Runnable() {
                                /* class com.tencent.mm.plugin.sns.ui.OnlineVideoView.AnonymousClass10 */

                                public final void run() {
                                    AppMethodBeat.i(203329);
                                    Log.w(OnlineVideoView.this.TAG, "%d deal sns video change isOnlinePlay[%b]", Integer.valueOf(OnlineVideoView.this.hashCode()), Boolean.valueOf(OnlineVideoView.this.EtM));
                                    if (OnlineVideoView.this.EtM) {
                                        OnlineVideoView.E(OnlineVideoView.this);
                                        OnlineVideoView.this.qbJ.stop();
                                        OnlineVideoView.this.fgc();
                                        String E = ay.E(OnlineVideoView.this.ebR);
                                        boolean deleteFile = s.deleteFile(E);
                                        if (OnlineVideoView.this.EtL != null) {
                                            OnlineVideoView.this.EtL.fgw();
                                            OnlineVideoView.this.EtL.clear();
                                            OnlineVideoView.this.EtL = new an(OnlineVideoView.this);
                                        }
                                        Log.i(OnlineVideoView.this.TAG, "%d delete video file[%b] [%s]", Integer.valueOf(OnlineVideoView.this.hashCode()), Boolean.valueOf(deleteFile), E);
                                        OnlineVideoView.this.EtP = 0;
                                        OnlineVideoView.G(OnlineVideoView.this);
                                    }
                                    AppMethodBeat.o(203329);
                                }
                            });
                            AppMethodBeat.o(203325);
                        } else if (oqVar.dUF.retCode == 0 || oqVar.dUF.retCode == -21006) {
                            switch (oqVar.dUF.dKy) {
                                case 1:
                                    an anVar = OnlineVideoView.this.EtL;
                                    long j2 = (long) oqVar.dUF.offset;
                                    long j3 = oqVar.dUF.dUG;
                                    boolean z = oqVar.dUF.dUH;
                                    Log.i(anVar.TAG, "deal moov ready moovPos %d, timeDuration %d, cdnMediaId %s startDownload[%d %d]", Long.valueOf(j2), Integer.valueOf(anVar.jpY), anVar.jpT, Long.valueOf(j3), Long.valueOf(anVar.gqR));
                                    if (anVar.jpY != 0) {
                                        Log.w(anVar.TAG, "moov had callback, do nothing.");
                                    } else {
                                        if (j3 <= anVar.gqR) {
                                            j3 = anVar.gqR;
                                        }
                                        anVar.gqR = j3;
                                        anVar.Eut = Util.nowMilliSecond();
                                        try {
                                            if (anVar.Eup == null) {
                                                Log.w(anVar.TAG, "parser is null, thread is error.");
                                            } else if (anVar.Eup.L(anVar.jpU, j2)) {
                                                anVar.jpY = anVar.Eup.jQw;
                                                Log.i(anVar.TAG, "mp4 parse moov success. duration %d cdnMediaId %s isFastStart %b", Integer.valueOf(anVar.jpY), anVar.jpT, Boolean.valueOf(z));
                                                if (!z) {
                                                    MMHandlerThread.postToMainThread(new Runnable() {
                                                        /* class com.tencent.mm.plugin.sns.ui.an.AnonymousClass1 */

                                                        public final void run() {
                                                            AppMethodBeat.i(98117);
                                                            if (!(an.this.Euq == null || !an.this.ub(0) || an.this.Euq == null)) {
                                                                an.this.fgB();
                                                                an.this.vm(true);
                                                                an.this.jqe = true;
                                                            }
                                                            AppMethodBeat.o(98117);
                                                        }
                                                    });
                                                }
                                                if (anVar.jpZ == -1) {
                                                    anVar.jpW = 1;
                                                } else {
                                                    anVar.jpW = 2;
                                                }
                                                h.INSTANCE.idkeyStat(354, 204, 1, false);
                                            } else {
                                                Log.w(anVar.TAG, "mp4 parse moov error. cdnMediaId %s", anVar.jpT);
                                                o.bhk();
                                                e.r(anVar.jpT, 0, -1);
                                                h.INSTANCE.idkeyStat(354, 205, 1, false);
                                                h.INSTANCE.a(13836, 402, Long.valueOf(Util.nowSecond()), "");
                                            }
                                        } catch (Exception e2) {
                                            Log.e(anVar.TAG, "deal moov ready error: " + e2.toString());
                                        }
                                    }
                                    OnlineVideoView.this.EtM = true;
                                    break;
                                case 2:
                                    an anVar2 = OnlineVideoView.this.EtL;
                                    String str = oqVar.dUF.mediaId;
                                    int i2 = oqVar.dUF.offset;
                                    int i3 = oqVar.dUF.length;
                                    anVar2.jqf = false;
                                    if (i2 < 0 || i3 < 0) {
                                        Log.w(anVar2.TAG, "deal data available error offset[%d], length[%d]", Integer.valueOf(i2), Integer.valueOf(i3));
                                    } else if (anVar2.aQW(str)) {
                                        Integer num = anVar2.Euo.get(anVar2.jpT + i2 + "_" + i3);
                                        if (num == null || num.intValue() <= 0) {
                                            try {
                                                anVar2.jqc = anVar2.Eup.dG(i2, i3);
                                            } catch (Exception e3) {
                                                Log.e(anVar2.TAG, "deal data available file pos to video time error: " + e3.toString());
                                            }
                                        } else {
                                            anVar2.jqc = num.intValue();
                                        }
                                        Log.i(anVar2.TAG, "deal data available. offset[%d] length[%d] cachePlayTime[%d]", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(anVar2.jqc));
                                    }
                                    if (oqVar.dUF.length > 0) {
                                        OnlineVideoView.this.fO(true);
                                        break;
                                    }
                                    break;
                                case 3:
                                    OnlineVideoView.this.fO(true);
                                    break;
                                case 4:
                                    Log.i(OnlineVideoView.this.TAG, "%d download finish. cdnMediaId %s sendReqCode %d favFromScene %d", Integer.valueOf(OnlineVideoView.this.hashCode()), oqVar.dUF.mediaId, Integer.valueOf(OnlineVideoView.this.ecB), Integer.valueOf(OnlineVideoView.this.ecz));
                                    an anVar3 = OnlineVideoView.this.EtL;
                                    Log.i(anVar3.TAG, "deal stream finish. playStatus %d cdnMediaId %s", Integer.valueOf(anVar3.jpW), anVar3.jpT);
                                    anVar3.jqf = false;
                                    anVar3.jpV = 3;
                                    h.INSTANCE.idkeyStat(354, 206, 1, false);
                                    if (anVar3.jpW == 0) {
                                        Log.w(anVar3.TAG, "it had not moov callback and download finish start to play video.");
                                        anVar3.fgy();
                                    } else if (anVar3.jpW == 5) {
                                        Log.w(anVar3.TAG, "it had play error, it request all video data finish, start to play." + anVar3.jpT);
                                        anVar3.fgy();
                                    }
                                    if (OnlineVideoView.this.ecB <= 0) {
                                        if (OnlineVideoView.this.ecz <= 0) {
                                            if (!OnlineVideoView.this.EtJ) {
                                                OnlineVideoView.this.fO(true);
                                                break;
                                            } else {
                                                OnlineVideoView.u(OnlineVideoView.this);
                                                OnlineVideoView.C(OnlineVideoView.this);
                                                break;
                                            }
                                        } else {
                                            OnlineVideoView.u(OnlineVideoView.this);
                                            OnlineVideoView.b(OnlineVideoView.this, OnlineVideoView.this.ecz, OnlineVideoView.this.ecA);
                                            break;
                                        }
                                    } else {
                                        OnlineVideoView.u(OnlineVideoView.this);
                                        OnlineVideoView.b(OnlineVideoView.this, OnlineVideoView.this.ecB);
                                        break;
                                    }
                                case 5:
                                    if (OnlineVideoView.this.EtH != 1) {
                                        if (OnlineVideoView.this.EtH == 2) {
                                            OnlineVideoView.a(OnlineVideoView.this, oqVar.dUF.offset, oqVar.dUF.length);
                                            break;
                                        }
                                    } else {
                                        an anVar4 = OnlineVideoView.this.EtL;
                                        String str2 = oqVar.dUF.mediaId;
                                        int i4 = oqVar.dUF.offset;
                                        int i5 = oqVar.dUF.length;
                                        if (anVar4.aQW(str2)) {
                                            anVar4.progress = i4;
                                            anVar4.jcu = i5;
                                            anVar4.Eur = (anVar4.progress * 100) / anVar4.jcu;
                                            Log.i(anVar4.TAG, "deal video[%s] progress callback[%d, %d]. downloadedPercent[%d]", anVar4.jpT, Integer.valueOf(anVar4.progress), Integer.valueOf(anVar4.jcu), Integer.valueOf(anVar4.Eur));
                                        }
                                        if (anVar4.Eur >= 100) {
                                            anVar4.jpV = 3;
                                            break;
                                        }
                                    }
                                    break;
                                case 6:
                                    an anVar5 = OnlineVideoView.this.EtL;
                                    Log.i(anVar5.TAG, "deal had dup video. cdnMediaId %s", anVar5.jpT);
                                    anVar5.fgy();
                                    break;
                                default:
                                    Log.w(OnlineVideoView.this.TAG, "%d unknown event opcode %d", Integer.valueOf(OnlineVideoView.this.hashCode()), Integer.valueOf(oqVar.dUF.dKy));
                                    break;
                            }
                            AppMethodBeat.o(203325);
                        } else {
                            Log.w(OnlineVideoView.this.TAG, "%d stream download online video error. retCode %d ", Integer.valueOf(OnlineVideoView.this.hashCode()), Integer.valueOf(oqVar.dUF.retCode));
                            AppMethodBeat.o(203325);
                        }
                    } catch (Exception e4) {
                        Log.e(OnlineVideoView.this.TAG, "online video callback error: " + e4.toString());
                    }
                }
                return false;
            }
        };
        this.EtE = new j.e() {
            /* class com.tencent.mm.plugin.sns.ui.OnlineVideoView.AnonymousClass7 */

            @Override // com.tencent.mm.pluginsdk.ui.tools.j.e
            public final void bLh() {
                AppMethodBeat.i(203327);
                Log.i(OnlineVideoView.this.TAG, "%d on texture update.", Integer.valueOf(OnlineVideoView.this.hashCode()));
                try {
                    OnlineVideoView.t(OnlineVideoView.this);
                    AppMethodBeat.o(203327);
                } catch (Exception e2) {
                    Log.e(OnlineVideoView.this.TAG, "texture view update. error " + e2.toString());
                    AppMethodBeat.o(203327);
                }
            }
        };
        this.zrF = new b() {
            /* class com.tencent.mm.plugin.sns.ui.OnlineVideoView.AnonymousClass8 */

            @Override // com.tencent.mm.plugin.n.b
            public final long eja() {
                AppMethodBeat.i(203328);
                Log.i(OnlineVideoView.this.TAG, "%d sns video get online cache", Integer.valueOf(OnlineVideoView.this.hashCode()));
                g.aAi();
                g.aAh().azQ().set(ar.a.USERINFO_VIDEO_NEED_RESET_EXTRACTOR_BOOLEAN, Boolean.TRUE);
                try {
                    if (OnlineVideoView.this.EtM && OnlineVideoView.this.EtL != null) {
                        long j2 = (long) OnlineVideoView.this.EtL.jqc;
                        AppMethodBeat.o(203328);
                        return j2;
                    }
                } catch (Exception e2) {
                }
                AppMethodBeat.o(203328);
                return 0;
            }
        };
        this.Eue = true;
        this.mContext = context;
        Log.i(this.TAG, "%d ui init view.", Integer.valueOf(hashCode()));
        LayoutInflater.from(context).inflate(R.layout.by6, this);
        this.tiQ = (ImageView) findViewById(R.id.j6m);
        this.tjk = (RelativeLayout) findViewById(R.id.j6e);
        this.hPF = (TextView) findViewById(R.id.j4l);
        this.hPF.setVisibility(8);
        this.tne = (MMPinProgressBtn) findViewById(R.id.j62);
        this.mEz = (ProgressBar) findViewById(R.id.j59);
        this.tmU = (TextView) findViewById(R.id.j6r);
        com.tencent.mm.modelcontrol.e.baZ();
        if (com.tencent.mm.modelcontrol.e.bbm()) {
            this.tna = true;
            this.qbJ = new VideoPlayerTextureView(context);
            ((VideoPlayerTextureView) this.qbJ).setIOnlineCache(this.zrF);
            ((VideoPlayerTextureView) this.qbJ).setOpenWithNoneSurface(true);
            h.INSTANCE.idkeyStat(354, 148, 1, false);
        } else {
            this.tna = false;
            this.qbJ = new VideoTextureView(context);
            h.INSTANCE.idkeyStat(354, 149, 1, false);
        }
        this.qbJ.setVideoCallback(this);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(13);
        this.tjk.addView((View) this.qbJ, layoutParams);
        Log.i(this.TAG, "%d switch sync video model isVideoPlay %b %f", Integer.valueOf(hashCode()), Boolean.FALSE, Float.valueOf(0.0f));
        this.tjk.setVisibility(8);
        ((View) this.qbJ).setVisibility(8);
        if (this.Eue) {
            this.tiQ.setVisibility(0);
        }
        AppMethodBeat.o(98060);
    }

    private synchronized void unInit() {
        AppMethodBeat.i(98061);
        if (!this.isInit) {
            AppMethodBeat.o(98061);
        } else {
            this.isInit = false;
            Log.i(this.TAG, "%d logic unInit", Integer.valueOf(hashCode()));
            fgp();
            fgr();
            this.qbJ.stop();
            EventCenter.instance.removeListener(this.DOo);
            EventCenter.instance.removeListener(this.EtY);
            aj.faJ().b(this.EtX);
            fgc();
            this.qaC.removeCallbacksAndMessages(null);
            if (this.EtL != null) {
                this.EtL.fgw();
                this.EtL.clear();
            }
            if (com.tencent.mm.q.a.Xi() != null) {
                com.tencent.mm.q.a.Xi().akq();
            }
            if (this.pNk != null) {
                this.pNk.fp(false);
            }
            this.pNk = null;
            this.ebR = null;
            this.dJX = null;
            this.EtL = null;
            this.EtP = 0;
            AppMethodBeat.o(98061);
        }
    }

    public final void fgg() {
        this.EtS = false;
    }

    public final void abandonAudioFocus() {
        AppMethodBeat.i(98062);
        if (this.pNk != null) {
            this.pNk.fp(false);
        }
        AppMethodBeat.o(98062);
    }

    public final void fgh() {
        AppMethodBeat.i(98063);
        Log.d(this.TAG, "%d register sns ui event", Integer.valueOf(hashCode()));
        EventCenter.instance.addListener(this.EtZ);
        AppMethodBeat.o(98063);
    }

    public final void fgi() {
        AppMethodBeat.i(98064);
        Log.d(this.TAG, "%d unRegister sns ui event", Integer.valueOf(hashCode()));
        EventCenter.instance.removeListener(this.EtZ);
        AppMethodBeat.o(98064);
    }

    public final void a(cnb cnb, String str, int i2) {
        AppMethodBeat.i(98065);
        this.dJX = str;
        this.iXu = i2;
        bp gCZ = bp.gCZ();
        gCZ.hXs = this.iXu;
        this.DEv = gCZ;
        if (this.ebR != cnb) {
            this.ebR = cnb;
            fgk();
        }
        this.isPreview = false;
        Log.i(this.TAG, "%d set video data[%s, %d] isPreview %b self %s", Integer.valueOf(hashCode()), this.dJX, Integer.valueOf(this.iXu), Boolean.valueOf(this.isPreview), this);
        AppMethodBeat.o(98065);
    }

    public final String fgj() {
        AppMethodBeat.i(98066);
        StringBuffer stringBuffer = new StringBuffer();
        try {
            if (this.ebR != null) {
                stringBuffer.append("media: " + this.ebR.Id);
            }
            if (this.dJX != null) {
                stringBuffer.append("localId: " + this.dJX);
            }
        } catch (Exception e2) {
            Log.printErrStackTrace(this.TAG, e2, "", new Object[0]);
        }
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(98066);
        return stringBuffer2;
    }

    public void setVideoCallback(a aVar) {
        this.EtK = aVar;
    }

    public void setMute(boolean z) {
        AppMethodBeat.i(98067);
        this.guh = z;
        this.qbJ.setMute(this.guh);
        AppMethodBeat.o(98067);
    }

    private void fgk() {
        AppMethodBeat.i(203335);
        int i2 = R.drawable.ban;
        if (this.ebR != null && this.ebR.isAd) {
            Log.i(this.TAG, "the media is ad, the background should be transparent");
            i2 = R.drawable.b0w;
        }
        boolean b2 = aj.faL().b(this.ebR, this.tiQ, i2, this.mContext.hashCode(), this.DEv);
        Log.i(this.TAG, "%d fresh thumb image %b", Integer.valueOf(hashCode()), Boolean.valueOf(b2));
        AppMethodBeat.o(203335);
    }

    public void onResume() {
        AppMethodBeat.i(98068);
        Log.d(this.TAG, "%d on resume %s", Integer.valueOf(hashCode()), Util.getStack());
        this.EtQ = Util.nowMilliSecond();
        if (this.EtU) {
            Log.e(this.TAG, "what are you doing guys!!! Would you like to invite everyone to eat pizza??? %s", Util.getStack());
            h.INSTANCE.n(31, 3, 1);
        } else if (this.EtL == null) {
            this.isInit = true;
            Log.i(this.TAG, "%d logic init, create new helper and add listener.", Integer.valueOf(hashCode()));
            this.EtL = new an(this);
            Log.i(this.TAG, "onlineVideoHelper hash:%d", Integer.valueOf(this.EtL.hashCode()));
            EventCenter.instance.addListener(this.DOo);
            EventCenter.instance.addListener(this.EtY);
            aj.faJ().a(this.EtX);
            if (this.EtS) {
                this.pNk = new d();
                this.pNk.a(this);
            }
            if (com.tencent.mm.q.a.Xi() != null) {
                com.tencent.mm.q.a.Xi().akr();
            }
        }
        if (!this.tmZ) {
            cWZ();
        }
        this.Etz = true;
        AppMethodBeat.o(98068);
    }

    public final void onPause() {
        AppMethodBeat.i(98069);
        Log.d(this.TAG, "%d on pause %s ", Integer.valueOf(hashCode()), Util.getStack());
        fgc();
        if (this.qbJ != null) {
            this.qbJ.stop();
        }
        AppMethodBeat.o(98069);
    }

    public void onDestroy() {
        AppMethodBeat.i(98070);
        Log.d(this.TAG, "%d on destroy %s", Integer.valueOf(hashCode()), Util.getStack());
        this.EtR = Util.nowMilliSecond();
        unInit();
        AppMethodBeat.o(98070);
    }

    private void ZA(int i2) {
        AppMethodBeat.i(98071);
        String str = com.tencent.mm.plugin.sns.model.ar.ki(aj.getAccSnsPath(), this.ebR.Id) + r.e(this.ebR);
        Intent intent = new Intent();
        intent.putExtra("Select_Conv_Type", 3);
        intent.putExtra("select_is_ret", true);
        intent.putExtra("mutil_select_is_ret", true);
        intent.putExtra("image_path", str);
        intent.putExtra("Retr_Msg_Type", 11);
        Log.i(this.TAG, "send video path %s reqCode %d", str, Integer.valueOf(i2));
        com.tencent.mm.br.c.c(getActivityContext(), ".ui.transmit.SelectConversationUI", intent, i2);
        this.ecB = 0;
        AppMethodBeat.o(98071);
    }

    /* access modifiers changed from: protected */
    public Context getActivityContext() {
        if (this.EtV == null) {
            return this.mContext;
        }
        return this.EtV;
    }

    public final void aM(Activity activity) {
        this.EtV = activity;
        this.EtW = true;
    }

    public final void fgl() {
        this.EtV = null;
        this.EtW = false;
    }

    private void aV(final int i2, final boolean z) {
        AppMethodBeat.i(98072);
        this.qaC.post(new Runnable() {
            /* class com.tencent.mm.plugin.sns.ui.OnlineVideoView.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(98040);
                SnsInfo aQm = aj.faO().aQm(OnlineVideoView.this.dJX);
                if (aQm == null) {
                    AppMethodBeat.o(98040);
                    return;
                }
                Log.i(OnlineVideoView.this.TAG, "fav download video[%s] farFromScene %d isFromMain %b", OnlineVideoView.this.dJX, Integer.valueOf(i2), Boolean.valueOf(z));
                cz czVar = new cz();
                czVar.dFZ.dGf = i2;
                czVar.dFZ.activity = (Activity) OnlineVideoView.this.getActivityContext();
                com.tencent.mm.plugin.sns.l.a.a(czVar, aQm);
                EventCenter.instance.publish(czVar);
                if (czVar.dGa.ret == 0) {
                    OnlineVideoView.fgs();
                } else {
                    OnlineVideoView.fgt();
                }
                if (z) {
                    vj vjVar = new vj();
                    vjVar.ebG.dHp = aQm.getLocalid();
                    vjVar.ebG.dRS = r.v(aQm);
                    EventCenter.instance.publish(vjVar);
                }
                OnlineVideoView.this.ecz = 0;
                if (OnlineVideoView.this.qbJ != null) {
                    if (Util.isNullOrNil(OnlineVideoView.this.qbJ.getVideoPath())) {
                        Log.i(OnlineVideoView.this.TAG, "%d had not set video path to play", Integer.valueOf(OnlineVideoView.this.hashCode()));
                        String a2 = ay.a(OnlineVideoView.this.dJX, OnlineVideoView.this.ebR);
                        if (!Util.isNullOrNil(a2)) {
                            OnlineVideoView.this.cq(a2, false);
                        }
                        AppMethodBeat.o(98040);
                        return;
                    } else if (!OnlineVideoView.this.qbJ.isPlaying()) {
                        OnlineVideoView.this.qbJ.start();
                        AppMethodBeat.o(98040);
                        return;
                    }
                }
                AppMethodBeat.o(98040);
            }
        });
        AppMethodBeat.o(98072);
    }

    private void fgm() {
        AppMethodBeat.i(98073);
        p.a(getContext(), new android.support.v4.e.c<Boolean>() {
            /* class com.tencent.mm.plugin.sns.ui.OnlineVideoView.AnonymousClass11 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // android.support.v4.e.c
            public final /* synthetic */ void accept(Boolean bool) {
                AppMethodBeat.i(203333);
                Boolean bool2 = bool;
                final String a2 = ay.a(OnlineVideoView.this.dJX, OnlineVideoView.this.ebR);
                if (!bool2.booleanValue() || TextUtils.isEmpty(a2)) {
                    Toast.makeText(OnlineVideoView.this.mContext, OnlineVideoView.this.mContext.getString(R.string.hwt), 1).show();
                    OnlineVideoView.fgu();
                    Log.w(OnlineVideoView.this.TAG, hashCode() + " save downloaded video fail, granted = " + bool2 + ", fullPath = " + a2);
                    OnlineVideoView.this.EtJ = false;
                    AppMethodBeat.o(203333);
                    return;
                }
                final AnonymousClass1 r5 = new Runnable() {
                    /* class com.tencent.mm.plugin.sns.ui.OnlineVideoView.AnonymousClass11.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(203330);
                        if (OnlineVideoView.this.qbJ != null) {
                            if (Util.isNullOrNil(OnlineVideoView.this.qbJ.getVideoPath())) {
                                Log.i(OnlineVideoView.this.TAG, "%d had not set video path to play", Integer.valueOf(OnlineVideoView.this.hashCode()));
                                String a2 = ay.a(OnlineVideoView.this.dJX, OnlineVideoView.this.ebR);
                                if (!Util.isNullOrNil(a2)) {
                                    OnlineVideoView.this.cq(a2, false);
                                }
                                AppMethodBeat.o(203330);
                                return;
                            } else if (!OnlineVideoView.this.qbJ.isPlaying()) {
                                OnlineVideoView.this.qbJ.start();
                            }
                        }
                        AppMethodBeat.o(203330);
                    }
                };
                final long currentTicks = Util.currentTicks();
                p.b(OnlineVideoView.this.getContext(), a2, new p.a() {
                    /* class com.tencent.mm.plugin.sns.ui.OnlineVideoView.AnonymousClass11.AnonymousClass2 */

                    @Override // com.tencent.mm.platformtools.p.a
                    public final void bP(String str, String str2) {
                        AppMethodBeat.i(203331);
                        Toast.makeText(OnlineVideoView.this.getContext(), OnlineVideoView.this.getContext().getString(R.string.hwu, AndroidMediaUtil.getFriendlySdcardPath(str2)), 1).show();
                        AndroidMediaUtil.refreshMediaScanner(str2, OnlineVideoView.this.getContext());
                        OnlineVideoView.fgv();
                        OnlineVideoView.i(OnlineVideoView.this);
                        OnlineVideoView.this.EtJ = false;
                        Log.i(OnlineVideoView.this.TAG, "%d save downloaded video finish %d %s", Integer.valueOf(hashCode()), Long.valueOf(Util.ticksToNow(currentTicks)), a2);
                        OnlineVideoView.this.qaC.post(r5);
                        AppMethodBeat.o(203331);
                    }

                    @Override // com.tencent.mm.platformtools.p.a
                    public final void bQ(String str, String str2) {
                        AppMethodBeat.i(203332);
                        Toast.makeText(OnlineVideoView.this.getContext(), OnlineVideoView.this.getContext().getString(R.string.hwt), 1).show();
                        OnlineVideoView.fgu();
                        OnlineVideoView.this.EtJ = false;
                        Log.w(OnlineVideoView.this.TAG, "%d save downloaded video finish %d %s", Integer.valueOf(hashCode()), Long.valueOf(Util.ticksToNow(currentTicks)), a2);
                        OnlineVideoView.this.qaC.post(r5);
                        AppMethodBeat.o(203332);
                    }
                });
                AppMethodBeat.o(203333);
            }
        });
        AppMethodBeat.o(98073);
    }

    private void d(final boolean z, final float f2) {
        AppMethodBeat.i(98074);
        this.qaC.post(new Runnable() {
            /* class com.tencent.mm.plugin.sns.ui.OnlineVideoView.AnonymousClass13 */

            public final void run() {
                AppMethodBeat.i(98054);
                Log.i(OnlineVideoView.this.TAG, "%d switch video model isVideoPlay %b %f", Integer.valueOf(OnlineVideoView.this.hashCode()), Boolean.valueOf(z), Float.valueOf(f2));
                View view = (View) OnlineVideoView.this.qbJ;
                if (z) {
                    OnlineVideoView.this.tjk.setAlpha(f2);
                    OnlineVideoView.this.tjk.setVisibility(0);
                    view.setAlpha(f2);
                    view.setVisibility(0);
                    if (((double) f2) >= 1.0d) {
                        OnlineVideoView.this.tiQ.setVisibility(8);
                        AppMethodBeat.o(98054);
                        return;
                    }
                } else {
                    OnlineVideoView.this.tjk.setVisibility(8);
                    view.setVisibility(8);
                    if (OnlineVideoView.this.Eue) {
                        OnlineVideoView.this.tiQ.setVisibility(0);
                    }
                }
                AppMethodBeat.o(98054);
            }
        });
        AppMethodBeat.o(98074);
    }

    private void cWZ() {
        String str;
        AppMethodBeat.i(98075);
        if (!this.isPreview) {
            str = ay.a(this.dJX, this.ebR);
        } else {
            str = this.EtI;
        }
        Log.i(this.TAG, "%d toggleVideo local id %s finish path %s isPreview %b", Integer.valueOf(hashCode()), this.dJX, str, Boolean.valueOf(this.isPreview));
        if (!Util.isNullOrNil(str)) {
            Log.i(this.TAG, "%d sns video already download finish, play now", Integer.valueOf(hashCode()));
            d(true, 0.0f);
            cq(str, false);
            AppMethodBeat.o(98075);
            return;
        }
        d(false, 0.0f);
        W(false, 0);
        showLoading();
        AppMethodBeat.o(98075);
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0099  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x00c7  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void W(boolean r8, int r9) {
        /*
        // Method dump skipped, instructions count: 212
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.sns.ui.OnlineVideoView.W(boolean, int):void");
    }

    public int getDuration() {
        AppMethodBeat.i(98077);
        if (this.qbJ == null) {
            AppMethodBeat.o(98077);
            return 0;
        }
        int duration2 = this.qbJ.getDuration();
        AppMethodBeat.o(98077);
        return duration2;
    }

    public final void cXa() {
        AppMethodBeat.i(98078);
        if (this.qbJ.isPlaying()) {
            Log.i(this.TAG, "%d pause play", Integer.valueOf(hashCode()));
            fgp();
            fgr();
            this.qbJ.pause();
        }
        AppMethodBeat.o(98078);
    }

    private void showLoading() {
        AppMethodBeat.i(98079);
        this.qaC.post(new Runnable() {
            /* class com.tencent.mm.plugin.sns.ui.OnlineVideoView.AnonymousClass15 */

            public final void run() {
                AppMethodBeat.i(98056);
                Log.i(OnlineVideoView.this.TAG, "%d show loading. downloadMode %d", Integer.valueOf(OnlineVideoView.this.hashCode()), Integer.valueOf(OnlineVideoView.this.EtH));
                if (OnlineVideoView.this.EtH == 1) {
                    if (!(OnlineVideoView.this.mEz == null || OnlineVideoView.this.mEz.getVisibility() == 0)) {
                        OnlineVideoView.this.mEz.setVisibility(0);
                    }
                    if (!(OnlineVideoView.this.tne == null || OnlineVideoView.this.tne.getVisibility() == 8)) {
                        OnlineVideoView.this.tne.setVisibility(8);
                    }
                }
                if (OnlineVideoView.this.EtH == 2) {
                    if (!(OnlineVideoView.this.tne == null || OnlineVideoView.this.tne.getVisibility() == 0)) {
                        OnlineVideoView.this.tne.setVisibility(0);
                    }
                    if (!(OnlineVideoView.this.mEz == null || OnlineVideoView.this.mEz.getVisibility() == 8)) {
                        OnlineVideoView.this.mEz.setVisibility(8);
                    }
                }
                if (OnlineVideoView.this.EtH == 3) {
                    if (!(OnlineVideoView.this.tne == null || OnlineVideoView.this.tne.getVisibility() == 0)) {
                        OnlineVideoView.this.tne.setVisibility(0);
                        OnlineVideoView.this.tne.gYN();
                    }
                    if (!(OnlineVideoView.this.mEz == null || OnlineVideoView.this.mEz.getVisibility() == 8)) {
                        OnlineVideoView.this.mEz.setVisibility(8);
                    }
                }
                AppMethodBeat.o(98056);
            }
        });
        AppMethodBeat.o(98079);
    }

    private void hideLoading() {
        AppMethodBeat.i(98080);
        this.qaC.post(new Runnable() {
            /* class com.tencent.mm.plugin.sns.ui.OnlineVideoView.AnonymousClass16 */

            public final void run() {
                AppMethodBeat.i(98057);
                if (!(OnlineVideoView.this.mEz == null || OnlineVideoView.this.mEz.getVisibility() == 8)) {
                    Log.i(OnlineVideoView.this.TAG, "%d hide loading.", Integer.valueOf(OnlineVideoView.this.hashCode()));
                    OnlineVideoView.this.mEz.setVisibility(8);
                }
                if (!(OnlineVideoView.this.tne == null || OnlineVideoView.this.tne.getVisibility() == 8)) {
                    Log.i(OnlineVideoView.this.TAG, "%d hide progress.", Integer.valueOf(OnlineVideoView.this.hashCode()));
                    OnlineVideoView.this.tne.setVisibility(8);
                }
                AppMethodBeat.o(98057);
            }
        });
        AppMethodBeat.o(98080);
    }

    /* access modifiers changed from: protected */
    public final void fO(boolean z) {
        AppMethodBeat.i(98081);
        if (!this.EtM) {
            this.qbP.startTimer(500);
            AppMethodBeat.o(98081);
        } else if (z) {
            MMHandlerThread.postToMainThread(new Runnable() {
                /* class com.tencent.mm.plugin.sns.ui.OnlineVideoView.AnonymousClass17 */

                public final void run() {
                    AppMethodBeat.i(203334);
                    if (!(OnlineVideoView.this.qbJ == null || OnlineVideoView.this.EtL == null)) {
                        OnlineVideoView.this.EtL.ub(OnlineVideoView.this.qbJ.getCurrentPosition() / 1000);
                    }
                    OnlineVideoView.this.Ehq.startTimer(500);
                    AppMethodBeat.o(203334);
                }
            });
            AppMethodBeat.o(98081);
        } else {
            this.Ehq.startTimer(500);
            AppMethodBeat.o(98081);
        }
    }

    public final void fgc() {
        AppMethodBeat.i(98082);
        this.Ehq.stopTimer();
        this.qbP.stopTimer();
        AppMethodBeat.o(98082);
    }

    @Override // com.tencent.mm.pluginsdk.ui.tools.j.a
    public final void onError(int i2, int i3) {
        AppMethodBeat.i(98083);
        Log.e(this.TAG, "%d on play video error what %d extra %d. isOnlinePlay %b isMMVideoPlayer[%b]", Integer.valueOf(hashCode()), Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(this.EtM), Boolean.valueOf(this.tna));
        if (this.EtM) {
            h.INSTANCE.idkeyStat(354, 230, 1, false);
        } else {
            h.INSTANCE.idkeyStat(354, 231, 1, false);
        }
        this.tnb = i3;
        fgp();
        final String videoPath = this.qbJ.getVideoPath();
        this.EtO = this.qbJ.getCurrentPosition() / 1000;
        if (this.EtM) {
            if (i2 == -2) {
                this.qbJ.stop();
            } else if (i2 == -3) {
                this.EtP = i2;
                this.qbJ.pause();
            } else {
                fgc();
                this.qbJ.stop();
            }
            try {
                showLoading();
                if (this.EtL != null) {
                    an anVar = this.EtL;
                    String str = anVar.jpT + 0 + "_-1";
                    if (!anVar.Euo.containsKey(str)) {
                        Log.i(anVar.TAG, "request all data. [%s]", anVar.jpT);
                        o.bhk();
                        e.r(anVar.jpT, 0, -1);
                        anVar.Euo.put(str, 0);
                        h.INSTANCE.idkeyStat(354, 207, 1, false);
                        h.INSTANCE.a(13836, 403, Long.valueOf(Util.nowSecond()), "");
                    }
                    anVar.jpW = 5;
                    anVar.jqb = true;
                    anVar.jqe = false;
                }
                fgp();
            } catch (Exception e2) {
            }
        } else {
            this.qbJ.stop();
            this.tmZ = true;
            d(false, 0.0f);
            Log.w(this.TAG, "error %s, %s", Boolean.valueOf(this.EtW), videoPath);
            if (!Util.isNullOrNil(videoPath) && this.EtW) {
                Log.w(this.TAG, "%d start third player to play", Integer.valueOf(hashCode()));
                this.qaC.post(new Runnable() {
                    /* class com.tencent.mm.plugin.sns.ui.OnlineVideoView.AnonymousClass9 */

                    public final void run() {
                        AppMethodBeat.i(98051);
                        Intent intent = new Intent();
                        intent.setAction("android.intent.action.VIEW");
                        FileProviderHelper.setIntentDataAndType(OnlineVideoView.this.getContext(), intent, new com.tencent.mm.vfs.o(videoPath), "video/*", false);
                        try {
                            Context context = OnlineVideoView.this.getContext();
                            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                            com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/plugin/sns/ui/OnlineVideoView$17", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                            context.startActivity((Intent) bl.pG(0));
                            com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/plugin/sns/ui/OnlineVideoView$17", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                            AppMethodBeat.o(98051);
                        } catch (Exception e2) {
                            Log.e(OnlineVideoView.this.TAG, "startActivity fail, activity not found");
                            f.a aVar = new f.a(OnlineVideoView.this.getContext());
                            aVar.bow(OnlineVideoView.this.getContext().getString(R.string.caa));
                            aVar.aC(OnlineVideoView.this.getContext().getString(R.string.cab)).c(new f.c() {
                                /* class com.tencent.mm.plugin.sns.ui.OnlineVideoView.AnonymousClass9.AnonymousClass1 */

                                @Override // com.tencent.mm.ui.widget.a.f.c
                                public final void e(boolean z, String str) {
                                }
                            }).show();
                            AppMethodBeat.o(98051);
                        } catch (Throwable th) {
                            Log.e(OnlineVideoView.this.TAG, "showAlert fail");
                            AppMethodBeat.o(98051);
                        }
                    }
                });
            }
        }
        if (this.ebR != null && this.ebR.isAd) {
            h.INSTANCE.dN(1579, 8);
        }
        AppMethodBeat.o(98083);
    }

    @Override // com.tencent.mm.pluginsdk.ui.tools.j.a
    public final void tf() {
        AppMethodBeat.i(98084);
        Log.i(this.TAG, "%d onPrepared playErrorCode[%d] onErrorPlayTimeSec[%d]", Integer.valueOf(hashCode()), Integer.valueOf(this.tnb), Integer.valueOf(this.EtO));
        this.tnb = 0;
        if (this.EtO > 0) {
            aT(this.EtO, true);
            this.EtO = 0;
            AppMethodBeat.o(98084);
            return;
        }
        this.EtP = 0;
        hideLoading();
        fgo();
        fgq();
        this.qbJ.start();
        this.duration = this.qbJ.getDuration() / 1000;
        Log.i(this.TAG, "%d start play duration %d sns local id %s ", Integer.valueOf(hashCode()), Integer.valueOf(this.duration), this.dJX);
        fO(false);
        a aVar = this.EtK;
        if (aVar != null) {
            aVar.onStart(this.duration);
        }
        AppMethodBeat.o(98084);
    }

    @Override // com.tencent.mm.pluginsdk.ui.tools.j.a
    public final void onCompletion() {
        AppMethodBeat.i(98085);
        Log.i(this.TAG, "%d on completion", Integer.valueOf(hashCode()));
        a aVar = this.EtK;
        if (aVar != null) {
            aVar.onCompletion();
        } else if (com.tencent.mm.compatible.util.d.oF(18) || !this.tna) {
            aT(0, true);
            AppMethodBeat.o(98085);
            return;
        } else if (this.qbJ != null) {
            String videoPath = this.qbJ.getVideoPath();
            this.qbJ.stop();
            cq(videoPath, this.EtM);
            AppMethodBeat.o(98085);
            return;
        }
        AppMethodBeat.o(98085);
    }

    @Override // com.tencent.mm.pluginsdk.ui.tools.j.a
    public final int fh(int i2, int i3) {
        return 0;
    }

    @Override // com.tencent.mm.pluginsdk.ui.tools.j.a
    public final void eo(int i2, int i3) {
        this.videoWidth = i2;
        this.videoHeight = i3;
    }

    private boolean cXc() {
        AppMethodBeat.i(98086);
        if (!this.EtM) {
            AppMethodBeat.o(98086);
            return false;
        }
        g.aAi();
        boolean z = g.aAh().azQ().getBoolean(ar.a.USERINFO_VIDEO_NEED_RESET_EXTRACTOR_BOOLEAN, false);
        AppMethodBeat.o(98086);
        return z;
    }

    @Override // com.tencent.mm.plugin.sns.ui.an.a
    public final void cq(String str, boolean z) {
        AppMethodBeat.i(98087);
        Log.i(this.TAG, "%d prepare video isOnlinePlay %b filePath %s", Integer.valueOf(hashCode()), Boolean.valueOf(z), str);
        if (Util.isNullOrNil(str)) {
            Log.w(this.TAG, "%d prepare video but filepath is null.", Integer.valueOf(hashCode()));
            AppMethodBeat.o(98087);
            return;
        }
        this.EtM = z;
        if (this.qbJ != null) {
            if (this.EtP != -3) {
                if (this.qbJ instanceof VideoPlayerTextureView) {
                    ((VideoPlayerTextureView) this.qbJ).setNeedResetExtractor(cXc());
                    ((VideoPlayerTextureView) this.qbJ).setIsOnlineVideoType(z);
                }
                this.qbJ.setOneTimeVideoTextureUpdateCallback(this.EtE);
                MultiProcessMMKV mmkv = MultiProcessMMKV.getMMKV("TrackDataSource");
                mmkv.putString("media-url", this.ebR == null ? "" : this.ebR.Url);
                mmkv.putString("thumb-url", this.ebR == null ? "" : this.ebR.Msz);
                mmkv.putLong("prepare-ts", System.currentTimeMillis());
                mmkv.putString("prepare-path", str);
                mmkv.commit();
                this.qbJ.setVideoPath(str);
                d(true, 0.0f);
            } else {
                Log.i(this.TAG, "%d prepare video reset source", Integer.valueOf(hashCode()));
                if (this.qbJ instanceof VideoPlayerTextureView) {
                    ((VideoPlayerTextureView) this.qbJ).gsH();
                }
                aT(this.EtO, true);
            }
        }
        g.aAi();
        if (((Integer) g.aAh().azQ().get(ar.a.USERINFO_LOCAL_SIGHT_DEBUGINFO_INT_SYNC, (Object) 0)).intValue() == 1) {
            this.tmU.setText(com.tencent.mm.plugin.sight.base.e.aFm(str));
            this.tmU.setVisibility(0);
        }
        AppMethodBeat.o(98087);
    }

    @Override // com.tencent.mm.plugin.sns.ui.an.a
    public final boolean fgn() {
        boolean z = true;
        AppMethodBeat.i(98088);
        Log.i(this.TAG, "%d resumeByDataGain", Integer.valueOf(hashCode()));
        if (!this.qbJ.isPlaying()) {
            fgo();
            fgq();
            z = this.qbJ.start();
            hideLoading();
        }
        AppMethodBeat.o(98088);
        return z;
    }

    public void eYd() {
        AppMethodBeat.i(98089);
        if (!this.qbJ.isPlaying()) {
            fgq();
            int duration2 = this.qbJ.getDuration();
            int currentPosition = this.qbJ.getCurrentPosition();
            if (currentPosition >= duration2) {
                Log.e(this.TAG, "the current position is more than duration, current = %d, duration = %d !!!", Integer.valueOf(currentPosition), Integer.valueOf(duration2));
            }
            this.qbJ.start();
        }
        AppMethodBeat.o(98089);
    }

    @Override // com.tencent.mm.plugin.sns.ui.an.a
    public final void bgW() {
        AppMethodBeat.i(98090);
        Log.i(this.TAG, "%d pauseByDataBlock", Integer.valueOf(hashCode()));
        fgp();
        showLoading();
        cXa();
        AppMethodBeat.o(98090);
    }

    @Override // com.tencent.mm.plugin.sns.ui.an.a
    public final void aT(int i2, boolean z) {
        AppMethodBeat.i(203336);
        Log.i(this.TAG, "%d seek second %d afterSeekPlay %b", Integer.valueOf(hashCode()), Integer.valueOf(i2), Boolean.valueOf(z));
        this.EtP = 0;
        hideLoading();
        this.qbJ.d((double) (i2 * 1000), z);
        fO(false);
        AppMethodBeat.o(203336);
    }

    @Override // com.tencent.mm.plugin.sns.ui.an.a
    public final void Zz(int i2) {
        AppMethodBeat.i(203337);
        a aVar = this.EtK;
        if (aVar != null) {
            aVar.xv(i2);
        }
        AppMethodBeat.o(203337);
    }

    private void fgo() {
        AppMethodBeat.i(98092);
        this.Eua = Util.nowMilliSecond();
        Log.d(this.TAG, "%d notePlayVideo notePlayVideo %d ", Integer.valueOf(hashCode()), Long.valueOf(this.Eua));
        AppMethodBeat.o(98092);
    }

    private void fgp() {
        AppMethodBeat.i(98093);
        if (this.Eua > 0) {
            this.Eub = (int) (((long) this.Eub) + ((Util.nowMilliSecond() - this.Eua) / 1000));
        }
        Log.i(this.TAG, "%d notePauseVideo playVideoDuration %d ", Integer.valueOf(hashCode()), Integer.valueOf(this.Eub));
        this.Eua = 0;
        AppMethodBeat.o(98093);
    }

    @Override // com.tencent.mm.plugin.sns.ui.an.a
    public int getPlayVideoDuration() {
        AppMethodBeat.i(98094);
        if (this.Eub < 0) {
            this.Eub = 0;
        }
        Log.i(this.TAG, "%d get play video duration [%d]", Integer.valueOf(hashCode()), Integer.valueOf(this.Eub));
        int i2 = this.Eub;
        AppMethodBeat.o(98094);
        return i2;
    }

    private void fgq() {
        AppMethodBeat.i(98095);
        this.Euc = Util.nowMilliSecond();
        Log.d(this.TAG, "%d noteResumeVideo noteResumeVideo %d ", Integer.valueOf(hashCode()), Long.valueOf(this.Euc));
        AppMethodBeat.o(98095);
    }

    private void fgr() {
        AppMethodBeat.i(98096);
        if (this.Euc > 0) {
            this.Eud = 0;
            this.Eud = (int) (((long) this.Eud) + ((Util.nowMilliSecond() - this.Euc) / 1000));
        }
        Log.i(this.TAG, "%d notePauseVideoByResume playVideoDuration %d ", Integer.valueOf(hashCode()), Integer.valueOf(this.Eud));
        this.Euc = 0;
        AppMethodBeat.o(98096);
    }

    @Override // com.tencent.mm.plugin.sns.ui.an.a
    public int getPlayVideoDurationByResume() {
        AppMethodBeat.i(98097);
        if (this.Eud < 0) {
            this.Eud = 0;
        }
        Log.i(this.TAG, "%d get play video duration by resume [%d]", Integer.valueOf(hashCode()), Integer.valueOf(this.Eud));
        int i2 = this.Eud;
        AppMethodBeat.o(98097);
        return i2;
    }

    @Override // com.tencent.mm.plugin.sns.ui.an.a
    public int getPlayErrorCode() {
        return this.tnb;
    }

    @Override // com.tencent.mm.plugin.sns.ui.an.a
    public int getUiStayTime() {
        int i2;
        if (this.EtR <= 0 || this.EtQ <= 0) {
            i2 = 0;
        } else {
            i2 = (int) (this.EtR - this.EtQ);
        }
        if (i2 < 0) {
            return 0;
        }
        return i2;
    }

    @Override // com.tencent.mm.model.d.a
    public final void aTw() {
    }

    @Override // com.tencent.mm.model.d.a
    public final void aTx() {
    }

    @Override // com.tencent.mm.model.d.a
    public final void aTy() {
    }

    @Override // com.tencent.mm.model.d.a
    public final void aTz() {
    }

    public final boolean isPlaying() {
        AppMethodBeat.i(98098);
        boolean isPlaying = this.qbJ.isPlaying();
        AppMethodBeat.o(98098);
        return isPlaying;
    }

    @Override // com.tencent.mm.plugin.sns.ui.an.a
    public an.c getRptStruct() {
        AppMethodBeat.i(98099);
        an.c cVar = new an.c();
        cVar.scene = this.scene;
        cVar.sessionId = this.sessionId;
        cVar.EtT = this.EtT;
        cVar.dRS = this.dRS;
        cVar.filePath = this.filePath;
        AppMethodBeat.o(98099);
        return cVar;
    }

    public int getCurrentPosition() {
        AppMethodBeat.i(98100);
        int currentPosition = this.qbJ.getCurrentPosition();
        AppMethodBeat.o(98100);
        return currentPosition;
    }

    public void setThumbViewScaleType(ImageView.ScaleType scaleType) {
        AppMethodBeat.i(98101);
        this.tiQ.setScaleType(scaleType);
        AppMethodBeat.o(98101);
    }

    public void setVideoScaleType(i.e eVar) {
        AppMethodBeat.i(98102);
        if (this.qbJ != null) {
            if (this.qbJ instanceof VideoPlayerTextureView) {
                ((VideoPlayerTextureView) this.qbJ).setScaleType(eVar);
                AppMethodBeat.o(98102);
                return;
            } else if (this.qbJ instanceof VideoTextureView) {
                ((VideoTextureView) this.qbJ).setScaleType(eVar);
            }
        }
        AppMethodBeat.o(98102);
    }

    public void setScene(int i2) {
        this.scene = i2;
    }

    public int getScene() {
        return this.scene;
    }

    public void setSessionId(String str) {
        this.sessionId = str;
    }

    public String getSessionId() {
        return this.sessionId;
    }

    public void setSessionTimestamp(long j2) {
        this.EtT = j2;
    }

    public long getSessionTimestamp() {
        return this.EtT;
    }

    public void setSnsId(String str) {
        this.dRS = str;
    }

    public String getSnsId() {
        return this.dRS;
    }

    public void setFilePath(String str) {
        this.filePath = str;
    }

    public String getFilePath() {
        return this.filePath;
    }

    static /* synthetic */ void fgs() {
        AppMethodBeat.i(98104);
        h.INSTANCE.idkeyStat(354, 225, 1, false);
        AppMethodBeat.o(98104);
    }

    static /* synthetic */ void fgt() {
        AppMethodBeat.i(203338);
        h.INSTANCE.idkeyStat(354, 226, 1, false);
        AppMethodBeat.o(203338);
    }

    static /* synthetic */ void fgu() {
        AppMethodBeat.i(203339);
        h.INSTANCE.idkeyStat(354, 222, 1, false);
        AppMethodBeat.o(203339);
    }

    static /* synthetic */ void fgv() {
        AppMethodBeat.i(203340);
        h.INSTANCE.idkeyStat(354, 221, 1, false);
        AppMethodBeat.o(203340);
    }

    static /* synthetic */ void i(OnlineVideoView onlineVideoView) {
        AppMethodBeat.i(203341);
        com.tencent.f.h.RTc.b(new Runnable() {
            /* class com.tencent.mm.plugin.sns.ui.OnlineVideoView.AnonymousClass12 */

            public final void run() {
                AppMethodBeat.i(98053);
                try {
                    SnsInfo aQm = aj.faO().aQm(OnlineVideoView.this.dJX);
                    if (aQm == null) {
                        Log.e(OnlineVideoView.this.TAG, "[-] Fail to get sns info, skip reporting. snsId:%s, url:%s", OnlineVideoView.this.getSnsId(), OnlineVideoView.this.ebR.Url);
                        AppMethodBeat.o(98053);
                        return;
                    }
                    j.b c2 = com.tencent.mm.app.j.c(j.a.dkR);
                    c2.dkU = aQm.getUserName();
                    c2.msgId = aQm.field_snsId;
                    c2.dkW = OnlineVideoView.this.ebR.Url;
                    c2.dkX = OnlineVideoView.this.videoWidth;
                    c2.dkY = OnlineVideoView.this.videoHeight;
                    c2.dkZ = OnlineVideoView.this.ebR.Msz;
                    c2.dla = OnlineVideoView.this.qbJ.getDuration();
                    c2.md5 = OnlineVideoView.this.ebR.MsS;
                    com.tencent.mm.app.j.a(c2);
                    AppMethodBeat.o(98053);
                } catch (Throwable th) {
                    Log.printErrStackTrace(OnlineVideoView.this.TAG, th, "[-] Exception was thrown when report.", new Object[0]);
                    AppMethodBeat.o(98053);
                }
            }
        }, "SnsVideoExportReport");
        AppMethodBeat.o(203341);
    }

    static /* synthetic */ void a(OnlineVideoView onlineVideoView, int i2) {
        AppMethodBeat.i(203344);
        if (onlineVideoView.ecB > 0) {
            Log.w(onlineVideoView.TAG, "send video now, do nothing.");
            AppMethodBeat.o(203344);
            return;
        }
        String a2 = ay.a(onlineVideoView.dJX, onlineVideoView.ebR);
        Log.i(onlineVideoView.TAG, "%d retransmit video req code %d, download finish path %s", Integer.valueOf(onlineVideoView.hashCode()), Integer.valueOf(i2), a2);
        if (!Util.isNullOrNil(a2)) {
            onlineVideoView.ZA(i2);
            AppMethodBeat.o(203344);
            return;
        }
        onlineVideoView.ecB = i2;
        onlineVideoView.W(true, 33);
        onlineVideoView.showLoading();
        h.INSTANCE.idkeyStat(354, 223, 1, false);
        AppMethodBeat.o(203344);
    }

    static /* synthetic */ void a(OnlineVideoView onlineVideoView, int i2, boolean z) {
        AppMethodBeat.i(98111);
        if (onlineVideoView.ecz > 0) {
            Log.w(onlineVideoView.TAG, "fav video now, do nothing.");
            AppMethodBeat.o(98111);
            return;
        }
        String a2 = ay.a(onlineVideoView.dJX, onlineVideoView.ebR);
        Log.i(onlineVideoView.TAG, "%d fav video req code %d fromMain %b, download finish path %s", Integer.valueOf(onlineVideoView.hashCode()), Integer.valueOf(i2), Boolean.valueOf(z), a2);
        if (!Util.isNullOrNil(a2)) {
            onlineVideoView.aV(i2, z);
            AppMethodBeat.o(98111);
            return;
        }
        onlineVideoView.ecz = i2;
        onlineVideoView.ecA = z;
        onlineVideoView.W(true, 35);
        onlineVideoView.showLoading();
        h.INSTANCE.idkeyStat(354, 224, 1, false);
        AppMethodBeat.o(98111);
    }

    static /* synthetic */ void v(OnlineVideoView onlineVideoView) {
        AppMethodBeat.i(203345);
        String a2 = ay.a(onlineVideoView.dJX, onlineVideoView.ebR);
        Log.i(onlineVideoView.TAG, "%d save video, download finish path %s", Integer.valueOf(onlineVideoView.hashCode()), a2);
        if (!Util.isNullOrNil(a2)) {
            onlineVideoView.fgm();
            AppMethodBeat.o(203345);
            return;
        }
        onlineVideoView.EtJ = true;
        onlineVideoView.W(true, 34);
        onlineVideoView.showLoading();
        h.INSTANCE.idkeyStat(354, 220, 1, false);
        AppMethodBeat.o(203345);
    }

    static /* synthetic */ void a(OnlineVideoView onlineVideoView, final int i2, final int i3) {
        AppMethodBeat.i(203349);
        onlineVideoView.qaC.post(new Runnable() {
            /* class com.tencent.mm.plugin.sns.ui.OnlineVideoView.AnonymousClass14 */

            public final void run() {
                AppMethodBeat.i(98055);
                if (!(OnlineVideoView.this.mEz == null || OnlineVideoView.this.mEz.getVisibility() == 8)) {
                    OnlineVideoView.this.mEz.setVisibility(8);
                }
                if (OnlineVideoView.this.tne != null) {
                    if (OnlineVideoView.this.tne.getVisibility() != 0) {
                        OnlineVideoView.this.tne.setVisibility(0);
                    }
                    Log.i(OnlineVideoView.this.TAG, "%d update progress %d %d", Integer.valueOf(OnlineVideoView.this.hashCode()), Integer.valueOf(i2), Integer.valueOf(i3));
                    if (OnlineVideoView.this.tne.getMax() != i3 && i3 > 0) {
                        OnlineVideoView.this.tne.setMax(i3);
                    }
                    OnlineVideoView.this.tne.setProgress(i2);
                }
                AppMethodBeat.o(98055);
            }
        });
        AppMethodBeat.o(203349);
    }
}

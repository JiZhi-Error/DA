package com.tencent.mm.plugin.sns.ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.database.Cursor;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcel;
import android.os.Process;
import android.os.SystemClock;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.view.animation.Transformation;
import android.widget.AbsoluteLayout;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.q;
import com.tencent.mm.component.api.jumper.UICustomParam;
import com.tencent.mm.g.a.bs;
import com.tencent.mm.g.a.ir;
import com.tencent.mm.g.a.nm;
import com.tencent.mm.g.a.nq;
import com.tencent.mm.g.a.oa;
import com.tencent.mm.g.a.ob;
import com.tencent.mm.g.a.oi;
import com.tencent.mm.g.a.sk;
import com.tencent.mm.g.a.vb;
import com.tencent.mm.g.a.vi;
import com.tencent.mm.g.a.vj;
import com.tencent.mm.g.a.vn;
import com.tencent.mm.g.a.vo;
import com.tencent.mm.g.a.vp;
import com.tencent.mm.g.a.vu;
import com.tencent.mm.g.a.vx;
import com.tencent.mm.g.a.wd;
import com.tencent.mm.g.a.we;
import com.tencent.mm.g.a.wm;
import com.tencent.mm.g.a.ys;
import com.tencent.mm.g.b.a.im;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.kernel.i;
import com.tencent.mm.model.bb;
import com.tencent.mm.model.cl;
import com.tencent.mm.model.z;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.platformtools.ac;
import com.tencent.mm.plugin.appbrand.jsapi.h.h;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.mmsight.SightCaptureResult;
import com.tencent.mm.plugin.mmsight.SightParams;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.recordvideo.jumper.VideoCaptureReportInfo;
import com.tencent.mm.plugin.secdata.ui.WxPresenterSecDataActivity;
import com.tencent.mm.plugin.sns.ad.g.k;
import com.tencent.mm.plugin.sns.b.i;
import com.tencent.mm.plugin.sns.data.m;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.i.a;
import com.tencent.mm.plugin.sns.k.a;
import com.tencent.mm.plugin.sns.m.c;
import com.tencent.mm.plugin.sns.model.ah;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.an;
import com.tencent.mm.plugin.sns.model.aq;
import com.tencent.mm.plugin.sns.model.av;
import com.tencent.mm.plugin.sns.model.aw;
import com.tencent.mm.plugin.sns.model.ax;
import com.tencent.mm.plugin.sns.model.az;
import com.tencent.mm.plugin.sns.model.bd;
import com.tencent.mm.plugin.sns.model.p;
import com.tencent.mm.plugin.sns.model.v;
import com.tencent.mm.plugin.sns.storage.AdSnsInfo;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.storage.j;
import com.tencent.mm.plugin.sns.storage.w;
import com.tencent.mm.plugin.sns.storage.x;
import com.tencent.mm.plugin.sns.ui.SnsUIAction;
import com.tencent.mm.plugin.sns.ui.TestTimeForSns;
import com.tencent.mm.plugin.sns.ui.bf;
import com.tencent.mm.plugin.sns.ui.bk;
import com.tencent.mm.plugin.sns.ui.i;
import com.tencent.mm.plugin.sns.ui.item.BaseTimeLineItem;
import com.tencent.mm.plugin.sns.ui.view.SnsStoryHeaderView;
import com.tencent.mm.plugin.sns.ui.widget.f;
import com.tencent.mm.pluginsdk.h;
import com.tencent.mm.pluginsdk.ui.a;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.cly;
import com.tencent.mm.protocal.protobuf.dzi;
import com.tencent.mm.protocal.protobuf.dzo;
import com.tencent.mm.sdk.crash.CrashReportFactory;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.ForceGpuUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.ScreenShotUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bp;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.at;
import com.tencent.mm.ui.au;
import com.tencent.mm.ui.base.MMPullDownView;
import com.tencent.mm.ui.statusbar.c;
import com.tencent.mm.ui.widget.QFadeImageView;
import com.tencent.mm.ui.widget.QImageView;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.mm.vending.a.b;
import com.tencent.mm.vending.app.a;
import com.tencent.mm.vending.base.Vending;
import com.tencent.mm.vending.g.g;
import com.tencent.mm.vending.h.d;
import com.tencent.mm.vfs.s;
import com.tencent.tavkit.component.TAVExporter;
import com.tencent.thumbplayer.core.thirdparties.LocalCache;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.regex.Matcher;
import org.json.JSONObject;

@i
public class SnsTimeLineUI extends WxPresenterSecDataActivity implements com.tencent.mm.ak.i, bb, i.a, x {
    public static final Boolean ELX = Boolean.FALSE;
    private static Boolean ELn = null;
    private static final Set<Activity> sUILeaksRoutineEnsuranceRef = new HashSet();
    private View BdQ;
    private c.a BdS;
    private IListener DMM;
    private boolean DSi;
    protected k EBv;
    private final long EKO = 300;
    private long EKP = SystemClock.elapsedRealtime();
    private com.tencent.mm.plugin.sns.m.b EKQ = ((com.tencent.mm.plugin.sns.m.b) aq(com.tencent.mm.plugin.sns.m.b.class));
    private com.tencent.mm.plugin.sns.m.a EKR;
    private com.tencent.mm.plugin.sns.ui.a.a.c EKS;
    com.tencent.mm.plugin.sns.ui.a.c EKT;
    private LinearLayout EKU;
    private LinearLayout EKV;
    private QFadeImageView EKW;
    private boolean EKX;
    private boolean EKY;
    private i EKZ;
    private e ELA;
    private boolean ELB;
    private Runnable ELC;
    private IListener ELD;
    private IListener ELE;
    private Vending.d ELF;
    private boolean ELG;
    private IListener ELH;
    private IListener ELI;
    private IListener ELJ;
    private IListener ELK;
    private IListener ELL;
    private IListener ELM;
    private IListener ELN;
    private IListener ELO;
    private IListener ELP;
    private IListener ELQ;
    private IListener ELR;
    private IListener ELS;
    private IListener ELT;
    private IListener ELU;
    private IListener ELV;
    private IListener ELW;
    private long ELY;
    boolean ELZ;
    private int ELa;
    private a ELb;
    private TestTimeForSns ELc;
    private int ELd;
    private boolean ELe;
    private String ELf;
    private com.tencent.mm.plugin.sns.k.a ELg;
    private bd ELh;
    private com.tencent.mm.plugin.sns.model.bb ELi;
    private String ELj;
    private boolean ELk;
    private int ELl;
    private String ELm;
    private String ELo;
    private c ELp;
    private bf ELq;
    private ViewGroup ELr;
    private long ELs;
    private int ELt;
    private int ELu;
    private int ELv;
    private int ELw;
    private int ELx;
    private int ELy;
    private int ELz;
    Runnable EMa;
    Runnable EMb;
    private Handler EMc;
    private Runnable EMd;
    private SnsUIAction.a EMe;
    private long EMf;
    private a.b EMg;
    boolean EMh;
    int EMi;
    private ImageView EMj;
    private View EMk;
    private long EMl;
    private boolean EMm;
    private boolean EoO;
    private boolean EqY;
    private volatile boolean ExJ;
    private ScreenShotUtil.ScreenShotCallback EyL;
    private boolean autoPlay;
    private int gsi;
    private long hlB;
    private long iTC;
    private ActionBar mActionBar;
    private String mRa;
    private int mScreenHeight;
    private int mScreenWidth;
    private String mSessionId;
    private SnsUIAction mUIAction;
    private MenuItem.OnMenuItemClickListener ubB;
    private int wAr;
    private long zdW;

    public SnsTimeLineUI() {
        AppMethodBeat.i(99372);
        this.EKR = this.EKQ != null ? this.EKQ.flo() : null;
        this.EKS = new com.tencent.mm.plugin.sns.ui.a.a.c();
        this.EKX = false;
        this.EKY = false;
        this.EoO = false;
        this.ELa = 800;
        this.ELd = 0;
        this.ELe = false;
        this.ELf = "";
        this.ELg = new com.tencent.mm.plugin.sns.k.a();
        this.EBv = new k(0);
        this.ELh = new bd();
        this.ELi = new com.tencent.mm.plugin.sns.model.bb();
        this.autoPlay = false;
        this.ELo = "";
        this.ELp = new c(this, (byte) 0);
        this.ELq = new bf();
        this.ELr = null;
        this.ELs = 0;
        this.ExJ = false;
        this.ELt = 0;
        this.ELu = 0;
        this.ELv = 0;
        this.ELw = 0;
        this.ELx = 2;
        this.ELy = 2;
        this.ELz = 2;
        this.ELB = false;
        this.ELC = new Runnable() {
            /* class com.tencent.mm.plugin.sns.ui.SnsTimeLineUI.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(99267);
                com.tencent.mm.plugin.sns.ui.a.c cVar = SnsTimeLineUI.this.EKT;
                if (cVar != null) {
                    if (aj.faZ().DNF == ax.DOe) {
                        SnsTimeLineUI.this.ELs = cVar.vC(true);
                    }
                    cVar.ESq.fiE();
                    cVar.ESq.notifyVendingDataChange();
                }
                AppMethodBeat.o(99267);
            }
        };
        this.ELD = new IListener<ys>() {
            /* class com.tencent.mm.plugin.sns.ui.SnsTimeLineUI.AnonymousClass12 */

            {
                AppMethodBeat.i(160734);
                this.__eventId = ys.class.getName().hashCode();
                AppMethodBeat.o(160734);
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
            @Override // com.tencent.mm.sdk.event.IListener
            public final /* synthetic */ boolean callback(ys ysVar) {
                AppMethodBeat.i(99278);
                SnsTimeLineUI.this.aBf().bk(c.b.class);
                AppMethodBeat.o(99278);
                return false;
            }
        };
        this.ELE = new IListener<we>() {
            /* class com.tencent.mm.plugin.sns.ui.SnsTimeLineUI.AnonymousClass23 */

            {
                AppMethodBeat.i(160735);
                this.__eventId = we.class.getName().hashCode();
                AppMethodBeat.o(160735);
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
            @Override // com.tencent.mm.sdk.event.IListener
            public final /* synthetic */ boolean callback(we weVar) {
                AppMethodBeat.i(99303);
                we weVar2 = weVar;
                if (SnsTimeLineUI.this.getContext() == null || SnsTimeLineUI.this.getContext().isFinishing()) {
                    AppMethodBeat.o(99303);
                } else {
                    if (!weVar2.ecn.eco) {
                        g.hdG().d(new com.tencent.mm.vending.c.a<Void, Void>() {
                            /* class com.tencent.mm.plugin.sns.ui.SnsTimeLineUI.AnonymousClass23.AnonymousClass1 */

                            /* Return type fixed from 'java.lang.Object' to match base method */
                            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                            @Override // com.tencent.mm.vending.c.a
                            public final /* synthetic */ Void call(Void r4) {
                                AppMethodBeat.i(99302);
                                Void r42 = r4;
                                com.tencent.mm.plugin.sns.ui.a.c cVar = SnsTimeLineUI.this.EKT;
                                if (cVar != null) {
                                    cVar.ESq.axJ();
                                    cVar.ESq.notifyVendingDataChange();
                                }
                                AppMethodBeat.o(99302);
                                return r42;
                            }
                        });
                        SnsTimeLineUI.b(SnsTimeLineUI.this);
                    } else {
                        SnsTimeLineUI.c(SnsTimeLineUI.this);
                        SnsTimeLineUI.this.mUIAction.DSh.onResume();
                    }
                    AppMethodBeat.o(99303);
                }
                return false;
            }
        };
        this.ELF = new Vending.d() {
            /* class com.tencent.mm.plugin.sns.ui.SnsTimeLineUI.AnonymousClass34 */

            {
                AppMethodBeat.i(160736);
                AppMethodBeat.o(160736);
            }

            @Override // com.tencent.mm.vending.base.Vending.d
            public final void fjn() {
                AppMethodBeat.i(179249);
                if (SnsTimeLineUI.this.EKT != null && !SnsTimeLineUI.this.EKT.ESr) {
                    SnsTimeLineUI.this.EKT.notifyDataSetChanged();
                    if (SnsTimeLineUI.this.mUIAction.getSnsListView() != null) {
                        final int eu = au.eu(SnsTimeLineUI.this.getContext());
                        int statusBarHeight = au.getStatusBarHeight(SnsTimeLineUI.this.getContext());
                        Log.d("MicroMsg.SnsTimeLineUI", "topOffset:%s curFetchMode:%s, mUIAction.header.getLoadingGroupHeight():%s, actionBar:%s, statusBar:%s", Integer.valueOf(-(((SnsTimeLineUI.this.mUIAction.DSh.getLoadingGroupHeight() - at.fromDPToPix(SnsTimeLineUI.this.getContext(), 44)) - eu) - statusBarHeight)), Integer.valueOf(aj.faZ().DNF), Integer.valueOf(SnsTimeLineUI.this.mUIAction.DSh.getLoadingGroupHeight()), Integer.valueOf(eu), Integer.valueOf(statusBarHeight));
                        if (aj.faZ().DNF == ax.DOd) {
                            Log.i("MicroMsg.SnsTimeLineUI", "curFetchMode == FETCH_MODE_SPECIFIC");
                            long fkc = SnsTimeLineUI.this.EKT.fkc();
                            aj.faE().W(fkc, -1);
                            SnsTimeLineUI.this.EKT.ESq.aRi(r.Jc(fkc));
                            SnsTimeLineUI.this.ELs = SnsTimeLineUI.this.EKT.vC(true);
                            SnsTimeLineUI.this.mUIAction.vz(true);
                            aj.faL().start();
                            SnsTimeLineUI.this.mUIAction.getSnsListView().post(new Runnable() {
                                /* class com.tencent.mm.plugin.sns.ui.SnsTimeLineUI.AnonymousClass34.AnonymousClass1 */

                                public final void run() {
                                    AppMethodBeat.i(203694);
                                    SnsTimeLineUI.this.mUIAction.getSnsListView().setSelectionFromTop(SnsTimeLineUI.this.mUIAction.getSnsListView().getHeaderViewsCount(), eu + at.fromDPToPix(SnsTimeLineUI.this.getContext(), 44));
                                    aj.faZ().DNH = false;
                                    AppMethodBeat.o(203694);
                                }
                            });
                            AppMethodBeat.o(179249);
                            return;
                        } else if (aj.faZ().DNF == ax.DOe) {
                            int i2 = 0;
                            while (true) {
                                if (i2 >= SnsTimeLineUI.this.EKT.getCount()) {
                                    i2 = 0;
                                    break;
                                } else if (SnsTimeLineUI.this.EKT.Zv(i2).field_snsId == SnsTimeLineUI.this.ELs) {
                                    break;
                                } else {
                                    i2++;
                                }
                            }
                            Log.i("MicroMsg.SnsTimeLineUI", "curFetchMode == FETCH_MODE_UP upFetchRightId:%s, rightIndex:%s", Long.valueOf(SnsTimeLineUI.this.ELs), Integer.valueOf(i2));
                            SnsTimeLineUI.this.mUIAction.getSnsListView().setSelectionFromTop(i2 + SnsTimeLineUI.this.mUIAction.getSnsListView().getHeaderViewsCount(), SnsTimeLineUI.this.mUIAction.getHeaderHeight());
                        }
                    }
                }
                AppMethodBeat.o(179249);
            }
        };
        this.ELG = false;
        this.DSi = false;
        this.ELH = new IListener<oa>() {
            /* class com.tencent.mm.plugin.sns.ui.SnsTimeLineUI.AnonymousClass45 */

            {
                AppMethodBeat.i(160737);
                this.__eventId = oa.class.getName().hashCode();
                AppMethodBeat.o(160737);
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
            @Override // com.tencent.mm.sdk.event.IListener
            public final /* synthetic */ boolean callback(oa oaVar) {
                AppMethodBeat.i(99334);
                Log.d("MicroMsg.SnsTimeLineUI", "notifyTimelineFpListener callback");
                if (oaVar instanceof oa) {
                    SnsTimeLineUI.f(SnsTimeLineUI.this);
                    SnsTimeLineUI.this.EKT.ESq.notifyVendingDataChange();
                }
                AppMethodBeat.o(99334);
                return false;
            }
        };
        this.ELI = new IListener<ob>() {
            /* class com.tencent.mm.plugin.sns.ui.SnsTimeLineUI.AnonymousClass56 */

            {
                AppMethodBeat.i(160738);
                this.__eventId = ob.class.getName().hashCode();
                AppMethodBeat.o(160738);
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
            @Override // com.tencent.mm.sdk.event.IListener
            public final /* synthetic */ boolean callback(ob obVar) {
                AppMethodBeat.i(99345);
                SnsTimeLineUI.this.EKT.ESq.notifyVendingDataChange();
                AppMethodBeat.o(99345);
                return false;
            }
        };
        this.ELJ = new IListener<nm>() {
            /* class com.tencent.mm.plugin.sns.ui.SnsTimeLineUI.AnonymousClass66 */

            {
                AppMethodBeat.i(160739);
                this.__eventId = nm.class.getName().hashCode();
                AppMethodBeat.o(160739);
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
            @Override // com.tencent.mm.sdk.event.IListener
            public final /* synthetic */ boolean callback(nm nmVar) {
                AppMethodBeat.i(99357);
                SnsTimeLineUI.this.ELG = true;
                AppMethodBeat.o(99357);
                return false;
            }
        };
        this.ELK = new IListener<nq>() {
            /* class com.tencent.mm.plugin.sns.ui.SnsTimeLineUI.AnonymousClass77 */

            {
                AppMethodBeat.i(160740);
                this.__eventId = nq.class.getName().hashCode();
                AppMethodBeat.o(160740);
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
            @Override // com.tencent.mm.sdk.event.IListener
            public final /* synthetic */ boolean callback(nq nqVar) {
                AppMethodBeat.i(99358);
                SnsTimeLineUI.this.DSi = true;
                SnsTimeLineUI.this.ELg.DSi = SnsTimeLineUI.this.DSi;
                SnsTimeLineUI.a(SnsTimeLineUI.this, nqVar.dTN.position);
                AppMethodBeat.o(99358);
                return false;
            }
        };
        this.ELL = new IListener<wm>() {
            /* class com.tencent.mm.plugin.sns.ui.SnsTimeLineUI.AnonymousClass78 */

            {
                AppMethodBeat.i(160741);
                this.__eventId = wm.class.getName().hashCode();
                AppMethodBeat.o(160741);
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
            @Override // com.tencent.mm.sdk.event.IListener
            public final /* synthetic */ boolean callback(wm wmVar) {
                AppMethodBeat.i(99359);
                if (SnsTimeLineUI.this.EKZ != null) {
                    SnsTimeLineUI.this.EKZ.EoF.DMa.DSJ++;
                    SnsTimeLineUI.this.EKZ.EoF.DMa.uT(false);
                }
                AppMethodBeat.o(99359);
                return false;
            }
        };
        this.ELM = new IListener<vi>() {
            /* class com.tencent.mm.plugin.sns.ui.SnsTimeLineUI.AnonymousClass2 */

            {
                AppMethodBeat.i(160725);
                this.__eventId = vi.class.getName().hashCode();
                AppMethodBeat.o(160725);
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
            @Override // com.tencent.mm.sdk.event.IListener
            public final /* synthetic */ boolean callback(vi viVar) {
                AppMethodBeat.i(99268);
                vi viVar2 = viVar;
                if (SnsTimeLineUI.this.EKZ != null) {
                    com.tencent.mm.plugin.sns.k.b bVar = SnsTimeLineUI.this.EKZ.EoF.DMa;
                    String str = viVar2.ebE.ebF;
                    bVar.DUa.add(viVar2.ebE.dRS);
                    bVar.DUi.add(str);
                    bVar.DSK = bVar.DUi.size();
                }
                AppMethodBeat.o(99268);
                return false;
            }
        };
        this.ELN = new IListener<vx>() {
            /* class com.tencent.mm.plugin.sns.ui.SnsTimeLineUI.AnonymousClass3 */

            {
                AppMethodBeat.i(160726);
                this.__eventId = vx.class.getName().hashCode();
                AppMethodBeat.o(160726);
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
            @Override // com.tencent.mm.sdk.event.IListener
            public final /* synthetic */ boolean callback(vx vxVar) {
                AppMethodBeat.i(99269);
                vx vxVar2 = vxVar;
                if (SnsTimeLineUI.this.EKZ != null) {
                    if (vxVar2.ebX.ebY) {
                        com.tencent.mm.plugin.sns.k.b bVar = SnsTimeLineUI.this.EKZ.EoF.DMa;
                        bVar.DUk.add(vxVar2.ebX.username);
                        bVar.DSM = bVar.DUk.size();
                    } else {
                        com.tencent.mm.plugin.sns.k.b bVar2 = SnsTimeLineUI.this.EKZ.EoF.DMa;
                        bVar2.DUl.add(vxVar2.ebX.username);
                        bVar2.DSN = bVar2.DUl.size();
                    }
                }
                AppMethodBeat.o(99269);
                return false;
            }
        };
        this.ELO = new IListener<vu>() {
            /* class com.tencent.mm.plugin.sns.ui.SnsTimeLineUI.AnonymousClass4 */

            {
                AppMethodBeat.i(160727);
                this.__eventId = vu.class.getName().hashCode();
                AppMethodBeat.o(160727);
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
            @Override // com.tencent.mm.sdk.event.IListener
            public final /* synthetic */ boolean callback(vu vuVar) {
                AppMethodBeat.i(99270);
                SnsTimeLineUI.this.EKT.ESq.notifyVendingDataChange();
                AppMethodBeat.o(99270);
                return false;
            }
        };
        this.ELP = new IListener<ir>() {
            /* class com.tencent.mm.plugin.sns.ui.SnsTimeLineUI.AnonymousClass5 */

            {
                AppMethodBeat.i(160728);
                this.__eventId = ir.class.getName().hashCode();
                AppMethodBeat.o(160728);
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
            @Override // com.tencent.mm.sdk.event.IListener
            public final /* synthetic */ boolean callback(ir irVar) {
                AppMethodBeat.i(99271);
                ir irVar2 = irVar;
                SnsTimeLineUI.a(SnsTimeLineUI.this, irVar2.dNm.dNp, irVar2.dNm.dNo, irVar2);
                AppMethodBeat.o(99271);
                return false;
            }
        };
        this.DMM = new IListener<com.tencent.mm.g.a.e>() {
            /* class com.tencent.mm.plugin.sns.ui.SnsTimeLineUI.AnonymousClass6 */

            {
                AppMethodBeat.i(160729);
                this.__eventId = com.tencent.mm.g.a.e.class.getName().hashCode();
                AppMethodBeat.o(160729);
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
            @Override // com.tencent.mm.sdk.event.IListener
            public final /* synthetic */ boolean callback(com.tencent.mm.g.a.e eVar) {
                boolean z = true;
                AppMethodBeat.i(99272);
                com.tencent.mm.g.a.e eVar2 = eVar;
                if (!(SnsTimeLineUI.this.EKZ == null || SnsTimeLineUI.this.EKZ.EoF == null)) {
                    com.tencent.mm.plugin.sns.k.b bVar = SnsTimeLineUI.this.EKZ.EoF.DMa;
                    boolean z2 = eVar2.dBR.active;
                    String str = eVar2.dBR.className;
                    if (str.toLowerCase().indexOf("sns") < 0 && str.toLowerCase().indexOf("sightuploadui") < 0 && !str.contains("WebViewUI")) {
                        z = false;
                    }
                    if (!z) {
                        Log.d("MicroMsg.SnsBrowseInfoHelper", "handleActivityStatusChanged, not sns scene, className" + str + ",_active=" + z2);
                    } else if (!z2) {
                        bVar.DTo = System.currentTimeMillis();
                    } else if (bVar.DTo > 0) {
                        bVar.DTn += System.currentTimeMillis() - bVar.DTo;
                        bVar.DTo = 0;
                    }
                }
                AppMethodBeat.o(99272);
                return false;
            }
        };
        this.ELQ = new IListener<vb>() {
            /* class com.tencent.mm.plugin.sns.ui.SnsTimeLineUI.AnonymousClass7 */

            {
                AppMethodBeat.i(160730);
                this.__eventId = vb.class.getName().hashCode();
                AppMethodBeat.o(160730);
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
            @Override // com.tencent.mm.sdk.event.IListener
            public final /* synthetic */ boolean callback(vb vbVar) {
                AppMethodBeat.i(99273);
                if (!(SnsTimeLineUI.this.EKZ == null || SnsTimeLineUI.this.EKZ.EoF == null)) {
                    SnsTimeLineUI.this.EKZ.EoF.DMa.vc(true);
                }
                AppMethodBeat.o(99273);
                return false;
            }
        };
        this.ELR = new IListener<vj>() {
            /* class com.tencent.mm.plugin.sns.ui.SnsTimeLineUI.AnonymousClass8 */

            {
                AppMethodBeat.i(160731);
                this.__eventId = vj.class.getName().hashCode();
                AppMethodBeat.o(160731);
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
            @Override // com.tencent.mm.sdk.event.IListener
            public final /* synthetic */ boolean callback(vj vjVar) {
                AppMethodBeat.i(99274);
                vj vjVar2 = vjVar;
                if (!(SnsTimeLineUI.this.EKZ == null || SnsTimeLineUI.this.EKZ.EoF == null)) {
                    SnsTimeLineUI.this.EKZ.EoF.DMa.kp(vjVar2.ebG.dHp, vjVar2.ebG.dRS);
                }
                AppMethodBeat.o(99274);
                return false;
            }
        };
        this.ELS = new IListener<vn>() {
            /* class com.tencent.mm.plugin.sns.ui.SnsTimeLineUI.AnonymousClass9 */

            {
                AppMethodBeat.i(160732);
                this.__eventId = vn.class.getName().hashCode();
                AppMethodBeat.o(160732);
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
            @Override // com.tencent.mm.sdk.event.IListener
            public final /* synthetic */ boolean callback(vn vnVar) {
                AppMethodBeat.i(99275);
                vn vnVar2 = vnVar;
                if (!(SnsTimeLineUI.this.EKZ == null || SnsTimeLineUI.this.EKZ.EoF == null)) {
                    com.tencent.mm.plugin.sns.k.b bVar = SnsTimeLineUI.this.EKZ.EoF.DMa;
                    bVar.DUg.add(vnVar2.ebK.dRS);
                }
                AppMethodBeat.o(99275);
                return false;
            }
        };
        this.ELT = new IListener<vo>() {
            /* class com.tencent.mm.plugin.sns.ui.SnsTimeLineUI.AnonymousClass10 */

            {
                AppMethodBeat.i(160733);
                this.__eventId = vo.class.getName().hashCode();
                AppMethodBeat.o(160733);
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
            @Override // com.tencent.mm.sdk.event.IListener
            public final /* synthetic */ boolean callback(vo voVar) {
                AppMethodBeat.i(99276);
                vo voVar2 = voVar;
                if (!(SnsTimeLineUI.this.EKZ == null || SnsTimeLineUI.this.EKZ.EoF == null)) {
                    com.tencent.mm.plugin.sns.k.b bVar = SnsTimeLineUI.this.EKZ.EoF.DMa;
                    bVar.DUf.add(voVar2.ebL.dRS);
                }
                AppMethodBeat.o(99276);
                return false;
            }
        };
        this.ELU = new IListener<vp>() {
            /* class com.tencent.mm.plugin.sns.ui.SnsTimeLineUI.AnonymousClass11 */

            {
                AppMethodBeat.i(176298);
                this.__eventId = vp.class.getName().hashCode();
                AppMethodBeat.o(176298);
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
            @Override // com.tencent.mm.sdk.event.IListener
            public final /* synthetic */ boolean callback(vp vpVar) {
                AppMethodBeat.i(176299);
                vp vpVar2 = vpVar;
                if (!(SnsTimeLineUI.this.EKZ == null || SnsTimeLineUI.this.EKZ.EoF == null)) {
                    com.tencent.mm.plugin.sns.k.b bVar = SnsTimeLineUI.this.EKZ.EoF.DMa;
                    bVar.DUc.add(vpVar2.ebM.dRS);
                }
                AppMethodBeat.o(176299);
                return false;
            }
        };
        this.ELV = new IListener<bs>() {
            /* class com.tencent.mm.plugin.sns.ui.SnsTimeLineUI.AnonymousClass13 */

            {
                AppMethodBeat.i(179218);
                this.__eventId = bs.class.getName().hashCode();
                AppMethodBeat.o(179218);
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
            @Override // com.tencent.mm.sdk.event.IListener
            public final /* synthetic */ boolean callback(bs bsVar) {
                AppMethodBeat.i(179219);
                Log.i("MicroMsg.SnsTimeLineUI", "checkSnsAutoPlay event");
                SnsTimeLineUI.b(SnsTimeLineUI.this);
                AppMethodBeat.o(179219);
                return true;
            }
        };
        this.ELW = new IListener<wd>() {
            /* class com.tencent.mm.plugin.sns.ui.SnsTimeLineUI.AnonymousClass14 */

            {
                AppMethodBeat.i(203671);
                this.__eventId = wd.class.getName().hashCode();
                AppMethodBeat.o(203671);
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
            @Override // com.tencent.mm.sdk.event.IListener
            public final /* synthetic */ boolean callback(wd wdVar) {
                AppMethodBeat.i(203672);
                Log.i("MicroMsg.SnsTimeLineUI", "SnsRetryEditTipExpired event");
                SnsTimeLineUI.this.runOnUiThread(new Runnable() {
                    /* class com.tencent.mm.plugin.sns.ui.SnsTimeLineUI.AnonymousClass14.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(203670);
                        if (SnsTimeLineUI.this.EKT != null) {
                            SnsTimeLineUI.this.EKT.ESq.notifyVendingDataChange();
                        }
                        AppMethodBeat.o(203670);
                    }
                });
                AppMethodBeat.o(203672);
                return true;
            }
        };
        this.ELY = 0;
        this.ELZ = false;
        this.wAr = 0;
        this.EMa = new Runnable() {
            /* class com.tencent.mm.plugin.sns.ui.SnsTimeLineUI.AnonymousClass22 */

            public final void run() {
                AppMethodBeat.i(176303);
                if (SnsTimeLineUI.this.EKT == null) {
                    AppMethodBeat.o(176303);
                    return;
                }
                if (SnsTimeLineUI.this.ELZ) {
                    aj.faL().pause();
                }
                AppMethodBeat.o(176303);
            }
        };
        this.EMb = new Runnable() {
            /* class com.tencent.mm.plugin.sns.ui.SnsTimeLineUI.AnonymousClass24 */

            public final void run() {
                AppMethodBeat.i(179225);
                if (SnsTimeLineUI.this.EKT == null) {
                    AppMethodBeat.o(179225);
                    return;
                }
                if (!SnsTimeLineUI.this.ELZ) {
                    Log.v("MicroMsg.SnsTimeLineUI", "zeustest update onFling notify resume %s", Integer.valueOf(SnsTimeLineUI.this.mUIAction.list.getFirstVisiblePosition() - SnsTimeLineUI.this.mUIAction.list.getHeaderViewsCount()));
                    aj.faL().start();
                    SnsTimeLineUI.this.EKT.ESp.fiS();
                }
                AppMethodBeat.o(179225);
            }
        };
        this.EMc = ((com.tencent.mm.vending.h.b) d.LOGIC.RaM).mHandler;
        this.EMd = new Runnable() {
            /* class com.tencent.mm.plugin.sns.ui.SnsTimeLineUI.AnonymousClass25 */

            public final void run() {
                AppMethodBeat.i(179226);
                SnsTimeLineUI.this.setMMNormalView();
                SnsTimeLineUI.w(SnsTimeLineUI.this);
                SnsTimeLineUI.x(SnsTimeLineUI.this);
                SnsTimeLineUI.this.setMMTitle(SnsTimeLineUI.this.getString(R.string.hbf));
                SnsTimeLineUI.this.ELY = 0;
                SnsTimeLineUI.this.wAr = SnsTimeLineUI.this.mUIAction.list.getFirstVisiblePosition();
                AppMethodBeat.o(179226);
            }
        };
        this.EMe = new SnsUIAction.a() {
            /* class com.tencent.mm.plugin.sns.ui.SnsTimeLineUI.AnonymousClass28 */
            private int EMu = 0;
            private int EMv = 0;

            @Override // com.tencent.mm.plugin.sns.ui.SnsUIAction.a
            public final void fjg() {
                AppMethodBeat.i(203677);
                if (aj.faZ().DNH) {
                    Log.i("MicroMsg.SnsTimeLineUI", "isAutoScrolling, skip onLoadingMore");
                    AppMethodBeat.o(203677);
                    return;
                }
                com.tencent.mm.plugin.sns.ui.a.a.c cVar = SnsTimeLineUI.this.EKS;
                SnsUIAction.a unused = SnsTimeLineUI.this.EMe;
                cVar.e(SnsTimeLineUI.this.mRa, SnsTimeLineUI.this.ELk, false, SnsTimeLineUI.this.ELl);
                com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.USERINFO_UPDATE_SNS_TIMELINE_SCENE_INT, (Object) 3);
                Log.d("MicroMsg.SnsTimeLineUI", "onLoadingMore here");
                if (SnsTimeLineUI.this.EMc == null) {
                    Log.e("MicroMsg.SnsTimeLineUI", "mLogicHandler handler null");
                    AppMethodBeat.o(203677);
                    return;
                }
                if (SnsTimeLineUI.this.EKZ != null) {
                    SnsTimeLineUI.this.EMc.removeCallbacks(SnsTimeLineUI.this.ELC);
                    SnsTimeLineUI.this.EMc.postDelayed(SnsTimeLineUI.this.ELC, 3000);
                }
                AppMethodBeat.o(203677);
            }

            @Override // com.tencent.mm.plugin.sns.ui.SnsUIAction.a
            public final ListView getSnsListView() {
                AppMethodBeat.i(203678);
                if (SnsTimeLineUI.this.EKZ.list == null) {
                    SnsTimeLineUI.this.EKZ.list = (ListView) SnsTimeLineUI.this.findViewById(R.id.hzr);
                }
                ListView listView = SnsTimeLineUI.this.EKZ.list;
                AppMethodBeat.o(203678);
                return listView;
            }

            @Override // com.tencent.mm.plugin.sns.ui.SnsUIAction.a
            public final View fjh() {
                AppMethodBeat.i(203679);
                if (SnsTimeLineUI.this.EKZ.DQt == null) {
                    SnsTimeLineUI.this.EKZ.DQt = (FrameLayout) SnsTimeLineUI.this.findViewById(R.id.in6);
                }
                FrameLayout frameLayout = SnsTimeLineUI.this.EKZ.DQt;
                AppMethodBeat.o(203679);
                return frameLayout;
            }

            @Override // com.tencent.mm.plugin.sns.ui.SnsUIAction.a
            public final View getMaskView() {
                AppMethodBeat.i(203680);
                View findViewById = SnsTimeLineUI.this.findViewById(R.id.hxi);
                AppMethodBeat.o(203680);
                return findViewById;
            }

            @Override // com.tencent.mm.plugin.sns.ui.SnsUIAction.a
            public final MMPullDownView fji() {
                AppMethodBeat.i(203681);
                MMPullDownView mMPullDownView = (MMPullDownView) SnsTimeLineUI.this.findViewById(R.id.i00);
                AppMethodBeat.o(203681);
                return mMPullDownView;
            }

            @Override // com.tencent.mm.plugin.sns.ui.SnsUIAction.a
            public final int getType() {
                if (SnsTimeLineUI.this.EMi == 1) {
                    return 2;
                }
                return 1;
            }

            @Override // com.tencent.mm.plugin.sns.ui.SnsUIAction.a
            public final void d(int i2, List<Integer> list, List<Integer> list2) {
                SnsInfo Zr;
                boolean z = true;
                AppMethodBeat.i(203682);
                if (i2 > 0 && (Zr = aj.faO().Zr(i2)) != null) {
                    if (Zr.getPravited() > 0) {
                        Toast.makeText(SnsTimeLineUI.this, (int) R.string.h6s, 1).show();
                    }
                    if (Zr.getPravited() == 1) {
                        z = false;
                    }
                }
                if (z) {
                    com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(SnsTimeLineUI.this.mUIAction.list);
                    Object obj = new Object();
                    com.tencent.mm.hellhoundlib.a.a.a(obj, bl.axQ(), "com/tencent/mm/plugin/sns/ui/SnsTimeLineUI$34", "notifyList", "(ZILjava/util/List;Ljava/util/List;)V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
                    BackwardSupportUtil.SmoothScrollFactory.scrollToTop((ListView) bl.pG(0));
                    com.tencent.mm.hellhoundlib.a.a.a(obj, "com/tencent/mm/plugin/sns/ui/SnsTimeLineUI$34", "notifyList", "(ZILjava/util/List;Ljava/util/List;)V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
                }
                if (SnsTimeLineUI.this.EKT != null) {
                    SnsTimeLineUI.this.EKT.ESq.notifyVendingDataChange();
                }
                if (SnsTimeLineUI.this.mUIAction.list != null) {
                    SnsTimeLineUI.b(SnsTimeLineUI.this);
                }
                AppMethodBeat.o(203682);
            }

            @Override // com.tencent.mm.plugin.sns.ui.SnsUIAction.a
            public final boolean fjj() {
                AppMethodBeat.i(203683);
                boolean z = SnsTimeLineUI.this.EoO;
                AppMethodBeat.o(203683);
                return z;
            }

            @Override // com.tencent.mm.plugin.sns.ui.SnsUIAction.a
            public final void fjk() {
                AppMethodBeat.i(203684);
                Log.d("MicroMsg.SnsTimeLineUI", "onLoadingTap");
                SnsTimeLineUI.this.ffL();
                if (!SnsTimeLineUI.this.mUIAction.EvK && !SnsTimeLineUI.this.ELB) {
                    if (SnsTimeLineUI.this.EKW != null) {
                        Log.d("MicroMsg.SnsTimeLineUI", "refreshIv onLoadingTap");
                        SnsTimeLineUI.b(SnsTimeLineUI.this, 0);
                    }
                    com.tencent.mm.plugin.sns.ui.a.a.c cVar = SnsTimeLineUI.this.EKS;
                    SnsUIAction.a unused = SnsTimeLineUI.this.EMe;
                    cVar.d(SnsTimeLineUI.this.mRa, SnsTimeLineUI.this.ELk, SnsTimeLineUI.this.EqY, SnsTimeLineUI.this.ELl);
                    com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.USERINFO_UPDATE_SNS_TIMELINE_SCENE_INT, (Object) 2);
                }
                AppMethodBeat.o(203684);
            }

            @Override // com.tencent.mm.plugin.sns.ui.SnsUIAction.a
            public final void fjl() {
                AppMethodBeat.i(203685);
                SnsTimeLineUI.this.ffL();
                AppMethodBeat.o(203685);
            }

            @Override // com.tencent.mm.plugin.sns.ui.SnsUIAction.a
            public final void fjm() {
                AppMethodBeat.i(203686);
                aj.faZ().fbK();
                int firstVisiblePosition = SnsTimeLineUI.this.mUIAction.list.getFirstVisiblePosition();
                View childAt = SnsTimeLineUI.this.mUIAction.list.getChildAt(0);
                Log.i("MicroMsg.SnsTimeLineUI", "will do up fetch isDoingFetch:%s, SnsCore.getSnsUnreadTipManager().isAutoScrolling:%s", Boolean.valueOf(aj.faZ().DNI), Boolean.valueOf(aj.faZ().DNH));
                if (!aj.faZ().DNH && childAt != null && firstVisiblePosition == 0 && childAt.getTop() == 0 && SnsTimeLineUI.this.mUIAction.EvK) {
                    if (aj.faZ().DNI) {
                        AppMethodBeat.o(203686);
                        return;
                    }
                    com.tencent.mm.plugin.sns.ui.a.a.c cVar = SnsTimeLineUI.this.EKS;
                    SnsUIAction.a unused = SnsTimeLineUI.this.EMe;
                    String str = SnsTimeLineUI.this.mRa;
                    int i2 = ax.DOe;
                    boolean z = SnsTimeLineUI.this.EqY;
                    int i3 = SnsTimeLineUI.this.ELl;
                    if (cVar.hasInit && cVar.EMi == 0) {
                        long j2 = aj.faZ().DNE;
                        com.tencent.mm.plugin.sns.ui.a.a.b bVar = cVar.ESM;
                        if (bVar.EKQ != null) {
                            g.b(str, Integer.valueOf(i2), Boolean.valueOf(z), Integer.valueOf(i3), Long.valueOf(j2)).c(bVar.EKQ.FgD);
                        }
                    }
                    if (SnsTimeLineUI.this.EKZ != null) {
                        SnsTimeLineUI.this.EMc.removeCallbacks(SnsTimeLineUI.this.ELC);
                        SnsTimeLineUI.this.EMc.postDelayed(SnsTimeLineUI.this.ELC, 3000);
                    }
                }
                AppMethodBeat.o(203686);
            }

            @Override // com.tencent.mm.plugin.sns.ui.SnsUIAction.a
            public final void ZS(int i2) {
                TimeLineObject timeLine;
                AppMethodBeat.i(203687);
                int firstVisiblePosition = SnsTimeLineUI.this.mUIAction.list.getFirstVisiblePosition();
                int lastVisiblePosition = SnsTimeLineUI.this.mUIAction.list.getLastVisiblePosition();
                if (i2 == 0 && SnsTimeLineUI.this.EKT != null) {
                    SnsTimeLineUI.a(SnsTimeLineUI.this, firstVisiblePosition, lastVisiblePosition);
                }
                if (firstVisiblePosition == this.EMu && lastVisiblePosition == this.EMv) {
                    AppMethodBeat.o(203687);
                    return;
                }
                this.EMu = firstVisiblePosition;
                this.EMv = lastVisiblePosition;
                Log.i("MicroMsg.SnsTimeLineUI", "onListViewScoll %s %s %s", Integer.valueOf(firstVisiblePosition), Integer.valueOf(lastVisiblePosition), Integer.valueOf(i2));
                if (i2 == 2) {
                    WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcSNSScrollEnable, SnsTimeLineUI.this.gsi);
                    SnsTimeLineUI.this.gsi = WXHardCoderJNI.startPerformance(WXHardCoderJNI.hcSNSScrollEnable, WXHardCoderJNI.hcSNSScrollDelay, WXHardCoderJNI.hcSNSScrollCPU, WXHardCoderJNI.hcSNSScrollIO, WXHardCoderJNI.hcSNSScrollThr ? Process.myTid() : 0, WXHardCoderJNI.hcSNSScrollTimeout, 701, WXHardCoderJNI.hcSNSScrollAction, "MicroMsg.SnsTimeLineUI");
                    Log.i("MicroMsg.SnsTimeLineUI", "summer hardcoder sns startPerformance [%s]", Integer.valueOf(SnsTimeLineUI.this.gsi));
                }
                if (i2 == 0 && SnsTimeLineUI.this.EKT != null) {
                    com.tencent.mm.plugin.sns.ui.a.c cVar = SnsTimeLineUI.this.EKT;
                    if (lastVisiblePosition >= firstVisiblePosition) {
                        LinkedList linkedList = new LinkedList();
                        for (int i3 = firstVisiblePosition; i3 <= lastVisiblePosition; i3++) {
                            SnsInfo Zv = cVar.Zv(i3 - 1);
                            if (Zv != null && (timeLine = Zv.getTimeLine()) != null && !TextUtils.isEmpty(timeLine.ContentObj.Url) && timeLine.ContentObj.Url.contains(WeChatHosts.domainString(R.string.e20)) && timeLine.ContentObj.LoU == 3) {
                                int i4 = -1;
                                if (timeLine.ContentObj.LoY != null) {
                                    i4 = timeLine.ContentObj.LoY.iAb;
                                }
                                ArrayList arrayList = new ArrayList();
                                arrayList.add(timeLine.ContentObj.Url);
                                arrayList.add(String.valueOf(i4));
                                arrayList.add(String.valueOf(timeLine.Id));
                                arrayList.add("");
                                arrayList.add("");
                                arrayList.add(timeLine.UserName);
                                arrayList.add(String.valueOf(timeLine.CreateTime));
                                arrayList.add(String.valueOf(((com.tencent.mm.plugin.brandservice.a.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.brandservice.a.b.class)).ahy("__sns_timeline__")));
                                linkedList.add(arrayList);
                            }
                        }
                        ((com.tencent.mm.plugin.brandservice.a.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.brandservice.a.b.class)).j(linkedList, 2);
                    }
                    SnsTimeLineUI.this.EKT.iS(firstVisiblePosition, lastVisiblePosition);
                }
                if (SnsTimeLineUI.this.EKT != null) {
                    final a.C1716a b2 = SnsTimeLineUI.this.ELg.b(SnsTimeLineUI.this.EKT.ESp);
                    g.hdG().d(new com.tencent.mm.vending.c.a<Void, Void>() {
                        /* class com.tencent.mm.plugin.sns.ui.SnsTimeLineUI.AnonymousClass28.AnonymousClass1 */

                        /* Return type fixed from 'java.lang.Object' to match base method */
                        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                        @Override // com.tencent.mm.vending.c.a
                        public final /* synthetic */ Void call(Void r13) {
                            AppMethodBeat.i(203676);
                            Void r132 = r13;
                            if (b2 != null) {
                                a.C1716a aVar = b2;
                                com.tencent.mm.modelsns.k tO = com.tencent.mm.modelsns.k.tO(501);
                                tO.timeStamp = aVar.DSj;
                                tO.tR(aVar.mScreenWidth).tR(aVar.mScreenHeight);
                                tO.tR(aVar.DSl);
                                tO.tR(0);
                                tO.tR(aVar.DSk);
                                tO.tR(aVar.afB);
                                tO.bfK();
                                if (aVar.DSm != null) {
                                    for (a.b bVar : aVar.DSm) {
                                        com.tencent.mm.modelsns.k tO2 = com.tencent.mm.modelsns.k.tO(502);
                                        tO2.timeStamp = aVar.DSj;
                                        tO2.PH(bVar.DSr).tR(bVar.DSp).fL(bVar.DSq).tR(bVar.DSo).tR(bVar.DSn).tR(bVar.aYN).tR(bVar.aYO);
                                        tO2.bfK();
                                        Log.v("MicroMsg.CaptureSnsHelper", "rootview top left %s %s viewWidth: %s viewHeight: %s", Integer.valueOf(bVar.DSn), Integer.valueOf(bVar.DSo), Integer.valueOf(bVar.aYN), Integer.valueOf(bVar.aYO));
                                        Log.v("MicroMsg.CaptureSnsHelper", "like %s %s likeheight: %s likewidth: %s", Integer.valueOf(bVar.DSu), Integer.valueOf(bVar.DSv), Integer.valueOf(bVar.DSx), Integer.valueOf(bVar.DSw));
                                        Log.v("MicroMsg.CaptureSnsHelper", "comment %s %s commentheight: %s commentwidth: %s", Integer.valueOf(bVar.DSy), Integer.valueOf(bVar.DSz), Integer.valueOf(bVar.DSB), Integer.valueOf(bVar.DSA));
                                        if (bVar.DSt != 0) {
                                            com.tencent.mm.modelsns.k tO3 = com.tencent.mm.modelsns.k.tO(503);
                                            tO3.timeStamp = aVar.DSj;
                                            tO3.PH(bVar.DSr).tR(bVar.DSp).fL(bVar.DSq).tR(bVar.DSt).tR(bVar.DSv).tR(bVar.DSu).tR(bVar.DSw).tR(bVar.DSx);
                                            tO3.bfK();
                                        }
                                        if (bVar.DSs != 0) {
                                            com.tencent.mm.modelsns.k tO4 = com.tencent.mm.modelsns.k.tO(504);
                                            tO4.timeStamp = aVar.DSj;
                                            tO4.PH(bVar.DSr).tR(bVar.DSp).fL(bVar.DSq).tR(bVar.DSs).tR(bVar.DSz).tR(bVar.DSy).tR(bVar.DSA).tR(bVar.DSB);
                                            tO4.bfK();
                                        }
                                    }
                                }
                                com.tencent.mm.modelsns.k tO5 = com.tencent.mm.modelsns.k.tO(506);
                                tO5.timeStamp = aVar.DSj;
                                tO5.bfK();
                            }
                            AppMethodBeat.o(203676);
                            return r132;
                        }
                    });
                }
                com.tencent.mm.plugin.sns.k.e.DUQ.ix(firstVisiblePosition, lastVisiblePosition);
                com.tencent.mm.plugin.sns.k.e.DUQ.iy(firstVisiblePosition, lastVisiblePosition);
                AppMethodBeat.o(203687);
            }

            @Override // com.tencent.mm.plugin.sns.ui.SnsUIAction.a
            public final void aP(int i2, boolean z) {
                AppMethodBeat.i(203688);
                if (SnsTimeLineUI.this.EKT != null) {
                    SnsTimeLineUI.this.EKT.ESq.notifyVendingDataChange();
                }
                if (!z) {
                    SnsTimeLineUI.this.aBf().bk(c.b.class);
                }
                AppMethodBeat.o(203688);
            }

            @Override // com.tencent.mm.plugin.sns.ui.SnsUIAction.a
            public final void vy(boolean z) {
                AppMethodBeat.i(203689);
                SnsTimeLineUI snsTimeLineUI = SnsTimeLineUI.this;
                snsTimeLineUI.ELZ = z;
                MMHandler dRd = aj.dRd();
                com.tencent.mm.plugin.sns.model.g faL = aj.faL();
                com.tencent.mm.plugin.sns.model.c faJ = aj.faJ();
                if (z) {
                    if (faL.DGJ || faJ.DGJ) {
                        dRd.removeCallbacks(snsTimeLineUI.EMa);
                        dRd.removeCallbacks(snsTimeLineUI.EMb);
                        dRd.postDelayed(snsTimeLineUI.EMa, 0);
                        AppMethodBeat.o(203689);
                        return;
                    }
                } else if (!faL.DGJ || !faJ.DGJ) {
                    dRd.removeCallbacks(snsTimeLineUI.EMa);
                    dRd.removeCallbacks(snsTimeLineUI.EMb);
                    dRd.postDelayed(snsTimeLineUI.EMb, 0);
                }
                AppMethodBeat.o(203689);
            }

            @Override // com.tencent.mm.plugin.sns.ui.SnsUIAction.a
            public final void iR(int i2, int i3) {
            }

            @Override // com.tencent.mm.plugin.sns.ui.SnsUIAction.a
            public final void a(m mVar) {
            }
        };
        this.EMf = 0;
        this.EMg = new a.b<c.b>() {
            /* class com.tencent.mm.plugin.sns.ui.SnsTimeLineUI.AnonymousClass29 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // com.tencent.mm.vending.app.a.b
            public final /* synthetic */ void co(c.b bVar) {
                AppMethodBeat.i(203690);
                c.b bVar2 = bVar;
                if (bVar2 != null) {
                    if (bVar2.xhI > 0 || ((bVar2.FgG != null && bVar2.FgG.size() > 0) || (SnsTimeLineUI.this.mUIAction.DSh != null && SnsTimeLineUI.this.mUIAction.DSh.fie()))) {
                        SnsTimeLineUI.this.EKU.setVisibility(0);
                    } else {
                        SnsTimeLineUI.this.EKU.setVisibility(8);
                    }
                    if (bVar2.xhI <= 0 || SnsTimeLineUI.this.EMi != 0) {
                        SnsTimeLineUI.this.EKU.findViewById(R.id.hzd).setVisibility(8);
                    } else {
                        SnsTimeLineUI.a(SnsTimeLineUI.this, bVar2);
                        SnsTimeLineUI.this.EKU.findViewById(R.id.hzd).setVisibility(0);
                    }
                    if (bVar2.FgG == null || bVar2.FgG.size() <= 0) {
                        SnsTimeLineUI.this.EKV.setVisibility(8);
                    } else {
                        SnsTimeLineUI.this.EKV.setVisibility(0);
                        SnsTimeLineUI.this.EKV.removeAllViews();
                        for (Long l : bVar2.FgG) {
                            SnsTimeLineUI.b(SnsTimeLineUI.this, l.longValue());
                        }
                    }
                    if (SnsTimeLineUI.this.EKT != null && SnsTimeLineUI.this.ELc.hasDrawed()) {
                        SnsTimeLineUI.this.EKT.ESq.notifyVendingDataChange();
                        Log.i("MicroMsg.SnsTimeLineUI", "has not show view, pass");
                    }
                }
                AppMethodBeat.o(203690);
            }
        };
        this.mScreenWidth = 0;
        this.mScreenHeight = 0;
        this.EMh = true;
        this.zdW = 0;
        this.hlB = 0;
        this.iTC = 0;
        this.EyL = new ScreenShotUtil.ScreenShotCallback() {
            /* class com.tencent.mm.plugin.sns.ui.SnsTimeLineUI.AnonymousClass39 */

            @Override // com.tencent.mm.sdk.platformtools.ScreenShotUtil.ScreenShotCallback
            public final void onScreenShot(String str, long j2) {
                AppMethodBeat.i(203698);
                Log.i("MicroMsg.SnsTimeLineUI.ScreenShot", "onScreenShot， path = " + str + "， dateAdded = " + j2);
                SnsTimeLineUI.M(SnsTimeLineUI.this);
                AppMethodBeat.o(203698);
            }
        };
        this.EMi = 0;
        this.ubB = new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.sns.ui.SnsTimeLineUI.AnonymousClass54 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(203711);
                SnsTimeLineUI.this.hideVKB();
                SnsTimeLineUI.this.finish();
                AppMethodBeat.o(203711);
                return false;
            }
        };
        this.EMl = 0;
        this.EMm = false;
        AppMethodBeat.o(99372);
    }

    static /* synthetic */ void J(SnsTimeLineUI snsTimeLineUI) {
        AppMethodBeat.i(203739);
        snsTimeLineUI.fiZ();
        AppMethodBeat.o(203739);
    }

    static /* synthetic */ int V(SnsTimeLineUI snsTimeLineUI) {
        AppMethodBeat.i(203745);
        int fjc = snsTimeLineUI.fjc();
        AppMethodBeat.o(203745);
        return fjc;
    }

    static /* synthetic */ void aa(SnsTimeLineUI snsTimeLineUI) {
        AppMethodBeat.i(179308);
        snsTimeLineUI.fje();
        AppMethodBeat.o(179308);
    }

    static /* synthetic */ void ac(SnsTimeLineUI snsTimeLineUI) {
        AppMethodBeat.i(203746);
        snsTimeLineUI.fjd();
        AppMethodBeat.o(203746);
    }

    static /* synthetic */ void b(c cVar) {
        AppMethodBeat.i(203744);
        a(cVar);
        AppMethodBeat.o(203744);
    }

    static /* synthetic */ void b(SnsTimeLineUI snsTimeLineUI) {
        AppMethodBeat.i(99408);
        snsTimeLineUI.fiY();
        AppMethodBeat.o(99408);
    }

    static /* synthetic */ void b(SnsTimeLineUI snsTimeLineUI, int i2) {
        AppMethodBeat.i(203734);
        snsTimeLineUI.ZR(i2);
        AppMethodBeat.o(203734);
    }

    static /* synthetic */ void w(SnsTimeLineUI snsTimeLineUI) {
        AppMethodBeat.i(99414);
        snsTimeLineUI.fjb();
        AppMethodBeat.o(99414);
    }

    static /* synthetic */ void x(SnsTimeLineUI snsTimeLineUI) {
        AppMethodBeat.i(179295);
        snsTimeLineUI.fja();
        AppMethodBeat.o(179295);
    }

    static {
        AppMethodBeat.i(99430);
        AppMethodBeat.o(99430);
    }

    @Override // com.tencent.mm.plugin.sns.b.i.a
    public final void a(final String str, boolean z, final int i2, final com.tencent.mm.plugin.sns.b.b bVar) {
        AppMethodBeat.i(99373);
        this.EMc.removeCallbacks(this.ELC);
        g.hdG().d(new com.tencent.mm.vending.c.a<Void, Void>() {
            /* class com.tencent.mm.plugin.sns.ui.SnsTimeLineUI.AnonymousClass16 */

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // com.tencent.mm.vending.c.a
            public final /* synthetic */ Void call(Void r9) {
                AppMethodBeat.i(176301);
                Void r92 = r9;
                com.tencent.mm.plugin.sns.ui.a.c cVar = SnsTimeLineUI.this.EKT;
                if (cVar != null) {
                    long vC = cVar.vC(false);
                    long eZd = bVar.eZd();
                    if (eZd > vC || eZd <= r.aOw(cVar.ESq.fkf())) {
                        cVar.ESq.vD(false);
                    } else {
                        cVar.ESq.vD(true);
                    }
                    cVar.ESq.aRm("");
                    cVar.ESq.aRi(str);
                    cVar.ESq.axJ();
                    cVar.ESq.notifyVendingDataChange();
                }
                AppMethodBeat.o(176301);
                return r92;
            }
        }).f(new com.tencent.mm.vending.c.a<Void, Void>() {
            /* class com.tencent.mm.plugin.sns.ui.SnsTimeLineUI.AnonymousClass15 */

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // com.tencent.mm.vending.c.a
            public final /* synthetic */ Void call(Void r7) {
                AppMethodBeat.i(99282);
                Void r72 = r7;
                if (SnsTimeLineUI.this.ELb != null) {
                    SnsTimeLineUI.this.EKY = false;
                    SnsTimeLineUI.this.ELb.fjt();
                }
                SnsTimeLineUI.this.mUIAction.qeT = bVar.eZa();
                if (bVar.eZa()) {
                    SnsTimeLineUI.this.mUIAction.aRh(bVar.eZg());
                    if (SnsTimeLineUI.this.EMi == 1) {
                        SnsTimeLineUI.this.mUIAction.aQU(bVar.eZg());
                    }
                } else if (bVar.eZb()) {
                    com.tencent.mm.plugin.sns.ui.a.a.c cVar = SnsTimeLineUI.this.EKS;
                    SnsUIAction.a unused = SnsTimeLineUI.this.EMe;
                    cVar.e(SnsTimeLineUI.this.mRa, SnsTimeLineUI.this.ELk, SnsTimeLineUI.this.EqY, 0);
                }
                SnsTimeLineUI.this.mUIAction.fjz();
                aj.faZ().fbK();
                aj.faZ().Jw(0);
                AppMethodBeat.o(99282);
                return r72;
            }
        });
        AppMethodBeat.o(99373);
    }

    @Override // com.tencent.mm.plugin.sns.b.i.a
    public final void b(final String str, final boolean z, final int i2, final com.tencent.mm.plugin.sns.b.b bVar) {
        AppMethodBeat.i(99374);
        this.EMc.removeCallbacks(this.ELC);
        g.hdG().d(new com.tencent.mm.vending.c.a<Void, Void>() {
            /* class com.tencent.mm.plugin.sns.ui.SnsTimeLineUI.AnonymousClass18 */

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // com.tencent.mm.vending.c.a
            public final /* synthetic */ Void call(Void r5) {
                AppMethodBeat.i(179222);
                Void r52 = r5;
                com.tencent.mm.plugin.sns.ui.a.c cVar = SnsTimeLineUI.this.EKT;
                if (cVar != null) {
                    cVar.ESq.aRi(str);
                    cVar.ESq.fiE();
                    cVar.ESq.notifyVendingDataChange();
                }
                AppMethodBeat.o(179222);
                return r52;
            }
        }).f(new com.tencent.mm.vending.c.a<Void, Void>() {
            /* class com.tencent.mm.plugin.sns.ui.SnsTimeLineUI.AnonymousClass17 */

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // com.tencent.mm.vending.c.a
            public final /* synthetic */ Void call(Void r3) {
                AppMethodBeat.i(179221);
                Void a2 = a(r3);
                AppMethodBeat.o(179221);
                return a2;
            }

            private Void a(Void r7) {
                AppMethodBeat.i(203673);
                if (SnsTimeLineUI.this.ELb != null) {
                    SnsTimeLineUI.this.EKY = false;
                    SnsTimeLineUI.this.ELb.fjt();
                }
                SnsTimeLineUI.this.mUIAction.qeT = bVar.eZa();
                if (SnsTimeLineUI.this.EMi == 0) {
                    Log.d("MicroMsg.SnsTimeLineUI", "onNpSize %s", Boolean.valueOf(bVar.eZa()));
                    if (bVar.eZa()) {
                        SnsTimeLineUI.this.mUIAction.aRh(bVar.eZg());
                    }
                    AppMethodBeat.o(203673);
                } else {
                    if (!z || SnsTimeLineUI.this.ELj.equals(SnsTimeLineUI.this.mRa)) {
                        if (SnsTimeLineUI.this.ELj.equals(SnsTimeLineUI.this.mRa) && bVar.eZf() != 0) {
                            com.tencent.mm.kernel.g.aAi();
                            com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.USERINFO_SNS_RECENT_LIMITED_ID_LONG_SYNC, Long.valueOf(bVar.eZf()));
                        }
                        if (bVar.eZa()) {
                            SnsTimeLineUI.this.mUIAction.aRh(bVar.eZg());
                        }
                    } else {
                        SnsTimeLineUI.this.mUIAction.qeT = true;
                        SnsTimeLineUI.this.mUIAction.aQU(bVar.eZg());
                    }
                    AppMethodBeat.o(203673);
                }
                return r7;
            }
        });
        AppMethodBeat.o(99374);
    }

    @Override // com.tencent.mm.plugin.sns.b.i.a
    public final void a(String str, String str2, boolean z, int i2, final com.tencent.mm.plugin.sns.b.b bVar) {
        AppMethodBeat.i(203729);
        Log.i("MicroMsg.SnsTimeLineUI", "onOtherAddSize respMaxSeq:%s, respMinSeq:%s", str, str2);
        this.EMc.removeCallbacks(this.ELC);
        g.hdG().d(new com.tencent.mm.vending.c.a<Void, Void>() {
            /* class com.tencent.mm.plugin.sns.ui.SnsTimeLineUI.AnonymousClass20 */

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // com.tencent.mm.vending.c.a
            public final /* synthetic */ Void call(Void r6) {
                AppMethodBeat.i(203674);
                Void r62 = r6;
                com.tencent.mm.plugin.sns.ui.a.c cVar = SnsTimeLineUI.this.EKT;
                if (cVar != null) {
                    SnsTimeLineUI.this.ELs = cVar.vC(true);
                    cVar.ESq.fiE();
                    cVar.ESq.notifyVendingDataChange();
                }
                AppMethodBeat.o(203674);
                return r62;
            }
        }).f(new com.tencent.mm.vending.c.a<Void, Void>() {
            /* class com.tencent.mm.plugin.sns.ui.SnsTimeLineUI.AnonymousClass19 */

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // com.tencent.mm.vending.c.a
            public final /* synthetic */ Void call(Void r8) {
                boolean z;
                AppMethodBeat.i(179223);
                Void r82 = r8;
                aj.faZ().DNI = false;
                if (SnsTimeLineUI.this.EKT != null) {
                    long vC = SnsTimeLineUI.this.EKT.vC(false);
                    z = vC != 0 && vC >= r.aOw(SnsTimeLineUI.this.EKT.ESq.fke());
                } else {
                    z = false;
                }
                if (bVar.eZh() || z) {
                    SnsTimeLineUI.this.mUIAction.vz(false);
                }
                AppMethodBeat.o(179223);
                return r82;
            }
        });
        AppMethodBeat.o(203729);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void setActionbarColor(int i2) {
        AppMethodBeat.i(99375);
        super.setActionbarColor(i2);
        if (Build.VERSION.SDK_INT >= 21 && this.BdQ != null) {
            this.BdQ.setBackgroundColor(getWindow().getStatusBarColor());
            com.tencent.mm.ui.statusbar.d.e(getWindow());
        }
        AppMethodBeat.o(99375);
    }

    private void ZR(int i2) {
        boolean z;
        AppMethodBeat.i(99376);
        if (ELX.booleanValue()) {
            Object[] objArr = new Object[2];
            if (i2 == 0) {
                z = true;
            } else {
                z = false;
            }
            objArr[0] = Boolean.valueOf(z);
            objArr[1] = Util.getStack().toString();
            Log.i("MicroMsg.SnsTimeLineUI", "setRefreshAnimVisible %s %s", objArr);
        }
        this.EKW.setVisibility(i2);
        AppMethodBeat.o(99376);
    }

    /* access modifiers changed from: package-private */
    public class a extends Animation {
        int AGw = 600;
        private float EMJ;
        private float EMK;
        float EML = -1.0f;
        float EMM;
        private float EMN = 50.0f;
        private float EMO = 10.0f;
        float EMP = 0.0f;
        private float EMQ = 0.0f;
        private float EMR;
        private float EMS;
        boolean EMT;
        int EMU;
        boolean EMV = false;
        int EMW = 0;
        float EMX = 0.0f;
        float EMY = 0.0f;
        float EMZ = 0.0f;
        float ENa = 0.0f;
        private ListView list;

        public a(ListView listView) {
            this.list = listView;
        }

        public final void bZ(float f2) {
            float f3;
            AppMethodBeat.i(99360);
            if (this.list != null) {
                if (this.list.getFirstVisiblePosition() != 0) {
                    SnsTimeLineUI.b(SnsTimeLineUI.this, 8);
                } else if (SnsTimeLineUI.this.mUIAction.DSh.getTop() >= SnsTimeLineUI.this.ELb.EMU) {
                    SnsTimeLineUI.b(SnsTimeLineUI.this, 0);
                }
            }
            if (SnsTimeLineUI.ELX.booleanValue()) {
                Log.d("MicroMsg.RefreshAnim", "animtest setDistanceY %s %s %s", Float.valueOf(f2), Float.valueOf(this.EMM), Float.valueOf(this.EML));
            }
            if (SnsTimeLineUI.this.EKW.getVisibility() != 0) {
                AppMethodBeat.o(99360);
                return;
            }
            SnsTimeLineUI.this.EKW.clearAnimation();
            init();
            if (f2 <= (-this.EMN)) {
                f2 = -this.EMN;
            }
            if (f2 >= this.EMN) {
                f2 = this.EMN;
            }
            if (f2 < 0.0f) {
                this.EMP -= f2 * 2.0f;
            } else {
                this.EMP -= f2 / 2.0f;
            }
            float f4 = this.EMP;
            if (f4 < this.EMM) {
                f4 = this.EMM;
                this.EMP = this.EMM;
            }
            if (f4 > this.EML) {
                f4 = this.EML;
                this.EMP = this.EML;
            }
            if (SnsTimeLineUI.ELX.booleanValue()) {
                Log.d("MicroMsg.RefreshAnim", "animtest setDistanceY %s %s %s sumY %s translateY %s distanceY %s", Float.valueOf(f2), Float.valueOf(this.EMM), Float.valueOf(this.EML), Float.valueOf(this.EMP), Float.valueOf(f4), Float.valueOf(this.EMN));
            }
            if (f4 == this.EML) {
                f3 = f2 * 2.0f;
            } else {
                f3 = 5.0f * f2;
            }
            SnsTimeLineUI.this.EKW.setScaleType(QImageView.a.MATRIX);
            SnsTimeLineUI.this.EKW.getImageMatrix().postRotate(f3, this.EMJ, this.EMK);
            SnsTimeLineUI.this.EKW.setImageResource(R.raw.friendactivity_refresh);
            AbsoluteLayout.LayoutParams layoutParams = (AbsoluteLayout.LayoutParams) SnsTimeLineUI.this.EKW.getLayoutParams();
            layoutParams.y = (int) f4;
            SnsTimeLineUI.this.EKW.setLayoutParams(layoutParams);
            SnsTimeLineUI.this.EKW.invalidate();
            AppMethodBeat.o(99360);
        }

        public final void fjs() {
            AppMethodBeat.i(99361);
            if (SnsTimeLineUI.ELX.booleanValue()) {
                Log.d("MicroMsg.RefreshAnim", "animtest playLoading");
            }
            if (SnsTimeLineUI.this.EKW.getVisibility() != 0) {
                AppMethodBeat.o(99361);
                return;
            }
            init();
            this.EMP = this.EML + 20.0f;
            AbsoluteLayout.LayoutParams layoutParams = (AbsoluteLayout.LayoutParams) SnsTimeLineUI.this.EKW.getLayoutParams();
            layoutParams.y = (int) this.EML;
            SnsTimeLineUI.this.EKW.setLayoutParams(layoutParams);
            fju();
            AppMethodBeat.o(99361);
        }

        public final void fjt() {
            AppMethodBeat.i(99362);
            if (SnsTimeLineUI.ELX.booleanValue()) {
                Log.i("MicroMsg.RefreshAnim", "play end vis: %d, sumY %f MAX_Y %f", Integer.valueOf(SnsTimeLineUI.this.EKW.getVisibility()), Float.valueOf(this.EMP), Float.valueOf(this.EML));
            }
            if (SnsTimeLineUI.this.EKW.getVisibility() != 0) {
                AppMethodBeat.o(99362);
                return;
            }
            init();
            if (this.EMP < this.EML - this.EMO) {
                AppMethodBeat.o(99362);
                return;
            }
            SnsTimeLineUI.this.EKW.clearAnimation();
            JT((long) (this.AGw + 100));
            SnsTimeLineUI.this.EKW.startAnimation(this);
            this.EMT = false;
            AppMethodBeat.o(99362);
        }

        /* access modifiers changed from: package-private */
        public final void JT(long j2) {
            AppMethodBeat.i(99363);
            if (SnsTimeLineUI.ELX.booleanValue()) {
                Log.d("MicroMsg.RefreshAnim", "setDurationTime durationMillis %s %s", Long.valueOf(j2), Util.getStack().toString());
            }
            setDuration(j2);
            AppMethodBeat.o(99363);
        }

        public final void fju() {
            AppMethodBeat.i(99364);
            if (SnsTimeLineUI.ELX.booleanValue()) {
                Log.d("MicroMsg.RefreshAnim", "animtest setAcitonUp");
            }
            if (SnsTimeLineUI.this.EKW.getVisibility() != 0) {
                AppMethodBeat.o(99364);
                return;
            }
            init();
            SnsTimeLineUI.this.EKW.clearAnimation();
            if (SnsTimeLineUI.ELX.booleanValue()) {
                Log.v("MicroMsg.RefreshAnim", "setAcitonUp1 sumY  %s MAX_Y %s %s", Float.valueOf(this.EMP), Float.valueOf(this.EML), Util.getStack().toString());
            }
            SnsTimeLineUI.this.EKW.startAnimation(this);
            if (this.EMP >= this.EML - this.EMO) {
                JT(20000);
                this.EMT = false;
                AppMethodBeat.o(99364);
                return;
            }
            JT((long) (this.AGw + 100));
            this.EMT = true;
            AppMethodBeat.o(99364);
        }

        /* access modifiers changed from: package-private */
        public final void init() {
            AppMethodBeat.i(99365);
            if (this.EML == -1.0f || ((double) this.EMK) < 0.1d) {
                this.EML = (float) BackwardSupportUtil.BitmapFactory.fromDPToPix(SnsTimeLineUI.this, 70.0f);
                this.EMN = (float) BackwardSupportUtil.BitmapFactory.fromDPToPix(SnsTimeLineUI.this, 16.0f);
                this.EMJ = (float) (SnsTimeLineUI.this.EKW.getWidth() / 2);
                this.EMK = (float) (SnsTimeLineUI.this.EKW.getHeight() / 2);
                this.EMQ = (float) ((-SnsTimeLineUI.this.EKW.getHeight()) * 2);
                if (this.EMQ == 0.0f) {
                    this.EMQ = (float) (-BackwardSupportUtil.BitmapFactory.fromDPToPix(SnsTimeLineUI.this, 40.0f));
                }
                this.EMM = this.EMQ;
                if (SnsTimeLineUI.ELX.booleanValue()) {
                    Log.d("MicroMsg.RefreshAnim", "init MIN_Y %s MAX_Y %s targetInitY %s distanceY %s", Float.valueOf(this.EMM), Float.valueOf(this.EML), Float.valueOf(this.EMQ), Float.valueOf(this.EMN));
                }
                this.EMP = this.EMM;
                if (!this.EMV) {
                    if (SnsTimeLineUI.ELX.booleanValue()) {
                        Log.i("MicroMsg.RefreshAnim", "initState");
                    }
                    this.EMW = ((AbsoluteLayout.LayoutParams) SnsTimeLineUI.this.EKW.getLayoutParams()).y;
                    this.EMX = this.EML;
                    this.EMY = this.EMP;
                }
                this.EMV = true;
            }
            AppMethodBeat.o(99365);
        }

        /* access modifiers changed from: protected */
        public final void applyTransformation(float f2, Transformation transformation) {
            AppMethodBeat.i(99366);
            if (SnsTimeLineUI.ELX.booleanValue()) {
                Log.d("MicroMsg.RefreshAnim", "animtest applyTransformation vis %s interpolatedTime %s isJustUp %s", Integer.valueOf(SnsTimeLineUI.this.EKW.getVisibility()), Float.valueOf(f2), Boolean.valueOf(this.EMT));
            }
            if (SnsTimeLineUI.this.EKW.getVisibility() != 0) {
                AppMethodBeat.o(99366);
                return;
            }
            float duration = (f2 - this.EMR) * ((float) getDuration());
            if (duration < 2.0f) {
                if (SnsTimeLineUI.ELX.booleanValue()) {
                    Log.d("MicroMsg.RefreshAnim", "applyTransformation wawawa %s", Float.valueOf(duration));
                }
                AppMethodBeat.o(99366);
                return;
            }
            this.EMR = f2;
            SnsTimeLineUI.this.EKW.setImageResource(R.raw.friendactivity_refresh);
            SnsTimeLineUI.this.EKW.setScaleType(QImageView.a.MATRIX);
            if (((float) getDuration()) * f2 >= ((float) (getDuration() - ((long) this.AGw))) || this.EMT) {
                AbsoluteLayout.LayoutParams layoutParams = (AbsoluteLayout.LayoutParams) SnsTimeLineUI.this.EKW.getLayoutParams();
                if (((float) layoutParams.y) <= this.EMQ) {
                    AppMethodBeat.o(99366);
                    return;
                }
                if (this.EMZ == 0.0f) {
                    this.EMZ = (-this.EMQ) + ((float) layoutParams.y);
                    this.ENa = (float) layoutParams.y;
                    this.EMS = f2;
                }
                float f3 = (f2 - this.EMS) / (1.0f - this.EMS);
                float f4 = this.EMZ * f3;
                float f5 = this.ENa - f4;
                if (SnsTimeLineUI.ELX.booleanValue()) {
                    Log.i("MicroMsg.RefreshAnim", "animcheck interpolatedTime y %s duration %s factor %s residualTime %s pass %s ", Float.valueOf(f5), Long.valueOf(getDuration()), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(this.EMS * ((float) getDuration())));
                }
                if (((float) layoutParams.y) > f5) {
                    layoutParams.y = (int) f5;
                }
                this.EMP = (float) layoutParams.y;
                SnsTimeLineUI.this.EKW.setLayoutParams(layoutParams);
            } else {
                if (SnsTimeLineUI.ELX.booleanValue()) {
                    Log.d("MicroMsg.RefreshAnim", "animcheck delt Rotate " + (duration / 2.5f));
                }
                SnsTimeLineUI.this.EKW.getImageMatrix().postRotate(duration / 2.5f, this.EMJ, this.EMK);
            }
            SnsTimeLineUI.this.EKW.invalidate();
            AppMethodBeat.o(99366);
        }

        public final void initialize(int i2, int i3, int i4, int i5) {
            AppMethodBeat.i(99367);
            super.initialize(i2, i3, i4, i5);
            if (SnsTimeLineUI.ELX.booleanValue()) {
                Log.i("MicroMsg.RefreshAnim", "anim initialize %s", Util.getStack().toString());
            }
            this.EMR = 0.0f;
            this.EMS = 0.0f;
            this.EMZ = 0.0f;
            this.ENa = 0.0f;
            AppMethodBeat.o(99367);
        }
    }

    private void fiY() {
        AppMethodBeat.i(99377);
        this.mUIAction.list.postDelayed(new Runnable() {
            /* class com.tencent.mm.plugin.sns.ui.SnsTimeLineUI.AnonymousClass26 */

            public final void run() {
                AppMethodBeat.i(99306);
                int firstVisiblePosition = SnsTimeLineUI.this.mUIAction.list.getFirstVisiblePosition();
                int lastVisiblePosition = SnsTimeLineUI.this.mUIAction.list.getLastVisiblePosition();
                Log.d("MicroMsg.SnsTimeLineUI", "notifyList from:%s to:%s", Integer.valueOf(firstVisiblePosition), Integer.valueOf(lastVisiblePosition));
                SnsTimeLineUI.a(SnsTimeLineUI.this, firstVisiblePosition, lastVisiblePosition);
                SnsTimeLineUI.this.mUIAction.bIW();
                AppMethodBeat.o(99306);
            }
        }, 15);
        AppMethodBeat.o(99377);
    }

    @Override // android.support.v4.app.SupportActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        boolean z = false;
        AppMethodBeat.i(99378);
        Log.i("MicroMsg.SnsTimeLineUI", "dispatchKeyEvent %s", keyEvent.toString());
        int keyboardState = keyboardState();
        i iVar = this.EKZ;
        if (keyEvent.getKeyCode() == 4 && iVar.EoJ.getVisibility() == 0) {
            iVar.EoJ.setVisibility(8);
            z = true;
        }
        if (!z || keyboardState != 2) {
            boolean dispatchKeyEvent = super.dispatchKeyEvent(keyEvent);
            AppMethodBeat.o(99378);
            return dispatchKeyEvent;
        }
        AppMethodBeat.o(99378);
        return true;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.kiss.WxPresenterActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        aw awVar;
        boolean z;
        boolean z2;
        c.a aVar;
        String str;
        int i2;
        com.tencent.mm.plugin.sns.m.a aVar2;
        SnsObject C;
        boolean z3;
        AppMethodBeat.i(99379);
        if (ELn == null) {
            ELn = Boolean.valueOf(ao.isDarkMode());
            f.resetConfig();
        } else if (ELn.booleanValue() != ao.isDarkMode()) {
            Log.i("MicroMsg.SnsTimeLineUI", "dancy test UIMode change!!");
            ELn = Boolean.valueOf(ao.isDarkMode());
            f.resetConfig();
        }
        com.tencent.mm.plugin.sns.model.b.a.fcd();
        az faM = aj.faM();
        faM.jrf = true;
        Log.i("MicroMsg.SnsVideoService", "set isInSnsTimeline:%b", Boolean.valueOf(faM.jrf));
        if ((faM.jrf && !com.tencent.mm.plugin.sns.model.b.a.fce()) || faM.jre) {
            faM.fbN();
        }
        o.bhl().fP(faM.jrf);
        aw faZ = aj.faZ();
        if (BuildInfo.DEBUG) {
            faZ.DNn = true;
            faZ.DNo = 1;
            faZ.DNp = 86400;
            faZ.DNq = 1;
            faZ.DNr = 1;
            faZ.DNs = 50;
            faZ.DNu = 2;
            faZ.DNt = 5;
            faZ.DNv = 0;
        } else {
            if (BuildInfo.IS_FLAVOR_RED || BuildInfo.IS_FLAVOR_PURPLE) {
                z = true;
                awVar = faZ;
            } else if (((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_timeline_unread_jump_switch_android, 1) == 1) {
                z = true;
                awVar = faZ;
            } else {
                z = false;
                awVar = faZ;
            }
            awVar.DNn = z;
            faZ.DNo = (long) ((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_timeline_unread_jump_min_interval_android, LocalCache.TIME_HOUR);
            faZ.DNq = ((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_timeline_unread_jump_min_feeds_android, 5);
            faZ.DNr = ((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_timeline_unread_jump_min_skip_feeds_android, 10);
            faZ.DNp = ((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_timeline_unread_jump_max_interval_android, 86400L);
            faZ.DNs = ((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_timeline_unread_jump_not_ws_percent_android, 0);
            faZ.DNu = ((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_timeline_unread_jump_indicator_index_offset_android, 1);
            faZ.DNt = ((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_timeline_unread_jump_read_continuous_feeds_android, 2);
            faZ.DNv = (long) ((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_timeline_unread_jump_indicator_expose_interval_android, 14400);
        }
        Log.i("MicroMsg.SnsUnreadTipManager", "jumpEnable:%s, jumpMinInterval:%s, jumpMaxInterval:%s, jumpMinFeedsCount:%s, jumpMinFeedsGapCount:%s, jumpNotWsPercent:%s, jumpIndicatorIndexOffset:%s, jumpReadContinuousCount:%s, jumpIndicatorExposeInterval:%s", Boolean.valueOf(faZ.DNn), Long.valueOf(faZ.DNo), Long.valueOf(faZ.DNp), Integer.valueOf(faZ.DNq), Integer.valueOf(faZ.DNr), Integer.valueOf(faZ.DNs), Integer.valueOf(faZ.DNu), Integer.valueOf(faZ.DNt), Long.valueOf(faZ.DNv));
        if (faZ.DNn) {
            faZ.DNm = aj.getAccSnsPath() + "snsUnread.proto";
            try {
                byte[] aW = s.aW(faZ.DNm, 0, -1);
                if (aW != null && aW.length > 0) {
                    faZ.DNJ.parseFrom(aW);
                    int aWB = cl.aWB();
                    Log.i("MicroMsg.SnsUnreadTipManager", "unreadSnsIdList.indicatorExposeTime:%s, now:%s, jumpIndicatorExposeInterval:%s", Long.valueOf(faZ.DNJ.DNN), Integer.valueOf(aWB), Long.valueOf(faZ.DNv));
                    if (faZ.DNJ.DNN > 0 && ((long) aWB) - faZ.DNJ.DNN > faZ.DNv) {
                        faZ.DNJ.DNN = 0;
                    } else if (faZ.DNJ.DNN < 0) {
                        faZ.DNJ.DNN = 0;
                    }
                    faZ.DNN = faZ.DNJ.DNN;
                    faZ.fbG();
                }
            } catch (Exception e2) {
                Log.w("MicroMsg.SnsUnreadTipManager", "Exception:%s", e2.getMessage());
            }
            faZ.fbE();
            faZ.fbF();
            Log.i("MicroMsg.SnsUnreadTipManager", "firstUnreadId:%s unreadSnsIdList.lastSnsId:%s", Long.valueOf(faZ.DNA), Long.valueOf(faZ.DNJ.DRZ));
        }
        faZ.fbH();
        faZ.sessionId = ((com.tencent.mm.plugin.expt.b.c) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.c.class)).cME();
        av avVar = faZ.DNT;
        com.tencent.mm.kernel.g.aAg().hqi.a(211, avVar);
        avVar.DNl = ((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_timeline_unread_jump_preload_max_count_android, 50);
        Log.i("MicroMsg.SnsUnreadPreloader", "onCreate PRELOAD_MAX_COUNT:%s", Integer.valueOf(avVar.DNl));
        com.tencent.mm.plugin.sns.model.at fba = aj.fba();
        Log.i(com.tencent.mm.plugin.sns.model.at.TAG, "create");
        if (BuildInfo.DEBUG || BuildInfo.IS_FLAVOR_RED || BuildInfo.IS_FLAVOR_PURPLE) {
            com.tencent.mm.plugin.sns.model.at.DMS = (long) (((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_sns_retry_edit_expired_time, 300) * 1000);
            com.tencent.mm.plugin.sns.model.at.DMT = ((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_sns_retry_edit_enable, 1) == 1;
            com.tencent.mm.plugin.sns.model.at.DMU = ((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_sns_retry_edit_interval, 60);
        } else {
            com.tencent.mm.plugin.sns.model.at.DMS = (long) (((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_sns_retry_edit_expired_time, 300) * 1000);
            if (((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_sns_retry_edit_enable, 1) == 1) {
                z3 = true;
            } else {
                z3 = false;
            }
            com.tencent.mm.plugin.sns.model.at.DMT = z3;
            com.tencent.mm.plugin.sns.model.at.DMU = ((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_sns_retry_edit_interval, 60);
        }
        Log.i(com.tencent.mm.plugin.sns.model.at.TAG, "updateConfig configEnable:%s, configInterval:%s, configExpiredTime:%s", Boolean.valueOf(com.tencent.mm.plugin.sns.model.at.DMT), Integer.valueOf(com.tencent.mm.plugin.sns.model.at.DMU), Long.valueOf(com.tencent.mm.plugin.sns.model.at.DMS));
        if (fba.DMV != 0) {
            if (Util.milliSecondsToNow(fba.DMV) >= com.tencent.mm.plugin.sns.model.at.DMS) {
                Log.i(com.tencent.mm.plugin.sns.model.at.TAG, "already expired, reset directly");
                MMHandlerThread.postToMainThread(fba.DMZ);
            } else {
                long milliSecondsToNow = com.tencent.mm.plugin.sns.model.at.DMS - Util.milliSecondsToNow(fba.DMV);
                Log.i(com.tencent.mm.plugin.sns.model.at.TAG, "delay %s to reset", Long.valueOf(milliSecondsToNow));
                MMHandlerThread.postToMainThreadDelayed(fba.DMZ, milliSecondsToNow);
            }
            if (!(fba.DMX == null || (C = an.C(fba.DMX)) == null)) {
                com.tencent.mm.plugin.sns.k.e.DUQ.DVz.xm(fba.DMY);
                com.tencent.mm.plugin.sns.k.e.DUQ.DVz.xl(r.Jc(fba.DMX.field_snsId));
                com.tencent.mm.plugin.sns.k.e.DUQ.DVz.eTY = (long) C.LikeCount;
                com.tencent.mm.plugin.sns.k.e.DUQ.DVz.eTZ = (long) C.CommentCount;
                com.tencent.mm.plugin.sns.k.e.DUQ.DVz.xn(String.valueOf(System.currentTimeMillis()));
                com.tencent.mm.plugin.sns.k.e.DUQ.DVA.xm(fba.DMY);
                com.tencent.mm.plugin.sns.k.e.DUQ.DVA.xl(r.Jc(fba.DMX.field_snsId));
                com.tencent.mm.plugin.sns.k.e.DUQ.DVA.eTY = (long) C.LikeCount;
                com.tencent.mm.plugin.sns.k.e.DUQ.DVA.eTZ = (long) C.CommentCount;
                com.tencent.mm.plugin.sns.k.e.DUQ.DVA.xn(String.valueOf(System.currentTimeMillis()));
            }
        }
        if (com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.brandservice.a.b.class) != null) {
            ((com.tencent.mm.plugin.brandservice.a.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.brandservice.a.b.class)).ahx("__sns_timeline__");
        }
        if (this.mController != null) {
            this.mController.bF(2, true);
        }
        getIntent().setExtrasClassLoader(getClass().getClassLoader());
        h.q(this);
        customfixStatusbar(true);
        super.onCreate(bundle);
        if (!com.tencent.mm.kernel.g.aAf().azp()) {
            finish();
            AppMethodBeat.o(99379);
            return;
        }
        this.BdQ = findViewById(R.id.c_);
        if (this.BdQ != null && com.tencent.mm.ui.statusbar.c.Qow) {
            com.tencent.mm.ui.statusbar.c bt = com.tencent.mm.ui.statusbar.c.bt(this);
            AnonymousClass21 r1 = new c.a() {
                /* class com.tencent.mm.plugin.sns.ui.SnsTimeLineUI.AnonymousClass21 */

                @Override // com.tencent.mm.ui.statusbar.c.a
                public final void yf(int i2) {
                    AppMethodBeat.i(203675);
                    SnsTimeLineUI.this.BdQ.setPadding(0, i2, 0, 0);
                    AppMethodBeat.o(203675);
                }
            };
            this.BdS = r1;
            bt.a(r1);
            getWindow().getDecorView().requestApplyInsets();
            com.tencent.mm.ui.statusbar.d.e(getWindow());
        }
        getWindow().getDecorView().setSystemUiVisibility(TAVExporter.VIDEO_EXPORT_HEIGHT);
        SharedPreferences defaultPreference = MMApplicationContext.getDefaultPreference();
        if (defaultPreference != null) {
            z2 = defaultPreference.getBoolean("Main_need_read_top_margin", false);
        } else {
            z2 = false;
        }
        com.tencent.mm.ui.b.e(this, z2);
        this.ELa = (int) (((double) getResources().getDisplayMetrics().heightPixels) * 0.4d);
        setActionbarColor(getContext().getResources().getColor(R.color.ac_));
        hideActionbarLine();
        this.EMi = getIntent().getIntExtra("sns_adapter_type", 0);
        this.EKY = getIntent().getBooleanExtra("sns_timeline_NeedFirstLoadint", false);
        this.mActionBar = getSupportActionBar();
        int gO = com.tencent.mm.model.c.d.aXv().gO("Sns_Private_Recent_Setting_Guide", 0);
        Log.i("MicroMsg.SnsTimeLineUI", "Sns_Private_Recent_Setting_Guide abtestvalue = ".concat(String.valueOf(gO)));
        if (gO == 1) {
            com.tencent.mm.kernel.g.aAi();
            if (!com.tencent.mm.kernel.g.aAh().azQ().getBoolean(ar.a.USERINFO_SNS_INTRODUCE_SETTING_DISPLAY_BOOLEAN_SYNC, false)) {
                Intent intent = getIntent();
                intent.setClass(getContext(), SnsSettingIntroduceUI.class);
                com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                com.tencent.mm.hellhoundlib.a.a.a(this, bl.axQ(), "com/tencent/mm/plugin/sns/ui/SnsTimeLineUI", "onCreate", "(Landroid/os/Bundle;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                startActivity((Intent) bl.pG(0));
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsTimeLineUI", "onCreate", "(Landroid/os/Bundle;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                overridePendingTransition(0, 0);
                finish();
                com.tencent.mm.kernel.g.aAi();
                com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.USERINFO_SNS_INTRODUCE_SETTING_DISPLAY_BOOLEAN_SYNC, Boolean.TRUE);
            }
        }
        this.ELq.EGI = new bf.b() {
            /* class com.tencent.mm.plugin.sns.ui.SnsTimeLineUI.AnonymousClass30 */

            @Override // com.tencent.mm.plugin.sns.ui.bf.b
            public final void fix() {
                AppMethodBeat.i(203691);
                SnsTimeLineUI.J(SnsTimeLineUI.this);
                AppMethodBeat.o(203691);
            }
        };
        fiZ();
        com.tencent.f.h.RTc.aX(new Runnable() {
            /* class com.tencent.mm.plugin.sns.ui.SnsTimeLineUI.AnonymousClass31 */

            public final void run() {
                AppMethodBeat.i(203692);
                Log.i("MicroMsg.SnsTimeLineUI", "%s", com.tencent.mm.plugin.performance.watchdogs.c.eCH().S(true, 0));
                AppMethodBeat.o(203692);
            }
        });
        this.EKR.a(c.b.class, this.EMg);
        com.tencent.mm.plugin.sns.ui.a.a.c cVar = this.EKS;
        int i3 = this.EMi;
        Intent intent2 = getIntent();
        com.tencent.mm.plugin.sns.m.b bVar = this.EKQ;
        cVar.EMi = i3;
        cVar.hasInit = true;
        if (i3 == 0) {
            com.tencent.mm.plugin.sns.ui.a.a.b bVar2 = cVar.ESM;
            bVar2.EKQ = bVar;
            if (bVar != null) {
                aVar2 = bVar.flo();
            } else {
                aVar2 = null;
            }
            bVar2.EKR = aVar2;
            cVar.ESM.EKR.a(this);
        } else {
            cVar.ESN = new c.a();
            cVar.ESN.mRa = intent2.getStringExtra("sns_userName");
            cVar.ESN.ELj = z.aTY();
            c.a aVar3 = cVar.ESN;
            com.tencent.mm.kernel.g.aAi();
            aVar3.ELk = ((l) com.tencent.mm.kernel.g.af(l.class)).aSN().bjG(cVar.ESN.mRa);
            cVar.ESN.EqY = z.aTY().equals(cVar.ESN.mRa);
            cVar.ESN.ELl = intent2.getIntExtra("sns_source", 0);
            cVar.ESN.krY = Util.nullAs(intent2.getStringExtra("sns_nickName"), "");
            cVar.ESN.mSignature = Util.nullAs(intent2.getStringExtra("sns_signature"), "");
        }
        com.tencent.mm.plugin.sns.ui.a.a.c cVar2 = this.EKS;
        if (cVar2.EMi == 0) {
            aVar = (c.a) cVar2.ESM.EKR.y(c.a.class);
        } else {
            aVar = cVar2.ESN;
        }
        this.mRa = aVar.mRa;
        this.ELj = aVar.ELj;
        this.ELk = aVar.ELk;
        this.EqY = aVar.EqY;
        this.ELl = aVar.ELl;
        String str2 = aVar.krY;
        String str3 = aVar.mSignature;
        this.mSessionId = com.tencent.mm.ui.e.avA("123");
        this.ELm = String.valueOf(System.currentTimeMillis());
        this.mUIAction = new SnsUIAction(this);
        this.mUIAction.setSessionId(this.mSessionId);
        this.mUIAction.DTT = this.ELm;
        this.mUIAction.EOI = this.EMe;
        this.mUIAction.actionbarView = this.mActionBar.getCustomView();
        ((com.tencent.mm.plugin.notification.b.a) com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.notification.b.a.class)).getNotification().nS(2);
        f.fll().Fff = 0;
        com.tencent.mm.plugin.sns.ui.widget.d.fli().Fff = 0;
        com.tencent.mm.modelsns.l lVar = com.tencent.mm.modelsns.l.jlw;
        com.tencent.mm.modelsns.l.bfL();
        this.EKZ = new i(this, getIntent().getBooleanExtra("is_sns_notify_open", true) ? 1 : 0, Util.nullAs(getIntent().getStringExtra("new_feed_id"), ""), getIntent().getIntExtra("sns_unread_count", 0), this.ELm);
        this.EKZ.EoI = new i.b() {
            /* class com.tencent.mm.plugin.sns.ui.SnsTimeLineUI.AnonymousClass32 */

            {
                AppMethodBeat.i(99315);
                AppMethodBeat.o(99315);
            }

            @Override // com.tencent.mm.plugin.sns.ui.i.b
            public final void ffv() {
                int i2;
                int size;
                AppMethodBeat.i(203693);
                com.tencent.mm.plugin.report.service.h.INSTANCE.dN(1295, 2);
                aw faZ = aj.faZ();
                if (faZ.DNn) {
                    aj.eJP().post(
                    /*  JADX ERROR: Method code generation error
                        jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0022: INVOKE  
                          (wrap: com.tencent.mm.sdk.platformtools.MMHandler : 0x0019: INVOKE  (r1v40 com.tencent.mm.sdk.platformtools.MMHandler) =  type: STATIC call: com.tencent.mm.plugin.sns.model.aj.eJP():com.tencent.mm.sdk.platformtools.MMHandler)
                          (wrap: com.tencent.mm.plugin.sns.model.aw$4 : 0x001f: CONSTRUCTOR  (r3v20 com.tencent.mm.plugin.sns.model.aw$4) = (r0v1 'faZ' com.tencent.mm.plugin.sns.model.aw) call: com.tencent.mm.plugin.sns.model.aw.4.<init>(com.tencent.mm.plugin.sns.model.aw):void type: CONSTRUCTOR)
                         type: VIRTUAL call: com.tencent.mm.sdk.platformtools.MMHandler.post(java.lang.Runnable):boolean in method: com.tencent.mm.plugin.sns.ui.SnsTimeLineUI.32.ffv():void, file: classes3.dex
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:217)
                        	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:110)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:56)
                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                        	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:143)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                        	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:244)
                        	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:237)
                        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:342)
                        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:295)
                        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:264)
                        	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                        	at java.util.ArrayList.forEach(ArrayList.java:1259)
                        	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                        	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                        Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x001f: CONSTRUCTOR  (r3v20 com.tencent.mm.plugin.sns.model.aw$4) = (r0v1 'faZ' com.tencent.mm.plugin.sns.model.aw) call: com.tencent.mm.plugin.sns.model.aw.4.<init>(com.tencent.mm.plugin.sns.model.aw):void type: CONSTRUCTOR in method: com.tencent.mm.plugin.sns.ui.SnsTimeLineUI.32.ffv():void, file: classes3.dex
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                        	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
                        	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
                        	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:806)
                        	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:746)
                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                        	... 19 more
                        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.tencent.mm.plugin.sns.model.aw, state: GENERATED_AND_UNLOADED
                        	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
                        	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                        	... 25 more
                        */
                    /*
                    // Method dump skipped, instructions count: 606
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.sns.ui.SnsTimeLineUI.AnonymousClass32.ffv():void");
                }
            };
            this.EoO = getIntent().getBooleanExtra("sns_resume_state", true);
            if (aj.isInValid()) {
                this.EoO = false;
            } else if (this.EoO) {
                this.EoO = aj.faY().fgK();
            }
            this.EKX = this.EoO;
            this.mUIAction.a(this.ELj, this.mRa, str2, str3, this.ELk, this.EqY, this.ELl);
            this.mUIAction.onCreate();
            aj.faF().init();
            com.tencent.mm.kernel.g.aAi();
            com.tencent.mm.kernel.g.aAg().hqi.a(213, this);
            com.tencent.mm.kernel.g.aAi();
            com.tencent.mm.kernel.g.aAg().hqi.a(com.tencent.mm.plugin.appbrand.jsapi.pay.k.CTRL_INDEX, this);
            com.tencent.mm.kernel.g.aAi();
            com.tencent.mm.kernel.g.aAg().hqi.a(218, this);
            com.tencent.mm.kernel.g.aAi();
            com.tencent.mm.kernel.g.aAg().hqi.a(211, this);
            com.tencent.mm.kernel.g.aAi();
            com.tencent.mm.kernel.g.aAg().hqi.a(683, this);
            com.tencent.mm.plugin.sns.ui.video.d.fkS().fkT();
            initView();
            com.tencent.mm.plugin.sns.h.c faF = aj.faF();
            ListView listView = this.mUIAction.list;
            bk bkVar = this.EKT.ESp;
            faF.DQW = listView;
            faF.DQX = bkVar;
            com.tencent.mm.plugin.sns.h.c faF2 = aj.faF();
            com.tencent.mm.kernel.g.aAi();
            com.tencent.mm.kernel.g.aAg().hqi.a(291, faF2);
            if (aj.isInValid()) {
                this.EoO = false;
            } else if (this.EoO) {
                this.EoO = aj.faY().fgK();
            }
            com.tencent.mm.plugin.sns.m.a aVar4 = this.EKR;
            aVar4.ESq = this.EKT.ESq;
            aVar4.QYN.keep(aVar4.ESq);
            if (!this.EoO || this.EMi != 0) {
                this.mUIAction.list.setAdapter((ListAdapter) this.EKT);
                ZR(0);
                this.EKT.vC();
            } else {
                this.EKY = false;
                int i4 = aj.faY().position;
                this.EKT.ESq.aRl(aj.faY().sNG);
                this.EKT.ESq.aRi(aj.faY().EvF);
                this.EKT.ESq.vD(true);
                this.EKT.ESq.aRm(aj.faY().EvI);
                this.EKT.ESq.aRj(aj.faY().EvG);
                this.EKT.ESq.aRk(aj.faY().EvH);
                this.mUIAction.vz(aj.faY().EvK);
                this.EKT.vC();
                if (i4 >= this.EKT.getCount()) {
                    i4 = this.EKT.getCount() - 1;
                    Log.e("MicroMsg.SnsTimeLineUI", "error position %s", Integer.valueOf(this.EKT.getCount()));
                }
                this.mUIAction.list.setAdapter((ListAdapter) this.EKT);
                Log.d("MicroMsg.SnsTimeLineUI", "resume position %s", Integer.valueOf(aj.faY().EvJ));
                this.mUIAction.list.setSelectionFromTop(i4, aj.faY().EvJ);
                ZR(4);
            }
            fiY();
            int count = this.EKT.getCount();
            int firstVisiblePosition = this.mUIAction.list.getFirstVisiblePosition();
            if (firstVisiblePosition < count) {
                this.ELf = r.v(this.EKT.Zv(firstVisiblePosition));
            }
            com.tencent.mm.kernel.g.aAi();
            this.ELd = ((Integer) com.tencent.mm.kernel.g.aAh().azQ().get(327776, (Object) 0)).intValue();
            this.EKZ.EoQ = new bs(this, this.EKT.ESp, this.EKZ.DQt);
            this.EKZ.EoS = new com.tencent.mm.plugin.sns.h.b(this, this.EKT.ESp.DQs, this.EKZ.DQt);
            this.EKZ.EoR = new b(this, this.EKT.ESp.DQs, this.EKZ.DQt, this.EKZ.EoS);
            this.EKZ.EoR.DzW = this.EBv;
            this.EKZ.EoT = new ap(this, this.EKT.ESp.DQs, this.EKZ.DQt);
            this.EKZ.EoU = new bu(this, this.EKT.ESp.DQs, this.EKZ.DQt);
            if (this.ELi != null) {
                this.ELi.a(this.EKZ.EoS);
            }
            if (count > 0) {
                SnsInfo Zv = this.EKT.Zv(0);
                if (!(this.EKZ.EoF == null || this.EKZ.EoF.DMa == null)) {
                    this.EKZ.EoF.DMa.DSD = Zv.field_snsId;
                }
                com.tencent.mm.plugin.sns.k.e eVar = com.tencent.mm.plugin.sns.k.e.DUQ;
                if (eVar.hmp != 0) {
                    if (eVar.DUR.isEmpty()) {
                        eVar.gmR.setLong(2, Util.nowSecond());
                        eVar.DUS.clear();
                    }
                    Log.i("MicroMsg.SnsReportHelper", "enterTimeLine exposureFeedSize %d", Integer.valueOf(eVar.DUR.size()));
                }
            }
            com.tencent.mm.plugin.report.service.h.INSTANCE.kvStat(13312, "1," + Util.nowMilliSecond());
            EventCenter.instance.addListener(this.ELD);
            if (getIntent().getBooleanExtra("is_need_resend_sns", false)) {
                MMHandlerThread.postToMainThreadDelayed(new Runnable() {
                    /* class com.tencent.mm.plugin.sns.ui.SnsTimeLineUI.AnonymousClass33 */

                    {
                        AppMethodBeat.i(176326);
                        AppMethodBeat.o(176326);
                    }

                    public final void run() {
                        AppMethodBeat.i(99317);
                        com.tencent.mm.ui.base.h.c(SnsTimeLineUI.this, SnsTimeLineUI.this.getString(R.string.ffz), "", SnsTimeLineUI.this.getString(R.string.fg0), SnsTimeLineUI.this.getString(R.string.sz), new DialogInterface.OnClickListener() {
                            /* class com.tencent.mm.plugin.sns.ui.SnsTimeLineUI.AnonymousClass33.AnonymousClass1 */

                            public final void onClick(DialogInterface dialogInterface, int i2) {
                                AppMethodBeat.i(99307);
                                EventCenter.instance.publish(new sk());
                                AppMethodBeat.o(99307);
                            }
                        }, new DialogInterface.OnClickListener() {
                            /* class com.tencent.mm.plugin.sns.ui.SnsTimeLineUI.AnonymousClass33.AnonymousClass2 */

                            public final void onClick(DialogInterface dialogInterface, int i2) {
                                AppMethodBeat.i(99308);
                                EventCenter.instance.publish(new oi());
                                AppMethodBeat.o(99308);
                            }
                        });
                        AppMethodBeat.o(99317);
                    }
                }, 500);
                getIntent().putExtra("is_need_resend_sns", false);
            }
            com.tencent.mm.kernel.g.aAi();
            if (com.tencent.mm.kernel.g.aAf().azp()) {
                com.tencent.mm.kernel.g.aAi();
                com.tencent.mm.kernel.g.aAh().azQ().set(589825, Boolean.FALSE);
            }
            this.EKZ.b(this.EBv);
            this.EBv.a(this.mUIAction.DuA, this.mActionBar.getCustomView(), this);
            EventCenter.instance.addListener(this.ELJ);
            EventCenter.instance.addListener(this.ELK);
            EventCenter.instance.addListener(this.ELL);
            EventCenter.instance.addListener(this.ELM);
            EventCenter.instance.addListener(this.ELN);
            EventCenter.instance.addListener(this.ELP);
            EventCenter.instance.addListener(this.ELO);
            EventCenter.instance.addListener(this.DMM);
            EventCenter.instance.addListener(this.ELQ);
            EventCenter.instance.addListener(this.ELR);
            EventCenter.instance.addListener(this.ELT);
            EventCenter.instance.addListener(this.ELS);
            EventCenter.instance.addListener(this.ELU);
            EventCenter.instance.addListener(this.ELW);
            com.tencent.mm.plugin.sns.abtest.c.eWz();
            com.tencent.mm.plugin.sns.abtest.a.d(this, this.EKZ.DQt);
            if (this.ELg != null) {
                com.tencent.mm.plugin.sns.k.a aVar5 = this.ELg;
                ListView listView2 = this.mUIAction.list;
                SnsHeader snsHeader = this.mUIAction.DSh;
                aVar5.hUI = listView2;
                aVar5.DSh = snsHeader;
            }
            if (!(this.EKZ == null || this.EKZ.EoF == null)) {
                com.tencent.mm.plugin.sns.k.b bVar3 = this.EKZ.EoF.DMa;
                Log.i("MicroMsg.SnsBrowseInfoHelper", "onTimelineCreate");
                bVar3.DSC = true;
                bVar3.DUA = System.currentTimeMillis();
            }
            boolean booleanExtra = getIntent().getBooleanExtra("enter_by_red", false);
            if (!(this.EKZ == null || this.EKZ.EoF == null)) {
                com.tencent.mm.plugin.sns.k.b bVar4 = this.EKZ.EoF.DMa;
                if (booleanExtra) {
                    i2 = 1;
                } else {
                    i2 = 0;
                }
                bVar4.DSP = i2;
            }
            aj.faL().DHe.clear();
            if (!(this.mUIAction == null || this.mUIAction.DSh == null)) {
                this.mUIAction.DSh.setStoryAction(new SnsStoryHeaderView.a() {
                    /* class com.tencent.mm.plugin.sns.ui.SnsTimeLineUI.AnonymousClass35 */

                    @Override // com.tencent.mm.plugin.sns.ui.view.SnsStoryHeaderView.a
                    public final void fjo() {
                        AppMethodBeat.i(203695);
                        a aVar = SnsTimeLineUI.this.ELb;
                        if (SnsTimeLineUI.this.EKW.getVisibility() == 0) {
                            aVar.init();
                            SnsTimeLineUI.this.EKW.clearAnimation();
                            SnsTimeLineUI.this.EKW.startAnimation(aVar);
                            aVar.JT((long) (aVar.AGw + 100));
                            aVar.EMT = false;
                        }
                        AppMethodBeat.o(203695);
                    }
                });
            }
            ((com.tencent.mm.plugin.i.a.ao) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.i.a.ao.class)).awT(3);
            if (Util.isNullOrNil(z.aUg())) {
                this.ELx = 0;
            } else if (!((com.tencent.mm.plugin.i.a.aj) com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.i.a.aj.class)).hasFinderPosted()) {
                this.ELx = 1;
            } else {
                this.ELx = 2;
            }
            if (BuildInfo.DEBUG || BuildInfo.IS_FLAVOR_PURPLE || BuildInfo.IS_FLAVOR_RED) {
                str = ((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_clip_page_finder_promotion_entrance, "{\"enable\":2,\"max_count_no_user\":0,\"max_count_no_feed\":0,\"max_count_normal\":0}");
            } else {
                str = ((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_clip_page_finder_promotion_entrance, "");
            }
            if (!Util.isNullOrNil(str)) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    this.ELt = jSONObject.getInt("enable");
                    this.ELu = jSONObject.getInt("max_count_no_user");
                    this.ELv = jSONObject.getInt("max_count_no_feed");
                    this.ELw = jSONObject.getInt("max_count_normal");
                } catch (Exception e3) {
                    Log.w("MicroMsg.SnsTimeLineUI", "parse SnsFinderEntranceConfig fail. %s", e3.getMessage());
                }
            }
            if (ac.jPK > 0) {
                this.ELt = ac.jPK;
                if (ac.jPK == 1) {
                    this.ELu = -1;
                    this.ELv = -1;
                    this.ELw = -1;
                }
            }
            Log.i("MicroMsg.SnsTimeLineUI", "curFinderStatus:%s, finderEntranceEnable:%s, finderEntranceMaxCountNoUser:%s, finderEntranceMaxCountNoFeed:%s, finderEntranceMaxCountNormal:%s", Integer.valueOf(this.ELx), Integer.valueOf(this.ELt), Integer.valueOf(this.ELu), Integer.valueOf(this.ELv), Integer.valueOf(this.ELw));
            ah.fas();
            EventCenter.instance.addListener(this.ELE);
            a.C1715a aVar6 = com.tencent.mm.plugin.sns.i.a.DRI;
            a.C1715a.gZ(this);
            AppMethodBeat.o(99379);
        }

        private void fiZ() {
            AppMethodBeat.i(99380);
            this.autoPlay = ((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_sns_video_autoplay, 0) == 1;
            String lowerCase = Build.MODEL.toLowerCase();
            String a2 = ((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_sns_video_autoplay_disable_device, "");
            if (!Util.isNullOrNil(a2) && a2.contains(lowerCase)) {
                Log.i("MicroMsg.SnsTimeLineUI", "model %s is hit, expt:%s", lowerCase, a2);
                this.autoPlay = false;
            }
            if (!this.autoPlay) {
                Log.i("MicroMsg.SnsTimeLineUI", "autoPlay DynamicConfig false");
            } else if (this.ELq.emf()) {
                this.autoPlay = false;
                Log.i("MicroMsg.SnsTimeLineUI", "2G/3G autoplay false");
            } else if (this.ELq.cGF()) {
                Log.i("MicroMsg.SnsTimeLineUI", "wifi autoplay true");
                this.autoPlay = true;
            } else {
                this.autoPlay = ((Boolean) com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.USERINFO_WEIXIN_SNSAUTOPLAY_AUTOSYNC_BOOLEAN, Boolean.TRUE)).booleanValue();
            }
            Log.i("MicroMsg.SnsTimeLineUI", "autoPlay:%s", Boolean.valueOf(this.autoPlay));
            AppMethodBeat.o(99380);
        }

        private void fja() {
            AppMethodBeat.i(99381);
            if (this.EMi != 1) {
                addIconOptionMenu(0, R.string.h2y, R.raw.icons_filled_camera, new MenuItem.OnMenuItemClickListener() {
                    /* class com.tencent.mm.plugin.sns.ui.SnsTimeLineUI.AnonymousClass37 */

                    public final boolean onMenuItemClick(MenuItem menuItem) {
                        AppMethodBeat.i(203696);
                        SnsTimeLineUI.L(SnsTimeLineUI.this);
                        AppMethodBeat.o(203696);
                        return true;
                    }
                }, new View.OnLongClickListener() {
                    /* class com.tencent.mm.plugin.sns.ui.SnsTimeLineUI.AnonymousClass38 */

                    {
                        AppMethodBeat.i(179254);
                        AppMethodBeat.o(179254);
                    }

                    public final boolean onLongClick(View view) {
                        AppMethodBeat.i(203697);
                        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                        bVar.bm(view);
                        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsTimeLineUI$43", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, bVar.axR());
                        if (!(SnsTimeLineUI.this.EKZ == null || SnsTimeLineUI.this.EKZ.EoF == null)) {
                            SnsTimeLineUI.this.EKZ.EoF.DMa.uT(true);
                        }
                        com.tencent.mm.kernel.g.aAi();
                        boolean booleanValue = ((Boolean) com.tencent.mm.kernel.g.aAh().azQ().get(7490, Boolean.TRUE)).booleanValue();
                        aj.faV().vk(true);
                        j aQn = aj.faV().aQn("draft_text");
                        if (aQn != null) {
                            byte[] bArr = aQn.field_draft;
                            if (!Util.isNullOrNil(bArr)) {
                                com.tencent.mm.kernel.g.aAi();
                                new im().ahi().wj((String) com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.USERINFO_SNS_OPEN_UPLOAD_DRAFT_NEWTEXT_LAST_SESSIONID_STRING, "")).bfK();
                                Parcel obtain = Parcel.obtain();
                                obtain.unmarshall(bArr, 0, bArr.length);
                                obtain.setDataPosition(0);
                                try {
                                    Intent intent = (Intent) Intent.CREATOR.createFromParcel(obtain);
                                    if (SnsTimeLineUI.aZ(intent)) {
                                        SnsTimeLineUI.this.startActivityForResult(intent, 9);
                                        com.tencent.mm.hellhoundlib.a.a.a(true, (Object) this, "com/tencent/mm/plugin/sns/ui/SnsTimeLineUI$43", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
                                        AppMethodBeat.o(203697);
                                        return true;
                                    }
                                    aj.faV().b("draft_text", null, 0);
                                } catch (Exception e2) {
                                    aj.faV().b("draft_text", null, 0);
                                }
                            }
                        }
                        if (!booleanValue) {
                            Intent intent2 = new Intent();
                            intent2.setClass(SnsTimeLineUI.this, SnsUploadUI.class);
                            intent2.putExtra("KSnsPostManu", true);
                            intent2.putExtra("KTouchCameraTime", Util.nowSecond());
                            intent2.putExtra("sns_comment_type", 1);
                            intent2.putExtra("Ksnsupload_type", 9);
                            com.tencent.mm.modelsns.k tO = com.tencent.mm.modelsns.k.tO(705);
                            tO.tS(tO.jll).PI(new StringBuilder().append(System.currentTimeMillis()).toString()).tS(tO.jlm).tS(1);
                            com.tencent.mm.modelsns.k b2 = com.tencent.mm.plugin.sns.k.g.DVR.b(tO);
                            b2.bfK();
                            b2.b(intent2, "intent_key_StatisticsOplog");
                            SnsTimeLineUI.this.startActivityForResult(intent2, 9);
                        } else {
                            SnsTimeLineUI snsTimeLineUI = SnsTimeLineUI.this;
                            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(new Intent().setClass(SnsTimeLineUI.this, SnsLongMsgUI.class));
                            com.tencent.mm.hellhoundlib.a.a.a(snsTimeLineUI, bl.axQ(), "com/tencent/mm/plugin/sns/ui/SnsTimeLineUI$43", "onLongClick", "(Landroid/view/View;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                            snsTimeLineUI.startActivity((Intent) bl.pG(0));
                            com.tencent.mm.hellhoundlib.a.a.a(snsTimeLineUI, "com/tencent/mm/plugin/sns/ui/SnsTimeLineUI$43", "onLongClick", "(Landroid/view/View;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                            com.tencent.mm.kernel.g.aAi();
                            com.tencent.mm.kernel.g.aAh().azQ().set(7490, Boolean.FALSE);
                        }
                        com.tencent.mm.hellhoundlib.a.a.a(true, (Object) this, "com/tencent/mm/plugin/sns/ui/SnsTimeLineUI$43", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
                        AppMethodBeat.o(203697);
                        return true;
                    }
                });
                AppMethodBeat.o(99381);
            } else if (!this.EqY) {
                enableOptionMenu(false);
                AppMethodBeat.o(99381);
            } else {
                addIconOptionMenu(0, getString(R.string.h8q), R.raw.actionbar_list_icon, new MenuItem.OnMenuItemClickListener() {
                    /* class com.tencent.mm.plugin.sns.ui.SnsTimeLineUI.AnonymousClass36 */

                    public final boolean onMenuItemClick(MenuItem menuItem) {
                        AppMethodBeat.i(179251);
                        Intent intent = new Intent();
                        intent.setClass(SnsTimeLineUI.this, SnsMsgUI.class);
                        intent.putExtra("sns_msg_force_show_all", true);
                        intent.putExtra("sns_msg_comment_list_scene", 1);
                        SnsTimeLineUI.this.startActivityForResult(intent, 8);
                        AppMethodBeat.o(179251);
                        return true;
                    }
                });
                AppMethodBeat.o(99381);
            }
        }

        @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
        public void onConfigurationChanged(Configuration configuration) {
            AppMethodBeat.i(99382);
            super.onConfigurationChanged(configuration);
            Log.i("MicroMsg.SnsTimeLineUI", "onConfigurationChanged");
            EventCenter.instance.publish(new com.tencent.mm.g.a.cl());
            DisplayMetrics displayMetrics = new DisplayMetrics();
            getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
            Point point = new Point();
            point.x = displayMetrics.widthPixels;
            point.y = displayMetrics.heightPixels;
            aj.k(point);
            f.fll().Fff = 0;
            com.tencent.mm.plugin.sns.ui.widget.d.fli().Fff = 0;
            com.tencent.mm.kiss.widget.textview.c.hue.aBj();
            this.EKT.ESp.fiM();
            this.EKT.ESq.resolvedClear();
            AppMethodBeat.o(99382);
        }

        @Override // com.tencent.mm.kiss.WxPresenterActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
        public void onDestroy() {
            int positionForView;
            int i2;
            AppMethodBeat.i(99383);
            this.ELe = true;
            bf bfVar = this.ELq;
            bfVar.dMu();
            bfVar.EGI = null;
            bfVar.CTg = bf.a.EGK;
            com.tencent.mm.plugin.sns.ui.video.d.fkS().aN(this);
            com.tencent.mm.plugin.sns.ui.video.b fkM = com.tencent.mm.plugin.sns.ui.video.b.fkM();
            Log.i("MicroMsg.SightPlayViewManager", "onUIDestroy");
            for (com.tencent.mm.plugin.sns.ui.video.a aVar : fkM.FcW) {
                aVar.stop();
            }
            fkM.FcW.clear();
            Log.i("MicroMsg.SnsTimeLineUI", "timeline on destroy");
            EventCenter.instance.removeListener(this.ELJ);
            EventCenter.instance.removeListener(this.ELK);
            EventCenter.instance.removeListener(this.ELL);
            EventCenter.instance.removeListener(this.ELM);
            EventCenter.instance.removeListener(this.ELN);
            EventCenter.instance.removeListener(this.ELP);
            EventCenter.instance.removeListener(this.ELO);
            EventCenter.instance.removeListener(this.DMM);
            EventCenter.instance.removeListener(this.ELQ);
            EventCenter.instance.removeListener(this.ELR);
            EventCenter.instance.removeListener(this.ELS);
            EventCenter.instance.removeListener(this.ELT);
            EventCenter.instance.removeListener(this.ELU);
            EventCenter.instance.removeListener(this.ELE);
            EventCenter.instance.removeListener(this.ELW);
            com.tencent.mm.plugin.sns.ui.e.a.fkK();
            if (!(this.EKZ == null || this.EKZ.EoF == null)) {
                com.tencent.mm.plugin.sns.k.b bVar = this.EKZ.EoF.DMa;
                if (this.ELG) {
                    i2 = 1;
                } else {
                    i2 = 0;
                }
                bVar.DSQ = i2;
            }
            com.tencent.mm.plugin.sns.k.e eVar = com.tencent.mm.plugin.sns.k.e.DUQ;
            if (eVar.hmp != 0) {
                Log.i("MicroMsg.SnsReportHelper", "exitTimeline exposureFeedSize %d, exposureAppIdSize %d", Integer.valueOf(eVar.DUR.size()), Integer.valueOf(eVar.DUS.size()));
                long j2 = eVar.gmR.getLong(2, 0);
                if (eVar.DUR.isEmpty() || (eVar.DUR.size() <= eVar.DUY && Util.secondsToNow(j2) <= ((long) eVar.DUZ))) {
                    eVar.gmR.set(3, eVar.DUR);
                    eVar.gmR.set(4, eVar.DUS);
                    eVar.gmR.set(5, eVar.DUT);
                } else {
                    StringBuffer stringBuffer = new StringBuffer();
                    int i3 = 0;
                    int i4 = 0;
                    for (String str : eVar.DUR.keySet()) {
                        String str2 = eVar.DUS.get(str);
                        if (!Util.isNullOrNil(str2)) {
                            i4 = 1;
                        } else {
                            str2 = "";
                        }
                        stringBuffer.append(str + "#" + eVar.DUR.get(str) + "#" + str2 + "#" + (eVar.DUT.contains(str) ? 1 : 0) + "|");
                        i3++;
                    }
                    stringBuffer.append("," + j2 + "," + Util.nowSecond() + ",1," + i4 + "," + i3 + ",1");
                    Log.v("MicroMsg.SnsReportHelper", "report(13226) %d: %s", 13226, stringBuffer);
                    com.tencent.mm.plugin.report.service.h.INSTANCE.kvStat(13226, stringBuffer.toString());
                    eVar.gmR.set(3, null);
                    eVar.gmR.set(4, null);
                    eVar.gmR.set(5, null);
                    eVar.DUR.clear();
                    eVar.DUS.clear();
                    eVar.DUT.clear();
                    eVar.gmR.setLong(2, Util.nowSecond());
                }
                eVar.fcu();
            }
            com.tencent.mm.kernel.g.aAi();
            String str3 = (String) com.tencent.mm.kernel.g.aAh().azQ().get(68377, (Object) null);
            if (!(this.EKZ == null || this.EKZ.EoF == null)) {
                com.tencent.mm.plugin.sns.k.b bVar2 = this.EKZ.EoF.DMa;
                int i5 = com.tencent.mm.plugin.sns.k.e.DUQ.DUX;
                Log.i("MicroMsg.SnsBrowseInfoHelper", "onTimelineDestroy");
                long currentTimeMillis = System.currentTimeMillis() - bVar2.DUA;
                bVar2.DSE += currentTimeMillis;
                Log.i("MicroMsg.SnsBrowseInfoHelper", "onTimelineEns passedtime: " + currentTimeMillis + " BrowseTime: " + bVar2.DSE + "BackgroundTime: " + bVar2.DTn);
                ExecutorService faB = aj.faB();
                if (faB != null) {
                    faB.execute(
                    /*  JADX ERROR: Method code generation error
                        jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x02e2: INVOKE  
                          (r5v25 'faB' java.util.concurrent.ExecutorService)
                          (wrap: com.tencent.mm.plugin.sns.k.b$2 : 0x02df: CONSTRUCTOR  (r6v26 com.tencent.mm.plugin.sns.k.b$2) = (r3v80 'bVar2' com.tencent.mm.plugin.sns.k.b), (r4v36 'i5' int) call: com.tencent.mm.plugin.sns.k.b.2.<init>(com.tencent.mm.plugin.sns.k.b, int):void type: CONSTRUCTOR)
                         type: INTERFACE call: java.util.concurrent.ExecutorService.execute(java.lang.Runnable):void in method: com.tencent.mm.plugin.sns.ui.SnsTimeLineUI.onDestroy():void, file: classes3.dex
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:217)
                        	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:110)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:56)
                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                        	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:143)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                        	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:143)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                        	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:244)
                        	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:237)
                        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:342)
                        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:295)
                        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:264)
                        	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                        	at java.util.ArrayList.forEach(ArrayList.java:1259)
                        	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                        	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                        Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x02df: CONSTRUCTOR  (r6v26 com.tencent.mm.plugin.sns.k.b$2) = (r3v80 'bVar2' com.tencent.mm.plugin.sns.k.b), (r4v36 'i5' int) call: com.tencent.mm.plugin.sns.k.b.2.<init>(com.tencent.mm.plugin.sns.k.b, int):void type: CONSTRUCTOR in method: com.tencent.mm.plugin.sns.ui.SnsTimeLineUI.onDestroy():void, file: classes3.dex
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                        	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
                        	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
                        	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:806)
                        	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:746)
                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                        	... 24 more
                        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.tencent.mm.plugin.sns.k.b, state: GENERATED_AND_UNLOADED
                        	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
                        	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                        	... 30 more
                        */
                    /*
                    // Method dump skipped, instructions count: 1951
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.sns.ui.SnsTimeLineUI.onDestroy():void");
                }

                private boolean fA(View view) {
                    AppMethodBeat.i(203730);
                    try {
                        if (getContext() == null || getContext().isFinishing()) {
                            AppMethodBeat.o(203730);
                            return false;
                        }
                        Rect rect = new Rect();
                        view.getGlobalVisibleRect(rect);
                        DisplayMetrics displayMetrics = new DisplayMetrics();
                        getContext().getWindowManager().getDefaultDisplay().getRealMetrics(displayMetrics);
                        int i2 = displayMetrics.heightPixels;
                        int height = this.mActionBar.getHeight() + ao.jJ(this);
                        Log.i("MicroMsg.SnsTimeLineUI.ScreenShot", "lxl checkItemVisible actionbar height:%s, total height:%s, screenHeight:%s, top:%s, bottom:%s", Integer.valueOf(this.mActionBar.getHeight()), Integer.valueOf(height), Integer.valueOf(i2), Integer.valueOf(rect.top), Integer.valueOf(rect.bottom));
                        if (rect.bottom <= height || i2 <= rect.top) {
                            AppMethodBeat.o(203730);
                            return false;
                        }
                        AppMethodBeat.o(203730);
                        return true;
                    } catch (Throwable th) {
                        Log.e("MicroMsg.SnsTimeLineUI.ScreenShot", th.toString());
                        AppMethodBeat.o(203730);
                        return false;
                    }
                }

                @Override // com.tencent.mm.kiss.WxPresenterActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.plugin.secdata.ui.WxPresenterSecDataActivity, com.tencent.mm.ui.MMFragmentActivity
                public void onWindowFocusChanged(boolean z) {
                    AppMethodBeat.i(203731);
                    AppMethodBeat.at(this, z);
                    super.onWindowFocusChanged(z);
                    Log.i("MicroMsg.SnsTimeLineUI.ScreenShot", "hasFocus = ".concat(String.valueOf(z)));
                    if (!z) {
                        try {
                            ScreenShotUtil.setScreenShotCallback(this, null);
                            this.ExJ = false;
                            AppMethodBeat.o(203731);
                        } catch (Throwable th) {
                            Log.i("MicroMsg.SnsTimeLineUI.ScreenShot", "hasFocus = ".concat(String.valueOf(z)));
                            Log.e("MicroMsg.SnsTimeLineUI.ScreenShot", th.toString());
                            AppMethodBeat.o(203731);
                        }
                    } else {
                        if (!this.ExJ) {
                            Log.i("MicroMsg.SnsTimeLineUI.ScreenShot", "onWindowFocusChanged callback");
                            ScreenShotUtil.setScreenShotCallback(this, this.EyL);
                            this.ExJ = true;
                        }
                        AppMethodBeat.o(203731);
                    }
                }

                @Override // com.tencent.mm.kiss.WxPresenterActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
                public void onResume() {
                    com.tencent.mm.modelsns.k c2;
                    com.tencent.matrix.trace.f.c cVar;
                    AppMethodBeat.i(99384);
                    aj.faZ().DNF = ax.DOf;
                    this.ELq.CTg = bf.fiw();
                    this.iTC = Util.nowSecond();
                    if (!(!com.tencent.matrix.b.isInstalled() || com.tencent.matrix.b.RG().Y(com.tencent.matrix.trace.a.class) == null || (cVar = ((com.tencent.matrix.trace.a) com.tencent.matrix.b.RG().Y(com.tencent.matrix.trace.a.class)).daF) == null)) {
                        this.hlB = (long) cVar.dcx;
                    }
                    try {
                        if (!this.ExJ) {
                            Log.i("MicroMsg.SnsTimeLineUI.ScreenShot", "onResume callback");
                            ScreenShotUtil.setScreenShotCallback(this, this.EyL);
                            this.ExJ = true;
                        }
                    } catch (Throwable th) {
                        Log.e("MicroMsg.SnsTimeLineUI.ScreenShot", th.toString());
                    }
                    if (CrashReportFactory.hasDebuger() && CrashReportFactory.isMonkeyEnv()) {
                        sUILeaksRoutineEnsuranceRef.add(this);
                    }
                    this.mUIAction.onResume();
                    super.onResume();
                    fiZ();
                    if (this.autoPlay) {
                        fiY();
                    }
                    this.zdW = Util.nowSecond();
                    if (this.EMh) {
                        this.EMh = false;
                        int count = this.EKT.getCount();
                        if (getIntent().getBooleanExtra("is_from_find_more", false) && (c2 = com.tencent.mm.modelsns.k.c(getIntent(), "enter_log")) != null) {
                            if (count > 0) {
                                SnsInfo Zv = this.EKT.Zv(0);
                                c2.PH(Zv == null ? AppEventsConstants.EVENT_PARAM_VALUE_NO : r.Jb(Zv.field_snsId));
                                c2.PH(Zv == null ? AppEventsConstants.EVENT_PARAM_VALUE_NO : new StringBuilder().append(Zv.field_createTime).toString());
                                c2.PH(String.valueOf(count));
                            } else {
                                c2.PH("");
                                c2.PH("");
                                c2.PH(AppEventsConstants.EVENT_PARAM_VALUE_NO);
                            }
                            c2.bfK();
                        }
                    }
                    if (this.mScreenWidth == 0) {
                        DisplayMetrics displayMetrics = new DisplayMetrics();
                        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
                        this.mScreenWidth = displayMetrics.widthPixels;
                        this.mScreenHeight = displayMetrics.heightPixels;
                        com.tencent.mm.plugin.sns.k.a aVar = this.ELg;
                        int i2 = this.mScreenWidth;
                        int i3 = this.mScreenHeight;
                        aVar.mScreenWidth = i2;
                        aVar.mScreenHeight = i3;
                    }
                    if (aj.isInValid()) {
                        finish();
                    }
                    aj.faL().DHg = this.EKT.ESp;
                    aBf().bk(c.b.class);
                    v.a(this);
                    if (this.EKY) {
                        this.EKW.post(new Runnable() {
                            /* class com.tencent.mm.plugin.sns.ui.SnsTimeLineUI.AnonymousClass40 */

                            public final void run() {
                                AppMethodBeat.i(99328);
                                Log.i("MicroMsg.SnsTimeLineUI", "onResume go to playAnim " + SnsTimeLineUI.this.EKY);
                                if (SnsTimeLineUI.this.EKY) {
                                    SnsTimeLineUI.this.EKY = false;
                                    SnsTimeLineUI.this.ELb.fjs();
                                }
                                AppMethodBeat.o(99328);
                            }
                        });
                    } else {
                        a aVar2 = this.ELb;
                        if (SnsTimeLineUI.this.EKW.getVisibility() == 0) {
                            aVar2.init();
                            AbsoluteLayout.LayoutParams layoutParams = (AbsoluteLayout.LayoutParams) SnsTimeLineUI.this.EKW.getLayoutParams();
                            layoutParams.y = (int) aVar2.EMM;
                            SnsTimeLineUI.this.EKW.setLayoutParams(layoutParams);
                            SnsTimeLineUI.this.EKW.invalidate();
                        }
                    }
                    if (!(this.EKZ == null || this.EKZ.EoE == null)) {
                        this.EKZ.EoE.onResume();
                    }
                    if (this.EKT != null) {
                        this.EKT.ESp.onResume();
                    }
                    if (!(this.EKZ == null || this.EKZ.EoF == null)) {
                        this.EKZ.EoF.DMa.uP(true);
                        this.EKZ.EoF.DMa.uQ(false);
                        this.EKZ.EoF.DMa.uR(false);
                        this.EKZ.EoF.DMa.uS(false);
                        this.EKZ.EoF.DMa.vc(false);
                        com.tencent.mm.plugin.sns.k.b bVar = this.EKZ.EoF.DMa;
                        bVar.va(false);
                        bVar.vb(false);
                        bVar.uU(false);
                        bVar.uZ(false);
                        bVar.uX(false);
                        bVar.uZ(false);
                        bVar.vd(false);
                        bVar.uY(false);
                        bVar.uZ(false);
                        bVar.uV(false);
                        bVar.uW(false);
                    }
                    com.tencent.mm.plugin.sns.model.g faL = aj.faL();
                    faL.DHh = 0;
                    faL.DHi = 0;
                    EventCenter.instance.addListener(this.ELI);
                    EventCenter.instance.addListener(this.ELH);
                    EventCenter.instance.addListener(this.ELV);
                    AppMethodBeat.o(99384);
                }

                @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
                public void onStart() {
                    AppMethodBeat.i(99385);
                    super.onStart();
                    AppMethodBeat.o(99385);
                }

                @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
                public void onStop() {
                    AppMethodBeat.i(99386);
                    super.onStop();
                    AppMethodBeat.o(99386);
                }

                @Override // com.tencent.mm.kiss.WxPresenterActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
                public void onPause() {
                    com.tencent.matrix.trace.f.c cVar;
                    AppMethodBeat.i(99387);
                    try {
                        ScreenShotUtil.setScreenShotCallback(this, null);
                        this.ExJ = false;
                    } catch (Throwable th) {
                        Log.e("MicroMsg.SnsTimeLineUI.ScreenShot", th.toString());
                    }
                    this.EKW.clearAnimation();
                    WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcSNSScrollEnable, this.gsi);
                    this.gsi = 0;
                    v.b(this);
                    aj.faL().DHg = null;
                    if (this.EKT != null) {
                        this.EKT.ESp.onPause();
                    }
                    if (!(this.EKZ == null || this.EKZ.EoE == null)) {
                        this.EKZ.EoE.onPause();
                    }
                    if (!(this.EKZ == null || this.EKZ.EoF == null)) {
                        this.EKZ.EoF.DMa.uP(false);
                    }
                    com.tencent.mm.modelstat.d.m("SnsTimeLineUI", this.zdW, Util.nowSecond());
                    this.mUIAction.onPause();
                    super.onPause();
                    com.tencent.mm.plugin.sns.ui.video.d.fkS().onUIPause();
                    com.tencent.mm.plugin.sns.ui.video.b fkM = com.tencent.mm.plugin.sns.ui.video.b.fkM();
                    Log.i("MicroMsg.SightPlayViewManager", "onUIPause");
                    for (com.tencent.mm.plugin.sns.ui.video.a aVar : fkM.FcW) {
                        aVar.onUIPause();
                    }
                    EventCenter.instance.removeListener(this.ELI);
                    EventCenter.instance.removeListener(this.ELH);
                    EventCenter.instance.removeListener(this.ELV);
                    if (!(!com.tencent.matrix.b.isInstalled() || com.tencent.matrix.b.RG().Y(com.tencent.matrix.trace.a.class) == null || (cVar = ((com.tencent.matrix.trace.a) com.tencent.matrix.b.RG().Y(com.tencent.matrix.trace.a.class)).daF) == null)) {
                        this.hlB = Math.max(0L, ((long) cVar.dcx) - this.hlB);
                    }
                    this.iTC = Util.nowSecond() > this.iTC ? Util.nowSecond() - this.iTC : 1;
                    WXHardCoderJNI.reportFPS(701, WXHardCoderJNI.hcSNSScrollAction, 1, this.hlB, this.iTC);
                    this.hlB = 0;
                    this.iTC = 0;
                    if (com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.ball.c.a.class) != null) {
                        ((com.tencent.mm.plugin.ball.c.a) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.ball.c.a.class)).d(101, false, false);
                    }
                    AppMethodBeat.o(99387);
                }

                @Override // com.tencent.mm.ui.MMActivity
                public int getLayoutId() {
                    return R.layout.bxx;
                }

                @Override // com.tencent.mm.ui.MMActivity
                public void initView() {
                    String str;
                    boolean z;
                    boolean z2;
                    boolean z3 = false;
                    AppMethodBeat.i(99388);
                    this.mUIAction.DSh.setDrawingCacheEnabled(false);
                    this.EKZ.DQt = (FrameLayout) findViewById(R.id.in6);
                    int i2 = aj.faY().position;
                    AdListView adListView = (AdListView) this.mUIAction.getSnsListView();
                    adListView.Enb = this.EBv;
                    adListView.setTimelineStat(this.ELh);
                    adListView.setTimelineEvent(this.ELi);
                    this.ELi.a(aj.faF());
                    Log.i("MicroMsg.SnsTimeLineUI", "oncreate firstPosition %d isToResume: " + this.EoO, Integer.valueOf(i2));
                    this.EKW = (QFadeImageView) findViewById(R.id.i01);
                    this.EKW.setImageResource(R.raw.friendactivity_refresh);
                    this.ELb = new a(this.mUIAction.getSnsListView());
                    this.ELb.setInterpolator(new LinearInterpolator());
                    this.ELb.setAnimationListener(new Animation.AnimationListener() {
                        /* class com.tencent.mm.plugin.sns.ui.SnsTimeLineUI.AnonymousClass41 */

                        public final void onAnimationStart(Animation animation) {
                            AppMethodBeat.i(203699);
                            Log.i("MicroMsg.SnsTimeLineUI", "refreshAnim start");
                            AppMethodBeat.o(203699);
                        }

                        public final void onAnimationRepeat(Animation animation) {
                            AppMethodBeat.i(203700);
                            Log.i("MicroMsg.SnsTimeLineUI", "refreshAnim repeat");
                            AppMethodBeat.o(203700);
                        }

                        public final void onAnimationEnd(Animation animation) {
                            AppMethodBeat.i(203701);
                            Log.i("MicroMsg.SnsTimeLineUI", "refreshAnim end");
                            AppMethodBeat.o(203701);
                        }
                    });
                    com.tencent.mm.plugin.sns.ui.a.b.d dVar = null;
                    if (this.EMi == 1) {
                        this.EKY = true;
                        dVar = new com.tencent.mm.plugin.sns.ui.a.b.d(this.mRa, this.EqY);
                    }
                    this.EKT = new com.tencent.mm.plugin.sns.ui.a.c(this, this.mUIAction.getSnsListView(), this.EKZ.EoV, this.EKZ, this.ELj, dVar, this.ELF);
                    this.EKZ.EoV.Fbe = new bk.b() {
                        /* class com.tencent.mm.plugin.sns.ui.SnsTimeLineUI.AnonymousClass42 */

                        @Override // com.tencent.mm.plugin.sns.ui.bk.b
                        public final boolean fiX() {
                            AppMethodBeat.i(203702);
                            SnsTimeLineUI.this.aBf().bk(c.b.class);
                            AppMethodBeat.o(203702);
                            return false;
                        }
                    };
                    this.EKZ.DQX = this.EKT.ESp;
                    this.EKT.ESq.QYM = new b.a() {
                        /* class com.tencent.mm.plugin.sns.ui.SnsTimeLineUI.AnonymousClass43 */

                        @Override // com.tencent.mm.vending.a.b.a
                        public final void fjp() {
                            AppMethodBeat.i(203703);
                            com.tencent.mm.plugin.report.service.g.Wl(14);
                            AppMethodBeat.o(203703);
                        }

                        @Override // com.tencent.mm.vending.a.b.a
                        public final void fjq() {
                            AppMethodBeat.i(203704);
                            com.tencent.mm.plugin.report.service.g.Wm(14);
                            AppMethodBeat.o(203704);
                        }
                    };
                    this.ELc = (TestTimeForSns) this.EKZ.DQt;
                    this.ELc.setListener(new TestTimeForSns.a() {
                        /* class com.tencent.mm.plugin.sns.ui.SnsTimeLineUI.AnonymousClass44 */

                        @Override // com.tencent.mm.plugin.sns.ui.TestTimeForSns.a
                        public final void dSa() {
                            AppMethodBeat.i(203705);
                            Log.i("MicroMsg.SnsTimeLineUI", "sns has drawed");
                            SnsTimeLineUI.this.ELc.post(new Runnable() {
                                /* class com.tencent.mm.plugin.sns.ui.SnsTimeLineUI.AnonymousClass44.AnonymousClass1 */

                                public final void run() {
                                    int i2;
                                    AppMethodBeat.i(176335);
                                    if (SnsTimeLineUI.this.EKT == null || SnsTimeLineUI.this.ELc == null) {
                                        Log.i("MicroMsg.SnsTimeLineUI", "onViewDrawed is error");
                                        AppMethodBeat.o(176335);
                                        return;
                                    }
                                    SnsTimeLineUI.this.ELc.setListener(null);
                                    SnsTimeLineUI.this.EoO = SnsTimeLineUI.this.EKX;
                                    if (SnsTimeLineUI.this.ELe) {
                                        Log.w("MicroMsg.SnsTimeLineUI", "too fast that it finish");
                                        AppMethodBeat.o(176335);
                                        return;
                                    }
                                    if (SnsTimeLineUI.this.EoO) {
                                        aj.faE().W(aj.faY().DMw, -1);
                                        aj.faE().Jv(aj.faY().DMx);
                                    }
                                    if (!SnsTimeLineUI.this.EoO) {
                                        Log.i("MicroMsg.SnsTimeLineUI", "onViewDrawed doFpList");
                                        Cursor rawQuery = aj.faW().iFy.rawQuery("select *,rowid from SnsWsFoldGroup  where SnsWsFoldGroup.state=" + x.EmU + " order by SnsWsFoldGroup.top desc limit 1", null, 2);
                                        if (rawQuery != null) {
                                            if (rawQuery.moveToFirst()) {
                                                w wVar = new w();
                                                wVar.convertFrom(rawQuery);
                                                i2 = wVar.field_size;
                                            } else {
                                                i2 = -1;
                                            }
                                            rawQuery.close();
                                        } else {
                                            i2 = -1;
                                        }
                                        Log.i("MicroMsg.SnsTimeLineUI", "oldWsFoldSize:%s newWsFoldSize:%s", Integer.valueOf(i2), Integer.valueOf(ah.DKg));
                                        if (!(i2 == -1 || i2 == ah.DKg)) {
                                            Log.i("MicroMsg.SnsWsFoldGroupStorage", "dropTable:%s %s", Boolean.valueOf(aj.faW().iFy.execSQL("SnsWsFoldGroup", "DELETE FROM SnsWsFoldGroup")), Long.valueOf(System.currentTimeMillis() - System.currentTimeMillis()));
                                            com.tencent.mm.plugin.sns.storage.v faX = aj.faX();
                                            long currentTimeMillis = System.currentTimeMillis();
                                            boolean execSQL = faX.iFy.execSQL("SnsWsFoldGroupDetail", "DELETE FROM SnsWsFoldGroupDetail");
                                            faX.EmT.clear();
                                            Log.i("MicroMsg.SnsWsFoldDetailStorage", "dropTable:%s %s", Boolean.valueOf(execSQL), Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                                        }
                                        com.tencent.mm.plugin.sns.ui.a.a.c cVar = SnsTimeLineUI.this.EKS;
                                        SnsUIAction.a unused = SnsTimeLineUI.this.EMe;
                                        cVar.d(SnsTimeLineUI.this.mRa, SnsTimeLineUI.this.ELk, SnsTimeLineUI.this.EqY, SnsTimeLineUI.this.ELl);
                                        com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.USERINFO_UPDATE_SNS_TIMELINE_SCENE_INT, (Object) 1);
                                    }
                                    SnsTimeLineUI.this.EoO = false;
                                    if (SnsTimeLineUI.this.EBv != null) {
                                        SnsTimeLineUI.this.EBv.eXq();
                                    }
                                    AppMethodBeat.o(176335);
                                }
                            });
                            AppMethodBeat.o(203705);
                        }
                    });
                    this.mUIAction.list.setOnTouchListener(new View.OnTouchListener() {
                        /* class com.tencent.mm.plugin.sns.ui.SnsTimeLineUI.AnonymousClass46 */

                        public final boolean onTouch(View view, MotionEvent motionEvent) {
                            AppMethodBeat.i(203706);
                            if (motionEvent.getAction() == 1) {
                                SnsTimeLineUI.this.ffL();
                                if (SnsTimeLineUI.this.mUIAction.list != null && SnsTimeLineUI.this.mUIAction.list.getFirstVisiblePosition() == 0) {
                                    Log.d("MicroMsg.SnsTimeLineUI", "refreshIv onTouch set refreshIv visible");
                                }
                                SnsTimeLineUI.this.ELb.fju();
                            }
                            if (motionEvent.getAction() == 0) {
                                if (SnsTimeLineUI.this.mUIAction.list != null) {
                                    SnsTimeLineUI.this.mUIAction.list.getFirstVisiblePosition();
                                }
                                SnsTimeLineUI.this.EKZ.ffp();
                                SnsTimeLineUI.this.EKZ.EoK.fjZ();
                            }
                            AppMethodBeat.o(203706);
                            return false;
                        }
                    });
                    this.mUIAction.list.post(new Runnable() {
                        /* class com.tencent.mm.plugin.sns.ui.SnsTimeLineUI.AnonymousClass47 */

                        public final void run() {
                            AppMethodBeat.i(176343);
                            if (SnsTimeLineUI.this.EKZ == null) {
                                AppMethodBeat.o(176343);
                                return;
                            }
                            SnsTimeLineUI.this.EKZ.EoK.EBc = SnsTimeLineUI.this.mUIAction.list.getBottom();
                            SnsTimeLineUI.this.EKZ.EoK.ERI = SnsTimeLineUI.this.mUIAction.zog.getTop();
                            SnsTimeLineUI.this.ELb.EMU = at.fromDPToPix(SnsTimeLineUI.this.getContext(), -44);
                            AppMethodBeat.o(176343);
                        }
                    });
                    this.mUIAction.zog.setOnSrcollDistance(new MMPullDownView.f() {
                        /* class com.tencent.mm.plugin.sns.ui.SnsTimeLineUI.AnonymousClass48 */

                        @Override // com.tencent.mm.ui.base.MMPullDownView.f
                        public final void bY(float f2) {
                            AppMethodBeat.i(203707);
                            SnsTimeLineUI.Q(SnsTimeLineUI.this);
                            if (SnsTimeLineUI.ELX.booleanValue()) {
                                Log.i("MicroMsg.SnsTimeLineUI", "mUIAction.header.getTop %s originalHeaderTop %s distanceY %s", Integer.valueOf(SnsTimeLineUI.this.mUIAction.DSh.getTop()), Integer.valueOf(SnsTimeLineUI.this.ELb.EMU), Float.valueOf(f2));
                            }
                            if ((f2 > 0.0f || SnsTimeLineUI.R(SnsTimeLineUI.this)) && ((SnsTimeLineUI.this.mUIAction.DSh.getTop() >= SnsTimeLineUI.this.ELb.EMU || f2 > 0.0f) && !SnsTimeLineUI.this.mUIAction.EvK)) {
                                SnsTimeLineUI.this.ELb.bZ(f2);
                            }
                            SnsTimeLineUI.this.EKZ.ffp();
                            SnsTimeLineUI.this.ffL();
                            SnsTimeLineUI.this.EKZ.EoK.fjZ();
                            AppMethodBeat.o(203707);
                        }

                        @Override // com.tencent.mm.ui.base.MMPullDownView.f
                        public final void fjr() {
                            AppMethodBeat.i(203708);
                            if (!SnsTimeLineUI.this.mUIAction.EvK) {
                                SnsTimeLineUI.this.ELb.fju();
                            }
                            if (SnsTimeLineUI.R(SnsTimeLineUI.this)) {
                                SnsTimeLineUI.this.ELB = false;
                                AppMethodBeat.o(203708);
                                return;
                            }
                            SnsTimeLineUI.this.ELB = true;
                            AppMethodBeat.o(203708);
                        }
                    });
                    this.EKZ.EoJ = (SnsCommentFooter) findViewById(R.id.b8y);
                    this.EKZ.EoJ.post(new Runnable() {
                        /* class com.tencent.mm.plugin.sns.ui.SnsTimeLineUI.AnonymousClass49 */

                        public final void run() {
                            AppMethodBeat.i(99338);
                            com.tencent.mm.compatible.util.i.v(SnsTimeLineUI.this);
                            AppMethodBeat.o(99338);
                        }
                    });
                    this.EKZ.EoK = new bt(this.mUIAction.list, this.EKZ.EoJ);
                    this.EKU = (LinearLayout) this.mUIAction.DSh.findViewById(R.id.hzh);
                    this.EKU.findViewById(R.id.hzd).setOnClickListener(new View.OnClickListener() {
                        /* class com.tencent.mm.plugin.sns.ui.SnsTimeLineUI.AnonymousClass50 */

                        public final void onClick(View view) {
                            AppMethodBeat.i(179269);
                            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                            bVar.bm(view);
                            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsTimeLineUI$54", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                            if (!(SnsTimeLineUI.this.EKZ == null || SnsTimeLineUI.this.EKZ.EoF == null)) {
                                SnsTimeLineUI.this.EKZ.EoF.DMa.uS(true);
                            }
                            com.tencent.mm.modelsns.k tO = com.tencent.mm.modelsns.k.tO(725);
                            tO.tR(((c.b) SnsTimeLineUI.this.aBf().y(c.b.class)).xhI);
                            tO.bfK();
                            Intent intent = new Intent();
                            intent.setClass(SnsTimeLineUI.this, SnsMsgUI.class);
                            intent.putExtra("sns_msg_comment_list_scene", 1);
                            SnsTimeLineUI.this.startActivityForResult(intent, 13);
                            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsTimeLineUI$54", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                            AppMethodBeat.o(179269);
                        }
                    });
                    this.EKV = (LinearLayout) this.mUIAction.DSh.findViewById(R.id.hzi);
                    this.EKZ.EoL = new bb(this);
                    fja();
                    fjb();
                    if (this.EMi == 0) {
                        setMMTitle(R.string.hbf);
                    } else {
                        if (this.EqY) {
                            setMMTitle(R.string.h9h);
                        } else {
                            Log.d("MicroMsg.SnsTimeLineUI", "SnsUserUI, userName:%s, title:%s", this.mRa, this.mUIAction.title);
                            as Kn = aj.faC().Kn(this.mRa);
                            if (Kn != null) {
                                Log.d("MicroMsg.SnsTimeLineUI", "SnsUserUI, contact is not null");
                                str = Kn.arJ();
                            } else {
                                Log.d("MicroMsg.SnsTimeLineUI", "SnsUserUI, contact is null, title:%s", this.mUIAction.title);
                                str = this.mUIAction.title;
                            }
                            setMMTitle(r.R(str));
                        }
                        ZR(8);
                    }
                    if (BuildInfo.IS_FLAVOR_RED || BuildInfo.IS_FLAVOR_PURPLE || BuildInfo.DEBUG) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (1 == ((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_get_max_texture_size, 0)) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    Log.i("MicroMsg.SnsTimeLineUI", "getGpuMaxTextureSize %s %s.", Boolean.valueOf(z), Boolean.valueOf(z2));
                    if (z || z2) {
                        z3 = true;
                    }
                    ForceGpuUtil.setMaxTextureGet(z3);
                    if (z3) {
                        int maxTextureSize = ForceGpuUtil.getMaxTextureSize();
                        if (maxTextureSize <= 2048) {
                            com.tencent.mm.plugin.report.service.h.INSTANCE.dN(1198, 7);
                        } else if (maxTextureSize <= 4096) {
                            com.tencent.mm.plugin.report.service.h.INSTANCE.dN(1198, 8);
                        } else if (maxTextureSize <= 6144) {
                            com.tencent.mm.plugin.report.service.h.INSTANCE.dN(1198, 9);
                        } else if (maxTextureSize <= 8192) {
                            com.tencent.mm.plugin.report.service.h.INSTANCE.dN(1198, 10);
                        } else {
                            com.tencent.mm.plugin.report.service.h.INSTANCE.dN(1198, 11);
                        }
                    }
                    this.ELr = (ViewGroup) findViewById(R.id.i1e);
                    this.ELr.setOnClickListener(new View.OnClickListener() {
                        /* class com.tencent.mm.plugin.sns.ui.SnsTimeLineUI.AnonymousClass51 */

                        public final void onClick(View view) {
                            AppMethodBeat.i(203709);
                            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                            bVar.bm(view);
                            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsTimeLineUI$55", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                            SnsTimeLineUI.this.EKZ.ffv();
                            com.tencent.mm.plugin.sns.k.e.DUQ.DVy.eTU = 2;
                            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsTimeLineUI$55", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                            AppMethodBeat.o(203709);
                        }
                    });
                    this.ELr.setVisibility(4);
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                    layoutParams.topMargin = at.fromDPToPix(getContext(), 24) + au.eu(getContext()) + au.getStatusBarHeight(getContext());
                    layoutParams.addRule(14);
                    this.ELr.setLayoutParams(layoutParams);
                    AppMethodBeat.o(99388);
                }

                @Override // com.tencent.mm.ui.MMActivity
                public void onKeyboardStateChanged() {
                    AppMethodBeat.i(99389);
                    super.onKeyboardStateChanged();
                    MMHandlerThread.postToMainThread(new Runnable() {
                        /* class com.tencent.mm.plugin.sns.ui.SnsTimeLineUI.AnonymousClass52 */

                        public final void run() {
                            AppMethodBeat.i(179271);
                            SnsTimeLineUI.this.ffL();
                            AppMethodBeat.o(179271);
                        }
                    });
                    if (keyboardState() == 2) {
                        if (!(this.EKZ == null || this.EKZ.EoJ == null || this.EKZ.EoJ.fhW())) {
                            Log.i("MicroMsg.SnsTimeLineUI", "onKeyBoardStateChange find");
                            AppMethodBeat.o(99389);
                            return;
                        }
                    } else if (keyboardState() == 1 && this.EKZ != null) {
                        this.EKZ.ffq();
                    }
                    AppMethodBeat.o(99389);
                }

                @Override // com.tencent.mm.ui.MMFragmentActivity
                public boolean supportNavigationSwipeBack() {
                    AppMethodBeat.i(99390);
                    boolean supportNavigationSwipeBack = super.supportNavigationSwipeBack();
                    AppMethodBeat.o(99390);
                    return supportNavigationSwipeBack;
                }

                private void fjb() {
                    AppMethodBeat.i(99391);
                    setTitleBarClickListener(new Runnable() {
                        /* class com.tencent.mm.plugin.sns.ui.SnsTimeLineUI.AnonymousClass55 */

                        public final void run() {
                            AppMethodBeat.i(203712);
                            SnsTimeLineUI.S(SnsTimeLineUI.this);
                            AppMethodBeat.o(203712);
                        }
                    }, new Runnable() {
                        /* class com.tencent.mm.plugin.sns.ui.SnsTimeLineUI.AnonymousClass57 */

                        public final void run() {
                        }
                    });
                    setBackBtn(this.ubB, R.raw.actionbar_icon_dark_back);
                    AppMethodBeat.o(99391);
                }

                private int fjc() {
                    if (this.ELx == 0) {
                        return this.ELu;
                    }
                    if (this.ELx == 1) {
                        return this.ELv;
                    }
                    return this.ELw;
                }

                private void fjd() {
                    AppMethodBeat.i(99392);
                    boolean booleanValue = ((Boolean) com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.USERINFO_STORY_NEW_FEATURE_TIP_BOOLEAN_SYNC, Boolean.TRUE)).booleanValue();
                    com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.USERINFO_STORY_NEW_FEATURE_TIP_BOOLEAN_SYNC, Boolean.FALSE);
                    if (booleanValue) {
                        com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.USERINFO_STORY_NEW_FEATURE_TIP_BOOLEAN_SYNC, Boolean.FALSE);
                    }
                    if (!((com.tencent.mm.plugin.story.api.e) com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.story.api.e.class)).canPostStory()) {
                        com.tencent.mm.kernel.g.aAi();
                        int intValue = ((Integer) com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.USERINFO_STORY_ONE_DAY_POST_COUNT_INT_SYNC, (Object) 0)).intValue();
                        com.tencent.mm.ui.base.h.c(getContext(), "", getContext().getResources().getString(R.string.his, Integer.valueOf(intValue)), true);
                        AppMethodBeat.o(99392);
                        return;
                    }
                    ((com.tencent.mm.plugin.story.api.e) com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.story.api.e.class)).startStoryCaptureForResult(getContext(), 0, System.currentTimeMillis(), 18);
                    AppMethodBeat.o(99392);
                }

                private void fje() {
                    AppMethodBeat.i(99393);
                    if (com.tencent.mm.q.a.cA(this)) {
                        AppMethodBeat.o(99393);
                    } else if (com.tencent.mm.q.a.cE(this)) {
                        AppMethodBeat.o(99393);
                    } else {
                        boolean a2 = com.tencent.mm.pluginsdk.permission.b.a(this, "android.permission.CAMERA", 18, "", "");
                        Log.i("MicroMsg.SnsTimeLineUI", "summerper checkPermission checkCamera[%b], stack[%s], activity[%s]", Boolean.valueOf(a2), Util.getStack(), this);
                        if (!a2) {
                            AppMethodBeat.o(99393);
                            return;
                        }
                        long aWz = cl.aWz();
                        String eZx = r.eZx();
                        Log.i("MicroMsg.SnsTimeLineUI", "doCpatureMMSight sessionID:%s", eZx);
                        com.tencent.mm.plugin.report.service.h.INSTANCE.a(13822, 1, 2, eZx, Long.valueOf(aWz));
                        SightParams sightParams = new SightParams(2, 0);
                        RecordConfigProvider a3 = RecordConfigProvider.a("", "", sightParams.irT, sightParams.irT.duration * 1000, 2);
                        if (((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_sns_ignore_remux_without_edit, false)) {
                            a3.remuxType = 2;
                        }
                        VideoCaptureReportInfo videoCaptureReportInfo = new VideoCaptureReportInfo();
                        videoCaptureReportInfo.sQn = 1;
                        a3.BOE = videoCaptureReportInfo;
                        UICustomParam.a aVar = new UICustomParam.a();
                        aVar.apD();
                        aVar.apE();
                        aVar.dz(true);
                        a3.BOn = aVar.gLU;
                        CaptureDataManager.BOb.BOa = new CaptureDataManager.c() {
                            /* class com.tencent.mm.plugin.sns.ui.SnsTimeLineUI.AnonymousClass65 */

                            @Override // com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.c, com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.b
                            public final void a(Context context, CaptureDataManager.CaptureVideoNormalModel captureVideoNormalModel, Bundle bundle) {
                                AppMethodBeat.i(203717);
                                r.aOz(new StringBuilder().append(captureVideoNormalModel.eJJ().y("KEY_EDIT_PUBLISHID_INT", -1)).toString());
                                cly cly = new cly();
                                cly.Mrn = true;
                                cly.Mrm = false;
                                SightCaptureResult sightCaptureResult = new SightCaptureResult(true, captureVideoNormalModel.videoPath, captureVideoNormalModel.thumbPath, s.bpb(captureVideoNormalModel.videoPath), com.tencent.xweb.util.d.getMD5(captureVideoNormalModel.videoPath), (int) (captureVideoNormalModel.BOd.longValue() / 1000), cly);
                                if (captureVideoNormalModel.BOe.booleanValue()) {
                                    sightCaptureResult.zsy = true;
                                    sightCaptureResult.tkD = false;
                                    sightCaptureResult.zsG = captureVideoNormalModel.thumbPath;
                                }
                                Intent intent = new Intent();
                                intent.putExtra("key_req_result", sightCaptureResult);
                                ((Activity) context).setResult(-1, intent);
                                ((Activity) context).finish();
                                AppMethodBeat.o(203717);
                            }

                            @Override // com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.c, com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.b
                            public final boolean a(Context context, Bundle bundle, CaptureDataManager.a aVar) {
                                return false;
                            }
                        };
                        if (((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_jump_to_record_media, true)) {
                            com.tencent.mm.plugin.recordvideo.jumper.a aVar2 = com.tencent.mm.plugin.recordvideo.jumper.a.BOL;
                            com.tencent.mm.plugin.recordvideo.jumper.a.a(getContext(), 17, R.anim.ei, R.anim.ej, a3);
                            AppMethodBeat.o(99393);
                            return;
                        }
                        com.tencent.mm.pluginsdk.ui.tools.s.d(getContext(), new Intent(), eZx);
                        AppMethodBeat.o(99393);
                    }
                }

                @Override // com.tencent.mm.plugin.sns.ui.x
                public final boolean fv(View view) {
                    AppMethodBeat.i(99394);
                    this.EKZ.EoR.fcl();
                    this.EKZ.EoT.fcl();
                    boolean d2 = this.EKZ.EoQ.d(view, false, false);
                    AppMethodBeat.o(99394);
                    return d2;
                }

                @Override // com.tencent.mm.plugin.sns.ui.x
                public final boolean ffL() {
                    AppMethodBeat.i(99395);
                    if (this.EKZ == null || this.EKZ.EoQ == null) {
                        AppMethodBeat.o(99395);
                        return false;
                    }
                    if (!(this.EKZ == null || this.EKZ.EoR == null)) {
                        this.EKZ.EoR.fcl();
                    }
                    if (!(this.EKZ == null || this.EKZ.EoT == null)) {
                        this.EKZ.EoT.fcl();
                    }
                    if (!(this.EKZ == null || this.EKZ.EoU == null)) {
                        this.EKZ.EoU.fka();
                    }
                    com.tencent.mm.plugin.sns.abtest.a.eWu();
                    boolean ffL = this.EKZ.EoQ.ffL();
                    AppMethodBeat.o(99395);
                    return ffL;
                }

                @Override // com.tencent.mm.model.bb
                public final void aVs() {
                    AppMethodBeat.i(99396);
                    aBf().bk(c.b.class);
                    AppMethodBeat.o(99396);
                }

                @Override // com.tencent.mm.model.bb
                public final void aVt() {
                }

                @Override // com.tencent.mm.model.bb
                public final void aVu() {
                    AppMethodBeat.i(99397);
                    if (this.EMm) {
                        AppMethodBeat.o(99397);
                        return;
                    }
                    Log.v("MicroMsg.SnsTimeLineUI", "notifyHbReward imp");
                    this.EMm = true;
                    aj.dRd().postDelayed(new Runnable() {
                        /* class com.tencent.mm.plugin.sns.ui.SnsTimeLineUI.AnonymousClass68 */

                        public final void run() {
                            AppMethodBeat.i(203719);
                            if (SnsTimeLineUI.this.EKT != null) {
                                SnsTimeLineUI.this.EKT.ESq.notifyVendingDataChange();
                            }
                            SnsTimeLineUI.this.EMm = false;
                            AppMethodBeat.o(203719);
                        }
                    }, 1000);
                    AppMethodBeat.o(99397);
                }

                @Override // com.tencent.mm.ak.i
                public void onSceneEnd(int i2, int i3, String str, q qVar) {
                    AppMethodBeat.i(99398);
                    Log.i("MicroMsg.SnsTimeLineUI", "uionSceneEnd: errType = " + i2 + " errCode = " + i3 + " errMsg = " + str + " type = " + qVar.getType());
                    if (qVar.getType() == 218) {
                        com.tencent.mm.plugin.sns.model.s sVar = (com.tencent.mm.plugin.sns.model.s) qVar;
                        if ((sVar.type == 1 || sVar.type == 6 || sVar.type == 4) && this.EKZ.EoW != null) {
                            this.EKZ.EoW.dismiss();
                        }
                        if (sVar.type == 11) {
                            if (this.mUIAction.tipDialog != null) {
                                this.mUIAction.tipDialog.dismiss();
                            }
                            if (this.EMj != null) {
                                this.EMj.setImageResource(R.raw.icons_outlined_camera);
                            }
                        }
                    }
                    if (this.EKT != null) {
                        this.EKT.ESq.notifyVendingDataChange();
                    }
                    if (qVar.getType() == 211) {
                        com.tencent.mm.plugin.sns.model.z zVar = (com.tencent.mm.plugin.sns.model.z) qVar;
                        if (zVar.DIe) {
                            com.tencent.mm.modelsns.k tO = com.tencent.mm.modelsns.k.tO(727);
                            tO.tR(this.EKT.getCount()).tR(zVar.akb);
                            tO.bfK();
                        } else {
                            com.tencent.mm.modelsns.k tO2 = com.tencent.mm.modelsns.k.tO(728);
                            tO2.tR(this.EKT.getCount()).tR(zVar.akb).tR(0);
                            tO2.bfK();
                        }
                        if (this.ELb != null) {
                            this.EKY = false;
                            this.ELb.fjt();
                        }
                    }
                    a(i2, i3, qVar, this);
                    AppMethodBeat.o(99398);
                }

                public static void a(int i2, int i3, q qVar, final Context context) {
                    AppMethodBeat.i(203732);
                    if (qVar == null) {
                        AppMethodBeat.o(203732);
                    } else if (qVar.getType() != 213) {
                        AppMethodBeat.o(203732);
                    } else if (!((com.tencent.mm.plugin.websearch.api.c) com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.websearch.api.c.class)).isOpenInlineSnsTag()) {
                        AppMethodBeat.o(203732);
                    } else if (i2 != 0 || i3 != 0) {
                        AppMethodBeat.o(203732);
                    } else if (!(qVar instanceof p)) {
                        AppMethodBeat.o(203732);
                    } else {
                        final p pVar = (p) qVar;
                        if (!(context instanceof SnsTimeLineUI) || pVar.DIk == 0) {
                            final long aWB = (long) cl.aWB();
                            com.tencent.f.h.RTc.b(new Runnable() {
                                /* class com.tencent.mm.plugin.sns.ui.SnsTimeLineUI.AnonymousClass70 */

                                public final void run() {
                                    dzi dzi;
                                    AppMethodBeat.i(203722);
                                    p pVar = pVar;
                                    if (pVar.DIb != null) {
                                        dzi = pVar.DIb.MZb;
                                    } else {
                                        dzi = null;
                                    }
                                    SnsObject snsObject = pVar.DqN;
                                    SnsInfo snsInfo = pVar.DqO;
                                    if (dzi == null || snsObject == null || snsInfo == null) {
                                        AppMethodBeat.o(203722);
                                        return;
                                    }
                                    dzo a2 = r.a(dzi, snsObject);
                                    if (a2 == null) {
                                        AppMethodBeat.o(203722);
                                        return;
                                    }
                                    Matcher matcher = k.a.Krb.matcher(dzi.iAc);
                                    while (matcher.find()) {
                                        SnsCommentFooter.a(context, snsInfo, r.a(a2), String.valueOf(a2.MYT), 3, matcher.group(), aWB);
                                    }
                                    AppMethodBeat.o(203722);
                                }
                            }, "WebSearchReportLogic.TagSearchReport");
                            AppMethodBeat.o(203732);
                            return;
                        }
                        AppMethodBeat.o(203732);
                    }
                }

                /* access modifiers changed from: protected */
                @Override // java.lang.Object
                public void finalize() {
                    AppMethodBeat.i(99399);
                    Log.d("MicroMsg.SnsTimeLineUI", "finalize");
                    super.finalize();
                    AppMethodBeat.o(99399);
                }

                @Override // com.tencent.mm.model.bb
                public final void aVv() {
                    AppMethodBeat.i(99400);
                    aBf().bk(c.b.class);
                    AppMethodBeat.o(99400);
                }

                @Override // com.tencent.mm.ui.component.UIComponentActivity, android.support.v4.app.FragmentActivity
                public void onBackPressed() {
                    AppMethodBeat.i(99401);
                    finish();
                    AppMethodBeat.o(99401);
                }

                @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
                public void onActivityResult(int i2, int i3, Intent intent) {
                    AppMethodBeat.i(99402);
                    Log.v("MicroMsg.SnsTimeLineUI", "on ActivityResult, requestCode %d, resultCode %d", Integer.valueOf(i2), Integer.valueOf(i3));
                    if (i2 == 15) {
                        if (!(this.EKZ == null || this.EKZ.EoV == null || this.EKZ.EoV.Far == null)) {
                            this.EKZ.EoV.Far.onActivityResult(i2, i3, intent);
                            MMHandlerThread.postToMainThreadDelayed(new Runnable() {
                                /* class com.tencent.mm.plugin.sns.ui.SnsTimeLineUI.AnonymousClass71 */

                                public final void run() {
                                    AppMethodBeat.i(203723);
                                    SnsTimeLineUI.this.hideVKB();
                                    AppMethodBeat.o(203723);
                                }
                            }, 300);
                        }
                        AppMethodBeat.o(99402);
                    } else if (i2 == 16) {
                        Log.i("MicroMsg.SnsTimeLineUI", "REQUEST_CODE_FOR_FULLSCREEN");
                        AppMethodBeat.o(99402);
                    } else {
                        if (i2 == 2333 && intent != null) {
                            String stringExtra = intent.getStringExtra("Select_Contact");
                            if (!Util.isNullOrNil(stringExtra)) {
                                String[] split = stringExtra.split(",");
                                if (split.length > 0) {
                                    this.EKZ.EoJ.gte.showVKB();
                                    String displayName = ((com.tencent.mm.plugin.messenger.a.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.a.b.class)).getDisplayName(split[0]);
                                    if (!Util.isNullOrNil(displayName)) {
                                        this.EKZ.EoJ.fhY();
                                        this.EKZ.EoJ.setText("@" + displayName + " ");
                                        this.EKZ.EoJ.setCommentAtPrefix("@" + displayName + " ");
                                        this.EKZ.EoJ.setCommentInfo(new dzo());
                                        this.EKZ.EoJ.getCommentInfo().Username = split[0];
                                        this.EKZ.EoJ.setCommentFlag(8);
                                    }
                                }
                            }
                        }
                        super.onActivityResult(i2, i3, intent);
                        this.mUIAction.onActivityResult(i2, i3, intent);
                        if (i2 == 11) {
                            this.EKS.d(this.mRa, this.ELk, this.EqY, this.ELl);
                            AppMethodBeat.o(99402);
                            return;
                        }
                        AppMethodBeat.o(99402);
                    }
                }

                /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
                @Override // com.tencent.mm.ui.component.UIComponentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.a.AbstractC0015a
                public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
                    AppMethodBeat.i(99403);
                    if (iArr == null || iArr.length <= 0) {
                        Log.i("MicroMsg.SnsTimeLineUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", Integer.valueOf(i2), Long.valueOf(Thread.currentThread().getId()));
                        AppMethodBeat.o(99403);
                        return;
                    }
                    Log.i("MicroMsg.SnsTimeLineUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", Integer.valueOf(i2), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId()));
                    switch (i2) {
                        case 18:
                            if (iArr[0] == 0) {
                                fje();
                                AppMethodBeat.o(99403);
                                return;
                            }
                            int i3 = "android.permission.CAMERA".equals(strArr[0]) ? R.string.fl0 : R.string.flb;
                            if (iArr[0] != 0) {
                                com.tencent.mm.ui.base.h.a((Context) this, getString(i3), getString(R.string.flp), getString(R.string.e_k), getString(R.string.sz), false, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                                    /* class com.tencent.mm.plugin.sns.ui.SnsTimeLineUI.AnonymousClass72 */

                                    public final void onClick(DialogInterface dialogInterface, int i2) {
                                        AppMethodBeat.i(203724);
                                        dialogInterface.dismiss();
                                        SnsTimeLineUI snsTimeLineUI = SnsTimeLineUI.this;
                                        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                                        com.tencent.mm.hellhoundlib.a.a.a(snsTimeLineUI, bl.axQ(), "com/tencent/mm/plugin/sns/ui/SnsTimeLineUI$75", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                                        snsTimeLineUI.startActivity((Intent) bl.pG(0));
                                        com.tencent.mm.hellhoundlib.a.a.a(snsTimeLineUI, "com/tencent/mm/plugin/sns/ui/SnsTimeLineUI$75", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                                        AppMethodBeat.o(203724);
                                    }
                                }, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                                    /* class com.tencent.mm.plugin.sns.ui.SnsTimeLineUI.AnonymousClass73 */

                                    public final void onClick(DialogInterface dialogInterface, int i2) {
                                        AppMethodBeat.i(203725);
                                        dialogInterface.dismiss();
                                        AppMethodBeat.o(203725);
                                    }
                                });
                            }
                            AppMethodBeat.o(99403);
                            return;
                        case 24:
                            if (iArr[0] == 0) {
                                fjd();
                                AppMethodBeat.o(99403);
                                return;
                            }
                            com.tencent.mm.ui.base.h.a((Context) getContext(), getString("android.permission.CAMERA".equals(strArr[0]) ? R.string.fl0 : R.string.flb), getString(R.string.flp), getString(R.string.e_k), getString(R.string.sz), false, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                                /* class com.tencent.mm.plugin.sns.ui.SnsTimeLineUI.AnonymousClass74 */

                                public final void onClick(DialogInterface dialogInterface, int i2) {
                                    AppMethodBeat.i(203726);
                                    dialogInterface.dismiss();
                                    AppCompatActivity context = SnsTimeLineUI.this.getContext();
                                    com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                                    com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/plugin/sns/ui/SnsTimeLineUI$77", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                                    context.startActivity((Intent) bl.pG(0));
                                    com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/plugin/sns/ui/SnsTimeLineUI$77", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                                    AppMethodBeat.o(203726);
                                }
                            }, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                                /* class com.tencent.mm.plugin.sns.ui.SnsTimeLineUI.AnonymousClass75 */

                                public final void onClick(DialogInterface dialogInterface, int i2) {
                                    AppMethodBeat.i(203727);
                                    dialogInterface.dismiss();
                                    AppMethodBeat.o(203727);
                                }
                            });
                            AppMethodBeat.o(99403);
                            return;
                        case h.a.CTRL_INDEX:
                            if (iArr[0] != 0) {
                                com.tencent.mm.ui.base.h.a((Context) getContext(), getString(R.string.fl_), getString(R.string.flp), getString(R.string.e_k), getString(R.string.sz), false, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                                    /* class com.tencent.mm.plugin.sns.ui.SnsTimeLineUI.AnonymousClass76 */

                                    public final void onClick(DialogInterface dialogInterface, int i2) {
                                        AppMethodBeat.i(203728);
                                        AppCompatActivity context = SnsTimeLineUI.this.getContext();
                                        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                                        com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/plugin/sns/ui/SnsTimeLineUI$79", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                                        context.startActivity((Intent) bl.pG(0));
                                        com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/plugin/sns/ui/SnsTimeLineUI$79", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                                        AppMethodBeat.o(203728);
                                    }
                                }, (DialogInterface.OnClickListener) null);
                                break;
                            } else {
                                fjd();
                                AppMethodBeat.o(99403);
                                return;
                            }
                    }
                    AppMethodBeat.o(99403);
                }

                @Override // com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.ui.widget.SwipeBackLayout.a
                public void onDrag() {
                    AppMethodBeat.i(99404);
                    super.onDrag();
                    AppMethodBeat.o(99404);
                }

                public final void vx(boolean z) {
                    AppMethodBeat.i(99405);
                    if (this.EKT != null) {
                        Log.i("MicroMsg.SnsTimeLineUI", "set play animation %s", Boolean.valueOf(z));
                        com.tencent.mm.plugin.sns.ui.a.c cVar = this.EKT;
                        cVar.ESr = z;
                        if (!z) {
                            cVar.notifyDataSetChanged();
                        }
                    }
                    AppMethodBeat.o(99405);
                }

                private static void a(c cVar) {
                    AppMethodBeat.i(99406);
                    if (cVar.active) {
                        Log.d("MicroMsg.SnsTimeLineUI", "report weishi: %s", cVar.toString());
                        com.tencent.mm.plugin.report.service.h.INSTANCE.kvStat(15827, cVar.toString());
                    }
                    AppMethodBeat.o(99406);
                }

                /* access modifiers changed from: package-private */
                public class b {
                    public int ENb;
                    public int type;

                    private b() {
                        this.type = 0;
                    }

                    /* synthetic */ b(SnsTimeLineUI snsTimeLineUI, byte b2) {
                        this();
                    }
                }

                /* access modifiers changed from: package-private */
                public class c {
                    public String ENc;
                    public long ENd;
                    public int ENe;
                    public int ENf;
                    public long ENg;
                    public int ENh;
                    public long ENi;
                    public int ENj;
                    public long ENk;
                    public boolean active;
                    public long mNy;
                    public int scene;

                    private c() {
                        this.active = true;
                        this.ENc = "";
                    }

                    /* synthetic */ c(SnsTimeLineUI snsTimeLineUI, byte b2) {
                        this();
                    }

                    /* access modifiers changed from: package-private */
                    public final void reset() {
                        this.scene = 0;
                        this.ENd = 0;
                        this.ENe = -1;
                        this.ENf = 0;
                        this.mNy = 0;
                        this.ENg = 0;
                        this.ENh = 0;
                        this.ENi = 0;
                        this.ENj = 0;
                        this.ENk = 0;
                    }

                    public final void ZT(int i2) {
                        AppMethodBeat.i(99368);
                        if (!this.active) {
                            AppMethodBeat.o(99368);
                            return;
                        }
                        this.ENf = i2;
                        this.mNy = Util.nowMilliSecond();
                        AppMethodBeat.o(99368);
                    }

                    public final void ZU(int i2) {
                        AppMethodBeat.i(99369);
                        if (!this.active) {
                            AppMethodBeat.o(99369);
                            return;
                        }
                        reset();
                        this.scene = 2;
                        this.ENg = Util.nowMilliSecond();
                        this.ENh = i2;
                        AppMethodBeat.o(99369);
                    }

                    public final void ZV(int i2) {
                        AppMethodBeat.i(99370);
                        if (!this.active) {
                            AppMethodBeat.o(99370);
                            return;
                        }
                        reset();
                        this.scene = 3;
                        this.ENi = Util.nowMilliSecond();
                        this.ENk = 0;
                        this.ENj = i2;
                        AppMethodBeat.o(99370);
                    }

                    public final String toString() {
                        AppMethodBeat.i(99371);
                        StringBuilder sb = new StringBuilder();
                        sb.append(this.ENc).append(",").append(this.scene).append(",").append(this.ENd).append(",").append(this.ENe).append(",").append(this.ENf).append(",").append(this.mNy).append(",").append(this.ENg).append(",").append(this.ENh).append(",").append(this.ENi).append(",").append(this.ENj).append(",").append(this.ENk);
                        String sb2 = sb.toString();
                        AppMethodBeat.o(99371);
                        return sb2;
                    }
                }

                public final com.tencent.mm.plugin.sns.ad.g.k fjf() {
                    return this.EBv;
                }

                @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v4.app.FragmentActivity
                public void onNewIntent(Intent intent) {
                    AppMethodBeat.i(203733);
                    super.onNewIntent(intent);
                    Bundle bundleExtra = intent.getBundleExtra("key_finder_bundle_info");
                    if (bundleExtra != null) {
                        Intent intent2 = new Intent();
                        String string = bundleExtra.getString("key_context_id");
                        long j2 = bundleExtra.getLong("key_finder_post_local_id");
                        intent2.putExtra("KEY_FINDER_POST_FINISH_JUMP_FOLLOW_TAB", true);
                        intent2.putExtra("key_finder_post_local_id", j2);
                        intent2.putExtra("KEY_POST_DIRECTLY_FROM_SNS", true);
                        if (!Util.isNullOrNil(string)) {
                            intent2.putExtra("key_context_id", string);
                        }
                        ((com.tencent.mm.plugin.i.a.aj) com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.i.a.aj.class)).enterFinderTimelineUI(getContext(), intent2);
                        finish();
                    }
                    AppMethodBeat.o(203733);
                }

                static /* synthetic */ void c(SnsTimeLineUI snsTimeLineUI) {
                    AppMethodBeat.i(179290);
                    snsTimeLineUI.mUIAction.list.post(new Runnable() {
                        /* class com.tencent.mm.plugin.sns.ui.SnsTimeLineUI.AnonymousClass27 */

                        public final void run() {
                            AppMethodBeat.i(99309);
                            SnsTimeLineUI.z(SnsTimeLineUI.this);
                            AppMethodBeat.o(99309);
                        }
                    });
                    AppMethodBeat.o(179290);
                }

                static /* synthetic */ void f(SnsTimeLineUI snsTimeLineUI) {
                    AppMethodBeat.i(179291);
                    snsTimeLineUI.EKS.d(snsTimeLineUI.mRa, snsTimeLineUI.ELk, snsTimeLineUI.EqY, snsTimeLineUI.ELl);
                    AppMethodBeat.o(179291);
                }

                static /* synthetic */ void a(SnsTimeLineUI snsTimeLineUI, int i2) {
                    AppMethodBeat.i(179292);
                    com.tencent.mm.modelsns.k tO = com.tencent.mm.modelsns.k.tO(507);
                    int lastVisiblePosition = snsTimeLineUI.mUIAction.list.getLastVisiblePosition() - 1;
                    int count = snsTimeLineUI.EKT.getCount();
                    for (int firstVisiblePosition = snsTimeLineUI.mUIAction.list.getFirstVisiblePosition() - 1; firstVisiblePosition <= lastVisiblePosition; firstVisiblePosition++) {
                        if (firstVisiblePosition < count && firstVisiblePosition >= 0 && firstVisiblePosition != i2) {
                            if (i2 > firstVisiblePosition) {
                                String v = r.v(snsTimeLineUI.EKZ.DQX.Zv(firstVisiblePosition));
                                if (tO.bfG()) {
                                    if (tO.jls.length() != 0) {
                                        tO.jls.append("||".concat(String.valueOf(v)));
                                    } else if (Util.isNullOrNil(v)) {
                                        tO.jls.append(" ");
                                    } else {
                                        tO.jls.append(v);
                                    }
                                }
                            } else {
                                tO.PH(r.v(snsTimeLineUI.EKZ.DQX.Zv(firstVisiblePosition)));
                            }
                        }
                    }
                    tO.bfK();
                    AppMethodBeat.o(179292);
                }

                static /* synthetic */ void a(SnsTimeLineUI snsTimeLineUI, int i2, int i3, ir irVar) {
                    TagImageView tagImageView;
                    AppMethodBeat.i(179293);
                    int firstVisiblePosition = snsTimeLineUI.EKZ.list.getFirstVisiblePosition();
                    int headerViewsCount = snsTimeLineUI.EKZ.list.getHeaderViewsCount();
                    SnsInfo Zv = snsTimeLineUI.EKZ.DQX.Zv(i3);
                    if (Zv != null) {
                        TimeLineObject timeLine = Zv.getTimeLine();
                        if (timeLine.ContentObj.LoU == 1 && timeLine.ContentObj.LoV.size() == 4 && i2 > 1) {
                            i2++;
                        }
                    } else {
                        Log.e("MicroMsg.SnsTimeLineUI", "snsInfo is null");
                    }
                    View childAt = snsTimeLineUI.EKZ.list.getChildAt((i3 - firstVisiblePosition) + headerViewsCount);
                    if (!(childAt == null || childAt.getTag() == null || !(childAt.getTag() instanceof BaseTimeLineItem.BaseViewHolder))) {
                        BaseTimeLineItem.BaseViewHolder baseViewHolder = (BaseTimeLineItem.BaseViewHolder) childAt.getTag();
                        if (baseViewHolder.EWX != null) {
                            tagImageView = baseViewHolder.EWX.ZD(i2);
                        } else {
                            tagImageView = baseViewHolder.EXr != null ? baseViewHolder.EWG : null;
                        }
                        if (tagImageView != null) {
                            int[] iArr = new int[2];
                            tagImageView.getLocationOnScreen(iArr);
                            irVar.dNn.dEq = iArr[0];
                            irVar.dNn.dEr = iArr[1];
                            irVar.dNn.dEs = tagImageView.getWidth();
                            irVar.dNn.dEt = tagImageView.getHeight();
                        }
                    }
                    AppMethodBeat.o(179293);
                }

                /* JADX WARNING: Removed duplicated region for block: B:33:0x013e  */
                /* JADX WARNING: Removed duplicated region for block: B:61:0x0098 A[SYNTHETIC] */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                static /* synthetic */ void a(com.tencent.mm.plugin.sns.ui.SnsTimeLineUI r19, int r20, int r21) {
                    /*
                    // Method dump skipped, instructions count: 512
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.sns.ui.SnsTimeLineUI.a(com.tencent.mm.plugin.sns.ui.SnsTimeLineUI, int, int):void");
                }

                static /* synthetic */ void z(SnsTimeLineUI snsTimeLineUI) {
                    AppMethodBeat.i(203736);
                    if (snsTimeLineUI.autoPlay) {
                        com.tencent.mm.plugin.sns.ui.video.d fkS = com.tencent.mm.plugin.sns.ui.video.d.fkS();
                        Log.i("MicroMsg.Sns.SnsVideoViewMgr", "pausePlayWithGone");
                        fkS.cXa();
                        if (fkS.Fdr != null) {
                            fkS.Fdr.setVisibility(8);
                        }
                    }
                    AppMethodBeat.o(203736);
                }

                static /* synthetic */ void a(SnsTimeLineUI snsTimeLineUI, c.b bVar) {
                    AdSnsInfo JE;
                    boolean z = false;
                    AppMethodBeat.i(203737);
                    if (snsTimeLineUI.findViewById(R.id.hzk) != null) {
                        ((TextView) snsTimeLineUI.findViewById(R.id.hzk)).setText(snsTimeLineUI.getResources().getQuantityString(R.plurals.a5, bVar.xhI, Integer.valueOf(bVar.xhI)));
                        ImageView imageView = (ImageView) snsTimeLineUI.findViewById(R.id.hzf);
                        try {
                            long j2 = bVar.DuE;
                            if (!(j2 == 0 || (JE = aj.faR().JE(j2)) == null)) {
                                z = com.tencent.mm.plugin.sns.ui.widget.e.a(imageView, JE.convertToSnsInfo(), bVar.FgF);
                            }
                        } catch (Exception e2) {
                            Log.e("MicroMsg.SnsTimeLineUI", "trySetAdBossCommentAvater exp=" + e2.toString());
                        }
                        if (!z) {
                            a.b.c(imageView, bVar.FgF);
                        }
                    }
                    AppMethodBeat.o(203737);
                }

                static /* synthetic */ void b(SnsTimeLineUI snsTimeLineUI, final long j2) {
                    AppMethodBeat.i(203738);
                    final SnsInfo JJ = aj.faO().JJ(j2);
                    if (JJ != null) {
                        final TimeLineObject timeLine = JJ.getTimeLine();
                        final LayoutInflater from = LayoutInflater.from(snsTimeLineUI);
                        snsTimeLineUI.runOnUiThread(new Runnable() {
                            /* class com.tencent.mm.plugin.sns.ui.SnsTimeLineUI.AnonymousClass69 */

                            public final void run() {
                                final String str;
                                AppMethodBeat.i(203721);
                                View inflate = from.inflate(R.layout.bw0, (ViewGroup) SnsTimeLineUI.this.EKV, false);
                                SnsTimeLineUI.this.EKV.addView(inflate);
                                if (SnsTimeLineUI.this.EKV.getChildCount() > 0) {
                                    SnsTimeLineUI.this.EKV.setVisibility(0);
                                }
                                ImageView imageView = (ImageView) inflate.findViewById(R.id.hzj);
                                TextView textView = (TextView) inflate.findViewById(R.id.hzk);
                                if (textView == null) {
                                    AppMethodBeat.o(203721);
                                    return;
                                }
                                if (timeLine.ContentObj.LoV.size() > 0) {
                                    com.tencent.mm.plugin.sns.model.g faL = aj.faL();
                                    int hashCode = SnsTimeLineUI.this.hashCode();
                                    bp gCU = bp.gCU();
                                    gCU.hXs = timeLine.CreateTime;
                                    faL.b(timeLine.ContentObj.LoV.get(0), imageView, hashCode, gCU);
                                }
                                if (timeLine.ContentObj.LoU == 1) {
                                    textView.setText(R.string.h9d);
                                    str = SnsTimeLineUI.this.getString(R.string.h9e);
                                } else if (timeLine.ContentObj.LoU == 15) {
                                    textView.setText(R.string.h_r);
                                    str = SnsTimeLineUI.this.getString(R.string.h_s);
                                } else {
                                    str = "";
                                }
                                inflate.setOnClickListener(new View.OnClickListener() {
                                    /* class com.tencent.mm.plugin.sns.ui.SnsTimeLineUI.AnonymousClass69.AnonymousClass1 */

                                    public final void onClick(View view) {
                                        AppMethodBeat.i(203720);
                                        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                                        bVar.bm(view);
                                        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsTimeLineUI$72$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                                        Log.d("MicroMsg.SnsTimeLineUI", "collapse tips click");
                                        Intent intent = new Intent(SnsTimeLineUI.this, SnsCommentDetailUI.class);
                                        intent.putExtra("INTENT_TALKER", JJ.getUserName());
                                        intent.putExtra("INTENT_SNS_LOCAL_ID", JJ.localid);
                                        intent.putExtra("INTENT_FROMGALLERY", false);
                                        intent.putExtra("intent_show_collapse_info", true);
                                        intent.putExtra("intent_content_collapse_hint", str);
                                        SnsTimeLineUI snsTimeLineUI = SnsTimeLineUI.this;
                                        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                                        com.tencent.mm.hellhoundlib.a.a.a(snsTimeLineUI, bl.axQ(), "com/tencent/mm/plugin/sns/ui/SnsTimeLineUI$72$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                                        snsTimeLineUI.startActivity((Intent) bl.pG(0));
                                        com.tencent.mm.hellhoundlib.a.a.a(snsTimeLineUI, "com/tencent/mm/plugin/sns/ui/SnsTimeLineUI$72$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                                        com.tencent.mm.plugin.sns.storage.g.JH(j2);
                                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsTimeLineUI$72$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                                        AppMethodBeat.o(203720);
                                    }
                                });
                                AppMethodBeat.o(203721);
                            }
                        });
                    }
                    AppMethodBeat.o(203738);
                }

                /* JADX WARNING: Code restructure failed: missing block: B:30:0x01c2, code lost:
                    if (r0 == false) goto L_0x01c4;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:34:0x01d4, code lost:
                    if (((com.tencent.mm.plugin.i.a.aj) com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.i.a.aj.class)).showPostEntry() != false) goto L_0x01d6;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:35:0x01d6, code lost:
                    r3 = new com.tencent.mm.ui.base.n(r13, 6, 0);
                    r0 = com.tencent.mm.R.string.bpz;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:36:0x01e1, code lost:
                    if (r13.ELt != 1) goto L_0x01e6;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:37:0x01e3, code lost:
                    r0 = com.tencent.mm.R.string.bpw;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:38:0x01e6, code lost:
                    r3.setTitle(r13.getString(r0));
                    r2.add(r3);
                    r13.ELy = 1;
                    r13.EMl = com.tencent.mm.model.cl.aWz();
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:39:0x01fa, code lost:
                    if (r13.ELt != 2) goto L_0x0227;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:40:0x01fc, code lost:
                    com.tencent.mm.kernel.g.aAh().azQ().set(com.tencent.mm.storage.ar.a.USERINFO_SNS_JUMP_FINDER_POST_EXPOSE_COUNT_INT_SYNC, java.lang.Integer.valueOf(((java.lang.Integer) com.tencent.mm.kernel.g.aAh().azQ().get(com.tencent.mm.storage.ar.a.USERINFO_SNS_JUMP_FINDER_POST_EXPOSE_COUNT_INT_SYNC, (java.lang.Object) 0)).intValue() + 1));
                 */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                static /* synthetic */ void L(com.tencent.mm.plugin.sns.ui.SnsTimeLineUI r13) {
                    /*
                    // Method dump skipped, instructions count: 764
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.sns.ui.SnsTimeLineUI.L(com.tencent.mm.plugin.sns.ui.SnsTimeLineUI):void");
                }

                static /* synthetic */ boolean aZ(Intent intent) {
                    boolean z = false;
                    AppMethodBeat.i(203741);
                    if (intent != null && intent.getIntExtra("Ksnsupload_type", 0) == 9) {
                        z = true;
                    }
                    AppMethodBeat.o(203741);
                    return z;
                }

                static /* synthetic */ void M(SnsTimeLineUI snsTimeLineUI) {
                    BaseTimeLineItem.BaseViewHolder baseViewHolder;
                    AppMethodBeat.i(99422);
                    try {
                        int headerViewsCount = snsTimeLineUI.mUIAction.list.getHeaderViewsCount();
                        Log.i("MicroMsg.SnsTimeLineUI.ScreenShot", "getHeaderViewsCount: ".concat(String.valueOf(headerViewsCount)));
                        int firstVisiblePosition = snsTimeLineUI.mUIAction.list.getFirstVisiblePosition();
                        int lastVisiblePosition = snsTimeLineUI.mUIAction.list.getLastVisiblePosition();
                        Log.i("MicroMsg.SnsTimeLineUI.ScreenShot", "firstVisiblePosition = " + firstVisiblePosition + ", lastVisiblePosition = " + lastVisiblePosition);
                        for (int i2 = firstVisiblePosition; i2 <= lastVisiblePosition; i2++) {
                            View childAt = snsTimeLineUI.mUIAction.list.getChildAt(i2 - firstVisiblePosition);
                            if (!(childAt == null || childAt.getTag() == null || !(childAt.getTag() instanceof BaseTimeLineItem.BaseViewHolder) || (baseViewHolder = (BaseTimeLineItem.BaseViewHolder) childAt.getTag()) == null)) {
                                Log.i("MicroMsg.SnsTimeLineUI.ScreenShot", "In ListView, current visible position = " + i2 + ", nickNameTv = " + baseViewHolder.EWx.getText().toString() + ", descCollapTv = " + baseViewHolder.EWA.getContent());
                                if (baseViewHolder.isAd && snsTimeLineUI.fA(childAt)) {
                                    Log.i("MicroMsg.SnsTimeLineUI.ScreenShot", "Use eyes, real current visible position = " + i2 + ", nickNameTv = " + baseViewHolder.EWx.getText().toString() + ", descCollapTv = " + baseViewHolder.EWA.getContent());
                                    SnsInfo Zv = snsTimeLineUI.EKZ.DQX.Zv(i2 - headerViewsCount);
                                    if (Zv != null) {
                                        String nullAsNil = Util.nullAsNil(Zv.getAdInfo().uxInfo);
                                        Log.i("MicroMsg.SnsTimeLineUI.ScreenShot", "uxInfo = ".concat(String.valueOf(nullAsNil)));
                                        String aH = com.tencent.mm.plugin.sns.a.b.aH("1", nullAsNil, "");
                                        Log.i("MicroMsg.SnsTimeLineUI.ScreenShot", "reportScreenShotParams = ".concat(String.valueOf(aH)));
                                        com.tencent.mm.plugin.report.service.h.INSTANCE.kvStat(19213, aH);
                                    }
                                }
                            }
                        }
                        AppMethodBeat.o(99422);
                    } catch (Throwable th) {
                        Log.e("MicroMsg.SnsTimeLineUI.ScreenShot", th.toString());
                        AppMethodBeat.o(99422);
                    }
                }

                static /* synthetic */ void Q(SnsTimeLineUI snsTimeLineUI) {
                    AppMethodBeat.i(203742);
                    if (snsTimeLineUI.ELd <= 3) {
                        int firstVisiblePosition = snsTimeLineUI.mUIAction.list.getFirstVisiblePosition();
                        if (System.currentTimeMillis() - snsTimeLineUI.ELY > 1000 || firstVisiblePosition > snsTimeLineUI.wAr) {
                            snsTimeLineUI.ELY = 0;
                            snsTimeLineUI.wAr = snsTimeLineUI.mUIAction.list.getFirstVisiblePosition();
                        }
                        snsTimeLineUI.ELY = System.currentTimeMillis();
                        if (snsTimeLineUI.wAr - firstVisiblePosition >= 10 && firstVisiblePosition > 10) {
                            Log.i("MicroMsg.SnsTimeLineUI", "showTopTip %d", Integer.valueOf(snsTimeLineUI.ELd));
                            if (snsTimeLineUI.ELd <= 3 && !snsTimeLineUI.isSingleTitleView()) {
                                snsTimeLineUI.setMMSingleTitle(snsTimeLineUI.getString(R.string.h5c), AnimationUtils.loadAnimation(snsTimeLineUI.getContext(), R.anim.dn));
                                snsTimeLineUI.removeAllOptionMenu();
                                snsTimeLineUI.removeOptionMenu(16908332);
                                snsTimeLineUI.setTitleBarDoubleClickListener(new Runnable() {
                                    /* class com.tencent.mm.plugin.sns.ui.SnsTimeLineUI.AnonymousClass53 */

                                    public final void run() {
                                        AppMethodBeat.i(203710);
                                        SnsTimeLineUI.S(SnsTimeLineUI.this);
                                        AppMethodBeat.o(203710);
                                    }
                                });
                                snsTimeLineUI.ELd++;
                                aj.dRd().removeCallbacks(snsTimeLineUI.EMd);
                                aj.dRd().postDelayed(snsTimeLineUI.EMd, 4000);
                            }
                        }
                    }
                    AppMethodBeat.o(203742);
                }

                static /* synthetic */ boolean R(SnsTimeLineUI snsTimeLineUI) {
                    AppMethodBeat.i(203743);
                    boolean z = false;
                    if (!(snsTimeLineUI.mUIAction == null || snsTimeLineUI.mUIAction.zog == null || snsTimeLineUI.mUIAction.zog.getScrollY() >= 0)) {
                        z = true;
                    }
                    AppMethodBeat.o(203743);
                    return z;
                }

                static /* synthetic */ void S(SnsTimeLineUI snsTimeLineUI) {
                    AppMethodBeat.i(99426);
                    Log.i("MicroMsg.SnsTimeLineUI", "double click, first visible:%s", Integer.valueOf(snsTimeLineUI.mUIAction.list.getFirstVisiblePosition()));
                    if (snsTimeLineUI.mUIAction.EvK) {
                        Log.i("MicroMsg.SnsTimeLineUI", "double click, in pullDownMode");
                        aj.faS().kJ("@__weixintimtline", "");
                        snsTimeLineUI.mUIAction.vz(false);
                        if (snsTimeLineUI.EKZ != null) {
                            snsTimeLineUI.EMc.removeCallbacks(snsTimeLineUI.ELC);
                            snsTimeLineUI.EMc.postDelayed(snsTimeLineUI.ELC, 3000);
                        }
                    }
                    com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(snsTimeLineUI.mUIAction.list);
                    Object obj = new Object();
                    com.tencent.mm.hellhoundlib.a.a.a(obj, bl.axQ(), "com/tencent/mm/plugin/sns/ui/SnsTimeLineUI", "doubleClick", "()V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
                    BackwardSupportUtil.SmoothScrollFactory.scrollToTop((ListView) bl.pG(0));
                    com.tencent.mm.hellhoundlib.a.a.a(obj, "com/tencent/mm/plugin/sns/ui/SnsTimeLineUI", "doubleClick", "()V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
                    snsTimeLineUI.ZR(0);
                    if (snsTimeLineUI.mUIAction.list.getFirstVisiblePosition() != 0) {
                        snsTimeLineUI.EMd.run();
                    }
                    snsTimeLineUI.EKZ.ffp();
                    snsTimeLineUI.ffL();
                    new MMHandler().postDelayed(new Runnable() {
                        /* class com.tencent.mm.plugin.sns.ui.SnsTimeLineUI.AnonymousClass67 */

                        public final void run() {
                            AppMethodBeat.i(203718);
                            SnsTimeLineUI.this.mUIAction.list.setSelection(0);
                            a aVar = SnsTimeLineUI.this.ELb;
                            if (aVar.EMV) {
                                if (SnsTimeLineUI.ELX.booleanValue()) {
                                    Log.i("MicroMsg.SnsTimeLineUI", "force init %s %s %s", Boolean.valueOf(aVar.EMV), Float.valueOf(aVar.EMY), Integer.valueOf(aVar.EMW));
                                }
                                AbsoluteLayout.LayoutParams layoutParams = (AbsoluteLayout.LayoutParams) SnsTimeLineUI.this.EKW.getLayoutParams();
                                layoutParams.y = aVar.EMW;
                                SnsTimeLineUI.this.EKW.setLayoutParams(layoutParams);
                                aVar.EML = aVar.EMX;
                                aVar.EMP = aVar.EMY;
                            }
                            SnsTimeLineUI.this.ELb.fjs();
                            com.tencent.mm.plugin.sns.ui.a.a.c cVar = SnsTimeLineUI.this.EKS;
                            SnsUIAction.a unused = SnsTimeLineUI.this.EMe;
                            cVar.d(SnsTimeLineUI.this.mRa, SnsTimeLineUI.this.ELk, SnsTimeLineUI.this.EqY, SnsTimeLineUI.this.ELl);
                            aj.dRd().removeCallbacks(SnsTimeLineUI.this.EMd);
                            com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.USERINFO_UPDATE_SNS_TIMELINE_SCENE_INT, (Object) 2);
                            AppMethodBeat.o(203718);
                        }
                    }, 300);
                    AppMethodBeat.o(99426);
                }

                static /* synthetic */ void ab(SnsTimeLineUI snsTimeLineUI) {
                    AppMethodBeat.i(179309);
                    final b bVar = new b(snsTimeLineUI, (byte) 0);
                    if (aq.gQ(snsTimeLineUI)) {
                        bVar.ENb = R.string.v_;
                        bVar.type = 2;
                        snsTimeLineUI.ELp.ZU(1);
                    } else {
                        bVar.ENb = R.string.v9;
                        bVar.type = 0;
                        snsTimeLineUI.ELp.ZU(2);
                    }
                    a(snsTimeLineUI.ELp);
                    com.tencent.mm.ui.base.h.a(snsTimeLineUI, bVar.ENb, (int) R.string.zb, (int) R.string.x_, (int) R.string.sz, new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.plugin.sns.ui.SnsTimeLineUI.AnonymousClass63 */

                        /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            AppMethodBeat.i(99354);
                            SnsTimeLineUI.this.ELp.ZV(1);
                            SnsTimeLineUI.b(SnsTimeLineUI.this.ELp);
                            switch (bVar.type) {
                                case 0:
                                    SnsTimeLineUI.af(SnsTimeLineUI.this);
                                    break;
                                case 2:
                                    SnsTimeLineUI.ae(SnsTimeLineUI.this);
                                    AppMethodBeat.o(99354);
                                    return;
                            }
                            AppMethodBeat.o(99354);
                        }
                    }, new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.plugin.sns.ui.SnsTimeLineUI.AnonymousClass64 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            AppMethodBeat.i(99355);
                            if (SnsTimeLineUI.this.ELp.scene != 3) {
                                if (i2 == 0) {
                                    SnsTimeLineUI.this.ELp.ZV(3);
                                } else {
                                    SnsTimeLineUI.this.ELp.ZV(2);
                                }
                                SnsTimeLineUI.b(SnsTimeLineUI.this.ELp);
                            }
                            AppMethodBeat.o(99355);
                        }
                    });
                    AppMethodBeat.o(179309);
                }

                static /* synthetic */ void ad(SnsTimeLineUI snsTimeLineUI) {
                    AppMethodBeat.i(203747);
                    com.tencent.mm.plugin.recordvideo.e.a aVar = com.tencent.mm.plugin.recordvideo.e.a.ChV;
                    final boolean G = com.tencent.mm.plugin.recordvideo.e.a.G(snsTimeLineUI, "com.tencent.phoenix", "A24DC0755072F64C480DC06DCD3412BF");
                    com.tencent.mm.ui.base.h.a(snsTimeLineUI, G ? R.string.uu : R.string.ut, (int) R.string.zb, (int) R.string.x_, (int) R.string.sz, new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.plugin.sns.ui.SnsTimeLineUI.AnonymousClass61 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            AppMethodBeat.i(99352);
                            if (G) {
                                com.tencent.mm.plugin.recordvideo.e.h hVar = com.tencent.mm.plugin.recordvideo.e.h.Cix;
                                com.tencent.mm.plugin.recordvideo.e.g gVar = com.tencent.mm.plugin.recordvideo.e.g.Ciw;
                                Intent fm = com.tencent.mm.plugin.recordvideo.e.h.fm("moments", com.tencent.mm.plugin.recordvideo.e.g.eMQ());
                                com.tencent.mm.plugin.recordvideo.e.h hVar2 = com.tencent.mm.plugin.recordvideo.e.h.Cix;
                                com.tencent.mm.plugin.recordvideo.e.h.ao(SnsTimeLineUI.this, fm);
                                AppMethodBeat.o(99352);
                                return;
                            }
                            com.tencent.mm.plugin.recordvideo.e.a aVar = com.tencent.mm.plugin.recordvideo.e.a.ChV;
                            SnsTimeLineUI snsTimeLineUI = SnsTimeLineUI.this;
                            StringBuilder sb = new StringBuilder();
                            com.tencent.mm.plugin.recordvideo.e.g gVar2 = com.tencent.mm.plugin.recordvideo.e.g.Ciw;
                            com.tencent.mm.plugin.recordvideo.e.a.bt(snsTimeLineUI, sb.append(com.tencent.mm.plugin.recordvideo.e.g.eMR()).append("moments0").toString());
                            AppMethodBeat.o(99352);
                        }
                    }, new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.plugin.sns.ui.SnsTimeLineUI.AnonymousClass62 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            AppMethodBeat.i(99353);
                            AppMethodBeat.o(99353);
                        }
                    });
                    AppMethodBeat.o(203747);
                }

                static /* synthetic */ void ae(SnsTimeLineUI snsTimeLineUI) {
                    AppMethodBeat.i(203748);
                    if (!com.tencent.mm.q.a.cA(snsTimeLineUI) && !com.tencent.mm.q.a.cE(snsTimeLineUI)) {
                        long aWz = cl.aWz();
                        String eZx = r.eZx();
                        Log.i("MicroMsg.SnsTimeLineUI", "doCpatureMMSight sessionID:%s", eZx);
                        com.tencent.mm.plugin.report.service.h.INSTANCE.a(13822, 1, 2, eZx, Long.valueOf(aWz));
                        com.tencent.mm.pluginsdk.ui.tools.s.f(snsTimeLineUI.getContext(), new Intent(), eZx);
                    }
                    AppMethodBeat.o(203748);
                }

                static /* synthetic */ void af(SnsTimeLineUI snsTimeLineUI) {
                    AppMethodBeat.i(203749);
                    Intent intent = new Intent();
                    intent.putExtra("rawUrl", "https://mobile.qzone.qq.com/l?g=4991");
                    com.tencent.mm.br.c.b(snsTimeLineUI, "webview", ".ui.tools.WebViewUI", intent);
                    AppMethodBeat.o(203749);
                }
            }

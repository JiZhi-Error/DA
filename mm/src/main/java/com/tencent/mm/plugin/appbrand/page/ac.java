package com.tencent.mm.plugin.appbrand.page;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.ac.g;
import com.tencent.mm.plugin.appbrand.ac.m;
import com.tencent.mm.plugin.appbrand.config.b;
import com.tencent.mm.plugin.appbrand.h;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.h;
import com.tencent.mm.plugin.appbrand.jsapi.i;
import com.tencent.mm.plugin.appbrand.jsapi.j;
import com.tencent.mm.plugin.appbrand.menu.t;
import com.tencent.mm.plugin.appbrand.page.capsulebar.e;
import com.tencent.mm.plugin.appbrand.page.w;
import com.tencent.mm.plugin.appbrand.platform.window.a.o;
import com.tencent.mm.plugin.appbrand.platform.window.c;
import com.tencent.mm.plugin.appbrand.platform.window.d;
import com.tencent.mm.plugin.appbrand.platform.window.e;
import com.tencent.mm.plugin.appbrand.s;
import com.tencent.mm.plugin.appbrand.widget.actionbar.b;
import com.tencent.mm.plugin.appbrand.widget.actionbar.d;
import com.tencent.mm.plugin.appbrand.widget.actionbar.e;
import com.tencent.mm.plugin.appbrand.widget.dialog.l;
import com.tencent.mm.plugin.appbrand.widget.input.ad;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.system.AndroidContextUtil;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;
import junit.framework.Assert;
import kotlin.g.b.p;

@SuppressLint({"ViewConstructor"})
public class ac extends d implements h {
    private static final int nqH = R.id.nb;
    public volatile boolean cwV;
    private volatile boolean gc;
    private volatile boolean kDZ;
    public c kEb;
    private volatile AppBrandRuntime kEc;
    private List<t> kHj;
    public String lBI;
    private ViewGroup lja;
    private Context mContext;
    public bb nmX;
    public String nna;
    public FrameLayout noq;
    bw npk;
    private final int nqI;
    private ae nqJ;
    private final Class<? extends ae> nqK;
    protected d nqL;
    protected b nqM;
    public ao nqN;
    public bf nqO;
    private com.tencent.mm.plugin.appbrand.n.a nqP;
    protected b nqQ;
    public e.a nqR;
    private com.tencent.mm.plugin.appbrand.platform.window.d nqS;
    public final com.tencent.mm.plugin.appbrand.widget.f.b nqT;
    public t nqU;
    private an nqV;
    boolean nqW;
    private final l nqX;
    private String nqY;
    protected boolean nqZ;
    private final Object nra;
    private int[] nrb;
    private int[] nrc;
    private final AtomicBoolean nrd;
    private boolean nre;

    public final boolean Pv() {
        return this.cwV;
    }

    protected ac(Class<? extends ae> cls) {
        AppMethodBeat.i(135144);
        this.nqI = R.id.na;
        this.gc = false;
        this.kDZ = false;
        this.cwV = false;
        this.nqR = null;
        this.nqT = new com.tencent.mm.plugin.appbrand.widget.f.b(this);
        this.npk = null;
        this.kEb = new o();
        this.nqW = false;
        this.nqX = new l() {
            /* class com.tencent.mm.plugin.appbrand.page.ac.AnonymousClass1 */

            @Override // com.tencent.mm.plugin.appbrand.widget.dialog.l
            public final void h(Boolean bool) {
                AppMethodBeat.i(176625);
                if (bool.booleanValue()) {
                    ac.this.hh(false);
                    AppMethodBeat.o(176625);
                    return;
                }
                ac.this.hh(true);
                AppMethodBeat.o(176625);
            }
        };
        this.nqZ = false;
        this.nra = new byte[0];
        this.nrb = new int[0];
        this.nrc = new int[0];
        this.nrd = new AtomicBoolean(false);
        this.nre = false;
        this.nqK = cls;
        AppMethodBeat.o(135144);
    }

    public ac() {
        this(null);
    }

    public void b(c cVar) {
        AppMethodBeat.i(176631);
        this.kEb = cVar;
        if (!(this.kEb == null || this.nqS == null)) {
            this.nqS.btC();
            this.nqS = null;
            getFullscreenImpl();
        }
        AppMethodBeat.o(176631);
    }

    @Override // com.tencent.mm.plugin.appbrand.d
    public final c getWindowAndroid() {
        return this.kEb;
    }

    /* access modifiers changed from: protected */
    public final ae bRb() {
        AppMethodBeat.i(135145);
        if (this.nqK == null) {
            AppMethodBeat.o(135145);
            return null;
        } else if (this.nqJ != null) {
            ae aeVar = this.nqJ;
            AppMethodBeat.o(135145);
            return aeVar;
        } else {
            ae aeVar2 = (ae) org.a.a.bF(this.nqK).ak(this).object;
            this.nqJ = aeVar2;
            AppMethodBeat.o(135145);
            return aeVar2;
        }
    }

    public void a(Context context, AppBrandRuntime appBrandRuntime) {
        AppMethodBeat.i(135146);
        this.mContext = context;
        this.kEc = appBrandRuntime;
        this.gc = true;
        this.nqQ = bRG();
        b(appBrandRuntime.getWindowAndroid());
        f(appBrandRuntime.kAA);
        super.init();
        if (bRb() != null) {
            final Context context2 = getRuntime().mContext;
            final View view = (View) com.tencent.luggage.sdk.g.c.a("AppBrandPageViewProfile| onCreateView", new kotlin.g.a.a<View>() {
                /* class com.tencent.mm.plugin.appbrand.page.ac.AnonymousClass12 */

                /* Return type fixed from 'java.lang.Object' to match base method */
                @Override // kotlin.g.a.a
                public final /* synthetic */ View invoke() {
                    AppMethodBeat.i(176630);
                    View a2 = ac.this.bRb().a(LayoutInflater.from(context2));
                    AppMethodBeat.o(176630);
                    return a2;
                }
            });
            com.tencent.luggage.sdk.g.c.a("AppBrandPageViewProfile| onViewCreated", new Runnable() {
                /* class com.tencent.mm.plugin.appbrand.page.ac.AnonymousClass18 */

                public final void run() {
                    AppMethodBeat.i(135134);
                    ac.this.lja = new a(context2);
                    View j2 = ac.this.j(ac.this.lja);
                    RelativeLayout.LayoutParams cc = ac.this.bRb().cc(j2);
                    if (j2 != null) {
                        ac.this.lja.addView(view, ac.this.lja.getChildCount() - 1, cc);
                    } else {
                        ac.this.lja.addView(view, cc);
                    }
                    ac.this.bRb().cb(view);
                    AppMethodBeat.o(135134);
                }
            });
            com.tencent.luggage.sdk.g.c.a("AppBrandPageViewProfile| initActionBar", new Runnable() {
                /* class com.tencent.mm.plugin.appbrand.page.ac.AnonymousClass19 */

                public final void run() {
                    AppMethodBeat.i(135135);
                    ac.o(ac.this);
                    ac.this.nqL.aG(ac.this.getContext());
                    ac.this.lja.addView(ac.this.nqL, -1, new ViewGroup.LayoutParams(-1, -2));
                    ac.this.bRb().b(ac.this.nqM);
                    if (ac.this.nqM.getParent() != ac.this.nqL) {
                        IllegalAccessError illegalAccessError = new IllegalAccessError("You should not modify actionbar's view hierarchy");
                        AppMethodBeat.o(135135);
                        throw illegalAccessError;
                    }
                    AppMethodBeat.o(135135);
                }
            });
            this.noq = (FrameLayout) view;
            this.nqO = bRb().Nc();
            this.nqN = bRb().getCustomViewContainer();
        }
        com.tencent.mm.plugin.appbrand.page.capsulebar.e eVar = appBrandRuntime.kAx;
        p.h(this, "page");
        eVar.nvm.a(this, new e.a(eVar, this));
        Log.i("MicroMsg.AppBrandPageView", "AppBrandPageViewProfile| dispatchStart");
        if (bRb() != null) {
            bRb().dispatchStart();
        }
        AppMethodBeat.o(135146);
    }

    public final void a(Map<String, Object> map, bx bxVar) {
        AppMethodBeat.i(135147);
        if (this.nqZ) {
            map.put("notFound", Boolean.TRUE);
        }
        if (bx.REWRITE_ROUTE == bxVar) {
            map.put("originalWebviewId", Integer.valueOf(bRn()));
        }
        ae bRb = bRb();
        if (bRb != null) {
            bRb.a(map, bxVar);
        }
        AppMethodBeat.o(135147);
    }

    /* access modifiers changed from: protected */
    public void aG(Context context) {
        AppMethodBeat.i(135148);
        this.mContext = context;
        if (this.nqL != null) {
            this.nqL.aG(context);
        }
        AppMethodBeat.o(135148);
    }

    public final t bRc() {
        return this.nqU;
    }

    public final void YU() {
        AppMethodBeat.i(135149);
        bEb();
        bRA();
        AppMethodBeat.o(135149);
    }

    public final com.tencent.mm.plugin.appbrand.widget.f.b bRd() {
        return this.nqT;
    }

    final class a extends RelativeLayout implements bz {
        public a(Context context) {
            super(context);
        }

        @Override // com.tencent.mm.plugin.appbrand.page.bz
        public final boolean c(Canvas canvas) {
            AppMethodBeat.i(135142);
            Bitmap bRB = ac.this.bRB();
            if (bRB != null) {
                canvas.drawBitmap(bRB, 0.0f, (float) ac.this.noq.getTop(), (Paint) null);
            }
            if (ac.this.nqM != null && !ac.this.nqM.isFullscreenMode()) {
                ac.this.nqL.draw(canvas);
            }
            AppMethodBeat.o(135142);
            return true;
        }

        public final void setBackgroundColor(int i2) {
            AppMethodBeat.i(178578);
            super.setBackgroundColor(i2);
            AppMethodBeat.o(178578);
        }

        public final boolean post(Runnable runnable) {
            AppMethodBeat.i(219436);
            if (runnable == null) {
                AppMethodBeat.o(219436);
                return false;
            } else if (ac.this.f(this, runnable)) {
                AppMethodBeat.o(219436);
                return true;
            } else {
                boolean post = super.post(runnable);
                AppMethodBeat.o(219436);
                return post;
            }
        }

        public final boolean postDelayed(Runnable runnable, long j2) {
            AppMethodBeat.i(219437);
            if (runnable == null) {
                AppMethodBeat.o(219437);
                return false;
            } else if (ac.this.b(this, runnable, j2)) {
                AppMethodBeat.o(219437);
                return true;
            } else {
                boolean postDelayed = super.postDelayed(runnable, j2);
                AppMethodBeat.o(219437);
                return postDelayed;
            }
        }
    }

    /* access modifiers changed from: protected */
    public boolean f(View view, Runnable runnable) {
        return false;
    }

    /* access modifiers changed from: protected */
    public boolean b(View view, Runnable runnable, long j2) {
        return false;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.f
    public final Map<String, com.tencent.mm.plugin.appbrand.jsapi.p> Op() {
        AppMethodBeat.i(135151);
        if (bRb() != null) {
            Map<String, com.tencent.mm.plugin.appbrand.jsapi.p> Nf = bRb().Nf();
            AppMethodBeat.o(135151);
            return Nf;
        }
        AppMethodBeat.o(135151);
        return null;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.k
    public AppBrandRuntime getRuntime() {
        return this.kEc;
    }

    public s NY() {
        AppMethodBeat.i(135152);
        if (getRuntime() == null) {
            AppMethodBeat.o(135152);
            return null;
        }
        s NY = getRuntime().NY();
        AppMethodBeat.o(135152);
        return NY;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.h, com.tencent.mm.plugin.appbrand.page.d
    public final View getContentView() {
        return this.lja;
    }

    public final ad bRf() {
        AppMethodBeat.i(135154);
        if (getContext() instanceof ad) {
            ad adVar = (ad) getContext();
            AppMethodBeat.o(135154);
            return adVar;
        }
        AppMethodBeat.o(135154);
        return null;
    }

    /* access modifiers changed from: protected */
    public void bP(List<t> list) {
        AppMethodBeat.i(135156);
        new u(this, new LinkedList(bRh()), false).btY();
        AppMethodBeat.o(135156);
    }

    /* access modifiers changed from: protected */
    public View j(ViewGroup viewGroup) {
        return null;
    }

    public List<t> bRg() {
        AppMethodBeat.i(135157);
        List<t> emptyList = Collections.emptyList();
        AppMethodBeat.o(135157);
        return emptyList;
    }

    public final List<t> bRh() {
        AppMethodBeat.i(135158);
        if (this.kHj == null) {
            this.kHj = bRg();
        }
        List<t> list = this.kHj;
        AppMethodBeat.o(135158);
        return list;
    }

    public final com.tencent.mm.plugin.appbrand.platform.window.d getFullscreenImpl() {
        AppMethodBeat.i(176632);
        if (this.nqS != null) {
            com.tencent.mm.plugin.appbrand.platform.window.d dVar = this.nqS;
            AppMethodBeat.o(176632);
            return dVar;
        } else if (this.kEb == null) {
            Log.w("MicroMsg.AppBrandPageView", "getFullscreenImpl NULL windowAndroid, appId[%s] url[%s]", getAppId(), this.lBI);
            AppMethodBeat.o(176632);
            return null;
        } else {
            this.nqS = this.kEb.a(new d.b() {
                /* class com.tencent.mm.plugin.appbrand.page.ac.AnonymousClass2 */

                @Override // com.tencent.mm.plugin.appbrand.platform.window.d.b
                public final ViewGroup cB(View view) {
                    AppMethodBeat.i(219430);
                    ViewGroup bRX = ac.this.nqN.bRX();
                    AppMethodBeat.o(219430);
                    return bRX;
                }
            });
            this.nqS.a(new com.tencent.mm.plugin.appbrand.platform.window.b() {
                /* class com.tencent.mm.plugin.appbrand.page.ac.AnonymousClass3 */

                @Override // com.tencent.mm.plugin.appbrand.platform.window.b
                public final void Na() {
                    AppMethodBeat.i(219431);
                    ac.this.bDo();
                    AppMethodBeat.o(219431);
                }
            });
            com.tencent.mm.plugin.appbrand.platform.window.d dVar2 = this.nqS;
            AppMethodBeat.o(176632);
            return dVar2;
        }
    }

    /* access modifiers changed from: package-private */
    public final void yJ(int i2) {
        AppMethodBeat.i(135160);
        if (this.nre) {
            AppMethodBeat.o(135160);
            return;
        }
        if (this.nqL.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.nqL.getLayoutParams();
            if (marginLayoutParams.bottomMargin != i2) {
                marginLayoutParams.bottomMargin = i2;
                this.nqL.setLayoutParams(marginLayoutParams);
            }
        }
        AppMethodBeat.o(135160);
    }

    public final b bRi() {
        return this.nqM;
    }

    public final com.tencent.mm.plugin.appbrand.widget.actionbar.d bRj() {
        return this.nqL;
    }

    public final bb bRk() {
        return this.nmX;
    }

    public final b.d getPageConfig() {
        AppMethodBeat.i(135161);
        if (!isRunning()) {
            AppMethodBeat.o(135161);
            return null;
        }
        b.d WV = getRuntime().getAppConfig().WV(this.lBI);
        AppMethodBeat.o(135161);
        return WV;
    }

    public final String bRl() {
        return this.nqY;
    }

    public final String getURL() {
        return this.lBI;
    }

    public final String bRm() {
        return this.nna;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.f, com.tencent.mm.plugin.appbrand.jsapi.g
    public final int getComponentId() {
        int i2;
        AppMethodBeat.i(219439);
        synchronized (this.nra) {
            try {
                if (this.nrc == null || this.nrc.length <= 0) {
                    this.nrc = new int[]{Objects.hash(Integer.valueOf(super.hashCode()), Long.valueOf(System.currentTimeMillis()))};
                    if (this.nrb == null || this.nrb.length <= 0) {
                        this.nrb = new int[]{this.nrc[0]};
                    }
                }
                i2 = this.nrc[0];
            } finally {
                AppMethodBeat.o(219439);
            }
        }
        return i2;
    }

    private int bRn() {
        int i2;
        AppMethodBeat.i(219440);
        synchronized (this.nra) {
            try {
                getComponentId();
                i2 = this.nrb[0];
            } finally {
                AppMethodBeat.o(219440);
            }
        }
        return i2;
    }

    public boolean dE(String str) {
        AppMethodBeat.i(135162);
        if (this.nqY == null) {
            this.nqY = Util.nullAsNil(str);
        }
        this.lBI = com.tencent.luggage.h.l.dM(str);
        this.nna = str;
        this.nmX.setXWebKeyboardImpl(new au() {
            /* class com.tencent.mm.plugin.appbrand.page.ac.AnonymousClass4 */

            @Override // com.tencent.mm.plugin.appbrand.page.au
            public final h bRH() {
                return ac.this;
            }

            @Override // com.tencent.mm.plugin.appbrand.page.au
            public final f bxr() {
                AppMethodBeat.i(219432);
                s NY = ac.this.NY();
                AppMethodBeat.o(219432);
                return NY;
            }
        });
        if (bRb() != null) {
            boolean dy = bRb().dy(str);
            AppMethodBeat.o(135162);
            return dy;
        }
        bOF();
        if (!bqY().UW(this.lBI)) {
            dF(str);
            adM("onPageScriptNotFound");
            AppMethodBeat.o(135162);
            return false;
        }
        AppMethodBeat.o(135162);
        return true;
    }

    public void bOF() {
        boolean z;
        com.tencent.mm.plugin.appbrand.page.a.f fVar;
        com.tencent.mm.plugin.appbrand.page.a.f fVar2;
        AppMethodBeat.i(135163);
        b.d dVar = (b.d) Objects.requireNonNull(getPageConfig());
        YO(dVar.lcl);
        dVar.getClass();
        s(1.0d);
        wz(a(dVar));
        final String str = dVar.lck;
        P(new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.page.ac.AnonymousClass11 */

            public final void run() {
                AppMethodBeat.i(135124);
                if (ac.this.bRi() == null) {
                    AppMethodBeat.o(135124);
                    return;
                }
                ac.this.bRi().setForegroundStyle(str);
                ac.this.YP(str);
                AppMethodBeat.o(135124);
            }
        });
        ii(dVar.bzL());
        boolean z2 = dVar.lcy;
        if (!(bRb() == null || (fVar2 = (com.tencent.mm.plugin.appbrand.page.a.f) bRb().S(com.tencent.mm.plugin.appbrand.page.a.f.class)) == null)) {
            fVar2.ij(z2);
        }
        String str2 = dVar.lcA;
        String str3 = dVar.lco;
        if (!(bRb() == null || (fVar = (com.tencent.mm.plugin.appbrand.page.a.f) bRb().S(com.tencent.mm.plugin.appbrand.page.a.f.class)) == null)) {
            fVar.eE(str2, str3);
        }
        if (!dVar.lcw) {
            z = true;
        } else {
            z = false;
        }
        bV(z);
        if (this.nqW) {
            this.nqM.setNavHidden(true);
        }
        AppMethodBeat.o(135163);
    }

    private static int a(b.d dVar) {
        int cu;
        AppMethodBeat.i(135164);
        try {
            cu = g.afE(dVar.lci);
        } catch (Exception e2) {
            cu = g.cu(dVar.lco, -1);
        }
        AppMethodBeat.o(135164);
        return cu;
    }

    public final com.tencent.mm.plugin.appbrand.n.a bRo() {
        Context context;
        AppMethodBeat.i(219441);
        if (this.nqP != null) {
            Log.d("MicroMsg.AppBrandPageView", "return keyBoardComponentView(AppBrandKeyBoardComponentView)");
            com.tencent.mm.plugin.appbrand.n.a aVar = this.nqP;
            AppMethodBeat.o(219441);
            return aVar;
        }
        if (getRuntime() == null) {
            context = getContext();
        } else {
            context = getRuntime().mContext;
        }
        this.nqP = new com.tencent.mm.plugin.appbrand.n.a(context, this);
        Log.d("MicroMsg.AppBrandPageView", "make new keyBoardComponentView(AppBrandKeyBoardComponentView)");
        com.tencent.mm.plugin.appbrand.n.a aVar2 = this.nqP;
        AppMethodBeat.o(219441);
        return aVar2;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.f, com.tencent.mm.plugin.appbrand.jsapi.g
    public void b(String str, String str2, int[] iArr) {
        AppMethodBeat.i(135165);
        if (this.kEc == null || this.kEc.NY() == null) {
            Log.e("MicroMsg.AppBrandPageView", "publish runtime destroyed, event %s", str);
            AppMethodBeat.o(135165);
        } else if (bRb() == null || !bRb().y(str, str2)) {
            this.kEc.NY().c(str, str2, getComponentId());
            AppMethodBeat.o(135165);
        } else {
            AppMethodBeat.o(135165);
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.g
    public final void c(String str, String str2, int i2) {
        AppMethodBeat.i(135166);
        if (bRb() != null) {
            if (!bRb().b(str, str2, i2)) {
                super.c(str, str2, i2);
            }
            AppMethodBeat.o(135166);
            return;
        }
        super.c(str, str2, i2);
        AppMethodBeat.o(135166);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.f, com.tencent.mm.plugin.appbrand.d
    public final boolean isRunning() {
        AppMethodBeat.i(135167);
        if (!this.gc || !super.isRunning()) {
            AppMethodBeat.o(135167);
            return false;
        }
        AppMethodBeat.o(135167);
        return true;
    }

    public boolean isFullScreen() {
        return false;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.g
    public final void cleanup() {
        AppMethodBeat.i(135168);
        super.cleanup();
        NR();
        j jVar = this.nnC;
        jVar.lxE.clear();
        jVar.lxH.clear();
        jVar.lxF.clear();
        jVar.lxG.clear();
        jVar.lxI.clear();
        jVar.lxJ.clear();
        jVar.lxL.clear();
        jVar.lxK.clear();
        AppMethodBeat.o(135168);
    }

    /* access modifiers changed from: protected */
    public void NR() {
        AppMethodBeat.i(135169);
        this.nmX.destroy();
        if (this.nqN != null) {
            this.nqN.removeAll();
        }
        if (this.nqM != null) {
            this.nqM.destroy();
        }
        if (this.lja != null) {
            this.lja.removeAllViewsInLayout();
        }
        if (this.nqL != null) {
            this.nqL.setActuallyVisible(false);
            this.nqL.removeAllViewsInLayout();
        }
        if (this.noq != null) {
            this.noq.removeAllViewsInLayout();
        }
        this.nqT.ccK();
        if (getRuntime() != null) {
            getRuntime().jCK.b(this.nqX);
        }
        this.nmX = null;
        this.nqN = null;
        this.lja = null;
        this.nqL = null;
        this.noq = null;
        this.nqM = null;
        this.nqQ = null;
        if (this.nqP != null) {
            com.tencent.mm.plugin.appbrand.n.a aVar = this.nqP;
            Log.i("MicroMsg.AppBrandKeyBoardComponentView", "destroy view containers");
            Log.i("MicroMsg.AppBrandKeyBoardComponentView", "clear views");
            m.runOnUiThread(aVar.mOq);
            aVar.kGU = null;
            aVar.mOo = null;
            this.nqP = null;
        }
        AppMethodBeat.o(135169);
    }

    public final void bRp() {
        AppMethodBeat.i(135170);
        this.nqL.setActuallyVisible(true);
        AppMethodBeat.o(135170);
    }

    public final void adM(String str) {
        AppMethodBeat.i(219442);
        boolean andSet = this.nrd.getAndSet(true);
        Log.i("MicroMsg.AppBrandPageView", "onInitReady appId:%s, url:%s, reason:%s, called:%b", getAppId(), this.lBI, str, Boolean.valueOf(andSet));
        if (andSet) {
            AppMethodBeat.o(219442);
            return;
        }
        P(new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.page.ac.AnonymousClass5 */

            public final void run() {
                AppMethodBeat.i(219433);
                if (!ac.this.isRunning()) {
                    Log.e("MicroMsg.AppBrandPageView", "onInitReady but not running, return, appId[%s] url[%s]", ac.this.getAppId(), ac.this.lBI);
                    AppMethodBeat.o(219433);
                    return;
                }
                ac.this.getRuntime().jCK.a(ac.this.nqX);
                if (ac.this.bRb() != null) {
                    ac.this.bRb().Ng();
                }
                ac.this.bRq();
                for (i.f fVar : ac.this.nnC.lxE) {
                    fVar.onReady();
                }
                AppMethodBeat.o(219433);
            }
        });
        AppMethodBeat.o(219442);
    }

    /* access modifiers changed from: protected */
    public void bRq() {
    }

    public final void onForeground() {
        AppMethodBeat.i(135172);
        b(getRuntime().getWindowAndroid());
        this.cwV = true;
        if (bRb() != null) {
            bRb().Nd();
        }
        bRr();
        j jVar = this.nnC;
        for (i.d dVar : jVar.lxG) {
            dVar.onForeground();
        }
        jVar.hh(true);
        b.d dVar2 = (b.d) Objects.requireNonNull(getPageConfig());
        if (!(getActivity() == null || getActivity().getWindow() == null)) {
            if ("hidden".equals(dVar2.lcD)) {
                getActivity().getWindow().addFlags(8192);
                AppMethodBeat.o(135172);
                return;
            }
            getActivity().getWindow().clearFlags(8192);
        }
        AppMethodBeat.o(135172);
    }

    /* access modifiers changed from: protected */
    public void bRr() {
    }

    public final void onBackground() {
        AppMethodBeat.i(135173);
        this.cwV = false;
        if (bRb() != null) {
            bRb().Ne();
        }
        bRs();
        j jVar = this.nnC;
        for (i.b bVar : jVar.lxF) {
            bVar.onBackground();
        }
        jVar.hh(false);
        AppMethodBeat.o(135173);
    }

    /* access modifiers changed from: protected */
    public void bRs() {
    }

    public boolean onBackPressed() {
        AppMethodBeat.i(135174);
        if (this.nqS.btC()) {
            AppMethodBeat.o(135174);
            return true;
        }
        if (bRb() != null) {
            bRb();
        }
        boolean z = false;
        for (i.a aVar : this.nnC.lxI) {
            z = aVar.onBackPressed() ? true : z;
        }
        AppMethodBeat.o(135174);
        return z;
    }

    public final void onConfigurationChanged(Configuration configuration) {
        AppMethodBeat.i(135175);
        if (bRb() != null) {
            bRb().dispatchConfigurationChanged(configuration);
        }
        AppMethodBeat.o(135175);
    }

    public final void onDestroy() {
        AppMethodBeat.i(135176);
        bRt();
        if (bRb() != null) {
            bRb().dispatchDestroy();
        }
        for (i.c cVar : this.nnC.lxH) {
            cVar.onDestroy();
        }
        AppMethodBeat.o(135176);
    }

    /* access modifiers changed from: protected */
    public void bRt() {
        this.gc = false;
    }

    public final void bRu() {
        AppMethodBeat.i(135177);
        P(new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.page.ac.AnonymousClass6 */

            public final void run() {
                AppMethodBeat.i(219434);
                if (ac.this.bRi() == null) {
                    AppMethodBeat.o(219434);
                    return;
                }
                ac.this.ii(false);
                ac.this.bRi().setFullscreenMode(false);
                AppMethodBeat.o(219434);
            }
        });
        AppMethodBeat.o(135177);
    }

    public final void bRv() {
        AppMethodBeat.i(135178);
        P(new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.page.ac.AnonymousClass7 */

            public final void run() {
                AppMethodBeat.i(160933);
                if (ac.this.bRi() == null) {
                    AppMethodBeat.o(160933);
                    return;
                }
                ac.this.ii(true);
                ac.this.bRi().setFullscreenMode(true);
                AppMethodBeat.o(160933);
            }
        });
        AppMethodBeat.o(135178);
    }

    public final void s(final double d2) {
        AppMethodBeat.i(135179);
        P(new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.page.ac.AnonymousClass8 */

            public final void run() {
                AppMethodBeat.i(135121);
                if (ac.this.bRi() == null) {
                    AppMethodBeat.o(135121);
                    return;
                }
                ac.this.bRi().setBackgroundAlpha(d2);
                AppMethodBeat.o(135121);
            }
        });
        AppMethodBeat.o(135179);
    }

    public void wz(final int i2) {
        AppMethodBeat.i(135180);
        P(new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.page.ac.AnonymousClass9 */

            public final void run() {
                AppMethodBeat.i(135122);
                if (ac.this.bRi() == null) {
                    AppMethodBeat.o(135122);
                    return;
                }
                ac.this.bRi().setBackgroundColor(i2);
                AppMethodBeat.o(135122);
            }
        });
        AppMethodBeat.o(135180);
    }

    public void YO(final String str) {
        AppMethodBeat.i(135181);
        P(new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.page.ac.AnonymousClass10 */

            public final void run() {
                AppMethodBeat.i(135123);
                if (ac.this.bRi() == null) {
                    AppMethodBeat.o(135123);
                    return;
                }
                ac.this.bRi().setMainTitle(str);
                AppMethodBeat.o(135123);
            }
        });
        AppMethodBeat.o(135181);
    }

    public void wA(final int i2) {
        AppMethodBeat.i(135183);
        P(new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.page.ac.AnonymousClass13 */

            public final void run() {
                AppMethodBeat.i(135126);
                if (ac.this.bRi() == null) {
                    AppMethodBeat.o(135126);
                    return;
                }
                ac.this.bRi().setForegroundColor(i2);
                ac.this.YP(e.a.zP(i2).name());
                AppMethodBeat.o(135126);
            }
        });
        AppMethodBeat.o(135183);
    }

    public void he(final boolean z) {
        AppMethodBeat.i(135184);
        P(new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.page.ac.AnonymousClass14 */

            public final void run() {
                AppMethodBeat.i(135127);
                if (ac.this.bRi() == null) {
                    AppMethodBeat.o(135127);
                    return;
                }
                ac.this.bRi().setLoadingIconVisibility(z);
                AppMethodBeat.o(135127);
            }
        });
        AppMethodBeat.o(135184);
    }

    public void bV(final boolean z) {
        AppMethodBeat.i(135185);
        P(new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.page.ac.AnonymousClass15 */

            public final void run() {
                AppMethodBeat.i(135128);
                if (ac.this.bRi() == null) {
                    AppMethodBeat.o(135128);
                    return;
                }
                ac.this.bRi().gz(z);
                AppMethodBeat.o(135128);
            }
        });
        AppMethodBeat.o(135185);
    }

    public final void ii(boolean z) {
        AppMethodBeat.i(135186);
        this.nre = z;
        ViewGroup.LayoutParams layoutParams = this.nqL.getLayoutParams();
        ViewGroup.LayoutParams layoutParams2 = this.noq.getLayoutParams();
        if ((layoutParams instanceof RelativeLayout.LayoutParams) && (layoutParams2 instanceof RelativeLayout.LayoutParams)) {
            ((RelativeLayout.LayoutParams) layoutParams).addRule(10);
            if (z) {
                ((RelativeLayout.LayoutParams) layoutParams2).removeRule(3);
            } else {
                ((RelativeLayout.LayoutParams) layoutParams2).addRule(3, nqH);
            }
            this.lja.requestLayout();
            this.nqM.setFullscreenMode(this.nre);
            AppMethodBeat.o(135186);
        } else if (this.kAU) {
            IllegalStateException illegalStateException = new IllegalStateException("ActionBarContainer and Renderer's PageArea should be in RelativeLayout");
            AppMethodBeat.o(135186);
            throw illegalStateException;
        } else {
            AppMethodBeat.o(135186);
        }
    }

    public final void bRw() {
        AppMethodBeat.i(135187);
        if (bRb() != null) {
            com.tencent.mm.plugin.appbrand.page.a.f fVar = (com.tencent.mm.plugin.appbrand.page.a.f) bRb().S(com.tencent.mm.plugin.appbrand.page.a.f.class);
            if (fVar != null) {
                fVar.il(false);
            }
            AppMethodBeat.o(135187);
            return;
        }
        AppMethodBeat.o(135187);
    }

    public final void P(int i2, boolean z) {
        AppMethodBeat.i(135188);
        for (t tVar : bRh()) {
            if (tVar != null && tVar.id == i2) {
                tVar.neT = z;
                AppMethodBeat.o(135188);
                return;
            }
        }
        AppMethodBeat.o(135188);
    }

    public final t yK(int i2) {
        AppMethodBeat.i(135189);
        for (t tVar : bRh()) {
            if (tVar != null && tVar.id == i2) {
                AppMethodBeat.o(135189);
                return tVar;
            }
        }
        AppMethodBeat.o(135189);
        return null;
    }

    public void bDo() {
        AppMethodBeat.i(135190);
        runOnUiThread(new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.page.ac.AnonymousClass16 */

            public final void run() {
                AppMethodBeat.i(135129);
                if (ac.this.nqL == null) {
                    AppMethodBeat.o(135129);
                    return;
                }
                ac.this.nqL.cah();
                AppMethodBeat.o(135129);
            }
        });
        AppMethodBeat.o(135190);
    }

    public void YP(final String str) {
        AppMethodBeat.i(135191);
        runOnUiThread(new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.page.ac.AnonymousClass17 */

            public final void run() {
                AppMethodBeat.i(135130);
                if (ac.this.nqL == null) {
                    AppMethodBeat.o(135130);
                    return;
                }
                ac.this.nqL.setStatusBarForegroundStyle(e.a.afW(str) == e.a.BLACK);
                AppMethodBeat.o(135130);
            }
        });
        AppMethodBeat.o(135191);
    }

    /* access modifiers changed from: protected */
    public void dF(String str) {
    }

    public final String bRx() {
        AppMethodBeat.i(219443);
        com.tencent.mm.plugin.appbrand.page.a.d dVar = (com.tencent.mm.plugin.appbrand.page.a.d) S(com.tencent.mm.plugin.appbrand.page.a.d.class);
        if (dVar != null) {
            String MZ = dVar.MZ();
            AppMethodBeat.o(219443);
            return MZ;
        }
        AppMethodBeat.o(219443);
        return null;
    }

    public final void adN(String str) {
        AppMethodBeat.i(135194);
        if ("dark".equalsIgnoreCase(str)) {
            this.nqR = e.a.BLACK;
            AppMethodBeat.o(135194);
            return;
        }
        this.nqR = e.a.WHITE;
        AppMethodBeat.o(135194);
    }

    public View bRy() {
        AppMethodBeat.i(176633);
        AppMethodBeat.o(176633);
        return null;
    }

    public View bRz() {
        return null;
    }

    private void bRA() {
        AppMethodBeat.i(135196);
        this.kDZ = true;
        if (bRb() != null) {
            com.tencent.mm.plugin.appbrand.page.a.g gVar = (com.tencent.mm.plugin.appbrand.page.a.g) bRb().S(com.tencent.mm.plugin.appbrand.page.a.g.class);
            if (gVar != null) {
                gVar.bRA();
                AppMethodBeat.o(135196);
                return;
            }
            IllegalAccessError illegalAccessError = new IllegalAccessError(String.format(Locale.US, "Renderer[%s] impl not supports preload", bRb().getClass().getName()));
            AppMethodBeat.o(135196);
            throw illegalAccessError;
        }
        AppMethodBeat.o(135196);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.l
    public final boolean bsW() {
        AppMethodBeat.i(135197);
        if (bRb() != null) {
            com.tencent.mm.plugin.appbrand.page.a.g gVar = (com.tencent.mm.plugin.appbrand.page.a.g) bRb().S(com.tencent.mm.plugin.appbrand.page.a.g.class);
            if (gVar == null || !gVar.bSg()) {
                AppMethodBeat.o(135197);
                return false;
            }
            AppMethodBeat.o(135197);
            return true;
        } else if (getRuntime() == null) {
            AppMethodBeat.o(135197);
            return true;
        } else {
            AppMethodBeat.o(135197);
            return false;
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.l
    public final boolean bsX() {
        AppMethodBeat.i(219444);
        if (bRb() != null) {
            com.tencent.mm.plugin.appbrand.page.a.g gVar = (com.tencent.mm.plugin.appbrand.page.a.g) bRb().S(com.tencent.mm.plugin.appbrand.page.a.g.class);
            if (gVar == null || !gVar.bsX()) {
                AppMethodBeat.o(219444);
                return false;
            }
            AppMethodBeat.o(219444);
            return true;
        }
        boolean z = this.kDZ;
        AppMethodBeat.o(219444);
        return z;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.h
    public final boolean btO() {
        AppMethodBeat.i(135198);
        boolean contains = org.apache.commons.b.a.contains(new e.b[]{e.b.LANDSCAPE_SENSOR, e.b.LANDSCAPE_LOCKED, e.b.LANDSCAPE_LEFT, e.b.LANDSCAPE_RIGHT}, this.kEb.getOrientationHandler().btm());
        AppMethodBeat.o(135198);
        return contains;
    }

    public Bitmap bRB() {
        AppMethodBeat.i(135199);
        if (this.nmX == null) {
            AppMethodBeat.o(135199);
            return null;
        }
        Bitmap cD = ca.cD(this.nmX.getWrapperView());
        if (cD != null) {
            ViewGroup bRe = bRe();
            ca.a(bRe, bRe, new Canvas(cD));
        }
        AppMethodBeat.o(135199);
        return cD;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.g
    public final String btc() {
        return "AppBrandPageView";
    }

    public final <T> T S(Class<T> cls) {
        AppMethodBeat.i(135200);
        if (bRb() != null) {
            T t = (T) bRb().S(cls);
            AppMethodBeat.o(135200);
            return t;
        }
        AppMethodBeat.o(135200);
        return null;
    }

    public final boolean bRC() {
        return this.nqW;
    }

    public void bRD() {
        AppMethodBeat.i(219445);
        if (this.nqQ == null) {
            AppMethodBeat.o(219445);
            return;
        }
        this.nqM.setNavResetStyleListener(this.nqQ);
        this.nqM.setNavHidden(false);
        if (this.nqQ.nno) {
            bRF();
        }
        AppMethodBeat.o(219445);
    }

    public final void bRE() {
        if (this.nqQ != null) {
            this.nqQ.nno = true;
        }
    }

    public void bRF() {
        AppMethodBeat.i(219446);
        if (this.nqQ != null) {
            if (this.nqQ.nnp) {
                this.nqM.setNavHidden(true);
            }
            bRE();
        }
        AppMethodBeat.o(219446);
    }

    /* access modifiers changed from: protected */
    public b bRG() {
        AppMethodBeat.i(219447);
        Assert.assertTrue(MMHandlerThread.isMainThread());
        b bVar = new b(this);
        AppMethodBeat.o(219447);
        return bVar;
    }

    public final Activity getActivity() {
        AppMethodBeat.i(164053);
        if (this.kEb instanceof o) {
            Activity castActivityOrNull = AndroidContextUtil.castActivityOrNull(((o) this.kEb).mContext);
            AppMethodBeat.o(164053);
            return castActivityOrNull;
        }
        Activity castActivityOrNull2 = AndroidContextUtil.castActivityOrNull(getContext());
        AppMethodBeat.o(164053);
        return castActivityOrNull2;
    }

    public final ViewGroup bRe() {
        AppMethodBeat.i(135153);
        ViewGroup container = this.nqO.getContainer();
        AppMethodBeat.o(135153);
        return container;
    }

    /* access modifiers changed from: protected */
    public final boolean adL(String str) {
        AppMethodBeat.i(219438);
        if (this.nqZ) {
            synchronized (this.nra) {
                try {
                    this.nrc = new int[0];
                    getComponentId();
                } catch (Throwable th) {
                    AppMethodBeat.o(219438);
                    throw th;
                }
            }
            int bRn = bRn();
            int componentId = getComponentId();
            c("webviewIdChanged", String.format(Locale.ENGLISH, "{webviewId: %d}", Integer.valueOf(componentId)), 0);
            Log.i("MicroMsg.AppBrandPageView", "rewriteRoute --START-- appId:%s, url[%s]->[%s], componentId[%d]->[%d]", getAppId(), this.lBI, str, Integer.valueOf(bRn), Integer.valueOf(componentId));
            this.nqZ = false;
            this.nqU.adB(str);
            this.nqU.a(bx.REWRITE_ROUTE, (w.h) null);
            this.nqU.b(bx.REWRITE_ROUTE);
            Log.i("MicroMsg.AppBrandPageView", "rewriteRoute --END-- appId:%s, rewrittenURL:%s, rewrittenComponentId:%d", getAppId(), str, Integer.valueOf(getComponentId()));
            AppMethodBeat.o(219438);
            return true;
        }
        Log.w("MicroMsg.AppBrandPageView", "rewriteRoute condition mismatch, appId:%s, currentURL:%s, rewrittenURL:%s", getAppId(), this.lBI, str);
        AppMethodBeat.o(219438);
        return false;
    }

    public String bDn() {
        AppMethodBeat.i(135182);
        com.tencent.mm.plugin.appbrand.widget.actionbar.b bVar = this.nqM;
        CharSequence mainTitle = bVar == null ? null : bVar.getMainTitle();
        if (mainTitle != null) {
            String charSequence = mainTitle.toString();
            AppMethodBeat.o(135182);
            return charSequence;
        }
        AppMethodBeat.o(135182);
        return "";
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.f
    public final /* synthetic */ com.tencent.mm.plugin.appbrand.m.i Oo() {
        bb awVar;
        AppMethodBeat.i(135203);
        Context context = getContext();
        if (bRb() != null) {
            awVar = bRb().aI(context);
        } else {
            if (this.nqV == null) {
                this.nqV = new an(this);
            }
            awVar = new aw(context, this.nqV);
        }
        this.nmX = awVar;
        AppMethodBeat.o(135203);
        return awVar;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.h
    public final /* synthetic */ h.a gA(boolean z) {
        AppMethodBeat.i(219448);
        if (z) {
            j jVar = getRuntime().kAT;
            AppMethodBeat.o(219448);
            return jVar;
        }
        ao aoVar = this.nqN;
        AppMethodBeat.o(219448);
        return aoVar;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.h
    public /* bridge */ /* synthetic */ h.a getCustomViewContainer() {
        return this.nqN;
    }

    static /* synthetic */ void o(ac acVar) {
        AppMethodBeat.i(135204);
        acVar.nqM = (com.tencent.mm.plugin.appbrand.widget.actionbar.b) acVar.npk.d(acVar.getContext(), com.tencent.mm.plugin.appbrand.widget.actionbar.b.class);
        acVar.nqM.getActionView().setId(acVar.nqI);
        acVar.nqM.setBackButtonClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.appbrand.page.ac.AnonymousClass20 */

            public final void onClick(View view) {
                AppMethodBeat.i(135136);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/page/AppBrandPageView$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (!ac.this.onBackPressed()) {
                    ac.this.kEc.brh().a(ac.this.nqU, "scene_actionbar_back");
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/page/AppBrandPageView$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(135136);
            }
        });
        acVar.nqM.setCloseButtonClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.appbrand.page.ac.AnonymousClass21 */

            public final void onClick(View view) {
                AppMethodBeat.i(135137);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/page/AppBrandPageView$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                com.tencent.mm.plugin.appbrand.h.a(ac.this.getAppId(), h.d.CLOSE);
                ac.this.kEc.close();
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/page/AppBrandPageView$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(135137);
            }
        });
        acVar.nqM.a(new com.tencent.mm.plugin.appbrand.widget.actionbar.a() {
            /* class com.tencent.mm.plugin.appbrand.page.ac.AnonymousClass22 */

            @Override // com.tencent.mm.plugin.appbrand.widget.actionbar.a
            public final void bLE() {
                AppMethodBeat.i(135138);
                ac.this.nmX.MM();
                r.h(ac.this);
                AppMethodBeat.o(135138);
            }
        });
        acVar.nqM.setOptionButtonClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.appbrand.page.ac.AnonymousClass23 */

            public final void onClick(View view) {
                int i2;
                AppMethodBeat.i(135140);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/page/AppBrandPageView$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                boolean aM = com.tencent.luggage.h.g.aM(ac.this.getContext());
                ac acVar = ac.this;
                AnonymousClass1 r2 = new Runnable() {
                    /* class com.tencent.mm.plugin.appbrand.page.ac.AnonymousClass23.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(135139);
                        if (!ac.this.isRunning()) {
                            AppMethodBeat.o(135139);
                            return;
                        }
                        ac.a(ac.this, ac.this.bRh());
                        AppMethodBeat.o(135139);
                    }
                };
                if (aM) {
                    i2 = 100;
                } else {
                    i2 = 0;
                }
                acVar.i(r2, (long) i2);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/page/AppBrandPageView$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(135140);
            }
        });
        acVar.nqL = (com.tencent.mm.plugin.appbrand.widget.actionbar.d) acVar.npk.d(acVar.getContext(), com.tencent.mm.plugin.appbrand.widget.actionbar.d.class);
        acVar.nqL.setId(nqH);
        acVar.nqL.setActuallyVisible(false);
        acVar.nqL.setDeferStatusBarHeightChange(false);
        acVar.nqL.addView(acVar.nqM, new ViewGroup.LayoutParams(-1, -1));
        acVar.a(new i.b() {
            /* class com.tencent.mm.plugin.appbrand.page.ac.AnonymousClass24 */

            @Override // com.tencent.mm.plugin.appbrand.jsapi.i.b
            public final void onBackground() {
                AppMethodBeat.i(219435);
                ac.this.nqL.setActuallyVisible(false);
                AppMethodBeat.o(219435);
            }
        });
        acVar.a((i.d) acVar.nqM);
        acVar.a((i.b) acVar.nqM);
        AppMethodBeat.o(135204);
    }

    static /* synthetic */ void a(ac acVar, List list) {
        AppMethodBeat.i(219449);
        if (list == null || list.size() <= 0) {
            Log.w("MicroMsg.AppBrandPageView", "showPageActionSheet appId[%s], url[%s], empty list skip", acVar.getAppId(), acVar.lBI);
            AppMethodBeat.o(219449);
            return;
        }
        acVar.bP(list);
        AppMethodBeat.o(219449);
    }
}

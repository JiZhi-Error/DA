package com.tencent.mm.plugin.finder.viewmodel.component;

import android.arch.lifecycle.ViewModel;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.cl;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.activity.fragment.FinderActivityFragment;
import com.tencent.mm.plugin.finder.event.base.f;
import com.tencent.mm.plugin.finder.extension.reddot.i;
import com.tencent.mm.plugin.finder.model.as;
import com.tencent.mm.plugin.finder.nearby.base.AbsNearByFragment;
import com.tencent.mm.plugin.finder.report.ac;
import com.tencent.mm.plugin.finder.report.ae;
import com.tencent.mm.plugin.finder.report.e;
import com.tencent.mm.plugin.finder.report.g;
import com.tencent.mm.plugin.finder.report.k;
import com.tencent.mm.plugin.finder.report.n;
import com.tencent.mm.plugin.finder.report.o;
import com.tencent.mm.plugin.finder.report.u;
import com.tencent.mm.plugin.finder.report.v;
import com.tencent.mm.plugin.finder.ui.FinderHomeUI;
import com.tencent.mm.plugin.finder.ui.FinderShareFeedRelUI;
import com.tencent.mm.plugin.finder.ui.fragment.FinderHomeTabFragment;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.plugin.finder.view.h;
import com.tencent.mm.plugin.finder.viewmodel.FinderHomeTabStateVM;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.s;
import kotlin.t;
import kotlin.x;
import org.json.JSONObject;

public final class FinderReporterUIC extends UIComponent implements h {
    private static final int STOP = 2;
    private static final String TAG = TAG;
    private static final String kWD = kWD;
    private static final int uOE = 1;
    private static final long wzB = 60000;
    public static final a wzC = new a((byte) 0);
    public boolean UVO;
    private int dYn;
    String extraInfo = "";
    public String sGE;
    String sGH = "";
    public String sGQ;
    public String sessionId;
    public int tCE;
    private com.tencent.mm.plugin.finder.event.base.c tId;
    public int tyh;
    public int wtW;
    long wyW;
    String wyX;
    int wyY;
    public int wyZ;
    private final c wzA = new c(this, kWD);
    public String wza = "";
    private boolean wzb;
    private com.tencent.mm.plugin.finder.event.a wzc;
    private n wzd;
    private o wze;
    private ae wzf;
    private u wzg;
    private v wzh;
    private ac wzi;
    private com.tencent.mm.plugin.finder.event.base.c wzj;
    private com.tencent.mm.plugin.finder.event.a wzk;
    private n wzl;
    private o wzm;
    private com.tencent.mm.plugin.finder.event.base.c wzn;
    private com.tencent.mm.plugin.finder.event.a wzo;
    private n wzp;
    private o wzq;
    private com.tencent.mm.plugin.finder.event.base.c wzr;
    private com.tencent.mm.plugin.finder.event.a wzs;
    private n wzt;
    private g wzu;
    private boolean wzv = true;
    private boolean wzw = true;
    private boolean wzx;
    private boolean wzy = true;
    public LinkedList<WeakReference<WxRecyclerAdapter<?>>> wzz = new LinkedList<>();

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FinderReporterUIC(AppCompatActivity appCompatActivity) {
        super(appCompatActivity);
        p.h(appCompatActivity, EnvConsts.ACTIVITY_MANAGER_SRVNAME);
        AppMethodBeat.i(255893);
        AppMethodBeat.o(255893);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FinderReporterUIC(Fragment fragment) {
        super(fragment);
        p.h(fragment, "fragment");
        AppMethodBeat.i(255894);
        AppMethodBeat.o(255894);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x004e, code lost:
        if (r1 == null) goto L_0x0050;
     */
    @Override // com.tencent.mm.ui.component.UIComponent
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onCreateBefore(android.os.Bundle r6) {
        /*
        // Method dump skipped, instructions count: 161
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.onCreateBefore(android.os.Bundle):void");
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onCreateAfter(Bundle bundle) {
        AppMethodBeat.i(255870);
        super.onCreateAfter(bundle);
        if (getActivity() instanceof FinderHomeUI) {
            k kVar = k.vfA;
            String str = this.sGQ;
            if (str == null) {
                str = "";
            }
            k.gS(str, "OnCreate");
            e.a aVar = e.vdS;
            bbn dIx = dIx();
            e.a aVar2 = e.vdS;
            String jSONObject = e.a.a(8, String.valueOf(getActivity().getIntent().getIntExtra("FROM_SCENE_KEY", 2))).toString();
            p.g(jSONObject, "FinderFeedFlowReporter.b…ORE_FRIEND)}\").toString()");
            e.a.a(dIx, 0, 8, jSONObject, 0, null, 48);
        }
        if (getActivity() instanceof FinderShareFeedRelUI) {
            e.a aVar3 = e.vdS;
            bbn dIx2 = dIx();
            e.a aVar4 = e.vdS;
            String jSONObject2 = e.a.a(8, String.valueOf(getActivity().getIntent().getIntExtra("FROM_SCENE_KEY", 1))).toString();
            p.g(jSONObject2, "FinderFeedFlowReporter.b…ARE_DETAIL)}\").toString()");
            e.a.a(dIx2, 0, 8, jSONObject2, 0, null, 48);
        }
        as asVar = as.uOL;
        as.startTimer();
        this.wzA.sendEmptyMessage(uOE);
        AppMethodBeat.o(255870);
    }

    public final void gv(int i2, int i3) {
        g oVar;
        FinderReporterUIC finderReporterUIC;
        g oVar2;
        FinderReporterUIC finderReporterUIC2;
        AppMethodBeat.i(255871);
        this.tyh = getActivity().getIntent().getIntExtra("key_comment_scene", 0);
        if (i2 == 0) {
            this.tCE = this.tyh;
        } else {
            this.tCE = i2;
        }
        this.dYn = i3;
        this.wzb = dIv();
        String stringExtra = getActivity().getIntent().getStringExtra("key_context_id");
        if (stringExtra == null) {
            k kVar = k.vfA;
            stringExtra = k.doc();
        }
        this.sGQ = stringExtra;
        String cMD = ((com.tencent.mm.plugin.expt.b.c) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.c.class)).cMD();
        if (cMD == null) {
            cMD = "";
        }
        this.sessionId = cMD;
        this.wyW = getActivity().getIntent().getLongExtra("key_click_feed_id", 0);
        this.wyX = getActivity().getIntent().getStringExtra("key_click_feed_context_id");
        this.wyY = getActivity().getIntent().getIntExtra("key_enter_profile_type", 0);
        this.wyZ = getActivity().getIntent().getIntExtra("key_from_profile_share_scene", 0);
        if (dIs()) {
            com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
            this.wtW = ((FinderHomeUIC) com.tencent.mm.ui.component.a.b(getActivity()).get(FinderHomeUIC.class)).dIf();
            k kVar2 = k.vfA;
            this.tCE = k.Kw(this.wtW);
            this.sGE = a.MG(this.wtW);
        } else if (getFragment() instanceof AbsNearByFragment) {
            Fragment fragment = getFragment();
            if (fragment == null) {
                t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.nearby.base.AbsNearByFragment");
                AppMethodBeat.o(255871);
                throw tVar;
            }
            this.wtW = ((AbsNearByFragment) fragment).dLS;
            Fragment fragment2 = getFragment();
            if (fragment2 == null) {
                t tVar2 = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.nearby.base.AbsNearByFragment");
                AppMethodBeat.o(255871);
                throw tVar2;
            }
            this.tCE = ((AbsNearByFragment) fragment2).getCommentScene();
            Fragment fragment3 = getFragment();
            if (fragment3 == null) {
                t tVar3 = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.nearby.base.AbsNearByFragment");
                AppMethodBeat.o(255871);
                throw tVar3;
            }
            this.sGE = ((AbsNearByFragment) fragment3).ack();
        } else if (getFragment() instanceof FinderActivityFragment) {
            Fragment fragment4 = getFragment();
            if (fragment4 == null) {
                t tVar4 = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.activity.fragment.FinderActivityFragment");
                AppMethodBeat.o(255871);
                throw tVar4;
            }
            this.wtW = ((FinderActivityFragment) fragment4).dLS + 1;
            if (getFragment() == null) {
                t tVar5 = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.activity.fragment.FinderActivityFragment");
                AppMethodBeat.o(255871);
                throw tVar5;
            }
            this.tCE = 59;
            this.sGE = a.MG(i2 + 100);
        } else {
            String stringExtra2 = getActivity().getIntent().getStringExtra("key_click_tab_context_id");
            if (stringExtra2 == null) {
                stringExtra2 = "";
            }
            this.sGE = stringExtra2;
            if (Util.isNullOrNil(this.sGE)) {
                this.sGE = a.MG(i2 + 100);
            }
        }
        String stringExtra3 = getActivity().getIntent().getStringExtra("key_extra_info");
        if (stringExtra3 == null) {
            stringExtra3 = "";
        }
        this.extraInfo = stringExtra3;
        String stringExtra4 = getActivity().getIntent().getStringExtra("key_enter_source_info");
        if (stringExtra4 == null) {
            stringExtra4 = "";
        }
        this.sGH = stringExtra4;
        Log.i(TAG, "initActivityReporter reportType:" + this.dYn + " commentScene:" + this.tCE + " fromCommentScene:" + this.tyh + " sessionId:" + this.sessionId + " contextId:" + this.sGQ + " clickTabContextId:" + this.sGE + " currentTabType:" + this.wtW + " uxInfo:" + this.extraInfo);
        if (dIs()) {
            com.tencent.mm.plugin.finder.event.base.c cVar = new com.tencent.mm.plugin.finder.event.base.c(kWD);
            this.wzl = new n(cVar);
            this.wzk = new com.tencent.mm.plugin.finder.event.a(cVar);
            com.tencent.mm.plugin.finder.storage.c cVar2 = com.tencent.mm.plugin.finder.storage.c.vCb;
            if (com.tencent.mm.plugin.finder.storage.c.dtE()) {
                AppCompatActivity activity = getActivity();
                if (activity == null) {
                    t tVar6 = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMFragmentActivity");
                    AppMethodBeat.o(255871);
                    throw tVar6;
                }
                g gVar = new g((MMFragmentActivity) activity, Mz(3));
                cVar.a(gVar);
                gVar.onInvisible();
                oVar = gVar;
                finderReporterUIC = this;
            } else {
                AppCompatActivity activity2 = getActivity();
                if (activity2 == null) {
                    t tVar7 = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMFragmentActivity");
                    AppMethodBeat.o(255871);
                    throw tVar7;
                }
                oVar = new o((MMFragmentActivity) activity2, Mz(3));
                cVar.a(oVar);
                oVar.onInvisible();
                finderReporterUIC = this;
            }
            finderReporterUIC.wzm = oVar;
            cVar.a(new com.tencent.mm.plugin.finder.event.b());
            this.wzj = cVar;
            com.tencent.mm.plugin.finder.event.base.c cVar3 = new com.tencent.mm.plugin.finder.event.base.c(kWD);
            this.wzp = new n(cVar3);
            this.wzo = new com.tencent.mm.plugin.finder.event.a(cVar3);
            com.tencent.mm.plugin.finder.storage.c cVar4 = com.tencent.mm.plugin.finder.storage.c.vCb;
            if (com.tencent.mm.plugin.finder.storage.c.dtE()) {
                AppCompatActivity activity3 = getActivity();
                if (activity3 == null) {
                    t tVar8 = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMFragmentActivity");
                    AppMethodBeat.o(255871);
                    throw tVar8;
                }
                g gVar2 = new g((MMFragmentActivity) activity3, Mz(1));
                cVar3.a(gVar2);
                gVar2.onInvisible();
                oVar2 = gVar2;
                finderReporterUIC2 = this;
            } else {
                AppCompatActivity activity4 = getActivity();
                if (activity4 == null) {
                    t tVar9 = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMFragmentActivity");
                    AppMethodBeat.o(255871);
                    throw tVar9;
                }
                oVar2 = new o((MMFragmentActivity) activity4, Mz(1));
                cVar3.a(oVar2);
                oVar2.onInvisible();
                finderReporterUIC2 = this;
            }
            finderReporterUIC2.wzq = oVar2;
            cVar3.a(new com.tencent.mm.plugin.finder.event.b());
            this.wzn = cVar3;
            com.tencent.mm.plugin.finder.event.base.c cVar5 = new com.tencent.mm.plugin.finder.event.base.c(kWD);
            this.wzt = new n(cVar5);
            this.wzs = new com.tencent.mm.plugin.finder.event.a(cVar5);
            AppCompatActivity activity5 = getActivity();
            if (activity5 == null) {
                t tVar10 = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMFragmentActivity");
                AppMethodBeat.o(255871);
                throw tVar10;
            }
            g gVar3 = new g((MMFragmentActivity) activity5, Mz(4));
            cVar5.a(gVar3);
            gVar3.onInvisible();
            this.wzu = gVar3;
            cVar5.a(new com.tencent.mm.plugin.finder.event.b());
            this.wzr = cVar5;
            com.tencent.mm.ui.component.a aVar2 = com.tencent.mm.ui.component.a.PRN;
            ((FinderHomeUIC) com.tencent.mm.ui.component.a.b(getActivity()).get(FinderHomeUIC.class)).wxj.add(this);
            AppMethodBeat.o(255871);
        } else if (dIt()) {
            com.tencent.mm.plugin.finder.event.base.c cVar6 = new com.tencent.mm.plugin.finder.event.base.c(kWD);
            this.wzc = new com.tencent.mm.plugin.finder.event.a(cVar6);
            this.wzd = new n(cVar6);
            AppCompatActivity activity6 = getActivity();
            if (activity6 == null) {
                t tVar11 = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMFragmentActivity");
                AppMethodBeat.o(255871);
                throw tVar11;
            }
            o oVar3 = new o((MMFragmentActivity) activity6, dIx());
            cVar6.a(oVar3);
            this.wze = oVar3;
            cVar6.a(new com.tencent.mm.plugin.finder.event.b());
            this.tId = cVar6;
            AppMethodBeat.o(255871);
        } else if (dIu()) {
            com.tencent.mm.plugin.finder.event.base.c cVar7 = new com.tencent.mm.plugin.finder.event.base.c(kWD);
            this.wzc = new com.tencent.mm.plugin.finder.event.a(cVar7);
            this.wzg = new u(cVar7);
            AppCompatActivity activity7 = getActivity();
            if (activity7 == null) {
                t tVar12 = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMFragmentActivity");
                AppMethodBeat.o(255871);
                throw tVar12;
            }
            v vVar = new v((MMFragmentActivity) activity7, dIx());
            cVar7.a(vVar);
            this.wzh = vVar;
            this.tId = cVar7;
            AppMethodBeat.o(255871);
        } else if (dIv()) {
            com.tencent.mm.plugin.finder.event.base.c cVar8 = new com.tencent.mm.plugin.finder.event.base.c(kWD);
            this.wzc = new com.tencent.mm.plugin.finder.event.a(cVar8);
            this.wzd = new n(cVar8);
            AppCompatActivity activity8 = getActivity();
            if (activity8 == null) {
                t tVar13 = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMFragmentActivity");
                AppMethodBeat.o(255871);
                throw tVar13;
            }
            ae aeVar = new ae((MMFragmentActivity) activity8, dIx());
            cVar8.a(aeVar);
            this.wzf = aeVar;
            cVar8.a(new com.tencent.mm.plugin.finder.event.b());
            this.tId = cVar8;
            AppMethodBeat.o(255871);
        } else {
            if (dIw()) {
                AppCompatActivity activity9 = getActivity();
                if (activity9 == null) {
                    t tVar14 = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
                    AppMethodBeat.o(255871);
                    throw tVar14;
                }
                this.wzi = new ac((MMActivity) activity9, dIx());
            }
            AppMethodBeat.o(255871);
        }
    }

    public final boolean dIs() {
        return this.dYn == 1;
    }

    private boolean dIt() {
        return this.dYn == 2;
    }

    private boolean dIu() {
        return this.dYn == 3;
    }

    private boolean dIv() {
        return this.dYn == 4;
    }

    private final boolean dIw() {
        return this.dYn == 5;
    }

    public final void s(long j2, String str) {
        String str2;
        bbn bbn;
        bbn bbn2 = null;
        AppMethodBeat.i(255872);
        Log.i(TAG, "setEnterSourceInfo:" + j2 + "  finderUserName:" + str + '}');
        JSONObject jSONObject = new JSONObject();
        k kVar = k.vfA;
        String Fg = k.Fg(j2);
        this.wyW = j2;
        jSONObject.put("feedid", Fg);
        if (str == null) {
            str2 = "";
        } else {
            str2 = str;
        }
        jSONObject.put("finderusername", str2);
        String jSONObject2 = jSONObject.toString();
        p.g(jSONObject2, "enterSourceJson.toString()");
        this.sGH = jSONObject2;
        o oVar = this.wze;
        if (oVar != null) {
            bbn = oVar.ttO;
        } else {
            bbn = null;
        }
        a(bbn, jSONObject2);
        v vVar = this.wzh;
        if (vVar != null) {
            bbn2 = vVar.ttO;
        }
        a(bbn2, jSONObject2);
        getActivity().getIntent().putExtra("key_enter_source_info", this.sGH);
        if (!Util.isNullOrNil(this.extraInfo)) {
            e.a aVar = e.vdS;
            e.a.o(this.sGQ, this.extraInfo, Fg, str);
        }
        AppMethodBeat.o(255872);
    }

    private static void a(bbn bbn, String str) {
        if (bbn != null) {
            bbn.sGH = str;
        }
    }

    public final bbn dIx() {
        AppMethodBeat.i(255873);
        if (dIs()) {
            com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
            bbn Mz = Mz(((FinderHomeUIC) com.tencent.mm.ui.component.a.b(getActivity()).get(FinderHomeUIC.class)).dIf());
            AppMethodBeat.o(255873);
            return Mz;
        }
        bbn bbn = new bbn();
        bbn.tyh = this.tyh;
        bbn.tCE = this.tCE;
        bbn.sessionId = this.sessionId;
        bbn.sGQ = this.sGQ;
        bbn.sGE = this.sGE;
        bbn.wyW = this.wyW;
        bbn.wyX = this.wyX;
        bbn.wyZ = this.wyZ;
        bbn.wyY = this.wyY;
        bbn.wza = this.wza;
        String str = this.extraInfo;
        if (str == null) {
            str = "";
        }
        bbn.extraInfo = str;
        String str2 = this.sGH;
        if (str2 == null) {
            str2 = "";
        }
        bbn.sGH = str2;
        bbn.wzb = this.wzb;
        bbn.dLS = this.wtW;
        AppMethodBeat.o(255873);
        return bbn;
    }

    public final bbn Mz(int i2) {
        AppMethodBeat.i(255874);
        bbn bbn = new bbn();
        bbn.tyh = this.tyh;
        bbn.sessionId = this.sessionId;
        bbn.sGQ = this.sGQ;
        bbn.sGE = this.sGE;
        bbn.wyW = this.wyW;
        bbn.wyX = this.wyX;
        k kVar = k.vfA;
        bbn.tCE = k.Kw(i2);
        bbn.wyZ = this.wyZ;
        bbn.wyY = this.wyY;
        bbn.wza = this.wza;
        String str = this.extraInfo;
        if (str == null) {
            str = "";
        }
        bbn.extraInfo = str;
        String str2 = this.sGH;
        if (str2 == null) {
            str2 = "";
        }
        bbn.sGH = str2;
        bbn.wzb = false;
        AppMethodBeat.o(255874);
        return bbn;
    }

    public static /* synthetic */ com.tencent.mm.plugin.finder.event.base.c a(FinderReporterUIC finderReporterUIC) {
        AppMethodBeat.i(255876);
        com.tencent.mm.plugin.finder.event.base.c MA = finderReporterUIC.MA(-1);
        AppMethodBeat.o(255876);
        return MA;
    }

    public final com.tencent.mm.plugin.finder.event.base.c MA(int i2) {
        AppMethodBeat.i(255875);
        if (!dIs()) {
            com.tencent.mm.plugin.finder.event.base.c cVar = this.tId;
            AppMethodBeat.o(255875);
            return cVar;
        } else if (i2 == -1) {
            com.tencent.mm.plugin.finder.event.base.c MF = MF(this.wtW);
            AppMethodBeat.o(255875);
            return MF;
        } else {
            com.tencent.mm.plugin.finder.event.base.c MF2 = MF(i2);
            AppMethodBeat.o(255875);
            return MF2;
        }
    }

    public static /* synthetic */ e c(FinderReporterUIC finderReporterUIC) {
        AppMethodBeat.i(255879);
        e MB = finderReporterUIC.MB(-1);
        AppMethodBeat.o(255879);
        return MB;
    }

    public final e MB(int i2) {
        AppMethodBeat.i(255878);
        if (dIs()) {
            if (i2 == -1) {
                e MD = MD(this.wtW);
                AppMethodBeat.o(255878);
                return MD;
            }
            e MD2 = MD(i2);
            AppMethodBeat.o(255878);
            return MD2;
        } else if (dIt()) {
            o oVar = this.wze;
            AppMethodBeat.o(255878);
            return oVar;
        } else if (dIu()) {
            v vVar = this.wzh;
            AppMethodBeat.o(255878);
            return vVar;
        } else if (dIv()) {
            ae aeVar = this.wzf;
            AppMethodBeat.o(255878);
            return aeVar;
        } else if (dIw()) {
            ac acVar = this.wzi;
            AppMethodBeat.o(255878);
            return acVar;
        } else {
            AppMethodBeat.o(255878);
            return null;
        }
    }

    public static /* synthetic */ f d(FinderReporterUIC finderReporterUIC) {
        AppMethodBeat.i(255881);
        f MC = finderReporterUIC.MC(-1);
        AppMethodBeat.o(255881);
        return MC;
    }

    public final f MC(int i2) {
        AppMethodBeat.i(255880);
        if (dIs()) {
            if (i2 == -1) {
                f ME = ME(this.wtW);
                AppMethodBeat.o(255880);
                return ME;
            }
            f ME2 = ME(i2);
            AppMethodBeat.o(255880);
            return ME2;
        } else if (dIt()) {
            n nVar = this.wzd;
            AppMethodBeat.o(255880);
            return nVar;
        } else if (dIu()) {
            u uVar = this.wzg;
            AppMethodBeat.o(255880);
            return uVar;
        } else if (dIv()) {
            n nVar2 = this.wzd;
            AppMethodBeat.o(255880);
            return nVar2;
        } else {
            AppMethodBeat.o(255880);
            return null;
        }
    }

    private e MD(int i2) {
        AppMethodBeat.i(255882);
        Log.i(TAG, "getHomeFlowReporter ".concat(String.valueOf(i2)));
        switch (i2) {
            case 1:
                o oVar = this.wzq;
                AppMethodBeat.o(255882);
                return oVar;
            case 2:
            default:
                o oVar2 = this.wze;
                AppMethodBeat.o(255882);
                return oVar2;
            case 3:
                o oVar3 = this.wzm;
                AppMethodBeat.o(255882);
                return oVar3;
            case 4:
                g gVar = this.wzu;
                AppMethodBeat.o(255882);
                return gVar;
        }
    }

    public final f ME(int i2) {
        AppMethodBeat.i(255883);
        Log.i(TAG, "getHomeFlowEventSubscriber ".concat(String.valueOf(i2)));
        switch (i2) {
            case 1:
                n nVar = this.wzp;
                AppMethodBeat.o(255883);
                return nVar;
            case 2:
            default:
                n nVar2 = this.wzd;
                AppMethodBeat.o(255883);
                return nVar2;
            case 3:
                n nVar3 = this.wzl;
                AppMethodBeat.o(255883);
                return nVar3;
            case 4:
                n nVar4 = this.wzt;
                AppMethodBeat.o(255883);
                return nVar4;
        }
    }

    public final com.tencent.mm.plugin.finder.event.base.c MF(int i2) {
        switch (i2) {
            case 1:
                return this.wzn;
            case 2:
            default:
                return this.tId;
            case 3:
                return this.wzj;
            case 4:
                return this.wzr;
        }
    }

    @Override // com.tencent.mm.plugin.finder.view.h
    public final void a(boolean z, int i2, FinderHomeTabFragment finderHomeTabFragment) {
        boolean z2;
        int i3;
        AppMethodBeat.i(255884);
        p.h(finderHomeTabFragment, "fragment");
        if (z) {
            com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
            ViewModel viewModel = com.tencent.mm.ui.component.a.bi(PluginFinder.class).get(FinderHomeTabStateVM.class);
            p.g(viewModel, "UICProvider.of(PluginFin…meTabStateVM::class.java)");
            FinderHomeTabStateVM finderHomeTabStateVM = (FinderHomeTabStateVM) viewModel;
            if (this.wzv) {
                z2 = finderHomeTabStateVM.dHR() == finderHomeTabFragment.dLS;
            } else {
                z2 = false;
            }
            if (!finderHomeTabStateVM.JN(finderHomeTabFragment.dLS)) {
                i3 = 3;
            } else {
                i3 = 2;
            }
            bbn Mz = Mz(finderHomeTabFragment.dLS);
            switch (finderHomeTabFragment.dLS) {
                case 1:
                    n nVar = this.wzp;
                    if (nVar != null) {
                        nVar.onVisible();
                    }
                    o oVar = this.wzq;
                    if (oVar != null) {
                        oVar.onVisible();
                    }
                    n nVar2 = this.wzl;
                    if (nVar2 != null) {
                        nVar2.onInvisible();
                    }
                    o oVar2 = this.wzm;
                    if (oVar2 != null) {
                        oVar2.onInvisible();
                    }
                    n nVar3 = this.wzt;
                    if (nVar3 != null) {
                        nVar3.onInvisible();
                    }
                    g gVar = this.wzu;
                    if (gVar != null) {
                        gVar.onInvisible();
                    }
                    i.a aVar2 = i.tLi;
                    i.a.a(i3, Mz, this.wtW, z2);
                    break;
                case 3:
                    n nVar4 = this.wzl;
                    if (nVar4 != null) {
                        nVar4.onVisible();
                    }
                    o oVar3 = this.wzm;
                    if (oVar3 != null) {
                        oVar3.onVisible();
                    }
                    n nVar5 = this.wzp;
                    if (nVar5 != null) {
                        nVar5.onInvisible();
                    }
                    o oVar4 = this.wzq;
                    if (oVar4 != null) {
                        oVar4.onInvisible();
                    }
                    n nVar6 = this.wzt;
                    if (nVar6 != null) {
                        nVar6.onInvisible();
                    }
                    g gVar2 = this.wzu;
                    if (gVar2 != null) {
                        gVar2.onInvisible();
                    }
                    i.a aVar3 = i.tLi;
                    i.a.b(i3, Mz, this.wtW, z2);
                    break;
                case 4:
                    n nVar7 = this.wzt;
                    if (nVar7 != null) {
                        nVar7.onVisible();
                    }
                    g gVar3 = this.wzu;
                    if (gVar3 != null) {
                        gVar3.onVisible();
                    }
                    n nVar8 = this.wzp;
                    if (nVar8 != null) {
                        nVar8.onInvisible();
                    }
                    o oVar5 = this.wzq;
                    if (oVar5 != null) {
                        oVar5.onInvisible();
                    }
                    n nVar9 = this.wzl;
                    if (nVar9 != null) {
                        nVar9.onInvisible();
                    }
                    o oVar6 = this.wzm;
                    if (oVar6 != null) {
                        oVar6.onInvisible();
                    }
                    i.a aVar4 = i.tLi;
                    i.a.c(i3, Mz, this.wtW, z2);
                    break;
            }
            this.wzv = false;
        }
        AppMethodBeat.o(255884);
    }

    @Override // com.tencent.mm.plugin.finder.view.h
    public final void D(int i2, int i3, int i4, int i5) {
        int i6;
        e MB;
        AppMethodBeat.i(255885);
        Log.i(TAG, "onFragmentChange ".concat(String.valueOf(i5)));
        k kVar = k.vfA;
        this.tCE = k.Kw(i5);
        this.wtW = i5;
        if (i2 >= 0) {
            this.sGE = a.MG(i5);
        }
        bbn Mz = Mz(i5);
        switch (i5) {
            case 1:
                o oVar = this.wzq;
                if (oVar != null) {
                    oVar.d(Mz);
                    break;
                }
                break;
            case 3:
                o oVar2 = this.wzm;
                if (oVar2 != null) {
                    oVar2.d(Mz);
                    break;
                }
                break;
            case 4:
                g gVar = this.wzu;
                if (gVar != null) {
                    gVar.d(Mz);
                    break;
                }
                break;
        }
        if (this.wzw) {
            com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
            Bundle bundle = ((FinderHomeUIC) com.tencent.mm.ui.component.a.b(getActivity()).get(FinderHomeUIC.class)).getActiveFragment().Ew;
            if (bundle != null) {
                i6 = bundle.getInt("Source", 0);
            } else {
                i6 = 0;
            }
        } else {
            this.wzw = true;
            i6 = 6;
        }
        k kVar2 = k.vfA;
        k.a(i4, i5, Mz, i6);
        if (i4 <= 0 || (MB = MB(i4)) == null) {
            AppMethodBeat.o(255885);
            return;
        }
        if (MB instanceof o) {
            e.a aVar2 = e.vdS;
            ((o) MB).auL(e.a.ah(kotlin.a.ae.e(s.U("feedActionType", 2), s.U("toTab", Integer.valueOf(i5)), s.U("fromTab", Integer.valueOf(i4)))));
        }
        AppMethodBeat.o(255885);
    }

    @Override // com.tencent.mm.plugin.finder.view.h
    public final void onPageScrolled(int i2, float f2, int i3) {
        if (this.wzx) {
            this.wzw = false;
            this.wzx = false;
        }
    }

    @Override // com.tencent.mm.plugin.finder.view.h
    public final void onPageScrollStateChanged(int i2) {
        switch (i2) {
            case 0:
                this.wzx = false;
                return;
            case 1:
                this.wzx = true;
                return;
            default:
                return;
        }
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onResume() {
        ac acVar;
        AppMethodBeat.i(255886);
        super.onResume();
        if (this.wzy) {
            this.wzy = false;
            AppMethodBeat.o(255886);
            return;
        }
        if (dIs()) {
            bbn Mz = Mz(this.wtW);
            switch (this.wtW) {
                case 1:
                    o oVar = this.wzq;
                    if (oVar != null) {
                        oVar.d(Mz);
                    }
                    n nVar = this.wzp;
                    if (nVar != null) {
                        nVar.onVisible();
                    }
                    o oVar2 = this.wzq;
                    if (oVar2 != null) {
                        oVar2.onVisible();
                        break;
                    }
                    break;
                case 3:
                    o oVar3 = this.wzm;
                    if (oVar3 != null) {
                        oVar3.d(Mz);
                    }
                    n nVar2 = this.wzl;
                    if (nVar2 != null) {
                        nVar2.onVisible();
                    }
                    o oVar4 = this.wzm;
                    if (oVar4 != null) {
                        oVar4.onVisible();
                        break;
                    }
                    break;
                case 4:
                    g gVar = this.wzu;
                    if (gVar != null) {
                        gVar.d(Mz);
                    }
                    n nVar3 = this.wzt;
                    if (nVar3 != null) {
                        nVar3.onVisible();
                    }
                    g gVar2 = this.wzu;
                    if (gVar2 != null) {
                        gVar2.onVisible();
                        break;
                    }
                    break;
            }
            i.a aVar = i.tLi;
            i.a.a(1, dIx(), this.wtW, false);
            i.a aVar2 = i.tLi;
            i.a.b(1, dIx(), this.wtW, false);
            i.a aVar3 = i.tLi;
            i.a.c(1, dIx(), this.wtW, false);
            i.a aVar4 = i.tLi;
            i.a.a(1, dIx());
            i.a aVar5 = i.tLi;
            i.a.a(1, dIx(), "");
        } else if (dIt()) {
            n nVar4 = this.wzd;
            if (nVar4 != null) {
                nVar4.onVisible();
            }
            o oVar5 = this.wze;
            if (oVar5 != null) {
                oVar5.onVisible();
            }
        } else if (dIu()) {
            u uVar = this.wzg;
            if (uVar != null) {
                uVar.onVisible();
            }
            v vVar = this.wzh;
            if (vVar != null) {
                vVar.onVisible();
            }
        } else if (dIv()) {
            n nVar5 = this.wzd;
            if (nVar5 != null) {
                nVar5.onVisible();
            }
            ae aeVar = this.wzf;
            if (aeVar != null) {
                aeVar.onVisible();
            }
        } else if (dIw() && (acVar = this.wzi) != null) {
            acVar.onVisible();
        }
        Iterator<T> it = this.wzz.iterator();
        while (it.hasNext()) {
            WxRecyclerAdapter wxRecyclerAdapter = (WxRecyclerAdapter) it.next().get();
            if (wxRecyclerAdapter != null) {
                wxRecyclerAdapter.onResume();
            }
        }
        AppMethodBeat.o(255886);
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onPause() {
        ac acVar;
        v vVar;
        AppMethodBeat.i(255887);
        super.onPause();
        if (dIs()) {
            switch (this.wtW) {
                case 1:
                    n nVar = this.wzp;
                    if (nVar != null) {
                        nVar.onInvisible();
                    }
                    o oVar = this.wzq;
                    if (oVar != null) {
                        oVar.onInvisible();
                        break;
                    }
                    break;
                case 3:
                    n nVar2 = this.wzl;
                    if (nVar2 != null) {
                        nVar2.onInvisible();
                    }
                    o oVar2 = this.wzm;
                    if (oVar2 != null) {
                        oVar2.onInvisible();
                        break;
                    }
                    break;
                case 4:
                    n nVar3 = this.wzt;
                    if (nVar3 != null) {
                        nVar3.onInvisible();
                    }
                    g gVar = this.wzu;
                    if (gVar != null) {
                        gVar.onInvisible();
                        break;
                    }
                    break;
            }
        } else if (dIt()) {
            n nVar4 = this.wzd;
            if (nVar4 != null) {
                nVar4.onInvisible();
            }
            o oVar3 = this.wze;
            if (oVar3 != null) {
                oVar3.onInvisible();
            }
        } else if (dIu()) {
            u uVar = this.wzg;
            if (uVar != null) {
                uVar.onInvisible();
            }
            if (!this.UVO && (vVar = this.wzh) != null) {
                vVar.onInvisible();
            }
        } else if (dIv()) {
            n nVar5 = this.wzd;
            if (nVar5 != null) {
                nVar5.onInvisible();
            }
            ae aeVar = this.wzf;
            if (aeVar != null) {
                aeVar.onInvisible();
            }
        } else if (dIw() && (acVar = this.wzi) != null) {
            acVar.onInvisible();
        }
        Iterator<T> it = this.wzz.iterator();
        while (it.hasNext()) {
            WxRecyclerAdapter wxRecyclerAdapter = (WxRecyclerAdapter) it.next().get();
            if (wxRecyclerAdapter != null) {
                wxRecyclerAdapter.onPause();
            }
        }
        AppMethodBeat.o(255887);
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onUserVisibleFocused() {
        AppMethodBeat.i(255888);
        super.onUserVisibleFocused();
        if (dIu()) {
            u uVar = this.wzg;
            if (uVar != null) {
                uVar.onVisible();
            }
            v vVar = this.wzh;
            if (vVar != null) {
                vVar.onVisible();
                AppMethodBeat.o(255888);
                return;
            }
        }
        AppMethodBeat.o(255888);
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onUserVisibleUnFocused() {
        AppMethodBeat.i(255889);
        super.onUserVisibleUnFocused();
        if (dIu()) {
            u uVar = this.wzg;
            if (uVar != null) {
                uVar.onInvisible();
            }
            v vVar = this.wzh;
            if (vVar != null) {
                vVar.onInvisible();
                AppMethodBeat.o(255889);
                return;
            }
        }
        AppMethodBeat.o(255889);
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onDestroy() {
        com.tencent.mm.plugin.finder.event.base.c cVar;
        AppMethodBeat.i(255891);
        Log.i(TAG, "onDestroy");
        if (getActivity() instanceof FinderHomeUI) {
            e.a aVar = e.vdS;
            bbn dIx = dIx();
            e.c.a aVar2 = e.c.vdX;
            e.a.a(dIx, 0, 9, e.c.vdW, 0, null, 48);
            k kVar = k.vfA;
            String str = this.sGQ;
            if (str == null) {
                str = "";
            }
            k.gS(str, "Exit");
        }
        if (getActivity() instanceof FinderShareFeedRelUI) {
            e.a aVar3 = e.vdS;
            bbn dIx2 = dIx();
            e.c.a aVar4 = e.c.vdX;
            e.a.a(dIx2, 0, 9, e.c.vdW, 0, null, 48);
        }
        if (!this.UVO && (cVar = this.tId) != null) {
            cVar.onRelease();
        }
        com.tencent.mm.plugin.finder.event.base.c cVar2 = this.wzj;
        if (cVar2 != null) {
            cVar2.onRelease();
        }
        com.tencent.mm.plugin.finder.event.base.c cVar3 = this.wzn;
        if (cVar3 != null) {
            cVar3.onRelease();
        }
        com.tencent.mm.plugin.finder.event.base.c cVar4 = this.wzr;
        if (cVar4 != null) {
            cVar4.onRelease();
        }
        as asVar = as.uOL;
        as.stopTimer();
        this.wzA.removeCallbacksAndMessages(null);
        this.wzA.sendEmptyMessage(STOP);
        super.onDestroy();
        AppMethodBeat.o(255891);
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static /* synthetic */ void a(Context context, Intent intent, long j2, int i2, boolean z, int i3) {
            boolean z2 = false;
            AppMethodBeat.i(255864);
            long j3 = (i3 & 4) != 0 ? 0 : j2;
            int i4 = (i3 & 32) != 0 ? 0 : i2;
            if ((i3 & 64) == 0) {
                z2 = z;
            }
            a(context, intent, j3, i4, z2);
            AppMethodBeat.o(255864);
        }

        public static void a(Context context, Intent intent, long j2, int i2, boolean z) {
            AppMethodBeat.i(255863);
            p.h(context, "context");
            p.h(intent, "intent");
            if (context instanceof MMFragmentActivity) {
                com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
                int i3 = ((FinderReporterUIC) com.tencent.mm.ui.component.a.b((AppCompatActivity) context).get(FinderReporterUIC.class)).tCE;
                y yVar = y.vXH;
                if (y.LO(i3)) {
                    com.tencent.mm.ui.component.a aVar2 = com.tencent.mm.ui.component.a.PRN;
                    intent.putExtra("key_comment_scene", ((FinderReporterUIC) com.tencent.mm.ui.component.a.b((AppCompatActivity) context).get(FinderReporterUIC.class)).tyh);
                } else {
                    com.tencent.mm.ui.component.a aVar3 = com.tencent.mm.ui.component.a.PRN;
                    intent.putExtra("key_comment_scene", ((FinderReporterUIC) com.tencent.mm.ui.component.a.b((AppCompatActivity) context).get(FinderReporterUIC.class)).tCE);
                }
                com.tencent.mm.ui.component.a aVar4 = com.tencent.mm.ui.component.a.PRN;
                intent.putExtra("key_context_id", ((FinderReporterUIC) com.tencent.mm.ui.component.a.b((AppCompatActivity) context).get(FinderReporterUIC.class)).sGQ);
                com.tencent.mm.ui.component.a aVar5 = com.tencent.mm.ui.component.a.PRN;
                String str = ((FinderReporterUIC) com.tencent.mm.ui.component.a.b((AppCompatActivity) context).get(FinderReporterUIC.class)).extraInfo;
                if (!Util.isNullOrNil(str)) {
                    intent.putExtra("key_extra_info", str);
                }
                com.tencent.mm.ui.component.a aVar6 = com.tencent.mm.ui.component.a.PRN;
                String str2 = ((FinderReporterUIC) com.tencent.mm.ui.component.a.b((AppCompatActivity) context).get(FinderReporterUIC.class)).sGH;
                if (!Util.isNullOrNil(str2)) {
                    intent.putExtra("key_enter_source_info", str2);
                }
                if (z) {
                    com.tencent.mm.ui.component.a aVar7 = com.tencent.mm.ui.component.a.PRN;
                    int i4 = ((FinderReporterUIC) com.tencent.mm.ui.component.a.b((AppCompatActivity) context).get(FinderReporterUIC.class)).wtW;
                    com.tencent.mm.ui.component.a aVar8 = com.tencent.mm.ui.component.a.PRN;
                    ((FinderReporterUIC) com.tencent.mm.ui.component.a.b((AppCompatActivity) context).get(FinderReporterUIC.class)).sGE = MG(i4);
                    String MG = MG(2);
                    intent.putExtra("key_click_tab_context_id", MG);
                    com.tencent.mm.ui.component.a aVar9 = com.tencent.mm.ui.component.a.PRN;
                    FinderReporterUIC finderReporterUIC = (FinderReporterUIC) com.tencent.mm.ui.component.a.b((AppCompatActivity) context).get(FinderReporterUIC.class);
                    if (finderReporterUIC != null) {
                        bbn dIx = finderReporterUIC.dIx();
                        dIx.sGE = MG;
                        k kVar = k.vfA;
                        k.a(i4, 2, dIx);
                        e MB = finderReporterUIC.MB(i4);
                        if (MB != null && (MB instanceof o)) {
                            e.a aVar10 = e.vdS;
                            ((o) MB).auL(e.a.ah(kotlin.a.ae.e(s.U("feedActionType", 2), s.U("toTab", 2), s.U("fromTab", Integer.valueOf(i4)))));
                        }
                        i.a aVar11 = i.tLi;
                        i.a.a(2, dIx);
                    }
                } else {
                    com.tencent.mm.ui.component.a aVar12 = com.tencent.mm.ui.component.a.PRN;
                    p.g(intent.putExtra("key_click_tab_context_id", ((FinderReporterUIC) com.tencent.mm.ui.component.a.b((AppCompatActivity) context).get(FinderReporterUIC.class)).sGE), "intent.putExtra(Constant….java).clickTabContextId)");
                }
                if (j2 != 0) {
                    p.g(intent.putExtra("key_click_feed_id", j2), "intent.putExtra(Constant…EY_CLICK_FEED_ID, feedId)");
                } else {
                    com.tencent.mm.ui.component.a aVar13 = com.tencent.mm.ui.component.a.PRN;
                    long j3 = ((FinderReporterUIC) com.tencent.mm.ui.component.a.b((AppCompatActivity) context).get(FinderReporterUIC.class)).wyW;
                    if (j3 != 0) {
                        intent.putExtra("key_click_feed_id", j3);
                    }
                }
                com.tencent.mm.ui.component.a aVar14 = com.tencent.mm.ui.component.a.PRN;
                String str3 = ((FinderReporterUIC) com.tencent.mm.ui.component.a.b((AppCompatActivity) context).get(FinderReporterUIC.class)).wyX;
                if (str3 != null) {
                    intent.putExtra("key_click_feed_context_id", str3);
                }
                com.tencent.mm.ui.component.a aVar15 = com.tencent.mm.ui.component.a.PRN;
                int i5 = ((FinderReporterUIC) com.tencent.mm.ui.component.a.b((AppCompatActivity) context).get(FinderReporterUIC.class)).wyZ;
                if (i5 != 0) {
                    intent.putExtra("key_from_profile_share_scene", i5);
                }
                if (i2 != 0) {
                    p.g(intent.putExtra("key_enter_profile_type", i2), "intent.putExtra(Constant…E_TYPE, enterProfileType)");
                    AppMethodBeat.o(255863);
                    return;
                }
                com.tencent.mm.ui.component.a aVar16 = com.tencent.mm.ui.component.a.PRN;
                int i6 = ((FinderReporterUIC) com.tencent.mm.ui.component.a.b((AppCompatActivity) context).get(FinderReporterUIC.class)).wyY;
                if (i6 != 0) {
                    intent.putExtra("key_enter_profile_type", i6);
                }
                AppMethodBeat.o(255863);
                return;
            }
            Log.w(FinderReporterUIC.TAG, "initIntentParams context is not MMFragmentActivity");
            AppMethodBeat.o(255863);
        }

        public static FinderReporterUIC fH(Context context) {
            AppMethodBeat.i(255865);
            p.h(context, "context");
            if (context instanceof MMFragmentActivity) {
                com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
                FinderReporterUIC finderReporterUIC = (FinderReporterUIC) com.tencent.mm.ui.component.a.b((AppCompatActivity) context).get(FinderReporterUIC.class);
                AppMethodBeat.o(255865);
                return finderReporterUIC;
            }
            AppMethodBeat.o(255865);
            return null;
        }

        public static String MG(int i2) {
            String str;
            AppMethodBeat.i(255866);
            String sb = new StringBuilder().append(i2).append('-').append(cl.aWA()).toString();
            String a2 = ((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_finder_all_clicktabid_blacklist, "100");
            switch (i2) {
                case 1:
                    str = "1";
                    break;
                case 2:
                    str = TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL;
                    break;
                case 3:
                    str = AppEventsConstants.EVENT_PARAM_VALUE_NO;
                    break;
                case 4:
                    str = "2";
                    break;
                default:
                    str = "unknown";
                    break;
            }
            Log.i(FinderReporterUIC.TAG, "genClickTabContextId [%s] uiTabIndex[%s] blacklist[%s]", sb, str, a2);
            try {
                p.g(a2, "blacklist");
                for (String str2 : kotlin.n.n.b(a2, new char[]{';'})) {
                    if (p.j(str2, String.valueOf(i2))) {
                        AppMethodBeat.o(255866);
                        return sb;
                    }
                }
            } catch (Exception e2) {
            }
            com.tencent.mm.kernel.e aAh = com.tencent.mm.kernel.g.aAh();
            p.g(aAh, "MMKernel.storage()");
            aAh.azQ().set(ar.a.USERINFO_FINDER_ALL_CLICK_TAB_CONTEXT_ID_STRING, sb);
            AppMethodBeat.o(255866);
            return sb;
        }
    }

    static {
        AppMethodBeat.i(255895);
        AppMethodBeat.o(255895);
    }

    public static final class c extends MMHandler {
        final /* synthetic */ FinderReporterUIC wzD;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(FinderReporterUIC finderReporterUIC, String str) {
            super(str);
            this.wzD = finderReporterUIC;
        }

        @Override // com.tencent.mm.sdk.platformtools.MMHandler
        public final void handleMessage(Message message) {
            AppMethodBeat.i(255868);
            if (message != null) {
                int i2 = message.what;
                if (i2 == FinderReporterUIC.uOE) {
                    FinderReporterUIC.e(this.wzD);
                    sendEmptyMessageDelayed(FinderReporterUIC.uOE, FinderReporterUIC.wzB);
                    AppMethodBeat.o(255868);
                    return;
                }
                if (i2 == FinderReporterUIC.STOP) {
                    FinderReporterUIC.e(this.wzD);
                    removeCallbacksAndMessages(null);
                }
                AppMethodBeat.o(255868);
                return;
            }
            AppMethodBeat.o(255868);
        }
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(255892);
        super.onActivityResult(i2, i3, intent);
        if (i2 == 19999) {
            bbn Mz = Mz(this.wtW);
            k kVar = k.vfA;
            k.a(2, this.wtW, Mz);
        }
        AppMethodBeat.o(255892);
    }

    public static final class b extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ WxRecyclerAdapter uMv;
        final /* synthetic */ FinderReporterUIC wzD;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(FinderReporterUIC finderReporterUIC, WxRecyclerAdapter wxRecyclerAdapter) {
            super(0);
            this.wzD = finderReporterUIC;
            this.uMv = wxRecyclerAdapter;
        }

        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(255867);
            this.wzD.wzz.add(new WeakReference<>(this.uMv));
            Iterator<WeakReference<WxRecyclerAdapter<?>>> it = this.wzD.wzz.iterator();
            p.g(it, "dataAdapterListener.iterator()");
            while (it.hasNext()) {
                if (it.next().get() == null) {
                    it.remove();
                }
            }
            x xVar = x.SXb;
            AppMethodBeat.o(255867);
            return xVar;
        }
    }

    public static /* synthetic */ com.tencent.mm.plugin.finder.event.a b(FinderReporterUIC finderReporterUIC) {
        AppMethodBeat.i(255877);
        if (finderReporterUIC.dIs()) {
            int i2 = finderReporterUIC.wtW;
            Log.i(TAG, "getHomeFeedEventSubscriber ".concat(String.valueOf(i2)));
            switch (i2) {
                case 1:
                    com.tencent.mm.plugin.finder.event.a aVar = finderReporterUIC.wzo;
                    AppMethodBeat.o(255877);
                    return aVar;
                case 2:
                default:
                    com.tencent.mm.plugin.finder.event.a aVar2 = finderReporterUIC.wzc;
                    AppMethodBeat.o(255877);
                    return aVar2;
                case 3:
                    com.tencent.mm.plugin.finder.event.a aVar3 = finderReporterUIC.wzk;
                    AppMethodBeat.o(255877);
                    return aVar3;
                case 4:
                    com.tencent.mm.plugin.finder.event.a aVar4 = finderReporterUIC.wzs;
                    AppMethodBeat.o(255877);
                    return aVar4;
            }
        } else {
            com.tencent.mm.plugin.finder.event.a aVar5 = finderReporterUIC.wzc;
            AppMethodBeat.o(255877);
            return aVar5;
        }
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final boolean onBackPressed() {
        AppMethodBeat.i(255890);
        e MB = MB(-1);
        if (MB != null && (MB instanceof o) && !(getActivity() instanceof FinderHomeUI)) {
            e.a aVar = e.vdS;
            ((o) MB).auL(e.a.ah(kotlin.a.ae.b(s.U("feedActionType", 5))));
        }
        boolean onBackPressed = super.onBackPressed();
        AppMethodBeat.o(255890);
        return onBackPressed;
    }

    public static final /* synthetic */ void e(FinderReporterUIC finderReporterUIC) {
        ac acVar;
        AppMethodBeat.i(255896);
        if (finderReporterUIC.dIs()) {
            o oVar = finderReporterUIC.wzm;
            if (oVar != null) {
                oVar.dnM();
            }
            o oVar2 = finderReporterUIC.wzq;
            if (oVar2 != null) {
                oVar2.dnM();
            }
            g gVar = finderReporterUIC.wzu;
            if (gVar != null) {
                gVar.dnM();
                AppMethodBeat.o(255896);
                return;
            }
            AppMethodBeat.o(255896);
        } else if (finderReporterUIC.dIt()) {
            o oVar3 = finderReporterUIC.wze;
            if (oVar3 != null) {
                oVar3.dnM();
                AppMethodBeat.o(255896);
                return;
            }
            AppMethodBeat.o(255896);
        } else if (finderReporterUIC.dIu()) {
            v vVar = finderReporterUIC.wzh;
            if (vVar != null) {
                vVar.dnM();
                AppMethodBeat.o(255896);
                return;
            }
            AppMethodBeat.o(255896);
        } else if (finderReporterUIC.dIv()) {
            ae aeVar = finderReporterUIC.wzf;
            if (aeVar != null) {
                aeVar.dnM();
                AppMethodBeat.o(255896);
                return;
            }
            AppMethodBeat.o(255896);
        } else if (!finderReporterUIC.dIw() || (acVar = finderReporterUIC.wzi) == null) {
            AppMethodBeat.o(255896);
        } else {
            acVar.dnM();
            AppMethodBeat.o(255896);
        }
    }
}

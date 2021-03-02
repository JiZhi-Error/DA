package com.tencent.mm.plugin.brandservice.ui.timeline;

import android.content.Intent;
import android.content.res.Configuration;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Looper;
import android.os.MessageQueue;
import android.os.Process;
import android.text.TextUtils;
import android.util.Base64;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.data.APMidasPluginInfo;
import com.tencent.mm.R;
import com.tencent.mm.ag.v;
import com.tencent.mm.ak.aa;
import com.tencent.mm.ak.d;
import com.tencent.mm.al.ag;
import com.tencent.mm.api.q;
import com.tencent.mm.av.a.a.c;
import com.tencent.mm.br.c;
import com.tencent.mm.g.a.l;
import com.tencent.mm.g.a.w;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.kernel.i;
import com.tencent.mm.model.ad;
import com.tencent.mm.model.p;
import com.tencent.mm.plugin.appbrand.jsapi.video.AppBrandVideoView;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.service.r;
import com.tencent.mm.plugin.bizui.a.a;
import com.tencent.mm.plugin.bizui.widget.StoryListView;
import com.tencent.mm.plugin.brandservice.b.k;
import com.tencent.mm.plugin.brandservice.ui.timeline.a.b;
import com.tencent.mm.plugin.brandservice.ui.timeline.b;
import com.tencent.mm.plugin.brandservice.ui.timeline.offenread.BizTimeLineHotView;
import com.tencent.mm.plugin.brandservice.ui.timeline.video.MPVideoPreviewMgr;
import com.tencent.mm.plugin.brandservice.ui.timeline.video.util.o;
import com.tencent.mm.plugin.webcanvas.f;
import com.tencent.mm.plugin.webcanvas.g;
import com.tencent.mm.plugin.webcanvas.h;
import com.tencent.mm.plugin.webcanvas.m;
import com.tencent.mm.plugin.websearch.api.ai;
import com.tencent.mm.plugin.websearch.api.ak;
import com.tencent.mm.pluginsdk.model.a;
import com.tencent.mm.pluginsdk.ui.a;
import com.tencent.mm.pluginsdk.ui.applet.u;
import com.tencent.mm.protocal.protobuf.cuq;
import com.tencent.mm.protocal.protobuf.cur;
import com.tencent.mm.protocal.protobuf.cus;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.ScreenShotUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aa;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.ca;
import com.tencent.mm.storage.y;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.chatting.aq;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

@i
public class BizTimeLineUI extends MMActivity implements g, g, ScreenShotUtil.ScreenShotCallback {
    private static String psS = null;
    private static int psT = 0;
    private static int psU = 0;
    private int dEb;
    private boolean dLD = false;
    private TextView emptyTipTv;
    private int gsi;
    private View kgo;
    private int mScrollState = 0;
    private long ofm = 0;
    private f pqZ;
    private BizTimeLineHotView prb;
    public StoryListView psJ;
    private View psK;
    private ImageView psL;
    private LinearLayout psM;
    private TextView psN;
    private TextView psO;
    private View psP;
    private b psQ;
    private d psR;
    private b psV;
    private long psW = 0;
    private boolean psX = false;
    private boolean psY = false;
    private boolean psZ = false;
    private View psf;
    private long pss = 0;
    private int pta = 0;
    private int ptb = -1;
    private int ptc = -1;
    private boolean ptd = false;
    private HashSet<String> pte = new HashSet<>();
    private final Set<h> ptf = Collections.newSetFromMap(new ConcurrentHashMap());
    private final Set<f> ptg = Collections.newSetFromMap(new ConcurrentHashMap());
    private aa.c pth = new aa.c() {
        /* class com.tencent.mm.plugin.brandservice.ui.timeline.BizTimeLineUI.AnonymousClass12 */

        @Override // com.tencent.mm.storage.aa.c
        public final void a(Object obj, aa.a aVar) {
            AppMethodBeat.i(5955);
            BizTimeLineUI.this.cmA();
            AppMethodBeat.o(5955);
        }
    };
    private IListener pti = new IListener<w>() {
        /* class com.tencent.mm.plugin.brandservice.ui.timeline.BizTimeLineUI.AnonymousClass15 */

        {
            AppMethodBeat.i(160485);
            this.__eventId = w.class.getName().hashCode();
            AppMethodBeat.o(160485);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(w wVar) {
            AppMethodBeat.i(5957);
            Log.i("MicroMsg.BizTimeLineUI", "AppMsgRelatedInfoUpdateEvent scene %d", Integer.valueOf(wVar.dCO.scene));
            if (BizTimeLineUI.this.psQ != null && !BizTimeLineUI.this.isFinishing()) {
                BizTimeLineUI.this.psQ.notifyDataSetChanged();
            }
            AppMethodBeat.o(5957);
            return false;
        }
    };
    private int ptj = 0;
    private final int ptk = 20;
    private long ptl = 0;
    private final long ptm = 100;
    private boolean ptn = false;
    private boolean pto = false;
    private IListener ptp = new IListener<l>() {
        /* class com.tencent.mm.plugin.brandservice.ui.timeline.BizTimeLineUI.AnonymousClass11 */

        {
            AppMethodBeat.i(194941);
            this.__eventId = l.class.getName().hashCode();
            AppMethodBeat.o(194941);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(l lVar) {
            AppMethodBeat.i(194942);
            l lVar2 = lVar;
            if (!(lVar2 == null || lVar2.dCi == null || lVar2.dCi.isActive)) {
                BizTimeLineUI.this.pss = 0;
            }
            AppMethodBeat.o(194942);
            return false;
        }
    };
    private com.tencent.mm.pluginsdk.ui.span.i ptq = new com.tencent.mm.pluginsdk.ui.span.i() {
        /* class com.tencent.mm.plugin.brandservice.ui.timeline.BizTimeLineUI.AnonymousClass13 */

        @Override // com.tencent.mm.pluginsdk.ui.span.i
        public final Object a(u uVar) {
            return null;
        }

        @Override // com.tencent.mm.pluginsdk.ui.span.i
        public final Object b(u uVar) {
            ad.b JV;
            AppMethodBeat.i(194943);
            if (uVar.type == 45) {
                String str = new String(Base64.decode(uVar.url, 0));
                String str2 = new String(Base64.decode(Util.nullAs((String) uVar.ba(String.class), ""), 0));
                Log.d("MicroMsg.BizTimeLineUI", "appId:%s,path:%s", str, str2);
                AppBrandStatObject appBrandStatObject = new AppBrandStatObject();
                appBrandStatObject.scene = 1082;
                String str3 = uVar.mSessionId;
                if (!Util.isNullOrNil(str3) && (JV = ad.aVe().JV(str3)) != null) {
                    appBrandStatObject.dCw = JV.getString("preUsername", null) + "|3";
                }
                ((r) com.tencent.mm.kernel.g.af(r.class)).a(BizTimeLineUI.this.getContext(), (String) null, str, 0, 0, str2, appBrandStatObject);
            }
            AppMethodBeat.o(194943);
            return null;
        }
    };
    private int source = 1;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public BizTimeLineUI() {
        AppMethodBeat.i(5965);
        AppMethodBeat.o(5965);
    }

    static /* synthetic */ void a(BizTimeLineUI bizTimeLineUI, int i2, int i3) {
        AppMethodBeat.i(5987);
        bizTimeLineUI.fd(i2, i3);
        AppMethodBeat.o(5987);
    }

    static /* synthetic */ void a(BizTimeLineUI bizTimeLineUI, z zVar) {
        AppMethodBeat.i(194961);
        bizTimeLineUI.i(zVar);
        AppMethodBeat.o(194961);
    }

    static /* synthetic */ void a(BizTimeLineUI bizTimeLineUI, z zVar, int i2) {
        AppMethodBeat.i(194962);
        bizTimeLineUI.g(zVar, i2);
        AppMethodBeat.o(194962);
    }

    static /* synthetic */ int k(BizTimeLineUI bizTimeLineUI) {
        int i2 = bizTimeLineUI.ptj;
        bizTimeLineUI.ptj = i2 + 1;
        return i2;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        List<z> ajT;
        final List<z> list;
        AppMethodBeat.i(5966);
        ab.AK(true);
        com.tencent.mm.plugin.brandservice.b.b.init();
        super.onCreate(bundle);
        this.emptyTipTv = (TextView) $(R.id.c30);
        this.emptyTipTv.setText(R.string.aht);
        this.psR = new d(this);
        EventCenter.instance.addListener(this.psR.lEl);
        this.dEb = (int) (System.currentTimeMillis() / 1000);
        this.source = getIntent().getIntExtra("biz_enter_source", 1);
        this.pss = System.currentTimeMillis();
        this.pqZ = new f(this.dEb, this.pss);
        this.psV = new b(this, this.pqZ);
        ab.DU(this.dEb);
        o oVar = o.pLS;
        o.DU(this.dEb);
        setTitleBarDoubleClickListener(new Runnable() {
            /* class com.tencent.mm.plugin.brandservice.ui.timeline.BizTimeLineUI.AnonymousClass5 */

            public final void run() {
                AppMethodBeat.i(194937);
                if (BizTimeLineUI.this.activityHasDestroyed() || BizTimeLineUI.this.isFinishing()) {
                    AppMethodBeat.o(194937);
                    return;
                }
                BizTimeLineUI.p(BizTimeLineUI.this);
                AppMethodBeat.o(194937);
            }
        });
        a aVar = a.pfC;
        boolean ckz = a.ckz();
        boolean Vu = ((q) com.tencent.mm.kernel.g.af(q.class)).Vu();
        Log.i("MicroMsg.BizTimeLineUI", "open search entrance:%b, isBizTeenModeAllowAll: %b", Boolean.valueOf(ckz), Boolean.valueOf(Vu));
        if (ckz && Vu) {
            addIconOptionMenu(0, R.string.hpa, R.raw.actionbar_icon_dark_search, new MenuItem.OnMenuItemClickListener() {
                /* class com.tencent.mm.plugin.brandservice.ui.timeline.BizTimeLineUI.AnonymousClass2 */

                public final boolean onMenuItemClick(MenuItem menuItem) {
                    AppMethodBeat.i(5945);
                    if (ai.afs(0)) {
                        Intent fXX = ai.fXX();
                        fXX.putExtra("title", BizTimeLineUI.this.getString(R.string.dkg));
                        fXX.putExtra("searchbar_tips", BizTimeLineUI.this.getString(R.string.dkg));
                        fXX.putExtra("KRightBtn", true);
                        fXX.putExtra("ftsneedkeyboard", true);
                        fXX.putExtra("publishIdPrefix", "bs");
                        fXX.putExtra("ftsType", 2);
                        fXX.putExtra("ftsbizscene", 11);
                        Map<String, String> h2 = ai.h(11, true, 2);
                        String afq = ai.afq(Util.safeParseInt(h2.get("scene")));
                        h2.put("sessionId", afq);
                        fXX.putExtra("sessionId", afq);
                        fXX.putExtra("rawUrl", ai.bd(h2));
                        fXX.putExtra("key_load_js_without_delay", true);
                        fXX.addFlags(67108864);
                        String aXg = ak.aXg("bizAccountTopSearch");
                        if (!TextUtils.isEmpty(aXg)) {
                            fXX.putExtra("key_search_input_hint", aXg);
                        }
                        c.b(MMApplicationContext.getContext(), "webview", ".ui.tools.fts.FTSSearchTabWebViewUI", fXX);
                    } else {
                        Log.e("MicroMsg.BizTimeLineUI", "fts h5 template not avail");
                    }
                    AppMethodBeat.o(5945);
                    return true;
                }
            });
        }
        addIconOptionMenu(1, R.string.air, R.raw.actionbar_menu_list_icon, new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.brandservice.ui.timeline.BizTimeLineUI.AnonymousClass3 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(5946);
                Intent intent = new Intent();
                intent.addFlags(67108864);
                intent.putExtra("biz_from_scene", 2);
                intent.putExtra("biz_time_line_line_session_id", BizTimeLineUI.this.dEb);
                intent.putExtra("biz_enter_source", BizTimeLineUI.this.source);
                c.f(BizTimeLineUI.this, ".ui.conversation.NewBizConversationUI", intent);
                BizTimeLineUI.this.pqZ.Dg(7);
                BizTimeLineUI.this.psX = true;
                AppMethodBeat.o(5946);
                return true;
            }
        }, new View.OnLongClickListener() {
            /* class com.tencent.mm.plugin.brandservice.ui.timeline.BizTimeLineUI.AnonymousClass4 */

            public final boolean onLongClick(View view) {
                AppMethodBeat.i(194936);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineUI$12", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, bVar.axR());
                com.tencent.mm.plugin.biz.b.c cVar = com.tencent.mm.plugin.biz.b.c.pfv;
                if (((Boolean) com.tencent.mm.plugin.biz.b.c.pfr.getValue()).booleanValue()) {
                    BizTimeLineUI bizTimeLineUI = BizTimeLineUI.this;
                    com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(new Intent(BizTimeLineUI.this, BizTestUI.class));
                    com.tencent.mm.hellhoundlib.a.a.a(bizTimeLineUI, bl.axQ(), "com/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineUI$12", "onLongClick", "(Landroid/view/View;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    bizTimeLineUI.startActivity((Intent) bl.pG(0));
                    com.tencent.mm.hellhoundlib.a.a.a(bizTimeLineUI, "com/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineUI$12", "onLongClick", "(Landroid/view/View;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                }
                com.tencent.mm.hellhoundlib.a.a.a(false, (Object) this, "com/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineUI$12", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
                AppMethodBeat.o(194936);
                return false;
            }
        });
        setMMTitle(R.string.aix);
        setMMTitleColor(getContext().getResources().getColor(R.color.FG_0));
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.brandservice.ui.timeline.BizTimeLineUI.AnonymousClass6 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(194938);
                BizTimeLineUI.this.finish();
                AppMethodBeat.o(194938);
                return true;
            }
        }, R.raw.actionbar_icon_dark_back);
        this.psK = getLayoutInflater().inflate(R.layout.jq, (ViewGroup) null);
        this.psO = (TextView) this.psK.findViewById(R.id.a96);
        this.psO.setTextSize(1, 14.0f);
        this.psP = this.psK.findViewById(R.id.a95);
        View customView = getController().mActionBar.getCustomView();
        if (customView instanceof LinearLayout) {
            ((LinearLayout) customView).addView(this.psK);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.psK.getLayoutParams();
            layoutParams.width = -1;
            layoutParams.weight = 1.0f;
            layoutParams.gravity = 16;
            this.psK.setLayoutParams(layoutParams);
        } else if (customView instanceof RelativeLayout) {
            ((RelativeLayout) customView).addView(this.psK);
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.psK.getLayoutParams();
            layoutParams2.width = -1;
            layoutParams2.addRule(15);
            this.psK.setLayoutParams(layoutParams2);
        }
        this.psP.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.brandservice.ui.timeline.BizTimeLineUI.AnonymousClass7 */

            public final void onClick(View view) {
                AppMethodBeat.i(194939);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineUI$15", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                BizTimeLineUI.p(BizTimeLineUI.this);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineUI$15", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(194939);
            }
        });
        this.psK.setVisibility(8);
        this.psJ = (StoryListView) $(R.id.a8k);
        StoryListView storyListView = this.psJ;
        this.psf = getLayoutInflater().inflate(R.layout.jt, (ViewGroup) null);
        storyListView.addFooterView(this.psf);
        StoryListView storyListView2 = this.psJ;
        this.kgo = getLayoutInflater().inflate(R.layout.ju, (ViewGroup) null);
        this.prb = (BizTimeLineHotView) this.kgo.findViewById(R.id.a7v);
        storyListView2.addHeaderView(this.kgo);
        final int i2 = psU;
        final int intExtra = getIntent().getIntExtra("Main_UnreadCount", 0);
        this.psY = ab.gBb();
        this.psZ = ab.bD(intExtra, this.psY);
        if (this.psZ) {
            list = ag.ban().MO(ab.NQU);
            com.tencent.mm.plugin.brandservice.ui.b.c.cM(list);
        } else {
            if (ab.gBd()) {
                aa ban = ag.ban();
                int min = Math.min(p.aTH(), 10);
                ajT = aa.o(ban.iFy.query("BizTimeLineInfo", null, "orderFlag>=?", new String[]{String.valueOf(ban.gAS() << 32)}, null, null, "orderFlag DESC limit ".concat(String.valueOf(min))));
            } else {
                ajT = ag.ban().ajT(10);
            }
            LinkedList linkedList = new LinkedList();
            linkedList.addAll(ajT);
            com.tencent.mm.plugin.brandservice.ui.b.c.cP(linkedList);
            com.tencent.mm.plugin.brandservice.ui.b.c.a(linkedList, (Runnable) null);
            list = ajT;
        }
        Log.i("MicroMsg.BizTimeLineUI", "initListView keepPos %b, keepData %b", Boolean.valueOf(this.psY), Boolean.valueOf(this.psZ));
        this.psQ = new b(this, list, this.psY, this.psZ, this.pqZ, this.prb);
        this.pqZ.psq = cmG();
        this.psM = (LinearLayout) $(R.id.fxc);
        this.psN = (TextView) $(R.id.fxd);
        this.psL = (ImageView) $(R.id.fxb);
        cmA();
        this.psM.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.brandservice.ui.timeline.BizTimeLineUI.AnonymousClass1 */

            public final void onClick(View view) {
                int i2;
                AppMethodBeat.i(5944);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                String str = "";
                z gBn = ag.bap().gBn();
                if (gBn != null) {
                    str = com.tencent.mm.storage.ag.I(gBn);
                    i2 = com.tencent.mm.storage.ag.f(gBn);
                } else {
                    i2 = 0;
                }
                com.tencent.mm.plugin.report.service.h.INSTANCE.a(15721, str, "", 12, -1, Integer.valueOf(BizTimeLineUI.this.pqZ.dEb), "", "", "", 0, "", "", "", "", "", "", "", "", "", Integer.valueOf(i2));
                BizTimeLineUI.this.pqZ.l(i2, str, 1);
                Intent intent = new Intent(BizTimeLineUI.this.getContext(), BizTimeLineNewMsgUI.class);
                intent.putExtra("biz_time_line_line_session_id", BizTimeLineUI.this.dEb);
                intent.putExtra("biz_time_line_line_enter_scene", 1);
                BizTimeLineUI bizTimeLineUI = BizTimeLineUI.this;
                com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                com.tencent.mm.hellhoundlib.a.a.a(bizTimeLineUI, bl.axQ(), "com/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineUI$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                bizTimeLineUI.startActivity((Intent) bl.pG(0));
                com.tencent.mm.hellhoundlib.a.a.a(bizTimeLineUI, "com/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineUI$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(5944);
            }
        });
        this.psJ.setAdapter((ListAdapter) this.psQ);
        this.psJ.setFooterDividersEnabled(false);
        this.psJ.setOnScrollListener(new AbsListView.OnScrollListener() {
            /* class com.tencent.mm.plugin.brandservice.ui.timeline.BizTimeLineUI.AnonymousClass16 */

            public final void onScrollStateChanged(AbsListView absListView, int i2) {
                AppMethodBeat.i(194945);
                BizTimeLineUI.this.mScrollState = i2;
                if (i2 == 2) {
                    BizTimeLineUI.this.gsi = WXHardCoderJNI.startPerformance(WXHardCoderJNI.hcBizEnable, WXHardCoderJNI.hcBizDelay, WXHardCoderJNI.hcBizCPU, WXHardCoderJNI.hcBizIO, WXHardCoderJNI.hcBizThr ? Process.myTid() : 0, WXHardCoderJNI.hcBizTimeout, 903, WXHardCoderJNI.hcBizAction, "MicroMsg.BizTimeLineUI");
                    Log.i("MicroMsg.BizTimeLineUI", "summer hardcoder biz startPerformance [%s] [%s]", 903, Integer.valueOf(BizTimeLineUI.this.gsi));
                }
                Iterator it = BizTimeLineUI.this.ptf.iterator();
                while (it.hasNext()) {
                    it.next();
                }
                com.tencent.mm.plugin.brandservice.ui.b.a.crg();
                com.tencent.mm.av.q.bcV().onScrollStateChanged(i2);
                if (i2 == 0 || i2 == 1) {
                    com.tencent.mm.pluginsdk.model.a aVar = com.tencent.mm.pluginsdk.model.a.JUl;
                    if (com.tencent.mm.pluginsdk.model.a.JUj) {
                        com.tencent.mm.pluginsdk.model.a.v(new a.h(System.currentTimeMillis()));
                    }
                } else {
                    com.tencent.mm.pluginsdk.model.a aVar2 = com.tencent.mm.pluginsdk.model.a.JUl;
                    if (!com.tencent.mm.pluginsdk.model.a.JUj) {
                        com.tencent.mm.pluginsdk.model.a.v(new a.l(System.currentTimeMillis()));
                    }
                }
                if (i2 == 0) {
                    BizTimeLineUI.this.psQ.fc(BizTimeLineUI.this.psJ.getFirstVisiblePosition() - BizTimeLineUI.this.psJ.getHeaderViewsCount(), BizTimeLineUI.this.psJ.getLastVisiblePosition());
                    MPVideoPreviewMgr.pJz.a("idle", BizTimeLineUI.this.psJ, BizTimeLineUI.this.psQ);
                }
                AppMethodBeat.o(194945);
            }

            public final void onScroll(AbsListView absListView, int i2, int i3, int i4) {
                AppMethodBeat.i(194946);
                for (h hVar : BizTimeLineUI.this.ptf) {
                    hVar.cmV();
                }
                BizTimeLineUI.a(BizTimeLineUI.this, i2, (i2 + i3) - 1);
                com.tencent.mm.pluginsdk.ui.applet.g gVar = com.tencent.mm.pluginsdk.ui.applet.g.Kev;
                if (com.tencent.mm.pluginsdk.ui.applet.g.aig(1)) {
                    BizTimeLineUI.b(BizTimeLineUI.this, i2, (i2 + i3) - 1);
                }
                int unused = BizTimeLineUI.psU = i2;
                f fVar = BizTimeLineUI.this.pqZ;
                int i5 = BizTimeLineUI.psU;
                if (fVar.psw != null) {
                    if (i5 == 0 && fVar.psw.psH != i5) {
                        fVar.psw.psE++;
                    }
                    fVar.psw.psH = i5;
                }
                AppMethodBeat.o(194946);
            }
        });
        this.psJ.setOnTouchListener(new View.OnTouchListener() {
            /* class com.tencent.mm.plugin.brandservice.ui.timeline.BizTimeLineUI.AnonymousClass17 */

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                AppMethodBeat.i(194947);
                BizTimeLineUI.this.ptd = true;
                AppMethodBeat.o(194947);
                return false;
            }
        });
        this.psJ.setEmptyView(this.emptyTipTv);
        this.psJ.postDelayed(new Runnable() {
            /* class com.tencent.mm.plugin.brandservice.ui.timeline.BizTimeLineUI.AnonymousClass18 */

            public final void run() {
                AppMethodBeat.i(5961);
                if (!BizTimeLineUI.this.psY) {
                    BizTimeLineUI.a(BizTimeLineUI.this, BizTimeLineUI.this.psJ.getFirstVisiblePosition(), BizTimeLineUI.this.psJ.getLastVisiblePosition());
                } else if (i2 != 0) {
                    BizTimeLineUI.i(BizTimeLineUI.this);
                    BizTimeLineUI.this.cmC();
                } else {
                    BizTimeLineUI.a(BizTimeLineUI.this, BizTimeLineUI.this.psQ.De(0));
                }
                if (!Util.isNullOrNil(list)) {
                    com.tencent.mm.plugin.brandservice.b.a("BrandServiceWorkerThread", new Runnable(((z) list.get(0)).field_orderFlag, BizTimeLineUI.this.source, BizTimeLineUI.this.getIntent().getIntExtra("Main_IndexInSessionList", 0)) {
                        /* class com.tencent.mm.plugin.brandservice.ui.timeline.f.AnonymousClass3 */
                        final /* synthetic */ int psA;
                        final /* synthetic */ int psB;
                        final /* synthetic */ long psz;

                        {
                            this.psz = r2;
                            this.psA = r4;
                            this.psB = r5;
                        }

                        public final void run() {
                            int i2;
                            int i3;
                            int i4;
                            String str;
                            z R;
                            int i5;
                            AppMethodBeat.i(5932);
                            Cursor rawQuery = ag.ban().iFy.rawQuery("SELECT count(*) FROM BizTimeLineInfo where orderFlag >= ".concat(String.valueOf(this.psz & -4294967296L)), null);
                            if (rawQuery.moveToFirst()) {
                                i2 = rawQuery.getInt(0);
                            } else {
                                i2 = 0;
                            }
                            rawQuery.close();
                            int MR = ag.ban().MR(this.psz);
                            Cursor rawQuery2 = ag.ban().iFy.rawQuery("SELECT count(*) FROM BizTimeLineInfo where orderFlag >= " + (this.psz & -4294967296L) + " and placeTop = 1 ", null);
                            if (rawQuery2.moveToFirst()) {
                                i3 = rawQuery2.getInt(0);
                            } else {
                                i3 = 0;
                            }
                            rawQuery2.close();
                            int ctM = ag.bap().ctM();
                            ag.bap().gAM();
                            long j2 = 0;
                            int i6 = 0;
                            MultiProcessMMKV singleMMKV = MultiProcessMMKV.getSingleMMKV("brandService");
                            if (singleMMKV != null) {
                                long decodeLong = singleMMKV.decodeLong("BizLastMsgId", 0);
                                if (decodeLong > 0) {
                                    ca Hb = ((com.tencent.mm.plugin.messenger.foundation.a.l) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).eiy().Hb(decodeLong);
                                    str = Hb.field_talker;
                                    if (ag.ban().R(decodeLong, "msgId") != null) {
                                        i5 = 1;
                                    } else {
                                        i5 = 2;
                                    }
                                    if (Hb.gAt()) {
                                        try {
                                            com.tencent.mm.ag.u a2 = ((com.tencent.mm.plugin.biz.a.a) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.biz.a.a.class)).a(Hb.field_msgId, Hb.field_content);
                                            if (a2 != null && !Util.isNullOrNil(a2.iAd)) {
                                                v vVar = (v) a2.iAd.get(0);
                                                if (!Util.isNullOrNil(vVar.url)) {
                                                    j2 = Util.getLong(Uri.parse(vVar.url).getQueryParameter("mid"), 0);
                                                }
                                            }
                                            i4 = 0;
                                            i6 = i5;
                                        } catch (UnsupportedOperationException e2) {
                                            Log.w("MicroMsg.BizTimeLineReport", "reportEnterBiz exp %s", e2.getMessage());
                                            i4 = 0;
                                            i6 = i5;
                                        } catch (Exception e3) {
                                            Log.w("MicroMsg.BizTimeLineReport", "reportEnterBiz exp %s", e3.getMessage());
                                        }
                                    }
                                    i4 = 0;
                                    i6 = i5;
                                } else if (decodeLong < 0 && (R = ag.bap().R(decodeLong, "msgId")) != null && R.gAx()) {
                                    String I = com.tencent.mm.storage.ag.I(R);
                                    i4 = com.tencent.mm.storage.ag.f(R);
                                    Log.i("MicroMsg.BizTimeLineReport", "BizTimeLineReport dyeing template enterUserName = %s, msgType = %s", I, Integer.valueOf(i4));
                                    str = I;
                                    i6 = 2;
                                }
                                com.tencent.mm.plugin.biz.b.a aVar = com.tencent.mm.plugin.biz.b.a.pfl;
                                com.tencent.mm.plugin.biz.b.a aVar2 = com.tencent.mm.plugin.biz.b.a.pfl;
                                kotlin.o<String, String> a3 = com.tencent.mm.plugin.biz.b.a.a(com.tencent.mm.plugin.biz.b.a.ckr());
                                com.tencent.mm.plugin.report.service.h.INSTANCE.a(11404, 1, Integer.valueOf(i2), Integer.valueOf(MR), Integer.valueOf(i3), Integer.valueOf(ctM), Integer.valueOf(f.this.dEb), Integer.valueOf(f.this.dEb), Integer.valueOf(this.psA), str, Long.valueOf(j2), Integer.valueOf(this.psB), Integer.valueOf(i6), 0, Integer.valueOf(i4), a3.first, a3.second);
                                Log.i("MicroMsg.BizTimeLineReport", "reportEnterBiz %d,%d,%d,%d,%d,%d,%d,%s,%d,%d,%d,%d", Integer.valueOf(i2), Integer.valueOf(MR), Integer.valueOf(i3), Integer.valueOf(ctM), Integer.valueOf(f.this.dEb), Integer.valueOf(f.this.dEb), Integer.valueOf(this.psA), str, Long.valueOf(j2), Integer.valueOf(this.psB), Integer.valueOf(i6), 0);
                                AppMethodBeat.o(5932);
                            }
                            i4 = 0;
                            str = "";
                            com.tencent.mm.plugin.biz.b.a aVar3 = com.tencent.mm.plugin.biz.b.a.pfl;
                            com.tencent.mm.plugin.biz.b.a aVar22 = com.tencent.mm.plugin.biz.b.a.pfl;
                            kotlin.o<String, String> a32 = com.tencent.mm.plugin.biz.b.a.a(com.tencent.mm.plugin.biz.b.a.ckr());
                            com.tencent.mm.plugin.report.service.h.INSTANCE.a(11404, 1, Integer.valueOf(i2), Integer.valueOf(MR), Integer.valueOf(i3), Integer.valueOf(ctM), Integer.valueOf(f.this.dEb), Integer.valueOf(f.this.dEb), Integer.valueOf(this.psA), str, Long.valueOf(j2), Integer.valueOf(this.psB), Integer.valueOf(i6), 0, Integer.valueOf(i4), a32.first, a32.second);
                            Log.i("MicroMsg.BizTimeLineReport", "reportEnterBiz %d,%d,%d,%d,%d,%d,%d,%s,%d,%d,%d,%d", Integer.valueOf(i2), Integer.valueOf(MR), Integer.valueOf(i3), Integer.valueOf(ctM), Integer.valueOf(f.this.dEb), Integer.valueOf(f.this.dEb), Integer.valueOf(this.psA), str, Long.valueOf(j2), Integer.valueOf(this.psB), Integer.valueOf(i6), 0);
                            AppMethodBeat.o(5932);
                        }
                    }, 0);
                }
                MMHandlerThread.postToMainThreadDelayed(new Runnable() {
                    /* class com.tencent.mm.plugin.brandservice.ui.timeline.BizTimeLineUI.AnonymousClass18.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(194948);
                        MPVideoPreviewMgr.pJz.a(APMidasPluginInfo.LAUNCH_INTERFACE_INIT, BizTimeLineUI.this.psJ, BizTimeLineUI.this.psQ);
                        AppMethodBeat.o(194948);
                    }
                }, 100);
                AppMethodBeat.o(5961);
            }
        }, 10);
        this.psJ.addOnLayoutChangeListener(new View.OnLayoutChangeListener() {
            /* class com.tencent.mm.plugin.brandservice.ui.timeline.BizTimeLineUI.AnonymousClass19 */

            public final void onLayoutChange(View view, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
                AppMethodBeat.i(5962);
                BizTimeLineUI.this.psQ.fc(BizTimeLineUI.this.psJ.getFirstVisiblePosition() - BizTimeLineUI.this.psJ.getHeaderViewsCount(), BizTimeLineUI.this.psJ.getLastVisiblePosition());
                BizTimeLineUI.this.psJ.removeOnLayoutChangeListener(this);
                AppMethodBeat.o(5962);
            }
        });
        ag.bap().a(this.pth, Looper.getMainLooper());
        new c();
        Log.d("MicroMsg.BizTimeLineMigrateImp", "migrateOldList");
        int intValue = ((Integer) com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.USERINFO_BIZ_TIME_LINE_MIGRATE_DATA_INT_SYNC, (Object) 0)).intValue();
        if ((intValue & 4) == 0) {
            ((com.tencent.mm.plugin.messenger.foundation.a.l) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aST().bkb("officialaccounts");
            com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.USERINFO_BIZ_TIME_LINE_MIGRATE_DATA_INT_SYNC, Integer.valueOf(intValue | 4));
        }
        Looper.myQueue().addIdleHandler(new MessageQueue.IdleHandler() {
            /* class com.tencent.mm.plugin.brandservice.ui.timeline.BizTimeLineUI.AnonymousClass20 */

            public final boolean queueIdle() {
                AppMethodBeat.i(5963);
                Looper.myQueue().removeIdleHandler(this);
                z cmp = BizTimeLineUI.this.psQ != null ? BizTimeLineUI.this.psQ.cmp() : null;
                if (cmp != null) {
                    ag.ban().MV(cmp.field_orderFlag);
                } else {
                    ag.ban().gAQ();
                }
                AppMethodBeat.o(5963);
                return false;
            }
        });
        com.tencent.mm.pluginsdk.h.r(this);
        EventCenter.instance.addListener(this.ptp);
        this.pti.alive();
        if (((com.tencent.mm.plugin.brandservice.a.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.brandservice.a.b.class)).CR(1)) {
            ((com.tencent.mm.plugin.brandservice.a.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.brandservice.a.b.class)).CS(90);
        }
        aa ban2 = ag.ban();
        if (ban2.NQv) {
            ban2.NQv = false;
            com.tencent.f.h.RTc.a(new Runnable() {
                /* class com.tencent.mm.storage.aa.AnonymousClass3 */

                public final void run() {
                    AppMethodBeat.i(124611);
                    if (aa.NQs != null && aa.NQs.length > 0) {
                        Log.d("MicroMsg.BizTimeLineInfoStorage", "createIndexIfNeed start");
                        ArrayList<IDKey> arrayList = new ArrayList<>();
                        for (int i2 = 0; i2 < aa.NQs.length; i2++) {
                            long currentTimeMillis = System.currentTimeMillis();
                            aa.this.iFy.execSQL("BizTimeLineInfo", aa.NQs[i2]);
                            int currentTimeMillis2 = (int) ((System.currentTimeMillis() - currentTimeMillis) / 1000);
                            IDKey iDKey = new IDKey();
                            iDKey.SetID(1049);
                            iDKey.SetKey(aa.ajY(currentTimeMillis2));
                            iDKey.SetValue(1);
                            arrayList.add(iDKey);
                        }
                        com.tencent.mm.plugin.report.service.h.INSTANCE.b(arrayList, false);
                        Log.d("MicroMsg.BizTimeLineInfoStorage", "createIndexIfNeed end");
                    }
                    AppMethodBeat.o(124611);
                }
            }, 1000, "BizTimeLineInfoStorageThread");
        }
        com.tencent.mm.plugin.brandservice.ui.b.a.cre();
        com.tencent.mm.pluginsdk.ui.applet.g.gpi();
        y yVar = y.NPP;
        y.a(y.b.RECYCLE_CARD_SCENE_ENTER_BOX);
        com.tencent.mm.api.b.Uu();
        com.tencent.mm.plugin.brandservice.b.b.clr();
        m.IAG.fWO();
        com.tencent.mm.plugin.webcanvas.l lVar = com.tencent.mm.plugin.webcanvas.l.IAx;
        com.tencent.mm.plugin.webcanvas.l.LV(65);
        AppMethodBeat.o(5966);
    }

    public final void cmA() {
        AppMethodBeat.i(5968);
        if (isFinishing()) {
            AppMethodBeat.o(5968);
            return;
        }
        int ctM = ag.bap().ctM();
        if (ctM > 0) {
            this.psM.setVisibility(0);
            this.psN.setText(getString(R.string.aik, new Object[]{Integer.valueOf(ctM)}));
            z gBn = ag.bap().gBn();
            if (gBn != null) {
                this.psL.setVisibility(0);
                if (gBn.gAw()) {
                    as Kn = ((com.tencent.mm.plugin.messenger.foundation.a.l) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().Kn(gBn.field_talker);
                    if (Kn == null || !com.tencent.mm.contact.c.oR(Kn.field_type)) {
                        if (gBn.gAB() != null) {
                            c.a aVar = new c.a();
                            aVar.jbq = R.drawable.bca;
                            aVar.jbe = true;
                            com.tencent.mm.av.q.bcV().a(gBn.gAB().iAR, this.psL, aVar.bdv());
                        }
                    }
                    a.b.c(this.psL, gBn.field_talker);
                } else if (gBn.gAx()) {
                    String I = com.tencent.mm.storage.ag.I(gBn);
                    if (Util.isNullOrNil(I)) {
                        a.b.c(this.psL, gBn.field_talker);
                    } else if (com.tencent.mm.model.ab.IT(I)) {
                        a.b.d(this.psL, I);
                    } else {
                        a.b.c(this.psL, I);
                    }
                    this.pqZ.l(com.tencent.mm.storage.ag.f(gBn), I, 0);
                } else {
                    if (com.tencent.mm.model.ab.IT(gBn.field_talker)) {
                        a.b.d(this.psL, gBn.field_talker);
                    }
                    a.b.c(this.psL, gBn.field_talker);
                }
                ab.Nc(gBn.field_msgId);
            } else {
                this.psL.setVisibility(8);
            }
            if (this.psQ != null && this.psQ.getCount() == 0) {
                this.psQ.notifyDataSetChanged();
            }
            AppMethodBeat.o(5968);
            return;
        }
        this.psM.setVisibility(8);
        AppMethodBeat.o(5968);
    }

    private void g(final z zVar, final int i2) {
        AppMethodBeat.i(194949);
        if (this.psJ == null || isFinishing()) {
            AppMethodBeat.o(194949);
            return;
        }
        com.tencent.mm.pluginsdk.ui.tools.p.a(this.psJ, i2, psT, false);
        if (this.psJ.getFirstVisiblePosition() == i2) {
            i(zVar);
            Log.i("MicroMsg.BizTimeLineUI", "tryToScrollToPosition success tryScrollTimes: %d", Integer.valueOf(this.ptj));
            AppMethodBeat.o(194949);
            return;
        }
        this.psJ.postDelayed(new Runnable() {
            /* class com.tencent.mm.plugin.brandservice.ui.timeline.BizTimeLineUI.AnonymousClass21 */

            public final void run() {
                AppMethodBeat.i(5964);
                if (BizTimeLineUI.k(BizTimeLineUI.this) > 20 || BizTimeLineUI.this.ptd || BizTimeLineUI.this.mScrollState != 0) {
                    BizTimeLineUI.a(BizTimeLineUI.this, zVar);
                    Log.i("MicroMsg.BizTimeLineUI", "tryToScrollToPosition fail userTouched: %b state: %d tryScrollTimes: %d", Boolean.valueOf(BizTimeLineUI.this.ptd), Integer.valueOf(BizTimeLineUI.this.mScrollState), Integer.valueOf(BizTimeLineUI.this.ptj));
                    AppMethodBeat.o(5964);
                    return;
                }
                BizTimeLineUI.a(BizTimeLineUI.this, zVar, i2);
                AppMethodBeat.o(5964);
            }
        }, 10);
        AppMethodBeat.o(194949);
    }

    private void i(z zVar) {
        AppMethodBeat.i(5971);
        this.psQ.prf = false;
        this.psY = false;
        int max = Math.max(0, this.psJ.getFirstVisiblePosition() - this.psJ.getHeaderViewsCount());
        this.psQ.d(zVar);
        this.psQ.d(this.psQ.De(max));
        cmB();
        Log.i("MicroMsg.BizTimeLineUI", "resetKeep pos %d", Integer.valueOf(max));
        AppMethodBeat.o(5971);
    }

    private void cmB() {
        int i2;
        int i3 = 0;
        AppMethodBeat.i(194950);
        if (this.psJ == null || this.psQ == null) {
            AppMethodBeat.o(194950);
            return;
        }
        int firstVisiblePosition = this.psJ.getFirstVisiblePosition();
        int lastVisiblePosition = this.psJ.getLastVisiblePosition();
        fd(firstVisiblePosition, lastVisiblePosition);
        if (firstVisiblePosition > 0) {
            i2 = firstVisiblePosition - 1;
        } else {
            i2 = 0;
        }
        if (lastVisiblePosition > 0) {
            i3 = lastVisiblePosition - 1;
        }
        while (i2 <= i3) {
            z De = this.psQ.De(i2);
            if (De != null) {
                this.psQ.ahO(De.field_talker);
                this.pqZ.e(De);
            }
            i2++;
        }
        AppMethodBeat.o(194950);
    }

    public final void cms() {
        AppMethodBeat.i(5974);
        if (!isFinishing() && this.psf != null) {
            ((View) $(R.id.a8h)).setVisibility(8);
            ((View) $(R.id.a8q)).setVisibility(0);
            TextView textView = (TextView) $(R.id.a8p);
            ImageView imageView = (ImageView) $(R.id.a8o);
            b.a aVar = b.prG;
            if (b.a.cmx()) {
                textView.setVisibility(8);
                imageView.setVisibility(0);
                com.tencent.mm.model.o oVar = com.tencent.mm.model.o.iBV;
                com.tencent.mm.model.o.Aa(15);
                AppMethodBeat.o(5974);
                return;
            }
            textView.setVisibility(0);
            imageView.setVisibility(8);
            textView.setText(getString(R.string.aih));
        }
        AppMethodBeat.o(5974);
    }

    public final void cmt() {
        AppMethodBeat.i(194951);
        if (!isFinishing() && this.psf != null) {
            ((View) $(R.id.a8h)).setVisibility(0);
            ((View) $(R.id.a8q)).setVisibility(8);
        }
        AppMethodBeat.o(194951);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.jr;
    }

    public final void cmC() {
        AppMethodBeat.i(5975);
        long currentTimeMillis = System.currentTimeMillis() - this.ptl;
        if (!this.ptn || currentTimeMillis >= 200) {
            Log.d("MicroMsg.BizTimeLineUI", "try2UpdateActionBarCustomView isDoingUpdateView %s,interval %s", Boolean.valueOf(this.ptn), Long.valueOf(currentTimeMillis));
            this.ptn = true;
            if (currentTimeMillis < 100) {
                MMHandlerThread.postToMainThreadDelayed(new Runnable() {
                    /* class com.tencent.mm.plugin.brandservice.ui.timeline.BizTimeLineUI.AnonymousClass8 */

                    public final void run() {
                        AppMethodBeat.i(5951);
                        BizTimeLineUI.this.ptn = false;
                        if (!BizTimeLineUI.this.isFinishing()) {
                            BizTimeLineUI.this.cmC();
                            AppMethodBeat.o(5951);
                            return;
                        }
                        Log.w("MicroMsg.BizTimeLineUI", "Activity is finished!!!");
                        AppMethodBeat.o(5951);
                    }
                }, 100);
                AppMethodBeat.o(5975);
                return;
            }
            if (this.psQ != null && !this.dLD && this.psQ.nZr.size() > 0) {
                final long j2 = this.psQ.nZr.get(0).field_orderFlag;
                if (this.psY || this.psJ == null || this.psJ.getFirstVisiblePosition() != 0) {
                    int MR = ag.ban().MR(j2);
                    if (MR > 0) {
                        if (ag.ban().MZ(ag.ban().gAS() << 32) != null) {
                            MR--;
                        }
                    }
                    Log.d("MicroMsg.BizTimeLineUI", "updateActionBarCustomView %d", Integer.valueOf(MR));
                    if (MR > 0) {
                        setMMTitleVisibility(8);
                        if (this.psK.getVisibility() == 8) {
                            this.psK.setVisibility(4);
                        }
                        this.psO.setText(getString(R.string.aiq, new Object[]{Integer.valueOf(MR)}));
                        this.psK.post(new Runnable() {
                            /* class com.tencent.mm.plugin.brandservice.ui.timeline.BizTimeLineUI.AnonymousClass9 */

                            public final void run() {
                                AppMethodBeat.i(5952);
                                if (ag.ban().MR(j2) <= 0) {
                                    BizTimeLineUI.this.setMMTitleVisibility(0);
                                    AppMethodBeat.o(5952);
                                    return;
                                }
                                float x = BizTimeLineUI.this.psK.getX();
                                int width = (int) ((((float) BizTimeLineUI.this.psK.getWidth()) + (x + x)) / 2.0f);
                                int jn = com.tencent.mm.cb.a.jn(BizTimeLineUI.this.getContext()) / 2;
                                if (width != jn) {
                                    float f2 = ((float) (jn - width)) + x;
                                    BizTimeLineUI.this.psK.setX(f2);
                                    Log.d("MicroMsg.BizTimeLineUI", "updateActionBarCustomView x = %f, new x=%f", Float.valueOf(x), Float.valueOf(f2));
                                }
                                if (BizTimeLineUI.this.psK.getVisibility() != 0) {
                                    BizTimeLineUI.this.psK.setVisibility(0);
                                }
                                AppMethodBeat.o(5952);
                            }
                        });
                    }
                }
                this.psK.setVisibility(8);
                setMMTitleVisibility(0);
            }
            this.ptl = System.currentTimeMillis();
            this.ptn = false;
            AppMethodBeat.o(5975);
            return;
        }
        Log.d("MicroMsg.BizTimeLineUI", "DoingUpdateView return");
        AppMethodBeat.o(5975);
    }

    public final void cmD() {
        AppMethodBeat.i(5977);
        Log.d("MicroMsg.BizTimeLineUI", "hideActionBarCustomView");
        cmC();
        AppMethodBeat.o(5977);
    }

    @Override // com.tencent.mm.plugin.brandservice.ui.timeline.g
    public final void cmy() {
        AppMethodBeat.i(5978);
        if (this.psQ != null) {
            this.psQ.notifyDataSetChanged();
        }
        AppMethodBeat.o(5978);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        long j2;
        AppBrandVideoView appBrandVideoView;
        AppBrandVideoView appBrandVideoView2;
        AppMethodBeat.i(5979);
        super.onDestroy();
        Log.i("MicroMsg.BizTimeLineUI", "onDestroy %d", Integer.valueOf(hashCode()));
        if (this.prb != null) {
            BizTimeLineHotView bizTimeLineHotView = this.prb;
            ((com.tencent.mm.plugin.messenger.foundation.a.l) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aST().remove(bizTimeLineHotView);
            EventCenter.instance.removeListener(bizTimeLineHotView.pzx);
            com.tencent.mm.plugin.brandservice.ui.timeline.offenread.g gVar = bizTimeLineHotView.pyZ;
            d.a aVar = new d.a();
            cuq cuq = new cuq();
            aVar.iLN = cuq;
            aVar.iLO = new cur();
            aVar.uri = "/cgi-bin/micromsg-bin/often_read_bar_report";
            aVar.funcId = 2550;
            d aXF = aVar.aXF();
            cuq.KRg = ab.getSessionId();
            cuq.MzY = gVar.pzT;
            LinkedList<cus> linkedList = new LinkedList<>();
            if (gVar.pzS.size() > 0) {
                for (Map.Entry<String, cus> entry : gVar.pzS.entrySet()) {
                    linkedList.add(entry.getValue());
                }
            }
            cuq.MzX = linkedList;
            cuq.source = 0;
            com.tencent.mm.ak.aa.a(aXF, new aa.a() {
                /* class com.tencent.mm.plugin.brandservice.ui.timeline.offenread.g.AnonymousClass1 */

                @Override // com.tencent.mm.ak.aa.a
                public final int a(int i2, int i3, String str, d dVar, com.tencent.mm.ak.q qVar) {
                    AppMethodBeat.i(6136);
                    Log.i("MicroMsg.BizTimeLineOftenReadReport", "often_read_bar_report CGI return, errType = %d, errCode = %d", Integer.valueOf(i2), Integer.valueOf(i3));
                    AppMethodBeat.o(6136);
                    return 0;
                }
            });
            com.tencent.mm.kernel.g.azz().b(2768, bizTimeLineHotView);
            bizTimeLineHotView.pzr.setAdapter(null);
            bizTimeLineHotView.pzr.pzf.dead();
        }
        EventCenter.instance.removeListener(this.psR.lEl);
        ab.AK(false);
        ab.NQT = System.currentTimeMillis();
        if (!(this.psQ == null || this.psJ == null)) {
            z cmo = this.psQ.cmo();
            if (cmo != null) {
                ab.NQU = cmo.field_orderFlag;
            } else {
                ab.NQU = ag.ban().gAo() << 32;
            }
            z De = this.psQ.De(cmG());
            if (De != null) {
                psS = De.getId();
            } else {
                Log.w("MicroMsg.BizTimeLineUI", "FirstVisibleItem is null %d", Integer.valueOf(cmG()));
            }
            b bVar = this.psQ;
            ag.ban().a(bVar.pmx);
            bVar.prc.pAy.clear();
            p.a aVar2 = p.iCa;
            List<z> list = bVar.pqW;
            kotlin.g.b.p.h(list, "list");
            kotlin.g.b.p.h(list, "<set-?>");
            p.iBX = list;
        }
        ag.bap().a(this.pth);
        if (this.pss != 0) {
            long currentTimeMillis = System.currentTimeMillis();
            this.ofm += currentTimeMillis - this.psW;
            com.tencent.mm.plugin.report.service.h.INSTANCE.a(13932, Integer.valueOf(((int) (currentTimeMillis - this.pss)) / 1000), 1, Integer.valueOf(this.dEb), Integer.valueOf((int) (this.ofm / 1000)), Integer.valueOf(this.source));
        }
        EventCenter.instance.removeListener(this.ptp);
        this.pti.dead();
        this.pqZ.psr = cmG();
        f fVar = this.pqZ;
        com.tencent.f.h.RTc.b(new Runnable() {
            /* class com.tencent.mm.plugin.brandservice.ui.timeline.f.AnonymousClass2 */

            public final void run() {
                AppMethodBeat.i(5931);
                LinkedList linkedList = new LinkedList();
                StringBuilder sb = new StringBuilder();
                for (Map.Entry<String, b> entry : f.this.psu.entrySet()) {
                    b value = entry.getValue();
                    if (!Util.isNullOrNil(value.psI)) {
                        MPVideoPreviewMgr mPVideoPreviewMgr = MPVideoPreviewMgr.pJz;
                        value.KVl = MPVideoPreviewMgr.aiL(value.psI);
                        MPVideoPreviewMgr mPVideoPreviewMgr2 = MPVideoPreviewMgr.pJz;
                        value.KVm = MPVideoPreviewMgr.aiM(value.psI);
                    }
                    linkedList.add(value);
                    if (value.KUU == 0) {
                        sb.append(value.fQY).append(",").append(value.KUZ).append(" ");
                    }
                }
                Log.i("MicroMsg.BizTimeLineReport", "reportExpose %s.", sb.toString());
                com.tencent.mm.kernel.g.aAg().hqi.a(new k(linkedList, f.this.psq, f.this.psr, f.this.dEb, f.this.pss, 0, 0), 0);
                AppMethodBeat.o(5931);
            }
        }, "BizTimeLineExpose");
        if (fVar.psw != null) {
            com.tencent.mm.plugin.report.service.h.INSTANCE.a(21136, Integer.valueOf(fVar.psw.psE), Integer.valueOf(fVar.psw.psF), Integer.valueOf(fVar.psw.msgType), Integer.valueOf(fVar.psw.dEb), fVar.psw.dVu, Integer.valueOf(fVar.psw.psG));
        }
        com.tencent.mm.plugin.brandservice.ui.b.b.clean();
        aq.clear();
        ab.DU(0);
        try {
            if (getContentView() instanceof ViewGroup) {
                ((ViewGroup) getContentView()).removeAllViews();
            }
        } catch (Throwable th) {
            Log.w("MicroMsg.BizTimeLineUI", "onDestroy contentView removeAllViews %s", th);
        }
        com.tencent.mm.pluginsdk.model.a aVar3 = com.tencent.mm.pluginsdk.model.a.JUl;
        com.tencent.mm.pluginsdk.model.a.gmj();
        com.tencent.mm.plugin.brandservice.b.b.release();
        for (f fVar2 : this.ptg) {
            fVar2.onDestroy();
        }
        this.ptf.clear();
        this.ptg.clear();
        MPVideoPreviewMgr mPVideoPreviewMgr = MPVideoPreviewMgr.pJz;
        if (MPVideoPreviewMgr.pJj) {
            MPVideoPreviewMgr.a aVar4 = MPVideoPreviewMgr.pJq;
            WeakReference<AppBrandVideoView> weakReference = MPVideoPreviewMgr.pJm;
            if (weakReference == null || (appBrandVideoView2 = weakReference.get()) == null) {
                j2 = 0;
            } else {
                j2 = (long) appBrandVideoView2.getCurrPosMs();
            }
            aVar4.pJH = j2;
            MPVideoPreviewMgr.pJq.pl(4);
            MPVideoPreviewMgr.a aVar5 = MPVideoPreviewMgr.pJq;
            aVar5.pJA = null;
            aVar5.d(null);
            aVar5.aiO("IDLE");
            aVar5.akb = 0;
            aVar5.pJE.clear();
            aVar5.setVideoDuration(0);
            aVar5.pJH = 0;
            aVar5.pJI = 0;
            aVar5.pJJ = 0;
            aVar5.pJK = 0;
            aVar5.pJL = 0;
            aVar5.pJD = "";
            WeakReference<AppBrandVideoView> weakReference2 = MPVideoPreviewMgr.pJm;
            if (!(weakReference2 == null || (appBrandVideoView = weakReference2.get()) == null)) {
                appBrandVideoView.onUIDestroy();
            }
            MPVideoPreviewMgr.pJs = "";
            MPVideoPreviewMgr.pJu = null;
            MPVideoPreviewMgr.pJk = null;
            MPVideoPreviewMgr.pJl = null;
            MPVideoPreviewMgr.pJm = null;
            MPVideoPreviewMgr.pJn = null;
            MPVideoPreviewMgr.pJo = null;
            MPVideoPreviewMgr.pJw.clear();
            MPVideoPreviewMgr.stopTimer();
            MPVideoPreviewMgr.pJp = null;
            MPVideoPreviewMgr.pJx.clear();
        }
        AppMethodBeat.o(5979);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        AppMethodBeat.i(5980);
        super.onResume();
        if (this.psX) {
            this.psX = false;
            this.pqZ.Dg(8);
        }
        if (this.psQ != null) {
            b bVar = this.psQ;
            bVar.dLD = false;
            com.tencent.mm.plugin.brandservice.ui.timeline.preload.d dVar = bVar.prc;
            if (dVar.pAB) {
                dVar.pAB = false;
                if (dVar.pAv <= 0) {
                    dVar.cnz();
                }
            }
        }
        if (this.dLD) {
            this.dLD = false;
            cmC();
        }
        this.psW = System.currentTimeMillis();
        com.tencent.mm.plugin.brandservice.b.a("BrandServiceWorkerThread", new Runnable() {
            /* class com.tencent.mm.plugin.brandservice.ui.timeline.BizTimeLineUI.AnonymousClass14 */

            public final void run() {
                AppMethodBeat.i(194944);
                if (BizTimeLineUI.this.isFinishing() || BizTimeLineUI.this.psJ == null || BizTimeLineUI.this.psJ.getFirstVisiblePosition() != 0 || BizTimeLineUI.this.prb == null) {
                    AppMethodBeat.o(194944);
                    return;
                }
                BizTimeLineUI.this.prb.cnm();
                AppMethodBeat.o(194944);
            }
        }, 500);
        com.tencent.mm.pluginsdk.ui.span.l.a(this.ptq);
        try {
            ScreenShotUtil.setScreenShotCallback(this, this);
        } catch (Exception e2) {
            Log.w("MicroMsg.BizTimeLineUI", "setScreenShotCallback fail e:%s", e2.getMessage());
        }
        for (f fVar : this.ptg) {
            fVar.onResume();
        }
        MPVideoPreviewMgr mPVideoPreviewMgr = MPVideoPreviewMgr.pJz;
        MPVideoPreviewMgr.aiI("ONRESUME");
        AppMethodBeat.o(5980);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onPause() {
        z zVar;
        AppMethodBeat.i(5981);
        super.onPause();
        if (this.psQ != null) {
            b bVar = this.psQ;
            bVar.dLD = true;
            bVar.prc.pAB = true;
            zVar = this.psQ.cmp();
        } else {
            zVar = null;
        }
        if (zVar != null) {
            ag.ban().MV(zVar.field_orderFlag);
        } else {
            ag.ban().gAQ();
        }
        if (this.psJ != null) {
            View childAt = this.psJ.getChildAt(0);
            psT = childAt != null ? childAt.getTop() : 0;
        } else {
            psT = 0;
        }
        this.dLD = true;
        long currentTimeMillis = System.currentTimeMillis();
        this.ofm += currentTimeMillis - this.psW;
        this.psW = currentTimeMillis;
        WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcBizEnable, this.gsi);
        this.gsi = 0;
        com.tencent.mm.pluginsdk.ui.span.l.b(this.ptq);
        com.tencent.mm.pluginsdk.ui.applet.g gVar = com.tencent.mm.pluginsdk.ui.applet.g.Kev;
        if (com.tencent.mm.pluginsdk.ui.applet.g.aig(1)) {
            com.tencent.mm.pluginsdk.model.a aVar = com.tencent.mm.pluginsdk.model.a.JUl;
            com.tencent.mm.pluginsdk.model.a.gmk();
        }
        ScreenShotUtil.setScreenShotCallback(this, null);
        for (f fVar : this.ptg) {
            fVar.onPause();
        }
        MPVideoPreviewMgr mPVideoPreviewMgr = MPVideoPreviewMgr.pJz;
        MPVideoPreviewMgr.aiI("ONPAUSE");
        AppMethodBeat.o(5981);
    }

    private void ds(View view) {
        AppMethodBeat.i(5982);
        Object tag = view.getTag(R.id.a5g);
        if (tag instanceof String) {
            this.pte.add((String) tag);
        }
        AppMethodBeat.o(5982);
    }

    private void fd(int i2, int i3) {
        AppMethodBeat.i(5983);
        if (i2 == 0 && !this.psY && psU != i2) {
            this.prb.cnm();
        }
        this.psV.a(i2, i3, this.psJ, this.pqZ);
        AppMethodBeat.o(5983);
    }

    public final StoryListView cmE() {
        return this.psJ;
    }

    public final boolean cmF() {
        AppMethodBeat.i(194952);
        if (this.prb.getVisibility() == 0 || this.psM.getVisibility() == 0) {
            AppMethodBeat.o(194952);
            return true;
        }
        AppMethodBeat.o(194952);
        return false;
    }

    private static int cmG() {
        if (psU > 0) {
            return psU - 1;
        }
        return 0;
    }

    @Override // com.tencent.mm.plugin.webcanvas.g
    public final void a(h hVar) {
        AppMethodBeat.i(194953);
        if (!this.ptf.contains(hVar)) {
            this.ptf.add(hVar);
        }
        AppMethodBeat.o(194953);
    }

    @Override // com.tencent.mm.plugin.webcanvas.g
    public final void b(h hVar) {
        AppMethodBeat.i(194954);
        this.ptf.remove(hVar);
        AppMethodBeat.o(194954);
    }

    @Override // com.tencent.mm.plugin.webcanvas.g
    public final void a(f fVar) {
        AppMethodBeat.i(194955);
        if (!this.ptg.contains(this.ptg)) {
            this.ptg.add(fVar);
        }
        AppMethodBeat.o(194955);
    }

    public final void j(z zVar) {
        AppMethodBeat.i(194956);
        this.pqZ.a(zVar, 0, (int) (System.currentTimeMillis() / 1000));
        AppMethodBeat.o(194956);
    }

    @Override // com.tencent.mm.sdk.platformtools.ScreenShotUtil.ScreenShotCallback
    public void onScreenShot(String str, long j2) {
        AppMethodBeat.i(194957);
        for (h hVar : this.ptf) {
            hVar.cmW();
        }
        AppMethodBeat.o(194957);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onConfigurationChanged(Configuration configuration) {
        AppMethodBeat.i(194958);
        super.onConfigurationChanged(configuration);
        for (h hVar : this.ptf) {
            hVar.onConfigurationChanged(configuration);
        }
        if (this.prb != null) {
            this.prb.onConfigurationChanged(configuration);
        }
        com.tencent.mm.plugin.brandservice.ui.timeline.a.b bVar = this.psV;
        bVar.mEY = com.tencent.mm.cb.a.jo(bVar.context);
        AppMethodBeat.o(194958);
    }

    /* JADX WARNING: Removed duplicated region for block: B:47:0x010a  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x0124  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x01b9  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ void b(com.tencent.mm.plugin.brandservice.ui.timeline.BizTimeLineUI r21, int r22, int r23) {
        /*
        // Method dump skipped, instructions count: 515
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.brandservice.ui.timeline.BizTimeLineUI.b(com.tencent.mm.plugin.brandservice.ui.timeline.BizTimeLineUI, int, int):void");
    }

    static /* synthetic */ void i(BizTimeLineUI bizTimeLineUI) {
        AppMethodBeat.i(194960);
        if (bizTimeLineUI.psQ == null || bizTimeLineUI.psJ == null || Util.isNullOrNil(psS)) {
            AppMethodBeat.o(194960);
            return;
        }
        for (int i2 = 0; i2 < bizTimeLineUI.psQ.getCount(); i2++) {
            z De = bizTimeLineUI.psQ.De(i2);
            if (De != null && Util.isEqual(psS, De.getId())) {
                Log.i("MicroMsg.BizTimeLineUI", "tryToScrollToPosition %d top %d", Integer.valueOf(i2), Integer.valueOf(psT));
                bizTimeLineUI.g(De, i2 + 1);
                AppMethodBeat.o(194960);
                return;
            }
        }
        bizTimeLineUI.i((z) null);
        AppMethodBeat.o(194960);
    }

    static /* synthetic */ void p(BizTimeLineUI bizTimeLineUI) {
        z cmp;
        AppMethodBeat.i(194963);
        if (!(bizTimeLineUI.psQ == null || bizTimeLineUI.psJ == null || bizTimeLineUI.psQ.getCount() <= 0)) {
            bizTimeLineUI.psQ.cmq();
            bizTimeLineUI.psQ.notifyDataSetChanged();
            bizTimeLineUI.pto = true;
            MMHandlerThread.postToMainThreadDelayed(new Runnable() {
                /* class com.tencent.mm.plugin.brandservice.ui.timeline.BizTimeLineUI.AnonymousClass10 */

                {
                    AppMethodBeat.i(160484);
                    AppMethodBeat.o(160484);
                }

                public final void run() {
                    AppMethodBeat.i(194940);
                    BizTimeLineUI.this.pto = false;
                    if (!BizTimeLineUI.this.isFinishing() && BizTimeLineUI.this.psJ != null) {
                        BizTimeLineUI.a(BizTimeLineUI.this, BizTimeLineUI.this.psJ.getFirstVisiblePosition(), BizTimeLineUI.this.psJ.getLastVisiblePosition());
                    }
                    AppMethodBeat.o(194940);
                }
            }, 200);
            bizTimeLineUI.psJ.setSelection(0);
            bizTimeLineUI.pqZ.Dg(6);
            if (!(bizTimeLineUI.psQ == null || (cmp = bizTimeLineUI.psQ.cmp()) == null)) {
                ab.Nb(cmp.field_orderFlag);
            }
            bizTimeLineUI.cmD();
        }
        AppMethodBeat.o(194963);
    }
}

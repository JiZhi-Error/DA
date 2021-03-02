package com.tencent.mm.ui.conversation;

import android.app.ActivityOptions;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ag.u;
import com.tencent.mm.ag.v;
import com.tencent.mm.ak.aa;
import com.tencent.mm.ak.d;
import com.tencent.mm.al.ae;
import com.tencent.mm.al.ag;
import com.tencent.mm.g.a.ao;
import com.tencent.mm.g.a.l;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.bp;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.brandservice.ui.timeline.BizTimeLineNewMsgUI;
import com.tencent.mm.plugin.messenger.foundation.a.a.k;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.websearch.api.ai;
import com.tencent.mm.plugin.websearch.api.ak;
import com.tencent.mm.plugin.websearch.api.i;
import com.tencent.mm.protocal.protobuf.afk;
import com.tencent.mm.protocal.protobuf.dna;
import com.tencent.mm.protocal.protobuf.dqi;
import com.tencent.mm.protocal.protobuf.qc;
import com.tencent.mm.protocal.protobuf.qd;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.az;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMSlideDelView;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.q;
import com.tencent.mm.ui.chatting.ChattingUI;
import com.tencent.mm.ui.g;
import com.tencent.mm.ui.s;
import com.tencent.mm.ui.widget.a.e;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class NewBizConversationUI extends MMActivity {
    private ListView Qbt;
    private String Qbv;
    private a QgH;
    private final int QgI = 1;
    private final int QgJ = 2;
    private az conversation;
    private int dEb;
    private TextView emptyTipTv;
    private String iNV;
    private boolean isDeleteCancel = false;
    private int ppd = 0;
    private int ppe = 0;
    private com.tencent.mm.ui.widget.b.a pqr;
    private o.g pso = new o.g() {
        /* class com.tencent.mm.ui.conversation.NewBizConversationUI.AnonymousClass10 */

        /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // com.tencent.mm.ui.base.o.g
        public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
            AppMethodBeat.i(38671);
            switch (menuItem.getItemId()) {
                case 1:
                    bg.aVF();
                    as Kn = c.aSN().Kn(NewBizConversationUI.this.talker);
                    if (Kn == null) {
                        Log.e("MicroMsg.NewBizConversationUI", "changed biz stick status failed, contact is null, talker = " + NewBizConversationUI.this.talker);
                        AppMethodBeat.o(38671);
                        return;
                    }
                    if (Kn.arE()) {
                        h.INSTANCE.a(13307, Kn.field_username, 1, 2, 2);
                        ab.F(NewBizConversationUI.this.talker, true);
                    } else {
                        h.INSTANCE.a(13307, Kn.field_username, 1, 1, 2);
                        ab.E(NewBizConversationUI.this.talker, true);
                    }
                    ao aoVar = new ao();
                    aoVar.dDs.userName = Kn.field_username;
                    EventCenter.instance.publish(aoVar);
                    AppMethodBeat.o(38671);
                    return;
                case 2:
                    bg.aVF();
                    com.tencent.mm.ui.tools.b.a(ag.bah().MT(NewBizConversationUI.this.talker), NewBizConversationUI.this, c.aSN().Kn(NewBizConversationUI.this.talker), 2);
                    AppMethodBeat.o(38671);
                    return;
                case 3:
                    NewBizConversationUI.b(NewBizConversationUI.this, NewBizConversationUI.this.talker);
                    AppMethodBeat.o(38671);
                    return;
                case 4:
                    g.c(NewBizConversationUI.this, new Runnable() {
                        /* class com.tencent.mm.ui.conversation.NewBizConversationUI.AnonymousClass10.AnonymousClass1 */

                        public final void run() {
                            AppMethodBeat.i(234252);
                            bg.aVF();
                            c.aST().bjW(NewBizConversationUI.this.talker);
                            AppMethodBeat.o(234252);
                        }
                    });
                    break;
            }
            AppMethodBeat.o(38671);
        }
    };
    private long pss = 0;
    private IListener ptp = new IListener<l>() {
        /* class com.tencent.mm.ui.conversation.NewBizConversationUI.AnonymousClass11 */

        {
            AppMethodBeat.i(161573);
            this.__eventId = l.class.getName().hashCode();
            AppMethodBeat.o(161573);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(l lVar) {
            AppMethodBeat.i(38672);
            l lVar2 = lVar;
            if (!(lVar2 == null || lVar2.dCi == null || lVar2.dCi.isActive)) {
                NewBizConversationUI.this.pss = 0;
            }
            AppMethodBeat.o(38672);
            return false;
        }
    };
    private int source = 1;
    private String talker = "";
    private q tipDialog = null;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public NewBizConversationUI() {
        AppMethodBeat.i(38687);
        AppMethodBeat.o(38687);
    }

    static /* synthetic */ void a(NewBizConversationUI newBizConversationUI) {
        AppMethodBeat.i(38696);
        newBizConversationUI.gWd();
        AppMethodBeat.o(38696);
    }

    static /* synthetic */ String gWf() {
        AppMethodBeat.i(162389);
        String gWe = gWe();
        AppMethodBeat.o(162389);
        return gWe;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(38688);
        super.onCreate(bundle);
        if (!bg.aAc()) {
            Log.e("MicroMsg.NewBizConversationUI", "onCreate acc not ready!!!");
            finish();
            AppMethodBeat.o(38688);
            return;
        }
        this.dEb = getIntent().getIntExtra("biz_time_line_line_session_id", 0);
        this.source = getIntent().getIntExtra("biz_enter_source", 1);
        this.iNV = "officialaccounts";
        h.INSTANCE.a(11404, 0, 0, 0, 0, 0, Integer.valueOf(this.dEb), Integer.valueOf((int) (System.currentTimeMillis() / 1000)), Integer.valueOf(this.source), "", 0, 0, 0);
        this.Qbv = getIntent().getStringExtra("enterprise_biz_display_name");
        if (Util.isNullOrNil(this.Qbv)) {
            this.Qbv = getString(R.string.agz);
        }
        initView();
        gWd();
        if (((com.tencent.mm.plugin.brandservice.a.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.brandservice.a.b.class)).cle()) {
            d.a aVar = new d.a();
            aVar.iLN = new qc();
            aVar.iLO = new qd();
            aVar.uri = "/cgi-bin/mmbiz-bin/timeline/bizstrategy";
            aVar.funcId = 1806;
            d aXF = aVar.aXF();
            ((qc) aXF.iLK.iLR).ReqType = 1;
            aa.a(aXF, new aa.a() {
                /* class com.tencent.mm.ui.conversation.NewBizConversationUI.AnonymousClass13 */

                @Override // com.tencent.mm.ak.aa.a
                public final int a(int i2, int i3, String str, d dVar, com.tencent.mm.ak.q qVar) {
                    AppMethodBeat.i(38676);
                    Log.i("MicroMsg.NewBizConversationUI", "doBizStrategy callback %d/%d %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
                    if (i2 == 0 || i3 == 0) {
                        qd qdVar = (qd) dVar.iLL.iLR;
                        if (qdVar.KWW != null && !Util.isNullOrNil(qdVar.KWW.MFT)) {
                            MultiProcessMMKV singleMMKV = MultiProcessMMKV.getSingleMMKV("brandService");
                            int decodeInt = singleMMKV.decodeInt(NewBizConversationUI.gWf(), 0);
                            singleMMKV.encode("PaySubscribeEntryUrl", qdVar.KWW.MFT);
                            singleMMKV.encode(NewBizConversationUI.gWf(), qdVar.KWW.MFS);
                            if (decodeInt != qdVar.KWW.MFS) {
                                NewBizConversationUI.a(NewBizConversationUI.this);
                            }
                        }
                        AppMethodBeat.o(38676);
                    } else {
                        AppMethodBeat.o(38676);
                    }
                    return 0;
                }
            });
        }
        bg.aVF();
        c.aST().add(this.QgH);
        this.pss = System.currentTimeMillis();
        EventCenter.instance.addListener(this.ptp);
        AppMethodBeat.o(38688);
    }

    private void gWd() {
        final boolean z = true;
        AppMethodBeat.i(38689);
        removeAllOptionMenu();
        com.tencent.mm.plugin.bizui.a.a aVar = com.tencent.mm.plugin.bizui.a.a.pfC;
        boolean ckz = com.tencent.mm.plugin.bizui.a.a.ckz();
        boolean Vu = ((com.tencent.mm.api.q) com.tencent.mm.kernel.g.af(com.tencent.mm.api.q.class)).Vu();
        Log.d("MicroMsg.NewBizConversationUI", "open search entrance:%b, isBizTeenModeAllowAll: %b", Boolean.valueOf(ckz), Boolean.valueOf(Vu));
        if (ckz && Vu) {
            addIconOptionMenu(1, R.string.hpa, R.raw.actionbar_icon_dark_search, new MenuItem.OnMenuItemClickListener() {
                /* class com.tencent.mm.ui.conversation.NewBizConversationUI.AnonymousClass1 */

                public final boolean onMenuItemClick(MenuItem menuItem) {
                    AppMethodBeat.i(38661);
                    if (ai.afs(0)) {
                        ((i) com.tencent.mm.kernel.g.af(i.class)).a(MMApplicationContext.getContext(), new Runnable() {
                            /* class com.tencent.mm.ui.conversation.NewBizConversationUI.AnonymousClass1.AnonymousClass1 */

                            public final void run() {
                                AppMethodBeat.i(38660);
                                Intent fXX = ai.fXX();
                                fXX.putExtra("title", NewBizConversationUI.this.getString(R.string.dkg));
                                fXX.putExtra("searchbar_tips", NewBizConversationUI.this.getString(R.string.dkg));
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
                                Bundle bundle = null;
                                if (Build.VERSION.SDK_INT >= 21 && !com.tencent.mm.ui.ao.isDarkMode()) {
                                    bundle = ActivityOptions.makeSceneTransitionAnimation(NewBizConversationUI.this, new Pair[0]).toBundle();
                                }
                                String aXg = ak.aXg("bizAccountTopSearch");
                                if (!TextUtils.isEmpty(aXg)) {
                                    fXX.putExtra("key_search_input_hint", aXg);
                                }
                                com.tencent.mm.br.c.a(NewBizConversationUI.this, "webview", ".ui.tools.fts.FTSSearchTabWebViewUI", fXX, bundle);
                                AppMethodBeat.o(38660);
                            }
                        });
                    } else {
                        Log.e("MicroMsg.NewBizConversationUI", "fts h5 template not avail");
                    }
                    AppMethodBeat.o(38661);
                    return true;
                }
            });
        }
        final MultiProcessMMKV singleMMKV = MultiProcessMMKV.getSingleMMKV("brandService");
        final boolean cle = ((com.tencent.mm.plugin.brandservice.a.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.brandservice.a.b.class)).cle();
        final int decodeInt = singleMMKV.decodeInt(gWe(), 0);
        if (decodeInt != 1 || !cle || !singleMMKV.decodeBool("NeedShowPayActionBarRedDot", true)) {
            z = false;
        }
        addIconOptionMenu(0, R.string.aip, R.raw.actionbar_icon_dark_more, z, new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.ui.conversation.NewBizConversationUI.AnonymousClass12 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(38675);
                if (z) {
                    singleMMKV.encode("NeedShowPayActionBarRedDot", false);
                    NewBizConversationUI.a(NewBizConversationUI.this);
                }
                e eVar = new e((Context) NewBizConversationUI.this, 1, false);
                eVar.HLX = new o.f() {
                    /* class com.tencent.mm.ui.conversation.NewBizConversationUI.AnonymousClass12.AnonymousClass1 */

                    @Override // com.tencent.mm.ui.base.o.f
                    public final void onCreateMMMenu(m mVar) {
                        AppMethodBeat.i(38673);
                        mVar.kV(1, R.string.aim);
                        String decodeString = singleMMKV.decodeString("PaySubscribeEntryUrl", "");
                        if (decodeInt == 1 && !Util.isNullOrNil(decodeString) && cle) {
                            mVar.a(2, NewBizConversationUI.this.getString(R.string.agn), singleMMKV.decodeBool("NeedShowPayRedDot", true));
                        }
                        AppMethodBeat.o(38673);
                    }
                };
                eVar.HLY = new o.g() {
                    /* class com.tencent.mm.ui.conversation.NewBizConversationUI.AnonymousClass12.AnonymousClass2 */

                    @Override // com.tencent.mm.ui.base.o.g
                    public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
                        AppMethodBeat.i(38674);
                        switch (menuItem.getItemId()) {
                            case 1:
                                Intent intent = new Intent(NewBizConversationUI.this.getContext(), BizTimeLineNewMsgUI.class);
                                intent.putExtra("biz_time_line_line_enter_scene", 2);
                                intent.putExtra("biz_time_line_line_session_id", NewBizConversationUI.this.dEb);
                                NewBizConversationUI newBizConversationUI = NewBizConversationUI.this;
                                com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                                com.tencent.mm.hellhoundlib.a.a.a(newBizConversationUI, bl.axQ(), "com/tencent/mm/ui/conversation/NewBizConversationUI$2$2", "onMMMenuItemSelected", "(Landroid/view/MenuItem;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                                newBizConversationUI.startActivity((Intent) bl.pG(0));
                                com.tencent.mm.hellhoundlib.a.a.a(newBizConversationUI, "com/tencent/mm/ui/conversation/NewBizConversationUI$2$2", "onMMMenuItemSelected", "(Landroid/view/MenuItem;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                                AppMethodBeat.o(38674);
                                return;
                            case 2:
                                Intent intent2 = new Intent();
                                MultiProcessMMKV singleMMKV = MultiProcessMMKV.getSingleMMKV("brandService");
                                singleMMKV.encode("NeedShowPayRedDot", false);
                                String decodeString = singleMMKV.decodeString("PaySubscribeEntryUrl", "");
                                if (Util.isNullOrNil(decodeString)) {
                                    Log.e("MicroMsg.NewBizConversationUI", "pay entry url is null!");
                                    AppMethodBeat.o(38674);
                                    return;
                                }
                                intent2.putExtra("rawUrl", decodeString);
                                intent2.putExtra("KRightBtn", true);
                                com.tencent.mm.br.c.b(NewBizConversationUI.this, "webview", ".ui.tools.WebViewUI", intent2);
                                AppMethodBeat.o(38674);
                                return;
                            default:
                                Log.w("MicroMsg.NewBizConversationUI", "default onMMMenuItemSelected err");
                                AppMethodBeat.o(38674);
                                return;
                        }
                    }
                };
                eVar.dGm();
                AppMethodBeat.o(38675);
                return true;
            }
        });
        AppMethodBeat.o(38689);
    }

    private static String gWe() {
        String str;
        AppMethodBeat.i(162388);
        if (com.tencent.mm.kernel.g.aAc()) {
            com.tencent.mm.kernel.g.aAf();
            str = com.tencent.mm.kernel.a.ayV();
        } else {
            str = "";
        }
        String str2 = str + ":PaySubscribeEntryOpen";
        AppMethodBeat.o(162388);
        return str2;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.c3f;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(38690);
        bg.aAk().postToWorker(new Runnable() {
            /* class com.tencent.mm.ui.conversation.NewBizConversationUI.AnonymousClass16 */

            public final void run() {
                AppMethodBeat.i(38679);
                NewBizConversationUI.d(NewBizConversationUI.this);
                NewBizConversationUI.e(NewBizConversationUI.this);
                NewBizConversationUI.f(NewBizConversationUI.this);
                AppMethodBeat.o(38679);
            }
        });
        EventCenter.instance.removeListener(this.ptp);
        if (bg.aAc()) {
            bg.aVF();
            c.aST().remove(this.QgH);
        }
        if (this.QgH != null) {
            this.QgH.onDestroy();
        }
        super.onDestroy();
        AppMethodBeat.o(38690);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        AppMethodBeat.i(38691);
        Log.v("MicroMsg.NewBizConversationUI", "on resume");
        if (this.QgH != null) {
            this.QgH.onResume();
        }
        super.onResume();
        AppMethodBeat.o(38691);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onPause() {
        AppMethodBeat.i(38692);
        Log.i("MicroMsg.NewBizConversationUI", "on pause");
        if (this.QgH != null) {
            this.QgH.onPause();
        }
        super.onPause();
        AppMethodBeat.o(38692);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(38694);
        super.onActivityResult(i2, i3, intent);
        if (this.talker != null && !this.talker.isEmpty()) {
            this.talker = "";
        }
        if (i3 != -1) {
            AppMethodBeat.o(38694);
        } else {
            AppMethodBeat.o(38694);
        }
    }

    /* access modifiers changed from: package-private */
    public static class b extends dna {
        public int jkU;
        public long seq;

        private b() {
            this.jkU = -1;
        }

        /* synthetic */ b(byte b2) {
            this();
        }
    }

    /* access modifiers changed from: package-private */
    public static class a extends e {
        private String dVu;
        HashMap<String, b> pyQ = new HashMap<>();

        public a(Context context, String str, s.a aVar) {
            super(context, aVar);
            AppMethodBeat.i(38683);
            this.dVu = str;
            AppMethodBeat.o(38683);
        }

        @Override // com.tencent.mm.ui.s, com.tencent.mm.ui.conversation.e
        public final void anp() {
            AppMethodBeat.i(38684);
            bg.aVF();
            setCursor(c.aST().c(ab.iCF, this.gzY, this.dVu));
            if (this.OFI != null) {
                this.OFI.bnE();
            }
            super.notifyDataSetChanged();
            AppMethodBeat.o(38684);
        }

        /* access modifiers changed from: protected */
        @Override // com.tencent.mm.ui.conversation.e
        public final void a(az azVar, boolean z, int i2, boolean z2) {
            b bVar;
            u a2;
            AppMethodBeat.i(38685);
            if (azVar == null) {
                AppMethodBeat.o(38685);
                return;
            }
            b bVar2 = this.pyQ.get(azVar.field_username);
            if (bVar2 == null) {
                b bVar3 = new b((byte) 0);
                this.pyQ.put(azVar.field_username, bVar3);
                bVar = bVar3;
            } else {
                bVar = bVar2;
            }
            if (bVar.jkU > 0) {
                AppMethodBeat.o(38685);
                return;
            }
            bVar.MQt = z;
            bVar.MQw = bVar.MQw || azVar.field_unReadCount > 0;
            bVar.xNc = i2 + 1;
            if (z2) {
                bVar.jkU = bVar.xNc;
            }
            bVar.MQv = (int) (System.currentTimeMillis() / 1000);
            if (azVar.field_lastSeq == bVar.seq) {
                AppMethodBeat.o(38685);
                return;
            }
            bVar.seq = azVar.field_lastSeq;
            ca aEx = ((com.tencent.mm.plugin.messenger.foundation.a.l) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).eiy().aEx(azVar.field_username);
            if (aEx != null && aEx.gAt() && (a2 = ((com.tencent.mm.plugin.biz.a.a) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.biz.a.a.class)).a(aEx.field_msgId, aEx.field_content)) != null && !Util.isNullOrNil(a2.iAd) && !Util.isNullOrNil(((v) a2.iAd.get(0)).url)) {
                try {
                    Uri parse = Uri.parse(((v) a2.iAd.get(0)).url);
                    bVar.MQr = Util.getLong(parse.getQueryParameter("mid"), 0);
                    bVar.MQs = Util.getInt(parse.getQueryParameter("idx"), 0);
                    AppMethodBeat.o(38685);
                    return;
                } catch (UnsupportedOperationException e2) {
                    Log.w("MicroMsg.ConversationAdapter", "exposeLog exp %s", e2.getMessage());
                    AppMethodBeat.o(38685);
                    return;
                } catch (Exception e3) {
                    Log.w("MicroMsg.ConversationAdapter", "exposeLog exp %s", e3.getMessage());
                }
            }
            AppMethodBeat.o(38685);
        }

        public final void a(az azVar, int i2) {
            AppMethodBeat.i(38686);
            bg.aVF();
            a(azVar, c.aST().h(azVar), i2, true);
            AppMethodBeat.o(38686);
        }
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        AppMethodBeat.i(38695);
        super.onCreateContextMenu(contextMenu, view, contextMenuInfo);
        bg.aVF();
        as Kn = c.aSN().Kn(this.talker);
        if (Kn == null) {
            Log.e("MicroMsg.NewBizConversationUI", "onCreateContextMenu, contact is null, talker = " + this.talker);
            AppMethodBeat.o(38695);
            return;
        }
        String arJ = Kn.arJ();
        if (arJ.toLowerCase().endsWith("@chatroom") && Util.isNullOrNil(Kn.field_nickname)) {
            arJ = getString(R.string.b25);
        }
        AdapterView.AdapterContextMenuInfo adapterContextMenuInfo = (AdapterView.AdapterContextMenuInfo) contextMenuInfo;
        contextMenu.setHeaderTitle(com.tencent.mm.pluginsdk.ui.span.l.c(this, arJ));
        if (com.tencent.mm.contact.c.oR(Kn.field_type)) {
            if (Kn.arE()) {
                contextMenu.add(adapterContextMenuInfo.position, 1, 0, R.string.agy);
            } else {
                contextMenu.add(adapterContextMenuInfo.position, 1, 0, R.string.agx);
            }
            contextMenu.add(adapterContextMenuInfo.position, 2, 0, R.string.eur);
        }
        contextMenu.add(adapterContextMenuInfo.position, 3, 0, R.string.euz);
        AppMethodBeat.o(38695);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(38693);
        setMMTitle(this.Qbv);
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.ui.conversation.NewBizConversationUI.AnonymousClass14 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(38677);
                NewBizConversationUI.this.finish();
                AppMethodBeat.o(38677);
                return true;
            }
        });
        setTitleBarDoubleClickListener(new Runnable() {
            /* class com.tencent.mm.ui.conversation.NewBizConversationUI.AnonymousClass15 */

            public final void run() {
                AppMethodBeat.i(38678);
                if (NewBizConversationUI.this.activityHasDestroyed() || NewBizConversationUI.this.isFinishing()) {
                    AppMethodBeat.o(38678);
                    return;
                }
                NewBizConversationUI.c(NewBizConversationUI.this);
                AppMethodBeat.o(38678);
            }
        });
        this.Qbt = (ListView) findViewById(R.id.ir8);
        this.emptyTipTv = (TextView) findViewById(R.id.c30);
        this.emptyTipTv.setText(R.string.bww);
        this.QgH = new a(this, this.iNV, new s.a() {
            /* class com.tencent.mm.ui.conversation.NewBizConversationUI.AnonymousClass17 */

            @Override // com.tencent.mm.ui.s.a
            public final void bnE() {
                AppMethodBeat.i(38680);
                NewBizConversationUI.a(NewBizConversationUI.this, NewBizConversationUI.this.QgH.getCount());
                AppMethodBeat.o(38680);
            }
        });
        this.QgH.setGetViewPositionCallback(new MMSlideDelView.c() {
            /* class com.tencent.mm.ui.conversation.NewBizConversationUI.AnonymousClass18 */

            @Override // com.tencent.mm.ui.base.MMSlideDelView.c
            public final int dr(View view) {
                AppMethodBeat.i(38681);
                int positionForView = NewBizConversationUI.this.Qbt.getPositionForView(view);
                AppMethodBeat.o(38681);
                return positionForView;
            }
        });
        this.QgH.setPerformItemClickListener(new MMSlideDelView.g() {
            /* class com.tencent.mm.ui.conversation.NewBizConversationUI.AnonymousClass19 */

            @Override // com.tencent.mm.ui.base.MMSlideDelView.g
            public final void r(View view, int i2, int i3) {
                AppMethodBeat.i(38682);
                NewBizConversationUI.this.Qbt.performItemClick(view, i2, (long) i3);
                AppMethodBeat.o(38682);
            }
        });
        this.Qbt.setAdapter((ListAdapter) this.QgH);
        this.pqr = new com.tencent.mm.ui.widget.b.a(this);
        this.Qbt.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            /* class com.tencent.mm.ui.conversation.NewBizConversationUI.AnonymousClass2 */

            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
                AppMethodBeat.i(38662);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(adapterView);
                bVar.bm(view);
                bVar.pH(i2);
                bVar.zo(j2);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/conversation/NewBizConversationUI$10", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, bVar.axR());
                NewBizConversationUI.this.conversation = (az) NewBizConversationUI.this.QgH.getItem(i2);
                NewBizConversationUI.this.talker = NewBizConversationUI.this.conversation.field_username;
                az azVar = NewBizConversationUI.this.conversation;
                if (azVar == null) {
                    Log.e("MicroMsg.NewBizConversationUI", "user should not be null. position:%d, size:%d", Integer.valueOf(i2), Integer.valueOf(NewBizConversationUI.this.QgH.getCount()));
                    NewBizConversationUI.this.QgH.notifyDataSetChanged();
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/conversation/NewBizConversationUI$10", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                    AppMethodBeat.o(38662);
                    return;
                }
                Intent intent = new Intent(NewBizConversationUI.this, ChattingUI.class);
                intent.putExtra("Chat_User", azVar.field_username);
                intent.putExtra("finish_direct", true);
                intent.putExtra("biz_click_item_unread_count", NewBizConversationUI.this.conversation.field_unReadCount);
                intent.putExtra("biz_click_item_position", i2 + 1);
                intent.putExtra("KOpenArticleSceneFromScene", 92);
                intent.putExtra("specific_chat_from_scene", 6);
                NewBizConversationUI newBizConversationUI = NewBizConversationUI.this;
                com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                com.tencent.mm.hellhoundlib.a.a.a(newBizConversationUI, bl.axQ(), "com/tencent/mm/ui/conversation/NewBizConversationUI$10", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                newBizConversationUI.startActivity((Intent) bl.pG(0));
                com.tencent.mm.hellhoundlib.a.a.a(newBizConversationUI, "com/tencent/mm/ui/conversation/NewBizConversationUI$10", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                NewBizConversationUI.this.QgH.a(azVar, i2);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/conversation/NewBizConversationUI$10", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                AppMethodBeat.o(38662);
            }
        });
        this.Qbt.setOnTouchListener(new View.OnTouchListener() {
            /* class com.tencent.mm.ui.conversation.NewBizConversationUI.AnonymousClass3 */

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                AppMethodBeat.i(38663);
                switch (motionEvent.getAction()) {
                    case 0:
                        NewBizConversationUI.this.ppd = (int) motionEvent.getRawX();
                        NewBizConversationUI.this.ppe = (int) motionEvent.getRawY();
                        break;
                }
                AppMethodBeat.o(38663);
                return false;
            }
        });
        this.Qbt.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            /* class com.tencent.mm.ui.conversation.NewBizConversationUI.AnonymousClass4 */

            @Override // android.widget.AdapterView.OnItemLongClickListener
            public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i2, long j2) {
                AppMethodBeat.i(38664);
                NewBizConversationUI.this.conversation = (az) NewBizConversationUI.this.QgH.getItem(i2);
                NewBizConversationUI.this.talker = NewBizConversationUI.this.conversation.field_username;
                NewBizConversationUI.this.pqr.a(view, i2, j2, NewBizConversationUI.this, NewBizConversationUI.this.pso, NewBizConversationUI.this.ppd, NewBizConversationUI.this.ppe);
                AppMethodBeat.o(38664);
                return true;
            }
        });
        this.QgH.setGetViewPositionCallback(new MMSlideDelView.c() {
            /* class com.tencent.mm.ui.conversation.NewBizConversationUI.AnonymousClass5 */

            @Override // com.tencent.mm.ui.base.MMSlideDelView.c
            public final int dr(View view) {
                AppMethodBeat.i(38665);
                int positionForView = NewBizConversationUI.this.Qbt.getPositionForView(view);
                AppMethodBeat.o(38665);
                return positionForView;
            }
        });
        this.QgH.setPerformItemClickListener(new MMSlideDelView.g() {
            /* class com.tencent.mm.ui.conversation.NewBizConversationUI.AnonymousClass6 */

            @Override // com.tencent.mm.ui.base.MMSlideDelView.g
            public final void r(View view, int i2, int i3) {
                AppMethodBeat.i(38666);
                NewBizConversationUI.this.Qbt.performItemClick(view, i2, (long) i3);
                AppMethodBeat.o(38666);
            }
        });
        this.QgH.a(new MMSlideDelView.f() {
            /* class com.tencent.mm.ui.conversation.NewBizConversationUI.AnonymousClass7 */

            @Override // com.tencent.mm.ui.base.MMSlideDelView.f
            public final void cZ(Object obj) {
                AppMethodBeat.i(38667);
                if (obj == null) {
                    Log.e("MicroMsg.NewBizConversationUI", "onItemDel object null");
                    AppMethodBeat.o(38667);
                    return;
                }
                NewBizConversationUI.b(NewBizConversationUI.this, obj.toString());
                AppMethodBeat.o(38667);
            }
        });
        AppMethodBeat.o(38693);
    }

    static /* synthetic */ void c(NewBizConversationUI newBizConversationUI) {
        AppMethodBeat.i(38698);
        if (!(newBizConversationUI.QgH == null || newBizConversationUI.Qbt == null || newBizConversationUI.QgH.getCount() <= 0)) {
            newBizConversationUI.Qbt.setSelection(0);
        }
        AppMethodBeat.o(38698);
    }

    static /* synthetic */ void d(NewBizConversationUI newBizConversationUI) {
        AppMethodBeat.i(38699);
        if (bg.aAc()) {
            long currentTimeMillis = System.currentTimeMillis();
            int i2 = 0;
            int i3 = 0;
            int i4 = 0;
            long j2 = 0;
            int i5 = 0;
            StringBuilder sb = new StringBuilder("");
            bg.aVF();
            Cursor c2 = c.aST().c(ab.iCF, null, newBizConversationUI.iNV);
            if (c2 != null) {
                int columnIndex = c2.getColumnIndex("unReadCount");
                int columnIndex2 = c2.getColumnIndex("conversationTime");
                int columnIndex3 = c2.getColumnIndex("flag");
                int count = c2.getCount();
                az azVar = new az();
                while (c2.moveToNext()) {
                    azVar.yB(c2.getLong(columnIndex3));
                    int i6 = c2.getInt(columnIndex);
                    if (i6 > 0) {
                        j2 = c2.getLong(columnIndex2);
                        i3++;
                        i2 += i6;
                    } else {
                        i6 = 0;
                    }
                    sb.append(c2.isFirst() ? "" : ".").append(i6);
                    bg.aVF();
                    if (c.aST().h(azVar)) {
                        i4++;
                    }
                }
                c2.close();
                i5 = count;
            }
            h.INSTANCE.a(13771, Integer.valueOf(i5), Integer.valueOf(i3), Integer.valueOf(i2), Long.valueOf(j2 / 1000), Integer.valueOf(i4), sb.toString());
            Log.v("MicroMsg.NewBizConversationUI", "report use time:%d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        }
        AppMethodBeat.o(38699);
    }

    static /* synthetic */ void e(NewBizConversationUI newBizConversationUI) {
        AppMethodBeat.i(38700);
        if (newBizConversationUI.pss != 0) {
            h.INSTANCE.a(13932, Integer.valueOf(((int) (System.currentTimeMillis() - newBizConversationUI.pss)) / 1000), 2, Integer.valueOf(newBizConversationUI.dEb), 0, Integer.valueOf(newBizConversationUI.source));
        }
        AppMethodBeat.o(38700);
    }

    static /* synthetic */ void f(NewBizConversationUI newBizConversationUI) {
        AppMethodBeat.i(162390);
        if (newBizConversationUI.QgH != null) {
            LinkedList linkedList = new LinkedList();
            for (Map.Entry<String, b> entry : newBizConversationUI.QgH.pyQ.entrySet()) {
                b value = entry.getValue();
                dna dna = new dna();
                dna.KSV = entry.getKey();
                dna.MQr = value.MQr;
                dna.MQs = value.MQs;
                dna.xNc = value.xNc;
                dna.MQu = value.jkU > 0;
                dna.MQw = value.MQw;
                dna.MQt = value.MQt;
                dna.MQv = value.MQv;
                linkedList.add(dna);
            }
            com.tencent.mm.kernel.g.aAg().hqi.a(new ae(linkedList), 0);
            Log.d("MicroMsg.NewBizConversationUI", "reportExpose size:%d", Integer.valueOf(linkedList.size()));
        }
        AppMethodBeat.o(162390);
    }

    static /* synthetic */ void a(NewBizConversationUI newBizConversationUI, int i2) {
        AppMethodBeat.i(162391);
        if (i2 <= 0) {
            newBizConversationUI.emptyTipTv.setVisibility(0);
            newBizConversationUI.Qbt.setVisibility(8);
            AppMethodBeat.o(162391);
            return;
        }
        newBizConversationUI.emptyTipTv.setVisibility(8);
        newBizConversationUI.Qbt.setVisibility(0);
        AppMethodBeat.o(162391);
    }

    static /* synthetic */ void b(NewBizConversationUI newBizConversationUI, String str) {
        AppMethodBeat.i(162392);
        if (Util.isNullOrNil(str)) {
            Log.e("MicroMsg.NewBizConversationUI", "Delete Conversation and messages fail because username is null or nil.");
            AppMethodBeat.o(162392);
            return;
        }
        h.INSTANCE.a(13773, 0, Integer.valueOf(newBizConversationUI.conversation.field_unReadCount), 0, newBizConversationUI.conversation.field_username);
        bg.aVF();
        ca aEw = c.aSQ().aEw(str);
        afk afk = new afk();
        afk.Lqk = new dqi().bhy(Util.nullAsNil(str));
        afk.Brn = aEw.field_msgSvrId;
        bg.aVF();
        c.aSM().d(new k.a(8, afk));
        newBizConversationUI.isDeleteCancel = false;
        newBizConversationUI.getString(R.string.zb);
        final q a2 = com.tencent.mm.ui.base.h.a((Context) newBizConversationUI, newBizConversationUI.getString(R.string.a06), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
            /* class com.tencent.mm.ui.conversation.NewBizConversationUI.AnonymousClass8 */

            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.i(38668);
                NewBizConversationUI.this.isDeleteCancel = true;
                AppMethodBeat.o(38668);
            }
        });
        bp.a(str, new bp.a() {
            /* class com.tencent.mm.ui.conversation.NewBizConversationUI.AnonymousClass9 */

            @Override // com.tencent.mm.model.bp.a
            public final boolean amG() {
                AppMethodBeat.i(38669);
                boolean z = NewBizConversationUI.this.isDeleteCancel;
                AppMethodBeat.o(38669);
                return z;
            }

            @Override // com.tencent.mm.model.bp.a
            public final void amH() {
                AppMethodBeat.i(38670);
                if (a2 != null) {
                    a2.dismiss();
                }
                AppMethodBeat.o(38670);
            }
        });
        bg.aVF();
        as Kn = c.aSN().Kn(str);
        bg.aVF();
        az bjY = c.aST().bjY(str);
        bg.aVF();
        c.aST().bjW(str);
        ag.ban().aEn(str);
        if (bjY != null && (bjY.oV(4194304) || (Kn != null && Kn.gBM() && !com.tencent.mm.contact.c.oR(Kn.field_type) && bjY.field_conversationTime < ag.baw()))) {
            bg.azz().a(new com.tencent.mm.modelsimple.i(str), 0);
        }
        AppMethodBeat.o(162392);
    }
}

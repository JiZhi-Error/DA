package com.tencent.mm.ui.chatting.d;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.PorterDuff;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.ActionBarContainer;
import android.text.SpannableString;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.gms.common.Scopes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.aj.e;
import com.tencent.mm.aj.p;
import com.tencent.mm.g.a.zj;
import com.tencent.mm.g.b.a.gq;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.ay;
import com.tencent.mm.model.b.b;
import com.tencent.mm.model.b.e;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.appbrand.config.ae;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.gamelife.PluginGameLife;
import com.tencent.mm.plugin.newtips.PluginNewTips;
import com.tencent.mm.plugin.newtips.a.k;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.textstatus.a.a;
import com.tencent.mm.plugin.textstatus.a.c;
import com.tencent.mm.pluginsdk.ui.applet.a;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.protocal.protobuf.ehv;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorage;
import com.tencent.mm.sdk.storage.MStorageEventData;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.cf;
import com.tencent.mm.ui.AppBrandNotifySettingsUI;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.SingleChatInfoUI;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.d.b.aa;
import com.tencent.mm.ui.chatting.d.b.ac;
import com.tencent.mm.ui.chatting.d.b.ai;
import com.tencent.mm.ui.chatting.d.b.am;
import com.tencent.mm.ui.chatting.d.b.d;
import com.tencent.mm.ui.chatting.d.b.f;
import com.tencent.mm.ui.chatting.d.b.i;
import com.tencent.mm.ui.chatting.d.b.o;
import com.tencent.mm.ui.chatting.d.b.s;
import com.tencent.mm.ui.chatting.d.b.u;
import com.tencent.mm.ui.conversation.ServiceNotifyConversationUI;
import com.tencent.mm.ui.conversation.a.e;
import com.tencent.mm.ui.t;
import com.tencent.mm.ui.w;
import com.tencent.mm.ui.y;
import java.util.LinkedList;
import java.util.List;

@com.tencent.mm.ui.chatting.d.a.a(gRF = aa.class)
public class ad extends a implements aa {
    private int Dkc = 0;
    private final MStorage.IOnStorageChange Pnh = new MStorage.IOnStorageChange() {
        /* class com.tencent.mm.ui.chatting.d.ad.AnonymousClass7 */

        @Override // com.tencent.mm.sdk.storage.MStorage.IOnStorageChange
        public final void onNotifyChange(String str, MStorageEventData mStorageEventData) {
            AppMethodBeat.i(179918);
            Log.v("MicroMsg.ChattingUI.HeaderComponent", "roommember watcher notify ".concat(String.valueOf(str)));
            if (ad.this.dom.gRM() && !Util.isNullOrNil(str)) {
                ad.this.gPx();
                ad.this.gQp();
            }
            AppMethodBeat.o(179918);
        }
    };
    private boolean Pnm = false;
    private Runnable PrA = null;
    private final e.a PrB = new e.a() {
        /* class com.tencent.mm.ui.chatting.d.ad.AnonymousClass6 */

        @Override // com.tencent.mm.aj.e.a
        public final void Mr(final String str) {
            AppMethodBeat.i(179917);
            com.tencent.mm.ui.chatting.e.a.gRP().removeCallbacks(ad.this.PrA);
            com.tencent.mm.ui.chatting.e.a.gRP().postDelayed(ad.this.PrA = new Runnable() {
                /* class com.tencent.mm.ui.chatting.d.ad.AnonymousClass6.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(179916);
                    if (!Util.isNullOrNil(ad.this.Prt) && !Util.isNullOrNil(str) && str.equals(ad.this.Prt)) {
                        ad.this.BR(false);
                    }
                    AppMethodBeat.o(179916);
                }
            }, 1000);
            AppMethodBeat.o(179917);
        }
    };
    private View.OnClickListener PrC = new View.OnClickListener() {
        /* class com.tencent.mm.ui.chatting.d.ad.AnonymousClass10 */

        public final void onClick(View view) {
            AppMethodBeat.i(233132);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/component/HeaderComponent$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            ((c) g.ah(c.class)).showCardDialog(ad.this.dom.Pwc.getContext(), ad.this.dom.GUe.field_username);
            ((c) g.ah(c.class)).report22210(ad.this.dom.GUe.field_username, 2);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/component/HeaderComponent$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(233132);
        }
    };
    final int PrD = 1;
    final int PrE = 2;
    final MenuItem.OnMenuItemClickListener PrF = new MenuItem.OnMenuItemClickListener() {
        /* class com.tencent.mm.ui.chatting.d.ad.AnonymousClass12 */

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.i(233133);
            zj zjVar = new zj();
            zjVar.efx.dKy = 5;
            zjVar.efx.talker = ad.this.dom.GUe.field_username;
            zjVar.efx.context = ad.this.dom.Pwc.getContext();
            if (menuItem.getItemId() == 1) {
                zjVar.efx.eft = 4;
            } else if (menuItem.getItemId() == 2) {
                zjVar.efx.eft = 2;
            }
            EventCenter.instance.publish(zjVar);
            AppMethodBeat.o(233133);
            return true;
        }
    };
    private View PrG = null;
    private View PrH = null;
    protected LinearLayout Prp;
    protected LinearLayout Prq;
    protected LinearLayout Prr;
    private List<String> Prs = new LinkedList();
    private String Prt;
    public w Pru = null;
    private com.tencent.mm.ui.a Prv;
    private View Prw;
    private a Prx;
    final y Pry = new b();
    private b.a Prz = new b.a() {
        /* class com.tencent.mm.ui.chatting.d.ad.AnonymousClass5 */

        @Override // com.tencent.mm.model.b.b.a
        public final void aXg() {
            AppMethodBeat.i(179915);
            com.tencent.mm.ui.chatting.e.a.gRP().post(new Runnable() {
                /* class com.tencent.mm.ui.chatting.d.ad.AnonymousClass5.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(35371);
                    bg.aVF().aTo();
                    if (com.tencent.mm.model.b.b.a(b.EnumC0443b.Chatting)) {
                        ad.c(ad.this);
                        AppMethodBeat.o(35371);
                        return;
                    }
                    ad.d(ad.this);
                    AppMethodBeat.o(35371);
                }
            });
            AppMethodBeat.o(179915);
        }
    };
    private MenuItem.OnMenuItemClickListener backListener = new MenuItem.OnMenuItemClickListener() {
        /* class com.tencent.mm.ui.chatting.d.ad.AnonymousClass11 */

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.i(179922);
            boolean gNh = ad.this.dom.Pwc.gNh();
            AppMethodBeat.o(179922);
            return gNh;
        }
    };
    private ActionBarContainer mActionBarContainer = null;

    public ad() {
        AppMethodBeat.i(35388);
        AppMethodBeat.o(35388);
    }

    static /* synthetic */ void c(ad adVar) {
        AppMethodBeat.i(35430);
        adVar.gQq();
        AppMethodBeat.o(35430);
    }

    static /* synthetic */ void d(ad adVar) {
        AppMethodBeat.i(179928);
        adVar.gQx();
        AppMethodBeat.o(179928);
    }

    static /* synthetic */ void g(ad adVar) {
        AppMethodBeat.i(35432);
        adVar.gQt();
        AppMethodBeat.o(35432);
    }

    static /* synthetic */ void h(ad adVar) {
        AppMethodBeat.i(35433);
        adVar.gQu();
        AppMethodBeat.o(35433);
    }

    static /* synthetic */ void i(ad adVar) {
        AppMethodBeat.i(35434);
        adVar.gQv();
        AppMethodBeat.o(35434);
    }

    static /* synthetic */ void j(ad adVar) {
        AppMethodBeat.i(179929);
        adVar.gQw();
        AppMethodBeat.o(179929);
    }

    @Override // com.tencent.mm.ui.l
    public final void onConfigurationChanged(Configuration configuration) {
        boolean z = true;
        AppMethodBeat.i(35389);
        super.onConfigurationChanged(configuration);
        Log.d("MicroMsg.ChattingUI.HeaderComponent", "getConfiguration().orientation = " + this.dom.Pwc.getMMResources().getConfiguration().orientation + ", newConfig.orientation = " + configuration.orientation);
        this.dom.Pwc.getMMResources().getConfiguration().orientation = configuration.orientation;
        Log.i("MicroMsg.ChatFooter", "[dealOrientationChange] %s", ((u) this.dom.bh(u.class)).gPO().getContext().getResources().getConfiguration());
        boolean z2 = this.mActionBarContainer != null;
        if (this.Prw == null) {
            z = false;
        }
        if (z2 && z) {
            int cy = com.tencent.mm.compatible.util.a.cy(this.dom.Pwc.getContext());
            this.Prw.setMinimumHeight(cy);
            ViewGroup.LayoutParams layoutParams = this.Prw.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new ViewGroup.LayoutParams(-1, -1);
            }
            layoutParams.height = cy;
            this.Prw.setLayoutParams(layoutParams);
            ViewGroup.LayoutParams layoutParams2 = this.mActionBarContainer.getLayoutParams();
            layoutParams2.height = cy;
            this.mActionBarContainer.setLayoutParams(layoutParams2);
        }
        if (this.Pru != null) {
            this.Pru.OHt.mActionBar.onConfigurationChanged(configuration);
        }
        AppMethodBeat.o(35389);
    }

    @Override // com.tencent.mm.ui.chatting.d.ag, com.tencent.mm.ui.chatting.d.a
    public final void a(com.tencent.mm.ui.chatting.e.a aVar) {
        AppMethodBeat.i(35390);
        super.a(aVar);
        if (isSupportCustomActionBar()) {
            this.Pru = new w();
            w wVar = this.Pru;
            BaseChattingUIFragment baseChattingUIFragment = this.dom.Pwc;
            wVar.OHs = baseChattingUIFragment;
            wVar.OHt = new com.tencent.mm.ui.b.b(baseChattingUIFragment.thisActivity(), wVar);
            this.dom.Pwc.setActivityController(this.Pru);
        }
        AppMethodBeat.o(35390);
    }

    @Override // com.tencent.mm.ui.m, com.tencent.mm.ui.chatting.d.a
    public final void gIk() {
        AppMethodBeat.i(35391);
        gQn();
        AppMethodBeat.o(35391);
    }

    @Override // com.tencent.mm.ui.m, com.tencent.mm.ui.chatting.d.a
    public final void gIm() {
        AppMethodBeat.i(35393);
        BR(true);
        AppMethodBeat.o(35393);
    }

    @Override // com.tencent.mm.ui.m, com.tencent.mm.ui.chatting.d.a
    public final void gIn() {
        AppMethodBeat.i(35396);
        gQl();
        AppMethodBeat.o(35396);
    }

    @Override // com.tencent.mm.ui.chatting.d.ag, com.tencent.mm.ui.chatting.d.a
    public final void gOK() {
        AppMethodBeat.i(35397);
        super.gOK();
        gQl();
        AppMethodBeat.o(35397);
    }

    class b extends y {
        b() {
        }

        @Override // com.tencent.mm.ui.y
        public final void ane() {
            String str;
            com.tencent.mm.msgsubscription.b.a Ru;
            String displayName;
            AppMethodBeat.i(35387);
            if (((ai) ad.this.dom.bh(ai.class)).gQP()) {
                AppMethodBeat.o(35387);
                return;
            }
            if (ab.Iy(ad.this.dom.getTalkerUserName())) {
                gq gqVar = new gq();
                gqVar.us(ad.this.dom.getTalkerUserName());
                gqVar.erw = 4;
                gqVar.bfK();
            }
            if (ad.this.Prx != null && ad.this.Prx.PrR) {
                com.tencent.mm.plugin.newtips.a.exl().TC(25);
            }
            if (ab.IL(ad.this.dom.getTalkerUserName())) {
                h.INSTANCE.a(19540, 2);
            }
            ad.this.dom.hideVKB();
            if (ab.Jx(ad.this.dom.getTalkerUserName())) {
                if (((o) ad.this.dom.bh(o.class)).gPH()) {
                    String gPI = ((o) ad.this.dom.bh(o.class)).gPI();
                    if (as.HF(gPI)) {
                        com.tencent.mm.msgsubscription.api.b bVar = com.tencent.mm.msgsubscription.api.b.jza;
                        Ru = com.tencent.mm.msgsubscription.api.b.Ru("name_wxa");
                        ae Xr = com.tencent.mm.plugin.appbrand.config.y.Xr(gPI);
                        if (Xr != null) {
                            displayName = Xr.nickname;
                        } else {
                            Log.e("MicroMsg.ChattingUI.HeaderComponent", "attrs is null");
                            displayName = null;
                        }
                    } else {
                        com.tencent.mm.msgsubscription.api.b bVar2 = com.tencent.mm.msgsubscription.api.b.jza;
                        Ru = com.tencent.mm.msgsubscription.api.b.Ru("name_biz");
                        displayName = com.tencent.mm.model.aa.getDisplayName(gPI);
                    }
                    if (Ru != null) {
                        Ru.a(ad.this.dom.Pwc.getContext(), 4, gPI, displayName);
                    } else {
                        Log.e("MicroMsg.ChattingUI.HeaderComponent", "service is null");
                    }
                    h.INSTANCE.a(21825, 7, gPI, Long.valueOf(Util.nowSecond()), null, null, 0, 0, 0);
                    AppMethodBeat.o(35387);
                    return;
                }
                Activity context = ad.this.dom.Pwc.getContext();
                com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(new Intent(ad.this.dom.Pwc.getContext(), ServiceNotifyConversationUI.class));
                com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/ui/chatting/component/HeaderComponent$OptionListener", "onRealClick", "(Landroid/view/MenuItem;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                context.startActivity((Intent) bl.pG(0));
                com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/ui/chatting/component/HeaderComponent$OptionListener", "onRealClick", "(Landroid/view/MenuItem;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                h.INSTANCE.a(21825, 1, null, Long.valueOf(Util.nowSecond()), null, null, 0, 0, 0);
                AppMethodBeat.o(35387);
            } else if (ab.JC(ad.this.dom.getTalkerUserName())) {
                Intent intent = new Intent(ad.this.dom.Pwc.getContext(), AppBrandNotifySettingsUI.class);
                com.tencent.mm.plugin.appbrand.service.g gVar = (com.tencent.mm.plugin.appbrand.service.g) g.af(com.tencent.mm.plugin.appbrand.service.g.class);
                if (gVar != null) {
                    String bul = gVar.bul();
                    intent.putExtra("report_session_id", bul);
                    str = bul;
                } else {
                    str = null;
                }
                Activity context2 = ad.this.dom.Pwc.getContext();
                com.tencent.mm.hellhoundlib.b.a bl2 = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                com.tencent.mm.hellhoundlib.a.a.a(context2, bl2.axQ(), "com/tencent/mm/ui/chatting/component/HeaderComponent$OptionListener", "onRealClick", "(Landroid/view/MenuItem;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                context2.startActivity((Intent) bl2.pG(0));
                com.tencent.mm.hellhoundlib.a.a.a(context2, "com/tencent/mm/ui/chatting/component/HeaderComponent$OptionListener", "onRealClick", "(Landroid/view/MenuItem;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                h.INSTANCE.a(19724, 1, 6, 0, 0, 0, null, 0, 0, 0, null, null, null, null, 0, null, null, 0, null, null, str);
                AppMethodBeat.o(35387);
            } else if (ab.IP(ad.this.dom.getTalkerUserName())) {
                Intent intent2 = new Intent();
                intent2.putExtra("Contact_User", ad.this.dom.getTalkerUserName());
                com.tencent.mm.br.c.b(ad.this.dom.Pwc.getContext(), Scopes.PROFILE, ".ui.ContactInfoUI", intent2);
                AppMethodBeat.o(35387);
            } else if (((ac) ad.this.dom.bh(ac.class)).gQH()) {
                ad.b(ad.this);
                AppMethodBeat.o(35387);
            } else if (((d) ad.this.dom.bh(d.class)).gPa()) {
                AppMethodBeat.o(35387);
            } else {
                if (((i) ad.this.dom.bh(i.class)).gPw()) {
                    ((PluginGameLife) g.ah(PluginGameLife.class)).jumpToGameLifeSingleChatInfoUIReport(ad.this.dom.getTalkerUserName());
                }
                Intent intent3 = new Intent();
                intent3.setClass(ad.this.dom.Pwc.getContext(), SingleChatInfoUI.class);
                intent3.putExtra("Single_Chat_Talker", ad.this.dom.getTalkerUserName());
                intent3.putExtra("fromChatting", true);
                BaseChattingUIFragment baseChattingUIFragment = ad.this.dom.Pwc;
                com.tencent.mm.hellhoundlib.b.a bl3 = new com.tencent.mm.hellhoundlib.b.a().bl(intent3);
                com.tencent.mm.hellhoundlib.a.a.a(baseChattingUIFragment, bl3.axQ(), "com/tencent/mm/ui/chatting/component/HeaderComponent$OptionListener", "onRealClick", "(Landroid/view/MenuItem;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                baseChattingUIFragment.startActivity((Intent) bl3.pG(0));
                com.tencent.mm.hellhoundlib.a.a.a(baseChattingUIFragment, "com/tencent/mm/ui/chatting/component/HeaderComponent$OptionListener", "onRealClick", "(Landroid/view/MenuItem;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                AppMethodBeat.o(35387);
            }
        }
    }

    @Override // com.tencent.mm.ui.chatting.d.b.aa
    public final void gQk() {
        int i2;
        AppMethodBeat.i(35398);
        if (this.dom.getHeaderViewsCount() > 0) {
            this.Prp = (LinearLayout) this.dom.getListView().findViewById(R.id.ecr);
        } else {
            this.Prp = (LinearLayout) this.dom.Pwc.getContext().getLayoutInflater().inflate(R.layout.tv, (ViewGroup) null);
            this.dom.Pwd.addHeaderView(this.Prp);
        }
        if (((ai) this.dom.bh(ai.class)).gQN() && this.dom.getListView().getFooterViewsCount() == 0) {
            this.Prq = (LinearLayout) this.dom.Pwc.getContext().getLayoutInflater().inflate(R.layout.tt, (ViewGroup) null);
            this.dom.getListView().addFooterView(this.Prq);
            if (((ai) this.dom.bh(ai.class)).gQO() && (i2 = g.aAh().azQ().getInt(ar.a.USERINFO_SELECT_RECORD_FOOT_VIEW_HEIGHT_INT_SYNC, 0)) != 0) {
                View findViewById = this.dom.getListView().findViewById(R.id.ecq);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) findViewById.getLayoutParams();
                layoutParams.height = i2;
                findViewById.setLayoutParams(layoutParams);
            }
        }
        gQu();
        AppMethodBeat.o(35398);
    }

    private void doResume() {
        AppMethodBeat.i(35399);
        if (ab.IJ(this.dom.getTalkerUserName()) || ab.IK(this.dom.getTalkerUserName()) || ab.IL(this.dom.getTalkerUserName()) || (1 == ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_minishop_plugin_enabled, 0) && ab.IM(this.dom.getTalkerUserName()))) {
            com.tencent.mm.plugin.newtips.a.exo();
            this.dom.Pwc.addIconOptionMenu(0, R.string.d0, R.raw.actionbar_setting_icon, Boolean.valueOf(com.tencent.mm.plugin.newtips.a.e.Ty(com.tencent.mm.plugin.newtips.a.d.ADd)).booleanValue(), this.Pry);
        }
        AppMethodBeat.o(35399);
    }

    private void gQl() {
        AppMethodBeat.i(35400);
        if (g.aAf().azp()) {
            p.aYn().b(this.PrB);
            bg.aVF();
            com.tencent.mm.model.c.aSX().remove(this.Pnh);
        }
        com.tencent.mm.ui.chatting.e.a.gRP().removeCallbacks(this.PrA);
        v.aTR();
        if (this.Prx != null) {
            com.tencent.mm.plugin.newtips.a.exl();
            com.tencent.mm.plugin.newtips.a.i.i(this.Prx);
        }
        AppMethodBeat.o(35400);
    }

    @Override // com.tencent.mm.ui.chatting.d.b.aa
    public final void gPx() {
        String string;
        AppMethodBeat.i(35401);
        this.dom.Pwc.setMMSubTitle((String) null);
        if (((ai) this.dom.bh(ai.class)).gQN()) {
            setMMTitle("");
            AppMethodBeat.o(35401);
        } else if (ab.IJ(this.dom.getTalkerUserName())) {
            setMMTitle(this.dom.GUe.arI());
            AppMethodBeat.o(35401);
        } else if (((am) this.dom.bh(am.class)).gRa()) {
            setMMTitle(R.string.gff);
            AppMethodBeat.o(35401);
        } else if (as.bjm(this.dom.getTalkerUserName())) {
            ((u) this.dom.bh(u.class)).gPO().setWordCountLimit(140);
            setMMTitle(this.dom.GUe.arJ());
            AppMethodBeat.o(35401);
        } else if (ab.Jz(this.dom.getTalkerUserName())) {
            if (((o) this.dom.bh(o.class)).gPH()) {
                setMMTitle(this.dom.Pwc.getContext().getString(R.string.fhv));
                AppMethodBeat.o(35401);
                return;
            }
            setMMTitle(this.dom.GUe.arI());
            AppMethodBeat.o(35401);
        } else if (as.IG(this.dom.getTalkerUserName())) {
            setMMTitle(this.dom.Pwc.getContext().getString(R.string.ako, new Object[]{av(this.dom.GUe)}).trim());
            AppMethodBeat.o(35401);
        } else {
            if (as.HF(this.dom.getTalkerUserName())) {
                if (this.dom.bh(com.tencent.mm.ui.chatting.d.b.a.class) != null) {
                    ((com.tencent.mm.ui.chatting.d.b.a) this.dom.bh(com.tencent.mm.ui.chatting.d.b.a.class)).gPx();
                    AppMethodBeat.o(35401);
                    return;
                }
            } else if (this.dom.gRL()) {
                boolean gPk = ((f) this.dom.bh(f.class)).gPk();
                String str = this.dom.GUe.field_conRemark;
                if (Util.isNullOrNil(str)) {
                    str = this.dom.GUe.field_nickname;
                } else {
                    setMMSubTitle(l.c(this.dom.Pwc.getContext(), this.dom.gOZ()).toString());
                }
                if (!Util.isNullOrNil(str)) {
                    string = this.dom.Pwc.getContext().getString(R.string.dea, new Object[]{this.dom.GUe.arJ(), Integer.valueOf(v.Ie(this.dom.getTalkerUserName()))});
                } else if (v.Ie(this.dom.getTalkerUserName()) == 0) {
                    string = this.dom.Pwc.getContext().getString(R.string.b25);
                } else {
                    string = this.dom.Pwc.getContext().getString(R.string.dea, new Object[]{this.dom.Pwc.getContext().getString(R.string.b25), Integer.valueOf(v.Ie(this.dom.getTalkerUserName()))});
                }
                if (ab.Iy(this.dom.getTalkerUserName()) || gPk) {
                    string = l.d(this.dom.Pwc.getContext(), l.e((Context) this.dom.Pwc.getContext(), (CharSequence) (((Object) string) + " "), com.tencent.mm.cb.a.aG(this.dom.Pwc.getContext(), R.dimen.l)));
                }
                setMMTitle(string);
                AppMethodBeat.o(35401);
                return;
            } else if (((d) this.dom.bh(d.class)).gOR()) {
                AppMethodBeat.o(35401);
                return;
            } else if (((i) this.dom.bh(i.class)).gPw()) {
                ((i) this.dom.bh(i.class)).gPx();
                AppMethodBeat.o(35401);
                return;
            } else if (((com.tencent.mm.ui.chatting.d.b.h) this.dom.bh(com.tencent.mm.ui.chatting.d.b.h.class)).gPu()) {
                ((com.tencent.mm.ui.chatting.d.b.h) this.dom.bh(com.tencent.mm.ui.chatting.d.b.h.class)).gPx();
                AppMethodBeat.o(35401);
                return;
            } else {
                this.Prv.AS(as.bjo(this.dom.getTalkerUserName()));
                this.dom.Pwc.setMMTitle(this.dom.GUe.arJ());
                this.Prv.AS(as.bjo(this.dom.getTalkerUserName()));
                if (as.bjp(this.dom.getTalkerUserName())) {
                    this.dom.Pwc.setMMSubTitle(((com.tencent.mm.openim.a.a) g.af(com.tencent.mm.openim.a.a.class)).bN(this.dom.GUe.field_openImAppid, this.dom.GUe.field_descWordingId));
                }
            }
            AppMethodBeat.o(35401);
        }
    }

    private void gQm() {
        AppMethodBeat.i(233135);
        View findViewById = this.dom.Pwc.findViewById(R.id.ipv);
        if (findViewById != null) {
            findViewById.setOnClickListener(this.PrC);
        }
        AppMethodBeat.o(233135);
    }

    @Override // com.tencent.mm.ui.chatting.d.b.aa
    public final void setMMTitle(int i2) {
        AppMethodBeat.i(35402);
        setMMTitle(this.dom.Pwc.getMMResources().getString(i2));
        AppMethodBeat.o(35402);
    }

    private String av(as asVar) {
        AppMethodBeat.i(35403);
        if (asVar == null) {
            String string = this.dom.Pwc.getContext().getString(R.string.alg);
            AppMethodBeat.o(35403);
            return string;
        } else if (RegionCodeDecoder.bkO(asVar.getCountryCode())) {
            String city = asVar.getCity();
            if (!Util.isNullOrNil(city)) {
                AppMethodBeat.o(35403);
                return city;
            }
            String It = com.tencent.mm.model.aa.It(asVar.getProvince());
            if (!Util.isNullOrNil(It)) {
                AppMethodBeat.o(35403);
                return It;
            }
            RegionCodeDecoder.gEm();
            String locName = RegionCodeDecoder.getLocName(asVar.getCountryCode());
            AppMethodBeat.o(35403);
            return locName;
        } else {
            String It2 = com.tencent.mm.model.aa.It(asVar.getProvince());
            if (!Util.isNullOrNil(It2)) {
                AppMethodBeat.o(35403);
                return It2;
            }
            String string2 = this.dom.Pwc.getContext().getString(R.string.alg);
            AppMethodBeat.o(35403);
            return string2;
        }
    }

    private boolean isSupportCustomActionBar() {
        AppMethodBeat.i(35404);
        boolean isSupportNavigationSwipeBack = this.dom.Pwc.isSupportNavigationSwipeBack();
        AppMethodBeat.o(35404);
        return isSupportNavigationSwipeBack;
    }

    @Override // com.tencent.mm.ui.chatting.d.b.aa
    public final void gC(View view) {
        AppMethodBeat.i(35405);
        Log.d("MicroMsg.ChattingUI.HeaderComponent", "dealContentView");
        if (isSupportCustomActionBar()) {
            if (this.mActionBarContainer == null) {
                this.mActionBarContainer = (ActionBarContainer) ((ViewStub) view.findViewById(R.id.auq)).inflate();
            }
            this.Pru.OHt.WN = (ViewGroup) view;
        }
        AppMethodBeat.o(35405);
    }

    private View P(ViewGroup viewGroup) {
        AppMethodBeat.i(35406);
        if (this.Prw == null) {
            if (viewGroup == null) {
                this.Prw = com.tencent.mm.ui.aa.jQ(this.dom.Pwc.getContext()).inflate(R.layout.bc, (ViewGroup) null);
            } else {
                this.Prw = com.tencent.mm.ui.aa.jQ(this.dom.Pwc.getContext()).inflate(R.layout.bc, viewGroup, false);
            }
            View view = this.Prw;
            AppMethodBeat.o(35406);
            return view;
        } else if (this.Prw.getParent() == null) {
            View view2 = this.Prw;
            AppMethodBeat.o(35406);
            return view2;
        } else if (this.Prw.getParent() instanceof ViewGroup) {
            ((ViewGroup) this.Prw.getParent()).removeView(this.Prw);
            View view3 = this.Prw;
            AppMethodBeat.o(35406);
            return view3;
        } else {
            if (viewGroup == null) {
                this.Prw = com.tencent.mm.ui.aa.jQ(this.dom.Pwc.getContext()).inflate(R.layout.bc, (ViewGroup) null);
            } else {
                this.Prw = com.tencent.mm.ui.aa.jQ(this.dom.Pwc.getContext()).inflate(R.layout.bc, viewGroup, false);
            }
            View view4 = this.Prw;
            AppMethodBeat.o(35406);
            return view4;
        }
    }

    @Override // com.tencent.mm.ui.chatting.d.b.aa
    public final void gQn() {
        ActionBar actionBar;
        AppMethodBeat.i(35407);
        if (((MMFragment) this.dom.Pwc).isCurrentActivity || !isSupportCustomActionBar()) {
            actionBar = ((AppCompatActivity) this.dom.Pwc.getContext()).getSupportActionBar();
            View P = P(null);
            actionBar.setCustomView(P);
            this.Prv = new com.tencent.mm.ui.a(P);
        } else {
            ViewGroup viewGroup = (ViewGroup) this.mActionBarContainer.findViewById(R.id.c7);
            Log.i("MicroMsg.ChattingUI.HeaderComponent", "mActionBarContainer %s", this.mActionBarContainer);
            Log.i("MicroMsg.ChattingUI.HeaderComponent", "ctxView %s", this.mActionBarContainer.findViewById(R.id.cn));
            viewGroup.setVisibility(0);
            ActionBar supportActionBar = this.Pru.getSupportActionBar();
            View P2 = P(viewGroup);
            supportActionBar.setCustomView(P2);
            this.Prv = new com.tencent.mm.ui.a(P2);
            int height = supportActionBar.getHeight();
            if (height == 0) {
                DisplayMetrics displayMetrics = this.dom.Pwc.getMMResources().getDisplayMetrics();
                if (displayMetrics.widthPixels > displayMetrics.heightPixels) {
                    height = this.dom.Pwc.getMMResources().getDimensionPixelSize(R.dimen.b8);
                } else {
                    height = this.dom.Pwc.getMMResources().getDimensionPixelSize(R.dimen.b9);
                }
            }
            P2.setMinimumHeight(height);
            ViewGroup.LayoutParams layoutParams = P2.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new ViewGroup.LayoutParams(-1, -1);
            }
            layoutParams.height = height;
            layoutParams.width = -1;
            P2.setLayoutParams(layoutParams);
            actionBar = supportActionBar;
        }
        a(actionBar);
        this.Prv.AS(false);
        actionBar.setDisplayOptions((actionBar.getDisplayOptions() | 16) & -5 & -3 & -9);
        gQo();
        setBackBtn(this.backListener);
        AppMethodBeat.o(35407);
    }

    private void a(ActionBar actionBar) {
        AppMethodBeat.i(35408);
        boolean isDarkMode = ao.isDarkMode();
        if (actionBar.getCustomView() != null) {
            ImageView imageView = (ImageView) actionBar.getCustomView().findViewById(R.id.uo);
            if (imageView != null && isDarkMode) {
                if (imageView.getDrawable() != null) {
                    imageView.getDrawable().setColorFilter(-1, PorterDuff.Mode.SRC_ATOP);
                } else {
                    imageView.setColorFilter(-1, PorterDuff.Mode.SRC_ATOP);
                }
            }
            TextView textView = (TextView) actionBar.getCustomView().findViewById(R.id.ipt);
            if (textView != null) {
                ao.a(textView.getPaint(), 0.8f);
                if (isDarkMode) {
                    textView.setTextColor(this.dom.Pwc.getMMResources().getColor(R.color.bw));
                }
            }
            TextView textView2 = (TextView) actionBar.getCustomView().findViewById(R.id.id2);
            if (textView2 != null && isDarkMode) {
                textView2.setTextColor(this.dom.Pwc.getMMResources().getColor(R.color.bw));
            }
            ImageView imageView2 = (ImageView) actionBar.getCustomView().findViewById(R.id.fqt);
            if (imageView2 != null && isDarkMode) {
                if (imageView2.getDrawable() != null) {
                    imageView2.getDrawable().setColorFilter(-1, PorterDuff.Mode.SRC_ATOP);
                } else {
                    imageView2.setColorFilter(-1, PorterDuff.Mode.SRC_ATOP);
                }
            }
            ImageView imageView3 = (ImageView) actionBar.getCustomView().findViewById(R.id.gab);
            if (imageView3 != null && isDarkMode) {
                if (imageView3.getDrawable() != null) {
                    imageView3.getDrawable().setColorFilter(-1, PorterDuff.Mode.SRC_ATOP);
                    AppMethodBeat.o(35408);
                    return;
                }
                imageView3.setColorFilter(-1, PorterDuff.Mode.SRC_ATOP);
            }
        }
        AppMethodBeat.o(35408);
    }

    private void gQo() {
        AppMethodBeat.i(35409);
        this.Prs.clear();
        this.Prs.add(this.dom.Pwc.getStringExtra("Chat_User"));
        AppMethodBeat.o(35409);
    }

    @Override // com.tencent.mm.ui.chatting.d.b.aa
    public final void gQp() {
        AppMethodBeat.i(35410);
        am amVar = (am) this.dom.bh(am.class);
        if (amVar.gRa() || amVar.gQZ()) {
            this.dom.showOptionMenu(false);
            AppMethodBeat.o(35410);
        } else if (((s) this.dom.bh(s.class)).gPN()) {
            AppMethodBeat.o(35410);
        } else if (ab.IN(this.dom.getTalkerUserName())) {
            this.dom.showOptionMenu(false);
            AppMethodBeat.o(35410);
        } else {
            if (((ai) this.dom.bh(ai.class)).gQN()) {
                a(this.dom.Pwc.getContext().getString(R.string.vl), this.Pry, t.b.GREEN);
            } else if (ab.IK(this.dom.getTalkerUserName()) || ab.IL(this.dom.getTalkerUserName()) || (1 == ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_minishop_plugin_enabled, 0) && ab.IM(this.dom.getTalkerUserName()))) {
                a(R.string.d0, R.raw.actionbar_setting_icon, this.Pry);
            } else if (ab.IJ(this.dom.getTalkerUserName())) {
                com.tencent.mm.plugin.newtips.a.exo();
                this.dom.Pwc.addIconOptionMenu(0, R.string.d0, R.raw.actionbar_setting_icon, Boolean.valueOf(com.tencent.mm.plugin.newtips.a.e.Ty(com.tencent.mm.plugin.newtips.a.d.ADd)).booleanValue(), this.Pry);
            } else if (ab.IP(this.dom.getTalkerUserName())) {
                a(R.string.d0, R.raw.actionbar_setting_icon, this.Pry);
            } else if (ab.IW(this.dom.getTalkerUserName())) {
                a(R.string.d0, R.raw.actionbar_setting_icon, this.Pry);
                h.INSTANCE.kvStat(10071, "1");
            } else if (ab.IX(this.dom.getTalkerUserName())) {
                a(R.string.d0, R.raw.actionbar_setting_icon, this.Pry);
            } else if (ab.Jx(this.dom.getTalkerUserName())) {
                if (((o) this.dom.bh(o.class)).gPH()) {
                    this.dom.showOptionMenu(false);
                } else {
                    bg.aVF();
                    com.tencent.mm.model.c.getNotifyMessageRecordStorage();
                    if (cf.gEg()) {
                        this.dom.showOptionMenu(false);
                        AppMethodBeat.o(35410);
                        return;
                    }
                    a(R.string.d0, R.raw.actionbar_menu_list_icon, this.Pry);
                }
            } else if (ab.JC(this.dom.getTalkerUserName())) {
                a(R.string.d0, R.raw.actionbar_setting_icon, this.Pry);
            } else if (ab.JE(this.dom.getTalkerUserName())) {
                if (ab.Ji(this.dom.getTalkerUserName())) {
                    this.dom.showOptionMenu(false);
                    AppMethodBeat.o(35410);
                    return;
                }
                a(R.string.d0, R.raw.actionbar_setting_icon, this.Pry);
            } else if (as.bjm(this.dom.getTalkerUserName()) || as.bjo(this.dom.getTalkerUserName()) || as.IG(this.dom.getTalkerUserName())) {
                a(R.string.b1o, R.raw.actionbar_icon_dark_more, this.Pry);
            } else if (as.HF(this.dom.getTalkerUserName())) {
                if (this.dom.bh(com.tencent.mm.ui.chatting.d.b.a.class) != null) {
                    ((com.tencent.mm.ui.chatting.d.b.a) this.dom.bh(com.tencent.mm.ui.chatting.d.b.a.class)).gRG();
                }
            } else if (((com.tencent.mm.ui.chatting.d.b.ae) this.dom.bh(com.tencent.mm.ui.chatting.d.b.ae.class)).gQM() && l.bmI(this.dom.getTalkerUserName())) {
                a(R.string.b1o, R.raw.ofm_add_icon, this.Pry);
            } else if (this.dom.GUe == null || !this.dom.GUe.gBM() || (!com.tencent.mm.al.g.Nb(this.dom.getTalkerUserName()) && !com.tencent.mm.al.g.Nd(this.dom.getTalkerUserName()))) {
                ((ai) this.dom.bh(ai.class)).gQG();
                d dVar = (d) this.dom.bh(d.class);
                if (!ab.Iw(this.dom.getTalkerUserName()) && !dVar.gOP()) {
                    a(R.string.b1o, R.raw.actionbar_icon_dark_more, this.Pry);
                } else if (((f) this.dom.bh(f.class)).gPi()) {
                    Log.i("MicroMsg.ChattingUI.HeaderComponent", "cpan show chatroom right btn");
                    if (!((f) this.dom.bh(f.class)).gPj() || !((f) this.dom.bh(f.class)).amD() || !v.aTS()) {
                        a(R.string.b1o, R.raw.actionbar_icon_dark_more, this.Pry);
                    } else {
                        a(R.string.b1o, R.raw.actionbar_icon_dark_more, "chatroom", this.Pry);
                    }
                    this.dom.showOptionMenu(true);
                } else if (!dVar.gOP() || dVar.gOQ()) {
                    this.dom.showOptionMenu(false);
                    AppMethodBeat.o(35410);
                    return;
                } else {
                    a(R.string.b1o, R.raw.actionbar_particular_icon, this.Pry);
                    this.dom.showOptionMenu(true);
                }
            } else {
                a(R.string.d0, R.raw.icons_outlined_me, this.Pry);
            }
            if (as.IG(this.dom.getTalkerUserName())) {
                this.dom.BW(true);
                AppMethodBeat.o(35410);
                return;
            }
            this.dom.showOptionMenu(true);
            AppMethodBeat.o(35410);
        }
    }

    private void a(int i2, int i3, MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        AppMethodBeat.i(35411);
        a(i2, i3, "", onMenuItemClickListener);
        AppMethodBeat.o(35411);
    }

    private void a(int i2, int i3, String str, MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        AppMethodBeat.i(179927);
        t.a findMenuInfo = this.dom.Pwc.findMenuInfo(0);
        if (!Util.isNullOrNil(str)) {
            if (findMenuInfo == null) {
                this.dom.Pwc.addIconOptionMenu(0, i2, i3, onMenuItemClickListener);
                findMenuInfo = this.dom.Pwc.findMenuInfo(0);
            } else {
                this.dom.Pwc.updateOptionMenu(0, i2, i3, onMenuItemClickListener);
            }
            if (findMenuInfo == null) {
                Log.e("MicroMsg.ChattingUI.HeaderComponent", "updateMenuInfo menuInfo == null");
                AppMethodBeat.o(179927);
                return;
            }
            this.Prx = new a(0, str, findMenuInfo);
            com.tencent.mm.plugin.newtips.a.exl().h(this.Prx);
            com.tencent.mm.plugin.newtips.a.g.a(this.Prx);
            if (findMenuInfo.eho) {
                com.tencent.mm.plugin.newtips.a.g.a((com.tencent.mm.plugin.newtips.a.a) this.Prx, k.MMNEWTIPS_SHOWTYPE_REDPOINT, true);
            }
            AppMethodBeat.o(179927);
        } else if (findMenuInfo == null) {
            this.dom.Pwc.addIconOptionMenu(0, i2, i3, onMenuItemClickListener);
            AppMethodBeat.o(179927);
        } else {
            this.dom.Pwc.updateOptionMenu(0, i2, i3, onMenuItemClickListener);
            AppMethodBeat.o(179927);
        }
    }

    private void a(String str, MenuItem.OnMenuItemClickListener onMenuItemClickListener, t.b bVar) {
        AppMethodBeat.i(233136);
        t.a findMenuInfo = this.dom.Pwc.findMenuInfo(0);
        if (!(findMenuInfo == null || (findMenuInfo.Oyf == 0 && findMenuInfo.OGR == null))) {
            this.dom.Pwc.removeOptionMenu(0);
            findMenuInfo = null;
        }
        if (findMenuInfo == null) {
            this.dom.Pwc.addTextOptionMenu(0, str, onMenuItemClickListener, null, bVar);
            AppMethodBeat.o(233136);
            return;
        }
        this.dom.Pwc.updateOptionMenuText(0, str);
        AppMethodBeat.o(233136);
    }

    /* access modifiers changed from: package-private */
    public class a implements com.tencent.mm.plugin.newtips.a.a {
        private int Oye = 0;
        public boolean PrR = false;
        private t.a PrS;
        private View gvQ = new View(ad.this.dom.Pwc.getContext());
        private String path;

        public a(int i2, String str, t.a aVar) {
            AppMethodBeat.i(233134);
            this.path = str;
            this.PrS = aVar;
            AppMethodBeat.o(233134);
        }

        @Override // com.tencent.mm.plugin.newtips.a.a
        public final String getPath() {
            return this.path;
        }

        @Override // com.tencent.mm.plugin.newtips.a.a
        public final boolean ehp() {
            return false;
        }

        @Override // com.tencent.mm.plugin.newtips.a.a
        public final View getRoot() {
            return this.gvQ;
        }

        @Override // com.tencent.mm.plugin.newtips.a.a
        public final void a(k kVar, boolean z) {
            AppMethodBeat.i(179924);
            com.tencent.mm.plugin.newtips.a.g.a(this, kVar, z);
            AppMethodBeat.o(179924);
        }

        @Override // com.tencent.mm.plugin.newtips.a.a
        public final boolean qV(boolean z) {
            AppMethodBeat.i(179925);
            boolean a2 = com.tencent.mm.plugin.newtips.a.g.a(z, this);
            AppMethodBeat.o(179925);
            return a2;
        }

        @Override // com.tencent.mm.plugin.newtips.a.a
        public final boolean qW(boolean z) {
            AppMethodBeat.i(179926);
            this.PrR = z;
            ad.this.dom.Pwc.updateOptionMenuRedDot(this.Oye, z);
            AppMethodBeat.o(179926);
            return true;
        }

        @Override // com.tencent.mm.plugin.newtips.a.a
        public final boolean qX(boolean z) {
            return false;
        }

        @Override // com.tencent.mm.plugin.newtips.a.a
        public final boolean a(boolean z, ehv ehv) {
            return false;
        }

        @Override // com.tencent.mm.plugin.newtips.a.a
        public final boolean b(boolean z, ehv ehv) {
            return false;
        }

        @Override // com.tencent.mm.plugin.newtips.a.a
        public final boolean c(boolean z, ehv ehv) {
            return false;
        }

        @Override // com.tencent.mm.plugin.newtips.a.a
        public final boolean d(boolean z, ehv ehv) {
            return false;
        }
    }

    @Override // com.tencent.mm.ui.chatting.d.b.aa
    public final void BR(boolean z) {
        AppMethodBeat.i(35412);
        if (this.dom == null) {
            Log.e("MicroMsg.ChattingUI.HeaderComponent", "[updateBannerStatus] mChattingContext == null!");
            AppMethodBeat.o(35412);
            return;
        }
        if (this.dom.gRM()) {
            gQu();
        } else if (!ab.IN(this.dom.getTalkerUserName()) && l.bmI(this.dom.getTalkerUserName()) && !((com.tencent.mm.ui.chatting.d.b.ae) this.dom.bh(com.tencent.mm.ui.chatting.d.b.ae.class)).gQM()) {
            this.Prt = this.dom.getTalkerUserName();
            gQr();
        } else if (!((ac) this.dom.bh(ac.class)).gPG() && !((o) this.dom.bh(o.class)).gPG()) {
            gQt();
        }
        if (z) {
            gQv();
            gQq();
        }
        AppMethodBeat.o(35412);
    }

    private void gQq() {
        AppMethodBeat.i(35413);
        if (this.dom.Pwc.getContext() == null) {
            Log.w("MicroMsg.ChattingUI.HeaderComponent", "getActivity is null");
            AppMethodBeat.o(35413);
            return;
        }
        gQx();
        ViewGroup viewGroup = (ViewGroup) this.dom.Pwc.getContext().findViewById(R.id.au9);
        com.tencent.mm.pluginsdk.ui.b.a a2 = com.tencent.mm.ui.conversation.a.e.a(this.dom.Pwc.getContext(), e.a.CHATTING_MONITORED_HINT, new Object[]{b.EnumC0443b.Chatting});
        if (!(viewGroup == null || a2 == null || a2.getView() == null || this.PrH != null)) {
            this.PrH = a2.getView();
            viewGroup.addView(this.PrH, new ViewGroup.LayoutParams(-1, -2));
        }
        AppMethodBeat.o(35413);
    }

    @Override // com.tencent.mm.ui.chatting.d.b.aa
    @SuppressLint({"ResourceType"})
    public final void gQr() {
        final LinearLayout linearLayout;
        AppMethodBeat.i(35414);
        if (((MMFragment) this.dom.Pwc).hasDestory) {
            AppMethodBeat.o(35414);
            return;
        }
        gQu();
        if (this.Prr == null) {
            l.a(this.dom.Pwc, (int) R.id.j80);
            this.Prr = (LinearLayout) this.dom.Pwc.getContext().findViewById(R.id.d5o);
            LinearLayout linearLayout2 = (LinearLayout) this.dom.Pwc.getContext().getLayoutInflater().inflate(R.layout.tu, (ViewGroup) null);
            this.Prr.addView(linearLayout2, new ViewGroup.LayoutParams(-1, -2));
            linearLayout = linearLayout2;
        } else {
            linearLayout = (LinearLayout) this.Prr.findViewById(R.id.arv);
        }
        this.Prr.setVisibility(0);
        linearLayout.setVisibility(0);
        linearLayout.findViewById(R.id.gs);
        String str = this.Prt;
        if (Util.isNullOrNil(str)) {
            str = this.dom.GUe.field_username;
        }
        com.tencent.mm.aj.c.a(str, false, -1, null);
        Button button = (Button) linearLayout.findViewById(R.id.aru);
        if (((ac) this.dom.bh(ac.class)).gQH()) {
            ((ac) this.dom.bh(ac.class)).a(button, linearLayout, this.Prr);
        }
        linearLayout.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.ui.chatting.d.ad.AnonymousClass2 */

            public final void onClick(View view) {
                AppMethodBeat.i(35370);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/component/HeaderComponent$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                ad.b(ad.this);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/component/HeaderComponent$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(35370);
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.ui.chatting.d.ad.AnonymousClass3 */

            public final void onClick(View view) {
                final String str;
                AppMethodBeat.i(179914);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/component/HeaderComponent$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (((ac) ad.this.dom.bh(ac.class)).gQH()) {
                    ((ac) ad.this.dom.bh(ac.class)).amD(ad.this.Dkc);
                } else {
                    if (((int) ad.this.dom.GUe.gMZ) == 0) {
                        bg.aVF();
                        if (com.tencent.mm.model.c.aSN().aq(ad.this.dom.GUe) != -1) {
                            Log.e("MicroMsg.ChattingUI.HeaderComponent", "[insertRetId] successfully! username:%s", ad.this.dom.GUe);
                        }
                    }
                    if (ab.Eq(ad.this.dom.GUe.field_username)) {
                        str = ad.this.dom.GUe.field_username;
                    } else {
                        str = "";
                    }
                    bg.aVF();
                    as Kn = com.tencent.mm.model.c.aSN().Kn(ad.this.Prt);
                    String nullAs = Kn != null ? Util.nullAs(Kn.fuY, "") : "";
                    Log.i("MicroMsg.ChattingUI.HeaderComponent", "dkverify banner add:%s chat:%s ticket", ad.this.Prt, str, nullAs);
                    if ((TextUtils.isEmpty(str) || !TextUtils.isEmpty(nullAs)) && !as.bjp(Kn.field_username)) {
                        com.tencent.mm.pluginsdk.ui.applet.a aVar = new com.tencent.mm.pluginsdk.ui.applet.a(ad.this.dom.Pwc.getContext(), new a.AbstractC2025a() {
                            /* class com.tencent.mm.ui.chatting.d.ad.AnonymousClass3.AnonymousClass1 */

                            @Override // com.tencent.mm.pluginsdk.ui.applet.a.AbstractC2025a
                            public final void a(boolean z, boolean z2, String str, String str2) {
                                AppMethodBeat.i(233127);
                                if (z) {
                                    ab.B(ad.this.dom.GUe);
                                    linearLayout.setVisibility(8);
                                }
                                AppMethodBeat.o(233127);
                            }
                        });
                        LinkedList<Integer> linkedList = new LinkedList<>();
                        linkedList.add(3);
                        aVar.beC(nullAs);
                        aVar.Keg = true;
                        aVar.d(ad.this.Prt, str, linkedList);
                    } else {
                        ay.a.iDq.a(ad.this.Prt, str, new ay.b.a() {
                            /* class com.tencent.mm.ui.chatting.d.ad.AnonymousClass3.AnonymousClass2 */

                            @Override // com.tencent.mm.model.ay.b.a
                            public final void p(String str, boolean z) {
                                AppMethodBeat.i(233129);
                                com.tencent.mm.pluginsdk.ui.applet.a aVar = new com.tencent.mm.pluginsdk.ui.applet.a(ad.this.dom.Pwc.getContext(), new a.AbstractC2025a() {
                                    /* class com.tencent.mm.ui.chatting.d.ad.AnonymousClass3.AnonymousClass2.AnonymousClass1 */

                                    @Override // com.tencent.mm.pluginsdk.ui.applet.a.AbstractC2025a
                                    public final void a(boolean z, boolean z2, String str, String str2) {
                                        AppMethodBeat.i(233128);
                                        if (z) {
                                            ab.B(ad.this.dom.GUe);
                                            linearLayout.setVisibility(8);
                                        }
                                        AppMethodBeat.o(233128);
                                    }
                                });
                                LinkedList<Integer> linkedList = new LinkedList<>();
                                linkedList.add(3);
                                bg.aVF();
                                as Kn = com.tencent.mm.model.c.aSN().Kn(ad.this.Prt);
                                aVar.beC(Kn != null ? Util.nullAs(Kn.fuY, "") : "");
                                aVar.Keg = true;
                                aVar.d(ad.this.Prt, str, linkedList);
                                AppMethodBeat.o(233129);
                            }
                        });
                    }
                    h.INSTANCE.a(11004, ad.this.Prt, 3);
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/component/HeaderComponent$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(179914);
            }
        });
        h.INSTANCE.a(11004, this.Prt, 1);
        AppMethodBeat.o(35414);
    }

    @Override // com.tencent.mm.ui.chatting.d.b.aa
    public final void gQs() {
        LinearLayout linearLayout;
        AppMethodBeat.i(233137);
        if (((MMFragment) this.dom.Pwc).hasDestory) {
            AppMethodBeat.o(233137);
            return;
        }
        if (this.Prp != null) {
            gQu();
        }
        if (!(this.dom.Pwc.getController() == null || this.dom.Pwc.getMMResources() == null)) {
            this.dom.Pwc.getController().setActionbarColor(this.dom.Pwc.getMMResources().getColor(R.color.f3045c));
        }
        ActionBar supportActionBar = ((AppCompatActivity) this.dom.Pwc.getContext()).getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setElevation(0.0f);
        }
        if (this.Prr == null) {
            l.a(this.dom.Pwc, (int) R.id.j80);
            this.Prr = (LinearLayout) this.dom.Pwc.getContext().findViewById(R.id.d5o);
            linearLayout = (LinearLayout) this.dom.Pwc.getContext().getLayoutInflater().inflate(R.layout.tw, (ViewGroup) null);
            this.Prr.addView(linearLayout, new ViewGroup.LayoutParams(-1, -2));
        } else {
            linearLayout = (LinearLayout) this.Prr.findViewById(R.id.axv);
        }
        this.Prr.setVisibility(0);
        linearLayout.setVisibility(0);
        ((o) this.dom.bh(o.class)).j(this.Prr);
        AppMethodBeat.o(233137);
    }

    private void gQt() {
        com.tencent.mm.pluginsdk.ui.b.a aVar;
        AppMethodBeat.i(35415);
        if (this.dom.gRM() || this.Prp == null) {
            gQu();
            AppMethodBeat.o(35415);
            return;
        }
        gQu();
        if (this.Prp.getTag() == null) {
            aVar = com.tencent.mm.ui.conversation.a.e.a(this.dom.Pwc.getContext(), e.a.CHATTING_RECOMMEND_BANNER, new Object[]{this.dom.getTalkerUserName(), this.dom.gOZ()});
            if (!(aVar == null || aVar.getView() == null)) {
                this.Prp.addView(aVar.getView(), new ViewGroup.LayoutParams(-1, -2));
            }
        } else {
            aVar = (com.tencent.mm.pluginsdk.ui.b.a) this.Prp.getTag();
        }
        if (aVar != null) {
            this.Prp.setVisibility(0);
            this.Prp.setTag(aVar);
        }
        h.INSTANCE.a(11003, this.dom.getTalkerUserName(), 1, 0);
        AppMethodBeat.o(35415);
    }

    private void gQu() {
        AppMethodBeat.i(35416);
        this.Prp.setVisibility(8);
        if (this.Prr != null) {
            this.Prr.setVisibility(8);
        }
        AppMethodBeat.o(35416);
    }

    private void gQv() {
        AppMethodBeat.i(35417);
        if (this.dom.Pwc.getContext() == null) {
            Log.w("MicroMsg.ChattingUI.HeaderComponent", "getActivity is null");
            AppMethodBeat.o(35417);
            return;
        }
        gQw();
        ViewGroup viewGroup = (ViewGroup) this.dom.Pwc.getContext().findViewById(R.id.auh);
        com.tencent.mm.pluginsdk.ui.b.a a2 = com.tencent.mm.ui.conversation.a.e.a(this.dom.Pwc.getContext(), e.a.CHATTING_SECURITY_BANNER, new Object[]{this.dom.getTalkerUserName(), this.dom.gOZ(), Boolean.valueOf(this.dom.gRM())});
        if (!(viewGroup == null || a2 == null || a2.getView() == null || this.PrG != null)) {
            this.PrG = a2.getView();
            viewGroup.addView(this.PrG, new ViewGroup.LayoutParams(-1, -2));
        }
        AppMethodBeat.o(35417);
    }

    private void gQw() {
        AppMethodBeat.i(35418);
        ViewGroup viewGroup = (ViewGroup) this.dom.Pwc.getContext().findViewById(R.id.auh);
        if (!(viewGroup == null || this.PrG == null)) {
            viewGroup.removeView(this.PrG);
            this.PrG = null;
        }
        AppMethodBeat.o(35418);
    }

    private void gQx() {
        AppMethodBeat.i(35419);
        ViewGroup viewGroup = (ViewGroup) this.dom.Pwc.getContext().findViewById(R.id.au9);
        if (!(viewGroup == null || this.PrH == null)) {
            viewGroup.removeView(this.PrH);
            this.PrH = null;
        }
        AppMethodBeat.o(35419);
    }

    @Override // com.tencent.mm.ui.chatting.d.b.aa
    public final int gQy() {
        AppMethodBeat.i(35420);
        int i2 = 0;
        if (this.Prp != null && this.Prp.isShown()) {
            i2 = this.Prp.getHeight() + 0;
        }
        AppMethodBeat.o(35420);
        return i2;
    }

    @Override // com.tencent.mm.ui.chatting.d.b.aa
    public final void setMMTitle(CharSequence charSequence) {
        SpannableString spannableString;
        AppMethodBeat.i(35421);
        if (ab.Iy(this.dom.getTalkerUserName()) || ((f) this.dom.bh(f.class)).gPk()) {
            this.Prv.setTitle(charSequence);
            this.dom.Pwc.updateDescription(this.dom.Pwc.getContext().getString(R.string.axl, new Object[]{charSequence}));
            AppMethodBeat.o(35421);
            return;
        }
        if (as.bjp(this.dom.GUe.field_username)) {
            spannableString = ((com.tencent.mm.openim.a.a) g.af(com.tencent.mm.openim.a.a.class)).e(MMApplicationContext.getContext(), charSequence.toString(), com.tencent.mm.cb.a.aG(MMApplicationContext.getContext(), R.dimen.l));
            this.Prv.setTitle(spannableString);
        } else {
            SpannableString e2 = l.e((Context) this.dom.Pwc.getContext(), charSequence, com.tencent.mm.cb.a.aG(this.dom.Pwc.getContext(), R.dimen.l));
            this.Prv.setTitle(e2);
            if (!ab.Eq(this.dom.getTalkerUserName())) {
                ((c) g.ah(c.class)).setTextWithStatus(this.Prv.jVO, this.dom.getTalkerUserName(), a.b.CONVERSATION_LIST, a.c.OUTLINED);
                gQm();
            }
            spannableString = e2;
        }
        this.dom.Pwc.updateDescription(this.dom.Pwc.getContext().getString(R.string.axl, new Object[]{spannableString}));
        AppMethodBeat.o(35421);
    }

    @Override // com.tencent.mm.ui.chatting.d.b.aa
    public final void setMMSubTitle(String str) {
        AppMethodBeat.i(35422);
        this.Prv.ap(l.e((Context) this.dom.Pwc.getContext(), (CharSequence) str, com.tencent.mm.cb.a.aG(this.dom.Pwc.getContext(), R.dimen.hc)));
        AppMethodBeat.o(35422);
    }

    @Override // com.tencent.mm.ui.chatting.d.b.aa
    public final void a(boolean z, View.OnClickListener onClickListener) {
        AppMethodBeat.i(233139);
        com.tencent.mm.ui.a aVar = this.Prv;
        if (!z) {
            aVar.OwF.setVisibility(0);
            aVar.OwF.setIconColor(aVar.jVO.getCurrentTextColor());
            aVar.OwE.setOnClickListener(onClickListener);
            com.tencent.mm.ui.tools.o.hq(aVar.OwE);
            aVar.OwI.setVisibility(8);
            aVar.OwH.setOnClickListener(null);
            com.tencent.mm.ui.tools.o.hr(aVar.OwH);
        } else {
            aVar.OwI.setVisibility(0);
            aVar.OwI.setIconColor(aVar.OwG.getCurrentTextColor());
            aVar.OwH.setOnClickListener(onClickListener);
            com.tencent.mm.ui.tools.o.hq(aVar.OwH);
            aVar.OwF.setVisibility(8);
            aVar.OwE.setOnClickListener(null);
            com.tencent.mm.ui.tools.o.hr(aVar.OwE);
        }
        Log.d("MicroMsg.ActionBarCustomArea", "fixWhenTitleTooLong, forSubTitle: ".concat(String.valueOf(z)));
        if (!z) {
            aVar.jVO.post(
            /*  JADX ERROR: Method code generation error
                jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0051: INVOKE  
                  (wrap: android.widget.TextView : 0x004a: IGET  (r1v10 android.widget.TextView) = (r0v0 'aVar' com.tencent.mm.ui.a) com.tencent.mm.ui.a.jVO android.widget.TextView)
                  (wrap: com.tencent.mm.ui.a$1 : 0x004e: CONSTRUCTOR  (r2v5 com.tencent.mm.ui.a$1) = (r0v0 'aVar' com.tencent.mm.ui.a) call: com.tencent.mm.ui.a.1.<init>(com.tencent.mm.ui.a):void type: CONSTRUCTOR)
                 type: VIRTUAL call: android.widget.TextView.post(java.lang.Runnable):boolean in method: com.tencent.mm.ui.chatting.d.ad.a(boolean, android.view.View$OnClickListener):void, file: classes5.dex
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
                Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x004e: CONSTRUCTOR  (r2v5 com.tencent.mm.ui.a$1) = (r0v0 'aVar' com.tencent.mm.ui.a) call: com.tencent.mm.ui.a.1.<init>(com.tencent.mm.ui.a):void type: CONSTRUCTOR in method: com.tencent.mm.ui.chatting.d.ad.a(boolean, android.view.View$OnClickListener):void, file: classes5.dex
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
                	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:806)
                	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:746)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                	... 21 more
                Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.tencent.mm.ui.a, state: GENERATED_AND_UNLOADED
                	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
                	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                	... 27 more
                */
            /*
            // Method dump skipped, instructions count: 144
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.chatting.d.ad.a(boolean, android.view.View$OnClickListener):void");
        }

        @Override // com.tencent.mm.ui.chatting.d.b.aa
        public final void setBackBtn(final MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
            AppMethodBeat.i(35423);
            this.Prv.setClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.ui.chatting.d.ad.AnonymousClass4 */

                public final void onClick(View view) {
                    AppMethodBeat.i(233131);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/component/HeaderComponent$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    if (!ad.this.dom.Pwc.isScreenEnable()) {
                        Log.w("MicroMsg.ChattingUI.HeaderComponent", "Actionbar customView onclick screen not enable");
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/component/HeaderComponent$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(233131);
                        return;
                    }
                    view.setSelected(false);
                    view.setPressed(false);
                    view.clearFocus();
                    view.invalidate();
                    view.post(new Runnable() {
                        /* class com.tencent.mm.ui.chatting.d.ad.AnonymousClass4.AnonymousClass1 */

                        public final void run() {
                            AppMethodBeat.i(233130);
                            if (onMenuItemClickListener != null) {
                                onMenuItemClickListener.onMenuItemClick(null);
                            }
                            AppMethodBeat.o(233130);
                        }
                    });
                    ((ai) ad.this.dom.bh(ai.class)).gQT();
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/component/HeaderComponent$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(233131);
                }
            });
            this.Prv.gGI();
            AppMethodBeat.o(35423);
        }

        @Override // com.tencent.mm.ui.chatting.d.b.aa
        public final void setTitlePhoneIconVisibility(int i2) {
            boolean z;
            int i3 = 0;
            AppMethodBeat.i(35424);
            com.tencent.mm.ui.a aVar = this.Prv;
            if (i2 == 0) {
                z = true;
            } else {
                z = false;
            }
            ImageView imageView = aVar.OwK;
            if (!z) {
                i3 = 8;
            }
            imageView.setVisibility(i3);
            AppMethodBeat.o(35424);
        }

        @Override // com.tencent.mm.ui.chatting.d.b.aa
        public final void setTitleMuteIconVisibility(int i2) {
            boolean z = false;
            AppMethodBeat.i(35426);
            if (ab.Jx(this.dom.getTalkerUserName()) || ab.JC(this.dom.getTalkerUserName())) {
                this.Prv.AR(false);
                AppMethodBeat.o(35426);
                return;
            }
            com.tencent.mm.ui.a aVar = this.Prv;
            if (i2 == 0) {
                z = true;
            }
            aVar.AR(z);
            AppMethodBeat.o(35426);
        }

        @Override // com.tencent.mm.ui.chatting.d.b.aa
        public final void amB(int i2) {
            boolean z;
            int i3 = 0;
            AppMethodBeat.i(35427);
            com.tencent.mm.ui.a aVar = this.Prv;
            if (i2 == 0) {
                z = true;
            } else {
                z = false;
            }
            ImageView imageView = aVar.OwM;
            if (!z) {
                i3 = 8;
            }
            imageView.setVisibility(i3);
            AppMethodBeat.o(35427);
        }

        @Override // com.tencent.mm.ui.chatting.d.b.aa
        public final w gNg() {
            return this.Pru;
        }

        @Override // com.tencent.mm.ui.m, com.tencent.mm.ui.chatting.d.a
        public final void gIl() {
            AppMethodBeat.i(35392);
            this.Dkc = this.dom.Pwc.getIntExtra("add_scene", 0);
            p.aYn().a(this.PrB);
            bg.aVF();
            com.tencent.mm.model.c.aSX().add(this.Pnh);
            setBackBtn(this.backListener);
            doResume();
            gPx();
            gQp();
            gQu();
            this.Pnm = true;
            v.a(this.dom.getTalkerUserName(), new PluginNewTips.a() {
                /* class com.tencent.mm.ui.chatting.d.ad.AnonymousClass1 */

                @Override // com.tencent.mm.plugin.newtips.PluginNewTips.a
                public final void exp() {
                    AppMethodBeat.i(179909);
                    Log.i("MicroMsg.ChattingUI.HeaderComponent", "onCallback");
                    ad.this.gQp();
                    AppMethodBeat.o(179909);
                }
            });
            AppMethodBeat.o(35392);
        }

        @Override // com.tencent.mm.ui.m, com.tencent.mm.ui.chatting.d.a
        public final void cFx() {
            AppMethodBeat.i(35394);
            bg.aVF().aTm().a(new e.a() {
                /* class com.tencent.mm.ui.chatting.d.ad.AnonymousClass8 */

                @Override // com.tencent.mm.model.b.e.a
                public final void aXh() {
                    AppMethodBeat.i(35378);
                    com.tencent.mm.ui.chatting.e.a.gRP().post(new Runnable() {
                        /* class com.tencent.mm.ui.chatting.d.ad.AnonymousClass8.AnonymousClass1 */

                        public final void run() {
                            AppMethodBeat.i(35377);
                            ad.g(ad.this);
                            AppMethodBeat.o(35377);
                        }
                    });
                    AppMethodBeat.o(35378);
                }

                @Override // com.tencent.mm.model.b.e.a
                public final void aXi() {
                    AppMethodBeat.i(35379);
                    ad.h(ad.this);
                    AppMethodBeat.o(35379);
                }
            });
            bg.aVF().aTn().a(new e.a() {
                /* class com.tencent.mm.ui.chatting.d.ad.AnonymousClass9 */

                @Override // com.tencent.mm.model.b.e.a
                public final void aXh() {
                    AppMethodBeat.i(179920);
                    com.tencent.mm.ui.chatting.e.a.gRP().post(new Runnable() {
                        /* class com.tencent.mm.ui.chatting.d.ad.AnonymousClass9.AnonymousClass1 */

                        public final void run() {
                            AppMethodBeat.i(179919);
                            ad.i(ad.this);
                            AppMethodBeat.o(179919);
                        }
                    });
                    AppMethodBeat.o(179920);
                }

                @Override // com.tencent.mm.model.b.e.a
                public final void aXi() {
                    AppMethodBeat.i(179921);
                    ad.j(ad.this);
                    AppMethodBeat.o(179921);
                }
            });
            com.tencent.mm.model.b.b aTo = bg.aVF().aTo();
            b.a aVar = this.Prz;
            synchronized (com.tencent.mm.model.b.b.class) {
                try {
                    aTo.mListeners.add(aVar);
                } catch (Throwable th) {
                    AppMethodBeat.o(35394);
                    throw th;
                }
            }
            if (!this.Pnm) {
                doResume();
            }
            this.Pnm = false;
            AppMethodBeat.o(35394);
        }

        @Override // com.tencent.mm.ui.m, com.tencent.mm.ui.chatting.d.a
        public final void cFy() {
            AppMethodBeat.i(35395);
            if (g.aAf().azp()) {
                bg.aVF().aTm().a(null);
                bg.aVF().aTn().a(null);
                com.tencent.mm.model.b.b aTo = bg.aVF().aTo();
                b.a aVar = this.Prz;
                synchronized (com.tencent.mm.model.b.b.class) {
                    try {
                        aTo.mListeners.remove(aVar);
                    } finally {
                        AppMethodBeat.o(35395);
                    }
                }
                return;
            }
            AppMethodBeat.o(35395);
        }

        @Override // com.tencent.mm.ui.chatting.d.b.aa
        public final int gQz() {
            ActionBar actionBar;
            AppMethodBeat.i(233138);
            if (((MMFragment) this.dom.Pwc).isCurrentActivity || !isSupportCustomActionBar()) {
                ((AppCompatActivity) this.dom.Pwc.getContext()).getSupportActionBar().a(P(null), new ActionBar.LayoutParams(-1, -1));
                actionBar = ((AppCompatActivity) this.dom.Pwc.getContext()).getSupportActionBar();
            } else {
                actionBar = this.Pru.getSupportActionBar();
            }
            if (actionBar == null || actionBar.getCustomView() == null) {
                AppMethodBeat.o(233138);
                return 0;
            }
            int[] iArr = new int[2];
            actionBar.getCustomView().getLocationOnScreen(iArr);
            int height = actionBar.getHeight() + iArr[1] + gQy();
            AppMethodBeat.o(233138);
            return height;
        }

        static /* synthetic */ void b(ad adVar) {
            String str;
            int i2;
            AppMethodBeat.i(35429);
            if (Util.isNullOrNil(adVar.Prt)) {
                str = adVar.dom.GUe.field_username;
            } else {
                str = adVar.Prt;
            }
            if (str == null || str.equals("")) {
                AppMethodBeat.o(35429);
                return;
            }
            Intent intent = new Intent();
            intent.putExtra("Contact_User", str);
            intent.putExtra("Contact_Encryptusername", true);
            if (!((ac) adVar.dom.bh(ac.class)).gQH()) {
                h.INSTANCE.a(11004, adVar.Prt, 2);
            } else {
                ((ac) adVar.dom.bh(ac.class)).bD(intent);
            }
            if (adVar.dom.gRM()) {
                i2 = 3;
            } else {
                i2 = 2;
            }
            intent.putExtra("CONTACT_INFO_UI_SOURCE", i2);
            com.tencent.mm.br.c.b(adVar.dom.Pwc.getContext(), Scopes.PROFILE, ".ui.ContactInfoUI", intent);
            AppMethodBeat.o(35429);
        }
    }

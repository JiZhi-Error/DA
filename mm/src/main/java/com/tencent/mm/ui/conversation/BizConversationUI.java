package com.tencent.mm.ui.conversation;

import android.app.ActivityOptions;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Looper;
import android.os.MessageQueue;
import android.support.v4.app.FragmentActivity;
import android.util.Pair;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ag.u;
import com.tencent.mm.ag.v;
import com.tencent.mm.al.ae;
import com.tencent.mm.al.ag;
import com.tencent.mm.cr.d;
import com.tencent.mm.g.a.l;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.bp;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.messenger.foundation.a.a.k;
import com.tencent.mm.plugin.websearch.api.ai;
import com.tencent.mm.plugin.websearch.api.i;
import com.tencent.mm.pluginsdk.h;
import com.tencent.mm.protocal.protobuf.afk;
import com.tencent.mm.protocal.protobuf.dna;
import com.tencent.mm.protocal.protobuf.dqi;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.az;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.aa;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.base.MMSlideDelView;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.q;
import com.tencent.mm.ui.conversation.BaseConversationUI;
import com.tencent.mm.ui.g;
import com.tencent.mm.ui.s;
import com.tencent.thumbplayer.core.common.TPCodecParamers;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class BizConversationUI extends BaseConversationUI {
    private View contentView;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.conversation.BaseConversationUI, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.conversation.BaseConversationUI, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(38270);
        super.onCreate(bundle);
        if (!bg.aAc()) {
            Log.e("MicroMsg.BizConversationUI", "onCreate acc not ready!!!");
            finish();
            AppMethodBeat.o(38270);
            return;
        }
        this.contentView = aa.jQ(this).inflate(R.layout.la, (ViewGroup) null);
        setContentView(this.contentView);
        this.conversationFm = new BizConversationFmUI();
        getSupportFragmentManager().beginTransaction().a(R.id.fgf, this.conversationFm).commit();
        h.a((MMFragmentActivity) this, this.contentView);
        AppMethodBeat.o(38270);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onConfigurationChanged(Configuration configuration) {
        AppMethodBeat.i(38271);
        super.onConfigurationChanged(configuration);
        h.a((MMFragmentActivity) this, this.contentView);
        AppMethodBeat.o(38271);
    }

    public static class BizConversationFmUI extends BaseConversationUI.BaseConversationFmUI {
        private ListView Qbt;
        private a Qbu;
        private String Qbv;
        private az conversation;
        private TextView emptyTipTv;
        private String iNV;
        private boolean isDeleteCancel = false;
        private int ppd = 0;
        private int ppe = 0;
        private com.tencent.mm.ui.widget.b.a pqr;
        private o.g pso = new o.g() {
            /* class com.tencent.mm.ui.conversation.BizConversationUI.BizConversationFmUI.AnonymousClass9 */

            /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
            @Override // com.tencent.mm.ui.base.o.g
            public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
                AppMethodBeat.i(38244);
                switch (menuItem.getItemId()) {
                    case 1:
                        bg.aVF();
                        as Kn = c.aSN().Kn(BizConversationFmUI.this.talker);
                        if (Kn == null) {
                            Log.e("MicroMsg.BizConversationUI", "changed biz stick status failed, contact is null, talker = " + BizConversationFmUI.this.talker);
                            AppMethodBeat.o(38244);
                            return;
                        } else if (Kn.arE()) {
                            com.tencent.mm.plugin.report.service.h.INSTANCE.a(13307, Kn.field_username, 1, 2, 2);
                            ab.F(BizConversationFmUI.this.talker, true);
                            AppMethodBeat.o(38244);
                            return;
                        } else {
                            com.tencent.mm.plugin.report.service.h.INSTANCE.a(13307, Kn.field_username, 1, 1, 2);
                            ab.E(BizConversationFmUI.this.talker, true);
                            AppMethodBeat.o(38244);
                            return;
                        }
                    case 2:
                        bg.aVF();
                        com.tencent.mm.ui.tools.b.a(ag.bah().MT(BizConversationFmUI.this.talker), BizConversationFmUI.this.thisActivity(), c.aSN().Kn(BizConversationFmUI.this.talker), 2);
                        AppMethodBeat.o(38244);
                        return;
                    case 3:
                        BizConversationFmUI.b(BizConversationFmUI.this, BizConversationFmUI.this.talker);
                        AppMethodBeat.o(38244);
                        return;
                    case 4:
                        g.c(BizConversationFmUI.this.thisActivity(), new Runnable() {
                            /* class com.tencent.mm.ui.conversation.BizConversationUI.BizConversationFmUI.AnonymousClass9.AnonymousClass1 */

                            public final void run() {
                                AppMethodBeat.i(234099);
                                bg.aVF();
                                c.aST().bjY(BizConversationFmUI.this.talker);
                                AppMethodBeat.o(234099);
                            }
                        });
                        break;
                }
                AppMethodBeat.o(38244);
            }
        };
        private long pss = 0;
        private IListener ptp = new IListener<l>() {
            /* class com.tencent.mm.ui.conversation.BizConversationUI.BizConversationFmUI.AnonymousClass10 */

            {
                AppMethodBeat.i(161557);
                this.__eventId = l.class.getName().hashCode();
                AppMethodBeat.o(161557);
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
            @Override // com.tencent.mm.sdk.event.IListener
            public final /* synthetic */ boolean callback(l lVar) {
                AppMethodBeat.i(38245);
                l lVar2 = lVar;
                if (!(lVar2 == null || lVar2.dCi == null || lVar2.dCi.isActive)) {
                    BizConversationFmUI.this.pss = 0;
                }
                AppMethodBeat.o(38245);
                return false;
            }
        };
        private int source = 1;
        private String talker = "";
        private q tipDialog = null;

        public BizConversationFmUI() {
            AppMethodBeat.i(38258);
            AppMethodBeat.o(38258);
        }

        @Override // android.support.v4.app.Fragment
        public void onActivityCreated(Bundle bundle) {
            AppMethodBeat.i(38259);
            super.onActivityCreated(bundle);
            this.iNV = thisActivity().getIntent().getStringExtra("enterprise_biz_name");
            if (Util.isNullOrNil(this.iNV)) {
                this.iNV = "officialaccounts";
            }
            this.source = thisActivity().getIntent().getIntExtra("biz_enter_source", 1);
            if (Util.nullAsNil(this.iNV).equals("officialaccounts")) {
                com.tencent.mm.plugin.report.service.h.INSTANCE.a(11404, 0, 0, 0, 0, 0, 0, Integer.valueOf((int) (System.currentTimeMillis() / 1000)), Integer.valueOf(this.source), "", 0, 0, 0);
            }
            this.Qbv = thisActivity().getIntent().getStringExtra("enterprise_biz_display_name");
            if (Util.isNullOrNil(this.Qbv)) {
                this.Qbv = getString(R.string.agz);
            }
            setMMTitle(this.Qbv);
            this.Qbt = (ListView) findViewById(R.id.ir8);
            this.emptyTipTv = (TextView) findViewById(R.id.c30);
            this.emptyTipTv.setText(R.string.bww);
            setBackBtn(new MenuItem.OnMenuItemClickListener() {
                /* class com.tencent.mm.ui.conversation.BizConversationUI.BizConversationFmUI.AnonymousClass13 */

                public final boolean onMenuItemClick(MenuItem menuItem) {
                    AppMethodBeat.i(38248);
                    BizConversationFmUI.this.finish();
                    AppMethodBeat.o(38248);
                    return true;
                }
            });
            setToTop(new View.OnClickListener() {
                /* class com.tencent.mm.ui.conversation.BizConversationUI.BizConversationFmUI.AnonymousClass14 */

                public final void onClick(View view) {
                    AppMethodBeat.i(38249);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/conversation/BizConversationUI$BizConversationFmUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(BizConversationFmUI.this.Qbt);
                    Object obj = new Object();
                    com.tencent.mm.hellhoundlib.a.a.a(obj, bl.axQ(), "com/tencent/mm/ui/conversation/BizConversationUI$BizConversationFmUI$5", "onClick", "(Landroid/view/View;)V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
                    BackwardSupportUtil.SmoothScrollFactory.scrollToTop((ListView) bl.pG(0));
                    com.tencent.mm.hellhoundlib.a.a.a(obj, "com/tencent/mm/ui/conversation/BizConversationUI$BizConversationFmUI$5", "onClick", "(Landroid/view/View;)V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/conversation/BizConversationUI$BizConversationFmUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(38249);
                }
            });
            this.Qbu = new a(thisActivity(), this.iNV, new s.a() {
                /* class com.tencent.mm.ui.conversation.BizConversationUI.BizConversationFmUI.AnonymousClass15 */

                @Override // com.tencent.mm.ui.s.a
                public final void bnE() {
                    AppMethodBeat.i(38250);
                    BizConversationFmUI.a(BizConversationFmUI.this, BizConversationFmUI.this.Qbu.getCount());
                    AppMethodBeat.o(38250);
                }
            });
            this.Qbu.setGetViewPositionCallback(new MMSlideDelView.c() {
                /* class com.tencent.mm.ui.conversation.BizConversationUI.BizConversationFmUI.AnonymousClass16 */

                @Override // com.tencent.mm.ui.base.MMSlideDelView.c
                public final int dr(View view) {
                    AppMethodBeat.i(38251);
                    int positionForView = BizConversationFmUI.this.Qbt.getPositionForView(view);
                    AppMethodBeat.o(38251);
                    return positionForView;
                }
            });
            this.Qbu.setPerformItemClickListener(new MMSlideDelView.g() {
                /* class com.tencent.mm.ui.conversation.BizConversationUI.BizConversationFmUI.AnonymousClass17 */

                @Override // com.tencent.mm.ui.base.MMSlideDelView.g
                public final void r(View view, int i2, int i3) {
                    AppMethodBeat.i(38252);
                    BizConversationFmUI.this.Qbt.performItemClick(view, i2, (long) i3);
                    AppMethodBeat.o(38252);
                }
            });
            this.Qbt.setAdapter((ListAdapter) this.Qbu);
            this.pqr = new com.tencent.mm.ui.widget.b.a(thisActivity());
            this.Qbt.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                /* class com.tencent.mm.ui.conversation.BizConversationUI.BizConversationFmUI.AnonymousClass18 */

                @Override // android.widget.AdapterView.OnItemClickListener
                public final void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
                    AppMethodBeat.i(38253);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(adapterView);
                    bVar.bm(view);
                    bVar.pH(i2);
                    bVar.zo(j2);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/conversation/BizConversationUI$BizConversationFmUI$9", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, bVar.axR());
                    BizConversationFmUI.this.conversation = (az) BizConversationFmUI.this.Qbu.getItem(i2);
                    BizConversationFmUI.this.talker = BizConversationFmUI.this.conversation.field_username;
                    az azVar = BizConversationFmUI.this.conversation;
                    if (azVar == null) {
                        Log.e("MicroMsg.BizConversationUI", "user should not be null. position:%d, size:%d", Integer.valueOf(i2), Integer.valueOf(BizConversationFmUI.this.Qbu.getCount()));
                        BizConversationFmUI.this.Qbu.notifyDataSetChanged();
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/conversation/BizConversationUI$BizConversationFmUI$9", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                        AppMethodBeat.o(38253);
                        return;
                    }
                    Bundle bundle = new Bundle();
                    bundle.putInt("biz_click_item_unread_count", BizConversationFmUI.this.conversation.field_unReadCount);
                    bundle.putInt("biz_click_item_position", i2 + 1);
                    bundle.putInt("KOpenArticleSceneFromScene", TPCodecParamers.TP_PROFILE_MPEG2_AAC_HE);
                    bundle.putInt("specific_chat_from_scene", 1);
                    BizConversationFmUI.this.ui.startChatting(azVar.field_username, bundle, true);
                    BizConversationFmUI.this.Qbu.a(azVar, i2);
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/conversation/BizConversationUI$BizConversationFmUI$9", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                    AppMethodBeat.o(38253);
                }
            });
            this.Qbt.setOnTouchListener(new View.OnTouchListener() {
                /* class com.tencent.mm.ui.conversation.BizConversationUI.BizConversationFmUI.AnonymousClass2 */

                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    AppMethodBeat.i(38236);
                    switch (motionEvent.getAction()) {
                        case 0:
                            BizConversationFmUI.this.ppd = (int) motionEvent.getRawX();
                            BizConversationFmUI.this.ppe = (int) motionEvent.getRawY();
                            break;
                    }
                    AppMethodBeat.o(38236);
                    return false;
                }
            });
            this.Qbt.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
                /* class com.tencent.mm.ui.conversation.BizConversationUI.BizConversationFmUI.AnonymousClass3 */

                @Override // android.widget.AdapterView.OnItemLongClickListener
                public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i2, long j2) {
                    AppMethodBeat.i(38237);
                    BizConversationFmUI.this.conversation = (az) BizConversationFmUI.this.Qbu.getItem(i2);
                    BizConversationFmUI.this.talker = BizConversationFmUI.this.conversation.field_username;
                    BizConversationFmUI.this.pqr.a(view, i2, j2, BizConversationFmUI.this, BizConversationFmUI.this.pso, BizConversationFmUI.this.ppd, BizConversationFmUI.this.ppe);
                    AppMethodBeat.o(38237);
                    return true;
                }
            });
            this.Qbu.setGetViewPositionCallback(new MMSlideDelView.c() {
                /* class com.tencent.mm.ui.conversation.BizConversationUI.BizConversationFmUI.AnonymousClass4 */

                @Override // com.tencent.mm.ui.base.MMSlideDelView.c
                public final int dr(View view) {
                    AppMethodBeat.i(38238);
                    int positionForView = BizConversationFmUI.this.Qbt.getPositionForView(view);
                    AppMethodBeat.o(38238);
                    return positionForView;
                }
            });
            this.Qbu.setPerformItemClickListener(new MMSlideDelView.g() {
                /* class com.tencent.mm.ui.conversation.BizConversationUI.BizConversationFmUI.AnonymousClass5 */

                @Override // com.tencent.mm.ui.base.MMSlideDelView.g
                public final void r(View view, int i2, int i3) {
                    AppMethodBeat.i(38239);
                    BizConversationFmUI.this.Qbt.performItemClick(view, i2, (long) i3);
                    AppMethodBeat.o(38239);
                }
            });
            this.Qbu.a(new MMSlideDelView.f() {
                /* class com.tencent.mm.ui.conversation.BizConversationUI.BizConversationFmUI.AnonymousClass6 */

                @Override // com.tencent.mm.ui.base.MMSlideDelView.f
                public final void cZ(Object obj) {
                    AppMethodBeat.i(38240);
                    if (obj == null) {
                        Log.e("MicroMsg.BizConversationUI", "onItemDel object null");
                        AppMethodBeat.o(38240);
                        return;
                    }
                    BizConversationFmUI.b(BizConversationFmUI.this, obj.toString());
                    AppMethodBeat.o(38240);
                }
            });
            if ("officialaccounts".equals(this.iNV)) {
                com.tencent.mm.plugin.bizui.a.a aVar = com.tencent.mm.plugin.bizui.a.a.pfC;
                boolean ckz = com.tencent.mm.plugin.bizui.a.a.ckz();
                Log.d("MicroMsg.BizConversationUI", "open search entrance:%b", Boolean.valueOf(ckz));
                if (ckz) {
                    addIconOptionMenu(1, R.string.hpa, R.raw.actionbar_icon_dark_search, new MenuItem.OnMenuItemClickListener() {
                        /* class com.tencent.mm.ui.conversation.BizConversationUI.BizConversationFmUI.AnonymousClass1 */

                        public final boolean onMenuItemClick(MenuItem menuItem) {
                            AppMethodBeat.i(38235);
                            if (ai.afs(0)) {
                                ((i) com.tencent.mm.kernel.g.af(i.class)).a(MMApplicationContext.getContext(), new Runnable() {
                                    /* class com.tencent.mm.ui.conversation.BizConversationUI.BizConversationFmUI.AnonymousClass1.AnonymousClass1 */

                                    public final void run() {
                                        AppMethodBeat.i(38234);
                                        Intent fXX = ai.fXX();
                                        fXX.putExtra("title", BizConversationFmUI.this.getString(R.string.dkg));
                                        fXX.putExtra("searchbar_tips", BizConversationFmUI.this.getString(R.string.dkg));
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
                                        if (Build.VERSION.SDK_INT >= 21 && !ao.isDarkMode()) {
                                            bundle = ActivityOptions.makeSceneTransitionAnimation(BizConversationFmUI.this.thisActivity(), new Pair[0]).toBundle();
                                        }
                                        com.tencent.mm.br.c.a(BizConversationFmUI.this.thisActivity(), "webview", ".ui.tools.fts.FTSSearchTabWebViewUI", fXX, bundle);
                                        AppMethodBeat.o(38234);
                                    }
                                });
                            } else {
                                Log.e("MicroMsg.BizConversationUI", "fts h5 template not avail");
                            }
                            AppMethodBeat.o(38235);
                            return true;
                        }
                    });
                }
            }
            bg.aVF();
            c.aST().add(this.Qbu);
            this.pss = System.currentTimeMillis();
            EventCenter.instance.addListener(this.ptp);
            Looper.myQueue().addIdleHandler(new MessageQueue.IdleHandler() {
                /* class com.tencent.mm.ui.conversation.BizConversationUI.BizConversationFmUI.AnonymousClass11 */

                public final boolean queueIdle() {
                    AppMethodBeat.i(38246);
                    Looper.myQueue().removeIdleHandler(this);
                    d.hiy();
                    AppMethodBeat.o(38246);
                    return false;
                }
            });
            AppMethodBeat.o(38259);
        }

        @Override // com.tencent.mm.ui.conversation.BaseConversationUI.BaseConversationFmUI, com.tencent.mm.ui.MMFragment
        public int getLayoutId() {
            return R.layout.c3f;
        }

        @Override // com.tencent.mm.ui.conversation.BaseConversationUI.BaseConversationFmUI
        public String getUserName() {
            return this.iNV;
        }

        @Override // com.tencent.mm.ui.conversation.BaseConversationUI.BaseConversationFmUI, com.tencent.mm.ui.FragmentActivitySupport, android.support.v4.app.Fragment, com.tencent.mm.ui.MMFragment
        public void onDestroy() {
            AppMethodBeat.i(38260);
            bg.aAk().postToWorker(new Runnable() {
                /* class com.tencent.mm.ui.conversation.BizConversationUI.BizConversationFmUI.AnonymousClass12 */

                public final void run() {
                    AppMethodBeat.i(38247);
                    BizConversationFmUI.a(BizConversationFmUI.this);
                    BizConversationFmUI.b(BizConversationFmUI.this);
                    BizConversationFmUI.c(BizConversationFmUI.this);
                    AppMethodBeat.o(38247);
                }
            });
            EventCenter.instance.removeListener(this.ptp);
            if (bg.aAc()) {
                bg.aVF();
                c.aST().remove(this.Qbu);
            }
            if (this.Qbu != null) {
                this.Qbu.onDestroy();
            }
            super.onDestroy();
            AppMethodBeat.o(38260);
        }

        @Override // com.tencent.mm.ui.conversation.BaseConversationUI.BaseConversationFmUI, android.support.v4.app.Fragment, com.tencent.mm.ui.MMFragment
        public void onResume() {
            AppMethodBeat.i(38261);
            Log.v("MicroMsg.BizConversationUI", "on resume");
            if (this.Qbu != null) {
                this.Qbu.onResume();
            }
            super.onResume();
            AppMethodBeat.o(38261);
        }

        @Override // com.tencent.mm.ui.conversation.BaseConversationUI.BaseConversationFmUI, android.support.v4.app.Fragment, com.tencent.mm.ui.MMFragment
        public void onPause() {
            AppMethodBeat.i(38262);
            Log.i("MicroMsg.BizConversationUI", "on pause");
            bg.aVF();
            c.aST().bka(this.iNV);
            if (this.Qbu != null) {
                this.Qbu.onPause();
            }
            super.onPause();
            AppMethodBeat.o(38262);
        }

        @Override // android.support.v4.app.Fragment
        public void onActivityResult(int i2, int i3, Intent intent) {
            AppMethodBeat.i(38263);
            super.onActivityResult(i2, i3, intent);
            if (this.talker != null && !this.talker.isEmpty()) {
                this.talker = "";
            }
            if (i3 != -1) {
                AppMethodBeat.o(38263);
            } else {
                AppMethodBeat.o(38263);
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
                AppMethodBeat.i(38254);
                this.dVu = str;
                AppMethodBeat.o(38254);
            }

            @Override // com.tencent.mm.ui.s, com.tencent.mm.ui.conversation.e
            public final void anp() {
                AppMethodBeat.i(38255);
                bg.aVF();
                setCursor(c.aST().c(ab.iCF, this.gzY, this.dVu));
                if (this.OFI != null) {
                    this.OFI.bnE();
                }
                super.notifyDataSetChanged();
                AppMethodBeat.o(38255);
            }

            /* access modifiers changed from: protected */
            @Override // com.tencent.mm.ui.conversation.e
            public final void a(az azVar, boolean z, int i2, boolean z2) {
                b bVar;
                u a2;
                AppMethodBeat.i(38256);
                if (azVar == null) {
                    AppMethodBeat.o(38256);
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
                    AppMethodBeat.o(38256);
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
                    AppMethodBeat.o(38256);
                    return;
                }
                bVar.seq = azVar.field_lastSeq;
                ca aEx = ((com.tencent.mm.plugin.messenger.foundation.a.l) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).eiy().aEx(azVar.field_username);
                if (aEx != null && aEx.gAt() && (a2 = ((com.tencent.mm.plugin.biz.a.a) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.biz.a.a.class)).a(aEx.field_msgId, aEx.field_content)) != null && !Util.isNullOrNil(a2.iAd) && !Util.isNullOrNil(((v) a2.iAd.get(0)).url)) {
                    try {
                        Uri parse = Uri.parse(((v) a2.iAd.get(0)).url);
                        bVar.MQr = Util.getLong(parse.getQueryParameter("mid"), 0);
                        bVar.MQs = Util.getInt(parse.getQueryParameter("idx"), 0);
                        AppMethodBeat.o(38256);
                        return;
                    } catch (UnsupportedOperationException e2) {
                        Log.w("MicroMsg.ConversationAdapter", "exposeLog exp %s", e2.getMessage());
                        AppMethodBeat.o(38256);
                        return;
                    } catch (Exception e3) {
                        Log.w("MicroMsg.ConversationAdapter", "exposeLog exp %s", e3.getMessage());
                    }
                }
                AppMethodBeat.o(38256);
            }

            public final void a(az azVar, int i2) {
                AppMethodBeat.i(38257);
                bg.aVF();
                a(azVar, c.aST().h(azVar), i2, true);
                AppMethodBeat.o(38257);
            }
        }

        @Override // android.support.v4.app.Fragment
        public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
            AppMethodBeat.i(38264);
            super.onCreateContextMenu(contextMenu, view, contextMenuInfo);
            bg.aVF();
            as Kn = c.aSN().Kn(this.talker);
            if (Kn == null) {
                Log.e("MicroMsg.BizConversationUI", "onCreateContextMenu, contact is null, talker = " + this.talker);
                AppMethodBeat.o(38264);
                return;
            }
            String arJ = Kn.arJ();
            if (arJ.toLowerCase().endsWith("@chatroom") && Util.isNullOrNil(Kn.field_nickname)) {
                arJ = getString(R.string.b25);
            }
            AdapterView.AdapterContextMenuInfo adapterContextMenuInfo = (AdapterView.AdapterContextMenuInfo) contextMenuInfo;
            contextMenu.setHeaderTitle(com.tencent.mm.pluginsdk.ui.span.l.c(thisActivity(), arJ));
            if (com.tencent.mm.contact.c.oR(Kn.field_type)) {
                if (Kn.arE()) {
                    contextMenu.add(adapterContextMenuInfo.position, 1, 0, R.string.euv);
                } else {
                    contextMenu.add(adapterContextMenuInfo.position, 1, 0, R.string.bh2);
                }
                contextMenu.add(adapterContextMenuInfo.position, 2, 0, R.string.eur);
            }
            contextMenu.add(adapterContextMenuInfo.position, 3, 0, R.string.euz);
            AppMethodBeat.o(38264);
        }

        static /* synthetic */ void a(BizConversationFmUI bizConversationFmUI) {
            AppMethodBeat.i(38265);
            if (!bg.aAc() || !"officialaccounts".equals(bizConversationFmUI.iNV)) {
                AppMethodBeat.o(38265);
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            int i2 = 0;
            int i3 = 0;
            int i4 = 0;
            long j2 = 0;
            int i5 = 0;
            StringBuilder sb = new StringBuilder("");
            bg.aVF();
            Cursor c2 = c.aST().c(ab.iCF, null, bizConversationFmUI.iNV);
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
            com.tencent.mm.plugin.report.service.h.INSTANCE.a(13771, Integer.valueOf(i5), Integer.valueOf(i3), Integer.valueOf(i2), Long.valueOf(j2 / 1000), Integer.valueOf(i4), sb.toString());
            Log.v("MicroMsg.BizConversationUI", "report use time:%d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
            AppMethodBeat.o(38265);
        }

        static /* synthetic */ void b(BizConversationFmUI bizConversationFmUI) {
            AppMethodBeat.i(38266);
            if (bizConversationFmUI.pss != 0 && "officialaccounts".equals(bizConversationFmUI.iNV)) {
                com.tencent.mm.plugin.report.service.h.INSTANCE.a(13932, Integer.valueOf(((int) (System.currentTimeMillis() - bizConversationFmUI.pss)) / 1000), 0, 0, 0, Integer.valueOf(bizConversationFmUI.source));
            }
            AppMethodBeat.o(38266);
        }

        static /* synthetic */ void c(BizConversationFmUI bizConversationFmUI) {
            AppMethodBeat.i(38267);
            if (bizConversationFmUI.Qbu != null) {
                LinkedList linkedList = new LinkedList();
                for (Map.Entry<String, b> entry : bizConversationFmUI.Qbu.pyQ.entrySet()) {
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
                Log.d("MicroMsg.BizConversationUI", "reportExpose size:%d", Integer.valueOf(linkedList.size()));
            }
            AppMethodBeat.o(38267);
        }

        static /* synthetic */ void a(BizConversationFmUI bizConversationFmUI, int i2) {
            AppMethodBeat.i(38268);
            if (i2 <= 0) {
                bizConversationFmUI.emptyTipTv.setVisibility(0);
                bizConversationFmUI.Qbt.setVisibility(8);
                AppMethodBeat.o(38268);
                return;
            }
            bizConversationFmUI.emptyTipTv.setVisibility(8);
            bizConversationFmUI.Qbt.setVisibility(0);
            AppMethodBeat.o(38268);
        }

        static /* synthetic */ void b(BizConversationFmUI bizConversationFmUI, final String str) {
            AppMethodBeat.i(38269);
            if (Util.isNullOrNil(str)) {
                Log.e("MicroMsg.BizConversationUI", "Delete Conversation and messages fail because username is null or nil.");
                AppMethodBeat.o(38269);
                return;
            }
            if ("officialaccounts".equals(bizConversationFmUI.iNV)) {
                com.tencent.mm.plugin.report.service.h.INSTANCE.a(13773, 0, Integer.valueOf(bizConversationFmUI.conversation.field_unReadCount), 0, bizConversationFmUI.conversation.field_username);
            }
            bg.aVF();
            ca aEw = c.aSQ().aEw(str);
            afk afk = new afk();
            afk.Lqk = new dqi().bhy(Util.nullAsNil(str));
            afk.Brn = aEw.field_msgSvrId;
            bg.aVF();
            c.aSM().d(new k.a(8, afk));
            bizConversationFmUI.isDeleteCancel = false;
            FragmentActivity thisActivity = bizConversationFmUI.thisActivity();
            bizConversationFmUI.getString(R.string.zb);
            final q a2 = com.tencent.mm.ui.base.h.a((Context) thisActivity, bizConversationFmUI.getString(R.string.a06), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
                /* class com.tencent.mm.ui.conversation.BizConversationUI.BizConversationFmUI.AnonymousClass7 */

                public final void onCancel(DialogInterface dialogInterface) {
                    AppMethodBeat.i(38241);
                    BizConversationFmUI.this.isDeleteCancel = true;
                    AppMethodBeat.o(38241);
                }
            });
            bp.a(str, new bp.a() {
                /* class com.tencent.mm.ui.conversation.BizConversationUI.BizConversationFmUI.AnonymousClass8 */

                @Override // com.tencent.mm.model.bp.a
                public final boolean amG() {
                    AppMethodBeat.i(38242);
                    boolean z = BizConversationFmUI.this.isDeleteCancel;
                    AppMethodBeat.o(38242);
                    return z;
                }

                @Override // com.tencent.mm.model.bp.a
                public final void amH() {
                    AppMethodBeat.i(38243);
                    if (a2 != null) {
                        a2.dismiss();
                    }
                    if (Util.nullAsNil(BizConversationFmUI.this.iNV).equals("officialaccounts")) {
                        com.tencent.mm.kernel.g.af(com.tencent.mm.al.q.class);
                        com.tencent.mm.storage.u.biP(str);
                    }
                    AppMethodBeat.o(38243);
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
            AppMethodBeat.o(38269);
        }
    }
}

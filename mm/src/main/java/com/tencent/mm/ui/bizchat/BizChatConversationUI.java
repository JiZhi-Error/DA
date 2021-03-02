package com.tencent.mm.ui.bizchat;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.database.Cursor;
import android.os.Bundle;
import android.os.Looper;
import android.os.MessageQueue;
import android.support.v4.app.FragmentActivity;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.al.a.a;
import com.tencent.mm.al.a.b;
import com.tencent.mm.al.a.d;
import com.tencent.mm.al.a.k;
import com.tencent.mm.al.ag;
import com.tencent.mm.al.d;
import com.tencent.mm.al.e;
import com.tencent.mm.al.p;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.bp;
import com.tencent.mm.model.c;
import com.tencent.mm.model.j;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.pluginsdk.h;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.protocal.protobuf.bfs;
import com.tencent.mm.sdk.platformtools.IntentUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MStorageEx;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.aa;
import com.tencent.mm.ui.base.MMSlideDelView;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.q;
import com.tencent.mm.ui.conversation.BaseConversationUI;
import com.tencent.mm.ui.conversation.presenter.BaseBizConversationUI;
import com.tencent.mm.ui.g;
import com.tencent.mm.ui.s;
import java.util.Iterator;
import java.util.LinkedList;

public class BizChatConversationUI extends BaseBizConversationUI {
    private View contentView;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.conversation.BaseConversationUI, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.ui.conversation.presenter.BaseBizConversationUI
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.conversation.BaseConversationUI, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(33956);
        super.onCreate(bundle);
        this.contentView = aa.jQ(this).inflate(R.layout.la, (ViewGroup) null);
        setContentView(this.contentView);
        this.conversationFm = new BizChatConversationFmUI();
        getSupportFragmentManager().beginTransaction().a(R.id.fgf, this.conversationFm).commit();
        h.a((MMFragmentActivity) this, this.contentView);
        AppMethodBeat.o(33956);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onConfigurationChanged(Configuration configuration) {
        AppMethodBeat.i(33957);
        super.onConfigurationChanged(configuration);
        h.a((MMFragmentActivity) this, this.contentView);
        AppMethodBeat.o(33957);
    }

    public static class BizChatConversationFmUI extends BaseConversationUI.BaseConversationFmUI implements p, MStorageEx.IOnStorageChange {
        private LinearLayout PaK;
        private b PaL;
        private k PaM;
        private int PaN = 0;
        private d PaO;
        private b.a PaP = new b.a() {
            /* class com.tencent.mm.ui.bizchat.BizChatConversationUI.BizChatConversationFmUI.AnonymousClass10 */

            @Override // com.tencent.mm.al.a.b.a
            public final void a(b.a.C0248b bVar) {
                AppMethodBeat.i(232781);
                if (!(bVar == null || bVar.iPF == null || !BizChatConversationFmUI.this.ppO.equals(bVar.iPF.field_brandUserName))) {
                    Log.i("MicroMsg.BizChatConversationFmUI", "bizChatExtension bizChatConv change");
                    BizChatConversationFmUI.this.PaL.Np(bVar.iPE);
                    if (BizChatConversationFmUI.this.isCurrentActivity) {
                        BizChatConversationFmUI.this.PaL.anp();
                    }
                }
                AppMethodBeat.o(232781);
            }
        };
        private d.a PaQ = new d.a() {
            /* class com.tencent.mm.ui.bizchat.BizChatConversationUI.BizChatConversationFmUI.AnonymousClass11 */

            @Override // com.tencent.mm.al.a.d.a
            public final void a(d.a.b bVar) {
                AppMethodBeat.i(232782);
                if (!(bVar == null || bVar.iPP == null || !BizChatConversationFmUI.this.ppO.equals(bVar.iPP.field_brandUserName))) {
                    Log.i("MicroMsg.BizChatConversationFmUI", "bizChatExtension bizChat change");
                    BizChatConversationFmUI.this.PaL.Np(bVar.iPE);
                    if (BizChatConversationFmUI.this.isCurrentActivity) {
                        BizChatConversationFmUI.this.PaL.anp();
                    }
                }
                AppMethodBeat.o(232782);
            }
        };
        private e.a PaR = new e.a() {
            /* class com.tencent.mm.ui.bizchat.BizChatConversationUI.BizChatConversationFmUI.AnonymousClass13 */

            @Override // com.tencent.mm.al.e.a
            public final void a(e.a.C0254a aVar) {
                AppMethodBeat.i(232783);
                String d2 = BizChatConversationFmUI.d(BizChatConversationFmUI.this);
                if (aVar != null && !Util.isNullOrNil(aVar.iNV) && aVar.iNV.equals(d2)) {
                    int i2 = BizChatConversationFmUI.this.PaN;
                    BizChatConversationFmUI.this.PaN = com.tencent.mm.ui.h.cy(BizChatConversationFmUI.this.getContext(), d2);
                    if (BizChatConversationFmUI.this.PaN != i2) {
                        BizChatConversationFmUI.p(BizChatConversationFmUI.this);
                    }
                }
                AppMethodBeat.o(232783);
            }
        };
        private String dik;
        private TextView emptyTipTv;
        private boolean isCurrentActivity;
        private boolean isDeleteCancel = false;
        private ListView pli;
        private o.g plk;
        private String ppO;
        private int ppd = 0;
        private int ppe = 0;
        private long ppv;
        private q tipDialog;

        public BizChatConversationFmUI() {
            AppMethodBeat.i(33937);
            AppMethodBeat.o(33937);
        }

        static /* synthetic */ void b(BizChatConversationFmUI bizChatConversationFmUI, long j2) {
            AppMethodBeat.i(33952);
            bizChatConversationFmUI.Nq(j2);
            AppMethodBeat.o(33952);
        }

        static /* synthetic */ String d(BizChatConversationFmUI bizChatConversationFmUI) {
            AppMethodBeat.i(33950);
            String gMa = bizChatConversationFmUI.gMa();
            AppMethodBeat.o(33950);
            return gMa;
        }

        static /* synthetic */ void p(BizChatConversationFmUI bizChatConversationFmUI) {
            AppMethodBeat.i(232786);
            bizChatConversationFmUI.gLZ();
            AppMethodBeat.o(232786);
        }

        @Override // android.support.v4.app.Fragment
        public void onActivityCreated(Bundle bundle) {
            AppMethodBeat.i(33938);
            super.onActivityCreated(bundle);
            this.ppO = thisActivity().getIntent().getStringExtra("Contact_User");
            Log.i("MicroMsg.BizChatConversationFmUI", "[registerListener]");
            ag.bak().a(this.PaP, thisActivity().getMainLooper());
            ag.baj().a(this.PaQ, thisActivity().getMainLooper());
            ag.bar().a(this.PaR, thisActivity().getMainLooper());
            bg.aVF();
            c.aST().add(this);
            this.emptyTipTv = (TextView) findViewById(R.id.c30);
            this.emptyTipTv.setText(R.string.ev3);
            this.pli = (ListView) findViewById(R.id.ir8);
            try {
                gLZ();
            } catch (NullPointerException e2) {
            }
            this.PaL = new b(thisActivity(), new s.a() {
                /* class com.tencent.mm.ui.bizchat.BizChatConversationUI.BizChatConversationFmUI.AnonymousClass18 */

                @Override // com.tencent.mm.ui.s.a
                public final void bnE() {
                    AppMethodBeat.i(33934);
                    BizChatConversationFmUI.this.setMMTitle(com.tencent.mm.model.aa.getDisplayName(BizChatConversationFmUI.this.ppO));
                    if (BizChatConversationFmUI.this.PaL.getCount() <= 0) {
                        BizChatConversationFmUI.this.emptyTipTv.setVisibility(0);
                        BizChatConversationFmUI.this.pli.setVisibility(8);
                        AppMethodBeat.o(33934);
                        return;
                    }
                    BizChatConversationFmUI.this.emptyTipTv.setVisibility(8);
                    if (BizChatConversationFmUI.this.pli != null) {
                        BizChatConversationFmUI.this.pli.setVisibility(0);
                    }
                    AppMethodBeat.o(33934);
                }
            }, this.ppO);
            this.PaL.setGetViewPositionCallback(new MMSlideDelView.c() {
                /* class com.tencent.mm.ui.bizchat.BizChatConversationUI.BizChatConversationFmUI.AnonymousClass19 */

                @Override // com.tencent.mm.ui.base.MMSlideDelView.c
                public final int dr(View view) {
                    AppMethodBeat.i(33935);
                    int positionForView = BizChatConversationFmUI.this.pli.getPositionForView(view);
                    AppMethodBeat.o(33935);
                    return positionForView;
                }
            });
            this.PaL.setPerformItemClickListener(new MMSlideDelView.g() {
                /* class com.tencent.mm.ui.bizchat.BizChatConversationUI.BizChatConversationFmUI.AnonymousClass20 */

                @Override // com.tencent.mm.ui.base.MMSlideDelView.g
                public final void r(View view, int i2, int i3) {
                    AppMethodBeat.i(33936);
                    BizChatConversationFmUI.this.pli.performItemClick(view, i2, (long) i3);
                    AppMethodBeat.o(33936);
                }
            });
            this.PaL.a(new MMSlideDelView.f() {
                /* class com.tencent.mm.ui.bizchat.BizChatConversationUI.BizChatConversationFmUI.AnonymousClass2 */

                @Override // com.tencent.mm.ui.base.MMSlideDelView.f
                public final void cZ(Object obj) {
                    AppMethodBeat.i(33914);
                    if (obj == null) {
                        Log.e("MicroMsg.BizChatConversationFmUI", "onItemDel object null");
                        AppMethodBeat.o(33914);
                        return;
                    }
                    AppMethodBeat.o(33914);
                }
            });
            this.pli.setAdapter((ListAdapter) this.PaL);
            this.plk = new o.g() {
                /* class com.tencent.mm.ui.bizchat.BizChatConversationUI.BizChatConversationFmUI.AnonymousClass14 */

                /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
                @Override // com.tencent.mm.ui.base.o.g
                public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
                    AppMethodBeat.i(33930);
                    switch (menuItem.getItemId()) {
                        case 0:
                            BizChatConversationFmUI.a(BizChatConversationFmUI.this, BizChatConversationFmUI.this.ppv);
                            AppMethodBeat.o(33930);
                            return;
                        case 1:
                            a Al = ag.bak().Al(BizChatConversationFmUI.this.ppv);
                            Al.field_unReadCount = 1;
                            Al.field_atCount = 0;
                            Al.field_atAll = 0;
                            ag.bak().b(Al);
                            com.tencent.mm.modelstat.b.jmd.V(Al.field_brandUserName, true);
                            AppMethodBeat.o(33930);
                            return;
                        case 2:
                            ag.bak().An(BizChatConversationFmUI.this.ppv);
                            com.tencent.mm.modelstat.b.jmd.V(ag.bak().Al(BizChatConversationFmUI.this.ppv).field_brandUserName, false);
                            AppMethodBeat.o(33930);
                            return;
                        case 3:
                            a Al2 = ag.bak().Al(BizChatConversationFmUI.this.ppv);
                            if (!ag.bak().Ao(BizChatConversationFmUI.this.ppv)) {
                                ag.bak().Ap(BizChatConversationFmUI.this.ppv);
                                com.tencent.mm.modelstat.b.jmd.c(true, Al2.field_brandUserName, true);
                                break;
                            } else {
                                ag.bak().Aq(BizChatConversationFmUI.this.ppv);
                                com.tencent.mm.modelstat.b.jmd.c(true, Al2.field_brandUserName, false);
                                AppMethodBeat.o(33930);
                                return;
                            }
                        case 4:
                            g.c(BizChatConversationFmUI.this.thisActivity(), new Runnable() {
                                /* class com.tencent.mm.ui.bizchat.BizChatConversationUI.BizChatConversationFmUI.AnonymousClass14.AnonymousClass1 */

                                public final void run() {
                                    AppMethodBeat.i(232784);
                                    ag.bak().Am(BizChatConversationFmUI.this.ppv);
                                    if (ag.bak().Nz(BizChatConversationFmUI.this.ppO) <= 0) {
                                        bg.aVF();
                                        c.aST().bjW(BizChatConversationFmUI.this.ppO);
                                    }
                                    AppMethodBeat.o(232784);
                                }
                            });
                            AppMethodBeat.o(33930);
                            return;
                    }
                    AppMethodBeat.o(33930);
                }
            };
            final com.tencent.mm.ui.widget.b.a aVar = new com.tencent.mm.ui.widget.b.a(thisActivity());
            this.pli.setOnTouchListener(new View.OnTouchListener() {
                /* class com.tencent.mm.ui.bizchat.BizChatConversationUI.BizChatConversationFmUI.AnonymousClass15 */

                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    AppMethodBeat.i(33931);
                    if (motionEvent.getAction() == 0) {
                        BizChatConversationFmUI.this.ppd = (int) motionEvent.getRawX();
                        BizChatConversationFmUI.this.ppe = (int) motionEvent.getRawY();
                    }
                    AppMethodBeat.o(33931);
                    return false;
                }
            });
            this.pli.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
                /* class com.tencent.mm.ui.bizchat.BizChatConversationUI.BizChatConversationFmUI.AnonymousClass16 */

                @Override // android.widget.AdapterView.OnItemLongClickListener
                public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i2, long j2) {
                    AppMethodBeat.i(33932);
                    aVar.a(view, i2, j2, BizChatConversationFmUI.this, BizChatConversationFmUI.this.plk, BizChatConversationFmUI.this.ppd, BizChatConversationFmUI.this.ppe);
                    AppMethodBeat.o(33932);
                    return true;
                }
            });
            this.pli.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                /* class com.tencent.mm.ui.bizchat.BizChatConversationUI.BizChatConversationFmUI.AnonymousClass17 */

                @Override // android.widget.AdapterView.OnItemClickListener
                public final void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
                    AppMethodBeat.i(33933);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(adapterView);
                    bVar.bm(view);
                    bVar.pH(i2);
                    bVar.zo(j2);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/bizchat/BizChatConversationUI$BizChatConversationFmUI$6", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, bVar.axR());
                    BizChatConversationFmUI.b(BizChatConversationFmUI.this, ((a) BizChatConversationFmUI.this.PaL.getItem(i2)).field_bizChatId);
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/bizchat/BizChatConversationUI$BizChatConversationFmUI$6", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                    AppMethodBeat.o(33933);
                }
            });
            setBackBtn(new MenuItem.OnMenuItemClickListener() {
                /* class com.tencent.mm.ui.bizchat.BizChatConversationUI.BizChatConversationFmUI.AnonymousClass3 */

                public final boolean onMenuItemClick(MenuItem menuItem) {
                    AppMethodBeat.i(33915);
                    BizChatConversationFmUI.this.finish();
                    AppMethodBeat.o(33915);
                    return true;
                }
            });
            addIconOptionMenu(1, R.string.hpa, R.raw.actionbar_icon_dark_search, new MenuItem.OnMenuItemClickListener() {
                /* class com.tencent.mm.ui.bizchat.BizChatConversationUI.BizChatConversationFmUI.AnonymousClass4 */

                public final boolean onMenuItemClick(MenuItem menuItem) {
                    AppMethodBeat.i(33916);
                    Log.v("MicroMsg.BizChatConversationFmUI", "search btn was clicked.");
                    Intent intent = new Intent(BizChatConversationFmUI.this.getContext(), BizChatSearchUI.class);
                    intent.putExtra("enterprise_biz_name", BizChatConversationFmUI.this.ppO);
                    intent.putExtra("biz_chat_search_scene", 1);
                    intent.putExtra("biz_chat_search_text", "");
                    intent.addFlags(67108864);
                    BizChatConversationFmUI bizChatConversationFmUI = BizChatConversationFmUI.this;
                    com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                    com.tencent.mm.hellhoundlib.a.a.a(bizChatConversationFmUI, bl.axQ(), "com/tencent/mm/ui/bizchat/BizChatConversationUI$BizChatConversationFmUI$12", "onMenuItemClick", "(Landroid/view/MenuItem;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    bizChatConversationFmUI.startActivity((Intent) bl.pG(0));
                    com.tencent.mm.hellhoundlib.a.a.a(bizChatConversationFmUI, "com/tencent/mm/ui/bizchat/BizChatConversationUI$BizChatConversationFmUI$12", "onMenuItemClick", "(Landroid/view/MenuItem;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    AppMethodBeat.o(33916);
                    return true;
                }
            });
            addIconOptionMenu(2, R.string.cz, R.raw.actionbar_icon_dark_add, new com.tencent.mm.ui.conversation.presenter.b(this.ui, gMa()));
            String fC = ag.bal().fC(this.ppO);
            this.PaM = ag.bal().fB(fC);
            Object[] objArr = new Object[3];
            objArr[0] = this.ppO;
            objArr[1] = fC;
            objArr[2] = Boolean.valueOf(this.PaM == null);
            Log.i("MicroMsg.BizChatConversationFmUI", "updateBizChatMyUserInfo: %s:%s,myBizChatUserInfo is null:%s", objArr);
            if (Util.isNullOrNil(fC) || this.PaM == null || this.PaM.bay() || Util.isNullOrNil(this.PaM.field_addMemberUrl)) {
                ag.baq();
                com.tencent.mm.al.a.h.a(this.ppO, this);
                FragmentActivity thisActivity = thisActivity();
                getString(R.string.zb);
                this.tipDialog = com.tencent.mm.ui.base.h.a((Context) thisActivity, getString(R.string.a06), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
                    /* class com.tencent.mm.ui.bizchat.BizChatConversationUI.BizChatConversationFmUI.AnonymousClass8 */

                    public final void onCancel(DialogInterface dialogInterface) {
                        AppMethodBeat.i(232779);
                        BizChatConversationFmUI.this.finish();
                        AppMethodBeat.o(232779);
                    }
                });
            }
            bg.aAk().postToWorkerDelayed(new Runnable() {
                /* class com.tencent.mm.ui.bizchat.BizChatConversationUI.BizChatConversationFmUI.AnonymousClass9 */

                public final void run() {
                    AppMethodBeat.i(232780);
                    Log.i("MicroMsg.BizChatConversationFmUI", "updateChatInfoFromSvr");
                    LinkedList<String> linkedList = new LinkedList<>();
                    LinkedList<String> linkedList2 = new LinkedList<>();
                    Cursor NB = ag.bak().NB(BizChatConversationFmUI.this.ppO);
                    if (NB.moveToFirst()) {
                        while (!NB.isAfterLast()) {
                            a aVar = new a();
                            aVar.convertFrom(NB);
                            NB.moveToNext();
                            com.tencent.mm.al.a.c bs = ag.baj().bs(aVar.field_bizChatId);
                            if (bs.bay()) {
                                if (bs.isGroup()) {
                                    linkedList2.add(bs.field_bizChatServId);
                                } else {
                                    linkedList.add(bs.field_bizChatServId);
                                }
                            }
                        }
                    }
                    NB.close();
                    if (linkedList2.size() > 0) {
                        ag.baq().b(linkedList2, BizChatConversationFmUI.this.ppO);
                    }
                    BizChatConversationFmUI.a(BizChatConversationFmUI.this, linkedList);
                    if (linkedList.size() > 0) {
                        ag.baq().c(linkedList, BizChatConversationFmUI.this.ppO);
                    }
                    AppMethodBeat.o(232780);
                }
            }, 300);
            String gMa = gMa();
            if (gMa != null) {
                ag.bar();
                e.a(gMa, (i) null);
                Log.e("MicroMsg.BizChatConversationFmUI", "update father attr from svr mainBizName:%s", gMa);
            } else {
                Log.e("MicroMsg.BizChatConversationFmUI", "mainBizName is null!!!");
            }
            this.PaO = ag.bar().MO(gMa());
            Looper.myQueue().addIdleHandler(new MessageQueue.IdleHandler() {
                /* class com.tencent.mm.ui.bizchat.BizChatConversationUI.BizChatConversationFmUI.AnonymousClass1 */

                public final boolean queueIdle() {
                    AppMethodBeat.i(33913);
                    BizChatConversationFmUI.this.dik = ag.bah().MT(BizChatConversationFmUI.this.ppO).UN();
                    int intExtra = BizChatConversationFmUI.this.thisActivity().getIntent().getIntExtra("biz_chat_from_scene", 7);
                    int i2 = -1;
                    if (BizChatConversationFmUI.this.PaL != null) {
                        i2 = BizChatConversationFmUI.this.PaL.getCount();
                    }
                    com.tencent.mm.al.d MO = ag.bar().MO(BizChatConversationFmUI.this.dik);
                    int i3 = MO != null ? MO.field_qyUin : 0;
                    int i4 = MO != null ? MO.field_userUin : 0;
                    int MQ = ag.bar().MQ(BizChatConversationFmUI.this.ppO);
                    long j2 = MO != null ? MO.field_wwCorpId : 0;
                    long j3 = MO != null ? MO.field_wwUserVid : 0;
                    com.tencent.mm.plugin.report.service.h.INSTANCE.a(12648, BizChatConversationFmUI.this.dik, BizChatConversationFmUI.this.ppO, Integer.valueOf(intExtra), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(MQ), Integer.valueOf(i4), Long.valueOf(j2), Long.valueOf(j3));
                    Log.d("MicroMsg.BizChatConversationFmUI", "bizchat report belong:%s,brandUserName:%s,fromScene:%s,itemCount:%s,fatherUin:%d,childUin:%d,userUin:%d,wwCorpId:%l,wwUserVidL%l", BizChatConversationFmUI.this.dik, BizChatConversationFmUI.this.ppO, Integer.valueOf(intExtra), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(MQ), Integer.valueOf(i4), Long.valueOf(j2), Long.valueOf(j3));
                    AppMethodBeat.o(33913);
                    return false;
                }
            });
            Intent intent = thisActivity().getIntent();
            if (IntentUtil.getBooleanExtra(intent, "biz_chat_need_to_jump_to_chatting_ui", false)) {
                long longExtra = intent.getLongExtra("biz_chat_chat_id", -1);
                if (longExtra != -1) {
                    Nq(longExtra);
                }
            }
            AppMethodBeat.o(33938);
        }

        @Override // com.tencent.mm.ui.conversation.BaseConversationUI.BaseConversationFmUI, com.tencent.mm.ui.MMFragment
        public int getLayoutId() {
            return R.layout.a43;
        }

        @Override // com.tencent.mm.ui.conversation.BaseConversationUI.BaseConversationFmUI
        public String getUserName() {
            AppMethodBeat.i(33939);
            if (Util.isNullOrNil(this.dik)) {
                String str = this.ppO;
                AppMethodBeat.o(33939);
                return str;
            }
            String str2 = this.dik;
            AppMethodBeat.o(33939);
            return str2;
        }

        @Override // android.support.v4.app.Fragment, com.tencent.mm.ui.conversation.BaseConversationUI.BaseConversationFmUI, com.tencent.mm.ui.MMFragment
        public void onResume() {
            AppMethodBeat.i(33941);
            super.onResume();
            as Kn = ((l) com.tencent.mm.kernel.g.af(l.class)).aSN().Kn(this.ppO);
            if (Kn == null || !com.tencent.mm.contact.c.oR(Kn.field_type)) {
                Log.w("MicroMsg.BizChatConversationFmUI", "onResume is not contact now");
                finish();
                AppMethodBeat.o(33941);
                return;
            }
            com.tencent.mm.api.c fJ = com.tencent.mm.al.g.fJ(this.ppO);
            if (fJ == null || fJ.field_enterpriseFather == null || !ab.IS(fJ.field_enterpriseFather)) {
                Log.w("MicroMsg.BizChatConversationFmUI", "onResume enterpriseFather is invalid");
                finish();
                AppMethodBeat.o(33941);
                return;
            }
            if (Kn.Zx()) {
                setTitleMuteIconVisibility(0);
            } else {
                setTitleMuteIconVisibility(8);
            }
            this.isCurrentActivity = true;
            this.PaL.onNotifyChange(null, null);
            bg.getNotification().CY(this.ppO);
            AppMethodBeat.o(33941);
        }

        @Override // android.support.v4.app.Fragment, com.tencent.mm.ui.conversation.BaseConversationUI.BaseConversationFmUI, com.tencent.mm.ui.MMFragment
        public void onPause() {
            AppMethodBeat.i(33942);
            Log.i("MicroMsg.BizChatConversationFmUI", "on pause");
            bg.aVF();
            c.aST().bka(this.ppO);
            b bak = ag.bak();
            String str = this.ppO;
            if (Util.isNullOrNil(str)) {
                Log.e("MicroMsg.BizConversationStorage", "brandUserName is null");
            } else {
                String str2 = "update BizChatConversation set newUnReadCount = 0 where newUnReadCount != 0 and brandUserName = '" + str + "'";
                Log.d("MicroMsg.BizConversationStorage", "resetNewUnreadCount :%s,sql:%s", Boolean.valueOf(bak.db.execSQL("BizChatConversation", str2)), str2);
            }
            if (this.PaL != null) {
                this.PaL.onPause();
            }
            this.isCurrentActivity = false;
            bg.getNotification().CY("");
            super.onPause();
            AppMethodBeat.o(33942);
        }

        @Override // android.support.v4.app.Fragment
        public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
            AppMethodBeat.i(33943);
            AdapterView.AdapterContextMenuInfo adapterContextMenuInfo = (AdapterView.AdapterContextMenuInfo) contextMenuInfo;
            a aVar = (a) this.PaL.getItem(adapterContextMenuInfo.position);
            this.ppv = aVar.field_bizChatId;
            if (aVar.field_unReadCount <= 0) {
                contextMenu.add(adapterContextMenuInfo.position, 1, 1, R.string.euu);
            } else {
                contextMenu.add(adapterContextMenuInfo.position, 2, 1, R.string.eus);
            }
            ag.bak();
            if (b.c(aVar)) {
                contextMenu.add(adapterContextMenuInfo.position, 3, 2, R.string.euv);
            } else {
                contextMenu.add(adapterContextMenuInfo.position, 3, 2, R.string.eut);
            }
            contextMenu.add(adapterContextMenuInfo.position, 0, 3, R.string.euz);
            AppMethodBeat.o(33943);
        }

        @Override // android.support.v4.app.Fragment
        public void onActivityResult(int i2, int i3, Intent intent) {
            boolean z;
            AppMethodBeat.i(33944);
            super.onActivityResult(i2, i3, intent);
            if (i3 != -1) {
                AppMethodBeat.o(33944);
                return;
            }
            switch (i2) {
                case 1:
                    Bundle bundleExtra = intent.getBundleExtra("result_data");
                    if (bundleExtra != null) {
                        Log.i("MicroMsg.BizChatConversationFmUI", "bundle != null");
                        String string = bundleExtra.getString("enterprise_members");
                        bfs bfs = new bfs();
                        com.tencent.mm.al.a.c cVar = new com.tencent.mm.al.a.c();
                        cVar.field_addMemberUrl = this.PaM != null ? this.PaM.field_addMemberUrl : null;
                        cVar.field_brandUserName = this.ppO;
                        if (!com.tencent.mm.al.a.e.a(cVar, string, null, bfs)) {
                            z = false;
                        } else if (cVar.field_bizChatLocalId != -1) {
                            Nq(cVar.field_bizChatLocalId);
                            z = true;
                        } else {
                            ag.baq();
                            final com.tencent.mm.al.a.o a2 = com.tencent.mm.al.a.h.a(this.ppO, bfs, this);
                            FragmentActivity thisActivity = thisActivity();
                            getString(R.string.zb);
                            this.tipDialog = com.tencent.mm.ui.base.h.a((Context) thisActivity, getString(R.string.a06), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
                                /* class com.tencent.mm.ui.bizchat.BizChatConversationUI.BizChatConversationFmUI.AnonymousClass5 */

                                public final void onCancel(DialogInterface dialogInterface) {
                                    AppMethodBeat.i(232776);
                                    ag.baq();
                                    com.tencent.mm.al.a.h.d(a2);
                                    AppMethodBeat.o(232776);
                                }
                            });
                            z = true;
                        }
                    } else {
                        z = false;
                    }
                    if (!z) {
                        Toast.makeText(thisActivity(), getString(R.string.g6j), 0).show();
                        AppMethodBeat.o(33944);
                        return;
                    }
                    AppMethodBeat.o(33944);
                    return;
                default:
                    AppMethodBeat.o(33944);
                    return;
            }
        }

        @Override // com.tencent.mm.al.p
        public final void a(int i2, com.tencent.mm.ak.q qVar) {
            AppMethodBeat.i(33945);
            if (this.tipDialog != null) {
                this.tipDialog.dismiss();
                this.tipDialog = null;
            }
            if (qVar.getType() == 1355) {
                com.tencent.mm.al.a.c NE = ag.baj().NE(((com.tencent.mm.al.a.o) qVar).baD().Lpw.LPp.KTl);
                if (NE == null) {
                    Toast.makeText(MMApplicationContext.getContext(), getString(R.string.g6j), 0).show();
                    AppMethodBeat.o(33945);
                    return;
                }
                Nq(NE.field_bizChatLocalId);
            }
            AppMethodBeat.o(33945);
        }

        private void gLZ() {
            AppMethodBeat.i(33946);
            String gMa = gMa();
            this.PaN = com.tencent.mm.ui.h.cy(getContext(), gMa);
            if (this.PaN == 2 && this.PaK == null) {
                this.PaK = (LinearLayout) findViewById(R.id.aa7);
                ViewGroup.LayoutParams layoutParams = this.PaK.getLayoutParams();
                layoutParams.height = com.tencent.mm.cb.a.aG(getContext(), R.dimen.bc);
                this.PaK.setLayoutParams(layoutParams);
                View inflate = aa.jQ(getContext()).inflate(R.layout.a44, (ViewGroup) this.PaK, false);
                float ez = com.tencent.mm.cb.a.ez(getContext());
                CdnImageView cdnImageView = (CdnImageView) inflate.findViewById(R.id.dtx);
                int i2 = cdnImageView.getLayoutParams().height;
                cdnImageView.getLayoutParams().height = (int) (((float) i2) * ez);
                cdnImageView.getLayoutParams().width = (int) (ez * ((float) i2));
                cdnImageView.requestLayout();
                TextView textView = (TextView) inflate.findViewById(R.id.ir3);
                ag.bar();
                ag.bar();
                String sM = e.sM(0);
                if (sM == null || sM.length() <= 0) {
                    textView.setText(R.string.bxv);
                } else {
                    textView.setText(sM);
                }
                ag.bar();
                int aZC = e.aZC();
                if (aZC != 0) {
                    textView.setTextColor(aZC);
                }
                ag.bar();
                String aZB = e.aZB();
                if (aZB != null && aZB.length() > 0) {
                    cdnImageView.setUrl(aZB);
                }
                this.PaK.addView(inflate);
                inflate.setOnClickListener(new View.OnClickListener() {
                    /* class com.tencent.mm.ui.bizchat.BizChatConversationUI.BizChatConversationFmUI.AnonymousClass12 */

                    public final void onClick(View view) {
                        AppMethodBeat.i(33927);
                        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                        bVar.bm(view);
                        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/bizchat/BizChatConversationUI$BizChatConversationFmUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                        com.tencent.mm.ui.h.s(BizChatConversationFmUI.this.getContext(), BizChatConversationFmUI.d(BizChatConversationFmUI.this), 4);
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/bizchat/BizChatConversationUI$BizChatConversationFmUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(33927);
                    }
                });
                com.tencent.mm.ui.h.r(getContext(), this.ppO, 4);
                com.tencent.mm.ui.h.cz(getContext(), gMa);
            }
            if (this.PaK != null) {
                if (this.PaN == 2) {
                    this.PaK.setVisibility(0);
                    AppMethodBeat.o(33946);
                    return;
                }
                this.PaK.setVisibility(8);
            }
            AppMethodBeat.o(33946);
        }

        private String gMa() {
            AppMethodBeat.i(33948);
            if (Util.isNullOrNil(this.dik)) {
                this.dik = ag.bah().MT(this.ppO).UN();
            }
            String str = this.dik;
            AppMethodBeat.o(33948);
            return str;
        }

        private void Nq(long j2) {
            AppMethodBeat.i(33949);
            Bundle bundle = new Bundle();
            bundle.putLong("key_biz_chat_id", j2);
            bundle.putBoolean("finish_direct", false);
            bundle.putBoolean("key_need_send_video", false);
            bundle.putBoolean("key_is_biz_chat", true);
            this.ui.startChatting(this.ppO, bundle, true);
            AppMethodBeat.o(33949);
        }

        @Override // com.tencent.mm.sdk.storage.MStorageEx.IOnStorageChange
        public void onNotifyChange(int i2, MStorageEx mStorageEx, Object obj) {
        }

        @Override // com.tencent.mm.ui.FragmentActivitySupport, android.support.v4.app.Fragment, com.tencent.mm.ui.conversation.BaseConversationUI.BaseConversationFmUI, com.tencent.mm.ui.MMFragment
        public void onDestroy() {
            AppMethodBeat.i(33940);
            Log.i("MicroMsg.BizChatConversationFmUI", "[unRegitListener]");
            ag.bak().a(this.PaP);
            ag.baj().a(this.PaQ);
            ag.bar().a(this.PaR);
            if (bg.aAc()) {
                bg.aVF();
                c.aST().remove(this);
            }
            this.PaL.ebf();
            this.PaL.onDestroy();
            super.onDestroy();
            AppMethodBeat.o(33940);
        }

        static /* synthetic */ void a(BizChatConversationFmUI bizChatConversationFmUI, final long j2) {
            AppMethodBeat.i(33951);
            Log.i("MicroMsg.BizChatConversationFmUI", "deleteChatroom");
            ag.baj().bs(j2);
            bizChatConversationFmUI.isDeleteCancel = false;
            FragmentActivity thisActivity = bizChatConversationFmUI.thisActivity();
            bizChatConversationFmUI.getString(R.string.zb);
            bizChatConversationFmUI.tipDialog = com.tencent.mm.ui.base.h.a((Context) thisActivity, bizChatConversationFmUI.getString(R.string.a06), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
                /* class com.tencent.mm.ui.bizchat.BizChatConversationUI.BizChatConversationFmUI.AnonymousClass6 */

                public final void onCancel(DialogInterface dialogInterface) {
                    AppMethodBeat.i(33920);
                    BizChatConversationFmUI.this.isDeleteCancel = true;
                    AppMethodBeat.o(33920);
                }
            });
            j.a(bizChatConversationFmUI.ppO, j2, new bp.a() {
                /* class com.tencent.mm.ui.bizchat.BizChatConversationUI.BizChatConversationFmUI.AnonymousClass7 */

                @Override // com.tencent.mm.model.bp.a
                public final boolean amG() {
                    AppMethodBeat.i(232777);
                    boolean z = BizChatConversationFmUI.this.isDeleteCancel;
                    AppMethodBeat.o(232777);
                    return z;
                }

                @Override // com.tencent.mm.model.bp.a
                public final void amH() {
                    AppMethodBeat.i(232778);
                    if (BizChatConversationFmUI.this.tipDialog != null) {
                        ag.baj().Am(j2);
                        ag.bak().Am(j2);
                        if (ag.bak().Nz(BizChatConversationFmUI.this.ppO) <= 0) {
                            bg.aVF();
                            c.aST().bjW(BizChatConversationFmUI.this.ppO);
                        }
                        BizChatConversationFmUI.this.tipDialog.dismiss();
                    }
                    AppMethodBeat.o(232778);
                }
            });
            AppMethodBeat.o(33951);
        }

        static /* synthetic */ void a(BizChatConversationFmUI bizChatConversationFmUI, LinkedList linkedList) {
            AppMethodBeat.i(232785);
            if (linkedList.size() == 0) {
                Log.i("MicroMsg.BizChatConversationFmUI", "userIdList is empty");
                AppMethodBeat.o(232785);
                return;
            }
            SharedPreferences sharedPreferences = bizChatConversationFmUI.getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0);
            if (sharedPreferences.getBoolean("FIRST_TIME_IN_BIZCHAT_CONV_" + bizChatConversationFmUI.ppO, true)) {
                Log.i("MicroMsg.BizChatConversationFmUI", "updateData");
                long currentTimeMillis = System.currentTimeMillis();
                ISQLiteDatabase iSQLiteDatabase = ag.bal().db;
                long j2 = 0;
                if (iSQLiteDatabase instanceof com.tencent.mm.storagebase.h) {
                    j2 = ((com.tencent.mm.storagebase.h) iSQLiteDatabase).beginTransaction(Thread.currentThread().getId());
                }
                Iterator it = linkedList.iterator();
                while (it.hasNext()) {
                    String str = (String) it.next();
                    com.tencent.mm.al.a.c NE = ag.baj().NE(str);
                    if (NE != null && !NE.isGroup()) {
                        k fB = ag.bal().fB(str);
                        String str2 = fB != null ? fB.field_userName : null;
                        if (str2 != null && !str2.equals(NE.field_chatName)) {
                            NE.field_chatName = str2;
                            ag.baj().b(NE);
                        }
                    }
                }
                if (iSQLiteDatabase instanceof com.tencent.mm.storagebase.h) {
                    bg.aVF();
                    c.getDataDB().endTransaction(j2);
                }
                sharedPreferences.edit().putBoolean("FIRST_TIME_IN_BIZCHAT_CONV_" + bizChatConversationFmUI.ppO, false).commit();
                Log.d("MicroMsg.BizChatConversationFmUI", "updateData use time:%s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
            }
            AppMethodBeat.o(232785);
        }
    }
}

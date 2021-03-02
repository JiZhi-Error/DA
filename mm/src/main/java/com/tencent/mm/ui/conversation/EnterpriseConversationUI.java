package com.tencent.mm.ui.conversation;

import android.content.Intent;
import android.graphics.Point;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.al.ag;
import com.tencent.mm.al.e;
import com.tencent.mm.al.f;
import com.tencent.mm.al.g;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bg;
import com.tencent.mm.pluginsdk.h;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorageEx;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.az;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.aa;
import com.tencent.mm.ui.base.MMSlideDelView;
import com.tencent.mm.ui.bizchat.BizChatSearchUI;
import com.tencent.mm.ui.conversation.BaseConversationUI;
import com.tencent.mm.ui.conversation.l;
import com.tencent.mm.ui.conversation.presenter.BaseBizConversationUI;
import com.tencent.mm.ui.conversation.presenter.a;
import com.tencent.mm.ui.conversation.presenter.c;
import com.tencent.mm.ui.conversation.presenter.d;
import com.tencent.mm.ui.s;
import java.util.LinkedList;

public class EnterpriseConversationUI extends BaseBizConversationUI {
    private View contentView;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.conversation.BaseConversationUI, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.ui.conversation.presenter.BaseBizConversationUI
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.conversation.BaseConversationUI, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(38586);
        super.onCreate(bundle);
        this.contentView = aa.jQ(this).inflate(R.layout.la, (ViewGroup) null);
        setContentView(this.contentView);
        this.conversationFm = new EnterpriseConversationFmUI();
        getSupportFragmentManager().beginTransaction().a(R.id.fgf, this.conversationFm).commit();
        h.a((MMFragmentActivity) this, this.contentView);
        AppMethodBeat.o(38586);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void finish() {
        AppMethodBeat.i(38587);
        if (this.conversationFm != null && (this.conversationFm instanceof EnterpriseConversationFmUI)) {
            ((EnterpriseConversationFmUI) this.conversationFm).jmU = System.currentTimeMillis() / 1000;
        }
        super.finish();
        AppMethodBeat.o(38587);
    }

    public static class EnterpriseConversationFmUI extends BaseConversationUI.BaseConversationFmUI implements MStorageEx.IOnStorageChange {
        private LinearLayout PaK = null;
        private int PaN = 0;
        private e.a PaR = new e.a() {
            /* class com.tencent.mm.ui.conversation.EnterpriseConversationUI.EnterpriseConversationFmUI.AnonymousClass7 */

            @Override // com.tencent.mm.al.e.a
            public final void a(e.a.C0254a aVar) {
                AppMethodBeat.i(234162);
                if (aVar != null && !Util.isNullOrNil(aVar.iNV) && aVar.iNV.equals(EnterpriseConversationFmUI.this.iNV)) {
                    int i2 = EnterpriseConversationFmUI.this.PaN;
                    EnterpriseConversationFmUI.this.PaN = com.tencent.mm.ui.h.cy(EnterpriseConversationFmUI.this.getContext(), EnterpriseConversationFmUI.this.iNV);
                    if (EnterpriseConversationFmUI.this.PaN != i2) {
                        EnterpriseConversationFmUI.k(EnterpriseConversationFmUI.this);
                    }
                }
                AppMethodBeat.o(234162);
            }
        };
        private ListView Qbt;
        private String Qbv;
        private View Qfb = null;
        private l Qfc;
        private String Qfd = null;
        private MMHandler Qfe;
        private int Qff = -2;
        private String Qfg = null;
        private a Qfh;
        private c Qfi;
        private TextView emptyTipTv;
        private long enterTime = 0;
        private int fromScene;
        private String iNV;
        long jmU = 0;
        private long oJs = 0;

        public EnterpriseConversationFmUI() {
            AppMethodBeat.i(38568);
            AppMethodBeat.o(38568);
        }

        static /* synthetic */ void k(EnterpriseConversationFmUI enterpriseConversationFmUI) {
            AppMethodBeat.i(234171);
            enterpriseConversationFmUI.gLZ();
            AppMethodBeat.o(234171);
        }

        @Override // android.support.v4.app.Fragment
        public void onActivityCreated(Bundle bundle) {
            String str;
            AppMethodBeat.i(38569);
            super.onActivityCreated(bundle);
            this.iNV = thisActivity().getIntent().getStringExtra("enterprise_biz_name");
            this.Qbv = thisActivity().getIntent().getStringExtra("enterprise_biz_display_name");
            this.fromScene = thisActivity().getIntent().getIntExtra("enterprise_from_scene", 5);
            setMMTitle(this.Qbv);
            this.Qbt = (ListView) findViewById(R.id.ir8);
            this.emptyTipTv = (TextView) findViewById(R.id.c30);
            this.emptyTipTv.setText(R.string.bxh);
            setBackBtn(new MenuItem.OnMenuItemClickListener() {
                /* class com.tencent.mm.ui.conversation.EnterpriseConversationUI.EnterpriseConversationFmUI.AnonymousClass1 */

                public final boolean onMenuItemClick(MenuItem menuItem) {
                    AppMethodBeat.i(38546);
                    EnterpriseConversationFmUI.this.finish();
                    AppMethodBeat.o(38546);
                    return true;
                }
            });
            setToTop(new View.OnClickListener() {
                /* class com.tencent.mm.ui.conversation.EnterpriseConversationUI.EnterpriseConversationFmUI.AnonymousClass8 */

                public final void onClick(View view) {
                    AppMethodBeat.i(38558);
                    b bVar = new b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/conversation/EnterpriseConversationUI$EnterpriseConversationFmUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(EnterpriseConversationFmUI.this.Qbt);
                    Object obj = new Object();
                    com.tencent.mm.hellhoundlib.a.a.a(obj, bl.axQ(), "com/tencent/mm/ui/conversation/EnterpriseConversationUI$EnterpriseConversationFmUI$2", "onClick", "(Landroid/view/View;)V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
                    BackwardSupportUtil.SmoothScrollFactory.scrollToTop((ListView) bl.pG(0));
                    com.tencent.mm.hellhoundlib.a.a.a(obj, "com/tencent/mm/ui/conversation/EnterpriseConversationUI$EnterpriseConversationFmUI$2", "onClick", "(Landroid/view/View;)V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/conversation/EnterpriseConversationUI$EnterpriseConversationFmUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(38558);
                }
            });
            if (g.fJ(this.iNV) != null) {
                gLZ();
                if (this.iNV != null) {
                    AnonymousClass9 r0 = new i() {
                        /* class com.tencent.mm.ui.conversation.EnterpriseConversationUI.EnterpriseConversationFmUI.AnonymousClass9 */

                        @Override // com.tencent.mm.ak.i
                        public final void onSceneEnd(int i2, int i3, String str, q qVar) {
                            AppMethodBeat.i(38559);
                            EnterpriseConversationFmUI.b(EnterpriseConversationFmUI.this);
                            AppMethodBeat.o(38559);
                        }
                    };
                    ag.bar();
                    e.a(this.iNV, r0);
                    Log.e("MicroMsg.EnterpriseConversationUI", "update father attr from svr bizName:%s", this.iNV);
                } else {
                    Log.e("MicroMsg.EnterpriseConversationUI", "bizName is null!!!");
                }
                addIconOptionMenu(1, R.string.hpa, R.raw.actionbar_icon_dark_search, new MenuItem.OnMenuItemClickListener() {
                    /* class com.tencent.mm.ui.conversation.EnterpriseConversationUI.EnterpriseConversationFmUI.AnonymousClass11 */

                    public final boolean onMenuItemClick(MenuItem menuItem) {
                        AppMethodBeat.i(38561);
                        ag.bah();
                        String MX = f.MX(EnterpriseConversationFmUI.this.iNV);
                        if (TextUtils.isEmpty(MX)) {
                            Intent intent = new Intent();
                            intent.putExtra("enterprise_biz_name", EnterpriseConversationFmUI.this.iNV);
                            intent.addFlags(67108864);
                            com.tencent.mm.br.c.b(EnterpriseConversationFmUI.this.getContext(), "brandservice", ".ui.EnterpriseBizSearchUI", intent);
                        } else {
                            Intent intent2 = new Intent(EnterpriseConversationFmUI.this.getContext(), BizChatSearchUI.class);
                            intent2.putExtra("enterprise_biz_name", MX);
                            intent2.putExtra("enterprise_biz_father_name", EnterpriseConversationFmUI.this.iNV);
                            intent2.putExtra("biz_chat_search_scene", 1);
                            intent2.putExtra("biz_chat_search_text", "");
                            intent2.addFlags(67108864);
                            EnterpriseConversationFmUI enterpriseConversationFmUI = EnterpriseConversationFmUI.this;
                            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent2);
                            com.tencent.mm.hellhoundlib.a.a.a(enterpriseConversationFmUI, bl.axQ(), "com/tencent/mm/ui/conversation/EnterpriseConversationUI$EnterpriseConversationFmUI$5", "onMenuItemClick", "(Landroid/view/MenuItem;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                            enterpriseConversationFmUI.startActivity((Intent) bl.pG(0));
                            com.tencent.mm.hellhoundlib.a.a.a(enterpriseConversationFmUI, "com/tencent/mm/ui/conversation/EnterpriseConversationUI$EnterpriseConversationFmUI$5", "onMenuItemClick", "(Landroid/view/MenuItem;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                        }
                        AppMethodBeat.o(38561);
                        return true;
                    }
                });
                addIconOptionMenu(2, R.string.cz, R.raw.actionbar_icon_dark_add, new com.tencent.mm.ui.conversation.presenter.b(this.ui, this.iNV));
                this.Qfc = new l(thisActivity(), this.iNV, new s.a() {
                    /* class com.tencent.mm.ui.conversation.EnterpriseConversationUI.EnterpriseConversationFmUI.AnonymousClass12 */

                    @Override // com.tencent.mm.ui.s.a
                    public final void bnE() {
                        AppMethodBeat.i(234163);
                        EnterpriseConversationFmUI.a(EnterpriseConversationFmUI.this, EnterpriseConversationFmUI.this.Qfc.getCount());
                        AppMethodBeat.o(234163);
                    }
                });
                l lVar = this.Qfc;
                AnonymousClass13 r1 = new MMSlideDelView.c() {
                    /* class com.tencent.mm.ui.conversation.EnterpriseConversationUI.EnterpriseConversationFmUI.AnonymousClass13 */

                    @Override // com.tencent.mm.ui.base.MMSlideDelView.c
                    public final int dr(View view) {
                        AppMethodBeat.i(234164);
                        int positionForView = EnterpriseConversationFmUI.this.Qbt.getPositionForView(view);
                        AppMethodBeat.o(234164);
                        return positionForView;
                    }
                };
                lVar.Qgf.setGetViewPositionCallback(r1);
                lVar.Qgg.setGetViewPositionCallback(r1);
                l lVar2 = this.Qfc;
                AnonymousClass14 r12 = new MMSlideDelView.g() {
                    /* class com.tencent.mm.ui.conversation.EnterpriseConversationUI.EnterpriseConversationFmUI.AnonymousClass14 */

                    @Override // com.tencent.mm.ui.base.MMSlideDelView.g
                    public final void r(View view, int i2, int i3) {
                        AppMethodBeat.i(234165);
                        EnterpriseConversationFmUI.this.Qbt.performItemClick(view, i2, (long) i3);
                        AppMethodBeat.o(234165);
                    }
                };
                lVar2.Qgf.setPerformItemClickListener(r12);
                lVar2.Qgg.setPerformItemClickListener(r12);
                l lVar3 = this.Qfc;
                AnonymousClass15 r13 = new MMSlideDelView.f() {
                    /* class com.tencent.mm.ui.conversation.EnterpriseConversationUI.EnterpriseConversationFmUI.AnonymousClass15 */

                    @Override // com.tencent.mm.ui.base.MMSlideDelView.f
                    public final void cZ(Object obj) {
                        AppMethodBeat.i(234166);
                        if (obj == null) {
                            Log.e("MicroMsg.EnterpriseConversationUI", "onItemDel object null");
                            AppMethodBeat.o(234166);
                            return;
                        }
                        EnterpriseConversationFmUI.a(EnterpriseConversationFmUI.this, obj.toString());
                        AppMethodBeat.o(234166);
                    }
                };
                lVar3.Qgf.a(r13);
                lVar3.Qgg.a(r13);
                this.Qbt.setAdapter((ListAdapter) this.Qfc);
                this.Qbt.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    /* class com.tencent.mm.ui.conversation.EnterpriseConversationUI.EnterpriseConversationFmUI.AnonymousClass2 */

                    @Override // android.widget.AdapterView.OnItemClickListener
                    public final void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
                        AppMethodBeat.i(234158);
                        b bVar = new b();
                        bVar.bm(adapterView);
                        bVar.bm(view);
                        bVar.pH(i2);
                        bVar.zo(j2);
                        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/conversation/EnterpriseConversationUI$EnterpriseConversationFmUI$10", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, bVar.axR());
                        l.a anT = EnterpriseConversationFmUI.this.Qfc.anT(i2);
                        d a2 = EnterpriseConversationFmUI.a(EnterpriseConversationFmUI.this, anT);
                        if (a2 == null) {
                            Log.e("MicroMsg.EnterpriseConversationUI", "user should not be null. position:%d, size:%d", Integer.valueOf(i2), Integer.valueOf(EnterpriseConversationFmUI.this.Qfc.getCount()));
                            EnterpriseConversationFmUI.this.Qfc.notifyDataSetChanged();
                            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/conversation/EnterpriseConversationUI$EnterpriseConversationFmUI$10", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                            AppMethodBeat.o(234158);
                            return;
                        }
                        a2.a(anT);
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/conversation/EnterpriseConversationUI$EnterpriseConversationFmUI$10", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                        AppMethodBeat.o(234158);
                    }
                });
                final Point point = new Point();
                this.Qbt.setOnTouchListener(new View.OnTouchListener() {
                    /* class com.tencent.mm.ui.conversation.EnterpriseConversationUI.EnterpriseConversationFmUI.AnonymousClass4 */

                    public final boolean onTouch(View view, MotionEvent motionEvent) {
                        AppMethodBeat.i(234160);
                        if (motionEvent.getAction() == 0) {
                            point.x = (int) motionEvent.getRawX();
                            point.y = (int) motionEvent.getRawY();
                        }
                        AppMethodBeat.o(234160);
                        return false;
                    }
                });
                this.Qbt.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
                    /* class com.tencent.mm.ui.conversation.EnterpriseConversationUI.EnterpriseConversationFmUI.AnonymousClass5 */

                    @Override // android.widget.AdapterView.OnItemLongClickListener
                    public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i2, long j2) {
                        AppMethodBeat.i(38550);
                        l.a anT = EnterpriseConversationFmUI.this.Qfc.anT(i2);
                        d a2 = EnterpriseConversationFmUI.a(EnterpriseConversationFmUI.this, anT);
                        if (a2 == null) {
                            AppMethodBeat.o(38550);
                            return false;
                        }
                        boolean a3 = a2.a(view, point, i2, j2, anT);
                        AppMethodBeat.o(38550);
                        return a3;
                    }
                });
            }
            this.enterTime = System.currentTimeMillis() / 1000;
            bg.aVF();
            az bjY = com.tencent.mm.model.c.aST().bjY(this.iNV);
            if (bjY != null) {
                this.Qff = bjY.field_unReadCount;
                if (this.Qff == 0 && bjY.field_unReadMuteCount > 0) {
                    this.Qff = -1;
                }
                this.oJs = bjY.field_conversationTime / 1000;
                if (bjY.field_isSend == 1) {
                    str = null;
                } else {
                    str = bjY.field_digestUser;
                }
                this.Qfg = str;
            }
            ag.bar().a(this.PaR, thisActivity().getMainLooper());
            bg.aVF();
            com.tencent.mm.model.c.aST().add(this);
            bg.aVF();
            com.tencent.mm.model.c.aSN().add(this);
            if (this.Qfc != null) {
                if (this.Qfe == null) {
                    this.Qfe = new MMHandler() {
                        /* class com.tencent.mm.ui.conversation.EnterpriseConversationUI.EnterpriseConversationFmUI.AnonymousClass6 */

                        @Override // com.tencent.mm.sdk.platformtools.MMHandler
                        public final void handleMessage(Message message) {
                            int i2;
                            String str;
                            AppMethodBeat.i(234161);
                            if (message != null && message.what == 1 && EnterpriseConversationFmUI.this.thisActivity() != null && !EnterpriseConversationFmUI.this.thisActivity().isFinishing()) {
                                int count = EnterpriseConversationFmUI.this.Qfc.getCount();
                                LinkedList<String> linkedList = new LinkedList<>();
                                LinkedList linkedList2 = new LinkedList();
                                int i3 = 0;
                                int i4 = 0;
                                int i5 = 0;
                                int i6 = 0;
                                while (i6 < count) {
                                    l.a anT = EnterpriseConversationFmUI.this.Qfc.anT(i6);
                                    az azVar = anT == null ? null : anT.conversation;
                                    if (!(azVar == null || (str = azVar.field_username) == null)) {
                                        if (!ab.IS(str) || !g.Ni(str)) {
                                            Log.d("MicroMsg.EnterpriseConversationUI", "checkEnterpriseChildConv delete conv %s", str);
                                            linkedList.add(str);
                                            i2 = i5;
                                            i6++;
                                            i5 = i2;
                                        } else {
                                            as Kn = ((com.tencent.mm.plugin.messenger.foundation.a.l) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().Kn(str);
                                            boolean bkg = ((com.tencent.mm.plugin.messenger.foundation.a.l) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aST().bkg(str);
                                            boolean z = (Kn == null || (Kn.field_type & 2048) == 0) ? false : true;
                                            if (z && !bkg) {
                                                ((com.tencent.mm.plugin.messenger.foundation.a.l) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aST().bke(str);
                                            } else if (!z && bkg) {
                                                ((com.tencent.mm.plugin.messenger.foundation.a.l) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aST().bkf(str);
                                            }
                                            if (g.Nh(str)) {
                                                linkedList2.add(str);
                                            }
                                            if (azVar.field_unReadCount > 0) {
                                                if (ab.JJ(str)) {
                                                    i3++;
                                                    i2 = i5;
                                                } else {
                                                    i4++;
                                                    i2 = azVar.field_unReadCount + i5;
                                                }
                                                i6++;
                                                i5 = i2;
                                            }
                                        }
                                    }
                                    i2 = i5;
                                    i6++;
                                    i5 = i2;
                                }
                                com.tencent.mm.al.d MO = ag.bar().MO(EnterpriseConversationFmUI.this.iNV);
                                int i7 = MO != null ? MO.field_qyUin : 0;
                                long j2 = MO != null ? MO.field_wwCorpId : 0;
                                long j3 = MO != null ? MO.field_wwUserVid : 0;
                                int i8 = 0;
                                if (!Util.isNullOrNil(EnterpriseConversationFmUI.this.Qfg)) {
                                    i8 = ag.bar().MQ(EnterpriseConversationFmUI.this.Qfg);
                                }
                                com.tencent.mm.plugin.report.service.h.INSTANCE.a(12892, EnterpriseConversationFmUI.this.iNV, Integer.valueOf(EnterpriseConversationFmUI.this.fromScene), Integer.valueOf(count), "", Integer.valueOf(EnterpriseConversationFmUI.this.Qff), Integer.valueOf(i5), Integer.valueOf(i3), Integer.valueOf(i4), Long.valueOf(EnterpriseConversationFmUI.this.oJs), Integer.valueOf(i8), Integer.valueOf(i7), Long.valueOf(j2), Long.valueOf(j3));
                                Log.d("MicroMsg.EnterpriseConversationUI", "enter biz enterprise father report: %s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s", EnterpriseConversationFmUI.this.iNV, Integer.valueOf(EnterpriseConversationFmUI.this.fromScene), Integer.valueOf(count), "", Integer.valueOf(EnterpriseConversationFmUI.this.Qff), Integer.valueOf(i5), Integer.valueOf(i3), Integer.valueOf(i4), Long.valueOf(EnterpriseConversationFmUI.this.oJs), Integer.valueOf(i8), Integer.valueOf(i7), Long.valueOf(j2), Long.valueOf(j3));
                                if (linkedList.size() > 0) {
                                    bg.aVF();
                                    com.tencent.mm.model.c.aST().bI(linkedList);
                                    EnterpriseConversationFmUI.this.Qfc.anp();
                                }
                                if (ag.bau().MN(EnterpriseConversationFmUI.this.iNV)) {
                                    ag.bar();
                                    e.a(EnterpriseConversationFmUI.this.iNV, (i) null);
                                }
                                ag.bau().MN(EnterpriseConversationFmUI.i(EnterpriseConversationFmUI.this));
                                if (linkedList2.size() > 0) {
                                    for (int i9 = 0; i9 < linkedList2.size(); i9++) {
                                        ag.bau().MN((String) linkedList2.get(i9));
                                    }
                                }
                            }
                            AppMethodBeat.o(234161);
                        }
                    };
                } else {
                    this.Qfe.removeMessages(1);
                }
                this.Qfe.sendEmptyMessageDelayed(1, 500);
            }
            AppMethodBeat.o(38569);
        }

        @Override // com.tencent.mm.ui.conversation.BaseConversationUI.BaseConversationFmUI, com.tencent.mm.ui.MMFragment
        public int getLayoutId() {
            return R.layout.a43;
        }

        @Override // com.tencent.mm.ui.conversation.BaseConversationUI.BaseConversationFmUI
        public String getUserName() {
            return this.iNV;
        }

        @Override // com.tencent.mm.ui.conversation.BaseConversationUI.BaseConversationFmUI, com.tencent.mm.ui.FragmentActivitySupport, android.support.v4.app.Fragment, com.tencent.mm.ui.MMFragment
        public void onDestroy() {
            int i2;
            int i3;
            AppMethodBeat.i(38570);
            ag.bar().a(this.PaR);
            if (bg.aAc()) {
                bg.aVF();
                com.tencent.mm.model.c.aST().remove(this);
                bg.aVF();
                com.tencent.mm.model.c.aSN().remove(this);
            }
            if (this.Qfc != null) {
                l lVar = this.Qfc;
                j jVar = lVar.Qgf;
                jVar.Qca.stopTimer();
                if (jVar.Pax != null) {
                    jVar.Pax.clear();
                    jVar.Pax = null;
                }
                jVar.ebf();
                jVar.gGV();
                bg.aVF();
                com.tencent.mm.model.c.aST().remove(jVar);
                lVar.Qgg.onDestroy();
            }
            if (this.Qfi != null) {
                bg.azz().b(1394, this.Qfi);
            }
            if (this.enterTime > 0 && this.jmU > 0) {
                long j2 = this.jmU - this.enterTime;
                com.tencent.mm.al.d MO = ag.bar().MO(this.iNV);
                if (MO != null) {
                    i2 = MO.field_qyUin;
                } else {
                    i2 = 0;
                }
                if (MO != null) {
                    i3 = MO.field_userUin;
                } else {
                    i3 = 0;
                }
                com.tencent.mm.plugin.report.service.h.INSTANCE.a(13465, "", Integer.valueOf(i2), 0, Integer.valueOf(i3), 1, Long.valueOf(j2));
                Log.d("MicroMsg.EnterpriseConversationUI", "quit biz enterprise father report: %s,%s,%s,%s,%s", Integer.valueOf(i2), 0, Integer.valueOf(i3), 1, Long.valueOf(j2));
            }
            super.onDestroy();
            AppMethodBeat.o(38570);
        }

        @Override // com.tencent.mm.ui.conversation.BaseConversationUI.BaseConversationFmUI, android.support.v4.app.Fragment, com.tencent.mm.ui.MMFragment
        public void onResume() {
            AppMethodBeat.i(38571);
            Log.v("MicroMsg.EnterpriseConversationUI", "on resume");
            if (this.Qfh != null) {
                a aVar = this.Qfh;
                if (0 != aVar.QiZ) {
                    if (aVar.QiY != null) {
                        aVar.QiY.NW(aVar.QiZ);
                    }
                    aVar.QiZ = 0;
                }
            }
            if (this.Qfc != null) {
                l lVar = this.Qfc;
                lVar.Qgf.onResume();
                lVar.Qgg.onResume();
            }
            super.onResume();
            if (!ab.IS(this.iNV)) {
                finish();
            }
            AppMethodBeat.o(38571);
        }

        @Override // com.tencent.mm.ui.conversation.BaseConversationUI.BaseConversationFmUI, android.support.v4.app.Fragment, com.tencent.mm.ui.MMFragment
        public void onPause() {
            AppMethodBeat.i(38572);
            Log.v("MicroMsg.EnterpriseConversationUI", "on pause");
            bg.aVF();
            com.tencent.mm.model.c.aST().bka(this.iNV);
            if (this.Qfc != null) {
                l lVar = this.Qfc;
                lVar.Qgf.onPause();
                lVar.Qgg.onPause();
            }
            super.onPause();
            AppMethodBeat.o(38572);
        }

        @Override // android.support.v4.app.Fragment
        public void onActivityResult(int i2, int i3, Intent intent) {
            AppMethodBeat.i(38573);
            super.onActivityResult(i2, i3, intent);
            switch (i2) {
                case 1:
                    if (i3 != -1 || intent == null) {
                        AppMethodBeat.o(38573);
                        return;
                    }
                    String stringExtra = intent.getStringExtra("be_send_card_name");
                    String stringExtra2 = intent.getStringExtra("received_card_name");
                    boolean booleanExtra = intent.getBooleanExtra("Is_Chatroom", false);
                    String stringExtra3 = intent.getStringExtra("custom_send_text");
                    com.tencent.mm.plugin.messenger.a.g.eir().s(stringExtra, stringExtra2, booleanExtra);
                    com.tencent.mm.plugin.messenger.a.g.eir().iF(stringExtra3, stringExtra2);
                    com.tencent.mm.ui.widget.snackbar.b.r(thisActivity(), getContext().getString(R.string.dc_));
                    AppMethodBeat.o(38573);
                    return;
                default:
                    AppMethodBeat.o(38573);
                    return;
            }
        }

        private void gLZ() {
            AppMethodBeat.i(38574);
            this.PaN = com.tencent.mm.ui.h.cy(getContext(), this.iNV);
            if (this.PaN == 2 && this.PaK == null) {
                this.PaK = (LinearLayout) findViewById(R.id.aa7);
                ViewGroup.LayoutParams layoutParams = this.PaK.getLayoutParams();
                layoutParams.height = com.tencent.mm.cb.a.aG(getContext(), R.dimen.bc);
                this.PaK.setLayoutParams(layoutParams);
                this.Qfb = aa.jQ(getContext()).inflate(R.layout.a44, (ViewGroup) this.PaK, false);
                float ez = com.tencent.mm.cb.a.ez(getContext());
                CdnImageView cdnImageView = (CdnImageView) this.Qfb.findViewById(R.id.dtx);
                int i2 = cdnImageView.getLayoutParams().height;
                cdnImageView.getLayoutParams().height = (int) (((float) i2) * ez);
                cdnImageView.getLayoutParams().width = (int) (ez * ((float) i2));
                cdnImageView.requestLayout();
                TextView textView = (TextView) this.Qfb.findViewById(R.id.ir3);
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
                com.tencent.mm.ui.h.aQ(this.iNV, 1, 2);
                this.PaK.addView(this.Qfb);
                this.Qfb.setOnClickListener(new View.OnClickListener() {
                    /* class com.tencent.mm.ui.conversation.EnterpriseConversationUI.EnterpriseConversationFmUI.AnonymousClass10 */

                    public final void onClick(View view) {
                        AppMethodBeat.i(38560);
                        b bVar = new b();
                        bVar.bm(view);
                        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/conversation/EnterpriseConversationUI$EnterpriseConversationFmUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                        com.tencent.mm.ui.h.s(EnterpriseConversationFmUI.this.getContext(), EnterpriseConversationFmUI.this.iNV, 3);
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/conversation/EnterpriseConversationUI$EnterpriseConversationFmUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(38560);
                    }
                });
                com.tencent.mm.ui.h.r(getContext(), this.iNV, 3);
                com.tencent.mm.ui.h.cz(getContext(), this.iNV);
            }
            if (this.PaK != null) {
                if (this.PaN == 2) {
                    this.PaK.setVisibility(0);
                    gVQ();
                    AppMethodBeat.o(38574);
                    return;
                }
                this.PaK.setVisibility(8);
            }
            AppMethodBeat.o(38574);
        }

        private void gVQ() {
            AppMethodBeat.i(38575);
            com.tencent.mm.al.d MO = ag.bar().MO(this.iNV);
            int i2 = MO != null ? MO.field_qyUin : 0;
            int i3 = MO != null ? MO.field_userUin : 0;
            long j2 = MO != null ? MO.field_wwCorpId : 0;
            long j3 = MO != null ? MO.field_wwUserVid : 0;
            com.tencent.mm.plugin.report.service.h.INSTANCE.a(13656, Integer.valueOf(i2), Integer.valueOf(i3), 6, 3, Long.valueOf(j2), Long.valueOf(j3));
            Log.d("MicroMsg.EnterpriseConversationUI", "expose wework btn on session list  report: %s,%s,%s,%s,%s,%s", Integer.valueOf(i2), Integer.valueOf(i3), 6, 3, Long.valueOf(j2), Long.valueOf(j3));
            AppMethodBeat.o(38575);
        }

        @Override // com.tencent.mm.sdk.storage.MStorageEx.IOnStorageChange
        public void onNotifyChange(int i2, MStorageEx mStorageEx, Object obj) {
        }

        static /* synthetic */ void b(EnterpriseConversationFmUI enterpriseConversationFmUI) {
            AppMethodBeat.i(38578);
            if (enterpriseConversationFmUI.Qfb != null) {
                ag.bar().MO(enterpriseConversationFmUI.iNV);
                TextView textView = (TextView) enterpriseConversationFmUI.Qfb.findViewById(R.id.ir3);
                ag.bar();
                ag.bar();
                String sM = e.sM(0);
                if (textView != null && sM != null && sM.length() > 0 && !textView.getText().equals(sM)) {
                    textView.setText(sM);
                }
                ag.bar();
                int aZC = e.aZC();
                if (!(textView == null || aZC == 0)) {
                    textView.setTextColor(aZC);
                }
                CdnImageView cdnImageView = (CdnImageView) enterpriseConversationFmUI.Qfb.findViewById(R.id.dtx);
                ag.bar();
                String aZB = e.aZB();
                if (!(cdnImageView == null || aZB == null || aZB.length() <= 0)) {
                    cdnImageView.setUrl(aZB);
                }
            }
            AppMethodBeat.o(38578);
        }

        static /* synthetic */ void a(EnterpriseConversationFmUI enterpriseConversationFmUI, int i2) {
            AppMethodBeat.i(234167);
            if (i2 <= 0) {
                enterpriseConversationFmUI.emptyTipTv.setVisibility(0);
                enterpriseConversationFmUI.Qbt.setVisibility(8);
                AppMethodBeat.o(234167);
                return;
            }
            enterpriseConversationFmUI.emptyTipTv.setVisibility(8);
            enterpriseConversationFmUI.Qbt.setVisibility(0);
            AppMethodBeat.o(234167);
        }

        static /* synthetic */ void a(EnterpriseConversationFmUI enterpriseConversationFmUI, String str) {
            AppMethodBeat.i(234168);
            if (Util.isNullOrNil(str)) {
                Log.e("MicroMsg.EnterpriseConversationUI", "Delete Conversation and messages fail because username is null or nil.");
                AppMethodBeat.o(234168);
                return;
            }
            if (enterpriseConversationFmUI.Qfi == null) {
                enterpriseConversationFmUI.Qfi = new c(enterpriseConversationFmUI.ui, enterpriseConversationFmUI.iNV);
            }
            enterpriseConversationFmUI.Qfi.delConversationAndMsg(str);
            AppMethodBeat.o(234168);
        }

        static /* synthetic */ d a(EnterpriseConversationFmUI enterpriseConversationFmUI, l.a aVar) {
            AppMethodBeat.i(234169);
            if (aVar != null) {
                if (aVar.qcr == 0 && aVar.Qgk != null) {
                    if (enterpriseConversationFmUI.Qfh == null) {
                        enterpriseConversationFmUI.Qfh = new a(enterpriseConversationFmUI.ui, new a.b() {
                            /* class com.tencent.mm.ui.conversation.EnterpriseConversationUI.EnterpriseConversationFmUI.AnonymousClass3 */

                            @Override // com.tencent.mm.ui.conversation.presenter.a.b
                            public final void NW(long j2) {
                                AppMethodBeat.i(234159);
                                try {
                                    EnterpriseConversationFmUI.this.Qfc.Qgg.Np(j2);
                                    AppMethodBeat.o(234159);
                                } catch (Throwable th) {
                                    AppMethodBeat.o(234159);
                                }
                            }
                        });
                    }
                    a aVar2 = enterpriseConversationFmUI.Qfh;
                    AppMethodBeat.o(234169);
                    return aVar2;
                } else if (aVar.qcr == 1 && aVar.conversation != null) {
                    if (enterpriseConversationFmUI.Qfi == null) {
                        enterpriseConversationFmUI.Qfi = new c(enterpriseConversationFmUI.ui, enterpriseConversationFmUI.iNV);
                    }
                    c cVar = enterpriseConversationFmUI.Qfi;
                    AppMethodBeat.o(234169);
                    return cVar;
                }
            }
            AppMethodBeat.o(234169);
            return null;
        }

        static /* synthetic */ String i(EnterpriseConversationFmUI enterpriseConversationFmUI) {
            AppMethodBeat.i(234170);
            if (enterpriseConversationFmUI.Qfd == null) {
                ag.bah();
                String MX = f.MX(enterpriseConversationFmUI.iNV);
                if (Util.isNullOrNil(MX)) {
                    MX = "";
                }
                enterpriseConversationFmUI.Qfd = MX;
            }
            if (Util.isNullOrNil(enterpriseConversationFmUI.Qfd)) {
                AppMethodBeat.o(234170);
                return null;
            }
            String str = enterpriseConversationFmUI.Qfd;
            AppMethodBeat.o(234170);
            return str;
        }
    }
}

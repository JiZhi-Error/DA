package com.tencent.mm.plugin.card.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.os.MessageQueue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.kinda.framework.app.KindaConfigCacheStg;
import com.tencent.liteav.TXLiteAVCode;
import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.wq;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.kernel.i;
import com.tencent.mm.plugin.card.b.k;
import com.tencent.mm.plugin.card.base.CardBaseUI;
import com.tencent.mm.plugin.card.base.d;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.plugin.card.d.r;
import com.tencent.mm.plugin.card.model.ad;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.model.n;
import com.tencent.mm.plugin.card.sharecard.a.b;
import com.tencent.mm.plugin.card.sharecard.ui.ShareCardListUI;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.up;
import com.tencent.mm.protocal.protobuf.vc;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorage;
import com.tencent.mm.sdk.storage.MStorageEventData;
import com.tencent.mm.storage.ar;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.y.c;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

@i
public class CardHomePageUI extends CardBaseUI implements d, MStorage.IOnStorageChange {
    private int fromScene = 0;
    private long mStartTime = 0;
    private boolean pXF = false;
    private boolean pXH = true;
    private boolean pXJ = false;
    private String pXK = "";
    private boolean pXL = false;
    private boolean pXM = false;
    private long pXQ = 0;
    boolean pXR = false;
    private b pXs;
    private i qcb;
    private f qcc;
    private f qcd;
    private boolean qce = true;
    private boolean qcf = false;
    private TextView qcg;
    private LinearLayout qch;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.plugin.card.base.CardBaseUI, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    static /* synthetic */ void b(CardHomePageUI cardHomePageUI) {
        AppMethodBeat.i(113444);
        cardHomePageUI.cwa();
        AppMethodBeat.o(113444);
    }

    static /* synthetic */ void d(CardHomePageUI cardHomePageUI) {
        AppMethodBeat.i(113446);
        cardHomePageUI.csn();
        AppMethodBeat.o(113446);
    }

    static /* synthetic */ void h(CardHomePageUI cardHomePageUI) {
        AppMethodBeat.i(113447);
        cardHomePageUI.cvY();
        AppMethodBeat.o(113447);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.plugin.card.base.CardBaseUI, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(113419);
        super.onCreate(bundle);
        this.fromScene = getIntent().getIntExtra("key_home_page_from_scene", 0);
        long currentTimeMillis = System.currentTimeMillis();
        this.mStartTime = currentTimeMillis;
        this.pXQ = currentTimeMillis;
        initView();
        am.ctU().a(this.qcb);
        g.aAg().hqi.a(1164, this);
        g.aAg().hqi.a(1054, this);
        am.ctX().cuu();
        am.ctP();
        com.tencent.mm.plugin.card.b.b.Ef(1);
        cuW();
        Looper.myQueue().addIdleHandler(new MessageQueue.IdleHandler() {
            /* class com.tencent.mm.plugin.card.ui.CardHomePageUI.AnonymousClass9 */

            public final boolean queueIdle() {
                AppMethodBeat.i(113418);
                if (CardHomePageUI.this.pXs != null) {
                    b unused = CardHomePageUI.this.pXs;
                    if (b.cuD()) {
                        Log.i("MicroMsg.CardHomePageUI", "try2UpdateCardType");
                        CardHomePageUI.h(CardHomePageUI.this);
                    }
                }
                AppMethodBeat.o(113418);
                return false;
            }
        });
        am.ctX().a(this);
        am.ctQ().add(this);
        ((com.tencent.mm.pluginsdk.wallet.b) g.af(com.tencent.mm.pluginsdk.wallet.b.class)).he(8, 2);
        AppMethodBeat.o(113419);
    }

    @Override // com.tencent.mm.ui.MMActivity, com.tencent.mm.plugin.card.base.CardBaseUI
    public int getLayoutId() {
        return R.layout.ng;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.plugin.card.base.CardBaseUI, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(113420);
        if (this.qcf) {
            csp();
        }
        am.ctU().b(this.qcb);
        this.pXs.pVL = null;
        g.aAg().hqi.b(1164, this);
        g.aAg().hqi.b(1054, this);
        am.ctX().b(this);
        am.ctQ().remove(this);
        k.ctF();
        b.cuA();
        long currentTimeMillis = System.currentTimeMillis() - this.pXQ;
        h.INSTANCE.a(13219, "CardHomePageUI", Integer.valueOf(this.fromScene), "", "", Long.valueOf(currentTimeMillis));
        super.onDestroy();
        AppMethodBeat.o(113420);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.plugin.card.base.CardBaseUI, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        AppMethodBeat.i(113421);
        Log.i("MicroMsg.CardHomePageUI", "onResume locationPermissionGranted %s, hasInitLocation %s, shouldGetLayout %s", Boolean.valueOf(this.qcf), Boolean.valueOf(this.pXR), Boolean.valueOf(this.pXF));
        if (this.qcf) {
            if (this.pXR && this.pXF) {
                this.pXK = "";
                this.pXL = false;
                cso();
            }
        } else if (this.pXF) {
            this.pXK = "";
            cuT();
        }
        this.pXF = false;
        updateView();
        long currentTimeMillis = System.currentTimeMillis();
        if (this.mStartTime != 0) {
            ArrayList<IDKey> arrayList = new ArrayList<>();
            IDKey iDKey = new IDKey();
            iDKey.SetID(281);
            iDKey.SetKey(0);
            iDKey.SetValue(1);
            IDKey iDKey2 = new IDKey();
            iDKey2.SetID(281);
            iDKey2.SetKey(1);
            iDKey2.SetValue((long) ((int) (currentTimeMillis - this.mStartTime)));
            arrayList.add(iDKey);
            arrayList.add(iDKey2);
            h.INSTANCE.b(arrayList, true);
            this.mStartTime = 0;
        }
        g.aAk().postToWorker(new Runnable() {
            /* class com.tencent.mm.plugin.card.ui.CardHomePageUI.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(113410);
                am.cug().a(r.EN_DYNAMIC_CODE_SCENE_ENTER_WXCARD);
                AppMethodBeat.o(113410);
            }
        });
        super.onResume();
        AppMethodBeat.o(113421);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.plugin.card.base.CardBaseUI, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onPause() {
        AppMethodBeat.i(113422);
        super.onPause();
        AppMethodBeat.o(113422);
    }

    @Override // com.tencent.mm.ui.MMActivity, com.tencent.mm.plugin.card.base.CardBaseUI
    public void initView() {
        AppMethodBeat.i(113423);
        boolean a2 = com.tencent.mm.pluginsdk.permission.b.a(this, new String[]{"android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION"}, 69, (String) null, (String) null);
        Log.i("MicroMsg.CardHomePageUI", "checkPermission checkLocation[%b]", Boolean.valueOf(a2));
        this.qcf = a2;
        if (this.qcf) {
            cuN();
        } else {
            Log.e("MicroMsg.CardHomePageUI", "location permission is denied, doGetLayout");
            cuT();
        }
        super.initView();
        AppMethodBeat.o(113423);
    }

    @Override // com.tencent.mm.plugin.card.base.CardBaseUI
    public final void csj() {
        AppMethodBeat.i(113424);
        setMMTitle(R.string.aq7);
        addTextOptionMenu(0, getString(R.string.arj), new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.card.ui.CardHomePageUI.AnonymousClass2 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(113411);
                com.tencent.mm.plugin.card.d.b.a((MMActivity) CardHomePageUI.this, true);
                h.INSTANCE.a(11582, "CardListMsgMenu", 2, 0, "", "");
                AppMethodBeat.o(113411);
                return true;
            }
        });
        this.pXs = new b(this);
        this.pXs.init();
        if (this.qcb == null) {
            this.qcb = new i(this, getContentView());
            i iVar = this.qcb;
            iVar.qdd = View.inflate(iVar.pQZ, R.layout.o7, null);
            iVar.qdd.setVisibility(8);
            iVar.qde = (TextView) iVar.qdd.findViewById(R.id.anb);
            iVar.qdf = (ImageView) iVar.qdd.findViewById(R.id.an_);
            iVar.qdd.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.plugin.card.ui.i.AnonymousClass1 */

                public final void onClick(View view) {
                    AppMethodBeat.i(113515);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    a.b("com/tencent/mm/plugin/card/ui/CardMsgEntranceController$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    com.tencent.mm.plugin.card.d.b.a(i.this.pQZ, false);
                    am.ctU().ctE();
                    i.this.cwf();
                    h.INSTANCE.a(11324, "CardMsgCenterView", 0, "", "", 1, 0, "", 0, "");
                    a.a(this, "com/tencent/mm/plugin/card/ui/CardMsgEntranceController$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(113515);
                }
            });
            iVar.cwf();
            if (iVar.qdg == null) {
                iVar.qdg = ((ViewStub) iVar.jBN.findViewById(R.id.ao4)).inflate();
                iVar.qdg.setVisibility(8);
                iVar.qdh = (TextView) iVar.qdg.findViewById(R.id.anb);
                iVar.qdi = (ImageView) iVar.qdg.findViewById(R.id.an_);
                iVar.qdg.setOnClickListener(new View.OnClickListener() {
                    /* class com.tencent.mm.plugin.card.ui.i.AnonymousClass2 */

                    public final void onClick(View view) {
                        AppMethodBeat.i(113516);
                        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                        bVar.bm(view);
                        a.b("com/tencent/mm/plugin/card/ui/CardMsgEntranceController$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                        com.tencent.mm.plugin.card.d.b.a(i.this.pQZ, false);
                        am.ctU().ctE();
                        i.this.cwf();
                        h.INSTANCE.a(11324, "CardMsgCenterView", 0, "", "", 1, 0, "", 0, "");
                        a.a(this, "com/tencent/mm/plugin/card/ui/CardMsgEntranceController$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(113516);
                    }
                });
            }
            this.qcb.pXX = true;
        }
        if (this.qcc == null) {
            this.qcc = new f(this, findViewById(R.id.ao1), 1, this.pXs);
        }
        if (this.qcd == null) {
            this.qcd = new f(this, findViewById(R.id.apd), 3, this.pXs);
        }
        if (this.qcc != null) {
            this.qcc.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.plugin.card.ui.CardHomePageUI.AnonymousClass6 */

                public final void onClick(View view) {
                    AppMethodBeat.i(113415);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    a.b("com/tencent/mm/plugin/card/ui/CardHomePageUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    Intent intent = new Intent(CardHomePageUI.this, CardIndexUI.class);
                    intent.putExtra("key_card_type", 1);
                    CardHomePageUI cardHomePageUI = CardHomePageUI.this;
                    com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                    a.a(cardHomePageUI, bl.axQ(), "com/tencent/mm/plugin/card/ui/CardHomePageUI$6", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    cardHomePageUI.startActivity((Intent) bl.pG(0));
                    a.a(cardHomePageUI, "com/tencent/mm/plugin/card/ui/CardHomePageUI$6", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    h.INSTANCE.a(11324, "GotoMemberCardUI", 0, "", "", 0, 1, "", 0, 0);
                    a.a(this, "com/tencent/mm/plugin/card/ui/CardHomePageUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(113415);
                }
            });
        }
        if (this.qcd != null) {
            this.qcd.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.plugin.card.ui.CardHomePageUI.AnonymousClass7 */

                public final void onClick(View view) {
                    AppMethodBeat.i(113416);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    a.b("com/tencent/mm/plugin/card/ui/CardHomePageUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    Intent intent = new Intent(CardHomePageUI.this, CardIndexUI.class);
                    intent.putExtra("key_card_type", 3);
                    CardHomePageUI cardHomePageUI = CardHomePageUI.this;
                    com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                    a.a(cardHomePageUI, bl.axQ(), "com/tencent/mm/plugin/card/ui/CardHomePageUI$7", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    cardHomePageUI.startActivity((Intent) bl.pG(0));
                    a.a(cardHomePageUI, "com/tencent/mm/plugin/card/ui/CardHomePageUI$7", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    h.INSTANCE.a(11324, "ClickTicketCard", 0, "", "", 0, 0, "", 0, 0);
                    a.a(this, "com/tencent/mm/plugin/card/ui/CardHomePageUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(113416);
                }
            });
        }
        this.qch = (LinearLayout) findViewById(R.id.alj);
        vc cvZ = cvZ();
        if (cvZ != null) {
            a(cvZ);
        }
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.card.ui.CardHomePageUI.AnonymousClass3 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(113412);
                if (CardHomePageUI.this.fromScene == 1 || CardHomePageUI.this.fromScene == 2) {
                    CardHomePageUI.b(CardHomePageUI.this);
                } else {
                    CardHomePageUI.this.finish();
                }
                AppMethodBeat.o(113412);
                return true;
            }
        });
        AppMethodBeat.o(113424);
    }

    @Override // com.tencent.mm.plugin.card.base.CardBaseUI
    public final n.a csk() {
        return n.a.HOME_MEMBER_CARD_TYPE;
    }

    private void cuN() {
        AppMethodBeat.i(113425);
        Log.d("MicroMsg.CardHomePageUI", "initLocation");
        g.aAk().postToWorker(new Runnable() {
            /* class com.tencent.mm.plugin.card.ui.CardHomePageUI.AnonymousClass4 */

            public final void run() {
                AppMethodBeat.i(113413);
                CardHomePageUI.c(CardHomePageUI.this);
                CardHomePageUI.d(CardHomePageUI.this);
                CardHomePageUI.this.pXR = true;
                Log.d("MicroMsg.CardHomePageUI", "initLocation end");
                AppMethodBeat.o(113413);
            }
        });
        AppMethodBeat.o(113425);
    }

    @Override // com.tencent.mm.plugin.card.base.CardBaseUI
    public final void css() {
        AppMethodBeat.i(113426);
        Log.i("MicroMsg.CardHomePageUI", "onMPermissionGranted locationPermissionGranted " + this.qcf);
        if (!this.qcf) {
            this.qcf = true;
            cuN();
        }
        AppMethodBeat.o(113426);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v4.app.FragmentActivity
    public void onNewIntent(Intent intent) {
        AppMethodBeat.i(113427);
        super.onNewIntent(intent);
        setIntent(intent);
        cuW();
        this.pXF = true;
        this.qce = true;
        AppMethodBeat.o(113427);
    }

    private void updateView() {
        AppMethodBeat.i(113428);
        Log.i("MicroMsg.CardHomePageUI", "updateView()");
        this.qcb.cwf();
        cvY();
        this.qcd.updateView();
        AppMethodBeat.o(113428);
    }

    private void cvY() {
        AppMethodBeat.i(113429);
        Log.i("MicroMsg.CardHomePageUI", "updateMemberCardItem()");
        c cVar = (c) this.pQr;
        if (this.qcg == null) {
            this.qcg = (TextView) findViewById(R.id.fck);
            this.qcg.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.plugin.card.ui.CardHomePageUI.AnonymousClass5 */

                public final void onClick(View view) {
                    AppMethodBeat.i(113414);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    a.b("com/tencent/mm/plugin/card/ui/CardHomePageUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    Intent intent = new Intent(CardHomePageUI.this, CardIndexUI.class);
                    intent.putExtra("key_card_type", 1);
                    CardHomePageUI cardHomePageUI = CardHomePageUI.this;
                    com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                    a.a(cardHomePageUI, bl.axQ(), "com/tencent/mm/plugin/card/ui/CardHomePageUI$5", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    cardHomePageUI.startActivity((Intent) bl.pG(0));
                    a.a(cardHomePageUI, "com/tencent/mm/plugin/card/ui/CardHomePageUI$5", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    h.INSTANCE.a(11324, "GotoMemberCardUI", 0, "", "", 0, 0, "", 0, 0);
                    a.a(this, "com/tencent/mm/plugin/card/ui/CardHomePageUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(113414);
                }
            });
        }
        if (cVar.getCount() > 0) {
            this.qcg.setVisibility(0);
            this.qcg.setText(getString(R.string.at3, new Object[]{Integer.valueOf(b.cuv())}));
        } else {
            this.qcg.setVisibility(0);
            this.qcg.setText(getString(R.string.at3, new Object[]{Integer.valueOf(b.cuv())}));
            LinearLayout linearLayout = (LinearLayout) findViewById(R.id.amt);
            if (linearLayout != null) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) linearLayout.getLayoutParams();
                layoutParams.topMargin = com.tencent.mm.cb.a.fromDPToPix((Context) this, 29);
                layoutParams.bottomMargin = com.tencent.mm.cb.a.fromDPToPix((Context) this, 29);
                linearLayout.setLayoutParams(layoutParams);
            }
        }
        this.qcc.cvX();
        AppMethodBeat.o(113429);
    }

    @Override // com.tencent.mm.plugin.card.base.CardBaseUI
    public final void cst() {
        AppMethodBeat.i(113430);
        cvY();
        AppMethodBeat.o(113430);
    }

    @Override // com.tencent.mm.plugin.card.base.CardBaseUI
    public final void csq() {
        AppMethodBeat.i(113431);
        if (this.pXL) {
            Log.e("MicroMsg.CardHomePageUI", "onLocationFinish, has do GetShareCardLayout,don't get again");
            if (this.qcf) {
                csp();
            }
            AppMethodBeat.o(113431);
            return;
        }
        Log.d("MicroMsg.CardHomePageUI", "onLocationFinish()");
        this.pXL = true;
        cuT();
        csp();
        AppMethodBeat.o(113431);
    }

    @Override // com.tencent.mm.plugin.card.base.CardBaseUI
    public final void csr() {
        AppMethodBeat.i(113432);
        if (this.pXM || this.pXL) {
            csp();
            AppMethodBeat.o(113432);
            return;
        }
        this.pXM = true;
        Log.i("MicroMsg.CardHomePageUI", "onLocationFail()");
        cuT();
        AppMethodBeat.o(113432);
    }

    private void cuT() {
        AppMethodBeat.i(113433);
        Log.d("MicroMsg.CardHomePageUI", "doGetLayout() >> doNetSceneGetCardsHomePageLayout()");
        cuU();
        if (l.cxF()) {
            com.tencent.mm.plugin.card.b.b.cte();
        } else {
            Log.i("MicroMsg.CardHomePageUI", "the card entrance is not open, don't do doNetSceneGetCardsLayout!");
        }
        am.ctW().G("", "", 4);
        AppMethodBeat.o(113433);
    }

    private void cuU() {
        AppMethodBeat.i(113434);
        if (!this.qce) {
            Log.i("MicroMsg.CardHomePageUI", "doNetSceneGetCardsHomePageLayout, shouldGetHomePage is false");
            AppMethodBeat.o(113434);
        } else if (this.pXJ) {
            Log.e("MicroMsg.CardHomePageUI", "doNetSceneGetCardsHomePageLayout, isDoingGetData is true");
            AppMethodBeat.o(113434);
        } else {
            if (this.pXH && !Util.isNullOrNil(this.pXK)) {
                this.pXK = "";
            }
            this.pXJ = true;
            this.qce = false;
            g.aAg().hqi.a(new com.tencent.mm.plugin.card.sharecard.model.b((double) am.ctW().gmu, (double) am.ctW().gmv, this.pXK), 0);
            AppMethodBeat.o(113434);
        }
    }

    @Override // com.tencent.mm.plugin.card.base.CardBaseUI
    public final boolean csl() {
        AppMethodBeat.i(113435);
        boolean csl = super.csl();
        AppMethodBeat.o(113435);
        return csl;
    }

    @Override // com.tencent.mm.plugin.card.base.CardBaseUI
    public final boolean csm() {
        return true;
    }

    @Override // com.tencent.mm.plugin.card.base.CardBaseUI
    public final void b(com.tencent.mm.plugin.card.base.b bVar, int i2) {
        AppMethodBeat.i(113436);
        super.b(bVar, i2);
        AppMethodBeat.o(113436);
    }

    @Override // com.tencent.mm.plugin.card.base.CardBaseUI
    public final void a(com.tencent.mm.plugin.card.base.b bVar) {
        AppMethodBeat.i(113437);
        super.a(bVar);
        AppMethodBeat.o(113437);
    }

    @Override // com.tencent.mm.ak.i, com.tencent.mm.plugin.card.base.CardBaseUI
    public void onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(113438);
        super.onSceneEnd(i2, i3, str, qVar);
        if (i2 != 0 || i3 != 0) {
            if (qVar instanceof com.tencent.mm.plugin.card.sharecard.model.b) {
                this.pXJ = false;
            }
            Log.i("MicroMsg.CardHomePageUI", "share card list ui, onSceneEnd, errType = %d, errCode = %d", Integer.valueOf(i2), Integer.valueOf(i3));
        } else if (qVar instanceof ad) {
            cvY();
            this.pQx.onNotify();
            this.qcd.updateView();
            a(((ad) qVar).pUo);
            AppMethodBeat.o(113438);
            return;
        } else if (qVar instanceof com.tencent.mm.plugin.card.sharecard.model.b) {
            com.tencent.mm.plugin.card.sharecard.model.b bVar = (com.tencent.mm.plugin.card.sharecard.model.b) qVar;
            this.pXJ = false;
            this.pXK = bVar.pVT;
            this.pXs.aL(bVar.pTY, this.pXH);
            if (!b.cuB() || !b.cuC()) {
                this.pXH = false;
            }
            Log.i("MicroMsg.CardHomePageUI", "NetSceneGetShareCardsLayout() >> updateView()");
            updateView();
            AppMethodBeat.o(113438);
            return;
        }
        AppMethodBeat.o(113438);
    }

    private static vc cvZ() {
        AppMethodBeat.i(113439);
        String str = (String) g.aAh().azQ().get(ar.a.USERINFO_CARD_HOME_PAGE_LIST_STRING_SYNC, (Object) null);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(113439);
            return null;
        }
        vc vcVar = new vc();
        try {
            vcVar.parseFrom(str.getBytes(KindaConfigCacheStg.SAVE_CHARSET));
            AppMethodBeat.o(113439);
            return vcVar;
        } catch (IOException e2) {
            Log.printErrStackTrace("MicroMsg.CardHomePageUI", e2, "", new Object[0]);
            AppMethodBeat.o(113439);
            return null;
        }
    }

    private void a(vc vcVar) {
        AppMethodBeat.i(113440);
        this.qch.removeAllViews();
        if (!(vcVar == null || vcVar.Lfp == null || vcVar.Lfp.isEmpty())) {
            Iterator<up> it = vcVar.Lfp.iterator();
            while (it.hasNext()) {
                final up next = it.next();
                View inflate = LayoutInflater.from(getContext()).inflate(R.layout.n4, (ViewGroup) this.qch, false);
                new f(this, inflate, 4, this.pXs, next).setOnClickListener(new View.OnClickListener() {
                    /* class com.tencent.mm.plugin.card.ui.CardHomePageUI.AnonymousClass8 */

                    public final void onClick(View view) {
                        AppMethodBeat.i(113417);
                        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                        bVar.bm(view);
                        a.b("com/tencent/mm/plugin/card/ui/CardHomePageUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                        if (next.LdZ == 1) {
                            com.tencent.mm.plugin.card.d.b.a(CardHomePageUI.this, next.Lea, 0);
                        } else if (next.LdZ == 2) {
                            if (next.Leb != null) {
                                wq wqVar = new wq();
                                wqVar.ecI.userName = next.Leb.Hwr;
                                wqVar.ecI.ecK = Util.nullAs(next.Leb.Hws, "");
                                wqVar.ecI.scene = TXLiteAVCode.EVT_SW_ENCODER_START_SUCC;
                                EventCenter.instance.publish(wqVar);
                            }
                        } else if (next.LdZ != 3) {
                            Log.w("MicroMsg.CardHomePageUI", "unknown op action: %s", Integer.valueOf(next.LdZ));
                        } else if ("weixin://wccard/sharecarddetail".equals(next.Lec)) {
                            Log.d("MicroMsg.CardHomePageUI", "go to share card ui");
                            Intent intent = new Intent(CardHomePageUI.this, ShareCardListUI.class);
                            intent.putExtra("key_layout_buff", CardHomePageUI.this.pXK);
                            CardHomePageUI.this.qce = true;
                            CardHomePageUI cardHomePageUI = CardHomePageUI.this;
                            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                            a.a(cardHomePageUI, bl.axQ(), "com/tencent/mm/plugin/card/ui/CardHomePageUI$8", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                            cardHomePageUI.startActivity((Intent) bl.pG(0));
                            a.a(cardHomePageUI, "com/tencent/mm/plugin/card/ui/CardHomePageUI$8", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                            h.INSTANCE.a(11324, "ClickShareCard", 0, "", "", 0, 0, "", 0, 0);
                        }
                        a.a(this, "com/tencent/mm/plugin/card/ui/CardHomePageUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(113417);
                    }
                });
                this.qch.addView(inflate);
            }
        }
        AppMethodBeat.o(113440);
    }

    private void cuW() {
        AppMethodBeat.i(113441);
        int intExtra = getIntent().getIntExtra("key_from_scene", 22);
        boolean cO = c.axV().cO(262152, 266256);
        boolean cP = c.axV().cP(262152, 266256);
        boolean a2 = c.axV().a(ar.a.NEW_BANDAGE_DATASOURCE_NEW_CARD_REDDOT_WORDING_STRING_SYNC, ar.a.NEW_BANDAGE_WATCHER_SETTING_CARD_ENTRY_REDDOT_WORDING_STRING_SYNC);
        boolean a3 = c.axV().a(ar.a.NEW_BANDAGE_DATASOURCE_NEW_CARD_ICON_STRING_SYNC, ar.a.NEW_BANDAGE_WATCHER_SETTING_CARD_ENTRY_ICON_STRING_SYNC);
        String nullAsNil = Util.nullAsNil((String) g.aAh().azQ().get(ar.a.USERINFO_CARD_REDOT_WORDING_STRING_SYNC, (Object) null));
        if (cO) {
            h.INSTANCE.a(11324, "CardHomePageUI", 0, "", "", 2, Integer.valueOf(intExtra), "", 0, nullAsNil);
            AppMethodBeat.o(113441);
        } else if (cP) {
            h.INSTANCE.a(11324, "CardHomePageUI", 0, "", "", 1, Integer.valueOf(intExtra), "", 0, nullAsNil);
            AppMethodBeat.o(113441);
        } else if (a2 && !a3) {
            h.INSTANCE.a(11324, "CardHomePageUI", 0, "", "", 3, Integer.valueOf(intExtra), "", 0, nullAsNil);
            AppMethodBeat.o(113441);
        } else if (a2 && a3) {
            h.INSTANCE.a(11324, "CardHomePageUI", 0, "", "", 4, Integer.valueOf(intExtra), "", 0, nullAsNil);
            AppMethodBeat.o(113441);
        } else if (a3) {
            h.INSTANCE.a(11324, "CardHomePageUI", 0, "", "", 5, Integer.valueOf(intExtra), "", 0, nullAsNil);
            AppMethodBeat.o(113441);
        } else {
            h.INSTANCE.a(11324, "CardHomePageUI", 0, "", "", 0, Integer.valueOf(intExtra), "", 0, nullAsNil);
            AppMethodBeat.o(113441);
        }
    }

    @Override // com.tencent.mm.plugin.card.base.d
    public final void ctb() {
        this.pXF = true;
    }

    @Override // com.tencent.mm.sdk.storage.MStorage.IOnStorageChange
    public void onNotifyChange(String str, MStorageEventData mStorageEventData) {
        this.pXF = true;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity
    public boolean onKeyUp(int i2, KeyEvent keyEvent) {
        AppMethodBeat.i(113442);
        if (i2 == 4) {
            if (this.fromScene == 1 || this.fromScene == 2) {
                cwa();
            } else {
                finish();
            }
        }
        boolean onKeyUp = super.onKeyUp(i2, keyEvent);
        AppMethodBeat.o(113442);
        return onKeyUp;
    }

    private void cwa() {
        AppMethodBeat.i(113443);
        Intent intent = new Intent();
        intent.addFlags(67108864);
        intent.putExtra("preferred_tab", 3);
        com.tencent.mm.br.c.f(this, "com.tencent.mm.ui.LauncherUI", intent);
        finish();
        AppMethodBeat.o(113443);
    }

    static /* synthetic */ void c(CardHomePageUI cardHomePageUI) {
        AppMethodBeat.i(113445);
        cardHomePageUI.iOv = com.tencent.mm.modelgeo.d.bca();
        AppMethodBeat.o(113445);
    }
}

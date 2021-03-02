package com.tencent.mm.plugin.card.base;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelgeo.b;
import com.tencent.mm.modelgeo.d;
import com.tencent.mm.modelstat.o;
import com.tencent.mm.plugin.card.d.d;
import com.tencent.mm.plugin.card.model.CardInfo;
import com.tencent.mm.plugin.card.model.ad;
import com.tencent.mm.plugin.card.model.af;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.model.n;
import com.tencent.mm.plugin.card.model.r;
import com.tencent.mm.plugin.card.model.x;
import com.tencent.mm.plugin.card.sharecard.ui.h;
import com.tencent.mm.plugin.card.ui.CardDetailUI;
import com.tencent.mm.plugin.card.ui.c;
import com.tencent.mm.pluginsdk.ui.applet.ab;
import com.tencent.mm.pluginsdk.ui.applet.y;
import com.tencent.mm.protocal.protobuf.ty;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.q;
import java.util.ArrayList;
import java.util.LinkedList;

public abstract class CardBaseUI extends MMActivity implements i, MMActivity.a {
    private b.a gmA = new b.a() {
        /* class com.tencent.mm.plugin.card.base.CardBaseUI.AnonymousClass7 */

        @Override // com.tencent.mm.modelgeo.b.a
        public final boolean a(boolean z, float f2, float f3, int i2, double d2, double d3) {
            AppMethodBeat.i(112568);
            if (!z) {
                CardBaseUI.this.csr();
                AppMethodBeat.o(112568);
                return true;
            }
            if (!(f3 == -85.0f || f2 == -1000.0f)) {
                CardBaseUI.this.gmu = f3;
                CardBaseUI.this.gmv = f2;
                am.ctW().R(CardBaseUI.this.gmu, CardBaseUI.this.gmv);
                CardBaseUI.this.csq();
            }
            if (!CardBaseUI.this.iOy) {
                CardBaseUI.this.iOy = true;
                o.a(2010, f2, f3, (int) d3);
            }
            AppMethodBeat.o(112568);
            return false;
        }
    };
    private float gmu = -85.0f;
    private float gmv = -1000.0f;
    private q gxX = null;
    public d iOv;
    private boolean iOy = false;
    protected ListView pQq = null;
    public BaseAdapter pQr = null;
    protected RelativeLayout pQs = null;
    protected LinearLayout pQt;
    protected LinearLayout pQu;
    public boolean pQv = false;
    protected boolean pQw = true;
    public a pQx = null;
    protected CardInfo pQy;

    /* access modifiers changed from: protected */
    public abstract void csj();

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        super.onResume();
        this.pQw = true;
        g.aAg().hqi.a(1045, this);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onPause() {
        super.onPause();
        this.pQw = false;
        g.aAg().hqi.b(1045, this);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        a hVar;
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.card.base.CardBaseUI.AnonymousClass1 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(112562);
                CardBaseUI.this.finish();
                AppMethodBeat.o(112562);
                return true;
            }
        });
        this.pQq = (ListView) findViewById(16908298);
        this.pQs = (RelativeLayout) findViewById(R.id.bf4);
        if (this.pQs != null) {
            this.pQq.setEmptyView(this.pQs);
        }
        this.pQt = (LinearLayout) View.inflate(getBaseContext(), R.layout.o0, null);
        this.pQu = (LinearLayout) View.inflate(getBaseContext(), R.layout.nx, null);
        this.pQq.addHeaderView(this.pQt);
        this.pQq.addFooterView(this.pQu);
        this.pQr = anl();
        this.pQq.setAdapter((ListAdapter) this.pQr);
        this.pQq.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            /* class com.tencent.mm.plugin.card.base.CardBaseUI.AnonymousClass2 */

            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
                AppMethodBeat.i(112563);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(adapterView);
                bVar.bm(view);
                bVar.pH(i2);
                bVar.zo(j2);
                a.b("com/tencent/mm/plugin/card/base/CardBaseUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, bVar.axR());
                if (i2 == 0) {
                    Log.i("MicroMsg.CardBaseUI", "onItemClick pos is 0, onListHeaderItemClick()");
                    a.a(this, "com/tencent/mm/plugin/card/base/CardBaseUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                    AppMethodBeat.o(112563);
                    return;
                }
                if (i2 > 0) {
                    i2--;
                }
                if (i2 >= CardBaseUI.this.pQr.getCount()) {
                    a.a(this, "com/tencent/mm/plugin/card/base/CardBaseUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                    AppMethodBeat.o(112563);
                    return;
                }
                CardBaseUI.this.b(CardBaseUI.this.pQx.Ed(i2), i2);
                a.a(this, "com/tencent/mm/plugin/card/base/CardBaseUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                AppMethodBeat.o(112563);
            }
        });
        this.pQq.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            /* class com.tencent.mm.plugin.card.base.CardBaseUI.AnonymousClass3 */

            @Override // android.widget.AdapterView.OnItemLongClickListener
            public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i2, long j2) {
                AppMethodBeat.i(112564);
                if (i2 == 0) {
                    Log.i("MicroMsg.CardBaseUI", "onItemLongClick pos is 0");
                    AppMethodBeat.o(112564);
                } else {
                    if (i2 > 0) {
                        i2--;
                    }
                    if (i2 >= CardBaseUI.this.pQr.getCount()) {
                        AppMethodBeat.o(112564);
                    } else {
                        CardBaseUI.this.a(CardBaseUI.this.pQx.Ed(i2));
                        AppMethodBeat.o(112564);
                    }
                }
                return true;
            }
        });
        g.aAg().hqi.a(1077, this);
        g.aAg().hqi.a(1046, this);
        BaseAdapter baseAdapter = this.pQr;
        if (baseAdapter instanceof c) {
            hVar = new com.tencent.mm.plugin.card.ui.d((c) baseAdapter);
        } else if (baseAdapter instanceof com.tencent.mm.plugin.card.sharecard.ui.c) {
            hVar = new com.tencent.mm.plugin.card.sharecard.ui.d((com.tencent.mm.plugin.card.sharecard.ui.c) baseAdapter);
        } else if (baseAdapter instanceof com.tencent.mm.plugin.card.sharecard.ui.g) {
            hVar = new h((com.tencent.mm.plugin.card.sharecard.ui.g) baseAdapter);
        } else {
            hVar = new com.tencent.mm.plugin.card.ui.h((com.tencent.mm.plugin.card.ui.g) baseAdapter);
        }
        this.pQx = hVar;
        this.pQx.onCreate();
        csj();
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.nr;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        Log.d("MicroMsg.CardBaseUI", "destroy card");
        g.aAg().hqi.b(1077, this);
        g.aAg().hqi.b(1046, this);
        if (this.pQx != null) {
            this.pQx.onDestroy();
        }
        super.onDestroy();
    }

    /* access modifiers changed from: protected */
    public void a(b bVar, int i2) {
        Intent intent = new Intent(this, CardDetailUI.class);
        intent.putExtra("key_card_id", bVar.csU());
        intent.addFlags(131072);
        intent.putExtra("key_from_scene", 3);
        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
        a.a(this, bl.axQ(), "com/tencent/mm/plugin/card/base/CardBaseUI", "onGotoCardDetailUI", "(Lcom/tencent/mm/plugin/card/base/ICardInfo;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent) bl.pG(0));
        a.a(this, "com/tencent/mm/plugin/card/base/CardBaseUI", "onGotoCardDetailUI", "(Lcom/tencent/mm/plugin/card/base/ICardInfo;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        if (csk() == n.a.HOME_MEMBER_CARD_TYPE) {
            com.tencent.mm.plugin.report.service.h.INSTANCE.a(11324, "ClickMemberCard", 0, "", "", 0, 0, "", 0, 0);
            int intValue = ((Integer) g.aAh().azQ().get(ar.a.USERINFO_CARD_HOME_PAGE_CARD_NUM_INT_SYNC, (Object) 3)).intValue();
            com.tencent.mm.plugin.report.service.h.INSTANCE.a(15767, Integer.valueOf(intValue), Integer.valueOf(i2 + 1));
        } else if (csk() == n.a.MEMBER_CARD_TYPE) {
            com.tencent.mm.plugin.report.service.h.INSTANCE.a(11324, "ClickMemberCard", 0, "", "", 0, 1, "", 0, 0);
        }
    }

    /* access modifiers changed from: protected */
    public final void ku(boolean z) {
        if (z) {
            this.gxX = q.a(this, getString(R.string.a06), true, 0, null);
        } else if (this.gxX != null && this.gxX.isShowing()) {
            this.gxX.dismiss();
            this.gxX = null;
        }
    }

    public final void P(LinkedList<String> linkedList) {
        ku(true);
        g.aAg().hqi.a(new r(linkedList), 0);
    }

    @Override // com.tencent.mm.ak.i
    public void onSceneEnd(int i2, int i3, String str, com.tencent.mm.ak.q qVar) {
        if (i2 != 0 || i3 != 0) {
            ku(false);
            if (qVar instanceof af) {
                int i4 = ((af) qVar).pTZ;
                String str2 = ((af) qVar).pUa;
                if (i4 == 10000) {
                    if (TextUtils.isEmpty(str2)) {
                        str2 = getString(R.string.ap1);
                    }
                    str = str2;
                }
            }
            if (!(qVar instanceof x) && !(qVar instanceof ad) && !(qVar instanceof com.tencent.mm.plugin.card.sharecard.model.b) && this.pQw) {
                com.tencent.mm.plugin.card.d.d.b(this, str, i3);
            }
        } else if (qVar instanceof r) {
            ku(false);
            com.tencent.mm.ui.base.h.cD(this, getResources().getString(R.string.aod));
            am.ctP();
            com.tencent.mm.plugin.card.b.b.Ef(4);
            this.pQx.onNotify();
            cst();
        } else if (qVar instanceof af) {
            ku(false);
            int i5 = ((af) qVar).pTZ;
            String str3 = ((af) qVar).pUa;
            if (i5 == 10000) {
                if (TextUtils.isEmpty(str3)) {
                    str3 = getString(R.string.ap1);
                }
                com.tencent.mm.plugin.card.d.d.b(this, str3, i5);
                return;
            }
            if (this.pQy != null) {
                ty csR = this.pQy.csR();
                csR.status = 3;
                this.pQy.a(csR);
                if (!am.ctQ().update(this.pQy, new String[0])) {
                    Log.e("MicroMsg.CardBaseUI", "update newSerial fail, cardId = %s", this.pQy.field_card_id);
                }
            }
            this.pQx.onNotify();
            cst();
        }
    }

    /* access modifiers changed from: protected */
    public n.a csk() {
        return n.a.NORMAL_TYPE;
    }

    /* access modifiers changed from: protected */
    public BaseAdapter anl() {
        return new c(this, csk());
    }

    /* access modifiers changed from: protected */
    public boolean csl() {
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean csm() {
        return true;
    }

    /* access modifiers changed from: protected */
    public void b(b bVar, int i2) {
        if (!csl()) {
            Log.e("MicroMsg.CardBaseUI", "isItemClickable return false");
        } else if (bVar == null) {
            Log.e("MicroMsg.CardBaseUI", "onListItemClick  item == null");
        } else if (!bVar.csU().equals("PRIVATE_TICKET_TITLE") && !bVar.csU().equals("PRIVATE_INVOICE_TITLE")) {
            if (bVar.csC()) {
                a(bVar, i2);
            } else if (!TextUtils.isEmpty(bVar.csQ().LeG)) {
                com.tencent.mm.plugin.card.d.b.a(this, bVar.csQ().LeG, 0);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void a(final b bVar) {
        if (!csm()) {
            Log.e("MicroMsg.CardBaseUI", "isItemClickable return false");
        } else if (bVar == null) {
            Log.e("MicroMsg.CardBaseUI", "onListItemLongClick  item == null");
        } else {
            ArrayList arrayList = new ArrayList();
            if (bVar.csD()) {
                if (!Util.isNullOrNil(bVar.csQ().Lfl)) {
                    arrayList.add(bVar.csQ().Lfl);
                } else if (bVar.csB()) {
                    arrayList.add(getResources().getString(R.string.arf));
                } else {
                    arrayList.add(getResources().getString(R.string.are));
                }
            }
            arrayList.add(getResources().getString(R.string.tf));
            final String csU = bVar.csU();
            com.tencent.mm.ui.base.h.a(this, bVar.csQ().pTn, (String[]) arrayList.toArray(new String[arrayList.size()]), (String) null, new h.d() {
                /* class com.tencent.mm.plugin.card.base.CardBaseUI.AnonymousClass5 */

                @Override // com.tencent.mm.ui.base.h.d
                public final void oj(int i2) {
                    AppMethodBeat.i(112566);
                    if (bVar.csD()) {
                        switch (i2) {
                            case 0:
                                CardBaseUI.this.a((CardInfo) bVar);
                                AppMethodBeat.o(112566);
                                return;
                            case 1:
                                CardBaseUI.b(CardBaseUI.this, csU);
                                AppMethodBeat.o(112566);
                                return;
                            default:
                                AppMethodBeat.o(112566);
                                return;
                        }
                    } else {
                        switch (i2) {
                            case 0:
                                CardBaseUI.b(CardBaseUI.this, csU);
                                break;
                        }
                        AppMethodBeat.o(112566);
                    }
                }
            });
        }
    }

    @Override // com.tencent.mm.ui.MMActivity.a
    public final void d(int i2, int i3, Intent intent) {
        if (i2 == 0 && i3 == -1) {
            l(intent.getStringExtra("Select_Conv_User"), 0, false);
        }
    }

    /* access modifiers changed from: protected */
    public void a(CardInfo cardInfo) {
        this.pQy = cardInfo;
        com.tencent.mm.plugin.card.d.b.a(this, 0, this);
    }

    /* access modifiers changed from: protected */
    public final void l(final String str, int i2, final boolean z) {
        if (this.pQy == null) {
            Log.e("MicroMsg.CardBaseUI", "showGiftConfirmDialog mCardInfo == null");
        } else if (this.pQy.csQ() == null) {
            Log.e("MicroMsg.CardBaseUI", "showGiftConfirmDialog mCardInfo.getCardTpInfo() == null");
        } else {
            StringBuilder sb = new StringBuilder();
            if (i2 == 0) {
                if (TextUtils.isEmpty(this.pQy.csS().MXq) || this.pQy.csB()) {
                    sb.append(getString(R.string.h9u));
                } else {
                    sb.append(this.pQy.csS().MXq);
                }
                com.tencent.mm.plugin.report.service.h.INSTANCE.a(11582, "OperGift", 2, Integer.valueOf(this.pQy.csQ().nHh), this.pQy.field_card_tp_id, this.pQy.field_card_id, str);
            } else if (i2 == 1) {
                sb.append(getString(R.string.ap0, new Object[]{this.pQy.csQ().pTn}));
                com.tencent.mm.plugin.report.service.h.INSTANCE.a(11582, "OperGift", 3, Integer.valueOf(this.pQy.csQ().nHh), this.pQy.field_card_tp_id, this.pQy.field_card_id, str);
            }
            ab.a.Kgn.a(getController(), sb.toString(), this.pQy.csQ().iwv, this.pQy.csQ().title + "\n" + this.pQy.csQ().gTG, false, getResources().getString(R.string.yq), new y.a() {
                /* class com.tencent.mm.plugin.card.base.CardBaseUI.AnonymousClass6 */

                @Override // com.tencent.mm.pluginsdk.ui.applet.y.a
                public final void a(boolean z, String str, int i2) {
                    AppMethodBeat.i(112567);
                    if (z) {
                        CardBaseUI.c(CardBaseUI.this, str);
                        com.tencent.mm.ui.base.h.cD(CardBaseUI.this, CardBaseUI.this.getResources().getString(R.string.apl));
                        if (z) {
                            CardBaseUI.this.finish();
                        }
                    }
                    AppMethodBeat.o(112567);
                }
            });
        }
    }

    public final void csn() {
        if (this.iOv == null) {
            this.iOv = d.bca();
        }
        if (this.iOv != null) {
            this.iOv.a(this.gmA, true);
        }
    }

    /* access modifiers changed from: protected */
    public final void cso() {
        if (this.iOv != null) {
            this.iOv.a(this.gmA, true);
        }
    }

    /* access modifiers changed from: protected */
    public final void csp() {
        if (this.iOv != null) {
            this.iOv.c(this.gmA);
        }
    }

    /* access modifiers changed from: protected */
    public void csq() {
    }

    /* access modifiers changed from: protected */
    public void csr() {
    }

    /* access modifiers changed from: protected */
    public void css() {
    }

    /* access modifiers changed from: protected */
    public void cst() {
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.a.AbstractC0015a
    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        if (iArr == null || iArr.length <= 0) {
            Log.i("MicroMsg.CardBaseUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", Integer.valueOf(i2), Long.valueOf(Thread.currentThread().getId()));
            return;
        }
        Log.i("MicroMsg.CardBaseUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", Integer.valueOf(i2), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId()));
        switch (i2) {
            case 69:
                if (iArr == null || iArr.length <= 0 || iArr[0] != 0) {
                    com.tencent.mm.ui.base.h.a((Context) this, getString(R.string.fl_), getString(R.string.flp), getString(R.string.e_k), getString(R.string.b96), false, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.plugin.card.base.CardBaseUI.AnonymousClass8 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            AppMethodBeat.i(112569);
                            CardBaseUI cardBaseUI = CardBaseUI.this;
                            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                            a.a(cardBaseUI, bl.axQ(), "com/tencent/mm/plugin/card/base/CardBaseUI$8", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                            cardBaseUI.startActivity((Intent) bl.pG(0));
                            a.a(cardBaseUI, "com/tencent/mm/plugin/card/base/CardBaseUI$8", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                            AppMethodBeat.o(112569);
                        }
                    }, (DialogInterface.OnClickListener) null);
                    return;
                } else {
                    css();
                    return;
                }
            default:
                return;
        }
    }

    static /* synthetic */ void a(CardBaseUI cardBaseUI, String str) {
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add(str);
        cardBaseUI.pQv = false;
        cardBaseUI.P(linkedList);
    }

    static /* synthetic */ void b(CardBaseUI cardBaseUI, final String str) {
        com.tencent.mm.plugin.card.d.d.a(cardBaseUI, str, "", new d.a() {
            /* class com.tencent.mm.plugin.card.base.CardBaseUI.AnonymousClass4 */

            @Override // com.tencent.mm.plugin.card.d.d.a, com.tencent.mm.plugin.card.d.d.b
            public final void csu() {
                AppMethodBeat.i(112565);
                CardBaseUI.a(CardBaseUI.this, str);
                AppMethodBeat.o(112565);
            }
        });
    }

    static /* synthetic */ void c(CardBaseUI cardBaseUI, String str) {
        cardBaseUI.ku(true);
        g.aAg().hqi.a(new af(cardBaseUI.pQy.field_card_id, str, 17), 0);
    }
}

package com.tencent.mm.plugin.card.ui;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.q;
import com.tencent.mm.hellhoundlib.b.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.card.base.CardBaseUI;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.d.d;
import com.tencent.mm.plugin.card.d.k;
import com.tencent.mm.plugin.card.model.CardInfo;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.model.n;
import com.tencent.mm.plugin.card.model.t;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.eck;
import com.tencent.mm.protocal.protobuf.va;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;

public class CardViewUI extends CardBaseUI {
    private int azh = 1;
    private int gwE;
    private String ixM = "";
    private String mAppId = "";
    private LinkedList<va> pYH = new LinkedList<>();
    private int qaa;
    private String qer;
    private View qes;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.plugin.card.base.CardBaseUI, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public CardViewUI() {
        AppMethodBeat.i(113598);
        AppMethodBeat.o(113598);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.plugin.card.base.CardBaseUI, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(113599);
        super.onCreate(bundle);
        Intent intent = getIntent();
        if (intent == null) {
            Log.e("MicroMsg.CardViewUI", "onCreate intent is null");
            finish();
            AppMethodBeat.o(113599);
            return;
        }
        this.gwE = intent.getIntExtra("key_previous_scene", 7);
        this.qaa = intent.getIntExtra("key_from_appbrand_type", 0);
        this.azh = intent.getIntExtra("view_type", 0);
        this.qer = intent.getStringExtra("user_name");
        this.mAppId = intent.getStringExtra("key_app_id");
        String stringExtra = intent.getStringExtra("card_list");
        this.ixM = getIntent().getStringExtra("key_template_id");
        if (this.azh == 0) {
            if (TextUtils.isEmpty(stringExtra)) {
                Log.e("MicroMsg.CardViewUI", "oncreate card_list is empty");
                finish();
                AppMethodBeat.o(113599);
                return;
            }
            LinkedList<va> G = k.G(stringExtra, this.gwE, this.mAppId);
            if (G != null && G.size() > 0) {
                this.pYH.clear();
                this.pYH.addAll(G);
            }
        }
        initView();
        AppMethodBeat.o(113599);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.plugin.card.base.CardBaseUI, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(113600);
        g.aAg().hqi.b(1099, this);
        super.onDestroy();
        AppMethodBeat.o(113600);
    }

    @Override // com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.ui.widget.SwipeBackLayout.a
    public void onSwipeBack() {
        AppMethodBeat.i(113601);
        super.onSwipeBack();
        if (this.gwE == 26) {
            overridePendingTransition(0, 0);
        }
        AppMethodBeat.o(113601);
    }

    @Override // com.tencent.mm.plugin.card.base.CardBaseUI
    public final void csj() {
        int i2;
        AppMethodBeat.i(113602);
        if (this.azh == 0) {
            setMMTitle(R.string.atu);
        } else if (this.azh == 1) {
            setMMTitle(R.string.apj);
        }
        g.aAg().hqi.a(1099, this);
        if (this.azh == 0) {
            ku(true);
            eck eck = new eck();
            eck.NcB = this.ixM;
            Log.i("MicroMsg.CardViewUI", "doBatchGetCardItemByTpInfo templateId:%s", this.ixM);
            g.aAg().hqi.a(new t(this.pYH, eck, this.gwE), 0);
            i2 = R.string.an9;
        } else if (this.azh == 1) {
            this.qes = View.inflate(this, R.layout.nz, null);
            if (this.pQt != null) {
                this.pQt.addView(this.qes);
            }
            i2 = R.string.at5;
        } else {
            i2 = R.string.an9;
        }
        findViewById(R.id.fzj).setVisibility(8);
        ((TextView) findViewById(R.id.fzl)).setText(i2);
        AppMethodBeat.o(113602);
    }

    @Override // com.tencent.mm.plugin.card.base.CardBaseUI
    public final n.a csk() {
        return n.a.CAN_GIFT_TYPE;
    }

    @Override // com.tencent.mm.plugin.card.base.CardBaseUI
    public final BaseAdapter anl() {
        AppMethodBeat.i(113603);
        if (this.azh == 0) {
            g gVar = new g(getApplicationContext());
            AppMethodBeat.o(113603);
            return gVar;
        }
        BaseAdapter anl = super.anl();
        AppMethodBeat.o(113603);
        return anl;
    }

    @Override // com.tencent.mm.plugin.card.base.CardBaseUI
    public final boolean csm() {
        AppMethodBeat.i(113604);
        if (this.azh == 1) {
            AppMethodBeat.o(113604);
            return false;
        }
        boolean csm = super.csm();
        AppMethodBeat.o(113604);
        return csm;
    }

    @Override // com.tencent.mm.plugin.card.base.CardBaseUI
    public final void b(b bVar, int i2) {
        AppMethodBeat.i(113605);
        if (this.azh == 1) {
            a((CardInfo) bVar);
            AppMethodBeat.o(113605);
            return;
        }
        super.b(bVar, i2);
        AppMethodBeat.o(113605);
    }

    @Override // com.tencent.mm.plugin.card.base.CardBaseUI
    public final void a(CardInfo cardInfo) {
        AppMethodBeat.i(113606);
        if (this.azh == 1) {
            this.pQy = cardInfo;
            l(this.qer, 1, true);
            AppMethodBeat.o(113606);
            return;
        }
        super.a(cardInfo);
        if (this.pQy != null) {
            h.INSTANCE.a(11582, "OperGift", 4, Integer.valueOf(this.pQy.csQ().nHh), this.pQy.field_card_tp_id, this.pQy.field_card_id, this.qer);
        }
        AppMethodBeat.o(113606);
    }

    @Override // com.tencent.mm.plugin.card.base.CardBaseUI
    public final void a(b bVar, int i2) {
        AppMethodBeat.i(113607);
        if (this.azh == 0) {
            am.ctV().pQy = (CardInfo) bVar;
            Intent intent = new Intent(this, CardDetailUI.class);
            intent.putExtra("key_card_id", ((CardInfo) bVar).field_card_id);
            intent.putExtra("key_from_scene", 51);
            intent.putExtra("key_from_appbrand_type", this.qaa);
            a bl = new a().bl(intent);
            com.tencent.mm.hellhoundlib.a.a.a(this, bl.axQ(), "com/tencent/mm/plugin/card/ui/CardViewUI", "onGotoCardDetailUI", "(Lcom/tencent/mm/plugin/card/base/ICardInfo;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            startActivity((Intent) bl.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/CardViewUI", "onGotoCardDetailUI", "(Lcom/tencent/mm/plugin/card/base/ICardInfo;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            AppMethodBeat.o(113607);
            return;
        }
        super.a(bVar, i2);
        AppMethodBeat.o(113607);
    }

    @Override // com.tencent.mm.ak.i, com.tencent.mm.plugin.card.base.CardBaseUI
    public void onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(113608);
        if (qVar instanceof t) {
            ku(false);
            if (i2 == 0 && i3 == 0) {
                LinkedList<CardInfo> linkedList = ((t) qVar).pUe;
                if (linkedList != null && linkedList.size() > 0) {
                    if (this.pQr instanceof g) {
                        g gVar = (g) this.pQr;
                        if (linkedList != null) {
                            gVar.pXz.clear();
                            gVar.pXz.addAll(linkedList);
                            gVar.qcw.clear();
                            for (int i4 = 0; i4 < linkedList.size(); i4++) {
                                gVar.qcw.add(Boolean.TRUE);
                            }
                        }
                    }
                    this.pQr.notifyDataSetChanged();
                }
                AppMethodBeat.o(113608);
                return;
            }
            d.b(this, str, i3);
            AppMethodBeat.o(113608);
            return;
        }
        super.onSceneEnd(i2, i3, str, qVar);
        AppMethodBeat.o(113608);
    }
}

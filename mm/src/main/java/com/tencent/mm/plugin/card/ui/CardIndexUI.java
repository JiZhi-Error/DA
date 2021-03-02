package com.tencent.mm.plugin.card.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.kinda.framework.app.KindaConfigCacheStg;
import com.tencent.liteav.TXLiteAVCode;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.wq;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.card.b.b;
import com.tencent.mm.plugin.card.base.CardBaseUI;
import com.tencent.mm.plugin.card.d.i;
import com.tencent.mm.plugin.card.model.ad;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.model.f;
import com.tencent.mm.plugin.card.model.n;
import com.tencent.mm.plugin.card.model.x;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.protocal.protobuf.dtb;
import com.tencent.mm.protocal.protobuf.dtc;
import com.tencent.mm.protocal.protobuf.ur;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import com.tencent.mm.y.c;
import java.io.IOException;
import java.util.List;

public class CardIndexUI extends CardBaseUI {
    private final String TAG = "MicroMsg.CardIndexUI";
    int fromScene = 0;
    private long mStartTime = 0;
    private View qck;
    private TextView qcl;
    private f qcm;
    private TextView qcn;
    private TextView qco;
    private ImageView qcp;
    private LinearLayout qcq;
    int qcr = -1;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.plugin.card.base.CardBaseUI, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.plugin.card.base.CardBaseUI, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(113450);
        super.onCreate(bundle);
        Log.i("MicroMsg.CardIndexUI", "oncreate");
        this.mStartTime = System.currentTimeMillis();
        initView();
        g.aAg().hqi.a(1054, this);
        am.ctP();
        b.Ef(1);
        int i2 = am.ctU().pRQ;
        if (c.axV().cO(262152, 266256) || i2 > 0) {
            h.INSTANCE.a(11324, "CardPackageListView", 0, "", "", 1, Integer.valueOf(this.fromScene), "", 0, "");
            AppMethodBeat.o(113450);
            return;
        }
        h.INSTANCE.a(11324, "CardPackageListView", 0, "", "", 0, Integer.valueOf(this.fromScene), "", 0, "");
        AppMethodBeat.o(113450);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.plugin.card.base.CardBaseUI, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(113451);
        g.aAg().hqi.b(1054, this);
        long currentTimeMillis = System.currentTimeMillis() - this.mStartTime;
        h.INSTANCE.a(13219, "CardPackageListView", Integer.valueOf(this.fromScene), "", "", Long.valueOf(currentTimeMillis));
        super.onDestroy();
        AppMethodBeat.o(113451);
    }

    @Override // com.tencent.mm.ui.MMActivity, com.tencent.mm.plugin.card.base.CardBaseUI
    public void initView() {
        AppMethodBeat.i(113452);
        if (getIntent() != null) {
            this.qcr = getIntent().getIntExtra("key_card_type", -1);
        }
        super.initView();
        AppMethodBeat.o(113452);
    }

    @Override // com.tencent.mm.plugin.card.base.CardBaseUI
    public final void csj() {
        AppMethodBeat.i(113453);
        if (1 == this.qcr) {
            setMMTitle(R.string.ar8);
        } else if (3 == this.qcr) {
            setMMTitle(R.string.atp);
        } else {
            setMMTitle(R.string.arh);
        }
        this.qcn = (TextView) findViewById(R.id.fzl);
        this.qco = (TextView) findViewById(R.id.fzm);
        this.qcp = (ImageView) findViewById(R.id.fzj);
        this.qck = findViewById(R.id.am9);
        this.qcl = (TextView) findViewById(R.id.am_);
        this.qcq = (LinearLayout) findViewById(R.id.fzk);
        this.qck.setVisibility(8);
        this.qco.setVisibility(0);
        this.qcn.setVisibility(0);
        this.qcp.setVisibility(8);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.qcq.getLayoutParams();
        layoutParams.topMargin = BackwardSupportUtil.BitmapFactory.fromDPToPix(this, 100.0f);
        this.qcq.setLayoutParams(layoutParams);
        if (1 == this.qcr) {
            this.qco.setText(getString(R.string.aqw));
            this.qcn.setText(getString(R.string.aqv));
        } else if (3 == this.qcr) {
            this.qco.setText(getString(R.string.ar2));
            this.qcn.setText(getString(R.string.ar1));
        } else {
            this.qco.setText(getString(R.string.as2));
            this.qcn.setText(getString(R.string.asg));
        }
        if (this.qcr == 3) {
            this.pQq.setEmptyView(null);
            this.pQs.setVisibility(8);
        }
        this.qcl.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.card.ui.CardIndexUI.AnonymousClass1 */

            public final void onClick(View view) {
                AppMethodBeat.i(113448);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/card/ui/CardIndexUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (!TextUtils.isEmpty(CardIndexUI.this.qcm.pTs)) {
                    com.tencent.mm.plugin.card.d.b.a(CardIndexUI.this, CardIndexUI.this.qcm.pTs, 0);
                }
                a.a(this, "com/tencent/mm/plugin/card/ui/CardIndexUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(113448);
            }
        });
        if (this.qcr == 3 && ((Boolean) g.aAh().azQ().get(ar.a.USERINFO_CARD_HOME_PAGE_HAS_LOAD_NEW_ENTRANCE_BOOLEAN_SYNC, Boolean.FALSE)).booleanValue()) {
            Log.i("MicroMsg.CardIndexUI", "has load new entrance");
            String str = (String) g.aAh().azQ().get(ar.a.USERINFO_CARD_HOME_PAGE_SECOND_ENTRANCE_STRING_SYNC, (Object) null);
            if (!Util.isNullOrNil(str)) {
                try {
                    dtc dtc = new dtc();
                    dtc.parseFrom(str.getBytes(KindaConfigCacheStg.SAVE_CHARSET));
                    cT(dtc.MVi);
                    AppMethodBeat.o(113453);
                    return;
                } catch (IOException e2) {
                    Log.printErrStackTrace("MicroMsg.CardIndexUI", e2, "", new Object[0]);
                }
            }
        }
        AppMethodBeat.o(113453);
    }

    private void cwb() {
        AppMethodBeat.i(113454);
        if (this.pQt.getChildCount() == 0 && this.pQr.getCount() == 0) {
            Log.i("MicroMsg.CardIndexUI", "show empty view");
            this.pQs.setVisibility(0);
            this.pQq.setVisibility(8);
            AppMethodBeat.o(113454);
            return;
        }
        Log.i("MicroMsg.CardIndexUI", "hide empty view");
        this.pQs.setVisibility(8);
        this.pQq.setVisibility(0);
        AppMethodBeat.o(113454);
    }

    private void cT(List<dtb> list) {
        AppMethodBeat.i(113455);
        if (list != null && !list.isEmpty()) {
            for (dtb dtb : list) {
                if (dtb.LdV == 1) {
                    Log.i("MicroMsg.CardIndexUI", "should update new invoice");
                    cU(dtb.MVh);
                }
            }
        }
        cwb();
        AppMethodBeat.o(113455);
    }

    private void cU(List<ur> list) {
        AppMethodBeat.i(113456);
        this.pQt.removeAllViews();
        this.pQt.setPadding(0, 0, 0, 0);
        if (list != null && !list.isEmpty()) {
            int i2 = 0;
            for (final ur urVar : list) {
                View inflate = View.inflate(getContext(), R.layout.nv, null);
                ((CdnImageView) inflate.findViewById(R.id.b3x)).setUrl(urVar.Lei);
                ((TextView) inflate.findViewById(R.id.b3y)).setText(urVar.Leh);
                ((TextView) inflate.findViewById(R.id.b3w)).setText(urVar.Lej);
                if (urVar.Lek > 0) {
                    inflate.setOnClickListener(new View.OnClickListener() {
                        /* class com.tencent.mm.plugin.card.ui.CardIndexUI.AnonymousClass2 */

                        public final void onClick(View view) {
                            AppMethodBeat.i(113449);
                            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                            bVar.bm(view);
                            a.b("com/tencent/mm/plugin/card/ui/CardIndexUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                            Log.i("MicroMsg.CardIndexUI", "click header view: %s", Integer.valueOf(urVar.Lek));
                            if (urVar.Lek == 1) {
                                com.tencent.mm.plugin.card.d.b.a(CardIndexUI.this, urVar.Lel, 0);
                            } else if (urVar.Lek == 2) {
                                wq wqVar = new wq();
                                wqVar.ecI.userName = urVar.Lem.Hwr;
                                wqVar.ecI.ecK = Util.nullAs(urVar.Lem.Hws, "");
                                wqVar.ecI.scene = TXLiteAVCode.EVT_SW_ENCODER_START_SUCC;
                                EventCenter.instance.publish(wqVar);
                            }
                            a.a(this, "com/tencent/mm/plugin/card/ui/CardIndexUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                            AppMethodBeat.o(113449);
                        }
                    });
                }
                this.pQt.addView(inflate);
                if (i2 == 0) {
                    this.pQt.setPadding(0, com.tencent.mm.cb.a.fromDPToPix((Context) this, 13), 0, 0);
                } else {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) inflate.getLayoutParams();
                    if (layoutParams != null) {
                        layoutParams.topMargin = com.tencent.mm.cb.a.fromDPToPix((Context) this, 6);
                        inflate.setLayoutParams(layoutParams);
                    }
                }
                i2++;
            }
        }
        AppMethodBeat.o(113456);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.plugin.card.base.CardBaseUI, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        AppMethodBeat.i(113457);
        super.onResume();
        AppMethodBeat.o(113457);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onStop() {
        AppMethodBeat.i(113458);
        super.onStop();
        AppMethodBeat.o(113458);
    }

    @Override // com.tencent.mm.plugin.card.base.CardBaseUI
    public final n.a csk() {
        AppMethodBeat.i(113459);
        if (1 == this.qcr) {
            n.a aVar = n.a.MEMBER_CARD_TYPE;
            AppMethodBeat.o(113459);
            return aVar;
        } else if (3 != this.qcr) {
            n.a aVar2 = n.a.NORMAL_TYPE;
            AppMethodBeat.o(113459);
            return aVar2;
        } else if (((Boolean) g.aAh().azQ().get(ar.a.USERINFO_CARD_HOME_PAGE_HAS_LOAD_NEW_ENTRANCE_BOOLEAN_SYNC, Boolean.FALSE)).booleanValue()) {
            n.a aVar3 = n.a.GENERAL_WITHOUT_INVOICE_TYPE;
            AppMethodBeat.o(113459);
            return aVar3;
        } else {
            n.a aVar4 = n.a.GENERAL_TYPE;
            AppMethodBeat.o(113459);
            return aVar4;
        }
    }

    @Override // com.tencent.mm.plugin.card.base.CardBaseUI
    public final BaseAdapter anl() {
        AppMethodBeat.i(113460);
        if (3 == this.qcr) {
            k kVar = new k(this, csk());
            AppMethodBeat.o(113460);
            return kVar;
        }
        c cVar = new c(this, csk());
        AppMethodBeat.o(113460);
        return cVar;
    }

    @Override // com.tencent.mm.ak.i, com.tencent.mm.plugin.card.base.CardBaseUI
    public void onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(113461);
        super.onSceneEnd(i2, i3, str, qVar);
        if (i2 == 0 && i3 == 0) {
            if (qVar instanceof x) {
                this.qcm = i.akc((String) g.aAh().azQ().get(282885, ""));
                if (this.qcm == null) {
                    this.qcm = new f();
                }
                if (this.qcm != null && !TextUtils.isEmpty(this.qcm.pTq)) {
                    this.qcn.setText(this.qcm.pTq);
                }
                if (this.qcm == null || !this.qcm.pTt) {
                    this.qck.setVisibility(8);
                    AppMethodBeat.o(113461);
                    return;
                }
                this.qcl.setText(this.qcm.pTr);
                if (TextUtils.isEmpty(this.qcm.pTr) || TextUtils.isEmpty(this.qcm.pTs)) {
                    this.qck.setVisibility(8);
                    AppMethodBeat.o(113461);
                    return;
                }
                this.qck.setVisibility(0);
                AppMethodBeat.o(113461);
                return;
            } else if (qVar instanceof ad) {
                ad adVar = (ad) qVar;
                if (adVar.pUn && (this.pQr instanceof c)) {
                    ((c) this.pQr).Bh(false);
                    ((c) this.pQr).Bh(true);
                    ((c) this.pQr).anp();
                }
                if (((Boolean) g.aAh().azQ().get(ar.a.USERINFO_CARD_HOME_PAGE_HAS_LOAD_NEW_ENTRANCE_BOOLEAN_SYNC, Boolean.FALSE)).booleanValue() && adVar.pUp != null) {
                    cT(adVar.pUp.MVi);
                    if (this.pQr instanceof c) {
                        ((c) this.pQr).Bh(false);
                        ((c) this.pQr).Bh(true);
                        ((c) this.pQr).anp();
                    }
                }
            }
        }
        AppMethodBeat.o(113461);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(113462);
        super.onActivityResult(i2, i3, intent);
        AppMethodBeat.o(113462);
    }
}

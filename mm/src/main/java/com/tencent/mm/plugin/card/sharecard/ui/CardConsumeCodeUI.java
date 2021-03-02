package com.tencent.mm.plugin.card.sharecard.ui;

import android.content.Context;
import android.content.Intent;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Vibrator;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.b.a;
import com.tencent.mm.plugin.card.b.c;
import com.tencent.mm.plugin.card.b.d;
import com.tencent.mm.plugin.card.b.j;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.plugin.card.d.n;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.sharecard.ui.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.abz;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;

public class CardConsumeCodeUI extends MMActivity implements View.OnClickListener, c.a, d.a {
    private final String TAG = "MicroMsg.CardConsumeCodeUI";
    private int gwE = 3;
    private b pQV;
    private String pWF;
    private int pWG = 3;
    private int pWH = 0;
    private a pWI;
    private TextView pWJ;
    private TextView pWK;
    private LinearLayout pWL;
    private ImageView pWM;
    private View pWN;
    private LinearLayout pWO;
    private View pWP;
    private TextView pWQ;
    private TextView pWR;
    private TextView pWS;
    private boolean pWT = false;
    private Vibrator paT;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.mg;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(113037);
        super.onCreate(bundle);
        Log.i("MicroMsg.CardConsumeCodeUI", "onCreate()");
        setResult(0);
        this.pQV = (b) getIntent().getParcelableExtra("key_card_info_data");
        this.gwE = getIntent().getIntExtra("key_from_scene", 3);
        this.pWG = getIntent().getIntExtra("key_previous_scene", 3);
        this.pWF = getIntent().getStringExtra("key_mark_user");
        this.pWH = getIntent().getIntExtra("key_from_appbrand_type", 0);
        if (this.pQV == null || this.pQV.csQ() == null || this.pQV.csR() == null) {
            Log.e("MicroMsg.CardConsumeCodeUI", "mCardInfo == null or mCardInfo.getCardTpInfo() == null or mCardInfo.getDataInfo() == null");
            finish();
            AppMethodBeat.o(113037);
            return;
        }
        initView();
        am.ctW().G("", "", 3);
        AppMethodBeat.o(113037);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        AppMethodBeat.i(113039);
        this.pWI.cuE();
        am.cub().a(this, true);
        super.onResume();
        AppMethodBeat.o(113039);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onPause() {
        AppMethodBeat.i(113040);
        am.cub().a(this, false);
        super.onPause();
        AppMethodBeat.o(113040);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(113041);
        a aVar = this.pWI;
        aVar.bc(aVar.pWC);
        l.Z(aVar.kuJ);
        l.Z(aVar.pWu);
        aVar.pWB = null;
        aVar.pQZ = null;
        am.cub().c(this);
        am.cub().b(this);
        if (this.pQV.csK()) {
            am.cud().b(this);
            am.cud().ctj();
        }
        this.paT.cancel();
        super.onDestroy();
        AppMethodBeat.o(113041);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, android.support.v7.app.AppCompatActivity
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        AppMethodBeat.i(113042);
        if (i2 == 4) {
            Log.e("MicroMsg.CardConsumeCodeUI", "onKeyDown finishUI");
            setResult(-1);
            finish();
        }
        boolean onKeyDown = super.onKeyDown(i2, keyEvent);
        AppMethodBeat.o(113042);
        return onKeyDown;
    }

    @Override // com.tencent.mm.plugin.card.b.d.a
    public final void d(b bVar) {
        AppMethodBeat.i(113043);
        Log.i("MicroMsg.CardConsumeCodeUI", "onDataChange");
        if (!(bVar == null || bVar.csU() == null || !bVar.csU().equals(this.pQV.csU()))) {
            this.pQV = bVar;
            this.pWI.pQV = this.pQV;
            this.pWI.cuE();
        }
        AppMethodBeat.o(113043);
    }

    @Override // com.tencent.mm.plugin.card.b.d.a
    public final void ctp() {
        AppMethodBeat.i(113044);
        this.paT.vibrate(300);
        AppMethodBeat.o(113044);
    }

    @Override // com.tencent.mm.plugin.card.b.d.a
    public final void ctq() {
        AppMethodBeat.i(113045);
        Log.i("MicroMsg.CardConsumeCodeUI", "onFinishUI");
        finish();
        AppMethodBeat.o(113045);
    }

    @Override // com.tencent.mm.plugin.card.b.d.a
    public final void ajc(String str) {
        AppMethodBeat.i(113046);
        Log.i("MicroMsg.CardConsumeCodeUI", "onStartConsumedSuccUI");
        if (this.pWT) {
            Log.e("MicroMsg.CardConsumeCodeUI", "has start CardConsumeSuccessUI!");
            AppMethodBeat.o(113046);
            return;
        }
        Log.i("MicroMsg.CardConsumeCodeUI", "startConsumedSuccUI() ");
        this.pWT = true;
        Intent intent = new Intent(this, CardConsumeSuccessUI.class);
        intent.putExtra("KEY_CARD_ID", this.pQV.csU());
        intent.putExtra("KEY_CARD_CONSUMED_JSON", str);
        intent.putExtra("KEY_CARD_COLOR", this.pQV.csQ().ixw);
        intent.putExtra("key_stastic_scene", this.gwE);
        intent.putExtra("key_from_scene", 0);
        a bl = new a().bl(intent);
        com.tencent.mm.hellhoundlib.a.a.a(this, bl.axQ(), "com/tencent/mm/plugin/card/sharecard/ui/CardConsumeCodeUI", "startConsumedSuccUI", "(Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent) bl.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/sharecard/ui/CardConsumeCodeUI", "startConsumedSuccUI", "(Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(113046);
    }

    @Override // com.tencent.mm.plugin.card.b.c.a
    public final void ctk() {
        AppMethodBeat.i(113047);
        this.pWI.cuE();
        AppMethodBeat.o(113047);
    }

    @Override // com.tencent.mm.plugin.card.b.c.a
    public final void aiZ(String str) {
        AppMethodBeat.i(113048);
        com.tencent.mm.plugin.card.d.d.a(this, str, true);
        AppMethodBeat.o(113048);
    }

    @Override // com.tencent.mm.plugin.card.b.c.a
    public final void onSuccess() {
        AppMethodBeat.i(113049);
        this.pWI.cuE();
        AppMethodBeat.o(113049);
    }

    public void onClick(View view) {
        AppMethodBeat.i(113050);
        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
        bVar.bm(view);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/card/sharecard/ui/CardConsumeCodeUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
        if (view.getId() == R.id.aoj || view.getId() == R.id.aoe) {
            if (this.pQV.csJ()) {
                j.b bVar2 = new j.b();
                com.tencent.mm.plugin.card.d.b.a(this, bVar2.pRN, bVar2.pRO, false, this.pQV);
            } else {
                abz abz = this.pQV.csQ().Lfe;
                if (!com.tencent.mm.plugin.card.d.b.a(this.pQV.csU(), abz, this.pWG, this.pWH) && abz != null && !TextUtils.isEmpty(abz.url)) {
                    com.tencent.mm.plugin.card.d.b.a(this, l.Y(abz.url, abz.LfD), 1);
                    h.INSTANCE.a(11941, 9, this.pQV.csU(), this.pQV.csV(), "", abz.title);
                    if (l.a(abz, this.pQV.csU())) {
                        l.akj(this.pQV.csU());
                        com.tencent.mm.plugin.card.d.b.b(this, this.pQV.csQ().gTG);
                    }
                }
            }
            finish();
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/sharecard/ui/CardConsumeCodeUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(113050);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(113038);
        if (this.pQV.csx()) {
            if (!TextUtils.isEmpty(this.pQV.csQ().pTn)) {
                setMMTitle(getString(R.string.ao5, new Object[]{this.pQV.csQ().pTn}));
            } else {
                setMMTitle(getString(R.string.ao5, new Object[]{getString(R.string.ar9)}));
            }
        }
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.card.sharecard.ui.CardConsumeCodeUI.AnonymousClass1 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(113035);
                CardConsumeCodeUI.this.setResult(-1);
                CardConsumeCodeUI.this.finish();
                AppMethodBeat.o(113035);
                return true;
            }
        });
        if (this.pWI == null) {
            this.pWI = new a(this, getContentView());
            a aVar = this.pWI;
            aVar.pWC = aVar.pQZ.getWindow().getAttributes().screenBrightness;
            a aVar2 = this.pWI;
            aVar2.pWv = (TextView) aVar2.jBN.findViewById(R.id.ao8);
            aVar2.pWw = (TextView) aVar2.jBN.findViewById(R.id.aog);
            aVar2.pWx = (CheckBox) aVar2.jBN.findViewById(R.id.g2h);
            aVar2.pWx.setChecked(true);
            aVar2.pWx.setOnClickListener(aVar2.kuO);
            if (aVar2.pWC < 0.8f) {
                aVar2.bc(0.8f);
            }
            this.pWI.pWB = new a.AbstractC0907a() {
                /* class com.tencent.mm.plugin.card.sharecard.ui.CardConsumeCodeUI.AnonymousClass2 */

                @Override // com.tencent.mm.plugin.card.sharecard.ui.a.AbstractC0907a
                public final void Em(int i2) {
                    AppMethodBeat.i(113036);
                    am.cuc().V(CardConsumeCodeUI.this.pQV.csU(), i2, 1);
                    AppMethodBeat.o(113036);
                }
            };
        }
        this.pWI.pQV = this.pQV;
        this.pWI.pWA = true;
        if (this.pQV.csw()) {
            a aVar3 = this.pWI;
            String str = this.pWF;
            aVar3.pWz = 1;
            aVar3.pWy = str;
        }
        this.paT = (Vibrator) getSystemService("vibrator");
        this.pWJ = (TextView) findViewById(R.id.ac4);
        this.pWK = (TextView) findViewById(R.id.ipm);
        this.pWL = (LinearLayout) findViewById(R.id.s5);
        this.pWM = (ImageView) findViewById(R.id.s4);
        this.pWN = findViewById(R.id.bkd);
        this.pWO = (LinearLayout) findViewById(R.id.b56);
        if (this.pQV.csx()) {
            findViewById(R.id.all).setBackgroundColor(getResources().getColor(R.color.hl));
            n.d(this);
        } else {
            findViewById(R.id.all).setBackgroundColor(l.ake(this.pQV.csQ().ixw));
            n.a(this, this.pQV);
        }
        if (!this.pQV.csx() || TextUtils.isEmpty(this.pQV.csQ().iwv)) {
            this.pWJ.setText(this.pQV.csQ().gTG);
            this.pWK.setText(this.pQV.csQ().title);
        } else {
            this.pWL.setVisibility(0);
            this.pWJ.setVisibility(8);
            this.pWK.setVisibility(8);
            this.pWN.setVisibility(8);
            n.a(this.pWM, this.pQV.csQ().iwv, getResources().getDimensionPixelSize(R.dimen.v2), (int) R.drawable.ci4, true);
        }
        if (this.pQV.csQ().Lfe != null) {
            abz abz = this.pQV.csQ().Lfe;
            if (!TextUtils.isEmpty(abz.title)) {
                if (this.pWP == null) {
                    this.pWP = ((ViewStub) findViewById(R.id.aoh)).inflate();
                }
                this.pWP.setOnClickListener(this);
                this.pWQ = (TextView) this.pWP.findViewById(R.id.aoj);
                this.pWR = (TextView) this.pWP.findViewById(R.id.aoi);
                this.pWS = (TextView) this.pWP.findViewById(R.id.aof);
                this.pWQ.setVisibility(0);
                this.pWQ.setText(abz.title);
                Drawable drawable = getResources().getDrawable(R.drawable.c1h);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                drawable.setColorFilter(l.ake(this.pQV.csQ().ixw), PorterDuff.Mode.SRC_IN);
                this.pWQ.setCompoundDrawables(null, null, drawable, null);
                this.pWQ.setTextColor(l.ake(this.pQV.csQ().ixw));
                this.pWQ.setOnClickListener(this);
                if (!TextUtils.isEmpty(abz.pRY)) {
                    this.pWR.setVisibility(0);
                    this.pWR.setText(abz.pRY);
                } else {
                    this.pWR.setVisibility(0);
                    this.pWR.setText(getString(R.string.ar_));
                }
                if (!TextUtils.isEmpty(abz.pRZ)) {
                    this.pWS.setVisibility(0);
                    this.pWS.setText(abz.pRZ);
                }
                ViewGroup.LayoutParams layoutParams = this.pWM.getLayoutParams();
                layoutParams.height = getResources().getDimensionPixelSize(R.dimen.v3);
                layoutParams.width = getResources().getDimensionPixelSize(R.dimen.v3);
                this.pWM.setLayoutParams(layoutParams);
                ViewGroup.LayoutParams layoutParams2 = this.pWL.getLayoutParams();
                layoutParams2.height = com.tencent.mm.cb.a.fromDPToPix((Context) this, 54);
                layoutParams2.width = com.tencent.mm.cb.a.fromDPToPix((Context) this, 54);
                this.pWL.setLayoutParams(layoutParams2);
                n.a(this.pWM, this.pQV.csQ().iwv, getResources().getDimensionPixelSize(R.dimen.v3), (int) R.drawable.ci4, true);
                this.pWO.setPadding(0, com.tencent.mm.cb.a.fromDPToPix((Context) this, 10), 0, com.tencent.mm.cb.a.fromDPToPix((Context) this, 30));
            }
        }
        am.cub().a(this);
        if (this.pQV.csK()) {
            am.cud().a(this);
            if (!am.cud().isEmpty()) {
                am.cud().cti();
                AppMethodBeat.o(113038);
                return;
            }
            Log.i("MicroMsg.CardConsumeCodeUI", "registerListener doGetCardCodes");
            am.cud().aja(this.pQV.csU());
        }
        AppMethodBeat.o(113038);
    }
}

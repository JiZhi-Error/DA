package com.tencent.mm.plugin.honey_pay.ui;

import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.q;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.honey_pay.a.m;
import com.tencent.mm.plugin.honey_pay.model.c;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.pluginsdk.ui.span.o;
import com.tencent.mm.protocal.protobuf.caj;
import com.tencent.mm.protocal.protobuf.cbx;
import com.tencent.mm.protocal.protobuf.dhh;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.wallet_core.c.r;
import com.tencent.mm.wallet_core.ui.f;
import java.io.IOException;

public class HoneyPayCardDetailUI extends HoneyPayBaseUI {
    private int mScene;
    private ImageView qyu;
    private String yjY;
    private TextView ykc;
    private TextView ykd;
    private TextView yke;
    private TextView ykf;
    private TextView ykg;
    private TextView ykh;
    private RelativeLayout yki;
    private CdnImageView ykj;
    private TextView ykk;
    private Button ykl;
    private dhh ykm;
    private caj ykn;

    @Override // com.tencent.mm.plugin.honey_pay.ui.HoneyPayBaseUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.report.MMSecDataActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    static /* synthetic */ void a(HoneyPayCardDetailUI honeyPayCardDetailUI) {
        AppMethodBeat.i(64677);
        honeyPayCardDetailUI.dYQ();
        AppMethodBeat.o(64677);
    }

    @Override // com.tencent.mm.plugin.honey_pay.ui.HoneyPayBaseUI, android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(64671);
        this.wwG = R.color.um;
        super.onCreate(bundle);
        addSceneEndListener(2613);
        this.mScene = getIntent().getIntExtra("key_scene", 0);
        this.yjY = getIntent().getStringExtra("key_card_no");
        initView();
        if (this.mScene == 0) {
            dYR();
            AppMethodBeat.o(64671);
            return;
        }
        byte[] byteArrayExtra = getIntent().getByteArrayExtra("key_qry_response");
        try {
            this.ykm = new dhh();
            this.ykm.parseFrom(byteArrayExtra);
            dYQ();
            AppMethodBeat.o(64671);
        } catch (IOException e2) {
            Log.printErrStackTrace(this.TAG, e2, "", new Object[0]);
            dYR();
            AppMethodBeat.o(64671);
        }
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(64672);
        this.qyu = (ImageView) findViewById(R.id.dqr);
        this.ykc = (TextView) findViewById(R.id.dqq);
        this.ykd = (TextView) findViewById(R.id.dqp);
        this.ykg = (TextView) findViewById(R.id.dqh);
        this.ykh = (TextView) findViewById(R.id.dqo);
        this.yke = (TextView) findViewById(R.id.dqg);
        this.ykf = (TextView) findViewById(R.id.dqn);
        this.yki = (RelativeLayout) findViewById(R.id.dql);
        this.ykj = (CdnImageView) findViewById(R.id.dqk);
        this.ykk = (TextView) findViewById(R.id.dqj);
        this.ykl = (Button) findViewById(R.id.dqi);
        this.ykd.setClickable(true);
        this.ykd.setOnTouchListener(new o(this));
        AppMethodBeat.o(64672);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onDestroy() {
        AppMethodBeat.i(64673);
        super.onDestroy();
        removeSceneEndListener(2613);
        AppMethodBeat.o(64673);
    }

    @Override // com.tencent.mm.wallet_core.ui.WalletBaseUI
    public boolean onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(64674);
        if (qVar instanceof m) {
            final m mVar = (m) qVar;
            mVar.a(new r.a() {
                /* class com.tencent.mm.plugin.honey_pay.ui.HoneyPayCardDetailUI.AnonymousClass3 */

                @Override // com.tencent.mm.wallet_core.c.r.a
                public final void d(int i2, int i3, String str, q qVar) {
                    AppMethodBeat.i(64669);
                    HoneyPayCardDetailUI.this.ykm = mVar.yjK;
                    HoneyPayCardDetailUI.a(HoneyPayCardDetailUI.this);
                    AppMethodBeat.o(64669);
                }
            }).b(new r.a() {
                /* class com.tencent.mm.plugin.honey_pay.ui.HoneyPayCardDetailUI.AnonymousClass2 */

                @Override // com.tencent.mm.wallet_core.c.r.a
                public final void d(int i2, int i3, String str, q qVar) {
                }
            }).c(new r.a() {
                /* class com.tencent.mm.plugin.honey_pay.ui.HoneyPayCardDetailUI.AnonymousClass1 */

                @Override // com.tencent.mm.wallet_core.c.r.a
                public final void d(int i2, int i3, String str, q qVar) {
                }
            });
        }
        AppMethodBeat.o(64674);
        return true;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.aue;
    }

    private void dYQ() {
        AppMethodBeat.i(64675);
        if (this.ykm.LWG == null) {
            AppMethodBeat.o(64675);
            return;
        }
        cbx cbx = this.ykm.LWG;
        setMMTitle(cbx.pTn);
        this.ykc.setText(cbx.MhP);
        int i2 = cbx.state;
        if (i2 == 2) {
            this.qyu.setImageResource(R.raw.icons_outlined_done2);
            this.qyu.setColorFilter(getContext().getResources().getColor(R.color.Brand), PorterDuff.Mode.SRC_ATOP);
            if (!Util.isNullOrNil(cbx.MhL)) {
                cbx.MhL = c.W(cbx.MhL, this.ykm.LWG.KBN, -1);
                this.ykd.setText(l.a(this, cbx.MhL, (int) this.ykd.getTextSize(), (Object) null));
            }
            findViewById(R.id.dqe).setVisibility(8);
            findViewById(R.id.dqf).setVisibility(8);
            findViewById(R.id.dqm).setVisibility(8);
            if (this.ykn != null) {
                this.yki.setVisibility(0);
                this.ykj.setUrl(this.ykn.icon);
                this.ykk.setText(this.ykn.MfD);
                this.ykl.setText(this.ykn.MfC);
                this.ykl.setOnClickListener(new View.OnClickListener() {
                    /* class com.tencent.mm.plugin.honey_pay.ui.HoneyPayCardDetailUI.AnonymousClass4 */

                    public final void onClick(View view) {
                        AppMethodBeat.i(64670);
                        b bVar = new b();
                        bVar.bm(view);
                        a.b("com/tencent/mm/plugin/honey_pay/ui/HoneyPayCardDetailUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                        Log.d(HoneyPayCardDetailUI.this.TAG, "click oper btn: %s", HoneyPayCardDetailUI.this.ykn.url);
                        if (!Util.isNullOrNil(HoneyPayCardDetailUI.this.ykn.url)) {
                            f.p(HoneyPayCardDetailUI.this.getContext(), HoneyPayCardDetailUI.this.ykn.url, false);
                        }
                        a.a(this, "com/tencent/mm/plugin/honey_pay/ui/HoneyPayCardDetailUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(64670);
                    }
                });
                AppMethodBeat.o(64675);
                return;
            }
        } else if (i2 == 3) {
            this.qyu.setImageResource(R.raw.remittance_timed_out);
            if (!Util.isNullOrNil(cbx.MhL)) {
                this.ykd.setText(cbx.MhL);
            }
            this.yke.setText(R.string.e14);
            this.ykf.setText(R.string.e16);
            this.ykg.setText(c.GP((long) this.ykm.LWG.Gaz));
            this.ykh.setText(c.GP((long) this.ykm.LWG.pRN));
            AppMethodBeat.o(64675);
            return;
        } else if (i2 == 4) {
            this.qyu.setImageResource(R.raw.remittance_timed_out);
            if (!Util.isNullOrNil(cbx.MhL)) {
                this.ykd.setText(l.g(this, cbx.MhL, (int) this.ykd.getTextSize()));
            }
            this.yke.setText(R.string.e15);
            this.ykg.setText(c.GP((long) this.ykm.LWG.MhN));
            findViewById(R.id.dqm).setVisibility(8);
        }
        AppMethodBeat.o(64675);
    }

    private void dYR() {
        AppMethodBeat.i(64676);
        m mVar = new m(this.yjY);
        mVar.t(this);
        doSceneProgress(mVar, true);
        AppMethodBeat.o(64676);
    }
}

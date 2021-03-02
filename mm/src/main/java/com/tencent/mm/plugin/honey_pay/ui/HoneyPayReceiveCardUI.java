package com.tencent.mm.plugin.honey_pay.ui;

import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.q;
import com.tencent.mm.compatible.util.Exif;
import com.tencent.mm.g.a.og;
import com.tencent.mm.g.a.zv;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.honey_pay.a.e;
import com.tencent.mm.plugin.honey_pay.a.m;
import com.tencent.mm.plugin.honey_pay.model.c;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_core.ui.q;
import com.tencent.mm.pluginsdk.ui.a;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.pluginsdk.ui.applet.u;
import com.tencent.mm.pluginsdk.ui.span.i;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.pluginsdk.ui.span.o;
import com.tencent.mm.protocal.protobuf.cbx;
import com.tencent.mm.protocal.protobuf.dhh;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.wallet_core.c.r;
import com.tencent.mm.wallet_core.ui.f;
import java.io.IOException;

public class HoneyPayReceiveCardUI extends HoneyPayBaseUI {
    private int mScene;
    private String yjY;
    private ImageView ylK;
    private TextView ylL;
    private TextView ylM;
    private TextView ylN;
    private TextView ylO;
    private TextView ylP;
    private TextView ylQ;
    private TextView ylR;
    private TextView ylS;
    private TextView ylT;
    private LinearLayout ylU;
    private CdnImageView ylV;
    private i ylW = new i() {
        /* class com.tencent.mm.plugin.honey_pay.ui.HoneyPayReceiveCardUI.AnonymousClass1 */

        @Override // com.tencent.mm.pluginsdk.ui.span.i
        public final Object a(u uVar) {
            return null;
        }

        @Override // com.tencent.mm.pluginsdk.ui.span.i
        public final Object b(u uVar) {
            Object obj;
            AppMethodBeat.i(64824);
            if (uVar.type == 1 && (obj = uVar.data) != null && (obj instanceof Bundle) && ((Bundle) obj).getBoolean("click_help", false)) {
                h.INSTANCE.a(15191, 0, 1, 0, 0, 0, 0);
            }
            AppMethodBeat.o(64824);
            return null;
        }
    };

    @Override // com.tencent.mm.plugin.honey_pay.ui.HoneyPayBaseUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.report.MMSecDataActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public HoneyPayReceiveCardUI() {
        AppMethodBeat.i(64831);
        AppMethodBeat.o(64831);
    }

    static /* synthetic */ void a(HoneyPayReceiveCardUI honeyPayReceiveCardUI, dhh dhh) {
        AppMethodBeat.i(64839);
        honeyPayReceiveCardUI.a(dhh);
        AppMethodBeat.o(64839);
    }

    @Override // com.tencent.mm.plugin.honey_pay.ui.HoneyPayBaseUI, android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(64832);
        this.wwG = R.color.um;
        super.onCreate(bundle);
        l.a(this.ylW);
        addSceneEndListener(2613);
        addSceneEndListener(Exif.PARSE_EXIF_ERROR_NO_EXIF);
        this.yjY = getIntent().getStringExtra("key_card_no");
        this.mScene = getIntent().getIntExtra("key_scene", 0);
        initView();
        if (this.mScene == 1) {
            dhh dhh = new dhh();
            try {
                dhh.parseFrom(getIntent().getByteArrayExtra("key_qry_response"));
                a(dhh);
                if (dhh.LWG != null) {
                    setMMTitle(dhh.LWG.pTn);
                }
                AppMethodBeat.o(64832);
            } catch (IOException e2) {
                Log.printErrStackTrace(this.TAG, e2, "", new Object[0]);
                dYR();
                AppMethodBeat.o(64832);
            }
        } else {
            dYR();
            AppMethodBeat.o(64832);
        }
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(64833);
        this.ylK = (ImageView) findViewById(R.id.dsf);
        this.ylL = (TextView) findViewById(R.id.dsi);
        this.ylQ = (TextView) findViewById(R.id.dsp);
        this.ylM = (TextView) findViewById(R.id.dsj);
        this.ylT = (TextView) findViewById(R.id.dsm);
        this.ylN = (TextView) findViewById(R.id.dsg);
        this.ylO = (TextView) findViewById(R.id.dsn);
        this.ylP = (TextView) findViewById(R.id.dso);
        this.ylU = (LinearLayout) findViewById(R.id.dsk);
        this.ylR = (TextView) findViewById(R.id.dsq);
        this.ylS = (TextView) findViewById(R.id.dsh);
        this.ylV = (CdnImageView) findViewById(R.id.dsl);
        this.ylO.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.honey_pay.ui.HoneyPayReceiveCardUI.AnonymousClass2 */

            public final void onClick(View view) {
                AppMethodBeat.i(64825);
                b bVar = new b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/honey_pay/ui/HoneyPayReceiveCardUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                HoneyPayReceiveCardUI.a(HoneyPayReceiveCardUI.this);
                a.a(this, "com/tencent/mm/plugin/honey_pay/ui/HoneyPayReceiveCardUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(64825);
            }
        });
        AppMethodBeat.o(64833);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onDestroy() {
        AppMethodBeat.i(64834);
        super.onDestroy();
        l.b(this.ylW);
        removeSceneEndListener(2613);
        removeSceneEndListener(Exif.PARSE_EXIF_ERROR_NO_EXIF);
        AppMethodBeat.o(64834);
    }

    @Override // com.tencent.mm.wallet_core.ui.WalletBaseUI
    public boolean onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(64835);
        if (qVar instanceof m) {
            final m mVar = (m) qVar;
            mVar.a(new r.a() {
                /* class com.tencent.mm.plugin.honey_pay.ui.HoneyPayReceiveCardUI.AnonymousClass5 */

                @Override // com.tencent.mm.wallet_core.c.r.a
                public final void d(int i2, int i3, String str, q qVar) {
                    AppMethodBeat.i(64826);
                    HoneyPayReceiveCardUI.a(HoneyPayReceiveCardUI.this, mVar.yjK);
                    AppMethodBeat.o(64826);
                }
            }).b(new r.a() {
                /* class com.tencent.mm.plugin.honey_pay.ui.HoneyPayReceiveCardUI.AnonymousClass4 */

                @Override // com.tencent.mm.wallet_core.c.r.a
                public final void d(int i2, int i3, String str, q qVar) {
                }
            }).c(new r.a() {
                /* class com.tencent.mm.plugin.honey_pay.ui.HoneyPayReceiveCardUI.AnonymousClass3 */

                @Override // com.tencent.mm.wallet_core.c.r.a
                public final void d(int i2, int i3, String str, q qVar) {
                }
            });
        } else if (qVar instanceof e) {
            final e eVar = (e) qVar;
            eVar.a(new r.a() {
                /* class com.tencent.mm.plugin.honey_pay.ui.HoneyPayReceiveCardUI.AnonymousClass8 */

                @Override // com.tencent.mm.wallet_core.c.r.a
                public final void d(int i2, int i3, String str, q qVar) {
                    AppMethodBeat.i(64829);
                    if (eVar.yjB.LjA != null) {
                        Log.i(HoneyPayReceiveCardUI.this.TAG, "do real name");
                        Bundle bundle = new Bundle();
                        bundle.putString("realname_verify_process_jump_activity", ".ui.HoneyPayReceiveCardUI");
                        c.a(HoneyPayReceiveCardUI.this, bundle, eVar.yjB.LjA, false);
                    } else {
                        HoneyPayReceiveCardUI.b(HoneyPayReceiveCardUI.this);
                        String str2 = HoneyPayReceiveCardUI.this.yjY;
                        zv zvVar = new zv();
                        zvVar.efR.scene = 8;
                        EventCenter.instance.publish(zvVar);
                        Log.i("MicroMsg.HoneyPayUtil", "trigger offline event");
                        og ogVar = new og();
                        ogVar.dUv.scene = 1;
                        ogVar.dUv.dQm = "qmf";
                        EventCenter.instance.publish(ogVar);
                        if (!Util.isNullOrNil(str2)) {
                            com.tencent.mm.plugin.offline.c.a.aJk(str2);
                        }
                        HoneyPayReceiveCardUI.this.finish();
                    }
                    h.INSTANCE.n(875, 4, 1);
                    AppMethodBeat.o(64829);
                }
            }).b(new r.a() {
                /* class com.tencent.mm.plugin.honey_pay.ui.HoneyPayReceiveCardUI.AnonymousClass7 */

                @Override // com.tencent.mm.wallet_core.c.r.a
                public final void d(int i2, int i3, String str, q qVar) {
                    AppMethodBeat.i(64828);
                    if (eVar.yjB.LjA != null) {
                        Log.i(HoneyPayReceiveCardUI.this.TAG, "do real name");
                        Bundle bundle = new Bundle();
                        bundle.putString("realname_verify_process_jump_activity", ".ui.HoneyPayReceiveCardUI");
                        c.a(HoneyPayReceiveCardUI.this, bundle, eVar.yjB.LjA, false);
                    }
                    h.INSTANCE.n(875, 5, 1);
                    AppMethodBeat.o(64828);
                }
            }).c(new r.a() {
                /* class com.tencent.mm.plugin.honey_pay.ui.HoneyPayReceiveCardUI.AnonymousClass6 */

                @Override // com.tencent.mm.wallet_core.c.r.a
                public final void d(int i2, int i3, String str, q qVar) {
                    AppMethodBeat.i(64827);
                    h.INSTANCE.n(875, 5, 1);
                    AppMethodBeat.o(64827);
                }
            });
        }
        AppMethodBeat.o(64835);
        return true;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.aus;
    }

    private void a(final dhh dhh) {
        AppMethodBeat.i(64836);
        if (dhh.LWG == null) {
            AppMethodBeat.o(64836);
            return;
        }
        cbx cbx = dhh.LWG;
        this.ylP.setText(cbx.MhL);
        this.ylR.setText(l.b(getContext(), cbx.yPK, this.ylR.getTextSize()));
        Bundle bundle = new Bundle();
        bundle.putBoolean("click_help", true);
        this.ylS.setText(l.a(getContext(), cbx.Cjw, (int) this.ylS.getTextSize(), bundle));
        this.ylS.setClickable(true);
        this.ylS.setOnTouchListener(new o(this));
        if (!Util.isNullOrNil(dhh.MGq)) {
            com.tencent.mm.plugin.wallet_core.ui.q qVar = new com.tencent.mm.plugin.wallet_core.ui.q(new q.a() {
                /* class com.tencent.mm.plugin.honey_pay.ui.HoneyPayReceiveCardUI.AnonymousClass9 */

                @Override // com.tencent.mm.plugin.wallet_core.ui.q.a
                public final void dF(View view) {
                    AppMethodBeat.i(64830);
                    if (!Util.isNullOrNil(dhh.MGr)) {
                        f.p(HoneyPayReceiveCardUI.this.getContext(), dhh.MGr, false);
                    }
                    h.INSTANCE.a(15191, 0, 1, 0, 0, 0, 0);
                    AppMethodBeat.o(64830);
                }
            });
            SpannableString spannableString = new SpannableString(dhh.MGq);
            spannableString.setSpan(qVar, 0, spannableString.length(), 18);
            this.ylN.setText(spannableString);
            this.ylN.setOnTouchListener(new o(this));
            this.ylN.setClickable(true);
        } else {
            Log.d(this.TAG, "no help url");
            this.ylN.setVisibility(8);
        }
        this.ylM.setText(cbx.pTn);
        a.b.a(this.ylK, cbx.KBN, 0.06f, false);
        f.i(this.ylL, cbx.KBN);
        f.i(this.ylT, cbx.KBN);
        if (cbx.nHh == 1) {
            this.ylQ.setText(R.string.e0c);
        } else if (cbx.nHh == 2) {
            this.ylQ.setText(R.string.e0z);
        } else {
            this.ylQ.setText(l.b(this, f.hs(z.aUa(), 16), this.ylQ.getTextSize()));
        }
        if (!Util.isNullOrNil(cbx.qGB)) {
            this.ylV.gI(cbx.qGB, c.dYO());
            AppMethodBeat.o(64836);
            return;
        }
        this.ylV.setImageResource(c.dYO());
        AppMethodBeat.o(64836);
    }

    private void dYR() {
        AppMethodBeat.i(64837);
        Log.i(this.TAG, "qry user detail");
        m mVar = new m(this.yjY);
        mVar.t(this);
        doSceneProgress(mVar, true);
        AppMethodBeat.o(64837);
    }

    static /* synthetic */ void a(HoneyPayReceiveCardUI honeyPayReceiveCardUI) {
        AppMethodBeat.i(64838);
        Log.i(honeyPayReceiveCardUI.TAG, "do get honey pay card");
        e eVar = new e(honeyPayReceiveCardUI.yjY);
        eVar.t(honeyPayReceiveCardUI);
        honeyPayReceiveCardUI.doSceneProgress(eVar, true);
        AppMethodBeat.o(64838);
    }

    static /* synthetic */ void b(HoneyPayReceiveCardUI honeyPayReceiveCardUI) {
        AppMethodBeat.i(64840);
        Log.i(honeyPayReceiveCardUI.TAG, "go to honey pay card detail");
        Intent intent = new Intent(honeyPayReceiveCardUI, HoneyPayCardDetailUI.class);
        intent.putExtra("key_scene", 0);
        intent.putExtra("key_card_no", honeyPayReceiveCardUI.yjY);
        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
        com.tencent.mm.hellhoundlib.a.a.a(honeyPayReceiveCardUI, bl.axQ(), "com/tencent/mm/plugin/honey_pay/ui/HoneyPayReceiveCardUI", "gotoHoneyPayCardDetailUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        honeyPayReceiveCardUI.startActivity((Intent) bl.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(honeyPayReceiveCardUI, "com/tencent/mm/plugin/honey_pay/ui/HoneyPayReceiveCardUI", "gotoHoneyPayCardDetailUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(64840);
    }
}

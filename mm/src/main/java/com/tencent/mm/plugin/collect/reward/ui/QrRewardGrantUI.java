package com.tencent.mm.plugin.collect.reward.ui;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.gn;
import com.tencent.mm.hardcoder.g;
import com.tencent.mm.plugin.collect.reward.a.a;
import com.tencent.mm.plugin.collect.reward.a.d;
import com.tencent.mm.plugin.collect.reward.a.e;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.pluginsdk.ui.a;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.mm.ui.x;
import com.tencent.mm.wallet_core.b;
import com.tencent.mm.wallet_core.ui.WalletTextView;
import com.tencent.mm.wallet_core.ui.f;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;

public class QrRewardGrantUI extends QrRewardBaseUI {
    private RadioButton afT;
    private int channel;
    private String dDL;
    private String lDS;
    private String qvD;
    private CdnImageView qxN;
    private TextView qxO;
    private TextView qxP;
    private WalletTextView qxQ;
    private LinearLayout qxR;
    private WalletFormView qxS;
    private MMEditText qxT;
    private Button qxU;
    private int qxV;
    private int qxW;
    private String qxX;
    private String qxY;
    private String qxZ;
    private String qya;
    private String qyb;
    private String qyc;
    private String qyd;
    private String qye;
    private String qyf;
    private int qyg;
    private String qyh;
    private String qyi;
    private IListener<gn> qyj = new IListener<gn>() {
        /* class com.tencent.mm.plugin.collect.reward.ui.QrRewardGrantUI.AnonymousClass8 */

        {
            AppMethodBeat.i(160793);
            this.__eventId = gn.class.getName().hashCode();
            AppMethodBeat.o(160793);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(gn gnVar) {
            AppMethodBeat.i(63930);
            gn gnVar2 = gnVar;
            if (gnVar2.dKu.isKinda) {
                Log.f("MicroMsg.QrRewardGrantUI", "F2fPayCheckEvent is from kinda");
                if (gnVar2.dKu.dDN == 1) {
                    QrRewardGrantUI.a(QrRewardGrantUI.this, gnVar2.dKu.dDL, gnVar2.dKu.dDM);
                    QrRewardGrantUI.this.setResult(-1);
                    QrRewardGrantUI.this.finish();
                }
                AppMethodBeat.o(63930);
            } else {
                QrRewardGrantUI.a(QrRewardGrantUI.this, gnVar2.dKu.dDL, gnVar2.dKu.dDM);
                AppMethodBeat.o(63930);
            }
            return false;
        }
    };

    @Override // com.tencent.mm.plugin.collect.reward.ui.QrRewardBaseUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.report.MMSecDataActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public QrRewardGrantUI() {
        AppMethodBeat.i(63931);
        AppMethodBeat.o(63931);
    }

    static /* synthetic */ void a(QrRewardGrantUI qrRewardGrantUI, String str, String str2) {
        AppMethodBeat.i(213159);
        qrRewardGrantUI.fF(str, str2);
        AppMethodBeat.o(213159);
    }

    @Override // com.tencent.mm.plugin.collect.reward.ui.QrRewardBaseUI, android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(63932);
        super.onCreate(bundle);
        addSceneEndListener(1336);
        this.qyj.alive();
        setMMTitle(R.string.frp);
        this.qxV = getIntent().getIntExtra("key_money_amt", g.sHCENCODEVIDEOTIMEOUT);
        this.qxW = getIntent().getIntExtra("key_amt_type", 0);
        this.qxX = getIntent().getStringExtra("key_qrcode_desc");
        this.channel = getIntent().getIntExtra("key_channel", 0);
        this.qxZ = getIntent().getStringExtra("key_rcvr_open_id");
        this.qyb = getIntent().getStringExtra("key_rcvr_name");
        this.qyc = getIntent().getStringExtra("key_rcvr_true_name");
        this.qyd = getIntent().getStringExtra("key_scan_id");
        this.lDS = getIntent().getStringExtra("key_web_url");
        this.qye = getIntent().getStringExtra("key_sxtend_1");
        this.qyf = getIntent().getStringExtra("key_sxtend_2");
        this.qyg = getIntent().getIntExtra("key_max_amt", g.sHCENCODEVIDEOTIMEOUT);
        this.qyh = getIntent().getStringExtra("key_receiver_nickname");
        this.qyi = getIntent().getStringExtra("key_photo_url");
        Log.i("MicroMsg.QrRewardGrantUI", "amtType: %s, channel: %s, maxAmt: %s", Integer.valueOf(this.qxW), Integer.valueOf(this.channel), Integer.valueOf(this.qyg));
        initView();
        b.hgC();
        this.mKindaEnable = b.b(b.a.clicfg_kinda_open, true);
        AppMethodBeat.o(63932);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        String str;
        AppMethodBeat.i(63933);
        this.qxN = (CdnImageView) findViewById(R.id.gom);
        this.qxO = (TextView) findViewById(R.id.gon);
        this.qxQ = (WalletTextView) findViewById(R.id.gor);
        this.qxR = (LinearLayout) findViewById(R.id.goq);
        this.qxS = (WalletFormView) findViewById(R.id.goo);
        this.qxT = (MMEditText) findViewById(R.id.gop);
        this.qxU = (Button) findViewById(R.id.gos);
        this.qxP = (TextView) findViewById(R.id.gol);
        this.afT = (RadioButton) findViewById(R.id.gqv);
        this.afT.setChecked(true);
        this.qxP.setText(getString(R.string.fs4, new Object[]{new StringBuilder().append(Math.round(((float) this.qyg) / 100.0f)).toString()}));
        if (Util.isNullOrNil(this.qyi)) {
            a.b.a(this.qxN, this.qyb, 0.03f, false);
        } else {
            int fromDPToPix = BackwardSupportUtil.BitmapFactory.fromDPToPix(this, 50.0f);
            this.qxN.setRoundCorner(true);
            this.qxN.s(this.qyi, fromDPToPix, fromDPToPix, R.drawable.bca);
        }
        if (Util.isNullOrNil(this.qyh)) {
            str = f.hs(f.getDisplayName(this.qyb), 10);
        } else {
            str = this.qyh;
        }
        this.qxO.setText(l.c(this, getString(R.string.frq, new Object[]{str})));
        if (this.qxW == 2) {
            Log.i("MicroMsg.QrRewardGrantUI", "edit layout");
            setEditFocusListener(this.qxS, 2, false);
            this.qxS.a(new TextWatcher() {
                /* class com.tencent.mm.plugin.collect.reward.ui.QrRewardGrantUI.AnonymousClass1 */

                public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                }

                public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                }

                public final void afterTextChanged(Editable editable) {
                    AppMethodBeat.i(63923);
                    if (editable.toString().startsWith(".")) {
                        editable.insert(0, AppEventsConstants.EVENT_PARAM_VALUE_NO);
                    }
                    String obj = editable.toString();
                    int indexOf = obj.indexOf(".");
                    int length = obj.length();
                    if (indexOf >= 0 && length - indexOf > 3) {
                        editable.delete(indexOf + 3, length);
                    } else if (indexOf > 6) {
                        editable.delete(6, indexOf);
                    } else if (indexOf == -1 && length > 6) {
                        editable.delete(6, length);
                    }
                    int round = (int) Math.round(Util.getDouble(editable.toString(), 0.0d) * 100.0d);
                    QrRewardGrantUI.a(QrRewardGrantUI.this, round);
                    QrRewardGrantUI.this.qxV = round;
                    AppMethodBeat.o(63923);
                }
            });
            this.qxS.setVisibility(0);
            this.qxR.setVisibility(8);
            this.qxS.hic();
            this.qxU.setEnabled(false);
        } else {
            this.qxQ.setText(f.formatMoney2f(((double) this.qxV) / 100.0d));
            this.qxS.setVisibility(8);
            this.qxR.setVisibility(0);
        }
        this.qxU.setOnClickListener(new x() {
            /* class com.tencent.mm.plugin.collect.reward.ui.QrRewardGrantUI.AnonymousClass2 */

            @Override // com.tencent.mm.ui.x
            public final void czW() {
                AppMethodBeat.i(63924);
                if (QrRewardGrantUI.a(QrRewardGrantUI.this, (int) Math.round(Util.getDouble(QrRewardGrantUI.this.qxS.getText(), 0.0d) * 100.0d))) {
                    QrRewardGrantUI.b(QrRewardGrantUI.this);
                }
                AppMethodBeat.o(63924);
            }
        });
        findViewById(R.id.gqw).setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.collect.reward.ui.QrRewardGrantUI.AnonymousClass3 */

            public final void onClick(View view) {
                AppMethodBeat.i(63925);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/collect/reward/ui/QrRewardGrantUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                QrRewardGrantUI.this.afT.setChecked(!QrRewardGrantUI.this.afT.isChecked());
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/collect/reward/ui/QrRewardGrantUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(63925);
            }
        });
        this.afT.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            /* class com.tencent.mm.plugin.collect.reward.ui.QrRewardGrantUI.AnonymousClass4 */

            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            }
        });
        AppMethodBeat.o(63933);
    }

    @Override // com.tencent.mm.wallet_core.ui.WalletBaseUI
    public boolean onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(63934);
        if (qVar instanceof e) {
            final e eVar = (e) qVar;
            eVar.a(new a.AbstractC0930a() {
                /* class com.tencent.mm.plugin.collect.reward.ui.QrRewardGrantUI.AnonymousClass7 */

                @Override // com.tencent.mm.plugin.collect.reward.a.a.AbstractC0930a
                public final void g(q qVar) {
                    AppMethodBeat.i(63929);
                    QrRewardGrantUI.this.dDL = eVar.qxE.dNQ;
                    QrRewardGrantUI.this.qxY = eVar.qxE.LhB;
                    QrRewardGrantUI.this.qvD = eVar.qxE.KHN;
                    QrRewardGrantUI.this.qxZ = eVar.qxE.Lhz;
                    QrRewardGrantUI.this.qya = eVar.qxE.Lhy;
                    Log.i("MicroMsg.QrRewardGrantUI", "remind str: %s", eVar.qxE.LhN);
                    if (!Util.isNullOrNil(eVar.qxE.LhN)) {
                        h.c(QrRewardGrantUI.this.getContext(), eVar.qxE.LhN, "", QrRewardGrantUI.this.getString(R.string.g28), QrRewardGrantUI.this.getString(R.string.sz), new DialogInterface.OnClickListener() {
                            /* class com.tencent.mm.plugin.collect.reward.ui.QrRewardGrantUI.AnonymousClass7.AnonymousClass1 */

                            public final void onClick(DialogInterface dialogInterface, int i2) {
                                AppMethodBeat.i(63928);
                                QrRewardGrantUI.f(QrRewardGrantUI.this);
                                AppMethodBeat.o(63928);
                            }
                        }, new DialogInterface.OnClickListener() {
                            /* class com.tencent.mm.plugin.collect.reward.ui.QrRewardGrantUI.AnonymousClass7.AnonymousClass2 */

                            public final void onClick(DialogInterface dialogInterface, int i2) {
                                AppMethodBeat.i(213158);
                                if (QrRewardGrantUI.this.mKindaEnable) {
                                    QrRewardGrantUI.this.hideLoading();
                                }
                                AppMethodBeat.o(213158);
                            }
                        });
                        AppMethodBeat.o(63929);
                        return;
                    }
                    QrRewardGrantUI.f(QrRewardGrantUI.this);
                    AppMethodBeat.o(63929);
                }
            }).b(new a.AbstractC0930a() {
                /* class com.tencent.mm.plugin.collect.reward.ui.QrRewardGrantUI.AnonymousClass6 */

                @Override // com.tencent.mm.plugin.collect.reward.a.a.AbstractC0930a
                public final void g(q qVar) {
                    AppMethodBeat.i(63927);
                    Log.e("MicroMsg.QrRewardGrantUI", "place order error: %s, %s", Integer.valueOf(eVar.qxE.dDN), eVar.qxE.qwn);
                    if (!Util.isNullOrNil(eVar.qxE.qwn)) {
                        Toast.makeText(QrRewardGrantUI.this, eVar.qxE.qwn, 0).show();
                    }
                    if (QrRewardGrantUI.this.mKindaEnable) {
                        QrRewardGrantUI.this.hideLoading();
                    }
                    AppMethodBeat.o(63927);
                }
            }).c(new a.AbstractC0930a() {
                /* class com.tencent.mm.plugin.collect.reward.ui.QrRewardGrantUI.AnonymousClass5 */

                @Override // com.tencent.mm.plugin.collect.reward.a.a.AbstractC0930a
                public final void g(q qVar) {
                    AppMethodBeat.i(63926);
                    Log.e("MicroMsg.QrRewardGrantUI", "net error: %s", qVar);
                    if (QrRewardGrantUI.this.mKindaEnable) {
                        QrRewardGrantUI.this.hideLoading();
                    }
                    AppMethodBeat.o(63926);
                }
            });
        }
        AppMethodBeat.o(63934);
        return true;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onDestroy() {
        AppMethodBeat.i(63935);
        super.onDestroy();
        removeSceneEndListener(1336);
        this.qyj.dead();
        AppMethodBeat.o(63935);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(63936);
        if (i2 != 1) {
            super.onActivityResult(i2, i3, intent);
        } else if (i3 == -1) {
            setResult(-1);
            if (intent != null) {
                fF(intent.getStringExtra("key_reqKey"), intent.getStringExtra("key_trans_id"));
            }
            finish();
            AppMethodBeat.o(63936);
            return;
        }
        AppMethodBeat.o(63936);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.bk5;
    }

    private void fF(String str, String str2) {
        AppMethodBeat.i(63937);
        Log.i("MicroMsg.QrRewardGrantUI", "do pay check");
        if (Util.isNullOrNil(this.dDL)) {
            this.dDL = str;
        }
        if (Util.isNullOrNil(this.qvD)) {
            this.qvD = str2;
        }
        doSceneProgress(new d(this.dDL, this.qxY, this.qvD, this.qxV, this.qxZ, this.qya), false);
        AppMethodBeat.o(63937);
    }

    static /* synthetic */ boolean a(QrRewardGrantUI qrRewardGrantUI, int i2) {
        boolean z;
        boolean z2;
        AppMethodBeat.i(63938);
        if (qrRewardGrantUI.qxW == 1) {
            z = false;
            z2 = true;
        } else if (((double) i2) <= 0.0d) {
            z = true;
            z2 = false;
        } else if (i2 <= qrRewardGrantUI.qyg) {
            qrRewardGrantUI.qxS.setContentTextColorRes(R.color.a2x);
            z = false;
            z2 = true;
        } else {
            qrRewardGrantUI.qxS.setContentTextColorRes(R.color.a3);
            z = false;
            z2 = false;
        }
        if (z2) {
            if (qrRewardGrantUI.qxP.isShown()) {
                qrRewardGrantUI.qxP.startAnimation(AnimationUtils.loadAnimation(qrRewardGrantUI, R.anim.d5));
                qrRewardGrantUI.qxP.setVisibility(8);
            }
            qrRewardGrantUI.qxU.setEnabled(true);
        } else {
            if (!z && !qrRewardGrantUI.qxP.isShown()) {
                qrRewardGrantUI.qxP.startAnimation(AnimationUtils.loadAnimation(qrRewardGrantUI, R.anim.cc));
                qrRewardGrantUI.qxP.setVisibility(0);
            }
            qrRewardGrantUI.qxU.setEnabled(false);
        }
        AppMethodBeat.o(63938);
        return z2;
    }

    static /* synthetic */ void b(QrRewardGrantUI qrRewardGrantUI) {
        AppMethodBeat.i(63939);
        String replace = qrRewardGrantUI.qxT.getText().toString().replace("\n", "");
        int i2 = qrRewardGrantUI.afT.isChecked() ? 1 : 0;
        Log.i("MicroMsg.QrRewardGrantUI", "do place order, amt: %s, amtType: %s, payer desc: %s showPayInfo %s", Integer.valueOf(qrRewardGrantUI.qxV), Integer.valueOf(qrRewardGrantUI.qxW), replace, Integer.valueOf(i2));
        e eVar = new e(qrRewardGrantUI.qxV, qrRewardGrantUI.qxW, qrRewardGrantUI.qyb, qrRewardGrantUI.qxX, replace, qrRewardGrantUI.channel, qrRewardGrantUI.qyd, qrRewardGrantUI.qxZ, qrRewardGrantUI.lDS, qrRewardGrantUI.qye, qrRewardGrantUI.qyf, i2);
        eVar.M(qrRewardGrantUI);
        if (qrRewardGrantUI.mKindaEnable) {
            qrRewardGrantUI.showLoading();
            qrRewardGrantUI.doSceneProgress(eVar, false);
            AppMethodBeat.o(63939);
            return;
        }
        qrRewardGrantUI.doSceneProgress(eVar);
        AppMethodBeat.o(63939);
    }

    static /* synthetic */ void f(QrRewardGrantUI qrRewardGrantUI) {
        AppMethodBeat.i(63940);
        Log.i("MicroMsg.QrRewardGrantUI", "start pay");
        PayInfo payInfo = new PayInfo();
        payInfo.dDL = qrRewardGrantUI.dDL;
        payInfo.dVv = 48;
        payInfo.channel = qrRewardGrantUI.channel;
        Bundle bundle = new Bundle();
        bundle.putString("extinfo_key_1", qrRewardGrantUI.qyb);
        bundle.putString("extinfo_key_2", qrRewardGrantUI.qyc);
        bundle.putString("extinfo_key_3", qrRewardGrantUI.qxX);
        bundle.putString("extinfo_key_7", qrRewardGrantUI.qxT.getText().toString().replace("\n", ""));
        bundle.putString("extinfo_key_27", qrRewardGrantUI.qyi);
        bundle.putString("extinfo_key_28", qrRewardGrantUI.qyh);
        payInfo.iqp = bundle;
        if (qrRewardGrantUI.mKindaEnable) {
            ((com.tencent.mm.pluginsdk.wallet.a) com.tencent.mm.kernel.g.af(com.tencent.mm.pluginsdk.wallet.a.class)).startSNSPay(qrRewardGrantUI, payInfo);
            AppMethodBeat.o(63940);
            return;
        }
        com.tencent.mm.pluginsdk.wallet.f.a(qrRewardGrantUI, payInfo, 1);
        AppMethodBeat.o(63940);
    }
}

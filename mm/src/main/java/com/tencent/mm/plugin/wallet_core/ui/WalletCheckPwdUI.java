package com.tencent.mm.plugin.wallet_core.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.ow;
import com.tencent.mm.g.a.rm;
import com.tencent.mm.g.a.zq;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fingerprint.b.p;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_core.c.ad;
import com.tencent.mm.plugin.wallet_core.c.e;
import com.tencent.mm.plugin.wallet_core.c.w;
import com.tencent.mm.plugin.wallet_core.c.x;
import com.tencent.mm.protocal.protobuf.dal;
import com.tencent.mm.protocal.protobuf.eja;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.wallet_core.d;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.formview.EditHintPasswdView;
import org.json.JSONObject;

@a(3)
public class WalletCheckPwdUI extends WalletBaseUI {
    private String IgA;
    private String IgB;
    private Animation IgC;
    private d.a IgD;
    private boolean Igo = false;
    private LinearLayout Igp;
    private ImageView Igq;
    private TextView Igr;
    private TextView Igs;
    private TextView Igt;
    private boolean Igu = false;
    private boolean Igv = false;
    private String Igw;
    private int Igx = 0;
    private int Igy;
    private boolean Igz;
    private String dDL;
    private int dOG = 0;
    private TextView jUR;
    private String kof;
    private ScrollView lTw;
    protected EditHintPasswdView ykY;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.report.MMSecDataActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    static /* synthetic */ void f(WalletCheckPwdUI walletCheckPwdUI) {
        AppMethodBeat.i(70924);
        walletCheckPwdUI.fSO();
        AppMethodBeat.o(70924);
    }

    static /* synthetic */ void fSQ() {
        AppMethodBeat.i(70923);
        fSP();
        AppMethodBeat.o(70923);
    }

    static /* synthetic */ void g(WalletCheckPwdUI walletCheckPwdUI) {
        AppMethodBeat.i(70925);
        walletCheckPwdUI.fSM();
        AppMethodBeat.o(70925);
    }

    static /* synthetic */ int k(WalletCheckPwdUI walletCheckPwdUI) {
        int i2 = walletCheckPwdUI.Igx;
        walletCheckPwdUI.Igx = i2 + 1;
        return i2;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.c8l;
    }

    @Override // com.tencent.mm.ui.MMActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void setContentViewVisibility(int i2) {
        AppMethodBeat.i(70905);
        getContentView().setVisibility(i2);
        AppMethodBeat.o(70905);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onCreate(Bundle bundle) {
        q eVar;
        int i2 = -1;
        AppMethodBeat.i(70906);
        super.onCreate(bundle);
        hideTitleView();
        hideActionbarLine();
        getController().p(this, getContext().getResources().getColor(R.color.afz));
        Intent intent = getIntent();
        if (intent == null || !getIntent().hasExtra("scene")) {
            d by = com.tencent.mm.wallet_core.a.by(this);
            if (by != null) {
                int i3 = by.dQL.getInt("scene", -1);
                this.Igv = i3 == 1 && "UnbindProcess".equals(by.dKC());
                i2 = i3;
            }
        } else {
            i2 = intent.getIntExtra("scene", -1);
        }
        if (i2 == 1) {
            this.Igu = true;
            Log.d("Micromsg.WalletCheckPwdUI", "check pwd jsapi");
            setContentViewVisibility(4);
            Bundle bundle2 = null;
            if (this.Igv) {
                d by2 = com.tencent.mm.wallet_core.a.by(this);
                if (by2 != null) {
                    bundle2 = by2.dQL;
                }
                if (bundle2 == null) {
                    Log.d("Micromsg.WalletCheckPwdUI", "func[doCheckPayNetscene] process.getContextData null");
                    setResult(1);
                    aew(1);
                    finish();
                }
            } else if (getIntent() == null) {
                Log.d("Micromsg.WalletCheckPwdUI", "func[doCheckPayNetscene] intent null");
                setResult(0);
                aew(0);
                finish();
            } else {
                bundle2 = getIntent().getExtras();
            }
            String string = bundle2.getString("appId");
            String string2 = bundle2.getString("timeStamp");
            String string3 = bundle2.getString("nonceStr");
            String string4 = bundle2.getString("packageExt");
            String string5 = bundle2.getString("signtype");
            String string6 = bundle2.getString("paySignature");
            String string7 = bundle2.getString("url");
            int i4 = bundle2.getInt("pay_channel", 0);
            if (this.Igv) {
                Log.i("Micromsg.WalletCheckPwdUI", "appId is null? " + Util.isNullOrNil(string));
                eVar = new com.tencent.mm.plugin.wallet_core.c.d(string, string2, string3, string4, string5, string6, string7, 10, "verifyWCPayPassword", i4);
            } else {
                eVar = new e(string, string2, string3, string4, string5, string6, string7, "verifyWCPayPassword", i4);
            }
            doSceneForceProgress(eVar);
        } else {
            setContentViewVisibility(0);
        }
        initView();
        fSN();
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.wallet_core.ui.WalletCheckPwdUI.AnonymousClass1 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(70895);
                WalletCheckPwdUI.a(WalletCheckPwdUI.this);
                AppMethodBeat.o(70895);
                return false;
            }
        });
        findViewById(R.id.b47).setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.wallet_core.ui.WalletCheckPwdUI.AnonymousClass2 */

            public final void onClick(View view) {
                AppMethodBeat.i(70896);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/ui/WalletCheckPwdUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                WalletCheckPwdUI.a(WalletCheckPwdUI.this);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletCheckPwdUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(70896);
            }
        });
        AppMethodBeat.o(70906);
    }

    @Override // com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void forceCancel() {
        AppMethodBeat.i(70907);
        Log.d("Micromsg.WalletCheckPwdUI", "check pwd ");
        cleanScenes();
        AppMethodBeat.o(70907);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onResume() {
        AppMethodBeat.i(70908);
        if (this.ykY != null) {
            this.ykY.eIj();
        }
        addSceneEndListener(580);
        super.onResume();
        AppMethodBeat.o(70908);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onPause() {
        AppMethodBeat.i(70909);
        super.onPause();
        this.dOG = 0;
        fSM();
        fSP();
        removeSceneEndListener(580);
        AppMethodBeat.o(70909);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onDestroy() {
        AppMethodBeat.i(70910);
        super.onDestroy();
        if (this.Igz) {
            fSP();
        }
        AppMethodBeat.o(70910);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(70911);
        Util.isNullOrNil(getTips(0));
        this.ykY = (EditHintPasswdView) findViewById(R.id.dyp);
        com.tencent.mm.wallet_core.ui.formview.a.a(this.ykY);
        this.ykY.setOnInputValidListener(new EditHintPasswdView.a() {
            /* class com.tencent.mm.plugin.wallet_core.ui.WalletCheckPwdUI.AnonymousClass3 */

            @Override // com.tencent.mm.wallet_core.ui.formview.EditHintPasswdView.a
            public final void onInputValidChange(boolean z) {
                AppMethodBeat.i(70897);
                if (z) {
                    WalletCheckPwdUI.this.kof = WalletCheckPwdUI.this.ykY.getText();
                    d by = com.tencent.mm.wallet_core.a.by(WalletCheckPwdUI.this);
                    String str = null;
                    if (by != null) {
                        str = by.dKC();
                    }
                    if (!WalletCheckPwdUI.this.Igu || "UnbindProcess".equals(str)) {
                        if (!WalletCheckPwdUI.this.getNetController().r(WalletCheckPwdUI.this.kof, WalletCheckPwdUI.this.getPayReqKey())) {
                            WalletCheckPwdUI.this.doSceneProgress(new w(WalletCheckPwdUI.this.kof, 1, WalletCheckPwdUI.this.getPayReqKey()));
                        }
                    } else {
                        WalletCheckPwdUI.this.doSceneProgress(new x(WalletCheckPwdUI.this.kof, WalletCheckPwdUI.this.Igw, (byte) 0));
                        h.INSTANCE.a(15021, 1);
                        AppMethodBeat.o(70897);
                        return;
                    }
                }
                AppMethodBeat.o(70897);
            }
        });
        this.lTw = (ScrollView) findViewById(R.id.jjo);
        this.Igp = (LinearLayout) findViewById(R.id.d4l);
        this.Igq = (ImageView) findViewById(R.id.d4k);
        this.Igs = (TextView) findViewById(R.id.jhz);
        this.Igt = (TextView) findViewById(R.id.jhu);
        this.Igr = (TextView) findViewById(R.id.d4o);
        this.jUR = (TextView) findViewById(R.id.jjm);
        this.jUR.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.wallet_core.ui.WalletCheckPwdUI.AnonymousClass4 */

            public final void onClick(View view) {
                AppMethodBeat.i(70898);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/ui/WalletCheckPwdUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                WalletCheckPwdUI.fSQ();
                if (WalletCheckPwdUI.this.dOG == 0) {
                    WalletCheckPwdUI.this.dOG = 1;
                    WalletCheckPwdUI.f(WalletCheckPwdUI.this);
                } else {
                    WalletCheckPwdUI.this.dOG = 0;
                }
                WalletCheckPwdUI.g(WalletCheckPwdUI.this);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletCheckPwdUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(70898);
            }
        });
        setTenpayKBStateListener(new com.tencent.mm.wallet_core.ui.a() {
            /* class com.tencent.mm.plugin.wallet_core.ui.WalletCheckPwdUI.AnonymousClass5 */

            @Override // com.tencent.mm.wallet_core.ui.a
            public final void onVisibleStateChange(final boolean z) {
                AppMethodBeat.i(70900);
                Log.d("Micromsg.WalletCheckPwdUI", "kb visibility: %s", Boolean.valueOf(z));
                WalletCheckPwdUI.this.lTw.post(new Runnable() {
                    /* class com.tencent.mm.plugin.wallet_core.ui.WalletCheckPwdUI.AnonymousClass5.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(70899);
                        if (z) {
                            WalletCheckPwdUI.this.lTw.fullScroll(130);
                            AppMethodBeat.o(70899);
                            return;
                        }
                        WalletCheckPwdUI.this.lTw.fullScroll(33);
                        AppMethodBeat.o(70899);
                    }
                });
                AppMethodBeat.o(70900);
            }
        });
        setEditFocusListener(this.ykY, 0, false);
        this.ykY.post(new Runnable() {
            /* class com.tencent.mm.plugin.wallet_core.ui.WalletCheckPwdUI.AnonymousClass6 */

            public final void run() {
                AppMethodBeat.i(70901);
                WalletCheckPwdUI.this.ykY.hhY();
                AppMethodBeat.o(70901);
            }
        });
        showTenpayKB();
        AppMethodBeat.o(70911);
    }

    private void a(dal dal) {
        AppMethodBeat.i(70912);
        if (dal != null && !Util.isNullOrNil(dal.title)) {
            this.Igs.setText(dal.title);
        }
        if (dal != null && !Util.isNullOrNil(dal.MFO)) {
            this.Igt.setText(dal.MFO);
        }
        fSN();
        AppMethodBeat.o(70912);
    }

    private void fSM() {
        AppMethodBeat.i(70913);
        Log.i("Micromsg.WalletCheckPwdUI", "change mode: %s", Integer.valueOf(this.dOG));
        if (this.dOG == 1) {
            this.Igp.setVisibility(0);
            this.ykY.setVisibility(8);
            this.jUR.setText(R.string.iau);
            this.Igp.postDelayed(new Runnable() {
                /* class com.tencent.mm.plugin.wallet_core.ui.WalletCheckPwdUI.AnonymousClass7 */

                public final void run() {
                    AppMethodBeat.i(70902);
                    WalletCheckPwdUI.this.hideTenpayKB();
                    AppMethodBeat.o(70902);
                }
            }, 300);
            if (!Util.isNullOrNil(this.IgB)) {
                this.Igt.setText(this.IgB);
                AppMethodBeat.o(70913);
                return;
            }
            this.Igt.setText(R.string.iay);
            AppMethodBeat.o(70913);
            return;
        }
        this.Igp.setVisibility(8);
        this.ykY.eIj();
        this.ykY.setVisibility(0);
        this.jUR.setText(R.string.iat);
        showTenpayKB();
        if (!Util.isNullOrNil(this.IgA)) {
            this.Igt.setText(this.IgA);
            AppMethodBeat.o(70913);
            return;
        }
        this.Igt.setText(R.string.iax);
        AppMethodBeat.o(70913);
    }

    private void fSN() {
        AppMethodBeat.i(70914);
        d process = getProcess();
        if (process != null) {
            if ("UnbindProcess".equals(process.dKC())) {
                String string = process.dQL.getString("key_check_pwd_title");
                if (!Util.isNullOrNil(string)) {
                    this.Igs.setText(string);
                } else {
                    this.Igs.setText(R.string.ie9);
                }
                this.Igt.setText(R.string.ib3);
                AppMethodBeat.o(70914);
                return;
            } else if (process instanceof com.tencent.mm.plugin.wallet_core.b.b) {
                this.Igs.setText(R.string.idq);
                this.Igt.setText(R.string.ib3);
                AppMethodBeat.o(70914);
                return;
            } else if ("ModifyPwdProcess".equals(process.dKC())) {
                this.Igs.setText(R.string.ij1);
                this.Igt.setText(R.string.ib3);
                AppMethodBeat.o(70914);
                return;
            } else if ("OfflineProcess".equals(process.dKC())) {
                this.Igs.setText(R.string.ib2);
                this.Igt.setText(R.string.ib3);
            }
        }
        AppMethodBeat.o(70914);
    }

    @Override // com.tencent.mm.wallet_core.ui.WalletBaseUI
    public boolean onSceneEnd(int i2, int i3, String str, q qVar) {
        boolean z;
        AppMethodBeat.i(70915);
        Log.d("Micromsg.WalletCheckPwdUI", " errCode: " + i3 + " errMsg :" + str);
        if (i2 == 0 && i3 == 0) {
            if (qVar instanceof w) {
                Bundle input = getInput();
                input.putString("key_pwd1", this.ykY.getText());
                input.putString("key_bind_card_user_token", ((w) qVar).token);
                com.tencent.mm.wallet_core.a.l(this, input);
                if (this.ykY != null) {
                    this.ykY.eIj();
                }
                finish();
            } else if (qVar instanceof ad) {
                com.tencent.mm.ui.base.h.cD(this, getString(R.string.ib_));
                d by = com.tencent.mm.wallet_core.a.by(this);
                if (by != null) {
                    by.dQL.putInt("key_process_result_code", -1);
                }
                com.tencent.mm.wallet_core.a.l(this, by.dQL);
                if (this.ykY != null) {
                    this.ykY.eIj();
                }
                finish();
            } else if (qVar instanceof com.tencent.mm.plugin.wallet_core.c.d) {
                com.tencent.mm.pluginsdk.wallet.e.bfP(((com.tencent.mm.plugin.wallet_core.c.d) qVar).fPP());
                this.Igw = ((com.tencent.mm.plugin.wallet_core.c.d) qVar).getToken();
                setResult(-1);
                a(((com.tencent.mm.plugin.wallet_core.c.d) qVar).fPQ());
                setContentViewVisibility(0);
            } else if (qVar instanceof e) {
                e eVar = (e) qVar;
                this.Igw = eVar.HPD.token;
                this.dDL = eVar.HPD.KxE;
                com.tencent.mm.pluginsdk.wallet.e.bfP(eVar.HPD.KxE);
                if (eVar.HPD.Lkx != null) {
                    this.IgA = eVar.HPD.Lkx.MFO;
                    this.IgB = eVar.HPD.Lkx.MFP;
                }
                setResult(-1);
                a(eVar.HPD.Lkx);
                eja eja = eVar.HPD.Llh;
                if (!(eja == null || eja.KYF == null)) {
                    com.tencent.mm.plugin.fingerprint.d.a aVar = (com.tencent.mm.plugin.fingerprint.d.a) g.af(com.tencent.mm.plugin.fingerprint.d.a.class);
                    if (eja.NiN == 1 && eja.NiO == 1 && aVar.dJU() && aVar.dJT() && !aVar.dJP()) {
                        Log.i("Micromsg.WalletCheckPwdUI", "can use touch pay");
                        this.dOG = 1;
                        if (eja.KYF != null) {
                            p.IML.wFE = eja.KYF.yO();
                        }
                        p pVar = p.IML;
                        if (eja.KYG == 1) {
                            z = true;
                        } else {
                            z = false;
                        }
                        pVar.wFM = z;
                        fSO();
                        this.jUR.setVisibility(0);
                    }
                }
                fSM();
                setContentViewVisibility(0);
            } else if (qVar instanceof x) {
                x xVar = (x) qVar;
                if (xVar.fPR()) {
                    Log.i("Micromsg.WalletCheckPwdUI", "need free sms");
                    Bundle bundle = new Bundle();
                    bundle.putString("key_pwd1", this.kof);
                    bundle.putString("key_jsapi_token", this.Igw);
                    bundle.putString("key_relation_key", xVar.HQd);
                    bundle.putString("key_mobile", xVar.HQc);
                    this.IgD = new d.a() {
                        /* class com.tencent.mm.plugin.wallet_core.ui.WalletCheckPwdUI.AnonymousClass8 */

                        @Override // com.tencent.mm.wallet_core.d.a
                        public final Intent q(int i2, Bundle bundle) {
                            AppMethodBeat.i(70903);
                            Log.i("Micromsg.WalletCheckPwdUI", "verify code end: %s", Integer.valueOf(i2));
                            Intent intent = new Intent();
                            intent.putExtra("token", bundle.getString("key_jsapi_token"));
                            intent.putExtra("key_process_result_code", i2);
                            intent.setClass(WalletCheckPwdUI.this.getContext(), WalletCheckPwdUI.class);
                            intent.addFlags(536870912);
                            intent.putExtra("key_process_is_stay", false);
                            AppMethodBeat.o(70903);
                            return intent;
                        }
                    };
                    com.tencent.mm.wallet_core.a.a(this, p.class, bundle, this.IgD);
                } else {
                    Intent intent = new Intent();
                    intent.putExtra("token", ((x) qVar).HQa);
                    setResult(-1, intent);
                    aew(-1);
                    finish();
                }
            }
            AppMethodBeat.o(70915);
            return true;
        }
        if (this.ykY != null) {
            this.ykY.eIj();
        }
        if ((qVar instanceof com.tencent.mm.plugin.wallet_core.c.d) || (qVar instanceof e)) {
            Log.i("Micromsg.WalletCheckPwdUI", "check jsapi fail");
            d by2 = com.tencent.mm.wallet_core.a.by(this);
            if (by2 == null || !by2.dKC().equals("UnbindProcess")) {
                setResult(0);
                aew(0);
                finish();
            } else {
                setResult(1);
                by2.dQL.putInt("key_process_result_code", 1);
                com.tencent.mm.wallet_core.a.l(this, by2.dQL);
            }
            AppMethodBeat.o(70915);
            return true;
        }
        AppMethodBeat.o(70915);
        return false;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public boolean onKeyUp(int i2, KeyEvent keyEvent) {
        AppMethodBeat.i(70916);
        if (this.mKBLayout == null || !this.mKBLayout.isShown()) {
            boolean onKeyUp = super.onKeyUp(i2, keyEvent);
            AppMethodBeat.o(70916);
            return onKeyUp;
        }
        this.mKBLayout.setVisibility(8);
        AppMethodBeat.o(70916);
        return true;
    }

    @Override // com.tencent.mm.wallet_core.ui.WalletBaseUI
    public boolean needConfirmFinish() {
        AppMethodBeat.i(70917);
        if (getInput().getInt("key_pay_flag", 0) != 0) {
            AppMethodBeat.o(70917);
            return true;
        }
        AppMethodBeat.o(70917);
        return false;
    }

    @Override // com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void cleanUiData(int i2) {
        AppMethodBeat.i(70918);
        if (this.Igo) {
            finish();
            AppMethodBeat.o(70918);
            return;
        }
        if (this.ykY != null) {
            this.ykY.eIj();
        }
        AppMethodBeat.o(70918);
    }

    @Override // com.tencent.mm.wallet_core.ui.WalletBaseUI
    public boolean isTransparent() {
        return this.Igo;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getForceOrientation() {
        return 1;
    }

    private void fSO() {
        AppMethodBeat.i(70919);
        this.Igz = true;
        com.tencent.mm.plugin.soter.d.a.flK();
        final ow owVar = new ow();
        owVar.dUQ.dNQ = this.dDL;
        owVar.dUQ.dUS = 1;
        owVar.dUQ.dUU = new Runnable() {
            /* class com.tencent.mm.plugin.wallet_core.ui.WalletCheckPwdUI.AnonymousClass9 */

            public final void run() {
                boolean z;
                AppMethodBeat.i(70904);
                Log.i("Micromsg.WalletCheckPwdUI", "hy: FingerPrintAuthEvent callback");
                ow.b bVar = owVar.dUR;
                if (bVar == null) {
                    Log.i("Micromsg.WalletCheckPwdUI", "hy: FingerPrintAuthEvent callback, result == null");
                    AppMethodBeat.o(70904);
                    return;
                }
                int i2 = bVar.errCode;
                Log.v("Micromsg.WalletCheckPwdUI", "alvinluo errCode: %d, errMsg: %s", Integer.valueOf(i2), bVar.errMsg);
                if (i2 == 0) {
                    Log.i("Micromsg.WalletCheckPwdUI", "hy: payInfo soterAuthReq: %s", bVar.dUV);
                    WalletCheckPwdUI.this.Igr.setVisibility(8);
                    WalletCheckPwdUI.b(WalletCheckPwdUI.this, bVar.dUV);
                    com.tencent.mm.plugin.soter.d.a.aau(0);
                    AppMethodBeat.o(70904);
                    return;
                }
                Log.i("Micromsg.WalletCheckPwdUI", "hy: FingerPrintAuthEvent callback, encrypted_pay_info & encrypted_rsa_sign is empty, idetify fail!");
                int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
                int i3 = currentTimeMillis - WalletCheckPwdUI.this.Igy;
                if (i3 > 1) {
                    WalletCheckPwdUI.this.Igy = currentTimeMillis;
                    WalletCheckPwdUI.k(WalletCheckPwdUI.this);
                }
                boolean z2 = i2 == 2 || i2 == 10308;
                if (bVar.dUW == 2) {
                    z = true;
                } else {
                    z = false;
                }
                Log.v("Micromsg.WalletCheckPwdUI", "alvinluo shouldDirectlyFail: %b, mIdentifyFail: %d, errCode: %d, isSoter: %b", Boolean.valueOf(z2), Integer.valueOf(WalletCheckPwdUI.this.Igx), Integer.valueOf(i2), Boolean.valueOf(z));
                if ((z || (WalletCheckPwdUI.this.Igx < 3 && i3 > 1)) && !z2) {
                    Log.v("Micromsg.WalletCheckPwdUI", "alvinluo fingerprint pay");
                    if (WalletCheckPwdUI.this.IgC == null) {
                        WalletCheckPwdUI.this.IgC = com.tencent.mm.ui.c.a.he(WalletCheckPwdUI.this.getContext());
                    }
                    WalletCheckPwdUI.this.Igr.setVisibility(0);
                    WalletCheckPwdUI.this.Igr.startAnimation(WalletCheckPwdUI.this.IgC);
                    WalletCheckPwdUI.this.IgC.setFillAfter(true);
                    com.tencent.mm.plugin.soter.d.a.aau(1);
                    AppMethodBeat.o(70904);
                    return;
                }
                if (WalletCheckPwdUI.this.Igx >= 3 || z2) {
                    Log.v("Micromsg.WalletCheckPwdUI", "alvinluo change to pwd pay");
                    WalletCheckPwdUI.fSQ();
                    WalletCheckPwdUI.this.dOG = 0;
                    WalletCheckPwdUI.g(WalletCheckPwdUI.this);
                    WalletCheckPwdUI.this.jUR.setVisibility(8);
                    com.tencent.mm.plugin.soter.d.a.aau(2);
                }
                AppMethodBeat.o(70904);
            }
        };
        EventCenter.instance.asyncPublish(owVar, Looper.getMainLooper());
        AppMethodBeat.o(70919);
    }

    private static void fSP() {
        AppMethodBeat.i(70920);
        Log.i("Micromsg.WalletCheckPwdUI", "hy: send release FPManager");
        EventCenter.instance.publish(new rm());
        AppMethodBeat.o(70920);
    }

    private void aew(int i2) {
        AppMethodBeat.i(70921);
        if (getIntent().getBooleanExtra("from_kinda", false)) {
            zq zqVar = new zq();
            zqVar.efK.result = i2;
            EventCenter.instance.publish(zqVar);
        }
        AppMethodBeat.o(70921);
    }

    static /* synthetic */ void a(WalletCheckPwdUI walletCheckPwdUI) {
        AppMethodBeat.i(70922);
        d process = walletCheckPwdUI.getProcess();
        Log.i("Micromsg.WalletCheckPwdUI", "onbackbtn click");
        if (process == null) {
            walletCheckPwdUI.aew(0);
        } else if (process instanceof com.tencent.mm.plugin.wallet_core.id_verify.a) {
            process.g(walletCheckPwdUI, 0);
        } else if (walletCheckPwdUI.Igv) {
            process.dQL.putInt("key_process_result_code", 0);
            process.b(walletCheckPwdUI, process.dQL);
        } else if (process.dKC().equals("OpenECardProcess")) {
            walletCheckPwdUI.getInput().putInt("key_process_result_code", 0);
            walletCheckPwdUI.setResult(-1);
            process.b(walletCheckPwdUI, walletCheckPwdUI.getInput());
        } else if (process.dKC().equals("PayProcess")) {
            walletCheckPwdUI.getInput().putInt("key_process_result_code", 0);
            walletCheckPwdUI.setResult(-1);
            process.b(walletCheckPwdUI.getContext(), walletCheckPwdUI.getInput());
        } else if (process.dKC().equals("BindCardProcess")) {
            walletCheckPwdUI.getInput().putInt("key_process_result_code", 0);
            walletCheckPwdUI.setResult(-1);
            process.b(walletCheckPwdUI.getContext(), walletCheckPwdUI.getInput());
        }
        walletCheckPwdUI.finish();
        AppMethodBeat.o(70922);
    }

    static /* synthetic */ void b(WalletCheckPwdUI walletCheckPwdUI, String str) {
        AppMethodBeat.i(70926);
        Log.i("Micromsg.WalletCheckPwdUI", "do check pwd by fp");
        try {
            JSONObject jSONObject = new JSONObject(str);
            jSONObject.put("soter_type", "1");
            str = jSONObject.toString();
        } catch (Exception e2) {
            Log.printErrStackTrace("Micromsg.WalletCheckPwdUI", e2, "", new Object[0]);
        }
        walletCheckPwdUI.doSceneProgress(new x(walletCheckPwdUI.Igw, str), true);
        h.INSTANCE.a(15021, 2);
        AppMethodBeat.o(70926);
    }
}

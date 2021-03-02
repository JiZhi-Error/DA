package com.tencent.mm.plugin.wallet_core.id_verify;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.c;
import com.tencent.mm.ak.q;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.wallet_core.id_verify.a;
import com.tencent.mm.protocal.protobuf.djw;
import com.tencent.mm.protocal.protobuf.djy;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.mm.ui.x;
import com.tencent.mm.wallet_core.d;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.f;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;

public class WcPayRealnameVerifyCodeUI extends WalletBaseUI {
    private WalletFormView HRV;
    private WalletFormView HRW;
    private Button HRX;
    private TextView HRY;
    private ViewGroup HRZ;
    private TextView HSa;
    private a HSb;
    private String HSc = "+86";
    private boolean HSd = false;
    private Button krs;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.report.MMSecDataActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(174469);
        super.onCreate(bundle);
        setMMTitle("");
        setActionbarColor(getResources().getColor(R.color.f3048f));
        hideActionbarLine();
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.wallet_core.id_verify.WcPayRealnameVerifyCodeUI.AnonymousClass1 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(174457);
                d process = WcPayRealnameVerifyCodeUI.this.getProcess();
                if (process != null) {
                    process.g(WcPayRealnameVerifyCodeUI.this.getContext(), 0);
                } else {
                    WcPayRealnameVerifyCodeUI.this.finish();
                }
                AppMethodBeat.o(174457);
                return false;
            }
        }, R.raw.actionbar_icon_dark_close);
        initView();
        AppMethodBeat.o(174469);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(174470);
        this.HRV = (WalletFormView) findViewById(R.id.jqa);
        this.HRW = (WalletFormView) findViewById(R.id.jqc);
        this.HRX = (Button) findViewById(R.id.jqb);
        this.krs = (Button) findViewById(R.id.jq8);
        this.HRY = (TextView) findViewById(R.id.jq7);
        this.HRZ = (ViewGroup) findViewById(R.id.jq9);
        this.HSa = (TextView) findViewById(R.id.jq_);
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.hs);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(R.dimen.bt);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize);
        layoutParams.gravity = 17;
        layoutParams.rightMargin = dimensionPixelSize2;
        this.HRV.getInfoIv().setLayoutParams(layoutParams);
        this.HRV.getInfoIv().setScaleType(ImageView.ScaleType.FIT_CENTER);
        this.HRV.getInfoIv().setClearBtnDrawableId$255f295(getResources().getColor(R.color.FG_2));
        this.HRW.getContentEt().setPadding(this.HRW.getContentEt().getPaddingLeft(), this.HRW.getContentEt().getPaddingTop(), 0, this.HRW.getContentEt().getPaddingBottom());
        this.HRX.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.wallet_core.id_verify.WcPayRealnameVerifyCodeUI.AnonymousClass2 */

            public final void onClick(View view) {
                AppMethodBeat.i(174458);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/id_verify/WcPayRealnameVerifyCodeUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                Log.d("MicroMsg.WcPayRealNameVerifyCodeUI", "click resend btn");
                WcPayRealnameVerifyCodeUI.a(WcPayRealnameVerifyCodeUI.this);
                g netController = WcPayRealnameVerifyCodeUI.this.getNetController();
                if (netController instanceof a.b) {
                    a.b bVar2 = (a.b) netController;
                    String text = WcPayRealnameVerifyCodeUI.this.HRV.getText();
                    String str = WcPayRealnameVerifyCodeUI.this.HSc;
                    Log.i("MicroMsg.RealNameVerifyProcess", "do resend verify code");
                    Log.i("MicroMsg.RealNameVerifyProcess", "do send sms: %s", text);
                    new com.tencent.mm.plugin.wallet_core.id_verify.model.b(text, str, bVar2.HQT, a.this.dQL.getString("realname_verify_process_req_key", "")).aYI().b(new com.tencent.mm.vending.c.a<Object, c.a<djw>>() {
                        /* class com.tencent.mm.plugin.wallet_core.id_verify.a.b.AnonymousClass2 */

                        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                        @Override // com.tencent.mm.vending.c.a
                        public final /* synthetic */ Object call(c.a<djw> aVar) {
                            AppMethodBeat.i(174439);
                            c.a<djw> aVar2 = aVar;
                            if (b.this.activity.isFinishing() || b.this.activity.isDestroyed()) {
                                AppMethodBeat.o(174439);
                            } else {
                                if (aVar2.errType == 0 && aVar2.errCode == 0 && ((djw) aVar2.iLC).pTZ != 0 && !Util.isNullOrNil(((djw) aVar2.iLC).pUa)) {
                                    f.bpB(((djw) aVar2.iLC).pUa);
                                }
                                AppMethodBeat.o(174439);
                            }
                            return null;
                        }
                    });
                    if (bVar2.HQT == 0) {
                        bVar2.HQT++;
                    }
                } else {
                    Log.w("MicroMsg.WcPayRealNameVerifyCodeUI", "wrong controller");
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/id_verify/WcPayRealnameVerifyCodeUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(174458);
            }
        });
        this.krs.setOnClickListener(new x() {
            /* class com.tencent.mm.plugin.wallet_core.id_verify.WcPayRealnameVerifyCodeUI.AnonymousClass3 */

            @Override // com.tencent.mm.ui.x
            public final void czW() {
                AppMethodBeat.i(174459);
                WcPayRealnameVerifyCodeUI.d(WcPayRealnameVerifyCodeUI.this);
                if (WcPayRealnameVerifyCodeUI.this.krs.isEnabled()) {
                    g netController = WcPayRealnameVerifyCodeUI.this.getNetController();
                    if (netController instanceof a.b) {
                        a.b bVar = (a.b) netController;
                        String text = WcPayRealnameVerifyCodeUI.this.HRV.getText();
                        String str = WcPayRealnameVerifyCodeUI.this.HSc;
                        String text2 = WcPayRealnameVerifyCodeUI.this.HRW.getText();
                        Log.i("MicroMsg.RealNameVerifyProcess", "do check verify code");
                        ((WalletBaseUI) bVar.activity).showProgress();
                        new com.tencent.mm.plugin.wallet_core.id_verify.model.c(a.this.dQL.getString("realname_verify_process_req_key", ""), text, str, text2).aYI().b(new com.tencent.mm.vending.c.a<Object, c.a<djy>>() {
                            /* class com.tencent.mm.plugin.wallet_core.id_verify.a.b.AnonymousClass1 */

                            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                            @Override // com.tencent.mm.vending.c.a
                            public final /* synthetic */ Object call(c.a<djy> aVar) {
                                AppMethodBeat.i(174438);
                                c.a<djy> aVar2 = aVar;
                                if (b.this.activity.isFinishing() || b.this.activity.isDestroyed()) {
                                    AppMethodBeat.o(174438);
                                    return null;
                                }
                                ((WalletBaseUI) b.this.activity).hideProgress();
                                if (aVar2.errType == 0 && aVar2.errCode == 0) {
                                    if (((djy) aVar2.iLC).pTZ == 0) {
                                        a.this.a(b.this.activity, 0, new Bundle());
                                    } else {
                                        f.cP(b.this.activity, ((djy) aVar2.iLC).pUa);
                                    }
                                    Boolean bool = Boolean.TRUE;
                                    AppMethodBeat.o(174438);
                                    return bool;
                                }
                                f.ar(b.this.activity, aVar2.errMsg);
                                AppMethodBeat.o(174438);
                                return null;
                            }
                        });
                        AppMethodBeat.o(174459);
                        return;
                    }
                    Log.w("MicroMsg.WcPayRealNameVerifyCodeUI", "wrong controller");
                }
                AppMethodBeat.o(174459);
            }
        });
        this.HRV.setLogicDelegate(new com.tencent.mm.wallet_core.ui.formview.a.b() {
            /* class com.tencent.mm.plugin.wallet_core.id_verify.WcPayRealnameVerifyCodeUI.AnonymousClass4 */

            @Override // com.tencent.mm.wallet_core.ui.formview.a.b
            public final boolean a(WalletFormView walletFormView) {
                AppMethodBeat.i(174460);
                if ("+86".equals(WcPayRealnameVerifyCodeUI.this.HSc)) {
                    boolean isPhoneNum = walletFormView.isPhoneNum();
                    AppMethodBeat.o(174460);
                    return isPhoneNum;
                } else if (Util.isNullOrNil(WcPayRealnameVerifyCodeUI.this.HSc) || Util.isNullOrNil(WcPayRealnameVerifyCodeUI.this.HRV.getText())) {
                    AppMethodBeat.o(174460);
                    return false;
                } else {
                    AppMethodBeat.o(174460);
                    return true;
                }
            }

            @Override // com.tencent.mm.wallet_core.ui.formview.a.b
            public final boolean a(WalletFormView walletFormView, String str) {
                return false;
            }

            @Override // com.tencent.mm.wallet_core.ui.formview.a.b
            public final boolean b(WalletFormView walletFormView, String str) {
                return false;
            }

            @Override // com.tencent.mm.wallet_core.ui.formview.a.b
            public final boolean eIg() {
                return false;
            }

            @Override // com.tencent.mm.wallet_core.ui.formview.a.b
            public final String c(WalletFormView walletFormView, String str) {
                return null;
            }
        });
        this.HRV.setOnInputValidChangeListener(new WalletFormView.a() {
            /* class com.tencent.mm.plugin.wallet_core.id_verify.WcPayRealnameVerifyCodeUI.AnonymousClass5 */

            @Override // com.tencent.mm.wallet_core.ui.formview.WalletFormView.a
            public final void onInputValidChange(boolean z) {
                AppMethodBeat.i(174461);
                Log.i("MicroMsg.WcPayRealNameVerifyCodeUI", "phone valid change: %s", Boolean.valueOf(z));
                WcPayRealnameVerifyCodeUI.g(WcPayRealnameVerifyCodeUI.this);
                WcPayRealnameVerifyCodeUI.d(WcPayRealnameVerifyCodeUI.this);
                AppMethodBeat.o(174461);
            }
        });
        this.HRW.a(new TextWatcher() {
            /* class com.tencent.mm.plugin.wallet_core.id_verify.WcPayRealnameVerifyCodeUI.AnonymousClass6 */

            public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public final void afterTextChanged(Editable editable) {
                AppMethodBeat.i(174462);
                WcPayRealnameVerifyCodeUI.d(WcPayRealnameVerifyCodeUI.this);
                AppMethodBeat.o(174462);
            }
        });
        this.HRZ.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.wallet_core.id_verify.WcPayRealnameVerifyCodeUI.AnonymousClass7 */

            public final void onClick(View view) {
                AppMethodBeat.i(174463);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/id_verify/WcPayRealnameVerifyCodeUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                Log.d("MicroMsg.WcPayRealNameVerifyCodeUI", "click phone code layout");
                Intent intent = new Intent();
                intent.setClassName(WcPayRealnameVerifyCodeUI.this.getContext(), "com.tencent.mm.ui.tools.CountryCodeUI");
                WcPayRealnameVerifyCodeUI.this.startActivityForResult(intent, 1);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/id_verify/WcPayRealnameVerifyCodeUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(174463);
            }
        });
        fPY();
        this.HRY.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.wallet_core.id_verify.WcPayRealnameVerifyCodeUI.AnonymousClass8 */

            public final void onClick(View view) {
                AppMethodBeat.i(174466);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/id_verify/WcPayRealnameVerifyCodeUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                Log.d("MicroMsg.WcPayRealNameVerifyCodeUI", "click verify code fail tv");
                final e eVar = new e((Context) WcPayRealnameVerifyCodeUI.this.getContext(), 1, false);
                final View inflate = WcPayRealnameVerifyCodeUI.this.getLayoutInflater().inflate(R.layout.cb1, (ViewGroup) null);
                ((Button) inflate.findViewById(R.id.dt2)).setOnClickListener(new View.OnClickListener() {
                    /* class com.tencent.mm.plugin.wallet_core.id_verify.WcPayRealnameVerifyCodeUI.AnonymousClass8.AnonymousClass1 */

                    public final void onClick(View view) {
                        AppMethodBeat.i(174464);
                        b bVar = new b();
                        bVar.bm(view);
                        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/id_verify/WcPayRealnameVerifyCodeUI$8$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                        eVar.bMo();
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/id_verify/WcPayRealnameVerifyCodeUI$8$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(174464);
                    }
                });
                eVar.HLX = new o.f() {
                    /* class com.tencent.mm.plugin.wallet_core.id_verify.WcPayRealnameVerifyCodeUI.AnonymousClass8.AnonymousClass2 */

                    @Override // com.tencent.mm.ui.base.o.f
                    public final void onCreateMMMenu(m mVar) {
                        AppMethodBeat.i(174465);
                        mVar.clear();
                        eVar.setFooterView(null);
                        eVar.setFooterView(inflate);
                        AppMethodBeat.o(174465);
                    }
                };
                eVar.Dm(true);
                eVar.dGm();
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/id_verify/WcPayRealnameVerifyCodeUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(174466);
            }
        });
        AppMethodBeat.o(174470);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(174471);
        if (i2 == 1 && i3 == 100) {
            String stringExtra = intent.getStringExtra("country_name");
            if (Util.isNullOrNil(stringExtra)) {
                Log.i("MicroMsg.WcPayRealNameVerifyCodeUI", "user canceled this select");
                AppMethodBeat.o(174471);
                return;
            }
            this.HSc = "+" + intent.getStringExtra("couttry_code");
            Log.i("MicroMsg.WcPayRealNameVerifyCodeUI", "countryName: %s, countryCode: %s", stringExtra, this.HSc);
            fPY();
        }
        super.onActivityResult(i2, i3, intent);
        AppMethodBeat.o(174471);
    }

    @Override // com.tencent.mm.wallet_core.ui.WalletBaseUI
    public boolean onSceneEnd(int i2, int i3, String str, q qVar) {
        return false;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onDestroy() {
        AppMethodBeat.i(174472);
        super.onDestroy();
        if (this.HSb != null) {
            this.HSb.cancel();
        }
        AppMethodBeat.o(174472);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.cb2;
    }

    private void fPY() {
        AppMethodBeat.i(174473);
        this.HSa.setText(this.HSc);
        AppMethodBeat.o(174473);
    }

    /* access modifiers changed from: package-private */
    public class a extends CountDownTimer {
        public a() {
            super(Util.MILLSECONDS_OF_MINUTE, 1000);
        }

        public final void onTick(long j2) {
            AppMethodBeat.i(174467);
            WcPayRealnameVerifyCodeUI.this.HRX.setText(WcPayRealnameVerifyCodeUI.this.getString(R.string.ixq, new Object[]{(j2 / 1000) + "s"}));
            AppMethodBeat.o(174467);
        }

        public final void onFinish() {
            AppMethodBeat.i(174468);
            WcPayRealnameVerifyCodeUI.this.HRX.setText(WcPayRealnameVerifyCodeUI.this.getString(R.string.ixr));
            WcPayRealnameVerifyCodeUI.this.HSd = false;
            WcPayRealnameVerifyCodeUI.g(WcPayRealnameVerifyCodeUI.this);
            AppMethodBeat.o(174468);
        }
    }

    static /* synthetic */ void a(WcPayRealnameVerifyCodeUI wcPayRealnameVerifyCodeUI) {
        AppMethodBeat.i(174474);
        if (wcPayRealnameVerifyCodeUI.HSb == null) {
            wcPayRealnameVerifyCodeUI.HSb = new a();
        }
        wcPayRealnameVerifyCodeUI.HSd = true;
        wcPayRealnameVerifyCodeUI.HRX.setEnabled(false);
        wcPayRealnameVerifyCodeUI.HSb.start();
        AppMethodBeat.o(174474);
    }

    static /* synthetic */ void d(WcPayRealnameVerifyCodeUI wcPayRealnameVerifyCodeUI) {
        AppMethodBeat.i(174475);
        if (Util.isNullOrNil(wcPayRealnameVerifyCodeUI.HRW.getText()) || !wcPayRealnameVerifyCodeUI.HRV.bql()) {
            wcPayRealnameVerifyCodeUI.krs.setEnabled(false);
            AppMethodBeat.o(174475);
            return;
        }
        wcPayRealnameVerifyCodeUI.krs.setEnabled(true);
        AppMethodBeat.o(174475);
    }

    static /* synthetic */ void g(WcPayRealnameVerifyCodeUI wcPayRealnameVerifyCodeUI) {
        AppMethodBeat.i(174476);
        if (!wcPayRealnameVerifyCodeUI.HRV.bql() || wcPayRealnameVerifyCodeUI.HSd) {
            wcPayRealnameVerifyCodeUI.HRX.setEnabled(false);
            AppMethodBeat.o(174476);
            return;
        }
        wcPayRealnameVerifyCodeUI.HRX.setEnabled(true);
        AppMethodBeat.o(174476);
    }
}

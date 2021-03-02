package com.tencent.mm.plugin.remittance.ui;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.q;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fingerprint.b.h;
import com.tencent.mm.plugin.remittance.a.c;
import com.tencent.mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.wallet_core.ui.f;

@a(19)
public class RemittanceResultOldUI extends RemittanceResultUI {
    private Orders CwO;
    private boolean CwP;
    private int mPayScene;
    private String mReceiverName;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.report.MMSecDataActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.plugin.remittance.ui.RemittanceResultUI, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    static /* synthetic */ void a(RemittanceResultOldUI remittanceResultOldUI) {
        AppMethodBeat.i(68312);
        remittanceResultOldUI.eOl();
        AppMethodBeat.o(68312);
    }

    static /* synthetic */ void b(RemittanceResultOldUI remittanceResultOldUI) {
        AppMethodBeat.i(68313);
        remittanceResultOldUI.eOm();
        AppMethodBeat.o(68313);
    }

    @Override // com.tencent.mm.plugin.remittance.ui.RemittanceResultUI, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public boolean onSceneEnd(int i2, int i3, String str, q qVar) {
        return false;
    }

    @Override // com.tencent.mm.ui.MMActivity, com.tencent.mm.plugin.remittance.ui.RemittanceResultUI
    public int getLayoutId() {
        return R.layout.bn1;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.plugin.remittance.ui.RemittanceResultUI, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(68307);
        super.onCreate(bundle);
        this.CwO = (Orders) getInput().getParcelable("key_orders");
        initView();
        if (this.mPayScene == 31) {
            String str = "";
            if (this.CwO.HZd.size() > 0) {
                str = this.CwO.HZd.get(0).dDM;
            }
            Log.i("MicroMsg.RemittanceResultOldUI", "transId: %s", str);
            c.eMU().eMX().jM(str, this.mReceiverName);
        }
        AppMethodBeat.o(68307);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public boolean onKeyUp(int i2, KeyEvent keyEvent) {
        AppMethodBeat.i(68308);
        if (i2 == 4) {
            eOl();
        }
        boolean onKeyUp = super.onKeyUp(i2, keyEvent);
        AppMethodBeat.o(68308);
        return onKeyUp;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        String str;
        boolean z;
        boolean z2 = true;
        AppMethodBeat.i(68309);
        setMMTitle(getString(R.string.g4f));
        setBackBtn(null);
        showHomeBtn(false);
        enableBackMenu(false);
        TextView textView = (TextView) findViewById(R.id.h2t);
        if (this.CwO != null) {
            textView.setText(f.d(this.CwO.dDO, this.CwO.AOl));
        }
        PayInfo payInfo = (PayInfo) getInput().getParcelable("key_pay_info");
        if (payInfo == null) {
            Log.e("MicroMsg.RemittanceResultOldUI", "payInfo is null!!!");
            finish();
            AppMethodBeat.o(68309);
            return;
        }
        String str2 = "";
        if (payInfo.iqp != null) {
            this.CwP = payInfo.iqp.getBoolean("extinfo_key_4");
            str2 = payInfo.iqp.getString("extinfo_key_1");
        }
        int i2 = payInfo.dVv;
        this.mPayScene = i2;
        this.mReceiverName = str2;
        String displayName = f.getDisplayName(str2);
        if (i2 == 31) {
            TextView textView2 = (TextView) findViewById(R.id.h2v);
            String string = getString(R.string.g4e, new Object[]{displayName});
            if (!Util.isNullOrNil(string)) {
                textView2.setText(l.b(this, string, textView2.getTextSize()));
                textView2.setVisibility(0);
            } else {
                textView2.setVisibility(8);
            }
            findViewById(R.id.h2m).setVisibility(8);
            if (this.CwO.CoZ > 0.0d) {
                ((TextView) findViewById(R.id.ar4)).setText(getResources().getString(R.string.g4c, f.d(this.CwO.CoZ, this.CwO.AOl)));
                findViewById(R.id.ar5).setVisibility(0);
            }
        } else {
            String str3 = "";
            if (payInfo.iqp != null) {
                str3 = payInfo.iqp.getString("extinfo_key_2");
            }
            if (i2 == 32 || i2 == 33) {
                str = displayName;
            } else if (!Util.isNullOrNil(str3)) {
                str = displayName + "（" + f.bps(str3) + "）";
            } else {
                str = displayName + getString(R.string.g4u);
            }
            TextView textView3 = (TextView) findViewById(R.id.h2v);
            if (!Util.isNullOrNil(str)) {
                textView3.setText(l.b(this, getString(R.string.g4d, new Object[]{str}), textView3.getTextSize()));
                textView3.setVisibility(0);
            } else {
                textView3.setVisibility(8);
            }
            if (i2 == 33 || i2 == 32) {
                View findViewById = findViewById(R.id.h2r);
                TextView textView4 = (TextView) findViewById(R.id.h2s);
                TextView textView5 = (TextView) findViewById(R.id.h2q);
                String string2 = payInfo.iqp.getString("extinfo_key_3");
                String string3 = payInfo.iqp.getString("extinfo_key_8");
                if (!Util.isNullOrNil(string2)) {
                    textView5.setText(l.b(this, string2, textView5.getTextSize()));
                    findViewById.setVisibility(0);
                    if (!Util.isNullOrNil(string3)) {
                        textView4.setText(string3);
                        z = true;
                    } else {
                        z = true;
                    }
                } else {
                    findViewById.setVisibility(8);
                    z = false;
                }
                View findViewById2 = findViewById(R.id.h2o);
                TextView textView6 = (TextView) findViewById(R.id.h2p);
                TextView textView7 = (TextView) findViewById(R.id.h2n);
                String string4 = payInfo.iqp.getString("extinfo_key_6");
                String string5 = payInfo.iqp.getString("extinfo_key_7");
                if (!Util.isNullOrNil(string5)) {
                    textView7.setText(l.b(this, string5, textView7.getTextSize()));
                    textView7.setVisibility(0);
                    if (!Util.isNullOrNil(string4)) {
                        textView6.setText(l.b(this, string4, textView6.getTextSize()));
                    }
                } else {
                    findViewById2.setVisibility(8);
                    z2 = false;
                }
                if (!z && !z2) {
                    findViewById(R.id.h2m).setVisibility(8);
                }
            } else if (i2 == 5 && this.CwO.HZd != null && this.CwO.HZd.get(0) != null && !TextUtils.isEmpty(this.CwO.HZd.get(0).AOa)) {
                textView3.setText(this.CwO.HZd.get(0).AOa);
            }
        }
        ((Button) findViewById(R.id.h2u)).setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.remittance.ui.RemittanceResultOldUI.AnonymousClass1 */

            public final void onClick(View view) {
                AppMethodBeat.i(68304);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/remittance/ui/RemittanceResultOldUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                RemittanceResultOldUI.a(RemittanceResultOldUI.this);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/remittance/ui/RemittanceResultOldUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(68304);
            }
        });
        ((h) g.af(h.class)).i(this);
        AppMethodBeat.o(68309);
    }

    private void eOl() {
        AppMethodBeat.i(68310);
        if (getInput().containsKey("key_realname_guide_helper")) {
            RealnameGuideHelper realnameGuideHelper = (RealnameGuideHelper) getInput().getParcelable("key_realname_guide_helper");
            if (realnameGuideHelper != null) {
                Bundle bundle = new Bundle();
                bundle.putString("realname_verify_process_jump_activity", ".ui.RemittanceResultUI");
                bundle.putString("realname_verify_process_jump_plugin", "remittance");
                realnameGuideHelper.b(this, bundle, new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.plugin.remittance.ui.RemittanceResultOldUI.AnonymousClass2 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        AppMethodBeat.i(68305);
                        RemittanceResultOldUI.b(RemittanceResultOldUI.this);
                        AppMethodBeat.o(68305);
                    }
                });
                getInput().remove("key_realname_guide_helper");
            }
            AppMethodBeat.o(68310);
            return;
        }
        eOm();
        AppMethodBeat.o(68310);
    }

    private void eOm() {
        AppMethodBeat.i(68311);
        getProcess().b(this, getInput());
        new MMHandler().postDelayed(new Runnable() {
            /* class com.tencent.mm.plugin.remittance.ui.RemittanceResultOldUI.AnonymousClass3 */

            public final void run() {
                AppMethodBeat.i(68306);
                if (RemittanceResultOldUI.this.mPayScene == 33 || RemittanceResultOldUI.this.mPayScene == 32) {
                    RemittanceResultOldUI.this.finish();
                    AppMethodBeat.o(68306);
                } else if (Util.isNullOrNil(RemittanceResultOldUI.this.mReceiverName) || RemittanceResultOldUI.this.CwP) {
                    RemittanceResultOldUI.this.finish();
                    AppMethodBeat.o(68306);
                } else {
                    Intent intent = new Intent();
                    intent.putExtra("Chat_User", RemittanceResultOldUI.this.mReceiverName);
                    intent.putExtra("finish_direct", false);
                    com.tencent.mm.br.c.f(RemittanceResultOldUI.this, ".ui.chatting.ChattingUI", intent);
                    AppMethodBeat.o(68306);
                }
            }
        }, 100);
        AppMethodBeat.o(68311);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.remittance.ui.RemittanceResultUI
    public final boolean eOn() {
        return false;
    }
}

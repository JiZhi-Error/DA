package com.tencent.mm.plugin.honey_pay.ui;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.q;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.wallet_core.c.ah;
import com.tencent.mm.wallet_core.ui.f;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import java.math.RoundingMode;

public class HoneyPayModifyQuotaUI extends HoneyPayBaseUI {
    private Button nAa;
    private String yjY;
    private long ykN;
    private long ykO;
    private WalletFormView ylE;
    private TextView ylk;

    @Override // com.tencent.mm.plugin.honey_pay.ui.HoneyPayBaseUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.report.MMSecDataActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // com.tencent.mm.plugin.honey_pay.ui.HoneyPayBaseUI, android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(64805);
        super.onCreate(bundle);
        this.ykN = getIntent().getLongExtra("key_max_credit_line", 0);
        this.ykO = getIntent().getLongExtra("key_min_credit_line", 0);
        this.yjY = getIntent().getStringExtra("key_card_no");
        initView();
        setMMTitle(R.string.e0w);
        AppMethodBeat.o(64805);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(64806);
        this.ylE = (WalletFormView) findViewById(R.id.ds2);
        this.nAa = (Button) findViewById(R.id.ds1);
        this.ylk = (TextView) findViewById(R.id.ds3);
        this.ylE.setContentPadding$3b4dfe4b(0);
        this.ylE.getTitleTv().setText(ah.hhz());
        setEditFocusListener(this.ylE, 2, false);
        this.ylE.a(new TextWatcher() {
            /* class com.tencent.mm.plugin.honey_pay.ui.HoneyPayModifyQuotaUI.AnonymousClass1 */

            public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public final void afterTextChanged(Editable editable) {
                AppMethodBeat.i(64802);
                if (editable.toString().startsWith(".")) {
                    editable.insert(0, AppEventsConstants.EVENT_PARAM_VALUE_NO);
                }
                String obj = editable.toString();
                int indexOf = obj.indexOf(".");
                int length = obj.length();
                if (indexOf >= 0 && length - indexOf > 2) {
                    editable.delete(indexOf + 3, length);
                }
                HoneyPayModifyQuotaUI.a(HoneyPayModifyQuotaUI.this);
                AppMethodBeat.o(64802);
            }
        });
        this.nAa.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.honey_pay.ui.HoneyPayModifyQuotaUI.AnonymousClass2 */

            public final void onClick(View view) {
                AppMethodBeat.i(64803);
                b bVar = new b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/honey_pay/ui/HoneyPayModifyQuotaUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (HoneyPayModifyQuotaUI.a(HoneyPayModifyQuotaUI.this)) {
                    HoneyPayModifyQuotaUI.b(HoneyPayModifyQuotaUI.this);
                    HoneyPayModifyQuotaUI.this.hideTenpayKB();
                }
                a.a(this, "com/tencent/mm/plugin/honey_pay/ui/HoneyPayModifyQuotaUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(64803);
            }
        });
        this.ylE.postDelayed(new Runnable() {
            /* class com.tencent.mm.plugin.honey_pay.ui.HoneyPayModifyQuotaUI.AnonymousClass3 */

            public final void run() {
                AppMethodBeat.i(64804);
                HoneyPayModifyQuotaUI.this.ylE.d(HoneyPayModifyQuotaUI.this);
                AppMethodBeat.o(64804);
            }
        }, 100);
        AppMethodBeat.o(64806);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onDestroy() {
        AppMethodBeat.i(64807);
        super.onDestroy();
        AppMethodBeat.o(64807);
    }

    @Override // com.tencent.mm.wallet_core.ui.WalletBaseUI
    public boolean onSceneEnd(int i2, int i3, String str, q qVar) {
        return false;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(64808);
        if (i2 == 1 && i3 == -1 && intent.getBooleanExtra("key_modify_create_line_succ", false)) {
            setResult(-1, intent);
            finish();
        }
        super.onActivityResult(i2, i3, intent);
        AppMethodBeat.o(64808);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.auq;
    }

    private void qf(boolean z) {
        AppMethodBeat.i(64809);
        if (!z || this.ylk.isShown()) {
            if (!z && this.ylk.isShown()) {
                this.ylk.startAnimation(AnimationUtils.loadAnimation(this, R.anim.d5));
                this.ylk.setVisibility(8);
            }
            AppMethodBeat.o(64809);
            return;
        }
        this.ylk.setText(getString(R.string.e0v, new Object[]{ah.hhz() + f.b(new StringBuilder().append(this.ykO).toString(), "100", 2, RoundingMode.HALF_UP).toString()}));
        this.ylk.startAnimation(AnimationUtils.loadAnimation(this, R.anim.cc));
        this.ylk.setVisibility(0);
        AppMethodBeat.o(64809);
    }

    private void qg(boolean z) {
        AppMethodBeat.i(64810);
        if (!z || this.ylk.isShown()) {
            if (!z && this.ylk.isShown()) {
                this.ylk.startAnimation(AnimationUtils.loadAnimation(this, R.anim.d5));
                this.ylk.setVisibility(8);
            }
            AppMethodBeat.o(64810);
            return;
        }
        this.ylk.setText(getString(R.string.e0r, new Object[]{ah.hhz() + f.b(new StringBuilder().append(this.ykN).toString(), "100", 2, RoundingMode.HALF_UP)}));
        this.ylk.startAnimation(AnimationUtils.loadAnimation(this, R.anim.cc));
        this.ylk.setVisibility(0);
        AppMethodBeat.o(64810);
    }

    private void qh(boolean z) {
        AppMethodBeat.i(64811);
        this.nAa.setEnabled(z);
        AppMethodBeat.o(64811);
    }

    static /* synthetic */ boolean a(HoneyPayModifyQuotaUI honeyPayModifyQuotaUI) {
        AppMethodBeat.i(64812);
        if (Util.isNullOrNil(honeyPayModifyQuotaUI.ylE.getText())) {
            honeyPayModifyQuotaUI.qg(false);
            honeyPayModifyQuotaUI.qf(false);
            honeyPayModifyQuotaUI.qh(false);
            AppMethodBeat.o(64812);
            return false;
        }
        int nE = f.nE(honeyPayModifyQuotaUI.ylE.getText(), "100");
        Log.d(honeyPayModifyQuotaUI.TAG, "current fen: %s", Integer.valueOf(nE));
        if (((long) nE) < honeyPayModifyQuotaUI.ykO) {
            honeyPayModifyQuotaUI.qf(true);
            honeyPayModifyQuotaUI.qh(false);
            AppMethodBeat.o(64812);
            return false;
        } else if (((long) nE) > honeyPayModifyQuotaUI.ykN) {
            honeyPayModifyQuotaUI.qg(true);
            honeyPayModifyQuotaUI.qh(false);
            AppMethodBeat.o(64812);
            return false;
        } else if (nE == 0) {
            honeyPayModifyQuotaUI.qh(false);
            AppMethodBeat.o(64812);
            return false;
        } else {
            honeyPayModifyQuotaUI.qg(false);
            honeyPayModifyQuotaUI.qf(false);
            honeyPayModifyQuotaUI.qh(true);
            AppMethodBeat.o(64812);
            return true;
        }
    }

    static /* synthetic */ void b(HoneyPayModifyQuotaUI honeyPayModifyQuotaUI) {
        AppMethodBeat.i(64813);
        Log.i(honeyPayModifyQuotaUI.TAG, "go to check pwd ui");
        long nF = f.nF(honeyPayModifyQuotaUI.ylE.getText(), "100");
        Intent intent = new Intent(honeyPayModifyQuotaUI, HoneyPayCheckPwdUI.class);
        intent.putExtra("key_scene", 2);
        intent.putExtra("key_credit_line", nF);
        intent.putExtra("key_card_no", honeyPayModifyQuotaUI.yjY);
        honeyPayModifyQuotaUI.startActivityForResult(intent, 1);
        AppMethodBeat.o(64813);
    }
}

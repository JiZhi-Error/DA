package com.tencent.mm.plugin.wallet_core.ui;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.q;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.cl;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_core.c.y;
import com.tencent.mm.plugin.wallet_core.model.ElementQuery;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.c.z;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tenpay.android.wechat.MyKeyboardWindow;
import com.tenpay.bankcard.TenpaySegmentEditText;

public class WalletConfirmCardIDUI extends WalletBaseUI {
    private TenpaySegmentEditText IgI;
    private boolean IgJ = true;
    private Button xRO;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.report.MMSecDataActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.c8m;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(70934);
        super.onCreate(bundle);
        initView();
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.wallet_core.ui.WalletConfirmCardIDUI.AnonymousClass1 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(70930);
                if (WalletConfirmCardIDUI.this.needConfirmFinish()) {
                    WalletConfirmCardIDUI.this.hideVKB();
                    WalletConfirmCardIDUI.this.showDialog(1000);
                } else {
                    WalletConfirmCardIDUI.this.finish();
                }
                AppMethodBeat.o(70930);
                return false;
            }
        });
        AppMethodBeat.o(70934);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onDestroy() {
        AppMethodBeat.i(70935);
        super.onDestroy();
        AppMethodBeat.o(70935);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void finish() {
        AppMethodBeat.i(162422);
        super.finish();
        z.hhs();
        getInput().remove("key_bankcard_cropimg");
        AppMethodBeat.o(162422);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(70936);
        String string = getInput().getString("key_bankcard_id");
        String string2 = getInput().getString("key_bankcard_des");
        Bitmap bitmap = (Bitmap) getInput().getParcelable("key_bankcard_cropimg");
        if (TextUtils.isEmpty(string)) {
            Log.e("MicroMsg.WalletConfirmCardIDUI", "cardID is empty");
            finish();
            AppMethodBeat.o(70936);
        } else if (bitmap == null) {
            Log.e("MicroMsg.WalletConfirmCardIDUI", "cardID bitmap is null");
            finish();
            AppMethodBeat.o(70936);
        } else {
            setMMTitle(R.string.ibe);
            this.xRO = (Button) findViewById(R.id.fz0);
            this.IgI = (TenpaySegmentEditText) findViewById(R.id.bvq);
            this.IgI.setText(string, string2);
            this.mKeyboard = (MyKeyboardWindow) findViewById(R.id.ijb);
            this.mKBLayout = findViewById(R.id.ija);
            ((ImageView) findViewById(R.id.an7)).setImageBitmap(bitmap);
            this.IgI.setKeyboard(this.mKeyboard);
            this.mKeyboard.setXMode(0);
            ((InputMethodManager) getContext().getSystemService("input_method")).hideSoftInputFromWindow(this.IgI.getWindowToken(), 0);
            this.mKBLayout.setVisibility(8);
            this.IgI.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.plugin.wallet_core.ui.WalletConfirmCardIDUI.AnonymousClass2 */

                public final void onClick(View view) {
                    AppMethodBeat.i(70931);
                    b bVar = new b();
                    bVar.bm(view);
                    a.b("com/tencent/mm/plugin/wallet_core/ui/WalletConfirmCardIDUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    if (!WalletConfirmCardIDUI.this.mKBLayout.isShown() && !WalletConfirmCardIDUI.this.IgJ) {
                        WalletConfirmCardIDUI.this.mKBLayout.setVisibility(0);
                        WalletConfirmCardIDUI.this.mKeyboard.setVisibility(0);
                    }
                    WalletConfirmCardIDUI.this.IgJ = false;
                    a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletConfirmCardIDUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(70931);
                }
            });
            final String str = this.IgI.get3DesEncrptData();
            this.xRO.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.plugin.wallet_core.ui.WalletConfirmCardIDUI.AnonymousClass3 */

                public final void onClick(View view) {
                    AppMethodBeat.i(70932);
                    b bVar = new b();
                    bVar.bm(view);
                    a.b("com/tencent/mm/plugin/wallet_core/ui/WalletConfirmCardIDUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    String str = WalletConfirmCardIDUI.this.IgI.get3DesEncrptData();
                    if (str == null || !str.equals(str)) {
                        h.INSTANCE.a(11353, 0, 2);
                    } else {
                        h.INSTANCE.a(11353, 0, 1);
                    }
                    WalletConfirmCardIDUI.g(WalletConfirmCardIDUI.this);
                    a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletConfirmCardIDUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(70932);
                }
            });
            this.mKeyboard = (MyKeyboardWindow) findViewById(R.id.ijb);
            this.mKBLayout = findViewById(R.id.ija);
            View findViewById = findViewById(R.id.ijc);
            if (!(this.mKeyboard == null || this.mKBLayout == null)) {
                findViewById.setOnClickListener(new View.OnClickListener() {
                    /* class com.tencent.mm.plugin.wallet_core.ui.WalletConfirmCardIDUI.AnonymousClass4 */

                    public final void onClick(View view) {
                        AppMethodBeat.i(70933);
                        b bVar = new b();
                        bVar.bm(view);
                        a.b("com/tencent/mm/plugin/wallet_core/ui/WalletConfirmCardIDUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                        WalletConfirmCardIDUI.this.hideTenpayKB();
                        a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletConfirmCardIDUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(70933);
                    }
                });
            }
            this.IgI.setFocusable(false);
            this.IgI.setFocusableInTouchMode(true);
            AppMethodBeat.o(70936);
        }
    }

    @Override // com.tencent.mm.wallet_core.ui.WalletBaseUI
    public boolean onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(70937);
        Bundle bundle = new Bundle();
        boolean z = getInput().getBoolean("key_is_reset_with_new_card", false);
        if (i2 == 0 && i3 == 0) {
            if (qVar instanceof y) {
                y yVar = (y) qVar;
                bundle.putBoolean("key_need_area", yVar.fPS());
                bundle.putBoolean("key_need_profession", yVar.fPT());
                bundle.putParcelableArray("key_profession_list", yVar.mProfessions);
                bundle.putBoolean("key_need_country", yVar.HQj == 1);
                bundle.putStringArray("key_country_excludes", yVar.HQk);
                if (yVar.HQf == null) {
                    bundle.putBoolean("key_is_reset_with_new_card", z);
                    bundle.putString("bank_name", "");
                    bundle.putParcelable("elemt_query", new ElementQuery());
                    bundle.putString("key_card_id", this.IgI.getEncryptDataWithHash(false));
                    com.tencent.mm.wallet_core.a.l(this, bundle);
                } else if (!yVar.HQf.HXj || !yVar.HQf.isError()) {
                    bundle.putBoolean("key_is_reset_with_new_card", z);
                    bundle.putString("bank_name", yVar.HQf.ynT);
                    bundle.putParcelable("elemt_query", yVar.HQf);
                    bundle.putString("key_card_id", this.IgI.getEncryptDataWithHash(false));
                    com.tencent.mm.wallet_core.a.l(this, bundle);
                    AppMethodBeat.o(70937);
                    return true;
                } else {
                    com.tencent.mm.ui.base.h.n(this, R.string.i7k, R.string.zb);
                    AppMethodBeat.o(70937);
                    return true;
                }
            }
        } else if (i3 == 1 && (qVar instanceof y)) {
            bundle.putString("bank_name", "");
            bundle.putBoolean("key_is_reset_with_new_card", z);
            bundle.putParcelable("elemt_query", new ElementQuery());
            bundle.putString("key_card_id", this.IgI.getEncryptDataWithHash(false));
            com.tencent.mm.wallet_core.a.l(this, bundle);
            AppMethodBeat.o(70937);
            return true;
        }
        AppMethodBeat.o(70937);
        return false;
    }

    @Override // com.tencent.mm.wallet_core.ui.WalletBaseUI
    public boolean needConfirmFinish() {
        return true;
    }

    static /* synthetic */ void g(WalletConfirmCardIDUI walletConfirmCardIDUI) {
        AppMethodBeat.i(70938);
        TenpaySegmentEditText.setSalt(Long.toString(cl.aWy() / 1000));
        int i2 = walletConfirmCardIDUI.getInput().getInt("entry_scene", -1);
        int i3 = walletConfirmCardIDUI.getInput().getInt("real_name_verify_mode") == 4 ? 1 : 0;
        String string = walletConfirmCardIDUI.getInput().getString("kreq_token");
        if (string == null || string.isEmpty()) {
            walletConfirmCardIDUI.doSceneProgress(new y(walletConfirmCardIDUI.getPayReqKey(), walletConfirmCardIDUI.IgI.getEncryptDataWithHash(false), (PayInfo) walletConfirmCardIDUI.getInput().getParcelable("key_pay_info"), i2, i3));
            AppMethodBeat.o(70938);
            return;
        }
        int i4 = walletConfirmCardIDUI.getInput().getInt("key_bind_scene");
        Log.e("MicroMsg.WalletConfirmCardIDUI", "doNext has token, bind_scene:".concat(String.valueOf(i4)));
        walletConfirmCardIDUI.doSceneProgress(new y(walletConfirmCardIDUI.getPayReqKey(), walletConfirmCardIDUI.IgI.getEncryptDataWithHash(false), (PayInfo) walletConfirmCardIDUI.getInput().getParcelable("key_pay_info"), string, i4, i2, i3));
        AppMethodBeat.o(70938);
    }
}

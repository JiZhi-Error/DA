package com.tencent.mm.plugin.aa.ui;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.q;
import com.tencent.mm.cb.a;
import com.tencent.mm.model.z;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.ui.a.d;
import com.tencent.mm.vending.app.c;
import com.tencent.mm.vending.c.b;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.f;
import com.tencent.mm.wallet_core.ui.formview.EditHintPasswdView;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import com.tenpay.android.wechat.MyKeyboardWindow;

public abstract class BaseAAPresenterActivity extends WalletBaseUI {
    private static final int HARDCODE_TENPAY_KEYBOARD_HEIGHT = a.fromDPToPix(MMApplicationContext.getContext(), 300);
    private c htH = new c();
    protected View jWj;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.report.MMSecDataActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    static /* synthetic */ void a(BaseAAPresenterActivity baseAAPresenterActivity, EditText editText) {
        if (baseAAPresenterActivity.jWj != null) {
            int[] iArr = new int[2];
            editText.getLocationInWindow(iArr);
            int height = iArr[1] + editText.getHeight();
            int height2 = baseAAPresenterActivity.getWindow().getDecorView().getHeight() - baseAAPresenterActivity.getSupportActionBar().getHeight();
            int i2 = height2 - height;
            Log.i("MicroMsg.BaseAAPresenterActivity", "scrollToFormEditPosAfterShowTenPay, editText locationY: %s, height: %s, diff: %s, hardcodeKeyboardHeight: %s", Integer.valueOf(height), Integer.valueOf(height2), Integer.valueOf(i2), Integer.valueOf(HARDCODE_TENPAY_KEYBOARD_HEIGHT));
            if (i2 > 0 && i2 < HARDCODE_TENPAY_KEYBOARD_HEIGHT) {
                int fromDPToPix = (HARDCODE_TENPAY_KEYBOARD_HEIGHT - i2) + a.fromDPToPix((Context) baseAAPresenterActivity, 5);
                Log.i("MicroMsg.BaseAAPresenterActivity", "scrollToFormEditPosAfterShowTenPay, scrollDistance: %s", Integer.valueOf(fromDPToPix));
                baseAAPresenterActivity.jWj.scrollBy(0, fromDPToPix);
            }
        }
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.htH.A(getIntent(), this);
        this.isVKBFirstTimeShown = true;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onResume() {
        super.onResume();
        this.htH.apB(2);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onPause() {
        super.onPause();
        this.htH.apB(3);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onDestroy() {
        super.onDestroy();
        this.htH.onDestroy();
    }

    public final <T extends b<? extends com.tencent.mm.vending.app.a>> T aq(Class<? extends b<? extends com.tencent.mm.vending.app.a>> cls) {
        return (T) this.htH.a(this, cls);
    }

    public final <T extends com.tencent.mm.vending.app.a> T au(Class<? extends com.tencent.mm.vending.app.a> cls) {
        return (T) this.htH.b(this, cls);
    }

    @Override // com.tencent.mm.wallet_core.ui.WalletBaseUI
    public boolean onSceneEnd(int i2, int i3, String str, q qVar) {
        return false;
    }

    @Override // com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void setEditFocusListener(final View view, final int i2, final boolean z, final boolean z2) {
        this.mKeyboard = (MyKeyboardWindow) findViewById(R.id.ijb);
        this.mKBLayout = findViewById(R.id.ija);
        View findViewById = findViewById(R.id.ijc);
        final EditText editText = (EditText) view.findViewById(R.id.jf4);
        if (this.mKeyboard != null && editText != null && this.mKBLayout != null) {
            this.mKBLayout.setVisibility(8);
            f.setNoSystemInputOnEditText(editText);
            editText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                /* class com.tencent.mm.plugin.aa.ui.BaseAAPresenterActivity.AnonymousClass1 */

                public final void onFocusChange(final View view, boolean z) {
                    AppMethodBeat.i(63569);
                    if (!view.isFocused() || z) {
                        new MMHandler().postDelayed(new Runnable() {
                            /* class com.tencent.mm.plugin.aa.ui.BaseAAPresenterActivity.AnonymousClass1.AnonymousClass2 */

                            public final void run() {
                                AppMethodBeat.i(63568);
                                BaseAAPresenterActivity.this.hideTenpayKB();
                                if (z) {
                                    ((InputMethodManager) BaseAAPresenterActivity.this.getContext().getSystemService("input_method")).showSoftInput(editText, 0);
                                }
                                AppMethodBeat.o(63568);
                            }
                        }, 200);
                        AppMethodBeat.o(63569);
                        return;
                    }
                    ((InputMethodManager) BaseAAPresenterActivity.this.getContext().getSystemService("input_method")).hideSoftInputFromWindow(view.getWindowToken(), 0);
                    new MMHandler().postDelayed(new Runnable() {
                        /* class com.tencent.mm.plugin.aa.ui.BaseAAPresenterActivity.AnonymousClass1.AnonymousClass1 */

                        public final void run() {
                            AppMethodBeat.i(63567);
                            if (!BaseAAPresenterActivity.this.mKBLayout.isShown() && view.isShown()) {
                                if (z2) {
                                    BaseAAPresenterActivity.this.showTenpayKB();
                                } else if (!BaseAAPresenterActivity.this.isVKBFirstTimeShown) {
                                    BaseAAPresenterActivity.this.showTenpayKB();
                                }
                                BaseAAPresenterActivity.this.isVKBFirstTimeShown = false;
                                BaseAAPresenterActivity.a(BaseAAPresenterActivity.this, editText);
                            }
                            if ((view instanceof WalletFormView) && Build.VERSION.SDK_INT >= 14) {
                                WalletFormView walletFormView = (WalletFormView) view;
                                if ((z.aUo() || walletFormView.getEncrptType() == 100) && (!z.aUo() || walletFormView.getEncrptType() == 0)) {
                                    BaseAAPresenterActivity.this.mKeyboard.resetSecureAccessibility();
                                    editText.setAccessibilityDelegate(null);
                                } else {
                                    d dVar = new d();
                                    BaseAAPresenterActivity.this.mKeyboard.setSecureAccessibility(dVar);
                                    editText.setAccessibilityDelegate(dVar);
                                }
                            }
                            if ((view instanceof EditHintPasswdView) && Build.VERSION.SDK_INT >= 14) {
                                d dVar2 = new d();
                                BaseAAPresenterActivity.this.mKeyboard.setSecureAccessibility(dVar2);
                                editText.setAccessibilityDelegate(dVar2);
                            }
                            BaseAAPresenterActivity.this.setKBMode(i2);
                            BaseAAPresenterActivity.this.mKeyboard.setInputEditText((EditText) view);
                            ((InputMethodManager) BaseAAPresenterActivity.this.getContext().getSystemService("input_method")).hideSoftInputFromWindow(view.getWindowToken(), 0);
                            AppMethodBeat.o(63567);
                        }
                    }, 300);
                    AppMethodBeat.o(63569);
                }
            });
            editText.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.plugin.aa.ui.BaseAAPresenterActivity.AnonymousClass2 */

                public final void onClick(View view) {
                    AppMethodBeat.i(63570);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/aa/ui/BaseAAPresenterActivity$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    if (!BaseAAPresenterActivity.this.mKBLayout.isShown() && !z) {
                        BaseAAPresenterActivity.this.showTenpayKB();
                        BaseAAPresenterActivity.a(BaseAAPresenterActivity.this, editText);
                        BaseAAPresenterActivity.this.setKBMode(i2);
                    } else if (z) {
                        BaseAAPresenterActivity.this.hideTenpayKB();
                        ((InputMethodManager) BaseAAPresenterActivity.this.getContext().getSystemService("input_method")).showSoftInput(editText, 0);
                    }
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/aa/ui/BaseAAPresenterActivity$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(63570);
                }
            });
            findViewById.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.plugin.aa.ui.BaseAAPresenterActivity.AnonymousClass3 */

                public final void onClick(View view) {
                    AppMethodBeat.i(63571);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/aa/ui/BaseAAPresenterActivity$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    BaseAAPresenterActivity.this.hideTenpayKB();
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/aa/ui/BaseAAPresenterActivity$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(63571);
                }
            });
        }
    }

    @Override // com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void hideTenpayKB() {
        super.hideTenpayKB();
        if (this.jWj != null) {
            this.jWj.scrollTo(0, 0);
        }
    }
}

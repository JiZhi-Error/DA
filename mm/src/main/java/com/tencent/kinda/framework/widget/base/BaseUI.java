package com.tencent.kinda.framework.widget.base;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.cb.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.z;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.ui.a.d;
import com.tencent.mm.wallet_core.ui.f;
import com.tencent.mm.wallet_core.ui.formview.EditHintPasswdView;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import com.tenpay.android.wechat.MyKeyboardWindow;
import com.tenpay.android.wechat.TenpaySecureEditText;

public class BaseUI implements IExtendUI {
    public static final int HARDCODE_TENPAY_KEYBOARD_HEIGHT = a.fromDPToPix(MMApplicationContext.getContext(), 270);
    public static final String TAG = "MicroMsg.BaseUI";
    protected boolean isVKBFirstTimeShown = false;
    protected View mKBLayout;
    protected MyKeyboardWindow mKeyboard;
    private com.tencent.mm.wallet_core.ui.a mTenpayKBStateListener;
    private IBaseUIWrap wrap;

    public interface IBaseUIWrap {
        View findViewById(int i2);

        Context getContext();

        View getCurrentFocus();
    }

    static {
        AppMethodBeat.i(18778);
        AppMethodBeat.o(18778);
    }

    public BaseUI(IBaseUIWrap iBaseUIWrap) {
        this.wrap = iBaseUIWrap;
    }

    @Override // com.tencent.kinda.framework.widget.base.IExtendUI
    public void setEditFocusListener(View view, int i2, boolean z) {
        AppMethodBeat.i(18770);
        setEditFocusListener(view, i2, z, true);
        AppMethodBeat.o(18770);
    }

    @Override // com.tencent.kinda.framework.widget.base.IExtendUI
    @TargetApi(14)
    public void setEditFocusListener(final View view, final int i2, final boolean z, final boolean z2) {
        AppMethodBeat.i(18771);
        this.mKeyboard = (MyKeyboardWindow) this.wrap.findViewById(R.id.ijb);
        this.mKBLayout = this.wrap.findViewById(R.id.ija);
        View findViewById = this.wrap.findViewById(R.id.ijc);
        final EditText editText = view instanceof TenpaySecureEditText ? (EditText) view : (EditText) view.findViewById(R.id.jf4);
        if (this.mKeyboard == null || editText == null || this.mKBLayout == null) {
            AppMethodBeat.o(18771);
            return;
        }
        f.setNoSystemInputOnEditText(editText);
        editText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            /* class com.tencent.kinda.framework.widget.base.BaseUI.AnonymousClass1 */

            public void onFocusChange(final View view, boolean z) {
                AppMethodBeat.i(18766);
                if (!view.isFocused() || z) {
                    new MMHandler().postDelayed(new Runnable() {
                        /* class com.tencent.kinda.framework.widget.base.BaseUI.AnonymousClass1.AnonymousClass2 */

                        public void run() {
                            AppMethodBeat.i(18765);
                            BaseUI.this.hideTenpayKB();
                            ((InputMethodManager) BaseUI.this.wrap.getContext().getSystemService("input_method")).showSoftInput(editText, 0);
                            AppMethodBeat.o(18765);
                        }
                    }, 200);
                    AppMethodBeat.o(18766);
                    return;
                }
                ((InputMethodManager) BaseUI.this.wrap.getContext().getSystemService("input_method")).hideSoftInputFromWindow(view.getWindowToken(), 0);
                new MMHandler().postDelayed(new Runnable() {
                    /* class com.tencent.kinda.framework.widget.base.BaseUI.AnonymousClass1.AnonymousClass1 */

                    public void run() {
                        AppMethodBeat.i(18764);
                        if (!BaseUI.this.mKBLayout.isShown() && view.isShown() && (z2 || BaseUI.this.isVKBFirstTimeShown)) {
                            BaseUI.this.isVKBFirstTimeShown = true;
                            BaseUI.this.showTenpayKB();
                        }
                        if ((view instanceof WalletFormView) && Build.VERSION.SDK_INT >= 14) {
                            WalletFormView walletFormView = (WalletFormView) view;
                            if ((z.aUo() || walletFormView.getEncrptType() == 100) && (!z.aUo() || walletFormView.getEncrptType() == 0)) {
                                BaseUI.this.mKeyboard.resetSecureAccessibility();
                                editText.setAccessibilityDelegate(null);
                            } else {
                                d dVar = new d();
                                BaseUI.this.mKeyboard.setSecureAccessibility(dVar);
                                editText.setAccessibilityDelegate(dVar);
                            }
                        }
                        if ((view instanceof EditHintPasswdView) && Build.VERSION.SDK_INT >= 14) {
                            d dVar2 = new d();
                            BaseUI.this.mKeyboard.setSecureAccessibility(dVar2);
                            editText.setAccessibilityDelegate(dVar2);
                        }
                        BaseUI.this.setKBMode(i2);
                        BaseUI.this.mKeyboard.setInputEditText((EditText) view);
                        ((InputMethodManager) BaseUI.this.wrap.getContext().getSystemService("input_method")).hideSoftInputFromWindow(view.getWindowToken(), 0);
                        AppMethodBeat.o(18764);
                    }
                }, 300);
                AppMethodBeat.o(18766);
            }
        });
        editText.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.kinda.framework.widget.base.BaseUI.AnonymousClass2 */
            private byte _hellAccFlag_;

            public void onClick(View view) {
                AppMethodBeat.i(18767);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/kinda/framework/widget/base/BaseUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (!BaseUI.this.mKBLayout.isShown() && !z) {
                    BaseUI.this.showTenpayKB();
                    BaseUI.this.setKBMode(i2);
                } else if (z) {
                    BaseUI.this.hideTenpayKB();
                    ((InputMethodManager) BaseUI.this.wrap.getContext().getSystemService("input_method")).showSoftInput(editText, 0);
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/kinda/framework/widget/base/BaseUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(18767);
            }
        });
        findViewById.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.kinda.framework.widget.base.BaseUI.AnonymousClass3 */
            private byte _hellAccFlag_;

            public void onClick(View view) {
                AppMethodBeat.i(18768);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/kinda/framework/widget/base/BaseUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                BaseUI.this.hideTenpayKB();
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/kinda/framework/widget/base/BaseUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(18768);
            }
        });
        AppMethodBeat.o(18771);
    }

    /* access modifiers changed from: protected */
    public void setKBMode(int i2) {
        AppMethodBeat.i(18772);
        this.mKeyboard.setXMode(i2);
        AppMethodBeat.o(18772);
    }

    @Override // com.tencent.kinda.framework.widget.base.IExtendUI
    public void setTenpayKBStateListener(com.tencent.mm.wallet_core.ui.a aVar) {
        this.mTenpayKBStateListener = aVar;
    }

    @Override // com.tencent.kinda.framework.widget.base.IExtendUI
    public void hideTenpayKB() {
        AppMethodBeat.i(18773);
        if (this.mKBLayout != null && this.mKBLayout.isShown()) {
            this.mKBLayout.setVisibility(8);
            if (this.mTenpayKBStateListener != null) {
                this.mTenpayKBStateListener.onVisibleStateChange(false);
            }
        }
        AppMethodBeat.o(18773);
    }

    @Override // com.tencent.kinda.framework.widget.base.IExtendUI
    public void showTenpayKB() {
        AppMethodBeat.i(18774);
        if (this.mKBLayout != null && !this.mKBLayout.isShown()) {
            this.mKBLayout.setVisibility(0);
            if (this.mTenpayKBStateListener != null) {
                this.mTenpayKBStateListener.onVisibleStateChange(true);
            }
        }
        AppMethodBeat.o(18774);
    }

    @Override // com.tencent.kinda.framework.widget.base.IExtendUI
    public void scrollToFormEditPosAfterShowTenPay(final View view, View view2, int i2) {
        AppMethodBeat.i(18775);
        if (view != null) {
            int[] iArr = new int[2];
            view2.getLocationInWindow(iArr);
            int height = iArr[1] + view2.getHeight();
            int jo = a.jo(this.wrap.getContext());
            int fromDPToPix = (jo - height) - a.fromDPToPix(this.wrap.getContext(), i2);
            Log.d(TAG, "scrollToFormEditPosAfterShowTenPay, editText locationY: %s, height: %s, diff: %s, hardcodeKeyboardHeight: %s", Integer.valueOf(height), Integer.valueOf(jo), Integer.valueOf(fromDPToPix), Integer.valueOf(HARDCODE_TENPAY_KEYBOARD_HEIGHT));
            if (fromDPToPix > 0 && fromDPToPix < HARDCODE_TENPAY_KEYBOARD_HEIGHT) {
                final int i3 = HARDCODE_TENPAY_KEYBOARD_HEIGHT - fromDPToPix;
                Log.d(TAG, "scrollToFormEditPosAfterShowTenPay, scrollDistance: %s", Integer.valueOf(i3));
                view.post(new Runnable() {
                    /* class com.tencent.kinda.framework.widget.base.BaseUI.AnonymousClass4 */

                    public void run() {
                        AppMethodBeat.i(18769);
                        view.scrollBy(0, i3);
                        AppMethodBeat.o(18769);
                    }
                });
            }
        }
        AppMethodBeat.o(18775);
    }

    @Override // com.tencent.kinda.framework.widget.base.IExtendUI
    public void scrollTo(View view, int i2, int i3) {
        AppMethodBeat.i(18776);
        if (view != null) {
            view.scrollTo(i2, i3);
        }
        AppMethodBeat.o(18776);
    }

    @Override // com.tencent.kinda.framework.widget.base.IExtendUI
    public void showVKB() {
        AppMethodBeat.i(18777);
        InputMethodManager inputMethodManager = (InputMethodManager) this.wrap.getContext().getSystemService("input_method");
        if (inputMethodManager == null) {
            AppMethodBeat.o(18777);
            return;
        }
        View currentFocus = this.wrap.getCurrentFocus();
        if (currentFocus == null) {
            AppMethodBeat.o(18777);
        } else if (currentFocus.getWindowToken() == null) {
            AppMethodBeat.o(18777);
        } else {
            inputMethodManager.toggleSoftInput(0, 2);
            AppMethodBeat.o(18777);
        }
    }
}

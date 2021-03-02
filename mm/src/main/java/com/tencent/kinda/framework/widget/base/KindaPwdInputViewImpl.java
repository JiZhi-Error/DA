package com.tencent.kinda.framework.widget.base;

import android.content.Context;
import com.tencent.kinda.gen.KPwdInputView;
import com.tencent.kinda.gen.KPwdInputViewOnEndEnterPasswordCallback;
import com.tencent.kinda.gen.KPwdInputViewOnPasswordChangeCallback;
import com.tencent.kinda.gen.PwdViewStyle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.wallet_core.ui.f;
import com.tencent.mm.wallet_core.ui.formview.EditHintPasswdView;
import com.tencent.mm.wallet_core.ui.formview.a;
import com.tenpay.android.wechat.TenpaySecureEditText;

public class KindaPwdInputViewImpl extends MMKView<EditHintPasswdView> implements KPwdInputView {
    private KPwdInputViewOnPasswordChangeCallback pwdChangeCallback;
    private KPwdInputViewOnEndEnterPasswordCallback pwdEndCallback;
    private PwdViewStyle pwdStyle = PwdViewStyle.CHECKPWDSTYLE;
    private EditHintPasswdView pwdView;

    @Override // com.tencent.kinda.framework.widget.base.MMKView
    public EditHintPasswdView createView(Context context) {
        AppMethodBeat.i(18933);
        this.pwdView = new EditHintPasswdView(context);
        if (this.pwdStyle == PwdViewStyle.CHECKPWDSTYLE) {
            this.pwdView.aqo(1);
        } else {
            this.pwdView.aqo(0);
        }
        a.a(this.pwdView);
        if (context instanceof BaseFrActivity) {
            ((BaseFrActivity) context).setEditFocusListener(this.pwdView, 0, false);
        }
        this.pwdView.setOnInputValidListener(new EditHintPasswdView.a() {
            /* class com.tencent.kinda.framework.widget.base.KindaPwdInputViewImpl.AnonymousClass1 */

            @Override // com.tencent.mm.wallet_core.ui.formview.EditHintPasswdView.a
            public void onInputValidChange(boolean z) {
                AppMethodBeat.i(18931);
                if (KindaPwdInputViewImpl.this.pwdView.mEditText != null) {
                    TenpaySecureEditText.setSalt(f.hhV());
                }
                if (z) {
                    KindaPwdInputViewImpl.this.pwdView.getText();
                    if (KindaPwdInputViewImpl.this.pwdEndCallback != null) {
                        KindaPwdInputViewImpl.this.pwdEndCallback.onEndEnterPassword(KindaPwdInputViewImpl.this.pwdView.getText(), KindaPwdInputViewImpl.this.pwdView.getMd5Value());
                    }
                    if (KindaPwdInputViewImpl.this.pwdChangeCallback != null) {
                        KindaPwdInputViewImpl.this.pwdChangeCallback.onPasswordChange(6, KindaPwdInputViewImpl.this.pwdView.getText(), KindaPwdInputViewImpl.this.pwdView.getMd5Value());
                    }
                    AppMethodBeat.o(18931);
                    return;
                }
                if (KindaPwdInputViewImpl.this.pwdChangeCallback != null) {
                    KindaPwdInputViewImpl.this.pwdChangeCallback.onPasswordChange(0, KindaPwdInputViewImpl.this.pwdView.getText(), KindaPwdInputViewImpl.this.pwdView.getMd5Value());
                }
                AppMethodBeat.o(18931);
            }
        });
        EditHintPasswdView editHintPasswdView = this.pwdView;
        AppMethodBeat.o(18933);
        return editHintPasswdView;
    }

    @Override // com.tencent.kinda.gen.KPwdInputView
    public void setTextLength(long j2) {
    }

    @Override // com.tencent.kinda.gen.KPwdInputView
    public long getTextLength() {
        return 0;
    }

    @Override // com.tencent.kinda.gen.KPwdInputView
    public void setFocus(boolean z) {
        AppMethodBeat.i(18934);
        if (z && this.pwdView.getVisibility() == 0 && !this.pwdView.hasFocus()) {
            MMHandlerThread.postToMainThread(new Runnable() {
                /* class com.tencent.kinda.framework.widget.base.KindaPwdInputViewImpl.AnonymousClass2 */

                public void run() {
                    AppMethodBeat.i(18932);
                    KindaPwdInputViewImpl.this.pwdView.requestFocus();
                    AppMethodBeat.o(18932);
                }
            });
        }
        AppMethodBeat.o(18934);
    }

    @Override // com.tencent.kinda.gen.KPwdInputView
    public boolean getFocus() {
        return false;
    }

    @Override // com.tencent.kinda.gen.KPwdInputView
    public void setHashData(String str) {
    }

    @Override // com.tencent.kinda.gen.KPwdInputView
    public String getHashData() {
        return null;
    }

    @Override // com.tencent.kinda.gen.KPwdInputView
    public void setChearInput(boolean z) {
        AppMethodBeat.i(18935);
        if (z) {
            this.pwdView.eIj();
        }
        AppMethodBeat.o(18935);
    }

    @Override // com.tencent.kinda.gen.KPwdInputView
    public boolean getChearInput() {
        return false;
    }

    @Override // com.tencent.kinda.gen.KPwdInputView
    public void setAutoRemarkKeyBoradType(boolean z) {
    }

    @Override // com.tencent.kinda.gen.KPwdInputView
    public boolean getAutoRemarkKeyBoradType() {
        return false;
    }

    @Override // com.tencent.kinda.gen.KPwdInputView
    public void setPwdStyle(PwdViewStyle pwdViewStyle) {
        AppMethodBeat.i(214496);
        Log.d(MMKView.TAG, "set pwd: %s", pwdViewStyle);
        this.pwdStyle = pwdViewStyle;
        if (this.pwdStyle == PwdViewStyle.CHECKPWDSTYLE) {
            this.pwdView.aqo(1);
            AppMethodBeat.o(214496);
            return;
        }
        this.pwdView.aqo(0);
        AppMethodBeat.o(214496);
    }

    @Override // com.tencent.kinda.gen.KPwdInputView
    public PwdViewStyle getPwdStyle() {
        return this.pwdStyle;
    }

    @Override // com.tencent.kinda.gen.KPwdInputView
    public void setOnEndEnterPasswordCallback(KPwdInputViewOnEndEnterPasswordCallback kPwdInputViewOnEndEnterPasswordCallback) {
        if (kPwdInputViewOnEndEnterPasswordCallback != null) {
            this.pwdEndCallback = kPwdInputViewOnEndEnterPasswordCallback;
        }
    }

    @Override // com.tencent.kinda.gen.KPwdInputView
    public void setOnPasswordChangeCallback(KPwdInputViewOnPasswordChangeCallback kPwdInputViewOnPasswordChangeCallback) {
        if (kPwdInputViewOnPasswordChangeCallback != null) {
            this.pwdChangeCallback = kPwdInputViewOnPasswordChangeCallback;
        }
    }
}

package com.tencent.kinda.framework.widget.base;

import android.content.Context;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import com.tencent.kinda.framework.widget.tools.ColorUtil;
import com.tencent.kinda.framework.widget.tools.MMKViewUtil;
import com.tencent.kinda.gen.DynamicColor;
import com.tencent.kinda.gen.KCardNumberEditView;
import com.tencent.kinda.gen.KCardNumberEditViewOnTextChangedCallback;
import com.tencent.kinda.gen.KViewOnClickCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.at;
import com.tencent.mm.wallet_core.b;
import com.tencent.mm.wallet_core.ui.f;
import com.tenpay.android.wechat.TenpaySecureEditText;

public class KindaCardNumberEditViewImpl extends MMKView<TenpaySecureEditText> implements KCardNumberEditView {
    private TenpaySecureEditText cardNumberView = null;
    private DynamicColor hintColor = new DynamicColor(-1, 0);
    private KCardNumberEditViewOnTextChangedCallback m_callback;
    private DynamicColor normalColor = new DynamicColor(-1, 0);

    public KindaCardNumberEditViewImpl() {
        AppMethodBeat.i(18874);
        AppMethodBeat.o(18874);
    }

    @Override // com.tencent.kinda.framework.widget.base.MMKView
    public TenpaySecureEditText createView(Context context) {
        AppMethodBeat.i(18875);
        this.cardNumberView = new TenpaySecureEditText(context);
        this.cardNumberView.setIsBankcardFormat(true);
        this.cardNumberView.setBackground(null);
        this.cardNumberView.setInputType(131072);
        this.cardNumberView.setSingleLine(false);
        this.cardNumberView.setTextSize(0, MMKViewUtil.dpToPx(MMApplicationContext.getContext(), 17.0f));
        this.cardNumberView.setPadding(0, 0, at.fromDPToPix(context, 4), 0);
        this.cardNumberView.setCursorStyle(R.drawable.a70);
        this.cardNumberView.setregExFilterInput("[^0-9]");
        if (ColorUtil.ifCompatKindaDarkModeDefaultColor()) {
            this.cardNumberView.setClearBtnDrawableId(R.raw.kinda_actionbar_icon_light_clear, 0, 16, 16);
        } else {
            this.cardNumberView.setClearBtnDrawableId(R.raw.kinda_actionbar_icon_dark_clear, 0, 16, 16);
        }
        TenpaySecureEditText.setSalt(f.hhV());
        this.cardNumberView.setFilters(new InputFilter[]{new InputFilter.LengthFilter(24)});
        this.cardNumberView.addTextChangedListener(new TextWatcher() {
            /* class com.tencent.kinda.framework.widget.base.KindaCardNumberEditViewImpl.AnonymousClass1 */

            public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                AppMethodBeat.i(18873);
                if (KindaCardNumberEditViewImpl.this.m_callback != null) {
                    KCardNumberEditViewOnTextChangedCallback kCardNumberEditViewOnTextChangedCallback = KindaCardNumberEditViewImpl.this.m_callback;
                    TenpaySecureEditText tenpaySecureEditText = KindaCardNumberEditViewImpl.this.cardNumberView;
                    b.hgC();
                    kCardNumberEditViewOnTextChangedCallback.onTextChanged(tenpaySecureEditText.getEncryptDataWithHash(false, b.hgD()));
                }
                AppMethodBeat.o(18873);
            }

            public void afterTextChanged(Editable editable) {
            }
        });
        if (context instanceof BaseFrActivity) {
            ((BaseFrActivity) context).setEditFocusListener(this.cardNumberView, 0, false);
        }
        this.cardNumberView.setId(R.id.e6j);
        this.cardNumberView.setKindaEditTextCallBackListener(new TenpaySecureEditText.IKindaEditTextCallBackListener() {
            /* class com.tencent.kinda.framework.widget.base.KindaCardNumberEditViewImpl.AnonymousClass2 */

            @Override // com.tenpay.android.wechat.TenpaySecureEditText.IKindaEditTextCallBackListener
            public void onCallBackKinda() {
                AppMethodBeat.i(214467);
                KViewOnClickCallback onClickCallback = KindaCardNumberEditViewImpl.this.getOnClickCallback();
                if (onClickCallback != null) {
                    onClickCallback.onClick(KindaCardNumberEditViewImpl.this);
                }
                AppMethodBeat.o(214467);
            }
        });
        TenpaySecureEditText tenpaySecureEditText = this.cardNumberView;
        AppMethodBeat.o(18875);
        return tenpaySecureEditText;
    }

    @Override // com.tencent.kinda.gen.KCardNumberEditView
    public String getValue() {
        AppMethodBeat.i(18876);
        TenpaySecureEditText tenpaySecureEditText = this.cardNumberView;
        b.hgC();
        String encryptDataWithHash = tenpaySecureEditText.getEncryptDataWithHash(false, b.hgD());
        AppMethodBeat.o(18876);
        return encryptDataWithHash;
    }

    @Override // com.tencent.kinda.gen.KCardNumberEditView
    public boolean isBankCardNumber() {
        AppMethodBeat.i(18877);
        boolean isBankcardNum = this.cardNumberView.isBankcardNum();
        AppMethodBeat.o(18877);
        return isBankcardNum;
    }

    @Override // com.tencent.kinda.gen.KCardNumberEditView
    public int getInputTextLength() {
        AppMethodBeat.i(18878);
        int inputLength = this.cardNumberView.getInputLength();
        AppMethodBeat.o(18878);
        return inputLength;
    }

    @Override // com.tencent.kinda.gen.KCardNumberEditView
    public void setText(String str) {
        AppMethodBeat.i(18879);
        this.cardNumberView.setText(str);
        this.cardNumberView.setSelection(this.cardNumberView.getText().toString().length());
        this.cardNumberView.clearFocus();
        AppMethodBeat.o(18879);
    }

    @Override // com.tencent.kinda.gen.KCardNumberEditView
    public void setTextColor(DynamicColor dynamicColor) {
        AppMethodBeat.i(18880);
        if (ColorUtil.getColorByModeNoCompat(this.normalColor) != ColorUtil.getColorByMode(dynamicColor)) {
            this.normalColor = dynamicColor;
        }
        this.cardNumberView.setTextColor((int) ColorUtil.getColorByModeNoCompat(this.normalColor));
        AppMethodBeat.o(18880);
    }

    @Override // com.tencent.kinda.gen.KCardNumberEditView
    public DynamicColor getTextColor() {
        return this.normalColor;
    }

    @Override // com.tencent.kinda.gen.KCardNumberEditView
    public void setFocus(boolean z) {
        AppMethodBeat.i(18881);
        if (z && this.cardNumberView.isFocused()) {
            this.cardNumberView.clearFocus();
        }
        if (z) {
            this.cardNumberView.requestFocus();
            AppMethodBeat.o(18881);
            return;
        }
        this.cardNumberView.clearFocus();
        AppMethodBeat.o(18881);
    }

    @Override // com.tencent.kinda.gen.KCardNumberEditView
    public boolean getFocus() {
        AppMethodBeat.i(18882);
        boolean isFocused = this.cardNumberView.isFocused();
        AppMethodBeat.o(18882);
        return isFocused;
    }

    @Override // com.tencent.kinda.gen.KCardNumberEditView
    public void setHint(String str) {
        AppMethodBeat.i(18883);
        this.cardNumberView.setHint(str);
        AppMethodBeat.o(18883);
    }

    @Override // com.tencent.kinda.gen.KCardNumberEditView
    public String getHint() {
        AppMethodBeat.i(18884);
        String charSequence = this.cardNumberView.getHint().toString();
        AppMethodBeat.o(18884);
        return charSequence;
    }

    @Override // com.tencent.kinda.gen.KCardNumberEditView
    public void setHintColor(DynamicColor dynamicColor) {
        AppMethodBeat.i(18885);
        if (ColorUtil.getColorByModeNoCompat(this.hintColor) != ColorUtil.getColorByMode(dynamicColor)) {
            this.hintColor = dynamicColor;
        }
        this.cardNumberView.setHintTextColor((int) ColorUtil.getColorByModeNoCompat(this.hintColor));
        AppMethodBeat.o(18885);
    }

    @Override // com.tencent.kinda.gen.KCardNumberEditView
    public DynamicColor getHintColor() {
        return this.hintColor;
    }

    @Override // com.tencent.kinda.gen.KCardNumberEditView
    public void setOnTextChangedCallback(KCardNumberEditViewOnTextChangedCallback kCardNumberEditViewOnTextChangedCallback) {
        this.m_callback = kCardNumberEditViewOnTextChangedCallback;
    }
}

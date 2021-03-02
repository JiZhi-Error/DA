package com.tencent.kinda.framework.widget.base;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.view.View;
import android.widget.LinearLayout;
import com.tencent.kinda.framework.widget.tools.ColorUtil;
import com.tencent.kinda.framework.widget.tools.MMKViewUtil;
import com.tencent.kinda.gen.ClearButtonMode;
import com.tencent.kinda.gen.DynamicColor;
import com.tencent.kinda.gen.KSecureEditText;
import com.tencent.kinda.gen.KSecureEditTextOnTextChangedCallback;
import com.tencent.kinda.gen.KeyboardType;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.pluginsdk.ui.wallet.WalletIconImageView;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.at;
import com.tencent.mm.wallet_core.ui.f;
import com.tenpay.android.wechat.TenpaySecureEditText;

public class KindaSecureEditTextImpl extends MMKView<LinearLayout> implements KSecureEditText {
    private ClearButtonMode clearButtonMode = ClearButtonMode.WHILEEDITING;
    private TenpaySecureEditText editText;
    private WalletIconImageView iconImageView;
    private BaseFrActivity mContext;
    private KeyboardType mKeyboardType;
    private int m_maxLength = Integer.MAX_VALUE;
    private KSecureEditTextOnTextChangedCallback onTextChangedCallback;

    @Override // com.tencent.kinda.framework.widget.base.MMKView
    public LinearLayout createView(Context context) {
        AppMethodBeat.i(18949);
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setGravity(16);
        this.editText = new TenpaySecureEditText(context);
        this.editText.setSingleLine();
        this.editText.setBackground(null);
        this.editText.setTextSize(0, MMKViewUtil.dpToPx(MMApplicationContext.getContext(), 17.0f));
        TenpaySecureEditText.setSalt(f.hhV());
        this.editText.setPadding(0, 0, 0, 0);
        this.editText.setCursorStyle(R.drawable.a70);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
        layoutParams.weight = 1.0f;
        linearLayout.addView(this.editText, layoutParams);
        if (context instanceof BaseFrActivity) {
            this.mContext = (BaseFrActivity) context;
            this.mContext.setEditFocusListener(this.editText, 0, false);
            this.editText.setTag(this);
        }
        if (ColorUtil.ifCompatKindaDarkModeDefaultColor()) {
            this.editText.setHintTextColor(context.getResources().getColor(R.color.uj));
            this.editText.setTextColor(context.getResources().getColor(R.color.a2x));
        }
        this.iconImageView = new WalletIconImageView(context);
        this.iconImageView.setClearBtnDrawableId$255f295(context.getResources().getColor(R.color.en));
        this.iconImageView.setToClearState(new View.OnClickListener() {
            /* class com.tencent.kinda.framework.widget.base.KindaSecureEditTextImpl.AnonymousClass1 */
            private byte _hellAccFlag_;

            public void onClick(View view) {
                AppMethodBeat.i(18946);
                b bVar = new b();
                bVar.bm(view);
                a.b("com/tencent/kinda/framework/widget/base/KindaSecureEditTextImpl$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                KindaSecureEditTextImpl.this.editText.setText("");
                a.a(this, "com/tencent/kinda/framework/widget/base/KindaSecureEditTextImpl$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(18946);
            }
        });
        this.iconImageView.setVisibility(4);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(at.fromDPToPix(context, 16), at.fromDPToPix(context, 16));
        layoutParams2.setMargins(0, 0, at.fromDPToPix(context, 4), 0);
        linearLayout.addView(this.iconImageView, layoutParams2);
        this.editText.addTextChangedListener(new TextWatcher() {
            /* class com.tencent.kinda.framework.widget.base.KindaSecureEditTextImpl.AnonymousClass2 */

            public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                AppMethodBeat.i(18947);
                if (KindaSecureEditTextImpl.this.clearButtonMode == ClearButtonMode.NEVER) {
                    AppMethodBeat.o(18947);
                } else if (charSequence.length() <= 0 || KindaSecureEditTextImpl.this.clearButtonMode != ClearButtonMode.WHILEEDITING) {
                    KindaSecureEditTextImpl.this.iconImageView.setVisibility(4);
                    AppMethodBeat.o(18947);
                } else {
                    KindaSecureEditTextImpl.this.iconImageView.setVisibility(0);
                    AppMethodBeat.o(18947);
                }
            }

            public void afterTextChanged(Editable editable) {
                AppMethodBeat.i(18948);
                if (!(KindaSecureEditTextImpl.this.onTextChangedCallback == null || editable == null)) {
                    KindaSecureEditTextImpl.this.onTextChangedCallback.onTextChanged(editable.toString());
                }
                AppMethodBeat.o(18948);
            }
        });
        AppMethodBeat.o(18949);
        return linearLayout;
    }

    @Override // com.tencent.kinda.gen.KSecureEditText
    public void setText(String str) {
        AppMethodBeat.i(18950);
        this.editText.setText(str);
        AppMethodBeat.o(18950);
    }

    @Override // com.tencent.kinda.gen.KSecureEditText
    public String getText() {
        AppMethodBeat.i(18951);
        String str = this.editText.get3DesEncrptData();
        AppMethodBeat.o(18951);
        return str;
    }

    @Override // com.tencent.kinda.gen.KSecureEditText
    public void setHint(String str) {
        AppMethodBeat.i(18952);
        this.editText.setHint(str);
        AppMethodBeat.o(18952);
    }

    @Override // com.tencent.kinda.gen.KSecureEditText
    public String getHint() {
        AppMethodBeat.i(18953);
        String charSequence = this.editText.getHint().toString();
        AppMethodBeat.o(18953);
        return charSequence;
    }

    @Override // com.tencent.kinda.gen.KSecureEditText
    public void setFocus(boolean z) {
        AppMethodBeat.i(18954);
        if (z) {
            this.editText.requestFocus();
            AppMethodBeat.o(18954);
            return;
        }
        this.editText.clearFocus();
        AppMethodBeat.o(18954);
    }

    @Override // com.tencent.kinda.gen.KSecureEditText
    public boolean getFocus() {
        AppMethodBeat.i(18955);
        boolean isFocused = this.editText.isFocused();
        AppMethodBeat.o(18955);
        return isFocused;
    }

    @Override // com.tencent.kinda.gen.KSecureEditText
    public void setTintColor(DynamicColor dynamicColor) {
    }

    @Override // com.tencent.kinda.gen.KSecureEditText
    public DynamicColor getTintColor() {
        return null;
    }

    @Override // com.tencent.kinda.gen.KSecureEditText
    public void setClearButtonMode(ClearButtonMode clearButtonMode2) {
        AppMethodBeat.i(18956);
        this.clearButtonMode = clearButtonMode2;
        if (clearButtonMode2 == ClearButtonMode.NEVER) {
            this.iconImageView.setVisibility(8);
            AppMethodBeat.o(18956);
            return;
        }
        if (!(clearButtonMode2 == ClearButtonMode.WHILEEDITING || clearButtonMode2 == ClearButtonMode.UNLESSEDITING)) {
            if (clearButtonMode2 == ClearButtonMode.ALWAYS) {
                this.iconImageView.setVisibility(0);
                AppMethodBeat.o(18956);
                return;
            }
            this.iconImageView.setVisibility(4);
        }
        AppMethodBeat.o(18956);
    }

    @Override // com.tencent.kinda.gen.KSecureEditText
    public ClearButtonMode getClearButtonMode() {
        return this.clearButtonMode;
    }

    @Override // com.tencent.kinda.gen.KSecureEditText
    public void setTextColor(DynamicColor dynamicColor) {
        AppMethodBeat.i(18957);
        this.editText.setTextColor((int) ColorUtil.getColorByMode(dynamicColor));
        AppMethodBeat.o(18957);
    }

    @Override // com.tencent.kinda.gen.KSecureEditText
    public DynamicColor getTextColor() {
        AppMethodBeat.i(18958);
        DynamicColor dynamicColor = new DynamicColor((long) this.editText.getCurrentTextColor(), 0);
        AppMethodBeat.o(18958);
        return dynamicColor;
    }

    @Override // com.tencent.kinda.gen.KSecureEditText
    public void setOnTextChangedCallback(KSecureEditTextOnTextChangedCallback kSecureEditTextOnTextChangedCallback) {
        this.onTextChangedCallback = kSecureEditTextOnTextChangedCallback;
    }

    @Override // com.tencent.kinda.gen.KSecureEditText
    public void setKeyboardType(KeyboardType keyboardType) {
        AppMethodBeat.i(18959);
        this.mKeyboardType = keyboardType;
        if (keyboardType == KeyboardType.ID || keyboardType == KeyboardType.CRETAIL) {
            this.mContext.setEditFocusListener(this.editText, 1, false);
        } else if (keyboardType == KeyboardType.NORMAL) {
            this.mContext.setEditFocusListener(this.editText, 0, true);
        }
        setregExFilterInput(keyboardType);
        AppMethodBeat.o(18959);
    }

    public void setVisibleClearIcon(boolean z) {
        AppMethodBeat.i(170117);
        if (z) {
            this.iconImageView.setVisibility(0);
            AppMethodBeat.o(170117);
            return;
        }
        this.iconImageView.setVisibility(4);
        AppMethodBeat.o(170117);
    }

    @Override // com.tencent.kinda.gen.KSecureEditText
    public KeyboardType getKeyboardType() {
        return this.mKeyboardType;
    }

    @Override // com.tencent.kinda.gen.KSecureEditText
    public boolean isCardFromatValid(int i2) {
        AppMethodBeat.i(18960);
        boolean isAreaIDCardNum = this.editText.isAreaIDCardNum(i2);
        AppMethodBeat.o(18960);
        return isAreaIDCardNum;
    }

    @Override // com.tencent.kinda.gen.KSecureEditText
    public void setDefaultValue(String str) {
    }

    @Override // com.tencent.kinda.gen.KSecureEditText
    public String getDefaultValue() {
        return "";
    }

    @Override // com.tencent.kinda.gen.KSecureEditText
    public void setEnabled(boolean z) {
        AppMethodBeat.i(18961);
        this.editText.setEnabled(z);
        AppMethodBeat.o(18961);
    }

    @Override // com.tencent.kinda.gen.KSecureEditText
    public boolean getEnabled() {
        AppMethodBeat.i(18962);
        boolean isEnabled = this.editText.isEnabled();
        AppMethodBeat.o(18962);
        return isEnabled;
    }

    @Override // com.tencent.kinda.gen.KSecureEditText
    public void setMaxLength(int i2) {
        AppMethodBeat.i(18963);
        this.m_maxLength = i2;
        this.editText.setFilters(new InputFilter[]{new InputFilter.LengthFilter(i2)});
        AppMethodBeat.o(18963);
    }

    @Override // com.tencent.kinda.gen.KSecureEditText
    public int getMaxLength() {
        return this.m_maxLength;
    }

    @Override // com.tencent.kinda.gen.KView, com.tencent.kinda.framework.widget.base.MMKView
    @SuppressLint({"ResourceType"})
    public void setViewId(String str) {
        AppMethodBeat.i(214497);
        super.setViewId(str);
        if (this.iconImageView != null) {
            MMKViewUtil.setId4KindaImplView(this.mContext, str + "_btn", this.iconImageView);
        }
        AppMethodBeat.o(214497);
    }

    private void setregExFilterInput(KeyboardType keyboardType) {
        AppMethodBeat.i(214498);
        if (keyboardType == KeyboardType.ID || keyboardType == KeyboardType.CRETAIL) {
            this.editText.setregExFilterInput("[^a-zA-Z0-9]");
            AppMethodBeat.o(214498);
            return;
        }
        if (keyboardType == KeyboardType.NUMBER) {
            this.editText.setregExFilterInput("[^0-9]");
        }
        AppMethodBeat.o(214498);
    }
}

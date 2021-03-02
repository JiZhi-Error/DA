package com.tencent.kinda.framework.widget.base;

import android.content.Context;
import android.graphics.Typeface;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.kinda.framework.widget.tools.ColorUtil;
import com.tencent.kinda.framework.widget.tools.KindaWcKeyboardHelpr;
import com.tencent.kinda.framework.widget.tools.MMKViewUtil;
import com.tencent.kinda.gen.ClearButtonMode;
import com.tencent.kinda.gen.DynamicColor;
import com.tencent.kinda.gen.EditTextRestrictType;
import com.tencent.kinda.gen.KEditText;
import com.tencent.kinda.gen.KEditTextOnTextBeginChangeCallback;
import com.tencent.kinda.gen.KEditTextOnTextChangedCallback;
import com.tencent.kinda.gen.KEditTextOnTextEndEditingCallback;
import com.tencent.kinda.gen.KViewOnClickCallback;
import com.tencent.kinda.gen.KeyboardType;
import com.tencent.kinda.gen.TextAlign;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.framework.app.UIPageFragmentActivity;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.cl;
import com.tencent.mm.pluginsdk.ui.wallet.WalletIconImageView;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.at;
import com.tencent.mm.wallet_core.ui.f;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import com.tenpay.android.wechat.TenpaySecureEditText;
import com.tenpay.android.wechat.TenpaySecureEncrypt;

public class MMKEditText extends MMKView<LinearLayout> implements KEditText {
    private ClearButtonMode clearButtonMode = ClearButtonMode.WHILEEDITING;
    protected TenpaySecureEditText editText;
    private DynamicColor hintColor = new DynamicColor(0, 0);
    private WalletIconImageView iconImageView;
    private KeyboardType keyboardType = KeyboardType.NORMAL;
    protected BaseFrActivity mBaseFrActivity = null;
    protected KEditTextOnTextEndEditingCallback mKEditTextOnTextEndEditingCallback;
    private EditTextRestrictType mRestriceType;
    private int maxLength = -1;
    protected KEditTextOnTextBeginChangeCallback onTextBeginChangeCallback;
    protected KEditTextOnTextChangedCallback onTextChangedCallback;
    private TextAlign textAlign;
    private DynamicColor textColor = new DynamicColor(0, 0);
    private String textFontName;
    private float textSize;

    public MMKEditText() {
        AppMethodBeat.i(19021);
        AppMethodBeat.o(19021);
    }

    @Override // com.tencent.kinda.framework.widget.base.MMKView
    public LinearLayout createView(Context context) {
        AppMethodBeat.i(19022);
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setGravity(16);
        this.editText = new TenpaySecureEditText(context);
        this.editText.setSingleLine();
        this.editText.setBackground(null);
        this.editText.setTextSize(0, MMKViewUtil.dpToPx(MMApplicationContext.getContext(), 17.0f));
        this.editText.setTag(this);
        this.editText.setCursorStyle(R.drawable.a70);
        this.editText.setPadding(0, 0, 0, 0);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
        layoutParams.weight = 1.0f;
        linearLayout.addView(this.editText, layoutParams);
        this.iconImageView = new WalletIconImageView(context);
        this.iconImageView.setClearBtnDrawableId$255f295(context.getResources().getColor(R.color.en));
        this.iconImageView.setToClearState(new View.OnClickListener() {
            /* class com.tencent.kinda.framework.widget.base.MMKEditText.AnonymousClass1 */
            private byte _hellAccFlag_;

            public void onClick(View view) {
                AppMethodBeat.i(19015);
                b bVar = new b();
                bVar.bm(view);
                a.b("com/tencent/kinda/framework/widget/base/MMKEditText$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                MMKEditText.this.editText.setText("");
                a.a(this, "com/tencent/kinda/framework/widget/base/MMKEditText$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(19015);
            }
        });
        this.iconImageView.setVisibility(8);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(at.fromDPToPix(context, 16), at.fromDPToPix(context, 16));
        layoutParams2.setMargins(0, 0, at.fromDPToPix(context, 4), 0);
        linearLayout.addView(this.iconImageView, layoutParams2);
        if (context instanceof BaseFrActivity) {
            this.mBaseFrActivity = (BaseFrActivity) context;
        }
        this.editText.addTextChangedListener(new TextWatcher() {
            /* class com.tencent.kinda.framework.widget.base.MMKEditText.AnonymousClass2 */

            public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                AppMethodBeat.i(19016);
                if (!(MMKEditText.this.onTextBeginChangeCallback == null || charSequence == null)) {
                    MMKEditText.this.onTextBeginChangeCallback.onTextBeginChange(charSequence.toString());
                }
                AppMethodBeat.o(19016);
            }

            public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                AppMethodBeat.i(19017);
                if (MMKEditText.this.clearButtonMode == ClearButtonMode.NEVER) {
                    MMKEditText.this.iconImageView.setVisibility(8);
                    AppMethodBeat.o(19017);
                } else if (charSequence == null || charSequence.length() <= 0 || MMKEditText.this.clearButtonMode != ClearButtonMode.WHILEEDITING) {
                    MMKEditText.this.iconImageView.setVisibility(4);
                    AppMethodBeat.o(19017);
                } else {
                    MMKEditText.this.iconImageView.setVisibility(0);
                    AppMethodBeat.o(19017);
                }
            }

            public void afterTextChanged(Editable editable) {
                AppMethodBeat.i(19018);
                if (!(MMKEditText.this.onTextChangedCallback == null || editable == null)) {
                    MMKEditText.this.onTextChangedCallback.onTextChanged(editable.toString());
                }
                AppMethodBeat.o(19018);
            }
        });
        this.editText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            /* class com.tencent.kinda.framework.widget.base.MMKEditText.AnonymousClass3 */

            public void onFocusChange(View view, boolean z) {
                AppMethodBeat.i(170122);
                boolean z2 = MMKEditText.this.clearButtonMode == ClearButtonMode.WHILEEDITING || MMKEditText.this.clearButtonMode == ClearButtonMode.ALWAYS || MMKEditText.this.clearButtonMode == ClearButtonMode.UNLESSEDITING;
                if (!z || MMKEditText.this.editText.getText().length() <= 0 || !z2) {
                    MMKEditText.this.iconImageView.setVisibility(4);
                    AppMethodBeat.o(170122);
                    return;
                }
                MMKEditText.this.iconImageView.setVisibility(0);
                AppMethodBeat.o(170122);
            }
        });
        if (ColorUtil.ifCompatKindaDarkModeDefaultColor()) {
            this.editText.setHintTextColor(context.getResources().getColor(R.color.uj));
            this.editText.setTextColor(context.getResources().getColor(R.color.a2x));
        }
        this.editText.setOnTouchListener(new View.OnTouchListener() {
            /* class com.tencent.kinda.framework.widget.base.MMKEditText.AnonymousClass4 */

            public boolean onTouch(View view, MotionEvent motionEvent) {
                AppMethodBeat.i(184745);
                if (MMKEditText.this.editText.isFocused()) {
                    AppMethodBeat.o(184745);
                    return false;
                } else if (motionEvent.getAction() == 0) {
                    KViewOnClickCallback onClickCallback = MMKEditText.this.getOnClickCallback();
                    if (onClickCallback != null) {
                        onClickCallback.onClick(MMKEditText.this);
                        AppMethodBeat.o(184745);
                        return true;
                    }
                    AppMethodBeat.o(184745);
                    return false;
                } else {
                    AppMethodBeat.o(184745);
                    return false;
                }
            }
        });
        this.editText.setId(R.id.e6n);
        linearLayout.setFocusableInTouchMode(true);
        linearLayout.setFocusable(true);
        AppMethodBeat.o(19022);
        return linearLayout;
    }

    @Override // com.tencent.kinda.gen.KView, com.tencent.kinda.framework.widget.base.MMKView
    public void setViewId(String str) {
        AppMethodBeat.i(214518);
        super.setViewId(str);
        if (this.iconImageView != null) {
            MMKViewUtil.setId4KindaImplView(this.mContext, str + "_btn", this.iconImageView);
        }
        AppMethodBeat.o(214518);
    }

    public void setVisibleClearIcon(boolean z) {
        AppMethodBeat.i(170125);
        if (!z || this.editText.getText().length() <= 0) {
            this.iconImageView.setVisibility(4);
            AppMethodBeat.o(170125);
            return;
        }
        this.iconImageView.setVisibility(0);
        AppMethodBeat.o(170125);
    }

    @Override // com.tencent.kinda.gen.KEditText
    public void setText(String str) {
        AppMethodBeat.i(19023);
        Log.d(MMKView.TAG, "MMKLabelView setText ".concat(String.valueOf(str)));
        if (str != null && !getText().equals(str)) {
            this.editText.setText(str);
        }
        AppMethodBeat.o(19023);
    }

    @Override // com.tencent.kinda.gen.KEditText
    public String getText() {
        AppMethodBeat.i(19024);
        Log.d(MMKView.TAG, "MMKLabelView getText ");
        Editable text = this.editText.getText();
        if (text != null) {
            String charSequence = text.toString();
            AppMethodBeat.o(19024);
            return charSequence;
        }
        AppMethodBeat.o(19024);
        return null;
    }

    @Override // com.tencent.kinda.gen.KEditText
    public void setTextSize(float f2) {
        AppMethodBeat.i(19025);
        if (f2 > 0.0f) {
            this.textSize = f2;
            this.editText.setTextSize(0, MMKViewUtil.dpToPx(MMApplicationContext.getContext(), f2));
            notifyChanged();
        }
        AppMethodBeat.o(19025);
    }

    @Override // com.tencent.kinda.gen.KEditText
    public float getTextSize() {
        return this.textSize;
    }

    @Override // com.tencent.kinda.gen.KEditText
    public void setTextColor(DynamicColor dynamicColor) {
        AppMethodBeat.i(19026);
        this.textColor = dynamicColor;
        this.editText.setTextColor(MMKViewUtil.argbColor(ColorUtil.getColorByMode(dynamicColor)));
        AppMethodBeat.o(19026);
    }

    @Override // com.tencent.kinda.gen.KEditText
    public DynamicColor getTextColor() {
        return this.textColor;
    }

    @Override // com.tencent.kinda.gen.KEditText
    public void setTextFont(String str) {
        int i2;
        AppMethodBeat.i(19027);
        if (!Util.isNullOrNil(str)) {
            if (str.equalsIgnoreCase("WeChat-Sans-SS-Light")) {
                i2 = 2;
            } else if (str.equalsIgnoreCase("WeChat-Sans-SS-Medium")) {
                i2 = 0;
            } else if (str.equalsIgnoreCase("WeChat-Sans-SS-Regular")) {
                i2 = 3;
            } else if (str.equalsIgnoreCase("WeChat-Sans-SS-Bold")) {
                i2 = 1;
            } else {
                i2 = -1;
            }
            if (i2 != -1) {
                try {
                    this.editText.setTypeface(Typeface.createFromAsset(MMApplicationContext.getContext().getAssets(), f.aqk(i2)));
                    notifyChanged();
                    AppMethodBeat.o(19027);
                    return;
                } catch (Exception e2) {
                    Log.e(MMKView.TAG, "setTypeface() Exception:%s %s", e2.getClass().getSimpleName(), e2.getMessage());
                }
            }
        }
        AppMethodBeat.o(19027);
    }

    @Override // com.tencent.kinda.gen.KEditText
    public String getTextFont() {
        return this.textFontName;
    }

    @Override // com.tencent.kinda.gen.KEditText
    public void setTextAlign(TextAlign textAlign2) {
        AppMethodBeat.i(19028);
        if (textAlign2 != null) {
            this.textAlign = textAlign2;
            switch (this.textAlign) {
                case LEFT:
                    ((LinearLayout) getView()).setGravity(3);
                    break;
                case CENTER:
                    ((LinearLayout) getView()).setGravity(1);
                    break;
                case RIGHT:
                    ((LinearLayout) getView()).setGravity(5);
                    break;
            }
            notifyChanged();
        }
        AppMethodBeat.o(19028);
    }

    @Override // com.tencent.kinda.gen.KEditText
    public TextAlign getTextAlign() {
        return this.textAlign;
    }

    @Override // com.tencent.kinda.gen.KEditText
    public void setHint(String str) {
        AppMethodBeat.i(19029);
        this.editText.setHint(str);
        notifyChanged();
        AppMethodBeat.o(19029);
    }

    @Override // com.tencent.kinda.gen.KEditText
    public String getHint() {
        AppMethodBeat.i(19030);
        CharSequence hint = this.editText.getHint();
        if (hint != null) {
            String charSequence = hint.toString();
            AppMethodBeat.o(19030);
            return charSequence;
        }
        AppMethodBeat.o(19030);
        return null;
    }

    @Override // com.tencent.kinda.gen.KEditText
    public void setHintColor(DynamicColor dynamicColor) {
        AppMethodBeat.i(19031);
        this.hintColor = dynamicColor;
        this.editText.setHintTextColor(MMKViewUtil.argbColor(ColorUtil.getColorByMode(this.hintColor)));
        AppMethodBeat.o(19031);
    }

    @Override // com.tencent.kinda.gen.KEditText
    public DynamicColor getHintColor() {
        return this.hintColor;
    }

    @Override // com.tencent.kinda.gen.KEditText
    public void setMaxLength(int i2) {
        AppMethodBeat.i(19032);
        if (i2 >= 0) {
            this.maxLength = i2;
            this.editText.setFilters(new InputFilter[]{new InputFilter.LengthFilter(this.maxLength)});
        }
        AppMethodBeat.o(19032);
    }

    @Override // com.tencent.kinda.gen.KEditText
    public int getMaxLength() {
        return this.maxLength;
    }

    @Override // com.tencent.kinda.gen.KEditText
    public void setKeyboardType(KeyboardType keyboardType2) {
        AppMethodBeat.i(19033);
        this.keyboardType = keyboardType2;
        switch (keyboardType2) {
            case NORMAL:
                this.editText.setInputType(0);
                AppMethodBeat.o(19033);
                return;
            case NUMBER:
                this.editText.setInputType(2);
                AppMethodBeat.o(19033);
                return;
            case PASSWORD:
                this.editText.setInputType(128);
                AppMethodBeat.o(19033);
                return;
            case EMAIL:
                this.editText.setInputType(32);
                AppMethodBeat.o(19033);
                return;
            case PHONE:
                this.editText.setInputType(3);
                AppMethodBeat.o(19033);
                return;
            case ID:
            case CRETAIL:
                if (this.mBaseFrActivity != null) {
                    this.mBaseFrActivity.setEditFocusListener(this.editText, 1, false);
                    this.mBaseFrActivity.setTenpayKBStateListener(new com.tencent.mm.wallet_core.ui.a() {
                        /* class com.tencent.kinda.framework.widget.base.MMKEditText.AnonymousClass5 */

                        @Override // com.tencent.mm.wallet_core.ui.a
                        public void onVisibleStateChange(boolean z) {
                            AppMethodBeat.i(184746);
                            if (!z && MMKEditText.this.editText.isFocused()) {
                                MMKEditText.this.editText.clearFocus();
                            }
                            AppMethodBeat.o(184746);
                        }
                    });
                    AppMethodBeat.o(19033);
                    return;
                }
                break;
            case DIGIT:
                this.editText.setImeOptions(6);
                this.editText.setInputType(524289);
                KindaWcKeyboardHelpr.bind((UIPageFragmentActivity) this.mBaseFrActivity, this.editText, MMApplicationContext.getContext().getString(R.string.x_), this.mBaseFrActivity.mTenpayKBStateCallBackListener);
                this.editText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
                    /* class com.tencent.kinda.framework.widget.base.MMKEditText.AnonymousClass6 */

                    public boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
                        AppMethodBeat.i(214514);
                        Log.d("MMKEditText", "on eidtor action: %s", keyEvent);
                        if (keyEvent.getAction() == 1 && keyEvent.getKeyCode() == 66) {
                            MMKEditText.this.editText.clearFocus();
                        }
                        AppMethodBeat.o(214514);
                        return true;
                    }
                });
                break;
        }
        AppMethodBeat.o(19033);
    }

    @Override // com.tencent.kinda.gen.KEditText
    public KeyboardType getKeyboardType() {
        return this.keyboardType;
    }

    @Override // com.tencent.kinda.gen.KEditText
    public void setSelection(int i2) {
        AppMethodBeat.i(19034);
        this.editText.setSelection(i2);
        AppMethodBeat.o(19034);
    }

    @Override // com.tencent.kinda.gen.KEditText
    public int getSelection() {
        AppMethodBeat.i(19035);
        int selectionStart = this.editText.getSelectionStart();
        AppMethodBeat.o(19035);
        return selectionStart;
    }

    @Override // com.tencent.kinda.gen.KEditText
    public void setFocus(boolean z) {
        AppMethodBeat.i(19036);
        if (z) {
            if (this.editText.hasFocus()) {
                this.editText.clearFocus();
            }
            this.editText.postDelayed(new Runnable() {
                /* class com.tencent.kinda.framework.widget.base.MMKEditText.AnonymousClass7 */

                public void run() {
                    AppMethodBeat.i(214515);
                    MMKEditText.this.editText.requestFocus();
                    if (!(MMKEditText.this.keyboardType == KeyboardType.ID || MMKEditText.this.keyboardType == KeyboardType.CRETAIL)) {
                        ((InputMethodManager) MMKEditText.this.mContext.getSystemService("input_method")).showSoftInput(MMKEditText.this.editText, 0);
                    }
                    AppMethodBeat.o(214515);
                }
            }, 50);
            AppMethodBeat.o(19036);
            return;
        }
        this.editText.clearFocus();
        if (!(this.keyboardType == KeyboardType.ID || this.keyboardType == KeyboardType.CRETAIL)) {
            ((InputMethodManager) this.mContext.getSystemService("input_method")).hideSoftInputFromWindow(this.editText.getWindowToken(), 0);
        }
        AppMethodBeat.o(19036);
    }

    @Override // com.tencent.kinda.gen.KEditText
    public boolean getFocus() {
        AppMethodBeat.i(19037);
        boolean isFocused = this.editText.isFocused();
        AppMethodBeat.o(19037);
        return isFocused;
    }

    @Override // com.tencent.kinda.gen.KEditText
    public void setTintColor(DynamicColor dynamicColor) {
    }

    @Override // com.tencent.kinda.gen.KEditText
    public DynamicColor getTintColor() {
        return null;
    }

    @Override // com.tencent.kinda.gen.KEditText
    public void setClearButtonMode(ClearButtonMode clearButtonMode2) {
        AppMethodBeat.i(19038);
        this.clearButtonMode = clearButtonMode2;
        if (clearButtonMode2 == ClearButtonMode.NEVER) {
            this.iconImageView.setVisibility(8);
            AppMethodBeat.o(19038);
            return;
        }
        if (!(clearButtonMode2 == ClearButtonMode.WHILEEDITING || clearButtonMode2 == ClearButtonMode.UNLESSEDITING)) {
            if (clearButtonMode2 == ClearButtonMode.ALWAYS) {
                this.iconImageView.setVisibility(0);
                AppMethodBeat.o(19038);
                return;
            }
            this.iconImageView.setVisibility(4);
        }
        AppMethodBeat.o(19038);
    }

    @Override // com.tencent.kinda.gen.KEditText
    public ClearButtonMode getClearButtonMode() {
        return this.clearButtonMode;
    }

    @Override // com.tencent.kinda.gen.KEditText
    public void setOnTextBeginChangeCallback(KEditTextOnTextBeginChangeCallback kEditTextOnTextBeginChangeCallback) {
        this.onTextBeginChangeCallback = kEditTextOnTextBeginChangeCallback;
    }

    @Override // com.tencent.kinda.gen.KEditText
    public void setOnTextChangedCallback(KEditTextOnTextChangedCallback kEditTextOnTextChangedCallback) {
        this.onTextChangedCallback = kEditTextOnTextChangedCallback;
    }

    @Override // com.tencent.kinda.gen.KEditText
    public String encryptWith3Des() {
        AppMethodBeat.i(19039);
        String desedeVerifyCode = new TenpaySecureEncrypt().desedeVerifyCode(this.editText.getText().toString(), Long.toString(cl.aWy() / 1000));
        AppMethodBeat.o(19039);
        return desedeVerifyCode;
    }

    @Override // com.tencent.kinda.gen.KEditText
    public void setEnabled(boolean z) {
        AppMethodBeat.i(19040);
        this.editText.setEnabled(z);
        AppMethodBeat.o(19040);
    }

    @Override // com.tencent.kinda.gen.KEditText
    public boolean getEnabled() {
        AppMethodBeat.i(19041);
        boolean isEnabled = this.editText.isEnabled();
        AppMethodBeat.o(19041);
        return isEnabled;
    }

    @Override // com.tencent.kinda.gen.KEditText
    public void setRestrictType(EditTextRestrictType editTextRestrictType) {
        AppMethodBeat.i(214519);
        this.mRestriceType = editTextRestrictType;
        if (this.mRestriceType == EditTextRestrictType.MONEY) {
            this.editText.addTextChangedListener(new TextWatcher() {
                /* class com.tencent.kinda.framework.widget.base.MMKEditText.AnonymousClass8 */

                public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                }

                public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                }

                public void afterTextChanged(Editable editable) {
                    AppMethodBeat.i(214516);
                    if (editable.toString().startsWith(".")) {
                        editable.insert(0, AppEventsConstants.EVENT_PARAM_VALUE_NO);
                    }
                    String obj = editable.toString();
                    int indexOf = obj.indexOf(".");
                    int length = obj.length();
                    if (indexOf >= 0 && length - indexOf > 3) {
                        WalletFormView.a(MMKEditText.this.editText, obj, indexOf + 3, length);
                        AppMethodBeat.o(214516);
                    } else if (indexOf > 12) {
                        WalletFormView.a(MMKEditText.this.editText, obj, 12, indexOf);
                        AppMethodBeat.o(214516);
                    } else {
                        if (indexOf == -1 && length > 12) {
                            WalletFormView.a(MMKEditText.this.editText, obj, 12, length);
                        }
                        AppMethodBeat.o(214516);
                    }
                }
            });
        }
        AppMethodBeat.o(214519);
    }

    @Override // com.tencent.kinda.gen.KEditText
    public EditTextRestrictType getRestrictType() {
        return this.mRestriceType;
    }

    @Override // com.tencent.kinda.gen.KEditText
    public void setOnTextEndEditingCallback(KEditTextOnTextEndEditingCallback kEditTextOnTextEndEditingCallback) {
        this.mKEditTextOnTextEndEditingCallback = kEditTextOnTextEndEditingCallback;
    }

    public void callBackKindaTextEndEditing() {
        AppMethodBeat.i(178777);
        if (this.mKEditTextOnTextEndEditingCallback != null) {
            this.mKEditTextOnTextEndEditingCallback.onTextEndEditing(this.editText.getText().toString());
        }
        AppMethodBeat.o(178777);
    }
}

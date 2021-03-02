package com.tenpay.bankcard;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Build;
import android.text.InputFilter;
import android.util.AttributeSet;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.Util;
import com.tenpay.android.wechat.MyKeyboardWindow;
import com.tenpay.android.wechat.TenpayUtil;
import com.tenpay.ndk.Encrypt;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public final class TenpaySegmentEditText extends LinearLayout {
    private static String mTimeStamp;
    private final int BG_LINE_COLOR;
    private final int BG_LINE_HEIGHT;
    private final int BG_LINE_SIZE;
    private final String TAG;
    private Context mContext;
    private List<EditText> mEditArray;
    EditState mEditState;
    private MyKeyboardWindow mKeyboard;
    private boolean mNoFocus;
    private View.OnClickListener mOnClickListener;
    private Paint mPaintBg;
    private Paint mPaintSplit;

    public enum EditState {
        DEFAULT,
        BANKCARD,
        BANKCARD_WITH_TAILNUM;

        public static EditState valueOf(String str) {
            AppMethodBeat.i(73270);
            EditState editState = (EditState) Enum.valueOf(EditState.class, str);
            AppMethodBeat.o(73270);
            return editState;
        }

        static {
            AppMethodBeat.i(73271);
            AppMethodBeat.o(73271);
        }
    }

    public TenpaySegmentEditText(Context context) {
        this(context, null);
        AppMethodBeat.i(73272);
        this.mContext = context;
        init();
        AppMethodBeat.o(73272);
    }

    public TenpaySegmentEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(73273);
        this.TAG = "MyTag";
        this.BG_LINE_COLOR = -11615450;
        this.BG_LINE_SIZE = 4;
        this.BG_LINE_HEIGHT = 9;
        this.mOnClickListener = null;
        this.mNoFocus = true;
        this.mEditState = EditState.DEFAULT;
        this.mContext = null;
        this.mEditArray = new ArrayList();
        this.mKeyboard = null;
        this.mContext = context;
        init();
        AppMethodBeat.o(73273);
    }

    private void init() {
        AppMethodBeat.i(73274);
        setBackgroundColor(getResources().getColor(R.color.afz));
        setOrientation(0);
        setIsBankcardFormat(true);
        this.mPaintSplit = new Paint();
        this.mPaintSplit.setStrokeWidth(0.0f);
        this.mPaintSplit.setColor(-7829368);
        this.mPaintBg = new Paint();
        this.mPaintBg.setColor(-11615450);
        this.mPaintBg.setStyle(Paint.Style.FILL);
        AppMethodBeat.o(73274);
    }

    public final void setIsBankcardFormat(boolean z) {
        if (z) {
            this.mEditState = EditState.BANKCARD;
        } else if (EditState.BANKCARD == this.mEditState) {
            this.mEditState = EditState.DEFAULT;
        }
    }

    public final void setText(String str) {
        AppMethodBeat.i(73275);
        setText(str, null);
        AppMethodBeat.o(73275);
    }

    public final void setText(String str, String str2) {
        AppMethodBeat.i(73276);
        Encrypt encrypt = new Encrypt();
        if (Util.isNullOrNil(str2)) {
            str2 = encrypt.getRandomKey();
        }
        String[] split = encrypt.desedeDecode(str, str2).split("-");
        removeAllViews();
        this.mNoFocus = true;
        this.mEditArray.clear();
        for (int i2 = 0; i2 < split.length; i2++) {
            final EditText editText = new EditText(this.mContext);
            editText.setText(split[i2]);
            editText.setMaxLines(1);
            editText.setFilters(new InputFilter[]{new InputFilter.LengthFilter(split[i2].length())});
            editText.setGravity(17);
            editText.setInputType(2);
            editText.setBackgroundColor(0);
            editText.setSelectAllOnFocus(true);
            editText.setOnClickListener(new View.OnClickListener() {
                /* class com.tenpay.bankcard.TenpaySegmentEditText.AnonymousClass1 */
                private byte _hellAccFlag_;

                public void onClick(View view) {
                    AppMethodBeat.i(73267);
                    b bVar = new b();
                    bVar.bm(view);
                    a.b("com/tenpay/bankcard/TenpaySegmentEditText$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    if (TenpaySegmentEditText.this.mOnClickListener != null) {
                        TenpaySegmentEditText.this.mOnClickListener.onClick(view);
                    }
                    if (TenpaySegmentEditText.this.mNoFocus) {
                        TenpaySegmentEditText.this.setFocusable(true);
                        editText.requestFocus();
                        TenpaySegmentEditText.this.mNoFocus = false;
                    }
                    a.a(this, "com/tenpay/bankcard/TenpaySegmentEditText$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(73267);
                }
            });
            setNoSystemInputOnEditText(editText);
            ((InputMethodManager) this.mContext.getSystemService("input_method")).hideSoftInputFromWindow(editText.getWindowToken(), 2);
            editText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                /* class com.tenpay.bankcard.TenpaySegmentEditText.AnonymousClass2 */

                public void onFocusChange(View view, boolean z) {
                    AppMethodBeat.i(73268);
                    LogUtil.d("MyTag", "edit onFocusChange hasFocus=".concat(String.valueOf(z)));
                    if (z) {
                        if (TenpaySegmentEditText.this.mOnClickListener != null) {
                            TenpaySegmentEditText.this.mOnClickListener.onClick(view);
                        }
                        if (TenpaySegmentEditText.this.mKeyboard != null) {
                            LogUtil.d("MyTag", "keyboard is not null");
                            TenpaySegmentEditText.this.mKeyboard.setXMode(0);
                            TenpaySegmentEditText.this.mKeyboard.setInputEditText(editText);
                        }
                    }
                    AppMethodBeat.o(73268);
                }
            });
            addView(editText, new LinearLayout.LayoutParams(-2, -1, (float) split[i2].length()));
            this.mEditArray.add(editText);
        }
        setFocusable(false);
        AppMethodBeat.o(73276);
    }

    public final void setKeyboard(MyKeyboardWindow myKeyboardWindow) {
        this.mKeyboard = myKeyboardWindow;
    }

    @Override // android.view.View
    public final void setFocusable(boolean z) {
        AppMethodBeat.i(73277);
        LogUtil.d("MyTag", "setFocusable ".concat(String.valueOf(z)));
        for (int i2 = 0; i2 < this.mEditArray.size(); i2++) {
            EditText editText = this.mEditArray.get(i2);
            editText.setFocusable(z);
            editText.setFocusableInTouchMode(z);
        }
        AppMethodBeat.o(73277);
    }

    public final void setOnClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
    }

    /* access modifiers changed from: protected */
    public final void onDraw(Canvas canvas) {
        AppMethodBeat.i(73278);
        super.onDraw(canvas);
        drawBackgroundLine(canvas);
        AppMethodBeat.o(73278);
    }

    private void drawBackgroundLine(Canvas canvas) {
        AppMethodBeat.i(73279);
        int width = getWidth();
        int height = getHeight();
        float f2 = (float) (height - 4);
        canvas.drawRect(0.0f, f2, (float) width, (float) height, this.mPaintBg);
        float f3 = f2 - 9.0f;
        int size = this.mEditArray.size();
        canvas.drawRect(0.0f, f3, 4.0f, f2, this.mPaintBg);
        int i2 = 0;
        float f4 = 0.0f;
        while (i2 < size) {
            int i3 = -2;
            if (i2 == size - 1) {
                i3 = -4;
            }
            float width2 = f4 + ((float) (this.mEditArray.get(i2).getWidth() + i3));
            canvas.drawRect(width2, f3, width2 + 4.0f, f2, this.mPaintBg);
            i2++;
            f4 = width2 - ((float) i3);
        }
        AppMethodBeat.o(73279);
    }

    public static void setSalt(String str) {
        mTimeStamp = str;
    }

    private String getInputText() {
        AppMethodBeat.i(73280);
        StringBuffer stringBuffer = new StringBuffer();
        for (int i2 = 0; i2 < this.mEditArray.size(); i2++) {
            stringBuffer.append(this.mEditArray.get(i2).getText().toString());
        }
        String stringBuffer2 = stringBuffer.toString();
        if (stringBuffer2 == null || stringBuffer2.length() == 0) {
            AppMethodBeat.o(73280);
            return null;
        }
        stringBuffer2.trim().replaceAll(" ", "");
        AppMethodBeat.o(73280);
        return stringBuffer2;
    }

    public final String getEncryptDataWithHash(boolean z) {
        AppMethodBeat.i(73281);
        String inputText = getInputText();
        if (inputText == null || inputText.length() == 0) {
            AppMethodBeat.o(73281);
            return null;
        }
        if (z) {
            inputText = TenpayUtil.md5HexDigest(inputText);
        }
        Encrypt encrypt = new Encrypt();
        if (mTimeStamp != null) {
            encrypt.setTimeStamp(mTimeStamp);
        }
        com.tencent.mm.wallet_core.b.hgC();
        if (com.tencent.mm.wallet_core.b.hgD()) {
            String encryptPasswdWithRSA2048 = encrypt.encryptPasswdWithRSA2048(inputText);
            AppMethodBeat.o(73281);
            return encryptPasswdWithRSA2048;
        }
        String encryptPasswd = encrypt.encryptPasswd(inputText);
        AppMethodBeat.o(73281);
        return encryptPasswd;
    }

    public final String get3DesEncrptData() {
        AppMethodBeat.i(73282);
        String inputText = getInputText();
        if (inputText == null || inputText.length() == 0) {
            AppMethodBeat.o(73282);
            return null;
        }
        Encrypt encrypt = new Encrypt();
        String desedeEncode = encrypt.desedeEncode(inputText, encrypt.getRandomKey());
        AppMethodBeat.o(73282);
        return desedeEncode;
    }

    public final boolean isMatchPattern(String str) {
        boolean z = false;
        AppMethodBeat.i(73283);
        if (str != null) {
            try {
                z = Pattern.compile(str).matcher(getInputText()).matches();
                AppMethodBeat.o(73283);
            } catch (Exception e2) {
                AppMethodBeat.o(73283);
            }
        } else {
            AppMethodBeat.o(73283);
        }
        return z;
    }

    private boolean isMatchPattern(String str, String str2) {
        boolean z = false;
        AppMethodBeat.i(73284);
        if (str2 != null) {
            try {
                z = Pattern.compile(str2).matcher(str).matches();
                AppMethodBeat.o(73284);
            } catch (Exception e2) {
                AppMethodBeat.o(73284);
            }
        } else {
            AppMethodBeat.o(73284);
        }
        return z;
    }

    public final void ClearInput() {
    }

    public final int getInputLength() {
        AppMethodBeat.i(73285);
        String inputText = getInputText();
        if (inputText == null) {
            AppMethodBeat.o(73285);
            return 0;
        }
        int length = inputText.length();
        AppMethodBeat.o(73285);
        return length;
    }

    public static void setNoSystemInputOnEditText(EditText editText) {
        AppMethodBeat.i(73286);
        if (Build.VERSION.SDK_INT < 11) {
            editText.setInputType(0);
            AppMethodBeat.o(73286);
            return;
        }
        try {
            Method method = EditText.class.getMethod("setShowSoftInputOnFocus", Boolean.TYPE);
            method.setAccessible(true);
            method.invoke(editText, Boolean.FALSE);
            AppMethodBeat.o(73286);
        } catch (NoSuchMethodException e2) {
            try {
                Method method2 = EditText.class.getMethod("setSoftInputShownOnFocus", Boolean.TYPE);
                method2.setAccessible(true);
                method2.invoke(editText, Boolean.FALSE);
                AppMethodBeat.o(73286);
            } catch (Exception e3) {
                editText.setInputType(0);
                AppMethodBeat.o(73286);
            }
        } catch (Exception e4) {
            AppMethodBeat.o(73286);
        }
    }
}

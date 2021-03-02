package com.tenpay.android.wechat;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.ContextMenu;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.cb.a;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.at;
import com.tenpay.ndk.Encrypt;
import java.lang.reflect.Field;
import java.util.regex.Pattern;

public final class TenpaySecureEditText extends EditText {
    public static final int AREA_ID_CARD_TYPE_HUIXIANG = 5;
    public static final int AREA_ID_CARD_TYPE_SHENFEN = 1;
    public static final int AREA_ID_CARD_TYPE_TAIBAO = 9;
    private static int BANK_CARD_LENGTH_LIMIT = 14;
    private static int CARD_TAIL_SPACE = 15;
    private static int CVV_4_PAYMENT_LENGTH = 4;
    private static int CVV_PAYMENT_LENGTH = 3;
    private static int PASSWD_BLACK_DOT_SIZE = 7;
    private static int PASSWD_LEFT_PADDING = -1500000;
    private static int PASSWD_LENGTH = 6;
    private static int VALID_THRU_LEN = 4;
    private static String mTimeStamp;
    private String mCardTailNum;
    private Drawable mClearBtnImg;
    private float mDensity;
    EditState mEditState;
    private char[] mFilterChar;
    private String mFixedHeaderText;
    private Paint mIDCardPaint;
    private ISecureEncrypt mIEncrypt;
    private boolean mIsCardTailNumCanDisplay;
    private boolean mIsSelfSet;
    private boolean mIsUseOfKinda;
    private IKindaEditTextCallBackListener mKindaEditTextCallBackListener;
    private boolean mNewPwdStyle;
    private Paint mPaintBackground;
    private Paint mPasswdBgPaint;
    private OnPasswdInputListener mPasswdListener;
    private Paint mPasswdSeparedPaint;
    private Paint mTitlePaint;
    private String regExFilterInput;

    public interface IKindaEditTextCallBackListener {
        void onCallBackKinda();
    }

    public enum EditState {
        DEFAULT,
        PASSWORD,
        BANKCARD,
        BANKCARD_WITH_TAILNUM,
        VALID_THRU,
        MONEY_AMOUNT,
        CVV_PAYMENT,
        CVV_4_PAYMENT,
        SECURITY_ANSWER,
        IDCARD_TAIL;

        public static EditState valueOf(String str) {
            AppMethodBeat.i(73208);
            EditState editState = (EditState) Enum.valueOf(EditState.class, str);
            AppMethodBeat.o(73208);
            return editState;
        }

        static {
            AppMethodBeat.i(73209);
            AppMethodBeat.o(73209);
        }
    }

    public TenpaySecureEditText(Context context) {
        this(context, null);
    }

    public TenpaySecureEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(73210);
        this.mEditState = EditState.DEFAULT;
        this.mNewPwdStyle = true;
        this.mIEncrypt = new TenpaySecureEncrypt();
        init(context, attributeSet);
        AppMethodBeat.o(73210);
    }

    public TenpaySecureEditText(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(73211);
        this.mEditState = EditState.DEFAULT;
        this.mNewPwdStyle = true;
        this.mIEncrypt = new TenpaySecureEncrypt();
        init(context, attributeSet);
        AppMethodBeat.o(73211);
    }

    private void init(Context context, AttributeSet attributeSet) {
        int[] resourceDeclareStyleableIntArray;
        TypedArray obtainStyledAttributes;
        AppMethodBeat.i(73212);
        this.mDensity = getResources().getDisplayMetrics().density;
        if (!(attributeSet == null || (resourceDeclareStyleableIntArray = TenpayUtil.getResourceDeclareStyleableIntArray(context, "TenpaySecureEditText")) == null || (obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, resourceDeclareStyleableIntArray)) == null)) {
            setIsPasswordFormat(obtainStyledAttributes.getBoolean(TenpayUtil.getResourceDeclareStyleableIndex(context, "TenpaySecureEditText_isPassword"), false), true);
            setIsBankcardFormat(obtainStyledAttributes.getBoolean(TenpayUtil.getResourceDeclareStyleableIndex(context, "TenpaySecureEditText_isBankcard"), false));
            setIsValidThru(obtainStyledAttributes.getBoolean(TenpayUtil.getResourceDeclareStyleableIndex(context, "TenpaySecureEditText_isValidThru"), false));
            setBankcardTailNum(obtainStyledAttributes.getString(TenpayUtil.getResourceDeclareStyleableIndex(context, "TenpaySecureEditText_bankcardTailNum")));
            int resourceId = obtainStyledAttributes.getResourceId(TenpayUtil.getResourceDeclareStyleableIndex(context, "TenpaySecureEditText_rightClearDrawable"), 0);
            if (resourceId != 0) {
                setClearBtnDrawableId(resourceId);
            }
            obtainStyledAttributes.recycle();
        }
        addTextChangedListener(new TextWatcher() {
            /* class com.tenpay.android.wechat.TenpaySecureEditText.AnonymousClass1 */

            public void afterTextChanged(Editable editable) {
            }

            public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }
        });
        AppMethodBeat.o(73212);
    }

    public final Drawable getClearBtnDrawable() {
        return this.mClearBtnImg;
    }

    public final void setClearBtnDrawableId(int i2) {
        AppMethodBeat.i(73213);
        setClearBtnDrawableId(i2, 0);
        AppMethodBeat.o(73213);
    }

    public final void setClearBtnDrawableId(int i2, int i3) {
        AppMethodBeat.i(73214);
        setClearBtnDrawableId(i2, i3, 0, 0);
        AppMethodBeat.o(73214);
    }

    public final void setClearBtnDrawableId(int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(174540);
        try {
            this.mClearBtnImg = getResources().getDrawable(i2);
            if (i3 != 0) {
                this.mClearBtnImg.setColorFilter(i3, PorterDuff.Mode.SRC_ATOP);
            }
        } catch (Exception e2) {
            this.mClearBtnImg = null;
        }
        if (this.mClearBtnImg != null) {
            if (i4 == 0 || i5 == 0) {
                this.mClearBtnImg.setBounds(0, 0, this.mClearBtnImg.getIntrinsicWidth(), this.mClearBtnImg.getIntrinsicHeight());
            } else {
                this.mClearBtnImg.setBounds(0, 0, at.fromDPToPix(getContext(), i4), at.fromDPToPix(getContext(), i5));
            }
            setOnFocusChangeListener(new View.OnFocusChangeListener() {
                /* class com.tenpay.android.wechat.TenpaySecureEditText.AnonymousClass2 */

                public void onFocusChange(View view, boolean z) {
                    AppMethodBeat.i(73204);
                    if (!z) {
                        TenpaySecureEditText.this.setCompoundDrawables(TenpaySecureEditText.this.getCompoundDrawables()[0], TenpaySecureEditText.this.getCompoundDrawables()[1], null, TenpaySecureEditText.this.getCompoundDrawables()[3]);
                        AppMethodBeat.o(73204);
                        return;
                    }
                    if (!(TenpaySecureEditText.this.getText().toString().equals("") || EditState.PASSWORD == TenpaySecureEditText.this.mEditState || EditState.CVV_PAYMENT == TenpaySecureEditText.this.mEditState || EditState.CVV_4_PAYMENT == TenpaySecureEditText.this.mEditState)) {
                        TenpaySecureEditText.this.setCompoundDrawables(TenpaySecureEditText.this.getCompoundDrawables()[0], TenpaySecureEditText.this.getCompoundDrawables()[1], TenpaySecureEditText.this.mClearBtnImg, TenpaySecureEditText.this.getCompoundDrawables()[3]);
                    }
                    AppMethodBeat.o(73204);
                }
            });
            setOnTouchListener(new View.OnTouchListener() {
                /* class com.tenpay.android.wechat.TenpaySecureEditText.AnonymousClass3 */

                public boolean onTouch(View view, MotionEvent motionEvent) {
                    AppMethodBeat.i(73205);
                    if (!(EditState.PASSWORD == TenpaySecureEditText.this.mEditState || EditState.CVV_PAYMENT == TenpaySecureEditText.this.mEditState || EditState.CVV_4_PAYMENT == TenpaySecureEditText.this.mEditState)) {
                        TenpaySecureEditText tenpaySecureEditText = TenpaySecureEditText.this;
                        if (motionEvent.getAction() == 1 && !tenpaySecureEditText.isFocused() && TenpaySecureEditText.this.mKindaEditTextCallBackListener != null) {
                            TenpaySecureEditText.this.mKindaEditTextCallBackListener.onCallBackKinda();
                        }
                        if (tenpaySecureEditText.getCompoundDrawables()[2] == null) {
                            AppMethodBeat.o(73205);
                        } else if (motionEvent.getAction() != 1) {
                            AppMethodBeat.o(73205);
                        } else if (motionEvent.getX() > ((float) ((tenpaySecureEditText.getWidth() - tenpaySecureEditText.getPaddingRight()) - TenpaySecureEditText.this.mClearBtnImg.getIntrinsicWidth()))) {
                            tenpaySecureEditText.setText("");
                        }
                        return false;
                    }
                    AppMethodBeat.o(73205);
                    return false;
                }
            });
            AppMethodBeat.o(174540);
            return;
        }
        setOnFocusChangeListener(new View.OnFocusChangeListener() {
            /* class com.tenpay.android.wechat.TenpaySecureEditText.AnonymousClass4 */

            public void onFocusChange(View view, boolean z) {
            }
        });
        setOnTouchListener(new View.OnTouchListener() {
            /* class com.tenpay.android.wechat.TenpaySecureEditText.AnonymousClass5 */

            public boolean onTouch(View view, MotionEvent motionEvent) {
                return false;
            }
        });
        AppMethodBeat.o(174540);
    }

    public final boolean onTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(73215);
        if (motionEvent.getAction() == 0 && this.mIsUseOfKinda) {
            clearFocus();
        }
        boolean onTouchEvent = super.onTouchEvent(motionEvent);
        AppMethodBeat.o(73215);
        return onTouchEvent;
    }

    public final EditState getEditState() {
        return this.mEditState;
    }

    public final void setIsPasswordFormat(boolean z, boolean z2) {
        AppMethodBeat.i(214353);
        if (z) {
            this.mNewPwdStyle = z2;
            setPadding(PASSWD_LEFT_PADDING, getPaddingTop(), getPaddingRight(), getPaddingBottom());
            this.mPaintBackground = new Paint(1);
            this.mPaintBackground.setStyle(Paint.Style.FILL);
            if (ao.isDarkMode()) {
                this.mPaintBackground.setColor(getResources().getColor(R.color.BW_100_Alpha_0_8));
            } else {
                this.mPaintBackground.setColor(getResources().getColor(R.color.BW_0));
            }
            this.mEditState = EditState.PASSWORD;
            this.mPasswdSeparedPaint = new Paint(1);
            this.mPasswdSeparedPaint.setStyle(Paint.Style.STROKE);
            this.mPasswdSeparedPaint.setStrokeWidth(1.5f);
            if (ao.isDarkMode()) {
                this.mPasswdSeparedPaint.setColor(getResources().getColor(R.color.FG_4));
            } else {
                this.mPasswdSeparedPaint.setColor(getResources().getColor(R.color.FG_3));
            }
            this.mPasswdBgPaint = new Paint(1);
            this.mPasswdBgPaint.setStyle(Paint.Style.FILL);
            if (ao.isDarkMode()) {
                this.mPasswdBgPaint.setColor(getResources().getColor(R.color.f3043a));
                AppMethodBeat.o(214353);
                return;
            }
            this.mPasswdBgPaint.setColor(getResources().getColor(R.color.f3043a));
            AppMethodBeat.o(214353);
            return;
        }
        this.mPaintBackground = null;
        if (EditState.PASSWORD == this.mEditState) {
            this.mEditState = EditState.DEFAULT;
        }
        AppMethodBeat.o(214353);
    }

    public final void setIsSecurityAnswerFormat(boolean z) {
        if (z) {
            this.mEditState = EditState.SECURITY_ANSWER;
        } else {
            this.mEditState = EditState.DEFAULT;
        }
    }

    public final void setIsIdCardTailFormat(boolean z) {
        AppMethodBeat.i(73217);
        if (z) {
            setPadding(PASSWD_LEFT_PADDING, getPaddingTop(), getPaddingRight(), getPaddingBottom());
            this.mEditState = EditState.IDCARD_TAIL;
            this.mIDCardPaint = new Paint();
            this.mIDCardPaint.setTypeface(Typeface.create(Typeface.DEFAULT, 0));
            this.mIDCardPaint.setTextAlign(Paint.Align.CENTER);
            this.mIDCardPaint.setAntiAlias(true);
            this.mIDCardPaint.setTextSize(getTextSize());
            this.mIDCardPaint.setColor(getResources().getColor(R.color.fo));
            AppMethodBeat.o(73217);
            return;
        }
        this.mEditState = EditState.DEFAULT;
        AppMethodBeat.o(73217);
    }

    public final void setIsCvvPaymentFormat(boolean z) {
        AppMethodBeat.i(73218);
        if (z) {
            setPadding(PASSWD_LEFT_PADDING, getPaddingTop(), getPaddingRight(), getPaddingBottom());
            this.mPaintBackground = new Paint(1);
            this.mPaintBackground.setStyle(Paint.Style.FILL);
            this.mIDCardPaint.setColor(getResources().getColor(R.color.fo));
            this.mEditState = EditState.CVV_PAYMENT;
            AppMethodBeat.o(73218);
            return;
        }
        this.mPaintBackground = null;
        if (EditState.CVV_PAYMENT == this.mEditState) {
            this.mEditState = EditState.DEFAULT;
        }
        AppMethodBeat.o(73218);
    }

    public final void setIsCvv4PaymentFormat(boolean z) {
        AppMethodBeat.i(73219);
        if (z) {
            setPadding(PASSWD_LEFT_PADDING, getPaddingTop(), getPaddingRight(), getPaddingBottom());
            this.mPaintBackground = new Paint(1);
            this.mPaintBackground.setStyle(Paint.Style.FILL);
            this.mIDCardPaint.setColor(getResources().getColor(R.color.fo));
            this.mEditState = EditState.CVV_4_PAYMENT;
            AppMethodBeat.o(73219);
            return;
        }
        this.mPaintBackground = null;
        if (EditState.CVV_4_PAYMENT == this.mEditState) {
            this.mEditState = EditState.DEFAULT;
        }
        AppMethodBeat.o(73219);
    }

    public final void setIsValidThru(boolean z) {
        if (z) {
            this.mEditState = EditState.VALID_THRU;
        } else if (EditState.VALID_THRU == this.mEditState) {
            this.mEditState = EditState.DEFAULT;
        }
    }

    public final void setValidThru(String str) {
        AppMethodBeat.i(73220);
        if (str != null && str.length() == VALID_THRU_LEN) {
            setText(str);
            this.mEditState = EditState.VALID_THRU;
        }
        AppMethodBeat.o(73220);
    }

    public final void setIsBankcardFormat(boolean z) {
        if (z) {
            this.mEditState = EditState.BANKCARD;
        } else if (EditState.BANKCARD == this.mEditState) {
            this.mEditState = EditState.DEFAULT;
        }
    }

    public final void setBankcardTailNum(String str) {
        AppMethodBeat.i(73221);
        this.mCardTailNum = str;
        if (str != null && str.length() > 0) {
            this.mEditState = EditState.BANKCARD_WITH_TAILNUM;
            this.mTitlePaint = new Paint();
            this.mTitlePaint.setTypeface(Typeface.create(Typeface.DEFAULT, 0));
            this.mTitlePaint.setAntiAlias(true);
            this.mTitlePaint.setTextSize(getTextSize());
            this.mIDCardPaint.setColor(getResources().getColor(R.color.fo));
        }
        AppMethodBeat.o(73221);
    }

    public final void setIsMoneyAmountFormat(boolean z) {
        if (z) {
            this.mEditState = EditState.MONEY_AMOUNT;
        } else if (EditState.MONEY_AMOUNT == this.mEditState) {
            this.mEditState = EditState.DEFAULT;
        }
    }

    public final void setFilterChar(char[] cArr) {
        this.mFilterChar = cArr;
    }

    public final void setregExFilterInput(String str) {
        this.regExFilterInput = str;
    }

    public final void setFixedHeaderText(String str) {
        AppMethodBeat.i(73222);
        this.mFixedHeaderText = str;
        setPadding(((int) getPaint().measureText(this.mFixedHeaderText)) + getPaddingLeft(), getPaddingTop(), getPaddingBottom(), getPaddingRight());
        invalidate();
        AppMethodBeat.o(73222);
    }

    /* access modifiers changed from: protected */
    public final void onDraw(Canvas canvas) {
        AppMethodBeat.i(73223);
        if (this.mEditState == EditState.IDCARD_TAIL) {
            drawIdCardTail(canvas);
        } else if (this.mEditState == EditState.PASSWORD || this.mEditState == EditState.CVV_PAYMENT || this.mEditState == EditState.CVV_4_PAYMENT) {
            drawPasswdDot(canvas);
            drawCvvPaymentDot(canvas);
            drawCvv4PaymentDot(canvas);
        } else {
            super.onDraw(canvas);
            drawCardTailNum(canvas);
        }
        if (!TextUtils.isEmpty(this.mFixedHeaderText)) {
            canvas.drawText(this.mFixedHeaderText, 0.0f, ((((float) getMeasuredHeight()) - getTextSize()) / 2.0f) + getTextSize(), getPaint());
        }
        AppMethodBeat.o(73223);
    }

    private void drawIdCardTail(Canvas canvas) {
        AppMethodBeat.i(73224);
        if (EditState.IDCARD_TAIL == this.mEditState && this.mIDCardPaint != null) {
            int width = getWidth() / 4;
            String obj = getText().toString();
            int length = obj.length();
            this.mIDCardPaint.setTextSize(getTextSize());
            for (int i2 = 0; i2 < length; i2++) {
                canvas.drawText(obj.substring(i2, i2 + 1), (float) ((width / 2) + (i2 * width)), (float) getBaseline(), this.mIDCardPaint);
            }
        }
        AppMethodBeat.o(73224);
    }

    private void drawPasswdDot(Canvas canvas) {
        int i2 = 0;
        AppMethodBeat.i(73225);
        if (EditState.PASSWORD == this.mEditState && this.mPaintBackground != null) {
            int width = getWidth();
            int height = getHeight();
            int i3 = width / PASSWD_LENGTH;
            int length = getText().length();
            if (!this.mNewPwdStyle) {
                while (i2 < length) {
                    canvas.drawCircle((float) ((i3 / 2) + (i2 * i3)), (float) (height / 2), ((float) PASSWD_BLACK_DOT_SIZE) * this.mDensity, this.mPaintBackground);
                    i2++;
                }
                for (int i4 = 1; i4 < PASSWD_LENGTH; i4++) {
                    canvas.drawLine((float) (i3 * i4), 0.0f, (float) (i3 * i4), (float) height, this.mPasswdSeparedPaint);
                }
                AppMethodBeat.o(73225);
                return;
            }
            int fromDPToPix = a.fromDPToPix(getContext(), 8);
            while (i2 < PASSWD_LENGTH) {
                float f2 = (float) ((height + fromDPToPix) * i2);
                float f3 = ((float) height) + f2;
                RectF rectF = new RectF(f2, 0.0f, f3, (float) height);
                float fromDPToPix2 = (float) a.fromDPToPix(getContext(), 4);
                canvas.drawRoundRect(rectF, fromDPToPix2, fromDPToPix2, this.mPasswdBgPaint);
                if (i2 < length) {
                    canvas.drawCircle((f2 + f3) / 2.0f, ((float) height) / 2.0f, (float) a.fromDPToPix(getContext(), 4), this.mPaintBackground);
                }
                i2++;
            }
        }
        AppMethodBeat.o(73225);
    }

    private void drawCvvPaymentDot(Canvas canvas) {
        AppMethodBeat.i(73226);
        if (EditState.CVV_PAYMENT == this.mEditState && this.mPaintBackground != null) {
            int width = getWidth();
            int height = getHeight();
            int i2 = width / CVV_PAYMENT_LENGTH;
            int length = getText().length();
            for (int i3 = 0; i3 < length; i3++) {
                canvas.drawCircle((float) ((i2 / 2) + (i3 * i2)), (float) (height / 2), ((float) PASSWD_BLACK_DOT_SIZE) * this.mDensity, this.mPaintBackground);
            }
        }
        AppMethodBeat.o(73226);
    }

    private void drawCvv4PaymentDot(Canvas canvas) {
        AppMethodBeat.i(73227);
        if (EditState.CVV_4_PAYMENT == this.mEditState && this.mPaintBackground != null) {
            int width = getWidth();
            int height = getHeight();
            int i2 = width / CVV_4_PAYMENT_LENGTH;
            int length = getText().length();
            for (int i3 = 0; i3 < length; i3++) {
                canvas.drawCircle((float) ((i2 / 2) + (i3 * i2)), (float) (height / 2), ((float) PASSWD_BLACK_DOT_SIZE) * this.mDensity, this.mPaintBackground);
            }
        }
        AppMethodBeat.o(73227);
    }

    private void drawCardTailNum(Canvas canvas) {
        AppMethodBeat.i(73228);
        if (EditState.BANKCARD_WITH_TAILNUM == this.mEditState && this.mIsCardTailNumCanDisplay) {
            int baseline = getBaseline();
            if (baseline == -1) {
                baseline = 44;
            }
            canvas.drawText(this.mCardTailNum, (((float) CARD_TAIL_SPACE) * this.mDensity) + getPaint().measureText(getText().toString()), (float) baseline, this.mTitlePaint);
        }
        AppMethodBeat.o(73228);
    }

    public final boolean onTextContextMenuItem(int i2) {
        AppMethodBeat.i(73229);
        if ((getInputType() & 128) > 0 || EditState.PASSWORD == this.mEditState || EditState.CVV_PAYMENT == this.mEditState || EditState.CVV_4_PAYMENT == this.mEditState || this.mEditState == EditState.IDCARD_TAIL) {
            AppMethodBeat.o(73229);
            return true;
        }
        boolean onTextContextMenuItem = super.onTextContextMenuItem(i2);
        AppMethodBeat.o(73229);
        return onTextContextMenuItem;
    }

    /* access modifiers changed from: protected */
    public final void onCreateContextMenu(ContextMenu contextMenu) {
        AppMethodBeat.i(73230);
        if (!((getInputType() & 128) > 0 || EditState.PASSWORD == this.mEditState || EditState.CVV_PAYMENT == this.mEditState || EditState.CVV_4_PAYMENT == this.mEditState)) {
            super.onCreateContextMenu(contextMenu);
        }
        AppMethodBeat.o(73230);
    }

    public static void setSalt(String str) {
        AppMethodBeat.i(73231);
        Log.i("TenpaySecureEditText", "check salt: %s", str);
        if ((Integer.decode(BuildInfo.CLIENT_VERSION).intValue() & 255) < 48) {
            Log.i("TenpaySecureEditText", "check salt stack: %s", Util.getStack());
        }
        mTimeStamp = str;
        AppMethodBeat.o(73231);
    }

    private String getInputText() {
        String trim;
        AppMethodBeat.i(73232);
        if (this.mEditState == EditState.SECURITY_ANSWER) {
            trim = getText().toString();
        } else {
            trim = getText().toString().trim();
        }
        if (trim == null || trim.length() == 0) {
            AppMethodBeat.o(73232);
            return null;
        }
        switch (this.mEditState) {
            case BANKCARD:
                trim = trim.replaceAll(" ", "");
                break;
            case BANKCARD_WITH_TAILNUM:
                trim = trim.replaceAll(" ", "");
                if (this.mCardTailNum != null && this.mCardTailNum.length() > 0) {
                    trim = trim + this.mCardTailNum;
                    break;
                }
            case VALID_THRU:
                trim = trim.replaceAll(FilePathGenerator.ANDROID_DIR_SEP, "");
                if (trim != null && trim.length() == VALID_THRU_LEN) {
                    trim = trim.substring(2) + trim.substring(0, 2);
                    break;
                }
            case SECURITY_ANSWER:
                break;
            default:
                trim = trim.replaceAll(" ", "").replaceAll("x", "X");
                break;
        }
        if (!Util.isNullOrNil(this.regExFilterInput)) {
            trim = Pattern.compile(this.regExFilterInput).matcher(trim).replaceAll("").trim();
            Log.i("TenpaySecureEditText", "use filter");
        }
        AppMethodBeat.o(73232);
        return trim;
    }

    public final void setSecureEncrypt(ISecureEncrypt iSecureEncrypt) {
        this.mIEncrypt = iSecureEncrypt;
    }

    public final String getEncryptDataWithHash(boolean z) {
        AppMethodBeat.i(73233);
        String encryptDataWithHash = getEncryptDataWithHash(z, false);
        AppMethodBeat.o(73233);
        return encryptDataWithHash;
    }

    public final String getEncryptDataWithHash(boolean z, boolean z2) {
        AppMethodBeat.i(73234);
        String inputText = getInputText();
        if (inputText == null || inputText.length() == 0) {
            AppMethodBeat.o(73234);
            return null;
        }
        Log.i("TenpaySecureEditText", "timestamp: %s, 2048: %s", mTimeStamp, Boolean.valueOf(z2));
        if (this.mIEncrypt == null) {
            if (z) {
                inputText = TenpayUtil.md5HexDigest(inputText);
            }
            Encrypt encrypt = new Encrypt();
            if (mTimeStamp != null) {
                encrypt.setTimeStamp(mTimeStamp);
            }
            if (z2) {
                String encryptPasswdWithRSA2048 = encrypt.encryptPasswdWithRSA2048(inputText);
                AppMethodBeat.o(73234);
                return encryptPasswdWithRSA2048;
            }
            String encryptPasswd = encrypt.encryptPasswd(inputText);
            AppMethodBeat.o(73234);
            return encryptPasswd;
        } else if (z2) {
            String encryptPasswdWithRSA20482 = this.mIEncrypt.encryptPasswdWithRSA2048(z, inputText, mTimeStamp);
            AppMethodBeat.o(73234);
            return encryptPasswdWithRSA20482;
        } else {
            String encryptPasswd2 = this.mIEncrypt.encryptPasswd(z, inputText, mTimeStamp);
            AppMethodBeat.o(73234);
            return encryptPasswd2;
        }
    }

    public final String get3DesEncrptData() {
        AppMethodBeat.i(73235);
        String inputText = getInputText();
        if (inputText == null || inputText.length() == 0) {
            AppMethodBeat.o(73235);
            return null;
        } else if (this.mIEncrypt != null) {
            String desedeEncode = this.mIEncrypt.desedeEncode(inputText, mTimeStamp);
            AppMethodBeat.o(73235);
            return desedeEncode;
        } else {
            String desedeEncode2 = new Encrypt().desedeEncode(inputText);
            AppMethodBeat.o(73235);
            return desedeEncode2;
        }
    }

    public final String get3DesEncrptData(String str) {
        AppMethodBeat.i(73236);
        if (str == null || str.length() == 0) {
            AppMethodBeat.o(73236);
            return null;
        } else if (this.mIEncrypt != null) {
            String desedeEncode = this.mIEncrypt.desedeEncode(str, mTimeStamp);
            AppMethodBeat.o(73236);
            return desedeEncode;
        } else {
            String desedeEncode2 = new Encrypt().desedeEncode(str);
            AppMethodBeat.o(73236);
            return desedeEncode2;
        }
    }

    public final void set3DesEncrptData(String str) {
        AppMethodBeat.i(73237);
        if (str == null || str.length() == 0) {
            AppMethodBeat.o(73237);
            return;
        }
        Encrypt encrypt = new Encrypt();
        setText(encrypt.desedeDecode(str, encrypt.getRandomKey()));
        AppMethodBeat.o(73237);
    }

    public final String get3DesVerifyCode() {
        AppMethodBeat.i(73238);
        String inputText = getInputText();
        if (inputText == null || inputText.length() == 0) {
            AppMethodBeat.o(73238);
            return null;
        } else if (this.mIEncrypt != null) {
            String desedeVerifyCode = this.mIEncrypt.desedeVerifyCode(inputText, mTimeStamp);
            AppMethodBeat.o(73238);
            return desedeVerifyCode;
        } else {
            String desedeVerifyCode2 = new Encrypt().desedeVerifyCode(inputText);
            AppMethodBeat.o(73238);
            return desedeVerifyCode2;
        }
    }

    public final boolean isPhoneNum() {
        AppMethodBeat.i(73239);
        if (getText().toString().trim().length() == 11) {
            AppMethodBeat.o(73239);
            return true;
        } else if (getText().toString().contains("**")) {
            AppMethodBeat.o(73239);
            return true;
        } else {
            AppMethodBeat.o(73239);
            return false;
        }
    }

    public final boolean isBankcardNum() {
        AppMethodBeat.i(73240);
        if (getInputLength() >= BANK_CARD_LENGTH_LIMIT || getText().toString().contains("**")) {
            AppMethodBeat.o(73240);
            return true;
        }
        AppMethodBeat.o(73240);
        return false;
    }

    public final boolean isMoneyAmount() {
        AppMethodBeat.i(73241);
        boolean isMatchPattern = isMatchPattern("^\\d+(\\.\\d{0,2})?$");
        AppMethodBeat.o(73241);
        return isMatchPattern;
    }

    public final boolean isUserIdNum() {
        AppMethodBeat.i(73242);
        String trim = getText().toString().trim();
        if (getInputLength() == 15) {
            boolean isMatchPattern = isMatchPattern("^\\d{15}$");
            AppMethodBeat.o(73242);
            return isMatchPattern;
        }
        boolean invalidateID = TenpayUtil.invalidateID(trim);
        AppMethodBeat.o(73242);
        return invalidateID;
    }

    public final boolean isValidThru() {
        AppMethodBeat.i(73243);
        boolean isMatchPattern = isMatchPattern("[1-9][0-9]0[1-9]$|[1-9][0-9]1[0-2]$");
        AppMethodBeat.o(73243);
        return isMatchPattern;
    }

    public final boolean isAreaIDCardNum(int i2) {
        AppMethodBeat.i(73244);
        String trim = getText().toString().trim();
        if (trim == null || trim.length() == 0) {
            AppMethodBeat.o(73244);
            return false;
        }
        trim.replaceAll(" ", "");
        switch (i2) {
            case 1:
                boolean isUserIdNum = isUserIdNum();
                AppMethodBeat.o(73244);
                return isUserIdNum;
            default:
                AppMethodBeat.o(73244);
                return true;
        }
    }

    public final boolean isMatchPattern(String str) {
        boolean z = false;
        AppMethodBeat.i(73245);
        if (str != null) {
            try {
                z = Pattern.compile(str).matcher(getInputText()).matches();
                AppMethodBeat.o(73245);
            } catch (Exception e2) {
                AppMethodBeat.o(73245);
            }
        } else {
            AppMethodBeat.o(73245);
        }
        return z;
    }

    private boolean isMatchPattern(String str, String str2) {
        boolean z = false;
        AppMethodBeat.i(73246);
        if (str2 != null) {
            try {
                z = Pattern.compile(str2).matcher(str).matches();
                AppMethodBeat.o(73246);
            } catch (Exception e2) {
                AppMethodBeat.o(73246);
            }
        } else {
            AppMethodBeat.o(73246);
        }
        return z;
    }

    public final void ClearInput() {
        AppMethodBeat.i(73247);
        setText("");
        AppMethodBeat.o(73247);
    }

    public final int getInputLength() {
        AppMethodBeat.i(73248);
        String inputText = getInputText();
        if (inputText == null) {
            AppMethodBeat.o(73248);
            return 0;
        }
        int length = inputText.length();
        AppMethodBeat.o(73248);
        return length;
    }

    /* access modifiers changed from: protected */
    public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        int i5;
        int length;
        int i6 = 0;
        AppMethodBeat.i(73249);
        super.onTextChanged(charSequence, i2, i3, i4);
        if (this.mFilterChar != null && !TextUtils.isEmpty(charSequence)) {
            for (int i7 = i2; i7 < i2 + i4; i7++) {
                for (char c2 : this.mFilterChar) {
                    if (c2 == charSequence.charAt(i7)) {
                        String charSequence2 = charSequence.toString();
                        setText(charSequence2.substring(0, i7) + charSequence2.substring(i7 + 1));
                        setSelection(i7);
                        AppMethodBeat.o(73249);
                        return;
                    }
                }
            }
        }
        String obj = getText().toString();
        this.mIsCardTailNumCanDisplay = obj != null && obj.length() > 0;
        if (!(!isFocused() || this.mClearBtnImg == null || EditState.PASSWORD == this.mEditState || EditState.CVV_PAYMENT == this.mEditState || EditState.CVV_4_PAYMENT == this.mEditState)) {
            if (getText().toString().equals("")) {
                setCompoundDrawables(getCompoundDrawables()[0], getCompoundDrawables()[1], null, getCompoundDrawables()[3]);
            } else {
                setCompoundDrawables(getCompoundDrawables()[0], getCompoundDrawables()[1], this.mClearBtnImg, getCompoundDrawables()[3]);
            }
        }
        if (this.mEditState != null) {
            try {
                switch (this.mEditState) {
                    case BANKCARD:
                    case BANKCARD_WITH_TAILNUM:
                        if (!this.mIsSelfSet) {
                            int i8 = i2 + i4;
                            if (obj.length() > 0) {
                                if (i8 <= obj.length()) {
                                    String substring = obj.substring(0, i8);
                                    i5 = substring.length() - substring.replaceAll(" ", "").length();
                                } else {
                                    i5 = 0;
                                }
                                String replaceAll = obj.replaceAll(" ", "");
                                StringBuffer stringBuffer = new StringBuffer();
                                int length2 = replaceAll.length();
                                while (i6 + 4 < length2) {
                                    stringBuffer.append(replaceAll.substring(i6, i6 + 4));
                                    stringBuffer.append(" ");
                                    i6 += 4;
                                }
                                stringBuffer.append(replaceAll.substring(i6));
                                String stringBuffer2 = stringBuffer.toString();
                                if (i8 <= stringBuffer2.length()) {
                                    String substring2 = stringBuffer2.substring(0, i8);
                                    length = substring2.length() - substring2.replaceAll(" ", "").length();
                                } else {
                                    length = stringBuffer2.length() - stringBuffer2.replaceAll(" ", "").length();
                                }
                                this.mIsSelfSet = true;
                                setText(stringBuffer2);
                                setSelection((length + i8) - i5);
                            }
                            AppMethodBeat.o(73249);
                            return;
                        }
                        this.mIsSelfSet = false;
                        AppMethodBeat.o(73249);
                        return;
                    case VALID_THRU:
                        if (this.mIsSelfSet) {
                            this.mIsSelfSet = false;
                            break;
                        } else {
                            int length3 = obj.length();
                            if (length3 == 0 || length3 == 1) {
                                AppMethodBeat.o(73249);
                                return;
                            }
                            String replace = obj.replace(FilePathGenerator.ANDROID_DIR_SEP, "");
                            if (length3 != 2 || !obj.contains(FilePathGenerator.ANDROID_DIR_SEP)) {
                                StringBuilder sb = new StringBuilder();
                                sb.append(replace.substring(0, 2));
                                sb.append(FilePathGenerator.ANDROID_DIR_SEP);
                                if (replace.length() > 2) {
                                    sb.append(replace.substring(2));
                                }
                                replace = sb.toString();
                            }
                            int selectionStart = getSelectionStart();
                            this.mIsSelfSet = true;
                            setText(replace);
                            if (length3 != 2) {
                                setSelection(selectionStart);
                            } else if (obj.contains(FilePathGenerator.ANDROID_DIR_SEP)) {
                                setSelection(1);
                                AppMethodBeat.o(73249);
                                return;
                            } else if (selectionStart == 2) {
                                setSelection(i4 > i3 ? 3 : 2);
                                AppMethodBeat.o(73249);
                                return;
                            }
                            AppMethodBeat.o(73249);
                            return;
                        }
                    case PASSWORD:
                        if (obj.length() == PASSWD_LENGTH && this.mPasswdListener != null) {
                            this.mPasswdListener.onDone();
                            AppMethodBeat.o(73249);
                            return;
                        }
                    case CVV_PAYMENT:
                        if (obj.length() == CVV_PAYMENT_LENGTH && this.mPasswdListener != null) {
                            this.mPasswdListener.onDone();
                            AppMethodBeat.o(73249);
                            return;
                        }
                    case CVV_4_PAYMENT:
                        if (obj.length() == CVV_4_PAYMENT_LENGTH && this.mPasswdListener != null) {
                            this.mPasswdListener.onDone();
                            AppMethodBeat.o(73249);
                            return;
                        }
                }
                AppMethodBeat.o(73249);
                return;
            } catch (Exception e2) {
            }
        }
        AppMethodBeat.o(73249);
    }

    public final void setOnPasswdInputListener(OnPasswdInputListener onPasswdInputListener) {
        this.mPasswdListener = onPasswdInputListener;
    }

    public final void setUseOfKinda(boolean z) {
        this.mIsUseOfKinda = z;
    }

    public final void setCursorStyle(int i2) {
        AppMethodBeat.i(174541);
        if (i2 == -1) {
            AppMethodBeat.o(174541);
            return;
        }
        try {
            Field declaredField = TextView.class.getDeclaredField("mCursorDrawableRes");
            declaredField.setAccessible(true);
            declaredField.set(this, Integer.valueOf(i2));
            AppMethodBeat.o(174541);
        } catch (Exception e2) {
            AppMethodBeat.o(174541);
        }
    }

    public final void setKindaEditTextCallBackListener(IKindaEditTextCallBackListener iKindaEditTextCallBackListener) {
        this.mKindaEditTextCallBackListener = iKindaEditTextCallBackListener;
    }
}

package com.tenpay.android.wechat;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;

public class MyKeyboardWindow extends LinearLayout {
    public static final int X_MODE_CHARACTER = 1;
    public static final int X_MODE_DOT = 2;
    public static final int X_MODE_NONE = 0;
    private Context mContext;
    private EditText mInputEditText;
    private Button mKey0;
    private Button mKey1;
    private Button mKey2;
    private Button mKey3;
    private Button mKey4;
    private Button mKey5;
    private Button mKey6;
    private Button mKey7;
    private Button mKey8;
    private Button mKey9;
    private RelativeLayout mKeyD;
    private Button mKeyX;
    private OnTouchListener mOnTouchListener;
    private int mXMode = 0;

    public interface OnTouchListener {
        boolean onTouch(View view, MotionEvent motionEvent);
    }

    public MyKeyboardWindow(Context context) {
        super(context);
        AppMethodBeat.i(130947);
        init(context);
        AppMethodBeat.o(130947);
    }

    public MyKeyboardWindow(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(130948);
        init(context);
        AppMethodBeat.o(130948);
    }

    private void init(Context context) {
        AppMethodBeat.i(130949);
        this.mContext = context.getApplicationContext();
        TenpayTTSUtil.init(context);
        View inflate = LayoutInflater.from(context).inflate(this.mContext.getResources().getIdentifier("tenpay_number_keyboard", "layout", this.mContext.getPackageName()), (ViewGroup) this, true);
        this.mKey1 = (Button) inflate.findViewById(getId("tenpay_keyboard_1"));
        this.mKey2 = (Button) inflate.findViewById(getId("tenpay_keyboard_2"));
        this.mKey3 = (Button) inflate.findViewById(getId("tenpay_keyboard_3"));
        this.mKey4 = (Button) inflate.findViewById(getId("tenpay_keyboard_4"));
        this.mKey5 = (Button) inflate.findViewById(getId("tenpay_keyboard_5"));
        this.mKey6 = (Button) inflate.findViewById(getId("tenpay_keyboard_6"));
        this.mKey7 = (Button) inflate.findViewById(getId("tenpay_keyboard_7"));
        this.mKey8 = (Button) inflate.findViewById(getId("tenpay_keyboard_8"));
        this.mKey9 = (Button) inflate.findViewById(getId("tenpay_keyboard_9"));
        this.mKeyX = (Button) inflate.findViewById(getId("tenpay_keyboard_x"));
        this.mKey0 = (Button) inflate.findViewById(getId("tenpay_keyboard_0"));
        this.mKeyD = (RelativeLayout) inflate.findViewById(getId("tenpay_keyboard_d"));
        AnonymousClass1 r0 = new View.OnClickListener() {
            /* class com.tenpay.android.wechat.MyKeyboardWindow.AnonymousClass1 */
            private byte _hellAccFlag_;

            public void onClick(View view) {
                int i2;
                AppMethodBeat.i(130946);
                b bVar = new b();
                bVar.bm(view);
                a.b("com/tenpay/android/wechat/MyKeyboardWindow$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (MyKeyboardWindow.this.mInputEditText == null) {
                    a.a(this, "com/tenpay/android/wechat/MyKeyboardWindow$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(130946);
                } else if (view.getId() == MyKeyboardWindow.this.getId("tenpay_keyboard_x")) {
                    switch (MyKeyboardWindow.this.mXMode) {
                        case 1:
                            MyKeyboardWindow.this.mInputEditText.dispatchKeyEvent(new KeyEvent(0, 59));
                            MyKeyboardWindow.this.mInputEditText.dispatchKeyEvent(new KeyEvent(0, 52));
                            MyKeyboardWindow.this.mInputEditText.dispatchKeyEvent(new KeyEvent(1, 59));
                            break;
                        case 2:
                            MyKeyboardWindow.this.mInputEditText.dispatchKeyEvent(new KeyEvent(0, 56));
                            break;
                    }
                    a.a(this, "com/tenpay/android/wechat/MyKeyboardWindow$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(130946);
                } else {
                    if (view.getId() == MyKeyboardWindow.this.getId("tenpay_keyboard_1")) {
                        i2 = 8;
                    } else if (view.getId() == MyKeyboardWindow.this.getId("tenpay_keyboard_2")) {
                        i2 = 9;
                    } else if (view.getId() == MyKeyboardWindow.this.getId("tenpay_keyboard_3")) {
                        i2 = 10;
                    } else if (view.getId() == MyKeyboardWindow.this.getId("tenpay_keyboard_4")) {
                        i2 = 11;
                    } else if (view.getId() == MyKeyboardWindow.this.getId("tenpay_keyboard_5")) {
                        i2 = 12;
                    } else if (view.getId() == MyKeyboardWindow.this.getId("tenpay_keyboard_6")) {
                        i2 = 13;
                    } else if (view.getId() == MyKeyboardWindow.this.getId("tenpay_keyboard_7")) {
                        i2 = 14;
                    } else if (view.getId() == MyKeyboardWindow.this.getId("tenpay_keyboard_8")) {
                        i2 = 15;
                    } else if (view.getId() == MyKeyboardWindow.this.getId("tenpay_keyboard_9")) {
                        i2 = 16;
                    } else if (view.getId() == MyKeyboardWindow.this.getId("tenpay_keyboard_0")) {
                        i2 = 7;
                    } else if (view.getId() == MyKeyboardWindow.this.getId("tenpay_keyboard_d")) {
                        i2 = 67;
                    } else {
                        i2 = 0;
                    }
                    MyKeyboardWindow.this.mInputEditText.dispatchKeyEvent(new KeyEvent(0, i2));
                    MyKeyboardWindow.this.mInputEditText.dispatchKeyEvent(new KeyEvent(1, i2));
                    a.a(this, "com/tenpay/android/wechat/MyKeyboardWindow$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(130946);
                }
            }
        };
        if (Build.VERSION.SDK_INT >= 14) {
            this.mKey1.setContentDescription("1");
            this.mKey2.setContentDescription("2");
            this.mKey3.setContentDescription(TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL);
            this.mKey4.setContentDescription("4");
            this.mKey5.setContentDescription("5");
            this.mKey6.setContentDescription("6");
            this.mKey7.setContentDescription("7");
            this.mKey8.setContentDescription("8");
            this.mKey9.setContentDescription("9");
            this.mKey0.setContentDescription(AppEventsConstants.EVENT_PARAM_VALUE_NO);
            this.mKeyX.setContentDescription("字母X");
            this.mKeyD.setContentDescription("删除");
        }
        this.mKey1.setOnClickListener(r0);
        this.mKey2.setOnClickListener(r0);
        this.mKey3.setOnClickListener(r0);
        this.mKey4.setOnClickListener(r0);
        this.mKey5.setOnClickListener(r0);
        this.mKey6.setOnClickListener(r0);
        this.mKey7.setOnClickListener(r0);
        this.mKey8.setOnClickListener(r0);
        this.mKey9.setOnClickListener(r0);
        this.mKeyX.setOnClickListener(r0);
        this.mKey0.setOnClickListener(r0);
        this.mKeyD.setOnClickListener(r0);
        AppMethodBeat.o(130949);
    }

    public void setSecureAccessibility(View.AccessibilityDelegate accessibilityDelegate) {
        AppMethodBeat.i(130950);
        this.mKey0.setAccessibilityDelegate(accessibilityDelegate);
        this.mKey1.setAccessibilityDelegate(accessibilityDelegate);
        this.mKey2.setAccessibilityDelegate(accessibilityDelegate);
        this.mKey3.setAccessibilityDelegate(accessibilityDelegate);
        this.mKey4.setAccessibilityDelegate(accessibilityDelegate);
        this.mKey5.setAccessibilityDelegate(accessibilityDelegate);
        this.mKey6.setAccessibilityDelegate(accessibilityDelegate);
        this.mKey7.setAccessibilityDelegate(accessibilityDelegate);
        this.mKey8.setAccessibilityDelegate(accessibilityDelegate);
        this.mKey9.setAccessibilityDelegate(accessibilityDelegate);
        this.mKeyX.setAccessibilityDelegate(accessibilityDelegate);
        this.mKeyD.setAccessibilityDelegate(accessibilityDelegate);
        AppMethodBeat.o(130950);
    }

    public void resetSecureAccessibility() {
        AppMethodBeat.i(130951);
        this.mKey0.setAccessibilityDelegate(null);
        this.mKey1.setAccessibilityDelegate(null);
        this.mKey2.setAccessibilityDelegate(null);
        this.mKey3.setAccessibilityDelegate(null);
        this.mKey4.setAccessibilityDelegate(null);
        this.mKey5.setAccessibilityDelegate(null);
        this.mKey6.setAccessibilityDelegate(null);
        this.mKey7.setAccessibilityDelegate(null);
        this.mKey8.setAccessibilityDelegate(null);
        this.mKey9.setAccessibilityDelegate(null);
        this.mKeyX.setAccessibilityDelegate(null);
        this.mKeyD.setAccessibilityDelegate(null);
        AppMethodBeat.o(130951);
    }

    public void setInputEditText(EditText editText) {
        AppMethodBeat.i(130952);
        if (editText != null) {
            this.mInputEditText = editText;
            int imeOptions = this.mInputEditText.getImeOptions();
            CharSequence imeActionLabel = this.mInputEditText.getImeActionLabel();
            if (!TextUtils.isEmpty(imeActionLabel)) {
                this.mKeyX.setText(imeActionLabel);
            }
            switch (imeOptions) {
                case 1:
                    this.mXMode = 0;
                    if (TextUtils.isEmpty(imeActionLabel)) {
                        this.mKeyX.setText("");
                        break;
                    }
                    break;
            }
        }
        AppMethodBeat.o(130952);
    }

    public void setXMode(int i2) {
        AppMethodBeat.i(130953);
        this.mXMode = i2;
        switch (i2) {
            case 0:
                this.mKeyX.setText("");
                this.mKeyX.setBackgroundResource(getDrawableId("tenpay_keybtn_bottom_new"));
                AppMethodBeat.o(130953);
                return;
            case 1:
                this.mKeyX.setText("X");
                this.mKeyX.setBackgroundResource(getDrawableId("tenpay_keybtn_bottom_new"));
                AppMethodBeat.o(130953);
                return;
            case 2:
                this.mKeyX.setText(".");
                this.mKeyX.setBackgroundResource(getDrawableId("tenpay_keybtn_bottom_new"));
                AppMethodBeat.o(130953);
                return;
            default:
                this.mXMode = 0;
                AppMethodBeat.o(130953);
                return;
        }
    }

    /* access modifiers changed from: protected */
    public int getId(String str) {
        AppMethodBeat.i(130954);
        int identifier = this.mContext.getResources().getIdentifier(str, "id", this.mContext.getPackageName());
        AppMethodBeat.o(130954);
        return identifier;
    }

    /* access modifiers changed from: protected */
    public int getDrawableId(String str) {
        AppMethodBeat.i(130955);
        int identifier = this.mContext.getResources().getIdentifier(str, "drawable", this.mContext.getPackageName());
        AppMethodBeat.o(130955);
        return identifier;
    }

    public void onDetachedFromWindow() {
        AppMethodBeat.i(130956);
        super.onDetachedFromWindow();
        TenpayTTSUtil.destroy();
        AppMethodBeat.o(130956);
    }

    public void setOnTouchListener(OnTouchListener onTouchListener) {
        this.mOnTouchListener = onTouchListener;
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(256167);
        try {
            if (this.mOnTouchListener != null) {
                this.mOnTouchListener.onTouch(this, motionEvent);
            }
        } catch (Throwable th) {
        }
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        AppMethodBeat.o(256167);
        return dispatchTouchEvent;
    }
}

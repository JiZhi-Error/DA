package com.tencent.mm.plugin.appbrand.widget.input.numberpad;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;

public class BaseNumberKeyboardView extends LinearLayout {
    public View jBN;
    private Context mContext;
    private EditText mInputEditText;
    public Button mKey0;
    public Button mKey1;
    public Button mKey2;
    public Button mKey3;
    public Button mKey4;
    public Button mKey5;
    public Button mKey6;
    public Button mKey7;
    public Button mKey8;
    public Button mKey9;
    public Button mKeyX;
    private int mXMode = 0;
    public boolean orS;
    public ImageButton owM;

    public BaseNumberKeyboardView(Context context) {
        super(context);
        AppMethodBeat.i(136679);
        init(context);
        AppMethodBeat.o(136679);
    }

    public BaseNumberKeyboardView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(136680);
        init(context);
        AppMethodBeat.o(136680);
    }

    private void init(Context context) {
        AppMethodBeat.i(136681);
        this.mContext = context.getApplicationContext();
        this.jBN = LayoutInflater.from(context).inflate(R.layout.gv, (ViewGroup) this, true);
        this.mKey1 = (Button) this.jBN.findViewById(getId("tenpay_keyboard_1"));
        this.mKey2 = (Button) this.jBN.findViewById(getId("tenpay_keyboard_2"));
        this.mKey3 = (Button) this.jBN.findViewById(getId("tenpay_keyboard_3"));
        this.mKey4 = (Button) this.jBN.findViewById(getId("tenpay_keyboard_4"));
        this.mKey5 = (Button) this.jBN.findViewById(getId("tenpay_keyboard_5"));
        this.mKey6 = (Button) this.jBN.findViewById(getId("tenpay_keyboard_6"));
        this.mKey7 = (Button) this.jBN.findViewById(getId("tenpay_keyboard_7"));
        this.mKey8 = (Button) this.jBN.findViewById(getId("tenpay_keyboard_8"));
        this.mKey9 = (Button) this.jBN.findViewById(getId("tenpay_keyboard_9"));
        this.mKeyX = (Button) this.jBN.findViewById(getId("tenpay_keyboard_x"));
        this.mKey0 = (Button) this.jBN.findViewById(getId("tenpay_keyboard_0"));
        this.owM = (ImageButton) this.jBN.findViewById(getId("tenpay_keyboard_d"));
        AnonymousClass1 r0 = new View.OnClickListener() {
            /* class com.tencent.mm.plugin.appbrand.widget.input.numberpad.BaseNumberKeyboardView.AnonymousClass1 */

            public final void onClick(View view) {
                int i2;
                AppMethodBeat.i(136678);
                b bVar = new b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/appbrand/widget/input/numberpad/BaseNumberKeyboardView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (BaseNumberKeyboardView.this.mInputEditText == null) {
                    a.a(this, "com/tencent/mm/plugin/appbrand/widget/input/numberpad/BaseNumberKeyboardView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(136678);
                } else if (view.getId() == BaseNumberKeyboardView.this.getId("tenpay_keyboard_x")) {
                    switch (BaseNumberKeyboardView.this.mXMode) {
                        case 1:
                            BaseNumberKeyboardView.this.mInputEditText.dispatchKeyEvent(new KeyEvent(0, 59));
                            BaseNumberKeyboardView.this.mInputEditText.dispatchKeyEvent(new KeyEvent(0, 52));
                            BaseNumberKeyboardView.this.mInputEditText.dispatchKeyEvent(new KeyEvent(1, 59));
                            break;
                        case 2:
                            BaseNumberKeyboardView.this.mInputEditText.dispatchKeyEvent(new KeyEvent(0, 56));
                            break;
                    }
                    a.a(this, "com/tencent/mm/plugin/appbrand/widget/input/numberpad/BaseNumberKeyboardView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(136678);
                } else {
                    if (view.getId() == BaseNumberKeyboardView.this.getId("tenpay_keyboard_1")) {
                        i2 = 8;
                    } else if (view.getId() == BaseNumberKeyboardView.this.getId("tenpay_keyboard_2")) {
                        i2 = 9;
                    } else if (view.getId() == BaseNumberKeyboardView.this.getId("tenpay_keyboard_3")) {
                        i2 = 10;
                    } else if (view.getId() == BaseNumberKeyboardView.this.getId("tenpay_keyboard_4")) {
                        i2 = 11;
                    } else if (view.getId() == BaseNumberKeyboardView.this.getId("tenpay_keyboard_5")) {
                        i2 = 12;
                    } else if (view.getId() == BaseNumberKeyboardView.this.getId("tenpay_keyboard_6")) {
                        i2 = 13;
                    } else if (view.getId() == BaseNumberKeyboardView.this.getId("tenpay_keyboard_7")) {
                        i2 = 14;
                    } else if (view.getId() == BaseNumberKeyboardView.this.getId("tenpay_keyboard_8")) {
                        i2 = 15;
                    } else if (view.getId() == BaseNumberKeyboardView.this.getId("tenpay_keyboard_9")) {
                        i2 = 16;
                    } else if (view.getId() == BaseNumberKeyboardView.this.getId("tenpay_keyboard_0")) {
                        i2 = 7;
                    } else if (view.getId() == BaseNumberKeyboardView.this.getId("tenpay_keyboard_d")) {
                        i2 = 67;
                    } else {
                        i2 = 0;
                    }
                    BaseNumberKeyboardView.this.mInputEditText.dispatchKeyEvent(new KeyEvent(0, i2));
                    BaseNumberKeyboardView.this.mInputEditText.dispatchKeyEvent(new KeyEvent(1, i2));
                    a.a(this, "com/tencent/mm/plugin/appbrand/widget/input/numberpad/BaseNumberKeyboardView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(136678);
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
            this.owM.setContentDescription("删除");
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
        this.owM.setOnClickListener(r0);
        AppMethodBeat.o(136681);
    }

    public void setSecureAccessibility(View.AccessibilityDelegate accessibilityDelegate) {
        AppMethodBeat.i(136682);
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
        this.owM.setAccessibilityDelegate(accessibilityDelegate);
        AppMethodBeat.o(136682);
    }

    public void setInputEditText(EditText editText) {
        AppMethodBeat.i(136683);
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
        AppMethodBeat.o(136683);
    }

    public void setXMode(int i2) {
        AppMethodBeat.i(136684);
        this.mXMode = i2;
        switch (i2) {
            case 0:
                this.mKeyX.setText("");
                if (this.orS) {
                    this.mKeyX.setBackgroundResource(R.color.eh);
                    AppMethodBeat.o(136684);
                    return;
                }
                this.mKeyX.setBackgroundResource(R.color.ee);
                AppMethodBeat.o(136684);
                return;
            case 1:
                this.mKeyX.setText("X");
                if (this.orS) {
                    this.mKeyX.setBackgroundResource(R.drawable.ayu);
                    AppMethodBeat.o(136684);
                    return;
                }
                this.mKeyX.setBackgroundResource(R.drawable.ayt);
                AppMethodBeat.o(136684);
                return;
            case 2:
                this.mKeyX.setText(".");
                if (this.orS) {
                    this.mKeyX.setBackgroundResource(R.drawable.ayu);
                    AppMethodBeat.o(136684);
                    return;
                }
                this.mKeyX.setBackgroundResource(R.drawable.ayt);
                AppMethodBeat.o(136684);
                return;
            default:
                this.mXMode = 0;
                AppMethodBeat.o(136684);
                return;
        }
    }

    public final int getId(String str) {
        AppMethodBeat.i(136685);
        int identifier = this.mContext.getResources().getIdentifier(str, "id", this.mContext.getPackageName());
        AppMethodBeat.o(136685);
        return identifier;
    }

    public void onDetachedFromWindow() {
        AppMethodBeat.i(136686);
        super.onDetachedFromWindow();
        AppMethodBeat.o(136686);
    }
}

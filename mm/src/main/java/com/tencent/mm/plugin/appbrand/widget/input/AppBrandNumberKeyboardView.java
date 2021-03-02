package com.tencent.mm.plugin.appbrand.widget.input;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputConnection;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.appbrand.widget.input.numberpad.BaseNumberKeyboardView;
import com.tencent.mm.plugin.appbrand.widget.input.numberpad.a;
import com.tencent.mm.sdk.platformtools.Log;

public final class AppBrandNumberKeyboardView extends BaseNumberKeyboardView {
    private int otS = 0;
    private final SparseArray<String> otT = new SparseArray<String>() {
        /* class com.tencent.mm.plugin.appbrand.widget.input.AppBrandNumberKeyboardView.AnonymousClass1 */

        {
            AppMethodBeat.i(136491);
            put(1, "tenpay_keyboard_1");
            put(2, "tenpay_keyboard_2");
            put(3, "tenpay_keyboard_3");
            put(4, "tenpay_keyboard_4");
            put(5, "tenpay_keyboard_5");
            put(6, "tenpay_keyboard_6");
            put(7, "tenpay_keyboard_7");
            put(8, "tenpay_keyboard_8");
            put(9, "tenpay_keyboard_9");
            put(0, "tenpay_keyboard_0");
            AppMethodBeat.o(136491);
        }
    };
    InputConnection otU;
    a otV;

    static /* synthetic */ int a(AppBrandNumberKeyboardView appBrandNumberKeyboardView, String str) {
        AppMethodBeat.i(136500);
        int id = appBrandNumberKeyboardView.getId(str);
        AppMethodBeat.o(136500);
        return id;
    }

    static /* synthetic */ int b(AppBrandNumberKeyboardView appBrandNumberKeyboardView, String str) {
        AppMethodBeat.i(136501);
        int id = appBrandNumberKeyboardView.getId(str);
        AppMethodBeat.o(136501);
        return id;
    }

    public AppBrandNumberKeyboardView(Context context) {
        super(context);
        AppMethodBeat.i(136495);
        init();
        AppMethodBeat.o(136495);
    }

    public AppBrandNumberKeyboardView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(136496);
        init();
        AppMethodBeat.o(136496);
    }

    private void init() {
        AppMethodBeat.i(136497);
        AnonymousClass2 r2 = new View.OnClickListener() {
            /* class com.tencent.mm.plugin.appbrand.widget.input.AppBrandNumberKeyboardView.AnonymousClass2 */

            public final void onClick(View view) {
                String str;
                AppMethodBeat.i(136492);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/widget/input/AppBrandNumberKeyboardView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (AppBrandNumberKeyboardView.this.otU == null) {
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/widget/input/AppBrandNumberKeyboardView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(136492);
                    return;
                }
                String str2 = null;
                if (view.getId() == AppBrandNumberKeyboardView.a(AppBrandNumberKeyboardView.this, "tenpay_keyboard_x")) {
                    switch (AppBrandNumberKeyboardView.this.otS) {
                        case 1:
                            str2 = "X";
                            break;
                        case 2:
                            str2 = ".";
                            break;
                        default:
                            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/widget/input/AppBrandNumberKeyboardView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                            AppMethodBeat.o(136492);
                            return;
                    }
                } else {
                    int i2 = 0;
                    while (i2 < AppBrandNumberKeyboardView.this.otT.size()) {
                        if (view.getId() == AppBrandNumberKeyboardView.b(AppBrandNumberKeyboardView.this, (String) AppBrandNumberKeyboardView.this.otT.valueAt(i2))) {
                            str = String.valueOf(AppBrandNumberKeyboardView.this.otT.keyAt(i2));
                        } else {
                            str = str2;
                        }
                        i2++;
                        str2 = str;
                    }
                }
                if (TextUtils.isEmpty(str2)) {
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/widget/input/AppBrandNumberKeyboardView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(136492);
                    return;
                }
                AppBrandNumberKeyboardView.this.otU.commitText(str2, str2.length());
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/widget/input/AppBrandNumberKeyboardView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(136492);
            }
        };
        for (int i2 = 0; i2 < this.otT.size(); i2++) {
            findViewById(getId(this.otT.valueAt(i2))).setOnClickListener(r2);
        }
        findViewById(getId("tenpay_keyboard_x")).setOnClickListener(r2);
        findViewById(getId("tenpay_keyboard_d")).setOnClickListener(null);
        findViewById(getId("tenpay_keyboard_d")).setOnTouchListener(new an() {
            /* class com.tencent.mm.plugin.appbrand.widget.input.AppBrandNumberKeyboardView.AnonymousClass3 */

            /* access modifiers changed from: protected */
            @Override // com.tencent.mm.plugin.appbrand.widget.input.an
            public final void bJj() {
                AppMethodBeat.i(136493);
                Log.d("MicroMsg.AppBrand.AppBrandNumberKeyboardView", "backspace onSingleTap");
                AppBrandNumberKeyboardView.d(AppBrandNumberKeyboardView.this);
                AppMethodBeat.o(136493);
            }

            /* access modifiers changed from: protected */
            @Override // com.tencent.mm.plugin.appbrand.widget.input.an
            public final void cbF() {
                AppMethodBeat.i(136494);
                Log.d("MicroMsg.AppBrand.AppBrandNumberKeyboardView", "backspace onRepeat");
                AppBrandNumberKeyboardView.d(AppBrandNumberKeyboardView.this);
                AppMethodBeat.o(136494);
            }
        });
        AppMethodBeat.o(136497);
    }

    @Override // com.tencent.mm.plugin.appbrand.widget.input.numberpad.BaseNumberKeyboardView
    public final void setXMode(int i2) {
        AppMethodBeat.i(136498);
        super.setXMode(i2);
        this.otS = i2;
        AppMethodBeat.o(136498);
    }

    @Override // com.tencent.mm.plugin.appbrand.widget.input.numberpad.BaseNumberKeyboardView
    public final void onDetachedFromWindow() {
        AppMethodBeat.i(136499);
        super.onDetachedFromWindow();
        setInputEditText(null);
        AppMethodBeat.o(136499);
    }

    static /* synthetic */ boolean d(AppBrandNumberKeyboardView appBrandNumberKeyboardView) {
        AppMethodBeat.i(136502);
        if (appBrandNumberKeyboardView.otU != null) {
            if (!TextUtils.isEmpty(appBrandNumberKeyboardView.otU.getTextBeforeCursor(1, 0))) {
                appBrandNumberKeyboardView.otU.deleteSurroundingText(1, 0);
            } else {
                appBrandNumberKeyboardView.otU.sendKeyEvent(new KeyEvent(0, 67));
                appBrandNumberKeyboardView.otU.sendKeyEvent(new KeyEvent(1, 67));
            }
            AppMethodBeat.o(136502);
            return true;
        }
        AppMethodBeat.o(136502);
        return false;
    }
}

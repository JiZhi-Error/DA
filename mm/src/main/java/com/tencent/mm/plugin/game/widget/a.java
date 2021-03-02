package com.tencent.mm.plugin.game.widget;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.text.Editable;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextWatcher;
import android.text.method.SingleLineTransformationMethod;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;

public final class a {
    private TextPaint Ol;
    TextView Ws;
    private TextWatcher aws = new C1410a(this, (byte) 0);
    private float gPN;
    private boolean mEnabled;
    private ArrayList<b> mListeners;
    private int pME;
    float xZB;
    float xZC;
    float xZD;
    boolean xZE;

    public interface b {
    }

    public static a a(TextView textView, AttributeSet attributeSet) {
        AppMethodBeat.i(42578);
        a aVar = new a(textView);
        if (attributeSet != null) {
            aVar.r(0, (float) ((int) aVar.xZB)).bp(aVar.xZD);
        }
        aVar.pX(true);
        AppMethodBeat.o(42578);
        return aVar;
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x009d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void a(android.widget.TextView r10, android.text.TextPaint r11, float r12, float r13, int r14, float r15) {
        /*
        // Method dump skipped, instructions count: 161
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.game.widget.a.a(android.widget.TextView, android.text.TextPaint, float, float, int, float):void");
    }

    private static float a(CharSequence charSequence, TextPaint textPaint, float f2, int i2, float f3, float f4, float f5, DisplayMetrics displayMetrics) {
        StaticLayout staticLayout;
        int i3;
        AppMethodBeat.i(42580);
        while (true) {
            float f6 = (f3 + f4) / 2.0f;
            textPaint.setTextSize(TypedValue.applyDimension(0, f6, displayMetrics));
            if (i2 != 1) {
                StaticLayout staticLayout2 = new StaticLayout(charSequence, textPaint, (int) f2, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, true);
                staticLayout = staticLayout2;
                i3 = staticLayout2.getLineCount();
            } else {
                staticLayout = null;
                i3 = 1;
            }
            if (i3 > i2) {
                if (f4 - f3 < f5) {
                    AppMethodBeat.o(42580);
                    return f3;
                }
                f4 = f6;
            } else if (i3 < i2) {
                f3 = f6;
            } else {
                float f7 = 0.0f;
                if (i2 == 1) {
                    f7 = textPaint.measureText(charSequence, 0, charSequence.length());
                } else {
                    for (int i4 = 0; i4 < i3; i4++) {
                        if (staticLayout.getLineWidth(i4) > f7) {
                            f7 = staticLayout.getLineWidth(i4);
                        }
                    }
                }
                if (f4 - f3 < f5) {
                    AppMethodBeat.o(42580);
                    return f3;
                } else if (f7 > f2) {
                    f4 = f6;
                } else if (f7 < f2) {
                    f3 = f6;
                } else {
                    AppMethodBeat.o(42580);
                    return f6;
                }
            }
        }
    }

    private a(TextView textView) {
        AppMethodBeat.i(42581);
        float f2 = textView.getContext().getResources().getDisplayMetrics().scaledDensity;
        this.Ws = textView;
        this.Ol = new TextPaint();
        setRawTextSize(textView.getTextSize());
        int i2 = -1;
        TransformationMethod transformationMethod = textView.getTransformationMethod();
        if (transformationMethod != null && (transformationMethod instanceof SingleLineTransformationMethod)) {
            i2 = 1;
        } else if (Build.VERSION.SDK_INT >= 16) {
            i2 = textView.getMaxLines();
        }
        this.pME = i2;
        this.xZB = 8.0f * f2;
        this.xZC = this.gPN;
        this.xZD = 0.5f;
        AppMethodBeat.o(42581);
    }

    public final a a(b bVar) {
        AppMethodBeat.i(42582);
        if (this.mListeners == null) {
            this.mListeners = new ArrayList<>();
        }
        this.mListeners.add(bVar);
        AppMethodBeat.o(42582);
        return this;
    }

    public final a bp(float f2) {
        AppMethodBeat.i(42583);
        if (this.xZD != f2) {
            this.xZD = f2;
            dWT();
        }
        AppMethodBeat.o(42583);
        return this;
    }

    public final a r(int i2, float f2) {
        AppMethodBeat.i(42584);
        Context context = this.Ws.getContext();
        Resources system = Resources.getSystem();
        if (context != null) {
            system = context.getResources();
        }
        bq(TypedValue.applyDimension(i2, f2, system.getDisplayMetrics()));
        AppMethodBeat.o(42584);
        return this;
    }

    private void bq(float f2) {
        AppMethodBeat.i(42585);
        if (f2 != this.xZB) {
            this.xZB = f2;
            dWT();
        }
        AppMethodBeat.o(42585);
    }

    public final a OC(int i2) {
        AppMethodBeat.i(42586);
        if (this.pME != i2) {
            this.pME = i2;
            dWT();
        }
        AppMethodBeat.o(42586);
        return this;
    }

    public final a pX(boolean z) {
        AppMethodBeat.i(42587);
        if (this.mEnabled != z) {
            this.mEnabled = z;
            if (z) {
                this.Ws.addTextChangedListener(this.aws);
                dWT();
            } else {
                this.Ws.removeTextChangedListener(this.aws);
                this.Ws.setTextSize(0, this.gPN);
            }
        }
        AppMethodBeat.o(42587);
        return this;
    }

    /* access modifiers changed from: package-private */
    public final void setRawTextSize(float f2) {
        if (this.gPN != f2) {
            this.gPN = f2;
        }
    }

    public final void dWT() {
        AppMethodBeat.i(42588);
        float textSize = this.Ws.getTextSize();
        this.xZE = true;
        a(this.Ws, this.Ol, this.xZB, this.xZC, this.pME, this.xZD);
        this.xZE = false;
        if (this.Ws.getTextSize() != textSize) {
            dWU();
        }
        AppMethodBeat.o(42588);
    }

    private void dWU() {
        AppMethodBeat.i(42589);
        if (this.mListeners == null) {
            AppMethodBeat.o(42589);
            return;
        }
        Iterator<b> it = this.mListeners.iterator();
        while (it.hasNext()) {
            it.next();
        }
        AppMethodBeat.o(42589);
    }

    /* renamed from: com.tencent.mm.plugin.game.widget.a$a  reason: collision with other inner class name */
    class C1410a implements TextWatcher {
        private C1410a() {
        }

        /* synthetic */ C1410a(a aVar, byte b2) {
            this();
        }

        public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            AppMethodBeat.i(42577);
            a.this.dWT();
            AppMethodBeat.o(42577);
        }

        public final void afterTextChanged(Editable editable) {
        }
    }
}

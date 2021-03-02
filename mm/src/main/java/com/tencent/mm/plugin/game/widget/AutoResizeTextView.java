package com.tencent.mm.plugin.game.widget;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.widget.a;

public class AutoResizeTextView extends TextView implements a.b {
    private a xZx;

    public AutoResizeTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(42558);
        i(attributeSet);
        AppMethodBeat.o(42558);
    }

    public AutoResizeTextView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(42559);
        i(attributeSet);
        AppMethodBeat.o(42559);
    }

    private void i(AttributeSet attributeSet) {
        AppMethodBeat.i(42560);
        this.xZx = a.a(this, attributeSet).a(this);
        AppMethodBeat.o(42560);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(42561);
        super.onLayout(z, i2, i3, i4, i5);
        if (this.xZx != null) {
            this.xZx.dWT();
        }
        AppMethodBeat.o(42561);
    }

    public void setTextSize(int i2, float f2) {
        AppMethodBeat.i(42562);
        super.setTextSize(i2, f2);
        if (this.xZx != null) {
            a aVar = this.xZx;
            if (!aVar.xZE) {
                Context context = aVar.Ws.getContext();
                Resources system = Resources.getSystem();
                if (context != null) {
                    system = context.getResources();
                }
                aVar.setRawTextSize(TypedValue.applyDimension(i2, f2, system.getDisplayMetrics()));
            }
        }
        AppMethodBeat.o(42562);
    }

    public void setLines(int i2) {
        AppMethodBeat.i(42563);
        super.setLines(i2);
        if (this.xZx != null) {
            this.xZx.OC(i2);
        }
        AppMethodBeat.o(42563);
    }

    public void setMaxLines(int i2) {
        AppMethodBeat.i(42564);
        super.setMaxLines(i2);
        if (this.xZx != null) {
            this.xZx.OC(i2);
        }
        AppMethodBeat.o(42564);
    }

    public a getAutofitHelper() {
        return this.xZx;
    }

    public void setSizeToFit(boolean z) {
        AppMethodBeat.i(42565);
        this.xZx.pX(z);
        AppMethodBeat.o(42565);
    }

    public float getMaxTextSize() {
        return this.xZx.xZC;
    }

    public void setMaxTextSize(float f2) {
        AppMethodBeat.i(42566);
        a aVar = this.xZx;
        Context context = aVar.Ws.getContext();
        Resources system = Resources.getSystem();
        if (context != null) {
            system = context.getResources();
        }
        float applyDimension = TypedValue.applyDimension(2, f2, system.getDisplayMetrics());
        if (applyDimension != aVar.xZC) {
            aVar.xZC = applyDimension;
            aVar.dWT();
        }
        AppMethodBeat.o(42566);
    }

    public float getMinTextSize() {
        return this.xZx.xZB;
    }

    public void setMinTextSize(int i2) {
        AppMethodBeat.i(42567);
        this.xZx.r(2, (float) i2);
        AppMethodBeat.o(42567);
    }

    public float getPrecision() {
        return this.xZx.xZD;
    }

    public void setPrecision(float f2) {
        AppMethodBeat.i(42568);
        this.xZx.bp(f2);
        AppMethodBeat.o(42568);
    }
}

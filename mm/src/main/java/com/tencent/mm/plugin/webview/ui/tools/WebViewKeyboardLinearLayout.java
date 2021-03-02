package com.tencent.mm.plugin.webview.ui.tools;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.KeyboardLinearLayout;

public class WebViewKeyboardLinearLayout extends KeyboardLinearLayout {
    boolean Jgc;
    private int Jgd;
    private int Jge;
    private int Jgf;
    private boolean mHasInit = false;
    private int mHeight;

    public WebViewKeyboardLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public WebViewKeyboardLinearLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    @Override // com.tencent.mm.ui.KeyboardLinearLayout, com.tencent.mm.ui.base.OnLayoutChangedLinearLayout, com.tencent.mm.ui.widget.DrawnCallBackLinearLayout
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(79834);
        super.onLayout(z, i2, i3, i4, i5);
        AppMethodBeat.o(79834);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        AppMethodBeat.i(79835);
        super.onMeasure(i2, i3);
        AppMethodBeat.o(79835);
    }

    @Override // com.tencent.mm.ui.KeyboardLinearLayout
    public final void agG(int i2) {
        AppMethodBeat.i(258103);
        Log.d("MicroMsg.WebViewKeyboardLinearLayout", "onLayout : b: " + i2 + " mHasInit: " + this.mHasInit + " mHasKeyboard: " + this.Jgc);
        Rect rect = new Rect();
        getWindowVisibleDisplayFrame(rect);
        int height = getRootView().getHeight();
        if (!this.mHasInit) {
            this.mHasInit = true;
            this.mHeight = i2;
            Log.i("MicroMsg.WebViewKeyboardLinearLayout", "init height:%d", Integer.valueOf(this.mHeight));
            super.Ns(-1);
            this.Jgf = height - rect.bottom;
        }
        Log.d("MicroMsg.WebViewKeyboardLinearLayout", "onLayout, current rect = %s", rect.toString());
        int height2 = rect.height();
        this.mHeight = height2;
        Log.d("MicroMsg.WebViewKeyboardLinearLayout", "onLayout, usableHeightNow = %d, previousUsableHeight = %d", Integer.valueOf(height2), Integer.valueOf(this.Jgd));
        if (this.Jgd != height2) {
            int height3 = (getRootView().getHeight() - this.Jgf) - rect.top;
            int i3 = height3 - height2;
            if (i3 > height3 / 4) {
                this.Jgc = true;
                this.Jge = i3;
                super.Ns(-3);
                Log.w("MicroMsg.WebViewKeyboardLinearLayout", "onLayout, show keyboard!! mHeight: " + this.mHeight + " b: " + i2 + " mKBHeight: " + this.Jge);
            } else {
                this.Jgc = false;
                super.Ns(-2);
                Log.w("MicroMsg.WebViewKeyboardLinearLayout", "onLayout, hide keyboard!! mHeight: " + this.mHeight + " b: " + i2);
            }
            this.Jgd = height2;
        }
        AppMethodBeat.o(258103);
    }

    public final int getKeyBoardHeight() {
        return this.Jge;
    }

    public final boolean geD() {
        return this.Jgc;
    }

    @Override // com.tencent.mm.ui.KeyboardLinearLayout
    public final void Ns(int i2) {
        AppMethodBeat.i(259610);
        super.Ns(i2);
        AppMethodBeat.o(259610);
    }
}

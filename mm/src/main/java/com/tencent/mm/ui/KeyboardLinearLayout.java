package com.tencent.mm.ui;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.OnLayoutChangedLinearLayout;

public class KeyboardLinearLayout extends OnLayoutChangedLinearLayout {
    private boolean ODJ;
    private a ODK;
    public String TAG;
    private boolean mHasInit;
    private int mHeight;

    public interface a {
        void Ns(int i2);
    }

    public KeyboardLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(141302);
        this.TAG = "MicroMsg.KeyboardLinearLayout";
        this.mHasInit = false;
        this.mHasInit = false;
        this.mHeight = 0;
        this.ODJ = false;
        this.TAG += getId();
        AppMethodBeat.o(141302);
    }

    public KeyboardLinearLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.TAG = "MicroMsg.KeyboardLinearLayout";
        this.mHasInit = false;
    }

    public void setOnkbdStateListener(a aVar) {
        this.ODK = aVar;
    }

    @Override // com.tencent.mm.ui.base.OnLayoutChangedLinearLayout, com.tencent.mm.ui.widget.DrawnCallBackLinearLayout
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(141303);
        super.onLayout(z, i2, i3, i4, i5);
        agG(i5);
        AppMethodBeat.o(141303);
    }

    /* access modifiers changed from: protected */
    public void agG(int i2) {
        AppMethodBeat.i(141304);
        if (!this.mHasInit) {
            this.mHasInit = true;
            this.mHeight = i2;
            Log.i(this.TAG, "init height:%d", Integer.valueOf(this.mHeight));
            if (this.ODK != null) {
                this.ODK.Ns(-1);
            }
        } else {
            this.mHeight = this.mHeight < i2 ? i2 : this.mHeight;
        }
        if (this.mHasInit && !this.ODJ && this.mHeight - i2 > 100) {
            this.ODJ = true;
            Ns(-3);
            Log.w(this.TAG, "show keyboard!! mHeight: " + this.mHeight + " b: " + i2);
        }
        if (this.mHasInit && this.ODJ && this.mHeight - i2 <= 100) {
            this.ODJ = false;
            Ns(-2);
            Log.w(this.TAG, "hide keyboard!! mHeight: " + this.mHeight + " b: " + i2);
        }
        AppMethodBeat.o(141304);
    }

    /* access modifiers changed from: protected */
    public void Ns(int i2) {
        AppMethodBeat.i(141305);
        if (this.ODK != null) {
            this.ODK.Ns(i2);
        }
        AppMethodBeat.o(141305);
    }
}

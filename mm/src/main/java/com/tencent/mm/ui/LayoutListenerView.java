package com.tencent.mm.ui;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

public class LayoutListenerView extends FrameLayout {
    private byte[] OEW = new byte[0];
    private a OEX;
    private c OEY;
    private b OEZ;
    private String TAG = "MicroMsg.LayoutListenerView";

    public interface a {
    }

    public interface b {
    }

    public interface c {
        void onSizeChanged(int i2, int i3, int i4, int i5);
    }

    public void setOnLayoutListener(a aVar) {
        synchronized (this.OEW) {
            this.OEX = aVar;
        }
    }

    public void setOnResizedListener(c cVar) {
        synchronized (this.OEW) {
            this.OEY = cVar;
        }
    }

    public void setOnPreLayoutListener(b bVar) {
        synchronized (this.OEW) {
            this.OEZ = bVar;
        }
    }

    public LayoutListenerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(141306);
        AppMethodBeat.o(141306);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(141307);
        synchronized (this.OEW) {
            try {
            } finally {
                AppMethodBeat.o(141307);
            }
        }
        super.onLayout(z, i2, i3, i4, i5);
        synchronized (this.OEW) {
            try {
            } catch (Throwable th) {
                throw th;
            }
        }
        AppMethodBeat.o(141307);
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(141308);
        super.onSizeChanged(i2, i3, i4, i5);
        synchronized (this.OEW) {
            try {
                if (this.OEY != null) {
                    this.OEY.onSizeChanged(i2, i3, i4, i5);
                }
            } finally {
                AppMethodBeat.o(141308);
            }
        }
    }

    @TargetApi(14)
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        AppMethodBeat.i(141309);
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        Log.d(this.TAG, "jacks onInitializeAccessibilityNodeInfo");
        AppMethodBeat.o(141309);
    }

    @TargetApi(14)
    public void onPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        AppMethodBeat.i(141310);
        super.onPopulateAccessibilityEvent(accessibilityEvent);
        Log.d(this.TAG, "jacks onPopulateAccessibilityEvent");
        AppMethodBeat.o(141310);
    }

    @TargetApi(14)
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        AppMethodBeat.i(141311);
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        Log.d(this.TAG, "jacks onInitializeAccessibilityEvent");
        AppMethodBeat.o(141311);
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        AppMethodBeat.i(141312);
        synchronized (this.OEW) {
            try {
                this.OEX = null;
                this.OEY = null;
                this.OEZ = null;
            } catch (Throwable th) {
                AppMethodBeat.o(141312);
                throw th;
            }
        }
        super.onDetachedFromWindow();
        AppMethodBeat.o(141312);
    }
}

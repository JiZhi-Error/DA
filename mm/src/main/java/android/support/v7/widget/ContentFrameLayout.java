package android.support.v7.widget;

import android.content.Context;
import android.graphics.Rect;
import android.support.v4.view.u;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.FrameLayout;

public class ContentFrameLayout extends FrameLayout {
    private TypedValue amc;
    private TypedValue amd;
    private TypedValue ame;
    private TypedValue amf;
    private TypedValue amg;
    private TypedValue amh;
    private final Rect ami;
    private a amj;

    public interface a {
        void onDetachedFromWindow();
    }

    public ContentFrameLayout(Context context) {
        this(context, null);
    }

    public ContentFrameLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ContentFrameLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.ami = new Rect();
    }

    public final void g(Rect rect) {
        fitSystemWindows(rect);
    }

    public void setAttachListener(a aVar) {
        this.amj = aVar;
    }

    public final void j(int i2, int i3, int i4, int i5) {
        this.ami.set(i2, i3, i4, i5);
        if (u.az(this)) {
            requestLayout();
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0052  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x008e  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x009a  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00a1  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00ad  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00b4  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00e5  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00e8  */
    /* JADX WARNING: Removed duplicated region for block: B:62:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onMeasure(int r13, int r14) {
        /*
        // Method dump skipped, instructions count: 262
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.ContentFrameLayout.onMeasure(int, int):void");
    }

    public TypedValue getMinWidthMajor() {
        if (this.amc == null) {
            this.amc = new TypedValue();
        }
        return this.amc;
    }

    public TypedValue getMinWidthMinor() {
        if (this.amd == null) {
            this.amd = new TypedValue();
        }
        return this.amd;
    }

    public TypedValue getFixedWidthMajor() {
        if (this.ame == null) {
            this.ame = new TypedValue();
        }
        return this.ame;
    }

    public TypedValue getFixedWidthMinor() {
        if (this.amf == null) {
            this.amf = new TypedValue();
        }
        return this.amf;
    }

    public TypedValue getFixedHeightMajor() {
        if (this.amg == null) {
            this.amg = new TypedValue();
        }
        return this.amg;
    }

    public TypedValue getFixedHeightMinor() {
        if (this.amh == null) {
            this.amh = new TypedValue();
        }
        return this.amh;
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.amj != null) {
            this.amj.onDetachedFromWindow();
        }
    }
}

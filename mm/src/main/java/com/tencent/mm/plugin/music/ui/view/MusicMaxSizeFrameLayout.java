package com.tencent.mm.plugin.music.ui.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.music.a;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007B\u001f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u001a\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\tH\u0002J\u0018\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\tH\u0014J\u000e\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\tJ\u000e\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\tR\u000e\u0010\u000b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, hxF = {"Lcom/tencent/mm/plugin/music/ui/view/MusicMaxSizeFrameLayout;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "maxHeight", "maxWidth", "initAttribute", "", "onMeasure", "widthSpec", "heightSpec", "setMaxHeight", "setMaxWidth", "Companion", "plugin-music_release"})
public final class MusicMaxSizeFrameLayout extends FrameLayout {
    public static final a Aoq = new a((byte) 0);
    private int maxHeight;
    private int maxWidth;

    static {
        AppMethodBeat.i(220057);
        AppMethodBeat.o(220057);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/music/ui/view/MusicMaxSizeFrameLayout$Companion;", "", "()V", "TAG", "", "plugin-music_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MusicMaxSizeFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        p.h(context, "context");
        p.h(attributeSet, "attrs");
        AppMethodBeat.i(220055);
        b(attributeSet, 0);
        AppMethodBeat.o(220055);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MusicMaxSizeFrameLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        p.h(context, "context");
        p.h(attributeSet, "attrs");
        AppMethodBeat.i(220056);
        b(attributeSet, i2);
        AppMethodBeat.o(220056);
    }

    public final void setMaxHeight(int i2) {
        this.maxHeight = i2;
    }

    public final void setMaxWidth(int i2) {
        this.maxWidth = i2;
    }

    /* access modifiers changed from: protected */
    public final void onMeasure(int i2, int i3) {
        AppMethodBeat.i(220053);
        super.onMeasure(i2, i3);
        boolean z = false;
        if (this.maxHeight >= 0 || this.maxWidth >= 0) {
            z = true;
        }
        if (z) {
            int measuredHeight = getMeasuredHeight();
            int measuredWidth = getMeasuredWidth();
            if (getMeasuredHeight() > this.maxHeight) {
                measuredHeight = this.maxHeight;
            }
            if (getMeasuredWidth() > this.maxWidth) {
                measuredWidth = this.maxWidth;
            }
            setMeasuredDimension(measuredWidth, measuredHeight);
        }
        AppMethodBeat.o(220053);
    }

    private final void b(AttributeSet attributeSet, int i2) {
        AppMethodBeat.i(220054);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, a.C1531a.MaxSizeFrameLayout, i2, 0);
            this.maxHeight = (int) obtainStyledAttributes.getDimension(0, 0.0f);
            this.maxWidth = (int) obtainStyledAttributes.getDimension(0, 0.0f);
            obtainStyledAttributes.recycle();
            Log.i("Music.MusicMaxSizeFrameLayout", "[initAttribute],maxHeight:" + this.maxHeight + ", maxWidth:" + this.maxWidth);
        }
        AppMethodBeat.o(220054);
    }
}

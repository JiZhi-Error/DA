package com.tencent.mm.plugin.multitask.animation.a;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0010\b\u0016\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\fH\u0016J(\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u000fH\u0016JH\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u001b\u001a\u00020\u000fH\u0016J\u0018\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\f2\u0006\u0010\u001e\u001a\u00020\fH\u0016¨\u0006\u001f"}, hxF = {"Lcom/tencent/mm/plugin/multitask/animation/enter/TransformEnterBaseView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "setDefaultDstRect", "", "dstRect", "Landroid/graphics/Rect;", "setDstRect", "setMaskAlpha", "maskAlpha", "", "setMaskRect", "left", "", "top", "right", "buttom", "setRectConnerRadius", "radll", "radlt", "radtl", "radtt", "radrl", "radrt", "radbl", "radbt", "setViewSize", "width", "height", "plugin-multitask_release"})
public class a extends View {
    public a(Context context) {
        super(context);
    }

    public void setDstRect(Rect rect) {
        AppMethodBeat.i(200376);
        p.h(rect, "dstRect");
        AppMethodBeat.o(200376);
    }

    public void setDefaultDstRect(Rect rect) {
        AppMethodBeat.i(200377);
        p.h(rect, "dstRect");
        AppMethodBeat.o(200377);
    }

    public void setMaskAlpha(int i2) {
    }

    public void hk(int i2, int i3) {
    }

    public void m(float f2, float f3, float f4) {
    }

    public void m(float f2, float f3, float f4, float f5) {
    }
}

package com.tencent.mm.plugin.voip.ui;

import android.graphics.Outline;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewOutlineProvider;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001c\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004¨\u0006\u000e"}, hxF = {"Lcom/tencent/mm/plugin/voip/ui/VoipRectangleViewOutlineProvider;", "Landroid/view/ViewOutlineProvider;", "mRadius", "", "(F)V", "getMRadius", "()F", "setMRadius", "getOutline", "", "view", "Landroid/view/View;", "outline", "Landroid/graphics/Outline;", "plugin-voip_release"})
public final class e extends ViewOutlineProvider {
    private float auL;

    public e(float f2) {
        this.auL = f2;
    }

    public final void getOutline(View view, Outline outline) {
        AppMethodBeat.i(184119);
        Rect rect = new Rect();
        if (view != null) {
            view.getDrawingRect(rect);
        }
        Rect rect2 = new Rect(0, 0, (rect.right - rect.left) + 0, (rect.bottom - rect.top) + 0);
        if (outline != null) {
            outline.setRoundRect(rect2, this.auL);
            AppMethodBeat.o(184119);
            return;
        }
        AppMethodBeat.o(184119);
    }
}

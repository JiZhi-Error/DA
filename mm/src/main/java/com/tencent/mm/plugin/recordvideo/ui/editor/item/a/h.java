package com.tencent.mm.plugin.recordvideo.ui.editor.item.a;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.data.APMidasPluginInfo;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\u0006H\u0016J\b\u0010\r\u001a\u00020\u000eH\u0016¨\u0006\u000f"}, hxF = {"Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/draw/PlaceHolderEditorItem;", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/draw/BaseEditorItem;", "matrix", "Landroid/graphics/Matrix;", "(Landroid/graphics/Matrix;)V", "destroy", "", "draw", "canvas", "Landroid/graphics/Canvas;", "paint", "Landroid/graphics/Paint;", APMidasPluginInfo.LAUNCH_INTERFACE_INIT, "prepareNext", "", "plugin-recordvideo_release"})
public final class h extends a {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public h(Matrix matrix) {
        super(matrix);
        p.h(matrix, "matrix");
        AppMethodBeat.i(237870);
        AppMethodBeat.o(237870);
    }

    @Override // com.tencent.mm.plugin.recordvideo.ui.editor.item.a.a
    public final void init() {
    }

    @Override // com.tencent.mm.plugin.recordvideo.ui.editor.item.a.a
    public final void draw(Canvas canvas, Paint paint) {
        AppMethodBeat.i(237869);
        p.h(canvas, "canvas");
        p.h(paint, "paint");
        AppMethodBeat.o(237869);
    }

    @Override // com.tencent.mm.plugin.recordvideo.ui.editor.item.a.a
    public final long eMv() {
        return 0;
    }

    @Override // com.tencent.mm.plugin.recordvideo.ui.editor.item.a.a
    public final void destroy() {
    }
}

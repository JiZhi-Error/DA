package com.tencent.mm.plugin.recordvideo.ui.editor.item.a;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.data.APMidasPluginInfo;
import com.tencent.mm.sdk.platformtools.MAlarmHandler;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0016J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\bH\u0016J\b\u0010\u000f\u001a\u00020\u0010H\u0016R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0011"}, hxF = {"Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/draw/BitmapEditorItem;", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/draw/BaseEditorItem;", "bitmap", "Landroid/graphics/Bitmap;", "matrix", "Landroid/graphics/Matrix;", "(Landroid/graphics/Bitmap;Landroid/graphics/Matrix;)V", "destroy", "", "draw", "canvas", "Landroid/graphics/Canvas;", "paint", "Landroid/graphics/Paint;", APMidasPluginInfo.LAUNCH_INTERFACE_INIT, "prepareNext", "", "plugin-recordvideo_release"})
public final class c extends a {
    private Bitmap bitmap;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public c(Bitmap bitmap2, Matrix matrix) {
        super(matrix);
        p.h(matrix, "matrix");
        AppMethodBeat.i(237853);
        this.bitmap = bitmap2;
        AppMethodBeat.o(237853);
    }

    @Override // com.tencent.mm.plugin.recordvideo.ui.editor.item.a.a
    public final void init() {
    }

    @Override // com.tencent.mm.plugin.recordvideo.ui.editor.item.a.a
    public final void draw(Canvas canvas, Paint paint) {
        AppMethodBeat.i(237852);
        p.h(canvas, "canvas");
        p.h(paint, "paint");
        if (eMu()) {
            canvas.save();
            canvas.concat(this.gT);
            Bitmap bitmap2 = this.bitmap;
            if (bitmap2 == null) {
                p.hyc();
            }
            canvas.drawBitmap(bitmap2, 0.0f, 0.0f, paint);
            canvas.restore();
        }
        AppMethodBeat.o(237852);
    }

    @Override // com.tencent.mm.plugin.recordvideo.ui.editor.item.a.a
    public final long eMv() {
        return MAlarmHandler.NEXT_FIRE_INTERVAL;
    }

    @Override // com.tencent.mm.plugin.recordvideo.ui.editor.item.a.a
    public final void destroy() {
    }
}

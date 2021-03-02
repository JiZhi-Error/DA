package com.tencent.mm.plugin.recordvideo.ui.editor.item.a;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.data.APMidasPluginInfo;
import com.tencent.mm.sdk.platformtools.MAlarmHandler;
import java.util.ArrayList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B'\u0012\u0010\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\b\u0010\u000e\u001a\u00020\u000fH\u0016J\u0018\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u000fH\u0016J\b\u0010\u0016\u001a\u00020\u0006H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, hxF = {"Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/draw/BitmapArrayEditorItem;", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/draw/BaseEditorItem;", "bitmapArray", "", "Landroid/graphics/Bitmap;", "animInterval", "", "matrix", "Landroid/graphics/Matrix;", "([Landroid/graphics/Bitmap;JLandroid/graphics/Matrix;)V", "bitmaps", "", "currIndex", "", "destroy", "", "draw", "canvas", "Landroid/graphics/Canvas;", "paint", "Landroid/graphics/Paint;", APMidasPluginInfo.LAUNCH_INTERFACE_INIT, "prepareNext", "plugin-recordvideo_release"})
public final class b extends a {
    private int Cgl;
    private final List<Bitmap> Cgm = new ArrayList();
    private final long Cgn = 100;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public b(Bitmap[] bitmapArr, Matrix matrix) {
        super(matrix);
        p.h(matrix, "matrix");
        AppMethodBeat.i(237851);
        if (bitmapArr != null) {
            for (Bitmap bitmap : bitmapArr) {
                if (bitmap != null) {
                    this.Cgm.add(bitmap);
                }
            }
        }
        AppMethodBeat.o(237851);
    }

    @Override // com.tencent.mm.plugin.recordvideo.ui.editor.item.a.a
    public final void init() {
    }

    @Override // com.tencent.mm.plugin.recordvideo.ui.editor.item.a.a
    public final void draw(Canvas canvas, Paint paint) {
        AppMethodBeat.i(237849);
        p.h(canvas, "canvas");
        p.h(paint, "paint");
        if (this.Cgm.isEmpty()) {
            AppMethodBeat.o(237849);
            return;
        }
        canvas.save();
        canvas.concat(this.gT);
        canvas.drawBitmap(this.Cgm.get(this.Cgl), 0.0f, 0.0f, paint);
        canvas.restore();
        AppMethodBeat.o(237849);
    }

    @Override // com.tencent.mm.plugin.recordvideo.ui.editor.item.a.a
    public final long eMv() {
        AppMethodBeat.i(237850);
        if (this.Cgm.isEmpty()) {
            AppMethodBeat.o(237850);
            return MAlarmHandler.NEXT_FIRE_INTERVAL;
        }
        this.Cgl++;
        this.Cgl %= this.Cgm.size();
        long j2 = this.Cgn;
        AppMethodBeat.o(237850);
        return j2;
    }

    @Override // com.tencent.mm.plugin.recordvideo.ui.editor.item.a.a
    public final void destroy() {
    }
}

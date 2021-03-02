package com.tencent.mm.plugin.recordvideo.ui.editor;

import android.graphics.Canvas;
import android.graphics.Paint;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recordvideo.ui.editor.item.a.a;
import com.tencent.mm.sdk.platformtools.MAlarmHandler;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u0016\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fR\u000e\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, hxF = {"Lcom/tencent/mm/plugin/recordvideo/ui/editor/EditorFrameDrawer;", "", "editorItems", "", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/draw/BaseEditorItem;", "(Ljava/util/List;)V", "currFrameTime", "", "drawFrame", "canvas", "Landroid/graphics/Canvas;", "paint", "Landroid/graphics/Paint;", "plugin-recordvideo_release"})
public final class b {
    private final List<a> rpx;
    private long rpy;

    public b(List<a> list) {
        p.h(list, "editorItems");
        AppMethodBeat.i(237710);
        this.rpx = list;
        AppMethodBeat.o(237710);
    }

    public final long a(Canvas canvas, Paint paint) {
        AppMethodBeat.i(237709);
        p.h(canvas, "canvas");
        p.h(paint, "paint");
        if (this.rpx.size() <= 0) {
            AppMethodBeat.o(237709);
            return 0;
        }
        long j2 = MAlarmHandler.NEXT_FIRE_INTERVAL;
        for (a aVar : this.rpx) {
            long Ik = aVar.Ik(this.rpy);
            aVar.draw(canvas, paint);
            if (Ik < j2) {
                j2 = Ik;
            } else {
                j2 = j2;
            }
        }
        this.rpy = j2;
        long j3 = this.rpy;
        AppMethodBeat.o(237709);
        return j3;
    }
}

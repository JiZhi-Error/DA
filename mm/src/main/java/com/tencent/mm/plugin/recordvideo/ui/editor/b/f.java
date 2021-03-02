package com.tencent.mm.plugin.recordvideo.ui.editor.b;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0014\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0002\u0010\u000bJ\b\u0010\u0012\u001a\u00020\u0013H\u0016J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u0013H\u0016R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, hxF = {"Lcom/tencent/mm/plugin/recordvideo/ui/editor/retriever/SimpleFrameRetriever;", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/retriever/FrameSeeker;", "drawingRect", "", "validRect", "editorItems", "", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/draw/BaseEditorItem;", "width", "", "height", "([F[FLjava/util/List;II)V", "bitmap", "Landroid/graphics/Bitmap;", "canvas", "Landroid/graphics/Canvas;", "paint", "Landroid/graphics/Paint;", "destroy", "", "seekFrame", "timeMs", "", "start", "Companion", "plugin-recordvideo_release"})
public final class f implements c {
    public static final a CgF = new a((byte) 0);
    private final Canvas aTi;
    private final Bitmap bitmap;
    private final Paint paint = new Paint();
    private final List<com.tencent.mm.plugin.recordvideo.ui.editor.item.a.a> rpx;

    static {
        AppMethodBeat.i(237914);
        AppMethodBeat.o(237914);
    }

    public f(float[] fArr, List<com.tencent.mm.plugin.recordvideo.ui.editor.item.a.a> list, int i2, int i3) {
        p.h(fArr, "drawingRect");
        p.h(list, "editorItems");
        AppMethodBeat.i(237913);
        this.rpx = list;
        this.paint.setAntiAlias(true);
        this.paint.setFilterBitmap(true);
        Bitmap createBitmap = Bitmap.createBitmap(i2, i3, Bitmap.Config.ARGB_8888);
        p.g(createBitmap, "Bitmap.createBitmap(widt… Bitmap.Config.ARGB_8888)");
        this.bitmap = createBitmap;
        this.aTi = new Canvas(this.bitmap);
        this.aTi.translate(-fArr[0], -fArr[1]);
        AppMethodBeat.o(237913);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.g.a.b
    public final /* synthetic */ Bitmap invoke(Long l) {
        AppMethodBeat.i(237915);
        Bitmap Im = Im(l.longValue());
        AppMethodBeat.o(237915);
        return Im;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/recordvideo/ui/editor/retriever/SimpleFrameRetriever$Companion;", "", "()V", "TAG", "", "plugin-recordvideo_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @Override // com.tencent.mm.plugin.recordvideo.ui.editor.b.c
    public final Bitmap Im(long j2) {
        AppMethodBeat.i(237910);
        if (this.rpx.size() == 0) {
            AppMethodBeat.o(237910);
            return null;
        }
        this.aTi.drawColor(0, PorterDuff.Mode.MULTIPLY);
        for (T t : this.rpx) {
            t.seekTo(j2);
            t.draw(this.aTi, this.paint);
        }
        Bitmap bitmap2 = this.bitmap;
        AppMethodBeat.o(237910);
        return bitmap2;
    }

    @Override // com.tencent.mm.plugin.recordvideo.ui.editor.b.c
    public final void start() {
        AppMethodBeat.i(237911);
        try {
            Iterator<T> it = this.rpx.iterator();
            while (it.hasNext()) {
                it.next().init();
            }
            AppMethodBeat.o(237911);
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.SimpleFrameRetriever", e2, "start error", new Object[0]);
            AppMethodBeat.o(237911);
        }
    }

    @Override // com.tencent.mm.plugin.recordvideo.ui.editor.b.c
    public final void destroy() {
        AppMethodBeat.i(237912);
        try {
            Iterator<T> it = this.rpx.iterator();
            while (it.hasNext()) {
                it.next().destroy();
            }
            AppMethodBeat.o(237912);
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.SimpleFrameRetriever", e2, "destroy error", new Object[0]);
            AppMethodBeat.o(237912);
        }
    }
}

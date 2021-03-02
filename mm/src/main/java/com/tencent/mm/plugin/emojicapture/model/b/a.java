package com.tencent.mm.plugin.emojicapture.model.b;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.RectF;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.emojicapture.model.d;
import com.tencent.mm.plugin.recordvideo.ui.editor.b.b;
import java.util.ArrayList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u000fJ\n\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\u0006\u0010 \u001a\u00020\u001cJ\u0006\u0010!\u001a\u00020\u001cR\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R \u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0014\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000¨\u0006\""}, hxF = {"Lcom/tencent/mm/plugin/emojicapture/model/mix/EmojiFrameRetriever;", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/retriever/FrameRetriever;", "preViewRect", "Landroid/graphics/RectF;", "(Landroid/graphics/RectF;)V", "bitmap", "Landroid/graphics/Bitmap;", "canvas", "Landroid/graphics/Canvas;", "currFrameTime", "", "drawer", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/EditorFrameDrawer;", "editorItems", "", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/draw/BaseEditorItem;", "getEditorItems", "()Ljava/util/List;", "setEditorItems", "(Ljava/util/List;)V", "height", "", "paint", "Landroid/graphics/Paint;", "preViewMatrix", "Landroid/graphics/Matrix;", "width", "addItem", "", "item", "requestNextFrame", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/retriever/FrameInfo;", "start", "stop", "plugin-emojicapture_release"})
public final class a implements b {
    private final Canvas aTi;
    private final Bitmap bitmap;
    private int height;
    private final Paint paint;
    private final com.tencent.mm.plugin.recordvideo.ui.editor.b rpA;
    List<com.tencent.mm.plugin.recordvideo.ui.editor.item.a.a> rpx;
    private long rpy;
    private final Matrix rpz;
    private int width = d.rov;

    public a(RectF rectF) {
        p.h(rectF, "preViewRect");
        AppMethodBeat.i(262);
        d.a aVar = d.roA;
        d.a aVar2 = d.roA;
        this.height = d.rov;
        this.rpx = new ArrayList();
        this.rpz = new Matrix();
        this.paint = new Paint();
        this.rpA = new com.tencent.mm.plugin.recordvideo.ui.editor.b(this.rpx);
        this.rpz.setPolyToPoly(new float[]{rectF.left, rectF.top, rectF.right, rectF.bottom}, 0, new float[]{0.0f, 0.0f, (float) this.width, (float) this.height}, 0, 2);
        this.paint.setAntiAlias(true);
        this.paint.setFilterBitmap(true);
        Bitmap createBitmap = Bitmap.createBitmap(this.width, this.height, Bitmap.Config.ARGB_8888);
        p.g(createBitmap, "Bitmap.createBitmap(widt… Bitmap.Config.ARGB_8888)");
        this.bitmap = createBitmap;
        this.aTi = new Canvas(this.bitmap);
        AppMethodBeat.o(262);
    }

    @Override // com.tencent.mm.plugin.recordvideo.ui.editor.b.b
    public final com.tencent.mm.plugin.recordvideo.ui.editor.b.a cJu() {
        AppMethodBeat.i(256430);
        if (this.rpx.size() <= 0) {
            AppMethodBeat.o(256430);
            return null;
        }
        int save = this.aTi.save();
        this.aTi.drawColor(0, PorterDuff.Mode.MULTIPLY);
        this.aTi.concat(this.rpz);
        this.rpy = this.rpA.a(this.aTi, this.paint);
        this.aTi.restoreToCount(save);
        com.tencent.mm.plugin.recordvideo.ui.editor.b.a aVar = new com.tencent.mm.plugin.recordvideo.ui.editor.b.a(this.bitmap, this.rpy);
        AppMethodBeat.o(256430);
        return aVar;
    }

    public final void stop() {
        AppMethodBeat.i(260);
        for (com.tencent.mm.plugin.recordvideo.ui.editor.item.a.a aVar : this.rpx) {
            aVar.destroy();
        }
        AppMethodBeat.o(260);
    }

    public final void a(com.tencent.mm.plugin.recordvideo.ui.editor.item.a.a aVar) {
        AppMethodBeat.i(256431);
        if (aVar != null) {
            this.rpx.add(aVar);
        }
        AppMethodBeat.o(256431);
    }
}

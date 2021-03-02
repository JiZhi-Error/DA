package com.tencent.mm.plugin.recordvideo.ui.editor.item.a;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.data.APMidasPluginInfo;
import com.tencent.mm.emoji.decode.MMGIFJNIFactory;
import com.tencent.mm.emoji.decode.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.emotion.EmojiInfo;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\u0018\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u0011H\u0016J\b\u0010\u0018\u001a\u00020\u000eH\u0016J\u0010\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020\u000eH\u0016R\u000e\u0010\u0007\u001a\u00020\bXD¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX.¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b"}, hxF = {"Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/draw/EmojiEditorItem;", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/draw/BaseEditorItem;", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "matrix", "Landroid/graphics/Matrix;", "(Lcom/tencent/mm/storage/emotion/EmojiInfo;Landroid/graphics/Matrix;)V", "TAG", "", "decoder", "Lcom/tencent/mm/emoji/decode/IGIFDecoder;", "lastValidFrame", "Landroid/graphics/Bitmap;", "consumeTime", "", "lastFrameTime", "destroy", "", "draw", "canvas", "Landroid/graphics/Canvas;", "paint", "Landroid/graphics/Paint;", APMidasPluginInfo.LAUNCH_INTERFACE_INIT, "prepareNext", "seekTo", "timeMs", "plugin-recordvideo_release"})
public final class e extends a {
    private final String TAG = "MicroMsg.EmojiEditorItem";
    private Bitmap gUK;
    private d gUS;
    private EmojiInfo gWm;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public e(EmojiInfo emojiInfo, Matrix matrix) {
        super(matrix);
        p.h(emojiInfo, "emojiInfo");
        p.h(matrix, "matrix");
        AppMethodBeat.i(237864);
        this.gWm = emojiInfo;
        AppMethodBeat.o(237864);
    }

    @Override // com.tencent.mm.plugin.recordvideo.ui.editor.item.a.a
    public final void init() {
        AppMethodBeat.i(237858);
        Log.d(this.TAG, "filepath is " + this.gWm.hYx());
        this.gUS = MMGIFJNIFactory.Companion.getDecoder(this.gWm);
        AppMethodBeat.o(237858);
    }

    @Override // com.tencent.mm.plugin.recordvideo.ui.editor.item.a.a
    public final void draw(Canvas canvas, Paint paint) {
        AppMethodBeat.i(237859);
        p.h(canvas, "canvas");
        p.h(paint, "paint");
        if (eMu()) {
            canvas.save();
            canvas.concat(this.gT);
            if (this.gUK != null) {
                Bitmap bitmap = this.gUK;
                if (bitmap == null) {
                    p.hyc();
                }
                canvas.drawBitmap(bitmap, 0.0f, 0.0f, paint);
            }
            canvas.restore();
        }
        AppMethodBeat.o(237859);
    }

    @Override // com.tencent.mm.plugin.recordvideo.ui.editor.item.a.a
    public final void seekTo(long j2) {
        AppMethodBeat.i(237860);
        super.seekTo(j2);
        if (eMu()) {
            d dVar = this.gUS;
            if (dVar == null) {
                p.btv("decoder");
            }
            dVar.seekTo(j2);
            d dVar2 = this.gUS;
            if (dVar2 == null) {
                p.btv("decoder");
            }
            this.gUK = dVar2.getFrame();
        }
        AppMethodBeat.o(237860);
    }

    @Override // com.tencent.mm.plugin.recordvideo.ui.editor.item.a.a
    public final long Ik(long j2) {
        AppMethodBeat.i(237861);
        Log.d(this.TAG, "request time is " + j2 + ", curr frame is " + this.rpy);
        long Ik = super.Ik(j2);
        AppMethodBeat.o(237861);
        return Ik;
    }

    @Override // com.tencent.mm.plugin.recordvideo.ui.editor.item.a.a
    public final long eMv() {
        AppMethodBeat.i(237862);
        d dVar = this.gUS;
        if (dVar == null) {
            p.btv("decoder");
        }
        dVar.auo();
        d dVar2 = this.gUS;
        if (dVar2 == null) {
            p.btv("decoder");
        }
        this.gUK = dVar2.getFrame();
        d dVar3 = this.gUS;
        if (dVar3 == null) {
            p.btv("decoder");
        }
        long auq = (long) dVar3.auq();
        AppMethodBeat.o(237862);
        return auq;
    }

    @Override // com.tencent.mm.plugin.recordvideo.ui.editor.item.a.a
    public final void destroy() {
        AppMethodBeat.i(237863);
        d dVar = this.gUS;
        if (dVar == null) {
            p.btv("decoder");
        }
        dVar.destroy();
        AppMethodBeat.o(237863);
    }
}

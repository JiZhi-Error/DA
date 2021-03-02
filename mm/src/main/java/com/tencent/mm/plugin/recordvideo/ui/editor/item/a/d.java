package com.tencent.mm.plugin.recordvideo.ui.editor.item.a;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.data.APMidasPluginInfo;
import com.tencent.mm.plugin.recordvideo.ui.editor.a;
import com.tencent.mm.plugin.recordvideo.ui.editor.item.c;
import com.tencent.mm.protocal.protobuf.sy;
import com.tencent.mm.sdk.platformtools.MAlarmHandler;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.au;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\u0018\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\u0006H\u0016J\u0010\u0010\u001b\u001a\u00020\u000e2\u0006\u0010\u001c\u001a\u00020\u0016H\u0002J\b\u0010\u001d\u001a\u00020\u0018H\u0016J\b\u0010\u001e\u001a\u00020\u0012H\u0016J\u0010\u0010\u001f\u001a\u00020\u00182\u0006\u0010 \u001a\u00020\u0012H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u000e¢\u0006\u0002\n\u0000¨\u0006!"}, hxF = {"Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/draw/CaptionEditorItem;", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/draw/BaseEditorItem;", "captionItem", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/CaptionItem;", "(Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/CaptionItem;)V", "bitmapPaint", "Landroid/graphics/Paint;", "canvas", "Landroid/graphics/Canvas;", "captionItemView", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/CaptionItemView;", "hasContent", "", "scale", "", "screenWidth", "", "seekTime", "", "showBitmap", "Landroid/graphics/Bitmap;", "transMatrix", "Landroid/graphics/Matrix;", "destroy", "", "draw", "paint", "getScale", "matrix", APMidasPluginInfo.LAUNCH_INTERFACE_INIT, "prepareNext", "seekTo", "timeMs", "plugin-recordvideo_release"})
public final class d extends a {
    private final c Can;
    private a Cgo;
    private Matrix Cgp;
    private boolean Cgq;
    private Canvas aTi;
    private Paint aYz = new Paint();
    private int mEX;
    private final float scale;

    @Override // com.tencent.mm.plugin.recordvideo.ui.editor.item.a.a
    public final void init() {
        AppMethodBeat.i(237854);
        this.aYz.setAntiAlias(true);
        this.Cgo.setCaptionItem(this.Can);
        this.Cgo.setTag(this.Can);
        AppMethodBeat.o(237854);
    }

    @Override // com.tencent.mm.plugin.recordvideo.ui.editor.item.a.a
    public final void draw(Canvas canvas, Paint paint) {
        AppMethodBeat.i(237855);
        p.h(canvas, "canvas");
        p.h(paint, "paint");
        if (this.Cgq) {
            canvas.save();
            this.Cgp.reset();
            this.Cgp.postTranslate((((float) this.mEX) - (((float) this.Cgo.getMeasuredWidth()) * this.scale)) / 2.0f, 0.0f);
            canvas.concat(this.Cgp);
            canvas.concat(this.gT);
            this.Cgo.draw(canvas);
            canvas.restore();
        }
        AppMethodBeat.o(237855);
    }

    @Override // com.tencent.mm.plugin.recordvideo.ui.editor.item.a.a
    public final void seekTo(long j2) {
        boolean z;
        boolean z2;
        AppMethodBeat.i(237856);
        super.seekTo(j2);
        Canvas canvas = this.aTi;
        if (canvas != null) {
            canvas.drawColor(0, PorterDuff.Mode.MULTIPLY);
        }
        if (this.Cgo.Ig(j2)) {
            c cVar = this.Cgo.Can;
            if (cVar != null) {
                sy Ii = cVar.Ii(j2);
                if (Ii != null) {
                    z2 = Ii.LaV;
                } else {
                    z2 = true;
                }
                z = !z2;
            } else {
                z = false;
            }
            if (z) {
                this.Cgq = true;
                this.Cgo.measure(0, 0);
                this.Cgo.layout(0, 0, this.Cgo.getMeasuredWidth(), this.Cgo.getMeasuredHeight());
                AppMethodBeat.o(237856);
                return;
            }
        }
        this.Cgq = false;
        AppMethodBeat.o(237856);
    }

    @Override // com.tencent.mm.plugin.recordvideo.ui.editor.item.a.a
    public final long eMv() {
        return MAlarmHandler.NEXT_FIRE_INTERVAL;
    }

    @Override // com.tencent.mm.plugin.recordvideo.ui.editor.item.a.a
    public final void destroy() {
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public d(c cVar) {
        super(cVar.gT);
        p.h(cVar, "captionItem");
        AppMethodBeat.i(237857);
        this.Can = cVar;
        Context context = MMApplicationContext.getContext();
        p.g(context, "MMApplicationContext.getContext()");
        this.Cgo = new a(context);
        this.mEX = au.az(MMApplicationContext.getContext()).x;
        this.Cgp = new Matrix();
        float[] fArr = new float[9];
        this.gT.getValues(fArr);
        double d2 = (double) fArr[0];
        double d3 = (double) fArr[3];
        this.scale = (float) Math.sqrt((d3 * d3) + (d2 * d2));
        AppMethodBeat.o(237857);
    }
}

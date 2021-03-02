package com.tencent.mm.plugin.recordvideo.ui.editor.item;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.view.MotionEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.recordvideo.background.e;
import com.tencent.mm.plugin.recordvideo.ui.editor.view.b;
import com.tencent.mm.ui.at;
import com.tencent.mm.ui.au;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\fJ\n\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u000f\u001a\u00020\fJ\n\u0010\u0014\u001a\u0004\u0018\u00010\u0011H\u0016J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\u000e\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u000f\u001a\u00020\fJ\u000e\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u000f\u001a\u00020\fR\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bXD¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000¨\u0006\u001e"}, hxF = {"Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/TipItemView;", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/BitmapItemView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "MARGIN", "", "TAG", "", "originMatrix", "Landroid/graphics/Matrix;", "textItem", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/TextItem;", "createBitmap", "Landroid/graphics/Bitmap;", "item", "createEditorData", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/BaseEditorData;", "getBitmapEditorItem", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/draw/BitmapEditorItem;", "getEditorData", "getType", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/view/EditItemType;", "onTouchEvent", "", "event", "Landroid/view/MotionEvent;", "reshowText", "", "setText", "plugin-recordvideo_release"})
public final class s extends b {
    private final Matrix CfS;
    private q Cgi;
    private final String TAG = "MicroMsg.TipItemView";
    private final int apv;

    public s(Context context) {
        super(context);
        AppMethodBeat.i(76176);
        this.apv = at.fromDPToPix(context, 32);
        this.CfS = new Matrix();
        setTextSize(getResources().getDimension(R.dimen.a1p));
        AppMethodBeat.o(76176);
    }

    @Override // com.tencent.mm.plugin.recordvideo.ui.editor.item.b
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(76172);
        p.h(motionEvent, "event");
        this.CfS.set(getTouchTracker().gT);
        boolean onTouchEvent = super.onTouchEvent(motionEvent);
        getTouchTracker().gT.set(this.CfS);
        AppMethodBeat.o(76172);
        return onTouchEvent;
    }

    public final void setText(q qVar) {
        int fromDPToPix;
        float f2;
        AppMethodBeat.i(237844);
        p.h(qVar, "item");
        this.Cgi = qVar;
        setText(qVar.text);
        Bitmap c2 = c(qVar);
        setSourceDataType(d.TIP);
        setColor(qVar.textColor);
        setTextBg(qVar.Cgg);
        if (qVar.CeB == 0) {
            fromDPToPix = qVar.CeB;
        } else {
            fromDPToPix = qVar.CeB + at.fromDPToPix(getContext(), 24);
        }
        setMarginBottom(fromDPToPix);
        setBitmap(c2);
        Bitmap bitmap = getBitmap();
        if (bitmap != null) {
            float height = (((float) ((getValidRect().height() - at.fromDPToPix(getContext(), 128)) - au.aD(getContext()))) - ((float) getMarginBottom())) - ((float) bitmap.getHeight());
            int i2 = this.apv;
            e eVar = e.BKp;
            if (i2 >= e.eIR().left) {
                f2 = (float) this.apv;
            } else {
                e eVar2 = e.BKp;
                f2 = (float) e.eIR().left;
            }
            getTouchTracker().gT.setTranslate(f2, height);
        }
        postInvalidate();
        AppMethodBeat.o(237844);
    }

    public final void b(q qVar) {
        AppMethodBeat.i(237845);
        p.h(qVar, "item");
        setText(qVar);
        setViewMatrix(qVar.gT);
        setSourceDataType(d.TIP);
        AppMethodBeat.o(237845);
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x00b5  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.graphics.Bitmap c(com.tencent.mm.plugin.recordvideo.ui.editor.item.q r8) {
        /*
        // Method dump skipped, instructions count: 320
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.recordvideo.ui.editor.item.s.c(com.tencent.mm.plugin.recordvideo.ui.editor.item.q):android.graphics.Bitmap");
    }

    @Override // com.tencent.mm.plugin.recordvideo.ui.editor.view.c
    public final a getEditorData() {
        Matrix matrix;
        AppMethodBeat.i(237847);
        q qVar = this.Cgi;
        if (!(qVar == null || (matrix = qVar.gT) == null)) {
            matrix.set(getTouchTracker().gT);
        }
        q qVar2 = this.Cgi;
        if (qVar2 != null) {
            qVar2.b(d.TIP);
        }
        q qVar3 = this.Cgi;
        AppMethodBeat.o(237847);
        return qVar3;
    }

    @Override // com.tencent.mm.plugin.recordvideo.ui.editor.item.g, com.tencent.mm.plugin.recordvideo.ui.editor.item.b
    public final a cJO() {
        AppMethodBeat.i(237848);
        a cJO = super.cJO();
        if (cJO != null) {
            cJO.b(d.TIP);
        }
        AppMethodBeat.o(237848);
        return cJO;
    }

    @Override // com.tencent.mm.plugin.recordvideo.ui.editor.view.c
    public final b getType() {
        return b.EditItemTypeTip;
    }
}

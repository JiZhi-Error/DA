package com.tencent.mm.plugin.recordvideo.ui.editor.item;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.view.MotionEvent;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recordvideo.background.e;
import com.tencent.mm.plugin.recordvideo.ui.editor.view.b;
import com.tencent.mm.protocal.protobuf.dlg;
import com.tencent.mm.ui.at;
import com.tencent.mm.ui.au;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\fH\u0002J\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0011\u001a\u00020\fJ\n\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\u000e\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0011\u001a\u00020\fJ\u000e\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020 J\u0010\u0010!\u001a\u00020\u001d2\u0006\u0010\"\u001a\u00020#H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nXD¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000¨\u0006$"}, hxF = {"Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/PositionItemView;", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/BitmapItemView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "DEFAULT_BG_COLOR", "", "DEFAULT_TEXT_COLOR", "MARGIN", "TAG", "", "locationItem", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/LocationItem;", "originMatrix", "Landroid/graphics/Matrix;", "createPositionBitmap", "Landroid/graphics/Bitmap;", "item", "getBitmapEditorItem", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/draw/BitmapEditorItem;", "getEditorData", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/BaseEditorData;", "getType", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/view/EditItemType;", "onTouchEvent", "", "event", "Landroid/view/MotionEvent;", "reshowPosition", "", "setLocation", FirebaseAnalytics.b.LOCATION, "Lcom/tencent/mm/protocal/protobuf/RecordLocationInfo;", "setValidArea", "validRect", "Landroid/graphics/Rect;", "plugin-recordvideo_release"})
public final class p extends b {
    private final Matrix CfS;
    private final int Cge = -1;
    private k Cgf;
    private final String TAG = "MicroMsg.PositionItemView";
    private final int apv;
    private final int oyw = -1;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public p(Context context) {
        super(context);
        kotlin.g.b.p.h(context, "context");
        AppMethodBeat.i(76166);
        this.apv = at.fromDPToPix(context, 32);
        this.CfS = new Matrix();
        AppMethodBeat.o(76166);
    }

    @Override // com.tencent.mm.plugin.recordvideo.ui.editor.item.b, com.tencent.mm.plugin.recordvideo.ui.editor.view.c
    public final void setValidArea(Rect rect) {
        AppMethodBeat.i(76161);
        kotlin.g.b.p.h(rect, "validRect");
        getValidRect().set(rect);
        AppMethodBeat.o(76161);
    }

    @Override // com.tencent.mm.plugin.recordvideo.ui.editor.item.b
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(76162);
        kotlin.g.b.p.h(motionEvent, "event");
        this.CfS.set(getTouchTracker().gT);
        boolean onTouchEvent = super.onTouchEvent(motionEvent);
        getTouchTracker().gT.set(this.CfS);
        AppMethodBeat.o(76162);
        return onTouchEvent;
    }

    @Override // com.tencent.mm.plugin.recordvideo.ui.editor.view.c
    public final b getType() {
        return b.EditItemTypePosition;
    }

    public final void a(k kVar) {
        AppMethodBeat.i(237825);
        kotlin.g.b.p.h(kVar, "item");
        b(kVar);
        setViewMatrix(kVar.gT);
        getTouchTracker().gT.set(kVar.gT);
        setSourceDataType(d.CeM);
        AppMethodBeat.o(237825);
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0181  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.graphics.Bitmap b(com.tencent.mm.plugin.recordvideo.ui.editor.item.k r14) {
        /*
        // Method dump skipped, instructions count: 478
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.recordvideo.ui.editor.item.p.b(com.tencent.mm.plugin.recordvideo.ui.editor.item.k):android.graphics.Bitmap");
    }

    public final void setLocation(dlg dlg) {
        float f2;
        AppMethodBeat.i(76165);
        kotlin.g.b.p.h(dlg, FirebaseAnalytics.b.LOCATION);
        String str = dlg.kea;
        kotlin.g.b.p.g(str, "location.City");
        String str2 = dlg.kHV;
        kotlin.g.b.p.g(str2, "location.poiName");
        b(new k(str, str2, dlg.LbC, dlg.LbD));
        Bitmap bitmap = getBitmap();
        if (bitmap != null) {
            float height = ((float) ((getValidRect().height() - at.fromDPToPix(getContext(), 128)) - au.aD(getContext()))) - ((float) bitmap.getHeight());
            int i2 = this.apv;
            e eVar = e.BKp;
            if (i2 >= e.eIR().left) {
                f2 = (float) this.apv;
            } else {
                e eVar2 = e.BKp;
                f2 = (float) e.eIR().left;
            }
            getTouchTracker().gT.setTranslate(f2, height);
            AppMethodBeat.o(76165);
            return;
        }
        AppMethodBeat.o(76165);
    }

    @Override // com.tencent.mm.plugin.recordvideo.ui.editor.view.c
    public final a getEditorData() {
        return this.Cgf;
    }
}

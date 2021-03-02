package com.tencent.mm.plugin.recordvideo.ui.editor.item;

import android.content.Context;
import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.recordvideo.ui.editor.item.b.d;
import com.tencent.mm.plugin.recordvideo.ui.editor.view.b;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\rJ\n\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\u000e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0010\u001a\u00020\rJ\n\u0010\u0015\u001a\u0004\u0018\u00010\u0012H\u0016J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\u0016\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001bJ\u000e\u0010\u001d\u001a\u00020\u00192\u0006\u0010\u0010\u001a\u00020\rJ\u000e\u0010\u001e\u001a\u00020\u00192\u0006\u0010\u0010\u001a\u00020\rR\u000e\u0010\u0005\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000¨\u0006\u001f"}, hxF = {"Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/TextItemView;", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/BitmapItemView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "TAG", "", "font", "getFont", "()Ljava/lang/String;", "setFont", "(Ljava/lang/String;)V", "textItem", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/TextItem;", "createBitmap", "Landroid/graphics/Bitmap;", "item", "createEditorData", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/BaseEditorData;", "getBitmapEditorItem", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/draw/BitmapEditorItem;", "getEditorData", "getType", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/view/EditItemType;", "initScale", "", "sx", "", "sy", "reshowText", "setText", "plugin-recordvideo_release"})
public final class r extends b {
    private String CeI;
    private q Cgi;
    private final String TAG = "MicroMsg.TextItemView";

    public r(Context context) {
        super(context);
        AppMethodBeat.i(76171);
        setTextSize(getResources().getDimension(R.dimen.a1l));
        this.CeI = "";
        AppMethodBeat.o(76171);
    }

    public final void af(float f2, float f3) {
        AppMethodBeat.i(76167);
        if (!(f2 == 0.0f || f3 == 0.0f)) {
            getTouchTracker().gT.setScale(f2, f3);
        }
        AppMethodBeat.o(76167);
    }

    public final String getFont() {
        return this.CeI;
    }

    public final void setFont(String str) {
        AppMethodBeat.i(237839);
        p.h(str, "<set-?>");
        this.CeI = str;
        AppMethodBeat.o(237839);
    }

    public final void setText(q qVar) {
        AppMethodBeat.i(237840);
        p.h(qVar, "item");
        this.Cgi = qVar;
        Bitmap c2 = c(qVar);
        setText(qVar.text);
        setSourceDataType(d.TEXT);
        setColor(qVar.textColor);
        setTextBg(qVar.Cgg);
        this.CeI = qVar.CeI;
        if (getBitmap() == null) {
            getTouchTracker().gT.postTranslate(((float) (-getWidth())) / 2.0f, -((((float) ((getDisplayRect().top + getDisplayRect().bottom) / 2)) - (((float) (getValidRect().top + getValidRect().bottom)) / 2.0f)) + (((float) getHeight()) / 2.0f)));
        }
        Bitmap bitmap = getBitmap();
        if (bitmap != null) {
            getTouchTracker().gT.preTranslate(((float) bitmap.getWidth()) / 2.0f, ((float) bitmap.getHeight()) / 2.0f);
        }
        setBitmap(c2);
        postInvalidate();
        AppMethodBeat.o(237840);
    }

    @Override // com.tencent.mm.plugin.recordvideo.ui.editor.view.c
    public final a getEditorData() {
        return this.Cgi;
    }

    public final void b(q qVar) {
        AppMethodBeat.i(237841);
        p.h(qVar, "item");
        setText(qVar);
        setViewMatrix(qVar.gT);
        getTouchTracker().gT.set(qVar.gT);
        setSourceDataType(d.TEXT);
        AppMethodBeat.o(237841);
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x00b8  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x00d4 A[ADDED_TO_REGION] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.graphics.Bitmap c(com.tencent.mm.plugin.recordvideo.ui.editor.item.q r11) {
        /*
        // Method dump skipped, instructions count: 325
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.recordvideo.ui.editor.item.r.c(com.tencent.mm.plugin.recordvideo.ui.editor.item.q):android.graphics.Bitmap");
    }

    @Override // com.tencent.mm.plugin.recordvideo.ui.editor.item.g, com.tencent.mm.plugin.recordvideo.ui.editor.item.b
    public final a cJO() {
        AppMethodBeat.i(237843);
        a cJO = super.cJO();
        q qVar = this.Cgi;
        if (qVar != null) {
            if (cJO != null) {
                d dVar = qVar.Cev;
                p.h(dVar, "range");
                cJO.Cev.ai(dVar.Cgx.getTime(), dVar.Cgy.getTime());
            }
            if (cJO != null) {
                cJO.objectId = qVar.objectId;
            }
            if (cJO instanceof q) {
                String str = this.CeI;
                p.h(str, "<set-?>");
                ((q) cJO).CeI = str;
            }
        }
        AppMethodBeat.o(237843);
        return cJO;
    }

    @Override // com.tencent.mm.plugin.recordvideo.ui.editor.view.c
    public final b getType() {
        return b.EditItemTypeText;
    }
}

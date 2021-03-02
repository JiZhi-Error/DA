package com.tencent.mm.plugin.recordvideo.ui.editor.item;

import android.graphics.Matrix;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.erc;
import com.tencent.mm.protocal.protobuf.sy;
import com.tencent.mm.protocal.protobuf.tv;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.system.MimeTypeUtil;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 ,2\u00020\u0001:\u0001,B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B/\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bB\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ\u0010\u0010#\u001a\u0004\u0018\u00010\u00072\u0006\u0010$\u001a\u00020%J\u0010\u0010&\u001a\u0004\u0018\u00010\u00072\u0006\u0010$\u001a\u00020%J\b\u0010'\u001a\u00020(H\u0016J\b\u0010)\u001a\u00020*H\u0016J\b\u0010+\u001a\u00020\u001bH\u0016R\u001a\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R*\u0010\u0015\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001a\u0010 \u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0012\"\u0004\b\"\u0010\u0014¨\u0006-"}, hxF = {"Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/CaptionItem;", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/BaseEditorData;", "type", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/EditorDataType;", "(Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/EditorDataType;)V", "list", "Ljava/util/ArrayList;", "Lcom/tencent/mm/protocal/protobuf/CCTransResult;", "Lkotlin/collections/ArrayList;", "matrix", "Landroid/graphics/Matrix;", "(Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/EditorDataType;Ljava/util/ArrayList;Landroid/graphics/Matrix;)V", "byteArray", "", "(Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/EditorDataType;[B)V", "bgColor", "", "getBgColor", "()I", "setBgColor", "(I)V", "captionList", "getCaptionList", "()Ljava/util/ArrayList;", "setCaptionList", "(Ljava/util/ArrayList;)V", "font", "", "getFont", "()Ljava/lang/String;", "setFont", "(Ljava/lang/String;)V", "textColor", "getTextColor", "setTextColor", "getCurrentTransResult", "timeMs", "", "getShowCaptionAtTime", "isValid", "", "toProtoBuf", "Lcom/tencent/mm/protocal/protobuf/CaptionItemData;", "toString", "Companion", "plugin-recordvideo_release"})
public final class c extends a {
    public static final a CeJ = new a((byte) 0);
    public ArrayList<sy> CeH = new ArrayList<>();
    public String CeI;
    public int bgColor;
    public int textColor;

    static {
        AppMethodBeat.i(237754);
        AppMethodBeat.o(237754);
    }

    @Override // com.tencent.mm.plugin.recordvideo.ui.editor.item.h
    public final /* synthetic */ com.tencent.mm.bw.a eMk() {
        AppMethodBeat.i(237749);
        tv eMj = eMj();
        AppMethodBeat.o(237749);
        return eMj;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/CaptionItem$Companion;", "", "()V", "TAG", "", "plugin-recordvideo_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public c(d dVar) {
        super(dVar);
        p.h(dVar, "type");
        AppMethodBeat.i(237751);
        AppMethodBeat.o(237751);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public c(d dVar, ArrayList<sy> arrayList, Matrix matrix) {
        super(dVar);
        p.h(dVar, "type");
        p.h(arrayList, "list");
        p.h(matrix, "matrix");
        AppMethodBeat.i(237752);
        this.CeH.clear();
        this.CeH.addAll(arrayList);
        this.gT.set(matrix);
        AppMethodBeat.o(237752);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public c(d dVar, byte[] bArr) {
        super(dVar);
        p.h(dVar, "type");
        p.h(bArr, "byteArray");
        AppMethodBeat.i(237753);
        try {
            tv tvVar = new tv();
            try {
                tvVar.parseFrom(bArr);
            } catch (Exception e2) {
                Log.printDebugStack("safeParser", "", e2);
                tvVar = null;
            }
            tv tvVar2 = tvVar;
            if (tvVar2 != null) {
                this.CeH.clear();
                this.CeH.addAll(tvVar2.Lbb);
                Matrix matrix = this.gT;
                erc erc = tvVar2.Lce;
                p.g(erc, "captionData.matrix");
                matrix.setValues(a(erc));
                this.bgColor = tvVar2.Lcg;
                this.textColor = tvVar2.Lcf;
                this.CeI = tvVar2.CeI;
                Log.i("MicroMsg.CaptionItem", toString());
                AppMethodBeat.o(237753);
                return;
            }
            AppMethodBeat.o(237753);
        } catch (IOException e3) {
            Log.printErrStackTrace("MicroMsg.CaptionItem", e3, "LocationItem parse error", new Object[0]);
            AppMethodBeat.o(237753);
        }
    }

    public final sy Ii(long j2) {
        AppMethodBeat.i(237747);
        for (T t : this.CeH) {
            if (t.LaT <= j2 && t.LaU >= j2) {
                AppMethodBeat.o(237747);
                return t;
            }
        }
        AppMethodBeat.o(237747);
        return null;
    }

    public final tv eMj() {
        AppMethodBeat.i(237748);
        tv tvVar = new tv();
        tvVar.Lbb.addAll(this.CeH);
        tvVar.Lce = f(this.gT);
        tvVar.Lcg = this.bgColor;
        tvVar.Lcf = this.textColor;
        tvVar.CeI = this.CeI;
        AppMethodBeat.o(237748);
        return tvVar;
    }

    public final String toString() {
        AppMethodBeat.i(237750);
        Iterator<sy> it = this.CeH.iterator();
        while (it.hasNext()) {
            sy next = it.next();
            new StringBuilder().append("").append("start:").append(next.LaT).append(" end:").append(next.LaU).append(" text:").append(next.LaS.toString(MimeTypeUtil.ContentType.DEFAULT_CHARSET)).append('\n');
        }
        AppMethodBeat.o(237750);
        return "";
    }
}

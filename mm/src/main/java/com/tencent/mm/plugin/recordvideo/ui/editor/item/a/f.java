package com.tencent.mm.plugin.recordvideo.ui.editor.item.a;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.ckm;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, hxF = {"Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/draw/LyricsEditorInfo;", "", "itemInfo", "Lcom/tencent/mm/protocal/protobuf/LyricsItemInfo;", "bitmap", "Landroid/graphics/Bitmap;", "(Lcom/tencent/mm/protocal/protobuf/LyricsItemInfo;Landroid/graphics/Bitmap;)V", "getBitmap", "()Landroid/graphics/Bitmap;", "getItemInfo", "()Lcom/tencent/mm/protocal/protobuf/LyricsItemInfo;", "plugin-recordvideo_release"})
public final class f {
    final ckm Cgr;
    final Bitmap bitmap;

    public f(ckm ckm, Bitmap bitmap2) {
        p.h(ckm, "itemInfo");
        p.h(bitmap2, "bitmap");
        AppMethodBeat.i(237865);
        this.Cgr = ckm;
        this.bitmap = bitmap2;
        AppMethodBeat.o(237865);
    }
}

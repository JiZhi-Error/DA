package com.tencent.mm.plugin.finder.video.sticker;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sticker.c;
import java.util.ArrayList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0018\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\nH\u0016J\u0018\u0010\u000f\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0018\u0010\u0010\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0010\u0010\u0011\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0001J\u0016\u0010\u0012\u001a\u00020\b2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0016R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0001X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0014"}, hxF = {"Lcom/tencent/mm/plugin/finder/video/sticker/DiffCallbackHolder;", "Lcom/tencent/mm/plugin/finder/video/sticker/StickerDiffCallback;", "()V", "callback", "dataList", "", "Lcom/tencent/mm/sticker/LensItem;", "onInsert", "", "start", "", "count", "onMove", "fromPos", "toPos", "onRemove", "onUpdate", "setCallback", "updateData", "lensList", "plugin-finder_release"})
public final class a implements d {
    private List<c> dataList = new ArrayList();
    private d wiO;

    public a() {
        AppMethodBeat.i(254553);
        AppMethodBeat.o(254553);
    }

    public final void a(d dVar) {
        AppMethodBeat.i(254547);
        this.wiO = dVar;
        dVar.ad(this.dataList);
        dVar.fH(0, this.dataList.size());
        AppMethodBeat.o(254547);
    }

    @Override // com.tencent.mm.plugin.finder.video.sticker.d
    public final void ad(List<c> list) {
        AppMethodBeat.i(254548);
        p.h(list, "lensList");
        this.dataList = list;
        d dVar = this.wiO;
        if (dVar != null) {
            dVar.ad(list);
            AppMethodBeat.o(254548);
            return;
        }
        AppMethodBeat.o(254548);
    }

    @Override // com.tencent.mm.plugin.finder.video.sticker.d
    public final void fH(int i2, int i3) {
        AppMethodBeat.i(254549);
        d dVar = this.wiO;
        if (dVar != null) {
            dVar.fH(i2, i3);
            AppMethodBeat.o(254549);
            return;
        }
        AppMethodBeat.o(254549);
    }

    @Override // com.tencent.mm.plugin.finder.video.sticker.d
    public final void fI(int i2, int i3) {
        AppMethodBeat.i(254550);
        d dVar = this.wiO;
        if (dVar != null) {
            dVar.fI(i2, i3);
            AppMethodBeat.o(254550);
            return;
        }
        AppMethodBeat.o(254550);
    }

    @Override // com.tencent.mm.plugin.finder.video.sticker.d
    public final void fJ(int i2, int i3) {
        AppMethodBeat.i(254551);
        d dVar = this.wiO;
        if (dVar != null) {
            dVar.fJ(i2, i3);
            AppMethodBeat.o(254551);
            return;
        }
        AppMethodBeat.o(254551);
    }

    @Override // com.tencent.mm.plugin.finder.video.sticker.d
    public final void fK(int i2, int i3) {
        AppMethodBeat.i(254552);
        d dVar = this.wiO;
        if (dVar != null) {
            dVar.fK(i2, i3);
            AppMethodBeat.o(254552);
            return;
        }
        AppMethodBeat.o(254552);
    }
}

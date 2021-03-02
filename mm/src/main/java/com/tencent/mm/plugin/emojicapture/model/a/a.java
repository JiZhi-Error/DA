package com.tencent.mm.plugin.emojicapture.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sticker.c;
import java.util.ArrayList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0018\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\nH\u0016J\u0018\u0010\u000f\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0018\u0010\u0010\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0010\u0010\u0011\u001a\u00020\b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001J\u0016\u0010\u0013\u001a\u00020\b2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0016R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0001X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, hxF = {"Lcom/tencent/mm/plugin/emojicapture/model/capture/DataCallbackHolder;", "Lcom/tencent/mm/plugin/emojicapture/model/capture/StickerListDiffCallback;", "()V", "dataCallback", "dataList", "", "Lcom/tencent/mm/sticker/LensItem;", "onInsert", "", "start", "", "count", "onMove", "fromPos", "toPos", "onRemove", "onUpdate", "setDataCallback", "callback", "updateData", "lensList", "plugin-emojicapture_release"})
public final class a implements c {
    public List<c> dataList = new ArrayList();
    public c roK;

    public a() {
        AppMethodBeat.i(209);
        AppMethodBeat.o(209);
    }

    @Override // com.tencent.mm.plugin.emojicapture.model.a.c
    public final void ad(List<c> list) {
        AppMethodBeat.i(204);
        p.h(list, "lensList");
        this.dataList = list;
        c cVar = this.roK;
        if (cVar != null) {
            cVar.ad(list);
            AppMethodBeat.o(204);
            return;
        }
        AppMethodBeat.o(204);
    }

    @Override // com.tencent.mm.plugin.emojicapture.model.a.c
    public final void fH(int i2, int i3) {
        AppMethodBeat.i(205);
        c cVar = this.roK;
        if (cVar != null) {
            cVar.fH(i2, i3);
            AppMethodBeat.o(205);
            return;
        }
        AppMethodBeat.o(205);
    }

    @Override // com.tencent.mm.plugin.emojicapture.model.a.c
    public final void fI(int i2, int i3) {
        AppMethodBeat.i(206);
        c cVar = this.roK;
        if (cVar != null) {
            cVar.fI(i2, i3);
            AppMethodBeat.o(206);
            return;
        }
        AppMethodBeat.o(206);
    }

    @Override // com.tencent.mm.plugin.emojicapture.model.a.c
    public final void fJ(int i2, int i3) {
        AppMethodBeat.i(207);
        c cVar = this.roK;
        if (cVar != null) {
            cVar.fJ(i2, i3);
            AppMethodBeat.o(207);
            return;
        }
        AppMethodBeat.o(207);
    }

    @Override // com.tencent.mm.plugin.emojicapture.model.a.c
    public final void fK(int i2, int i3) {
        AppMethodBeat.i(208);
        c cVar = this.roK;
        if (cVar != null) {
            cVar.fK(i2, i3);
            AppMethodBeat.o(208);
            return;
        }
        AppMethodBeat.o(208);
    }
}

package com.tencent.mm.plugin.multitask.ui.minusscreen.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.multitask.model.MultiTaskInfo;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\nH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000b"}, hxF = {"Lcom/tencent/mm/plugin/multitask/ui/minusscreen/data/RVMultiTaskData;", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "multiTaskInfoObj", "Lcom/tencent/mm/plugin/multitask/model/MultiTaskInfo;", "(Lcom/tencent/mm/plugin/multitask/model/MultiTaskInfo;)V", "getMultiTaskInfoObj", "()Lcom/tencent/mm/plugin/multitask/model/MultiTaskInfo;", "getItemId", "", "getItemType", "", "ui-multitask_release"})
public final class a implements com.tencent.mm.view.recyclerview.a {
    public final MultiTaskInfo Aen;

    public a(MultiTaskInfo multiTaskInfo) {
        p.h(multiTaskInfo, "multiTaskInfoObj");
        AppMethodBeat.i(236502);
        this.Aen = multiTaskInfo;
        AppMethodBeat.o(236502);
    }

    @Override // com.tencent.mm.view.recyclerview.a
    public final long lT() {
        AppMethodBeat.i(236501);
        long hashCode = (long) (this.Aen.field_id.hashCode() + Integer.valueOf(this.Aen.field_type).hashCode());
        AppMethodBeat.o(236501);
        return hashCode;
    }

    @Override // com.tencent.mm.view.recyclerview.a
    public final int cxn() {
        return this.Aen.field_type;
    }
}

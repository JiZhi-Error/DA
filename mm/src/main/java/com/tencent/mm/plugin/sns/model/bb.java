package com.tencent.mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ui.bq;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import java.lang.ref.WeakReference;
import java.util.LinkedList;
import java.util.List;

public final class bb implements e {
    public List<WeakReference<e>> DOu = new LinkedList();

    public bb() {
        AppMethodBeat.i(95990);
        AppMethodBeat.o(95990);
    }

    public final void a(e eVar) {
        AppMethodBeat.i(95991);
        for (WeakReference<e> weakReference : this.DOu) {
            if (!(weakReference == null || weakReference.get() == null || !weakReference.get().equals(eVar))) {
                AppMethodBeat.o(95991);
                return;
            }
        }
        this.DOu.add(new WeakReference<>(eVar));
        AppMethodBeat.o(95991);
    }

    @Override // com.tencent.mm.plugin.sns.model.e
    public final void a(int i2, String str, long j2, TimeLineObject timeLineObject, boolean z, bq bqVar) {
        AppMethodBeat.i(95992);
        for (WeakReference<e> weakReference : this.DOu) {
            if (!(weakReference == null || weakReference.get() == null)) {
                weakReference.get().a(i2, str, j2, timeLineObject, z, bqVar);
            }
        }
        AppMethodBeat.o(95992);
    }

    @Override // com.tencent.mm.plugin.sns.model.e
    public final void a(int i2, String str, long j2, TimeLineObject timeLineObject, boolean z) {
        AppMethodBeat.i(95993);
        for (WeakReference<e> weakReference : this.DOu) {
            if (!(weakReference == null || weakReference.get() == null)) {
                weakReference.get().a(i2, str, j2, timeLineObject, z);
            }
        }
        AppMethodBeat.o(95993);
    }
}

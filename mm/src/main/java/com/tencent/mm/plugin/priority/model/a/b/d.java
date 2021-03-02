package com.tencent.mm.plugin.priority.model.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.priority.model.a.a;
import com.tencent.mm.plugin.priority.model.b;
import com.tencent.mm.sdk.platformtools.Log;

public final class d extends a {
    public d(b bVar) {
        super(bVar);
        AppMethodBeat.i(87842);
        Log.i("MicroMsg.Priority.C2CMsgFileUsageStorage", "Create FileUsageStorage");
        AppMethodBeat.o(87842);
    }

    @Override // com.tencent.mm.plugin.priority.model.a.a
    public final long eCV() {
        return 33;
    }

    @Override // com.tencent.mm.plugin.priority.model.a.a
    public final String getTableName() {
        return "C2CMsgFileUsage";
    }
}

package com.tencent.mm.plugin.priority.model.a.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.priority.model.a.a;
import com.tencent.mm.plugin.priority.model.b;
import com.tencent.mm.sdk.platformtools.Log;

public final class d extends a {
    public d(b bVar) {
        super(bVar);
        AppMethodBeat.i(87865);
        Log.i("MicroMsg.Priority.C2CMsgImgUsageStorage", "Create ImgUsageStorage");
        AppMethodBeat.o(87865);
    }

    @Override // com.tencent.mm.plugin.priority.model.a.a
    public final long eCV() {
        return 17;
    }

    @Override // com.tencent.mm.plugin.priority.model.a.a
    public final String getTableName() {
        return "C2CMsgImgUsage";
    }
}

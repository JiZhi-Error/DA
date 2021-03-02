package com.tencent.mm.w;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tavkit.component.TAVExporter;

public final class a extends com.tencent.mm.plugin.fts.a.a {
    @Override // com.tencent.mm.plugin.fts.a.i
    public final String getName() {
        return "FTS5FriendStorage";
    }

    @Override // com.tencent.mm.plugin.fts.a.i
    public final int getType() {
        return TAVExporter.VIDEO_EXPORT_HEIGHT;
    }

    @Override // com.tencent.mm.plugin.fts.a.i
    public final int getPriority() {
        return TAVExporter.VIDEO_EXPORT_HEIGHT;
    }

    @Override // com.tencent.mm.plugin.fts.a.a
    public final void awY() {
        AppMethodBeat.i(127630);
        if (awZ()) {
            this.wUt.W(-107, 1);
        }
        AppMethodBeat.o(127630);
    }

    @Override // com.tencent.mm.plugin.fts.a.a
    public final String getTableName() {
        return "Friend";
    }

    @Override // com.tencent.mm.plugin.fts.a.a
    public final boolean awZ() {
        AppMethodBeat.i(127631);
        if (!gD(-107, 1)) {
            AppMethodBeat.o(127631);
            return true;
        }
        AppMethodBeat.o(127631);
        return false;
    }
}

package com.tencent.mm.ui.contact;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.a.m;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashSet;
import java.util.List;

public final class t extends s {
    private HashSet<String> PWQ = new HashSet<>();

    public t(MMBaseSelectContactUI mMBaseSelectContactUI, List<String> list, boolean z, String str) {
        super(mMBaseSelectContactUI, list, z, 0);
        AppMethodBeat.i(102890);
        if (!Util.isNullOrNil(str)) {
            this.PWQ.addAll(Util.stringsToList(str.split(",")));
            Log.i("MicroMsg.MMSearchSportContactAdapter", "matchUsernameSet %s", Integer.valueOf(this.PWQ.size()));
        }
        AppMethodBeat.o(102890);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.ui.contact.s
    public final void jJ(List<m> list) {
        AppMethodBeat.i(102891);
        super.jJ(list);
        if (this.PWQ.size() > 0) {
            for (int size = list.size() - 1; size >= 0; size--) {
                if (!this.PWQ.contains(list.get(size).wVX)) {
                    list.remove(size);
                }
            }
        }
        AppMethodBeat.o(102891);
    }
}

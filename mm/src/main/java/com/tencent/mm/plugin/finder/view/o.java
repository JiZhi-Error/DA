package com.tencent.mm.plugin.finder.view;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.aps;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¨\u0006\u0004"}, hxF = {"safeParseFrom", "Lcom/tencent/mm/protocal/protobuf/FinderContactMsgInfo;", "byteArray", "", "plugin-finder_release"})
public final class o {
    public static final aps a(aps aps, byte[] bArr) {
        AppMethodBeat.i(255044);
        p.h(aps, "$this$safeParseFrom");
        if (bArr == null) {
            AppMethodBeat.o(255044);
        } else {
            try {
                aps.parseFrom(bArr);
            } catch (Exception e2) {
            }
            AppMethodBeat.o(255044);
        }
        return aps;
    }
}

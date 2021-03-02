package com.tencent.mm.plugin.finder.storage.data;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.platformtools.d;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.protocal.protobuf.aqr;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.s;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 \u00062\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0006B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/finder/storage/data/FansContactPage;", "Lcom/tencent/mm/platformtools/BaseProtoPage;", "Lcom/tencent/mm/protocal/protobuf/FinderFansContact;", "filename", "", "(Ljava/lang/String;)V", "Companion", "plugin-finder_release"})
public final class b extends d<aqr> {
    private static final String TAG = TAG;
    public static final a vFQ = new a((byte) 0);

    public b(String str) {
        p.h(str, "filename");
        AppMethodBeat.i(167043);
        StringBuilder sb = new StringBuilder();
        y yVar = y.vXH;
        super.Sg(sb.append(y.LA(3)).append(str).toString());
        AppMethodBeat.o(167043);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0005\u001a\u00020\u0006R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/finder/storage/data/FansContactPage$Companion;", "", "()V", "TAG", "", "clearAll", "", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static void clearAll() {
            AppMethodBeat.i(167042);
            Log.i(b.TAG, "clearAll");
            y yVar = y.vXH;
            String LA = y.LA(3);
            if (s.YS(LA)) {
                s.dy(LA, true);
            }
            AppMethodBeat.o(167042);
        }
    }

    static {
        AppMethodBeat.i(167044);
        AppMethodBeat.o(167044);
    }
}

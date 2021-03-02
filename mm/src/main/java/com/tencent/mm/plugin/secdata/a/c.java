package com.tencent.mm.plugin.secdata.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.HashMap;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\n\u001a\u00020\u000bR-\u0010\u0003\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006`\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\f"}, hxF = {"Lcom/tencent/mm/plugin/secdata/model/SecReportDataInfoMemoryStorage;", "", "()V", "map", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/protobuf/BaseProtoBuf;", "Lkotlin/collections/HashMap;", "getMap", "()Ljava/util/HashMap;", "clear", "", "plugin-sec-data_release"})
public final class c {
    public static final c CWk = new c();
    private static final HashMap<String, a> map = new HashMap<>();

    static {
        AppMethodBeat.i(219176);
        AppMethodBeat.o(219176);
    }

    private c() {
    }

    public static HashMap<String, a> eSp() {
        return map;
    }

    public static void clear() {
        AppMethodBeat.i(219175);
        map.clear();
        AppMethodBeat.o(219175);
    }
}

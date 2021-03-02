package com.tencent.mm.plugin.gamelife;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.as;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, hxF = {"Lcom/tencent/mm/plugin/gamelife/GameLifeUtil;", "", "()V", "Companion", "plugin-gamelife_release"})
public final class b {
    public static final a xZZ = new a((byte) 0);

    static {
        AppMethodBeat.i(241190);
        AppMethodBeat.o(241190);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006J\u0014\u0010\u0007\u001a\u00020\u00062\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00060\t¨\u0006\n"}, hxF = {"Lcom/tencent/mm/plugin/gamelife/GameLifeUtil$Companion;", "", "()V", "checkSessionId", "", "sessionId", "", "genStringArray", "stringList", "", "plugin-gamelife_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static boolean aAQ(String str) {
            AppMethodBeat.i(241188);
            if (str == null) {
                AppMethodBeat.o(241188);
                return false;
            } else if (as.bju(str)) {
                AppMethodBeat.o(241188);
                return true;
            } else {
                Log.i("GameLife.PluginGameLife", "check sessionId failed");
                AppMethodBeat.o(241188);
                return false;
            }
        }

        public static String fc(List<String> list) {
            AppMethodBeat.i(241189);
            p.h(list, "stringList");
            if (list.isEmpty()) {
                AppMethodBeat.o(241189);
                return "()";
            }
            StringBuilder sb = new StringBuilder();
            sb.append("(");
            int size = list.size() - 1;
            for (int i2 = 0; i2 < size; i2++) {
                sb.append("'").append(list.get(i2)).append("',");
            }
            sb.append("'").append(list.get(list.size() - 1)).append("')");
            String sb2 = sb.toString();
            p.g(sb2, "sb.toString()");
            AppMethodBeat.o(241189);
            return sb2;
        }
    }
}

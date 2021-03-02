package com.tencent.mm.plugin.appbrand.appusage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0001\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000bB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\f"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/appusage/NotifyType;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "MODIFY_HISTORY_LIST", "MODIFY_STAR_LIST", "DELETE_HISTORY_LIST", "DELETE_STAR_LIST", "Companion", "plugin-appbrand-integration_release"})
public enum ak {
    MODIFY_HISTORY_LIST(1),
    MODIFY_STAR_LIST(2),
    DELETE_HISTORY_LIST(3),
    DELETE_STAR_LIST(4);
    
    public static final a kWj = new a((byte) 0);
    final int value;

    public static ak valueOf(String str) {
        AppMethodBeat.i(228130);
        ak akVar = (ak) Enum.valueOf(ak.class, str);
        AppMethodBeat.o(228130);
        return akVar;
    }

    private ak(int i2) {
        this.value = i2;
    }

    static {
        AppMethodBeat.i(228128);
        AppMethodBeat.o(228128);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/appusage/NotifyType$Companion;", "", "()V", "getByValue", "Lcom/tencent/mm/plugin/appbrand/appusage/NotifyType;", "value", "", "plugin-appbrand-integration_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static ak wa(int i2) {
            AppMethodBeat.i(228127);
            ak[] values = ak.values();
            for (ak akVar : values) {
                if (akVar.value == i2) {
                    AppMethodBeat.o(228127);
                    return akVar;
                }
            }
            AppMethodBeat.o(228127);
            return null;
        }
    }
}

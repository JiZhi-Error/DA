package com.tencent.mm.plugin.finder.storage.config.item;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;
import java.util.List;
import kotlin.a.j;
import kotlin.l;
import kotlin.o;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, hxF = {"Lcom/tencent/mm/plugin/finder/storage/config/item/ConfigUtil;", "", "()V", "Companion", "plugin-finder_release"})
public final class b {
    public static final a vFL = new a((byte) 0);

    static {
        AppMethodBeat.i(251933);
        AppMethodBeat.o(251933);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J%\u0010\u0003\u001a\u0002H\u0004\"\u0004\b\u0000\u0010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u0001H\u0004¢\u0006\u0002\u0010\bJB\u0010\t\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u00020\u00060\u000b0\n\"\u0004\b\u0000\u0010\u00042\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u0002H\u0004\u0018\u00010\r2\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\rJ%\u0010\u000f\u001a\u00020\u0010\"\u0004\b\u0000\u0010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0011\u001a\u0004\u0018\u0001H\u0004¢\u0006\u0002\u0010\u0012¨\u0006\u0013"}, hxF = {"Lcom/tencent/mm/plugin/finder/storage/config/item/ConfigUtil$Companion;", "", "()V", "getSpValue", "T", "spKey", "", "defValue", "(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;", "makePairList", "Ljava/util/LinkedList;", "Lkotlin/Pair;", "configDataList", "", "configDataNameList", "setSpValue", "", "newValue", "(Ljava/lang/String;Ljava/lang/Object;)V", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static <T> LinkedList<o<T, String>> n(List<? extends T> list, List<String> list2) {
            String str;
            AppMethodBeat.i(251932);
            LinkedList<o<T, String>> linkedList = new LinkedList<>();
            if (list != null) {
                int i2 = 0;
                for (T t : list) {
                    int i3 = i2 + 1;
                    if (i2 < 0) {
                        j.hxH();
                    }
                    if (list2 == null || (str = (String) j.L(list2, i2)) == null) {
                        str = "";
                    }
                    linkedList.add(new o<>(t, str));
                    i2 = i3;
                }
            }
            AppMethodBeat.o(251932);
            return linkedList;
        }
    }
}

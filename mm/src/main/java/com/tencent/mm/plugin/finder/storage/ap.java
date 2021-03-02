package com.tencent.mm.plugin.finder.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, hxF = {"Lcom/tencent/mm/plugin/finder/storage/StgUtil;", "", "()V", "Companion", "plugin-finder_release"})
public final class ap {
    public static final a vFv = new a((byte) 0);

    static {
        AppMethodBeat.i(167041);
        AppMethodBeat.o(167041);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\u0004J$\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\nJ\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eJ\u001a\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00070\u00102\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¨\u0006\u0011"}, hxF = {"Lcom/tencent/mm/plugin/finder/storage/StgUtil$Companion;", "", "()V", "buildLimitString", "", "data", "", "", "col", "reverse", "", "createLocalMediaObj", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "feedMedia", "Lcom/tencent/mm/protocal/protobuf/FinderMedia;", "getORIntRange", "Ljava/util/ArrayList;", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static ArrayList<Integer> eu(List<Integer> list) {
            AppMethodBeat.i(251902);
            p.h(list, "data");
            ArrayList arrayList = new ArrayList(list);
            HashSet hashSet = new HashSet();
            ArrayList<Integer> arrayList2 = new ArrayList<>();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                Integer num = (Integer) it.next();
                ArrayList arrayList3 = new ArrayList();
                Iterator it2 = hashSet.iterator();
                while (it2.hasNext()) {
                    int intValue = ((Integer) it2.next()).intValue();
                    p.g(num, "i");
                    arrayList3.add(Integer.valueOf(intValue | num.intValue()));
                }
                hashSet.addAll(new HashSet(arrayList3));
                hashSet.add(num);
            }
            hashSet.add(0);
            arrayList2.addAll(hashSet);
            AppMethodBeat.o(251902);
            return arrayList2;
        }

        public static String k(List<Integer> list, String str) {
            AppMethodBeat.i(167039);
            p.h(list, "data");
            p.h(str, "col");
            String l = l(list, str);
            AppMethodBeat.o(167039);
            return l;
        }

        private static String l(List<Integer> list, String str) {
            AppMethodBeat.i(167040);
            p.h(list, "data");
            p.h(str, "col");
            StringBuilder sb = new StringBuilder("(");
            sb.append(str + " in (");
            Iterator<Integer> it = list.iterator();
            while (it.hasNext()) {
                sb.append(it.next().intValue());
                if (it.hasNext()) {
                    sb.append(",");
                }
            }
            sb.append(")");
            sb.append(")");
            String sb2 = sb.toString();
            p.g(sb2, "sb.toString()");
            AppMethodBeat.o(167040);
            return sb2;
        }
    }
}

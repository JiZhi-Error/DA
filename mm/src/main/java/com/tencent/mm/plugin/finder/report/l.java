package com.tencent.mm.plugin.finder.report;

import com.google.android.gms.actions.SearchIntents;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.expt.b.c;
import com.tencent.mm.plugin.finder.report.o;
import com.tencent.mm.plugin.finder.search.a;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.protocal.protobuf.alc;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import java.util.List;
import kotlin.g.b.p;
import kotlin.n.n;
import org.json.JSONObject;

@kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J@\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\fJB\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\fJL\u0010\u0012\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000b\u001a\u00020\f2\"\u0010\u0013\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00150\u0014j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0015`\u00162\u0006\u0010\u0011\u001a\u00020\fJ\u000e\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\fJ\u001c\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\u00042\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00040\u001bR\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u001c"}, hxF = {"Lcom/tencent/mm/plugin/finder/report/FinderSearchReportLogic;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "report18690", "", "requestId", SearchIntents.EXTRA_QUERY, "requestType", "", "itemType", "itemId", "", "position", "scene", "report18691", "exposeItemMap", "Ljava/util/HashMap;", "Lcom/tencent/mm/plugin/finder/search/FinderExposeItem;", "Lkotlin/collections/HashMap;", "report19184", "reportExtStats", "searchStr", "result", "", "plugin-finder_release"})
public final class l {
    private static final String TAG = TAG;
    public static final l vfB = new l();

    static {
        AppMethodBeat.i(166603);
        AppMethodBeat.o(166603);
    }

    private l() {
    }

    public static void e(String str, String str2, String str3, int i2) {
        AppMethodBeat.i(250708);
        p.h(str, "requestId");
        String nullAs = Util.nullAs(str2, "");
        p.g(nullAs, "Util.nullAs(query, \"\")");
        StringBuilder append = new StringBuilder().append(str).append(',').append(n.j(nullAs, ",", " ", false)).append(',').append(0).append(',').append(1).append(',');
        if (str3 == null) {
            str3 = "";
        }
        String sb = append.append(str3).append(',').append(i2).append(',').append(2).toString();
        Log.i(TAG, "report18690 %s", sb);
        e.INSTANCE.kvStat(18690, sb);
        AppMethodBeat.o(250708);
    }

    public static void a(String str, String str2, HashMap<String, a> hashMap, int i2) {
        AppMethodBeat.i(166601);
        p.h(str, "requestId");
        p.h(hashMap, "exposeItemMap");
        String nullAs = Util.nullAs(str2, "");
        p.g(nullAs, "Util.nullAs(query, \"\")");
        String j2 = n.j(nullAs, ",", " ", false);
        StringBuffer stringBuffer = new StringBuffer();
        long j3 = 0;
        for (a aVar : hashMap.values()) {
            if (!aVar.vtY) {
                aVar.vtY = true;
                stringBuffer.append(aVar.position);
                stringBuffer.append("#");
                stringBuffer.append(aVar.type);
                stringBuffer.append("#");
                stringBuffer.append(aVar.id);
                stringBuffer.append("#");
                stringBuffer.append(aVar.timeStamp);
                stringBuffer.append(";");
                if (aVar.timeStamp < j3) {
                    j3 = aVar.timeStamp;
                }
            }
        }
        if (stringBuffer.length() == 0) {
            AppMethodBeat.o(166601);
            return;
        }
        String sb = new StringBuilder().append(str).append(',').append(j2).append(',').append(0).append(',').append(stringBuffer).append(',').append(i2).append(',').append(System.currentTimeMillis() - j3).append(',').append(hashMap.isEmpty() ? 0 : 1).toString();
        Log.i(TAG, "report18691 ".concat(String.valueOf(sb)));
        e.INSTANCE.kvStat(18691, sb);
        AppMethodBeat.o(166601);
    }

    public static void doe() {
        AppMethodBeat.i(166602);
        String str = ((c) g.af(c.class)).cMD() + ',' + 1;
        Log.i(TAG, "report19184 ".concat(String.valueOf(str)));
        e.INSTANCE.kvStat(19184, str);
        AppMethodBeat.o(166602);
    }

    public static void t(String str, List<String> list) {
        AppMethodBeat.i(250709);
        p.h(str, "searchStr");
        p.h(list, "result");
        if (str.length() == 0) {
            AppMethodBeat.o(250709);
            return;
        }
        o.a aVar = o.vfN;
        alc alc = new alc();
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("feedActionType", 10);
        jSONObject.put("search_data", str);
        jSONObject.put("result_list", list.subList(0, Math.min(list.size(), 50)));
        alc.Lub = jSONObject.toString();
        alc.finderUsername = z.aUg();
        o.a.a(null, alc);
        AppMethodBeat.o(250709);
    }
}

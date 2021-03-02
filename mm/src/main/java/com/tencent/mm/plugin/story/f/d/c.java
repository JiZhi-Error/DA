package com.tencent.mm.plugin.story.f.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.plugin.story.api.p;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\u0018\u00002\u00020\u0001Bu\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012$\b\u0002\u0010\n\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00030\fj\b\u0012\u0004\u0012\u00020\u0003`\r0\u000b\u0012\u0018\b\u0002\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\u00030\fj\b\u0012\u0004\u0012\u00020\u0003`\r\u0012\u0006\u0010\u000f\u001a\u00020\u0010¢\u0006\u0002\u0010\u0011R!\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\u00030\fj\b\u0012\u0004\u0012\u00020\u0003`\r¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R-\u0010\n\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00030\fj\b\u0012\u0004\u0012\u00020\u0003`\r0\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0018R\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001a¨\u0006\u001b"}, hxF = {"Lcom/tencent/mm/plugin/story/model/gallery/FavStoryDataSeed;", "Lcom/tencent/mm/plugin/story/api/StoryDataSeed;", "key", "", "dateList", "", "", ch.COL_USERNAME, "isMultiSelected", "", "filterList", "", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "checkedList", "queryCondition", "", "(JLjava/util/List;Ljava/lang/String;ZLjava/util/Map;Ljava/util/ArrayList;I)V", "getCheckedList", "()Ljava/util/ArrayList;", "getDateList", "()Ljava/util/List;", "getFilterList", "()Ljava/util/Map;", "()Z", "getUsername", "()Ljava/lang/String;", "plugin-story_release"})
public final class c extends p {
    public final boolean Dff;
    public final Map<String, ArrayList<Long>> FoI;
    final List<String> FoJ;
    public final ArrayList<Long> FoK;
    public final String username;

    public /* synthetic */ c(long j2, List list, String str, int i2) {
        this(j2, list, str, false, new HashMap(), new ArrayList(), i2);
        AppMethodBeat.i(118908);
        AppMethodBeat.o(118908);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r9v0, resolved type: java.util.Map<java.lang.String, ? extends java.util.ArrayList<java.lang.Long>> */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public c(long j2, List<String> list, String str, boolean z, Map<String, ? extends ArrayList<Long>> map, ArrayList<Long> arrayList, int i2) {
        super(j2, i2);
        kotlin.g.b.p.h(list, "dateList");
        kotlin.g.b.p.h(str, ch.COL_USERNAME);
        kotlin.g.b.p.h(map, "filterList");
        kotlin.g.b.p.h(arrayList, "checkedList");
        AppMethodBeat.i(118907);
        this.FoJ = list;
        this.username = str;
        this.Dff = z;
        this.FoI = map;
        this.FoK = arrayList;
        AppMethodBeat.o(118907);
    }
}

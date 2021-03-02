package com.tencent.mm.plugin.story.f.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.model.cl;
import com.tencent.mm.plugin.story.api.p;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JB\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\"\u0010\b\u001a\u001e\u0012\u0004\u0012\u00020\u0007\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00040\nj\b\u0012\u0004\u0012\u00020\u0004`\u000b0\t2\u0006\u0010\f\u001a\u00020\rH\u0016J&\u0010\u000e\u001a\u00020\u00042\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0010\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\rH\u0016Jb\u0010\u0011\u001a\u00020\u00042\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0010\u001a\u00020\u00072\"\u0010\b\u001a\u001e\u0012\u0004\u0012\u00020\u0007\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00040\nj\b\u0012\u0004\u0012\u00020\u0004`\u000b0\t2\u0016\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\u00040\nj\b\u0012\u0004\u0012\u00020\u0004`\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u001e\u0010\u0013\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u0014\u001a\u00020\u0004H\u0002¨\u0006\u0015"}, hxF = {"Lcom/tencent/mm/plugin/story/model/gallery/StoryDataSeedFactory;", "Lcom/tencent/mm/plugin/story/api/StoryDataSeed$IFactory;", "()V", "createAllFriendDataSeed", "", "userList", "", "", "filterList", "", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "queryCondition", "", "createFavDataSeed", "dateList", ch.COL_USERNAME, "createMultiSelectFavDataSeed", "checkedList", "createNewestDataSeed", "genKey", "plugin-story_release"})
public final class e implements p.b {
    public static final e FoL = new e();

    static {
        AppMethodBeat.i(118914);
        AppMethodBeat.o(118914);
    }

    private e() {
    }

    @Override // com.tencent.mm.plugin.story.api.p.b
    public final long a(List<String> list, Map<String, ? extends ArrayList<Long>> map, int i2) {
        AppMethodBeat.i(118910);
        kotlin.g.b.p.h(list, "userList");
        kotlin.g.b.p.h(map, "filterList");
        a aVar = new a(cl.aWz(), list, map, i2);
        p.a.fns().a(aVar.key, aVar);
        long j2 = aVar.key;
        AppMethodBeat.o(118910);
        return j2;
    }

    @Override // com.tencent.mm.plugin.story.api.p.b
    public final long a(List<String> list, String str, int i2) {
        AppMethodBeat.i(118911);
        kotlin.g.b.p.h(list, "dateList");
        kotlin.g.b.p.h(str, ch.COL_USERNAME);
        c cVar = new c(cl.aWz(), list, str, i2);
        p.a.fns().a(cVar.key, cVar);
        long j2 = cVar.key;
        AppMethodBeat.o(118911);
        return j2;
    }

    @Override // com.tencent.mm.plugin.story.api.p.b
    public final long a(List<String> list, String str, Map<String, ? extends ArrayList<Long>> map, ArrayList<Long> arrayList, int i2) {
        AppMethodBeat.i(118912);
        kotlin.g.b.p.h(list, "dateList");
        kotlin.g.b.p.h(str, ch.COL_USERNAME);
        kotlin.g.b.p.h(map, "filterList");
        kotlin.g.b.p.h(arrayList, "checkedList");
        c cVar = new c(cl.aWz(), list, str, true, map, arrayList, i2);
        p.a.fns().a(cVar.key, cVar);
        long j2 = cVar.key;
        AppMethodBeat.o(118912);
        return j2;
    }

    @Override // com.tencent.mm.plugin.story.api.p.b
    public final long B(List<String> list, int i2) {
        AppMethodBeat.i(118913);
        kotlin.g.b.p.h(list, "userList");
        d dVar = new d(cl.aWz(), list, i2);
        p.a.fns().a(dVar.key, dVar);
        long j2 = dVar.key;
        AppMethodBeat.o(118913);
        return j2;
    }
}

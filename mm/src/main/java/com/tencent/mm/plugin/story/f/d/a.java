package com.tencent.mm.plugin.story.f.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.story.api.p;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001BG\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\"\u0010\u0007\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00030\tj\b\u0012\u0004\u0012\u00020\u0003`\n0\b\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rR-\u0010\u0007\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00030\tj\b\u0012\u0004\u0012\u00020\u0003`\n0\b¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, hxF = {"Lcom/tencent/mm/plugin/story/model/gallery/AllFriendStoryDataSeed;", "Lcom/tencent/mm/plugin/story/api/StoryDataSeed;", "key", "", "userList", "", "", "filterList", "", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "queryCondition", "", "(JLjava/util/List;Ljava/util/Map;I)V", "getFilterList", "()Ljava/util/Map;", "getUserList", "()Ljava/util/List;", "plugin-story_release"})
public final class a extends p {
    public final Map<String, ArrayList<Long>> FoI;
    public final List<String> iPH;

    /* JADX DEBUG: Multi-variable search result rejected for r7v0, resolved type: java.util.Map<java.lang.String, ? extends java.util.ArrayList<java.lang.Long>> */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(long j2, List<String> list, Map<String, ? extends ArrayList<Long>> map, int i2) {
        super(j2, i2);
        kotlin.g.b.p.h(list, "userList");
        kotlin.g.b.p.h(map, "filterList");
        AppMethodBeat.i(118906);
        this.iPH = list;
        this.FoI = map;
        AppMethodBeat.o(118906);
    }
}

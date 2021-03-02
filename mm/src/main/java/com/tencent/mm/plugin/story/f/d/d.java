package com.tencent.mm.plugin.story.f.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.story.api.p;
import java.util.List;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, hxF = {"Lcom/tencent/mm/plugin/story/model/gallery/NewestStoryDataSeed;", "Lcom/tencent/mm/plugin/story/api/StoryDataSeed;", "key", "", "userList", "", "", "queryCondition", "", "(JLjava/util/List;I)V", "getUserList", "()Ljava/util/List;", "plugin-story_release"})
public final class d extends p {
    final List<String> iPH;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public d(long j2, List<String> list, int i2) {
        super(j2, i2);
        kotlin.g.b.p.h(list, "userList");
        AppMethodBeat.i(118909);
        this.iPH = list;
        AppMethodBeat.o(118909);
    }
}

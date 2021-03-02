package com.tencent.mm.plugin.story.f.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0014\b\u0002\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00050\t¢\u0006\u0002\u0010\nJ\b\u0010\u0015\u001a\u00020\u0003H\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001d\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00050\t¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0016"}, hxF = {"Lcom/tencent/mm/plugin/story/model/sync/StoryCommentReply;", "", "storyOwner", "", "createTime", "", "interactTime", "", "storyIds", "Ljava/util/HashMap;", "(Ljava/lang/String;IJLjava/util/HashMap;)V", "getCreateTime", "()I", "setCreateTime", "(I)V", "getInteractTime", "()J", "getStoryIds", "()Ljava/util/HashMap;", "getStoryOwner", "()Ljava/lang/String;", "toString", "plugin-story_release"})
public final class c {
    final String Foa;
    private final long FpZ;
    final HashMap<Long, Integer> Fqa;
    int iXu;

    public /* synthetic */ c(String str, int i2, long j2) {
        this(str, i2, j2, new HashMap());
        AppMethodBeat.i(119045);
        AppMethodBeat.o(119045);
    }

    private c(String str, int i2, long j2, HashMap<Long, Integer> hashMap) {
        p.h(str, "storyOwner");
        p.h(hashMap, "storyIds");
        AppMethodBeat.i(119044);
        this.Foa = str;
        this.iXu = i2;
        this.FpZ = j2;
        this.Fqa = hashMap;
        AppMethodBeat.o(119044);
    }

    public final String toString() {
        AppMethodBeat.i(119043);
        String str = "StoryCommentReply[" + this.Foa + " : " + this.iXu + " : " + this.FpZ + " : " + this.Fqa + ']';
        AppMethodBeat.o(119043);
        return str;
    }
}

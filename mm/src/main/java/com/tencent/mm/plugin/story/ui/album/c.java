package com.tencent.mm.plugin.story.ui.album;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.story.i.h;
import com.tencent.mm.protocal.protobuf.edt;
import java.util.ArrayList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u001f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\b\u0010\f\u001a\u00020\u0003H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\r"}, hxF = {"Lcom/tencent/mm/plugin/story/ui/album/StoryAlbumInfo;", "", "label", "", "storyInfos", "", "Lcom/tencent/mm/plugin/story/storage/StoryHistoryInfo;", "(Ljava/lang/String;Ljava/util/List;)V", "getLabel", "()Ljava/lang/String;", "getStoryInfos", "()Ljava/util/List;", "toString", "plugin-story_release"})
public final class c {
    final List<h> FyP;
    final String label;

    public c() {
        this(null, null, 3);
    }

    public c(String str, List<h> list) {
        p.h(str, "label");
        p.h(list, "storyInfos");
        AppMethodBeat.i(119821);
        this.label = str;
        this.FyP = list;
        AppMethodBeat.o(119821);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ c(String str, List list, int i2) {
        this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? new ArrayList() : list);
        AppMethodBeat.i(119822);
        AppMethodBeat.o(119822);
    }

    public final String toString() {
        AppMethodBeat.i(119820);
        StringBuilder sb = new StringBuilder();
        for (T t : this.FyP) {
            edt edt = t.Fqr.frG().NeB.LoV.size() > 0 ? t.Fqr.frG().NeB.LoV.get(0) : null;
            sb.append(new StringBuilder("\t[date=").append(((h) t).field_date).append(" localId=").append((int) t.Fqr.systemRowid).append(", storyId=").append(t.Fqr.field_storyID).append(", thumb=").append(edt != null ? edt.Msz : null).append(", video=").append(edt != null ? edt.Url : null).append("]\n").toString());
        }
        String str = "[" + this.label + "] \n " + ((Object) sb);
        AppMethodBeat.o(119820);
        return str;
    }
}

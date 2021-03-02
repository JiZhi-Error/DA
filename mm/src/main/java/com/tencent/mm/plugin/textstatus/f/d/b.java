package com.tencent.mm.plugin.textstatus.f.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.view.recyclerview.a;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\t\n\u0002\b\u0002\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\b\u0010\u0015\u001a\u00020\u0016H\u0016J\b\u0010\u0017\u001a\u00020\bH\u0016R \u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001e\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0010\n\u0002\u0010\u0012\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0018"}, hxF = {"Lcom/tencent/mm/plugin/textstatus/model/planet/PlanetItem;", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "topicId", "", "items", "", "Lcom/tencent/mm/plugin/textstatus/model/storage/TextStatusItem;", "liveCount", "", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/Integer;)V", "getItems", "()Ljava/util/List;", "setItems", "(Ljava/util/List;)V", "getLiveCount", "()Ljava/lang/Integer;", "setLiveCount", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getTopicId", "()Ljava/lang/String;", "getItemId", "", "getItemType", "plugin-textstatus_release"})
public final class b implements a {
    public Integer FZA;
    public final String FZz;
    public List<com.tencent.mm.plugin.textstatus.f.f.a> iHf;

    public b(String str, List<com.tencent.mm.plugin.textstatus.f.f.a> list, Integer num) {
        p.h(str, "topicId");
        p.h(list, "items");
        AppMethodBeat.i(216239);
        this.FZz = str;
        this.iHf = list;
        this.FZA = num;
        AppMethodBeat.o(216239);
    }

    @Override // com.tencent.mm.view.recyclerview.a
    public final long lT() {
        AppMethodBeat.i(216238);
        long hashCode = (long) hashCode();
        AppMethodBeat.o(216238);
        return hashCode;
    }

    @Override // com.tencent.mm.view.recyclerview.a
    public final int cxn() {
        return 1;
    }
}

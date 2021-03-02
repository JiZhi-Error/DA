package com.tencent.mm.plugin.finder.feed.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.List;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J)\u0010\u0010\u001a\u00020\u00002!\u0010\u0011\u001a\u001d\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00020\u00160\u0012J;\u0010\u0017\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0018j\b\u0012\u0004\u0012\u00020\u0006`\u00192!\u0010\u0011\u001a\u001d\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00020\u00160\u0012H\u0002J\b\u0010\u001a\u001a\u00020\tH\u0016R\u0014\u0010\b\u001a\u00020\tXD¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001b"}, hxF = {"Lcom/tencent/mm/plugin/finder/feed/model/LoaderCacheData;", "", "position", "", "feedList", "", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "(ILjava/util/List;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "getFeedList", "()Ljava/util/List;", "getPosition", "()I", "filterFeed", "filterLogic", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "feed", "", "filterFeedImpl", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "toString", "plugin-finder_release"})
public final class i {
    private final String TAG = "Finder.LoaderCacheData";
    public final int position;
    public final List<bo> tXV;

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: java.util.List<? extends com.tencent.mm.plugin.finder.model.bo> */
    /* JADX WARN: Multi-variable type inference failed */
    public i(int i2, List<? extends bo> list) {
        p.h(list, "feedList");
        AppMethodBeat.i(244941);
        this.position = i2;
        this.tXV = list;
        AppMethodBeat.o(244941);
    }

    private final ArrayList<bo> B(b<? super bo, Boolean> bVar) {
        AppMethodBeat.i(244938);
        ArrayList<bo> arrayList = new ArrayList<>();
        for (T t : this.tXV) {
            if (!bVar.invoke(t).booleanValue()) {
                arrayList.add(t);
            }
        }
        AppMethodBeat.o(244938);
        return arrayList;
    }

    public final i C(b<? super bo, Boolean> bVar) {
        AppMethodBeat.i(244939);
        p.h(bVar, "filterLogic");
        Log.i(this.TAG, "before filterFeed ".concat(String.valueOf(this)));
        y yVar = y.vXH;
        bo n = y.n(this.position, this.tXV);
        ArrayList<bo> B = B(bVar);
        y yVar2 = y.vXH;
        i iVar = new i(y.a(n, B), B);
        Log.i(this.TAG, "after filterFeed ".concat(String.valueOf(iVar)));
        AppMethodBeat.o(244939);
        return iVar;
    }

    public final String toString() {
        AppMethodBeat.i(244940);
        String str = "position:" + this.position + ",feed size:" + this.tXV.size();
        AppMethodBeat.o(244940);
        return str;
    }
}

package com.tencent.mm.plugin.finder.model;

import com.facebook.internal.FacebookRequestErrorClassification;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.plugin.finder.feed.model.internal.i;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.awe;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u000eH\u0016J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0002J\u0006\u0010\u0013\u001a\u00020\rJ\b\u0010\u0014\u001a\u00020\u0015H\u0016J\b\u0010\u0016\u001a\u00020\rH\u0016J\b\u0010\u0017\u001a\u0004\u0018\u00010\u0006J\b\u0010\u0018\u001a\u00020\u0006H\u0016R\u0014\u0010\u0005\u001a\u00020\u0006XD¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0019"}, hxF = {"Lcom/tencent/mm/plugin/finder/model/FinderFeedLiveListItem;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", ch.COL_FINDEROBJECT, "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "(Lcom/tencent/mm/protocal/protobuf/FinderObject;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "obj", "getObj", "()Lcom/tencent/mm/protocal/protobuf/FinderObject;", "compare", "", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "equals", "", FacebookRequestErrorClassification.KEY_OTHER, "", "getFriendLikeCount", "getItemId", "", "getItemType", "getSessionBuffer", "toString", "plugin-finder_release"})
public final class y implements bo {
    private final String TAG = "FinderFeedLiveListItem";
    public final FinderObject uOo;

    public y(FinderObject finderObject) {
        p.h(finderObject, ch.COL_FINDEROBJECT);
        AppMethodBeat.i(248750);
        this.uOo = finderObject;
        AppMethodBeat.o(248750);
    }

    @Override // com.tencent.mm.view.recyclerview.a
    public final long lT() {
        return this.uOo.id;
    }

    @Override // com.tencent.mm.view.recyclerview.a
    public final int cxn() {
        return 2004;
    }

    @Override // com.tencent.mm.plugin.finder.feed.model.internal.i
    public final int a(i iVar) {
        i iVar2;
        AppMethodBeat.i(248748);
        p.h(iVar, "obj");
        if (!(iVar instanceof y)) {
            iVar2 = null;
        } else {
            iVar2 = iVar;
        }
        if (((y) iVar2) == null) {
            AppMethodBeat.o(248748);
            return -1;
        } else if (((y) iVar).uOo.id == this.uOo.id) {
            AppMethodBeat.o(248748);
            return 0;
        } else {
            AppMethodBeat.o(248748);
            return -1;
        }
    }

    public final boolean equals(Object obj) {
        Object obj2;
        if (!(obj instanceof y)) {
            obj2 = null;
        } else {
            obj2 = obj;
        }
        y yVar = (y) obj2;
        if (yVar == null) {
            return false;
        }
        if (yVar.uOo.id == this.uOo.id) {
            return true;
        }
        return false;
    }

    public final String toString() {
        AppMethodBeat.i(248749);
        StringBuilder sb = new StringBuilder("liveItem:");
        StringBuilder append = new StringBuilder("[username:").append(this.uOo.nickname).append(",feedId:").append(this.uOo.id).append(",liveId:");
        awe awe = this.uOo.liveInfo;
        StringBuilder append2 = sb.append(append.append(awe != null ? Long.valueOf(awe.liveId) : null).append(",friendLikeCount:").append(this.uOo.friendLikeCount).append(']').toString());
        p.g(append2, "StringBuilder(\"liveItem:…${obj.friendLikeCount}]\")");
        String sb2 = append2.toString();
        p.g(sb2, "sb.toString()");
        AppMethodBeat.o(248749);
        return sb2;
    }
}

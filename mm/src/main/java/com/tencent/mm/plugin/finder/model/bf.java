package com.tencent.mm.plugin.finder.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.plugin.finder.api.b;
import com.tencent.mm.plugin.finder.api.g;
import com.tencent.mm.plugin.finder.feed.model.internal.i;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.FinderMedia;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.axw;
import java.util.LinkedList;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012J\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014J\b\u0010\u0015\u001a\u00020\u0006H\u0016J\b\u0010\u0016\u001a\u00020\u000eH\u0016J\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018J\u0006\u0010\u0019\u001a\u00020\u000eJ\u0006\u0010\u001a\u001a\u00020\u001bJ\u0006\u0010\u001c\u001a\u00020\u001bJ\u0006\u0010\u001d\u001a\u00020\u001bJ\u0006\u0010\u001e\u001a\u00020\u001bR\u001c\u0010\u0005\u001a\u00020\u00068FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u001f"}, hxF = {"Lcom/tencent/mm/plugin/finder/model/FinderMusicInfoData;", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "musicItem", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "(Lcom/tencent/mm/plugin/finder/storage/FinderItem;)V", ch.COL_LOCALID, "", "getLocalId", "()J", "setLocalId", "(J)V", "getMusicItem", "()Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "compare", "", "obj", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "getFeedObject", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "getImageUrl", "", "getItemId", "getItemType", "getMvInfo", "Lcom/tencent/mm/protocal/protobuf/FinderMVInfo;", "getPostProgress", "isLocal", "", "isPostFailed", "isPostFinish", "isPosting", "plugin-finder_release"})
public final class bf extends BaseFinderFeed {
    public final FinderItem uOO;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public bf(FinderItem finderItem) {
        super(finderItem);
        g gVar = null;
        p.h(finderItem, "musicItem");
        AppMethodBeat.i(248841);
        this.uOO = finderItem;
        FinderContact finderContact = this.uOO.getFeedObject().contact;
        this.contact = finderContact != null ? b.a(finderContact, null) : gVar;
        AppMethodBeat.o(248841);
    }

    @Override // com.tencent.mm.view.recyclerview.a, com.tencent.mm.plugin.finder.model.BaseFinderFeed
    public final long lT() {
        AppMethodBeat.i(248833);
        long id = this.uOO.getId();
        AppMethodBeat.o(248833);
        return id;
    }

    @Override // com.tencent.mm.view.recyclerview.a, com.tencent.mm.plugin.finder.model.BaseFinderFeed
    public final int cxn() {
        AppMethodBeat.i(248834);
        int hashCode = bf.class.getName().hashCode();
        AppMethodBeat.o(248834);
        return hashCode;
    }

    @Override // com.tencent.mm.plugin.finder.feed.model.internal.i, com.tencent.mm.plugin.finder.model.BaseFinderFeed
    public final int a(i iVar) {
        i iVar2;
        AppMethodBeat.i(248835);
        p.h(iVar, "obj");
        if (!(iVar instanceof FinderItem)) {
            iVar2 = null;
        } else {
            iVar2 = iVar;
        }
        FinderItem finderItem = (FinderItem) iVar2;
        if (finderItem == null) {
            AppMethodBeat.o(248835);
            return -1;
        } else if (finderItem.getFeedObject().id != 0 && this.uOO.getFeedObject().id != 0 && finderItem.getFeedObject().id == this.uOO.getFeedObject().id) {
            AppMethodBeat.o(248835);
            return 0;
        } else if (finderItem.getLocalId() > 0 && this.uOO.getLocalId() > 0 && finderItem.getLocalId() == this.uOO.getLocalId()) {
            AppMethodBeat.o(248835);
            return 0;
        } else if (this.uOO.getCreateTime() > finderItem.getCreateTime()) {
            AppMethodBeat.o(248835);
            return 1;
        } else {
            AppMethodBeat.o(248835);
            return -1;
        }
    }

    public final axw dkQ() {
        AppMethodBeat.i(248836);
        FinderObjectDesc finderObjectDesc = this.uOO.getFeedObject().objectDesc;
        if (finderObjectDesc != null) {
            axw axw = finderObjectDesc.mvInfo;
            AppMethodBeat.o(248836);
            return axw;
        }
        AppMethodBeat.o(248836);
        return null;
    }

    public final String dkR() {
        LinkedList<FinderMedia> linkedList;
        FinderMedia finderMedia;
        AppMethodBeat.i(248837);
        FinderObjectDesc finderObjectDesc = this.uOO.getFeedObject().objectDesc;
        if (finderObjectDesc == null || (linkedList = finderObjectDesc.media) == null || (finderMedia = (FinderMedia) j.kt(linkedList)) == null) {
            AppMethodBeat.o(248837);
            return null;
        }
        String str = finderMedia.url;
        AppMethodBeat.o(248837);
        return str;
    }

    public final boolean dkS() {
        AppMethodBeat.i(248838);
        if (this.uOO.getFeedObject().id == 0) {
            AppMethodBeat.o(248838);
            return true;
        }
        AppMethodBeat.o(248838);
        return false;
    }

    public final boolean dkT() {
        AppMethodBeat.i(248839);
        if (this.uOO.isPostFailed() || this.uOO.isPostFinish()) {
            AppMethodBeat.o(248839);
            return false;
        }
        AppMethodBeat.o(248839);
        return true;
    }

    public final int dkU() {
        AppMethodBeat.i(248840);
        int i2 = this.uOO.getPostInfo().Mpc;
        AppMethodBeat.o(248840);
        return i2;
    }
}

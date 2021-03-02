package com.tencent.mm.plugin.finder.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import com.tencent.mm.plugin.finder.feed.model.internal.i;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.awe;
import com.tencent.mm.protocal.protobuf.axi;
import com.tencent.mm.protocal.protobuf.bcu;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 62\u00020\u0001:\u00016B\u0007\b\u0016¢\u0006\u0002\u0010\u0002B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u001e\u0010 \u001a\u00020!2\u0016\u0010\"\u001a\u0012\u0012\u0004\u0012\u00020\u00140\u0013j\b\u0012\u0004\u0012\u00020\u0014`\u0015J\u0010\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&H\u0016J\u000e\u0010'\u001a\u00020$2\u0006\u0010(\u001a\u00020\u001bJ\b\u0010)\u001a\u00020\u001bH\u0016J\b\u0010*\u001a\u00020$H\u0016J\b\u0010+\u001a\u00020\u001bH\u0002J\"\u0010,\u001a\u0016\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0013j\n\u0012\u0004\u0012\u00020\u0014\u0018\u0001`\u00152\u0006\u0010-\u001a\u00020.J$\u0010/\u001a\u0012\u0012\u0004\u0012\u00020\u00140\u0013j\b\u0012\u0004\u0012\u00020\u0014`\u00152\f\u00100\u001a\b\u0012\u0004\u0012\u00020201J\u001e\u00103\u001a\u00020!2\u0016\u0010\"\u001a\u0012\u0012\u0004\u0012\u00020\u00140\u0013j\b\u0012\u0004\u0012\u00020\u0014`\u0015J\b\u00104\u001a\u000205H\u0016R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R*\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\u00140\u0013j\b\u0012\u0004\u0012\u00020\u0014`\u0015X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001a\u001a\u00020\u001bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001f¨\u00067"}, hxF = {"Lcom/tencent/mm/plugin/finder/model/FinderFeedLiveList;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "()V", "finderStreamCard", "Lcom/tencent/mm/protocal/protobuf/FinderStreamCard;", "(Lcom/tencent/mm/protocal/protobuf/FinderStreamCard;)V", "cardBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "getCardBuffer", "()Lcom/tencent/mm/protobuf/ByteString;", "setCardBuffer", "(Lcom/tencent/mm/protobuf/ByteString;)V", "continueAtTheEnd", "", "getContinueAtTheEnd", "()Z", "setContinueAtTheEnd", "(Z)V", "list", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/model/FinderFeedLiveListItem;", "Lkotlin/collections/ArrayList;", "getList", "()Ljava/util/ArrayList;", "setList", "(Ljava/util/ArrayList;)V", "listId", "", "getListId", "()J", "setListId", "(J)V", "addAllList", "", "newList", "compare", "", "obj", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "getIndex", "liveId", "getItemId", "getItemType", "initListId", "merge", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderLiveStreamResponse;", "parseLiveList", "userInfoList", "", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "replaceList", "toString", "", "Companion", "plugin-finder_release"})
public final class x implements bo {
    private static final String TAG = TAG;
    public static final a uOn = new a((byte) 0);
    public ArrayList<y> dtS;
    public b tVe;
    public long uOl;
    public boolean uOm;

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/finder/model/FinderFeedLiveList$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(248747);
        AppMethodBeat.o(248747);
    }

    public x() {
        AppMethodBeat.i(248745);
        this.tVe = null;
        this.dtS = new ArrayList<>();
        this.uOl = dkB();
        AppMethodBeat.o(248745);
    }

    public x(bcu bcu) {
        p.h(bcu, "finderStreamCard");
        AppMethodBeat.i(248746);
        LinkedList<FinderObject> linkedList = bcu.object;
        p.g(linkedList, "finderStreamCard.`object`");
        this.dtS = ei(linkedList);
        this.tVe = bcu.tVe;
        this.uOl = dkB();
        this.uOm = bcu.uOm;
        AppMethodBeat.o(248746);
    }

    public final long dkB() {
        AppMethodBeat.i(248739);
        long j2 = Util.MAX_32BIT_VALUE;
        Iterator<T> it = this.dtS.iterator();
        while (it.hasNext()) {
            j2 = it.next().uOo.id & j2;
        }
        Log.i(TAG, "listId:".concat(String.valueOf(j2)));
        AppMethodBeat.o(248739);
        return j2;
    }

    @Override // com.tencent.mm.view.recyclerview.a
    public final long lT() {
        return this.uOl;
    }

    @Override // com.tencent.mm.view.recyclerview.a
    public final int cxn() {
        return 2003;
    }

    @Override // com.tencent.mm.plugin.finder.feed.model.internal.i
    public final int a(i iVar) {
        i iVar2;
        AppMethodBeat.i(248740);
        p.h(iVar, "obj");
        if (!(iVar instanceof x)) {
            iVar2 = null;
        } else {
            iVar2 = iVar;
        }
        if (((x) iVar2) != null) {
            AppMethodBeat.o(248740);
            return 0;
        }
        AppMethodBeat.o(248740);
        return -1;
    }

    private static ArrayList<y> ei(List<? extends FinderObject> list) {
        AppMethodBeat.i(248741);
        p.h(list, "userInfoList");
        List<? extends FinderObject> list2 = list;
        ArrayList arrayList = new ArrayList(j.a(list2, 10));
        Iterator<T> it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(new y(it.next()));
        }
        ArrayList<y> arrayList2 = new ArrayList<>(arrayList);
        AppMethodBeat.o(248741);
        return arrayList2;
    }

    public final ArrayList<y> a(axi axi) {
        AppMethodBeat.i(248742);
        p.h(axi, "resp");
        LinkedList<FinderObject> linkedList = axi.object;
        Log.i(TAG, "merge remote list size:" + linkedList.size());
        this.tVe = axi.lastBuffer;
        this.uOm = axi.continueFlag > 0;
        LinkedList linkedList2 = new LinkedList();
        p.g(linkedList, "remote");
        for (T t : linkedList) {
            int i2 = 0;
            Iterator<y> it = this.dtS.iterator();
            while (true) {
                if (!it.hasNext()) {
                    i2 = -1;
                    break;
                }
                if (it.next().uOo.id == t.id) {
                    break;
                }
                i2++;
            }
            int i3 = 0;
            Iterator it2 = linkedList2.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    i3 = -1;
                    break;
                }
                if (((FinderObject) it2.next()).id == t.id) {
                    break;
                }
                i3++;
            }
            if (i2 == -1 && i3 == -1) {
                linkedList2.add(t);
            } else {
                Log.i(TAG, "merge live list feed:" + t.id + ',' + t.nickname + " exist!");
            }
        }
        if (linkedList2.size() > 0) {
            ArrayList<y> ei = ei(linkedList2);
            p.h(ei, "newList");
            this.dtS.addAll(ei);
            dkB();
            AppMethodBeat.o(248742);
            return ei;
        }
        AppMethodBeat.o(248742);
        return null;
    }

    public final int getIndex(long j2) {
        awe awe;
        AppMethodBeat.i(248743);
        int i2 = 0;
        for (y yVar : this.dtS) {
            FinderObject finderObject = yVar.uOo;
            if (finderObject != null && (awe = finderObject.liveInfo) != null && awe.liveId == j2) {
                AppMethodBeat.o(248743);
                return i2;
            }
            i2++;
        }
        AppMethodBeat.o(248743);
        return -1;
    }

    public final String toString() {
        Long l;
        AppMethodBeat.i(248744);
        int size = this.dtS.size();
        StringBuilder sb = new StringBuilder("liveListId,size:" + size + ':');
        for (int i2 = 0; i2 < size; i2++) {
            StringBuilder append = new StringBuilder("[username:").append(this.dtS.get(i2).uOo.nickname).append(",feedId:").append(this.dtS.get(i2).uOo.id).append(",liveId:");
            awe awe = this.dtS.get(i2).uOo.liveInfo;
            if (awe != null) {
                l = Long.valueOf(awe.liveId);
            } else {
                l = null;
            }
            sb.append(append.append(l).append("，friendLikeCount:").append(this.dtS.get(i2).uOo.friendLikeCount).append(']').toString());
        }
        String sb2 = sb.toString();
        p.g(sb2, "sb.toString()");
        AppMethodBeat.o(248744);
        return sb2;
    }
}

package com.tencent.mm.plugin.finder.cgi.interceptor;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.cgi.aa;
import com.tencent.mm.plugin.finder.feed.model.b;
import com.tencent.mm.plugin.finder.storage.c;
import com.tencent.mm.protocal.protobuf.FinderCommentInfo;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 %2\u00020\u0001:\u0001%B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cJ\u000e\u0010\u001d\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cJ\u0018\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010 \u001a\u00020\u0004H\u0016J\u0018\u0010!\u001a\u00020\u001f2\u0006\u0010\"\u001a\u00020#2\u0006\u0010 \u001a\u00020\u0004H\u0016J\u0018\u0010$\u001a\u00020\u001f2\u0006\u0010\"\u001a\u00020#2\u0006\u0010 \u001a\u00020\u0004H\u0016R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\"\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u0006&"}, hxF = {"Lcom/tencent/mm/plugin/finder/cgi/interceptor/AdjustOrderAvatarInterceptor;", "Lcom/tencent/mm/plugin/finder/cgi/interceptor/IFinderStreamInterceptor;", "()V", "MAX_RED_DOT_USER_NUM", "", "getMAX_RED_DOT_USER_NUM", "()I", "redDotFeedId", "", "getRedDotFeedId", "()J", "setRedDotFeedId", "(J)V", "redDotUserNameList", "", "", "getRedDotUserNameList", "()Ljava/util/List;", "setRedDotUserNameList", "(Ljava/util/List;)V", "redDotUsername", "getRedDotUsername", "()Ljava/lang/String;", "setRedDotUsername", "(Ljava/lang/String;)V", "modify", "", "resp", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderStream$FinderStreamResponseEx;", "modifyLikeList", "onIntercept", "", "tabType", "onInterceptAfterStore", "loadedInfo", "Lcom/tencent/mm/plugin/finder/feed/model/CgiFinderStreamResult;", "onInterceptBeforeStore", "Companion", "plugin-finder_release"})
public final class a implements f {
    public static final C1094a txA = new C1094a((byte) 0);
    private long txx;
    private String txy = "";
    private final int txz = 3;

    static {
        AppMethodBeat.i(242613);
        AppMethodBeat.o(242613);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/finder/cgi/interceptor/AdjustOrderAvatarInterceptor$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
    /* renamed from: com.tencent.mm.plugin.finder.cgi.interceptor.a$a  reason: collision with other inner class name */
    public static final class C1094a {
        private C1094a() {
        }

        public /* synthetic */ C1094a(byte b2) {
            this();
        }
    }

    @Override // com.tencent.mm.plugin.finder.cgi.interceptor.f
    public final boolean a(aa.f fVar) {
        FinderObject finderObject;
        int i2;
        Object obj;
        boolean z;
        AppMethodBeat.i(242610);
        p.h(fVar, "resp");
        c cVar = c.vCb;
        if (c.duv().value().intValue() == 1) {
            p.h(fVar, "resp");
            this.txx = fVar.cXX().LMx;
            String str = fVar.cXX().LMC;
            if (str == null) {
                str = "";
            }
            this.txy = str;
            if (this.txx != 0 && !Util.isNullOrNil(this.txy)) {
                LinkedList linkedList = fVar.object;
                if (linkedList != null) {
                    Iterator it = linkedList.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            obj = null;
                            break;
                        }
                        Object next = it.next();
                        if (((FinderObject) next).id == this.txx) {
                            z = true;
                            continue;
                        } else {
                            z = false;
                            continue;
                        }
                        if (z) {
                            obj = next;
                            break;
                        }
                    }
                    finderObject = (FinderObject) obj;
                } else {
                    finderObject = null;
                }
                if (finderObject != null) {
                    LinkedList<FinderCommentInfo> linkedList2 = finderObject.likeList;
                    p.g(linkedList2, "likeList");
                    Iterator<FinderCommentInfo> it2 = linkedList2.iterator();
                    int i3 = 0;
                    while (true) {
                        if (!it2.hasNext()) {
                            i2 = -1;
                            break;
                        } else if (p.j(it2.next().username, z.aTY())) {
                            i2 = i3;
                            break;
                        } else {
                            i3++;
                        }
                    }
                    if (i2 > 1) {
                        finderObject.likeList.add(1, finderObject.likeList.remove(i2));
                    }
                    LinkedList<FinderCommentInfo> linkedList3 = finderObject.likeList;
                    p.g(linkedList3, "likeList");
                    Iterator<FinderCommentInfo> it3 = linkedList3.iterator();
                    int i4 = 0;
                    while (true) {
                        if (!it3.hasNext()) {
                            i4 = -1;
                            break;
                        } else if (p.j(it3.next().username, this.txy)) {
                            break;
                        } else {
                            i4++;
                        }
                    }
                    if (i4 > 0) {
                        finderObject.likeList.add(0, finderObject.likeList.remove(i4));
                    }
                    StringBuilder append = new StringBuilder("meExistIndex=").append(i2).append(" friendExistIndex=").append(i4).append(" redDotUsername=").append(this.txy).append(" self=").append(z.aTY()).append("likeList=");
                    LinkedList<FinderCommentInfo> linkedList4 = finderObject.likeList;
                    p.g(linkedList4, "likeList");
                    LinkedList<FinderCommentInfo> linkedList5 = linkedList4;
                    ArrayList arrayList = new ArrayList(j.a(linkedList5, 10));
                    Iterator<T> it4 = linkedList5.iterator();
                    while (it4.hasNext()) {
                        arrayList.add(it4.next().username);
                    }
                    Log.i("Finder.AdjustOrderAvatarInterceptor", append.append(arrayList).toString());
                }
            }
        }
        AppMethodBeat.o(242610);
        return false;
    }

    @Override // com.tencent.mm.plugin.finder.cgi.interceptor.f
    public final boolean a(b bVar) {
        AppMethodBeat.i(242611);
        p.h(bVar, "loadedInfo");
        AppMethodBeat.o(242611);
        return false;
    }

    @Override // com.tencent.mm.plugin.finder.cgi.interceptor.f
    public final boolean b(b bVar, int i2) {
        AppMethodBeat.i(242612);
        p.h(bVar, "loadedInfo");
        AppMethodBeat.o(242612);
        return false;
    }
}

package com.tencent.mm.plugin.story.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.story.api.n;
import com.tencent.mm.plugin.story.f.d.a;
import com.tencent.mm.plugin.story.f.d.c;
import com.tencent.mm.plugin.story.f.d.f;
import com.tencent.mm.plugin.story.f.j;
import com.tencent.mm.plugin.story.h.h;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J*\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0014\u0010\t\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006R\u0014\u0010\u000b\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0006¨\u0006\u0016"}, hxF = {"Lcom/tencent/mm/plugin/story/presenter/GalleryPresenterFactory;", "", "()V", "QUERY_CONDITION_ALL_UNREAD", "", "getQUERY_CONDITION_ALL_UNREAD", "()I", "QUERY_CONDITION_BIG_MOUTH", "getQUERY_CONDITION_BIG_MOUTH", "QUERY_CONDITION_DEFAULT", "getQUERY_CONDITION_DEFAULT", "QUERY_CONDITION_WITH_FILTER", "getQUERY_CONDITION_WITH_FILTER", "getPresenter", "Lcom/tencent/mm/plugin/story/presenter/IGalleryPresenter;", "dataSeed", "groupCallback", "Lcom/tencent/mm/plugin/story/presenter/GalleryGroupUpdateCallback;", "galleryType", "Lcom/tencent/mm/plugin/story/api/IStoryUIFactory$GalleryType;", "chatRoom", "", "plugin-story_release"})
public final class d {
    private static final int FrC = 0;
    private static final int FrD = 1;
    private static final int FrE = 2;
    private static final int FrF = 4;
    public static final d FrG = new d();

    static {
        AppMethodBeat.i(119194);
        AppMethodBeat.o(119194);
    }

    private d() {
    }

    public static int fpB() {
        return FrC;
    }

    public static int fpC() {
        return FrD;
    }

    public static int fpD() {
        return FrE;
    }

    public static int fpE() {
        return FrF;
    }

    public static f a(Object obj, c cVar, n.a aVar, String str) {
        Map<String, ArrayList<Long>> hashMap;
        AppMethodBeat.i(119193);
        p.h(cVar, "groupCallback");
        p.h(aVar, "galleryType");
        if (obj instanceof com.tencent.mm.plugin.story.api.p) {
            List<String> a2 = f.a((com.tencent.mm.plugin.story.api.p) obj);
            com.tencent.mm.plugin.story.api.p pVar = (com.tencent.mm.plugin.story.api.p) obj;
            p.h(pVar, "dataSeed");
            if (pVar instanceof a) {
                hashMap = ((a) pVar).FoI;
            } else if (pVar instanceof c) {
                hashMap = ((c) pVar).FoI;
            } else {
                hashMap = new HashMap();
            }
            int i2 = ((com.tencent.mm.plugin.story.api.p) obj).FkI;
            h hVar = h.FuH;
            h.fqi().sw((long) a2.size());
            if (obj instanceof c) {
                if (((c) obj).Dff) {
                    i iVar = new i(((c) obj).username, a2, cVar, hashMap, i2);
                    AppMethodBeat.o(119193);
                    return iVar;
                }
                b bVar = new b(((c) obj).username, a2, cVar);
                AppMethodBeat.o(119193);
                return bVar;
            } else if (obj instanceof com.tencent.mm.plugin.story.f.d.d) {
                g gVar = new g(a2, null, cVar, hashMap, i2);
                AppMethodBeat.o(119193);
                return gVar;
            } else {
                g gVar2 = new g(a2, null, cVar, hashMap, i2);
                AppMethodBeat.o(119193);
                return gVar2;
            }
        } else {
            if (j.listOf((Object[]) new n.a[]{n.a.SelfGallery, n.a.SelfTabGallery}).contains(aVar)) {
                if (obj instanceof String) {
                    h hVar2 = h.FuH;
                    h.fqi().sw(1);
                    h hVar3 = new h((String) obj, cVar, (byte) 0);
                    AppMethodBeat.o(119193);
                    return hVar3;
                }
            } else if (aVar == n.a.SingleGallery || aVar == n.a.ProfileGallery) {
                if (obj instanceof String) {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(obj);
                    h hVar4 = h.FuH;
                    h.fqi().sw((long) arrayList.size());
                    g gVar3 = new g(arrayList, str, cVar);
                    AppMethodBeat.o(119193);
                    return gVar3;
                }
            } else if (aVar == n.a.MultiUserGallery) {
                ArrayList arrayList2 = new ArrayList();
                if (obj instanceof Collection) {
                    for (Object obj2 : (Iterable) obj) {
                        if (obj2 instanceof String) {
                            arrayList2.add(obj2);
                        }
                    }
                    h hVar5 = h.FuH;
                    h.fqi().sw((long) arrayList2.size());
                    g gVar4 = new g(arrayList2, str, cVar);
                    AppMethodBeat.o(119193);
                    return gVar4;
                }
            } else if (aVar == n.a.HistoryGallery) {
                ArrayList arrayList3 = new ArrayList();
                if (obj instanceof Collection) {
                    for (Object obj3 : (Iterable) obj) {
                        if (obj3 instanceof String) {
                            arrayList3.add(obj3);
                        }
                    }
                    j.b bVar2 = com.tencent.mm.plugin.story.f.j.Fmy;
                    i iVar2 = new i(j.b.fau(), arrayList3, cVar);
                    AppMethodBeat.o(119193);
                    return iVar2;
                }
            }
            RuntimeException runtimeException = new RuntimeException("Cannot handler dataSeed ".concat(String.valueOf(obj)));
            AppMethodBeat.o(119193);
            throw runtimeException;
        }
    }
}

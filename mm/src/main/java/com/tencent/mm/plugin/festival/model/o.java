package com.tencent.mm.plugin.festival.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.festival.b.c;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00070\fJ\u0016\u0010\u0010\u001a\u00020\r2\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\fJ1\u0010\u0012\u001a\u00020\r2'\u0010\u0013\u001a#\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00070\f¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\r0\u000bH\u0016J1\u0010\u0017\u001a\u00020\r2'\u0010\u0013\u001a#\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00070\f¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\r0\u000bH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u001e\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\bX\u0004¢\u0006\u0002\n\u0000RB\u0010\t\u001a6\u0012\u0016\u0012\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\f\u0012\u0004\u0012\u00020\r0\u000b0\nj\u001a\u0012\u0016\u0012\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\f\u0012\u0004\u0012\u00020\r0\u000b`\u000eX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, hxF = {"Lcom/tencent/mm/plugin/festival/model/FestivalLiveRecommendWishProvider;", "Lcom/tencent/mm/plugin/festival/model/FestivalLiveRecommendWishProviderContract;", "()V", "IO_SERIAL_TAG", "", "cacheList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/festival/proto/FestivalWish;", "Lkotlin/collections/ArrayList;", "subscribeCallbacks", "Ljava/util/HashSet;", "Lkotlin/Function1;", "", "", "Lkotlin/collections/HashSet;", "getCacheRecommendWishList", "notifyNewRecommendWishList", "list", "subscribeNewRecommendWishList", "block", "Lkotlin/ParameterName;", "name", "recommendWishList", "unsubscribeNewRecommendWishList", "plugin-festival_release"})
public final class o {
    private static final HashSet<b<List<? extends c>, x>> Uyv = new HashSet<>();
    public static final o Uyw = new o();
    private static final ArrayList<c> uwf = new ArrayList<>();

    static {
        AppMethodBeat.i(263013);
        AppMethodBeat.o(263013);
    }

    private o() {
    }

    public static void kT(List<? extends c> list) {
        HashSet<b> hashSet;
        AppMethodBeat.i(263010);
        List<? extends c> list2 = list;
        if (list2 == null || list2.isEmpty()) {
            AppMethodBeat.o(263010);
            return;
        }
        uwf.clear();
        uwf.addAll(list);
        synchronized (Uyv) {
            try {
                hashSet = new HashSet(Uyv);
            } finally {
                AppMethodBeat.o(263010);
            }
        }
        for (b bVar : hashSet) {
            bVar.invoke(list);
        }
    }

    public static List<c> hcg() {
        return uwf;
    }

    public static void aa(b<? super List<? extends c>, x> bVar) {
        AppMethodBeat.i(263011);
        p.h(bVar, "block");
        synchronized (Uyv) {
            try {
                Uyv.add(bVar);
            } finally {
                AppMethodBeat.o(263011);
            }
        }
    }

    public static void ab(b<? super List<? extends c>, x> bVar) {
        AppMethodBeat.i(263012);
        p.h(bVar, "block");
        synchronized (Uyv) {
            try {
                Uyv.remove(bVar);
            } finally {
                AppMethodBeat.o(263012);
            }
        }
    }
}

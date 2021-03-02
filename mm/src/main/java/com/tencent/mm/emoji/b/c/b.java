package com.tencent.mm.emoji.b.c;

import com.google.android.gms.common.internal.ImagesContract;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.b.c.j;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0010!\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u0017\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J$\u0010\u0011\u001a\u00020\u00122\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u00132\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\f0\u0015H\u0002J\u001a\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\u0018\u0010\u0019\u001a\u00020\u00122\b\u0010\u001a\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u001b\u001a\u00020\u0010R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, hxF = {"Lcom/tencent/mm/emoji/model/search/EmojiSuggest;", "Lcom/tencent/mm/emoji/model/search/AbsEmojiSuggest;", "lifeCycleKeeper", "Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycle;", "(Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;)V", ImagesContract.LOCAL, "Lcom/tencent/mm/emoji/model/search/EmojiSuggestLocal;", "remote", "Lcom/tencent/mm/emoji/model/search/EmojiSuggestRemote;", "resultList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/emoji/model/search/SuggestEmojiItem;", "checkMatch", "", "desc", "", "distinctResult", "", "", "newList", "", "searchSuggest", "callback", "Lcom/tencent/mm/emoji/model/search/IEmojiSuggest$SuggestCallback;", "setRequestInfo", "chatId", "sessionId", "Companion", "plugin-emojisdk_release"})
public final class b extends a {
    public static final a gZq = new a((byte) 0);
    private final e gZn;
    public final f gZo;
    private final LinkedList<l> gZp;

    static {
        AppMethodBeat.i(199934);
        AppMethodBeat.o(199934);
    }

    private /* synthetic */ b() {
        this(null);
    }

    public b(com.tencent.mm.vending.e.b<com.tencent.mm.vending.e.a> bVar) {
        super(bVar);
        AppMethodBeat.i(199933);
        this.gZn = new e();
        this.gZo = new f(bVar);
        this.gZp = new LinkedList<>();
        AppMethodBeat.o(199933);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    /* renamed from: com.tencent.mm.emoji.b.c.b$b  reason: collision with other inner class name */
    public static final class C0321b extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ b gZr;
        final /* synthetic */ String gZs;
        final /* synthetic */ j.b gZt;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public C0321b(b bVar, String str, j.b bVar2) {
            super(0);
            this.gZr = bVar;
            this.gZs = str;
            this.gZt = bVar2;
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001e\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, hxF = {"com/tencent/mm/emoji/model/search/EmojiSuggest$searchSuggest$1$remoteCallback$1", "Lcom/tencent/mm/emoji/model/search/IEmojiSuggest$SuggestCallback;", "onResult", "", "emojiList", "", "Lcom/tencent/mm/emoji/model/search/SuggestEmojiItem;", "wordInfo", "Lcom/tencent/mm/emoji/model/search/SuggestWordInfo;", "plugin-emojisdk_release"})
        /* renamed from: com.tencent.mm.emoji.b.c.b$b$b  reason: collision with other inner class name */
        public static final class C0322b implements j.b {
            final /* synthetic */ C0321b gZu;
            final /* synthetic */ LinkedList gZv;
            final /* synthetic */ boolean gZx;

            C0322b(C0321b bVar, boolean z, LinkedList linkedList) {
                this.gZu = bVar;
                this.gZx = z;
                this.gZv = linkedList;
            }

            @Override // com.tencent.mm.emoji.b.c.j.b
            public final void a(List<l> list, m mVar) {
                Object obj;
                Object obj2;
                AppMethodBeat.i(199931);
                p.h(list, "emojiList");
                p.h(mVar, "wordInfo");
                Log.i(k.TAG, "onResult: remote " + list.size());
                if (!this.gZu.gZr.dbi) {
                    AppMethodBeat.o(199931);
                    return;
                }
                if (this.gZx) {
                    LinkedList linkedList = new LinkedList(list);
                    linkedList.addAll(this.gZv);
                    Iterator it = linkedList.iterator();
                    if (!it.hasNext()) {
                        obj2 = null;
                    } else {
                        Object next = it.next();
                        if (!it.hasNext()) {
                            obj2 = next;
                        } else {
                            long j2 = ((l) next).gWm.field_lastUseTime;
                            while (true) {
                                next = it.next();
                                long j3 = ((l) next).gWm.field_lastUseTime;
                                if (j2 < j3) {
                                    j2 = j3;
                                } else {
                                    next = next;
                                }
                                if (!it.hasNext()) {
                                    break;
                                }
                            }
                            obj2 = next;
                        }
                    }
                    l lVar = (l) obj2;
                    if (lVar != null) {
                        lVar.gZO = 1;
                        this.gZu.gZr.gZp.add(lVar);
                    }
                    b.d(this.gZu.gZr.gZp, list);
                    b.d(this.gZu.gZr.gZp, this.gZv);
                } else {
                    Iterator it2 = this.gZv.iterator();
                    if (!it2.hasNext()) {
                        obj = null;
                    } else {
                        Object next2 = it2.next();
                        if (!it2.hasNext()) {
                            obj = next2;
                        } else {
                            long j4 = ((l) next2).gWm.field_lastUseTime;
                            while (true) {
                                next2 = it2.next();
                                long j5 = ((l) next2).gWm.field_lastUseTime;
                                if (j4 < j5) {
                                    j4 = j5;
                                } else {
                                    next2 = next2;
                                }
                                if (!it2.hasNext()) {
                                    break;
                                }
                            }
                            obj = next2;
                        }
                    }
                    l lVar2 = (l) obj;
                    if (lVar2 != null) {
                        lVar2.gZO = 1;
                        this.gZu.gZr.gZp.add(lVar2);
                    }
                    b.d(this.gZu.gZr.gZp, this.gZv);
                    b.d(this.gZu.gZr.gZp, list);
                }
                j.b bVar = this.gZu.gZt;
                if (bVar != null) {
                    bVar.a(this.gZu.gZr.gZp, mVar);
                }
                d dVar = d.gZA;
                d.ac(this.gZu.gZr.gZp);
                AppMethodBeat.o(199931);
            }
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001e\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, hxF = {"com/tencent/mm/emoji/model/search/EmojiSuggest$searchSuggest$1$localCallback$1", "Lcom/tencent/mm/emoji/model/search/IEmojiSuggest$SuggestCallback;", "onResult", "", "emojiList", "", "Lcom/tencent/mm/emoji/model/search/SuggestEmojiItem;", "wordInfo", "Lcom/tencent/mm/emoji/model/search/SuggestWordInfo;", "plugin-emojisdk_release"})
        /* renamed from: com.tencent.mm.emoji.b.c.b$b$a */
        public static final class a implements j.b {
            final /* synthetic */ C0321b gZu;
            final /* synthetic */ LinkedList gZv;
            final /* synthetic */ C0322b gZw;

            a(C0321b bVar, LinkedList linkedList, C0322b bVar2) {
                this.gZu = bVar;
                this.gZv = linkedList;
                this.gZw = bVar2;
            }

            @Override // com.tencent.mm.emoji.b.c.j.b
            public final void a(List<l> list, m mVar) {
                AppMethodBeat.i(199930);
                p.h(list, "emojiList");
                p.h(mVar, "wordInfo");
                Log.i(k.TAG, "onResult: local " + list.size());
                if (!this.gZu.gZr.dbi) {
                    AppMethodBeat.o(199930);
                    return;
                }
                this.gZv.addAll(list);
                this.gZu.gZr.gZo.a(this.gZu.gZs, this.gZw);
                AppMethodBeat.o(199930);
            }
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(199932);
            boolean a2 = ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_emoji_suggest_remote_shuffle, false);
            e unused = this.gZr.gZn;
            boolean ET = e.ET(this.gZs);
            f unused2 = this.gZr.gZo;
            boolean ET2 = f.ET(this.gZs);
            LinkedList linkedList = new LinkedList();
            Log.i(k.TAG, "searchSuggest: localMatch " + ET + ", remoteMatch " + ET2 + ", remoteShuffle " + a2);
            this.gZr.gZo.gZB = a2;
            d dVar = d.gZA;
            if (ET) {
                d.pl(21);
            }
            if (ET2) {
                d.pl(22);
            }
            d dVar2 = d.gZA;
            if (a2) {
                d.pl(30);
            }
            C0322b bVar = new C0322b(this, a2, linkedList);
            a aVar = new a(this, linkedList, bVar);
            if (ET) {
                this.gZr.gZn.a(this.gZs, aVar);
            } else if (ET2) {
                this.gZr.gZo.a(this.gZs, bVar);
            }
            x xVar = x.SXb;
            AppMethodBeat.o(199932);
            return xVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/emoji/model/search/EmojiSuggest$Companion;", "", "()V", "MaxResultSize", "", "RemoteValidTime", "", "plugin-emojisdk_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0061  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0070 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final /* synthetic */ void d(java.util.List r8, java.util.List r9) {
        /*
        // Method dump skipped, instructions count: 122
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.emoji.b.c.b.d(java.util.List, java.util.List):void");
    }
}

package com.tencent.mm.emoji.b.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b.a;
import com.tencent.mm.plugin.emoji.b.d;
import com.tencent.mm.protocal.protobuf.bmw;
import com.tencent.mm.protocal.protobuf.dbh;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.bj;
import com.tencent.mm.vfs.s;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00050\u0013J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\b\u0010\u0018\u001a\u00020\u0015H\u0002J\u0006\u0010\u0019\u001a\u00020\u0015J\u000e\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0005R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u001d"}, hxF = {"Lcom/tencent/mm/emoji/model/search/EmojiSuggestWords;", "", "()V", "wordList", "Ljava/util/LinkedList;", "", "wordType", "", "getWordType", "()I", "setWordType", "(I)V", "wordVersion", "", "getWordVersion", "()J", "setWordVersion", "(J)V", "getWordList", "", "initPersonalWords", "", "rsp", "Lcom/tencent/mm/protocal/protobuf/GetEmotionWordListResponse;", "initResourceWords", "initWordList", "matchWord", "", "content", "plugin-emojisdk_release"})
public final class g {
    private static int gZE = 3;
    private static long gZF;
    private static final LinkedList<String> gZG = new LinkedList<>();
    public static final g gZH = new g();

    static {
        AppMethodBeat.i(199950);
        avL();
        AppMethodBeat.o(199950);
    }

    private g() {
    }

    public static int avJ() {
        return gZE;
    }

    public static long avK() {
        return gZF;
    }

    public static void avL() {
        AppMethodBeat.i(199948);
        synchronized (gZG) {
            try {
                Log.i(h.auD(), "initWordList: start");
                bj gCJ = bj.gCJ();
                p.g(gCJ, "EmojiStorageMgr.getInstance()");
                byte[] bArr = gCJ.gCM().get("cache_type_words_list");
                bmw bmw = new bmw();
                try {
                    bmw.parseFrom(bArr);
                } catch (Exception e2) {
                    Log.printDebugStack("safeParser", "", e2);
                    bmw = null;
                }
                bmw bmw2 = bmw;
                if (bmw2 != null) {
                    d dVar = d.gZA;
                    d.pl(31);
                    gZG.clear();
                    LinkedList<String> linkedList = gZG;
                    LinkedList<dbh> linkedList2 = bmw2.LVv;
                    p.g(linkedList2, "rsp.PersonalWords");
                    LinkedList<dbh> linkedList3 = linkedList2;
                    ArrayList arrayList = new ArrayList(j.a(linkedList3, 10));
                    Iterator<T> it = linkedList3.iterator();
                    while (it.hasNext()) {
                        arrayList.add(it.next().MGp);
                    }
                    linkedList.addAll(arrayList);
                    gZE = bmw2.LVw;
                    gZF = bmw2.LVx;
                } else {
                    gZG.clear();
                    StringBuilder sb = new StringBuilder();
                    a ah = com.tencent.mm.kernel.g.ah(d.class);
                    p.g(ah, "MMKernel.plugin(IPluginEmoji::class.java)");
                    com.tencent.mm.pluginsdk.a.d emojiMgr = ((d) ah).getEmojiMgr();
                    p.g(emojiMgr, "MMKernel.plugin(IPluginEmoji::class.java).emojiMgr");
                    String sb2 = sb.append(emojiMgr.getDataEmojiPath()).append("/suggest_word/word2emoji.txt").toString();
                    if (s.YS(sb2)) {
                        String boY = s.boY(sb2);
                        LinkedList<String> linkedList4 = gZG;
                        p.g(boY, "content");
                        linkedList4.addAll(n.b(boY, new String[]{"\n"}));
                    }
                    gZE = 3;
                    gZF = 0;
                }
                Log.i(h.auD(), "initWordList: personal:" + (bmw2 != null) + ", size:" + gZG.size() + ", type:" + gZE + ", version:" + gZF);
                x xVar = x.SXb;
            } finally {
                AppMethodBeat.o(199948);
            }
        }
    }

    public static boolean EV(String str) {
        T t;
        AppMethodBeat.i(199949);
        p.h(str, "content");
        synchronized (gZG) {
            try {
                Iterator<T> it = gZG.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        t = null;
                        break;
                    }
                    T next = it.next();
                    if (n.I(next, str, true)) {
                        t = next;
                        break;
                    }
                }
                T t2 = t;
                if (t2 != null) {
                    Log.i(h.auD(), "matchWord: ".concat(String.valueOf(t2)));
                    return true;
                }
                AppMethodBeat.o(199949);
                return false;
            } finally {
                AppMethodBeat.o(199949);
            }
        }
    }

    public static List<String> avM() {
        LinkedList<String> linkedList;
        synchronized (gZG) {
            linkedList = gZG;
        }
        return linkedList;
    }
}

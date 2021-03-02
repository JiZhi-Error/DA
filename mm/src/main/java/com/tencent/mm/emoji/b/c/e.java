package com.tencent.mm.emoji.b.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.b.c.j;
import com.tencent.mm.kernel.b.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emoji.PluginEmoji;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.bf;
import com.tencent.mm.storage.emotion.EmojiInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0004H\u0016J\u001e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\tH\u0002J\u001a\u0010\f\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\u0010"}, hxF = {"Lcom/tencent/mm/emoji/model/search/EmojiSuggestLocal;", "Lcom/tencent/mm/emoji/model/search/IEmojiSuggest;", "()V", "TAG", "", "checkMatch", "", "desc", "getEmojiList", "", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "md5List", "searchSuggest", "", "callback", "Lcom/tencent/mm/emoji/model/search/IEmojiSuggest$SuggestCallback;", "plugin-emojisdk_release"})
public final class e implements j {
    private final String TAG = "MicroMsg.EmojiSuggestLocal";

    public static boolean ET(String str) {
        AppMethodBeat.i(199941);
        p.h(str, "desc");
        boolean EV = bf.gCF().EV(str);
        AppMethodBeat.o(199941);
        return EV;
    }

    public final void a(String str, j.b bVar) {
        AppMethodBeat.i(199942);
        p.h(str, "desc");
        a ah = g.ah(PluginEmoji.class);
        p.g(ah, "MMKernel.plugin(PluginEmoji::class.java)");
        List t = kotlin.a.j.t((Iterable) ((PluginEmoji) ah).getEmojiMgr().amr(str));
        LinkedList linkedList = new LinkedList();
        List list = t;
        if (!(list == null || list.isEmpty())) {
            if (t.size() > 100) {
                d dVar = d.gZA;
                d.pl(24);
            }
            int size = t.size();
            int i2 = 0;
            while (i2 < size && i2 < 100) {
                a ah2 = g.ah(PluginEmoji.class);
                p.g(ah2, "MMKernel.plugin(PluginEmoji::class.java)");
                EmojiInfo aml = ((PluginEmoji) ah2).getEmojiMgr().aml((String) t.get(i2));
                if (aml != null) {
                    linkedList.add(aml);
                }
                i2++;
            }
            if (linkedList.isEmpty()) {
                Log.i(this.TAG, "sorEmojiList return. empty list.");
            } else {
                Iterator it = linkedList.iterator();
                while (it.hasNext()) {
                    Log.i(this.TAG, "getEmojiList: match " + ((EmojiInfo) it.next()).getMd5());
                }
            }
        }
        LinkedList linkedList2 = linkedList;
        ArrayList arrayList = new ArrayList(kotlin.a.j.a(linkedList2, 10));
        int i3 = 0;
        for (Object obj : linkedList2) {
            int i4 = i3 + 1;
            if (i3 < 0) {
                kotlin.a.j.hxH();
            }
            arrayList.add(new l((EmojiInfo) obj, 0, i3 + 1));
            i3 = i4;
        }
        bVar.a(arrayList, new m(0, 0, 0, null, 15));
        AppMethodBeat.o(199942);
    }
}

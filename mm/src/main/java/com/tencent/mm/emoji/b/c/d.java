package com.tencent.mm.emoji.b.c;

import com.google.android.gms.common.internal.ImagesContract;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import java.util.ArrayList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0005\u001a\u00020\u0006J\u0006\u0010\u0007\u001a\u00020\u0006J\u0006\u0010\b\u001a\u00020\u0006J\u0006\u0010\t\u001a\u00020\u0006J\u000e\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\fJ\u0006\u0010\r\u001a\u00020\u0006J\u0010\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0016\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\fJ\u0014\u0010\u0014\u001a\u00020\u00062\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016J\u0006\u0010\u0018\u001a\u00020\u0006J\u0006\u0010\u0019\u001a\u00020\u0006J\u0006\u0010\u001a\u001a\u00020\u0006R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u001b"}, hxF = {"Lcom/tencent/mm/emoji/model/search/EmojiSuggestIDKey;", "", "()V", "id", "", "getRemoteStart", "", "getRemoteSuccess", "hasPersonalWords", "hasRemoteCache", "hasRemoteShuffle", "config", "", "localResultTooMuch", "report", "key", "", "reportMatch", ImagesContract.LOCAL, "remote", "reportResult", "emojiList", "", "Lcom/tencent/mm/emoji/model/search/SuggestEmojiItem;", "reportSearchSlow", "reportStart", "resultTooMuch", "plugin-emojisdk_release"})
public final class d {
    public static final d gZA = new d();

    static {
        AppMethodBeat.i(199940);
        AppMethodBeat.o(199940);
    }

    private d() {
    }

    public static void ac(List<l> list) {
        AppMethodBeat.i(199938);
        p.h(list, "emojiList");
        if (!list.isEmpty()) {
            int size = list.size();
            ArrayList arrayList = new ArrayList();
            for (T t : list) {
                if (t.type == 0) {
                    arrayList.add(t);
                }
            }
            int size2 = arrayList.size();
            pl(1);
            if (size <= 2) {
                pl(2);
            } else if (size <= 5) {
                pl(3);
            } else if (size <= 10) {
                pl(4);
            } else if (size <= 50) {
                pl(5);
            } else {
                pl(9);
            }
            if (size2 > 0) {
                pl(11);
                if (size2 <= 2) {
                    pl(12);
                    AppMethodBeat.o(199938);
                    return;
                } else if (size2 <= 5) {
                    pl(13);
                    AppMethodBeat.o(199938);
                    return;
                } else if (size2 <= 10) {
                    pl(14);
                    AppMethodBeat.o(199938);
                    return;
                } else if (size2 <= 50) {
                    pl(15);
                    AppMethodBeat.o(199938);
                    return;
                } else {
                    pl(19);
                }
            }
        }
        AppMethodBeat.o(199938);
    }

    public static void pl(int i2) {
        AppMethodBeat.i(199939);
        h.INSTANCE.n(1418, (long) i2, 1);
        AppMethodBeat.o(199939);
    }
}

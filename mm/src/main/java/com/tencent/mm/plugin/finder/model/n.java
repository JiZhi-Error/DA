package com.tencent.mm.plugin.finder.model;

import android.text.SpannableString;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.h;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\t\u001a\u00020\nJ\u000e\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\rR\u001d\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u000e"}, hxF = {"Lcom/tencent/mm/plugin/finder/model/FinderCommentInfoEx;", "", "()V", "spanCache", "Lcom/tencent/mm/algorithm/MMLRUMap;", "", "Landroid/text/SpannableString;", "getSpanCache", "()Lcom/tencent/mm/algorithm/MMLRUMap;", "release", "", "update", "item", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "plugin-finder_release"})
public final class n {
    private static final h<String, SpannableString> uNT = new h<>(200);
    public static final n uNU = new n();

    static {
        AppMethodBeat.i(166377);
        AppMethodBeat.o(166377);
    }

    private n() {
    }

    public static h<String, SpannableString> dkv() {
        return uNT;
    }

    public static void release() {
        AppMethodBeat.i(166375);
        uNT.clear();
        AppMethodBeat.o(166375);
    }

    public static void d(FinderItem finderItem) {
        AppMethodBeat.i(166376);
        p.h(finderItem, "item");
        for (T t : finderItem.getCommentList()) {
            if (!uNT.check(t.username)) {
                y yVar = y.vXH;
                String str = t.username;
                if (str == null) {
                    str = "";
                }
                String str2 = t.nickname;
                if (str2 == null) {
                    str2 = "";
                }
                uNT.put(t.username, com.tencent.mm.pluginsdk.ui.span.l.c(MMApplicationContext.getContext(), y.he(str, str2)));
            }
            if (!uNT.check(t.reply_username)) {
                y yVar2 = y.vXH;
                String str3 = t.reply_username;
                if (str3 == null) {
                    str3 = "";
                }
                String str4 = t.replyNickname;
                if (str4 == null) {
                    str4 = "";
                }
                uNT.put(t.reply_username, com.tencent.mm.pluginsdk.ui.span.l.c(MMApplicationContext.getContext(), y.he(str3, str4)));
            }
            if (!uNT.check(t.content)) {
                uNT.put(t.content, com.tencent.mm.pluginsdk.ui.span.l.c(MMApplicationContext.getContext(), t.content));
            }
        }
        for (T t2 : finderItem.getLikeList()) {
            if (!uNT.check(t2.username)) {
                y yVar3 = y.vXH;
                String str5 = t2.username;
                if (str5 == null) {
                    str5 = "";
                }
                String str6 = t2.nickname;
                if (str6 == null) {
                    str6 = "";
                }
                uNT.put(t2.username, com.tencent.mm.pluginsdk.ui.span.l.c(MMApplicationContext.getContext(), y.he(str5, str6)));
            }
        }
        AppMethodBeat.o(166376);
    }
}

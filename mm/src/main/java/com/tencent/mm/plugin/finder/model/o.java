package com.tencent.mm.plugin.finder.model;

import android.text.SpannableString;
import com.tencent.e.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.FinderCommentInfo;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\"(\u0010\u0002\u001a\u00020\u0001*\u00020\u00032\u0006\u0010\u0000\u001a\u00020\u00018F@FX\u000e¢\u0006\f\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007\"(\u0010\b\u001a\u00020\u0001*\u00020\u00032\u0006\u0010\u0000\u001a\u00020\u00018F@FX\u000e¢\u0006\f\u001a\u0004\b\t\u0010\u0005\"\u0004\b\n\u0010\u0007\"(\u0010\u000b\u001a\u00020\u0001*\u00020\u00032\u0006\u0010\u0000\u001a\u00020\u00018F@FX\u000e¢\u0006\f\u001a\u0004\b\f\u0010\u0005\"\u0004\b\r\u0010\u0007¨\u0006\u000e"}, hxF = {"value", "Landroid/text/SpannableString;", "contentSpan", "Lcom/tencent/mm/protocal/protobuf/FinderCommentInfo;", "getContentSpan", "(Lcom/tencent/mm/protocal/protobuf/FinderCommentInfo;)Landroid/text/SpannableString;", "setContentSpan", "(Lcom/tencent/mm/protocal/protobuf/FinderCommentInfo;Landroid/text/SpannableString;)V", "displayNameSpan", "getDisplayNameSpan", "setDisplayNameSpan", "replyDisplayNameSpan", "getReplyDisplayNameSpan", "setReplyDisplayNameSpan", "plugin-finder_release"})
public final class o {
    public static final SpannableString a(FinderCommentInfo finderCommentInfo) {
        AppMethodBeat.i(166379);
        p.h(finderCommentInfo, "$this$contentSpan");
        n nVar = n.uNU;
        SpannableString spannableString = (SpannableString) n.dkv().get(finderCommentInfo.content);
        if (spannableString == null) {
            h.ez("{displayNameSpan} username=" + finderCommentInfo.username + " get SpannableString without cache!");
            spannableString = com.tencent.mm.pluginsdk.ui.span.l.c(MMApplicationContext.getContext(), finderCommentInfo.content);
            n nVar2 = n.uNU;
            n.dkv().put(finderCommentInfo.content, spannableString);
        }
        p.g(spannableString, "value");
        AppMethodBeat.o(166379);
        return spannableString;
    }
}

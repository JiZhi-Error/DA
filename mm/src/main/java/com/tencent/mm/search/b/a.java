package com.tencent.mm.search.b;

import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.pluginsdk.ui.chat.j;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u0006\u0010\t\u001a\u00020\u0006J\b\u0010\n\u001a\u0004\u0018\u00010\u0004R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u000b"}, hxF = {"Lcom/tencent/mm/search/logic/SimilarEmojiListenerInstance;", "", "()V", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/tencent/mm/search/logic/SosSimilarEmojiPanelClickListener;", "create", "", "emojiCallback", "Lcom/tencent/mm/pluginsdk/ui/chat/SmileyPanelCallback;", "destroy", "getInstance", "plugin-emojisdk_release"})
public final class a {
    private static c NJr;
    public static final a NJs = new a();

    static {
        AppMethodBeat.i(105835);
        AppMethodBeat.o(105835);
    }

    private a() {
    }

    public static void a(j jVar) {
        AppMethodBeat.i(105834);
        p.h(jVar, "emojiCallback");
        NJr = null;
        c cVar = new c(ChatFooterPanel.KbC);
        NJr = cVar;
        cVar.haC = jVar;
        AppMethodBeat.o(105834);
    }

    public static void destroy() {
        c cVar = NJr;
        if (cVar != null) {
            cVar.haC = null;
        }
        NJr = null;
    }

    public static c gxq() {
        return NJr;
    }
}

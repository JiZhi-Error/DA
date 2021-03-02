package com.tencent.mm.plugin.comm;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.util.c;
import java.util.UUID;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004J\u0006\u0010\b\u001a\u00020\u0006J\u0006\u0010\t\u001a\u00020\u0006J\u0006\u0010\n\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u000b"}, hxF = {"Lcom/tencent/mm/plugin/comm/MusicExptFlagLogic;", "", "()V", "QQ_MUSIC_APP_ID", "", "isFromQQMusicApp", "", "appId", "isOpenDowngradeH5Flag", "isOpenMvChatting", "newContextId", "plugin-comm_release"})
public final class a {
    public static final a qCo = new a();

    static {
        AppMethodBeat.i(223466);
        AppMethodBeat.o(223466);
    }

    private a() {
    }

    public static boolean cAI() {
        AppMethodBeat.i(223462);
        b.a aVar = b.a.clicfg_new_music_type_flag;
        c cVar = c.QYz;
        if (((b) g.af(b.class)).a(aVar, Util.getInt(c.axY(c.np("musicplayer", "openMvType")), 0)) == 1) {
            AppMethodBeat.o(223462);
            return true;
        }
        AppMethodBeat.o(223462);
        return false;
    }

    public static boolean akQ(String str) {
        AppMethodBeat.i(223463);
        boolean j2 = p.j("wx5aa333606550dfd5", str);
        AppMethodBeat.o(223463);
        return j2;
    }

    public static boolean cAJ() {
        AppMethodBeat.i(223464);
        b.a aVar = b.a.clicfg_new_music_chatting_flag;
        c cVar = c.QYz;
        if (((b) g.af(b.class)).a(aVar, Util.getInt(c.axY(c.np("musicplayer", "openMvChatting")), 0)) == 1) {
            AppMethodBeat.o(223464);
            return true;
        }
        AppMethodBeat.o(223464);
        return false;
    }

    public static String cAK() {
        AppMethodBeat.i(223465);
        String uuid = UUID.randomUUID().toString();
        p.g(uuid, "UUID.randomUUID().toString()");
        AppMethodBeat.o(223465);
        return uuid;
    }
}

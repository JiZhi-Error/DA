package com.tencent.mm.search;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.h.d;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\t\u001a\u00020\nH\u0007J\u0006\u0010\u000b\u001a\u00020\fR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\r"}, hxF = {"Lcom/tencent/mm/search/EmojiSearchConstant;", "", "()V", "KEY_NET_PARAM", "", "KEY_USERNAME", "SOS_SEARCH_UI_REQUEST_CODE", "", "TAG", "getEmojiSearchSwitch", "", "getHideVKBDelayTime", "", "plugin-emojisdk_release"})
public final class a {
    public static final a NJh = new a();

    static {
        AppMethodBeat.i(200079);
        AppMethodBeat.o(200079);
    }

    private a() {
    }

    public static long gxo() {
        AppMethodBeat.i(200077);
        long j2 = Util.getLong(d.cRY().b("clicfg_emoji_search_hide_keyboard_delay_time", "30000", false, true), 5000);
        AppMethodBeat.o(200077);
        return j2;
    }

    public static final boolean gxp() {
        AppMethodBeat.i(200078);
        if (Util.getInt(d.cRY().b("clicfg_emoji_search_switch", "1", false, true), 1) > 0) {
            AppMethodBeat.o(200078);
            return true;
        }
        AppMethodBeat.o(200078);
        return false;
    }
}

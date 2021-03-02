package com.tencent.mm.plugin.mv.ui.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\"\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0007\u001a\u000e\u0010\u0006\u001a\u00020\u0001*\u0004\u0018\u00010\u0007H\u0000\u001a\u0016\u0010\b\u001a\u0004\u0018\u00010\t*\u00020\u00052\b\u0010\n\u001a\u0004\u0018\u00010\u0001\u001a\u0014\u0010\u000b\u001a\u00020\u0001*\u00020\u00052\b\u0010\n\u001a\u0004\u0018\u00010\u0001\u001a\f\u0010\u000b\u001a\u00020\u0001*\u00020\u0003H\u0007¨\u0006\f"}, hxF = {"buildBusinessBuffer", "", "songInfo", "Lcom/tencent/mm/protocal/protobuf/FinderMVSongInfo;", "musicMv", "Lcom/tencent/mm/plugin/mv/model/MusicMv;", "escape", "", "toMusicShareObject", "Lcom/tencent/mm/protocal/protobuf/MusicShareObject;", "albumUrl", "toXml", "plugin-mv_release"})
public final class d {
    public static final String dG(Object obj) {
        String str;
        AppMethodBeat.i(257038);
        if (obj == null || (str = obj.toString()) == null) {
            str = "";
        }
        String escapeStringForXml = Util.escapeStringForXml(str);
        p.g(escapeStringForXml, "Util.escapeStringForXml(this?.toString() ?: \"\")");
        AppMethodBeat.o(257038);
        return escapeStringForXml;
    }
}

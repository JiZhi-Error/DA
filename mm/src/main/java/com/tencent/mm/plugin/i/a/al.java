package com.tencent.mm.plugin.i.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.k;
import com.tencent.mm.pluginsdk.ui.tools.b;
import com.tencent.mm.protocal.protobuf.css;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0007J\u001e\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0007¨\u0006\f"}, hxF = {"Lcom/tencent/mm/plugin/findersdk/api/MusicShareObjectUtil;", "", "()V", "isMusicShareObjectInvalid", "", "musicShareObject", "Lcom/tencent/mm/protocal/protobuf/MusicShareObject;", "parseFromMusicPiece", "content", "Lcom/tencent/mm/message/AppMessage$Content;", "piece", "Lcom/tencent/mm/pluginsdk/ui/tools/AppContentMusicPiece;", "finder-sdk_release"})
public final class al {
    public static final al wEm = new al();

    static {
        AppMethodBeat.i(208798);
        AppMethodBeat.o(208798);
    }

    private al() {
    }

    public static final css a(k.b bVar, b bVar2) {
        AppMethodBeat.i(208796);
        if (bVar2 == null || bVar == null) {
            AppMethodBeat.o(208796);
            return null;
        }
        css css = new css();
        css.Ktn = bVar2.Ktn;
        css.Kto = bVar2.Kto;
        css.Ktp = bVar2.Ktp;
        css.Ktq = bVar2.Ktq;
        String str = bVar2.Ktr;
        if (!(str == null || str.length() == 0)) {
            css.singerName = bVar2.Ktr;
        } else {
            css.singerName = bVar.description;
        }
        css.albumName = bVar2.Kts;
        css.musicGenre = bVar2.Ktt;
        css.issueDate = Util.safeParseLong(bVar2.Ktu);
        css.identification = bVar2.Ktv;
        css.extraInfo = bVar.messageExt;
        css.Alz = bVar2.Alz;
        css.BPc = bVar.title;
        css.songLyric = bVar2.songLyric;
        css.EsK = bVar2.songAlbumUrl;
        AppMethodBeat.o(208796);
        return css;
    }

    public static final boolean b(css css) {
        AppMethodBeat.i(208797);
        if (css == null) {
            AppMethodBeat.o(208797);
            return true;
        }
        String str = css.Ktn;
        if (str == null || str.length() == 0) {
            String str2 = css.Kto;
            if (str2 == null || str2.length() == 0) {
                String str3 = css.singerName;
                if (str3 == null || str3.length() == 0) {
                    AppMethodBeat.o(208797);
                    return true;
                }
            }
        }
        AppMethodBeat.o(208797);
        return false;
    }
}

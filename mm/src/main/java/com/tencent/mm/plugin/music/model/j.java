package com.tencent.mm.plugin.music.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.g;
import com.tencent.mm.loader.j.b;
import java.nio.charset.Charset;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.d;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\b\u001a\u00020\u0004J\u0006\u0010\t\u001a\u00020\u0004R\u0014\u0010\u0003\u001a\u00020\u00048BX\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\n"}, hxF = {"Lcom/tencent/mm/plugin/music/model/MusicMediaPath;", "", "()V", "musicCachePath", "", "getMusicCachePath", "()Ljava/lang/String;", "thumbSuffix", "getCaptureFilePath", "getCaptureThumbPath", "plugin-music_release"})
public final class j {
    private static final String AkD = AkD;
    public static final j AkE = new j();

    static {
        AppMethodBeat.i(219981);
        AppMethodBeat.o(219981);
    }

    private j() {
    }

    private static String euy() {
        AppMethodBeat.i(219978);
        String str = b.aKS() + "music/";
        AppMethodBeat.o(219978);
        return str;
    }

    public static String dEC() {
        AppMethodBeat.i(219979);
        StringBuilder append = new StringBuilder().append(euy());
        String valueOf = String.valueOf(System.currentTimeMillis());
        Charset charset = d.UTF_8;
        if (valueOf == null) {
            t tVar = new t("null cannot be cast to non-null type java.lang.String");
            AppMethodBeat.o(219979);
            throw tVar;
        }
        byte[] bytes = valueOf.getBytes(charset);
        p.g(bytes, "(this as java.lang.String).getBytes(charset)");
        String sb = append.append(g.getMessageDigest(bytes)).toString();
        AppMethodBeat.o(219979);
        return sb;
    }

    public static String euz() {
        AppMethodBeat.i(219980);
        StringBuilder append = new StringBuilder().append(euy());
        String valueOf = String.valueOf(System.currentTimeMillis());
        Charset charset = d.UTF_8;
        if (valueOf == null) {
            t tVar = new t("null cannot be cast to non-null type java.lang.String");
            AppMethodBeat.o(219980);
            throw tVar;
        }
        byte[] bytes = valueOf.getBytes(charset);
        p.g(bytes, "(this as java.lang.String).getBytes(charset)");
        String sb = append.append(g.getMessageDigest(bytes)).append(AkD).toString();
        AppMethodBeat.o(219980);
        return sb;
    }
}

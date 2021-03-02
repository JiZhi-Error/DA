package com.tencent.mm.plugin.music.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.kernel.e;
import java.nio.charset.Charset;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.d;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u001b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u001a\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0018\u001a\u00020\u00042\b\u0010\u0019\u001a\u0004\u0018\u00010\u0004H\u0002J\u001a\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u00042\b\u0010\u001c\u001a\u0004\u0018\u00010\u0004H\u0002J\u0010\u0010\u001d\u001a\u00020\u00042\b\u0010\u001c\u001a\u0004\u0018\u00010\u0004J\b\u0010\u001e\u001a\u00020\u0004H\u0002J\u0018\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u00042\b\b\u0002\u0010\"\u001a\u00020#J\u0006\u0010$\u001a\u00020\u0004J\u0006\u0010%\u001a\u00020\u0004J\u0006\u0010&\u001a\u00020\u0004J\u0006\u0010'\u001a\u00020\u0004J\u000e\u0010(\u001a\u00020\u00042\u0006\u0010)\u001a\u00020\u0004J\u0012\u0010*\u001a\u00020#2\b\u0010+\u001a\u0004\u0018\u00010\u0004H\u0002J\u0006\u0010,\u001a\u00020\u0004J\u0006\u0010-\u001a\u00020\u0004J\u0006\u0010.\u001a\u00020\u0004J\u0006\u0010/\u001a\u00020\u0004J\u0012\u00100\u001a\u0004\u0018\u00010\u00042\b\u00101\u001a\u0004\u0018\u00010\u0004J\u0006\u00102\u001a\u00020 J\u001a\u00103\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u00042\b\u00104\u001a\u0004\u0018\u00010\u0004H\u0002J\u0010\u00105\u001a\u00020\u00042\b\u00106\u001a\u0004\u0018\u00010\u0004J\u001a\u00107\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u00042\b\u0010\u001c\u001a\u0004\u0018\u00010\u0004H\u0002J\u0010\u00108\u001a\u00020\u00042\b\u0010\u001c\u001a\u0004\u0018\u00010\u0004J\u0010\u00109\u001a\u00020\u00042\b\u0010\u001c\u001a\u0004\u0018\u00010\u0004J\u001a\u0010:\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u00042\b\u00104\u001a\u0004\u0018\u00010\u0004H\u0002J\u0010\u0010;\u001a\u00020\u00042\b\u0010<\u001a\u0004\u0018\u00010\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006="}, hxF = {"Lcom/tencent/mm/plugin/music/model/MusicFileNameUtil;", "", "()V", "AVATAR_FILE", "", "BULLET_CACHE_FILE", "CACHE", "COVER_AVATAR", "COVER_DEFAULT_VIDEO", "COVER_IMG", "COVER_VIDEO", "LIKE_CACHE_FILE", "PIC_FILE", "STORAGE_COVER", "STORAGE_MUSIC", "TAG", "TMP_FILE", "UP_FILE", "VIDEO_FILE", "selfName", "getSelfName", "()Ljava/lang/String;", "setSelfName", "(Ljava/lang/String;)V", "autoPath", "user", "avatarEnsurePath", "parentPath", "coverId", "avatarPath", "checkSelfName", "checkToCreateDir", "", "newVideoPath", "noMedia", "", "coverAvatarPath", "coverDefaultVideoPath", "coverImgPath", "coverVideoPath", "defaultVideoPath", "name", "isSelf", "userName", "musicBulletCachePath", "musicCachePath", "musicLikeCachePath", "musicPath", "primaryPathVideoPath", ch.COL_USERNAME, "reset", "thumbEnsurePath", "mediaId", "thumbPath", "musicId", "uploadEnsurePath", "uploadThumbPath", "uploadVideoPath", "videoEnsurePath", "videoPath", "url", "plugin-music_release"})
public final class g {
    public static final g Aku = new g();
    private static String gna = "";

    static {
        AppMethodBeat.i(219974);
        AppMethodBeat.o(219974);
    }

    private g() {
    }

    public static String eux() {
        AppMethodBeat.i(219971);
        StringBuilder sb = new StringBuilder();
        e aAh = com.tencent.mm.kernel.g.aAh();
        p.g(aAh, "MMKernel.storage()");
        String sb2 = sb.append(aAh.getAccPath()).append("music/cover/").toString();
        AppMethodBeat.o(219971);
        return sb2;
    }

    public static String aHP(String str) {
        AppMethodBeat.i(219972);
        if (str == null) {
            AppMethodBeat.o(219972);
            return "";
        }
        String str2 = eux() + "img/";
        if (str == null) {
            AppMethodBeat.o(219972);
            return "";
        }
        String str3 = str2 + str + ".p";
        AppMethodBeat.o(219972);
        return str3;
    }

    public static String aHQ(String str) {
        AppMethodBeat.i(219973);
        String str2 = str;
        if (str2 == null || str2.length() == 0) {
            AppMethodBeat.o(219973);
            return "";
        }
        String str3 = eux() + "video/";
        Charset charset = d.UTF_8;
        if (str == null) {
            t tVar = new t("null cannot be cast to non-null type java.lang.String");
            AppMethodBeat.o(219973);
            throw tVar;
        }
        byte[] bytes = str.getBytes(charset);
        p.g(bytes, "(this as java.lang.String).getBytes(charset)");
        String messageDigest = com.tencent.mm.b.g.getMessageDigest(bytes);
        if (messageDigest == null) {
            AppMethodBeat.o(219973);
            return "";
        }
        String str4 = str3 + messageDigest + ".v";
        AppMethodBeat.o(219973);
        return str4;
    }
}

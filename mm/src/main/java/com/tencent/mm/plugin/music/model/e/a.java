package com.tencent.mm.plugin.music.model.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ay.f;
import com.tencent.mm.g.c.et;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.IAutoDBItem;

public final class a extends et {
    public static IAutoDBItem.MAutoDBInfo info = et.ajs();
    public String iJP;
    public String jft;
    public boolean jfx;
    public String playUrl;

    static {
        AppMethodBeat.i(63171);
        AppMethodBeat.o(63171);
    }

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem
    public final IAutoDBItem.MAutoDBInfo getDBInfo() {
        return info;
    }

    public final boolean euM() {
        return (this.field_songBgColor == 0 || this.field_songLyricColor == 0) ? false : true;
    }

    public final boolean euN() {
        AppMethodBeat.i(63168);
        if (!Util.isNullOrNil(this.field_songHAlbumUrl)) {
            AppMethodBeat.o(63168);
            return true;
        }
        AppMethodBeat.o(63168);
        return false;
    }

    public final boolean G(int[] iArr) {
        return this.field_songBgColor == iArr[0] && this.field_songLyricColor == iArr[1];
    }

    public final boolean h(a aVar) {
        AppMethodBeat.i(63169);
        if (aVar == null) {
            AppMethodBeat.o(63169);
            return false;
        }
        boolean equals = this.field_musicId.equals(aVar.field_musicId);
        AppMethodBeat.o(63169);
        return equals;
    }

    public final f euO() {
        AppMethodBeat.i(63170);
        f fVar = new f();
        fVar.jeV = this.field_originMusicId;
        fVar.jeT = this.field_musicType;
        fVar.jfi = this.field_appId;
        fVar.jeZ = this.field_songAlbum;
        fVar.jfj = this.field_songAlbumType;
        fVar.jfa = this.field_songAlbumUrl;
        fVar.jfm = this.field_songHAlbumUrl;
        fVar.jfe = this.field_songLyric;
        fVar.jfb = this.field_songWifiUrl;
        fVar.jeX = this.field_songName;
        fVar.jeY = this.field_songSinger;
        fVar.jfc = this.field_songWapLinkUrl;
        fVar.jfd = this.field_songWebUrl;
        fVar.jff = this.field_songAlbumLocalPath;
        fVar.jfl = this.field_songMediaId;
        fVar.jfn = this.field_songSnsAlbumUser;
        fVar.jfp = this.field_songSnsShareUser;
        fVar.jfr = this.field_hideBanner;
        fVar.jfs = this.field_jsWebUrlDomain;
        fVar.dvv = this.field_startTime;
        fVar.jft = this.jft;
        fVar.protocol = this.field_protocol;
        fVar.jfu = this.field_barBackToWebView;
        fVar.jfv = this.field_musicbar_url;
        fVar.playUrl = this.playUrl;
        fVar.eag = this.field_srcUsername;
        fVar.iJH = this.field_playbackRate;
        fVar.iJP = this.iJP;
        fVar.jfx = this.jfx;
        AppMethodBeat.o(63170);
        return fVar;
    }
}

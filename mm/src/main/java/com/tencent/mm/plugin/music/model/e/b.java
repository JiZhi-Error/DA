package com.tencent.mm.plugin.music.model.e;

import android.database.Cursor;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.b.f;
import com.tencent.mm.memory.a.c;
import com.tencent.mm.plugin.music.model.e;
import com.tencent.mm.plugin.music.model.m;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;

public final class b extends MAutoStorage<a> {
    public f<String, a> AlG = new c(20);
    public f<String, e> AlH = new c(10);
    public ISQLiteDatabase db;

    public b(ISQLiteDatabase iSQLiteDatabase) {
        super(iSQLiteDatabase, a.info, "Music", null);
        AppMethodBeat.i(63172);
        this.db = iSQLiteDatabase;
        AppMethodBeat.o(63172);
    }

    public final a aHW(String str) {
        AppMethodBeat.i(63173);
        if (this.AlG.get(str) != null) {
            a aVar = this.AlG.get(str);
            AppMethodBeat.o(63173);
            return aVar;
        }
        String format = String.format("Select * From Music Where musicId=?", new Object[0]);
        Cursor rawQuery = this.db.rawQuery(format, new String[]{str}, 2);
        if (rawQuery == null || !rawQuery.moveToFirst()) {
            if (rawQuery != null) {
                rawQuery.close();
            }
            AppMethodBeat.o(63173);
            return null;
        }
        a aVar2 = new a();
        aVar2.convertFrom(rawQuery);
        rawQuery.close();
        this.AlG.put(str, aVar2);
        AppMethodBeat.o(63173);
        return aVar2;
    }

    public final e a(a aVar, boolean z) {
        AppMethodBeat.i(63174);
        if (this.AlH.get(aVar.field_musicId) != null) {
            e eVar = this.AlH.get(aVar.field_musicId);
            AppMethodBeat.o(63174);
            return eVar;
        }
        e b2 = b(aVar, z, true);
        AppMethodBeat.o(63174);
        return b2;
    }

    public final e i(a aVar) {
        AppMethodBeat.i(219852);
        if (this.AlH.get(aVar.field_musicId) != null) {
            e eVar = this.AlH.get(aVar.field_musicId);
            AppMethodBeat.o(219852);
            return eVar;
        }
        e b2 = b(aVar, false, false);
        AppMethodBeat.o(219852);
        return b2;
    }

    private e b(a aVar, boolean z, boolean z2) {
        AppMethodBeat.i(219853);
        e a2 = e.a(aVar.field_songLyric, MMApplicationContext.getContext().getString(R.string.f9t), aVar.field_songSnsShareUser, m.a(aVar), aVar.field_songSinger, z, z2);
        this.AlH.put(aVar.field_musicId, a2);
        AppMethodBeat.o(219853);
        return a2;
    }

    public final a b(String str, String str2, String str3, String str4, boolean z, boolean z2) {
        AppMethodBeat.i(219854);
        a aHW = aHW(str);
        if (aHW == null) {
            Log.e("MicroMsg.Music.MusicStorage", "updateMusicWithLyricResponse can not find music %s", str);
            AppMethodBeat.o(219854);
            return null;
        }
        if (!Util.isNullOrNil(str2)) {
            aHW.field_songAlbumUrl = str2;
        }
        aHW.field_songHAlbumUrl = str3;
        aHW.field_songLyric = str4;
        update(aHW, "songAlbumUrl", "songHAlbumUrl", "songLyric");
        this.AlG.put(str, aHW);
        b(aHW, z, z2);
        AppMethodBeat.o(219854);
        return aHW;
    }

    public final a aw(String str, int i2, int i3) {
        AppMethodBeat.i(63176);
        Log.i("MicroMsg.Music.MusicStorage", "updateMusicWithColor %s %d %d", str, Integer.valueOf(i2), Integer.valueOf(i3));
        a aHW = aHW(str);
        if (aHW == null) {
            Log.e("MicroMsg.Music.MusicStorage", "updateMusicWithColor can not find music %s", str);
            AppMethodBeat.o(63176);
            return null;
        }
        aHW.field_songBgColor = i2;
        aHW.field_songLyricColor = i3;
        update(aHW, "songBgColor", "songLyricColor");
        this.AlG.put(str, aHW);
        AppMethodBeat.o(63176);
        return aHW;
    }

    public final a F(com.tencent.mm.ay.f fVar) {
        boolean z;
        AppMethodBeat.i(63177);
        String S = com.tencent.mm.plugin.music.h.b.S(fVar);
        a aHW = aHW(S);
        if (aHW == null) {
            aHW = new a();
            z = false;
        } else {
            z = true;
        }
        aHW.field_musicId = S;
        aHW.field_originMusicId = fVar.jeV;
        aHW.field_musicType = fVar.jeT;
        aHW.field_appId = fVar.jfi;
        if (Util.isNullOrNil(aHW.field_appId)) {
            aHW.field_appId = m.D(fVar);
        }
        aHW.field_songAlbum = fVar.jeZ;
        aHW.field_songAlbumType = fVar.jfj;
        aHW.field_songWifiUrl = fVar.jfb;
        aHW.field_songName = fVar.jeX;
        aHW.field_songSinger = fVar.jeY;
        aHW.field_songWapLinkUrl = fVar.jfc;
        aHW.field_songWebUrl = fVar.jfd;
        aHW.field_songAlbumLocalPath = fVar.jff;
        aHW.field_songMediaId = fVar.jfl;
        aHW.field_songSnsAlbumUser = fVar.jfn;
        aHW.field_songAlbumUrl = fVar.jfa;
        if (TextUtils.isEmpty(aHW.field_songLyric) && !TextUtils.isEmpty(fVar.jfe)) {
            aHW.field_songLyric = fVar.jfe;
        }
        aHW.field_songSnsShareUser = fVar.jfp;
        if (TextUtils.isEmpty(aHW.field_songHAlbumUrl) && !Util.isNullOrNil(fVar.jfm)) {
            aHW.field_songHAlbumUrl = fVar.jfm;
        }
        aHW.field_updateTime = System.currentTimeMillis();
        if (aHW.field_songId == 0) {
            com.tencent.mm.plugin.music.h.e.Y(fVar);
            aHW.field_songId = fVar.jfk;
        }
        if (aHW.field_songMId == null) {
            aHW.field_songMId = com.tencent.mm.plugin.music.h.e.aIk(com.tencent.mm.plugin.music.h.e.W(fVar));
        }
        if ((Util.isNullOrNil(aHW.field_songWapLinkUrl) || aHW.field_songWapLinkUrl.equals(aHW.field_songWebUrl)) && !Util.isNullOrNil(aHW.field_songWifiUrl)) {
            aHW.field_songWapLinkUrl = aHW.field_songWifiUrl;
        }
        if (aHW.field_songId == 0 && fVar.jeT == 4) {
            try {
                aHW.field_songId = Integer.valueOf(fVar.jeV).intValue();
            } catch (Exception e2) {
            }
        }
        aHW.field_hideBanner = fVar.jfr;
        aHW.field_jsWebUrlDomain = fVar.jfs;
        aHW.field_startTime = fVar.dvv;
        aHW.jft = fVar.jft;
        aHW.field_protocol = fVar.protocol;
        aHW.field_barBackToWebView = fVar.jfu;
        aHW.field_musicbar_url = fVar.jfv;
        aHW.field_srcUsername = fVar.eag;
        aHW.field_playbackRate = fVar.iJH;
        aHW.iJP = fVar.iJP;
        aHW.jfx = fVar.jfx;
        if (z) {
            Log.i("MicroMsg.Music.MusicStorage", "update music %s", S);
            update(aHW, new String[0]);
        } else {
            Log.i("MicroMsg.Music.MusicStorage", "insert music %s", S);
            insert(aHW);
        }
        this.AlG.put(S, aHW);
        AppMethodBeat.o(63177);
        return aHW;
    }
}

package com.tencent.mm.opensdk.modelmsg;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.utils.Log;

public class WXMusicObject implements WXMediaMessage.IMediaObject {
    private static final int LENGTH_LIMIT = 10240;
    private static final int LYRIC_LENGTH_LIMIT = 32768;
    private static final String TAG = "MicroMsg.SDK.WXMusicObject";
    public String musicDataUrl;
    public String musicLowBandDataUrl;
    public String musicLowBandUrl;
    public String musicUrl;
    public String songAlbumUrl;
    public String songLyric;

    @Override // com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject
    public boolean checkArgs() {
        String str;
        AppMethodBeat.i(3979);
        String str2 = this.musicUrl;
        if ((str2 == null || str2.length() == 0) && ((str = this.musicLowBandUrl) == null || str.length() == 0)) {
            Log.e(TAG, "both arguments are null");
            AppMethodBeat.o(3979);
            return false;
        }
        String str3 = this.musicUrl;
        if (str3 == null || str3.length() <= 10240) {
            String str4 = this.musicLowBandUrl;
            if (str4 == null || str4.length() <= 10240) {
                String str5 = this.songAlbumUrl;
                if (str5 == null || str5.length() <= 10240) {
                    String str6 = this.songLyric;
                    if (str6 == null || str6.length() <= 32768) {
                        AppMethodBeat.o(3979);
                        return true;
                    }
                    Log.e(TAG, "checkArgs fail, songLyric is too long");
                    AppMethodBeat.o(3979);
                    return false;
                }
                Log.e(TAG, "checkArgs fail, songAlbumUrl is too long");
                AppMethodBeat.o(3979);
                return false;
            }
            Log.e(TAG, "checkArgs fail, musicLowBandUrl is too long");
            AppMethodBeat.o(3979);
            return false;
        }
        Log.e(TAG, "checkArgs fail, musicUrl is too long");
        AppMethodBeat.o(3979);
        return false;
    }

    @Override // com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject
    public void serialize(Bundle bundle) {
        AppMethodBeat.i(3977);
        bundle.putString("_wxmusicobject_musicUrl", this.musicUrl);
        bundle.putString("_wxmusicobject_musicLowBandUrl", this.musicLowBandUrl);
        bundle.putString("_wxmusicobject_musicDataUrl", this.musicDataUrl);
        bundle.putString("_wxmusicobject_musicLowBandDataUrl", this.musicLowBandDataUrl);
        bundle.putString("_wxmusicobject_musicAlbumUrl", this.songAlbumUrl);
        bundle.putString("_wxmusicobject_musicLyric", this.songLyric);
        AppMethodBeat.o(3977);
    }

    @Override // com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject
    public int type() {
        return 3;
    }

    @Override // com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject
    public void unserialize(Bundle bundle) {
        AppMethodBeat.i(3978);
        this.musicUrl = bundle.getString("_wxmusicobject_musicUrl");
        this.musicLowBandUrl = bundle.getString("_wxmusicobject_musicLowBandUrl");
        this.musicDataUrl = bundle.getString("_wxmusicobject_musicDataUrl");
        this.musicLowBandDataUrl = bundle.getString("_wxmusicobject_musicLowBandDataUrl");
        this.songAlbumUrl = bundle.getString("_wxmusicobject_musicAlbumUrl");
        this.songLyric = bundle.getString("_wxmusicobject_musicLyric");
        AppMethodBeat.o(3978);
    }
}

package com.tencent.mm.opensdk.modelmsg;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.utils.Log;
import com.tencent.mm.opensdk.utils.b;

public class WXMusicVideoObject implements WXMediaMessage.IMediaObject {
    private static final int HD_ALBUM_FILE_LENGTH = 10485760;
    private static final int LYRIC_LENGTH_LIMIT = 32768;
    private static final int STRING_LIMIT = 1024;
    private static final String TAG = "MicroMsg.SDK.WXMusicVideoObject";
    private static final int URL_LENGTH_LIMIT = 10240;
    public String albumName;
    public int duration;
    public String hdAlbumThumbFilePath;
    public String identification;
    public long issueDate;
    public String musicDataUrl;
    public String musicGenre;
    public String musicUrl;
    public String singerName;
    public String songLyric;

    private int getFileSize(String str) {
        AppMethodBeat.i(258810);
        int a2 = b.a(str);
        AppMethodBeat.o(258810);
        return a2;
    }

    @Override // com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject
    public boolean checkArgs() {
        AppMethodBeat.i(190414);
        if (b.b(this.musicUrl) || this.musicUrl.length() > 10240) {
            Log.e(TAG, "musicUrl.length exceeds the limit");
            AppMethodBeat.o(190414);
            return false;
        } else if (b.b(this.musicDataUrl) || this.musicDataUrl.length() > 10240) {
            Log.e(TAG, "musicDataUrl.length exceeds the limit");
            AppMethodBeat.o(190414);
            return false;
        } else if (b.b(this.singerName) || this.singerName.length() > 1024) {
            Log.e(TAG, "singerName.length exceeds the limit");
            AppMethodBeat.o(190414);
            return false;
        } else if (!b.b(this.songLyric) && this.songLyric.length() > 32768) {
            Log.e(TAG, "songLyric.length exceeds the limit");
            AppMethodBeat.o(190414);
            return false;
        } else if (!b.b(this.hdAlbumThumbFilePath) && this.hdAlbumThumbFilePath.length() > 1024) {
            Log.e(TAG, "hdAlbumThumbFilePath.length exceeds the limit");
            AppMethodBeat.o(190414);
            return false;
        } else if (!b.b(this.hdAlbumThumbFilePath) && getFileSize(this.hdAlbumThumbFilePath) > HD_ALBUM_FILE_LENGTH) {
            Log.e(TAG, "hdAlbumThumbFilePath file length exceeds the limit");
            AppMethodBeat.o(190414);
            return false;
        } else if (!b.b(this.musicGenre) && this.musicGenre.length() > 1024) {
            Log.e(TAG, "musicGenre.length exceeds the limit");
            AppMethodBeat.o(190414);
            return false;
        } else if (b.b(this.identification) || this.identification.length() <= 1024) {
            AppMethodBeat.o(190414);
            return true;
        } else {
            Log.e(TAG, "identification.length exceeds the limit");
            AppMethodBeat.o(190414);
            return false;
        }
    }

    @Override // com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject
    public void serialize(Bundle bundle) {
        AppMethodBeat.i(190412);
        bundle.putString("_wxmusicvideoobject_musicUrl", this.musicUrl);
        bundle.putString("_wxmusicvideoobject_musicDataUrl", this.musicDataUrl);
        bundle.putString("_wxmusicvideoobject_singerName", this.singerName);
        bundle.putString("_wxmusicvideoobject_songLyric", this.songLyric);
        bundle.putString("_wxmusicvideoobject_hdAlbumThumbFilePath", this.hdAlbumThumbFilePath);
        bundle.putString("_wxmusicvideoobject_albumName", this.albumName);
        bundle.putString("_wxmusicvideoobject_musicGenre", this.musicGenre);
        bundle.putLong("_wxmusicvideoobject_issueDate", this.issueDate);
        bundle.putString("_wxmusicvideoobject_identification", this.identification);
        bundle.putInt("_wxmusicvideoobject_duration", this.duration);
        AppMethodBeat.o(190412);
    }

    @Override // com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject
    public int type() {
        return 76;
    }

    @Override // com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject
    public void unserialize(Bundle bundle) {
        AppMethodBeat.i(190413);
        this.musicUrl = bundle.getString("_wxmusicvideoobject_musicUrl");
        this.musicDataUrl = bundle.getString("_wxmusicvideoobject_musicDataUrl");
        this.singerName = bundle.getString("_wxmusicvideoobject_singerName");
        this.songLyric = bundle.getString("_wxmusicvideoobject_songLyric");
        this.hdAlbumThumbFilePath = bundle.getString("_wxmusicvideoobject_hdAlbumThumbFilePath");
        this.albumName = bundle.getString("_wxmusicvideoobject_albumName");
        this.musicGenre = bundle.getString("_wxmusicvideoobject_musicGenre");
        this.issueDate = bundle.getLong("_wxmusicvideoobject_issueDate", 0);
        this.identification = bundle.getString("_wxmusicvideoobject_identification");
        this.duration = bundle.getInt("_wxmusicvideoobject_duration", 0);
        AppMethodBeat.o(190413);
    }
}

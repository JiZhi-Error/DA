package com.tencent.mm.plugin.mmsight.segment;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.q;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.FileDescriptor;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class FFmpegMetadataRetriever {
    public static final String METADATA_CHAPTER_COUNT = "chapter_count";
    public static final String METADATA_KEY_ALBUM = "album";
    public static final String METADATA_KEY_ALBUM_ARTIST = "album_artist";
    public static final String METADATA_KEY_ARTIST = "artist";
    public static final String METADATA_KEY_AUDIO_CODEC = "audio_codec";
    public static final String METADATA_KEY_CHAPTER_END_TIME = "chapter_end_time";
    public static final String METADATA_KEY_CHAPTER_START_TIME = "chapter_start_time";
    public static final String METADATA_KEY_COMMENT = "comment";
    public static final String METADATA_KEY_COMPOSER = "composer";
    public static final String METADATA_KEY_COPYRIGHT = "copyright";
    public static final String METADATA_KEY_CREATION_TIME = "creation_time";
    public static final String METADATA_KEY_DATE = "date";
    public static final String METADATA_KEY_DISC = "disc";
    public static final String METADATA_KEY_DURATION = "duration";
    public static final String METADATA_KEY_ENCODED_BY = "encoded_by";
    public static final String METADATA_KEY_ENCODER = "encoder";
    public static final String METADATA_KEY_FILENAME = "filename";
    public static final String METADATA_KEY_FILESIZE = "filesize";
    public static final String METADATA_KEY_FRAMERATE = "framerate";
    public static final String METADATA_KEY_GENRE = "genre";
    public static final String METADATA_KEY_ICY_METADATA = "icy_metadata";
    public static final String METADATA_KEY_LANGUAGE = "language";
    public static final String METADATA_KEY_PERFORMER = "performer";
    public static final String METADATA_KEY_PUBLISHER = "publisher";
    public static final String METADATA_KEY_SERVICE_NAME = "service_name";
    public static final String METADATA_KEY_SERVICE_PROVIDER = "service_provider";
    public static final String METADATA_KEY_TITLE = "title";
    public static final String METADATA_KEY_TRACK = "track";
    public static final String METADATA_KEY_VARIANT_BITRATE = "bitrate";
    public static final String METADATA_KEY_VIDEO_CODEC = "video_codec";
    public static final String METADATA_KEY_VIDEO_HEIGHT = "video_height";
    public static final String METADATA_KEY_VIDEO_ROTATION = "rotate";
    public static final String METADATA_KEY_VIDEO_WIDTH = "video_width";
    public static final int OPTION_CLOSEST = 3;
    public static final int OPTION_CLOSEST_SYNC = 2;
    public static final int OPTION_NEXT_SYNC = 1;
    public static final int OPTION_PREVIOUS_SYNC = 0;
    private static final String TAG = "FFmpegMetadataRetriever";
    private long mNativeContext;
    private Bitmap reuse;

    private native byte[] _getFrameAtTime(long j2, int i2);

    private native byte[] _getScaledFrameAtTime(long j2, int i2, int i3, int i4);

    private native void _setDataSource(String str, String[] strArr, String[] strArr2);

    private native void native_finalize();

    private final native HashMap<String, String> native_getMetadata(boolean z, boolean z2, HashMap<String, String> hashMap);

    private static native void native_init();

    private native void native_setup();

    public native String extractMetadata(String str);

    public native String extractMetadataFromChapter(String str, int i2);

    public native void release();

    public native void setDataSource(FileDescriptor fileDescriptor, long j2, long j3);

    static {
        AppMethodBeat.i(107628);
        native_init();
        AppMethodBeat.o(107628);
    }

    public FFmpegMetadataRetriever() {
        AppMethodBeat.i(107609);
        native_setup();
        AppMethodBeat.o(107609);
    }

    public void setDataSource(String str) {
        AppMethodBeat.i(107610);
        _setDataSourceVFS(str, null, null);
        AppMethodBeat.o(107610);
    }

    public void setDataSource(String str, Map<String, String> map) {
        AppMethodBeat.i(107611);
        int i2 = 0;
        String[] strArr = new String[map.size()];
        String[] strArr2 = new String[map.size()];
        for (Map.Entry<String, String> entry : map.entrySet()) {
            strArr[i2] = entry.getKey();
            strArr2[i2] = entry.getValue();
            i2++;
        }
        _setDataSourceVFS(str, strArr, strArr2);
        AppMethodBeat.o(107611);
    }

    private void _setDataSourceVFS(String str, String[] strArr, String[] strArr2) {
        AppMethodBeat.i(107612);
        _setDataSource(q.k(str, false), strArr, strArr2);
        AppMethodBeat.o(107612);
    }

    public void setDataSource(FileDescriptor fileDescriptor) {
        AppMethodBeat.i(107613);
        setDataSource(fileDescriptor, 0, 576460752303423487L);
        AppMethodBeat.o(107613);
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0049 A[SYNTHETIC, Splitter:B:22:0x0049] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0080 A[SYNTHETIC, Splitter:B:36:0x0080] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setDataSource(android.content.Context r9, android.net.Uri r10) {
        /*
        // Method dump skipped, instructions count: 183
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever.setDataSource(android.content.Context, android.net.Uri):void");
    }

    public a getMetadata() {
        boolean z = false;
        AppMethodBeat.i(107615);
        a aVar = new a();
        HashMap<String, String> native_getMetadata = native_getMetadata(false, false, null);
        if (native_getMetadata == null) {
            AppMethodBeat.o(107615);
            return null;
        }
        if (native_getMetadata != null) {
            aVar.zxY = native_getMetadata;
            z = true;
        }
        if (!z) {
            AppMethodBeat.o(107615);
            return null;
        }
        AppMethodBeat.o(107615);
        return aVar;
    }

    public Bitmap getFrameAtTime(long j2, int i2) {
        AppMethodBeat.i(107616);
        if (i2 < 0 || i2 > 3) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Unsupported option: ".concat(String.valueOf(i2)));
            AppMethodBeat.o(107616);
            throw illegalArgumentException;
        }
        Bitmap bitmap = null;
        byte[] _getFrameAtTime = _getFrameAtTime(j2, i2);
        if (_getFrameAtTime != null) {
            bitmap = getBitmapFromPixels(_getFrameAtTime, -1, -1);
        }
        AppMethodBeat.o(107616);
        return bitmap;
    }

    public Bitmap getFrameAtTime(long j2) {
        AppMethodBeat.i(107617);
        Bitmap bitmap = null;
        byte[] _getFrameAtTime = _getFrameAtTime(j2, 2);
        if (_getFrameAtTime != null) {
            bitmap = getBitmapFromPixels(_getFrameAtTime, -1, -1);
        }
        AppMethodBeat.o(107617);
        return bitmap;
    }

    public Bitmap getFrameAtTime() {
        AppMethodBeat.i(107618);
        Bitmap frameAtTime = getFrameAtTime(-1, 2);
        AppMethodBeat.o(107618);
        return frameAtTime;
    }

    public Bitmap getScaledFrameAtTime(long j2, int i2, int i3, int i4) {
        AppMethodBeat.i(107619);
        if (i2 < 0 || i2 > 3) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Unsupported option: ".concat(String.valueOf(i2)));
            AppMethodBeat.o(107619);
            throw illegalArgumentException;
        }
        Bitmap bitmap = null;
        byte[] _getScaledFrameAtTime = _getScaledFrameAtTime(j2, i2, i3, i4);
        if (_getScaledFrameAtTime != null) {
            bitmap = getBitmapFromPixels(_getScaledFrameAtTime, i3, i4);
        }
        AppMethodBeat.o(107619);
        return bitmap;
    }

    public Bitmap getScaledFrameAtTime(long j2, int i2, int i3) {
        AppMethodBeat.i(107620);
        Bitmap bitmap = null;
        byte[] _getScaledFrameAtTime = _getScaledFrameAtTime(j2, 0, i2, i3);
        if (_getScaledFrameAtTime != null) {
            bitmap = getBitmapFromPixels(_getScaledFrameAtTime, i2, i3);
        }
        AppMethodBeat.o(107620);
        return bitmap;
    }

    public void reuseBitmap(Bitmap bitmap) {
        AppMethodBeat.i(107621);
        if (bitmap == null) {
            AppMethodBeat.o(107621);
            return;
        }
        if (this.reuse != null) {
            this.reuse.recycle();
        }
        this.reuse = bitmap;
        AppMethodBeat.o(107621);
    }

    private Bitmap getBitmapFromPixels(byte[] bArr, int i2, int i3) {
        AppMethodBeat.i(107622);
        if (bArr == null || bArr.length == 0) {
            AppMethodBeat.o(107622);
            return null;
        }
        if (i2 == -1) {
            i2 = getVideoWidth();
        }
        if (i3 == -1) {
            i3 = getVideoHeight();
        }
        if (i2 <= 0 || i3 <= 0) {
            IllegalStateException illegalStateException = new IllegalStateException(String.format(Locale.CHINA, "Can not get bitmap width and height [%d, %d]", Integer.valueOf(i2), Integer.valueOf(i3)));
            AppMethodBeat.o(107622);
            throw illegalStateException;
        }
        Bitmap bitmap = this.reuse;
        if (bitmap == null) {
            bitmap = Bitmap.createBitmap(i2, i3, Bitmap.Config.ARGB_8888);
        }
        bitmap.copyPixelsFromBuffer(ByteBuffer.wrap(bArr));
        AppMethodBeat.o(107622);
        return bitmap;
    }

    public int getVideoWidth() {
        String str;
        int i2 = 0;
        AppMethodBeat.i(107623);
        try {
            String extractMetadata = extractMetadata(METADATA_KEY_VIDEO_ROTATION);
            if ("90".equals(extractMetadata) || "270".equals(extractMetadata)) {
                str = extractMetadata(METADATA_KEY_VIDEO_HEIGHT);
            } else {
                str = extractMetadata(METADATA_KEY_VIDEO_WIDTH);
            }
            i2 = Integer.valueOf(str).intValue();
        } catch (Exception e2) {
            Log.e(TAG, "can not get video width %s", e2.getMessage());
        }
        AppMethodBeat.o(107623);
        return i2;
    }

    public int getVideoRotation() {
        int i2 = 0;
        AppMethodBeat.i(107624);
        try {
            i2 = Integer.valueOf(extractMetadata(METADATA_KEY_VIDEO_ROTATION)).intValue();
        } catch (Exception e2) {
            Log.e(TAG, "can not get video rotation. %s", e2.getMessage());
        }
        AppMethodBeat.o(107624);
        return i2;
    }

    public int getVideoHeight() {
        String str;
        int i2 = 0;
        AppMethodBeat.i(107625);
        try {
            String extractMetadata = extractMetadata(METADATA_KEY_VIDEO_ROTATION);
            if ("90".equals(extractMetadata) || "270".equals(extractMetadata)) {
                str = extractMetadata(METADATA_KEY_VIDEO_WIDTH);
            } else {
                str = extractMetadata(METADATA_KEY_VIDEO_HEIGHT);
            }
            Log.d(TAG, "video height %s rotate %s", str, extractMetadata);
            i2 = Integer.valueOf(str).intValue();
        } catch (Exception e2) {
            Log.e(TAG, "can not get video height %s", e2.getMessage());
        }
        AppMethodBeat.o(107625);
        return i2;
    }

    public byte[] getScaledFrameAtTimeUndecoded(long j2, int i2, int i3) {
        AppMethodBeat.i(107626);
        byte[] _getScaledFrameAtTime = _getScaledFrameAtTime(j2, 2, i2, i3);
        AppMethodBeat.o(107626);
        return _getScaledFrameAtTime;
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        AppMethodBeat.i(107627);
        try {
            native_finalize();
        } catch (Exception e2) {
            Log.e(TAG, "do nothing");
        } finally {
            super.finalize();
            AppMethodBeat.o(107627);
        }
    }

    public class a {
        HashMap<String, String> zxY;

        public a() {
        }
    }
}

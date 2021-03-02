package com.tencent.mm.plugin.game.media;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.LinkedList;

public final class j {
    private static Object lock = new Object();
    private static j xBj;
    ContentResolver hwt = MMApplicationContext.getContext().getContentResolver();

    static {
        AppMethodBeat.i(41033);
        AppMethodBeat.o(41033);
    }

    public static j dUp() {
        AppMethodBeat.i(41029);
        if (xBj == null) {
            synchronized (lock) {
                try {
                    if (xBj == null) {
                        xBj = new j();
                    }
                } catch (Throwable th) {
                    AppMethodBeat.o(41029);
                    throw th;
                }
            }
        }
        j jVar = xBj;
        AppMethodBeat.o(41029);
        return jVar;
    }

    private j() {
        AppMethodBeat.i(41030);
        AppMethodBeat.o(41030);
    }

    public static Uri dUq() {
        return MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
    }

    public static String[] getProjection() {
        return new String[]{"_data", "datetaken", "date_modified", FFmpegMetadataRetriever.METADATA_KEY_DURATION, "description", "mime_type", "title", "_size", "bucket_display_name"};
    }

    public static String a(LinkedList<String> linkedList, long j2, long j3) {
        String sb;
        AppMethodBeat.i(41031);
        Object[] objArr = new Object[6];
        objArr[0] = "bucket_display_name";
        if (Util.isNullOrNil(linkedList)) {
            sb = "()";
        } else {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("(");
            int size = linkedList.size();
            for (int i2 = 0; i2 < size - 1; i2++) {
                sb2.append("'" + linkedList.get(i2) + "'").append(",");
            }
            sb2.append("'" + linkedList.get(size - 1) + "'").append(")");
            sb = sb2.toString();
        }
        objArr[1] = sb;
        objArr[2] = "datetaken";
        objArr[3] = Long.valueOf(j2);
        objArr[4] = "datetaken";
        objArr[5] = Long.valueOf(j3);
        String format = String.format("%s in %s and %s<=%d AND %s>=%d", objArr);
        Log.d("MicroMsg.GameLocalVideoQuery", "where %s", format);
        AppMethodBeat.o(41031);
        return format;
    }

    public static String dUr() {
        return "datetaken desc";
    }

    public final int b(LinkedList<String> linkedList, long j2, long j3) {
        AppMethodBeat.i(41032);
        Cursor query = this.hwt.query(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, new String[]{"_id"}, a(linkedList, j2, j3), null, null);
        if (query == null || !query.moveToNext()) {
            AppMethodBeat.o(41032);
            return 0;
        }
        int i2 = query.getInt(0);
        query.close();
        AppMethodBeat.o(41032);
        return i2;
    }
}

package com.tencent.mm.plugin.gallery.a;

import android.media.MediaMetadataRetriever;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.media.k;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.plugin.sight.base.a;
import com.tencent.mm.plugin.sight.base.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\b"}, hxF = {"Lcom/tencent/mm/plugin/gallery/utils/MediaUtil;", "", "()V", "TAG", "", k.NAME, "Lcom/tencent/mm/plugin/sight/base/MediaInfo;", "filePath", "plugin-gallery_release"})
public final class c {
    private static final String TAG = TAG;
    public static final c xsz = new c();

    static {
        AppMethodBeat.i(165053);
        AppMethodBeat.o(165053);
    }

    private c() {
    }

    public static a awl(String str) {
        AppMethodBeat.i(165052);
        if (TextUtils.isEmpty(str)) {
            a aVar = new a();
            AppMethodBeat.o(165052);
            return aVar;
        }
        a aNx = e.aNx(str);
        if (aNx == null) {
            aNx = new a();
        }
        if (aNx.height <= 0 || aNx.width <= 0) {
            try {
                MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                mediaMetadataRetriever.setDataSource(str);
                aNx.width = Util.getInt(mediaMetadataRetriever.extractMetadata(18), 0);
                aNx.height = Util.getInt(mediaMetadataRetriever.extractMetadata(19), 0);
                aNx.videoBitrate = Util.getInt(mediaMetadataRetriever.extractMetadata(20), 0);
                aNx.videoDuration = Util.getInt(mediaMetadataRetriever.extractMetadata(9), 0);
                mediaMetadataRetriever.release();
            } catch (Exception e2) {
            }
        }
        int mp4RotateVFS = SightVideoJNI.getMp4RotateVFS(str);
        Log.i(TAG, "width %d, height %d, rotate %d", Integer.valueOf(aNx.width), Integer.valueOf(aNx.height), Integer.valueOf(mp4RotateVFS));
        if (mp4RotateVFS == 270 || mp4RotateVFS == 90) {
            int i2 = aNx.height;
            aNx.height = aNx.width;
            aNx.width = i2;
        }
        AppMethodBeat.o(165052);
        return aNx;
    }
}

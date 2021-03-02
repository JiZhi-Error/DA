package com.tencent.mm.plugin.emojicapture.model;

import android.media.MediaFormat;
import com.facebook.internal.FacebookRequestErrorClassification;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.i.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.s;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\b"}, hxF = {"Lcom/tencent/mm/plugin/emojicapture/model/EmojiCaptureUtil;", "", "()V", "TAG", "", "checkVideoValid", "", "videoPath", "plugin-emojicapture_release"})
public final class f {
    private static final String TAG = TAG;
    public static final f roC = new f();

    static {
        AppMethodBeat.i(FacebookRequestErrorClassification.EC_INVALID_TOKEN);
        AppMethodBeat.o(FacebookRequestErrorClassification.EC_INVALID_TOKEN);
    }

    private f() {
    }

    public static boolean anm(String str) {
        String string;
        AppMethodBeat.i(189);
        p.h(str, "videoPath");
        if (s.boW(str) <= 0) {
            AppMethodBeat.o(189);
            return false;
        }
        c cVar = new c();
        try {
            cVar.setDataSource(str);
            if (cVar.getTrackCount() <= 0) {
                try {
                    cVar.release();
                } catch (Exception e2) {
                    Log.printErrStackTrace(TAG, e2, "checkVideoValid, release extractor error", new Object[0]);
                }
                AppMethodBeat.o(189);
                return false;
            }
            int trackCount = cVar.getTrackCount();
            for (int i2 = 0; i2 < trackCount; i2++) {
                MediaFormat trackFormat = cVar.getTrackFormat(i2);
                p.g(trackFormat, "extractor.getTrackFormat(i)");
                if (trackFormat != null && trackFormat.containsKey("mime") && (string = trackFormat.getString("mime")) != null && n.a((CharSequence) string, (CharSequence) "video", false)) {
                    try {
                        cVar.release();
                    } catch (Exception e3) {
                        Log.printErrStackTrace(TAG, e3, "checkVideoValid, release extractor error", new Object[0]);
                    }
                    AppMethodBeat.o(189);
                    return true;
                }
            }
            try {
                cVar.release();
            } catch (Exception e4) {
                Log.printErrStackTrace(TAG, e4, "checkVideoValid, release extractor error", new Object[0]);
            }
            AppMethodBeat.o(189);
            return false;
        } catch (Exception e5) {
            Log.printErrStackTrace(TAG, e5, "checkVideoValid error", new Object[0]);
            try {
                cVar.release();
            } catch (Exception e6) {
                Log.printErrStackTrace(TAG, e6, "checkVideoValid, release extractor error", new Object[0]);
            }
        } catch (Throwable th) {
            try {
                cVar.release();
            } catch (Exception e7) {
                Log.printErrStackTrace(TAG, e7, "checkVideoValid, release extractor error", new Object[0]);
            }
            AppMethodBeat.o(189);
            throw th;
        }
    }
}

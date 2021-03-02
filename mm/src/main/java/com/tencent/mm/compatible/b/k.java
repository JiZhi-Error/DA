package com.tencent.mm.compatible.b;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.IOException;
import java.util.Map;

public final class k extends MediaPlayer {
    public k() {
        AppMethodBeat.i(155617);
        g.os(hashCode());
        AppMethodBeat.o(155617);
    }

    public static k f(Context context, Uri uri) {
        AppMethodBeat.i(155618);
        try {
            k kVar = new k();
            kVar.setDataSource(context, uri);
            kVar.prepare();
            AppMethodBeat.o(155618);
            return kVar;
        } catch (IOException e2) {
            Log.d("MicroMsg.MediaPlayerWrapper", "create failed:", e2);
            AppMethodBeat.o(155618);
            return null;
        } catch (IllegalArgumentException e3) {
            Log.d("MicroMsg.MediaPlayerWrapper", "create failed:", e3);
            AppMethodBeat.o(155618);
            return null;
        } catch (SecurityException e4) {
            Log.d("MicroMsg.MediaPlayerWrapper", "create failed:", e4);
            AppMethodBeat.o(155618);
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x002a  */
    @Override // android.media.MediaPlayer
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void setDataSource(java.lang.String r6) {
        /*
        // Method dump skipped, instructions count: 111
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.compatible.b.k.setDataSource(java.lang.String):void");
    }

    @Override // android.media.MediaPlayer
    public final void setDataSource(Context context, Uri uri) {
        AppMethodBeat.i(155620);
        if (d.oD(26)) {
            setDataSource(context, uri, null, null);
            AppMethodBeat.o(155620);
            return;
        }
        setDataSource(context, uri, (Map<String, String>) null);
        AppMethodBeat.o(155620);
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x005a  */
    @Override // android.media.MediaPlayer
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void setDataSource(android.content.Context r6, android.net.Uri r7, java.util.Map<java.lang.String, java.lang.String> r8) {
        /*
        // Method dump skipped, instructions count: 122
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.compatible.b.k.setDataSource(android.content.Context, android.net.Uri, java.util.Map):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x004b  */
    @Override // android.media.MediaPlayer
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void setDataSource(android.content.Context r6, android.net.Uri r7, java.util.Map<java.lang.String, java.lang.String> r8, java.util.List<java.net.HttpCookie> r9) {
        /*
        // Method dump skipped, instructions count: 107
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.compatible.b.k.setDataSource(android.content.Context, android.net.Uri, java.util.Map, java.util.List):void");
    }

    public final void release() {
        AppMethodBeat.i(155623);
        super.release();
        g.ot(hashCode());
        AppMethodBeat.o(155623);
    }
}

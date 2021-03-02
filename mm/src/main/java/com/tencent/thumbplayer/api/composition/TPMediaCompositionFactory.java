package com.tencent.thumbplayer.api.composition;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.thumbplayer.c.a;
import com.tencent.thumbplayer.c.b;
import com.tencent.thumbplayer.c.d;
import com.tencent.thumbplayer.c.e;
import com.tencent.thumbplayer.c.g;
import java.util.List;

public class TPMediaCompositionFactory {
    public static ITPMediaComposition createMediaComposition() {
        AppMethodBeat.i(189073);
        b bVar = new b();
        AppMethodBeat.o(189073);
        return bVar;
    }

    public static ITPMediaTrack createMediaTrack(int i2) {
        AppMethodBeat.i(189074);
        d dVar = new d(i2);
        AppMethodBeat.o(189074);
        return dVar;
    }

    public static ITPMediaTrack createMediaTrack(int i2, ITPMediaTrackClip... iTPMediaTrackClipArr) {
        AppMethodBeat.i(189075);
        d dVar = new d(i2);
        for (ITPMediaTrackClip iTPMediaTrackClip : iTPMediaTrackClipArr) {
            dVar.addTrackClip(iTPMediaTrackClip);
        }
        AppMethodBeat.o(189075);
        return dVar;
    }

    public static ITPMediaTrack createMediaTrack(int i2, List<ITPMediaTrackClip> list) {
        AppMethodBeat.i(189076);
        d dVar = new d(i2);
        for (ITPMediaTrackClip iTPMediaTrackClip : list) {
            dVar.addTrackClip(iTPMediaTrackClip);
        }
        AppMethodBeat.o(189076);
        return dVar;
    }

    public static ITPMediaTrackClip createEmptyTrackClip(int i2, long j2, long j3) {
        AppMethodBeat.i(189077);
        a aVar = new a(i2);
        aVar.setCutTimeRange(j2, j3);
        AppMethodBeat.o(189077);
        return aVar;
    }

    public static ITPMediaTrackClip createMediaTrackClip(String str, int i2) {
        AppMethodBeat.i(189078);
        e eVar = new e(str, i2);
        AppMethodBeat.o(189078);
        return eVar;
    }

    public static ITPMediaTrackClip createMediaTrackClip(String str, int i2, long j2, long j3) {
        AppMethodBeat.i(189079);
        e eVar = new e(str, i2, j2, j3);
        AppMethodBeat.o(189079);
        return eVar;
    }

    public static ITPMediaDRMAsset createMediaDRMAsset(int i2, String str) {
        AppMethodBeat.i(189080);
        g gVar = new g(i2, str);
        AppMethodBeat.o(189080);
        return gVar;
    }
}

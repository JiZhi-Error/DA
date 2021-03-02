package com.tencent.mm.plugin.recordvideo.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000bJ\u0006\u0010\f\u001a\u00020\bJ\u001e\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u0012"}, hxF = {"Lcom/tencent/mm/plugin/recordvideo/report/StoryRemuxIDKeyStat;", "", "()V", "ID", "", "TAG", "", "markCreateThumbFailed", "", "markRemuxProcessType", "isForeground", "", "markStoryRemuxHitBitrateExceed", "markStoryRemuxResult", "isLocalCapture", FFmpegMetadataRetriever.METADATA_KEY_VARIANT_BITRATE, "", "fps", "plugin-recordvideo_release"})
public final class f {
    public static final f BXU = new f();

    static {
        AppMethodBeat.i(75856);
        AppMethodBeat.o(75856);
    }

    private f() {
    }

    public static void to(boolean z) {
        AppMethodBeat.i(75853);
        Log.i("MicroMsg.StoryRemuxIDKeyStat", "markRemuxProcessType, isForeground:".concat(String.valueOf(z)));
        if (z) {
            h.INSTANCE.n(986, 5, 1);
            AppMethodBeat.o(75853);
            return;
        }
        h.INSTANCE.n(986, 6, 1);
        AppMethodBeat.o(75853);
    }

    public static void eLe() {
        AppMethodBeat.i(75854);
        Log.i("MicroMsg.StoryRemuxIDKeyStat", "markCreateThumbFailed");
        h.INSTANCE.n(986, 9, 1);
        AppMethodBeat.o(75854);
    }

    public static void j(boolean z, int i2, int i3) {
        AppMethodBeat.i(75855);
        Log.i("MicroMsg.StoryRemuxIDKeyStat", "markStoryRemuxResult, isLocalCapture:" + z + ", bitrate:" + i2 + ", fps:" + i3);
        if (z) {
            h.INSTANCE.n(986, 56, 1);
            h.INSTANCE.n(986, 60, (long) i2);
            h.INSTANCE.n(986, 63, (long) i3);
            AppMethodBeat.o(75855);
            return;
        }
        h.INSTANCE.n(986, 57, 1);
        h.INSTANCE.n(986, 66, (long) i2);
        h.INSTANCE.n(986, 69, (long) i3);
        AppMethodBeat.o(75855);
    }
}

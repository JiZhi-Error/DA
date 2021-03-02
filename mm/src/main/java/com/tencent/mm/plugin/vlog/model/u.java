package com.tencent.mm.plugin.vlog.model;

import android.media.MediaFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\u001a\u001a\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0001\u001a\u001a\u0010\u0006\u001a\u00020\u0007*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0007¨\u0006\b"}, hxF = {"getInteger", "", "Landroid/media/MediaFormat;", "name", "", "defaultValue", "getLong", "", "plugin-vlog_release"})
public final class u {
    public static final int c(MediaFormat mediaFormat, String str, int i2) {
        AppMethodBeat.i(190590);
        p.h(mediaFormat, "$this$getInteger");
        p.h(str, "name");
        if (mediaFormat.containsKey(str)) {
            int integer = mediaFormat.getInteger(str);
            AppMethodBeat.o(190590);
            return integer;
        }
        AppMethodBeat.o(190590);
        return i2;
    }
}

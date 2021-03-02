package com.tencent.mm.plugin.appbrand.canvas.action;

import android.graphics.Canvas;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.DrawActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.RotateActionArg;
import com.tencent.mm.plugin.appbrand.canvas.d;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import org.json.JSONArray;

public final class n implements d {
    @Override // com.tencent.mm.plugin.appbrand.canvas.action.d
    public final BaseDrawActionArg bzj() {
        AppMethodBeat.i(144903);
        RotateActionArg rotateActionArg = new RotateActionArg();
        AppMethodBeat.o(144903);
        return rotateActionArg;
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.d
    public final String getMethod() {
        return FFmpegMetadataRetriever.METADATA_KEY_VIDEO_ROTATION;
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.d
    public final boolean a(d dVar, Canvas canvas, JSONArray jSONArray) {
        AppMethodBeat.i(144904);
        if (jSONArray.length() <= 0) {
            AppMethodBeat.o(144904);
            return false;
        }
        boolean a2 = a(canvas, (float) jSONArray.optDouble(0));
        AppMethodBeat.o(144904);
        return a2;
    }

    private static boolean a(Canvas canvas, float f2) {
        AppMethodBeat.i(144905);
        canvas.rotate((float) ((((double) f2) / 3.141592653589793d) * 180.0d));
        AppMethodBeat.o(144905);
        return true;
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.d
    public final boolean a(d dVar, Canvas canvas, DrawActionArg drawActionArg) {
        AppMethodBeat.i(144906);
        RotateActionArg rotateActionArg = (RotateActionArg) drawActionArg;
        if (rotateActionArg == null) {
            AppMethodBeat.o(144906);
            return false;
        }
        boolean a2 = a(canvas, rotateActionArg.degrees);
        AppMethodBeat.o(144906);
        return a2;
    }
}

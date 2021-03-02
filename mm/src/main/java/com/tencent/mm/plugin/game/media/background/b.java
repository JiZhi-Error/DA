package com.tencent.mm.plugin.game.media.background;

import android.database.Cursor;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.api.d;
import com.tencent.mm.plugin.game.api.f;
import com.tencent.mm.plugin.game.media.e;
import com.tencent.mm.plugin.game.media.g;
import com.tencent.mm.plugin.recordvideo.background.c;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager;
import com.tencent.mm.protocal.protobuf.ald;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;

public final class b implements com.tencent.mm.plugin.recordvideo.background.b {
    @Override // com.tencent.mm.plugin.recordvideo.background.b
    public final void aAd(String str) {
        AppMethodBeat.i(41210);
        Log.i("MicroMsg.Haowan.VideoMixCallback", "onInit, taskId:%s", str);
        AppMethodBeat.o(41210);
    }

    @Override // com.tencent.mm.plugin.recordvideo.background.b
    public final void eh(String str, int i2) {
        AppMethodBeat.i(41211);
        Log.i("MicroMsg.Haowan.VideoMixCallback", "onRun, taskId:%s, runNum:%d", str, Integer.valueOf(i2));
        AppMethodBeat.o(41211);
    }

    @Override // com.tencent.mm.plugin.recordvideo.background.b
    public final void aAe(String str) {
        AppMethodBeat.i(41212);
        Log.i("MicroMsg.Haowan.VideoMixCallback", "onWait, taskId:%s", str);
        AppMethodBeat.o(41212);
    }

    @Override // com.tencent.mm.plugin.recordvideo.background.b
    public final void a(String str, boolean z, CaptureDataManager.CaptureVideoNormalModel captureVideoNormalModel) {
        Bundle aLl;
        e eVar;
        AppMethodBeat.i(41213);
        Log.i("MicroMsg.Haowan.VideoMixCallback", "onFinish, taskId:%s, success:%b, model:%s", str, Boolean.valueOf(z), captureVideoNormalModel);
        if (str == null) {
            AppMethodBeat.o(41213);
            return;
        }
        com.tencent.mm.plugin.recordvideo.background.e eVar2 = com.tencent.mm.plugin.recordvideo.background.e.BKp;
        p.h(str, "taskId");
        c aLf = com.tencent.mm.plugin.recordvideo.background.e.aLf(str);
        if (aLf == null) {
            aLl = new Bundle();
        } else {
            String str2 = aLf.field_userData;
            p.g(str2, "videoEditData.field_userData");
            aLl = com.tencent.mm.plugin.recordvideo.background.e.aLl(str2);
        }
        if (aLl.getInt("key_game_haowan_flag", 0) != 10) {
            Log.i("MicroMsg.Haowan.VideoMixCallback", "not game haowan task");
            AppMethodBeat.o(41213);
            return;
        }
        a.a(captureVideoNormalModel, aLl);
        if (z && captureVideoNormalModel != null) {
            com.tencent.mm.plugin.recordvideo.background.e eVar3 = com.tencent.mm.plugin.recordvideo.background.e.BKp;
            ald aLk = com.tencent.mm.plugin.recordvideo.background.e.aLk(str);
            if (aLk != null) {
                a.a(aLk.BOA, captureVideoNormalModel);
                a.b(aLk.Lue, captureVideoNormalModel);
            }
        }
        g dSN = ((f) com.tencent.mm.kernel.g.af(f.class)).dSN();
        String format = String.format("select * from %s where %s=\"%s\"", "GameHaowanPublishEdition", "bgMixTaskId", str);
        Log.i("MicroMsg.Haowan.GameHaowanPublishStorage", "queryTaskByBgMixId, sql : %s", format);
        Cursor rawQuery = dSN.rawQuery(format, new String[0]);
        if (rawQuery == null) {
            eVar = null;
        } else {
            e eVar4 = null;
            if (rawQuery.moveToNext()) {
                eVar4 = new e();
                eVar4.convertFrom(rawQuery);
            }
            rawQuery.close();
            eVar = eVar4;
        }
        if (eVar == null) {
            Log.i("MicroMsg.Haowan.VideoMixCallback", "no perform publish action");
            AppMethodBeat.o(41213);
        } else if (eVar.field_publishState == 2) {
            Log.i("MicroMsg.Haowan.VideoMixCallback", "publish has finished");
            AppMethodBeat.o(41213);
        } else {
            ((d) com.tencent.mm.kernel.g.af(d.class)).azm(eVar.field_taskId);
            AppMethodBeat.o(41213);
        }
    }
}

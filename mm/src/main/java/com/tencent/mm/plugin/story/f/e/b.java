package com.tencent.mm.plugin.story.f.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recordvideo.background.c;
import com.tencent.mm.plugin.recordvideo.background.e;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager;
import com.tencent.mm.protocal.protobuf.ald;
import com.tencent.mm.protocal.protobuf.eds;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\"\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\u0010\u0010\f\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0004H\u0016J\u0018\u0010\r\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0004H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0011"}, hxF = {"Lcom/tencent/mm/plugin/story/model/mix/VLogMixManager;", "Lcom/tencent/mm/plugin/recordvideo/background/IBgMixCallback;", "()V", "TAG", "", "onFinish", "", "taskId", "success", "", "model", "Lcom/tencent/mm/plugin/recordvideo/jumper/CaptureDataManager$CaptureVideoNormalModel;", "onInit", "onRun", "runNum", "", "onWait", "plugin-story_release"})
public final class b implements com.tencent.mm.plugin.recordvideo.background.b {
    public static final b Fps = new b();

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", "storyLocalId", "", "invoke"})
    static final class a extends q implements kotlin.g.a.b<Integer, x> {
        final /* synthetic */ String BKc;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(String str) {
            super(1);
            this.BKc = str;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(Integer num) {
            AppMethodBeat.i(118966);
            int intValue = num.intValue();
            a aVar = a.Fpl;
            a.foZ().put(Integer.valueOf(intValue), this.BKc);
            a aVar2 = a.Fpl;
            a.fpa();
            x xVar = x.SXb;
            AppMethodBeat.o(118966);
            return xVar;
        }
    }

    static {
        AppMethodBeat.i(118971);
        AppMethodBeat.o(118971);
    }

    private b() {
    }

    @Override // com.tencent.mm.plugin.recordvideo.background.b
    public final void aAd(String str) {
        String str2;
        String str3;
        AppMethodBeat.i(118967);
        p.h(str, "taskId");
        Log.i("MicroMsg.VLogMixManager", "onInit, taskId:".concat(String.valueOf(str)));
        e eVar = e.BKp;
        c aLf = e.aLf(str);
        if (aLf == null) {
            AppMethodBeat.o(118967);
            return;
        }
        ald eIK = aLf.eIK();
        if (eIK == null || (str3 = eIK.BOA) == null) {
            str2 = "";
        } else {
            str2 = str3;
        }
        new com.tencent.mm.ac.c("runMixInBackground");
        a aVar = a.Fpl;
        a.a(aLf, str2, new eds(), new a(str));
        AppMethodBeat.o(118967);
    }

    @Override // com.tencent.mm.plugin.recordvideo.background.b
    public final void eh(String str, int i2) {
        AppMethodBeat.i(118968);
        p.h(str, "taskId");
        Log.i("MicroMsg.VLogMixManager", "onRun, taskId:" + str + " runNum:" + i2 + ' ');
        AppMethodBeat.o(118968);
    }

    @Override // com.tencent.mm.plugin.recordvideo.background.b
    public final void aAe(String str) {
        AppMethodBeat.i(118969);
        p.h(str, "taskId");
        AppMethodBeat.o(118969);
    }

    @Override // com.tencent.mm.plugin.recordvideo.background.b
    public final void a(String str, boolean z, CaptureDataManager.CaptureVideoNormalModel captureVideoNormalModel) {
        AppMethodBeat.i(118970);
        p.h(str, "taskId");
        Log.i("MicroMsg.VLogMixManager", "onFinish, taskId:" + str + " success:" + z + " model:" + captureVideoNormalModel);
        a.Fpl.a(str, z, captureVideoNormalModel);
        com.tencent.mm.plugin.recordvideo.e.c cVar = com.tencent.mm.plugin.recordvideo.e.c.Cic;
        com.tencent.mm.plugin.recordvideo.e.c.c(captureVideoNormalModel);
        AppMethodBeat.o(118970);
    }
}

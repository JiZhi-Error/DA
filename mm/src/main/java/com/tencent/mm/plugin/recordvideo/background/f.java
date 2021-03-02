package com.tencent.mm.plugin.recordvideo.background;

import android.os.Process;
import android.text.TextUtils;
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.e;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.loader.g.a.g;
import com.tencent.mm.loader.g.j;
import com.tencent.mm.plugin.recordvideo.background.c;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager;
import com.tencent.mm.plugin.recordvideo.jumper.RecordMediaReportInfo;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.protocal.protobuf.aio;
import com.tencent.mm.protocal.protobuf.ald;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.s;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.g.a.r;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.g.b.z;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002 !B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J*\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\n2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0002J\u0006\u0010\u001b\u001a\u00020\u0010J\u0006\u0010\u001c\u001a\u00020\nJ\u001a\u0010\u001c\u001a\u00020\n2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aJ\u0016\u0010\u001f\u001a\u00020\u00102\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bXT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013X\u000e¢\u0006\u0002\n\u0000¨\u0006\""}, hxF = {"Lcom/tencent/mm/plugin/recordvideo/background/VideoMixHandler;", "", "()V", "LOOP_WAIT_TIME", "", "MAX_RETRY_TIME", "", "TAG", "", "isRunning", "", "mixQueue", "Lcom/tencent/mm/loader/loader/LoaderCore;", "Lcom/tencent/mm/plugin/recordvideo/background/VideoMixHandler$MixTask;", "onCallback", "Lkotlin/Function0;", "", "stopFlag", "waitTaskList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/recordvideo/background/VideoMixHandler$WaitTask;", "performCallback", "scene", "taskId", "success", "model", "Lcom/tencent/mm/plugin/recordvideo/jumper/CaptureDataManager$CaptureVideoNormalModel;", "resumeBgMix", "startBgMix", "videoEditorData", "Lcom/tencent/mm/plugin/recordvideo/background/VideoEditData;", "stopBgMix", "MixTask", "WaitTask", "plugin-recordvideo_release"})
public final class f {
    private static boolean BKt;
    private static ArrayList<b> BKu = new ArrayList<>();
    private static kotlin.g.a.a<x> BKv;
    public static final f BKw = new f();
    private static boolean isRunning;
    private static com.tencent.mm.loader.g.d<a> rpP = new com.tencent.mm.loader.g.d<>(new com.tencent.mm.loader.g.a.f(new com.tencent.mm.loader.g.a.a(5), new g(1, (byte) 0), 1, "videoMixTask"));

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class d extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ b BKD;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(b bVar) {
            super(0);
            this.BKD = bVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* bridge */ /* synthetic */ x invoke() {
            return x.SXb;
        }
    }

    static {
        AppMethodBeat.i(75235);
        AppMethodBeat.o(75235);
    }

    private f() {
    }

    public static boolean eIX() {
        AppMethodBeat.i(75231);
        e eVar = e.BKp;
        c eIV = e.eIV();
        if (eIV != null) {
            boolean a2 = a(eIV, null);
            AppMethodBeat.o(75231);
            return a2;
        }
        Log.d("MicroMsg.mix_background.VideoMixHandler", "mix task is empty");
        AppMethodBeat.o(75231);
        return false;
    }

    public static void V(kotlin.g.a.a<x> aVar) {
        AppMethodBeat.i(75232);
        Log.i("MicroMsg.mix_background.VideoMixHandler", "VideoMixHandler stopBgMix!");
        BKv = aVar;
        BKt = true;
        Iterator<T> it = BKu.iterator();
        while (it.hasNext()) {
            d dVar = new d(it.next());
            p.h(dVar, "block");
            MMHandlerThread.removeRunnable(new e(dVar));
        }
        BKu.clear();
        if (!isRunning) {
            kotlin.g.a.a<x> aVar2 = BKv;
            if (aVar2 != null) {
                aVar2.invoke();
            }
            BKv = null;
        }
        AppMethodBeat.o(75232);
    }

    public static void eIY() {
        AppMethodBeat.i(75233);
        Log.i("MicroMsg.mix_background.VideoMixHandler", "VideoMixHandler resumeBgMix!");
        BKt = false;
        BKv = null;
        eIX();
        AppMethodBeat.o(75233);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, hxF = {"com/tencent/mm/plugin/recordvideo/background/VideoMixHandler$startBgMix$3$1", "Lcom/tencent/mm/loader/loader/LoaderCoreCallback;", "Lcom/tencent/mm/plugin/recordvideo/background/VideoMixHandler$MixTask;", "onLoaderFin", "", "task", "status", "Lcom/tencent/mm/loader/loader/WorkStatus;", "plugin-recordvideo_release"})
    public static final class c implements com.tencent.mm.loader.g.f<a> {

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
        static final class a extends q implements kotlin.g.a.a<x> {
            final /* synthetic */ z.f BKC;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(z.f fVar) {
                super(0);
                this.BKC = fVar;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* bridge */ /* synthetic */ x invoke() {
                return x.SXb;
            }
        }

        c() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.loader.g.c, com.tencent.mm.loader.g.j] */
        /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // com.tencent.mm.loader.g.f
        public final /* synthetic */ void a(a aVar, j jVar) {
            AppMethodBeat.i(75230);
            a aVar2 = aVar;
            p.h(aVar2, "task");
            p.h(jVar, "status");
            Log.i("MicroMsg.mix_background.VideoMixHandler", "loader finish! taskId:" + aVar2.BKx.field_taskId + ", status " + jVar);
            f fVar = f.BKw;
            f.isRunning = false;
            f fVar2 = f.BKw;
            kotlin.g.a.a aVar3 = f.BKv;
            if (aVar3 != null) {
                aVar3.invoke();
            }
            f fVar3 = f.BKw;
            f.BKv = null;
            switch (g.$EnumSwitchMapping$0[jVar.ordinal()]) {
                case 1:
                    f fVar4 = f.BKw;
                    int i2 = aVar2.BKx.field_fromScene;
                    String str = aVar2.BKx.field_taskId;
                    p.g(str, "task.editorData.field_taskId");
                    f.b(i2, str, true, aVar2.BKy);
                    f fVar5 = f.BKw;
                    f.eIX();
                    AppMethodBeat.o(75230);
                    return;
                case 2:
                    a aVar4 = a.BKb;
                    int i3 = aVar2.BKx.field_fromScene;
                    String str2 = aVar2.BKx.field_taskId;
                    p.g(str2, "task.editorData.field_taskId");
                    a.bU(i3, str2);
                    z.f fVar6 = new z.f();
                    String str3 = aVar2.BKx.field_taskId;
                    p.g(str3, "task.editorData.field_taskId");
                    fVar6.SYG = (T) new b(str3, aVar2.BKy);
                    f fVar7 = f.BKw;
                    f.BKu.add(fVar6.SYG);
                    com.tencent.mm.ac.d.a(30000, new a(fVar6));
                    AppMethodBeat.o(75230);
                    return;
                case 3:
                    f fVar8 = f.BKw;
                    int i4 = aVar2.BKx.field_fromScene;
                    String str4 = aVar2.BKx.field_taskId;
                    p.g(str4, "task.editorData.field_taskId");
                    f.b(i4, str4, false, aVar2.BKy);
                    f fVar9 = f.BKw;
                    f.eIX();
                    break;
            }
            AppMethodBeat.o(75230);
        }
    }

    public static boolean a(c cVar, CaptureDataManager.CaptureVideoNormalModel captureVideoNormalModel) {
        AppMethodBeat.i(75234);
        if (cVar != null) {
            Log.i("MicroMsg.mix_background.VideoMixHandler", "start background mix, taskId:" + cVar.field_taskId + ", reyTime:" + cVar.field_mixRetryTime);
            rpP.a(new a(cVar, captureVideoNormalModel), new c());
            AppMethodBeat.o(75234);
        } else {
            AppMethodBeat.o(75234);
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u000f\u001a\u00020\u0010H\u0016R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0011"}, hxF = {"Lcom/tencent/mm/plugin/recordvideo/background/VideoMixHandler$WaitTask;", "Ljava/lang/Runnable;", "taskId", "", "model", "Lcom/tencent/mm/plugin/recordvideo/jumper/CaptureDataManager$CaptureVideoNormalModel;", "(Ljava/lang/String;Lcom/tencent/mm/plugin/recordvideo/jumper/CaptureDataManager$CaptureVideoNormalModel;)V", "getModel", "()Lcom/tencent/mm/plugin/recordvideo/jumper/CaptureDataManager$CaptureVideoNormalModel;", "setModel", "(Lcom/tencent/mm/plugin/recordvideo/jumper/CaptureDataManager$CaptureVideoNormalModel;)V", "getTaskId", "()Ljava/lang/String;", "setTaskId", "(Ljava/lang/String;)V", "run", "", "plugin-recordvideo_release"})
    public static final class b implements Runnable {
        private CaptureDataManager.CaptureVideoNormalModel BKy;
        private String taskId;

        public b(String str, CaptureDataManager.CaptureVideoNormalModel captureVideoNormalModel) {
            p.h(str, "taskId");
            AppMethodBeat.i(75228);
            this.taskId = str;
            this.BKy = captureVideoNormalModel;
            AppMethodBeat.o(75228);
        }

        public final void run() {
            AppMethodBeat.i(75227);
            f fVar = f.BKw;
            f.BKu.remove(this);
            e eVar = e.BKp;
            c aLf = e.aLf(this.taskId);
            f fVar2 = f.BKw;
            f.a(aLf, this.BKy);
            AppMethodBeat.o(75227);
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\u0012\u0010\u0013\u001a\u00020\u00122\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0002J\u0010\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\b\u0010\u0019\u001a\u00020\u0018H\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a"}, hxF = {"Lcom/tencent/mm/plugin/recordvideo/background/VideoMixHandler$MixTask;", "Lcom/tencent/mm/loader/loader/IWorkTask;", "editorData", "Lcom/tencent/mm/plugin/recordvideo/background/VideoEditData;", "model", "Lcom/tencent/mm/plugin/recordvideo/jumper/CaptureDataManager$CaptureVideoNormalModel;", "(Lcom/tencent/mm/plugin/recordvideo/background/VideoEditData;Lcom/tencent/mm/plugin/recordvideo/jumper/CaptureDataManager$CaptureVideoNormalModel;)V", "getEditorData", "()Lcom/tencent/mm/plugin/recordvideo/background/VideoEditData;", "setEditorData", "(Lcom/tencent/mm/plugin/recordvideo/background/VideoEditData;)V", "getModel", "()Lcom/tencent/mm/plugin/recordvideo/jumper/CaptureDataManager$CaptureVideoNormalModel;", "setModel", "(Lcom/tencent/mm/plugin/recordvideo/jumper/CaptureDataManager$CaptureVideoNormalModel;)V", "startPerformance", "", "call", "", "runMix", "extraConfig", "Lcom/tencent/mm/protocal/protobuf/ExtraConfig;", "setMoovHead", "path", "", "uniqueId", "plugin-recordvideo_release"})
    public static final class a extends com.tencent.mm.loader.g.c {
        c BKx;
        CaptureDataManager.CaptureVideoNormalModel BKy;
        int gsi;

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\n¢\u0006\u0002\b\t"}, hxF = {"<anonymous>", "", "mixVideoPath", "", "mixThumbPath", "ret", "", "error", "", "invoke"})
        static final class b extends q implements r<String, String, Boolean, Integer, x> {
            final /* synthetic */ long BKA;
            final /* synthetic */ ald BKB;
            final /* synthetic */ a BKz;
            final /* synthetic */ long qVz;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            b(a aVar, long j2, long j3, ald ald) {
                super(4);
                this.BKz = aVar;
                this.BKA = j2;
                this.qVz = j3;
                this.BKB = ald;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object, java.lang.Object, java.lang.Object] */
            @Override // kotlin.g.a.r
            public final /* synthetic */ x invoke(String str, String str2, Boolean bool, Integer num) {
                AppMethodBeat.i(75223);
                String str3 = str;
                String str4 = str2;
                boolean booleanValue = bool.booleanValue();
                num.intValue();
                p.h(str3, "mixVideoPath");
                p.h(str4, "mixThumbPath");
                Log.i("MicroMsg.mix_background.VideoMixHandler", "mixer task done " + this.BKz.BKx.field_taskId + " ret " + booleanValue + " mixVideoPath " + str3 + " mixThumb " + str4);
                long currentTimeMillis = System.currentTimeMillis() - this.BKA;
                if (this.BKz.gsi != 0) {
                    Log.i("MicroMsg.mix_background.VideoMixHandler", "hardcoder summerPerformance stopPerformance %s", Integer.valueOf(WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcEncodeVideoEnable, this.BKz.gsi)));
                    this.BKz.gsi = 0;
                }
                RecordMediaReportInfo recordMediaReportInfo = new RecordMediaReportInfo();
                recordMediaReportInfo.aLq(this.BKz.BKx.field_reportInfo);
                recordMediaReportInfo.x("KEY_REMUX_VIDEO_COST_MS_INT", Long.valueOf(System.currentTimeMillis() - this.qVz));
                Log.i("MicroMsg.mix_background.VideoMixHandler", "after remux, reportInfo:" + recordMediaReportInfo.eJN());
                this.BKz.BKy = new CaptureDataManager.CaptureVideoNormalModel(Boolean.valueOf(booleanValue), str3, str4, Long.valueOf(this.BKB.duration), Boolean.FALSE, recordMediaReportInfo);
                if (booleanValue) {
                    aio aio = new aio();
                    try {
                        aio.parseFrom(this.BKz.BKx.field_baseItemData);
                    } catch (Exception e2) {
                        Log.printDebugStack("safeParser", "", e2);
                        aio = null;
                    }
                    aio aio2 = aio;
                    if (aio2 != null && this.BKz.BKx.eIJ()) {
                        com.tencent.mm.plugin.recordvideo.d.e eVar = com.tencent.mm.plugin.recordvideo.d.e.BXT;
                        com.tencent.mm.plugin.recordvideo.d.e.tl(aio2.iqf);
                        com.tencent.mm.plugin.recordvideo.d.e eVar2 = com.tencent.mm.plugin.recordvideo.d.e.BXT;
                        com.tencent.mm.plugin.recordvideo.d.e.i(aio2.iqf, currentTimeMillis);
                        com.tencent.mm.plugin.recordvideo.d.e eVar3 = com.tencent.mm.plugin.recordvideo.d.e.BXT;
                        com.tencent.mm.plugin.recordvideo.d.e.aM(this.BKz.BKx.field_mixRetryTime, aio2.iqf);
                    }
                    if (!TextUtils.isEmpty(str3)) {
                        com.tencent.mm.plugin.recordvideo.e.d dVar = com.tencent.mm.plugin.recordvideo.e.d.Cin;
                        Log.i("MicroMsg.mix_background.VideoMixHandler", "videoInfo : ".concat(String.valueOf(com.tencent.mm.plugin.recordvideo.e.d.aLQ(str3))));
                        long currentTicks = Util.currentTicks();
                        SightVideoJNI.optimizeMP4VFS(str3);
                        Log.d("MicroMsg.mix_background.VideoMixHandler", "time cost: " + Util.ticksToNow(currentTicks));
                        com.tencent.mm.plugin.recordvideo.e.c cVar = com.tencent.mm.plugin.recordvideo.e.c.Cic;
                        com.tencent.mm.plugin.recordvideo.e.c.a(this.BKB);
                        s.deleteFile(this.BKz.BKx.field_blurBgPath);
                        this.BKz.a(j.OK);
                        x xVar = x.SXb;
                        AppMethodBeat.o(75223);
                        return xVar;
                    }
                }
                this.BKz.a(j.Wait);
                x xVar2 = x.SXb;
                AppMethodBeat.o(75223);
                return xVar2;
            }
        }

        public a(c cVar, CaptureDataManager.CaptureVideoNormalModel captureVideoNormalModel) {
            p.h(cVar, "editorData");
            AppMethodBeat.i(75226);
            this.BKx = cVar;
            this.BKy = captureVideoNormalModel;
            AppMethodBeat.o(75226);
        }

        @Override // com.tencent.mm.loader.g.c
        public final void call() {
            AppMethodBeat.i(75224);
            f fVar = f.BKw;
            if (f.BKt) {
                Log.i("MicroMsg.mix_background.VideoMixHandler", "running forground task");
                a(j.Wait);
                AppMethodBeat.o(75224);
                return;
            }
            h.RTc.b(new RunnableC1644a(this), "VideoMixHandler");
            AppMethodBeat.o(75224);
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
        /* renamed from: com.tencent.mm.plugin.recordvideo.background.f$a$a  reason: collision with other inner class name */
        static final class RunnableC1644a implements Runnable {
            final /* synthetic */ a BKz;

            RunnableC1644a(a aVar) {
                this.BKz = aVar;
            }

            public final void run() {
                AppMethodBeat.i(75222);
                Log.i("MicroMsg.mix_background.VideoMixHandler", "call background mix " + this.BKz.BKx.field_taskId + ", mixRetryTime:" + this.BKz.BKx.field_mixRetryTime);
                aio aio = new aio();
                try {
                    aio.parseFrom(this.BKz.BKx.field_baseItemData);
                } catch (Exception e2) {
                    Log.printDebugStack("safeParser", "", e2);
                    aio = null;
                }
                aio aio2 = aio;
                if (aio2 != null && this.BKz.BKx.eIJ()) {
                    com.tencent.mm.plugin.recordvideo.d.e eVar = com.tencent.mm.plugin.recordvideo.d.e.BXT;
                    com.tencent.mm.plugin.recordvideo.d.e.tk(aio2.iqf);
                }
                if (this.BKz.BKx.field_mixRetryTime < 3) {
                    e eVar2 = e.BKp;
                    String str = this.BKz.BKx.field_taskId;
                    p.g(str, "editorData.field_taskId");
                    e.aLg(str);
                    if (aio2 != null) {
                        e eVar3 = e.BKp;
                        String str2 = this.BKz.BKx.field_taskId;
                        p.g(str2, "editorData.field_taskId");
                        c aLf = e.aLf(str2);
                        if (aLf != null) {
                            a aVar = this.BKz;
                            p.h(aLf, "<set-?>");
                            aVar.BKx = aLf;
                        }
                    }
                    ald ald = new ald();
                    try {
                        ald.parseFrom(this.BKz.BKx.field_extraConfig);
                    } catch (Exception e3) {
                        Log.printDebugStack("safeParser", "", e3);
                        ald = null;
                    }
                    ald ald2 = ald;
                    a aVar2 = this.BKz;
                    Log.i("MicroMsg.mix_background.VideoMixHandler", "runMix from VideoMixHandler extraConfig:".concat(String.valueOf(ald2)));
                    if (ald2 != null) {
                        com.tencent.mm.plugin.recordvideo.background.c.d dVar = com.tencent.mm.plugin.recordvideo.background.c.d.BMq;
                        com.tencent.mm.plugin.recordvideo.background.c.c b2 = com.tencent.mm.plugin.recordvideo.background.c.d.b(aVar2.BKx, ald2);
                        aVar2.gsi = WXHardCoderJNI.startPerformance(WXHardCoderJNI.hcEncodeVideoEnable, WXHardCoderJNI.hcEncodeVideoDelay, WXHardCoderJNI.hcEncodeVideoCPU, WXHardCoderJNI.hcEncodeVideoIO, WXHardCoderJNI.hcEncodeVideoThr ? Process.myTid() : 0, 35000, 603, WXHardCoderJNI.hcEncodeVideoAction, "MicroMsg.mix_background.VideoMixHandler");
                        Log.i("MicroMsg.mix_background.VideoMixHandler", "hardcoder summerPerformance startPerformance: %s", Integer.valueOf(aVar2.gsi));
                        f fVar = f.BKw;
                        f.isRunning = true;
                        a aVar3 = a.BKb;
                        int i2 = aVar2.BKx.field_fromScene;
                        String str3 = aVar2.BKx.field_taskId;
                        p.g(str3, "editorData.field_taskId");
                        a.p(i2, str3, aVar2.BKx.field_mixRetryTime);
                        long currentTimeMillis = System.currentTimeMillis();
                        long currentTimeMillis2 = System.currentTimeMillis();
                        if (b2 != null) {
                            b2.e(new b(aVar2, currentTimeMillis2, currentTimeMillis, ald2));
                        }
                        if (b2 == null) {
                            if (aVar2.BKx.eIJ()) {
                                com.tencent.mm.plugin.recordvideo.d.e eVar4 = com.tencent.mm.plugin.recordvideo.d.e.BXT;
                                com.tencent.mm.plugin.recordvideo.d.e.eLd();
                            }
                            aVar2.a(j.Fail);
                            AppMethodBeat.o(75222);
                            return;
                        }
                    } else {
                        if (aVar2.BKx.eIJ()) {
                            com.tencent.mm.plugin.recordvideo.d.e eVar5 = com.tencent.mm.plugin.recordvideo.d.e.BXT;
                            com.tencent.mm.plugin.recordvideo.d.e.eLd();
                        }
                        aVar2.a(j.Fail);
                    }
                    AppMethodBeat.o(75222);
                    return;
                }
                Log.i("MicroMsg.mix_background.VideoMixHandler", "retry mix taskId:" + this.BKz.BKx.field_taskId + " third and still failed");
                if (aio2 != null && this.BKz.BKx.eIJ()) {
                    com.tencent.mm.plugin.recordvideo.d.e eVar6 = com.tencent.mm.plugin.recordvideo.d.e.BXT;
                    com.tencent.mm.plugin.recordvideo.d.e.tm(aio2.iqf);
                }
                this.BKz.a(j.Fail);
                AppMethodBeat.o(75222);
            }
        }

        @Override // com.tencent.mm.loader.g.c
        public final String auK() {
            AppMethodBeat.i(75225);
            String str = "mixTask_" + this.BKx.field_taskId;
            AppMethodBeat.o(75225);
            return str;
        }
    }

    public static final /* synthetic */ void b(int i2, String str, boolean z, CaptureDataManager.CaptureVideoNormalModel captureVideoNormalModel) {
        AppMethodBeat.i(75236);
        Log.i("MicroMsg.mix_background.VideoMixHandler", "taskId:" + str + ", success:" + z + ", model:" + captureVideoNormalModel);
        if (z) {
            e eVar = e.BKp;
            c.b bVar = c.b.BKk;
            e.fk(str, c.b.bTk());
        } else {
            e eVar2 = e.BKp;
            c.b bVar2 = c.b.BKk;
            e.fk(str, c.b.eIP());
        }
        if (captureVideoNormalModel == null) {
            a aVar = a.BKb;
            a.a(i2, str, z, new CaptureDataManager.CaptureVideoNormalModel(Boolean.FALSE, "", "", 0L, Boolean.FALSE, new RecordMediaReportInfo()));
            AppMethodBeat.o(75236);
            return;
        }
        a aVar2 = a.BKb;
        a.a(i2, str, z, captureVideoNormalModel);
        AppMethodBeat.o(75236);
    }
}

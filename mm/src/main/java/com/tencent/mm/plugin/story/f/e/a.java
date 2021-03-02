package com.tencent.mm.plugin.story.f.e;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.component.api.jumper.UICustomParam;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.recordvideo.background.VideoMixer;
import com.tencent.mm.plugin.recordvideo.background.e;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.recordvideo.jumper.RecordMediaReportInfo;
import com.tencent.mm.plugin.recordvideo.jumper.VideoCaptureReportInfo;
import com.tencent.mm.plugin.recordvideo.plugin.parent.Image2VideoPluginLayout;
import com.tencent.mm.plugin.recordvideo.ui.FakeVideoViewLayer;
import com.tencent.mm.plugin.story.c.a.c;
import com.tencent.mm.plugin.story.c.a.g;
import com.tencent.mm.plugin.story.f.j;
import com.tencent.mm.plugin.story.h.f;
import com.tencent.mm.plugin.story.ui.StoryCaptureUI;
import com.tencent.mm.plugin.vlog.ui.VLogPreviewPluginLayout;
import com.tencent.mm.protocal.protobuf.aio;
import com.tencent.mm.protocal.protobuf.ald;
import com.tencent.mm.protocal.protobuf.eds;
import com.tencent.mm.protocal.protobuf.jn;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.at;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0005J\u0010\u0010\u000e\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010J\u000e\u0010\u000e\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0005JA\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u00162!\u0010\u0017\u001a\u001d\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001b\u0012\u0004\u0012\u00020\f0\u0018JM\u0010\u0011\u001a\u00020\f2\u0006\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\u001f\u001a\u00020\u00052!\u0010\u0017\u001a\u001d\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b( \u0012\u0004\u0012\u00020\f0\u0018H\u0002J\u0010\u0010!\u001a\u00020\u00162\u0006\u0010\"\u001a\u00020\u0013H\u0002J\u0010\u0010#\u001a\u0004\u0018\u00010\u00132\u0006\u0010$\u001a\u00020\bJ\u0010\u0010%\u001a\u0004\u0018\u00010\u00132\u0006\u0010\r\u001a\u00020\u0005J\u0010\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010)J\u0010\u0010*\u001a\u00020+2\b\u0010(\u001a\u0004\u0018\u00010)J \u0010,\u001a\u00020\f2\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u00020\u001eH\u0016J\"\u0010\u0017\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00052\u0006\u00102\u001a\u00020.2\b\u00103\u001a\u0004\u0018\u000104H\u0016J&\u00105\u001a\u00020.2\b\u0010(\u001a\u0004\u0018\u00010)2\b\u00101\u001a\u0004\u0018\u00010\u001e2\b\u00106\u001a\u0004\u0018\u000107H\u0016J\u0010\u00108\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0005H\u0016J&\u00109\u001a\u00020\f2\b\u0010(\u001a\u0004\u0018\u00010)2\b\u00103\u001a\u0004\u0018\u0001042\b\u00101\u001a\u0004\u0018\u00010\u001eH\u0016J\u0018\u0010:\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010;\u001a\u00020\bH\u0016J\u0010\u0010<\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0005H\u0016J\u0006\u0010=\u001a\u00020\fJ\u000e\u0010=\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0005J \u0010>\u001a\u00020\f2\b\u0010(\u001a\u0004\u0018\u00010)2\u0006\u0010?\u001a\u00020\b2\u0006\u0010@\u001a\u00020AJ\u0016\u0010B\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010C\u001a\u00020\u0013R\u000e\u0010\u0004\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u001d\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00050\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006D"}, hxF = {"Lcom/tencent/mm/plugin/story/model/mix/StoryMixManager;", "Lcom/tencent/mm/plugin/recordvideo/background/IBgMixCallback;", "Lcom/tencent/mm/plugin/recordvideo/jumper/CaptureDataManager$IVideoGenerateCallback;", "()V", "TAG", "", "remuxTaskMap", "Ljava/util/HashMap;", "", "getRemuxTaskMap", "()Ljava/util/HashMap;", "cleanNullData", "", "taskId", "cleanUnAvailableData", "data", "Lcom/tencent/mm/protocal/protobuf/EditorProtoData;", "commit", "storyEditorData", "Lcom/tencent/mm/plugin/recordvideo/background/VideoEditData;", "thumbPath", "editorInfo", "Lcom/tencent/mm/protocal/protobuf/StoryMediaEditorInfo;", "onFinish", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "retId", "videoPath", "extraBundle", "Landroid/os/Bundle;", "mediaDes", "resId", "genStoryEditorReportInfo", "videoEditData", "getEditDataByLocalId", ch.COL_LOCALID, "getEditDataByTaskId", "getFakeLayer", "Lcom/tencent/mm/plugin/recordvideo/ui/FakeVideoViewLayer;", "context", "Landroid/content/Context;", "getImageFakeLayer", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/ImageFakeVideoView;", "onEditFinish", "forward", "", "reportInfo", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordMediaReportInfo;", "extData", "success", "model", "Lcom/tencent/mm/plugin/recordvideo/jumper/CaptureDataManager$CaptureVideoNormalModel;", "onFinishBtnClick", "controller", "Lcom/tencent/mm/plugin/recordvideo/jumper/CaptureDataManager$IVideoFinishController;", "onInit", "onMediaGenerated", "onRun", "runNum", "onWait", "remuxMedia", "startStoryCapture", "entranceScene", "videoObjectId", "", "updateByTaskId", "editorData", "plugin-story_release"})
public final class a implements com.tencent.mm.plugin.recordvideo.background.b, CaptureDataManager.b {
    private static final HashMap<Integer, String> Fpk = new HashMap<>();
    public static final a Fpl;

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", "storyLocalId", "", "invoke"})
    static final class c extends q implements kotlin.g.a.b<Integer, x> {
        final /* synthetic */ String BKc;
        final /* synthetic */ com.tencent.mm.media.k.a ipM;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(String str, com.tencent.mm.media.k.a aVar) {
            super(1);
            this.BKc = str;
            this.ipM = aVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(Integer num) {
            AppMethodBeat.i(118947);
            int intValue = num.intValue();
            a aVar = a.Fpl;
            a.foZ().put(Integer.valueOf(intValue), this.BKc);
            j.b bVar = j.Fmy;
            j.b.foi().fpv();
            a aVar2 = a.Fpl;
            a.fpa();
            Log.i("MicroMsg.StoryMixManager", "man reStartMixend " + this.ipM);
            x xVar = x.SXb;
            AppMethodBeat.o(118947);
            return xVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "", "invoke"})
    static final class d extends q implements kotlin.g.a.b<Integer, x> {
        public static final d Fpr = new d();

        static {
            AppMethodBeat.i(118949);
            AppMethodBeat.o(118949);
        }

        d() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(Integer num) {
            AppMethodBeat.i(118948);
            num.intValue();
            x xVar = x.SXb;
            AppMethodBeat.o(118948);
            return xVar;
        }
    }

    static {
        AppMethodBeat.i(118965);
        a aVar = new a();
        Fpl = aVar;
        com.tencent.mm.plugin.recordvideo.background.a aVar2 = com.tencent.mm.plugin.recordvideo.background.a.BKb;
        com.tencent.mm.plugin.recordvideo.background.a.a(3, aVar);
        com.tencent.mm.plugin.recordvideo.background.a aVar3 = com.tencent.mm.plugin.recordvideo.background.a.BKb;
        com.tencent.mm.plugin.recordvideo.background.a.a(6, b.Fps);
        AppMethodBeat.o(118965);
    }

    private a() {
    }

    public static HashMap<Integer, String> foZ() {
        return Fpk;
    }

    @Override // com.tencent.mm.plugin.recordvideo.background.b
    public final void aAd(String str) {
        AppMethodBeat.i(118950);
        p.h(str, "taskId");
        Log.i("MicroMsg.StoryMixManager", "onInit, taskId:".concat(String.valueOf(str)));
        e eVar = e.BKp;
        com.tencent.mm.plugin.recordvideo.background.c aLf = e.aLf(str);
        if (aLf == null) {
            AppMethodBeat.o(118950);
            return;
        }
        String str2 = aLf.eII().thumbPath;
        eds d2 = d(aLf);
        com.tencent.mm.media.k.a aVar = new com.tencent.mm.media.k.a("runMixInBackground");
        p.g(str2, "thumbPath");
        a(aLf, str2, d2, new c(str, aVar));
        AppMethodBeat.o(118950);
    }

    @Override // com.tencent.mm.plugin.recordvideo.background.b
    public final void eh(String str, int i2) {
        AppMethodBeat.i(118951);
        p.h(str, "taskId");
        Log.i("MicroMsg.StoryMixManager", "onRun, taskId:" + str + " runNum:" + i2);
        AppMethodBeat.o(118951);
    }

    @Override // com.tencent.mm.plugin.recordvideo.background.b
    public final void aAe(String str) {
        AppMethodBeat.i(118952);
        p.h(str, "taskId");
        Log.i("MicroMsg.StoryMixManager", "onWait, taskId:".concat(String.valueOf(str)));
        AppMethodBeat.o(118952);
    }

    @Override // com.tencent.mm.plugin.recordvideo.background.b
    public final void a(String str, boolean z, CaptureDataManager.CaptureVideoNormalModel captureVideoNormalModel) {
        String str2;
        String str3;
        RecordMediaReportInfo eJJ;
        String videoPath;
        AppMethodBeat.i(118953);
        p.h(str, "taskId");
        Log.i("MicroMsg.StoryMixManager", "onFinish, success:" + z + " taskId:" + str);
        Set<Map.Entry<Integer, String>> entrySet = Fpk.entrySet();
        p.g(entrySet, "remuxTaskMap.entries");
        int i2 = 0;
        for (T t : entrySet) {
            if (Util.isEqual((String) t.getValue(), str)) {
                Object key = t.getKey();
                p.g(key, "it.key");
                int intValue = ((Number) key).intValue();
                Log.i("MicroMsg.StoryMixManager", "found localId:".concat(String.valueOf(intValue)));
                i2 = intValue;
            }
        }
        if (z) {
            Fpk.remove(Integer.valueOf(i2));
            if (captureVideoNormalModel == null || (videoPath = captureVideoNormalModel.getVideoPath()) == null) {
                str2 = "";
            } else {
                str2 = videoPath;
            }
            if (captureVideoNormalModel == null || (str3 = captureVideoNormalModel.aQn()) == null) {
                str3 = "";
            }
            com.tencent.mm.plugin.story.g.j jVar = com.tencent.mm.plugin.story.g.j.FsI;
            com.tencent.mm.plugin.story.g.j.e((long) i2, str2, str3);
            j.b bVar = j.Fmy;
            j.b.foi().fpv();
            if (captureVideoNormalModel == null || (eJJ = captureVideoNormalModel.eJJ()) == null) {
                AppMethodBeat.o(118953);
                return;
            }
            boolean a2 = ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_clear_story_tmp_file, true);
            Object y = eJJ.y("KEY_IS_CAPUTRE_BOOLEAN", Boolean.FALSE);
            p.g(y, "getReportValue(RecordMed…IS_CAPUTRE_BOOLEAN,false)");
            if (((Boolean) y).booleanValue() && a2) {
                com.tencent.mm.plugin.recordvideo.e.c cVar = com.tencent.mm.plugin.recordvideo.e.c.Cic;
                com.tencent.mm.plugin.recordvideo.e.c.aHD((String) eJJ.y("KEY_CAPUTRE_VIDEO_PATH_STRING", ""));
                com.tencent.mm.plugin.recordvideo.e.c cVar2 = com.tencent.mm.plugin.recordvideo.e.c.Cic;
                com.tencent.mm.plugin.recordvideo.e.c.aHD((String) eJJ.y("KEY_CAPUTRE_THUMB_PATH_STRING", ""));
            }
            AppMethodBeat.o(118953);
            return;
        }
        f fVar = f.Fui;
        f.eLd();
        com.tencent.mm.plugin.story.g.j jVar2 = com.tencent.mm.plugin.story.g.j.FsI;
        com.tencent.mm.plugin.story.g.j.aaQ(i2);
        AppMethodBeat.o(118953);
    }

    private static eds d(com.tencent.mm.plugin.recordvideo.background.c cVar) {
        AppMethodBeat.i(118954);
        eds eds = new eds();
        aio aio = new aio();
        try {
            aio.parseFrom(cVar.field_baseItemData);
        } catch (Exception e2) {
            Log.printDebugStack("safeParser", "", e2);
        }
        LinkedList<jn> linkedList = aio.Lna;
        p.g(linkedList, "editProtoData.baseItemData");
        for (T t : linkedList) {
            int i2 = t.dataType;
            if (i2 == com.tencent.mm.plugin.recordvideo.ui.editor.item.d.TEXT.value) {
                LinkedList<String> linkedList2 = eds.Nec;
                p.g(t, LocaleUtil.ITALIAN);
                linkedList2.add(String.valueOf(new com.tencent.mm.plugin.recordvideo.ui.editor.item.q(t).text));
            } else if (i2 == com.tencent.mm.plugin.recordvideo.ui.editor.item.d.EMOJI.value) {
                p.g(t, LocaleUtil.ITALIAN);
                EmojiInfo emojiInfo = new com.tencent.mm.plugin.recordvideo.ui.editor.item.e((jn) t).gWm;
                if (emojiInfo != null) {
                    eds.Neb.add(emojiInfo.getMd5());
                }
            } else if (i2 == com.tencent.mm.plugin.recordvideo.ui.editor.item.d.TIP.value) {
                p.g(t, LocaleUtil.ITALIAN);
                eds.HIK = String.valueOf(new com.tencent.mm.plugin.recordvideo.ui.editor.item.q(t).text);
            }
        }
        if (Util.isNullOrNil(aio.iiv)) {
            eds.Nea = false;
        } else {
            eds.Nea = true;
            eds.BOX = aio.BOX;
            eds.Lsa = aio.Lsa;
            eds.NdZ = aio.Lsb;
        }
        AppMethodBeat.o(118954);
        return eds;
    }

    public static void a(com.tencent.mm.plugin.recordvideo.background.c cVar, String str, eds eds, kotlin.g.a.b<? super Integer, x> bVar) {
        AppMethodBeat.i(118955);
        p.h(cVar, "storyEditorData");
        p.h(str, "thumbPath");
        p.h(eds, "editorInfo");
        p.h(bVar, "onFinish");
        com.tencent.mm.ac.d.b("StoryCapture_commit", new C1752a(cVar, str, eds, bVar));
        AppMethodBeat.o(118955);
    }

    public static void aSe(String str) {
        AppMethodBeat.i(118956);
        p.h(str, "taskId");
        e eVar = e.BKp;
        e.aLj(str);
        AppMethodBeat.o(118956);
    }

    public static void fpa() {
        AppMethodBeat.i(118957);
        e eVar = e.BKp;
        e.eIW();
        AppMethodBeat.o(118957);
    }

    public static com.tencent.mm.plugin.recordvideo.background.c aaI(int i2) {
        AppMethodBeat.i(118958);
        String str = Fpk.get(Integer.valueOf(i2));
        if (str == null) {
            str = "";
        }
        p.g(str, "remuxTaskMap[localId] ?: \"\"");
        e eVar = e.BKp;
        com.tencent.mm.plugin.recordvideo.background.c aLf = e.aLf(str);
        AppMethodBeat.o(118958);
        return aLf;
    }

    public static void aLh(String str) {
        AppMethodBeat.i(118959);
        p.h(str, "taskId");
        Log.i("MicroMsg.StoryMixManager", "run cleanNullData data");
        e eVar = e.BKp;
        e.aLh(str);
        AppMethodBeat.o(118959);
    }

    public static void aLi(String str) {
        AppMethodBeat.i(118960);
        p.h(str, "taskId");
        Log.i("MicroMsg.StoryMixManager", "run cleanUnAvailableData data");
        e eVar = e.BKp;
        e.aLi(str);
        AppMethodBeat.o(118960);
    }

    public final void startStoryCapture(Context context, int i2, long j2) {
        boolean z;
        AppMethodBeat.i(118961);
        if (com.tencent.mm.plugin.voip.f.hy(context) || com.tencent.mm.plugin.voip.f.cC(context) || com.tencent.mm.bh.e.cA(context) || com.tencent.mm.q.a.cE(context)) {
            Log.i("MicroMsg.StoryMixManager", "startStoryCapture, voip or multitalk running");
            AppMethodBeat.o(118961);
            return;
        }
        if (context instanceof Activity) {
            if (!com.tencent.mm.pluginsdk.permission.b.a((Activity) context, "android.permission.CAMERA", 24, "", "")) {
                AppMethodBeat.o(118961);
                return;
            }
            if (!com.tencent.mm.pluginsdk.permission.b.a((Activity) context, new String[]{"android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION"}, 78, "", "")) {
                AppMethodBeat.o(118961);
                return;
            }
        }
        Log.i("MicroMsg.StoryMixManager", "startStoryCapture %s", Util.getStack().toString());
        if (com.tencent.mm.plugin.story.c.a.e.Fln.fng()) {
            com.tencent.mm.kernel.e aAh = g.aAh();
            p.g(aAh, "storage()");
            z = aAh.azQ().getBoolean(ar.a.USERINFO_STORY_CAPTURE_FIRST_NEW_BOOLEAN_SYNC, false);
        } else {
            com.tencent.mm.kernel.e aAh2 = g.aAh();
            p.g(aAh2, "storage()");
            z = aAh2.azQ().getBoolean(ar.a.USERINFO_STORY_CAPTURE_FIRST_BOOLEAN_SYNC, false);
        }
        if (!z) {
            Intent intent = new Intent(context, StoryCaptureUI.class);
            intent.putExtra("jump_page_from", i2);
            intent.putExtra("video_object_id", j2);
            if (context != null) {
                com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/plugin/story/model/mix/StoryMixManager", "startStoryCapture", "(Landroid/content/Context;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                context.startActivity((Intent) bl.pG(0));
                com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/plugin/story/model/mix/StoryMixManager", "startStoryCapture", "(Landroid/content/Context;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                AppMethodBeat.o(118961);
                return;
            }
            AppMethodBeat.o(118961);
            return;
        }
        RecordConfigProvider a2 = RecordConfigProvider.a("", "", ((c.a) com.tencent.mm.plugin.story.c.a.c.FkZ.aLT()).BOm, ((c.a) com.tencent.mm.plugin.story.c.a.c.FkZ.aLT()).BOm.duration * 1000, 3);
        j.b bVar = j.Fmy;
        a2.BOt = Boolean.valueOf(j.b.fom() == g.a.FORWARD);
        a2.BOx = true;
        UICustomParam.a aVar = new UICustomParam.a();
        aVar.a(R.drawable.axo, R.color.ag5, context != null ? context.getString(R.string.hhr) : null, at.fromDPToPix(context, 48));
        aVar.dy(true);
        aVar.oG(Color.parseColor("#0E9CE6"));
        a2.BOn = aVar.apG();
        a2.BOu = Boolean.TRUE;
        a2.BOr = Boolean.FALSE;
        a2.BOF = Util.MILLSECONDS_OF_DAY;
        a2.BOG = false;
        a2.BOp = 1;
        a2.BOH = true;
        a2.BOI = true;
        VideoCaptureReportInfo videoCaptureReportInfo = new VideoCaptureReportInfo();
        videoCaptureReportInfo.sQn = 7;
        videoCaptureReportInfo.rna = i2;
        videoCaptureReportInfo.twG = j2;
        a2.BOE = videoCaptureReportInfo;
        a2.BOq = Boolean.TRUE;
        boolean a3 = ((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_story_enable_vlog, false);
        com.tencent.mm.kernel.e aAh3 = com.tencent.mm.kernel.g.aAh();
        p.g(aAh3, "storage()");
        boolean z2 = aAh3.azQ().getInt(ar.a.USERINFO_TOP_STORY_VLOG_ENABLE_INT, 0) == 1 || a3;
        a2.F(1, Image2VideoPluginLayout.class.getName());
        if (z2) {
            a2.F(3, VLogPreviewPluginLayout.class.getName());
            a2.F(4, VLogPreviewPluginLayout.class.getName());
        } else {
            a2.F(3, Image2VideoPluginLayout.class.getName());
        }
        CaptureDataManager.BOb.a(this);
        if (((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_jump_to_record_media, true)) {
            com.tencent.mm.plugin.recordvideo.jumper.a aVar2 = com.tencent.mm.plugin.recordvideo.jumper.a.BOL;
            com.tencent.mm.plugin.recordvideo.jumper.a.a(context, 0, -1, -1, a2);
        }
        AppMethodBeat.o(118961);
    }

    public static FakeVideoViewLayer hk(Context context) {
        AppMethodBeat.i(118962);
        com.tencent.mm.plugin.recordvideo.background.a aVar = com.tencent.mm.plugin.recordvideo.background.a.BKb;
        FakeVideoViewLayer gN = com.tencent.mm.plugin.recordvideo.background.a.gN(context);
        AppMethodBeat.o(118962);
        return gN;
    }

    public static com.tencent.mm.plugin.recordvideo.ui.editor.f hl(Context context) {
        AppMethodBeat.i(118963);
        com.tencent.mm.plugin.recordvideo.background.a aVar = com.tencent.mm.plugin.recordvideo.background.a.BKb;
        com.tencent.mm.plugin.recordvideo.ui.editor.f gO = com.tencent.mm.plugin.recordvideo.background.a.gO(context);
        AppMethodBeat.o(118963);
        return gO;
    }

    @Override // com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.b
    public final void a(Context context, CaptureDataManager.CaptureVideoNormalModel captureVideoNormalModel, Bundle bundle) {
        String str;
        String str2;
        AppMethodBeat.i(118964);
        Log.i("MicroMsg.StoryMixManager", "onMediaGenerated model:" + captureVideoNormalModel + ", extData:" + bundle);
        if (bundle == null || !bundle.getBoolean("key_bg_generate") || bundle.getByteArray("key_bg_generate_pb") == null) {
            if (captureVideoNormalModel == null || (str = captureVideoNormalModel.getVideoPath()) == null) {
                str = "";
            }
            if (captureVideoNormalModel == null || (str2 = captureVideoNormalModel.aQn()) == null) {
                str2 = "";
            }
            if (bundle == null) {
                AppMethodBeat.o(118964);
                return;
            }
            com.tencent.mm.ac.d.b("StoryCapture_commit", new b(new Bundle(bundle), str, str2, "", d.Fpr));
            if (context == null) {
                t tVar = new t("null cannot be cast to non-null type android.app.Activity");
                AppMethodBeat.o(118964);
                throw tVar;
            }
            ((Activity) context).setResult(-1);
            ((Activity) context).finish();
            AppMethodBeat.o(118964);
            return;
        }
        com.tencent.mm.bw.a parseFrom = new ald().parseFrom(bundle.getByteArray("key_bg_generate_extra_config"));
        VideoMixer.MixConfig mixConfig = (VideoMixer.MixConfig) bundle.getParcelable("key_bg_generate_mix_config");
        e eVar = e.BKp;
        byte[] byteArray = bundle.getByteArray("key_bg_generate_pb");
        if (byteArray == null) {
            p.hyc();
        }
        p.g(byteArray, "extData.getByteArray(KEY_BG_GENERATE_PB)!!");
        if (mixConfig == null) {
            p.hyc();
        }
        byte[] byteArray2 = parseFrom.toByteArray();
        p.g(byteArray2, "extraConfig.toByteArray()");
        e.a(byteArray, mixConfig, byteArray2);
        AppMethodBeat.o(118964);
    }

    @Override // com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.b
    public final boolean a(Context context, Bundle bundle, CaptureDataManager.a aVar) {
        return false;
    }

    @Override // com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.b
    public final void a(RecordMediaReportInfo recordMediaReportInfo, Bundle bundle) {
        AppMethodBeat.i(222911);
        p.h(recordMediaReportInfo, "reportInfo");
        p.h(bundle, "extData");
        AppMethodBeat.o(222911);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    /* renamed from: com.tencent.mm.plugin.story.f.e.a$a  reason: collision with other inner class name */
    public static final class C1752a extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ com.tencent.mm.plugin.recordvideo.background.c Fpm;
        final /* synthetic */ eds Fpn;
        final /* synthetic */ kotlin.g.a.b Fpo;
        final /* synthetic */ String mtc;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C1752a(com.tencent.mm.plugin.recordvideo.background.c cVar, String str, eds eds, kotlin.g.a.b bVar) {
            super(0);
            this.Fpm = cVar;
            this.mtc = str;
            this.Fpn = eds;
            this.Fpo = bVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX WARNING: Removed duplicated region for block: B:105:0x0295  */
        /* JADX WARNING: Removed duplicated region for block: B:109:0x02a8  */
        /* JADX WARNING: Removed duplicated region for block: B:87:0x0226  */
        /* JADX WARNING: Removed duplicated region for block: B:91:0x0239  */
        @Override // kotlin.g.a.a
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final /* synthetic */ kotlin.x invoke() {
            /*
            // Method dump skipped, instructions count: 710
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.story.f.e.a.C1752a.invoke():java.lang.Object");
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class b extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ kotlin.g.a.b Fpo;
        final /* synthetic */ Bundle Fpp;
        final /* synthetic */ String Fpq;
        final /* synthetic */ String mtb;
        final /* synthetic */ String mtc;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(Bundle bundle, String str, String str2, String str3, kotlin.g.a.b bVar) {
            super(0);
            this.Fpp = bundle;
            this.mtb = str;
            this.mtc = str2;
            this.Fpq = str3;
            this.Fpo = bVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX WARNING: Removed duplicated region for block: B:42:0x019c  */
        /* JADX WARNING: Removed duplicated region for block: B:46:0x01af  */
        /* JADX WARNING: Removed duplicated region for block: B:60:0x020b  */
        /* JADX WARNING: Removed duplicated region for block: B:64:0x021e  */
        @Override // kotlin.g.a.a
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final /* synthetic */ kotlin.x invoke() {
            /*
            // Method dump skipped, instructions count: 560
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.story.f.e.a.b.invoke():java.lang.Object");
        }
    }
}

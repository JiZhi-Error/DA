package com.tencent.mm.plugin.recordvideo.background.c;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recordvideo.background.VideoMixer;
import com.tencent.mm.plugin.recordvideo.background.c;
import com.tencent.mm.plugin.recordvideo.model.audio.AudioCacheInfo;
import com.tencent.mm.protocal.protobuf.aio;
import com.tencent.mm.protocal.protobuf.ald;
import com.tencent.mm.protocal.protobuf.jn;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.ArrayList;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0005¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\n"}, hxF = {"Lcom/tencent/mm/plugin/recordvideo/background/mixer/VideoMixerManager;", "Lcom/tencent/mm/plugin/recordvideo/background/mixer/IMixInstanceManager;", "()V", "createMixInstance", "Lcom/tencent/mm/plugin/recordvideo/background/mixer/IVideoRemuxer;", "editorData", "Lcom/tencent/mm/plugin/recordvideo/background/VideoEditData;", "extraConfig", "Lcom/tencent/mm/protocal/protobuf/ExtraConfig;", "Companion", "plugin-recordvideo_release"})
public final class e implements a {
    public static final a BMr = new a((byte) 0);

    static {
        AppMethodBeat.i(75326);
        AppMethodBeat.o(75326);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/recordvideo/background/mixer/VideoMixerManager$Companion;", "", "()V", "TAG", "", "plugin-recordvideo_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @Override // com.tencent.mm.plugin.recordvideo.background.c.a
    public final c a(c cVar, ald ald) {
        AudioCacheInfo audioCacheInfo;
        AppMethodBeat.i(75325);
        p.h(cVar, "editorData");
        p.h(ald, "extraConfig");
        aio aio = new aio();
        try {
            aio.parseFrom(cVar.field_baseItemData);
        } catch (Exception e2) {
            Log.printDebugStack("safeParser", "", e2);
            aio = null;
        }
        aio aio2 = aio;
        if (aio2 != null) {
            com.tencent.mm.plugin.recordvideo.background.e eVar = com.tencent.mm.plugin.recordvideo.background.e.BKp;
            p.h(aio2, "storyEditorProtoData");
            com.tencent.mm.plugin.recordvideo.b.c cVar2 = new com.tencent.mm.plugin.recordvideo.b.c();
            p.h(aio2, "storyEditorProtoData");
            if (aio2.idq == 0 || aio2.idq == 1) {
                audioCacheInfo = null;
            } else {
                audioCacheInfo = new AudioCacheInfo();
                audioCacheInfo.musicUrl = aio2.musicUrl;
                audioCacheInfo.BOX = aio2.BOX;
                audioCacheInfo.aXa = aio2.aXa;
                audioCacheInfo.BPa = aio2.BPa;
                audioCacheInfo.cachePath = aio2.iiv;
                audioCacheInfo.position = aio2.Lsa;
                audioCacheInfo.BPd = aio2.Lsb;
            }
            cVar2.uPh = audioCacheInfo;
            cVar2.BMY = aio2.idq;
            cVar2.BMV = aio2.startTime;
            cVar2.BMW = aio2.endTime;
            String str = aio2.videoPath;
            p.g(str, "storyEditorProtoData.videoPath");
            cVar2.aLo(str);
            String str2 = aio2.thumbPath;
            p.g(str2, "storyEditorProtoData.thumbPath");
            cVar2.aLp(str2);
            cVar2.iqf = aio2.iqf;
            cVar2.BMZ.addAll(aio2.Lsc);
            if (!cVar2.BMZ.isEmpty()) {
                cVar2.BMX = true;
            }
            com.tencent.mm.plugin.recordvideo.background.e eVar2 = com.tencent.mm.plugin.recordvideo.background.e.BKp;
            LinkedList<jn> linkedList = aio2.Lna;
            p.g(linkedList, "storyEditorItem.baseItemData");
            Context context = MMApplicationContext.getContext();
            p.g(context, "MMApplicationContext.getContext()");
            ArrayList<com.tencent.mm.plugin.recordvideo.ui.editor.item.a.a> a2 = com.tencent.mm.plugin.recordvideo.background.e.a(linkedList, context);
            com.tencent.mm.plugin.recordvideo.background.e eVar3 = com.tencent.mm.plugin.recordvideo.background.e.BKp;
            float[] b2 = com.tencent.mm.plugin.recordvideo.background.e.b(aio2);
            com.tencent.mm.plugin.recordvideo.background.e eVar4 = com.tencent.mm.plugin.recordvideo.background.e.BKp;
            float[] c2 = com.tencent.mm.plugin.recordvideo.background.e.c(aio2);
            String str3 = ald.BOA;
            p.g(str3, "extraConfig.outputVideoPath");
            String str4 = ald.Lue;
            p.g(str4, "extraConfig.outputThumbPath");
            boolean z = ald.BLF;
            String str5 = cVar.field_blurBgPath;
            p.g(str5, "editorData.field_blurBgPath");
            VideoMixer videoMixer = new VideoMixer(new com.tencent.mm.plugin.recordvideo.background.a.a(cVar2, a2, b2, c2, str3, str4, 0, z, false, 0, str5, 832));
            VideoMixer.a(videoMixer, cVar.field_targetWidth, cVar.field_targetHeight, cVar.field_videoBitrate, cVar.field_audioBitrate, cVar.field_audioSampleRate, cVar.field_audioChannelCount, cVar.field_frameRate, cVar.field_videoRotate);
            Log.i("MicroMsg.VideoMixerManager", "remux video config: " + videoMixer.eJf().toString());
            VideoMixer videoMixer2 = videoMixer;
            AppMethodBeat.o(75325);
            return videoMixer2;
        }
        AppMethodBeat.o(75325);
        return null;
    }
}

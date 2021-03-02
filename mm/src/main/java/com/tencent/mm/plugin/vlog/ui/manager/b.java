package com.tencent.mm.plugin.vlog.ui.manager;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.cl;
import com.tencent.mm.plugin.recordvideo.model.audio.AudioCacheInfo;
import com.tencent.mm.plugin.recordvideo.model.audio.i;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0005¢\u0006\u0002\u0010\u0002JH\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b28\u0010\t\u001a4\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0015\u0012\u0013\u0018\u00010\b¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u00060\nJ\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u0006\u0010\u0012\u001a\u00020\u0006R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0014"}, hxF = {"Lcom/tencent/mm/plugin/vlog/ui/manager/VLogMusicManager;", "", "()V", "downloadManager", "Lcom/tencent/mm/plugin/recordvideo/model/audio/StoryAudioManager;", "loadMusic", "", "path", "", "callback", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "success", "filePath", "packageAudioInfo", "Lcom/tencent/mm/plugin/recordvideo/model/audio/AudioCacheInfo;", "release", "Companion", "plugin-vlog_release"})
public final class b {
    private static String GGg;
    public static final a GGh = new a((byte) 0);
    private i GGf = i.BPK;

    public b() {
        AppMethodBeat.i(111153);
        i.a aVar = i.BPL;
        AppMethodBeat.o(111153);
    }

    public final void d(String str, m<? super Boolean, ? super String, x> mVar) {
        AppMethodBeat.i(111151);
        p.h(str, "path");
        p.h(mVar, "callback");
        this.GGf.a(aUj(str), mVar);
        AppMethodBeat.o(111151);
    }

    private static AudioCacheInfo aUj(String str) {
        AppMethodBeat.i(111152);
        AudioCacheInfo audioCacheInfo = new AudioCacheInfo();
        audioCacheInfo.musicUrl = str;
        audioCacheInfo.BOX = str.hashCode();
        audioCacheInfo.cachePath = GGg + str.hashCode() + '_' + cl.aWz() + ".a";
        AppMethodBeat.o(111152);
        return audioCacheInfo;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0004R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u000b"}, hxF = {"Lcom/tencent/mm/plugin/vlog/ui/manager/VLogMusicManager$Companion;", "", "()V", "AAC_PATH", "", "getAAC_PATH", "()Ljava/lang/String;", "setAAC_PATH", "(Ljava/lang/String;)V", "getAudioCachePath", "path", "plugin-vlog_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(111154);
        StringBuilder sb = new StringBuilder();
        e aAh = g.aAh();
        p.g(aAh, "MMKernel.storage()");
        GGg = sb.append(aAh.getAccPath()).append("vlog/coming/").toString();
        AppMethodBeat.o(111154);
    }
}

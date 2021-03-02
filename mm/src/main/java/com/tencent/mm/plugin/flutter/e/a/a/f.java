package com.tencent.mm.plugin.flutter.e.a.a;

import android.os.Handler;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.flutter.e.a.a.o;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.plugin.recordvideo.model.audio.AudioCacheInfo;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.clp;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.a.j;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.g.b.z;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 %2\u00020\u0001:\u0001%B\u0007\b\u0012¢\u0006\u0002\u0010\u0002J\u0014\u0010\u0017\u001a\u00020\u000f2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019J\u000e\u0010\u001b\u001a\u00020\u000f2\u0006\u0010\u001c\u001a\u00020\bJ\u0006\u0010\u001d\u001a\u00020\u001eJ\u001e\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020\u001e2\u0006\u0010#\u001a\u00020\u001eJ\u001e\u0010$\u001a\u00020\u000f2\u0006\u0010!\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020\u001e2\u0006\u0010#\u001a\u00020\u001eR\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R!\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\"\u0010\f\u001a\u0016\u0012\u0004\u0012\u00020\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0004\u0012\u00020\u000f0\rX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u0002\n\u0000¨\u0006&"}, hxF = {"Lcom/tencent/mm/plugin/flutter/plugins/video/api/MMVideoEditorAudioRecommend;", "", "()V", "FLUTTER_TAG", "", "TAG", "audioCacheList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/recordvideo/model/audio/AudioCacheInfo;", "Lkotlin/collections/ArrayList;", "getAudioCacheList", "()Ljava/util/ArrayList;", "callback", "Lkotlin/Function2;", "", "", "taskLifeCycle", "Lcom/tencent/mm/vending/lifecycle/LifeCycleKeeper;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycle;", "uiThreadHandler", "Landroid/os/Handler;", "videoRecommendAudioTask", "Lcom/tencent/mm/plugin/recordvideo/model/audio/AbsGetRecommendAudioTask;", "addAudioList", "audioList", "", "Lcom/tencent/mm/protocal/protobuf/MMSPRRecommendedMusicInfo;", "downloadMusic", "info", "getMusicRequestId", "", "getRecommendAudio", "Lcom/tencent/pigeon/VideoEditorCompositionApiPluginApi$AudioRecommendResponse;", "videoPath", "startTime", "endTime", "startGetRecommendAudio", "Companion", "plugin-flutter_release"})
public final class f {
    private static f wJU;
    public static final a wJV = new a((byte) 0);
    public final String TAG;
    private m<? super Boolean, ? super String, x> gWp;
    private final Handler uiThreadHandler;
    public final String vRb;
    private final ArrayList<AudioCacheInfo> wJR;
    public com.tencent.mm.plugin.recordvideo.model.audio.a wJS;
    public com.tencent.mm.vending.e.c<com.tencent.mm.vending.e.a> wJT;

    static {
        AppMethodBeat.i(241071);
        AppMethodBeat.o(241071);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\n¢\u0006\u0002\b\u0006"}, hxF = {"<anonymous>", "", "success", "", "filePath", "", "invoke"})
    static final class b extends q implements m<Boolean, String, x> {
        final /* synthetic */ f wJW;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(f fVar) {
            super(2);
            this.wJW = fVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.g.a.m
        public final /* synthetic */ x invoke(Boolean bool, String str) {
            AppMethodBeat.i(241065);
            boolean booleanValue = bool.booleanValue();
            String str2 = str;
            Log.i(this.wJW.TAG, "downloadMusic success: " + booleanValue + " path " + str2);
            HashMap hashMap = new HashMap();
            if (booleanValue) {
                hashMap.put("success", Boolean.TRUE);
                if (str2 != null) {
                    hashMap.put("filePath", str2);
                } else {
                    hashMap.put("filePath", "nopath");
                }
            } else {
                hashMap.put("success", Boolean.FALSE);
            }
            o.a aVar = o.wKI;
            o.a.dMh().t("onDownloadMusicCompleted", hashMap);
            x xVar = x.SXb;
            AppMethodBeat.o(241065);
            return xVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\n¢\u0006\u0002\b\u0006"}, hxF = {"<anonymous>", "", "success", "", "filePath", "", "invoke"})
    public static final class c extends q implements m<Boolean, String, x> {
        final /* synthetic */ f wJW;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(f fVar) {
            super(2);
            this.wJW = fVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.g.a.m
        public final /* synthetic */ x invoke(Boolean bool, String str) {
            AppMethodBeat.i(241067);
            boolean booleanValue = bool.booleanValue();
            String str2 = str;
            Log.i(this.wJW.TAG, "downloadMusic success: " + booleanValue + " path " + str2);
            final z.f fVar = new z.f();
            fVar.SYG = (T) new HashMap();
            if (booleanValue) {
                fVar.SYG.put("success", Boolean.TRUE);
                if (str2 != null) {
                    fVar.SYG.put("filePath", str2);
                } else {
                    fVar.SYG.put("filePath", "nopath");
                }
            } else {
                fVar.SYG.put("success", Boolean.FALSE);
            }
            this.wJW.uiThreadHandler.post(new Runnable() {
                /* class com.tencent.mm.plugin.flutter.e.a.a.f.c.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(241066);
                    o.a aVar = o.wKI;
                    o.a.dMh().t("onDownloadMusicCompleted", fVar.SYG);
                    AppMethodBeat.o(241066);
                }
            });
            x xVar = x.SXb;
            AppMethodBeat.o(241067);
            return xVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/MMSPRRecommendedMusicInfo;", "invoke"})
    public static final class d extends q implements kotlin.g.a.b<LinkedList<clp>, x> {
        final /* synthetic */ f wJW;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(f fVar) {
            super(1);
            this.wJW = fVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(LinkedList<clp> linkedList) {
            AppMethodBeat.i(241068);
            LinkedList<clp> linkedList2 = linkedList;
            p.h(linkedList2, LocaleUtil.ITALIAN);
            if (!linkedList2.isEmpty()) {
                h.INSTANCE.dN(1565, 20);
                Log.i(this.wJW.vRb, "get music recommend success");
                Log.i(this.wJW.TAG, "music size " + linkedList2.size());
                this.wJW.eL(linkedList2);
            } else {
                h.INSTANCE.dN(1565, 21);
                Log.i(this.wJW.vRb, "get music recommend fail");
                Log.i(this.wJW.TAG, "music size is zero");
            }
            Log.d(this.wJW.TAG, "notify task end");
            x xVar = x.SXb;
            AppMethodBeat.o(241068);
            return xVar;
        }
    }

    public /* synthetic */ f(byte b2) {
        this();
    }

    private f() {
        AppMethodBeat.i(241070);
        this.TAG = "MMVideoEditorAudioRecommend";
        this.vRb = "MMVideoEditorAudioRecommend.FlutterVideoEditor_DataReport";
        this.wJR = new ArrayList<>();
        this.wJT = new com.tencent.mm.vending.e.c<>();
        this.uiThreadHandler = new Handler(Looper.getMainLooper());
        this.gWp = new b(this);
        AppMethodBeat.o(241070);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0005\u001a\u00020\u0004R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0006"}, hxF = {"Lcom/tencent/mm/plugin/flutter/plugins/video/api/MMVideoEditorAudioRecommend$Companion;", "", "()V", "mInstance", "Lcom/tencent/mm/plugin/flutter/plugins/video/api/MMVideoEditorAudioRecommend;", "getInstance", "plugin-flutter_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static f dLQ() {
            AppMethodBeat.i(241064);
            if (f.wJU == null) {
                f.wJU = new f((byte) 0);
            }
            f fVar = f.wJU;
            if (fVar == null) {
                p.hyc();
            }
            AppMethodBeat.o(241064);
            return fVar;
        }
    }

    public final void eL(List<? extends clp> list) {
        long j2;
        AppMethodBeat.i(241069);
        p.h(list, "audioList");
        this.wJR.clear();
        int i2 = 0;
        for (T t : list) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                j.hxH();
            }
            AudioCacheInfo.a aVar = AudioCacheInfo.BPo;
            AudioCacheInfo.a aVar2 = AudioCacheInfo.BPo;
            AudioCacheInfo a2 = AudioCacheInfo.a.a(t, AudioCacheInfo.BPh);
            AudioCacheInfo.a aVar3 = AudioCacheInfo.BPo;
            a2.source = AudioCacheInfo.BPm;
            a2.position = i2;
            com.tencent.mm.plugin.recordvideo.model.audio.a aVar4 = this.wJS;
            if (aVar4 != null) {
                j2 = aVar4.BOT;
            } else {
                j2 = -1;
            }
            a2.BPd = j2;
            this.wJR.add(a2);
            i2 = i3;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<AudioCacheInfo> it = this.wJR.iterator();
        while (it.hasNext()) {
            AudioCacheInfo next = it.next();
            HashMap hashMap = new HashMap();
            String str = next.cachePath;
            if (str != null) {
                hashMap.put("cachePath", str);
            }
            hashMap.put(FFmpegMetadataRetriever.METADATA_KEY_DURATION, Integer.valueOf(next.duration));
            ArrayList arrayList2 = new ArrayList();
            ArrayList<AudioCacheInfo.c> arrayList3 = next.BOY;
            if (arrayList3 == null) {
                p.hyc();
            }
            Iterator<AudioCacheInfo.c> it2 = arrayList3.iterator();
            while (it2.hasNext()) {
                AudioCacheInfo.c next2 = it2.next();
                HashMap hashMap2 = new HashMap();
                hashMap2.put("lrc", next2.BPp);
                hashMap2.put("startTime", Integer.valueOf(next2.dvv));
                hashMap2.put("endTime", Integer.valueOf(next2.BPq));
                arrayList2.add(hashMap2);
            }
            hashMap.put("lrcList", arrayList2);
            ArrayList arrayList4 = new ArrayList();
            Iterator<String> it3 = next.BOZ.iterator();
            while (it3.hasNext()) {
                arrayList4.add(it3.next());
            }
            hashMap.put("singers", arrayList4);
            hashMap.put("songName", next.BPc);
            hashMap.put("musicId", Integer.valueOf(next.BOX));
            hashMap.put("cached", Boolean.valueOf(next.aXa));
            String str2 = next.musicUrl;
            if (str2 != null) {
                hashMap.put("musicUrl", str2);
            }
            arrayList.add(hashMap);
        }
        o.a aVar5 = o.wKI;
        o.a.dMh().t("onReceiveMusicRecommend", arrayList);
        AppMethodBeat.o(241069);
    }
}

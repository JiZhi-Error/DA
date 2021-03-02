package com.tencent.mm.plugin.recordvideo.model.audio;

import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.f;
import com.tencent.mm.i.d;
import com.tencent.mm.i.g;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.plugin.recordvideo.e.c;
import com.tencent.mm.plugin.recordvideo.model.audio.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vending.e.a;
import com.tencent.mm.vfs.s;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u001d\u0012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006JD\u0010\u0019\u001a\u00020\u00112<\b\u0002\u0010\u001a\u001a6\u0012\u0013\u0012\u00110\f¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0015\u0012\u0013\u0018\u00010\b¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u000bJ\u0006\u0010\u001b\u001a\u00020\u0011J\b\u0010\u001c\u001a\u00020\u0011H\u0016J\u001a\u0010\u001d\u001a\u00020\u00112\u0006\u0010\u000f\u001a\u00020\f2\b\u0010\u0010\u001a\u0004\u0018\u00010\bH\u0002J\u0006\u0010\u001e\u001a\u00020\u0011R\u000e\u0010\u0007\u001a\u00020\bXD¢\u0006\u0002\n\u0000Rû\u0001\u0010\t\u001aî\u0001\u0012p\u0012n\u0012\u0013\u0012\u00110\f¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0015\u0012\u0013\u0018\u00010\b¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u0011 \u0012*6\u0012\u0013\u0012\u00110\f¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0015\u0012\u0013\u0018\u00010\b¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u000b0\u000b \u0012*v\u0012p\u0012n\u0012\u0013\u0012\u00110\f¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0015\u0012\u0013\u0018\u00010\b¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u0011 \u0012*6\u0012\u0013\u0012\u00110\f¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0015\u0012\u0013\u0018\u00010\b¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u000b0\u000b\u0018\u00010\u00130\nX\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, hxF = {"Lcom/tencent/mm/plugin/recordvideo/model/audio/AudioDownloadTask;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycle;", "lifeCycleKeeper", "Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;", "info", "Lcom/tencent/mm/plugin/recordvideo/model/audio/AudioCacheInfo;", "(Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;Lcom/tencent/mm/plugin/recordvideo/model/audio/AudioCacheInfo;)V", "TAG", "", "callbacks", "", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "success", "filePath", "", "kotlin.jvm.PlatformType", "", "getInfo", "()Lcom/tencent/mm/plugin/recordvideo/model/audio/AudioCacheInfo;", "mediaId", "task", "Lcom/tencent/mm/cdn/keep_TaskInfo;", "addCallback", "cb", "cancel", "dead", "notifyCallbacks", "start", "plugin-recordvideo_release"})
public final class b implements a {
    private final g BPr;
    private final AudioCacheInfo BPs;
    final String TAG = "MicroMsg.AudioDownloadTask";
    private final List<m<Boolean, String, x>> callbacks = Collections.synchronizedList(new ArrayList());
    private final com.tencent.mm.vending.e.b<a> gZm;
    private final String mediaId;

    public b(com.tencent.mm.vending.e.b<a> bVar, AudioCacheInfo audioCacheInfo) {
        p.h(audioCacheInfo, "info");
        AppMethodBeat.i(75414);
        this.gZm = bVar;
        this.BPs = audioCacheInfo;
        final String str = this.BPs.cachePath + "_temp";
        final String str2 = this.BPs.cachePath;
        c cVar = c.Cic;
        c.aLP(str);
        if (str2 != null) {
            c cVar2 = c.Cic;
            c.aLP(str2);
        }
        this.mediaId = "downaudio_" + this.BPs.BOX;
        this.BPr = new g();
        this.BPr.taskName = "task_AudioDownloadTask";
        this.BPr.gqC = 60;
        this.BPr.gqD = 60;
        this.BPr.field_mediaId = this.mediaId;
        this.BPr.gqB = this.BPs.musicUrl;
        this.BPr.field_fileType = CdnLogic.kMediaTypeStoryAudio;
        this.BPr.field_fullpath = str;
        this.BPr.gqy = new g.a(this) {
            /* class com.tencent.mm.plugin.recordvideo.model.audio.b.AnonymousClass1 */
            final /* synthetic */ b BPt;

            {
                this.BPt = r1;
            }

            @Override // com.tencent.mm.i.g.a
            public final int a(String str, int i2, com.tencent.mm.i.c cVar, d dVar, boolean z) {
                String str2;
                String str3;
                AppMethodBeat.i(75406);
                p.h(str, "mediaId");
                String str4 = this.BPt.TAG;
                Object[] objArr = new Object[4];
                objArr[0] = str;
                objArr[1] = Integer.valueOf(i2);
                if (cVar == null || (str2 = cVar.toString()) == null) {
                    str2 = BuildConfig.COMMAND;
                }
                objArr[2] = str2;
                if (dVar == null || (str3 = dVar.toString()) == null) {
                    str3 = BuildConfig.COMMAND;
                }
                objArr[3] = str3;
                Log.d(str4, "AudioDownloadTask on cdn callback mediaId = %s, startRet = %d, keep_ProgressInfo = %s, keep_SceneResult = %s", objArr);
                if (dVar != null) {
                    if (dVar.field_retCode == 0) {
                        Log.i(this.BPt.TAG, "download success " + str + ' ' + str2);
                        s.nx(str, str2);
                        b.a(this.BPt, true, str2);
                    } else {
                        Log.w(this.BPt.TAG, "download fail sceneResult " + dVar.field_retCode);
                        b.a(this.BPt, false, null);
                    }
                } else if (i2 != 0) {
                    Log.w(this.BPt.TAG, "download fail startRet ".concat(String.valueOf(i2)));
                    b.a(this.BPt, false, null);
                }
                AppMethodBeat.o(75406);
                return 0;
            }

            @Override // com.tencent.mm.i.g.a
            public final void a(String str, ByteArrayOutputStream byteArrayOutputStream) {
                AppMethodBeat.i(75407);
                p.h(str, "mediaId");
                p.h(byteArrayOutputStream, "buff");
                AppMethodBeat.o(75407);
            }

            @Override // com.tencent.mm.i.g.a
            public final byte[] f(String str, byte[] bArr) {
                AppMethodBeat.i(75408);
                p.h(str, "mediaId");
                p.h(bArr, "inbuf");
                byte[] bArr2 = new byte[0];
                AppMethodBeat.o(75408);
                return bArr2;
            }
        };
        AppMethodBeat.o(75414);
    }

    public static final /* synthetic */ void a(b bVar, boolean z, String str) {
        AppMethodBeat.i(75415);
        bVar.B(z, str);
        AppMethodBeat.o(75415);
    }

    public final void start() {
        AppMethodBeat.i(75409);
        if (!f.baQ().e(this.BPr)) {
            B(false, null);
            AppMethodBeat.o(75409);
            return;
        }
        com.tencent.mm.vending.e.b<a> bVar = this.gZm;
        if (bVar != null) {
            bVar.keep(this);
            AppMethodBeat.o(75409);
            return;
        }
        AppMethodBeat.o(75409);
    }

    public final void h(m<? super Boolean, ? super String, x> mVar) {
        AppMethodBeat.i(75410);
        if (mVar != null) {
            this.callbacks.add(mVar);
        }
        AppMethodBeat.o(75410);
    }

    public final void cancel() {
        AppMethodBeat.i(75411);
        Log.i(this.TAG, "cancel " + this.mediaId);
        f.baQ().Oc(this.mediaId);
        this.callbacks.clear();
        AppMethodBeat.o(75411);
    }

    @Override // com.tencent.mm.vending.e.a
    public final void dead() {
        AppMethodBeat.i(75412);
        i.a aVar = i.BPL;
        i.BPK.c(this.BPs);
        AppMethodBeat.o(75412);
    }

    private final void B(boolean z, String str) {
        AppMethodBeat.i(75413);
        List<m<Boolean, String, x>> list = this.callbacks;
        p.g(list, "callbacks");
        List<m<Boolean, String, x>> list2 = list;
        synchronized (list2) {
            try {
                Iterator<T> it = list2.iterator();
                while (it.hasNext()) {
                    it.next().invoke(Boolean.valueOf(z), str);
                }
                x xVar = x.SXb;
            } catch (Throwable th) {
                AppMethodBeat.o(75413);
                throw th;
            }
        }
        this.callbacks.clear();
        AppMethodBeat.o(75413);
    }
}

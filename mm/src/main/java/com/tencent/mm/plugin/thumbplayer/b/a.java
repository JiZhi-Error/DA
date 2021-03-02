package com.tencent.mm.plugin.thumbplayer.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.data.APMidasPluginInfo;
import com.tencent.mm.an.a;
import com.tencent.mm.i.b;
import com.tencent.mm.i.g;
import com.tencent.mm.i.h;
import com.tencent.mm.model.cl;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0002./B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\r\u001a\u00020\u000eJ\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0004J\u001e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0013J\u0006\u0010\u0016\u001a\u00020\u000eJ2\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u00132\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001aJ\u0010\u0010\u001b\u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00020\u0007H\u0002J\u0010\u0010\u001d\u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00020\u0007H\u0002J\u001a\u0010\u001e\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00020\u00072\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001fJ\"\u0010 \u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010!\u001a\u00020\"2\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001fJ\u001a\u0010#\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00020\u00072\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010$J\"\u0010%\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010!\u001a\u00020\"2\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010$J\b\u0010&\u001a\u00020\u000eH\u0002J\u0010\u0010'\u001a\u00020\u00132\u0006\u0010\u0011\u001a\u00020\u0004H\u0002J\u0018\u0010(\u001a\u00020\u00132\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010)\u001a\u00020\u000bH\u0002J\u001a\u0010*\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00042\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010+J\u001a\u0010,\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00042\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010-R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R*\u0010\u0005\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070\u0006j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0007`\bX\u0004¢\u0006\u0002\n\u0000R*\u0010\t\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070\u0006j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0007`\bX\u0004¢\u0006\u0002\n\u0000R*\u0010\n\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000b0\u0006j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000b`\bX\u0004¢\u0006\u0002\n\u0000R*\u0010\f\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070\u0006j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0007`\bX\u0004¢\u0006\u0002\n\u0000¨\u00060"}, hxF = {"Lcom/tencent/mm/plugin/thumbplayer/cdn/CdnTaskController;", "", "()V", "TAG", "", "runningPreloadTaskMap", "Ljava/util/HashMap;", "Lcom/tencent/mm/cdn/keep_VideoTaskInfo;", "Lkotlin/collections/HashMap;", "runningStreamTaskMap", "streamFinishResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "streamFinishTask", APMidasPluginInfo.LAUNCH_INTERFACE_INIT, "", "isMediaInRunningStreamTaskMap", "", "mediaId", "isVideoDataAvailable", "", "offset", "length", "release", "requestVideoData", FFmpegMetadataRetriever.METADATA_KEY_DURATION, "callback", "Lcom/tencent/mm/plugin/thumbplayer/cdn/RequestStreamingVideoDataCallback;", "startJniPreloadTask", "task", "startJniStreamTask", "startPreloadDownloadTask", "Lcom/tencent/mm/plugin/thumbplayer/cdn/StartPreloadDownloadCallback;", "startPreloadDownloadTaskAsync", "createCallback", "Lcom/tencent/mm/plugin/thumbplayer/cdn/CreateCdnDownloadTaskCallback;", "startStreamDownloadTask", "Lcom/tencent/mm/plugin/thumbplayer/cdn/StartStreamingDownloadCallback;", "startStreamDownloadTaskAsync", "stopAllJniStreamTask", "stopJniPreloadTask", "stopJniStreamTask", "downloadResult", "stopPreloadDownloadTask", "Lcom/tencent/mm/plugin/thumbplayer/cdn/StopPreloadDownloadCallback;", "stopStreamDownloadTask", "Lcom/tencent/mm/plugin/thumbplayer/cdn/StopStreamingDownloadCallback;", "PreloadTaskCallback", "StreamTaskCallback", "plugin-thumbplayer_release"})
public final class a {
    public final HashMap<String, com.tencent.mm.i.h> Ggu = new HashMap<>();
    public final HashMap<String, com.tencent.mm.i.h> Ggv = new HashMap<>();
    public final HashMap<String, com.tencent.mm.i.h> Ggw = new HashMap<>();
    public final HashMap<String, com.tencent.mm.i.d> Ggx = new HashMap<>();
    public final String TAG = "MicroMsg.TP.CdnTaskController";

    public a() {
        AppMethodBeat.i(238639);
        AppMethodBeat.o(238639);
    }

    public final boolean a(String str, f fVar) {
        AppMethodBeat.i(238634);
        p.h(str, "mediaId");
        com.tencent.mm.ac.d.c("MicroMsg.Cdn.ThreadName", new g(this, str, fVar));
        AppMethodBeat.o(238634);
        return true;
    }

    public final boolean a(String str, b bVar, e eVar) {
        AppMethodBeat.i(238635);
        p.h(str, "mediaId");
        p.h(bVar, "createCallback");
        if (str.length() == 0) {
            AppMethodBeat.o(238635);
            return false;
        }
        Log.i(this.TAG, "startStreamDownloadTaskAsync mediaId:".concat(String.valueOf(str)));
        com.tencent.mm.ac.d.c("MicroMsg.Cdn.ThreadName", new f(this, bVar, str, eVar));
        AppMethodBeat.o(238635);
        return true;
    }

    public final boolean a(String str, g gVar) {
        AppMethodBeat.i(238636);
        p.h(str, "mediaId");
        Log.i(this.TAG, "stopStreamDownloadTask " + str + ' ' + gVar + " runningStreamTask:" + this.Ggu.size());
        com.tencent.mm.ac.d.c("MicroMsg.Cdn.ThreadName", new h(this, str, gVar));
        AppMethodBeat.o(238636);
        return true;
    }

    /* access modifiers changed from: package-private */
    public final int d(String str, com.tencent.mm.i.d dVar) {
        AppMethodBeat.i(238637);
        com.tencent.mm.an.f.baR();
        int c2 = com.tencent.mm.an.a.c(str, dVar);
        if (c2 == 0 || c2 == -21007 || c2 == -21008) {
            this.Ggu.remove(str);
        }
        Log.i(this.TAG, "stopJniStreamTask " + str + ' ' + c2);
        AppMethodBeat.o(238637);
        return c2;
    }

    public final int a(String str, int i2, int i3, c cVar) {
        AppMethodBeat.i(238638);
        p.h(str, "mediaId");
        if (this.Ggu.containsKey(str)) {
            com.tencent.mm.ac.d.c("MicroMsg.Cdn.ThreadName", new c(this, str, i2, i3, cVar));
            AppMethodBeat.o(238638);
            return 1;
        }
        Log.i(this.TAG, "requestVideoData not running id mediaId:" + str + " offset:" + i2 + " length:" + i3);
        AppMethodBeat.o(238638);
        return 0;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J&\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\u001c\u0010\u000b\u001a\u00020\f2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J\u001c\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\r\u001a\u0004\u0018\u00010\u0010H\u0016J\u001c\u0010\u0011\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016¨\u0006\u0012"}, hxF = {"Lcom/tencent/mm/plugin/thumbplayer/cdn/CdnTaskController$PreloadTaskCallback;", "Lcom/tencent/mm/cdn/TransportService$CdnTransCallback;", "(Lcom/tencent/mm/plugin/thumbplayer/cdn/CdnTaskController;)V", "callback", "", "mediaId", "", "progressInfo", "Lcom/tencent/mm/cdn/keep_ProgressInfo;", "sceneResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "decodePrepareResponse", "", "buff", "getCdnAuthInfo", "", "Ljava/io/ByteArrayOutputStream;", "onPreloadCompleted", "plugin-thumbplayer_release"})
    /* renamed from: com.tencent.mm.plugin.thumbplayer.b.a$a  reason: collision with other inner class name */
    public final class C1830a implements b.a {
        /* JADX WARN: Incorrect args count in method signature: ()V */
        public C1830a() {
        }

        @Override // com.tencent.mm.i.b.a
        public final void a(String str, ByteArrayOutputStream byteArrayOutputStream) {
        }

        @Override // com.tencent.mm.i.b.a
        public final byte[] f(String str, byte[] bArr) {
            return new byte[0];
        }

        @Override // com.tencent.mm.i.b.a
        public final int a(String str, com.tencent.mm.i.d dVar) {
            AppMethodBeat.i(238618);
            Log.d(a.this.TAG, "callback by jni onPreloadCompleted mediaId:" + str + " retCode:" + (dVar != null ? Integer.valueOf(dVar.field_retCode) : null));
            if (str == null) {
                AppMethodBeat.o(238618);
                return 0;
            } else if (a.this.Ggv.containsKey(str)) {
                com.tencent.mm.ac.d.c("MicroMsg.Cdn.ThreadName", new b(str, this, dVar, str));
                AppMethodBeat.o(238618);
                return 1;
            } else {
                AppMethodBeat.o(238618);
                return 0;
            }
        }

        @Override // com.tencent.mm.i.b.a
        public final int a(String str, com.tencent.mm.i.c cVar, com.tencent.mm.i.d dVar) {
            long j2;
            int i2;
            AppMethodBeat.i(238619);
            String str2 = a.this.TAG;
            StringBuilder append = new StringBuilder("callback preload by jni mediaId:").append(str).append(" progressFinishLength:");
            if (cVar != null) {
                j2 = cVar.field_finishedLength;
            } else {
                j2 = 0;
            }
            StringBuilder append2 = append.append(j2).append(" sceneResultRet:");
            if (dVar != null) {
                i2 = dVar.field_retCode;
            } else {
                i2 = 0;
            }
            Log.d(str2, append2.append(i2).toString());
            if (str == null) {
                AppMethodBeat.o(238619);
                return 0;
            } else if (a.this.Ggv.containsKey(str)) {
                com.tencent.mm.ac.d.c("MicroMsg.Cdn.ThreadName", new C1831a(str, this, cVar, str, dVar));
                AppMethodBeat.o(238619);
                return 1;
            } else {
                AppMethodBeat.o(238619);
                return 0;
            }
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, hxF = {"<anonymous>", "", "invoke", "com/tencent/mm/plugin/thumbplayer/cdn/CdnTaskController$PreloadTaskCallback$onPreloadCompleted$1$1"})
        /* renamed from: com.tencent.mm.plugin.thumbplayer.b.a$a$b */
        static final class b extends q implements kotlin.g.a.a<x> {
            final /* synthetic */ C1830a Ggz;
            final /* synthetic */ String pAl;
            final /* synthetic */ String uJv;
            final /* synthetic */ com.tencent.mm.i.d uJy;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            b(String str, C1830a aVar, com.tencent.mm.i.d dVar, String str2) {
                super(0);
                this.pAl = str;
                this.Ggz = aVar;
                this.uJy = dVar;
                this.uJv = str2;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ x invoke() {
                com.tencent.mm.i.d dVar;
                AppMethodBeat.i(238617);
                com.tencent.mm.i.h hVar = a.this.Ggv.get(this.pAl);
                if (hVar != null) {
                    a.this.Ggv.remove(this.pAl);
                    g.b bVar = hVar.gqQ;
                    if (!(bVar == null || (dVar = this.uJy) == null)) {
                        Log.i(a.this.TAG, "callback by CdnTaskController onPreloadCompleted mediaId:" + this.uJv + " retCode:" + dVar.field_retCode);
                        bVar.b(this.pAl, dVar);
                    }
                }
                x xVar = x.SXb;
                AppMethodBeat.o(238617);
                return xVar;
            }
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, hxF = {"<anonymous>", "", "invoke", "com/tencent/mm/plugin/thumbplayer/cdn/CdnTaskController$PreloadTaskCallback$callback$1$1"})
        /* renamed from: com.tencent.mm.plugin.thumbplayer.b.a$a$a  reason: collision with other inner class name */
        static final class C1831a extends q implements kotlin.g.a.a<x> {
            final /* synthetic */ com.tencent.mm.i.c GgA;
            final /* synthetic */ C1830a Ggz;
            final /* synthetic */ String pAl;
            final /* synthetic */ String uJv;
            final /* synthetic */ com.tencent.mm.i.d uJy;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            C1831a(String str, C1830a aVar, com.tencent.mm.i.c cVar, String str2, com.tencent.mm.i.d dVar) {
                super(0);
                this.pAl = str;
                this.Ggz = aVar;
                this.GgA = cVar;
                this.uJv = str2;
                this.uJy = dVar;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ x invoke() {
                g.a aVar;
                com.tencent.mm.i.c cVar;
                AppMethodBeat.i(238616);
                com.tencent.mm.i.h hVar = a.this.Ggv.get(this.pAl);
                if (!(hVar == null || (aVar = hVar.gqy) == null || (cVar = this.GgA) == null)) {
                    Log.i(a.this.TAG, "callback by CdnTaskController onProgress mediaId:" + this.uJv + " progressFinishLength:" + cVar.field_finishedLength);
                    aVar.a(this.uJv, 0, cVar, this.uJy, hVar.field_onlycheckexist);
                }
                x xVar = x.SXb;
                AppMethodBeat.o(238616);
                return xVar;
            }
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J&\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\"\u0010\u000b\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0004H\u0016J\"\u0010\u000e\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0004H\u0016J\u001c\u0010\u000f\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0010\u001a\u0004\u0018\u00010\u0006H\u0016J,\u0010\u0011\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u0006H\u0016¨\u0006\u0013"}, hxF = {"Lcom/tencent/mm/plugin/thumbplayer/cdn/CdnTaskController$StreamTaskCallback;", "Lcom/tencent/mm/modelcdntran/CdnTransportEngine$CdnOnlineVideoCallback;", "(Lcom/tencent/mm/plugin/thumbplayer/cdn/CdnTaskController;)V", "callback", "", "mediaId", "", "progressInfo", "Lcom/tencent/mm/cdn/keep_ProgressInfo;", "sceneResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "onDataAvailable", "offset", "length", "onDownloadToEnd", "onM3U8Ready", "m3u8", "onMoovReady", "svrflag", "plugin-thumbplayer_release"})
    public final class b implements a.AbstractC0257a {
        /* JADX WARN: Incorrect args count in method signature: ()V */
        public b() {
        }

        @Override // com.tencent.mm.an.a.AbstractC0257a
        public final int d(String str, int i2, int i3, String str2) {
            AppMethodBeat.i(238624);
            Log.d(a.this.TAG, "callback by jni onMoovReady mediaId:" + str + " offset:" + i2 + " length:" + i3);
            if (str == null) {
                AppMethodBeat.o(238624);
                return 0;
            } else if (a.this.Ggu.containsKey(str)) {
                com.tencent.mm.ac.d.c("MicroMsg.Cdn.ThreadName", new c(str, this, i2, i3, str2));
                AppMethodBeat.o(238624);
                return 1;
            } else {
                AppMethodBeat.o(238624);
                return 0;
            }
        }

        @Override // com.tencent.mm.an.a.AbstractC0257a
        public final int p(String str, int i2, int i3) {
            AppMethodBeat.i(238625);
            Log.d(a.this.TAG, "callback by jni onDataAvailable mediaId:" + str + " offset:" + i2 + " length:" + i3);
            if (str == null) {
                AppMethodBeat.o(238625);
                return 0;
            } else if (a.this.Ggu.containsKey(str)) {
                com.tencent.mm.ac.d.c("MicroMsg.Cdn.ThreadName", new C1833b(str, this, i2, i3));
                AppMethodBeat.o(238625);
                return 1;
            } else {
                AppMethodBeat.o(238625);
                return 0;
            }
        }

        @Override // com.tencent.mm.an.a.AbstractC0257a
        public final int q(String str, int i2, int i3) {
            AppMethodBeat.i(238626);
            Log.d(a.this.TAG, "callback by jni onDownloadToEnd mediaId:" + str + " offset:" + i2 + " length:" + i3);
            AppMethodBeat.o(238626);
            return 0;
        }

        @Override // com.tencent.mm.an.a.AbstractC0257a
        public final int a(String str, com.tencent.mm.i.c cVar, com.tencent.mm.i.d dVar) {
            long j2;
            int i2;
            AppMethodBeat.i(238627);
            String str2 = a.this.TAG;
            StringBuilder append = new StringBuilder("callback stream by jni mediaId:").append(str).append(" progressFinishLength:");
            if (cVar != null) {
                j2 = cVar.field_finishedLength;
            } else {
                j2 = 0;
            }
            StringBuilder append2 = append.append(j2).append(" sceneResultRet:");
            if (dVar != null) {
                i2 = dVar.field_retCode;
            } else {
                i2 = 0;
            }
            Log.d(str2, append2.append(i2).toString());
            if (str == null) {
                AppMethodBeat.o(238627);
                return 0;
            } else if (a.this.Ggu.containsKey(str)) {
                com.tencent.mm.ac.d.c("MicroMsg.Cdn.ThreadName", new C1832a(str, this, cVar, str, dVar));
                AppMethodBeat.o(238627);
                return 1;
            } else {
                AppMethodBeat.o(238627);
                return 0;
            }
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, hxF = {"<anonymous>", "", "invoke", "com/tencent/mm/plugin/thumbplayer/cdn/CdnTaskController$StreamTaskCallback$onMoovReady$1$1"})
        static final class c extends q implements kotlin.g.a.a<x> {
            final /* synthetic */ b GgB;
            final /* synthetic */ int GgF;
            final /* synthetic */ int GgG;
            final /* synthetic */ String pAl;
            final /* synthetic */ String uJE;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            c(String str, b bVar, int i2, int i3, String str2) {
                super(0);
                this.pAl = str;
                this.GgB = bVar;
                this.GgF = i2;
                this.GgG = i3;
                this.uJE = str2;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ x invoke() {
                AppMethodBeat.i(238623);
                com.tencent.mm.i.h hVar = a.this.Ggu.get(this.pAl);
                if (hVar != null) {
                    hVar.gra = (long) this.GgF;
                    h.a aVar = hVar.gre;
                    if (aVar != null) {
                        Log.i(a.this.TAG, "callback by CdnTaskController onMoovReady mediaId:" + this.pAl + " offset:" + this.GgF + " length:" + this.GgG);
                        aVar.a(this.pAl, (long) this.GgF, (long) this.GgG, this.uJE);
                    }
                }
                x xVar = x.SXb;
                AppMethodBeat.o(238623);
                return xVar;
            }
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, hxF = {"<anonymous>", "", "invoke", "com/tencent/mm/plugin/thumbplayer/cdn/CdnTaskController$StreamTaskCallback$onDataAvailable$1$1"})
        /* renamed from: com.tencent.mm.plugin.thumbplayer.b.a$b$b  reason: collision with other inner class name */
        static final class C1833b extends q implements kotlin.g.a.a<x> {
            final /* synthetic */ b GgB;
            final /* synthetic */ int GgF;
            final /* synthetic */ int GgG;
            final /* synthetic */ String pAl;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            C1833b(String str, b bVar, int i2, int i3) {
                super(0);
                this.pAl = str;
                this.GgB = bVar;
                this.GgF = i2;
                this.GgG = i3;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ x invoke() {
                AppMethodBeat.i(238622);
                com.tencent.mm.i.h hVar = a.this.Ggu.get(this.pAl);
                if (hVar != null) {
                    hVar.gra = (long) this.GgF;
                    h.a aVar = hVar.gre;
                    if (aVar != null) {
                        Log.i(a.this.TAG, "callback by CdnTaskController onDataAvailable mediaId:" + this.pAl + " offset:" + this.GgF + " length:" + this.GgG + " callback:" + aVar.hashCode());
                        aVar.onDataAvailable(this.pAl, (long) this.GgF, (long) this.GgG);
                    }
                }
                x xVar = x.SXb;
                AppMethodBeat.o(238622);
                return xVar;
            }
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, hxF = {"<anonymous>", "", "invoke", "com/tencent/mm/plugin/thumbplayer/cdn/CdnTaskController$StreamTaskCallback$callback$1$1"})
        /* renamed from: com.tencent.mm.plugin.thumbplayer.b.a$b$a  reason: collision with other inner class name */
        static final class C1832a extends q implements kotlin.g.a.a<x> {
            final /* synthetic */ com.tencent.mm.i.c GgA;
            final /* synthetic */ b GgB;
            final /* synthetic */ String pAl;
            final /* synthetic */ String uJv;
            final /* synthetic */ com.tencent.mm.i.d uJy;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            C1832a(String str, b bVar, com.tencent.mm.i.c cVar, String str2, com.tencent.mm.i.d dVar) {
                super(0);
                this.pAl = str;
                this.GgB = bVar;
                this.GgA = cVar;
                this.uJv = str2;
                this.uJy = dVar;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX WARNING: Code restructure failed: missing block: B:2:0x0017, code lost:
                r0 = r6.gre;
             */
            @Override // kotlin.g.a.a
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final /* synthetic */ kotlin.x invoke() {
                /*
                // Method dump skipped, instructions count: 221
                */
                throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.thumbplayer.b.a.b.C1832a.invoke():java.lang.Object");
            }
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class d extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ com.tencent.mm.i.h GgI;
        final /* synthetic */ d GgJ;
        final /* synthetic */ a Ggy;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(a aVar, com.tencent.mm.i.h hVar, d dVar) {
            super(0);
            this.Ggy = aVar;
            this.GgI = hVar;
            this.GgJ = dVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            int i2 = -1;
            AppMethodBeat.i(238629);
            if (this.Ggy.Ggu.containsKey(this.GgI.field_mediaId)) {
                d dVar = this.GgJ;
                if (dVar != null) {
                    dVar.JS(-1);
                }
            } else {
                a aVar = this.Ggy;
                String str = this.GgI.field_mediaId;
                p.g(str, "task.field_mediaId");
                a.a(aVar, str);
                this.GgI.field_startTime = cl.aWA();
                if (this.GgI.alT()) {
                    i2 = a.a(this.Ggy, this.GgI);
                }
                d dVar2 = this.GgJ;
                if (dVar2 != null) {
                    dVar2.JS(i2);
                }
            }
            x xVar = x.SXb;
            AppMethodBeat.o(238629);
            return xVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class e extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ d GgJ;
        final /* synthetic */ b GgK;
        final /* synthetic */ a Ggy;
        final /* synthetic */ String qWs;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public e(a aVar, b bVar, String str, d dVar) {
            super(0);
            this.Ggy = aVar;
            this.GgK = bVar;
            this.qWs = str;
            this.GgJ = dVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX WARNING: Code restructure failed: missing block: B:13:0x003c, code lost:
            if (r0 == null) goto L_0x003e;
         */
        @Override // kotlin.g.a.a
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final /* synthetic */ kotlin.x invoke() {
            /*
            // Method dump skipped, instructions count: 133
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.thumbplayer.b.a.e.invoke():java.lang.Object");
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class g extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ f GgM;
        final /* synthetic */ a Ggy;
        final /* synthetic */ String qWs;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        g(a aVar, String str, f fVar) {
            super(0);
            this.Ggy = aVar;
            this.qWs = str;
            this.GgM = fVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(238632);
            if (!this.Ggy.Ggv.containsKey(this.qWs)) {
                f fVar = this.GgM;
                if (fVar != null) {
                    fVar.JR(-1);
                }
            } else {
                a.a(this.Ggy, this.qWs);
                f fVar2 = this.GgM;
                if (fVar2 != null) {
                    fVar2.JR(0);
                }
            }
            x xVar = x.SXb;
            AppMethodBeat.o(238632);
            return xVar;
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class f extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ b GgK;
        final /* synthetic */ e GgL;
        final /* synthetic */ a Ggy;
        final /* synthetic */ String qWs;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        f(a aVar, b bVar, String str, e eVar) {
            super(0);
            this.Ggy = aVar;
            this.GgK = bVar;
            this.qWs = str;
            this.GgL = eVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX WARNING: Removed duplicated region for block: B:23:0x0085  */
        @Override // kotlin.g.a.a
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final /* synthetic */ kotlin.x invoke() {
            /*
            // Method dump skipped, instructions count: 286
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.thumbplayer.b.a.f.invoke():java.lang.Object");
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class h extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ g GgN;
        final /* synthetic */ a Ggy;
        final /* synthetic */ String qWs;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        h(a aVar, String str, g gVar) {
            super(0);
            this.Ggy = aVar;
            this.qWs = str;
            this.GgN = gVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX WARNING: Code restructure failed: missing block: B:5:0x002a, code lost:
            if (r0 == null) goto L_0x002c;
         */
        @Override // kotlin.g.a.a
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final /* synthetic */ kotlin.x invoke() {
            /*
                r5 = this;
                r4 = 238633(0x3a429, float:3.34396E-40)
                com.tencent.matrix.trace.core.AppMethodBeat.i(r4)
                com.tencent.mm.plugin.thumbplayer.b.a r0 = r5.Ggy
                java.util.HashMap<java.lang.String, com.tencent.mm.i.h> r0 = r0.Ggu
                java.lang.String r1 = r5.qWs
                java.lang.Object r0 = r0.get(r1)
                com.tencent.mm.i.h r0 = (com.tencent.mm.i.h) r0
                if (r0 == 0) goto L_0x002c
                com.tencent.mm.i.d r1 = new com.tencent.mm.i.d
                r1.<init>()
                com.tencent.mm.plugin.thumbplayer.b.a r2 = r5.Ggy
                java.lang.String r3 = r5.qWs
                int r2 = r2.d(r3, r1)
                com.tencent.mm.plugin.thumbplayer.b.g r3 = r5.GgN
                if (r3 == 0) goto L_0x005a
                r3.a(r2, r0, r1)
                kotlin.x r0 = kotlin.x.SXb
            L_0x002a:
                if (r0 != 0) goto L_0x004f
            L_0x002c:
                com.tencent.mm.plugin.thumbplayer.b.a r1 = r5.Ggy
                java.util.HashMap<java.lang.String, com.tencent.mm.i.h> r0 = r1.Ggw
                java.lang.String r2 = r5.qWs
                java.lang.Object r0 = r0.remove(r2)
                com.tencent.mm.i.h r0 = (com.tencent.mm.i.h) r0
                java.util.HashMap<java.lang.String, com.tencent.mm.i.d> r1 = r1.Ggx
                java.lang.String r2 = r5.qWs
                java.lang.Object r1 = r1.remove(r2)
                com.tencent.mm.i.d r1 = (com.tencent.mm.i.d) r1
                com.tencent.mm.plugin.thumbplayer.b.g r3 = r5.GgN
                if (r3 == 0) goto L_0x004f
                if (r1 == 0) goto L_0x005c
                int r2 = r1.field_retCode
            L_0x004a:
                r3.a(r2, r0, r1)
                kotlin.x r0 = kotlin.x.SXb
            L_0x004f:
                com.tencent.mm.plugin.thumbplayer.b.a r0 = r5.Ggy
                com.tencent.mm.plugin.thumbplayer.b.a.a(r0)
                kotlin.x r0 = kotlin.x.SXb
                com.tencent.matrix.trace.core.AppMethodBeat.o(r4)
                return r0
            L_0x005a:
                r0 = 0
                goto L_0x002a
            L_0x005c:
                r2 = 0
                goto L_0x004a
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.thumbplayer.b.a.h.invoke():java.lang.Object");
        }
    }

    public static final /* synthetic */ int a(a aVar, String str) {
        AppMethodBeat.i(238640);
        com.tencent.mm.an.f.baR();
        com.tencent.mm.an.a.NU(str);
        aVar.Ggv.remove(str);
        Log.i(aVar.TAG, "stopJniPreloadTask " + str + ' ' + 0);
        AppMethodBeat.o(238640);
        return 0;
    }

    public static final /* synthetic */ int a(a aVar, com.tencent.mm.i.h hVar) {
        AppMethodBeat.i(238641);
        String str = hVar.field_mediaId;
        p.g(str, "task.field_mediaId");
        aVar.Ggv.put(str, hVar);
        int c2 = com.tencent.mm.an.f.baR().c(hVar);
        if (c2 != 0) {
            aVar.Ggv.remove(hVar.field_mediaId);
        }
        Log.i(aVar.TAG, "startJniPreloadTask " + hVar.field_mediaId + ' ' + c2);
        AppMethodBeat.o(238641);
        return c2;
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class c extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ int Ceg = 3000;
        final /* synthetic */ int FIm;
        final /* synthetic */ c GgH;
        final /* synthetic */ a Ggy;
        final /* synthetic */ int gUs;
        final /* synthetic */ String qWs;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(a aVar, String str, int i2, int i3, c cVar) {
            super(0);
            this.Ggy = aVar;
            this.qWs = str;
            this.gUs = i2;
            this.FIm = i3;
            this.GgH = cVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(238628);
            if (this.Ggy.Ggu.containsKey(this.qWs)) {
                com.tencent.mm.an.f.baR();
                int requestVideoData = com.tencent.mm.an.a.requestVideoData(this.qWs, (long) this.gUs, (long) this.FIm, this.Ceg);
                c cVar = this.GgH;
                if (cVar != null) {
                    cVar.Mg(requestVideoData);
                }
                Log.i(this.Ggy.TAG, "requestVideoData in cdn thread mediaId:" + this.qWs + " offset:" + this.gUs + " length:" + this.FIm + " ret:" + requestVideoData);
            } else {
                c cVar2 = this.GgH;
                if (cVar2 != null) {
                    cVar2.Mg(-1);
                }
                Log.i(this.Ggy.TAG, "requestVideoData not running id " + this.qWs);
            }
            x xVar = x.SXb;
            AppMethodBeat.o(238628);
            return xVar;
        }
    }

    public static final /* synthetic */ void a(a aVar) {
        AppMethodBeat.i(238642);
        if (aVar.Ggu.size() > 0) {
            Object clone = aVar.Ggu.clone();
            if (clone == null) {
                t tVar = new t("null cannot be cast to non-null type kotlin.collections.HashMap<kotlin.String, com.tencent.mm.cdn.keep_VideoTaskInfo> /* = java.util.HashMap<kotlin.String, com.tencent.mm.cdn.keep_VideoTaskInfo> */");
                AppMethodBeat.o(238642);
                throw tVar;
            }
            for (Map.Entry entry : ((HashMap) clone).entrySet()) {
                com.tencent.mm.i.d dVar = new com.tencent.mm.i.d();
                aVar.d((String) entry.getKey(), dVar);
                aVar.Ggw.put(entry.getKey(), entry.getValue());
                aVar.Ggx.put(entry.getKey(), dVar);
            }
        }
        AppMethodBeat.o(238642);
    }
}

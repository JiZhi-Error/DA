package com.tencent.mm.plugin.vlog.player;

import android.graphics.SurfaceTexture;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.os.Looper;
import android.view.Surface;
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.d.f;
import com.tencent.mm.media.d.i;
import com.tencent.mm.media.i.e;
import com.tencent.mm.plugin.n.d;
import com.tencent.mm.plugin.n.j;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.plugin.vlog.model.aj;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.s;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.n.n;
import kotlin.t;
import kotlin.x;

@kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0010\u0018\u0000 ,2\u00020\u0001:\u0001,B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\b\u0010\u001c\u001a\u00020\u001dH\u0002J\u0010\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\b\u001a\u00020\tH\u0016J\b\u0010\u001f\u001a\u00020\tH\u0016J\b\u0010 \u001a\u00020\tH\u0016J\u0006\u0010!\u001a\u00020\tJ\b\u0010\"\u001a\u00020\u001dH\u0016J\u0018\u0010#\u001a\u00020\u001d2\u0006\u0010$\u001a\u00020\u000e2\u0006\u0010%\u001a\u00020\tH\u0016J\b\u0010&\u001a\u00020\u001dH\u0016J\u0010\u0010'\u001a\u00020\u001d2\u0006\u0010\u0016\u001a\u00020\u000eH\u0016J\b\u0010(\u001a\u00020\u001dH\u0016J\b\u0010)\u001a\u00020\u001dH\u0016J\u0006\u0010*\u001a\u00020\tJ\b\u0010+\u001a\u00020\u001dH\u0016R\u000e\u0010\u000b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0014X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000¨\u0006-"}, hxF = {"Lcom/tencent/mm/plugin/vlog/player/VLogVideoPlayer;", "Lcom/tencent/mm/plugin/vlog/player/MaterialPlayer;", "texture", "", "drawWidth", "drawHeight", "material", "Lcom/tencent/mm/plugin/vlog/model/VideoMaterial;", "mute", "", "(IIILcom/tencent/mm/plugin/vlog/model/VideoMaterial;Z)V", "canPlaying", "didCheckCrop", "lastSurfaceUpdatedTime", "", "player", "Lcom/tencent/mm/plugin/mmplayer/VideoPlayer;", "playerCallback", "Lcom/tencent/mm/plugin/mmplayer/IPlayerCallback;", "prepareLock", "Ljava/lang/Object;", "seekLock", "seekTime", "surface", "Landroid/view/Surface;", "surfaceTexture", "Landroid/graphics/SurfaceTexture;", "videoIsPrepared", "checkCropRect", "", "enableMute", "isMirror", "isOES", "isPlaying", "pause", "playing", "pts", "updateTex", "prepare", "readyAt", "release", "resume", "start", "stop", "Companion", "plugin-vlog_release"})
public final class l extends b {
    public static final a GCo = new a((byte) 0);
    private long GCi;
    private final Object GCj = new Object();
    private final Object GCk = new Object();
    private volatile boolean GCl;
    private volatile boolean GCm;
    private boolean GCn;
    private long mEm;
    private j rsl;
    private d rsv = new c(this);
    private Surface surface;
    private SurfaceTexture surfaceTexture;

    static {
        AppMethodBeat.i(111004);
        AppMethodBeat.o(111004);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public l(int i2, int i3, int i4, aj ajVar, boolean z) {
        super(i2, i3, i4, ajVar, z);
        p.h(ajVar, "material");
        AppMethodBeat.i(111003);
        AppMethodBeat.o(111003);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/vlog/player/VLogVideoPlayer$Companion;", "", "()V", "TAG", "", "plugin-vlog_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0018\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\b\u001a\u00020\u0003H\u0016J\b\u0010\t\u001a\u00020\u0003H\u0016J \u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u0006H\u0016¨\u0006\u000e"}, hxF = {"com/tencent/mm/plugin/vlog/player/VLogVideoPlayer$playerCallback$1", "Lcom/tencent/mm/plugin/mmplayer/IPlayerCallback;", "onCompletion", "", "onError", "what", "", "error", "onPrepared", "onSeekComplete", "onVideoSizeChanged", "width", "height", "degrees", "plugin-vlog_release"})
    public static final class c implements d {
        final /* synthetic */ l GCp;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        c(l lVar) {
            this.GCp = lVar;
        }

        @Override // com.tencent.mm.plugin.n.d
        public final void tf() {
            AppMethodBeat.i(110990);
            Log.i("MicroMsg.VLogVideoPlayer", this.GCp.hashCode() + " onPrepared, canPlaying:" + this.GCp.GCl + ", notify all");
            this.GCp.GCm = true;
            synchronized (this.GCp.GCj) {
                try {
                    Log.i("MicroMsg.VLogVideoPlayer", this.GCp.hashCode() + " onPrepared notifyAll");
                    this.GCp.GCj.notifyAll();
                } catch (Exception e2) {
                    Log.printErrStackTrace("MicroMsg.VLogVideoPlayer", e2, "prepare lock notify error", new Object[0]);
                }
                try {
                    x xVar = x.SXb;
                } finally {
                    AppMethodBeat.o(110990);
                }
            }
        }

        @Override // com.tencent.mm.plugin.n.d
        public final void onCompletion() {
        }

        @Override // com.tencent.mm.plugin.n.d
        public final void onError(int i2, int i3) {
            AppMethodBeat.i(110991);
            Log.i("MicroMsg.VLogVideoPlayer", this.GCp.hashCode() + " onError what:" + i2 + " error :" + i3);
            AppMethodBeat.o(110991);
        }

        @Override // com.tencent.mm.plugin.n.d
        public final void cJH() {
            AppMethodBeat.i(110992);
            String str = this.GCp.hashCode() + " %s player seek done";
            Object[] objArr = new Object[1];
            j jVar = this.GCp.rsl;
            objArr[0] = jVar != null ? jVar.info() : null;
            Log.d("MicroMsg.VLogVideoPlayer", str, objArr);
            synchronized (this.GCp.GCk) {
                try {
                    Log.i("MicroMsg.VLogVideoPlayer", this.GCp.hashCode() + " player seek notifyAll");
                    this.GCp.GCk.notifyAll();
                } catch (Exception e2) {
                    Log.printErrStackTrace("MicroMsg.VLogVideoPlayer", e2, this.GCp.hashCode() + " notify seekLock error", new Object[0]);
                }
                try {
                    x xVar = x.SXb;
                } finally {
                    AppMethodBeat.o(110992);
                }
            }
        }

        @Override // com.tencent.mm.plugin.n.d
        public final void aa(int i2, int i3, int i4) {
            AppMethodBeat.i(110993);
            Log.i("MicroMsg.VLogVideoPlayer", this.GCp.hashCode() + " video size changed size[%d, %d] degrees[%d]", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4));
            AppMethodBeat.o(110993);
        }
    }

    private boolean start() {
        boolean z;
        boolean z2 = false;
        AppMethodBeat.i(110994);
        if (this.rsl == null || !this.GCm) {
            Object[] objArr = new Object[3];
            objArr[0] = Integer.valueOf(hashCode());
            if (this.rsl == null) {
                z = true;
            } else {
                z = false;
            }
            objArr[1] = Boolean.valueOf(z);
            objArr[2] = Boolean.valueOf(this.GCm);
            Log.w("MicroMsg.VLogVideoPlayer", "%d player is null[%b] or it prepared [%b]", objArr);
            AppMethodBeat.o(110994);
            return false;
        }
        String str = "%d player start surface[%b], seekTime:" + this.GCi;
        Object[] objArr2 = new Object[2];
        objArr2[0] = Integer.valueOf(hashCode());
        if (this.surface != null) {
            z2 = true;
        }
        objArr2[1] = Boolean.valueOf(z2);
        Log.i("MicroMsg.VLogVideoPlayer", str, objArr2);
        j jVar = this.rsl;
        if (jVar != null) {
            jVar.start();
        }
        AppMethodBeat.o(110994);
        return true;
    }

    @Override // com.tencent.mm.plugin.vlog.player.b
    public final void release() {
        AppMethodBeat.i(110996);
        Log.i("MicroMsg.VLogVideoPlayer", "%d player release [%s]", Integer.valueOf(hashCode()), Util.getStack());
        this.GBl = false;
        j jVar = this.rsl;
        if (jVar != null) {
            jVar.a(null);
        }
        j jVar2 = this.rsl;
        if (jVar2 != null) {
            jVar2.stop();
        }
        j jVar3 = this.rsl;
        if (jVar3 != null) {
            jVar3.release();
        }
        this.rsl = null;
        this.GCm = false;
        this.mEm = 0;
        Surface surface2 = this.surface;
        if (surface2 != null) {
            surface2.release();
        }
        SurfaceTexture surfaceTexture2 = this.surfaceTexture;
        if (surfaceTexture2 != null) {
            surfaceTexture2.release();
        }
        this.surfaceTexture = null;
        this.surface = null;
        this.bcY = false;
        AppMethodBeat.o(110996);
    }

    @Override // com.tencent.mm.plugin.vlog.player.b
    public final void pause() {
        j jVar;
        AppMethodBeat.i(110997);
        j jVar2 = this.rsl;
        if (jVar2 == null) {
            AppMethodBeat.o(110997);
        } else if (!jVar2.isPlaying() || (jVar = this.rsl) == null) {
            AppMethodBeat.o(110997);
        } else {
            jVar.pause();
            AppMethodBeat.o(110997);
        }
    }

    @Override // com.tencent.mm.plugin.vlog.player.b
    public final void resume() {
        AppMethodBeat.i(110998);
        j jVar = this.rsl;
        if (jVar != null) {
            if (!jVar.isPlaying()) {
                start();
            }
            AppMethodBeat.o(110998);
            return;
        }
        AppMethodBeat.o(110998);
    }

    @Override // com.tencent.mm.plugin.vlog.player.b
    public final void O(long j2, boolean z) {
        AppMethodBeat.i(111000);
        this.GCl = true;
        j jVar = this.rsl;
        if (jVar != null && !jVar.isPlaying()) {
            Log.i("MicroMsg.VLogVideoPlayer", hashCode() + " playing start now");
            start();
        }
        if (z) {
            try {
                SurfaceTexture surfaceTexture2 = this.surfaceTexture;
                if (surfaceTexture2 != null) {
                    surfaceTexture2.updateTexImage();
                    AppMethodBeat.o(111000);
                    return;
                }
                AppMethodBeat.o(111000);
                return;
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.VLogVideoPlayer", e2, hashCode() + " updateTexImage error", new Object[0]);
            }
        }
        AppMethodBeat.o(111000);
    }

    @Override // com.tencent.mm.plugin.vlog.player.b
    public final void prepare() {
        boolean z = true;
        AppMethodBeat.i(111001);
        long currentTicks = Util.currentTicks();
        if (Util.isNullOrNil(this.GBm.path) || !s.YS(this.GBm.path)) {
            Log.e("MicroMsg.VLogVideoPlayer", hashCode() + " prepare file not exist or is null");
        }
        this.bcY = true;
        e eVar = e.GBH;
        a aUf = e.aUf(this.GBm.path);
        if (aUf != null) {
            Log.i("MicroMsg.VLogVideoPlayer", "prepare get info from cache");
            this.dYT = aUf.dYT;
            this.width = aUf.width;
            this.height = aUf.height;
            this.cropLeft = aUf.cropLeft;
            this.cropTop = aUf.cropTop;
            this.cropRight = aUf.cropRight;
            this.cropBottom = aUf.cropBottom;
        } else {
            z = false;
        }
        if (z) {
            Log.i("MicroMsg.VLogVideoPlayer", "prepare finish get from cache");
            StringBuilder append = new StringBuilder().append(hashCode()).append(" prepare video, rotate = ").append(this.dYT).append(", width = ").append(this.width).append(", height = ").append(this.height).append(", startTime = ").append(this.GBm.startTime).append(", endTime = ").append(this.GBm.endTime).append(", videoStartTime = ");
            com.tencent.mm.plugin.vlog.model.s sVar = this.GBm;
            if (sVar == null) {
                t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.vlog.model.VideoMaterial");
                AppMethodBeat.o(111001);
                throw tVar;
            }
            Log.i("MicroMsg.VLogVideoPlayer", append.append(((aj) sVar).GzW).append(", videoEndTime = ").append(((aj) this.GBm).GzX).append(", cost:").append(Util.ticksToNow(currentTicks)).append(LocaleUtil.MALAY).toString());
            AppMethodBeat.o(111001);
            return;
        }
        try {
            Log.printInfoStack("MicroMsg.VLogVideoPlayer", hashCode() + " start prepare " + this.GBm.path, new Object[0]);
            this.dYT = -1;
            long currentTicks2 = Util.currentTicks();
            MediaExtractor mediaExtractor = new MediaExtractor();
            mediaExtractor.setDataSource(this.GBm.path);
            int trackCount = mediaExtractor.getTrackCount();
            int i2 = 0;
            while (true) {
                if (i2 >= trackCount) {
                    break;
                }
                MediaFormat trackFormat = mediaExtractor.getTrackFormat(i2);
                p.g(trackFormat, "mediaExtractor.getTrackFormat(i)");
                String string = trackFormat.getString("mime");
                p.g(string, "mediaFormat.getString(MediaFormat.KEY_MIME)");
                if (n.J(string, "video", false)) {
                    this.width = trackFormat.getInteger("width");
                    this.height = trackFormat.getInteger("height");
                    if (com.tencent.mm.compatible.util.d.oD(23) && trackFormat.containsKey("rotation-degrees")) {
                        this.dYT = trackFormat.getInteger("rotation-degrees");
                    }
                } else {
                    i2++;
                }
            }
            mediaExtractor.release();
            Log.i("MicroMsg.VLogVideoPlayer", hashCode() + " prepare video get width/height cost:" + Util.ticksToNow(currentTicks2) + "ms, try-get rotate:" + this.dYT);
            if (this.dYT < 0) {
                long currentTicks3 = Util.currentTicks();
                this.dYT = SightVideoJNI.getMp4RotateVFS(this.GBm.path);
                Log.i("MicroMsg.VLogVideoPlayer", hashCode() + " prepare video get rotate cost:" + Util.ticksToNow(currentTicks3) + LocaleUtil.MALAY);
            }
            if (this.dYT == 90) {
                this.dYT = 3;
            } else if (this.dYT == 180) {
                this.dYT = 2;
            } else if (this.dYT == 270) {
                this.dYT = 1;
            }
            StringBuilder append2 = new StringBuilder().append(hashCode()).append(" prepare video, rotate = ").append(this.dYT).append(", width = ").append(this.width).append(", height = ").append(this.height).append(", startTime = ").append(this.GBm.startTime).append(", endTime = ").append(this.GBm.endTime).append(", videoStartTime = ");
            com.tencent.mm.plugin.vlog.model.s sVar2 = this.GBm;
            if (sVar2 == null) {
                t tVar2 = new t("null cannot be cast to non-null type com.tencent.mm.plugin.vlog.model.VideoMaterial");
                AppMethodBeat.o(111001);
                throw tVar2;
            }
            Log.i("MicroMsg.VLogVideoPlayer", append2.append(((aj) sVar2).GzW).append(", videoEndTime = ").append(((aj) this.GBm).GzX).append(", cost:").append(Util.ticksToNow(currentTicks)).append(LocaleUtil.MALAY).toString());
            e eVar2 = e.GBH;
            e.p(this.GBm.path, this.width, this.height, this.dYT);
            AppMethodBeat.o(111001);
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.VLogVideoPlayer", e2, hashCode() + " prepare error", new Object[0]);
            AppMethodBeat.o(111001);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class b implements Runnable {
        final /* synthetic */ l GCp;

        b(l lVar) {
            this.GCp = lVar;
        }

        public final void run() {
            f iVar;
            AppMethodBeat.i(110989);
            Log.i("MicroMsg.VLogVideoPlayer", this.GCp.hashCode() + ' ' + this.GCp.GBm.path + " start do check crop rect");
            final long currentTicks = Util.currentTicks();
            final com.tencent.mm.media.f.a aVar = new com.tencent.mm.media.f.a(this.GCp.GBm.path);
            e eVar = new e(aVar, (byte) 0);
            AnonymousClass1 r2 = new m<MediaFormat, e, x>(this) {
                /* class com.tencent.mm.plugin.vlog.player.l.b.AnonymousClass1 */
                final /* synthetic */ b GCq;

                {
                    this.GCq = r3;
                }

                /* Return type fixed from 'java.lang.Object' to match base method */
                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
                @Override // kotlin.g.a.m
                public final /* synthetic */ x invoke(MediaFormat mediaFormat, e eVar) {
                    boolean z;
                    int i2;
                    int i3;
                    int i4;
                    int i5 = 0;
                    AppMethodBeat.i(110988);
                    MediaFormat mediaFormat2 = mediaFormat;
                    p.h(eVar, "checker");
                    if (mediaFormat2 != null) {
                        p.h(mediaFormat2, "mediaFormat");
                        if (mediaFormat2.containsKey("crop-left") || mediaFormat2.containsKey("crop-top") || mediaFormat2.containsKey("crop-right") || mediaFormat2.containsKey("crop-bottom")) {
                            z = true;
                        } else {
                            z = false;
                        }
                        if (z) {
                            l lVar = this.GCq.GCp;
                            p.h(mediaFormat2, "mediaFormat");
                            if (mediaFormat2.containsKey("crop-left")) {
                                i2 = mediaFormat2.getInteger("crop-left");
                            } else {
                                i2 = 0;
                            }
                            lVar.cropLeft = i2;
                            l lVar2 = this.GCq.GCp;
                            p.h(mediaFormat2, "mediaFormat");
                            if (mediaFormat2.containsKey("crop-top")) {
                                i3 = mediaFormat2.getInteger("crop-top");
                            } else {
                                i3 = 0;
                            }
                            lVar2.cropTop = i3;
                            l lVar3 = this.GCq.GCp;
                            p.h(mediaFormat2, "mediaFormat");
                            if (mediaFormat2.containsKey("crop-right")) {
                                i4 = mediaFormat2.getInteger("crop-right");
                            } else {
                                i4 = 0;
                            }
                            lVar3.cropRight = i4;
                            l lVar4 = this.GCq.GCp;
                            p.h(mediaFormat2, "mediaFormat");
                            if (mediaFormat2.containsKey("crop-bottom")) {
                                i5 = mediaFormat2.getInteger("crop-bottom");
                            }
                            lVar4.cropBottom = i5;
                            if (mediaFormat2.containsKey("width") && mediaFormat2.containsKey("height")) {
                                this.GCq.GCp.width = mediaFormat2.getInteger("width");
                                this.GCq.GCp.height = mediaFormat2.getInteger("height");
                            }
                            Log.i("MicroMsg.VLogVideoPlayer", this.GCq.GCp.hashCode() + ' ' + this.GCq.GCp.GBm.path + " finish check crop rect:[" + this.GCq.GCp.cropLeft + ", " + this.GCq.GCp.cropTop + ", " + this.GCq.GCp.cropRight + ", " + this.GCq.GCp.cropBottom + "], width:" + this.GCq.GCp.width + ", height:" + this.GCq.GCp.height);
                            e eVar2 = e.GBH;
                            e.a(this.GCq.GCp.GBm.path, this.GCq.GCp.width, this.GCq.GCp.height, this.GCq.GCp.cropLeft, this.GCq.GCp.cropTop, this.GCq.GCp.cropRight, this.GCq.GCp.cropBottom);
                        }
                        Log.i("MicroMsg.VLogVideoPlayer", this.GCq.GCp.hashCode() + ' ' + this.GCq.GCp.GBm.path + " finish check crop rect, notify all, cost:" + Util.ticksToNow(currentTicks) + LocaleUtil.MALAY);
                        aVar.release();
                    }
                    x xVar = x.SXb;
                    AppMethodBeat.o(110988);
                    return xVar;
                }
            };
            eVar.gWp = r2;
            try {
                if (com.tencent.mm.compatible.util.d.oD(23)) {
                    iVar = new com.tencent.mm.media.d.j((long) (eVar.ihK.getDuration() / 1000), eVar.ihK, new e.c(eVar));
                } else {
                    iVar = new i((long) (eVar.ihK.getDuration() / 1000), eVar.ihK, new e.d(eVar));
                }
                eVar.ihG = iVar;
            } catch (Exception e2) {
                Log.printErrStackTrace(eVar.TAG, e2, "start check init decoder error", new Object[0]);
                com.tencent.mm.media.k.e eVar2 = com.tencent.mm.media.k.e.ilC;
                com.tencent.mm.media.k.e.aOP();
                r2.invoke(null, eVar);
            }
            eVar.ihI = com.tencent.mm.ac.d.a("MediaCodecCheckVideoCropRect_decode", false, (kotlin.g.a.a) new e.C0419e(eVar));
            Log.i("MicroMsg.VLogVideoPlayer", this.GCp.hashCode() + " checkCropRect finish cost " + Util.ticksToNow(currentTicks) + LocaleUtil.MALAY);
            AppMethodBeat.o(110989);
        }
    }

    @Override // com.tencent.mm.plugin.vlog.player.b
    public final void stop() {
        AppMethodBeat.i(110995);
        this.GBl = false;
        j jVar = this.rsl;
        if (jVar != null) {
            jVar.a(null);
        }
        j jVar2 = this.rsl;
        if (jVar2 != null) {
            jVar2.stop();
        }
        j jVar3 = this.rsl;
        if (jVar3 != null) {
            jVar3.release();
        }
        this.rsl = null;
        this.GCm = false;
        Surface surface2 = this.surface;
        if (surface2 != null) {
            surface2.release();
        }
        SurfaceTexture surfaceTexture2 = this.surfaceTexture;
        if (surfaceTexture2 != null) {
            surfaceTexture2.release();
        }
        this.surfaceTexture = null;
        this.surface = null;
        AppMethodBeat.o(110995);
    }

    @Override // com.tencent.mm.plugin.vlog.player.b
    public final void KV(long j2) {
        boolean z;
        AppMethodBeat.i(183781);
        if (this.GBl) {
            Log.i("MicroMsg.VLogVideoPlayer", "play already ready");
            AppMethodBeat.o(183781);
            return;
        }
        this.GBl = true;
        long currentTicks = Util.currentTicks();
        Log.i("MicroMsg.VLogVideoPlayer", "%d play set video path [%s], texture:" + this.Gxi + ", seekTime:" + j2 + ", rotate:" + this.dYT, Integer.valueOf(hashCode()), this.GBm.path);
        if (Util.isNullOrNil(this.GBm.path) || !s.YS(this.GBm.path)) {
            Log.w("MicroMsg.VLogVideoPlayer", "%d open video but path is null or mSurface is null", Integer.valueOf(hashCode()));
            AppMethodBeat.o(183781);
            return;
        }
        Log.i("MicroMsg.VLogVideoPlayer", "%d open video [%s]", Integer.valueOf(hashCode()), this.GBm.path);
        if (!this.GCn) {
            Log.i("MicroMsg.VLogVideoPlayer", hashCode() + ' ' + this.GBm.path + " before check crop rect, width: " + this.width + ", height: " + this.height);
            if (this.width == 0 || this.height == 0) {
                Log.i("MicroMsg.VLogVideoPlayer", hashCode() + ' ' + this.GBm.path + " width and height is zero! Don't check!");
                this.GCn = false;
            } else {
                if (!(this.width % 16 == 0 && this.height % 16 == 0)) {
                    e eVar = e.GBH;
                    a aUf = e.aUf(this.GBm.path);
                    if (aUf == null || aUf.cropLeft < 0 || aUf.cropTop < 0 || this.cropRight < 0 || aUf.cropBottom < 0) {
                        z = false;
                    } else {
                        Log.i("MicroMsg.VLogVideoPlayer", "checkCropRect get from cache");
                        this.dYT = aUf.dYT;
                        this.width = aUf.width;
                        this.height = aUf.height;
                        this.cropLeft = aUf.cropLeft;
                        this.cropTop = aUf.cropTop;
                        this.cropRight = aUf.cropRight;
                        this.cropBottom = aUf.cropBottom;
                        Log.i("MicroMsg.VLogVideoPlayer", hashCode() + ' ' + this.GBm.path + " finish check crop rect:[" + this.cropLeft + ", " + this.cropTop + ", " + this.cropRight + ", " + this.cropBottom + "], width:" + this.width + ", height:" + this.height);
                        z = true;
                    }
                    if (!z) {
                        h.RTc.b(new b(this), "VLogVideoPlayer_checkCropRect");
                    }
                }
                this.GCn = true;
            }
        }
        try {
            this.surfaceTexture = new SurfaceTexture(this.Gxi);
            this.surface = new Surface(this.surfaceTexture);
            this.GCm = false;
            this.rsl = new j(Looper.getMainLooper());
            j jVar = this.rsl;
            if (jVar != null) {
                jVar.setPath(this.GBm.path);
            }
            j jVar2 = this.rsl;
            if (jVar2 != null) {
                jVar2.a(this.rsv);
            }
            j jVar3 = this.rsl;
            if (jVar3 != null) {
                jVar3.setSurface(this.surface);
            }
            j jVar4 = this.rsl;
            if (jVar4 != null) {
                jVar4.setMute(this.isb);
            }
            j jVar5 = this.rsl;
            if (jVar5 != null) {
                jVar5.setNeedResetExtractor(false);
            }
            j jVar6 = this.rsl;
            if (jVar6 != null) {
                jVar6.setIsOnlineVideoType(false);
            }
            j jVar7 = this.rsl;
            if (jVar7 != null) {
                jVar7.prepare();
            }
            this.GCi = j2;
            Log.i("MicroMsg.VLogVideoPlayer", hashCode() + " prepare player, wait");
            synchronized (this.GCj) {
                try {
                    this.GCj.wait();
                } catch (Exception e2) {
                    Log.printErrStackTrace("MicroMsg.VLogVideoPlayer", e2, hashCode() + " wait prepare lock error", new Object[0]);
                }
                try {
                    x xVar = x.SXb;
                } finally {
                    AppMethodBeat.o(183781);
                }
            }
            com.tencent.mm.plugin.vlog.model.s sVar = this.GBm;
            if (sVar == null) {
                t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.vlog.model.VideoMaterial");
                AppMethodBeat.o(183781);
                throw tVar;
            }
            int i2 = (int) (((aj) sVar).GzW + j2);
            if (i2 > 0) {
                j jVar8 = this.rsl;
                if (jVar8 != null) {
                    jVar8.seek(i2);
                }
                synchronized (this.GCk) {
                    try {
                        Log.i("MicroMsg.VLogVideoPlayer", hashCode() + " player seek wait:" + i2);
                        this.GCk.wait(100);
                    } catch (Exception e3) {
                        Log.printErrStackTrace("MicroMsg.VLogVideoPlayer", e3, hashCode() + " wait seekLock error", new Object[0]);
                    }
                    try {
                        x xVar2 = x.SXb;
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                Log.i("MicroMsg.VLogVideoPlayer", hashCode() + " player seek wait finish");
            } else {
                Log.i("MicroMsg.VLogVideoPlayer", hashCode() + " real seek time:" + i2 + ", not need to seek");
                this.GCl = true;
                j jVar9 = this.rsl;
                if (jVar9 != null && !jVar9.isPlaying()) {
                    Log.i("MicroMsg.VLogVideoPlayer", hashCode() + " play directly start");
                    start();
                }
            }
            Log.i("MicroMsg.VLogVideoPlayer", hashCode() + " play finish cost " + Util.ticksToNow(currentTicks) + LocaleUtil.MALAY);
            AppMethodBeat.o(183781);
        } catch (Exception e4) {
            Log.printErrStackTrace("MicroMsg.VLogVideoPlayer", e4, hashCode() + " prepare async error %s", e4.getMessage());
            AppMethodBeat.o(183781);
        }
    }

    @Override // com.tencent.mm.plugin.vlog.player.b
    public final void wC(boolean z) {
        j jVar;
        AppMethodBeat.i(111002);
        if (!(this.isb == z || (jVar = this.rsl) == null)) {
            jVar.setMute(z);
        }
        this.isb = z;
        AppMethodBeat.o(111002);
    }
}

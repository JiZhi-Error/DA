package com.tencent.mm.plugin.vlog.player;

import android.graphics.Bitmap;
import android.graphics.Rect;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.vlog.model.ah;
import com.tencent.mm.plugin.vlog.model.aj;
import com.tencent.mm.plugin.vlog.model.s;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.nio.IntBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u0000 b2\u00020\u0001:\u0001bBI\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b¢\u0006\u0002\u0010\rB'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b¢\u0006\u0002\u0010\u000eJ\u0006\u0010@\u001a\u00020!J\u0006\u0010A\u001a\u00020\u0019J\u0006\u0010B\u001a\u00020CJ\u0006\u0010D\u001a\u00020!J.\u0010E\u001a\u00020!2\n\b\u0002\u0010F\u001a\u0004\u0018\u00010G2\b\b\u0002\u0010H\u001a\u00020\u000b2\u0010\b\u0002\u0010I\u001a\n\u0012\u0004\u0012\u00020!\u0018\u00010JJ\u0006\u0010K\u001a\u00020!J\u0006\u0010L\u001a\u00020!J\u0006\u0010M\u001a\u00020!J\b\u0010N\u001a\u00020!H\u0002J\u0006\u0010O\u001a\u00020!J4\u0010P\u001a\u00020!2\u0018\u0010&\u001a\u0014\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020!0'2\u0012\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020!0 J\u0010\u0010Q\u001a\u00020!2\b\u0010R\u001a\u0004\u0018\u00010\u0010J\u0016\u0010S\u001a\u00020!2\u0006\u0010T\u001a\u00020\u00032\u0006\u0010U\u001a\u00020\u0003J\u000e\u0010V\u001a\u00020!2\u0006\u0010W\u001a\u00020\u000bJ \u0010X\u001a\u00020!2\u0006\u0010Y\u001a\u00020Z2\u0006\u0010\u0012\u001a\u00020\u00032\b\b\u0002\u0010[\u001a\u00020\\J+\u0010]\u001a\u00020!2#\u0010^\u001a\u001f\u0012\u0013\u0012\u001107¢\u0006\f\b8\u0012\b\b9\u0012\u0004\b\b(:\u0012\u0004\u0012\u00020!\u0018\u00010 J\u000e\u0010_\u001a\u00020!2\u0006\u0010=\u001a\u00020>J\u0016\u0010`\u001a\u00020!2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003J\b\u0010a\u001a\u00020!H\u0002R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0012\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0014R\u000e\u0010\t\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u000e\u0010\u001e\u001a\u00020\u0019X\u000e¢\u0006\u0002\n\u0000R(\u0010\u001f\u001a\u0010\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020!\u0018\u00010 X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R.\u0010&\u001a\u0016\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020!\u0018\u00010'X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u000e\u0010,\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010-\u001a\u00020\u0019X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u0010\u00102\u001a\u0004\u0018\u000103X\u000e¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u000205X\u000e¢\u0006\u0002\n\u0000R7\u00106\u001a\u001f\u0012\u0013\u0012\u001107¢\u0006\f\b8\u0012\b\b9\u0012\u0004\b\b(:\u0012\u0004\u0012\u00020!\u0018\u00010 X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010#\"\u0004\b<\u0010%R\u000e\u0010\u0006\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010=\u001a\u0004\u0018\u00010>X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b?\u0010\u0014R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000¨\u0006c"}, hxF = {"Lcom/tencent/mm/plugin/vlog/player/VLogDirector;", "", "width", "", "height", "textureWidth", "textureHeight", "widthScale", "", "heightScale", "loop", "", "previewPlay", "(IIIIFFZZ)V", "(IIZZ)V", "cropRect", "Landroid/graphics/Rect;", "drawCount", "durationMs", "getDurationMs", "()I", "setDurationMs", "(I)V", "getHeight", "lastPlayTime", "", "getLoop", "()Z", "setLoop", "(Z)V", "nextDrawTimeDelay", "onEnd", "Lkotlin/Function1;", "", "getOnEnd", "()Lkotlin/jvm/functions/Function1;", "setOnEnd", "(Lkotlin/jvm/functions/Function1;)V", "onProgress", "Lkotlin/Function2;", "getOnProgress", "()Lkotlin/jvm/functions/Function2;", "setOnProgress", "(Lkotlin/jvm/functions/Function2;)V", "prepared", "pts", "getPts", "()J", "setPts", "(J)V", "render", "Lcom/tencent/mm/media/render/proc/GLTextureRenderProcBlend;", "scriptReader", "Lcom/tencent/mm/plugin/vlog/player/VLogScriptReader;", "snapShotCallback", "Ljava/nio/IntBuffer;", "Lkotlin/ParameterName;", "name", "buffer", "getSnapShotCallback", "setSnapShotCallback", "vLogSurface", "Lcom/tencent/mm/plugin/vlog/player/VLogSurface;", "getWidth", "drawPreloadFrame", "getNextPtsStep", "getSize", "Landroid/util/Size;", "pause", "playNextFrame", "blendBitmap", "Landroid/graphics/Bitmap;", "withSnapshot", "drawCallback", "Lkotlin/Function0;", "preloadOneFrame", "release", "reset", "resetPts", "resume", "setCallback", "setCropRect", "rect", "setFrameRate", "videoFps", "imageFps", "setMute", "mute", "setScript", "scriptModel", "Lcom/tencent/mm/plugin/vlog/model/VLogScriptModel;", "musicUrl", "", "setSnapshotCallback", "callback", "setVLogSurface", "updateDrawSize", "videoDecodeEnd", "Companion", "plugin-vlog_release"})
public final class c {
    public static final a GBv = new a((byte) 0);
    private i GBn;
    private com.tencent.mm.media.j.b.b GBo;
    public k GBp;
    public m<? super Long, ? super Long, x> GBq;
    public kotlin.g.a.b<? super Long, x> GBr;
    public kotlin.g.a.b<? super IntBuffer, x> GBs;
    public long GBt;
    private final boolean GBu;
    private boolean bcY;
    private int gRJ;
    private int hDn;
    private int hDo;
    public final int height;
    private Rect iiw;
    int jkS;
    private boolean loop;
    private float mLi;
    private float mLj;
    long pts;
    private long vgi;
    public final int width;

    static {
        AppMethodBeat.i(190856);
        AppMethodBeat.o(190856);
    }

    public /* synthetic */ c(int i2, int i3) {
        this(i2, i3, true, true);
    }

    private c(int i2, int i3, boolean z, boolean z2) {
        AppMethodBeat.i(190854);
        this.width = i2;
        this.height = i3;
        this.loop = z;
        this.GBu = z2;
        this.GBn = new i(this.GBu);
        this.mLi = 1.0f;
        this.mLj = 1.0f;
        this.pts = -1;
        AppMethodBeat.o(190854);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/vlog/player/VLogDirector$Companion;", "", "()V", "TAG", "", "plugin-vlog_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public c(int i2, int i3, int i4, int i5, float f2, float f3) {
        this(i2, i3, false, false);
        AppMethodBeat.i(190855);
        this.mLi = f2;
        this.mLj = f3;
        this.hDn = i4;
        this.hDo = i5;
        Log.i("MicroMsg.VLogDirector", "create VLogDirector, scale:[" + f2 + ", " + f3 + "], texture:[" + i4 + ", " + i5 + ']');
        AppMethodBeat.o(190855);
    }

    public static /* synthetic */ void a(c cVar, ah ahVar, int i2) {
        AppMethodBeat.i(190845);
        cVar.a(ahVar, i2, "");
        AppMethodBeat.o(190845);
    }

    public final void a(ah ahVar, int i2, String str) {
        AppMethodBeat.i(190844);
        p.h(ahVar, "scriptModel");
        p.h(str, "musicUrl");
        Log.i("MicroMsg.VLogDirector", hashCode() + "  setScript  durationMs :" + i2 + "  musicUrl:" + str);
        this.jkS = i2;
        fCn();
        this.bcY = true;
        k kVar = this.GBp;
        if (kVar != null) {
            kVar.j(new h(this, ahVar));
            AppMethodBeat.o(190844);
            return;
        }
        AppMethodBeat.o(190844);
    }

    public final void fCl() {
        AppMethodBeat.i(190846);
        i iVar = this.GBn;
        iVar.GBT = 33;
        iVar.GBU = 33;
        Log.i("MicroMsg.VLogScriptReader", "videoPtsStep :" + iVar.GBT + " imagePtsStep:" + iVar.GBU);
        AppMethodBeat.o(190846);
    }

    public final void setCropRect(Rect rect) {
        AppMethodBeat.i(190847);
        if (rect != null) {
            Log.i("MicroMsg.VLogDirector", "setCropRect:" + rect + ", width:" + this.width + ", height:" + this.height + ", textureWidth:" + this.hDn + ", textureHeight:" + this.hDo);
            this.iiw = new Rect(rect);
            com.tencent.mm.media.j.b.b bVar = this.GBo;
            if (bVar != null) {
                bVar.ijA = this.iiw;
                AppMethodBeat.o(190847);
                return;
            }
        }
        AppMethodBeat.o(190847);
    }

    public final void a(k kVar) {
        AppMethodBeat.i(190848);
        p.h(kVar, "vLogSurface");
        Log.i("MicroMsg.VLogDirector", hashCode() + " setSurface");
        this.GBp = kVar;
        kVar.j(new i(this, kVar));
        AppMethodBeat.o(190848);
    }

    public final void cX(int i2, int i3) {
        AppMethodBeat.i(190849);
        Log.i("MicroMsg.VLogDirector", hashCode() + " updateDrawSize:[" + i2 + ", " + i3 + ']');
        k kVar = this.GBp;
        if (kVar != null) {
            kVar.j(new j(this, i2, i3));
            AppMethodBeat.o(190849);
            return;
        }
        AppMethodBeat.o(190849);
    }

    public final void fCm() {
        AppMethodBeat.i(190850);
        k kVar = this.GBp;
        if (kVar != null) {
            kVar.j(new b(this));
            AppMethodBeat.o(190850);
            return;
        }
        AppMethodBeat.o(190850);
    }

    public static /* synthetic */ void a(c cVar, Bitmap bitmap, boolean z, int i2) {
        k kVar;
        AppMethodBeat.i(190851);
        if ((i2 & 1) != 0) {
            bitmap = null;
        }
        if ((i2 & 2) != 0) {
            z = false;
        }
        if (!cVar.bcY || (kVar = cVar.GBp) == null) {
            AppMethodBeat.o(190851);
            return;
        }
        kVar.j(new d(kVar, cVar, bitmap, z));
        AppMethodBeat.o(190851);
    }

    private final void fCn() {
        this.pts = 0;
        this.gRJ = 0;
    }

    public final void release() {
        AppMethodBeat.i(190852);
        Log.printInfoStack("MicroMsg.VLogDirector", "VLogRelease into VLogDirector#release 1", new Object[0]);
        k kVar = this.GBp;
        if (kVar != null) {
            Log.d("MicroMsg.VLogDirector", "VLogRelease into VLogDirector#release 2");
            kVar.j(new e(this));
        }
        k kVar2 = this.GBp;
        if (kVar2 != null) {
            kVar2.release();
        }
        e eVar = e.GBH;
        e.clearCache();
        AppMethodBeat.o(190852);
    }

    public final void setMute(boolean z) {
        AppMethodBeat.i(190853);
        k kVar = this.GBp;
        if (kVar != null) {
            kVar.j(new g(this, z));
            AppMethodBeat.o(190853);
            return;
        }
        AppMethodBeat.o(190853);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class h extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ ah GBC;
        final /* synthetic */ c GBw;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        h(c cVar, ah ahVar) {
            super(0);
            this.GBw = cVar;
            this.GBC = ahVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            d dVar;
            AppMethodBeat.i(190840);
            i iVar = this.GBw.GBn;
            ah ahVar = this.GBC;
            float f2 = this.GBw.mLi;
            float f3 = this.GBw.mLj;
            p.h(ahVar, "scriptModel");
            iVar.GBQ = ahVar;
            Log.i("MicroMsg.VLogScriptReader", "setEffectConfig " + iVar.hashCode() + ", previewPlay:" + iVar.GBu + ", scale:[" + f2 + ", " + f3 + "] : " + ahVar.GzS);
            iVar.wD(true);
            iVar.GBR.clear();
            long currentTicks = Util.currentTicks();
            for (T t : ahVar.GzQ) {
                if (t instanceof aj) {
                    j jVar = iVar.GBS;
                    com.tencent.mm.media.g.d[] dVarArr = jVar.GCb;
                    int i2 = jVar.GCd;
                    jVar.GCd = i2 + 1;
                    com.tencent.mm.media.g.d dVar2 = dVarArr[i2 % 2];
                    Log.i("MicroMsg.VLogScriptTexCache", "requestExternalTex: ".concat(String.valueOf(dVar2)));
                    int i3 = dVar2 != null ? dVar2.igv : -1;
                    Log.i("MicroMsg.VLogScriptReader", "prepare VideoMaterial:" + t.path + ", texture:" + i3);
                    if (iVar.GBu) {
                        dVar = new l(i3, iVar.targetWidth, iVar.targetHeight, t, iVar.isb);
                    } else {
                        dVar = new f(i3, iVar.targetWidth, iVar.targetHeight, t);
                    }
                } else if (t instanceof com.tencent.mm.plugin.vlog.model.q) {
                    j jVar2 = iVar.GBS;
                    com.tencent.mm.media.g.d[] dVarArr2 = jVar2.GCc;
                    int i4 = jVar2.GCe;
                    jVar2.GCe = i4 + 1;
                    com.tencent.mm.media.g.d dVar3 = dVarArr2[i4 % 2];
                    Log.i("MicroMsg.VLogScriptTexCache", "requestNormalTex: ".concat(String.valueOf(dVar3)));
                    int i5 = dVar3 != null ? dVar3.igv : -1;
                    Log.i("MicroMsg.VLogScriptReader", "prepare ImageMaterial:" + t.path + ", texture:" + i5);
                    dVar = new d(i5, iVar.targetWidth, iVar.targetHeight, t);
                } else {
                    dVar = null;
                }
                if (dVar != null) {
                    iVar.GBR.add(dVar);
                    Log.i("MicroMsg.VLogScriptReader", "init cacheMaterialPlayer put " + t.path);
                }
            }
            for (b bVar : kotlin.a.j.b(iVar.GBR, 1)) {
                bVar.prepare();
            }
            Log.i("MicroMsg.VLogScriptReader", "init prepare all material player cost:" + Util.ticksToNow(currentTicks) + LocaleUtil.MALAY);
            x xVar = x.SXb;
            AppMethodBeat.o(190840);
            return xVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class i extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ k GBD;
        final /* synthetic */ c GBw;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        i(c cVar, k kVar) {
            super(0);
            this.GBw = cVar;
            this.GBD = kVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            com.tencent.mm.media.j.b.b bVar;
            AppMethodBeat.i(190842);
            if (this.GBw.hDn <= 0 || this.GBw.hDo <= 0) {
                this.GBw.GBn.jv(this.GBw.width, this.GBw.height);
            } else {
                this.GBw.GBn.jv(this.GBw.hDn, this.GBw.hDo);
            }
            this.GBw.GBo = new com.tencent.mm.media.j.b.b(this.GBw.width, this.GBw.height);
            Log.i("MicroMsg.VLogDirector", this.GBw.hashCode() + " setVLogSurface, updateDrawViewSize:[" + this.GBw.width + ", " + this.GBw.height + ']');
            com.tencent.mm.media.j.b.b bVar2 = this.GBw.GBo;
            if (bVar2 != null) {
                bVar2.cY(this.GBw.width, this.GBw.height);
            }
            if (this.GBw.hDn <= 0 || this.GBw.hDo <= 0) {
                Log.i("MicroMsg.VLogDirector", this.GBw.hashCode() + " setVLogSurface, update texture and draw size:[" + this.GBw.width + ", " + this.GBw.height + ']');
                com.tencent.mm.media.j.b.b bVar3 = this.GBw.GBo;
                if (bVar3 != null) {
                    bVar3.cZ(this.GBw.width, this.GBw.height);
                }
            } else {
                Log.i("MicroMsg.VLogDirector", this.GBw.hashCode() + " setVLogSurface, update texture size from texture:[" + this.GBw.hDn + ", " + this.GBw.hDo + ']');
                com.tencent.mm.media.j.b.b bVar4 = this.GBw.GBo;
                if (bVar4 != null) {
                    bVar4.cZ(this.GBw.hDn, this.GBw.hDo);
                }
            }
            com.tencent.mm.media.j.b.b bVar5 = this.GBw.GBo;
            if (bVar5 != null) {
                bVar5.textureType = 3553;
            }
            com.tencent.mm.media.j.b.b bVar6 = this.GBw.GBo;
            if (bVar6 != null) {
                bVar6.hDl = this.GBD.fCq();
            }
            if (!(this.GBw.iiw == null || (bVar = this.GBw.GBo) == null)) {
                bVar.ijA = this.GBw.iiw;
            }
            com.tencent.mm.media.j.b.b bVar7 = this.GBw.GBo;
            if (bVar7 != null) {
                bVar7.ijJ = new kotlin.g.a.b<IntBuffer, x>(this) {
                    /* class com.tencent.mm.plugin.vlog.player.c.i.AnonymousClass1 */
                    final /* synthetic */ i GBE;

                    {
                        this.GBE = r2;
                    }

                    /* Return type fixed from 'java.lang.Object' to match base method */
                    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                    @Override // kotlin.g.a.b
                    public final /* synthetic */ x invoke(IntBuffer intBuffer) {
                        AppMethodBeat.i(190841);
                        IntBuffer intBuffer2 = intBuffer;
                        p.h(intBuffer2, LocaleUtil.ITALIAN);
                        kotlin.g.a.b<? super IntBuffer, x> bVar = this.GBE.GBw.GBs;
                        if (bVar != null) {
                            bVar.invoke(intBuffer2);
                        }
                        x xVar = x.SXb;
                        AppMethodBeat.o(190841);
                        return xVar;
                    }
                };
            }
            x xVar = x.SXb;
            AppMethodBeat.o(190842);
            return xVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class j extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ c GBw;
        final /* synthetic */ int cKE;
        final /* synthetic */ int cKF;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        j(c cVar, int i2, int i3) {
            super(0);
            this.GBw = cVar;
            this.cKE = i2;
            this.cKF = i3;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(190843);
            Log.i("MicroMsg.VLogDirector", this.GBw.hashCode() + " queue updateDrawSize:[" + this.cKE + ", " + this.cKF + ']');
            com.tencent.mm.media.j.b.b bVar = this.GBw.GBo;
            if (bVar != null) {
                bVar.cY(this.cKE, this.cKF);
            }
            x xVar = x.SXb;
            AppMethodBeat.o(190843);
            return xVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, hxF = {"<anonymous>", "", "invoke", "com/tencent/mm/plugin/vlog/player/VLogDirector$drawPreloadFrame$1$1"})
    static final class b extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ c GBw;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(c cVar) {
            super(0);
            this.GBw = cVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(190834);
            com.tencent.mm.media.j.b.b bVar = this.GBw.GBo;
            if (bVar != null) {
                bVar.aED();
            }
            x xVar = x.SXb;
            AppMethodBeat.o(190834);
            return xVar;
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, hxF = {"<anonymous>", "", "invoke", "com/tencent/mm/plugin/vlog/player/VLogDirector$playNextFrame$1$1"})
    public static final class d extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ kotlin.g.a.a GBA = null;
        final /* synthetic */ c GBw;
        final /* synthetic */ k GBx;
        final /* synthetic */ Bitmap GBy;
        final /* synthetic */ boolean GBz;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(k kVar, c cVar, Bitmap bitmap, boolean z) {
            super(0);
            this.GBx = kVar;
            this.GBw = cVar;
            this.GBy = bitmap;
            this.GBz = z;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            ArrayList<s> arrayList;
            long j2;
            com.tencent.mm.media.j.b.b bVar;
            ArrayList<s> arrayList2 = null;
            AppMethodBeat.i(190836);
            if (this.GBw.pts > ((long) this.GBw.jkS)) {
                c.h(this.GBw);
            } else {
                long currentTicks = Util.currentTicks();
                this.GBw.vgi = currentTicks;
                i iVar = this.GBw.GBn;
                long j3 = this.GBw.pts;
                int fCq = this.GBx.fCq();
                boolean z = this.GBw.GBu;
                ah ahVar = iVar.GBQ;
                if ((ahVar != null ? ahVar.GzQ : null) == null) {
                    arrayList = new ArrayList<>();
                } else {
                    arrayList = new ArrayList<>();
                    ah ahVar2 = iVar.GBQ;
                    List<? extends s> list = ahVar2 != null ? ahVar2.GzQ : null;
                    if (list == null) {
                        p.hyc();
                    }
                    for (s sVar : list) {
                        if (j3 >= sVar.startTime && j3 < sVar.endTime) {
                            arrayList.add(sVar);
                        }
                    }
                }
                ArrayList<s> arrayList3 = !arrayList.isEmpty() ? arrayList : null;
                if (arrayList3 != null) {
                    if (z) {
                        ArrayList<Integer> a2 = iVar.a(j3, arrayList3);
                        if (a2 != null) {
                            arrayList2 = iVar.a(a2, j3);
                        }
                        iVar.a(arrayList3, arrayList2, fCq, j3);
                    } else {
                        iVar.a(arrayList3, null, fCq, j3);
                    }
                }
                if (!(this.GBy == null || (bVar = this.GBw.GBo) == null)) {
                    com.tencent.mm.media.j.b.b.a(bVar, this.GBy);
                }
                if (this.GBz) {
                    Log.i("MicroMsg.VLogDirector", "issue take snapshot");
                    com.tencent.mm.media.j.b.b bVar2 = this.GBw.GBo;
                    if (bVar2 != null) {
                        bVar2.ijM = true;
                    }
                }
                com.tencent.mm.media.j.b.b bVar3 = this.GBw.GBo;
                if (bVar3 != null) {
                    bVar3.aED();
                }
                this.GBx.KY(this.GBw.pts);
                m<? super Long, ? super Long, x> mVar = this.GBw.GBq;
                if (mVar != null) {
                    mVar.invoke(Long.valueOf(this.GBw.pts), Long.valueOf((long) this.GBw.jkS));
                }
                this.GBw.pts += this.GBw.GBn.GBV;
                long ticksToNow = Util.ticksToNow(currentTicks);
                c cVar = this.GBw;
                if (this.GBw.GBu) {
                    j2 = Math.max(this.GBw.GBn.GBV - ticksToNow, 0L);
                } else {
                    j2 = this.GBw.GBn.GBV;
                }
                cVar.GBt = j2;
                kotlin.g.a.a aVar = this.GBA;
                if (aVar != null) {
                    aVar.invoke();
                }
            }
            x xVar = x.SXb;
            AppMethodBeat.o(190836);
            return xVar;
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, hxF = {"<anonymous>", "", "invoke", "com/tencent/mm/plugin/vlog/player/VLogDirector$release$1$1"})
    public static final class e extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ c GBw;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(c cVar) {
            super(0);
            this.GBw = cVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(190837);
            Log.d("MicroMsg.VLogDirector", "VLogRelease into VLogDirector#release 3");
            i iVar = this.GBw.GBn;
            Log.d("MicroMsg.VLogScriptReader", "VLogRelease into VLogScriptReader#release");
            com.tencent.mm.plugin.xlabeffect.b bVar = iVar.hiH;
            if (bVar != null) {
                bVar.destroy();
            }
            i.a(iVar);
            iVar.GBR.clear();
            j jVar = iVar.GBS;
            Log.d("MicroMsg.VLogScriptTexCache", "VLogRelease into VLogScriptTexCache#clearCache");
            Log.i("MicroMsg.VLogScriptTexCache", "VLogRelease release clearCache, " + jVar.GCb.length + ", " + jVar.GCc.length);
            com.tencent.mm.media.g.d[] dVarArr = jVar.GCb;
            for (com.tencent.mm.media.g.d dVar : dVarArr) {
                if (dVar != null) {
                    dVar.close();
                }
            }
            com.tencent.mm.media.g.d[] dVarArr2 = jVar.GCc;
            for (com.tencent.mm.media.g.d dVar2 : dVarArr2) {
                if (dVar2 != null) {
                    dVar2.close();
                }
            }
            x xVar = x.SXb;
            AppMethodBeat.o(190837);
            return xVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, hxF = {"<anonymous>", "", "invoke", "com/tencent/mm/plugin/vlog/player/VLogDirector$pause$1$1"})
    /* renamed from: com.tencent.mm.plugin.vlog.player.c$c  reason: collision with other inner class name */
    public static final class C1853c extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ c GBw;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public C1853c(c cVar) {
            super(0);
            this.GBw = cVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(190835);
            Iterator<T> it = this.GBw.GBn.GBR.iterator();
            while (it.hasNext()) {
                it.next().pause();
            }
            x xVar = x.SXb;
            AppMethodBeat.o(190835);
            return xVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, hxF = {"<anonymous>", "", "invoke", "com/tencent/mm/plugin/vlog/player/VLogDirector$resume$1$1"})
    public static final class f extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ c GBw;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public f(c cVar) {
            super(0);
            this.GBw = cVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(190838);
            Iterator<T> it = this.GBw.GBn.GBR.iterator();
            while (it.hasNext()) {
                it.next().resume();
            }
            x xVar = x.SXb;
            AppMethodBeat.o(190838);
            return xVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, hxF = {"<anonymous>", "", "invoke", "com/tencent/mm/plugin/vlog/player/VLogDirector$setMute$1$1"})
    static final class g extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ boolean GBB;
        final /* synthetic */ c GBw;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        g(c cVar, boolean z) {
            super(0);
            this.GBw = cVar;
            this.GBB = z;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(190839);
            i iVar = this.GBw.GBn;
            boolean z = this.GBB;
            iVar.isb = z;
            Iterator<T> it = iVar.GBR.iterator();
            while (it.hasNext()) {
                it.next().wC(z);
            }
            x xVar = x.SXb;
            AppMethodBeat.o(190839);
            return xVar;
        }
    }

    public static final /* synthetic */ void h(c cVar) {
        boolean z;
        AppMethodBeat.i(190857);
        Log.i("MicroMsg.VLogDirector", "videoDecodeEnd pts:" + cVar.pts);
        kotlin.g.a.b<? super Long, x> bVar = cVar.GBr;
        if (bVar != null) {
            bVar.invoke(Long.valueOf(cVar.pts));
        }
        if (!cVar.loop) {
            k kVar = cVar.GBp;
            if (kVar != null) {
                kVar.clearTask();
            }
        } else {
            cVar.fCn();
        }
        i iVar = cVar.GBn;
        boolean z2 = cVar.loop;
        Log.i("MicroMsg.VLogScriptReader", "onPlayEnd, loop:".concat(String.valueOf(z2)));
        if (!z2) {
            z = true;
        } else {
            z = false;
        }
        iVar.wD(z);
        AppMethodBeat.o(190857);
    }
}

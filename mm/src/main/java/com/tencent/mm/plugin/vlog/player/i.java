package com.tencent.mm.plugin.vlog.player;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.vlog.model.ah;
import com.tencent.mm.plugin.vlog.model.s;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.ResultKt;
import kotlin.d.b.a.j;
import kotlin.d.d;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;
import kotlinx.coroutines.ai;
import kotlinx.coroutines.ba;
import kotlinx.coroutines.bn;
import kotlinx.coroutines.f;

@l(hxD = {1, 1, 16}, hxE = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u001d\n\u0002\u0010\u0007\n\u0002\b\u0003\u0018\u0000 C2\u00020\u0001:\u0001CB\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0012\u0010\u001a\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J\u0012\u0010\u001d\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u001e\u001a\u00020\u0013H\u0002J<\u0010\u001f\u001a\u0016\u0012\u0004\u0012\u00020\u001c\u0018\u00010\nj\n\u0012\u0004\u0012\u00020\u001c\u0018\u0001`\f2\u0006\u0010 \u001a\u00020\u00062\u0016\u0010!\u001a\u0012\u0012\u0004\u0012\u00020\u001c0\nj\b\u0012\u0004\u0012\u00020\u001c`\fH\u0002J\u0006\u0010\"\u001a\u00020#J<\u0010$\u001a\u0016\u0012\u0004\u0012\u00020\u001c\u0018\u00010\nj\n\u0012\u0004\u0012\u00020\u001c\u0018\u0001`\f2\u0016\u0010%\u001a\u0012\u0012\u0004\u0012\u00020\u00130\nj\b\u0012\u0004\u0012\u00020\u0013`\f2\u0006\u0010 \u001a\u00020\u0006H\u0002JL\u0010&\u001a\u00020#2\u0016\u0010'\u001a\u0012\u0012\u0004\u0012\u00020\u001c0\nj\b\u0012\u0004\u0012\u00020\u001c`\f2\u001a\u0010(\u001a\u0016\u0012\u0004\u0012\u00020\u001c\u0018\u00010\nj\n\u0012\u0004\u0012\u00020\u001c\u0018\u0001`\f2\u0006\u0010)\u001a\u00020\u00132\u0006\u0010 \u001a\u00020\u0006H\u0002J \u0010*\u001a\u00020#2\u0006\u0010+\u001a\u00020\u00062\u0006\u0010,\u001a\u00020\u00132\b\b\u0002\u0010\u0002\u001a\u00020\u0003J\u001e\u0010-\u001a\u0012\u0012\u0004\u0012\u00020\u001c0\nj\b\u0012\u0004\u0012\u00020\u001c`\f2\u0006\u0010+\u001a\u00020\u0006J\u000e\u0010.\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u0006J\u0016\u0010/\u001a\u00020#2\u0006\u00100\u001a\u00020\u00132\u0006\u00101\u001a\u00020\u0013J<\u00102\u001a\u0016\u0012\u0004\u0012\u00020\u0013\u0018\u00010\nj\n\u0012\u0004\u0012\u00020\u0013\u0018\u0001`\f2\u0006\u0010 \u001a\u00020\u00062\u0016\u0010!\u001a\u0012\u0012\u0004\u0012\u00020\u001c0\nj\b\u0012\u0004\u0012\u00020\u001c`\fH\u0002J\u000e\u00103\u001a\u00020#2\u0006\u00104\u001a\u00020\u0003J\u0006\u00105\u001a\u00020#J\u001c\u00106\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u00107\u001a\u00020\u0003H\u0002J\u0006\u00108\u001a\u00020#J\u0012\u00109\u001a\u00020#2\b\b\u0002\u00108\u001a\u00020\u0003H\u0002J\u0006\u0010:\u001a\u00020#J\u0016\u0010;\u001a\u00020#2\u0006\u0010<\u001a\u00020\u00132\u0006\u0010=\u001a\u00020\u0013J\u000e\u0010>\u001a\u00020#2\u0006\u0010\u0007\u001a\u00020\u0003J\"\u0010?\u001a\u00020#2\u0006\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010@\u001a\u00020A2\b\b\u0002\u0010B\u001a\u00020AR\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\nj\b\u0012\u0004\u0012\u00020\u000b`\fX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0004R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u000e¢\u0006\u0002\n\u0000¨\u0006D"}, hxF = {"Lcom/tencent/mm/plugin/vlog/player/VLogScriptReader;", "", "previewPlay", "", "(Z)V", "imagePtsStep", "", "mute", "nextPtsStep", "playerList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/vlog/player/MaterialPlayer;", "Lkotlin/collections/ArrayList;", "getPreviewPlay", "()Z", "setPreviewPlay", "scriptModel", "Lcom/tencent/mm/plugin/vlog/model/VLogScriptModel;", "targetHeight", "", "targetWidth", "texCache", "Lcom/tencent/mm/plugin/vlog/player/VLogScriptTexCache;", "videoPtsStep", "xLabEffect", "Lcom/tencent/mm/plugin/xlabeffect/XLabEffect;", "cacheMaterialPlayer", "material", "Lcom/tencent/mm/plugin/vlog/model/Material;", "cacheMaterialPlayerByIndex", FirebaseAnalytics.b.INDEX, "checkPreloadNextMaterials", "pts", "currentMaterial", "clearScreen", "", "doPreloadMaterials", "nextMaterialIndices", "drawImpl", "currentMaterials", "nextMaterialList", "outputTexture", "drawScript", "ptsMs", "outputTexId", "getPtsMaterials", "getPtsStep", "initXEffectInGlesThread", "width", "height", "needPreloadMaterials", "onPlayEnd", "loop", "pause", "prepareMaterial", "prepare", "release", "resetAllPlayers", "resume", "setMediaFps", "videoFps", "imageFps", "setMute", "setScript", "widthScale", "", "heightScale", "Companion", "plugin-vlog_release"})
public final class i {
    public static final a GBW = new a((byte) 0);
    ah GBQ;
    ArrayList<b> GBR;
    j GBS;
    long GBT;
    long GBU;
    long GBV;
    boolean GBu;
    com.tencent.mm.plugin.xlabeffect.b hiH;
    boolean isb;
    int targetHeight;
    int targetWidth;

    static {
        AppMethodBeat.i(190883);
        AppMethodBeat.o(190883);
    }

    private /* synthetic */ i() {
        this(true);
    }

    public i(boolean z) {
        AppMethodBeat.i(190882);
        this.GBu = z;
        this.isb = true;
        this.GBR = new ArrayList<>();
        this.GBS = new j();
        this.GBT = 33;
        this.GBU = 16;
        this.GBV = this.GBT;
        AppMethodBeat.o(190882);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\b"}, hxF = {"Lcom/tencent/mm/plugin/vlog/player/VLogScriptReader$Companion;", "", "()V", "TAG", "", "preloadThresholdLowerBound", "", "preloadThresholdUpperBound", "plugin-vlog_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public final void jv(int i2, int i3) {
        AppMethodBeat.i(190876);
        this.targetWidth = i2;
        this.targetHeight = i3;
        Log.i("MicroMsg.VLogScriptReader", "set target size:[" + this.targetWidth + ", " + this.targetHeight + ']');
        this.hiH = new com.tencent.mm.plugin.xlabeffect.b(this.targetWidth, this.targetHeight, 0);
        com.tencent.mm.plugin.xlabeffect.b bVar = this.hiH;
        if (bVar != null) {
            bVar.setSize(this.targetWidth, this.targetHeight);
        }
        this.GBS.fCp();
        AppMethodBeat.o(190876);
    }

    /* access modifiers changed from: package-private */
    public final ArrayList<Integer> a(long j2, ArrayList<s> arrayList) {
        List<? extends s> list;
        boolean z;
        int i2;
        boolean z2;
        AppMethodBeat.i(190877);
        ah ahVar = this.GBQ;
        if (!(ahVar == null || (list = ahVar.GzQ) == null)) {
            int i3 = 0;
            int i4 = 0;
            int size = list.size();
            while (i4 < size) {
                ArrayList<s> arrayList2 = arrayList;
                if (!arrayList2.isEmpty()) {
                    Iterator<T> it = arrayList2.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        T next = it.next();
                        if (!p.j(next.path, ((s) list.get(i4)).path) || next.startTime < ((s) list.get(i4)).startTime) {
                            z2 = false;
                            continue;
                        } else {
                            z2 = true;
                            continue;
                        }
                        if (z2) {
                            z = true;
                            break;
                        }
                    }
                }
                z = false;
                if (!z || i4 < i3) {
                    i2 = i3;
                } else {
                    i2 = i4;
                }
                i4++;
                i3 = i2;
            }
            if (i3 + 1 < list.size()) {
                long j3 = ((s) list.get(i3 + 1)).startTime - j2;
                if (400 <= j3 && 600 >= j3) {
                    ArrayList<Integer> arrayList3 = new ArrayList<>();
                    arrayList3.add(Integer.valueOf(i3 + 1));
                    AppMethodBeat.o(190877);
                    return arrayList3;
                }
            }
        }
        AppMethodBeat.o(190877);
        return null;
    }

    /* access modifiers changed from: package-private */
    public final ArrayList<s> a(ArrayList<Integer> arrayList, long j2) {
        b bVar;
        AppMethodBeat.i(190878);
        ArrayList<s> arrayList2 = new ArrayList<>();
        Iterator<T> it = arrayList.iterator();
        while (it.hasNext()) {
            int intValue = it.next().intValue();
            if (intValue < this.GBR.size()) {
                bVar = this.GBR.get(intValue);
            } else {
                bVar = null;
            }
            if (bVar != null && !bVar.GBl) {
                f.b(bn.TUK, ba.hMW(), new b(bVar, null, this, j2, arrayList2), 2);
                arrayList2.add(bVar.GBm);
            }
        }
        AppMethodBeat.o(190878);
        return arrayList2;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x0119 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(java.util.ArrayList<com.tencent.mm.plugin.vlog.model.s> r11, java.util.ArrayList<com.tencent.mm.plugin.vlog.model.s> r12, int r13, long r14) {
        /*
        // Method dump skipped, instructions count: 428
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.vlog.player.i.a(java.util.ArrayList, java.util.ArrayList, int, long):void");
    }

    static /* synthetic */ void a(i iVar) {
        AppMethodBeat.i(190881);
        iVar.wD(false);
        AppMethodBeat.o(190881);
    }

    /* access modifiers changed from: package-private */
    public final void wD(boolean z) {
        AppMethodBeat.i(190880);
        Log.i("MicroMsg.VLogScriptReader", "resetAllPlayers size:" + this.GBR.size());
        for (T t : this.GBR) {
            t.stop();
            if (z) {
                t.release();
            }
        }
        AppMethodBeat.o(190880);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0004\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0006"}, hxF = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "com/tencent/mm/plugin/vlog/player/VLogScriptReader$doPreloadMaterials$1$1$1", "com/tencent/mm/plugin/vlog/player/VLogScriptReader$$special$$inlined$apply$lambda$1"})
    static final class b extends j implements m<ai, d<? super x>, Object> {
        final /* synthetic */ b GBX;
        final /* synthetic */ i GBY;
        final /* synthetic */ long GBZ;
        final /* synthetic */ ArrayList GCa;
        int label;
        private ai p$;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(b bVar, d dVar, i iVar, long j2, ArrayList arrayList) {
            super(2, dVar);
            this.GBX = bVar;
            this.GBY = iVar;
            this.GBZ = j2;
            this.GCa = arrayList;
        }

        @Override // kotlin.d.b.a.a
        public final d<x> create(Object obj, d<?> dVar) {
            AppMethodBeat.i(190874);
            p.h(dVar, "completion");
            b bVar = new b(this.GBX, dVar, this.GBY, this.GBZ, this.GCa);
            bVar.p$ = (ai) obj;
            AppMethodBeat.o(190874);
            return bVar;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.g.a.m
        public final Object invoke(ai aiVar, d<? super x> dVar) {
            AppMethodBeat.i(190875);
            Object invokeSuspend = ((b) create(aiVar, dVar)).invokeSuspend(x.SXb);
            AppMethodBeat.o(190875);
            return invokeSuspend;
        }

        @Override // kotlin.d.b.a.a
        public final Object invokeSuspend(Object obj) {
            AppMethodBeat.i(190873);
            kotlin.d.a.a aVar = kotlin.d.a.a.COROUTINE_SUSPENDED;
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure(obj);
                    Log.i("MicroMsg.VLogScriptReader", "doPreloadMaterials, play: " + this.GBX.GBm.path + ", texture:" + this.GBX.Gxi + ", pts:" + this.GBZ + ", startTime:" + this.GBX.GBm.startTime);
                    if (!this.GBX.bcY) {
                        this.GBX.prepare();
                    }
                    this.GBX.KV(0);
                    this.GBX.O(0, false);
                    x xVar = x.SXb;
                    AppMethodBeat.o(190873);
                    return xVar;
                default:
                    IllegalStateException illegalStateException = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    AppMethodBeat.o(190873);
                    throw illegalStateException;
            }
        }
    }
}

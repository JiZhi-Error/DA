package com.tencent.mm.plugin.flutter.e.a.a;

import android.content.Intent;
import com.facebook.internal.NativeProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.modelcontrol.e;
import com.tencent.mm.plugin.recordvideo.plugin.t;
import com.tencent.mm.plugin.vlog.ui.plugin.read.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.s;
import java.util.UUID;
import kotlin.ResultKt;
import kotlin.d.b.a.j;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.g.b.z;
import kotlin.l;
import kotlin.x;
import kotlinx.coroutines.ai;
import kotlinx.coroutines.ba;
import kotlinx.coroutines.bn;
import kotlinx.coroutines.f;

@l(hxD = {1, 1, 16}, hxE = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u001c2\u00020\u00012\u00020\u0002:\u0001\u001cB\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0006\u0010\u000e\u001a\u00020\u000fJ\u0018\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0004H\u0002J,\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u00072\b\u0010\u0016\u001a\u0004\u0018\u00010\u00042\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u000fH\u0016J\u000e\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u001b\u001a\u00020\u0004R\u000e\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\n \r*\u0004\u0018\u00010\f0\fX\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, hxF = {"Lcom/tencent/mm/plugin/flutter/plugins/video/api/EditReadPlugin;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "uniqueId", "", "(Ljava/lang/String;)V", "reqId", "", "simpleAudioRemuxer", "Lcom/tencent/mm/plugin/vlog/ui/plugin/read/SimpleAudioRemuxer;", "uniqueString", "videoParams", "Lcom/tencent/mm/modelcontrol/VideoTransPara;", "kotlin.jvm.PlatformType", "cancel", "", "doNetRequest", "finderUserName", "inputText", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "release", "textToSpeech", "text", "Companion", "plugin-flutter_release"})
public final class b implements i, t {
    public static int wJJ;
    public static final a wJK = new a((byte) 0);
    private final VideoTransPara irT;
    public int wJG = -1;
    private String wJH;
    private final d wJI;

    static {
        AppMethodBeat.i(241060);
        AppMethodBeat.o(241060);
    }

    public b(String str) {
        p.h(str, "uniqueId");
        AppMethodBeat.i(241059);
        this.wJH = str;
        com.tencent.mm.kernel.b aAg = g.aAg();
        p.g(aAg, "MMKernel.network()");
        aAg.azz().a(5207, this);
        this.wJI = new d();
        e baZ = e.baZ();
        p.g(baZ, "SubCoreVideoControl.getCore()");
        this.irT = baZ.bbf();
        AppMethodBeat.o(241059);
    }

    public static final /* synthetic */ String c(b bVar) {
        AppMethodBeat.i(241062);
        String str = bVar.wJH;
        if (str == null) {
            p.btv("uniqueString");
        }
        AppMethodBeat.o(241062);
        return str;
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void aSs() {
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final String name() {
        return null;
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void onActivityResult(int i2, int i3, Intent intent) {
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final boolean onBackPress() {
        return false;
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void onDetach() {
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void onPause() {
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        AppMethodBeat.i(241061);
        p.h(strArr, NativeProtocol.RESULT_ARGS_PERMISSIONS);
        p.h(iArr, "grantResults");
        t.a.a(strArr, iArr);
        AppMethodBeat.o(241061);
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void onResume() {
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void reset() {
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void setVisibility(int i2) {
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/flutter/plugins/video/api/EditReadPlugin$Companion;", "", "()V", "BASE_REQ_ID", "", "TAG", "", "plugin-flutter_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @Override // com.tencent.mm.ak.i
    public final void onSceneEnd(int i2, int i3, String str, q qVar) {
        Integer num;
        AppMethodBeat.i(241057);
        if ((qVar instanceof com.tencent.mm.plugin.vlog.ui.plugin.read.b) && ((com.tencent.mm.plugin.vlog.ui.plugin.read.b) qVar).wJG == this.wJG) {
            if (i2 == 0 && i3 == 0) {
                String str2 = com.tencent.mm.plugin.sight.base.b.eVt() + '/' + UUID.randomUUID();
                String str3 = str2 + ".wav";
                StringBuilder append = new StringBuilder("tts success, input text:").append(((com.tencent.mm.plugin.vlog.ui.plugin.read.b) qVar).GLT).append(", speech size:");
                byte[] bArr = ((com.tencent.mm.plugin.vlog.ui.plugin.read.b) qVar).GLS;
                if (bArr != null) {
                    num = Integer.valueOf(bArr.length);
                } else {
                    num = null;
                }
                Log.i("vison", append.append(num).append(", speech duration:").append(((com.tencent.mm.plugin.vlog.ui.plugin.read.b) qVar).durationMs).append(", path:").append(str2).toString());
                s.C(str2, ((com.tencent.mm.plugin.vlog.ui.plugin.read.b) qVar).GLS);
                f.b(bn.TUK, ba.hMV(), new C1362b(this, str2, str3, qVar, null), 2);
                AppMethodBeat.o(241057);
                return;
            }
            Log.e("vison", "tts error, input text:" + ((com.tencent.mm.plugin.vlog.ui.plugin.read.b) qVar).GLT + ", errType:" + i2 + ", errCode:" + i3);
        }
        AppMethodBeat.o(241057);
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void release() {
        AppMethodBeat.i(241058);
        com.tencent.mm.kernel.b aAg = g.aAg();
        p.g(aAg, "MMKernel.network()");
        aAg.azz().b(5207, this);
        AppMethodBeat.o(241058);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@¢\u0006\u0004\b\u0003\u0010\u0004"}, hxF = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"})
    @kotlin.d.b.a.f(c = "com.tencent.mm.plugin.flutter.plugins.video.api.EditReadPlugin$onSceneEnd$1", f = "EditReadPlugin.kt", hxM = {87}, m = "invokeSuspend")
    /* renamed from: com.tencent.mm.plugin.flutter.e.a.a.b$b  reason: collision with other inner class name */
    public static final class C1362b extends j implements m<ai, kotlin.d.d<? super x>, Object> {
        Object L$0;
        final /* synthetic */ q hvN;
        int label;
        private ai p$;
        Object pED;
        final /* synthetic */ b wJL;
        final /* synthetic */ String wJM;
        final /* synthetic */ String wJN;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C1362b(b bVar, String str, String str2, q qVar, kotlin.d.d dVar) {
            super(2, dVar);
            this.wJL = bVar;
            this.wJM = str;
            this.wJN = str2;
            this.hvN = qVar;
        }

        @Override // kotlin.d.b.a.a
        public final kotlin.d.d<x> create(Object obj, kotlin.d.d<?> dVar) {
            AppMethodBeat.i(241055);
            p.h(dVar, "completion");
            C1362b bVar = new C1362b(this.wJL, this.wJM, this.wJN, this.hvN, dVar);
            bVar.p$ = (ai) obj;
            AppMethodBeat.o(241055);
            return bVar;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.g.a.m
        public final Object invoke(ai aiVar, kotlin.d.d<? super x> dVar) {
            AppMethodBeat.i(241056);
            Object invokeSuspend = ((C1362b) create(aiVar, dVar)).invokeSuspend(x.SXb);
            AppMethodBeat.o(241056);
            return invokeSuspend;
        }

        @Override // kotlin.d.b.a.a
        public final Object invokeSuspend(Object obj) {
            z.a aVar;
            AppMethodBeat.i(241054);
            kotlin.d.a.a aVar2 = kotlin.d.a.a.COROUTINE_SUSPENDED;
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure(obj);
                    ai aiVar = this.p$;
                    final z.a aVar3 = new z.a();
                    aVar3.SYB = false;
                    this.L$0 = aiVar;
                    this.pED = aVar3;
                    this.label = 1;
                    if (kotlinx.coroutines.g.a(ba.hMW(), new m<ai, kotlin.d.d<? super x>, Object>(this, null) {
                        /* class com.tencent.mm.plugin.flutter.e.a.a.b.C1362b.AnonymousClass1 */
                        int label;
                        private ai p$;
                        final /* synthetic */ C1362b wJO;

                        {
                            this.wJO = r2;
                        }

                        @Override // kotlin.d.b.a.a
                        public final kotlin.d.d<x> create(Object obj, kotlin.d.d<?> dVar) {
                            AppMethodBeat.i(241052);
                            p.h(dVar, "completion");
                            AnonymousClass1 r0 = 
                        }

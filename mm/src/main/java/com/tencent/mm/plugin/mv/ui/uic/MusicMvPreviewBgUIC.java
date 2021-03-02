package com.tencent.mm.plugin.mv.ui.uic;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.music.e.k;
import com.tencent.mm.plugin.mv.ui.uic.MusicMvPreviewTrackUIC;
import com.tencent.mm.plugin.thumbplayer.view.MMMvVideoLayout;
import com.tencent.mm.protocal.protobuf.csp;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import java.util.LinkedList;
import java.util.Map;
import kotlin.ResultKt;
import kotlin.d.b.a.f;
import kotlin.d.b.a.j;
import kotlin.d.d;
import kotlin.g.a.m;
import kotlin.g.b.aa;
import kotlin.g.b.n;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;
import kotlinx.coroutines.ai;
import kotlinx.coroutines.ba;
import kotlinx.coroutines.g;

@l(hxD = {1, 1, 16}, hxE = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010-\u001a\u00020.H\u0002J\f\u0010/\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012J\u0010\u00100\u001a\u00020.2\b\u00101\u001a\u0004\u0018\u000102J\u000e\u00103\u001a\u00020.2\u0006\u00101\u001a\u000204J\u0012\u00105\u001a\u00020.2\b\u00106\u001a\u0004\u0018\u000107H\u0016J\b\u00108\u001a\u00020.H\u0016J\u0012\u00109\u001a\u00020.2\b\u0010:\u001a\u0004\u0018\u00010;H\u0016J\b\u0010<\u001a\u00020.H\u0016J\b\u0010=\u001a\u00020.H\u0016J\u0016\u0010>\u001a\u00020.2\u0006\u0010?\u001a\u00020@2\u0006\u0010A\u001a\u00020@J\u000e\u0010B\u001a\u00020.2\u0006\u0010C\u001a\u00020DR\u0014\u0010\u0005\u001a\u00020\u0006XD¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\f\"\u0004\b\u0010\u0010\u000eR\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0014\u001a\u00020\u0015X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\b\"\u0004\b\u001c\u0010\u001dR\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\b\"\u0004\b \u0010\u001dR\u001c\u0010!\u001a\u0004\u0018\u00010\"X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001c\u0010'\u001a\u0004\u0018\u00010(X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,¨\u0006E"}, hxF = {"Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvPreviewBgUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", EnvConsts.ACTIVITY_MANAGER_SRVNAME, "Landroid/support/v7/app/AppCompatActivity;", "(Landroid/support/v7/app/AppCompatActivity;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "firstTimePlay", "", "getFirstTimePlay", "()Z", "setFirstTimePlay", "(Z)V", "isOnActivityPause", "setOnActivityPause", "mediaInfoList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/thumbplayer/model/TPMediaInfo;", "playerRecycler", "Lcom/tencent/mm/plugin/thumbplayer/view/MMCdnTPPlayerRecycler;", "getPlayerRecycler", "()Lcom/tencent/mm/plugin/thumbplayer/view/MMCdnTPPlayerRecycler;", "setPlayerRecycler", "(Lcom/tencent/mm/plugin/thumbplayer/view/MMCdnTPPlayerRecycler;)V", "thumbPath", "getThumbPath", "setThumbPath", "(Ljava/lang/String;)V", "thumbUrl", "getThumbUrl", "setThumbUrl", "trackData", "Lcom/tencent/mm/protocal/protobuf/MusicMvData;", "getTrackData", "()Lcom/tencent/mm/protocal/protobuf/MusicMvData;", "setTrackData", "(Lcom/tencent/mm/protocal/protobuf/MusicMvData;)V", "videoLayout", "Lcom/tencent/mm/plugin/thumbplayer/view/MMMvVideoLayout;", "getVideoLayout", "()Lcom/tencent/mm/plugin/thumbplayer/view/MMMvVideoLayout;", "setVideoLayout", "(Lcom/tencent/mm/plugin/thumbplayer/view/MMMvVideoLayout;)V", "checkSyncMvPositionWithMusic", "", "collectBgVideoInfo", "initBgCover", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/tencent/mm/plugin/mv/ui/uic/OnBackgroundBitmapReadyListener;", "initBgVideo", "Lcom/tencent/mm/plugin/thumbplayer/view/OnPlayerChangeMediaListener;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onNewIntent", "intent", "Landroid/content/Intent;", "onPause", "onResume", "onVideoProgressUpdate", "timeMs", "", "videoDuration", "selectMedia", FirebaseAnalytics.b.INDEX, "", "plugin-mv_release"})
public final class MusicMvPreviewBgUIC extends UIComponent {
    public csp AqY;
    public MMMvVideoLayout AtX;
    private com.tencent.mm.plugin.thumbplayer.view.a Avu = new com.tencent.mm.plugin.thumbplayer.view.a(getContext());
    private boolean Avv = true;
    private boolean Avw;
    public final String TAG = "MicroMsg.Mv.MusicMvPreviewBgUIC";
    private final LinkedList<com.tencent.mm.plugin.thumbplayer.d.a> oNM = new LinkedList<>();
    public String thumbPath;
    public String thumbUrl;

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@¢\u0006\u0004\b\u0003\u0010\u0004"}, hxF = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"})
    @f(c = "com.tencent.mm.plugin.mv.ui.uic.MusicMvPreviewBgUIC$initBgVideo$1", f = "MusicMvPreviewBgUIC.kt", hxM = {210}, m = "invokeSuspend")
    public static final class b extends j implements m<ai, d<? super x>, Object> {
        final /* synthetic */ MusicMvPreviewBgUIC Avx;
        Object L$0;
        final /* synthetic */ com.tencent.mm.plugin.thumbplayer.view.d Vao;
        int label;
        private ai p$;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(MusicMvPreviewBgUIC musicMvPreviewBgUIC, com.tencent.mm.plugin.thumbplayer.view.d dVar, d dVar2) {
            super(2, dVar2);
            this.Avx = musicMvPreviewBgUIC;
            this.Vao = dVar;
        }

        @Override // kotlin.d.b.a.a
        public final d<x> create(Object obj, d<?> dVar) {
            AppMethodBeat.i(259281);
            p.h(dVar, "completion");
            b bVar = new b(this.Avx, this.Vao, dVar);
            bVar.p$ = (ai) obj;
            AppMethodBeat.o(259281);
            return bVar;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.g.a.m
        public final Object invoke(ai aiVar, d<? super x> dVar) {
            AppMethodBeat.i(259282);
            Object invokeSuspend = ((b) create(aiVar, dVar)).invokeSuspend(x.SXb);
            AppMethodBeat.o(259282);
            return invokeSuspend;
        }

        /* access modifiers changed from: package-private */
        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0005\u0010\u0000\u001a\u00020\u00012\u0015\u0010\u0002\u001a\u00110\u0003¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00062\u0015\u0010\u0007\u001a\u00110\u0003¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\b¢\u0006\u0002\b\t"}, hxF = {"<anonymous>", "", "p1", "", "Lkotlin/ParameterName;", "name", "timeMs", "p2", "videoDuration", "invoke"})
        /* renamed from: com.tencent.mm.plugin.mv.ui.uic.MusicMvPreviewBgUIC$b$b  reason: collision with other inner class name */
        public static final /* synthetic */ class C1557b extends n implements m<Long, Long, x> {
            C1557b(MusicMvPreviewBgUIC musicMvPreviewBgUIC) {
                super(2, musicMvPreviewBgUIC);
            }

            @Override // kotlin.g.b.e
            public final kotlin.l.d Rs() {
                AppMethodBeat.i(259276);
                kotlin.l.b bp = aa.bp(MusicMvPreviewBgUIC.class);
                AppMethodBeat.o(259276);
                return bp;
            }

            @Override // kotlin.l.a, kotlin.g.b.e
            public final String getName() {
                return "onVideoProgressUpdate";
            }

            @Override // kotlin.g.b.e
            public final String getSignature() {
                return "onVideoProgressUpdate(JJ)V";
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
            @Override // kotlin.g.a.m
            public final /* synthetic */ x invoke(Long l, Long l2) {
                AppMethodBeat.i(259275);
                long longValue = l.longValue();
                long longValue2 = l2.longValue();
                com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
                h.RTc.aV(new MusicMvPreviewTrackUIC.f((MusicMvPreviewTrackUIC) com.tencent.mm.ui.component.a.b(((MusicMvPreviewBgUIC) this.SYl).getActivity()).get(MusicMvPreviewTrackUIC.class), longValue, longValue2));
                x xVar = x.SXb;
                AppMethodBeat.o(259275);
                return xVar;
            }
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, hxF = {"com/tencent/mm/plugin/mv/ui/uic/MusicMvPreviewBgUIC$initBgVideo$1$1$1", "Lcom/tencent/mm/plugin/thumbplayer/view/MvMusicProxy;", "getCurrentPosition", "", "getTotalDuration", "seekMusic", "", "position", "", "plugin-mv_release"})
        public static final class a implements com.tencent.mm.plugin.thumbplayer.view.c {
            a() {
            }

            @Override // com.tencent.mm.plugin.thumbplayer.view.c
            public final long getCurrentPosition() {
                AppMethodBeat.i(259273);
                k euj = k.euj();
                p.g(euj, "MusicPlayerManager.Instance()");
                com.tencent.mm.plugin.music.f.a.d etW = euj.etW();
                p.g(etW, "MusicPlayerManager.Instance().musicPlayer");
                long etn = (long) etW.etn();
                AppMethodBeat.o(259273);
                return etn;
            }

            @Override // com.tencent.mm.plugin.thumbplayer.view.c
            public final void Tp(int i2) {
                AppMethodBeat.i(259274);
                k euj = k.euj();
                p.g(euj, "MusicPlayerManager.Instance()");
                euj.etW().tG(i2);
                AppMethodBeat.o(259274);
            }
        }

        /* access modifiers changed from: package-private */
        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H@¢\u0006\u0004\b\u0004\u0010\u0005"}, hxF = {"<anonymous>", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/thumbplayer/model/TPMediaInfo;", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"})
        @f(c = "com.tencent.mm.plugin.mv.ui.uic.MusicMvPreviewBgUIC$initBgVideo$1$mediaInfoList$1", f = "MusicMvPreviewBgUIC.kt", hxM = {}, m = "invokeSuspend")
        public static final class c extends j implements m<ai, d<? super LinkedList<com.tencent.mm.plugin.thumbplayer.d.a>>, Object> {
            final /* synthetic */ b Vap;
            int label;
            private ai p$;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            c(b bVar, d dVar) {
                super(2, dVar);
                this.Vap = bVar;
            }

            @Override // kotlin.d.b.a.a
            public final d<x> create(Object obj, d<?> dVar) {
                AppMethodBeat.i(259278);
                p.h(dVar, "completion");
                c cVar = new c(this.Vap, dVar);
                cVar.p$ = (ai) obj;
                AppMethodBeat.o(259278);
                return cVar;
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
            @Override // kotlin.g.a.m
            public final Object invoke(ai aiVar, d<? super LinkedList<com.tencent.mm.plugin.thumbplayer.d.a>> dVar) {
                AppMethodBeat.i(259279);
                Object invokeSuspend = ((c) create(aiVar, dVar)).invokeSuspend(x.SXb);
                AppMethodBeat.o(259279);
                return invokeSuspend;
            }

            @Override // kotlin.d.b.a.a
            public final Object invokeSuspend(Object obj) {
                AppMethodBeat.i(259277);
                kotlin.d.a.a aVar = kotlin.d.a.a.COROUTINE_SUSPENDED;
                switch (this.label) {
                    case 0:
                        ResultKt.throwOnFailure(obj);
                        LinkedList<com.tencent.mm.plugin.thumbplayer.d.a> ewh = this.Vap.Avx.ewh();
                        AppMethodBeat.o(259277);
                        return ewh;
                    default:
                        IllegalStateException illegalStateException = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        AppMethodBeat.o(259277);
                        throw illegalStateException;
                }
            }
        }

        @Override // kotlin.d.b.a.a
        public final Object invokeSuspend(Object obj) {
            Object obj2;
            AppMethodBeat.i(259280);
            kotlin.d.a.a aVar = kotlin.d.a.a.COROUTINE_SUSPENDED;
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure(obj);
                    this.L$0 = this.p$;
                    this.label = 1;
                    obj2 = g.a(ba.hMW(), new c(this, null), this);
                    if (obj2 == aVar) {
                        AppMethodBeat.o(259280);
                        return aVar;
                    }
                    break;
                case 1:
                    ResultKt.throwOnFailure(obj);
                    obj2 = obj;
                    break;
                default:
                    IllegalStateException illegalStateException = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    AppMethodBeat.o(259280);
                    throw illegalStateException;
            }
            LinkedList linkedList = (LinkedList) obj2;
            Log.i(this.Avx.TAG, "init mediaInfoList:" + linkedList.size());
            if (linkedList.isEmpty()) {
                x xVar = x.SXb;
                AppMethodBeat.o(259280);
                return xVar;
            }
            FrameLayout frameLayout = (FrameLayout) this.Avx.getActivity().findViewById(R.id.y5);
            MMMvVideoLayout mMMvVideoLayout = new MMMvVideoLayout(this.Avx.getActivity());
            mMMvVideoLayout.setId(R.id.fqq);
            mMMvVideoLayout.setMediaChangeListener(this.Vao);
            mMMvVideoLayout.setMvMusicProxy(new a());
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            frameLayout.removeAllViews();
            frameLayout.addView(mMMvVideoLayout, layoutParams);
            mMMvVideoLayout.fxd();
            MMMvVideoLayout.a(mMMvVideoLayout, linkedList);
            com.tencent.mm.util.c cVar = com.tencent.mm.util.c.QYz;
            mMMvVideoLayout.setEnableEffect(com.tencent.mm.util.c.hdl());
            mMMvVideoLayout.start();
            MusicMvPreviewBgUIC.a(this.Avx);
            mMMvVideoLayout.setOnProgressUpdate(new C1557b(this.Avx));
            mMMvVideoLayout.setKeepScreenOn(true);
            this.Avx.AtX = mMMvVideoLayout;
            x xVar2 = x.SXb;
            AppMethodBeat.o(259280);
            return xVar2;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MusicMvPreviewBgUIC(AppCompatActivity appCompatActivity) {
        super(appCompatActivity);
        p.h(appCompatActivity, EnvConsts.ACTIVITY_MANAGER_SRVNAME);
        AppMethodBeat.i(257325);
        AppMethodBeat.o(257325);
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onCreate(Bundle bundle) {
        AppMethodBeat.i(257319);
        if (getIntent().getBooleanExtra("key_seek_to_start", false)) {
            k euj = k.euj();
            p.g(euj, "MusicPlayerManager.Instance()");
            euj.etW().tG(0);
        }
        AppMethodBeat.o(257319);
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onNewIntent(Intent intent) {
        AppMethodBeat.i(257320);
        super.onNewIntent(intent);
        if (intent != null) {
            if (intent.getBooleanExtra("key_seek_to_start", false)) {
                k euj = k.euj();
                p.g(euj, "MusicPlayerManager.Instance()");
                euj.etW().tG(0);
            }
            AppMethodBeat.o(257320);
            return;
        }
        AppMethodBeat.o(257320);
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onDestroy() {
        AppMethodBeat.i(257321);
        MMMvVideoLayout mMMvVideoLayout = this.AtX;
        if (mMMvVideoLayout != null) {
            mMMvVideoLayout.recycle();
        }
        com.tencent.mm.plugin.thumbplayer.view.a aVar = this.Avu;
        for (T t : aVar.Gia) {
            t.stopAsync();
            t.recycle();
        }
        for (Map.Entry<com.tencent.mm.plugin.thumbplayer.e.b, Long> entry : aVar.Gib.entrySet()) {
            entry.getKey().stopAsync();
            entry.getKey().recycle();
        }
        aVar.Gia.clear();
        aVar.Gib.clear();
        AppMethodBeat.o(257321);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0018\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\"\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\r"}, hxF = {"com/tencent/mm/plugin/mv/ui/uic/MusicMvPreviewBgUIC$initBgCover$imageLoaderListener$1", "Lcom/tencent/mm/modelimage/loader/listener/IImageLoadListener;", "onImageLoadFinish", "", "url", "", "view", "Landroid/view/View;", "imageData", "Lcom/tencent/mm/modelimage/loader/model/Response;", "onImageLoadStart", "onProcessBitmap", "Landroid/graphics/Bitmap;", "plugin-mv_release"})
    public static final class a implements com.tencent.mm.av.a.c.h {
        final /* synthetic */ MusicMvPreviewBgUIC Avx;
        final /* synthetic */ ImageView Avy;
        final /* synthetic */ a Avz;

        public a(MusicMvPreviewBgUIC musicMvPreviewBgUIC, ImageView imageView, a aVar) {
            this.Avx = musicMvPreviewBgUIC;
            this.Avy = imageView;
            this.Avz = aVar;
        }

        @Override // com.tencent.mm.av.a.c.h
        public final void b(String str, View view) {
            AppMethodBeat.i(257312);
            p.h(str, "url");
            p.h(view, "view");
            AppMethodBeat.o(257312);
        }

        @Override // com.tencent.mm.av.a.c.h
        public final Bitmap a(String str, View view, com.tencent.mm.av.a.d.b bVar) {
            AppMethodBeat.i(257313);
            p.h(str, "url");
            p.h(view, "view");
            p.h(bVar, "imageData");
            AppMethodBeat.o(257313);
            return null;
        }

        @Override // com.tencent.mm.av.a.c.h
        public final void b(String str, View view, com.tencent.mm.av.a.d.b bVar) {
            boolean z = false;
            AppMethodBeat.i(257314);
            p.h(str, "url");
            p.h(view, "view");
            p.h(bVar, "imageData");
            String str2 = this.Avx.TAG;
            Object[] objArr = new Object[2];
            objArr[0] = str;
            if (bVar.bitmap != null) {
                z = true;
            }
            objArr[1] = Boolean.valueOf(z);
            Log.i(str2, "onImageLoadFinish %s %b", objArr);
            if (bVar.bitmap != null) {
                Bitmap bitmap = bVar.bitmap;
                p.g(bitmap, "imageData.bitmap");
                if (!bitmap.isRecycled()) {
                    com.tencent.mm.ac.d.h(new C1556a(this, bVar.bitmap));
                }
            }
            AppMethodBeat.o(257314);
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
        /* renamed from: com.tencent.mm.plugin.mv.ui.uic.MusicMvPreviewBgUIC$a$a  reason: collision with other inner class name */
        static final class C1556a extends q implements kotlin.g.a.a<x> {
            final /* synthetic */ a AvA;
            final /* synthetic */ Bitmap cKG;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            C1556a(a aVar, Bitmap bitmap) {
                super(0);
                this.AvA = aVar;
                this.cKG = bitmap;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ x invoke() {
                AppMethodBeat.i(257311);
                this.AvA.Avy.setImageBitmap(BitmapUtil.fastBlurBitmap(this.cKG, 0.5f, 15));
                a aVar = this.AvA.Avz;
                if (aVar != null) {
                    Bitmap bitmap = this.cKG;
                    p.g(bitmap, "bitmap");
                    aVar.ak(bitmap);
                }
                x xVar = x.SXb;
                AppMethodBeat.o(257311);
                return xVar;
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:91:0x0290  */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x02dd  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized java.util.LinkedList<com.tencent.mm.plugin.thumbplayer.d.a> ewh() {
        /*
        // Method dump skipped, instructions count: 946
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.mv.ui.uic.MusicMvPreviewBgUIC.ewh():java.util.LinkedList");
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onResume() {
        AppMethodBeat.i(257323);
        if (this.Avw) {
            MMMvVideoLayout mMMvVideoLayout = this.AtX;
            if (mMMvVideoLayout != null) {
                mMMvVideoLayout.resume();
            }
            this.Avw = false;
        }
        AppMethodBeat.o(257323);
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onPause() {
        AppMethodBeat.i(257324);
        this.Avw = true;
        MMMvVideoLayout mMMvVideoLayout = this.AtX;
        if (mMMvVideoLayout != null) {
            mMMvVideoLayout.pause();
            AppMethodBeat.o(257324);
            return;
        }
        AppMethodBeat.o(257324);
    }

    public static final /* synthetic */ void a(MusicMvPreviewBgUIC musicMvPreviewBgUIC) {
        AppMethodBeat.i(259283);
        if (musicMvPreviewBgUIC.Avv) {
            musicMvPreviewBgUIC.Avv = false;
            if (musicMvPreviewBgUIC.getIntent().getBooleanExtra("key_seek_to_start", false)) {
                Log.i(musicMvPreviewBgUIC.TAG, "first time play and music seek to start");
                AppMethodBeat.o(259283);
                return;
            }
            k euj = k.euj();
            p.g(euj, "MusicPlayerManager.Instance()");
            com.tencent.mm.plugin.music.f.a.d etW = euj.etW();
            p.g(etW, "MusicPlayerManager.Instance().musicPlayer");
            int etn = etW.etn();
            MMMvVideoLayout mMMvVideoLayout = musicMvPreviewBgUIC.AtX;
            if (mMMvVideoLayout != null) {
                mMMvVideoLayout.KG((long) etn);
            }
            Log.i(musicMvPreviewBgUIC.TAG, "first time play and music seek to ".concat(String.valueOf(etn)));
            AppMethodBeat.o(259283);
            return;
        }
        k euj2 = k.euj();
        p.g(euj2, "MusicPlayerManager.Instance()");
        com.tencent.mm.plugin.music.f.a.d etW2 = euj2.etW();
        p.g(etW2, "MusicPlayerManager.Instance().musicPlayer");
        int etn2 = etW2.etn();
        MMMvVideoLayout mMMvVideoLayout2 = musicMvPreviewBgUIC.AtX;
        if (mMMvVideoLayout2 != null) {
            mMMvVideoLayout2.KG((long) etn2);
        }
        Log.i(musicMvPreviewBgUIC.TAG, "first time play and music seek to ".concat(String.valueOf(etn2)));
        AppMethodBeat.o(259283);
    }
}

package com.tencent.mm.plugin.mv.ui;

import android.arch.lifecycle.ViewModel;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.av.a.a.c;
import com.tencent.mm.av.q;
import com.tencent.mm.g.b.a.on;
import com.tencent.mm.plugin.music.e.k;
import com.tencent.mm.plugin.music.model.m;
import com.tencent.mm.plugin.music.ui.LyricView;
import com.tencent.mm.plugin.mv.ui.uic.MusicMvPreviewBgUIC;
import com.tencent.mm.plugin.mv.ui.uic.MusicMvPreviewLyricUIC;
import com.tencent.mm.plugin.mv.ui.uic.MusicMvPreviewTrackUIC;
import com.tencent.mm.plugin.thumbplayer.view.MMMvVideoLayout;
import com.tencent.mm.protocal.protobuf.FinderMedia;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.axw;
import com.tencent.mm.protocal.protobuf.axy;
import com.tencent.mm.protocal.protobuf.csp;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.tavkit.component.TAVExporter;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import kotlin.a.ak;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;
import kotlin.x;
import kotlinx.coroutines.ba;
import kotlinx.coroutines.bn;
import kotlinx.coroutines.f;

@com.tencent.mm.ui.base.a(32)
@l(hxD = {1, 1, 16}, hxE = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u000b\u001a\u00020\fH\u0014J\u0018\u0010\r\u001a\u0012\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00100\u000f\u0018\u00010\u000eH\u0016J\u0012\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0012H\u0014J\b\u0010\u0016\u001a\u00020\u0012H\u0014R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u0017"}, hxF = {"Lcom/tencent/mm/plugin/mv/ui/MusicMvMakerPreviewUI;", "Lcom/tencent/mm/plugin/mv/ui/BaseMusicMvUI;", "()V", "startPostUI", "", "trackData", "Lcom/tencent/mm/protocal/protobuf/MusicMvData;", "getTrackData", "()Lcom/tencent/mm/protocal/protobuf/MusicMvData;", "setTrackData", "(Lcom/tencent/mm/protocal/protobuf/MusicMvData;)V", "getLayoutId", "", "importUIComponents", "", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onPause", "onResume", "plugin-mv_release"})
public final class MusicMvMakerPreviewUI extends BaseMusicMvUI {
    csp AqY;
    private boolean AqZ;
    private HashMap _$_findViewCache;

    @Override // com.tencent.mm.plugin.mv.ui.BaseMusicMvUI, com.tencent.mm.ui.component.UIComponentActivity
    public final void _$_clearFindViewByIdCache() {
        AppMethodBeat.i(256876);
        if (this._$_findViewCache != null) {
            this._$_findViewCache.clear();
        }
        AppMethodBeat.o(256876);
    }

    @Override // com.tencent.mm.plugin.mv.ui.BaseMusicMvUI, com.tencent.mm.ui.component.UIComponentActivity
    public final View _$_findCachedViewById(int i2) {
        AppMethodBeat.i(256875);
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i2));
        if (view == null) {
            view = findViewById(i2);
            this._$_findViewCache.put(Integer.valueOf(i2), view);
        }
        AppMethodBeat.o(256875);
        return view;
    }

    @Override // com.tencent.mm.plugin.mv.ui.BaseMusicMvUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.report.MMSecDataActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // com.tencent.mm.plugin.mv.ui.BaseMusicMvUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.report.MMSecDataActivity, com.tencent.mm.ui.MMFragmentActivity
    public final Set<Class<? extends UIComponent>> importUIComponents() {
        AppMethodBeat.i(256871);
        Set<Class<? extends UIComponent>> importUIComponents = super.importUIComponents();
        if (importUIComponents != null) {
            Set<Class<? extends UIComponent>> b2 = ak.b(importUIComponents, ak.setOf((Object[]) new Class[]{MusicMvPreviewBgUIC.class, MusicMvPreviewTrackUIC.class, MusicMvPreviewLyricUIC.class}));
            AppMethodBeat.o(256871);
            return b2;
        }
        AppMethodBeat.o(256871);
        return null;
    }

    @Override // com.tencent.mm.plugin.mv.ui.BaseMusicMvUI, android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onCreate(Bundle bundle) {
        String str;
        String str2;
        MusicMvPreviewBgUIC musicMvPreviewBgUIC;
        axy axy;
        ViewGroup.LayoutParams layoutParams;
        boolean z;
        axy axy2;
        LyricView lyricView;
        FinderObject finderObject;
        FinderObjectDesc finderObjectDesc;
        axw axw;
        FinderObject finderObject2;
        FinderObjectDesc finderObjectDesc2;
        LinkedList<FinderMedia> linkedList;
        FinderMedia finderMedia;
        csp csp;
        AppMethodBeat.i(256872);
        super.onCreate(bundle);
        hideTitleView();
        View findViewById = findViewById(R.id.xt);
        Util.expandViewTouchArea(findViewById, 200, 200, 200, 200);
        findViewById.setOnClickListener(new a(this));
        Window window = getWindow();
        p.g(window, "window");
        View decorView = window.getDecorView();
        p.g(decorView, "window.decorView");
        decorView.setSystemUiVisibility(TAVExporter.VIDEO_EXPORT_HEIGHT);
        AppCompatActivity context = getContext();
        p.g(context, "context");
        setActionbarColor(context.getResources().getColor(R.color.ac_));
        hideActionbarLine();
        this.AqY = new csp();
        byte[] byteArrayExtra = getIntent().getByteArrayExtra("key_track_data");
        if (!(byteArrayExtra == null || (csp = this.AqY) == null)) {
            csp.parseFrom(byteArrayExtra);
        }
        k euj = k.euj();
        p.g(euj, "MusicPlayerManager.Instance()");
        euj.etW().tG(0);
        com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
        ViewModel viewModel = com.tencent.mm.ui.component.a.b(this).get(MusicMvPreviewBgUIC.class);
        p.g(viewModel, "UICProvider.of(this).get…PreviewBgUIC::class.java)");
        MusicMvPreviewBgUIC musicMvPreviewBgUIC2 = (MusicMvPreviewBgUIC) viewModel;
        csp csp2 = this.AqY;
        if (csp2 != null) {
            str = csp2.MxF;
        } else {
            str = null;
        }
        musicMvPreviewBgUIC2.thumbPath = str;
        csp csp3 = this.AqY;
        if (csp3 == null || (finderObject2 = csp3.MxE) == null || (finderObjectDesc2 = finderObject2.objectDesc) == null || (linkedList = finderObjectDesc2.media) == null || (finderMedia = (FinderMedia) j.kt(linkedList)) == null) {
            str2 = null;
            musicMvPreviewBgUIC = musicMvPreviewBgUIC2;
        } else {
            str2 = finderMedia.thumbUrl + finderMedia.thumb_url_token;
            musicMvPreviewBgUIC = musicMvPreviewBgUIC2;
        }
        musicMvPreviewBgUIC.thumbUrl = str2;
        ImageView imageView = (ImageView) musicMvPreviewBgUIC2.getActivity().findViewById(R.id.y6);
        MusicMvPreviewBgUIC.a aVar2 = new MusicMvPreviewBgUIC.a(musicMvPreviewBgUIC2, imageView, new b());
        String str3 = musicMvPreviewBgUIC2.thumbPath;
        if (str3 != null) {
            Log.i(musicMvPreviewBgUIC2.TAG, "initBgCover thumbPath:" + musicMvPreviewBgUIC2.thumbPath);
            com.tencent.mm.av.a.a.c bdv = new c.a().bdo().bdr().bdv();
            p.g(bdv, "ImageLoaderOptions.Build…ns.LoadFrom.FILE).build()");
            q.bcV().a(str3, imageView, bdv, aVar2);
        } else {
            MusicMvPreviewBgUIC musicMvPreviewBgUIC3 = musicMvPreviewBgUIC2;
            String str4 = musicMvPreviewBgUIC3.thumbUrl;
            if (str4 != null) {
                a aVar3 = a.ArA;
                String aIo = a.aIo(str4);
                Log.i(musicMvPreviewBgUIC3.TAG, "initBgCover url:" + str4 + " fullPath:" + aIo);
                c.a aVar4 = new c.a();
                aVar4.OS(aIo);
                aVar4.bdp();
                aVar4.bdo();
                q.bcV().a(str4, imageView, aVar4.bdv(), aVar2);
            }
        }
        musicMvPreviewBgUIC2.AqY = this.AqY;
        c cVar = new c(this);
        p.h(cVar, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        f.b(bn.TUK, ba.hMV(), new MusicMvPreviewBgUIC.b(musicMvPreviewBgUIC2, cVar, null), 2);
        com.tencent.mm.ui.component.a aVar5 = com.tencent.mm.ui.component.a.PRN;
        ((MusicMvPreviewTrackUIC) com.tencent.mm.ui.component.a.b(this).get(MusicMvPreviewTrackUIC.class)).AvJ = new d(musicMvPreviewBgUIC2);
        com.tencent.mm.ui.component.a aVar6 = com.tencent.mm.ui.component.a.PRN;
        ((MusicMvPreviewTrackUIC) com.tencent.mm.ui.component.a.b(this).get(MusicMvPreviewTrackUIC.class)).AqY = this.AqY;
        com.tencent.mm.ui.component.a aVar7 = com.tencent.mm.ui.component.a.PRN;
        ((MusicMvPreviewTrackUIC) com.tencent.mm.ui.component.a.b(this).get(MusicMvPreviewTrackUIC.class)).ewi();
        Button button = (Button) findViewById(R.id.b9t);
        if (button != null) {
            button.setOnClickListener(new e(this));
        }
        com.tencent.mm.ui.component.a aVar8 = com.tencent.mm.ui.component.a.PRN;
        MusicMvPreviewLyricUIC musicMvPreviewLyricUIC = (MusicMvPreviewLyricUIC) com.tencent.mm.ui.component.a.b(this).get(MusicMvPreviewLyricUIC.class);
        csp csp4 = this.AqY;
        if (csp4 == null || (finderObject = csp4.MxE) == null || (finderObjectDesc = finderObject.objectDesc) == null || (axw = finderObjectDesc.mvInfo) == null) {
            axy = null;
        } else {
            axy = axw.Aqo;
        }
        musicMvPreviewLyricUIC.Aqo = axy;
        com.tencent.mm.ui.component.a aVar9 = com.tencent.mm.ui.component.a.PRN;
        MusicMvPreviewLyricUIC musicMvPreviewLyricUIC2 = (MusicMvPreviewLyricUIC) com.tencent.mm.ui.component.a.b(this).get(MusicMvPreviewLyricUIC.class);
        musicMvPreviewLyricUIC2.Anv = (LyricView) musicMvPreviewLyricUIC2.getActivity().findViewById(R.id.f5l);
        int fromDPToPix = com.tencent.mm.cb.a.fromDPToPix((Context) musicMvPreviewLyricUIC2.getActivity(), 22);
        int fromDPToPix2 = com.tencent.mm.cb.a.fromDPToPix((Context) musicMvPreviewLyricUIC2.getActivity(), 4.0f);
        int fromDPToPix3 = com.tencent.mm.cb.a.fromDPToPix((Context) musicMvPreviewLyricUIC2.getActivity(), 4.0f);
        LyricView lyricView2 = musicMvPreviewLyricUIC2.Anv;
        if (lyricView2 != null) {
            lyricView2.a(Paint.Align.LEFT, fromDPToPix, fromDPToPix2, fromDPToPix3);
        }
        LyricView lyricView3 = musicMvPreviewLyricUIC2.Anv;
        if (lyricView3 != null) {
            lyricView3.setMode(1);
        }
        LyricView lyricView4 = musicMvPreviewLyricUIC2.Anv;
        if (lyricView4 != null) {
            layoutParams = lyricView4.getLayoutParams();
        } else {
            layoutParams = null;
        }
        if (layoutParams == null) {
            t tVar = new t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            AppMethodBeat.o(256872);
            throw tVar;
        }
        Resources resources = musicMvPreviewLyricUIC2.getActivity().getResources();
        p.g(resources, "activity.resources");
        ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = (int) (((float) resources.getDisplayMetrics().heightPixels) * 0.37f);
        axy axy3 = musicMvPreviewLyricUIC2.Aqo;
        if (axy3 != null) {
            String str5 = axy3.LIh;
            if (!(str5 == null || str5.length() == 0)) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                axy2 = axy3;
            } else {
                axy2 = null;
            }
            if (axy2 != null) {
                com.tencent.mm.plugin.music.model.e a2 = com.tencent.mm.plugin.music.model.e.a(axy2.LIh, musicMvPreviewLyricUIC2.getActivity().getString(R.string.f9t), "", m.iZ(axy2.LIg, axy2.musicDataUrl), axy2.lDR, false, false);
                p.g(a2, "lyricObj");
                if (a2.euw() > 1) {
                    LyricView lyricView5 = musicMvPreviewLyricUIC2.Anv;
                    if (lyricView5 != null) {
                        lyricView5.setLyricObj(a2);
                    }
                    if (!m.iZ(axy2.LIg, axy2.musicDataUrl) && (lyricView = musicMvPreviewLyricUIC2.Anv) != null) {
                        lyricView.setCurrentTime(1);
                        AppMethodBeat.o(256872);
                        return;
                    }
                }
                AppMethodBeat.o(256872);
                return;
            }
        }
        AppMethodBeat.o(256872);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/mv/ui/MusicMvMakerPreviewUI$onCreate$1$1"})
    static final class a implements View.OnClickListener {
        final /* synthetic */ MusicMvMakerPreviewUI Ara;

        a(MusicMvMakerPreviewUI musicMvMakerPreviewUI) {
            this.Ara = musicMvMakerPreviewUI;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(256865);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/mv/ui/MusicMvMakerPreviewUI$onCreate$$inlined$let$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            this.Ara.finish();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/mv/ui/MusicMvMakerPreviewUI$onCreate$$inlined$let$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(256865);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/mv/ui/MusicMvMakerPreviewUI$onCreate$4", "Lcom/tencent/mm/plugin/mv/ui/uic/OnBackgroundBitmapReadyListener;", "onReady", "", "bitmap", "Landroid/graphics/Bitmap;", "plugin-mv_release"})
    public static final class b implements com.tencent.mm.plugin.mv.ui.uic.a {
        b() {
        }

        @Override // com.tencent.mm.plugin.mv.ui.uic.a
        public final void ak(Bitmap bitmap) {
            AppMethodBeat.i(256866);
            p.h(bitmap, "bitmap");
            AppMethodBeat.o(256866);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, hxF = {"com/tencent/mm/plugin/mv/ui/MusicMvMakerPreviewUI$onCreate$5", "Lcom/tencent/mm/plugin/thumbplayer/view/OnPlayerChangeMediaListener;", "onChange", "", FirebaseAnalytics.b.INDEX, "", "targetMedia", "Lcom/tencent/mm/plugin/thumbplayer/model/TPMediaInfo;", "plugin-mv_release"})
    public static final class c implements com.tencent.mm.plugin.thumbplayer.view.d {
        final /* synthetic */ MusicMvMakerPreviewUI Ara;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        c(MusicMvMakerPreviewUI musicMvMakerPreviewUI) {
            this.Ara = musicMvMakerPreviewUI;
        }

        @Override // com.tencent.mm.plugin.thumbplayer.view.d
        public final void a(int i2, com.tencent.mm.plugin.thumbplayer.d.a aVar) {
            AppMethodBeat.i(256868);
            p.h(aVar, "targetMedia");
            com.tencent.mm.ac.d.h(new a(this, i2));
            AppMethodBeat.o(256868);
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
        static final class a extends kotlin.g.b.q implements kotlin.g.a.a<x> {
            final /* synthetic */ c Arb;
            final /* synthetic */ int puW;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(c cVar, int i2) {
                super(0);
                this.Arb = cVar;
                this.puW = i2;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ x invoke() {
                AppMethodBeat.i(256867);
                com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
                ((MusicMvPreviewTrackUIC) com.tencent.mm.ui.component.a.b(this.Arb.Ara).get(MusicMvPreviewTrackUIC.class)).Tr(this.puW);
                x xVar = x.SXb;
                AppMethodBeat.o(256867);
                return xVar;
            }
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/mv/ui/MusicMvMakerPreviewUI$onCreate$6", "Lcom/tencent/mm/plugin/mv/ui/uic/OnMediaSelectListener;", "select", "", FirebaseAnalytics.b.INDEX, "", "plugin-mv_release"})
    public static final class d implements com.tencent.mm.plugin.mv.ui.uic.b {
        final /* synthetic */ MusicMvPreviewBgUIC Arc;

        d(MusicMvPreviewBgUIC musicMvPreviewBgUIC) {
            this.Arc = musicMvPreviewBgUIC;
        }

        @Override // com.tencent.mm.plugin.mv.ui.uic.b
        public final void select(int i2) {
            boolean z;
            com.tencent.mm.plugin.thumbplayer.d.a aVar;
            AppMethodBeat.i(256869);
            MMMvVideoLayout mMMvVideoLayout = this.Arc.AtX;
            if (mMMvVideoLayout != null) {
                Log.i(mMMvVideoLayout.TAG, "seekToIndex " + i2 + ' ' + mMMvVideoLayout.dFm());
                List<com.tencent.mm.plugin.thumbplayer.d.a> list = mMMvVideoLayout.Gie;
                if (list != null) {
                    if (list.size() <= i2 || i2 < 0 || mMMvVideoLayout.Gid == i2) {
                        z = false;
                    } else {
                        z = true;
                    }
                    if (!z) {
                        list = null;
                    }
                    if (!(list == null || (aVar = list.get(i2)) == null)) {
                        mMMvVideoLayout.fxd();
                        com.tencent.mm.plugin.thumbplayer.view.c cVar = mMMvVideoLayout.Gih;
                        if (cVar != null) {
                            cVar.Tp((int) aVar.Ghu);
                        }
                        mMMvVideoLayout.Gid = i2;
                        com.tencent.mm.plugin.thumbplayer.e.b bVar = mMMvVideoLayout.Gic;
                        if (bVar != null) {
                            bVar.setMediaInfo(aVar);
                        }
                        mMMvVideoLayout.start();
                        AppMethodBeat.o(256869);
                        return;
                    }
                }
                AppMethodBeat.o(256869);
                return;
            }
            AppMethodBeat.o(256869);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class e implements View.OnClickListener {
        final /* synthetic */ MusicMvMakerPreviewUI Ara;

        e(MusicMvMakerPreviewUI musicMvMakerPreviewUI) {
            this.Ara = musicMvMakerPreviewUI;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(256870);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/mv/ui/MusicMvMakerPreviewUI$onCreate$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            Intent intent = new Intent(this.Ara, MusicMvPostUI.class);
            csp csp = this.Ara.AqY;
            if (csp != null) {
                intent.putExtra("key_track_data", csp.toByteArray());
            }
            com.tencent.mm.ac.d.a(intent, this.Ara.getIntent(), "key_mv_from_scene");
            this.Ara.AqZ = true;
            com.tencent.mm.plugin.music.model.c cVar = com.tencent.mm.plugin.music.model.c.Akc;
            com.tencent.mm.plugin.music.model.c.sm(true);
            MusicMvMakerPreviewUI musicMvMakerPreviewUI = this.Ara;
            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
            com.tencent.mm.hellhoundlib.a.a.a(musicMvMakerPreviewUI, bl.axQ(), "com/tencent/mm/plugin/mv/ui/MusicMvMakerPreviewUI$onCreate$7", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            musicMvMakerPreviewUI.startActivity((Intent) bl.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(musicMvMakerPreviewUI, "com/tencent/mm/plugin/mv/ui/MusicMvMakerPreviewUI$onCreate$7", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            com.tencent.mm.plugin.mv.a.l lVar = com.tencent.mm.plugin.mv.a.l.UZs;
            on hWv = com.tencent.mm.plugin.mv.a.l.hWv();
            hWv.PV(7);
            hWv.bfK();
            com.tencent.mm.util.b bVar2 = com.tencent.mm.util.b.QYu;
            com.tencent.mm.util.b.a(hWv);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/mv/ui/MusicMvMakerPreviewUI$onCreate$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(256870);
        }
    }

    @Override // com.tencent.mm.ui.MMActivity
    public final int getLayoutId() {
        return R.layout.bee;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onResume() {
        AppMethodBeat.i(256873);
        super.onResume();
        if (!this.AqZ) {
            this.AqZ = false;
            com.tencent.mm.plugin.music.model.c cVar = com.tencent.mm.plugin.music.model.c.Akc;
            com.tencent.mm.plugin.music.model.c.onResume();
        }
        AppMethodBeat.o(256873);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onPause() {
        AppMethodBeat.i(256874);
        super.onPause();
        com.tencent.mm.plugin.music.model.c cVar = com.tencent.mm.plugin.music.model.c.Akc;
        com.tencent.mm.plugin.music.model.c.hWr();
        AppMethodBeat.o(256874);
    }
}

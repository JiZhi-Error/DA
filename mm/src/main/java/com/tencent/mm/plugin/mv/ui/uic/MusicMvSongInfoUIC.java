package com.tencent.mm.plugin.mv.ui.uic;

import android.arch.lifecycle.ViewModel;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.a.mx;
import com.tencent.mm.loader.c.e;
import com.tencent.mm.plugin.music.f.a.d;
import com.tencent.mm.plugin.music.model.g;
import com.tencent.mm.plugin.music.ui.view.MusicMainSeekBar;
import com.tencent.mm.plugin.mv.a.k;
import com.tencent.mm.plugin.mv.ui.view.MusicMvLyricView;
import com.tencent.mm.plugin.mv.ui.view.MusicMvMarqueeTextView;
import com.tencent.mm.plugin.mv.ui.view.f;
import com.tencent.mm.plugin.thumbplayer.view.MMMvVideoLayout;
import com.tencent.mm.pluginsdk.model.app.al;
import com.tencent.mm.pluginsdk.model.app.h;
import com.tencent.mm.protocal.protobuf.axy;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMImageView;
import com.tencent.mm.ui.blur.BlurView;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.widget.MMRoundCornerImageView;
import com.tencent.mm.ui.widget.RoundCornerRelativeLayout;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 E2\u00020\u0001:\u0001EB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020\tJ\u000e\u00101\u001a\u00020/2\u0006\u00102\u001a\u00020\u0018J\"\u00103\u001a\u00020/2\u0006\u00104\u001a\u00020\u00072\u0006\u00105\u001a\u00020\u00072\b\u00106\u001a\u0004\u0018\u000107H\u0016J\u0012\u00108\u001a\u00020/2\b\u00109\u001a\u0004\u0018\u00010:H\u0016J\b\u0010;\u001a\u00020/H\u0016J\b\u0010<\u001a\u00020/H\u0016J\b\u0010=\u001a\u00020/H\u0016J\u0012\u0010>\u001a\u00020/2\b\u0010 \u001a\u0004\u0018\u00010!H\u0002J(\u0010?\u001a\u00020/2\u0006\u0010@\u001a\u00020A2\u0006\u0010B\u001a\u00020\u00072\u0006\u0010 \u001a\u00020!2\u0006\u0010C\u001a\u00020DH\u0007R9\u0010\u0005\u001a*\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u0006j\u0014\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b`\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0012\u0010\u0013\u001a\u0006\u0012\u0002\b\u00030\u0014X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0004¢\u0006\u0002\n\u0000R9\u0010\u0017\u001a*\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00180\b0\u0006j\u0014\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00180\b`\n¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\fR\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001c\u0010 \u001a\u0004\u0018\u00010!X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001c\u0010&\u001a\u0004\u0018\u00010'X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u000e\u0010,\u001a\u00020-X\u000e¢\u0006\u0002\n\u0000¨\u0006F"}, hxF = {"Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvSongInfoUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", EnvConsts.ACTIVITY_MANAGER_SRVNAME, "Landroid/support/v7/app/AppCompatActivity;", "(Landroid/support/v7/app/AppCompatActivity;)V", "mediaIconIvMap", "Ljava/util/HashMap;", "", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "Lkotlin/collections/HashMap;", "getMediaIconIvMap", "()Ljava/util/HashMap;", "music", "Lcom/tencent/mm/plugin/music/model/storage/Music;", "getMusic", "()Lcom/tencent/mm/plugin/music/model/storage/Music;", "setMusic", "(Lcom/tencent/mm/plugin/music/model/storage/Music;)V", "musicPlayerListener", "Lcom/tencent/mm/sdk/event/IListener;", "playProgressListener", "Lcom/tencent/mm/plugin/music/player/base/IMusicPlayer$PlayProgressListener;", "seekBarMap", "Lcom/tencent/mm/plugin/music/ui/view/MusicMainSeekBar;", "getSeekBarMap", "snapHelper", "Lcom/tencent/mm/emoji/panel/layout/CenterPagerSnapHelper;", "getSnapHelper", "()Lcom/tencent/mm/emoji/panel/layout/CenterPagerSnapHelper;", "setSnapHelper", "(Lcom/tencent/mm/emoji/panel/layout/CenterPagerSnapHelper;)V", "songInfo", "Lcom/tencent/mm/protocal/protobuf/FinderMVSongInfo;", "getSongInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderMVSongInfo;", "setSongInfo", "(Lcom/tencent/mm/protocal/protobuf/FinderMVSongInfo;)V", "songInfoDialog", "Lcom/tencent/mm/plugin/mv/ui/view/MusicMvSongInfoDialog;", "getSongInfoDialog", "()Lcom/tencent/mm/plugin/mv/ui/view/MusicMvSongInfoDialog;", "setSongInfoDialog", "(Lcom/tencent/mm/plugin/mv/ui/view/MusicMvSongInfoDialog;)V", "songInfoDialogPrepared", "", "addMediaIconIvMap", "", "mediaIconIv", "addSeekBar", "seekBar", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPause", "onResume", "prepareSongInfoDialog", "update", "parent", "Landroid/view/ViewGroup;", "position", "musicMv", "Lcom/tencent/mm/plugin/mv/model/MusicMv;", "Companion", "plugin-mv_release"})
public final class MusicMvSongInfoUIC extends UIComponent {
    public static final a Awm = new a((byte) 0);
    private final d.a AhI;
    public axy Aqo;
    com.tencent.mm.emoji.panel.layout.a AtW;
    com.tencent.mm.plugin.mv.ui.view.f Awi;
    private boolean Awj;
    public final HashMap<Integer, WeakReference<MusicMainSeekBar>> Awk = new HashMap<>();
    public final HashMap<Integer, WeakReference<WeImageView>> Awl = new HashMap<>();
    private final IListener<?> lEl;

    static {
        AppMethodBeat.i(257386);
        AppMethodBeat.o(257386);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/MotionEvent;", "invoke"})
    public static final class e extends q implements kotlin.g.a.b<MotionEvent, Boolean> {
        final /* synthetic */ MusicMvSongInfoUIC Awn;
        final /* synthetic */ int gUj;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public e(MusicMvSongInfoUIC musicMvSongInfoUIC, int i2) {
            super(1);
            this.Awn = musicMvSongInfoUIC;
            this.gUj = i2;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ Boolean invoke(MotionEvent motionEvent) {
            boolean z;
            com.tencent.mm.plugin.mv.ui.view.f fVar;
            com.tencent.mm.plugin.mv.ui.view.f fVar2;
            int i2 = 0;
            AppMethodBeat.i(257378);
            MotionEvent motionEvent2 = motionEvent;
            StringBuilder append = new StringBuilder("onParentClick, position:").append(this.gUj).append(", snapPosition:");
            com.tencent.mm.emoji.panel.layout.a aVar = this.Awn.AtW;
            Log.i("MicroMsg.Mv.MusicMvSongInfoUIC", append.append(aVar != null ? Integer.valueOf(aVar.hbQ) : null).toString());
            if (motionEvent2 == null || motionEvent2.getAction() != 0 || (fVar = this.Awn.Awi) == null || !fVar.dEF) {
                z = false;
            } else {
                float y = motionEvent2.getY();
                com.tencent.mm.plugin.mv.ui.view.f fVar3 = this.Awn.Awi;
                if (fVar3 != null) {
                    i2 = fVar3.uZv;
                }
                if (y >= ((float) i2) && (fVar2 = this.Awn.Awi) != null) {
                    fVar2.hide();
                }
                z = true;
            }
            Boolean valueOf = Boolean.valueOf(z);
            AppMethodBeat.o(257378);
            return valueOf;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvSongInfoUIC$Companion;", "", "()V", "TAG", "", "UPDATE_PROGRESS", "", "plugin-mv_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MusicMvSongInfoUIC(AppCompatActivity appCompatActivity) {
        super(appCompatActivity);
        p.h(appCompatActivity, EnvConsts.ACTIVITY_MANAGER_SRVNAME);
        AppMethodBeat.i(257385);
        this.AhI = new c(this, appCompatActivity);
        this.lEl = new b(this, appCompatActivity);
        AppMethodBeat.o(257385);
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onCreate(Bundle bundle) {
        AppMethodBeat.i(257380);
        super.onCreate(bundle);
        Log.i("MicroMsg.Mv.MusicMvSongInfoUIC", "onCreate");
        View findViewById = getActivity().findViewById(R.id.h93);
        p.g(findViewById, "activity.findViewById(R.id.root_layout)");
        this.Awi = new com.tencent.mm.plugin.mv.ui.view.f((ViewGroup) findViewById);
        this.lEl.alive();
        AppMethodBeat.o(257380);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    public static final class d implements View.OnClickListener {
        final /* synthetic */ com.tencent.mm.plugin.mv.a.e Awc;
        final /* synthetic */ MusicMvSongInfoUIC Awn;
        final /* synthetic */ int gUj;

        public d(MusicMvSongInfoUIC musicMvSongInfoUIC, int i2, com.tencent.mm.plugin.mv.a.e eVar) {
            this.Awn = musicMvSongInfoUIC;
            this.gUj = i2;
            this.Awc = eVar;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(257377);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/mv/ui/uic/MusicMvSongInfoUIC$update$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            StringBuilder append = new StringBuilder("onClick, position:").append(this.gUj).append(", snapPositin:");
            com.tencent.mm.emoji.panel.layout.a aVar = this.Awn.AtW;
            Log.i("MicroMsg.Mv.MusicMvSongInfoUIC", append.append(aVar != null ? Integer.valueOf(aVar.hbQ) : null).toString());
            if (!this.Awn.Awj) {
                com.tencent.mm.ui.component.a aVar2 = com.tencent.mm.ui.component.a.PRN;
                ViewModel viewModel = com.tencent.mm.ui.component.a.b(this.Awn.getActivity()).get(MusicMvDataUIC.class);
                p.g(viewModel, "UICProvider.of(activity)…sicMvDataUIC::class.java)");
                MusicMvSongInfoUIC.a(this.Awn, ((MusicMvDataUIC) viewModel).Aqo);
                this.Awn.Awj = true;
            }
            com.tencent.mm.plugin.mv.ui.view.f fVar = this.Awn.Awi;
            if (fVar != null) {
                com.tencent.mm.plugin.mv.a.e eVar = this.Awc;
                p.h(eVar, "musicMv");
                fVar.Ayc = eVar;
            }
            com.tencent.mm.plugin.mv.ui.view.f fVar2 = this.Awn.Awi;
            if (fVar2 != null) {
                String str = com.tencent.mm.plugin.mv.ui.view.f.TAG;
                StringBuilder append2 = new StringBuilder("show song info dialog, isShow:").append(fVar2.dEF).append(", translateY:");
                RoundCornerRelativeLayout ewB = fVar2.ewB();
                p.g(ewB, "dialogRootLayout");
                Log.i(str, append2.append(ewB.getTranslationY()).toString());
                if (!fVar2.dEF) {
                    Log.i(com.tencent.mm.plugin.mv.ui.view.f.TAG, "doShow");
                    com.tencent.mm.ui.component.a aVar3 = com.tencent.mm.ui.component.a.PRN;
                    Context context = fVar2.parent.getContext();
                    p.g(context, "parent.context");
                    fVar2.fuN = ((MusicMvDataUIC) com.tencent.mm.ui.component.a.ko(context).get(MusicMvDataUIC.class)).fuN;
                    String str2 = fVar2.fuN;
                    if ((str2 == null || str2.length() == 0) || !com.tencent.mm.plugin.textstatus.a.p.fvC()) {
                        Log.i(com.tencent.mm.plugin.mv.ui.view.f.TAG, "verifyInfo:" + fVar2.fuN + ", textStatusSwitch:" + com.tencent.mm.plugin.textstatus.a.p.fvC() + ", show status icon!");
                        BlurView ewH = fVar2.ewH();
                        p.g(ewH, "statusButtonBlurLayout");
                        ewH.setVisibility(4);
                    } else {
                        Log.i(com.tencent.mm.plugin.mv.ui.view.f.TAG, "verifyInfo:" + fVar2.fuN + ", textStatusSwitch:" + com.tencent.mm.plugin.textstatus.a.p.fvC() + ", hide status icon!");
                        BlurView ewH2 = fVar2.ewH();
                        p.g(ewH2, "statusButtonBlurLayout");
                        ewH2.setVisibility(0);
                    }
                    ViewGroup ewA = fVar2.ewA();
                    p.g(ewA, "songInfoFullScreenRoot");
                    ewA.setVisibility(0);
                    fVar2.ewB().animate().translationY(0.0f).setDuration(300).setListener(new f.m(fVar2)).start();
                    fVar2.ewC().animate().alpha(1.0f).setDuration(300);
                    axy axy = fVar2.Aqo;
                    com.tencent.mm.plugin.mv.a.e eVar2 = fVar2.Ayc;
                    if (!(axy == null || eVar2 == null)) {
                        k kVar = k.Aql;
                        Context context2 = fVar2.parent.getContext();
                        p.g(context2, "parent.context");
                        k.a(context2, axy, eVar2, 1, 0, 0);
                    }
                }
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/mv/ui/uic/MusicMvSongInfoUIC$update$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(257377);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    public static final class f implements View.OnClickListener {
        final /* synthetic */ com.tencent.mm.plugin.mv.a.e Awc;
        final /* synthetic */ MusicMvSongInfoUIC Awn;
        final /* synthetic */ axy Awp;
        final /* synthetic */ ViewGroup hVi;

        public f(MusicMvSongInfoUIC musicMvSongInfoUIC, ViewGroup viewGroup, axy axy, com.tencent.mm.plugin.mv.a.e eVar) {
            this.Awn = musicMvSongInfoUIC;
            this.hVi = viewGroup;
            this.Awp = axy;
            this.Awc = eVar;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(257379);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/mv/ui/uic/MusicMvSongInfoUIC$update$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
            Context context = this.hVi.getContext();
            p.g(context, "parent.context");
            int a2 = ((MusicMvMainUIC) com.tencent.mm.ui.component.a.ko(context).get(MusicMvMainUIC.class)).a(this.Awp, new a(this));
            if (a2 != 7) {
                k kVar = k.Aql;
                k.a(this.Awn.getActivity(), this.Awp, this.Awc, 2, a2, 2);
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/mv/ui/uic/MusicMvSongInfoUIC$update$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(257379);
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", "launchSuccess", "", "launchCancel", "onLaunchApp"})
        static final class a implements al {
            final /* synthetic */ f Vas;

            a(f fVar) {
                this.Vas = fVar;
            }

            @Override // com.tencent.mm.pluginsdk.model.app.al
            public final void v(boolean z, boolean z2) {
                AppMethodBeat.i(259291);
                if (z) {
                    k kVar = k.Aql;
                    k.a(this.Vas.Awn.getActivity(), this.Vas.Awp, this.Vas.Awc, 2, 1, 2);
                }
                if (z2) {
                    k kVar2 = k.Aql;
                    k.a(this.Vas.Awn.getActivity(), this.Vas.Awp, this.Vas.Awc, 2, 3, 2);
                }
                AppMethodBeat.o(259291);
            }
        }
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onResume() {
        AppMethodBeat.i(257381);
        super.onResume();
        com.tencent.mm.plugin.mv.ui.view.f fVar = this.Awi;
        if (fVar != null) {
            fVar.hide();
        }
        com.tencent.mm.plugin.music.e.k euj = com.tencent.mm.plugin.music.e.k.euj();
        p.g(euj, "MusicPlayerManager.Instance()");
        euj.etW().b(this.AhI);
        AppMethodBeat.o(257381);
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onPause() {
        AppMethodBeat.i(257382);
        com.tencent.mm.plugin.music.e.k euj = com.tencent.mm.plugin.music.e.k.euj();
        p.g(euj, "MusicPlayerManager.Instance()");
        euj.etW().c(this.AhI);
        com.tencent.mm.plugin.mv.ui.view.f fVar = this.Awi;
        if (fVar != null) {
            fVar.hide();
        }
        super.onPause();
        AppMethodBeat.o(257382);
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onDestroy() {
        AppMethodBeat.i(257383);
        this.lEl.dead();
        com.tencent.mm.plugin.mv.ui.view.f fVar = this.Awi;
        if (fVar != null) {
            fVar.hide();
        }
        com.tencent.mm.plugin.music.e.k euj = com.tencent.mm.plugin.music.e.k.euj();
        p.g(euj, "MusicPlayerManager.Instance()");
        euj.etW().c(this.AhI);
        super.onDestroy();
        AppMethodBeat.o(257383);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", "currentPos", "", "totalDuration", "onProgress"})
    static final class c implements d.a {
        final /* synthetic */ MusicMvSongInfoUIC Awn;
        final /* synthetic */ AppCompatActivity uQi;

        c(MusicMvSongInfoUIC musicMvSongInfoUIC, AppCompatActivity appCompatActivity) {
            this.Awn = musicMvSongInfoUIC;
            this.uQi = appCompatActivity;
        }

        @Override // com.tencent.mm.plugin.music.f.a.d.a
        public final void fn(final int i2, final int i3) {
            AppMethodBeat.i(257376);
            com.tencent.mm.ac.d.h(new kotlin.g.a.a<x>(this) {
                /* class com.tencent.mm.plugin.mv.ui.uic.MusicMvSongInfoUIC.c.AnonymousClass1 */
                final /* synthetic */ c Awo;

                {
                    this.Awo = r2;
                }

                /* Return type fixed from 'java.lang.Object' to match base method */
                @Override // kotlin.g.a.a
                public final /* synthetic */ x invoke() {
                    int i2;
                    MusicMvLyricView evQ;
                    LinearLayoutManager linearLayoutManager;
                    AppMethodBeat.i(257375);
                    if (i2 >= 0 && i3 >= 0) {
                        Collection<WeakReference<MusicMainSeekBar>> values = this.Awo.Awn.Awk.values();
                        p.g(values, "seekBarMap.values");
                        for (T t : values) {
                            MusicMainSeekBar musicMainSeekBar = (MusicMainSeekBar) t.get();
                            if (musicMainSeekBar != null) {
                                musicMainSeekBar.setProgress(i2);
                            }
                            MusicMainSeekBar musicMainSeekBar2 = (MusicMainSeekBar) t.get();
                            if (musicMainSeekBar2 != null) {
                                musicMainSeekBar2.setMaxProgress(i3);
                            }
                        }
                        com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
                        MusicMvLyricUIC musicMvLyricUIC = (MusicMvLyricUIC) com.tencent.mm.ui.component.a.b(this.Awo.uQi).get(MusicMvLyricUIC.class);
                        int i3 = i2;
                        musicMvLyricUIC.dCS = i3;
                        int i4 = musicMvLyricUIC.currentIndex;
                        com.tencent.mm.plugin.music.model.e eVar = musicMvLyricUIC.Amv;
                        if (eVar != null) {
                            i2 = eVar.Hp((long) i3);
                        } else {
                            i2 = i4;
                        }
                        if (i2 != musicMvLyricUIC.currentIndex && i2 >= 0) {
                            for (T t2 : musicMvLyricUIC.AtL) {
                                if (t2.getVisibility() == 0 && (linearLayoutManager = (LinearLayoutManager) t2.getLayoutManager()) != null) {
                                    int ks = linearLayoutManager.ks();
                                    int ku = linearLayoutManager.ku();
                                    t2.kQ();
                                    int i5 = ku + 1;
                                    if (ks - 1 <= i2 && i5 >= i2) {
                                        com.tencent.mm.hellhoundlib.b.a a2 = com.tencent.mm.hellhoundlib.b.c.a(i2, new com.tencent.mm.hellhoundlib.b.a());
                                        com.tencent.mm.hellhoundlib.a.a.a(t2, a2.axQ(), "com/tencent/mm/plugin/mv/ui/uic/MusicMvLyricUIC", "setCurrentTime", "(I)V", "Undefined", "smoothScrollToPosition", "(I)V");
                                        t2.smoothScrollToPosition(((Integer) a2.pG(0)).intValue());
                                        com.tencent.mm.hellhoundlib.a.a.a(t2, "com/tencent/mm/plugin/mv/ui/uic/MusicMvLyricUIC", "setCurrentTime", "(I)V", "Undefined", "smoothScrollToPosition", "(I)V");
                                    } else {
                                        com.tencent.mm.hellhoundlib.b.a a3 = com.tencent.mm.hellhoundlib.b.c.a(i2, new com.tencent.mm.hellhoundlib.b.a());
                                        com.tencent.mm.hellhoundlib.a.a.a(t2, a3.axQ(), "com/tencent/mm/plugin/mv/ui/uic/MusicMvLyricUIC", "setCurrentTime", "(I)V", "Undefined", "scrollToPosition", "(I)V");
                                        t2.scrollToPosition(((Integer) a3.pG(0)).intValue());
                                        com.tencent.mm.hellhoundlib.a.a.a(t2, "com/tencent/mm/plugin/mv/ui/uic/MusicMvLyricUIC", "setCurrentTime", "(I)V", "Undefined", "scrollToPosition", "(I)V");
                                    }
                                }
                            }
                        }
                        musicMvLyricUIC.currentIndex = i2;
                        MusicMvLyricView evQ2 = musicMvLyricUIC.evQ();
                        if (!(evQ2 == null || evQ2.getVisibility() != 0 || (evQ = musicMvLyricUIC.evQ()) == null)) {
                            MusicMvLyricView.a(evQ, (long) i3);
                        }
                        com.tencent.mm.ui.component.a aVar2 = com.tencent.mm.ui.component.a.PRN;
                        ((MusicMvDataUIC) com.tencent.mm.ui.component.a.b(this.Awo.uQi).get(MusicMvDataUIC.class)).Aqo.duration = i3;
                    }
                    x xVar = x.SXb;
                    AppMethodBeat.o(257375);
                    return xVar;
                }
            });
            AppMethodBeat.o(257376);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/mv/ui/uic/MusicMvSongInfoUIC$musicPlayerListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/MusicPlayerEvent;", "callback", "", "event", "plugin-mv_release"})
    public static final class b extends IListener<mx> {
        final /* synthetic */ MusicMvSongInfoUIC Awn;
        final /* synthetic */ AppCompatActivity uQi;

        b(MusicMvSongInfoUIC musicMvSongInfoUIC, AppCompatActivity appCompatActivity) {
            this.Awn = musicMvSongInfoUIC;
            this.uQi = appCompatActivity;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(mx mxVar) {
            com.tencent.mm.plugin.mv.a.e eVar;
            AppMethodBeat.i(257374);
            mx mxVar2 = mxVar;
            if (mxVar2 != null) {
                com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
                if (((MusicMvDataUIC) com.tencent.mm.ui.component.a.b(this.uQi).get(MusicMvDataUIC.class)).f(mxVar2.dSE.dSy)) {
                    switch (mxVar2.dSE.action) {
                        case 0:
                        case 1:
                            Collection<WeakReference<WeImageView>> values = this.Awn.Awl.values();
                            p.g(values, "mediaIconIvMap.values");
                            for (T t : values) {
                                WeImageView weImageView = (WeImageView) t.get();
                                if (weImageView != null) {
                                    weImageView.setImageResource(R.raw.icons_filled_pause);
                                }
                                WeImageView weImageView2 = (WeImageView) t.get();
                                if (weImageView2 != null) {
                                    weImageView2.setIconColor(this.uQi.getResources().getColor(R.color.BW_100_Alpha_0_9));
                                }
                            }
                            com.tencent.mm.ui.component.a aVar2 = com.tencent.mm.ui.component.a.PRN;
                            MMMvVideoLayout mMMvVideoLayout = ((MusicMvMainUIC) com.tencent.mm.ui.component.a.b(this.uQi).get(MusicMvMainUIC.class)).AtX;
                            if (mMMvVideoLayout != null) {
                                mMMvVideoLayout.resume();
                                break;
                            }
                            break;
                        case 2:
                        case 3:
                        case 4:
                            Collection<WeakReference<WeImageView>> values2 = this.Awn.Awl.values();
                            p.g(values2, "mediaIconIvMap.values");
                            for (T t2 : values2) {
                                WeImageView weImageView3 = (WeImageView) t2.get();
                                if (weImageView3 != null) {
                                    weImageView3.setImageResource(R.raw.icons_filled_play);
                                }
                                WeImageView weImageView4 = (WeImageView) t2.get();
                                if (weImageView4 != null) {
                                    weImageView4.setIconColor(this.uQi.getResources().getColor(R.color.BW_100_Alpha_0_9));
                                }
                            }
                            com.tencent.mm.ui.component.a aVar3 = com.tencent.mm.ui.component.a.PRN;
                            MMMvVideoLayout mMMvVideoLayout2 = ((MusicMvMainUIC) com.tencent.mm.ui.component.a.b(this.uQi).get(MusicMvMainUIC.class)).AtX;
                            if (mMMvVideoLayout2 != null) {
                                mMMvVideoLayout2.pause();
                            }
                            com.tencent.mm.ui.component.a aVar4 = com.tencent.mm.ui.component.a.PRN;
                            MusicMvMainUIC musicMvMainUIC = (MusicMvMainUIC) com.tencent.mm.ui.component.a.b(this.uQi).get(MusicMvMainUIC.class);
                            com.tencent.mm.plugin.mv.ui.a.b bVar = (com.tencent.mm.plugin.mv.ui.a.b) j.L(musicMvMainUIC.kgc, musicMvMainUIC.tex);
                            if (!(bVar == null || (eVar = bVar.ArY) == null)) {
                                eVar.UZm++;
                                break;
                            }
                    }
                }
            }
            AppMethodBeat.o(257374);
            return false;
        }
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onActivityResult(int i2, int i3, Intent intent) {
        com.tencent.mm.plugin.mv.ui.view.f fVar;
        AppMethodBeat.i(257384);
        super.onActivityResult(i2, i3, intent);
        switch (i2) {
            case 1:
                if (i3 == -1 && (fVar = this.Awi) != null) {
                    fVar.hide();
                    AppMethodBeat.o(257384);
                    return;
                }
        }
        AppMethodBeat.o(257384);
    }

    public static final /* synthetic */ void a(MusicMvSongInfoUIC musicMvSongInfoUIC, axy axy) {
        String str;
        AppMethodBeat.i(259292);
        Log.i("MicroMsg.Mv.MusicMvSongInfoUIC", "prepareSongInfoDialog");
        com.tencent.mm.plugin.mv.ui.view.f fVar = musicMvSongInfoUIC.Awi;
        if (fVar != null) {
            fVar.Aqo = axy;
            if (axy == null) {
                Log.i(com.tencent.mm.plugin.mv.ui.view.f.TAG, "passParameters songInfo is null");
            }
            if (axy != null) {
                Log.i(com.tencent.mm.plugin.mv.ui.view.f.TAG, "updateView songName:" + axy.BPc + " songId:" + axy.AqO);
                if (!Util.isNullOrNil(axy.lDR)) {
                    TextView ewF = fVar.ewF();
                    if (ewF != null) {
                        ewF.setText(axy.lDR);
                    }
                    TextView ewF2 = fVar.ewF();
                    if (ewF2 != null) {
                        ewF2.setVisibility(0);
                    }
                } else {
                    TextView ewF3 = fVar.ewF();
                    if (ewF3 != null) {
                        ewF3.setVisibility(4);
                    }
                }
                int fromDPToPix = com.tencent.mm.cb.a.fromDPToPix(fVar.parent.getContext(), 22);
                Context context = fVar.parent.getContext();
                p.g(context, "parent.context");
                int color = context.getResources().getColor(R.color.am);
                MusicMvMarqueeTextView ewE = fVar.ewE();
                if (ewE != null) {
                    ewE.b(axy.BPc, (float) fromDPToPix, color);
                }
                MusicMvMarqueeTextView ewE2 = fVar.ewE();
                if (ewE2 != null) {
                    ewE2.setTag(axy.BPc);
                }
                String str2 = axy.Djf;
                e.a aVar = new e.a();
                Log.d(com.tencent.mm.plugin.mv.ui.view.f.TAG, "thumb url:".concat(String.valueOf(str2)));
                Log.d(com.tencent.mm.plugin.mv.ui.view.f.TAG, "special info:" + axy.albumName + ',' + axy.LIi + ',' + axy.LIj + ',' + axy.LIk);
                ArrayList arrayList = new ArrayList();
                String str3 = axy.albumName;
                String str4 = str3;
                if (!(!(str4 == null || str4.length() == 0))) {
                    str3 = null;
                }
                if (str3 != null) {
                    String string = fVar.parent.getContext().getString(R.string.hdo, str3);
                    p.g(string, "parent.context.getString…l_name_format, albumName)");
                    arrayList.add(string);
                }
                String str5 = axy.LIi;
                String str6 = str5;
                if (!(!(str6 == null || str6.length() == 0))) {
                    str5 = null;
                }
                if (str5 != null) {
                    arrayList.add(str5);
                }
                String str7 = axy.LIj;
                if (!(str7 == null || str7.length() == 0) || axy.LIk > 0) {
                    String d2 = com.tencent.mm.plugin.mv.ui.view.f.d(axy);
                    if (d2.length() > 0) {
                        arrayList.add(d2);
                    }
                }
                if (!arrayList.isEmpty()) {
                    int aG = com.tencent.mm.cb.a.aG(fVar.parent.getContext(), R.dimen.c5);
                    Context context2 = fVar.parent.getContext();
                    p.g(context2, "parent.context");
                    ((MusicMvMarqueeTextView) fVar.AyO.getValue()).b(j.a(arrayList, "  ", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (kotlin.g.a.b) null, 62), (float) aG, context2.getResources().getColor(R.color.BW_100_Alpha_0_5));
                }
                g gVar = g.Aku;
                aVar.Hh(g.aHP(axy.Djf));
                aVar.hZJ = true;
                aVar.hZI = true;
                com.tencent.mm.loader.c.e aJT = aVar.aJT();
                MMImageView ewG = fVar.ewG();
                if (!(str2 == null || ewG == null)) {
                    com.tencent.mm.loader.e eVar = com.tencent.mm.loader.e.hXU;
                    com.tencent.mm.loader.e.aJs().a(str2, ewG, aJT, new f.l(str2, ewG, aJT, fVar, axy));
                }
            }
            if (!Util.isNullOrNil(axy != null ? axy.LIf : null)) {
                Context context3 = fVar.parent.getContext();
                com.tencent.mm.plugin.comm.a aVar2 = com.tencent.mm.plugin.comm.a.qCo;
                if (com.tencent.mm.plugin.comm.a.akQ(axy != null ? axy.LIf : null)) {
                    TextView ewL = fVar.ewL();
                    p.g(ewL, "copyrightFromTv");
                    ewL.setText(context3.getString(R.string.f_7, context3.getString(R.string.frd)));
                } else {
                    String r = h.r(context3, axy != null ? axy.LIf : null);
                    p.g(r, "appName");
                    if (r.length() > 0) {
                        TextView ewL2 = fVar.ewL();
                        p.g(ewL2, "copyrightFromTv");
                        ewL2.setVisibility(0);
                        TextView ewL3 = fVar.ewL();
                        p.g(ewL3, "copyrightFromTv");
                        ewL3.setText(context3.getString(R.string.f_7, r));
                    } else {
                        TextView ewL4 = fVar.ewL();
                        p.g(ewL4, "copyrightFromTv");
                        ewL4.setVisibility(8);
                    }
                }
                com.tencent.mm.plugin.mv.ui.a aVar3 = com.tencent.mm.plugin.mv.ui.a.ArA;
                if (axy != null) {
                    str = axy.LIf;
                } else {
                    str = null;
                }
                com.tencent.mm.plugin.mv.ui.a.i(str, (MMRoundCornerImageView) fVar.AyS.getValue());
            } else {
                ViewGroup ewJ = fVar.ewJ();
                if (ewJ != null) {
                    ewJ.setVisibility(4);
                }
            }
        }
        com.tencent.mm.plugin.mv.ui.view.f fVar2 = musicMvSongInfoUIC.Awi;
        if (fVar2 != null) {
            fVar2.dEF = false;
            RoundCornerRelativeLayout ewB = fVar2.ewB();
            p.g(ewB, "dialogRootLayout");
            ewB.setTranslationY(((float) fVar2.uZv) * -1.0f);
            AppMethodBeat.o(259292);
            return;
        }
        AppMethodBeat.o(259292);
    }
}

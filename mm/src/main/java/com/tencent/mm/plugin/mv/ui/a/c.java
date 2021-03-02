package com.tencent.mm.plugin.mv.ui.a;

import android.annotation.SuppressLint;
import android.arch.lifecycle.ViewModel;
import android.content.Context;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.appbrand.jsapi.ac.e;
import com.tencent.mm.plugin.finder.presenter.contract.CommentDrawerContract;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.plugin.music.ui.view.MusicMainSeekBar;
import com.tencent.mm.plugin.mv.a.e;
import com.tencent.mm.plugin.mv.ui.adapter.MusicLyricLayoutManager;
import com.tencent.mm.plugin.mv.ui.uic.MusicMvChattingUIC;
import com.tencent.mm.plugin.mv.ui.uic.MusicMvDataUIC;
import com.tencent.mm.plugin.mv.ui.uic.MusicMvDebugUIC;
import com.tencent.mm.plugin.mv.ui.uic.MusicMvInfoUIC;
import com.tencent.mm.plugin.mv.ui.uic.MusicMvMainUIC;
import com.tencent.mm.plugin.mv.ui.uic.MusicMvShareUIC;
import com.tencent.mm.plugin.secdata.ui.SecDataUIC;
import com.tencent.mm.plugin.thumbplayer.view.MMMvVideoLayout;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.axy;
import com.tencent.mm.protocal.protobuf.cst;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import java.util.List;
import java.util.Set;
import kotlin.a.ak;
import org.json.JSONObject;

@kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\t\u0018\u0000 *2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002*+B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\f\u001a\u00020\rH\u0016J\u0016\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0002J\u0016\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0002J\u0016\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0002J \u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\rH\u0003J\u0016\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0002J\u0016\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0002J\u0010\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u001aH\u0003J \u0010\u001b\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\rH\u0007J\u0018\u0010\u001c\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0002H\u0002J@\u0010\u001d\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\r2\u0006\u0010\u001e\u001a\u00020\r2\u0006\u0010\u001f\u001a\u00020 2\u000e\u0010!\u001a\n\u0012\u0004\u0012\u00020#\u0018\u00010\"H\u0016J \u0010$\u001a\u00020\u000f2\u0006\u0010%\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u001e\u001a\u00020\rH\u0016J\u0010\u0010&\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0018\u0010'\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0002H\u0002J\u0016\u0010(\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0002J\u0018\u0010)\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0002H\u0003R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000¨\u0006,"}, hxF = {"Lcom/tencent/mm/plugin/mv/ui/convert/MvItemConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/mv/ui/convert/MvConvertData;", EnvConsts.ACTIVITY_MANAGER_SRVNAME, "Landroid/support/v7/app/AppCompatActivity;", "(Landroid/support/v7/app/AppCompatActivity;)V", "getActivity", "()Landroid/support/v7/app/AppCompatActivity;", "fullScreenAnimate", "Lcom/tencent/mm/plugin/mv/ui/uic/VisibleRecord;", "lyricRecycler", "Landroid/support/v7/widget/RecyclerView;", "getLayoutId", "", "initBgCover", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "initChattingInfo", "initDeleteStatus", "initFullScreen", "position", "initLocalPostStats", "initMvInfo", "initSongHolderView", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "initSongInfo", "likeMvClick", "onBindViewHolder", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "recyclerView", "onViewRecycled", "updateCommentCount", "updateFullScreen", "updateLikeStatus", "Companion", "ItemGestureListener", "plugin-mv_release"})
public final class c extends com.tencent.mm.view.recyclerview.e<b> {
    private static final String TAG = TAG;
    public static final s UZQ = new s((byte) 0);
    private RecyclerView ArZ;
    private final com.tencent.mm.plugin.mv.ui.uic.c Asa = new com.tencent.mm.plugin.mv.ui.uic.c();
    final AppCompatActivity tUQ;

    public c(AppCompatActivity appCompatActivity) {
        kotlin.g.b.p.h(appCompatActivity, EnvConsts.ACTIVITY_MANAGER_SRVNAME);
        AppMethodBeat.i(257036);
        this.tUQ = appCompatActivity;
        AppMethodBeat.o(257036);
    }

    public static final /* synthetic */ void b(c cVar, com.tencent.mm.view.recyclerview.h hVar, b bVar) {
        AppMethodBeat.i(259233);
        cVar.c(hVar, bVar);
        AppMethodBeat.o(259233);
    }

    public static final /* synthetic */ void e(com.tencent.mm.view.recyclerview.h hVar, b bVar) {
        AppMethodBeat.i(259232);
        d(hVar, bVar);
        AppMethodBeat.o(259232);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.view.recyclerview.h, com.tencent.mm.view.recyclerview.a, int, int, boolean, java.util.List] */
    /* JADX WARNING: Removed duplicated region for block: B:103:0x04ff  */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x0598 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:110:0x060a  */
    /* JADX WARNING: Removed duplicated region for block: B:112:0x0619  */
    /* JADX WARNING: Removed duplicated region for block: B:122:0x0694  */
    /* JADX WARNING: Removed duplicated region for block: B:124:0x06ba  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x00a7 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:142:0x078a  */
    /* JADX WARNING: Removed duplicated region for block: B:145:0x07d3  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x011a  */
    @Override // com.tencent.mm.view.recyclerview.e
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ void a(com.tencent.mm.view.recyclerview.h r11, com.tencent.mm.plugin.mv.ui.a.b r12, int r13, int r14, boolean r15, java.util.List r16) {
        /*
        // Method dump skipped, instructions count: 2303
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.mv.ui.a.c.a(com.tencent.mm.view.recyclerview.h, com.tencent.mm.view.recyclerview.a, int, int, boolean, java.util.List):void");
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/mv/ui/convert/MvItemConvert$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-mv_release"})
    public static final class s {
        private s() {
        }

        public /* synthetic */ s(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(259231);
        AppMethodBeat.o(259231);
    }

    @Override // com.tencent.mm.view.recyclerview.e
    public final int getLayoutId() {
        return R.layout.beb;
    }

    @Override // com.tencent.mm.view.recyclerview.e
    public final void a(RecyclerView recyclerView, com.tencent.mm.view.recyclerview.h hVar, int i2) {
        AppMethodBeat.i(257029);
        kotlin.g.b.p.h(recyclerView, "recyclerView");
        kotlin.g.b.p.h(hVar, "holder");
        com.tencent.mm.view.recyclerview.h hVar2 = hVar;
        WeImageView weImageView = (WeImageView) hVar2.aus.findViewById(R.id.fbn);
        ((MusicMainSeekBar) hVar2.aus.findViewById(R.id.f6g)).setOnSeekBarChange(new n(this, hVar2, weImageView));
        com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
        ViewModel viewModel = com.tencent.mm.ui.component.a.b(this.tUQ).get(MusicMvDataUIC.class);
        kotlin.g.b.p.g(viewModel, "UICProvider.of(activity)…sicMvDataUIC::class.java)");
        MusicMvDataUIC musicMvDataUIC = (MusicMvDataUIC) viewModel;
        if (weImageView != null) {
            weImageView.setOnClickListener(new o(this, weImageView, hVar2, musicMvDataUIC));
        }
        this.ArZ = (RecyclerView) hVar2.aus.findViewById(R.id.f5j);
        RecyclerView recyclerView2 = this.ArZ;
        if (recyclerView2 != null) {
            View view = hVar2.aus;
            kotlin.g.b.p.g(view, "holder.itemView");
            Context context = view.getContext();
            kotlin.g.b.p.g(context, "holder.itemView.context");
            recyclerView2.setLayoutManager(new MusicLyricLayoutManager(context, (byte) 0));
        }
        RecyclerView recyclerView3 = this.ArZ;
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) (recyclerView3 != null ? recyclerView3.getLayoutParams() : null);
        if (marginLayoutParams != null) {
            Resources resources = this.tUQ.getResources();
            kotlin.g.b.p.g(resources, "activity.resources");
            View view2 = hVar2.aus;
            kotlin.g.b.p.g(view2, "holder.itemView");
            marginLayoutParams.topMargin = (int) ((((float) resources.getDisplayMetrics().heightPixels) * 0.37f) - ((float) com.tencent.mm.cb.a.fromDPToPix(view2.getContext(), 15)));
            AppMethodBeat.o(257029);
            return;
        }
        AppMethodBeat.o(257029);
    }

    @Override // com.tencent.mm.view.recyclerview.e
    public final void b(com.tencent.mm.view.recyclerview.h hVar) {
        AppMethodBeat.i(257030);
        kotlin.g.b.p.h(hVar, "holder");
        super.b(hVar);
        AppMethodBeat.o(257030);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0018\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\b\u001a\u00020\u0003H\u0016¨\u0006\t"}, hxF = {"com/tencent/mm/plugin/mv/ui/convert/MvItemConvert$initSongHolderView$1", "Lcom/tencent/mm/plugin/music/ui/view/MusicMainSeekBar$OnSeekBarChange;", "onSeekBarChange", "", "seekPosition", "", "max", "onSeekEnd", "onSeekStart", "plugin-mv_release"})
    public static final class n implements MusicMainSeekBar.b {
        final /* synthetic */ c Asc;
        final /* synthetic */ WeImageView Ask;
        final /* synthetic */ RecyclerView.v wrN;

        n(c cVar, RecyclerView.v vVar, WeImageView weImageView) {
            this.Asc = cVar;
            this.wrN = vVar;
            this.Ask = weImageView;
        }

        @Override // com.tencent.mm.plugin.music.ui.view.MusicMainSeekBar.b
        public final void evo() {
            AppMethodBeat.i(257022);
            View findViewById = this.wrN.aus.findViewById(R.id.dos);
            kotlin.g.b.p.g(findViewById, "holder.itemView.findView…>(R.id.header_song_panel)");
            findViewById.setVisibility(4);
            WeImageView weImageView = this.Ask;
            kotlin.g.b.p.g(weImageView, "mediaIconIv");
            weImageView.setVisibility(4);
            SecDataUIC.a aVar = SecDataUIC.CWq;
            cst cst = (cst) SecDataUIC.a.a(this.Asc.tUQ, 7, cst.class);
            if (cst != null) {
                cst.Vkc = 1;
                AppMethodBeat.o(257022);
                return;
            }
            AppMethodBeat.o(257022);
        }

        @Override // com.tencent.mm.plugin.music.ui.view.MusicMainSeekBar.b
        public final void hv(int i2, int i3) {
            AppMethodBeat.i(257023);
            s sVar = c.UZQ;
            Log.i(c.TAG, "onSeekEnd, seekPosition:" + i2 + ", max:" + i3);
            View findViewById = this.wrN.aus.findViewById(R.id.dos);
            kotlin.g.b.p.g(findViewById, "holder.itemView.findView…>(R.id.header_song_panel)");
            findViewById.setVisibility(0);
            com.tencent.mm.ay.a.tG(i2);
            com.tencent.mm.plugin.music.e.k euj = com.tencent.mm.plugin.music.e.k.euj();
            kotlin.g.b.p.g(euj, "MusicPlayerManager.Instance()");
            com.tencent.mm.plugin.music.f.a.d etW = euj.etW();
            kotlin.g.b.p.g(etW, "MusicPlayerManager.Instance().musicPlayer");
            float duration = ((float) etW.getDuration()) * (((float) i2) / ((float) i3));
            MMMvVideoLayout mMMvVideoLayout = (MMMvVideoLayout) this.wrN.aus.findViewById(R.id.fqq);
            if (mMMvVideoLayout != null) {
                mMMvVideoLayout.KG(kotlin.h.a.L((double) duration));
            }
            com.tencent.mm.ay.a.bdZ();
            this.Ask.setImageResource(R.raw.icons_filled_pause);
            WeImageView weImageView = this.Ask;
            View view = this.wrN.aus;
            kotlin.g.b.p.g(view, "holder.itemView");
            weImageView.setIconColor(view.getResources().getColor(R.color.BW_100_Alpha_0_9));
            WeImageView weImageView2 = this.Ask;
            kotlin.g.b.p.g(weImageView2, "mediaIconIv");
            weImageView2.setVisibility(0);
            AppMethodBeat.o(257023);
        }

        @Override // com.tencent.mm.plugin.music.ui.view.MusicMainSeekBar.b
        public final void hw(int i2, int i3) {
            AppMethodBeat.i(257024);
            s sVar = c.UZQ;
            Log.i(c.TAG, "onSeekBarChange " + i2 + ' ' + i3);
            AppMethodBeat.o(257024);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/mv/ui/convert/MvItemConvert$initSongHolderView$2", "Landroid/view/View$OnClickListener;", "onClick", "", "v", "Landroid/view/View;", "plugin-mv_release"})
    public static final class o implements View.OnClickListener {
        final /* synthetic */ c Asc;
        final /* synthetic */ WeImageView Ask;
        final /* synthetic */ MusicMvDataUIC UZR;
        final /* synthetic */ RecyclerView.v wrN;

        o(c cVar, WeImageView weImageView, RecyclerView.v vVar, MusicMvDataUIC musicMvDataUIC) {
            this.Asc = cVar;
            this.Ask = weImageView;
            this.wrN = vVar;
            this.UZR = musicMvDataUIC;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(257025);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/mv/ui/convert/MvItemConvert$initSongHolderView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            com.tencent.mm.plugin.music.e.k euj = com.tencent.mm.plugin.music.e.k.euj();
            kotlin.g.b.p.g(euj, "MusicPlayerManager.Instance()");
            com.tencent.mm.plugin.music.f.a.d etW = euj.etW();
            kotlin.g.b.p.g(etW, "MusicPlayerManager.Instance().musicPlayer");
            if (etW.bec()) {
                s sVar = c.UZQ;
                Log.i(c.TAG, "onSingleTap, stop music");
                com.tencent.mm.ay.a.bdY();
                this.Ask.setImageResource(R.raw.icons_filled_play);
                WeImageView weImageView = this.Ask;
                View view2 = this.wrN.aus;
                kotlin.g.b.p.g(view2, "holder.itemView");
                weImageView.setIconColor(view2.getResources().getColor(R.color.BW_100_Alpha_0_9));
                com.tencent.mm.plugin.mv.a.k kVar = com.tencent.mm.plugin.mv.a.k.Aql;
                com.tencent.mm.plugin.mv.a.k.a(this.Asc.tUQ, this.UZR.Aqo, 2);
                SecDataUIC.a aVar = SecDataUIC.CWq;
                cst cst = (cst) SecDataUIC.a.a(this.Asc.tUQ, 7, cst.class);
                if (cst != null) {
                    cst.Vkf = Util.currentTicks();
                }
                MMMvVideoLayout mMMvVideoLayout = (MMMvVideoLayout) this.wrN.aus.findViewById(R.id.fqq);
                if (mMMvVideoLayout != null) {
                    mMMvVideoLayout.pause();
                }
            } else {
                com.tencent.mm.plugin.music.e.k euj2 = com.tencent.mm.plugin.music.e.k.euj();
                kotlin.g.b.p.g(euj2, "MusicPlayerManager.Instance()");
                com.tencent.mm.plugin.music.f.a.d etW2 = euj2.etW();
                kotlin.g.b.p.g(etW2, "MusicPlayerManager.Instance().musicPlayer");
                if (etW2.bee()) {
                    com.tencent.mm.ui.component.a aVar2 = com.tencent.mm.ui.component.a.PRN;
                    ((MusicMvMainUIC) com.tencent.mm.ui.component.a.b(this.Asc.tUQ).get(MusicMvMainUIC.class)).axd(this.wrN.lR());
                    com.tencent.mm.plugin.music.e.k euj3 = com.tencent.mm.plugin.music.e.k.euj();
                    kotlin.g.b.p.g(euj3, "MusicPlayerManager.Instance()");
                    euj3.etW().resume();
                } else {
                    com.tencent.mm.plugin.music.e.k.euj().t(com.tencent.mm.ay.a.bef());
                }
                this.Ask.setImageResource(R.raw.icons_filled_pause);
                WeImageView weImageView2 = this.Ask;
                View view3 = this.wrN.aus;
                kotlin.g.b.p.g(view3, "holder.itemView");
                weImageView2.setIconColor(view3.getResources().getColor(R.color.BW_100_Alpha_0_9));
                MMMvVideoLayout mMMvVideoLayout2 = (MMMvVideoLayout) this.wrN.aus.findViewById(R.id.fqq);
                if (mMMvVideoLayout2 != null) {
                    mMMvVideoLayout2.resume();
                }
                com.tencent.mm.plugin.mv.a.k kVar2 = com.tencent.mm.plugin.mv.a.k.Aql;
                com.tencent.mm.plugin.mv.a.k.a(this.Asc.tUQ, this.UZR.Aqo, 1);
                SecDataUIC.a aVar3 = SecDataUIC.CWq;
                cst cst2 = (cst) SecDataUIC.a.a(this.Asc.tUQ, 7, cst.class);
                if (cst2 != null && cst2.Vkf > 0) {
                    long ticksToNow = Util.ticksToNow(cst2.Vkf);
                    s sVar2 = c.UZQ;
                    Log.i(c.TAG, "accumulate pauseTime:".concat(String.valueOf(ticksToNow)));
                    cst2.Vke = ticksToNow + cst2.Vke;
                    cst2.Vkf = -1;
                }
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/mv/ui/convert/MvItemConvert$initSongHolderView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(257025);
        }
    }

    public final void a(com.tencent.mm.view.recyclerview.h hVar, b bVar) {
        AppMethodBeat.i(257032);
        kotlin.g.b.p.h(hVar, "holder");
        kotlin.g.b.p.h(bVar, "item");
        Set<Integer> of = ak.setOf((Object[]) new Integer[]{Integer.valueOf((int) R.id.fbn), Integer.valueOf((int) R.id.f6g), Integer.valueOf((int) R.id.ch), Integer.valueOf((int) R.id.i2a), Integer.valueOf((int) R.id.d8d), Integer.valueOf((int) R.id.d90)});
        if (bVar.ArY.onr) {
            this.Asa.eD(hVar.aus).s(of).t(ak.setOf(Integer.valueOf((int) R.id.xt)));
            this.Asa.Awq.clear();
            View findViewById = hVar.aus.findViewById(R.id.i2f);
            if (findViewById != null) {
                findViewById.animate().cancel();
                findViewById.animate().translationX(-((float) com.tencent.mm.cb.a.fromDPToPix(hVar.getContext(), 24))).start();
                AppMethodBeat.o(257032);
                return;
            }
            AppMethodBeat.o(257032);
            return;
        }
        this.Asa.eD(hVar.aus).u(of).u(ak.setOf(Integer.valueOf((int) R.id.xt)));
        this.Asa.Awq.clear();
        View findViewById2 = hVar.aus.findViewById(R.id.i2f);
        if (findViewById2 != null) {
            findViewById2.animate().cancel();
            findViewById2.animate().translationX(0.0f).start();
            AppMethodBeat.o(257032);
            return;
        }
        AppMethodBeat.o(257032);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class d implements View.OnClickListener {
        final /* synthetic */ c Asc;
        final /* synthetic */ b Asf;

        d(c cVar, b bVar) {
            this.Asc = cVar;
            this.Asf = bVar;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(257011);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/mv/ui/convert/MvItemConvert$initDeleteStatus$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
            ((MusicMvInfoUIC) com.tencent.mm.ui.component.a.b(this.Asc.tUQ).get(MusicMvInfoUIC.class)).f(this.Asf.ArY);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/mv/ui/convert/MvItemConvert$initDeleteStatus$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(257011);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, hxF = {"com/tencent/mm/plugin/mv/ui/convert/MvItemConvert$initChattingInfo$1", "Lcom/tencent/mm/plugin/mv/ui/uic/callback/OnChattingViewEventListener;", "onReferLinkClicked", "", "feedId", "", "nonceId", "", "plugin-mv_release"})
    /* renamed from: com.tencent.mm.plugin.mv.ui.a.c$c  reason: collision with other inner class name */
    public static final class C1547c implements com.tencent.mm.plugin.mv.ui.uic.a.a {
        final /* synthetic */ MusicMvChattingUIC Ase;

        C1547c(MusicMvChattingUIC musicMvChattingUIC) {
            this.Ase = musicMvChattingUIC;
        }

        @Override // com.tencent.mm.plugin.mv.ui.uic.a.a
        public final void B(long j2, String str) {
            AppMethodBeat.i(257010);
            kotlin.g.b.p.h(str, "nonceId");
            com.tencent.mm.plugin.mv.ui.uic.a.a aVar = this.Ase.AsZ;
            if (aVar != null) {
                aVar.B(j2, str);
                AppMethodBeat.o(257010);
                return;
            }
            AppMethodBeat.o(257010);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class p implements View.OnClickListener {
        final /* synthetic */ c Asc;

        p(c cVar) {
            this.Asc = cVar;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(257026);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/mv/ui/convert/MvItemConvert$initSongInfo$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            this.Asc.tUQ.finish();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/mv/ui/convert/MvItemConvert$initSongInfo$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(257026);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class q implements View.OnClickListener {
        final /* synthetic */ c Asc;
        final /* synthetic */ b Asf;

        q(c cVar, b bVar) {
            this.Asc = cVar;
            this.Asf = bVar;
        }

        public final void onClick(View view) {
            com.tencent.mm.ui.widget.a.e eVar;
            AppMethodBeat.i(257027);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/mv/ui/convert/MvItemConvert$initSongInfo$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
            MusicMvShareUIC musicMvShareUIC = (MusicMvShareUIC) com.tencent.mm.ui.component.a.b(this.Asc.tUQ).get(MusicMvShareUIC.class);
            com.tencent.mm.plugin.mv.a.e eVar2 = this.Asf.ArY;
            kotlin.g.b.p.h(eVar2, "musicMv");
            com.tencent.mm.ui.component.a aVar2 = com.tencent.mm.ui.component.a.PRN;
            ViewModel viewModel = com.tencent.mm.ui.component.a.ko(musicMvShareUIC.getContext()).get(MusicMvDataUIC.class);
            kotlin.g.b.p.g(viewModel, "UICProvider.of(context).…sicMvDataUIC::class.java)");
            MusicMvDataUIC musicMvDataUIC = (MusicMvDataUIC) viewModel;
            FinderContact finderContact = eVar2.ApJ;
            boolean z = !kotlin.g.b.p.j(finderContact != null ? finderContact.username : null, z.aUg());
            com.tencent.mm.plugin.mv.ui.a aVar3 = com.tencent.mm.plugin.mv.ui.a.ArA;
            boolean c2 = com.tencent.mm.plugin.mv.ui.a.c(eVar2);
            boolean d2 = musicMvDataUIC.d(eVar2);
            if (c2) {
                eVar = new com.tencent.mm.ui.widget.a.e((Context) musicMvShareUIC.getActivity(), 0, false);
            } else {
                com.tencent.mm.ui.widget.a.e eVar3 = new com.tencent.mm.ui.widget.a.e((Context) musicMvShareUIC.getActivity(), 0, true);
                eVar3.j(musicMvShareUIC.getActivity().getResources().getString(R.string.f8z), 17, com.tencent.mm.cb.a.fromDPToPix((Context) musicMvShareUIC.getActivity(), 12));
                eVar = eVar3;
            }
            eVar.a(new MusicMvShareUIC.d(musicMvShareUIC, c2));
            eVar.b(new MusicMvShareUIC.e(musicMvShareUIC, d2, z, eVar2, c2));
            eVar.a(new MusicMvShareUIC.f(musicMvShareUIC, eVar2));
            eVar.b(new MusicMvShareUIC.g(musicMvShareUIC, eVar2));
            eVar.b(MusicMvShareUIC.h.Awh);
            eVar.dGm();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/mv/ui/convert/MvItemConvert$initSongInfo$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(257027);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onLongClick"})
    static final class r implements View.OnLongClickListener {
        final /* synthetic */ c Asc;
        final /* synthetic */ b Asf;

        r(c cVar, b bVar) {
            this.Asc = cVar;
            this.Asf = bVar;
        }

        public final boolean onLongClick(View view) {
            Integer num = null;
            AppMethodBeat.i(257028);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/mv/ui/convert/MvItemConvert$initSongInfo$3", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, bVar.axR());
            com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
            MusicMvDebugUIC musicMvDebugUIC = (MusicMvDebugUIC) com.tencent.mm.ui.component.a.b(this.Asc.tUQ).get(MusicMvDebugUIC.class);
            com.tencent.mm.plugin.mv.a.e eVar = this.Asf.ArY;
            kotlin.g.b.p.h(eVar, "musicMv");
            com.tencent.mm.util.c cVar = com.tencent.mm.util.c.QYz;
            if (com.tencent.mm.util.c.hdg()) {
                com.tencent.mm.ui.component.a aVar2 = com.tencent.mm.ui.component.a.PRN;
                axy axy = ((MusicMvDataUIC) com.tencent.mm.ui.component.a.b(musicMvDebugUIC.getActivity()).get(MusicMvDataUIC.class)).Aqo;
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("songId", axy.AqO);
                jSONObject.put("songName", axy.BPc);
                jSONObject.put("singer", axy.lDR);
                jSONObject.put("albumName", axy.albumName);
                jSONObject.put("albumUrl", axy.Djf);
                jSONObject.put("musicWebUrl", axy.LIg);
                jSONObject.put("musicDataUrl", axy.musicDataUrl);
                jSONObject.put(FFmpegMetadataRetriever.METADATA_KEY_GENRE, axy.LIi);
                jSONObject.put("publicTime", axy.LIj);
                jSONObject.put("musicAppId", axy.LIf);
                jSONObject.put("publicTimeS", axy.LIk);
                jSONObject.put("extraInfo", axy.extraInfo);
                jSONObject.put("identification", axy.identification);
                com.tencent.mm.plugin.music.e.k euj = com.tencent.mm.plugin.music.e.k.euj();
                kotlin.g.b.p.g(euj, "MusicPlayerManager.Instance()");
                com.tencent.mm.plugin.music.f.a.d etW = euj.etW();
                jSONObject.put(FFmpegMetadataRetriever.METADATA_KEY_DURATION, etW != null ? Integer.valueOf(etW.getDuration()) : null);
                jSONObject.put("musicDuration", axy.duration);
                com.tencent.mm.plugin.music.e.k euj2 = com.tencent.mm.plugin.music.e.k.euj();
                kotlin.g.b.p.g(euj2, "MusicPlayerManager.Instance()");
                com.tencent.mm.plugin.music.f.a.d etW2 = euj2.etW();
                if (etW2 != null) {
                    num = Integer.valueOf(etW2.etn());
                }
                jSONObject.put("currentPosition", num);
                String jSONObject2 = jSONObject.toString();
                kotlin.g.b.p.g(jSONObject2, "songInfoJson.toString()");
                String l = MusicMvDebugUIC.l(eVar);
                String m = MusicMvDebugUIC.m(eVar);
                String n = MusicMvDebugUIC.n(eVar);
                String hWE = MusicMvDebugUIC.hWE();
                com.tencent.mm.ui.widget.a.e eVar2 = new com.tencent.mm.ui.widget.a.e((Context) musicMvDebugUIC.getActivity(), 0, false);
                eVar2.a(new MusicMvDebugUIC.b(musicMvDebugUIC));
                eVar2.b(new MusicMvDebugUIC.c(musicMvDebugUIC));
                eVar2.a(new MusicMvDebugUIC.d(musicMvDebugUIC, jSONObject2, l, m, n, hWE));
                eVar2.b(new MusicMvDebugUIC.e(musicMvDebugUIC));
                eVar2.b(MusicMvDebugUIC.f.Vaa);
                eVar2.dGm();
                Log.e(musicMvDebugUIC.TAG, "MV START####################################################START");
                Log.e(musicMvDebugUIC.TAG, "songInfoText: ".concat(String.valueOf(jSONObject2)));
                Log.e(musicMvDebugUIC.TAG, "mvHeadInfoText: ".concat(String.valueOf(l)));
                Log.e(musicMvDebugUIC.TAG, "mvTrackInfoText: ".concat(String.valueOf(m)));
                Log.e(musicMvDebugUIC.TAG, "mvRefObjInfoText: ".concat(String.valueOf(n)));
                Log.e(musicMvDebugUIC.TAG, "cgiInfo: ".concat(String.valueOf(n)));
                Log.e(musicMvDebugUIC.TAG, "MV END  ####################################################  END");
            }
            com.tencent.mm.hellhoundlib.a.a.a(false, (Object) this, "com/tencent/mm/plugin/mv/ui/convert/MvItemConvert$initSongInfo$3", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
            AppMethodBeat.o(257028);
            return false;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class h implements View.OnClickListener {
        final /* synthetic */ c Asc;
        final /* synthetic */ b Asf;
        final /* synthetic */ com.tencent.mm.view.recyclerview.h qhp;

        h(c cVar, com.tencent.mm.view.recyclerview.h hVar, b bVar) {
            this.Asc = cVar;
            this.qhp = hVar;
            this.Asf = bVar;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(257015);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/mv/ui/convert/MvItemConvert$initMvInfo$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            c.a(this.Asc, this.qhp, this.Asf);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/mv/ui/convert/MvItemConvert$initMvInfo$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(257015);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class i implements View.OnClickListener {
        final /* synthetic */ c Asc;
        final /* synthetic */ b Asf;
        final /* synthetic */ com.tencent.mm.view.recyclerview.h qhp;

        i(c cVar, b bVar, com.tencent.mm.view.recyclerview.h hVar) {
            this.Asc = cVar;
            this.Asf = bVar;
            this.qhp = hVar;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(257017);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/mv/ui/convert/MvItemConvert$initMvInfo$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
            MusicMvInfoUIC.a((MusicMvInfoUIC) com.tencent.mm.ui.component.a.b(this.Asc.tUQ).get(MusicMvInfoUIC.class), this.Asf.ArY, new CommentDrawerContract.CloseDrawerCallback(this) {
                /* class com.tencent.mm.plugin.mv.ui.a.c.i.AnonymousClass1 */
                final /* synthetic */ i Asi;

                /* JADX WARN: Incorrect args count in method signature: ()V */
                {
                    this.Asi = r1;
                }

                @Override // com.tencent.mm.plugin.finder.presenter.contract.CommentDrawerContract.CloseDrawerCallback
                public final void g(int i2, List<? extends com.tencent.mm.plugin.finder.model.s> list) {
                    AppMethodBeat.i(257016);
                    kotlin.g.b.p.h(list, "data");
                    this.Asi.Asf.ArY.commentCount = i2;
                    c.b(this.Asi.Asc, this.Asi.qhp, this.Asi.Asf);
                    AppMethodBeat.o(257016);
                }
            });
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/mv/ui/convert/MvItemConvert$initMvInfo$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(257017);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class j implements Runnable {
        final /* synthetic */ c Asc;
        final /* synthetic */ b Asf;
        final /* synthetic */ MusicMvDataUIC UZR;
        final /* synthetic */ com.tencent.mm.view.recyclerview.h qhp;

        j(c cVar, b bVar, MusicMvDataUIC musicMvDataUIC, com.tencent.mm.view.recyclerview.h hVar) {
            this.Asc = cVar;
            this.Asf = bVar;
            this.UZR = musicMvDataUIC;
            this.qhp = hVar;
        }

        public final void run() {
            AppMethodBeat.i(259230);
            com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
            ((MusicMvInfoUIC) com.tencent.mm.ui.component.a.b(this.Asc.tUQ).get(MusicMvInfoUIC.class)).a(this.Asf.ArY, this.UZR.tuj, new CommentDrawerContract.CloseDrawerCallback(this) {
                /* class com.tencent.mm.plugin.mv.ui.a.c.j.AnonymousClass1 */
                final /* synthetic */ j UZS;

                /* JADX WARN: Incorrect args count in method signature: ()V */
                {
                    this.UZS = r1;
                }

                @Override // com.tencent.mm.plugin.finder.presenter.contract.CommentDrawerContract.CloseDrawerCallback
                public final void g(int i2, List<? extends com.tencent.mm.plugin.finder.model.s> list) {
                    AppMethodBeat.i(259229);
                    kotlin.g.b.p.h(list, "data");
                    this.UZS.Asf.ArY.commentCount = i2;
                    c.b(this.UZS.Asc, this.UZS.qhp, this.UZS.Asf);
                    AppMethodBeat.o(259229);
                }
            });
            this.UZR.Ats = false;
            AppMethodBeat.o(259230);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class k implements View.OnClickListener {
        final /* synthetic */ c Asc;
        final /* synthetic */ b Asf;

        k(c cVar, b bVar) {
            this.Asc = cVar;
            this.Asf = bVar;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(257019);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/mv/ui/convert/MvItemConvert$initMvInfo$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            com.tencent.mm.plugin.mv.ui.a aVar = com.tencent.mm.plugin.mv.ui.a.ArA;
            if (com.tencent.mm.plugin.mv.ui.a.c(this.Asf.ArY)) {
                com.tencent.mm.ui.component.a aVar2 = com.tencent.mm.ui.component.a.PRN;
                MusicMvShareUIC musicMvShareUIC = (MusicMvShareUIC) com.tencent.mm.ui.component.a.b(this.Asc.tUQ).get(MusicMvShareUIC.class);
                com.tencent.mm.plugin.mv.a.e eVar = this.Asf.ArY;
                kotlin.g.b.p.h(eVar, "musicMv");
                FinderContact finderContact = eVar.ApJ;
                if (((finderContact != null ? finderContact.extFlag : 0) & 1024) != 0) {
                    y yVar = y.vXH;
                    String string = musicMvShareUIC.getActivity().getString(R.string.d61);
                    kotlin.g.b.p.g(string, "activity.getString(com.t…finder_private_ban_share)");
                    y.aF(musicMvShareUIC.getActivity(), string);
                } else {
                    com.tencent.mm.ui.widget.a.e eVar2 = new com.tencent.mm.ui.widget.a.e((Context) musicMvShareUIC.getActivity(), 1, false);
                    eVar2.a(new MusicMvShareUIC.b(musicMvShareUIC));
                    eVar2.a(new MusicMvShareUIC.c(musicMvShareUIC, eVar));
                    eVar2.dGm();
                }
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/mv/ui/convert/MvItemConvert$initMvInfo$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(257019);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/mv/ui/convert/MvItemConvert$initMvInfo$5$2"})
    static final class f implements View.OnClickListener {
        final /* synthetic */ b Asg;
        final /* synthetic */ MusicMvInfoUIC Ash;

        f(b bVar, MusicMvInfoUIC musicMvInfoUIC) {
            this.Asg = bVar;
            this.Ash = musicMvInfoUIC;
        }

        public final void onClick(View view) {
            String str;
            AppMethodBeat.i(257013);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/mv/ui/convert/MvItemConvert$initMvInfo$$inlined$let$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            FinderContact finderContact = this.Asg.ArY.ApJ;
            if (!(finderContact == null || (str = finderContact.username) == null)) {
                MusicMvInfoUIC musicMvInfoUIC = this.Ash;
                kotlin.g.b.p.g(str, LocaleUtil.ITALIAN);
                musicMvInfoUIC.aIr(str);
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/mv/ui/convert/MvItemConvert$initMvInfo$$inlined$let$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(257013);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/mv/ui/convert/MvItemConvert$initMvInfo$6$2"})
    static final class g implements View.OnClickListener {
        final /* synthetic */ c Asc;
        final /* synthetic */ b Asg;
        final /* synthetic */ MusicMvInfoUIC Ash;

        g(c cVar, b bVar, MusicMvInfoUIC musicMvInfoUIC) {
            this.Asc = cVar;
            this.Asg = bVar;
            this.Ash = musicMvInfoUIC;
        }

        public final void onClick(View view) {
            String str;
            AppMethodBeat.i(257014);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/mv/ui/convert/MvItemConvert$initMvInfo$$inlined$let$lambda$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            FinderContact finderContact = this.Asg.ArY.ApJ;
            if (!(finderContact == null || (str = finderContact.username) == null)) {
                MusicMvInfoUIC musicMvInfoUIC = this.Ash;
                kotlin.g.b.p.g(str, LocaleUtil.ITALIAN);
                musicMvInfoUIC.aIr(str);
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/mv/ui/convert/MvItemConvert$initMvInfo$$inlined$let$lambda$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(257014);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class l implements View.OnClickListener {
        final /* synthetic */ b Asf;
        final /* synthetic */ MusicMvInfoUIC Asj;

        l(MusicMvInfoUIC musicMvInfoUIC, b bVar) {
            this.Asj = musicMvInfoUIC;
            this.Asf = bVar;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(257020);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/mv/ui/convert/MvItemConvert$initMvInfo$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            this.Asj.f(this.Asf.ArY);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/mv/ui/convert/MvItemConvert$initMvInfo$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(257020);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class m implements View.OnClickListener {
        final /* synthetic */ c Asc;
        final /* synthetic */ b Asf;

        m(c cVar, b bVar) {
            this.Asc = cVar;
            this.Asf = bVar;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(257021);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/mv/ui/convert/MvItemConvert$initMvInfo$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
            ((MusicMvShareUIC) com.tencent.mm.ui.component.a.b(this.Asc.tUQ).get(MusicMvShareUIC.class)).i(this.Asf.ArY);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/mv/ui/convert/MvItemConvert$initMvInfo$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(257021);
        }
    }

    private final void c(com.tencent.mm.view.recyclerview.h hVar, b bVar) {
        AppMethodBeat.i(257034);
        TextView textView = (TextView) hVar.aus.findViewById(R.id.b8o);
        if (bVar.ArY.commentCount > 0) {
            kotlin.g.b.p.g(textView, "commentCntTv");
            y yVar = y.vXH;
            textView.setText(y.LT(bVar.ArY.commentCount));
            AppMethodBeat.o(257034);
            return;
        }
        kotlin.g.b.p.g(textView, "commentCntTv");
        textView.setText(this.tUQ.getResources().getString(R.string.cje));
        AppMethodBeat.o(257034);
    }

    @SuppressLint({"ResourceType"})
    private static void d(com.tencent.mm.view.recyclerview.h hVar, b bVar) {
        AppMethodBeat.i(257035);
        WeImageView weImageView = (WeImageView) hVar.aus.findViewById(R.id.dts);
        if (bVar.ArY.ApK) {
            weImageView.setImageResource(R.raw.icons_filled_like);
            View view = hVar.aus;
            kotlin.g.b.p.g(view, "holder.itemView");
            weImageView.setIconColor(view.getResources().getColor(R.color.Red));
        } else {
            weImageView.setImageResource(R.raw.icons_filled_like);
            View view2 = hVar.aus;
            kotlin.g.b.p.g(view2, "holder.itemView");
            weImageView.setIconColor(view2.getResources().getColor(R.color.am));
        }
        TextView textView = (TextView) hVar.aus.findViewById(R.id.eba);
        if (bVar.ArY.likeCount > 0) {
            kotlin.g.b.p.g(textView, "likeTv");
            y yVar = y.vXH;
            textView.setText(y.LT(bVar.ArY.likeCount));
        } else {
            kotlin.g.b.p.g(textView, "likeTv");
            View view3 = hVar.aus;
            kotlin.g.b.p.g(view3, "holder.itemView");
            textView.setText(view3.getResources().getString(R.string.f8m));
        }
        Log.i(TAG, "updateLikeStatus isLike:" + bVar.ArY.ApK + " likeCount:" + bVar.ArY.likeCount);
        AppMethodBeat.o(257035);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032,\u0010\u0004\u001a(\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00060\u0006 \u0007*\u0014\u0012\u000e\b\u0001\u0012\n \u0007*\u0004\u0018\u00010\u00060\u0006\u0018\u00010\u00050\u0005H\n¢\u0006\u0004\b\b\u0010\t"}, hxF = {"<anonymous>", "", "success", "", "<anonymous parameter 1>", "", "", "kotlin.jvm.PlatformType", "onImageDownload", "(Z[Ljava/lang/Object;)V"})
    static final class b implements com.tencent.mm.av.a.c.d {
        public static final b Asd = new b();

        static {
            AppMethodBeat.i(257009);
            AppMethodBeat.o(257009);
        }

        b() {
        }

        @Override // com.tencent.mm.av.a.c.d
        public final void a(boolean z, Object[] objArr) {
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00060\u0006H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "v", "Landroid/view/View;", "kotlin.jvm.PlatformType", "event", "Landroid/view/MotionEvent;", "onTouch"})
    static final class e implements View.OnTouchListener {
        final /* synthetic */ GestureDetector AoY;

        e(GestureDetector gestureDetector) {
            this.AoY = gestureDetector;
        }

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            AppMethodBeat.i(257012);
            GestureDetector gestureDetector = this.AoY;
            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(motionEvent);
            com.tencent.mm.hellhoundlib.a.a.a(gestureDetector, bl.axQ(), "com/tencent/mm/plugin/mv/ui/convert/MvItemConvert$initFullScreen$1", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
            boolean a2 = com.tencent.mm.hellhoundlib.a.a.a(gestureDetector, gestureDetector.onTouchEvent((MotionEvent) bl.pG(0)), "com/tencent/mm/plugin/mv/ui/convert/MvItemConvert$initFullScreen$1", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
            AppMethodBeat.o(257012);
            return a2;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0004\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0012H\u0003J\u0012\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\u0012\u0010\u0017\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\u0012\u0010\u0018\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0019"}, hxF = {"Lcom/tencent/mm/plugin/mv/ui/convert/MvItemConvert$ItemGestureListener;", "Landroid/view/GestureDetector$SimpleOnGestureListener;", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "Lcom/tencent/mm/plugin/mv/ui/convert/MvConvertData;", "position", "", "(Lcom/tencent/mm/plugin/mv/ui/convert/MvItemConvert;Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;Lcom/tencent/mm/plugin/mv/ui/convert/MvConvertData;I)V", "getHolder", "()Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "getItem", "()Lcom/tencent/mm/plugin/mv/ui/convert/MvConvertData;", "getPosition", "()I", "createLikeFloatIcon", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "fullScreenTapLayout", "Landroid/view/ViewGroup;", "onDoubleTap", "", "e", "Landroid/view/MotionEvent;", "onSingleTapConfirmed", "onSingleTapUp", "plugin-mv_release"})
    public final class a extends GestureDetector.SimpleOnGestureListener {
        private final b Asb;
        final /* synthetic */ c Asc;
        private final int position;
        private final com.tencent.mm.view.recyclerview.h tAm;

        public final boolean onContextClick(MotionEvent motionEvent) {
            AppMethodBeat.i(257008);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(motionEvent);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/mv/ui/convert/MvItemConvert$ItemGestureListener", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z", this, bVar.axR());
            boolean onContextClick = super.onContextClick(motionEvent);
            com.tencent.mm.hellhoundlib.a.a.a(onContextClick, this, "com/tencent/mm/plugin/mv/ui/convert/MvItemConvert$ItemGestureListener", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z");
            AppMethodBeat.o(257008);
            return onContextClick;
        }

        public final void onLongPress(MotionEvent motionEvent) {
            AppMethodBeat.i(257007);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(motionEvent);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/mv/ui/convert/MvItemConvert$ItemGestureListener", "android/view/GestureDetector$SimpleOnGestureListener", e.a.NAME, "(Landroid/view/MotionEvent;)V", this, bVar.axR());
            super.onLongPress(motionEvent);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/mv/ui/convert/MvItemConvert$ItemGestureListener", "android/view/GestureDetector$SimpleOnGestureListener", e.a.NAME, "(Landroid/view/MotionEvent;)V");
            AppMethodBeat.o(257007);
        }

        public a(c cVar, com.tencent.mm.view.recyclerview.h hVar, b bVar, int i2) {
            kotlin.g.b.p.h(hVar, "holder");
            kotlin.g.b.p.h(bVar, "item");
            this.Asc = cVar;
            AppMethodBeat.i(257006);
            this.tAm = hVar;
            this.Asb = bVar;
            this.position = i2;
            AppMethodBeat.o(257006);
        }

        public final boolean onSingleTapUp(MotionEvent motionEvent) {
            AppMethodBeat.i(257003);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(motionEvent);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/mv/ui/convert/MvItemConvert$ItemGestureListener", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, bVar.axR());
            com.tencent.mm.hellhoundlib.a.a.a(false, (Object) this, "com/tencent/mm/plugin/mv/ui/convert/MvItemConvert$ItemGestureListener", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
            AppMethodBeat.o(257003);
            return false;
        }

        public final boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            boolean z;
            AppMethodBeat.i(257004);
            s sVar = c.UZQ;
            Log.i(c.TAG, "onSingleTapConfirmed");
            e.a aVar = com.tencent.mm.plugin.mv.a.e.ApR;
            if (e.a.b(this.Asb.ArY)) {
                com.tencent.mm.plugin.mv.a.e eVar = this.Asb.ArY;
                if (!this.Asb.ArY.onr) {
                    z = true;
                } else {
                    z = false;
                }
                eVar.onr = z;
                c.b(this.tAm, this.Asb);
                this.Asc.a(this.tAm, this.Asb);
            }
            AppMethodBeat.o(257004);
            return false;
        }

        public final boolean onDoubleTap(MotionEvent motionEvent) {
            AppMethodBeat.i(257005);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(motionEvent);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/mv/ui/convert/MvItemConvert$ItemGestureListener", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z", this, bVar.axR());
            s sVar = c.UZQ;
            Log.i(c.TAG, "onDoubleTap");
            e.a aVar = com.tencent.mm.plugin.mv.a.e.ApR;
            if (e.a.b(this.Asb.ArY)) {
                ViewGroup viewGroup = (ViewGroup) this.tAm.aus.findViewById(R.id.dcc);
                com.tencent.mm.view.recyclerview.h hVar = this.tAm;
                kotlin.g.b.p.g(viewGroup, "fullScreenTapLayout");
                WeImageView weImageView = new WeImageView(hVar.getContext());
                weImageView.setVisibility(4);
                Context context = hVar.getContext();
                kotlin.g.b.p.g(context, "holder.context");
                int dimension = (int) context.getResources().getDimension(R.dimen.co);
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(dimension, dimension);
                layoutParams.gravity = 17;
                weImageView.setLayoutParams(layoutParams);
                weImageView.setImageResource(R.raw.finder_full_like);
                Context context2 = hVar.getContext();
                kotlin.g.b.p.g(context2, "holder.context");
                weImageView.setIconColor(context2.getResources().getColor(R.color.Red_90));
                viewGroup.addView(weImageView);
                com.tencent.mm.plugin.finder.view.animation.c cVar = com.tencent.mm.plugin.finder.view.animation.c.wrB;
                com.tencent.mm.plugin.finder.view.animation.c.a((View) weImageView, 1.4f, motionEvent, true, viewGroup.getY());
                if (!this.Asb.ArY.ApK) {
                    c.a(this.Asc, this.tAm, this.Asb);
                    c.e(this.tAm, this.Asb);
                }
            }
            com.tencent.mm.hellhoundlib.a.a.a(false, (Object) this, "com/tencent/mm/plugin/mv/ui/convert/MvItemConvert$ItemGestureListener", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z");
            AppMethodBeat.o(257005);
            return false;
        }
    }

    public static void b(com.tencent.mm.view.recyclerview.h hVar, b bVar) {
        AppMethodBeat.i(257033);
        kotlin.g.b.p.h(hVar, "holder");
        kotlin.g.b.p.h(bVar, "item");
        if (!bVar.ArY.onr) {
            switch (bVar.ArY.ApM) {
                case 1:
                    View findViewById = hVar.aus.findViewById(R.id.epl);
                    if (findViewById != null) {
                        findViewById.setVisibility(8);
                    }
                    View findViewById2 = hVar.aus.findViewById(R.id.eph);
                    if (findViewById2 != null) {
                        findViewById2.setVisibility(8);
                        AppMethodBeat.o(257033);
                        return;
                    }
                    AppMethodBeat.o(257033);
                    return;
                case 2:
                    View findViewById3 = hVar.aus.findViewById(R.id.epl);
                    if (findViewById3 != null) {
                        findViewById3.setVisibility(0);
                    }
                    View findViewById4 = hVar.aus.findViewById(R.id.eph);
                    if (findViewById4 != null) {
                        findViewById4.setVisibility(8);
                        AppMethodBeat.o(257033);
                        return;
                    }
                    AppMethodBeat.o(257033);
                    return;
                case 3:
                    View findViewById5 = hVar.aus.findViewById(R.id.epl);
                    if (findViewById5 != null) {
                        findViewById5.setVisibility(0);
                    }
                    View findViewById6 = hVar.aus.findViewById(R.id.eph);
                    if (findViewById6 != null) {
                        findViewById6.setVisibility(0);
                        AppMethodBeat.o(257033);
                        return;
                    }
                    AppMethodBeat.o(257033);
                    return;
                case 4:
                    View findViewById7 = hVar.aus.findViewById(R.id.epl);
                    if (findViewById7 != null) {
                        findViewById7.setVisibility(8);
                    }
                    View findViewById8 = hVar.aus.findViewById(R.id.eph);
                    if (findViewById8 != null) {
                        findViewById8.setVisibility(8);
                        AppMethodBeat.o(257033);
                        return;
                    }
                    AppMethodBeat.o(257033);
                    return;
                default:
                    AppMethodBeat.o(257033);
                    return;
            }
        } else {
            View findViewById9 = hVar.aus.findViewById(R.id.epl);
            if (findViewById9 != null) {
                findViewById9.setVisibility(8);
            }
            View findViewById10 = hVar.aus.findViewById(R.id.eph);
            if (findViewById10 != null) {
                findViewById10.setVisibility(8);
                AppMethodBeat.o(257033);
                return;
            }
            AppMethodBeat.o(257033);
        }
    }

    public static final /* synthetic */ void a(c cVar, com.tencent.mm.view.recyclerview.h hVar, b bVar) {
        Long l2;
        String str;
        boolean z = false;
        int i2 = 1;
        AppMethodBeat.i(257037);
        com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
        ViewModel viewModel = com.tencent.mm.ui.component.a.b(cVar.tUQ).get(MusicMvDataUIC.class);
        kotlin.g.b.p.g(viewModel, "UICProvider.of(activity)…sicMvDataUIC::class.java)");
        MusicMvDataUIC musicMvDataUIC = (MusicMvDataUIC) viewModel;
        Log.i(TAG, "likeMvClick " + bVar.ArY.ApE + ' ' + bVar.ArY.ApF + ' ' + bVar.ArY.ApM);
        if (bVar.ArY.ApM == 1) {
            com.tencent.mm.plugin.mv.a.e eVar = bVar.ArY;
            if (!bVar.ArY.ApK) {
                z = true;
            }
            eVar.ApK = z;
            if (bVar.ArY.ApK) {
                bVar.ArY.likeCount++;
            } else {
                com.tencent.mm.plugin.mv.a.e eVar2 = bVar.ArY;
                eVar2.likeCount--;
            }
            d(hVar, bVar);
            Long l3 = bVar.ArY.ApE;
            String str2 = bVar.ArY.ApF;
            if (!(l3 == null || str2 == null)) {
                long longValue = l3.longValue();
                com.tencent.mm.plugin.mv.a.k kVar = com.tencent.mm.plugin.mv.a.k.Aql;
                AppCompatActivity appCompatActivity = cVar.tUQ;
                axy axy = musicMvDataUIC.Aqo;
                com.tencent.mm.plugin.mv.a.e eVar3 = bVar.ArY;
                if (!bVar.ArY.ApK) {
                    i2 = 2;
                }
                com.tencent.mm.plugin.mv.a.k.a(appCompatActivity, axy, eVar3, i2);
                com.tencent.mm.kernel.g.azz().b(new com.tencent.mm.plugin.mv.a.a.b(longValue, str2, bVar.ArY.ApK));
                AppMethodBeat.o(257037);
                return;
            }
        } else if (bVar.ArY.ApM == 4) {
            com.tencent.mm.plugin.mv.a.e eVar4 = bVar.ArY;
            if (!bVar.ArY.ApK) {
                z = true;
            }
            eVar4.ApK = z;
            if (bVar.ArY.ApK) {
                bVar.ArY.likeCount++;
            } else {
                com.tencent.mm.plugin.mv.a.e eVar5 = bVar.ArY;
                eVar5.likeCount--;
            }
            d(hVar, bVar);
            FinderObject finderObject = bVar.ArY.ApP;
            if (finderObject != null) {
                l2 = Long.valueOf(finderObject.id);
            } else {
                l2 = null;
            }
            FinderObject finderObject2 = bVar.ArY.ApP;
            if (finderObject2 != null) {
                str = finderObject2.objectNonceId;
            } else {
                str = null;
            }
            if (!(l2 == null || str == null)) {
                com.tencent.mm.kernel.g.azz().b(new com.tencent.mm.plugin.mv.a.a.b(l2.longValue(), str, bVar.ArY.ApK));
                com.tencent.mm.plugin.mv.a.k kVar2 = com.tencent.mm.plugin.mv.a.k.Aql;
                AppCompatActivity appCompatActivity2 = cVar.tUQ;
                axy axy2 = musicMvDataUIC.Aqo;
                com.tencent.mm.plugin.mv.a.e eVar6 = bVar.ArY;
                if (!bVar.ArY.ApK) {
                    i2 = 2;
                }
                com.tencent.mm.plugin.mv.a.k.a(appCompatActivity2, axy2, eVar6, i2);
            }
        }
        AppMethodBeat.o(257037);
    }
}

package com.tencent.mm.plugin.mv.ui.uic;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.mv.a.d;
import com.tencent.mm.plugin.mv.ui.b.b;
import com.tencent.mm.plugin.mv.ui.view.MusicMvSliderSeekBar;
import com.tencent.mm.plugin.thumbplayer.e.b;
import com.tencent.mm.plugin.thumbplayer.view.MMTPRecyclerVideoLayout;
import com.tencent.mm.plugin.vlog.model.ad;
import com.tencent.mm.plugin.vlog.ui.thumb.FrameListView;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.widget.RoundedCornerFrameLayout;
import com.tencent.mm.videocomposition.c;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import java.util.ArrayList;
import java.util.List;
import kotlin.x;

@kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000º\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007*\u00029<\u0018\u0000 g2\u00020\u0001:\u0004ghijB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010T\u001a\u0004\u0018\u00010\fJ\b\u0010U\u001a\u00020&H\u0016J\u0012\u0010V\u001a\u00020W2\b\u0010X\u001a\u0004\u0018\u00010YH\u0016J\b\u0010Z\u001a\u00020WH\u0016J\b\u0010[\u001a\u00020WH\u0002J\u000e\u0010\\\u001a\u00020W2\u0006\u0010]\u001a\u00020&J\u000e\u0010^\u001a\u00020W2\u0006\u0010_\u001a\u00020\u0010J\u0018\u0010`\u001a\u00020W2\u0006\u0010a\u001a\u00020b2\u0006\u0010F\u001a\u00020-H\u0002J\u0018\u0010c\u001a\u00020W2\u0006\u0010a\u001a\u00020d2\u0006\u0010F\u001a\u00020-H\u0002J\b\u0010e\u001a\u00020WH\u0002J\b\u0010f\u001a\u00020WH\u0002R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u001f\u0010\u0013\u001a\u00060\u0014R\u00020\u00008BX\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0015\u0010\u0016R#\u0010\u0019\u001a\n \u001b*\u0004\u0018\u00010\u001a0\u001a8BX\u0002¢\u0006\f\n\u0004\b\u001e\u0010\u0018\u001a\u0004\b\u001c\u0010\u001dR\u000e\u0010\u001f\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R#\u0010 \u001a\n \u001b*\u0004\u0018\u00010!0!8BX\u0002¢\u0006\f\n\u0004\b$\u0010\u0018\u001a\u0004\b\"\u0010#R\u000e\u0010%\u001a\u00020&X\u000e¢\u0006\u0002\n\u0000R#\u0010'\u001a\n \u001b*\u0004\u0018\u00010(0(8BX\u0002¢\u0006\f\n\u0004\b+\u0010\u0018\u001a\u0004\b)\u0010*R\u000e\u0010,\u001a\u00020-X\u000e¢\u0006\u0002\n\u0000R\u001b\u0010.\u001a\u00020/8BX\u0002¢\u0006\f\n\u0004\b2\u0010\u0018\u001a\u0004\b0\u00101R#\u00103\u001a\n \u001b*\u0004\u0018\u000104048BX\u0002¢\u0006\f\n\u0004\b7\u0010\u0018\u001a\u0004\b5\u00106R\u0010\u00108\u001a\u000209X\u0004¢\u0006\u0004\n\u0002\u0010:R\u0010\u0010;\u001a\u00020<X\u0004¢\u0006\u0004\n\u0002\u0010=R#\u0010>\u001a\n \u001b*\u0004\u0018\u00010?0?8BX\u0002¢\u0006\f\n\u0004\bB\u0010\u0018\u001a\u0004\b@\u0010AR\u000e\u0010C\u001a\u00020DX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010E\u001a\u00020-X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010F\u001a\u00020-X\u000e¢\u0006\u0002\n\u0000R#\u0010G\u001a\n \u001b*\u0004\u0018\u00010H0H8BX\u0002¢\u0006\f\n\u0004\bK\u0010\u0018\u001a\u0004\bI\u0010JR\u000e\u0010L\u001a\u00020-X\u000e¢\u0006\u0002\n\u0000R#\u0010M\u001a\n \u001b*\u0004\u0018\u00010N0N8BX\u0002¢\u0006\f\n\u0004\bQ\u0010\u0018\u001a\u0004\bO\u0010PR\u0010\u0010R\u001a\u0004\u0018\u00010SX\u000e¢\u0006\u0002\n\u0000¨\u0006k"}, hxF = {"Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvMakerItemEditUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", EnvConsts.ACTIVITY_MANAGER_SRVNAME, "Landroid/support/v7/app/AppCompatActivity;", "(Landroid/support/v7/app/AppCompatActivity;)V", "actionCallback", "Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvMakerItemEditUIC$MVItemEditActionCallback;", "getActionCallback", "()Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvMakerItemEditUIC$MVItemEditActionCallback;", "setActionCallback", "(Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvMakerItemEditUIC$MVItemEditActionCallback;)V", "backFirstFrame", "Landroid/graphics/Bitmap;", "backFirstRenderTime", "", "dataItem", "Lcom/tencent/mm/plugin/mv/model/MusicMVVideoConvertData;", "firstRenderFrame", "firstRenderTime", "frameAdapter", "Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvMakerItemEditUIC$ThumbAdapter;", "getFrameAdapter", "()Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvMakerItemEditUIC$ThumbAdapter;", "frameAdapter$delegate", "Lkotlin/Lazy;", "frameRv", "Landroid/support/v7/widget/RecyclerView;", "kotlin.jvm.PlatformType", "getFrameRv", "()Landroid/support/v7/widget/RecyclerView;", "frameRv$delegate", "frameViewHeight", "hintView", "Landroid/widget/TextView;", "getHintView", "()Landroid/widget/TextView;", "hintView$delegate", "isScrollEdit", "", "itemEditRoot", "Landroid/widget/LinearLayout;", "getItemEditRoot", "()Landroid/widget/LinearLayout;", "itemEditRoot$delegate", "itemEditStartTimeMs", "", "layoutManager", "Landroid/support/v7/widget/LinearLayoutManager;", "getLayoutManager", "()Landroid/support/v7/widget/LinearLayoutManager;", "layoutManager$delegate", "previewContainer", "Lcom/tencent/mm/ui/widget/RoundedCornerFrameLayout;", "getPreviewContainer", "()Lcom/tencent/mm/ui/widget/RoundedCornerFrameLayout;", "previewContainer$delegate", "progressListener", "com/tencent/mm/plugin/mv/ui/uic/MusicMvMakerItemEditUIC$progressListener$1", "Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvMakerItemEditUIC$progressListener$1;", "scrollListener", "com/tencent/mm/plugin/mv/ui/uic/MusicMvMakerItemEditUIC$scrollListener$1", "Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvMakerItemEditUIC$scrollListener$1;", "seekBar", "Lcom/tencent/mm/plugin/mv/ui/view/MusicMvSliderSeekBar;", "getSeekBar", "()Lcom/tencent/mm/plugin/mv/ui/view/MusicMvSliderSeekBar;", "seekBar$delegate", "sizePerTime", "", "startMs", "targetDuration", "thumbView", "Landroid/widget/ImageView;", "getThumbView", "()Landroid/widget/ImageView;", "thumbView$delegate", "totalDuration", "videoContainer", "Landroid/widget/FrameLayout;", "getVideoContainer", "()Landroid/widget/FrameLayout;", "videoContainer$delegate", "videoLayout", "Lcom/tencent/mm/plugin/thumbplayer/view/MMTPRecyclerVideoLayout;", "getFirstRenderFrame", "onBackPressed", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "releaseFrameList", "setShow", "show", "setVideoData", "item", "setupLocalVideoThumb", "videoData", "Lcom/tencent/mm/plugin/mv/model/MusicMVVideoConvertData$LocalVideoData;", "setupOnlineVideoThumb", "Lcom/tencent/mm/plugin/mv/model/MusicMVVideoConvertData$FinderVideoData;", "tryCatchFirstFrame", "updateFrameView", "Companion", "MVItemEditActionCallback", "ThumbAdapter", "ThumbViewHolder", "plugin-mv_release"})
public final class MusicMvMakerItemEditUIC extends UIComponent {
    public static final a Avm = new a((byte) 0);
    private MMTPRecyclerVideoLayout AuG;
    private final kotlin.f AuY;
    private final kotlin.f AuZ;
    private final kotlin.f Ava;
    private final kotlin.f Avb;
    private final kotlin.f Avc;
    private final kotlin.f Avd = kotlin.g.ah(new e(this));
    private long Ave;
    private float Avf;
    private com.tencent.mm.plugin.mv.a.d Avg;
    private final int Avh;
    private long Avi;
    private final m Avj;
    private final n Avk;
    public b Avl;
    private int Vai;
    Bitmap Vaj;
    private int Vak;
    private Bitmap Val;
    private boolean Vam;
    private long eiq;
    private long targetDuration;
    private final kotlin.f vMb;
    private final kotlin.f vat;
    private final kotlin.f wfk;

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvMakerItemEditUIC$MVItemEditActionCallback;", "", "onCancel", "", "isScrollEdit", "", "onConfirm", "plugin-mv_release"})
    public interface b {
        void FD(boolean z);

        void FE(boolean z);
    }

    static {
        AppMethodBeat.i(257301);
        AppMethodBeat.o(257301);
    }

    private final LinearLayout ewa() {
        AppMethodBeat.i(257287);
        LinearLayout linearLayout = (LinearLayout) this.AuY.getValue();
        AppMethodBeat.o(257287);
        return linearLayout;
    }

    private final TextView ewb() {
        AppMethodBeat.i(257289);
        TextView textView = (TextView) this.Avb.getValue();
        AppMethodBeat.o(257289);
        return textView;
    }

    private final RecyclerView ewc() {
        AppMethodBeat.i(257290);
        RecyclerView recyclerView = (RecyclerView) this.Avc.getValue();
        AppMethodBeat.o(257290);
        return recyclerView;
    }

    private final c ewd() {
        AppMethodBeat.i(257292);
        c cVar = (c) this.Avd.getValue();
        AppMethodBeat.o(257292);
        return cVar;
    }

    private final MusicMvSliderSeekBar ewe() {
        AppMethodBeat.i(257293);
        MusicMvSliderSeekBar musicMvSliderSeekBar = (MusicMvSliderSeekBar) this.vMb.getValue();
        AppMethodBeat.o(257293);
        return musicMvSliderSeekBar;
    }

    private final LinearLayoutManager getLayoutManager() {
        AppMethodBeat.i(257291);
        LinearLayoutManager linearLayoutManager = (LinearLayoutManager) this.vat.getValue();
        AppMethodBeat.o(257291);
        return linearLayoutManager;
    }

    private final ImageView getThumbView() {
        AppMethodBeat.i(257288);
        ImageView imageView = (ImageView) this.wfk.getValue();
        AppMethodBeat.o(257288);
        return imageView;
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004¨\u0006\u0005"}, hxF = {"<anonymous>", "", "snapshot", "Landroid/graphics/Bitmap;", "invoke", "com/tencent/mm/plugin/mv/ui/uic/MusicMvMakerItemEditUIC$tryCatchFirstFrame$1$1"})
    public static final class v extends kotlin.g.b.q implements kotlin.g.a.b<Bitmap, x> {
        final /* synthetic */ MusicMvMakerItemEditUIC Avp;
        final /* synthetic */ int Van;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        v(int i2, MusicMvMakerItemEditUIC musicMvMakerItemEditUIC) {
            super(1);
            this.Van = i2;
            this.Avp = musicMvMakerItemEditUIC;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(Bitmap bitmap) {
            AppMethodBeat.i(259269);
            Bitmap bitmap2 = bitmap;
            Log.i("MicroMsg.Mv.MusicMvMakerItemEditUIC", "tryCatchFirstFrame, timeInMv:" + this.Van + ", thumb:" + bitmap2);
            this.Avp.Vaj = bitmap2;
            this.Avp.Vai = this.Van;
            x xVar = x.SXb;
            AppMethodBeat.o(259269);
            return xVar;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MusicMvMakerItemEditUIC(AppCompatActivity appCompatActivity) {
        super(appCompatActivity);
        kotlin.g.b.p.h(appCompatActivity, EnvConsts.ACTIVITY_MANAGER_SRVNAME);
        AppMethodBeat.i(257300);
        this.AuY = kotlin.g.ah(new h(appCompatActivity));
        this.AuZ = kotlin.g.ah(new l(appCompatActivity));
        this.Ava = kotlin.g.ah(new u(appCompatActivity));
        this.wfk = kotlin.g.ah(new t(appCompatActivity));
        this.Avb = kotlin.g.ah(new g(appCompatActivity));
        this.Avc = kotlin.g.ah(new f(appCompatActivity));
        this.vat = kotlin.g.ah(new i(appCompatActivity));
        this.vMb = kotlin.g.ah(new o(appCompatActivity));
        this.Vai = Integer.MAX_VALUE;
        this.Vak = Integer.MAX_VALUE;
        this.Avh = com.tencent.mm.cb.a.fromDPToPix((Context) appCompatActivity, 48);
        this.Avi = -1;
        this.Avj = new m(this);
        this.Avk = new n(this);
        AppMethodBeat.o(257300);
    }

    public static final /* synthetic */ LinearLayout e(MusicMvMakerItemEditUIC musicMvMakerItemEditUIC) {
        AppMethodBeat.i(257303);
        LinearLayout ewa = musicMvMakerItemEditUIC.ewa();
        AppMethodBeat.o(257303);
        return ewa;
    }

    public static final /* synthetic */ void f(MusicMvMakerItemEditUIC musicMvMakerItemEditUIC) {
        AppMethodBeat.i(257304);
        musicMvMakerItemEditUIC.ewf();
        AppMethodBeat.o(257304);
    }

    public static final /* synthetic */ RecyclerView g(MusicMvMakerItemEditUIC musicMvMakerItemEditUIC) {
        AppMethodBeat.i(257305);
        RecyclerView ewc = musicMvMakerItemEditUIC.ewc();
        AppMethodBeat.o(257305);
        return ewc;
    }

    public static final /* synthetic */ LinearLayoutManager j(MusicMvMakerItemEditUIC musicMvMakerItemEditUIC) {
        AppMethodBeat.i(257306);
        LinearLayoutManager layoutManager = musicMvMakerItemEditUIC.getLayoutManager();
        AppMethodBeat.o(257306);
        return layoutManager;
    }

    public static final /* synthetic */ MusicMvSliderSeekBar l(MusicMvMakerItemEditUIC musicMvMakerItemEditUIC) {
        AppMethodBeat.i(257309);
        MusicMvSliderSeekBar ewe = musicMvMakerItemEditUIC.ewe();
        AppMethodBeat.o(257309);
        return ewe;
    }

    public static final /* synthetic */ ImageView m(MusicMvMakerItemEditUIC musicMvMakerItemEditUIC) {
        AppMethodBeat.i(257310);
        ImageView thumbView = musicMvMakerItemEditUIC.getThumbView();
        AppMethodBeat.o(257310);
        return thumbView;
    }

    public static final /* synthetic */ void w(MusicMvMakerItemEditUIC musicMvMakerItemEditUIC) {
        AppMethodBeat.i(259272);
        musicMvMakerItemEditUIC.hWI();
        AppMethodBeat.o(259272);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\b"}, hxF = {"Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvMakerItemEditUIC$Companion;", "", "()V", "TAG", "", "ThumbHeight", "", "ThumbWidth", "plugin-mv_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\u0003H\u0016J\u0006\u0010\t\u001a\u00020\u0005R\u000e\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000¨\u0006\n"}, hxF = {"com/tencent/mm/plugin/mv/ui/uic/MusicMvMakerItemEditUIC$progressListener$1", "Lcom/tencent/mm/plugin/thumbplayer/view/OnPlayerProgressListener;", "lastPlayPosition", "", "onProgress", "", "media", "Lcom/tencent/mm/plugin/thumbplayer/model/TPMediaInfo;", "timeMs", "reset", "plugin-mv_release"})
    public static final class m implements com.tencent.mm.plugin.thumbplayer.view.e {
        final /* synthetic */ MusicMvMakerItemEditUIC Avp;
        long Avr;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        m(MusicMvMakerItemEditUIC musicMvMakerItemEditUIC) {
            this.Avp = musicMvMakerItemEditUIC;
        }

        @Override // com.tencent.mm.plugin.thumbplayer.view.e
        public final void Hv(long j2) {
            AppMethodBeat.i(257275);
            com.tencent.mm.ac.d.h(new a(this, j2));
            AppMethodBeat.o(257275);
        }

        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
        static final class a extends kotlin.g.b.q implements kotlin.g.a.a<x> {
            final /* synthetic */ m Avs;
            final /* synthetic */ long wfK;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(m mVar, long j2) {
                super(0);
                this.Avs = mVar;
                this.wfK = j2;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ x invoke() {
                AppMethodBeat.i(257274);
                RecyclerView g2 = MusicMvMakerItemEditUIC.g(this.Avs.Avp);
                kotlin.g.b.p.g(g2, "frameRv");
                if (g2.getChildCount() > 0) {
                    View childAt = MusicMvMakerItemEditUIC.g(this.Avs.Avp).getChildAt(0);
                    kotlin.g.b.p.g(childAt, "childView");
                    float f2 = ((float) (-childAt.getLeft())) / this.Avs.Avp.Avf;
                    RecyclerView g3 = MusicMvMakerItemEditUIC.g(this.Avs.Avp);
                    kotlin.g.b.p.g(g3, "frameRv");
                    float width = ((float) (g3.getWidth() - childAt.getLeft())) / this.Avs.Avp.Avf;
                    MusicMvMakerItemEditUIC.l(this.Avs.Avp).setCursorPos(((((float) this.wfK) - f2) * 1.0f) / (width - f2));
                    if (this.Avs.Avr > this.wfK) {
                        Log.d("MicroMsg.Mv.MusicMvMakerItemEditUIC", "lastPlayPosition:" + this.Avs.Avr + ", timeMs:" + this.wfK + ", loop");
                        com.tencent.mm.plugin.mv.a.d dVar = this.Avs.Avp.Avg;
                        if (dVar != null) {
                            com.tencent.mm.plugin.music.e.k euj = com.tencent.mm.plugin.music.e.k.euj();
                            kotlin.g.b.p.g(euj, "MusicPlayerManager.Instance()");
                            euj.etW().tG(dVar.Apl);
                        }
                    }
                    this.Avs.Avr = this.wfK;
                }
                x xVar = x.SXb;
                AppMethodBeat.o(257274);
                return xVar;
            }
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J \u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0007H\u0016¨\u0006\u000b"}, hxF = {"com/tencent/mm/plugin/mv/ui/uic/MusicMvMakerItemEditUIC$scrollListener$1", "Landroid/support/v7/widget/RecyclerView$OnScrollListener;", "onScrollStateChanged", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "newState", "", "onScrolled", "dx", "dy", "plugin-mv_release"})
    public static final class n extends RecyclerView.l {
        final /* synthetic */ MusicMvMakerItemEditUIC Avp;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        n(MusicMvMakerItemEditUIC musicMvMakerItemEditUIC) {
            this.Avp = musicMvMakerItemEditUIC;
        }

        @Override // android.support.v7.widget.RecyclerView.l
        public final void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            com.tencent.mm.plugin.thumbplayer.e.b player;
            com.tencent.mm.plugin.thumbplayer.e.b player2;
            AppMethodBeat.i(257276);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(recyclerView);
            bVar.pH(i2);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/mv/ui/uic/MusicMvMakerItemEditUIC$scrollListener$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, bVar.axR());
            kotlin.g.b.p.h(recyclerView, "recyclerView");
            super.onScrollStateChanged(recyclerView, i2);
            if (i2 == 0) {
                RecyclerView g2 = MusicMvMakerItemEditUIC.g(this.Avp);
                kotlin.g.b.p.g(g2, "frameRv");
                if (g2.getChildCount() <= 0) {
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/mv/ui/uic/MusicMvMakerItemEditUIC$scrollListener$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
                    AppMethodBeat.o(257276);
                    return;
                }
                View childAt = MusicMvMakerItemEditUIC.g(this.Avp).getChildAt(0);
                RecyclerView g3 = MusicMvMakerItemEditUIC.g(this.Avp);
                kotlin.g.b.p.g(g3, "frameRv");
                int paddingStart = g3.getPaddingStart();
                kotlin.g.b.p.g(childAt, "childView");
                long left = (long) (((float) (paddingStart - childAt.getLeft())) / this.Avp.Avf);
                MMTPRecyclerVideoLayout mMTPRecyclerVideoLayout = this.Avp.AuG;
                if (!(mMTPRecyclerVideoLayout == null || (player2 = mMTPRecyclerVideoLayout.getPlayer()) == null)) {
                    player2.at(left, this.Avp.targetDuration + left);
                }
                MMTPRecyclerVideoLayout mMTPRecyclerVideoLayout2 = this.Avp.AuG;
                if (!(mMTPRecyclerVideoLayout2 == null || (player = mMTPRecyclerVideoLayout2.getPlayer()) == null)) {
                    player.YX((int) left);
                }
                MusicMvMakerItemEditUIC.w(this.Avp);
                com.tencent.mm.plugin.mv.a.d dVar = this.Avp.Avg;
                if (dVar != null) {
                    this.Avp.Avj.Avr = 0;
                    com.tencent.mm.plugin.music.e.k euj = com.tencent.mm.plugin.music.e.k.euj();
                    kotlin.g.b.p.g(euj, "MusicPlayerManager.Instance()");
                    euj.etW().tG(dVar.Apl);
                }
                this.Avp.Vam = true;
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/mv/ui/uic/MusicMvMakerItemEditUIC$scrollListener$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
            AppMethodBeat.o(257276);
        }

        @Override // android.support.v7.widget.RecyclerView.l
        public final void onScrolled(RecyclerView recyclerView, int i2, int i3) {
            AppMethodBeat.i(257277);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(recyclerView);
            bVar.pH(i2);
            bVar.pH(i3);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/mv/ui/uic/MusicMvMakerItemEditUIC$scrollListener$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, bVar.axR());
            kotlin.g.b.p.h(recyclerView, "recyclerView");
            super.onScrolled(recyclerView, i2, i3);
            RecyclerView g2 = MusicMvMakerItemEditUIC.g(this.Avp);
            kotlin.g.b.p.g(g2, "frameRv");
            if (g2.getChildCount() <= 0) {
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/mv/ui/uic/MusicMvMakerItemEditUIC$scrollListener$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
                AppMethodBeat.o(257277);
                return;
            }
            View childAt = MusicMvMakerItemEditUIC.g(this.Avp).getChildAt(0);
            RecyclerView g3 = MusicMvMakerItemEditUIC.g(this.Avp);
            kotlin.g.b.p.g(g3, "frameRv");
            int paddingStart = g3.getPaddingStart();
            kotlin.g.b.p.g(childAt, "childView");
            this.Avp.Avi = (long) (((float) (paddingStart - childAt.getLeft())) / this.Avp.Avf);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/mv/ui/uic/MusicMvMakerItemEditUIC$scrollListener$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
            AppMethodBeat.o(257277);
        }
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onCreate(Bundle bundle) {
        AppMethodBeat.i(257294);
        super.onCreate(bundle);
        ewe().setCursorColor(-1);
        ewe().setCursorWidth(com.tencent.mm.cb.a.fromDPToPix((Context) getActivity(), 2));
        ((Button) getActivity().findViewById(R.id.fr_)).setOnClickListener(new j(this));
        ((Button) getActivity().findViewById(R.id.fra)).setOnClickListener(new k(this));
        LinearLayout ewa = ewa();
        kotlin.g.b.p.g(ewa, "itemEditRoot");
        ewa.setAlpha(0.0f);
        RecyclerView ewc = ewc();
        kotlin.g.b.p.g(ewc, "frameRv");
        ewc.setAdapter(ewd());
        RecyclerView ewc2 = ewc();
        kotlin.g.b.p.g(ewc2, "frameRv");
        ewc2.setLayoutManager(getLayoutManager());
        ewc().a(this.Avk);
        this.AuG = new MMTPRecyclerVideoLayout((Context) getActivity(), false);
        MMTPRecyclerVideoLayout mMTPRecyclerVideoLayout = this.AuG;
        if (mMTPRecyclerVideoLayout != null) {
            mMTPRecyclerVideoLayout.fxf();
        }
        MMTPRecyclerVideoLayout mMTPRecyclerVideoLayout2 = this.AuG;
        if (mMTPRecyclerVideoLayout2 != null) {
            mMTPRecyclerVideoLayout2.setKeepScreenOn(true);
        }
        MMTPRecyclerVideoLayout mMTPRecyclerVideoLayout3 = this.AuG;
        if (mMTPRecyclerVideoLayout3 != null) {
            mMTPRecyclerVideoLayout3.setId(R.id.fqq);
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        ((FrameLayout) this.Ava.getValue()).addView(this.AuG, layoutParams);
        AppMethodBeat.o(257294);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class j implements View.OnClickListener {
        final /* synthetic */ MusicMvMakerItemEditUIC Avp;

        j(MusicMvMakerItemEditUIC musicMvMakerItemEditUIC) {
            this.Avp = musicMvMakerItemEditUIC;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(257271);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/mv/ui/uic/MusicMvMakerItemEditUIC$onCreate$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            Log.i("MicroMsg.Mv.MusicMvMakerItemEditUIC", "onCancel, firstRenderTime:" + this.Avp.Vai + ", firstRenderFrame:" + this.Avp.Vaj + ", backFirstRenderTime:" + this.Avp.Vak + ", backFirstFrame:" + this.Avp.Val);
            this.Avp.Vaj = this.Avp.Val;
            this.Avp.Vai = this.Avp.Vak;
            b bVar2 = this.Avp.Avl;
            if (bVar2 != null) {
                bVar2.FE(this.Avp.Vam);
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/mv/ui/uic/MusicMvMakerItemEditUIC$onCreate$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(257271);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class k implements View.OnClickListener {
        final /* synthetic */ MusicMvMakerItemEditUIC Avp;

        k(MusicMvMakerItemEditUIC musicMvMakerItemEditUIC) {
            this.Avp = musicMvMakerItemEditUIC;
        }

        public final void onClick(View view) {
            com.tencent.mm.plugin.mv.a.d dVar;
            d.h hVar;
            AppMethodBeat.i(257272);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/mv/ui/uic/MusicMvMakerItemEditUIC$onCreate$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            if (this.Avp.Avi >= 0 && this.Avp.Avi + this.Avp.targetDuration <= this.Avp.Ave && (dVar = this.Avp.Avg) != null && (hVar = dVar.App) != null) {
                hVar.Hr(this.Avp.Avi);
            }
            b bVar2 = this.Avp.Avl;
            if (bVar2 != null) {
                bVar2.FD(this.Avp.Vam);
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/mv/ui/uic/MusicMvMakerItemEditUIC$onCreate$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(257272);
        }
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final boolean onBackPressed() {
        AppMethodBeat.i(257295);
        LinearLayout ewa = ewa();
        kotlin.g.b.p.g(ewa, "itemEditRoot");
        if (ewa.getVisibility() == 0) {
            b bVar = this.Avl;
            if (bVar != null) {
                bVar.FE(this.Vam);
            }
            AppMethodBeat.o(257295);
            return true;
        }
        boolean onBackPressed = super.onBackPressed();
        AppMethodBeat.o(257295);
        return onBackPressed;
    }

    public final void setShow(boolean z) {
        com.tencent.mm.plugin.thumbplayer.e.b player;
        AppMethodBeat.i(257296);
        Log.i("MicroMsg.Mv.MusicMvMakerItemEditUIC", "setShow:".concat(String.valueOf(z)));
        if (z) {
            getThumbView().setImageDrawable(null);
            com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
            ((MusicMvMakerEditUIC) com.tencent.mm.ui.component.a.b(getActivity()).get(MusicMvMakerEditUIC.class)).cWX();
            LinearLayout ewa = ewa();
            kotlin.g.b.p.g(ewa, "itemEditRoot");
            ewa.setVisibility(0);
            ewa().animate().alpha(1.0f).setDuration(250).setListener(new p(this)).start();
            AppMethodBeat.o(257296);
            return;
        }
        getThumbView().setImageDrawable(null);
        MMTPRecyclerVideoLayout mMTPRecyclerVideoLayout = this.AuG;
        if (!(mMTPRecyclerVideoLayout == null || (player = mMTPRecyclerVideoLayout.getPlayer()) == null)) {
            player.pause();
        }
        ewf();
        com.tencent.mm.ui.component.a aVar2 = com.tencent.mm.ui.component.a.PRN;
        ((MusicMvMakerEditUIC) com.tencent.mm.ui.component.a.b(getActivity()).get(MusicMvMakerEditUIC.class)).cWY();
        ewa().animate().alpha(0.0f).withEndAction(new q(this)).start();
        AppMethodBeat.o(257296);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0007"}, hxF = {"com/tencent/mm/plugin/mv/ui/uic/MusicMvMakerItemEditUIC$setShow$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "onAnimationStart", "plugin-mv_release"})
    public static final class p extends AnimatorListenerAdapter {
        final /* synthetic */ MusicMvMakerItemEditUIC Avp;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        p(MusicMvMakerItemEditUIC musicMvMakerItemEditUIC) {
            this.Avp = musicMvMakerItemEditUIC;
        }

        public final void onAnimationStart(Animator animator) {
            AppMethodBeat.i(257279);
            RoundedCornerFrameLayout d2 = MusicMvMakerItemEditUIC.d(this.Avp);
            kotlin.g.b.p.g(d2, "previewContainer");
            d2.setAlpha(0.0f);
            AppMethodBeat.o(257279);
        }

        public final void onAnimationEnd(Animator animator) {
            AppMethodBeat.i(257280);
            RoundedCornerFrameLayout d2 = MusicMvMakerItemEditUIC.d(this.Avp);
            kotlin.g.b.p.g(d2, "previewContainer");
            d2.setAlpha(1.0f);
            AppMethodBeat.o(257280);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class q implements Runnable {
        final /* synthetic */ MusicMvMakerItemEditUIC Avp;

        q(MusicMvMakerItemEditUIC musicMvMakerItemEditUIC) {
            this.Avp = musicMvMakerItemEditUIC;
        }

        public final void run() {
            AppMethodBeat.i(257281);
            LinearLayout e2 = MusicMvMakerItemEditUIC.e(this.Avp);
            kotlin.g.b.p.g(e2, "itemEditRoot");
            e2.setVisibility(8);
            MusicMvMakerItemEditUIC.f(this.Avp);
            AppMethodBeat.o(257281);
        }
    }

    public final void d(com.tencent.mm.plugin.mv.a.d dVar) {
        int i2;
        com.tencent.mm.plugin.thumbplayer.d.a evA;
        com.tencent.mm.plugin.thumbplayer.e.b player;
        com.tencent.mm.plugin.thumbplayer.e.b player2;
        com.tencent.mm.plugin.thumbplayer.e.b player3;
        com.tencent.mm.plugin.thumbplayer.c.a effector;
        com.tencent.mm.plugin.thumbplayer.e.b player4;
        com.tencent.mm.plugin.thumbplayer.e.b player5;
        com.tencent.mm.plugin.thumbplayer.e.b player6;
        com.tencent.mm.plugin.thumbplayer.c.a effector2;
        AppMethodBeat.i(257297);
        kotlin.g.b.p.h(dVar, "item");
        StringBuilder sb = new StringBuilder("setVideoData:");
        d.h hVar = dVar.App;
        Log.i("MicroMsg.Mv.MusicMvMakerItemEditUIC", sb.append(hVar != null ? hVar.evA() : null).toString());
        this.Vam = false;
        this.Avi = -1;
        this.Avg = dVar;
        d.g gVar = dVar.Apo;
        if (gVar != null) {
            ImageView thumbView = getThumbView();
            kotlin.g.b.p.g(thumbView, "thumbView");
            d.g.a.a(gVar, thumbView);
        }
        int Tl = com.tencent.mm.plugin.mv.ui.a.e.Tl(dVar.getDurationMs());
        d.h hVar2 = dVar.App;
        if (hVar2 != null) {
            i2 = com.tencent.mm.plugin.mv.ui.a.e.Tm((int) hVar2.getDurationMs());
        } else {
            i2 = 0;
        }
        TextView ewb = ewb();
        kotlin.g.b.p.g(ewb, "hintView");
        ewb.setText(getActivity().getString(R.string.f8x, new Object[]{Integer.valueOf(i2), Integer.valueOf(Tl)}));
        d.h hVar3 = dVar.App;
        if (hVar3 != null) {
            this.eiq = hVar3.evz();
            this.targetDuration = (long) dVar.getDurationMs();
            this.Ave = hVar3.getDurationMs();
        }
        ewc().post(new s(this, dVar));
        d.h hVar4 = dVar.App;
        if (hVar4 == null || (evA = hVar4.evA()) == null) {
            AppMethodBeat.o(257297);
            return;
        }
        ewf();
        MMTPRecyclerVideoLayout mMTPRecyclerVideoLayout = this.AuG;
        if (mMTPRecyclerVideoLayout != null) {
            mMTPRecyclerVideoLayout.fxd();
        }
        MMTPRecyclerVideoLayout mMTPRecyclerVideoLayout2 = this.AuG;
        if (mMTPRecyclerVideoLayout2 != null) {
            mMTPRecyclerVideoLayout2.setMediaInfo(evA);
        }
        MMTPRecyclerVideoLayout mMTPRecyclerVideoLayout3 = this.AuG;
        if (!(mMTPRecyclerVideoLayout3 == null || (effector2 = mMTPRecyclerVideoLayout3.getEffector()) == null)) {
            effector2.hXB();
        }
        MMTPRecyclerVideoLayout mMTPRecyclerVideoLayout4 = this.AuG;
        if (!(mMTPRecyclerVideoLayout4 == null || (player6 = mMTPRecyclerVideoLayout4.getPlayer()) == null)) {
            player6.wcA = true;
        }
        MMTPRecyclerVideoLayout mMTPRecyclerVideoLayout5 = this.AuG;
        if (!(mMTPRecyclerVideoLayout5 == null || (player5 = mMTPRecyclerVideoLayout5.getPlayer()) == null)) {
            player5.fwW();
        }
        MMTPRecyclerVideoLayout mMTPRecyclerVideoLayout6 = this.AuG;
        if (!(mMTPRecyclerVideoLayout6 == null || (player4 = mMTPRecyclerVideoLayout6.getPlayer()) == null)) {
            player4.setLoop(true);
        }
        MMTPRecyclerVideoLayout mMTPRecyclerVideoLayout7 = this.AuG;
        if (!(mMTPRecyclerVideoLayout7 == null || (effector = mMTPRecyclerVideoLayout7.getEffector()) == null)) {
            com.tencent.mm.plugin.thumbplayer.c.a.a(effector);
        }
        MMTPRecyclerVideoLayout mMTPRecyclerVideoLayout8 = this.AuG;
        if (!(mMTPRecyclerVideoLayout8 == null || (player3 = mMTPRecyclerVideoLayout8.getPlayer()) == null)) {
            player3.at(this.eiq, this.eiq + ((long) dVar.getDurationMs()));
        }
        MMTPRecyclerVideoLayout mMTPRecyclerVideoLayout9 = this.AuG;
        if (!(mMTPRecyclerVideoLayout9 == null || (player2 = mMTPRecyclerVideoLayout9.getPlayer()) == null)) {
            player2.fwU();
        }
        ewe().setCursorPos(0.0f);
        MMTPRecyclerVideoLayout mMTPRecyclerVideoLayout10 = this.AuG;
        if (!(mMTPRecyclerVideoLayout10 == null || (player = mMTPRecyclerVideoLayout10.getPlayer()) == null)) {
            player.a(this.Avj, 30);
        }
        ImageView thumbView2 = getThumbView();
        kotlin.g.b.p.g(thumbView2, "thumbView");
        thumbView2.setVisibility(0);
        MMTPRecyclerVideoLayout mMTPRecyclerVideoLayout11 = this.AuG;
        if (mMTPRecyclerVideoLayout11 != null) {
            mMTPRecyclerVideoLayout11.setOnFrameAvailable(new r(this, dVar));
        }
        this.Val = this.Vaj;
        this.Vak = this.Vai;
        Log.i("MicroMsg.Mv.MusicMvMakerItemEditUIC", "setVideoData, firstRenderTime:" + this.Vai + ", firstRenderFrame:" + this.Vaj + ", backFirstRenderTime:" + this.Vak + ", backFirstFrame:" + this.Val);
        hWI();
        this.Avj.Avr = 0;
        com.tencent.mm.plugin.music.e.k euj = com.tencent.mm.plugin.music.e.k.euj();
        kotlin.g.b.p.g(euj, "MusicPlayerManager.Instance()");
        euj.etW().tG(dVar.Apl);
        AppMethodBeat.o(257297);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class s implements Runnable {
        final /* synthetic */ com.tencent.mm.plugin.mv.a.d ArX;
        final /* synthetic */ MusicMvMakerItemEditUIC Avp;

        s(MusicMvMakerItemEditUIC musicMvMakerItemEditUIC, com.tencent.mm.plugin.mv.a.d dVar) {
            this.Avp = musicMvMakerItemEditUIC;
            this.ArX = dVar;
        }

        public final void run() {
            d.i iVar = null;
            AppMethodBeat.i(259268);
            RecyclerView g2 = MusicMvMakerItemEditUIC.g(this.Avp);
            kotlin.g.b.p.g(g2, "frameRv");
            int paddingStart = g2.getPaddingStart();
            RecyclerView g3 = MusicMvMakerItemEditUIC.g(this.Avp);
            kotlin.g.b.p.g(g3, "frameRv");
            int width = g3.getWidth() - (paddingStart * 2);
            this.Avp.Avf = (((float) width) * 1.0f) / ((float) this.Avp.targetDuration);
            MusicMvMakerItemEditUIC.j(this.Avp).ah(0, -((int) (((float) this.Avp.eiq) * this.Avp.Avf)));
            if (this.ArX.App instanceof d.i) {
                d.h hVar = this.ArX.App;
                if (hVar instanceof d.i) {
                    iVar = hVar;
                }
                d.i iVar2 = iVar;
                if (iVar2 != null) {
                    MusicMvMakerItemEditUIC.a(this.Avp, iVar2);
                }
            } else if (this.ArX.App instanceof d.e) {
                d.h hVar2 = this.ArX.App;
                if (hVar2 instanceof d.e) {
                    iVar = hVar2;
                }
                d.e eVar = iVar;
                if (eVar != null) {
                    MusicMvMakerItemEditUIC.a(this.Avp, eVar);
                }
            }
            MusicMvMakerItemEditUIC.l(this.Avp).ao(width, width, paddingStart);
            MusicMvMakerItemEditUIC.l(this.Avp).b(true, (float) paddingStart);
            MusicMvMakerItemEditUIC.l(this.Avp).b(true, (float) (paddingStart + width));
            AppMethodBeat.o(259268);
        }
    }

    private final void hWI() {
        com.tencent.mm.plugin.thumbplayer.c.a effector;
        AppMethodBeat.i(259270);
        com.tencent.mm.plugin.mv.a.d dVar = this.Avg;
        if (dVar != null) {
            int i2 = dVar.Apl;
            if (dVar.Apq != null && i2 <= this.Vai) {
                Log.i("MicroMsg.Mv.MusicMvMakerItemEditUIC", "tryCatchFirstFrame, timeInMv:" + i2 + ", firstRenderTime:" + this.Vai);
                MMTPRecyclerVideoLayout mMTPRecyclerVideoLayout = this.AuG;
                if (!(mMTPRecyclerVideoLayout == null || (effector = mMTPRecyclerVideoLayout.getEffector()) == null)) {
                    effector.ac(new v(i2, this));
                    AppMethodBeat.o(259270);
                    return;
                }
            }
            AppMethodBeat.o(259270);
            return;
        }
        AppMethodBeat.o(259270);
    }

    private final void ewf() {
        FrameListView frameListView;
        AppMethodBeat.i(257298);
        int itemCount = ewd().getItemCount();
        for (int i2 = 0; i2 < itemCount; i2++) {
            RecyclerView.v ch = ewc().ch(i2);
            if (!(ch instanceof d)) {
                ch = null;
            }
            d dVar = (d) ch;
            if (!(dVar == null || (frameListView = dVar.Avq) == null)) {
                frameListView.release();
            }
        }
        ewd().Avo = null;
        ewc().postInvalidate();
        AppMethodBeat.o(257298);
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onDestroy() {
        com.tencent.mm.plugin.thumbplayer.c.a effector;
        com.tencent.mm.plugin.thumbplayer.e.b player;
        AppMethodBeat.i(257299);
        super.onDestroy();
        MMTPRecyclerVideoLayout mMTPRecyclerVideoLayout = this.AuG;
        if (!(mMTPRecyclerVideoLayout == null || (player = mMTPRecyclerVideoLayout.getPlayer()) == null)) {
            player.recycle();
        }
        MMTPRecyclerVideoLayout mMTPRecyclerVideoLayout2 = this.AuG;
        if (!(mMTPRecyclerVideoLayout2 == null || (effector = mMTPRecyclerVideoLayout2.getEffector()) == null)) {
            effector.release();
        }
        c.a aVar = com.tencent.mm.videocomposition.c.RgU;
        com.tencent.mm.videocomposition.c.Asq.evictAll();
        b.a aVar2 = com.tencent.mm.plugin.mv.ui.b.b.Asr;
        Log.i("MicroMsg.TPTrackThumbFetcher", "clearCache");
        com.tencent.mm.plugin.mv.ui.b.b.evK().evictAll();
        AppMethodBeat.o(257299);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\t\u001a\u00020\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u000b"}, hxF = {"Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvMakerItemEditUIC$ThumbViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "parent", "Landroid/view/ViewGroup;", "(Landroid/view/ViewGroup;)V", "frameList", "Lcom/tencent/mm/plugin/vlog/ui/thumb/FrameListView;", "getFrameList", "()Lcom/tencent/mm/plugin/vlog/ui/thumb/FrameListView;", "unbind", "", "plugin-mv_release"})
    public static final class d extends RecyclerView.v {
        final FrameListView Avq;

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public d(android.view.ViewGroup r5) {
            /*
                r4 = this;
                r3 = 257265(0x3ecf1, float:3.60505E-40)
                java.lang.String r0 = "parent"
                kotlin.g.b.p.h(r5, r0)
                com.tencent.mm.plugin.vlog.ui.thumb.FrameListView r0 = new com.tencent.mm.plugin.vlog.ui.thumb.FrameListView
                android.content.Context r1 = r5.getContext()
                java.lang.String r2 = "parent.context"
                kotlin.g.b.p.g(r1, r2)
                r0.<init>(r1)
                android.view.View r0 = (android.view.View) r0
                r4.<init>(r0)
                com.tencent.matrix.trace.core.AppMethodBeat.i(r3)
                android.view.View r0 = r4.aus
                if (r0 != 0) goto L_0x0030
                kotlin.t r0 = new kotlin.t
                java.lang.String r1 = "null cannot be cast to non-null type com.tencent.mm.plugin.vlog.ui.thumb.FrameListView"
                r0.<init>(r1)
                com.tencent.matrix.trace.core.AppMethodBeat.o(r3)
                throw r0
            L_0x0030:
                com.tencent.mm.plugin.vlog.ui.thumb.FrameListView r0 = (com.tencent.mm.plugin.vlog.ui.thumb.FrameListView) r0
                r4.Avq = r0
                com.tencent.matrix.trace.core.AppMethodBeat.o(r3)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.mv.ui.uic.MusicMvMakerItemEditUIC.d.<init>(android.view.ViewGroup):void");
        }

        public final void ewg() {
            AppMethodBeat.i(257264);
            Log.i("MicroMsg.Mv.MusicMvMakerItemEditUIC", "release frameListView");
            this.Avq.release();
            AppMethodBeat.o(257264);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0000\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\f\u001a\u00020\rH\u0016J\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\rH\u0016J\u0018\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\rH\u0016J\u0010\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u0002H\u0016J\u0010\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u0002H\u0016J\u0010\u0010\u0019\u001a\u00020\u000f2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0005J\u0014\u0010\u001b\u001a\u00020\u000f2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\b0\u001dR\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0002\n\u0000R!\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u001e"}, hxF = {"Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvMakerItemEditUIC$ThumbAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvMakerItemEditUIC$ThumbViewHolder;", "(Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvMakerItemEditUIC;)V", "thumbFetcherFactory", "Lcom/tencent/mm/plugin/vlog/ui/thumb/ThumbFetcherFactory;", "trackInfoList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/vlog/ui/thumb/BaseTrackThumbInfo;", "Lkotlin/collections/ArrayList;", "getTrackInfoList", "()Ljava/util/ArrayList;", "getItemCount", "", "onBindViewHolder", "", "viewHolder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onViewDetachedFromWindow", "holder", "onViewRecycled", "setThumbFetcherFactory", "factory", "updateTrackInfo", "trackInfos", "", "plugin-mv_release"})
    public final class c extends RecyclerView.a<d> {
        final ArrayList<com.tencent.mm.plugin.vlog.ui.thumb.a> Avn = new ArrayList<>();
        com.tencent.mm.plugin.vlog.ui.thumb.g Avo;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        public c() {
            AppMethodBeat.i(257263);
            AppMethodBeat.o(257263);
        }

        /* Return type fixed from 'android.support.v7.widget.RecyclerView$v' to match base method */
        @Override // android.support.v7.widget.RecyclerView.a
        public final /* synthetic */ d a(ViewGroup viewGroup, int i2) {
            AppMethodBeat.i(257258);
            kotlin.g.b.p.h(viewGroup, "parent");
            d dVar = new d(viewGroup);
            AppMethodBeat.o(257258);
            return dVar;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.support.v7.widget.RecyclerView$v] */
        @Override // android.support.v7.widget.RecyclerView.a
        public final /* synthetic */ void a(d dVar) {
            AppMethodBeat.i(257260);
            d dVar2 = dVar;
            kotlin.g.b.p.h(dVar2, "holder");
            super.a(dVar2);
            dVar2.ewg();
            AppMethodBeat.o(257260);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.support.v7.widget.RecyclerView$v, int] */
        @Override // android.support.v7.widget.RecyclerView.a
        public final /* synthetic */ void a(d dVar, int i2) {
            b.C1836b bVar;
            com.tencent.mm.plugin.thumbplayer.e.b player;
            AppMethodBeat.i(257259);
            d dVar2 = dVar;
            kotlin.g.b.p.h(dVar2, "viewHolder");
            com.tencent.mm.plugin.vlog.ui.thumb.g gVar = this.Avo;
            if (gVar != null) {
                dVar2.Avq.setThumbFetcherFactory(gVar);
                FrameListView frameListView = dVar2.Avq;
                MMTPRecyclerVideoLayout mMTPRecyclerVideoLayout = MusicMvMakerItemEditUIC.this.AuG;
                if (mMTPRecyclerVideoLayout == null || (player = mMTPRecyclerVideoLayout.getPlayer()) == null) {
                    bVar = null;
                } else {
                    bVar = player.GhA;
                }
                frameListView.setThumbFetcherExtraData(bVar);
            }
            FrameListView frameListView2 = dVar2.Avq;
            com.tencent.mm.plugin.vlog.ui.thumb.a aVar = this.Avn.get(i2);
            kotlin.g.b.p.g(aVar, "trackInfoList[position]");
            frameListView2.setTrackInfo(aVar);
            AppMethodBeat.o(257259);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.support.v7.widget.RecyclerView$v] */
        @Override // android.support.v7.widget.RecyclerView.a
        public final /* synthetic */ void l(d dVar) {
            AppMethodBeat.i(257261);
            d dVar2 = dVar;
            kotlin.g.b.p.h(dVar2, "holder");
            super.l(dVar2);
            dVar2.ewg();
            AppMethodBeat.o(257261);
        }

        public final void fE(List<? extends com.tencent.mm.plugin.vlog.ui.thumb.a> list) {
            AppMethodBeat.i(257257);
            kotlin.g.b.p.h(list, "trackInfos");
            this.Avn.clear();
            this.Avn.addAll(list);
            notifyDataSetChanged();
            AppMethodBeat.o(257257);
        }

        @Override // android.support.v7.widget.RecyclerView.a
        public final int getItemCount() {
            AppMethodBeat.i(257262);
            int size = this.Avn.size();
            AppMethodBeat.o(257262);
            return size;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Landroid/widget/LinearLayout;", "kotlin.jvm.PlatformType", "invoke"})
    static final class h extends kotlin.g.b.q implements kotlin.g.a.a<LinearLayout> {
        final /* synthetic */ AppCompatActivity uQi;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        h(AppCompatActivity appCompatActivity) {
            super(0);
            this.uQi = appCompatActivity;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ LinearLayout invoke() {
            AppMethodBeat.i(257269);
            LinearLayout linearLayout = (LinearLayout) this.uQi.findViewById(R.id.frn);
            AppMethodBeat.o(257269);
            return linearLayout;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Lcom/tencent/mm/ui/widget/RoundedCornerFrameLayout;", "kotlin.jvm.PlatformType", "invoke"})
    static final class l extends kotlin.g.b.q implements kotlin.g.a.a<RoundedCornerFrameLayout> {
        final /* synthetic */ AppCompatActivity uQi;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        l(AppCompatActivity appCompatActivity) {
            super(0);
            this.uQi = appCompatActivity;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ RoundedCornerFrameLayout invoke() {
            AppMethodBeat.i(257273);
            RoundedCornerFrameLayout roundedCornerFrameLayout = (RoundedCornerFrameLayout) this.uQi.findViewById(R.id.frp);
            AppMethodBeat.o(257273);
            return roundedCornerFrameLayout;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Landroid/widget/FrameLayout;", "kotlin.jvm.PlatformType", "invoke"})
    static final class u extends kotlin.g.b.q implements kotlin.g.a.a<FrameLayout> {
        final /* synthetic */ AppCompatActivity uQi;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        u(AppCompatActivity appCompatActivity) {
            super(0);
            this.uQi = appCompatActivity;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ FrameLayout invoke() {
            AppMethodBeat.i(257286);
            FrameLayout frameLayout = (FrameLayout) this.uQi.findViewById(R.id.fro);
            AppMethodBeat.o(257286);
            return frameLayout;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "invoke"})
    static final class t extends kotlin.g.b.q implements kotlin.g.a.a<ImageView> {
        final /* synthetic */ AppCompatActivity uQi;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        t(AppCompatActivity appCompatActivity) {
            super(0);
            this.uQi = appCompatActivity;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ ImageView invoke() {
            AppMethodBeat.i(257285);
            ImageView imageView = (ImageView) this.uQi.findViewById(R.id.frb);
            AppMethodBeat.o(257285);
            return imageView;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "invoke"})
    static final class g extends kotlin.g.b.q implements kotlin.g.a.a<TextView> {
        final /* synthetic */ AppCompatActivity uQi;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        g(AppCompatActivity appCompatActivity) {
            super(0);
            this.uQi = appCompatActivity;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ TextView invoke() {
            AppMethodBeat.i(257268);
            TextView textView = (TextView) this.uQi.findViewById(R.id.frm);
            AppMethodBeat.o(257268);
            return textView;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Landroid/support/v7/widget/RecyclerView;", "kotlin.jvm.PlatformType", "invoke"})
    static final class f extends kotlin.g.b.q implements kotlin.g.a.a<RecyclerView> {
        final /* synthetic */ AppCompatActivity uQi;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        f(AppCompatActivity appCompatActivity) {
            super(0);
            this.uQi = appCompatActivity;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ RecyclerView invoke() {
            AppMethodBeat.i(257267);
            RecyclerView recyclerView = (RecyclerView) this.uQi.findViewById(R.id.frc);
            AppMethodBeat.o(257267);
            return recyclerView;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "Landroid/support/v7/widget/LinearLayoutManager;", "invoke"})
    static final class i extends kotlin.g.b.q implements kotlin.g.a.a<LinearLayoutManager> {
        final /* synthetic */ AppCompatActivity uQi;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        i(AppCompatActivity appCompatActivity) {
            super(0);
            this.uQi = appCompatActivity;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ LinearLayoutManager invoke() {
            AppMethodBeat.i(257270);
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(0, false);
            AppMethodBeat.o(257270);
            return linearLayoutManager;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00060\u0001R\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvMakerItemEditUIC$ThumbAdapter;", "Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvMakerItemEditUIC;", "invoke"})
    static final class e extends kotlin.g.b.q implements kotlin.g.a.a<c> {
        final /* synthetic */ MusicMvMakerItemEditUIC Avp;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(MusicMvMakerItemEditUIC musicMvMakerItemEditUIC) {
            super(0);
            this.Avp = musicMvMakerItemEditUIC;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ c invoke() {
            AppMethodBeat.i(257266);
            c cVar = new c();
            AppMethodBeat.o(257266);
            return cVar;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Lcom/tencent/mm/plugin/mv/ui/view/MusicMvSliderSeekBar;", "kotlin.jvm.PlatformType", "invoke"})
    static final class o extends kotlin.g.b.q implements kotlin.g.a.a<MusicMvSliderSeekBar> {
        final /* synthetic */ AppCompatActivity uQi;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        o(AppCompatActivity appCompatActivity) {
            super(0);
            this.uQi = appCompatActivity;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ MusicMvSliderSeekBar invoke() {
            AppMethodBeat.i(257278);
            MusicMvSliderSeekBar musicMvSliderSeekBar = (MusicMvSliderSeekBar) this.uQi.findViewById(R.id.frd);
            AppMethodBeat.o(257278);
            return musicMvSliderSeekBar;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004¨\u0006\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/graphics/SurfaceTexture;", "invoke", "com/tencent/mm/plugin/mv/ui/uic/MusicMvMakerItemEditUIC$setVideoData$3$1"})
    static final class r extends kotlin.g.b.q implements kotlin.g.a.b<SurfaceTexture, x> {
        final /* synthetic */ com.tencent.mm.plugin.mv.a.d AuU;
        final /* synthetic */ MusicMvMakerItemEditUIC Avp;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        r(MusicMvMakerItemEditUIC musicMvMakerItemEditUIC, com.tencent.mm.plugin.mv.a.d dVar) {
            super(1);
            this.Avp = musicMvMakerItemEditUIC;
            this.AuU = dVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(SurfaceTexture surfaceTexture) {
            AppMethodBeat.i(257283);
            com.tencent.mm.ac.d.h(new kotlin.g.a.a<x>(this) {
                /* class com.tencent.mm.plugin.mv.ui.uic.MusicMvMakerItemEditUIC.r.AnonymousClass1 */
                final /* synthetic */ r Avt;

                {
                    this.Avt = r2;
                }

                /* Return type fixed from 'java.lang.Object' to match base method */
                @Override // kotlin.g.a.a
                public final /* synthetic */ x invoke() {
                    com.tencent.mm.plugin.thumbplayer.e.b player;
                    com.tencent.mm.plugin.thumbplayer.e.a aVar;
                    AppMethodBeat.i(257282);
                    MMTPRecyclerVideoLayout mMTPRecyclerVideoLayout = this.Avt.Avp.AuG;
                    long durationMs = (mMTPRecyclerVideoLayout == null || (player = mMTPRecyclerVideoLayout.getPlayer()) == null || (aVar = player.wdC) == null) ? 0 : aVar.getDurationMs();
                    Log.i("MicroMsg.Mv.MusicMvMakerItemEditUIC", "setVideoDuration: origin:" + this.Avt.Avp.Ave + ", player:" + durationMs);
                    if (durationMs > 0 && this.Avt.Avp.Ave != durationMs) {
                        d.h hVar = this.Avt.AuU.App;
                        if (hVar != null) {
                            hVar.RQ(durationMs);
                        }
                        this.Avt.Avp.Ave = durationMs;
                        MusicMvMakerItemEditUIC.v(this.Avt.Avp);
                    }
                    ImageView m = MusicMvMakerItemEditUIC.m(this.Avt.Avp);
                    kotlin.g.b.p.g(m, "thumbView");
                    m.setVisibility(4);
                    MMTPRecyclerVideoLayout mMTPRecyclerVideoLayout2 = this.Avt.Avp.AuG;
                    if (mMTPRecyclerVideoLayout2 != null) {
                        mMTPRecyclerVideoLayout2.setOnFrameAvailable(null);
                    }
                    x xVar = x.SXb;
                    AppMethodBeat.o(257282);
                    return xVar;
                }
            });
            x xVar = x.SXb;
            AppMethodBeat.o(257283);
            return xVar;
        }
    }

    public static final /* synthetic */ RoundedCornerFrameLayout d(MusicMvMakerItemEditUIC musicMvMakerItemEditUIC) {
        AppMethodBeat.i(257302);
        RoundedCornerFrameLayout roundedCornerFrameLayout = (RoundedCornerFrameLayout) musicMvMakerItemEditUIC.AuZ.getValue();
        AppMethodBeat.o(257302);
        return roundedCornerFrameLayout;
    }

    public static final /* synthetic */ void a(MusicMvMakerItemEditUIC musicMvMakerItemEditUIC, d.i iVar) {
        AppMethodBeat.i(257307);
        com.tencent.mm.plugin.vlog.ui.thumb.h hVar = new com.tencent.mm.plugin.vlog.ui.thumb.h(new ad(iVar.videoPath, 2));
        hVar.GOE = musicMvMakerItemEditUIC.Ave;
        hVar.width = 80;
        hVar.height = 120;
        hVar.GOF = (musicMvMakerItemEditUIC.Avf * ((float) musicMvMakerItemEditUIC.Ave)) / (((((float) musicMvMakerItemEditUIC.Avh) * 1.0f) / ((float) hVar.height)) * ((float) hVar.width));
        hVar.fEv();
        musicMvMakerItemEditUIC.ewd().Avo = new com.tencent.mm.plugin.vlog.ui.thumb.b();
        musicMvMakerItemEditUIC.ewd().fE(kotlin.a.j.listOf(hVar));
        AppMethodBeat.o(257307);
    }

    public static final /* synthetic */ void a(MusicMvMakerItemEditUIC musicMvMakerItemEditUIC, d.e eVar) {
        AppMethodBeat.i(257308);
        com.tencent.mm.plugin.thumbplayer.d.a evA = eVar.evA();
        if (evA != null) {
            com.tencent.mm.plugin.mv.ui.b.c cVar = new com.tencent.mm.plugin.mv.ui.b.c(evA);
            cVar.width = 80;
            cVar.height = 120;
            cVar.GOF = (musicMvMakerItemEditUIC.Avf * ((float) musicMvMakerItemEditUIC.Ave)) / (((((float) musicMvMakerItemEditUIC.Avh) * 1.0f) / ((float) cVar.height)) * ((float) cVar.width));
            cVar.fEv();
            musicMvMakerItemEditUIC.ewd().Avo = new com.tencent.mm.plugin.mv.ui.b.a();
            musicMvMakerItemEditUIC.ewd().fE(kotlin.a.j.listOf(cVar));
            AppMethodBeat.o(257308);
            return;
        }
        AppMethodBeat.o(257308);
    }

    public static final /* synthetic */ void v(MusicMvMakerItemEditUIC musicMvMakerItemEditUIC) {
        AppMethodBeat.i(259271);
        RecyclerView ewc = musicMvMakerItemEditUIC.ewc();
        kotlin.g.b.p.g(ewc, "frameRv");
        int childCount = ewc.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            FrameListView frameListView = (FrameListView) musicMvMakerItemEditUIC.ewc().getChildAt(i2);
            if (frameListView != null) {
                musicMvMakerItemEditUIC.ewc();
                com.tencent.mm.plugin.vlog.ui.thumb.a aVar = musicMvMakerItemEditUIC.ewd().Avn.get(RecyclerView.bw(frameListView));
                kotlin.g.b.p.g(aVar, "frameAdapter.trackInfoList[position]");
                com.tencent.mm.plugin.vlog.ui.thumb.a aVar2 = aVar;
                aVar2.GOF = (musicMvMakerItemEditUIC.Avf * ((float) musicMvMakerItemEditUIC.Ave)) / (((((float) musicMvMakerItemEditUIC.Avh) * 1.0f) / ((float) aVar2.height)) * ((float) aVar2.width));
                aVar2.fEv();
                frameListView.setTrackInfo(aVar2);
                frameListView.requestLayout();
            }
        }
        AppMethodBeat.o(259271);
    }
}

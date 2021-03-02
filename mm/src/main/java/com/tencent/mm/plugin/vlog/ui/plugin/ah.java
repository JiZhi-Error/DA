package com.tencent.mm.plugin.vlog.ui.plugin;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.a.a;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import com.facebook.internal.NativeProtocol;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d;
import com.tencent.mm.plugin.recordvideo.plugin.t;
import com.tencent.mm.plugin.vlog.model.ac;
import com.tencent.mm.plugin.vlog.ui.plugin.e;
import com.tencent.mm.plugin.vlog.ui.thumb.FrameListView;
import com.tencent.mm.plugin.vlog.ui.thumb.f;
import com.tencent.mm.plugin.vlog.ui.thumb.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.videocomposition.c;
import com.tencent.tav.coremedia.CMTimeRange;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import kotlin.a.j;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.g.b.z;
import kotlin.l;
import kotlin.o;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000ª\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010 \n\u0002\b\u0004\u0018\u0000 o2\u00020\u00012\u00020\u00022\u00020\u0003:\u0003opqB\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0006\u0010T\u001a\u00020UJ\u0014\u0010V\u001a\u000e\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020$0WH\u0002J\u000e\u0010\u0015\u001a\u00020U2\u0006\u0010X\u001a\u00020\u0012J\b\u0010Y\u001a\u00020UH\u0016J\u0010\u0010Z\u001a\u00020U2\u0006\u0010[\u001a\u00020 H\u0016J\u0012\u0010\\\u001a\u00020U2\b\u0010]\u001a\u0004\u0018\u00010\fH\u0016J\"\u0010^\u001a\u00020U2\b\u0010_\u001a\u0004\u0018\u00010`2\u0006\u0010a\u001a\u00020 2\u0006\u0010b\u001a\u00020\u0012H\u0016J\b\u0010c\u001a\u00020UH\u0016J\u001e\u0010d\u001a\u00020U2\u0006\u0010e\u001a\u00020-2\u0006\u0010f\u001a\u00020 2\u0006\u0010g\u001a\u00020 J\u0010\u0010h\u001a\u00020U2\u0006\u0010i\u001a\u00020-H\u0016J\u000e\u0010>\u001a\u00020U2\u0006\u0010j\u001a\u00020\u0012J\u0006\u0010k\u001a\u00020UJ\u0014\u0010l\u001a\u00020U2\f\u0010m\u001a\b\u0012\u0004\u0012\u00020\u00120nR\u000e\u0010\t\u001a\u00020\nXD¢\u0006\u0002\n\u0000R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0017X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020 X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020 X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020$X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020$X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u000e\u0010(\u001a\u00020)X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020+X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020-X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020 X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020 X\u000e¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u000202X\u0004¢\u0006\u0002\n\u0000R\u0010\u00103\u001a\u0004\u0018\u000104X\u000e¢\u0006\u0002\n\u0000R\u001a\u00105\u001a\u00020-X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\u000e\u0010:\u001a\u00020-X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010;\u001a\u00020-X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010<\u001a\u00020 X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010=\u001a\u00020 X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010>\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010?\u001a\u00020$X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010@\u001a\u0004\u0018\u00010AX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010C\"\u0004\bD\u0010ER\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\bF\u0010GR\u000e\u0010H\u001a\u00020-X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010I\u001a\u00020-X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010J\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010K\u001a\u00020-X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010L\u001a\u00020 X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010M\u001a\u00020-X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010N\u001a\u00020-X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010O\u001a\u00020$X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010P\u001a\u00020$X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010Q\u001a\b\u0012\u0004\u0012\u00020\u00170RX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010S\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000¨\u0006r"}, hxF = {"Lcom/tencent/mm/plugin/vlog/ui/plugin/VLogThumbViewPlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "Lcom/tencent/mm/plugin/vlog/ui/plugin/EditMultiPreviewPlugin$PreviewSeekCallback;", "Lcom/tencent/mm/plugin/vlog/ui/plugin/EditMultiPreviewPlugin$PreviewUpdateCallback;", "layout", "Landroid/view/View;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Landroid/view/View;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "TAG", "", "audioSeekable", "Lcom/tencent/mm/plugin/vlog/ui/plugin/EditMultiPreviewPlugin$Seekable;", "getAudioSeekable", "()Lcom/tencent/mm/plugin/vlog/ui/plugin/EditMultiPreviewPlugin$Seekable;", "setAudioSeekable", "(Lcom/tencent/mm/plugin/vlog/ui/plugin/EditMultiPreviewPlugin$Seekable;)V", "canScroll", "", "dragScroll", "enableAutoScroll", "enableTrackTouchMove", "endEmptyTrack", "Lcom/tencent/mm/plugin/vlog/ui/thumb/TrackThumbInfo;", "frameAdapter", "Lcom/tencent/mm/plugin/vlog/ui/thumb/FrameListAdapter;", "headEmptyTrack", "indicator", "isThumbViewReady", "itemTouchHelper", "Landroid/support/v7/widget/helper/ItemTouchHelper;", "lastClickTime", "", "lastLogProgressTime", "lastTime", "lastTouchX", "", "lastTouchY", "getLayout", "()Landroid/view/View;", "layoutManager", "Landroid/support/v7/widget/LinearLayoutManager;", "markDecoration", "Lcom/tencent/mm/plugin/vlog/ui/plugin/transition/TransitionMarkDecoration;", "originScrolledX", "", "playEnd", "playStart", "playWaitIdle", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "runOnSize", "Ljava/lang/Runnable;", "scrollCount", "getScrollCount", "()I", "setScrollCount", "(I)V", "scrolledX", "selectIndex", "selectPlayEndTime", "selectPlayStartTime", "showTransitionMark", "sizePerTime", "sortCallback", "Lcom/tencent/mm/plugin/vlog/ui/plugin/VLogThumbViewPlugin$TrackSortCallback;", "getSortCallback", "()Lcom/tencent/mm/plugin/vlog/ui/plugin/VLogThumbViewPlugin$TrackSortCallback;", "setSortCallback", "(Lcom/tencent/mm/plugin/vlog/ui/plugin/VLogThumbViewPlugin$TrackSortCallback;)V", "getStatus", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "tapTimeout", "thumbHeight", "thumbViewRoot", "thumbWidth", "totalDuration", "totalWidth", "touchSlop", "touchX", "touchY", "trackThumbInfo", "Ljava/util/LinkedList;", "videoSeekable", "clearFocus", "", "computeCurrentSelectMaxMinScrollExtent", "Lkotlin/Pair;", "enable", "onFinish", "onProgress", "timeMs", "onStart", "seekable", "onUpdate", "composition", "Lcom/tencent/mm/plugin/vlog/model/VLogComposition;", "seekTo", "seekToOriginPosition", "release", "selectTrack", FirebaseAnalytics.b.INDEX, "startTime", "endTime", "setVisibility", "visibility", "visible", "stopScroll", "updateTransMarkStatus", "transMarkStatusList", "", "Companion", "TrackSelectedCallback", "TrackSortCallback", "plugin-vlog_release"})
public final class ah implements t, e.c, e.d {
    public static final a GJs = new a((byte) 0);
    private long Ave;
    private float Avf;
    private int FVU;
    private float FcB;
    private float FcC;
    private e.AbstractC1868e GGT;
    public e.AbstractC1868e GGU;
    private final View GIW;
    private final f GIX;
    private final android.support.v7.widget.a.a GIY;
    private final com.tencent.mm.plugin.vlog.ui.plugin.transition.e GIZ;
    private int GJa;
    private boolean GJb;
    private int GJc;
    private Runnable GJd;
    private final h GJe;
    private final h GJf;
    private boolean GJg;
    private int GJh;
    public int GJi;
    public b GJj;
    private boolean GJk;
    private boolean GJl;
    private final LinkedList<h> GJm;
    public boolean GJn;
    private long GJo;
    private long GJp;
    private boolean GJq;
    private long GJr;
    private long GhH;
    private final String TAG = "MicroMsg.VLogThumbViewPlugin";
    private boolean canScroll;
    private float gZZ;
    private float haa;
    public final RecyclerView hak;
    private long hwQ;
    private long lastClickTime;
    private int rZ;
    private final View sc;
    private int thumbHeight;
    private int thumbWidth;
    private final View uyM;
    private final LinearLayoutManager vKp;
    private long wbl;
    final com.tencent.mm.plugin.recordvideo.plugin.parent.d wgr;
    private int whv;

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&J\b\u0010\u0007\u001a\u00020\u0003H&¨\u0006\b"}, hxF = {"Lcom/tencent/mm/plugin/vlog/ui/plugin/VLogThumbViewPlugin$TrackSortCallback;", "", "onMove", "", "fromPosition", "", "toPosition", "onSortEnd", "plugin-vlog_release"})
    public interface b {
        void fCJ();

        void fJ(int i2, int i3);
    }

    static {
        AppMethodBeat.i(191549);
        AppMethodBeat.o(191549);
    }

    public ah(View view, com.tencent.mm.plugin.recordvideo.plugin.parent.d dVar) {
        p.h(view, "layout");
        p.h(dVar, "status");
        AppMethodBeat.i(191548);
        this.sc = view;
        this.wgr = dVar;
        View findViewById = this.sc.findViewById(R.id.j8q);
        p.g(findViewById, "layout.findViewById(R.id.vlog_editor_thumb_view)");
        this.GIW = findViewById;
        View findViewById2 = this.sc.findViewById(R.id.j8p);
        p.g(findViewById2, "layout.findViewById(R.id…og_editor_thumb_progress)");
        this.uyM = findViewById2;
        View findViewById3 = this.sc.findViewById(R.id.j8x);
        p.g(findViewById3, "layout.findViewById(R.id.vlog_thumb_recycler)");
        this.hak = (RecyclerView) findViewById3;
        this.GJa = 1;
        this.thumbHeight = 112;
        this.thumbWidth = 63;
        this.GJb = true;
        this.Avf = 1.0f;
        h.a aVar = h.GQe;
        this.GJe = h.a.fEy();
        h.a aVar2 = h.GQe;
        this.GJf = h.a.fEy();
        ViewConfiguration viewConfiguration = ViewConfiguration.get(this.sc.getContext());
        p.g(viewConfiguration, "ViewConfiguration.get(layout.context)");
        this.rZ = viewConfiguration.getScaledTouchSlop();
        this.GJh = 200;
        this.GJm = new LinkedList<>();
        this.GJn = true;
        this.whv = -1;
        this.canScroll = true;
        this.sc.getContext();
        this.vKp = new VLogThumbViewPlugin$1(this);
        this.hak.setLayoutManager(this.vKp);
        this.GIX = new f();
        this.hak.setAdapter(this.GIX);
        this.hak.setItemAnimator(null);
        this.hak.setFocusableInTouchMode(false);
        this.hak.setFocusable(false);
        Context context = this.sc.getContext();
        p.g(context, "layout.context");
        this.GIZ = new com.tencent.mm.plugin.vlog.ui.plugin.transition.e(context, this.GIX);
        this.hak.a(new RecyclerView.l(this) {
            /* class com.tencent.mm.plugin.vlog.ui.plugin.ah.AnonymousClass1 */
            final /* synthetic */ ah GJt;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            {
                this.GJt = r1;
            }

            @Override // android.support.v7.widget.RecyclerView.l
            public final void onScrolled(RecyclerView recyclerView, int i2, int i3) {
                e.AbstractC1868e eVar;
                AppMethodBeat.i(191527);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(recyclerView);
                bVar.pH(i2);
                bVar.pH(i3);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/vlog/ui/plugin/VLogThumbViewPlugin$2", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, bVar.axR());
                p.h(recyclerView, "recyclerView");
                super.onScrolled(recyclerView, i2, i3);
                if (this.GJt.GJl) {
                    this.GJt.FVU += i2;
                }
                Log.d(this.GJt.TAG, "onScrolled, scrolledX:" + this.GJt.FVU + ", dx:" + i2 + ", isThumbViewReady:" + this.GJt.GJl);
                if (!this.GJt.GJb && this.GJt.GJl && this.GJt.GJa > 0 && i2 != 0 && (eVar = this.GJt.GGT) != null) {
                    eVar.Lb((((this.GJt.GhH - this.GJt.wbl) * ((long) this.GJt.FVU)) / ((long) this.GJt.GJa)) + this.GJt.wbl);
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/vlog/ui/plugin/VLogThumbViewPlugin$2", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
                AppMethodBeat.o(191527);
            }

            @Override // android.support.v7.widget.RecyclerView.l
            public final void onScrollStateChanged(RecyclerView recyclerView, int i2) {
                AppMethodBeat.i(191528);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(recyclerView);
                bVar.pH(i2);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/vlog/ui/plugin/VLogThumbViewPlugin$2", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, bVar.axR());
                p.h(recyclerView, "recyclerView");
                Log.i(this.GJt.TAG, "onScrollStateChanged: ".concat(String.valueOf(i2)));
                super.onScrollStateChanged(recyclerView, i2);
                if (i2 == 0) {
                    if (this.GJt.GJk) {
                        this.GJt.GJb = true;
                        e.AbstractC1868e eVar = this.GJt.GGT;
                        if (eVar != null) {
                            eVar.resume();
                        }
                        this.GJt.GJk = false;
                    }
                    this.GJt.GJq = false;
                } else if (i2 == 1) {
                    if (!this.GJt.GJq) {
                        this.GJt.GJi++;
                    }
                    this.GJt.GJq = true;
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/vlog/ui/plugin/VLogThumbViewPlugin$2", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
                AppMethodBeat.o(191528);
            }
        });
        this.hak.a(new RecyclerView.k(this) {
            /* class com.tencent.mm.plugin.vlog.ui.plugin.ah.AnonymousClass2 */
            final /* synthetic */ ah GJt;

            @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", "position", "", "invoke"})
            /* renamed from: com.tencent.mm.plugin.vlog.ui.plugin.ah$2$a */
            static final class a extends q implements kotlin.g.a.b<Integer, x> {
                final /* synthetic */ AnonymousClass2 GJu;
                final /* synthetic */ z.a GJv;

                /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                a(AnonymousClass2 r2, z.a aVar) {
                    super(1);
                    this.GJu = r2;
                    this.GJv = aVar;
                }

                /* Return type fixed from 'java.lang.Object' to match base method */
                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                @Override // kotlin.g.a.b
                public final /* synthetic */ x invoke(Integer num) {
                    AppMethodBeat.i(191529);
                    int intValue = num.intValue();
                    if (intValue != -1) {
                        com.tencent.mm.plugin.recordvideo.plugin.parent.d dVar = this.GJu.GJt.wgr;
                        d.c cVar = d.c.BWy;
                        Bundle bundle = new Bundle();
                        bundle.putInt("EDIT_SELECT_TRANSITION_INDEX", intValue);
                        dVar.a(cVar, bundle);
                        this.GJv.SYB = true;
                    }
                    x xVar = x.SXb;
                    AppMethodBeat.o(191529);
                    return xVar;
                }
            }

            /* JADX WARN: Incorrect args count in method signature: ()V */
            {
                this.GJt = r1;
            }

            @Override // android.support.v7.widget.RecyclerView.k
            public final void b(RecyclerView recyclerView, MotionEvent motionEvent) {
                AppMethodBeat.i(191530);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(recyclerView);
                bVar.bm(motionEvent);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/vlog/ui/plugin/VLogThumbViewPlugin$3", "android/support/v7/widget/RecyclerView$OnItemTouchListener", "onTouchEvent", "(Landroid/support/v7/widget/RecyclerView;Landroid/view/MotionEvent;)V", this, bVar.axR());
                p.h(recyclerView, "recyclerView");
                p.h(motionEvent, "event");
                Log.i(this.GJt.TAG, "onTouchEvent: " + motionEvent.getX());
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/vlog/ui/plugin/VLogThumbViewPlugin$3", "android/support/v7/widget/RecyclerView$OnItemTouchListener", "onTouchEvent", "(Landroid/support/v7/widget/RecyclerView;Landroid/view/MotionEvent;)V");
                AppMethodBeat.o(191530);
            }

            @Override // android.support.v7.widget.RecyclerView.k
            public final boolean a(RecyclerView recyclerView, MotionEvent motionEvent) {
                AppMethodBeat.i(191531);
                p.h(recyclerView, "recyclerView");
                p.h(motionEvent, "event");
                Log.i(this.GJt.TAG, "onInterceptTouchEvent: " + motionEvent.getX() + ", " + motionEvent.getAction());
                this.GJt.gZZ = motionEvent.getX();
                this.GJt.haa = motionEvent.getY();
                z.a aVar = new z.a();
                aVar.SYB = false;
                switch (motionEvent.getAction()) {
                    case 0:
                        this.GJt.GJk = false;
                        recyclerView.kQ();
                        this.GJt.GJb = false;
                        e.AbstractC1868e eVar = this.GJt.GGT;
                        if (eVar != null) {
                            eVar.pause();
                        }
                        e.AbstractC1868e eVar2 = this.GJt.GGU;
                        if (eVar2 != null) {
                            eVar2.pause();
                        }
                        this.GJt.lastClickTime = System.currentTimeMillis();
                        this.GJt.FcB = this.GJt.gZZ;
                        this.GJt.FcC = this.GJt.haa;
                        break;
                    case 1:
                    case 3:
                        this.GJt.canScroll = true;
                        if (recyclerView.getScrollState() == 0) {
                            this.GJt.GJb = true;
                            e.AbstractC1868e eVar3 = this.GJt.GGT;
                            if (eVar3 != null) {
                                eVar3.resume();
                            }
                            this.GJt.GJk = false;
                        } else {
                            this.GJt.GJk = true;
                        }
                        long currentTimeMillis = System.currentTimeMillis();
                        if (currentTimeMillis - this.GJt.lastClickTime < ((long) this.GJt.GJh) && Math.abs(this.GJt.gZZ - this.GJt.FcB) < ((float) this.GJt.rZ) && Math.abs(this.GJt.haa - this.GJt.FcC) < ((float) this.GJt.rZ) && this.GJt.GJg) {
                            this.GJt.GIZ.a(this.GJt.gZZ, new a(this, aVar));
                        }
                        this.GJt.lastClickTime = currentTimeMillis;
                        break;
                }
                boolean z = aVar.SYB;
                AppMethodBeat.o(191531);
                return z;
            }

            @Override // android.support.v7.widget.RecyclerView.k
            public final void ah(boolean z) {
            }
        });
        this.GIY = new android.support.v7.widget.a.a(new a.AbstractC0053a(this) {
            /* class com.tencent.mm.plugin.vlog.ui.plugin.ah.AnonymousClass3 */
            final /* synthetic */ ah GJt;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            {
                this.GJt = r1;
            }

            @Override // android.support.v7.widget.a.a.AbstractC0053a
            public final void f(RecyclerView.v vVar, int i2) {
                AppMethodBeat.i(191532);
                super.f(vVar, i2);
                if (!this.GJt.GJn) {
                    AppMethodBeat.o(191532);
                    return;
                }
                Log.d(this.GJt.TAG, "onSelectedChanged, viewHolder:" + vVar + ", actionState:" + i2);
                if (vVar != null) {
                    RecyclerView.LayoutManager layoutManager = this.GJt.hak.getLayoutManager();
                    if (layoutManager == null) {
                        kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type android.support.v7.widget.LinearLayoutManager");
                        AppMethodBeat.o(191532);
                        throw tVar;
                    }
                    ((LinearLayoutManager) layoutManager).ah(vVar.lR(), ((int) this.GJt.gZZ) - (com.tencent.mm.cb.a.fromDPToPix(this.GJt.hak.getContext(), 56) / 2));
                    for (h hVar : this.GJt.GJm) {
                        hVar.GOH = true;
                    }
                    this.GJt.GIX.aq(0, this.GJt.GIX.getItemCount());
                }
                if (vVar == null && i2 == 0) {
                    b bVar = this.GJt.GJj;
                    if (bVar != null) {
                        bVar.fCJ();
                    }
                    this.GJt.GJb = true;
                    for (h hVar2 : this.GJt.GJm) {
                        hVar2.GOH = false;
                    }
                    this.GJt.GIX.aq(0, this.GJt.GIX.getItemCount());
                }
                AppMethodBeat.o(191532);
            }

            @Override // android.support.v7.widget.a.a.AbstractC0053a
            public final int a(RecyclerView recyclerView, RecyclerView.v vVar) {
                AppMethodBeat.i(191533);
                p.h(recyclerView, "recyclerView");
                p.h(vVar, "viewHolder");
                if (!this.GJt.GJn) {
                    AppMethodBeat.o(191533);
                    return 0;
                }
                int db = a.AbstractC0053a.db(15);
                AppMethodBeat.o(191533);
                return db;
            }

            @Override // android.support.v7.widget.a.a.AbstractC0053a
            public final boolean a(RecyclerView recyclerView, RecyclerView.v vVar, RecyclerView.v vVar2) {
                AppMethodBeat.i(191534);
                p.h(recyclerView, "recyclerView");
                p.h(vVar, "viewHolder");
                p.h(vVar2, "target");
                if (!this.GJt.GJn) {
                    AppMethodBeat.o(191534);
                    return false;
                } else if (vVar.lU() != vVar2.lU()) {
                    AppMethodBeat.o(191534);
                    return false;
                } else {
                    int lR = vVar.lR();
                    int lR2 = vVar2.lR();
                    RecyclerView.a adapter = recyclerView.getAdapter();
                    if (adapter != null) {
                        adapter.ar(lR, lR2);
                    }
                    Collections.swap(this.GJt.GJm, lR, lR2);
                    b bVar = this.GJt.GJj;
                    if (bVar != null) {
                        bVar.fJ(lR - 1, lR2 - 1);
                    }
                    AppMethodBeat.o(191534);
                    return true;
                }
            }

            @Override // android.support.v7.widget.a.a.AbstractC0053a
            public final void N(RecyclerView.v vVar) {
                AppMethodBeat.i(191535);
                p.h(vVar, "viewHolder");
                AppMethodBeat.o(191535);
            }
        });
        this.GIY.f(this.hak);
        this.GIX.rsD = new m<Integer, h, x>(this) {
            /* class com.tencent.mm.plugin.vlog.ui.plugin.ah.AnonymousClass4 */
            final /* synthetic */ ah GJt;

            {
                this.GJt = r2;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
            @Override // kotlin.g.a.m
            public final /* synthetic */ x invoke(Integer num, h hVar) {
                AppMethodBeat.i(191536);
                num.intValue();
                h hVar2 = hVar;
                p.h(hVar2, "info");
                if (!hVar2.isEmpty() && hVar2.trackIndex >= 0) {
                    Bundle bundle = new Bundle();
                    bundle.putInt("EDIT_VLOG_SELECT_TRACK", hVar2.trackIndex);
                    this.GJt.wgr.a(d.c.BWb, bundle);
                    this.GJt.GIZ.whv = hVar2.trackIndex;
                    this.GJt.whv = hVar2.trackIndex;
                    this.GJt.GJo = hVar2.GQc.GzA.startTimeMs;
                    this.GJt.GJp = hVar2.GQc.GzA.endTimeMs;
                    this.GJt.GIX.setSelection(hVar2.trackIndex);
                }
                x xVar = x.SXb;
                AppMethodBeat.o(191536);
                return xVar;
            }
        };
        wJ(true);
        this.GJr = -1;
        AppMethodBeat.o(191548);
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
        AppMethodBeat.i(191550);
        p.h(strArr, NativeProtocol.RESULT_ARGS_PERMISSIONS);
        p.h(iArr, "grantResults");
        t.a.a(strArr, iArr);
        AppMethodBeat.o(191550);
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void onResume() {
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void reset() {
    }

    public final void wJ(boolean z) {
        AppMethodBeat.i(191539);
        this.GJg = z;
        if (z) {
            if (this.hak.getItemDecorationCount() == 1) {
                this.hak.b(this.GIZ);
                AppMethodBeat.o(191539);
                return;
            }
        } else if (this.hak.getItemDecorationCount() == 2) {
            this.hak.c(this.GIZ);
        }
        AppMethodBeat.o(191539);
    }

    public final void hS(List<Boolean> list) {
        AppMethodBeat.i(191540);
        p.h(list, "transMarkStatusList");
        this.GIZ.hS(list);
        this.hak.ls();
        AppMethodBeat.o(191540);
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void setVisibility(int i2) {
        AppMethodBeat.i(191541);
        this.GIW.setVisibility(i2);
        this.GJb = i2 == 0;
        this.uyM.setVisibility(i2);
        AppMethodBeat.o(191541);
    }

    @Override // com.tencent.mm.plugin.vlog.ui.plugin.e.d
    public final void a(ac acVar, long j2, boolean z) {
        h hVar;
        AppMethodBeat.i(191542);
        if (this.GIW.getVisibility() != 0) {
            Log.i(this.TAG, "thumbViewRoot not visible ignore update");
            AppMethodBeat.o(191542);
            return;
        }
        this.GJm.clear();
        this.GJa = 0;
        this.hwQ = 0;
        z.e eVar = new z.e();
        eVar.SYF = 0;
        this.uyM.setVisibility(0);
        if (acVar != null) {
            this.Ave = acVar.Gez.getDurationMs();
            CMTimeRange hfo = acVar.Gez.hfo();
            this.wbl = hfo.getStartUs() / 1000;
            this.GhH = hfo.getEndUs() / 1000;
            eVar.SYF = this.GhH - this.wbl;
            LinkedList<h> linkedList = this.GJm;
            ArrayList arrayList = new ArrayList();
            int i2 = 0;
            for (T t : acVar.fBD()) {
                int i3 = i2 + 1;
                if (i2 < 0) {
                    j.hxH();
                }
                T t2 = t;
                if (t2.GzA.endTimeMs < this.wbl || t2.GzA.startTimeMs > this.GhH) {
                    hVar = null;
                } else {
                    h hVar2 = new h(t2);
                    hVar2.trackIndex = i2;
                    long j3 = this.wbl;
                    long j4 = this.GhH;
                    if (hVar2.GQc.GzA.startTimeMs < j3) {
                        hVar2.GOD = ((long) (((float) (j3 - hVar2.GQc.GzA.startTimeMs)) * hVar2.GQc.GzA.mwH)) + hVar2.GQc.GzA.GGz;
                    }
                    if (hVar2.GQc.GzA.endTimeMs > j4) {
                        hVar2.GOE = hVar2.GQc.GzA.GGA - ((long) (((float) (hVar2.GQc.GzA.endTimeMs - j4)) * hVar2.GQc.GzA.mwH));
                    }
                    hVar2.height = this.thumbHeight;
                    hVar2.width = this.thumbWidth;
                    hVar = hVar2;
                }
                if (hVar != null) {
                    arrayList.add(hVar);
                    i2 = i3;
                } else {
                    i2 = i3;
                }
            }
            linkedList.addAll(arrayList);
        }
        Log.i(this.TAG, "onUpdate, duration:" + (this.GhH - this.wbl) + ", visibility:" + this.GIW.getVisibility() + " seekTo:" + j2 + " seekToOrigin:" + z);
        this.hak.removeCallbacks(this.GJd);
        this.GJd = new d(this, eVar, j2, z);
        this.GJl = false;
        this.GJb = false;
        this.GJc = this.FVU;
        this.FVU = 0;
        this.vKp.ah(0, 0);
        Runnable runnable = this.GJd;
        if (runnable != null) {
            runnable.run();
            AppMethodBeat.o(191542);
            return;
        }
        AppMethodBeat.o(191542);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class d implements Runnable {
        final /* synthetic */ ah GJt;
        final /* synthetic */ z.e GJw;
        final /* synthetic */ long GJx;
        final /* synthetic */ boolean GJy;

        d(ah ahVar, z.e eVar, long j2, boolean z) {
            this.GJt = ahVar;
            this.GJw = eVar;
            this.GJx = j2;
            this.GJy = z;
        }

        public final void run() {
            AppMethodBeat.i(191538);
            int width = this.GJt.GIW.getWidth();
            int height = (this.GJt.hak.getHeight() - this.GJt.hak.getPaddingTop()) - this.GJt.hak.getPaddingBottom();
            if (width <= 0 || height <= 0) {
                this.GJt.hak.post(this.GJt.GJd);
                AppMethodBeat.o(191538);
                return;
            }
            float f2 = (((float) height) * 1.0f) / ((float) this.GJt.thumbHeight);
            float f3 = ((float) width) / (((float) this.GJt.thumbWidth) * f2);
            float f4 = ((float) this.GJw.SYF) / 1000.0f < f3 ? ((float) this.GJw.SYF) / f3 : 1000.0f;
            this.GJt.GJa = 0;
            for (h hVar : this.GJt.GJm) {
                hVar.GOF = (((float) hVar.fEu()) / f4) / hVar.GQc.GzA.mwH;
                hVar.fEv();
                ah ahVar = this.GJt;
                ahVar.GJa = ((int) (((float) hVar.width) * hVar.GOF * f2)) + ahVar.GJa;
            }
            this.GJt.Avf = (((float) this.GJt.GJa) * 1.0f) / ((float) (this.GJt.GhH - this.GJt.wbl));
            h hVar2 = this.GJt.GJe;
            int i2 = width / 2;
            ViewGroup.LayoutParams layoutParams = this.GJt.hak.getLayoutParams();
            if (layoutParams == null) {
                kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type android.support.constraint.ConstraintLayout.LayoutParams");
                AppMethodBeat.o(191538);
                throw tVar;
            }
            hVar2.hEp = i2 - ((ConstraintLayout.LayoutParams) layoutParams).getMarginStart();
            this.GJt.GJf.hEp = width / 2;
            if (!p.j((h) j.L(this.GJt.GJm, 0), this.GJt.GJe)) {
                this.GJt.GJm.add(0, this.GJt.GJe);
                this.GJt.GJm.add(this.GJt.GJf);
            }
            this.GJt.GIX.hw(this.GJt.GJm);
            this.GJt.GIX.notifyDataSetChanged();
            this.GJt.hak.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
            this.GJt.GJl = true;
            if (this.GJx != -1) {
                int i3 = (int) (((float) (this.GJx - this.GJt.wbl)) * this.GJt.Avf);
                this.GJt.FVU = i3;
                this.GJt.vKp.ah(0, -i3);
                AppMethodBeat.o(191538);
                return;
            }
            if (this.GJy) {
                this.GJt.FVU = this.GJt.GJc;
                this.GJt.vKp.ah(0, -this.GJt.GJc);
            }
            AppMethodBeat.o(191538);
        }
    }

    @Override // com.tencent.mm.plugin.vlog.ui.plugin.e.c
    public final void a(e.AbstractC1868e eVar) {
        AppMethodBeat.i(191543);
        this.GGT = eVar;
        Log.i(this.TAG, "onStart: ");
        if (this.GIW.getVisibility() == 8) {
            Log.i(this.TAG, "onStart thumbViewRoot not visible ignore");
            AppMethodBeat.o(191543);
            return;
        }
        this.GJb = true;
        this.canScroll = true;
        AppMethodBeat.o(191543);
    }

    @Override // com.tencent.mm.plugin.vlog.ui.plugin.e.c
    public final void onProgress(long j2) {
        AppMethodBeat.i(191544);
        if (this.GJr <= 0 || Util.ticksToNow(this.GJr) >= 1000) {
            Log.d(this.TAG, "onProgress: " + j2 + ", enableAutoScroll:" + this.GJb);
            this.GJr = Util.currentTicks();
        }
        if (!this.GIW.isShown()) {
            Log.i(this.TAG, "onProgress thumbViewRoot not visible ignore");
            AppMethodBeat.o(191544);
            return;
        }
        com.tencent.mm.ac.d.h(new c(this, j2));
        AppMethodBeat.o(191544);
    }

    private void clearFocus() {
        AppMethodBeat.i(191545);
        this.GIX.setSelection(-1);
        this.GIZ.whv = -1;
        AppMethodBeat.o(191545);
    }

    public final void q(int i2, long j2, long j3) {
        AppMethodBeat.i(191546);
        Log.i(this.TAG, "selectTrack:".concat(String.valueOf(i2)));
        this.whv = i2;
        this.GJo = j2;
        this.GJp = j3;
        if (i2 == -1) {
            clearFocus();
            AppMethodBeat.o(191546);
            return;
        }
        this.GIX.setSelection(i2);
        AppMethodBeat.o(191546);
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void release() {
        AppMethodBeat.i(191547);
        int childCount = this.hak.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = this.hak.getChildAt(i2);
            if (childAt instanceof FrameListView) {
                ((FrameListView) childAt).release();
            }
        }
        c.a aVar = com.tencent.mm.videocomposition.c.RgU;
        com.tencent.mm.videocomposition.c.Asq.evictAll();
        AppMethodBeat.o(191547);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, hxF = {"Lcom/tencent/mm/plugin/vlog/ui/plugin/VLogThumbViewPlugin$Companion;", "", "()V", "ThumbHeight", "", "ThumbWidth", "plugin-vlog_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class c extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ ah GJt;
        final /* synthetic */ long wfK;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(ah ahVar, long j2) {
            super(0);
            this.GJt = ahVar;
            this.wfK = j2;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(191537);
            if (this.GJt.GJb) {
                if (this.wfK == this.GJt.wbl) {
                    this.GJt.vKp.ah(0, 0);
                    this.GJt.FVU = 0;
                } else {
                    this.GJt.hak.smoothScrollBy(((int) ((((float) ((this.wfK - this.GJt.wbl) * ((long) this.GJt.GJa))) * 1.0f) / ((float) (this.GJt.GhH - this.GJt.wbl)))) - this.GJt.FVU, 0);
                }
                this.GJt.hwQ = this.wfK;
            }
            x xVar = x.SXb;
            AppMethodBeat.o(191537);
            return xVar;
        }
    }

    public static final /* synthetic */ o v(ah ahVar) {
        AppMethodBeat.i(191551);
        float f2 = (((((float) ahVar.GJo) * 1.0f) / ((float) ahVar.Ave)) * ((float) ahVar.GJa)) - ((float) (ahVar.GIZ.GOa / 2));
        float f3 = (((((float) ahVar.GJp) * 1.0f) / ((float) ahVar.Ave)) * ((float) ahVar.GJa)) + ((float) (ahVar.GIZ.GOa / 2));
        Log.d(ahVar.TAG, "startOffset:" + f2 + ", endOffset:" + f3 + ", totalWith:" + ahVar.GJa + ", scrollX:" + ahVar.FVU);
        o oVar = new o(Float.valueOf(f2), Float.valueOf(f3));
        AppMethodBeat.o(191551);
        return oVar;
    }
}

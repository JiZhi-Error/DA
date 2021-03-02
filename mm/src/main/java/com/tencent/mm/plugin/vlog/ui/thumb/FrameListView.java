package com.tencent.mm.plugin.vlog.ui.thumb;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.vlog.model.t;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.videocomposition.g;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.ResultKt;
import kotlin.d.b.a.f;
import kotlin.d.b.a.j;
import kotlin.d.d;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;
import kotlinx.coroutines.ai;
import kotlinx.coroutines.ba;
import kotlinx.coroutines.bn;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\b\u0010-\u001a\u00020.H\u0002J\u0016\u0010/\u001a\u00020.2\u0006\u00100\u001a\u00020\u00192\u0006\u00101\u001a\u00020\u0019J\u0016\u00102\u001a\u00020.2\u0006\u00100\u001a\u00020\u00192\u0006\u00101\u001a\u00020\u0019J\u0010\u00103\u001a\u00020.2\u0006\u00104\u001a\u000205H\u0014J\u0018\u00106\u001a\u00020.2\u0006\u00107\u001a\u00020\t2\u0006\u00108\u001a\u00020\tH\u0014J\u0006\u00109\u001a\u00020.J\u0010\u0010:\u001a\u00020.2\b\u0010;\u001a\u0004\u0018\u00010#J\u000e\u0010<\u001a\u00020.2\u0006\u0010$\u001a\u00020%J\u0006\u0010=\u001a\u00020.J\u000e\u0010>\u001a\u00020.2\u0006\u0010?\u001a\u00020,R\u000e\u0010\u000b\u001a\u00020\fXD¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0019X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0019X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0019X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0015X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010!X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u0004\u0018\u00010#X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020%X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010&\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00170'X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020)X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010+\u001a\u0004\u0018\u00010,X\u000e¢\u0006\u0002\n\u0000¨\u0006@"}, hxF = {"Lcom/tencent/mm/plugin/vlog/ui/thumb/FrameListView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "centerMatrix", "Landroid/graphics/Matrix;", "clipOffset", "", "clipPath", "Landroid/graphics/Path;", "clipRadius", "clipRect", "Landroid/graphics/RectF;", "firstThumb", "Landroid/graphics/Bitmap;", "noClipLeft", "", "noClipRight", "noRadiusLeft", "noRadiusRight", "paint", "Landroid/graphics/Paint;", "thumbDrawRect", "thumbFetcher", "Lcom/tencent/mm/videocomposition/ITrackThumbFetcher;", "thumbFetcherExtraData", "", "thumbFetcherFactory", "Lcom/tencent/mm/plugin/vlog/ui/thumb/ThumbFetcherFactory;", "thumbList", "Ljava/util/LinkedList;", "thumbRect", "Landroid/graphics/Rect;", "thumbScale", "trackInfo", "Lcom/tencent/mm/plugin/vlog/ui/thumb/BaseTrackThumbInfo;", "clearThumbs", "", "noClip", "left", "right", "noRadius", "onDraw", "canvas", "Landroid/graphics/Canvas;", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "release", "setThumbFetcherExtraData", "data", "setThumbFetcherFactory", "setToDefaultThumbFetcherFactory", "setTrackInfo", "info", "plugin-vlog_release"})
public final class FrameListView extends View {
    private g Avo;
    private final Rect COM;
    private LinkedList<Bitmap> GOW;
    private Bitmap GOX;
    private float GOY;
    private final RectF GOZ;
    private boolean GPa;
    private boolean GPb;
    private boolean GPc;
    private boolean GPd;
    private final RectF GPe;
    private final float GPf;
    private final float GPg;
    private a GPs;
    private Object GPt;
    private final String TAG;
    private final Paint paint;
    private final Path rqV;
    private g vNj;
    private final Matrix xnd;

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@¢\u0006\u0004\b\u0003\u0010\u0004"}, hxF = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"})
    @f(c = "com.tencent.mm.plugin.vlog.ui.thumb.FrameListView$setTrackInfo$2", f = "FrameListView.kt", hxM = {109}, m = "invokeSuspend")
    public static final class a extends j implements m<ai, d<? super x>, Object> {
        final /* synthetic */ FrameListView GPu;
        Object L$0;
        int label;
        private ai p$;
        Object pED;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(FrameListView frameListView, d dVar) {
            super(2, dVar);
            this.GPu = frameListView;
        }

        @Override // kotlin.d.b.a.a
        public final d<x> create(Object obj, d<?> dVar) {
            AppMethodBeat.i(192087);
            p.h(dVar, "completion");
            a aVar = new a(this.GPu, dVar);
            aVar.p$ = (ai) obj;
            AppMethodBeat.o(192087);
            return aVar;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.g.a.m
        public final Object invoke(ai aiVar, d<? super x> dVar) {
            AppMethodBeat.i(192088);
            Object invokeSuspend = ((a) create(aiVar, dVar)).invokeSuspend(x.SXb);
            AppMethodBeat.o(192088);
            return invokeSuspend;
        }

        /* access modifiers changed from: package-private */
        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\n¢\u0006\u0002\b\u0006¨\u0006\u0007"}, hxF = {"<anonymous>", "", "timeMs", "", "bitmap", "Landroid/graphics/Bitmap;", "invoke", "com/tencent/mm/plugin/vlog/ui/thumb/FrameListView$setTrackInfo$2$1$1"})
        /* renamed from: com.tencent.mm.plugin.vlog.ui.thumb.FrameListView$a$a  reason: collision with other inner class name */
        public static final class C1882a extends q implements m<Long, Bitmap, x> {
            final /* synthetic */ ai GPo;
            final /* synthetic */ a GPv;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            C1882a(a aVar, ai aiVar) {
                super(2);
                this.GPv = aVar;
                this.GPo = aiVar;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
            @Override // kotlin.g.a.m
            public final /* synthetic */ x invoke(Long l, Bitmap bitmap) {
                AppMethodBeat.i(192081);
                l.longValue();
                this.GPv.GPu.GOX = bitmap;
                x xVar = x.SXb;
                AppMethodBeat.o(192081);
                return xVar;
            }
        }

        /* access modifiers changed from: package-private */
        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\n¢\u0006\u0002\b\u0006¨\u0006\u0007"}, hxF = {"<anonymous>", "", "timeMs", "", "bitmap", "Landroid/graphics/Bitmap;", "invoke", "com/tencent/mm/plugin/vlog/ui/thumb/FrameListView$setTrackInfo$2$1$3"})
        public static final class b extends q implements m<Long, Bitmap, x> {
            final /* synthetic */ ai GPo;
            final /* synthetic */ a GPv;
            final /* synthetic */ a GPw;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            b(a aVar, a aVar2, ai aiVar) {
                super(2);
                this.GPw = aVar;
                this.GPv = aVar2;
                this.GPo = aiVar;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
            @Override // kotlin.g.a.m
            public final /* synthetic */ x invoke(Long l, Bitmap bitmap) {
                int i2 = 0;
                AppMethodBeat.i(192082);
                long longValue = l.longValue();
                Bitmap bitmap2 = bitmap;
                String str = this.GPv.GPu.TAG;
                StringBuilder append = new StringBuilder("setTrackInfo: ").append(longValue).append(", ");
                g gVar = this.GPv.GPu.vNj;
                Log.i(str, append.append(gVar != null ? gVar.hashCode() : 0).toString());
                for (T t : this.GPw.GOG) {
                    int i3 = i2 + 1;
                    if (i2 < 0) {
                        kotlin.a.j.hxH();
                    }
                    if (t.Asv == longValue && i2 >= 0 && i2 < this.GPv.GPu.GOW.size()) {
                        this.GPv.GPu.GOW.set(i2, bitmap2);
                        this.GPv.GPu.postInvalidate();
                    }
                    i2 = i3;
                }
                x xVar = x.SXb;
                AppMethodBeat.o(192082);
                return xVar;
            }
        }

        /* access modifiers changed from: package-private */
        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, hxF = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "com/tencent/mm/plugin/vlog/ui/thumb/FrameListView$setTrackInfo$2$1$4"})
        public static final class c extends j implements m<ai, d<? super x>, Object> {
            final /* synthetic */ ai GPo;
            final /* synthetic */ a GPv;
            int label;
            private ai p$;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            c(d dVar, a aVar, ai aiVar) {
                super(2, dVar);
                this.GPv = aVar;
                this.GPo = aiVar;
            }

            @Override // kotlin.d.b.a.a
            public final d<x> create(Object obj, d<?> dVar) {
                AppMethodBeat.i(192084);
                p.h(dVar, "completion");
                c cVar = new c(dVar, this.GPv, this.GPo);
                cVar.p$ = (ai) obj;
                AppMethodBeat.o(192084);
                return cVar;
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
            @Override // kotlin.g.a.m
            public final Object invoke(ai aiVar, d<? super x> dVar) {
                AppMethodBeat.i(192085);
                Object invokeSuspend = ((c) create(aiVar, dVar)).invokeSuspend(x.SXb);
                AppMethodBeat.o(192085);
                return invokeSuspend;
            }

            @Override // kotlin.d.b.a.a
            public final Object invokeSuspend(Object obj) {
                AppMethodBeat.i(192083);
                kotlin.d.a.a aVar = kotlin.d.a.a.COROUTINE_SUSPENDED;
                switch (this.label) {
                    case 0:
                        ResultKt.throwOnFailure(obj);
                        this.GPv.GPu.requestLayout();
                        x xVar = x.SXb;
                        AppMethodBeat.o(192083);
                        return xVar;
                    default:
                        IllegalStateException illegalStateException = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        AppMethodBeat.o(192083);
                        throw illegalStateException;
                }
            }
        }

        @Override // kotlin.d.b.a.a
        public final Object invokeSuspend(Object obj) {
            AppMethodBeat.i(192086);
            kotlin.d.a.a aVar = kotlin.d.a.a.COROUTINE_SUSPENDED;
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure(obj);
                    ai aiVar = this.p$;
                    Log.i(this.GPu.TAG, aiVar.hashCode() + " setTrackInfo launch");
                    a aVar2 = this.GPu.GPs;
                    if (aVar2 != null) {
                        Log.i(this.GPu.TAG, aiVar.hashCode() + " setTrackInfo init thumb fetcher");
                        g gVar = this.GPu.vNj;
                        if (gVar != null) {
                            gVar.destroy();
                        }
                        this.GPu.vNj = this.GPu.Avo.a(aVar2, this.GPu.GPt);
                        g gVar2 = this.GPu.vNj;
                        if (gVar2 != null) {
                            gVar2.setSize(aVar2.width, aVar2.height);
                        }
                        Log.i(this.GPu.TAG, aiVar.hashCode() + " setTrackInfo finish init thumb fetcher, frames.size:" + aVar2.GOG.size());
                        g gVar3 = this.GPu.vNj;
                        if (gVar3 != null) {
                            gVar3.b(kotlin.a.j.listOf(kotlin.d.b.a.b.Pe(0)), new C1882a(this, aiVar));
                        }
                        g gVar4 = this.GPu.vNj;
                        if (gVar4 != null) {
                            LinkedList<e> linkedList = aVar2.GOG;
                            ArrayList arrayList = new ArrayList(kotlin.a.j.a(linkedList, 10));
                            Iterator<T> it = linkedList.iterator();
                            while (it.hasNext()) {
                                arrayList.add(kotlin.d.b.a.b.Pe(it.next().Asv));
                            }
                            gVar4.b(arrayList, new b(aVar2, this, aiVar));
                        }
                        Log.i(this.GPu.TAG, aiVar.hashCode() + " setTrackInfo request layout");
                        if (!this.GPu.isInLayout() || aVar2.GOH) {
                            this.L$0 = aiVar;
                            this.pED = aVar2;
                            this.label = 1;
                            if (kotlinx.coroutines.g.a(ba.hMV(), new c(null, this, aiVar), this) == aVar) {
                                AppMethodBeat.o(192086);
                                return aVar;
                            }
                        }
                    }
                    break;
                case 1:
                    ResultKt.throwOnFailure(obj);
                    break;
                default:
                    IllegalStateException illegalStateException = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    AppMethodBeat.o(192086);
                    throw illegalStateException;
            }
            x xVar = x.SXb;
            AppMethodBeat.o(192086);
            return xVar;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FrameListView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        p.h(context, "context");
        AppMethodBeat.i(192095);
        this.TAG = "MicroMsg.FrameListView";
        this.paint = new Paint();
        this.GOW = new LinkedList<>();
        this.GOY = 1.0f;
        this.COM = new Rect();
        this.GOZ = new RectF();
        this.xnd = new Matrix();
        this.rqV = new Path();
        this.GPe = new RectF();
        this.GPf = (float) com.tencent.mm.cb.a.fromDPToPix(context, 4);
        this.GPg = (float) com.tencent.mm.cb.a.fromDPToPix(context, 4);
        this.Avo = new b();
        this.paint.setColor(-65536);
        this.paint.setAntiAlias(true);
        AppMethodBeat.o(192095);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public FrameListView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        p.h(context, "context");
        AppMethodBeat.i(192096);
        AppMethodBeat.o(192096);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public FrameListView(Context context) {
        this(context, null);
        p.h(context, "context");
        AppMethodBeat.i(192097);
        AppMethodBeat.o(192097);
    }

    public final void setThumbFetcherFactory(g gVar) {
        AppMethodBeat.i(192089);
        p.h(gVar, "thumbFetcherFactory");
        this.Avo = gVar;
        fEw();
        AppMethodBeat.o(192089);
    }

    public final void setThumbFetcherExtraData(Object obj) {
        this.GPt = obj;
    }

    public final void setTrackInfo(a aVar) {
        LinkedList<e> linkedList;
        AppMethodBeat.i(192090);
        p.h(aVar, "info");
        this.GPs = aVar;
        this.GOW.clear();
        a aVar2 = this.GPs;
        if (!(aVar2 == null || (linkedList = aVar2.GOG) == null)) {
            Iterator<T> it = linkedList.iterator();
            while (it.hasNext()) {
                it.next();
                this.GOW.add(null);
            }
        }
        kotlinx.coroutines.f.b(bn.TUK, ba.hMW(), new a(this, null), 2);
        AppMethodBeat.o(192090);
    }

    private final void fEw() {
        AppMethodBeat.i(192091);
        Log.i(this.TAG, "clearThumb");
        this.GOW.clear();
        this.GOX = null;
        postInvalidate();
        AppMethodBeat.o(192091);
    }

    public final void aC(boolean z, boolean z2) {
        this.GPa = z;
        this.GPb = z2;
    }

    public final void aD(boolean z, boolean z2) {
        this.GPc = z;
        this.GPd = z2;
    }

    /* access modifiers changed from: protected */
    public final void onMeasure(int i2, int i3) {
        float f2 = 0.0f;
        AppMethodBeat.i(192092);
        int defaultSize = View.getDefaultSize(getSuggestedMinimumHeight(), i3);
        this.GOZ.bottom = (float) defaultSize;
        int defaultSize2 = View.getDefaultSize(getSuggestedMinimumWidth(), i2);
        a aVar = this.GPs;
        if (aVar != null) {
            this.COM.right = aVar.width;
            this.COM.bottom = aVar.height;
            this.GOY = (((float) defaultSize) * 1.0f) / ((float) aVar.height);
            this.GOZ.right = this.GOY * ((float) aVar.width);
            defaultSize2 = (int) (this.GOZ.right * aVar.GOF);
        }
        a aVar2 = this.GPs;
        if (aVar2 != null && aVar2.GOH) {
            Matrix matrix = this.xnd;
            float f3 = (float) defaultSize;
            p.h(matrix, "$this$setRectToRectCenterCrop");
            t.a(matrix, new RectF(0.0f, 0.0f, (float) this.COM.right, (float) this.COM.bottom), new RectF(0.0f, 0.0f, f3, f3));
            defaultSize2 = defaultSize;
        }
        if (this.GPa) {
            this.GPe.left = 0.0f;
        } else {
            this.GPe.left = this.GPg;
        }
        if (this.GPb) {
            this.GPe.right = (float) defaultSize2;
        } else {
            this.GPe.right = ((float) defaultSize2) - this.GPg;
        }
        String str = this.TAG;
        StringBuilder append = new StringBuilder("onMeasure: ").append(this.GPa).append(' ').append(this.GPb).append(", ").append(defaultSize2).append(' ').append(defaultSize).append(", thumbScale:").append(this.GOY).append(", trackInfo.width:");
        a aVar3 = this.GPs;
        Log.i(str, append.append(aVar3 != null ? Integer.valueOf(aVar3.width) : null).append(", thumbDrawRect.right:").append(this.GOZ.right).toString());
        this.GPe.bottom = (float) defaultSize;
        this.rqV.reset();
        float f4 = this.GPc ? 0.0f : this.GPf;
        if (!this.GPd) {
            f2 = this.GPf;
        }
        this.rqV.addRoundRect(this.GPe, new float[]{f4, f4, f2, f2, f2, f2, f4, f4}, Path.Direction.CW);
        setMeasuredDimension(defaultSize2, defaultSize);
        AppMethodBeat.o(192092);
    }

    /* access modifiers changed from: protected */
    public final void onDraw(Canvas canvas) {
        AppMethodBeat.i(192093);
        p.h(canvas, "canvas");
        super.onDraw(canvas);
        Log.i(this.TAG, "onDraw, trackInfo:" + this.GPs + ", thumbList.size:" + this.GOW.size());
        canvas.save();
        canvas.clipPath(this.rqV);
        a aVar = this.GPs;
        if (aVar == null || !aVar.GOH) {
            for (T t : this.GOW) {
                if (t != null) {
                    canvas.drawBitmap(t, this.COM, this.GOZ, this.paint);
                } else {
                    Bitmap bitmap = this.GOX;
                    if (bitmap != null) {
                        canvas.drawBitmap(bitmap, this.COM, this.GOZ, this.paint);
                    }
                }
                canvas.translate(this.GOZ.right, 0.0f);
            }
        } else {
            Bitmap bitmap2 = (Bitmap) kotlin.a.j.L(this.GOW, 0);
            if (bitmap2 != null) {
                canvas.concat(this.xnd);
                canvas.drawBitmap(bitmap2, 0.0f, 0.0f, this.paint);
            }
        }
        canvas.restore();
        Drawable background = getBackground();
        if (background != null) {
            background.setBounds((int) this.GPe.left, (int) this.GPe.top, (int) this.GPe.right, (int) this.GPe.bottom);
            background.draw(canvas);
            AppMethodBeat.o(192093);
            return;
        }
        AppMethodBeat.o(192093);
    }

    public final void release() {
        AppMethodBeat.i(192094);
        g gVar = this.vNj;
        if (gVar != null) {
            gVar.destroy();
        }
        this.vNj = null;
        this.GPs = null;
        fEw();
        AppMethodBeat.o(192094);
    }
}

package com.tencent.mm.plugin.vlog.ui.thumb;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.videocomposition.c;
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

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 K2\u00020\u0001:\u0001KB\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0016\u0010<\u001a\u00020=2\u0006\u0010>\u001a\u00020 2\u0006\u0010?\u001a\u00020 J\u0016\u0010@\u001a\u00020=2\u0006\u0010>\u001a\u00020 2\u0006\u0010?\u001a\u00020 J\u0010\u0010A\u001a\u00020=2\u0006\u0010B\u001a\u00020CH\u0014J\u0018\u0010D\u001a\u00020=2\u0006\u0010E\u001a\u00020\t2\u0006\u0010F\u001a\u00020\tH\u0014J\u0006\u0010G\u001a\u00020=J&\u0010H\u001a\u00020=2\u0006\u0010I\u001a\u0002092\u0006\u0010J\u001a\u00020\t2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020 R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0014\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u000e\u0010\u0019\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bXD¢\u0006\u0002\n\u0000R\u001a\u0010\u001c\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0016\"\u0004\b\u001e\u0010\u0018R\u000e\u0010\u001f\u001a\u00020 X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020 X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020 X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020 X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020%X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010'\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u0016\"\u0004\b)\u0010\u0018R\u000e\u0010*\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010+\u001a\u0004\u0018\u00010,X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010-\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00130.X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u000200X\u0004¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u001a\u00102\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010\u0016\"\u0004\b4\u0010\u0018R\u001a\u00105\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u0010\u0016\"\u0004\b7\u0010\u0018R\u0010\u00108\u001a\u0004\u0018\u000109X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010:\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b;\u0010\u0016¨\u0006L"}, hxF = {"Lcom/tencent/mm/plugin/vlog/ui/thumb/EditFrameListView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "clipOffset", "", "clipPath", "Landroid/graphics/Path;", "clipRadius", "clipRect", "Landroid/graphics/RectF;", "firstThumb", "Landroid/graphics/Bitmap;", "frameWidth", "getFrameWidth", "()I", "setFrameWidth", "(I)V", "leftExtend", "minDuration", "", "minWidth", "getMinWidth", "setMinWidth", "noClipLeft", "", "noClipRight", "noRadiusLeft", "noRadiusRight", "paint", "Landroid/graphics/Paint;", "rightExtend", "showWidth", "getShowWidth", "setShowWidth", "thumbDrawRect", "thumbFetcher", "Lcom/tencent/mm/videocomposition/ITrackThumbFetcher;", "thumbList", "Ljava/util/LinkedList;", "thumbRect", "Landroid/graphics/Rect;", "thumbScale", "totalFrameWidth", "getTotalFrameWidth", "setTotalFrameWidth", "totalWidth", "getTotalWidth", "setTotalWidth", "trackInfo", "Lcom/tencent/mm/plugin/vlog/ui/thumb/TrackThumbInfo;", "validWidth", "getValidWidth", "noClip", "", "left", "right", "noRadius", "onDraw", "canvas", "Landroid/graphics/Canvas;", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "release", "setTrackInfo", "info", "parentHeight", "Companion", "plugin-vlog_release"})
public final class EditFrameListView extends View {
    public static final a GPl = new a((byte) 0);
    private final Rect COM;
    private int GJa;
    private h GOV;
    private LinkedList<Bitmap> GOW;
    private Bitmap GOX;
    private float GOY;
    private final RectF GOZ;
    boolean GPa;
    boolean GPb;
    boolean GPc;
    boolean GPd;
    private final RectF GPe;
    private final float GPf;
    private final float GPg;
    private int GPh;
    private int GPi;
    private int GPj;
    private int GPk;
    private int kxW;
    private int minWidth;
    private final Paint paint;
    private final Path rqV;
    private final long tXD;
    g vNj;

    static {
        AppMethodBeat.i(192065);
        AppMethodBeat.o(192065);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@¢\u0006\u0004\b\u0003\u0010\u0004"}, hxF = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"})
    @f(c = "com.tencent.mm.plugin.vlog.ui.thumb.EditFrameListView$setTrackInfo$2", f = "EditFrameListView.kt", hxM = {}, m = "invokeSuspend")
    static final class b extends j implements m<ai, d<? super x>, Object> {
        final /* synthetic */ EditFrameListView GPm;
        int label;
        private ai p$;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(EditFrameListView editFrameListView, d dVar) {
            super(2, dVar);
            this.GPm = editFrameListView;
        }

        @Override // kotlin.d.b.a.a
        public final d<x> create(Object obj, d<?> dVar) {
            AppMethodBeat.i(192057);
            p.h(dVar, "completion");
            b bVar = new b(this.GPm, dVar);
            bVar.p$ = (ai) obj;
            AppMethodBeat.o(192057);
            return bVar;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.g.a.m
        public final Object invoke(ai aiVar, d<? super x> dVar) {
            AppMethodBeat.i(192058);
            Object invokeSuspend = ((b) create(aiVar, dVar)).invokeSuspend(x.SXb);
            AppMethodBeat.o(192058);
            return invokeSuspend;
        }

        /* access modifiers changed from: package-private */
        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\n¢\u0006\u0002\b\u0006¨\u0006\u0007"}, hxF = {"<anonymous>", "", "<anonymous parameter 0>", "", "bitmap", "Landroid/graphics/Bitmap;", "invoke", "com/tencent/mm/plugin/vlog/ui/thumb/EditFrameListView$setTrackInfo$2$1$1"})
        public static final class a extends q implements m<Long, Bitmap, x> {
            final /* synthetic */ b GPn;
            final /* synthetic */ ai GPo;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(b bVar, ai aiVar) {
                super(2);
                this.GPn = bVar;
                this.GPo = aiVar;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
            @Override // kotlin.g.a.m
            public final /* synthetic */ x invoke(Long l, Bitmap bitmap) {
                AppMethodBeat.i(192054);
                l.longValue();
                this.GPn.GPm.GOX = bitmap;
                x xVar = x.SXb;
                AppMethodBeat.o(192054);
                return xVar;
            }
        }

        /* access modifiers changed from: package-private */
        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\n¢\u0006\u0002\b\u0006¨\u0006\u0007"}, hxF = {"<anonymous>", "", "timeMs", "", "bitmap", "Landroid/graphics/Bitmap;", "invoke", "com/tencent/mm/plugin/vlog/ui/thumb/EditFrameListView$setTrackInfo$2$1$3"})
        /* renamed from: com.tencent.mm.plugin.vlog.ui.thumb.EditFrameListView$b$b  reason: collision with other inner class name */
        public static final class C1881b extends q implements m<Long, Bitmap, x> {
            final /* synthetic */ h GOR;
            final /* synthetic */ b GPn;
            final /* synthetic */ ai GPo;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            C1881b(h hVar, b bVar, ai aiVar) {
                super(2);
                this.GOR = hVar;
                this.GPn = bVar;
                this.GPo = aiVar;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
            @Override // kotlin.g.a.m
            public final /* synthetic */ x invoke(Long l, Bitmap bitmap) {
                int i2 = 0;
                AppMethodBeat.i(192055);
                long longValue = l.longValue();
                Bitmap bitmap2 = bitmap;
                StringBuilder append = new StringBuilder("setTrackInfo: ").append(longValue).append(", ");
                g gVar = this.GPn.GPm.vNj;
                Log.i("MicroMsg.EditFrameListView", append.append(gVar != null ? gVar.hashCode() : 0).toString());
                for (T t : this.GOR.GOG) {
                    int i3 = i2 + 1;
                    if (i2 < 0) {
                        kotlin.a.j.hxH();
                    }
                    if (t.Asv == longValue && i2 >= 0 && i2 < this.GPn.GPm.GOW.size()) {
                        this.GPn.GPm.GOW.set(i2, bitmap2);
                        this.GPn.GPm.postInvalidate();
                    }
                    i2 = i3;
                }
                x xVar = x.SXb;
                AppMethodBeat.o(192055);
                return xVar;
            }
        }

        @Override // kotlin.d.b.a.a
        public final Object invokeSuspend(Object obj) {
            AppMethodBeat.i(192056);
            kotlin.d.a.a aVar = kotlin.d.a.a.COROUTINE_SUSPENDED;
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure(obj);
                    ai aiVar = this.p$;
                    Log.i("MicroMsg.EditFrameListView", aiVar.hashCode() + " setTrackInfo launch");
                    h hVar = this.GPm.GOV;
                    if (hVar != null) {
                        Log.i("MicroMsg.EditFrameListView", aiVar.hashCode() + " setTrackInfo init thumb fetcher");
                        g gVar = this.GPm.vNj;
                        if (gVar != null) {
                            gVar.destroy();
                        }
                        EditFrameListView editFrameListView = this.GPm;
                        c.a aVar2 = c.RgU;
                        editFrameListView.vNj = c.a.b(hVar.GQc.GzA);
                        g gVar2 = this.GPm.vNj;
                        if (gVar2 != null) {
                            gVar2.setSize(hVar.width, hVar.height);
                        }
                        Log.i("MicroMsg.EditFrameListView", aiVar.hashCode() + " setTrackInfo finish init thumb fetcher, frames.size:" + hVar.GOG.size());
                        g gVar3 = this.GPm.vNj;
                        if (gVar3 != null) {
                            gVar3.b(kotlin.a.j.listOf(kotlin.d.b.a.b.Pe(0)), new a(this, aiVar));
                        }
                        g gVar4 = this.GPm.vNj;
                        if (gVar4 != null) {
                            LinkedList<e> linkedList = hVar.GOG;
                            ArrayList arrayList = new ArrayList(kotlin.a.j.a(linkedList, 10));
                            Iterator<T> it = linkedList.iterator();
                            while (it.hasNext()) {
                                arrayList.add(kotlin.d.b.a.b.Pe(it.next().Asv));
                            }
                            gVar4.b(arrayList, new C1881b(hVar, this, aiVar));
                        }
                    }
                    x xVar = x.SXb;
                    AppMethodBeat.o(192056);
                    return xVar;
                default:
                    IllegalStateException illegalStateException = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    AppMethodBeat.o(192056);
                    throw illegalStateException;
            }
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public EditFrameListView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        p.h(context, "context");
        AppMethodBeat.i(192063);
        this.paint = new Paint();
        this.GOW = new LinkedList<>();
        this.GOY = 1.0f;
        this.COM = new Rect();
        this.GOZ = new RectF();
        this.rqV = new Path();
        this.GPe = new RectF();
        this.GPf = (float) com.tencent.mm.cb.a.fromDPToPix(context, 4);
        this.GPg = (float) com.tencent.mm.cb.a.fromDPToPix(context, 4);
        this.tXD = 3000;
        this.paint.setColor(-65536);
        this.paint.setAntiAlias(true);
        AppMethodBeat.o(192063);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public EditFrameListView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        p.h(context, "context");
        AppMethodBeat.i(192064);
        AppMethodBeat.o(192064);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/vlog/ui/thumb/EditFrameListView$Companion;", "", "()V", "TAG", "", "plugin-vlog_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public final int getMinWidth() {
        return this.minWidth;
    }

    public final void setMinWidth(int i2) {
        this.minWidth = i2;
    }

    public final int getShowWidth() {
        return this.GPj;
    }

    public final void setShowWidth(int i2) {
        this.GPj = i2;
    }

    public final int getTotalWidth() {
        return this.GJa;
    }

    public final void setTotalWidth(int i2) {
        this.GJa = i2;
    }

    public final int getValidWidth() {
        AppMethodBeat.i(192059);
        float f2 = (float) this.GPk;
        h hVar = this.GOV;
        if (hVar == null) {
            p.hyc();
        }
        float fEu = f2 * ((float) hVar.fEu());
        h hVar2 = this.GOV;
        if (hVar2 == null) {
            p.hyc();
        }
        int i2 = ((int) (fEu / ((float) hVar2.GQc.GzA.GJB))) + this.GPh + this.GPi;
        AppMethodBeat.o(192059);
        return i2;
    }

    public final int getFrameWidth() {
        return this.kxW;
    }

    public final void setFrameWidth(int i2) {
        this.kxW = i2;
    }

    public final int getTotalFrameWidth() {
        return this.GPk;
    }

    public final void setTotalFrameWidth(int i2) {
        this.GPk = i2;
    }

    public final void a(h hVar, int i2, boolean z, boolean z2) {
        int fEu;
        LinkedList<e> linkedList;
        AppMethodBeat.i(192060);
        p.h(hVar, "info");
        this.GOV = hVar;
        this.GOW.clear();
        h hVar2 = this.GOV;
        if (!(hVar2 == null || (linkedList = hVar2.GOG) == null)) {
            Iterator<T> it = linkedList.iterator();
            while (it.hasNext()) {
                it.next();
                this.GOW.add(null);
            }
        }
        this.COM.right = hVar.width;
        this.COM.bottom = hVar.height;
        this.GOY = (((float) i2) * 1.0f) / ((float) hVar.height);
        this.GOZ.bottom = (float) i2;
        this.GOZ.right = this.GOY * ((float) hVar.width);
        this.GPk = (int) (this.GOZ.right * hVar.GOF);
        this.minWidth = (int) ((((float) this.tXD) / ((float) hVar.GQc.GzA.GJB)) * ((float) this.GPk));
        if (hVar.GQb) {
            fEu = (int) ((((float) this.GPk) * ((float) hVar.GOE)) / ((float) hVar.GQc.GzA.GJB));
        } else if (hVar.GQa) {
            fEu = (int) ((((float) this.GPk) * ((float) (hVar.GQc.GzA.GJB - hVar.GOD))) / ((float) hVar.GQc.GzA.GJB));
        } else {
            fEu = (int) ((((float) this.GPk) * ((float) hVar.fEu())) / ((float) hVar.GQc.GzA.GJB));
        }
        this.kxW = fEu;
        this.GPh = z ? com.tencent.mm.cb.a.fromDPToPix(getContext(), 8) : com.tencent.mm.cb.a.fromDPToPix(getContext(), 4);
        this.GPi = z2 ? com.tencent.mm.cb.a.fromDPToPix(getContext(), 8) : com.tencent.mm.cb.a.fromDPToPix(getContext(), 4);
        this.GPj = this.kxW + this.GPh + this.GPi;
        this.GJa = this.GPk + this.GPh + this.GPi;
        kotlinx.coroutines.f.b(bn.TUK, ba.hMW(), new b(this, null), 2);
        AppMethodBeat.o(192060);
    }

    /* access modifiers changed from: protected */
    public final void onMeasure(int i2, int i3) {
        float f2 = 0.0f;
        AppMethodBeat.i(192061);
        int defaultSize = View.getDefaultSize(getSuggestedMinimumHeight(), i3);
        if (this.GPa) {
            this.GPe.left = 0.0f;
        } else {
            this.GPe.left = this.GPg;
        }
        if (this.GPb) {
            this.GPe.right = (float) this.kxW;
        } else {
            this.GPe.right = ((float) this.kxW) - this.GPg;
        }
        StringBuilder append = new StringBuilder("onMeasure: ").append(this.GPa).append(' ').append(this.GPb).append(", ").append(getWidth()).append(' ').append(defaultSize).append(", thumbScale:").append(this.GOY).append(", trackInfo.width:");
        h hVar = this.GOV;
        Log.i("MicroMsg.EditFrameListView", append.append(hVar != null ? Integer.valueOf(hVar.width) : null).append(", thumbDrawRect.right:").append(this.GOZ.right).toString());
        this.GPe.bottom = (float) defaultSize;
        this.rqV.reset();
        float f3 = this.GPc ? 0.0f : this.GPf;
        if (!this.GPd) {
            f2 = this.GPf;
        }
        this.rqV.addRoundRect(this.GPe, new float[]{f3, f3, f2, f2, f2, f2, f3, f3}, Path.Direction.CW);
        super.onMeasure(i2, i3);
        AppMethodBeat.o(192061);
    }

    /* access modifiers changed from: protected */
    public final void onDraw(Canvas canvas) {
        AppMethodBeat.i(192062);
        p.h(canvas, "canvas");
        super.onDraw(canvas);
        Log.i("MicroMsg.EditFrameListView", "onDraw: " + this + ", width:" + getWidth() + ", showWidth:" + this.GPj + ", track:" + this.GOV);
        canvas.translate((float) this.GPh, 0.0f);
        canvas.save();
        canvas.clipPath(this.rqV);
        h hVar = this.GOV;
        if (hVar != null && !hVar.GQb) {
            canvas.translate(((-((float) hVar.GOD)) / ((float) hVar.GQc.GzA.GJB)) * ((float) this.GPk), 0.0f);
        }
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
        canvas.restore();
        Drawable background = getBackground();
        if (background != null) {
            background.setBounds((int) this.GPe.left, (int) this.GPe.top, (int) this.GPe.right, (int) this.GPe.bottom);
            background.draw(canvas);
            AppMethodBeat.o(192062);
            return;
        }
        AppMethodBeat.o(192062);
    }
}

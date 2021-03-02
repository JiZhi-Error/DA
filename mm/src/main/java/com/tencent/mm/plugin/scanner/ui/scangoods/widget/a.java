package com.tencent.mm.plugin.scanner.ui.scangoods.widget;

import android.content.Context;
import android.graphics.Canvas;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.plugin.scanner.ui.scangoods.widget.c;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import kotlin.g.b.af;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000[\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f*\u0001\b\b&\u0018\u0000 52\u00020\u0001:\u00015B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%H\u0016J\u0014\u0010&\u001a\u00020#2\n\b\u0002\u0010'\u001a\u0004\u0018\u00010%H\u0002J\u0012\u0010(\u001a\u00020#2\b\u0010)\u001a\u0004\u0018\u00010*H\u0016J\b\u0010+\u001a\u00020#H\u0016J\b\u0010,\u001a\u00020#H\u0016J\u0010\u0010-\u001a\u00020#2\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0010\u0010.\u001a\u00020#2\u0006\u0010/\u001a\u00020\u0015H\u0016J\b\u00100\u001a\u00020#H\u0016J\b\u00101\u001a\u00020#H\u0016J\u0018\u00102\u001a\u00020#2\u0006\u00103\u001a\u00020\u001a2\u0006\u00104\u001a\u00020\u001aH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0004\n\u0002\u0010\tR*\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\f0\u000bj\b\u0012\u0004\u0012\u00020\f`\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0014\u001a\u00020\u0015X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0019\u001a\u00020\u001aX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001a\u0010\u001f\u001a\u00020\u001aX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u001c\"\u0004\b!\u0010\u001e¨\u00066"}, hxF = {"Lcom/tencent/mm/plugin/scanner/ui/scangoods/widget/BaseScanDotsAnimationController;", "Lcom/tencent/mm/plugin/scanner/ui/scangoods/widget/IScanDotsAnimationController;", "context", "Landroid/content/Context;", "scanAnimationDotsView", "Lcom/tencent/mm/plugin/scanner/ui/scangoods/widget/IScanAnimationDotsView;", "(Landroid/content/Context;Lcom/tencent/mm/plugin/scanner/ui/scangoods/widget/IScanAnimationDotsView;)V", "dotsAnimationListener", "com/tencent/mm/plugin/scanner/ui/scangoods/widget/BaseScanDotsAnimationController$dotsAnimationListener$1", "Lcom/tencent/mm/plugin/scanner/ui/scangoods/widget/BaseScanDotsAnimationController$dotsAnimationListener$1;", "dotsGroupSet", "Ljava/util/HashSet;", "Lcom/tencent/mm/plugin/scanner/ui/scangoods/widget/IScanAnimationDotsGroupView;", "Lkotlin/collections/HashSet;", "getDotsGroupSet", "()Ljava/util/HashSet;", "setDotsGroupSet", "(Ljava/util/HashSet;)V", FFmpegMetadataRetriever.METADATA_KEY_DURATION, "", "isStoping", "", "()Z", "setStoping", "(Z)V", "viewHeight", "", "getViewHeight", "()I", "setViewHeight", "(I)V", "viewWidth", "getViewWidth", "setViewWidth", "addAnimationDots", "", "pointsResult", "Lcom/tencent/mm/plugin/scanner/model/ScanPointsInfo;", "addAnimationDotsGroup", "points", "draw", "canvas", "Landroid/graphics/Canvas;", "refreshView", "release", "setDuration", "show", "visible", "startAnimation", "stopAnimation", "updateViewSize", "width", "height", "Companion", "plugin-scan_release"})
public abstract class a implements e {
    private static final ArrayList<c> CPp = new ArrayList<>();
    public static final C1677a CPq = new C1677a((byte) 0);
    HashSet<c> CPl = new HashSet<>();
    boolean CPm;
    private b CPn = new b(this);
    private final d CPo;
    private final Context context;
    private long duration = 700;
    int gRD;
    int gRE;

    @l(hxD = {1, 1, 16}, hxE = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\"\u0010\u000b\u001a\u0004\u0018\u00010\t2\u0006\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u001e\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\nX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, hxF = {"Lcom/tencent/mm/plugin/scanner/ui/scangoods/widget/BaseScanDotsAnimationController$Companion;", "", "()V", "RECYCLED_VIEW_MAX_SIZE", "", "TAG", "", "recycledViewList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/scanner/ui/scangoods/widget/IScanAnimationDotsGroupView;", "Lkotlin/collections/ArrayList;", "obtain", "context", "Landroid/content/Context;", FFmpegMetadataRetriever.METADATA_KEY_DURATION, "", "scanAnimationDotsView", "Lcom/tencent/mm/plugin/scanner/ui/scangoods/widget/IScanAnimationDotsView;", "plugin-scan_release"})
    /* renamed from: com.tencent.mm.plugin.scanner.ui.scangoods.widget.a$a  reason: collision with other inner class name */
    public static final class C1677a {
        private C1677a() {
        }

        public /* synthetic */ C1677a(byte b2) {
            this();
        }
    }

    public a(Context context2, d dVar) {
        p.h(context2, "context");
        p.h(dVar, "scanAnimationDotsView");
        this.context = context2;
        this.CPo = dVar;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0003H\u0016¨\u0006\u0007"}, hxF = {"com/tencent/mm/plugin/scanner/ui/scangoods/widget/BaseScanDotsAnimationController$dotsAnimationListener$1", "Lcom/tencent/mm/plugin/scanner/ui/scangoods/widget/IScanAnimationDotsGroupView$AnimationListener;", "onAnimationEnd", "", "dotsGroupView", "Lcom/tencent/mm/plugin/scanner/ui/scangoods/widget/IScanAnimationDotsGroupView;", "onAnimationStart", "plugin-scan_release"})
    public static final class b implements c.a {
        final /* synthetic */ a CPr;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        b(a aVar) {
            this.CPr = aVar;
        }

        @Override // com.tencent.mm.plugin.scanner.ui.scangoods.widget.c.a
        public final void a(c cVar) {
            AppMethodBeat.i(52250);
            Log.v("MicroMsg.BaseScanDotsAnimationController", "alvinluo dotsGroupSet remove isStoping: %b", Boolean.valueOf(this.CPr.CPm));
            if (!this.CPr.CPm) {
                HashSet<c> hashSet = this.CPr.CPl;
                if (hashSet == null) {
                    t tVar = new t("null cannot be cast to non-null type kotlin.collections.MutableCollection<T>");
                    AppMethodBeat.o(52250);
                    throw tVar;
                }
                af.eV(hashSet).remove(cVar);
            }
            AppMethodBeat.o(52250);
        }
    }

    @Override // com.tencent.mm.plugin.scanner.ui.scangoods.widget.d
    public void setDuration(long j2) {
        this.duration = j2;
        Iterator<T> it = this.CPl.iterator();
        while (it.hasNext()) {
            it.next().setDuration(j2);
        }
    }

    @Override // com.tencent.mm.plugin.scanner.ui.scangoods.widget.d
    public void startAnimation() {
    }

    @Override // com.tencent.mm.plugin.scanner.ui.scangoods.widget.d
    public void stopAnimation() {
        this.CPm = true;
        Iterator<T> it = this.CPl.iterator();
        while (it.hasNext()) {
            it.next().stopAnimation();
        }
        this.CPl.clear();
        this.CPm = false;
    }

    @Override // com.tencent.mm.plugin.scanner.ui.scangoods.widget.e
    public final void draw(Canvas canvas) {
        Iterator<T> it = this.CPl.iterator();
        while (it.hasNext()) {
            it.next().draw(canvas);
        }
    }

    @Override // com.tencent.mm.plugin.scanner.ui.scangoods.widget.e
    public final void ih(int i2, int i3) {
        this.gRD = i2;
        this.gRE = i3;
        Iterator<T> it = this.CPl.iterator();
        while (it.hasNext()) {
            it.next().A(i2, i3, false);
        }
    }

    @Override // com.tencent.mm.plugin.scanner.ui.scangoods.widget.d
    public final void release() {
        stopAnimation();
        Iterator<T> it = CPp.iterator();
        while (it.hasNext()) {
            it.next().release();
        }
        CPp.clear();
    }

    @Override // com.tencent.mm.plugin.scanner.ui.scangoods.widget.d
    public final void refreshView() {
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0091  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x00b4  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00ea  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00ec  */
    @Override // com.tencent.mm.plugin.scanner.ui.scangoods.widget.d
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void b(com.tencent.mm.plugin.scanner.model.ae r12) {
        /*
        // Method dump skipped, instructions count: 249
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.scanner.ui.scangoods.widget.a.b(com.tencent.mm.plugin.scanner.model.ae):void");
    }
}

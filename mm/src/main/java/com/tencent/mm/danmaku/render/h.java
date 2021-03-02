package com.tencent.mm.danmaku.render;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.danmaku.b.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class h extends a<e> {
    private SparseArray<List<a>> gQi = new SparseArray<>();

    public abstract void a(a aVar, e eVar);

    public abstract a atg();

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.graphics.Canvas, com.tencent.mm.danmaku.b.a, float, float] */
    @Override // com.tencent.mm.danmaku.render.a
    public final /* synthetic */ void b(Canvas canvas, e eVar, float f2, float f3) {
        e eVar2 = eVar;
        a aVar = eVar2.gPk;
        if (aVar != null) {
            if (!eVar2.gPl) {
                aVar.measure(View.MeasureSpec.makeMeasureSpec(aVar.ath(), 1073741824), View.MeasureSpec.makeMeasureSpec(aVar.ati(), 1073741824));
                aVar.cw(aVar.ath(), aVar.ati());
                eVar2.gPl = true;
            }
            canvas.save();
            canvas.translate(f2, f3);
            aVar.draw(canvas);
            canvas.restore();
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.danmaku.b.a] */
    @Override // com.tencent.mm.danmaku.render.a
    public final /* synthetic */ com.tencent.mm.danmaku.e.a g(e eVar) {
        e eVar2 = eVar;
        List<a> list = this.gQi.get(0);
        if (list == null) {
            list = new ArrayList<>();
            this.gQi.put(0, list);
        }
        if (list.isEmpty()) {
            list.add(atg());
        }
        a remove = list.remove(0);
        a(remove, eVar2);
        remove.measure(View.MeasureSpec.makeMeasureSpec(e.getScreenWidth(), Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(e.getScreenHeight(), Integer.MIN_VALUE));
        remove.cw(remove.ath(), remove.ati());
        eVar2.gPk = remove;
        eVar2.gPb = (float) remove.ath();
        eVar2.gPc = (float) remove.ati();
        return new com.tencent.mm.danmaku.e.a((float) remove.ath(), (float) remove.ati());
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.danmaku.b.a] */
    @Override // com.tencent.mm.danmaku.render.a
    public final /* synthetic */ void h(e eVar) {
        e eVar2 = eVar;
        a aVar = eVar2.gPk;
        if (aVar != null) {
            List<a> list = this.gQi.get(0);
            if (list == null) {
                list = new ArrayList<>();
                this.gQi.put(0, list);
            }
            list.add(aVar);
            eVar2.gPk = null;
        }
    }

    public static class a {
        protected final View gQj;
        private RectF gQk = new RectF();
        private Paint gQl = new Paint();

        public a(View view) {
            AppMethodBeat.i(241731);
            if (view == null) {
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException("itemView may not be null");
                AppMethodBeat.o(241731);
                throw illegalArgumentException;
            }
            this.gQj = view;
            AppMethodBeat.o(241731);
        }

        public final void measure(int i2, int i3) {
            AppMethodBeat.i(241732);
            this.gQj.measure(i2, i3);
            AppMethodBeat.o(241732);
        }

        public final int ath() {
            AppMethodBeat.i(241733);
            int measuredWidth = this.gQj.getMeasuredWidth();
            AppMethodBeat.o(241733);
            return measuredWidth;
        }

        public final int ati() {
            AppMethodBeat.i(241734);
            int measuredHeight = this.gQj.getMeasuredHeight();
            AppMethodBeat.o(241734);
            return measuredHeight;
        }

        public final void cw(int i2, int i3) {
            AppMethodBeat.i(241735);
            this.gQj.layout(0, 0, i2, i3);
            AppMethodBeat.o(241735);
        }

        public final void draw(Canvas canvas) {
            AppMethodBeat.i(241736);
            this.gQk.set(0.0f, 0.0f, (float) this.gQj.getMeasuredWidth(), (float) this.gQj.getMeasuredHeight());
            this.gQl.setAlpha((int) (this.gQj.getAlpha() * 255.0f));
            int saveLayer = canvas.saveLayer(this.gQk, this.gQl, 31);
            this.gQj.draw(canvas);
            canvas.restoreToCount(saveLayer);
            AppMethodBeat.o(241736);
        }

        public final View c(com.tencent.mm.danmaku.d.h hVar) {
            AppMethodBeat.i(241737);
            View d2 = d(this.gQj, ((float) hVar.mPoint.x) - hVar.gQG, ((float) hVar.mPoint.y) - hVar.gQH);
            AppMethodBeat.o(241737);
            return d2;
        }

        private View d(View view, float f2, float f3) {
            AppMethodBeat.i(241738);
            RectF rectF = new RectF();
            boolean z = false;
            Iterator<View> it = view.getTouchables().iterator();
            View view2 = null;
            while (it.hasNext()) {
                View next = it.next();
                float x = next.getX();
                float y = next.getY();
                rectF.set(x, y, ((float) next.getMeasuredWidth()) + x, ((float) next.getMeasuredWidth()) + y);
                if (rectF.contains(f2, f3)) {
                    if (next.equals(view)) {
                        z = true;
                    } else if (next instanceof ViewGroup) {
                        view2 = d(view, f2 - x, f3 - f2);
                    } else {
                        AppMethodBeat.o(241738);
                        return next;
                    }
                }
            }
            if (!z || view2 != null) {
                AppMethodBeat.o(241738);
                return view2;
            }
            AppMethodBeat.o(241738);
            return view;
        }
    }

    @Override // com.tencent.mm.danmaku.render.a
    public final boolean f(com.tencent.mm.danmaku.b.a aVar) {
        return aVar instanceof e;
    }
}

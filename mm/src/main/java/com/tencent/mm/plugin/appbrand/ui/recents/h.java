package com.tencent.mm.plugin.appbrand.ui.recents;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.modelgeo.d;
import com.tencent.mm.plugin.appbrand.appusage.ap;
import com.tencent.mm.plugin.appbrand.appusage.v;
import com.tencent.mm.plugin.appbrand.ui.recents.a;
import com.tencent.mm.plugin.appbrand.utils.f;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.b.p;

public class h extends a implements a.AbstractC0808a {
    ViewGroup nmW;
    private final List<a> odt;
    private final List<Class<? extends a>> odu = new LinkedList();
    private boolean odv;
    private boolean odw = false;
    private int odx = 2;
    private final ap ody;
    private final b odz;

    /* access modifiers changed from: package-private */
    public class b {
        final int odA;
        final int odB;
        private final int odC;
        final int odD;
        final int odE;
        final int odF;

        /* synthetic */ b(h hVar, Context context, byte b2) {
            this(context);
        }

        private b(Context context) {
            AppMethodBeat.i(49142);
            this.odA = context.getResources().getDimensionPixelSize(R.dimen.tv);
            this.odB = com.tencent.mm.cb.a.fromDPToPix(context, 56);
            this.odC = 0;
            this.odD = com.tencent.mm.cb.a.fromDPToPix(context, 8);
            this.odE = com.tencent.mm.cb.a.n(context, R.color.f9do);
            this.odF = 2;
            AppMethodBeat.o(49142);
        }
    }

    public h(FragmentActivity fragmentActivity, ViewGroup viewGroup, boolean z) {
        AppMethodBeat.i(180403);
        if (fragmentActivity == null || viewGroup == null) {
            IllegalStateException illegalStateException = new IllegalStateException("Unexpected parameters");
            AppMethodBeat.o(180403);
            throw illegalStateException;
        }
        this.odz = new b(this, fragmentActivity, (byte) 0);
        this.odv = z;
        LinearLayout linearLayout = new LinearLayout(viewGroup.getContext());
        linearLayout.setOrientation(1);
        this.nmW = linearLayout;
        this.odt = a(fragmentActivity, this.nmW);
        a(this.odt, this.nmW);
        bU(this.odt);
        zu(0);
        this.ody = new ap();
        bYF();
        d.bca().b((ap.e) f.cP(new ap.e(this.ody)), false);
        AppMethodBeat.o(180403);
    }

    private void bYF() {
        AppMethodBeat.i(180404);
        for (a aVar : this.odt) {
            if (aVar instanceof ap.c) {
                ap apVar = this.ody;
                ap.c cVar = (ap.c) aVar;
                p.h(cVar, "receiver");
                synchronized (apVar.kWm) {
                    try {
                        ArrayList arrayList = apVar.kWm.get(cVar.byw());
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                            apVar.kWm.put(cVar.byw(), arrayList);
                        }
                        arrayList.add(cVar);
                    } catch (Throwable th) {
                        AppMethodBeat.o(180404);
                        throw th;
                    }
                }
            }
        }
        AppMethodBeat.o(180404);
    }

    /* access modifiers changed from: protected */
    public List<a> a(FragmentActivity fragmentActivity, ViewGroup viewGroup) {
        AppMethodBeat.i(180405);
        ArrayList arrayList = new ArrayList(2);
        d dVar = new d(fragmentActivity, viewGroup);
        dVar.obo = this;
        a(arrayList, dVar);
        a(arrayList, c(fragmentActivity, viewGroup));
        c cVar = new c(fragmentActivity, viewGroup);
        cVar.obo = this;
        a(arrayList, cVar);
        e eVar = new e(fragmentActivity, viewGroup);
        eVar.obo = this;
        a(arrayList, eVar);
        a(arrayList, b(fragmentActivity, viewGroup));
        AppMethodBeat.o(180405);
        return arrayList;
    }

    protected static void a(List<a> list, a aVar) {
        AppMethodBeat.i(49145);
        if (aVar != null) {
            list.add(aVar);
        }
        AppMethodBeat.o(49145);
    }

    /* access modifiers changed from: protected */
    public a b(FragmentActivity fragmentActivity, ViewGroup viewGroup) {
        AppMethodBeat.i(180406);
        v.byn();
        b bVar = new b(fragmentActivity, viewGroup);
        bVar.obo = this;
        AppMethodBeat.o(180406);
        return bVar;
    }

    /* access modifiers changed from: protected */
    public a c(FragmentActivity fragmentActivity, ViewGroup viewGroup) {
        AppMethodBeat.i(180407);
        j jVar = new j(fragmentActivity, viewGroup);
        jVar.obo = this;
        AppMethodBeat.o(180407);
        return jVar;
    }

    private void a(List<a> list, ViewGroup viewGroup) {
        AppMethodBeat.i(49150);
        if (list == null || list.size() == 0) {
            AppMethodBeat.o(49150);
        } else if (viewGroup == null) {
            AppMethodBeat.o(49150);
        } else {
            for (int i2 = 0; i2 < list.size(); i2++) {
                a aVar = list.get(i2);
                viewGroup.addView(aVar.bYp());
                if (i2 == this.odx) {
                    viewGroup.addView(new a(viewGroup.getContext()), -1, this.odz.odD);
                } else if (i2 != list.size() - 1) {
                    if (i2 != 0) {
                        list.get(i2 - 1);
                    }
                    a aVar2 = list.get(i2 + 1);
                    if (this.odu.contains(aVar.getClass()) || this.odu.contains(aVar2.getClass())) {
                        LinearLayout linearLayout = new LinearLayout(viewGroup.getContext());
                        linearLayout.setOrientation(1);
                        l(linearLayout);
                        viewGroup.addView(linearLayout, -1, -2);
                    } else if (this.odv) {
                        int dimensionPixelOffset = viewGroup.getContext().getResources().getDimensionPixelOffset(R.dimen.rv);
                        int dimensionPixelOffset2 = viewGroup.getContext().getResources().getDimensionPixelOffset(R.dimen.rl);
                        LinearLayout linearLayout2 = new LinearLayout(viewGroup.getContext());
                        linearLayout2.setOrientation(0);
                        viewGroup.addView(linearLayout2, -1, -2);
                        Context context = viewGroup.getContext();
                        View view = new View(context);
                        view.setBackgroundColor(context.getResources().getColor(R.color.f3045c));
                        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dimensionPixelOffset2, dimensionPixelOffset);
                        layoutParams.gravity = 3;
                        linearLayout2.addView(view, layoutParams);
                        View view2 = new View(context);
                        view2.setBackgroundColor(viewGroup.getResources().getColor(R.color.dy));
                        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(0, dimensionPixelOffset, 1.0f);
                        layoutParams2.gravity = 17;
                        linearLayout2.addView(view2, layoutParams2);
                        View view3 = new View(context);
                        view3.setBackgroundColor(context.getResources().getColor(R.color.f3045c));
                        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(dimensionPixelOffset2, dimensionPixelOffset);
                        layoutParams3.gravity = 5;
                        linearLayout2.addView(view3, layoutParams3);
                    } else {
                        Context context2 = viewGroup.getContext();
                        View view4 = new View(context2);
                        LinearLayout linearLayout3 = new LinearLayout(context2);
                        linearLayout3.setPadding(this.odz.odB, 0, 0, 0);
                        linearLayout3.setBackgroundResource(R.color.f3045c);
                        linearLayout3.addView(view4, new LinearLayout.LayoutParams(-1, this.odz.odA));
                        view4.setBackgroundColor(context2.getResources().getColor(R.color.FG_3));
                        new LinearLayout.LayoutParams(this.odz.odB, this.odz.odA).gravity = 3;
                        viewGroup.addView(linearLayout3, new LinearLayout.LayoutParams(-1, -2));
                    }
                }
            }
            Context context3 = viewGroup.getContext();
            ColorDrawable colorDrawable = new ColorDrawable(this.odz.odE);
            ImageView imageView = new ImageView(context3);
            if (this.odv || !this.odw) {
                imageView.setBackgroundColor(0);
            } else {
                imageView.setImageDrawable(colorDrawable);
                imageView.setBackgroundColor(context3.getResources().getColor(R.color.f3045c));
            }
            viewGroup.addView(imageView, 0, new LinearLayout.LayoutParams(-1, this.odz.odF));
            l(viewGroup);
            AppMethodBeat.o(49150);
        }
    }

    private static void bU(List<a> list) {
        AppMethodBeat.i(49151);
        if (list == null) {
            AppMethodBeat.o(49151);
            return;
        }
        for (a aVar : list) {
            aVar.setViewEnable(false);
        }
        AppMethodBeat.o(49151);
    }

    private void l(ViewGroup viewGroup) {
        AppMethodBeat.i(49152);
        FrameLayout frameLayout = new FrameLayout(viewGroup.getContext());
        Context context = frameLayout.getContext();
        ColorDrawable colorDrawable = new ColorDrawable(this.odz.odE);
        ImageView imageView = new ImageView(context);
        if (this.odv || !this.odw) {
            imageView.setBackgroundColor(0);
        } else {
            imageView.setImageDrawable(colorDrawable);
            imageView.setBackgroundColor(context.getResources().getColor(R.color.Red));
        }
        frameLayout.addView(imageView, -1, this.odz.odF);
        frameLayout.addView(new View(context), -1, this.odz.odD);
        ImageView imageView2 = new ImageView(context);
        if (this.odv || !this.odw) {
            imageView2.setBackgroundColor(0);
        } else {
            imageView2.setImageDrawable(colorDrawable);
            imageView2.setBackgroundColor(context.getResources().getColor(R.color.f3045c));
        }
        frameLayout.addView(imageView2, -1, this.odz.odF);
        frameLayout.setId(R.id.p8);
        viewGroup.addView(frameLayout, -1, -2);
        AppMethodBeat.o(49152);
    }

    @Override // com.tencent.mm.plugin.appbrand.ui.recents.a
    public final void bSx() {
        AppMethodBeat.i(49153);
        for (a aVar : this.odt) {
            aVar.bSx();
        }
        AppMethodBeat.o(49153);
    }

    @Override // com.tencent.mm.plugin.appbrand.ui.recents.a
    public final void onDetached() {
        AppMethodBeat.i(49154);
        for (a aVar : this.odt) {
            aVar.onDetached();
        }
        this.odt.clear();
        this.ody.kWm.clear();
        AppMethodBeat.o(49154);
    }

    @Override // com.tencent.mm.plugin.appbrand.ui.recents.a
    public final void onResume() {
        AppMethodBeat.i(49155);
        for (a aVar : this.odt) {
            aVar.onResume();
        }
        AppMethodBeat.o(49155);
    }

    @Override // com.tencent.mm.plugin.appbrand.ui.recents.a
    public final void onPause() {
        AppMethodBeat.i(180408);
        for (a aVar : this.odt) {
            aVar.onPause();
        }
        AppMethodBeat.o(180408);
    }

    @Override // com.tencent.mm.plugin.appbrand.ui.recents.a
    public final View bYp() {
        return this.nmW;
    }

    @Override // com.tencent.mm.plugin.appbrand.ui.recents.a
    public final void zu(int i2) {
        AppMethodBeat.i(49156);
        for (a aVar : this.odt) {
            aVar.zu(i2);
        }
        AppMethodBeat.o(49156);
    }

    @Override // com.tencent.mm.plugin.appbrand.ui.recents.a
    public final void zv(int i2) {
        AppMethodBeat.i(49157);
        bYG();
        AppMethodBeat.o(49157);
    }

    private void bYG() {
        int i2;
        int i3 = 0;
        AppMethodBeat.i(49158);
        int i4 = 0;
        for (a aVar : this.odt) {
            if (aVar.getViewEnable()) {
                i2 = i4 + 1;
            } else {
                i2 = i4;
            }
            i4 = i2;
        }
        for (a aVar2 : this.odt) {
            if (aVar2.getViewEnable()) {
                if (i3 == 0) {
                    aVar2.zv(R.drawable.dm);
                } else if (i3 == this.odt.size() - 1 || i3 == i4 - 1) {
                    aVar2.zv(R.drawable.dk);
                } else {
                    aVar2.zv(R.drawable.dl);
                }
                i3++;
            }
        }
        AppMethodBeat.o(49158);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00ad, code lost:
        if (r4 != false) goto L_0x00af;
     */
    @Override // com.tencent.mm.plugin.appbrand.ui.recents.a.AbstractC0808a
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(com.tencent.mm.plugin.appbrand.ui.recents.a r11, android.view.View r12, boolean r13) {
        /*
        // Method dump skipped, instructions count: 251
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.ui.recents.h.a(com.tencent.mm.plugin.appbrand.ui.recents.a, android.view.View, boolean):void");
    }

    /* access modifiers changed from: package-private */
    public static class a extends View {
        public a(Context context) {
            super(context);
        }
    }
}

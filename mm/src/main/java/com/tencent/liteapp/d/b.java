package com.tencent.liteapp.d;

import android.content.Context;
import android.graphics.Rect;
import android.support.v4.view.u;
import android.view.View;
import com.tencent.liteapp.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.LinkedHashSet;

public final class b implements c {
    private int crS = 0;
    private final int[] crT = new int[2];
    private final Rect crU = new Rect();
    private boolean crV = false;
    private View crW;
    private AbstractC0152b crX;
    public final LinkedHashSet<c> crY = new LinkedHashSet<>();

    /* access modifiers changed from: package-private */
    public interface a {
        void a(c cVar);
    }

    /* renamed from: com.tencent.liteapp.d.b$b  reason: collision with other inner class name */
    interface AbstractC0152b extends c {
    }

    public interface c {
        void bQ(boolean z);

        int getHeight();

        void hF(int i2);
    }

    public b() {
        AppMethodBeat.i(197799);
        AppMethodBeat.o(197799);
    }

    private void getWindowVisibleDisplayFrame(Rect rect) {
        AppMethodBeat.i(197800);
        if (this.crW != null) {
            this.crW.getWindowVisibleDisplayFrame(rect);
            this.crW.getLocationInWindow(this.crT);
            rect.top = this.crT[1];
        }
        AppMethodBeat.o(197800);
    }

    @Override // com.tencent.liteapp.d.c
    public final void bZ(View view) {
        final boolean z;
        boolean z2 = true;
        AppMethodBeat.i(197802);
        this.crW = view;
        Rect rect = this.crU;
        getWindowVisibleDisplayFrame(rect);
        int height = rect.height();
        if (this.crS == 0) {
            this.crS = height;
        } else {
            final int frameHeight = getFrameHeight() - height;
            if (frameHeight > 0) {
                a(new a() {
                    /* class com.tencent.liteapp.d.b.AnonymousClass1 */

                    @Override // com.tencent.liteapp.d.b.a
                    public final void a(c cVar) {
                        AppMethodBeat.i(197797);
                        if (cVar.getHeight() != frameHeight) {
                            cVar.hF(frameHeight);
                        }
                        AppMethodBeat.o(197797);
                    }
                });
                if (!(this.crX == null || this.crX.getHeight() == frameHeight)) {
                    this.crX.hF(frameHeight);
                }
            }
        }
        if (getFrameHeight() > height) {
            z = true;
        } else {
            z = false;
        }
        if (this.crV == z) {
            z2 = false;
        }
        if (z2) {
            if (this.crX != null) {
                this.crX.bQ(z);
            }
            a(new a() {
                /* class com.tencent.liteapp.d.b.AnonymousClass2 */

                @Override // com.tencent.liteapp.d.b.a
                public final void a(c cVar) {
                    AppMethodBeat.i(197798);
                    cVar.bQ(z);
                    AppMethodBeat.o(197798);
                }
            });
        }
        this.crV = z;
        this.crS = height;
        this.crW = null;
        AppMethodBeat.o(197802);
    }

    private void a(a aVar) {
        AppMethodBeat.i(197803);
        Iterator it = ((LinkedHashSet) this.crY.clone()).iterator();
        while (it.hasNext()) {
            aVar.a((c) it.next());
        }
        AppMethodBeat.o(197803);
    }

    private int getFrameHeight() {
        View rootView;
        Context context;
        int i2;
        AppMethodBeat.i(197801);
        if (this.crW == null) {
            rootView = null;
        } else {
            rootView = this.crW.getRootView();
        }
        if (rootView == null) {
            AppMethodBeat.o(197801);
            return 0;
        }
        Rect rect = this.crU;
        getWindowVisibleDisplayFrame(rect);
        if (u.az(this.crW)) {
            i2 = this.crW.getMeasuredHeight();
        } else {
            if (this.crW == null) {
                a.C0147a aVar = com.tencent.liteapp.a.cqJ;
                context = a.C0147a.getAppContext();
            } else {
                context = this.crW.getContext();
            }
            i2 = context.getResources().getDisplayMetrics().heightPixels;
        }
        int i3 = i2 - rect.top;
        AppMethodBeat.o(197801);
        return i3;
    }
}

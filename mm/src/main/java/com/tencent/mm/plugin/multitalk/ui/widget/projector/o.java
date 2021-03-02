package com.tencent.mm.plugin.multitalk.ui.widget.projector;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.multitalk.d.f;
import com.tencent.mm.plugin.multitalk.ui.widget.projector.a;
import com.tencent.mm.plugin.multitalk.ui.widget.projector.recyclerview.ScreenThumbLayoutManager;
import com.tencent.mm.plugin.multitalk.ui.widget.projector.recyclerview.e;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.x;

public final class o {
    static int zXR = 10;
    public static final a zXS = new a((byte) 0);
    Context context;
    boolean isLoading;
    boolean jUX;
    int mMaxCount = -1;
    int rmJ = -1;
    a zQD;
    String zXB;
    public CopyOnWriteArrayList<Bitmap> zXD = new CopyOnWriteArrayList<>();
    View zXE;
    ScreenThumbLayoutManager zXF;
    e zXG;
    com.tencent.mm.plugin.multitalk.ui.widget.projector.recyclerview.b zXH;
    RecyclerView zXI;
    FrameLayout zXJ;
    n zXK;
    FrameLayout zXL;
    View zXM;
    int zXN;
    int zXO;
    int zXP;
    int zXQ = 3;

    static final class c extends q implements m<View, Integer, x> {
        final /* synthetic */ o zXT;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(o oVar) {
            super(2);
            this.zXT = oVar;
        }

        @Override // kotlin.g.a.m
        public final /* synthetic */ x invoke(View view, Integer num) {
            AppMethodBeat.i(240040);
            int intValue = num.intValue();
            p.h(view, "view");
            f fVar = f.zZd;
            f.eqs();
            if (intValue != this.zXT.rmJ) {
                Bundle bundle = new Bundle();
                bundle.putInt("thumb_flip_target_position", intValue);
                this.zXT.zQD.a(a.c.THUMB_VIEW_PAGE_FLIP, bundle);
                if (this.zXT.zXI != null && intValue >= 0) {
                    String sb = new StringBuilder().append(intValue + 1).append('/').append(this.zXT.mMaxCount).toString();
                    n nVar = this.zXT.zXK;
                    if (nVar != null) {
                        nVar.aGE(sb);
                    }
                    com.tencent.mm.plugin.multitalk.ui.widget.projector.recyclerview.b bVar = this.zXT.zXH;
                    if (bVar != null) {
                        bVar.RB(intValue);
                    }
                    ScreenThumbLayoutManager screenThumbLayoutManager = this.zXT.zXF;
                    if (screenThumbLayoutManager != null) {
                        RecyclerView recyclerView = this.zXT.zXI;
                        if (recyclerView == null) {
                            p.hyc();
                        }
                        screenThumbLayoutManager.smoothScrollToPosition(recyclerView, new RecyclerView.s(), intValue);
                    }
                    f fVar2 = f.zZd;
                    f.eqt();
                }
            }
            x xVar = x.SXb;
            AppMethodBeat.o(240040);
            return xVar;
        }
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public o(Context context2, a aVar) {
        p.h(context2, "context");
        p.h(aVar, "statusManager");
        AppMethodBeat.i(240047);
        this.context = context2;
        this.zQD = aVar;
        AppMethodBeat.o(240047);
    }

    static {
        AppMethodBeat.i(240048);
        AppMethodBeat.o(240048);
    }

    public static final class b extends com.tencent.mm.plugin.multitalk.ui.widget.projector.recyclerview.c {
        final /* synthetic */ o zXT;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(o oVar, LinearLayoutManager linearLayoutManager) {
            super(linearLayoutManager);
            this.zXT = oVar;
        }

        @Override // com.tencent.mm.plugin.multitalk.ui.widget.projector.recyclerview.c
        public final void epH() {
            AppMethodBeat.i(240037);
            this.zXT.isLoading = true;
            this.zXT.zXP++;
            this.zXT.epE();
            AppMethodBeat.o(240037);
        }

        @Override // com.tencent.mm.plugin.multitalk.ui.widget.projector.recyclerview.c
        public final boolean epI() {
            AppMethodBeat.i(240038);
            boolean z = this.zXT.jUX;
            AppMethodBeat.o(240038);
            return z;
        }

        @Override // com.tencent.mm.plugin.multitalk.ui.widget.projector.recyclerview.c
        public final boolean isLoading() {
            AppMethodBeat.i(240039);
            boolean z = this.zXT.isLoading;
            AppMethodBeat.o(240039);
            return z;
        }
    }

    public final void epE() {
        AppMethodBeat.i(240041);
        Bundle bundle = new Bundle();
        bundle.putInt("thumb_current_page", this.zXP);
        this.zQD.a(a.c.REQUEST_THUMB_REFRESH, bundle);
        AppMethodBeat.o(240041);
    }

    public final void aGE(String str) {
        AppMethodBeat.i(240042);
        p.h(str, "str");
        FrameLayout frameLayout = this.zXL;
        if (frameLayout != null) {
            frameLayout.setVisibility(0);
        }
        this.zXB = str;
        n nVar = this.zXK;
        if (nVar != null) {
            nVar.aGE(str);
            AppMethodBeat.o(240042);
            return;
        }
        AppMethodBeat.o(240042);
    }

    public final void hide() {
        AppMethodBeat.i(240043);
        epF();
        if (this.zQD.epf() == 90 || this.zQD.epf() == 270) {
            RecyclerView recyclerView = this.zXI;
            if (recyclerView != null) {
                recyclerView.setVisibility(4);
                AppMethodBeat.o(240043);
                return;
            }
            AppMethodBeat.o(240043);
            return;
        }
        RecyclerView recyclerView2 = this.zXI;
        if (recyclerView2 != null) {
            recyclerView2.setVisibility(4);
        }
        View view = this.zXM;
        if (view != null) {
            view.setVisibility(4);
            AppMethodBeat.o(240043);
            return;
        }
        AppMethodBeat.o(240043);
    }

    private void epF() {
        AppMethodBeat.i(240044);
        FrameLayout frameLayout = this.zXL;
        if (frameLayout != null) {
            frameLayout.removeAllViews();
            n nVar = this.zXK;
            if (nVar != null) {
                nVar.c(this.context, frameLayout);
                AppMethodBeat.o(240044);
                return;
            }
            AppMethodBeat.o(240044);
            return;
        }
        AppMethodBeat.o(240044);
    }

    public final void show() {
        AppMethodBeat.i(240045);
        epF();
        n nVar = this.zXK;
        if (nVar != null) {
            nVar.eoD();
        }
        FrameLayout frameLayout = this.zXL;
        if (frameLayout != null) {
            frameLayout.setVisibility(0);
        }
        FrameLayout frameLayout2 = this.zXJ;
        if (frameLayout2 != null) {
            frameLayout2.setVisibility(0);
        }
        RecyclerView recyclerView = this.zXI;
        if (recyclerView != null) {
            recyclerView.setVisibility(0);
        }
        View view = this.zXM;
        if (view != null) {
            view.setVisibility(0);
        }
        RB(this.rmJ);
        AppMethodBeat.o(240045);
    }

    public final void RB(int i2) {
        AppMethodBeat.i(240046);
        if (this.zXI != null && i2 >= 0 && this.mMaxCount >= 0) {
            n nVar = this.zXK;
            if (nVar != null) {
                nVar.aGE(new StringBuilder().append(i2 + 1).append('/').append(this.mMaxCount).toString());
            }
            com.tencent.mm.plugin.multitalk.ui.widget.projector.recyclerview.b bVar = this.zXH;
            if (bVar != null) {
                bVar.RB(i2);
            }
            ScreenThumbLayoutManager screenThumbLayoutManager = this.zXF;
            if (screenThumbLayoutManager != null) {
                RecyclerView recyclerView = this.zXI;
                if (recyclerView == null) {
                    p.hyc();
                }
                screenThumbLayoutManager.smoothScrollToPosition(recyclerView, new RecyclerView.s(), i2);
                AppMethodBeat.o(240046);
                return;
            }
        }
        AppMethodBeat.o(240046);
    }
}

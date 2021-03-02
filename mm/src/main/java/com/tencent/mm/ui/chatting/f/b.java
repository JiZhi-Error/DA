package com.tencent.mm.ui.chatting.f;

import android.support.v7.widget.RecyclerView;
import com.tencent.mm.modelvoiceaddr.ui.b;
import com.tencent.mm.ui.chatting.a.c;
import com.tencent.mm.ui.chatting.k.c;

public final class b {

    public interface a extends c<AbstractC2093b> {
        String bmB();

        RecyclerView.a bmS(String str);

        <T extends RecyclerView.LayoutManager> T gRW();

        RecyclerView.h gRX();

        void gRY();

        c.e gRZ();

        b.a gSa();

        String gSb();

        int getType();
    }

    /* renamed from: com.tencent.mm.ui.chatting.f.b$b  reason: collision with other inner class name */
    public interface AbstractC2093b extends com.tencent.mm.ui.chatting.view.a<a> {
        void D(boolean z, int i2);

        void dr(String str, boolean z);

        void gSc();

        void onFinish();
    }
}

package com.tencent.mm.ui.chatting.f;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a {

    /* renamed from: com.tencent.mm.ui.chatting.f.a$a  reason: collision with other inner class name */
    public interface AbstractC2092a extends com.tencent.mm.ui.chatting.k.c<b> {
        void G(boolean z, int i2);

        void Ig(int i2);

        String bmB();

        boolean cWG();

        void cWH();

        void cWI();

        <T extends RecyclerView.a> T cWP();

        com.tencent.mm.ui.chatting.a.b ch(String str, long j2);

        <T extends RecyclerView.LayoutManager> T eS(Context context);

        RecyclerView.h fi(Context context);

        int gRR();

        void gRS();

        void onResume();
    }

    public interface b extends com.tencent.mm.ui.chatting.view.a<AbstractC2092a> {
        void D(boolean z, int i2);

        void Ie(int i2);

        void amL(int i2);

        void cWI();

        void gRS();

        void gRT();

        void gRU();

        boolean gRV();

        View getChildAt(int i2);

        void kF(boolean z);
    }

    public enum c {
        TYPE_IMAGE_AND_VIDEO;

        public static c valueOf(String str) {
            AppMethodBeat.i(35854);
            c cVar = (c) Enum.valueOf(c.class, str);
            AppMethodBeat.o(35854);
            return cVar;
        }

        static {
            AppMethodBeat.i(35855);
            AppMethodBeat.o(35855);
        }
    }
}

package com.tencent.mm.plugin.fav.ui.gallery;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fav.ui.gallery.f;
import java.util.List;

public final class g {

    public interface a extends a<b> {
        void G(boolean z, int i2);

        void Ig(int i2);

        void a(f.b bVar);

        boolean cWG();

        void cWH();

        void cWI();

        <T extends RecyclerView.a> T cWP();

        RecyclerView.a cyF();

        <T extends RecyclerView.LayoutManager> T eS(Context context);

        RecyclerView.h fi(Context context);

        void onResume();
    }

    public interface b extends b<a> {
        void D(boolean z, int i2);

        void Ie(int i2);

        void cWI();

        void dM(List<d> list);

        void dN(List<d> list);

        void kF(boolean z);
    }

    public enum c {
        TYPE_IMAGE_AND_VIDEO;

        public static c valueOf(String str) {
            AppMethodBeat.i(107421);
            c cVar = (c) Enum.valueOf(c.class, str);
            AppMethodBeat.o(107421);
            return cVar;
        }

        static {
            AppMethodBeat.i(107422);
            AppMethodBeat.o(107422);
        }
    }
}

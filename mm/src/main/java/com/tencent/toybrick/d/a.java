package com.tencent.toybrick.d;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.toybrick.c.g;
import com.tencent.toybrick.ui.BaseToyUI;
import java.util.LinkedList;

public final class a {
    private BaseToyUI SnR;
    public C2220a Snl;

    public a(BaseToyUI baseToyUI) {
        AppMethodBeat.i(159962);
        this.SnR = baseToyUI;
        this.Snl = new C2220a(baseToyUI);
        AppMethodBeat.o(159962);
    }

    /* renamed from: com.tencent.toybrick.d.a$a  reason: collision with other inner class name */
    public class C2220a {
        public LinkedList<g> Soh = new LinkedList<>();
        public boolean Soi = true;
        public Drawable Soj;

        public C2220a(Context context) {
            AppMethodBeat.i(159961);
            this.Soj = new ColorDrawable(context.getResources().getColor(R.color.x5));
            AppMethodBeat.o(159961);
        }
    }
}

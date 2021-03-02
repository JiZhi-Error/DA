package com.tencent.mm.plugin.location.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.a.d;

public final class j {
    private d ljp = null;
    public Context mContext;
    public Resources mResources;
    a yJV;

    public interface a {
        void Py(int i2);

        void edx();

        void edy();
    }

    public j(Context context, a aVar) {
        AppMethodBeat.i(55961);
        this.mContext = context;
        this.yJV = aVar;
        this.mResources = this.mContext.getResources();
        AppMethodBeat.o(55961);
    }

    public final void edw() {
        boolean booleanValue;
        AppMethodBeat.i(55962);
        Object obj = g.aAh().azQ().get(67590, (Object) null);
        if (obj == null) {
            booleanValue = false;
        } else {
            booleanValue = ((Boolean) obj).booleanValue();
        }
        if (!booleanValue) {
            h.a(this.mContext, this.mResources.getString(R.string.el6), "", false, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.plugin.location.ui.j.AnonymousClass1 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(55957);
                    if (j.this.yJV != null) {
                        j.this.yJV.edx();
                    }
                    AppMethodBeat.o(55957);
                }
            }, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.plugin.location.ui.j.AnonymousClass2 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                }
            });
            g.aAh().azQ().set(67590, Boolean.TRUE);
            AppMethodBeat.o(55962);
            return;
        }
        if (this.yJV != null) {
            this.yJV.edx();
        }
        AppMethodBeat.o(55962);
    }
}

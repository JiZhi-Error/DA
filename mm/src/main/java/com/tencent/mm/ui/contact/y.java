package com.tencent.mm.ui.contact;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.at;
import java.util.List;

public final class y extends LinearLayout {
    private List<String> PVy;
    private a PYg;
    private b PYh;
    private Context context;
    private LinearLayout tmh = null;

    public interface a {
        void anE(int i2);
    }

    public interface b {
        void Cm(boolean z);
    }

    public y(Context context2, a aVar) {
        super(context2);
        AppMethodBeat.i(37926);
        this.context = context2;
        this.PYg = aVar;
        h.RTc.aX(new Runnable() {
            /* class com.tencent.mm.ui.contact.y.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(234015);
                y yVar = y.this;
                bg.aVF();
                yVar.PVy = c.aSN().gBY();
                y.this.post(new Runnable() {
                    /* class com.tencent.mm.ui.contact.y.AnonymousClass1.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(234014);
                        if (y.this.PVy == null || y.this.PVy.size() <= 0) {
                            Log.i("MicroMsg.OpenIMListHeaderView", "openimIdList is null");
                            AppMethodBeat.o(234014);
                            return;
                        }
                        y.this.PVy.remove("wework");
                        Log.i("MicroMsg.OpenIMListHeaderView", "openim list size = %s", Integer.valueOf(y.this.PVy.size()));
                        if (y.this.tmh == null) {
                            View.inflate(y.this.getContext(), R.layout.bh3, y.this);
                            y.this.tmh = (LinearLayout) y.this.findViewById(R.id.be3);
                        }
                        y.this.tmh.removeAllViews();
                        for (int i2 = 0; i2 < y.this.PVy.size(); i2++) {
                            z zVar = new z(y.this.getContext(), (String) y.this.PVy.get(i2));
                            y.this.tmh.addView(zVar);
                            if (i2 == y.this.PVy.size() - 1) {
                                View findViewById = zVar.findViewById(R.id.c45);
                                int paddingLeft = findViewById.getPaddingLeft();
                                findViewById.setBackground(at.aN(y.this.context, R.attr.sg));
                                findViewById.findViewById(R.id.c47).setBackground(null);
                                findViewById.setPadding(paddingLeft, 0, 0, 0);
                            } else {
                                zVar.findViewById(R.id.c45).setBackground(null);
                                zVar.findViewById(R.id.c45).findViewById(R.id.c47).setBackground(at.aN(y.this.context, R.attr.sg));
                            }
                        }
                        y.this.PYg.anE(y.this.PVy.size());
                        AppMethodBeat.o(234014);
                    }
                });
                AppMethodBeat.o(234015);
            }
        });
        AppMethodBeat.o(37926);
    }

    public final int getOpenIMCount() {
        AppMethodBeat.i(37927);
        if (this.PVy == null) {
            AppMethodBeat.o(37927);
            return 0;
        }
        int size = this.PVy.size();
        AppMethodBeat.o(37927);
        return size;
    }

    public final void setVisibility(int i2) {
        AppMethodBeat.i(37929);
        if (!(this.PYh == null || i2 == getVisibility())) {
            this.PYh.Cm(i2 == 0);
        }
        super.setVisibility(i2);
        AppMethodBeat.o(37929);
    }

    public final void setOnVisibilityChangeListener(b bVar) {
        this.PYh = bVar;
    }
}

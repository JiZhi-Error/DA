package com.tencent.mm.plugin.choosemsgfile.b.b;

import android.content.Context;
import android.os.Looper;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ag.k;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.plugin.choosemsgfile.b.d.c;
import com.tencent.mm.plugin.fav.ui.e;
import com.tencent.mm.plugin.fav.ui.m;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.pluginsdk.ui.a;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ah;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.ca;

public class k extends a<n> {
    private String goe;
    private k.b qnG;
    public String qnQ;
    private String qnT;
    private Integer qnU;
    private String qnV;
    private String qnW;

    static /* synthetic */ void a(k kVar, n nVar) {
        AppMethodBeat.i(123296);
        kVar.b(nVar);
        AppMethodBeat.o(123296);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.support.v7.widget.RecyclerView$v] */
    @Override // com.tencent.mm.plugin.choosemsgfile.b.b.a
    public final /* synthetic */ void V(n nVar) {
        AppMethodBeat.i(123294);
        a(nVar);
        AppMethodBeat.o(123294);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.support.v7.widget.RecyclerView$v, int, com.tencent.mm.plugin.choosemsgfile.b.b.a] */
    @Override // com.tencent.mm.plugin.choosemsgfile.b.b.a
    public final /* synthetic */ void a(n nVar, int i2, a aVar) {
        String ajy;
        AppMethodBeat.i(162333);
        n nVar2 = nVar;
        nVar2.qnZ.setTag(this);
        nVar2.qol.setTag(this);
        a.b.c(nVar2.gyr, getUsername());
        TextView textView = nVar2.gxs;
        Context context = this.qnE.cyC().getContext();
        if (!Util.isNullOrNil(ajy())) {
            ajy = ajy();
        } else if (Util.isNullOrNil(cyB())) {
            if (this.qnT == null) {
                as Kn = ((l) g.af(l.class)).aSN().Kn(this.qnQ);
                if (Kn != null) {
                    this.qnT = Kn.arI();
                } else {
                    this.qnT = "";
                }
            }
            ajy = this.qnT;
        } else {
            ajy = cyB();
        }
        textView.setText(com.tencent.mm.pluginsdk.ui.span.l.b(context, ajy, nVar2.gxs.getTextSize()));
        nVar2.timeTv.setText(m.h(getContext(), getTimeStamp()));
        nVar2.gBZ.setImageResource(cyA());
        nVar2.titleTv.setText(getFileName());
        if (cyt() == 0) {
            nVar2.hPW.setText(Util.getSizeKB((long) cyt()));
        } else {
            nVar2.hPW.setText(getFileExt().toUpperCase() + " " + Util.getSizeKB((long) cyt()));
        }
        if (aVar == null || aVar.getType() != 1) {
            nVar2.jWr.setVisibility(8);
        } else {
            nVar2.jWr.setVisibility(0);
        }
        nVar2.gxr.setVisibility(0);
        nVar2.qol.setVisibility(0);
        nVar2.kdb.setVisibility(8);
        nVar2.qoc.setVisibility(8);
        nVar2.qoj.setVisibility(8);
        if (isEnable()) {
            nVar2.qnZ.setAlpha(1.0f);
        } else {
            nVar2.qnZ.setAlpha(0.6f);
        }
        a(nVar2);
        if (cys().BY(this.qnv.field_msgId)) {
            nVar2.gxr.setChecked(true);
            AppMethodBeat.o(162333);
            return;
        }
        nVar2.gxr.setChecked(false);
        AppMethodBeat.o(162333);
    }

    private k.b cyz() {
        AppMethodBeat.i(123283);
        if (this.qnG == null) {
            this.qnG = k.b.HD(this.qnv.field_content);
        }
        k.b bVar = this.qnG;
        AppMethodBeat.o(123283);
        return bVar;
    }

    public String getUsername() {
        AppMethodBeat.i(123284);
        if (this.goe == null) {
            this.goe = c.b(this.qnv, ab.Eq(this.qnQ));
        }
        String str = this.goe;
        AppMethodBeat.o(123284);
        return str;
    }

    @Override // com.tencent.mm.plugin.choosemsgfile.b.b.a
    public String getFileExt() {
        AppMethodBeat.i(123285);
        if (cyz() != null) {
            String str = cyz().iwJ;
            AppMethodBeat.o(123285);
            return str;
        }
        AppMethodBeat.o(123285);
        return "";
    }

    public int cyA() {
        AppMethodBeat.i(123286);
        if (this.qnU == null) {
            this.qnU = Integer.valueOf(e.asl(getFileExt()));
        }
        int intValue = this.qnU.intValue();
        AppMethodBeat.o(123286);
        return intValue;
    }

    @Override // com.tencent.mm.plugin.choosemsgfile.b.b.a
    public String getFileName() {
        AppMethodBeat.i(123287);
        if (cyz() != null) {
            as Kn = ((l) g.af(l.class)).aSN().Kn(this.qnQ);
            if (Kn != null) {
                this.qnT = Kn.arI();
            }
            String str = cyz().title;
            AppMethodBeat.o(123287);
            return str;
        }
        AppMethodBeat.o(123287);
        return "";
    }

    @Override // com.tencent.mm.plugin.choosemsgfile.b.b.a
    public int cyt() {
        AppMethodBeat.i(123288);
        if (cyz() != null) {
            int i2 = cyz().iwI;
            AppMethodBeat.o(123288);
            return i2;
        }
        AppMethodBeat.o(123288);
        return 0;
    }

    private String cyB() {
        AppMethodBeat.i(123289);
        if (this.qnV == null) {
            ah ahVar = null;
            if (ab.Eq(this.qnQ)) {
                ahVar = ((com.tencent.mm.plugin.chatroom.a.c) g.af(com.tencent.mm.plugin.chatroom.a.c.class)).aSX().Kd(this.qnQ);
            }
            if (ahVar != null) {
                this.qnV = ahVar.getDisplayName(getUsername());
            } else {
                this.qnV = "";
            }
        }
        String str = this.qnV;
        AppMethodBeat.o(123289);
        return str;
    }

    private String ajy() {
        AppMethodBeat.i(123290);
        if (this.qnW == null) {
            as Kn = ((l) g.af(l.class)).aSN().Kn(this.qnQ);
            if (Kn != null) {
                this.qnW = Kn.field_conRemark;
            } else {
                this.qnW = "";
            }
        }
        String str = this.qnW;
        AppMethodBeat.o(123290);
        return str;
    }

    public k(com.tencent.mm.plugin.choosemsgfile.b.c.g gVar, ca caVar, String str) {
        super(gVar, caVar);
        this.qnQ = str;
    }

    @Override // com.tencent.mm.plugin.choosemsgfile.b.b.a
    public void a(View view, a aVar) {
        AppMethodBeat.i(123291);
        if (!cys().Cb(this.qnv.field_msgId) && !isInvalid()) {
            if (isEnable()) {
                c.g(getContext(), this.qnv.field_msgId);
                AppMethodBeat.o(123291);
                return;
            }
            c.V(getContext(), cys().mMaxCount);
        }
        AppMethodBeat.o(123291);
    }

    private void a(final n nVar) {
        AppMethodBeat.i(123292);
        if (Looper.getMainLooper() == Looper.myLooper()) {
            b(nVar);
            AppMethodBeat.o(123292);
            return;
        }
        MMHandlerThread.postToMainThread(new Runnable() {
            /* class com.tencent.mm.plugin.choosemsgfile.b.b.k.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(123282);
                k.a(k.this, nVar);
                AppMethodBeat.o(123282);
            }
        });
        AppMethodBeat.o(123292);
    }

    private void b(n nVar) {
        AppMethodBeat.i(123293);
        switch (this.qnF) {
            case 0:
                nVar.kdb.setVisibility(8);
                nVar.qoc.setVisibility(8);
                nVar.gxr.setVisibility(0);
                nVar.qol.setVisibility(0);
                nVar.gxr.setChecked(false);
                nVar.qoj.setVisibility(8);
                break;
            case 1:
                nVar.kdb.setVisibility(0);
                nVar.qoc.setVisibility(8);
                nVar.gxr.setVisibility(8);
                nVar.qol.setVisibility(8);
                nVar.qoj.setVisibility(8);
                AppMethodBeat.o(123293);
                return;
            case 2:
                nVar.kdb.setVisibility(0);
                nVar.qoc.setVisibility(0);
                nVar.gxr.setVisibility(8);
                nVar.qol.setVisibility(8);
                nVar.qoj.setVisibility(8);
                if (this.aqi > 0) {
                    int i2 = (int) ((((float) this.fs) / ((float) this.aqi)) * 100.0f);
                    if (i2 == -1 || i2 >= 100) {
                        nVar.qoc.setProgress(100);
                        AppMethodBeat.o(123293);
                        return;
                    }
                    nVar.qoc.setProgress(i2);
                    AppMethodBeat.o(123293);
                    return;
                }
                break;
            case 3:
                nVar.kdb.setVisibility(8);
                nVar.qoc.setVisibility(8);
                nVar.gxr.setVisibility(0);
                nVar.qol.setVisibility(0);
                nVar.qoj.setVisibility(8);
                AppMethodBeat.o(123293);
                return;
            case 4:
                nVar.kdb.setVisibility(8);
                nVar.qoc.setVisibility(8);
                nVar.gxr.setVisibility(8);
                nVar.qol.setVisibility(8);
                nVar.qoj.setVisibility(0);
                nVar.hPW.setText(getFileExt().toUpperCase() + " " + getContext().getString(R.string.b3s));
                AppMethodBeat.o(123293);
                return;
            case 5:
                nVar.kdb.setVisibility(8);
                nVar.qoc.setVisibility(8);
                nVar.gxr.setVisibility(8);
                nVar.qol.setVisibility(8);
                nVar.qoj.setVisibility(0);
                nVar.hPW.setText(getFileExt().toUpperCase() + " " + getContext().getString(R.string.b3r));
                AppMethodBeat.o(123293);
                return;
        }
        AppMethodBeat.o(123293);
    }

    @Override // com.tencent.mm.plugin.choosemsgfile.b.b.a
    public int getType() {
        return 1;
    }
}

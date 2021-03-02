package com.tencent.mm.plugin.appbrand.widget.dialog;

import android.app.Dialog;
import android.content.Context;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.d;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.plugin.appbrand.report.b;
import com.tencent.mm.plugin.appbrand.service.c;
import com.tencent.mm.plugin.crashfix.b.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.emo;
import com.tencent.mm.protocal.protobuf.emp;
import com.tencent.mm.protocal.protobuf.ffc;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class f {
    public boolean GfH = false;
    int Gga = 0;
    public RatingBar GhC;
    public TextView HZZ;
    public LinearLayout Iaa;
    public LinearLayout Iab;
    boolean Iac = false;
    public String appId;
    public String dCx;
    public Dialog dialog;
    public b lrj;
    public int mEO = -1;
    public TextView oqv;
    public int scene;
    public String sessionId;
    public String userName;

    static /* synthetic */ void a(f fVar, q qVar, ffc ffc) {
        AppMethodBeat.i(175093);
        fVar.a(qVar, true, null, ffc);
        AppMethodBeat.o(175093);
    }

    public f(c cVar) {
        AppMethodBeat.i(49886);
        com.tencent.mm.plugin.appbrand.game.b bVar = (com.tencent.mm.plugin.appbrand.game.b) cVar.S(com.tencent.mm.plugin.appbrand.game.b.class);
        if (bVar != null) {
            this.lrj = bVar.bCV();
        }
        AppMethodBeat.o(49886);
    }

    public static Dialog z(Context context, boolean z) {
        AppMethodBeat.i(49887);
        a aVar = new a(context, R.style.p);
        aVar.setCancelable(true);
        aVar.setCanceledOnTouchOutside(z);
        Window window = aVar.getWindow();
        if (window != null) {
            window.getDecorView().setPadding(0, 0, 0, 0);
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.gravity = 81;
            attributes.height = -2;
            attributes.width = -1;
            window.setAttributes(attributes);
            window.setWindowAnimations(R.style.o);
        }
        AppMethodBeat.o(49887);
        return aVar;
    }

    /* access modifiers changed from: package-private */
    public final void a(emo emo) {
        AppMethodBeat.i(49888);
        d.a aVar = new d.a();
        aVar.funcId = 2521;
        aVar.uri = "/cgi-bin/mmbiz-bin/wxabusiness/updateevaluate";
        aVar.iLN = emo;
        aVar.iLO = new emp();
        IPCRunCgi.a(aVar.aXF(), new IPCRunCgi.a() {
            /* class com.tencent.mm.plugin.appbrand.widget.dialog.f.AnonymousClass5 */

            @Override // com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a
            public final void a(int i2, int i3, String str, d dVar) {
                AppMethodBeat.i(49869);
                Log.i("MicroMsg.AppBrand.Evaluate.AppBrandEvaluateDialogHelper", "updateEvaluateCgi, errType:%s, errCode:%s, errMsg:%s", Integer.valueOf(i2), Integer.valueOf(i3), str);
                if (i2 != 0 || i3 != 0 || dVar == null || dVar.iLL.iLR == null || !(dVar.iLL.iLR instanceof emp)) {
                    Log.e("MicroMsg.AppBrand.Evaluate.AppBrandEvaluateDialogHelper", "updateEvaluateCgi, request fail");
                    if (f.this.GfH) {
                        f.this.eJ(3, 2);
                        AppMethodBeat.o(49869);
                        return;
                    }
                    f.this.eJ(2, 2);
                    AppMethodBeat.o(49869);
                    return;
                }
                Log.i("MicroMsg.AppBrand.Evaluate.AppBrandEvaluateDialogHelper", "updateEvaluateCgi, request success");
                if (f.this.GfH) {
                    f.this.eJ(3, 1);
                    AppMethodBeat.o(49869);
                    return;
                }
                f.this.eJ(2, 1);
                AppMethodBeat.o(49869);
            }
        });
        AppMethodBeat.o(49888);
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0032  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0055  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0069  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0073  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00fd  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0100  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0105  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x010a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(com.tencent.mm.plugin.appbrand.q r12, boolean r13, com.tencent.mm.protocal.protobuf.cxp r14, com.tencent.mm.protocal.protobuf.ffc r15) {
        /*
        // Method dump skipped, instructions count: 271
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.widget.dialog.f.a(com.tencent.mm.plugin.appbrand.q, boolean, com.tencent.mm.protocal.protobuf.cxp, com.tencent.mm.protocal.protobuf.ffc):void");
    }

    /* access modifiers changed from: package-private */
    public final void awx(int i2) {
        int i3 = R.string.kz;
        AppMethodBeat.i(49890);
        switch (i2) {
            case 2:
                i3 = R.string.l1;
                break;
            case 3:
                i3 = R.string.l0;
                break;
            case 4:
                i3 = R.string.ky;
                break;
            case 5:
                i3 = R.string.kx;
                break;
        }
        this.HZZ.setText(i3);
        AppMethodBeat.o(49890);
    }

    public final void show() {
        AppMethodBeat.i(49891);
        if (this.dialog != null) {
            this.dialog.show();
        }
        AppMethodBeat.o(49891);
    }

    public final void dismiss() {
        AppMethodBeat.i(49892);
        if (this.dialog != null) {
            this.dialog.dismiss();
            this.dialog = null;
        }
        AppMethodBeat.o(49892);
    }

    public final void eJ(int i2, int i3) {
        AppMethodBeat.i(49893);
        if (Util.isNullOrNil(this.appId)) {
            Log.e("MicroMsg.AppBrand.Evaluate.AppBrandEvaluateDialogHelper", "operateReport, no app id");
            AppMethodBeat.o(49893);
            return;
        }
        Log.i("MicroMsg.AppBrand.Evaluate.AppBrandEvaluateDialogHelper", "operateReport, appId:%s, eventId:%s, session:%s, score:%s, scene:%s, result:%s, path:%s", this.appId, Integer.valueOf(i2), this.sessionId, Integer.valueOf(this.Gga), Integer.valueOf(this.scene), Integer.valueOf(i3), this.dCx);
        h.INSTANCE.a(16176, this.appId, Integer.valueOf(i2), Long.valueOf(Util.nowSecond()), Integer.valueOf(this.Gga), this.sessionId, this.dCx, Integer.valueOf(this.scene), Integer.valueOf(i3));
        AppMethodBeat.o(49893);
    }
}

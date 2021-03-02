package com.tencent.mm.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.j;
import com.tencent.mm.ak.l;
import com.tencent.mm.api.c;
import com.tencent.mm.api.d;
import com.tencent.mm.api.m;
import com.tencent.mm.audio.a.a;
import com.tencent.mm.bb.n;
import com.tencent.mm.bb.v;
import com.tencent.mm.booter.o;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.g.a.xr;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bg;
import com.tencent.mm.modelmulti.f;
import com.tencent.mm.modelmulti.p;
import com.tencent.mm.plugin.gallery.picker.view.ImageCropUI;
import com.tencent.mm.plugin.game.api.b;
import com.tencent.mm.pluginsdk.k;
import com.tencent.mm.pluginsdk.model.app.h;
import com.tencent.mm.pluginsdk.model.app.q;
import com.tencent.mm.pluginsdk.ui.tools.s;
import com.tencent.mm.protocal.protobuf.cpl;
import com.tencent.mm.protocal.protobuf.drt;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.MMAppMgr;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.z;

/* access modifiers changed from: package-private */
public final class ak implements l, m, k, com.tencent.mm.pluginsdk.l {
    ak() {
    }

    @Override // com.tencent.mm.pluginsdk.l
    public final void WZ() {
        AppMethodBeat.i(19502);
        p.bdS().tE(7);
        AppMethodBeat.o(19502);
    }

    @Override // com.tencent.mm.pluginsdk.l
    public final void iO(int i2) {
        AppMethodBeat.i(19503);
        Log.d("MicroMsg.WorkerModelCallback", "trigger netscene sync, scene[%d]", Integer.valueOf(i2));
        p.bdS().tE(i2);
        AppMethodBeat.o(19503);
    }

    @Override // com.tencent.mm.ak.l
    public final com.tencent.mm.ak.k Xa() {
        AppMethodBeat.i(19504);
        a aVar = new a(MMApplicationContext.getContext());
        AppMethodBeat.o(19504);
        return aVar;
    }

    @Override // com.tencent.mm.pluginsdk.l
    public final String w(String str, int i2) {
        AppMethodBeat.i(19505);
        if (h.gE(str, i2) != null) {
            String str2 = h.gE(str, i2).field_packageName;
            AppMethodBeat.o(19505);
            return str2;
        }
        AppMethodBeat.o(19505);
        return "";
    }

    @Override // com.tencent.mm.pluginsdk.l
    public final String r(Context context, String str) {
        AppMethodBeat.i(19507);
        String r = h.r(context, str);
        AppMethodBeat.o(19507);
        return r;
    }

    @Override // com.tencent.mm.pluginsdk.l
    public final boolean gp(String str) {
        AppMethodBeat.i(19508);
        boolean gp = h.gp(str);
        AppMethodBeat.o(19508);
        return gp;
    }

    @Override // com.tencent.mm.pluginsdk.l
    public final boolean s(Context context, String str) {
        AppMethodBeat.i(19509);
        boolean s = h.s(context, str);
        AppMethodBeat.o(19509);
        return s;
    }

    @Override // com.tencent.mm.pluginsdk.l
    public final String e(Context context, String str, String str2) {
        AppMethodBeat.i(19510);
        String e2 = q.e(context, str, str2);
        AppMethodBeat.o(19510);
        return e2;
    }

    @Override // com.tencent.mm.pluginsdk.l
    public final String R(String str, String str2) {
        AppMethodBeat.i(19511);
        String R = q.R(str, str2);
        AppMethodBeat.o(19511);
        return R;
    }

    @Override // com.tencent.mm.pluginsdk.l
    public final void a(Context context, String str, String str2, String str3, int i2, int i3, int i4, String str4, String str5) {
        AppMethodBeat.i(19512);
        b dSQ = b.a.dSQ();
        if (dSQ != null) {
            dSQ.a(context, str, str2, str3, i2, i3, i4, str4, str5, "");
        }
        AppMethodBeat.o(19512);
    }

    @Override // com.tencent.mm.pluginsdk.l
    public final void a(String str, String str2, int i2, String str3, long j2) {
        AppMethodBeat.i(19513);
        b dSQ = b.a.dSQ();
        if (dSQ != null) {
            dSQ.a(str, str2, i2, 4, str3, j2, "", 0);
        }
        AppMethodBeat.o(19513);
    }

    @Override // com.tencent.mm.pluginsdk.l
    public final void Xb() {
        AppMethodBeat.i(19514);
        xr xrVar = new xr();
        xrVar.edW.edY = true;
        EventCenter.instance.publish(xrVar);
        AppMethodBeat.o(19514);
    }

    @Override // com.tencent.mm.pluginsdk.l
    public final com.tencent.mm.ak.q cR(boolean z) {
        AppMethodBeat.i(19515);
        if (z) {
            v.bev().tI(4);
        }
        n nVar = new n(4);
        bg.azz().a(nVar, 0);
        AppMethodBeat.o(19515);
        return nVar;
    }

    @Override // com.tencent.mm.pluginsdk.l
    public final boolean gq(String str) {
        AppMethodBeat.i(19516);
        boolean gq = h.gq(str);
        AppMethodBeat.o(19516);
        return gq;
    }

    @Override // com.tencent.mm.pluginsdk.l
    public final boolean a(Context context, int i2, int i3, String str) {
        AppMethodBeat.i(19517);
        boolean a2 = z.a.a(context, i2, i3, str, 4);
        AppMethodBeat.o(19517);
        return a2;
    }

    @Override // com.tencent.mm.pluginsdk.l
    public final boolean b(Context context, int i2, int i3, String str) {
        AppMethodBeat.i(19518);
        boolean a2 = z.a.a(context, i2, i3, str, 7);
        AppMethodBeat.o(19518);
        return a2;
    }

    @Override // com.tencent.mm.pluginsdk.l
    public final void Xc() {
        AppMethodBeat.i(19519);
        MMAppMgr.Xc();
        AppMethodBeat.o(19519);
    }

    @Override // com.tencent.mm.pluginsdk.l
    public final boolean s(Activity activity) {
        AppMethodBeat.i(19520);
        if (!e.apn()) {
            u.g(activity, null);
            AppMethodBeat.o(19520);
            return false;
        }
        s.o(activity, 2);
        AppMethodBeat.o(19520);
        return true;
    }

    @Override // com.tencent.mm.pluginsdk.l
    public final void bU(Context context) {
        AppMethodBeat.i(19521);
        MMAppMgr.jO(context);
        AppMethodBeat.o(19521);
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.pluginsdk.l
    public final Bitmap b(Activity activity, int i2, int i3, Intent intent) {
        AppMethodBeat.i(19523);
        if (i3 != -1) {
            AppMethodBeat.o(19523);
            return null;
        }
        switch (i2) {
            case 2:
                if (intent == null) {
                    AppMethodBeat.o(19523);
                    return null;
                }
                Intent intent2 = new Intent(activity, ImageCropUI.class);
                intent2.putExtra("CropImageMode", 1);
                intent2.putExtra("CropImage_Filter", true);
                intent2.putExtra("CropImage_OutputPath", com.tencent.mm.loader.j.b.aKR() + "temp.avatar");
                intent2.putExtra("CropImage_ImgPath", (String) null);
                intent2.putExtra("CropImage_from_scene", 3);
                com.tencent.mm.ui.tools.a.a(activity, intent, intent2, com.tencent.mm.loader.j.b.aKR(), 4);
                AppMethodBeat.o(19523);
                return null;
            case 3:
                String h2 = s.h(activity.getApplicationContext(), intent, com.tencent.mm.loader.j.b.aKR());
                if (h2 == null) {
                    AppMethodBeat.o(19523);
                    return null;
                }
                Intent intent3 = new Intent(activity, ImageCropUI.class);
                intent3.putExtra("CropImageMode", 1);
                intent3.putExtra("CropImage_OutputPath", com.tencent.mm.loader.j.b.aKR() + "temp.avatar");
                intent3.putExtra("CropImage_ImgPath", h2);
                intent3.putExtra("CropImage_from_scene", 3);
                activity.startActivityForResult(intent3, 4);
                AppMethodBeat.o(19523);
                return null;
            case 4:
                if (intent == null) {
                    AppMethodBeat.o(19523);
                    return null;
                }
                String stringExtra = intent.getStringExtra("CropImage_OutputPath");
                if (stringExtra == null) {
                    Log.e("MicroMsg.WorkerModelCallback", "crop picture failed");
                    break;
                } else {
                    Log.e("MicroMsg.WorkerModelCallback", "crop picture path %s ", stringExtra);
                    Bitmap bitmapNative = BitmapUtil.getBitmapNative(stringExtra);
                    AppMethodBeat.o(19523);
                    return bitmapNative;
                }
        }
        AppMethodBeat.o(19523);
        return null;
    }

    @Override // com.tencent.mm.pluginsdk.l
    public final Intent Xd() {
        AppMethodBeat.i(19524);
        Intent intent = new Intent(MMApplicationContext.getContext(), LauncherUI.class);
        intent.putExtra("nofification_type", "talkroom_notification");
        intent.addFlags(67108864);
        AppMethodBeat.o(19524);
        return intent;
    }

    @Override // com.tencent.mm.pluginsdk.l
    public final com.tencent.mm.ak.q a(j jVar) {
        AppMethodBeat.i(19525);
        if (com.tencent.mm.modelmulti.l.bdN()) {
            f fVar = new f(jVar);
            AppMethodBeat.o(19525);
            return fVar;
        }
        p.bdS().tE(4);
        AppMethodBeat.o(19525);
        return null;
    }

    @Override // com.tencent.mm.pluginsdk.l
    public final boolean a(as asVar) {
        AppMethodBeat.i(19526);
        boolean a2 = com.tencent.mm.modelmulti.a.a(asVar);
        AppMethodBeat.o(19526);
        return a2;
    }

    @Override // com.tencent.mm.api.m
    public final void a(c cVar, Activity activity, as asVar, boolean z, Runnable runnable) {
        AppMethodBeat.i(19527);
        com.tencent.mm.ui.tools.b.a(cVar, activity, asVar, z, runnable, 0);
        AppMethodBeat.o(19527);
    }

    @Override // com.tencent.mm.api.m
    public final void a(c cVar, Activity activity, as asVar) {
        AppMethodBeat.i(19528);
        com.tencent.mm.ui.tools.b.c(cVar, activity, asVar);
        AppMethodBeat.o(19528);
    }

    @Override // com.tencent.mm.pluginsdk.l
    public final void Xe() {
        AppMethodBeat.i(19531);
        o.Xe();
        AppMethodBeat.o(19531);
    }

    @Override // com.tencent.mm.pluginsdk.l
    public final void a(Context context, ca.a aVar, Bundle bundle) {
        AppMethodBeat.i(19532);
        com.tencent.mm.ui.contact.e.a(context, aVar, true, true, bundle);
        AppMethodBeat.o(19532);
    }

    @Override // com.tencent.mm.pluginsdk.l
    public final void a(Context context, as asVar, ca.a aVar, Bundle bundle, String str) {
        AppMethodBeat.i(19533);
        com.tencent.mm.ui.contact.e.a(context, asVar, aVar, true, true, bundle, str);
        AppMethodBeat.o(19533);
    }

    @Override // com.tencent.mm.pluginsdk.l
    public final void a(Intent intent, String str) {
        AppMethodBeat.i(19534);
        com.tencent.mm.ui.contact.e.a(intent, str);
        AppMethodBeat.o(19534);
    }

    @Override // com.tencent.mm.pluginsdk.l
    public final void gr(String str) {
        AppMethodBeat.i(19535);
        com.tencent.mm.as.b.bch();
        com.tencent.mm.as.b.Om(str);
        AppMethodBeat.o(19535);
    }

    @Override // com.tencent.mm.pluginsdk.l
    public final void a(cpl cpl, String str, int i2) {
        AppMethodBeat.i(231411);
        ((com.tencent.mm.plugin.messenger.foundation.a.e) g.af(com.tencent.mm.plugin.messenger.foundation.a.e.class)).processModContact(cpl, str, null, true, false, i2);
        AppMethodBeat.o(231411);
    }

    @Override // com.tencent.mm.pluginsdk.l
    public final boolean Xf() {
        AppMethodBeat.i(19537);
        boolean bdN = com.tencent.mm.modelmulti.l.bdN();
        AppMethodBeat.o(19537);
        return bdN;
    }

    @Override // com.tencent.mm.pluginsdk.l
    public final String go(String str) {
        AppMethodBeat.i(19506);
        if (h.o(str, false, false) != null) {
            String str2 = h.o(str, false, false).field_packageName;
            AppMethodBeat.o(19506);
            return str2;
        }
        AppMethodBeat.o(19506);
        return "";
    }

    @Override // com.tencent.mm.pluginsdk.l
    public final void t(Activity activity) {
        AppMethodBeat.i(19522);
        MMAppMgr.a(activity, null);
        AppMethodBeat.o(19522);
    }

    @Override // com.tencent.mm.pluginsdk.k
    public final void a(Intent intent, drt drt, int i2) {
        AppMethodBeat.i(19530);
        d.a(intent, drt, i2);
        AppMethodBeat.o(19530);
    }
}

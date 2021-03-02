package com.tencent.mm.ui.tools;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.al.a;
import com.tencent.mm.al.ag;
import com.tencent.mm.api.c;
import com.tencent.mm.api.q;
import com.tencent.mm.ba.d;
import com.tencent.mm.g.a.an;
import com.tencent.mm.g.a.fm;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.bp;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.u;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.base.h;
import java.lang.ref.WeakReference;

public final class b {
    private static boolean isDeleteCancel = false;

    public static void a(c cVar, Activity activity, as asVar, int i2) {
        AppMethodBeat.i(38982);
        a(cVar, activity, asVar, false, null, i2);
        AppMethodBeat.o(38982);
    }

    public static void a(final c cVar, final Activity activity, final as asVar, final boolean z, final Runnable runnable, final int i2) {
        String string;
        AppMethodBeat.i(38983);
        if (cVar == null || activity == null || asVar == null) {
            Object[] objArr = new Object[3];
            objArr[0] = Boolean.valueOf(cVar == null);
            objArr[1] = Boolean.valueOf(activity == null);
            objArr[2] = Boolean.valueOf(asVar == null);
            Log.e("MicroMsg.BizContactDeleteUtil", "bizInfo null : %s, context null : %s, ct null : %s", objArr);
            AppMethodBeat.o(38983);
            return;
        }
        if (cVar.UG()) {
            string = activity.getString(R.string.alw);
        } else {
            string = activity.getString(R.string.alx, new Object[]{asVar.arJ()});
        }
        h.a(activity, string, "", activity.getString(R.string.bew), activity.getString(R.string.bev), new DialogInterface.OnClickListener() {
            /* class com.tencent.mm.ui.tools.b.AnonymousClass1 */

            public final void onClick(DialogInterface dialogInterface, int i2) {
                AppMethodBeat.i(38978);
                b.a(cVar, activity, asVar, z, i2);
                ((q) g.af(q.class)).c(cVar);
                if (runnable != null) {
                    runnable.run();
                }
                AppMethodBeat.o(38978);
            }
        }, (DialogInterface.OnClickListener) null, (int) R.color.a5c);
        AppMethodBeat.o(38983);
    }

    public static void c(c cVar, Activity activity, as asVar) {
        AppMethodBeat.i(38984);
        a(cVar, activity, asVar, false, 0);
        AppMethodBeat.o(38984);
    }

    public static void a(final c cVar, Activity activity, as asVar, boolean z, int i2) {
        boolean z2;
        boolean z3 = true;
        AppMethodBeat.i(38985);
        if (cVar == null || activity == null || asVar == null) {
            Object[] objArr = new Object[3];
            objArr[0] = Boolean.valueOf(cVar == null);
            if (activity == null) {
                z2 = true;
            } else {
                z2 = false;
            }
            objArr[1] = Boolean.valueOf(z2);
            if (asVar != null) {
                z3 = false;
            }
            objArr[2] = Boolean.valueOf(z3);
            Log.e("MicroMsg.BizContactDeleteUtil", "error args, %b, %b, %b", objArr);
            AppMethodBeat.o(38985);
            return;
        }
        final String str = asVar.field_username;
        asVar.aqR();
        bg.aVF();
        com.tencent.mm.model.c.aSM().d(new d(str, i2));
        if (ab.IQ(str)) {
            ((l) g.af(l.class)).aSN().aNa(str);
            bg.aVF();
            com.tencent.mm.model.c.aSX().Kj(str);
        } else {
            isDeleteCancel = false;
            activity.getString(R.string.zb);
            final WeakReference weakReference = new WeakReference(h.a((Context) activity, activity.getString(R.string.a06), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
                /* class com.tencent.mm.ui.tools.b.AnonymousClass2 */

                public final void onCancel(DialogInterface dialogInterface) {
                    AppMethodBeat.i(38979);
                    boolean unused = b.isDeleteCancel = true;
                    AppMethodBeat.o(38979);
                }
            }));
            AnonymousClass3 r4 = new bp.a() {
                /* class com.tencent.mm.ui.tools.b.AnonymousClass3 */

                @Override // com.tencent.mm.model.bp.a
                public final boolean amG() {
                    AppMethodBeat.i(38980);
                    boolean z = b.isDeleteCancel;
                    AppMethodBeat.o(38980);
                    return z;
                }

                @Override // com.tencent.mm.model.bp.a
                public final void amH() {
                    AppMethodBeat.i(38981);
                    if (cVar.UD()) {
                        g.af(com.tencent.mm.al.q.class);
                        u.biP(str);
                        an anVar = new an();
                        anVar.dDr.userName = str;
                        EventCenter.instance.publish(anVar);
                    }
                    ag.bah().delete(str);
                    if (weakReference.get() != null) {
                        ((com.tencent.mm.ui.base.q) weakReference.get()).dismiss();
                    }
                    AppMethodBeat.o(38981);
                }
            };
            ag.bau();
            a.ML(str);
            ((l) g.af(l.class)).aSN().c(str, asVar);
            if (cVar.UF()) {
                com.tencent.mm.al.g.Nj(cVar.field_username);
            } else {
                bp.a(str, r4);
                bg.aVF();
                com.tencent.mm.model.c.aST().bjW(str);
            }
            if (activity != null && z) {
                activity.setResult(-1, activity.getIntent().putExtra("_delete_ok_", true));
            }
        }
        if (com.tencent.mm.app.plugin.a.a.d(cVar)) {
            fm fmVar = new fm();
            fmVar.dIM.brandName = str;
            EventCenter.instance.publish(fmVar);
        }
        ag.bag().No(str);
        ag.ban().aEn(str);
        ag.bap().aEn(str);
        if (z) {
            int intExtra = activity.getIntent().getIntExtra("Kdel_from", -1);
            if (intExtra == 0) {
                Intent intent = new Intent(activity, LauncherUI.class);
                intent.addFlags(67108864);
                com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                com.tencent.mm.hellhoundlib.a.a.a(activity, bl.axQ(), "com/tencent/mm/ui/tools/BizContactDeleteUtil", "dealDelContactEvent", "(Lcom/tencent/mm/api/BizInfo;Landroid/app/Activity;Lcom/tencent/mm/storage/Contact;ZI)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                activity.startActivity((Intent) bl.pG(0));
                com.tencent.mm.hellhoundlib.a.a.a(activity, "com/tencent/mm/ui/tools/BizContactDeleteUtil", "dealDelContactEvent", "(Lcom/tencent/mm/api/BizInfo;Landroid/app/Activity;Lcom/tencent/mm/storage/Contact;ZI)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            } else if (intExtra == 2) {
                Intent intent2 = new Intent();
                intent2.addFlags(67108864);
                com.tencent.mm.br.c.b(activity, "brandservice", ".ui.BrandServiceIndexUI", intent2);
            }
            activity.finish();
        }
        AppMethodBeat.o(38985);
    }
}

package com.tencent.mm.plugin.profile.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ba.l;
import com.tencent.mm.g.a.ke;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.model.z;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.storage.MStorageEx;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.base.q;
import com.tencent.mm.ui.s;

public final class g extends m implements MStorageEx.IOnStorageChange {
    @Override // com.tencent.mm.plugin.profile.ui.m, com.tencent.mm.pluginsdk.b.a
    public final /* bridge */ /* synthetic */ boolean a(f fVar, as asVar, boolean z, int i2) {
        AppMethodBeat.i(27145);
        boolean a2 = super.a(fVar, asVar, z, i2);
        AppMethodBeat.o(27145);
        return a2;
    }

    @Override // com.tencent.mm.plugin.profile.ui.m, com.tencent.mm.pluginsdk.b.a
    public final /* bridge */ /* synthetic */ boolean cCs() {
        AppMethodBeat.i(27144);
        boolean cCs = super.cCs();
        AppMethodBeat.o(27144);
        return cCs;
    }

    @Override // com.tencent.mm.plugin.profile.ui.m, com.tencent.mm.pluginsdk.b.a
    public final /* bridge */ /* synthetic */ void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(27143);
        super.onActivityResult(i2, i3, intent);
        AppMethodBeat.o(27143);
    }

    @Override // com.tencent.mm.plugin.profile.ui.m, com.tencent.mm.sdk.storage.MStorageEx.IOnStorageChange
    public final /* bridge */ /* synthetic */ void onNotifyChange(int i2, MStorageEx mStorageEx, Object obj) {
        AppMethodBeat.i(27146);
        super.onNotifyChange(i2, mStorageEx, obj);
        AppMethodBeat.o(27146);
    }

    public g(Context context) {
        super(context, new r(context));
        AppMethodBeat.i(27137);
        EventCenter.instance.publish(new ke());
        AppMethodBeat.o(27137);
    }

    public static void clearData() {
        AppMethodBeat.i(27138);
        bg.aVF();
        c.aSQ().aEE("feedsapp");
        bg.aVF();
        c.aST().bjW("feedsapp");
        AppMethodBeat.o(27138);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.profile.ui.m
    public final void clear() {
        AppMethodBeat.i(27139);
        clearData();
        AppMethodBeat.o(27139);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.profile.ui.m
    public final void sH(final boolean z) {
        AppMethodBeat.i(27140);
        Context context = this.context;
        String string = z ? context.getString(R.string.gst) : context.getString(R.string.gt0);
        context.getString(R.string.zb);
        final q a2 = h.a(context, string, true, (DialogInterface.OnCancelListener) null);
        new MTimerHandler(new MTimerHandler.CallBack() {
            /* class com.tencent.mm.plugin.profile.ui.g.AnonymousClass1 */
            final /* synthetic */ s znB = null;

            @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
            public final boolean onTimerExpired() {
                int i2;
                AppMethodBeat.i(27135);
                int aUl = z.aUl();
                if (z) {
                    i2 = aUl & -32769;
                } else {
                    i2 = aUl | 32768;
                }
                bg.aVF();
                c.azQ().set(34, Integer.valueOf(i2));
                bg.aVF();
                c.aSM().d(new l("", "", "", "", "", "", "", "", i2, "", ""));
                if (!z) {
                    g.clearData();
                }
                if (this.znB != null) {
                    this.znB.onNotifyChange(null, null);
                }
                if (a2 != null) {
                    a2.dismiss();
                }
                AppMethodBeat.o(27135);
                return true;
            }
        }, false).startTimer(1500);
        AppMethodBeat.o(27140);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.profile.ui.m
    public final boolean eEv() {
        AppMethodBeat.i(27141);
        if ((z.aUl() & 32768) == 0) {
            AppMethodBeat.o(27141);
            return true;
        }
        AppMethodBeat.o(27141);
        return false;
    }

    @Override // com.tencent.mm.plugin.profile.ui.m, com.tencent.mm.pluginsdk.b.a
    public final boolean alD(String str) {
        AppMethodBeat.i(27142);
        if ("contact_info_plugin_view".equals(str)) {
            Intent intent = new Intent();
            intent.putExtra("sns_timeline_NeedFirstLoadint", true);
            com.tencent.mm.br.c.b(this.context, "sns", ".ui.SnsTimeLineUI", intent);
            AppMethodBeat.o(27142);
            return true;
        }
        if ("contact_info_plugin_outsize".equals(str)) {
            Intent intent2 = new Intent();
            intent2.putExtra("k_sns_tag_id", 4L);
            com.tencent.mm.br.c.b(this.context, "sns", ".ui.SnsBlackDetailUI", intent2);
        }
        if ("contact_info_plugin_black".equals(str)) {
            Intent intent3 = new Intent();
            intent3.putExtra("k_sns_tag_id", 5L);
            com.tencent.mm.br.c.b(this.context, "sns", ".ui.SnsTagDetailUI", intent3);
        }
        if (str.equals("contact_info_plugin_uninstall")) {
            h.c(this.context, this.context.getString(R.string.gsx), "", this.context.getString(R.string.z8), this.context.getString(R.string.sz), new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.plugin.profile.ui.g.AnonymousClass2 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(27136);
                    g.this.sH(false);
                    AppMethodBeat.o(27136);
                }
            }, null);
            AppMethodBeat.o(27142);
            return true;
        }
        boolean alD = super.alD(str);
        AppMethodBeat.o(27142);
        return alD;
    }
}

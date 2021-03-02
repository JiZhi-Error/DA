package com.tencent.mm.plugin.topstory.ui.widget;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.messenger.foundation.a.a.k;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.topstory.ui.c;
import com.tencent.mm.pluginsdk.ui.preference.HelperHeaderPreference;
import com.tencent.mm.protocal.protobuf.bfx;
import com.tencent.mm.protocal.protobuf.dbw;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorageEx;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.az;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.thumbplayer.core.common.TPMediaCodecProfileLevel;

public final class a implements com.tencent.mm.pluginsdk.b.a, MStorageEx.IOnStorageChange {
    private as contact;
    private Context context;
    private CheckBoxPreference qNs;
    private f screen;

    static /* synthetic */ void a(a aVar) {
        AppMethodBeat.i(236419);
        aVar.wx(false);
        AppMethodBeat.o(236419);
    }

    public a(Context context2) {
        this.context = context2;
    }

    @Override // com.tencent.mm.pluginsdk.b.a
    public final boolean a(f fVar, as asVar, boolean z, int i2) {
        AppMethodBeat.i(126625);
        this.screen = fVar;
        this.contact = asVar;
        fVar.addPreferencesFromResource(R.xml.ai);
        g.aAh().azQ().add(this);
        this.qNs = (CheckBoxPreference) fVar.bmg("contact_info_top_story_not_disturb");
        cCt();
        AppMethodBeat.o(126625);
        return true;
    }

    @Override // com.tencent.mm.pluginsdk.b.a
    public final boolean cCs() {
        AppMethodBeat.i(126626);
        g.aAh().azQ().remove(this);
        AppMethodBeat.o(126626);
        return true;
    }

    @Override // com.tencent.mm.pluginsdk.b.a
    public final boolean alD(String str) {
        int i2;
        int i3;
        AppMethodBeat.i(126627);
        if ("contact_info_go_to_top_story".equals(str)) {
            c.as(this.context, 0);
        } else if ("contact_info_top_story_install".equals(str)) {
            wx(true);
        } else if ("contact_info_top_story_uninstall".equals(str)) {
            h.c(this.context, this.context.getString(R.string.gsw), "", this.context.getString(R.string.t2), this.context.getString(R.string.sz), new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.plugin.topstory.ui.widget.a.AnonymousClass1 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(126624);
                    a.a(a.this);
                    AppMethodBeat.o(126624);
                }
            }, null);
        } else if ("contact_info_top_story_not_disturb".equals(str)) {
            int aUe = z.aUe();
            if (this.qNs.isChecked()) {
                i2 = aUe & -16777217;
            } else {
                i2 = aUe | TPMediaCodecProfileLevel.HEVCMainTierLevel62;
            }
            g.aAh().azQ().set(40, Integer.valueOf(i2));
            bfx bfx = new bfx();
            bfx.LPB = 55;
            if (this.qNs.isChecked()) {
                i3 = 2;
            } else {
                i3 = 1;
            }
            bfx.BsD = i3;
            ((l) g.af(l.class)).aSM().d(new k.a(55, bfx));
        }
        AppMethodBeat.o(126627);
        return false;
    }

    private void wx(boolean z) {
        int i2;
        AppMethodBeat.i(126628);
        int aUl = z.aUl();
        if (z) {
            i2 = aUl & -67108865;
        } else {
            i2 = aUl | 67108864;
        }
        g.aAh().azQ().set(34, Integer.valueOf(i2));
        dbw dbw = new dbw();
        dbw.KEc = 67108864;
        dbw.MGK = z ? 0 : 1;
        ((l) g.af(l.class)).aSM().d(new k.a(39, dbw));
        cCt();
        if (z) {
            if (((l) g.af(l.class)).aST().bjY("topstoryapp") == null) {
                az azVar = new az();
                azVar.setUsername("topstoryapp");
                azVar.setContent(this.context.getString(R.string.bhb));
                azVar.yA(Util.nowMilliSecond());
                azVar.nv(0);
                azVar.nt(0);
                ((l) g.af(l.class)).aST().e(azVar);
            }
            AppMethodBeat.o(126628);
            return;
        }
        ((l) g.af(l.class)).aST().bjW("topstoryapp");
        AppMethodBeat.o(126628);
    }

    @Override // com.tencent.mm.pluginsdk.b.a
    public final void onActivityResult(int i2, int i3, Intent intent) {
    }

    private void cCt() {
        AppMethodBeat.i(126629);
        HelperHeaderPreference helperHeaderPreference = (HelperHeaderPreference) this.screen.bmg("contact_info_header_helper");
        helperHeaderPreference.bk(this.contact.field_username, this.contact.arJ(), this.context.getString(R.string.bhb));
        if ((z.aUl() & 67108864) == 0) {
            helperHeaderPreference.updateStatus(1);
            this.screen.m38do("contact_info_top_story_install", true);
            this.screen.m38do("contact_info_top_story_uninstall", false);
            this.screen.m38do("contact_info_go_to_top_story", false);
            this.screen.m38do("contact_info_top_story_not_disturb", false);
        } else {
            helperHeaderPreference.updateStatus(0);
            this.screen.m38do("contact_info_top_story_install", false);
            this.screen.m38do("contact_info_top_story_uninstall", true);
            this.screen.m38do("contact_info_go_to_top_story", true);
            this.screen.m38do("contact_info_top_story_not_disturb", true);
        }
        if (fzX()) {
            this.qNs.setChecked(true);
            AppMethodBeat.o(126629);
            return;
        }
        this.qNs.setChecked(false);
        AppMethodBeat.o(126629);
    }

    @Override // com.tencent.mm.sdk.storage.MStorageEx.IOnStorageChange
    public final void onNotifyChange(int i2, MStorageEx mStorageEx, Object obj) {
        AppMethodBeat.i(126630);
        int nullAsInt = Util.nullAsInt(obj, 0);
        if (mStorageEx != g.aAh().azQ() || nullAsInt <= 0) {
            AppMethodBeat.o(126630);
        } else if (nullAsInt == 40 || nullAsInt == 34 || nullAsInt == 7) {
            cCt();
            AppMethodBeat.o(126630);
        } else {
            AppMethodBeat.o(126630);
        }
    }

    private static boolean fzX() {
        AppMethodBeat.i(126631);
        if ((z.aUe() & TPMediaCodecProfileLevel.HEVCMainTierLevel62) == 0) {
            AppMethodBeat.o(126631);
            return true;
        }
        AppMethodBeat.o(126631);
        return false;
    }
}

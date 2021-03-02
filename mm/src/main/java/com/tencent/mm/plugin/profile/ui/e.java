package com.tencent.mm.plugin.profile.ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ba.h;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.bp;
import com.tencent.mm.model.c;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.account.friend.a.l;
import com.tencent.mm.plugin.profile.b;
import com.tencent.mm.plugin.profile.ui.HelperHeaderPreference;
import com.tencent.mm.pluginsdk.b.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.base.q;
import junit.framework.Assert;

public final class e implements a {
    private boolean Bdx;
    private HelperHeaderPreference.a Bfp;
    private as contact;
    Context context;
    boolean isDeleteCancel = false;
    private f screen;
    private int status;
    q tipDialog = null;

    public e(Context context2) {
        AppMethodBeat.i(27119);
        this.context = context2;
        this.Bfp = new p(context2);
        this.status = -1;
        AppMethodBeat.o(27119);
    }

    @Override // com.tencent.mm.pluginsdk.b.a
    public final boolean alD(String str) {
        int i2;
        boolean z;
        boolean z2 = false;
        AppMethodBeat.i(27120);
        Log.d("MicroMsg.ContactWidgetFMessage", "handlerEvent : key = ".concat(String.valueOf(str)));
        if (Util.nullAsNil(str).length() <= 0) {
            AppMethodBeat.o(27120);
            return false;
        } else if (str.equals("contact_info_recommend_qqfriends_to_me")) {
            if (!((CheckBoxPreference) this.screen.bmg("contact_info_recommend_qqfriends_to_me")).isChecked()) {
                z = true;
            } else {
                z = false;
            }
            i(z, 128, 6);
            AppMethodBeat.o(27120);
            return true;
        } else if (str.equals("contact_info_recommend_mobilefriends_to_me")) {
            if (!((CheckBoxPreference) this.screen.bmg("contact_info_recommend_mobilefriends_to_me")).isChecked()) {
                z2 = true;
            }
            i(z2, 256, 7);
            AppMethodBeat.o(27120);
            return true;
        } else if (str.equals("contact_info_recommend_fbfriends_to_me")) {
            boolean isChecked = ((CheckBoxPreference) this.screen.bmg("contact_info_recommend_fbfriends_to_me")).isChecked();
            Log.d("MicroMsg.ContactWidgetFMessage", "switch change : open = " + isChecked + " item value = 4 functionId = 18");
            int aUe = z.aUe();
            if (isChecked) {
                i2 = aUe | 4;
            } else {
                i2 = aUe & -5;
            }
            bg.aVF();
            c.azQ().set(40, Integer.valueOf(i2));
            int i3 = isChecked ? 1 : 2;
            bg.aVF();
            c.aSM().d(new h(18, i3));
            AppMethodBeat.o(27120);
            return true;
        } else if (str.equals("contact_info_view_message")) {
            Intent intent = new Intent();
            if (this.Bdx) {
                intent.putExtra("Chat_User", this.contact.field_username);
                intent.putExtra("Chat_Mode", 1);
                intent.addFlags(67108864);
                ((Activity) this.context).setResult(-1, intent);
                ((Activity) this.context).finish();
            } else {
                intent.putExtra("Chat_User", this.contact.field_username);
                intent.putExtra("Chat_Mode", 1);
                intent.addFlags(67108864);
                b.jRt.d(intent, this.context);
                ((Activity) this.context).finish();
            }
            AppMethodBeat.o(27120);
            return true;
        } else if (str.equals("contact_info_bind_mobile_entry")) {
            b.jRt.f(new Intent(), this.context);
            AppMethodBeat.o(27120);
            return true;
        } else if (str.equals("contact_info_bind_qq_entry")) {
            b.jRt.g(new Intent(), this.context);
            AppMethodBeat.o(27120);
            return true;
        } else if (str.equals("contact_info_bind_fb_entry")) {
            com.tencent.mm.br.c.b(this.context, "account", ".ui.FacebookAuthUI", new Intent());
            AppMethodBeat.o(27120);
            return true;
        } else if (str.equals("contact_info_fmessage_clear_data")) {
            com.tencent.mm.ui.base.h.c(this.context, this.context.getString(R.string.ba3), "", this.context.getString(R.string.t2), this.context.getString(R.string.sz), new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.plugin.profile.ui.e.AnonymousClass1 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(27117);
                    e eVar = e.this;
                    eVar.isDeleteCancel = false;
                    Context context = eVar.context;
                    eVar.context.getString(R.string.zb);
                    eVar.tipDialog = com.tencent.mm.ui.base.h.a(context, eVar.context.getString(R.string.a06), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
                        /* class com.tencent.mm.plugin.profile.ui.e.AnonymousClass2 */

                        public final void onCancel(DialogInterface dialogInterface) {
                            e.this.isDeleteCancel = true;
                        }
                    });
                    bp.a("fmessage", new bp.a() {
                        /* class com.tencent.mm.plugin.profile.ui.e.AnonymousClass3 */

                        @Override // com.tencent.mm.model.bp.a
                        public final boolean amG() {
                            return e.this.isDeleteCancel;
                        }

                        @Override // com.tencent.mm.model.bp.a
                        public final void amH() {
                            AppMethodBeat.i(27118);
                            if (e.this.tipDialog != null) {
                                e.this.tipDialog.dismiss();
                                e.this.tipDialog = null;
                            }
                            AppMethodBeat.o(27118);
                        }
                    });
                    bg.aVF();
                    c.aST().bjW("fmessage");
                    AppMethodBeat.o(27117);
                }
            }, null);
            AppMethodBeat.o(27120);
            return true;
        } else {
            Log.e("MicroMsg.ContactWidgetFMessage", "handleEvent : unExpected key = ".concat(String.valueOf(str)));
            AppMethodBeat.o(27120);
            return false;
        }
    }

    private void i(boolean z, int i2, int i3) {
        AppMethodBeat.i(27121);
        Log.d("MicroMsg.ContactWidgetFMessage", "switch change : open = " + z + " item value = " + i2 + " functionId = " + i3);
        if (z) {
            this.status |= i2;
        } else {
            this.status &= i2 ^ -1;
        }
        bg.aVF();
        c.azQ().set(7, Integer.valueOf(this.status));
        int i4 = z ? 1 : 2;
        bg.aVF();
        c.aSM().d(new h(i3, i4));
        AppMethodBeat.o(27121);
    }

    @Override // com.tencent.mm.pluginsdk.b.a
    public final boolean a(f fVar, as asVar, boolean z, int i2) {
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6 = false;
        AppMethodBeat.i(27122);
        Assert.assertTrue(fVar != null);
        if (asVar != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        Assert.assertTrue(z2);
        Assert.assertTrue(ab.IX(asVar.field_username));
        this.screen = fVar;
        this.Bdx = z;
        this.contact = asVar;
        if (this.status == -1) {
            this.status = z.aUc();
        }
        fVar.addPreferencesFromResource(R.xml.a0);
        CheckBoxPreference checkBoxPreference = (CheckBoxPreference) fVar.bmg("contact_info_recommend_qqfriends_to_me");
        CheckBoxPreference checkBoxPreference2 = (CheckBoxPreference) fVar.bmg("contact_info_recommend_mobilefriends_to_me");
        CheckBoxPreference checkBoxPreference3 = (CheckBoxPreference) fVar.bmg("contact_info_recommend_fbfriends_to_me");
        checkBoxPreference2.setChecked(!UM(256));
        if (!UM(128)) {
            z3 = true;
        } else {
            z3 = false;
        }
        checkBoxPreference.setChecked(z3);
        if ((z.aUe() & 4) != 0) {
            z4 = true;
        } else {
            z4 = false;
        }
        checkBoxPreference3.setChecked(z4);
        ((HelperHeaderPreference) fVar.bmg("contact_info_header_helper")).a(asVar, this.Bfp);
        bg.aVF();
        if (Util.nullAsNil((Integer) c.azQ().get(9, null)) != 0) {
            fVar.e(fVar.bmg("contact_info_bind_qq_entry"));
            fVar.e(fVar.bmg("contact_info_bind_qq_entry_tip"));
        } else {
            fVar.e(checkBoxPreference);
            if (!com.tencent.mm.aw.b.bdE()) {
                fVar.e(fVar.bmg("contact_info_bind_qq_entry"));
                fVar.e(fVar.bmg("contact_info_bind_qq_entry_tip"));
            }
        }
        if (l.bnZ() == l.a.SUCC) {
            z5 = true;
        } else {
            z5 = false;
        }
        if (z5) {
            fVar.e(fVar.bmg("contact_info_bind_mobile_entry"));
            fVar.e(fVar.bmg("contact_info_bind_mobile_entry_tip"));
        } else {
            fVar.e(checkBoxPreference2);
            fVar.bmg("contact_info_bind_mobile_entry").setSummary(R.string.gnr);
        }
        if ((z.aUl() & 8192) == 0) {
            z6 = true;
        }
        if (z6) {
            boolean aUF = z.aUF();
            com.tencent.mm.aw.b.bdF();
            fVar.e(checkBoxPreference3);
            if (!aUF) {
                fVar.bmg("contact_info_bind_fb_entry").setSummary(R.string.gnr);
            } else {
                fVar.bmg("contact_info_bind_fb_entry").setSummary(R.string.bau);
            }
        } else {
            fVar.e(fVar.bmg("contact_info_bind_fb_entry"));
            fVar.e(fVar.bmg("contact_info_bind_fb_entry_tip"));
            fVar.e(checkBoxPreference3);
        }
        AppMethodBeat.o(27122);
        return true;
    }

    private boolean UM(int i2) {
        return (this.status & i2) != 0;
    }

    @Override // com.tencent.mm.pluginsdk.b.a
    public final boolean cCs() {
        AppMethodBeat.i(27123);
        b.jRu.WZ();
        this.screen.bmg("contact_info_header_helper");
        AppMethodBeat.o(27123);
        return true;
    }

    @Override // com.tencent.mm.pluginsdk.b.a
    public final void onActivityResult(int i2, int i3, Intent intent) {
    }
}

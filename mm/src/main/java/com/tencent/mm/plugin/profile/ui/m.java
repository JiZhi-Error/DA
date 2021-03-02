package com.tencent.mm.plugin.profile.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.profile.ui.HelperHeaderPreference;
import com.tencent.mm.pluginsdk.b.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorageEx;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.f;
import junit.framework.Assert;

/* access modifiers changed from: package-private */
public abstract class m implements a, MStorageEx.IOnStorageChange {
    protected HelperHeaderPreference.a BfU;
    protected as contact;
    protected Context context;
    protected f screen;

    /* access modifiers changed from: protected */
    public abstract void clear();

    /* access modifiers changed from: protected */
    public abstract boolean eEv();

    /* access modifiers changed from: protected */
    public abstract void sH(boolean z);

    public m(Context context2, HelperHeaderPreference.a aVar) {
        this.context = context2;
        this.BfU = aVar;
    }

    @Override // com.tencent.mm.sdk.storage.MStorageEx.IOnStorageChange
    public void onNotifyChange(int i2, MStorageEx mStorageEx, Object obj) {
        int nullAsInt = Util.nullAsInt(obj, 0);
        Log.d("MicroMsg.ContactWidgetPlugin", "onNotifyChange event:%d obj:%d stg:%s", Integer.valueOf(i2), Integer.valueOf(nullAsInt), mStorageEx);
        bg.aVF();
        if (mStorageEx != c.azQ() || nullAsInt <= 0) {
            Log.e("MicroMsg.ContactWidgetPlugin", "onNotifyChange error obj:%d stg:%s", Integer.valueOf(nullAsInt), mStorageEx);
        } else if (nullAsInt == 40 || nullAsInt == 34 || nullAsInt == 7) {
            cCt();
        }
    }

    @Override // com.tencent.mm.pluginsdk.b.a
    public boolean a(f fVar, as asVar, boolean z, int i2) {
        boolean z2;
        boolean z3;
        boolean z4 = false;
        if (asVar != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        Assert.assertTrue(z2);
        if (Util.nullAsNil(asVar.field_username).length() > 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        Assert.assertTrue(z3);
        if (fVar != null) {
            z4 = true;
        }
        Assert.assertTrue(z4);
        bg.aVF();
        c.azQ().add(this);
        this.contact = asVar;
        this.screen = fVar;
        cCt();
        return true;
    }

    @Override // com.tencent.mm.pluginsdk.b.a
    public boolean cCs() {
        bg.aVF();
        c.azQ().remove(this);
        this.screen.bmg("contact_info_header_helper");
        return true;
    }

    @Override // com.tencent.mm.pluginsdk.b.a
    public boolean alD(String str) {
        if ("contact_info_plugin_clear_data".equals(str)) {
            h.c(this.context, this.context.getString(R.string.ba3), "", this.context.getString(R.string.t2), this.context.getString(R.string.sz), new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.plugin.profile.ui.m.AnonymousClass1 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(27204);
                    m.this.clear();
                    AppMethodBeat.o(27204);
                }
            }, null);
            return true;
        } else if (str.equals("contact_info_plugin_install")) {
            sH(true);
            return true;
        } else if (str.equals("contact_info_plugin_uninstall")) {
            h.c(this.context, this.context.getString(R.string.gsw), "", this.context.getString(R.string.t2), this.context.getString(R.string.sz), new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.plugin.profile.ui.m.AnonymousClass2 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(27205);
                    m.this.sH(false);
                    AppMethodBeat.o(27205);
                }
            }, null);
            return true;
        } else {
            Log.e("MicroMsg.ContactWidgetPlugin", "handleEvent : unexpected key = ".concat(String.valueOf(str)));
            return false;
        }
    }

    @Override // com.tencent.mm.pluginsdk.b.a
    public void onActivityResult(int i2, int i3, Intent intent) {
    }

    private void cCt() {
        this.screen.removeAll();
        this.screen.addPreferencesFromResource(R.xml.z);
        boolean eEv = eEv();
        HelperHeaderPreference helperHeaderPreference = (HelperHeaderPreference) this.screen.bmg("contact_info_header_helper");
        if (helperHeaderPreference != null) {
            helperHeaderPreference.a(this.contact, this.BfU);
        }
        if (!eEv) {
            this.screen.bmi("contact_info_plugin_view");
            this.screen.bmi("contact_info_plugin_clear_data");
            this.screen.bmi("contact_info_plugin_uninstall");
            return;
        }
        this.screen.bmi("contact_info_plugin_install");
    }
}

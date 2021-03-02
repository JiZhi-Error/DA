package com.tencent.mm.plugin.qmessage.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.widget.Toast;
import com.facebook.appevents.codeless.internal.Constants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.model.bg;
import com.tencent.mm.platformtools.ac;
import com.tencent.mm.plugin.qmessage.a.b;
import com.tencent.mm.plugin.qmessage.a.d;
import com.tencent.mm.plugin.qmessage.a.g;
import com.tencent.mm.pluginsdk.ui.preference.NormalUserHeaderPreference;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import java.util.HashSet;
import java.util.Map;
import junit.framework.Assert;

public final class a implements i, com.tencent.mm.pluginsdk.b.a {
    private as contact;
    Context context;
    private ProgressDialog gtM;
    private f screen;

    public a(Context context2) {
        this.context = context2;
    }

    @Override // com.tencent.mm.pluginsdk.b.a
    public final boolean alD(String str) {
        return true;
    }

    @Override // com.tencent.mm.pluginsdk.b.a
    public final boolean a(f fVar, as asVar, boolean z, int i2) {
        boolean z2;
        boolean z3;
        boolean z4 = false;
        AppMethodBeat.i(27739);
        Assert.assertTrue(fVar != null);
        if (asVar != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        Assert.assertTrue(z2);
        Assert.assertTrue(as.bjo(asVar.field_username));
        bg.azz().a(140, this);
        this.contact = asVar;
        this.screen = fVar;
        fVar.addPreferencesFromResource(R.xml.a9);
        NormalUserHeaderPreference normalUserHeaderPreference = (NormalUserHeaderPreference) fVar.bmg("contact_info_header_normal");
        if (normalUserHeaderPreference != null) {
            normalUserHeaderPreference.Kqa = "ContactWidgetQContact";
            normalUserHeaderPreference.a(asVar, 0, null);
        }
        cCt();
        d aKB = g.eFZ().aKB(this.contact.field_username);
        if (aKB == null || Util.nullAsNil(aKB.getUsername()).length() <= 0) {
            Log.e("MicroMsg.ContactWidgetQContact", "getProfileOrNot: QContact is null, should not in this way");
            aKB = new d();
            aKB.username = this.contact.field_username;
            aKB.cSx = -1;
            g.eFZ().a(aKB);
        }
        if (aKB.Bqg == 1) {
            String str = this.contact.field_username;
            if (Util.nullAsNil(aKB.bjg()).length() <= 0) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (Util.nullAsNil(str).length() > 0) {
                z4 = true;
            }
            Assert.assertTrue(z4);
            HashSet hashSet = new HashSet();
            hashSet.add(str);
            final b bVar = new b(hashSet);
            new MMHandler().post(new Runnable() {
                /* class com.tencent.mm.plugin.qmessage.ui.a.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(27736);
                    bg.azz().a(bVar, 0);
                    AppMethodBeat.o(27736);
                }
            });
            if (z3) {
                Context context2 = this.context;
                this.context.getString(R.string.zb);
                this.gtM = h.a(context2, this.context.getString(R.string.wd), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
                    /* class com.tencent.mm.plugin.qmessage.ui.a.AnonymousClass2 */

                    public final void onCancel(DialogInterface dialogInterface) {
                        AppMethodBeat.i(27737);
                        bg.azz().a(bVar);
                        AppMethodBeat.o(27737);
                    }
                });
            }
        }
        AppMethodBeat.o(27739);
        return true;
    }

    private void cCt() {
        AppMethodBeat.i(27740);
        d aKB = g.eFZ().aKB(this.contact.field_username);
        if (aKB == null || Util.nullAsNil(aKB.getUsername()).length() <= 0) {
            Log.e("MicroMsg.ContactWidgetQContact", "updateProfile : Qcontact is null");
            AppMethodBeat.o(27740);
            return;
        }
        if (Util.nullAsNil(aKB.bjg()).length() <= 0) {
            Log.e("MicroMsg.ContactWidgetQContact", "updateProfile: QContact extInfo is null");
        }
        Preference bmg = this.screen.bmg("contact_info_qcontact_sex");
        Preference bmg2 = this.screen.bmg("contact_info_qcontact_age");
        Preference bmg3 = this.screen.bmg("contact_info_qcontact_birthday");
        Preference bmg4 = this.screen.bmg("contact_info_qcontact_address");
        C1609a aVar = new C1609a(this, (byte) 0);
        aVar.parse(aKB.bjg());
        if (bmg != null) {
            bmg.setSummary(aVar.eGc());
        }
        if (bmg2 != null) {
            bmg2.setSummary(aVar.eGd());
        }
        if (bmg3 != null) {
            bmg3.setSummary(aVar.eGf());
        }
        if (bmg4 != null) {
            bmg4.setSummary(aVar.eGe());
        }
        this.screen.notifyDataSetChanged();
        AppMethodBeat.o(27740);
    }

    @Override // com.tencent.mm.pluginsdk.b.a
    public final boolean cCs() {
        AppMethodBeat.i(27741);
        bg.azz().b(140, this);
        NormalUserHeaderPreference normalUserHeaderPreference = (NormalUserHeaderPreference) this.screen.bmg("contact_info_header_normal");
        if (normalUserHeaderPreference != null) {
            normalUserHeaderPreference.onDetach();
        }
        AppMethodBeat.o(27741);
        return true;
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.ak.i
    public final void onSceneEnd(int i2, int i3, String str, q qVar) {
        boolean z = true;
        AppMethodBeat.i(27742);
        if (qVar.getType() != 140) {
            AppMethodBeat.o(27742);
            return;
        }
        if (this.gtM != null) {
            this.gtM.dismiss();
            this.gtM = null;
            switch (i2) {
                case 1:
                    if (ac.jNP) {
                        Toast.makeText(this.context, this.context.getString(R.string.deo, 1, Integer.valueOf(i3)), 3000).show();
                        break;
                    }
                    z = false;
                    break;
                case 2:
                    if (ac.jNP) {
                        Toast.makeText(this.context, this.context.getString(R.string.dep, 2, Integer.valueOf(i3)), 3000).show();
                        break;
                    }
                    z = false;
                    break;
                default:
                    z = false;
                    break;
            }
            if (z) {
                AppMethodBeat.o(27742);
                return;
            }
        }
        if (i2 == 0 && i3 == 0) {
            d aKB = g.eFZ().aKB(this.contact.field_username);
            if (aKB == null || Util.nullAsNil(aKB.getUsername()).length() <= 0) {
                Log.e("MicroMsg.ContactWidgetQContact", "resetUpdateStatus: did not find this QContact, username = " + this.contact.field_username);
            } else {
                aKB.cSx = 8;
                aKB.Bqg = 0;
                if (!g.eFZ().a(this.contact.field_username, aKB)) {
                    Log.e("MicroMsg.ContactWidgetQContact", "resetUpdateStatus: update Qcontact failed, username = " + this.contact.field_username);
                }
            }
            cCt();
        }
        AppMethodBeat.o(27742);
    }

    /* renamed from: com.tencent.mm.plugin.qmessage.ui.a$a  reason: collision with other inner class name */
    public final class C1609a {
        private String Bqt;
        private String Bqu;
        private String Bqv;
        private String country;
        private String fuJ;
        private String fuK;
        private String iUO;

        /* synthetic */ C1609a(a aVar, byte b2) {
            this();
        }

        private C1609a() {
            this.Bqt = "";
            this.Bqu = "";
            this.iUO = "";
            this.Bqv = "";
            this.country = "";
            this.fuK = "";
            this.fuJ = "";
        }

        public final void parse(String str) {
            AppMethodBeat.i(27738);
            if (Util.nullAsNil(str).length() <= 0) {
                Log.e("MicroMsg.ContactWidgetQContact", "QExtInfoContent : parse xml, but xml is null");
                AppMethodBeat.o(27738);
                return;
            }
            Map<String, String> parseXml = XmlParser.parseXml(str, Constants.EXTINFO, null);
            if (parseXml != null) {
                this.Bqt = parseXml.get(".extinfo.sex");
                this.Bqu = parseXml.get(".extinfo.age");
                this.Bqv = parseXml.get(".extinfo.bd");
                this.country = parseXml.get(".extinfo.country");
                this.fuJ = parseXml.get(".extinfo.province");
                this.fuK = parseXml.get(".extinfo.city");
            }
            if (this.Bqt == null || !this.Bqt.equals("1")) {
                this.Bqt = a.this.context.getString(R.string.gxh);
            } else {
                this.Bqt = a.this.context.getString(R.string.gxi);
            }
            if (this.country != null) {
                this.iUO += this.country + " ";
            }
            if (this.fuJ != null) {
                this.iUO += this.fuJ + " ";
            }
            if (this.fuK != null) {
                this.iUO += this.fuK;
            }
            AppMethodBeat.o(27738);
        }

        public final String eGc() {
            return this.Bqt == null ? "" : this.Bqt;
        }

        public final String eGd() {
            return this.Bqu == null ? "" : this.Bqu;
        }

        public final String eGe() {
            return this.iUO == null ? "" : this.iUO;
        }

        public final String eGf() {
            return this.Bqv == null ? "" : this.Bqv;
        }
    }

    @Override // com.tencent.mm.pluginsdk.b.a
    public final void onActivityResult(int i2, int i3, Intent intent) {
    }
}

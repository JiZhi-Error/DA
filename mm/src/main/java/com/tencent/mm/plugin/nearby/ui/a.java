package com.tencent.mm.plugin.nearby.ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Message;
import android.view.View;
import android.widget.CheckBox;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bz;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.nearby.a.c;
import com.tencent.mm.pluginsdk.ui.preference.HelperHeaderPreference;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorageEx;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.base.q;
import com.tencent.mm.ui.s;
import com.tencent.mm.ui.widget.a.d;
import java.util.Timer;
import java.util.TimerTask;
import junit.framework.Assert;

public final class a implements i, com.tencent.mm.pluginsdk.b.a, MStorageEx.IOnStorageChange {
    private static boolean AzR = true;
    private c AzP;
    private CheckBox AzQ;
    private d AzS = null;
    private as contact;
    private Context context;
    private View jBV;
    private f screen;
    private q tipDialog;

    public a(Context context2) {
        AppMethodBeat.i(89816);
        this.context = context2;
        this.jBV = View.inflate(context2, R.layout.azk, null);
        this.AzQ = (CheckBox) this.jBV.findViewById(R.id.e_r);
        this.AzQ.setChecked(false);
        g.azz().a(148, this);
        AppMethodBeat.o(89816);
    }

    @Override // com.tencent.mm.pluginsdk.b.a
    public final boolean alD(String str) {
        AppMethodBeat.i(89817);
        Log.d("MicroMsg.ContactWidgetLBS", "handleEvent : key = ".concat(String.valueOf(str)));
        if (Util.nullAsNil(str).length() <= 0) {
            AppMethodBeat.o(89817);
            return false;
        } else if (str.equals("contact_info_lbs_go_lbs")) {
            Boolean bool = (Boolean) g.aAh().azQ().get(4103, (Object) null);
            if (bool == null || !bool.booleanValue()) {
                com.tencent.mm.br.c.V(this.context, "nearby", ".ui.NearbyFriendsIntroUI");
            } else {
                bz aWk = bz.aWk();
                if (aWk == null) {
                    com.tencent.mm.br.c.V(this.context, "nearby", ".ui.NearbyPersonalInfoUI");
                } else {
                    String nullAsNil = Util.nullAsNil(aWk.getProvince());
                    String nullAsNil2 = Util.nullAsNil(aWk.getCity());
                    int i2 = aWk.fuA;
                    if (nullAsNil.equals("") || nullAsNil2.equals("") || i2 == 0) {
                        com.tencent.mm.br.c.V(this.context, "nearby", ".ui.NearbyPersonalInfoUI");
                    } else {
                        Boolean bool2 = (Boolean) g.aAh().azQ().get(4104, (Object) null);
                        if (bool2 == null || !bool2.booleanValue()) {
                            com.tencent.mm.bp.a.ih(this.context);
                            ((Activity) this.context).finish();
                        } else if (this.AzS == null) {
                            this.AzS = h.a(this.context, this.context.getString(R.string.zb), this.jBV, new DialogInterface.OnClickListener() {
                                /* class com.tencent.mm.plugin.nearby.ui.a.AnonymousClass2 */

                                public final void onClick(DialogInterface dialogInterface, int i2) {
                                    AppMethodBeat.i(89811);
                                    g.aAh().azQ().set(4104, Boolean.valueOf(!a.this.AzQ.isChecked()));
                                    com.tencent.mm.bp.a.ih(a.this.context);
                                    ((Activity) a.this.context).finish();
                                    AppMethodBeat.o(89811);
                                }
                            }, new DialogInterface.OnClickListener() {
                                /* class com.tencent.mm.plugin.nearby.ui.a.AnonymousClass3 */

                                public final void onClick(DialogInterface dialogInterface, int i2) {
                                }
                            });
                        } else {
                            this.AzS.show();
                        }
                    }
                }
            }
            AppMethodBeat.o(89817);
            return true;
        } else if (str.equals("contact_info_lbs_install")) {
            C(this.context, true);
            AppMethodBeat.o(89817);
            return true;
        } else if (str.equals("contact_info_lbs_clear_info")) {
            h.a(this.context, (int) R.string.f_p, (int) R.string.f_o, new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.plugin.nearby.ui.a.AnonymousClass4 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(89813);
                    a.this.AzP = new c(2, 0.0f, 0.0f, 0, 0, "", "");
                    g.azz().a(a.this.AzP, 0);
                    a aVar = a.this;
                    Context context = a.this.context;
                    a.this.context.getString(R.string.zb);
                    aVar.tipDialog = h.a(context, a.this.context.getString(R.string.f_s), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
                        /* class com.tencent.mm.plugin.nearby.ui.a.AnonymousClass4.AnonymousClass1 */

                        public final void onCancel(DialogInterface dialogInterface) {
                            AppMethodBeat.i(89812);
                            g.azz().a(a.this.AzP);
                            AppMethodBeat.o(89812);
                        }
                    });
                    AppMethodBeat.o(89813);
                }
            }, new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.plugin.nearby.ui.a.AnonymousClass5 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                }
            });
            AppMethodBeat.o(89817);
            return true;
        } else if (str.equals("contact_info_lbs_uninstall")) {
            h.c(this.context, this.context.getString(R.string.gsw), "", this.context.getString(R.string.t2), this.context.getString(R.string.sz), new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.plugin.nearby.ui.a.AnonymousClass1 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(89810);
                    a.C(a.this.context, false);
                    AppMethodBeat.o(89810);
                }
            }, null);
            AppMethodBeat.o(89817);
            return true;
        } else {
            Log.e("MicroMsg.ContactWidgetLBS", "handleEvent : unExpected key = ".concat(String.valueOf(str)));
            AppMethodBeat.o(89817);
            return false;
        }
    }

    private static boolean isOpen() {
        AppMethodBeat.i(89818);
        if ((z.aUl() & 512) == 0) {
            AppMethodBeat.o(89818);
            return true;
        }
        AppMethodBeat.o(89818);
        return false;
    }

    @Override // com.tencent.mm.pluginsdk.b.a
    public final boolean a(f fVar, as asVar, boolean z, int i2) {
        boolean z2 = false;
        AppMethodBeat.i(89819);
        Assert.assertTrue(fVar != null);
        if (asVar != null) {
            z2 = true;
        }
        Assert.assertTrue(z2);
        Assert.assertTrue(ab.Jg(asVar.field_username));
        g.aAh().azQ().add(this);
        Log.v("MicroMsg.ContactWidgetLBS", "listener added");
        this.contact = asVar;
        this.screen = fVar;
        AzR = true;
        fVar.addPreferencesFromResource(R.xml.a2);
        cCt();
        AppMethodBeat.o(89819);
        return true;
    }

    private void cCt() {
        boolean z;
        boolean z2;
        boolean z3 = true;
        AppMethodBeat.i(89820);
        boolean isOpen = isOpen();
        HelperHeaderPreference helperHeaderPreference = (HelperHeaderPreference) this.screen.bmg("contact_info_header_helper");
        helperHeaderPreference.bk(this.contact.field_username, this.contact.arJ(), this.context.getString(R.string.bc0));
        helperHeaderPreference.updateStatus(isOpen ? 1 : 0);
        this.screen.m38do("contact_info_lbs_install", isOpen);
        f fVar = this.screen;
        if (!isOpen) {
            z = true;
        } else {
            z = false;
        }
        fVar.m38do("contact_info_lbs_go_lbs", z);
        f fVar2 = this.screen;
        if (!isOpen) {
            z2 = true;
        } else {
            z2 = false;
        }
        fVar2.m38do("contact_info_lbs_clear_info", z2);
        f fVar3 = this.screen;
        if (isOpen) {
            z3 = false;
        }
        fVar3.m38do("contact_info_lbs_uninstall", z3);
        AppMethodBeat.o(89820);
    }

    public static void C(Context context2, final boolean z) {
        AppMethodBeat.i(89821);
        String string = z ? context2.getString(R.string.gst) : context2.getString(R.string.gt0);
        AzR = z;
        context2.getString(R.string.zb);
        final q a2 = h.a(context2, string, true, (DialogInterface.OnCancelListener) null);
        final AnonymousClass6 r1 = new MMHandler() {
            /* class com.tencent.mm.plugin.nearby.ui.a.AnonymousClass6 */
            final /* synthetic */ s znB = null;

            @Override // com.tencent.mm.sdk.platformtools.MMHandler
            public final void handleMessage(Message message) {
                int i2;
                AppMethodBeat.i(89814);
                int aUl = z.aUl();
                if (z) {
                    i2 = aUl & -513;
                } else {
                    i2 = aUl | 512;
                }
                g.aAh().azQ().set(34, Integer.valueOf(i2));
                ((l) g.af(l.class)).aSM().d(new com.tencent.mm.ba.l("", "", "", "", "", "", "", "", i2, "", ""));
                if (!z) {
                    g.aAf().azk();
                    ((l) g.af(l.class)).eiv().byC();
                    g.azz().a(new c(2, 0.0f, 0.0f, 0, 0, "", ""), 0);
                }
                if (this.znB != null) {
                    this.znB.onNotifyChange(null, null);
                }
                AppMethodBeat.o(89814);
            }
        };
        new Timer().schedule(new TimerTask() {
            /* class com.tencent.mm.plugin.nearby.ui.a.AnonymousClass7 */

            public final void run() {
                AppMethodBeat.i(89815);
                if (a2 != null) {
                    a2.dismiss();
                    r1.sendEmptyMessage(0);
                }
                AppMethodBeat.o(89815);
            }
        }, 1500);
        AppMethodBeat.o(89821);
    }

    @Override // com.tencent.mm.pluginsdk.b.a
    public final boolean cCs() {
        AppMethodBeat.i(89822);
        g.aAh().azQ().remove(this);
        g.azz().b(148, this);
        com.tencent.mm.plugin.nearby.a.jRu.WZ();
        AppMethodBeat.o(89822);
        return true;
    }

    @Override // com.tencent.mm.sdk.storage.MStorageEx.IOnStorageChange
    public final void onNotifyChange(int i2, MStorageEx mStorageEx, Object obj) {
        AppMethodBeat.i(89823);
        int nullAsInt = Util.nullAsInt(obj, 0);
        Log.d("MicroMsg.ContactWidgetLBS", "onNotifyChange event:%d obj:%d stg:%s", Integer.valueOf(i2), Integer.valueOf(nullAsInt), mStorageEx);
        if (mStorageEx != g.aAh().azQ() || nullAsInt <= 0) {
            Log.e("MicroMsg.ContactWidgetLBS", "onNotifyChange error obj:%d stg:%s", Integer.valueOf(nullAsInt), mStorageEx);
            AppMethodBeat.o(89823);
        } else if (nullAsInt == 40 || nullAsInt == 34 || nullAsInt == 7) {
            cCt();
            AppMethodBeat.o(89823);
        } else {
            AppMethodBeat.o(89823);
        }
    }

    @Override // com.tencent.mm.pluginsdk.b.a
    public final void onActivityResult(int i2, int i3, Intent intent) {
    }

    @Override // com.tencent.mm.ak.i
    public final void onSceneEnd(int i2, int i3, String str, com.tencent.mm.ak.q qVar) {
        int i4;
        AppMethodBeat.i(89824);
        if (this.AzP == null && ((c) qVar).Vj() == 2) {
            AppMethodBeat.o(89824);
            return;
        }
        Log.i("MicroMsg.ContactWidgetLBS", "onSceneEnd: errType = " + i2 + " errCode = " + i3 + " errMsg = " + str);
        if (qVar.getType() != 148) {
            AppMethodBeat.o(89824);
            return;
        }
        if (this.tipDialog != null) {
            this.tipDialog.dismiss();
            this.tipDialog = null;
        }
        if (i2 == 0 && i3 == 0) {
            i4 = R.string.f_r;
        } else {
            i4 = R.string.f_q;
        }
        if (((c) qVar).Vj() == 2 && AzR) {
            h.a(this.context, i4, (int) R.string.zb, new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.plugin.nearby.ui.a.AnonymousClass8 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                }
            });
            this.AzP = null;
        }
        AppMethodBeat.o(89824);
    }
}

package com.tencent.mm.pluginsdk.ui.applet;

import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.g.a.mp;
import com.tencent.mm.kernel.g;
import com.tencent.mm.pluginsdk.model.p;
import com.tencent.mm.pluginsdk.ui.applet.aa;
import com.tencent.mm.protocal.protobuf.eqb;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.q;
import java.util.LinkedList;
import junit.framework.Assert;

public final class a implements i {
    private LinkedList<String> Byl;
    private LinkedList<Integer> Bym;
    private AbstractC2025a KdZ;
    public b Kea;
    private LinkedList<String> Keb;
    String Kec = "";
    public boolean Ked = true;
    public boolean Kee = true;
    boolean Kef = true;
    public boolean Keg = false;
    public String Keh = "";
    public eqb Kei;
    private String chatroomName = "";
    private Context context;
    private String hmm = "";
    public String khI = "";
    public int pHw = 0;
    private String sourceNickName;
    private String sourceUserName;
    private q tipDialog;
    public String wHV;
    public String wZz = "";

    /* renamed from: com.tencent.mm.pluginsdk.ui.applet.a$a  reason: collision with other inner class name */
    public interface AbstractC2025a {
        void a(boolean z, boolean z2, String str, String str2);
    }

    public interface b {
        boolean aE(String str, int i2);
    }

    static /* synthetic */ void a(a aVar, boolean z, String str, String str2) {
        AppMethodBeat.i(152163);
        aVar.c(false, z, str, str2);
        AppMethodBeat.o(152163);
    }

    public a(Context context2, AbstractC2025a aVar) {
        AppMethodBeat.i(152151);
        this.context = context2;
        this.KdZ = aVar;
        this.Byl = new LinkedList<>();
        this.Keb = new LinkedList<>();
        this.tipDialog = null;
        AppMethodBeat.o(152151);
    }

    public final void d(String str, String str2, LinkedList<Integer> linkedList) {
        AppMethodBeat.i(152152);
        this.chatroomName = str2;
        a(str, linkedList, false, "");
        AppMethodBeat.o(152152);
    }

    public final void h(String str, LinkedList<Integer> linkedList) {
        AppMethodBeat.i(152153);
        a(str, linkedList, false, "");
        AppMethodBeat.o(152153);
    }

    public final void a(String str, LinkedList<Integer> linkedList, String str2) {
        AppMethodBeat.i(152154);
        a(str, linkedList, false, str2);
        AppMethodBeat.o(152154);
    }

    public final void beC(String str) {
        AppMethodBeat.i(152155);
        if (!TextUtils.isEmpty(str)) {
            this.Keb.add(str);
        }
        AppMethodBeat.o(152155);
    }

    public final void b(String str, LinkedList<Integer> linkedList, boolean z) {
        AppMethodBeat.i(152156);
        a(str, linkedList, z, "");
        AppMethodBeat.o(152156);
    }

    private void a(String str, LinkedList<Integer> linkedList, boolean z, String str2) {
        boolean z2 = true;
        AppMethodBeat.i(152157);
        Assert.assertTrue(str != null && str.length() > 0);
        if (linkedList == null) {
            z2 = false;
        }
        Assert.assertTrue(z2);
        this.Ked = z;
        this.hmm = str2;
        this.Bym = linkedList;
        this.Byl.add(str);
        this.Kec = str;
        gpf();
        AppMethodBeat.o(152157);
    }

    /* access modifiers changed from: package-private */
    public final void gpf() {
        AppMethodBeat.i(152158);
        onStart();
        if (this.Kee) {
            Context context2 = this.context;
            this.context.getString(R.string.zb);
            this.tipDialog = h.a(context2, this.context.getString(R.string.b9q), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
                /* class com.tencent.mm.pluginsdk.ui.applet.a.AnonymousClass1 */

                public final void onCancel(DialogInterface dialogInterface) {
                    AppMethodBeat.i(152147);
                    a.a(a.this, false, a.this.Kec, a.this.khI);
                    AppMethodBeat.o(152147);
                }
            });
        }
        if (as.bjp(this.Byl.getFirst())) {
            g.aAg().hqi.a(new com.tencent.mm.openim.b.b(this.Byl.getFirst(), this.Keb.isEmpty() ? "" : this.Keb.getFirst()), 0);
            AppMethodBeat.o(152158);
            return;
        }
        p pVar = new p(1, this.Byl, this.Bym, this.Keb, "", this.wZz, null, this.chatroomName, this.hmm);
        if (!Util.isNullOrNil(this.sourceUserName)) {
            pVar.mw(this.sourceUserName, this.sourceNickName);
        }
        pVar.Pz(this.Keh);
        pVar.setSubScene(this.pHw);
        pVar.a(this.Kei);
        pVar.zJ(this.Kef);
        g.aAg().hqi.a(pVar, 0);
        AppMethodBeat.o(152158);
    }

    public final void mz(String str, String str2) {
        this.sourceUserName = str;
        this.sourceNickName = str2;
    }

    private void c(boolean z, boolean z2, String str, String str2) {
        AppMethodBeat.i(152159);
        if (this.KdZ != null) {
            this.KdZ.a(z, z2, str, str2);
        }
        if (z) {
            mp mpVar = new mp();
            mpVar.dSe.username = str;
            EventCenter.instance.publish(mpVar);
        }
        AppMethodBeat.o(152159);
    }

    private void onStart() {
        AppMethodBeat.i(152160);
        g.aAg().hqi.a(30, this);
        g.aAg().hqi.a(com.tencent.mm.plugin.appbrand.game.e.a.a.CTRL_INDEX, this);
        AppMethodBeat.o(152160);
    }

    @Override // com.tencent.mm.ak.i
    public final void onSceneEnd(int i2, int i3, String str, com.tencent.mm.ak.q qVar) {
        String first;
        int i4;
        AppMethodBeat.i(152161);
        Log.d("MicroMsg.AddContact", "onSceneEnd, errType = " + i2 + ", errCode = " + i3 + "," + str);
        if (qVar.getType() != 30 && qVar.getType() != 667) {
            Log.w("MicroMsg.AddContact", "not expected scene,  type = " + qVar.getType());
            AppMethodBeat.o(152161);
        } else if (!(qVar instanceof p) || ((p) qVar).dKy == 1) {
            if (this.tipDialog != null) {
                this.tipDialog.dismiss();
                this.tipDialog = null;
            }
            g.aAg().hqi.b(30, this);
            g.aAg().hqi.b(com.tencent.mm.plugin.appbrand.game.e.a.a.CTRL_INDEX, this);
            if (i2 == 0 && i3 == 0) {
                if (qVar.getType() == 30) {
                    this.Kec = ((p) qVar).gmD();
                } else if (qVar.getType() == 667) {
                    this.Kec = ((com.tencent.mm.openim.b.b) qVar).jGZ;
                }
                c(true, false, this.Kec, this.khI);
                com.tencent.mm.plugin.report.service.h hVar = com.tencent.mm.plugin.report.service.h.INSTANCE;
                Object[] objArr = new Object[7];
                objArr[0] = this.sourceUserName;
                objArr[1] = 1;
                objArr[2] = 0;
                objArr[3] = 0;
                if (this.Bym.size() > 0) {
                    i4 = this.Bym.getLast().intValue();
                } else {
                    i4 = 0;
                }
                objArr[4] = Integer.valueOf(i4);
                objArr[5] = 1;
                objArr[6] = 0;
                hVar.a(18713, objArr);
                AppMethodBeat.o(152161);
            } else if (i3 == -44) {
                String str2 = this.khI;
                if (this.Kea != null) {
                    b bVar = this.Kea;
                    if (this.Keb.isEmpty()) {
                        first = "";
                    } else {
                        first = this.Keb.getFirst();
                    }
                    bVar.aE(first, i3);
                    c(false, false, this.Kec, str2);
                    AppMethodBeat.o(152161);
                    return;
                }
                aa aaVar = new aa(this.context, new aa.a() {
                    /* class com.tencent.mm.pluginsdk.ui.applet.a.AnonymousClass4 */

                    @Override // com.tencent.mm.pluginsdk.ui.applet.aa.a
                    /* renamed from: do  reason: not valid java name */
                    public final void m35do(boolean z) {
                        AppMethodBeat.i(152150);
                        String str = a.this.khI;
                        a aVar = a.this;
                        a.a(aVar, z, aVar.Kec, str);
                        AppMethodBeat.o(152150);
                    }
                });
                if (this.wHV != null) {
                    aaVar.wHV = this.wHV;
                }
                if (this.Ked) {
                    aaVar.z(this.Byl, this.Bym);
                    AppMethodBeat.o(152161);
                    return;
                }
                aaVar.a(this.Byl, this.Bym, this.Keb);
                AppMethodBeat.o(152161);
            } else if (i3 == -87) {
                h.c(this.context, this.context.getString(R.string.b_d), "", true);
                AppMethodBeat.o(152161);
            } else if (i3 == -101 && !Util.isNullOrNil(str)) {
                Log.d("MicroMsg.AddContact", "jacks catch add Contact errCode: %d && errMsg: %s", Integer.valueOf(i3), str);
                h.a(this.context, str, "", false, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.pluginsdk.ui.applet.a.AnonymousClass2 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        AppMethodBeat.i(152148);
                        a.a(a.this, false, a.this.Kec, a.this.khI);
                        AppMethodBeat.o(152148);
                    }
                });
                AppMethodBeat.o(152161);
            } else if (i3 == -2) {
                if (!Util.isNullOrNil(str)) {
                    h.a(this.context, str, this.context.getString(R.string.zb), this.context.getString(R.string.x_), (DialogInterface.OnClickListener) null);
                    AppMethodBeat.o(152161);
                    return;
                }
                R(i2, i3, null);
                AppMethodBeat.o(152161);
            } else if (i3 != -160) {
                R(i2, i3, str);
                AppMethodBeat.o(152161);
            } else if (!Util.isNullOrNil(str)) {
                h.c(this.context, str, "", this.context.getResources().getString(R.string.t9), this.context.getResources().getString(R.string.sz), new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.pluginsdk.ui.applet.a.AnonymousClass3 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        AppMethodBeat.i(152149);
                        a.this.Kef = false;
                        a.this.gpf();
                        AppMethodBeat.o(152149);
                    }
                }, null);
                AppMethodBeat.o(152161);
            } else {
                R(i2, i3, str);
                AppMethodBeat.o(152161);
            }
        } else {
            Log.e("MicroMsg.AddContact", "not opcode addcontact!");
            AppMethodBeat.o(152161);
        }
    }

    private void R(int i2, int i3, String str) {
        AppMethodBeat.i(152162);
        if (this.Keg && !Util.isNullOrNil(str)) {
            h.c(this.context, str, "", true);
        } else if (i2 == 4 && i3 == -22) {
            Toast.makeText(this.context, this.context.getString(R.string.dv), 1).show();
        } else if (i2 == 4 && i3 == -24 && !Util.isNullOrNil(str)) {
            Toast.makeText(this.context, str, 1).show();
        } else {
            Toast.makeText(this.context, this.context.getString(R.string.du), 1).show();
        }
        c(false, false, this.Kec, this.khI);
        AppMethodBeat.o(152162);
    }
}

package com.tencent.mm.pluginsdk.ui.applet;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.aj.e;
import com.tencent.mm.aj.p;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.api.n;
import com.tencent.mm.contact.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.messenger.a.f;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.pluginsdk.ui.applet.a;
import com.tencent.mm.pluginsdk.ui.applet.y;
import com.tencent.mm.protocal.protobuf.drt;
import com.tencent.mm.protocal.protobuf.eqb;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.a.d;
import java.util.LinkedList;

public final class b implements e.a, a.AbstractC2025a, w {
    private boolean JSl;
    private int Kek;
    private v Kel;
    i Kem;
    private String hmm;
    ProgressDialog jZH;
    Context mContext;
    String mRa;
    private int mScene;
    private String nTU;
    d nUK;
    as rjX;

    public b(Context context, String str, int i2, v vVar, com.tencent.mm.pluginsdk.a aVar) {
        this(context, str, i2, vVar);
        AppMethodBeat.i(232190);
        if (aVar != null) {
            this.JSl = aVar.JSl;
            this.hmm = aVar.JSj;
            this.Kek = aVar.JSk;
            this.nTU = aVar.dCw;
        }
        AppMethodBeat.o(232190);
    }

    public b(Context context, String str, int i2, v vVar) {
        this.Kek = 0;
        this.Kem = null;
        this.JSl = true;
        this.mContext = context;
        this.mRa = str;
        this.mScene = i2;
        this.Kel = vVar;
    }

    @Override // com.tencent.mm.pluginsdk.ui.applet.w
    public final void show() {
        AppMethodBeat.i(31332);
        g.aAi();
        this.rjX = ((l) g.af(l.class)).aSN().Kn(this.mRa);
        if (this.rjX != null && ((int) this.rjX.gMZ) <= 0) {
            Log.i("MicroMsg.AddContactDialog", "dealAddContact get by username fail, try alias, %s", this.mRa);
            g.aAi();
            this.rjX = ((l) g.af(l.class)).aSN().bjH(this.mRa);
        }
        if (this.rjX != null && ((int) this.rjX.gMZ) > 0) {
            Log.i("MicroMsg.AddContactDialog", "The contact already exists, so go to dealAddContact.");
            if (this.rjX == null) {
                Log.e("MicroMsg.AddContactDialog", "dealAddContact fail, contact is null");
                rU(-1);
                AppMethodBeat.o(31332);
                return;
            }
            String str = this.rjX.field_username;
            if (!this.rjX.gBM()) {
                if (((n) g.af(n.class)).fD(str)) {
                    Context context = this.mContext;
                    this.mContext.getString(R.string.zb);
                    this.jZH = h.a(context, this.mContext.getString(R.string.j4n), true, (DialogInterface.OnCancelListener) null);
                    beD(str);
                    AppMethodBeat.o(31332);
                    return;
                }
                if ((this.mContext instanceof MMActivity) && h.a(this.mContext, this.mContext.getString(R.string.j4m), "", this.mContext.getString(R.string.w0), false, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.pluginsdk.ui.applet.b.AnonymousClass5 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        AppMethodBeat.i(232189);
                        Log.e("MicroMsg.AddContactDialog", "doAddContact fail, contact not biz");
                        b.this.rU(-1);
                        AppMethodBeat.o(232189);
                    }
                }) == null) {
                    Log.e("MicroMsg.AddContactDialog", "dealAddContact fail, connot show dialog");
                    rU(-1);
                }
                AppMethodBeat.o(31332);
            } else if (c.oR(this.rjX.field_type)) {
                h.cD(this.mContext, this.mContext.getResources().getString(R.string.j4q));
                rU(-2);
                AppMethodBeat.o(31332);
            } else {
                ak(this.rjX);
                AppMethodBeat.o(31332);
            }
        } else if (this.mContext == null) {
            AppMethodBeat.o(31332);
        } else {
            Context context2 = this.mContext;
            this.mContext.getString(R.string.zb);
            this.jZH = h.a(context2, this.mContext.getString(R.string.j4n), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
                /* class com.tencent.mm.pluginsdk.ui.applet.b.AnonymousClass1 */

                public final void onCancel(DialogInterface dialogInterface) {
                    AppMethodBeat.i(31327);
                    if (b.this.jZH != null) {
                        b.this.jZH.dismiss();
                        b.this.jZH = null;
                    }
                    AppMethodBeat.o(31327);
                }
            });
            beD(this.mRa);
            AppMethodBeat.o(31332);
        }
    }

    /* access modifiers changed from: package-private */
    public final void ak(final as asVar) {
        String str = null;
        AppMethodBeat.i(31333);
        if (asVar == null) {
            Log.e("MicroMsg.AddContactDialog", "showContact fail, contact is null");
            rU(-1);
            AppMethodBeat.o(31333);
            return;
        }
        String string = this.mContext.getString(R.string.j4l);
        Bitmap a2 = com.tencent.mm.aj.c.a(asVar.field_username, false, -1, null);
        if (a2 == null) {
            p.aYn().a(this);
        }
        if (a2 != null && asVar.gBM()) {
            a2 = BitmapUtil.getRoundedCornerBitmap(a2, false, (float) (a2.getWidth() / 2));
        }
        String str2 = asVar.field_nickname;
        this.nUK = null;
        if (this.mContext instanceof MMActivity) {
            if (!this.JSl) {
                al(asVar);
                AppMethodBeat.o(31333);
                return;
            }
            com.tencent.mm.aj.i Mx = p.aYB().Mx(asVar.field_username);
            if (Mx != null && !Util.isNullOrNil(Mx.aYu())) {
                str = Mx.aYu();
            }
            this.nUK = o.a(((MMActivity) this.mContext).getController(), string, a2, str2, str, new y.a() {
                /* class com.tencent.mm.pluginsdk.ui.applet.b.AnonymousClass2 */

                @Override // com.tencent.mm.pluginsdk.ui.applet.y.a
                public final void a(boolean z, String str, int i2) {
                    AppMethodBeat.i(31328);
                    if (z) {
                        b.this.al(asVar);
                    } else {
                        b.this.rU(0);
                    }
                    b.this.nUK.dismiss();
                    AppMethodBeat.o(31328);
                }
            });
        }
        if (this.nUK == null) {
            Log.e("MicroMsg.AddContactDialog", "showContact fail, cannot show dialog");
            rU(-1);
        }
        AppMethodBeat.o(31333);
    }

    /* access modifiers changed from: package-private */
    public final void al(as asVar) {
        AppMethodBeat.i(31334);
        if (this.jZH != null) {
            this.jZH.dismiss();
        }
        Context context = this.mContext;
        this.mContext.getString(R.string.zb);
        this.jZH = h.a(context, this.mContext.getString(R.string.j4n), true, (DialogInterface.OnCancelListener) null);
        a aVar = new a(this.mContext, this);
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(Integer.valueOf(this.mScene));
        eqb eqb = new eqb();
        eqb.Lru = this.nTU;
        aVar.Kei = eqb;
        aVar.a(asVar.field_username, linkedList, this.hmm);
        AppMethodBeat.o(31334);
    }

    @Override // com.tencent.mm.aj.e.a
    public final void Mr(String str) {
        boolean z = true;
        AppMethodBeat.i(31335);
        if (this.rjX != null) {
            boolean z2 = this.rjX.field_username != null && this.rjX.field_username.equals(str);
            if (this.rjX.ajx() == null || !this.rjX.ajx().equals(str)) {
                z = false;
            }
            if (!z2 && !z) {
                AppMethodBeat.o(31335);
                return;
            }
        } else if (this.mRa == null || !this.mRa.equals(str)) {
            AppMethodBeat.o(31335);
            return;
        }
        if (this.nUK == null || !this.nUK.isShowing()) {
            AppMethodBeat.o(31335);
            return;
        }
        MMHandlerThread.postToMainThread(new Runnable() {
            /* class com.tencent.mm.pluginsdk.ui.applet.b.AnonymousClass3 */

            public final void run() {
                AppMethodBeat.i(31329);
                ImageView imageView = (ImageView) b.this.nUK.getContentView().findViewById(R.id.b_i);
                if (imageView != null) {
                    Bitmap a2 = com.tencent.mm.aj.c.a(b.this.rjX.field_username, false, -1, null);
                    if (a2 != null && b.this.rjX.gBM()) {
                        a2 = BitmapUtil.getRoundedCornerBitmap(a2, false, (float) (a2.getWidth() / 2));
                    }
                    if (a2 != null && !a2.isRecycled()) {
                        imageView.setImageBitmap(a2);
                        imageView.setVisibility(0);
                    }
                }
                AppMethodBeat.o(31329);
            }
        });
        AppMethodBeat.o(31335);
    }

    private void beD(String str) {
        AppMethodBeat.i(31336);
        Log.i("MicroMsg.AddContactDialog", "searchContact %s", str);
        if (this.Kem == null) {
            this.Kem = new i() {
                /* class com.tencent.mm.pluginsdk.ui.applet.b.AnonymousClass4 */

                @Override // com.tencent.mm.ak.i
                public final void onSceneEnd(int i2, int i3, String str, q qVar) {
                    AppMethodBeat.i(31330);
                    if (b.this.jZH != null) {
                        b.this.jZH.dismiss();
                    }
                    if (b.this.Kem != null) {
                        g.aAi();
                        g.aAg().hqi.b(106, b.this.Kem);
                    }
                    if (b.this.jZH == null) {
                        Log.e("MicroMsg.AddContactDialog", "has cancel the loading dialog");
                        b.this.rU(0);
                        AppMethodBeat.o(31330);
                    } else if (i2 != 0 || i3 != 0) {
                        Log.e("MicroMsg.AddContactDialog", "searchContact onSceneEnd, errType = %d, errCode = %d", Integer.valueOf(i2), Integer.valueOf(i3));
                        b.this.rU(-1);
                        AppMethodBeat.o(31330);
                    } else if (b.this.mContext == null) {
                        Log.e("MicroMsg.AddContactDialog", "searchContact, context is null, msghandler has already been detached!");
                        b.this.rU(-1);
                        AppMethodBeat.o(31330);
                    } else if (!(b.this.mContext instanceof Activity) || !((Activity) b.this.mContext).isFinishing()) {
                        drt eiq = ((f) qVar).eiq();
                        String a2 = z.a(eiq.Lqk);
                        if (Util.isNullOrNil(a2)) {
                            Log.e("MicroMsg.AddContactDialog", "searchContact, user is null");
                            h.cD(b.this.mContext, b.this.mContext.getResources().getString(R.string.j4m));
                            b.this.rU(-1);
                            AppMethodBeat.o(31330);
                            return;
                        }
                        if (b.this.mRa == null || !b.this.mRa.equals(a2)) {
                            Log.w("MicroMsg.AddContactDialog", "user not the same, %s, %s", b.this.mRa, a2);
                        }
                        b bVar = b.this;
                        g.aAi();
                        bVar.rjX = ((l) g.af(l.class)).aSN().Kn(a2);
                        if (b.this.rjX == null || ((int) b.this.rjX.gMZ) == 0) {
                            Log.i("MicroMsg.AddContactDialog", "searchContact, no contact with username = " + a2 + ", try get by alias");
                            b bVar2 = b.this;
                            g.aAi();
                            bVar2.rjX = ((l) g.af(l.class)).aSN().bjH(a2);
                            if (b.this.rjX == null || ((int) b.this.rjX.gMZ) == 0) {
                                Log.i("MicroMsg.AddContactDialog", "searchContact, no contact with alias, new Contact");
                                b.this.rjX = new as(a2);
                                b.this.rjX.BC(eiq.ked);
                                b.this.rjX.setNickname(z.a(eiq.Mjj));
                                b.this.rjX.BF(z.a(eiq.LpA));
                                b.this.rjX.BG(z.a(eiq.LpB));
                                b.this.rjX.nj(eiq.kdY);
                                b.this.rjX.Cb(RegionCodeDecoder.bq(eiq.keh, eiq.kdZ, eiq.kea));
                                b.this.rjX.BV(eiq.keb);
                                b.this.rjX.nf(eiq.MmK);
                                b.this.rjX.Ca(eiq.MmL);
                                b.this.rjX.ne(eiq.MmO);
                                b.this.rjX.BH(eiq.MmN);
                                b.this.rjX.BZ(eiq.MmM);
                            }
                        } else {
                            Log.i("MicroMsg.AddContactDialog", "searchContact, contact in db, %s", a2);
                        }
                        b.this.ak(b.this.rjX);
                        AppMethodBeat.o(31330);
                    } else {
                        Log.e("MicroMsg.AddContactDialog", "searchContact, context isFinishing");
                        b.this.rU(-1);
                        AppMethodBeat.o(31330);
                    }
                }
            };
        }
        g.aAi();
        g.aAg().hqi.a(106, this.Kem);
        f fVar = new f(str, this.Kek);
        g.aAi();
        g.aAg().hqi.a(fVar, 0);
        AppMethodBeat.o(31336);
    }

    @Override // com.tencent.mm.pluginsdk.ui.applet.a.AbstractC2025a
    public final void a(boolean z, boolean z2, String str, String str2) {
        AppMethodBeat.i(31337);
        if (this.jZH != null) {
            this.jZH.dismiss();
        }
        if (z) {
            this.rjX.aqQ();
            g.aAi();
            ((l) g.af(l.class)).aSN().c(this.rjX.field_username, this.rjX);
            h.cD(this.mContext, this.mContext.getResources().getString(R.string.j4q));
            rU(1);
            AppMethodBeat.o(31337);
            return;
        }
        rU(-1);
        AppMethodBeat.o(31337);
    }

    /* access modifiers changed from: package-private */
    public final void rU(int i2) {
        AppMethodBeat.i(31338);
        if (this.Kel != null) {
            this.Kel.wK(i2);
        }
        AppMethodBeat.o(31338);
    }
}

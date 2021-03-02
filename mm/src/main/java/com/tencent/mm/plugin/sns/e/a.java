package com.tencent.mm.plugin.sns.e;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.text.TextUtils;
import android.widget.Toast;
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.model.ab;
import com.tencent.mm.openim.b.b;
import com.tencent.mm.plugin.sns.a.c;
import com.tencent.mm.plugin.sns.data.d;
import com.tencent.mm.plugin.sns.data.k;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy;
import com.tencent.mm.plugin.sns.storage.ADXml;
import com.tencent.mm.plugin.sns.ui.av;
import com.tencent.mm.plugin.sns.ui.view.HalfScreenAddBrandView;
import com.tencent.mm.pluginsdk.model.p;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.base.q;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.sqlitelint.behaviour.persistence.IssueStorage;
import org.json.JSONObject;

public final class a {
    public av.a DCV;
    public ADXml.AdCardActionBtnInfo DCW;
    public d DCX;
    public boolean DCY;
    public int DxM;
    public String adExtInfo;
    public String dRS;
    public bv iFD;
    public Context mContext;
    private e nVN;
    public as rjX;
    public q tipDialog;
    public String uxInfo;

    public final void eZo() {
        AppMethodBeat.i(202565);
        this.nVN = new e(this.mContext, true, 0);
        HalfScreenAddBrandView halfScreenAddBrandView = new HalfScreenAddBrandView(this.mContext);
        d dVar = this.DCX;
        int i2 = this.DxM;
        halfScreenAddBrandView.DCX = dVar;
        halfScreenAddBrandView.DxM = i2;
        halfScreenAddBrandView.EcO = this;
        halfScreenAddBrandView.Fdv.setText(halfScreenAddBrandView.DCX.brandName);
        halfScreenAddBrandView.Fdw.setText(halfScreenAddBrandView.DCX.brandDesc);
        String str = halfScreenAddBrandView.DCX.brandHead;
        if (!TextUtils.equals((String) halfScreenAddBrandView.Fdu.getTag(R.id.hwe), str)) {
            halfScreenAddBrandView.Fdu.setImageDrawable(null);
            c.k(str, halfScreenAddBrandView.Fdu);
        }
        if (this.DxM == 182 && this.DCY) {
            halfScreenAddBrandView.Fdz.setText(halfScreenAddBrandView.DCX.btnTitleAfterAddBrand);
        }
        this.nVN.V(halfScreenAddBrandView, true);
        this.nVN.Dm(true);
        this.nVN.dGm();
        AppMethodBeat.o(202565);
    }

    /* renamed from: com.tencent.mm.plugin.sns.e.a$a  reason: collision with other inner class name */
    public class C1713a implements i {
        Context context;
        int source;
        q tipDialog;

        public /* synthetic */ C1713a(a aVar, Context context2, int i2, q qVar, byte b2) {
            this(context2, i2, qVar);
        }

        private C1713a(Context context2, int i2, q qVar) {
            this.context = context2;
            this.source = i2;
            this.tipDialog = qVar;
        }

        @Override // com.tencent.mm.ak.i
        public final void onSceneEnd(final int i2, final int i3, final String str, final com.tencent.mm.ak.q qVar) {
            AppMethodBeat.i(202564);
            if ((qVar instanceof b) || (qVar instanceof p)) {
                if (qVar.getType() != 30 && qVar.getType() != 667) {
                    Log.w("HalfScreenAddBrandController", "not expected scene,  type = " + qVar.getType());
                    AppMethodBeat.o(202564);
                    return;
                } else if (!(qVar instanceof p) || ((p) qVar).dKy == 1) {
                    com.tencent.mm.plugin.sns.model.b.e(this);
                    Log.i("HalfScreenAddBrandController", "catch add Contact errCode: %d && errMsg: %s", Integer.valueOf(i3), str);
                    MMHandlerThread.postToMainThread(new Runnable() {
                        /* class com.tencent.mm.plugin.sns.e.a.C1713a.AnonymousClass1 */

                        public final void run() {
                            AppMethodBeat.i(202563);
                            if (C1713a.this.tipDialog != null) {
                                C1713a.this.tipDialog.dismiss();
                                C1713a.this.tipDialog = null;
                            }
                            String str = "";
                            if (i2 == 0 && i3 == 0) {
                                if (qVar.getType() == 30) {
                                    str = ((p) qVar).gmD();
                                } else if (qVar.getType() == 667) {
                                    str = ((b) qVar).jGZ;
                                }
                            }
                            a.a(a.this, C1713a.this.context, i2, i3, str, C1713a.this.source, str);
                            AppMethodBeat.o(202563);
                        }
                    });
                } else {
                    Log.e("HalfScreenAddBrandController", "not opcode addcontact!");
                    AppMethodBeat.o(202564);
                    return;
                }
            }
            AppMethodBeat.o(202564);
        }
    }

    public final void D(boolean z, String str) {
        AppMethodBeat.i(202566);
        if (this.mContext == null) {
            Log.i("HalfScreenAddBrandController", "context is null");
            AppMethodBeat.o(202566);
        } else if (!z || Util.isNullOrNil(str)) {
            Toast.makeText(this.mContext, this.mContext.getString(R.string.du), 1).show();
            AppMethodBeat.o(202566);
        } else {
            Intent intent = new Intent();
            intent.putExtra("Chat_User", str);
            intent.putExtra("key_has_add_contact", true);
            intent.putExtra("finish_direct", true);
            intent.setClassName(this.mContext, "com.tencent.mm.ui.chatting.ChattingUI");
            Context context = this.mContext;
            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
            com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/plugin/sns/controller/HalfScreenAddBrandController", "dealRet", "(ZLjava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            context.startActivity((Intent) bl.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/plugin/sns/controller/HalfScreenAddBrandController", "dealRet", "(ZLjava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            AppMethodBeat.o(202566);
        }
    }

    public final void eZp() {
        AppMethodBeat.i(202567);
        if (this.nVN != null && this.nVN.isShowing()) {
            this.nVN.bMo();
        }
        AppMethodBeat.o(202567);
    }

    private void is(int i2, int i3) {
        int i4;
        AppMethodBeat.i(202568);
        if (i2 == 0) {
            i4 = 1;
        } else if (i2 == 182) {
            i4 = 3;
        } else {
            i4 = 2;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("enterType", i4);
            jSONObject2.put("result", i3);
            jSONObject.put(IssueStorage.COLUMN_EXT_INFO, jSONObject2);
            jSONObject.put("uxinfo", this.uxInfo);
            jSONObject.put("snsid", this.dRS);
            jSONObject.put("scene", 0);
            jSONObject.put("adExtInfo", this.adExtInfo);
            String jSONObject3 = jSONObject.toString();
            k.jY("timeline_ad_half_screen_quickly_add_brand_result", jSONObject3);
            Log.i("HalfScreenAddBrandController", "addBrandReport timeline_ad_half_screen_quickly_add_brand_result, content=".concat(String.valueOf(jSONObject3)));
            AppMethodBeat.o(202568);
        } catch (Exception e2) {
            Log.e("HalfScreenAddBrandController", "addBrandReport exp:" + e2.toString());
            AppMethodBeat.o(202568);
        }
    }

    static /* synthetic */ void a(a aVar, Context context, int i2, int i3, String str, int i4, String str2) {
        AppMethodBeat.i(202569);
        if (i2 == 0 && i3 == 0 && !Util.isNullOrNil(str2)) {
            if (i4 == 182) {
                aVar.D(true, str2);
            } else if (!(aVar.DCV == null || aVar.DCW == null)) {
                aVar.DCV.a(aVar.DCW);
            }
            if (MMApplicationContext.isMainProcess()) {
                Log.i("HalfScreenAddBrandController", "updateContact, main, respUsername = ".concat(String.valueOf(str2)));
                if (!(aVar.rjX == null || aVar.iFD == null)) {
                    aVar.rjX.aqQ();
                    aVar.rjX.setUsername(str2);
                    h.RTc.aX(new Runnable() {
                        /* class com.tencent.mm.plugin.sns.e.a.AnonymousClass2 */

                        public final void run() {
                            AppMethodBeat.i(202562);
                            try {
                                if (((int) a.this.rjX.gMZ) == 0) {
                                    a.this.iFD.aq(a.this.rjX);
                                }
                                if (((int) a.this.rjX.gMZ) <= 0) {
                                    Log.e("HalfScreenAddBrandController", "addContact : insert contact failed");
                                    AppMethodBeat.o(202562);
                                    return;
                                }
                                ab.B(a.this.rjX);
                                AppMethodBeat.o(202562);
                            } catch (Throwable th) {
                                Log.e("HalfScreenAddBrandController", th.toString());
                                AppMethodBeat.o(202562);
                            }
                        }
                    });
                }
            } else if (MMApplicationContext.isToolsProcess()) {
                AdLandingPagesProxy.getInstance().updateContact(str2);
                Log.i("HalfScreenAddBrandController", "updateContact, tools, respUsername = ".concat(String.valueOf(str2)));
            } else {
                Log.e("HalfScreenAddBrandController", "updateContact, process err");
            }
            aVar.is(i4, 1);
            AppMethodBeat.o(202569);
            return;
        }
        if (i3 != -44) {
            if (i3 == -87) {
                com.tencent.mm.ui.base.h.c(context, context.getString(R.string.b_d), "", true);
                aVar.is(i4, 2);
                AppMethodBeat.o(202569);
                return;
            } else if (i3 != -101 && i3 == -2) {
                if (!Util.isNullOrNil(str)) {
                    com.tencent.mm.ui.base.h.a(context, str, context.getString(R.string.zb), context.getString(R.string.x_), (DialogInterface.OnClickListener) null);
                } else {
                    aVar.D(false, str2);
                }
                aVar.is(i4, 2);
                AppMethodBeat.o(202569);
                return;
            }
        }
        aVar.D(false, str2);
        aVar.is(i4, 2);
        AppMethodBeat.o(202569);
    }
}

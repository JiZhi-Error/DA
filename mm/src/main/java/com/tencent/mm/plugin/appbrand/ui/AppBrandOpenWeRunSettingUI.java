package com.tencent.mm.plugin.appbrand.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.al.ag;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.ay;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.sport.a.c;
import com.tencent.mm.pluginsdk.model.p;
import com.tencent.mm.pluginsdk.ui.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.q;
import com.tencent.mm.ui.tools.u;
import java.util.LinkedList;

public class AppBrandOpenWeRunSettingUI extends MMActivity implements i {
    private as contact = null;
    private TextView gCd;
    private ImageView gyr;
    private TextView kcZ;
    private TextView nUp;
    q nUq;
    private TextView titleTv;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    static /* synthetic */ void a(AppBrandOpenWeRunSettingUI appBrandOpenWeRunSettingUI) {
        AppMethodBeat.i(48672);
        appBrandOpenWeRunSettingUI.updateStatus();
        AppMethodBeat.o(48672);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(48669);
        super.onCreate(bundle);
        setMMTitle(getString(R.string.o6));
        this.gyr = (ImageView) findViewById(R.id.g4k);
        this.kcZ = (TextView) findViewById(R.id.g4l);
        this.gCd = (TextView) findViewById(R.id.g4n);
        this.titleTv = (TextView) findViewById(R.id.g4p);
        this.nUp = (TextView) findViewById(R.id.g4m);
        this.nUp.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.appbrand.ui.AppBrandOpenWeRunSettingUI.AnonymousClass1 */

            public final void onClick(View view) {
                AppMethodBeat.i(48665);
                b bVar = new b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/appbrand/ui/AppBrandOpenWeRunSettingUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                c.pl(13);
                AppBrandOpenWeRunSettingUI appBrandOpenWeRunSettingUI = AppBrandOpenWeRunSettingUI.this;
                appBrandOpenWeRunSettingUI.getString(R.string.zb);
                appBrandOpenWeRunSettingUI.nUq = h.a((Context) appBrandOpenWeRunSettingUI, appBrandOpenWeRunSettingUI.getString(R.string.gst), true, (DialogInterface.OnCancelListener) null);
                appBrandOpenWeRunSettingUI.nUq.show();
                g.aAg().hqi.a(30, appBrandOpenWeRunSettingUI);
                LinkedList linkedList = new LinkedList();
                linkedList.add("gh_43f2581f6fd6");
                LinkedList linkedList2 = new LinkedList();
                linkedList2.add(1);
                g.aAg().hqi.a(new p(linkedList, linkedList2, "", ""), 0);
                a.a(this, "com/tencent/mm/plugin/appbrand/ui/AppBrandOpenWeRunSettingUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(48665);
            }
        });
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.appbrand.ui.AppBrandOpenWeRunSettingUI.AnonymousClass2 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(48666);
                AppBrandOpenWeRunSettingUI.this.finish();
                AppMethodBeat.o(48666);
                return true;
            }
        });
        String nullAsNil = Util.nullAsNil(getIntent().getStringExtra("OpenWeRunSettingName"));
        this.contact = ((l) g.af(l.class)).aSN().Kn("gh_43f2581f6fd6");
        if (this.contact == null || ((int) this.contact.gMZ) == 0) {
            getString(R.string.zb);
            this.nUq = h.a((Context) this, getString(R.string.a06), true, (DialogInterface.OnCancelListener) null);
            this.nUq.show();
            ay.a.iDq.a("gh_43f2581f6fd6", "", new ay.b.a() {
                /* class com.tencent.mm.plugin.appbrand.ui.AppBrandOpenWeRunSettingUI.AnonymousClass3 */

                @Override // com.tencent.mm.model.ay.b.a
                public final void p(String str, boolean z) {
                    AppMethodBeat.i(48667);
                    Log.i("MicroMsg.AppBrandOpenWeRunSettingUI", "getContactCallBack, suc = %b,user %s", Boolean.valueOf(z), str);
                    AppBrandOpenWeRunSettingUI.this.contact = ((l) g.af(l.class)).aSN().Kn("gh_43f2581f6fd6");
                    AppBrandOpenWeRunSettingUI.a(AppBrandOpenWeRunSettingUI.this);
                    AppBrandOpenWeRunSettingUI.this.nUq.dismiss();
                    AppMethodBeat.o(48667);
                }
            });
        }
        this.titleTv.setText(getString(R.string.o8, new Object[]{nullAsNil}));
        updateStatus();
        AppMethodBeat.o(48669);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.ef;
    }

    private void updateStatus() {
        AppMethodBeat.i(48670);
        a.b.c(this.gyr, this.contact.field_username);
        this.kcZ.setText(this.contact.arJ());
        if (com.tencent.mm.contact.c.oR(this.contact.field_type)) {
            this.gCd.setTextColor(u.kF(getContext()));
            this.gCd.setText(R.string.gsr);
            this.gCd.setCompoundDrawablesWithIntrinsicBounds(R.drawable.bo8, 0, 0, 0);
            this.nUp.setText(R.string.gsr);
            this.nUp.setClickable(false);
            AppMethodBeat.o(48670);
            return;
        }
        this.gCd.setTextColor(u.kG(getContext()));
        this.gCd.setText(R.string.gsy);
        this.gCd.setCompoundDrawablesWithIntrinsicBounds(R.drawable.bo7, 0, 0, 0);
        this.nUp.setText(R.string.gsq);
        this.nUp.setClickable(true);
        AppMethodBeat.o(48670);
    }

    @Override // com.tencent.mm.ak.i
    public void onSceneEnd(int i2, int i3, String str, com.tencent.mm.ak.q qVar) {
        com.tencent.mm.api.c cVar;
        AppMethodBeat.i(48671);
        if (qVar instanceof p) {
            g.aAg().hqi.b(30, this);
            if (i2 == 0 && i3 == 0) {
                String gmD = ((p) qVar).gmD();
                Log.i("MicroMsg.AppBrandOpenWeRunSettingUI", "bind fitness contact %s success", gmD);
                this.contact = ((l) g.af(l.class)).aSN().Kn("gh_43f2581f6fd6");
                as asVar = this.contact;
                if (asVar == null || Util.isNullOrNil(gmD)) {
                    Log.e("MicroMsg.AppBrandOpenWeRunSettingUI", "respUsername == " + gmD + ", contact = " + asVar);
                } else {
                    if (ab.IR(asVar.field_username)) {
                        String nullAsNil = Util.nullAsNil(asVar.field_username);
                        com.tencent.mm.api.c fJ = com.tencent.mm.al.g.fJ(nullAsNil);
                        if (fJ != null) {
                            fJ.field_username = gmD;
                        }
                        ag.bah().delete(nullAsNil);
                        asVar.BK(nullAsNil);
                        cVar = fJ;
                    } else {
                        cVar = null;
                    }
                    asVar.setUsername(gmD);
                    if (((int) asVar.gMZ) == 0) {
                        ((l) g.af(l.class)).aSN().aq(asVar);
                    }
                    if (((int) asVar.gMZ) <= 0) {
                        Log.e("MicroMsg.AppBrandOpenWeRunSettingUI", "addContact : insert contact failed");
                    } else {
                        ab.B(asVar);
                        as Kn = ((l) g.af(l.class)).aSN().Kn(asVar.field_username);
                        if (cVar != null) {
                            ag.bah().g(cVar);
                        } else {
                            com.tencent.mm.api.c fJ2 = com.tencent.mm.al.g.fJ(Kn.field_username);
                            if (fJ2 == null || fJ2.Uz()) {
                                Log.d("MicroMsg.AppBrandOpenWeRunSettingUI", "shouldUpdate");
                                ay.a.iDq.aL(Kn.field_username, "");
                                com.tencent.mm.aj.c.Mf(Kn.field_username);
                            } else if (Kn.gBQ()) {
                                Log.d("MicroMsg.AppBrandOpenWeRunSettingUI", "update contact, last check time=%d", Integer.valueOf(Kn.fuP));
                                ay.a.iDq.aL(Kn.field_username, "");
                                com.tencent.mm.aj.c.Mf(Kn.field_username);
                            }
                        }
                    }
                }
                ag.bah().h(ag.bah().MT(this.contact.field_username));
                g.aAh().azQ().set(327825, Boolean.TRUE);
                setResult(-1);
                MMHandlerThread.postToMainThreadDelayed(new Runnable() {
                    /* class com.tencent.mm.plugin.appbrand.ui.AppBrandOpenWeRunSettingUI.AnonymousClass4 */

                    public final void run() {
                        AppMethodBeat.i(48668);
                        AppBrandOpenWeRunSettingUI.this.finish();
                        AppMethodBeat.o(48668);
                    }
                }, 1500);
            } else {
                Log.e("MicroMsg.AppBrandOpenWeRunSettingUI", "errType %d | errCode %d | errMsg %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
                if (i2 == 4 && i3 == -24 && !Util.isNullOrNil(str)) {
                    Toast.makeText(MMApplicationContext.getContext(), str, 1).show();
                }
                setResult(1);
            }
            if (this.nUq != null) {
                this.nUq.dismiss();
            }
            updateStatus();
        }
        AppMethodBeat.o(48671);
    }
}

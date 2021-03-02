package com.tencent.mm.plugin.account.bind.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.aj.e;
import com.tencent.mm.ak.i;
import com.tencent.mm.b.p;
import com.tencent.mm.g.a.am;
import com.tencent.mm.g.a.yo;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.account.friend.a.ar;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.q;
import com.tencent.mm.ui.widget.a.d;

public class StartUnbindQQ extends MMWizardActivity implements i {
    private String kaJ = null;
    private d kdA;
    private View kdz;
    private q tipDialog;

    @Override // com.tencent.mm.ui.MMWizardActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // com.tencent.mm.ui.MMWizardActivity, android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(110190);
        super.onCreate(bundle);
        g.azz().a(253, this);
        this.kaJ = getIntent().getStringExtra("notice");
        AppMethodBeat.o(110190);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(110191);
        g.azz().b(253, this);
        super.onDestroy();
        AppMethodBeat.o(110191);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        AppMethodBeat.i(110192);
        super.onResume();
        initView();
        AppMethodBeat.o(110192);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.byr;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(110193);
        setMMTitle(R.string.hrz);
        this.kdz = findViewById(R.id.hm4);
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.account.bind.ui.StartUnbindQQ.AnonymousClass1 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(110186);
                StartUnbindQQ.this.finish();
                AppMethodBeat.o(110186);
                return true;
            }
        });
        this.kdz.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.account.bind.ui.StartUnbindQQ.AnonymousClass2 */

            public final void onClick(View view) {
                AppMethodBeat.i(110188);
                b bVar = new b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/account/bind/ui/StartUnbindQQ$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (StartUnbindQQ.this.kdA == null) {
                    StartUnbindQQ.this.kdA = h.a(StartUnbindQQ.this, StartUnbindQQ.this.getString(R.string.gmg), (String) null, new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.plugin.account.bind.ui.StartUnbindQQ.AnonymousClass2.AnonymousClass1 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            AppMethodBeat.i(110187);
                            g.azz().a(new com.tencent.mm.plugin.account.bind.a.d(""), 0);
                            StartUnbindQQ startUnbindQQ = StartUnbindQQ.this;
                            StartUnbindQQ startUnbindQQ2 = StartUnbindQQ.this;
                            StartUnbindQQ.this.getString(R.string.zb);
                            startUnbindQQ.tipDialog = h.a((Context) startUnbindQQ2, StartUnbindQQ.this.getString(R.string.gmh), true, (DialogInterface.OnCancelListener) null);
                            AppMethodBeat.o(110187);
                        }
                    }, new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.plugin.account.bind.ui.StartUnbindQQ.AnonymousClass2.AnonymousClass2 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                        }
                    });
                } else {
                    StartUnbindQQ.this.kdA.show();
                }
                a.a(this, "com/tencent/mm/plugin/account/bind/ui/StartUnbindQQ$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(110188);
            }
        });
        AppMethodBeat.o(110193);
    }

    @Override // com.tencent.mm.ak.i
    public void onSceneEnd(int i2, int i3, String str, com.tencent.mm.ak.q qVar) {
        AppMethodBeat.i(110194);
        Log.d("MicroMsg.StartUnbindQQ", "onSceneEnd " + i2 + " errCode " + i3 + " errMsg " + str + "  " + qVar.getType());
        if (qVar.getType() == 253) {
            if (this.tipDialog != null) {
                this.tipDialog.dismiss();
                this.tipDialog = null;
            }
            if (i2 == 0 && i3 == 0) {
                int nullAs = Util.nullAs((Integer) g.aAh().azQ().get(9, (Object) null), 0);
                Log.d("MicroMsg.StartUnbindQQ", "iBindUin ".concat(String.valueOf(nullAs)));
                if (nullAs != 0) {
                    ((l) g.af(l.class)).aSW().delete(new p(nullAs) + "@qqim");
                }
                Object obj = g.aAh().azQ().get(102407, (Object) null);
                if (obj != null && ((String) obj).length() > 0) {
                    g.aAh().azQ().set(102407, (Object) null);
                }
                try {
                    EventCenter.instance.publish(new am());
                    String str2 = new p(Util.nullAs((Integer) g.aAh().azQ().get(9, (Object) null), 0)) + "@qqim";
                    ((l) g.af(l.class)).aSW().delete(str2);
                    ((l) g.af(l.class)).aSN().aNa(str2);
                    com.tencent.mm.aj.p.aYB().My(str2);
                    String str3 = z.aTY() + "@qqim";
                    com.tencent.mm.aj.p.aYB().My(str3);
                    com.tencent.mm.aj.p.aYn();
                    e.N(str2, false);
                    com.tencent.mm.aj.p.aYn();
                    e.N(str2, true);
                    com.tencent.mm.aj.p.aYn();
                    e.N(str3, false);
                    com.tencent.mm.aj.p.aYn();
                    e.N(str3, true);
                    ar arVar = (ar) ((com.tencent.mm.plugin.account.a.a.a) g.ah(com.tencent.mm.plugin.account.a.a.a.class)).getQQGroupStg();
                    Log.d("MicroMsg.QQGroupStorage", "delete all");
                    if (arVar.iFy.delete("qqgroup", null, null) > 0) {
                        arVar.doNotify();
                    }
                    com.tencent.mm.plugin.account.a.a.jRu.WZ();
                } catch (Exception e2) {
                    Log.printErrStackTrace("MicroMsg.StartUnbindQQ", e2, "", new Object[0]);
                    Log.printErrStackTrace("MicroMsg.StartUnbindQQ", e2, "", new Object[0]);
                }
                g.aAh().azQ().set(9, (Object) 0);
                yo yoVar = new yo();
                yoVar.eeN.eeO = false;
                yoVar.eeN.eeP = true;
                EventCenter.instance.publish(yoVar);
                if (!Util.isNullOrNil(this.kaJ)) {
                    h.a(this, this.kaJ, "", getString(R.string.w1), new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.plugin.account.bind.ui.StartUnbindQQ.AnonymousClass3 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            AppMethodBeat.i(110189);
                            StartUnbindQQ.b(StartUnbindQQ.this);
                            AppMethodBeat.o(110189);
                        }
                    });
                } else {
                    ala(1);
                }
            }
            com.tencent.mm.h.a Dk = com.tencent.mm.h.a.Dk(str);
            if (Dk != null) {
                Dk.a(this, null, null);
                AppMethodBeat.o(110194);
                return;
            }
        }
        AppMethodBeat.o(110194);
    }

    static /* synthetic */ void b(StartUnbindQQ startUnbindQQ) {
        AppMethodBeat.i(110195);
        startUnbindQQ.ala(1);
        AppMethodBeat.o(110195);
    }
}

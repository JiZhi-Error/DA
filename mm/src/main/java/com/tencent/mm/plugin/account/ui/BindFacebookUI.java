package com.tencent.mm.plugin.account.ui;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.ba.i;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.friend.a.w;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.h.a.c;
import com.tencent.mm.ui.h.a.e;
import java.util.ArrayList;

public class BindFacebookUI extends MMWizardActivity implements i {
    private static final String[] kkg = {"public_profile"};
    private c kiu;
    private ProgressDialog kkd;
    private DialogInterface.OnCancelListener kke;
    private w kkf;

    @Override // com.tencent.mm.ui.MMWizardActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // com.tencent.mm.ui.MMWizardActivity, android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(127884);
        super.onCreate(bundle);
        AppMethodBeat.o(127884);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(127885);
        super.onDestroy();
        AppMethodBeat.o(127885);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        AppMethodBeat.i(127886);
        super.onResume();
        g.azz().a(183, this);
        initView();
        AppMethodBeat.o(127886);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onPause() {
        AppMethodBeat.i(127887);
        super.onPause();
        g.azz().b(183, this);
        AppMethodBeat.o(127887);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.iy;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(127888);
        this.kiu = new c(getString(R.string.c71));
        this.kke = new DialogInterface.OnCancelListener() {
            /* class com.tencent.mm.plugin.account.ui.BindFacebookUI.AnonymousClass1 */

            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.i(127877);
                if (BindFacebookUI.this.kkf != null) {
                    g.azz().a(BindFacebookUI.this.kkf);
                }
                AppMethodBeat.o(127877);
            }
        };
        addTextOptionMenu(0, getString(R.string.w4), new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.account.ui.BindFacebookUI.AnonymousClass2 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(127878);
                BindFacebookUI.b(BindFacebookUI.this);
                AppMethodBeat.o(127878);
                return true;
            }
        });
        setMMTitle(R.string.ad7);
        TextView textView = (TextView) findViewById(R.id.hlm);
        textView.setVisibility(4);
        textView.setText(R.string.ad6);
        Button button = (Button) findViewById(R.id.a3r);
        button.setVisibility(0);
        button.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.account.ui.BindFacebookUI.AnonymousClass3 */

            public final void onClick(View view) {
                AppMethodBeat.i(127879);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/ui/BindFacebookUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                BindFacebookUI.this.kiu.a(BindFacebookUI.this, BindFacebookUI.kkg, new a(BindFacebookUI.this, (byte) 0));
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/BindFacebookUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(127879);
            }
        });
        AppMethodBeat.o(127888);
    }

    final class a implements c.a {
        private a() {
        }

        /* synthetic */ a(BindFacebookUI bindFacebookUI, byte b2) {
            this();
        }

        @Override // com.tencent.mm.ui.h.a.c.a
        public final void E(Bundle bundle) {
            AppMethodBeat.i(127880);
            Log.d("MicroMsg.BindFacebookUI", "token:" + BindFacebookUI.this.kiu.jZX);
            g.aAh().azQ().set(65830, BindFacebookUI.this.kiu.jZX);
            if (BindFacebookUI.this.kiu.QjF != 0) {
                g.aAh().azQ().set(65832, Long.valueOf(BindFacebookUI.this.kiu.QjF));
            }
            String string = BindFacebookUI.this.getString(R.string.zb);
            String string2 = BindFacebookUI.this.getString(R.string.c75);
            BindFacebookUI.this.kkd = ProgressDialog.show(BindFacebookUI.this, string, string2, true);
            BindFacebookUI.this.kkd.setOnCancelListener(BindFacebookUI.this.kke);
            BindFacebookUI.this.kkf = new w(1, BindFacebookUI.this.kiu.jZX);
            g.azz().a(BindFacebookUI.this.kkf, 0);
            BindFacebookUI.go(true);
            AppMethodBeat.o(127880);
        }

        @Override // com.tencent.mm.ui.h.a.c.a
        public final void a(e eVar) {
            AppMethodBeat.i(127881);
            Log.d("MicroMsg.BindFacebookUI", "onFacebookError:" + eVar.QjS);
            h.c(BindFacebookUI.this, eVar.getMessage(), BindFacebookUI.this.getString(R.string.bat), true);
            BindFacebookUI.go(false);
            AppMethodBeat.o(127881);
        }

        @Override // com.tencent.mm.ui.h.a.c.a
        public final void a(com.tencent.mm.ui.h.a.b bVar) {
            AppMethodBeat.i(127882);
            Log.d("MicroMsg.BindFacebookUI", "onError:" + bVar.getMessage());
            h.c(BindFacebookUI.this, bVar.getMessage(), BindFacebookUI.this.getString(R.string.bat), true);
            BindFacebookUI.go(false);
            AppMethodBeat.o(127882);
        }

        @Override // com.tencent.mm.ui.h.a.c.a
        public final void onCancel() {
            AppMethodBeat.i(127883);
            Log.d("MicroMsg.BindFacebookUI", "onCancel");
            BindFacebookUI.go(false);
            AppMethodBeat.o(127883);
        }
    }

    @Override // com.tencent.mm.ak.i
    public void onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(127889);
        if (qVar.getType() != 183) {
            AppMethodBeat.o(127889);
            return;
        }
        if (this.kkd != null) {
            this.kkd.dismiss();
        }
        if (com.tencent.mm.plugin.account.a.a.jRu.a(getContext(), i2, i3, str)) {
            AppMethodBeat.o(127889);
            return;
        }
        int i4 = ((w) qVar).opType;
        if (i2 == 0 && i3 == 0) {
            if (i4 == 1) {
                ((l) g.af(l.class)).aST().bjW("facebookapp");
                ((l) g.af(l.class)).eiy().aEE("facebookapp");
            }
            ala(1);
            AppMethodBeat.o(127889);
        } else if (i2 == 4 && i3 == -67) {
            Toast.makeText(this, (int) R.string.c78, 1).show();
            AppMethodBeat.o(127889);
        } else if (i2 == 4 && i3 == -5) {
            Toast.makeText(this, i4 == 1 ? R.string.c72 : R.string.c7a, 1).show();
            AppMethodBeat.o(127889);
        } else {
            Toast.makeText(this, i4 == 0 ? R.string.bax : R.string.bat, 1).show();
            AppMethodBeat.o(127889);
        }
    }

    static /* synthetic */ void b(BindFacebookUI bindFacebookUI) {
        AppMethodBeat.i(127890);
        bindFacebookUI.ala(1);
        AppMethodBeat.o(127890);
    }

    static /* synthetic */ void go(boolean z) {
        AppMethodBeat.i(127891);
        ArrayList arrayList = new ArrayList();
        arrayList.add(new i.a(32, z ? AppEventsConstants.EVENT_PARAM_VALUE_NO : "1"));
        ((l) g.af(l.class)).aSM().d(new com.tencent.mm.ba.i(arrayList));
        AppMethodBeat.o(127891);
    }
}

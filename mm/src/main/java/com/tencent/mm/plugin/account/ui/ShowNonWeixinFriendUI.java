package com.tencent.mm.plugin.account.ui;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.aj.c;
import com.tencent.mm.aj.e;
import com.tencent.mm.aj.p;
import com.tencent.mm.cb.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.h.a.c;

public class ShowNonWeixinFriendUI extends MMActivity implements e.a {
    private long kso = 0;
    private String ksp = "";

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(128753);
        super.onCreate(bundle);
        setMMTitle(R.string.e42);
        this.kso = getIntent().getLongExtra("Contact_KFacebookId", 0);
        this.ksp = getIntent().getStringExtra("Contact_KFacebookName");
        initView();
        AppMethodBeat.o(128753);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onPause() {
        AppMethodBeat.i(128754);
        super.onPause();
        p.aYn().e(this);
        AppMethodBeat.o(128754);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        AppMethodBeat.i(128755);
        super.onResume();
        p.aYn().d(this);
        AppMethodBeat.o(128755);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.a6p;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(128756);
        ImageView imageView = (ImageView) findViewById(R.id.dzm);
        imageView.setBackgroundDrawable(a.l(this, R.raw.default_mobile_avatar));
        imageView.setImageBitmap(c.LY(new StringBuilder().append(this.kso).toString()));
        ((TextView) findViewById(R.id.dzr)).setText(this.ksp);
        ((TextView) findViewById(R.id.dzs)).setText(getString(R.string.e40, new Object[]{this.ksp}));
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.account.ui.ShowNonWeixinFriendUI.AnonymousClass1 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(128746);
                ShowNonWeixinFriendUI.this.hideVKB();
                ShowNonWeixinFriendUI.this.finish();
                AppMethodBeat.o(128746);
                return true;
            }
        });
        ((Button) findViewById(R.id.dzp)).setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.account.ui.ShowNonWeixinFriendUI.AnonymousClass2 */

            public final void onClick(View view) {
                AppMethodBeat.i(128752);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/ui/ShowNonWeixinFriendUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                com.tencent.mm.ui.h.a.c cVar = new com.tencent.mm.ui.h.a.c(ShowNonWeixinFriendUI.this.getString(R.string.c71));
                Bundle bundle = new Bundle();
                bundle.putString("message", ShowNonWeixinFriendUI.this.getString(R.string.c7j));
                bundle.putString("to", Long.toString(ShowNonWeixinFriendUI.this.kso));
                cVar.a(ShowNonWeixinFriendUI.this, "apprequests", bundle, new c.a() {
                    /* class com.tencent.mm.plugin.account.ui.ShowNonWeixinFriendUI.AnonymousClass2.AnonymousClass1 */

                    @Override // com.tencent.mm.ui.h.a.c.a
                    public final void a(com.tencent.mm.ui.h.a.e eVar) {
                        AppMethodBeat.i(128748);
                        Log.e("MicroMsg.ShowNonWeixinFriendUI", "fbinvite error");
                        AppMethodBeat.o(128748);
                    }

                    @Override // com.tencent.mm.ui.h.a.c.a
                    public final void a(com.tencent.mm.ui.h.a.b bVar) {
                        AppMethodBeat.i(128749);
                        Log.e("MicroMsg.ShowNonWeixinFriendUI", "fbinvite error");
                        AppMethodBeat.o(128749);
                    }

                    @Override // com.tencent.mm.ui.h.a.c.a
                    public final void E(Bundle bundle) {
                        AppMethodBeat.i(128750);
                        Log.i("MicroMsg.ShowNonWeixinFriendUI", "fbinvite oncomplete");
                        h.a(ShowNonWeixinFriendUI.this.getContext(), (int) R.string.c7o, (int) R.string.zb, new DialogInterface.OnClickListener() {
                            /* class com.tencent.mm.plugin.account.ui.ShowNonWeixinFriendUI.AnonymousClass2.AnonymousClass1.AnonymousClass1 */

                            public final void onClick(DialogInterface dialogInterface, int i2) {
                                AppMethodBeat.i(128747);
                                ShowNonWeixinFriendUI.this.finish();
                                AppMethodBeat.o(128747);
                            }
                        });
                        AppMethodBeat.o(128750);
                    }

                    @Override // com.tencent.mm.ui.h.a.c.a
                    public final void onCancel() {
                        AppMethodBeat.i(128751);
                        Log.e("MicroMsg.ShowNonWeixinFriendUI", "fbinvite cancle");
                        AppMethodBeat.o(128751);
                    }
                });
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/ShowNonWeixinFriendUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(128752);
            }
        });
        AppMethodBeat.o(128756);
    }

    @Override // com.tencent.mm.aj.e.a
    public final void Mr(String str) {
        AppMethodBeat.i(128757);
        initView();
        AppMethodBeat.o(128757);
    }
}

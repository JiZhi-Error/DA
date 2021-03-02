package com.tencent.mm.ui.contact;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.bd.c;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.bg;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;

public class ContactRemarkInfoViewUI extends MMActivity {
    private TextView PUI;
    private TextView PUJ;
    private ImageView PUM;
    private boolean PUR = false;
    private View PVn;
    private View PVo;
    private String cgo;
    private as contact;
    private String fuR;
    private String jid;
    private int kgm;
    private String username;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    static /* synthetic */ void e(ContactRemarkInfoViewUI contactRemarkInfoViewUI) {
        AppMethodBeat.i(37815);
        contactRemarkInfoViewUI.gUB();
        AppMethodBeat.o(37815);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(37809);
        super.onCreate(bundle);
        this.kgm = getIntent().getIntExtra("Contact_Scene", 9);
        this.username = getIntent().getStringExtra("Contact_User");
        if (Util.isNullOrNil(this.username)) {
            finish();
            AppMethodBeat.o(37809);
            return;
        }
        amZ();
        initView();
        AppMethodBeat.o(37809);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        AppMethodBeat.i(37810);
        super.onResume();
        amZ();
        this.PUI.setText(l.b(this, Util.nullAsNil(this.cgo), this.PUI.getTextSize()));
        if (!Util.isNullOrNil(this.fuR)) {
            this.PVn.setVisibility(0);
            this.PUJ.setText(Util.nullAsNil(this.fuR));
        } else {
            this.PVn.setVisibility(8);
        }
        if (!Util.isNullOrNil(this.jid)) {
            this.PVo.setVisibility(0);
            c.bez();
            if (!c.Ps(this.username)) {
                c.bez().a(this.username, this.jid, new c.a() {
                    /* class com.tencent.mm.ui.contact.ContactRemarkInfoViewUI.AnonymousClass4 */

                    @Override // com.tencent.mm.bd.c.a
                    public final void fI(final boolean z) {
                        AppMethodBeat.i(37808);
                        ContactRemarkInfoViewUI.this.PUM.post(new Runnable() {
                            /* class com.tencent.mm.ui.contact.ContactRemarkInfoViewUI.AnonymousClass4.AnonymousClass1 */

                            public final void run() {
                                AppMethodBeat.i(37807);
                                if (!z) {
                                    h.cD(ContactRemarkInfoViewUI.this, ContactRemarkInfoViewUI.this.getString(R.string.u5));
                                    AppMethodBeat.o(37807);
                                    return;
                                }
                                ContactRemarkInfoViewUI.e(ContactRemarkInfoViewUI.this);
                                AppMethodBeat.o(37807);
                            }
                        });
                        AppMethodBeat.o(37808);
                    }
                });
                AppMethodBeat.o(37810);
                return;
            }
            gUB();
            AppMethodBeat.o(37810);
            return;
        }
        this.PVo.setVisibility(8);
        AppMethodBeat.o(37810);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(37811);
        super.onDestroy();
        AppMethodBeat.o(37811);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.y9;
    }

    private void amZ() {
        AppMethodBeat.i(37812);
        bg.aVF();
        this.contact = com.tencent.mm.model.c.aSN().Kn(this.username);
        this.cgo = this.contact.arJ();
        this.fuR = this.contact.fuR;
        this.jid = this.contact.fuS;
        AppMethodBeat.o(37812);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(37813);
        this.PUI = (TextView) findViewById(R.id.bbc);
        this.PUJ = (TextView) findViewById(R.id.bba);
        this.PUM = (ImageView) findViewById(R.id.h08);
        this.PVn = findViewById(R.id.bdc);
        this.PVo = findViewById(R.id.bdd);
        setMMTitle(R.string.bd2);
        this.PUM.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.ui.contact.ContactRemarkInfoViewUI.AnonymousClass1 */

            public final void onClick(View view) {
                AppMethodBeat.i(37804);
                b bVar = new b();
                bVar.bm(view);
                a.b("com/tencent/mm/ui/contact/ContactRemarkInfoViewUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (!ContactRemarkInfoViewUI.this.PUR) {
                    a.a(this, "com/tencent/mm/ui/contact/ContactRemarkInfoViewUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(37804);
                    return;
                }
                Intent intent = new Intent(ContactRemarkInfoViewUI.this, ContactRemarkImagePreviewUI.class);
                intent.putExtra("Contact_User", ContactRemarkInfoViewUI.this.username);
                c.bez();
                intent.putExtra("remark_image_path", c.Pr(ContactRemarkInfoViewUI.this.username));
                intent.putExtra("view_only", true);
                ContactRemarkInfoViewUI contactRemarkInfoViewUI = ContactRemarkInfoViewUI.this;
                com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                a.a(contactRemarkInfoViewUI, bl.axQ(), "com/tencent/mm/ui/contact/ContactRemarkInfoViewUI$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                contactRemarkInfoViewUI.startActivity((Intent) bl.pG(0));
                a.a(contactRemarkInfoViewUI, "com/tencent/mm/ui/contact/ContactRemarkInfoViewUI$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                a.a(this, "com/tencent/mm/ui/contact/ContactRemarkInfoViewUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(37804);
            }
        });
        addTextOptionMenu(0, getString(R.string.tt), new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.ui.contact.ContactRemarkInfoViewUI.AnonymousClass2 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(37805);
                Intent intent = new Intent();
                intent.setClass(ContactRemarkInfoViewUI.this.getContext(), ContactRemarkInfoModUI.class);
                intent.putExtra("Contact_Scene", ContactRemarkInfoViewUI.this.kgm);
                intent.putExtra("Contact_User", ContactRemarkInfoViewUI.this.contact.field_username);
                ContactRemarkInfoViewUI contactRemarkInfoViewUI = ContactRemarkInfoViewUI.this;
                com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                a.a(contactRemarkInfoViewUI, bl.axQ(), "com/tencent/mm/ui/contact/ContactRemarkInfoViewUI$2", "onMenuItemClick", "(Landroid/view/MenuItem;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                contactRemarkInfoViewUI.startActivity((Intent) bl.pG(0));
                a.a(contactRemarkInfoViewUI, "com/tencent/mm/ui/contact/ContactRemarkInfoViewUI$2", "onMenuItemClick", "(Landroid/view/MenuItem;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                AppMethodBeat.o(37805);
                return false;
            }
        });
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.ui.contact.ContactRemarkInfoViewUI.AnonymousClass3 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(37806);
                ContactRemarkInfoViewUI.this.finish();
                AppMethodBeat.o(37806);
                return true;
            }
        });
        AppMethodBeat.o(37813);
    }

    private void gUB() {
        AppMethodBeat.i(37814);
        c.bez();
        Bitmap Pu = c.Pu(this.username);
        if (Pu != null) {
            this.PUM.setImageBitmap(Pu);
            this.PUR = true;
        }
        AppMethodBeat.o(37814);
    }
}

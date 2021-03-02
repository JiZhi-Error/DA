package com.tencent.mm.ui.contact;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextPaint;
import android.text.TextWatcher;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.bd.c;
import com.tencent.mm.g.a.yr;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bg;
import com.tencent.mm.modelmulti.p;
import com.tencent.mm.platformtools.af;
import com.tencent.mm.plugin.messenger.foundation.a.a.k;
import com.tencent.mm.pluginsdk.ui.ProfileEditPhoneNumberView;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.pluginsdk.ui.span.m;
import com.tencent.mm.pluginsdk.ui.tools.s;
import com.tencent.mm.protocal.protobuf.cpo;
import com.tencent.mm.protocal.protobuf.cqe;
import com.tencent.mm.protocal.protobuf.dbk;
import com.tencent.mm.protocal.protobuf.dbl;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorageEx;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.cn;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMClearEditText;
import com.tencent.mm.ui.base.MMTagPanel;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.t;
import com.tencent.mm.ui.tools.b.c;
import com.tencent.mm.ui.tools.f;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.mm.vfs.o;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ContactRemarkInfoModUI extends MMActivity implements i {
    private String KpU;
    private MMClearEditText PUF;
    private TextView PUG;
    private MMEditText PUH;
    private TextView PUI;
    private TextView PUJ;
    private TextView PUK;
    private TextView PUL;
    private ImageView PUM;
    private ImageView PUN;
    private TextView PUO;
    private View PUP;
    private String PUQ;
    private boolean PUR = false;
    private boolean PUS = false;
    private boolean PUT = false;
    private boolean PUU = false;
    private boolean PUV = false;
    private a PUW = new a(this, (byte) 0);
    private MMTagPanel PUX;
    private TextView PUY;
    private List<String> PUZ;
    private ProfileEditPhoneNumberView PVa;
    private String PVb;
    private String PVc;
    private TextWatcher PVd = new TextWatcher() {
        /* class com.tencent.mm.ui.contact.ContactRemarkInfoModUI.AnonymousClass1 */

        public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        public final void afterTextChanged(Editable editable) {
            AppMethodBeat.i(37749);
            ContactRemarkInfoModUI.a(ContactRemarkInfoModUI.this);
            AppMethodBeat.o(37749);
        }
    };
    private b PVe = new b(this, (byte) 0);
    private String PVf;
    private MStorageEx.IOnStorageChange PVg = new MStorageEx.IOnStorageChange() {
        /* class com.tencent.mm.ui.contact.ContactRemarkInfoModUI.AnonymousClass10 */

        @Override // com.tencent.mm.sdk.storage.MStorageEx.IOnStorageChange
        public final void onNotifyChange(int i2, MStorageEx mStorageEx, Object obj) {
            AppMethodBeat.i(37758);
            Log.d("MiroMsg.ContactRemarkInfoModUI", "cpan onNotifyChange");
            ContactRemarkInfoModUI.d(ContactRemarkInfoModUI.this);
            AppMethodBeat.o(37758);
        }
    };
    boolean PVh = true;
    boolean PVi = false;
    private boolean PVj = false;
    private String cgo;
    private as contact;
    private String fuR;
    private ProgressDialog iLh;
    private String jid;
    private int kgm;
    private View uhh;
    private String username;
    private String yDk;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public ContactRemarkInfoModUI() {
        AppMethodBeat.i(37771);
        AppMethodBeat.o(37771);
    }

    static /* synthetic */ void a(ContactRemarkInfoModUI contactRemarkInfoModUI) {
        AppMethodBeat.i(37794);
        contactRemarkInfoModUI.amS();
        AppMethodBeat.o(37794);
    }

    static /* synthetic */ void a(ContactRemarkInfoModUI contactRemarkInfoModUI, boolean z, int i2) {
        AppMethodBeat.i(37797);
        contactRemarkInfoModUI.ae(z, i2);
        AppMethodBeat.o(37797);
    }

    static /* synthetic */ void d(ContactRemarkInfoModUI contactRemarkInfoModUI) {
        AppMethodBeat.i(37796);
        contactRemarkInfoModUI.gUH();
        AppMethodBeat.o(37796);
    }

    static /* synthetic */ void j(ContactRemarkInfoModUI contactRemarkInfoModUI) {
        AppMethodBeat.i(37798);
        contactRemarkInfoModUI.gUA();
        AppMethodBeat.o(37798);
    }

    static /* synthetic */ void q(ContactRemarkInfoModUI contactRemarkInfoModUI) {
        AppMethodBeat.i(37801);
        contactRemarkInfoModUI.goBack();
        AppMethodBeat.o(37801);
    }

    static /* synthetic */ void u(ContactRemarkInfoModUI contactRemarkInfoModUI) {
        AppMethodBeat.i(37802);
        contactRemarkInfoModUI.gUB();
        AppMethodBeat.o(37802);
    }

    static /* synthetic */ void v(ContactRemarkInfoModUI contactRemarkInfoModUI) {
        AppMethodBeat.i(37803);
        contactRemarkInfoModUI.gUF();
        AppMethodBeat.o(37803);
    }

    /* access modifiers changed from: package-private */
    public class b implements TextWatcher {
        private int CYV;
        private String PVm;

        private b() {
            this.CYV = 800;
            this.PVm = "";
        }

        /* synthetic */ b(ContactRemarkInfoModUI contactRemarkInfoModUI, byte b2) {
            this();
        }

        public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        public final void afterTextChanged(Editable editable) {
            AppMethodBeat.i(37768);
            this.CYV = f.dp(800, editable.toString());
            if (this.CYV < 0) {
                this.CYV = 0;
            }
            if (ContactRemarkInfoModUI.this.PUL != null) {
                ContactRemarkInfoModUI.this.PUL.setText(new StringBuilder().append(this.CYV).toString());
            }
            ContactRemarkInfoModUI.a(ContactRemarkInfoModUI.this);
            AppMethodBeat.o(37768);
        }
    }

    /* access modifiers changed from: package-private */
    public class a implements View.OnClickListener {
        private a() {
        }

        /* synthetic */ a(ContactRemarkInfoModUI contactRemarkInfoModUI, byte b2) {
            this();
        }

        public final void onClick(View view) {
            AppMethodBeat.i(37767);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/contact/ContactRemarkInfoModUI$LabelEditOnClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            ContactRemarkInfoModUI.c(ContactRemarkInfoModUI.this);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/ContactRemarkInfoModUI$LabelEditOnClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(37767);
        }
    }

    private void amS() {
        boolean z;
        AppMethodBeat.i(37772);
        ProfileEditPhoneNumberView profileEditPhoneNumberView = this.PVa;
        ArrayList<String> phoneNumberList = profileEditPhoneNumberView.getPhoneNumberList();
        if (phoneNumberList == null || phoneNumberList.isEmpty()) {
            if (profileEditPhoneNumberView.KcK != null) {
                z = true;
            }
            z = false;
        } else if (profileEditPhoneNumberView.KcK == null) {
            z = true;
        } else if (phoneNumberList.size() != profileEditPhoneNumberView.KcK.length) {
            z = true;
        } else {
            Iterator<String> it = phoneNumberList.iterator();
            int i2 = 0;
            while (true) {
                if (!it.hasNext()) {
                    break;
                } else if (!it.next().equals(profileEditPhoneNumberView.KcK[i2])) {
                    z = true;
                    break;
                } else {
                    i2++;
                }
            }
            z = false;
        }
        this.PVj = z;
        if (gUD() || gUE() || Co(false) || this.PVj) {
            enableOptionMenu(true);
            AppMethodBeat.o(37772);
            return;
        }
        enableOptionMenu(false);
        AppMethodBeat.o(37772);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(37773);
        super.onCreate(bundle);
        bg.azz().a(575, this);
        bg.azz().a(576, this);
        this.kgm = getIntent().getIntExtra("Contact_Scene", 9);
        this.KpU = getIntent().getStringExtra("Contact_RoomNickname");
        this.PUU = getIntent().getBooleanExtra("view_mode", false);
        this.PVf = getIntent().getStringExtra("contact_auto_app_phone_from_chatting");
        this.PVb = getIntent().getStringExtra("contact_phone_number_by_md5");
        this.PVc = getIntent().getStringExtra("contact_phone_number_list");
        this.username = getIntent().getStringExtra("Contact_User");
        if (af.isNullOrNil(this.username)) {
            finish();
            AppMethodBeat.o(37773);
            return;
        }
        bg.aVF();
        this.contact = com.tencent.mm.model.c.aSN().Kn(this.username);
        this.cgo = this.contact.field_conRemark;
        this.fuR = this.contact.fuR;
        this.jid = this.contact.fuS;
        this.yDk = this.contact.field_contactLabelIds;
        this.PUZ = com.tencent.mm.plugin.label.a.a.ecg().aCJ(this.yDk);
        initView();
        amS();
        if (this.contact != null && as.bjp(this.contact.field_username)) {
            if (this.PUF == null) {
                AppMethodBeat.o(37773);
                return;
            }
            ViewGroup viewGroup = (ViewGroup) this.PUF.getParent();
            ViewGroup viewGroup2 = (ViewGroup) viewGroup.getParent();
            int childCount = viewGroup2.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = viewGroup2.getChildAt(i2);
                if (childAt != viewGroup) {
                    childAt.setVisibility(8);
                }
            }
        }
        AppMethodBeat.o(37773);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        AppMethodBeat.i(37774);
        super.onResume();
        bg.aVF();
        com.tencent.mm.model.c.aSN().add(this.PVg);
        gUH();
        AppMethodBeat.o(37774);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onPause() {
        AppMethodBeat.i(37775);
        bg.aVF();
        com.tencent.mm.model.c.aSN().remove(this.PVg);
        super.onPause();
        AppMethodBeat.o(37775);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(37776);
        bg.azz().b(575, this);
        bg.azz().b(576, this);
        this.PUF.removeTextChangedListener(this.PVd);
        this.PUH.removeTextChangedListener(this.PVe);
        super.onDestroy();
        AppMethodBeat.o(37776);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.y8;
    }

    private void ae(boolean z, int i2) {
        AppMethodBeat.i(37777);
        if (this.PUT) {
            this.PUI.setVisibility(8);
            if (z && af.isNullOrNil(this.fuR)) {
                this.PUJ.setVisibility(0);
                this.uhh.setVisibility(8);
            } else if (i2 == R.id.bba) {
                this.PUJ.setVisibility(8);
                this.uhh.setVisibility(0);
            }
            this.PUF.setVisibility(0);
            AppMethodBeat.o(37777);
            return;
        }
        this.PUI.setVisibility(0);
        this.PUJ.setVisibility(0);
        this.PUF.setVisibility(8);
        this.uhh.setVisibility(8);
        AppMethodBeat.o(37777);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        boolean z;
        AppMethodBeat.i(37778);
        this.PUG = (TextView) findViewById(R.id.bb5);
        this.PUI = (TextView) findViewById(R.id.bbc);
        this.PUJ = (TextView) findViewById(R.id.bba);
        this.PUK = (TextView) findViewById(R.id.bbb);
        this.PUF = (MMClearEditText) findViewById(R.id.bb4);
        this.PUH = (MMEditText) findViewById(R.id.bb3);
        this.PUM = (ImageView) findViewById(R.id.h08);
        this.PUN = (ImageView) findViewById(R.id.h09);
        this.PUL = (TextView) findViewById(R.id.joi);
        this.uhh = findViewById(R.id.bb2);
        this.PVa = (ProfileEditPhoneNumberView) findViewById(R.id.fik);
        this.PVa.rjX = this.contact;
        ProfileEditPhoneNumberView profileEditPhoneNumberView = this.PVa;
        String str = this.PVb;
        String str2 = this.PVc;
        profileEditPhoneNumberView.KcI = str;
        profileEditPhoneNumberView.KcJ = str2;
        profileEditPhoneNumberView.eEV();
        this.PVa.KcN = new ProfileEditPhoneNumberView.a() {
            /* class com.tencent.mm.ui.contact.ContactRemarkInfoModUI.AnonymousClass11 */

            @Override // com.tencent.mm.pluginsdk.ui.ProfileEditPhoneNumberView.a
            public final void onChange() {
                AppMethodBeat.i(37759);
                ContactRemarkInfoModUI.a(ContactRemarkInfoModUI.this);
                AppMethodBeat.o(37759);
            }

            @Override // com.tencent.mm.pluginsdk.ui.ProfileEditPhoneNumberView.a
            public final void goV() {
                AppMethodBeat.i(37760);
                ab.D(ContactRemarkInfoModUI.this.contact);
                p.bdS().tE(7);
                AppMethodBeat.o(37760);
            }
        };
        this.PUX = (MMTagPanel) findViewById(R.id.bb0);
        this.PUX.setPanelClickable(false);
        this.PUY = (TextView) findViewById(R.id.bay);
        this.PUY.setText(R.string.f2p);
        this.PUX.setOnClickListener(this.PUW);
        this.PUY.setOnClickListener(this.PUW);
        setMMTitle(R.string.bd1);
        if (!af.isNullOrNil(this.cgo)) {
            this.PUF.setText(l.b(this, af.nullAsNil(this.cgo), this.PUF.getTextSize()));
            this.PUI.setText(l.b(this, af.nullAsNil(this.cgo), this.PUI.getTextSize()));
        } else {
            this.PUF.setText(l.b(this, af.nullAsNil(this.contact.arI()), this.PUF.getTextSize()));
            this.PUI.setText(l.b(this, af.nullAsNil(this.contact.arI()), this.PUF.getTextSize()));
        }
        this.PUF.setSelection(this.PUF.getText().length());
        this.PUH.setText(l.b(this, af.nullAsNil(this.fuR), this.PUJ.getTextSize()));
        this.PUH.setSelection(this.PUH.getText().length());
        if (!af.isNullOrNil(this.fuR)) {
            this.PUJ.setText(l.b(this, af.nullAsNil(this.fuR), this.PUJ.getTextSize()));
            this.PUJ.setTextColor(getContext().getResources().getColor(R.color.FG_0));
        }
        this.PUI.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.ui.contact.ContactRemarkInfoModUI.AnonymousClass12 */

            public final void onClick(View view) {
                AppMethodBeat.i(37761);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/contact/ContactRemarkInfoModUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                ContactRemarkInfoModUI.this.PUT = true;
                ContactRemarkInfoModUI.a(ContactRemarkInfoModUI.this, false, view.getId());
                ContactRemarkInfoModUI.this.PUF.performClick();
                ContactRemarkInfoModUI.this.PUF.requestFocus();
                ContactRemarkInfoModUI.this.showVKB();
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/ContactRemarkInfoModUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(37761);
            }
        });
        this.PUJ.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.ui.contact.ContactRemarkInfoModUI.AnonymousClass13 */

            public final void onClick(View view) {
                AppMethodBeat.i(37762);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/contact/ContactRemarkInfoModUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                ContactRemarkInfoModUI.this.PUT = true;
                ContactRemarkInfoModUI.a(ContactRemarkInfoModUI.this, false, view.getId());
                ContactRemarkInfoModUI.this.PUH.performClick();
                ContactRemarkInfoModUI.this.PUH.requestFocus();
                ContactRemarkInfoModUI.this.showVKB();
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/ContactRemarkInfoModUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(37762);
            }
        });
        this.PUF.addTextChangedListener(this.PVd);
        this.PUL.setText(new StringBuilder().append(f.dp(800, this.PUH.getEditableText().toString())).toString());
        this.PUH.addTextChangedListener(this.PVe);
        if (!af.isNullOrNil(this.jid)) {
            this.PUK.setVisibility(8);
            this.PUM.setVisibility(0);
            com.tencent.mm.bd.c.bez();
            if (!com.tencent.mm.bd.c.Ps(this.username)) {
                com.tencent.mm.bd.c.bez().a(this.username, this.jid, new c.a() {
                    /* class com.tencent.mm.ui.contact.ContactRemarkInfoModUI.AnonymousClass5 */

                    @Override // com.tencent.mm.bd.c.a
                    public final void fI(final boolean z) {
                        AppMethodBeat.i(37754);
                        ContactRemarkInfoModUI.this.PUM.post(new Runnable() {
                            /* class com.tencent.mm.ui.contact.ContactRemarkInfoModUI.AnonymousClass5.AnonymousClass1 */

                            public final void run() {
                                AppMethodBeat.i(37753);
                                if (!z) {
                                    h.cD(ContactRemarkInfoModUI.this, ContactRemarkInfoModUI.this.getString(R.string.u5));
                                    ContactRemarkInfoModUI.this.PUN.setVisibility(0);
                                    ContactRemarkInfoModUI.this.PUK.setVisibility(8);
                                    ContactRemarkInfoModUI.this.PUM.setVisibility(8);
                                    AppMethodBeat.o(37753);
                                    return;
                                }
                                ContactRemarkInfoModUI.u(ContactRemarkInfoModUI.this);
                                AppMethodBeat.o(37753);
                            }
                        });
                        AppMethodBeat.o(37754);
                    }
                });
            } else {
                gUB();
            }
        } else {
            this.PUK.setVisibility(0);
            this.PUM.setVisibility(8);
        }
        this.PUM.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.ui.contact.ContactRemarkInfoModUI.AnonymousClass14 */

            public final void onClick(View view) {
                String str;
                AppMethodBeat.i(37763);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/contact/ContactRemarkInfoModUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (!ContactRemarkInfoModUI.this.PUR) {
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/ContactRemarkInfoModUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(37763);
                    return;
                }
                ContactRemarkInfoModUI.j(ContactRemarkInfoModUI.this);
                Intent intent = new Intent(ContactRemarkInfoModUI.this, ContactRemarkImagePreviewUI.class);
                intent.putExtra("Contact_User", ContactRemarkInfoModUI.this.username);
                if (af.isNullOrNil(ContactRemarkInfoModUI.this.jid) || ContactRemarkInfoModUI.this.PUS) {
                    str = ContactRemarkInfoModUI.this.PUQ;
                } else {
                    com.tencent.mm.bd.c.bez();
                    str = com.tencent.mm.bd.c.Pr(ContactRemarkInfoModUI.this.username);
                }
                intent.putExtra("remark_image_path", str);
                intent.putExtra("view_temp_remark_image", ContactRemarkInfoModUI.this.PUS);
                ContactRemarkInfoModUI.this.startActivityForResult(intent, 400);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/ContactRemarkInfoModUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(37763);
            }
        });
        this.PUK.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.ui.contact.ContactRemarkInfoModUI.AnonymousClass15 */

            public final void onClick(View view) {
                AppMethodBeat.i(37764);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/contact/ContactRemarkInfoModUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (af.isNullOrNil(ContactRemarkInfoModUI.this.jid) || ContactRemarkInfoModUI.this.PUV) {
                    ContactRemarkInfoModUI.a(ContactRemarkInfoModUI.this, false);
                    ContactRemarkInfoModUI.j(ContactRemarkInfoModUI.this);
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/ContactRemarkInfoModUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(37764);
            }
        });
        com.tencent.mm.plugin.account.friend.a.a SR = com.tencent.mm.plugin.account.a.getAddrUploadStg().SR(this.contact.field_username);
        if (SR == null || af.isNullOrNil(SR.bnK()) || SR.bnK().equals(this.PUF.getText().toString())) {
            z = false;
        } else {
            this.PUO = (TextView) findViewById(R.id.fit);
            this.PUP = findViewById(R.id.fil);
            this.PUP.setVisibility(0);
            this.PUO.setText(af.nullAsNil(getString(R.string.bfe, new Object[]{SR.bnK()})));
            m mVar = new m(getString(R.string.j40));
            mVar.setSpan(new c(SR.bnK()), 0, mVar.length(), 17);
            this.PUO.append(" ");
            this.PUO.append(mVar);
            this.PUO.setMovementMethod(LinkMovementMethod.getInstance());
            z = true;
        }
        if (!z && this.kgm == 14 && !af.isNullOrNil(this.KpU) && !this.KpU.equals(this.PUF.getText().toString())) {
            this.PUO = (TextView) findViewById(R.id.fit);
            this.PUP = findViewById(R.id.fil);
            this.PUP.setVisibility(0);
            this.PUO.setText(l.b(this, af.nullAsNil(getString(R.string.bfd, new Object[]{this.KpU})), this.PUO.getTextSize()));
            m mVar2 = new m(getString(R.string.j40));
            mVar2.setSpan(new c(this.KpU), 0, mVar2.length(), 17);
            this.PUO.append(" ");
            this.PUO.append(mVar2);
            this.PUO.setMovementMethod(LinkMovementMethod.getInstance());
        }
        addTextOptionMenu(0, getString(R.string.vl), new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.ui.contact.ContactRemarkInfoModUI.AnonymousClass16 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(37765);
                ContactRemarkInfoModUI.p(ContactRemarkInfoModUI.this);
                ContactRemarkInfoModUI.this.hideVKB();
                AppMethodBeat.o(37765);
                return false;
            }
        }, null, t.b.GREEN);
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.ui.contact.ContactRemarkInfoModUI.AnonymousClass17 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(37766);
                ContactRemarkInfoModUI.q(ContactRemarkInfoModUI.this);
                AppMethodBeat.o(37766);
                return true;
            }
        });
        if (af.isNullOrNil(this.cgo)) {
            enableOptionMenu(true);
        } else {
            enableOptionMenu(false);
        }
        this.PUN.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.ui.contact.ContactRemarkInfoModUI.AnonymousClass2 */

            public final void onClick(View view) {
                AppMethodBeat.i(37750);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/contact/ContactRemarkInfoModUI$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                ContactRemarkInfoModUI.a(ContactRemarkInfoModUI.this, true);
                ContactRemarkInfoModUI.j(ContactRemarkInfoModUI.this);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/ContactRemarkInfoModUI$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(37750);
            }
        });
        if (!this.PUU) {
            this.PUT = true;
            ae(true, -1);
        }
        gUA();
        AppMethodBeat.o(37778);
    }

    private void gUA() {
        AppMethodBeat.i(37779);
        this.PUG.setFocusableInTouchMode(true);
        this.PUG.requestFocus();
        this.PUF.clearFocus();
        this.PUH.clearFocus();
        this.PVa.clearFocus();
        hideVKB();
        AppMethodBeat.o(37779);
    }

    private void gUB() {
        AppMethodBeat.i(37780);
        com.tencent.mm.bd.c.bez();
        Bitmap Pu = com.tencent.mm.bd.c.Pu(this.username);
        if (Pu != null) {
            this.PUK.setVisibility(8);
            this.PUN.setVisibility(8);
            this.PUM.setVisibility(0);
            this.PUM.setImageBitmap(Pu);
        }
        this.PUR = true;
        AppMethodBeat.o(37780);
    }

    private void bnu(String str) {
        AppMethodBeat.i(37781);
        if (af.isNullOrNil(str)) {
            AppMethodBeat.o(37781);
            return;
        }
        o oVar = new o(str);
        if (!oVar.exists()) {
            AppMethodBeat.o(37781);
        } else if (oVar.length() > 204800) {
            h.c(this, getString(R.string.b_y), null, true);
            AppMethodBeat.o(37781);
        } else {
            Bitmap decodeFile = BackwardSupportUtil.BitmapFactory.decodeFile(this.PUQ, com.tencent.mm.cb.a.getDensity(this));
            if (decodeFile != null) {
                this.PUK.setVisibility(8);
                this.PUN.setVisibility(8);
                this.PUM.setVisibility(0);
                this.PUM.setImageBitmap(decodeFile);
                this.PUR = true;
            }
            AppMethodBeat.o(37781);
        }
    }

    private void gUC() {
        AppMethodBeat.i(37782);
        if (!this.PVj) {
            AppMethodBeat.o(37782);
            return;
        }
        cqe cqe = new cqe();
        cqe.MvG = this.username;
        dbl dbl = new dbl();
        dbl.MGv = new LinkedList<>();
        ArrayList<String> phoneNumberList = this.PVa.getPhoneNumberList();
        ArrayList arrayList = new ArrayList();
        if (phoneNumberList != null) {
            Iterator<String> it = phoneNumberList.iterator();
            while (it.hasNext()) {
                String next = it.next();
                if (com.tencent.mm.plugin.bbom.c.ahc(next)) {
                    dbk dbk = new dbk();
                    dbk.MGu = next;
                    dbl.MGv.add(dbk);
                    arrayList.add(next);
                }
            }
        }
        dbl.oTz = arrayList.size();
        cqe.Mvx = dbl;
        bg.aVF();
        com.tencent.mm.model.c.aSM().d(new k.a(60, cqe));
        bg.aVF();
        as Kn = com.tencent.mm.model.c.aSN().Kn(this.username);
        if (Kn != null && ((int) Kn.gMZ) > 0 && com.tencent.mm.contact.c.oR(Kn.field_type)) {
            String j2 = com.tencent.mm.contact.a.j(arrayList);
            Log.i("MiroMsg.ContactRemarkInfoModUI", "[dealModPhoneNumberList] username:%s %s", this.username, j2);
            this.contact.Ci(j2);
            com.tencent.mm.contact.a.g(this.contact);
            bg.aVF();
            com.tencent.mm.model.c.aSN().ao(this.contact);
        }
        AppMethodBeat.o(37782);
    }

    private boolean Co(boolean z) {
        boolean z2;
        AppMethodBeat.i(37783);
        String obj = this.PUF.getText().toString();
        if (z) {
            if ((this.cgo == null || !this.cgo.equals(obj)) && (!af.isNullOrNil(this.cgo) || !af.isNullOrNil(obj))) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (!z2 || (obj != null && obj.equals(this.contact.field_nickname))) {
                AppMethodBeat.o(37783);
                return false;
            }
            AppMethodBeat.o(37783);
            return true;
        } else if ((this.cgo == null || !this.cgo.equals(obj)) && (!af.isNullOrNil(this.cgo) || !af.isNullOrNil(obj))) {
            AppMethodBeat.o(37783);
            return true;
        } else {
            AppMethodBeat.o(37783);
            return false;
        }
    }

    private boolean gUD() {
        AppMethodBeat.i(37784);
        String obj = this.PUH.getText().toString();
        if ((this.fuR == null || !this.fuR.equals(obj)) && (!af.isNullOrNil(this.fuR) || !af.isNullOrNil(obj))) {
            AppMethodBeat.o(37784);
            return true;
        }
        AppMethodBeat.o(37784);
        return false;
    }

    private boolean gUE() {
        AppMethodBeat.i(37785);
        if (!af.isNullOrNil(this.PUQ) || this.PUV) {
            AppMethodBeat.o(37785);
            return true;
        }
        AppMethodBeat.o(37785);
        return false;
    }

    private void goBack() {
        AppMethodBeat.i(37786);
        boolean gUE = gUE();
        boolean Co = Co(true);
        boolean gUD = gUD();
        if (gUE || Co || gUD) {
            h.c(this, getString(R.string.beo), null, getString(R.string.beq), getString(R.string.bep), new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.ui.contact.ContactRemarkInfoModUI.AnonymousClass8 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(37756);
                    ContactRemarkInfoModUI.p(ContactRemarkInfoModUI.this);
                    AppMethodBeat.o(37756);
                }
            }, new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.ui.contact.ContactRemarkInfoModUI.AnonymousClass9 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(37757);
                    ContactRemarkInfoModUI.this.finish();
                    AppMethodBeat.o(37757);
                }
            });
            AppMethodBeat.o(37786);
            return;
        }
        hideVKB();
        finish();
        AppMethodBeat.o(37786);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, android.support.v7.app.AppCompatActivity
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        AppMethodBeat.i(37787);
        if (keyEvent.getKeyCode() == 4) {
            goBack();
            AppMethodBeat.o(37787);
            return true;
        }
        AppMethodBeat.o(37787);
        return false;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(37788);
        Log.i("MiroMsg.ContactRemarkInfoModUI", "onAcvityResult requestCode:%d, resultCode:%d", Integer.valueOf(i2), Integer.valueOf(i3));
        if (intent == null) {
            Log.e("MiroMsg.ContactRemarkInfoModUI", "data shouldnot be null");
            AppMethodBeat.o(37788);
            return;
        }
        switch (i2) {
            case 100:
                Context applicationContext = getApplicationContext();
                bg.aVF();
                String h2 = s.h(applicationContext, intent, com.tencent.mm.model.c.aSY());
                if (h2 == null) {
                    AppMethodBeat.o(37788);
                    return;
                }
                this.PUQ = bnv(h2);
                bnu(this.PUQ);
                this.PUS = true;
                this.PUV = false;
                amS();
                AppMethodBeat.o(37788);
                return;
            case 200:
                Context applicationContext2 = getApplicationContext();
                bg.aVF();
                String i4 = com.tencent.mm.ui.tools.a.i(applicationContext2, intent, com.tencent.mm.model.c.aSY());
                if (i4 == null) {
                    AppMethodBeat.o(37788);
                    return;
                }
                this.PUQ = bnv(i4);
                bnu(this.PUQ);
                this.PUS = true;
                this.PUV = false;
                amS();
                AppMethodBeat.o(37788);
                return;
            case 400:
                if (intent.getBooleanExtra("response_delete", false)) {
                    gUF();
                }
                AppMethodBeat.o(37788);
                return;
            case 600:
                if (Co(true) || gUD() || gUE() || intent.getBooleanExtra("hasLableChange", false)) {
                    enableOptionMenu(true);
                    AppMethodBeat.o(37788);
                    return;
                }
                enableOptionMenu(false);
                AppMethodBeat.o(37788);
                return;
            default:
                AppMethodBeat.o(37788);
                return;
        }
    }

    private void gUF() {
        AppMethodBeat.i(37789);
        this.PUV = true;
        this.PUN.setVisibility(8);
        this.PUK.setVisibility(0);
        this.PUM.setVisibility(8);
        this.PUM.setImageBitmap(null);
        amS();
        AppMethodBeat.o(37789);
    }

    @Override // com.tencent.mm.ak.i
    public void onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(37790);
        Log.i("MiroMsg.ContactRemarkInfoModUI", "onSceneEnd: errType = " + i2 + " errCode = " + i3 + " errMsg = " + str);
        if (this.iLh != null) {
            this.iLh.dismiss();
            this.iLh = null;
        }
        if (i2 == 0 && i3 == 0) {
            if (qVar.getType() == 575) {
                if (this.PUQ != null) {
                    o oVar = new o(this.PUQ);
                    if (oVar.exists()) {
                        com.tencent.mm.bd.c.bez();
                        oVar.am(new o(com.tencent.mm.bd.c.Pr(this.username)));
                    }
                }
                String str2 = ((com.tencent.mm.bd.b) qVar).jid;
                if (!af.isNullOrNil(str2)) {
                    this.jid = str2;
                }
            } else if (qVar.getType() == 576) {
                this.PUQ = null;
                this.jid = null;
                this.PUR = false;
                bg.aVF();
                this.contact = com.tencent.mm.model.c.aSN().Kn(this.username);
                this.contact.Cd("");
                bg.aVF();
                com.tencent.mm.model.c.aSN().c(this.username, this.contact);
            }
            finish();
            AppMethodBeat.o(37790);
            return;
        }
        h.c(this, getString(R.string.u4), null, true);
        AppMethodBeat.o(37790);
    }

    private String bnv(String str) {
        AppMethodBeat.i(37791);
        if (!com.tencent.mm.vfs.s.YS(str)) {
            AppMethodBeat.o(37791);
            return null;
        }
        int exifOrientation = BackwardSupportUtil.ExifHelper.getExifOrientation(str);
        StringBuilder sb = new StringBuilder();
        com.tencent.mm.bd.c.bez();
        String sb2 = sb.append(com.tencent.mm.bd.c.Pr(this.username)).append(".tmp").toString();
        if (!BitmapUtil.createThumbNail(str, 960, 960, Bitmap.CompressFormat.JPEG, 70, sb2)) {
            Log.e("MiroMsg.ContactRemarkInfoModUI", "createThumbNail big pic fail");
            AppMethodBeat.o(37791);
            return null;
        } else if (exifOrientation == 0 || BitmapUtil.rotate(sb2, exifOrientation, Bitmap.CompressFormat.JPEG, 70, sb2)) {
            AppMethodBeat.o(37791);
            return sb2;
        } else {
            Log.e("MiroMsg.ContactRemarkInfoModUI", "rotate big pic fail");
            AppMethodBeat.o(37791);
            return null;
        }
    }

    private void gUG() {
        AppMethodBeat.i(37792);
        if (!af.isNullOrNil(this.yDk)) {
            this.PUX.setVisibility(0);
            this.PUY.setVisibility(8);
            this.PUX.a(this.PUZ, this.PUZ);
            AppMethodBeat.o(37792);
            return;
        }
        this.PUX.setVisibility(8);
        this.PUY.setVisibility(0);
        AppMethodBeat.o(37792);
    }

    private void gUH() {
        AppMethodBeat.i(37793);
        bg.aVF();
        this.contact = com.tencent.mm.model.c.aSN().Kn(this.username);
        this.yDk = this.contact.field_contactLabelIds;
        this.PUZ = com.tencent.mm.plugin.label.a.a.ecg().aCJ(this.yDk);
        gUG();
        AppMethodBeat.o(37793);
    }

    /* access modifiers changed from: package-private */
    public class c extends ClickableSpan {
        public String remark;

        public c(String str) {
            this.remark = str;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(37769);
            ContactRemarkInfoModUI.this.PUT = true;
            ContactRemarkInfoModUI.a(ContactRemarkInfoModUI.this, true, -1);
            ContactRemarkInfoModUI.this.PUF.setText(l.b(ContactRemarkInfoModUI.this, af.nullAsNil(this.remark), ContactRemarkInfoModUI.this.PUF.getTextSize()));
            ContactRemarkInfoModUI.this.PUF.setSelection(ContactRemarkInfoModUI.this.PUF.getText().length());
            ContactRemarkInfoModUI.this.PUP.setVisibility(8);
            AppMethodBeat.o(37769);
        }

        public final void updateDrawState(TextPaint textPaint) {
            AppMethodBeat.i(37770);
            textPaint.setColor(ContactRemarkInfoModUI.this.getResources().getColor(R.color.fx));
            textPaint.setUnderlineText(false);
            AppMethodBeat.o(37770);
        }
    }

    static /* synthetic */ void c(ContactRemarkInfoModUI contactRemarkInfoModUI) {
        AppMethodBeat.i(37795);
        Intent intent = new Intent();
        intent.putExtra("label_id_list", contactRemarkInfoModUI.yDk);
        if (contactRemarkInfoModUI.PUZ != null) {
            intent.putStringArrayListExtra("label_str_list", (ArrayList) contactRemarkInfoModUI.PUZ);
        }
        intent.putExtra("label_username", contactRemarkInfoModUI.username);
        com.tencent.mm.br.c.b(contactRemarkInfoModUI, "label", ".ui.ContactLabelUI", intent, 600);
        AppMethodBeat.o(37795);
    }

    static /* synthetic */ void a(ContactRemarkInfoModUI contactRemarkInfoModUI, boolean z) {
        AppMethodBeat.i(37799);
        bg.aVF();
        if (!com.tencent.mm.model.c.isSDCardAvailable()) {
            u.g(contactRemarkInfoModUI, null);
        }
        if (!z) {
            Intent intent = new Intent();
            intent.putExtra("max_select_count", 1);
            intent.putExtra("query_source_type", 0);
            intent.putExtra("send_btn_string", " ");
            intent.addFlags(67108864);
            intent.putExtra("gallery_report_tag", 19);
            com.tencent.mm.br.c.b(contactRemarkInfoModUI, "gallery", ".ui.GalleryEntryUI", intent, 200);
            AppMethodBeat.o(37799);
            return;
        }
        h.a(contactRemarkInfoModUI, "", new String[]{contactRemarkInfoModUI.getString(R.string.giw), contactRemarkInfoModUI.getString(R.string.tf)}, "", new h.d() {
            /* class com.tencent.mm.ui.contact.ContactRemarkInfoModUI.AnonymousClass6 */

            @Override // com.tencent.mm.ui.base.h.d
            public final void oj(int i2) {
                AppMethodBeat.i(37755);
                switch (i2) {
                    case 0:
                        Log.d("MiroMsg.ContactRemarkInfoModUI", "pick up an image");
                        Intent intent = new Intent();
                        intent.putExtra("max_select_count", 1);
                        intent.putExtra("query_source_type", 0);
                        intent.putExtra("send_btn_string", " ");
                        intent.addFlags(67108864);
                        com.tencent.mm.br.c.b(ContactRemarkInfoModUI.this, "gallery", ".ui.GalleryEntryUI", intent, 200);
                        AppMethodBeat.o(37755);
                        return;
                    case 1:
                        Log.d("MiroMsg.ContactRemarkInfoModUI", "delete the remark image when download failed.");
                        ContactRemarkInfoModUI.v(ContactRemarkInfoModUI.this);
                        break;
                }
                AppMethodBeat.o(37755);
            }
        });
        AppMethodBeat.o(37799);
    }

    static /* synthetic */ void p(ContactRemarkInfoModUI contactRemarkInfoModUI) {
        int length;
        String secPrint;
        AppMethodBeat.i(37800);
        contactRemarkInfoModUI.PVh = true;
        com.tencent.mm.ui.tools.b.c.f(contactRemarkInfoModUI.PUF).aoq(32).a(new c.a() {
            /* class com.tencent.mm.ui.contact.ContactRemarkInfoModUI.AnonymousClass3 */

            @Override // com.tencent.mm.ui.tools.b.c.a
            public final void Tw(String str) {
            }

            @Override // com.tencent.mm.ui.tools.b.c.a
            public final void Tx(String str) {
            }

            @Override // com.tencent.mm.ui.tools.b.c.a
            public final void dv(String str) {
                AppMethodBeat.i(163380);
                h.n(ContactRemarkInfoModUI.this, R.string.gr3, R.string.gqy);
                ContactRemarkInfoModUI.this.PVh = false;
                AppMethodBeat.o(163380);
            }
        });
        com.tencent.mm.ui.tools.b.c.f(contactRemarkInfoModUI.PUH).aoq(800).a(new c.a() {
            /* class com.tencent.mm.ui.contact.ContactRemarkInfoModUI.AnonymousClass4 */

            @Override // com.tencent.mm.ui.tools.b.c.a
            public final void Tw(String str) {
            }

            @Override // com.tencent.mm.ui.tools.b.c.a
            public final void Tx(String str) {
            }

            @Override // com.tencent.mm.ui.tools.b.c.a
            public final void dv(String str) {
                AppMethodBeat.i(163381);
                h.n(ContactRemarkInfoModUI.this, R.string.gqq, R.string.gqy);
                ContactRemarkInfoModUI.this.PVh = false;
                AppMethodBeat.o(163381);
            }
        });
        if (contactRemarkInfoModUI.PVh) {
            Log.i("MiroMsg.ContactRemarkInfoModUI", "[dealModRemarkDesc] :%s", contactRemarkInfoModUI.username);
            if (contactRemarkInfoModUI.gUD()) {
                String obj = contactRemarkInfoModUI.PUH.getText().toString();
                contactRemarkInfoModUI.fuR = obj;
                cpo cpo = new cpo();
                cpo.MvG = contactRemarkInfoModUI.username;
                cpo.Desc = obj;
                bg.aVF();
                com.tencent.mm.model.c.aSM().d(new k.a(54, cpo));
            }
            String obj2 = contactRemarkInfoModUI.PUF.getText().toString();
            Log.i("MiroMsg.ContactRemarkInfoModUI", "Set New RemarkName : " + obj2 + ", Report kvStat, addContactScene = " + contactRemarkInfoModUI.kgm);
            com.tencent.mm.plugin.report.service.h.INSTANCE.a(10448, Integer.valueOf(contactRemarkInfoModUI.kgm));
            switch (contactRemarkInfoModUI.contact.getSource()) {
                case 10:
                case 11:
                case 13:
                    com.tencent.mm.plugin.account.friend.a.a SR = com.tencent.mm.plugin.account.a.getAddrUploadStg().SR(contactRemarkInfoModUI.contact.field_username);
                    if (SR != null && !af.isNullOrNil(SR.bnK())) {
                        if (af.isNullOrNil(obj2)) {
                            SR.bnQ();
                        } else {
                            SR.kdU &= -2;
                        }
                        com.tencent.mm.plugin.account.a.getAddrUploadStg().a(SR.getMd5(), SR);
                        break;
                    }
            }
            bg.aVF();
            cn aEZ = com.tencent.mm.model.c.aSO().aEZ(contactRemarkInfoModUI.contact.field_username);
            if ((aEZ == null || af.isNullOrNil(aEZ.field_encryptUsername)) && !af.isNullOrNil(contactRemarkInfoModUI.contact.field_encryptUsername)) {
                bg.aVF();
                aEZ = com.tencent.mm.model.c.aSO().aEZ(contactRemarkInfoModUI.contact.field_encryptUsername);
            }
            if (aEZ != null && !af.isNullOrNil(aEZ.field_encryptUsername)) {
                bg.aVF();
                com.tencent.mm.model.c.aSO().aFa(aEZ.field_encryptUsername);
            }
            if (!contactRemarkInfoModUI.Co(false)) {
                Log.i("MiroMsg.ContactRemarkInfoModUI", "remarkNameChanged", Boolean.valueOf(contactRemarkInfoModUI.Co(false)));
            } else {
                contactRemarkInfoModUI.cgo = obj2;
                Log.i("MiroMsg.ContactRemarkInfoModUI", "usernamne %s operationSetRemark %s", contactRemarkInfoModUI.contact.field_username, obj2);
                ab.c(contactRemarkInfoModUI.contact, obj2);
            }
            contactRemarkInfoModUI.gUC();
            String str = contactRemarkInfoModUI.cgo;
            String str2 = contactRemarkInfoModUI.fuR;
            String str3 = contactRemarkInfoModUI.jid;
            Log.i("MiroMsg.ContactRemarkInfoModUI", "[saveRemarkInfo] :%s :%s", contactRemarkInfoModUI.username, str);
            bg.aVF();
            as Kn = com.tencent.mm.model.c.aSN().Kn(contactRemarkInfoModUI.username);
            if (Kn == null || ((int) Kn.gMZ) <= 0 || !com.tencent.mm.contact.c.oR(Kn.field_type)) {
                Log.e("MiroMsg.ContactRemarkInfoModUI", "[saveRemarkInfo] is error!");
            } else {
                contactRemarkInfoModUI.contact.BD(str);
                contactRemarkInfoModUI.contact.Cc(str2);
                contactRemarkInfoModUI.contact.Cd(str3);
                bg.aVF();
                Log.i("MiroMsg.ContactRemarkInfoModUI", "saveRemarkInfo ret %s", Boolean.valueOf(com.tencent.mm.model.c.aSN().ao(contactRemarkInfoModUI.contact)));
                Object[] objArr = new Object[3];
                objArr[0] = Boolean.valueOf(str2 == null);
                if (str2 == null) {
                    length = 0;
                } else {
                    length = str2.length();
                }
                objArr[1] = Integer.valueOf(length);
                if (str2 == null) {
                    secPrint = "";
                } else {
                    secPrint = Util.secPrint(str2);
                }
                objArr[2] = secPrint;
                Log.i("MiroMsg.ContactRemarkInfoModUI", "remarkDesc (%s, %s, %s)", objArr);
                EventCenter.instance.publish(new yr());
            }
            if (!contactRemarkInfoModUI.gUE()) {
                contactRemarkInfoModUI.finish();
            } else if (contactRemarkInfoModUI.PUV) {
                bg.azz().a(new com.tencent.mm.bd.a(contactRemarkInfoModUI.username), 0);
                contactRemarkInfoModUI.getString(R.string.zb);
                contactRemarkInfoModUI.iLh = h.a((Context) contactRemarkInfoModUI, contactRemarkInfoModUI.getString(R.string.b_z), false, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
                    /* class com.tencent.mm.ui.contact.ContactRemarkInfoModUI.AnonymousClass7 */

                    public final void onCancel(DialogInterface dialogInterface) {
                    }
                });
                AppMethodBeat.o(37800);
                return;
            } else {
                bg.azz().a(new com.tencent.mm.bd.b(contactRemarkInfoModUI.username, contactRemarkInfoModUI.PUQ), 0);
                contactRemarkInfoModUI.getString(R.string.zb);
                contactRemarkInfoModUI.iLh = h.a((Context) contactRemarkInfoModUI, contactRemarkInfoModUI.getString(R.string.ba0), false, (DialogInterface.OnCancelListener) null);
                AppMethodBeat.o(37800);
                return;
            }
        }
        AppMethodBeat.o(37800);
    }
}

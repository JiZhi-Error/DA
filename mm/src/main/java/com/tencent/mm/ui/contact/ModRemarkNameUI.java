package com.tencent.mm.ui.contact;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextPaint;
import android.text.TextWatcher;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.yr;
import com.tencent.mm.model.bg;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.span.m;
import com.tencent.mm.pluginsdk.ui.tools.l;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.cn;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMTagPanel;
import com.tencent.mm.ui.tools.b.c;
import com.tencent.mm.ui.tools.f;
import com.tencent.mm.ui.widget.MMEditText;
import java.util.ArrayList;

public class ModRemarkNameUI extends MMActivity implements i {
    private String BeJ;
    private ArrayList<String> Bea;
    private cn BzG;
    private TextView PUO;
    private View PUP;
    private MMTagPanel PUX;
    private TextView PUY;
    private EditText PXc;
    private int PXd;
    private String PXe = "";
    private TextView PXf = null;
    private EditText PXg = null;
    private TextView PXh = null;
    private String PXi = "";
    private boolean PXj = false;
    private a PXk = new a(this, (byte) 0);
    private View PXl;
    private TextView PXm;
    private as contact;
    private String dWq;
    private int kgm = 9;
    private String remark = "";
    private View uhh;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public ModRemarkNameUI() {
        AppMethodBeat.i(37872);
        AppMethodBeat.o(37872);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(37873);
        super.onCreate(bundle);
        this.kgm = getIntent().getIntExtra("Contact_Scene", 9);
        this.PXd = getIntent().getIntExtra("Contact_mode_name_type", 0);
        this.PXe = Util.nullAsNil(getIntent().getStringExtra("Contact_Nick"));
        this.remark = Util.nullAsNil(getIntent().getStringExtra("Contact_RemarkName"));
        this.PXj = getIntent().getBooleanExtra("Contact_ModStrangerRemark", true);
        initView();
        this.PXm = (TextView) findViewById(R.id.bb1);
        this.PXl = findViewById(R.id.baz);
        if (this.PXd != 0) {
            this.PXl.setVisibility(8);
            this.PXm.setVisibility(8);
        } else {
            this.PXl.setVisibility(0);
            this.PXm.setVisibility(0);
        }
        this.PUX = (MMTagPanel) findViewById(R.id.bb0);
        this.PUX.setPanelClickable(false);
        this.PUY = (TextView) findViewById(R.id.bay);
        this.PUY.setText(R.string.f2p);
        this.PUX.setOnClickListener(this.PXk);
        this.PUY.setOnClickListener(this.PXk);
        if (this.contact != null && as.bjp(this.contact.field_username)) {
            if (this.PXc == null) {
                AppMethodBeat.o(37873);
                return;
            }
            ViewGroup viewGroup = (ViewGroup) this.PXc.getParent();
            int childCount = viewGroup.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = viewGroup.getChildAt(i2);
                int id = childAt.getId();
                if (!(id == R.id.bb5 || id == R.id.bb4)) {
                    childAt.setVisibility(8);
                }
            }
        }
        AppMethodBeat.o(37873);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.bbd;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        boolean z;
        AppMethodBeat.i(37874);
        this.dWq = getIntent().getStringExtra("Contact_User");
        if (this.dWq != null && this.dWq.length() > 0) {
            bg.aVF();
            this.contact = com.tencent.mm.model.c.aSN().Kn(this.dWq);
            bg.aVF();
            this.BzG = com.tencent.mm.model.c.aSO().aEZ(this.dWq);
            if (this.contact == null || Util.isNullOrNil(this.contact.field_username)) {
                this.contact = new as(this.dWq);
                this.contact.setNickname(Util.nullAsNil(this.PXe));
                this.contact.BD(Util.nullAsNil(this.remark));
            }
        }
        this.PXc = (EditText) findViewById(R.id.bb4);
        AnonymousClass1 r0 = new MMEditText.b() {
            /* class com.tencent.mm.ui.contact.ModRemarkNameUI.AnonymousClass1 */

            @Override // com.tencent.mm.ui.widget.MMEditText.b
            public final void boS() {
                AppMethodBeat.i(37864);
                if (ModRemarkNameUI.this.PXc.getText().toString().trim().length() > 0) {
                    ModRemarkNameUI.this.enableOptionMenu(true);
                }
                AppMethodBeat.o(37864);
            }
        };
        l.a aVar = new l.a();
        aVar.KvR = r0;
        this.PXc.addTextChangedListener(aVar);
        com.tencent.mm.ui.tools.b.c.f(this.PXc).aoq(32).a((c.a) null);
        if (!(this.contact == null || this.PXd == 3)) {
            if (this.PXd == 4) {
                this.PXc.setText(com.tencent.mm.pluginsdk.ui.span.l.b(this, Util.nullAsNil(this.PXe), this.PXc.getTextSize()));
            } else if (!Util.isNullOrNil(this.contact.field_conRemark)) {
                if (this.PXd != 0 || Util.isNullOrNil(this.remark)) {
                    this.PXc.setText(com.tencent.mm.pluginsdk.ui.span.l.b(this, Util.nullAsNil(this.contact.field_conRemark), this.PXc.getTextSize()));
                } else {
                    this.PXc.setText(com.tencent.mm.pluginsdk.ui.span.l.b(this, this.remark, this.PXc.getTextSize()));
                }
            } else if (!Util.isNullOrNil(this.remark)) {
                this.PXc.setText(com.tencent.mm.pluginsdk.ui.span.l.b(this, Util.nullAsNil(this.remark), this.PXc.getTextSize()));
            } else if (!Util.isNullOrNil(this.contact.field_nickname)) {
                if (this.PXd != 0 || Util.isNullOrNil(this.PXe) || com.tencent.mm.contact.c.oR(this.contact.field_type)) {
                    this.PXc.setText(com.tencent.mm.pluginsdk.ui.span.l.b(this, Util.nullAsNil(this.contact.field_nickname), this.PXc.getTextSize()));
                } else {
                    this.PXc.setText(com.tencent.mm.pluginsdk.ui.span.l.b(this, Util.nullAsNil(this.PXe), this.PXc.getTextSize()));
                }
            } else if (!Util.isNullOrNil(this.PXe)) {
                this.PXc.setText(com.tencent.mm.pluginsdk.ui.span.l.b(this, Util.nullAsNil(this.PXe), this.PXc.getTextSize()));
            } else {
                String str = this.contact.field_nickname;
                if (Util.isNullOrNil(str) || str.length() > 50) {
                    z = false;
                } else {
                    z = true;
                }
                if (z) {
                    this.PXc.setText(com.tencent.mm.pluginsdk.ui.span.l.b(this, Util.nullAsNil(this.contact.arJ()), this.PXc.getTextSize()));
                } else {
                    this.PXc.setText("");
                }
            }
            this.PXc.setSelection(this.PXc.getText().length());
        }
        if (this.PXd == 0 && !as.avl(this.dWq)) {
            setMMTitle(R.string.bd1);
            com.tencent.mm.plugin.account.friend.a.a SR = com.tencent.mm.plugin.account.a.getAddrUploadStg().SR(this.contact.field_username);
            if (SR != null && !Util.isNullOrNil(SR.bnK()) && !SR.bnK().equals(this.PXc.getText())) {
                this.PUO = (TextView) findViewById(R.id.fit);
                this.PUP = findViewById(R.id.fil);
                this.PUP.setVisibility(0);
                this.PUO.setText(Util.nullAsNil(getString(R.string.bfe, new Object[]{SR.bnK()})));
                m mVar = new m(getString(R.string.j40));
                mVar.setSpan(new c(SR.bnK()), 0, mVar.length(), 17);
                this.PUO.append(" ");
                this.PUO.append(mVar);
                this.PUO.setMovementMethod(LinkMovementMethod.getInstance());
            }
        } else if (this.PXd == 3) {
            setMMTitle(R.string.hk8);
            this.PXc.setHint("");
            if (!Util.isNullOrNil(this.PXe)) {
                this.PXc.setText(this.PXe);
            }
            TextView textView = (TextView) findViewById(R.id.bb5);
            textView.setText(R.string.gl6);
            textView.setVisibility(0);
            findViewById(R.id.fim).setVisibility(8);
        } else if (this.PXd == 4) {
            setMMTitle(R.string.g88);
            this.PXc.setHint("");
            TextView textView2 = (TextView) findViewById(R.id.bb5);
            textView2.setText(R.string.g9l);
            textView2.setVisibility(0);
        } else if (as.avl(this.dWq)) {
            setMMTitle(R.string.hk8);
            findViewById(R.id.e74).setVisibility(8);
        }
        addTextOptionMenu(0, getString(R.string.yl), new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.ui.contact.ModRemarkNameUI.AnonymousClass2 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(37865);
                switch (ModRemarkNameUI.this.PXd) {
                    case 0:
                        ModRemarkNameUI.c(ModRemarkNameUI.this);
                        break;
                    case 3:
                        ModRemarkNameUI.d(ModRemarkNameUI.this);
                        break;
                    case 4:
                        ModRemarkNameUI.e(ModRemarkNameUI.this);
                        break;
                }
                AppMethodBeat.o(37865);
                return true;
            }
        });
        if (this.PXc == null || this.PXc.getText().toString().trim().length() <= 0) {
            enableOptionMenu(false);
        } else {
            enableOptionMenu(true);
        }
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.ui.contact.ModRemarkNameUI.AnonymousClass3 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(37866);
                ModRemarkNameUI.this.finish();
                AppMethodBeat.o(37866);
                return true;
            }
        });
        this.PXf = (TextView) findViewById(R.id.bba);
        this.PXg = (EditText) findViewById(R.id.bb3);
        this.PXh = (TextView) findViewById(R.id.joi);
        this.uhh = findViewById(R.id.bb2);
        com.tencent.mm.ui.tools.b.c.f(this.PXg).aoq(800).a((c.a) null);
        this.PXh.setText(new StringBuilder().append(f.dp(800, this.PXg.getEditableText().toString())).toString());
        this.PXg.append(com.tencent.mm.pluginsdk.ui.span.l.b(this, Util.nullAsNil(this.PXi), this.PXg.getTextSize()));
        this.PXf.append(com.tencent.mm.pluginsdk.ui.span.l.b(this, Util.nullAsNil(this.PXi), this.PXf.getTextSize()));
        if (this.BzG != null) {
            this.PXg.setText(com.tencent.mm.pluginsdk.ui.span.l.b(this, Util.nullAsNil(this.BzG.field_conDescription), this.PXg.getTextSize()));
            this.PXf.setText(com.tencent.mm.pluginsdk.ui.span.l.b(this, Util.nullAsNil(this.BzG.field_conDescription), this.PXg.getTextSize()));
        }
        this.PXg.addTextChangedListener(new b(this, (byte) 0));
        this.PXf.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.ui.contact.ModRemarkNameUI.AnonymousClass4 */

            public final void onClick(View view) {
                AppMethodBeat.i(37867);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/contact/ModRemarkNameUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                ModRemarkNameUI.this.uhh.setVisibility(0);
                ModRemarkNameUI.this.PXf.setVisibility(8);
                ModRemarkNameUI.this.PXg.requestFocus();
                ModRemarkNameUI.this.showVKB();
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/ModRemarkNameUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(37867);
            }
        });
        AppMethodBeat.o(37874);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        AppMethodBeat.i(37875);
        super.onResume();
        bg.aVF();
        this.BzG = com.tencent.mm.model.c.aSO().aEZ(this.dWq);
        if (this.BzG != null) {
            this.BeJ = this.BzG.field_contactLabels;
            this.Bea = (ArrayList) com.tencent.mm.plugin.label.a.a.ecg().aCI(this.BeJ);
        }
        if (!Util.isNullOrNil(this.BeJ)) {
            this.PUX.setVisibility(0);
            this.PUY.setVisibility(8);
            if (this.Bea != null && !this.Bea.isEmpty()) {
                this.PUX.a(this.Bea, this.Bea);
                AppMethodBeat.o(37875);
                return;
            }
        } else {
            this.PUX.setVisibility(8);
            this.PUY.setVisibility(0);
        }
        AppMethodBeat.o(37875);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(37876);
        super.onDestroy();
        AppMethodBeat.o(37876);
    }

    @Override // com.tencent.mm.ak.i
    public void onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(37877);
        Log.i("MiroMsg.ModRemarkName", "onSceneEnd: errType = " + i2 + " errCode = " + i3 + " errMsg = " + str);
        if (qVar.getType() == 44) {
            if (i2 != 0 && i3 < 0) {
                Log.d("MiroMsg.ModRemarkName", "addRoomCard Error!");
                Toast.makeText(this, getString(R.string.g9a, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)}), 0).show();
            }
            finish();
        }
        AppMethodBeat.o(37877);
    }

    /* access modifiers changed from: package-private */
    public class b implements TextWatcher {
        private int CYV;

        private b() {
            this.CYV = 800;
        }

        /* synthetic */ b(ModRemarkNameUI modRemarkNameUI, byte b2) {
            this();
        }

        public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        public final void afterTextChanged(Editable editable) {
            AppMethodBeat.i(37869);
            this.CYV = f.dp(800, editable.toString());
            if (this.CYV < 0) {
                this.CYV = 0;
            }
            if (ModRemarkNameUI.this.PXh != null) {
                ModRemarkNameUI.this.PXh.setText(new StringBuilder().append(this.CYV).toString());
            }
            ModRemarkNameUI.j(ModRemarkNameUI.this);
            AppMethodBeat.o(37869);
        }
    }

    class a implements View.OnClickListener {
        private a() {
        }

        /* synthetic */ a(ModRemarkNameUI modRemarkNameUI, byte b2) {
            this();
        }

        public final void onClick(View view) {
            AppMethodBeat.i(37868);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/contact/ModRemarkNameUI$LabelEditOnClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            ModRemarkNameUI.k(ModRemarkNameUI.this);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/ModRemarkNameUI$LabelEditOnClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(37868);
        }
    }

    /* access modifiers changed from: package-private */
    public class c extends ClickableSpan {
        public String remark;

        public c(String str) {
            this.remark = str;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(37870);
            ModRemarkNameUI.this.PXc.setText(com.tencent.mm.pluginsdk.ui.span.l.b(ModRemarkNameUI.this, Util.nullAsNil(this.remark), ModRemarkNameUI.this.PXc.getTextSize()));
            ModRemarkNameUI.this.PXc.setSelection(ModRemarkNameUI.this.PXc.getText().length());
            ModRemarkNameUI.this.PUP.setVisibility(8);
            AppMethodBeat.o(37870);
        }

        public final void updateDrawState(TextPaint textPaint) {
            AppMethodBeat.i(37871);
            textPaint.setColor(ModRemarkNameUI.this.getResources().getColor(R.color.fx));
            textPaint.setUnderlineText(false);
            AppMethodBeat.o(37871);
        }
    }

    static /* synthetic */ void c(ModRemarkNameUI modRemarkNameUI) {
        AppMethodBeat.i(37878);
        if (!bg.aAc()) {
            Log.e("MiroMsg.ModRemarkName", "!MMCore.hasSetUin()");
            AppMethodBeat.o(37878);
        } else if (modRemarkNameUI.PXc == null) {
            Log.e("MiroMsg.ModRemarkName", "remarkName == null in dealModNickName(), return");
            AppMethodBeat.o(37878);
        } else {
            String trim = modRemarkNameUI.PXc.getText().toString().trim();
            Log.i("MiroMsg.ModRemarkName", "Set New RemarkName : " + trim + ", Report kvStat, addContactScene = " + modRemarkNameUI.kgm);
            h.INSTANCE.a(10448, Integer.valueOf(modRemarkNameUI.kgm));
            if (modRemarkNameUI.PXj) {
                modRemarkNameUI.contact.BD(trim);
                cn cnVar = new cn(modRemarkNameUI.contact.field_username, trim);
                cnVar.field_conDescription = modRemarkNameUI.PXg.getText().toString().trim();
                if (!Util.isNullOrNil(modRemarkNameUI.BeJ)) {
                    cnVar.field_contactLabels = modRemarkNameUI.BeJ;
                }
                bg.aVF();
                com.tencent.mm.model.c.aSO().replace(cnVar);
                if (modRemarkNameUI.contact != null) {
                    bg.aVF();
                    com.tencent.mm.model.c.aSN().c(modRemarkNameUI.contact.field_username, modRemarkNameUI.contact);
                }
            }
            modRemarkNameUI.finish();
            AppMethodBeat.o(37878);
        }
    }

    static /* synthetic */ void d(ModRemarkNameUI modRemarkNameUI) {
        AppMethodBeat.i(37879);
        String trim = modRemarkNameUI.PXc.getText().toString().trim();
        Intent intent = new Intent();
        intent.putExtra("k_sns_tag_name", trim);
        modRemarkNameUI.setResult(-1, intent);
        modRemarkNameUI.finish();
        AppMethodBeat.o(37879);
    }

    static /* synthetic */ void e(ModRemarkNameUI modRemarkNameUI) {
        AppMethodBeat.i(37880);
        String trim = modRemarkNameUI.PXc.getText().toString().trim();
        if (trim.length() > 32) {
            com.tencent.mm.ui.base.h.a(modRemarkNameUI.getContext(), modRemarkNameUI.getString(R.string.g6c), modRemarkNameUI.getString(R.string.g9n), modRemarkNameUI.getString(R.string.sz), (DialogInterface.OnClickListener) null);
            AppMethodBeat.o(37880);
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("Contact_Nick", trim);
        modRemarkNameUI.setResult(-1, intent);
        modRemarkNameUI.finish();
        EventCenter.instance.publish(new yr());
        AppMethodBeat.o(37880);
    }

    static /* synthetic */ void j(ModRemarkNameUI modRemarkNameUI) {
        boolean z;
        boolean z2;
        AppMethodBeat.i(37881);
        String trim = modRemarkNameUI.PXg.getText().toString().trim();
        if ((modRemarkNameUI.PXi == null || !modRemarkNameUI.PXi.equals(trim)) && (!Util.isNullOrNil(modRemarkNameUI.PXi) || !Util.isNullOrNil(trim))) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            String trim2 = modRemarkNameUI.PXc.getText().toString().trim();
            if ((modRemarkNameUI.PXc == null || !modRemarkNameUI.PXc.equals(trim2)) && (!Util.isNullOrNil(modRemarkNameUI.remark) || !Util.isNullOrNil(trim2))) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (!z2) {
                modRemarkNameUI.enableOptionMenu(false);
                AppMethodBeat.o(37881);
                return;
            }
        }
        modRemarkNameUI.enableOptionMenu(true);
        AppMethodBeat.o(37881);
    }

    static /* synthetic */ void k(ModRemarkNameUI modRemarkNameUI) {
        AppMethodBeat.i(37882);
        Intent intent = new Intent();
        if (modRemarkNameUI.Bea != null) {
            intent.putStringArrayListExtra("label_str_list", modRemarkNameUI.Bea);
        }
        intent.putExtra("is_stranger", true);
        intent.putExtra("label_username", modRemarkNameUI.dWq);
        com.tencent.mm.br.c.b(modRemarkNameUI, "label", ".ui.ContactLabelUI", intent);
        AppMethodBeat.o(37882);
    }
}

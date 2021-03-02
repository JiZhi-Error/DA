package com.tencent.mm.plugin.ipcall.ui;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.gms.common.Scopes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.aj.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.ipcall.a.a;
import com.tencent.mm.plugin.ipcall.model.f.e;
import com.tencent.mm.plugin.ipcall.model.h.k;
import com.tencent.mm.plugin.ipcall.model.h.m;
import com.tencent.mm.plugin.ipcall.model.i;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.permission.b;
import com.tencent.mm.pluginsdk.ui.applet.a;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.e;
import java.util.ArrayList;
import java.util.LinkedList;

public class IPCallUserProfileUI extends MMActivity {
    private String ebd;
    private String edf;
    private ImageView gyr;
    private boolean yuw = false;
    private TextView yyZ;
    private TextView yza;
    private LinearLayout yzb;
    private LinearLayout yzc;
    private TextView yzd;
    private TextView yze;
    private TextView yzf;
    private TextView yzg;
    private TextView yzh;
    private Button yzi;
    private String yzj;
    private String yzk;
    private Bitmap yzl;
    private boolean yzm;
    private Cursor yzn = null;
    private boolean yzo = false;
    private e yzp = new e();

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public IPCallUserProfileUI() {
        AppMethodBeat.i(26007);
        AppMethodBeat.o(26007);
    }

    static /* synthetic */ String aCq(String str) {
        AppMethodBeat.i(26021);
        String aCp = aCp(str);
        AppMethodBeat.o(26021);
        return aCp;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getForceOrientation() {
        return 1;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(26008);
        super.onCreate(bundle);
        h.INSTANCE.a(12061, 0, 1, 0, 0, 0, 0);
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.ipcall.ui.IPCallUserProfileUI.AnonymousClass1 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(25994);
                IPCallUserProfileUI.this.finish();
                AppMethodBeat.o(25994);
                return true;
            }
        });
        setMMTitle(R.string.e76);
        this.gyr = (ImageView) findViewById(R.id.x1);
        this.yyZ = (TextView) findViewById(R.id.ifq);
        this.yza = (TextView) findViewById(R.id.jly);
        this.yzb = (LinearLayout) findViewById(R.id.gk5);
        this.yzd = (TextView) findViewById(R.id.gk4);
        this.yzf = (TextView) findViewById(R.id.gk3);
        this.yze = (TextView) findViewById(R.id.gk2);
        this.yzc = (LinearLayout) findViewById(R.id.gk8);
        this.yzg = (TextView) findViewById(R.id.gxn);
        this.yzh = (TextView) findViewById(R.id.dzv);
        this.yzi = (Button) findViewById(R.id.gj4);
        this.edf = getIntent().getStringExtra("IPCallProfileUI_contactid");
        this.yzj = getIntent().getStringExtra("IPCallProfileUI_systemUsername");
        this.yzk = getIntent().getStringExtra("IPCallProfileUI_wechatUsername");
        this.ebd = getIntent().getStringExtra("IPCallProfileUI_phonenumber");
        this.yzo = getIntent().getBooleanExtra("IPCallProfileUI_isNeedShowRecord", false);
        if (!Util.isNullOrNil(this.edf)) {
            this.yzl = a.bd(this, this.edf);
            if (this.yzl != null) {
                this.gyr.setImageBitmap(this.yzl);
            }
        }
        if (this.yzl == null && !Util.isNullOrNil(this.yzk)) {
            this.yzl = c.a(this.yzk, false, -1, null);
            if (this.yzl != null) {
                this.gyr.setImageBitmap(this.yzl);
            }
        }
        if (!Util.isNullOrNil(this.yzj)) {
            this.yyZ.setText(this.yzj);
        } else if (!Util.isNullOrNil(this.ebd)) {
            this.yyZ.setText(a.aCA(this.ebd));
        }
        if (Util.isNullOrNil(this.yzk) || this.yzk.endsWith("@stranger")) {
            this.yza.setVisibility(8);
        } else {
            this.yza.setText(l.c(this, getString(R.string.e77, new Object[]{aa.getDisplayName(this.yzk)})));
        }
        if (!Util.isNullOrNil(this.edf)) {
            if (!b.n(this, "android.permission.READ_CONTACTS")) {
                Log.e("MicroMsg.IPCallUserProfileUI", "no contact permission");
                AppMethodBeat.o(26008);
                return;
            }
            this.yzn = getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, "contact_id=?", new String[]{this.edf}, null);
            this.yuw = this.yzn.getCount() <= 1;
        }
        ebv();
        this.yzf.setVisibility(8);
        this.yze.setVisibility(8);
        this.yzd.setVisibility(8);
        this.yzi.setVisibility(8);
        this.yzh.setVisibility(8);
        if (!Util.isNullOrNil(this.yzk) && !Util.isNullOrNil(this.yzj)) {
            bg.aVF();
            as Kn = com.tencent.mm.model.c.aSN().Kn(this.yzk);
            if (Kn != null && !com.tencent.mm.contact.c.oR(Kn.field_type)) {
                this.yzi.setOnClickListener(new View.OnClickListener() {
                    /* class com.tencent.mm.plugin.ipcall.ui.IPCallUserProfileUI.AnonymousClass8 */

                    public final void onClick(View view) {
                        AppMethodBeat.i(26003);
                        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                        bVar.bm(view);
                        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/ipcall/ui/IPCallUserProfileUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                        h.INSTANCE.a(12766, 3);
                        com.tencent.mm.pluginsdk.ui.applet.a aVar = new com.tencent.mm.pluginsdk.ui.applet.a(IPCallUserProfileUI.this, new a.AbstractC2025a() {
                            /* class com.tencent.mm.plugin.ipcall.ui.IPCallUserProfileUI.AnonymousClass8.AnonymousClass1 */

                            @Override // com.tencent.mm.pluginsdk.ui.applet.a.AbstractC2025a
                            public final void a(boolean z, boolean z2, String str, String str2) {
                                AppMethodBeat.i(26001);
                                Log.d("MicroMsg.IPCallUserProfileUI", "canAddContact, ok: %b, hasSentVerify: %b, respUsername: %s, itemID: %s", Boolean.valueOf(z), Boolean.valueOf(z2), str, str2);
                                if (z) {
                                    IPCallUserProfileUI.this.yzi.setVisibility(8);
                                    IPCallUserProfileUI.this.yzh.setVisibility(8);
                                    IPCallUserProfileUI.b(IPCallUserProfileUI.this, str);
                                }
                                AppMethodBeat.o(26001);
                            }
                        });
                        LinkedList<Integer> linkedList = new LinkedList<>();
                        linkedList.add(86);
                        aVar.Kea = new a.b() {
                            /* class com.tencent.mm.plugin.ipcall.ui.IPCallUserProfileUI.AnonymousClass8.AnonymousClass2 */

                            @Override // com.tencent.mm.pluginsdk.ui.applet.a.b
                            public final boolean aE(String str, int i2) {
                                AppMethodBeat.i(26002);
                                Intent intent = new Intent();
                                intent.putExtra("Contact_User", IPCallUserProfileUI.this.yzk);
                                intent.putExtra("Contact_Scene", 13);
                                intent.putExtra(e.d.OyT, str);
                                int a2 = ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_set_default_chatonly, 2);
                                int a3 = ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_add_friends_without_choose_permission_threshold, 1000);
                                String str2 = ".ui.SayHiWithSnsPermissionUI";
                                if (!as.bjp(IPCallUserProfileUI.this.yzk) && a2 == 1) {
                                    str2 = ".ui.SayHiWithSnsPermissionUI2";
                                } else if (!as.bjp(IPCallUserProfileUI.this.yzk) && a2 == 2 && ab.aVc() >= a3) {
                                    str2 = ".ui.SayHiWithSnsPermissionUI3";
                                }
                                com.tencent.mm.br.c.b(IPCallUserProfileUI.this, Scopes.PROFILE, str2, intent);
                                AppMethodBeat.o(26002);
                                return true;
                            }
                        };
                        aVar.b(IPCallUserProfileUI.this.yzk, linkedList, true);
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/ipcall/ui/IPCallUserProfileUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(26003);
                    }
                });
                this.yzi.setText(R.string.e6z);
                this.yzi.setVisibility(0);
            }
        } else if (!Util.isNullOrNil(this.edf) && !Util.isNullOrNil(this.yzj)) {
            ebu();
            this.yzi.setText(R.string.e74);
        } else if (!Util.isNullOrNil(this.ebd)) {
            this.yze.setVisibility(0);
            this.yzf.setVisibility(0);
            Context context = MMApplicationContext.getContext();
            Intent intent = new Intent("android.intent.action.INSERT");
            intent.setType("vnd.android.cursor.dir/contact");
            intent.putExtra("phone", "10086");
            if (Util.isIntentAvailable(context, intent)) {
                this.yzd.setVisibility(0);
            }
            this.yzd.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.plugin.ipcall.ui.IPCallUserProfileUI.AnonymousClass10 */

                public final void onClick(View view) {
                    AppMethodBeat.i(26005);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/ipcall/ui/IPCallUserProfileUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    try {
                        h.INSTANCE.a(12061, 0, 0, 0, 0, 0, 1);
                        Intent intent = new Intent("android.intent.action.INSERT");
                        intent.setType("vnd.android.cursor.dir/contact");
                        intent.putExtra("phone", IPCallUserProfileUI.this.ebd);
                        IPCallUserProfileUI iPCallUserProfileUI = IPCallUserProfileUI.this;
                        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                        com.tencent.mm.hellhoundlib.a.a.a(iPCallUserProfileUI, bl.axQ(), "com/tencent/mm/plugin/ipcall/ui/IPCallUserProfileUI$8", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                        iPCallUserProfileUI.startActivity((Intent) bl.pG(0));
                        com.tencent.mm.hellhoundlib.a.a.a(iPCallUserProfileUI, "com/tencent/mm/plugin/ipcall/ui/IPCallUserProfileUI$8", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    } catch (Exception e2) {
                        Log.e("MicroMsg.IPCallUserProfileUI", e2.getMessage());
                    }
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/ipcall/ui/IPCallUserProfileUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(26005);
                }
            });
            this.yze.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.plugin.ipcall.ui.IPCallUserProfileUI.AnonymousClass11 */

                public final void onClick(View view) {
                    AppMethodBeat.i(26006);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/ipcall/ui/IPCallUserProfileUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    IPCallUserProfileUI.a(IPCallUserProfileUI.this, IPCallUserProfileUI.this.ebd);
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/ipcall/ui/IPCallUserProfileUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(26006);
                }
            });
            this.yzf.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.plugin.ipcall.ui.IPCallUserProfileUI.AnonymousClass2 */

                public final void onClick(View view) {
                    AppMethodBeat.i(25995);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/ipcall/ui/IPCallUserProfileUI$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    h.INSTANCE.a(12766, 4);
                    com.tencent.mm.plugin.ipcall.a.c.aCE(IPCallUserProfileUI.this.ebd);
                    Toast.makeText(IPCallUserProfileUI.this, (int) R.string.e6y, 0).show();
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/ipcall/ui/IPCallUserProfileUI$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(25995);
                }
            });
            ebu();
            this.yzi.setText(R.string.e74);
        }
        ebt();
        AppMethodBeat.o(26008);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.awq;
    }

    private void ebt() {
        int i2 = 0;
        AppMethodBeat.i(26009);
        ArrayList arrayList = new ArrayList();
        if (this.yzn == null || this.yzn.getCount() <= 0) {
            this.yzb.setVisibility(8);
            AppMethodBeat.o(26009);
            return;
        }
        try {
            if (this.yzn.moveToFirst()) {
                while (!this.yzn.isAfterLast()) {
                    i2++;
                    String string = this.yzn.getString(this.yzn.getColumnIndex("data1"));
                    int i3 = this.yzn.getInt(this.yzn.getColumnIndex("data2"));
                    if (!arrayList.contains(string)) {
                        arrayList.add(string);
                        if (i2 == this.yzn.getCount()) {
                            q(string, i3, false);
                        } else {
                            q(string, i3, true);
                        }
                    }
                    this.yzn.moveToNext();
                }
            }
        } catch (Exception e2) {
            Log.e("MicroMsg.IPCallUserProfileUI", "initPhoneNumberList error: %s", e2.getMessage());
        } finally {
            this.yzn.close();
            AppMethodBeat.o(26009);
        }
    }

    private void q(final String str, int i2, boolean z) {
        AppMethodBeat.i(26010);
        View inflate = LayoutInflater.from(this).inflate(R.layout.bjn, (ViewGroup) this.yzb, false);
        LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.ect);
        if (!z) {
            linearLayout.setBackgroundDrawable(null);
        } else {
            linearLayout.setBackgroundDrawable(getResources().getDrawable(R.drawable.b9w));
        }
        final TextView textView = (TextView) inflate.findViewById(R.id.gb2);
        textView.setText(com.tencent.mm.plugin.ipcall.a.a.aCA(com.tencent.mm.plugin.ipcall.a.c.trimPhoneNumber(str)));
        ((TextView) inflate.findViewById(R.id.gb3)).setText(com.tencent.mm.plugin.ipcall.a.a.Pq(i2));
        inflate.setClickable(true);
        inflate.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.ipcall.ui.IPCallUserProfileUI.AnonymousClass4 */

            public final void onClick(View view) {
                AppMethodBeat.i(25997);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/ipcall/ui/IPCallUserProfileUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                IPCallUserProfileUI.a(IPCallUserProfileUI.this, str);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/ipcall/ui/IPCallUserProfileUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(25997);
            }
        });
        inflate.setOnLongClickListener(new View.OnLongClickListener() {
            /* class com.tencent.mm.plugin.ipcall.ui.IPCallUserProfileUI.AnonymousClass5 */

            public final boolean onLongClick(View view) {
                AppMethodBeat.i(25998);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/ipcall/ui/IPCallUserProfileUI$3", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, bVar.axR());
                IPCallUserProfileUI.a(IPCallUserProfileUI.this, textView);
                com.tencent.mm.hellhoundlib.a.a.a(true, (Object) this, "com/tencent/mm/plugin/ipcall/ui/IPCallUserProfileUI$3", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
                AppMethodBeat.o(25998);
                return true;
            }
        });
        this.yzb.addView(inflate);
        AppMethodBeat.o(26010);
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x00a0  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String aCp(java.lang.String r10) {
        /*
        // Method dump skipped, instructions count: 193
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.ipcall.ui.IPCallUserProfileUI.aCp(java.lang.String):java.lang.String");
    }

    private void ebu() {
        AppMethodBeat.i(26012);
        this.yzi.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.ipcall.ui.IPCallUserProfileUI.AnonymousClass9 */

            public final void onClick(View view) {
                AppMethodBeat.i(26004);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/ipcall/ui/IPCallUserProfileUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                IPCallUserProfileUI.this.yzp.start();
                IPCallUserProfileUI.this.yzp.yrX = 1;
                IPCallUserProfileUI.this.yzp.yrY = 5;
                IPCallUserProfileUI.this.yzp.finish();
                h.INSTANCE.a(12766, 3);
                if (!Util.isNullOrNil(IPCallUserProfileUI.this.edf)) {
                    Intent intent = new Intent("android.intent.action.SENDTO", Uri.parse("smsto:" + IPCallUserProfileUI.aCq(IPCallUserProfileUI.this.edf)));
                    intent.putExtra("sms_body", IPCallUserProfileUI.this.getString(R.string.e6n, new Object[]{z.aUL().arI()}));
                    IPCallUserProfileUI iPCallUserProfileUI = IPCallUserProfileUI.this;
                    com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                    com.tencent.mm.hellhoundlib.a.a.a(iPCallUserProfileUI, bl.axQ(), "com/tencent/mm/plugin/ipcall/ui/IPCallUserProfileUI$7", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    iPCallUserProfileUI.startActivity((Intent) bl.pG(0));
                    com.tencent.mm.hellhoundlib.a.a.a(iPCallUserProfileUI, "com/tencent/mm/plugin/ipcall/ui/IPCallUserProfileUI$7", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                } else if (!Util.isNullOrNil(IPCallUserProfileUI.this.ebd)) {
                    Intent intent2 = new Intent("android.intent.action.SENDTO", Uri.parse("smsto:" + IPCallUserProfileUI.this.ebd));
                    intent2.putExtra("sms_body", IPCallUserProfileUI.this.getString(R.string.e6n, new Object[]{z.aUL().arI()}));
                    IPCallUserProfileUI iPCallUserProfileUI2 = IPCallUserProfileUI.this;
                    com.tencent.mm.hellhoundlib.b.a bl2 = new com.tencent.mm.hellhoundlib.b.a().bl(intent2);
                    com.tencent.mm.hellhoundlib.a.a.a(iPCallUserProfileUI2, bl2.axQ(), "com/tencent/mm/plugin/ipcall/ui/IPCallUserProfileUI$7", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    iPCallUserProfileUI2.startActivity((Intent) bl2.pG(0));
                    com.tencent.mm.hellhoundlib.a.a.a(iPCallUserProfileUI2, "com/tencent/mm/plugin/ipcall/ui/IPCallUserProfileUI$7", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/ipcall/ui/IPCallUserProfileUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(26004);
            }
        });
        AppMethodBeat.o(26012);
    }

    private void ebv() {
        Cursor aBZ;
        boolean z;
        AppMethodBeat.i(26013);
        if (!this.yzo) {
            this.yzc.setVisibility(8);
            this.yzg.setVisibility(8);
        }
        if (!Util.isNullOrNil(this.edf)) {
            aBZ = m.aCb(this.edf);
        } else {
            aBZ = i.eaz().aBZ(this.ebd);
        }
        if (aBZ == null || aBZ.getCount() <= 0) {
            this.yzc.setVisibility(8);
            this.yzg.setVisibility(8);
            AppMethodBeat.o(26013);
            return;
        }
        try {
            if (aBZ.moveToFirst()) {
                int i2 = 0;
                while (!aBZ.isAfterLast()) {
                    k kVar = new k();
                    kVar.convertFrom(aBZ);
                    i2++;
                    if (i2 >= 3) {
                        z = true;
                    } else {
                        z = false;
                    }
                    a(kVar, z, aBZ.getCount());
                    if (z) {
                        break;
                    }
                    aBZ.moveToNext();
                }
                if (i2 <= 0) {
                    this.yzc.setVisibility(8);
                } else if (aBZ.getCount() >= 4) {
                    ebw();
                }
            }
        } catch (Exception e2) {
            Log.e("MicroMsg.IPCallUserProfileUI", "initRecordList, error: %s", e2.getMessage());
        } finally {
            aBZ.close();
            AppMethodBeat.o(26013);
        }
    }

    private void a(k kVar, boolean z, int i2) {
        AppMethodBeat.i(26014);
        View inflate = LayoutInflater.from(this).inflate(R.layout.bjp, (ViewGroup) this.yzc, false);
        TextView textView = (TextView) inflate.findViewById(R.id.gk7);
        TextView textView2 = (TextView) inflate.findViewById(R.id.gk_);
        ((TextView) inflate.findViewById(R.id.gk9)).setText(com.tencent.mm.plugin.ipcall.a.a.aCA(kVar.field_phonenumber));
        if (kVar.field_duration > 0) {
            textView2.setText(com.tencent.mm.plugin.ipcall.a.c.GY(kVar.field_duration));
        } else {
            textView2.setText(com.tencent.mm.plugin.ipcall.a.c.Pr(kVar.field_status));
        }
        textView.setText(com.tencent.mm.plugin.ipcall.a.c.GU(kVar.field_calltime));
        if (z) {
            inflate.setBackgroundDrawable(getResources().getDrawable(R.drawable.ap5));
            int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.agc);
            inflate.setPadding(dimensionPixelSize, 0, dimensionPixelSize, 0);
        }
        if (1 == i2) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) inflate.getLayoutParams();
            layoutParams.height = com.tencent.mm.cb.a.aG(getContext(), R.dimen.afm);
            inflate.setLayoutParams(layoutParams);
        }
        this.yzc.addView(inflate);
        AppMethodBeat.o(26014);
    }

    private void ebw() {
        AppMethodBeat.i(26015);
        View inflate = LayoutInflater.from(this).inflate(R.layout.bjq, (ViewGroup) this.yzc, false);
        this.yzc.addView(inflate);
        inflate.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.ipcall.ui.IPCallUserProfileUI.AnonymousClass3 */

            public final void onClick(View view) {
                AppMethodBeat.i(25996);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/ipcall/ui/IPCallUserProfileUI$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                Intent intent = new Intent(IPCallUserProfileUI.this, IPCallAllRecordUI.class);
                if (!Util.isNullOrNil(IPCallUserProfileUI.this.edf)) {
                    intent.putExtra("IPCallAllRecordUI_contactId", IPCallUserProfileUI.this.edf);
                } else if (!Util.isNullOrNil(IPCallUserProfileUI.this.ebd)) {
                    intent.putExtra("IPCallAllRecordUI_phoneNumber", IPCallUserProfileUI.this.ebd);
                }
                intent.putExtra("IPCallAllRecordUI_isSinglePhoneNumber", IPCallUserProfileUI.this.yuw);
                IPCallUserProfileUI iPCallUserProfileUI = IPCallUserProfileUI.this;
                com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                com.tencent.mm.hellhoundlib.a.a.a(iPCallUserProfileUI, bl.axQ(), "com/tencent/mm/plugin/ipcall/ui/IPCallUserProfileUI$11", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                iPCallUserProfileUI.startActivity((Intent) bl.pG(0));
                com.tencent.mm.hellhoundlib.a.a.a(iPCallUserProfileUI, "com/tencent/mm/plugin/ipcall/ui/IPCallUserProfileUI$11", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/ipcall/ui/IPCallUserProfileUI$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(25996);
            }
        });
        AppMethodBeat.o(26015);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        AppMethodBeat.i(26016);
        super.onResume();
        if (this.yzm) {
            this.yzm = false;
            this.yzc.removeAllViews();
            ebv();
        }
        AppMethodBeat.o(26016);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(26017);
        super.onActivityResult(i2, i3, intent);
        AppMethodBeat.o(26017);
    }

    static /* synthetic */ void a(IPCallUserProfileUI iPCallUserProfileUI, String str) {
        AppMethodBeat.i(26018);
        if (com.tencent.mm.plugin.ipcall.a.c.gq(iPCallUserProfileUI)) {
            Intent intent = new Intent(iPCallUserProfileUI, IPCallDialUI.class);
            if (iPCallUserProfileUI.yzo) {
                intent.putExtra("IPCallTalkUI_dialScene", 4);
                h.INSTANCE.a(12059, 0, 0, 0, 0, 4);
            } else {
                intent.putExtra("IPCallTalkUI_dialScene", 2);
                h.INSTANCE.a(12059, 0, 0, 0, 0, 2);
            }
            intent.putExtra("IPCallTalkUI_contactId", iPCallUserProfileUI.edf);
            intent.putExtra("IPCallTalkUI_nickname", iPCallUserProfileUI.yzj);
            intent.putExtra("IPCallTalkUI_phoneNumber", com.tencent.mm.plugin.ipcall.a.c.trimPhoneNumber(str));
            intent.putExtra("IPCallTalkUI_toWechatUsername", iPCallUserProfileUI.yzk);
            iPCallUserProfileUI.startActivityForResult(intent, 1001);
            iPCallUserProfileUI.yzm = true;
        }
        AppMethodBeat.o(26018);
    }

    static /* synthetic */ void a(IPCallUserProfileUI iPCallUserProfileUI, final TextView textView) {
        AppMethodBeat.i(26019);
        com.tencent.mm.ui.tools.l lVar = new com.tencent.mm.ui.tools.l(iPCallUserProfileUI);
        lVar.HLX = new o.f() {
            /* class com.tencent.mm.plugin.ipcall.ui.IPCallUserProfileUI.AnonymousClass6 */

            @Override // com.tencent.mm.ui.base.o.f
            public final void onCreateMMMenu(com.tencent.mm.ui.base.m mVar) {
                AppMethodBeat.i(25999);
                mVar.add(R.string.t_);
                AppMethodBeat.o(25999);
            }
        };
        lVar.HLY = new o.g() {
            /* class com.tencent.mm.plugin.ipcall.ui.IPCallUserProfileUI.AnonymousClass7 */

            @Override // com.tencent.mm.ui.base.o.g
            public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
                AppMethodBeat.i(26000);
                if (i2 == 0) {
                    h.INSTANCE.a(12766, 4);
                    com.tencent.mm.plugin.ipcall.a.c.aCE(textView.getText().toString());
                    Toast.makeText(IPCallUserProfileUI.this, (int) R.string.e6y, 0).show();
                }
                AppMethodBeat.o(26000);
            }
        };
        lVar.gXI();
        AppMethodBeat.o(26019);
    }

    static /* synthetic */ void b(IPCallUserProfileUI iPCallUserProfileUI, String str) {
        AppMethodBeat.i(26020);
        if (!Util.isNullOrNil(iPCallUserProfileUI.edf) && !Util.isNullOrNil(str) && !str.endsWith("@stranger")) {
            com.tencent.mm.plugin.ipcall.model.h.c aBV = i.eay().aBV(iPCallUserProfileUI.edf);
            if (aBV.systemRowid > 0) {
                aBV.field_wechatUsername = str;
                i.eay().update(aBV.systemRowid, aBV);
            }
        }
        AppMethodBeat.o(26020);
    }
}

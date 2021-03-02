package com.tencent.mm.plugin.subapp.ui.pluginapp;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.br.c;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.z;
import com.tencent.mm.modelmulti.e;
import com.tencent.mm.n.h;
import com.tencent.mm.pluginsdk.ui.applet.o;
import com.tencent.mm.pluginsdk.ui.applet.y;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.o.a;

public class InviteFriendsBy3rdUI extends MMPreference implements i, a.AbstractC2123a, a.b {
    private static int FNf = 1;
    private static int FNg = 2;
    private static int FNh = 3;
    private static int FNi = 4;
    private static int FNj = 5;
    private static int FNk = 0;
    private static int FNl = 1;
    private a EPv = new a();
    private int FNm = 0;
    private Bitmap FNn = null;
    private View FNo;
    private ImageView FNp = null;
    private EditText FNq = null;
    private boolean FNr = false;
    private boolean FNs = false;
    private int fromScene;
    private ProgressDialog gtM = null;
    private ProgressBar mEz = null;
    private ProgressDialog vIA = null;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.ui.base.preference.MMPreference
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public InviteFriendsBy3rdUI() {
        AppMethodBeat.i(29235);
        AppMethodBeat.o(29235);
    }

    @Override // com.tencent.mm.ui.base.preference.MMPreference
    public int getResourceId() {
        return R.xml.bc;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.ui.base.preference.MMPreference
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(29236);
        super.onCreate(bundle);
        setMMTitle(R.string.ceq);
        this.fromScene = getIntent().getIntExtra("Invite_friends", 4);
        int i2 = Util.getInt(h.aqJ().getValue("InviteFriendsInviteFlags"), 0);
        f preferenceScreen = getPreferenceScreen();
        if ((i2 & 2) <= 0) {
            preferenceScreen.bmi("invite_friends_by_message");
        }
        if ((i2 & 1) <= 0) {
            preferenceScreen.bmi("invite_friends_by_mail");
        }
        if (WeChatBrands.Business.Entries.Global3rdSrv.banned() || (i2 & 4) <= 0 || !checkApkExist(getContext(), "com.whatsapp")) {
            preferenceScreen.bmi("invite_friends_by_whatsapp");
        }
        if (WeChatBrands.Business.Entries.Global3rdSrv.banned() || (i2 & 8) <= 0 || !z.aUC()) {
            preferenceScreen.bmi("invite_friends_by_facebook");
        }
        if (WeChatBrands.Business.Entries.Global3rdSrv.banned() || (i2 & 16) <= 0) {
            preferenceScreen.bmi("invite_friends_by_twitter");
        }
        preferenceScreen.notifyDataSetChanged();
        bg.azz().a(1803, this);
        bg.azz().a(1804, this);
        bg.azz().a(168, this);
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.subapp.ui.pluginapp.InviteFriendsBy3rdUI.AnonymousClass1 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(29228);
                InviteFriendsBy3rdUI.this.finish();
                AppMethodBeat.o(29228);
                return true;
            }
        });
        AppMethodBeat.o(29236);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(29237);
        bg.azz().b(1803, this);
        bg.azz().b(1804, this);
        bg.azz().b(168, this);
        if (this.FNm == 0) {
            com.tencent.mm.plugin.report.service.h.INSTANCE.a(14035, Integer.valueOf(this.FNm), Integer.valueOf(FNk), Integer.valueOf(this.fromScene));
        }
        super.onDestroy();
        AppMethodBeat.o(29237);
    }

    @Override // com.tencent.mm.ui.base.preference.MMPreference
    public boolean onPreferenceTreeClick(f fVar, Preference preference) {
        AppMethodBeat.i(29238);
        if ("invite_friends_by_message".equals(preference.mKey)) {
            this.FNm = FNg;
            abo(2);
            AppMethodBeat.o(29238);
            return true;
        } else if ("invite_friends_by_mail".equals(preference.mKey)) {
            this.FNm = FNf;
            abo(1);
            AppMethodBeat.o(29238);
            return true;
        } else if ("invite_friends_by_whatsapp".equals(preference.mKey)) {
            this.FNm = FNh;
            abo(4);
            AppMethodBeat.o(29238);
            return true;
        } else if ("invite_friends_by_facebook".equals(preference.mKey)) {
            this.FNm = FNi;
            if (z.aUF()) {
                this.FNs = true;
                abo(8);
            } else {
                com.tencent.mm.ui.base.h.a(getContext(), (int) R.string.gon, (int) R.string.zb, new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.plugin.subapp.ui.pluginapp.InviteFriendsBy3rdUI.AnonymousClass4 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        AppMethodBeat.i(29231);
                        c.b(InviteFriendsBy3rdUI.this.getContext(), "account", ".ui.FacebookAuthUI", new Intent());
                        AppMethodBeat.o(29231);
                    }
                }, new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.plugin.subapp.ui.pluginapp.InviteFriendsBy3rdUI.AnonymousClass5 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                    }
                });
            }
            AppMethodBeat.o(29238);
            return true;
        } else if ("invite_friends_by_twitter".equals(preference.mKey)) {
            this.FNm = FNj;
            if (this.EPv.gYx()) {
                this.FNr = true;
                abo(16);
            } else {
                com.tencent.mm.ui.base.h.a(getContext(), (int) R.string.gvt, (int) R.string.zb, new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.plugin.subapp.ui.pluginapp.InviteFriendsBy3rdUI.AnonymousClass6 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        AppMethodBeat.i(29232);
                        InviteFriendsBy3rdUI inviteFriendsBy3rdUI = InviteFriendsBy3rdUI.this;
                        AppCompatActivity context = InviteFriendsBy3rdUI.this.getContext();
                        InviteFriendsBy3rdUI.this.getContext().getString(R.string.zb);
                        inviteFriendsBy3rdUI.vIA = com.tencent.mm.ui.base.h.a((Context) context, InviteFriendsBy3rdUI.this.getContext().getString(R.string.hrq), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
                            /* class com.tencent.mm.plugin.subapp.ui.pluginapp.InviteFriendsBy3rdUI.AnonymousClass6.AnonymousClass1 */

                            public final void onCancel(DialogInterface dialogInterface) {
                            }
                        });
                        InviteFriendsBy3rdUI.this.EPv.a(InviteFriendsBy3rdUI.this, InviteFriendsBy3rdUI.this.getContext());
                        AppMethodBeat.o(29232);
                    }
                }, new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.plugin.subapp.ui.pluginapp.InviteFriendsBy3rdUI.AnonymousClass7 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                    }
                });
            }
            AppMethodBeat.o(29238);
            return true;
        } else {
            AppMethodBeat.o(29238);
            return false;
        }
    }

    @Override // com.tencent.mm.ak.i
    public void onSceneEnd(int i2, int i3, String str, q qVar) {
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        AppMethodBeat.i(29239);
        Log.i("MicroMsg.InviteFriendsBy3rdUI", "onSceneEnd: errType = " + i2 + " errCode = " + i3 + " errMsg = " + str);
        if (this.gtM != null) {
            this.gtM.dismiss();
            this.gtM = null;
        }
        if (!(i2 == 0 && i3 == 0)) {
            com.tencent.mm.plugin.report.service.h.INSTANCE.a(14035, Integer.valueOf(this.FNm), Integer.valueOf(FNk), Integer.valueOf(this.fromScene));
        }
        if (qVar.getType() == 1803) {
            if (i2 == 0 && i3 == 0) {
                e eVar = (e) qVar;
                if (Util.isNullOrNil(eVar.title)) {
                    str2 = null;
                } else {
                    str2 = eVar.title;
                }
                e eVar2 = (e) qVar;
                if (Util.isNullOrNil(eVar2.content)) {
                    str3 = null;
                } else {
                    str3 = eVar2.content;
                }
                String aTZ = z.aTZ();
                bg.aVF();
                String str9 = (String) com.tencent.mm.model.c.azQ().get(6, (Object) null);
                if (Util.isNullOrNil(aTZ)) {
                    str4 = str9;
                } else {
                    str4 = aTZ;
                }
                int i4 = ((e) qVar).jcv;
                if ((i4 & 1) > 0) {
                    if (Util.isNullOrNil(str2)) {
                        str2 = String.format(getString(R.string.e4c), z.aUa());
                    }
                    if (Util.isNullOrNil(str3)) {
                        str8 = String.format(getString(R.string.e4b), str4);
                    } else {
                        str8 = str3;
                    }
                    Intent intent = new Intent("android.intent.action.SEND");
                    intent.putExtra("android.intent.extra.SUBJECT", str2);
                    intent.putExtra("android.intent.extra.TEXT", str8);
                    intent.setType("plain/text");
                    com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(Intent.createChooser(intent, getString(R.string.e46)));
                    com.tencent.mm.hellhoundlib.a.a.a(this, bl.axQ(), "com/tencent/mm/plugin/subapp/ui/pluginapp/InviteFriendsBy3rdUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    startActivity((Intent) bl.pG(0));
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/subapp/ui/pluginapp/InviteFriendsBy3rdUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    com.tencent.mm.plugin.report.service.h.INSTANCE.a(14035, Integer.valueOf(this.FNm), Integer.valueOf(FNl), Integer.valueOf(this.fromScene));
                    str5 = str8;
                } else {
                    str5 = str3;
                }
                if ((i4 & 2) > 0) {
                    if (Util.isNullOrNil(str5)) {
                        str7 = String.format(getString(R.string.e4d), str4);
                    } else {
                        str7 = str5;
                    }
                    Intent intent2 = new Intent("android.intent.action.VIEW");
                    intent2.putExtra("sms_body", str7);
                    intent2.setType("vnd.android-dir/mms-sms");
                    if (Util.isIntentAvailable(this, intent2)) {
                        com.tencent.mm.hellhoundlib.b.a bl2 = new com.tencent.mm.hellhoundlib.b.a().bl(intent2);
                        com.tencent.mm.hellhoundlib.a.a.a(this, bl2.axQ(), "com/tencent/mm/plugin/subapp/ui/pluginapp/InviteFriendsBy3rdUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                        startActivity((Intent) bl2.pG(0));
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/subapp/ui/pluginapp/InviteFriendsBy3rdUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    } else {
                        Toast.makeText(this, (int) R.string.giz, 1).show();
                    }
                    com.tencent.mm.plugin.report.service.h.INSTANCE.a(14035, Integer.valueOf(this.FNm), Integer.valueOf(FNl), Integer.valueOf(this.fromScene));
                    str5 = str7;
                }
                if ((i4 & 4) > 0) {
                    if (Util.isNullOrNil(str5)) {
                        str6 = String.format(getString(R.string.e4d), str4);
                    } else {
                        str6 = str5;
                    }
                    Intent intent3 = new Intent();
                    intent3.setAction("android.intent.action.SEND");
                    intent3.putExtra("android.intent.extra.TEXT", str6);
                    intent3.setType("text/plain");
                    intent3.setPackage("com.whatsapp");
                    com.tencent.mm.hellhoundlib.b.a bl3 = new com.tencent.mm.hellhoundlib.b.a().bl(intent3);
                    com.tencent.mm.hellhoundlib.a.a.a(this, bl3.axQ(), "com/tencent/mm/plugin/subapp/ui/pluginapp/InviteFriendsBy3rdUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    startActivity((Intent) bl3.pG(0));
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/subapp/ui/pluginapp/InviteFriendsBy3rdUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    com.tencent.mm.plugin.report.service.h.INSTANCE.a(14035, Integer.valueOf(this.FNm), Integer.valueOf(FNl), Integer.valueOf(this.fromScene));
                    str5 = str6;
                }
                if ((i4 & 8) > 0) {
                    if (Util.isNullOrNil(str5)) {
                        if (Util.isNullOrNil(z.aTZ())) {
                            str5 = getString(R.string.e4a);
                        } else {
                            str5 = String.format(getString(R.string.e4_), z.aTZ());
                        }
                    }
                    String string = getString(R.string.e43);
                    if (this.FNs) {
                        E(i4, str5, string);
                        this.FNs = false;
                    }
                }
                if ((i4 & 16) > 0) {
                    this.EPv.a(this);
                    if (Util.isNullOrNil(str5)) {
                        if (Util.isNullOrNil(z.aTZ())) {
                            str5 = getString(R.string.e4a);
                        } else {
                            str5 = String.format(getString(R.string.e4_), z.aTZ());
                        }
                    }
                    String string2 = getString(R.string.e48);
                    if (this.FNr) {
                        E(i4, str5, string2);
                        this.FNr = false;
                    }
                }
            } else {
                com.tencent.mm.ui.base.h.n(getContext(), R.string.eka, R.string.zb);
                AppMethodBeat.o(29239);
                return;
            }
        }
        if (qVar.getType() == 1804) {
            if (i2 == 0 && i3 == 0) {
                com.tencent.mm.ui.base.h.cD(this, getResources().getString(R.string.b99));
                com.tencent.mm.plugin.report.service.h.INSTANCE.a(14035, Integer.valueOf(this.FNm), Integer.valueOf(FNl), Integer.valueOf(this.fromScene));
            } else {
                com.tencent.mm.ui.base.h.n(getContext(), R.string.gkm, R.string.zb);
                AppMethodBeat.o(29239);
                return;
            }
        }
        if (qVar.getType() == 168) {
            if (i2 != 0 || i3 != 0) {
                AppMethodBeat.o(29239);
                return;
            } else if (this.FNp != null) {
                if (this.mEz != null) {
                    this.mEz.setVisibility(8);
                }
                this.FNp.setImageBitmap(ebs());
            }
        }
        AppMethodBeat.o(29239);
    }

    private void abo(int i2) {
        AppMethodBeat.i(29240);
        final e eVar = new e(i2);
        getString(R.string.zb);
        this.gtM = com.tencent.mm.ui.base.h.a((Context) this, getString(R.string.ekc), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
            /* class com.tencent.mm.plugin.subapp.ui.pluginapp.InviteFriendsBy3rdUI.AnonymousClass8 */

            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.i(29233);
                bg.azz().a(eVar);
                AppMethodBeat.o(29233);
            }
        });
        bg.azz().a(eVar, 0);
        AppMethodBeat.o(29240);
    }

    private static boolean checkApkExist(Context context, String str) {
        AppMethodBeat.i(29241);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(29241);
            return false;
        }
        try {
            context.getPackageManager().getApplicationInfo(str, 8192);
            AppMethodBeat.o(29241);
            return true;
        } catch (PackageManager.NameNotFoundException e2) {
            AppMethodBeat.o(29241);
            return false;
        }
    }

    private void Po(int i2) {
        AppMethodBeat.i(29242);
        com.tencent.mm.ui.base.h.a(getContext(), i2, (int) R.string.zb, new DialogInterface.OnClickListener() {
            /* class com.tencent.mm.plugin.subapp.ui.pluginapp.InviteFriendsBy3rdUI.AnonymousClass10 */

            public final void onClick(DialogInterface dialogInterface, int i2) {
            }
        }, new DialogInterface.OnClickListener() {
            /* class com.tencent.mm.plugin.subapp.ui.pluginapp.InviteFriendsBy3rdUI.AnonymousClass11 */

            public final void onClick(DialogInterface dialogInterface, int i2) {
            }
        });
        AppMethodBeat.o(29242);
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.ui.o.a.b
    public final void a(a.c cVar) {
        AppMethodBeat.i(29243);
        if (this.vIA != null) {
            this.vIA.cancel();
        }
        switch (cVar) {
            case Finished:
                Po(R.string.hrs);
                AppMethodBeat.o(29243);
                return;
            case Canceled:
                AppMethodBeat.o(29243);
                return;
            case QAR:
                Po(R.string.hrr);
                break;
        }
        AppMethodBeat.o(29243);
    }

    @Override // com.tencent.mm.ui.o.a.AbstractC2123a
    public final void b(a.c cVar) {
    }

    private void E(final int i2, final String str, String str2) {
        AppMethodBeat.i(29244);
        this.FNo = View.inflate(getContext(), R.layout.vz, null);
        this.FNq = (EditText) this.FNo.findViewById(R.id.b_h);
        this.FNp = (ImageView) this.FNo.findViewById(R.id.b_e);
        this.mEz = (ProgressBar) this.FNo.findViewById(R.id.epo);
        ((View) this.FNp.getParent()).setVisibility(8);
        this.FNq.setText(str);
        this.FNn = ebs();
        if (this.FNn == null) {
            aSR(z.aTY());
            ((ProgressBar) this.FNo.findViewById(R.id.epo)).setVisibility(0);
        } else if (this.FNp != null) {
            this.FNp.setImageBitmap(this.FNn);
        }
        o.a(this.mController, str2, this.FNo, getResources().getString(R.string.yq), new y.b() {
            /* class com.tencent.mm.plugin.subapp.ui.pluginapp.InviteFriendsBy3rdUI.AnonymousClass2 */

            @Override // com.tencent.mm.pluginsdk.ui.applet.y.b
            public final void qB(boolean z) {
                AppMethodBeat.i(29229);
                if (z) {
                    InviteFriendsBy3rdUI.a(InviteFriendsBy3rdUI.this, i2, InviteFriendsBy3rdUI.this.FNq == null ? str : InviteFriendsBy3rdUI.this.FNq.getText().toString());
                    AppMethodBeat.o(29229);
                    return;
                }
                AppMethodBeat.o(29229);
            }
        });
        AppMethodBeat.o(29244);
    }

    private static Bitmap ebs() {
        AppMethodBeat.i(29245);
        byte[] aCo = aCo(z.aTY());
        if (aCo == null) {
            AppMethodBeat.o(29245);
            return null;
        }
        Bitmap decodeByteArray = BitmapUtil.decodeByteArray(aCo);
        AppMethodBeat.o(29245);
        return decodeByteArray;
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x004f A[SYNTHETIC, Splitter:B:15:0x004f] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x005b A[SYNTHETIC, Splitter:B:21:0x005b] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static byte[] aCo(java.lang.String r8) {
        /*
        // Method dump skipped, instructions count: 108
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.subapp.ui.pluginapp.InviteFriendsBy3rdUI.aCo(java.lang.String):byte[]");
    }

    private static void aSR(String str) {
        AppMethodBeat.i(29247);
        bg.aVF();
        bg.azz().a(new com.tencent.mm.bc.a(str, Util.nullAsNil((Integer) com.tencent.mm.model.c.azQ().get(66561, (Object) null))), 0);
        AppMethodBeat.o(29247);
    }

    static /* synthetic */ void a(InviteFriendsBy3rdUI inviteFriendsBy3rdUI, int i2, String str) {
        AppMethodBeat.i(29248);
        final com.tencent.mm.modelmulti.h hVar = new com.tencent.mm.modelmulti.h(i2, str);
        inviteFriendsBy3rdUI.getString(R.string.zb);
        inviteFriendsBy3rdUI.gtM = com.tencent.mm.ui.base.h.a((Context) inviteFriendsBy3rdUI, inviteFriendsBy3rdUI.getString(R.string.ys), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
            /* class com.tencent.mm.plugin.subapp.ui.pluginapp.InviteFriendsBy3rdUI.AnonymousClass9 */

            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.i(29234);
                bg.azz().a(hVar);
                AppMethodBeat.o(29234);
            }
        });
        bg.azz().a(hVar, 0);
        AppMethodBeat.o(29248);
    }
}

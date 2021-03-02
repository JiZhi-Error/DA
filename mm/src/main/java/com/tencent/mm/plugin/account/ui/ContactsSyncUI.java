package com.tencent.mm.plugin.account.ui;

import android.accounts.AccountAuthenticatorResponse;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.constraint.ConstraintLayout;
import android.widget.Toast;
import com.jg.EType;
import com.jg.JgClassChecked;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.plugin.account.bind.ui.BindMContactIntroUI;
import com.tencent.mm.plugin.account.friend.a.l;
import com.tencent.mm.plugin.account.model.b;
import com.tencent.mm.pluginsdk.permission.b;
import com.tencent.mm.sdk.platformtools.IntentUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.h;

@JgClassChecked(author = 20, fComment = "checked", lastDate = "20140422", reviewer = 20, vComment = {EType.ACTIVITYCHECK})
public final class ContactsSyncUI extends MMActivity {
    private AccountAuthenticatorResponse kki = null;
    Bundle kkj = null;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onCreate(Bundle bundle) {
        AppMethodBeat.i(127902);
        super.onCreate(bundle);
        setMMTitle("");
        int intExtra = IntentUtil.getIntExtra(getIntent(), "wizard_activity_result_code", 0);
        Log.i("MicroMsg.ContactsSyncUI", "onCreate() resultCode[%d]", Integer.valueOf(intExtra));
        switch (intExtra) {
            case -1:
            case 0:
                boolean a2 = b.a(this, "android.permission.READ_CONTACTS", 48, (String) null, (String) null);
                Log.i("MicroMsg.ContactsSyncUI", "summerper checkPermission checkContacts read[%b],stack[%s]", Boolean.valueOf(a2), Util.getStack());
                if (!a2) {
                    AppMethodBeat.o(127902);
                    return;
                }
                boolean a3 = b.a(this, "android.permission.WRITE_CONTACTS", 48, (String) null, (String) null);
                Log.i("MicroMsg.ContactsSyncUI", "summerper checkPermission checkContacts write[%b],stack[%s]", Boolean.valueOf(a3), Util.getStack());
                if (!a3) {
                    AppMethodBeat.o(127902);
                    return;
                }
                initView();
                AppMethodBeat.o(127902);
                return;
            case 1:
                finish();
                AppMethodBeat.o(127902);
                return;
            default:
                Log.e("MicroMsg.ContactsSyncUI", "onCreate, should not reach here, resultCode = ".concat(String.valueOf(intExtra)));
                finish();
                AppMethodBeat.o(127902);
                return;
        }
    }

    @Override // com.tencent.mm.ui.MMActivity
    public final int getLayoutId() {
        return -1;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public final void initView() {
        b.a aVar;
        boolean z = true;
        AppMethodBeat.i(127903);
        g.aAf();
        if (!com.tencent.mm.kernel.a.azo() || com.tencent.mm.kernel.a.azj()) {
            MMWizardActivity.b(this, new Intent(this, SimpleLoginUI.class), getIntent());
            finish();
            AppMethodBeat.o(127903);
        } else if (getIntent() == null) {
            Log.e("MicroMsg.ContactsSyncUI", "initView fail, intent is null");
            finish();
            AppMethodBeat.o(127903);
        } else {
            int intExtra = IntentUtil.getIntExtra(getIntent(), "contact_sync_scene", -1);
            if (getIntent().getAction() == null || !getIntent().getAction().equalsIgnoreCase("com.tencent.mm.login.ACTION_LOGIN")) {
                String resolveType = getIntent().resolveType(this);
                Log.i("MicroMsg.ContactsSyncUI", "scheme = " + resolveType + ", action = " + getIntent().getAction());
                if (!Util.isNullOrNil(resolveType)) {
                    if (resolveType.equals("vnd.android.cursor.item/vnd.com.tencent.mm.chatting.profile")) {
                        intExtra = 2;
                    } else if (resolveType.equals("vnd.android.cursor.item/vnd.com.tencent.mm.chatting.voip")) {
                        intExtra = 12;
                    } else if (resolveType.equals("vnd.android.cursor.item/vnd.com.tencent.mm.chatting.voip.video")) {
                        intExtra = 13;
                    } else if (resolveType.equals("vnd.android.cursor.item/vnd.com.tencent.mm.plugin.sns.timeline")) {
                        intExtra = 3;
                    } else {
                        intExtra = resolveType.equals("vnd.android.cursor.item/vnd.com.tencent.mm.chatting.phonenum") ? 6 : -1;
                    }
                }
            } else {
                intExtra = 4;
            }
            if (intExtra == -1) {
                Log.e("MicroMsg.ContactsSyncUI", "unkown scene, finish");
                finish();
                AppMethodBeat.o(127903);
                return;
            }
            switch (intExtra) {
                case 1:
                    Parcelable parcelableExtra = getIntent().getParcelableExtra("accountAuthenticatorResponse");
                    this.kki = null;
                    if (parcelableExtra != null && (parcelableExtra instanceof AccountAuthenticatorResponse)) {
                        this.kki = (AccountAuthenticatorResponse) parcelableExtra;
                    }
                    if (this.kki != null) {
                        this.kki.onRequestContinued();
                    }
                    if (IntentUtil.getBooleanExtra(getIntent(), "k_login_without_bind_mobile", false)) {
                        z = false;
                    }
                    aVar = new a(z);
                    break;
                case 2:
                case 6:
                    aVar = new b.C0522b(1, IntentUtil.getStringExtra(getIntent(), "k_phone_num"), getIntent().getData());
                    break;
                case 3:
                    aVar = new b.C0522b(2, IntentUtil.getStringExtra(getIntent(), "k_phone_num"), getIntent().getData());
                    break;
                case 4:
                    Parcelable parcelableExtra2 = getIntent().getParcelableExtra("accountAuthenticatorResponse");
                    this.kki = null;
                    if (parcelableExtra2 != null && (parcelableExtra2 instanceof AccountAuthenticatorResponse)) {
                        this.kki = (AccountAuthenticatorResponse) parcelableExtra2;
                    }
                    if (this.kki != null) {
                        this.kki.onRequestContinued();
                    }
                    if (!getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0).getBoolean("upload_contacts_already_displayed", false)) {
                        aVar = new a(!IntentUtil.getBooleanExtra(getIntent(), "k_login_without_bind_mobile", false));
                        break;
                    }
                case 5:
                case 7:
                case 8:
                case 9:
                case 10:
                case 11:
                default:
                    aVar = null;
                    break;
                case 12:
                    aVar = new b.C0522b(3, IntentUtil.getStringExtra(getIntent(), "k_phone_num"), getIntent().getData());
                    break;
                case 13:
                    aVar = new b.C0522b(4, IntentUtil.getStringExtra(getIntent(), "k_phone_num"), getIntent().getData());
                    break;
            }
            if (aVar != null) {
                switch (aVar.dC(this)) {
                    case 2:
                        Intent intent = getIntent();
                        intent.setClass(this, ContactsSyncUI.class);
                        Intent intent2 = new Intent();
                        intent2.setClass(this, BindMContactIntroUI.class);
                        intent2.putExtra("key_upload_scene", 2);
                        intent2.putExtra("bind_scene", 2);
                        MMWizardActivity.b(this, intent2, intent);
                        finish();
                        break;
                    case 3:
                        Intent intent3 = getIntent();
                        intent3.setClass(this, ContactsSyncUI.class);
                        Intent intent4 = new Intent();
                        intent4.setClass(this, SimpleLoginUI.class);
                        MMWizardActivity.b(this, intent4, intent3);
                        finish();
                        break;
                    case 4:
                        Intent intent5 = getIntent();
                        intent5.setClass(this, ContactsSyncUI.class);
                        Intent intent6 = new Intent();
                        intent6.setClass(this, SimpleLoginUI.class);
                        intent6.putExtra("accountAuthenticatorResponse", this.kki);
                        MMWizardActivity.b(this, intent6, intent5);
                        finish();
                        break;
                    case 5:
                        AppMethodBeat.o(127903);
                        return;
                }
            } else {
                Log.e("MicroMsg.ContactsSyncUI", "unkown scene, finish");
            }
            finish();
            AppMethodBeat.o(127903);
        }
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public final void finish() {
        AppMethodBeat.i(127904);
        if (this.kki != null) {
            if (this.kkj != null) {
                this.kki.onResult(this.kkj);
            } else {
                this.kki.onError(4, "canceled");
            }
            this.kki = null;
        }
        super.finish();
        AppMethodBeat.o(127904);
    }

    /* access modifiers changed from: package-private */
    public final class a implements b.a {
        private boolean kkm;
        private t.a kkn = new t.a() {
            /* class com.tencent.mm.plugin.account.ui.ContactsSyncUI.a.AnonymousClass1 */

            @Override // com.tencent.mm.platformtools.t.a
            public final void D(Bundle bundle) {
                AppMethodBeat.i(127896);
                ContactsSyncUI contactsSyncUI = ContactsSyncUI.this;
                contactsSyncUI.kkj = bundle;
                contactsSyncUI.finish();
                AppMethodBeat.o(127896);
            }
        };

        public a(boolean z) {
            AppMethodBeat.i(127899);
            this.kkm = z;
            AppMethodBeat.o(127899);
        }

        @Override // com.tencent.mm.plugin.account.model.b.a
        public final int dC(final Context context) {
            AppMethodBeat.i(127900);
            g.aAf();
            if (!com.tencent.mm.kernel.a.azo() || com.tencent.mm.kernel.a.azj()) {
                AppMethodBeat.o(127900);
                return 4;
            } else if (!this.kkm) {
                Log.i("MicroMsg.ProcessorAddAccount", "no need to bind mobile");
                t.a(ContactsSyncUI.this, this.kkn);
                AppMethodBeat.o(127900);
                return 0;
            } else {
                final String str = (String) g.aAh().azQ().get(6, "");
                if (Util.isNullOrNil(str)) {
                    Log.e("MicroMsg.ProcessorAddAccount", "not bind mobile phone");
                    AppMethodBeat.o(127900);
                    return 2;
                } else if (l.bnY()) {
                    h.a(context, (int) R.string.bii, (int) R.string.zb, (int) R.string.x_, (int) R.string.sz, new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.plugin.account.ui.ContactsSyncUI.a.AnonymousClass2 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            AppMethodBeat.i(127897);
                            l.gl(true);
                            ContactsSyncUI.this.getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0).edit().putBoolean("upload_contacts_already_displayed", true).commit();
                            a.this.W(context, str);
                            if (context instanceof Activity) {
                                ((Activity) context).finish();
                            }
                            AppMethodBeat.o(127897);
                        }
                    }, new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.plugin.account.ui.ContactsSyncUI.a.AnonymousClass3 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            AppMethodBeat.i(127898);
                            l.gl(false);
                            ContactsSyncUI.this.getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0).edit().putBoolean("upload_contacts_already_displayed", true).commit();
                            if (context instanceof Activity) {
                                ((Activity) context).finish();
                            }
                            AppMethodBeat.o(127898);
                        }
                    });
                    AppMethodBeat.o(127900);
                    return 5;
                } else {
                    int W = W(context, str);
                    AppMethodBeat.o(127900);
                    return W;
                }
            }
        }

        /* access modifiers changed from: package-private */
        public final int W(Context context, String str) {
            AppMethodBeat.i(127901);
            if (context == null) {
                AppMethodBeat.o(127901);
                return 1;
            }
            int a2 = t.a(context, str, this.kkn);
            if (a2 == 2) {
                Toast.makeText(context, ContactsSyncUI.this.getString(R.string.bik), 1).show();
                AppMethodBeat.o(127901);
                return 1;
            } else if (a2 == 3) {
                Toast.makeText(context, ContactsSyncUI.this.getString(R.string.bij), 1).show();
                AppMethodBeat.o(127901);
                return 1;
            } else {
                AppMethodBeat.o(127901);
                return 0;
            }
        }
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.a.AbstractC0015a
    public final void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        AppMethodBeat.i(127905);
        if (iArr == null || iArr.length <= 0) {
            Log.i("MicroMsg.ContactsSyncUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", Integer.valueOf(i2), Long.valueOf(Thread.currentThread().getId()));
            AppMethodBeat.o(127905);
            return;
        }
        Log.i("MicroMsg.ContactsSyncUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", Integer.valueOf(i2), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId()));
        switch (i2) {
            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE:
                if (iArr[0] != 0) {
                    h.a((Context) this, getString(R.string.fl2), getString(R.string.flp), getString(R.string.e_k), getString(R.string.sz), false, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.plugin.account.ui.ContactsSyncUI.AnonymousClass2 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            AppMethodBeat.i(127894);
                            dialogInterface.dismiss();
                            ContactsSyncUI contactsSyncUI = ContactsSyncUI.this;
                            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                            com.tencent.mm.hellhoundlib.a.a.a(contactsSyncUI, bl.axQ(), "com/tencent/mm/plugin/account/ui/ContactsSyncUI$2", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                            contactsSyncUI.startActivity((Intent) bl.pG(0));
                            com.tencent.mm.hellhoundlib.a.a.a(contactsSyncUI, "com/tencent/mm/plugin/account/ui/ContactsSyncUI$2", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                            AppMethodBeat.o(127894);
                        }
                    }, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.plugin.account.ui.ContactsSyncUI.AnonymousClass3 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            AppMethodBeat.i(127895);
                            dialogInterface.dismiss();
                            ContactsSyncUI.this.finish();
                            AppMethodBeat.o(127895);
                        }
                    });
                    break;
                } else {
                    final String str = strArr[0];
                    new MMHandler().post(new Runnable() {
                        /* class com.tencent.mm.plugin.account.ui.ContactsSyncUI.AnonymousClass1 */

                        public final void run() {
                            AppMethodBeat.i(127892);
                            boolean a2 = com.tencent.mm.pluginsdk.permission.b.a(ContactsSyncUI.this, str.equals("android.permission.READ_CONTACTS") ? "android.permission.WRITE_CONTACTS" : "android.permission.READ_CONTACTS", 48, (String) null, (String) null);
                            Log.i("MicroMsg.ContactsSyncUI", "summerper checkPermission checkContacts [%b], oldPermission[%s], stack[%s]", Boolean.valueOf(a2), str, Util.getStack());
                            if (a2) {
                                ContactsSyncUI.this.initView();
                            }
                            AppMethodBeat.o(127892);
                        }

                        public final String toString() {
                            AppMethodBeat.i(127893);
                            String str = super.toString() + "|checkContacts";
                            AppMethodBeat.o(127893);
                            return str;
                        }
                    });
                    AppMethodBeat.o(127905);
                    return;
                }
        }
        AppMethodBeat.o(127905);
    }
}

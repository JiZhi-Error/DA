package com.tencent.mm.ui.contact;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.a.zj;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.permission.b;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.contact.a.a;
import com.tencent.mm.ui.contact.c;
import com.tencent.qqmusic.mediaplayer.PlayerException;
import java.util.ArrayList;
import java.util.List;

public class VoipAddressUI extends MMBaseSelectContactUI {
    private boolean GZt = false;
    private boolean PZW = false;
    private IListener PZX = new IListener<zj>() {
        /* class com.tencent.mm.ui.contact.VoipAddressUI.AnonymousClass1 */

        {
            AppMethodBeat.i(161551);
            this.__eventId = zj.class.getName().hashCode();
            AppMethodBeat.o(161551);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(zj zjVar) {
            AppMethodBeat.i(38089);
            switch (zjVar.efx.dKy) {
                case 7:
                    VoipAddressUI.this.finish();
                    break;
                case 8:
                    VoipAddressUI.this.finish();
                    break;
            }
            AppMethodBeat.o(38089);
            return false;
        }
    };
    private List<String> gzY;
    private String talker = "";

    @Override // com.tencent.mm.ui.contact.MMBaseSelectContactUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public VoipAddressUI() {
        AppMethodBeat.i(38093);
        AppMethodBeat.o(38093);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.contact.MMBaseSelectContactUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(38094);
        super.onCreate(bundle);
        EventCenter.instance.addListener(this.PZX);
        AppMethodBeat.o(38094);
    }

    @Override // com.tencent.mm.ui.contact.MMBaseSelectContactUI
    public final void M(View view, int i2) {
        AppMethodBeat.i(234094);
        a aVar = (a) getContentLV().getAdapter().getItem(i2);
        if (aVar == null) {
            AppMethodBeat.o(234094);
        } else if (aVar.contact == null) {
            AppMethodBeat.o(234094);
        } else {
            this.talker = aVar.contact.field_username;
            if (this.GZt) {
                eEL();
                AppMethodBeat.o(234094);
                return;
            }
            eEK();
            AppMethodBeat.o(234094);
        }
    }

    private void eEK() {
        AppMethodBeat.i(38096);
        boolean a2 = b.a(this, "android.permission.RECORD_AUDIO", 82, "", "");
        Log.i("MicroMsg.VoipAddressUI", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", Boolean.valueOf(a2), Util.getStack(), this);
        if (!a2) {
            AppMethodBeat.o(38096);
            return;
        }
        zj zjVar = new zj();
        zjVar.efx.dKy = 5;
        zjVar.efx.talker = this.talker;
        zjVar.efx.context = this;
        int i2 = this.PZW ? 2 : 1;
        zjVar.efx.eft = 3;
        h.INSTANCE.a(11033, Integer.valueOf(i2), 2, 0);
        EventCenter.instance.publish(zjVar);
        hideVKB();
        AppMethodBeat.o(38096);
    }

    private void eEL() {
        AppMethodBeat.i(38097);
        boolean a2 = b.a(this, "android.permission.CAMERA", 19, "", "");
        Log.i("MicroMsg.VoipAddressUI", "summerper checkPermission checkCamera[%b], stack[%s], activity[%s]", Boolean.valueOf(a2), Util.getStack(), this);
        if (!a2) {
            AppMethodBeat.o(38097);
            return;
        }
        boolean a3 = b.a(this, "android.permission.RECORD_AUDIO", 19, "", "");
        Log.i("MicroMsg.VoipAddressUI", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", Boolean.valueOf(a3), Util.getStack(), this);
        if (!a3) {
            AppMethodBeat.o(38097);
            return;
        }
        zj zjVar = new zj();
        zjVar.efx.dKy = 5;
        zjVar.efx.talker = this.talker;
        zjVar.efx.context = this;
        int i2 = this.PZW ? 2 : 1;
        zjVar.efx.eft = 2;
        h.INSTANCE.a(11033, Integer.valueOf(i2), 1, 0);
        EventCenter.instance.publish(zjVar);
        hideVKB();
        AppMethodBeat.o(38097);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.ui.contact.MMBaseSelectContactUI
    public final void amZ() {
        AppMethodBeat.i(38098);
        super.amZ();
        String stringExtra = getIntent().getStringExtra("LauncherUI.Shortcut.LaunchType");
        this.GZt = getIntent().getBooleanExtra("voip_video", true);
        if (stringExtra != null) {
            this.PZW = true;
            if (stringExtra.equals("launch_type_voip")) {
                this.GZt = true;
            } else if (stringExtra.equals("launch_type_voip_audio")) {
                this.GZt = false;
            }
        }
        this.gzY = new ArrayList();
        this.gzY.addAll(u.gVb());
        this.gzY.addAll(u.gVc());
        AppMethodBeat.o(38098);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.ui.contact.MMBaseSelectContactUI
    public final q bmC() {
        AppMethodBeat.i(38099);
        c.a aVar = new c.a();
        aVar.PTM = true;
        aVar.PTL = true;
        c cVar = new c(this, this.gzY, false, aVar, (byte) 0);
        AppMethodBeat.o(38099);
        return cVar;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.ui.contact.MMBaseSelectContactUI
    public final o bmD() {
        AppMethodBeat.i(38100);
        s sVar = new s(this, this.gzY, false, this.scene);
        AppMethodBeat.o(38100);
        return sVar;
    }

    public static void kp(Context context) {
        int i2 = 0;
        AppMethodBeat.i(38101);
        boolean z = 1 == Util.getInt(com.tencent.mm.n.h.aqJ().getValue("VOIPCallType"), 0);
        Intent intent = new Intent(context, VoipAddressUI.class);
        intent.putExtra("Add_address_titile", context.getString(R.string.g4));
        intent.putExtra("voip_video", z);
        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
        com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/ui/contact/VoipAddressUI", "inviteVoip", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        context.startActivity((Intent) bl.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/ui/contact/VoipAddressUI", "inviteVoip", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        h hVar = h.INSTANCE;
        Object[] objArr = new Object[2];
        objArr[0] = 1;
        if (!z) {
            i2 = 1;
        }
        objArr[1] = Integer.valueOf(i2);
        hVar.a(11034, objArr);
        AppMethodBeat.o(38101);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.ui.contact.MMBaseSelectContactUI
    public final boolean bmA() {
        return true;
    }

    @Override // com.tencent.mm.ui.contact.MMBaseSelectContactUI
    public final int[] egI() {
        return new int[]{131072};
    }

    @Override // com.tencent.mm.ui.contact.MMBaseSelectContactUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(38102);
        EventCenter.instance.removeListener(this.PZX);
        super.onDestroy();
        AppMethodBeat.o(38102);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.ui.contact.MMBaseSelectContactUI
    public final void egJ() {
        AppMethodBeat.i(38103);
        if (this.PZW) {
            Intent intent = new Intent(this, LauncherUI.class);
            intent.addFlags(67108864);
            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
            com.tencent.mm.hellhoundlib.a.a.a(this, bl.axQ(), "com/tencent/mm/ui/contact/VoipAddressUI", "onBackBtnPress", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            startActivity((Intent) bl.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/VoipAddressUI", "onBackBtnPress", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        }
        hideVKB();
        finish();
        AppMethodBeat.o(38103);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.ui.contact.MMBaseSelectContactUI
    public final String bmB() {
        AppMethodBeat.i(38104);
        String stringExtra = getIntent().getStringExtra("Add_address_titile");
        if (!Util.isNullOrNil(stringExtra)) {
            stringExtra = getString(R.string.g4);
        }
        AppMethodBeat.o(38104);
        return stringExtra;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.ui.contact.MMBaseSelectContactUI
    public final boolean bmz() {
        return false;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.a.AbstractC0015a
    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        AppMethodBeat.i(38105);
        if (iArr == null || iArr.length <= 0) {
            Log.i("MicroMsg.VoipAddressUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", Integer.valueOf(i2), Long.valueOf(Thread.currentThread().getId()));
            AppMethodBeat.o(38105);
            return;
        }
        Log.i("MicroMsg.VoipAddressUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", Integer.valueOf(i2), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId()));
        switch (i2) {
            case 19:
                if (iArr[0] == 0) {
                    eEL();
                    AppMethodBeat.o(38105);
                    return;
                }
                int i3 = "android.permission.CAMERA".equals(strArr[0]) ? R.string.fl0 : R.string.flb;
                if (iArr[0] != 0) {
                    com.tencent.mm.ui.base.h.a((Context) this, getString(i3), getString(R.string.flp), getString(R.string.e_k), getString(R.string.amn), false, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.ui.contact.VoipAddressUI.AnonymousClass2 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            AppMethodBeat.i(38090);
                            dialogInterface.dismiss();
                            VoipAddressUI voipAddressUI = VoipAddressUI.this;
                            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                            com.tencent.mm.hellhoundlib.a.a.a(voipAddressUI, bl.axQ(), "com/tencent/mm/ui/contact/VoipAddressUI$2", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                            voipAddressUI.startActivity((Intent) bl.pG(0));
                            com.tencent.mm.hellhoundlib.a.a.a(voipAddressUI, "com/tencent/mm/ui/contact/VoipAddressUI$2", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                            AppMethodBeat.o(38090);
                        }
                    }, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.ui.contact.VoipAddressUI.AnonymousClass3 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            AppMethodBeat.i(38091);
                            dialogInterface.dismiss();
                            AppMethodBeat.o(38091);
                        }
                    });
                }
                AppMethodBeat.o(38105);
                return;
            case PlayerException.EXCEPTION_TYPE_ERROR_CREATE_JAVA_DATASOURCE /*{ENCODED_INT: 82}*/:
                if (iArr[0] != 0) {
                    com.tencent.mm.ui.base.h.a((Context) this, getString(R.string.fl_), getString(R.string.flp), getString(R.string.e_k), getString(R.string.amn), false, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.ui.contact.VoipAddressUI.AnonymousClass4 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            AppMethodBeat.i(38092);
                            VoipAddressUI voipAddressUI = VoipAddressUI.this;
                            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                            com.tencent.mm.hellhoundlib.a.a.a(voipAddressUI, bl.axQ(), "com/tencent/mm/ui/contact/VoipAddressUI$4", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                            voipAddressUI.startActivity((Intent) bl.pG(0));
                            com.tencent.mm.hellhoundlib.a.a.a(voipAddressUI, "com/tencent/mm/ui/contact/VoipAddressUI$4", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                            AppMethodBeat.o(38092);
                        }
                    }, (DialogInterface.OnClickListener) null);
                    break;
                } else {
                    eEK();
                    AppMethodBeat.o(38105);
                    return;
                }
        }
        AppMethodBeat.o(38105);
    }
}

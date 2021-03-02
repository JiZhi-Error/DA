package com.tencent.mm.pluginsdk.permission;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.br.c;
import com.tencent.mm.compatible.e.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMBaseActivity;
import com.tencent.mm.ui.base.aa;
import com.tencent.mm.ui.widget.a.d;

public class RequestFloatWindowPermissionDialog extends MMBaseActivity {
    public static int JXZ = 1234;
    private static a JYa;
    private d jzT = null;

    public interface a {
        void onResultAllow(RequestFloatWindowPermissionDialog requestFloatWindowPermissionDialog);

        void onResultCancel(RequestFloatWindowPermissionDialog requestFloatWindowPermissionDialog);

        void onResultRefuse(RequestFloatWindowPermissionDialog requestFloatWindowPermissionDialog);
    }

    @Override // com.tencent.mm.ui.MMBaseActivity, com.tencent.mm.hellhoundlib.activities.HellActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(151879);
        super.onCreate(bundle);
        requestWindowFeature(1);
        cjQ();
        AppMethodBeat.o(151879);
    }

    @Override // com.tencent.mm.ui.MMBaseActivity, com.tencent.mm.hellhoundlib.activities.HellActivity
    public void onResume() {
        AppMethodBeat.i(151880);
        super.onResume();
        aa.activateBroadcast(true);
        AppMethodBeat.o(151880);
    }

    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity
    public void onNewIntent(Intent intent) {
        AppMethodBeat.i(151881);
        super.onNewIntent(intent);
        setIntent(intent);
        if (this.jzT != null) {
            this.jzT.dismiss();
            this.jzT = null;
        }
        cjQ();
        AppMethodBeat.o(151881);
    }

    @Override // com.tencent.mm.ui.MMBaseActivity, com.tencent.mm.hellhoundlib.activities.HellActivity
    public void onPause() {
        AppMethodBeat.i(151882);
        super.onPause();
        aa.activateBroadcast(false);
        AppMethodBeat.o(151882);
    }

    private void cjQ() {
        AppMethodBeat.i(151883);
        if (getIntent() == null) {
            Log.e("MicroMsg.RequestFloatWindowPermissionDialog", "Intent is null");
            AppMethodBeat.o(151883);
            return;
        }
        Bundle extras = getIntent().getExtras();
        if (extras == null) {
            Log.e("MicroMsg.RequestFloatWindowPermissionDialog", "invalid params");
            AppMethodBeat.o(151883);
            return;
        }
        d.a aVar = new d.a(this);
        aVar.aoO(R.string.dde);
        aVar.boo(extras.getString("warning_content"));
        aVar.f(new DialogInterface.OnCancelListener() {
            /* class com.tencent.mm.pluginsdk.permission.RequestFloatWindowPermissionDialog.AnonymousClass1 */

            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.i(151877);
                if (RequestFloatWindowPermissionDialog.JYa != null) {
                    RequestFloatWindowPermissionDialog.JYa.onResultCancel(RequestFloatWindowPermissionDialog.this);
                    a unused = RequestFloatWindowPermissionDialog.JYa = null;
                }
                RequestFloatWindowPermissionDialog.this.finish();
                AppMethodBeat.o(151877);
            }
        });
        aVar.aoV(com.tencent.mm.compatible.util.d.oD(23) ? R.string.ddd : R.string.ddc).c(new DialogInterface.OnClickListener() {
            /* class com.tencent.mm.pluginsdk.permission.RequestFloatWindowPermissionDialog.AnonymousClass2 */

            public final void onClick(DialogInterface dialogInterface, int i2) {
                AppMethodBeat.i(151878);
                if (com.tencent.mm.compatible.util.d.oD(23)) {
                    try {
                        if (!Util.isNullOrNil((String) Settings.class.getField("ACTION_MANAGE_OVERLAY_PERMISSION").get(Settings.class))) {
                            RequestFloatWindowPermissionDialog.this.startActivityForResult(new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION", Uri.parse("package:" + MMApplicationContext.getPackageName())), RequestFloatWindowPermissionDialog.JXZ);
                            AppMethodBeat.o(151878);
                            return;
                        }
                    } catch (Exception e2) {
                        Log.e("MicroMsg.RequestFloatWindowPermissionDialog", "getField:ACTION_MANAGE_OVERLAY_PERMISSION! Error:%s, etype:%s", e2.getMessage(), e2.getClass().getCanonicalName());
                    }
                }
                String string = RequestFloatWindowPermissionDialog.this.getString(R.string.ddf);
                Intent intent = new Intent();
                intent.putExtra("rawUrl", string);
                intent.putExtra("useJs", true);
                intent.putExtra("vertical_scroll", true);
                c.b(RequestFloatWindowPermissionDialog.this, "webview", ".ui.tools.WebViewUI", intent);
                RequestFloatWindowPermissionDialog.this.finish();
                AppMethodBeat.o(151878);
            }
        });
        this.jzT = aVar.hbn();
        this.jzT.setCanceledOnTouchOutside(false);
        this.jzT.show();
        AppMethodBeat.o(151883);
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(151884);
        if (JYa == null) {
            finish();
            AppMethodBeat.o(151884);
            return;
        }
        if (i2 != JXZ) {
            JYa.onResultRefuse(this);
        } else if (b.cx(MMApplicationContext.getContext())) {
            JYa.onResultAllow(this);
        } else {
            JYa.onResultRefuse(this);
        }
        JYa = null;
        finish();
        AppMethodBeat.o(151884);
    }

    public static void a(Context context, String str, a aVar, String str2) {
        AppMethodBeat.i(151885);
        a(context, str, aVar, true, str2);
        AppMethodBeat.o(151885);
    }

    public static void a(Context context, String str, a aVar, boolean z, String str2) {
        AppMethodBeat.i(151886);
        JYa = aVar;
        Intent intent = new Intent(context, RequestFloatWindowPermissionDialog.class);
        intent.putExtra("warning_content", str);
        if (z) {
            intent.addFlags(805306368);
        }
        com.tencent.mm.util.a.a(context, intent, str, RequestFloatWindowPermissionDialog.class.getCanonicalName(), str2);
        AppMethodBeat.o(151886);
    }
}

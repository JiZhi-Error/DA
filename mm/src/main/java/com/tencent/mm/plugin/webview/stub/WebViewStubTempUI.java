package com.tencent.mm.plugin.webview.stub;

import android.app.Dialog;
import android.app.Service;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.ResultReceiver;
import android.support.v4.app.a;
import android.support.v4.content.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.plugin.webview.ui.tools.e;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.f;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.g;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import java.util.ArrayList;

@a(7)
public class WebViewStubTempUI extends MMActivity implements a.AbstractC0015a, MMActivity.a {
    private Dialog JdA = null;
    private int Jdy = 0;
    private boolean Jdz = false;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    /* access modifiers changed from: package-private */
    public static final class StartActivityForResultTask implements Parcelable {
        public static final Parcelable.Creator<StartActivityForResultTask> CREATOR = new Parcelable.Creator<StartActivityForResultTask>() {
            /* class com.tencent.mm.plugin.webview.stub.WebViewStubTempUI.StartActivityForResultTask.AnonymousClass1 */

            /* Return type fixed from 'java.lang.Object[]' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ StartActivityForResultTask[] newArray(int i2) {
                return new StartActivityForResultTask[i2];
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ StartActivityForResultTask createFromParcel(Parcel parcel) {
                AppMethodBeat.i(79416);
                StartActivityForResultTask startActivityForResultTask = new StartActivityForResultTask(parcel);
                AppMethodBeat.o(79416);
                return startActivityForResultTask;
            }
        };
        Intent JdF;
        boolean JdG;
        int JdH;
        int requestCode;
        String wJd;
        String wJe;

        public final int describeContents() {
            return 0;
        }

        public final void writeToParcel(Parcel parcel, int i2) {
            AppMethodBeat.i(79417);
            parcel.writeString(this.wJd);
            parcel.writeString(this.wJe);
            parcel.writeParcelable(this.JdF, i2);
            parcel.writeInt(this.requestCode);
            parcel.writeByte(this.JdG ? (byte) 1 : 0);
            parcel.writeInt(this.JdH);
            AppMethodBeat.o(79417);
        }

        StartActivityForResultTask() {
        }

        StartActivityForResultTask(Parcel parcel) {
            AppMethodBeat.i(79418);
            this.wJd = parcel.readString();
            this.wJe = parcel.readString();
            this.JdF = (Intent) parcel.readParcelable(Intent.class.getClassLoader());
            this.requestCode = parcel.readInt();
            this.JdG = parcel.readByte() != 0;
            this.JdH = parcel.readInt();
            AppMethodBeat.o(79418);
        }

        static {
            AppMethodBeat.i(79419);
            AppMethodBeat.o(79419);
        }
    }

    public static void a(Context context, String str, String str2, Intent intent, int i2) {
        AppMethodBeat.i(79420);
        Intent intent2 = new Intent(context, WebViewStubTempUI.class);
        if (context instanceof Service) {
            intent2.addFlags(268435456);
        }
        intent2.putExtra("key_action_code", 2);
        StartActivityForResultTask startActivityForResultTask = new StartActivityForResultTask();
        startActivityForResultTask.wJd = str;
        startActivityForResultTask.wJe = str2;
        startActivityForResultTask.JdF = intent;
        startActivityForResultTask.requestCode = 15;
        startActivityForResultTask.JdG = false;
        startActivityForResultTask.JdH = i2;
        intent2.putExtra("key_activity_result_task", startActivityForResultTask);
        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent2);
        com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/plugin/webview/stub/WebViewStubTempUI", "startActivityForResult", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Landroid/content/Intent;IZI)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        context.startActivity((Intent) bl.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/plugin/webview/stub/WebViewStubTempUI", "startActivityForResult", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Landroid/content/Intent;IZI)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(79420);
    }

    public static boolean a(Context context, f fVar, String[] strArr, int i2, int i3) {
        AppMethodBeat.i(79424);
        if (context == null) {
            AppMethodBeat.o(79424);
            return true;
        }
        ArrayList arrayList = new ArrayList();
        for (int i4 = 0; i4 <= 0; i4++) {
            String str = strArr[0];
            if (b.checkSelfPermission(context, str) != 0) {
                arrayList.add(str);
            }
        }
        if (arrayList.size() == 0) {
            AppMethodBeat.o(79424);
            return true;
        }
        Bundle bundle = new Bundle();
        bundle.putInt("key_action_code", 1);
        bundle.putStringArray("key_permission_types", (String[]) arrayList.toArray(new String[arrayList.size()]));
        bundle.putInt("key_permission_request_code", i2);
        bundle.putInt("key_binder_id", i3);
        e.a(bundle, "webview", ".stub.WebViewStubTempUI", fVar, null);
        AppMethodBeat.o(79424);
        return false;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(79425);
        super.onCreate(bundle);
        switch (getIntent().getIntExtra("key_action_code", -1)) {
            case 0:
                final ResultReceiver resultReceiver = (ResultReceiver) getIntent().getParcelableExtra("key_alert_result_receiver");
                if (resultReceiver == null) {
                    finish();
                    AppMethodBeat.o(79425);
                    return;
                }
                this.JdA = h.a(this, getIntent().getBooleanExtra("key_alert_cancelable", false), getIntent().getStringExtra("key_alert_message"), getIntent().getStringExtra("key_alert_title"), getIntent().getStringExtra("key_alert_yes"), getIntent().getStringExtra("key_alert_no"), new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.plugin.webview.stub.WebViewStubTempUI.AnonymousClass2 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        AppMethodBeat.i(79413);
                        resultReceiver.send(0, null);
                        WebViewStubTempUI.this.finish();
                        AppMethodBeat.o(79413);
                    }
                }, new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.plugin.webview.stub.WebViewStubTempUI.AnonymousClass3 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        AppMethodBeat.i(79414);
                        resultReceiver.send(1, null);
                        WebViewStubTempUI.this.finish();
                        AppMethodBeat.o(79414);
                    }
                });
                this.JdA.setOnCancelListener(new DialogInterface.OnCancelListener() {
                    /* class com.tencent.mm.plugin.webview.stub.WebViewStubTempUI.AnonymousClass4 */

                    public final void onCancel(DialogInterface dialogInterface) {
                        AppMethodBeat.i(79415);
                        WebViewStubTempUI.this.finish();
                        AppMethodBeat.o(79415);
                    }
                });
                AppMethodBeat.o(79425);
                return;
            case 1:
                android.support.v4.app.a.a(this, getIntent().getStringArrayExtra("key_permission_types"), getIntent().getIntExtra("key_permission_request_code", 0));
                AppMethodBeat.o(79425);
                return;
            case 2:
                StartActivityForResultTask startActivityForResultTask = (StartActivityForResultTask) getIntent().getParcelableExtra("key_activity_result_task");
                this.Jdy = startActivityForResultTask.JdH;
                this.Jdz = true;
                mmSetOnActivityResultCallback(this);
                c.a(this, startActivityForResultTask.wJd, startActivityForResultTask.wJe, startActivityForResultTask.JdF, startActivityForResultTask.requestCode, startActivityForResultTask.JdG);
                AppMethodBeat.o(79425);
                return;
            default:
                finish();
                AppMethodBeat.o(79425);
                return;
        }
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(79426);
        super.onDestroy();
        if (this.JdA != null) {
            this.JdA.dismiss();
        }
        AppMethodBeat.o(79426);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.a.AbstractC0015a
    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        AppMethodBeat.i(79427);
        int intExtra = getIntent().getIntExtra("key_binder_id", 0);
        switch (i2) {
            case 72:
            case 113:
            case 115:
            case 116:
            case 117:
            case 118:
                if (iArr[0] != 0) {
                    g.ahd(intExtra).d(i2, 0, (Intent) null);
                    break;
                } else {
                    g.ahd(intExtra).d(i2, -1, (Intent) null);
                    break;
                }
        }
        finish();
        AppMethodBeat.o(79427);
    }

    @Override // com.tencent.mm.ui.MMActivity.a
    public final void d(int i2, int i3, Intent intent) {
        f ahd;
        AppMethodBeat.i(79428);
        if (this.Jdz && (ahd = g.ahd(this.Jdy)) != null) {
            ahd.d(i2, i3, intent);
        }
        finish();
        AppMethodBeat.o(79428);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return -1;
    }

    public static void a(Context context, f fVar, String str, String str2, String str3, String str4, final DialogInterface.OnClickListener onClickListener, final DialogInterface.OnClickListener onClickListener2) {
        AppMethodBeat.i(79423);
        Intent intent = new Intent(context, WebViewStubTempUI.class);
        if (context instanceof Service) {
            intent.addFlags(268435456);
        }
        intent.putExtra("key_action_code", 0);
        intent.putExtra("key_alert_cancelable", false);
        intent.putExtra("key_alert_message", str);
        intent.putExtra("key_alert_title", str2);
        intent.putExtra("key_alert_yes", str3);
        intent.putExtra("key_alert_no", str4);
        intent.putExtra("key_alert_result_receiver", new ResultReceiver(new Handler(Looper.getMainLooper())) {
            /* class com.tencent.mm.plugin.webview.stub.WebViewStubTempUI.AnonymousClass1 */

            /* access modifiers changed from: protected */
            public final void onReceiveResult(int i2, Bundle bundle) {
                AppMethodBeat.i(79412);
                switch (i2) {
                    case 0:
                        onClickListener.onClick(null, 0);
                        AppMethodBeat.o(79412);
                        return;
                    case 1:
                        onClickListener2.onClick(null, 0);
                        break;
                }
                AppMethodBeat.o(79412);
            }
        });
        e.a(intent.getExtras(), "webview", ".stub.WebViewStubTempUI", fVar, null);
        AppMethodBeat.o(79423);
    }
}

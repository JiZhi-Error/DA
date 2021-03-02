package com.tencent.mm.opensdk.channel;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.channel.a.a;
import com.tencent.mm.opensdk.constants.Build;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import com.tencent.mm.opensdk.utils.Log;
import com.tencent.mm.opensdk.utils.b;

public class MMessageActV2 {
    public static final String DEFAULT_ENTRY_CLASS_NAME = ".wxapi.WXEntryActivity";
    public static final String MM_ENTRY_PACKAGE_NAME = "com.tencent.mm";
    public static final String MM_MSG_ENTRY_CLASS_NAME = "com.tencent.mm.plugin.base.stub.WXEntryActivity";
    private static final String TAG = "MicroMsg.SDK.MMessageAct";
    private byte _hellAccFlag_;

    public static class Args {
        public static final int INVALID_FLAGS = -1;
        public Bundle bundle;
        public String content;
        public int flags = -1;
        public String targetClassName;
        public String targetPkgName;
        public String token;

        public Args() {
            AppMethodBeat.i(190417);
            AppMethodBeat.o(190417);
        }

        public String toString() {
            AppMethodBeat.i(3829);
            String str = "targetPkgName:" + this.targetPkgName + ", targetClassName:" + this.targetClassName + ", content:" + this.content + ", flags:" + this.flags + ", bundle:" + this.bundle;
            AppMethodBeat.o(3829);
            return str;
        }
    }

    public static boolean send(Context context, Args args) {
        AppMethodBeat.i(3828);
        if (context == null || args == null) {
            Log.e(TAG, "send fail, invalid argument");
            AppMethodBeat.o(3828);
            return false;
        } else if (b.b(args.targetPkgName)) {
            Log.e(TAG, "send fail, invalid targetPkgName, targetPkgName = " + args.targetPkgName);
            AppMethodBeat.o(3828);
            return false;
        } else {
            if (b.b(args.targetClassName)) {
                args.targetClassName = args.targetPkgName + DEFAULT_ENTRY_CLASS_NAME;
            }
            Log.d(TAG, "send, targetPkgName = " + args.targetPkgName + ", targetClassName = " + args.targetClassName);
            Intent intent = new Intent();
            intent.setClassName(args.targetPkgName, args.targetClassName);
            Bundle bundle = args.bundle;
            if (bundle != null) {
                intent.putExtras(bundle);
            }
            String packageName = context.getPackageName();
            intent.putExtra(ConstantsAPI.SDK_VERSION, Build.SDK_INT);
            intent.putExtra(ConstantsAPI.APP_PACKAGE, packageName);
            intent.putExtra(ConstantsAPI.CONTENT, args.content);
            intent.putExtra(ConstantsAPI.CHECK_SUM, a.a(args.content, Build.SDK_INT, packageName));
            intent.putExtra(ConstantsAPI.TOKEN, args.token);
            int i2 = args.flags;
            if (i2 == -1) {
                intent.addFlags(268435456).addFlags(134217728);
            } else {
                intent.setFlags(i2);
            }
            try {
                if (Build.VERSION.SDK_INT >= 29) {
                    sendUsingPendingIntent(context, intent);
                } else {
                    com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                    com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/opensdk/channel/MMessageActV2", "send", "(Landroid/content/Context;Lcom/tencent/mm/opensdk/channel/MMessageActV2$Args;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    context.startActivity((Intent) bl.pG(0));
                    com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/opensdk/channel/MMessageActV2", "send", "(Landroid/content/Context;Lcom/tencent/mm/opensdk/channel/MMessageActV2$Args;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                }
                Log.d(TAG, "send mm message, intent=".concat(String.valueOf(intent)));
                AppMethodBeat.o(3828);
                return true;
            } catch (Exception e2) {
                Log.e(TAG, "send fail, ex = " + e2.getMessage());
                AppMethodBeat.o(3828);
                return false;
            }
        }
    }

    private static void sendUsingPendingIntent(Context context, Intent intent) {
        AppMethodBeat.i(190397);
        try {
            Log.i(TAG, "sendUsingPendingIntent");
            PendingIntent.getActivity(context, 3, intent, 134217728).send(context, 4, null, new PendingIntent.OnFinished() {
                /* class com.tencent.mm.opensdk.channel.MMessageActV2.AnonymousClass1 */

                public final void onSendFinished(PendingIntent pendingIntent, Intent intent, int i2, String str, Bundle bundle) {
                    AppMethodBeat.i(190366);
                    Log.i(MMessageActV2.TAG, "sendUsingPendingIntent onSendFinished resultCode: " + i2 + ", resultData: " + str);
                    AppMethodBeat.o(190366);
                }
            }, null);
            AppMethodBeat.o(190397);
        } catch (Exception e2) {
            Log.e(TAG, "sendUsingPendingIntent fail, ex = " + e2.getMessage());
            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
            com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/opensdk/channel/MMessageActV2", "sendUsingPendingIntent", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            context.startActivity((Intent) bl.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/opensdk/channel/MMessageActV2", "sendUsingPendingIntent", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            AppMethodBeat.o(190397);
        }
    }
}

package com.tencent.wework.api;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.a;
import com.tencent.wework.api.IWWAPI;
import com.tencent.wework.api.model.BaseMessage;
import com.tencent.wework.api.model.WWBaseRespMessage;
import com.tencent.wework.api.util.OpenDataUtils;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class WWAPIImplLocal implements IWWAPI {
    private static final ArrayList<String> Sxg = new ArrayList<String>() {
        /* class com.tencent.wework.api.WWAPIImplLocal.AnonymousClass1 */

        {
            AppMethodBeat.i(198985);
            add("com.tencent.wework");
            add("com.tencent.wwgovernment");
            AppMethodBeat.o(198985);
        }
    };
    private static final ArrayList<String> Sxh = new ArrayList<String>() {
        /* class com.tencent.wework.api.WWAPIImplLocal.AnonymousClass2 */

        {
            AppMethodBeat.i(198986);
            add("com.tencent.wework");
            AppMethodBeat.o(198986);
        }
    };
    private static final ArrayList<String> Sxm = new ArrayList<String>() {
        /* class com.tencent.wework.api.WWAPIImplLocal.AnonymousClass3 */

        {
            AppMethodBeat.i(198987);
            add("011A40266C8C75D181DDD8E4DDC50075");
            add("F5BF8B3B1B616EFEF88681716C061BA4");
            add("99A7B5BDA8615128675831C01F208344");
            add("B374B823AD2BF3F216AC8F67B86CE189");
            AppMethodBeat.o(198987);
        }
    };
    private String Sxf;
    private BroadcastReceiver Sxi = new BroadcastReceiver() {
        /* class com.tencent.wework.api.WWAPIImplLocal.AnonymousClass4 */

        public void onReceive(Context context, Intent intent) {
            AppMethodBeat.i(198989);
            try {
                if (!WWAPIImplLocal.this.Sxf.equals(intent.getScheme())) {
                    AppMethodBeat.o(198989);
                    return;
                }
                final BaseMessage A = BaseMessage.A(intent.getData());
                A.brz(WWAPIImplLocal.this.mPreferences.getString("sk", ""));
                A.fromBundle(intent.getExtras());
                if (A instanceof WWBaseRespMessage) {
                    new Handler(Looper.getMainLooper()).post(new Runnable() {
                        /* class com.tencent.wework.api.WWAPIImplLocal.AnonymousClass4.AnonymousClass1 */

                        public void run() {
                            AppMethodBeat.i(198988);
                            try {
                                WWAPIImplLocal.this.callbacks.get(((WWBaseRespMessage) A).transaction);
                                WWAPIImplLocal.this.callbacks.remove(((WWBaseRespMessage) A).transaction);
                                AppMethodBeat.o(198988);
                            } catch (Throwable th) {
                                AppMethodBeat.o(198988);
                            }
                        }
                    });
                }
                AppMethodBeat.o(198989);
            } catch (Throwable th) {
                AppMethodBeat.o(198989);
            }
        }
    };
    private Map<String, Object> callbacks = new HashMap();
    private Context context;
    private SharedPreferences mPreferences = null;

    static {
        AppMethodBeat.i(199000);
        AppMethodBeat.o(199000);
    }

    WWAPIImplLocal(Context context2) {
        AppMethodBeat.i(198990);
        this.context = context2;
        this.mPreferences = context2.getSharedPreferences("wxwork_wwapi_store", 0);
        AppMethodBeat.o(198990);
    }

    @Override // com.tencent.wework.api.IWWAPI
    public final boolean a(IWWAPI.WWAppType wWAppType) {
        AppMethodBeat.i(198991);
        if (wWAppType == IWWAPI.WWAppType.WwAppTypeDefault) {
            boolean bry = bry("com.tencent.wework");
            AppMethodBeat.o(198991);
            return bry;
        } else if (wWAppType == IWWAPI.WWAppType.WwAppTypeWxwork) {
            Intent intent = new Intent("com.tencent.wework.api.sharemsg", Uri.parse("wxworkentuniform://jump"));
            Intent intent2 = new Intent("com.tencent.wework.api.sharemsg", Uri.parse("wxworkentcustomized://jump"));
            if (bry("com.tencent.wework") || bry("com.tencent.wwgovernment") || bL(intent) || bL(intent2)) {
                AppMethodBeat.o(198991);
                return true;
            }
            AppMethodBeat.o(198991);
            return false;
        } else if (wWAppType == IWWAPI.WWAppType.WwAppTypeLocal) {
            Intent intent3 = new Intent("com.tencent.wework.api.sharemsg", Uri.parse("wxworkgovuniform://jump"));
            Intent intent4 = new Intent("com.tencent.wework.api.sharemsg", Uri.parse("wxworkgovcustomized://jump"));
            if (bry("com.tencent.wwgovernment") || bL(intent3) || bL(intent4)) {
                AppMethodBeat.o(198991);
                return true;
            }
            AppMethodBeat.o(198991);
            return false;
        } else {
            AppMethodBeat.o(198991);
            return false;
        }
    }

    private boolean bL(Intent intent) {
        AppMethodBeat.i(198992);
        if (this.context.getPackageManager().queryIntentActivities(intent, 65536).size() > 0) {
            AppMethodBeat.o(198992);
            return true;
        }
        AppMethodBeat.o(198992);
        return false;
    }

    private String bM(Intent intent) {
        AppMethodBeat.i(198993);
        List<ResolveInfo> queryIntentActivities = this.context.getPackageManager().queryIntentActivities(intent, 65536);
        String str = "";
        if (queryIntentActivities.size() > 0) {
            str = queryIntentActivities.get(0).activityInfo.applicationInfo.packageName;
        }
        AppMethodBeat.o(198993);
        return str;
    }

    @Override // com.tencent.wework.api.IWWAPI
    public final String b(IWWAPI.WWAppType wWAppType) {
        if (wWAppType == IWWAPI.WWAppType.WwAppTypeLocal) {
            return "政务微信";
        }
        return "企业微信";
    }

    private int brw(String str) {
        int i2 = 0;
        AppMethodBeat.i(198995);
        try {
            PackageInfo packageInfo = this.context.getPackageManager().getPackageInfo(str, 128);
            if (packageInfo == null) {
                AppMethodBeat.o(198995);
            } else {
                i2 = packageInfo.versionCode;
                AppMethodBeat.o(198995);
            }
        } catch (Throwable th) {
            AppMethodBeat.o(198995);
        }
        return i2;
    }

    @Override // com.tencent.wework.api.IWWAPI
    public final boolean a(BaseMessage baseMessage, IWWAPI.WWAppType wWAppType) {
        String str;
        AppMethodBeat.i(198996);
        ArrayList<String> arrayList = new ArrayList();
        if (wWAppType == IWWAPI.WWAppType.WwAppTypeDefault) {
            arrayList.add("com.tencent.wework");
        } else if (wWAppType == IWWAPI.WWAppType.WwAppTypeWxwork) {
            arrayList.add("com.tencent.wework");
            arrayList.add("com.tencent.weworkenterprise");
        } else if (wWAppType == IWWAPI.WWAppType.WwAppTypeLocal) {
            arrayList.add("com.tencent.wwgovernment");
            arrayList.add("com.tencent.weworklocal");
        }
        for (String str2 : arrayList) {
            if ((str2.equals("com.tencent.wework") || str2.equals("com.tencent.wwgovernment")) && bry(str2)) {
                Intent intent = new Intent("com.tencent.wework.apihost");
                intent.setClassName(str2, "com.tencent.wework.apihost.WWAPIActivity");
                intent.addFlags(411041792);
                try {
                    baseMessage.brA(str2);
                    baseMessage.setContext(this.context);
                    Bundle a2 = BaseMessage.a(baseMessage);
                    long c2 = OpenDataUtils.c(this.context, this.context.getPackageName(), str2, a2);
                    if (c2 > 0) {
                        intent.putExtra("data_id", c2);
                        intent.putExtra("data_pkg", this.context.getPackageName());
                    } else {
                        intent.putExtras(a2);
                    }
                    intent.putExtra("PendingIntent", PendingIntent.getBroadcast(this.context, 0, new Intent(this.context, this.Sxi.getClass()), 134217728));
                    baseMessage.v(intent, str2);
                    Context context2 = this.context;
                    a bl = new a().bl(intent);
                    com.tencent.mm.hellhoundlib.a.a.a(context2, bl.axQ(), "com/tencent/wework/api/WWAPIImplLocal", "sendMessage", "(Lcom/tencent/wework/api/model/BaseMessage;Lcom/tencent/wework/api/IWWAPI$WWAppType;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    context2.startActivity((Intent) bl.pG(0));
                    com.tencent.mm.hellhoundlib.a.a.a(context2, "com/tencent/wework/api/WWAPIImplLocal", "sendMessage", "(Lcom/tencent/wework/api/model/BaseMessage;Lcom/tencent/wework/api/IWWAPI$WWAppType;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    AppMethodBeat.o(198996);
                    return true;
                } catch (Throwable th) {
                }
            } else {
                if (str2.equals("com.tencent.weworkenterprise")) {
                    Intent intent2 = new Intent("com.tencent.wework.api.sharemsg", Uri.parse("wxworkentuniform://jump"));
                    Intent intent3 = new Intent("com.tencent.wework.api.sharemsg", Uri.parse("wxworkentcustomized://jump"));
                    if (bL(intent2)) {
                        if (bry(bM(intent2))) {
                            str = "wxworkentuniform";
                        } else {
                            AppMethodBeat.o(198996);
                            return false;
                        }
                    } else if (bry(bM(intent3))) {
                        str = "wxworkentcustomized";
                    } else {
                        AppMethodBeat.o(198996);
                        return false;
                    }
                } else if (str2.equals("com.tencent.weworklocal")) {
                    Intent intent4 = new Intent("com.tencent.wework.api.sharemsg", Uri.parse("wxworkgovuniform://jump"));
                    Intent intent5 = new Intent("com.tencent.wework.api.sharemsg", Uri.parse("wxworkgovcustomized://jump"));
                    if (bL(intent4)) {
                        if (bry(bM(intent4))) {
                            str = "wxworkgovuniform";
                        } else {
                            AppMethodBeat.o(198996);
                            return false;
                        }
                    } else if (bry(bM(intent5))) {
                        str = "wxworkgovcustomized";
                    } else {
                        AppMethodBeat.o(198996);
                        return false;
                    }
                } else {
                    continue;
                }
                Intent intent6 = new Intent("com.tencent.wework.api.sharemsg", Uri.parse(str + "://jump"));
                intent6.addFlags(411041792);
                try {
                    baseMessage.brA(str2);
                    baseMessage.setContext(this.context);
                    Bundle a3 = BaseMessage.a(baseMessage);
                    long c3 = OpenDataUtils.c(this.context, this.context.getPackageName(), str2, a3);
                    if (c3 > 0) {
                        intent6.putExtra("data_id", c3);
                        intent6.putExtra("data_pkg", this.context.getPackageName());
                    } else {
                        intent6.putExtras(a3);
                    }
                    intent6.putExtra("PendingIntent", PendingIntent.getBroadcast(this.context, 0, new Intent(this.context, this.Sxi.getClass()), 134217728));
                    baseMessage.v(intent6, str2);
                    Context context3 = this.context;
                    a bl2 = new a().bl(intent6);
                    com.tencent.mm.hellhoundlib.a.a.a(context3, bl2.axQ(), "com/tencent/wework/api/WWAPIImplLocal", "sendMessage", "(Lcom/tencent/wework/api/model/BaseMessage;Lcom/tencent/wework/api/IWWAPI$WWAppType;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    context3.startActivity((Intent) bl2.pG(0));
                    com.tencent.mm.hellhoundlib.a.a.a(context3, "com/tencent/wework/api/WWAPIImplLocal", "sendMessage", "(Lcom/tencent/wework/api/model/BaseMessage;Lcom/tencent/wework/api/IWWAPI$WWAppType;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    new StringBuilder("sendMessage, start WWAPIActivity, pkg: ").append(str2).append(",scheme:").append(str);
                    AppMethodBeat.o(198996);
                    return true;
                } catch (Throwable th2) {
                }
            }
        }
        AppMethodBeat.o(198996);
        return false;
    }

    private String brx(String str) {
        AppMethodBeat.i(198997);
        try {
            String dd = dd(this.context.getPackageManager().getPackageInfo(str, 64).signatures[0].toByteArray());
            AppMethodBeat.o(198997);
            return dd;
        } catch (Throwable th) {
            AppMethodBeat.o(198997);
            return "";
        }
    }

    private static String dd(byte[] bArr) {
        AppMethodBeat.i(198998);
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            instance.reset();
            instance.update(bArr);
            byte[] digest = instance.digest();
            StringBuilder sb = new StringBuilder(digest.length * 2);
            for (byte b2 : digest) {
                sb.append(Integer.toHexString((b2 & 240) >>> 4));
                sb.append(Integer.toHexString(b2 & 15));
            }
            String upperCase = sb.toString().toUpperCase();
            AppMethodBeat.o(198998);
            return upperCase;
        } catch (NoSuchAlgorithmException e2) {
            AppMethodBeat.o(198998);
            return "";
        }
    }

    private boolean bry(String str) {
        AppMethodBeat.i(198999);
        boolean contains = Sxm.contains(brx(str));
        AppMethodBeat.o(198999);
        return contains;
    }

    @Override // com.tencent.wework.api.IWWAPI
    public final boolean hrE() {
        int i2;
        AppMethodBeat.i(198994);
        ArrayList<String> arrayList = Sxg;
        if (this.context != null && !TextUtils.equals(this.context.getPackageName(), "com.tencent.mm")) {
            arrayList = Sxh;
        }
        Iterator<String> it = arrayList.iterator();
        while (true) {
            if (!it.hasNext()) {
                i2 = 0;
                break;
            }
            i2 = brw(it.next());
            if (i2 != 0) {
                break;
            }
        }
        if (i2 >= 100) {
            AppMethodBeat.o(198994);
            return true;
        }
        AppMethodBeat.o(198994);
        return false;
    }
}

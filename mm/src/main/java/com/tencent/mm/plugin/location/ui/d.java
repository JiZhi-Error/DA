package com.tencent.mm.plugin.location.ui;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.b.a;
import com.tencent.mm.plugin.location.model.LocationInfo;
import com.tencent.mm.plugin.location.model.e;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class d {
    private ActivityManager aJf;
    public Context context;
    public int dYn = -1;
    public int yHB = 0;
    public int yHC = 0;
    public boolean yHD = false;

    public static int ede() {
        AppMethodBeat.i(55815);
        Log.d("MicroMsg.MapHelper", "getDefaultZoom isGoogle : false");
        AppMethodBeat.o(55815);
        return 15;
    }

    public d(Context context2) {
        AppMethodBeat.i(55816);
        this.context = context2;
        this.aJf = (ActivityManager) context2.getSystemService(EnvConsts.ACTIVITY_MANAGER_SRVNAME);
        AppMethodBeat.o(55816);
    }

    private static String a(Context context2, LocationInfo locationInfo) {
        AppMethodBeat.i(55817);
        String string = context2.getString(R.string.ekg);
        if (!Util.isNullOrNil(locationInfo.dWi) && !locationInfo.dWi.equals(string)) {
            String str = locationInfo.dWi;
            AppMethodBeat.o(55817);
            return str;
        } else if (!Util.isNullOrNil(locationInfo.yFx)) {
            String str2 = locationInfo.yFx;
            AppMethodBeat.o(55817);
            return str2;
        } else {
            AppMethodBeat.o(55817);
            return "";
        }
    }

    private static Intent a(Context context2, LocationInfo locationInfo, LocationInfo locationInfo2, boolean z) {
        String format;
        String format2;
        AppMethodBeat.i(55818);
        if (z || !locationInfo2.ecH()) {
            double[] b2 = e.b(new double[]{locationInfo.yFv, locationInfo.yFu});
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(String.format("geo:%s,%s?z=%s", Double.valueOf(b2[1]), Double.valueOf(b2[0]), Integer.valueOf(locationInfo.yFw))));
            intent.setPackage("com.baidu.BaiduMap");
            AppMethodBeat.o(55818);
            return intent;
        }
        String a2 = a(context2, locationInfo2);
        if (!Util.isNullOrNil(a2)) {
            format = String.format("name:%s|latlng:%f,%f", a2, Double.valueOf(locationInfo2.yFu), Double.valueOf(locationInfo2.yFv));
        } else {
            format = String.format("%f,%f", Double.valueOf(locationInfo2.yFu), Double.valueOf(locationInfo2.yFv));
        }
        String a3 = a(context2, locationInfo);
        if (!Util.isNullOrNil(a3)) {
            format2 = String.format("name:%s|latlng:%f,%f", a3, Double.valueOf(locationInfo.yFu), Double.valueOf(locationInfo.yFv));
        } else {
            format2 = String.format("%f,%f", Double.valueOf(locationInfo.yFu), Double.valueOf(locationInfo.yFv));
        }
        String format3 = String.format("intent://map/direction?origin=%s&destination=%s&mode=recommond&coord_type=gcj02", format, format2);
        Log.d("MicroMsg.MapHelper", "url ".concat(String.valueOf(format3)));
        try {
            String str = format3 + "&referer=tencent|weixin#Intent;scheme=bdapp;package=com.baidu.BaiduMap;end";
            Log.d("MicroMsg.MapHelper", "all: ".concat(String.valueOf(str)));
            Intent intent2 = Intent.getIntent(str);
            AppMethodBeat.o(55818);
            return intent2;
        } catch (URISyntaxException e2) {
            Log.printErrStackTrace("MicroMsg.MapHelper", e2, "", new Object[0]);
            AppMethodBeat.o(55818);
            return null;
        }
    }

    private static Intent a(LocationInfo locationInfo, LocationInfo locationInfo2, boolean z) {
        AppMethodBeat.i(55819);
        if (z || !locationInfo2.ecH()) {
            double[] b2 = e.b(new double[]{locationInfo.yFv, locationInfo.yFu});
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(String.format("geo:%s,%s?z=%s", Double.valueOf(b2[1]), Double.valueOf(b2[0]), Integer.valueOf(locationInfo.yFw))));
            intent.setClassName("com.google.android.apps.maps", "com.google.android.maps.MapsActivity");
            AppMethodBeat.o(55819);
            return intent;
        }
        Intent intent2 = new Intent("android.intent.action.VIEW", Uri.parse(String.format("http://maps.google.com/maps?f=d&saddr=%f,%f&daddr=%f,%f&hl=".concat(String.valueOf(Util.isNullOrNil(locationInfo.yFy) ? "zh-cn" : locationInfo.yFy)), Double.valueOf(locationInfo2.yFu), Double.valueOf(locationInfo2.yFv), Double.valueOf(locationInfo.yFu), Double.valueOf(locationInfo.yFv))));
        intent2.setClassName("com.google.android.apps.maps", "com.google.android.maps.MapsActivity");
        AppMethodBeat.o(55819);
        return intent2;
    }

    private static Intent b(Context context2, LocationInfo locationInfo, LocationInfo locationInfo2, boolean z) {
        AppMethodBeat.i(55820);
        if (z || !locationInfo2.ecH()) {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("geo:" + locationInfo.yFu + "," + locationInfo.yFv + "?z=" + locationInfo.yFw));
            intent.setPackage("com.tencent.map");
            AppMethodBeat.o(55820);
            return intent;
        }
        String str = locationInfo.yFB;
        if (!Util.isNullOrNil(locationInfo.yFB) && locationInfo.yFB.startsWith("qqmap_")) {
            str = locationInfo.yFB.substring(6);
        }
        String format = String.format("qqmap://map/routeplan/type=drive&touid=%s&tocoord=%f,%f&from=%s&to=%s&referer=wx_client", str, Double.valueOf(locationInfo.yFu), Double.valueOf(locationInfo.yFv), URLEncoder.encode(a(context2, locationInfo2)), URLEncoder.encode(a(context2, locationInfo)));
        Log.d("MicroMsg.MapHelper", "tencentluxian, url=%s", format);
        Intent intent2 = new Intent("android.intent.action.VIEW", Uri.parse(format));
        intent2.setPackage("com.tencent.map");
        if (Util.isIntentAvailable(context2, intent2)) {
            AppMethodBeat.o(55820);
            return intent2;
        }
        Intent intent3 = new Intent("android.intent.action.VIEW", Uri.parse("geo:" + locationInfo.yFu + "," + locationInfo.yFv));
        intent3.setPackage("com.tencent.map");
        AppMethodBeat.o(55820);
        return intent3;
    }

    private static Intent a(Context context2, LocationInfo locationInfo, LocationInfo locationInfo2, boolean z, String str) {
        AppMethodBeat.i(55821);
        if (z || !locationInfo2.ecH()) {
            double[] b2 = e.b(new double[]{locationInfo.yFv, locationInfo.yFu});
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(String.format("geo:%s,%s?z=%s", Double.valueOf(b2[1]), Double.valueOf(b2[0]), Integer.valueOf(locationInfo.yFw))));
            intent.setPackage(str);
            AppMethodBeat.o(55821);
            return intent;
        }
        String format = String.format("wechatnav://type=nav&fromcoord=%f,%f&tocoord=%f,%f", Double.valueOf(locationInfo2.yFu), Double.valueOf(locationInfo2.yFv), Double.valueOf(locationInfo.yFu), Double.valueOf(locationInfo.yFv));
        if (!Util.isNullOrNil(locationInfo2.yFx) && (!Util.isNullOrNil(locationInfo.yFx) || !Util.isNullOrNil(locationInfo.dWi))) {
            StringBuilder append = new StringBuilder().append(format);
            Object[] objArr = new Object[2];
            objArr[0] = locationInfo2.yFx;
            objArr[1] = !Util.isNullOrNil(locationInfo.dWi) ? locationInfo.dWi : locationInfo.yFx;
            format = append.append(String.format("&from=%s&to=%s", objArr)).toString();
        }
        Intent intent2 = new Intent("android.intent.action.VIEW", Uri.parse(format));
        intent2.setPackage(str);
        if (Util.isIntentAvailable(context2, intent2)) {
            AppMethodBeat.o(55821);
            return intent2;
        }
        Intent intent3 = new Intent("android.intent.action.VIEW", Uri.parse("geo:" + locationInfo.yFu + "," + locationInfo.yFv));
        intent3.setPackage(str);
        AppMethodBeat.o(55821);
        return intent3;
    }

    private static Intent b(Context context2, LocationInfo locationInfo, LocationInfo locationInfo2, boolean z, String str) {
        AppMethodBeat.i(55822);
        if (z || !locationInfo2.ecH()) {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("geo:" + locationInfo.yFu + "," + locationInfo.yFv + "?z=" + locationInfo.yFw));
            intent.setPackage(str);
            AppMethodBeat.o(55822);
            return intent;
        }
        String format = String.format("wechatnav://type=nav&fromcoord=%f,%f&tocoord=%f,%f", Double.valueOf(locationInfo2.yFu), Double.valueOf(locationInfo2.yFv), Double.valueOf(locationInfo.yFu), Double.valueOf(locationInfo.yFv));
        if (!Util.isNullOrNil(locationInfo2.yFx) && !Util.isNullOrNil(locationInfo.yFx)) {
            format = format + String.format("&from=%s&to=%s", locationInfo2.yFx, locationInfo.yFx);
        }
        Intent intent2 = new Intent("android.intent.action.VIEW", Uri.parse(format));
        intent2.setPackage(str);
        if (Util.isIntentAvailable(context2, intent2)) {
            AppMethodBeat.o(55822);
            return intent2;
        }
        Intent intent3 = new Intent("android.intent.action.VIEW", Uri.parse("geo:" + locationInfo.yFu + "," + locationInfo.yFv));
        intent3.setPackage(str);
        AppMethodBeat.o(55822);
        return intent3;
    }

    public final void a(LocationInfo locationInfo, LocationInfo locationInfo2, String str, boolean z) {
        PackageInfo bg;
        Intent intent;
        Intent intent2;
        Intent intent3;
        Intent intent4;
        Intent intent5;
        AppMethodBeat.i(55823);
        if ("com.tencent.map".equals(str)) {
            if (z) {
                h.INSTANCE.a(11091, 4, 2);
            } else {
                h.INSTANCE.a(11091, 4, 1);
            }
        } else if (z) {
            h.INSTANCE.a(11091, 5, 2);
        } else {
            h.INSTANCE.a(11091, 5, 1);
        }
        PackageManager packageManager = this.context.getPackageManager();
        if ("com.google.android.apps.maps".equals(str)) {
            Intent a2 = a(locationInfo, locationInfo2, false);
            if (!Util.isIntentAvailable(this.context, a2)) {
                intent5 = a(locationInfo, locationInfo2, true);
            } else {
                intent5 = a2;
            }
            h.INSTANCE.a(10997, "4", "", 0, 0);
            Context context2 = this.context;
            a bl = new a().bl(intent5);
            com.tencent.mm.hellhoundlib.a.a.a(context2, bl.axQ(), "com/tencent/mm/plugin/location/ui/MapHelper", "startNavigationActivity", "(Lcom/tencent/mm/plugin/location/model/LocationInfo;Lcom/tencent/mm/plugin/location/model/LocationInfo;Ljava/lang/String;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            context2.startActivity((Intent) bl.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(context2, "com/tencent/mm/plugin/location/ui/MapHelper", "startNavigationActivity", "(Lcom/tencent/mm/plugin/location/model/LocationInfo;Lcom/tencent/mm/plugin/location/model/LocationInfo;Ljava/lang/String;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            AppMethodBeat.o(55823);
        } else if ("com.baidu.BaiduMap".equals(str)) {
            Intent a3 = a(this.context, locationInfo, locationInfo2, false);
            if (!Util.isIntentAvailable(this.context, a3)) {
                intent4 = a(this.context, locationInfo, locationInfo2, true);
            } else {
                intent4 = a3;
            }
            h.INSTANCE.a(10997, "5", e.bg(this.context, "com.baidu.BaiduMap").applicationInfo.loadLabel(packageManager).toString(), 0, 0);
            Context context3 = this.context;
            a bl2 = new a().bl(intent4);
            com.tencent.mm.hellhoundlib.a.a.a(context3, bl2.axQ(), "com/tencent/mm/plugin/location/ui/MapHelper", "startNavigationActivity", "(Lcom/tencent/mm/plugin/location/model/LocationInfo;Lcom/tencent/mm/plugin/location/model/LocationInfo;Ljava/lang/String;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            context3.startActivity((Intent) bl2.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(context3, "com/tencent/mm/plugin/location/ui/MapHelper", "startNavigationActivity", "(Lcom/tencent/mm/plugin/location/model/LocationInfo;Lcom/tencent/mm/plugin/location/model/LocationInfo;Ljava/lang/String;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            AppMethodBeat.o(55823);
        } else if ("com.tencent.map".equals(str)) {
            Intent b2 = b(this.context, locationInfo, locationInfo2, false);
            if (!Util.isIntentAvailable(this.context, b2)) {
                intent3 = b(this.context, locationInfo, locationInfo2, true);
            } else {
                intent3 = b2;
            }
            h.INSTANCE.a(10997, "2", "", 0, 0);
            Context context4 = this.context;
            a bl3 = new a().bl(intent3);
            com.tencent.mm.hellhoundlib.a.a.a(context4, bl3.axQ(), "com/tencent/mm/plugin/location/ui/MapHelper", "startNavigationActivity", "(Lcom/tencent/mm/plugin/location/model/LocationInfo;Lcom/tencent/mm/plugin/location/model/LocationInfo;Ljava/lang/String;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            context4.startActivity((Intent) bl3.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(context4, "com/tencent/mm/plugin/location/ui/MapHelper", "startNavigationActivity", "(Lcom/tencent/mm/plugin/location/model/LocationInfo;Lcom/tencent/mm/plugin/location/model/LocationInfo;Ljava/lang/String;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            AppMethodBeat.o(55823);
        } else if ("com.autonavi.minimap".equals(str)) {
            PackageInfo bg2 = e.bg(this.context, str);
            if (bg2 != null) {
                Intent a4 = a(this.context, locationInfo, locationInfo2, false, str);
                if (!Util.isIntentAvailable(this.context, a4)) {
                    intent2 = a(this.context, locationInfo, locationInfo2, true, str);
                } else {
                    intent2 = a4;
                }
                h.INSTANCE.a(10997, "5", bg2.applicationInfo.loadLabel(packageManager).toString(), 0, 0);
                Context context5 = this.context;
                a bl4 = new a().bl(intent2);
                com.tencent.mm.hellhoundlib.a.a.a(context5, bl4.axQ(), "com/tencent/mm/plugin/location/ui/MapHelper", "startNavigationActivity", "(Lcom/tencent/mm/plugin/location/model/LocationInfo;Lcom/tencent/mm/plugin/location/model/LocationInfo;Ljava/lang/String;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                context5.startActivity((Intent) bl4.pG(0));
                com.tencent.mm.hellhoundlib.a.a.a(context5, "com/tencent/mm/plugin/location/ui/MapHelper", "startNavigationActivity", "(Lcom/tencent/mm/plugin/location/model/LocationInfo;Lcom/tencent/mm/plugin/location/model/LocationInfo;Ljava/lang/String;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            }
            AppMethodBeat.o(55823);
        } else {
            if ("com.sogou.map.android.maps".equals(str) && (bg = e.bg(this.context, str)) != null) {
                Intent b3 = b(this.context, locationInfo, locationInfo2, false, str);
                if (!Util.isIntentAvailable(this.context, b3)) {
                    intent = b(this.context, locationInfo, locationInfo2, true, str);
                } else {
                    intent = b3;
                }
                h.INSTANCE.a(10997, "5", bg.applicationInfo.loadLabel(packageManager).toString(), 0, 0);
                Context context6 = this.context;
                a bl5 = new a().bl(intent);
                com.tencent.mm.hellhoundlib.a.a.a(context6, bl5.axQ(), "com/tencent/mm/plugin/location/ui/MapHelper", "startNavigationActivity", "(Lcom/tencent/mm/plugin/location/model/LocationInfo;Lcom/tencent/mm/plugin/location/model/LocationInfo;Ljava/lang/String;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                context6.startActivity((Intent) bl5.pG(0));
                com.tencent.mm.hellhoundlib.a.a.a(context6, "com/tencent/mm/plugin/location/ui/MapHelper", "startNavigationActivity", "(Lcom/tencent/mm/plugin/location/model/LocationInfo;Lcom/tencent/mm/plugin/location/model/LocationInfo;Ljava/lang/String;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            }
            AppMethodBeat.o(55823);
        }
    }

    public final Map<String, String> b(LocationInfo locationInfo) {
        AppMethodBeat.i(55824);
        ArrayList arrayList = new ArrayList();
        arrayList.add("com.tencent.map");
        arrayList.add("com.google.android.apps.maps");
        arrayList.add("com.baidu.BaiduMap");
        arrayList.add("com.autonavi.minimap");
        arrayList.add("com.sogou.map.android.maps");
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(String.format("geo:%f,%f", Double.valueOf(locationInfo.yFu), Double.valueOf(locationInfo.yFv))));
        PackageManager packageManager = this.context.getPackageManager();
        HashMap hashMap = new HashMap();
        for (ResolveInfo resolveInfo : packageManager.queryIntentActivities(intent, 65536)) {
            if (arrayList.contains(resolveInfo.activityInfo.packageName)) {
                hashMap.put(resolveInfo.activityInfo.packageName, resolveInfo.activityInfo.loadLabel(this.context.getPackageManager()).toString());
            }
        }
        AppMethodBeat.o(55824);
        return hashMap;
    }
}

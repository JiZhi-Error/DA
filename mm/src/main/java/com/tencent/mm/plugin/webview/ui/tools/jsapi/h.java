package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.map.lib.models.AccessibleTouchItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.modelgeo.b;
import com.tencent.mm.modelgeo.c;
import com.tencent.mm.pluginsdk.model.d;
import com.tencent.mm.pluginsdk.ui.tools.AppChooserUI;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import java.lang.ref.WeakReference;
import java.net.URLEncoder;
import java.util.ArrayList;

public final class h implements MMActivity.a {
    final Runnable JvA = new Runnable() {
        /* class com.tencent.mm.plugin.webview.ui.tools.jsapi.h.AnonymousClass1 */

        public final void run() {
            AppMethodBeat.i(82029);
            if (h.this.Jvz == null || h.this.iOv == null) {
                AppMethodBeat.o(82029);
                return;
            }
            h.this.yKY.a(h.this.Jvx);
            h.this.iOv.c(h.this.Jvz);
            h.this.Jvz.a(false, 0.0f, 0.0f, 0, 0.0d, 0.0d);
            AppMethodBeat.o(82029);
        }
    };
    int Jvq;
    boolean Jvr = false;
    int Jvs;
    e Jvt;
    e Jvu;
    String Jvv;
    d Jvw;
    c.a Jvx = null;
    c.a Jvy = null;
    b.a Jvz = null;
    WeakReference<Context> aWF;
    com.tencent.mm.modelgeo.d iOv = null;
    com.tencent.mm.modelgeo.c yKY = null;

    interface d {
        void ahb(int i2);

        void ahc(int i2);

        void onFail(int i2);

        void onSuccess(int i2);
    }

    @Override // com.tencent.mm.ui.MMActivity.a
    public final void d(int i2, int i3, Intent intent) {
        f hVar;
        AppMethodBeat.i(82044);
        Context context = this.aWF.get();
        if (!(this.Jvw == null || context == null)) {
            if (!this.Jvr) {
                Log.e("MicroMsg.OpenMapNavigator", "onActivityResult called without msgId attached...");
            } else if (i2 != 33) {
                Log.e("MicroMsg.OpenMapNavigator", "onActivityResult, mismatched request_code = %d", Integer.valueOf(i2));
                this.Jvw.onFail(this.Jvq);
            } else if (i3 == 4097 || i3 == 0) {
                this.Jvw.ahb(this.Jvq);
            } else if (i3 == -1) {
                String stringExtra = intent.getStringExtra("selectpkg");
                if (Util.isNullOrNil(stringExtra)) {
                    Log.e("MicroMsg.OpenMapNavigator", "onActivityResult, get null packageName");
                    this.Jvw.onFail(this.Jvq);
                } else {
                    if (d.a.GoogleMap.getPackage().equals(stringExtra)) {
                        hVar = new c((byte) 0);
                    } else if (d.a.BaiduMap.getPackage().equals(stringExtra)) {
                        hVar = new a((byte) 0);
                    } else if (d.a.SogouMap.getPackage().equals(stringExtra)) {
                        hVar = new g((byte) 0);
                    } else if (d.a.AutonaviMap.getPackage().equals(stringExtra)) {
                        hVar = new b((byte) 0);
                    } else {
                        hVar = new C1998h((byte) 0);
                    }
                    hVar.a(context, this.Jvt, this.Jvu, this.Jvv);
                    this.Jvw.onSuccess(this.Jvq);
                }
            } else {
                Log.e("MicroMsg.OpenMapNavigator", "onActivityResult, not support result_code = %d", Integer.valueOf(i3));
                this.Jvw.onFail(this.Jvq);
            }
        }
        if (this.Jvr && this.Jvw != null) {
            this.Jvw.ahc(this.Jvq);
        }
        this.Jvr = false;
        this.Jvs = d.a.TencentMap.code;
        this.Jvt = null;
        this.Jvu = null;
        this.aWF = null;
        this.Jvw = null;
        this.Jvv = null;
        this.Jvx = null;
        this.Jvy = null;
        if (!(this.iOv == null || this.Jvz == null)) {
            this.iOv.c(this.Jvz);
        }
        this.iOv = null;
        this.Jvz = null;
        if (this.yKY != null) {
            if (this.Jvx != null) {
                this.yKY.a(this.Jvx);
            }
            if (this.Jvy != null) {
                this.yKY.a(this.Jvy);
            }
        }
        this.yKY = null;
        this.Jvx = null;
        this.Jvy = null;
        AppMethodBeat.o(82044);
    }

    /* access modifiers changed from: package-private */
    public static final class e {
        String JvD;
        double latitude;
        double longitude;

        /* synthetic */ e(double d2, double d3, byte b2) {
            this(d2, d3);
        }

        private e(double d2, double d3) {
            this.latitude = d2;
            this.longitude = d3;
            this.JvD = null;
        }
    }

    h() {
        AppMethodBeat.i(82045);
        AppMethodBeat.o(82045);
    }

    /* access modifiers changed from: package-private */
    public final void ghG() {
        Context context = null;
        AppMethodBeat.i(82046);
        this.Jvz = null;
        this.Jvx = null;
        this.Jvy = null;
        if (this.aWF != null) {
            context = this.aWF.get();
        }
        if (context == null) {
            AppMethodBeat.o(82046);
            return;
        }
        Intent intent = new Intent(context, AppChooserUI.class);
        ArrayList<String> arrayList = new ArrayList<>(5);
        arrayList.add(d.a.TencentMap.getPackage());
        arrayList.add(d.a.GoogleMap.getPackage());
        arrayList.add(d.a.SogouMap.getPackage());
        arrayList.add(d.a.BaiduMap.getPackage());
        arrayList.add(d.a.AutonaviMap.getPackage());
        intent.putStringArrayListExtra("targetwhitelist", arrayList);
        Intent intent2 = new Intent("android.intent.action.VIEW", Uri.parse(String.format("geo:%f,%f", Double.valueOf(this.Jvu.latitude), Double.valueOf(this.Jvu.longitude))));
        intent.putExtra("targetintent", intent2);
        Bundle bundle = new Bundle(2);
        bundle.putInt("key_map_app", this.Jvs);
        bundle.putParcelable("key_target_intent", intent2);
        intent.putExtra("key_recommend_params", bundle);
        intent.putExtra("type", 2);
        intent.putExtra("title", context.getString(R.string.j4v));
        ((MMActivity) context).mmStartActivityForResult(this, intent, 33);
        AppMethodBeat.o(82046);
    }

    static abstract class f {
        /* access modifiers changed from: protected */
        public abstract String getPackageName();

        private f() {
        }

        /* synthetic */ f(byte b2) {
            this();
        }

        /* access modifiers changed from: protected */
        public void a(Context context, e eVar, e eVar2, String str) {
            if (context != null) {
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("geo:" + eVar2.latitude + "," + eVar2.longitude));
                intent.setPackage(getPackageName());
                intent.addFlags(268435456);
                com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/plugin/webview/ui/tools/jsapi/OpenMapNavigator$NavigateJumper", "goNavigate", "(Landroid/content/Context;Lcom/tencent/mm/plugin/webview/ui/tools/jsapi/OpenMapNavigator$Location;Lcom/tencent/mm/plugin/webview/ui/tools/jsapi/OpenMapNavigator$Location;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                context.startActivity((Intent) bl.pG(0));
                com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/plugin/webview/ui/tools/jsapi/OpenMapNavigator$NavigateJumper", "goNavigate", "(Landroid/content/Context;Lcom/tencent/mm/plugin/webview/ui/tools/jsapi/OpenMapNavigator$Location;Lcom/tencent/mm/plugin/webview/ui/tools/jsapi/OpenMapNavigator$Location;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            }
        }
    }

    static final class c extends f {
        private c() {
            super((byte) 0);
        }

        /* synthetic */ c(byte b2) {
            this();
        }

        /* access modifiers changed from: protected */
        @Override // com.tencent.mm.plugin.webview.ui.tools.jsapi.h.f
        public final void a(Context context, e eVar, e eVar2, String str) {
            AppMethodBeat.i(82038);
            if (context == null) {
                super.a(context, eVar, eVar2, str);
                AppMethodBeat.o(82038);
                return;
            }
            String format = String.format("http://maps.google.com/maps?f=d&daddr=%f,%f", Double.valueOf(eVar2.latitude), Double.valueOf(eVar2.longitude));
            if (eVar != null) {
                format = format + String.format("&saddr=%f,%f", Double.valueOf(eVar.latitude), Double.valueOf(eVar.longitude));
            }
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(format));
            intent.setClassName("com.google.android.apps.maps", "com.google.android.maps.MapsActivity");
            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
            com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/plugin/webview/ui/tools/jsapi/OpenMapNavigator$GoogleNavigateJumper", "goNavigate", "(Landroid/content/Context;Lcom/tencent/mm/plugin/webview/ui/tools/jsapi/OpenMapNavigator$Location;Lcom/tencent/mm/plugin/webview/ui/tools/jsapi/OpenMapNavigator$Location;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            context.startActivity((Intent) bl.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/plugin/webview/ui/tools/jsapi/OpenMapNavigator$GoogleNavigateJumper", "goNavigate", "(Landroid/content/Context;Lcom/tencent/mm/plugin/webview/ui/tools/jsapi/OpenMapNavigator$Location;Lcom/tencent/mm/plugin/webview/ui/tools/jsapi/OpenMapNavigator$Location;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            AppMethodBeat.o(82038);
        }

        /* access modifiers changed from: protected */
        @Override // com.tencent.mm.plugin.webview.ui.tools.jsapi.h.f
        public final String getPackageName() {
            AppMethodBeat.i(82039);
            String str = d.a.GoogleMap.getPackage();
            AppMethodBeat.o(82039);
            return str;
        }
    }

    static final class a extends f {
        private a() {
            super((byte) 0);
        }

        /* synthetic */ a(byte b2) {
            this();
        }

        /* access modifiers changed from: protected */
        @Override // com.tencent.mm.plugin.webview.ui.tools.jsapi.h.f
        public final void a(Context context, e eVar, e eVar2, String str) {
            AppMethodBeat.i(82034);
            if (context == null) {
                super.a(context, eVar, eVar2, str);
                AppMethodBeat.o(82034);
                return;
            }
            String format = String.format("baidumap://map/direction?destination=%f,%f&mode=driving", Double.valueOf(eVar2.latitude), Double.valueOf(eVar2.longitude));
            if (eVar != null) {
                format = format + String.format("origin=%f,%f", Double.valueOf(eVar.latitude), Double.valueOf(eVar.longitude));
            }
            Log.d("MicroMsg.OpenMapNavigator", "url ".concat(String.valueOf(format)));
            try {
                com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(new Intent("android.intent.action.VIEW", Uri.parse(format + "&src=webapp.car.carroutelistmappg.weixindrivenav")));
                com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/plugin/webview/ui/tools/jsapi/OpenMapNavigator$BaiduNavigateJumper", "goNavigate", "(Landroid/content/Context;Lcom/tencent/mm/plugin/webview/ui/tools/jsapi/OpenMapNavigator$Location;Lcom/tencent/mm/plugin/webview/ui/tools/jsapi/OpenMapNavigator$Location;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                context.startActivity((Intent) bl.pG(0));
                com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/plugin/webview/ui/tools/jsapi/OpenMapNavigator$BaiduNavigateJumper", "goNavigate", "(Landroid/content/Context;Lcom/tencent/mm/plugin/webview/ui/tools/jsapi/OpenMapNavigator$Location;Lcom/tencent/mm/plugin/webview/ui/tools/jsapi/OpenMapNavigator$Location;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                AppMethodBeat.o(82034);
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.OpenMapNavigator", e2, "", new Object[0]);
                AppMethodBeat.o(82034);
            }
        }

        /* access modifiers changed from: protected */
        @Override // com.tencent.mm.plugin.webview.ui.tools.jsapi.h.f
        public final String getPackageName() {
            AppMethodBeat.i(82035);
            String str = d.a.BaiduMap.getPackage();
            AppMethodBeat.o(82035);
            return str;
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.jsapi.h$h  reason: collision with other inner class name */
    static final class C1998h extends f {
        private C1998h() {
            super((byte) 0);
        }

        /* synthetic */ C1998h(byte b2) {
            this();
        }

        /* access modifiers changed from: protected */
        @Override // com.tencent.mm.plugin.webview.ui.tools.jsapi.h.f
        public final void a(Context context, e eVar, e eVar2, String str) {
            AppMethodBeat.i(82042);
            if (context == null) {
                super.a(context, eVar, eVar2, str);
                AppMethodBeat.o(82042);
                return;
            }
            String format = String.format("sosomap://type=nav&tocoord=%f,%f", Double.valueOf(eVar2.longitude), Double.valueOf(eVar2.latitude));
            if (eVar != null) {
                format = format + String.format("fromcoord=%f,%f", Double.valueOf(eVar.longitude), Double.valueOf(eVar.latitude));
                if (!Util.isNullOrNil(eVar.JvD)) {
                    format = format + String.format("&from=%s", URLEncoder.encode(eVar.JvD));
                }
            }
            if (Util.isNullOrNil(str)) {
                if (!Util.isNullOrNil(eVar2.JvD)) {
                    str = eVar2.JvD;
                } else {
                    str = "地图选点";
                }
            }
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse((format + String.format("&to=%s", URLEncoder.encode(str))) + "&referer=wx_client"));
            intent.setPackage(d.a.TencentMap.getPackage());
            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
            com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/plugin/webview/ui/tools/jsapi/OpenMapNavigator$TencentNavigateJumper", "goNavigate", "(Landroid/content/Context;Lcom/tencent/mm/plugin/webview/ui/tools/jsapi/OpenMapNavigator$Location;Lcom/tencent/mm/plugin/webview/ui/tools/jsapi/OpenMapNavigator$Location;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            context.startActivity((Intent) bl.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/plugin/webview/ui/tools/jsapi/OpenMapNavigator$TencentNavigateJumper", "goNavigate", "(Landroid/content/Context;Lcom/tencent/mm/plugin/webview/ui/tools/jsapi/OpenMapNavigator$Location;Lcom/tencent/mm/plugin/webview/ui/tools/jsapi/OpenMapNavigator$Location;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            AppMethodBeat.o(82042);
        }

        /* access modifiers changed from: protected */
        @Override // com.tencent.mm.plugin.webview.ui.tools.jsapi.h.f
        public final String getPackageName() {
            AppMethodBeat.i(259801);
            String str = d.a.TencentMap.getPackage();
            AppMethodBeat.o(259801);
            return str;
        }
    }

    static final class g extends f {
        private g() {
            super((byte) 0);
        }

        /* synthetic */ g(byte b2) {
            this();
        }

        /* access modifiers changed from: protected */
        @Override // com.tencent.mm.plugin.webview.ui.tools.jsapi.h.f
        public final void a(Context context, e eVar, e eVar2, String str) {
            String str2;
            AppMethodBeat.i(82040);
            if (context == null) {
                super.a(context, eVar, eVar2, str);
                AppMethodBeat.o(82040);
                return;
            }
            String format = String.format("wechatnav://type=nav&tocoord=%f,%f", Double.valueOf(eVar2.latitude), Double.valueOf(eVar2.longitude));
            if (eVar != null) {
                str2 = format + String.format("&fromcoord=%f,%f", Double.valueOf(eVar.latitude), Double.valueOf(eVar.longitude));
                if (!Util.isNullOrNil(eVar.JvD)) {
                    str2 = str2 + String.format("&from=%s", URLEncoder.encode(eVar.JvD));
                }
            } else {
                str2 = format + String.format("&from=%s", AccessibleTouchItem.MY_LOCATION_PREFIX);
            }
            if (Util.isNullOrNil(str)) {
                if (!Util.isNullOrNil(eVar2.JvD)) {
                    str = eVar2.JvD;
                } else {
                    str = "目的地";
                }
            }
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str2 + String.format("&to=%s", str)));
            intent.setPackage(d.a.SogouMap.getPackage());
            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
            com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/plugin/webview/ui/tools/jsapi/OpenMapNavigator$SogouNavigateJumper", "goNavigate", "(Landroid/content/Context;Lcom/tencent/mm/plugin/webview/ui/tools/jsapi/OpenMapNavigator$Location;Lcom/tencent/mm/plugin/webview/ui/tools/jsapi/OpenMapNavigator$Location;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            context.startActivity((Intent) bl.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/plugin/webview/ui/tools/jsapi/OpenMapNavigator$SogouNavigateJumper", "goNavigate", "(Landroid/content/Context;Lcom/tencent/mm/plugin/webview/ui/tools/jsapi/OpenMapNavigator$Location;Lcom/tencent/mm/plugin/webview/ui/tools/jsapi/OpenMapNavigator$Location;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            AppMethodBeat.o(82040);
        }

        /* access modifiers changed from: protected */
        @Override // com.tencent.mm.plugin.webview.ui.tools.jsapi.h.f
        public final String getPackageName() {
            AppMethodBeat.i(259800);
            String str = d.a.SogouMap.getPackage();
            AppMethodBeat.o(259800);
            return str;
        }
    }

    static final class b extends f {
        private b() {
            super((byte) 0);
        }

        /* synthetic */ b(byte b2) {
            this();
        }

        /* access modifiers changed from: protected */
        @Override // com.tencent.mm.plugin.webview.ui.tools.jsapi.h.f
        public final void a(Context context, e eVar, e eVar2, String str) {
            AppMethodBeat.i(82036);
            if (context == null) {
                super.a(context, eVar, eVar2, str);
                AppMethodBeat.o(82036);
                return;
            }
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(String.format("androidamap://navi?sourceApplication=%s&lat=%f&lon=%f&dev=1&style=2", "MicroMessager", Double.valueOf(eVar2.latitude), Double.valueOf(eVar2.longitude))));
            intent.addCategory("android.intent.category.DEFAULT");
            intent.setPackage(d.a.AutonaviMap.getPackage());
            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
            com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/plugin/webview/ui/tools/jsapi/OpenMapNavigator$GaodeNavigateJumper", "goNavigate", "(Landroid/content/Context;Lcom/tencent/mm/plugin/webview/ui/tools/jsapi/OpenMapNavigator$Location;Lcom/tencent/mm/plugin/webview/ui/tools/jsapi/OpenMapNavigator$Location;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            context.startActivity((Intent) bl.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/plugin/webview/ui/tools/jsapi/OpenMapNavigator$GaodeNavigateJumper", "goNavigate", "(Landroid/content/Context;Lcom/tencent/mm/plugin/webview/ui/tools/jsapi/OpenMapNavigator$Location;Lcom/tencent/mm/plugin/webview/ui/tools/jsapi/OpenMapNavigator$Location;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            AppMethodBeat.o(82036);
        }

        /* access modifiers changed from: protected */
        @Override // com.tencent.mm.plugin.webview.ui.tools.jsapi.h.f
        public final String getPackageName() {
            AppMethodBeat.i(259799);
            String str = d.a.AutonaviMap.getPackage();
            AppMethodBeat.o(259799);
            return str;
        }
    }
}

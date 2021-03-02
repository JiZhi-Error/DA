package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.text.TextUtils;
import android.view.ViewGroup;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sns.ad.e.f;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.data.k;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ah;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b;
import com.tencent.mm.pluginsdk.model.app.al;
import com.tencent.mm.sdk.platformtools.IntentUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class l extends q {
    private static a EcP;
    private static Runnable EcT = new Runnable() {
        /* class com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.l.AnonymousClass2 */

        public final void run() {
            AppMethodBeat.i(202903);
            l.access$200();
            AppMethodBeat.o(202903);
        }
    };
    private b EcQ;
    private String EcR;
    private boolean EcS;

    static /* synthetic */ void access$200() {
        AppMethodBeat.i(202923);
        fdi();
        AppMethodBeat.o(202923);
    }

    public l(Context context, b bVar, ViewGroup viewGroup) {
        super(context, bVar, viewGroup);
        AppMethodBeat.i(202910);
        this.EcQ = bVar;
        String str = "";
        if (bVar != null) {
            str = bVar.DXR != null ? bVar.DXR.getStringExtra("target_app_id") : str;
            if (TextUtils.isEmpty(str)) {
                str = bVar.LG;
            }
        }
        this.EcR = str;
        this.EcS = aPX(this.EcR);
        if (fdg() == 3) {
            H(4, 1, "");
        } else {
            H(4, 0, "");
        }
        H(1, 0, "");
        AppMethodBeat.o(202910);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.q
    public final void hWL() {
        AppMethodBeat.i(259443);
        if (this.EcS) {
            Context context = this.context;
            try {
                String nullAs = Util.nullAs(this.EcR, "");
                String nullAs2 = Util.nullAs(this.EcQ.appPageUrl, "");
                String nullAs3 = Util.nullAs(this.EcQ.DXA, "");
                String nullAs4 = Util.nullAs(this.EcQ.dNI, "");
                ah fds = fds();
                k.a(context, nullAs4, nullAs, nullAs3, nullAs2, fds.uxInfo, fds.adExtInfo, fds.getSnsId(), 1, 2);
                AppMethodBeat.o(259443);
            } catch (Throwable th) {
                AppMethodBeat.o(259443);
            }
        } else {
            Intent intent = this.EcQ.DXR;
            Context context2 = this.context;
            try {
                if (!(context2 instanceof Activity)) {
                    intent.addFlags(268435456);
                }
                ap.a(context2, intent.getPackage(), "", intent, Util.nullAs(IntentUtil.getStringExtra(intent, "market_app_name"), ""), new al() {
                    /* class com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.l.AnonymousClass1 */

                    @Override // com.tencent.mm.pluginsdk.model.app.al
                    public final void v(boolean z, boolean z2) {
                        AppMethodBeat.i(202902);
                        if (z) {
                            k.jZ(l.this.EcR, l.this.EcQ.appPageUrl);
                        }
                        AppMethodBeat.o(202902);
                    }
                }, 2);
                AppMethodBeat.o(259443);
            } catch (Throwable th2) {
                H(2, 1, "");
                AppMethodBeat.o(259443);
            }
        }
    }

    @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.q, com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m
    public final void eXe() {
        AppMethodBeat.i(202912);
        super.eXe();
        AppMethodBeat.o(202912);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.q, com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m
    public final void eWT() {
        AppMethodBeat.i(202913);
        try {
            super.eWT();
            HashMap hashMap = new HashMap();
            hashMap.put("fontNormalColor", kt(this.EcQ.DXK, "#FFFFFF"));
            hashMap.put("fontDisableColor", kt(this.EcQ.DXL, "#4CFFFFFF"));
            hashMap.put("fontPressedColor", kt(this.EcQ.DXM, "#99FFFFFF"));
            hashMap.put("NormalColor", kt(this.EcQ.DXE, "#1AAD19"));
            hashMap.put("PressedColor", kt(this.EcQ.DXG, "#179B16"));
            hashMap.put("DisableColor", kt(this.EcQ.DXF, "#661AAD19"));
            hashMap.put("borderNormalColor", kt(this.EcQ.DXH, "#179E16"));
            hashMap.put("borderPressedColor", kt(this.EcQ.DXJ, "#158E14"));
            hashMap.put("borderDisableColor", kt(this.EcQ.DXI, "#00179E16"));
            int parseColor = Color.parseColor((String) hashMap.get("fontNormalColor"));
            int parseColor2 = Color.parseColor((String) hashMap.get("fontDisableColor"));
            int parseColor3 = Color.parseColor((String) hashMap.get("fontPressedColor"));
            int parseColor4 = Color.parseColor((String) hashMap.get("NormalColor"));
            int parseColor5 = Color.parseColor((String) hashMap.get("PressedColor"));
            int parseColor6 = Color.parseColor((String) hashMap.get("DisableColor"));
            int i2 = (int) fdx().DYu;
            int parseColor7 = Color.parseColor((String) hashMap.get("borderNormalColor"));
            int parseColor8 = Color.parseColor((String) hashMap.get("borderPressedColor"));
            int parseColor9 = Color.parseColor((String) hashMap.get("borderDisableColor"));
            int dimensionPixelSize = this.context.getResources().getDimensionPixelSize(R.dimen.a0);
            if (fdx().tt > 0.0f) {
                dimensionPixelSize = (int) fdx().tt;
            }
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setShape(0);
            gradientDrawable.setCornerRadius((float) dimensionPixelSize);
            gradientDrawable.setColor(parseColor6);
            gradientDrawable.setStroke(i2, parseColor9);
            GradientDrawable gradientDrawable2 = new GradientDrawable();
            gradientDrawable2.setShape(0);
            gradientDrawable2.setCornerRadius((float) dimensionPixelSize);
            gradientDrawable2.setColor(parseColor5);
            gradientDrawable2.setStroke(i2, parseColor8);
            GradientDrawable gradientDrawable3 = new GradientDrawable();
            gradientDrawable3.setShape(0);
            gradientDrawable3.setCornerRadius((float) dimensionPixelSize);
            gradientDrawable3.setColor(parseColor4);
            gradientDrawable3.setStroke(i2, parseColor7);
            StateListDrawable stateListDrawable = new StateListDrawable();
            stateListDrawable.addState(new int[]{-16842910}, gradientDrawable);
            stateListDrawable.addState(new int[]{16842919}, gradientDrawable2);
            stateListDrawable.addState(new int[]{16842910}, gradientDrawable3);
            this.Edp.setBackground(stateListDrawable);
            int[] iArr = {parseColor2, parseColor3, parseColor};
            this.Edp.setTextColor(new ColorStateList(new int[][]{new int[]{-16842910}, new int[]{16842919}, new int[]{16842910}}, iArr));
            if (this.EcQ.fontSize > 0.0f) {
                this.Edp.setTextSize(0, this.EcQ.fontSize);
            }
            if (this.EcS && this.Edp != null) {
                this.Edp.setText(R.string.h3p);
                f.a(this.context, fdx(), this.Edp);
            }
            AppMethodBeat.o(202913);
        } catch (Throwable th) {
            Log.w("MicroMsg.AdLandingPageAppMarketBtnComp", "fill item data occur something wrong!");
            AppMethodBeat.o(202913);
        }
    }

    private static boolean aPX(String str) {
        AppMethodBeat.i(202914);
        try {
            boolean isPkgInstalled = AdLandingPagesProxy.getInstance().isPkgInstalled(str);
            AppMethodBeat.o(202914);
            return isPkgInstalled;
        } catch (Throwable th) {
            Log.w("MicroMsg.AdLandingPageAppMarketBtnComp", "isApkInstalled occur something wrong!");
            AppMethodBeat.o(202914);
            return false;
        }
    }

    private int fdg() {
        AppMethodBeat.i(202915);
        try {
            int intExtra = IntentUtil.getIntExtra(this.EcQ.DXR, "market_priority", 1);
            AppMethodBeat.o(202915);
            return intExtra;
        } catch (Throwable th) {
            Log.e("MicroMsg.AdLandingPageAppMarketBtnComp", "getMarketPriority has something wrong");
            AppMethodBeat.o(202915);
            return 0;
        }
    }

    @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m
    public final void eWZ() {
        AppMethodBeat.i(202916);
        super.eWZ();
        try {
            Log.i("MicroMsg.AdLandingPageAppMarketBtnComp", "viewWillAppear is called");
            MMHandlerThread.removeRunnable(EcT);
            fdh();
            if (EcP != null) {
                a aVar = EcP;
                if (TextUtils.isEmpty(this.EcR)) {
                    Log.w("MicroMsg.AdLandingPageAppMarketBtnComp", "the btn comp is null or target apk pkg is empty");
                    AppMethodBeat.o(202916);
                    return;
                }
                try {
                    aVar.fdj();
                    aVar.c(this);
                    AppMethodBeat.o(202916);
                    return;
                } catch (Throwable th) {
                    Log.w("MicroMsg.AdLandingPageAppMarketBtnComp", "add market btn has some error");
                }
            }
            AppMethodBeat.o(202916);
        } catch (Throwable th2) {
            Log.e("MicroMsg.AdLandingPageAppMarketBtnComp", "processor registerPkgReceiver error");
            AppMethodBeat.o(202916);
        }
    }

    @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m
    public final void eXd() {
        AppMethodBeat.i(202917);
        super.eXd();
        try {
            Log.i("MicroMsg.AdLandingPageAppMarketBtnComp", "viewWillDestroy is called");
            MMHandlerThread.removeRunnable(EcT);
            MMHandlerThread.postToMainThreadDelayed(EcT, 300000);
            AppMethodBeat.o(202917);
        } catch (Throwable th) {
            Log.e("MicroMsg.AdLandingPageAppMarketBtnComp", "remove mProcessorForUnregisterPkgReceiver error");
            AppMethodBeat.o(202917);
        }
    }

    private static String kt(String str, String str2) {
        AppMethodBeat.i(202918);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(202918);
            return str2;
        } else if (str.matches("#[0-9A-Fa-f]{6}([0-9A-Fa-f]{2})?")) {
            AppMethodBeat.o(202918);
            return str;
        } else {
            AppMethodBeat.o(202918);
            return str2;
        }
    }

    private void H(int i2, int i3, String str) {
        AppMethodBeat.i(202919);
        try {
            a(fds(), i2, String.valueOf(i3), str);
            AppMethodBeat.o(202919);
        } catch (Throwable th) {
            Log.e("MicroMsg.AdLandingPageAppMarketBtnComp", "report19790 exp:" + th.toString());
            AppMethodBeat.o(202919);
        }
    }

    static {
        AppMethodBeat.i(202925);
        AppMethodBeat.o(202925);
    }

    private static synchronized void fdh() {
        synchronized (l.class) {
            AppMethodBeat.i(202920);
            try {
                if (EcP == null) {
                    EcP = new a((byte) 0);
                    IntentFilter intentFilter = new IntentFilter();
                    intentFilter.addAction("android.intent.action.PACKAGE_ADDED");
                    intentFilter.addAction("android.intent.action.PACKAGE_REMOVED");
                    intentFilter.addDataScheme("package");
                    MMApplicationContext.getContext().registerReceiver(EcP, intentFilter);
                    Log.i("MicroMsg.AdLandingPageAppMarketBtnComp", "the broadcast receiver register");
                }
                AppMethodBeat.o(202920);
            } catch (Throwable th) {
                Log.w("MicroMsg.AdLandingPageAppMarketBtnComp", "register broadcast receiver failed");
                AppMethodBeat.o(202920);
            }
        }
    }

    private static synchronized void fdi() {
        synchronized (l.class) {
            AppMethodBeat.i(202921);
            try {
                if (EcP != null) {
                    MMApplicationContext.getContext().unregisterReceiver(EcP);
                    EcP = null;
                    Log.i("MicroMsg.AdLandingPageAppMarketBtnComp", "the broadcast receiver unregister");
                }
                AppMethodBeat.o(202921);
            } catch (Throwable th) {
                Log.w("MicroMsg.AdLandingPageAppMarketBtnComp", "unregister broadcast receiver failed");
                AppMethodBeat.o(202921);
            }
        }
    }

    static void a(ah ahVar, int i2, String str, String str2) {
        AppMethodBeat.i(202922);
        try {
            String nullAsNil = Util.nullAsNil(ahVar.getSnsId());
            String aNZ = i.aNZ(ahVar.uxInfo);
            String nullAsNil2 = Util.nullAsNil(ahVar.adExtInfo);
            h.INSTANCE.a(19790, nullAsNil, aNZ, nullAsNil2, Integer.valueOf(i2), str, str2);
            Log.d("MicroMsg.AdLandingPageAppMarketBtnComp", "report19790 snsId=" + nullAsNil + ", uxInfo=" + aNZ + ", adExtInfo =" + nullAsNil2 + ", actType =" + i2 + ", actValue = " + str + ", extInfo = " + str2);
            AppMethodBeat.o(202922);
        } catch (Exception e2) {
            Log.e("MicroMsg.AdLandingPageAppMarketBtnComp", "report19790 exp:" + e2.toString());
            AppMethodBeat.o(202922);
        }
    }

    /* access modifiers changed from: package-private */
    public static class a extends BroadcastReceiver {
        final List<WeakReference<l>> EcV;
        final Map<String, ah> EcW;

        private a() {
            AppMethodBeat.i(202904);
            this.EcV = new LinkedList();
            this.EcW = new ConcurrentHashMap();
            AppMethodBeat.o(202904);
        }

        /* synthetic */ a(byte b2) {
            this();
        }

        /* access modifiers changed from: package-private */
        public final synchronized void c(l lVar) {
            AppMethodBeat.i(202905);
            Iterator<WeakReference<l>> it = this.EcV.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (it.next().get() == lVar) {
                        Log.d("MicroMsg.AdLandingPageAppMarketBtnComp", "refs contains the btn comp");
                        AppMethodBeat.o(202905);
                        break;
                    }
                } else {
                    this.EcV.add(new WeakReference<>(lVar));
                    this.EcW.put(lVar.EcR, lVar.fds());
                    AppMethodBeat.o(202905);
                    break;
                }
            }
        }

        /* access modifiers changed from: package-private */
        public final synchronized void fdj() {
            AppMethodBeat.i(202906);
            Iterator<WeakReference<l>> it = this.EcV.iterator();
            while (it.hasNext()) {
                WeakReference<l> next = it.next();
                if (next == null || next.get() == null) {
                    it.remove();
                }
            }
            AppMethodBeat.o(202906);
        }

        public final void onReceive(Context context, Intent intent) {
            AppMethodBeat.i(202907);
            if (intent != null) {
                try {
                    String action = intent.getAction();
                    if ("android.intent.action.PACKAGE_ADDED".equals(action)) {
                        String aW = aW(intent);
                        if (!TextUtils.isEmpty(aW)) {
                            e(aW, true, context.getString(R.string.h3p));
                            try {
                                ah ahVar = this.EcW.get(aW);
                                if (ahVar != null) {
                                    l.a(ahVar, 3, AppEventsConstants.EVENT_PARAM_VALUE_NO, "");
                                }
                                AppMethodBeat.o(202907);
                                return;
                            } catch (Throwable th) {
                                Log.e("MicroMsg.AdLandingPageAppMarketBtnComp", "report error?");
                            }
                        }
                        AppMethodBeat.o(202907);
                        return;
                    }
                    if ("android.intent.action.PACKAGE_REMOVED".equals(action)) {
                        String aW2 = aW(intent);
                        if (!TextUtils.isEmpty(aW2)) {
                            e(aW2, false, "");
                        }
                    }
                    AppMethodBeat.o(202907);
                    return;
                } catch (Throwable th2) {
                    Log.e("MicroMsg.AdLandingPageAppMarketBtnComp", "there is a exception in receiver");
                }
            }
            AppMethodBeat.o(202907);
        }

        private synchronized void e(String str, boolean z, String str2) {
            AppMethodBeat.i(202908);
            for (WeakReference<l> weakReference : this.EcV) {
                if (!(weakReference == null || weakReference.get() == null)) {
                    l lVar = weakReference.get();
                    if (str.equals(lVar.EcR)) {
                        lVar.EcS = z;
                        if (z) {
                            l.a(lVar, str2);
                        } else {
                            l.a(lVar, lVar.EcQ.title);
                        }
                    }
                }
            }
            AppMethodBeat.o(202908);
        }

        private static String aW(Intent intent) {
            AppMethodBeat.i(202909);
            try {
                String schemeSpecificPart = intent.getData().getSchemeSpecificPart();
                AppMethodBeat.o(202909);
                return schemeSpecificPart;
            } catch (Throwable th) {
                AppMethodBeat.o(202909);
                return "";
            }
        }
    }

    static /* synthetic */ void a(l lVar, String str) {
        AppMethodBeat.i(202924);
        if (lVar.Edp != null) {
            lVar.Edp.setText(str);
            f.a(lVar.context, lVar.fdx(), lVar.Edp);
        }
        AppMethodBeat.o(202924);
    }
}

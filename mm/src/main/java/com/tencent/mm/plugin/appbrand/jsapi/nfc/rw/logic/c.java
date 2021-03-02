package com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.logic;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentFilter;
import android.nfc.NdefMessage;
import android.nfc.NfcAdapter;
import android.nfc.Tag;
import android.nfc.tech.IsoDep;
import android.nfc.tech.MifareClassic;
import android.nfc.tech.MifareUltralight;
import android.nfc.tech.Ndef;
import android.nfc.tech.NfcA;
import android.nfc.tech.NfcB;
import android.nfc.tech.NfcF;
import android.nfc.tech.NfcV;
import android.nfc.tech.TagTechnology;
import android.os.Parcelable;
import com.facebook.internal.NativeProtocol;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.h;
import com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.a.b;
import com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.logic.e;
import com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.o;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.system.AndroidContextUtil;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.g.a.q;
import kotlin.g.b.p;
import kotlin.t;
import kotlin.x;

@kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000º\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u0003\n\u0002\b\u0002*\u0002\u001e8\b\u0016\u0018\u0000 c2\u00020\u0001:\u0001cB\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010<\u001a\u00020*H\u0002J\b\u0010=\u001a\u00020*H\u0002JA\u0010>\u001a\u00020*2\u0006\u0010?\u001a\u00020\u000321\u0010@\u001a-\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020*0A¢\u0006\f\b#\u0012\b\b$\u0012\u0004\b\b(B\u0012\u0004\u0012\u00020*0\fj\b\u0012\u0004\u0012\u00020*`CJA\u0010D\u001a\u00020*2\u0006\u0010?\u001a\u00020\u000321\u0010@\u001a-\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020*0A¢\u0006\f\b#\u0012\b\b$\u0012\u0004\b\b(B\u0012\u0004\u0012\u00020*0\fj\b\u0012\u0004\u0012\u00020*`CJ(\u0010E\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010A2\u0006\u0010?\u001a\u00020\u00032\u0006\u0010F\u001a\u00020\u00032\b\u0010G\u001a\u0004\u0018\u00010HJW\u0010I\u001a\u00020*2\u0006\u0010?\u001a\u00020\u00032\u0006\u0010F\u001a\u00020\u00032\b\u0010G\u001a\u0004\u0018\u00010H25\u0010@\u001a1\u0012\u001b\u0012\u0019\u0012\u0006\u0012\u0004\u0018\u00010\u00010A¢\u0006\f\b#\u0012\b\b$\u0012\u0004\b\b(B\u0012\u0004\u0012\u00020*0\fj\n\u0012\u0006\u0012\u0004\u0018\u00010\u0001`CJA\u0010J\u001a\u00020*2\u0006\u0010?\u001a\u00020\u000321\u0010@\u001a-\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020K0A¢\u0006\f\b#\u0012\b\b$\u0012\u0004\b\b(B\u0012\u0004\u0012\u00020*0\fj\b\u0012\u0004\u0012\u00020K`CJN\u0010L\u001a\u0004\u0018\u00010\u0015\"\u0006\b\u0000\u0010M\u0018\u00012\u0006\u0010?\u001a\u00020\u000321\u0010@\u001a-\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u0002HM0A¢\u0006\f\b#\u0012\b\b$\u0012\u0004\b\b(B\u0012\u0004\u0012\u00020*0\fj\b\u0012\u0004\u0012\u0002HM`CH\bJF\u0010N\u001a\u0004\u0018\u00010;\"\u0006\b\u0000\u0010M\u0018\u000121\u0010@\u001a-\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u0002HM0A¢\u0006\f\b#\u0012\b\b$\u0012\u0004\b\b(B\u0012\u0004\u0012\u00020*0\fj\b\u0012\u0004\u0012\u0002HM`CH\bJV\u0010O\u001a\u0004\u0018\u00010P\"\u0006\b\u0000\u0010M\u0018\u00012\u0006\u0010Q\u001a\u00020\u00152\u0006\u0010R\u001a\u00020;21\u0010@\u001a-\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u0002HM0A¢\u0006\f\b#\u0012\b\b$\u0012\u0004\b\b(B\u0012\u0004\u0012\u00020*0\fj\b\u0012\u0004\u0012\u0002HM`CH\bJA\u0010S\u001a\u00020*2\u0006\u0010?\u001a\u00020\u000321\u0010@\u001a-\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u000e0A¢\u0006\f\b#\u0012\b\b$\u0012\u0004\b\b(B\u0012\u0004\u0012\u00020*0\fj\b\u0012\u0004\u0012\u00020\u000e`CJ\b\u0010T\u001a\u00020*H\u0002J\b\u0010U\u001a\u00020*H\u0002JI\u0010V\u001a\u00020*2\u0006\u0010?\u001a\u00020\u00032\u0006\u0010W\u001a\u00020K21\u0010@\u001a-\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020*0A¢\u0006\f\b#\u0012\b\b$\u0012\u0004\b\b(B\u0012\u0004\u0012\u00020*0\fj\b\u0012\u0004\u0012\u00020*`CJ9\u0010X\u001a\u00020*21\u0010@\u001a-\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020*0A¢\u0006\f\b#\u0012\b\b$\u0012\u0004\b\b(B\u0012\u0004\u0012\u00020*0\fj\b\u0012\u0004\u0012\u00020*`CJ9\u0010Y\u001a\u00020*21\u0010@\u001a-\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020*0A¢\u0006\f\b#\u0012\b\b$\u0012\u0004\b\b(B\u0012\u0004\u0012\u00020*0\fj\b\u0012\u0004\u0012\u00020*`CJI\u0010Z\u001a\u00020*2\u0006\u0010?\u001a\u00020\u00032\u0006\u0010[\u001a\u00020\"21\u0010@\u001a-\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\"0A¢\u0006\f\b#\u0012\b\b$\u0012\u0004\b\b(B\u0012\u0004\u0012\u00020*0\fj\b\u0012\u0004\u0012\u00020\"`CJ\u0010\u0010\\\u001a\u00020*2\u0006\u0010]\u001a\u00020\rH\u0016J\u0018\u0010^\u001a\n\u0012\u0004\u0012\u00020(\u0018\u00010&2\u0006\u0010]\u001a\u00020\rH\u0002JA\u0010_\u001a\u00020*2\u0006\u0010`\u001a\u00020(21\u0010@\u001a-\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020*0A¢\u0006\f\b#\u0012\b\b$\u0012\u0004\b\b(B\u0012\u0004\u0012\u00020*0\fj\b\u0012\u0004\u0012\u00020*`CJ\u000e\u0010a\u001a\u0004\u0018\u00010b*\u00020bH\u0002R\u0014\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\fX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R2\u0010\u0013\u001a&\u0012\f\u0012\n \u0016*\u0004\u0018\u00010\u00150\u0015 \u0016*\u0012\u0012\f\u0012\n \u0016*\u0004\u0018\u00010\u00150\u0015\u0018\u00010\u00170\u0014X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u00020\u001eX\u0004¢\u0006\u0004\n\u0002\u0010\u001fRw\u0010 \u001a_\u0012\u0015\u0012\u0013\u0018\u00010\"¢\u0006\f\b#\u0012\b\b$\u0012\u0004\b\b(%\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00030&¢\u0006\f\b#\u0012\b\b$\u0012\u0004\b\b('\u0012\u001b\u0012\u0019\u0012\u0004\u0012\u00020(\u0018\u00010&¢\u0006\f\b#\u0012\b\b$\u0012\u0004\b\b()\u0012\u0004\u0012\u00020*\u0018\u00010!j\u0004\u0018\u0001`+X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u0016\u00100\u001a\n \u0016*\u0004\u0018\u00010101X\u0004¢\u0006\u0002\n\u0000R\u001a\u00102\u001a\u00020\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\u0010\u00107\u001a\u000208X\u0004¢\u0006\u0004\n\u0002\u00109R\u0010\u0010:\u001a\u0004\u0018\u00010;X\u000e¢\u0006\u0002\n\u0000¨\u0006d"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/logic/NFCReadWriteManager;", "", "appId", "", EnvConsts.ACTIVITY_MANAGER_SRVNAME, "Landroid/app/Activity;", "component", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "(Ljava/lang/String;Landroid/app/Activity;Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;)V", "getActivity", "()Landroid/app/Activity;", "activityEventInterceptor", "Lkotlin/Function1;", "Landroid/content/Intent;", "", "getAppId", "()Ljava/lang/String;", "getComponent", "()Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "connectedTech", "", "Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/model/NFCTech;", "kotlin.jvm.PlatformType", "", "isActivityEventInterceptorAdded", "isLifeCycleListenerAdded", "isNFCDiscovering", "Ljava/util/concurrent/atomic/AtomicBoolean;", "isNFCDiscoverySticky", "lifeCycleListener", "com/tencent/mm/plugin/appbrand/jsapi/nfc/rw/logic/NFCReadWriteManager$lifeCycleListener$1", "Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/logic/NFCReadWriteManager$lifeCycleListener$1;", "nfcTagDiscoveredCallback", "Lkotlin/Function3;", "", "Lkotlin/ParameterName;", "name", "id", "", "techs", "Landroid/nfc/NdefMessage;", "ndefMessages", "", "Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/logic/NFCTagDiscoveredCallback;", "getNfcTagDiscoveredCallback", "()Lkotlin/jvm/functions/Function3;", "setNfcTagDiscoveredCallback", "(Lkotlin/jvm/functions/Function3;)V", BaseGmsClient.KEY_PENDING_INTENT, "Landroid/app/PendingIntent;", "requireForegroundDispatch", "getRequireForegroundDispatch", "()Z", "setRequireForegroundDispatch", "(Z)V", "sysNfcSwitchToggleListener", "com/tencent/mm/plugin/appbrand/jsapi/nfc/rw/logic/NFCReadWriteManager$sysNfcSwitchToggleListener$1", "Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/logic/NFCReadWriteManager$sysNfcSwitchToggleListener$1;", "tag", "Landroid/nfc/Tag;", "addActivityEventInterceptorOnce", "addLifeCycleListenerOnce", "close", "techName", "callback", "Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/logic/NFCReadWriteResult;", "result", "Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/logic/NFCReadWriteCallback;", "connect", "execTechLogic", "function", NativeProtocol.WEB_DIALOG_PARAMS, "Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/model/INFCTechExecParams;", "execTechLogicAsync", "getMaxTransceiveLength", "", "getNFCTech", "T", "getTag", "getTagTechnology", "Landroid/nfc/tech/TagTechnology;", "nfcTech", "tagSnapshot", "isConnected", "removeActivityEventInterceptorIfNecessary", "removeLifeCycleListenerIfNecessary", "setTimeout", "timeoutMs", com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.m.NAME, com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.n.NAME, "transceive", "reqData", "tryDispatchNfcTagDiscovered", "intent", "tryParseMessageMap", o.NAME, "message", "wrappedThrowable", "", "Companion", "luggage-commons-jsapi-nfc-ext_release"})
public class c {
    private static final Map<String, c> miK = new ConcurrentHashMap();
    private static final IntentFilter[] miL;
    private static final String[][] miM = {new String[]{NfcA.class.getName()}, new String[]{NfcB.class.getName()}, new String[]{IsoDep.class.getName()}, new String[]{NfcF.class.getName()}, new String[]{NfcV.class.getName()}, new String[]{MifareClassic.class.getName()}, new String[]{MifareUltralight.class.getName()}, new String[]{Ndef.class.getName()}};
    private static a.AbstractC0689a miN = new b();
    public static final a miO = new a((byte) 0);
    final Activity activity;
    public final String appId;
    protected final com.tencent.mm.plugin.appbrand.jsapi.f lqg;
    public volatile q<? super byte[], ? super List<String>, ? super List<NdefMessage>, x> miA;
    private boolean miB;
    private final kotlin.g.a.b<Intent, Boolean> miC = new C0690c(this);
    private final AtomicBoolean miD = new AtomicBoolean(false);
    private boolean miE;
    private boolean miF;
    private final i miG = new i(this);
    private volatile Tag miH;
    private final Set<com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.a.b> miI = Collections.newSetFromMap(new ConcurrentHashMap());
    private final NFCReadWriteManager$sysNfcSwitchToggleListener$1 miJ = new NFCReadWriteManager$sysNfcSwitchToggleListener$1(this);
    private volatile boolean miz;
    private final PendingIntent pendingIntent = PendingIntent.getActivity(this.activity, 0, new Intent(this.activity, this.activity.getClass()).addFlags(536870912), 0);

    public static final boolean u(com.tencent.mm.plugin.appbrand.jsapi.f fVar) {
        AppMethodBeat.i(207161);
        boolean u = a.u(fVar);
        AppMethodBeat.o(207161);
        return u;
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", "intent", "Landroid/content/Intent;", "invoke"})
    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.logic.c$c  reason: collision with other inner class name */
    static final class C0690c extends kotlin.g.b.q implements kotlin.g.a.b<Intent, Boolean> {
        final /* synthetic */ c miP;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C0690c(c cVar) {
            super(1);
            this.miP = cVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARNING: Code restructure failed: missing block: B:11:0x006d, code lost:
            if (r0.equals("android.nfc.action.TAG_DISCOVERED") != false) goto L_0x003f;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:8:0x003d, code lost:
            if (r0.equals("android.nfc.action.TECH_DISCOVERED") != false) goto L_0x003f;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:9:0x003f, code lost:
            com.tencent.mm.sdk.platformtools.Log.d("MicroMsg.AppBrand.NFCReadWriteManager", "onNewIntent, tech/tag discovered");
            r4.miP.miI.clear();
            r4.miP.miH = (android.nfc.Tag) r5.getParcelableExtra("android.nfc.extra.TAG");
            r4.miP.E(r5);
            r0 = true;
         */
        @Override // kotlin.g.a.b
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final /* synthetic */ java.lang.Boolean invoke(android.content.Intent r5) {
            /*
            // Method dump skipped, instructions count: 122
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.logic.c.C0690c.invoke(java.lang.Object):java.lang.Object");
        }
    }

    public c(String str, Activity activity2, com.tencent.mm.plugin.appbrand.jsapi.f fVar) {
        p.h(str, "appId");
        p.h(activity2, EnvConsts.ACTIVITY_MANAGER_SRVNAME);
        p.h(fVar, "component");
        AppMethodBeat.i(207159);
        this.appId = str;
        this.activity = activity2;
        this.lqg = fVar;
        this.activity.registerReceiver(this.miJ, new IntentFilter("android.nfc.action.ADAPTER_STATE_CHANGED"));
        com.tencent.mm.plugin.appbrand.h.a(this.appId, new h.c(this) {
            /* class com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.logic.c.AnonymousClass1 */
            final /* synthetic */ c miP;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            {
                this.miP = r1;
            }

            @Override // com.tencent.mm.plugin.appbrand.h.c
            public final void onDestroy() {
                AppMethodBeat.i(183669);
                super.onDestroy();
                Log.d("MicroMsg.AppBrand.NFCReadWriteManager", "onDestroy");
                this.miP.activity.unregisterReceiver(this.miP.miJ);
                c.miK.remove(this.miP.appId);
                AppMethodBeat.o(183669);
            }
        });
        AppMethodBeat.o(207159);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001:\u0001\"B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u001b\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u001c\u001a\u00020\u001dH\u0007J\u0010\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u001c\u001a\u00020\u001dH\u0007J\u0010\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u000eH\u0002J\u0012\u0010\u001e\u001a\u00020\u001f2\b\u0010!\u001a\u0004\u0018\u00010\u0006H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u000e0\rX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016X\u0004¢\u0006\u0004\n\u0002\u0010\u0018R\u001c\u0010\u0019\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00160\u0016X\u0004¢\u0006\u0004\n\u0002\u0010\u001a¨\u0006#"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/logic/NFCReadWriteManager$Companion;", "", "()V", "INVALID_NFC_ADAPTER_STATE", "", "METHOD_NAME_GET", "", "METHOD_NAME_GET_MAX_TRANSCEIVE_LENGTH", "METHOD_NAME_SET_TIMEOUT", "METHOD_NAME_TRANSCEIVE", "NFC_IO_LOOP_TAG", "TAG", "appId2ManagerMap", "", "Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/logic/NFCReadWriteManager;", "factory", "Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/logic/NFCReadWriteManager$Companion$IFactory;", "getFactory", "()Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/logic/NFCReadWriteManager$Companion$IFactory;", "setFactory", "(Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/logic/NFCReadWriteManager$Companion$IFactory;)V", "intentFiltersArray", "", "Landroid/content/IntentFilter;", "[Landroid/content/IntentFilter;", "techListsArray", "[[Ljava/lang/String;", "get", "component", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "isNFCUsing", "", "manager", "appId", "IFactory", "luggage-commons-jsapi-nfc-ext_release"})
    public static final class a {

        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&¨\u0006\n"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/logic/NFCReadWriteManager$Companion$IFactory;", "", "createNFCReadWriteManager", "Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/logic/NFCReadWriteManager;", "appId", "", EnvConsts.ACTIVITY_MANAGER_SRVNAME, "Landroid/app/Activity;", "component", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "luggage-commons-jsapi-nfc-ext_release"})
        /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.logic.c$a$a  reason: collision with other inner class name */
        public interface AbstractC0689a {
            c a(String str, Activity activity, com.tencent.mm.plugin.appbrand.jsapi.f fVar);
        }

        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static void b(AbstractC0689a aVar) {
            AppMethodBeat.i(207148);
            p.h(aVar, "<set-?>");
            c.miN = aVar;
            AppMethodBeat.o(207148);
        }

        public static c w(com.tencent.mm.plugin.appbrand.jsapi.f fVar) {
            AppMethodBeat.i(183670);
            p.h(fVar, "component");
            c cVar = (c) c.miK.get(fVar.getAppId());
            if (cVar == null) {
                Activity castActivityOrNull = AndroidContextUtil.castActivityOrNull(fVar.getContext());
                if (castActivityOrNull != null) {
                    a aVar = c.miO;
                    AbstractC0689a aVar2 = c.miN;
                    String appId = fVar.getAppId();
                    p.g(appId, "component.appId");
                    p.g(castActivityOrNull, EnvConsts.ACTIVITY_MANAGER_SRVNAME);
                    c a2 = aVar2.a(appId, castActivityOrNull, fVar);
                    Map map = c.miK;
                    String appId2 = fVar.getAppId();
                    p.g(appId2, "component.appId");
                    map.put(appId2, a2);
                    AppMethodBeat.o(183670);
                    return a2;
                }
                cVar = null;
            }
            AppMethodBeat.o(183670);
            return cVar;
        }

        public static boolean u(com.tencent.mm.plugin.appbrand.jsapi.f fVar) {
            AppMethodBeat.i(207149);
            p.h(fVar, "component");
            c w = w(fVar);
            if (w == null) {
                Log.i("MicroMsg.AppBrand.NFCReadWriteManager", "isNFCUsing, manager is null, not using");
                AppMethodBeat.o(207149);
                return false;
            }
            boolean k = k(w);
            AppMethodBeat.o(207149);
            return k;
        }

        private static boolean k(c cVar) {
            boolean z;
            AppMethodBeat.i(207150);
            if (cVar.miD.get()) {
                Log.i("MicroMsg.AppBrand.NFCReadWriteManager", "isNFCUsing, isDiscovering, using");
                AppMethodBeat.o(207150);
                return true;
            }
            Set set = cVar.miI;
            p.g(set, "manager.connectedTech");
            if (!set.isEmpty()) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                Log.i("MicroMsg.AppBrand.NFCReadWriteManager", "isNFCUsing, connected, using");
                AppMethodBeat.o(207150);
                return true;
            }
            Log.i("MicroMsg.AppBrand.NFCReadWriteManager", "isNFCUsing, not using");
            AppMethodBeat.o(207150);
            return false;
        }
    }

    static {
        AppMethodBeat.i(183681);
        IntentFilter[] intentFilterArr = new IntentFilter[1];
        IntentFilter intentFilter = new IntentFilter("android.nfc.action.TAG_DISCOVERED");
        try {
            intentFilter.addDataType("*/*");
        } catch (IntentFilter.MalformedMimeTypeException e2) {
            Log.w("MicroMsg.AppBrand.NFCReadWriteManager", "addDataType failed");
        }
        intentFilterArr[0] = intentFilter;
        miL = intentFilterArr;
        AppMethodBeat.o(183681);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, hxF = {"com/tencent/mm/plugin/appbrand/jsapi/nfc/rw/logic/NFCReadWriteManager$Companion$factory$1", "Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/logic/NFCReadWriteManager$Companion$IFactory;", "createNFCReadWriteManager", "Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/logic/NFCReadWriteManager;", "appId", "", EnvConsts.ACTIVITY_MANAGER_SRVNAME, "Landroid/app/Activity;", "component", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "luggage-commons-jsapi-nfc-ext_release"})
    public static final class b implements a.AbstractC0689a {
        b() {
        }

        @Override // com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.logic.c.a.AbstractC0689a
        public final c a(String str, Activity activity, com.tencent.mm.plugin.appbrand.jsapi.f fVar) {
            AppMethodBeat.i(207147);
            p.h(str, "appId");
            p.h(activity, EnvConsts.ACTIVITY_MANAGER_SRVNAME);
            p.h(fVar, "component");
            c cVar = new c(str, activity, fVar);
            AppMethodBeat.o(207147);
            return cVar;
        }
    }

    public void hK(boolean z) {
        this.miz = z;
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0003H\u0016¨\u0006\u0007"}, hxF = {"com/tencent/mm/plugin/appbrand/jsapi/nfc/rw/logic/NFCReadWriteManager$lifeCycleListener$1", "Lcom/tencent/mm/plugin/appbrand/AppBrandLifeCycle$Listener;", "onPause", "", "type", "Lcom/tencent/mm/plugin/appbrand/AppBrandLifeCycle$PauseType;", "onResume", "luggage-commons-jsapi-nfc-ext_release"})
    public static final class i extends h.c {
        final /* synthetic */ c miP;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        i(c cVar) {
            this.miP = cVar;
        }

        @Override // com.tencent.mm.plugin.appbrand.h.c
        public final void onResume() {
            AppMethodBeat.i(183673);
            super.onResume();
            Log.d("MicroMsg.AppBrand.NFCReadWriteManager", "onResume");
            if (this.miP.miE) {
                Log.i("MicroMsg.AppBrand.NFCReadWriteManager", "onResume, isNFCDiscoverySticky");
                if (this.miP.activity instanceof com.tencent.mm.plugin.appbrand.jsapi.nfc.b) {
                    ((com.tencent.mm.plugin.appbrand.jsapi.nfc.b) this.miP.activity).bHJ();
                }
                NfcAdapter defaultAdapter = NfcAdapter.getDefaultAdapter(MMApplicationContext.getContext());
                if (defaultAdapter == null || true != defaultAdapter.isEnabled()) {
                    Log.i("MicroMsg.AppBrand.NFCReadWriteManager", "onResume, nfc is not enabled");
                    AppMethodBeat.o(183673);
                    return;
                }
                try {
                    Log.i("MicroMsg.AppBrand.NFCReadWriteManager", "enableForegroundDispatch");
                    NfcAdapter defaultAdapter2 = NfcAdapter.getDefaultAdapter(MMApplicationContext.getContext());
                    if (defaultAdapter2 != null) {
                        defaultAdapter2.enableForegroundDispatch(this.miP.activity, this.miP.pendingIntent, c.miL, c.miM);
                    }
                    this.miP.miD.set(true);
                } catch (Exception e2) {
                    Log.w("MicroMsg.AppBrand.NFCReadWriteManager", "enableForegroundDispatch failed since ".concat(String.valueOf(e2)));
                }
                this.miP.miE = false;
            }
            AppMethodBeat.o(183673);
        }

        @Override // com.tencent.mm.plugin.appbrand.h.c
        public final void a(h.d dVar) {
            AppMethodBeat.i(183674);
            super.a(dVar);
            Log.d("MicroMsg.AppBrand.NFCReadWriteManager", "onPause");
            if (this.miP.miD.getAndSet(false)) {
                Log.i("MicroMsg.AppBrand.NFCReadWriteManager", "onPause, isNFCDiscovering");
                try {
                    Log.i("MicroMsg.AppBrand.NFCReadWriteManager", "disableForegroundDispatch");
                    NfcAdapter defaultAdapter = NfcAdapter.getDefaultAdapter(MMApplicationContext.getContext());
                    if (defaultAdapter != null) {
                        defaultAdapter.disableForegroundDispatch(this.miP.activity);
                    }
                } catch (Exception e2) {
                    Log.w("MicroMsg.AppBrand.NFCReadWriteManager", "disableForegroundDispatch failed since ".concat(String.valueOf(e2)));
                }
                this.miP.miE = true;
            }
            AppMethodBeat.o(183674);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class k implements Runnable {
        final /* synthetic */ kotlin.g.a.b gWe;
        final /* synthetic */ c miP;

        public k(c cVar, kotlin.g.a.b bVar) {
            this.miP = cVar;
            this.gWe = bVar;
        }

        public final void run() {
            AppMethodBeat.i(183675);
            if (this.miP.miD.get()) {
                this.gWe.invoke(new e.a(13021, "NFC discovery already started"));
                AppMethodBeat.o(183675);
                return;
            }
            try {
                Log.i("MicroMsg.AppBrand.NFCReadWriteManager", "enableForegroundDispatch");
                NfcAdapter defaultAdapter = NfcAdapter.getDefaultAdapter(MMApplicationContext.getContext());
                if (defaultAdapter == null) {
                    p.hyc();
                }
                defaultAdapter.enableForegroundDispatch(this.miP.activity, this.miP.pendingIntent, c.miL, c.miM);
                c.c(this.miP);
                this.gWe.invoke(new e.b(x.SXb));
                this.miP.miD.set(true);
                c.d(this.miP);
                AppMethodBeat.o(183675);
            } catch (Exception e2) {
                Log.w("MicroMsg.AppBrand.NFCReadWriteManager", "enableForegroundDispatch failed since ".concat(String.valueOf(e2)));
                this.gWe.invoke(new e.a(13017, "system internal error"));
                AppMethodBeat.o(183675);
            }
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class l implements Runnable {
        final /* synthetic */ kotlin.g.a.b gWe;
        final /* synthetic */ c miP;

        public l(c cVar, kotlin.g.a.b bVar) {
            this.miP = cVar;
            this.gWe = bVar;
        }

        public final void run() {
            AppMethodBeat.i(183676);
            this.miP.miE = false;
            if (!this.miP.miD.get()) {
                this.gWe.invoke(new e.a(13018, "NFC discovery has not started"));
                AppMethodBeat.o(183676);
                return;
            }
            try {
                Log.i("MicroMsg.AppBrand.NFCReadWriteManager", "disableForegroundDispatch");
                NfcAdapter defaultAdapter = NfcAdapter.getDefaultAdapter(MMApplicationContext.getContext());
                if (defaultAdapter == null) {
                    p.hyc();
                }
                defaultAdapter.disableForegroundDispatch(this.miP.activity);
                c.f(this.miP);
                this.gWe.invoke(new e.b(x.SXb));
                this.miP.miD.set(false);
                c.g(this.miP);
                AppMethodBeat.o(183676);
            } catch (Exception e2) {
                Log.w("MicroMsg.AppBrand.NFCReadWriteManager", "disableForegroundDispatch failed since ".concat(String.valueOf(e2)));
                this.gWe.invoke(new e.a(13017, "system internal error"));
                AppMethodBeat.o(183676);
            }
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class e implements Runnable {
        final /* synthetic */ kotlin.g.a.b gWe;
        final /* synthetic */ c miP;
        final /* synthetic */ String miQ;

        public e(c cVar, kotlin.g.a.b bVar, String str) {
            this.miP = cVar;
            this.gWe = bVar;
            this.miQ = str;
        }

        public final void run() {
            TagTechnology tagTechnology;
            AppMethodBeat.i(207152);
            c cVar = this.miP;
            kotlin.g.a.b bVar = this.gWe;
            Tag tag = cVar.miH;
            if (tag == null) {
                bVar.invoke(new e.a(13013, "NFC tag has not been discovered"));
            }
            if (tag == null) {
                AppMethodBeat.o(207152);
                return;
            }
            String str = this.miQ;
            kotlin.g.a.b bVar2 = this.gWe;
            b.a aVar = com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.a.b.mjo;
            com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.a.b bVar3 = (com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.a.b) com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.a.b.bId().get(str);
            if (bVar3 == null) {
                bVar2.invoke(new e.a(13014, "invalid tech"));
            }
            if (bVar3 == null) {
                AppMethodBeat.o(207152);
            } else if (this.miP.miI.contains(bVar3)) {
                this.gWe.invoke(new e.a(13022, "Tech already connected"));
                AppMethodBeat.o(207152);
            } else {
                try {
                    Object obj = org.a.a.bF(org.a.a.forName(bVar3.mjk)).u("get", tag).object;
                    if (obj == null) {
                        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Required value was null.".toString());
                        AppMethodBeat.o(207152);
                        throw illegalArgumentException;
                    }
                    tagTechnology = (TagTechnology) obj;
                    if (tagTechnology == null) {
                        AppMethodBeat.o(207152);
                        return;
                    }
                    try {
                        tagTechnology.connect();
                        this.miP.miI.add(bVar3);
                        this.gWe.invoke(new e.b(x.SXb));
                        AppMethodBeat.o(207152);
                    } catch (Exception e2) {
                        Log.w("MicroMsg.AppBrand.NFCReadWriteManager", "connect failed since ".concat(String.valueOf(e2)));
                        this.gWe.invoke(new e.a(13017, "system internal error"));
                        AppMethodBeat.o(207152);
                    }
                } catch (Exception e3) {
                    this.gWe.invoke(new e.a(13015, "unavailable tech"));
                    tagTechnology = null;
                }
            }
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class d implements Runnable {
        final /* synthetic */ kotlin.g.a.b gWe;
        final /* synthetic */ c miP;
        final /* synthetic */ String miQ;

        public d(c cVar, kotlin.g.a.b bVar, String str) {
            this.miP = cVar;
            this.gWe = bVar;
            this.miQ = str;
        }

        public final void run() {
            TagTechnology tagTechnology;
            AppMethodBeat.i(207151);
            c cVar = this.miP;
            kotlin.g.a.b bVar = this.gWe;
            Tag tag = cVar.miH;
            if (tag == null) {
                bVar.invoke(new e.a(13013, "NFC tag has not been discovered"));
            }
            if (tag == null) {
                AppMethodBeat.o(207151);
                return;
            }
            String str = this.miQ;
            kotlin.g.a.b bVar2 = this.gWe;
            b.a aVar = com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.a.b.mjo;
            com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.a.b bVar3 = (com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.a.b) com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.a.b.bId().get(str);
            if (bVar3 == null) {
                bVar2.invoke(new e.a(13014, "invalid tech"));
            }
            if (bVar3 == null) {
                AppMethodBeat.o(207151);
            } else if (!this.miP.miI.contains(bVar3)) {
                this.gWe.invoke(new e.a(13023, "Tech has not connected"));
                AppMethodBeat.o(207151);
            } else {
                try {
                    Object obj = org.a.a.bF(org.a.a.forName(bVar3.mjk)).u("get", tag).object;
                    if (obj == null) {
                        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Required value was null.".toString());
                        AppMethodBeat.o(207151);
                        throw illegalArgumentException;
                    }
                    tagTechnology = (TagTechnology) obj;
                    if (tagTechnology == null) {
                        AppMethodBeat.o(207151);
                        return;
                    }
                    try {
                        tagTechnology.close();
                    } catch (Exception e2) {
                        Log.i("MicroMsg.AppBrand.NFCReadWriteManager", "close failed since ".concat(String.valueOf(e2)));
                    }
                    this.miP.miI.remove(bVar3);
                    this.gWe.invoke(new e.b(x.SXb));
                    AppMethodBeat.o(207151);
                } catch (Exception e3) {
                    this.gWe.invoke(new e.a(13015, "unavailable tech"));
                    tagTechnology = null;
                }
            }
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class h implements Runnable {
        final /* synthetic */ kotlin.g.a.b gWe;
        final /* synthetic */ c miP;
        final /* synthetic */ String miQ;

        public h(c cVar, kotlin.g.a.b bVar, String str) {
            this.miP = cVar;
            this.gWe = bVar;
            this.miQ = str;
        }

        public final void run() {
            TagTechnology tagTechnology;
            AppMethodBeat.i(207154);
            c cVar = this.miP;
            kotlin.g.a.b bVar = this.gWe;
            Tag tag = cVar.miH;
            if (tag == null) {
                bVar.invoke(new e.a(13013, "NFC tag has not been discovered"));
            }
            if (tag == null) {
                AppMethodBeat.o(207154);
                return;
            }
            String str = this.miQ;
            kotlin.g.a.b bVar2 = this.gWe;
            b.a aVar = com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.a.b.mjo;
            com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.a.b bVar3 = (com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.a.b) com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.a.b.bId().get(str);
            if (bVar3 == null) {
                bVar2.invoke(new e.a(13014, "invalid tech"));
            }
            if (bVar3 == null) {
                AppMethodBeat.o(207154);
                return;
            }
            try {
                Object obj = org.a.a.bF(org.a.a.forName(bVar3.mjk)).u("get", tag).object;
                if (obj == null) {
                    IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Required value was null.".toString());
                    AppMethodBeat.o(207154);
                    throw illegalArgumentException;
                }
                tagTechnology = (TagTechnology) obj;
                if (tagTechnology == null) {
                    AppMethodBeat.o(207154);
                    return;
                }
                try {
                    this.gWe.invoke(new e.b(Boolean.valueOf(tagTechnology.isConnected())));
                    AppMethodBeat.o(207154);
                } catch (Exception e2) {
                    Log.i("MicroMsg.AppBrand.NFCReadWriteManager", "check isConnected failed since ".concat(String.valueOf(e2)));
                    this.gWe.invoke(new e.a(13017, "system internal error"));
                    AppMethodBeat.o(207154);
                }
            } catch (Exception e3) {
                this.gWe.invoke(new e.a(13015, "unavailable tech"));
                tagTechnology = null;
            }
        }
    }

    public final void a(NdefMessage ndefMessage, kotlin.g.a.b<? super e<x>, x> bVar) {
        AppMethodBeat.i(183679);
        p.h(ndefMessage, "message");
        p.h(bVar, "callback");
        Log.d("MicroMsg.AppBrand.NFCReadWriteManager", "writeNdefMessage, message: ".concat(String.valueOf(ndefMessage)));
        com.tencent.f.h.RTc.b(new n(this, bVar, ndefMessage), "NFC-IO");
        AppMethodBeat.o(183679);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class n implements Runnable {
        final /* synthetic */ kotlin.g.a.b gWe;
        final /* synthetic */ c miP;
        final /* synthetic */ NdefMessage miV;

        n(c cVar, kotlin.g.a.b bVar, NdefMessage ndefMessage) {
            this.miP = cVar;
            this.gWe = bVar;
            this.miV = ndefMessage;
        }

        public final void run() {
            AppMethodBeat.i(183678);
            c cVar = this.miP;
            kotlin.g.a.b bVar = this.gWe;
            Tag tag = cVar.miH;
            if (tag == null) {
                bVar.invoke(new e.a(13013, "NFC tag has not been discovered"));
            }
            if (tag == null) {
                AppMethodBeat.o(183678);
                return;
            }
            Ndef ndef = Ndef.get(tag);
            if (ndef == null) {
                this.gWe.invoke(new e.a(13015, "unavailable tech"));
                AppMethodBeat.o(183678);
                return;
            }
            try {
                ndef.writeNdefMessage(this.miV);
                this.gWe.invoke(new e.b(x.SXb));
                AppMethodBeat.o(183678);
            } catch (Exception e2) {
                Log.w("MicroMsg.AppBrand.NFCReadWriteManager", "writeNdefMessage failed since ".concat(String.valueOf(e2)));
                this.gWe.invoke(new e.a(13017, "system internal error"));
                AppMethodBeat.o(183678);
            }
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class g implements Runnable {
        final /* synthetic */ kotlin.g.a.b gWe;
        final /* synthetic */ c miP;
        final /* synthetic */ String miQ;

        public g(c cVar, kotlin.g.a.b bVar, String str) {
            this.miP = cVar;
            this.gWe = bVar;
            this.miQ = str;
        }

        public final void run() {
            TagTechnology tagTechnology;
            String str;
            AppMethodBeat.i(183672);
            c cVar = this.miP;
            kotlin.g.a.b bVar = this.gWe;
            Tag tag = cVar.miH;
            if (tag == null) {
                bVar.invoke(new e.a(13013, "NFC tag has not been discovered"));
            }
            if (tag == null) {
                AppMethodBeat.o(183672);
                return;
            }
            String str2 = this.miQ;
            kotlin.g.a.b bVar2 = this.gWe;
            b.a aVar = com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.a.b.mjo;
            com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.a.b bVar3 = (com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.a.b) com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.a.b.bId().get(str2);
            if (bVar3 == null) {
                bVar2.invoke(new e.a(13014, "invalid tech"));
            }
            if (bVar3 == null) {
                AppMethodBeat.o(183672);
            } else if (com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.a.b.NDEF == bVar3) {
                this.gWe.invoke(new e.a(13024, "function not support"));
                AppMethodBeat.o(183672);
            } else {
                try {
                    Object obj = org.a.a.bF(org.a.a.forName(bVar3.mjk)).u("get", tag).object;
                    if (obj == null) {
                        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Required value was null.".toString());
                        AppMethodBeat.o(183672);
                        throw illegalArgumentException;
                    }
                    tagTechnology = (TagTechnology) obj;
                    if (tagTechnology == null) {
                        AppMethodBeat.o(183672);
                        return;
                    }
                    try {
                        Integer num = (Integer) org.a.a.gG(tagTechnology).bvt("getMaxTransceiveLength").object;
                        kotlin.g.a.b bVar4 = this.gWe;
                        p.g(num, "length");
                        bVar4.invoke(new e.b(num));
                        AppMethodBeat.o(183672);
                    } catch (Exception e2) {
                        Throwable g2 = c.g(e2);
                        Log.w("MicroMsg.AppBrand.NFCReadWriteManager", "getMaxTransceiveLength failed since ".concat(String.valueOf(g2)));
                        kotlin.g.a.b bVar5 = this.gWe;
                        StringBuilder sb = new StringBuilder("system internal error: ");
                        if (g2 != null) {
                            str = g2.getMessage();
                        } else {
                            str = null;
                        }
                        bVar5.invoke(new e.a(13017, sb.append(str).toString()));
                        AppMethodBeat.o(183672);
                    }
                } catch (Exception e3) {
                    this.gWe.invoke(new e.a(13015, "unavailable tech"));
                    tagTechnology = null;
                }
            }
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class j implements Runnable {
        final /* synthetic */ kotlin.g.a.b gWe;
        final /* synthetic */ c miP;
        final /* synthetic */ String miQ;
        final /* synthetic */ int miT;

        public j(c cVar, kotlin.g.a.b bVar, String str, int i2) {
            this.miP = cVar;
            this.gWe = bVar;
            this.miQ = str;
            this.miT = i2;
        }

        public final void run() {
            TagTechnology tagTechnology;
            String str;
            AppMethodBeat.i(207155);
            c cVar = this.miP;
            kotlin.g.a.b bVar = this.gWe;
            Tag tag = cVar.miH;
            if (tag == null) {
                bVar.invoke(new e.a(13013, "NFC tag has not been discovered"));
            }
            if (tag == null) {
                AppMethodBeat.o(207155);
                return;
            }
            String str2 = this.miQ;
            kotlin.g.a.b bVar2 = this.gWe;
            b.a aVar = com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.a.b.mjo;
            com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.a.b bVar3 = (com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.a.b) com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.a.b.bId().get(str2);
            if (bVar3 == null) {
                bVar2.invoke(new e.a(13014, "invalid tech"));
            }
            if (bVar3 == null) {
                AppMethodBeat.o(207155);
                return;
            }
            Class[] clsArr = {Integer.TYPE};
            p.h("setTimeout", "name");
            p.h(clsArr, "parameterTypes");
            b.C0687b bVar4 = new b.C0687b("setTimeout", clsArr);
            Boolean bool = bVar3.mjj.get(bVar4);
            if (bool == null) {
                bool = (Boolean) new b.c(bVar4, bVar3, "setTimeout", clsArr).invoke();
            }
            p.g(bool, "MethodSignature(name, pa…            }()\n        }");
            if (!bool.booleanValue()) {
                Log.i("MicroMsg.AppBrand.NFCReadWriteManager", "setTimeout, " + bVar3.mhN + ".setTimeout is not supported");
                this.gWe.invoke(new e.a(13024, "function not support"));
                AppMethodBeat.o(207155);
                return;
            }
            try {
                Object obj = org.a.a.bF(org.a.a.forName(bVar3.mjk)).u("get", tag).object;
                if (obj == null) {
                    IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Required value was null.".toString());
                    AppMethodBeat.o(207155);
                    throw illegalArgumentException;
                }
                tagTechnology = (TagTechnology) obj;
                if (tagTechnology == null) {
                    AppMethodBeat.o(207155);
                    return;
                }
                try {
                    org.a.a.gG(tagTechnology).u("setTimeout", Integer.valueOf(this.miT));
                    this.gWe.invoke(new e.b(x.SXb));
                    AppMethodBeat.o(207155);
                } catch (Exception e2) {
                    Throwable g2 = c.g(e2);
                    Log.w("MicroMsg.AppBrand.NFCReadWriteManager", "setTimeout failed since ".concat(String.valueOf(g2)));
                    kotlin.g.a.b bVar5 = this.gWe;
                    StringBuilder sb = new StringBuilder("system internal error: ");
                    if (g2 != null) {
                        str = g2.getMessage();
                    } else {
                        str = null;
                    }
                    bVar5.invoke(new e.a(13017, sb.append(str).toString()));
                    AppMethodBeat.o(207155);
                }
            } catch (Exception e3) {
                this.gWe.invoke(new e.a(13015, "unavailable tech"));
                tagTechnology = null;
            }
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class m implements Runnable {
        final /* synthetic */ kotlin.g.a.b gWe;
        final /* synthetic */ c miP;
        final /* synthetic */ String miQ;
        final /* synthetic */ byte[] miU;

        public m(c cVar, kotlin.g.a.b bVar, String str, byte[] bArr) {
            this.miP = cVar;
            this.gWe = bVar;
            this.miQ = str;
            this.miU = bArr;
        }

        public final void run() {
            TagTechnology tagTechnology;
            String str;
            String str2;
            AppMethodBeat.i(183677);
            c cVar = this.miP;
            kotlin.g.a.b bVar = this.gWe;
            Tag tag = cVar.miH;
            if (tag == null) {
                bVar.invoke(new e.a(13013, "NFC tag has not been discovered"));
            }
            if (tag == null) {
                AppMethodBeat.o(183677);
                return;
            }
            String str3 = this.miQ;
            kotlin.g.a.b bVar2 = this.gWe;
            b.a aVar = com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.a.b.mjo;
            com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.a.b bVar3 = (com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.a.b) com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.a.b.bId().get(str3);
            if (bVar3 == null) {
                bVar2.invoke(new e.a(13014, "invalid tech"));
            }
            if (bVar3 == null) {
                AppMethodBeat.o(183677);
            } else if (com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.a.b.NDEF == bVar3) {
                this.gWe.invoke(new e.a(13024, "function not support"));
                AppMethodBeat.o(183677);
            } else {
                try {
                    Object obj = org.a.a.bF(org.a.a.forName(bVar3.mjk)).u("get", tag).object;
                    if (obj == null) {
                        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Required value was null.".toString());
                        AppMethodBeat.o(183677);
                        throw illegalArgumentException;
                    }
                    tagTechnology = (TagTechnology) obj;
                    if (tagTechnology == null) {
                        AppMethodBeat.o(183677);
                        return;
                    }
                    try {
                        byte[] bArr = (byte[]) org.a.a.gG(tagTechnology).u("transceive", this.miU).object;
                        StringBuilder sb = new StringBuilder("transceive, rspData: ");
                        if (bArr != null) {
                            str2 = Arrays.toString(bArr);
                            p.g(str2, "java.util.Arrays.toString(this)");
                        } else {
                            str2 = null;
                        }
                        Log.d("MicroMsg.AppBrand.NFCReadWriteManager", sb.append(str2).toString());
                        kotlin.g.a.b bVar4 = this.gWe;
                        p.g(bArr, "rspData");
                        bVar4.invoke(new e.b(bArr));
                        AppMethodBeat.o(183677);
                    } catch (Exception e2) {
                        Throwable g2 = c.g(e2);
                        Log.w("MicroMsg.AppBrand.NFCReadWriteManager", "transceive failed since ".concat(String.valueOf(g2)));
                        kotlin.g.a.b bVar5 = this.gWe;
                        StringBuilder sb2 = new StringBuilder("system internal error: ");
                        if (g2 != null) {
                            str = g2.getMessage();
                        } else {
                            str = null;
                        }
                        bVar5.invoke(new e.a(13017, sb2.append(str).toString()));
                        AppMethodBeat.o(183677);
                    }
                } catch (Exception e3) {
                    this.gWe.invoke(new e.a(13015, "unavailable tech"));
                    tagTechnology = null;
                }
            }
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class f implements Runnable {
        final /* synthetic */ kotlin.g.a.b gWe;
        final /* synthetic */ c miP;
        final /* synthetic */ String miQ;
        final /* synthetic */ String miR;
        final /* synthetic */ com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.a.a miS = null;

        public f(c cVar, kotlin.g.a.b bVar, String str, String str2) {
            this.miP = cVar;
            this.gWe = bVar;
            this.miQ = str;
            this.miR = str2;
        }

        public final void run() {
            AppMethodBeat.i(207153);
            c cVar = this.miP;
            kotlin.g.a.b bVar = this.gWe;
            Tag tag = cVar.miH;
            if (tag == null) {
                bVar.invoke(new e.a(13013, "NFC tag has not been discovered"));
            }
            if (tag == null) {
                AppMethodBeat.o(207153);
                return;
            }
            String str = this.miQ;
            kotlin.g.a.b bVar2 = this.gWe;
            b.a aVar = com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.a.b.mjo;
            com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.a.b bVar3 = (com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.a.b) com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.a.b.bId().get(str);
            if (bVar3 == null) {
                bVar2.invoke(new e.a(13014, "invalid tech"));
            }
            if (bVar3 == null) {
                AppMethodBeat.o(207153);
                return;
            }
            a aVar2 = bVar3.mjl;
            if (aVar2 == null) {
                this.gWe.invoke(new e.a(13024, "function not support"));
                AppMethodBeat.o(207153);
                return;
            }
            aVar2.a(tag, this.miR, this.gWe);
            AppMethodBeat.o(207153);
        }
    }

    public void E(Intent intent) {
        Tag tag;
        String[] techList;
        String str;
        List<NdefMessage> list = null;
        AppMethodBeat.i(207157);
        p.h(intent, "intent");
        Log.d("MicroMsg.AppBrand.NFCReadWriteManager", "tryDispatchNfcTagDiscovered");
        q<? super byte[], ? super List<String>, ? super List<NdefMessage>, x> qVar = this.miA;
        if (qVar == null || (tag = this.miH) == null || (techList = tag.getTechList()) == null) {
            AppMethodBeat.o(207157);
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (String str2 : techList) {
            b.a aVar = com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.a.b.mjo;
            String str3 = (String) com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.a.b.bIe().get(str2);
            if (str3 != null) {
                arrayList.add(str3);
            }
        }
        ArrayList arrayList2 = arrayList;
        byte[] byteArrayExtra = intent.getByteArrayExtra("android.nfc.extra.ID");
        StringBuilder sb = new StringBuilder("tryDispatchNfcTagDiscovered, id: ");
        if (byteArrayExtra != null) {
            str = Arrays.toString(byteArrayExtra);
            p.g(str, "java.util.Arrays.toString(this)");
        } else {
            str = null;
        }
        Log.i("MicroMsg.AppBrand.NFCReadWriteManager", sb.append(str).append(", techs: ").append(arrayList2).toString());
        if (!arrayList2.isEmpty()) {
            if (arrayList2.contains(com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.a.b.NDEF.mhN)) {
                list = F(intent);
            }
            qVar.d(byteArrayExtra, arrayList2, list);
        }
        AppMethodBeat.o(207157);
    }

    private static List<NdefMessage> F(Intent intent) {
        AppMethodBeat.i(207158);
        Log.d("MicroMsg.AppBrand.NFCReadWriteManager", "tryParseMessageMap");
        Parcelable[] parcelableArrayExtra = intent.getParcelableArrayExtra("android.nfc.extra.NDEF_MESSAGES");
        if (parcelableArrayExtra != null) {
            StringBuilder sb = new StringBuilder("tryDispatchNdefMessagesRead, rawMessages: ");
            String arrays = Arrays.toString(parcelableArrayExtra);
            p.g(arrays, "java.util.Arrays.toString(this)");
            Log.i("MicroMsg.AppBrand.NFCReadWriteManager", sb.append(arrays).toString());
            ArrayList arrayList = new ArrayList(parcelableArrayExtra.length);
            for (Parcelable parcelable : parcelableArrayExtra) {
                if (parcelable == null) {
                    t tVar = new t("null cannot be cast to non-null type android.nfc.NdefMessage");
                    AppMethodBeat.o(207158);
                    throw tVar;
                }
                arrayList.add((NdefMessage) parcelable);
            }
            ArrayList arrayList2 = arrayList;
            AppMethodBeat.o(207158);
            return arrayList2;
        }
        AppMethodBeat.o(207158);
        return null;
    }

    public static final /* synthetic */ void c(c cVar) {
        Object obj;
        AppMethodBeat.i(183682);
        Log.d("MicroMsg.AppBrand.NFCReadWriteManager", "addActivityEventInterceptorOnce");
        if (!cVar.miB) {
            String str = cVar.appId;
            kotlin.g.a.b<Intent, Boolean> bVar = cVar.miC;
            if (bVar != null) {
                obj = new d(bVar);
            } else {
                obj = bVar;
            }
            com.tencent.mm.plugin.appbrand.h.a(str, (h.a) obj);
            cVar.miB = true;
        }
        AppMethodBeat.o(183682);
    }

    public static final /* synthetic */ void d(c cVar) {
        AppMethodBeat.i(183683);
        Log.d("MicroMsg.AppBrand.NFCReadWriteManager", "addLifeCycleListenerOnce");
        if (!cVar.miF) {
            com.tencent.mm.plugin.appbrand.h.a(cVar.appId, cVar.miG);
            cVar.miF = true;
        }
        AppMethodBeat.o(183683);
    }

    public static final /* synthetic */ void f(c cVar) {
        Object obj;
        AppMethodBeat.i(183684);
        Log.d("MicroMsg.AppBrand.NFCReadWriteManager", "removeActivityEventInterceptorIfNecessary");
        if (cVar.miB) {
            String str = cVar.appId;
            kotlin.g.a.b<Intent, Boolean> bVar = cVar.miC;
            if (bVar != null) {
                obj = new d(bVar);
            } else {
                obj = bVar;
            }
            com.tencent.mm.plugin.appbrand.h.b(str, (h.a) obj);
            cVar.miB = false;
        }
        AppMethodBeat.o(183684);
    }

    public static final /* synthetic */ void g(c cVar) {
        AppMethodBeat.i(183685);
        Log.d("MicroMsg.AppBrand.NFCReadWriteManager", "removeLifeCycleListenerIfNecessary");
        if (cVar.miF) {
            com.tencent.mm.plugin.appbrand.h.b(cVar.appId, cVar.miG);
            cVar.miF = false;
        }
        AppMethodBeat.o(183685);
    }

    public static final /* synthetic */ Throwable g(Throwable th) {
        AppMethodBeat.i(207160);
        if (th instanceof org.a.b) {
            Throwable cause = th.getCause();
            if (cause != null) {
                Throwable cause2 = cause.getCause();
                AppMethodBeat.o(207160);
                return cause2;
            }
            AppMethodBeat.o(207160);
            return null;
        }
        AppMethodBeat.o(207160);
        return th;
    }
}

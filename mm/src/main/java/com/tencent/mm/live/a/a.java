package com.tencent.mm.live.a;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.ContentObserver;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.ViewGroup;
import com.tencent.map.geolocation.sapp.internal.TencentExtraKeys;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.data.APMidasPluginInfo;
import com.tencent.mm.live.api.LiveConfig;
import com.tencent.mm.live.b.o;
import com.tencent.mm.live.view.BaseLivePluginLayout;
import com.tencent.mm.live.view.LiveAnchorPluginLayout;
import com.tencent.mm.live.view.LiveVisitorPluginLayout;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.tools.g;
import com.tencent.mm.ui.tools.h;
import java.lang.reflect.Constructor;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;
import kotlin.x;
import org.xwalk.core.XWalkEnvironment;

@l(hxD = {1, 1, 16}, hxE = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001:\u00016B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0016\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\t2\u0006\u0010\"\u001a\u00020#J\u001c\u0010$\u001a\u00020 2\u0006\u0010%\u001a\u00020#2\n\u0010&\u001a\u0006\u0012\u0002\b\u00030\u001eH\u0002J\u0006\u0010'\u001a\u00020 J \u0010(\u001a\u00020 2\u0006\u0010)\u001a\u00020#2\u0006\u0010*\u001a\u00020#2\b\u0010+\u001a\u0004\u0018\u00010,J\u0006\u0010-\u001a\u00020\tJ\u0006\u0010.\u001a\u00020 J\u0006\u0010/\u001a\u00020 J\u0006\u00100\u001a\u00020 J\u0006\u00101\u001a\u00020 J\u0006\u00102\u001a\u00020 J\u0006\u00103\u001a\u00020 J\u0010\u00104\u001a\u00020 2\u0006\u00105\u001a\u00020#H\u0016R\u000e\u0010\u000b\u001a\u00020\fXD¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0004¢\u0006\u0002\n\u0000R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u000e0\u001cX\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u001d\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u001e0\u001cX\u0004¢\u0006\u0002\n\u0000¨\u00067"}, hxF = {"Lcom/tencent/mm/live/controller/LiveUIRouter;", "Lcom/tencent/mm/live/controller/ILiveUINavigation;", "context", "Landroid/content/Context;", "root", "Landroid/view/ViewGroup;", "provider", "Lcom/tencent/mm/live/api/LiveConfig;", "isFinished", "", "(Landroid/content/Context;Landroid/view/ViewGroup;Lcom/tencent/mm/live/api/LiveConfig;Z)V", "TAG", "", "currentView", "Lcom/tencent/mm/live/view/BaseLivePluginLayout;", "()Z", "isKeyBoardShow", "keyboardHeightProvider", "Lcom/tencent/mm/ui/tools/KeyboardHeightProvider;", "phoneStatelistener", "Landroid/telephony/PhoneStateListener;", "getProvider", "()Lcom/tencent/mm/live/api/LiveConfig;", "rotationSwitchObserver", "Lcom/tencent/mm/live/controller/LiveUIRouter$RotationSwitchObserver;", "sp", "Landroid/content/SharedPreferences;", "viewMap", "Landroid/util/SparseArray;", "viewTable", "Ljava/lang/Class;", "keyboardChange", "", "show", "height", "", "loadViewFromClass", "key", "clazz", "maximizeUi", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onBackPressed", "onCreate", "onDestroy", "onPause", "onResume", "onStart", "onStop", TencentExtraKeys.LOCATION_KEY_ROUTE, "toWhere", "RotationSwitchObserver", "plugin-logic_release"})
public final class a {
    public final String TAG = "MicroMsg.LiveUIRouter";
    public final Context context;
    public h gyh;
    public final C0369a hwm;
    private final SparseArray<Class<?>> hwn;
    private final SparseArray<BaseLivePluginLayout> hwo;
    public BaseLivePluginLayout hwp;
    boolean hwq;
    private final ViewGroup hwr;
    private final LiveConfig hws;
    private final boolean isFinished;
    public final PhoneStateListener phoneStatelistener;
    public final SharedPreferences sp;

    public a(Context context2, ViewGroup viewGroup, LiveConfig liveConfig, boolean z) {
        p.h(context2, "context");
        p.h(viewGroup, "root");
        AppMethodBeat.i(207548);
        this.context = context2;
        this.hwr = viewGroup;
        this.hws = liveConfig;
        this.isFinished = z;
        SharedPreferences sharedPreferences = this.context.getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 4);
        p.g(sharedPreferences, "context.getSharedPrefere…ntext.MODE_MULTI_PROCESS)");
        this.sp = sharedPreferences;
        this.hwm = new C0369a(new Handler(Looper.getMainLooper()), new d(this));
        this.hwn = new SparseArray<>();
        this.hwo = new SparseArray<>();
        this.phoneStatelistener = new c(this);
        Log.i(this.TAG, APMidasPluginInfo.LAUNCH_INTERFACE_INIT);
        SparseArray<Class<?>> sparseArray = this.hwn;
        o.k kVar = o.k.hHn;
        sparseArray.put(o.k.aFM(), LiveAnchorPluginLayout.class);
        SparseArray<Class<?>> sparseArray2 = this.hwn;
        o.k kVar2 = o.k.hHn;
        sparseArray2.put(o.k.aFN(), LiveVisitorPluginLayout.class);
        AppMethodBeat.o(207548);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, hxF = {"com/tencent/mm/live/controller/LiveUIRouter$phoneStatelistener$1", "Landroid/telephony/PhoneStateListener;", "onCallStateChanged", "", "state", "", "incomingNumber", "", "plugin-logic_release"})
    public static final class c extends PhoneStateListener {
        final /* synthetic */ a hwv;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        c(a aVar) {
            this.hwv = aVar;
        }

        public final void onCallStateChanged(int i2, String str) {
            AppMethodBeat.i(207544);
            p.h(str, "incomingNumber");
            BaseLivePluginLayout baseLivePluginLayout = this.hwv.hwp;
            if (baseLivePluginLayout != null) {
                baseLivePluginLayout.onCallStateChanged(i2, str);
                AppMethodBeat.o(207544);
                return;
            }
            AppMethodBeat.o(207544);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class b implements Runnable {
        final /* synthetic */ a hwv;

        public b(a aVar) {
            this.hwv = aVar;
        }

        public final void run() {
            AppMethodBeat.i(207543);
            if (this.hwv.gyh == null) {
                a aVar = this.hwv;
                Context context = this.hwv.context;
                if (context == null) {
                    t tVar = new t("null cannot be cast to non-null type android.app.Activity");
                    AppMethodBeat.o(207543);
                    throw tVar;
                }
                aVar.gyh = new h((Activity) context);
                h hVar = this.hwv.gyh;
                if (hVar != null) {
                    hVar.setKeyboardHeightObserver(new g(this) {
                        /* class com.tencent.mm.live.a.a.b.AnonymousClass1 */
                        final /* synthetic */ b hww;

                        {
                            this.hww = r1;
                        }

                        @Override // com.tencent.mm.ui.tools.g
                        public final void y(int i2, boolean z) {
                            boolean z2;
                            AppMethodBeat.i(207542);
                            Log.i(this.hww.hwv.TAG, "onKeyboardHeightChanged, height:" + i2 + ", isResized:" + z);
                            a aVar = this.hww.hwv;
                            if (i2 > 0) {
                                z2 = true;
                            } else {
                                z2 = false;
                            }
                            if (aVar.hwq != z2) {
                                aVar.hwq = z2;
                                BaseLivePluginLayout baseLivePluginLayout = aVar.hwp;
                                if (baseLivePluginLayout != null) {
                                    baseLivePluginLayout.keyboardChange(z2, i2);
                                    AppMethodBeat.o(207542);
                                    return;
                                }
                            }
                            AppMethodBeat.o(207542);
                        }
                    });
                }
            }
            h hVar2 = this.hwv.gyh;
            if (hVar2 != null) {
                hVar2.start();
                AppMethodBeat.o(207543);
                return;
            }
            AppMethodBeat.o(207543);
        }
    }

    public final void onDestroy() {
        AppMethodBeat.i(207546);
        Log.i(this.TAG, "onDestroy " + this.hwp);
        int size = this.hwo.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.hwo.valueAt(i2).unMount();
        }
        Object systemService = this.context.getSystemService("phone");
        if (systemService == null) {
            t tVar = new t("null cannot be cast to non-null type android.telephony.TelephonyManager");
            AppMethodBeat.o(207546);
            throw tVar;
        }
        TelephonyManager telephonyManager = (TelephonyManager) systemService;
        com.tencent.mm.hellhoundlib.b.a bl = com.tencent.mm.hellhoundlib.b.c.a(0, new com.tencent.mm.hellhoundlib.b.a()).bl(this.phoneStatelistener);
        com.tencent.mm.hellhoundlib.a.a.a(telephonyManager, bl.axQ(), "com/tencent/mm/live/controller/LiveUIRouter", "onDestroy", "()V", "android/telephony/TelephonyManager_EXEC_", "listen", "(Landroid/telephony/PhoneStateListener;I)V");
        telephonyManager.listen((PhoneStateListener) bl.pG(0), ((Integer) bl.pG(1)).intValue());
        com.tencent.mm.hellhoundlib.a.a.a(telephonyManager, "com/tencent/mm/live/controller/LiveUIRouter", "onDestroy", "()V", "android/telephony/TelephonyManager_EXEC_", "listen", "(Landroid/telephony/PhoneStateListener;I)V");
        AppMethodBeat.o(207546);
    }

    public final void qp(int i2) {
        AppMethodBeat.i(207547);
        if (this.hwo.get(i2) == null) {
            Class<?> cls = this.hwn.get(i2);
            p.g(cls, "viewTable[toWhere]");
            try {
                Constructor<?> constructor = cls.getConstructor(Context.class, AttributeSet.class);
                p.g(constructor, "clazz.getConstructor(Con…AttributeSet::class.java)");
                Object newInstance = constructor.newInstance(this.context, null);
                if (newInstance == null) {
                    t tVar = new t("null cannot be cast to non-null type com.tencent.mm.live.view.BaseLivePluginLayout");
                    AppMethodBeat.o(207547);
                    throw tVar;
                }
                BaseLivePluginLayout baseLivePluginLayout = (BaseLivePluginLayout) newInstance;
                LiveConfig liveConfig = this.hws;
                if (liveConfig == null) {
                    liveConfig = LiveConfig.V("", LiveConfig.hvS);
                    p.g(liveConfig, "LiveConfig.getDefaultAnc…ig.SCENE_CHATTING_FOOTER)");
                }
                baseLivePluginLayout.initLogic(liveConfig, this.isFinished);
                this.hwo.put(i2, baseLivePluginLayout);
                this.hwr.addView(baseLivePluginLayout, new ViewGroup.LayoutParams(-1, -1));
                baseLivePluginLayout.setVisibility(8);
            } catch (Exception e2) {
                Log.printErrStackTrace(this.TAG, e2, "", new Object[0]);
            }
        }
        BaseLivePluginLayout baseLivePluginLayout2 = this.hwp;
        this.hwp = this.hwo.get(i2);
        BaseLivePluginLayout baseLivePluginLayout3 = this.hwp;
        if (baseLivePluginLayout3 != null) {
            baseLivePluginLayout3.mount();
        }
        BaseLivePluginLayout baseLivePluginLayout4 = this.hwp;
        if (baseLivePluginLayout4 != null) {
            baseLivePluginLayout4.bringToFront();
        }
        if (baseLivePluginLayout2 != null) {
            baseLivePluginLayout2.pause();
            AppMethodBeat.o(207547);
            return;
        }
        AppMethodBeat.o(207547);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u001f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\u0002\u0010\u0007J\u0010\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0006\u0010\u0013\u001a\u00020\u0006J\u0006\u0010\u0014\u001a\u00020\u0006R\u001a\u0010\b\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0019\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0015"}, hxF = {"Lcom/tencent/mm/live/controller/LiveUIRouter$RotationSwitchObserver;", "Landroid/database/ContentObserver;", "handler", "Landroid/os/Handler;", "onChangCallback", "Lkotlin/Function0;", "", "(Landroid/os/Handler;Lkotlin/jvm/functions/Function0;)V", "mResolver", "Landroid/content/ContentResolver;", "getMResolver", "()Landroid/content/ContentResolver;", "setMResolver", "(Landroid/content/ContentResolver;)V", "getOnChangCallback", "()Lkotlin/jvm/functions/Function0;", "onChange", "selfChange", "", "startObserver", "stopObserver", "plugin-logic_release"})
    /* renamed from: com.tencent.mm.live.a.a$a  reason: collision with other inner class name */
    public static final class C0369a extends ContentObserver {
        public ContentResolver hwt;
        private final kotlin.g.a.a<x> hwu;

        public C0369a(Handler handler, kotlin.g.a.a<x> aVar) {
            super(handler);
            AppMethodBeat.i(207541);
            this.hwu = aVar;
            ContentResolver contentResolver = XWalkEnvironment.getContentResolver();
            p.g(contentResolver, "getContentResolver()");
            this.hwt = contentResolver;
            AppMethodBeat.o(207541);
        }

        public final void onChange(boolean z) {
            AppMethodBeat.i(207540);
            super.onChange(z);
            kotlin.g.a.a<x> aVar = this.hwu;
            if (aVar != null) {
                aVar.invoke();
                AppMethodBeat.o(207540);
                return;
            }
            AppMethodBeat.o(207540);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class d extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ a hwv;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(a aVar) {
            super(0);
            this.hwv = aVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            boolean z = true;
            AppMethodBeat.i(207545);
            BaseLivePluginLayout baseLivePluginLayout = this.hwv.hwp;
            if (baseLivePluginLayout != null) {
                if (Settings.System.getInt(XWalkEnvironment.getContentResolver(), "accelerometer_rotation") != 1 || !this.hwv.sp.getBoolean("settings_landscape_mode", false)) {
                    z = false;
                }
                baseLivePluginLayout.onRotationSwitchChange(z);
            }
            x xVar = x.SXb;
            AppMethodBeat.o(207545);
            return xVar;
        }
    }
}

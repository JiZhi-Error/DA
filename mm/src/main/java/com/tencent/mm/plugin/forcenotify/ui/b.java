package com.tencent.mm.plugin.forcenotify.ui;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.app.KeyguardManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Looper;
import android.os.PowerManager;
import android.os.Vibrator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.AccelerateInterpolator;
import android.widget.ImageView;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.app.AppForegroundDelegate;
import com.tencent.mm.g.a.abl;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.forcenotify.c.f;
import com.tencent.mm.plugin.forcenotify.ui.view.KeyEventConstraintLayout;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.PlaySound;
import com.tencent.mm.ui.ao;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.g;
import java.util.ArrayList;

@kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000´\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 e2\u00020\u0001:\u0001eB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010C\u001a\u00020+H\u0002J\b\u0010D\u001a\u00020EH\u0002J\b\u0010F\u001a\u00020EH\u0002J\b\u0010G\u001a\u00020EH\u0002J\u0006\u0010H\u001a\u00020EJ\b\u0010I\u001a\u00020+H\u0002J\u0010\u0010J\u001a\u00020E2\u0006\u0010K\u001a\u00020LH\u0002J\u0010\u0010M\u001a\u00020E2\u0006\u0010K\u001a\u00020NH\u0002J\b\u0010O\u001a\u00020EH\u0002J\b\u0010P\u001a\u00020EH\u0002J$\u0010Q\u001a\u00020+2\b\u0010R\u001a\u0004\u0018\u00010)2\u0006\u0010S\u001a\u00020\u00182\b\u0010T\u001a\u0004\u0018\u00010UH\u0016J\b\u0010V\u001a\u00020EH\u0003J\u0010\u0010W\u001a\u00020E2\u0006\u0010X\u001a\u00020+H\u0002J\b\u0010Y\u001a\u00020EH\u0002J\u0016\u0010Z\u001a\u00020E2\f\u0010[\u001a\b\u0012\u0004\u0012\u00020E0\\H\u0002J\b\u0010]\u001a\u00020EH\u0002J\b\u0010^\u001a\u00020EH\u0002J\u000e\u0010_\u001a\u00020E2\u0006\u0010`\u001a\u00020+J\b\u0010a\u001a\u00020EH\u0002J\b\u0010b\u001a\u00020EH\u0002J\f\u0010c\u001a\u00020+*\u00020'H\u0002J\f\u0010d\u001a\u00020+*\u00020'H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R#\u0010\r\u001a\n \u000f*\u0004\u0018\u00010\u000e0\u000e8BX\u0002¢\u0006\f\n\u0004\b\u0012\u0010\n\u001a\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0013\u001a\u0012\u0012\u0004\u0012\u00020\u00150\u0014j\b\u0012\u0004\u0012\u00020\u0015`\u0016X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0019\u001a\u00020\u001a8BX\u0002¢\u0006\f\n\u0004\b\u001d\u0010\n\u001a\u0004\b\u001b\u0010\u001cR\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010\u001fX\u000e¢\u0006\u0002\n\u0000R\u001b\u0010!\u001a\u00020\"8BX\u0002¢\u0006\f\n\u0004\b%\u0010\n\u001a\u0004\b#\u0010$R\u0010\u0010&\u001a\u0004\u0018\u00010'X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010(\u001a\u0004\u0018\u00010)X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020+X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010,\u001a\u0004\u0018\u00010-X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u001b\u0010/\u001a\u0002008BX\u0002¢\u0006\f\n\u0004\b3\u0010\n\u001a\u0004\b1\u00102R\u001b\u00104\u001a\u0002058BX\u0002¢\u0006\f\n\u0004\b8\u0010\n\u001a\u0004\b6\u00107R+\u00109\u001a\u0012 \u000f*\b\u0018\u00010:R\u00020\"0:R\u00020\"8BX\u0002¢\u0006\f\n\u0004\b=\u0010\n\u001a\u0004\b;\u0010<R\u001b\u0010>\u001a\u00020?8BX\u0002¢\u0006\f\n\u0004\bB\u0010\n\u001a\u0004\b@\u0010A¨\u0006f"}, hxF = {"Lcom/tencent/mm/plugin/forcenotify/ui/ForceNotifyWindow;", "Landroid/view/View$OnKeyListener;", "()V", "audioFocusChangeListener", "Landroid/media/AudioManager$OnAudioFocusChangeListener;", "audioManager", "Landroid/media/AudioManager;", "getAudioManager", "()Landroid/media/AudioManager;", "audioManager$delegate", "Lkotlin/Lazy;", "checkLockScreenTask", "Ljava/lang/Runnable;", "context", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "getContext", "()Landroid/content/Context;", "context$delegate", "dataList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/forcenotify/model/ForceNotifyItem;", "Lkotlin/collections/ArrayList;", "dividerHeight", "", "keyguardManager", "Landroid/app/KeyguardManager;", "getKeyguardManager", "()Landroid/app/KeyguardManager;", "keyguardManager$delegate", "maskBottomIv", "Landroid/widget/ImageView;", "maskTopIv", "powerManager", "Landroid/os/PowerManager;", "getPowerManager", "()Landroid/os/PowerManager;", "powerManager$delegate", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "rootView", "Landroid/view/View;", "shown", "", "soundPlay", "Landroid/media/MediaPlayer;", "stopSoundTask", "uiHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "getUiHandler", "()Lcom/tencent/mm/sdk/platformtools/MMHandler;", "uiHandler$delegate", "vibrator", "Landroid/os/Vibrator;", "getVibrator", "()Landroid/os/Vibrator;", "vibrator$delegate", "wakeLock", "Landroid/os/PowerManager$WakeLock;", "getWakeLock", "()Landroid/os/PowerManager$WakeLock;", "wakeLock$delegate", "windowManager", "Landroid/view/WindowManager;", "getWindowManager", "()Landroid/view/WindowManager;", "windowManager$delegate", "canListScroll", "checkNeedMask", "", "handleDarkModeResources", "handleNormalResources", MessengerShareContentUtility.SHARE_BUTTON_HIDE, "isPhoneLocking", "jumpChattingUI", "item", "Lcom/tencent/mm/plugin/forcenotify/model/ForceNotifyMsgItem;", "jumpServiceNotifyUI", "Lcom/tencent/mm/plugin/forcenotify/model/ForceNotifyLiveItem;", "onCreate", "onHideWindow", "onKey", "v", "keyCode", "event", "Landroid/view/KeyEvent;", "onShowWindow", "onUpdateData", "add", "playPopupAnimation", "playScrollUpAnimation", "onAnimateEnd", "Lkotlin/Function0;", "playSound", "resetVibrateAndSound", "show", "update", "stopSound", "updateRecyclerViewHeight", "isFirstItemReachTop", "isLastItemReachBottom", "Companion", "plugin-force-notify_release"})
public final class b implements View.OnKeyListener {
    public static final a UWB = new a((byte) 0);
    private static final kotlin.f iax = kotlin.g.ah(C1367b.UWC);
    private Runnable UWA;
    private MediaPlayer UWm;
    private ImageView UWr;
    private ImageView UWs;
    private final kotlin.f UWt;
    private final kotlin.f UWu;
    private final kotlin.f UWv;
    private final kotlin.f UWw;
    private final kotlin.f UWx;
    private boolean UWy;
    private Runnable UWz;
    private final AudioManager.OnAudioFocusChangeListener audioFocusChangeListener;
    private final int dividerHeight;
    private RecyclerView hak;
    private final ArrayList<com.tencent.mm.plugin.forcenotify.c.e> kgc;
    private View lJI;
    private final kotlin.f mKI;
    private final kotlin.f tMy;
    private final kotlin.f uAh;

    private final AudioManager getAudioManager() {
        AppMethodBeat.i(261834);
        AudioManager audioManager = (AudioManager) this.mKI.getValue();
        AppMethodBeat.o(261834);
        return audioManager;
    }

    private final Context getContext() {
        AppMethodBeat.i(261833);
        Context context = (Context) this.tMy.getValue();
        AppMethodBeat.o(261833);
        return context;
    }

    private final MMHandler getUiHandler() {
        AppMethodBeat.i(261837);
        MMHandler mMHandler = (MMHandler) this.UWx.getValue();
        AppMethodBeat.o(261837);
        return mMHandler;
    }

    private final Vibrator getVibrator() {
        AppMethodBeat.i(261836);
        Vibrator vibrator = (Vibrator) this.uAh.getValue();
        AppMethodBeat.o(261836);
        return vibrator;
    }

    private final PowerManager.WakeLock getWakeLock() {
        AppMethodBeat.i(261835);
        PowerManager.WakeLock wakeLock = (PowerManager.WakeLock) this.UWv.getValue();
        AppMethodBeat.o(261835);
        return wakeLock;
    }

    private b() {
        AppMethodBeat.i(261846);
        this.tMy = kotlin.g.ah(e.UWF);
        this.mKI = kotlin.g.ah(new d(this));
        this.UWt = kotlin.g.ah(new q(this));
        this.UWu = kotlin.g.ah(new g(this));
        this.UWv = kotlin.g.ah(new w(this));
        this.audioFocusChangeListener = c.UWD;
        this.UWw = kotlin.g.ah(new x(this));
        this.uAh = kotlin.g.ah(new v(this));
        this.UWx = kotlin.g.ah(t.UWL);
        this.kgc = new ArrayList<>();
        this.UWz = new s(this);
        this.dividerHeight = com.tencent.mm.cb.a.fromDPToPix(getContext(), 0.5f);
        AppMethodBeat.o(261846);
    }

    public /* synthetic */ b(byte b2) {
        this();
    }

    public static final /* synthetic */ Context i(b bVar) {
        AppMethodBeat.i(261854);
        Context context = bVar.getContext();
        AppMethodBeat.o(261854);
        return context;
    }

    public static final /* synthetic */ PowerManager.WakeLock j(b bVar) {
        AppMethodBeat.i(261855);
        PowerManager.WakeLock wakeLock = bVar.getWakeLock();
        AppMethodBeat.o(261855);
        return wakeLock;
    }

    public static final /* synthetic */ void o(b bVar) {
        AppMethodBeat.i(261860);
        bVar.hVH();
        AppMethodBeat.o(261860);
    }

    public static final /* synthetic */ MMHandler p(b bVar) {
        AppMethodBeat.i(261861);
        MMHandler uiHandler = bVar.getUiHandler();
        AppMethodBeat.o(261861);
        return uiHandler;
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "", "onAudioFocusChange"})
    static final class c implements AudioManager.OnAudioFocusChangeListener {
        public static final c UWD = new c();

        static {
            AppMethodBeat.i(261806);
            AppMethodBeat.o(261806);
        }

        c() {
        }

        public final void onAudioFocusChange(int i2) {
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class s implements Runnable {
        final /* synthetic */ b UWE;

        s(b bVar) {
            this.UWE = bVar;
        }

        public final void run() {
            AppMethodBeat.i(261826);
            b.o(this.UWE);
            b.p(this.UWE).removeCallbacks(this.UWE.UWA);
            AppMethodBeat.o(261826);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R!\u0010\u0007\u001a\u00020\b8FX\u0002¢\u0006\u0012\n\u0004\b\f\u0010\r\u0012\u0004\b\t\u0010\u0002\u001a\u0004\b\n\u0010\u000b¨\u0006\u000e"}, hxF = {"Lcom/tencent/mm/plugin/forcenotify/ui/ForceNotifyWindow$Companion;", "", "()V", "LIST_ITEM_COUNT_MAX", "", "TAG", "", "instance", "Lcom/tencent/mm/plugin/forcenotify/ui/ForceNotifyWindow;", "instance$annotations", "getInstance", "()Lcom/tencent/mm/plugin/forcenotify/ui/ForceNotifyWindow;", "instance$delegate", "Lkotlin/Lazy;", "plugin-force-notify_release"})
    public static final class a {
        public static b hVK() {
            AppMethodBeat.i(261805);
            kotlin.f fVar = b.iax;
            a aVar = b.UWB;
            b bVar = (b) fVar.getValue();
            AppMethodBeat.o(261805);
            return bVar;
        }

        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(261847);
        AppMethodBeat.o(261847);
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    public static final class i implements View.OnClickListener {
        final /* synthetic */ b UWE;

        i(b bVar) {
            this.UWE = bVar;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(261813);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/forcenotify/ui/ForceNotifyWindow$onShowWindow$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            this.UWE.hide();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/forcenotify/ui/ForceNotifyWindow$onShowWindow$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(261813);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/forcenotify/ui/ForceNotifyWindow$onShowWindow$3", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "plugin-force-notify_release"})
    public static final class k implements com.tencent.mm.view.recyclerview.f {
        k() {
        }

        @Override // com.tencent.mm.view.recyclerview.f
        public final com.tencent.mm.view.recyclerview.e<?> EC(int i2) {
            AppMethodBeat.i(261816);
            switch (i2) {
                case 0:
                    com.tencent.mm.plugin.forcenotify.e.b bVar = new com.tencent.mm.plugin.forcenotify.e.b();
                    AppMethodBeat.o(261816);
                    return bVar;
                case 1:
                    com.tencent.mm.plugin.forcenotify.e.a aVar = new com.tencent.mm.plugin.forcenotify.e.a();
                    AppMethodBeat.o(261816);
                    return aVar;
                default:
                    com.tencent.mm.plugin.forcenotify.e.b bVar2 = new com.tencent.mm.plugin.forcenotify.e.b();
                    AppMethodBeat.o(261816);
                    return bVar2;
            }
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J.\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0002H\u0016¨\u0006\f¸\u0006\u0000"}, hxF = {"com/tencent/mm/plugin/forcenotify/ui/ForceNotifyWindow$onShowWindow$4$1", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$OnItemClickListener;", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "onItemClick", "", "adapter", "Landroid/support/v7/widget/RecyclerView$Adapter;", "view", "Landroid/view/View;", "position", "", "holder", "plugin-force-notify_release"})
    public static final class h implements g.c<com.tencent.mm.view.recyclerview.h> {
        final /* synthetic */ b UWE;
        final /* synthetic */ WxRecyclerAdapter vcC;

        h(WxRecyclerAdapter wxRecyclerAdapter, b bVar) {
            this.vcC = wxRecyclerAdapter;
            this.UWE = bVar;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.support.v7.widget.RecyclerView$a, android.view.View, int, android.support.v7.widget.RecyclerView$v] */
        @Override // com.tencent.mm.view.recyclerview.g.c
        public final /* synthetic */ void a(RecyclerView.a<com.tencent.mm.view.recyclerview.h> aVar, View view, int i2, com.tencent.mm.view.recyclerview.h hVar) {
            AppMethodBeat.i(261812);
            kotlin.g.b.p.h(aVar, "adapter");
            kotlin.g.b.p.h(view, "view");
            kotlin.g.b.p.h(hVar, "holder");
            this.vcC.getRecyclerView();
            int bw = RecyclerView.bw(view);
            Object remove = this.UWE.kgc.remove(bw);
            kotlin.g.b.p.g(remove, "dataList.removeAt(index)");
            com.tencent.mm.plugin.forcenotify.c.e eVar = (com.tencent.mm.plugin.forcenotify.c.e) remove;
            f.a aVar2 = com.tencent.mm.plugin.forcenotify.c.f.UVX;
            f.a.hVE().byh(eVar.wMn);
            if (this.UWE.kgc.isEmpty()) {
                this.UWE.hide();
            } else {
                RecyclerView.a adapter = this.vcC.getRecyclerView().getAdapter();
                if (adapter != null) {
                    adapter.ck(bw);
                }
                RecyclerView.a adapter2 = this.vcC.getRecyclerView().getAdapter();
                if (adapter2 != null) {
                    adapter2.aq(bw, this.UWE.kgc.size() - bw);
                }
            }
            b.a(this.UWE, false);
            com.tencent.mm.plugin.forcenotify.d.a.wLU.gC(eVar.wMn);
            if (eVar instanceof com.tencent.mm.plugin.forcenotify.c.h) {
                b.a(this.UWE, (com.tencent.mm.plugin.forcenotify.c.h) eVar);
                AppMethodBeat.o(261812);
                return;
            }
            if (eVar instanceof com.tencent.mm.plugin.forcenotify.c.g) {
                b.d(this.UWE);
            }
            AppMethodBeat.o(261812);
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class l implements Runnable {
        final /* synthetic */ b UWE;

        l(b bVar) {
            this.UWE = bVar;
        }

        public final void run() {
            AppMethodBeat.i(261817);
            b.e(this.UWE);
            AppMethodBeat.o(261817);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0016¨\u0006\t"}, hxF = {"com/tencent/mm/plugin/forcenotify/ui/ForceNotifyWindow$onShowWindow$6", "Landroid/support/v7/widget/RecyclerView$OnScrollListener;", "onScrolled", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "dx", "", "dy", "plugin-force-notify_release"})
    public static final class m extends RecyclerView.l {
        final /* synthetic */ b UWE;

        @Override // android.support.v7.widget.RecyclerView.l
        public final void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            AppMethodBeat.i(261819);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(recyclerView);
            bVar.pH(i2);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/forcenotify/ui/ForceNotifyWindow$onShowWindow$6", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, bVar.axR());
            super.onScrollStateChanged(recyclerView, i2);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/forcenotify/ui/ForceNotifyWindow$onShowWindow$6", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
            AppMethodBeat.o(261819);
        }

        /* JADX WARN: Incorrect args count in method signature: ()V */
        m(b bVar) {
            this.UWE = bVar;
        }

        @Override // android.support.v7.widget.RecyclerView.l
        public final void onScrolled(RecyclerView recyclerView, int i2, int i3) {
            AppMethodBeat.i(261818);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(recyclerView);
            bVar.pH(i2);
            bVar.pH(i3);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/forcenotify/ui/ForceNotifyWindow$onShowWindow$6", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, bVar.axR());
            kotlin.g.b.p.h(recyclerView, "recyclerView");
            super.onScrolled(recyclerView, i2, i3);
            b.e(this.UWE);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/forcenotify/ui/ForceNotifyWindow$onShowWindow$6", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
            AppMethodBeat.o(261818);
        }
    }

    private final void hVI() {
        AppMethodBeat.i(261838);
        RecyclerView recyclerView = this.hak;
        if (recyclerView != null) {
            recyclerView.post(new u(recyclerView, this));
            AppMethodBeat.o(261838);
            return;
        }
        AppMethodBeat.o(261838);
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, hxF = {"<anonymous>", "", "run", "com/tencent/mm/plugin/forcenotify/ui/ForceNotifyWindow$updateRecyclerViewHeight$1$1"})
    public static final class u implements Runnable {
        final /* synthetic */ b UWE;
        final /* synthetic */ RecyclerView uMW;

        u(RecyclerView recyclerView, b bVar) {
            this.uMW = recyclerView;
            this.UWE = bVar;
        }

        public final void run() {
            AppMethodBeat.i(261829);
            if (this.UWE.kgc.size() <= 3) {
                ViewGroup.LayoutParams layoutParams = this.uMW.getLayoutParams();
                layoutParams.height = -2;
                this.uMW.setLayoutParams(layoutParams);
                AppMethodBeat.o(261829);
                return;
            }
            View childAt = this.uMW.getChildAt(0);
            if (childAt != null) {
                int height = (childAt.getHeight() * 3) + (this.UWE.dividerHeight * 2);
                ViewGroup.LayoutParams layoutParams2 = this.uMW.getLayoutParams();
                layoutParams2.height = height;
                this.uMW.setLayoutParams(layoutParams2);
                AppMethodBeat.o(261829);
                return;
            }
            AppMethodBeat.o(261829);
        }
    }

    public final void fkZ() {
        AppMethodBeat.i(261839);
        com.tencent.mm.plugin.forcenotify.f.a aVar = com.tencent.mm.plugin.forcenotify.f.a.UWN;
        Context context = getContext();
        kotlin.g.b.p.g(context, "context");
        if (!com.tencent.mm.plugin.forcenotify.f.a.ml(context)) {
            AppMethodBeat.o(261839);
            return;
        }
        com.tencent.f.h.RTc.aV(new r(this, true));
        AppMethodBeat.o(261839);
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class r implements Runnable {
        final /* synthetic */ b UWE;
        final /* synthetic */ boolean UWI = true;

        r(b bVar, boolean z) {
            this.UWE = bVar;
        }

        public final void run() {
            ImageView imageView;
            ImageView imageView2;
            int i2;
            RecyclerView.a adapter;
            AppMethodBeat.i(261825);
            if (this.UWI) {
                f.a aVar = com.tencent.mm.plugin.forcenotify.c.f.UVX;
                com.tencent.mm.plugin.forcenotify.c.e hVD = f.a.hVE().hVD();
                if (hVD != null) {
                    this.UWE.kgc.add(0, hVD);
                    RecyclerView recyclerView = this.UWE.hak;
                    if (!(recyclerView == null || (adapter = recyclerView.getAdapter()) == null)) {
                        adapter.cj(0);
                    }
                    b.a(this.UWE, true);
                    RecyclerView recyclerView2 = this.UWE.hak;
                    if (recyclerView2 != null) {
                        com.tencent.mm.hellhoundlib.b.a a2 = com.tencent.mm.hellhoundlib.b.c.a(0, new com.tencent.mm.hellhoundlib.b.a());
                        com.tencent.mm.hellhoundlib.a.a.a(recyclerView2, a2.axQ(), "com/tencent/mm/plugin/forcenotify/ui/ForceNotifyWindow$show$1", "run", "()V", "Undefined", "smoothScrollToPosition", "(I)V");
                        recyclerView2.smoothScrollToPosition(((Integer) a2.pG(0)).intValue());
                        com.tencent.mm.hellhoundlib.a.a.a(recyclerView2, "com/tencent/mm/plugin/forcenotify/ui/ForceNotifyWindow$show$1", "run", "()V", "Undefined", "smoothScrollToPosition", "(I)V");
                    }
                    RecyclerView recyclerView3 = this.UWE.hak;
                    if (recyclerView3 != null) {
                        recyclerView3.post(new a(this));
                    }
                }
            }
            if (!this.UWE.UWy) {
                this.UWE.lJI = LayoutInflater.from(b.i(this.UWE)).inflate(R.layout.cfr, (ViewGroup) null);
                b bVar = this.UWE;
                View view = this.UWE.lJI;
                bVar.hak = view != null ? (RecyclerView) view.findViewById(R.id.h_1) : null;
                b bVar2 = this.UWE;
                View view2 = this.UWE.lJI;
                if (view2 != null) {
                    imageView = (ImageView) view2.findViewById(R.id.jzn);
                } else {
                    imageView = null;
                }
                bVar2.UWr = imageView;
                b bVar3 = this.UWE;
                View view3 = this.UWE.lJI;
                if (view3 != null) {
                    imageView2 = (ImageView) view3.findViewById(R.id.jzm);
                } else {
                    imageView2 = null;
                }
                bVar3.UWs = imageView2;
                WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
                if (com.tencent.mm.compatible.util.d.oD(26)) {
                    i2 = 2038;
                } else {
                    i2 = 2002;
                }
                layoutParams.type = i2;
                layoutParams.format = -2;
                Context i3 = b.i(this.UWE);
                kotlin.g.b.p.g(i3, "context");
                layoutParams.packageName = i3.getPackageName();
                layoutParams.gravity = 48;
                layoutParams.flags = 40;
                Context i4 = b.i(this.UWE);
                kotlin.g.b.p.g(i4, "context");
                layoutParams.horizontalMargin = (float) i4.getResources().getDimensionPixelSize(R.dimen.ct);
                layoutParams.width = -1;
                layoutParams.height = -2;
                PowerManager.WakeLock j2 = b.j(this.UWE);
                kotlin.g.b.p.g(j2, "wakeLock");
                if (!j2.isHeld()) {
                    b.j(this.UWE).acquire(120000);
                }
                View view4 = this.UWE.lJI;
                if (view4 != null) {
                    view4.setVisibility(0);
                }
                try {
                    b.k(this.UWE).addView(this.UWE.lJI, layoutParams);
                } catch (Exception e2) {
                    Log.e("ForceNotifyWindow", "ForceNotifyWindow attach to window failed!");
                }
                b.l(this.UWE);
                this.UWE.UWy = true;
            }
            AppMethodBeat.o(261825);
        }

        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, hxF = {"<anonymous>", "", "run", "com/tencent/mm/plugin/forcenotify/ui/ForceNotifyWindow$show$1$1$1"})
        static final class a implements Runnable {
            final /* synthetic */ r UWJ;
            final /* synthetic */ int UWK = 0;

            a(r rVar) {
                this.UWJ = rVar;
            }

            public final void run() {
                AppMethodBeat.i(261824);
                b.e(this.UWJ.UWE);
                AppMethodBeat.o(261824);
            }
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class n implements Runnable {
        final /* synthetic */ b UWE;

        n(b bVar) {
            this.UWE = bVar;
        }

        public final void run() {
            AppMethodBeat.i(261820);
            b.m(this.UWE);
            AppMethodBeat.o(261820);
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class o implements Runnable {
        final /* synthetic */ b UWE;

        o(b bVar) {
            this.UWE = bVar;
        }

        public final void run() {
            AppMethodBeat.i(261821);
            if (b.n(this.UWE)) {
                b.o(this.UWE);
                AppMethodBeat.o(261821);
                return;
            }
            b.p(this.UWE).postDelayed(this.UWE.UWA, 100);
            AppMethodBeat.o(261821);
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class f implements Runnable {
        final /* synthetic */ b UWE;

        f(b bVar) {
            this.UWE = bVar;
        }

        public final void run() {
            AppMethodBeat.i(261810);
            if (this.UWE.UWy) {
                this.UWE.UWy = false;
                View view = this.UWE.lJI;
                if (view != null) {
                    view.setVisibility(8);
                }
                try {
                    b.k(this.UWE).removeView(this.UWE.lJI);
                } catch (Exception e2) {
                    Log.e("ForceNotifyWindow", "ForceNotifyWindow dettach from window failed!");
                }
                b.r(this.UWE);
                this.UWE.lJI = null;
                this.UWE.hak = null;
                this.UWE.UWr = null;
                this.UWE.UWs = null;
            }
            AppMethodBeat.o(261810);
        }
    }

    public final void hide() {
        AppMethodBeat.i(261840);
        com.tencent.f.h.RTc.aV(new f(this));
        AppMethodBeat.o(261840);
    }

    private static boolean w(RecyclerView recyclerView) {
        View findViewByPosition;
        AppMethodBeat.i(261841);
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (layoutManager == null || (findViewByPosition = layoutManager.findViewByPosition(0)) == null) {
            AppMethodBeat.o(261841);
            return false;
        } else if (findViewByPosition.getTop() >= 0) {
            AppMethodBeat.o(261841);
            return true;
        } else {
            AppMethodBeat.o(261841);
            return false;
        }
    }

    private static boolean y(RecyclerView recyclerView) {
        int ku;
        View findViewByPosition;
        AppMethodBeat.i(261842);
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (layoutManager != null) {
            Rect rect = new Rect();
            if ((layoutManager instanceof LinearLayoutManager) && (ku = ((LinearLayoutManager) layoutManager).ku()) == ((LinearLayoutManager) layoutManager).getItemCount() - 1 && (findViewByPosition = layoutManager.findViewByPosition(ku)) != null) {
                RecyclerView.getDecoratedBoundsWithMargins(findViewByPosition, rect);
                if (rect.bottom <= recyclerView.getHeight()) {
                    findViewByPosition.getHitRect(rect);
                    if (rect.bottom <= recyclerView.getHeight()) {
                        AppMethodBeat.o(261842);
                        return true;
                    }
                    AppMethodBeat.o(261842);
                    return false;
                }
            }
        }
        AppMethodBeat.o(261842);
        return false;
    }

    private final void hVH() {
        AppMethodBeat.i(261843);
        try {
            getVibrator().cancel();
            MediaPlayer mediaPlayer = this.UWm;
            if (mediaPlayer != null) {
                mediaPlayer.stop();
            }
            MediaPlayer mediaPlayer2 = this.UWm;
            if (mediaPlayer2 != null) {
                mediaPlayer2.release();
            }
            PowerManager.WakeLock wakeLock = getWakeLock();
            kotlin.g.b.p.g(wakeLock, "wakeLock");
            if (wakeLock.isHeld()) {
                getWakeLock().release();
            }
            getAudioManager().abandonAudioFocus(this.audioFocusChangeListener);
            AppMethodBeat.o(261843);
        } catch (Exception e2) {
            AppMethodBeat.o(261843);
        }
    }

    private final void hVJ() {
        AppMethodBeat.i(261844);
        getUiHandler().removeCallbacksAndMessages(null);
        this.UWz.run();
        AppMethodBeat.o(261844);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0007\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\t"}, hxF = {"com/tencent/mm/plugin/forcenotify/ui/ForceNotifyWindow$playScrollUpAnimation$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-force-notify_release"})
    public static final class p implements Animator.AnimatorListener {
        final /* synthetic */ kotlin.g.a.a FAX;
        final /* synthetic */ b UWE;
        final /* synthetic */ float UWH;

        p(b bVar, kotlin.g.a.a aVar, float f2) {
            this.UWE = bVar;
            this.FAX = aVar;
            this.UWH = f2;
        }

        public final void onAnimationStart(Animator animator) {
        }

        public final void onAnimationCancel(Animator animator) {
        }

        public final void onAnimationRepeat(Animator animator) {
        }

        public final void onAnimationEnd(Animator animator) {
            AppMethodBeat.i(261822);
            this.FAX.invoke();
            View view = this.UWE.lJI;
            if (view == null) {
                kotlin.g.b.p.hyc();
            }
            view.setTranslationY(this.UWH);
            AppMethodBeat.o(261822);
        }
    }

    public final boolean onKey(View view, int i2, KeyEvent keyEvent) {
        AppMethodBeat.i(261845);
        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
        bVar.bm(view);
        bVar.pH(i2);
        bVar.bm(keyEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/forcenotify/ui/ForceNotifyWindow", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z", this, bVar.axR());
        if (keyEvent != null && keyEvent.getAction() == 1) {
            hVJ();
        }
        com.tencent.mm.hellhoundlib.a.a.a(false, (Object) this, "com/tencent/mm/plugin/forcenotify/ui/ForceNotifyWindow", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z");
        AppMethodBeat.o(261845);
        return false;
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "invoke"})
    static final class e extends kotlin.g.b.q implements kotlin.g.a.a<Context> {
        public static final e UWF = new e();

        static {
            AppMethodBeat.i(261809);
            AppMethodBeat.o(261809);
        }

        e() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ Context invoke() {
            AppMethodBeat.i(261808);
            Context context = MMApplicationContext.getContext();
            AppMethodBeat.o(261808);
            return context;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "Landroid/media/AudioManager;", "invoke"})
    static final class d extends kotlin.g.b.q implements kotlin.g.a.a<AudioManager> {
        final /* synthetic */ b UWE;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(b bVar) {
            super(0);
            this.UWE = bVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ AudioManager invoke() {
            AppMethodBeat.i(261807);
            Object systemService = b.i(this.UWE).getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE);
            if (systemService == null) {
                kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type android.media.AudioManager");
                AppMethodBeat.o(261807);
                throw tVar;
            }
            AudioManager audioManager = (AudioManager) systemService;
            AppMethodBeat.o(261807);
            return audioManager;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "Landroid/os/PowerManager;", "invoke"})
    static final class q extends kotlin.g.b.q implements kotlin.g.a.a<PowerManager> {
        final /* synthetic */ b UWE;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        q(b bVar) {
            super(0);
            this.UWE = bVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ PowerManager invoke() {
            AppMethodBeat.i(261823);
            Object systemService = b.i(this.UWE).getSystemService("power");
            if (systemService == null) {
                kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type android.os.PowerManager");
                AppMethodBeat.o(261823);
                throw tVar;
            }
            PowerManager powerManager = (PowerManager) systemService;
            AppMethodBeat.o(261823);
            return powerManager;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "Landroid/app/KeyguardManager;", "invoke"})
    static final class g extends kotlin.g.b.q implements kotlin.g.a.a<KeyguardManager> {
        final /* synthetic */ b UWE;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        g(b bVar) {
            super(0);
            this.UWE = bVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ KeyguardManager invoke() {
            AppMethodBeat.i(261811);
            Object systemService = b.i(this.UWE).getSystemService("keyguard");
            if (systemService == null) {
                kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type android.app.KeyguardManager");
                AppMethodBeat.o(261811);
                throw tVar;
            }
            KeyguardManager keyguardManager = (KeyguardManager) systemService;
            AppMethodBeat.o(261811);
            return keyguardManager;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0012 \u0003*\b\u0018\u00010\u0001R\u00020\u00020\u0001R\u00020\u0002H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "Landroid/os/PowerManager$WakeLock;", "Landroid/os/PowerManager;", "kotlin.jvm.PlatformType", "invoke"})
    static final class w extends kotlin.g.b.q implements kotlin.g.a.a<PowerManager.WakeLock> {
        final /* synthetic */ b UWE;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        w(b bVar) {
            super(0);
            this.UWE = bVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ PowerManager.WakeLock invoke() {
            AppMethodBeat.i(261831);
            PowerManager.WakeLock newWakeLock = b.s(this.UWE).newWakeLock(26, "wx:ForceNotifyWindowLock");
            AppMethodBeat.o(261831);
            return newWakeLock;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "Landroid/view/WindowManager;", "invoke"})
    static final class x extends kotlin.g.b.q implements kotlin.g.a.a<WindowManager> {
        final /* synthetic */ b UWE;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        x(b bVar) {
            super(0);
            this.UWE = bVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ WindowManager invoke() {
            AppMethodBeat.i(261832);
            Object systemService = b.i(this.UWE).getSystemService("window");
            if (systemService == null) {
                kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type android.view.WindowManager");
                AppMethodBeat.o(261832);
                throw tVar;
            }
            WindowManager windowManager = (WindowManager) systemService;
            AppMethodBeat.o(261832);
            return windowManager;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "Landroid/os/Vibrator;", "invoke"})
    static final class v extends kotlin.g.b.q implements kotlin.g.a.a<Vibrator> {
        final /* synthetic */ b UWE;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        v(b bVar) {
            super(0);
            this.UWE = bVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ Vibrator invoke() {
            AppMethodBeat.i(261830);
            Object systemService = b.i(this.UWE).getSystemService("vibrator");
            if (systemService == null) {
                kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type android.os.Vibrator");
                AppMethodBeat.o(261830);
                throw tVar;
            }
            Vibrator vibrator = (Vibrator) systemService;
            AppMethodBeat.o(261830);
            return vibrator;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "invoke"})
    static final class t extends kotlin.g.b.q implements kotlin.g.a.a<MMHandler> {
        public static final t UWL = new t();

        static {
            AppMethodBeat.i(261828);
            AppMethodBeat.o(261828);
        }

        t() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ MMHandler invoke() {
            AppMethodBeat.i(261827);
            MMHandler mMHandler = new MMHandler(Looper.getMainLooper());
            AppMethodBeat.o(261827);
            return mMHandler;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "Lcom/tencent/mm/plugin/forcenotify/ui/ForceNotifyWindow;", "invoke"})
    /* renamed from: com.tencent.mm.plugin.forcenotify.ui.b$b  reason: collision with other inner class name */
    static final class C1367b extends kotlin.g.b.q implements kotlin.g.a.a<b> {
        public static final C1367b UWC = new C1367b();

        static {
            AppMethodBeat.i(261804);
            AppMethodBeat.o(261804);
        }

        C1367b() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ b invoke() {
            AppMethodBeat.i(261803);
            b bVar = new b((byte) 0);
            AppMethodBeat.o(261803);
            return bVar;
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class j extends kotlin.g.b.q implements kotlin.g.a.a<kotlin.x> {
        final /* synthetic */ b UWE;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        j(b bVar) {
            super(0);
            this.UWE = bVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ kotlin.x invoke() {
            AppMethodBeat.i(261815);
            if (!b.a(this.UWE)) {
                b.a(this.UWE, new kotlin.g.a.a<kotlin.x>(this) {
                    /* class com.tencent.mm.plugin.forcenotify.ui.b.j.AnonymousClass1 */
                    final /* synthetic */ j UWG;

                    {
                        this.UWG = r2;
                    }

                    /* Return type fixed from 'java.lang.Object' to match base method */
                    @Override // kotlin.g.a.a
                    public final /* synthetic */ kotlin.x invoke() {
                        AppMethodBeat.i(261814);
                        View view = this.UWG.UWE.lJI;
                        if (view != null) {
                            view.setVisibility(8);
                        }
                        this.UWG.UWE.hide();
                        kotlin.x xVar = kotlin.x.SXb;
                        AppMethodBeat.o(261814);
                        return xVar;
                    }
                });
            }
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(261815);
            return xVar;
        }
    }

    public static final /* synthetic */ boolean a(b bVar) {
        RecyclerView recyclerView;
        AppMethodBeat.i(261848);
        RecyclerView recyclerView2 = bVar.hak;
        if ((recyclerView2 == null || w(recyclerView2)) && ((recyclerView = bVar.hak) == null || y(recyclerView))) {
            AppMethodBeat.o(261848);
            return false;
        }
        AppMethodBeat.o(261848);
        return true;
    }

    public static final /* synthetic */ void a(b bVar, kotlin.g.a.a aVar) {
        AppMethodBeat.i(261849);
        View view = bVar.lJI;
        if (view == null) {
            kotlin.g.b.p.hyc();
        }
        int height = view.getHeight();
        View view2 = bVar.lJI;
        if (view2 == null) {
            kotlin.g.b.p.hyc();
        }
        float translationY = view2.getTranslationY();
        View view3 = bVar.lJI;
        if (view3 == null) {
            kotlin.g.b.p.hyc();
        }
        ObjectAnimator duration = ObjectAnimator.ofFloat(view3, "translationY", -((float) height)).setDuration(260L);
        kotlin.g.b.p.g(duration, "ObjectAnimator.ofFloat(r…Float()).setDuration(260)");
        duration.addListener(new p(bVar, aVar, translationY));
        duration.setInterpolator(new AccelerateInterpolator());
        duration.start();
        AppMethodBeat.o(261849);
    }

    public static final /* synthetic */ void a(b bVar, boolean z) {
        AppMethodBeat.i(261850);
        if (z) {
            bVar.hVH();
            bVar.getUiHandler().removeCallbacks(bVar.UWA);
            bVar.getUiHandler().removeCallbacks(bVar.UWz);
            bVar.getAudioManager().requestAudioFocus(bVar.audioFocusChangeListener, 3, 2);
            bVar.getUiHandler().postDelayed(new n(bVar), 1000);
            AppForegroundDelegate appForegroundDelegate = AppForegroundDelegate.INSTANCE;
            bVar.getUiHandler().postDelayed(bVar.UWz, 7000);
            bVar.UWA = new o(bVar);
            bVar.getUiHandler().postDelayed(bVar.UWA, 100);
        }
        bVar.hVI();
        AppMethodBeat.o(261850);
    }

    public static final /* synthetic */ void a(b bVar, com.tencent.mm.plugin.forcenotify.c.h hVar) {
        AppMethodBeat.i(261851);
        abl abl = new abl();
        abl.opW.username = hVar.username;
        if (!EventCenter.instance.publish(abl)) {
            Log.i("ForceNotifyWindow", "jumpChattingUI LauncherUI background, jump chatting username:" + hVar.username);
            Intent intent = new Intent();
            intent.putExtra("Chat_Self", z.aTY());
            intent.putExtra("Chat_User", hVar.username);
            intent.putExtra("finish_direct", true);
            com.tencent.mm.br.c.f(bVar.getContext(), ".ui.chatting.ChattingUI", intent);
            AppMethodBeat.o(261851);
            return;
        }
        Log.i("ForceNotifyWindow", "jumpChattingUI LauncherUI running, jump chatting username:" + hVar.username);
        AppMethodBeat.o(261851);
    }

    public static final /* synthetic */ void d(b bVar) {
        AppMethodBeat.i(261852);
        Intent intent = new Intent();
        intent.putExtra("Chat_User", "notifymessage");
        intent.putExtra("finish_direct", true);
        com.tencent.mm.br.c.f(bVar.getContext(), ".ui.chatting.ChattingUI", intent);
        AppMethodBeat.o(261852);
    }

    public static final /* synthetic */ void e(b bVar) {
        int i2;
        int i3 = 8;
        AppMethodBeat.i(261853);
        ImageView imageView = bVar.UWr;
        if (imageView != null) {
            RecyclerView recyclerView = bVar.hak;
            if (recyclerView == null || !w(recyclerView)) {
                i2 = 0;
            } else {
                i2 = 8;
            }
            imageView.setVisibility(i2);
        }
        ImageView imageView2 = bVar.UWs;
        if (imageView2 != null) {
            RecyclerView recyclerView2 = bVar.hak;
            if (recyclerView2 == null || !y(recyclerView2)) {
                i3 = 0;
            }
            imageView2.setVisibility(i3);
            AppMethodBeat.o(261853);
            return;
        }
        AppMethodBeat.o(261853);
    }

    public static final /* synthetic */ WindowManager k(b bVar) {
        AppMethodBeat.i(261856);
        WindowManager windowManager = (WindowManager) bVar.UWw.getValue();
        AppMethodBeat.o(261856);
        return windowManager;
    }

    public static final /* synthetic */ void l(b bVar) {
        View findViewById;
        View findViewById2;
        View findViewById3;
        AppMethodBeat.i(261857);
        View view = bVar.lJI;
        if (view == null) {
            kotlin.g.b.p.hyc();
        }
        view.setAlpha(0.0f);
        View view2 = bVar.lJI;
        if (view2 == null) {
            kotlin.g.b.p.hyc();
        }
        ObjectAnimator duration = ObjectAnimator.ofFloat(view2, "alpha", 1.0f).setDuration(260L);
        kotlin.g.b.p.g(duration, "ObjectAnimator.ofFloat(r…\", 1.0f).setDuration(260)");
        duration.setInterpolator(new AccelerateInterpolator());
        duration.start();
        View view3 = bVar.lJI;
        if (!(view3 == null || (findViewById3 = view3.findViewById(R.id.jtk)) == null)) {
            findViewById3.setOnClickListener(new i(bVar));
        }
        if (ao.isDarkMode()) {
            View view4 = bVar.lJI;
            if (!(view4 == null || (findViewById2 = view4.findViewById(R.id.k03)) == null)) {
                findViewById2.setBackgroundResource(R.drawable.cv8);
            }
            ImageView imageView = bVar.UWs;
            if (imageView != null) {
                imageView.setImageResource(R.drawable.cv4);
            }
            ImageView imageView2 = bVar.UWr;
            if (imageView2 != null) {
                imageView2.setImageResource(R.drawable.cv6);
            }
        } else {
            View view5 = bVar.lJI;
            if (!(view5 == null || (findViewById = view5.findViewById(R.id.k03)) == null)) {
                findViewById.setBackgroundResource(R.drawable.cv7);
            }
            ImageView imageView3 = bVar.UWs;
            if (imageView3 != null) {
                imageView3.setImageResource(R.drawable.cv3);
            }
            ImageView imageView4 = bVar.UWr;
            if (imageView4 != null) {
                imageView4.setImageResource(R.drawable.cv5);
            }
        }
        View view6 = bVar.lJI;
        if (view6 != null) {
            view6.setFocusableInTouchMode(true);
        }
        View view7 = bVar.lJI;
        if (view7 != null) {
            view7.setOnKeyListener(bVar);
        }
        View view8 = bVar.lJI;
        if (!(view8 instanceof KeyEventConstraintLayout)) {
            view8 = null;
        }
        KeyEventConstraintLayout keyEventConstraintLayout = (KeyEventConstraintLayout) view8;
        if (keyEventConstraintLayout != null) {
            keyEventConstraintLayout.setOnScrollUpListener(new j(bVar));
        }
        RecyclerView recyclerView = bVar.hak;
        if (recyclerView != null) {
            bVar.getContext();
            recyclerView.setLayoutManager(new LinearLayoutManager());
        }
        RecyclerView recyclerView2 = bVar.hak;
        if (recyclerView2 != null) {
            Context context = bVar.getContext();
            kotlin.g.b.p.g(context, "context");
            recyclerView2.b(new a(context, bVar.dividerHeight));
        }
        RecyclerView recyclerView3 = bVar.hak;
        if (recyclerView3 != null) {
            WxRecyclerAdapter wxRecyclerAdapter = new WxRecyclerAdapter(new k(), bVar.kgc);
            wxRecyclerAdapter.RqP = new h(wxRecyclerAdapter, bVar);
            recyclerView3.setAdapter(wxRecyclerAdapter);
        }
        bVar.hVI();
        RecyclerView recyclerView4 = bVar.hak;
        if (recyclerView4 != null) {
            recyclerView4.post(new l(bVar));
        }
        RecyclerView recyclerView5 = bVar.hak;
        if (recyclerView5 != null) {
            recyclerView5.a(new m(bVar));
            AppMethodBeat.o(261857);
            return;
        }
        AppMethodBeat.o(261857);
    }

    public static final /* synthetic */ void m(b bVar) {
        AppMethodBeat.i(261858);
        com.tencent.mm.plugin.forcenotify.b.c cVar = com.tencent.mm.plugin.forcenotify.b.c.wLS;
        Context context = bVar.getContext();
        kotlin.g.b.p.g(context, "context");
        if (!cVar.fR(context)) {
            Log.i("ForceNotifyWindow", "PlaySound.playRoot");
            bVar.UWm = PlaySound.playRoot(bVar.getContext(), R.string.dha, PlaySound.SPEAKERON.NOTSET, 2, true, null);
        }
        com.tencent.mm.plugin.forcenotify.b.c cVar2 = com.tencent.mm.plugin.forcenotify.b.c.wLS;
        Context context2 = bVar.getContext();
        kotlin.g.b.p.g(context2, "context");
        if (cVar2.fS(context2)) {
            Log.i("ForceNotifyWindow", "vibrator.vibrate");
            if (AppForegroundDelegate.INSTANCE.Wc()) {
                bVar.getVibrator().vibrate(new long[]{1000, 1000, 1000, 1000, 1000, 1000}, -1);
                AppMethodBeat.o(261858);
                return;
            }
            bVar.getVibrator().vibrate(new long[]{1000, 1000, 1000, 1000, 1000, 1000}, -1);
        }
        AppMethodBeat.o(261858);
    }

    public static final /* synthetic */ boolean n(b bVar) {
        AppMethodBeat.i(261859);
        boolean inKeyguardRestrictedInputMode = ((KeyguardManager) bVar.UWu.getValue()).inKeyguardRestrictedInputMode();
        AppMethodBeat.o(261859);
        return inKeyguardRestrictedInputMode;
    }

    public static final /* synthetic */ void r(b bVar) {
        RecyclerView.a adapter;
        AppMethodBeat.i(261862);
        bVar.hVJ();
        for (T t2 : bVar.kgc) {
            f.a aVar = com.tencent.mm.plugin.forcenotify.c.f.UVX;
            f.a.hVE().byh(t2.wMn);
            com.tencent.mm.plugin.forcenotify.d.a.wLU.gC(t2.wMn);
        }
        bVar.kgc.clear();
        RecyclerView recyclerView = bVar.hak;
        if (recyclerView == null || (adapter = recyclerView.getAdapter()) == null) {
            AppMethodBeat.o(261862);
            return;
        }
        adapter.notifyDataSetChanged();
        AppMethodBeat.o(261862);
    }

    public static final /* synthetic */ PowerManager s(b bVar) {
        AppMethodBeat.i(261863);
        PowerManager powerManager = (PowerManager) bVar.UWt.getValue();
        AppMethodBeat.o(261863);
        return powerManager;
    }
}

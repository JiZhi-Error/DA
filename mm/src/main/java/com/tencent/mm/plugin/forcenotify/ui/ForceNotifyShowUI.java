package com.tencent.mm.plugin.forcenotify.ui;

import android.graphics.drawable.ColorDrawable;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Looper;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.av.q;
import com.tencent.mm.model.cl;
import com.tencent.mm.plugin.forcenotify.c.h;
import com.tencent.mm.plugin.i.a.aj;
import com.tencent.mm.pluginsdk.ui.a;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.PlaySound;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;
import kotlin.t;

@com.tencent.mm.ui.base.a(3)
@l(hxD = {1, 1, 16}, hxE = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u001e\u001a\u00020\u001fH\u0014J\b\u0010 \u001a\u00020!H\u0016J\u0012\u0010\"\u001a\u00020!2\b\u0010#\u001a\u0004\u0018\u00010$H\u0016J\b\u0010%\u001a\u00020!H\u0014J\u0018\u0010&\u001a\u00020\u00112\u0006\u0010'\u001a\u00020\u001f2\u0006\u0010(\u001a\u00020)H\u0016J\b\u0010*\u001a\u00020!H\u0014J\b\u0010+\u001a\u00020!H\u0014J\b\u0010,\u001a\u00020!H\u0016J\b\u0010-\u001a\u00020!H\u0014J\b\u0010.\u001a\u00020!H\u0002J\b\u0010/\u001a\u00020!H\u0002J\u0010\u00100\u001a\u00020!2\u0006\u00101\u001a\u000202H\u0002J\b\u00103\u001a\u00020!H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u001d\u0010\u000b\u001a\u0004\u0018\u00010\f8BX\u0002¢\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u0010\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0019\u001a\u00020\u001a8BX\u0002¢\u0006\f\n\u0004\b\u001d\u0010\n\u001a\u0004\b\u001b\u0010\u001c¨\u00064"}, hxF = {"Lcom/tencent/mm/plugin/forcenotify/ui/ForceNotifyShowUI;", "Lcom/tencent/mm/plugin/forcenotify/ui/BaseForceNotifyShowUI;", "()V", "audioFocusChangeListener", "Landroid/media/AudioManager$OnAudioFocusChangeListener;", "audioManager", "Landroid/media/AudioManager;", "getAudioManager", "()Landroid/media/AudioManager;", "audioManager$delegate", "Lkotlin/Lazy;", "info", "Lcom/tencent/mm/plugin/forcenotify/model/ForceNotifyInfo;", "getInfo", "()Lcom/tencent/mm/plugin/forcenotify/model/ForceNotifyInfo;", "info$delegate", "needSound", "", "playSoundRunnable", "Ljava/lang/Runnable;", "soundPlay", "Landroid/media/MediaPlayer;", "stopSoundRunnable", "uiHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "vibrator", "Landroid/os/Vibrator;", "getVibrator", "()Landroid/os/Vibrator;", "vibrator$delegate", "getLayoutId", "", "onBackPressed", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onKeyDown", "keyCode", "event", "Landroid/view/KeyEvent;", "onPause", "onResume", "onStart", "onStop", "playSound", "reset", "setBlurBg", "view", "Landroid/view/View;", "stopSound", "plugin-force-notify_release"})
public final class ForceNotifyShowUI extends BaseForceNotifyShowUI {
    private MediaPlayer UWm;
    private Runnable UWn;
    private boolean UWo;
    private final kotlin.f UWp = kotlin.g.ah(new e(this));
    private AudioManager.OnAudioFocusChangeListener audioFocusChangeListener = a.UWq;
    private final MMHandler hAk = new MMHandler(Looper.getMainLooper());
    private final kotlin.f mKI = kotlin.g.ah(new d(this));
    private final kotlin.f uAh = kotlin.g.ah(new g(this));
    private Runnable wMt;

    private final AudioManager getAudioManager() {
        AppMethodBeat.i(261796);
        AudioManager audioManager = (AudioManager) this.mKI.getValue();
        AppMethodBeat.o(261796);
        return audioManager;
    }

    private final Vibrator getVibrator() {
        AppMethodBeat.i(261797);
        Vibrator vibrator = (Vibrator) this.uAh.getValue();
        AppMethodBeat.o(261797);
        return vibrator;
    }

    private final com.tencent.mm.plugin.forcenotify.c.d hVG() {
        AppMethodBeat.i(261798);
        com.tencent.mm.plugin.forcenotify.c.d dVar = (com.tencent.mm.plugin.forcenotify.c.d) this.UWp.getValue();
        AppMethodBeat.o(261798);
        return dVar;
    }

    @Override // com.tencent.mm.plugin.forcenotify.ui.BaseForceNotifyShowUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public ForceNotifyShowUI() {
        AppMethodBeat.i(149247);
        AppMethodBeat.o(149247);
    }

    public static final /* synthetic */ void b(ForceNotifyShowUI forceNotifyShowUI) {
        AppMethodBeat.i(261801);
        forceNotifyShowUI.hVH();
        AppMethodBeat.o(261801);
    }

    public static final /* synthetic */ com.tencent.mm.plugin.forcenotify.c.d c(ForceNotifyShowUI forceNotifyShowUI) {
        AppMethodBeat.i(261802);
        com.tencent.mm.plugin.forcenotify.c.d hVG = forceNotifyShowUI.hVG();
        AppMethodBeat.o(261802);
        return hVG;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "", "onAudioFocusChange"})
    static final class a implements AudioManager.OnAudioFocusChangeListener {
        public static final a UWq = new a();

        static {
            AppMethodBeat.i(261789);
            AppMethodBeat.o(261789);
        }

        a() {
        }

        public final void onAudioFocusChange(int i2) {
        }
    }

    @Override // com.tencent.mm.ui.MMActivity
    public final int getLayoutId() {
        return R.layout.amf;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.plugin.forcenotify.ui.BaseForceNotifyShowUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onCreate(Bundle bundle) {
        boolean z;
        int i2;
        AppMethodBeat.i(149237);
        super.onCreate(bundle);
        if (this.UWb == null) {
            finish();
            AppMethodBeat.o(149237);
            return;
        }
        com.tencent.mm.plugin.forcenotify.c.e eVar = this.UWb;
        if (eVar == null) {
            p.hyc();
        }
        Log.i(this.TAG, "V:%s V1:%s  R:%s", Integer.valueOf(getAudioManager().getVibrateSetting(1)), Integer.valueOf(getAudioManager().getVibrateSetting(0)), Integer.valueOf(getAudioManager().getRingerMode()));
        int requestAudioFocus = getAudioManager().requestAudioFocus(this.audioFocusChangeListener, 3, 2);
        Window window = getWindow();
        p.g(window, "window");
        View decorView = window.getDecorView();
        p.g(decorView, "window.decorView");
        decorView.setKeepScreenOn(true);
        this.UWo = true;
        this.UWn = new f(this);
        this.wMt = new b(this);
        p.g(findViewById(R.id.be9), "findViewById(R.id.content)");
        getWindow().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.agu)));
        Log.i(this.TAG, "[onCreate] forcePushId:%s requestAudioFocus:%s", eVar.wMn, Integer.valueOf(requestAudioFocus));
        TextView textView = (TextView) findViewById(R.id.fzg);
        ImageView imageView = (ImageView) findViewById(R.id.x1);
        TextView textView2 = (TextView) findViewById(R.id.k3u);
        ImageView imageView2 = (ImageView) findViewById(R.id.w1);
        findViewById(R.id.dt3).setOnClickListener(new c(this));
        if (eVar instanceof h) {
            if (n.nm(eVar.wMn, "@miniapp")) {
                q.bcV().loadImage(((h) eVar).kog, imageView);
            } else {
                a.b.d(imageView, ((h) eVar).username, 0.1f);
            }
            p.g(textView, "nicknameTv");
            textView.setText(((h) eVar).nickname);
            p.g(textView2, "wordingTv");
            textView2.setText(((h) eVar).dQx);
        } else if (eVar instanceof com.tencent.mm.plugin.forcenotify.c.g) {
            if (((com.tencent.mm.plugin.forcenotify.c.g) eVar).kog.length() > 0) {
                ((aj) com.tencent.mm.kernel.g.ah(aj.class)).loadAvatar(((com.tencent.mm.plugin.forcenotify.c.g) eVar).kog, imageView);
            } else {
                AppCompatActivity context = getContext();
                p.g(context, "context");
                imageView.setImageDrawable(com.tencent.mm.svg.a.a.h(context.getResources(), R.raw.default_round_avatar));
            }
            if (((com.tencent.mm.plugin.forcenotify.c.g) eVar).authIconUrl != null) {
                if (((com.tencent.mm.plugin.forcenotify.c.g) eVar).authIconUrl.length() > 0) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    p.g(imageView2, "authIv");
                    imageView2.setVisibility(0);
                    ((aj) com.tencent.mm.kernel.g.ah(aj.class)).loadImage(((com.tencent.mm.plugin.forcenotify.c.g) eVar).authIconUrl, imageView2);
                    p.g(textView, "nicknameTv");
                    textView.setText(((com.tencent.mm.plugin.forcenotify.c.g) eVar).nickname);
                    p.g(textView2, "wordingTv");
                    textView2.setText(((com.tencent.mm.plugin.forcenotify.c.g) eVar).dQx);
                }
            }
            p.g(imageView2, "authIv");
            imageView2.setVisibility(8);
            p.g(textView, "nicknameTv");
            textView.setText(((com.tencent.mm.plugin.forcenotify.c.g) eVar).nickname);
            p.g(textView2, "wordingTv");
            textView2.setText(((com.tencent.mm.plugin.forcenotify.c.g) eVar).dQx);
        }
        com.tencent.mm.plugin.forcenotify.c.e eVar2 = this.UWb;
        if (eVar2 != null) {
            com.tencent.mm.plugin.forcenotify.a.a aVar = (com.tencent.mm.plugin.forcenotify.a.a) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.forcenotify.a.a.class);
            String str = eVar2.wMn;
            com.tencent.mm.plugin.forcenotify.b.c cVar = com.tencent.mm.plugin.forcenotify.b.c.wLS;
            AppCompatActivity context2 = getContext();
            p.g(context2, "context");
            if (cVar.fR(context2)) {
                com.tencent.mm.plugin.forcenotify.b.c cVar2 = com.tencent.mm.plugin.forcenotify.b.c.wLS;
                AppCompatActivity context3 = getContext();
                p.g(context3, "context");
                i2 = cVar2.fS(context3) ? 1 : 4;
            } else {
                com.tencent.mm.plugin.forcenotify.b.c cVar3 = com.tencent.mm.plugin.forcenotify.b.c.wLS;
                AppCompatActivity context4 = getContext();
                p.g(context4, "context");
                i2 = cVar3.fS(context4) ? 3 : 2;
            }
            aVar.A(str, i2, cl.aWz() / 1000);
        }
        com.tencent.mm.plugin.forcenotify.d.a.wLU.gC(eVar.wMn);
        AppMethodBeat.o(149237);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class f implements Runnable {
        final /* synthetic */ ForceNotifyShowUI wMw;

        f(ForceNotifyShowUI forceNotifyShowUI) {
            this.wMw = forceNotifyShowUI;
        }

        public final void run() {
            AppMethodBeat.i(261792);
            ForceNotifyShowUI.a(this.wMw);
            AppMethodBeat.o(261792);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class b implements Runnable {
        final /* synthetic */ ForceNotifyShowUI wMw;

        b(ForceNotifyShowUI forceNotifyShowUI) {
            this.wMw = forceNotifyShowUI;
        }

        public final void run() {
            AppMethodBeat.i(261793);
            ForceNotifyShowUI.b(this.wMw);
            this.wMw.UWo = false;
            AppMethodBeat.o(261793);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class c implements View.OnClickListener {
        final /* synthetic */ ForceNotifyShowUI wMw;

        c(ForceNotifyShowUI forceNotifyShowUI) {
            this.wMw = forceNotifyShowUI;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(261794);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/forcenotify/ui/ForceNotifyShowUI$onCreate$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            com.tencent.mm.plugin.forcenotify.c.d c2 = ForceNotifyShowUI.c(this.wMw);
            if (c2 != null && c2.field_CreateTime > 0) {
                ((com.tencent.mm.plugin.forcenotify.a.a) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.forcenotify.a.a.class)).f(c2.field_ForcePushId, String.valueOf(c2.field_CreateTime / 1000) + c2.field_UserName, 2, cl.aWz() / 1000);
            }
            this.wMw.UWo = false;
            this.wMw.finish();
            this.wMw.overridePendingTransition(0, R.anim.f6do);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/forcenotify/ui/ForceNotifyShowUI$onCreate$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(261794);
        }
    }

    private final void hVH() {
        AppMethodBeat.i(261799);
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
            Window window = getWindow();
            p.g(window, "window");
            View decorView = window.getDecorView();
            p.g(decorView, "window.decorView");
            decorView.setKeepScreenOn(false);
            getAudioManager().abandonAudioFocus(this.audioFocusChangeListener);
            AppMethodBeat.o(261799);
        } catch (Exception e2) {
            AppMethodBeat.o(261799);
        }
    }

    @Override // com.tencent.mm.plugin.forcenotify.ui.BaseForceNotifyShowUI, com.tencent.mm.ui.component.UIComponentActivity, android.support.v4.app.FragmentActivity
    public final void onBackPressed() {
        AppMethodBeat.i(149238);
        super.onBackPressed();
        Log.i(this.TAG, "[onBackPressed]");
        com.tencent.mm.plugin.forcenotify.c.d hVG = hVG();
        if (hVG != null) {
            ((com.tencent.mm.plugin.forcenotify.a.a) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.forcenotify.a.a.class)).f(hVG.field_ForcePushId, String.valueOf(hVG.field_CreateTime / 1000) + hVG.field_UserName, 8, cl.aWz() / 1000);
            AppMethodBeat.o(149238);
            return;
        }
        AppMethodBeat.o(149238);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onStart() {
        AppMethodBeat.i(149241);
        super.onStart();
        Log.i(this.TAG, "onStart");
        if (this.UWo) {
            this.hAk.postDelayed(this.UWn, 1000);
            this.hAk.postDelayed(this.wMt, Util.MILLSECONDS_OF_MINUTE);
        }
        AppMethodBeat.o(149241);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onResume() {
        AppMethodBeat.i(149242);
        super.onResume();
        Log.i(this.TAG, "onResume");
        AppMethodBeat.o(149242);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onPause() {
        AppMethodBeat.i(149243);
        super.onPause();
        Log.i(this.TAG, "onPause");
        AppMethodBeat.o(149243);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onStop() {
        AppMethodBeat.i(149244);
        super.onStop();
        reset();
        Log.i(this.TAG, "onStop");
        AppMethodBeat.o(149244);
    }

    @Override // com.tencent.mm.plugin.forcenotify.ui.BaseForceNotifyShowUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onDestroy() {
        String str;
        AppMethodBeat.i(149245);
        super.onDestroy();
        reset();
        this.UWn = null;
        this.wMt = null;
        com.tencent.mm.plugin.forcenotify.c.e eVar = this.UWb;
        if (eVar == null || (str = eVar.wMn) == null) {
            AppMethodBeat.o(149245);
            return;
        }
        com.tencent.mm.plugin.forcenotify.d.a.wLU.gC(str);
        AppMethodBeat.o(149245);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "Landroid/media/AudioManager;", "invoke"})
    static final class d extends kotlin.g.b.q implements kotlin.g.a.a<AudioManager> {
        final /* synthetic */ ForceNotifyShowUI wMw;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(ForceNotifyShowUI forceNotifyShowUI) {
            super(0);
            this.wMw = forceNotifyShowUI;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ AudioManager invoke() {
            AppMethodBeat.i(261790);
            Object systemService = this.wMw.getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE);
            if (systemService == null) {
                t tVar = new t("null cannot be cast to non-null type android.media.AudioManager");
                AppMethodBeat.o(261790);
                throw tVar;
            }
            AudioManager audioManager = (AudioManager) systemService;
            AppMethodBeat.o(261790);
            return audioManager;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "Landroid/os/Vibrator;", "invoke"})
    static final class g extends kotlin.g.b.q implements kotlin.g.a.a<Vibrator> {
        final /* synthetic */ ForceNotifyShowUI wMw;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        g(ForceNotifyShowUI forceNotifyShowUI) {
            super(0);
            this.wMw = forceNotifyShowUI;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ Vibrator invoke() {
            AppMethodBeat.i(261795);
            Object systemService = this.wMw.getContext().getSystemService("vibrator");
            if (systemService == null) {
                t tVar = new t("null cannot be cast to non-null type android.os.Vibrator");
                AppMethodBeat.o(261795);
                throw tVar;
            }
            Vibrator vibrator = (Vibrator) systemService;
            AppMethodBeat.o(261795);
            return vibrator;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "Lcom/tencent/mm/plugin/forcenotify/model/ForceNotifyInfo;", "invoke"})
    static final class e extends kotlin.g.b.q implements kotlin.g.a.a<com.tencent.mm.plugin.forcenotify.c.d> {
        final /* synthetic */ ForceNotifyShowUI wMw;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(ForceNotifyShowUI forceNotifyShowUI) {
            super(0);
            this.wMw = forceNotifyShowUI;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ com.tencent.mm.plugin.forcenotify.c.d invoke() {
            AppMethodBeat.i(261791);
            com.tencent.mm.plugin.forcenotify.c.e eVar = this.wMw.UWb;
            if (eVar != null) {
                com.tencent.mm.plugin.forcenotify.d.a aVar = com.tencent.mm.plugin.forcenotify.d.a.wLU;
                com.tencent.mm.plugin.forcenotify.c.d byi = com.tencent.mm.plugin.forcenotify.d.a.byi(eVar.wMn);
                AppMethodBeat.o(261791);
                return byi;
            }
            AppMethodBeat.o(261791);
            return null;
        }
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, android.support.v7.app.AppCompatActivity
    public final boolean onKeyDown(int i2, KeyEvent keyEvent) {
        AppMethodBeat.i(149240);
        p.h(keyEvent, "event");
        Log.i(this.TAG, "[onKeyDown] keyCode:".concat(String.valueOf(i2)));
        reset();
        boolean onKeyDown = super.onKeyDown(i2, keyEvent);
        AppMethodBeat.o(149240);
        return onKeyDown;
    }

    private final void reset() {
        AppMethodBeat.i(149246);
        Log.i(this.TAG, "reset");
        Window window = getWindow();
        p.g(window, "window");
        View decorView = window.getDecorView();
        p.g(decorView, "window.decorView");
        decorView.setKeepScreenOn(false);
        this.hAk.removeCallbacksAndMessages(null);
        try {
            Window window2 = getWindow();
            p.g(window2, "window");
            window2.getDecorView().removeCallbacks(this.wMt);
            hVH();
            AppMethodBeat.o(149246);
        } catch (IllegalStateException e2) {
            Log.printErrStackTrace(this.TAG, e2, "", new Object[0]);
            AppMethodBeat.o(149246);
        }
    }

    public static final /* synthetic */ void a(ForceNotifyShowUI forceNotifyShowUI) {
        AppMethodBeat.i(261800);
        com.tencent.mm.plugin.forcenotify.b.c cVar = com.tencent.mm.plugin.forcenotify.b.c.wLS;
        AppCompatActivity context = forceNotifyShowUI.getContext();
        p.g(context, "context");
        if (!cVar.fR(context)) {
            Log.i(forceNotifyShowUI.TAG, "PlaySound.playRoot");
            forceNotifyShowUI.UWm = PlaySound.playRoot(forceNotifyShowUI.getContext(), R.string.dha, PlaySound.SPEAKERON.NOTSET, 2, true, null);
        }
        com.tencent.mm.plugin.forcenotify.b.c cVar2 = com.tencent.mm.plugin.forcenotify.b.c.wLS;
        AppCompatActivity context2 = forceNotifyShowUI.getContext();
        p.g(context2, "context");
        if (cVar2.fS(context2)) {
            Log.i(forceNotifyShowUI.TAG, "vibrator.vibrate");
            forceNotifyShowUI.getVibrator().vibrate(new long[]{1000, 1000, 1000, 1000}, 0);
        }
        AppMethodBeat.o(261800);
    }
}

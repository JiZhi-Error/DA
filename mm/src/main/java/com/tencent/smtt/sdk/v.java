package com.tencent.smtt.sdk;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.a;
import com.tencent.smtt.export.external.DexLoader;

/* access modifiers changed from: package-private */
public class v extends FrameLayout implements MediaPlayer.OnErrorListener {
    private byte _hellAccFlag_;

    /* renamed from: a  reason: collision with root package name */
    private Object f2134a;

    /* renamed from: b  reason: collision with root package name */
    private w f2135b;

    /* renamed from: c  reason: collision with root package name */
    private VideoView f2136c;

    /* renamed from: d  reason: collision with root package name */
    private Context f2137d = null;

    /* renamed from: e  reason: collision with root package name */
    private String f2138e;

    public v(Context context) {
        super(context.getApplicationContext());
        AppMethodBeat.i(188393);
        this.f2137d = context;
        AppMethodBeat.o(188393);
    }

    /* access modifiers changed from: package-private */
    public void a(Bundle bundle, Object obj) {
        AppMethodBeat.i(188394);
        b(bundle, obj);
        AppMethodBeat.o(188394);
    }

    private void b(Bundle bundle, Object obj) {
        boolean z;
        AppMethodBeat.i(188395);
        a();
        if (b()) {
            bundle.putInt("callMode", bundle.getInt("callMode"));
            z = this.f2135b.a(this.f2134a, bundle, this, obj);
        } else {
            z = false;
        }
        if (!z) {
            if (this.f2136c != null) {
                this.f2136c.stopPlayback();
            }
            if (this.f2136c == null) {
                this.f2136c = new VideoView(getContext());
            }
            this.f2138e = bundle.getString("videoUrl");
            this.f2136c.setVideoURI(Uri.parse(this.f2138e));
            this.f2136c.setOnErrorListener(this);
            Intent intent = new Intent("com.tencent.smtt.tbs.video.PLAY");
            intent.addFlags(268435456);
            Context applicationContext = getContext().getApplicationContext();
            intent.setPackage(applicationContext.getPackageName());
            a bl = new a().bl(intent);
            com.tencent.mm.hellhoundlib.a.a.a(applicationContext, bl.axQ(), "com/tencent/smtt/sdk/v", "b", "(Landroid/os/Bundle;Ljava/lang/Object;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            applicationContext.startActivity((Intent) bl.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(applicationContext, "com/tencent/smtt/sdk/v", "b", "(Landroid/os/Bundle;Ljava/lang/Object;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        }
        AppMethodBeat.o(188395);
    }

    /* access modifiers changed from: package-private */
    public void a() {
        DexLoader dexLoader = null;
        AppMethodBeat.i(188396);
        setBackgroundColor(WebView.NIGHT_MODE_COLOR);
        if (this.f2135b == null) {
            g.a(true).a(getContext().getApplicationContext(), false, false, null);
            TbsWizard a2 = g.a(true).a();
            if (a2 != null) {
                dexLoader = a2.dexLoader();
            }
            if (dexLoader != null && QbSdk.canLoadVideo(getContext())) {
                this.f2135b = new w(dexLoader);
            }
        }
        if (this.f2135b != null && this.f2134a == null) {
            this.f2134a = this.f2135b.a(getContext().getApplicationContext());
        }
        AppMethodBeat.o(188396);
    }

    public boolean b() {
        return (this.f2135b == null || this.f2134a == null) ? false : true;
    }

    public void a(Activity activity) {
        AppMethodBeat.i(188397);
        if (!b() && this.f2136c != null) {
            if (this.f2136c.getParent() == null) {
                Window window = activity.getWindow();
                FrameLayout frameLayout = (FrameLayout) window.getDecorView();
                window.addFlags(1024);
                window.addFlags(128);
                frameLayout.setBackgroundColor(WebView.NIGHT_MODE_COLOR);
                MediaController mediaController = new MediaController(activity);
                mediaController.setMediaPlayer(this.f2136c);
                this.f2136c.setMediaController(mediaController);
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
                layoutParams.gravity = 17;
                frameLayout.addView(this.f2136c, layoutParams);
            }
            if (Build.VERSION.SDK_INT >= 8) {
                this.f2136c.start();
            }
        }
        AppMethodBeat.o(188397);
    }

    /* access modifiers changed from: package-private */
    public void a(Activity activity, int i2) {
        AppMethodBeat.i(188398);
        if (i2 == 3 && !b() && this.f2136c != null) {
            this.f2136c.pause();
        }
        if (i2 == 4) {
            this.f2137d = null;
            if (!b() && this.f2136c != null) {
                this.f2136c.stopPlayback();
                this.f2136c = null;
            }
        }
        if (i2 == 2 && !b()) {
            this.f2137d = activity;
            a(activity);
        }
        if (b()) {
            this.f2135b.a(this.f2134a, activity, i2);
        }
        AppMethodBeat.o(188398);
    }

    public boolean onError(MediaPlayer mediaPlayer, int i2, int i3) {
        AppMethodBeat.i(188399);
        try {
            if (this.f2137d instanceof Activity) {
                Activity activity = (Activity) this.f2137d;
                if (!activity.isFinishing()) {
                    activity.finish();
                }
            }
            Context context = getContext();
            if (context != null) {
                Toast.makeText(context, "播放失败，请选择其它播放器播放", 1).show();
                Context applicationContext = context.getApplicationContext();
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.addFlags(268435456);
                intent.setDataAndType(Uri.parse(this.f2138e), "video/*");
                a bl = new a().bl(intent);
                com.tencent.mm.hellhoundlib.a.a.a(applicationContext, bl.axQ(), "com/tencent/smtt/sdk/v", "onError", "(Landroid/media/MediaPlayer;II)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                applicationContext.startActivity((Intent) bl.pG(0));
                com.tencent.mm.hellhoundlib.a.a.a(applicationContext, "com/tencent/smtt/sdk/v", "onError", "(Landroid/media/MediaPlayer;II)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            }
            AppMethodBeat.o(188399);
            return true;
        } catch (Throwable th) {
            AppMethodBeat.o(188399);
            return false;
        }
    }

    public void c() {
        AppMethodBeat.i(188400);
        if (b()) {
            this.f2135b.a(this.f2134a);
        }
        AppMethodBeat.o(188400);
    }
}

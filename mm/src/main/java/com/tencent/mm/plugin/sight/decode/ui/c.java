package com.tencent.mm.plugin.sight.decode.ui;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Base64;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.av.q;
import com.tencent.mm.booter.a;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.g.a.yh;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.d;
import com.tencent.mm.plugin.sight.base.e;
import com.tencent.mm.pluginsdk.ui.tools.VideoSurfaceView;
import com.tencent.mm.pluginsdk.ui.tools.VideoTextureView;
import com.tencent.mm.pluginsdk.ui.tools.j;
import com.tencent.mm.sdk.crash.CrashReportFactory;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.FileProviderHelper;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.i;
import com.tencent.mm.vfs.o;
import com.tencent.thumbplayer.core.common.TPMediaCodecProfileLevel;

public final class c extends i implements d.a {
    private TextView DnJ = null;
    private boolean DnK = false;
    public int Dne = 0;
    public int eeF = 0;
    public String fullPath;
    public String imagePath;
    private d pNk = new d();
    private j qbJ = null;
    public int tex = 0;

    static /* synthetic */ void e(c cVar) {
        AppMethodBeat.i(116136);
        cVar.eVM();
        AppMethodBeat.o(116136);
    }

    public c(Context context) {
        super(context, R.style.a7b);
        AppMethodBeat.i(116131);
        AppMethodBeat.o(116131);
    }

    /* access modifiers changed from: protected */
    public final void onCreate(Bundle bundle) {
        AppMethodBeat.i(116132);
        long currentTimeMillis = System.currentTimeMillis();
        Log.d("MicroMsg.VideoPopupHelper", currentTimeMillis + " initView beg");
        super.onCreate(bundle);
        getWindow().setFlags(TPMediaCodecProfileLevel.HEVCMainTierLevel62, TPMediaCodecProfileLevel.HEVCMainTierLevel62);
        setContentView(R.layout.bsa);
        if (a.akp() != null) {
            a.akp().akr();
        }
        Log.d("MicroMsg.VideoPopupHelper", f.app() + " initView: fullpath:" + this.fullPath + ", imagepath:" + this.imagePath);
        this.DnJ = (TextView) findViewById(R.id.ipe);
        findViewById(R.id.hqu).setVisibility(8);
        ViewGroup viewGroup = (ViewGroup) findViewById(R.id.j44);
        viewGroup.setBackgroundResource(R.color.fm);
        Log.i("MicroMsg.VideoPopupHelper", "getVideoView, is normal video");
        if (com.tencent.mm.compatible.util.d.oD(14)) {
            this.qbJ = new VideoTextureView(getContext());
        } else {
            this.qbJ = new VideoSurfaceView(getContext());
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(13);
        viewGroup.addView((View) this.qbJ, layoutParams);
        this.qbJ.setVideoCallback(new j.a() {
            /* class com.tencent.mm.plugin.sight.decode.ui.c.AnonymousClass1 */

            @Override // com.tencent.mm.pluginsdk.ui.tools.j.a
            public final void tf() {
                AppMethodBeat.i(116125);
                Log.d("MicroMsg.VideoPopupHelper", f.app() + " onPrepared");
                c.a(c.this);
                AppMethodBeat.o(116125);
            }

            @Override // com.tencent.mm.pluginsdk.ui.tools.j.a
            public final void onError(int i2, int i3) {
                AppMethodBeat.i(116126);
                Log.e("MicroMsg.VideoPopupHelper", "on play video error, what %d extra %d", Integer.valueOf(i2), Integer.valueOf(i3));
                c.this.qbJ.stop();
                CrashReportFactory.reportRawMessage(Base64.encodeToString((e.eVv() + "[SightPopupHelper] on play video error, what " + i2 + " extra " + i3 + ", path=" + Util.nullAs(c.this.imagePath, "")).getBytes(), 2), "FullScreenPlaySight");
                final String str = c.this.imagePath;
                com.tencent.mm.av.i bcR = q.bcR();
                float density = com.tencent.mm.cb.a.getDensity(c.this.getContext());
                c.this.getContext();
                final Bitmap a2 = bcR.a(str, density, -1);
                MMHandlerThread.postToMainThread(new Runnable() {
                    /* class com.tencent.mm.plugin.sight.decode.ui.c.AnonymousClass1.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(116123);
                        ImageView imageView = (ImageView) c.this.findViewById(R.id.j73);
                        imageView.setImageBitmap(a2);
                        imageView.setVisibility(0);
                        Intent intent = new Intent();
                        intent.setAction("android.intent.action.VIEW");
                        FileProviderHelper.setIntentDataAndType(c.this.getContext(), intent, new o(str), "video/*", false);
                        try {
                            Context context = c.this.getContext();
                            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(Intent.createChooser(intent, c.this.getContext().getString(R.string.zw)));
                            com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/plugin/sight/decode/ui/SightPopupHelper$1$1", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                            context.startActivity((Intent) bl.pG(0));
                            com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/plugin/sight/decode/ui/SightPopupHelper$1$1", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                            AppMethodBeat.o(116123);
                        } catch (Exception e2) {
                            Log.e("MicroMsg.VideoPopupHelper", "startActivity fail, activity not found");
                            h.n(c.this.getContext(), R.string.fds, R.string.fdt);
                            AppMethodBeat.o(116123);
                        }
                    }
                });
                AppMethodBeat.o(116126);
            }

            @Override // com.tencent.mm.pluginsdk.ui.tools.j.a
            public final void onCompletion() {
                AppMethodBeat.i(116127);
                Log.d("MicroMsg.VideoPopupHelper", "on completion");
                c.this.DnJ.post(new Runnable() {
                    /* class com.tencent.mm.plugin.sight.decode.ui.c.AnonymousClass1.AnonymousClass2 */

                    public final void run() {
                        AppMethodBeat.i(116124);
                        c.this.DnJ.setVisibility(0);
                        c.this.DnJ.startAnimation(AnimationUtils.loadAnimation(c.this.getContext(), R.anim.br));
                        AppMethodBeat.o(116124);
                    }
                });
                c.this.qbJ.setLoop(true);
                c.a(c.this);
                AppMethodBeat.o(116127);
            }

            @Override // com.tencent.mm.pluginsdk.ui.tools.j.a
            public final int fh(int i2, int i3) {
                return 0;
            }

            @Override // com.tencent.mm.pluginsdk.ui.tools.j.a
            public final void eo(int i2, int i3) {
            }
        });
        findViewById(R.id.j44).setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.sight.decode.ui.c.AnonymousClass2 */

            public final void onClick(View view) {
                AppMethodBeat.i(116128);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sight/decode/ui/SightPopupHelper$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                c.e(c.this);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sight/decode/ui/SightPopupHelper$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(116128);
            }
        });
        ((View) this.qbJ).setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.sight.decode.ui.c.AnonymousClass3 */

            public final void onClick(View view) {
                AppMethodBeat.i(116129);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sight/decode/ui/SightPopupHelper$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                c.e(c.this);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sight/decode/ui/SightPopupHelper$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(116129);
            }
        });
        if (this.fullPath != null) {
            this.qbJ.stop();
            this.qbJ.setVideoPath(this.fullPath);
        }
        Log.d("MicroMsg.VideoPopupHelper", (System.currentTimeMillis() - currentTimeMillis) + " initView end");
        yh yhVar = new yh();
        yhVar.eeC.type = 1;
        EventCenter.instance.publish(yhVar);
        AppMethodBeat.o(116132);
    }

    private void eVM() {
        AppMethodBeat.i(116133);
        Log.v("check", "onclick");
        if (this.qbJ.isPlaying()) {
            this.qbJ.pause();
            this.pNk.fp(false);
        }
        new MMHandler().post(new Runnable() {
            /* class com.tencent.mm.plugin.sight.decode.ui.c.AnonymousClass4 */

            public final void run() {
                AppMethodBeat.i(116130);
                c.this.dismiss();
                AppMethodBeat.o(116130);
            }
        });
        AppMethodBeat.o(116133);
    }

    @Override // com.tencent.mm.ui.base.i
    public final void dismiss() {
        AppMethodBeat.i(116134);
        Log.d("MicroMsg.VideoPopupHelper", "on dismiss");
        if (a.akp() != null) {
            a.akp().akq();
        }
        if (this.qbJ != null) {
            this.qbJ.setVideoCallback(null);
            this.qbJ.stop();
            this.qbJ.onDetach();
            findViewById(R.id.j44).setOnClickListener(null);
        }
        if (!this.DnK && isShowing()) {
            yh yhVar = new yh();
            yhVar.eeC.type = 0;
            yhVar.eeC.eeD = this.Dne;
            yhVar.eeC.eeE = this.tex;
            yhVar.eeC.eeF = this.eeF;
            EventCenter.instance.publish(yhVar);
        }
        super.dismiss();
        this.pNk.fp(true);
        AppMethodBeat.o(116134);
    }

    @Override // com.tencent.mm.model.d.a
    public final void aTw() {
    }

    @Override // com.tencent.mm.model.d.a
    public final void aTx() {
    }

    @Override // com.tencent.mm.model.d.a
    public final void aTy() {
    }

    @Override // com.tencent.mm.model.d.a
    public final void aTz() {
    }

    static /* synthetic */ void a(c cVar) {
        AppMethodBeat.i(116135);
        if (!cVar.qbJ.start()) {
            cVar.eVM();
            AppMethodBeat.o(116135);
            return;
        }
        cVar.pNk.a(cVar);
        AppMethodBeat.o(116135);
    }
}

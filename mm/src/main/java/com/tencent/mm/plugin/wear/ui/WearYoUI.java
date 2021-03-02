package com.tencent.mm.plugin.wear.ui;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.br.c;
import com.tencent.mm.g.a.aar;
import com.tencent.mm.g.a.ma;
import com.tencent.mm.hellhoundlib.activities.HellActivity;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.bg;
import com.tencent.mm.pluginsdk.ui.a;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import java.lang.reflect.Array;
import java.util.concurrent.atomic.AtomicInteger;

public class WearYoUI extends HellActivity {
    private ImageView IyL;
    private ImageView IyM;
    private ImageView IyN;
    private ObjectAnimator[][] IyO = ((ObjectAnimator[][]) Array.newInstance(ObjectAnimator.class, 3, 3));
    private IListener IyP = new IListener<aar>() {
        /* class com.tencent.mm.plugin.wear.ui.WearYoUI.AnonymousClass2 */

        {
            AppMethodBeat.i(161472);
            this.__eventId = aar.class.getName().hashCode();
            AppMethodBeat.o(161472);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(aar aar) {
            AppMethodBeat.i(30140);
            aar aar2 = aar;
            if (aar2 instanceof aar) {
                switch (aar2.ehE.dDe) {
                    case 1:
                        if (!WearYoUI.this.username.equals(aar2.ehE.username)) {
                            aar2.ehF.ehG = 2;
                            break;
                        } else {
                            aar2.ehF.ehG = 1;
                            break;
                        }
                    case 2:
                        if (WearYoUI.this.username.equals(aar2.ehE.username)) {
                            WearYoUI.b(WearYoUI.this);
                            break;
                        }
                        break;
                }
            }
            AppMethodBeat.o(30140);
            return false;
        }
    };
    private boolean IyQ;
    private Runnable IyR = new Runnable() {
        /* class com.tencent.mm.plugin.wear.ui.WearYoUI.AnonymousClass3 */

        public final void run() {
            AppMethodBeat.i(30141);
            WearYoUI.this.paT.vibrate(200);
            WearYoUI.this.gvv.animate().scaleX(1.2f);
            WearYoUI.this.gvv.animate().scaleY(1.2f);
            WearYoUI.this.gvv.animate().setDuration(200);
            WearYoUI.this.gvv.animate().start();
            WearYoUI.this.gvv.animate().setListener(new a(1));
            AppMethodBeat.o(30141);
        }
    };
    private BroadcastReceiver IyS = new BroadcastReceiver() {
        /* class com.tencent.mm.plugin.wear.ui.WearYoUI.AnonymousClass4 */

        public final void onReceive(Context context, Intent intent) {
            AppMethodBeat.i(30142);
            if (intent.getAction() == "android.intent.action.CLOSE_SYSTEM_DIALOGS") {
                WearYoUI.this.finish();
            }
            AppMethodBeat.o(30142);
        }
    };
    private ImageView gvv;
    private TextView gvw;
    private IListener hvF = new IListener<ma>() {
        /* class com.tencent.mm.plugin.wear.ui.WearYoUI.AnonymousClass5 */

        {
            AppMethodBeat.i(161473);
            this.__eventId = ma.class.getName().hashCode();
            AppMethodBeat.o(161473);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(ma maVar) {
            AppMethodBeat.i(30143);
            if (maVar instanceof ma) {
                WearYoUI.this.finish();
            }
            AppMethodBeat.o(30143);
            return false;
        }
    };
    private AtomicInteger ohs = new AtomicInteger();
    private Vibrator paT;
    private String username;

    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public WearYoUI() {
        AppMethodBeat.i(30146);
        AppMethodBeat.o(30146);
    }

    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(30147);
        super.onCreate(bundle);
        getWindow().addFlags(4718592);
        setContentView(R.layout.cb8);
        this.paT = (Vibrator) getSystemService("vibrator");
        this.username = getIntent().getStringExtra("key_talker");
        this.gvv = (ImageView) findViewById(R.id.x1);
        this.gvw = (TextView) findViewById(R.id.fzg);
        this.IyL = (ImageView) findViewById(R.id.xd);
        this.IyM = (ImageView) findViewById(R.id.xe);
        this.IyN = (ImageView) findViewById(R.id.xf);
        a.b.d(this.gvv, this.username);
        this.gvw.setText(aa.getDisplayName(this.username));
        this.gvv.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.wear.ui.WearYoUI.AnonymousClass1 */

            public final void onClick(View view) {
                AppMethodBeat.i(30139);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wear/ui/WearYoUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                com.tencent.mm.plugin.wear.model.a.fVO();
                String str = WearYoUI.this.username;
                Log.i("MicroMsg.wear.WearYoLogic", "click avatarIV %s", str);
                Intent intent = new Intent();
                intent.putExtra("Main_User", str);
                intent.putExtra("From_fail_notify", true);
                intent.addFlags(536870912);
                intent.addFlags(67108864);
                c.f(MMApplicationContext.getContext(), "com.tencent.mm.ui.LauncherUI", intent);
                WearYoUI.this.finish();
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wear/ui/WearYoUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(30139);
            }
        });
        EventCenter.instance.addListener(this.IyP);
        EventCenter.instance.addListener(this.hvF);
        a(0, this.IyL, 0);
        a(1, this.IyM, 1300);
        a(2, this.IyN, 2600);
        this.paT.vibrate(200);
        registerReceiver(this.IyS, new IntentFilter("android.intent.action.CLOSE_SYSTEM_DIALOGS"));
        overridePendingTransition(R.anim.av, R.anim.aw);
        AppMethodBeat.o(30147);
    }

    private void a(int i2, ImageView imageView, long j2) {
        AppMethodBeat.i(30148);
        this.IyO[i2][0] = ObjectAnimator.ofFloat(imageView, "scaleX", 1.0f, 2.5f);
        this.IyO[i2][0].setRepeatCount(-1);
        this.IyO[i2][0].setStartDelay(j2);
        this.IyO[i2][0].setDuration(3900L);
        this.IyO[i2][0].start();
        this.IyO[i2][1] = ObjectAnimator.ofFloat(imageView, "scaleY", 1.0f, 2.5f);
        this.IyO[i2][1].setRepeatCount(-1);
        this.IyO[i2][1].setStartDelay(j2);
        this.IyO[i2][1].setDuration(3900L);
        this.IyO[i2][1].start();
        this.IyO[i2][2] = ObjectAnimator.ofFloat(imageView, "alpha", 1.0f, 0.0f);
        this.IyO[i2][2].setRepeatCount(-1);
        this.IyO[i2][2].setInterpolator(new AccelerateInterpolator());
        this.IyO[i2][2].setStartDelay(j2);
        this.IyO[i2][2].setDuration(3900L);
        this.IyO[i2][2].start();
        AppMethodBeat.o(30148);
    }

    public void onClickCheck(View view) {
        AppMethodBeat.i(30149);
        Log.i("MicroMsg.Wear.WearYoUI", "onClickCheck %s", this.username);
        bg.azz().a(new com.tencent.mm.plugin.wear.model.d.b(this.username), 0);
        finish();
        AppMethodBeat.o(30149);
    }

    public void onClickNoCheck(View view) {
        AppMethodBeat.i(30150);
        Log.i("MicroMsg.Wear.WearYoUI", "onClickNoCheck %s", this.username);
        finish();
        AppMethodBeat.o(30150);
    }

    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity
    public void onDestroy() {
        AppMethodBeat.i(30151);
        for (int i2 = 0; i2 < this.IyO.length; i2++) {
            for (int i3 = 0; i3 < this.IyO[i2].length; i3++) {
                this.IyO[i2][i3].cancel();
            }
        }
        unregisterReceiver(this.IyS);
        EventCenter.instance.removeListener(this.hvF);
        EventCenter.instance.removeListener(this.IyP);
        com.tencent.mm.plugin.wear.model.a.fVO().fWh();
        super.onDestroy();
        AppMethodBeat.o(30151);
    }

    class a implements Animator.AnimatorListener {
        private int lCq = 1;

        public a(int i2) {
            this.lCq = i2;
        }

        public final void onAnimationStart(Animator animator) {
        }

        public final void onAnimationEnd(Animator animator) {
            AppMethodBeat.i(30144);
            if (this.lCq == 2) {
                Log.v("MicroMsg.Wear.WearYoUI", "onAnimationEnd count: %d", Integer.valueOf(WearYoUI.this.ohs.get()));
                if (WearYoUI.this.ohs.get() > 0) {
                    WearYoUI.this.ohs.decrementAndGet();
                    MMHandlerThread.postToMainThreadDelayed(WearYoUI.this.IyR, 1000);
                    AppMethodBeat.o(30144);
                    return;
                }
                WearYoUI.this.gvv.animate().setListener(null);
                WearYoUI.this.IyQ = false;
                AppMethodBeat.o(30144);
                return;
            }
            if (this.lCq == 1) {
                WearYoUI.this.gvv.animate().scaleX(1.0f);
                WearYoUI.this.gvv.animate().scaleY(1.0f);
                WearYoUI.this.gvv.animate().setDuration(100);
                WearYoUI.this.gvv.animate().start();
                WearYoUI.this.gvv.animate().setListener(new a(2));
            }
            AppMethodBeat.o(30144);
        }

        public final void onAnimationCancel(Animator animator) {
            AppMethodBeat.i(30145);
            WearYoUI.this.IyQ = false;
            AppMethodBeat.o(30145);
        }

        public final void onAnimationRepeat(Animator animator) {
        }
    }

    static /* synthetic */ void b(WearYoUI wearYoUI) {
        AppMethodBeat.i(30152);
        if (wearYoUI.IyQ) {
            wearYoUI.ohs.addAndGet(1);
            Log.v("MicroMsg.Wear.WearYoUI", "startAnimation count: %d", Integer.valueOf(wearYoUI.ohs.get()));
            AppMethodBeat.o(30152);
            return;
        }
        wearYoUI.IyQ = true;
        MMHandlerThread.postToMainThread(wearYoUI.IyR);
        AppMethodBeat.o(30152);
    }
}

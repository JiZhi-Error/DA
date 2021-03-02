package com.tencent.mm.plugin.wallet_core.ui.view;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.OvershootInterpolator;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import e.a.a.f;
import java.io.IOException;

@a(3)
public class WalletSuccPageAwardLuckyMoneyDialog extends MMActivity {
    private ImageView CPf;
    private f InV;
    private ViewGroup zhm;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(71551);
        super.onCreate(bundle);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        if (d.oD(19)) {
            getWindow().setFlags(67108864, 67108864);
        }
        byte[] byteArrayExtra = getIntent().getByteArrayExtra("key_layer_info");
        if (byteArrayExtra == null) {
            Log.e("MicroMsg.WalletSuccPageAwardLuckyMoneyDialog", "WalletSuccPageAwardLuckyMoneyDialog onCreate error! cannot get layerInfoBytes!");
            finish();
        }
        this.InV = new f();
        try {
            this.InV.parseFrom(byteArrayExtra);
        } catch (IOException e2) {
            Log.printErrStackTrace("MicroMsg.WalletSuccPageAwardLuckyMoneyDialog", e2, "parse layer info byte error! %s", e2.getMessage());
            finish();
        }
        this.zhm = (ViewGroup) findViewById(R.id.bex);
        this.CPf = (ImageView) findViewById(R.id.b46);
        this.CPf.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.wallet_core.ui.view.WalletSuccPageAwardLuckyMoneyDialog.AnonymousClass1 */

            public final void onClick(View view) {
                AppMethodBeat.i(71549);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/ui/view/WalletSuccPageAwardLuckyMoneyDialog$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                WalletSuccPageAwardLuckyMoneyDialog.this.finish();
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/view/WalletSuccPageAwardLuckyMoneyDialog$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(71549);
            }
        });
        final ViewGroup viewGroup = this.zhm;
        AnonymousClass2 r11 = new Animation.AnimationListener() {
            /* class com.tencent.mm.plugin.wallet_core.ui.view.WalletSuccPageAwardLuckyMoneyDialog.AnonymousClass2 */

            public final void onAnimationStart(Animation animation) {
            }

            public final void onAnimationEnd(Animation animation) {
            }

            public final void onAnimationRepeat(Animation animation) {
            }
        };
        ScaleAnimation scaleAnimation = new ScaleAnimation(0.0f, 0.96f, 0.0f, 0.96f, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setDuration(300);
        scaleAnimation.setInterpolator(new OvershootInterpolator());
        scaleAnimation.setFillAfter(true);
        final ScaleAnimation scaleAnimation2 = new ScaleAnimation(0.96f, 1.0f, 0.96f, 1.0f, 1, 0.5f, 1, 0.5f);
        scaleAnimation2.setDuration(100);
        scaleAnimation2.setFillAfter(true);
        scaleAnimation.setAnimationListener(new Animation.AnimationListener() {
            /* class com.tencent.mm.plugin.wallet_core.ui.view.WalletSuccPageAwardLuckyMoneyDialog.AnonymousClass3 */

            public final void onAnimationStart(Animation animation) {
            }

            public final void onAnimationRepeat(Animation animation) {
            }

            public final void onAnimationEnd(Animation animation) {
                AppMethodBeat.i(71550);
                viewGroup.startAnimation(scaleAnimation2);
                AppMethodBeat.o(71550);
            }
        });
        scaleAnimation2.setAnimationListener(r11);
        if (viewGroup != null) {
            viewGroup.startAnimation(scaleAnimation);
        }
        AppMethodBeat.o(71551);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.ca4;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getForceOrientation() {
        return 1;
    }
}

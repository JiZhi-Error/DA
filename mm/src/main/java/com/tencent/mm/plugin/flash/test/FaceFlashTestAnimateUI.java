package com.tencent.mm.plugin.flash.test;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.imageview.WeImageView;

public class FaceFlashTestAnimateUI extends MMActivity {
    public static String TAG = "MicroMsg.FaceFlashTestAnimateUI";
    private TextView wHA;
    Animation wHB;
    Animation wHD;
    TextView wHw;
    WeImageView wHx;
    ImageView wHy;
    private Button wHz;
    Animation wIJ;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.a5z;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(186691);
        super.onCreate(bundle);
        this.wHw = (TextView) findViewById(R.id.c9n);
        this.wHx = (WeImageView) findViewById(R.id.c9m);
        this.wHz = (Button) findViewById(R.id.c9j);
        this.wHA = (TextView) findViewById(R.id.c9i);
        this.wHy = (ImageView) findViewById(R.id.c9l);
        this.wHB = AnimationUtils.loadAnimation(getContext(), R.anim.b_);
        this.wIJ = AnimationUtils.loadAnimation(getContext(), R.anim.bb);
        this.wHD = AnimationUtils.loadAnimation(getContext(), R.anim.ba);
        this.wHz.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.flash.test.FaceFlashTestAnimateUI.AnonymousClass1 */

            public final void onClick(View view) {
                AppMethodBeat.i(186689);
                b bVar = new b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/flash/test/FaceFlashTestAnimateUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                FaceFlashTestAnimateUI faceFlashTestAnimateUI = FaceFlashTestAnimateUI.this;
                faceFlashTestAnimateUI.wHw.setText(com.tencent.mm.cb.a.aI(faceFlashTestAnimateUI.getContext(), R.string.c70));
                faceFlashTestAnimateUI.wHy.setImageResource(R.drawable.uf);
                faceFlashTestAnimateUI.wHy.startAnimation(faceFlashTestAnimateUI.wHB);
                faceFlashTestAnimateUI.wHx.setImageDrawable(com.tencent.mm.cb.a.l(faceFlashTestAnimateUI.getContext(), R.raw.icons_filled_done3));
                faceFlashTestAnimateUI.wHx.startAnimation(faceFlashTestAnimateUI.wIJ);
                a.a(this, "com/tencent/mm/plugin/flash/test/FaceFlashTestAnimateUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(186689);
            }
        });
        findViewById(R.id.c9k).setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.flash.test.FaceFlashTestAnimateUI.AnonymousClass2 */

            public final void onClick(View view) {
                AppMethodBeat.i(186690);
                b bVar = new b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/flash/test/FaceFlashTestAnimateUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                FaceFlashTestAnimateUI faceFlashTestAnimateUI = FaceFlashTestAnimateUI.this;
                Log.i(FaceFlashTestAnimateUI.TAG, "showFailedAnimation");
                faceFlashTestAnimateUI.wHy.setImageResource(R.drawable.ue);
                faceFlashTestAnimateUI.wHy.startAnimation(faceFlashTestAnimateUI.wHB);
                faceFlashTestAnimateUI.wHx.setImageDrawable(com.tencent.mm.cb.a.l(faceFlashTestAnimateUI.getContext(), R.raw.icons_filled_error3));
                faceFlashTestAnimateUI.wHx.startAnimation(faceFlashTestAnimateUI.wHD);
                a.a(this, "com/tencent/mm/plugin/flash/test/FaceFlashTestAnimateUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(186690);
            }
        });
        AppMethodBeat.o(186691);
    }
}

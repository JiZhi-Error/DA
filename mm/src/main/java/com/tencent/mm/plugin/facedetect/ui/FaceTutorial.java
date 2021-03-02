package com.tencent.mm.plugin.facedetect.ui;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import java.lang.ref.WeakReference;

public final class FaceTutorial {
    View kHq = null;
    Animation sTt = null;

    public FaceTutorial() {
        AppMethodBeat.i(104045);
        Log.i("MicroMsg.FaceTutorial", "initFaceTutorial");
        this.sTt = AnimationUtils.loadAnimation(MMApplicationContext.getContext(), R.anim.o);
        this.sTt.setDuration(500);
        AppMethodBeat.o(104045);
    }

    public final void dismiss() {
        AppMethodBeat.i(104046);
        Log.i("MicroMsg.FaceTutorial", "dismiss()");
        if (this.kHq.getVisibility() == 0) {
            MMHandlerThread.postToMainThread(new Runnable() {
                /* class com.tencent.mm.plugin.facedetect.ui.FaceTutorial.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(104038);
                    FaceTutorial.this.sTt.setAnimationListener(new Animation.AnimationListener() {
                        /* class com.tencent.mm.plugin.facedetect.ui.FaceTutorial.AnonymousClass1.AnonymousClass1 */

                        public final void onAnimationStart(Animation animation) {
                        }

                        public final void onAnimationEnd(Animation animation) {
                            AppMethodBeat.i(104037);
                            FaceTutorial.this.kHq.setVisibility(8);
                            AppMethodBeat.o(104037);
                        }

                        public final void onAnimationRepeat(Animation animation) {
                        }
                    });
                    FaceTutorial.this.kHq.startAnimation(FaceTutorial.this.sTt);
                    AppMethodBeat.o(104038);
                }
            });
        }
        AppMethodBeat.o(104046);
    }

    @SuppressLint({"ValidFragment"})
    public static class TutorialOne extends Fragment {
        private View kHq;
        private Button sUj;
        private WeakReference<FaceTutorial> sUk;

        @Override // android.support.v4.app.Fragment
        public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
            AppMethodBeat.i(104042);
            Log.i("MicroMsg.FaceTutorialUI.TutorialTwo", "carson: onCreateView()");
            this.kHq = layoutInflater.inflate(R.layout.a6k, viewGroup, false);
            this.sUj = (Button) this.kHq.findViewById(R.id.c_v);
            this.sUj.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.plugin.facedetect.ui.FaceTutorial.TutorialOne.AnonymousClass1 */

                public final void onClick(View view) {
                    AppMethodBeat.i(104040);
                    b bVar = new b();
                    bVar.bm(view);
                    a.b("com/tencent/mm/plugin/facedetect/ui/FaceTutorial$TutorialOne$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    if (TutorialOne.this.sUk.get() != null) {
                        ((FaceTutorial) TutorialOne.this.sUk.get()).dismiss();
                    } else {
                        Log.e("MicroMsg.FaceTutorialUI.TutorialTwo", "hy: lost tutorial instance");
                    }
                    a.a(this, "com/tencent/mm/plugin/facedetect/ui/FaceTutorial$TutorialOne$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(104040);
                }
            });
            View view = this.kHq;
            AppMethodBeat.o(104042);
            return view;
        }

        @Override // android.support.v4.app.Fragment
        public void onCreate(Bundle bundle) {
            AppMethodBeat.i(104043);
            Log.i("MicroMsg.FaceTutorialUI.TutorialTwo", "carson: onCreate");
            super.onCreate(bundle);
            AppMethodBeat.o(104043);
        }

        @Override // android.support.v4.app.Fragment
        public void onDestroy() {
            AppMethodBeat.i(104044);
            super.onDestroy();
            Log.i("MicroMsg.FaceTutorialUI.TutorialTwo", "hy: TutorialTwo onDestroy");
            AppMethodBeat.o(104044);
        }
    }
}

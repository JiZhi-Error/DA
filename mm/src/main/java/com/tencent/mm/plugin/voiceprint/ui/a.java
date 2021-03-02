package com.tencent.mm.plugin.voiceprint.ui;

import android.content.Context;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.Log;

public final class a {

    /* renamed from: com.tencent.mm.plugin.voiceprint.ui.a$a  reason: collision with other inner class name */
    public interface AbstractC1886a {
        void fEL();

        void fEM();
    }

    public static void a(final View view, final AbstractC1886a aVar) {
        AppMethodBeat.i(29945);
        float width = (float) view.getWidth();
        Log.d("MicroMsg.VoiceViewAnimationHelper", "target ".concat(String.valueOf(width)));
        int[] iArr = new int[2];
        view.getLocationInWindow(iArr);
        final int i2 = (int) (width + ((float) iArr[0]));
        Log.d("MicroMsg.VoiceViewAnimationHelper", "location %d %d preX=%d", Integer.valueOf(iArr[0]), Integer.valueOf(iArr[1]), Integer.valueOf(i2));
        view.getParent();
        TranslateAnimation translateAnimation = new TranslateAnimation(0, 0.0f, 0, (float) (-i2), 1, 0.0f, 1, 0.0f);
        translateAnimation.setDuration(200);
        translateAnimation.setStartOffset(0);
        translateAnimation.setRepeatMode(-1);
        translateAnimation.setRepeatCount(0);
        translateAnimation.setFillAfter(true);
        translateAnimation.setAnimationListener(new Animation.AnimationListener() {
            /* class com.tencent.mm.plugin.voiceprint.ui.a.AnonymousClass2 */

            public final void onAnimationStart(Animation animation) {
            }

            public final void onAnimationRepeat(Animation animation) {
            }

            public final void onAnimationEnd(Animation animation) {
                AppMethodBeat.i(29936);
                if (aVar != null) {
                    aVar.fEL();
                }
                Log.d("MicroMsg.VoiceViewAnimationHelper", "onAnimationEnd ");
                TranslateAnimation translateAnimation = new TranslateAnimation(0, (float) i2, 0, 0.0f, 1, 0.0f, 1, 0.0f);
                translateAnimation.setDuration(200);
                translateAnimation.setStartOffset(0);
                translateAnimation.setRepeatMode(-1);
                translateAnimation.setRepeatCount(0);
                translateAnimation.setFillAfter(true);
                translateAnimation.setAnimationListener(new Animation.AnimationListener() {
                    /* class com.tencent.mm.plugin.voiceprint.ui.a.AnonymousClass2.AnonymousClass1 */

                    public final void onAnimationStart(Animation animation) {
                    }

                    public final void onAnimationRepeat(Animation animation) {
                    }

                    public final void onAnimationEnd(Animation animation) {
                        AppMethodBeat.i(29935);
                        Log.i("MicroMsg.VoiceViewAnimationHelper", "next end");
                        if (aVar != null) {
                            aVar.fEM();
                        }
                        AppMethodBeat.o(29935);
                    }
                });
                view.startAnimation(translateAnimation);
                AppMethodBeat.o(29936);
            }
        });
        view.startAnimation(translateAnimation);
        AppMethodBeat.o(29945);
    }

    public static void a(View view, Context context, final AbstractC1886a aVar) {
        AppMethodBeat.i(29946);
        Animation loadAnimation = AnimationUtils.loadAnimation(context, R.anim.bi);
        loadAnimation.setDuration(300);
        loadAnimation.setFillAfter(true);
        loadAnimation.setRepeatCount(0);
        loadAnimation.setAnimationListener(new Animation.AnimationListener() {
            /* class com.tencent.mm.plugin.voiceprint.ui.a.AnonymousClass3 */

            public final void onAnimationStart(Animation animation) {
            }

            public final void onAnimationEnd(Animation animation) {
                AppMethodBeat.i(29937);
                if (aVar != null) {
                    aVar.fEM();
                }
                AppMethodBeat.o(29937);
            }

            public final void onAnimationRepeat(Animation animation) {
            }
        });
        view.startAnimation(loadAnimation);
        AppMethodBeat.o(29946);
    }

    public static void b(View view, Context context, final AbstractC1886a aVar) {
        AppMethodBeat.i(29947);
        Animation loadAnimation = AnimationUtils.loadAnimation(context, R.anim.br);
        loadAnimation.setDuration(300);
        loadAnimation.setFillAfter(true);
        loadAnimation.setRepeatCount(0);
        loadAnimation.setAnimationListener(new Animation.AnimationListener() {
            /* class com.tencent.mm.plugin.voiceprint.ui.a.AnonymousClass4 */

            public final void onAnimationStart(Animation animation) {
            }

            public final void onAnimationEnd(Animation animation) {
                AppMethodBeat.i(29938);
                if (aVar != null) {
                    aVar.fEM();
                }
                AppMethodBeat.o(29938);
            }

            public final void onAnimationRepeat(Animation animation) {
            }
        });
        view.startAnimation(loadAnimation);
        AppMethodBeat.o(29947);
    }

    public static void b(View view, final AbstractC1886a aVar) {
        AppMethodBeat.i(29948);
        TranslateAnimation translateAnimation = new TranslateAnimation(1, -1.0f, 1, 0.0f, 1, 0.0f, 1, 0.0f);
        translateAnimation.setDuration(200);
        translateAnimation.setFillAfter(true);
        translateAnimation.setRepeatCount(0);
        translateAnimation.setAnimationListener(new Animation.AnimationListener() {
            /* class com.tencent.mm.plugin.voiceprint.ui.a.AnonymousClass5 */

            public final void onAnimationStart(Animation animation) {
                AppMethodBeat.i(29939);
                if (aVar != null) {
                    aVar.fEL();
                }
                AppMethodBeat.o(29939);
            }

            public final void onAnimationEnd(Animation animation) {
                AppMethodBeat.i(29940);
                if (aVar != null) {
                    aVar.fEM();
                }
                AppMethodBeat.o(29940);
            }

            public final void onAnimationRepeat(Animation animation) {
            }
        });
        view.startAnimation(translateAnimation);
        AppMethodBeat.o(29948);
    }
}

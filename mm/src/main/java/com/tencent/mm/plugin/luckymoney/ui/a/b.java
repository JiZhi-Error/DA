package com.tencent.mm.plugin.luckymoney.ui.a;

import android.content.Context;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.api.ac;
import com.tencent.mm.api.ad;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;

public final class b {
    public static boolean a(Context context, final ChatFooterPanel chatFooterPanel) {
        AppMethodBeat.i(65984);
        if (chatFooterPanel == null) {
            AppMethodBeat.o(65984);
            return false;
        }
        chatFooterPanel.onPause();
        if (chatFooterPanel.getVisibility() == 0) {
            chatFooterPanel.setVisibility(8);
            Animation loadAnimation = AnimationUtils.loadAnimation(context, R.anim.f6do);
            loadAnimation.setAnimationListener(new Animation.AnimationListener() {
                /* class com.tencent.mm.plugin.luckymoney.ui.a.b.AnonymousClass1 */

                public final void onAnimationStart(Animation animation) {
                    AppMethodBeat.i(65982);
                    if (chatFooterPanel != null) {
                        chatFooterPanel.setVisibility(0);
                    }
                    AppMethodBeat.o(65982);
                }

                public final void onAnimationEnd(Animation animation) {
                    AppMethodBeat.i(65983);
                    if (chatFooterPanel != null) {
                        chatFooterPanel.onPause();
                        chatFooterPanel.setVisibility(8);
                    }
                    AppMethodBeat.o(65983);
                }

                public final void onAnimationRepeat(Animation animation) {
                }
            });
            chatFooterPanel.startAnimation(loadAnimation);
            AppMethodBeat.o(65984);
            return true;
        }
        AppMethodBeat.o(65984);
        return false;
    }

    public static void a(ViewGroup viewGroup, ChatFooterPanel chatFooterPanel, int i2, ac.a aVar) {
        AppMethodBeat.i(65985);
        chatFooterPanel.setEntranceScene(i2);
        chatFooterPanel.setVisibility(0);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, ad.bD(viewGroup.getContext()));
        layoutParams.gravity = 80;
        viewGroup.removeAllViews();
        viewGroup.addView(chatFooterPanel, layoutParams);
        ac VK = ad.VK();
        VK.djc = aVar;
        chatFooterPanel.setCallback(VK);
        AppMethodBeat.o(65985);
    }
}

package com.tencent.mm.plugin.location.ui.impl;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.ui.a;
import com.tencent.mm.sdk.platformtools.Util;

public class TrackPointAnimAvatar extends RelativeLayout {
    private ImageView keC;
    private Context mContext;
    private String username;
    private LinearLayout yOg;
    private Animation yOh;
    private Animation yOi;

    public TrackPointAnimAvatar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(56194);
        this.mContext = context;
        init();
        AppMethodBeat.o(56194);
    }

    public TrackPointAnimAvatar(Context context) {
        super(context);
        AppMethodBeat.i(56195);
        this.mContext = context;
        init();
        AppMethodBeat.o(56195);
    }

    private void init() {
        AppMethodBeat.i(56196);
        View inflate = View.inflate(this.mContext, R.layout.c4i, this);
        this.yOg = (LinearLayout) inflate.findViewById(R.id.mu);
        this.keC = (ImageView) inflate.findViewById(R.id.mt);
        eeg();
        AppMethodBeat.o(56196);
    }

    public void setUser(String str) {
        AppMethodBeat.i(56197);
        if (!Util.isNullOrNil(str)) {
            this.username = str;
            if (this.keC != null) {
                a.b.d(this.keC, this.username);
            }
        }
        AppMethodBeat.o(56197);
    }

    private void eeg() {
        AppMethodBeat.i(56198);
        this.yOh = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 0.0f, 1, -0.5f);
        this.yOh.setDuration(500);
        this.yOh.setFillAfter(true);
        this.yOi = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, -0.5f, 1, 0.0f);
        this.yOi.setDuration(500);
        this.yOi.setFillAfter(true);
        this.yOh.setAnimationListener(new Animation.AnimationListener() {
            /* class com.tencent.mm.plugin.location.ui.impl.TrackPointAnimAvatar.AnonymousClass1 */

            public final void onAnimationStart(Animation animation) {
            }

            public final void onAnimationRepeat(Animation animation) {
            }

            public final void onAnimationEnd(Animation animation) {
                AppMethodBeat.i(56192);
                TrackPointAnimAvatar.this.bringToFront();
                TrackPointAnimAvatar.this.yOg.startAnimation(TrackPointAnimAvatar.this.yOi);
                AppMethodBeat.o(56192);
            }
        });
        this.yOi.setAnimationListener(new Animation.AnimationListener() {
            /* class com.tencent.mm.plugin.location.ui.impl.TrackPointAnimAvatar.AnonymousClass2 */

            public final void onAnimationStart(Animation animation) {
            }

            public final void onAnimationRepeat(Animation animation) {
            }

            public final void onAnimationEnd(Animation animation) {
                AppMethodBeat.i(56193);
                TrackPointAnimAvatar.this.bringToFront();
                TrackPointAnimAvatar.this.yOg.startAnimation(TrackPointAnimAvatar.this.yOh);
                AppMethodBeat.o(56193);
            }
        });
        AppMethodBeat.o(56198);
    }
}

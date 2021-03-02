package com.tencent.mm.plugin.emoji.ui.v2;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.av.q;
import com.tencent.mm.cb.a;
import com.tencent.mm.plugin.emoji.e.e;
import com.tencent.mm.protocal.protobuf.EmotionDonor;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.io.IOException;
import java.util.LinkedList;

public class DonorsAvatarView extends LinearLayout {
    private int mMaxCount;
    private int rjG;
    private int rjH;
    private int rjI;
    private int rjJ;
    private LinearLayout.LayoutParams rjK;

    public DonorsAvatarView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(109130);
        init();
        AppMethodBeat.o(109130);
    }

    public DonorsAvatarView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(109131);
        init();
        AppMethodBeat.o(109131);
    }

    private void init() {
        AppMethodBeat.i(109132);
        setOrientation(0);
        this.rjG = a.jn(getContext());
        this.rjH = a.aG(getContext(), R.dimen.a25);
        this.rjI = a.aG(getContext(), R.dimen.f3062g);
        this.rjJ = a.aG(getContext(), R.dimen.ir);
        this.rjK = new LinearLayout.LayoutParams(this.rjH, this.rjH);
        this.rjK.leftMargin = this.rjI;
        this.rjK.rightMargin = this.rjI;
        this.mMaxCount = (this.rjG - (this.rjJ * 2)) / (this.rjH + (this.rjI * 2));
        Log.i("MicroMsg.emoji.DonorsAvatarView", "max count:%d", Integer.valueOf(this.mMaxCount));
        AppMethodBeat.o(109132);
    }

    public final void d(String str, LinkedList<EmotionDonor> linkedList) {
        AppMethodBeat.i(109133);
        removeAllViews();
        if (linkedList != null && linkedList.size() > 0) {
            int size = linkedList.size() > this.mMaxCount ? this.mMaxCount : linkedList.size();
            for (int i2 = 0; i2 < size; i2++) {
                EmotionDonor emotionDonor = linkedList.get(i2);
                if (emotionDonor != null) {
                    ImageView imageView = new ImageView(getContext());
                    imageView.setLayoutParams(this.rjK);
                    if (!Util.isNullOrNil(emotionDonor.HeadUrl)) {
                        q.bcV().a(emotionDonor.HeadUrl, imageView, e.l(str, emotionDonor.HeadUrl, new Object[0]));
                    } else {
                        try {
                            imageView.setImageBitmap(BackwardSupportUtil.BitmapFactory.decodeStream(MMApplicationContext.getContext().getAssets().open("avatar/default_nor_avatar.png"), a.getDensity(null)));
                        } catch (IOException e2) {
                            Log.printErrStackTrace("MicroMsg.emoji.DonorsAvatarView", e2, "", new Object[0]);
                        }
                    }
                    addView(imageView);
                }
            }
        }
        AppMethodBeat.o(109133);
    }
}

package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.AbsoluteLayout;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.modelsns.k;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.an;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.storage.y;
import com.tencent.mm.plugin.sns.ui.item.BaseTimeLineItem;
import com.tencent.mm.pluginsdk.h;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.ForceGpuUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.ui.aa;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.au;

public final class bs {
    private int CHZ = -1;
    private bk DQX;
    private FrameLayout DQt;
    LinearLayout EAZ;
    LinearLayout EBa;
    SnsCommentShowAbLayout ERD = null;
    private Context mContext;

    public bs(Context context, bk bkVar, FrameLayout frameLayout) {
        this.mContext = context;
        this.DQX = bkVar;
        this.DQt = frameLayout;
    }

    /* access modifiers changed from: package-private */
    public class a {
        View Atk = null;
        String DQN;

        public a(String str, View view) {
            this.DQN = str;
            this.Atk = view;
        }
    }

    public final boolean d(final View view, boolean z, boolean z2) {
        int i2;
        AppMethodBeat.i(203845);
        if (!(view.getTag() instanceof BaseTimeLineItem.BaseViewHolder)) {
            Log.e("MicroMsg.TimeLineCommentHelper", "showCommentBtn err2");
            AppMethodBeat.o(203845);
            return false;
        }
        BaseTimeLineItem.BaseViewHolder baseViewHolder = (BaseTimeLineItem.BaseViewHolder) view.getTag();
        String str = baseViewHolder.dHp;
        if (this.ERD != null) {
            if (this.ERD.getTag() instanceof a) {
                a aVar = (a) this.ERD.getTag();
                if (aVar.DQN.equals(str)) {
                    fB(aVar.Atk);
                    AppMethodBeat.o(203845);
                    return true;
                }
                ffL();
            }
            this.ERD = null;
        }
        this.ERD = new SnsCommentShowAbLayout(this.mContext);
        ForceGpuUtil.setLayerType(this.ERD);
        this.ERD.setId(R.id.h2);
        new FrameLayout.LayoutParams(-1, -1);
        this.DQt.addView(this.ERD);
        int fromDPToPix = BackwardSupportUtil.BitmapFactory.fromDPToPix(this.mContext, 192.0f);
        int fromDPToPix2 = BackwardSupportUtil.BitmapFactory.fromDPToPix(this.mContext, 76.0f);
        int fromDPToPix3 = BackwardSupportUtil.BitmapFactory.fromDPToPix(this.mContext, 8.0f);
        BackwardSupportUtil.BitmapFactory.fromDPToPix(this.mContext, 16.0f);
        int fromDPToPix4 = BackwardSupportUtil.BitmapFactory.fromDPToPix(this.mContext, 40.0f);
        final View inflate = aa.jQ(this.mContext).inflate(R.layout.bvg, (ViewGroup) null);
        new Rect();
        int[] iArr = new int[2];
        h.im(this.mContext);
        int fromDPToPix5 = com.tencent.mm.cb.a.fromDPToPix(this.mContext, 1);
        view.getLocationInWindow(iArr);
        this.CHZ = ao.jJ(this.mContext);
        Log.d("MicroMsg.TimeLineCommentHelper", "addCommentView getLocationInWindow " + iArr[0] + "  " + iArr[1] + " height: " + fromDPToPix5 + " height_hardcode:" + fromDPToPix2 + " statusBarHeight: " + this.CHZ);
        if (z) {
            i2 = au.eu(this.mContext);
        } else {
            i2 = 0;
        }
        int i3 = 0;
        if (z2) {
            i3 = au.getStatusBarHeight(this.mContext);
        }
        AbsoluteLayout.LayoutParams layoutParams = new AbsoluteLayout.LayoutParams(-2, -2, (iArr[0] - fromDPToPix) - fromDPToPix3, (((iArr[1] - fromDPToPix5) - ((fromDPToPix4 / 2) - (view.getMeasuredHeight() / 2))) - i2) - i3);
        this.ERD.setTag(new a(str, inflate));
        this.ERD.addView(inflate, layoutParams);
        if (baseViewHolder.qcr == 10) {
            inflate.findViewById(R.id.j_).setBackgroundResource(R.drawable.csw);
        }
        inflate.setVisibility(8);
        new MMHandler().post(new Runnable() {
            /* class com.tencent.mm.plugin.sns.ui.bs.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(99746);
                bs.a(bs.this, view, inflate);
                AppMethodBeat.o(99746);
            }
        });
        AppMethodBeat.o(203845);
        return true;
    }

    private void fB(final View view) {
        AppMethodBeat.i(99748);
        view.clearAnimation();
        view.startAnimation(this.DQX.EAY);
        this.DQX.EAY.setAnimationListener(new Animation.AnimationListener() {
            /* class com.tencent.mm.plugin.sns.ui.bs.AnonymousClass2 */

            public final void onAnimationStart(Animation animation) {
            }

            public final void onAnimationRepeat(Animation animation) {
            }

            public final void onAnimationEnd(Animation animation) {
                AppMethodBeat.i(99747);
                if (view != null) {
                    view.setVisibility(8);
                    bs.this.ffL();
                }
                AppMethodBeat.o(99747);
            }
        });
        AppMethodBeat.o(99748);
    }

    public final boolean ffL() {
        AppMethodBeat.i(99749);
        if (this.ERD != null) {
            this.DQt.removeView(this.ERD);
            this.ERD = null;
            AppMethodBeat.o(99749);
            return true;
        }
        AppMethodBeat.o(99749);
        return false;
    }

    static /* synthetic */ void a(bs bsVar, View view, View view2) {
        AppMethodBeat.i(99750);
        BaseTimeLineItem.BaseViewHolder baseViewHolder = (BaseTimeLineItem.BaseViewHolder) view.getTag();
        SnsInfo aQm = aj.faO().aQm(baseViewHolder.dHp);
        if (aQm != null) {
            k tO = k.tO(740);
            SnsObject C = an.C(aQm);
            tO.PH(r.v(aQm)).tR(aQm.field_type).fL(aQm.isAd()).PH(aQm.getUxinfo()).PH(aQm.getUserName()).tR(C == null ? 0 : C.LikeCount).tR(C == null ? 0 : C.CommentCount);
            tO.bfK();
        }
        view2.setVisibility(0);
        view2.startAnimation(bsVar.DQX.EAX);
        bsVar.EAZ = (LinearLayout) view2.findViewById(R.id.jo);
        bsVar.EAZ.setOnClickListener(bsVar.DQX.DQs.Fay);
        bsVar.EAZ.setOnTouchListener(bsVar.DQX.EqE);
        bsVar.EBa = (LinearLayout) view2.findViewById(R.id.ka);
        bsVar.EBa.setOnClickListener(bsVar.DQX.DQs.Faz);
        bsVar.EBa.setOnTouchListener(bsVar.DQX.EqE);
        bsVar.EBa.setTag(baseViewHolder);
        bsVar.EAZ.setTag(baseViewHolder);
        ImageView imageView = (ImageView) bsVar.EBa.findViewById(R.id.k_);
        ImageView imageView2 = (ImageView) bsVar.EAZ.findViewById(R.id.jf);
        TextView textView = (TextView) bsVar.EBa.findViewById(R.id.kb);
        TextView textView2 = (TextView) bsVar.EAZ.findViewById(R.id.jp);
        if (y.aQK(baseViewHolder.dRS)) {
            bsVar.EAZ.setEnabled(false);
            bsVar.EBa.setEnabled(false);
            textView2.setTextColor(bsVar.mContext.getResources().getColor(R.color.a8z));
            if (baseViewHolder.qcr == 10) {
                imageView.setImageResource(R.raw.friendactivity_comment_likeicon_golden_normal);
                imageView2.setImageResource(R.raw.friendactivity_comment_writeicon_golden_normal);
            } else {
                imageView.setImageResource(R.raw.friendactivity_comment_likeicon_normal);
                imageView2.setImageResource(R.raw.friendactivity_comment_writeicon_normal);
            }
            textView.setText(bsVar.mContext.getString(R.string.h7y));
            textView.setTextColor(bsVar.mContext.getResources().getColor(R.color.a8z));
        } else {
            bsVar.EAZ.setEnabled(true);
            if (baseViewHolder.qcr == 10) {
                imageView.setImageResource(R.drawable.aej);
                imageView2.setImageResource(R.drawable.aek);
                textView.setTextColor(bsVar.mContext.getResources().getColor(R.color.a98));
                textView2.setTextColor(bsVar.mContext.getResources().getColor(R.color.a98));
            } else {
                imageView.setImageResource(R.drawable.a53);
                textView.setTextColor(bsVar.mContext.getResources().getColor(R.color.ag2));
                textView2.setTextColor(bsVar.mContext.getResources().getColor(R.color.ag2));
            }
            bsVar.EBa.setEnabled(true);
            if (baseViewHolder.EWv == 0) {
                textView.setText(bsVar.mContext.getString(R.string.h7y));
            } else {
                textView.setText(bsVar.mContext.getString(R.string.h6r));
            }
        }
        if (baseViewHolder.qcr == 10) {
            bsVar.EBa.setBackgroundResource(R.drawable.ag8);
            bsVar.EAZ.setBackgroundResource(R.drawable.ag9);
        }
        AppMethodBeat.o(99750);
    }
}

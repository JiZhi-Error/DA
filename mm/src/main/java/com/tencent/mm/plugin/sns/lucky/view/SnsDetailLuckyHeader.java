package com.tencent.mm.plugin.sns.lucky.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.WindowManager;
import android.widget.AbsListView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.cb.a;
import com.tencent.mm.plugin.sns.lucky.a.m;
import com.tencent.mm.plugin.sns.model.an;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.ui.SnsCommentDetailUI;
import com.tencent.mm.plugin.sns.ui.TouchImageView;
import com.tencent.mm.plugin.sns.ui.d.c;
import com.tencent.mm.plugin.sns.ui.h;
import com.tencent.mm.pluginsdk.ui.a;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.dzx;
import com.tencent.mm.protocal.protobuf.ear;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.LinkedList;

public class SnsDetailLuckyHeader extends LinearLayout {
    private TextView DGi;
    private LinearLayout DGj;
    private LinearLayout DGk;
    private View lJI = null;

    public SnsDetailLuckyHeader(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(95201);
        init();
        AppMethodBeat.o(95201);
    }

    public SnsDetailLuckyHeader(Context context) {
        super(context);
        AppMethodBeat.i(95202);
        init();
        AppMethodBeat.o(95202);
    }

    public SnsDetailLuckyHeader(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(95203);
        init();
        AppMethodBeat.o(95203);
    }

    private void init() {
        AppMethodBeat.i(95204);
        View inflate = View.inflate(getContext(), R.layout.b4m, this);
        this.lJI = inflate.findViewById(R.id.kf);
        this.DGi = (TextView) inflate.findViewById(R.id.jy);
        this.DGj = (LinearLayout) inflate.findViewById(R.id.jz);
        this.DGk = getLinearSeparator();
        AppMethodBeat.o(95204);
    }

    public LinearLayout getLinearSeparator() {
        AppMethodBeat.i(95205);
        BackwardSupportUtil.BitmapFactory.fromDPToPix(getContext(), 2.0f);
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, 1);
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setBackgroundResource(R.drawable.av_);
        linearLayout.setLayoutParams(layoutParams);
        AppMethodBeat.o(95205);
        return linearLayout;
    }

    public void setVisibility(int i2) {
        AppMethodBeat.i(95206);
        super.setVisibility(i2);
        if (this.lJI != null) {
            this.lJI.setVisibility(i2);
        }
        AppMethodBeat.o(95206);
    }

    public final void a(SnsInfo snsInfo, c cVar) {
        LinearLayout linearLayout;
        int i2;
        AppMethodBeat.i(95207);
        SnsObject C = an.C(snsInfo);
        ear ear = C.SnsRedEnvelops;
        if (ear == null || ear.Naf.size() == 0) {
            setVisibility(8);
            AppMethodBeat.o(95207);
            return;
        }
        setVisibility(0);
        this.DGi.setText(getContext().getString(R.string.h8i, Integer.valueOf(C.SnsRedEnvelops.Nae), Util.formatMoney2f((((double) m.b(snsInfo, C)) * 1.0d) / 100.0d)));
        this.lJI.setTag(snsInfo);
        this.lJI.setOnClickListener(cVar.FaD);
        LinkedList<dzx> linkedList = ear.Naf;
        boolean isEmpty = ear.Naf.isEmpty();
        int fromDPToPix = BackwardSupportUtil.BitmapFactory.fromDPToPix(getContext(), 32.0f);
        int fromDPToPix2 = BackwardSupportUtil.BitmapFactory.fromDPToPix(getContext(), 6.0f);
        int fromDPToPix3 = BackwardSupportUtil.BitmapFactory.fromDPToPix(getContext(), 10.0f);
        int fromDPToPix4 = BackwardSupportUtil.BitmapFactory.fromDPToPix(getContext(), 17.0f);
        if (this.DGj != null) {
            int width = ((WindowManager) getContext().getSystemService("window")).getDefaultDisplay().getWidth();
            float dimension = getResources().getDimension(R.dimen.ir);
            Log.d("MicroMsg.SnsDetailLuckyHeader", "guess size %d %f", Integer.valueOf(width), Float.valueOf(dimension));
            float f2 = ((float) width) - (dimension * 2.0f);
            if (linkedList.size() <= 0) {
                if (this.DGj.getParent() != null) {
                    this.DGj.setVisibility(8);
                }
                this.DGj.removeAllViews();
                this.DGj.setVisibility(8);
                linearLayout = this.DGj;
                i2 = 8;
            } else {
                this.DGj.getParent();
                this.DGj.removeAllViews();
                this.DGj.setVisibility(0);
                this.DGj.setPadding(0, fromDPToPix2, 0, fromDPToPix2);
                ImageView imageView = new ImageView(getContext());
                imageView.setImageResource(R.raw.friendactivity_luckymoney_icon);
                imageView.setPadding(fromDPToPix3, fromDPToPix4, fromDPToPix3, 0);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                layoutParams.gravity = 49;
                imageView.setLayoutParams(layoutParams);
                imageView.setClickable(false);
                imageView.setFocusable(false);
                this.DGj.addView(imageView);
                int fromDPToPix5 = a.fromDPToPix(getContext(), SnsCommentDetailUI.EBs);
                int i3 = ((int) (f2 - ((float) fromDPToPix5))) / (fromDPToPix2 + fromDPToPix);
                if (((int) (f2 - ((float) fromDPToPix5))) % (fromDPToPix2 + fromDPToPix) > fromDPToPix) {
                    i3++;
                }
                Log.d("MicroMsg.SnsDetailLuckyHeader", "guess size %d", Integer.valueOf(i3));
                h hVar = new h(getContext());
                hVar.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
                hVar.setLineMaxCounte(i3);
                for (int i4 = 0; i4 < linkedList.size(); i4++) {
                    dzx dzx = linkedList.get(i4);
                    TouchImageView touchImageView = new TouchImageView(getContext());
                    touchImageView.setScaleType(ImageView.ScaleType.FIT_XY);
                    touchImageView.setImageResource(R.drawable.a56);
                    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(fromDPToPix, fromDPToPix);
                    layoutParams2.setMargins(0, fromDPToPix2, fromDPToPix2, 0);
                    touchImageView.setLayoutParams(layoutParams2);
                    touchImageView.setTag(dzx.Username);
                    a.b.A(touchImageView, dzx.Username);
                    touchImageView.setOnClickListener(cVar.Fas);
                    hVar.addView(touchImageView);
                }
                this.DGj.addView(hVar);
                linearLayout = this.DGk;
                i2 = isEmpty ? 8 : 0;
            }
            linearLayout.setVisibility(i2);
        }
        AppMethodBeat.o(95207);
    }
}

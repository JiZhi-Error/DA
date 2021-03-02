package com.tencent.mm.plugin.card.ui.view;

import android.content.res.ColorStateList;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.StateListDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewStub;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.plugin.card.b.f;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.plugin.card.ui.a.g;
import com.tencent.mm.protocal.protobuf.bet;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.smtt.sdk.TbsListener;

public final class b extends i {
    private com.tencent.mm.plugin.card.base.b pQV;
    private MMActivity pQZ;
    private View qjF;
    private TextView qjG;
    private g qjH;

    @Override // com.tencent.mm.plugin.card.ui.view.i
    public final void initView() {
        AppMethodBeat.i(113659);
        this.pQZ = this.qjX.cvt();
        this.qjH = this.qjX.cvv();
        AppMethodBeat.o(113659);
    }

    @Override // com.tencent.mm.plugin.card.ui.view.i
    public final void destroy() {
        AppMethodBeat.i(113660);
        super.destroy();
        this.pQZ = null;
        this.qjH = null;
        AppMethodBeat.o(113660);
    }

    @Override // com.tencent.mm.plugin.card.ui.view.i
    public final void update() {
        String cwp;
        AppMethodBeat.i(113661);
        if (this.qjF == null) {
            this.qjF = ((ViewStub) findViewById(R.id.ajz)).inflate();
            this.qjF.findViewById(R.id.ajp).setOnClickListener(this.qjX.cvu());
        }
        this.pQV = this.qjX.cvq();
        this.qjH = this.qjX.cvv();
        boolean cww = this.qjH.cww();
        boolean cwx = this.qjH.cwx();
        if (cww) {
            this.qjF.setVisibility(0);
            Log.i("MicroMsg.CardAcceptView", "updateAcceptView() acceptViewVisible:" + cww + " acceptViewEnabled:" + cwx);
            Button button = (Button) this.qjF.findViewById(R.id.ajp);
            View findViewById = this.qjF.findViewById(R.id.ajy);
            findViewById.setBackgroundDrawable(null);
            findViewById.setOnClickListener(null);
            int dimensionPixelSize = this.pQZ.getResources().getDimensionPixelSize(R.dimen.vn);
            if (cwx) {
                if (!TextUtils.isEmpty(this.pQV.csQ().LeJ)) {
                    button.setText(this.pQV.csQ().LeJ);
                }
                if (this.pQV.csx()) {
                    button.setTextColor(l.ake(this.pQV.csQ().ixw));
                    ShapeDrawable e2 = l.e(this.pQZ, l.ake(this.pQV.csQ().ixw), dimensionPixelSize);
                    ShapeDrawable fi = l.fi(l.ake(this.pQV.csQ().ixw), dimensionPixelSize);
                    StateListDrawable stateListDrawable = new StateListDrawable();
                    stateListDrawable.addState(new int[]{16842919}, fi);
                    stateListDrawable.addState(new int[0], e2);
                    int[] iArr = {this.pQZ.getResources().getColor(R.color.afz), l.ake(this.pQV.csQ().ixw)};
                    button.setBackgroundDrawable(stateListDrawable);
                    button.setTextColor(new ColorStateList(new int[][]{new int[]{16842919, 16842910}, new int[0]}, iArr));
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.qjF.getLayoutParams();
                    layoutParams.topMargin = this.pQZ.getResources().getDimensionPixelSize(R.dimen.ux);
                    this.qjF.setLayoutParams(layoutParams);
                    this.qjF.findViewById(R.id.bsi).setVisibility(8);
                    final f cvy = this.qjX.cvy();
                    this.qjF.setBackgroundColor(this.pQZ.getResources().getColor(R.color.afz));
                    CheckBox checkBox = (CheckBox) this.qjF.findViewById(R.id.ama);
                    if (cvy.ctu() == null || !cvy.ctu().pSk) {
                        Log.i("MicroMsg.CardAcceptView", "updateFollowBox() not show followbox");
                        checkBox.setVisibility(8);
                    } else {
                        Log.i("MicroMsg.CardAcceptView", "updateFollowBox() show followbox");
                        checkBox.setVisibility(0);
                        bet bet = this.pQV.csQ().LeU;
                        if (bet == null || TextUtils.isEmpty(bet.text)) {
                            checkBox.setText(cvy.ctu().title);
                        } else {
                            checkBox.setText(bet.text);
                        }
                        checkBox.setChecked(cvy.ctu().edw);
                        checkBox.setOnClickListener(new View.OnClickListener() {
                            /* class com.tencent.mm.plugin.card.ui.view.b.AnonymousClass1 */

                            public final void onClick(View view) {
                                AppMethodBeat.i(113658);
                                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                                bVar.bm(view);
                                a.b("com/tencent/mm/plugin/card/ui/view/CardAcceptView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                                if (((CheckBox) view).isChecked()) {
                                    cvy.ctu().edw = true;
                                } else {
                                    cvy.ctu().edw = false;
                                }
                                a.a(this, "com/tencent/mm/plugin/card/ui/view/CardAcceptView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                                AppMethodBeat.o(113658);
                            }
                        });
                    }
                } else if (this.pQV.csy() || this.pQV.csw() || this.pQV.csz()) {
                    ShapeDrawable fi2 = l.fi(l.ake(this.pQV.csQ().ixw), dimensionPixelSize);
                    ShapeDrawable fi3 = l.fi(l.convertStringToRGB(this.pQV.csQ().ixw, TbsListener.ErrorCode.NEEDDOWNLOAD_FALSE_5), dimensionPixelSize);
                    StateListDrawable stateListDrawable2 = new StateListDrawable();
                    stateListDrawable2.addState(new int[]{16842919}, fi3);
                    stateListDrawable2.addState(new int[0], fi2);
                    button.setBackgroundDrawable(stateListDrawable2);
                    button.setTextColor(this.pQZ.getResources().getColor(R.color.ag5));
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) button.getLayoutParams();
                    layoutParams2.width = -1;
                    button.setLayoutParams(layoutParams2);
                } else {
                    ShapeDrawable fi4 = l.fi(l.ake(this.pQV.csQ().ixw), dimensionPixelSize);
                    ShapeDrawable fi5 = l.fi(l.convertStringToRGB(this.pQV.csQ().ixw, TbsListener.ErrorCode.NEEDDOWNLOAD_FALSE_5), dimensionPixelSize);
                    StateListDrawable stateListDrawable3 = new StateListDrawable();
                    stateListDrawable3.addState(new int[]{16842919}, fi5);
                    stateListDrawable3.addState(new int[0], fi4);
                    button.setBackgroundDrawable(stateListDrawable3);
                    button.setTextColor(this.pQZ.getResources().getColor(R.color.ag5));
                }
            } else {
                this.qjF.setEnabled(false);
                findViewById.setEnabled(false);
                button.setEnabled(false);
                if (this.pQV.csx()) {
                    cwp = this.pQV.csQ().LeJ;
                } else {
                    cwp = this.qjH.cwp();
                }
                button.setText(cwp);
                if (this.pQV.csx()) {
                    button.setTextColor(l.convertStringToRGB(this.pQV.csQ().ixw, 125));
                    button.setBackgroundDrawable(l.e(this.pQZ, l.convertStringToRGB(this.pQV.csQ().ixw, 125), dimensionPixelSize));
                    LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.qjF.getLayoutParams();
                    layoutParams3.topMargin = this.pQZ.getResources().getDimensionPixelSize(R.dimen.uy);
                    this.qjF.setLayoutParams(layoutParams3);
                    this.qjF.findViewById(R.id.bsi).setVisibility(8);
                } else if (this.pQV.csy() || this.pQV.csw() || this.pQV.csz()) {
                    button.setTextColor(this.pQZ.getResources().getColor(R.color.tx));
                    button.setBackgroundDrawable(l.U(this.pQZ, this.pQZ.getResources().getColor(R.color.hi)));
                    LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) button.getLayoutParams();
                    layoutParams4.width = -1;
                    button.setLayoutParams(layoutParams4);
                } else {
                    button.setTextColor(this.pQZ.getResources().getColor(R.color.tx));
                    button.setBackgroundDrawable(l.U(this.pQZ, this.pQZ.getResources().getColor(R.color.hi)));
                }
            }
            if (!this.pQV.csy() && !this.pQV.csw()) {
                if (this.pQV.csQ().LeV != null && !Util.isNullOrNil(this.pQV.csQ().LeV.text)) {
                    if (this.qjG == null) {
                        this.qjG = (TextView) this.qjF.findViewById(R.id.ajw);
                    }
                    this.qjG.setText(this.pQV.csQ().LeV.text);
                    if (!Util.isNullOrNil(this.pQV.csQ().LeV.url)) {
                        this.qjG.setOnClickListener(this.qjX.cvu());
                        this.qjG.setTextColor(l.ake(this.pQV.csQ().ixw));
                    }
                    this.qjG.setVisibility(0);
                    AppMethodBeat.o(113661);
                    return;
                } else if (this.qjG != null) {
                    this.qjG.setVisibility(8);
                }
            }
            AppMethodBeat.o(113661);
            return;
        }
        Log.i("MicroMsg.CardAcceptView", "updateAcceptView(), mAcceptCardView is Gone");
        this.qjF.setVisibility(8);
        AppMethodBeat.o(113661);
    }

    @Override // com.tencent.mm.plugin.card.ui.view.i
    public final void cxw() {
        AppMethodBeat.i(113662);
        this.qjF.setVisibility(8);
        AppMethodBeat.o(113662);
    }
}

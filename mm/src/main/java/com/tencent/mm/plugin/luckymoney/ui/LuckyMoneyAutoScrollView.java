package com.tencent.mm.plugin.luckymoney.ui;

import android.content.Context;
import android.support.v4.view.u;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyAutoScrollItem;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;

public class LuckyMoneyAutoScrollView extends RelativeLayout implements LuckyMoneyAutoScrollItem.b {
    private View contentView;
    boolean hasCallBack;
    private Context mContext;
    private RelativeLayout zbG;
    private RelativeLayout zbH;
    private RelativeLayout zbI;
    LuckyMoneyAutoScrollItem zbJ;
    LuckyMoneyAutoScrollItem zbK;
    LuckyMoneyAutoScrollItem zbL;
    private RelativeLayout zbM;
    private RelativeLayout zbN;
    private RelativeLayout zbO;
    ImageView zbP;
    ImageView zbQ;
    ImageView zbR;
    private String zbS;
    private String zbT;
    private String zbU;
    private a zbV;

    public interface a {
        void efY();
    }

    public LuckyMoneyAutoScrollView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet);
        AppMethodBeat.i(65434);
        this.zbS = AppEventsConstants.EVENT_PARAM_VALUE_NO;
        this.zbT = AppEventsConstants.EVENT_PARAM_VALUE_NO;
        this.zbU = AppEventsConstants.EVENT_PARAM_VALUE_NO;
        this.hasCallBack = false;
        this.mContext = context;
        View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.b3f, this);
        this.contentView = inflate;
        this.zbJ = (LuckyMoneyAutoScrollItem) inflate.findViewById(R.id.m7);
        this.zbK = (LuckyMoneyAutoScrollItem) inflate.findViewById(R.id.m8);
        this.zbL = (LuckyMoneyAutoScrollItem) inflate.findViewById(R.id.m9);
        u.p(this.zbJ, 2);
        u.p(this.zbK, 2);
        u.p(this.zbL, 2);
        this.zbM = (RelativeLayout) inflate.findViewById(R.id.m_);
        this.zbN = (RelativeLayout) inflate.findViewById(R.id.ma);
        this.zbO = (RelativeLayout) inflate.findViewById(R.id.mb);
        this.zbP = (ImageView) inflate.findViewById(R.id.ikf);
        this.zbQ = (ImageView) inflate.findViewById(R.id.ikg);
        this.zbR = (ImageView) inflate.findViewById(R.id.ikh);
        this.zbG = (RelativeLayout) inflate.findViewById(R.id.e2n);
        this.zbH = (RelativeLayout) inflate.findViewById(R.id.e2o);
        this.zbI = (RelativeLayout) inflate.findViewById(R.id.e2p);
        AppMethodBeat.o(65434);
    }

    public LuckyMoneyAutoScrollView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public void setFinalText(String str) {
        AppMethodBeat.i(65435);
        Log.i("MicroMsg.LuckyMoneyAutoScrollView", "hy: setting text: %s", str);
        this.zbS = str.substring(0, 1);
        this.zbT = str.substring(2, 3);
        this.zbU = str.substring(3, 4);
        this.zbJ.setFinalNumber(Util.getInt(this.zbS, 0));
        this.zbK.setFinalNumber(Util.getInt(this.zbT, 0));
        this.zbL.setFinalNumber(Util.getInt(this.zbU, 0));
        this.zbP.setImageResource(LuckyMoneyAutoScrollItem.zbA.get(Util.getInt(this.zbS, 0)).intValue());
        this.zbQ.setImageResource(LuckyMoneyAutoScrollItem.zbA.get(Util.getInt(this.zbT, 0)).intValue());
        this.zbR.setImageResource(LuckyMoneyAutoScrollItem.zbA.get(Util.getInt(this.zbU, 0)).intValue());
        this.zbP.setVisibility(4);
        this.zbQ.setVisibility(4);
        this.zbR.setVisibility(4);
        this.zbJ.setOnScrollEndListener(this);
        this.zbK.setOnScrollEndListener(this);
        this.zbL.setOnScrollEndListener(this);
        Log.i("MicroMsg.LuckyMoneyAutoScrollView", "hy: first: %s, second :%s, third: %s", this.zbS, this.zbT, this.zbU);
        AppMethodBeat.o(65435);
    }

    public final void a(a aVar) {
        AppMethodBeat.i(65436);
        this.zbV = aVar;
        MMHandlerThread.postToMainThread(new Runnable() {
            /* class com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyAutoScrollView.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(65432);
                LuckyMoneyAutoScrollView.this.zbM.setVisibility(0);
                LuckyMoneyAutoScrollView.this.zbN.setVisibility(0);
                LuckyMoneyAutoScrollView.this.zbO.setVisibility(0);
                LuckyMoneyAutoScrollView.this.zbJ.efV();
                LuckyMoneyAutoScrollView.this.zbK.efV();
                LuckyMoneyAutoScrollView.this.zbL.efV();
                AppMethodBeat.o(65432);
            }
        });
        AppMethodBeat.o(65436);
    }

    public final void efX() {
        AppMethodBeat.i(65437);
        this.zbJ.setVisibility(8);
        this.zbK.setVisibility(8);
        this.zbL.setVisibility(8);
        this.zbP.setVisibility(0);
        this.zbQ.setVisibility(0);
        this.zbR.setVisibility(0);
        AppMethodBeat.o(65437);
    }

    @Override // com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyAutoScrollItem.b
    public final void efW() {
        AppMethodBeat.i(65438);
        if (!this.hasCallBack) {
            this.hasCallBack = true;
            MMHandlerThread.postToMainThread(new Runnable() {
                /* class com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyAutoScrollView.AnonymousClass2 */

                public final void run() {
                    AppMethodBeat.i(65433);
                    LuckyMoneyAutoScrollView.this.zbM.setVisibility(8);
                    LuckyMoneyAutoScrollView.this.zbN.setVisibility(8);
                    LuckyMoneyAutoScrollView.this.zbO.setVisibility(8);
                    LuckyMoneyAutoScrollView.this.zbJ.setVisibility(8);
                    LuckyMoneyAutoScrollView.this.zbK.setVisibility(8);
                    LuckyMoneyAutoScrollView.this.zbL.setVisibility(8);
                    LuckyMoneyAutoScrollView.this.zbP.setVisibility(0);
                    LuckyMoneyAutoScrollView.this.zbQ.setVisibility(0);
                    LuckyMoneyAutoScrollView.this.zbR.setVisibility(0);
                    if (LuckyMoneyAutoScrollView.this.zbV != null) {
                        LuckyMoneyAutoScrollView.this.zbV.efY();
                    }
                    AppMethodBeat.o(65433);
                }
            });
        }
        AppMethodBeat.o(65438);
    }

    public final void gV(int i2, int i3) {
        AppMethodBeat.i(65439);
        if (i2 > 0 && i3 > 0) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.contentView.getLayoutParams();
            layoutParams.height = i3;
            this.contentView.setLayoutParams(layoutParams);
            this.contentView.invalidate();
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.zbG.getLayoutParams();
            layoutParams2.height = i3;
            layoutParams2.width = i2;
            this.zbG.setLayoutParams(layoutParams2);
            this.zbG.invalidate();
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.zbH.getLayoutParams();
            layoutParams3.height = i3;
            layoutParams3.width = i2;
            this.zbH.setLayoutParams(layoutParams3);
            this.zbH.invalidate();
            LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) this.zbI.getLayoutParams();
            layoutParams4.height = i3;
            layoutParams4.width = i2;
            layoutParams4.leftMargin = 0;
            this.zbI.setLayoutParams(layoutParams4);
            this.zbI.invalidate();
        }
        AppMethodBeat.o(65439);
    }
}

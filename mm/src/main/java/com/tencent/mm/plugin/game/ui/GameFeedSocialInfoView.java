package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.game.protobuf.ah;
import com.tencent.mm.plugin.game.widget.GameSmallAvatarList;
import com.tencent.mm.sdk.platformtools.Util;

public class GameFeedSocialInfoView extends LinearLayout {
    private TextView jVn;
    private LinearLayout xSB;
    private GameSmallAvatarList xSC;
    private TextView xSD;
    private LinearLayout xSE;

    public GameFeedSocialInfoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        AppMethodBeat.i(42128);
        super.onFinishInflate();
        this.xSB = (LinearLayout) findViewById(R.id.x4);
        this.xSC = (GameSmallAvatarList) findViewById(R.id.x6);
        this.xSD = (TextView) findViewById(R.id.ww);
        this.xSE = (LinearLayout) findViewById(R.id.bmr);
        this.jVn = (TextView) findViewById(R.id.bn5);
        AppMethodBeat.o(42128);
    }

    public void setData(ah ahVar) {
        AppMethodBeat.i(42129);
        if (!Util.isNullOrNil(ahVar.xKe) || ahVar.xKf != null) {
            this.xSB.setVisibility(0);
            this.xSC.setData(ahVar.xKe);
            if (ahVar.xKf != null) {
                this.xSD.setText(ahVar.xKf);
                this.xSD.setVisibility(0);
            } else {
                this.xSD.setVisibility(8);
            }
        } else {
            this.xSB.setVisibility(8);
        }
        if (ahVar.Desc != null) {
            this.xSE.setVisibility(0);
            this.jVn.setText(ahVar.Desc);
            AppMethodBeat.o(42129);
            return;
        }
        this.xSE.setVisibility(8);
        AppMethodBeat.o(42129);
    }
}

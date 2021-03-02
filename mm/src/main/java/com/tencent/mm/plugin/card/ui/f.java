package com.tencent.mm.plugin.card.ui;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.card.d.n;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.sharecard.a.b;
import com.tencent.mm.plugin.card.sharecard.model.l;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.protocal.protobuf.up;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;

public final class f {
    private View gQj;
    private View jBN;
    private MMActivity pQZ;
    private b pXs;
    private int qbU;
    private TextView qbV;
    private TextView qbW;
    private CdnImageView qbX;
    private ImageView[] qbY;
    private ImageView qbZ;
    private up qca;

    public f(MMActivity mMActivity, View view, int i2, b bVar) {
        this(mMActivity, view, i2, bVar, null);
    }

    public f(MMActivity mMActivity, View view, int i2, b bVar, up upVar) {
        AppMethodBeat.i(113406);
        this.qbY = new ImageView[3];
        this.pQZ = mMActivity;
        this.jBN = view;
        this.qbU = i2;
        this.pXs = bVar;
        this.qca = upVar;
        this.gQj = this.jBN.findViewById(R.id.amy);
        this.qbV = (TextView) this.jBN.findViewById(R.id.an0);
        this.qbW = (TextView) this.jBN.findViewById(R.id.amz);
        this.qbX = (CdnImageView) this.jBN.findViewById(R.id.an1);
        this.qbY[0] = (ImageView) this.jBN.findViewById(R.id.amv);
        this.qbY[1] = (ImageView) this.jBN.findViewById(R.id.amw);
        this.qbY[2] = (ImageView) this.jBN.findViewById(R.id.amx);
        this.qbZ = (ImageView) this.jBN.findViewById(R.id.aos);
        if (this.qbU == 1) {
            this.qbV.setText(this.pQZ.getString(R.string.ar7, new Object[]{0}));
            this.qbX.setImageResource(R.raw.card_home_member_card_icon);
            AppMethodBeat.o(113406);
        } else if (this.qbU == 2) {
            this.qbV.setText(R.string.ast);
            this.qbX.setImageResource(R.raw.card_home_friend_ticket_icon);
            AppMethodBeat.o(113406);
        } else if (this.qbU == 3) {
            this.qbV.setText(R.string.atp);
            this.qbX.setImageResource(R.raw.card_home_my_ticket_icon);
            AppMethodBeat.o(113406);
        } else {
            if (this.qbU == 4) {
                if (this.qca == null) {
                    Log.w("MicroMsg.CardHomePageItemController", "cell element is null");
                    cvX();
                }
                this.jBN.findViewById(R.id.amu).setVisibility(8);
                this.qbV.setText(this.qca.LdW);
                this.qbX.setUseSdcardCache(true);
                this.qbX.setUrl(this.qca.LdX);
                if (!Util.isNullOrNil(this.qca.LdY)) {
                    this.qbW.setText(this.qca.LdY);
                    this.qbW.setVisibility(0);
                    AppMethodBeat.o(113406);
                    return;
                }
                this.qbW.setVisibility(8);
            }
            AppMethodBeat.o(113406);
        }
    }

    public final void setOnClickListener(View.OnClickListener onClickListener) {
        AppMethodBeat.i(113407);
        this.gQj.setOnClickListener(onClickListener);
        AppMethodBeat.o(113407);
    }

    public final void updateView() {
        AppMethodBeat.i(113408);
        if (this.qbU == 2) {
            l lVar = (l) am.ctV().getValue("key_share_card_layout_data");
            if (lVar == null) {
                Log.w("MicroMsg.CardHomePageItemController", "updateShareCardView data is null");
                AppMethodBeat.o(113408);
                return;
            }
            if (Util.isNullOrNil(lVar.pWf)) {
                this.qbW.setVisibility(8);
            } else {
                this.qbW.setVisibility(0);
                this.qbW.setText(lVar.pWf);
            }
            if (Util.isNullOrNil(lVar.pWe)) {
                for (int i2 = 0; i2 < 3; i2++) {
                    this.qbY[i2].setVisibility(8);
                }
            } else {
                for (int i3 = 0; i3 < 3; i3++) {
                    if (i3 < lVar.pWe.size()) {
                        this.qbY[i3].setVisibility(0);
                        n.a(this.qbY[i3], lVar.pWe.get(i3), this.pQZ.getResources().getDimensionPixelSize(R.dimen.hv), (int) R.drawable.ci4, false);
                    } else {
                        this.qbY[i3].setVisibility(8);
                    }
                }
            }
            if (Util.isNullOrNil(lVar.pWe) || lVar.pWe.size() != 1 || !lVar.eaY || lVar.eaZ) {
                this.qbZ.setVisibility(8);
                AppMethodBeat.o(113408);
                return;
            }
            this.qbZ.setVisibility(0);
            AppMethodBeat.o(113408);
            return;
        }
        if (this.qbU == 3) {
            this.qbV.setText(R.string.atp);
            this.jBN.findViewById(R.id.amu).setVisibility(8);
            String str = (String) am.ctV().getValue("key_card_entrance_tips");
            if (!Util.isNullOrNil(str)) {
                this.qbW.setText(str);
                this.qbW.setVisibility(0);
                AppMethodBeat.o(113408);
                return;
            }
            this.qbW.setVisibility(8);
        }
        AppMethodBeat.o(113408);
    }

    public final void cvX() {
        AppMethodBeat.i(113409);
        this.jBN.setVisibility(8);
        AppMethodBeat.o(113409);
    }
}

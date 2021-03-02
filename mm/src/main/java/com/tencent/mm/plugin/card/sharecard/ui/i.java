package com.tencent.mm.plugin.card.sharecard.ui;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.sharecard.a.b;
import com.tencent.mm.plugin.card.sharecard.model.ShareCardInfo;
import com.tencent.mm.ui.MMActivity;

public final class i {
    private View jBN;
    MMActivity pQZ;
    View pXU;
    TextView pXV;
    TextView pXW;
    private boolean pXX = false;

    public i(MMActivity mMActivity, View view) {
        this.pQZ = mMActivity;
        this.jBN = view;
    }

    public final void cuX() {
        AppMethodBeat.i(113139);
        this.pXU.setVisibility(8);
        AppMethodBeat.o(113139);
    }

    public final void updateView() {
        AppMethodBeat.i(113140);
        Integer num = (Integer) am.ctV().getValue("key_share_card_show_type");
        if (num == null) {
            num = 0;
        }
        if (num.intValue() == 0 || b.cuz()) {
            this.pXU.setVisibility(8);
            AppMethodBeat.o(113140);
            return;
        }
        this.pXU.setVisibility(0);
        this.pXV.setVisibility(0);
        ShareCardInfo shareCardInfo = new ShareCardInfo();
        if (!TextUtils.isEmpty(shareCardInfo.Ee(10))) {
            this.pXV.setVisibility(0);
            this.pXV.setText(shareCardInfo.Ee(10));
        } else {
            this.pXV.setVisibility(8);
        }
        if (!TextUtils.isEmpty("")) {
            this.pXW.setVisibility(0);
            this.pXW.setText("");
            AppMethodBeat.o(113140);
            return;
        }
        this.pXW.setVisibility(8);
        AppMethodBeat.o(113140);
    }
}

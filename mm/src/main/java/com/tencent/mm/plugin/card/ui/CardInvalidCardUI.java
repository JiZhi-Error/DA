package com.tencent.mm.plugin.card.ui;

import android.os.Bundle;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.q;
import com.tencent.mm.plugin.card.base.CardBaseUI;
import com.tencent.mm.plugin.card.d.d;
import com.tencent.mm.plugin.card.model.CardInfo;
import com.tencent.mm.plugin.card.model.n;
import com.tencent.mm.plugin.card.model.r;
import com.tencent.mm.ui.base.h;
import java.util.LinkedList;

public class CardInvalidCardUI extends CardBaseUI {
    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.plugin.card.base.CardBaseUI, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    static /* synthetic */ void a(CardInvalidCardUI cardInvalidCardUI, LinkedList linkedList) {
        AppMethodBeat.i(113471);
        cardInvalidCardUI.P(linkedList);
        AppMethodBeat.o(113471);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.plugin.card.base.CardBaseUI, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(113465);
        super.onCreate(bundle);
        initView();
        AppMethodBeat.o(113465);
    }

    @Override // com.tencent.mm.ui.MMActivity, com.tencent.mm.plugin.card.base.CardBaseUI
    public void initView() {
        AppMethodBeat.i(113466);
        super.initView();
        AppMethodBeat.o(113466);
    }

    @Override // com.tencent.mm.plugin.card.base.CardBaseUI
    public final n.a csk() {
        return n.a.INVALID_TYPE;
    }

    @Override // com.tencent.mm.plugin.card.base.CardBaseUI
    public final void csj() {
        AppMethodBeat.i(113467);
        setMMTitle(R.string.aqb);
        addTextOptionMenu(0, getString(R.string.anu), new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.card.ui.CardInvalidCardUI.AnonymousClass1 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(113463);
                CardInvalidCardUI.a(CardInvalidCardUI.this);
                AppMethodBeat.o(113463);
                return true;
            }
        });
        if (this.pQr.getCount() > 0) {
            enableOptionMenu(true);
            AppMethodBeat.o(113467);
            return;
        }
        enableOptionMenu(false);
        AppMethodBeat.o(113467);
    }

    @Override // com.tencent.mm.ui.MMActivity, com.tencent.mm.plugin.card.base.CardBaseUI
    public int getLayoutId() {
        return R.layout.ns;
    }

    @Override // com.tencent.mm.ak.i, com.tencent.mm.plugin.card.base.CardBaseUI
    public void onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(113468);
        super.onSceneEnd(i2, i3, str, qVar);
        if (i2 == 0 && i3 == 0 && (qVar instanceof r)) {
            if (this.pQv) {
                h.cD(this, getResources().getString(R.string.anw));
            } else {
                h.cD(this, getResources().getString(R.string.aod));
            }
        }
        this.pQv = false;
        AppMethodBeat.o(113468);
    }

    static /* synthetic */ void a(CardInvalidCardUI cardInvalidCardUI) {
        AppMethodBeat.i(113469);
        d.a(cardInvalidCardUI, new d.a() {
            /* class com.tencent.mm.plugin.card.ui.CardInvalidCardUI.AnonymousClass2 */

            @Override // com.tencent.mm.plugin.card.d.d.a, com.tencent.mm.plugin.card.d.d.b
            public final void cwc() {
                AppMethodBeat.i(113464);
                CardInvalidCardUI.this.pQv = true;
                CardInvalidCardUI.a(CardInvalidCardUI.this, CardInvalidCardUI.c(CardInvalidCardUI.this));
                AppMethodBeat.o(113464);
            }
        });
        AppMethodBeat.o(113469);
    }

    static /* synthetic */ LinkedList c(CardInvalidCardUI cardInvalidCardUI) {
        AppMethodBeat.i(113470);
        LinkedList linkedList = new LinkedList();
        for (int i2 = 0; i2 < cardInvalidCardUI.pQr.getCount(); i2++) {
            CardInfo cardInfo = (CardInfo) cardInvalidCardUI.pQx.Ed(i2);
            if (cardInfo != null) {
                linkedList.add(cardInfo.field_card_id);
            }
        }
        AppMethodBeat.o(113470);
        return linkedList;
    }
}

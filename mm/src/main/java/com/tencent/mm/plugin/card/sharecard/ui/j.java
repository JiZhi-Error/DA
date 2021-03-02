package com.tencent.mm.plugin.card.sharecard.ui;

import android.content.Context;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.card.base.c;
import com.tencent.mm.plugin.card.widget.CardTagTextView;
import com.tencent.mm.plugin.report.service.h;
import java.util.ArrayList;
import java.util.LinkedList;

public final class j implements c {
    private Context mContext;
    private BaseAdapter pXY;
    private long pXZ = 0;
    private long pYa = 0;
    private int pYb;
    private int pYc;
    private ArrayList<Integer> pYd = new ArrayList<>();
    private ArrayList<String> pYe = new ArrayList<>();
    private ArrayList<String> pYf = new ArrayList<>();
    protected LinkedList<CardTagTextView> pYg = new LinkedList<>();

    public j(Context context, BaseAdapter baseAdapter) {
        AppMethodBeat.i(113141);
        this.mContext = context;
        this.pXY = baseAdapter;
        this.pYb = this.mContext.getResources().getDimensionPixelSize(R.dimen.iu);
        this.pYc = this.mContext.getResources().getDimensionPixelSize(R.dimen.ib);
        this.pYd.clear();
        this.pYe.clear();
        this.pYf.clear();
        AppMethodBeat.o(113141);
    }

    @Override // com.tencent.mm.plugin.card.base.c
    public final void release() {
        AppMethodBeat.i(113142);
        this.mContext = null;
        this.pXY = null;
        if (this.pYa > 0) {
            ArrayList<IDKey> arrayList = new ArrayList<>();
            IDKey iDKey = new IDKey();
            iDKey.SetID(281);
            iDKey.SetKey(5);
            iDKey.SetValue(1);
            IDKey iDKey2 = new IDKey();
            iDKey2.SetID(281);
            iDKey2.SetKey(6);
            iDKey2.SetValue((long) ((int) (this.pXZ / this.pYa)));
            arrayList.add(iDKey);
            arrayList.add(iDKey2);
            h.INSTANCE.b(arrayList, true);
        }
        if (this.pYd.size() == this.pYe.size() && this.pYe.size() == this.pYf.size() && this.pYd.size() > 0) {
            long currentTimeMillis = System.currentTimeMillis();
            for (int i2 = 0; i2 < this.pYd.size(); i2++) {
                h.INSTANCE.a(13220, this.pYf.get(i2), this.pYe.get(i2), this.pYd.get(i2), Long.valueOf(currentTimeMillis));
            }
        }
        this.pYd.clear();
        this.pYe.clear();
        this.pYf.clear();
        if (this.pYg != null) {
            this.pYg.clear();
        }
        AppMethodBeat.o(113142);
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x00ce  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x00fc  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0267  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x0408  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x0456  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x0478  */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x04ce  */
    @Override // com.tencent.mm.plugin.card.base.c
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.view.View a(int r11, android.view.View r12, com.tencent.mm.plugin.card.base.b r13) {
        /*
        // Method dump skipped, instructions count: 1255
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.card.sharecard.ui.j.a(int, android.view.View, com.tencent.mm.plugin.card.base.b):android.view.View");
    }

    @Override // com.tencent.mm.plugin.card.base.c
    public final void Y(View view, int i2) {
    }

    @Override // com.tencent.mm.plugin.card.base.c
    public final void Z(View view, int i2) {
    }

    @Override // com.tencent.mm.plugin.card.base.c
    public final void a(View view, int i2, View.OnClickListener onClickListener) {
    }

    private CardTagTextView cuY() {
        AppMethodBeat.i(113144);
        if (this.pYg.size() == 0) {
            CardTagTextView cardTagTextView = new CardTagTextView(this.mContext);
            AppMethodBeat.o(113144);
            return cardTagTextView;
        }
        CardTagTextView removeFirst = this.pYg.removeFirst();
        AppMethodBeat.o(113144);
        return removeFirst;
    }

    public class a {
        public LinearLayout pYh;
        public TextView pYi;
        public TextView pYj;
        public RelativeLayout pYk;
        public ImageView pYl;
        public TextView pYm;
        public TextView pYn;
        public TextView pYo;
        public TextView pYp;
        public TextView pYq;
        public View pYr;
        public TextView pYs;

        public a() {
        }
    }
}

package com.tencent.mm.plugin.emoji.a;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.av.q;
import com.tencent.mm.plugin.emoji.a.a.f;
import com.tencent.mm.plugin.emoji.e.e;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;

public final class h extends com.tencent.mm.plugin.emoji.a.a.a {
    private Context mContext;
    private int mNumColumns = 3;
    private int omS;
    private int opk;
    private int qXE;
    private int qXF;
    private int qXG;
    private boolean qXH;
    public a qXI;
    private HashMap<String, b> qXJ;
    public int qXz = 0;

    public interface a {
        void FP(int i2);
    }

    public h(Context context) {
        super(context);
        AppMethodBeat.i(108333);
        this.mContext = context;
        this.qXH = false;
        this.qXE = this.mContext.getResources().getDimensionPixelSize(R.dimen.ir);
        this.qXF = this.mContext.getResources().getDimensionPixelSize(R.dimen.k);
        this.opk = this.mContext.getResources().getDimensionPixelSize(R.dimen.a2a);
        this.qXG = com.tencent.mm.cb.a.jn(this.mContext);
        this.omS = (int) (((float) (this.qXG - (this.mNumColumns * this.opk))) / (((float) this.mNumColumns) + 1.0f));
        AppMethodBeat.o(108333);
    }

    public final int cFo() {
        AppMethodBeat.i(108334);
        if (!this.qXH) {
            int count = super.getCount();
            AppMethodBeat.o(108334);
            return count;
        } else if (this.qXz == 0) {
            AppMethodBeat.o(108334);
            return 0;
        } else if (this.qXz <= 0 || super.getCount() <= this.qXz) {
            int count2 = super.getCount();
            AppMethodBeat.o(108334);
            return count2;
        } else {
            int i2 = this.qXz;
            AppMethodBeat.o(108334);
            return i2;
        }
    }

    @Override // com.tencent.mm.plugin.emoji.a.a.a
    public final int getCount() {
        int i2 = 0;
        AppMethodBeat.i(108335);
        if (!this.qXH) {
            int cFo = cFo();
            if (cFo > this.qXz) {
                i2 = (int) Math.ceil((double) (((float) (cFo - this.qXz)) / ((float) this.mNumColumns)));
            }
            AppMethodBeat.o(108335);
            return i2;
        } else if (this.qXz == 0) {
            AppMethodBeat.o(108335);
            return 0;
        } else if (this.qXz <= 0 || cFo() <= this.qXz) {
            int ceil = (int) Math.ceil((double) (((float) cFo()) / ((float) this.mNumColumns)));
            AppMethodBeat.o(108335);
            return ceil;
        } else {
            int ceil2 = (int) Math.ceil((double) (((float) this.qXz) / ((float) this.mNumColumns)));
            AppMethodBeat.o(108335);
            return ceil2;
        }
    }

    public final int FO(int i2) {
        if (this.qXH) {
            return this.mNumColumns * i2;
        }
        return (this.mNumColumns * i2) + this.qXz;
    }

    @Override // com.tencent.mm.plugin.emoji.a.a.a
    public final View getView(int i2, View view, ViewGroup viewGroup) {
        b bVar;
        LinearLayout linearLayout;
        AppMethodBeat.i(108336);
        if (view == null || view.getTag() == null) {
            LinearLayout linearLayout2 = new LinearLayout(this.mContext);
            AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, -2);
            linearLayout2.setBackgroundResource(R.drawable.b0w);
            linearLayout2.setOrientation(0);
            linearLayout2.setLayoutParams(layoutParams);
            linearLayout2.setPadding(0, 0, 0, this.qXF);
            b bVar2 = new b();
            bVar2.qXM = linearLayout2;
            linearLayout2.setTag(bVar2);
            for (int i3 = 0; i3 < this.mNumColumns; i3++) {
                LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
                layoutParams2.leftMargin = this.omS;
                bVar2.qXM.addView(new b(this.mContext).kHq, i3, layoutParams2);
            }
            bVar = bVar2;
            linearLayout = linearLayout2;
        } else {
            bVar = (b) view.getTag();
            linearLayout = view;
        }
        for (int i4 = 0; i4 < this.mNumColumns; i4++) {
            final int FO = FO(i2) + i4;
            final b bVar3 = new b(this.mContext, bVar.qXM.getChildAt(i4));
            bVar3.kHq.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.plugin.emoji.a.h.AnonymousClass1 */

                public final void onClick(View view) {
                    AppMethodBeat.i(108332);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/emoji/adapter/EmojiStoreV2PersonAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    if (h.this.qXI != null) {
                        h.this.qXI.FP(FO);
                    }
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/emoji/adapter/EmojiStoreV2PersonAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(108332);
                }
            });
            f FN = getItem(FO);
            if (FO > cFo() - 1 || FN == null) {
                bVar3.kHq.setClickable(false);
                bVar3.kHq.setVisibility(8);
                bVar3.qXk.setBackgroundDrawable(null);
            } else {
                if (this.qXJ == null) {
                    this.qXJ = new HashMap<>();
                }
                if (this.qXJ.containsValue(bVar3)) {
                    this.qXJ.remove(bVar3.qXi);
                }
                bVar3.qXi = a(FN);
                this.qXJ.put(a(FN), bVar3);
                bVar3.kHq.setVisibility(0);
                bVar3.qbV.setText(FN.qYl.PackName);
                q.bcV().a(FN.qYl.IconUrl, bVar3.qXj, e.fQ(FN.qYl.ProductID, FN.qYl.IconUrl));
                bVar3.qXk.setBackgroundResource(R.drawable.emoji_grid_item_fg);
                bVar3.kHq.setClickable(true);
                a(bVar3, FN.mStatus);
            }
        }
        AppMethodBeat.o(108336);
        return linearLayout;
    }

    private void a(b bVar, int i2) {
        AppMethodBeat.i(108337);
        switch (i2) {
            case 7:
                bVar.qbV.setTextColor(super.mContext.getResources().getColor(R.color.u_));
                Drawable drawable = super.mContext.getResources().getDrawable(R.raw.emoji_download_finish);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                bVar.qbV.setCompoundDrawables(null, null, drawable, null);
                AppMethodBeat.o(108337);
                return;
            default:
                bVar.qbV.setTextColor(super.mContext.getResources().getColor(R.color.a2x));
                bVar.qbV.setCompoundDrawables(null, null, null, null);
                Log.w("MicroMsg.emoji.EmojiStoreV2PersonAdapter", "unknow product status:%d", Integer.valueOf(i2));
                AppMethodBeat.o(108337);
                return;
        }
    }

    class b {
        LinearLayout qXM;

        b() {
        }
    }

    @Override // com.tencent.mm.plugin.emoji.a.a.a
    public final a d(Context context, View view) {
        return null;
    }

    @Override // com.tencent.mm.plugin.emoji.a.a.a
    public final int cFk() {
        return this.qXz;
    }

    @Override // com.tencent.mm.plugin.emoji.a.a.a
    public final void FK(int i2) {
        this.qXz = i2;
    }

    @Override // com.tencent.mm.plugin.emoji.a.a.a
    public final int cFl() {
        return 0;
    }

    @Override // com.tencent.mm.plugin.emoji.a.a.a
    public final void FL(int i2) {
    }

    @Override // com.tencent.mm.plugin.emoji.a.a.a
    public final int cFm() {
        return 0;
    }

    @Override // com.tencent.mm.plugin.emoji.a.a.a
    public final void FM(int i2) {
    }

    @Override // com.tencent.mm.plugin.emoji.a.a.a
    public final View b(int i2, View view, ViewGroup viewGroup) {
        return null;
    }

    @Override // com.tencent.mm.plugin.emoji.a.a.a
    public final void dc(String str, int i2) {
        AppMethodBeat.i(108338);
        if (this.qXJ == null) {
            Log.w("MicroMsg.emoji.EmojiStoreV2PersonAdapter", "updateStatus mCacheHolder is nulll.");
            AppMethodBeat.o(108338);
            return;
        }
        b bVar = this.qXJ.get(str);
        f amb = this.qXZ.amb(str);
        if (amb != null) {
            a(amb, str, i2);
        }
        if (!(amb == null || this.qXZ == null || amb.mStatus != -1)) {
            Log.i("MicroMsg.emoji.EmojiStoreV2PersonAdapter", "force refresh status");
            amb.a(this.qXZ.qYi, this.qXZ.amf(str), this.qXZ.amd(str));
        }
        if (bVar == null) {
            Log.w("MicroMsg.emoji.EmojiStoreV2PersonAdapter", "updateStatus viewHolder is nulll.");
            AppMethodBeat.o(108338);
            return;
        }
        a(bVar, i2);
        AppMethodBeat.o(108338);
    }
}

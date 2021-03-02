package com.tencent.mm.plugin.emoji.a;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.emoji.a.f;
import com.tencent.mm.plugin.emoji.model.e;
import com.tencent.mm.sdk.platformtools.Util;

public final class g extends f {
    private int qXA = 0;
    private int qXB = 0;
    private int qXz = 0;

    public g(Context context) {
        super(context);
    }

    @Override // com.tencent.mm.plugin.emoji.a.a.a
    public final int getCount() {
        AppMethodBeat.i(108327);
        int count = super.getCount();
        AppMethodBeat.o(108327);
        return count;
    }

    @Override // com.tencent.mm.plugin.emoji.a.a.a, com.tencent.mm.plugin.emoji.a.f
    public final View b(int i2, View view, ViewGroup viewGroup) {
        AppMethodBeat.i(108328);
        final f.a aVar = (f.a) view.getTag();
        if (this.qXz > 0) {
            if (i2 == 0) {
                aVar.qWY.setVisibility(0);
                aVar.qWY.setText(this.mContext.getString(R.string.bug));
            } else if (this.qXA > 0 && i2 == this.qXz) {
                aVar.qWY.setVisibility(0);
                aVar.qWY.setText(this.mContext.getString(R.string.bv1));
            } else if (i2 == this.qXz + this.qXA) {
                aVar.qWY.setVisibility(0);
                if (!Util.isNullOrNil(e.cFX().rbp)) {
                    aVar.qWY.setText(e.cFX().rbp);
                } else if (e.cFX().rbn) {
                    aVar.qWY.setText(R.string.bv0);
                } else {
                    aVar.qWY.setText(this.mContext.getString(R.string.btx));
                }
            } else {
                aVar.qWY.setVisibility(8);
            }
        } else if (this.qXA > 0) {
            if (i2 == 0) {
                aVar.qWY.setVisibility(0);
                aVar.qWY.setText(this.mContext.getString(R.string.bv1));
            } else if (i2 == this.qXz + this.qXA) {
                aVar.qWY.setVisibility(0);
                if (!Util.isNullOrNil(e.cFX().rbp)) {
                    aVar.qWY.setText(e.cFX().rbp);
                } else if (e.cFX().rbn) {
                    aVar.qWY.setText(R.string.bv0);
                } else {
                    aVar.qWY.setText(this.mContext.getString(R.string.btx));
                }
            } else {
                aVar.qWY.setVisibility(8);
            }
        } else if (i2 == 0) {
            aVar.qWY.setVisibility(0);
            if (!Util.isNullOrNil(e.cFX().rbp)) {
                aVar.qWY.setText(e.cFX().rbp);
            } else if (e.cFX().rbn) {
                aVar.qWY.setText(R.string.bv0);
            } else {
                aVar.qWY.setText(this.mContext.getString(R.string.btx));
            }
        } else {
            aVar.qWY.setVisibility(8);
        }
        if (aVar.qXa != null) {
            aVar.qXa.postDelayed(new Runnable() {
                /* class com.tencent.mm.plugin.emoji.a.g.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(108326);
                    aVar.qXa.setPressed(false);
                    AppMethodBeat.o(108326);
                }
            }, 100);
        }
        View b2 = super.b(i2, view, viewGroup);
        AppMethodBeat.o(108328);
        return b2;
    }

    @Override // com.tencent.mm.plugin.emoji.a.a.a
    public final com.tencent.mm.plugin.emoji.a.a.f FN(int i2) {
        AppMethodBeat.i(108329);
        com.tencent.mm.plugin.emoji.a.a.f FN = super.getItem(i2);
        AppMethodBeat.o(108329);
        return FN;
    }

    @Override // com.tencent.mm.plugin.emoji.a.a.a, com.tencent.mm.plugin.emoji.a.f
    public final int cFk() {
        return this.qXz;
    }

    @Override // com.tencent.mm.plugin.emoji.a.a.a, com.tencent.mm.plugin.emoji.a.f
    public final void FK(int i2) {
        this.qXz = i2;
    }

    @Override // com.tencent.mm.plugin.emoji.a.a.a, com.tencent.mm.plugin.emoji.a.f
    public final int cFl() {
        return this.qXA;
    }

    @Override // com.tencent.mm.plugin.emoji.a.a.a, com.tencent.mm.plugin.emoji.a.f
    public final void FL(int i2) {
        this.qXA = i2;
    }

    @Override // com.tencent.mm.plugin.emoji.a.a.a, com.tencent.mm.plugin.emoji.a.f
    public final int cFm() {
        return this.qXB;
    }

    @Override // com.tencent.mm.plugin.emoji.a.a.a, com.tencent.mm.plugin.emoji.a.f
    public final void FM(int i2) {
        this.qXB = i2;
    }

    @Override // com.tencent.mm.plugin.emoji.a.a.a
    public final /* synthetic */ Object getItem(int i2) {
        AppMethodBeat.i(108331);
        com.tencent.mm.plugin.emoji.a.a.f FN = super.getItem(i2);
        AppMethodBeat.o(108331);
        return FN;
    }
}

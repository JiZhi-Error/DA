package com.tencent.mm.plugin.sns.ui.a;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.k.e;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.ui.aa;
import com.tencent.mm.plugin.sns.ui.bk;
import com.tencent.mm.plugin.sns.ui.bl;
import com.tencent.mm.plugin.sns.ui.d.c;
import com.tencent.mm.plugin.sns.ui.i;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.vending.base.Vending;
import java.util.ArrayList;
import java.util.List;

public final class d extends BaseAdapter implements aa {
    public bk ESp;
    public List<bl> dataList = new ArrayList();

    public final /* synthetic */ Object getItem(int i2) {
        AppMethodBeat.i(203870);
        SnsInfo Zv = Zv(i2);
        AppMethodBeat.o(203870);
        return Zv;
    }

    public d(MMActivity mMActivity, ListView listView, c cVar, i iVar) {
        AppMethodBeat.i(203864);
        this.ESp = new bk(mMActivity, listView, cVar, iVar, this);
        AppMethodBeat.o(203864);
    }

    @Override // com.tencent.mm.plugin.sns.ui.aa
    public final int getCount() {
        AppMethodBeat.i(203865);
        int size = this.dataList.size();
        AppMethodBeat.o(203865);
        return size;
    }

    @Override // com.tencent.mm.plugin.sns.ui.aa
    public final Vending ffN() {
        return null;
    }

    @Override // com.tencent.mm.plugin.sns.ui.aa
    public final bl Zw(int i2) {
        AppMethodBeat.i(203866);
        bl blVar = this.dataList.get(i2);
        AppMethodBeat.o(203866);
        return blVar;
    }

    @Override // com.tencent.mm.plugin.sns.ui.aa
    public final void ffM() {
        AppMethodBeat.i(203867);
        this.ESp.notifyDataSetChanged();
        AppMethodBeat.o(203867);
    }

    @Override // com.tencent.mm.plugin.sns.ui.aa
    public final SnsInfo Zv(int i2) {
        AppMethodBeat.i(203868);
        SnsInfo snsInfo = this.dataList.get(i2).DqO;
        AppMethodBeat.o(203868);
        return snsInfo;
    }

    public final long getItemId(int i2) {
        return 0;
    }

    public final View getView(int i2, View view, ViewGroup viewGroup) {
        AppMethodBeat.i(203869);
        if (i2 >= 0 && i2 < this.dataList.size()) {
            e eVar = e.DUQ;
            long j2 = this.dataList.get(i2).ENp;
            if (!eVar.DVJ.contains(Long.valueOf(j2))) {
                eVar.DVJ.add(Long.valueOf(j2));
            }
        }
        View o = this.ESp.o(i2, view);
        AppMethodBeat.o(203869);
        return o;
    }
}

package com.tencent.mm.plugin.fav.ui.a;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fav.a.af;
import com.tencent.mm.plugin.fav.a.l;
import com.tencent.mm.plugin.fav.ui.widget.FavTagPanel;
import com.tencent.mm.protocal.protobuf.anl;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.MMTagPanel;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public abstract class c extends BaseAdapter implements l.a, MMTagPanel.a {
    private Context context;
    private int thx = R.color.a2x;
    private int thy = R.drawable.vp;
    private Set<String> thz = new HashSet();

    public static class a {
        TextView pnP;
        FavTagPanel thA;
    }

    /* access modifiers changed from: protected */
    public abstract void aso(String str);

    /* access modifiers changed from: protected */
    public abstract void asp(String str);

    public c(Context context2) {
        this.context = context2;
    }

    public int getCount() {
        ((af) g.ah(af.class)).getFavTagSetMgr();
        return 1;
    }

    public long getItemId(int i2) {
        return (long) i2;
    }

    public View getView(int i2, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            view = View.inflate(this.context, R.layout.a83, null);
            a aVar2 = new a();
            aVar2.pnP = (TextView) view.findViewById(R.id.cco);
            aVar2.thA = (FavTagPanel) view.findViewById(R.id.cdj);
            aVar2.thA.setCallBack(this);
            aVar2.thA.setTagNormalBG(this.thy);
            aVar2.thA.setTagNormalTextColorRes(this.thx);
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        FavTagPanel favTagPanel = aVar.thA;
        Set<String> set = this.thz;
        List<anl> HW = ((af) g.ah(af.class)).getFavTagSetMgr().HW(i2);
        if (HW == null || HW.isEmpty()) {
            Object[] objArr = new Object[1];
            objArr[0] = Boolean.valueOf(HW == null);
            Log.e("MicroMsg.FavTagPanel", "setTagListByTagInfo,null == tags ?%B,", objArr);
        } else {
            Log.i("MicroMsg.FavTagPanel", "setTagListByTagInfo,tags.size = %d", Integer.valueOf(HW.size()));
            LinkedList linkedList = new LinkedList();
            for (anl anl : HW) {
                linkedList.add(anl.FeZ);
            }
            favTagPanel.a(set, linkedList);
        }
        return view;
    }

    @Override // com.tencent.mm.ui.base.MMTagPanel.a
    public final void and(String str) {
    }

    @Override // com.tencent.mm.ui.base.MMTagPanel.a
    public final void ane(String str) {
    }

    @Override // com.tencent.mm.ui.base.MMTagPanel.a
    public final void anf(String str) {
    }

    @Override // com.tencent.mm.ui.base.MMTagPanel.a
    public final void cIk() {
    }

    public final void ass(String str) {
        this.thz.add(str);
        notifyDataSetChanged();
    }

    public final void ast(String str) {
        this.thz.remove(str);
        notifyDataSetChanged();
    }

    public final void dK(List<String> list) {
        this.thz.clear();
        if (list != null) {
            this.thz.addAll(list);
        }
    }

    @Override // com.tencent.mm.ui.base.MMTagPanel.a
    public final void anc(String str) {
        ass(str);
        aso(str);
    }

    @Override // com.tencent.mm.ui.base.MMTagPanel.a
    public final void anb(String str) {
        ast(str);
        asp(str);
    }

    @Override // com.tencent.mm.plugin.fav.a.l.a
    public final void cUG() {
        Log.d("MicroMsg.FavoriteTagPanelAdapter", "on addtag callback");
        notifyDataSetChanged();
    }

    @Override // com.tencent.mm.plugin.fav.a.l.a
    public final void cUH() {
        Log.d("MicroMsg.FavoriteTagPanelAdapter", "on removetag callback");
        notifyDataSetChanged();
    }

    @Override // com.tencent.mm.ui.base.MMTagPanel.a
    public final void E(boolean z, int i2) {
    }

    public /* synthetic */ Object getItem(int i2) {
        return ((af) g.ah(af.class)).getFavTagSetMgr().HW(i2);
    }
}

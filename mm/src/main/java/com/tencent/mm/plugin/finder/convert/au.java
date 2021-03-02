package com.tencent.mm.plugin.finder.convert;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.finder.model.al;
import com.tencent.mm.protocal.protobuf.axk;
import com.tencent.mm.view.recyclerview.e;
import com.tencent.mm.view.recyclerview.h;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\t\u001a\u00020\nH\u0016J@\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u00132\u000e\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0015H\u0016J \u0010\u0017\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\nH\u0016R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0005¨\u0006\u001a"}, hxF = {"Lcom/tencent/mm/plugin/finder/convert/FinderLiveTagConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/finder/model/FinderLiveTagData;", "selectedTagInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveTagInfo;", "(Lcom/tencent/mm/protocal/protobuf/FinderLiveTagInfo;)V", "getSelectedTagInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderLiveTagInfo;", "setSelectedTagInfo", "getLayoutId", "", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "plugin-finder_release"})
public final class au extends e<al> {
    private axk tEC;

    public au(axk axk) {
        this.tEC = axk;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.view.recyclerview.h, com.tencent.mm.view.recyclerview.a, int, int, boolean, java.util.List] */
    @Override // com.tencent.mm.view.recyclerview.e
    public final /* synthetic */ void a(h hVar, al alVar, int i2, int i3, boolean z, List list) {
        axk axk;
        axk axk2;
        Context context;
        Object[] objArr;
        Object[] objArr2;
        axk axk3;
        axk axk4;
        axk axk5;
        String str = null;
        AppMethodBeat.i(243158);
        al alVar2 = alVar;
        p.h(hVar, "holder");
        p.h(alVar2, "item");
        TextView textView = (TextView) hVar.Mn(R.id.cy8);
        TextView textView2 = (TextView) hVar.Mn(R.id.cy6);
        if (textView2 != null) {
            textView2.setText(alVar2.uOy.qHk);
        }
        if (this.tEC == null || (((axk = this.tEC) != null && axk.LHS == -1) || (axk2 = this.tEC) == null || axk2.LHS != alVar2.uOy.LHS)) {
            p.g(textView, "selectedTagTip");
            textView.setVisibility(8);
            AppMethodBeat.o(243158);
            return;
        }
        axk axk6 = this.tEC;
        if (axk6 == null || (axk4 = axk6.LHU) == null || axk4.LHV != 1) {
            p.g(textView, "selectedTagTip");
            context = textView.getContext();
            Object[] objArr3 = new Object[1];
            axk axk7 = this.tEC;
            if (axk7 == null || (axk3 = axk7.LHU) == null) {
                objArr = objArr3;
                objArr2 = objArr3;
            } else {
                str = axk3.qHk;
                objArr = objArr3;
                objArr2 = objArr3;
            }
        } else {
            p.g(textView, "selectedTagTip");
            context = textView.getContext();
            Object[] objArr4 = new Object[1];
            StringBuilder sb = new StringBuilder();
            axk axk8 = this.tEC;
            StringBuilder append = sb.append(axk8 != null ? axk8.qHk : null).append('-');
            axk axk9 = this.tEC;
            if (!(axk9 == null || (axk5 = axk9.LHU) == null)) {
                str = axk5.qHk;
            }
            str = append.append(str).toString();
            objArr = objArr4;
            objArr2 = objArr4;
        }
        objArr[0] = str;
        String string = context.getString(R.string.czh, objArr2);
        p.g(string, "if (selectedTagInfo?.cho…?.tag_name)\n            }");
        textView.setVisibility(0);
        textView.setText(string);
        AppMethodBeat.o(243158);
    }

    @Override // com.tencent.mm.view.recyclerview.e
    public final int getLayoutId() {
        return R.layout.afh;
    }

    @Override // com.tencent.mm.view.recyclerview.e
    public final void a(RecyclerView recyclerView, h hVar, int i2) {
        AppMethodBeat.i(243157);
        p.h(recyclerView, "recyclerView");
        p.h(hVar, "holder");
        AppMethodBeat.o(243157);
    }
}

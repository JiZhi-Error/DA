package com.tencent.mm.plugin.fts.ui.widget;

import com.tencent.mm.protocal.protobuf.efk;
import com.tencent.mm.view.recyclerview.a;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\b\u0010\u0011\u001a\u00020\u0003H\u0016J\b\u0010\u0012\u001a\u00020\u0005H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0013"}, hxF = {"Lcom/tencent/mm/plugin/fts/ui/widget/KeyboardSugItem;", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "id", "", "type", "", "sugItem", "Lcom/tencent/mm/protocal/protobuf/SugItem;", "(JILcom/tencent/mm/protocal/protobuf/SugItem;)V", "getId", "()J", "getSugItem", "()Lcom/tencent/mm/protocal/protobuf/SugItem;", "setSugItem", "(Lcom/tencent/mm/protocal/protobuf/SugItem;)V", "getType", "()I", "getItemId", "getItemType", "ui-fts_release"})
public final class g implements a {
    final long id;
    private final int type;
    efk xfN;

    public /* synthetic */ g() {
        this(0, 0, null);
    }

    public g(long j2, int i2, efk efk) {
        this.id = j2;
        this.type = i2;
        this.xfN = efk;
    }

    @Override // com.tencent.mm.view.recyclerview.a
    public final long lT() {
        return this.id;
    }

    @Override // com.tencent.mm.view.recyclerview.a
    public final int cxn() {
        return this.type;
    }
}

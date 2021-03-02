package com.tencent.mm.plugin.finder.widget.pref;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.protocal.protobuf.az;
import com.tencent.mm.ui.base.preference.Preference;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B'\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nB\u001f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\u000bB\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\fJ\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\u0006\u0010\u000f\u001a\u00020\u000eR\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, hxF = {"Lcom/tencent/mm/plugin/finder/widget/pref/FinderAccountManagementPref;", "Lcom/tencent/mm/ui/base/preference/Preference;", "config", "Lcom/tencent/mm/protocal/protobuf/AcctConfig;", "context", "Landroid/content/Context;", "attributeSet", "Landroid/util/AttributeSet;", "defStyle", "", "(Lcom/tencent/mm/protocal/protobuf/AcctConfig;Landroid/content/Context;Landroid/util/AttributeSet;I)V", "(Lcom/tencent/mm/protocal/protobuf/AcctConfig;Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Lcom/tencent/mm/protocal/protobuf/AcctConfig;Landroid/content/Context;)V", "initContent", "", "onPrefClick", "plugin-finder_release"})
public final class a extends Preference {
    public az wDE;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(az azVar, Context context) {
        super(context);
        int i2;
        String str;
        p.h(azVar, "config");
        p.h(context, "context");
        AppMethodBeat.i(256156);
        setLayoutResource(R.layout.b8j);
        this.wDE = azVar;
        az azVar2 = this.wDE;
        setTitle((azVar2 == null || (str = azVar2.KDX) == null) ? "" : str);
        az azVar3 = this.wDE;
        if (azVar3 != null) {
            i2 = azVar3.hashCode();
        } else {
            i2 = 0;
        }
        setKey(String.valueOf(i2));
        AppMethodBeat.o(256156);
    }
}

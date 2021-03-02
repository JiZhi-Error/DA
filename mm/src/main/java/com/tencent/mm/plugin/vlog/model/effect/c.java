package com.tencent.mm.plugin.vlog.model.effect;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ab.f;
import com.tencent.mm.ab.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.io.InputStream;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0005J\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\fJ\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\fJ\u000e\u0010\u000f\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0005R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, hxF = {"Lcom/tencent/mm/plugin/vlog/model/effect/MagicListData;", "", "()V", "addedEffectList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/vlog/model/effect/MagicAddEffectItem;", "effectList", "Lcom/tencent/mm/plugin/vlog/model/effect/EffectInfo;", "addEffect", "", "item", "getAddItemList", "", "getItemList", "Lcom/tencent/mm/plugin/vlog/model/effect/MagicListItem;", "removeEffect", "Companion", "plugin-vlog_release"})
public final class c {
    public static final a GAq = new a((byte) 0);
    public final LinkedList<b> GAo = new LinkedList<>();
    private final LinkedList<a> GAp = new LinkedList<>();

    static {
        AppMethodBeat.i(190731);
        AppMethodBeat.o(190731);
    }

    public c() {
        AppMethodBeat.i(190730);
        try {
            Context context = MMApplicationContext.getContext();
            p.g(context, "MMApplicationContext.getContext()");
            InputStream open = context.getAssets().open("pag/magic/pag_magic.json");
            p.g(open, "MMApplicationContext.get…assets.open(MAGIC_CONFIG)");
            String streamToString = Util.streamToString(open);
            Log.i("MicroMsg.MagicListData", "initVideoTemplates config:".concat(String.valueOf(streamToString)));
            f FI = new i(streamToString).FI("magicList");
            int length = FI.length();
            for (int i2 = 0; i2 < length; i2++) {
                i pY = FI.pY(i2);
                if (pY.optInt("use", 0) == 1) {
                    this.GAp.add(new a("pag/magic/" + pY.optString("pag"), "pag/magic/" + pY.optString("cover")));
                }
            }
        } catch (Exception e2) {
            Log.e("MicroMsg.MagicListData", "parse magic config error");
        }
        AppMethodBeat.o(190730);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/vlog/model/effect/MagicListData$Companion;", "", "()V", "MAGIC_CONFIG", "", "MAGIC_PATH", "TAG", "plugin-vlog_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public final List<e> avn() {
        AppMethodBeat.i(190729);
        LinkedList linkedList = new LinkedList();
        if (this.GAo.size() > 0) {
            String string = MMApplicationContext.getContext().getString(R.string.etv);
            p.g(string, "MMApplicationContext.get…g.magic_list_title_added)");
            linkedList.add(new f(string));
            linkedList.addAll(this.GAo);
        }
        String string2 = MMApplicationContext.getContext().getString(R.string.etw);
        p.g(string2, "MMApplicationContext.get…ing.magic_list_title_all)");
        linkedList.add(new f(string2));
        Iterator<T> it = this.GAp.iterator();
        while (it.hasNext()) {
            linkedList.add(new d(it.next()));
        }
        LinkedList linkedList2 = linkedList;
        AppMethodBeat.o(190729);
        return linkedList2;
    }
}

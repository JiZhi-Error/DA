package com.tencent.mm.plugin.finder.cgi.interceptor;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.finder.cgi.aa;
import com.tencent.mm.plugin.finder.feed.model.b;
import com.tencent.mm.plugin.finder.model.ai;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.protocal.protobuf.bcw;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.Iterator;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0018\u0010\r\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0018\u0010\u000e\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\fH\u0016¨\u0006\u0010"}, hxF = {"Lcom/tencent/mm/plugin/finder/cgi/interceptor/HandleHistoryTipsInterceptor;", "Lcom/tencent/mm/plugin/finder/cgi/interceptor/IFinderStreamInterceptor;", "()V", "handle", "", "loadedInfo", "Lcom/tencent/mm/plugin/finder/feed/model/CgiFinderStreamResult;", "onIntercept", "", "resp", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderStream$FinderStreamResponseEx;", "tabType", "", "onInterceptAfterStore", "onInterceptBeforeStore", "Companion", "plugin-finder_release"})
public final class c implements f {
    public static final a txB = new a((byte) 0);

    static {
        AppMethodBeat.i(242621);
        AppMethodBeat.o(242621);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/finder/cgi/interceptor/HandleHistoryTipsInterceptor$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @Override // com.tencent.mm.plugin.finder.cgi.interceptor.f
    public final boolean a(aa.f fVar) {
        AppMethodBeat.i(242618);
        p.h(fVar, "resp");
        AppMethodBeat.o(242618);
        return false;
    }

    @Override // com.tencent.mm.plugin.finder.cgi.interceptor.f
    public final boolean b(b bVar, int i2) {
        AppMethodBeat.i(242620);
        p.h(bVar, "loadedInfo");
        AppMethodBeat.o(242620);
        return false;
    }

    @Override // com.tencent.mm.plugin.finder.cgi.interceptor.f
    public final boolean a(b bVar) {
        T t;
        boolean z;
        boolean z2;
        AppMethodBeat.i(242619);
        p.h(bVar, "loadedInfo");
        int i2 = bVar.dLS;
        int i3 = bVar.pullType;
        boolean z3 = bVar.twZ;
        boolean z4 = bVar.tUD;
        long j2 = bVar.ttW;
        int i4 = bVar.ttV;
        int i5 = bVar.kxF;
        Log.i("Finder.HandleHistoryTipsInterceptor", "[handle] tabType=" + i2 + " pullType=" + i3 + " isGetHistory=" + z3 + " isFetchHistory=" + z4 + " afterFeedIdHistory=" + j2 + " streamSize=" + i4 + " historySize=" + i5);
        if (!z3 && z4 && i5 > 0 && ((i2 == 3 || i2 == 1) && (i3 == 2 || ((i3 == 1 || i3 == 0) && i4 > 0)))) {
            if (!y.a(y.vXH, i2, 0, 2)) {
                Iterator<T> it = bVar.tUz.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        t = null;
                        break;
                    }
                    t = it.next();
                    if (t.cxn() == 2011) {
                        z2 = true;
                        continue;
                    } else {
                        z2 = false;
                        continue;
                    }
                    if (z2) {
                        break;
                    }
                }
                if (t == null) {
                    bcw bcw = new bcw();
                    bcw.LLE = 2;
                    bcw.uOx = System.currentTimeMillis();
                    Context context = MMApplicationContext.getContext();
                    p.g(context, "MMApplicationContext.getContext()");
                    bcw.dQx = context.getResources().getString(R.string.da5);
                    ai aiVar = new ai(bcw);
                    int i6 = 0;
                    Iterator<bo> it2 = bVar.tUz.iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            i6 = -1;
                            break;
                        }
                        if (it2.next().lT() == j2) {
                            z = true;
                        } else {
                            z = false;
                        }
                        if (z) {
                            break;
                        }
                        i6++;
                    }
                    bVar.tUz.add(i6 + 1, aiVar);
                    Log.i("Finder.HandleHistoryTipsInterceptor", "tabType=" + i2 + ", index=" + i6 + ", streamSize=" + i4 + " afterFeedIdHistory=" + j2);
                }
            }
            Log.i("Finder.HandleHistoryTipsInterceptor", "tabType=" + i2 + ", has insert history divider from server");
        }
        AppMethodBeat.o(242619);
        return false;
    }
}

package com.tencent.mm.plugin.profile.ui.tab;

import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bfu;
import com.tencent.mm.protocal.protobuf.ph;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\"\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u001c\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0002\u001a\u000e\u0010\r\u001a\u0004\u0018\u00010\t*\u0004\u0018\u00010\f\u001a\u000e\u0010\u000e\u001a\u0004\u0018\u00010\t*\u0004\u0018\u00010\f\u001a\u000e\u0010\u000f\u001a\u0004\u0018\u00010\t*\u0004\u0018\u00010\f\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00018F¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0003\"\u0015\u0010\u0004\u001a\u00020\u0005*\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, hxF = {"dpToPixel", "", "getDpToPixel", "(F)F", "resToPixel", "", "getResToPixel", "(I)I", "findBlockWording", "", "funcFlagBit", "bizProfileV2Resp", "Lcom/tencent/mm/protocal/protobuf/BizProfileV2Resp;", "listBlockWording", "msgListFooterWording", "videoListFooterWording", "app_release"})
public final class a {
    public static final float eFy() {
        AppMethodBeat.i(230662);
        Resources resources = MMApplicationContext.getResources();
        p.g(resources, "MMApplicationContext.getResources()");
        float f2 = (resources.getDisplayMetrics().density * 8.0f) + 0.5f;
        AppMethodBeat.o(230662);
        return f2;
    }

    public static final String a(int i2, ph phVar) {
        AppMethodBeat.i(230663);
        if (phVar == null) {
            AppMethodBeat.o(230663);
            return null;
        } else if ((phVar.KTf & i2) == 0) {
            AppMethodBeat.o(230663);
            return null;
        } else {
            LinkedList<bfu> linkedList = phVar.KWk;
            if (linkedList == null) {
                AppMethodBeat.o(230663);
                return null;
            }
            Iterator<bfu> it = linkedList.iterator();
            while (it.hasNext()) {
                bfu next = it.next();
                if (next.KTf == i2) {
                    String str = next.xJH;
                    AppMethodBeat.o(230663);
                    return str;
                }
            }
            AppMethodBeat.o(230663);
            return null;
        }
    }
}

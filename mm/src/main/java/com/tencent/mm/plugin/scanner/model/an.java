package com.tencent.mm.plugin.scanner.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.scanner.f.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.qbar.a;
import java.util.ArrayList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u0007\b\u0016¢\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u001c\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u000b"}, hxF = {"Lcom/tencent/mm/plugin/scanner/model/WxScanCodeResultFilter;", "Lcom/tencent/mm/plugin/scanner/result/IScanCodeResultFilter;", "()V", "directJumpWhiteCode", "", "directJumpWhiteListCode", "filter", "", "Lcom/tencent/qbar/QBar$QBarResult;", "codeResultList", "Companion", "plugin-scan_release"})
public final class an implements c {
    public static final a CHS = new a((byte) 0);
    private boolean CHR;

    static {
        AppMethodBeat.i(240479);
        AppMethodBeat.o(240479);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/scanner/model/WxScanCodeResultFilter$Companion;", "", "()V", "TAG", "", "plugin-scan_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public an() {
        boolean z;
        AppMethodBeat.i(240478);
        int a2 = ((b) g.af(b.class)).a(b.a.clicfg_scan_code_multi_code_direct_jump, 0);
        if (a2 != 0) {
            z = true;
        } else {
            z = false;
        }
        this.CHR = z;
        Log.i("MicroMsg.WxScanCodeResultFilter", "alvinluo WxScanCodeResultFilter init config: %d, directJumpWhiteCode: %b", Integer.valueOf(a2), Boolean.valueOf(this.CHR));
        AppMethodBeat.o(240478);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r11v0, resolved type: java.util.List<? extends com.tencent.qbar.a$a> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mm.plugin.scanner.f.c
    public final List<a.C2180a> gC(List<? extends a.C2180a> list) {
        ArrayList arrayList;
        boolean z = true;
        AppMethodBeat.i(240477);
        p.h(list, "codeResultList");
        if (list.size() <= 1) {
            AppMethodBeat.o(240477);
            return list;
        }
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        int i2 = 0;
        for (a.C2180a aVar : list) {
            if (com.tencent.qbar.b.bpV(aVar.data)) {
                i2++;
            } else {
                arrayList2.add(aVar);
                if (com.tencent.qbar.b.bpU(aVar.data)) {
                    arrayList3.add(aVar);
                }
            }
        }
        if (i2 == list.size() || arrayList3.size() != 1) {
            arrayList = list;
        } else if (i2 == list.size() - arrayList3.size()) {
            arrayList = arrayList3;
        } else if (i2 != 0) {
            arrayList = list;
        } else if (this.CHR) {
            arrayList = arrayList3;
        } else {
            arrayList = list;
        }
        Object[] objArr = new Object[7];
        objArr[0] = Integer.valueOf(i2);
        objArr[1] = Integer.valueOf(arrayList3.size());
        objArr[2] = Integer.valueOf(arrayList2.size());
        objArr[3] = Integer.valueOf(list.size());
        objArr[4] = Integer.valueOf(arrayList.size());
        objArr[5] = Boolean.valueOf(arrayList.size() == 1);
        if (arrayList.size() != list.size()) {
            z = false;
        }
        objArr[6] = Boolean.valueOf(z);
        Log.i("MicroMsg.WxScanCodeResultFilter", "alvinluo filter badCodeNum: %d, whiteCodeNum: %d, commonCodeNum: %d, originNum: %d, finalNum: %d, directJump: %b, showMultiCode: %b", objArr);
        AppMethodBeat.o(240477);
        return arrayList;
    }
}

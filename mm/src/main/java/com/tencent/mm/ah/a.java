package com.tencent.mm.ah;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.acc;
import com.tencent.mm.protocal.protobuf.che;
import com.tencent.tinker.loader.shareutil.SharePatchInfo;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u0004*\u0004\u0018\u00010\u0005H\u0007J\u000e\u0010\u0003\u001a\u00020\u0004*\u0004\u0018\u00010\u0006H\u0007¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/mmbizprotodef/WxaCgiLogUtils;", "", "()V", SharePatchInfo.FINGER_PRINT, "", "Lcom/tencent/mm/protocal/protobuf/CommRequestSource;", "Lcom/tencent/mm/protocal/protobuf/LaunchWxaAppResponse;", "data-model_release"})
public final class a {
    public static final a iBk = new a();

    static {
        AppMethodBeat.i(225247);
        AppMethodBeat.o(225247);
    }

    private a() {
    }

    public static final String a(acc acc) {
        AppMethodBeat.i(225245);
        if (acc == null) {
            AppMethodBeat.o(225245);
            return "CommRequestSource{NULL}";
        }
        String str = "CommRequestSource{open_scene=" + acc.dUS + ", is_pre_hot=" + acc.LmF + ", sync_type=" + acc.LmG + '}';
        AppMethodBeat.o(225245);
        return str;
    }

    public static final String a(che che) {
        String str;
        String str2;
        String sb;
        AppMethodBeat.i(225246);
        StringBuilder sb2 = new StringBuilder("LaunchWxaAppResponse{");
        if (che == null) {
            sb = "NULL";
        } else {
            if (che.MmA == null) {
                str = "NULL_API_INFO";
            } else {
                String str3 = "api_info~ fg:" + (che.MmA.LjS == null ? "NULL" : Integer.valueOf(che.MmA.LjS.zy.length));
                if (che.MmA.LjT != null) {
                    if (che.MmA.LjT.size() > 0) {
                        str3 = str3 + " | bg:" + che.MmA.LjT.get(0).zy.length;
                    }
                    if (che.MmA.LjT.size() > 1) {
                        str3 = str3 + " | suspend:" + che.MmA.LjT.get(1).zy.length;
                    }
                }
                str = str3 + "~";
            }
            StringBuilder append = new StringBuilder().append(str);
            if (che.Mmz == null) {
                str2 = " || NULL_LAUNCH";
            } else {
                str2 = " || launch " + che.Mmz.KCD;
            }
            sb = append.append(str2).toString();
        }
        String sb3 = sb2.append(sb).append("}").toString();
        AppMethodBeat.o(225246);
        return sb3;
    }
}

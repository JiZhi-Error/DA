package com.tencent.mm.plugin.expt.hellhound.core.b.c;

import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewParent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.core.b;
import com.tencent.mm.protocal.protobuf.erd;
import com.tencent.mm.protocal.protobuf.ere;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, hxF = {"Lcom/tencent/mm/plugin/expt/hellhound/core/v2/view/ViewUtil;", "", "()V", "Companion", "plugin-expt_release"})
public final class g {
    public static final a sBf = new a((byte) 0);

    static {
        AppMethodBeat.i(220788);
        AppMethodBeat.o(220788);
    }

    public static final boolean a(erd erd, ere ere) {
        AppMethodBeat.i(220789);
        boolean a2 = a.a(erd, ere);
        AppMethodBeat.o(220789);
        return a2;
    }

    public static final boolean gp(String str, String str2) {
        AppMethodBeat.i(220790);
        boolean gp = a.gp(str, str2);
        AppMethodBeat.o(220790);
        return gp;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\t\u001a\u00020\u0004H\u0002J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0006H\u0002J\u0012\u0010\f\u001a\u0004\u0018\u00010\u00042\b\u0010\r\u001a\u0004\u0018\u00010\u000eJ\u000e\u0010\u000f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000eJ\u001c\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00042\b\u0010\u0013\u001a\u0004\u0018\u00010\u0004H\u0007J&\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0006J\u0018\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u001e"}, hxF = {"Lcom/tencent/mm/plugin/expt/hellhound/core/v2/view/ViewUtil$Companion;", "", "()V", "TAG", "", "VIEW_TYPE_LIST", "", "VIEW_TYPE_SINGLE", "covertResName", "resName", "doGetResNameAgain", "viewId", "getResName", "view", "Landroid/view/View;", "getViewPath", "isViewCallerOk", "", "caller", "clazzProguard", "report", "", "page", "layout", "opEvent", "viewEqual", "viewNode", "Lcom/tencent/mm/protocal/protobuf/ViewNode;", "viewOp", "Lcom/tencent/mm/protocal/protobuf/ViewOp;", "plugin-expt_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static String dL(View view) {
            AppMethodBeat.i(220783);
            if (view == null) {
                AppMethodBeat.o(220783);
                return null;
            } else if (-1 == view.getId()) {
                AppMethodBeat.o(220783);
                return "-1";
            } else {
                try {
                    String resourceName = view.getResources().getResourceName(view.getId());
                    if (resourceName == null) {
                        String GW = GW(view.getId());
                        AppMethodBeat.o(220783);
                        return GW;
                    }
                    List<String> a2 = n.a(n.j(resourceName, FilePathGenerator.ANDROID_DIR_SEP, ":", false), new String[]{":"});
                    String str = "R:" + a2.get(1) + ":" + a2.get(2);
                    AppMethodBeat.o(220783);
                    return str;
                } catch (Resources.NotFoundException e2) {
                    String GW2 = GW(view.getId());
                    AppMethodBeat.o(220783);
                    return GW2;
                }
            }
        }

        private static String GW(int i2) {
            AppMethodBeat.i(220784);
            String valueOf = String.valueOf(i2);
            if (b.isNumeric(valueOf)) {
                String hexString = b.toHexString(i2);
                p.g(hexString, "HellhoundUtil.toHexString(viewId)");
                AppMethodBeat.o(220784);
                return hexString;
            }
            try {
                String hexString2 = b.toHexString(i2);
                p.g(hexString2, "HellhoundUtil.toHexString(viewId)");
                AppMethodBeat.o(220784);
                return hexString2;
            } catch (Exception e2) {
                AppMethodBeat.o(220784);
                return valueOf;
            }
        }

        public static String dM(View view) {
            AppMethodBeat.i(220785);
            p.h(view, "view");
            StringBuilder sb = new StringBuilder();
            sb.append(b.aoE(view.getClass().getName()));
            ViewParent parent = view.getParent();
            while (parent != null && (parent instanceof View)) {
                sb.append("|").append(b.aoE(((View) parent).getClass().getName()));
                parent = ((View) parent).getParent();
            }
            String sb2 = sb.toString();
            p.g(sb2, "viewPath.toString()");
            AppMethodBeat.o(220785);
            return sb2;
        }

        public static boolean a(erd erd, ere ere) {
            AppMethodBeat.i(220786);
            p.h(erd, "viewNode");
            p.h(ere, "viewOp");
            Log.i("HABBYGE-MALI.ViewUtil", "viewEqual: " + erd.id + ", " + ere.viewId + ", " + erd.NoL + ", " + ere.NoL);
            if (p.j(erd.id, ere.viewId) || p.j(erd.NoL, ere.NoL)) {
                boolean gp = gp(erd.NoM, ere.NoR);
                AppMethodBeat.o(220786);
                return gp;
            }
            AppMethodBeat.o(220786);
            return false;
        }

        public static boolean gp(String str, String str2) {
            AppMethodBeat.i(220787);
            if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str)) {
                String aoE = b.aoE(str2);
                if (aoE == null) {
                    AppMethodBeat.o(220787);
                    return true;
                }
                p.g(aoE, "HellhoundUtil.getShortNa…zProguard) ?: return true");
                String aoE2 = b.aoE(str);
                if (aoE2 == null) {
                    AppMethodBeat.o(220787);
                    return true;
                }
                p.g(aoE2, "HellhoundUtil.getShortNa…ge(caller) ?: return true");
                Log.i("HABBYGE-MALI.ViewUtil", "isViewCallerOk: " + aoE + ", " + aoE2);
                if (n.nm(aoE, "$")) {
                    if (!n.J(aoE2, aoE, false)) {
                        AppMethodBeat.o(220787);
                        return false;
                    }
                } else if (!p.j(aoE, aoE2)) {
                    AppMethodBeat.o(220787);
                    return false;
                }
            }
            AppMethodBeat.o(220787);
            return true;
        }
    }
}

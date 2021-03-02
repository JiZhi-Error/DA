package com.tencent.mm.plugin.textstatus.j;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.textstatus.a.p;
import com.tencent.mm.plugin.textstatus.g.v;
import com.tencent.mm.plugin.textstatus.g.w;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Random;
import java.util.regex.Pattern;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\fJ\u0010\u0010\r\u001a\u00020\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0004J\u0006\u0010\u000f\u001a\u00020\fJ\u0006\u0010\u0010\u001a\u00020\fJ\u000e\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0013R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0019\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0014"}, hxF = {"Lcom/tencent/mm/plugin/textstatus/util/TextStatusPostUtil;", "", "()V", "TAG", "", "topicPattern", "Ljava/util/regex/Pattern;", "kotlin.jvm.PlatformType", "getTopicPattern", "()Ljava/util/regex/Pattern;", "getBackgroundNameById", "id", "", "getBackgroundNameByName", "name", "getDefaultEditBackground", "getDefaultEditBackgroundId", "printTextStatusPostInfo", "info", "Lcom/tencent/mm/plugin/textstatus/proto/TextStatusPostInfo;", "plugin-textstatus_release"})
public final class e {
    private static final Pattern Ggi = Pattern.compile(p.fvG());
    public static final e Ggj = new e();

    static {
        AppMethodBeat.i(216700);
        AppMethodBeat.o(216700);
    }

    private e() {
    }

    public static Pattern fwK() {
        return Ggi;
    }

    public static int fwL() {
        AppMethodBeat.i(216698);
        kotlin.g.b.p.g(g.aAf(), "MMKernel.account()");
        int nextInt = (new Random((long) a.getUin()).nextInt(12) + ((int) (System.currentTimeMillis() % 12))) % 12;
        Log.i("MicroMsg.TxtStatus.TextStatusPostUtil", "getDefaultEditBackground :".concat(String.valueOf(nextInt)));
        switch (nextInt) {
            case 1:
                AppMethodBeat.o(216698);
                return R.drawable.bv3;
            case 2:
                AppMethodBeat.o(216698);
                return R.drawable.bv7;
            case 3:
                AppMethodBeat.o(216698);
                return R.drawable.bv8;
            case 4:
                AppMethodBeat.o(216698);
                return R.drawable.bv9;
            case 5:
                AppMethodBeat.o(216698);
                return R.drawable.bv_;
            case 6:
                AppMethodBeat.o(216698);
                return R.drawable.bva;
            case 7:
                AppMethodBeat.o(216698);
                return R.drawable.bvb;
            case 8:
                AppMethodBeat.o(216698);
                return R.drawable.bvc;
            case 9:
                AppMethodBeat.o(216698);
                return R.drawable.bvd;
            case 10:
                AppMethodBeat.o(216698);
                return R.drawable.bv4;
            case 11:
                AppMethodBeat.o(216698);
                return R.drawable.bv5;
            case 12:
                AppMethodBeat.o(216698);
                return R.drawable.bv6;
            default:
                AppMethodBeat.o(216698);
                return R.drawable.bv5;
        }
    }

    public static String abN(int i2) {
        if (i2 == R.drawable.bv3) {
            return "text_state_default_image_1";
        }
        if (i2 == R.drawable.bv7) {
            return "text_state_default_image_2";
        }
        if (i2 == R.drawable.bv8) {
            return "text_state_default_image_3";
        }
        if (i2 == R.drawable.bv9) {
            return "text_state_default_image_4";
        }
        if (i2 == R.drawable.bv_) {
            return "text_state_default_image_5";
        }
        if (i2 == R.drawable.bva) {
            return "text_state_default_image_6";
        }
        if (i2 == R.drawable.bvb) {
            return "text_state_default_image_7";
        }
        if (i2 == R.drawable.bvc) {
            return "text_state_default_image_8";
        }
        if (i2 == R.drawable.bvd) {
            return "text_state_default_image_9";
        }
        if (i2 == R.drawable.bv4) {
            return "text_state_default_image_10";
        }
        if (i2 == R.drawable.bv5 || i2 != R.drawable.bv6) {
            return "text_state_default_image_11";
        }
        return "text_state_default_image_12";
    }

    public static int aTr(String str) {
        AppMethodBeat.i(216699);
        if (str != null) {
            switch (str.hashCode()) {
                case -1083859711:
                    if (str.equals("text_state_default_image_10")) {
                        AppMethodBeat.o(216699);
                        return R.drawable.bv4;
                    }
                    break;
                case -1083859710:
                    if (str.equals("text_state_default_image_11")) {
                        AppMethodBeat.o(216699);
                        return R.drawable.bv5;
                    }
                    break;
                case -1083859709:
                    if (str.equals("text_state_default_image_12")) {
                        AppMethodBeat.o(216699);
                        return R.drawable.bv6;
                    }
                    break;
                case 1073415439:
                    if (str.equals("text_state_default_image_1")) {
                        AppMethodBeat.o(216699);
                        return R.drawable.bv3;
                    }
                    break;
                case 1073415440:
                    if (str.equals("text_state_default_image_2")) {
                        AppMethodBeat.o(216699);
                        return R.drawable.bv7;
                    }
                    break;
                case 1073415441:
                    if (str.equals("text_state_default_image_3")) {
                        AppMethodBeat.o(216699);
                        return R.drawable.bv8;
                    }
                    break;
                case 1073415442:
                    if (str.equals("text_state_default_image_4")) {
                        AppMethodBeat.o(216699);
                        return R.drawable.bv9;
                    }
                    break;
                case 1073415443:
                    if (str.equals("text_state_default_image_5")) {
                        AppMethodBeat.o(216699);
                        return R.drawable.bv_;
                    }
                    break;
                case 1073415444:
                    if (str.equals("text_state_default_image_6")) {
                        AppMethodBeat.o(216699);
                        return R.drawable.bva;
                    }
                    break;
                case 1073415445:
                    if (str.equals("text_state_default_image_7")) {
                        AppMethodBeat.o(216699);
                        return R.drawable.bvb;
                    }
                    break;
                case 1073415446:
                    if (str.equals("text_state_default_image_8")) {
                        AppMethodBeat.o(216699);
                        return R.drawable.bvc;
                    }
                    break;
                case 1073415447:
                    if (str.equals("text_state_default_image_9")) {
                        AppMethodBeat.o(216699);
                        return R.drawable.bvd;
                    }
                    break;
            }
        }
        AppMethodBeat.o(216699);
        return R.drawable.bv5;
    }

    public static String c(v vVar) {
        AppMethodBeat.i(258537);
        kotlin.g.b.p.h(vVar, "info");
        String str = "";
        com.tencent.mm.plugin.textstatus.g.g gVar = vVar.GaU;
        if (gVar != null) {
            str = "media_type:" + gVar.Gat + ",longitude:" + gVar.longitude + ",latitude:" + gVar.latitude + ",media_url:" + Util.secPrint(gVar.Gav) + ",media_thumb_url:" + gVar.Gax + ",visibility:" + gVar.visibility + ",create_time:" + gVar.Gaz + ",expire_time:" + gVar.pRN + ",poi_id:" + gVar.GaA + ",option:" + gVar.GaB + ",background_id:" + gVar.GaC + ",media_width:" + gVar.zGN + ",media_height:" + gVar.zGO;
            w wVar = gVar.Gau;
            if (wVar != null) {
                str = str + ",topic_info:[topic_id:" + wVar.GaI + ",source_id:" + wVar.Gao + ",activity_id:" + wVar.Gap + ",name:" + Util.secPrint(wVar.Gal) + ",icon:" + Util.secPrint(wVar.Gam) + ",id:" + wVar.Gan + ",topics:" + wVar.Gbc.size() + ",verify_info:" + Util.secPrint(wVar.Gbf) + ",jump_infos:" + wVar.Gbe.size() + ']';
            }
        }
        String str2 = "TextStatusPostInfo[useDefaultBackground:" + vVar.GaW + ",uploadFilePath:" + vVar.GaX + ",thumbPath:" + vVar.thumbPath + ",excludeUserNames:" + vVar.GaV + ",textStatusExtInfo:[" + str + "]]";
        AppMethodBeat.o(258537);
        return str2;
    }
}

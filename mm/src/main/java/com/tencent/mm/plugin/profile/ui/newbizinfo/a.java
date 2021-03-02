package com.tencent.mm.plugin.profile.ui.newbizinfo;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.profile.ui.newbizinfo.b.b;
import com.tencent.mm.protocal.protobuf.nh;
import com.tencent.mm.protocal.protobuf.ni;
import com.tencent.mm.protocal.protobuf.ou;
import com.tencent.mm.protocal.protobuf.ov;
import com.tencent.mm.protocal.protobuf.ph;
import com.tencent.mm.protocal.protobuf.pz;
import com.tencent.mm.protocal.protobuf.qa;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0004H\u0007J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\u0004H\u0007J\u001a\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0007J\u0016\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u00152\u0006\u0010\u0017\u001a\u00020\u0018H\u0007J\u0010\u0010\u0019\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\rH\u0007J\u0016\u0010\u001b\u001a\u00020\u00132\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u001c0\u0015H\u0007J\u0010\u0010\u001d\u001a\u00020\n2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0011J\f\u0010\u001f\u001a\u00020\r*\u00020\rH\u0002J\f\u0010 \u001a\u00020\u0004*\u00020\u0004H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u001c\u0010\u0005\u001a\n \u0006*\u0004\u0018\u00010\u00040\u00048BX\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006!"}, hxF = {"Lcom/tencent/mm/plugin/profile/ui/newbizinfo/ProfileV2;", "", "()V", "TAG", "", "profileCachePath", "kotlin.jvm.PlatformType", "getProfileCachePath", "()Ljava/lang/String;", "clear", "", "userName", "get", "Lcom/tencent/mm/protocal/protobuf/BizProfileV2Resp;", "indexOf", "Lcom/tencent/mm/plugin/profile/ui/newbizinfo/model/MessageInfo;", "list", "Lcom/tencent/mm/protocal/protobuf/BizMessageList;", FirebaseAnalytics.b.INDEX, "", "processServiceInfoList", "", "Lcom/tencent/mm/protocal/protobuf/BizServiceMenuButton;", "menuInfo", "Lcom/tencent/mm/protocal/protobuf/BizServiceMenu;", "save", "resp", "sizeOf", "Lcom/tencent/mm/protocal/protobuf/BizMessage;", "updatePayStatus", "msgList", "pickAppMsg", "toFileName", "app_release"})
public final class a {
    public static final a BjZ = new a();

    static {
        AppMethodBeat.i(39622);
        AppMethodBeat.o(39622);
    }

    private a() {
    }

    private static String aKx(String str) {
        AppMethodBeat.i(230655);
        StringBuilder sb = new StringBuilder();
        com.tencent.mm.kernel.c.a af = g.af(q.class);
        p.g(af, "MMKernel.service(IBizService::class.java)");
        String aZV = ((q) af).aZV();
        if (!s.YS(aZV)) {
            s.boN(aZV);
        }
        String sb2 = sb.append(aZV).append("profile_resp_").append(MD5Util.getMD5String(str)).toString();
        AppMethodBeat.o(230655);
        return sb2;
    }

    public static final List<qa> a(pz pzVar) {
        boolean z;
        AppMethodBeat.i(39617);
        p.h(pzVar, "menuInfo");
        ArrayList arrayList = new ArrayList();
        LinkedList<qa> linkedList = pzVar.KWS;
        p.g(linkedList, "menuInfo.button_list");
        for (T t : linkedList) {
            switch (t.type) {
                case 0:
                    LinkedList<qa> linkedList2 = t.KWT;
                    p.g(linkedList2, "button.sub_button_list");
                    ArrayList arrayList2 = new ArrayList();
                    for (T t2 : linkedList2) {
                        switch (t2.type) {
                            case 2:
                            case 5:
                            case 6:
                                z = true;
                                break;
                            case 3:
                            case 4:
                            default:
                                z = false;
                                break;
                        }
                        if (z) {
                            arrayList2.add(t2);
                        }
                    }
                    ArrayList arrayList3 = arrayList2;
                    if (!arrayList3.isEmpty()) {
                        qa qaVar = new qa();
                        qaVar.parseFrom(t.toByteArray());
                        qaVar.KWT.clear();
                        qaVar.KWT.addAll(arrayList3);
                        arrayList.add(qaVar);
                        break;
                    } else {
                        break;
                    }
                case 2:
                case 5:
                case 6:
                    arrayList.add(t);
                    break;
            }
        }
        ArrayList arrayList4 = arrayList;
        AppMethodBeat.o(39617);
        return arrayList4;
    }

    public static final void b(ph phVar) {
        LinkedList<ou> linkedList;
        ni niVar;
        LinkedList<nh> linkedList2;
        AppMethodBeat.i(39618);
        p.h(phVar, "resp");
        try {
            String str = phVar.KWe.UserName;
            p.g(str, "resp.AccountInfo.UserName");
            o oVar = new o(aKx(str));
            if (oVar.exists()) {
                oVar.delete();
            }
            String absolutePath = oVar.getAbsolutePath();
            ov ovVar = phVar.KWg;
            if (!(ovVar == null || (linkedList = ovVar.KVw) == null)) {
                for (T t : linkedList) {
                    if (!(t == null || (niVar = t.KVv) == null || (linkedList2 = niVar.KSK) == null)) {
                        for (T t2 : linkedList2) {
                            if (t2.KSE != null) {
                                t2.KSE = null;
                            }
                        }
                    }
                }
            }
            s.C(absolutePath, phVar.toByteArray());
            AppMethodBeat.o(39618);
        } catch (Exception e2) {
            AppMethodBeat.o(39618);
        }
    }

    public static final void clear(String str) {
        AppMethodBeat.i(230656);
        p.h(str, "userName");
        try {
            o oVar = new o(aKx(str));
            if (oVar.exists()) {
                oVar.delete();
            }
            AppMethodBeat.o(230656);
        } catch (Exception e2) {
            AppMethodBeat.o(230656);
        }
    }

    public static final ph aKy(String str) {
        AppMethodBeat.i(39619);
        p.h(str, "userName");
        ph phVar = new ph();
        try {
            byte[] aW = s.aW(aKx(str), 0, -1);
            if (aW != null) {
                phVar.parseFrom(aW);
            }
        } catch (Exception e2) {
            Log.e("MicroMsg.ProfileV2", "readFromFile ex=" + e2.getMessage());
        }
        AppMethodBeat.o(39619);
        return phVar;
    }

    public static final int fT(List<? extends ou> list) {
        int i2;
        LinkedList<nh> linkedList;
        AppMethodBeat.i(39620);
        p.h(list, "list");
        Iterator<T> it = list.iterator();
        int i3 = 0;
        while (it.hasNext()) {
            ni niVar = it.next().KVv;
            if (niVar == null || (linkedList = niVar.KSK) == null) {
                i2 = 0;
            } else {
                i2 = linkedList.size();
            }
            i3 = i2 + i3;
        }
        AppMethodBeat.o(39620);
        return i3;
    }

    public static final b a(ov ovVar, int i2) {
        int i3;
        AppMethodBeat.i(39621);
        p.h(ovVar, "list");
        LinkedList<ou> linkedList = ovVar.KVw;
        p.g(linkedList, "list.Msg");
        int i4 = 0;
        for (T t : linkedList) {
            if (t.KVv == null) {
                i3 = i4;
            } else if (i2 < t.KVv.KSK.size() + i4) {
                nh nhVar = t.KVv.KSK.get(i2 - i4);
                b bVar = new b();
                bVar.Bkr = String.valueOf(t.KVv.KSJ.KSf);
                bVar.coverImgUrl = nhVar.KSl;
                bVar.Bko = nhVar.KSj;
                bVar.Bkp = nhVar.KSq;
                bVar.type = nhVar.iAb;
                bVar.hXs = t.KVq.LmE;
                bVar.title = nhVar.Title;
                bVar.Bkq = nhVar.KSh;
                bVar.Bks = String.valueOf(i2 - i4);
                AppMethodBeat.o(39621);
                return bVar;
            } else {
                i3 = t.KVv.KSK.size() + i4;
            }
            i4 = i3;
        }
        AppMethodBeat.o(39621);
        return null;
    }

    public static void a(ov ovVar) {
        LinkedList<ou> linkedList;
        ni niVar;
        LinkedList<nh> linkedList2;
        AppMethodBeat.i(169906);
        if (ovVar == null || (linkedList = ovVar.KVw) == null) {
            AppMethodBeat.o(169906);
            return;
        }
        for (T t : linkedList) {
            if (!(t == null || (niVar = t.KVv) == null || (linkedList2 = niVar.KSK) == null)) {
                for (T t2 : linkedList2) {
                    if (t2 != null && t2.KSF == 1 && !Util.isNullOrNil(t2.KSj)) {
                        com.tencent.mm.plugin.brandservice.b.a aVar = com.tencent.mm.plugin.brandservice.b.a.pmT;
                        String str = t2.KSj;
                        p.g(str, "detail.ContentUrl");
                        com.tencent.mm.plugin.brandservice.b.a.aH(str, t2.izV == 1);
                    }
                }
            }
        }
        AppMethodBeat.o(169906);
    }
}

package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.d;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.plugin.finder.model.w;
import com.tencent.mm.protocal.protobuf.FinderMedia;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.ard;
import com.tencent.mm.protocal.protobuf.awe;
import com.tencent.mm.sdk.platformtools.MD5Util;
import java.util.LinkedList;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006J\u0016\u0010\b\u001a\u00020\u00042\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u0006J\n\u0010\n\u001a\u00020\u0004*\u00020\u0007J\n\u0010\u000b\u001a\u00020\u0004*\u00020\u0007J\n\u0010\f\u001a\u00020\u0004*\u00020\u0007¨\u0006\r"}, hxF = {"Lcom/tencent/mm/plugin/finder/cgi/CgiUtil;", "", "()V", "collectCgiInfo", "", "list", "", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "collectRVFeedInfo", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "debugDesc", "debugMediaId", "debugType", "plugin-finder_release"})
public final class al {
    public static final al tuv = new al();

    static {
        AppMethodBeat.i(165182);
        AppMethodBeat.o(165182);
    }

    private al() {
    }

    public static String a(FinderObject finderObject) {
        String str;
        LinkedList<FinderMedia> linkedList;
        FinderMedia finderMedia;
        String str2;
        AppMethodBeat.i(242318);
        p.h(finderObject, "$this$debugMediaId");
        FinderObjectDesc finderObjectDesc = finderObject.objectDesc;
        if (finderObjectDesc == null || (linkedList = finderObjectDesc.media) == null || (finderMedia = (FinderMedia) j.L(linkedList, 0)) == null || (str2 = finderMedia.url) == null || (str = MD5Util.getMD5String(str2)) == null) {
            str = "";
        }
        AppMethodBeat.o(242318);
        return str;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x003c, code lost:
        if (r0 == null) goto L_0x003e;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String b(com.tencent.mm.protocal.protobuf.FinderObject r4) {
        /*
            r3 = 242319(0x3b28f, float:3.39561E-40)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r3)
            java.lang.String r0 = "$this$debugDesc"
            kotlin.g.b.p.h(r4, r0)
            com.tencent.mm.protocal.protobuf.FinderObjectDesc r0 = r4.objectDesc
            if (r0 == 0) goto L_0x003e
            java.lang.String r0 = r0.description
            if (r0 == 0) goto L_0x003e
            java.lang.String r1 = "it"
            kotlin.g.b.p.g(r0, r1)
            int r1 = r0.length()
            r2 = 7
            int r1 = java.lang.Math.min(r1, r2)
            if (r0 != 0) goto L_0x0031
            kotlin.t r0 = new kotlin.t
            java.lang.String r1 = "null cannot be cast to non-null type java.lang.String"
            r0.<init>(r1)
            com.tencent.matrix.trace.core.AppMethodBeat.o(r3)
            throw r0
        L_0x0031:
            r2 = 0
            java.lang.String r0 = r0.substring(r2, r1)
            java.lang.String r1 = "(this as java.lang.Strin…ing(startIndex, endIndex)"
            kotlin.g.b.p.g(r0, r1)
            if (r0 != 0) goto L_0x0041
        L_0x003e:
            java.lang.String r0 = ""
        L_0x0041:
            com.tencent.matrix.trace.core.AppMethodBeat.o(r3)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.cgi.al.b(com.tencent.mm.protocal.protobuf.FinderObject):java.lang.String");
    }

    private static String c(FinderObject finderObject) {
        int i2;
        int i3;
        LinkedList<FinderMedia> linkedList;
        LinkedList<FinderMedia> linkedList2;
        FinderMedia finderMedia;
        int i4 = -1;
        AppMethodBeat.i(242320);
        p.h(finderObject, "$this$debugType");
        FinderObjectDesc finderObjectDesc = finderObject.objectDesc;
        if (finderObjectDesc != null) {
            i2 = finderObjectDesc.mediaType;
        } else {
            i2 = -1;
        }
        FinderObjectDesc finderObjectDesc2 = finderObject.objectDesc;
        if (!(finderObjectDesc2 == null || (linkedList2 = finderObjectDesc2.media) == null || (finderMedia = (FinderMedia) j.L(linkedList2, 0)) == null)) {
            i4 = finderMedia.mediaType;
        }
        FinderObjectDesc finderObjectDesc3 = finderObject.objectDesc;
        if (finderObjectDesc3 == null || (linkedList = finderObjectDesc3.media) == null) {
            i3 = 0;
        } else {
            i3 = linkedList.size();
        }
        String str = "t:" + i2 + ',' + i4 + ";s:" + i3;
        AppMethodBeat.o(242320);
        return str;
    }

    public static String dP(List<? extends bo> list) {
        AppMethodBeat.i(242321);
        if (list == null) {
            AppMethodBeat.o(242321);
            return BuildConfig.COMMAND;
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("count:" + list.size() + " \n");
        for (T t : list) {
            if (t instanceof BaseFinderFeed) {
                T t2 = t;
                if (t2 instanceof w) {
                    StringBuilder append = new StringBuilder("id:").append(t2.feedObject.getId()).append(" nick:").append(t2.feedObject.getNickName()).append(" livestate:");
                    awe liveInfo = t2.feedObject.getLiveInfo();
                    stringBuffer.append(append.append(liveInfo != null ? Integer.valueOf(liveInfo.liveStatus) : null).append(" \n").toString());
                } else {
                    stringBuffer.append("id:" + t2.feedObject.getId() + " nick:" + t2.feedObject.getNickName() + " \n");
                }
            } else {
                stringBuffer.append(t.toString() + "\n");
            }
        }
        String stringBuffer2 = stringBuffer.toString();
        p.g(stringBuffer2, "stringBuffer.toString()");
        AppMethodBeat.o(242321);
        return stringBuffer2;
    }

    public static String dQ(List<? extends FinderObject> list) {
        AppMethodBeat.i(165181);
        if (list == null) {
            AppMethodBeat.o(165181);
            return BuildConfig.COMMAND;
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("onCgiBack: count:" + list.size());
        StringBuffer stringBuffer2 = new StringBuffer();
        int i2 = 0;
        for (T t : list) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                j.hxH();
            }
            T t2 = t;
            String a2 = a(t2);
            String b2 = b(t2);
            String c2 = c(t2);
            ard ard = t2.foldedLayout;
            if (ard != null) {
                if (ard.LCW.size() > 0) {
                    stringBuffer2.append("PARENT_ID:id:" + d.zs(t2.id));
                    stringBuffer2.append("FL>>>");
                }
                LinkedList<FinderObject> linkedList = ard.LCW;
                if (linkedList != null) {
                    for (T t3 : linkedList) {
                        p.g(t3, "foldedObj");
                        stringBuffer2.append("#[id:" + d.zs(t3.id) + ",md:" + a(t3) + ",d:" + b(t3) + "] " + c(t3));
                    }
                }
                if (ard.LCW.size() > 0) {
                    stringBuffer2.append("<<FL\n");
                }
            }
            stringBuffer.append(";[*" + i2 + " id:" + d.zs(t2.id) + ",md:" + a2 + ",d:" + b2 + "] " + c2);
            i2 = i3;
        }
        if (stringBuffer2.length() > 0) {
            stringBuffer.append("\n" + stringBuffer2);
        }
        String stringBuffer3 = stringBuffer.toString();
        p.g(stringBuffer3, "buf.toString()");
        AppMethodBeat.o(165181);
        return stringBuffer3;
    }
}

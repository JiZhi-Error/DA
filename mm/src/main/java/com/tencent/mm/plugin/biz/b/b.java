package com.tencent.mm.plugin.biz.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.ag;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bp;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.x;
import com.tencent.mm.storage.z;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004J\"\u0010\b\u001a\u00020\t2\u0018\u0010\n\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u000bH\u0002J,\u0010\f\u001a\u00020\r2\u0018\u0010\n\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J,\u0010\f\u001a\u00020\r2\u0018\u0010\n\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u000b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0010"}, hxF = {"Lcom/tencent/mm/plugin/biz/util/BizPayAlbumLogic;", "", "()V", "TAG", "", "getAlbumInfo", "Lcom/tencent/mm/storage/BizPayAlbum;", "msgContent", "isDataValid", "", "values", "", "onBizPayAlbumNotify", "", "addMsgInfo", "Lcom/tencent/mm/modelbase/IMessageExtension$AddMsgInfo;", "plugin-biz_release"})
public final class b {
    public static final b pfn = new b();

    static {
        AppMethodBeat.i(212455);
        AppMethodBeat.o(212455);
    }

    private b() {
    }

    public static void g(Map<String, String> map, String str) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        AppMethodBeat.i(212453);
        if (str == null || map == null) {
            Log.w("MicroMsg.BizPayAlbumLogic", "onBizPayAlbumNotify data invalid");
            AppMethodBeat.o(212453);
        } else if (!g.aAc()) {
            Log.i("MicroMsg.BizPayAlbumLogic", "onBizPayAlbumNotify acc not ready");
            AppMethodBeat.o(212453);
        } else {
            Log.i("MicroMsg.BizPayAlbumLogic", "onBizPayAlbumNotify msgContent=".concat(String.valueOf(str)));
            if (map == null) {
                z7 = false;
            } else {
                String str2 = map.get(".sysmsg.BizNotification.BizAccount.UserName");
                if (str2 == null || n.aL(str2)) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    z7 = false;
                } else {
                    String str3 = map.get(".sysmsg.BizNotification.BizAccount.NickName");
                    if (str3 == null || n.aL(str3)) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (z2) {
                        z7 = false;
                    } else {
                        String str4 = map.get(".sysmsg.BizNotification.BizAccount.HeadImgUrl");
                        if (str4 == null || n.aL(str4)) {
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                        if (z3) {
                            z7 = false;
                        } else {
                            String str5 = map.get(".sysmsg.BizNotification.plain");
                            if (str5 == null || n.aL(str5)) {
                                z4 = true;
                            } else {
                                z4 = false;
                            }
                            if (z4) {
                                z7 = false;
                            } else {
                                String str6 = map.get(".sysmsg.BizNotification.AppMsg.Title");
                                if (str6 == null || n.aL(str6)) {
                                    z5 = true;
                                } else {
                                    z5 = false;
                                }
                                if (z5) {
                                    z7 = false;
                                } else {
                                    String str7 = map.get(".sysmsg.BizNotification.AppMsg.WebUrl");
                                    if (str7 == null || n.aL(str7)) {
                                        z6 = true;
                                    } else {
                                        z6 = false;
                                    }
                                    z7 = !z6;
                                }
                            }
                        }
                    }
                }
            }
            if (!z7) {
                Log.i("MicroMsg.BizPayAlbumLogic", "onBizPayAlbumNotify data invalid");
                AppMethodBeat.o(212453);
                return;
            }
            z zVar = new z();
            zVar.field_msgId = ag.bap().gBo();
            zVar.field_msgSvrId = 0;
            zVar.field_type = 10100;
            zVar.field_talker = map.get(".sysmsg.BizNotification.BizAccount.UserName");
            zVar.field_talkerId = 0;
            zVar.field_createTime = bp.aVP();
            zVar.nc(1);
            zVar.field_status = 3;
            zVar.field_content = str;
            Log.i("MicroMsg.BizPayAlbumLogic", "onBizPayAlbumNotify result: %b, username: %s, msgid=" + zVar.field_msgId, Boolean.valueOf(ag.bap().B(zVar)), zVar.field_talker);
            AppMethodBeat.o(212453);
        }
    }

    public static x ahh(String str) {
        Map<String, String> map = null;
        AppMethodBeat.i(212454);
        x xVar = new x();
        String str2 = str;
        if (str2 == null || n.aL(str2)) {
            AppMethodBeat.o(212454);
            return xVar;
        }
        int a2 = n.a((CharSequence) str, "<sysmsg", 0, false, 6);
        if (a2 != -1) {
            if (str == null) {
                t tVar = new t("null cannot be cast to non-null type java.lang.String");
                AppMethodBeat.o(212454);
                throw tVar;
            }
            String substring = str.substring(a2);
            p.g(substring, "(this as java.lang.String).substring(startIndex)");
            map = XmlParser.parseXml(substring, "sysmsg", null);
        }
        if (map == null) {
            Log.e("MicroMsg.BizPayAlbumLogic", "XmlParser values is null, msgContent %s", str);
            AppMethodBeat.o(212454);
            return xVar;
        }
        String str3 = map.get(".sysmsg.BizNotification.BizAccount.UserName");
        if (str3 == null) {
            str3 = "";
        }
        p.h(str3, "<set-?>");
        xVar.userName = str3;
        String str4 = map.get(".sysmsg.BizNotification.BizAccount.NickName");
        if (str4 == null) {
            str4 = "";
        }
        p.h(str4, "<set-?>");
        xVar.nickName = str4;
        String str5 = map.get(".sysmsg.BizNotification.plain");
        if (str5 == null) {
            str5 = "";
        }
        p.h(str5, "<set-?>");
        xVar.iAq = str5;
        String str6 = map.get(".sysmsg.BizNotification.BizAccount.HeadImgUrl");
        if (str6 == null) {
            str6 = "";
        }
        p.h(str6, "<set-?>");
        xVar.iAR = str6;
        String str7 = map.get(".sysmsg.BizNotification.AppMsg.Title");
        if (str7 == null) {
            str7 = "";
        }
        p.h(str7, "<set-?>");
        xVar.title = str7;
        String str8 = map.get(".sysmsg.BizNotification.AppMsg.WebUrl");
        if (str8 == null) {
            str8 = "";
        }
        p.h(str8, "<set-?>");
        xVar.lDS = str8;
        AppMethodBeat.o(212454);
        return xVar;
    }
}

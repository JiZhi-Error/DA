package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.webview.model.t;
import com.tencent.mm.plugin.webview.model.u;
import com.tencent.mm.plugin.webview.model.v;
import com.tencent.mm.plugin.webview.model.w;
import com.tencent.mm.plugin.webview.stub.WebViewStubTempUI;
import com.tencent.mm.plugin.webview.stub.f;
import com.tencent.mm.protocal.protobuf.cdw;
import com.tencent.mm.protocal.protobuf.cdx;
import com.tencent.mm.protocal.protobuf.cdy;
import com.tencent.mm.protocal.protobuf.cef;
import com.tencent.mm.protocal.protobuf.ceg;
import com.tencent.mm.protocal.protobuf.cei;
import com.tencent.mm.protocal.protobuf.cej;
import com.tencent.mm.protocal.protobuf.cel;
import com.tencent.mm.protocal.protobuf.cey;
import com.tencent.mm.protocal.protobuf.epn;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class a implements i {
    private f ISw;
    private final HashMap<String, d> IVk = new HashMap<>();
    final int IXV;
    private final HashMap<String, cdw> Jsn = new HashMap<>();
    private final HashMap<String, String> Jso = new HashMap<>();
    private Context context;

    public interface b {
        int fZu();
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.jsapi.a$a  reason: collision with other inner class name */
    public interface AbstractC1996a {
        void a(EnumC1997a aVar, String str, LinkedList<epn> linkedList, int i2, int i3);

        void baP(String str);

        /* renamed from: com.tencent.mm.plugin.webview.ui.tools.jsapi.a$a$a  reason: collision with other inner class name */
        public enum EnumC1997a {
            RET_OK(0),
            RET_FAIL(-1),
            RET_REJECT(-2),
            RET_ACCESS_DENIED(-3);
            
            private int code;

            public static EnumC1997a valueOf(String str) {
                AppMethodBeat.i(81009);
                EnumC1997a aVar = (EnumC1997a) Enum.valueOf(EnumC1997a.class, str);
                AppMethodBeat.o(81009);
                return aVar;
            }

            static {
                AppMethodBeat.i(81010);
                AppMethodBeat.o(81010);
            }

            private EnumC1997a(int i2) {
                this.code = i2;
            }

            public final int getCode() {
                return this.code;
            }
        }
    }

    public static abstract class c implements AbstractC1996a {
        public boolean Jsx = true;

        public boolean ghm() {
            return this.Jsx;
        }

        public final void zn(boolean z) {
            this.Jsx = z;
        }

        @Override // com.tencent.mm.plugin.webview.ui.tools.jsapi.a.AbstractC1996a
        public void baP(String str) {
        }
    }

    public final String baN(String str) {
        AppMethodBeat.i(81011);
        if (str == null) {
            AppMethodBeat.o(81011);
            return null;
        }
        String str2 = this.Jso.get(str);
        if (Util.isNullOrNil(str2)) {
            String aYy = aYy(str);
            Log.i("MicroMsg.webview.JSVerifyHelper", "appid = %s, url = %s, drophash url = %s", str2, str, aYy);
            if (!Util.isNullOrNil(aYy)) {
                str2 = this.Jso.get(aYy);
            }
        }
        AppMethodBeat.o(81011);
        return str2;
    }

    public final d baO(String str) {
        AppMethodBeat.i(81012);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(81012);
            return null;
        }
        d dVar = this.IVk.get(str);
        if (dVar == null) {
            dVar = this.IVk.get(aYy(str));
        }
        AppMethodBeat.o(81012);
        return dVar;
    }

    public a(int i2) {
        AppMethodBeat.i(81013);
        this.IXV = i2;
        AppMethodBeat.o(81013);
    }

    /* access modifiers changed from: package-private */
    public final void a(Context context2, f fVar) {
        this.context = context2;
        this.ISw = fVar;
    }

    @Override // com.tencent.mm.ak.i
    public final void onSceneEnd(int i2, int i3, String str, q qVar) {
        cej cej;
        int i4;
        cef cef;
        AppMethodBeat.i(81014);
        Log.i("MicroMsg.webview.JSVerifyHelper", "JSVerifyHelper onSceneEnd: type[%d], errType[%s], errCode[%s], errMsg[%s]", Integer.valueOf(qVar.getType()), Integer.valueOf(i2), Integer.valueOf(i3), str);
        if (!(qVar instanceof b)) {
            Log.i("MicroMsg.webview.JSVerifyHelper", "JSVerifyHelper onSceneEnd: net scene type mismatched, return");
            AppMethodBeat.o(81014);
        } else if (((b) qVar).fZu() != this.IXV) {
            Log.i("MicroMsg.webview.JSVerifyHelper", "JSVerifyHelper onSceneEnd: this.binderId = %d, incoming binderId = %d, not equal, return", Integer.valueOf(this.IXV), Integer.valueOf(((b) qVar).fZu()));
            AppMethodBeat.o(81014);
        } else {
            int type = qVar.getType();
            if (type == 1093) {
                g.azz().b(1093, this);
                u uVar = (u) qVar;
                if (uVar == null) {
                    Log.e("MicroMsg.webview.JSVerifyHelper", "");
                    AppMethodBeat.o(81014);
                } else if (uVar.IXT == null) {
                    Log.e("MicroMsg.webview.JSVerifyHelper", "dealJSAPIPreVerify, VerifyCallback is null");
                    AppMethodBeat.o(81014);
                } else {
                    int i5 = 0;
                    if (!(uVar.gcy() == null || uVar.gcy().Mjz == null)) {
                        i5 = uVar.gcy().Mjz.dIZ;
                    }
                    if (i2 == 0 && i3 == 0) {
                        ceg gcy = uVar.gcy();
                        if (uVar.rr == null) {
                            cef = null;
                        } else {
                            cef = (cef) uVar.rr.iLK.iLR;
                        }
                        if (gcy == null || Util.isNullOrNil(uVar.nKc) || cef == null || Util.isNullOrNil(cef.dNI)) {
                            Object[] objArr = new Object[3];
                            objArr[0] = Boolean.valueOf(gcy == null);
                            objArr[1] = Boolean.valueOf(Util.isNullOrNil(uVar.nKc));
                            objArr[2] = Boolean.valueOf(cef == null);
                            Log.e("MicroMsg.webview.JSVerifyHelper", "something null %b, %b, %b", objArr);
                            uVar.IXT.a(AbstractC1996a.EnumC1997a.RET_FAIL, null, null, i3, i5);
                            AppMethodBeat.o(81014);
                        } else if (gcy.Mjz == null) {
                            Log.e("MicroMsg.webview.JSVerifyHelper", "jsapi_baseresponse null");
                            uVar.IXT.a(AbstractC1996a.EnumC1997a.RET_FAIL, null, null, i3, i5);
                            AppMethodBeat.o(81014);
                        } else if (gcy.Mjz.dIZ != 0) {
                            Log.e("MicroMsg.webview.JSVerifyHelper", "jsapi baseresponse errcode fail : %d, errmsg = %s", Integer.valueOf(gcy.Mjz.dIZ), gcy.Mjz.dJa);
                            uVar.IXT.a(AbstractC1996a.EnumC1997a.RET_FAIL, gcy.Mjz.dJa, null, i3, i5);
                            AppMethodBeat.o(81014);
                        } else {
                            uVar.IXT.baP(gcy.MjR);
                            this.Jso.put(aYy(cef.url), cef.dNI);
                            d dVar = new d(cef.dNI, gcy);
                            this.IVk.put(aYy(cef.url), dVar);
                            this.IVk.put(aYy(cef.Mjy), dVar);
                            uVar.IXT.a(AbstractC1996a.EnumC1997a.RET_OK, null, gcy.MjP, i3, i5);
                            Log.d("MicroMsg.webview.JSVerifyHelper", "dealJSAPIPreVerify url is %s", cef.url);
                            AppMethodBeat.o(81014);
                        }
                    } else if (i2 == 4) {
                        uVar.IXT.a(AbstractC1996a.EnumC1997a.RET_FAIL, i3 + "_" + str, null, i3, i5);
                        AppMethodBeat.o(81014);
                    } else {
                        uVar.IXT.a(AbstractC1996a.EnumC1997a.RET_FAIL, null, null, i3, i5);
                        AppMethodBeat.o(81014);
                    }
                }
            } else if (type == 1095) {
                g.azz().b(1095, this);
                a(i2, i3, str, (t) qVar);
                AppMethodBeat.o(81014);
            } else if (type == 1094) {
                g.azz().b(1094, this);
                v vVar = (v) qVar;
                if (vVar == null) {
                    Log.e("MicroMsg.webview.JSVerifyHelper", "dealJSAPIRealtimeVerify scene is null");
                    AppMethodBeat.o(81014);
                    return;
                }
                h.INSTANCE.idkeyStat(157, 24, 1, false);
                if (vVar.gcz() == null || vVar.gcz().Mjz == null) {
                    i4 = 0;
                } else {
                    i4 = vVar.gcz().Mjz.dIZ;
                }
                if (i2 == 0 && i3 == 0) {
                    cei gcz = vVar.gcz();
                    if (gcz == null || gcz.Mjz == null) {
                        Log.e("MicroMsg.webview.JSVerifyHelper", "dealJSAPIRealtimeVerify resp is null");
                        vVar.IXT.a(AbstractC1996a.EnumC1997a.RET_FAIL, null, null, i3, i4);
                        AppMethodBeat.o(81014);
                    } else if (gcz.Mjz.dIZ != 0) {
                        Log.e("MicroMsg.webview.JSVerifyHelper", "realtime jsapi_baseresponse %s, %s", Integer.valueOf(gcz.Mjz.dIZ), gcz.Mjz.dJa);
                        vVar.IXT.a(AbstractC1996a.EnumC1997a.RET_FAIL, gcz.Mjz.dJa, null, i3, i4);
                        AppMethodBeat.o(81014);
                    } else {
                        epn epn = gcz.MjT;
                        if (epn == null) {
                            Log.e("MicroMsg.webview.JSVerifyHelper", "realtime not ok, vInfo is null");
                            vVar.IXT.a(AbstractC1996a.EnumC1997a.RET_FAIL, "verifyFail", null, i3, i4);
                            AppMethodBeat.o(81014);
                        } else if (epn.Nnk != 1) {
                            Log.e("MicroMsg.webview.JSVerifyHelper", "realtime not ok, %s", Integer.valueOf(epn.Nnk));
                            vVar.IXT.a(AbstractC1996a.EnumC1997a.RET_FAIL, "verifyFail", null, i3, i4);
                            AppMethodBeat.o(81014);
                        } else {
                            vVar.IXT.a(AbstractC1996a.EnumC1997a.RET_OK, null, null, i3, i4);
                            AppMethodBeat.o(81014);
                        }
                    }
                } else {
                    Log.e("MicroMsg.webview.JSVerifyHelper", "dealJSAPIRealtimeVerify netscene error", Integer.valueOf(i2), Integer.valueOf(i3));
                    h.INSTANCE.idkeyStat(157, 25, 1, false);
                    if (i2 == 4) {
                        vVar.IXT.a(AbstractC1996a.EnumC1997a.RET_FAIL, i3 + "_" + str, null, i3, i4);
                        AppMethodBeat.o(81014);
                        return;
                    }
                    vVar.IXT.a(AbstractC1996a.EnumC1997a.RET_FAIL, null, null, i3, i4);
                    AppMethodBeat.o(81014);
                }
            } else {
                if (type == 1096) {
                    g.azz().b(1096, this);
                    w wVar = (w) qVar;
                    if (wVar.rr == null) {
                        cej = null;
                    } else {
                        cej = (cej) wVar.rr.iLK.iLR;
                    }
                    if (cej == null) {
                        Log.e("MicroMsg.webview.JSVerifyHelper", "JSAPISetOAuth, setAuthReq is null");
                        AppMethodBeat.o(81014);
                        return;
                    } else if (i2 != 0 || i3 != 0) {
                        Log.e("MicroMsg.webview.JSVerifyHelper", "JSAPISetOAuth, errType[%s], errCode[%s], %s", Integer.valueOf(i2), Integer.valueOf(i3), cej.Mjs);
                        AppMethodBeat.o(81014);
                        return;
                    } else if (com.tencent.mm.protocal.c.bgb(Util.nullAsNil(cej.Mjs)) == null) {
                        Log.e("MicroMsg.webview.JSVerifyHelper", "JSAPISetOAuth, errType[%s], errCode[%s]", Integer.valueOf(i2), Integer.valueOf(i3));
                        AppMethodBeat.o(81014);
                        return;
                    } else {
                        cdw cdw = ((w) qVar).IXW;
                        cdw.KLv = 1;
                        this.Jsn.put(cej.Mjs + cej.url, cdw);
                    }
                }
                AppMethodBeat.o(81014);
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:49:0x029e  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x02a9  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x02d9  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x02e0  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x030d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(com.tencent.mm.protocal.JsapiPermissionWrapper r18, java.lang.String r19, java.lang.String r20, int r21, com.tencent.mm.plugin.webview.d.n r22, com.tencent.mm.plugin.webview.ui.tools.jsapi.a.AbstractC1996a r23) {
        /*
        // Method dump skipped, instructions count: 808
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.webview.ui.tools.jsapi.a.a(com.tencent.mm.protocal.JsapiPermissionWrapper, java.lang.String, java.lang.String, int, com.tencent.mm.plugin.webview.d.n, com.tencent.mm.plugin.webview.ui.tools.jsapi.a$a):void");
    }

    private void a(int i2, final int i3, String str, final t tVar) {
        AppMethodBeat.i(81016);
        if (tVar == null) {
            Log.e("MicroMsg.webview.JSVerifyHelper", "dealJSAPIAuth scene is null");
            AppMethodBeat.o(81016);
            return;
        }
        int i4 = 0;
        if (!(tVar.gcx() == null || tVar.gcx().Mjz == null)) {
            i4 = tVar.gcx().Mjz.dIZ;
        }
        if (i2 != 0 || i3 != 0) {
            Log.e("MicroMsg.webview.JSVerifyHelper", "dealJSAPIAuth netscene error, %s, %s", Integer.valueOf(i2), Integer.valueOf(i3));
            if (i2 == 4) {
                tVar.IXT.a(AbstractC1996a.EnumC1997a.RET_FAIL, str, null, i3, i4);
                AppMethodBeat.o(81016);
                return;
            }
            tVar.IXT.a(AbstractC1996a.EnumC1997a.RET_FAIL, null, null, i3, i4);
            AppMethodBeat.o(81016);
        } else if (Util.isNullOrNil(tVar.IXU)) {
            Log.e("MicroMsg.webview.JSVerifyHelper", "scene.jsapi is null or nil.");
            tVar.IXT.a(AbstractC1996a.EnumC1997a.RET_FAIL, null, null, i3, i4);
            AppMethodBeat.o(81016);
        } else {
            cdy gcx = tVar.gcx();
            if (gcx == null || gcx.Mjz == null) {
                Log.e("MicroMsg.webview.JSVerifyHelper", "dealJSAPIAuth resp is null");
                tVar.IXT.a(AbstractC1996a.EnumC1997a.RET_FAIL, null, null, i3, i4);
                AppMethodBeat.o(81016);
            } else if (gcx.Mjz.dIZ != 0) {
                Log.e("MicroMsg.webview.JSVerifyHelper", "auth jsapi_baseresponse %s, %s", Integer.valueOf(gcx.Mjz.dIZ), gcx.Mjz.dJa);
                tVar.IXT.a(AbstractC1996a.EnumC1997a.RET_FAIL, gcx.Mjz.dJa, null, i3, i4);
                AppMethodBeat.o(81016);
            } else {
                int i5 = tVar.gcw() == null ? 0 : tVar.gcw().Mjx;
                Log.i("MicroMsg.webview.JSVerifyHelper", "signature flag : %d.", Integer.valueOf(i5));
                if (i5 == 1) {
                    if (gcx.MjC == null) {
                        Log.e("MicroMsg.webview.JSVerifyHelper", "dealJSAPI scope_auth_info is null.");
                        tVar.IXT.a(AbstractC1996a.EnumC1997a.RET_FAIL, null, null, i3, i4);
                        AppMethodBeat.o(81016);
                        return;
                    }
                    Iterator<cey> it = gcx.MjC.iterator();
                    while (it.hasNext()) {
                        cey next = it.next();
                        if (next.Mkw == null) {
                            Log.e("MicroMsg.webview.JSVerifyHelper", "authInfo.apiname is null.");
                        } else {
                            Iterator<String> it2 = next.Mkw.iterator();
                            while (it2.hasNext()) {
                                String next2 = it2.next();
                                if (!Util.isNullOrNil(next2)) {
                                    cdw cdw = new cdw();
                                    cdw.Mjs = next2;
                                    cdw.KLv = next.Mkv;
                                    cdw.Mjt = next.CYp;
                                    this.Jsn.put(cdw.Mjs + tVar.url, cdw);
                                }
                            }
                        }
                    }
                } else if (gcx.MjA == null) {
                    Log.e("MicroMsg.webview.JSVerifyHelper", "dealJSAPIAuth auth_info is null");
                    tVar.IXT.a(AbstractC1996a.EnumC1997a.RET_FAIL, "nullAuthInfo", null, i3, i4);
                    AppMethodBeat.o(81016);
                    return;
                } else {
                    Iterator<cdw> it3 = gcx.MjA.iterator();
                    while (it3.hasNext()) {
                        cdw next3 = it3.next();
                        if (!Util.isNullOrNil(next3.Mjs)) {
                            this.Jsn.put(next3.Mjs + tVar.url, next3);
                        }
                    }
                }
                final cdw cdw2 = this.Jsn.get(tVar.IXU + tVar.url);
                if (cdw2 == null) {
                    Log.e("MicroMsg.webview.JSVerifyHelper", "The JSAPIAuthInfo is null. (jsapi : %s , url : %s)", tVar.IXU, tVar.url);
                    tVar.IXT.a(AbstractC1996a.EnumC1997a.RET_FAIL, null, null, i3, i4);
                    AppMethodBeat.o(81016);
                } else if (cdw2.KLv == 1) {
                    tVar.IXT.a(AbstractC1996a.EnumC1997a.RET_OK, null, null, i3, i4);
                    AppMethodBeat.o(81016);
                } else if (this.context == null) {
                    Log.e("MicroMsg.webview.JSVerifyHelper", "JSVerify context not activity");
                    a(tVar, i3, cdw2);
                    AppMethodBeat.o(81016);
                } else {
                    WebViewStubTempUI.a(this.context, this.ISw, Util.nullAsNil(cdw2.Mjt), "", this.context.getString(R.string.e_5), this.context.getString(R.string.e_4), new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.plugin.webview.ui.tools.jsapi.a.AnonymousClass1 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            AppMethodBeat.i(81006);
                            Log.i("MicroMsg.webview.JSVerifyHelper", "showDlgForJSVerify click ok");
                            a.this.a(tVar, i3, cdw2);
                            AppMethodBeat.o(81006);
                        }
                    }, new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.plugin.webview.ui.tools.jsapi.a.AnonymousClass2 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            AppMethodBeat.i(81007);
                            Log.i("MicroMsg.webview.JSVerifyHelper", "showDlgForJSVerify click cancel");
                            tVar.IXT.a(AbstractC1996a.EnumC1997a.RET_REJECT, "cancel", null, i3, tVar.gcx().Mjz.dIZ);
                            AppMethodBeat.o(81007);
                        }
                    });
                    AppMethodBeat.o(81016);
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(t tVar, int i2, cdw cdw) {
        AppMethodBeat.i(81017);
        cdx gcw = tVar.gcw();
        cdy gcx = tVar.gcx();
        if (gcw == null) {
            Log.e("MicroMsg.webview.JSVerifyHelper", "authReq is null");
            tVar.IXT.a(AbstractC1996a.EnumC1997a.RET_FAIL, null, null, i2, tVar.gcx().Mjz.dIZ);
            AppMethodBeat.o(81017);
        } else if (gcx == null) {
            Log.e("MicroMsg.webview.JSVerifyHelper", "authResp is null");
            tVar.IXT.a(AbstractC1996a.EnumC1997a.RET_FAIL, null, null, i2, tVar.gcx().Mjz.dIZ);
            AppMethodBeat.o(81017);
        } else {
            g.azz().a(1096, this);
            LinkedList<cey> linkedList = gcx.MjC;
            if (linkedList != null) {
                Iterator<cey> it = linkedList.iterator();
                while (it.hasNext()) {
                    cey next = it.next();
                    if (next != null) {
                        Log.i("MicroMsg.webview.JSVerifyHelper", "apiname = %s, scope = %s, scope desc = %s, status = %d, now jsapi name = %s", next.Mkw, next.scope, next.CYp, Integer.valueOf(next.Mkv), gcw.Mjs);
                        next.Mkv = 1;
                    }
                }
                Iterator<cey> it2 = linkedList.iterator();
                while (it2.hasNext()) {
                    cey next2 = it2.next();
                    if (next2 != null) {
                        Log.i("MicroMsg.webview.JSVerifyHelper", "apiname = %s, scope = %s, scope desc = %s, status = %d, now jsapi name = %s", next2.Mkw, next2.scope, next2.CYp, Integer.valueOf(next2.Mkv), gcw.Mjs);
                    }
                }
            }
            g.azz().a(new w(cdw, gcw.url, gcw.Mjy, gcw.hik, gcw.Mjs, gcw.dmc, gcw.Mju, gcw.signature, gcw.Mjv, gcw.Mjw, gcw.Mjx, linkedList, this.IXV), 0);
            tVar.IXT.a(AbstractC1996a.EnumC1997a.RET_OK, null, null, i2, tVar.gcx().Mjz.dIZ);
            AppMethodBeat.o(81017);
        }
    }

    private static String aYy(String str) {
        AppMethodBeat.i(81018);
        int indexOf = str.indexOf("#");
        if (indexOf < 0) {
            AppMethodBeat.o(81018);
            return str;
        }
        String substring = str.substring(0, indexOf);
        AppMethodBeat.o(81018);
        return substring;
    }

    public static class d {
        public List<String> Jsy;
        public List<cel> Jsz;
        public String appId;

        public d(String str, ceg ceg) {
            this.appId = str;
            this.Jsy = ceg.MjQ;
            this.Jsz = ceg.MjS;
        }
    }
}

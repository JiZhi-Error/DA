package com.tencent.mm.ui.conversation.a;

import android.content.Context;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.a.f;
import com.tencent.mm.model.a.g;
import com.tencent.mm.model.b.b;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.bn;
import com.tencent.mm.model.bo;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class e {

    public enum a {
        MAIN_FRAME_BANNER,
        CHATTING_RECOMMEND_BANNER,
        CHATTING_SECURITY_BANNER,
        NET_WARN_BANNER,
        OTHER_ONLINE_BANNER,
        FORCE_NOTIFY_BANNER,
        STORAGE_PERMISSION_BANNER,
        FACEBOOK_BANNER,
        AD_BANNER,
        ABTEST_BANNER,
        MASS_SEND_SIGHT_BANNER,
        TRY_NEW_INIT_BANNER,
        MAIN_FRAME_AND_ABTEST_BANNER,
        CHATTING_MONITORED_HINT;

        public static a valueOf(String str) {
            AppMethodBeat.i(38774);
            a aVar = (a) Enum.valueOf(a.class, str);
            AppMethodBeat.o(38774);
            return aVar;
        }

        static {
            AppMethodBeat.i(38775);
            AppMethodBeat.o(38775);
        }
    }

    public static com.tencent.mm.pluginsdk.ui.b.a a(Context context, a aVar, Object[] objArr) {
        b.EnumC0443b bVar;
        String str;
        boolean z;
        String str2;
        com.tencent.mm.pluginsdk.ui.b.a aVar2 = null;
        boolean z2 = false;
        AppMethodBeat.i(38776);
        switch (aVar) {
            case CHATTING_RECOMMEND_BANNER:
                if (objArr != null && objArr.length == 2) {
                    String obj = objArr[0] != null ? objArr[0].toString() : null;
                    if (objArr[1] != null) {
                        str2 = objArr[1].toString();
                    } else {
                        str2 = null;
                    }
                    if (bg.aVF().aTm() == null) {
                        Log.w("MicroMsg.BannerFactory", "recommend banner stg is null. this may be caused by account async init.");
                    }
                    if (bg.aVF().aTm() != null && (bg.aVF().aTm().KX(obj) || bg.aVF().aTm().KX(str2))) {
                        aVar2 = new f(context, obj, str2);
                        break;
                    }
                }
            case CHATTING_SECURITY_BANNER:
                if (objArr != null && objArr.length == 3) {
                    String obj2 = objArr[0] != null ? objArr[0].toString() : null;
                    if (objArr[1] != null) {
                        str = objArr[1].toString();
                    } else {
                        str = null;
                    }
                    if (objArr[2] == null || !(objArr[2] instanceof Boolean)) {
                        z = false;
                    } else {
                        z = ((Boolean) objArr[2]).booleanValue();
                    }
                    if ((bg.aAc() && bg.aVF().aTn() != null && bg.aVF().aTn().KX(obj2)) || bg.aVF().aTn().KX(str)) {
                        aVar2 = new g(context, obj2, str, z);
                        break;
                    }
                }
                break;
            case NET_WARN_BANNER:
                aVar2 = new o(context);
                break;
            case OTHER_ONLINE_BANNER:
                aVar2 = new p(context);
                break;
            case STORAGE_PERMISSION_BANNER:
                aVar2 = new q(context);
                break;
            case FACEBOOK_BANNER:
                aVar2 = new h(context);
                break;
            case AD_BANNER:
                aVar2 = new a(context);
                break;
            case MAIN_FRAME_BANNER:
                bo.aVL();
                bn aVM = bo.aVM();
                if (aVM != null) {
                    aVar2 = new l(context, aVM);
                    break;
                }
                break;
            case ABTEST_BANNER:
                com.tencent.mm.model.a.e KR = g.aWT().KR("4");
                if (KR != null) {
                    String str3 = KR.value;
                    if (!Util.isNullOrNil(str3) && !str3.equals(AppEventsConstants.EVENT_PARAM_VALUE_NO)) {
                        if (!str3.equals("1")) {
                            if (str3.equals("2")) {
                                bg.aVF();
                                Object obj3 = c.azQ().get(328196, Boolean.FALSE);
                                if (obj3 instanceof Boolean) {
                                    z2 = ((Boolean) obj3).booleanValue();
                                }
                                if (z2) {
                                    Log.i("MicroMsg.BannerFactory", "[cpan] banner type upload contact has clicked.");
                                    break;
                                } else {
                                    bo.aVL();
                                    if (bo.aVN() != bo.a.SUCC) {
                                        aVar2 = new l(context, new bn(2, 1, ""));
                                        f.KV("4");
                                        break;
                                    } else {
                                        Log.i("MicroMsg.BannerFactory", "already upload the Mobile");
                                        break;
                                    }
                                }
                            }
                        } else {
                            bg.aVF();
                            Object obj4 = c.azQ().get(328195, Boolean.FALSE);
                            if (obj4 instanceof Boolean) {
                                z2 = ((Boolean) obj4).booleanValue();
                            }
                            if (z2) {
                                Log.i("MicroMsg.BannerFactory", "[cpan] banner type bind mobile has clicked.");
                                break;
                            } else {
                                bo.aVL();
                                bo.a aVN = bo.aVN();
                                if (aVN != bo.a.SUCC && aVN != bo.a.SUCC_UNLOAD) {
                                    aVar2 = new l(context, new bn(1, 1, ""));
                                    f.KV("4");
                                    break;
                                } else {
                                    Log.i("MicroMsg.BannerFactory", "already Bind the Mobile");
                                    break;
                                }
                            }
                        }
                    }
                }
                break;
            case MASS_SEND_SIGHT_BANNER:
                aVar2 = new m(context);
                break;
            case TRY_NEW_INIT_BANNER:
                aVar2 = new r(context);
                break;
            case MAIN_FRAME_AND_ABTEST_BANNER:
                aVar2 = new k(context);
                break;
            case CHATTING_MONITORED_HINT:
                if (objArr == null || objArr.length <= 0) {
                    bVar = b.EnumC0443b.Main;
                } else {
                    bVar = (b.EnumC0443b) objArr[0];
                }
                aVar2 = new com.tencent.mm.ui.d.a(context, bVar);
                break;
        }
        AppMethodBeat.o(38776);
        return aVar2;
    }
}

package com.tencent.mm.plugin.finder.api;

import android.content.ContentValues;
import com.facebook.appevents.UserDataStore;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.cl;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.api.g;
import com.tencent.mm.plugin.finder.storage.d;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.protocal.protobuf.FinderAuthInfo;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.apr;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.bv;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.n.n;
import kotlin.t;

public final class c {
    private static boolean DEBUG;
    private static final String TAG = TAG;
    private static final a tso = ((PluginFinder) g.ah(PluginFinder.class)).getFinderContactCache();
    public static final a tsp = new a((byte) 0);

    public static final class a {

        /* access modifiers changed from: package-private */
        /* renamed from: com.tencent.mm.plugin.finder.api.c$a$a */
        public static final class C1089a extends q implements b<g, g> {
            final /* synthetic */ int tsq;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            C1089a(int i2) {
                super(1);
                this.tsq = i2;
            }

            @Override // kotlin.g.a.b
            public final /* synthetic */ g invoke(g gVar) {
                AppMethodBeat.i(165129);
                g gVar2 = gVar;
                p.h(gVar2, "contact");
                gVar2.field_follow_Flag = this.tsq;
                AppMethodBeat.o(165129);
                return gVar2;
            }
        }

        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static g cXF() {
            g gVar;
            AppMethodBeat.i(165131);
            a aVar = c.tso;
            String aUg = z.aUg();
            p.g(aUg, "ConfigStorageLogic.getMyFinderUsername()");
            g asE = aVar.asE(aUg);
            if (asE == null) {
                g gVar2 = new g();
                gVar2.field_username = z.aUg();
                gVar = gVar2;
            } else {
                gVar = asE;
            }
            g.a aVar2 = g.tsD;
            gVar.field_follow_Flag = g.tsB;
            e aAh = com.tencent.mm.kernel.g.aAh();
            p.g(aAh, "MMKernel.storage()");
            Object obj = aAh.azQ().get(ar.a.USERINFO_MY_FINDER_NICKNAME_STRING_SYNC, "");
            if (obj == null) {
                t tVar = new t("null cannot be cast to non-null type kotlin.String");
                AppMethodBeat.o(165131);
                throw tVar;
            }
            gVar.field_nickname = (String) obj;
            e aAh2 = com.tencent.mm.kernel.g.aAh();
            p.g(aAh2, "MMKernel.storage()");
            Object obj2 = aAh2.azQ().get(ar.a.USERINFO_MY_FINDER_AVATAR_STRING_SYNC, "");
            if (obj2 == null) {
                t tVar2 = new t("null cannot be cast to non-null type kotlin.String");
                AppMethodBeat.o(165131);
                throw tVar2;
            }
            gVar.field_avatarUrl = (String) obj2;
            e aAh3 = com.tencent.mm.kernel.g.aAh();
            p.g(aAh3, "MMKernel.storage()");
            Object obj3 = aAh3.azQ().get(ar.a.USERINFO_MY_FINDER_COVER_IMG_STRING_SYNC, "");
            if (obj3 == null) {
                t tVar3 = new t("null cannot be cast to non-null type kotlin.String");
                AppMethodBeat.o(165131);
                throw tVar3;
            }
            gVar.field_coverImg = (String) obj3;
            e aAh4 = com.tencent.mm.kernel.g.aAh();
            p.g(aAh4, "MMKernel.storage()");
            Object obj4 = aAh4.azQ().get(ar.a.USERINFO_MY_FINDER_SIGNATURE_STRING_SYNC, "");
            if (obj4 == null) {
                t tVar4 = new t("null cannot be cast to non-null type kotlin.String");
                AppMethodBeat.o(165131);
                throw tVar4;
            }
            gVar.field_signature = (String) obj4;
            e aAh5 = com.tencent.mm.kernel.g.aAh();
            p.g(aAh5, "MMKernel.storage()");
            gVar.field_originalFlag = aAh5.azQ().getInt(ar.a.USERINFO_MY_FINDER_ORIGINAL_FLAG2_INT_SYNC, 0);
            e aAh6 = com.tencent.mm.kernel.g.aAh();
            p.g(aAh6, "MMKernel.storage()");
            gVar.field_originalEntranceFlag = aAh6.azQ().getInt(ar.a.USERINFO_MY_FINDER_ORIGINAL_ENTRANCE2_INT_SYNC, 0);
            e aAh7 = com.tencent.mm.kernel.g.aAh();
            p.g(aAh7, "MMKernel.storage()");
            gVar.field_extFlag = aAh7.azQ().getInt(ar.a.USERINFO_FINDER_USER_EXT_FLAG_INT_SYNC, 0);
            e aAh8 = com.tencent.mm.kernel.g.aAh();
            p.g(aAh8, "MMKernel.storage()");
            Object obj5 = aAh8.azQ().get(ar.a.USERINFO_MY_FINDER_AUTH_INFO_STRING_SYNC, "");
            if (obj5 == null) {
                t tVar5 = new t("null cannot be cast to non-null type kotlin.String");
                AppMethodBeat.o(165131);
                throw tVar5;
            }
            String str = (String) obj5;
            if (!Util.isNullOrNil(str)) {
                gVar.field_authInfo = new FinderAuthInfo();
                try {
                    gVar.field_authInfo.parseFrom(Util.decodeHexString(str));
                } catch (Exception e2) {
                    Log.printDebugStack("safeParser", "", e2);
                }
            } else {
                gVar.field_authInfo = null;
            }
            e aAh9 = com.tencent.mm.kernel.g.aAh();
            p.g(aAh9, "MMKernel.storage()");
            Object obj6 = aAh9.azQ().get(ar.a.USERINFO_FINDER_LIVE_COVER_IMAGE_STRING_SYNC, "");
            if (obj6 == null) {
                t tVar6 = new t("null cannot be cast to non-null type kotlin.String");
                AppMethodBeat.o(165131);
                throw tVar6;
            }
            gVar.field_liveCoverImg = (String) obj6;
            e aAh10 = com.tencent.mm.kernel.g.aAh();
            p.g(aAh10, "MMKernel.storage()");
            gVar.field_liveAnchorStatusFlag = aAh10.azQ().a(ar.a.USERINFO_FINDER_LIVE_ANCHOR_STATUS_FLAG_LONG_SYNC, 0);
            e aAh11 = com.tencent.mm.kernel.g.aAh();
            p.g(aAh11, "MMKernel.storage()");
            gVar.field_liveSwitchFlag = aAh11.azQ().a(ar.a.USERINFO_FINDER_LIVE_SWITCH_FLAG_LONG_SYNC, 0);
            AppMethodBeat.o(165131);
            return gVar;
        }

        private static boolean asF(String str) {
            boolean z;
            AppMethodBeat.i(242184);
            g asE = c.tso.asE(str);
            if (asE != null) {
                String str2 = asE.field_username;
                if (str2 == null || str2.length() == 0) {
                    z = true;
                } else {
                    z = false;
                }
                if (!z && !p.j(str, z.aUg())) {
                    AppMethodBeat.o(242184);
                    return true;
                }
            }
            AppMethodBeat.o(242184);
            return false;
        }

        public static g asG(String str) {
            AppMethodBeat.i(165132);
            if (str == null) {
                AppMethodBeat.o(165132);
                return null;
            } else if (p.j(str, z.aUg())) {
                g cXF = cXF();
                AppMethodBeat.o(165132);
                return cXF;
            } else if (asF(str)) {
                g asE = c.tso.asE(str);
                AppMethodBeat.o(165132);
                return asE;
            } else {
                g asH = asH(str);
                if (asH != null) {
                    e(asH);
                }
                g asE2 = c.tso.asE(str);
                AppMethodBeat.o(165132);
                return asE2;
            }
        }

        private static g asH(String str) {
            AppMethodBeat.i(165133);
            g asG = ((PluginFinder) com.tencent.mm.kernel.g.ah(PluginFinder.class)).getContactStorage().asG(str);
            String str2 = c.TAG;
            Object[] objArr = new Object[2];
            objArr[0] = str;
            objArr[1] = asG != null ? asG.cXK() : null;
            Log.i(str2, "get contact %s %s", objArr);
            AppMethodBeat.o(165133);
            return asG;
        }

        public static boolean asI(String str) {
            AppMethodBeat.i(165134);
            Log.d(c.TAG, "isContact  %s exists ?", str);
            if (str == null || Util.isNullOrNil(str)) {
                AppMethodBeat.o(165134);
                return false;
            } else if (c.tso.asE(str) == null && asH(str) == null) {
                AppMethodBeat.o(165134);
                return false;
            } else {
                AppMethodBeat.o(165134);
                return true;
            }
        }

        private static boolean b(g gVar) {
            boolean z = false;
            AppMethodBeat.i(165135);
            d contactStorage = ((PluginFinder) com.tencent.mm.kernel.g.ah(PluginFinder.class)).getContactStorage();
            p.h(gVar, UserDataStore.CITY);
            gVar.field_updateTime = cl.aWA();
            if (contactStorage.asG(gVar.getUsername()) == null) {
                p.h(gVar, "contact");
                int insert = (int) contactStorage.vDi.insert("FinderContact", "", gVar.convertTo());
                Log.i("Finder.FinderContactStorage", "insert contact " + gVar + ' ' + insert);
                if (insert > 0) {
                    z = true;
                }
            } else {
                p.h(gVar, "contact");
                ContentValues convertTo = gVar.convertTo();
                convertTo.remove("rowid");
                int update = contactStorage.vDi.update("FinderContact", convertTo, "username=?", new String[]{gVar.field_username});
                Log.i("Finder.FinderContactStorage", "updateContact " + gVar.cXL() + ' ' + update);
                if (update > 0) {
                    z = true;
                }
            }
            if (z) {
                contactStorage.doNotify("FinderContact", 4, gVar.getUsername());
            }
            Log.i(c.TAG, "replaceContact success=" + z + ' ' + gVar.getUsername() + ' ' + gVar.cXK() + ' ' + (c.DEBUG ? Util.getStack() : ""));
            if (z) {
                com.tencent.mm.kernel.c.a af = com.tencent.mm.kernel.g.af(l.class);
                p.g(af, "MMKernel.service(IMessengerStorage::class.java)");
                ((l) af).aSN().d(g.f(gVar), true);
            }
            AppMethodBeat.o(165135);
            return z;
        }

        public static boolean c(g gVar) {
            AppMethodBeat.i(165136);
            p.h(gVar, "contact");
            Log.i(c.TAG, "update contact " + gVar.getUsername() + ' ' + gVar.cXK() + ' ' + (c.DEBUG ? Util.getStack() : ""));
            if (asI(gVar.getUsername())) {
                e(gVar);
                if (asH(gVar.getUsername()) != null) {
                    a aVar = c.tsp;
                    b(gVar);
                }
                AppMethodBeat.o(165136);
                return true;
            }
            AppMethodBeat.o(165136);
            return false;
        }

        public static void du(String str, int i2) {
            AppMethodBeat.i(242185);
            p.h(str, "finderUserName");
            String str2 = c.TAG;
            StringBuilder append = new StringBuilder("operationSetFollow ").append(str).append(' ').append(i2).append(" and cacheItem ");
            g asE = c.tso.asE(str);
            Log.i(str2, append.append(asE != null ? asE.cXK() : null).toString());
            C1089a aVar = new C1089a(i2);
            g asG = asG(str);
            if (asG == null) {
                asG = new g();
                asG.field_username = str;
            }
            g gVar = (g) aVar.invoke(asG);
            e(gVar);
            b(gVar);
            AppMethodBeat.o(242185);
        }

        public static boolean d(g gVar) {
            AppMethodBeat.i(242186);
            p.h(gVar, "contact");
            e(gVar);
            boolean b2 = b(gVar);
            AppMethodBeat.o(242186);
            return b2;
        }

        public static boolean a(FinderContact finderContact) {
            AppMethodBeat.i(165140);
            p.h(finderContact, "fcontact");
            String str = finderContact.username;
            if (str == null || str.length() == 0) {
                Log.e(c.TAG, "error FinderContact username is null " + Util.getStack());
                AppMethodBeat.o(165140);
                return false;
            }
            String str2 = finderContact.username;
            if (str2 == null) {
                str2 = "";
            }
            g a2 = b.a(finderContact, asG(str2));
            boolean unused = c.DEBUG;
            Log.i(c.TAG, "replaceContact contact %s result %s", a2.getUsername(), a2.cXK());
            e(a2);
            b(a2);
            AppMethodBeat.o(165140);
            return true;
        }

        public static boolean b(FinderContact finderContact) {
            boolean z;
            String str;
            Integer num;
            Long l;
            String str2;
            int i2;
            String str3;
            String str4;
            String str5;
            Integer num2 = null;
            AppMethodBeat.i(165141);
            if (finderContact == null) {
                AppMethodBeat.o(165141);
                return false;
            }
            String str6 = finderContact.username;
            if (str6 == null || str6.length() == 0) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                Log.e(c.TAG, "error FinderContact username is null " + Util.getStack());
                AppMethodBeat.o(165141);
                return false;
            }
            String str7 = finderContact.username;
            if (str7 == null) {
                str7 = "";
            }
            g asG = asG(str7);
            if (asG == null) {
                asG = new g();
            }
            String str8 = finderContact.username;
            if (str8 == null) {
                str8 = "";
            }
            asG.setUsername(str8);
            String str9 = finderContact.headUrl;
            if (str9 == null) {
                str9 = "";
            }
            asG.asL(str9);
            String str10 = finderContact.nickname;
            if (str10 == null) {
                str10 = "";
            }
            asG.setNickname(str10);
            FinderAuthInfo finderAuthInfo = asG.field_authInfo;
            if (finderAuthInfo == null) {
                asG.field_authInfo = finderContact.authInfo;
            } else if (finderContact.authInfo != null) {
                FinderAuthInfo finderAuthInfo2 = finderContact.authInfo;
                finderAuthInfo.appName = finderAuthInfo2 != null ? finderAuthInfo2.appName : null;
                FinderAuthInfo finderAuthInfo3 = finderContact.authInfo;
                if (finderAuthInfo3 != null) {
                    str2 = finderAuthInfo3.authProfession;
                } else {
                    str2 = null;
                }
                finderAuthInfo.authProfession = str2;
                FinderAuthInfo finderAuthInfo4 = finderContact.authInfo;
                if (finderAuthInfo4 != null) {
                    i2 = finderAuthInfo4.authIconType;
                } else {
                    i2 = 0;
                }
                finderAuthInfo.authIconType = i2;
                FinderAuthInfo finderAuthInfo5 = finderContact.authInfo;
                if (finderAuthInfo5 != null) {
                    str3 = finderAuthInfo5.detailLink;
                } else {
                    str3 = null;
                }
                finderAuthInfo.detailLink = str3;
                FinderAuthInfo finderAuthInfo6 = finderContact.authInfo;
                if (finderAuthInfo6 != null) {
                    str4 = finderAuthInfo6.realName;
                } else {
                    str4 = null;
                }
                finderAuthInfo.realName = str4;
                FinderAuthInfo finderAuthInfo7 = finderContact.authInfo;
                if (finderAuthInfo7 != null) {
                    str5 = finderAuthInfo7.authIconUrl;
                } else {
                    str5 = null;
                }
                finderAuthInfo.authIconUrl = str5;
            }
            asG.field_extInfo = finderContact.extInfo;
            if (c.DEBUG) {
                String str11 = c.TAG;
                StringBuilder sb = new StringBuilder("replaceMinContact fcontact : ");
                p.h(finderContact, "$this$info");
                StringBuilder append = new StringBuilder("info:userName:").append(finderContact.username).append(" nickname: ").append(finderContact.nickname).append(" followFlag: ").append(finderContact.followFlag).append(" auth: ");
                FinderAuthInfo finderAuthInfo8 = finderContact.authInfo;
                if (finderAuthInfo8 != null) {
                    str = finderAuthInfo8.realName;
                } else {
                    str = null;
                }
                StringBuilder append2 = append.append(str).append(" signature: ").append(finderContact.signature).append(" headUrl_len: ");
                String str12 = finderContact.headUrl;
                if (str12 != null) {
                    num = Integer.valueOf(str12.length());
                } else {
                    num = null;
                }
                StringBuilder append3 = append2.append(num).append(", originalFlag:").append(finderContact.originalFlag).append(" ,spam:").append(finderContact.spamStatus).append(", liveAnchorStatus:");
                apr apr = finderContact.live_info;
                if (apr != null) {
                    l = Long.valueOf(apr.LBA);
                } else {
                    l = null;
                }
                StringBuilder append4 = append3.append(l).append(", liveSwitchFlag:");
                apr apr2 = finderContact.live_info;
                if (apr2 != null) {
                    num2 = Integer.valueOf(apr2.LBB);
                }
                Log.i(str11, sb.append(append4.append(num2).toString()).append("  from ").append(Util.getStack()).toString());
            } else {
                Log.i(c.TAG, "replaceMinContact result %s onlyMemory true", asG.cXL());
            }
            e(asG);
            AppMethodBeat.o(165141);
            return true;
        }

        public static void e(g gVar) {
            AppMethodBeat.i(165142);
            String username = gVar.getUsername();
            c.tso.a(username, gVar);
            com.tencent.mm.kernel.c.a af = com.tencent.mm.kernel.g.af(l.class);
            p.g(af, "MMKernel.service(IMessengerStorage::class.java)");
            bv aSN = ((l) af).aSN();
            String avA = ((PluginFinder) com.tencent.mm.kernel.g.ah(PluginFinder.class)).getSessionInfoStorage().avA(username);
            aSN.ayf(username);
            aSN.ayf(avA);
            AppMethodBeat.o(165142);
        }

        public static boolean bxz(String str) {
            AppMethodBeat.i(260169);
            if (str != null) {
                boolean nm = n.nm(str, "@finder");
                AppMethodBeat.o(260169);
                return nm;
            }
            AppMethodBeat.o(260169);
            return false;
        }

        public static boolean asJ(String str) {
            AppMethodBeat.i(165143);
            if (str != null) {
                a aVar = c.tsp;
                g asG = asG(str);
                if (asG != null) {
                    int i2 = asG.field_follow_Flag;
                    g.a aVar2 = g.tsD;
                    if (i2 == g.tsB) {
                        AppMethodBeat.o(165143);
                        return true;
                    }
                }
                AppMethodBeat.o(165143);
                return false;
            }
            AppMethodBeat.o(165143);
            return false;
        }

        public static boolean asK(String str) {
            AppMethodBeat.i(242187);
            if (str != null) {
                a aVar = c.tsp;
                g asG = asG(str);
                if (asG != null) {
                    int i2 = asG.field_follow_Flag;
                    g.a aVar2 = g.tsD;
                    if (i2 == g.tsA) {
                        AppMethodBeat.o(242187);
                        return true;
                    }
                }
                AppMethodBeat.o(242187);
                return false;
            }
            AppMethodBeat.o(242187);
            return false;
        }
    }

    static {
        AppMethodBeat.i(165145);
        AppMethodBeat.o(165145);
    }
}

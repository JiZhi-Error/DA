package com.tencent.mm.plugin.finder.cgi.oplog;

import com.facebook.appevents.UserDataStore;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.bw.b;
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.api.c;
import com.tencent.mm.plugin.finder.api.g;
import com.tencent.mm.plugin.finder.cgi.bx;
import com.tencent.mm.plugin.finder.cgi.cl;
import com.tencent.mm.plugin.finder.viewmodel.FinderGlobalLocationVM;
import com.tencent.mm.plugin.i.a.ai;
import com.tencent.mm.plugin.i.a.x;
import com.tencent.mm.protocal.protobuf.apg;
import com.tencent.mm.protocal.protobuf.app;
import com.tencent.mm.protocal.protobuf.azg;
import com.tencent.mm.protocal.protobuf.bme;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ar;
import com.tencent.thumbplayer.core.common.TPMediaCodecProfileLevel;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\u0018\u00002\u00020\u00012\u00020\u00022\b\u0012\u0004\u0012\u00020\u00040\u0003B\u0005¢\u0006\u0002\u0010\u0005J\u0018\u0010\n\u001a\n \f*\u0004\u0018\u00010\u000b0\u000b2\u0006\u0010\r\u001a\u00020\u0004H\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u000fH\u0016J \u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00152\u000e\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0017H\u0016J \u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u000f2\u000e\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0017H\u0016J \u0010\u001a\u001a\u00020\u00112\u0006\u0010\u001b\u001a\u00020\u00072\u000e\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0017H\u0016J8\u0010\u001c\u001a\u00020\u00112\u0006\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\u000f2\u000e\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0017H\u0016J \u0010!\u001a\u00020\u00112\u0006\u0010\"\u001a\u00020\u00072\u000e\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0017H\u0016J \u0010#\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u000f2\u000e\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0017H\u0016J(\u0010$\u001a\u00020\u00112\u0006\u0010%\u001a\u00020\u000f2\u0006\u0010 \u001a\u00020\u000f2\u000e\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0017H\u0016J \u0010&\u001a\u00020\u00112\u0006\u0010'\u001a\u00020\u00072\u000e\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0017H\u0016J \u0010(\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00152\u000e\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0017H\u0016R\u0014\u0010\u0006\u001a\u00020\u0007XD¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006)"}, hxF = {"Lcom/tencent/mm/plugin/finder/cgi/oplog/FinderModifyUserService;", "Lcom/tencent/mm/plugin/findersdk/api/IFinderModifyUserInfo;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "Lcom/tencent/mm/plugin/finder/cgi/oplog/FinderOpLogCore;", "Lcom/tencent/mm/protocal/protobuf/FinderModUserInfo;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "convertToCmdBuf", "Lcom/tencent/mm/protobuf/ByteString;", "kotlin.jvm.PlatformType", "cmdBufItem", "getCmdId", "", "handleUpdateResult", "", "retCode", "modifyFeedMvReproduce", "show", "", "callback", "Lcom/tencent/mm/plugin/findersdk/api/IModifyUserResult;", "modifyUserAtShowTab", "private", "modifyUserAvatar", "avatarPath", "modifyUserDistrict", UserDataStore.COUNTRY, "province", "city", "unshowSwitch", "modifyUserNickname", "nickname", "modifyUserPrivate", "modifyUserSex", "sex", "modifyUserSignature", "signature", "modifyUserWxProfile", "plugin-finder_release"})
public final class i extends k<azg> implements com.tencent.mm.ak.i, x {
    final String TAG = "Finder.FinderModifyUserService";

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.tencent.mm.plugin.finder.cgi.oplog.k
    public final /* synthetic */ b di(azg azg) {
        AppMethodBeat.i(165308);
        azg azg2 = azg;
        p.h(azg2, "cmdBufItem");
        b cD = b.cD(azg2.toByteArray());
        AppMethodBeat.o(165308);
        return cD;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, int] */
    @Override // com.tencent.mm.plugin.finder.cgi.oplog.k
    public final /* synthetic */ void n(azg azg, int i2) {
        AppMethodBeat.i(165315);
        azg azg2 = azg;
        p.h(azg2, "cmdBufItem");
        if (i2 == 0) {
            c.a aVar = c.tsp;
            g asG = c.a.asG(z.aUg());
            if (asG == null) {
                p.hyc();
            }
            String str = azg2.nickname;
            if (str != null) {
                p.g(str, LocaleUtil.ITALIAN);
                asG.setNickname(str);
                e aAh = com.tencent.mm.kernel.g.aAh();
                p.g(aAh, "MMKernel.storage()");
                aAh.azQ().set(ar.a.USERINFO_MY_FINDER_NICKNAME_STRING_SYNC, str);
            }
            String str2 = azg2.signature;
            if (str2 != null) {
                asG.field_signature = str2;
                e aAh2 = com.tencent.mm.kernel.g.aAh();
                p.g(aAh2, "MMKernel.storage()");
                aAh2.azQ().set(ar.a.USERINFO_MY_FINDER_SIGNATURE_STRING_SYNC, str2);
            }
            String str3 = azg2.iAR;
            if (str3 != null) {
                p.g(str3, LocaleUtil.ITALIAN);
                asG.asL(str3);
                e aAh3 = com.tencent.mm.kernel.g.aAh();
                p.g(aAh3, "MMKernel.storage()");
                aAh3.azQ().set(ar.a.USERINFO_MY_FINDER_AVATAR_STRING_SYNC, str3);
            }
            c.a aVar2 = c.tsp;
            c.a.c(asG);
            e aAh4 = com.tencent.mm.kernel.g.aAh();
            p.g(aAh4, "MMKernel.storage()");
            int i3 = aAh4.azQ().getInt(ar.a.USERINFO_FINDER_USER_EXT_FLAG_INT_SYNC, 0);
            if (azg2.LJc == 1) {
                i3 |= TPMediaCodecProfileLevel.HEVCMainTierLevel52;
                Log.i(this.TAG, "showFinderInWxSwitch turn on");
            } else if (azg2.LJc == 2) {
                i3 &= -262145;
                Log.i(this.TAG, "showFinderInWxSwitch turn off");
            }
            e aAh5 = com.tencent.mm.kernel.g.aAh();
            p.g(aAh5, "MMKernel.storage()");
            aAh5.azQ().set(ar.a.USERINFO_FINDER_USER_EXT_FLAG_INT_SYNC, Integer.valueOf(i3));
        }
        AppMethodBeat.o(165315);
    }

    @Override // com.tencent.mm.plugin.finder.cgi.oplog.k
    public final String getTAG() {
        return this.TAG;
    }

    @Override // com.tencent.mm.plugin.finder.cgi.oplog.k
    public final int getCmdId() {
        AppMethodBeat.i(165309);
        bx.a aVar = bx.tvW;
        int i2 = bx.tvL;
        AppMethodBeat.o(165309);
        return i2;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J,\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016¨\u0006\u000b"}, hxF = {"com/tencent/mm/plugin/finder/cgi/oplog/FinderModifyUserService$modifyUserAvatar$1", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "onSceneEnd", "", "errType", "", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "plugin-finder_release"})
    public static final class a implements com.tencent.mm.ak.i {
        final /* synthetic */ i txN;
        final /* synthetic */ ai txO;

        a(i iVar, ai aiVar) {
            this.txN = iVar;
            this.txO = aiVar;
        }

        @Override // com.tencent.mm.ak.i
        public final void onSceneEnd(int i2, int i3, String str, q qVar) {
            AppMethodBeat.i(165307);
            Log.i(this.txN.TAG, "upload head img errType " + i2 + " errCode " + i3 + " errMsg " + str);
            com.tencent.mm.kernel.g.azz().b(3759, this);
            azg azg = new azg();
            if (qVar == null) {
                t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.cgi.NetSceneFinderUploadHeadImg");
                AppMethodBeat.o(165307);
                throw tVar;
            }
            azg.iAR = ((cl) qVar).twt;
            if (i2 == 0 && i3 == 0) {
                this.txN.a(azg, this.txO, false);
                AppMethodBeat.o(165307);
                return;
            }
            ai aiVar = this.txO;
            if (aiVar != null) {
                apg apg = new apg();
                bx.a aVar = bx.tvW;
                apg.cmdId = bx.tvL;
                apg.retCode = -1;
                aiVar.a(azg, apg);
                AppMethodBeat.o(165307);
                return;
            }
            AppMethodBeat.o(165307);
        }
    }

    @Override // com.tencent.mm.plugin.i.a.x
    public final void c(String str, ai<azg> aiVar) {
        AppMethodBeat.i(165310);
        p.h(str, "avatarPath");
        cl.a aVar = cl.twA;
        cl clVar = new cl(str, cl.cZi());
        com.tencent.mm.kernel.g.azz().a(3759, new a(this, aiVar));
        com.tencent.mm.kernel.g.azz().b(clVar);
        AppMethodBeat.o(165310);
    }

    @Override // com.tencent.mm.plugin.i.a.x
    public final void d(String str, ai<azg> aiVar) {
        AppMethodBeat.i(165311);
        p.h(str, "nickname");
        azg azg = new azg();
        azg.nickname = str;
        a(azg, aiVar, false);
        AppMethodBeat.o(165311);
    }

    @Override // com.tencent.mm.plugin.i.a.x
    public final void a(int i2, ai<azg> aiVar) {
        AppMethodBeat.i(242662);
        azg azg = new azg();
        azg.fuA = i2;
        azg.LCk = 0;
        a(azg, aiVar, false);
        AppMethodBeat.o(242662);
    }

    @Override // com.tencent.mm.plugin.i.a.x
    public final void b(int i2, ai<azg> aiVar) {
        AppMethodBeat.i(242663);
        azg azg = new azg();
        azg.LJa = i2;
        a(azg, aiVar, false);
        AppMethodBeat.o(242663);
    }

    @Override // com.tencent.mm.plugin.i.a.x
    public final void c(int i2, ai<azg> aiVar) {
        AppMethodBeat.i(242664);
        azg azg = new azg();
        azg.LJb = i2;
        a(azg, aiVar, false);
        AppMethodBeat.o(242664);
    }

    @Override // com.tencent.mm.plugin.i.a.x
    public final void a(String str, String str2, String str3, int i2, ai<azg> aiVar) {
        AppMethodBeat.i(165313);
        p.h(str, UserDataStore.COUNTRY);
        p.h(str2, "province");
        p.h(str3, "city");
        azg azg = new azg();
        azg.country = str;
        azg.fuJ = str2;
        azg.fuK = str3;
        azg.LCj = i2;
        com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
        bme bme = ((FinderGlobalLocationVM) com.tencent.mm.ui.component.a.bi(PluginFinder.class).get(FinderGlobalLocationVM.class)).wtO;
        if (bme != null) {
            azg.LCl = new app();
            app app = azg.LCl;
            if (app != null) {
                app.country = bme.keh;
            }
            app app2 = azg.LCl;
            if (app2 != null) {
                app2.fuJ = bme.kdZ;
            }
            app app3 = azg.LCl;
            if (app3 != null) {
                app3.fuK = bme.kea;
            }
            a(azg, aiVar, false);
            AppMethodBeat.o(165313);
            return;
        }
        a(azg, aiVar, false);
        AppMethodBeat.o(165313);
    }

    @Override // com.tencent.mm.plugin.i.a.x
    public final void e(String str, ai<azg> aiVar) {
        AppMethodBeat.i(165314);
        p.h(str, "signature");
        azg azg = new azg();
        azg.signature = str;
        a(azg, aiVar, false);
        AppMethodBeat.o(165314);
    }

    @Override // com.tencent.mm.plugin.i.a.x
    public final void a(boolean z, ai<azg> aiVar) {
        int i2;
        AppMethodBeat.i(242665);
        azg azg = new azg();
        if (z) {
            i2 = 1;
        } else {
            i2 = 2;
        }
        azg.LJc = i2;
        a(azg, aiVar, false);
        AppMethodBeat.o(242665);
    }

    @Override // com.tencent.mm.plugin.i.a.x
    public final void mR(boolean z) {
        int i2;
        AppMethodBeat.i(242666);
        azg azg = new azg();
        if (z) {
            i2 = 2;
        } else {
            i2 = 1;
        }
        azg.LJd = i2;
        a(azg, null, false);
        AppMethodBeat.o(242666);
    }
}

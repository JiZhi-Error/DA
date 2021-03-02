package com.tencent.mm.plugin.festival.model;

import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.aa;
import com.tencent.mm.ak.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.cl;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.festival.PluginFestival;
import com.tencent.mm.plugin.festival.b.c;
import com.tencent.mm.plugin.festival.b.d;
import com.tencent.mm.plugin.festival.c.f;
import com.tencent.mm.plugin.festival.c.i;
import com.tencent.mm.plugin.festival.model.a.e;
import com.tencent.mm.plugin.festival.model.d;
import com.tencent.mm.plugin.textstatus.a.m;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import com.tencent.youtu.sdkkitframework.common.StateEvent;
import java.util.Arrays;
import java.util.TimeZone;
import kotlin.a.j;
import kotlin.g.a.r;
import kotlin.g.b.aa;
import kotlin.g.b.ae;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.g.b.v;
import kotlin.l;
import kotlin.l.k;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u001f\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u00105\u001a\u00020\u0011J\u0006\u00106\u001a\u00020\u0011J\u0006\u00107\u001a\u000208JA\u00109\u001a\u0002082\u0006\u0010:\u001a\u00020\u00072!\u0010;\u001a\u001d\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b=\u0012\b\b>\u0012\u0004\b\b(?\u0012\u0004\u0012\u0002080<2\u000e\b\u0002\u0010@\u001a\b\u0012\u0002\b\u0003\u0018\u00010AJ\b\u0010B\u001a\u0004\u0018\u00010CJ\u0016\u0010D\u001a\u00020\u00072\u0006\u0010E\u001a\u00020F2\u0006\u0010G\u001a\u00020\u0018J\u0006\u0010H\u001a\u00020\u0011J\u0006\u0010I\u001a\u00020\u0011J\u0001\u0010J\u001a\u0002082\u0006\u0010K\u001a\u00020L2\b\u0010M\u001a\u0004\u0018\u00010\u00072\b\u0010N\u001a\u0004\u0018\u00010\u00072b\u0010;\u001a^\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b=\u0012\b\b>\u0012\u0004\b\b(P\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b=\u0012\b\b>\u0012\u0004\b\b(Q\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b=\u0012\b\b>\u0012\u0004\b\b(R\u0012\u0013\u0012\u00110S¢\u0006\f\b=\u0012\b\b>\u0012\u0004\b\b(T\u0012\u0004\u0012\u000208\u0018\u00010OH\u0007J\b\u0010U\u001a\u000208H\u0002J \u0010V\u001a\u0002082\u0006\u0010E\u001a\u00020F2\b\u0010W\u001a\u0004\u0018\u00010X2\u0006\u0010Y\u001a\u00020\u0004J\u0016\u0010Z\u001a\u0002082\u0006\u0010E\u001a\u00020F2\u0006\u0010Y\u001a\u00020\u0004J\b\u0010[\u001a\u000208H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R+\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00048B@BX\u0002¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR+\u0010\u0012\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u00118F@FX\u0002¢\u0006\u0012\n\u0004\b\u0017\u0010\u0010\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R+\u0010\u0019\u001a\u00020\u00182\u0006\u0010\t\u001a\u00020\u00188B@BX\u0002¢\u0006\u0012\n\u0004\b\u001e\u0010\u0010\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR+\u0010\u001f\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u00118F@FX\u0002¢\u0006\u0012\n\u0004\b\"\u0010\u0010\u001a\u0004\b \u0010\u0014\"\u0004\b!\u0010\u0016R+\u0010#\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00048B@BX\u0002¢\u0006\u0012\n\u0004\b&\u0010\u0010\u001a\u0004\b$\u0010\f\"\u0004\b%\u0010\u000eR+\u0010'\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00078B@BX\u0002¢\u0006\u0012\n\u0004\b,\u0010\u0010\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R+\u0010-\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00078B@BX\u0002¢\u0006\u0012\n\u0004\b0\u0010\u0010\u001a\u0004\b.\u0010)\"\u0004\b/\u0010+R+\u00101\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00078B@BX\u0002¢\u0006\u0012\n\u0004\b4\u0010\u0010\u001a\u0004\b2\u0010)\"\u0004\b3\u0010+¨\u0006\\"}, hxF = {"Lcom/tencent/mm/plugin/festival/model/FestivalWishLogic;", "", "()V", "ErrCodeNeedRealName", "", "FuBagExpiredTime", "TAG", "", "UpgradeUrl", "<set-?>", "getFuBagTime", "getGetFuBagTime", "()I", "setGetFuBagTime", "(I)V", "getFuBagTime$delegate", "Lcom/tencent/mm/plugin/festival/model/FestivalMmkvProperty;", "", "hadEverShowSetStatusPanel", "getHadEverShowSetStatusPanel", "()Z", "setHadEverShowSetStatusPanel", "(Z)V", "hadEverShowSetStatusPanel$delegate", "", "lastPostTime", "getLastPostTime", "()J", "setLastPostTime", "(J)V", "lastPostTime$delegate", "needShowEducation", "getNeedShowEducation", "setNeedShowEducation", "needShowEducation$delegate", "postQuotaLeft", "getPostQuotaLeft", "setPostQuotaLeft", "postQuotaLeft$delegate", "statusSourceActivityId", "getStatusSourceActivityId", "()Ljava/lang/String;", "setStatusSourceActivityId", "(Ljava/lang/String;)V", "statusSourceActivityId$delegate", "statusSourceName", "getStatusSourceName", "setStatusSourceName", "statusSourceName$delegate", "statusVerifyBuf", "getStatusVerifyBuf", "setStatusVerifyBuf", "statusVerifyBuf$delegate", "canPostWish", "checkShowEducation", "consumeFuBag", "", "deleteWish", "wishId", "callback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", StateEvent.ProcessResult.SUCCEED, "lifeCycleKeeper", "Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;", "getStatusFuIcon", "Landroid/graphics/drawable/Drawable;", "getTopicDesc", "context", "Landroid/content/Context;", "count", "isFuStatusAvailable", "needShowFuBag", "postWish", "point", "Landroid/graphics/Point;", "text", "topic", "Lkotlin/Function4;", "isSuc", "errMsg", "errCode", "Lcom/tencent/mm/plugin/festival/proto/PostFestivalWishResp;", "resp", "setFuStatusAvailable", "setStatus", "wishContext", "Lcom/tencent/mm/plugin/festival/model/FestivalWishContextBundle;", "reqCode", "setStatusFromFuBag", "updateQuota", "plugin-festival_release"})
public final class ab {
    public static final p UzA = new p(Boolean.FALSE, f.a.HadEverShowSetStatusPanel);
    private static final p UzB = new p("", f.a.StatusVerifyBuf);
    private static final p UzC = new p("", f.a.StatusSourceName);
    private static final p UzD = new p("", f.a.StatusSourceAcitivityId);
    private static final p UzE = new p((Object) 0, f.a.GetFuBagTime);
    public static final String UzF;
    public static final ab UzG = new ab();
    private static final p Uzx = new p((Object) 0L, f.a.LastPostWishTime);
    private static final p Uzy = new p((Object) 5, f.a.PostQuotaLeft);
    private static final p Uzz = new p(Boolean.TRUE, f.a.FirstEnterShowEducation);
    public static final /* synthetic */ k[] cLI = {aa.a(new v(aa.bp(ab.class), "lastPostTime", "getLastPostTime()J")), aa.a(new v(aa.bp(ab.class), "postQuotaLeft", "getPostQuotaLeft()I")), aa.a(new v(aa.bp(ab.class), "needShowEducation", "getNeedShowEducation()Z")), aa.a(new v(aa.bp(ab.class), "hadEverShowSetStatusPanel", "getHadEverShowSetStatusPanel()Z")), aa.a(new v(aa.bp(ab.class), "statusVerifyBuf", "getStatusVerifyBuf()Ljava/lang/String;")), aa.a(new v(aa.bp(ab.class), "statusSourceName", "getStatusSourceName()Ljava/lang/String;")), aa.a(new v(aa.bp(ab.class), "statusSourceActivityId", "getStatusSourceActivityId()Ljava/lang/String;")), aa.a(new v(aa.bp(ab.class), "getFuBagTime", "getGetFuBagTime()I"))};

    private final void awD(int i2) {
        AppMethodBeat.i(263106);
        Uzy.a(this, cLI[1], Integer.valueOf(i2));
        AppMethodBeat.o(263106);
    }

    private final void awE(int i2) {
        AppMethodBeat.i(263114);
        UzE.a(this, cLI[7], Integer.valueOf(i2));
        AppMethodBeat.o(263114);
    }

    private final long hRE() {
        AppMethodBeat.i(263104);
        long longValue = ((Number) Uzx.a(this, cLI[0])).longValue();
        AppMethodBeat.o(263104);
        return longValue;
    }

    private final int hRF() {
        AppMethodBeat.i(263105);
        int intValue = ((Number) Uzy.a(this, cLI[1])).intValue();
        AppMethodBeat.o(263105);
        return intValue;
    }

    private final int hRK() {
        AppMethodBeat.i(263113);
        int intValue = ((Number) UzE.a(this, cLI[7])).intValue();
        AppMethodBeat.o(263113);
        return intValue;
    }

    public final void Fm(boolean z) {
        AppMethodBeat.i(263108);
        Uzz.a(this, cLI[2], Boolean.valueOf(z));
        AppMethodBeat.o(263108);
    }

    public final void Fn(boolean z) {
        AppMethodBeat.i(263109);
        UzA.a(this, cLI[3], Boolean.valueOf(z));
        AppMethodBeat.o(263109);
    }

    public final boolean hRG() {
        AppMethodBeat.i(263107);
        boolean booleanValue = ((Boolean) Uzz.a(this, cLI[2])).booleanValue();
        AppMethodBeat.o(263107);
        return booleanValue;
    }

    public final String hRH() {
        AppMethodBeat.i(263110);
        String str = (String) UzB.a(this, cLI[4]);
        AppMethodBeat.o(263110);
        return str;
    }

    public final String hRI() {
        AppMethodBeat.i(263111);
        String str = (String) UzC.a(this, cLI[5]);
        AppMethodBeat.o(263111);
        return str;
    }

    public final String hRJ() {
        AppMethodBeat.i(263112);
        String str = (String) UzD.a(this, cLI[6]);
        AppMethodBeat.o(263112);
        return str;
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\n¢\u0006\u0002\b\t"}, hxF = {"<anonymous>", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/plugin/festival/proto/PostFestivalWishResp;", "invoke"})
    public static final class a extends q implements r<Integer, Integer, String, com.tencent.mm.plugin.festival.b.l, x> {
        final /* synthetic */ String UzH;
        final /* synthetic */ kotlin.g.a.b gWe;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(String str, kotlin.g.a.b bVar) {
            super(4);
            this.UzH = str;
            this.gWe = bVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object, java.lang.Object, java.lang.Object] */
        @Override // kotlin.g.a.r
        public final /* synthetic */ x invoke(Integer num, Integer num2, String str, com.tencent.mm.plugin.festival.b.l lVar) {
            c cVar;
            AppMethodBeat.i(263101);
            int intValue = num.intValue();
            int intValue2 = num2.intValue();
            com.tencent.mm.plugin.festival.b.l lVar2 = lVar;
            if (intValue == 0 && intValue2 == 0) {
                int i2 = (lVar2 == null || (cVar = lVar2.UqV) == null) ? 1 : cVar.UAu;
                com.tencent.mm.kernel.b.a ah = g.ah(PluginFestival.class);
                p.g(ah, "plugin(PluginFestival::class.java)");
                ((PluginFestival) ah).getFestivalWishStorage().ii(this.UzH, i2);
                this.gWe.invoke(Boolean.TRUE);
            } else {
                this.gWe.invoke(Boolean.FALSE);
            }
            x xVar = x.SXb;
            AppMethodBeat.o(263101);
            return xVar;
        }
    }

    static {
        AppMethodBeat.i(263103);
        ae aeVar = ae.SYK;
        String format = String.format("https://support.weixin.qq.com/cgi-bin/mmsupport-bin/newreadtemplate?t=upgrade_2021", Arrays.copyOf(new Object[0], 0));
        p.g(format, "java.lang.String.format(format, *args)");
        UzF = format;
        AppMethodBeat.o(263103);
    }

    private ab() {
    }

    public static final /* synthetic */ void a(ab abVar) {
        AppMethodBeat.i(263125);
        abVar.hRM();
        AppMethodBeat.o(263125);
    }

    public static final /* synthetic */ void a(ab abVar, int i2) {
        AppMethodBeat.i(263129);
        abVar.awD(i2);
        AppMethodBeat.o(263129);
    }

    public static final /* synthetic */ long b(ab abVar) {
        AppMethodBeat.i(263126);
        long hRE = abVar.hRE();
        AppMethodBeat.o(263126);
        return hRE;
    }

    public static final /* synthetic */ void b(ab abVar, int i2) {
        AppMethodBeat.i(263133);
        abVar.awE(i2);
        AppMethodBeat.o(263133);
    }

    public static final /* synthetic */ int c(ab abVar) {
        AppMethodBeat.i(263128);
        int hRF = abVar.hRF();
        AppMethodBeat.o(263128);
        return hRF;
    }

    public static final void a(Point point, String str, String str2, r<? super Boolean, ? super String, ? super Integer, ? super com.tencent.mm.plugin.festival.b.l, x> rVar) {
        AppMethodBeat.i(263115);
        p.h(point, "point");
        Log.i("MicroMsg.FestivalWishLogic", "postWish x:" + point.x + " y:" + point.y);
        Log.d("MicroMsg.FestivalWishLogic", "postWish topic:".concat(String.valueOf(str2)));
        c cVar = new c();
        cVar.x = point.x;
        cVar.y = point.y;
        cVar.UAs = new d();
        cVar.text = str;
        cVar.dST = str2;
        com.tencent.mm.plugin.festival.b.k kVar = new com.tencent.mm.plugin.festival.b.k();
        kVar.UqV = cVar;
        kVar.jlz = String.valueOf(Util.nowMilliSecond());
        d.a aVar = new d.a();
        aVar.MB(d.b.UxE.uri);
        aVar.sG(d.b.UxE.cmdId);
        aVar.c(kVar);
        aVar.d(new com.tencent.mm.plugin.festival.b.l());
        com.tencent.mm.ak.aa.a(aVar.aXF(), new b(rVar));
        AppMethodBeat.o(263115);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u000e\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u00052\u000e\u0010\u0007\u001a\n \u0006*\u0004\u0018\u00010\b0\b2\u000e\u0010\t\u001a\n \u0006*\u0004\u0018\u00010\n0\nH\n¢\u0006\u0002\b\u000b"}, hxF = {"<anonymous>", "", "errType", "errCode", "errMsg", "", "kotlin.jvm.PlatformType", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "callback"})
    public static final class b implements aa.a {
        final /* synthetic */ r nyK;

        b(r rVar) {
            this.nyK = rVar;
        }

        @Override // com.tencent.mm.ak.aa.a
        public final int a(int i2, int i3, String str, com.tencent.mm.ak.d dVar, com.tencent.mm.ak.q qVar) {
            boolean z;
            AppMethodBeat.i(263102);
            Log.i("MicroMsg.FestivalWishLogic", "postWishImg callback errType=" + i2 + ", errCode=" + i3 + ", errMsg=" + str);
            com.tencent.mm.bw.a aYK = dVar != null ? dVar.aYK() : null;
            if (!(aYK instanceof com.tencent.mm.plugin.festival.b.l)) {
                aYK = null;
            }
            com.tencent.mm.plugin.festival.b.l lVar = (com.tencent.mm.plugin.festival.b.l) aYK;
            if (lVar == null) {
                p.hyc();
            }
            if (lVar.UBc) {
                e eVar = e.UAo;
                e.hSd();
            }
            e eVar2 = e.UAo;
            e.awH(4);
            if (i2 == 0 && i3 == 0) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                ab abVar = ab.UzG;
                ab.hRR();
                ab.a(ab.UzG);
                ab.a(ab.UzG, Util.nowMilliSecond());
                ab abVar2 = ab.UzG;
                ab.a(abVar2, ab.c(abVar2) - 1);
                ab abVar3 = ab.UzG;
                String str2 = lVar.UBb;
                p.g(str2, "resp.text_status_verify_info_buf");
                ab.a(abVar3, str2);
                ab abVar4 = ab.UzG;
                String str3 = lVar.UBi;
                p.g(str3, "resp.text_status_sourceactivityid");
                ab.b(abVar4, str3);
                ab abVar5 = ab.UzG;
                String str4 = lVar.UBh;
                p.g(str4, "resp.text_status_sourcename");
                ab.c(abVar5, str4);
                ab.b(ab.UzG, cl.aWB());
                Log.i("MicroMsg.FestivalWishLogic", "save lastPostTime: " + ab.b(ab.UzG) + ", postQuotaLeft: " + ab.c(ab.UzG) + " hitDonation:" + lVar.UBc);
                com.tencent.mm.kernel.b.a ah = g.ah(PluginFestival.class);
                p.g(ah, "plugin(PluginFestival::class.java)");
                ad festivalWishStorage = ((PluginFestival) ah).getFestivalWishStorage();
                String str5 = "update FestivalWish2 set delFlag = 1 where userName = \"" + z.aTY() + '\"';
                synchronized (festivalWishStorage) {
                    try {
                        Log.i("MicroMsg.FestivalWishStorage", "delMyWish r:".concat(String.valueOf(festivalWishStorage.iFy.execSQL("FestivalWish2", str5))));
                        x xVar = x.SXb;
                    } catch (Throwable th) {
                        AppMethodBeat.o(263102);
                        throw th;
                    }
                }
                String str6 = lVar.UqV.username;
                if (str6 == null || str6.length() == 0) {
                    lVar.UqV.username = z.aTY();
                }
                com.tencent.mm.kernel.b.a ah2 = g.ah(PluginFestival.class);
                p.g(ah2, "plugin(PluginFestival::class.java)");
                ((PluginFestival) ah2).getFestivalWishStorage().b(lVar.UqV);
                com.tencent.mm.plugin.festival.model.a.b bVar = com.tencent.mm.plugin.festival.model.a.b.UzX;
                com.tencent.mm.plugin.festival.model.a.b.hRW();
            }
            String valueOf = String.valueOf(str);
            r rVar = this.nyK;
            if (rVar != null) {
                rVar.invoke(Boolean.valueOf(z), valueOf, Integer.valueOf(i3), lVar);
            }
            AppMethodBeat.o(263102);
            return 0;
        }
    }

    public static void q(String str, kotlin.g.a.b<? super Boolean, x> bVar) {
        AppMethodBeat.i(263116);
        p.h(str, "wishId");
        p.h(bVar, "callback");
        v vVar = v.UyU;
        d.a aVar = d.b.UxE;
        p.g(aVar, "FestivalConstants.Protocol.PostFestivalWish");
        com.tencent.mm.plugin.festival.b.k kVar = new com.tencent.mm.plugin.festival.b.k();
        c cVar = new c();
        cVar.UAu = 1;
        cVar.UAv = str;
        kVar.UqV = cVar;
        v.a(aVar, kVar, new com.tencent.mm.plugin.festival.b.l(), new a(str, bVar));
        AppMethodBeat.o(263116);
    }

    public final boolean hRL() {
        AppMethodBeat.i(263117);
        hRM();
        Log.i("MicroMsg.FestivalWishLogic", "canPostWish postQuotaLeft:" + hRF());
        if (hRF() > 0) {
            AppMethodBeat.o(263117);
            return true;
        }
        AppMethodBeat.o(263117);
        return false;
    }

    private final void hRM() {
        AppMethodBeat.i(263118);
        i iVar = i.UGI;
        long nowMilliSecond = Util.nowMilliSecond();
        long hRE = hRE();
        TimeZone timeZone = TimeZone.getDefault();
        p.g(timeZone, "TimeZone.getDefault()");
        if (!i.a(nowMilliSecond, hRE, timeZone)) {
            awD(z.Uzb.hRC().UAH);
            Log.i("MicroMsg.FestivalWishLogic", "updateQuota new day " + hRF());
        }
        AppMethodBeat.o(263118);
    }

    public final boolean hRN() {
        boolean z = true;
        AppMethodBeat.i(263119);
        boolean z2 = hRQ() != null;
        int aWB = cl.aWB();
        if (aWB - hRK() >= 86400 || !z2 || hRJ() == null || hRI() == null || hRH() == null) {
            z = false;
        }
        Log.i("MicroMsg.FestivalWishLogic", "needShowFuBag fuStatusValid:" + z2 + " canShow:" + z + " now:" + aWB + " getFuBagTime:" + hRK());
        AppMethodBeat.o(263119);
        return z;
    }

    public final void hRO() {
        AppMethodBeat.i(263120);
        Log.i("MicroMsg.FestivalWishLogic", "consumeFuBag");
        awE(0);
        AppMethodBeat.o(263120);
    }

    public static void a(Context context, FestivalWishContextBundle festivalWishContextBundle) {
        AppMethodBeat.i(263121);
        p.h(context, "context");
        if (festivalWishContextBundle == null) {
            AppMethodBeat.o(263121);
            return;
        }
        m.a aTe = new m.a().aSY("2021").aTb("wedraw@inner").aTc(festivalWishContextBundle.Uzo).aTd(festivalWishContextBundle.Uzh).aTe(festivalWishContextBundle.Uzn);
        com.tencent.mm.plugin.textstatus.g.r rVar = new com.tencent.mm.plugin.textstatus.g.r();
        rVar.GaO = "4";
        rVar.GaQ = null;
        com.tencent.mm.plugin.textstatus.g.r rVar2 = new com.tencent.mm.plugin.textstatus.g.r();
        rVar2.GaO = TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL;
        rVar2.GaQ = UzF;
        ((com.tencent.mm.plugin.textstatus.a.i) g.af(com.tencent.mm.plugin.textstatus.a.i.class)).a((Activity) context, 273, aTe.hE(j.listOf((Object[]) new com.tencent.mm.plugin.textstatus.g.r[]{rVar, rVar2})).fvy().fvz());
        AppMethodBeat.o(263121);
    }

    public static boolean hRP() {
        boolean z;
        AppMethodBeat.i(263122);
        if (hRQ() != null) {
            t tVar = t.UyR;
            if (!t.awC(16)) {
                z = true;
                Log.i("MicroMsg.FestivalWishLogic", "isFuStatusAvailable ".concat(String.valueOf(z)));
                AppMethodBeat.o(263122);
                return z;
            }
        }
        z = false;
        Log.i("MicroMsg.FestivalWishLogic", "isFuStatusAvailable ".concat(String.valueOf(z)));
        AppMethodBeat.o(263122);
        return z;
    }

    public static Drawable hRQ() {
        AppMethodBeat.i(263123);
        Drawable byn = ((com.tencent.mm.plugin.textstatus.a.i) g.af(com.tencent.mm.plugin.textstatus.a.i.class)).byn("2021");
        AppMethodBeat.o(263123);
        return byn;
    }

    public static final /* synthetic */ void hRR() {
        AppMethodBeat.i(263124);
        ((com.tencent.mm.plugin.textstatus.a.i) g.af(com.tencent.mm.plugin.textstatus.a.i.class)).bym("2021");
        AppMethodBeat.o(263124);
    }

    public static final /* synthetic */ void a(ab abVar, long j2) {
        AppMethodBeat.i(263127);
        Uzx.a(abVar, cLI[0], Long.valueOf(j2));
        AppMethodBeat.o(263127);
    }

    public static final /* synthetic */ void a(ab abVar, String str) {
        AppMethodBeat.i(263130);
        UzB.a(abVar, cLI[4], str);
        AppMethodBeat.o(263130);
    }

    public static final /* synthetic */ void b(ab abVar, String str) {
        AppMethodBeat.i(263131);
        UzD.a(abVar, cLI[6], str);
        AppMethodBeat.o(263131);
    }

    public static final /* synthetic */ void c(ab abVar, String str) {
        AppMethodBeat.i(263132);
        UzC.a(abVar, cLI[5], str);
        AppMethodBeat.o(263132);
    }
}

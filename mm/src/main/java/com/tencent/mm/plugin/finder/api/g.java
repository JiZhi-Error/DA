package com.tencent.mm.plugin.finder.api;

import android.database.Cursor;
import com.facebook.appevents.UserDataStore;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ce;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.plugin.i.a.ah;
import com.tencent.mm.protocal.protobuf.app;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.storage.as;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u001a\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b%\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 R2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001RB\u000f\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006B\u0007\b\u0016¢\u0006\u0002\u0010\u0007J\b\u0010\u001f\u001a\u0004\u0018\u00010\u0000J\u0012\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\b\u0010$\u001a\u00020\u0005H\u0016J\b\u0010%\u001a\u00020\u0005H\u0016J\b\u0010&\u001a\u00020'H\u0016J\b\u0010(\u001a\u00020\u0005H\u0016J\b\u0010)\u001a\u00020*H\u0014J\b\u0010+\u001a\u00020\u0005H\u0016J\b\u0010,\u001a\u00020\u0005H\u0016J\b\u0010-\u001a\u00020\u0005H\u0016J\b\u0010.\u001a\u00020\u0005H\u0016J\b\u0010/\u001a\u00020\u001aH\u0016J\b\u00100\u001a\u00020'H\u0016J\b\u00101\u001a\u00020\u001aH\u0016J\b\u00102\u001a\u00020\u0005H\u0016J\b\u00103\u001a\u00020'H\u0016J\b\u00104\u001a\u00020\u0005H\u0016J\b\u00105\u001a\u00020\u0005H\u0016J\b\u00106\u001a\u00020'H\u0016J\u0006\u00107\u001a\u00020\tJ\u0006\u00108\u001a\u00020\tJ\b\u00109\u001a\u00020\tH\u0016J\u000e\u0010:\u001a\u00020!2\u0006\u0010;\u001a\u00020\u0005J\u000e\u0010<\u001a\u00020!2\u0006\u0010=\u001a\u00020\u0005J\u000e\u0010>\u001a\u00020!2\u0006\u0010?\u001a\u00020\u0005J\u000e\u0010@\u001a\u00020!2\u0006\u0010A\u001a\u00020\u0005J\u000e\u0010B\u001a\u00020!2\u0006\u0010C\u001a\u00020\u0005J\u000e\u0010D\u001a\u00020!2\u0006\u0010E\u001a\u00020\u001aJ\u000e\u0010F\u001a\u00020!2\u0006\u0010G\u001a\u00020\u0005J\u000e\u0010H\u001a\u00020!2\u0006\u0010I\u001a\u00020\u0005J\u000e\u0010J\u001a\u00020!2\u0006\u0010K\u001a\u00020'J\u0006\u0010L\u001a\u00020\u0005J\u0006\u0010M\u001a\u00020\u0005J\b\u0010N\u001a\u00020\u0005H\u0016J\u0010\u0010O\u001a\u00020P2\b\b\u0002\u0010Q\u001a\u00020PR\u001a\u0010\b\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\n\"\u0004\b\u000e\u0010\fR\u001a\u0010\u000f\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\n\"\u0004\b\u0010\u0010\fR\u001a\u0010\u0011\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\n\"\u0004\b\u0013\u0010\fR\"\u0010\u0014\u001a\n \u0015*\u0004\u0018\u00010\u00050\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0006R\u001a\u0010\u0019\u001a\u00020\u001aX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001e¨\u0006S"}, hxF = {"Lcom/tencent/mm/plugin/finder/api/LocalFinderContact;", "Lcom/tencent/mm/autogen/table/BaseFinderContact;", "Lcom/tencent/mm/plugin/findersdk/api/ILocalFinderContact;", "", ch.COL_USERNAME, "", "(Ljava/lang/String;)V", "()V", "isContactValid", "", "()Z", "setContactValid", "(Z)V", "isNeedShowUnFollow", "setNeedShowUnFollow", "isSyncFromDB", "setSyncFromDB", "oldIsNeedShowUnFollow", "getOldIsNeedShowUnFollow", "setOldIsNeedShowUnFollow", "old_avatar_url", "kotlin.jvm.PlatformType", "getOld_avatar_url", "()Ljava/lang/String;", "setOld_avatar_url", "old_follow_flag", "", "getOld_follow_flag", "()I", "setOld_follow_flag", "(I)V", "cloneContact", "convertFrom", "", "cu", "Landroid/database/Cursor;", "getAvatarUrl", "getCity", "getContactId", "", "getCountry", "getDBInfo", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "getDisplayRemark", "getLiveAlias", "getNickname", "getProvince", "getRetryCount", "getRewardTotalAmountInWecoin", "getSex", "getSignature", "getUpdateTime", "getUsername", "getV5UserName", "getVersion", "isBlock", "isSilence", "isValid", "setAvatarUrl", "field_avatarUrl", "setCity", "city", "setCountry", UserDataStore.COUNTRY, "setNickname", "field_nickname", "setProvince", "province", "setSex", "sex", "setSignature", "signature", "setUsername", "field_username", "setVersion", "version", "toInfo", "toMiniInfo", "toString", "toWxContact", "Lcom/tencent/mm/storage/Contact;", "contact", "Companion", "plugin-finder_release"})
public final class g extends ce implements ah, Cloneable {
    private static final IAutoDBItem.MAutoDBInfo info;
    private static final int tsA = 2;
    private static final int tsB = 1;
    private static final int tsC = 0;
    public static final a tsD = new a((byte) 0);
    boolean isNeedShowUnFollow;
    public boolean tsv;
    public boolean tsw = true;
    int tsx = this.field_follow_Flag;
    String tsy = this.field_avatarUrl;
    boolean tsz;

    @Override // java.lang.Object
    public final Object clone() {
        AppMethodBeat.i(165157);
        Object clone = super.clone();
        AppMethodBeat.o(165157);
        return clone;
    }

    public g(String str) {
        p.h(str, ch.COL_USERNAME);
        AppMethodBeat.i(242194);
        this.field_username = str;
        AppMethodBeat.o(242194);
    }

    public g() {
        AppMethodBeat.i(165155);
        AppMethodBeat.o(165155);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0014\u0010\t\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006R\u000e\u0010\u000b\u001a\u00020\fXT¢\u0006\u0002\n\u0000R\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, hxF = {"Lcom/tencent/mm/plugin/finder/api/LocalFinderContact$Companion;", "", "()V", "FOLLOW_FLAG_FOLLOWED", "", "getFOLLOW_FLAG_FOLLOWED", "()I", "FOLLOW_FLAG_UNFOLLOWED", "getFOLLOW_FLAG_UNFOLLOWED", "FOLLOW_FLAG_WAITING", "getFOLLOW_FLAG_WAITING", "TAG", "", "info", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "getInfo", "()Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(165156);
        IAutoDBItem.MAutoDBInfo ajs = ce.ajs();
        p.g(ajs, "BaseFinderContact.initAu…inderContact::class.java)");
        info = ajs;
        AppMethodBeat.o(165156);
    }

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem
    public final IAutoDBItem.MAutoDBInfo getDBInfo() {
        return info;
    }

    @Override // com.tencent.mm.g.c.ce, com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public final void convertFrom(Cursor cursor) {
        AppMethodBeat.i(165147);
        super.convertFrom(cursor);
        this.tsv = true;
        AppMethodBeat.o(165147);
    }

    @Override // com.tencent.mm.plugin.i.a.ah
    public final String getUsername() {
        String str = this.field_username;
        return str == null ? "" : str;
    }

    public final void setUsername(String str) {
        AppMethodBeat.i(165148);
        p.h(str, "field_username");
        this.field_username = str;
        AppMethodBeat.o(165148);
    }

    @Override // com.tencent.mm.plugin.i.a.ah
    public final String getNickname() {
        String str = this.field_nickname;
        return str == null ? "" : str;
    }

    public final void setNickname(String str) {
        AppMethodBeat.i(165149);
        p.h(str, "field_nickname");
        this.field_nickname = str;
        AppMethodBeat.o(165149);
    }

    @Override // com.tencent.mm.plugin.i.a.ah
    public final String cXH() {
        String str = this.field_avatarUrl;
        return str == null ? "" : str;
    }

    public final void asL(String str) {
        AppMethodBeat.i(165150);
        p.h(str, "field_avatarUrl");
        this.field_avatarUrl = str;
        AppMethodBeat.o(165150);
    }

    @Override // com.tencent.mm.plugin.i.a.ah
    public final boolean isValid() {
        return this.tsw;
    }

    @Override // com.tencent.mm.plugin.i.a.ah
    public final long cXI() {
        return this.field_updateTime;
    }

    @Override // com.tencent.mm.plugin.i.a.ah
    public final String arJ() {
        String str = this.field_nickname;
        return str == null ? "" : str;
    }

    @Override // com.tencent.mm.plugin.i.a.ah
    public final String getCity() {
        String str;
        app app = this.field_extInfo;
        return (app == null || (str = app.fuK) == null) ? "" : str;
    }

    public final void BX(String str) {
        AppMethodBeat.i(242188);
        p.h(str, "city");
        app app = this.field_extInfo;
        if (app == null) {
            app = new app();
        }
        app.fuK = str;
        this.field_extInfo = app;
        AppMethodBeat.o(242188);
    }

    @Override // com.tencent.mm.plugin.i.a.ah
    public final String getCountry() {
        AppMethodBeat.i(242189);
        app app = this.field_extInfo;
        if (app == null) {
            app = new app();
        }
        String str = app.country;
        if (str == null) {
            str = "";
        }
        AppMethodBeat.o(242189);
        return str;
    }

    @Override // com.tencent.mm.plugin.i.a.ah
    public final String getSignature() {
        String str = this.field_signature;
        return str == null ? "" : str;
    }

    public final void BV(String str) {
        AppMethodBeat.i(242190);
        p.h(str, "signature");
        this.field_signature = str;
        AppMethodBeat.o(242190);
    }

    @Override // com.tencent.mm.plugin.i.a.ah
    public final long cXJ() {
        return this.systemRowid;
    }

    @Override // com.tencent.mm.plugin.i.a.ah
    public final String getProvince() {
        String str;
        app app = this.field_extInfo;
        return (app == null || (str = app.fuJ) == null) ? "" : str;
    }

    public final void BW(String str) {
        AppMethodBeat.i(242191);
        p.h(str, "province");
        app app = this.field_extInfo;
        if (app == null) {
            app = new app();
        }
        app.fuJ = str;
        this.field_extInfo = app;
        AppMethodBeat.o(242191);
    }

    @Override // com.tencent.mm.plugin.i.a.ah
    public final int ajE() {
        app app = this.field_extInfo;
        if (app != null) {
            return app.fuA;
        }
        return 0;
    }

    public final void nj(int i2) {
        AppMethodBeat.i(242192);
        app app = this.field_extInfo;
        if (app == null) {
            app = new app();
        }
        app.fuA = i2;
        this.field_extInfo = app;
        AppMethodBeat.o(242192);
    }

    public final String cXK() {
        AppMethodBeat.i(165151);
        String str = "username:" + this.field_username + " nick:" + this.field_nickname + " signature:" + this.field_signature + " version:" + this.field_version + " follow_flag:" + this.field_follow_Flag + " head:" + this.field_avatarUrl + " converImg:" + this.field_coverImg + " spam:" + this.field_spamStatus + ", originalFlag:" + this.field_originalFlag + ", liveAnchorFlag:" + this.field_liveAnchorStatusFlag + ", liveSwitchFlag:" + this.field_liveSwitchFlag;
        AppMethodBeat.o(165151);
        return str;
    }

    public final String cXL() {
        AppMethodBeat.i(165152);
        String str = "username:" + this.field_username + " nick:" + this.field_nickname + " signature:" + this.field_signature + " version:" + this.field_version + " follow_flag:" + this.field_follow_Flag + "  converImg:" + this.field_coverImg + " spam:" + this.field_spamStatus;
        AppMethodBeat.o(165152);
        return str;
    }

    @Override // com.tencent.mm.plugin.i.a.ah
    public final int getRetryCount() {
        return this.field_retryCount;
    }

    @Override // com.tencent.mm.plugin.i.a.ah
    public final long hSF() {
        return this.field_rewardTotalAmountInWecoin;
    }

    public final String toString() {
        AppMethodBeat.i(165153);
        String cXK = cXK();
        AppMethodBeat.o(165153);
        return cXK;
    }

    public final boolean isBlock() {
        return this.field_spamStatus == 1;
    }

    public final g cXM() {
        g gVar;
        AppMethodBeat.i(165154);
        try {
            Object clone = super.clone();
            if (clone == null) {
                t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.api.LocalFinderContact");
                AppMethodBeat.o(165154);
                throw tVar;
            }
            gVar = (g) clone;
            AppMethodBeat.o(165154);
            return gVar;
        } catch (Exception e2) {
            Log.printErrStackTrace("LocalFinderContact", e2, "", new Object[0]);
            Log.e("LocalFinderContact", "clone Contact error. e: ".concat(String.valueOf(e2)));
            gVar = null;
        }
    }

    public static /* synthetic */ as f(g gVar) {
        AppMethodBeat.i(242193);
        as asVar = new as();
        p.h(asVar, "contact");
        asVar.setNickname(gVar.getNickname());
        asVar.ao(com.tencent.mm.pluginsdk.ui.span.l.c(MMApplicationContext.getContext(), gVar.getNickname()));
        asVar.setUsername(gVar.getUsername());
        asVar.BV(gVar.field_signature);
        asVar.gMZ = gVar.systemRowid;
        asVar.no((int) (gVar.field_updateTime / 1000));
        asVar.BX(gVar.getCity());
        asVar.nj(gVar.ajE());
        asVar.BW(gVar.getProvince());
        AppMethodBeat.o(242193);
        return asVar;
    }
}

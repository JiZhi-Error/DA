package com.tencent.mm.plugin.appbrand.shortlink;

import android.app.Activity;
import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.internal.FacebookRequestErrorClassification;
import com.facebook.internal.NativeProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.shortlink.cgi.WxaShortLinkInfo;
import com.tencent.mm.plugin.appbrand.shortlink.cgi.a;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.tmassistantsdk.openSDK.OpenSDKTool4Assistant;
import java.util.regex.Pattern;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\n\b&\u0018\u0000 \"2\u00020\u0001:\u0002\"#B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H$J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0014J=\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2#\u0010\r\u001a\u001f\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\b\u0018\u00010\u000eH\u0002J;\u0010\u0013\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00142\u0006\u0010\u000b\u001a\u00020\f2!\u0010\u0015\u001a\u001d\u0012\u0013\u0012\u00110\u0016¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u00020\b0\u000eH$JG\u0010\u0018\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u00162#\u0010\r\u001a\u001f\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\b\u0018\u00010\u000eH\u0007J\u0018\u0010\u001c\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u001d\u001a\u00020\u001aH\u0014J \u0010\u001e\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u001d\u001a\u00020\u001a2\u0006\u0010\u0017\u001a\u00020\u0016H\u0014J\u0018\u0010\u001f\u001a\u00020\u00162\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\u0016H\u0014J\u0018\u0010 \u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u001d\u001a\u00020\u001aH\u0014J\u0018\u0010!\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u001d\u001a\u00020\u001aH\u0014¨\u0006$"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/shortlink/AbsWxaShortLinkLauncher;", "", "()V", "getBusinessType", "Lcom/tencent/mm/plugin/appbrand/shortlink/cgi/CgiCheckWxaShortLink$TYPE;", "getShortLinkCgiCache", "Lcom/tencent/mm/plugin/appbrand/shortlink/IShortLinkInfoCache;", "innerLaunch", "", "ctx", "Landroid/app/Activity;", NativeProtocol.WEB_DIALOG_PARAMS, "Lcom/tencent/mm/plugin/appbrand/shortlink/AbsWxaShortLinkLauncher$WxaShortLinkLaunchParams;", "resultCallback", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/appbrand/shortlink/WxaShortLinkLaunchErrorCode;", "Lkotlin/ParameterName;", "name", OpenSDKTool4Assistant.EXTRA_ERROR_CODE, "launch", "Landroid/content/Context;", "launchResultCallback", "", "success", "launchWithLink", "link", "", "showLaunchWxaTipDialog", "onDecodeLinkFailed", "url", "onLaunchDone", "onLinkDecodeDone", "onLinkIllegal", "onUserCancel", "Companion", "WxaShortLinkLaunchParams", "luggage-wechat-full-sdk_release"})
public abstract class AbsWxaShortLinkLauncher {
    public static final a nNA = new a((byte) 0);
    private static final Pattern nNz;

    /* access modifiers changed from: protected */
    public abstract void a(Context context, WxaShortLinkLaunchParams wxaShortLinkLaunchParams, kotlin.g.a.b<? super Boolean, x> bVar);

    /* access modifiers changed from: protected */
    public abstract a.b bVx();

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", "success", "", "invoke"})
    public static final class b extends q implements kotlin.g.a.b<Boolean, x> {
        final /* synthetic */ AbsWxaShortLinkLauncher nNB;
        final /* synthetic */ Activity nNC;
        final /* synthetic */ WxaShortLinkLaunchParams nND;
        final /* synthetic */ kotlin.g.a.b nNE;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(AbsWxaShortLinkLauncher absWxaShortLinkLauncher, Activity activity, WxaShortLinkLaunchParams wxaShortLinkLaunchParams, kotlin.g.a.b bVar) {
            super(1);
            this.nNB = absWxaShortLinkLauncher;
            this.nNC = activity;
            this.nND = wxaShortLinkLaunchParams;
            this.nNE = bVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(Boolean bool) {
            WxaShortLinkLaunchErrorCode wxaShortLinkLaunchErrorCode;
            AppMethodBeat.i(230167);
            boolean booleanValue = bool.booleanValue();
            AbsWxaShortLinkLauncher.e(this.nNC, this.nND.kHQ);
            kotlin.g.a.b bVar = this.nNE;
            if (bVar != null) {
                if (booleanValue) {
                    wxaShortLinkLaunchErrorCode = WxaShortLinkLaunchErrorCode.SUCCESS;
                } else {
                    wxaShortLinkLaunchErrorCode = WxaShortLinkLaunchErrorCode.LAUNCH_PHASE_FAIL;
                }
                bVar.invoke(wxaShortLinkLaunchErrorCode);
            }
            x xVar = x.SXb;
            AppMethodBeat.o(230167);
            return xVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\n¢\u0006\u0002\b\u0006"}, hxF = {"<no name provided>", "", "cgiSuccess", "", "info", "Lcom/tencent/mm/plugin/appbrand/shortlink/cgi/WxaShortLinkInfo;", "invoke"})
    static final class c extends q implements m<Boolean, WxaShortLinkInfo, x> {
        final /* synthetic */ AbsWxaShortLinkLauncher nNB;
        final /* synthetic */ Activity nNC;
        final /* synthetic */ kotlin.g.a.b nNE;
        final /* synthetic */ String nNF;
        final /* synthetic */ boolean nNG = true;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(AbsWxaShortLinkLauncher absWxaShortLinkLauncher, Activity activity, kotlin.g.a.b bVar, String str) {
            super(2);
            this.nNB = absWxaShortLinkLauncher;
            this.nNC = activity;
            this.nNE = bVar;
            this.nNF = str;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        /* JADX WARNING: Code restructure failed: missing block: B:13:0x0038, code lost:
            if (r3 != false) goto L_0x003a;
         */
        @Override // kotlin.g.a.m
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final /* synthetic */ kotlin.x invoke(java.lang.Boolean r7, com.tencent.mm.plugin.appbrand.shortlink.cgi.WxaShortLinkInfo r8) {
            /*
            // Method dump skipped, instructions count: 186
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.shortlink.AbsWxaShortLinkLauncher.c.invoke(java.lang.Object, java.lang.Object):java.lang.Object");
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
        static final class a extends q implements kotlin.g.a.a<x> {
            final /* synthetic */ Activity $context;
            final /* synthetic */ c nNH;
            final /* synthetic */ WxaShortLinkInfo nNI;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(c cVar, Activity activity, WxaShortLinkInfo wxaShortLinkInfo) {
                super(0);
                this.nNH = cVar;
                this.$context = activity;
                this.nNI = wxaShortLinkInfo;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ x invoke() {
                AppMethodBeat.i(230171);
                AbsWxaShortLinkLauncher.a(this.nNH.nNB, this.$context, new WxaShortLinkLaunchParams(this.nNI.appId, this.nNI.path, this.nNI.version, this.nNI.iOo, this.nNH.nNF), this.nNH.nNE);
                x xVar = x.SXb;
                AppMethodBeat.o(230171);
                return xVar;
            }
        }
    }

    public static final /* synthetic */ void a(AbsWxaShortLinkLauncher absWxaShortLinkLauncher, Activity activity, WxaShortLinkLaunchParams wxaShortLinkLaunchParams, kotlin.g.a.b bVar) {
        absWxaShortLinkLauncher.a(activity, wxaShortLinkLaunchParams, new b(absWxaShortLinkLauncher, activity, wxaShortLinkLaunchParams, bVar));
    }

    public final void a(Activity activity, String str, kotlin.g.a.b<? super WxaShortLinkLaunchErrorCode, x> bVar) {
        p.h(activity, "ctx");
        p.h(str, "link");
        c cVar = new c(this, activity, bVar, str);
        a bVy = bVy();
        WxaShortLinkInfo aeX = bVy != null ? bVy.aeX(str) : null;
        if (aeX != null) {
            Log.i("MicroMsg.AbsWxaShortLinkLauncher", "use cache for link:".concat(String.valueOf(str)));
            cVar.invoke(Boolean.TRUE, aeX);
        } else if (nNz.matcher(str).matches()) {
            new com.tencent.mm.plugin.appbrand.shortlink.cgi.a();
            com.tencent.mm.plugin.appbrand.shortlink.cgi.a.a(str, bVx(), cVar);
        } else {
            p.h(activity, "ctx");
            p.h(str, "url");
            bVar.invoke(WxaShortLinkLaunchErrorCode.ILLEGAL_LINK);
        }
    }

    protected static void d(Activity activity, String str) {
        p.h(activity, "ctx");
        p.h(str, "url");
    }

    protected static void e(Activity activity, String str) {
        p.h(activity, "ctx");
        p.h(str, "url");
    }

    protected static void f(Activity activity, String str) {
        p.h(activity, "ctx");
        p.h(str, "url");
    }

    /* access modifiers changed from: protected */
    public a bVy() {
        return null;
    }

    /* access modifiers changed from: protected */
    public boolean a(Activity activity, boolean z) {
        p.h(activity, "ctx");
        return true;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J;\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u0003HÆ\u0001J\t\u0010\u0017\u001a\u00020\u0006HÖ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bHÖ\u0003J\t\u0010\u001c\u001a\u00020\u0006HÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u0006HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000f¨\u0006#"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/shortlink/AbsWxaShortLinkLauncher$WxaShortLinkLaunchParams;", "Landroid/os/Parcelable;", "appId", "", "path", "version", "", "versionType", "shortLink", "(Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;)V", "getAppId", "()Ljava/lang/String;", "getPath", "getShortLink", "getVersion", "()I", "getVersionType", "component1", "component2", "component3", "component4", "component5", "copy", "describeContents", "equals", "", FacebookRequestErrorClassification.KEY_OTHER, "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "luggage-wechat-full-sdk_release"})
    public static final class WxaShortLinkLaunchParams implements Parcelable {
        public static final Parcelable.Creator CREATOR = new a();
        public final String appId;
        public final int iOo;
        public final String kHQ;
        public final String path;
        public final int version;

        @l(hxD = {1, 1, 16})
        public static class a implements Parcelable.Creator {
            @Override // android.os.Parcelable.Creator
            public final Object createFromParcel(Parcel parcel) {
                AppMethodBeat.i(230160);
                p.h(parcel, LocaleUtil.INDONESIAN_NEWNAME);
                WxaShortLinkLaunchParams wxaShortLinkLaunchParams = new WxaShortLinkLaunchParams(parcel.readString(), parcel.readString(), parcel.readInt(), parcel.readInt(), parcel.readString());
                AppMethodBeat.o(230160);
                return wxaShortLinkLaunchParams;
            }

            @Override // android.os.Parcelable.Creator
            public final Object[] newArray(int i2) {
                return new WxaShortLinkLaunchParams[i2];
            }
        }

        static {
            AppMethodBeat.i(230166);
            AppMethodBeat.o(230166);
        }

        public final int describeContents() {
            return 0;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:13:0x0036, code lost:
            if (kotlin.g.b.p.j(r3.kHQ, r4.kHQ) != false) goto L_0x0038;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean equals(java.lang.Object r4) {
            /*
                r3 = this;
                r2 = 230164(0x38314, float:3.22528E-40)
                com.tencent.matrix.trace.core.AppMethodBeat.i(r2)
                if (r3 == r4) goto L_0x0038
                boolean r0 = r4 instanceof com.tencent.mm.plugin.appbrand.shortlink.AbsWxaShortLinkLauncher.WxaShortLinkLaunchParams
                if (r0 == 0) goto L_0x003d
                com.tencent.mm.plugin.appbrand.shortlink.AbsWxaShortLinkLauncher$WxaShortLinkLaunchParams r4 = (com.tencent.mm.plugin.appbrand.shortlink.AbsWxaShortLinkLauncher.WxaShortLinkLaunchParams) r4
                java.lang.String r0 = r3.appId
                java.lang.String r1 = r4.appId
                boolean r0 = kotlin.g.b.p.j(r0, r1)
                if (r0 == 0) goto L_0x003d
                java.lang.String r0 = r3.path
                java.lang.String r1 = r4.path
                boolean r0 = kotlin.g.b.p.j(r0, r1)
                if (r0 == 0) goto L_0x003d
                int r0 = r3.version
                int r1 = r4.version
                if (r0 != r1) goto L_0x003d
                int r0 = r3.iOo
                int r1 = r4.iOo
                if (r0 != r1) goto L_0x003d
                java.lang.String r0 = r3.kHQ
                java.lang.String r1 = r4.kHQ
                boolean r0 = kotlin.g.b.p.j(r0, r1)
                if (r0 == 0) goto L_0x003d
            L_0x0038:
                r0 = 1
                com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
            L_0x003c:
                return r0
            L_0x003d:
                r0 = 0
                com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
                goto L_0x003c
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.shortlink.AbsWxaShortLinkLauncher.WxaShortLinkLaunchParams.equals(java.lang.Object):boolean");
        }

        public final int hashCode() {
            int i2 = 0;
            AppMethodBeat.i(230163);
            String str = this.appId;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            String str2 = this.path;
            int hashCode2 = ((((((str2 != null ? str2.hashCode() : 0) + hashCode) * 31) + this.version) * 31) + this.iOo) * 31;
            String str3 = this.kHQ;
            if (str3 != null) {
                i2 = str3.hashCode();
            }
            int i3 = hashCode2 + i2;
            AppMethodBeat.o(230163);
            return i3;
        }

        public final String toString() {
            AppMethodBeat.i(230162);
            String str = "WxaShortLinkLaunchParams(appId=" + this.appId + ", path=" + this.path + ", version=" + this.version + ", versionType=" + this.iOo + ", shortLink=" + this.kHQ + ")";
            AppMethodBeat.o(230162);
            return str;
        }

        public final void writeToParcel(Parcel parcel, int i2) {
            AppMethodBeat.i(230165);
            p.h(parcel, "parcel");
            parcel.writeString(this.appId);
            parcel.writeString(this.path);
            parcel.writeInt(this.version);
            parcel.writeInt(this.iOo);
            parcel.writeString(this.kHQ);
            AppMethodBeat.o(230165);
        }

        public WxaShortLinkLaunchParams(String str, String str2, int i2, int i3, String str3) {
            p.h(str, "appId");
            p.h(str2, "path");
            p.h(str3, "shortLink");
            AppMethodBeat.i(230161);
            this.appId = str;
            this.path = str2;
            this.version = i2;
            this.iOo = i3;
            this.kHQ = str3;
            AppMethodBeat.o(230161);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bXT¢\u0006\u0002\n\u0000¨\u0006\t"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/shortlink/AbsWxaShortLinkLauncher$Companion;", "", "()V", "SHORT_LINK_SCHEME_PATTERN", "Ljava/util/regex/Pattern;", "getSHORT_LINK_SCHEME_PATTERN", "()Ljava/util/regex/Pattern;", "TAG", "", "luggage-wechat-full-sdk_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        Pattern compile = Pattern.compile("^mp://\\w+");
        p.g(compile, "Pattern.compile(\"^$SHORT_LINK_SCHEME\\\\w+\")");
        nNz = compile;
    }
}

package com.tencent.mm.plugin.appbrand.dynamic;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelappbrand.u;
import com.tencent.mm.plugin.appbrand.appcache.WxaCommLibRuntimeReader;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.dynamic.debugger.DebuggerInfo;
import com.tencent.mm.plugin.appbrand.dynamic.j.d;
import com.tencent.mm.plugin.appbrand.dynamic.launching.WidgetRuntimeConfig;
import com.tencent.mm.plugin.appbrand.dynamic.launching.WidgetSysConfig;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiShowImageOperateSheet;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import junit.framework.Assert;

public final class WxaWidgetInitializer {

    public interface a {
        void a(String str, String str2, boolean z, WxaWidgetContext wxaWidgetContext);

        void cX(String str, String str2);
    }

    static WxaWidgetContextImpl a(String str, String str2, WxaPkgWrappingInfo wxaPkgWrappingInfo, d dVar) {
        int i2 = 1;
        AppMethodBeat.i(121205);
        Log.i("MicroMsg.WxaWidgetInitializer", "prepare(%s)", str);
        u.i("MicroMsg.WxaWidgetInitializer", "prepare(%s)", str);
        WxaPkgWrappingInfo bvX = WxaCommLibRuntimeReader.bvX();
        if (bvX == null) {
            Log.e("MicroMsg.WxaWidgetInitializer", "getLibPkgInfo return null.");
            AppMethodBeat.o(121205);
            return null;
        }
        WxaWidgetContextImpl wxaWidgetContextImpl = new WxaWidgetContextImpl(bvX, wxaPkgWrappingInfo);
        wxaWidgetContextImpl.gIx = str;
        wxaWidgetContextImpl.mAppId = str2;
        wxaWidgetContextImpl.lmw = dVar.lps;
        if (wxaWidgetContextImpl.lmw == null) {
            wxaWidgetContextImpl.lmw = new DebuggerInfo();
        }
        wxaWidgetContextImpl.lmx = dVar.lpt;
        wxaWidgetContextImpl.lmy = dVar.lpu;
        try {
            wxaWidgetContextImpl.lmu = (dVar.lpw == null || dVar.lpw.LjS == null) ? new byte[0] : dVar.lpw.LjS.toByteArray();
        } catch (Exception e2) {
            Log.e("MicroMsg.WxaWidgetInitializer", Util.stackTraceToString(e2));
        }
        if (wxaWidgetContextImpl.lmw.lnd) {
            wxaWidgetContextImpl.lmv = 2;
            f.bBJ().bF(str, 2101);
            j.bBN().P(str, JsApiShowImageOperateSheet.CTRL_INDEX, 5);
        } else {
            if (dVar.lpv != null) {
                i2 = dVar.lpv.KCD;
            }
            wxaWidgetContextImpl.lmv = i2;
        }
        AppMethodBeat.o(121205);
        return wxaWidgetContextImpl;
    }

    public static String da(String str, String str2) {
        AppMethodBeat.i(121206);
        String str3 = str + "#" + str2 + "#" + System.currentTimeMillis();
        AppMethodBeat.o(121206);
        return str3;
    }

    /* access modifiers changed from: package-private */
    public static class WxaWidgetContextImpl implements WxaWidgetContext {
        public static final Parcelable.Creator<WxaWidgetContextImpl> CREATOR = new Parcelable.Creator<WxaWidgetContextImpl>() {
            /* class com.tencent.mm.plugin.appbrand.dynamic.WxaWidgetInitializer.WxaWidgetContextImpl.AnonymousClass1 */

            /* Return type fixed from 'java.lang.Object[]' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ WxaWidgetContextImpl[] newArray(int i2) {
                return new WxaWidgetContextImpl[i2];
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ WxaWidgetContextImpl createFromParcel(Parcel parcel) {
                AppMethodBeat.i(121200);
                WxaWidgetContextImpl wxaWidgetContextImpl = new WxaWidgetContextImpl(parcel);
                AppMethodBeat.o(121200);
                return wxaWidgetContextImpl;
            }
        };
        String gIx;
        WxaPkgWrappingInfo lms;
        WxaPkgWrappingInfo lmt;
        byte[] lmu;
        int lmv;
        DebuggerInfo lmw;
        WidgetSysConfig lmx;
        WidgetRuntimeConfig lmy;
        String mAppId;

        public WxaWidgetContextImpl(Parcel parcel) {
            AppMethodBeat.i(121201);
            ClassLoader classLoader = getClass().getClassLoader();
            this.gIx = parcel.readString();
            this.mAppId = parcel.readString();
            this.lmt = (WxaPkgWrappingInfo) parcel.readParcelable(classLoader);
            this.lms = (WxaPkgWrappingInfo) parcel.readParcelable(classLoader);
            this.lmu = parcel.createByteArray();
            this.lmv = parcel.readInt();
            this.lmw = (DebuggerInfo) parcel.readParcelable(classLoader);
            this.lmx = (WidgetSysConfig) parcel.readParcelable(classLoader);
            this.lmy = (WidgetRuntimeConfig) parcel.readParcelable(classLoader);
            AppMethodBeat.o(121201);
        }

        public WxaWidgetContextImpl(WxaPkgWrappingInfo wxaPkgWrappingInfo, WxaPkgWrappingInfo wxaPkgWrappingInfo2) {
            AppMethodBeat.i(121202);
            Assert.assertNotNull(wxaPkgWrappingInfo);
            Assert.assertNotNull(wxaPkgWrappingInfo2);
            this.lmt = wxaPkgWrappingInfo;
            this.lms = wxaPkgWrappingInfo2;
            AppMethodBeat.o(121202);
        }

        @Override // com.tencent.mm.plugin.appbrand.dynamic.WxaWidgetContext
        public final WxaPkgWrappingInfo bBO() {
            return this.lms;
        }

        @Override // com.tencent.mm.plugin.appbrand.dynamic.WxaWidgetContext
        public final WxaPkgWrappingInfo bBP() {
            return this.lmt;
        }

        @Override // com.tencent.mm.plugin.appbrand.dynamic.WxaWidgetContext
        public final String getId() {
            return this.gIx;
        }

        @Override // com.tencent.mm.plugin.appbrand.dynamic.WxaWidgetContext
        public final String getAppId() {
            return this.mAppId;
        }

        @Override // com.tencent.mm.plugin.appbrand.dynamic.WxaWidgetContext
        public final int bvh() {
            if (this.lms != null) {
                return this.lms.kNW;
            }
            return 0;
        }

        @Override // com.tencent.mm.plugin.appbrand.dynamic.WxaWidgetContext
        public final int bBQ() {
            if (this.lms != null) {
                return this.lms.pkgVersion;
            }
            return 0;
        }

        @Override // com.tencent.mm.plugin.appbrand.dynamic.WxaWidgetContext
        public final byte[] bBR() {
            return this.lmu;
        }

        @Override // com.tencent.mm.plugin.appbrand.dynamic.WxaWidgetContext
        public final int bBS() {
            return this.lmv;
        }

        @Override // com.tencent.mm.plugin.appbrand.dynamic.WxaWidgetContext
        public final DebuggerInfo bBT() {
            return this.lmw;
        }

        @Override // com.tencent.mm.plugin.appbrand.dynamic.WxaWidgetContext
        public final WidgetSysConfig bBU() {
            return this.lmx;
        }

        @Override // com.tencent.mm.plugin.appbrand.dynamic.WxaWidgetContext
        public final WidgetRuntimeConfig bBV() {
            return this.lmy;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i2) {
            AppMethodBeat.i(121203);
            parcel.writeString(this.gIx);
            parcel.writeString(this.mAppId);
            parcel.writeParcelable(this.lmt, i2);
            parcel.writeParcelable(this.lms, i2);
            parcel.writeByteArray(this.lmu);
            parcel.writeInt(this.lmv);
            parcel.writeParcelable(this.lmw, i2);
            parcel.writeParcelable(this.lmx, i2);
            parcel.writeParcelable(this.lmy, i2);
            AppMethodBeat.o(121203);
        }

        static {
            AppMethodBeat.i(121204);
            AppMethodBeat.o(121204);
        }
    }
}

package com.tencent.mm.plugin.appbrand.config;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.internal.FacebookRequestErrorClassification;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u0000 )2\u00020\u0001:\u0005%&'()B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004BO\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\u0006\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\u0006\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0011¢\u0006\u0002\u0010\u0012J\b\u0010\u0015\u001a\u00020\bH\u0016J1\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u00182!\u0010\u0019\u001a\u001d\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(\u001d\u0012\u0004\u0012\u00020\b0\u001aJ\u0006\u0010\u001e\u001a\u00020\u001fJ\b\u0010 \u001a\u00020!H\u0016J\u0018\u0010\"\u001a\u00020#2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010$\u001a\u00020\bH\u0016R\u0010\u0010\n\u001a\u00020\u000b8\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u00020\u000e8\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u00020\u00068\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u00020\u00118\u0006X\u0004¢\u0006\u0002\n\u0000R\u0013\u0010\u0005\u001a\u00020\u00068G¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0010\u0010\u000f\u001a\u00020\u00068\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u00020\b8\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u00020\u00068\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006*"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/config/HalfScreenConfig;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "enable", "", "height", "", "hideCapsuleHomeButton", "activityAnimStyle", "Lcom/tencent/mm/plugin/appbrand/config/HalfScreenConfig$ActivityAnimationStyle;", "closeWhenClickEmptyArea", "bgShapeConf", "Lcom/tencent/mm/plugin/appbrand/config/HalfScreenConfig$BackgroundShapeConfig;", "forceLightMode", "closeWhenClickEmptyAreaConfig", "Lcom/tencent/mm/plugin/appbrand/config/HalfScreenConfig$CloseWhenClickEmptyAreaConfig;", "(ZIZLcom/tencent/mm/plugin/appbrand/config/HalfScreenConfig$ActivityAnimationStyle;ZLcom/tencent/mm/plugin/appbrand/config/HalfScreenConfig$BackgroundShapeConfig;ZLcom/tencent/mm/plugin/appbrand/config/HalfScreenConfig$CloseWhenClickEmptyAreaConfig;)V", "isEnable", "()Z", "describeContents", "performCloseHalfScreen", EnvConsts.ACTIVITY_MANAGER_SRVNAME, "Landroid/app/Activity;", "toAnimationRes", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE, "toBuilder", "Lcom/tencent/mm/plugin/appbrand/config/HalfScreenConfig$Builder;", "toString", "", "writeToParcel", "", "flags", "ActivityAnimationStyle", "BackgroundShapeConfig", "Builder", "CloseWhenClickEmptyAreaConfig", "Companion", "data-model_release"})
public final class HalfScreenConfig implements Parcelable {
    public static final Parcelable.Creator<HalfScreenConfig> CREATOR = new d();
    public static final HalfScreenConfig lfr = new HalfScreenConfig(false, 0, false, null, false, null, false, null, 248);
    public static final c lfs = new c((byte) 0);
    private final boolean enable;
    public final int height;
    public final boolean kuZ;
    public final boolean lfm;
    public final a lfn;
    public final boolean lfo;
    public final BackgroundShapeConfig lfp;
    public final CloseWhenClickEmptyAreaConfig lfq;

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/config/HalfScreenConfig$ActivityAnimationStyle;", "", "(Ljava/lang/String;I)V", "POPUP", "SLIDE", "data-model_release"})
    public enum a {
        POPUP,
        SLIDE;

        static {
            AppMethodBeat.i(225248);
            AppMethodBeat.o(225248);
        }

        public static a valueOf(String str) {
            AppMethodBeat.i(225250);
            a aVar = (a) Enum.valueOf(a.class, str);
            AppMethodBeat.o(225250);
            return aVar;
        }
    }

    public HalfScreenConfig(boolean z, int i2, boolean z2, a aVar, boolean z3, BackgroundShapeConfig backgroundShapeConfig, boolean z4, CloseWhenClickEmptyAreaConfig closeWhenClickEmptyAreaConfig) {
        p.h(aVar, "activityAnimStyle");
        p.h(backgroundShapeConfig, "bgShapeConf");
        p.h(closeWhenClickEmptyAreaConfig, "closeWhenClickEmptyAreaConfig");
        AppMethodBeat.i(225271);
        this.height = i2;
        this.lfm = z2;
        this.lfn = aVar;
        this.lfo = z3;
        this.lfp = backgroundShapeConfig;
        this.kuZ = z4;
        this.lfq = closeWhenClickEmptyAreaConfig;
        this.enable = z;
        AppMethodBeat.o(225271);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ HalfScreenConfig(boolean r11, int r12, boolean r13, com.tencent.mm.plugin.appbrand.config.HalfScreenConfig.a r14, boolean r15, com.tencent.mm.plugin.appbrand.config.HalfScreenConfig.BackgroundShapeConfig r16, boolean r17, com.tencent.mm.plugin.appbrand.config.HalfScreenConfig.CloseWhenClickEmptyAreaConfig r18, int r19) {
        /*
            r10 = this;
            r1 = r19 & 8
            if (r1 == 0) goto L_0x003d
            com.tencent.mm.plugin.appbrand.config.HalfScreenConfig$a r5 = com.tencent.mm.plugin.appbrand.config.HalfScreenConfig.a.POPUP
        L_0x0006:
            r1 = r19 & 16
            if (r1 == 0) goto L_0x003b
            r6 = 0
        L_0x000b:
            r1 = r19 & 32
            if (r1 == 0) goto L_0x0038
            com.tencent.mm.plugin.appbrand.config.HalfScreenConfig$BackgroundShapeConfig r7 = com.tencent.mm.plugin.appbrand.config.HalfScreenConfig.BackgroundShapeConfig.lfA
        L_0x0011:
            r1 = r19 & 64
            if (r1 == 0) goto L_0x0035
            r8 = 0
        L_0x0016:
            r0 = r19
            r1 = r0 & 128(0x80, float:1.794E-43)
            if (r1 == 0) goto L_0x0032
            com.tencent.mm.plugin.appbrand.config.HalfScreenConfig$CloseWhenClickEmptyAreaConfig r9 = com.tencent.mm.plugin.appbrand.config.HalfScreenConfig.CloseWhenClickEmptyAreaConfig.lfE
        L_0x001e:
            r1 = r10
            r2 = r11
            r3 = r12
            r4 = r13
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9)
            r1 = 225272(0x36ff8, float:3.15673E-40)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r1)
            r1 = 225272(0x36ff8, float:3.15673E-40)
            com.tencent.matrix.trace.core.AppMethodBeat.o(r1)
            return
        L_0x0032:
            r9 = r18
            goto L_0x001e
        L_0x0035:
            r8 = r17
            goto L_0x0016
        L_0x0038:
            r7 = r16
            goto L_0x0011
        L_0x003b:
            r6 = r15
            goto L_0x000b
        L_0x003d:
            r5 = r14
            goto L_0x0006
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.config.HalfScreenConfig.<init>(boolean, int, boolean, com.tencent.mm.plugin.appbrand.config.HalfScreenConfig$a, boolean, com.tencent.mm.plugin.appbrand.config.HalfScreenConfig$BackgroundShapeConfig, boolean, com.tencent.mm.plugin.appbrand.config.HalfScreenConfig$CloseWhenClickEmptyAreaConfig, int):void");
    }

    public final boolean isEnable() {
        return this.enable && this.height > 0;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public HalfScreenConfig(android.os.Parcel r11) {
        /*
        // Method dump skipped, instructions count: 113
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.config.HalfScreenConfig.<init>(android.os.Parcel):void");
    }

    public final String toString() {
        AppMethodBeat.i(225269);
        String str = "HalfScreenConfig(enable=" + isEnable() + ", height=" + this.height + ", hideCapsuleHomeButton=" + this.lfm + ", closeWhenClickEmptyArea=" + this.lfo + ", forceLightMode=" + this.kuZ + ')';
        AppMethodBeat.o(225269);
        return str;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        byte b2;
        byte b3;
        byte b4 = 1;
        AppMethodBeat.i(225270);
        p.h(parcel, "parcel");
        parcel.writeInt(isEnable() ? 1 : 0);
        parcel.writeInt(this.height);
        if (this.lfm) {
            b2 = 1;
        } else {
            b2 = 0;
        }
        parcel.writeByte(b2);
        parcel.writeString(this.lfn.name());
        if (this.lfo) {
            b3 = 1;
        } else {
            b3 = 0;
        }
        parcel.writeByte(b3);
        parcel.writeParcelable(this.lfp, i2);
        if (!this.kuZ) {
            b4 = 0;
        }
        parcel.writeByte(b4);
        parcel.writeParcelable(this.lfq, i2);
        AppMethodBeat.o(225270);
    }

    public final int describeContents() {
        return 0;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u00058\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/config/HalfScreenConfig$Companion;", "", "()V", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/appbrand/config/HalfScreenConfig;", "DUMMY", "data-model_release"})
    public static final class c {
        private c() {
        }

        public /* synthetic */ c(byte b2) {
            this();
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u001d\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¢\u0006\u0002\u0010\n¨\u0006\u000b"}, hxF = {"com/tencent/mm/plugin/appbrand/config/HalfScreenConfig$Companion$CREATOR$1", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/appbrand/config/HalfScreenConfig;", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/appbrand/config/HalfScreenConfig;", "data-model_release"})
    public static final class d implements Parcelable.Creator<HalfScreenConfig> {
        d() {
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ HalfScreenConfig createFromParcel(Parcel parcel) {
            AppMethodBeat.i(225268);
            p.h(parcel, "parcel");
            HalfScreenConfig halfScreenConfig = new HalfScreenConfig(parcel);
            AppMethodBeat.o(225268);
            return halfScreenConfig;
        }

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ HalfScreenConfig[] newArray(int i2) {
            return new HalfScreenConfig[i2];
        }
    }

    static {
        AppMethodBeat.i(225274);
        AppMethodBeat.o(225274);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0004J\u000e\u0010\u0005\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0006J\u0006\u0010\u0010\u001a\u00020\u0011J\u000e\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010\t\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\nJ\u000e\u0010\u000b\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\bJ\u000e\u0010\f\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\bJ\u000e\u0010\r\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\u000eJ\u000e\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\bR\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/config/HalfScreenConfig$Builder;", "", "()V", "activityAnimStyle", "Lcom/tencent/mm/plugin/appbrand/config/HalfScreenConfig$ActivityAnimationStyle;", "bgShapeConf", "Lcom/tencent/mm/plugin/appbrand/config/HalfScreenConfig$BackgroundShapeConfig;", "closeWhenClickEmptyArea", "", "closeWhenClickEmptyAreaConfig", "Lcom/tencent/mm/plugin/appbrand/config/HalfScreenConfig$CloseWhenClickEmptyAreaConfig;", "enable", "forceLightMode", "height", "", "hideCapsuleHomeButton", "build", "Lcom/tencent/mm/plugin/appbrand/config/HalfScreenConfig;", "data-model_release"})
    public static final class b {
        public boolean enable;
        public int height;
        public boolean kuZ;
        public boolean lfm;
        public a lfn = a.POPUP;
        public boolean lfo;
        public BackgroundShapeConfig lfp = BackgroundShapeConfig.lfA;
        public CloseWhenClickEmptyAreaConfig lfq = CloseWhenClickEmptyAreaConfig.lfE;

        public final b a(CloseWhenClickEmptyAreaConfig closeWhenClickEmptyAreaConfig) {
            AppMethodBeat.i(225259);
            p.h(closeWhenClickEmptyAreaConfig, "closeWhenClickEmptyAreaConfig");
            this.lfq = closeWhenClickEmptyAreaConfig;
            b bVar = this;
            AppMethodBeat.o(225259);
            return bVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0014\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\b\u0018\u0000 '2\u00020\u0001:\u0001'B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B7\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\b\b\u0002\u0010\n\u001a\u00020\b\u0012\b\b\u0002\u0010\u000b\u001a\u00020\b¢\u0006\u0002\u0010\fJ\t\u0010\u0014\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0015\u001a\u00020\bHÆ\u0003J\t\u0010\u0016\u001a\u00020\bHÆ\u0003J\t\u0010\u0017\u001a\u00020\bHÆ\u0003J\t\u0010\u0018\u001a\u00020\bHÆ\u0003J;\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\bHÆ\u0001J\b\u0010\u001a\u001a\u00020\u001bH\u0016J\u0013\u0010\u001c\u001a\u00020\b2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eHÖ\u0003J\u0006\u0010\u001f\u001a\u00020 J\t\u0010!\u001a\u00020\u001bHÖ\u0001J\t\u0010\"\u001a\u00020#HÖ\u0001J\u0018\u0010$\u001a\u00020%2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010&\u001a\u00020\u001bH\u0016R\u0011\u0010\n\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u000b\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000eR\u0011\u0010\t\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000e¨\u0006("}, hxF = {"Lcom/tencent/mm/plugin/appbrand/config/HalfScreenConfig$BackgroundShapeConfig;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "cornerRadius", "", "topLeft", "", "topRight", "bottomLeft", "bottomRight", "(FZZZZ)V", "getBottomLeft", "()Z", "getBottomRight", "getCornerRadius", "()F", "getTopLeft", "getTopRight", "component1", "component2", "component3", "component4", "component5", "copy", "describeContents", "", "equals", FacebookRequestErrorClassification.KEY_OTHER, "", "getRadiusArray", "", "hashCode", "toString", "", "writeToParcel", "", "flags", "Companion", "data-model_release"})
    public static final class BackgroundShapeConfig implements Parcelable {
        public static final Parcelable.Creator<BackgroundShapeConfig> CREATOR = new b();
        public static final BackgroundShapeConfig lfA = new BackgroundShapeConfig(0.0f, false, false, 31);
        public static final a lfB = new a((byte) 0);
        public final boolean lfw;
        public final boolean lfx;
        public final boolean lfy;
        public final boolean lfz;
        public final float tt;

        public BackgroundShapeConfig() {
            this(0.0f, false, false, 31);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:13:0x002e, code lost:
            if (r3.lfz == r4.lfz) goto L_0x0030;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean equals(java.lang.Object r4) {
            /*
                r3 = this;
                r2 = 225258(0x36fea, float:3.15654E-40)
                com.tencent.matrix.trace.core.AppMethodBeat.i(r2)
                if (r3 == r4) goto L_0x0030
                boolean r0 = r4 instanceof com.tencent.mm.plugin.appbrand.config.HalfScreenConfig.BackgroundShapeConfig
                if (r0 == 0) goto L_0x0035
                com.tencent.mm.plugin.appbrand.config.HalfScreenConfig$BackgroundShapeConfig r4 = (com.tencent.mm.plugin.appbrand.config.HalfScreenConfig.BackgroundShapeConfig) r4
                float r0 = r3.tt
                float r1 = r4.tt
                int r0 = java.lang.Float.compare(r0, r1)
                if (r0 != 0) goto L_0x0035
                boolean r0 = r3.lfw
                boolean r1 = r4.lfw
                if (r0 != r1) goto L_0x0035
                boolean r0 = r3.lfx
                boolean r1 = r4.lfx
                if (r0 != r1) goto L_0x0035
                boolean r0 = r3.lfy
                boolean r1 = r4.lfy
                if (r0 != r1) goto L_0x0035
                boolean r0 = r3.lfz
                boolean r1 = r4.lfz
                if (r0 != r1) goto L_0x0035
            L_0x0030:
                r0 = 1
                com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
            L_0x0034:
                return r0
            L_0x0035:
                r0 = 0
                com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
                goto L_0x0034
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.config.HalfScreenConfig.BackgroundShapeConfig.equals(java.lang.Object):boolean");
        }

        public final int hashCode() {
            int i2 = 1;
            AppMethodBeat.i(225257);
            int floatToIntBits = Float.floatToIntBits(this.tt) * 31;
            boolean z = this.lfw;
            if (z) {
                z = true;
            }
            int i3 = z ? 1 : 0;
            int i4 = z ? 1 : 0;
            int i5 = z ? 1 : 0;
            int i6 = (i3 + floatToIntBits) * 31;
            boolean z2 = this.lfx;
            if (z2) {
                z2 = true;
            }
            int i7 = z2 ? 1 : 0;
            int i8 = z2 ? 1 : 0;
            int i9 = z2 ? 1 : 0;
            int i10 = (i7 + i6) * 31;
            boolean z3 = this.lfy;
            if (z3) {
                z3 = true;
            }
            int i11 = z3 ? 1 : 0;
            int i12 = z3 ? 1 : 0;
            int i13 = z3 ? 1 : 0;
            int i14 = (i11 + i10) * 31;
            boolean z4 = this.lfz;
            if (!z4) {
                i2 = z4 ? 1 : 0;
            }
            int i15 = i14 + i2;
            AppMethodBeat.o(225257);
            return i15;
        }

        public final String toString() {
            AppMethodBeat.i(225256);
            String str = "BackgroundShapeConfig(cornerRadius=" + this.tt + ", topLeft=" + this.lfw + ", topRight=" + this.lfx + ", bottomLeft=" + this.lfy + ", bottomRight=" + this.lfz + ")";
            AppMethodBeat.o(225256);
            return str;
        }

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public /* synthetic */ BackgroundShapeConfig(float r8, boolean r9, boolean r10, int r11) {
            /*
                r7 = this;
                r6 = 225253(0x36fe5, float:3.15647E-40)
                r4 = 0
                r0 = r11 & 1
                if (r0 == 0) goto L_0x0023
                r1 = 0
            L_0x0009:
                r0 = r11 & 2
                if (r0 == 0) goto L_0x0021
                r2 = r4
            L_0x000e:
                r0 = r11 & 4
                if (r0 == 0) goto L_0x001f
                r3 = r4
            L_0x0013:
                r0 = r7
                r5 = r4
                r0.<init>(r1, r2, r3, r4, r5)
                com.tencent.matrix.trace.core.AppMethodBeat.i(r6)
                com.tencent.matrix.trace.core.AppMethodBeat.o(r6)
                return
            L_0x001f:
                r3 = r10
                goto L_0x0013
            L_0x0021:
                r2 = r9
                goto L_0x000e
            L_0x0023:
                r1 = r8
                goto L_0x0009
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.config.HalfScreenConfig.BackgroundShapeConfig.<init>(float, boolean, boolean, int):void");
        }

        private BackgroundShapeConfig(float f2, boolean z, boolean z2, boolean z3, boolean z4) {
            this.tt = f2;
            this.lfw = z;
            this.lfx = z2;
            this.lfy = z3;
            this.lfz = z4;
        }

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public BackgroundShapeConfig(android.os.Parcel r9) {
            /*
                r8 = this;
                r7 = 225254(0x36fe6, float:3.15648E-40)
                r0 = 1
                r5 = 0
                java.lang.String r1 = "parcel"
                kotlin.g.b.p.h(r9, r1)
                float r1 = r9.readFloat()
                byte r2 = r9.readByte()
                if (r2 == 0) goto L_0x0036
                r2 = r0
            L_0x0016:
                byte r3 = r9.readByte()
                if (r3 == 0) goto L_0x0038
                r3 = r0
            L_0x001d:
                byte r4 = r9.readByte()
                if (r4 == 0) goto L_0x003a
                r4 = r0
            L_0x0024:
                byte r6 = r9.readByte()
                if (r6 == 0) goto L_0x002b
                r5 = r0
            L_0x002b:
                r0 = r8
                r0.<init>(r1, r2, r3, r4, r5)
                com.tencent.matrix.trace.core.AppMethodBeat.i(r7)
                com.tencent.matrix.trace.core.AppMethodBeat.o(r7)
                return
            L_0x0036:
                r2 = r5
                goto L_0x0016
            L_0x0038:
                r3 = r5
                goto L_0x001d
            L_0x003a:
                r4 = r5
                goto L_0x0024
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.config.HalfScreenConfig.BackgroundShapeConfig.<init>(android.os.Parcel):void");
        }

        public final void writeToParcel(Parcel parcel, int i2) {
            byte b2;
            byte b3;
            byte b4;
            byte b5 = 1;
            AppMethodBeat.i(225252);
            p.h(parcel, "parcel");
            parcel.writeFloat(this.tt);
            if (this.lfw) {
                b2 = 1;
            } else {
                b2 = 0;
            }
            parcel.writeByte(b2);
            if (this.lfx) {
                b3 = 1;
            } else {
                b3 = 0;
            }
            parcel.writeByte(b3);
            if (this.lfy) {
                b4 = 1;
            } else {
                b4 = 0;
            }
            parcel.writeByte(b4);
            if (!this.lfz) {
                b5 = 0;
            }
            parcel.writeByte(b5);
            AppMethodBeat.o(225252);
        }

        public final int describeContents() {
            return 0;
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u00058\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/config/HalfScreenConfig$BackgroundShapeConfig$Companion;", "", "()V", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/appbrand/config/HalfScreenConfig$BackgroundShapeConfig;", "DUMMY", "data-model_release"})
        public static final class a {
            private a() {
            }

            public /* synthetic */ a(byte b2) {
                this();
            }
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u001d\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¢\u0006\u0002\u0010\n¨\u0006\u000b"}, hxF = {"com/tencent/mm/plugin/appbrand/config/HalfScreenConfig$BackgroundShapeConfig$Companion$CREATOR$1", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/appbrand/config/HalfScreenConfig$BackgroundShapeConfig;", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/appbrand/config/HalfScreenConfig$BackgroundShapeConfig;", "data-model_release"})
        public static final class b implements Parcelable.Creator<BackgroundShapeConfig> {
            b() {
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ BackgroundShapeConfig createFromParcel(Parcel parcel) {
                AppMethodBeat.i(225251);
                p.h(parcel, "parcel");
                BackgroundShapeConfig backgroundShapeConfig = new BackgroundShapeConfig(parcel);
                AppMethodBeat.o(225251);
                return backgroundShapeConfig;
            }

            /* Return type fixed from 'java.lang.Object[]' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ BackgroundShapeConfig[] newArray(int i2) {
                return new BackgroundShapeConfig[i2];
            }
        }

        static {
            AppMethodBeat.i(225255);
            AppMethodBeat.o(225255);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\b\b\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0017\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\t\u0010\u000e\u001a\u00020\u0006HÆ\u0003J\t\u0010\u000f\u001a\u00020\bHÆ\u0003J\u001d\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0006HÖ\u0001J\u0018\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u0012H\u0016R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u001d"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/config/HalfScreenConfig$CloseWhenClickEmptyAreaConfig;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "activityClassName", "", "closeAnimStyle", "Lcom/tencent/mm/plugin/appbrand/config/HalfScreenConfig$ActivityAnimationStyle;", "(Ljava/lang/String;Lcom/tencent/mm/plugin/appbrand/config/HalfScreenConfig$ActivityAnimationStyle;)V", "getActivityClassName", "()Ljava/lang/String;", "getCloseAnimStyle", "()Lcom/tencent/mm/plugin/appbrand/config/HalfScreenConfig$ActivityAnimationStyle;", "component1", "component2", "copy", "describeContents", "", "equals", "", FacebookRequestErrorClassification.KEY_OTHER, "", "hashCode", "toString", "writeToParcel", "", "flags", "Companion", "data-model_release"})
    public static final class CloseWhenClickEmptyAreaConfig implements Parcelable {
        public static final Parcelable.Creator<CloseWhenClickEmptyAreaConfig> CREATOR = new b();
        public static final CloseWhenClickEmptyAreaConfig lfE = new CloseWhenClickEmptyAreaConfig("", a.POPUP);
        public static final a lfF = new a((byte) 0);
        public final String lfC;
        public final a lfD;

        /* JADX WARNING: Code restructure failed: missing block: B:7:0x0020, code lost:
            if (kotlin.g.b.p.j(r3.lfD, r4.lfD) != false) goto L_0x0022;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean equals(java.lang.Object r4) {
            /*
                r3 = this;
                r2 = 225267(0x36ff3, float:3.15666E-40)
                com.tencent.matrix.trace.core.AppMethodBeat.i(r2)
                if (r3 == r4) goto L_0x0022
                boolean r0 = r4 instanceof com.tencent.mm.plugin.appbrand.config.HalfScreenConfig.CloseWhenClickEmptyAreaConfig
                if (r0 == 0) goto L_0x0027
                com.tencent.mm.plugin.appbrand.config.HalfScreenConfig$CloseWhenClickEmptyAreaConfig r4 = (com.tencent.mm.plugin.appbrand.config.HalfScreenConfig.CloseWhenClickEmptyAreaConfig) r4
                java.lang.String r0 = r3.lfC
                java.lang.String r1 = r4.lfC
                boolean r0 = kotlin.g.b.p.j(r0, r1)
                if (r0 == 0) goto L_0x0027
                com.tencent.mm.plugin.appbrand.config.HalfScreenConfig$a r0 = r3.lfD
                com.tencent.mm.plugin.appbrand.config.HalfScreenConfig$a r1 = r4.lfD
                boolean r0 = kotlin.g.b.p.j(r0, r1)
                if (r0 == 0) goto L_0x0027
            L_0x0022:
                r0 = 1
                com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
            L_0x0026:
                return r0
            L_0x0027:
                r0 = 0
                com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
                goto L_0x0026
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.config.HalfScreenConfig.CloseWhenClickEmptyAreaConfig.equals(java.lang.Object):boolean");
        }

        public final int hashCode() {
            int i2 = 0;
            AppMethodBeat.i(225266);
            String str = this.lfC;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            a aVar = this.lfD;
            if (aVar != null) {
                i2 = aVar.hashCode();
            }
            int i3 = hashCode + i2;
            AppMethodBeat.o(225266);
            return i3;
        }

        public final String toString() {
            AppMethodBeat.i(225265);
            String str = "CloseWhenClickEmptyAreaConfig(activityClassName=" + this.lfC + ", closeAnimStyle=" + this.lfD + ")";
            AppMethodBeat.o(225265);
            return str;
        }

        public CloseWhenClickEmptyAreaConfig(String str, a aVar) {
            p.h(str, "activityClassName");
            p.h(aVar, "closeAnimStyle");
            AppMethodBeat.i(225262);
            this.lfC = str;
            this.lfD = aVar;
            AppMethodBeat.o(225262);
        }

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public CloseWhenClickEmptyAreaConfig(android.os.Parcel r4) {
            /*
                r3 = this;
                r2 = 225263(0x36fef, float:3.1566E-40)
                java.lang.String r0 = "parcel"
                kotlin.g.b.p.h(r4, r0)
                java.lang.String r0 = r4.readString()
                if (r0 != 0) goto L_0x0012
                java.lang.String r0 = ""
            L_0x0012:
                java.lang.String r1 = r4.readString()
                if (r1 != 0) goto L_0x001b
                java.lang.String r1 = ""
            L_0x001b:
                com.tencent.mm.plugin.appbrand.config.HalfScreenConfig$a r1 = com.tencent.mm.plugin.appbrand.config.HalfScreenConfig.a.valueOf(r1)
                r3.<init>(r0, r1)
                com.tencent.matrix.trace.core.AppMethodBeat.i(r2)
                com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.config.HalfScreenConfig.CloseWhenClickEmptyAreaConfig.<init>(android.os.Parcel):void");
        }

        public final void writeToParcel(Parcel parcel, int i2) {
            AppMethodBeat.i(225261);
            p.h(parcel, "parcel");
            parcel.writeString(this.lfC);
            parcel.writeString(this.lfD.name());
            AppMethodBeat.o(225261);
        }

        public final int describeContents() {
            return 0;
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u00058\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bXT¢\u0006\u0002\n\u0000¨\u0006\t"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/config/HalfScreenConfig$CloseWhenClickEmptyAreaConfig$Companion;", "", "()V", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/appbrand/config/HalfScreenConfig$CloseWhenClickEmptyAreaConfig;", "DUMMY", "EXTRA_START_BY_HALF_SCREEN_EMPTY_AREA_CLICK_SCENE", "", "data-model_release"})
        public static final class a {
            private a() {
            }

            public /* synthetic */ a(byte b2) {
                this();
            }
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u001d\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¢\u0006\u0002\u0010\n¨\u0006\u000b"}, hxF = {"com/tencent/mm/plugin/appbrand/config/HalfScreenConfig$CloseWhenClickEmptyAreaConfig$Companion$CREATOR$1", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/appbrand/config/HalfScreenConfig$CloseWhenClickEmptyAreaConfig;", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/appbrand/config/HalfScreenConfig$CloseWhenClickEmptyAreaConfig;", "data-model_release"})
        public static final class b implements Parcelable.Creator<CloseWhenClickEmptyAreaConfig> {
            b() {
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ CloseWhenClickEmptyAreaConfig createFromParcel(Parcel parcel) {
                AppMethodBeat.i(225260);
                p.h(parcel, "parcel");
                CloseWhenClickEmptyAreaConfig closeWhenClickEmptyAreaConfig = new CloseWhenClickEmptyAreaConfig(parcel);
                AppMethodBeat.o(225260);
                return closeWhenClickEmptyAreaConfig;
            }

            /* Return type fixed from 'java.lang.Object[]' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ CloseWhenClickEmptyAreaConfig[] newArray(int i2) {
                return new CloseWhenClickEmptyAreaConfig[i2];
            }
        }

        static {
            AppMethodBeat.i(225264);
            AppMethodBeat.o(225264);
        }
    }
}

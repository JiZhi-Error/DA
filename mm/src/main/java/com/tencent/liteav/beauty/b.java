package com.tencent.liteav.beauty;

import android.graphics.Bitmap;
import android.os.Build;
import com.tencent.liteav.basic.license.e;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class b implements TXBeautyManager {

    /* renamed from: a  reason: collision with root package name */
    private e f507a;

    /* renamed from: b  reason: collision with root package name */
    private d f508b;

    /* renamed from: c  reason: collision with root package name */
    private int f509c;

    /* renamed from: d  reason: collision with root package name */
    private a f510d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f511e = true;

    /* access modifiers changed from: package-private */
    public class a {
        public float A;
        public String B;

        /* renamed from: a  reason: collision with root package name */
        public int f512a;

        /* renamed from: b  reason: collision with root package name */
        public int f513b;

        /* renamed from: c  reason: collision with root package name */
        public int f514c;

        /* renamed from: d  reason: collision with root package name */
        public int f515d;

        /* renamed from: e  reason: collision with root package name */
        public int f516e;

        /* renamed from: f  reason: collision with root package name */
        public int f517f;

        /* renamed from: g  reason: collision with root package name */
        public int f518g;

        /* renamed from: h  reason: collision with root package name */
        public int f519h;

        /* renamed from: i  reason: collision with root package name */
        public int f520i;

        /* renamed from: j  reason: collision with root package name */
        public int f521j;
        public int k;
        public int l;
        public int m;
        public int n;
        public int o;
        public int p;
        public int q;
        public int r;
        public int s;
        public int t;
        public int u;
        public int v;
        public int w;
        public String x;
        public boolean y;
        public Bitmap z;

        a() {
        }
    }

    public b(e eVar) {
        AppMethodBeat.i(221472);
        this.f507a = eVar;
        this.f510d = new a();
        enableSharpnessEnhancement(true);
        setFilterStrength(0.5f);
        AppMethodBeat.o(221472);
    }

    @Override // com.tencent.liteav.beauty.TXBeautyManager
    public void setPreprocessor(d dVar) {
        AppMethodBeat.i(221473);
        this.f508b = dVar;
        if (this.f508b != null) {
            a();
        }
        AppMethodBeat.o(221473);
    }

    private void a() {
        AppMethodBeat.i(15180);
        TXCLog.d("TXBeautyManager", "applyBeautyParams");
        this.f508b.b(this.f509c);
        b(this.f511e);
        if (this.f507a.a()) {
            this.f508b.g(this.f510d.f516e);
            this.f508b.h(this.f510d.f517f);
            this.f508b.i(this.f510d.f518g);
            this.f508b.k(this.f510d.f519h);
            this.f508b.j(this.f510d.f520i);
            this.f508b.l(this.f510d.f521j);
            this.f508b.m(this.f510d.k);
            this.f508b.n(this.f510d.l);
            this.f508b.o(this.f510d.m);
            this.f508b.p(this.f510d.n);
            this.f508b.q(this.f510d.o);
            this.f508b.r(this.f510d.p);
            this.f508b.s(this.f510d.q);
            this.f508b.t(this.f510d.r);
            this.f508b.u(this.f510d.s);
            this.f508b.v(this.f510d.t);
            this.f508b.w(this.f510d.u);
            this.f508b.x(this.f510d.v);
            this.f508b.y(this.f510d.w);
            this.f508b.a(this.f510d.B, true);
        }
        this.f508b.a(this.f510d.z);
        this.f508b.a(this.f510d.A);
        this.f508b.a(this.f510d.x);
        this.f508b.c(this.f510d.y);
        AppMethodBeat.o(15180);
    }

    public void a(boolean z) {
        AppMethodBeat.i(15168);
        this.f511e = z;
        b(z);
        AppMethodBeat.o(15168);
    }

    private void b(boolean z) {
        AppMethodBeat.i(221474);
        if (z) {
            this.f508b.c(this.f510d.f512a);
            this.f508b.d(this.f510d.f513b);
            this.f508b.e(this.f510d.f514c);
            this.f508b.f(this.f510d.f515d);
            AppMethodBeat.o(221474);
            return;
        }
        this.f508b.c(0);
        this.f508b.d(0);
        this.f508b.e(0);
        this.f508b.f(0);
        AppMethodBeat.o(221474);
    }

    @Override // com.tencent.liteav.beauty.TXBeautyManager
    public void setBeautyStyle(int i2) {
        AppMethodBeat.i(221475);
        TXCLog.d("TXBeautyManager", "setBeautyStyle beautyStyle:".concat(String.valueOf(i2)));
        this.f509c = i2;
        if (this.f508b != null) {
            this.f508b.b(i2);
        }
        AppMethodBeat.o(221475);
    }

    @Override // com.tencent.liteav.beauty.TXBeautyManager
    public void setFilter(Bitmap bitmap) {
        AppMethodBeat.i(221476);
        TXCLog.d("TXBeautyManager", "setFilter image:".concat(String.valueOf(bitmap)));
        this.f510d.z = bitmap;
        if (this.f508b != null) {
            this.f508b.a(bitmap);
        }
        AppMethodBeat.o(221476);
    }

    @Override // com.tencent.liteav.beauty.TXBeautyManager
    public void setFilterStrength(float f2) {
        AppMethodBeat.i(221477);
        TXCLog.d("TXBeautyManager", "setFilterStrength strength:".concat(String.valueOf(f2)));
        this.f510d.A = f2;
        if (this.f508b != null) {
            this.f508b.a(f2);
        }
        AppMethodBeat.o(221477);
    }

    @Override // com.tencent.liteav.beauty.TXBeautyManager
    public void setGreenScreenFile(String str) {
        AppMethodBeat.i(221478);
        TXCLog.d("TXBeautyManager", "setGreenScreenFile path:".concat(String.valueOf(str)));
        this.f510d.B = str;
        if (Build.VERSION.SDK_INT < 18) {
            TXCLog.e("TXBeautyManager", "setGreenScreenFile system version below 18");
            AppMethodBeat.o(221478);
        } else if (!this.f507a.a()) {
            TXCLog.e("TXBeautyManager", "setGreenScreenFile is only supported in EnterprisePro license");
            AppMethodBeat.o(221478);
        } else {
            if (this.f508b != null) {
                this.f508b.a(str, true);
            }
            AppMethodBeat.o(221478);
        }
    }

    @Override // com.tencent.liteav.beauty.TXBeautyManager
    public void setBeautyLevel(int i2) {
        AppMethodBeat.i(221479);
        TXCLog.d("TXBeautyManager", "setBeautyLevel beautyLevel:".concat(String.valueOf(i2)));
        this.f510d.f512a = i2;
        if (this.f508b != null && this.f511e) {
            this.f508b.c(i2);
        }
        AppMethodBeat.o(221479);
    }

    @Override // com.tencent.liteav.beauty.TXBeautyManager
    public void setWhitenessLevel(int i2) {
        AppMethodBeat.i(221480);
        TXCLog.d("TXBeautyManager", "setWhitenessLevel whitenessLevel:".concat(String.valueOf(i2)));
        this.f510d.f513b = i2;
        if (this.f508b != null && this.f511e) {
            this.f508b.d(i2);
        }
        AppMethodBeat.o(221480);
    }

    @Override // com.tencent.liteav.beauty.TXBeautyManager
    public void enableSharpnessEnhancement(boolean z) {
        int i2 = 0;
        AppMethodBeat.i(221481);
        TXCLog.d("TXBeautyManager", "enableSharpnessEnhancement enable: %b", Boolean.valueOf(z));
        a aVar = this.f510d;
        if (z) {
            i2 = 4;
        }
        aVar.f515d = i2;
        if (this.f508b != null && this.f511e) {
            this.f508b.f(this.f510d.f515d);
        }
        AppMethodBeat.o(221481);
    }

    @Override // com.tencent.liteav.beauty.TXBeautyManager
    public void setRuddyLevel(int i2) {
        AppMethodBeat.i(221482);
        TXCLog.d("TXBeautyManager", "setRuddyLevel ruddyLevel:".concat(String.valueOf(i2)));
        this.f510d.f514c = i2;
        if (this.f508b != null && this.f511e) {
            this.f508b.e(i2);
        }
        AppMethodBeat.o(221482);
    }

    @Override // com.tencent.liteav.beauty.TXBeautyManager
    public void setEyeScaleLevel(int i2) {
        AppMethodBeat.i(221483);
        TXCLog.d("TXBeautyManager", "setEyeScaleLevel eyeScaleLevel:".concat(String.valueOf(i2)));
        if (!this.f507a.a()) {
            TXCLog.i("TXBeautyManager", "support EnterPrise above!!!");
            AppMethodBeat.o(221483);
            return;
        }
        this.f510d.f516e = i2;
        if (this.f508b != null) {
            this.f508b.g(i2);
        }
        AppMethodBeat.o(221483);
    }

    @Override // com.tencent.liteav.beauty.TXBeautyManager
    public void setFaceSlimLevel(int i2) {
        AppMethodBeat.i(221484);
        TXCLog.d("TXBeautyManager", "setFaceSlimLevel faceSlimLevel:".concat(String.valueOf(i2)));
        if (!this.f507a.a()) {
            TXCLog.i("TXBeautyManager", "support EnterPrise above!!!");
            AppMethodBeat.o(221484);
            return;
        }
        this.f510d.f517f = i2;
        if (this.f508b != null) {
            this.f508b.h(i2);
        }
        AppMethodBeat.o(221484);
    }

    @Override // com.tencent.liteav.beauty.TXBeautyManager
    public void setFaceVLevel(int i2) {
        AppMethodBeat.i(221485);
        TXCLog.d("TXBeautyManager", "setFaceVLevel faceVLevel:".concat(String.valueOf(i2)));
        if (!this.f507a.a()) {
            TXCLog.i("TXBeautyManager", "support EnterPrise above!!!");
            AppMethodBeat.o(221485);
            return;
        }
        this.f510d.f518g = i2;
        if (this.f508b != null) {
            this.f508b.i(i2);
        }
        AppMethodBeat.o(221485);
    }

    @Override // com.tencent.liteav.beauty.TXBeautyManager
    public void setChinLevel(int i2) {
        AppMethodBeat.i(221486);
        TXCLog.d("TXBeautyManager", "setChinLevel chinLevel:".concat(String.valueOf(i2)));
        if (!this.f507a.a()) {
            TXCLog.i("TXBeautyManager", "support EnterPrise above!!!");
            AppMethodBeat.o(221486);
            return;
        }
        this.f510d.f519h = i2;
        if (this.f508b != null) {
            this.f508b.k(i2);
        }
        AppMethodBeat.o(221486);
    }

    @Override // com.tencent.liteav.beauty.TXBeautyManager
    public void setFaceShortLevel(int i2) {
        AppMethodBeat.i(221487);
        TXCLog.d("TXBeautyManager", "setFaceShortLevel faceShortLevel:".concat(String.valueOf(i2)));
        if (!this.f507a.a()) {
            TXCLog.i("TXBeautyManager", "support EnterPrise above!!!");
            AppMethodBeat.o(221487);
            return;
        }
        this.f510d.f520i = i2;
        if (this.f508b != null) {
            this.f508b.j(i2);
        }
        AppMethodBeat.o(221487);
    }

    @Override // com.tencent.liteav.beauty.TXBeautyManager
    public void setNoseSlimLevel(int i2) {
        AppMethodBeat.i(221488);
        TXCLog.d("TXBeautyManager", "setNoseSlimLevel noseSlimLevel:".concat(String.valueOf(i2)));
        if (!this.f507a.a()) {
            TXCLog.i("TXBeautyManager", "support EnterPrise above!!!");
            AppMethodBeat.o(221488);
            return;
        }
        this.f510d.f521j = i2;
        if (this.f508b != null) {
            this.f508b.l(i2);
        }
        AppMethodBeat.o(221488);
    }

    @Override // com.tencent.liteav.beauty.TXBeautyManager
    public void setEyeLightenLevel(int i2) {
        AppMethodBeat.i(221489);
        TXCLog.d("TXBeautyManager", "setEyeLightenLevel eyeLightenLevel:".concat(String.valueOf(i2)));
        if (!this.f507a.a()) {
            TXCLog.i("TXBeautyManager", "support EnterPrise above!!!");
            AppMethodBeat.o(221489);
            return;
        }
        this.f510d.k = i2;
        if (this.f508b != null) {
            this.f508b.m(i2);
        }
        AppMethodBeat.o(221489);
    }

    @Override // com.tencent.liteav.beauty.TXBeautyManager
    public void setToothWhitenLevel(int i2) {
        AppMethodBeat.i(221490);
        TXCLog.d("TXBeautyManager", "setToothWhitenLevel toothWhitenLevel:".concat(String.valueOf(i2)));
        if (!this.f507a.a()) {
            TXCLog.i("TXBeautyManager", "support EnterPrise above!!!");
            AppMethodBeat.o(221490);
            return;
        }
        this.f510d.l = i2;
        if (this.f508b != null) {
            this.f508b.n(i2);
        }
        AppMethodBeat.o(221490);
    }

    @Override // com.tencent.liteav.beauty.TXBeautyManager
    public void setWrinkleRemoveLevel(int i2) {
        AppMethodBeat.i(221491);
        TXCLog.d("TXBeautyManager", "setWrinkleRemoveLevel wrinkleRemoveLevel:".concat(String.valueOf(i2)));
        if (!this.f507a.a()) {
            TXCLog.i("TXBeautyManager", "support EnterPrise above!!!");
            AppMethodBeat.o(221491);
            return;
        }
        this.f510d.m = i2;
        if (this.f508b != null) {
            this.f508b.o(i2);
        }
        AppMethodBeat.o(221491);
    }

    @Override // com.tencent.liteav.beauty.TXBeautyManager
    public void setPounchRemoveLevel(int i2) {
        AppMethodBeat.i(221492);
        TXCLog.d("TXBeautyManager", "setPounchRemoveLevel pounchRemoveLevel:".concat(String.valueOf(i2)));
        if (!this.f507a.a()) {
            TXCLog.i("TXBeautyManager", "support EnterPrise above!!!");
            AppMethodBeat.o(221492);
            return;
        }
        this.f510d.n = i2;
        if (this.f508b != null) {
            this.f508b.p(i2);
        }
        AppMethodBeat.o(221492);
    }

    @Override // com.tencent.liteav.beauty.TXBeautyManager
    public void setSmileLinesRemoveLevel(int i2) {
        AppMethodBeat.i(221493);
        TXCLog.d("TXBeautyManager", "setSmileLinesRemoveLevel smileLinesRemoveLevel:".concat(String.valueOf(i2)));
        if (!this.f507a.a()) {
            TXCLog.i("TXBeautyManager", "support EnterPrise above!!!");
            AppMethodBeat.o(221493);
            return;
        }
        this.f510d.o = i2;
        if (this.f508b != null) {
            this.f508b.q(i2);
        }
        AppMethodBeat.o(221493);
    }

    @Override // com.tencent.liteav.beauty.TXBeautyManager
    public void setForeheadLevel(int i2) {
        AppMethodBeat.i(221494);
        TXCLog.d("TXBeautyManager", "setForeheadLevel foreheadLevel:".concat(String.valueOf(i2)));
        if (!this.f507a.a()) {
            TXCLog.i("TXBeautyManager", "support EnterPrise above!!!");
            AppMethodBeat.o(221494);
            return;
        }
        this.f510d.p = i2;
        if (this.f508b != null) {
            this.f508b.r(i2);
        }
        AppMethodBeat.o(221494);
    }

    @Override // com.tencent.liteav.beauty.TXBeautyManager
    public void setEyeDistanceLevel(int i2) {
        AppMethodBeat.i(221495);
        TXCLog.d("TXBeautyManager", "setEyeDistanceLevel eyeDistanceLevel:".concat(String.valueOf(i2)));
        if (!this.f507a.a()) {
            TXCLog.i("TXBeautyManager", "support EnterPrise above!!!");
            AppMethodBeat.o(221495);
            return;
        }
        this.f510d.q = i2;
        if (this.f508b != null) {
            this.f508b.s(i2);
        }
        AppMethodBeat.o(221495);
    }

    @Override // com.tencent.liteav.beauty.TXBeautyManager
    public void setEyeAngleLevel(int i2) {
        AppMethodBeat.i(221496);
        TXCLog.d("TXBeautyManager", "setEyeAngleLevel eyeAngleLevel:".concat(String.valueOf(i2)));
        if (!this.f507a.a()) {
            TXCLog.i("TXBeautyManager", "support EnterPrise above!!!");
            AppMethodBeat.o(221496);
            return;
        }
        this.f510d.r = i2;
        if (this.f508b != null) {
            this.f508b.t(i2);
        }
        AppMethodBeat.o(221496);
    }

    @Override // com.tencent.liteav.beauty.TXBeautyManager
    public void setMouthShapeLevel(int i2) {
        AppMethodBeat.i(221497);
        TXCLog.d("TXBeautyManager", "setMouthShapeLevel mouthShapeLevel:".concat(String.valueOf(i2)));
        if (!this.f507a.a()) {
            TXCLog.i("TXBeautyManager", "support EnterPrise above!!!");
            AppMethodBeat.o(221497);
            return;
        }
        this.f510d.s = i2;
        if (this.f508b != null) {
            this.f508b.u(i2);
        }
        AppMethodBeat.o(221497);
    }

    @Override // com.tencent.liteav.beauty.TXBeautyManager
    public void setNoseWingLevel(int i2) {
        AppMethodBeat.i(221498);
        TXCLog.d("TXBeautyManager", "setNoseWingLevel noseWingLevel:".concat(String.valueOf(i2)));
        if (!this.f507a.a()) {
            TXCLog.i("TXBeautyManager", "support EnterPrise above!!!");
            AppMethodBeat.o(221498);
            return;
        }
        this.f510d.t = i2;
        if (this.f508b != null) {
            this.f508b.v(i2);
        }
        AppMethodBeat.o(221498);
    }

    @Override // com.tencent.liteav.beauty.TXBeautyManager
    public void setNosePositionLevel(int i2) {
        AppMethodBeat.i(221499);
        TXCLog.d("TXBeautyManager", "setNosePositionLevel nosePositionLevel:".concat(String.valueOf(i2)));
        if (!this.f507a.a()) {
            TXCLog.i("TXBeautyManager", "support EnterPrise above!!!");
            AppMethodBeat.o(221499);
            return;
        }
        this.f510d.u = i2;
        if (this.f508b != null) {
            this.f508b.w(i2);
        }
        AppMethodBeat.o(221499);
    }

    @Override // com.tencent.liteav.beauty.TXBeautyManager
    public void setLipsThicknessLevel(int i2) {
        AppMethodBeat.i(221500);
        TXCLog.d("TXBeautyManager", "setLipsThicknessLevel lipsThicknessLevel:".concat(String.valueOf(i2)));
        if (!this.f507a.a()) {
            TXCLog.i("TXBeautyManager", "support EnterPrise above!!!");
            AppMethodBeat.o(221500);
            return;
        }
        this.f510d.v = i2;
        if (this.f508b != null) {
            this.f508b.x(i2);
        }
        AppMethodBeat.o(221500);
    }

    @Override // com.tencent.liteav.beauty.TXBeautyManager
    public void setFaceBeautyLevel(int i2) {
        AppMethodBeat.i(221501);
        TXCLog.d("TXBeautyManager", "setFaceBeautyLevel faceBeautyLevel:".concat(String.valueOf(i2)));
        if (!this.f507a.a()) {
            TXCLog.i("TXBeautyManager", "support EnterPrise above!!!");
            AppMethodBeat.o(221501);
            return;
        }
        this.f510d.w = i2;
        if (this.f508b != null) {
            this.f508b.y(i2);
        }
        AppMethodBeat.o(221501);
    }

    @Override // com.tencent.liteav.beauty.TXBeautyManager
    public void setMotionTmpl(String str) {
        AppMethodBeat.i(221502);
        TXCLog.d("TXBeautyManager", "setMotionTmpl tmplPath:".concat(String.valueOf(str)));
        this.f510d.x = str;
        if (this.f508b != null) {
            this.f508b.a(str);
        }
        AppMethodBeat.o(221502);
    }

    @Override // com.tencent.liteav.beauty.TXBeautyManager
    public void setMotionMute(boolean z) {
        AppMethodBeat.i(221503);
        TXCLog.d("TXBeautyManager", "setMotionMute motionMute:".concat(String.valueOf(z)));
        this.f510d.y = z;
        if (this.f508b != null) {
            this.f508b.c(z);
        }
        AppMethodBeat.o(221503);
    }
}

package com.tencent.mm.plugin.appbrand.jsapi.k.a;

import android.graphics.Point;
import android.graphics.SurfaceTexture;
import android.view.MotionEvent;
import android.view.View;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public interface b extends h {

    public static class a {
        i mas;
        public float mat;
        public float skew;
        public float zoom;
    }

    public static class aa {
        public String id;
        public i mbd;
    }

    public static class ab {
        public int fillColor;
        public List<i> maG;
        public String mau;
        public int strokeColor;
        public int strokeWidth;
        public int zIndex;
    }

    public static class ac {
        public ad mbe;
    }

    public static class ad {
        public j mbf;
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.k.a.b$b  reason: collision with other inner class name */
    public static class C0670b {
        public int fillColor;
        public double latitude;
        public double longitude;
        public String mau;
        public int radius;
        public int strokeColor;
        public int strokeWidth;
    }

    public static class c {
        public String data;
        public int height;
        public int left;
        public String mav;
        public boolean maw;
        public int top;
        public int width;
    }

    public static class e {
        public float alpha;
        public String mav;
        public i may;
        public i maz;
        public boolean visible;
        public int zIndex;
    }

    public static class f {
        public String buildingId;
        public String buildingName;
        public List<g> maA;
        public int maB;
    }

    public static class g {
        public String floorName;
    }

    public static class h {
        public int duration;
        public double latitude;
        public double longitude;
        public double maC;
        public double maD;
        public float mat;
    }

    public static class j {
        public i maE;
        public i maF;
    }

    public static class k {
        public int borderColor;
        public String buildingId;
        public int color;
        public String floorName;
        public String id;
        public List<i> maG;
        public boolean maH;
        public boolean maI;
        public String maJ;
        public int maK;
        public List<Integer> maL;
        public String mau;
        public int rc;
        public int style;
        public int width;
    }

    public interface l {
        void a(u uVar);
    }

    public interface m {
        void e(double d2, double d3);
    }

    public interface n {
        void ZQ(String str);
    }

    public interface o {
        boolean c(u uVar);
    }

    public interface p {
        boolean b(u uVar);
    }

    public interface q {
        void aa(JSONObject jSONObject);

        void p(JSONArray jSONArray);
    }

    public interface r {
        void bGP();

        void hv(boolean z);
    }

    public interface s {
        void d(double d2, double d3);
    }

    public static class t {
        public String buildingId;
        public String floorName;
        public double latitude;
        public double longitude;
        public String name;
    }

    public static class u {
        public String data;
        public v maM;
    }

    public interface w {
        void a(a aVar, boolean z);

        void b(a aVar, boolean z);
    }

    public interface x {
        void a(f fVar);
    }

    public interface y {
    }

    public interface z {
        void a(t tVar);
    }

    void ZR(String str);

    void ZS(String str);

    boolean ZT(String str);

    boolean ZV(String str);

    Point a(i iVar);

    void a(double d2, double d3, float f2, float f3, float f4);

    void a(double d2, double d3, float f2, float f3, float f4, boolean z2);

    void a(C0670b bVar);

    void a(k kVar, com.tencent.mm.plugin.appbrand.f.a aVar);

    void a(l lVar);

    void a(m mVar);

    void a(o oVar);

    void a(p pVar);

    void a(s sVar);

    void a(w wVar);

    void a(x xVar);

    void a(z zVar);

    void a(String str, int i2, i iVar, boolean z2);

    void a(String str, v vVar);

    void a(String str, v vVar, com.tencent.mm.plugin.appbrand.f.a aVar);

    void a(String str, ArrayList<i> arrayList, long j2, boolean z2, r rVar);

    void a(String str, LinkedList<h> linkedList, r rVar);

    boolean a(int i2, e eVar, com.tencent.mm.plugin.appbrand.f.a aVar);

    boolean a(ab abVar);

    boolean a(c cVar, n nVar, com.tencent.mm.plugin.appbrand.f.a aVar);

    boolean a(d dVar, com.tencent.mm.plugin.appbrand.f.a aVar);

    boolean a(boolean z2, boolean z3, int i2, int i3, q qVar);

    boolean b(int i2, e eVar, com.tencent.mm.plugin.appbrand.f.a aVar);

    ac bGU();

    void bGV();

    f bGW();

    boolean bGX();

    i bGY();

    void bGZ();

    void bHa();

    void bHb();

    void bHc();

    void bHd();

    void bHe();

    boolean bHg();

    boolean bHh();

    void c(float f2, float f3, boolean z2);

    void dy(String str, String str2);

    i e(Point point);

    void f(double d2, double d3);

    void g(SurfaceTexture surfaceTexture);

    float getRotate();

    float getSkew();

    View getView();

    float getZoom();

    void h(List<i> list, int i2);

    void hA(boolean z2);

    void hB(boolean z2);

    void hC(boolean z2);

    void hD(boolean z2);

    void hE(boolean z2);

    void hF(boolean z2);

    void hG(boolean z2);

    void hH(boolean z2);

    void hw(boolean z2);

    void hx(boolean z2);

    void hy(boolean z2);

    void hz(boolean z2);

    void onDestroy();

    void onPause();

    void onResume();

    void onSizeChanged(int i2, int i3);

    void onTouchEvent(MotionEvent motionEvent);

    void setBuilding3dEffectEnable(boolean z2);

    void setIndoorMaskColor(int i2);

    void setMapStyle(int i2);

    void setMaxZoomLevel(int i2);

    void setMinZoomLevel(int i2);

    void setPoisEnabled(boolean z2);

    boolean xf(int i2);

    public static class i {
        public double latitude;
        public double longitude;

        public i(double d2, double d3) {
            this.latitude = d2;
            this.longitude = d3;
        }
    }

    public static class v {
        public float alpha;
        public float anchorX;
        public float anchorY;
        public String buildingId;
        public String data;
        public String floorName;
        public double latitude;
        public double longitude;
        public boolean maN = false;
        public float maO;
        public float maP;
        public String maQ;
        public a maR;
        public C0671b maS;
        public int mao = -1;
        public float mat;
        public String mav;
        public String title;
        public int zIndex;

        public static class a {
            public static int mbb = 0;
            public static int mbc = 1;
            int bgColor;
            int borderColor;
            int color;
            String content;
            String kZR;
            int maT;
            int maU;
            int maV;
            int maW;
            int maX;
            public int maY;
            public int maZ;
            public int mba;
            int padding;
            int rc;
            int shadowColor;
            public View view = null;

            public a() {
            }

            public a(String str, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12, int i13, String str2, int i14, int i15) {
                this.content = str;
                this.color = i2;
                this.maT = i3;
                this.maU = i4;
                this.rc = i6;
                this.borderColor = i7;
                this.bgColor = i5;
                this.padding = i8;
                this.shadowColor = i9;
                this.maV = i10;
                this.maW = i11;
                this.maX = i12;
                this.maY = i13;
                this.kZR = str2;
                this.maZ = i14;
                this.mba = i15;
            }
        }

        /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.k.a.b$v$b  reason: collision with other inner class name */
        public static class C0671b {
            int bgColor;
            int borderColor;
            int color;
            String content;
            public int height;
            String kZR;
            int maT;
            int maU;
            int padding;
            int rc;
            public int width;
            int x;
            int y;

            public C0671b(String str, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, String str2, int i10) {
                this.content = str;
                this.color = i2;
                this.maT = i3;
                this.x = i4;
                this.y = i5;
                this.bgColor = i6;
                this.maU = i7;
                this.rc = i8;
                this.borderColor = i9;
                this.kZR = str2;
                this.padding = i10;
            }
        }

        public final void M(float f2, float f3) {
            this.anchorX = f2;
            this.anchorY = f3;
        }
    }

    public static class d {
        double latitude;
        double longitude;
        public float mat;
        public String mav;

        public final void g(double d2, double d3) {
            this.latitude = d2;
            this.longitude = d3;
        }
    }
}

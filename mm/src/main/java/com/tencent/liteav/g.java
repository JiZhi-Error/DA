package com.tencent.liteav;

import android.graphics.Bitmap;
import com.tencent.liteav.basic.a.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tavkit.component.TAVExporter;
import org.json.JSONArray;

public class g implements Cloneable {
    public Bitmap A = null;
    public int B = 300;
    public int C = 10;
    public int D = 1;
    public Bitmap E = null;
    public int F = 0;
    public int G = 0;
    public float H = 0.0f;
    public float I = 0.0f;
    public float J = -1.0f;
    public boolean K = true;
    public boolean L = false;
    public boolean M = false;
    public boolean N = true;
    public int O = 1;
    public boolean P = false;
    public boolean Q = false;
    public int R = 0;
    public boolean S = false;
    public boolean T = true;
    public boolean U = false;
    public boolean V = false;
    public boolean W = false;
    public int X = 0;
    public JSONArray Y = null;

    /* renamed from: a  reason: collision with root package name */
    public int f777a = 0;

    /* renamed from: b  reason: collision with root package name */
    public int f778b = 0;

    /* renamed from: c  reason: collision with root package name */
    public int f779c = 1200;

    /* renamed from: d  reason: collision with root package name */
    public int f780d = 1500;

    /* renamed from: e  reason: collision with root package name */
    public int f781e = 800;

    /* renamed from: f  reason: collision with root package name */
    public int f782f = 5;

    /* renamed from: g  reason: collision with root package name */
    public boolean f783g = true;

    /* renamed from: h  reason: collision with root package name */
    public int f784h = 20;

    /* renamed from: i  reason: collision with root package name */
    public int f785i = 1;

    /* renamed from: j  reason: collision with root package name */
    public int f786j = 2;
    public c k = c.RESOLUTION_TYPE_540_960;
    public int l = 1;
    public boolean m = true;
    public int n = 3;
    public int o = 0;
    public boolean p = false;
    public int q = 3;
    public int r = 3;
    public int s = 48000;
    public int t = 1;
    public boolean u = true;
    public boolean v = false;
    public boolean w = false;
    public int x = 0;
    public int y = 10;
    public boolean z = false;

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public int f788a = 0;

        /* renamed from: b  reason: collision with root package name */
        public int f789b = 0;
    }

    public static a a(c cVar) {
        AppMethodBeat.i(222647);
        a aVar = new a();
        switch (cVar) {
            case RESOLUTION_TYPE_360_640:
                aVar.f788a = 368;
                aVar.f789b = 640;
                break;
            case RESOLUTION_TYPE_540_960:
                aVar.f788a = 544;
                aVar.f789b = 960;
                break;
            case RESOLUTION_TYPE_720_1280:
                aVar.f788a = TAVExporter.VIDEO_EXPORT_WIDTH;
                aVar.f789b = TAVExporter.VIDEO_EXPORT_HEIGHT;
                break;
            case RESOLUTION_TYPE_320_480:
                aVar.f788a = 320;
                aVar.f789b = 480;
                break;
            case RESOLUTION_TYPE_180_320:
                aVar.f788a = 192;
                aVar.f789b = 320;
                break;
            case RESOLUTION_TYPE_270_480:
                aVar.f788a = 272;
                aVar.f789b = 480;
                break;
            case RESOLUTION_TYPE_240_320:
                aVar.f788a = 240;
                aVar.f789b = 320;
                break;
            case RESOLUTION_TYPE_360_480:
                aVar.f788a = 368;
                aVar.f789b = 480;
                break;
            case RESOLUTION_TYPE_480_640:
                aVar.f788a = 480;
                aVar.f789b = 640;
                break;
            case RESOLUTION_TYPE_480_480:
                aVar.f788a = 480;
                aVar.f789b = 480;
                break;
            case RESOLUTION_TYPE_270_270:
                aVar.f788a = 272;
                aVar.f789b = 272;
                break;
            case RESOLUTION_TYPE_160_160:
                aVar.f788a = 160;
                aVar.f789b = 160;
                break;
            case RESOLUTION_TYPE_640_360:
                aVar.f788a = 640;
                aVar.f789b = 368;
                break;
            case RESOLUTION_TYPE_960_540:
                aVar.f788a = 960;
                aVar.f789b = 544;
                break;
            case RESOLUTION_TYPE_1280_720:
                aVar.f788a = TAVExporter.VIDEO_EXPORT_HEIGHT;
                aVar.f789b = TAVExporter.VIDEO_EXPORT_WIDTH;
                break;
            case RESOLUTION_TYPE_640_480:
                aVar.f788a = 640;
                aVar.f789b = 480;
                break;
            case RESOLUTION_TYPE_480_360:
                aVar.f788a = 480;
                aVar.f789b = 368;
                break;
            case RESOLUTION_TYPE_320_240:
                aVar.f788a = 320;
                aVar.f789b = 240;
                break;
            case RESOLUTION_TYPE_480_270:
                aVar.f788a = 480;
                aVar.f789b = 272;
                break;
            case RESOLUTION_TYPE_320_180:
                aVar.f788a = 320;
                aVar.f789b = 192;
                break;
            case RESOLUTION_TYPE_120_120:
                aVar.f788a = 128;
                aVar.f789b = 128;
                break;
            case RESOLUTION_TYPE_1080_1920:
                aVar.f788a = 1088;
                aVar.f789b = 1920;
                break;
            case RESOLUTION_TYPE_1920_1080:
                aVar.f788a = 1920;
                aVar.f789b = 1088;
                break;
            default:
                aVar.f788a = 368;
                aVar.f789b = 640;
                break;
        }
        AppMethodBeat.o(222647);
        return aVar;
    }

    public boolean a() {
        AppMethodBeat.i(222648);
        if (this.k != c.RESOLUTION_TYPE_INVALID) {
            a a2 = a(this.k);
            this.f777a = a2.f788a;
            this.f778b = a2.f789b;
        }
        if (this.f777a > this.f778b) {
            AppMethodBeat.o(222648);
            return true;
        }
        AppMethodBeat.o(222648);
        return false;
    }

    /* access modifiers changed from: protected */
    @Override // java.lang.Object
    public Object clone() {
        AppMethodBeat.i(222649);
        g gVar = (g) super.clone();
        AppMethodBeat.o(222649);
        return gVar;
    }
}

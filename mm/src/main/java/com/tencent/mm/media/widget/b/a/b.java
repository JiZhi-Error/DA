package com.tencent.mm.media.widget.b.a;

import android.hardware.camera2.CaptureRequest;
import android.util.Range;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.widget.b.a.a.a;
import com.tencent.mm.media.widget.b.a.a.c;
import com.tencent.mm.media.widget.b.a.a.d;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\"\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0019\u001a\u00020\u0012H\u0007J(\u0010\u001a\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u001b2\u0006\u0010\u0017\u001a\u00020\u00182\u0012\u0010\u001c\u001a\u000e\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u001b\u0018\u00010\u001dJ\u0016\u0010\u001e\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u001b2\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J(\u0010\u001f\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u001b2\u0006\u0010\u0017\u001a\u00020\u00182\u0010\u0010\u001c\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u001b0\u001dH\u0002J*\u0010 \u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0019\u001a\u00020\u00122\u0006\u0010!\u001a\u00020\u0001H\u0007R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0014\u0010\t\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006R\u0014\u0010\u000b\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0006R\u0014\u0010\r\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0006R\u000e\u0010\u000f\u001a\u00020\u0010XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000¨\u0006\""}, hxF = {"Lcom/tencent/mm/media/widget/camera2/effect/WCCameraEffectHelper;", "", "()V", "CAMERA_ID_BACK", "", "getCAMERA_ID_BACK", "()I", "CAMERA_ID_FRONT", "getCAMERA_ID_FRONT", "CAMERA_STREAM_IMAGE", "getCAMERA_STREAM_IMAGE", "CAMERA_STREAM_PREVIEW", "getCAMERA_STREAM_PREVIEW", "CAMERA_STREAM_RECORD", "getCAMERA_STREAM_RECORD", "TAG", "", "isUseCaptureKeyCreator", "", "autoConfig", "", "builder", "Landroid/hardware/camera2/CaptureRequest$Builder;", "effectTag", "Lcom/tencent/mm/media/widget/camera2/effect/request/WCCameraEffectRequestTag;", "enable", "getVendorTagCaptureKey", "Landroid/hardware/camera2/CaptureRequest$Key;", "list", "", "getVendorTagCaptureKeyByCreator", "getVendorTagCaptureKeyByFinder", "manualConfig", "value", "plugin-mediaeditor_release"})
public final class b {
    private static final String TAG = TAG;
    private static boolean ioj = true;
    private static final int iok = 1;
    private static final int iol = 2;
    private static final int iom = 4;
    private static final int ion = 1;
    private static final int ioo = 2;
    public static final b iop = new b();

    static {
        AppMethodBeat.i(94185);
        AppMethodBeat.o(94185);
    }

    private b() {
    }

    public static int aPQ() {
        return iok;
    }

    public static int aPR() {
        return iol;
    }

    public static int aPS() {
        return iom;
    }

    public static int aPT() {
        return ion;
    }

    public static int aPU() {
        return ioo;
    }

    private static CaptureRequest.Key<?> a(a aVar, List<CaptureRequest.Key<?>> list) {
        AppMethodBeat.i(94182);
        p.h(aVar, "effectTag");
        if (list == null) {
            Object obj = aVar.aEX;
            if (obj instanceof Integer) {
                String str = aVar.ioN;
                if (str == null) {
                    p.hyc();
                }
                CaptureRequest.Key<?> d2 = c.d(str, Integer.TYPE);
                AppMethodBeat.o(94182);
                return d2;
            } else if (obj instanceof Boolean) {
                String str2 = aVar.ioN;
                if (str2 == null) {
                    p.hyc();
                }
                CaptureRequest.Key<?> d3 = c.d(str2, Boolean.TYPE);
                AppMethodBeat.o(94182);
                return d3;
            } else if (obj instanceof String) {
                String str3 = aVar.ioN;
                if (str3 == null) {
                    p.hyc();
                }
                CaptureRequest.Key<?> d4 = c.d(str3, String.class);
                AppMethodBeat.o(94182);
                return d4;
            } else {
                Log.e(TAG, "getVendorTagCaptureKeyByCreator: with unknow type value = " + aVar.aEX + " key = " + aVar.ioN);
                AppMethodBeat.o(94182);
                return null;
            }
        } else {
            Object obj2 = aVar.aEX;
            if (obj2 instanceof Integer) {
                CaptureRequest.Key<?> a2 = d.a(aVar, list, Integer.TYPE);
                AppMethodBeat.o(94182);
                return a2;
            } else if (obj2 instanceof Boolean) {
                CaptureRequest.Key<?> a3 = d.a(aVar, list, Boolean.TYPE);
                AppMethodBeat.o(94182);
                return a3;
            } else if (obj2 instanceof String) {
                CaptureRequest.Key<?> a4 = d.a(aVar, list, String.class);
                AppMethodBeat.o(94182);
                return a4;
            } else {
                AppMethodBeat.o(94182);
                return null;
            }
        }
    }

    public static final void a(CaptureRequest.Builder builder, a aVar, boolean z) {
        AppMethodBeat.i(94183);
        p.h(builder, "builder");
        if (aVar == null) {
            p.hyc();
        }
        Object obj = aVar.aEX;
        if (obj == null) {
            p.hyc();
        }
        a(builder, aVar, z, obj);
        AppMethodBeat.o(94183);
    }

    public static final void a(CaptureRequest.Builder builder, a aVar, boolean z, Object obj) {
        CaptureRequest.Key<?> a2;
        Object obj2;
        AppMethodBeat.i(94184);
        p.h(builder, "builder");
        p.h(obj, "value");
        if (aVar == null) {
            AppMethodBeat.o(94184);
            return;
        }
        if (ioj) {
            a2 = a(aVar, null);
        } else {
            CaptureRequest build = builder.build();
            p.g(build, "builder.build()");
            a2 = a(aVar, build.getKeys());
        }
        Object obj3 = aVar.ioM;
        if (obj3 instanceof Range) {
            Object obj4 = aVar.ioM;
            if (obj4 == null) {
                t tVar = new t("null cannot be cast to non-null type android.util.Range<kotlin.Int>");
                AppMethodBeat.o(94184);
                throw tVar;
            }
            obj2 = ((Range) obj4).getLower();
        } else if (obj3 instanceof ArrayList) {
            Object obj5 = aVar.ioM;
            if (obj5 == null) {
                t tVar2 = new t("null cannot be cast to non-null type kotlin.collections.ArrayList<*> /* = java.util.ArrayList<*> */");
                AppMethodBeat.o(94184);
                throw tVar2;
            }
            ArrayList arrayList = (ArrayList) obj5;
            Object obj6 = arrayList.get(0);
            if (obj6 instanceof Integer) {
                Object obj7 = arrayList.get(0);
                if (obj7 == null) {
                    t tVar3 = new t("null cannot be cast to non-null type kotlin.Int");
                    AppMethodBeat.o(94184);
                    throw tVar3;
                }
                obj2 = (Integer) obj7;
            } else if (obj6 instanceof Boolean) {
                Object obj8 = arrayList.get(0);
                if (obj8 == null) {
                    t tVar4 = new t("null cannot be cast to non-null type kotlin.Boolean");
                    AppMethodBeat.o(94184);
                    throw tVar4;
                }
                obj2 = (Boolean) obj8;
            } else if (obj6 instanceof String) {
                Object obj9 = arrayList.get(0);
                if (obj9 == null) {
                    t tVar5 = new t("null cannot be cast to non-null type kotlin.String");
                    AppMethodBeat.o(94184);
                    throw tVar5;
                }
                obj2 = (String) obj9;
            } else {
                obj2 = null;
            }
        } else {
            obj2 = null;
        }
        Log.i(TAG, aVar.ioL + " has been set value is " + z);
        if (obj instanceof Integer) {
            if (a2 == null) {
                t tVar6 = new t("null cannot be cast to non-null type android.hardware.camera2.CaptureRequest.Key<kotlin.Int>");
                AppMethodBeat.o(94184);
                throw tVar6;
            }
            if (z) {
                obj2 = obj;
            }
            if (obj2 == null) {
                t tVar7 = new t("null cannot be cast to non-null type kotlin.Int");
                AppMethodBeat.o(94184);
                throw tVar7;
            }
            builder.set(a2, (Integer) obj2);
            AppMethodBeat.o(94184);
        } else if (obj instanceof Boolean) {
            if (a2 == null) {
                t tVar8 = new t("null cannot be cast to non-null type android.hardware.camera2.CaptureRequest.Key<kotlin.Boolean>");
                AppMethodBeat.o(94184);
                throw tVar8;
            }
            builder.set(a2, Boolean.valueOf(z));
            AppMethodBeat.o(94184);
        } else if (!(obj instanceof String)) {
            Log.i(TAG, "error set config");
            AppMethodBeat.o(94184);
        } else if (a2 == null) {
            t tVar9 = new t("null cannot be cast to non-null type android.hardware.camera2.CaptureRequest.Key<kotlin.String>");
            AppMethodBeat.o(94184);
            throw tVar9;
        } else {
            if (z) {
                obj2 = obj;
            }
            if (obj2 == null) {
                t tVar10 = new t("null cannot be cast to non-null type kotlin.String");
                AppMethodBeat.o(94184);
                throw tVar10;
            }
            builder.set(a2, (String) obj2);
            AppMethodBeat.o(94184);
        }
    }
}

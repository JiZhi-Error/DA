package kotlin.l.b.a.b.j;

import android.support.constraint.ConstraintLayout;
import com.facebook.internal.FacebookRequestErrorClassification;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.appbrand.jsapi.bv;
import com.tencent.mm.plugin.appbrand.jsapi.h.h;
import com.tencent.mm.plugin.appbrand.jsapi.pay.n;
import com.tencent.mm.plugin.appbrand.jsapi.pay.s;
import com.tencent.mm.plugin.appbrand.jsapi.share.d;
import com.tencent.qqmusic.mediaplayer.PlayerException;
import com.tencent.thumbplayer.core.common.TPCodecParamers;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.l.b.a.b.a.g;
import kotlin.l.b.a.b.a.m;
import kotlin.l.b.a.b.b.ab;
import kotlin.l.b.a.b.b.ad;
import kotlin.l.b.a.b.b.ah;
import kotlin.l.b.a.b.b.aj;
import kotlin.l.b.a.b.b.ak;
import kotlin.l.b.a.b.b.ao;
import kotlin.l.b.a.b.b.ax;
import kotlin.l.b.a.b.b.az;
import kotlin.l.b.a.b.b.ba;
import kotlin.l.b.a.b.b.e;
import kotlin.l.b.a.b.b.l;
import kotlin.l.b.a.b.b.o;
import kotlin.l.b.a.b.b.p;
import kotlin.l.b.a.b.b.w;
import kotlin.l.b.a.b.b.y;
import kotlin.l.b.a.b.f.b;
import kotlin.l.b.a.b.f.f;
import kotlin.l.b.a.b.j.d.a;
import kotlin.l.b.a.b.m.at;
import kotlin.l.b.a.b.m.bc;
import kotlin.l.b.a.b.m.u;

public class c {
    static final /* synthetic */ boolean $assertionsDisabled = (!c.class.desiredAssertionStatus());
    public static final b THA = new b("kotlin.Result");
    public static final b THB = new b("kotlin.jvm.JvmName");
    public static final f THt = f.btY("values");
    public static final f THu = f.btY("valueOf");
    public static final b THv;
    public static final b THw;
    public static final b THx;
    public static final b THy = THw.p(f.btY("Continuation"));
    public static final b THz = THv.p(f.btY("Continuation"));

    private static /* synthetic */ void atM(int i2) {
        String str;
        int i3;
        Throwable illegalStateException;
        AppMethodBeat.i(59933);
        switch (i2) {
            case 4:
            case 7:
            case 9:
            case 10:
            case 20:
            case 38:
            case 40:
            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_RIGHT_CREATOR:
            case 45:
            case 47:
            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE:
            case 49:
            case 56:
            case 58:
            case 65:
            case 69:
            case 75:
            case WXMediaMessage.IMediaObject.TYPE_MUSIC_VIDEO:
            case h.a.CTRL_INDEX:
            case 81:
            case com.tencent.mm.plugin.appbrand.jsapi.pay.b.CTRL_INDEX:
            case TPCodecParamers.TP_PROFILE_H264_EXTENDED:
                str = "@NotNull method %s.%s must not return null";
                break;
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i2) {
            case 4:
            case 7:
            case 9:
            case 10:
            case 20:
            case 38:
            case 40:
            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_RIGHT_CREATOR:
            case 45:
            case 47:
            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE:
            case 49:
            case 56:
            case 58:
            case 65:
            case 69:
            case 75:
            case WXMediaMessage.IMediaObject.TYPE_MUSIC_VIDEO:
            case h.a.CTRL_INDEX:
            case 81:
            case com.tencent.mm.plugin.appbrand.jsapi.pay.b.CTRL_INDEX:
            case TPCodecParamers.TP_PROFILE_H264_EXTENDED:
                i3 = 2;
                break;
            default:
                i3 = 3;
                break;
        }
        Object[] objArr = new Object[i3];
        switch (i2) {
            case 1:
            case 2:
            case 3:
            case 5:
            case 6:
            case 8:
            case 11:
            case 12:
            case 13:
            case 19:
            case 21:
            case 22:
            case 32:
            case 33:
            case 34:
            case 53:
            case 54:
            case 55:
            case n.CTRL_INDEX:
            case 74:
            case 87:
            case PlayerException.EXCEPTION_IN_CHECK_STATE:
                objArr[0] = "descriptor";
                break;
            case 4:
            case 7:
            case 9:
            case 10:
            case 20:
            case 38:
            case 40:
            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_RIGHT_CREATOR:
            case 45:
            case 47:
            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE:
            case 49:
            case 56:
            case 58:
            case 65:
            case 69:
            case 75:
            case WXMediaMessage.IMediaObject.TYPE_MUSIC_VIDEO:
            case h.a.CTRL_INDEX:
            case 81:
            case com.tencent.mm.plugin.appbrand.jsapi.pay.b.CTRL_INDEX:
            case TPCodecParamers.TP_PROFILE_H264_EXTENDED:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/resolve/DescriptorUtils";
                break;
            case 14:
                objArr[0] = "first";
                break;
            case 15:
                objArr[0] = "second";
                break;
            case 16:
            case 17:
                objArr[0] = "aClass";
                break;
            case 18:
                objArr[0] = "kotlinType";
                break;
            case 23:
                objArr[0] = "declarationDescriptor";
                break;
            case 24:
            case 26:
                objArr[0] = "subClass";
                break;
            case 25:
            case 27:
            case 31:
                objArr[0] = "superClass";
                break;
            case 28:
            case 30:
            case 43:
            case 60:
                objArr[0] = "type";
                break;
            case 29:
                objArr[0] = FacebookRequestErrorClassification.KEY_OTHER;
                break;
            case 35:
                objArr[0] = "classKind";
                break;
            case 36:
            case 37:
            case 39:
            case 42:
            case 46:
            case 50:
            case PlayerException.EXCEPTION_TYPE_INITLIB:
            case 62:
            case 63:
            case 70:
            case 71:
                objArr[0] = "classDescriptor";
                break;
            case 44:
                objArr[0] = "typeConstructor";
                break;
            case 51:
                objArr[0] = "innerClassName";
                break;
            case 52:
                objArr[0] = FirebaseAnalytics.b.LOCATION;
                break;
            case bv.CTRL_INDEX:
                objArr[0] = "variable";
                break;
            case 64:
                objArr[0] = "f";
                break;
            case 66:
                objArr[0] = "current";
                break;
            case 67:
                objArr[0] = "result";
                break;
            case 68:
                objArr[0] = "memberDescriptor";
                break;
            case 72:
            case d.CTRL_INDEX:
                objArr[0] = "annotated";
                break;
            case TPCodecParamers.TP_PROFILE_H264_MAIN:
            case 79:
            case PlayerException.EXCEPTION_TYPE_ERROR_CREATE_JAVA_DATASOURCE:
            case com.tencent.mm.plugin.appbrand.jsapi.r.f.CTRL_INDEX:
                objArr[0] = "scope";
                break;
            case PlayerException.EXCEPTION_TYPE_CONNECT_FAIL:
            case 83:
            case s.CTRL_INDEX:
                objArr[0] = "name";
                break;
            default:
                objArr[0] = "containingDeclaration";
                break;
        }
        switch (i2) {
            case 4:
                objArr[1] = "getFqNameSafe";
                break;
            case 7:
                objArr[1] = "getFqNameUnsafe";
                break;
            case 9:
            case 10:
                objArr[1] = "getFqNameFromTopLevelClass";
                break;
            case 20:
                objArr[1] = "getContainingModule";
                break;
            case 38:
                objArr[1] = "getSuperclassDescriptors";
                break;
            case 40:
            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_RIGHT_CREATOR:
                objArr[1] = "getSuperClassType";
                break;
            case 45:
                objArr[1] = "getClassDescriptorForTypeConstructor";
                break;
            case 47:
            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE:
            case 49:
                objArr[1] = "getDefaultConstructorVisibility";
                break;
            case 56:
                objArr[1] = "unwrapFakeOverride";
                break;
            case 58:
                objArr[1] = "unwrapFakeOverrideToAnyDeclaration";
                break;
            case 65:
                objArr[1] = "getAllOverriddenDescriptors";
                break;
            case 69:
                objArr[1] = "getAllOverriddenDeclarations";
                break;
            case 75:
            case WXMediaMessage.IMediaObject.TYPE_MUSIC_VIDEO:
                objArr[1] = "getContainingSourceFile";
                break;
            case h.a.CTRL_INDEX:
                objArr[1] = "getAllDescriptors";
                break;
            case 81:
                objArr[1] = "getFunctionByName";
                break;
            case com.tencent.mm.plugin.appbrand.jsapi.pay.b.CTRL_INDEX:
                objArr[1] = "getPropertyByName";
                break;
            case TPCodecParamers.TP_PROFILE_H264_EXTENDED:
                objArr[1] = "getDirectMember";
                break;
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/resolve/DescriptorUtils";
                break;
        }
        switch (i2) {
            case 1:
                objArr[2] = "isLocal";
                break;
            case 2:
                objArr[2] = "getFqName";
                break;
            case 3:
                objArr[2] = "getFqNameSafe";
                break;
            case 4:
            case 7:
            case 9:
            case 10:
            case 20:
            case 38:
            case 40:
            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_RIGHT_CREATOR:
            case 45:
            case 47:
            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE:
            case 49:
            case 56:
            case 58:
            case 65:
            case 69:
            case 75:
            case WXMediaMessage.IMediaObject.TYPE_MUSIC_VIDEO:
            case h.a.CTRL_INDEX:
            case 81:
            case com.tencent.mm.plugin.appbrand.jsapi.pay.b.CTRL_INDEX:
            case TPCodecParamers.TP_PROFILE_H264_EXTENDED:
                break;
            case 5:
                objArr[2] = "getFqNameSafeIfPossible";
                break;
            case 6:
                objArr[2] = "getFqNameUnsafe";
                break;
            case 8:
                objArr[2] = "getFqNameFromTopLevelClass";
                break;
            case 11:
                objArr[2] = "isExtension";
                break;
            case 12:
                objArr[2] = "isOverride";
                break;
            case 13:
                objArr[2] = "isStaticDeclaration";
                break;
            case 14:
            case 15:
                objArr[2] = "areInSameModule";
                break;
            case 16:
            case 17:
                objArr[2] = "getParentOfType";
                break;
            case 18:
            case 21:
                objArr[2] = "getContainingModuleOrNull";
                break;
            case 19:
                objArr[2] = "getContainingModule";
                break;
            case 22:
                objArr[2] = "getContainingClass";
                break;
            case 23:
                objArr[2] = "isAncestor";
                break;
            case 24:
            case 25:
                objArr[2] = "isDirectSubclass";
                break;
            case 26:
            case 27:
                objArr[2] = "isSubclass";
                break;
            case 28:
            case 29:
                objArr[2] = "isSameClass";
                break;
            case 30:
            case 31:
                objArr[2] = "isSubtypeOfClass";
                break;
            case 32:
                objArr[2] = "isAnonymousObject";
                break;
            case 33:
                objArr[2] = "isAnonymousFunction";
                break;
            case 34:
                objArr[2] = "isEnumEntry";
                break;
            case 35:
                objArr[2] = "isKindOf";
                break;
            case 36:
                objArr[2] = "hasAbstractMembers";
                break;
            case 37:
                objArr[2] = "getSuperclassDescriptors";
                break;
            case 39:
                objArr[2] = "getSuperClassType";
                break;
            case 42:
                objArr[2] = "getSuperClassDescriptor";
                break;
            case 43:
                objArr[2] = "getClassDescriptorForType";
                break;
            case 44:
                objArr[2] = "getClassDescriptorForTypeConstructor";
                break;
            case 46:
                objArr[2] = "getDefaultConstructorVisibility";
                break;
            case 50:
            case 51:
            case 52:
                objArr[2] = "getInnerClassByName";
                break;
            case 53:
                objArr[2] = "isStaticNestedClass";
                break;
            case 54:
                objArr[2] = "isTopLevelOrInnerClass";
                break;
            case 55:
                objArr[2] = "unwrapFakeOverride";
                break;
            case n.CTRL_INDEX:
                objArr[2] = "unwrapFakeOverrideToAnyDeclaration";
                break;
            case bv.CTRL_INDEX:
            case 60:
                objArr[2] = "shouldRecordInitializerForProperty";
                break;
            case PlayerException.EXCEPTION_TYPE_INITLIB:
                objArr[2] = "classCanHaveAbstractFakeOverride";
                break;
            case 62:
                objArr[2] = "classCanHaveAbstractDeclaration";
                break;
            case 63:
                objArr[2] = "classCanHaveOpenMembers";
                break;
            case 64:
                objArr[2] = "getAllOverriddenDescriptors";
                break;
            case 66:
            case 67:
                objArr[2] = "collectAllOverriddenDescriptors";
                break;
            case 68:
                objArr[2] = "getAllOverriddenDeclarations";
                break;
            case 70:
                objArr[2] = "isSingletonOrAnonymousObject";
                break;
            case 71:
                objArr[2] = "canHaveDeclaredConstructors";
                break;
            case 72:
                objArr[2] = "getJvmName";
                break;
            case d.CTRL_INDEX:
                objArr[2] = "findJvmNameAnnotation";
                break;
            case 74:
                objArr[2] = "getContainingSourceFile";
                break;
            case TPCodecParamers.TP_PROFILE_H264_MAIN:
                objArr[2] = "getAllDescriptors";
                break;
            case 79:
            case PlayerException.EXCEPTION_TYPE_CONNECT_FAIL:
                objArr[2] = "getFunctionByName";
                break;
            case PlayerException.EXCEPTION_TYPE_ERROR_CREATE_JAVA_DATASOURCE:
            case 83:
                objArr[2] = "getFunctionByNameOrNull";
                break;
            case com.tencent.mm.plugin.appbrand.jsapi.r.f.CTRL_INDEX:
            case s.CTRL_INDEX:
                objArr[2] = "getPropertyByName";
                break;
            case 87:
                objArr[2] = "getDirectMember";
                break;
            case PlayerException.EXCEPTION_IN_CHECK_STATE:
                objArr[2] = "isMethodOfAny";
                break;
            default:
                objArr[2] = "getDispatchReceiverParameterIfNeeded";
                break;
        }
        String format = String.format(str, objArr);
        switch (i2) {
            case 4:
            case 7:
            case 9:
            case 10:
            case 20:
            case 38:
            case 40:
            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_RIGHT_CREATOR:
            case 45:
            case 47:
            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE:
            case 49:
            case 56:
            case 58:
            case 65:
            case 69:
            case 75:
            case WXMediaMessage.IMediaObject.TYPE_MUSIC_VIDEO:
            case h.a.CTRL_INDEX:
            case 81:
            case com.tencent.mm.plugin.appbrand.jsapi.pay.b.CTRL_INDEX:
            case TPCodecParamers.TP_PROFILE_H264_EXTENDED:
                illegalStateException = new IllegalStateException(format);
                break;
            default:
                illegalStateException = new IllegalArgumentException(format);
                break;
        }
        AppMethodBeat.o(59933);
        throw illegalStateException;
    }

    static {
        AppMethodBeat.i(59932);
        b bVar = new b("kotlin.coroutines");
        THv = bVar;
        b p = bVar.p(f.btY("experimental"));
        THw = p;
        THx = p.p(f.btY("intrinsics"));
        AppMethodBeat.o(59932);
    }

    private c() {
    }

    public static ak l(l lVar) {
        AppMethodBeat.i(59896);
        if (lVar == null) {
            atM(0);
        }
        if (lVar instanceof e) {
            ak hAO = ((e) lVar).hAO();
            AppMethodBeat.o(59896);
            return hAO;
        }
        AppMethodBeat.o(59896);
        return null;
    }

    public static boolean m(l lVar) {
        AppMethodBeat.i(59897);
        if (lVar == null) {
            atM(1);
        }
        for (l lVar2 = lVar; lVar2 != null; lVar2 = lVar2.hzx()) {
            if (!w(lVar2)) {
                if (!((lVar2 instanceof p) && ((p) lVar2).hzE() == az.ThV)) {
                }
            }
            AppMethodBeat.o(59897);
            return true;
        }
        AppMethodBeat.o(59897);
        return false;
    }

    public static kotlin.l.b.a.b.f.c n(l lVar) {
        AppMethodBeat.i(59898);
        if (lVar == null) {
            atM(2);
        }
        b p = p(lVar);
        if (p != null) {
            kotlin.l.b.a.b.f.c hJe = p.hJe();
            AppMethodBeat.o(59898);
            return hJe;
        }
        kotlin.l.b.a.b.f.c q = q(lVar);
        AppMethodBeat.o(59898);
        return q;
    }

    public static b o(l lVar) {
        AppMethodBeat.i(59899);
        if (lVar == null) {
            atM(3);
        }
        b p = p(lVar);
        if (p == null) {
            p = q(lVar).hJj();
        }
        if (p == null) {
            atM(4);
        }
        AppMethodBeat.o(59899);
        return p;
    }

    private static b p(l lVar) {
        AppMethodBeat.i(59900);
        if (lVar == null) {
            atM(5);
        }
        if ((lVar instanceof y) || u.L(lVar)) {
            b bVar = b.TCQ;
            AppMethodBeat.o(59900);
            return bVar;
        } else if (lVar instanceof ad) {
            b hBk = ((ad) lVar).hBk();
            AppMethodBeat.o(59900);
            return hBk;
        } else if (lVar instanceof ab) {
            b hBk2 = ((ab) lVar).hBk();
            AppMethodBeat.o(59900);
            return hBk2;
        } else {
            AppMethodBeat.o(59900);
            return null;
        }
    }

    private static kotlin.l.b.a.b.f.c q(l lVar) {
        AppMethodBeat.i(59901);
        if (lVar == null) {
            atM(6);
        }
        l hzx = lVar.hzx();
        if ($assertionsDisabled || hzx != null) {
            kotlin.l.b.a.b.f.c s = n(hzx).s(lVar.hAH());
            AppMethodBeat.o(59901);
            return s;
        }
        AssertionError assertionError = new AssertionError("Not package/module descriptor doesn't have containing declaration: ".concat(String.valueOf(lVar)));
        AppMethodBeat.o(59901);
        throw assertionError;
    }

    public static boolean r(l lVar) {
        AppMethodBeat.i(59902);
        if (lVar == null || !(lVar.hzx() instanceof ab)) {
            AppMethodBeat.o(59902);
            return false;
        }
        AppMethodBeat.o(59902);
        return true;
    }

    public static boolean d(l lVar, l lVar2) {
        AppMethodBeat.i(59903);
        if (lVar == null) {
            atM(14);
        }
        if (lVar2 == null) {
            atM(15);
        }
        boolean equals = s(lVar).equals(s(lVar2));
        AppMethodBeat.o(59903);
        return equals;
    }

    public static <D extends l> D a(l lVar, Class<D> cls) {
        AppMethodBeat.i(59904);
        D d2 = (D) a(lVar, cls, true);
        AppMethodBeat.o(59904);
        return d2;
    }

    public static <D extends l> D a(l lVar, Class<D> cls, boolean z) {
        AppMethodBeat.i(59905);
        if (cls == null) {
            atM(17);
        }
        if (lVar == null) {
            AppMethodBeat.o(59905);
            return null;
        }
        for (D d2 = z ? (D) lVar.hzx() : (D) lVar; d2 != null; d2 = (D) d2.hzx()) {
            if (cls.isInstance(d2)) {
                AppMethodBeat.o(59905);
                return d2;
            }
        }
        AppMethodBeat.o(59905);
        return null;
    }

    public static y Y(kotlin.l.b.a.b.m.ab abVar) {
        AppMethodBeat.i(59906);
        if (abVar == null) {
            atM(18);
        }
        kotlin.l.b.a.b.b.h hzS = abVar.hKE().hzS();
        if (hzS == null) {
            AppMethodBeat.o(59906);
            return null;
        }
        y t = t(hzS);
        AppMethodBeat.o(59906);
        return t;
    }

    public static y s(l lVar) {
        AppMethodBeat.i(59907);
        if (lVar == null) {
            atM(19);
        }
        y t = t(lVar);
        if ($assertionsDisabled || t != null) {
            if (t == null) {
                atM(20);
            }
            AppMethodBeat.o(59907);
            return t;
        }
        AssertionError assertionError = new AssertionError("Descriptor without a containing module: ".concat(String.valueOf(lVar)));
        AppMethodBeat.o(59907);
        throw assertionError;
    }

    private static y t(l lVar) {
        AppMethodBeat.i(59908);
        if (lVar == null) {
            atM(21);
        }
        for (l lVar2 = lVar; lVar2 != null; lVar2 = lVar2.hzx()) {
            if (lVar2 instanceof y) {
                y yVar = (y) lVar2;
                AppMethodBeat.o(59908);
                return yVar;
            } else if (lVar2 instanceof ad) {
                y hBl = ((ad) lVar2).hBl();
                AppMethodBeat.o(59908);
                return hBl;
            }
        }
        AppMethodBeat.o(59908);
        return null;
    }

    public static boolean b(e eVar, e eVar2) {
        AppMethodBeat.i(59909);
        if (eVar == null) {
            atM(24);
        }
        if (eVar2 == null) {
            atM(25);
        }
        for (kotlin.l.b.a.b.m.ab abVar : eVar.hzz().hBV()) {
            if (a(abVar, eVar2.hAP())) {
                AppMethodBeat.o(59909);
                return true;
            }
        }
        AppMethodBeat.o(59909);
        return false;
    }

    public static boolean c(e eVar, e eVar2) {
        AppMethodBeat.i(59910);
        if (eVar == null) {
            atM(26);
        }
        if (eVar2 == null) {
            atM(27);
        }
        boolean b2 = b(eVar.hAG(), eVar2.hAP());
        AppMethodBeat.o(59910);
        return b2;
    }

    private static boolean a(kotlin.l.b.a.b.m.ab abVar, l lVar) {
        AppMethodBeat.i(59911);
        if (abVar == null) {
            atM(28);
        }
        if (lVar == null) {
            atM(29);
        }
        kotlin.l.b.a.b.b.h hzS = abVar.hKE().hzS();
        if (hzS != null) {
            l hAE = hzS.hAE();
            if ((hAE instanceof kotlin.l.b.a.b.b.h) && (lVar instanceof kotlin.l.b.a.b.b.h) && ((kotlin.l.b.a.b.b.h) lVar).hzz().equals(((kotlin.l.b.a.b.b.h) hAE).hzz())) {
                AppMethodBeat.o(59911);
                return true;
            }
        }
        AppMethodBeat.o(59911);
        return false;
    }

    public static boolean b(kotlin.l.b.a.b.m.ab abVar, l lVar) {
        AppMethodBeat.i(59912);
        if (abVar == null) {
            atM(30);
        }
        if (lVar == null) {
            atM(31);
        }
        if (a(abVar, lVar)) {
            AppMethodBeat.o(59912);
            return true;
        }
        for (kotlin.l.b.a.b.m.ab abVar2 : abVar.hKE().hBV()) {
            if (b(abVar2, lVar)) {
                AppMethodBeat.o(59912);
                return true;
            }
        }
        AppMethodBeat.o(59912);
        return false;
    }

    public static boolean u(l lVar) {
        AppMethodBeat.i(59913);
        if (!a(lVar, kotlin.l.b.a.b.b.f.OBJECT) || !((e) lVar).hzF()) {
            AppMethodBeat.o(59913);
            return false;
        }
        AppMethodBeat.o(59913);
        return true;
    }

    public static boolean v(l lVar) {
        AppMethodBeat.i(59914);
        if (!a(lVar, kotlin.l.b.a.b.b.f.CLASS) || ((e) lVar).hzC() != w.SEALED) {
            AppMethodBeat.o(59914);
            return false;
        }
        AppMethodBeat.o(59914);
        return true;
    }

    public static boolean x(l lVar) {
        AppMethodBeat.i(59916);
        if (lVar == null) {
            atM(34);
        }
        boolean a2 = a(lVar, kotlin.l.b.a.b.b.f.ENUM_ENTRY);
        AppMethodBeat.o(59916);
        return a2;
    }

    public static boolean y(l lVar) {
        AppMethodBeat.i(59917);
        boolean a2 = a(lVar, kotlin.l.b.a.b.b.f.ENUM_CLASS);
        AppMethodBeat.o(59917);
        return a2;
    }

    public static boolean z(l lVar) {
        AppMethodBeat.i(59918);
        boolean a2 = a(lVar, kotlin.l.b.a.b.b.f.ANNOTATION_CLASS);
        AppMethodBeat.o(59918);
        return a2;
    }

    public static boolean A(l lVar) {
        AppMethodBeat.i(59919);
        boolean a2 = a(lVar, kotlin.l.b.a.b.b.f.INTERFACE);
        AppMethodBeat.o(59919);
        return a2;
    }

    private static boolean a(l lVar, kotlin.l.b.a.b.b.f fVar) {
        AppMethodBeat.i(59921);
        if (fVar == null) {
            atM(35);
        }
        if (!(lVar instanceof e) || ((e) lVar).hzB() != fVar) {
            AppMethodBeat.o(59921);
            return false;
        }
        AppMethodBeat.o(59921);
        return true;
    }

    public static e y(e eVar) {
        AppMethodBeat.i(59922);
        if (eVar == null) {
            atM(42);
        }
        for (kotlin.l.b.a.b.m.ab abVar : eVar.hzz().hBV()) {
            e Z = Z(abVar);
            if (Z.hzB() != kotlin.l.b.a.b.b.f.INTERFACE) {
                AppMethodBeat.o(59922);
                return Z;
            }
        }
        AppMethodBeat.o(59922);
        return null;
    }

    public static e Z(kotlin.l.b.a.b.m.ab abVar) {
        AppMethodBeat.i(59923);
        if (abVar == null) {
            atM(43);
        }
        e b2 = b(abVar.hKE());
        AppMethodBeat.o(59923);
        return b2;
    }

    private static e b(at atVar) {
        AppMethodBeat.i(59924);
        if (atVar == null) {
            atM(44);
        }
        kotlin.l.b.a.b.b.h hzS = atVar.hzS();
        if ($assertionsDisabled || (hzS instanceof e)) {
            e eVar = (e) hzS;
            if (eVar == null) {
                atM(45);
            }
            AppMethodBeat.o(59924);
            return eVar;
        }
        AssertionError assertionError = new AssertionError("Classifier descriptor of a type should be of type ClassDescriptor: ".concat(String.valueOf(atVar)));
        AppMethodBeat.o(59924);
        throw assertionError;
    }

    public static ba z(e eVar) {
        ba baVar;
        AppMethodBeat.i(59925);
        if (eVar == null) {
            atM(46);
        }
        kotlin.l.b.a.b.b.f hzB = eVar.hzB();
        if (hzB == kotlin.l.b.a.b.b.f.ENUM_CLASS || hzB.hAQ() || v(eVar)) {
            baVar = az.ThQ;
            if (baVar == null) {
                atM(47);
            }
            AppMethodBeat.o(59925);
        } else if (w(eVar)) {
            baVar = az.Tib;
            if (baVar == null) {
                atM(48);
            }
            AppMethodBeat.o(59925);
        } else if ($assertionsDisabled || hzB == kotlin.l.b.a.b.b.f.CLASS || hzB == kotlin.l.b.a.b.b.f.INTERFACE || hzB == kotlin.l.b.a.b.b.f.ANNOTATION_CLASS) {
            baVar = az.ThU;
            if (baVar == null) {
                atM(49);
            }
            AppMethodBeat.o(59925);
        } else {
            AssertionError assertionError = new AssertionError();
            AppMethodBeat.o(59925);
            throw assertionError;
        }
        return baVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v6, types: [kotlin.l.b.a.b.b.b] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static <D extends kotlin.l.b.a.b.b.b> D t(D r4) {
        /*
            r3 = 59926(0xea16, float:8.3974E-41)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r3)
            if (r4 != 0) goto L_0x000d
            r0 = 55
            atM(r0)
        L_0x000d:
            kotlin.l.b.a.b.b.b$a r0 = r4.hAA()
            kotlin.l.b.a.b.b.b$a r1 = kotlin.l.b.a.b.b.b.a.FAKE_OVERRIDE
            if (r0 != r1) goto L_0x003f
            java.util.Collection r0 = r4.hAy()
            boolean r1 = r0.isEmpty()
            if (r1 == 0) goto L_0x0033
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "Fake override should have at least one overridden descriptor: "
            java.lang.String r2 = java.lang.String.valueOf(r4)
            java.lang.String r1 = r1.concat(r2)
            r0.<init>(r1)
            com.tencent.matrix.trace.core.AppMethodBeat.o(r3)
            throw r0
        L_0x0033:
            java.util.Iterator r0 = r0.iterator()
            java.lang.Object r0 = r0.next()
            kotlin.l.b.a.b.b.b r0 = (kotlin.l.b.a.b.b.b) r0
            r4 = r0
            goto L_0x000d
        L_0x003f:
            if (r4 != 0) goto L_0x0046
            r0 = 56
            atM(r0)
        L_0x0046:
            com.tencent.matrix.trace.core.AppMethodBeat.o(r3)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.l.b.a.b.j.c.t(kotlin.l.b.a.b.b.b):kotlin.l.b.a.b.b.b");
    }

    public static <D extends p> D a(D d2) {
        AppMethodBeat.i(59927);
        if (d2 == null) {
            atM(57);
        }
        if (d2 instanceof kotlin.l.b.a.b.b.b) {
            kotlin.l.b.a.b.b.b t = t((kotlin.l.b.a.b.b.b) d2);
            AppMethodBeat.o(59927);
            return t;
        }
        if (d2 == null) {
            atM(58);
        }
        AppMethodBeat.o(59927);
        return d2;
    }

    public static boolean a(ax axVar, kotlin.l.b.a.b.m.ab abVar) {
        AppMethodBeat.i(59928);
        if (axVar == null) {
            atM(59);
        }
        if (abVar == null) {
            atM(60);
        }
        if (axVar.hBF() || kotlin.l.b.a.b.m.ad.ap(abVar)) {
            AppMethodBeat.o(59928);
            return false;
        } else if (bc.aF(abVar)) {
            AppMethodBeat.o(59928);
            return true;
        } else {
            g G = a.G(axVar);
            if (!g.o(abVar) && !kotlin.l.b.a.b.m.a.g.TPc.d(G.hzr(), abVar) && !kotlin.l.b.a.b.m.a.g.TPc.d(G.btz("Number").hAG(), abVar) && !kotlin.l.b.a.b.m.a.g.TPc.d(G.hzi(), abVar)) {
                m mVar = m.Tfo;
                if (!m.E(abVar)) {
                    AppMethodBeat.o(59928);
                    return false;
                }
            }
            AppMethodBeat.o(59928);
            return true;
        }
    }

    public static <D extends kotlin.l.b.a.b.b.a> Set<D> e(D d2) {
        AppMethodBeat.i(59929);
        if (d2 == null) {
            atM(64);
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        a(d2.hAv(), linkedHashSet);
        AppMethodBeat.o(59929);
        return linkedHashSet;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: java.util.Set<D extends kotlin.l.b.a.b.b.a> */
    /* JADX WARN: Multi-variable type inference failed */
    private static <D extends kotlin.l.b.a.b.b.a> void a(D d2, Set<D> set) {
        AppMethodBeat.i(59930);
        if (d2 == null) {
            atM(66);
        }
        if (set == 0) {
            atM(67);
        }
        if (set.contains(d2)) {
            AppMethodBeat.o(59930);
            return;
        }
        for (kotlin.l.b.a.b.b.a aVar : d2.hAv().hAy()) {
            kotlin.l.b.a.b.b.a hAv = aVar.hAv();
            a(hAv, set);
            set.add(hAv);
        }
        AppMethodBeat.o(59930);
    }

    public static ao C(l lVar) {
        ah ahVar;
        ao aoVar;
        AppMethodBeat.i(59931);
        if (lVar == null) {
            atM(74);
        }
        if (lVar instanceof aj) {
            ahVar = ((aj) lVar).hBm();
        } else {
            ahVar = lVar;
        }
        if (ahVar instanceof o) {
            aoVar = ((o) ahVar).hzM().hBu();
            if (aoVar == null) {
                atM(75);
            }
            AppMethodBeat.o(59931);
        } else {
            aoVar = ao.ThL;
            if (aoVar == null) {
                atM(76);
            }
            AppMethodBeat.o(59931);
        }
        return aoVar;
    }

    private static boolean w(l lVar) {
        AppMethodBeat.i(59915);
        if (lVar == null) {
            atM(32);
        }
        if (!a(lVar, kotlin.l.b.a.b.b.f.CLASS) || !lVar.hAH().equals(kotlin.l.b.a.b.f.h.TDd)) {
            AppMethodBeat.o(59915);
            return false;
        }
        AppMethodBeat.o(59915);
        return true;
    }

    public static boolean B(l lVar) {
        AppMethodBeat.i(59920);
        if (a(lVar, kotlin.l.b.a.b.b.f.CLASS) || a(lVar, kotlin.l.b.a.b.b.f.ENUM_CLASS)) {
            AppMethodBeat.o(59920);
            return true;
        }
        AppMethodBeat.o(59920);
        return false;
    }
}

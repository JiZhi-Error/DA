package kotlin.l.b.a.b.j;

import android.support.constraint.ConstraintLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.appbrand.jsapi.bv;
import com.tencent.mm.plugin.appbrand.jsapi.h.h;
import com.tencent.mm.plugin.appbrand.jsapi.pay.b;
import com.tencent.mm.plugin.appbrand.jsapi.pay.n;
import com.tencent.mm.plugin.appbrand.jsapi.pay.s;
import com.tencent.mm.plugin.appbrand.jsapi.r.f;
import com.tencent.mm.plugin.appbrand.jsapi.share.d;
import com.tencent.qqmusic.mediaplayer.PlayerException;
import com.tencent.thumbplayer.core.common.TPCodecParamers;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.ServiceLoader;
import java.util.Set;
import kotlin.a.j;
import kotlin.g.a.m;
import kotlin.l.b.a.b.b.ah;
import kotlin.l.b.a.b.b.aj;
import kotlin.l.b.a.b.b.ak;
import kotlin.l.b.a.b.b.as;
import kotlin.l.b.a.b.b.av;
import kotlin.l.b.a.b.b.az;
import kotlin.l.b.a.b.b.b;
import kotlin.l.b.a.b.b.e;
import kotlin.l.b.a.b.b.l;
import kotlin.l.b.a.b.b.p;
import kotlin.l.b.a.b.b.t;
import kotlin.l.b.a.b.b.w;
import kotlin.l.b.a.b.j.d;
import kotlin.l.b.a.b.m.a.g;
import kotlin.l.b.a.b.m.a.i;
import kotlin.l.b.a.b.m.ab;
import kotlin.l.b.a.b.m.ad;
import kotlin.l.b.a.b.m.at;
import kotlin.l.b.a.b.m.y;
import kotlin.o;
import kotlin.x;

public class i {
    static final /* synthetic */ boolean $assertionsDisabled = (!i.class.desiredAssertionStatus());
    private static final List<d> THO = j.p(ServiceLoader.load(d.class, d.class.getClassLoader()));
    public static final i THP = new i(THQ, i.a.TPf);
    private static final g.a THQ = new g.a() {
        /* class kotlin.l.b.a.b.j.i.AnonymousClass1 */

        private static /* synthetic */ void atM(int i2) {
            AppMethodBeat.i(59955);
            Object[] objArr = new Object[3];
            switch (i2) {
                case 1:
                    objArr[0] = "b";
                    break;
                default:
                    objArr[0] = "a";
                    break;
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil$1";
            objArr[2] = "equals";
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
            AppMethodBeat.o(59955);
            throw illegalArgumentException;
        }

        @Override // kotlin.l.b.a.b.m.a.g.a
        public final boolean a(at atVar, at atVar2) {
            AppMethodBeat.i(59954);
            if (atVar == null) {
                atM(0);
            }
            if (atVar2 == null) {
                atM(1);
            }
            boolean equals = atVar.equals(atVar2);
            AppMethodBeat.o(59954);
            return equals;
        }
    };
    private final kotlin.l.b.a.b.m.a.i THR;
    private final g.a THS;

    private static /* synthetic */ void atM(int i2) {
        String str;
        int i3;
        Throwable illegalStateException;
        AppMethodBeat.i(60005);
        switch (i2) {
            case 7:
            case 8:
            case 12:
            case 17:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 28:
            case 29:
            case 30:
            case 31:
            case 32:
            case 33:
            case 34:
            case 35:
            case 40:
            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_RIGHT_CREATOR:
            case 75:
            case WXMediaMessage.IMediaObject.TYPE_MUSIC_VIDEO:
            case TPCodecParamers.TP_PROFILE_H264_MAIN:
            case h.a.CTRL_INDEX:
            case 79:
            case s.CTRL_INDEX:
            case b.CTRL_INDEX:
            case 87:
            case 90:
            case PlayerException.EXCEPTION_IN_PAUSE:
            case 98:
                str = "@NotNull method %s.%s must not return null";
                break;
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i2) {
            case 7:
            case 8:
            case 12:
            case 17:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 28:
            case 29:
            case 30:
            case 31:
            case 32:
            case 33:
            case 34:
            case 35:
            case 40:
            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_RIGHT_CREATOR:
            case 75:
            case WXMediaMessage.IMediaObject.TYPE_MUSIC_VIDEO:
            case TPCodecParamers.TP_PROFILE_H264_MAIN:
            case h.a.CTRL_INDEX:
            case 79:
            case s.CTRL_INDEX:
            case b.CTRL_INDEX:
            case 87:
            case 90:
            case PlayerException.EXCEPTION_IN_PAUSE:
            case 98:
                i3 = 2;
                break;
            default:
                i3 = 3;
                break;
        }
        Object[] objArr = new Object[i3];
        switch (i2) {
            case 1:
            case 3:
                objArr[0] = "kotlinTypeRefiner";
                break;
            case 2:
                objArr[0] = "axioms";
                break;
            case 4:
            case 5:
                objArr[0] = "candidateSet";
                break;
            case 6:
                objArr[0] = "transformFirst";
                break;
            case 7:
            case 8:
            case 12:
            case 17:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 28:
            case 29:
            case 30:
            case 31:
            case 32:
            case 33:
            case 34:
            case 35:
            case 40:
            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_RIGHT_CREATOR:
            case 75:
            case WXMediaMessage.IMediaObject.TYPE_MUSIC_VIDEO:
            case TPCodecParamers.TP_PROFILE_H264_MAIN:
            case h.a.CTRL_INDEX:
            case 79:
            case s.CTRL_INDEX:
            case b.CTRL_INDEX:
            case 87:
            case 90:
            case PlayerException.EXCEPTION_IN_PAUSE:
            case 98:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil";
                break;
            case 9:
                objArr[0] = "f";
                break;
            case 10:
                objArr[0] = "g";
                break;
            case 11:
            case 13:
                objArr[0] = "descriptor";
                break;
            case 14:
                objArr[0] = "result";
                break;
            case 15:
            case 18:
            case 26:
            case 36:
                objArr[0] = "superDescriptor";
                break;
            case 16:
            case 19:
            case 27:
            case 37:
                objArr[0] = "subDescriptor";
                break;
            case 38:
                objArr[0] = "firstParameters";
                break;
            case 39:
                objArr[0] = "secondParameters";
                break;
            case 42:
                objArr[0] = "typeInSuper";
                break;
            case 43:
                objArr[0] = "typeInSub";
                break;
            case 44:
            case 47:
                objArr[0] = "typeChecker";
                break;
            case 45:
                objArr[0] = "superTypeParameter";
                break;
            case 46:
                objArr[0] = "subTypeParameter";
                break;
            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE:
                objArr[0] = "name";
                break;
            case 49:
                objArr[0] = "membersFromSupertypes";
                break;
            case 50:
                objArr[0] = "membersFromCurrent";
                break;
            case 51:
            case n.CTRL_INDEX:
            case 60:
            case 81:
            case f.CTRL_INDEX:
            case PlayerException.EXCEPTION_IN_PREPARE:
                objArr[0] = "current";
                break;
            case 52:
            case 58:
            case 62:
            case PlayerException.EXCEPTION_TYPE_ERROR_CREATE_JAVA_DATASOURCE:
            case 101:
                objArr[0] = "strategy";
                break;
            case 53:
                objArr[0] = "overriding";
                break;
            case 54:
                objArr[0] = "fromSuper";
                break;
            case 55:
                objArr[0] = "fromCurrent";
                break;
            case 56:
                objArr[0] = "descriptorsFromSuper";
                break;
            case bv.CTRL_INDEX:
            case PlayerException.EXCEPTION_TYPE_INITLIB:
                objArr[0] = "notOverridden";
                break;
            case 63:
            case 65:
            case 69:
                objArr[0] = "a";
                break;
            case 64:
            case 66:
            case 71:
                objArr[0] = "b";
                break;
            case 67:
                objArr[0] = "candidate";
                break;
            case 68:
            case 83:
            case TPCodecParamers.TP_PROFILE_H264_EXTENDED:
            case 104:
                objArr[0] = "descriptors";
                break;
            case 70:
                objArr[0] = "aReturnType";
                break;
            case 72:
                objArr[0] = "bReturnType";
                break;
            case d.CTRL_INDEX:
            case PlayerException.EXCEPTION_TYPE_CONNECT_FAIL:
                objArr[0] = "overridables";
                break;
            case 74:
            case PlayerException.EXCEPTION_IN_SETAUDIOEFFECT:
                objArr[0] = "descriptorByHandle";
                break;
            case PlayerException.EXCEPTION_IN_CHECK_STATE:
                objArr[0] = "classModality";
                break;
            case 92:
                objArr[0] = "toFilter";
                break;
            case 94:
            case 99:
                objArr[0] = "overrider";
                break;
            case PlayerException.EXCEPTION_IN_SEEK:
            case 100:
                objArr[0] = "extractFrom";
                break;
            case PlayerException.EXCEPTION_IN_RELEASE:
                objArr[0] = "onConflict";
                break;
            case 102:
            case 103:
                objArr[0] = "memberDescriptor";
                break;
            default:
                objArr[0] = "equalityAxioms";
                break;
        }
        switch (i2) {
            case 7:
            case 8:
                objArr[1] = "filterOverrides";
                break;
            case 12:
                objArr[1] = "getOverriddenDeclarations";
                break;
            case 17:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
                objArr[1] = "isOverridableBy";
                break;
            case 28:
            case 29:
            case 30:
            case 31:
            case 32:
            case 33:
            case 34:
            case 35:
                objArr[1] = "isOverridableByWithoutExternalConditions";
                break;
            case 40:
            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_RIGHT_CREATOR:
                objArr[1] = "createTypeChecker";
                break;
            case 75:
            case WXMediaMessage.IMediaObject.TYPE_MUSIC_VIDEO:
            case TPCodecParamers.TP_PROFILE_H264_MAIN:
            case h.a.CTRL_INDEX:
            case 79:
                objArr[1] = "selectMostSpecificMember";
                break;
            case s.CTRL_INDEX:
            case b.CTRL_INDEX:
            case 87:
                objArr[1] = "determineModalityForFakeOverride";
                break;
            case 90:
                objArr[1] = "getMinimalModality";
                break;
            case PlayerException.EXCEPTION_IN_PAUSE:
                objArr[1] = "filterVisibleFakeOverrides";
                break;
            case 98:
                objArr[1] = "extractMembersOverridableInBothWays";
                break;
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil";
                break;
        }
        switch (i2) {
            case 1:
                objArr[2] = "createWithTypeRefiner";
                break;
            case 2:
            case 3:
                objArr[2] = "<init>";
                break;
            case 4:
                objArr[2] = "filterOutOverridden";
                break;
            case 5:
            case 6:
                objArr[2] = "filterOverrides";
                break;
            case 7:
            case 8:
            case 12:
            case 17:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 28:
            case 29:
            case 30:
            case 31:
            case 32:
            case 33:
            case 34:
            case 35:
            case 40:
            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_RIGHT_CREATOR:
            case 75:
            case WXMediaMessage.IMediaObject.TYPE_MUSIC_VIDEO:
            case TPCodecParamers.TP_PROFILE_H264_MAIN:
            case h.a.CTRL_INDEX:
            case 79:
            case s.CTRL_INDEX:
            case b.CTRL_INDEX:
            case 87:
            case 90:
            case PlayerException.EXCEPTION_IN_PAUSE:
            case 98:
                break;
            case 9:
            case 10:
                objArr[2] = "overrides";
                break;
            case 11:
                objArr[2] = "getOverriddenDeclarations";
                break;
            case 13:
            case 14:
                objArr[2] = "collectOverriddenDeclarations";
                break;
            case 15:
            case 16:
            case 18:
            case 19:
                objArr[2] = "isOverridableBy";
                break;
            case 26:
            case 27:
                objArr[2] = "isOverridableByWithoutExternalConditions";
                break;
            case 36:
            case 37:
                objArr[2] = "getBasicOverridabilityProblem";
                break;
            case 38:
            case 39:
                objArr[2] = "createTypeChecker";
                break;
            case 42:
            case 43:
            case 44:
                objArr[2] = "areTypesEquivalent";
                break;
            case 45:
            case 46:
            case 47:
                objArr[2] = "areTypeParametersEquivalent";
                break;
            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE:
            case 49:
            case 50:
            case 51:
            case 52:
                objArr[2] = "generateOverridesInFunctionGroup";
                break;
            case 53:
            case 54:
                objArr[2] = "isVisibleForOverride";
                break;
            case 55:
            case 56:
            case n.CTRL_INDEX:
            case 58:
                objArr[2] = "extractAndBindOverridesForMember";
                break;
            case bv.CTRL_INDEX:
                objArr[2] = "allHasSameContainingDeclaration";
                break;
            case 60:
            case PlayerException.EXCEPTION_TYPE_INITLIB:
            case 62:
                objArr[2] = "createAndBindFakeOverrides";
                break;
            case 63:
            case 64:
                objArr[2] = "isMoreSpecific";
                break;
            case 65:
            case 66:
                objArr[2] = "isVisibilityMoreSpecific";
                break;
            case 67:
            case 68:
                objArr[2] = "isMoreSpecificThenAllOf";
                break;
            case 69:
            case 70:
            case 71:
            case 72:
                objArr[2] = "isReturnTypeMoreSpecific";
                break;
            case d.CTRL_INDEX:
            case 74:
                objArr[2] = "selectMostSpecificMember";
                break;
            case PlayerException.EXCEPTION_TYPE_CONNECT_FAIL:
            case 81:
            case PlayerException.EXCEPTION_TYPE_ERROR_CREATE_JAVA_DATASOURCE:
                objArr[2] = "createAndBindFakeOverride";
                break;
            case 83:
            case f.CTRL_INDEX:
                objArr[2] = "determineModalityForFakeOverride";
                break;
            case TPCodecParamers.TP_PROFILE_H264_EXTENDED:
            case PlayerException.EXCEPTION_IN_CHECK_STATE:
                objArr[2] = "getMinimalModality";
                break;
            case PlayerException.EXCEPTION_IN_PREPARE:
            case 92:
                objArr[2] = "filterVisibleFakeOverrides";
                break;
            case 94:
            case PlayerException.EXCEPTION_IN_SEEK:
            case PlayerException.EXCEPTION_IN_SETAUDIOEFFECT:
            case PlayerException.EXCEPTION_IN_RELEASE:
            case 99:
            case 100:
            case 101:
                objArr[2] = "extractMembersOverridableInBothWays";
                break;
            case 102:
                objArr[2] = "resolveUnknownVisibilityForMember";
                break;
            case 103:
                objArr[2] = "computeVisibilityToInherit";
                break;
            case 104:
                objArr[2] = "findMaxVisibility";
                break;
            default:
                objArr[2] = "createWithEqualityAxioms";
                break;
        }
        String format = String.format(str, objArr);
        switch (i2) {
            case 7:
            case 8:
            case 12:
            case 17:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 28:
            case 29:
            case 30:
            case 31:
            case 32:
            case 33:
            case 34:
            case 35:
            case 40:
            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_RIGHT_CREATOR:
            case 75:
            case WXMediaMessage.IMediaObject.TYPE_MUSIC_VIDEO:
            case TPCodecParamers.TP_PROFILE_H264_MAIN:
            case h.a.CTRL_INDEX:
            case 79:
            case s.CTRL_INDEX:
            case b.CTRL_INDEX:
            case 87:
            case 90:
            case PlayerException.EXCEPTION_IN_PAUSE:
            case 98:
                illegalStateException = new IllegalStateException(format);
                break;
            default:
                illegalStateException = new IllegalArgumentException(format);
                break;
        }
        AppMethodBeat.o(60005);
        throw illegalStateException;
    }

    static {
        AppMethodBeat.i(60004);
        AppMethodBeat.o(60004);
    }

    public static i a(g.a aVar) {
        AppMethodBeat.i(59973);
        i iVar = new i(aVar, i.a.TPf);
        AppMethodBeat.o(59973);
        return iVar;
    }

    public static i f(kotlin.l.b.a.b.m.a.i iVar) {
        AppMethodBeat.i(59974);
        if (iVar == null) {
            atM(1);
        }
        i iVar2 = new i(THQ, iVar);
        AppMethodBeat.o(59974);
        return iVar2;
    }

    private i(g.a aVar, kotlin.l.b.a.b.m.a.i iVar) {
        if (aVar == null) {
            atM(2);
        }
        if (iVar == null) {
            atM(3);
        }
        AppMethodBeat.i(59975);
        this.THS = aVar;
        this.THR = iVar;
        AppMethodBeat.o(59975);
    }

    private static <D extends kotlin.l.b.a.b.b.a> Set<D> F(Set<D> set) {
        AppMethodBeat.i(59976);
        boolean z = !set.isEmpty() && kotlin.l.b.a.b.j.d.a.e(kotlin.l.b.a.b.j.d.a.F(set.iterator().next()));
        AnonymousClass2 r4 = new m<D, D, o<kotlin.l.b.a.b.b.a, kotlin.l.b.a.b.b.a>>() {
            /* class kotlin.l.b.a.b.j.i.AnonymousClass2 */

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.m
            public final /* synthetic */ o<kotlin.l.b.a.b.b.a, kotlin.l.b.a.b.b.a> invoke(Object obj, Object obj2) {
                AppMethodBeat.i(59956);
                o oVar = new o((kotlin.l.b.a.b.b.a) obj, (kotlin.l.b.a.b.b.a) obj2);
                AppMethodBeat.o(59956);
                return oVar;
            }
        };
        if (set.size() <= 1) {
            AppMethodBeat.o(59976);
            return set;
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (D d2 : set) {
            Iterator it = linkedHashSet.iterator();
            while (true) {
                if (!it.hasNext()) {
                    linkedHashSet.add(d2);
                    break;
                }
                o oVar = (o) r4.invoke(d2, it.next());
                A a2 = oVar.first;
                B b2 = oVar.second;
                if (!a(a2, b2, z)) {
                    if (a(b2, a2, z)) {
                        break;
                    }
                } else {
                    it.remove();
                }
            }
        }
        if ($assertionsDisabled || !linkedHashSet.isEmpty()) {
            AppMethodBeat.o(59976);
            return linkedHashSet;
        }
        AssertionError assertionError = new AssertionError("All candidates filtered out from ".concat(String.valueOf(set)));
        AppMethodBeat.o(59976);
        throw assertionError;
    }

    private static <D extends kotlin.l.b.a.b.b.a> boolean a(D d2, D d3, boolean z) {
        AppMethodBeat.i(59977);
        if (d2 == null) {
            atM(9);
        }
        if (d3 == null) {
            atM(10);
        }
        if (d2.equals(d3) || !a.THm.a(d2.hAv(), d3.hAv(), z)) {
            kotlin.l.b.a.b.b.a hAv = d3.hAv();
            for (kotlin.l.b.a.b.b.a aVar : c.e(d2)) {
                if (a.THm.a(hAv, aVar, z)) {
                    AppMethodBeat.o(59977);
                    return true;
                }
            }
            AppMethodBeat.o(59977);
            return false;
        }
        AppMethodBeat.o(59977);
        return true;
    }

    private static Set<kotlin.l.b.a.b.b.b> u(kotlin.l.b.a.b.b.b bVar) {
        AppMethodBeat.i(59978);
        if (bVar == null) {
            atM(11);
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        a(bVar, (Set<kotlin.l.b.a.b.b.b>) linkedHashSet);
        AppMethodBeat.o(59978);
        return linkedHashSet;
    }

    private static void a(kotlin.l.b.a.b.b.b bVar, Set<kotlin.l.b.a.b.b.b> set) {
        AppMethodBeat.i(59979);
        if (bVar == null) {
            atM(13);
        }
        if (set == null) {
            atM(14);
        }
        if (bVar.hAA().hAB()) {
            set.add(bVar);
            AppMethodBeat.o(59979);
        } else if (bVar.hAy().isEmpty()) {
            IllegalStateException illegalStateException = new IllegalStateException("No overridden descriptors found for (fake override) ".concat(String.valueOf(bVar)));
            AppMethodBeat.o(59979);
            throw illegalStateException;
        } else {
            for (kotlin.l.b.a.b.b.b bVar2 : bVar.hAy()) {
                a(bVar2, set);
            }
            AppMethodBeat.o(59979);
        }
    }

    private a b(kotlin.l.b.a.b.b.a aVar, kotlin.l.b.a.b.b.a aVar2, e eVar) {
        AppMethodBeat.i(59980);
        if (aVar == null) {
            atM(15);
        }
        if (aVar2 == null) {
            atM(16);
        }
        a a2 = a(aVar, aVar2, eVar, false);
        if (a2 == null) {
            atM(17);
        }
        AppMethodBeat.o(59980);
        return a2;
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    public final a a(kotlin.l.b.a.b.b.a aVar, kotlin.l.b.a.b.b.a aVar2, e eVar, boolean z) {
        AppMethodBeat.i(59981);
        if (aVar == null) {
            atM(18);
        }
        if (aVar2 == null) {
            atM(19);
        }
        a b2 = b(aVar, aVar2, z);
        boolean z2 = b2.hKA() == a.EnumC2349a.OVERRIDABLE;
        boolean z3 = z2;
        for (d dVar : THO) {
            if (dVar.hDu() != d.a.CONFLICTS_ONLY && (!z3 || dVar.hDu() != d.a.SUCCESS_ONLY)) {
                switch (dVar.a(aVar, aVar2, eVar)) {
                    case OVERRIDABLE:
                        z3 = true;
                        continue;
                    case CONFLICT:
                        a buh = a.buh("External condition failed");
                        AppMethodBeat.o(59981);
                        return buh;
                    case INCOMPATIBLE:
                        a bug = a.bug("External condition");
                        AppMethodBeat.o(59981);
                        return bug;
                }
            }
        }
        if (!z3) {
            if (b2 == null) {
                atM(22);
            }
            AppMethodBeat.o(59981);
            return b2;
        }
        for (d dVar2 : THO) {
            if (dVar2.hDu() == d.a.CONFLICTS_ONLY) {
                switch (dVar2.a(aVar, aVar2, eVar)) {
                    case OVERRIDABLE:
                        IllegalStateException illegalStateException = new IllegalStateException("Contract violation in " + dVar2.getClass().getName() + " condition. It's not supposed to end with success");
                        AppMethodBeat.o(59981);
                        throw illegalStateException;
                    case CONFLICT:
                        a buh2 = a.buh("External condition failed");
                        AppMethodBeat.o(59981);
                        return buh2;
                    case INCOMPATIBLE:
                        a bug2 = a.bug("External condition");
                        AppMethodBeat.o(59981);
                        return bug2;
                }
            }
        }
        a hKz = a.hKz();
        if (hKz == null) {
            atM(25);
        }
        AppMethodBeat.o(59981);
        return hKz;
    }

    public final a b(kotlin.l.b.a.b.b.a aVar, kotlin.l.b.a.b.b.a aVar2, boolean z) {
        int i2 = 0;
        AppMethodBeat.i(59982);
        if (aVar == null) {
            atM(26);
        }
        if (aVar2 == null) {
            atM(27);
        }
        a c2 = c(aVar, aVar2);
        if (c2 != null) {
            if (c2 == null) {
                atM(28);
            }
            AppMethodBeat.o(59982);
            return c2;
        }
        List<ab> g2 = g(aVar);
        List<ab> g3 = g(aVar2);
        List<as> hAt = aVar.hAt();
        List<as> hAt2 = aVar2.hAt();
        if (hAt.size() != hAt2.size()) {
            while (i2 < g2.size()) {
                if (!g.TPc.d(g2.get(i2), g3.get(i2))) {
                    a bug = a.bug("Type parameter number mismatch");
                    AppMethodBeat.o(59982);
                    return bug;
                }
                i2++;
            }
            a buh = a.buh("Type parameter number mismatch");
            AppMethodBeat.o(59982);
            return buh;
        }
        g I = I(hAt, hAt2);
        for (int i3 = 0; i3 < hAt.size(); i3++) {
            if (!a(hAt.get(i3), hAt2.get(i3), I)) {
                a bug2 = a.bug("Type parameter bounds mismatch");
                AppMethodBeat.o(59982);
                return bug2;
            }
        }
        for (int i4 = 0; i4 < g2.size(); i4++) {
            if (!a(g2.get(i4), g3.get(i4), I)) {
                a bug3 = a.bug("Value parameter type mismatch");
                AppMethodBeat.o(59982);
                return bug3;
            }
        }
        if (!(aVar instanceof t) || !(aVar2 instanceof t) || ((t) aVar).hAZ() == ((t) aVar2).hAZ()) {
            if (z) {
                ab hAu = aVar.hAu();
                ab hAu2 = aVar2.hAu();
                if (!(hAu == null || hAu2 == null)) {
                    if (ad.ap(hAu2) && ad.ap(hAu)) {
                        i2 = 1;
                    }
                    if (i2 == 0 && !I.c(this.THR.aK(hAu2), this.THR.aK(hAu))) {
                        a buh2 = a.buh("Return type mismatch");
                        AppMethodBeat.o(59982);
                        return buh2;
                    }
                }
            }
            a hKz = a.hKz();
            if (hKz == null) {
                atM(35);
            }
            AppMethodBeat.o(59982);
            return hKz;
        }
        a buh3 = a.buh("Incompatible suspendability");
        AppMethodBeat.o(59982);
        return buh3;
    }

    private static a c(kotlin.l.b.a.b.b.a aVar, kotlin.l.b.a.b.b.a aVar2) {
        AppMethodBeat.i(59983);
        if (aVar == null) {
            atM(36);
        }
        if (aVar2 == null) {
            atM(37);
        }
        if (((aVar instanceof t) && !(aVar2 instanceof t)) || ((aVar instanceof ah) && !(aVar2 instanceof ah))) {
            a bug = a.bug("Member kind mismatch");
            AppMethodBeat.o(59983);
            return bug;
        } else if (!(aVar instanceof t) && !(aVar instanceof ah)) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("This type of CallableDescriptor cannot be checked for overridability: ".concat(String.valueOf(aVar)));
            AppMethodBeat.o(59983);
            throw illegalArgumentException;
        } else if (!aVar.hAH().equals(aVar2.hAH())) {
            a bug2 = a.bug("Name mismatch");
            AppMethodBeat.o(59983);
            return bug2;
        } else {
            a d2 = d(aVar, aVar2);
            if (d2 != null) {
                AppMethodBeat.o(59983);
                return d2;
            }
            AppMethodBeat.o(59983);
            return null;
        }
    }

    private g I(List<as> list, List<as> list2) {
        AppMethodBeat.i(59984);
        if (list == null) {
            atM(38);
        }
        if (list2 == null) {
            atM(39);
        }
        if (!$assertionsDisabled && list.size() != list2.size()) {
            AssertionError assertionError = new AssertionError("Should be the same number of type parameters: " + list + " vs " + list2);
            AppMethodBeat.o(59984);
            throw assertionError;
        } else if (list.isEmpty()) {
            g b2 = kotlin.l.b.a.b.m.a.h.b(this.THS);
            AppMethodBeat.o(59984);
            return b2;
        } else {
            final HashMap hashMap = new HashMap();
            for (int i2 = 0; i2 < list.size(); i2++) {
                hashMap.put(list.get(i2).hzz(), list2.get(i2).hzz());
            }
            g b3 = kotlin.l.b.a.b.m.a.h.b(new g.a() {
                /* class kotlin.l.b.a.b.j.i.AnonymousClass3 */

                private static /* synthetic */ void atM(int i2) {
                    AppMethodBeat.i(59958);
                    Object[] objArr = new Object[3];
                    switch (i2) {
                        case 1:
                            objArr[0] = "b";
                            break;
                        default:
                            objArr[0] = "a";
                            break;
                    }
                    objArr[1] = "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil$3";
                    objArr[2] = "equals";
                    IllegalArgumentException illegalArgumentException = new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
                    AppMethodBeat.o(59958);
                    throw illegalArgumentException;
                }

                @Override // kotlin.l.b.a.b.m.a.g.a
                public final boolean a(at atVar, at atVar2) {
                    AppMethodBeat.i(59957);
                    if (atVar == null) {
                        atM(0);
                    }
                    if (atVar2 == null) {
                        atM(1);
                    }
                    if (i.this.THS.a(atVar, atVar2)) {
                        AppMethodBeat.o(59957);
                        return true;
                    }
                    at atVar3 = (at) hashMap.get(atVar);
                    at atVar4 = (at) hashMap.get(atVar2);
                    if ((atVar3 == null || !atVar3.equals(atVar2)) && (atVar4 == null || !atVar4.equals(atVar))) {
                        AppMethodBeat.o(59957);
                        return false;
                    }
                    AppMethodBeat.o(59957);
                    return true;
                }
            });
            AppMethodBeat.o(59984);
            return b3;
        }
    }

    private static a d(kotlin.l.b.a.b.b.a aVar, kotlin.l.b.a.b.b.a aVar2) {
        boolean z = true;
        AppMethodBeat.i(59985);
        boolean z2 = aVar.hAr() == null;
        if (aVar2.hAr() != null) {
            z = false;
        }
        if (z2 != z) {
            a bug = a.bug("Receiver presence mismatch");
            AppMethodBeat.o(59985);
            return bug;
        } else if (aVar.hAw().size() != aVar2.hAw().size()) {
            a bug2 = a.bug("Value parameter number mismatch");
            AppMethodBeat.o(59985);
            return bug2;
        } else {
            AppMethodBeat.o(59985);
            return null;
        }
    }

    private boolean a(ab abVar, ab abVar2, g gVar) {
        AppMethodBeat.i(59986);
        if (abVar == null) {
            atM(42);
        }
        if (abVar2 == null) {
            atM(43);
        }
        if (gVar == null) {
            atM(44);
        }
        if (ad.ap(abVar) && ad.ap(abVar2)) {
            AppMethodBeat.o(59986);
            return true;
        }
        boolean d2 = gVar.d(this.THR.aK(abVar), this.THR.aK(abVar2));
        AppMethodBeat.o(59986);
        return d2;
    }

    private boolean a(as asVar, as asVar2, g gVar) {
        AppMethodBeat.i(59987);
        if (asVar == null) {
            atM(45);
        }
        if (asVar2 == null) {
            atM(46);
        }
        if (gVar == null) {
            atM(47);
        }
        List<ab> hyo = asVar.hyo();
        ArrayList arrayList = new ArrayList(asVar2.hyo());
        if (hyo.size() != arrayList.size()) {
            AppMethodBeat.o(59987);
            return false;
        }
        for (ab abVar : hyo) {
            ListIterator listIterator = arrayList.listIterator();
            while (listIterator.hasNext()) {
                if (a(abVar, (ab) listIterator.next(), gVar)) {
                    listIterator.remove();
                }
            }
            AppMethodBeat.o(59987);
            return false;
        }
        AppMethodBeat.o(59987);
        return true;
    }

    private static List<ab> g(kotlin.l.b.a.b.b.a aVar) {
        AppMethodBeat.i(59988);
        ak hAr = aVar.hAr();
        ArrayList arrayList = new ArrayList();
        if (hAr != null) {
            arrayList.add(hAr.hBy());
        }
        for (av avVar : aVar.hAw()) {
            arrayList.add(avVar.hBy());
        }
        AppMethodBeat.o(59988);
        return arrayList;
    }

    public final void a(kotlin.l.b.a.b.f.f fVar, Collection<? extends kotlin.l.b.a.b.b.b> collection, Collection<? extends kotlin.l.b.a.b.b.b> collection2, e eVar, h hVar) {
        AppMethodBeat.i(59989);
        if (fVar == null) {
            atM(48);
        }
        if (collection == null) {
            atM(49);
        }
        if (collection2 == null) {
            atM(50);
        }
        if (eVar == null) {
            atM(51);
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet(collection);
        for (kotlin.l.b.a.b.b.b bVar : collection2) {
            linkedHashSet.removeAll(a(bVar, collection, eVar, hVar));
        }
        a(eVar, linkedHashSet, hVar);
        AppMethodBeat.o(59989);
    }

    private Collection<kotlin.l.b.a.b.b.b> a(kotlin.l.b.a.b.b.b bVar, Collection<? extends kotlin.l.b.a.b.b.b> collection, e eVar, h hVar) {
        boolean z;
        AppMethodBeat.i(59990);
        if (bVar == null) {
            atM(55);
        }
        if (collection == null) {
            atM(56);
        }
        if (eVar == null) {
            atM(57);
        }
        if (hVar == null) {
            atM(58);
        }
        ArrayList arrayList = new ArrayList(collection.size());
        kotlin.l.b.a.b.o.i hLZ = kotlin.l.b.a.b.o.i.hLZ();
        for (kotlin.l.b.a.b.b.b bVar2 : collection) {
            a.EnumC2349a hKA = b(bVar2, bVar, eVar).hKA();
            if (bVar == null) {
                atM(53);
            }
            if (bVar2 == null) {
                atM(54);
            }
            if (az.b(bVar2.hzE()) || !az.a((p) bVar2, (l) bVar)) {
                z = false;
            } else {
                z = true;
            }
            switch (hKA) {
                case OVERRIDABLE:
                    if (z) {
                        hLZ.add(bVar2);
                    }
                    arrayList.add(bVar2);
                    break;
                case CONFLICT:
                    if (z) {
                        hVar.b(bVar2, bVar);
                    }
                    arrayList.add(bVar2);
                    break;
            }
        }
        hVar.a(bVar, hLZ);
        AppMethodBeat.o(59990);
        return arrayList;
    }

    public static boolean e(kotlin.l.b.a.b.b.a aVar, kotlin.l.b.a.b.b.a aVar2) {
        boolean z;
        AppMethodBeat.i(59992);
        if (aVar == null) {
            atM(63);
        }
        if (aVar2 == null) {
            atM(64);
        }
        ab hAu = aVar.hAu();
        ab hAu2 = aVar2.hAu();
        if (!$assertionsDisabled && hAu == null) {
            AssertionError assertionError = new AssertionError("Return type of " + aVar + " is null");
            AppMethodBeat.o(59992);
            throw assertionError;
        } else if (!$assertionsDisabled && hAu2 == null) {
            AssertionError assertionError2 = new AssertionError("Return type of " + aVar2 + " is null");
            AppMethodBeat.o(59992);
            throw assertionError2;
        } else if (!a(aVar, aVar2)) {
            AppMethodBeat.o(59992);
            return false;
        } else if (aVar instanceof t) {
            if ($assertionsDisabled || (aVar2 instanceof t)) {
                boolean a2 = a(aVar, hAu, aVar2, hAu2);
                AppMethodBeat.o(59992);
                return a2;
            }
            AssertionError assertionError3 = new AssertionError("b is " + aVar2.getClass());
            AppMethodBeat.o(59992);
            throw assertionError3;
        } else if (!(aVar instanceof ah)) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Unexpected callable: " + aVar.getClass());
            AppMethodBeat.o(59992);
            throw illegalArgumentException;
        } else if ($assertionsDisabled || (aVar2 instanceof ah)) {
            ah ahVar = (ah) aVar;
            ah ahVar2 = (ah) aVar2;
            aj hBo = ahVar.hBo();
            aj hBo2 = ahVar2.hBo();
            if (hBo == null || hBo2 == null) {
                z = true;
            } else {
                z = a(hBo, hBo2);
            }
            if (!z) {
                AppMethodBeat.o(59992);
                return false;
            } else if (ahVar.hBF() && ahVar2.hBF()) {
                boolean d2 = THP.I(aVar.hAt(), aVar2.hAt()).d(hAu, hAu2);
                AppMethodBeat.o(59992);
                return d2;
            } else if ((ahVar.hBF() || !ahVar2.hBF()) && a(aVar, hAu, aVar2, hAu2)) {
                AppMethodBeat.o(59992);
                return true;
            } else {
                AppMethodBeat.o(59992);
                return false;
            }
        } else {
            AssertionError assertionError4 = new AssertionError("b is " + aVar2.getClass());
            AppMethodBeat.o(59992);
            throw assertionError4;
        }
    }

    private static boolean a(p pVar, p pVar2) {
        AppMethodBeat.i(59993);
        if (pVar == null) {
            atM(65);
        }
        if (pVar2 == null) {
            atM(66);
        }
        Integer b2 = az.b(pVar.hzE(), pVar2.hzE());
        if (b2 == null || b2.intValue() >= 0) {
            AppMethodBeat.o(59993);
            return true;
        }
        AppMethodBeat.o(59993);
        return false;
    }

    private static boolean a(kotlin.l.b.a.b.b.a aVar, Collection<kotlin.l.b.a.b.b.a> collection) {
        AppMethodBeat.i(59994);
        if (aVar == null) {
            atM(67);
        }
        if (collection == null) {
            atM(68);
        }
        for (kotlin.l.b.a.b.b.a aVar2 : collection) {
            if (!e(aVar, aVar2)) {
                AppMethodBeat.o(59994);
                return false;
            }
        }
        AppMethodBeat.o(59994);
        return true;
    }

    private static boolean a(kotlin.l.b.a.b.b.a aVar, ab abVar, kotlin.l.b.a.b.b.a aVar2, ab abVar2) {
        AppMethodBeat.i(59995);
        if (aVar == null) {
            atM(69);
        }
        if (abVar == null) {
            atM(70);
        }
        if (aVar2 == null) {
            atM(71);
        }
        if (abVar2 == null) {
            atM(72);
        }
        boolean c2 = THP.I(aVar.hAt(), aVar2.hAt()).c(abVar, abVar2);
        AppMethodBeat.o(59995);
        return c2;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:58:0x007f */
    /* JADX DEBUG: Multi-variable search result rejected for r11v0, resolved type: kotlin.g.a.b<H, kotlin.l.b.a.b.b.a> */
    /* JADX WARN: Multi-variable type inference failed */
    public static <H> H a(Collection<H> collection, kotlin.g.a.b<H, kotlin.l.b.a.b.b.a> bVar) {
        H h2;
        AppMethodBeat.i(59996);
        if (collection == null) {
            atM(73);
        }
        if (bVar == 0) {
            atM(74);
        }
        if ($assertionsDisabled || !collection.isEmpty()) {
            if (collection.size() == 1) {
                h2 = (H) j.e(collection);
                if (h2 == null) {
                    atM(75);
                }
                AppMethodBeat.o(59996);
            } else {
                ArrayList arrayList = new ArrayList(2);
                List d2 = j.d((Iterable) collection, (kotlin.g.a.b) bVar);
                H e2 = j.e(collection);
                kotlin.l.b.a.b.b.a aVar = (kotlin.l.b.a.b.b.a) bVar.invoke(e2);
                Iterator<H> it = collection.iterator();
                while (true) {
                    h2 = (H) e2;
                    if (!it.hasNext()) {
                        break;
                    }
                    H next = it.next();
                    kotlin.l.b.a.b.b.a aVar2 = (kotlin.l.b.a.b.b.a) bVar.invoke(next);
                    if (a(aVar2, d2)) {
                        arrayList.add(next);
                    }
                    if (!e(aVar2, aVar) || e(aVar, aVar2)) {
                        e2 = h2;
                    } else {
                        e2 = next;
                    }
                }
                if (arrayList.isEmpty()) {
                    if (h2 == null) {
                        atM(76);
                    }
                    AppMethodBeat.o(59996);
                } else if (arrayList.size() == 1) {
                    h2 = (H) j.e(arrayList);
                    if (h2 == null) {
                        atM(77);
                    }
                    AppMethodBeat.o(59996);
                } else {
                    Iterator it2 = arrayList.iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            h2 = null;
                            break;
                        }
                        h2 = (H) it2.next();
                        if (!y.al(((kotlin.l.b.a.b.b.a) bVar.invoke(h2)).hAu())) {
                            break;
                        }
                    }
                    if (h2 != null) {
                        if (h2 == null) {
                            atM(78);
                        }
                        AppMethodBeat.o(59996);
                    } else {
                        h2 = (H) j.e(arrayList);
                        if (h2 == null) {
                            atM(79);
                        }
                        AppMethodBeat.o(59996);
                    }
                }
            }
            return h2;
        }
        AssertionError assertionError = new AssertionError("Should have at least one overridable descriptor");
        AppMethodBeat.o(59996);
        throw assertionError;
    }

    private static void a(Collection<kotlin.l.b.a.b.b.b> collection, e eVar, h hVar) {
        AppMethodBeat.i(59997);
        if (collection == null) {
            atM(80);
        }
        if (eVar == null) {
            atM(81);
        }
        if (hVar == null) {
            atM(82);
        }
        Collection<kotlin.l.b.a.b.b.b> a2 = a(eVar, collection);
        boolean isEmpty = a2.isEmpty();
        if (!isEmpty) {
            collection = a2;
        }
        kotlin.l.b.a.b.b.b a3 = ((kotlin.l.b.a.b.b.b) a(collection, new kotlin.g.a.b<kotlin.l.b.a.b.b.b, kotlin.l.b.a.b.b.a>() {
            /* class kotlin.l.b.a.b.j.i.AnonymousClass5 */

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.g.a.b
            public final /* bridge */ /* synthetic */ kotlin.l.b.a.b.b.a invoke(kotlin.l.b.a.b.b.b bVar) {
                return bVar;
            }
        })).a(eVar, a(collection, eVar), isEmpty ? az.ThX : az.ThW, b.a.FAKE_OVERRIDE);
        hVar.a(a3, collection);
        if ($assertionsDisabled || !a3.hAy().isEmpty()) {
            hVar.e(a3);
            AppMethodBeat.o(59997);
            return;
        }
        AssertionError assertionError = new AssertionError("Overridden descriptors should be set for " + b.a.FAKE_OVERRIDE);
        AppMethodBeat.o(59997);
        throw assertionError;
    }

    private static w a(Collection<kotlin.l.b.a.b.b.b> collection, e eVar) {
        boolean z;
        boolean z2 = true;
        AppMethodBeat.i(59998);
        if (collection == null) {
            atM(83);
        }
        if (eVar == null) {
            atM(84);
        }
        boolean z3 = false;
        boolean z4 = false;
        for (kotlin.l.b.a.b.b.b bVar : collection) {
            switch (bVar.hzC()) {
                case FINAL:
                    w wVar = w.FINAL;
                    if (wVar == null) {
                        atM(85);
                    }
                    AppMethodBeat.o(59998);
                    return wVar;
                case SEALED:
                    IllegalStateException illegalStateException = new IllegalStateException("Member cannot have SEALED modality: ".concat(String.valueOf(bVar)));
                    AppMethodBeat.o(59998);
                    throw illegalStateException;
                case OPEN:
                    z4 = true;
                    continue;
                case ABSTRACT:
                    z = true;
                    break;
                default:
                    z = z3;
                    break;
            }
            z3 = z;
        }
        if (!eVar.hzJ() || eVar.hzC() == w.ABSTRACT || eVar.hzC() == w.SEALED) {
            z2 = false;
        }
        if (z4 && !z3) {
            w wVar2 = w.OPEN;
            if (wVar2 == null) {
                atM(86);
            }
            AppMethodBeat.o(59998);
            return wVar2;
        } else if (z4 || !z3) {
            HashSet hashSet = new HashSet();
            for (kotlin.l.b.a.b.b.b bVar2 : collection) {
                hashSet.addAll(u(bVar2));
            }
            w a2 = a(F(hashSet), z2, eVar.hzC());
            AppMethodBeat.o(59998);
            return a2;
        } else {
            w hzC = z2 ? eVar.hzC() : w.ABSTRACT;
            if (hzC == null) {
                atM(87);
            }
            AppMethodBeat.o(59998);
            return hzC;
        }
    }

    private static w a(Collection<kotlin.l.b.a.b.b.b> collection, boolean z, w wVar) {
        AppMethodBeat.i(59999);
        if (collection == null) {
            atM(88);
        }
        if (wVar == null) {
            atM(89);
        }
        w wVar2 = w.ABSTRACT;
        for (kotlin.l.b.a.b.b.b bVar : collection) {
            wVar2 = (!z || bVar.hzC() != w.ABSTRACT) ? bVar.hzC() : wVar;
            if (wVar2.compareTo((Enum) wVar2) >= 0) {
                wVar2 = wVar2;
            }
        }
        if (wVar2 == null) {
            atM(90);
        }
        AppMethodBeat.o(59999);
        return wVar2;
    }

    private static Collection<kotlin.l.b.a.b.b.b> a(final e eVar, Collection<kotlin.l.b.a.b.b.b> collection) {
        AppMethodBeat.i(60000);
        if (eVar == null) {
            atM(91);
        }
        if (collection == null) {
            atM(92);
        }
        List c2 = j.c((Iterable) collection, (kotlin.g.a.b) new kotlin.g.a.b<kotlin.l.b.a.b.b.b, Boolean>() {
            /* class kotlin.l.b.a.b.j.i.AnonymousClass6 */

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.g.a.b
            public final /* synthetic */ Boolean invoke(kotlin.l.b.a.b.b.b bVar) {
                boolean z;
                AppMethodBeat.i(59960);
                kotlin.l.b.a.b.b.b bVar2 = bVar;
                if (az.b(bVar2.hzE()) || !az.a((p) bVar2, (l) eVar)) {
                    z = false;
                } else {
                    z = true;
                }
                Boolean valueOf = Boolean.valueOf(z);
                AppMethodBeat.o(59960);
                return valueOf;
            }
        });
        AppMethodBeat.o(60000);
        return c2;
    }

    public static <H> Collection<H> a(H h2, Collection<H> collection, kotlin.g.a.b<H, kotlin.l.b.a.b.b.a> bVar, kotlin.g.a.b<H, x> bVar2) {
        AppMethodBeat.i(60001);
        if (h2 == null) {
            atM(94);
        }
        if (bVar == null) {
            atM(96);
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(h2);
        kotlin.l.b.a.b.b.a invoke = bVar.invoke(h2);
        Iterator<H> it = collection.iterator();
        while (it.hasNext()) {
            H next = it.next();
            kotlin.l.b.a.b.b.a invoke2 = bVar.invoke(next);
            if (h2 == next) {
                it.remove();
            } else {
                a.EnumC2349a f2 = f(invoke, invoke2);
                if (f2 == a.EnumC2349a.OVERRIDABLE) {
                    arrayList.add(next);
                    it.remove();
                } else if (f2 == a.EnumC2349a.CONFLICT) {
                    bVar2.invoke(next);
                    it.remove();
                }
            }
        }
        AppMethodBeat.o(60001);
        return arrayList;
    }

    public static a.EnumC2349a f(kotlin.l.b.a.b.b.a aVar, kotlin.l.b.a.b.b.a aVar2) {
        AppMethodBeat.i(60002);
        a.EnumC2349a hKA = THP.b(aVar2, aVar, (e) null).hKA();
        a.EnumC2349a hKA2 = THP.b(aVar, aVar2, (e) null).hKA();
        if (hKA == a.EnumC2349a.OVERRIDABLE && hKA2 == a.EnumC2349a.OVERRIDABLE) {
            a.EnumC2349a aVar3 = a.EnumC2349a.OVERRIDABLE;
            AppMethodBeat.o(60002);
            return aVar3;
        } else if (hKA == a.EnumC2349a.CONFLICT || hKA2 == a.EnumC2349a.CONFLICT) {
            a.EnumC2349a aVar4 = a.EnumC2349a.CONFLICT;
            AppMethodBeat.o(60002);
            return aVar4;
        } else {
            a.EnumC2349a aVar5 = a.EnumC2349a.INCOMPATIBLE;
            AppMethodBeat.o(60002);
            return aVar5;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:112:0x00fd A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x00e4  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(kotlin.l.b.a.b.b.b r8, kotlin.g.a.b<kotlin.l.b.a.b.b.b, kotlin.x> r9) {
        /*
        // Method dump skipped, instructions count: 380
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.l.b.a.b.j.i.a(kotlin.l.b.a.b.b.b, kotlin.g.a.b):void");
    }

    public static class a {
        private static final a TIc = new a(EnumC2349a.OVERRIDABLE, "SUCCESS");
        private final EnumC2349a TId;
        private final String debugMessage;

        private static /* synthetic */ void atM(int i2) {
            String str;
            int i3;
            Throwable illegalArgumentException;
            AppMethodBeat.i(59972);
            switch (i2) {
                case 1:
                case 2:
                case 3:
                case 4:
                    str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                    break;
                default:
                    str = "@NotNull method %s.%s must not return null";
                    break;
            }
            switch (i2) {
                case 1:
                case 2:
                case 3:
                case 4:
                    i3 = 3;
                    break;
                default:
                    i3 = 2;
                    break;
            }
            Object[] objArr = new Object[i3];
            switch (i2) {
                case 1:
                case 2:
                case 4:
                    objArr[0] = "debugMessage";
                    break;
                case 3:
                    objArr[0] = "success";
                    break;
                default:
                    objArr[0] = "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil$OverrideCompatibilityInfo";
                    break;
            }
            switch (i2) {
                case 1:
                case 2:
                case 3:
                case 4:
                    objArr[1] = "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil$OverrideCompatibilityInfo";
                    break;
                case 5:
                    objArr[1] = "getResult";
                    break;
                case 6:
                    objArr[1] = "getDebugMessage";
                    break;
                default:
                    objArr[1] = "success";
                    break;
            }
            switch (i2) {
                case 1:
                    objArr[2] = "incompatible";
                    break;
                case 2:
                    objArr[2] = "conflict";
                    break;
                case 3:
                case 4:
                    objArr[2] = "<init>";
                    break;
            }
            String format = String.format(str, objArr);
            switch (i2) {
                case 1:
                case 2:
                case 3:
                case 4:
                    illegalArgumentException = new IllegalArgumentException(format);
                    break;
                default:
                    illegalArgumentException = new IllegalStateException(format);
                    break;
            }
            AppMethodBeat.o(59972);
            throw illegalArgumentException;
        }

        /* renamed from: kotlin.l.b.a.b.j.i$a$a  reason: collision with other inner class name */
        public enum EnumC2349a {
            OVERRIDABLE,
            INCOMPATIBLE,
            CONFLICT;

            public static EnumC2349a valueOf(String str) {
                AppMethodBeat.i(59964);
                EnumC2349a aVar = (EnumC2349a) Enum.valueOf(EnumC2349a.class, str);
                AppMethodBeat.o(59964);
                return aVar;
            }

            static {
                AppMethodBeat.i(59965);
                AppMethodBeat.o(59965);
            }
        }

        static {
            AppMethodBeat.i(59971);
            AppMethodBeat.o(59971);
        }

        public static a hKz() {
            AppMethodBeat.i(59966);
            a aVar = TIc;
            if (aVar == null) {
                atM(0);
            }
            AppMethodBeat.o(59966);
            return aVar;
        }

        public static a bug(String str) {
            AppMethodBeat.i(59967);
            a aVar = new a(EnumC2349a.INCOMPATIBLE, str);
            AppMethodBeat.o(59967);
            return aVar;
        }

        public static a buh(String str) {
            AppMethodBeat.i(59968);
            a aVar = new a(EnumC2349a.CONFLICT, str);
            AppMethodBeat.o(59968);
            return aVar;
        }

        private a(EnumC2349a aVar, String str) {
            if (aVar == null) {
                atM(3);
            }
            if (str == null) {
                atM(4);
            }
            AppMethodBeat.i(59969);
            this.TId = aVar;
            this.debugMessage = str;
            AppMethodBeat.o(59969);
        }

        public final EnumC2349a hKA() {
            AppMethodBeat.i(59970);
            EnumC2349a aVar = this.TId;
            if (aVar == null) {
                atM(5);
            }
            AppMethodBeat.o(59970);
            return aVar;
        }
    }

    private static void a(e eVar, Collection<kotlin.l.b.a.b.b.b> collection, final h hVar) {
        boolean z;
        AppMethodBeat.i(59991);
        if (eVar == null) {
            atM(60);
        }
        if (hVar == null) {
            atM(62);
        }
        if (collection.size() >= 2) {
            final l hzx = collection.iterator().next().hzx();
            AnonymousClass4 r1 = new kotlin.g.a.b<kotlin.l.b.a.b.b.b, Boolean>() {
                /* class kotlin.l.b.a.b.j.i.AnonymousClass4 */

                /* Return type fixed from 'java.lang.Object' to match base method */
                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                @Override // kotlin.g.a.b
                public final /* synthetic */ Boolean invoke(kotlin.l.b.a.b.b.b bVar) {
                    boolean z;
                    AppMethodBeat.i(59959);
                    if (bVar.hzx() == hzx) {
                        z = true;
                    } else {
                        z = false;
                    }
                    Boolean valueOf = Boolean.valueOf(z);
                    AppMethodBeat.o(59959);
                    return valueOf;
                }
            };
            kotlin.g.b.p.h(collection, "$this$all");
            kotlin.g.b.p.h(r1, "predicate");
            if (!collection.isEmpty()) {
                Iterator<T> it = collection.iterator();
                while (true) {
                    if (it.hasNext()) {
                        if (!((Boolean) r1.invoke(it.next())).booleanValue()) {
                            z = false;
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
        }
        z = true;
        if (z) {
            for (kotlin.l.b.a.b.b.b bVar : collection) {
                a(Collections.singleton(bVar), eVar, hVar);
            }
            AppMethodBeat.o(59991);
            return;
        }
        LinkedList linkedList = new LinkedList(collection);
        while (!linkedList.isEmpty()) {
            final kotlin.l.b.a.b.b.b z2 = k.z(linkedList);
            if (z2 == null) {
                atM(99);
            }
            if (hVar == null) {
                atM(101);
            }
            a(a(z2, linkedList, new kotlin.g.a.b<kotlin.l.b.a.b.b.b, kotlin.l.b.a.b.b.a>() {
                /* class kotlin.l.b.a.b.j.i.AnonymousClass7 */

                /* Return type fixed from 'java.lang.Object' to match base method */
                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                @Override // kotlin.g.a.b
                public final /* bridge */ /* synthetic */ kotlin.l.b.a.b.b.a invoke(kotlin.l.b.a.b.b.b bVar) {
                    return bVar;
                }
            }, new kotlin.g.a.b<kotlin.l.b.a.b.b.b, x>() {
                /* class kotlin.l.b.a.b.j.i.AnonymousClass8 */

                /* Return type fixed from 'java.lang.Object' to match base method */
                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                @Override // kotlin.g.a.b
                public final /* synthetic */ x invoke(kotlin.l.b.a.b.b.b bVar) {
                    AppMethodBeat.i(59961);
                    hVar.c(z2, bVar);
                    x xVar = x.SXb;
                    AppMethodBeat.o(59961);
                    return xVar;
                }
            }), eVar, hVar);
        }
        AppMethodBeat.o(59991);
    }
}

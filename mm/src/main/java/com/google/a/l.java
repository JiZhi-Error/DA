package com.google.a;

import com.google.a.ae;
import com.google.a.at;
import com.google.a.aw;
import com.google.a.bx;
import com.google.a.cj;
import com.google.a.k;
import com.google.a.x;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.logging.Logger;

public final class l {
    private static final Logger logger = Logger.getLogger(l.class.getName());

    public static abstract class h {
        public abstract at FC();

        public abstract String Fw();

        public abstract g Fx();

        public abstract String getName();
    }

    static /* synthetic */ String a(g gVar, a aVar, String str) {
        if (aVar != null) {
            return aVar.fullName + '.' + str;
        }
        String str2 = gVar.bTB.getPackage();
        return !str2.isEmpty() ? str2 + '.' + str : str;
    }

    public static final class g extends h {
        private final d[] bSu;
        private final f[] bSw;
        k.q bTB;
        private final a[] bTC;
        private final k[] bTD;
        private final g[] bTE;
        final g[] bTF;
        final b bTG;

        @Override // com.google.a.l.h
        public final String getName() {
            return this.bTB.getName();
        }

        @Override // com.google.a.l.h
        public final g Fx() {
            return this;
        }

        @Override // com.google.a.l.h
        public final String Fw() {
            return this.bTB.getName();
        }

        public final List<a> FP() {
            return Collections.unmodifiableList(Arrays.asList(this.bTC));
        }

        public enum a {
            UNKNOWN("unknown"),
            PROTO2("proto2"),
            PROTO3("proto3");
            
            private final String name;

            private a(String str) {
                this.name = str;
            }
        }

        public final a FQ() {
            if (a.PROTO3.name.equals(this.bTB.CU())) {
                return a.PROTO3;
            }
            return a.PROTO2;
        }

        private static g a(k.q qVar, g[] gVarArr) {
            g gVar = new g(qVar, gVarArr, new b(gVarArr));
            for (a aVar : gVar.bTC) {
                aVar.FB();
            }
            for (k kVar : gVar.bTD) {
                i[] iVarArr = kVar.bTS;
                for (i iVar : iVarArr) {
                    h a2 = iVar.bSr.bTG.a(iVar.bTL.DY(), iVar, b.c.TYPES_ONLY);
                    if (!(a2 instanceof a)) {
                        throw new c(iVar, "\"" + iVar.bTL.DY() + "\" is not a message type.", (byte) 0);
                    }
                    iVar.bTN = (a) a2;
                    h a3 = iVar.bSr.bTG.a(iVar.bTL.Ea(), iVar, b.c.TYPES_ONLY);
                    if (!(a3 instanceof a)) {
                        throw new c(iVar, "\"" + iVar.bTL.Ea() + "\" is not a message type.", (byte) 0);
                    }
                    iVar.bTO = (a) a3;
                }
            }
            for (f fVar : gVar.bSw) {
                f.d(fVar);
            }
            return gVar;
        }

        private g(k.q qVar, g[] gVarArr, b bVar) {
            this.bTG = bVar;
            this.bTB = qVar;
            this.bTE = (g[]) gVarArr.clone();
            HashMap hashMap = new HashMap();
            for (g gVar : gVarArr) {
                hashMap.put(gVar.bTB.getName(), gVar);
            }
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < qVar.CN(); i2++) {
                int i3 = qVar.bQJ.getInt(i2);
                if (i3 < 0 || i3 >= qVar.CM()) {
                    throw new c(this, "Invalid public dependency index.", (byte) 0);
                }
                g gVar2 = (g) hashMap.get((String) qVar.bQI.get(i3));
                if (gVar2 != null) {
                    arrayList.add(gVar2);
                }
            }
            this.bTF = new g[arrayList.size()];
            arrayList.toArray(this.bTF);
            bVar.a(this.bTB.getPackage(), this);
            this.bTC = new a[qVar.CO()];
            for (int i4 = 0; i4 < qVar.CO(); i4++) {
                this.bTC[i4] = new a(qVar.gt(i4), this, i4);
            }
            this.bSu = new d[qVar.AC()];
            for (int i5 = 0; i5 < qVar.AC(); i5++) {
                this.bSu[i5] = new d(qVar.gd(i5), this, null, i5, (byte) 0);
            }
            this.bTD = new k[qVar.CP()];
            for (int i6 = 0; i6 < qVar.CP(); i6++) {
                this.bTD[i6] = new k(qVar.gu(i6), this, i6, (byte) 0);
            }
            this.bSw = new f[qVar.AA()];
            for (int i7 = 0; i7 < qVar.AA(); i7++) {
                this.bSw[i7] = new f(qVar.gb(i7), this, null, i7, true, (byte) 0);
            }
        }

        g(String str, a aVar) {
            this.bTG = new b(new g[0]);
            this.bTB = k.q.CV().cg(aVar.fullName + ".placeholder.proto").ch(str).k(aVar.bSq).Bp();
            this.bTE = new g[0];
            this.bTF = new g[0];
            this.bTC = new a[]{aVar};
            this.bSu = new d[0];
            this.bTD = new k[0];
            this.bSw = new f[0];
            this.bTG.a(str, this);
            this.bTG.c(aVar);
        }

        /* access modifiers changed from: package-private */
        public final boolean FR() {
            return FQ() == a.PROTO3;
        }

        public static g a(String[] strArr, g[] gVarArr) {
            k.q qVar;
            try {
                try {
                    return a(k.q.E(strArr[0].getBytes(ae.ISO_8859_1)), gVarArr);
                } catch (c e2) {
                    throw new IllegalArgumentException("Invalid embedded descriptor for \"" + qVar.getName() + "\".", e2);
                }
            } catch (af e3) {
                throw new IllegalArgumentException("Failed to parse protocol buffer descriptor for generated code.", e3);
            }
        }

        @Override // com.google.a.l.h
        public final /* bridge */ /* synthetic */ at FC() {
            return this.bTB;
        }
    }

    public static final class a extends h {
        k.a bSq;
        final g bSr;
        private final a bSs;
        private final a[] bSt;
        private final d[] bSu;
        private final f[] bSv;
        private final f[] bSw;
        private final j[] bSx;
        final String fullName;
        private final int index;

        /* synthetic */ a(k.a aVar, g gVar, int i2) {
            this(aVar, gVar, null, i2);
        }

        @Override // com.google.a.l.h
        public final String getName() {
            return this.bSq.getName();
        }

        @Override // com.google.a.l.h
        public final String Fw() {
            return this.fullName;
        }

        @Override // com.google.a.l.h
        public final g Fx() {
            return this.bSr;
        }

        public final List<f> getFields() {
            return Collections.unmodifiableList(Arrays.asList(this.bSv));
        }

        public final List<j> Fy() {
            return Collections.unmodifiableList(Arrays.asList(this.bSx));
        }

        public final List<a> Fz() {
            return Collections.unmodifiableList(Arrays.asList(this.bSt));
        }

        public final boolean gy(int i2) {
            for (k.a.b bVar : this.bSq.bOZ) {
                if (bVar.bPp <= i2 && i2 < bVar.bPq) {
                    return true;
                }
            }
            return false;
        }

        public final boolean FA() {
            return this.bSq.bOZ.size() != 0;
        }

        public final f ci(String str) {
            h cj = this.bSr.bTG.cj(this.fullName + '.' + str);
            if (cj == null || !(cj instanceof f)) {
                return null;
            }
            return (f) cj;
        }

        public final f gz(int i2) {
            return this.bSr.bTG.bSB.get(new b.a(this, i2));
        }

        a(String str) {
            String str2;
            String str3 = "";
            int lastIndexOf = str.lastIndexOf(46);
            if (lastIndexOf != -1) {
                str2 = str.substring(lastIndexOf + 1);
                str3 = str.substring(0, lastIndexOf);
            } else {
                str2 = str;
            }
            this.index = 0;
            this.bSq = k.a.AH().ce(str2).a(k.a.b.Bs().gf(1).gg(536870912).Bp()).Bp();
            this.fullName = str;
            this.bSs = null;
            this.bSt = new a[0];
            this.bSu = new d[0];
            this.bSv = new f[0];
            this.bSw = new f[0];
            this.bSx = new j[0];
            this.bSr = new g(str3, this);
        }

        private a(k.a aVar, g gVar, a aVar2, int i2) {
            this.index = i2;
            this.bSq = aVar;
            this.fullName = l.a(gVar, aVar2, aVar.getName());
            this.bSr = gVar;
            this.bSs = aVar2;
            this.bSx = new j[aVar.AE()];
            for (int i3 = 0; i3 < aVar.AE(); i3++) {
                this.bSx[i3] = new j(aVar.ge(i3), gVar, this, i3, (byte) 0);
            }
            this.bSt = new a[aVar.AB()];
            for (int i4 = 0; i4 < aVar.AB(); i4++) {
                this.bSt[i4] = new a(aVar.gc(i4), gVar, this, i4);
            }
            this.bSu = new d[aVar.AC()];
            for (int i5 = 0; i5 < aVar.AC(); i5++) {
                this.bSu[i5] = new d(aVar.gd(i5), gVar, this, i5, (byte) 0);
            }
            this.bSv = new f[aVar.getFieldCount()];
            for (int i6 = 0; i6 < aVar.getFieldCount(); i6++) {
                this.bSv[i6] = new f(aVar.ga(i6), gVar, this, i6, false, (byte) 0);
            }
            this.bSw = new f[aVar.AA()];
            for (int i7 = 0; i7 < aVar.AA(); i7++) {
                this.bSw[i7] = new f(aVar.gb(i7), gVar, this, i7, true, (byte) 0);
            }
            for (int i8 = 0; i8 < aVar.AE(); i8++) {
                this.bSx[i8].bSv = new f[this.bSx[i8].bTQ];
                this.bSx[i8].bTQ = 0;
            }
            for (int i9 = 0; i9 < aVar.getFieldCount(); i9++) {
                j jVar = this.bSv[i9].bSU;
                if (jVar != null) {
                    jVar.bSv[j.c(jVar)] = this.bSv[i9];
                }
            }
            gVar.bTG.c(this);
        }

        /* access modifiers changed from: package-private */
        public final void FB() {
            for (a aVar : this.bSt) {
                aVar.FB();
            }
            for (f fVar : this.bSv) {
                f.d(fVar);
            }
            for (f fVar2 : this.bSw) {
                f.d(fVar2);
            }
        }

        @Override // com.google.a.l.h
        public final /* bridge */ /* synthetic */ at FC() {
            return this.bSq;
        }
    }

    public static final class f extends h implements x.a<f>, Comparable<f> {
        private static final cj.a[] bSO = cj.a.values();
        private Object aEX;
        k.m bSP;
        private final String bSQ;
        private final a bSR;
        b bSS;
        private a bST;
        j bSU;
        private d bSV;
        final g bSr;
        a bSs;
        final String fullName;
        final int index;

        /* synthetic */ f(k.m mVar, g gVar, a aVar, int i2, boolean z, byte b2) {
            this(mVar, gVar, aVar, i2, z);
        }

        static /* synthetic */ void d(f fVar) {
            e eVar;
            if (fVar.bSP.Cp()) {
                h a2 = fVar.bSr.bTG.a(fVar.bSP.Cq(), fVar, b.c.TYPES_ONLY);
                if (!(a2 instanceof a)) {
                    throw new c(fVar, "\"" + fVar.bSP.Cq() + "\" is not a message type.", (byte) 0);
                }
                fVar.bSs = (a) a2;
                if (!fVar.bSs.gy(fVar.bSP.bPE)) {
                    throw new c(fVar, "\"" + fVar.bSs.fullName + "\" does not declare " + fVar.bSP.bPE + " as an extension number.", (byte) 0);
                }
            }
            if (fVar.bSP.Co()) {
                h a3 = fVar.bSr.bTG.a(fVar.bSP.getTypeName(), fVar, b.c.TYPES_ONLY);
                if (!fVar.bSP.Cm()) {
                    if (a3 instanceof a) {
                        fVar.bSS = b.MESSAGE;
                    } else if (a3 instanceof d) {
                        fVar.bSS = b.ENUM;
                    } else {
                        throw new c(fVar, "\"" + fVar.bSP.getTypeName() + "\" is not a type.", (byte) 0);
                    }
                }
                if (fVar.bSS.bTz == a.MESSAGE) {
                    if (!(a3 instanceof a)) {
                        throw new c(fVar, "\"" + fVar.bSP.getTypeName() + "\" is not a message type.", (byte) 0);
                    }
                    fVar.bST = (a) a3;
                    if (fVar.bSP.Cr()) {
                        throw new c(fVar, "Messages can't have default values.", (byte) 0);
                    }
                } else if (fVar.bSS.bTz != a.ENUM) {
                    throw new c(fVar, "Field with primitive type has type_name.", (byte) 0);
                } else if (!(a3 instanceof d)) {
                    throw new c(fVar, "\"" + fVar.bSP.getTypeName() + "\" is not an enum type.", (byte) 0);
                } else {
                    fVar.bSV = (d) a3;
                }
            } else if (fVar.bSS.bTz == a.MESSAGE || fVar.bSS.bTz == a.ENUM) {
                throw new c(fVar, "Field with message or enum type missing type_name.", (byte) 0);
            }
            if (!fVar.bSP.Cv().bQs || fVar.FL()) {
                if (!fVar.bSP.Cr()) {
                    if (!fVar.FJ()) {
                        switch (fVar.bSS.bTz) {
                            case ENUM:
                                fVar.aEX = Collections.unmodifiableList(Arrays.asList(fVar.bSV.bSK)).get(0);
                                break;
                            case MESSAGE:
                                fVar.aEX = null;
                                break;
                            default:
                                fVar.aEX = fVar.bSS.bTz.bTf;
                                break;
                        }
                    } else {
                        fVar.aEX = Collections.emptyList();
                    }
                } else if (fVar.FJ()) {
                    throw new c(fVar, "Repeated fields cannot have default values.", (byte) 0);
                } else {
                    try {
                        switch (fVar.bSS) {
                            case INT32:
                            case SINT32:
                            case SFIXED32:
                                fVar.aEX = Integer.valueOf(bx.cm(fVar.bSP.getDefaultValue()));
                                break;
                            case UINT32:
                            case FIXED32:
                                fVar.aEX = Integer.valueOf(bx.cn(fVar.bSP.getDefaultValue()));
                                break;
                            case INT64:
                            case SINT64:
                            case SFIXED64:
                                fVar.aEX = Long.valueOf(bx.co(fVar.bSP.getDefaultValue()));
                                break;
                            case UINT64:
                            case FIXED64:
                                fVar.aEX = Long.valueOf(bx.cp(fVar.bSP.getDefaultValue()));
                                break;
                            case FLOAT:
                                if (!fVar.bSP.getDefaultValue().equals("inf")) {
                                    if (!fVar.bSP.getDefaultValue().equals("-inf")) {
                                        if (!fVar.bSP.getDefaultValue().equals("nan")) {
                                            fVar.aEX = Float.valueOf(fVar.bSP.getDefaultValue());
                                            break;
                                        } else {
                                            fVar.aEX = Float.valueOf(Float.NaN);
                                            break;
                                        }
                                    } else {
                                        fVar.aEX = Float.valueOf(Float.NEGATIVE_INFINITY);
                                        break;
                                    }
                                } else {
                                    fVar.aEX = Float.valueOf(Float.POSITIVE_INFINITY);
                                    break;
                                }
                            case DOUBLE:
                                if (!fVar.bSP.getDefaultValue().equals("inf")) {
                                    if (!fVar.bSP.getDefaultValue().equals("-inf")) {
                                        if (!fVar.bSP.getDefaultValue().equals("nan")) {
                                            fVar.aEX = Double.valueOf(fVar.bSP.getDefaultValue());
                                            break;
                                        } else {
                                            fVar.aEX = Double.valueOf(Double.NaN);
                                            break;
                                        }
                                    } else {
                                        fVar.aEX = Double.valueOf(Double.NEGATIVE_INFINITY);
                                        break;
                                    }
                                } else {
                                    fVar.aEX = Double.valueOf(Double.POSITIVE_INFINITY);
                                    break;
                                }
                            case BOOL:
                                fVar.aEX = Boolean.valueOf(fVar.bSP.getDefaultValue());
                                break;
                            case STRING:
                                fVar.aEX = fVar.bSP.getDefaultValue();
                                break;
                            case BYTES:
                                try {
                                    fVar.aEX = bx.t(fVar.bSP.getDefaultValue());
                                    break;
                                } catch (bx.a e2) {
                                    throw new c(fVar, "Couldn't parse default value: " + e2.getMessage(), e2, (byte) 0);
                                }
                            case ENUM:
                                d dVar = fVar.bSV;
                                h cj = dVar.bSr.bTG.cj(dVar.fullName + '.' + fVar.bSP.getDefaultValue());
                                if (cj == null || !(cj instanceof e)) {
                                    eVar = null;
                                } else {
                                    eVar = (e) cj;
                                }
                                fVar.aEX = eVar;
                                if (fVar.aEX == null) {
                                    throw new c(fVar, "Unknown enum default value: \"" + fVar.bSP.getDefaultValue() + '\"', (byte) 0);
                                }
                                break;
                            case MESSAGE:
                            case GROUP:
                                throw new c(fVar, "Message type had default value.", (byte) 0);
                        }
                    } catch (NumberFormatException e3) {
                        throw new c(fVar, "Could not parse default value: \"" + fVar.bSP.getDefaultValue() + '\"', e3, (byte) 0);
                    }
                }
                if (!fVar.bSP.Cp()) {
                    b bVar = fVar.bSr.bTG;
                    b.a aVar = new b.a(fVar.bSs, fVar.bSP.bPE);
                    f put = bVar.bSB.put(aVar, fVar);
                    if (put != null) {
                        bVar.bSB.put(aVar, put);
                        throw new c(fVar, "Field number " + fVar.bSP.bPE + " has already been used in \"" + fVar.bSs.fullName + "\" by field \"" + put.bSP.getName() + "\".", (byte) 0);
                    }
                }
                if (fVar.bSs != null && fVar.bSs.bSq.AG().bRt) {
                    if (!fVar.bSP.Cp()) {
                        throw new c(fVar, "MessageSets cannot have fields, only extensions.", (byte) 0);
                    } else if (!fVar.FI() || fVar.bSS != b.MESSAGE) {
                        throw new c(fVar, "Extensions of MessageSets must be optional messages.", (byte) 0);
                    }
                }
            } else {
                throw new c(fVar, "[packed = true] can only be specified for repeated primitive fields.", (byte) 0);
            }
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // java.lang.Comparable
        public final /* synthetic */ int compareTo(f fVar) {
            f fVar2 = fVar;
            if (fVar2.bSs == this.bSs) {
                return this.bSP.bPE - fVar2.bSP.bPE;
            }
            throw new IllegalArgumentException("FieldDescriptors can only be compared to other FieldDescriptors for fields of the same message type.");
        }

        @Override // com.google.a.l.h
        public final String getName() {
            return this.bSP.getName();
        }

        @Override // com.google.a.x.a
        public final int getNumber() {
            return this.bSP.bPE;
        }

        @Override // com.google.a.l.h
        public final String Fw() {
            return this.fullName;
        }

        @Override // com.google.a.x.a
        public final cj.b FD() {
            return FE().caU;
        }

        @Override // com.google.a.l.h
        public final g Fx() {
            return this.bSr;
        }

        @Override // com.google.a.x.a
        public final cj.a FE() {
            return bSO[this.bSS.ordinal()];
        }

        public final boolean FF() {
            if (this.bSS != b.STRING) {
                return false;
            }
            if (this.bSs.bSq.AG().bRv || this.bSr.FQ() == g.a.PROTO3) {
                return true;
            }
            return this.bSr.bTB.CQ().bQY;
        }

        static {
            if (b.values().length != k.m.c.values().length) {
                throw new RuntimeException("descriptor.proto has a new declared type but Descriptors.java wasn't updated.");
            }
        }

        public final boolean FH() {
            return this.bSP.Cl() == k.m.b.LABEL_REQUIRED;
        }

        public final boolean FI() {
            return this.bSP.Cl() == k.m.b.LABEL_OPTIONAL;
        }

        @Override // com.google.a.x.a
        public final boolean FJ() {
            return this.bSP.Cl() == k.m.b.LABEL_REPEATED;
        }

        @Override // com.google.a.x.a
        public final boolean FK() {
            if (!FL()) {
                return false;
            }
            if (this.bSr.FQ() == g.a.PROTO2) {
                return this.bSP.Cv().bQs;
            }
            if (!this.bSP.Cv().CC() || this.bSP.Cv().bQs) {
                return true;
            }
            return false;
        }

        public final boolean FL() {
            return FJ() && FE().FL();
        }

        public enum b {
            DOUBLE(a.DOUBLE),
            FLOAT(a.FLOAT),
            INT64(a.LONG),
            UINT64(a.LONG),
            INT32(a.INT),
            FIXED64(a.LONG),
            FIXED32(a.INT),
            BOOL(a.BOOLEAN),
            STRING(a.STRING),
            GROUP(a.MESSAGE),
            MESSAGE(a.MESSAGE),
            BYTES(a.BYTE_STRING),
            UINT32(a.INT),
            ENUM(a.ENUM),
            SFIXED32(a.INT),
            SFIXED64(a.LONG),
            SINT32(a.INT),
            SINT64(a.LONG);
            
            a bTz;

            private b(a aVar) {
                this.bTz = aVar;
            }

            public static b b(k.m.c cVar) {
                return values()[cVar.value - 1];
            }
        }

        public enum a {
            INT(0),
            LONG(0L),
            FLOAT(Float.valueOf(0.0f)),
            DOUBLE(Double.valueOf(0.0d)),
            BOOLEAN(Boolean.FALSE),
            STRING(""),
            BYTE_STRING(g.bNg),
            ENUM(null),
            MESSAGE(null);
            
            private final Object bTf;

            private a(Object obj) {
                this.bTf = obj;
            }
        }

        private f(k.m mVar, g gVar, a aVar, int i2, boolean z) {
            boolean z2;
            this.index = i2;
            this.bSP = mVar;
            this.fullName = l.a(gVar, aVar, mVar.getName());
            this.bSr = gVar;
            if (mVar.Ct()) {
                this.bSQ = mVar.Cu();
            } else {
                String name = mVar.getName();
                int length = name.length();
                StringBuilder sb = new StringBuilder(length);
                int i3 = 0;
                boolean z3 = false;
                while (i3 < length) {
                    char charAt = name.charAt(i3);
                    if (charAt == '_') {
                        z2 = true;
                    } else if (z3) {
                        if ('a' <= charAt && charAt <= 'z') {
                            charAt = (char) ((charAt - 'a') + 65);
                        }
                        sb.append(charAt);
                        z2 = false;
                    } else {
                        sb.append(charAt);
                        z2 = z3;
                    }
                    i3++;
                    z3 = z2;
                }
                this.bSQ = sb.toString();
            }
            if (mVar.Cm()) {
                this.bSS = b.b(mVar.Cn());
            }
            if (this.bSP.bPE <= 0) {
                throw new c(this, "Field numbers must be positive integers.", (byte) 0);
            }
            if (z) {
                if (!mVar.Cp()) {
                    throw new c(this, "FieldDescriptorProto.extendee not set for extension field.", (byte) 0);
                }
                this.bSs = null;
                if (aVar != null) {
                    this.bSR = aVar;
                } else {
                    this.bSR = null;
                }
                if (mVar.Cs()) {
                    throw new c(this, "FieldDescriptorProto.oneof_index set for extension field.", (byte) 0);
                }
                this.bSU = null;
            } else if (mVar.Cp()) {
                throw new c(this, "FieldDescriptorProto.extendee set for non-extension field.", (byte) 0);
            } else {
                this.bSs = aVar;
                if (!mVar.Cs()) {
                    this.bSU = null;
                } else if (mVar.bPN < 0 || mVar.bPN >= aVar.bSq.AE()) {
                    throw new c(this, "FieldDescriptorProto.oneof_index is out of range for type " + aVar.bSq.getName(), (byte) 0);
                } else {
                    this.bSU = aVar.Fy().get(mVar.bPN);
                    j.c(this.bSU);
                }
                this.bSR = null;
            }
            gVar.bTG.c(this);
        }

        @Override // com.google.a.x.a
        public final aw.a a(aw.a aVar, aw awVar) {
            return ((at.a) aVar).c((at) awVar);
        }

        public final boolean FG() {
            return this.bSS == b.MESSAGE && FJ() && FN().bSq.AG().bRv;
        }

        public final Object getDefaultValue() {
            if (this.bSS.bTz != a.MESSAGE) {
                return this.aEX;
            }
            throw new UnsupportedOperationException("FieldDescriptor.getDefaultValue() called on an embedded message field.");
        }

        public final a FM() {
            if (this.bSP.Cp()) {
                return this.bSR;
            }
            throw new UnsupportedOperationException(String.format("This field is not an extension. (%s)", this.fullName));
        }

        public final a FN() {
            if (this.bSS.bTz == a.MESSAGE) {
                return this.bST;
            }
            throw new UnsupportedOperationException(String.format("This field is not of message type. (%s)", this.fullName));
        }

        public final d FO() {
            if (this.bSS.bTz == a.ENUM) {
                return this.bSV;
            }
            throw new UnsupportedOperationException(String.format("This field is not of enum type. (%s)", this.fullName));
        }

        public final String toString() {
            return this.fullName;
        }

        @Override // com.google.a.l.h
        public final /* bridge */ /* synthetic */ at FC() {
            return this.bSP;
        }
    }

    public static final class d extends h implements ae.b<e> {
        k.c bSJ;
        e[] bSK;
        private final WeakHashMap<Integer, WeakReference<e>> bSL;
        final g bSr;
        private final a bSs;
        final String fullName;
        private final int index;

        /* synthetic */ d(k.c cVar, g gVar, a aVar, int i2, byte b2) {
            this(cVar, gVar, aVar, i2);
        }

        @Override // com.google.a.l.h
        public final String getName() {
            return this.bSJ.getName();
        }

        @Override // com.google.a.l.h
        public final String Fw() {
            return this.fullName;
        }

        @Override // com.google.a.l.h
        public final g Fx() {
            return this.bSr;
        }

        public final e gA(int i2) {
            return this.bSr.bTG.bSC.get(new b.a(this, i2));
        }

        public final e gB(int i2) {
            e eVar;
            e gA = gA(i2);
            if (gA != null) {
                return gA;
            }
            synchronized (this) {
                Integer valueOf = Integer.valueOf(i2);
                WeakReference<e> weakReference = this.bSL.get(valueOf);
                if (weakReference != null) {
                    eVar = weakReference.get();
                } else {
                    eVar = gA;
                }
                if (eVar == null) {
                    eVar = new e(this.bSr, this, valueOf, (byte) 0);
                    this.bSL.put(valueOf, new WeakReference<>(eVar));
                }
            }
            return eVar;
        }

        private d(k.c cVar, g gVar, a aVar, int i2) {
            this.bSL = new WeakHashMap<>();
            this.index = i2;
            this.bSJ = cVar;
            this.fullName = l.a(gVar, aVar, cVar.getName());
            this.bSr = gVar;
            this.bSs = aVar;
            if (cVar.getValueCount() == 0) {
                throw new c(this, "Enums must contain at least one value.", (byte) 0);
            }
            this.bSK = new e[cVar.getValueCount()];
            for (int i3 = 0; i3 < cVar.getValueCount(); i3++) {
                this.bSK[i3] = new e(cVar.gj(i3), gVar, this, i3, (byte) 0);
            }
            gVar.bTG.c(this);
        }

        @Override // com.google.a.l.h
        public final /* bridge */ /* synthetic */ at FC() {
            return this.bSJ;
        }
    }

    public static final class e extends h implements ae.a {
        k.g bSM;
        final d bSN;
        private final g bSr;
        private final String fullName;
        private final int index;

        /* synthetic */ e(k.g gVar, g gVar2, d dVar, int i2, byte b2) {
            this(gVar, gVar2, dVar, i2);
        }

        /* synthetic */ e(g gVar, d dVar, Integer num, byte b2) {
            this(gVar, dVar, num);
        }

        @Override // com.google.a.l.h
        public final String getName() {
            return this.bSM.getName();
        }

        @Override // com.google.a.ae.a
        public final int getNumber() {
            return this.bSM.bPE;
        }

        public final String toString() {
            return this.bSM.getName();
        }

        @Override // com.google.a.l.h
        public final String Fw() {
            return this.fullName;
        }

        @Override // com.google.a.l.h
        public final g Fx() {
            return this.bSr;
        }

        private e(k.g gVar, g gVar2, d dVar, int i2) {
            this.index = i2;
            this.bSM = gVar;
            this.bSr = gVar2;
            this.bSN = dVar;
            this.fullName = dVar.fullName + '.' + gVar.getName();
            gVar2.bTG.c(this);
            b bVar = gVar2.bTG;
            b.a aVar = new b.a(this.bSN, this.bSM.bPE);
            e put = bVar.bSC.put(aVar, this);
            if (put != null) {
                bVar.bSC.put(aVar, put);
            }
        }

        private e(g gVar, d dVar, Integer num) {
            k.g Ca = k.g.BX().cf("UNKNOWN_ENUM_VALUE_" + dVar.bSJ.getName() + "_" + num).gm(num.intValue()).Bp();
            this.index = -1;
            this.bSM = Ca;
            this.bSr = gVar;
            this.bSN = dVar;
            this.fullName = dVar.fullName + '.' + Ca.getName();
        }

        @Override // com.google.a.l.h
        public final /* bridge */ /* synthetic */ at FC() {
            return this.bSM;
        }
    }

    public static final class k extends h {
        private final g bSr;
        private k.ae bTR;
        i[] bTS;
        final String fullName;
        private final int index;

        /* synthetic */ k(k.ae aeVar, g gVar, int i2, byte b2) {
            this(aeVar, gVar, i2);
        }

        @Override // com.google.a.l.h
        public final String getName() {
            return this.bTR.getName();
        }

        @Override // com.google.a.l.h
        public final String Fw() {
            return this.fullName;
        }

        @Override // com.google.a.l.h
        public final g Fx() {
            return this.bSr;
        }

        private k(k.ae aeVar, g gVar, int i2) {
            this.index = i2;
            this.bTR = aeVar;
            this.fullName = l.a(gVar, null, aeVar.getName());
            this.bSr = gVar;
            this.bTS = new i[aeVar.Ex()];
            for (int i3 = 0; i3 < aeVar.Ex(); i3++) {
                this.bTS[i3] = new i(aeVar.gx(i3), gVar, this, i3, (byte) 0);
            }
            gVar.bTG.c(this);
        }

        @Override // com.google.a.l.h
        public final /* bridge */ /* synthetic */ at FC() {
            return this.bTR;
        }
    }

    public static final class i extends h {
        final g bSr;
        k.w bTL;
        private final k bTM;
        a bTN;
        a bTO;
        private final String fullName;
        private final int index;

        /* synthetic */ i(k.w wVar, g gVar, k kVar, int i2, byte b2) {
            this(wVar, gVar, kVar, i2);
        }

        @Override // com.google.a.l.h
        public final String getName() {
            return this.bTL.getName();
        }

        @Override // com.google.a.l.h
        public final String Fw() {
            return this.fullName;
        }

        @Override // com.google.a.l.h
        public final g Fx() {
            return this.bSr;
        }

        private i(k.w wVar, g gVar, k kVar, int i2) {
            this.index = i2;
            this.bTL = wVar;
            this.bSr = gVar;
            this.bTM = kVar;
            this.fullName = kVar.fullName + '.' + wVar.getName();
            gVar.bTG.c(this);
        }

        @Override // com.google.a.l.h
        public final /* bridge */ /* synthetic */ at FC() {
            return this.bTL;
        }
    }

    public static class c extends Exception {
        private final at bSI;
        private final String description;
        private final String name;

        /* synthetic */ c(g gVar, String str, byte b2) {
            this(gVar, str);
        }

        /* synthetic */ c(h hVar, String str, byte b2) {
            this(hVar, str);
        }

        /* synthetic */ c(h hVar, String str, Throwable th, byte b2) {
            this(hVar, str, th);
        }

        private c(h hVar, String str) {
            super(hVar.Fw() + ": " + str);
            this.name = hVar.Fw();
            this.bSI = hVar.FC();
            this.description = str;
        }

        private c(h hVar, String str, Throwable th) {
            this(hVar, str);
            initCause(th);
        }

        private c(g gVar, String str) {
            super(gVar.bTB.getName() + ": " + str);
            this.name = gVar.bTB.getName();
            this.bSI = gVar.bTB;
            this.description = str;
        }
    }

    /* access modifiers changed from: package-private */
    public static final class b {
        private final Map<String, h> bSA = new HashMap();
        final Map<a, f> bSB = new HashMap();
        final Map<a, e> bSC = new HashMap();
        private final Set<g> bSy = new HashSet();
        private boolean bSz = true;

        /* access modifiers changed from: package-private */
        public enum c {
            TYPES_ONLY,
            AGGREGATES_ONLY,
            ALL_SYMBOLS
        }

        b(g[] gVarArr) {
            for (int i2 = 0; i2 < gVarArr.length; i2++) {
                this.bSy.add(gVarArr[i2]);
                a(gVarArr[i2]);
            }
            for (g gVar : this.bSy) {
                try {
                    a(gVar.bTB.getPackage(), gVar);
                } catch (c e2) {
                    throw new AssertionError(e2);
                }
            }
        }

        /* access modifiers changed from: package-private */
        public final h cj(String str) {
            return a(str, c.ALL_SYMBOLS);
        }

        private h a(String str, c cVar) {
            h hVar = this.bSA.get(str);
            if (hVar != null) {
                if (cVar == c.ALL_SYMBOLS) {
                    return hVar;
                }
                if (cVar == c.TYPES_ONLY && a(hVar)) {
                    return hVar;
                }
                if (cVar == c.AGGREGATES_ONLY && b(hVar)) {
                    return hVar;
                }
            }
            for (g gVar : this.bSy) {
                h hVar2 = gVar.bTG.bSA.get(str);
                if (hVar2 != null) {
                    if (cVar == c.ALL_SYMBOLS) {
                        return hVar2;
                    }
                    if (cVar == c.TYPES_ONLY && a(hVar2)) {
                        return hVar2;
                    }
                    if (cVar == c.AGGREGATES_ONLY && b(hVar2)) {
                        return hVar2;
                    }
                }
            }
            return null;
        }

        private static boolean a(h hVar) {
            return (hVar instanceof a) || (hVar instanceof d);
        }

        private static boolean b(h hVar) {
            return (hVar instanceof a) || (hVar instanceof d) || (hVar instanceof C0097b) || (hVar instanceof k);
        }

        /* access modifiers changed from: package-private */
        public final h a(String str, h hVar, c cVar) {
            String substring;
            h a2;
            String str2;
            if (str.startsWith(".")) {
                str2 = str.substring(1);
                a2 = a(str2, cVar);
            } else {
                int indexOf = str.indexOf(46);
                if (indexOf == -1) {
                    substring = str;
                } else {
                    substring = str.substring(0, indexOf);
                }
                StringBuilder sb = new StringBuilder(hVar.Fw());
                while (true) {
                    int lastIndexOf = sb.lastIndexOf(".");
                    if (lastIndexOf == -1) {
                        a2 = a(str, cVar);
                        str2 = str;
                        break;
                    }
                    sb.setLength(lastIndexOf + 1);
                    sb.append(substring);
                    h a3 = a(sb.toString(), c.AGGREGATES_ONLY);
                    if (a3 != null) {
                        if (indexOf != -1) {
                            sb.setLength(lastIndexOf + 1);
                            sb.append(str);
                            a2 = a(sb.toString(), cVar);
                        } else {
                            a2 = a3;
                        }
                        str2 = sb.toString();
                    } else {
                        sb.setLength(lastIndexOf);
                    }
                }
            }
            if (a2 != null) {
                return a2;
            }
            if (!this.bSz || cVar != c.TYPES_ONLY) {
                throw new c(hVar, "\"" + str + "\" is not defined.", (byte) 0);
            }
            l.logger.warning("The descriptor for message type \"" + str + "\" can not be found and a placeholder is created for it");
            a aVar = new a(str2);
            this.bSy.add(aVar.Fx());
            return aVar;
        }

        /* access modifiers changed from: package-private */
        public final void c(h hVar) {
            d(hVar);
            String Fw = hVar.Fw();
            h put = this.bSA.put(Fw, hVar);
            if (put != null) {
                this.bSA.put(Fw, put);
                if (hVar.Fx() == put.Fx()) {
                    int lastIndexOf = Fw.lastIndexOf(46);
                    if (lastIndexOf == -1) {
                        throw new c(hVar, "\"" + Fw + "\" is already defined.", (byte) 0);
                    }
                    throw new c(hVar, "\"" + Fw.substring(lastIndexOf + 1) + "\" is already defined in \"" + Fw.substring(0, lastIndexOf) + "\".", (byte) 0);
                }
                throw new c(hVar, "\"" + Fw + "\" is already defined in file \"" + put.Fx().bTB.getName() + "\".", (byte) 0);
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: com.google.a.l$b$b  reason: collision with other inner class name */
        public static final class C0097b extends h {
            private final g bSr;
            private final String fullName;
            private final String name;

            @Override // com.google.a.l.h
            public final at FC() {
                return this.bSr.bTB;
            }

            @Override // com.google.a.l.h
            public final String getName() {
                return this.name;
            }

            @Override // com.google.a.l.h
            public final String Fw() {
                return this.fullName;
            }

            @Override // com.google.a.l.h
            public final g Fx() {
                return this.bSr;
            }

            C0097b(String str, String str2, g gVar) {
                this.bSr = gVar;
                this.fullName = str2;
                this.name = str;
            }
        }

        /* access modifiers changed from: package-private */
        public final void a(String str, g gVar) {
            String substring;
            int lastIndexOf = str.lastIndexOf(46);
            if (lastIndexOf == -1) {
                substring = str;
            } else {
                a(str.substring(0, lastIndexOf), gVar);
                substring = str.substring(lastIndexOf + 1);
            }
            h put = this.bSA.put(str, new C0097b(substring, str, gVar));
            if (put != null) {
                this.bSA.put(str, put);
                if (!(put instanceof C0097b)) {
                    throw new c(gVar, "\"" + substring + "\" is already defined (as something other than a package) in file \"" + put.Fx().bTB.getName() + "\".", (byte) 0);
                }
            }
        }

        /* access modifiers changed from: package-private */
        public static final class a {
            private final h bSD;
            private final int number;

            a(h hVar, int i2) {
                this.bSD = hVar;
                this.number = i2;
            }

            public final int hashCode() {
                return (this.bSD.hashCode() * 65535) + this.number;
            }

            public final boolean equals(Object obj) {
                if (!(obj instanceof a)) {
                    return false;
                }
                a aVar = (a) obj;
                if (this.bSD == aVar.bSD && this.number == aVar.number) {
                    return true;
                }
                return false;
            }
        }

        private static void d(h hVar) {
            String name = hVar.getName();
            if (name.length() == 0) {
                throw new c(hVar, "Missing name.", (byte) 0);
            }
            for (int i2 = 0; i2 < name.length(); i2++) {
                char charAt = name.charAt(i2);
                if (('a' > charAt || charAt > 'z') && (('A' > charAt || charAt > 'Z') && charAt != '_' && ('0' > charAt || charAt > '9' || i2 <= 0))) {
                    throw new c(hVar, "\"" + name + "\" is not a valid identifier.", (byte) 0);
                }
            }
        }

        private void a(g gVar) {
            for (g gVar2 : Collections.unmodifiableList(Arrays.asList(gVar.bTF))) {
                if (this.bSy.add(gVar2)) {
                    a(gVar2);
                }
            }
        }
    }

    public static final class j {
        private final g bSr;
        a bSs;
        f[] bSv;
        k.aa bTP;
        int bTQ;
        private final String fullName;
        final int index;

        /* synthetic */ j(k.aa aaVar, g gVar, a aVar, int i2, byte b2) {
            this(aaVar, gVar, aVar, i2);
        }

        static /* synthetic */ int c(j jVar) {
            int i2 = jVar.bTQ;
            jVar.bTQ = i2 + 1;
            return i2;
        }

        private j(k.aa aaVar, g gVar, a aVar, int i2) {
            this.bTP = aaVar;
            this.fullName = l.a(gVar, aVar, aaVar.getName());
            this.bSr = gVar;
            this.index = i2;
            this.bSs = aVar;
            this.bTQ = 0;
        }
    }
}

package com.google.a;

import android.support.constraint.ConstraintLayout;
import com.google.a.a;
import com.google.a.ac;
import com.google.a.ae;
import com.google.a.at;
import com.google.a.aw;
import com.google.a.b;
import com.google.a.cc;
import com.google.a.l;
import com.tencent.qqmusic.mediaplayer.PlayerException;
import com.tencent.thumbplayer.core.common.TPMediaCodecProfileLevel;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class k {
    private static final l.a bNQ;
    private static final ac.f bNR = new ac.f(bNQ, new String[]{"File"});
    private static final l.a bNS = bOS.FP().get(1);
    private static final ac.f bNT = new ac.f(bNS, new String[]{"Name", "Package", "Dependency", "PublicDependency", "WeakDependency", "MessageType", "EnumType", "Service", "Extension", "Options", "SourceCodeInfo", "Syntax"});
    private static final l.a bNU = bOS.FP().get(2);
    private static final ac.f bNV = new ac.f(bNU, new String[]{"Name", "Field", "Extension", "NestedType", "EnumType", "ExtensionRange", "OneofDecl", "Options", "ReservedRange", "ReservedName"});
    private static final l.a bNW = bNU.Fz().get(0);
    private static final ac.f bNX = new ac.f(bNW, new String[]{"Start", "End", "Options"});
    private static final l.a bNY = bNU.Fz().get(1);
    private static final ac.f bNZ = new ac.f(bNY, new String[]{"Start", "End"});
    private static final l.a bOA = bOS.FP().get(15);
    private static final ac.f bOB = new ac.f(bOA, new String[]{"Deprecated", "UninterpretedOption"});
    private static final l.a bOC = bOS.FP().get(16);
    private static final ac.f bOD = new ac.f(bOC, new String[]{"Deprecated", "UninterpretedOption"});
    private static final l.a bOE = bOS.FP().get(17);
    private static final ac.f bOF = new ac.f(bOE, new String[]{"Deprecated", "IdempotencyLevel", "UninterpretedOption"});
    private static final l.a bOG = bOS.FP().get(18);
    private static final ac.f bOH = new ac.f(bOG, new String[]{"Name", "IdentifierValue", "PositiveIntValue", "NegativeIntValue", "DoubleValue", "StringValue", "AggregateValue"});
    private static final l.a bOI = bOG.Fz().get(0);
    private static final ac.f bOJ = new ac.f(bOI, new String[]{"NamePart", "IsExtension"});
    private static final l.a bOK = bOS.FP().get(19);
    private static final ac.f bOL = new ac.f(bOK, new String[]{"Location"});
    private static final l.a bOM = bOK.Fz().get(0);
    private static final ac.f bON = new ac.f(bOM, new String[]{"Path", "Span", "LeadingComments", "TrailingComments", "LeadingDetachedComments"});
    private static final l.a bOO = bOS.FP().get(20);
    private static final ac.f bOP = new ac.f(bOO, new String[]{"Annotation"});
    private static final l.a bOQ = bOO.Fz().get(0);
    private static final ac.f bOR = new ac.f(bOQ, new String[]{"Path", "SourceFile", "Begin", "End"});
    private static l.g bOS;
    private static final l.a bOa = bOS.FP().get(3);
    private static final ac.f bOb = new ac.f(bOa, new String[]{"UninterpretedOption"});
    private static final l.a bOc = bOS.FP().get(4);
    private static final ac.f bOd = new ac.f(bOc, new String[]{"Name", "Number", "Label", "Type", "TypeName", "Extendee", "DefaultValue", "OneofIndex", "JsonName", "Options"});
    private static final l.a bOe = bOS.FP().get(5);
    private static final ac.f bOf = new ac.f(bOe, new String[]{"Name", "Options"});
    private static final l.a bOg = bOS.FP().get(6);
    private static final ac.f bOh = new ac.f(bOg, new String[]{"Name", "Value", "Options", "ReservedRange", "ReservedName"});
    private static final l.a bOi = bOg.Fz().get(0);
    private static final ac.f bOj = new ac.f(bOi, new String[]{"Start", "End"});
    private static final l.a bOk = bOS.FP().get(7);
    private static final ac.f bOl = new ac.f(bOk, new String[]{"Name", "Number", "Options"});
    private static final l.a bOm = bOS.FP().get(8);
    private static final ac.f bOn = new ac.f(bOm, new String[]{"Name", "Method", "Options"});
    private static final l.a bOo = bOS.FP().get(9);
    private static final ac.f bOp = new ac.f(bOo, new String[]{"Name", "InputType", "OutputType", "Options", "ClientStreaming", "ServerStreaming"});
    private static final l.a bOq = bOS.FP().get(10);
    private static final ac.f bOr = new ac.f(bOq, new String[]{"JavaPackage", "JavaOuterClassname", "JavaMultipleFiles", "JavaGenerateEqualsAndHash", "JavaStringCheckUtf8", "OptimizeFor", "GoPackage", "CcGenericServices", "JavaGenericServices", "PyGenericServices", "PhpGenericServices", "Deprecated", "CcEnableArenas", "ObjcClassPrefix", "CsharpNamespace", "SwiftPrefix", "PhpClassPrefix", "PhpNamespace", "PhpMetadataNamespace", "RubyPackage", "UninterpretedOption"});
    private static final l.a bOs = bOS.FP().get(11);
    private static final ac.f bOt = new ac.f(bOs, new String[]{"MessageSetWireFormat", "NoStandardDescriptorAccessor", "Deprecated", "MapEntry", "UninterpretedOption"});
    private static final l.a bOu = bOS.FP().get(12);
    private static final ac.f bOv = new ac.f(bOu, new String[]{"Ctype", "Packed", "Jstype", "Lazy", "Deprecated", "Weak", "UninterpretedOption"});
    private static final l.a bOw = bOS.FP().get(13);
    private static final ac.f bOx = new ac.f(bOw, new String[]{"UninterpretedOption"});
    private static final l.a bOy = bOS.FP().get(14);
    private static final ac.f bOz = new ac.f(bOy, new String[]{"AllowAlias", "Deprecated", "UninterpretedOption"});

    public interface ab extends az {
    }

    public interface ad extends ac.e {
    }

    public interface af extends az {
    }

    public interface ah extends ac.e {
    }

    public interface aj extends az {
    }

    public interface al extends az {
    }

    public interface b extends az {
    }

    public interface d extends az {
    }

    public interface f extends ac.e {
    }

    public interface h extends az {
    }

    public interface j extends ac.e {
    }

    public interface l extends ac.e {
    }

    public interface n extends az {
    }

    public interface p extends ac.e {
    }

    public interface r extends az {
    }

    public interface t extends ac.e {
    }

    public interface v extends ac.e {
    }

    public interface x extends az {
    }

    public interface z extends ac.e {
    }

    public static final class q extends ac implements r {
        @Deprecated
        public static final bj<q> bPg = new c<q>() {
            /* class com.google.a.k.q.AnonymousClass1 */

            @Override // com.google.a.bj
            public final /* synthetic */ Object d(h hVar, r rVar) {
                return new q(hVar, rVar, (byte) 0);
            }
        };
        private static final q bQQ = new q();
        private int bOT;
        private volatile Object bOU;
        private List<m> bOW;
        private List<c> bOY;
        private byte bPe;
        private volatile Object bQH;
        ak bQI;
        ae.d bQJ;
        private ae.d bQK;
        private List<a> bQL;
        private List<ae> bQM;
        private s bQN;
        private ai bQO;
        private volatile Object bQP;

        /* synthetic */ q(ac.a aVar, byte b2) {
            this(aVar);
        }

        /* synthetic */ q(h hVar, r rVar, byte b2) {
            this(hVar, rVar);
        }

        private q(ac.a<?> aVar) {
            super(aVar);
            this.bPe = -1;
        }

        private q() {
            this.bPe = -1;
            this.bOU = "";
            this.bQH = "";
            this.bQI = aj.bXM;
            this.bQJ = ad.GE();
            this.bQK = ad.GE();
            this.bQL = Collections.emptyList();
            this.bOY = Collections.emptyList();
            this.bQM = Collections.emptyList();
            this.bOW = Collections.emptyList();
            this.bQP = "";
        }

        @Override // com.google.a.az, com.google.a.ac
        public final cc Ax() {
            return this.bTW;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v61, resolved type: java.util.List<com.google.a.k$m> */
        /* JADX DEBUG: Multi-variable search result rejected for r0v64, resolved type: java.util.List<com.google.a.k$ae> */
        /* JADX DEBUG: Multi-variable search result rejected for r0v67, resolved type: java.util.List<com.google.a.k$c> */
        /* JADX DEBUG: Multi-variable search result rejected for r0v70, resolved type: java.util.List<com.google.a.k$a> */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARNING: Removed duplicated region for block: B:24:0x0040  */
        /* JADX WARNING: Removed duplicated region for block: B:27:0x004c  */
        /* JADX WARNING: Removed duplicated region for block: B:30:0x0058  */
        /* JADX WARNING: Removed duplicated region for block: B:33:0x0064  */
        /* JADX WARNING: Removed duplicated region for block: B:36:0x0070  */
        /* JADX WARNING: Removed duplicated region for block: B:39:0x007c  */
        /* JADX WARNING: Removed duplicated region for block: B:42:0x0085  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private q(com.google.a.h r9, com.google.a.r r10) {
            /*
            // Method dump skipped, instructions count: 706
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.a.k.q.<init>(com.google.a.h, com.google.a.r):void");
        }

        /* access modifiers changed from: protected */
        @Override // com.google.a.ac
        public final ac.f Ay() {
            return k.bNT.h(q.class, a.class);
        }

        public final boolean Az() {
            return (this.bOT & 1) != 0;
        }

        public final String getName() {
            Object obj = this.bOU;
            if (obj instanceof String) {
                return (String) obj;
            }
            g gVar = (g) obj;
            String yO = gVar.yO();
            if (gVar.yP()) {
                this.bOU = yO;
            }
            return yO;
        }

        public final boolean CL() {
            return (this.bOT & 2) != 0;
        }

        public final String getPackage() {
            Object obj = this.bQH;
            if (obj instanceof String) {
                return (String) obj;
            }
            g gVar = (g) obj;
            String yO = gVar.yO();
            if (gVar.yP()) {
                this.bQH = yO;
            }
            return yO;
        }

        public final int CM() {
            return this.bQI.size();
        }

        public final int CN() {
            return this.bQJ.size();
        }

        public final int CO() {
            return this.bQL.size();
        }

        public final a gt(int i2) {
            return this.bQL.get(i2);
        }

        public final int AC() {
            return this.bOY.size();
        }

        public final c gd(int i2) {
            return this.bOY.get(i2);
        }

        public final int CP() {
            return this.bQM.size();
        }

        public final ae gu(int i2) {
            return this.bQM.get(i2);
        }

        public final int AA() {
            return this.bOW.size();
        }

        public final m gb(int i2) {
            return this.bOW.get(i2);
        }

        public final boolean AF() {
            return (this.bOT & 4) != 0;
        }

        public final s CQ() {
            return this.bQN == null ? s.DN() : this.bQN;
        }

        public final boolean CR() {
            return (this.bOT & 8) != 0;
        }

        public final ai CS() {
            return this.bQO == null ? ai.EK() : this.bQO;
        }

        public final boolean CT() {
            return (this.bOT & 16) != 0;
        }

        public final String CU() {
            Object obj = this.bQP;
            if (obj instanceof String) {
                return (String) obj;
            }
            g gVar = (g) obj;
            String yO = gVar.yO();
            if (gVar.yP()) {
                this.bQP = yO;
            }
            return yO;
        }

        @Override // com.google.a.a, com.google.a.ax, com.google.a.ac
        public final boolean isInitialized() {
            byte b2 = this.bPe;
            if (b2 == 1) {
                return true;
            }
            if (b2 == 0) {
                return false;
            }
            for (int i2 = 0; i2 < CO(); i2++) {
                if (!gt(i2).isInitialized()) {
                    this.bPe = 0;
                    return false;
                }
            }
            for (int i3 = 0; i3 < AC(); i3++) {
                if (!gd(i3).isInitialized()) {
                    this.bPe = 0;
                    return false;
                }
            }
            for (int i4 = 0; i4 < CP(); i4++) {
                if (!gu(i4).isInitialized()) {
                    this.bPe = 0;
                    return false;
                }
            }
            for (int i5 = 0; i5 < AA(); i5++) {
                if (!gb(i5).isInitialized()) {
                    this.bPe = 0;
                    return false;
                }
            }
            if (!AF() || CQ().isInitialized()) {
                this.bPe = 1;
                return true;
            }
            this.bPe = 0;
            return false;
        }

        @Override // com.google.a.aw, com.google.a.a, com.google.a.ac
        public final void a(i iVar) {
            if ((this.bOT & 1) != 0) {
                ac.a(iVar, 1, this.bOU);
            }
            if ((this.bOT & 2) != 0) {
                ac.a(iVar, 2, this.bQH);
            }
            for (int i2 = 0; i2 < this.bQI.size(); i2++) {
                ac.a(iVar, 3, this.bQI.getRaw(i2));
            }
            for (int i3 = 0; i3 < this.bQL.size(); i3++) {
                iVar.a(4, this.bQL.get(i3));
            }
            for (int i4 = 0; i4 < this.bOY.size(); i4++) {
                iVar.a(5, this.bOY.get(i4));
            }
            for (int i5 = 0; i5 < this.bQM.size(); i5++) {
                iVar.a(6, this.bQM.get(i5));
            }
            for (int i6 = 0; i6 < this.bOW.size(); i6++) {
                iVar.a(7, this.bOW.get(i6));
            }
            if ((this.bOT & 4) != 0) {
                iVar.a(8, CQ());
            }
            if ((this.bOT & 8) != 0) {
                iVar.a(9, CS());
            }
            for (int i7 = 0; i7 < this.bQJ.size(); i7++) {
                iVar.bs(10, this.bQJ.getInt(i7));
            }
            for (int i8 = 0; i8 < this.bQK.size(); i8++) {
                iVar.bs(11, this.bQK.getInt(i8));
            }
            if ((this.bOT & 16) != 0) {
                ac.a(iVar, 12, this.bQP);
            }
            this.bTW.a(iVar);
        }

        @Override // com.google.a.aw, com.google.a.a, com.google.a.ac
        public final int yC() {
            int i2 = this.bNa;
            if (i2 != -1) {
                return i2;
            }
            int d2 = (this.bOT & 1) != 0 ? ac.d(1, this.bOU) + 0 : 0;
            if ((this.bOT & 2) != 0) {
                d2 += ac.d(2, this.bQH);
            }
            int i3 = 0;
            for (int i4 = 0; i4 < this.bQI.size(); i4++) {
                i3 += ar(this.bQI.getRaw(i4));
            }
            int size = d2 + i3 + (this.bQI.size() * 1);
            for (int i5 = 0; i5 < this.bQL.size(); i5++) {
                size += i.c(4, this.bQL.get(i5));
            }
            for (int i6 = 0; i6 < this.bOY.size(); i6++) {
                size += i.c(5, this.bOY.get(i6));
            }
            for (int i7 = 0; i7 < this.bQM.size(); i7++) {
                size += i.c(6, this.bQM.get(i7));
            }
            for (int i8 = 0; i8 < this.bOW.size(); i8++) {
                size += i.c(7, this.bOW.get(i8));
            }
            if ((this.bOT & 4) != 0) {
                size += i.c(8, CQ());
            }
            if ((this.bOT & 8) != 0) {
                size += i.c(9, CS());
            }
            int i9 = 0;
            for (int i10 = 0; i10 < this.bQJ.size(); i10++) {
                i9 += i.fT(this.bQJ.getInt(i10));
            }
            int size2 = size + i9 + (this.bQJ.size() * 1);
            int i11 = 0;
            for (int i12 = 0; i12 < this.bQK.size(); i12++) {
                i11 += i.fT(this.bQK.getInt(i12));
            }
            int size3 = size2 + i11 + (this.bQK.size() * 1);
            if ((this.bOT & 16) != 0) {
                size3 += ac.d(12, this.bQP);
            }
            int yC = size3 + this.bTW.yC();
            this.bNa = yC;
            return yC;
        }

        @Override // com.google.a.a
        public final boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof q)) {
                return super.equals(obj);
            }
            q qVar = (q) obj;
            if (Az() != qVar.Az()) {
                return false;
            }
            if (Az() && !getName().equals(qVar.getName())) {
                return false;
            }
            if (CL() != qVar.CL()) {
                return false;
            }
            if (CL() && !getPackage().equals(qVar.getPackage())) {
                return false;
            }
            if (!this.bQI.equals(qVar.bQI)) {
                return false;
            }
            if (!this.bQJ.equals(qVar.bQJ)) {
                return false;
            }
            if (!this.bQK.equals(qVar.bQK)) {
                return false;
            }
            if (!this.bQL.equals(qVar.bQL)) {
                return false;
            }
            if (!this.bOY.equals(qVar.bOY)) {
                return false;
            }
            if (!this.bQM.equals(qVar.bQM)) {
                return false;
            }
            if (!this.bOW.equals(qVar.bOW)) {
                return false;
            }
            if (AF() != qVar.AF()) {
                return false;
            }
            if (AF() && !CQ().equals(qVar.CQ())) {
                return false;
            }
            if (CR() != qVar.CR()) {
                return false;
            }
            if (CR() && !CS().equals(qVar.CS())) {
                return false;
            }
            if (CT() != qVar.CT()) {
                return false;
            }
            if (!CT() || CU().equals(qVar.CU())) {
                return this.bTW.equals(qVar.bTW);
            }
            return false;
        }

        @Override // com.google.a.a
        public final int hashCode() {
            if (this.bNb != 0) {
                return this.bNb;
            }
            int hashCode = k.bNS.hashCode() + com.tencent.mm.plugin.appbrand.jsapi.share.q.CTRL_INDEX;
            if (Az()) {
                hashCode = (((hashCode * 37) + 1) * 53) + getName().hashCode();
            }
            if (CL()) {
                hashCode = (((hashCode * 37) + 2) * 53) + getPackage().hashCode();
            }
            if (CM() > 0) {
                hashCode = (((hashCode * 37) + 3) * 53) + this.bQI.hashCode();
            }
            if (CN() > 0) {
                hashCode = (((hashCode * 37) + 10) * 53) + this.bQJ.hashCode();
            }
            if (this.bQK.size() > 0) {
                hashCode = (((hashCode * 37) + 11) * 53) + this.bQK.hashCode();
            }
            if (CO() > 0) {
                hashCode = (((hashCode * 37) + 4) * 53) + this.bQL.hashCode();
            }
            if (AC() > 0) {
                hashCode = (((hashCode * 37) + 5) * 53) + this.bOY.hashCode();
            }
            if (CP() > 0) {
                hashCode = (((hashCode * 37) + 6) * 53) + this.bQM.hashCode();
            }
            if (AA() > 0) {
                hashCode = (((hashCode * 37) + 7) * 53) + this.bOW.hashCode();
            }
            if (AF()) {
                hashCode = (((hashCode * 37) + 8) * 53) + CQ().hashCode();
            }
            if (CR()) {
                hashCode = (((hashCode * 37) + 9) * 53) + CS().hashCode();
            }
            if (CT()) {
                hashCode = (((hashCode * 37) + 12) * 53) + CU().hashCode();
            }
            int hashCode2 = (hashCode * 29) + this.bTW.hashCode();
            this.bNb = hashCode2;
            return hashCode2;
        }

        public static q E(byte[] bArr) {
            return bPg.y(bArr);
        }

        public static a CV() {
            return bQQ.AN();
        }

        /* access modifiers changed from: private */
        /* renamed from: CW */
        public a AN() {
            if (this == bQQ) {
                return new a((byte) 0);
            }
            return new a((byte) 0).k(this);
        }

        public static final class a extends ac.a<a> implements r {
            private int bOT;
            private Object bOU;
            private List<m> bOW;
            private List<c> bOY;
            private bq<m, m.a, n> bPi;
            private bq<c, c.a, d> bPk;
            private bu<s, s.a, t> bPn;
            private Object bQH;
            private ak bQI;
            private ae.d bQJ;
            private ae.d bQK;
            private List<a> bQL;
            private List<ae> bQM;
            private s bQN;
            private ai bQO;
            private Object bQP;
            private bq<a, a.C0092a, b> bQR;
            private bq<ae, ae.a, af> bQS;
            private bu<ai, ai.a, aj> bQT;

            /* synthetic */ a(byte b2) {
                this();
            }

            /* synthetic */ a(ac.b bVar, byte b2) {
                this(bVar);
            }

            /* access modifiers changed from: protected */
            @Override // com.google.a.ac.a
            public final ac.f Ay() {
                return k.bNT.h(q.class, a.class);
            }

            private a() {
                this.bOU = "";
                this.bQH = "";
                this.bQI = aj.bXM;
                this.bQJ = ac.Gv();
                this.bQK = ac.Gv();
                this.bQL = Collections.emptyList();
                this.bOY = Collections.emptyList();
                this.bQM = Collections.emptyList();
                this.bOW = Collections.emptyList();
                this.bQP = "";
                AR();
            }

            private a(ac.b bVar) {
                super(bVar);
                this.bOU = "";
                this.bQH = "";
                this.bQI = aj.bXM;
                this.bQJ = ac.Gv();
                this.bQK = ac.Gv();
                this.bQL = Collections.emptyList();
                this.bOY = Collections.emptyList();
                this.bQM = Collections.emptyList();
                this.bOW = Collections.emptyList();
                this.bQP = "";
                AR();
            }

            private void AR() {
                if (ac.bVU) {
                    De();
                    Bc();
                    Dg();
                    AY();
                    Bh();
                    Dh();
                }
            }

            @Override // com.google.a.az, com.google.a.ac.a, com.google.a.at.a
            public final l.a AS() {
                return k.bNS;
            }

            /* renamed from: CY */
            public final q Bp() {
                q CZ = Bo();
                if (CZ.isInitialized()) {
                    return CZ;
                }
                throw b(CZ);
            }

            /* access modifiers changed from: private */
            /* renamed from: CZ */
            public q Bo() {
                int i2;
                int i3;
                int i4 = 0;
                q qVar = new q(this, (byte) 0);
                int i5 = this.bOT;
                if ((i5 & 1) != 0) {
                    i4 = 1;
                }
                qVar.bOU = this.bOU;
                if ((i5 & 2) != 0) {
                    i2 = i4 | 2;
                } else {
                    i2 = i4;
                }
                qVar.bQH = this.bQH;
                if ((this.bOT & 4) != 0) {
                    this.bQI = this.bQI.GR();
                    this.bOT &= -5;
                }
                qVar.bQI = this.bQI;
                if ((this.bOT & 8) != 0) {
                    this.bQJ.yK();
                    this.bOT &= -9;
                }
                qVar.bQJ = this.bQJ;
                if ((this.bOT & 16) != 0) {
                    this.bQK.yK();
                    this.bOT &= -17;
                }
                qVar.bQK = this.bQK;
                if (this.bQR == null) {
                    if ((this.bOT & 32) != 0) {
                        this.bQL = Collections.unmodifiableList(this.bQL);
                        this.bOT &= -33;
                    }
                    qVar.bQL = this.bQL;
                } else {
                    qVar.bQL = this.bQR.build();
                }
                if (this.bPk == null) {
                    if ((this.bOT & 64) != 0) {
                        this.bOY = Collections.unmodifiableList(this.bOY);
                        this.bOT &= -65;
                    }
                    qVar.bOY = this.bOY;
                } else {
                    qVar.bOY = this.bPk.build();
                }
                if (this.bQS == null) {
                    if ((this.bOT & 128) != 0) {
                        this.bQM = Collections.unmodifiableList(this.bQM);
                        this.bOT &= -129;
                    }
                    qVar.bQM = this.bQM;
                } else {
                    qVar.bQM = this.bQS.build();
                }
                if (this.bPi == null) {
                    if ((this.bOT & 256) != 0) {
                        this.bOW = Collections.unmodifiableList(this.bOW);
                        this.bOT &= -257;
                    }
                    qVar.bOW = this.bOW;
                } else {
                    qVar.bOW = this.bPi.build();
                }
                if ((i5 & 512) != 0) {
                    if (this.bPn == null) {
                        qVar.bQN = this.bQN;
                    } else {
                        qVar.bQN = this.bPn.Hv();
                    }
                    i2 |= 4;
                }
                if ((i5 & 1024) != 0) {
                    if (this.bQT == null) {
                        qVar.bQO = this.bQO;
                    } else {
                        qVar.bQO = this.bQT.Hv();
                    }
                    i3 = i2 | 8;
                } else {
                    i3 = i2;
                }
                if ((i5 & 2048) != 0) {
                    i3 |= 16;
                }
                qVar.bQP = this.bQP;
                qVar.bOT = i3;
                Gy();
                return qVar;
            }

            /* access modifiers changed from: private */
            /* renamed from: C */
            public a f(l.f fVar, Object obj) {
                return (a) super.f(fVar, obj);
            }

            /* access modifiers changed from: private */
            /* renamed from: D */
            public a e(l.f fVar, Object obj) {
                return (a) super.e(fVar, obj);
            }

            /* access modifiers changed from: private */
            /* renamed from: o */
            public a c(at atVar) {
                if (atVar instanceof q) {
                    return k((q) atVar);
                }
                super.c(atVar);
                return this;
            }

            public final a k(q qVar) {
                bq<m, m.a, n> bqVar = null;
                if (qVar != q.CX()) {
                    if (qVar.Az()) {
                        this.bOT |= 1;
                        this.bOU = qVar.bOU;
                        onChanged();
                    }
                    if (qVar.CL()) {
                        this.bOT |= 2;
                        this.bQH = qVar.bQH;
                        onChanged();
                    }
                    if (!qVar.bQI.isEmpty()) {
                        if (this.bQI.isEmpty()) {
                            this.bQI = qVar.bQI;
                            this.bOT &= -5;
                        } else {
                            Da();
                            this.bQI.addAll(qVar.bQI);
                        }
                        onChanged();
                    }
                    if (!qVar.bQJ.isEmpty()) {
                        if (this.bQJ.isEmpty()) {
                            this.bQJ = qVar.bQJ;
                            this.bOT &= -9;
                        } else {
                            Db();
                            this.bQJ.addAll(qVar.bQJ);
                        }
                        onChanged();
                    }
                    if (!qVar.bQK.isEmpty()) {
                        if (this.bQK.isEmpty()) {
                            this.bQK = qVar.bQK;
                            this.bOT &= -17;
                        } else {
                            Dc();
                            this.bQK.addAll(qVar.bQK);
                        }
                        onChanged();
                    }
                    if (this.bQR == null) {
                        if (!qVar.bQL.isEmpty()) {
                            if (this.bQL.isEmpty()) {
                                this.bQL = qVar.bQL;
                                this.bOT &= -33;
                            } else {
                                Dd();
                                this.bQL.addAll(qVar.bQL);
                            }
                            onChanged();
                        }
                    } else if (!qVar.bQL.isEmpty()) {
                        if (this.bQR.isEmpty()) {
                            this.bQR.bYP = null;
                            this.bQR = null;
                            this.bQL = qVar.bQL;
                            this.bOT &= -33;
                            this.bQR = ac.bVU ? De() : null;
                        } else {
                            this.bQR.a(qVar.bQL);
                        }
                    }
                    if (this.bPk == null) {
                        if (!qVar.bOY.isEmpty()) {
                            if (this.bOY.isEmpty()) {
                                this.bOY = qVar.bOY;
                                this.bOT &= -65;
                            } else {
                                Bb();
                                this.bOY.addAll(qVar.bOY);
                            }
                            onChanged();
                        }
                    } else if (!qVar.bOY.isEmpty()) {
                        if (this.bPk.isEmpty()) {
                            this.bPk.bYP = null;
                            this.bPk = null;
                            this.bOY = qVar.bOY;
                            this.bOT &= -65;
                            this.bPk = ac.bVU ? Bc() : null;
                        } else {
                            this.bPk.a(qVar.bOY);
                        }
                    }
                    if (this.bQS == null) {
                        if (!qVar.bQM.isEmpty()) {
                            if (this.bQM.isEmpty()) {
                                this.bQM = qVar.bQM;
                                this.bOT &= -129;
                            } else {
                                Df();
                                this.bQM.addAll(qVar.bQM);
                            }
                            onChanged();
                        }
                    } else if (!qVar.bQM.isEmpty()) {
                        if (this.bQS.isEmpty()) {
                            this.bQS.bYP = null;
                            this.bQS = null;
                            this.bQM = qVar.bQM;
                            this.bOT &= -129;
                            this.bQS = ac.bVU ? Dg() : null;
                        } else {
                            this.bQS.a(qVar.bQM);
                        }
                    }
                    if (this.bPi == null) {
                        if (!qVar.bOW.isEmpty()) {
                            if (this.bOW.isEmpty()) {
                                this.bOW = qVar.bOW;
                                this.bOT &= -257;
                            } else {
                                AX();
                                this.bOW.addAll(qVar.bOW);
                            }
                            onChanged();
                        }
                    } else if (!qVar.bOW.isEmpty()) {
                        if (this.bPi.isEmpty()) {
                            this.bPi.bYP = null;
                            this.bPi = null;
                            this.bOW = qVar.bOW;
                            this.bOT &= -257;
                            if (ac.bVU) {
                                bqVar = AY();
                            }
                            this.bPi = bqVar;
                        } else {
                            this.bPi.a(qVar.bOW);
                        }
                    }
                    if (qVar.AF()) {
                        a(qVar.CQ());
                    }
                    if (qVar.CR()) {
                        a(qVar.CS());
                    }
                    if (qVar.CT()) {
                        this.bOT |= 2048;
                        this.bQP = qVar.bQP;
                        onChanged();
                    }
                    d(qVar.bTW);
                    onChanged();
                }
                return this;
            }

            @Override // com.google.a.ax, com.google.a.ac.a
            public final boolean isInitialized() {
                int count;
                int count2;
                int count3;
                int count4;
                boolean z;
                m s;
                ae s2;
                c s3;
                a s4;
                int i2 = 0;
                while (true) {
                    if (this.bQR == null) {
                        count = this.bQL.size();
                    } else {
                        count = this.bQR.getCount();
                    }
                    if (i2 < count) {
                        if (this.bQR == null) {
                            s4 = this.bQL.get(i2);
                        } else {
                            s4 = this.bQR.s(i2, false);
                        }
                        if (!s4.isInitialized()) {
                            return false;
                        }
                        i2++;
                    } else {
                        int i3 = 0;
                        while (true) {
                            if (this.bPk == null) {
                                count2 = this.bOY.size();
                            } else {
                                count2 = this.bPk.getCount();
                            }
                            if (i3 < count2) {
                                if (this.bPk == null) {
                                    s3 = this.bOY.get(i3);
                                } else {
                                    s3 = this.bPk.s(i3, false);
                                }
                                if (!s3.isInitialized()) {
                                    return false;
                                }
                                i3++;
                            } else {
                                int i4 = 0;
                                while (true) {
                                    if (this.bQS == null) {
                                        count3 = this.bQM.size();
                                    } else {
                                        count3 = this.bQS.getCount();
                                    }
                                    if (i4 < count3) {
                                        if (this.bQS == null) {
                                            s2 = this.bQM.get(i4);
                                        } else {
                                            s2 = this.bQS.s(i4, false);
                                        }
                                        if (!s2.isInitialized()) {
                                            return false;
                                        }
                                        i4++;
                                    } else {
                                        int i5 = 0;
                                        while (true) {
                                            if (this.bPi == null) {
                                                count4 = this.bOW.size();
                                            } else {
                                                count4 = this.bPi.getCount();
                                            }
                                            if (i5 < count4) {
                                                if (this.bPi == null) {
                                                    s = this.bOW.get(i5);
                                                } else {
                                                    s = this.bPi.s(i5, false);
                                                }
                                                if (!s.isInitialized()) {
                                                    return false;
                                                }
                                                i5++;
                                            } else {
                                                if ((this.bOT & 512) != 0) {
                                                    z = true;
                                                } else {
                                                    z = false;
                                                }
                                                return !z || CQ().isInitialized();
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }

            /* access modifiers changed from: private */
            /* JADX WARNING: Removed duplicated region for block: B:16:0x001e  */
            /* renamed from: p */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public com.google.a.k.q.a c(com.google.a.h r4, com.google.a.r r5) {
                /*
                    r3 = this;
                    r2 = 0
                    com.google.a.bj<com.google.a.k$q> r0 = com.google.a.k.q.bPg     // Catch:{ af -> 0x000f }
                    java.lang.Object r0 = r0.d(r4, r5)     // Catch:{ af -> 0x000f }
                    com.google.a.k$q r0 = (com.google.a.k.q) r0     // Catch:{ af -> 0x000f }
                    if (r0 == 0) goto L_0x000e
                    r3.k(r0)
                L_0x000e:
                    return r3
                L_0x000f:
                    r0 = move-exception
                    r1 = r0
                    com.google.a.aw r0 = r1.bXr     // Catch:{ all -> 0x0022 }
                    com.google.a.k$q r0 = (com.google.a.k.q) r0     // Catch:{ all -> 0x0022 }
                    java.io.IOException r1 = r1.GF()     // Catch:{ all -> 0x001a }
                    throw r1     // Catch:{ all -> 0x001a }
                L_0x001a:
                    r1 = move-exception
                    r2 = r0
                L_0x001c:
                    if (r2 == 0) goto L_0x0021
                    r3.k(r2)
                L_0x0021:
                    throw r1
                L_0x0022:
                    r0 = move-exception
                    r1 = r0
                    goto L_0x001c
                */
                throw new UnsupportedOperationException("Method not decompiled: com.google.a.k.q.a.c(com.google.a.h, com.google.a.r):com.google.a.k$q$a");
            }

            public final a cg(String str) {
                if (str == null) {
                    throw new NullPointerException();
                }
                this.bOT |= 1;
                this.bOU = str;
                onChanged();
                return this;
            }

            public final a ch(String str) {
                if (str == null) {
                    throw new NullPointerException();
                }
                this.bOT |= 2;
                this.bQH = str;
                onChanged();
                return this;
            }

            private void Da() {
                if ((this.bOT & 4) == 0) {
                    this.bQI = new aj(this.bQI);
                    this.bOT |= 4;
                }
            }

            private void Db() {
                if ((this.bOT & 8) == 0) {
                    this.bQJ = ac.a(this.bQJ);
                    this.bOT |= 8;
                }
            }

            private void Dc() {
                if ((this.bOT & 16) == 0) {
                    this.bQK = ac.a(this.bQK);
                    this.bOT |= 16;
                }
            }

            private void Dd() {
                if ((this.bOT & 32) == 0) {
                    this.bQL = new ArrayList(this.bQL);
                    this.bOT |= 32;
                }
            }

            public final a k(a aVar) {
                if (this.bQR != null) {
                    this.bQR.a(aVar);
                } else if (aVar == null) {
                    throw new NullPointerException();
                } else {
                    Dd();
                    this.bQL.add(aVar);
                    onChanged();
                }
                return this;
            }

            private bq<a, a.C0092a, b> De() {
                if (this.bQR == null) {
                    this.bQR = new bq<>(this.bQL, (this.bOT & 32) != 0, GA(), this.bWv);
                    this.bQL = null;
                }
                return this.bQR;
            }

            private void Bb() {
                if ((this.bOT & 64) == 0) {
                    this.bOY = new ArrayList(this.bOY);
                    this.bOT |= 64;
                }
            }

            private bq<c, c.a, d> Bc() {
                if (this.bPk == null) {
                    this.bPk = new bq<>(this.bOY, (this.bOT & 64) != 0, GA(), this.bWv);
                    this.bOY = null;
                }
                return this.bPk;
            }

            private void Df() {
                if ((this.bOT & 128) == 0) {
                    this.bQM = new ArrayList(this.bQM);
                    this.bOT |= 128;
                }
            }

            private bq<ae, ae.a, af> Dg() {
                if (this.bQS == null) {
                    this.bQS = new bq<>(this.bQM, (this.bOT & 128) != 0, GA(), this.bWv);
                    this.bQM = null;
                }
                return this.bQS;
            }

            private void AX() {
                if ((this.bOT & 256) == 0) {
                    this.bOW = new ArrayList(this.bOW);
                    this.bOT |= 256;
                }
            }

            private bq<m, m.a, n> AY() {
                if (this.bPi == null) {
                    this.bPi = new bq<>(this.bOW, (this.bOT & 256) != 0, GA(), this.bWv);
                    this.bOW = null;
                }
                return this.bPi;
            }

            private s CQ() {
                if (this.bPn == null) {
                    return this.bQN == null ? s.DN() : this.bQN;
                }
                return this.bPn.Hu();
            }

            private a a(s sVar) {
                if (this.bPn == null) {
                    if ((this.bOT & 512) == 0 || this.bQN == null || this.bQN == s.DN()) {
                        this.bQN = sVar;
                    } else {
                        this.bQN = s.b(this.bQN).n(sVar).Bo();
                    }
                    onChanged();
                } else {
                    this.bPn.b(sVar);
                }
                this.bOT |= 512;
                return this;
            }

            private bu<s, s.a, t> Bh() {
                if (this.bPn == null) {
                    this.bPn = new bu<>(CQ(), GA(), this.bWv);
                    this.bQN = null;
                }
                return this.bPn;
            }

            private ai CS() {
                if (this.bQT == null) {
                    return this.bQO == null ? ai.EK() : this.bQO;
                }
                return this.bQT.Hu();
            }

            private a a(ai aiVar) {
                if (this.bQT == null) {
                    if ((this.bOT & 1024) == 0 || this.bQO == null || this.bQO == ai.EK()) {
                        this.bQO = aiVar;
                    } else {
                        this.bQO = ai.b(this.bQO).d(aiVar).Bo();
                    }
                    onChanged();
                } else {
                    this.bQT.b(aiVar);
                }
                this.bOT |= 1024;
                return this;
            }

            private bu<ai, ai.a, aj> Dh() {
                if (this.bQT == null) {
                    this.bQT = new bu<>(CS(), GA(), this.bWv);
                    this.bQO = null;
                }
                return this.bQT;
            }

            /* access modifiers changed from: private */
            /* renamed from: A */
            public a f(cc ccVar) {
                return (a) super.f(ccVar);
            }

            /* access modifiers changed from: private */
            /* renamed from: B */
            public a d(cc ccVar) {
                return (a) super.a(ccVar);
            }

            /* Return type fixed from 'com.google.a.ac$a' to match base method */
            @Override // com.google.a.ac.a
            public final /* bridge */ /* synthetic */ a Bl() {
                return (a) super.yG();
            }

            @Override // com.google.a.a.AbstractC0085a, com.google.a.ac.a
            public final /* synthetic */ a.AbstractC0085a yE() {
                return (a) super.yG();
            }

            @Override // com.google.a.ax
            public final /* synthetic */ aw AP() {
                return q.CX();
            }

            @Override // com.google.a.az
            public final /* synthetic */ at AQ() {
                return q.CX();
            }

            @Override // com.google.a.b.a, com.google.a.a.AbstractC0085a, com.google.a.ac.a
            public final /* synthetic */ b.a yG() {
                return (a) super.yG();
            }

            @Override // com.google.a.b.a, com.google.a.a.AbstractC0085a, java.lang.Object, com.google.a.ac.a
            public final /* synthetic */ Object clone() {
                return (a) super.yG();
            }
        }

        public static q CX() {
            return bQQ;
        }

        @Override // com.google.a.aw, com.google.a.ac
        public final bj<q> AK() {
            return bPg;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.a.ac
        public final /* synthetic */ at.a a(ac.b bVar) {
            return new a(bVar, (byte) 0);
        }

        @Override // com.google.a.at
        public final /* synthetic */ at.a AM() {
            return bQQ.AN();
        }

        @Override // com.google.a.aw
        public final /* synthetic */ aw.a AO() {
            return bQQ.AN();
        }

        @Override // com.google.a.ax
        public final /* bridge */ /* synthetic */ aw AP() {
            return bQQ;
        }

        @Override // com.google.a.az
        public final /* bridge */ /* synthetic */ at AQ() {
            return bQQ;
        }
    }

    public static final class a extends ac implements b {
        private static final a bPf = new a();
        @Deprecated
        public static final bj<a> bPg = new c<a>() {
            /* class com.google.a.k.a.AnonymousClass1 */

            @Override // com.google.a.bj
            public final /* synthetic */ Object d(h hVar, r rVar) {
                return new a(hVar, rVar, (byte) 0);
            }
        };
        private int bOT;
        private volatile Object bOU;
        private List<m> bOV;
        private List<m> bOW;
        private List<a> bOX;
        private List<c> bOY;
        List<b> bOZ;
        private List<aa> bPa;
        private u bPb;
        private List<d> bPc;
        private ak bPd;
        private byte bPe;

        public interface c extends az {
        }

        public interface e extends az {
        }

        /* synthetic */ a(ac.a aVar, byte b2) {
            this(aVar);
        }

        /* synthetic */ a(h hVar, r rVar, byte b2) {
            this(hVar, rVar);
        }

        private a(ac.a<?> aVar) {
            super(aVar);
            this.bPe = -1;
        }

        private a() {
            this.bPe = -1;
            this.bOU = "";
            this.bOV = Collections.emptyList();
            this.bOW = Collections.emptyList();
            this.bOX = Collections.emptyList();
            this.bOY = Collections.emptyList();
            this.bOZ = Collections.emptyList();
            this.bPa = Collections.emptyList();
            this.bPc = Collections.emptyList();
            this.bPd = aj.bXM;
        }

        @Override // com.google.a.az, com.google.a.ac
        public final cc Ax() {
            return this.bTW;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v34, resolved type: java.util.List<com.google.a.k$a$d> */
        /* JADX DEBUG: Multi-variable search result rejected for r0v37, resolved type: java.util.List<com.google.a.k$aa> */
        /* JADX DEBUG: Multi-variable search result rejected for r0v50, resolved type: java.util.List<com.google.a.k$m> */
        /* JADX DEBUG: Multi-variable search result rejected for r0v53, resolved type: java.util.List<com.google.a.k$a$b> */
        /* JADX DEBUG: Multi-variable search result rejected for r0v56, resolved type: java.util.List<com.google.a.k$c> */
        /* JADX DEBUG: Multi-variable search result rejected for r0v59, resolved type: java.util.List<com.google.a.k$a> */
        /* JADX DEBUG: Multi-variable search result rejected for r0v62, resolved type: java.util.List<com.google.a.k$m> */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARNING: Removed duplicated region for block: B:24:0x003f  */
        /* JADX WARNING: Removed duplicated region for block: B:27:0x004b  */
        /* JADX WARNING: Removed duplicated region for block: B:30:0x0057  */
        /* JADX WARNING: Removed duplicated region for block: B:33:0x0063  */
        /* JADX WARNING: Removed duplicated region for block: B:36:0x006f  */
        /* JADX WARNING: Removed duplicated region for block: B:39:0x007b  */
        /* JADX WARNING: Removed duplicated region for block: B:42:0x0087  */
        /* JADX WARNING: Removed duplicated region for block: B:45:0x0093  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private a(com.google.a.h r7, com.google.a.r r8) {
            /*
            // Method dump skipped, instructions count: 586
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.a.k.a.<init>(com.google.a.h, com.google.a.r):void");
        }

        /* access modifiers changed from: protected */
        @Override // com.google.a.ac
        public final ac.f Ay() {
            return k.bNV.h(a.class, C0092a.class);
        }

        public static final class b extends ac implements c {
            @Deprecated
            public static final bj<b> bPg = new c<b>() {
                /* class com.google.a.k.a.b.AnonymousClass1 */

                @Override // com.google.a.bj
                public final /* synthetic */ Object d(h hVar, r rVar) {
                    return new b(hVar, rVar, (byte) 0);
                }
            };
            private static final b bPs = new b();
            private int bOT;
            private byte bPe;
            int bPp;
            int bPq;
            private C0096k bPr;

            /* synthetic */ b(ac.a aVar, byte b2) {
                this(aVar);
            }

            /* synthetic */ b(h hVar, r rVar, byte b2) {
                this(hVar, rVar);
            }

            private b(ac.a<?> aVar) {
                super(aVar);
                this.bPe = -1;
            }

            private b() {
                this.bPe = -1;
            }

            @Override // com.google.a.az, com.google.a.ac
            public final cc Ax() {
                return this.bTW;
            }

            private b(h hVar, r rVar) {
                this();
                C0096k.a aVar;
                boolean z;
                if (rVar == null) {
                    throw new NullPointerException();
                }
                cc.a HJ = cc.HJ();
                boolean z2 = false;
                while (!z2) {
                    try {
                        int yT = hVar.yT();
                        switch (yT) {
                            case 0:
                                z2 = true;
                                break;
                            case 8:
                                this.bOT |= 1;
                                this.bPp = hVar.yW();
                                break;
                            case 16:
                                this.bOT |= 2;
                                this.bPq = hVar.yW();
                                break;
                            case 26:
                                if ((this.bOT & 4) != 0) {
                                    aVar = this.bPr.AN();
                                } else {
                                    aVar = null;
                                }
                                this.bPr = (C0096k) hVar.a(C0096k.bPg, rVar);
                                if (aVar != null) {
                                    aVar.d(this.bPr);
                                    this.bPr = aVar.Bo();
                                }
                                this.bOT |= 4;
                                break;
                            default:
                                if (!a(hVar, HJ, rVar, yT)) {
                                    z = true;
                                } else {
                                    z = z2;
                                }
                                z2 = z;
                                break;
                        }
                    } catch (af e2) {
                        e2.bXr = this;
                        throw e2;
                    } catch (IOException e3) {
                        af afVar = new af(e3);
                        afVar.bXr = this;
                        throw afVar;
                    } catch (Throwable th) {
                        this.bTW = HJ.Bp();
                        Gw();
                        throw th;
                    }
                }
                this.bTW = HJ.Bp();
                Gw();
            }

            /* access modifiers changed from: protected */
            @Override // com.google.a.ac
            public final ac.f Ay() {
                return k.bNX.h(b.class, C0093a.class);
            }

            public final boolean Bq() {
                return (this.bOT & 1) != 0;
            }

            public final boolean hasEnd() {
                return (this.bOT & 2) != 0;
            }

            public final boolean AF() {
                return (this.bOT & 4) != 0;
            }

            public final C0096k Br() {
                return this.bPr == null ? C0096k.Ch() : this.bPr;
            }

            @Override // com.google.a.a, com.google.a.ax, com.google.a.ac
            public final boolean isInitialized() {
                byte b2 = this.bPe;
                if (b2 == 1) {
                    return true;
                }
                if (b2 == 0) {
                    return false;
                }
                if (!AF() || Br().isInitialized()) {
                    this.bPe = 1;
                    return true;
                }
                this.bPe = 0;
                return false;
            }

            @Override // com.google.a.aw, com.google.a.a, com.google.a.ac
            public final void a(i iVar) {
                if ((this.bOT & 1) != 0) {
                    iVar.bs(1, this.bPp);
                }
                if ((this.bOT & 2) != 0) {
                    iVar.bs(2, this.bPq);
                }
                if ((this.bOT & 4) != 0) {
                    iVar.a(3, Br());
                }
                this.bTW.a(iVar);
            }

            @Override // com.google.a.aw, com.google.a.a, com.google.a.ac
            public final int yC() {
                int i2 = this.bNa;
                if (i2 != -1) {
                    return i2;
                }
                int i3 = 0;
                if ((this.bOT & 1) != 0) {
                    i3 = i.bu(1, this.bPp) + 0;
                }
                if ((this.bOT & 2) != 0) {
                    i3 += i.bu(2, this.bPq);
                }
                if ((this.bOT & 4) != 0) {
                    i3 += i.c(3, Br());
                }
                int yC = i3 + this.bTW.yC();
                this.bNa = yC;
                return yC;
            }

            @Override // com.google.a.a
            public final boolean equals(Object obj) {
                if (obj == this) {
                    return true;
                }
                if (!(obj instanceof b)) {
                    return super.equals(obj);
                }
                b bVar = (b) obj;
                if (Bq() != bVar.Bq()) {
                    return false;
                }
                if (Bq() && this.bPp != bVar.bPp) {
                    return false;
                }
                if (hasEnd() != bVar.hasEnd()) {
                    return false;
                }
                if (hasEnd() && this.bPq != bVar.bPq) {
                    return false;
                }
                if (AF() != bVar.AF()) {
                    return false;
                }
                if (!AF() || Br().equals(bVar.Br())) {
                    return this.bTW.equals(bVar.bTW);
                }
                return false;
            }

            @Override // com.google.a.a
            public final int hashCode() {
                if (this.bNb != 0) {
                    return this.bNb;
                }
                int hashCode = k.bNW.hashCode() + com.tencent.mm.plugin.appbrand.jsapi.share.q.CTRL_INDEX;
                if (Bq()) {
                    hashCode = (((hashCode * 37) + 1) * 53) + this.bPp;
                }
                if (hasEnd()) {
                    hashCode = (((hashCode * 37) + 2) * 53) + this.bPq;
                }
                if (AF()) {
                    hashCode = (((hashCode * 37) + 3) * 53) + Br().hashCode();
                }
                int hashCode2 = (hashCode * 29) + this.bTW.hashCode();
                this.bNb = hashCode2;
                return hashCode2;
            }

            public static C0093a Bs() {
                return bPs.AN();
            }

            /* access modifiers changed from: private */
            /* renamed from: Bt */
            public C0093a AN() {
                if (this == bPs) {
                    return new C0093a((byte) 0);
                }
                return new C0093a((byte) 0).b(this);
            }

            /* renamed from: com.google.a.k$a$b$a  reason: collision with other inner class name */
            public static final class C0093a extends ac.a<C0093a> implements c {
                private int bOT;
                private bu<C0096k, C0096k.a, l> bPn;
                private int bPp;
                private int bPq;
                private C0096k bPr;

                /* synthetic */ C0093a(byte b2) {
                    this();
                }

                /* synthetic */ C0093a(ac.b bVar, byte b2) {
                    this(bVar);
                }

                /* access modifiers changed from: protected */
                @Override // com.google.a.ac.a
                public final ac.f Ay() {
                    return k.bNX.h(b.class, C0093a.class);
                }

                private C0093a() {
                    AR();
                }

                private C0093a(ac.b bVar) {
                    super(bVar);
                    AR();
                }

                private void AR() {
                    if (ac.bVU) {
                        Bh();
                    }
                }

                @Override // com.google.a.az, com.google.a.ac.a, com.google.a.at.a
                public final l.a AS() {
                    return k.bNW;
                }

                /* renamed from: Bv */
                public final b Bp() {
                    b Bw = Bo();
                    if (Bw.isInitialized()) {
                        return Bw;
                    }
                    throw b((at) Bw);
                }

                /* access modifiers changed from: private */
                /* renamed from: Bw */
                public b Bo() {
                    int i2;
                    int i3 = 0;
                    b bVar = new b(this, (byte) 0);
                    int i4 = this.bOT;
                    if ((i4 & 1) != 0) {
                        bVar.bPp = this.bPp;
                        i3 = 1;
                    }
                    if ((i4 & 2) != 0) {
                        bVar.bPq = this.bPq;
                        i3 |= 2;
                    }
                    if ((i4 & 4) != 0) {
                        if (this.bPn == null) {
                            bVar.bPr = this.bPr;
                        } else {
                            bVar.bPr = this.bPn.Hv();
                        }
                        i2 = i3 | 4;
                    } else {
                        i2 = i3;
                    }
                    bVar.bOT = i2;
                    Gy();
                    return bVar;
                }

                /* access modifiers changed from: private */
                /* renamed from: g */
                public C0093a f(l.f fVar, Object obj) {
                    return (C0093a) super.f(fVar, obj);
                }

                /* access modifiers changed from: private */
                /* renamed from: h */
                public C0093a e(l.f fVar, Object obj) {
                    return (C0093a) super.e(fVar, obj);
                }

                /* access modifiers changed from: private */
                /* renamed from: e */
                public C0093a c(at atVar) {
                    if (atVar instanceof b) {
                        return b((b) atVar);
                    }
                    super.c(atVar);
                    return this;
                }

                public final C0093a b(b bVar) {
                    if (bVar != b.Bu()) {
                        if (bVar.Bq()) {
                            gf(bVar.bPp);
                        }
                        if (bVar.hasEnd()) {
                            gg(bVar.bPq);
                        }
                        if (bVar.AF()) {
                            a(bVar.Br());
                        }
                        d(bVar.bTW);
                        onChanged();
                    }
                    return this;
                }

                @Override // com.google.a.ax, com.google.a.ac.a
                public final boolean isInitialized() {
                    boolean z;
                    if ((this.bOT & 4) != 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    return !z || Br().isInitialized();
                }

                /* access modifiers changed from: private */
                /* JADX WARNING: Removed duplicated region for block: B:16:0x001e  */
                /* renamed from: f */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public com.google.a.k.a.b.C0093a c(com.google.a.h r4, com.google.a.r r5) {
                    /*
                        r3 = this;
                        r2 = 0
                        com.google.a.bj<com.google.a.k$a$b> r0 = com.google.a.k.a.b.bPg     // Catch:{ af -> 0x000f }
                        java.lang.Object r0 = r0.d(r4, r5)     // Catch:{ af -> 0x000f }
                        com.google.a.k$a$b r0 = (com.google.a.k.a.b) r0     // Catch:{ af -> 0x000f }
                        if (r0 == 0) goto L_0x000e
                        r3.b(r0)
                    L_0x000e:
                        return r3
                    L_0x000f:
                        r0 = move-exception
                        r1 = r0
                        com.google.a.aw r0 = r1.bXr     // Catch:{ all -> 0x0022 }
                        com.google.a.k$a$b r0 = (com.google.a.k.a.b) r0     // Catch:{ all -> 0x0022 }
                        java.io.IOException r1 = r1.GF()     // Catch:{ all -> 0x001a }
                        throw r1     // Catch:{ all -> 0x001a }
                    L_0x001a:
                        r1 = move-exception
                        r2 = r0
                    L_0x001c:
                        if (r2 == 0) goto L_0x0021
                        r3.b(r2)
                    L_0x0021:
                        throw r1
                    L_0x0022:
                        r0 = move-exception
                        r1 = r0
                        goto L_0x001c
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.google.a.k.a.b.C0093a.c(com.google.a.h, com.google.a.r):com.google.a.k$a$b$a");
                }

                public final C0093a gf(int i2) {
                    this.bOT |= 1;
                    this.bPp = i2;
                    onChanged();
                    return this;
                }

                public final C0093a gg(int i2) {
                    this.bOT |= 2;
                    this.bPq = i2;
                    onChanged();
                    return this;
                }

                private C0096k Br() {
                    if (this.bPn == null) {
                        return this.bPr == null ? C0096k.Ch() : this.bPr;
                    }
                    return this.bPn.Hu();
                }

                private C0093a a(C0096k kVar) {
                    if (this.bPn == null) {
                        if ((this.bOT & 4) == 0 || this.bPr == null || this.bPr == C0096k.Ch()) {
                            this.bPr = kVar;
                        } else {
                            this.bPr = C0096k.b(this.bPr).d(kVar).Bo();
                        }
                        onChanged();
                    } else {
                        this.bPn.b(kVar);
                    }
                    this.bOT |= 4;
                    return this;
                }

                private bu<C0096k, C0096k.a, l> Bh() {
                    if (this.bPn == null) {
                        this.bPn = new bu<>(Br(), GA(), this.bWv);
                        this.bPr = null;
                    }
                    return this.bPn;
                }

                /* access modifiers changed from: private */
                /* renamed from: g */
                public C0093a f(cc ccVar) {
                    return (C0093a) super.f(ccVar);
                }

                /* access modifiers changed from: private */
                /* renamed from: h */
                public C0093a d(cc ccVar) {
                    return (C0093a) super.a(ccVar);
                }

                /* Return type fixed from 'com.google.a.ac$a' to match base method */
                @Override // com.google.a.ac.a
                public final /* bridge */ /* synthetic */ C0093a Bl() {
                    return (C0093a) super.yG();
                }

                @Override // com.google.a.a.AbstractC0085a, com.google.a.ac.a
                public final /* synthetic */ a.AbstractC0085a yE() {
                    return (C0093a) super.yG();
                }

                @Override // com.google.a.ax
                public final /* synthetic */ aw AP() {
                    return b.Bu();
                }

                @Override // com.google.a.az
                public final /* synthetic */ at AQ() {
                    return b.Bu();
                }

                @Override // com.google.a.b.a, com.google.a.a.AbstractC0085a, com.google.a.ac.a
                public final /* synthetic */ b.a yG() {
                    return (C0093a) super.yG();
                }

                @Override // com.google.a.b.a, com.google.a.a.AbstractC0085a, java.lang.Object, com.google.a.ac.a
                public final /* synthetic */ Object clone() {
                    return (C0093a) super.yG();
                }
            }

            public static b Bu() {
                return bPs;
            }

            @Override // com.google.a.aw, com.google.a.ac
            public final bj<b> AK() {
                return bPg;
            }

            /* access modifiers changed from: protected */
            @Override // com.google.a.ac
            public final /* synthetic */ at.a a(ac.b bVar) {
                return new C0093a(bVar, (byte) 0);
            }

            @Override // com.google.a.at
            public final /* synthetic */ at.a AM() {
                return bPs.AN();
            }

            @Override // com.google.a.aw
            public final /* synthetic */ aw.a AO() {
                return bPs.AN();
            }

            @Override // com.google.a.ax
            public final /* bridge */ /* synthetic */ aw AP() {
                return bPs;
            }

            @Override // com.google.a.az
            public final /* bridge */ /* synthetic */ at AQ() {
                return bPs;
            }
        }

        public static final class d extends ac implements e {
            @Deprecated
            public static final bj<d> bPg = new c<d>() {
                /* class com.google.a.k.a.d.AnonymousClass1 */

                @Override // com.google.a.bj
                public final /* synthetic */ Object d(h hVar, r rVar) {
                    return new d(hVar, rVar, (byte) 0);
                }
            };
            private static final d bPt = new d();
            private int bOT;
            private byte bPe;
            int bPp;
            int bPq;

            /* synthetic */ d(ac.a aVar, byte b2) {
                this(aVar);
            }

            /* synthetic */ d(h hVar, r rVar, byte b2) {
                this(hVar, rVar);
            }

            private d(ac.a<?> aVar) {
                super(aVar);
                this.bPe = -1;
            }

            private d() {
                this.bPe = -1;
            }

            @Override // com.google.a.az, com.google.a.ac
            public final cc Ax() {
                return this.bTW;
            }

            private d(h hVar, r rVar) {
                this();
                if (rVar == null) {
                    throw new NullPointerException();
                }
                cc.a HJ = cc.HJ();
                boolean z = false;
                while (!z) {
                    try {
                        int yT = hVar.yT();
                        switch (yT) {
                            case 0:
                                z = true;
                                break;
                            case 8:
                                this.bOT |= 1;
                                this.bPp = hVar.yW();
                                break;
                            case 16:
                                this.bOT |= 2;
                                this.bPq = hVar.yW();
                                break;
                            default:
                                if (a(hVar, HJ, rVar, yT)) {
                                    break;
                                } else {
                                    z = true;
                                    break;
                                }
                        }
                    } catch (af e2) {
                        e2.bXr = this;
                        throw e2;
                    } catch (IOException e3) {
                        af afVar = new af(e3);
                        afVar.bXr = this;
                        throw afVar;
                    } catch (Throwable th) {
                        this.bTW = HJ.Bp();
                        Gw();
                        throw th;
                    }
                }
                this.bTW = HJ.Bp();
                Gw();
            }

            /* access modifiers changed from: protected */
            @Override // com.google.a.ac
            public final ac.f Ay() {
                return k.bNZ.h(d.class, C0094a.class);
            }

            public final boolean Bq() {
                return (this.bOT & 1) != 0;
            }

            public final boolean hasEnd() {
                return (this.bOT & 2) != 0;
            }

            @Override // com.google.a.a, com.google.a.ax, com.google.a.ac
            public final boolean isInitialized() {
                byte b2 = this.bPe;
                if (b2 == 1) {
                    return true;
                }
                if (b2 == 0) {
                    return false;
                }
                this.bPe = 1;
                return true;
            }

            @Override // com.google.a.aw, com.google.a.a, com.google.a.ac
            public final void a(i iVar) {
                if ((this.bOT & 1) != 0) {
                    iVar.bs(1, this.bPp);
                }
                if ((this.bOT & 2) != 0) {
                    iVar.bs(2, this.bPq);
                }
                this.bTW.a(iVar);
            }

            @Override // com.google.a.aw, com.google.a.a, com.google.a.ac
            public final int yC() {
                int i2 = this.bNa;
                if (i2 != -1) {
                    return i2;
                }
                int i3 = 0;
                if ((this.bOT & 1) != 0) {
                    i3 = i.bu(1, this.bPp) + 0;
                }
                if ((this.bOT & 2) != 0) {
                    i3 += i.bu(2, this.bPq);
                }
                int yC = i3 + this.bTW.yC();
                this.bNa = yC;
                return yC;
            }

            @Override // com.google.a.a
            public final boolean equals(Object obj) {
                if (obj == this) {
                    return true;
                }
                if (!(obj instanceof d)) {
                    return super.equals(obj);
                }
                d dVar = (d) obj;
                if (Bq() != dVar.Bq()) {
                    return false;
                }
                if (Bq() && this.bPp != dVar.bPp) {
                    return false;
                }
                if (hasEnd() != dVar.hasEnd()) {
                    return false;
                }
                if (!hasEnd() || this.bPq == dVar.bPq) {
                    return this.bTW.equals(dVar.bTW);
                }
                return false;
            }

            @Override // com.google.a.a
            public final int hashCode() {
                if (this.bNb != 0) {
                    return this.bNb;
                }
                int hashCode = k.bNY.hashCode() + com.tencent.mm.plugin.appbrand.jsapi.share.q.CTRL_INDEX;
                if (Bq()) {
                    hashCode = (((hashCode * 37) + 1) * 53) + this.bPp;
                }
                if (hasEnd()) {
                    hashCode = (((hashCode * 37) + 2) * 53) + this.bPq;
                }
                int hashCode2 = (hashCode * 29) + this.bTW.hashCode();
                this.bNb = hashCode2;
                return hashCode2;
            }

            /* access modifiers changed from: private */
            /* renamed from: Bx */
            public C0094a AN() {
                if (this == bPt) {
                    return new C0094a((byte) 0);
                }
                return new C0094a((byte) 0).a(this);
            }

            /* renamed from: com.google.a.k$a$d$a  reason: collision with other inner class name */
            public static final class C0094a extends ac.a<C0094a> implements e {
                private int bOT;
                private int bPp;
                private int bPq;

                /* synthetic */ C0094a(byte b2) {
                    this();
                }

                /* synthetic */ C0094a(ac.b bVar, byte b2) {
                    this(bVar);
                }

                /* access modifiers changed from: protected */
                @Override // com.google.a.ac.a
                public final ac.f Ay() {
                    return k.bNZ.h(d.class, C0094a.class);
                }

                private C0094a() {
                    boolean z = ac.bVU;
                }

                private C0094a(ac.b bVar) {
                    super(bVar);
                    boolean z = ac.bVU;
                }

                @Override // com.google.a.az, com.google.a.ac.a, com.google.a.at.a
                public final l.a AS() {
                    return k.bNY;
                }

                /* access modifiers changed from: private */
                /* renamed from: Bz */
                public d Bp() {
                    d BA = Bo();
                    if (BA.isInitialized()) {
                        return BA;
                    }
                    throw b(BA);
                }

                /* access modifiers changed from: private */
                /* renamed from: BA */
                public d Bo() {
                    int i2 = 0;
                    d dVar = new d(this, (byte) 0);
                    int i3 = this.bOT;
                    if ((i3 & 1) != 0) {
                        dVar.bPp = this.bPp;
                        i2 = 1;
                    }
                    if ((i3 & 2) != 0) {
                        dVar.bPq = this.bPq;
                        i2 |= 2;
                    }
                    dVar.bOT = i2;
                    Gy();
                    return dVar;
                }

                /* access modifiers changed from: private */
                /* renamed from: i */
                public C0094a f(l.f fVar, Object obj) {
                    return (C0094a) super.f(fVar, obj);
                }

                /* access modifiers changed from: private */
                /* renamed from: j */
                public C0094a e(l.f fVar, Object obj) {
                    return (C0094a) super.e(fVar, obj);
                }

                /* access modifiers changed from: private */
                /* renamed from: f */
                public C0094a c(at atVar) {
                    if (atVar instanceof d) {
                        return a((d) atVar);
                    }
                    super.c(atVar);
                    return this;
                }

                public final C0094a a(d dVar) {
                    if (dVar != d.By()) {
                        if (dVar.Bq()) {
                            gh(dVar.bPp);
                        }
                        if (dVar.hasEnd()) {
                            gi(dVar.bPq);
                        }
                        d(dVar.bTW);
                        onChanged();
                    }
                    return this;
                }

                @Override // com.google.a.ax, com.google.a.ac.a
                public final boolean isInitialized() {
                    return true;
                }

                /* access modifiers changed from: private */
                /* JADX WARNING: Removed duplicated region for block: B:16:0x001e  */
                /* renamed from: g */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public com.google.a.k.a.d.C0094a c(com.google.a.h r4, com.google.a.r r5) {
                    /*
                        r3 = this;
                        r2 = 0
                        com.google.a.bj<com.google.a.k$a$d> r0 = com.google.a.k.a.d.bPg     // Catch:{ af -> 0x000f }
                        java.lang.Object r0 = r0.d(r4, r5)     // Catch:{ af -> 0x000f }
                        com.google.a.k$a$d r0 = (com.google.a.k.a.d) r0     // Catch:{ af -> 0x000f }
                        if (r0 == 0) goto L_0x000e
                        r3.a(r0)
                    L_0x000e:
                        return r3
                    L_0x000f:
                        r0 = move-exception
                        r1 = r0
                        com.google.a.aw r0 = r1.bXr     // Catch:{ all -> 0x0022 }
                        com.google.a.k$a$d r0 = (com.google.a.k.a.d) r0     // Catch:{ all -> 0x0022 }
                        java.io.IOException r1 = r1.GF()     // Catch:{ all -> 0x001a }
                        throw r1     // Catch:{ all -> 0x001a }
                    L_0x001a:
                        r1 = move-exception
                        r2 = r0
                    L_0x001c:
                        if (r2 == 0) goto L_0x0021
                        r3.a(r2)
                    L_0x0021:
                        throw r1
                    L_0x0022:
                        r0 = move-exception
                        r1 = r0
                        goto L_0x001c
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.google.a.k.a.d.C0094a.c(com.google.a.h, com.google.a.r):com.google.a.k$a$d$a");
                }

                private C0094a gh(int i2) {
                    this.bOT |= 1;
                    this.bPp = i2;
                    onChanged();
                    return this;
                }

                private C0094a gi(int i2) {
                    this.bOT |= 2;
                    this.bPq = i2;
                    onChanged();
                    return this;
                }

                /* access modifiers changed from: private */
                /* renamed from: i */
                public C0094a f(cc ccVar) {
                    return (C0094a) super.f(ccVar);
                }

                /* access modifiers changed from: private */
                /* renamed from: j */
                public C0094a d(cc ccVar) {
                    return (C0094a) super.a(ccVar);
                }

                /* Return type fixed from 'com.google.a.ac$a' to match base method */
                @Override // com.google.a.ac.a
                public final /* bridge */ /* synthetic */ C0094a Bl() {
                    return (C0094a) super.yG();
                }

                @Override // com.google.a.a.AbstractC0085a, com.google.a.ac.a
                public final /* synthetic */ a.AbstractC0085a yE() {
                    return (C0094a) super.yG();
                }

                @Override // com.google.a.ax
                public final /* synthetic */ aw AP() {
                    return d.By();
                }

                @Override // com.google.a.az
                public final /* synthetic */ at AQ() {
                    return d.By();
                }

                @Override // com.google.a.b.a, com.google.a.a.AbstractC0085a, com.google.a.ac.a
                public final /* synthetic */ b.a yG() {
                    return (C0094a) super.yG();
                }

                @Override // com.google.a.b.a, com.google.a.a.AbstractC0085a, java.lang.Object, com.google.a.ac.a
                public final /* synthetic */ Object clone() {
                    return (C0094a) super.yG();
                }
            }

            public static d By() {
                return bPt;
            }

            @Override // com.google.a.aw, com.google.a.ac
            public final bj<d> AK() {
                return bPg;
            }

            /* access modifiers changed from: protected */
            @Override // com.google.a.ac
            public final /* synthetic */ at.a a(ac.b bVar) {
                return new C0094a(bVar, (byte) 0);
            }

            @Override // com.google.a.at
            public final /* synthetic */ at.a AM() {
                return bPt.AN();
            }

            @Override // com.google.a.aw
            public final /* synthetic */ aw.a AO() {
                return bPt.AN();
            }

            @Override // com.google.a.ax
            public final /* bridge */ /* synthetic */ aw AP() {
                return bPt;
            }

            @Override // com.google.a.az
            public final /* bridge */ /* synthetic */ at AQ() {
                return bPt;
            }
        }

        public final boolean Az() {
            return (this.bOT & 1) != 0;
        }

        public final String getName() {
            Object obj = this.bOU;
            if (obj instanceof String) {
                return (String) obj;
            }
            g gVar = (g) obj;
            String yO = gVar.yO();
            if (gVar.yP()) {
                this.bOU = yO;
            }
            return yO;
        }

        public final int getFieldCount() {
            return this.bOV.size();
        }

        public final m ga(int i2) {
            return this.bOV.get(i2);
        }

        public final int AA() {
            return this.bOW.size();
        }

        public final m gb(int i2) {
            return this.bOW.get(i2);
        }

        public final int AB() {
            return this.bOX.size();
        }

        public final a gc(int i2) {
            return this.bOX.get(i2);
        }

        public final int AC() {
            return this.bOY.size();
        }

        public final c gd(int i2) {
            return this.bOY.get(i2);
        }

        private int AD() {
            return this.bOZ.size();
        }

        public final int AE() {
            return this.bPa.size();
        }

        public final aa ge(int i2) {
            return this.bPa.get(i2);
        }

        public final boolean AF() {
            return (this.bOT & 2) != 0;
        }

        public final u AG() {
            return this.bPb == null ? u.DU() : this.bPb;
        }

        @Override // com.google.a.a, com.google.a.ax, com.google.a.ac
        public final boolean isInitialized() {
            byte b2 = this.bPe;
            if (b2 == 1) {
                return true;
            }
            if (b2 == 0) {
                return false;
            }
            for (int i2 = 0; i2 < getFieldCount(); i2++) {
                if (!ga(i2).isInitialized()) {
                    this.bPe = 0;
                    return false;
                }
            }
            for (int i3 = 0; i3 < AA(); i3++) {
                if (!gb(i3).isInitialized()) {
                    this.bPe = 0;
                    return false;
                }
            }
            for (int i4 = 0; i4 < AB(); i4++) {
                if (!gc(i4).isInitialized()) {
                    this.bPe = 0;
                    return false;
                }
            }
            for (int i5 = 0; i5 < AC(); i5++) {
                if (!gd(i5).isInitialized()) {
                    this.bPe = 0;
                    return false;
                }
            }
            for (int i6 = 0; i6 < AD(); i6++) {
                if (!this.bOZ.get(i6).isInitialized()) {
                    this.bPe = 0;
                    return false;
                }
            }
            for (int i7 = 0; i7 < AE(); i7++) {
                if (!ge(i7).isInitialized()) {
                    this.bPe = 0;
                    return false;
                }
            }
            if (!AF() || AG().isInitialized()) {
                this.bPe = 1;
                return true;
            }
            this.bPe = 0;
            return false;
        }

        @Override // com.google.a.aw, com.google.a.a, com.google.a.ac
        public final void a(i iVar) {
            if ((this.bOT & 1) != 0) {
                ac.a(iVar, 1, this.bOU);
            }
            for (int i2 = 0; i2 < this.bOV.size(); i2++) {
                iVar.a(2, this.bOV.get(i2));
            }
            for (int i3 = 0; i3 < this.bOX.size(); i3++) {
                iVar.a(3, this.bOX.get(i3));
            }
            for (int i4 = 0; i4 < this.bOY.size(); i4++) {
                iVar.a(4, this.bOY.get(i4));
            }
            for (int i5 = 0; i5 < this.bOZ.size(); i5++) {
                iVar.a(5, this.bOZ.get(i5));
            }
            for (int i6 = 0; i6 < this.bOW.size(); i6++) {
                iVar.a(6, this.bOW.get(i6));
            }
            if ((this.bOT & 2) != 0) {
                iVar.a(7, AG());
            }
            for (int i7 = 0; i7 < this.bPa.size(); i7++) {
                iVar.a(8, this.bPa.get(i7));
            }
            for (int i8 = 0; i8 < this.bPc.size(); i8++) {
                iVar.a(9, this.bPc.get(i8));
            }
            for (int i9 = 0; i9 < this.bPd.size(); i9++) {
                ac.a(iVar, 10, this.bPd.getRaw(i9));
            }
            this.bTW.a(iVar);
        }

        @Override // com.google.a.aw, com.google.a.a, com.google.a.ac
        public final int yC() {
            int i2 = this.bNa;
            if (i2 != -1) {
                return i2;
            }
            int d2 = (this.bOT & 1) != 0 ? ac.d(1, this.bOU) + 0 : 0;
            for (int i3 = 0; i3 < this.bOV.size(); i3++) {
                d2 += i.c(2, this.bOV.get(i3));
            }
            for (int i4 = 0; i4 < this.bOX.size(); i4++) {
                d2 += i.c(3, this.bOX.get(i4));
            }
            for (int i5 = 0; i5 < this.bOY.size(); i5++) {
                d2 += i.c(4, this.bOY.get(i5));
            }
            for (int i6 = 0; i6 < this.bOZ.size(); i6++) {
                d2 += i.c(5, this.bOZ.get(i6));
            }
            for (int i7 = 0; i7 < this.bOW.size(); i7++) {
                d2 += i.c(6, this.bOW.get(i7));
            }
            if ((this.bOT & 2) != 0) {
                d2 += i.c(7, AG());
            }
            for (int i8 = 0; i8 < this.bPa.size(); i8++) {
                d2 += i.c(8, this.bPa.get(i8));
            }
            for (int i9 = 0; i9 < this.bPc.size(); i9++) {
                d2 += i.c(9, this.bPc.get(i9));
            }
            int i10 = 0;
            for (int i11 = 0; i11 < this.bPd.size(); i11++) {
                i10 += ar(this.bPd.getRaw(i11));
            }
            int size = d2 + i10 + (this.bPd.size() * 1) + this.bTW.yC();
            this.bNa = size;
            return size;
        }

        @Override // com.google.a.a
        public final boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof a)) {
                return super.equals(obj);
            }
            a aVar = (a) obj;
            if (Az() != aVar.Az()) {
                return false;
            }
            if (Az() && !getName().equals(aVar.getName())) {
                return false;
            }
            if (!this.bOV.equals(aVar.bOV)) {
                return false;
            }
            if (!this.bOW.equals(aVar.bOW)) {
                return false;
            }
            if (!this.bOX.equals(aVar.bOX)) {
                return false;
            }
            if (!this.bOY.equals(aVar.bOY)) {
                return false;
            }
            if (!this.bOZ.equals(aVar.bOZ)) {
                return false;
            }
            if (!this.bPa.equals(aVar.bPa)) {
                return false;
            }
            if (AF() != aVar.AF()) {
                return false;
            }
            if (AF() && !AG().equals(aVar.AG())) {
                return false;
            }
            if (!this.bPc.equals(aVar.bPc)) {
                return false;
            }
            if (!this.bPd.equals(aVar.bPd)) {
                return false;
            }
            return this.bTW.equals(aVar.bTW);
        }

        @Override // com.google.a.a
        public final int hashCode() {
            if (this.bNb != 0) {
                return this.bNb;
            }
            int hashCode = k.bNU.hashCode() + com.tencent.mm.plugin.appbrand.jsapi.share.q.CTRL_INDEX;
            if (Az()) {
                hashCode = (((hashCode * 37) + 1) * 53) + getName().hashCode();
            }
            if (getFieldCount() > 0) {
                hashCode = (((hashCode * 37) + 2) * 53) + this.bOV.hashCode();
            }
            if (AA() > 0) {
                hashCode = (((hashCode * 37) + 6) * 53) + this.bOW.hashCode();
            }
            if (AB() > 0) {
                hashCode = (((hashCode * 37) + 3) * 53) + this.bOX.hashCode();
            }
            if (AC() > 0) {
                hashCode = (((hashCode * 37) + 4) * 53) + this.bOY.hashCode();
            }
            if (AD() > 0) {
                hashCode = (((hashCode * 37) + 5) * 53) + this.bOZ.hashCode();
            }
            if (AE() > 0) {
                hashCode = (((hashCode * 37) + 8) * 53) + this.bPa.hashCode();
            }
            if (AF()) {
                hashCode = (((hashCode * 37) + 7) * 53) + AG().hashCode();
            }
            if (this.bPc.size() > 0) {
                hashCode = (((hashCode * 37) + 9) * 53) + this.bPc.hashCode();
            }
            if (this.bPd.size() > 0) {
                hashCode = (((hashCode * 37) + 10) * 53) + this.bPd.hashCode();
            }
            int hashCode2 = (hashCode * 29) + this.bTW.hashCode();
            this.bNb = hashCode2;
            return hashCode2;
        }

        public static C0092a AH() {
            return bPf.AN();
        }

        /* access modifiers changed from: private */
        /* renamed from: AI */
        public C0092a AN() {
            if (this == bPf) {
                return new C0092a((byte) 0);
            }
            return new C0092a((byte) 0).j(this);
        }

        /* renamed from: com.google.a.k$a$a  reason: collision with other inner class name */
        public static final class C0092a extends ac.a<C0092a> implements b {
            private int bOT;
            private Object bOU;
            private List<m> bOV;
            private List<m> bOW;
            private List<a> bOX;
            private List<c> bOY;
            private List<b> bOZ;
            private List<aa> bPa;
            private u bPb;
            private List<d> bPc;
            private ak bPd;
            private bq<m, m.a, n> bPh;
            private bq<m, m.a, n> bPi;
            private bq<a, C0092a, b> bPj;
            private bq<c, c.a, d> bPk;
            private bq<b, b.C0093a, c> bPl;
            private bq<aa, aa.a, ab> bPm;
            private bu<u, u.a, v> bPn;
            private bq<d, d.C0094a, e> bPo;

            /* synthetic */ C0092a(byte b2) {
                this();
            }

            /* synthetic */ C0092a(ac.b bVar, byte b2) {
                this(bVar);
            }

            /* access modifiers changed from: protected */
            @Override // com.google.a.ac.a
            public final ac.f Ay() {
                return k.bNV.h(a.class, C0092a.class);
            }

            private C0092a() {
                this.bOU = "";
                this.bOV = Collections.emptyList();
                this.bOW = Collections.emptyList();
                this.bOX = Collections.emptyList();
                this.bOY = Collections.emptyList();
                this.bOZ = Collections.emptyList();
                this.bPa = Collections.emptyList();
                this.bPc = Collections.emptyList();
                this.bPd = aj.bXM;
                AR();
            }

            private C0092a(ac.b bVar) {
                super(bVar);
                this.bOU = "";
                this.bOV = Collections.emptyList();
                this.bOW = Collections.emptyList();
                this.bOX = Collections.emptyList();
                this.bOY = Collections.emptyList();
                this.bOZ = Collections.emptyList();
                this.bPa = Collections.emptyList();
                this.bPc = Collections.emptyList();
                this.bPd = aj.bXM;
                AR();
            }

            private void AR() {
                if (ac.bVU) {
                    AW();
                    AY();
                    Ba();
                    Bc();
                    Be();
                    Bg();
                    Bh();
                    Bj();
                }
            }

            @Override // com.google.a.az, com.google.a.ac.a, com.google.a.at.a
            public final l.a AS() {
                return k.bNU;
            }

            /* renamed from: AT */
            public final a Bp() {
                a AU = Bo();
                if (AU.isInitialized()) {
                    return AU;
                }
                throw b(AU);
            }

            /* access modifiers changed from: private */
            /* renamed from: AU */
            public a Bo() {
                int i2;
                a aVar = new a(this, (byte) 0);
                int i3 = this.bOT;
                if ((i3 & 1) != 0) {
                    i2 = 1;
                } else {
                    i2 = 0;
                }
                aVar.bOU = this.bOU;
                if (this.bPh == null) {
                    if ((this.bOT & 2) != 0) {
                        this.bOV = Collections.unmodifiableList(this.bOV);
                        this.bOT &= -3;
                    }
                    aVar.bOV = this.bOV;
                } else {
                    aVar.bOV = this.bPh.build();
                }
                if (this.bPi == null) {
                    if ((this.bOT & 4) != 0) {
                        this.bOW = Collections.unmodifiableList(this.bOW);
                        this.bOT &= -5;
                    }
                    aVar.bOW = this.bOW;
                } else {
                    aVar.bOW = this.bPi.build();
                }
                if (this.bPj == null) {
                    if ((this.bOT & 8) != 0) {
                        this.bOX = Collections.unmodifiableList(this.bOX);
                        this.bOT &= -9;
                    }
                    aVar.bOX = this.bOX;
                } else {
                    aVar.bOX = this.bPj.build();
                }
                if (this.bPk == null) {
                    if ((this.bOT & 16) != 0) {
                        this.bOY = Collections.unmodifiableList(this.bOY);
                        this.bOT &= -17;
                    }
                    aVar.bOY = this.bOY;
                } else {
                    aVar.bOY = this.bPk.build();
                }
                if (this.bPl == null) {
                    if ((this.bOT & 32) != 0) {
                        this.bOZ = Collections.unmodifiableList(this.bOZ);
                        this.bOT &= -33;
                    }
                    aVar.bOZ = this.bOZ;
                } else {
                    aVar.bOZ = this.bPl.build();
                }
                if (this.bPm == null) {
                    if ((this.bOT & 64) != 0) {
                        this.bPa = Collections.unmodifiableList(this.bPa);
                        this.bOT &= -65;
                    }
                    aVar.bPa = this.bPa;
                } else {
                    aVar.bPa = this.bPm.build();
                }
                if ((i3 & 128) != 0) {
                    if (this.bPn == null) {
                        aVar.bPb = this.bPb;
                    } else {
                        aVar.bPb = this.bPn.Hv();
                    }
                    i2 |= 2;
                }
                if (this.bPo == null) {
                    if ((this.bOT & 256) != 0) {
                        this.bPc = Collections.unmodifiableList(this.bPc);
                        this.bOT &= -257;
                    }
                    aVar.bPc = this.bPc;
                } else {
                    aVar.bPc = this.bPo.build();
                }
                if ((this.bOT & 512) != 0) {
                    this.bPd = this.bPd.GR();
                    this.bOT &= -513;
                }
                aVar.bPd = this.bPd;
                aVar.bOT = i2;
                Gy();
                return aVar;
            }

            /* access modifiers changed from: private */
            /* renamed from: a */
            public C0092a f(l.f fVar, Object obj) {
                return (C0092a) super.f(fVar, obj);
            }

            /* access modifiers changed from: private */
            /* renamed from: b */
            public C0092a e(l.f fVar, Object obj) {
                return (C0092a) super.e(fVar, obj);
            }

            /* access modifiers changed from: private */
            /* renamed from: d */
            public C0092a c(at atVar) {
                if (atVar instanceof a) {
                    return j((a) atVar);
                }
                super.c(atVar);
                return this;
            }

            public final C0092a j(a aVar) {
                bq<d, d.C0094a, e> bqVar = null;
                if (aVar != a.AJ()) {
                    if (aVar.Az()) {
                        this.bOT |= 1;
                        this.bOU = aVar.bOU;
                        onChanged();
                    }
                    if (this.bPh == null) {
                        if (!aVar.bOV.isEmpty()) {
                            if (this.bOV.isEmpty()) {
                                this.bOV = aVar.bOV;
                                this.bOT &= -3;
                            } else {
                                AV();
                                this.bOV.addAll(aVar.bOV);
                            }
                            onChanged();
                        }
                    } else if (!aVar.bOV.isEmpty()) {
                        if (this.bPh.isEmpty()) {
                            this.bPh.bYP = null;
                            this.bPh = null;
                            this.bOV = aVar.bOV;
                            this.bOT &= -3;
                            this.bPh = ac.bVU ? AW() : null;
                        } else {
                            this.bPh.a(aVar.bOV);
                        }
                    }
                    if (this.bPi == null) {
                        if (!aVar.bOW.isEmpty()) {
                            if (this.bOW.isEmpty()) {
                                this.bOW = aVar.bOW;
                                this.bOT &= -5;
                            } else {
                                AX();
                                this.bOW.addAll(aVar.bOW);
                            }
                            onChanged();
                        }
                    } else if (!aVar.bOW.isEmpty()) {
                        if (this.bPi.isEmpty()) {
                            this.bPi.bYP = null;
                            this.bPi = null;
                            this.bOW = aVar.bOW;
                            this.bOT &= -5;
                            this.bPi = ac.bVU ? AY() : null;
                        } else {
                            this.bPi.a(aVar.bOW);
                        }
                    }
                    if (this.bPj == null) {
                        if (!aVar.bOX.isEmpty()) {
                            if (this.bOX.isEmpty()) {
                                this.bOX = aVar.bOX;
                                this.bOT &= -9;
                            } else {
                                AZ();
                                this.bOX.addAll(aVar.bOX);
                            }
                            onChanged();
                        }
                    } else if (!aVar.bOX.isEmpty()) {
                        if (this.bPj.isEmpty()) {
                            this.bPj.bYP = null;
                            this.bPj = null;
                            this.bOX = aVar.bOX;
                            this.bOT &= -9;
                            this.bPj = ac.bVU ? Ba() : null;
                        } else {
                            this.bPj.a(aVar.bOX);
                        }
                    }
                    if (this.bPk == null) {
                        if (!aVar.bOY.isEmpty()) {
                            if (this.bOY.isEmpty()) {
                                this.bOY = aVar.bOY;
                                this.bOT &= -17;
                            } else {
                                Bb();
                                this.bOY.addAll(aVar.bOY);
                            }
                            onChanged();
                        }
                    } else if (!aVar.bOY.isEmpty()) {
                        if (this.bPk.isEmpty()) {
                            this.bPk.bYP = null;
                            this.bPk = null;
                            this.bOY = aVar.bOY;
                            this.bOT &= -17;
                            this.bPk = ac.bVU ? Bc() : null;
                        } else {
                            this.bPk.a(aVar.bOY);
                        }
                    }
                    if (this.bPl == null) {
                        if (!aVar.bOZ.isEmpty()) {
                            if (this.bOZ.isEmpty()) {
                                this.bOZ = aVar.bOZ;
                                this.bOT &= -33;
                            } else {
                                Bd();
                                this.bOZ.addAll(aVar.bOZ);
                            }
                            onChanged();
                        }
                    } else if (!aVar.bOZ.isEmpty()) {
                        if (this.bPl.isEmpty()) {
                            this.bPl.bYP = null;
                            this.bPl = null;
                            this.bOZ = aVar.bOZ;
                            this.bOT &= -33;
                            this.bPl = ac.bVU ? Be() : null;
                        } else {
                            this.bPl.a(aVar.bOZ);
                        }
                    }
                    if (this.bPm == null) {
                        if (!aVar.bPa.isEmpty()) {
                            if (this.bPa.isEmpty()) {
                                this.bPa = aVar.bPa;
                                this.bOT &= -65;
                            } else {
                                Bf();
                                this.bPa.addAll(aVar.bPa);
                            }
                            onChanged();
                        }
                    } else if (!aVar.bPa.isEmpty()) {
                        if (this.bPm.isEmpty()) {
                            this.bPm.bYP = null;
                            this.bPm = null;
                            this.bPa = aVar.bPa;
                            this.bOT &= -65;
                            this.bPm = ac.bVU ? Bg() : null;
                        } else {
                            this.bPm.a(aVar.bPa);
                        }
                    }
                    if (aVar.AF()) {
                        a(aVar.AG());
                    }
                    if (this.bPo == null) {
                        if (!aVar.bPc.isEmpty()) {
                            if (this.bPc.isEmpty()) {
                                this.bPc = aVar.bPc;
                                this.bOT &= -257;
                            } else {
                                Bi();
                                this.bPc.addAll(aVar.bPc);
                            }
                            onChanged();
                        }
                    } else if (!aVar.bPc.isEmpty()) {
                        if (this.bPo.isEmpty()) {
                            this.bPo.bYP = null;
                            this.bPo = null;
                            this.bPc = aVar.bPc;
                            this.bOT &= -257;
                            if (ac.bVU) {
                                bqVar = Bj();
                            }
                            this.bPo = bqVar;
                        } else {
                            this.bPo.a(aVar.bPc);
                        }
                    }
                    if (!aVar.bPd.isEmpty()) {
                        if (this.bPd.isEmpty()) {
                            this.bPd = aVar.bPd;
                            this.bOT &= -513;
                        } else {
                            Bk();
                            this.bPd.addAll(aVar.bPd);
                        }
                        onChanged();
                    }
                    d(aVar.bTW);
                    onChanged();
                }
                return this;
            }

            @Override // com.google.a.ax, com.google.a.ac.a
            public final boolean isInitialized() {
                int count;
                int count2;
                int count3;
                int count4;
                int count5;
                int count6;
                boolean z;
                aa s;
                b s2;
                c s3;
                a s4;
                m s5;
                m s6;
                int i2 = 0;
                while (true) {
                    if (this.bPh == null) {
                        count = this.bOV.size();
                    } else {
                        count = this.bPh.getCount();
                    }
                    if (i2 < count) {
                        if (this.bPh == null) {
                            s6 = this.bOV.get(i2);
                        } else {
                            s6 = this.bPh.s(i2, false);
                        }
                        if (!s6.isInitialized()) {
                            return false;
                        }
                        i2++;
                    } else {
                        int i3 = 0;
                        while (true) {
                            if (this.bPi == null) {
                                count2 = this.bOW.size();
                            } else {
                                count2 = this.bPi.getCount();
                            }
                            if (i3 < count2) {
                                if (this.bPi == null) {
                                    s5 = this.bOW.get(i3);
                                } else {
                                    s5 = this.bPi.s(i3, false);
                                }
                                if (!s5.isInitialized()) {
                                    return false;
                                }
                                i3++;
                            } else {
                                int i4 = 0;
                                while (true) {
                                    if (this.bPj == null) {
                                        count3 = this.bOX.size();
                                    } else {
                                        count3 = this.bPj.getCount();
                                    }
                                    if (i4 < count3) {
                                        if (this.bPj == null) {
                                            s4 = this.bOX.get(i4);
                                        } else {
                                            s4 = this.bPj.s(i4, false);
                                        }
                                        if (!s4.isInitialized()) {
                                            return false;
                                        }
                                        i4++;
                                    } else {
                                        int i5 = 0;
                                        while (true) {
                                            if (this.bPk == null) {
                                                count4 = this.bOY.size();
                                            } else {
                                                count4 = this.bPk.getCount();
                                            }
                                            if (i5 < count4) {
                                                if (this.bPk == null) {
                                                    s3 = this.bOY.get(i5);
                                                } else {
                                                    s3 = this.bPk.s(i5, false);
                                                }
                                                if (!s3.isInitialized()) {
                                                    return false;
                                                }
                                                i5++;
                                            } else {
                                                int i6 = 0;
                                                while (true) {
                                                    if (this.bPl == null) {
                                                        count5 = this.bOZ.size();
                                                    } else {
                                                        count5 = this.bPl.getCount();
                                                    }
                                                    if (i6 < count5) {
                                                        if (this.bPl == null) {
                                                            s2 = this.bOZ.get(i6);
                                                        } else {
                                                            s2 = this.bPl.s(i6, false);
                                                        }
                                                        if (!s2.isInitialized()) {
                                                            return false;
                                                        }
                                                        i6++;
                                                    } else {
                                                        int i7 = 0;
                                                        while (true) {
                                                            if (this.bPm == null) {
                                                                count6 = this.bPa.size();
                                                            } else {
                                                                count6 = this.bPm.getCount();
                                                            }
                                                            if (i7 < count6) {
                                                                if (this.bPm == null) {
                                                                    s = this.bPa.get(i7);
                                                                } else {
                                                                    s = this.bPm.s(i7, false);
                                                                }
                                                                if (!s.isInitialized()) {
                                                                    return false;
                                                                }
                                                                i7++;
                                                            } else {
                                                                if ((this.bOT & 128) != 0) {
                                                                    z = true;
                                                                } else {
                                                                    z = false;
                                                                }
                                                                return !z || AG().isInitialized();
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }

            /* access modifiers changed from: private */
            /* JADX WARNING: Removed duplicated region for block: B:16:0x001e  */
            /* renamed from: e */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public com.google.a.k.a.C0092a c(com.google.a.h r4, com.google.a.r r5) {
                /*
                    r3 = this;
                    r2 = 0
                    com.google.a.bj<com.google.a.k$a> r0 = com.google.a.k.a.bPg     // Catch:{ af -> 0x000f }
                    java.lang.Object r0 = r0.d(r4, r5)     // Catch:{ af -> 0x000f }
                    com.google.a.k$a r0 = (com.google.a.k.a) r0     // Catch:{ af -> 0x000f }
                    if (r0 == 0) goto L_0x000e
                    r3.j(r0)
                L_0x000e:
                    return r3
                L_0x000f:
                    r0 = move-exception
                    r1 = r0
                    com.google.a.aw r0 = r1.bXr     // Catch:{ all -> 0x0022 }
                    com.google.a.k$a r0 = (com.google.a.k.a) r0     // Catch:{ all -> 0x0022 }
                    java.io.IOException r1 = r1.GF()     // Catch:{ all -> 0x001a }
                    throw r1     // Catch:{ all -> 0x001a }
                L_0x001a:
                    r1 = move-exception
                    r2 = r0
                L_0x001c:
                    if (r2 == 0) goto L_0x0021
                    r3.j(r2)
                L_0x0021:
                    throw r1
                L_0x0022:
                    r0 = move-exception
                    r1 = r0
                    goto L_0x001c
                */
                throw new UnsupportedOperationException("Method not decompiled: com.google.a.k.a.C0092a.c(com.google.a.h, com.google.a.r):com.google.a.k$a$a");
            }

            public final C0092a ce(String str) {
                if (str == null) {
                    throw new NullPointerException();
                }
                this.bOT |= 1;
                this.bOU = str;
                onChanged();
                return this;
            }

            private void AV() {
                if ((this.bOT & 2) == 0) {
                    this.bOV = new ArrayList(this.bOV);
                    this.bOT |= 2;
                }
            }

            private bq<m, m.a, n> AW() {
                if (this.bPh == null) {
                    this.bPh = new bq<>(this.bOV, (this.bOT & 2) != 0, GA(), this.bWv);
                    this.bOV = null;
                }
                return this.bPh;
            }

            private void AX() {
                if ((this.bOT & 4) == 0) {
                    this.bOW = new ArrayList(this.bOW);
                    this.bOT |= 4;
                }
            }

            private bq<m, m.a, n> AY() {
                if (this.bPi == null) {
                    this.bPi = new bq<>(this.bOW, (this.bOT & 4) != 0, GA(), this.bWv);
                    this.bOW = null;
                }
                return this.bPi;
            }

            private void AZ() {
                if ((this.bOT & 8) == 0) {
                    this.bOX = new ArrayList(this.bOX);
                    this.bOT |= 8;
                }
            }

            private bq<a, C0092a, b> Ba() {
                if (this.bPj == null) {
                    this.bPj = new bq<>(this.bOX, (this.bOT & 8) != 0, GA(), this.bWv);
                    this.bOX = null;
                }
                return this.bPj;
            }

            private void Bb() {
                if ((this.bOT & 16) == 0) {
                    this.bOY = new ArrayList(this.bOY);
                    this.bOT |= 16;
                }
            }

            private bq<c, c.a, d> Bc() {
                if (this.bPk == null) {
                    this.bPk = new bq<>(this.bOY, (this.bOT & 16) != 0, GA(), this.bWv);
                    this.bOY = null;
                }
                return this.bPk;
            }

            private void Bd() {
                if ((this.bOT & 32) == 0) {
                    this.bOZ = new ArrayList(this.bOZ);
                    this.bOT |= 32;
                }
            }

            public final C0092a a(b bVar) {
                if (this.bPl != null) {
                    this.bPl.a(bVar);
                } else if (bVar == null) {
                    throw new NullPointerException();
                } else {
                    Bd();
                    this.bOZ.add(bVar);
                    onChanged();
                }
                return this;
            }

            private bq<b, b.C0093a, c> Be() {
                if (this.bPl == null) {
                    this.bPl = new bq<>(this.bOZ, (this.bOT & 32) != 0, GA(), this.bWv);
                    this.bOZ = null;
                }
                return this.bPl;
            }

            private void Bf() {
                if ((this.bOT & 64) == 0) {
                    this.bPa = new ArrayList(this.bPa);
                    this.bOT |= 64;
                }
            }

            private bq<aa, aa.a, ab> Bg() {
                if (this.bPm == null) {
                    this.bPm = new bq<>(this.bPa, (this.bOT & 64) != 0, GA(), this.bWv);
                    this.bPa = null;
                }
                return this.bPm;
            }

            private u AG() {
                if (this.bPn == null) {
                    return this.bPb == null ? u.DU() : this.bPb;
                }
                return this.bPn.Hu();
            }

            private C0092a a(u uVar) {
                if (this.bPn == null) {
                    if ((this.bOT & 128) == 0 || this.bPb == null || this.bPb == u.DU()) {
                        this.bPb = uVar;
                    } else {
                        this.bPb = u.b(this.bPb).d(uVar).Bo();
                    }
                    onChanged();
                } else {
                    this.bPn.b(uVar);
                }
                this.bOT |= 128;
                return this;
            }

            private bu<u, u.a, v> Bh() {
                if (this.bPn == null) {
                    this.bPn = new bu<>(AG(), GA(), this.bWv);
                    this.bPb = null;
                }
                return this.bPn;
            }

            private void Bi() {
                if ((this.bOT & 256) == 0) {
                    this.bPc = new ArrayList(this.bPc);
                    this.bOT |= 256;
                }
            }

            private bq<d, d.C0094a, e> Bj() {
                if (this.bPo == null) {
                    this.bPo = new bq<>(this.bPc, (this.bOT & 256) != 0, GA(), this.bWv);
                    this.bPc = null;
                }
                return this.bPo;
            }

            private void Bk() {
                if ((this.bOT & 512) == 0) {
                    this.bPd = new aj(this.bPd);
                    this.bOT |= 512;
                }
            }

            /* access modifiers changed from: private */
            /* renamed from: b */
            public C0092a f(cc ccVar) {
                return (C0092a) super.f(ccVar);
            }

            /* access modifiers changed from: private */
            /* renamed from: c */
            public C0092a d(cc ccVar) {
                return (C0092a) super.a(ccVar);
            }

            /* Return type fixed from 'com.google.a.ac$a' to match base method */
            @Override // com.google.a.ac.a
            public final /* bridge */ /* synthetic */ C0092a Bl() {
                return (C0092a) super.yG();
            }

            @Override // com.google.a.a.AbstractC0085a, com.google.a.ac.a
            public final /* synthetic */ a.AbstractC0085a yE() {
                return (C0092a) super.yG();
            }

            @Override // com.google.a.ax
            public final /* synthetic */ aw AP() {
                return a.AJ();
            }

            @Override // com.google.a.az
            public final /* synthetic */ at AQ() {
                return a.AJ();
            }

            @Override // com.google.a.b.a, com.google.a.a.AbstractC0085a, com.google.a.ac.a
            public final /* synthetic */ b.a yG() {
                return (C0092a) super.yG();
            }

            @Override // com.google.a.b.a, com.google.a.a.AbstractC0085a, java.lang.Object, com.google.a.ac.a
            public final /* synthetic */ Object clone() {
                return (C0092a) super.yG();
            }
        }

        public static a AJ() {
            return bPf;
        }

        @Override // com.google.a.aw, com.google.a.ac
        public final bj<a> AK() {
            return bPg;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.a.ac
        public final /* synthetic */ at.a a(ac.b bVar) {
            return new C0092a(bVar, (byte) 0);
        }

        @Override // com.google.a.at
        public final /* synthetic */ at.a AM() {
            return bPf.AN();
        }

        @Override // com.google.a.aw
        public final /* synthetic */ aw.a AO() {
            return bPf.AN();
        }

        @Override // com.google.a.ax
        public final /* bridge */ /* synthetic */ aw AP() {
            return bPf;
        }

        @Override // com.google.a.az
        public final /* bridge */ /* synthetic */ at AQ() {
            return bPf;
        }
    }

    /* renamed from: com.google.a.k$k  reason: collision with other inner class name */
    public static final class C0096k extends ac.d<C0096k> implements l {
        private static final C0096k bPI = new C0096k();
        @Deprecated
        public static final bj<C0096k> bPg = new c<C0096k>() {
            /* class com.google.a.k.C0096k.AnonymousClass1 */

            @Override // com.google.a.bj
            public final /* synthetic */ Object d(h hVar, r rVar) {
                return new C0096k(hVar, rVar, (byte) 0);
            }
        };
        private List<ak> bPB;
        private byte bPe;

        /* synthetic */ C0096k(ac.c cVar, byte b2) {
            this(cVar);
        }

        /* synthetic */ C0096k(h hVar, r rVar, byte b2) {
            this(hVar, rVar);
        }

        private C0096k(ac.c<C0096k, ?> cVar) {
            super(cVar);
            this.bPe = -1;
        }

        private C0096k() {
            this.bPe = -1;
            this.bPB = Collections.emptyList();
        }

        @Override // com.google.a.az, com.google.a.ac
        public final cc Ax() {
            return this.bTW;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r3v3, resolved type: java.util.List<com.google.a.k$ak> */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARNING: Removed duplicated region for block: B:26:0x004a  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private C0096k(com.google.a.h r7, com.google.a.r r8) {
            /*
            // Method dump skipped, instructions count: 140
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.a.k.C0096k.<init>(com.google.a.h, com.google.a.r):void");
        }

        /* access modifiers changed from: protected */
        @Override // com.google.a.ac
        public final ac.f Ay() {
            return k.bOb.h(C0096k.class, a.class);
        }

        private int BO() {
            return this.bPB.size();
        }

        @Override // com.google.a.a, com.google.a.ax, com.google.a.ac.d, com.google.a.ac
        public final boolean isInitialized() {
            byte b2 = this.bPe;
            if (b2 == 1) {
                return true;
            }
            if (b2 == 0) {
                return false;
            }
            for (int i2 = 0; i2 < BO(); i2++) {
                if (!this.bPB.get(i2).isInitialized()) {
                    this.bPe = 0;
                    return false;
                }
            }
            if (!this.bWd.isInitialized()) {
                this.bPe = 0;
                return false;
            }
            this.bPe = 1;
            return true;
        }

        @Override // com.google.a.aw, com.google.a.a, com.google.a.ac
        public final void a(i iVar) {
            ac.d<MessageType>.a GC = GC();
            for (int i2 = 0; i2 < this.bPB.size(); i2++) {
                iVar.a(999, this.bPB.get(i2));
            }
            GC.b(iVar);
            this.bTW.a(iVar);
        }

        @Override // com.google.a.aw, com.google.a.a, com.google.a.ac
        public final int yC() {
            int i2 = this.bNa;
            if (i2 != -1) {
                return i2;
            }
            int i3 = 0;
            for (int i4 = 0; i4 < this.bPB.size(); i4++) {
                i3 += i.c(999, this.bPB.get(i4));
            }
            int yC = this.bWd.yC() + i3 + this.bTW.yC();
            this.bNa = yC;
            return yC;
        }

        @Override // com.google.a.a
        public final boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof C0096k)) {
                return super.equals(obj);
            }
            C0096k kVar = (C0096k) obj;
            if (!this.bPB.equals(kVar.bPB)) {
                return false;
            }
            if (!this.bTW.equals(kVar.bTW)) {
                return false;
            }
            return this.bWd.FS().equals(kVar.bWd.FS());
        }

        @Override // com.google.a.a
        public final int hashCode() {
            if (this.bNb != 0) {
                return this.bNb;
            }
            int hashCode = k.bOa.hashCode() + com.tencent.mm.plugin.appbrand.jsapi.share.q.CTRL_INDEX;
            if (BO() > 0) {
                hashCode = (((hashCode * 37) + 999) * 53) + this.bPB.hashCode();
            }
            int b2 = (b(hashCode, this.bWd.FS()) * 29) + this.bTW.hashCode();
            this.bNb = b2;
            return b2;
        }

        public static a b(C0096k kVar) {
            return bPI.AN().d(kVar);
        }

        /* renamed from: Cg */
        public final a AN() {
            if (this == bPI) {
                return new a((byte) 0);
            }
            return new a((byte) 0).d(this);
        }

        /* renamed from: com.google.a.k$k$a */
        public static final class a extends ac.c<C0096k, a> implements l {
            private int bOT;
            private List<ak> bPB;
            private bq<ak, ak.a, al> bPD;

            /* synthetic */ a(byte b2) {
                this();
            }

            /* synthetic */ a(ac.b bVar, byte b2) {
                this(bVar);
            }

            /* access modifiers changed from: protected */
            @Override // com.google.a.ac.a
            public final ac.f Ay() {
                return k.bOb.h(C0096k.class, a.class);
            }

            private a() {
                this.bPB = Collections.emptyList();
                AR();
            }

            private a(ac.b bVar) {
                super(bVar);
                this.bPB = Collections.emptyList();
                AR();
            }

            private void AR() {
                if (ac.bVU) {
                    BU();
                }
            }

            @Override // com.google.a.az, com.google.a.ac.a, com.google.a.at.a
            public final l.a AS() {
                return k.bOa;
            }

            /* access modifiers changed from: private */
            /* renamed from: Ci */
            public C0096k Bp() {
                C0096k Cj = Bo();
                if (Cj.isInitialized()) {
                    return Cj;
                }
                throw b(Cj);
            }

            /* renamed from: Cj */
            public final C0096k Bo() {
                C0096k kVar = new C0096k(this, (byte) 0);
                if (this.bPD == null) {
                    if ((this.bOT & 1) != 0) {
                        this.bPB = Collections.unmodifiableList(this.bPB);
                        this.bOT &= -2;
                    }
                    kVar.bPB = this.bPB;
                } else {
                    kVar.bPB = this.bPD.build();
                }
                Gy();
                return kVar;
            }

            /* access modifiers changed from: private */
            /* renamed from: w */
            public a r(l.f fVar, Object obj) {
                return (a) super.f(fVar, obj);
            }

            /* access modifiers changed from: private */
            /* renamed from: x */
            public a q(l.f fVar, Object obj) {
                return (a) super.e(fVar, obj);
            }

            /* access modifiers changed from: private */
            /* renamed from: l */
            public a c(at atVar) {
                if (atVar instanceof C0096k) {
                    return d((C0096k) atVar);
                }
                super.c(atVar);
                return this;
            }

            public final a d(C0096k kVar) {
                bq<ak, ak.a, al> bqVar = null;
                if (kVar != C0096k.Ch()) {
                    if (this.bPD == null) {
                        if (!kVar.bPB.isEmpty()) {
                            if (this.bPB.isEmpty()) {
                                this.bPB = kVar.bPB;
                                this.bOT &= -2;
                            } else {
                                BT();
                                this.bPB.addAll(kVar.bPB);
                            }
                            onChanged();
                        }
                    } else if (!kVar.bPB.isEmpty()) {
                        if (this.bPD.isEmpty()) {
                            this.bPD.bYP = null;
                            this.bPD = null;
                            this.bPB = kVar.bPB;
                            this.bOT &= -2;
                            if (ac.bVU) {
                                bqVar = BU();
                            }
                            this.bPD = bqVar;
                        } else {
                            this.bPD.a(kVar.bPB);
                        }
                    }
                    a((ac.d) kVar);
                    d(kVar.bTW);
                    onChanged();
                }
                return this;
            }

            @Override // com.google.a.ax, com.google.a.ac.c, com.google.a.ac.a
            public final boolean isInitialized() {
                int count;
                ak s;
                int i2 = 0;
                while (true) {
                    if (this.bPD == null) {
                        count = this.bPB.size();
                    } else {
                        count = this.bPD.getCount();
                    }
                    if (i2 < count) {
                        if (this.bPD == null) {
                            s = this.bPB.get(i2);
                        } else {
                            s = this.bPD.s(i2, false);
                        }
                        if (!s.isInitialized()) {
                            return false;
                        }
                        i2++;
                    } else if (this.bWd.isInitialized()) {
                        return true;
                    } else {
                        return false;
                    }
                }
            }

            /* access modifiers changed from: private */
            /* JADX WARNING: Removed duplicated region for block: B:16:0x001e  */
            /* renamed from: m */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public com.google.a.k.C0096k.a c(com.google.a.h r4, com.google.a.r r5) {
                /*
                    r3 = this;
                    r2 = 0
                    com.google.a.bj<com.google.a.k$k> r0 = com.google.a.k.C0096k.bPg     // Catch:{ af -> 0x000f }
                    java.lang.Object r0 = r0.d(r4, r5)     // Catch:{ af -> 0x000f }
                    com.google.a.k$k r0 = (com.google.a.k.C0096k) r0     // Catch:{ af -> 0x000f }
                    if (r0 == 0) goto L_0x000e
                    r3.d(r0)
                L_0x000e:
                    return r3
                L_0x000f:
                    r0 = move-exception
                    r1 = r0
                    com.google.a.aw r0 = r1.bXr     // Catch:{ all -> 0x0022 }
                    com.google.a.k$k r0 = (com.google.a.k.C0096k) r0     // Catch:{ all -> 0x0022 }
                    java.io.IOException r1 = r1.GF()     // Catch:{ all -> 0x001a }
                    throw r1     // Catch:{ all -> 0x001a }
                L_0x001a:
                    r1 = move-exception
                    r2 = r0
                L_0x001c:
                    if (r2 == 0) goto L_0x0021
                    r3.d(r2)
                L_0x0021:
                    throw r1
                L_0x0022:
                    r0 = move-exception
                    r1 = r0
                    goto L_0x001c
                */
                throw new UnsupportedOperationException("Method not decompiled: com.google.a.k.C0096k.a.c(com.google.a.h, com.google.a.r):com.google.a.k$k$a");
            }

            private void BT() {
                if ((this.bOT & 1) == 0) {
                    this.bPB = new ArrayList(this.bPB);
                    this.bOT |= 1;
                }
            }

            private bq<ak, ak.a, al> BU() {
                if (this.bPD == null) {
                    this.bPD = new bq<>(this.bPB, (this.bOT & 1) != 0, GA(), this.bWv);
                    this.bPB = null;
                }
                return this.bPD;
            }

            /* access modifiers changed from: private */
            /* renamed from: u */
            public a f(cc ccVar) {
                return (a) super.f(ccVar);
            }

            /* access modifiers changed from: private */
            /* renamed from: v */
            public a d(cc ccVar) {
                return (a) super.a(ccVar);
            }

            @Override // com.google.a.az
            public final /* synthetic */ at AQ() {
                return C0096k.Ch();
            }

            @Override // com.google.a.ax
            public final /* synthetic */ aw AP() {
                return C0096k.Ch();
            }

            @Override // com.google.a.ac.a
            public final /* bridge */ /* synthetic */ ac.a Bl() {
                return (a) super.yG();
            }

            @Override // com.google.a.a.AbstractC0085a, com.google.a.ac.a
            public final /* synthetic */ a.AbstractC0085a yE() {
                return (a) super.yG();
            }

            @Override // com.google.a.b.a, com.google.a.a.AbstractC0085a, com.google.a.ac.a
            public final /* synthetic */ b.a yG() {
                return (a) super.yG();
            }

            @Override // com.google.a.b.a, com.google.a.a.AbstractC0085a, java.lang.Object, com.google.a.ac.a
            public final /* synthetic */ Object clone() {
                return (a) super.yG();
            }
        }

        public static C0096k Ch() {
            return bPI;
        }

        @Override // com.google.a.aw, com.google.a.ac
        public final bj<C0096k> AK() {
            return bPg;
        }

        @Override // com.google.a.az
        public final /* bridge */ /* synthetic */ at AQ() {
            return bPI;
        }

        @Override // com.google.a.ax
        public final /* bridge */ /* synthetic */ aw AP() {
            return bPI;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.a.ac
        public final /* synthetic */ at.a a(ac.b bVar) {
            return new a(bVar, (byte) 0);
        }

        @Override // com.google.a.at
        public final /* synthetic */ at.a AM() {
            return bPI.AN();
        }

        @Override // com.google.a.aw
        public final /* synthetic */ aw.a AO() {
            return bPI.AN();
        }
    }

    public static final class m extends ac implements n {
        private static final m bPQ = new m();
        @Deprecated
        public static final bj<m> bPg = new c<m>() {
            /* class com.google.a.k.m.AnonymousClass1 */

            @Override // com.google.a.bj
            public final /* synthetic */ Object d(h hVar, r rVar) {
                return new m(hVar, rVar, (byte) 0);
            }
        };
        private int bOT;
        private volatile Object bOU;
        int bPE;
        private int bPJ;
        private volatile Object bPK;
        private volatile Object bPL;
        private volatile Object bPM;
        int bPN;
        private volatile Object bPO;
        private o bPP;
        private byte bPe;
        private int type_;

        /* synthetic */ m(ac.a aVar, byte b2) {
            this(aVar);
        }

        /* synthetic */ m(h hVar, r rVar, byte b2) {
            this(hVar, rVar);
        }

        private m(ac.a<?> aVar) {
            super(aVar);
            this.bPe = -1;
        }

        private m() {
            this.bPe = -1;
            this.bOU = "";
            this.bPJ = 1;
            this.type_ = 1;
            this.bPK = "";
            this.bPL = "";
            this.bPM = "";
            this.bPO = "";
        }

        @Override // com.google.a.az, com.google.a.ac
        public final cc Ax() {
            return this.bTW;
        }

        private m(h hVar, r rVar) {
            this();
            o.a aVar;
            boolean z;
            if (rVar == null) {
                throw new NullPointerException();
            }
            cc.a HJ = cc.HJ();
            boolean z2 = false;
            while (!z2) {
                try {
                    int yT = hVar.yT();
                    switch (yT) {
                        case 0:
                            z2 = true;
                            break;
                        case 10:
                            g zb = hVar.zb();
                            this.bOT |= 1;
                            this.bOU = zb;
                            break;
                        case 18:
                            g zb2 = hVar.zb();
                            this.bOT |= 32;
                            this.bPL = zb2;
                            break;
                        case 24:
                            this.bOT |= 2;
                            this.bPE = hVar.yW();
                            break;
                        case 32:
                            int zd = hVar.zd();
                            if (b.gp(zd) != null) {
                                this.bOT |= 4;
                                this.bPJ = zd;
                                break;
                            } else {
                                HJ.bx(4, zd);
                                break;
                            }
                        case 40:
                            int zd2 = hVar.zd();
                            if (c.gq(zd2) != null) {
                                this.bOT |= 8;
                                this.type_ = zd2;
                                break;
                            } else {
                                HJ.bx(5, zd2);
                                break;
                            }
                        case 50:
                            g zb3 = hVar.zb();
                            this.bOT |= 16;
                            this.bPK = zb3;
                            break;
                        case 58:
                            g zb4 = hVar.zb();
                            this.bOT |= 64;
                            this.bPM = zb4;
                            break;
                        case 66:
                            if ((this.bOT & 512) != 0) {
                                aVar = this.bPP.AN();
                            } else {
                                aVar = null;
                            }
                            this.bPP = (o) hVar.a(o.bPg, rVar);
                            if (aVar != null) {
                                aVar.d(this.bPP);
                                this.bPP = aVar.Bo();
                            }
                            this.bOT |= 512;
                            break;
                        case 72:
                            this.bOT |= 128;
                            this.bPN = hVar.yW();
                            break;
                        case PlayerException.EXCEPTION_TYPE_ERROR_CREATE_JAVA_DATASOURCE /*{ENCODED_INT: 82}*/:
                            g zb5 = hVar.zb();
                            this.bOT |= 256;
                            this.bPO = zb5;
                            break;
                        default:
                            if (!a(hVar, HJ, rVar, yT)) {
                                z = true;
                            } else {
                                z = z2;
                            }
                            z2 = z;
                            break;
                    }
                } catch (af e2) {
                    e2.bXr = this;
                    throw e2;
                } catch (IOException e3) {
                    af afVar = new af(e3);
                    afVar.bXr = this;
                    throw afVar;
                } catch (Throwable th) {
                    this.bTW = HJ.Bp();
                    Gw();
                    throw th;
                }
            }
            this.bTW = HJ.Bp();
            Gw();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.a.ac
        public final ac.f Ay() {
            return k.bOd.h(m.class, a.class);
        }

        public enum c implements bn {
            TYPE_DOUBLE(1),
            TYPE_FLOAT(2),
            TYPE_INT64(3),
            TYPE_UINT64(4),
            TYPE_INT32(5),
            TYPE_FIXED64(6),
            TYPE_FIXED32(7),
            TYPE_BOOL(8),
            TYPE_STRING(9),
            TYPE_GROUP(10),
            TYPE_MESSAGE(11),
            TYPE_BYTES(12),
            TYPE_UINT32(13),
            TYPE_ENUM(14),
            TYPE_SFIXED32(15),
            TYPE_SFIXED64(16),
            TYPE_SINT32(17),
            TYPE_SINT64(18);
            
            private static final ae.b<c> bPU = new ae.b<c>() {
                /* class com.google.a.k.m.c.AnonymousClass1 */
            };
            private static final c[] bQp = values();
            final int value;

            @Override // com.google.a.ae.a
            public final int getNumber() {
                return this.value;
            }

            private c(int i2) {
                this.value = i2;
            }

            @Deprecated
            public static c gq(int i2) {
                switch (i2) {
                    case 1:
                        return TYPE_DOUBLE;
                    case 2:
                        return TYPE_FLOAT;
                    case 3:
                        return TYPE_INT64;
                    case 4:
                        return TYPE_UINT64;
                    case 5:
                        return TYPE_INT32;
                    case 6:
                        return TYPE_FIXED64;
                    case 7:
                        return TYPE_FIXED32;
                    case 8:
                        return TYPE_BOOL;
                    case 9:
                        return TYPE_STRING;
                    case 10:
                        return TYPE_GROUP;
                    case 11:
                        return TYPE_MESSAGE;
                    case 12:
                        return TYPE_BYTES;
                    case 13:
                        return TYPE_UINT32;
                    case 14:
                        return TYPE_ENUM;
                    case 15:
                        return TYPE_SFIXED32;
                    case 16:
                        return TYPE_SFIXED64;
                    case 17:
                        return TYPE_SINT32;
                    case 18:
                        return TYPE_SINT64;
                    default:
                        return null;
                }
            }
        }

        public enum b implements bn {
            LABEL_OPTIONAL(1),
            LABEL_REQUIRED(2),
            LABEL_REPEATED(3);
            
            private static final ae.b<b> bPU = new ae.b<b>() {
                /* class com.google.a.k.m.b.AnonymousClass1 */
            };
            private static final b[] bPV = values();
            final int value;

            @Override // com.google.a.ae.a
            public final int getNumber() {
                return this.value;
            }

            private b(int i2) {
                this.value = i2;
            }

            @Deprecated
            public static b gp(int i2) {
                switch (i2) {
                    case 1:
                        return LABEL_OPTIONAL;
                    case 2:
                        return LABEL_REQUIRED;
                    case 3:
                        return LABEL_REPEATED;
                    default:
                        return null;
                }
            }
        }

        public final boolean Az() {
            return (this.bOT & 1) != 0;
        }

        public final String getName() {
            Object obj = this.bOU;
            if (obj instanceof String) {
                return (String) obj;
            }
            g gVar = (g) obj;
            String yO = gVar.yO();
            if (gVar.yP()) {
                this.bOU = yO;
            }
            return yO;
        }

        public final boolean BV() {
            return (this.bOT & 2) != 0;
        }

        public final boolean Ck() {
            return (this.bOT & 4) != 0;
        }

        public final b Cl() {
            b gp = b.gp(this.bPJ);
            return gp == null ? b.LABEL_OPTIONAL : gp;
        }

        public final boolean Cm() {
            return (this.bOT & 8) != 0;
        }

        public final c Cn() {
            c gq = c.gq(this.type_);
            return gq == null ? c.TYPE_DOUBLE : gq;
        }

        public final boolean Co() {
            return (this.bOT & 16) != 0;
        }

        public final String getTypeName() {
            Object obj = this.bPK;
            if (obj instanceof String) {
                return (String) obj;
            }
            g gVar = (g) obj;
            String yO = gVar.yO();
            if (gVar.yP()) {
                this.bPK = yO;
            }
            return yO;
        }

        public final boolean Cp() {
            return (this.bOT & 32) != 0;
        }

        public final String Cq() {
            Object obj = this.bPL;
            if (obj instanceof String) {
                return (String) obj;
            }
            g gVar = (g) obj;
            String yO = gVar.yO();
            if (gVar.yP()) {
                this.bPL = yO;
            }
            return yO;
        }

        public final boolean Cr() {
            return (this.bOT & 64) != 0;
        }

        public final String getDefaultValue() {
            Object obj = this.bPM;
            if (obj instanceof String) {
                return (String) obj;
            }
            g gVar = (g) obj;
            String yO = gVar.yO();
            if (gVar.yP()) {
                this.bPM = yO;
            }
            return yO;
        }

        public final boolean Cs() {
            return (this.bOT & 128) != 0;
        }

        public final boolean Ct() {
            return (this.bOT & 256) != 0;
        }

        public final String Cu() {
            Object obj = this.bPO;
            if (obj instanceof String) {
                return (String) obj;
            }
            g gVar = (g) obj;
            String yO = gVar.yO();
            if (gVar.yP()) {
                this.bPO = yO;
            }
            return yO;
        }

        public final boolean AF() {
            return (this.bOT & 512) != 0;
        }

        public final o Cv() {
            return this.bPP == null ? o.CI() : this.bPP;
        }

        @Override // com.google.a.a, com.google.a.ax, com.google.a.ac
        public final boolean isInitialized() {
            byte b2 = this.bPe;
            if (b2 == 1) {
                return true;
            }
            if (b2 == 0) {
                return false;
            }
            if (!AF() || Cv().isInitialized()) {
                this.bPe = 1;
                return true;
            }
            this.bPe = 0;
            return false;
        }

        @Override // com.google.a.aw, com.google.a.a, com.google.a.ac
        public final void a(i iVar) {
            if ((this.bOT & 1) != 0) {
                ac.a(iVar, 1, this.bOU);
            }
            if ((this.bOT & 32) != 0) {
                ac.a(iVar, 2, this.bPL);
            }
            if ((this.bOT & 2) != 0) {
                iVar.bs(3, this.bPE);
            }
            if ((this.bOT & 4) != 0) {
                iVar.bs(4, this.bPJ);
            }
            if ((this.bOT & 8) != 0) {
                iVar.bs(5, this.type_);
            }
            if ((this.bOT & 16) != 0) {
                ac.a(iVar, 6, this.bPK);
            }
            if ((this.bOT & 64) != 0) {
                ac.a(iVar, 7, this.bPM);
            }
            if ((this.bOT & 512) != 0) {
                iVar.a(8, Cv());
            }
            if ((this.bOT & 128) != 0) {
                iVar.bs(9, this.bPN);
            }
            if ((this.bOT & 256) != 0) {
                ac.a(iVar, 10, this.bPO);
            }
            this.bTW.a(iVar);
        }

        @Override // com.google.a.aw, com.google.a.a, com.google.a.ac
        public final int yC() {
            int i2 = this.bNa;
            if (i2 != -1) {
                return i2;
            }
            int i3 = 0;
            if ((this.bOT & 1) != 0) {
                i3 = ac.d(1, this.bOU) + 0;
            }
            if ((this.bOT & 32) != 0) {
                i3 += ac.d(2, this.bPL);
            }
            if ((this.bOT & 2) != 0) {
                i3 += i.bu(3, this.bPE);
            }
            if ((this.bOT & 4) != 0) {
                i3 += i.bv(4, this.bPJ);
            }
            if ((this.bOT & 8) != 0) {
                i3 += i.bv(5, this.type_);
            }
            if ((this.bOT & 16) != 0) {
                i3 += ac.d(6, this.bPK);
            }
            if ((this.bOT & 64) != 0) {
                i3 += ac.d(7, this.bPM);
            }
            if ((this.bOT & 512) != 0) {
                i3 += i.c(8, Cv());
            }
            if ((this.bOT & 128) != 0) {
                i3 += i.bu(9, this.bPN);
            }
            if ((this.bOT & 256) != 0) {
                i3 += ac.d(10, this.bPO);
            }
            int yC = i3 + this.bTW.yC();
            this.bNa = yC;
            return yC;
        }

        @Override // com.google.a.a
        public final boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof m)) {
                return super.equals(obj);
            }
            m mVar = (m) obj;
            if (Az() != mVar.Az()) {
                return false;
            }
            if (Az() && !getName().equals(mVar.getName())) {
                return false;
            }
            if (BV() != mVar.BV()) {
                return false;
            }
            if (BV() && this.bPE != mVar.bPE) {
                return false;
            }
            if (Ck() != mVar.Ck()) {
                return false;
            }
            if (Ck() && this.bPJ != mVar.bPJ) {
                return false;
            }
            if (Cm() != mVar.Cm()) {
                return false;
            }
            if (Cm() && this.type_ != mVar.type_) {
                return false;
            }
            if (Co() != mVar.Co()) {
                return false;
            }
            if (Co() && !getTypeName().equals(mVar.getTypeName())) {
                return false;
            }
            if (Cp() != mVar.Cp()) {
                return false;
            }
            if (Cp() && !Cq().equals(mVar.Cq())) {
                return false;
            }
            if (Cr() != mVar.Cr()) {
                return false;
            }
            if (Cr() && !getDefaultValue().equals(mVar.getDefaultValue())) {
                return false;
            }
            if (Cs() != mVar.Cs()) {
                return false;
            }
            if (Cs() && this.bPN != mVar.bPN) {
                return false;
            }
            if (Ct() != mVar.Ct()) {
                return false;
            }
            if (Ct() && !Cu().equals(mVar.Cu())) {
                return false;
            }
            if (AF() != mVar.AF()) {
                return false;
            }
            if (!AF() || Cv().equals(mVar.Cv())) {
                return this.bTW.equals(mVar.bTW);
            }
            return false;
        }

        @Override // com.google.a.a
        public final int hashCode() {
            if (this.bNb != 0) {
                return this.bNb;
            }
            int hashCode = k.bOc.hashCode() + com.tencent.mm.plugin.appbrand.jsapi.share.q.CTRL_INDEX;
            if (Az()) {
                hashCode = (((hashCode * 37) + 1) * 53) + getName().hashCode();
            }
            if (BV()) {
                hashCode = (((hashCode * 37) + 3) * 53) + this.bPE;
            }
            if (Ck()) {
                hashCode = (((hashCode * 37) + 4) * 53) + this.bPJ;
            }
            if (Cm()) {
                hashCode = (((hashCode * 37) + 5) * 53) + this.type_;
            }
            if (Co()) {
                hashCode = (((hashCode * 37) + 6) * 53) + getTypeName().hashCode();
            }
            if (Cp()) {
                hashCode = (((hashCode * 37) + 2) * 53) + Cq().hashCode();
            }
            if (Cr()) {
                hashCode = (((hashCode * 37) + 7) * 53) + getDefaultValue().hashCode();
            }
            if (Cs()) {
                hashCode = (((hashCode * 37) + 9) * 53) + this.bPN;
            }
            if (Ct()) {
                hashCode = (((hashCode * 37) + 10) * 53) + Cu().hashCode();
            }
            if (AF()) {
                hashCode = (((hashCode * 37) + 8) * 53) + Cv().hashCode();
            }
            int hashCode2 = (hashCode * 29) + this.bTW.hashCode();
            this.bNb = hashCode2;
            return hashCode2;
        }

        /* access modifiers changed from: private */
        /* renamed from: Cw */
        public a AN() {
            if (this == bPQ) {
                return new a((byte) 0);
            }
            return new a((byte) 0).f(this);
        }

        public static final class a extends ac.a<a> implements n {
            private int bOT;
            private Object bOU;
            private int bPE;
            private int bPJ;
            private Object bPK;
            private Object bPL;
            private Object bPM;
            private int bPN;
            private Object bPO;
            private o bPP;
            private bu<o, o.a, p> bPn;
            private int type_;

            /* synthetic */ a(byte b2) {
                this();
            }

            /* synthetic */ a(ac.b bVar, byte b2) {
                this(bVar);
            }

            /* access modifiers changed from: protected */
            @Override // com.google.a.ac.a
            public final ac.f Ay() {
                return k.bOd.h(m.class, a.class);
            }

            private a() {
                this.bOU = "";
                this.bPJ = 1;
                this.type_ = 1;
                this.bPK = "";
                this.bPL = "";
                this.bPM = "";
                this.bPO = "";
                AR();
            }

            private a(ac.b bVar) {
                super(bVar);
                this.bOU = "";
                this.bPJ = 1;
                this.type_ = 1;
                this.bPK = "";
                this.bPL = "";
                this.bPM = "";
                this.bPO = "";
                AR();
            }

            private void AR() {
                if (ac.bVU) {
                    Bh();
                }
            }

            @Override // com.google.a.az, com.google.a.ac.a, com.google.a.at.a
            public final l.a AS() {
                return k.bOc;
            }

            /* access modifiers changed from: private */
            /* renamed from: Cy */
            public m Bp() {
                m Cz = Bo();
                if (Cz.isInitialized()) {
                    return Cz;
                }
                throw b(Cz);
            }

            /* access modifiers changed from: private */
            /* renamed from: Cz */
            public m Bo() {
                int i2;
                int i3 = 0;
                m mVar = new m(this, (byte) 0);
                int i4 = this.bOT;
                if ((i4 & 1) != 0) {
                    i3 = 1;
                }
                mVar.bOU = this.bOU;
                if ((i4 & 2) != 0) {
                    mVar.bPE = this.bPE;
                    i3 |= 2;
                }
                if ((i4 & 4) != 0) {
                    i3 |= 4;
                }
                mVar.bPJ = this.bPJ;
                if ((i4 & 8) != 0) {
                    i3 |= 8;
                }
                mVar.type_ = this.type_;
                if ((i4 & 16) != 0) {
                    i3 |= 16;
                }
                mVar.bPK = this.bPK;
                if ((i4 & 32) != 0) {
                    i3 |= 32;
                }
                mVar.bPL = this.bPL;
                if ((i4 & 64) != 0) {
                    i3 |= 64;
                }
                mVar.bPM = this.bPM;
                if ((i4 & 128) != 0) {
                    mVar.bPN = this.bPN;
                    i3 |= 128;
                }
                if ((i4 & 256) != 0) {
                    i2 = i3 | 256;
                } else {
                    i2 = i3;
                }
                mVar.bPO = this.bPO;
                if ((i4 & 512) != 0) {
                    if (this.bPn == null) {
                        mVar.bPP = this.bPP;
                    } else {
                        mVar.bPP = this.bPn.Hv();
                    }
                    i2 |= 512;
                }
                mVar.bOT = i2;
                Gy();
                return mVar;
            }

            /* access modifiers changed from: private */
            /* renamed from: y */
            public a f(l.f fVar, Object obj) {
                return (a) super.f(fVar, obj);
            }

            /* access modifiers changed from: private */
            /* renamed from: z */
            public a e(l.f fVar, Object obj) {
                return (a) super.e(fVar, obj);
            }

            /* access modifiers changed from: private */
            /* renamed from: m */
            public a c(at atVar) {
                if (atVar instanceof m) {
                    return f((m) atVar);
                }
                super.c(atVar);
                return this;
            }

            public final a f(m mVar) {
                if (mVar != m.Cx()) {
                    if (mVar.Az()) {
                        this.bOT |= 1;
                        this.bOU = mVar.bOU;
                        onChanged();
                    }
                    if (mVar.BV()) {
                        gn(mVar.bPE);
                    }
                    if (mVar.Ck()) {
                        a(mVar.Cl());
                    }
                    if (mVar.Cm()) {
                        a(mVar.Cn());
                    }
                    if (mVar.Co()) {
                        this.bOT |= 16;
                        this.bPK = mVar.bPK;
                        onChanged();
                    }
                    if (mVar.Cp()) {
                        this.bOT |= 32;
                        this.bPL = mVar.bPL;
                        onChanged();
                    }
                    if (mVar.Cr()) {
                        this.bOT |= 64;
                        this.bPM = mVar.bPM;
                        onChanged();
                    }
                    if (mVar.Cs()) {
                        go(mVar.bPN);
                    }
                    if (mVar.Ct()) {
                        this.bOT |= 256;
                        this.bPO = mVar.bPO;
                        onChanged();
                    }
                    if (mVar.AF()) {
                        a(mVar.Cv());
                    }
                    d(mVar.bTW);
                    onChanged();
                }
                return this;
            }

            @Override // com.google.a.ax, com.google.a.ac.a
            public final boolean isInitialized() {
                boolean z;
                if ((this.bOT & 512) != 0) {
                    z = true;
                } else {
                    z = false;
                }
                return !z || Cv().isInitialized();
            }

            /* access modifiers changed from: private */
            /* JADX WARNING: Removed duplicated region for block: B:16:0x001e  */
            /* renamed from: n */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public com.google.a.k.m.a c(com.google.a.h r4, com.google.a.r r5) {
                /*
                    r3 = this;
                    r2 = 0
                    com.google.a.bj<com.google.a.k$m> r0 = com.google.a.k.m.bPg     // Catch:{ af -> 0x000f }
                    java.lang.Object r0 = r0.d(r4, r5)     // Catch:{ af -> 0x000f }
                    com.google.a.k$m r0 = (com.google.a.k.m) r0     // Catch:{ af -> 0x000f }
                    if (r0 == 0) goto L_0x000e
                    r3.f(r0)
                L_0x000e:
                    return r3
                L_0x000f:
                    r0 = move-exception
                    r1 = r0
                    com.google.a.aw r0 = r1.bXr     // Catch:{ all -> 0x0022 }
                    com.google.a.k$m r0 = (com.google.a.k.m) r0     // Catch:{ all -> 0x0022 }
                    java.io.IOException r1 = r1.GF()     // Catch:{ all -> 0x001a }
                    throw r1     // Catch:{ all -> 0x001a }
                L_0x001a:
                    r1 = move-exception
                    r2 = r0
                L_0x001c:
                    if (r2 == 0) goto L_0x0021
                    r3.f(r2)
                L_0x0021:
                    throw r1
                L_0x0022:
                    r0 = move-exception
                    r1 = r0
                    goto L_0x001c
                */
                throw new UnsupportedOperationException("Method not decompiled: com.google.a.k.m.a.c(com.google.a.h, com.google.a.r):com.google.a.k$m$a");
            }

            private a gn(int i2) {
                this.bOT |= 2;
                this.bPE = i2;
                onChanged();
                return this;
            }

            private a a(b bVar) {
                if (bVar == null) {
                    throw new NullPointerException();
                }
                this.bOT |= 4;
                this.bPJ = bVar.value;
                onChanged();
                return this;
            }

            private a a(c cVar) {
                if (cVar == null) {
                    throw new NullPointerException();
                }
                this.bOT |= 8;
                this.type_ = cVar.value;
                onChanged();
                return this;
            }

            private a go(int i2) {
                this.bOT |= 128;
                this.bPN = i2;
                onChanged();
                return this;
            }

            private o Cv() {
                if (this.bPn == null) {
                    return this.bPP == null ? o.CI() : this.bPP;
                }
                return this.bPn.Hu();
            }

            private a a(o oVar) {
                if (this.bPn == null) {
                    if ((this.bOT & 512) == 0 || this.bPP == null || this.bPP == o.CI()) {
                        this.bPP = oVar;
                    } else {
                        this.bPP = o.b(this.bPP).d(oVar).Bo();
                    }
                    onChanged();
                } else {
                    this.bPn.b(oVar);
                }
                this.bOT |= 512;
                return this;
            }

            private bu<o, o.a, p> Bh() {
                if (this.bPn == null) {
                    this.bPn = new bu<>(Cv(), GA(), this.bWv);
                    this.bPP = null;
                }
                return this.bPn;
            }

            /* access modifiers changed from: private */
            /* renamed from: w */
            public a f(cc ccVar) {
                return (a) super.f(ccVar);
            }

            /* access modifiers changed from: private */
            /* renamed from: x */
            public a d(cc ccVar) {
                return (a) super.a(ccVar);
            }

            /* Return type fixed from 'com.google.a.ac$a' to match base method */
            @Override // com.google.a.ac.a
            public final /* bridge */ /* synthetic */ a Bl() {
                return (a) super.yG();
            }

            @Override // com.google.a.a.AbstractC0085a, com.google.a.ac.a
            public final /* synthetic */ a.AbstractC0085a yE() {
                return (a) super.yG();
            }

            @Override // com.google.a.ax
            public final /* synthetic */ aw AP() {
                return m.Cx();
            }

            @Override // com.google.a.az
            public final /* synthetic */ at AQ() {
                return m.Cx();
            }

            @Override // com.google.a.b.a, com.google.a.a.AbstractC0085a, com.google.a.ac.a
            public final /* synthetic */ b.a yG() {
                return (a) super.yG();
            }

            @Override // com.google.a.b.a, com.google.a.a.AbstractC0085a, java.lang.Object, com.google.a.ac.a
            public final /* synthetic */ Object clone() {
                return (a) super.yG();
            }
        }

        public static m Cx() {
            return bPQ;
        }

        @Override // com.google.a.aw, com.google.a.ac
        public final bj<m> AK() {
            return bPg;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.a.ac
        public final /* synthetic */ at.a a(ac.b bVar) {
            return new a(bVar, (byte) 0);
        }

        @Override // com.google.a.at
        public final /* synthetic */ at.a AM() {
            return bPQ.AN();
        }

        @Override // com.google.a.aw
        public final /* synthetic */ aw.a AO() {
            return bPQ.AN();
        }

        @Override // com.google.a.ax
        public final /* bridge */ /* synthetic */ aw AP() {
            return bPQ;
        }

        @Override // com.google.a.az
        public final /* bridge */ /* synthetic */ at AQ() {
            return bPQ;
        }
    }

    public static final class aa extends ac implements ab {
        @Deprecated
        public static final bj<aa> bPg = new c<aa>() {
            /* class com.google.a.k.aa.AnonymousClass1 */

            @Override // com.google.a.bj
            public final /* synthetic */ Object d(h hVar, r rVar) {
                return new aa(hVar, rVar, (byte) 0);
            }
        };
        private static final aa bRL = new aa();
        private int bOT;
        private volatile Object bOU;
        private byte bPe;
        private ac bRK;

        /* synthetic */ aa(ac.a aVar, byte b2) {
            this(aVar);
        }

        /* synthetic */ aa(h hVar, r rVar, byte b2) {
            this(hVar, rVar);
        }

        private aa(ac.a<?> aVar) {
            super(aVar);
            this.bPe = -1;
        }

        private aa() {
            this.bPe = -1;
            this.bOU = "";
        }

        @Override // com.google.a.az, com.google.a.ac
        public final cc Ax() {
            return this.bTW;
        }

        private aa(h hVar, r rVar) {
            this();
            ac.a aVar;
            boolean z;
            if (rVar == null) {
                throw new NullPointerException();
            }
            cc.a HJ = cc.HJ();
            boolean z2 = false;
            while (!z2) {
                try {
                    int yT = hVar.yT();
                    switch (yT) {
                        case 0:
                            z2 = true;
                            break;
                        case 10:
                            g zb = hVar.zb();
                            this.bOT |= 1;
                            this.bOU = zb;
                            break;
                        case 18:
                            if ((this.bOT & 2) != 0) {
                                aVar = this.bRK.AN();
                            } else {
                                aVar = null;
                            }
                            this.bRK = (ac) hVar.a(ac.bPg, rVar);
                            if (aVar != null) {
                                aVar.d(this.bRK);
                                this.bRK = aVar.Bo();
                            }
                            this.bOT |= 2;
                            break;
                        default:
                            if (!a(hVar, HJ, rVar, yT)) {
                                z = true;
                            } else {
                                z = z2;
                            }
                            z2 = z;
                            break;
                    }
                } catch (af e2) {
                    e2.bXr = this;
                    throw e2;
                } catch (IOException e3) {
                    af afVar = new af(e3);
                    afVar.bXr = this;
                    throw afVar;
                } catch (Throwable th) {
                    this.bTW = HJ.Bp();
                    Gw();
                    throw th;
                }
            }
            this.bTW = HJ.Bp();
            Gw();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.a.ac
        public final ac.f Ay() {
            return k.bOf.h(aa.class, a.class);
        }

        public final boolean Az() {
            return (this.bOT & 1) != 0;
        }

        public final String getName() {
            Object obj = this.bOU;
            if (obj instanceof String) {
                return (String) obj;
            }
            g gVar = (g) obj;
            String yO = gVar.yO();
            if (gVar.yP()) {
                this.bOU = yO;
            }
            return yO;
        }

        public final boolean AF() {
            return (this.bOT & 2) != 0;
        }

        public final ac Eo() {
            return this.bRK == null ? ac.Eu() : this.bRK;
        }

        @Override // com.google.a.a, com.google.a.ax, com.google.a.ac
        public final boolean isInitialized() {
            byte b2 = this.bPe;
            if (b2 == 1) {
                return true;
            }
            if (b2 == 0) {
                return false;
            }
            if (!AF() || Eo().isInitialized()) {
                this.bPe = 1;
                return true;
            }
            this.bPe = 0;
            return false;
        }

        @Override // com.google.a.aw, com.google.a.a, com.google.a.ac
        public final void a(i iVar) {
            if ((this.bOT & 1) != 0) {
                ac.a(iVar, 1, this.bOU);
            }
            if ((this.bOT & 2) != 0) {
                iVar.a(2, Eo());
            }
            this.bTW.a(iVar);
        }

        @Override // com.google.a.aw, com.google.a.a, com.google.a.ac
        public final int yC() {
            int i2 = this.bNa;
            if (i2 != -1) {
                return i2;
            }
            int i3 = 0;
            if ((this.bOT & 1) != 0) {
                i3 = ac.d(1, this.bOU) + 0;
            }
            if ((this.bOT & 2) != 0) {
                i3 += i.c(2, Eo());
            }
            int yC = i3 + this.bTW.yC();
            this.bNa = yC;
            return yC;
        }

        @Override // com.google.a.a
        public final boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof aa)) {
                return super.equals(obj);
            }
            aa aaVar = (aa) obj;
            if (Az() != aaVar.Az()) {
                return false;
            }
            if (Az() && !getName().equals(aaVar.getName())) {
                return false;
            }
            if (AF() != aaVar.AF()) {
                return false;
            }
            if (!AF() || Eo().equals(aaVar.Eo())) {
                return this.bTW.equals(aaVar.bTW);
            }
            return false;
        }

        @Override // com.google.a.a
        public final int hashCode() {
            if (this.bNb != 0) {
                return this.bNb;
            }
            int hashCode = k.bOe.hashCode() + com.tencent.mm.plugin.appbrand.jsapi.share.q.CTRL_INDEX;
            if (Az()) {
                hashCode = (((hashCode * 37) + 1) * 53) + getName().hashCode();
            }
            if (AF()) {
                hashCode = (((hashCode * 37) + 2) * 53) + Eo().hashCode();
            }
            int hashCode2 = (hashCode * 29) + this.bTW.hashCode();
            this.bNb = hashCode2;
            return hashCode2;
        }

        /* access modifiers changed from: private */
        /* renamed from: Ep */
        public a AN() {
            if (this == bRL) {
                return new a((byte) 0);
            }
            return new a((byte) 0).b(this);
        }

        public static final class a extends ac.a<a> implements ab {
            private int bOT;
            private Object bOU;
            private bu<ac, ac.a, ad> bPn;
            private ac bRK;

            /* synthetic */ a(byte b2) {
                this();
            }

            /* synthetic */ a(ac.b bVar, byte b2) {
                this(bVar);
            }

            /* access modifiers changed from: protected */
            @Override // com.google.a.ac.a
            public final ac.f Ay() {
                return k.bOf.h(aa.class, a.class);
            }

            private a() {
                this.bOU = "";
                AR();
            }

            private a(ac.b bVar) {
                super(bVar);
                this.bOU = "";
                AR();
            }

            private void AR() {
                if (ac.bVU) {
                    Bh();
                }
            }

            @Override // com.google.a.az, com.google.a.ac.a, com.google.a.at.a
            public final l.a AS() {
                return k.bOe;
            }

            /* access modifiers changed from: private */
            /* renamed from: Er */
            public aa Bp() {
                aa Es = Bo();
                if (Es.isInitialized()) {
                    return Es;
                }
                throw b((at) Es);
            }

            /* access modifiers changed from: private */
            /* renamed from: Es */
            public aa Bo() {
                int i2;
                aa aaVar = new aa(this, (byte) 0);
                int i3 = this.bOT;
                if ((i3 & 1) != 0) {
                    i2 = 1;
                } else {
                    i2 = 0;
                }
                aaVar.bOU = this.bOU;
                if ((i3 & 2) != 0) {
                    if (this.bPn == null) {
                        aaVar.bRK = this.bRK;
                    } else {
                        aaVar.bRK = this.bPn.Hv();
                    }
                    i2 |= 2;
                }
                aaVar.bOT = i2;
                Gy();
                return aaVar;
            }

            /* access modifiers changed from: private */
            /* renamed from: M */
            public a f(l.f fVar, Object obj) {
                return (a) super.f(fVar, obj);
            }

            /* access modifiers changed from: private */
            /* renamed from: N */
            public a e(l.f fVar, Object obj) {
                return (a) super.e(fVar, obj);
            }

            /* access modifiers changed from: private */
            /* renamed from: t */
            public a c(at atVar) {
                if (atVar instanceof aa) {
                    return b((aa) atVar);
                }
                super.c(atVar);
                return this;
            }

            public final a b(aa aaVar) {
                if (aaVar != aa.Eq()) {
                    if (aaVar.Az()) {
                        this.bOT |= 1;
                        this.bOU = aaVar.bOU;
                        onChanged();
                    }
                    if (aaVar.AF()) {
                        a(aaVar.Eo());
                    }
                    d(aaVar.bTW);
                    onChanged();
                }
                return this;
            }

            @Override // com.google.a.ax, com.google.a.ac.a
            public final boolean isInitialized() {
                boolean z;
                if ((this.bOT & 2) != 0) {
                    z = true;
                } else {
                    z = false;
                }
                return !z || Eo().isInitialized();
            }

            /* access modifiers changed from: private */
            /* JADX WARNING: Removed duplicated region for block: B:16:0x001e  */
            /* renamed from: u */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public com.google.a.k.aa.a c(com.google.a.h r4, com.google.a.r r5) {
                /*
                    r3 = this;
                    r2 = 0
                    com.google.a.bj<com.google.a.k$aa> r0 = com.google.a.k.aa.bPg     // Catch:{ af -> 0x000f }
                    java.lang.Object r0 = r0.d(r4, r5)     // Catch:{ af -> 0x000f }
                    com.google.a.k$aa r0 = (com.google.a.k.aa) r0     // Catch:{ af -> 0x000f }
                    if (r0 == 0) goto L_0x000e
                    r3.b(r0)
                L_0x000e:
                    return r3
                L_0x000f:
                    r0 = move-exception
                    r1 = r0
                    com.google.a.aw r0 = r1.bXr     // Catch:{ all -> 0x0022 }
                    com.google.a.k$aa r0 = (com.google.a.k.aa) r0     // Catch:{ all -> 0x0022 }
                    java.io.IOException r1 = r1.GF()     // Catch:{ all -> 0x001a }
                    throw r1     // Catch:{ all -> 0x001a }
                L_0x001a:
                    r1 = move-exception
                    r2 = r0
                L_0x001c:
                    if (r2 == 0) goto L_0x0021
                    r3.b(r2)
                L_0x0021:
                    throw r1
                L_0x0022:
                    r0 = move-exception
                    r1 = r0
                    goto L_0x001c
                */
                throw new UnsupportedOperationException("Method not decompiled: com.google.a.k.aa.a.c(com.google.a.h, com.google.a.r):com.google.a.k$aa$a");
            }

            private ac Eo() {
                if (this.bPn == null) {
                    return this.bRK == null ? ac.Eu() : this.bRK;
                }
                return this.bPn.Hu();
            }

            private a a(ac acVar) {
                if (this.bPn == null) {
                    if ((this.bOT & 2) == 0 || this.bRK == null || this.bRK == ac.Eu()) {
                        this.bRK = acVar;
                    } else {
                        this.bRK = ac.b(this.bRK).d(acVar).Bo();
                    }
                    onChanged();
                } else {
                    this.bPn.b(acVar);
                }
                this.bOT |= 2;
                return this;
            }

            private bu<ac, ac.a, ad> Bh() {
                if (this.bPn == null) {
                    this.bPn = new bu<>(Eo(), GA(), this.bWv);
                    this.bRK = null;
                }
                return this.bPn;
            }

            /* access modifiers changed from: private */
            /* renamed from: K */
            public a f(cc ccVar) {
                return (a) super.f(ccVar);
            }

            /* access modifiers changed from: private */
            /* renamed from: L */
            public a d(cc ccVar) {
                return (a) super.a(ccVar);
            }

            /* Return type fixed from 'com.google.a.ac$a' to match base method */
            @Override // com.google.a.ac.a
            public final /* bridge */ /* synthetic */ a Bl() {
                return (a) super.yG();
            }

            @Override // com.google.a.a.AbstractC0085a, com.google.a.ac.a
            public final /* synthetic */ a.AbstractC0085a yE() {
                return (a) super.yG();
            }

            @Override // com.google.a.ax
            public final /* synthetic */ aw AP() {
                return aa.Eq();
            }

            @Override // com.google.a.az
            public final /* synthetic */ at AQ() {
                return aa.Eq();
            }

            @Override // com.google.a.b.a, com.google.a.a.AbstractC0085a, com.google.a.ac.a
            public final /* synthetic */ b.a yG() {
                return (a) super.yG();
            }

            @Override // com.google.a.b.a, com.google.a.a.AbstractC0085a, java.lang.Object, com.google.a.ac.a
            public final /* synthetic */ Object clone() {
                return (a) super.yG();
            }
        }

        public static aa Eq() {
            return bRL;
        }

        @Override // com.google.a.aw, com.google.a.ac
        public final bj<aa> AK() {
            return bPg;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.a.ac
        public final /* synthetic */ at.a a(ac.b bVar) {
            return new a(bVar, (byte) 0);
        }

        @Override // com.google.a.at
        public final /* synthetic */ at.a AM() {
            return bRL.AN();
        }

        @Override // com.google.a.aw
        public final /* synthetic */ aw.a AO() {
            return bRL.AN();
        }

        @Override // com.google.a.ax
        public final /* bridge */ /* synthetic */ aw AP() {
            return bRL;
        }

        @Override // com.google.a.az
        public final /* bridge */ /* synthetic */ at AQ() {
            return bRL;
        }
    }

    public static final class c extends ac implements d {
        @Deprecated
        public static final bj<c> bPg = new c<c>() {
            /* class com.google.a.k.c.AnonymousClass1 */

            @Override // com.google.a.bj
            public final /* synthetic */ Object d(h hVar, r rVar) {
                return new c(hVar, rVar, (byte) 0);
            }
        };
        private static final c bPw = new c();
        private int bOT;
        private volatile Object bOU;
        private List<b> bPc;
        private ak bPd;
        private byte bPe;
        private List<g> bPu;
        private e bPv;

        /* renamed from: com.google.a.k$c$c  reason: collision with other inner class name */
        public interface AbstractC0095c extends az {
        }

        /* synthetic */ c(ac.a aVar, byte b2) {
            this(aVar);
        }

        /* synthetic */ c(h hVar, r rVar, byte b2) {
            this(hVar, rVar);
        }

        private c(ac.a<?> aVar) {
            super(aVar);
            this.bPe = -1;
        }

        private c() {
            this.bPe = -1;
            this.bOU = "";
            this.bPu = Collections.emptyList();
            this.bPc = Collections.emptyList();
            this.bPd = aj.bXM;
        }

        @Override // com.google.a.az, com.google.a.ac
        public final cc Ax() {
            return this.bTW;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v19, resolved type: java.util.List<com.google.a.k$c$b> */
        /* JADX DEBUG: Multi-variable search result rejected for r0v32, resolved type: java.util.List<com.google.a.k$g> */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARNING: Removed duplicated region for block: B:24:0x003f  */
        /* JADX WARNING: Removed duplicated region for block: B:27:0x004b  */
        /* JADX WARNING: Removed duplicated region for block: B:30:0x0057  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private c(com.google.a.h r7, com.google.a.r r8) {
            /*
            // Method dump skipped, instructions count: 314
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.a.k.c.<init>(com.google.a.h, com.google.a.r):void");
        }

        /* access modifiers changed from: protected */
        @Override // com.google.a.ac
        public final ac.f Ay() {
            return k.bOh.h(c.class, a.class);
        }

        public static final class b extends ac implements AbstractC0095c {
            @Deprecated
            public static final bj<b> bPg = new c<b>() {
                /* class com.google.a.k.c.b.AnonymousClass1 */

                @Override // com.google.a.bj
                public final /* synthetic */ Object d(h hVar, r rVar) {
                    return new b(hVar, rVar, (byte) 0);
                }
            };
            private static final b bPy = new b();
            private int bOT;
            private byte bPe;
            int bPp;
            int bPq;

            /* synthetic */ b(ac.a aVar, byte b2) {
                this(aVar);
            }

            /* synthetic */ b(h hVar, r rVar, byte b2) {
                this(hVar, rVar);
            }

            private b(ac.a<?> aVar) {
                super(aVar);
                this.bPe = -1;
            }

            private b() {
                this.bPe = -1;
            }

            @Override // com.google.a.az, com.google.a.ac
            public final cc Ax() {
                return this.bTW;
            }

            private b(h hVar, r rVar) {
                this();
                if (rVar == null) {
                    throw new NullPointerException();
                }
                cc.a HJ = cc.HJ();
                boolean z = false;
                while (!z) {
                    try {
                        int yT = hVar.yT();
                        switch (yT) {
                            case 0:
                                z = true;
                                break;
                            case 8:
                                this.bOT |= 1;
                                this.bPp = hVar.yW();
                                break;
                            case 16:
                                this.bOT |= 2;
                                this.bPq = hVar.yW();
                                break;
                            default:
                                if (a(hVar, HJ, rVar, yT)) {
                                    break;
                                } else {
                                    z = true;
                                    break;
                                }
                        }
                    } catch (af e2) {
                        e2.bXr = this;
                        throw e2;
                    } catch (IOException e3) {
                        af afVar = new af(e3);
                        afVar.bXr = this;
                        throw afVar;
                    } catch (Throwable th) {
                        this.bTW = HJ.Bp();
                        Gw();
                        throw th;
                    }
                }
                this.bTW = HJ.Bp();
                Gw();
            }

            /* access modifiers changed from: protected */
            @Override // com.google.a.ac
            public final ac.f Ay() {
                return k.bOj.h(b.class, a.class);
            }

            public final boolean Bq() {
                return (this.bOT & 1) != 0;
            }

            public final boolean hasEnd() {
                return (this.bOT & 2) != 0;
            }

            @Override // com.google.a.a, com.google.a.ax, com.google.a.ac
            public final boolean isInitialized() {
                byte b2 = this.bPe;
                if (b2 == 1) {
                    return true;
                }
                if (b2 == 0) {
                    return false;
                }
                this.bPe = 1;
                return true;
            }

            @Override // com.google.a.aw, com.google.a.a, com.google.a.ac
            public final void a(i iVar) {
                if ((this.bOT & 1) != 0) {
                    iVar.bs(1, this.bPp);
                }
                if ((this.bOT & 2) != 0) {
                    iVar.bs(2, this.bPq);
                }
                this.bTW.a(iVar);
            }

            @Override // com.google.a.aw, com.google.a.a, com.google.a.ac
            public final int yC() {
                int i2 = this.bNa;
                if (i2 != -1) {
                    return i2;
                }
                int i3 = 0;
                if ((this.bOT & 1) != 0) {
                    i3 = i.bu(1, this.bPp) + 0;
                }
                if ((this.bOT & 2) != 0) {
                    i3 += i.bu(2, this.bPq);
                }
                int yC = i3 + this.bTW.yC();
                this.bNa = yC;
                return yC;
            }

            @Override // com.google.a.a
            public final boolean equals(Object obj) {
                if (obj == this) {
                    return true;
                }
                if (!(obj instanceof b)) {
                    return super.equals(obj);
                }
                b bVar = (b) obj;
                if (Bq() != bVar.Bq()) {
                    return false;
                }
                if (Bq() && this.bPp != bVar.bPp) {
                    return false;
                }
                if (hasEnd() != bVar.hasEnd()) {
                    return false;
                }
                if (!hasEnd() || this.bPq == bVar.bPq) {
                    return this.bTW.equals(bVar.bTW);
                }
                return false;
            }

            @Override // com.google.a.a
            public final int hashCode() {
                if (this.bNb != 0) {
                    return this.bNb;
                }
                int hashCode = k.bOi.hashCode() + com.tencent.mm.plugin.appbrand.jsapi.share.q.CTRL_INDEX;
                if (Bq()) {
                    hashCode = (((hashCode * 37) + 1) * 53) + this.bPp;
                }
                if (hasEnd()) {
                    hashCode = (((hashCode * 37) + 2) * 53) + this.bPq;
                }
                int hashCode2 = (hashCode * 29) + this.bTW.hashCode();
                this.bNb = hashCode2;
                return hashCode2;
            }

            /* access modifiers changed from: private */
            /* renamed from: BI */
            public a AN() {
                if (this == bPy) {
                    return new a((byte) 0);
                }
                return new a((byte) 0).a(this);
            }

            public static final class a extends ac.a<a> implements AbstractC0095c {
                private int bOT;
                private int bPp;
                private int bPq;

                /* synthetic */ a(byte b2) {
                    this();
                }

                /* synthetic */ a(ac.b bVar, byte b2) {
                    this(bVar);
                }

                /* access modifiers changed from: protected */
                @Override // com.google.a.ac.a
                public final ac.f Ay() {
                    return k.bOj.h(b.class, a.class);
                }

                private a() {
                    boolean z = ac.bVU;
                }

                private a(ac.b bVar) {
                    super(bVar);
                    boolean z = ac.bVU;
                }

                @Override // com.google.a.az, com.google.a.ac.a, com.google.a.at.a
                public final l.a AS() {
                    return k.bOi;
                }

                /* access modifiers changed from: private */
                /* renamed from: BK */
                public b Bp() {
                    b BL = Bo();
                    if (BL.isInitialized()) {
                        return BL;
                    }
                    throw b(BL);
                }

                /* access modifiers changed from: private */
                /* renamed from: BL */
                public b Bo() {
                    int i2 = 0;
                    b bVar = new b(this, (byte) 0);
                    int i3 = this.bOT;
                    if ((i3 & 1) != 0) {
                        bVar.bPp = this.bPp;
                        i2 = 1;
                    }
                    if ((i3 & 2) != 0) {
                        bVar.bPq = this.bPq;
                        i2 |= 2;
                    }
                    bVar.bOT = i2;
                    Gy();
                    return bVar;
                }

                /* access modifiers changed from: private */
                /* renamed from: m */
                public a f(l.f fVar, Object obj) {
                    return (a) super.f(fVar, obj);
                }

                /* access modifiers changed from: private */
                /* renamed from: n */
                public a e(l.f fVar, Object obj) {
                    return (a) super.e(fVar, obj);
                }

                /* access modifiers changed from: private */
                /* renamed from: h */
                public a c(at atVar) {
                    if (atVar instanceof b) {
                        return a((b) atVar);
                    }
                    super.c(atVar);
                    return this;
                }

                public final a a(b bVar) {
                    if (bVar != b.BJ()) {
                        if (bVar.Bq()) {
                            gk(bVar.bPp);
                        }
                        if (bVar.hasEnd()) {
                            gl(bVar.bPq);
                        }
                        d(bVar.bTW);
                        onChanged();
                    }
                    return this;
                }

                @Override // com.google.a.ax, com.google.a.ac.a
                public final boolean isInitialized() {
                    return true;
                }

                /* access modifiers changed from: private */
                /* JADX WARNING: Removed duplicated region for block: B:16:0x001e  */
                /* renamed from: i */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public com.google.a.k.c.b.a c(com.google.a.h r4, com.google.a.r r5) {
                    /*
                        r3 = this;
                        r2 = 0
                        com.google.a.bj<com.google.a.k$c$b> r0 = com.google.a.k.c.b.bPg     // Catch:{ af -> 0x000f }
                        java.lang.Object r0 = r0.d(r4, r5)     // Catch:{ af -> 0x000f }
                        com.google.a.k$c$b r0 = (com.google.a.k.c.b) r0     // Catch:{ af -> 0x000f }
                        if (r0 == 0) goto L_0x000e
                        r3.a(r0)
                    L_0x000e:
                        return r3
                    L_0x000f:
                        r0 = move-exception
                        r1 = r0
                        com.google.a.aw r0 = r1.bXr     // Catch:{ all -> 0x0022 }
                        com.google.a.k$c$b r0 = (com.google.a.k.c.b) r0     // Catch:{ all -> 0x0022 }
                        java.io.IOException r1 = r1.GF()     // Catch:{ all -> 0x001a }
                        throw r1     // Catch:{ all -> 0x001a }
                    L_0x001a:
                        r1 = move-exception
                        r2 = r0
                    L_0x001c:
                        if (r2 == 0) goto L_0x0021
                        r3.a(r2)
                    L_0x0021:
                        throw r1
                    L_0x0022:
                        r0 = move-exception
                        r1 = r0
                        goto L_0x001c
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.google.a.k.c.b.a.c(com.google.a.h, com.google.a.r):com.google.a.k$c$b$a");
                }

                private a gk(int i2) {
                    this.bOT |= 1;
                    this.bPp = i2;
                    onChanged();
                    return this;
                }

                private a gl(int i2) {
                    this.bOT |= 2;
                    this.bPq = i2;
                    onChanged();
                    return this;
                }

                /* access modifiers changed from: private */
                /* renamed from: m */
                public a f(cc ccVar) {
                    return (a) super.f(ccVar);
                }

                /* access modifiers changed from: private */
                /* renamed from: n */
                public a d(cc ccVar) {
                    return (a) super.a(ccVar);
                }

                /* Return type fixed from 'com.google.a.ac$a' to match base method */
                @Override // com.google.a.ac.a
                public final /* bridge */ /* synthetic */ a Bl() {
                    return (a) super.yG();
                }

                @Override // com.google.a.a.AbstractC0085a, com.google.a.ac.a
                public final /* synthetic */ a.AbstractC0085a yE() {
                    return (a) super.yG();
                }

                @Override // com.google.a.ax
                public final /* synthetic */ aw AP() {
                    return b.BJ();
                }

                @Override // com.google.a.az
                public final /* synthetic */ at AQ() {
                    return b.BJ();
                }

                @Override // com.google.a.b.a, com.google.a.a.AbstractC0085a, com.google.a.ac.a
                public final /* synthetic */ b.a yG() {
                    return (a) super.yG();
                }

                @Override // com.google.a.b.a, com.google.a.a.AbstractC0085a, java.lang.Object, com.google.a.ac.a
                public final /* synthetic */ Object clone() {
                    return (a) super.yG();
                }
            }

            public static b BJ() {
                return bPy;
            }

            @Override // com.google.a.aw, com.google.a.ac
            public final bj<b> AK() {
                return bPg;
            }

            /* access modifiers changed from: protected */
            @Override // com.google.a.ac
            public final /* synthetic */ at.a a(ac.b bVar) {
                return new a(bVar, (byte) 0);
            }

            @Override // com.google.a.at
            public final /* synthetic */ at.a AM() {
                return bPy.AN();
            }

            @Override // com.google.a.aw
            public final /* synthetic */ aw.a AO() {
                return bPy.AN();
            }

            @Override // com.google.a.ax
            public final /* bridge */ /* synthetic */ aw AP() {
                return bPy;
            }

            @Override // com.google.a.az
            public final /* bridge */ /* synthetic */ at AQ() {
                return bPy;
            }
        }

        public final boolean Az() {
            return (this.bOT & 1) != 0;
        }

        public final String getName() {
            Object obj = this.bOU;
            if (obj instanceof String) {
                return (String) obj;
            }
            g gVar = (g) obj;
            String yO = gVar.yO();
            if (gVar.yP()) {
                this.bOU = yO;
            }
            return yO;
        }

        public final int getValueCount() {
            return this.bPu.size();
        }

        public final g gj(int i2) {
            return this.bPu.get(i2);
        }

        public final boolean AF() {
            return (this.bOT & 2) != 0;
        }

        public final e BB() {
            return this.bPv == null ? e.BQ() : this.bPv;
        }

        @Override // com.google.a.a, com.google.a.ax, com.google.a.ac
        public final boolean isInitialized() {
            byte b2 = this.bPe;
            if (b2 == 1) {
                return true;
            }
            if (b2 == 0) {
                return false;
            }
            for (int i2 = 0; i2 < getValueCount(); i2++) {
                if (!gj(i2).isInitialized()) {
                    this.bPe = 0;
                    return false;
                }
            }
            if (!AF() || BB().isInitialized()) {
                this.bPe = 1;
                return true;
            }
            this.bPe = 0;
            return false;
        }

        @Override // com.google.a.aw, com.google.a.a, com.google.a.ac
        public final void a(i iVar) {
            if ((this.bOT & 1) != 0) {
                ac.a(iVar, 1, this.bOU);
            }
            for (int i2 = 0; i2 < this.bPu.size(); i2++) {
                iVar.a(2, this.bPu.get(i2));
            }
            if ((this.bOT & 2) != 0) {
                iVar.a(3, BB());
            }
            for (int i3 = 0; i3 < this.bPc.size(); i3++) {
                iVar.a(4, this.bPc.get(i3));
            }
            for (int i4 = 0; i4 < this.bPd.size(); i4++) {
                ac.a(iVar, 5, this.bPd.getRaw(i4));
            }
            this.bTW.a(iVar);
        }

        @Override // com.google.a.aw, com.google.a.a, com.google.a.ac
        public final int yC() {
            int i2 = this.bNa;
            if (i2 != -1) {
                return i2;
            }
            int d2 = (this.bOT & 1) != 0 ? ac.d(1, this.bOU) + 0 : 0;
            for (int i3 = 0; i3 < this.bPu.size(); i3++) {
                d2 += i.c(2, this.bPu.get(i3));
            }
            if ((this.bOT & 2) != 0) {
                d2 += i.c(3, BB());
            }
            for (int i4 = 0; i4 < this.bPc.size(); i4++) {
                d2 += i.c(4, this.bPc.get(i4));
            }
            int i5 = 0;
            for (int i6 = 0; i6 < this.bPd.size(); i6++) {
                i5 += ar(this.bPd.getRaw(i6));
            }
            int size = d2 + i5 + (this.bPd.size() * 1) + this.bTW.yC();
            this.bNa = size;
            return size;
        }

        @Override // com.google.a.a
        public final boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof c)) {
                return super.equals(obj);
            }
            c cVar = (c) obj;
            if (Az() != cVar.Az()) {
                return false;
            }
            if (Az() && !getName().equals(cVar.getName())) {
                return false;
            }
            if (!this.bPu.equals(cVar.bPu)) {
                return false;
            }
            if (AF() != cVar.AF()) {
                return false;
            }
            if (AF() && !BB().equals(cVar.BB())) {
                return false;
            }
            if (!this.bPc.equals(cVar.bPc)) {
                return false;
            }
            if (!this.bPd.equals(cVar.bPd)) {
                return false;
            }
            return this.bTW.equals(cVar.bTW);
        }

        @Override // com.google.a.a
        public final int hashCode() {
            if (this.bNb != 0) {
                return this.bNb;
            }
            int hashCode = k.bOg.hashCode() + com.tencent.mm.plugin.appbrand.jsapi.share.q.CTRL_INDEX;
            if (Az()) {
                hashCode = (((hashCode * 37) + 1) * 53) + getName().hashCode();
            }
            if (getValueCount() > 0) {
                hashCode = (((hashCode * 37) + 2) * 53) + this.bPu.hashCode();
            }
            if (AF()) {
                hashCode = (((hashCode * 37) + 3) * 53) + BB().hashCode();
            }
            if (this.bPc.size() > 0) {
                hashCode = (((hashCode * 37) + 4) * 53) + this.bPc.hashCode();
            }
            if (this.bPd.size() > 0) {
                hashCode = (((hashCode * 37) + 5) * 53) + this.bPd.hashCode();
            }
            int hashCode2 = (hashCode * 29) + this.bTW.hashCode();
            this.bNb = hashCode2;
            return hashCode2;
        }

        /* access modifiers changed from: private */
        /* renamed from: BC */
        public a AN() {
            if (this == bPw) {
                return new a((byte) 0);
            }
            return new a((byte) 0).e(this);
        }

        public static final class a extends ac.a<a> implements d {
            private int bOT;
            private Object bOU;
            private List<b> bPc;
            private ak bPd;
            private bu<e, e.a, f> bPn;
            private bq<b, b.a, AbstractC0095c> bPo;
            private List<g> bPu;
            private e bPv;
            private bq<g, g.a, h> bPx;

            /* synthetic */ a(byte b2) {
                this();
            }

            /* synthetic */ a(ac.b bVar, byte b2) {
                this(bVar);
            }

            /* access modifiers changed from: protected */
            @Override // com.google.a.ac.a
            public final ac.f Ay() {
                return k.bOh.h(c.class, a.class);
            }

            private a() {
                this.bOU = "";
                this.bPu = Collections.emptyList();
                this.bPc = Collections.emptyList();
                this.bPd = aj.bXM;
                AR();
            }

            private a(ac.b bVar) {
                super(bVar);
                this.bOU = "";
                this.bPu = Collections.emptyList();
                this.bPc = Collections.emptyList();
                this.bPd = aj.bXM;
                AR();
            }

            private void AR() {
                if (ac.bVU) {
                    BH();
                    Bh();
                    Bj();
                }
            }

            @Override // com.google.a.az, com.google.a.ac.a, com.google.a.at.a
            public final l.a AS() {
                return k.bOg;
            }

            /* access modifiers changed from: private */
            /* renamed from: BE */
            public c Bp() {
                c BF = Bo();
                if (BF.isInitialized()) {
                    return BF;
                }
                throw b(BF);
            }

            /* access modifiers changed from: private */
            /* renamed from: BF */
            public c Bo() {
                int i2;
                c cVar = new c(this, (byte) 0);
                int i3 = this.bOT;
                if ((i3 & 1) != 0) {
                    i2 = 1;
                } else {
                    i2 = 0;
                }
                cVar.bOU = this.bOU;
                if (this.bPx == null) {
                    if ((this.bOT & 2) != 0) {
                        this.bPu = Collections.unmodifiableList(this.bPu);
                        this.bOT &= -3;
                    }
                    cVar.bPu = this.bPu;
                } else {
                    cVar.bPu = this.bPx.build();
                }
                if ((i3 & 4) != 0) {
                    if (this.bPn == null) {
                        cVar.bPv = this.bPv;
                    } else {
                        cVar.bPv = this.bPn.Hv();
                    }
                    i2 |= 2;
                }
                if (this.bPo == null) {
                    if ((this.bOT & 8) != 0) {
                        this.bPc = Collections.unmodifiableList(this.bPc);
                        this.bOT &= -9;
                    }
                    cVar.bPc = this.bPc;
                } else {
                    cVar.bPc = this.bPo.build();
                }
                if ((this.bOT & 16) != 0) {
                    this.bPd = this.bPd.GR();
                    this.bOT &= -17;
                }
                cVar.bPd = this.bPd;
                cVar.bOT = i2;
                Gy();
                return cVar;
            }

            /* access modifiers changed from: private */
            /* renamed from: k */
            public a f(l.f fVar, Object obj) {
                return (a) super.f(fVar, obj);
            }

            /* access modifiers changed from: private */
            /* renamed from: l */
            public a e(l.f fVar, Object obj) {
                return (a) super.e(fVar, obj);
            }

            /* access modifiers changed from: private */
            /* renamed from: g */
            public a c(at atVar) {
                if (atVar instanceof c) {
                    return e((c) atVar);
                }
                super.c(atVar);
                return this;
            }

            public final a e(c cVar) {
                bq<b, b.a, AbstractC0095c> bqVar = null;
                if (cVar != c.BD()) {
                    if (cVar.Az()) {
                        this.bOT |= 1;
                        this.bOU = cVar.bOU;
                        onChanged();
                    }
                    if (this.bPx == null) {
                        if (!cVar.bPu.isEmpty()) {
                            if (this.bPu.isEmpty()) {
                                this.bPu = cVar.bPu;
                                this.bOT &= -3;
                            } else {
                                BG();
                                this.bPu.addAll(cVar.bPu);
                            }
                            onChanged();
                        }
                    } else if (!cVar.bPu.isEmpty()) {
                        if (this.bPx.isEmpty()) {
                            this.bPx.bYP = null;
                            this.bPx = null;
                            this.bPu = cVar.bPu;
                            this.bOT &= -3;
                            this.bPx = ac.bVU ? BH() : null;
                        } else {
                            this.bPx.a(cVar.bPu);
                        }
                    }
                    if (cVar.AF()) {
                        a(cVar.BB());
                    }
                    if (this.bPo == null) {
                        if (!cVar.bPc.isEmpty()) {
                            if (this.bPc.isEmpty()) {
                                this.bPc = cVar.bPc;
                                this.bOT &= -9;
                            } else {
                                Bi();
                                this.bPc.addAll(cVar.bPc);
                            }
                            onChanged();
                        }
                    } else if (!cVar.bPc.isEmpty()) {
                        if (this.bPo.isEmpty()) {
                            this.bPo.bYP = null;
                            this.bPo = null;
                            this.bPc = cVar.bPc;
                            this.bOT &= -9;
                            if (ac.bVU) {
                                bqVar = Bj();
                            }
                            this.bPo = bqVar;
                        } else {
                            this.bPo.a(cVar.bPc);
                        }
                    }
                    if (!cVar.bPd.isEmpty()) {
                        if (this.bPd.isEmpty()) {
                            this.bPd = cVar.bPd;
                            this.bOT &= -17;
                        } else {
                            Bk();
                            this.bPd.addAll(cVar.bPd);
                        }
                        onChanged();
                    }
                    d(cVar.bTW);
                    onChanged();
                }
                return this;
            }

            @Override // com.google.a.ax, com.google.a.ac.a
            public final boolean isInitialized() {
                int count;
                boolean z;
                g s;
                int i2 = 0;
                while (true) {
                    if (this.bPx == null) {
                        count = this.bPu.size();
                    } else {
                        count = this.bPx.getCount();
                    }
                    if (i2 < count) {
                        if (this.bPx == null) {
                            s = this.bPu.get(i2);
                        } else {
                            s = this.bPx.s(i2, false);
                        }
                        if (!s.isInitialized()) {
                            return false;
                        }
                        i2++;
                    } else {
                        if ((this.bOT & 4) != 0) {
                            z = true;
                        } else {
                            z = false;
                        }
                        return !z || BB().isInitialized();
                    }
                }
            }

            /* access modifiers changed from: private */
            /* JADX WARNING: Removed duplicated region for block: B:16:0x001e  */
            /* renamed from: h */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public com.google.a.k.c.a c(com.google.a.h r4, com.google.a.r r5) {
                /*
                    r3 = this;
                    r2 = 0
                    com.google.a.bj<com.google.a.k$c> r0 = com.google.a.k.c.bPg     // Catch:{ af -> 0x000f }
                    java.lang.Object r0 = r0.d(r4, r5)     // Catch:{ af -> 0x000f }
                    com.google.a.k$c r0 = (com.google.a.k.c) r0     // Catch:{ af -> 0x000f }
                    if (r0 == 0) goto L_0x000e
                    r3.e(r0)
                L_0x000e:
                    return r3
                L_0x000f:
                    r0 = move-exception
                    r1 = r0
                    com.google.a.aw r0 = r1.bXr     // Catch:{ all -> 0x0022 }
                    com.google.a.k$c r0 = (com.google.a.k.c) r0     // Catch:{ all -> 0x0022 }
                    java.io.IOException r1 = r1.GF()     // Catch:{ all -> 0x001a }
                    throw r1     // Catch:{ all -> 0x001a }
                L_0x001a:
                    r1 = move-exception
                    r2 = r0
                L_0x001c:
                    if (r2 == 0) goto L_0x0021
                    r3.e(r2)
                L_0x0021:
                    throw r1
                L_0x0022:
                    r0 = move-exception
                    r1 = r0
                    goto L_0x001c
                */
                throw new UnsupportedOperationException("Method not decompiled: com.google.a.k.c.a.c(com.google.a.h, com.google.a.r):com.google.a.k$c$a");
            }

            private void BG() {
                if ((this.bOT & 2) == 0) {
                    this.bPu = new ArrayList(this.bPu);
                    this.bOT |= 2;
                }
            }

            private bq<g, g.a, h> BH() {
                if (this.bPx == null) {
                    this.bPx = new bq<>(this.bPu, (this.bOT & 2) != 0, GA(), this.bWv);
                    this.bPu = null;
                }
                return this.bPx;
            }

            private e BB() {
                if (this.bPn == null) {
                    return this.bPv == null ? e.BQ() : this.bPv;
                }
                return this.bPn.Hu();
            }

            private a a(e eVar) {
                if (this.bPn == null) {
                    if ((this.bOT & 4) == 0 || this.bPv == null || this.bPv == e.BQ()) {
                        this.bPv = eVar;
                    } else {
                        this.bPv = e.b(this.bPv).d(eVar).Bo();
                    }
                    onChanged();
                } else {
                    this.bPn.b(eVar);
                }
                this.bOT |= 4;
                return this;
            }

            private bu<e, e.a, f> Bh() {
                if (this.bPn == null) {
                    this.bPn = new bu<>(BB(), GA(), this.bWv);
                    this.bPv = null;
                }
                return this.bPn;
            }

            private void Bi() {
                if ((this.bOT & 8) == 0) {
                    this.bPc = new ArrayList(this.bPc);
                    this.bOT |= 8;
                }
            }

            private bq<b, b.a, AbstractC0095c> Bj() {
                if (this.bPo == null) {
                    this.bPo = new bq<>(this.bPc, (this.bOT & 8) != 0, GA(), this.bWv);
                    this.bPc = null;
                }
                return this.bPo;
            }

            private void Bk() {
                if ((this.bOT & 16) == 0) {
                    this.bPd = new aj(this.bPd);
                    this.bOT |= 16;
                }
            }

            /* access modifiers changed from: private */
            /* renamed from: k */
            public a f(cc ccVar) {
                return (a) super.f(ccVar);
            }

            /* access modifiers changed from: private */
            /* renamed from: l */
            public a d(cc ccVar) {
                return (a) super.a(ccVar);
            }

            /* Return type fixed from 'com.google.a.ac$a' to match base method */
            @Override // com.google.a.ac.a
            public final /* bridge */ /* synthetic */ a Bl() {
                return (a) super.yG();
            }

            @Override // com.google.a.a.AbstractC0085a, com.google.a.ac.a
            public final /* synthetic */ a.AbstractC0085a yE() {
                return (a) super.yG();
            }

            @Override // com.google.a.ax
            public final /* synthetic */ aw AP() {
                return c.BD();
            }

            @Override // com.google.a.az
            public final /* synthetic */ at AQ() {
                return c.BD();
            }

            @Override // com.google.a.b.a, com.google.a.a.AbstractC0085a, com.google.a.ac.a
            public final /* synthetic */ b.a yG() {
                return (a) super.yG();
            }

            @Override // com.google.a.b.a, com.google.a.a.AbstractC0085a, java.lang.Object, com.google.a.ac.a
            public final /* synthetic */ Object clone() {
                return (a) super.yG();
            }
        }

        public static c BD() {
            return bPw;
        }

        @Override // com.google.a.aw, com.google.a.ac
        public final bj<c> AK() {
            return bPg;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.a.ac
        public final /* synthetic */ at.a a(ac.b bVar) {
            return new a(bVar, (byte) 0);
        }

        @Override // com.google.a.at
        public final /* synthetic */ at.a AM() {
            return bPw.AN();
        }

        @Override // com.google.a.aw
        public final /* synthetic */ aw.a AO() {
            return bPw.AN();
        }

        @Override // com.google.a.ax
        public final /* bridge */ /* synthetic */ aw AP() {
            return bPw;
        }

        @Override // com.google.a.az
        public final /* bridge */ /* synthetic */ at AQ() {
            return bPw;
        }
    }

    public static final class g extends ac implements h {
        private static final g bPG = new g();
        @Deprecated
        public static final bj<g> bPg = new c<g>() {
            /* class com.google.a.k.g.AnonymousClass1 */

            @Override // com.google.a.bj
            public final /* synthetic */ Object d(h hVar, r rVar) {
                return new g(hVar, rVar, (byte) 0);
            }
        };
        private int bOT;
        private volatile Object bOU;
        int bPE;
        private i bPF;
        private byte bPe;

        /* synthetic */ g(ac.a aVar, byte b2) {
            this(aVar);
        }

        /* synthetic */ g(h hVar, r rVar, byte b2) {
            this(hVar, rVar);
        }

        private g(ac.a<?> aVar) {
            super(aVar);
            this.bPe = -1;
        }

        private g() {
            this.bPe = -1;
            this.bOU = "";
        }

        @Override // com.google.a.az, com.google.a.ac
        public final cc Ax() {
            return this.bTW;
        }

        private g(h hVar, r rVar) {
            this();
            i.a aVar;
            boolean z;
            if (rVar == null) {
                throw new NullPointerException();
            }
            cc.a HJ = cc.HJ();
            boolean z2 = false;
            while (!z2) {
                try {
                    int yT = hVar.yT();
                    switch (yT) {
                        case 0:
                            z2 = true;
                            break;
                        case 10:
                            g zb = hVar.zb();
                            this.bOT |= 1;
                            this.bOU = zb;
                            break;
                        case 16:
                            this.bOT |= 2;
                            this.bPE = hVar.yW();
                            break;
                        case 26:
                            if ((this.bOT & 4) != 0) {
                                aVar = this.bPF.AN();
                            } else {
                                aVar = null;
                            }
                            this.bPF = (i) hVar.a(i.bPg, rVar);
                            if (aVar != null) {
                                aVar.d(this.bPF);
                                this.bPF = aVar.Bo();
                            }
                            this.bOT |= 4;
                            break;
                        default:
                            if (!a(hVar, HJ, rVar, yT)) {
                                z = true;
                            } else {
                                z = z2;
                            }
                            z2 = z;
                            break;
                    }
                } catch (af e2) {
                    e2.bXr = this;
                    throw e2;
                } catch (IOException e3) {
                    af afVar = new af(e3);
                    afVar.bXr = this;
                    throw afVar;
                } catch (Throwable th) {
                    this.bTW = HJ.Bp();
                    Gw();
                    throw th;
                }
            }
            this.bTW = HJ.Bp();
            Gw();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.a.ac
        public final ac.f Ay() {
            return k.bOl.h(g.class, a.class);
        }

        public final boolean Az() {
            return (this.bOT & 1) != 0;
        }

        public final String getName() {
            Object obj = this.bOU;
            if (obj instanceof String) {
                return (String) obj;
            }
            g gVar = (g) obj;
            String yO = gVar.yO();
            if (gVar.yP()) {
                this.bOU = yO;
            }
            return yO;
        }

        public final boolean BV() {
            return (this.bOT & 2) != 0;
        }

        public final boolean AF() {
            return (this.bOT & 4) != 0;
        }

        public final i BW() {
            return this.bPF == null ? i.Cd() : this.bPF;
        }

        @Override // com.google.a.a, com.google.a.ax, com.google.a.ac
        public final boolean isInitialized() {
            byte b2 = this.bPe;
            if (b2 == 1) {
                return true;
            }
            if (b2 == 0) {
                return false;
            }
            if (!AF() || BW().isInitialized()) {
                this.bPe = 1;
                return true;
            }
            this.bPe = 0;
            return false;
        }

        @Override // com.google.a.aw, com.google.a.a, com.google.a.ac
        public final void a(i iVar) {
            if ((this.bOT & 1) != 0) {
                ac.a(iVar, 1, this.bOU);
            }
            if ((this.bOT & 2) != 0) {
                iVar.bs(2, this.bPE);
            }
            if ((this.bOT & 4) != 0) {
                iVar.a(3, BW());
            }
            this.bTW.a(iVar);
        }

        @Override // com.google.a.aw, com.google.a.a, com.google.a.ac
        public final int yC() {
            int i2 = this.bNa;
            if (i2 != -1) {
                return i2;
            }
            int i3 = 0;
            if ((this.bOT & 1) != 0) {
                i3 = ac.d(1, this.bOU) + 0;
            }
            if ((this.bOT & 2) != 0) {
                i3 += i.bu(2, this.bPE);
            }
            if ((this.bOT & 4) != 0) {
                i3 += i.c(3, BW());
            }
            int yC = i3 + this.bTW.yC();
            this.bNa = yC;
            return yC;
        }

        @Override // com.google.a.a
        public final boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof g)) {
                return super.equals(obj);
            }
            g gVar = (g) obj;
            if (Az() != gVar.Az()) {
                return false;
            }
            if (Az() && !getName().equals(gVar.getName())) {
                return false;
            }
            if (BV() != gVar.BV()) {
                return false;
            }
            if (BV() && this.bPE != gVar.bPE) {
                return false;
            }
            if (AF() != gVar.AF()) {
                return false;
            }
            if (!AF() || BW().equals(gVar.BW())) {
                return this.bTW.equals(gVar.bTW);
            }
            return false;
        }

        @Override // com.google.a.a
        public final int hashCode() {
            if (this.bNb != 0) {
                return this.bNb;
            }
            int hashCode = k.bOk.hashCode() + com.tencent.mm.plugin.appbrand.jsapi.share.q.CTRL_INDEX;
            if (Az()) {
                hashCode = (((hashCode * 37) + 1) * 53) + getName().hashCode();
            }
            if (BV()) {
                hashCode = (((hashCode * 37) + 2) * 53) + this.bPE;
            }
            if (AF()) {
                hashCode = (((hashCode * 37) + 3) * 53) + BW().hashCode();
            }
            int hashCode2 = (hashCode * 29) + this.bTW.hashCode();
            this.bNb = hashCode2;
            return hashCode2;
        }

        public static a BX() {
            return bPG.AN();
        }

        /* access modifiers changed from: private */
        /* renamed from: BY */
        public a AN() {
            if (this == bPG) {
                return new a((byte) 0);
            }
            return new a((byte) 0).b(this);
        }

        public static final class a extends ac.a<a> implements h {
            private int bOT;
            private Object bOU;
            private int bPE;
            private i bPF;
            private bu<i, i.a, j> bPn;

            /* synthetic */ a(byte b2) {
                this();
            }

            /* synthetic */ a(ac.b bVar, byte b2) {
                this(bVar);
            }

            /* access modifiers changed from: protected */
            @Override // com.google.a.ac.a
            public final ac.f Ay() {
                return k.bOl.h(g.class, a.class);
            }

            private a() {
                this.bOU = "";
                AR();
            }

            private a(ac.b bVar) {
                super(bVar);
                this.bOU = "";
                AR();
            }

            private void AR() {
                if (ac.bVU) {
                    Bh();
                }
            }

            @Override // com.google.a.az, com.google.a.ac.a, com.google.a.at.a
            public final l.a AS() {
                return k.bOk;
            }

            /* renamed from: Ca */
            public final g Bp() {
                g Cb = Bo();
                if (Cb.isInitialized()) {
                    return Cb;
                }
                throw b((at) Cb);
            }

            /* access modifiers changed from: private */
            /* renamed from: Cb */
            public g Bo() {
                int i2;
                int i3;
                int i4 = 0;
                g gVar = new g(this, (byte) 0);
                int i5 = this.bOT;
                if ((i5 & 1) != 0) {
                    i4 = 1;
                }
                gVar.bOU = this.bOU;
                if ((i5 & 2) != 0) {
                    gVar.bPE = this.bPE;
                    i2 = i4 | 2;
                } else {
                    i2 = i4;
                }
                if ((i5 & 4) != 0) {
                    if (this.bPn == null) {
                        gVar.bPF = this.bPF;
                    } else {
                        gVar.bPF = this.bPn.Hv();
                    }
                    i3 = i2 | 4;
                } else {
                    i3 = i2;
                }
                gVar.bOT = i3;
                Gy();
                return gVar;
            }

            /* access modifiers changed from: private */
            /* renamed from: s */
            public a f(l.f fVar, Object obj) {
                return (a) super.f(fVar, obj);
            }

            /* access modifiers changed from: private */
            /* renamed from: t */
            public a e(l.f fVar, Object obj) {
                return (a) super.e(fVar, obj);
            }

            /* access modifiers changed from: private */
            /* renamed from: j */
            public a c(at atVar) {
                if (atVar instanceof g) {
                    return b((g) atVar);
                }
                super.c(atVar);
                return this;
            }

            public final a b(g gVar) {
                if (gVar != g.BZ()) {
                    if (gVar.Az()) {
                        this.bOT |= 1;
                        this.bOU = gVar.bOU;
                        onChanged();
                    }
                    if (gVar.BV()) {
                        gm(gVar.bPE);
                    }
                    if (gVar.AF()) {
                        a(gVar.BW());
                    }
                    d(gVar.bTW);
                    onChanged();
                }
                return this;
            }

            @Override // com.google.a.ax, com.google.a.ac.a
            public final boolean isInitialized() {
                boolean z;
                if ((this.bOT & 4) != 0) {
                    z = true;
                } else {
                    z = false;
                }
                return !z || BW().isInitialized();
            }

            /* access modifiers changed from: private */
            /* JADX WARNING: Removed duplicated region for block: B:16:0x001e  */
            /* renamed from: k */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public com.google.a.k.g.a c(com.google.a.h r4, com.google.a.r r5) {
                /*
                    r3 = this;
                    r2 = 0
                    com.google.a.bj<com.google.a.k$g> r0 = com.google.a.k.g.bPg     // Catch:{ af -> 0x000f }
                    java.lang.Object r0 = r0.d(r4, r5)     // Catch:{ af -> 0x000f }
                    com.google.a.k$g r0 = (com.google.a.k.g) r0     // Catch:{ af -> 0x000f }
                    if (r0 == 0) goto L_0x000e
                    r3.b(r0)
                L_0x000e:
                    return r3
                L_0x000f:
                    r0 = move-exception
                    r1 = r0
                    com.google.a.aw r0 = r1.bXr     // Catch:{ all -> 0x0022 }
                    com.google.a.k$g r0 = (com.google.a.k.g) r0     // Catch:{ all -> 0x0022 }
                    java.io.IOException r1 = r1.GF()     // Catch:{ all -> 0x001a }
                    throw r1     // Catch:{ all -> 0x001a }
                L_0x001a:
                    r1 = move-exception
                    r2 = r0
                L_0x001c:
                    if (r2 == 0) goto L_0x0021
                    r3.b(r2)
                L_0x0021:
                    throw r1
                L_0x0022:
                    r0 = move-exception
                    r1 = r0
                    goto L_0x001c
                */
                throw new UnsupportedOperationException("Method not decompiled: com.google.a.k.g.a.c(com.google.a.h, com.google.a.r):com.google.a.k$g$a");
            }

            public final a cf(String str) {
                if (str == null) {
                    throw new NullPointerException();
                }
                this.bOT |= 1;
                this.bOU = str;
                onChanged();
                return this;
            }

            public final a gm(int i2) {
                this.bOT |= 2;
                this.bPE = i2;
                onChanged();
                return this;
            }

            private i BW() {
                if (this.bPn == null) {
                    return this.bPF == null ? i.Cd() : this.bPF;
                }
                return this.bPn.Hu();
            }

            private a a(i iVar) {
                if (this.bPn == null) {
                    if ((this.bOT & 4) == 0 || this.bPF == null || this.bPF == i.Cd()) {
                        this.bPF = iVar;
                    } else {
                        this.bPF = i.b(this.bPF).d(iVar).Bo();
                    }
                    onChanged();
                } else {
                    this.bPn.b(iVar);
                }
                this.bOT |= 4;
                return this;
            }

            private bu<i, i.a, j> Bh() {
                if (this.bPn == null) {
                    this.bPn = new bu<>(BW(), GA(), this.bWv);
                    this.bPF = null;
                }
                return this.bPn;
            }

            /* access modifiers changed from: private */
            /* renamed from: q */
            public a f(cc ccVar) {
                return (a) super.f(ccVar);
            }

            /* access modifiers changed from: private */
            /* renamed from: r */
            public a d(cc ccVar) {
                return (a) super.a(ccVar);
            }

            /* Return type fixed from 'com.google.a.ac$a' to match base method */
            @Override // com.google.a.ac.a
            public final /* bridge */ /* synthetic */ a Bl() {
                return (a) super.yG();
            }

            @Override // com.google.a.a.AbstractC0085a, com.google.a.ac.a
            public final /* synthetic */ a.AbstractC0085a yE() {
                return (a) super.yG();
            }

            @Override // com.google.a.ax
            public final /* synthetic */ aw AP() {
                return g.BZ();
            }

            @Override // com.google.a.az
            public final /* synthetic */ at AQ() {
                return g.BZ();
            }

            @Override // com.google.a.b.a, com.google.a.a.AbstractC0085a, com.google.a.ac.a
            public final /* synthetic */ b.a yG() {
                return (a) super.yG();
            }

            @Override // com.google.a.b.a, com.google.a.a.AbstractC0085a, java.lang.Object, com.google.a.ac.a
            public final /* synthetic */ Object clone() {
                return (a) super.yG();
            }
        }

        public static g BZ() {
            return bPG;
        }

        @Override // com.google.a.aw, com.google.a.ac
        public final bj<g> AK() {
            return bPg;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.a.ac
        public final /* synthetic */ at.a a(ac.b bVar) {
            return new a(bVar, (byte) 0);
        }

        @Override // com.google.a.at
        public final /* synthetic */ at.a AM() {
            return bPG.AN();
        }

        @Override // com.google.a.aw
        public final /* synthetic */ aw.a AO() {
            return bPG.AN();
        }

        @Override // com.google.a.ax
        public final /* bridge */ /* synthetic */ aw AP() {
            return bPG;
        }

        @Override // com.google.a.az
        public final /* bridge */ /* synthetic */ at AQ() {
            return bPG;
        }
    }

    public static final class ae extends ac implements af {
        @Deprecated
        public static final bj<ae> bPg = new c<ae>() {
            /* class com.google.a.k.ae.AnonymousClass1 */

            @Override // com.google.a.bj
            public final /* synthetic */ Object d(h hVar, r rVar) {
                return new ae(hVar, rVar, (byte) 0);
            }
        };
        private static final ae bRP = new ae();
        private int bOT;
        private volatile Object bOU;
        private byte bPe;
        private List<w> bRN;
        private ag bRO;

        /* synthetic */ ae(ac.a aVar, byte b2) {
            this(aVar);
        }

        /* synthetic */ ae(h hVar, r rVar, byte b2) {
            this(hVar, rVar);
        }

        private ae(ac.a<?> aVar) {
            super(aVar);
            this.bPe = -1;
        }

        private ae() {
            this.bPe = -1;
            this.bOU = "";
            this.bRN = Collections.emptyList();
        }

        @Override // com.google.a.az, com.google.a.ac
        public final cc Ax() {
            return this.bTW;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v22, resolved type: java.util.List<com.google.a.k$w> */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARNING: Removed duplicated region for block: B:24:0x003f  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private ae(com.google.a.h r7, com.google.a.r r8) {
            /*
            // Method dump skipped, instructions count: 208
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.a.k.ae.<init>(com.google.a.h, com.google.a.r):void");
        }

        /* access modifiers changed from: protected */
        @Override // com.google.a.ac
        public final ac.f Ay() {
            return k.bOn.h(ae.class, a.class);
        }

        public final boolean Az() {
            return (this.bOT & 1) != 0;
        }

        public final String getName() {
            Object obj = this.bOU;
            if (obj instanceof String) {
                return (String) obj;
            }
            g gVar = (g) obj;
            String yO = gVar.yO();
            if (gVar.yP()) {
                this.bOU = yO;
            }
            return yO;
        }

        public final int Ex() {
            return this.bRN.size();
        }

        public final w gx(int i2) {
            return this.bRN.get(i2);
        }

        public final boolean AF() {
            return (this.bOT & 2) != 0;
        }

        public final ag Ey() {
            return this.bRO == null ? ag.EG() : this.bRO;
        }

        @Override // com.google.a.a, com.google.a.ax, com.google.a.ac
        public final boolean isInitialized() {
            byte b2 = this.bPe;
            if (b2 == 1) {
                return true;
            }
            if (b2 == 0) {
                return false;
            }
            for (int i2 = 0; i2 < Ex(); i2++) {
                if (!gx(i2).isInitialized()) {
                    this.bPe = 0;
                    return false;
                }
            }
            if (!AF() || Ey().isInitialized()) {
                this.bPe = 1;
                return true;
            }
            this.bPe = 0;
            return false;
        }

        @Override // com.google.a.aw, com.google.a.a, com.google.a.ac
        public final void a(i iVar) {
            if ((this.bOT & 1) != 0) {
                ac.a(iVar, 1, this.bOU);
            }
            for (int i2 = 0; i2 < this.bRN.size(); i2++) {
                iVar.a(2, this.bRN.get(i2));
            }
            if ((this.bOT & 2) != 0) {
                iVar.a(3, Ey());
            }
            this.bTW.a(iVar);
        }

        @Override // com.google.a.aw, com.google.a.a, com.google.a.ac
        public final int yC() {
            int i2;
            int i3;
            int i4 = 0;
            int i5 = this.bNa;
            if (i5 != -1) {
                return i5;
            }
            if ((this.bOT & 1) != 0) {
                i2 = ac.d(1, this.bOU) + 0;
            } else {
                i2 = 0;
            }
            while (true) {
                i3 = i2;
                if (i4 >= this.bRN.size()) {
                    break;
                }
                i2 = i.c(2, this.bRN.get(i4)) + i3;
                i4++;
            }
            if ((this.bOT & 2) != 0) {
                i3 += i.c(3, Ey());
            }
            int yC = this.bTW.yC() + i3;
            this.bNa = yC;
            return yC;
        }

        @Override // com.google.a.a
        public final boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof ae)) {
                return super.equals(obj);
            }
            ae aeVar = (ae) obj;
            if (Az() != aeVar.Az()) {
                return false;
            }
            if (Az() && !getName().equals(aeVar.getName())) {
                return false;
            }
            if (!this.bRN.equals(aeVar.bRN)) {
                return false;
            }
            if (AF() != aeVar.AF()) {
                return false;
            }
            if (!AF() || Ey().equals(aeVar.Ey())) {
                return this.bTW.equals(aeVar.bTW);
            }
            return false;
        }

        @Override // com.google.a.a
        public final int hashCode() {
            if (this.bNb != 0) {
                return this.bNb;
            }
            int hashCode = k.bOm.hashCode() + com.tencent.mm.plugin.appbrand.jsapi.share.q.CTRL_INDEX;
            if (Az()) {
                hashCode = (((hashCode * 37) + 1) * 53) + getName().hashCode();
            }
            if (Ex() > 0) {
                hashCode = (((hashCode * 37) + 2) * 53) + this.bRN.hashCode();
            }
            if (AF()) {
                hashCode = (((hashCode * 37) + 3) * 53) + Ey().hashCode();
            }
            int hashCode2 = (hashCode * 29) + this.bTW.hashCode();
            this.bNb = hashCode2;
            return hashCode2;
        }

        /* access modifiers changed from: private */
        /* renamed from: Ez */
        public a AN() {
            if (this == bRP) {
                return new a((byte) 0);
            }
            return new a((byte) 0).c(this);
        }

        public static final class a extends ac.a<a> implements af {
            private int bOT;
            private Object bOU;
            private bu<ag, ag.a, ah> bPn;
            private List<w> bRN;
            private ag bRO;
            private bq<w, w.a, x> bRQ;

            /* synthetic */ a(byte b2) {
                this();
            }

            /* synthetic */ a(ac.b bVar, byte b2) {
                this(bVar);
            }

            /* access modifiers changed from: protected */
            @Override // com.google.a.ac.a
            public final ac.f Ay() {
                return k.bOn.h(ae.class, a.class);
            }

            private a() {
                this.bOU = "";
                this.bRN = Collections.emptyList();
                AR();
            }

            private a(ac.b bVar) {
                super(bVar);
                this.bOU = "";
                this.bRN = Collections.emptyList();
                AR();
            }

            private void AR() {
                if (ac.bVU) {
                    EE();
                    Bh();
                }
            }

            @Override // com.google.a.az, com.google.a.ac.a, com.google.a.at.a
            public final l.a AS() {
                return k.bOm;
            }

            /* access modifiers changed from: private */
            /* renamed from: EB */
            public ae Bp() {
                ae EC = Bo();
                if (EC.isInitialized()) {
                    return EC;
                }
                throw b(EC);
            }

            /* access modifiers changed from: private */
            /* renamed from: EC */
            public ae Bo() {
                int i2;
                ae aeVar = new ae(this, (byte) 0);
                int i3 = this.bOT;
                if ((i3 & 1) != 0) {
                    i2 = 1;
                } else {
                    i2 = 0;
                }
                aeVar.bOU = this.bOU;
                if (this.bRQ == null) {
                    if ((this.bOT & 2) != 0) {
                        this.bRN = Collections.unmodifiableList(this.bRN);
                        this.bOT &= -3;
                    }
                    aeVar.bRN = this.bRN;
                } else {
                    aeVar.bRN = this.bRQ.build();
                }
                if ((i3 & 4) != 0) {
                    if (this.bPn == null) {
                        aeVar.bRO = this.bRO;
                    } else {
                        aeVar.bRO = this.bPn.Hv();
                    }
                    i2 |= 2;
                }
                aeVar.bOT = i2;
                Gy();
                return aeVar;
            }

            /* access modifiers changed from: private */
            /* renamed from: Q */
            public a f(l.f fVar, Object obj) {
                return (a) super.f(fVar, obj);
            }

            /* access modifiers changed from: private */
            /* renamed from: R */
            public a e(l.f fVar, Object obj) {
                return (a) super.e(fVar, obj);
            }

            /* access modifiers changed from: private */
            /* renamed from: v */
            public a c(at atVar) {
                if (atVar instanceof ae) {
                    return c((ae) atVar);
                }
                super.c(atVar);
                return this;
            }

            public final a c(ae aeVar) {
                bq<w, w.a, x> bqVar = null;
                if (aeVar != ae.EA()) {
                    if (aeVar.Az()) {
                        this.bOT |= 1;
                        this.bOU = aeVar.bOU;
                        onChanged();
                    }
                    if (this.bRQ == null) {
                        if (!aeVar.bRN.isEmpty()) {
                            if (this.bRN.isEmpty()) {
                                this.bRN = aeVar.bRN;
                                this.bOT &= -3;
                            } else {
                                ED();
                                this.bRN.addAll(aeVar.bRN);
                            }
                            onChanged();
                        }
                    } else if (!aeVar.bRN.isEmpty()) {
                        if (this.bRQ.isEmpty()) {
                            this.bRQ.bYP = null;
                            this.bRQ = null;
                            this.bRN = aeVar.bRN;
                            this.bOT &= -3;
                            if (ac.bVU) {
                                bqVar = EE();
                            }
                            this.bRQ = bqVar;
                        } else {
                            this.bRQ.a(aeVar.bRN);
                        }
                    }
                    if (aeVar.AF()) {
                        a(aeVar.Ey());
                    }
                    d(aeVar.bTW);
                    onChanged();
                }
                return this;
            }

            @Override // com.google.a.ax, com.google.a.ac.a
            public final boolean isInitialized() {
                int count;
                boolean z;
                w s;
                int i2 = 0;
                while (true) {
                    if (this.bRQ == null) {
                        count = this.bRN.size();
                    } else {
                        count = this.bRQ.getCount();
                    }
                    if (i2 < count) {
                        if (this.bRQ == null) {
                            s = this.bRN.get(i2);
                        } else {
                            s = this.bRQ.s(i2, false);
                        }
                        if (!s.isInitialized()) {
                            return false;
                        }
                        i2++;
                    } else {
                        if ((this.bOT & 4) != 0) {
                            z = true;
                        } else {
                            z = false;
                        }
                        return !z || Ey().isInitialized();
                    }
                }
            }

            /* access modifiers changed from: private */
            /* JADX WARNING: Removed duplicated region for block: B:16:0x001e  */
            /* renamed from: w */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public com.google.a.k.ae.a c(com.google.a.h r4, com.google.a.r r5) {
                /*
                    r3 = this;
                    r2 = 0
                    com.google.a.bj<com.google.a.k$ae> r0 = com.google.a.k.ae.bPg     // Catch:{ af -> 0x000f }
                    java.lang.Object r0 = r0.d(r4, r5)     // Catch:{ af -> 0x000f }
                    com.google.a.k$ae r0 = (com.google.a.k.ae) r0     // Catch:{ af -> 0x000f }
                    if (r0 == 0) goto L_0x000e
                    r3.c(r0)
                L_0x000e:
                    return r3
                L_0x000f:
                    r0 = move-exception
                    r1 = r0
                    com.google.a.aw r0 = r1.bXr     // Catch:{ all -> 0x0022 }
                    com.google.a.k$ae r0 = (com.google.a.k.ae) r0     // Catch:{ all -> 0x0022 }
                    java.io.IOException r1 = r1.GF()     // Catch:{ all -> 0x001a }
                    throw r1     // Catch:{ all -> 0x001a }
                L_0x001a:
                    r1 = move-exception
                    r2 = r0
                L_0x001c:
                    if (r2 == 0) goto L_0x0021
                    r3.c(r2)
                L_0x0021:
                    throw r1
                L_0x0022:
                    r0 = move-exception
                    r1 = r0
                    goto L_0x001c
                */
                throw new UnsupportedOperationException("Method not decompiled: com.google.a.k.ae.a.c(com.google.a.h, com.google.a.r):com.google.a.k$ae$a");
            }

            private void ED() {
                if ((this.bOT & 2) == 0) {
                    this.bRN = new ArrayList(this.bRN);
                    this.bOT |= 2;
                }
            }

            private bq<w, w.a, x> EE() {
                if (this.bRQ == null) {
                    this.bRQ = new bq<>(this.bRN, (this.bOT & 2) != 0, GA(), this.bWv);
                    this.bRN = null;
                }
                return this.bRQ;
            }

            private ag Ey() {
                if (this.bPn == null) {
                    return this.bRO == null ? ag.EG() : this.bRO;
                }
                return this.bPn.Hu();
            }

            private a a(ag agVar) {
                if (this.bPn == null) {
                    if ((this.bOT & 4) == 0 || this.bRO == null || this.bRO == ag.EG()) {
                        this.bRO = agVar;
                    } else {
                        this.bRO = ag.b(this.bRO).d(agVar).Bo();
                    }
                    onChanged();
                } else {
                    this.bPn.b(agVar);
                }
                this.bOT |= 4;
                return this;
            }

            private bu<ag, ag.a, ah> Bh() {
                if (this.bPn == null) {
                    this.bPn = new bu<>(Ey(), GA(), this.bWv);
                    this.bRO = null;
                }
                return this.bPn;
            }

            /* access modifiers changed from: private */
            /* renamed from: O */
            public a f(cc ccVar) {
                return (a) super.f(ccVar);
            }

            /* access modifiers changed from: private */
            /* renamed from: P */
            public a d(cc ccVar) {
                return (a) super.a(ccVar);
            }

            /* Return type fixed from 'com.google.a.ac$a' to match base method */
            @Override // com.google.a.ac.a
            public final /* bridge */ /* synthetic */ a Bl() {
                return (a) super.yG();
            }

            @Override // com.google.a.a.AbstractC0085a, com.google.a.ac.a
            public final /* synthetic */ a.AbstractC0085a yE() {
                return (a) super.yG();
            }

            @Override // com.google.a.ax
            public final /* synthetic */ aw AP() {
                return ae.EA();
            }

            @Override // com.google.a.az
            public final /* synthetic */ at AQ() {
                return ae.EA();
            }

            @Override // com.google.a.b.a, com.google.a.a.AbstractC0085a, com.google.a.ac.a
            public final /* synthetic */ b.a yG() {
                return (a) super.yG();
            }

            @Override // com.google.a.b.a, com.google.a.a.AbstractC0085a, java.lang.Object, com.google.a.ac.a
            public final /* synthetic */ Object clone() {
                return (a) super.yG();
            }
        }

        public static ae EA() {
            return bRP;
        }

        @Override // com.google.a.aw, com.google.a.ac
        public final bj<ae> AK() {
            return bPg;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.a.ac
        public final /* synthetic */ at.a a(ac.b bVar) {
            return new a(bVar, (byte) 0);
        }

        @Override // com.google.a.at
        public final /* synthetic */ at.a AM() {
            return bRP.AN();
        }

        @Override // com.google.a.aw
        public final /* synthetic */ aw.a AO() {
            return bRP.AN();
        }

        @Override // com.google.a.ax
        public final /* bridge */ /* synthetic */ aw AP() {
            return bRP;
        }

        @Override // com.google.a.az
        public final /* bridge */ /* synthetic */ at AQ() {
            return bRP;
        }
    }

    public static final class w extends ac implements x {
        @Deprecated
        public static final bj<w> bPg = new c<w>() {
            /* class com.google.a.k.w.AnonymousClass1 */

            @Override // com.google.a.bj
            public final /* synthetic */ Object d(h hVar, r rVar) {
                return new w(hVar, rVar, (byte) 0);
            }
        };
        private static final w bRC = new w();
        private int bOT;
        private volatile Object bOU;
        private byte bPe;
        boolean bRA;
        boolean bRB;
        private volatile Object bRx;
        private volatile Object bRy;
        private y bRz;

        /* synthetic */ w(ac.a aVar, byte b2) {
            this(aVar);
        }

        /* synthetic */ w(h hVar, r rVar, byte b2) {
            this(hVar, rVar);
        }

        private w(ac.a<?> aVar) {
            super(aVar);
            this.bPe = -1;
        }

        private w() {
            this.bPe = -1;
            this.bOU = "";
            this.bRx = "";
            this.bRy = "";
        }

        @Override // com.google.a.az, com.google.a.ac
        public final cc Ax() {
            return this.bTW;
        }

        private w(h hVar, r rVar) {
            this();
            y.a aVar;
            boolean z;
            if (rVar == null) {
                throw new NullPointerException();
            }
            cc.a HJ = cc.HJ();
            boolean z2 = false;
            while (!z2) {
                try {
                    int yT = hVar.yT();
                    switch (yT) {
                        case 0:
                            z2 = true;
                            break;
                        case 10:
                            g zb = hVar.zb();
                            this.bOT |= 1;
                            this.bOU = zb;
                            break;
                        case 18:
                            g zb2 = hVar.zb();
                            this.bOT |= 2;
                            this.bRx = zb2;
                            break;
                        case 26:
                            g zb3 = hVar.zb();
                            this.bOT |= 4;
                            this.bRy = zb3;
                            break;
                        case 34:
                            if ((this.bOT & 8) != 0) {
                                aVar = this.bRz.AN();
                            } else {
                                aVar = null;
                            }
                            this.bRz = (y) hVar.a(y.bPg, rVar);
                            if (aVar != null) {
                                aVar.d(this.bRz);
                                this.bRz = aVar.Bo();
                            }
                            this.bOT |= 8;
                            break;
                        case 40:
                            this.bOT |= 16;
                            this.bRA = hVar.yZ();
                            break;
                        case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE:
                            this.bOT |= 32;
                            this.bRB = hVar.yZ();
                            break;
                        default:
                            if (!a(hVar, HJ, rVar, yT)) {
                                z = true;
                            } else {
                                z = z2;
                            }
                            z2 = z;
                            break;
                    }
                } catch (af e2) {
                    e2.bXr = this;
                    throw e2;
                } catch (IOException e3) {
                    af afVar = new af(e3);
                    afVar.bXr = this;
                    throw afVar;
                } catch (Throwable th) {
                    this.bTW = HJ.Bp();
                    Gw();
                    throw th;
                }
            }
            this.bTW = HJ.Bp();
            Gw();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.a.ac
        public final ac.f Ay() {
            return k.bOp.h(w.class, a.class);
        }

        public final boolean Az() {
            return (this.bOT & 1) != 0;
        }

        public final String getName() {
            Object obj = this.bOU;
            if (obj instanceof String) {
                return (String) obj;
            }
            g gVar = (g) obj;
            String yO = gVar.yO();
            if (gVar.yP()) {
                this.bOU = yO;
            }
            return yO;
        }

        public final boolean DX() {
            return (this.bOT & 2) != 0;
        }

        public final String DY() {
            Object obj = this.bRx;
            if (obj instanceof String) {
                return (String) obj;
            }
            g gVar = (g) obj;
            String yO = gVar.yO();
            if (gVar.yP()) {
                this.bRx = yO;
            }
            return yO;
        }

        public final boolean DZ() {
            return (this.bOT & 4) != 0;
        }

        public final String Ea() {
            Object obj = this.bRy;
            if (obj instanceof String) {
                return (String) obj;
            }
            g gVar = (g) obj;
            String yO = gVar.yO();
            if (gVar.yP()) {
                this.bRy = yO;
            }
            return yO;
        }

        public final boolean AF() {
            return (this.bOT & 8) != 0;
        }

        public final y Eb() {
            return this.bRz == null ? y.El() : this.bRz;
        }

        public final boolean Ec() {
            return (this.bOT & 16) != 0;
        }

        public final boolean Ed() {
            return (this.bOT & 32) != 0;
        }

        @Override // com.google.a.a, com.google.a.ax, com.google.a.ac
        public final boolean isInitialized() {
            byte b2 = this.bPe;
            if (b2 == 1) {
                return true;
            }
            if (b2 == 0) {
                return false;
            }
            if (!AF() || Eb().isInitialized()) {
                this.bPe = 1;
                return true;
            }
            this.bPe = 0;
            return false;
        }

        @Override // com.google.a.aw, com.google.a.a, com.google.a.ac
        public final void a(i iVar) {
            if ((this.bOT & 1) != 0) {
                ac.a(iVar, 1, this.bOU);
            }
            if ((this.bOT & 2) != 0) {
                ac.a(iVar, 2, this.bRx);
            }
            if ((this.bOT & 4) != 0) {
                ac.a(iVar, 3, this.bRy);
            }
            if ((this.bOT & 8) != 0) {
                iVar.a(4, Eb());
            }
            if ((this.bOT & 16) != 0) {
                iVar.r(5, this.bRA);
            }
            if ((this.bOT & 32) != 0) {
                iVar.r(6, this.bRB);
            }
            this.bTW.a(iVar);
        }

        @Override // com.google.a.aw, com.google.a.a, com.google.a.ac
        public final int yC() {
            int i2 = this.bNa;
            if (i2 != -1) {
                return i2;
            }
            int i3 = 0;
            if ((this.bOT & 1) != 0) {
                i3 = ac.d(1, this.bOU) + 0;
            }
            if ((this.bOT & 2) != 0) {
                i3 += ac.d(2, this.bRx);
            }
            if ((this.bOT & 4) != 0) {
                i3 += ac.d(3, this.bRy);
            }
            if ((this.bOT & 8) != 0) {
                i3 += i.c(4, Eb());
            }
            if ((this.bOT & 16) != 0) {
                i3 += i.fR(5);
            }
            if ((this.bOT & 32) != 0) {
                i3 += i.fR(6);
            }
            int yC = i3 + this.bTW.yC();
            this.bNa = yC;
            return yC;
        }

        @Override // com.google.a.a
        public final boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof w)) {
                return super.equals(obj);
            }
            w wVar = (w) obj;
            if (Az() != wVar.Az()) {
                return false;
            }
            if (Az() && !getName().equals(wVar.getName())) {
                return false;
            }
            if (DX() != wVar.DX()) {
                return false;
            }
            if (DX() && !DY().equals(wVar.DY())) {
                return false;
            }
            if (DZ() != wVar.DZ()) {
                return false;
            }
            if (DZ() && !Ea().equals(wVar.Ea())) {
                return false;
            }
            if (AF() != wVar.AF()) {
                return false;
            }
            if (AF() && !Eb().equals(wVar.Eb())) {
                return false;
            }
            if (Ec() != wVar.Ec()) {
                return false;
            }
            if (Ec() && this.bRA != wVar.bRA) {
                return false;
            }
            if (Ed() != wVar.Ed()) {
                return false;
            }
            if (!Ed() || this.bRB == wVar.bRB) {
                return this.bTW.equals(wVar.bTW);
            }
            return false;
        }

        @Override // com.google.a.a
        public final int hashCode() {
            if (this.bNb != 0) {
                return this.bNb;
            }
            int hashCode = k.bOo.hashCode() + com.tencent.mm.plugin.appbrand.jsapi.share.q.CTRL_INDEX;
            if (Az()) {
                hashCode = (((hashCode * 37) + 1) * 53) + getName().hashCode();
            }
            if (DX()) {
                hashCode = (((hashCode * 37) + 2) * 53) + DY().hashCode();
            }
            if (DZ()) {
                hashCode = (((hashCode * 37) + 3) * 53) + Ea().hashCode();
            }
            if (AF()) {
                hashCode = (((hashCode * 37) + 4) * 53) + Eb().hashCode();
            }
            if (Ec()) {
                hashCode = (((hashCode * 37) + 5) * 53) + ae.bF(this.bRA);
            }
            if (Ed()) {
                hashCode = (((hashCode * 37) + 6) * 53) + ae.bF(this.bRB);
            }
            int hashCode2 = (hashCode * 29) + this.bTW.hashCode();
            this.bNb = hashCode2;
            return hashCode2;
        }

        /* access modifiers changed from: private */
        /* renamed from: Ee */
        public a AN() {
            if (this == bRC) {
                return new a((byte) 0);
            }
            return new a((byte) 0).d(this);
        }

        public static final class a extends ac.a<a> implements x {
            private int bOT;
            private Object bOU;
            private bu<y, y.a, z> bPn;
            private boolean bRA;
            private boolean bRB;
            private Object bRx;
            private Object bRy;
            private y bRz;

            /* synthetic */ a(byte b2) {
                this();
            }

            /* synthetic */ a(ac.b bVar, byte b2) {
                this(bVar);
            }

            /* access modifiers changed from: protected */
            @Override // com.google.a.ac.a
            public final ac.f Ay() {
                return k.bOp.h(w.class, a.class);
            }

            private a() {
                this.bOU = "";
                this.bRx = "";
                this.bRy = "";
                AR();
            }

            private a(ac.b bVar) {
                super(bVar);
                this.bOU = "";
                this.bRx = "";
                this.bRy = "";
                AR();
            }

            private void AR() {
                if (ac.bVU) {
                    Bh();
                }
            }

            @Override // com.google.a.az, com.google.a.ac.a, com.google.a.at.a
            public final l.a AS() {
                return k.bOo;
            }

            /* access modifiers changed from: private */
            /* renamed from: Eg */
            public w Bp() {
                w Eh = Bo();
                if (Eh.isInitialized()) {
                    return Eh;
                }
                throw b(Eh);
            }

            /* access modifiers changed from: private */
            /* renamed from: Eh */
            public w Bo() {
                int i2;
                int i3;
                int i4 = 0;
                w wVar = new w(this, (byte) 0);
                int i5 = this.bOT;
                if ((i5 & 1) != 0) {
                    i4 = 1;
                }
                wVar.bOU = this.bOU;
                if ((i5 & 2) != 0) {
                    i4 |= 2;
                }
                wVar.bRx = this.bRx;
                if ((i5 & 4) != 0) {
                    i2 = i4 | 4;
                } else {
                    i2 = i4;
                }
                wVar.bRy = this.bRy;
                if ((i5 & 8) != 0) {
                    if (this.bPn == null) {
                        wVar.bRz = this.bRz;
                    } else {
                        wVar.bRz = this.bPn.Hv();
                    }
                    i3 = i2 | 8;
                } else {
                    i3 = i2;
                }
                if ((i5 & 16) != 0) {
                    wVar.bRA = this.bRA;
                    i3 |= 16;
                }
                if ((i5 & 32) != 0) {
                    wVar.bRB = this.bRB;
                    i3 |= 32;
                }
                wVar.bOT = i3;
                Gy();
                return wVar;
            }

            /* access modifiers changed from: private */
            /* renamed from: I */
            public a f(l.f fVar, Object obj) {
                return (a) super.f(fVar, obj);
            }

            /* access modifiers changed from: private */
            /* renamed from: J */
            public a e(l.f fVar, Object obj) {
                return (a) super.e(fVar, obj);
            }

            /* access modifiers changed from: private */
            /* renamed from: r */
            public a c(at atVar) {
                if (atVar instanceof w) {
                    return d((w) atVar);
                }
                super.c(atVar);
                return this;
            }

            public final a d(w wVar) {
                if (wVar != w.Ef()) {
                    if (wVar.Az()) {
                        this.bOT |= 1;
                        this.bOU = wVar.bOU;
                        onChanged();
                    }
                    if (wVar.DX()) {
                        this.bOT |= 2;
                        this.bRx = wVar.bRx;
                        onChanged();
                    }
                    if (wVar.DZ()) {
                        this.bOT |= 4;
                        this.bRy = wVar.bRy;
                        onChanged();
                    }
                    if (wVar.AF()) {
                        a(wVar.Eb());
                    }
                    if (wVar.Ec()) {
                        bz(wVar.bRA);
                    }
                    if (wVar.Ed()) {
                        bA(wVar.bRB);
                    }
                    d(wVar.bTW);
                    onChanged();
                }
                return this;
            }

            @Override // com.google.a.ax, com.google.a.ac.a
            public final boolean isInitialized() {
                boolean z;
                if ((this.bOT & 8) != 0) {
                    z = true;
                } else {
                    z = false;
                }
                return !z || Eb().isInitialized();
            }

            /* access modifiers changed from: private */
            /* JADX WARNING: Removed duplicated region for block: B:16:0x001e  */
            /* renamed from: s */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public com.google.a.k.w.a c(com.google.a.h r4, com.google.a.r r5) {
                /*
                    r3 = this;
                    r2 = 0
                    com.google.a.bj<com.google.a.k$w> r0 = com.google.a.k.w.bPg     // Catch:{ af -> 0x000f }
                    java.lang.Object r0 = r0.d(r4, r5)     // Catch:{ af -> 0x000f }
                    com.google.a.k$w r0 = (com.google.a.k.w) r0     // Catch:{ af -> 0x000f }
                    if (r0 == 0) goto L_0x000e
                    r3.d(r0)
                L_0x000e:
                    return r3
                L_0x000f:
                    r0 = move-exception
                    r1 = r0
                    com.google.a.aw r0 = r1.bXr     // Catch:{ all -> 0x0022 }
                    com.google.a.k$w r0 = (com.google.a.k.w) r0     // Catch:{ all -> 0x0022 }
                    java.io.IOException r1 = r1.GF()     // Catch:{ all -> 0x001a }
                    throw r1     // Catch:{ all -> 0x001a }
                L_0x001a:
                    r1 = move-exception
                    r2 = r0
                L_0x001c:
                    if (r2 == 0) goto L_0x0021
                    r3.d(r2)
                L_0x0021:
                    throw r1
                L_0x0022:
                    r0 = move-exception
                    r1 = r0
                    goto L_0x001c
                */
                throw new UnsupportedOperationException("Method not decompiled: com.google.a.k.w.a.c(com.google.a.h, com.google.a.r):com.google.a.k$w$a");
            }

            private y Eb() {
                if (this.bPn == null) {
                    return this.bRz == null ? y.El() : this.bRz;
                }
                return this.bPn.Hu();
            }

            private a a(y yVar) {
                if (this.bPn == null) {
                    if ((this.bOT & 8) == 0 || this.bRz == null || this.bRz == y.El()) {
                        this.bRz = yVar;
                    } else {
                        this.bRz = y.b(this.bRz).d(yVar).Bo();
                    }
                    onChanged();
                } else {
                    this.bPn.b(yVar);
                }
                this.bOT |= 8;
                return this;
            }

            private bu<y, y.a, z> Bh() {
                if (this.bPn == null) {
                    this.bPn = new bu<>(Eb(), GA(), this.bWv);
                    this.bRz = null;
                }
                return this.bPn;
            }

            private a bz(boolean z) {
                this.bOT |= 16;
                this.bRA = z;
                onChanged();
                return this;
            }

            private a bA(boolean z) {
                this.bOT |= 32;
                this.bRB = z;
                onChanged();
                return this;
            }

            /* access modifiers changed from: private */
            /* renamed from: G */
            public a f(cc ccVar) {
                return (a) super.f(ccVar);
            }

            /* access modifiers changed from: private */
            /* renamed from: H */
            public a d(cc ccVar) {
                return (a) super.a(ccVar);
            }

            /* Return type fixed from 'com.google.a.ac$a' to match base method */
            @Override // com.google.a.ac.a
            public final /* bridge */ /* synthetic */ a Bl() {
                return (a) super.yG();
            }

            @Override // com.google.a.a.AbstractC0085a, com.google.a.ac.a
            public final /* synthetic */ a.AbstractC0085a yE() {
                return (a) super.yG();
            }

            @Override // com.google.a.ax
            public final /* synthetic */ aw AP() {
                return w.Ef();
            }

            @Override // com.google.a.az
            public final /* synthetic */ at AQ() {
                return w.Ef();
            }

            @Override // com.google.a.b.a, com.google.a.a.AbstractC0085a, com.google.a.ac.a
            public final /* synthetic */ b.a yG() {
                return (a) super.yG();
            }

            @Override // com.google.a.b.a, com.google.a.a.AbstractC0085a, java.lang.Object, com.google.a.ac.a
            public final /* synthetic */ Object clone() {
                return (a) super.yG();
            }
        }

        public static w Ef() {
            return bRC;
        }

        @Override // com.google.a.aw, com.google.a.ac
        public final bj<w> AK() {
            return bPg;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.a.ac
        public final /* synthetic */ at.a a(ac.b bVar) {
            return new a(bVar, (byte) 0);
        }

        @Override // com.google.a.at
        public final /* synthetic */ at.a AM() {
            return bRC.AN();
        }

        @Override // com.google.a.aw
        public final /* synthetic */ aw.a AO() {
            return bRC.AN();
        }

        @Override // com.google.a.ax
        public final /* bridge */ /* synthetic */ aw AP() {
            return bRC;
        }

        @Override // com.google.a.az
        public final /* bridge */ /* synthetic */ at AQ() {
            return bRC;
        }
    }

    public static final class s extends ac.d<s> implements t {
        @Deprecated
        public static final bj<s> bPg = new c<s>() {
            /* class com.google.a.k.s.AnonymousClass1 */

            @Override // com.google.a.bj
            public final /* synthetic */ Object d(h hVar, r rVar) {
                return new s(hVar, rVar, (byte) 0);
            }
        };
        private static final s bRn = new s();
        private int bOT;
        boolean bPA;
        private List<ak> bPB;
        private byte bPe;
        private volatile Object bQU;
        private volatile Object bQV;
        boolean bQW;
        boolean bQX;
        boolean bQY;
        private int bQZ;
        private volatile Object bRa;
        boolean bRb;
        boolean bRc;
        boolean bRd;
        boolean bRe;
        boolean bRf;
        private volatile Object bRg;
        private volatile Object bRh;
        private volatile Object bRi;
        private volatile Object bRj;
        private volatile Object bRk;
        private volatile Object bRl;
        private volatile Object bRm;

        /* synthetic */ s(ac.c cVar, byte b2) {
            this(cVar);
        }

        /* synthetic */ s(h hVar, r rVar, byte b2) {
            this(hVar, rVar);
        }

        private s(ac.c<s, ?> cVar) {
            super(cVar);
            this.bPe = -1;
        }

        private s() {
            this.bPe = -1;
            this.bQU = "";
            this.bQV = "";
            this.bQZ = 1;
            this.bRa = "";
            this.bRg = "";
            this.bRh = "";
            this.bRi = "";
            this.bRj = "";
            this.bRk = "";
            this.bRl = "";
            this.bRm = "";
            this.bPB = Collections.emptyList();
        }

        @Override // com.google.a.az, com.google.a.ac
        public final cc Ax() {
            return this.bTW;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r3v3, resolved type: java.util.List<com.google.a.k$ak> */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARNING: Removed duplicated region for block: B:23:0x0040  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private s(com.google.a.h r9, com.google.a.r r10) {
            /*
            // Method dump skipped, instructions count: 516
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.a.k.s.<init>(com.google.a.h, com.google.a.r):void");
        }

        /* access modifiers changed from: protected */
        @Override // com.google.a.ac
        public final ac.f Ay() {
            return k.bOr.h(s.class, a.class);
        }

        public enum b implements bn {
            SPEED(1),
            CODE_SIZE(2),
            LITE_RUNTIME(3);
            
            private static final ae.b<b> bPU = new ae.b<b>() {
                /* class com.google.a.k.s.b.AnonymousClass1 */
            };
            private static final b[] bRr = values();
            final int value;

            @Override // com.google.a.ae.a
            public final int getNumber() {
                return this.value;
            }

            private b(int i2) {
                this.value = i2;
            }

            @Deprecated
            public static b gv(int i2) {
                switch (i2) {
                    case 1:
                        return SPEED;
                    case 2:
                        return CODE_SIZE;
                    case 3:
                        return LITE_RUNTIME;
                    default:
                        return null;
                }
            }
        }

        public final boolean Di() {
            return (this.bOT & 1) != 0;
        }

        private String Dj() {
            Object obj = this.bQU;
            if (obj instanceof String) {
                return (String) obj;
            }
            g gVar = (g) obj;
            String yO = gVar.yO();
            if (gVar.yP()) {
                this.bQU = yO;
            }
            return yO;
        }

        public final boolean Dk() {
            return (this.bOT & 2) != 0;
        }

        private String Dl() {
            Object obj = this.bQV;
            if (obj instanceof String) {
                return (String) obj;
            }
            g gVar = (g) obj;
            String yO = gVar.yO();
            if (gVar.yP()) {
                this.bQV = yO;
            }
            return yO;
        }

        public final boolean Dm() {
            return (this.bOT & 4) != 0;
        }

        @Deprecated
        public final boolean Dn() {
            return (this.bOT & 8) != 0;
        }

        public final boolean Do() {
            return (this.bOT & 16) != 0;
        }

        public final boolean Dp() {
            return (this.bOT & 32) != 0;
        }

        public final b Dq() {
            b gv = b.gv(this.bQZ);
            return gv == null ? b.SPEED : gv;
        }

        public final boolean Dr() {
            return (this.bOT & 64) != 0;
        }

        private String Ds() {
            Object obj = this.bRa;
            if (obj instanceof String) {
                return (String) obj;
            }
            g gVar = (g) obj;
            String yO = gVar.yO();
            if (gVar.yP()) {
                this.bRa = yO;
            }
            return yO;
        }

        public final boolean Dt() {
            return (this.bOT & 128) != 0;
        }

        public final boolean Du() {
            return (this.bOT & 256) != 0;
        }

        public final boolean Dv() {
            return (this.bOT & 512) != 0;
        }

        public final boolean Dw() {
            return (this.bOT & 1024) != 0;
        }

        public final boolean BN() {
            return (this.bOT & 2048) != 0;
        }

        public final boolean Dx() {
            return (this.bOT & 4096) != 0;
        }

        public final boolean Dy() {
            return (this.bOT & 8192) != 0;
        }

        private String Dz() {
            Object obj = this.bRg;
            if (obj instanceof String) {
                return (String) obj;
            }
            g gVar = (g) obj;
            String yO = gVar.yO();
            if (gVar.yP()) {
                this.bRg = yO;
            }
            return yO;
        }

        public final boolean DA() {
            return (this.bOT & 16384) != 0;
        }

        private String DB() {
            Object obj = this.bRh;
            if (obj instanceof String) {
                return (String) obj;
            }
            g gVar = (g) obj;
            String yO = gVar.yO();
            if (gVar.yP()) {
                this.bRh = yO;
            }
            return yO;
        }

        public final boolean DC() {
            return (this.bOT & 32768) != 0;
        }

        private String DD() {
            Object obj = this.bRi;
            if (obj instanceof String) {
                return (String) obj;
            }
            g gVar = (g) obj;
            String yO = gVar.yO();
            if (gVar.yP()) {
                this.bRi = yO;
            }
            return yO;
        }

        public final boolean DE() {
            return (this.bOT & 65536) != 0;
        }

        private String DF() {
            Object obj = this.bRj;
            if (obj instanceof String) {
                return (String) obj;
            }
            g gVar = (g) obj;
            String yO = gVar.yO();
            if (gVar.yP()) {
                this.bRj = yO;
            }
            return yO;
        }

        public final boolean DG() {
            return (this.bOT & 131072) != 0;
        }

        private String DH() {
            Object obj = this.bRk;
            if (obj instanceof String) {
                return (String) obj;
            }
            g gVar = (g) obj;
            String yO = gVar.yO();
            if (gVar.yP()) {
                this.bRk = yO;
            }
            return yO;
        }

        public final boolean DI() {
            return (this.bOT & TPMediaCodecProfileLevel.HEVCMainTierLevel52) != 0;
        }

        private String DJ() {
            Object obj = this.bRl;
            if (obj instanceof String) {
                return (String) obj;
            }
            g gVar = (g) obj;
            String yO = gVar.yO();
            if (gVar.yP()) {
                this.bRl = yO;
            }
            return yO;
        }

        public final boolean DK() {
            return (this.bOT & 524288) != 0;
        }

        private String DL() {
            Object obj = this.bRm;
            if (obj instanceof String) {
                return (String) obj;
            }
            g gVar = (g) obj;
            String yO = gVar.yO();
            if (gVar.yP()) {
                this.bRm = yO;
            }
            return yO;
        }

        private int BO() {
            return this.bPB.size();
        }

        @Override // com.google.a.a, com.google.a.ax, com.google.a.ac.d, com.google.a.ac
        public final boolean isInitialized() {
            byte b2 = this.bPe;
            if (b2 == 1) {
                return true;
            }
            if (b2 == 0) {
                return false;
            }
            for (int i2 = 0; i2 < BO(); i2++) {
                if (!this.bPB.get(i2).isInitialized()) {
                    this.bPe = 0;
                    return false;
                }
            }
            if (!this.bWd.isInitialized()) {
                this.bPe = 0;
                return false;
            }
            this.bPe = 1;
            return true;
        }

        @Override // com.google.a.aw, com.google.a.a, com.google.a.ac
        public final void a(i iVar) {
            ac.d<MessageType>.a GC = GC();
            if ((this.bOT & 1) != 0) {
                ac.a(iVar, 1, this.bQU);
            }
            if ((this.bOT & 2) != 0) {
                ac.a(iVar, 8, this.bQV);
            }
            if ((this.bOT & 32) != 0) {
                iVar.bs(9, this.bQZ);
            }
            if ((this.bOT & 4) != 0) {
                iVar.r(10, this.bQW);
            }
            if ((this.bOT & 64) != 0) {
                ac.a(iVar, 11, this.bRa);
            }
            if ((this.bOT & 128) != 0) {
                iVar.r(16, this.bRb);
            }
            if ((this.bOT & 256) != 0) {
                iVar.r(17, this.bRc);
            }
            if ((this.bOT & 512) != 0) {
                iVar.r(18, this.bRd);
            }
            if ((this.bOT & 8) != 0) {
                iVar.r(20, this.bQX);
            }
            if ((this.bOT & 2048) != 0) {
                iVar.r(23, this.bPA);
            }
            if ((this.bOT & 16) != 0) {
                iVar.r(27, this.bQY);
            }
            if ((this.bOT & 4096) != 0) {
                iVar.r(31, this.bRf);
            }
            if ((this.bOT & 8192) != 0) {
                ac.a(iVar, 36, this.bRg);
            }
            if ((this.bOT & 16384) != 0) {
                ac.a(iVar, 37, this.bRh);
            }
            if ((this.bOT & 32768) != 0) {
                ac.a(iVar, 39, this.bRi);
            }
            if ((this.bOT & 65536) != 0) {
                ac.a(iVar, 40, this.bRj);
            }
            if ((this.bOT & 131072) != 0) {
                ac.a(iVar, 41, this.bRk);
            }
            if ((this.bOT & 1024) != 0) {
                iVar.r(42, this.bRe);
            }
            if ((this.bOT & TPMediaCodecProfileLevel.HEVCMainTierLevel52) != 0) {
                ac.a(iVar, 44, this.bRl);
            }
            if ((this.bOT & 524288) != 0) {
                ac.a(iVar, 45, this.bRm);
            }
            for (int i2 = 0; i2 < this.bPB.size(); i2++) {
                iVar.a(999, this.bPB.get(i2));
            }
            GC.b(iVar);
            this.bTW.a(iVar);
        }

        @Override // com.google.a.aw, com.google.a.a, com.google.a.ac
        public final int yC() {
            int i2 = this.bNa;
            if (i2 != -1) {
                return i2;
            }
            int d2 = (this.bOT & 1) != 0 ? ac.d(1, this.bQU) + 0 : 0;
            if ((this.bOT & 2) != 0) {
                d2 += ac.d(8, this.bQV);
            }
            if ((this.bOT & 32) != 0) {
                d2 += i.bv(9, this.bQZ);
            }
            if ((this.bOT & 4) != 0) {
                d2 += i.fR(10);
            }
            if ((this.bOT & 64) != 0) {
                d2 += ac.d(11, this.bRa);
            }
            if ((this.bOT & 128) != 0) {
                d2 += i.fR(16);
            }
            if ((this.bOT & 256) != 0) {
                d2 += i.fR(17);
            }
            if ((this.bOT & 512) != 0) {
                d2 += i.fR(18);
            }
            if ((this.bOT & 8) != 0) {
                d2 += i.fR(20);
            }
            if ((this.bOT & 2048) != 0) {
                d2 += i.fR(23);
            }
            if ((this.bOT & 16) != 0) {
                d2 += i.fR(27);
            }
            if ((this.bOT & 4096) != 0) {
                d2 += i.fR(31);
            }
            if ((this.bOT & 8192) != 0) {
                d2 += ac.d(36, this.bRg);
            }
            if ((this.bOT & 16384) != 0) {
                d2 += ac.d(37, this.bRh);
            }
            if ((this.bOT & 32768) != 0) {
                d2 += ac.d(39, this.bRi);
            }
            if ((this.bOT & 65536) != 0) {
                d2 += ac.d(40, this.bRj);
            }
            if ((this.bOT & 131072) != 0) {
                d2 += ac.d(41, this.bRk);
            }
            if ((this.bOT & 1024) != 0) {
                d2 += i.fR(42);
            }
            if ((this.bOT & TPMediaCodecProfileLevel.HEVCMainTierLevel52) != 0) {
                d2 += ac.d(44, this.bRl);
            }
            if ((this.bOT & 524288) != 0) {
                d2 += ac.d(45, this.bRm);
            }
            for (int i3 = 0; i3 < this.bPB.size(); i3++) {
                d2 = i.c(999, this.bPB.get(i3)) + d2;
            }
            int yC = this.bWd.yC() + d2 + this.bTW.yC();
            this.bNa = yC;
            return yC;
        }

        @Override // com.google.a.a
        public final boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof s)) {
                return super.equals(obj);
            }
            s sVar = (s) obj;
            if (Di() != sVar.Di()) {
                return false;
            }
            if (Di() && !Dj().equals(sVar.Dj())) {
                return false;
            }
            if (Dk() != sVar.Dk()) {
                return false;
            }
            if (Dk() && !Dl().equals(sVar.Dl())) {
                return false;
            }
            if (Dm() != sVar.Dm()) {
                return false;
            }
            if (Dm() && this.bQW != sVar.bQW) {
                return false;
            }
            if (Dn() != sVar.Dn()) {
                return false;
            }
            if (Dn() && this.bQX != sVar.bQX) {
                return false;
            }
            if (Do() != sVar.Do()) {
                return false;
            }
            if (Do() && this.bQY != sVar.bQY) {
                return false;
            }
            if (Dp() != sVar.Dp()) {
                return false;
            }
            if (Dp() && this.bQZ != sVar.bQZ) {
                return false;
            }
            if (Dr() != sVar.Dr()) {
                return false;
            }
            if (Dr() && !Ds().equals(sVar.Ds())) {
                return false;
            }
            if (Dt() != sVar.Dt()) {
                return false;
            }
            if (Dt() && this.bRb != sVar.bRb) {
                return false;
            }
            if (Du() != sVar.Du()) {
                return false;
            }
            if (Du() && this.bRc != sVar.bRc) {
                return false;
            }
            if (Dv() != sVar.Dv()) {
                return false;
            }
            if (Dv() && this.bRd != sVar.bRd) {
                return false;
            }
            if (Dw() != sVar.Dw()) {
                return false;
            }
            if (Dw() && this.bRe != sVar.bRe) {
                return false;
            }
            if (BN() != sVar.BN()) {
                return false;
            }
            if (BN() && this.bPA != sVar.bPA) {
                return false;
            }
            if (Dx() != sVar.Dx()) {
                return false;
            }
            if (Dx() && this.bRf != sVar.bRf) {
                return false;
            }
            if (Dy() != sVar.Dy()) {
                return false;
            }
            if (Dy() && !Dz().equals(sVar.Dz())) {
                return false;
            }
            if (DA() != sVar.DA()) {
                return false;
            }
            if (DA() && !DB().equals(sVar.DB())) {
                return false;
            }
            if (DC() != sVar.DC()) {
                return false;
            }
            if (DC() && !DD().equals(sVar.DD())) {
                return false;
            }
            if (DE() != sVar.DE()) {
                return false;
            }
            if (DE() && !DF().equals(sVar.DF())) {
                return false;
            }
            if (DG() != sVar.DG()) {
                return false;
            }
            if (DG() && !DH().equals(sVar.DH())) {
                return false;
            }
            if (DI() != sVar.DI()) {
                return false;
            }
            if (DI() && !DJ().equals(sVar.DJ())) {
                return false;
            }
            if (DK() != sVar.DK()) {
                return false;
            }
            if (DK() && !DL().equals(sVar.DL())) {
                return false;
            }
            if (!this.bPB.equals(sVar.bPB)) {
                return false;
            }
            if (!this.bTW.equals(sVar.bTW)) {
                return false;
            }
            return this.bWd.FS().equals(sVar.bWd.FS());
        }

        @Override // com.google.a.a
        public final int hashCode() {
            if (this.bNb != 0) {
                return this.bNb;
            }
            int hashCode = k.bOq.hashCode() + com.tencent.mm.plugin.appbrand.jsapi.share.q.CTRL_INDEX;
            if (Di()) {
                hashCode = (((hashCode * 37) + 1) * 53) + Dj().hashCode();
            }
            if (Dk()) {
                hashCode = (((hashCode * 37) + 8) * 53) + Dl().hashCode();
            }
            if (Dm()) {
                hashCode = (((hashCode * 37) + 10) * 53) + ae.bF(this.bQW);
            }
            if (Dn()) {
                hashCode = (((hashCode * 37) + 20) * 53) + ae.bF(this.bQX);
            }
            if (Do()) {
                hashCode = (((hashCode * 37) + 27) * 53) + ae.bF(this.bQY);
            }
            if (Dp()) {
                hashCode = (((hashCode * 37) + 9) * 53) + this.bQZ;
            }
            if (Dr()) {
                hashCode = (((hashCode * 37) + 11) * 53) + Ds().hashCode();
            }
            if (Dt()) {
                hashCode = (((hashCode * 37) + 16) * 53) + ae.bF(this.bRb);
            }
            if (Du()) {
                hashCode = (((hashCode * 37) + 17) * 53) + ae.bF(this.bRc);
            }
            if (Dv()) {
                hashCode = (((hashCode * 37) + 18) * 53) + ae.bF(this.bRd);
            }
            if (Dw()) {
                hashCode = (((hashCode * 37) + 42) * 53) + ae.bF(this.bRe);
            }
            if (BN()) {
                hashCode = (((hashCode * 37) + 23) * 53) + ae.bF(this.bPA);
            }
            if (Dx()) {
                hashCode = (((hashCode * 37) + 31) * 53) + ae.bF(this.bRf);
            }
            if (Dy()) {
                hashCode = (((hashCode * 37) + 36) * 53) + Dz().hashCode();
            }
            if (DA()) {
                hashCode = (((hashCode * 37) + 37) * 53) + DB().hashCode();
            }
            if (DC()) {
                hashCode = (((hashCode * 37) + 39) * 53) + DD().hashCode();
            }
            if (DE()) {
                hashCode = (((hashCode * 37) + 40) * 53) + DF().hashCode();
            }
            if (DG()) {
                hashCode = (((hashCode * 37) + 41) * 53) + DH().hashCode();
            }
            if (DI()) {
                hashCode = (((hashCode * 37) + 44) * 53) + DJ().hashCode();
            }
            if (DK()) {
                hashCode = (((hashCode * 37) + 45) * 53) + DL().hashCode();
            }
            if (BO() > 0) {
                hashCode = (((hashCode * 37) + 999) * 53) + this.bPB.hashCode();
            }
            int b2 = (b(hashCode, this.bWd.FS()) * 29) + this.bTW.hashCode();
            this.bNb = b2;
            return b2;
        }

        public static a b(s sVar) {
            return bRn.AN().n(sVar);
        }

        /* renamed from: DM */
        public final a AN() {
            if (this == bRn) {
                return new a((byte) 0);
            }
            return new a((byte) 0).n(this);
        }

        public static final class a extends ac.c<s, a> implements t {
            private int bOT;
            private boolean bPA;
            private List<ak> bPB;
            private bq<ak, ak.a, al> bPD;
            private Object bQU;
            private Object bQV;
            private boolean bQW;
            private boolean bQX;
            private boolean bQY;
            private int bQZ;
            private Object bRa;
            private boolean bRb;
            private boolean bRc;
            private boolean bRd;
            private boolean bRe;
            private boolean bRf;
            private Object bRg;
            private Object bRh;
            private Object bRi;
            private Object bRj;
            private Object bRk;
            private Object bRl;
            private Object bRm;

            /* synthetic */ a(byte b2) {
                this();
            }

            /* synthetic */ a(ac.b bVar, byte b2) {
                this(bVar);
            }

            /* access modifiers changed from: protected */
            @Override // com.google.a.ac.a
            public final ac.f Ay() {
                return k.bOr.h(s.class, a.class);
            }

            private a() {
                this.bQU = "";
                this.bQV = "";
                this.bQZ = 1;
                this.bRa = "";
                this.bRg = "";
                this.bRh = "";
                this.bRi = "";
                this.bRj = "";
                this.bRk = "";
                this.bRl = "";
                this.bRm = "";
                this.bPB = Collections.emptyList();
                AR();
            }

            private a(ac.b bVar) {
                super(bVar);
                this.bQU = "";
                this.bQV = "";
                this.bQZ = 1;
                this.bRa = "";
                this.bRg = "";
                this.bRh = "";
                this.bRi = "";
                this.bRj = "";
                this.bRk = "";
                this.bRl = "";
                this.bRm = "";
                this.bPB = Collections.emptyList();
                AR();
            }

            private void AR() {
                if (ac.bVU) {
                    BU();
                }
            }

            @Override // com.google.a.az, com.google.a.ac.a, com.google.a.at.a
            public final l.a AS() {
                return k.bOq;
            }

            /* access modifiers changed from: private */
            /* renamed from: DO */
            public s Bp() {
                s DP = Bo();
                if (DP.isInitialized()) {
                    return DP;
                }
                throw b(DP);
            }

            /* renamed from: DP */
            public final s Bo() {
                int i2 = 0;
                s sVar = new s(this, (byte) 0);
                int i3 = this.bOT;
                if ((i3 & 1) != 0) {
                    i2 = 1;
                }
                sVar.bQU = this.bQU;
                if ((i3 & 2) != 0) {
                    i2 |= 2;
                }
                sVar.bQV = this.bQV;
                if ((i3 & 4) != 0) {
                    sVar.bQW = this.bQW;
                    i2 |= 4;
                }
                if ((i3 & 8) != 0) {
                    sVar.bQX = this.bQX;
                    i2 |= 8;
                }
                if ((i3 & 16) != 0) {
                    sVar.bQY = this.bQY;
                    i2 |= 16;
                }
                if ((i3 & 32) != 0) {
                    i2 |= 32;
                }
                sVar.bQZ = this.bQZ;
                if ((i3 & 64) != 0) {
                    i2 |= 64;
                }
                sVar.bRa = this.bRa;
                if ((i3 & 128) != 0) {
                    sVar.bRb = this.bRb;
                    i2 |= 128;
                }
                if ((i3 & 256) != 0) {
                    sVar.bRc = this.bRc;
                    i2 |= 256;
                }
                if ((i3 & 512) != 0) {
                    sVar.bRd = this.bRd;
                    i2 |= 512;
                }
                if ((i3 & 1024) != 0) {
                    sVar.bRe = this.bRe;
                    i2 |= 1024;
                }
                if ((i3 & 2048) != 0) {
                    sVar.bPA = this.bPA;
                    i2 |= 2048;
                }
                if ((i3 & 4096) != 0) {
                    sVar.bRf = this.bRf;
                    i2 |= 4096;
                }
                if ((i3 & 8192) != 0) {
                    i2 |= 8192;
                }
                sVar.bRg = this.bRg;
                if ((i3 & 16384) != 0) {
                    i2 |= 16384;
                }
                sVar.bRh = this.bRh;
                if ((i3 & 32768) != 0) {
                    i2 |= 32768;
                }
                sVar.bRi = this.bRi;
                if ((i3 & 65536) != 0) {
                    i2 |= 65536;
                }
                sVar.bRj = this.bRj;
                if ((i3 & 131072) != 0) {
                    i2 |= 131072;
                }
                sVar.bRk = this.bRk;
                if ((i3 & TPMediaCodecProfileLevel.HEVCMainTierLevel52) != 0) {
                    i2 |= TPMediaCodecProfileLevel.HEVCMainTierLevel52;
                }
                sVar.bRl = this.bRl;
                if ((i3 & 524288) != 0) {
                    i2 |= 524288;
                }
                sVar.bRm = this.bRm;
                if (this.bPD == null) {
                    if ((this.bOT & 1048576) != 0) {
                        this.bPB = Collections.unmodifiableList(this.bPB);
                        this.bOT &= -1048577;
                    }
                    sVar.bPB = this.bPB;
                } else {
                    sVar.bPB = this.bPD.build();
                }
                sVar.bOT = i2;
                Gy();
                return sVar;
            }

            /* access modifiers changed from: private */
            /* renamed from: E */
            public a r(l.f fVar, Object obj) {
                return (a) super.f(fVar, obj);
            }

            /* access modifiers changed from: private */
            /* renamed from: F */
            public a q(l.f fVar, Object obj) {
                return (a) super.e(fVar, obj);
            }

            /* access modifiers changed from: private */
            /* renamed from: p */
            public a c(at atVar) {
                if (atVar instanceof s) {
                    return n((s) atVar);
                }
                super.c(atVar);
                return this;
            }

            public final a n(s sVar) {
                bq<ak, ak.a, al> bqVar = null;
                if (sVar != s.DN()) {
                    if (sVar.Di()) {
                        this.bOT |= 1;
                        this.bQU = sVar.bQU;
                        onChanged();
                    }
                    if (sVar.Dk()) {
                        this.bOT |= 2;
                        this.bQV = sVar.bQV;
                        onChanged();
                    }
                    if (sVar.Dm()) {
                        bm(sVar.bQW);
                    }
                    if (sVar.Dn()) {
                        bn(sVar.bQX);
                    }
                    if (sVar.Do()) {
                        bo(sVar.bQY);
                    }
                    if (sVar.Dp()) {
                        a(sVar.Dq());
                    }
                    if (sVar.Dr()) {
                        this.bOT |= 64;
                        this.bRa = sVar.bRa;
                        onChanged();
                    }
                    if (sVar.Dt()) {
                        bp(sVar.bRb);
                    }
                    if (sVar.Du()) {
                        bq(sVar.bRc);
                    }
                    if (sVar.Dv()) {
                        br(sVar.bRd);
                    }
                    if (sVar.Dw()) {
                        bs(sVar.bRe);
                    }
                    if (sVar.BN()) {
                        bt(sVar.bPA);
                    }
                    if (sVar.Dx()) {
                        bu(sVar.bRf);
                    }
                    if (sVar.Dy()) {
                        this.bOT |= 8192;
                        this.bRg = sVar.bRg;
                        onChanged();
                    }
                    if (sVar.DA()) {
                        this.bOT |= 16384;
                        this.bRh = sVar.bRh;
                        onChanged();
                    }
                    if (sVar.DC()) {
                        this.bOT |= 32768;
                        this.bRi = sVar.bRi;
                        onChanged();
                    }
                    if (sVar.DE()) {
                        this.bOT |= 65536;
                        this.bRj = sVar.bRj;
                        onChanged();
                    }
                    if (sVar.DG()) {
                        this.bOT |= 131072;
                        this.bRk = sVar.bRk;
                        onChanged();
                    }
                    if (sVar.DI()) {
                        this.bOT |= TPMediaCodecProfileLevel.HEVCMainTierLevel52;
                        this.bRl = sVar.bRl;
                        onChanged();
                    }
                    if (sVar.DK()) {
                        this.bOT |= 524288;
                        this.bRm = sVar.bRm;
                        onChanged();
                    }
                    if (this.bPD == null) {
                        if (!sVar.bPB.isEmpty()) {
                            if (this.bPB.isEmpty()) {
                                this.bPB = sVar.bPB;
                                this.bOT &= -1048577;
                            } else {
                                BT();
                                this.bPB.addAll(sVar.bPB);
                            }
                            onChanged();
                        }
                    } else if (!sVar.bPB.isEmpty()) {
                        if (this.bPD.isEmpty()) {
                            this.bPD.bYP = null;
                            this.bPD = null;
                            this.bPB = sVar.bPB;
                            this.bOT &= -1048577;
                            if (ac.bVU) {
                                bqVar = BU();
                            }
                            this.bPD = bqVar;
                        } else {
                            this.bPD.a(sVar.bPB);
                        }
                    }
                    a((ac.d) sVar);
                    d(sVar.bTW);
                    onChanged();
                }
                return this;
            }

            @Override // com.google.a.ax, com.google.a.ac.c, com.google.a.ac.a
            public final boolean isInitialized() {
                int count;
                ak s;
                int i2 = 0;
                while (true) {
                    if (this.bPD == null) {
                        count = this.bPB.size();
                    } else {
                        count = this.bPD.getCount();
                    }
                    if (i2 < count) {
                        if (this.bPD == null) {
                            s = this.bPB.get(i2);
                        } else {
                            s = this.bPD.s(i2, false);
                        }
                        if (!s.isInitialized()) {
                            return false;
                        }
                        i2++;
                    } else if (this.bWd.isInitialized()) {
                        return true;
                    } else {
                        return false;
                    }
                }
            }

            /* access modifiers changed from: private */
            /* JADX WARNING: Removed duplicated region for block: B:16:0x001e  */
            /* renamed from: q */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public com.google.a.k.s.a c(com.google.a.h r4, com.google.a.r r5) {
                /*
                    r3 = this;
                    r2 = 0
                    com.google.a.bj<com.google.a.k$s> r0 = com.google.a.k.s.bPg     // Catch:{ af -> 0x000f }
                    java.lang.Object r0 = r0.d(r4, r5)     // Catch:{ af -> 0x000f }
                    com.google.a.k$s r0 = (com.google.a.k.s) r0     // Catch:{ af -> 0x000f }
                    if (r0 == 0) goto L_0x000e
                    r3.n(r0)
                L_0x000e:
                    return r3
                L_0x000f:
                    r0 = move-exception
                    r1 = r0
                    com.google.a.aw r0 = r1.bXr     // Catch:{ all -> 0x0022 }
                    com.google.a.k$s r0 = (com.google.a.k.s) r0     // Catch:{ all -> 0x0022 }
                    java.io.IOException r1 = r1.GF()     // Catch:{ all -> 0x001a }
                    throw r1     // Catch:{ all -> 0x001a }
                L_0x001a:
                    r1 = move-exception
                    r2 = r0
                L_0x001c:
                    if (r2 == 0) goto L_0x0021
                    r3.n(r2)
                L_0x0021:
                    throw r1
                L_0x0022:
                    r0 = move-exception
                    r1 = r0
                    goto L_0x001c
                */
                throw new UnsupportedOperationException("Method not decompiled: com.google.a.k.s.a.c(com.google.a.h, com.google.a.r):com.google.a.k$s$a");
            }

            private a bm(boolean z) {
                this.bOT |= 4;
                this.bQW = z;
                onChanged();
                return this;
            }

            @Deprecated
            private a bn(boolean z) {
                this.bOT |= 8;
                this.bQX = z;
                onChanged();
                return this;
            }

            private a bo(boolean z) {
                this.bOT |= 16;
                this.bQY = z;
                onChanged();
                return this;
            }

            private a a(b bVar) {
                if (bVar == null) {
                    throw new NullPointerException();
                }
                this.bOT |= 32;
                this.bQZ = bVar.value;
                onChanged();
                return this;
            }

            private a bp(boolean z) {
                this.bOT |= 128;
                this.bRb = z;
                onChanged();
                return this;
            }

            private a bq(boolean z) {
                this.bOT |= 256;
                this.bRc = z;
                onChanged();
                return this;
            }

            private a br(boolean z) {
                this.bOT |= 512;
                this.bRd = z;
                onChanged();
                return this;
            }

            private a bs(boolean z) {
                this.bOT |= 1024;
                this.bRe = z;
                onChanged();
                return this;
            }

            private a bt(boolean z) {
                this.bOT |= 2048;
                this.bPA = z;
                onChanged();
                return this;
            }

            private a bu(boolean z) {
                this.bOT |= 4096;
                this.bRf = z;
                onChanged();
                return this;
            }

            private void BT() {
                if ((this.bOT & 1048576) == 0) {
                    this.bPB = new ArrayList(this.bPB);
                    this.bOT |= 1048576;
                }
            }

            private bq<ak, ak.a, al> BU() {
                if (this.bPD == null) {
                    this.bPD = new bq<>(this.bPB, (this.bOT & 1048576) != 0, GA(), this.bWv);
                    this.bPB = null;
                }
                return this.bPD;
            }

            /* access modifiers changed from: private */
            /* renamed from: C */
            public a f(cc ccVar) {
                return (a) super.f(ccVar);
            }

            /* access modifiers changed from: private */
            /* renamed from: D */
            public a d(cc ccVar) {
                return (a) super.a(ccVar);
            }

            @Override // com.google.a.az
            public final /* synthetic */ at AQ() {
                return s.DN();
            }

            @Override // com.google.a.ax
            public final /* synthetic */ aw AP() {
                return s.DN();
            }

            @Override // com.google.a.ac.a
            public final /* bridge */ /* synthetic */ ac.a Bl() {
                return (a) super.yG();
            }

            @Override // com.google.a.a.AbstractC0085a, com.google.a.ac.a
            public final /* synthetic */ a.AbstractC0085a yE() {
                return (a) super.yG();
            }

            @Override // com.google.a.b.a, com.google.a.a.AbstractC0085a, com.google.a.ac.a
            public final /* synthetic */ b.a yG() {
                return (a) super.yG();
            }

            @Override // com.google.a.b.a, com.google.a.a.AbstractC0085a, java.lang.Object, com.google.a.ac.a
            public final /* synthetic */ Object clone() {
                return (a) super.yG();
            }
        }

        public static s DN() {
            return bRn;
        }

        @Override // com.google.a.aw, com.google.a.ac
        public final bj<s> AK() {
            return bPg;
        }

        @Override // com.google.a.az
        public final /* bridge */ /* synthetic */ at AQ() {
            return bRn;
        }

        @Override // com.google.a.ax
        public final /* bridge */ /* synthetic */ aw AP() {
            return bRn;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.a.ac
        public final /* synthetic */ at.a a(ac.b bVar) {
            return new a(bVar, (byte) 0);
        }

        @Override // com.google.a.at
        public final /* synthetic */ at.a AM() {
            return bRn.AN();
        }

        @Override // com.google.a.aw
        public final /* synthetic */ aw.a AO() {
            return bRn.AN();
        }
    }

    public static final class u extends ac.d<u> implements v {
        @Deprecated
        public static final bj<u> bPg = new c<u>() {
            /* class com.google.a.k.u.AnonymousClass1 */

            @Override // com.google.a.bj
            public final /* synthetic */ Object d(h hVar, r rVar) {
                return new u(hVar, rVar, (byte) 0);
            }
        };
        private static final u bRw = new u();
        private int bOT;
        boolean bPA;
        private List<ak> bPB;
        private byte bPe;
        boolean bRt;
        boolean bRu;
        boolean bRv;

        /* synthetic */ u(ac.c cVar, byte b2) {
            this(cVar);
        }

        /* synthetic */ u(h hVar, r rVar, byte b2) {
            this(hVar, rVar);
        }

        private u(ac.c<u, ?> cVar) {
            super(cVar);
            this.bPe = -1;
        }

        private u() {
            this.bPe = -1;
            this.bPB = Collections.emptyList();
        }

        @Override // com.google.a.az, com.google.a.ac
        public final cc Ax() {
            return this.bTW;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r3v3, resolved type: java.util.List<com.google.a.k$ak> */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARNING: Removed duplicated region for block: B:23:0x003e  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private u(com.google.a.h r7, com.google.a.r r8) {
            /*
            // Method dump skipped, instructions count: 208
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.a.k.u.<init>(com.google.a.h, com.google.a.r):void");
        }

        /* access modifiers changed from: protected */
        @Override // com.google.a.ac
        public final ac.f Ay() {
            return k.bOt.h(u.class, a.class);
        }

        public final boolean DQ() {
            return (this.bOT & 1) != 0;
        }

        public final boolean DR() {
            return (this.bOT & 2) != 0;
        }

        public final boolean BN() {
            return (this.bOT & 4) != 0;
        }

        public final boolean DS() {
            return (this.bOT & 8) != 0;
        }

        private int BO() {
            return this.bPB.size();
        }

        @Override // com.google.a.a, com.google.a.ax, com.google.a.ac.d, com.google.a.ac
        public final boolean isInitialized() {
            byte b2 = this.bPe;
            if (b2 == 1) {
                return true;
            }
            if (b2 == 0) {
                return false;
            }
            for (int i2 = 0; i2 < BO(); i2++) {
                if (!this.bPB.get(i2).isInitialized()) {
                    this.bPe = 0;
                    return false;
                }
            }
            if (!this.bWd.isInitialized()) {
                this.bPe = 0;
                return false;
            }
            this.bPe = 1;
            return true;
        }

        @Override // com.google.a.aw, com.google.a.a, com.google.a.ac
        public final void a(i iVar) {
            ac.d<MessageType>.a GC = GC();
            if ((this.bOT & 1) != 0) {
                iVar.r(1, this.bRt);
            }
            if ((this.bOT & 2) != 0) {
                iVar.r(2, this.bRu);
            }
            if ((this.bOT & 4) != 0) {
                iVar.r(3, this.bPA);
            }
            if ((this.bOT & 8) != 0) {
                iVar.r(7, this.bRv);
            }
            for (int i2 = 0; i2 < this.bPB.size(); i2++) {
                iVar.a(999, this.bPB.get(i2));
            }
            GC.b(iVar);
            this.bTW.a(iVar);
        }

        @Override // com.google.a.aw, com.google.a.a, com.google.a.ac
        public final int yC() {
            int i2 = this.bNa;
            if (i2 != -1) {
                return i2;
            }
            int fR = (this.bOT & 1) != 0 ? i.fR(1) + 0 : 0;
            if ((this.bOT & 2) != 0) {
                fR += i.fR(2);
            }
            if ((this.bOT & 4) != 0) {
                fR += i.fR(3);
            }
            if ((this.bOT & 8) != 0) {
                fR += i.fR(7);
            }
            for (int i3 = 0; i3 < this.bPB.size(); i3++) {
                fR = i.c(999, this.bPB.get(i3)) + fR;
            }
            int yC = this.bWd.yC() + fR + this.bTW.yC();
            this.bNa = yC;
            return yC;
        }

        @Override // com.google.a.a
        public final boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof u)) {
                return super.equals(obj);
            }
            u uVar = (u) obj;
            if (DQ() != uVar.DQ()) {
                return false;
            }
            if (DQ() && this.bRt != uVar.bRt) {
                return false;
            }
            if (DR() != uVar.DR()) {
                return false;
            }
            if (DR() && this.bRu != uVar.bRu) {
                return false;
            }
            if (BN() != uVar.BN()) {
                return false;
            }
            if (BN() && this.bPA != uVar.bPA) {
                return false;
            }
            if (DS() != uVar.DS()) {
                return false;
            }
            if (DS() && this.bRv != uVar.bRv) {
                return false;
            }
            if (!this.bPB.equals(uVar.bPB)) {
                return false;
            }
            if (!this.bTW.equals(uVar.bTW)) {
                return false;
            }
            return this.bWd.FS().equals(uVar.bWd.FS());
        }

        @Override // com.google.a.a
        public final int hashCode() {
            if (this.bNb != 0) {
                return this.bNb;
            }
            int hashCode = k.bOs.hashCode() + com.tencent.mm.plugin.appbrand.jsapi.share.q.CTRL_INDEX;
            if (DQ()) {
                hashCode = (((hashCode * 37) + 1) * 53) + ae.bF(this.bRt);
            }
            if (DR()) {
                hashCode = (((hashCode * 37) + 2) * 53) + ae.bF(this.bRu);
            }
            if (BN()) {
                hashCode = (((hashCode * 37) + 3) * 53) + ae.bF(this.bPA);
            }
            if (DS()) {
                hashCode = (((hashCode * 37) + 7) * 53) + ae.bF(this.bRv);
            }
            if (BO() > 0) {
                hashCode = (((hashCode * 37) + 999) * 53) + this.bPB.hashCode();
            }
            int b2 = (b(hashCode, this.bWd.FS()) * 29) + this.bTW.hashCode();
            this.bNb = b2;
            return b2;
        }

        public static a b(u uVar) {
            return bRw.AN().d(uVar);
        }

        /* renamed from: DT */
        public final a AN() {
            if (this == bRw) {
                return new a((byte) 0);
            }
            return new a((byte) 0).d(this);
        }

        public static final class a extends ac.c<u, a> implements v {
            private int bOT;
            private boolean bPA;
            private List<ak> bPB;
            private bq<ak, ak.a, al> bPD;
            private boolean bRt;
            private boolean bRu;
            private boolean bRv;

            /* synthetic */ a(byte b2) {
                this();
            }

            /* synthetic */ a(ac.b bVar, byte b2) {
                this(bVar);
            }

            /* access modifiers changed from: protected */
            @Override // com.google.a.ac.a
            public final ac.f Ay() {
                return k.bOt.h(u.class, a.class);
            }

            private a() {
                this.bPB = Collections.emptyList();
                AR();
            }

            private a(ac.b bVar) {
                super(bVar);
                this.bPB = Collections.emptyList();
                AR();
            }

            private void AR() {
                if (ac.bVU) {
                    BU();
                }
            }

            @Override // com.google.a.az, com.google.a.ac.a, com.google.a.at.a
            public final l.a AS() {
                return k.bOs;
            }

            /* access modifiers changed from: private */
            /* renamed from: DV */
            public u Bp() {
                u DW = Bo();
                if (DW.isInitialized()) {
                    return DW;
                }
                throw b(DW);
            }

            /* renamed from: DW */
            public final u Bo() {
                int i2 = 0;
                u uVar = new u(this, (byte) 0);
                int i3 = this.bOT;
                if ((i3 & 1) != 0) {
                    uVar.bRt = this.bRt;
                    i2 = 1;
                }
                if ((i3 & 2) != 0) {
                    uVar.bRu = this.bRu;
                    i2 |= 2;
                }
                if ((i3 & 4) != 0) {
                    uVar.bPA = this.bPA;
                    i2 |= 4;
                }
                if ((i3 & 8) != 0) {
                    uVar.bRv = this.bRv;
                    i2 |= 8;
                }
                if (this.bPD == null) {
                    if ((this.bOT & 16) != 0) {
                        this.bPB = Collections.unmodifiableList(this.bPB);
                        this.bOT &= -17;
                    }
                    uVar.bPB = this.bPB;
                } else {
                    uVar.bPB = this.bPD.build();
                }
                uVar.bOT = i2;
                Gy();
                return uVar;
            }

            /* access modifiers changed from: private */
            /* renamed from: G */
            public a r(l.f fVar, Object obj) {
                return (a) super.f(fVar, obj);
            }

            /* access modifiers changed from: private */
            /* renamed from: H */
            public a q(l.f fVar, Object obj) {
                return (a) super.e(fVar, obj);
            }

            /* access modifiers changed from: private */
            /* renamed from: q */
            public a c(at atVar) {
                if (atVar instanceof u) {
                    return d((u) atVar);
                }
                super.c(atVar);
                return this;
            }

            public final a d(u uVar) {
                bq<ak, ak.a, al> bqVar = null;
                if (uVar != u.DU()) {
                    if (uVar.DQ()) {
                        bv(uVar.bRt);
                    }
                    if (uVar.DR()) {
                        bw(uVar.bRu);
                    }
                    if (uVar.BN()) {
                        bx(uVar.bPA);
                    }
                    if (uVar.DS()) {
                        by(uVar.bRv);
                    }
                    if (this.bPD == null) {
                        if (!uVar.bPB.isEmpty()) {
                            if (this.bPB.isEmpty()) {
                                this.bPB = uVar.bPB;
                                this.bOT &= -17;
                            } else {
                                BT();
                                this.bPB.addAll(uVar.bPB);
                            }
                            onChanged();
                        }
                    } else if (!uVar.bPB.isEmpty()) {
                        if (this.bPD.isEmpty()) {
                            this.bPD.bYP = null;
                            this.bPD = null;
                            this.bPB = uVar.bPB;
                            this.bOT &= -17;
                            if (ac.bVU) {
                                bqVar = BU();
                            }
                            this.bPD = bqVar;
                        } else {
                            this.bPD.a(uVar.bPB);
                        }
                    }
                    a((ac.d) uVar);
                    d(uVar.bTW);
                    onChanged();
                }
                return this;
            }

            @Override // com.google.a.ax, com.google.a.ac.c, com.google.a.ac.a
            public final boolean isInitialized() {
                int count;
                ak s;
                int i2 = 0;
                while (true) {
                    if (this.bPD == null) {
                        count = this.bPB.size();
                    } else {
                        count = this.bPD.getCount();
                    }
                    if (i2 < count) {
                        if (this.bPD == null) {
                            s = this.bPB.get(i2);
                        } else {
                            s = this.bPD.s(i2, false);
                        }
                        if (!s.isInitialized()) {
                            return false;
                        }
                        i2++;
                    } else if (this.bWd.isInitialized()) {
                        return true;
                    } else {
                        return false;
                    }
                }
            }

            /* access modifiers changed from: private */
            /* JADX WARNING: Removed duplicated region for block: B:16:0x001e  */
            /* renamed from: r */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public com.google.a.k.u.a c(com.google.a.h r4, com.google.a.r r5) {
                /*
                    r3 = this;
                    r2 = 0
                    com.google.a.bj<com.google.a.k$u> r0 = com.google.a.k.u.bPg     // Catch:{ af -> 0x000f }
                    java.lang.Object r0 = r0.d(r4, r5)     // Catch:{ af -> 0x000f }
                    com.google.a.k$u r0 = (com.google.a.k.u) r0     // Catch:{ af -> 0x000f }
                    if (r0 == 0) goto L_0x000e
                    r3.d(r0)
                L_0x000e:
                    return r3
                L_0x000f:
                    r0 = move-exception
                    r1 = r0
                    com.google.a.aw r0 = r1.bXr     // Catch:{ all -> 0x0022 }
                    com.google.a.k$u r0 = (com.google.a.k.u) r0     // Catch:{ all -> 0x0022 }
                    java.io.IOException r1 = r1.GF()     // Catch:{ all -> 0x001a }
                    throw r1     // Catch:{ all -> 0x001a }
                L_0x001a:
                    r1 = move-exception
                    r2 = r0
                L_0x001c:
                    if (r2 == 0) goto L_0x0021
                    r3.d(r2)
                L_0x0021:
                    throw r1
                L_0x0022:
                    r0 = move-exception
                    r1 = r0
                    goto L_0x001c
                */
                throw new UnsupportedOperationException("Method not decompiled: com.google.a.k.u.a.c(com.google.a.h, com.google.a.r):com.google.a.k$u$a");
            }

            private a bv(boolean z) {
                this.bOT |= 1;
                this.bRt = z;
                onChanged();
                return this;
            }

            private a bw(boolean z) {
                this.bOT |= 2;
                this.bRu = z;
                onChanged();
                return this;
            }

            private a bx(boolean z) {
                this.bOT |= 4;
                this.bPA = z;
                onChanged();
                return this;
            }

            private a by(boolean z) {
                this.bOT |= 8;
                this.bRv = z;
                onChanged();
                return this;
            }

            private void BT() {
                if ((this.bOT & 16) == 0) {
                    this.bPB = new ArrayList(this.bPB);
                    this.bOT |= 16;
                }
            }

            private bq<ak, ak.a, al> BU() {
                if (this.bPD == null) {
                    this.bPD = new bq<>(this.bPB, (this.bOT & 16) != 0, GA(), this.bWv);
                    this.bPB = null;
                }
                return this.bPD;
            }

            /* access modifiers changed from: private */
            /* renamed from: E */
            public a f(cc ccVar) {
                return (a) super.f(ccVar);
            }

            /* access modifiers changed from: private */
            /* renamed from: F */
            public a d(cc ccVar) {
                return (a) super.a(ccVar);
            }

            @Override // com.google.a.az
            public final /* synthetic */ at AQ() {
                return u.DU();
            }

            @Override // com.google.a.ax
            public final /* synthetic */ aw AP() {
                return u.DU();
            }

            @Override // com.google.a.ac.a
            public final /* bridge */ /* synthetic */ ac.a Bl() {
                return (a) super.yG();
            }

            @Override // com.google.a.a.AbstractC0085a, com.google.a.ac.a
            public final /* synthetic */ a.AbstractC0085a yE() {
                return (a) super.yG();
            }

            @Override // com.google.a.b.a, com.google.a.a.AbstractC0085a, com.google.a.ac.a
            public final /* synthetic */ b.a yG() {
                return (a) super.yG();
            }

            @Override // com.google.a.b.a, com.google.a.a.AbstractC0085a, java.lang.Object, com.google.a.ac.a
            public final /* synthetic */ Object clone() {
                return (a) super.yG();
            }
        }

        public static u DU() {
            return bRw;
        }

        @Override // com.google.a.aw, com.google.a.ac
        public final bj<u> AK() {
            return bPg;
        }

        @Override // com.google.a.az
        public final /* bridge */ /* synthetic */ at AQ() {
            return bRw;
        }

        @Override // com.google.a.ax
        public final /* bridge */ /* synthetic */ aw AP() {
            return bRw;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.a.ac
        public final /* synthetic */ at.a a(ac.b bVar) {
            return new a(bVar, (byte) 0);
        }

        @Override // com.google.a.at
        public final /* synthetic */ at.a AM() {
            return bRw.AN();
        }

        @Override // com.google.a.aw
        public final /* synthetic */ aw.a AO() {
            return bRw.AN();
        }
    }

    public static final class o extends ac.d<o> implements p {
        @Deprecated
        public static final bj<o> bPg = new c<o>() {
            /* class com.google.a.k.o.AnonymousClass1 */

            @Override // com.google.a.bj
            public final /* synthetic */ Object d(h hVar, r rVar) {
                return new o(hVar, rVar, (byte) 0);
            }
        };
        private static final o bQw = new o();
        private int bOT;
        boolean bPA;
        private List<ak> bPB;
        private byte bPe;
        private int bQr;
        boolean bQs;
        private int bQt;
        boolean bQu;
        boolean bQv;

        /* synthetic */ o(ac.c cVar, byte b2) {
            this(cVar);
        }

        /* synthetic */ o(h hVar, r rVar, byte b2) {
            this(hVar, rVar);
        }

        private o(ac.c<o, ?> cVar) {
            super(cVar);
            this.bPe = -1;
        }

        private o() {
            this.bPe = -1;
            this.bQr = 0;
            this.bQt = 0;
            this.bPB = Collections.emptyList();
        }

        @Override // com.google.a.az, com.google.a.ac
        public final cc Ax() {
            return this.bTW;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r3v3, resolved type: java.util.List<com.google.a.k$ak> */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARNING: Removed duplicated region for block: B:25:0x0040  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private o(com.google.a.h r7, com.google.a.r r8) {
            /*
            // Method dump skipped, instructions count: 268
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.a.k.o.<init>(com.google.a.h, com.google.a.r):void");
        }

        /* access modifiers changed from: protected */
        @Override // com.google.a.ac
        public final ac.f Ay() {
            return k.bOv.h(o.class, a.class);
        }

        public enum b implements bn {
            STRING(0),
            CORD(1),
            STRING_PIECE(2);
            
            private static final ae.b<b> bPU = new ae.b<b>() {
                /* class com.google.a.k.o.b.AnonymousClass1 */
            };
            private static final b[] bQA = values();
            final int value;

            @Override // com.google.a.ae.a
            public final int getNumber() {
                return this.value;
            }

            private b(int i2) {
                this.value = i2;
            }

            @Deprecated
            public static b gr(int i2) {
                switch (i2) {
                    case 0:
                        return STRING;
                    case 1:
                        return CORD;
                    case 2:
                        return STRING_PIECE;
                    default:
                        return null;
                }
            }
        }

        public enum c implements bn {
            JS_NORMAL(0),
            JS_STRING(1),
            JS_NUMBER(2);
            
            private static final ae.b<c> bPU = new ae.b<c>() {
                /* class com.google.a.k.o.c.AnonymousClass1 */
            };
            private static final c[] bQF = values();
            final int value;

            @Override // com.google.a.ae.a
            public final int getNumber() {
                return this.value;
            }

            private c(int i2) {
                this.value = i2;
            }

            @Deprecated
            public static c gs(int i2) {
                switch (i2) {
                    case 0:
                        return JS_NORMAL;
                    case 1:
                        return JS_STRING;
                    case 2:
                        return JS_NUMBER;
                    default:
                        return null;
                }
            }
        }

        public final boolean CA() {
            return (this.bOT & 1) != 0;
        }

        public final b CB() {
            b gr = b.gr(this.bQr);
            return gr == null ? b.STRING : gr;
        }

        public final boolean CC() {
            return (this.bOT & 2) != 0;
        }

        public final boolean CD() {
            return (this.bOT & 4) != 0;
        }

        public final c CE() {
            c gs = c.gs(this.bQt);
            return gs == null ? c.JS_NORMAL : gs;
        }

        public final boolean CF() {
            return (this.bOT & 8) != 0;
        }

        public final boolean BN() {
            return (this.bOT & 16) != 0;
        }

        public final boolean CG() {
            return (this.bOT & 32) != 0;
        }

        private int BO() {
            return this.bPB.size();
        }

        @Override // com.google.a.a, com.google.a.ax, com.google.a.ac.d, com.google.a.ac
        public final boolean isInitialized() {
            byte b2 = this.bPe;
            if (b2 == 1) {
                return true;
            }
            if (b2 == 0) {
                return false;
            }
            for (int i2 = 0; i2 < BO(); i2++) {
                if (!this.bPB.get(i2).isInitialized()) {
                    this.bPe = 0;
                    return false;
                }
            }
            if (!this.bWd.isInitialized()) {
                this.bPe = 0;
                return false;
            }
            this.bPe = 1;
            return true;
        }

        @Override // com.google.a.aw, com.google.a.a, com.google.a.ac
        public final void a(i iVar) {
            ac.d<MessageType>.a GC = GC();
            if ((this.bOT & 1) != 0) {
                iVar.bs(1, this.bQr);
            }
            if ((this.bOT & 2) != 0) {
                iVar.r(2, this.bQs);
            }
            if ((this.bOT & 16) != 0) {
                iVar.r(3, this.bPA);
            }
            if ((this.bOT & 8) != 0) {
                iVar.r(5, this.bQu);
            }
            if ((this.bOT & 4) != 0) {
                iVar.bs(6, this.bQt);
            }
            if ((this.bOT & 32) != 0) {
                iVar.r(10, this.bQv);
            }
            for (int i2 = 0; i2 < this.bPB.size(); i2++) {
                iVar.a(999, this.bPB.get(i2));
            }
            GC.b(iVar);
            this.bTW.a(iVar);
        }

        @Override // com.google.a.aw, com.google.a.a, com.google.a.ac
        public final int yC() {
            int i2 = this.bNa;
            if (i2 != -1) {
                return i2;
            }
            int bv = (this.bOT & 1) != 0 ? i.bv(1, this.bQr) + 0 : 0;
            if ((this.bOT & 2) != 0) {
                bv += i.fR(2);
            }
            if ((this.bOT & 16) != 0) {
                bv += i.fR(3);
            }
            if ((this.bOT & 8) != 0) {
                bv += i.fR(5);
            }
            if ((this.bOT & 4) != 0) {
                bv += i.bv(6, this.bQt);
            }
            if ((this.bOT & 32) != 0) {
                bv += i.fR(10);
            }
            for (int i3 = 0; i3 < this.bPB.size(); i3++) {
                bv = i.c(999, this.bPB.get(i3)) + bv;
            }
            int yC = this.bWd.yC() + bv + this.bTW.yC();
            this.bNa = yC;
            return yC;
        }

        @Override // com.google.a.a
        public final boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof o)) {
                return super.equals(obj);
            }
            o oVar = (o) obj;
            if (CA() != oVar.CA()) {
                return false;
            }
            if (CA() && this.bQr != oVar.bQr) {
                return false;
            }
            if (CC() != oVar.CC()) {
                return false;
            }
            if (CC() && this.bQs != oVar.bQs) {
                return false;
            }
            if (CD() != oVar.CD()) {
                return false;
            }
            if (CD() && this.bQt != oVar.bQt) {
                return false;
            }
            if (CF() != oVar.CF()) {
                return false;
            }
            if (CF() && this.bQu != oVar.bQu) {
                return false;
            }
            if (BN() != oVar.BN()) {
                return false;
            }
            if (BN() && this.bPA != oVar.bPA) {
                return false;
            }
            if (CG() != oVar.CG()) {
                return false;
            }
            if (CG() && this.bQv != oVar.bQv) {
                return false;
            }
            if (!this.bPB.equals(oVar.bPB)) {
                return false;
            }
            if (!this.bTW.equals(oVar.bTW)) {
                return false;
            }
            return this.bWd.FS().equals(oVar.bWd.FS());
        }

        @Override // com.google.a.a
        public final int hashCode() {
            if (this.bNb != 0) {
                return this.bNb;
            }
            int hashCode = k.bOu.hashCode() + com.tencent.mm.plugin.appbrand.jsapi.share.q.CTRL_INDEX;
            if (CA()) {
                hashCode = (((hashCode * 37) + 1) * 53) + this.bQr;
            }
            if (CC()) {
                hashCode = (((hashCode * 37) + 2) * 53) + ae.bF(this.bQs);
            }
            if (CD()) {
                hashCode = (((hashCode * 37) + 6) * 53) + this.bQt;
            }
            if (CF()) {
                hashCode = (((hashCode * 37) + 5) * 53) + ae.bF(this.bQu);
            }
            if (BN()) {
                hashCode = (((hashCode * 37) + 3) * 53) + ae.bF(this.bPA);
            }
            if (CG()) {
                hashCode = (((hashCode * 37) + 10) * 53) + ae.bF(this.bQv);
            }
            if (BO() > 0) {
                hashCode = (((hashCode * 37) + 999) * 53) + this.bPB.hashCode();
            }
            int b2 = (b(hashCode, this.bWd.FS()) * 29) + this.bTW.hashCode();
            this.bNb = b2;
            return b2;
        }

        public static a b(o oVar) {
            return bQw.AN().d(oVar);
        }

        /* renamed from: CH */
        public final a AN() {
            if (this == bQw) {
                return new a((byte) 0);
            }
            return new a((byte) 0).d(this);
        }

        public static final class a extends ac.c<o, a> implements p {
            private int bOT;
            private boolean bPA;
            private List<ak> bPB;
            private bq<ak, ak.a, al> bPD;
            private int bQr;
            private boolean bQs;
            private int bQt;
            private boolean bQu;
            private boolean bQv;

            /* synthetic */ a(byte b2) {
                this();
            }

            /* synthetic */ a(ac.b bVar, byte b2) {
                this(bVar);
            }

            /* access modifiers changed from: protected */
            @Override // com.google.a.ac.a
            public final ac.f Ay() {
                return k.bOv.h(o.class, a.class);
            }

            private a() {
                this.bQr = 0;
                this.bQt = 0;
                this.bPB = Collections.emptyList();
                AR();
            }

            private a(ac.b bVar) {
                super(bVar);
                this.bQr = 0;
                this.bQt = 0;
                this.bPB = Collections.emptyList();
                AR();
            }

            private void AR() {
                if (ac.bVU) {
                    BU();
                }
            }

            @Override // com.google.a.az, com.google.a.ac.a, com.google.a.at.a
            public final l.a AS() {
                return k.bOu;
            }

            /* access modifiers changed from: private */
            /* renamed from: CJ */
            public o Bp() {
                o CK = Bo();
                if (CK.isInitialized()) {
                    return CK;
                }
                throw b(CK);
            }

            /* renamed from: CK */
            public final o Bo() {
                int i2 = 0;
                o oVar = new o(this, (byte) 0);
                int i3 = this.bOT;
                if ((i3 & 1) != 0) {
                    i2 = 1;
                }
                oVar.bQr = this.bQr;
                if ((i3 & 2) != 0) {
                    oVar.bQs = this.bQs;
                    i2 |= 2;
                }
                if ((i3 & 4) != 0) {
                    i2 |= 4;
                }
                oVar.bQt = this.bQt;
                if ((i3 & 8) != 0) {
                    oVar.bQu = this.bQu;
                    i2 |= 8;
                }
                if ((i3 & 16) != 0) {
                    oVar.bPA = this.bPA;
                    i2 |= 16;
                }
                if ((i3 & 32) != 0) {
                    oVar.bQv = this.bQv;
                    i2 |= 32;
                }
                if (this.bPD == null) {
                    if ((this.bOT & 64) != 0) {
                        this.bPB = Collections.unmodifiableList(this.bPB);
                        this.bOT &= -65;
                    }
                    oVar.bPB = this.bPB;
                } else {
                    oVar.bPB = this.bPD.build();
                }
                oVar.bOT = i2;
                Gy();
                return oVar;
            }

            /* access modifiers changed from: private */
            /* renamed from: A */
            public a r(l.f fVar, Object obj) {
                return (a) super.f(fVar, obj);
            }

            /* access modifiers changed from: private */
            /* renamed from: B */
            public a q(l.f fVar, Object obj) {
                return (a) super.e(fVar, obj);
            }

            /* access modifiers changed from: private */
            /* renamed from: n */
            public a c(at atVar) {
                if (atVar instanceof o) {
                    return d((o) atVar);
                }
                super.c(atVar);
                return this;
            }

            public final a d(o oVar) {
                bq<ak, ak.a, al> bqVar = null;
                if (oVar != o.CI()) {
                    if (oVar.CA()) {
                        a(oVar.CB());
                    }
                    if (oVar.CC()) {
                        bi(oVar.bQs);
                    }
                    if (oVar.CD()) {
                        a(oVar.CE());
                    }
                    if (oVar.CF()) {
                        bj(oVar.bQu);
                    }
                    if (oVar.BN()) {
                        bk(oVar.bPA);
                    }
                    if (oVar.CG()) {
                        bl(oVar.bQv);
                    }
                    if (this.bPD == null) {
                        if (!oVar.bPB.isEmpty()) {
                            if (this.bPB.isEmpty()) {
                                this.bPB = oVar.bPB;
                                this.bOT &= -65;
                            } else {
                                BT();
                                this.bPB.addAll(oVar.bPB);
                            }
                            onChanged();
                        }
                    } else if (!oVar.bPB.isEmpty()) {
                        if (this.bPD.isEmpty()) {
                            this.bPD.bYP = null;
                            this.bPD = null;
                            this.bPB = oVar.bPB;
                            this.bOT &= -65;
                            if (ac.bVU) {
                                bqVar = BU();
                            }
                            this.bPD = bqVar;
                        } else {
                            this.bPD.a(oVar.bPB);
                        }
                    }
                    a((ac.d) oVar);
                    d(oVar.bTW);
                    onChanged();
                }
                return this;
            }

            @Override // com.google.a.ax, com.google.a.ac.c, com.google.a.ac.a
            public final boolean isInitialized() {
                int count;
                ak s;
                int i2 = 0;
                while (true) {
                    if (this.bPD == null) {
                        count = this.bPB.size();
                    } else {
                        count = this.bPD.getCount();
                    }
                    if (i2 < count) {
                        if (this.bPD == null) {
                            s = this.bPB.get(i2);
                        } else {
                            s = this.bPD.s(i2, false);
                        }
                        if (!s.isInitialized()) {
                            return false;
                        }
                        i2++;
                    } else if (this.bWd.isInitialized()) {
                        return true;
                    } else {
                        return false;
                    }
                }
            }

            /* access modifiers changed from: private */
            /* JADX WARNING: Removed duplicated region for block: B:16:0x001e  */
            /* renamed from: o */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public com.google.a.k.o.a c(com.google.a.h r4, com.google.a.r r5) {
                /*
                    r3 = this;
                    r2 = 0
                    com.google.a.bj<com.google.a.k$o> r0 = com.google.a.k.o.bPg     // Catch:{ af -> 0x000f }
                    java.lang.Object r0 = r0.d(r4, r5)     // Catch:{ af -> 0x000f }
                    com.google.a.k$o r0 = (com.google.a.k.o) r0     // Catch:{ af -> 0x000f }
                    if (r0 == 0) goto L_0x000e
                    r3.d(r0)
                L_0x000e:
                    return r3
                L_0x000f:
                    r0 = move-exception
                    r1 = r0
                    com.google.a.aw r0 = r1.bXr     // Catch:{ all -> 0x0022 }
                    com.google.a.k$o r0 = (com.google.a.k.o) r0     // Catch:{ all -> 0x0022 }
                    java.io.IOException r1 = r1.GF()     // Catch:{ all -> 0x001a }
                    throw r1     // Catch:{ all -> 0x001a }
                L_0x001a:
                    r1 = move-exception
                    r2 = r0
                L_0x001c:
                    if (r2 == 0) goto L_0x0021
                    r3.d(r2)
                L_0x0021:
                    throw r1
                L_0x0022:
                    r0 = move-exception
                    r1 = r0
                    goto L_0x001c
                */
                throw new UnsupportedOperationException("Method not decompiled: com.google.a.k.o.a.c(com.google.a.h, com.google.a.r):com.google.a.k$o$a");
            }

            private a a(b bVar) {
                if (bVar == null) {
                    throw new NullPointerException();
                }
                this.bOT |= 1;
                this.bQr = bVar.value;
                onChanged();
                return this;
            }

            private a bi(boolean z) {
                this.bOT |= 2;
                this.bQs = z;
                onChanged();
                return this;
            }

            private a a(c cVar) {
                if (cVar == null) {
                    throw new NullPointerException();
                }
                this.bOT |= 4;
                this.bQt = cVar.value;
                onChanged();
                return this;
            }

            private a bj(boolean z) {
                this.bOT |= 8;
                this.bQu = z;
                onChanged();
                return this;
            }

            private a bk(boolean z) {
                this.bOT |= 16;
                this.bPA = z;
                onChanged();
                return this;
            }

            private a bl(boolean z) {
                this.bOT |= 32;
                this.bQv = z;
                onChanged();
                return this;
            }

            private void BT() {
                if ((this.bOT & 64) == 0) {
                    this.bPB = new ArrayList(this.bPB);
                    this.bOT |= 64;
                }
            }

            private bq<ak, ak.a, al> BU() {
                if (this.bPD == null) {
                    this.bPD = new bq<>(this.bPB, (this.bOT & 64) != 0, GA(), this.bWv);
                    this.bPB = null;
                }
                return this.bPD;
            }

            /* access modifiers changed from: private */
            /* renamed from: y */
            public a f(cc ccVar) {
                return (a) super.f(ccVar);
            }

            /* access modifiers changed from: private */
            /* renamed from: z */
            public a d(cc ccVar) {
                return (a) super.a(ccVar);
            }

            @Override // com.google.a.az
            public final /* synthetic */ at AQ() {
                return o.CI();
            }

            @Override // com.google.a.ax
            public final /* synthetic */ aw AP() {
                return o.CI();
            }

            @Override // com.google.a.ac.a
            public final /* bridge */ /* synthetic */ ac.a Bl() {
                return (a) super.yG();
            }

            @Override // com.google.a.a.AbstractC0085a, com.google.a.ac.a
            public final /* synthetic */ a.AbstractC0085a yE() {
                return (a) super.yG();
            }

            @Override // com.google.a.b.a, com.google.a.a.AbstractC0085a, com.google.a.ac.a
            public final /* synthetic */ b.a yG() {
                return (a) super.yG();
            }

            @Override // com.google.a.b.a, com.google.a.a.AbstractC0085a, java.lang.Object, com.google.a.ac.a
            public final /* synthetic */ Object clone() {
                return (a) super.yG();
            }
        }

        public static o CI() {
            return bQw;
        }

        @Override // com.google.a.aw, com.google.a.ac
        public final bj<o> AK() {
            return bPg;
        }

        @Override // com.google.a.az
        public final /* bridge */ /* synthetic */ at AQ() {
            return bQw;
        }

        @Override // com.google.a.ax
        public final /* bridge */ /* synthetic */ aw AP() {
            return bQw;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.a.ac
        public final /* synthetic */ at.a a(ac.b bVar) {
            return new a(bVar, (byte) 0);
        }

        @Override // com.google.a.at
        public final /* synthetic */ at.a AM() {
            return bQw.AN();
        }

        @Override // com.google.a.aw
        public final /* synthetic */ aw.a AO() {
            return bQw.AN();
        }
    }

    public static final class ac extends ac.d<ac> implements ad {
        @Deprecated
        public static final bj<ac> bPg = new c<ac>() {
            /* class com.google.a.k.ac.AnonymousClass1 */

            @Override // com.google.a.bj
            public final /* synthetic */ Object d(h hVar, r rVar) {
                return new ac(hVar, rVar, (byte) 0);
            }
        };
        private static final ac bRM = new ac();
        private List<ak> bPB;
        private byte bPe;

        /* synthetic */ ac(ac.c cVar, byte b2) {
            this(cVar);
        }

        /* synthetic */ ac(h hVar, r rVar, byte b2) {
            this(hVar, rVar);
        }

        private ac(ac.c<ac, ?> cVar) {
            super(cVar);
            this.bPe = -1;
        }

        private ac() {
            this.bPe = -1;
            this.bPB = Collections.emptyList();
        }

        @Override // com.google.a.az, com.google.a.ac
        public final cc Ax() {
            return this.bTW;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r3v3, resolved type: java.util.List<com.google.a.k$ak> */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARNING: Removed duplicated region for block: B:26:0x004a  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private ac(com.google.a.h r7, com.google.a.r r8) {
            /*
            // Method dump skipped, instructions count: 140
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.a.k.ac.<init>(com.google.a.h, com.google.a.r):void");
        }

        /* access modifiers changed from: protected */
        @Override // com.google.a.ac
        public final ac.f Ay() {
            return k.bOx.h(ac.class, a.class);
        }

        private int BO() {
            return this.bPB.size();
        }

        @Override // com.google.a.a, com.google.a.ax, com.google.a.ac.d, com.google.a.ac
        public final boolean isInitialized() {
            byte b2 = this.bPe;
            if (b2 == 1) {
                return true;
            }
            if (b2 == 0) {
                return false;
            }
            for (int i2 = 0; i2 < BO(); i2++) {
                if (!this.bPB.get(i2).isInitialized()) {
                    this.bPe = 0;
                    return false;
                }
            }
            if (!this.bWd.isInitialized()) {
                this.bPe = 0;
                return false;
            }
            this.bPe = 1;
            return true;
        }

        @Override // com.google.a.aw, com.google.a.a, com.google.a.ac
        public final void a(i iVar) {
            ac.d<MessageType>.a GC = GC();
            for (int i2 = 0; i2 < this.bPB.size(); i2++) {
                iVar.a(999, this.bPB.get(i2));
            }
            GC.b(iVar);
            this.bTW.a(iVar);
        }

        @Override // com.google.a.aw, com.google.a.a, com.google.a.ac
        public final int yC() {
            int i2 = this.bNa;
            if (i2 != -1) {
                return i2;
            }
            int i3 = 0;
            for (int i4 = 0; i4 < this.bPB.size(); i4++) {
                i3 += i.c(999, this.bPB.get(i4));
            }
            int yC = this.bWd.yC() + i3 + this.bTW.yC();
            this.bNa = yC;
            return yC;
        }

        @Override // com.google.a.a
        public final boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof ac)) {
                return super.equals(obj);
            }
            ac acVar = (ac) obj;
            if (!this.bPB.equals(acVar.bPB)) {
                return false;
            }
            if (!this.bTW.equals(acVar.bTW)) {
                return false;
            }
            return this.bWd.FS().equals(acVar.bWd.FS());
        }

        @Override // com.google.a.a
        public final int hashCode() {
            if (this.bNb != 0) {
                return this.bNb;
            }
            int hashCode = k.bOw.hashCode() + com.tencent.mm.plugin.appbrand.jsapi.share.q.CTRL_INDEX;
            if (BO() > 0) {
                hashCode = (((hashCode * 37) + 999) * 53) + this.bPB.hashCode();
            }
            int b2 = (b(hashCode, this.bWd.FS()) * 29) + this.bTW.hashCode();
            this.bNb = b2;
            return b2;
        }

        public static a b(ac acVar) {
            return bRM.AN().d(acVar);
        }

        /* renamed from: Et */
        public final a AN() {
            if (this == bRM) {
                return new a((byte) 0);
            }
            return new a((byte) 0).d(this);
        }

        public static final class a extends ac.c<ac, a> implements ad {
            private int bOT;
            private List<ak> bPB;
            private bq<ak, ak.a, al> bPD;

            /* synthetic */ a(byte b2) {
                this();
            }

            /* synthetic */ a(ac.b bVar, byte b2) {
                this(bVar);
            }

            /* access modifiers changed from: protected */
            @Override // com.google.a.ac.a
            public final ac.f Ay() {
                return k.bOx.h(ac.class, a.class);
            }

            private a() {
                this.bPB = Collections.emptyList();
                AR();
            }

            private a(ac.b bVar) {
                super(bVar);
                this.bPB = Collections.emptyList();
                AR();
            }

            private void AR() {
                if (ac.bVU) {
                    BU();
                }
            }

            @Override // com.google.a.az, com.google.a.ac.a, com.google.a.at.a
            public final l.a AS() {
                return k.bOw;
            }

            /* access modifiers changed from: private */
            /* renamed from: Ev */
            public ac Bp() {
                ac Ew = Bo();
                if (Ew.isInitialized()) {
                    return Ew;
                }
                throw b(Ew);
            }

            /* renamed from: Ew */
            public final ac Bo() {
                ac acVar = new ac(this, (byte) 0);
                if (this.bPD == null) {
                    if ((this.bOT & 1) != 0) {
                        this.bPB = Collections.unmodifiableList(this.bPB);
                        this.bOT &= -2;
                    }
                    acVar.bPB = this.bPB;
                } else {
                    acVar.bPB = this.bPD.build();
                }
                Gy();
                return acVar;
            }

            /* access modifiers changed from: private */
            /* renamed from: O */
            public a r(l.f fVar, Object obj) {
                return (a) super.f(fVar, obj);
            }

            /* access modifiers changed from: private */
            /* renamed from: P */
            public a q(l.f fVar, Object obj) {
                return (a) super.e(fVar, obj);
            }

            /* access modifiers changed from: private */
            /* renamed from: u */
            public a c(at atVar) {
                if (atVar instanceof ac) {
                    return d((ac) atVar);
                }
                super.c(atVar);
                return this;
            }

            public final a d(ac acVar) {
                bq<ak, ak.a, al> bqVar = null;
                if (acVar != ac.Eu()) {
                    if (this.bPD == null) {
                        if (!acVar.bPB.isEmpty()) {
                            if (this.bPB.isEmpty()) {
                                this.bPB = acVar.bPB;
                                this.bOT &= -2;
                            } else {
                                BT();
                                this.bPB.addAll(acVar.bPB);
                            }
                            onChanged();
                        }
                    } else if (!acVar.bPB.isEmpty()) {
                        if (this.bPD.isEmpty()) {
                            this.bPD.bYP = null;
                            this.bPD = null;
                            this.bPB = acVar.bPB;
                            this.bOT &= -2;
                            if (ac.bVU) {
                                bqVar = BU();
                            }
                            this.bPD = bqVar;
                        } else {
                            this.bPD.a(acVar.bPB);
                        }
                    }
                    a((ac.d) acVar);
                    d(acVar.bTW);
                    onChanged();
                }
                return this;
            }

            @Override // com.google.a.ax, com.google.a.ac.c, com.google.a.ac.a
            public final boolean isInitialized() {
                int count;
                ak s;
                int i2 = 0;
                while (true) {
                    if (this.bPD == null) {
                        count = this.bPB.size();
                    } else {
                        count = this.bPD.getCount();
                    }
                    if (i2 < count) {
                        if (this.bPD == null) {
                            s = this.bPB.get(i2);
                        } else {
                            s = this.bPD.s(i2, false);
                        }
                        if (!s.isInitialized()) {
                            return false;
                        }
                        i2++;
                    } else if (this.bWd.isInitialized()) {
                        return true;
                    } else {
                        return false;
                    }
                }
            }

            /* access modifiers changed from: private */
            /* JADX WARNING: Removed duplicated region for block: B:16:0x001e  */
            /* renamed from: v */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public com.google.a.k.ac.a c(com.google.a.h r4, com.google.a.r r5) {
                /*
                    r3 = this;
                    r2 = 0
                    com.google.a.bj<com.google.a.k$ac> r0 = com.google.a.k.ac.bPg     // Catch:{ af -> 0x000f }
                    java.lang.Object r0 = r0.d(r4, r5)     // Catch:{ af -> 0x000f }
                    com.google.a.k$ac r0 = (com.google.a.k.ac) r0     // Catch:{ af -> 0x000f }
                    if (r0 == 0) goto L_0x000e
                    r3.d(r0)
                L_0x000e:
                    return r3
                L_0x000f:
                    r0 = move-exception
                    r1 = r0
                    com.google.a.aw r0 = r1.bXr     // Catch:{ all -> 0x0022 }
                    com.google.a.k$ac r0 = (com.google.a.k.ac) r0     // Catch:{ all -> 0x0022 }
                    java.io.IOException r1 = r1.GF()     // Catch:{ all -> 0x001a }
                    throw r1     // Catch:{ all -> 0x001a }
                L_0x001a:
                    r1 = move-exception
                    r2 = r0
                L_0x001c:
                    if (r2 == 0) goto L_0x0021
                    r3.d(r2)
                L_0x0021:
                    throw r1
                L_0x0022:
                    r0 = move-exception
                    r1 = r0
                    goto L_0x001c
                */
                throw new UnsupportedOperationException("Method not decompiled: com.google.a.k.ac.a.c(com.google.a.h, com.google.a.r):com.google.a.k$ac$a");
            }

            private void BT() {
                if ((this.bOT & 1) == 0) {
                    this.bPB = new ArrayList(this.bPB);
                    this.bOT |= 1;
                }
            }

            private bq<ak, ak.a, al> BU() {
                if (this.bPD == null) {
                    this.bPD = new bq<>(this.bPB, (this.bOT & 1) != 0, GA(), this.bWv);
                    this.bPB = null;
                }
                return this.bPD;
            }

            /* access modifiers changed from: private */
            /* renamed from: M */
            public a f(cc ccVar) {
                return (a) super.f(ccVar);
            }

            /* access modifiers changed from: private */
            /* renamed from: N */
            public a d(cc ccVar) {
                return (a) super.a(ccVar);
            }

            @Override // com.google.a.az
            public final /* synthetic */ at AQ() {
                return ac.Eu();
            }

            @Override // com.google.a.ax
            public final /* synthetic */ aw AP() {
                return ac.Eu();
            }

            @Override // com.google.a.ac.a
            public final /* bridge */ /* synthetic */ ac.a Bl() {
                return (a) super.yG();
            }

            @Override // com.google.a.a.AbstractC0085a, com.google.a.ac.a
            public final /* synthetic */ a.AbstractC0085a yE() {
                return (a) super.yG();
            }

            @Override // com.google.a.b.a, com.google.a.a.AbstractC0085a, com.google.a.ac.a
            public final /* synthetic */ b.a yG() {
                return (a) super.yG();
            }

            @Override // com.google.a.b.a, com.google.a.a.AbstractC0085a, java.lang.Object, com.google.a.ac.a
            public final /* synthetic */ Object clone() {
                return (a) super.yG();
            }
        }

        public static ac Eu() {
            return bRM;
        }

        @Override // com.google.a.aw, com.google.a.ac
        public final bj<ac> AK() {
            return bPg;
        }

        @Override // com.google.a.az
        public final /* bridge */ /* synthetic */ at AQ() {
            return bRM;
        }

        @Override // com.google.a.ax
        public final /* bridge */ /* synthetic */ aw AP() {
            return bRM;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.a.ac
        public final /* synthetic */ at.a a(ac.b bVar) {
            return new a(bVar, (byte) 0);
        }

        @Override // com.google.a.at
        public final /* synthetic */ at.a AM() {
            return bRM.AN();
        }

        @Override // com.google.a.aw
        public final /* synthetic */ aw.a AO() {
            return bRM.AN();
        }
    }

    public static final class e extends ac.d<e> implements f {
        private static final e bPC = new e();
        @Deprecated
        public static final bj<e> bPg = new c<e>() {
            /* class com.google.a.k.e.AnonymousClass1 */

            @Override // com.google.a.bj
            public final /* synthetic */ Object d(h hVar, r rVar) {
                return new e(hVar, rVar, (byte) 0);
            }
        };
        private int bOT;
        boolean bPA;
        private List<ak> bPB;
        private byte bPe;
        boolean bPz;

        /* synthetic */ e(ac.c cVar, byte b2) {
            this(cVar);
        }

        /* synthetic */ e(h hVar, r rVar, byte b2) {
            this(hVar, rVar);
        }

        private e(ac.c<e, ?> cVar) {
            super(cVar);
            this.bPe = -1;
        }

        private e() {
            this.bPe = -1;
            this.bPB = Collections.emptyList();
        }

        @Override // com.google.a.az, com.google.a.ac
        public final cc Ax() {
            return this.bTW;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r3v3, resolved type: java.util.List<com.google.a.k$ak> */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARNING: Removed duplicated region for block: B:23:0x003e  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private e(com.google.a.h r7, com.google.a.r r8) {
            /*
            // Method dump skipped, instructions count: 174
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.a.k.e.<init>(com.google.a.h, com.google.a.r):void");
        }

        /* access modifiers changed from: protected */
        @Override // com.google.a.ac
        public final ac.f Ay() {
            return k.bOz.h(e.class, a.class);
        }

        public final boolean BM() {
            return (this.bOT & 1) != 0;
        }

        public final boolean BN() {
            return (this.bOT & 2) != 0;
        }

        private int BO() {
            return this.bPB.size();
        }

        @Override // com.google.a.a, com.google.a.ax, com.google.a.ac.d, com.google.a.ac
        public final boolean isInitialized() {
            byte b2 = this.bPe;
            if (b2 == 1) {
                return true;
            }
            if (b2 == 0) {
                return false;
            }
            for (int i2 = 0; i2 < BO(); i2++) {
                if (!this.bPB.get(i2).isInitialized()) {
                    this.bPe = 0;
                    return false;
                }
            }
            if (!this.bWd.isInitialized()) {
                this.bPe = 0;
                return false;
            }
            this.bPe = 1;
            return true;
        }

        @Override // com.google.a.aw, com.google.a.a, com.google.a.ac
        public final void a(i iVar) {
            ac.d<MessageType>.a GC = GC();
            if ((this.bOT & 1) != 0) {
                iVar.r(2, this.bPz);
            }
            if ((this.bOT & 2) != 0) {
                iVar.r(3, this.bPA);
            }
            for (int i2 = 0; i2 < this.bPB.size(); i2++) {
                iVar.a(999, this.bPB.get(i2));
            }
            GC.b(iVar);
            this.bTW.a(iVar);
        }

        @Override // com.google.a.aw, com.google.a.a, com.google.a.ac
        public final int yC() {
            int i2 = this.bNa;
            if (i2 != -1) {
                return i2;
            }
            int fR = (this.bOT & 1) != 0 ? i.fR(2) + 0 : 0;
            if ((this.bOT & 2) != 0) {
                fR += i.fR(3);
            }
            for (int i3 = 0; i3 < this.bPB.size(); i3++) {
                fR = i.c(999, this.bPB.get(i3)) + fR;
            }
            int yC = this.bWd.yC() + fR + this.bTW.yC();
            this.bNa = yC;
            return yC;
        }

        @Override // com.google.a.a
        public final boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof e)) {
                return super.equals(obj);
            }
            e eVar = (e) obj;
            if (BM() != eVar.BM()) {
                return false;
            }
            if (BM() && this.bPz != eVar.bPz) {
                return false;
            }
            if (BN() != eVar.BN()) {
                return false;
            }
            if (BN() && this.bPA != eVar.bPA) {
                return false;
            }
            if (!this.bPB.equals(eVar.bPB)) {
                return false;
            }
            if (!this.bTW.equals(eVar.bTW)) {
                return false;
            }
            return this.bWd.FS().equals(eVar.bWd.FS());
        }

        @Override // com.google.a.a
        public final int hashCode() {
            if (this.bNb != 0) {
                return this.bNb;
            }
            int hashCode = k.bOy.hashCode() + com.tencent.mm.plugin.appbrand.jsapi.share.q.CTRL_INDEX;
            if (BM()) {
                hashCode = (((hashCode * 37) + 2) * 53) + ae.bF(this.bPz);
            }
            if (BN()) {
                hashCode = (((hashCode * 37) + 3) * 53) + ae.bF(this.bPA);
            }
            if (BO() > 0) {
                hashCode = (((hashCode * 37) + 999) * 53) + this.bPB.hashCode();
            }
            int b2 = (b(hashCode, this.bWd.FS()) * 29) + this.bTW.hashCode();
            this.bNb = b2;
            return b2;
        }

        public static a b(e eVar) {
            return bPC.AN().d(eVar);
        }

        /* renamed from: BP */
        public final a AN() {
            if (this == bPC) {
                return new a((byte) 0);
            }
            return new a((byte) 0).d(this);
        }

        public static final class a extends ac.c<e, a> implements f {
            private int bOT;
            private boolean bPA;
            private List<ak> bPB;
            private bq<ak, ak.a, al> bPD;
            private boolean bPz;

            /* synthetic */ a(byte b2) {
                this();
            }

            /* synthetic */ a(ac.b bVar, byte b2) {
                this(bVar);
            }

            /* access modifiers changed from: protected */
            @Override // com.google.a.ac.a
            public final ac.f Ay() {
                return k.bOz.h(e.class, a.class);
            }

            private a() {
                this.bPB = Collections.emptyList();
                AR();
            }

            private a(ac.b bVar) {
                super(bVar);
                this.bPB = Collections.emptyList();
                AR();
            }

            private void AR() {
                if (ac.bVU) {
                    BU();
                }
            }

            @Override // com.google.a.az, com.google.a.ac.a, com.google.a.at.a
            public final l.a AS() {
                return k.bOy;
            }

            /* access modifiers changed from: private */
            /* renamed from: BR */
            public e Bp() {
                e BS = Bo();
                if (BS.isInitialized()) {
                    return BS;
                }
                throw b(BS);
            }

            /* renamed from: BS */
            public final e Bo() {
                int i2 = 0;
                e eVar = new e(this, (byte) 0);
                int i3 = this.bOT;
                if ((i3 & 1) != 0) {
                    eVar.bPz = this.bPz;
                    i2 = 1;
                }
                if ((i3 & 2) != 0) {
                    eVar.bPA = this.bPA;
                    i2 |= 2;
                }
                if (this.bPD == null) {
                    if ((this.bOT & 4) != 0) {
                        this.bPB = Collections.unmodifiableList(this.bPB);
                        this.bOT &= -5;
                    }
                    eVar.bPB = this.bPB;
                } else {
                    eVar.bPB = this.bPD.build();
                }
                eVar.bOT = i2;
                Gy();
                return eVar;
            }

            /* access modifiers changed from: private */
            /* renamed from: o */
            public a r(l.f fVar, Object obj) {
                return (a) super.f(fVar, obj);
            }

            /* access modifiers changed from: private */
            /* renamed from: p */
            public a q(l.f fVar, Object obj) {
                return (a) super.e(fVar, obj);
            }

            /* access modifiers changed from: private */
            /* renamed from: i */
            public a c(at atVar) {
                if (atVar instanceof e) {
                    return d((e) atVar);
                }
                super.c(atVar);
                return this;
            }

            public final a d(e eVar) {
                bq<ak, ak.a, al> bqVar = null;
                if (eVar != e.BQ()) {
                    if (eVar.BM()) {
                        bf(eVar.bPz);
                    }
                    if (eVar.BN()) {
                        bg(eVar.bPA);
                    }
                    if (this.bPD == null) {
                        if (!eVar.bPB.isEmpty()) {
                            if (this.bPB.isEmpty()) {
                                this.bPB = eVar.bPB;
                                this.bOT &= -5;
                            } else {
                                BT();
                                this.bPB.addAll(eVar.bPB);
                            }
                            onChanged();
                        }
                    } else if (!eVar.bPB.isEmpty()) {
                        if (this.bPD.isEmpty()) {
                            this.bPD.bYP = null;
                            this.bPD = null;
                            this.bPB = eVar.bPB;
                            this.bOT &= -5;
                            if (ac.bVU) {
                                bqVar = BU();
                            }
                            this.bPD = bqVar;
                        } else {
                            this.bPD.a(eVar.bPB);
                        }
                    }
                    a((ac.d) eVar);
                    d(eVar.bTW);
                    onChanged();
                }
                return this;
            }

            @Override // com.google.a.ax, com.google.a.ac.c, com.google.a.ac.a
            public final boolean isInitialized() {
                int count;
                ak s;
                int i2 = 0;
                while (true) {
                    if (this.bPD == null) {
                        count = this.bPB.size();
                    } else {
                        count = this.bPD.getCount();
                    }
                    if (i2 < count) {
                        if (this.bPD == null) {
                            s = this.bPB.get(i2);
                        } else {
                            s = this.bPD.s(i2, false);
                        }
                        if (!s.isInitialized()) {
                            return false;
                        }
                        i2++;
                    } else if (this.bWd.isInitialized()) {
                        return true;
                    } else {
                        return false;
                    }
                }
            }

            /* access modifiers changed from: private */
            /* JADX WARNING: Removed duplicated region for block: B:16:0x001e  */
            /* renamed from: j */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public com.google.a.k.e.a c(com.google.a.h r4, com.google.a.r r5) {
                /*
                    r3 = this;
                    r2 = 0
                    com.google.a.bj<com.google.a.k$e> r0 = com.google.a.k.e.bPg     // Catch:{ af -> 0x000f }
                    java.lang.Object r0 = r0.d(r4, r5)     // Catch:{ af -> 0x000f }
                    com.google.a.k$e r0 = (com.google.a.k.e) r0     // Catch:{ af -> 0x000f }
                    if (r0 == 0) goto L_0x000e
                    r3.d(r0)
                L_0x000e:
                    return r3
                L_0x000f:
                    r0 = move-exception
                    r1 = r0
                    com.google.a.aw r0 = r1.bXr     // Catch:{ all -> 0x0022 }
                    com.google.a.k$e r0 = (com.google.a.k.e) r0     // Catch:{ all -> 0x0022 }
                    java.io.IOException r1 = r1.GF()     // Catch:{ all -> 0x001a }
                    throw r1     // Catch:{ all -> 0x001a }
                L_0x001a:
                    r1 = move-exception
                    r2 = r0
                L_0x001c:
                    if (r2 == 0) goto L_0x0021
                    r3.d(r2)
                L_0x0021:
                    throw r1
                L_0x0022:
                    r0 = move-exception
                    r1 = r0
                    goto L_0x001c
                */
                throw new UnsupportedOperationException("Method not decompiled: com.google.a.k.e.a.c(com.google.a.h, com.google.a.r):com.google.a.k$e$a");
            }

            private a bf(boolean z) {
                this.bOT |= 1;
                this.bPz = z;
                onChanged();
                return this;
            }

            private a bg(boolean z) {
                this.bOT |= 2;
                this.bPA = z;
                onChanged();
                return this;
            }

            private void BT() {
                if ((this.bOT & 4) == 0) {
                    this.bPB = new ArrayList(this.bPB);
                    this.bOT |= 4;
                }
            }

            private bq<ak, ak.a, al> BU() {
                if (this.bPD == null) {
                    this.bPD = new bq<>(this.bPB, (this.bOT & 4) != 0, GA(), this.bWv);
                    this.bPB = null;
                }
                return this.bPD;
            }

            /* access modifiers changed from: private */
            /* renamed from: o */
            public a f(cc ccVar) {
                return (a) super.f(ccVar);
            }

            /* access modifiers changed from: private */
            /* renamed from: p */
            public a d(cc ccVar) {
                return (a) super.a(ccVar);
            }

            @Override // com.google.a.az
            public final /* synthetic */ at AQ() {
                return e.BQ();
            }

            @Override // com.google.a.ax
            public final /* synthetic */ aw AP() {
                return e.BQ();
            }

            @Override // com.google.a.ac.a
            public final /* bridge */ /* synthetic */ ac.a Bl() {
                return (a) super.yG();
            }

            @Override // com.google.a.a.AbstractC0085a, com.google.a.ac.a
            public final /* synthetic */ a.AbstractC0085a yE() {
                return (a) super.yG();
            }

            @Override // com.google.a.b.a, com.google.a.a.AbstractC0085a, com.google.a.ac.a
            public final /* synthetic */ b.a yG() {
                return (a) super.yG();
            }

            @Override // com.google.a.b.a, com.google.a.a.AbstractC0085a, java.lang.Object, com.google.a.ac.a
            public final /* synthetic */ Object clone() {
                return (a) super.yG();
            }
        }

        public static e BQ() {
            return bPC;
        }

        @Override // com.google.a.aw, com.google.a.ac
        public final bj<e> AK() {
            return bPg;
        }

        @Override // com.google.a.az
        public final /* bridge */ /* synthetic */ at AQ() {
            return bPC;
        }

        @Override // com.google.a.ax
        public final /* bridge */ /* synthetic */ aw AP() {
            return bPC;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.a.ac
        public final /* synthetic */ at.a a(ac.b bVar) {
            return new a(bVar, (byte) 0);
        }

        @Override // com.google.a.at
        public final /* synthetic */ at.a AM() {
            return bPC.AN();
        }

        @Override // com.google.a.aw
        public final /* synthetic */ aw.a AO() {
            return bPC.AN();
        }
    }

    public static final class i extends ac.d<i> implements j {
        private static final i bPH = new i();
        @Deprecated
        public static final bj<i> bPg = new c<i>() {
            /* class com.google.a.k.i.AnonymousClass1 */

            @Override // com.google.a.bj
            public final /* synthetic */ Object d(h hVar, r rVar) {
                return new i(hVar, rVar, (byte) 0);
            }
        };
        private int bOT;
        boolean bPA;
        private List<ak> bPB;
        private byte bPe;

        /* synthetic */ i(ac.c cVar, byte b2) {
            this(cVar);
        }

        /* synthetic */ i(h hVar, r rVar, byte b2) {
            this(hVar, rVar);
        }

        private i(ac.c<i, ?> cVar) {
            super(cVar);
            this.bPe = -1;
        }

        private i() {
            this.bPe = -1;
            this.bPB = Collections.emptyList();
        }

        @Override // com.google.a.az, com.google.a.ac
        public final cc Ax() {
            return this.bTW;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r3v3, resolved type: java.util.List<com.google.a.k$ak> */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARNING: Removed duplicated region for block: B:23:0x003e  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private i(com.google.a.h r7, com.google.a.r r8) {
            /*
            // Method dump skipped, instructions count: 156
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.a.k.i.<init>(com.google.a.h, com.google.a.r):void");
        }

        /* access modifiers changed from: protected */
        @Override // com.google.a.ac
        public final ac.f Ay() {
            return k.bOB.h(i.class, a.class);
        }

        public final boolean BN() {
            return (this.bOT & 1) != 0;
        }

        private int BO() {
            return this.bPB.size();
        }

        @Override // com.google.a.a, com.google.a.ax, com.google.a.ac.d, com.google.a.ac
        public final boolean isInitialized() {
            byte b2 = this.bPe;
            if (b2 == 1) {
                return true;
            }
            if (b2 == 0) {
                return false;
            }
            for (int i2 = 0; i2 < BO(); i2++) {
                if (!this.bPB.get(i2).isInitialized()) {
                    this.bPe = 0;
                    return false;
                }
            }
            if (!this.bWd.isInitialized()) {
                this.bPe = 0;
                return false;
            }
            this.bPe = 1;
            return true;
        }

        @Override // com.google.a.aw, com.google.a.a, com.google.a.ac
        public final void a(i iVar) {
            ac.d<MessageType>.a GC = GC();
            if ((this.bOT & 1) != 0) {
                iVar.r(1, this.bPA);
            }
            for (int i2 = 0; i2 < this.bPB.size(); i2++) {
                iVar.a(999, this.bPB.get(i2));
            }
            GC.b(iVar);
            this.bTW.a(iVar);
        }

        @Override // com.google.a.aw, com.google.a.a, com.google.a.ac
        public final int yC() {
            int i2 = this.bNa;
            if (i2 != -1) {
                return i2;
            }
            int fR = (this.bOT & 1) != 0 ? i.fR(1) + 0 : 0;
            for (int i3 = 0; i3 < this.bPB.size(); i3++) {
                fR = i.c(999, this.bPB.get(i3)) + fR;
            }
            int yC = this.bWd.yC() + fR + this.bTW.yC();
            this.bNa = yC;
            return yC;
        }

        @Override // com.google.a.a
        public final boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof i)) {
                return super.equals(obj);
            }
            i iVar = (i) obj;
            if (BN() != iVar.BN()) {
                return false;
            }
            if (BN() && this.bPA != iVar.bPA) {
                return false;
            }
            if (!this.bPB.equals(iVar.bPB)) {
                return false;
            }
            if (!this.bTW.equals(iVar.bTW)) {
                return false;
            }
            return this.bWd.FS().equals(iVar.bWd.FS());
        }

        @Override // com.google.a.a
        public final int hashCode() {
            if (this.bNb != 0) {
                return this.bNb;
            }
            int hashCode = k.bOA.hashCode() + com.tencent.mm.plugin.appbrand.jsapi.share.q.CTRL_INDEX;
            if (BN()) {
                hashCode = (((hashCode * 37) + 1) * 53) + ae.bF(this.bPA);
            }
            if (BO() > 0) {
                hashCode = (((hashCode * 37) + 999) * 53) + this.bPB.hashCode();
            }
            int b2 = (b(hashCode, this.bWd.FS()) * 29) + this.bTW.hashCode();
            this.bNb = b2;
            return b2;
        }

        public static a b(i iVar) {
            return bPH.AN().d(iVar);
        }

        /* renamed from: Cc */
        public final a AN() {
            if (this == bPH) {
                return new a((byte) 0);
            }
            return new a((byte) 0).d(this);
        }

        public static final class a extends ac.c<i, a> implements j {
            private int bOT;
            private boolean bPA;
            private List<ak> bPB;
            private bq<ak, ak.a, al> bPD;

            /* synthetic */ a(byte b2) {
                this();
            }

            /* synthetic */ a(ac.b bVar, byte b2) {
                this(bVar);
            }

            /* access modifiers changed from: protected */
            @Override // com.google.a.ac.a
            public final ac.f Ay() {
                return k.bOB.h(i.class, a.class);
            }

            private a() {
                this.bPB = Collections.emptyList();
                AR();
            }

            private a(ac.b bVar) {
                super(bVar);
                this.bPB = Collections.emptyList();
                AR();
            }

            private void AR() {
                if (ac.bVU) {
                    BU();
                }
            }

            @Override // com.google.a.az, com.google.a.ac.a, com.google.a.at.a
            public final l.a AS() {
                return k.bOA;
            }

            /* access modifiers changed from: private */
            /* renamed from: Ce */
            public i Bp() {
                i Cf = Bo();
                if (Cf.isInitialized()) {
                    return Cf;
                }
                throw b(Cf);
            }

            /* renamed from: Cf */
            public final i Bo() {
                int i2 = 0;
                i iVar = new i(this, (byte) 0);
                if ((this.bOT & 1) != 0) {
                    iVar.bPA = this.bPA;
                    i2 = 1;
                }
                if (this.bPD == null) {
                    if ((this.bOT & 2) != 0) {
                        this.bPB = Collections.unmodifiableList(this.bPB);
                        this.bOT &= -3;
                    }
                    iVar.bPB = this.bPB;
                } else {
                    iVar.bPB = this.bPD.build();
                }
                iVar.bOT = i2;
                Gy();
                return iVar;
            }

            /* access modifiers changed from: private */
            /* renamed from: u */
            public a r(l.f fVar, Object obj) {
                return (a) super.f(fVar, obj);
            }

            /* access modifiers changed from: private */
            /* renamed from: v */
            public a q(l.f fVar, Object obj) {
                return (a) super.e(fVar, obj);
            }

            /* access modifiers changed from: private */
            /* renamed from: k */
            public a c(at atVar) {
                if (atVar instanceof i) {
                    return d((i) atVar);
                }
                super.c(atVar);
                return this;
            }

            public final a d(i iVar) {
                bq<ak, ak.a, al> bqVar = null;
                if (iVar != i.Cd()) {
                    if (iVar.BN()) {
                        bh(iVar.bPA);
                    }
                    if (this.bPD == null) {
                        if (!iVar.bPB.isEmpty()) {
                            if (this.bPB.isEmpty()) {
                                this.bPB = iVar.bPB;
                                this.bOT &= -3;
                            } else {
                                BT();
                                this.bPB.addAll(iVar.bPB);
                            }
                            onChanged();
                        }
                    } else if (!iVar.bPB.isEmpty()) {
                        if (this.bPD.isEmpty()) {
                            this.bPD.bYP = null;
                            this.bPD = null;
                            this.bPB = iVar.bPB;
                            this.bOT &= -3;
                            if (ac.bVU) {
                                bqVar = BU();
                            }
                            this.bPD = bqVar;
                        } else {
                            this.bPD.a(iVar.bPB);
                        }
                    }
                    a((ac.d) iVar);
                    d(iVar.bTW);
                    onChanged();
                }
                return this;
            }

            @Override // com.google.a.ax, com.google.a.ac.c, com.google.a.ac.a
            public final boolean isInitialized() {
                int count;
                ak s;
                int i2 = 0;
                while (true) {
                    if (this.bPD == null) {
                        count = this.bPB.size();
                    } else {
                        count = this.bPD.getCount();
                    }
                    if (i2 < count) {
                        if (this.bPD == null) {
                            s = this.bPB.get(i2);
                        } else {
                            s = this.bPD.s(i2, false);
                        }
                        if (!s.isInitialized()) {
                            return false;
                        }
                        i2++;
                    } else if (this.bWd.isInitialized()) {
                        return true;
                    } else {
                        return false;
                    }
                }
            }

            /* access modifiers changed from: private */
            /* JADX WARNING: Removed duplicated region for block: B:16:0x001e  */
            /* renamed from: l */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public com.google.a.k.i.a c(com.google.a.h r4, com.google.a.r r5) {
                /*
                    r3 = this;
                    r2 = 0
                    com.google.a.bj<com.google.a.k$i> r0 = com.google.a.k.i.bPg     // Catch:{ af -> 0x000f }
                    java.lang.Object r0 = r0.d(r4, r5)     // Catch:{ af -> 0x000f }
                    com.google.a.k$i r0 = (com.google.a.k.i) r0     // Catch:{ af -> 0x000f }
                    if (r0 == 0) goto L_0x000e
                    r3.d(r0)
                L_0x000e:
                    return r3
                L_0x000f:
                    r0 = move-exception
                    r1 = r0
                    com.google.a.aw r0 = r1.bXr     // Catch:{ all -> 0x0022 }
                    com.google.a.k$i r0 = (com.google.a.k.i) r0     // Catch:{ all -> 0x0022 }
                    java.io.IOException r1 = r1.GF()     // Catch:{ all -> 0x001a }
                    throw r1     // Catch:{ all -> 0x001a }
                L_0x001a:
                    r1 = move-exception
                    r2 = r0
                L_0x001c:
                    if (r2 == 0) goto L_0x0021
                    r3.d(r2)
                L_0x0021:
                    throw r1
                L_0x0022:
                    r0 = move-exception
                    r1 = r0
                    goto L_0x001c
                */
                throw new UnsupportedOperationException("Method not decompiled: com.google.a.k.i.a.c(com.google.a.h, com.google.a.r):com.google.a.k$i$a");
            }

            private a bh(boolean z) {
                this.bOT |= 1;
                this.bPA = z;
                onChanged();
                return this;
            }

            private void BT() {
                if ((this.bOT & 2) == 0) {
                    this.bPB = new ArrayList(this.bPB);
                    this.bOT |= 2;
                }
            }

            private bq<ak, ak.a, al> BU() {
                if (this.bPD == null) {
                    this.bPD = new bq<>(this.bPB, (this.bOT & 2) != 0, GA(), this.bWv);
                    this.bPB = null;
                }
                return this.bPD;
            }

            /* access modifiers changed from: private */
            /* renamed from: s */
            public a f(cc ccVar) {
                return (a) super.f(ccVar);
            }

            /* access modifiers changed from: private */
            /* renamed from: t */
            public a d(cc ccVar) {
                return (a) super.a(ccVar);
            }

            @Override // com.google.a.az
            public final /* synthetic */ at AQ() {
                return i.Cd();
            }

            @Override // com.google.a.ax
            public final /* synthetic */ aw AP() {
                return i.Cd();
            }

            @Override // com.google.a.ac.a
            public final /* bridge */ /* synthetic */ ac.a Bl() {
                return (a) super.yG();
            }

            @Override // com.google.a.a.AbstractC0085a, com.google.a.ac.a
            public final /* synthetic */ a.AbstractC0085a yE() {
                return (a) super.yG();
            }

            @Override // com.google.a.b.a, com.google.a.a.AbstractC0085a, com.google.a.ac.a
            public final /* synthetic */ b.a yG() {
                return (a) super.yG();
            }

            @Override // com.google.a.b.a, com.google.a.a.AbstractC0085a, java.lang.Object, com.google.a.ac.a
            public final /* synthetic */ Object clone() {
                return (a) super.yG();
            }
        }

        public static i Cd() {
            return bPH;
        }

        @Override // com.google.a.aw, com.google.a.ac
        public final bj<i> AK() {
            return bPg;
        }

        @Override // com.google.a.az
        public final /* bridge */ /* synthetic */ at AQ() {
            return bPH;
        }

        @Override // com.google.a.ax
        public final /* bridge */ /* synthetic */ aw AP() {
            return bPH;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.a.ac
        public final /* synthetic */ at.a a(ac.b bVar) {
            return new a(bVar, (byte) 0);
        }

        @Override // com.google.a.at
        public final /* synthetic */ at.a AM() {
            return bPH.AN();
        }

        @Override // com.google.a.aw
        public final /* synthetic */ aw.a AO() {
            return bPH.AN();
        }
    }

    public static final class ag extends ac.d<ag> implements ah {
        @Deprecated
        public static final bj<ag> bPg = new c<ag>() {
            /* class com.google.a.k.ag.AnonymousClass1 */

            @Override // com.google.a.bj
            public final /* synthetic */ Object d(h hVar, r rVar) {
                return new ag(hVar, rVar, (byte) 0);
            }
        };
        private static final ag bRR = new ag();
        private int bOT;
        boolean bPA;
        private List<ak> bPB;
        private byte bPe;

        /* synthetic */ ag(ac.c cVar, byte b2) {
            this(cVar);
        }

        /* synthetic */ ag(h hVar, r rVar, byte b2) {
            this(hVar, rVar);
        }

        private ag(ac.c<ag, ?> cVar) {
            super(cVar);
            this.bPe = -1;
        }

        private ag() {
            this.bPe = -1;
            this.bPB = Collections.emptyList();
        }

        @Override // com.google.a.az, com.google.a.ac
        public final cc Ax() {
            return this.bTW;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r3v3, resolved type: java.util.List<com.google.a.k$ak> */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARNING: Removed duplicated region for block: B:23:0x003e  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private ag(com.google.a.h r7, com.google.a.r r8) {
            /*
            // Method dump skipped, instructions count: 156
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.a.k.ag.<init>(com.google.a.h, com.google.a.r):void");
        }

        /* access modifiers changed from: protected */
        @Override // com.google.a.ac
        public final ac.f Ay() {
            return k.bOD.h(ag.class, a.class);
        }

        public final boolean BN() {
            return (this.bOT & 1) != 0;
        }

        private int BO() {
            return this.bPB.size();
        }

        @Override // com.google.a.a, com.google.a.ax, com.google.a.ac.d, com.google.a.ac
        public final boolean isInitialized() {
            byte b2 = this.bPe;
            if (b2 == 1) {
                return true;
            }
            if (b2 == 0) {
                return false;
            }
            for (int i2 = 0; i2 < BO(); i2++) {
                if (!this.bPB.get(i2).isInitialized()) {
                    this.bPe = 0;
                    return false;
                }
            }
            if (!this.bWd.isInitialized()) {
                this.bPe = 0;
                return false;
            }
            this.bPe = 1;
            return true;
        }

        @Override // com.google.a.aw, com.google.a.a, com.google.a.ac
        public final void a(i iVar) {
            ac.d<MessageType>.a GC = GC();
            if ((this.bOT & 1) != 0) {
                iVar.r(33, this.bPA);
            }
            for (int i2 = 0; i2 < this.bPB.size(); i2++) {
                iVar.a(999, this.bPB.get(i2));
            }
            GC.b(iVar);
            this.bTW.a(iVar);
        }

        @Override // com.google.a.aw, com.google.a.a, com.google.a.ac
        public final int yC() {
            int i2 = this.bNa;
            if (i2 != -1) {
                return i2;
            }
            int fR = (this.bOT & 1) != 0 ? i.fR(33) + 0 : 0;
            for (int i3 = 0; i3 < this.bPB.size(); i3++) {
                fR = i.c(999, this.bPB.get(i3)) + fR;
            }
            int yC = this.bWd.yC() + fR + this.bTW.yC();
            this.bNa = yC;
            return yC;
        }

        @Override // com.google.a.a
        public final boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof ag)) {
                return super.equals(obj);
            }
            ag agVar = (ag) obj;
            if (BN() != agVar.BN()) {
                return false;
            }
            if (BN() && this.bPA != agVar.bPA) {
                return false;
            }
            if (!this.bPB.equals(agVar.bPB)) {
                return false;
            }
            if (!this.bTW.equals(agVar.bTW)) {
                return false;
            }
            return this.bWd.FS().equals(agVar.bWd.FS());
        }

        @Override // com.google.a.a
        public final int hashCode() {
            if (this.bNb != 0) {
                return this.bNb;
            }
            int hashCode = k.bOC.hashCode() + com.tencent.mm.plugin.appbrand.jsapi.share.q.CTRL_INDEX;
            if (BN()) {
                hashCode = (((hashCode * 37) + 33) * 53) + ae.bF(this.bPA);
            }
            if (BO() > 0) {
                hashCode = (((hashCode * 37) + 999) * 53) + this.bPB.hashCode();
            }
            int b2 = (b(hashCode, this.bWd.FS()) * 29) + this.bTW.hashCode();
            this.bNb = b2;
            return b2;
        }

        public static a b(ag agVar) {
            return bRR.AN().d(agVar);
        }

        /* renamed from: EF */
        public final a AN() {
            if (this == bRR) {
                return new a((byte) 0);
            }
            return new a((byte) 0).d(this);
        }

        public static final class a extends ac.c<ag, a> implements ah {
            private int bOT;
            private boolean bPA;
            private List<ak> bPB;
            private bq<ak, ak.a, al> bPD;

            /* synthetic */ a(byte b2) {
                this();
            }

            /* synthetic */ a(ac.b bVar, byte b2) {
                this(bVar);
            }

            /* access modifiers changed from: protected */
            @Override // com.google.a.ac.a
            public final ac.f Ay() {
                return k.bOD.h(ag.class, a.class);
            }

            private a() {
                this.bPB = Collections.emptyList();
                AR();
            }

            private a(ac.b bVar) {
                super(bVar);
                this.bPB = Collections.emptyList();
                AR();
            }

            private void AR() {
                if (ac.bVU) {
                    BU();
                }
            }

            @Override // com.google.a.az, com.google.a.ac.a, com.google.a.at.a
            public final l.a AS() {
                return k.bOC;
            }

            /* access modifiers changed from: private */
            /* renamed from: EH */
            public ag Bp() {
                ag EI = Bo();
                if (EI.isInitialized()) {
                    return EI;
                }
                throw b(EI);
            }

            /* renamed from: EI */
            public final ag Bo() {
                int i2 = 0;
                ag agVar = new ag(this, (byte) 0);
                if ((this.bOT & 1) != 0) {
                    agVar.bPA = this.bPA;
                    i2 = 1;
                }
                if (this.bPD == null) {
                    if ((this.bOT & 2) != 0) {
                        this.bPB = Collections.unmodifiableList(this.bPB);
                        this.bOT &= -3;
                    }
                    agVar.bPB = this.bPB;
                } else {
                    agVar.bPB = this.bPD.build();
                }
                agVar.bOT = i2;
                Gy();
                return agVar;
            }

            /* access modifiers changed from: private */
            /* renamed from: S */
            public a r(l.f fVar, Object obj) {
                return (a) super.f(fVar, obj);
            }

            /* access modifiers changed from: private */
            /* renamed from: T */
            public a q(l.f fVar, Object obj) {
                return (a) super.e(fVar, obj);
            }

            /* access modifiers changed from: private */
            /* renamed from: w */
            public a c(at atVar) {
                if (atVar instanceof ag) {
                    return d((ag) atVar);
                }
                super.c(atVar);
                return this;
            }

            public final a d(ag agVar) {
                bq<ak, ak.a, al> bqVar = null;
                if (agVar != ag.EG()) {
                    if (agVar.BN()) {
                        bC(agVar.bPA);
                    }
                    if (this.bPD == null) {
                        if (!agVar.bPB.isEmpty()) {
                            if (this.bPB.isEmpty()) {
                                this.bPB = agVar.bPB;
                                this.bOT &= -3;
                            } else {
                                BT();
                                this.bPB.addAll(agVar.bPB);
                            }
                            onChanged();
                        }
                    } else if (!agVar.bPB.isEmpty()) {
                        if (this.bPD.isEmpty()) {
                            this.bPD.bYP = null;
                            this.bPD = null;
                            this.bPB = agVar.bPB;
                            this.bOT &= -3;
                            if (ac.bVU) {
                                bqVar = BU();
                            }
                            this.bPD = bqVar;
                        } else {
                            this.bPD.a(agVar.bPB);
                        }
                    }
                    a((ac.d) agVar);
                    d(agVar.bTW);
                    onChanged();
                }
                return this;
            }

            @Override // com.google.a.ax, com.google.a.ac.c, com.google.a.ac.a
            public final boolean isInitialized() {
                int count;
                ak s;
                int i2 = 0;
                while (true) {
                    if (this.bPD == null) {
                        count = this.bPB.size();
                    } else {
                        count = this.bPD.getCount();
                    }
                    if (i2 < count) {
                        if (this.bPD == null) {
                            s = this.bPB.get(i2);
                        } else {
                            s = this.bPD.s(i2, false);
                        }
                        if (!s.isInitialized()) {
                            return false;
                        }
                        i2++;
                    } else if (this.bWd.isInitialized()) {
                        return true;
                    } else {
                        return false;
                    }
                }
            }

            /* access modifiers changed from: private */
            /* JADX WARNING: Removed duplicated region for block: B:16:0x001e  */
            /* renamed from: x */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public com.google.a.k.ag.a c(com.google.a.h r4, com.google.a.r r5) {
                /*
                    r3 = this;
                    r2 = 0
                    com.google.a.bj<com.google.a.k$ag> r0 = com.google.a.k.ag.bPg     // Catch:{ af -> 0x000f }
                    java.lang.Object r0 = r0.d(r4, r5)     // Catch:{ af -> 0x000f }
                    com.google.a.k$ag r0 = (com.google.a.k.ag) r0     // Catch:{ af -> 0x000f }
                    if (r0 == 0) goto L_0x000e
                    r3.d(r0)
                L_0x000e:
                    return r3
                L_0x000f:
                    r0 = move-exception
                    r1 = r0
                    com.google.a.aw r0 = r1.bXr     // Catch:{ all -> 0x0022 }
                    com.google.a.k$ag r0 = (com.google.a.k.ag) r0     // Catch:{ all -> 0x0022 }
                    java.io.IOException r1 = r1.GF()     // Catch:{ all -> 0x001a }
                    throw r1     // Catch:{ all -> 0x001a }
                L_0x001a:
                    r1 = move-exception
                    r2 = r0
                L_0x001c:
                    if (r2 == 0) goto L_0x0021
                    r3.d(r2)
                L_0x0021:
                    throw r1
                L_0x0022:
                    r0 = move-exception
                    r1 = r0
                    goto L_0x001c
                */
                throw new UnsupportedOperationException("Method not decompiled: com.google.a.k.ag.a.c(com.google.a.h, com.google.a.r):com.google.a.k$ag$a");
            }

            private a bC(boolean z) {
                this.bOT |= 1;
                this.bPA = z;
                onChanged();
                return this;
            }

            private void BT() {
                if ((this.bOT & 2) == 0) {
                    this.bPB = new ArrayList(this.bPB);
                    this.bOT |= 2;
                }
            }

            private bq<ak, ak.a, al> BU() {
                if (this.bPD == null) {
                    this.bPD = new bq<>(this.bPB, (this.bOT & 2) != 0, GA(), this.bWv);
                    this.bPB = null;
                }
                return this.bPD;
            }

            /* access modifiers changed from: private */
            /* renamed from: Q */
            public a f(cc ccVar) {
                return (a) super.f(ccVar);
            }

            /* access modifiers changed from: private */
            /* renamed from: R */
            public a d(cc ccVar) {
                return (a) super.a(ccVar);
            }

            @Override // com.google.a.az
            public final /* synthetic */ at AQ() {
                return ag.EG();
            }

            @Override // com.google.a.ax
            public final /* synthetic */ aw AP() {
                return ag.EG();
            }

            @Override // com.google.a.ac.a
            public final /* bridge */ /* synthetic */ ac.a Bl() {
                return (a) super.yG();
            }

            @Override // com.google.a.a.AbstractC0085a, com.google.a.ac.a
            public final /* synthetic */ a.AbstractC0085a yE() {
                return (a) super.yG();
            }

            @Override // com.google.a.b.a, com.google.a.a.AbstractC0085a, com.google.a.ac.a
            public final /* synthetic */ b.a yG() {
                return (a) super.yG();
            }

            @Override // com.google.a.b.a, com.google.a.a.AbstractC0085a, java.lang.Object, com.google.a.ac.a
            public final /* synthetic */ Object clone() {
                return (a) super.yG();
            }
        }

        public static ag EG() {
            return bRR;
        }

        @Override // com.google.a.aw, com.google.a.ac
        public final bj<ag> AK() {
            return bPg;
        }

        @Override // com.google.a.az
        public final /* bridge */ /* synthetic */ at AQ() {
            return bRR;
        }

        @Override // com.google.a.ax
        public final /* bridge */ /* synthetic */ aw AP() {
            return bRR;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.a.ac
        public final /* synthetic */ at.a a(ac.b bVar) {
            return new a(bVar, (byte) 0);
        }

        @Override // com.google.a.at
        public final /* synthetic */ at.a AM() {
            return bRR.AN();
        }

        @Override // com.google.a.aw
        public final /* synthetic */ aw.a AO() {
            return bRR.AN();
        }
    }

    public static final class y extends ac.d<y> implements z {
        @Deprecated
        public static final bj<y> bPg = new c<y>() {
            /* class com.google.a.k.y.AnonymousClass1 */

            @Override // com.google.a.bj
            public final /* synthetic */ Object d(h hVar, r rVar) {
                return new y(hVar, rVar, (byte) 0);
            }
        };
        private static final y bRE = new y();
        private int bOT;
        boolean bPA;
        private List<ak> bPB;
        private byte bPe;
        private int bRD;

        /* synthetic */ y(ac.c cVar, byte b2) {
            this(cVar);
        }

        /* synthetic */ y(h hVar, r rVar, byte b2) {
            this(hVar, rVar);
        }

        private y(ac.c<y, ?> cVar) {
            super(cVar);
            this.bPe = -1;
        }

        private y() {
            this.bPe = -1;
            this.bRD = 0;
            this.bPB = Collections.emptyList();
        }

        @Override // com.google.a.az, com.google.a.ac
        public final cc Ax() {
            return this.bTW;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r3v3, resolved type: java.util.List<com.google.a.k$ak> */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARNING: Removed duplicated region for block: B:23:0x003e  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private y(com.google.a.h r7, com.google.a.r r8) {
            /*
            // Method dump skipped, instructions count: 186
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.a.k.y.<init>(com.google.a.h, com.google.a.r):void");
        }

        /* access modifiers changed from: protected */
        @Override // com.google.a.ac
        public final ac.f Ay() {
            return k.bOF.h(y.class, a.class);
        }

        public enum b implements bn {
            IDEMPOTENCY_UNKNOWN(0),
            NO_SIDE_EFFECTS(1),
            IDEMPOTENT(2);
            
            private static final ae.b<b> bPU = new ae.b<b>() {
                /* class com.google.a.k.y.b.AnonymousClass1 */
            };
            private static final b[] bRI = values();
            final int value;

            @Override // com.google.a.ae.a
            public final int getNumber() {
                return this.value;
            }

            private b(int i2) {
                this.value = i2;
            }

            @Deprecated
            public static b gw(int i2) {
                switch (i2) {
                    case 0:
                        return IDEMPOTENCY_UNKNOWN;
                    case 1:
                        return NO_SIDE_EFFECTS;
                    case 2:
                        return IDEMPOTENT;
                    default:
                        return null;
                }
            }
        }

        public final boolean BN() {
            return (this.bOT & 1) != 0;
        }

        public final boolean Ei() {
            return (this.bOT & 2) != 0;
        }

        public final b Ej() {
            b gw = b.gw(this.bRD);
            return gw == null ? b.IDEMPOTENCY_UNKNOWN : gw;
        }

        private int BO() {
            return this.bPB.size();
        }

        @Override // com.google.a.a, com.google.a.ax, com.google.a.ac.d, com.google.a.ac
        public final boolean isInitialized() {
            byte b2 = this.bPe;
            if (b2 == 1) {
                return true;
            }
            if (b2 == 0) {
                return false;
            }
            for (int i2 = 0; i2 < BO(); i2++) {
                if (!this.bPB.get(i2).isInitialized()) {
                    this.bPe = 0;
                    return false;
                }
            }
            if (!this.bWd.isInitialized()) {
                this.bPe = 0;
                return false;
            }
            this.bPe = 1;
            return true;
        }

        @Override // com.google.a.aw, com.google.a.a, com.google.a.ac
        public final void a(i iVar) {
            ac.d<MessageType>.a GC = GC();
            if ((this.bOT & 1) != 0) {
                iVar.r(33, this.bPA);
            }
            if ((this.bOT & 2) != 0) {
                iVar.bs(34, this.bRD);
            }
            for (int i2 = 0; i2 < this.bPB.size(); i2++) {
                iVar.a(999, this.bPB.get(i2));
            }
            GC.b(iVar);
            this.bTW.a(iVar);
        }

        @Override // com.google.a.aw, com.google.a.a, com.google.a.ac
        public final int yC() {
            int i2 = this.bNa;
            if (i2 != -1) {
                return i2;
            }
            int fR = (this.bOT & 1) != 0 ? i.fR(33) + 0 : 0;
            if ((this.bOT & 2) != 0) {
                fR += i.bv(34, this.bRD);
            }
            for (int i3 = 0; i3 < this.bPB.size(); i3++) {
                fR = i.c(999, this.bPB.get(i3)) + fR;
            }
            int yC = this.bWd.yC() + fR + this.bTW.yC();
            this.bNa = yC;
            return yC;
        }

        @Override // com.google.a.a
        public final boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof y)) {
                return super.equals(obj);
            }
            y yVar = (y) obj;
            if (BN() != yVar.BN()) {
                return false;
            }
            if (BN() && this.bPA != yVar.bPA) {
                return false;
            }
            if (Ei() != yVar.Ei()) {
                return false;
            }
            if (Ei() && this.bRD != yVar.bRD) {
                return false;
            }
            if (!this.bPB.equals(yVar.bPB)) {
                return false;
            }
            if (!this.bTW.equals(yVar.bTW)) {
                return false;
            }
            return this.bWd.FS().equals(yVar.bWd.FS());
        }

        @Override // com.google.a.a
        public final int hashCode() {
            if (this.bNb != 0) {
                return this.bNb;
            }
            int hashCode = k.bOE.hashCode() + com.tencent.mm.plugin.appbrand.jsapi.share.q.CTRL_INDEX;
            if (BN()) {
                hashCode = (((hashCode * 37) + 33) * 53) + ae.bF(this.bPA);
            }
            if (Ei()) {
                hashCode = (((hashCode * 37) + 34) * 53) + this.bRD;
            }
            if (BO() > 0) {
                hashCode = (((hashCode * 37) + 999) * 53) + this.bPB.hashCode();
            }
            int b2 = (b(hashCode, this.bWd.FS()) * 29) + this.bTW.hashCode();
            this.bNb = b2;
            return b2;
        }

        public static a b(y yVar) {
            return bRE.AN().d(yVar);
        }

        /* renamed from: Ek */
        public final a AN() {
            if (this == bRE) {
                return new a((byte) 0);
            }
            return new a((byte) 0).d(this);
        }

        public static final class a extends ac.c<y, a> implements z {
            private int bOT;
            private boolean bPA;
            private List<ak> bPB;
            private bq<ak, ak.a, al> bPD;
            private int bRD;

            /* synthetic */ a(byte b2) {
                this();
            }

            /* synthetic */ a(ac.b bVar, byte b2) {
                this(bVar);
            }

            /* access modifiers changed from: protected */
            @Override // com.google.a.ac.a
            public final ac.f Ay() {
                return k.bOF.h(y.class, a.class);
            }

            private a() {
                this.bRD = 0;
                this.bPB = Collections.emptyList();
                AR();
            }

            private a(ac.b bVar) {
                super(bVar);
                this.bRD = 0;
                this.bPB = Collections.emptyList();
                AR();
            }

            private void AR() {
                if (ac.bVU) {
                    BU();
                }
            }

            @Override // com.google.a.az, com.google.a.ac.a, com.google.a.at.a
            public final l.a AS() {
                return k.bOE;
            }

            /* access modifiers changed from: private */
            /* renamed from: Em */
            public y Bp() {
                y En = Bo();
                if (En.isInitialized()) {
                    return En;
                }
                throw b(En);
            }

            /* renamed from: En */
            public final y Bo() {
                int i2 = 0;
                y yVar = new y(this, (byte) 0);
                int i3 = this.bOT;
                if ((i3 & 1) != 0) {
                    yVar.bPA = this.bPA;
                    i2 = 1;
                }
                if ((i3 & 2) != 0) {
                    i2 |= 2;
                }
                yVar.bRD = this.bRD;
                if (this.bPD == null) {
                    if ((this.bOT & 4) != 0) {
                        this.bPB = Collections.unmodifiableList(this.bPB);
                        this.bOT &= -5;
                    }
                    yVar.bPB = this.bPB;
                } else {
                    yVar.bPB = this.bPD.build();
                }
                yVar.bOT = i2;
                Gy();
                return yVar;
            }

            /* access modifiers changed from: private */
            /* renamed from: K */
            public a r(l.f fVar, Object obj) {
                return (a) super.f(fVar, obj);
            }

            /* access modifiers changed from: private */
            /* renamed from: L */
            public a q(l.f fVar, Object obj) {
                return (a) super.e(fVar, obj);
            }

            /* access modifiers changed from: private */
            /* renamed from: s */
            public a c(at atVar) {
                if (atVar instanceof y) {
                    return d((y) atVar);
                }
                super.c(atVar);
                return this;
            }

            public final a d(y yVar) {
                bq<ak, ak.a, al> bqVar = null;
                if (yVar != y.El()) {
                    if (yVar.BN()) {
                        bB(yVar.bPA);
                    }
                    if (yVar.Ei()) {
                        a(yVar.Ej());
                    }
                    if (this.bPD == null) {
                        if (!yVar.bPB.isEmpty()) {
                            if (this.bPB.isEmpty()) {
                                this.bPB = yVar.bPB;
                                this.bOT &= -5;
                            } else {
                                BT();
                                this.bPB.addAll(yVar.bPB);
                            }
                            onChanged();
                        }
                    } else if (!yVar.bPB.isEmpty()) {
                        if (this.bPD.isEmpty()) {
                            this.bPD.bYP = null;
                            this.bPD = null;
                            this.bPB = yVar.bPB;
                            this.bOT &= -5;
                            if (ac.bVU) {
                                bqVar = BU();
                            }
                            this.bPD = bqVar;
                        } else {
                            this.bPD.a(yVar.bPB);
                        }
                    }
                    a((ac.d) yVar);
                    d(yVar.bTW);
                    onChanged();
                }
                return this;
            }

            @Override // com.google.a.ax, com.google.a.ac.c, com.google.a.ac.a
            public final boolean isInitialized() {
                int count;
                ak s;
                int i2 = 0;
                while (true) {
                    if (this.bPD == null) {
                        count = this.bPB.size();
                    } else {
                        count = this.bPD.getCount();
                    }
                    if (i2 < count) {
                        if (this.bPD == null) {
                            s = this.bPB.get(i2);
                        } else {
                            s = this.bPD.s(i2, false);
                        }
                        if (!s.isInitialized()) {
                            return false;
                        }
                        i2++;
                    } else if (this.bWd.isInitialized()) {
                        return true;
                    } else {
                        return false;
                    }
                }
            }

            /* access modifiers changed from: private */
            /* JADX WARNING: Removed duplicated region for block: B:16:0x001e  */
            /* renamed from: t */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public com.google.a.k.y.a c(com.google.a.h r4, com.google.a.r r5) {
                /*
                    r3 = this;
                    r2 = 0
                    com.google.a.bj<com.google.a.k$y> r0 = com.google.a.k.y.bPg     // Catch:{ af -> 0x000f }
                    java.lang.Object r0 = r0.d(r4, r5)     // Catch:{ af -> 0x000f }
                    com.google.a.k$y r0 = (com.google.a.k.y) r0     // Catch:{ af -> 0x000f }
                    if (r0 == 0) goto L_0x000e
                    r3.d(r0)
                L_0x000e:
                    return r3
                L_0x000f:
                    r0 = move-exception
                    r1 = r0
                    com.google.a.aw r0 = r1.bXr     // Catch:{ all -> 0x0022 }
                    com.google.a.k$y r0 = (com.google.a.k.y) r0     // Catch:{ all -> 0x0022 }
                    java.io.IOException r1 = r1.GF()     // Catch:{ all -> 0x001a }
                    throw r1     // Catch:{ all -> 0x001a }
                L_0x001a:
                    r1 = move-exception
                    r2 = r0
                L_0x001c:
                    if (r2 == 0) goto L_0x0021
                    r3.d(r2)
                L_0x0021:
                    throw r1
                L_0x0022:
                    r0 = move-exception
                    r1 = r0
                    goto L_0x001c
                */
                throw new UnsupportedOperationException("Method not decompiled: com.google.a.k.y.a.c(com.google.a.h, com.google.a.r):com.google.a.k$y$a");
            }

            private a bB(boolean z) {
                this.bOT |= 1;
                this.bPA = z;
                onChanged();
                return this;
            }

            private a a(b bVar) {
                if (bVar == null) {
                    throw new NullPointerException();
                }
                this.bOT |= 2;
                this.bRD = bVar.value;
                onChanged();
                return this;
            }

            private void BT() {
                if ((this.bOT & 4) == 0) {
                    this.bPB = new ArrayList(this.bPB);
                    this.bOT |= 4;
                }
            }

            private bq<ak, ak.a, al> BU() {
                if (this.bPD == null) {
                    this.bPD = new bq<>(this.bPB, (this.bOT & 4) != 0, GA(), this.bWv);
                    this.bPB = null;
                }
                return this.bPD;
            }

            /* access modifiers changed from: private */
            /* renamed from: I */
            public a f(cc ccVar) {
                return (a) super.f(ccVar);
            }

            /* access modifiers changed from: private */
            /* renamed from: J */
            public a d(cc ccVar) {
                return (a) super.a(ccVar);
            }

            @Override // com.google.a.az
            public final /* synthetic */ at AQ() {
                return y.El();
            }

            @Override // com.google.a.ax
            public final /* synthetic */ aw AP() {
                return y.El();
            }

            @Override // com.google.a.ac.a
            public final /* bridge */ /* synthetic */ ac.a Bl() {
                return (a) super.yG();
            }

            @Override // com.google.a.a.AbstractC0085a, com.google.a.ac.a
            public final /* synthetic */ a.AbstractC0085a yE() {
                return (a) super.yG();
            }

            @Override // com.google.a.b.a, com.google.a.a.AbstractC0085a, com.google.a.ac.a
            public final /* synthetic */ b.a yG() {
                return (a) super.yG();
            }

            @Override // com.google.a.b.a, com.google.a.a.AbstractC0085a, java.lang.Object, com.google.a.ac.a
            public final /* synthetic */ Object clone() {
                return (a) super.yG();
            }
        }

        public static y El() {
            return bRE;
        }

        @Override // com.google.a.aw, com.google.a.ac
        public final bj<y> AK() {
            return bPg;
        }

        @Override // com.google.a.az
        public final /* bridge */ /* synthetic */ at AQ() {
            return bRE;
        }

        @Override // com.google.a.ax
        public final /* bridge */ /* synthetic */ aw AP() {
            return bRE;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.a.ac
        public final /* synthetic */ at.a a(ac.b bVar) {
            return new a(bVar, (byte) 0);
        }

        @Override // com.google.a.at
        public final /* synthetic */ at.a AM() {
            return bRE.AN();
        }

        @Override // com.google.a.aw
        public final /* synthetic */ aw.a AO() {
            return bRE.AN();
        }
    }

    public static final class ak extends ac implements al {
        @Deprecated
        public static final bj<ak> bPg = new c<ak>() {
            /* class com.google.a.k.ak.AnonymousClass1 */

            @Override // com.google.a.bj
            public final /* synthetic */ Object d(h hVar, r rVar) {
                return new ak(hVar, rVar, (byte) 0);
            }
        };
        private static final ak bSk = new ak();
        private int bOT;
        private byte bPe;
        private List<b> bSd;
        private volatile Object bSe;
        long bSf;
        long bSg;
        double bSh;
        g bSi;
        private volatile Object bSj;

        public interface c extends az {
        }

        /* synthetic */ ak(ac.a aVar, byte b2) {
            this(aVar);
        }

        /* synthetic */ ak(h hVar, r rVar, byte b2) {
            this(hVar, rVar);
        }

        private ak(ac.a<?> aVar) {
            super(aVar);
            this.bPe = -1;
        }

        private ak() {
            this.bPe = -1;
            this.bSd = Collections.emptyList();
            this.bSe = "";
            this.bSi = g.bNg;
            this.bSj = "";
        }

        @Override // com.google.a.az, com.google.a.ac
        public final cc Ax() {
            return this.bTW;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r3v14, resolved type: java.util.List<com.google.a.k$ak$b> */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARNING: Removed duplicated region for block: B:26:0x004a  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private ak(com.google.a.h r9, com.google.a.r r10) {
            /*
            // Method dump skipped, instructions count: 240
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.a.k.ak.<init>(com.google.a.h, com.google.a.r):void");
        }

        /* access modifiers changed from: protected */
        @Override // com.google.a.ac
        public final ac.f Ay() {
            return k.bOH.h(ak.class, a.class);
        }

        public static final class b extends ac implements c {
            @Deprecated
            public static final bj<b> bPg = new c<b>() {
                /* class com.google.a.k.ak.b.AnonymousClass1 */

                @Override // com.google.a.bj
                public final /* synthetic */ Object d(h hVar, r rVar) {
                    return new b(hVar, rVar, (byte) 0);
                }
            };
            private static final b bSo = new b();
            private int bOT;
            private byte bPe;
            private volatile Object bSm;
            boolean bSn;

            /* synthetic */ b(ac.a aVar, byte b2) {
                this(aVar);
            }

            /* synthetic */ b(h hVar, r rVar, byte b2) {
                this(hVar, rVar);
            }

            private b(ac.a<?> aVar) {
                super(aVar);
                this.bPe = -1;
            }

            private b() {
                this.bPe = -1;
                this.bSm = "";
            }

            @Override // com.google.a.az, com.google.a.ac
            public final cc Ax() {
                return this.bTW;
            }

            private b(h hVar, r rVar) {
                this();
                if (rVar == null) {
                    throw new NullPointerException();
                }
                cc.a HJ = cc.HJ();
                boolean z = false;
                while (!z) {
                    try {
                        int yT = hVar.yT();
                        switch (yT) {
                            case 0:
                                z = true;
                                break;
                            case 10:
                                g zb = hVar.zb();
                                this.bOT |= 1;
                                this.bSm = zb;
                                break;
                            case 16:
                                this.bOT |= 2;
                                this.bSn = hVar.yZ();
                                break;
                            default:
                                if (a(hVar, HJ, rVar, yT)) {
                                    break;
                                } else {
                                    z = true;
                                    break;
                                }
                        }
                    } catch (af e2) {
                        e2.bXr = this;
                        throw e2;
                    } catch (IOException e3) {
                        af afVar = new af(e3);
                        afVar.bXr = this;
                        throw afVar;
                    } catch (Throwable th) {
                        this.bTW = HJ.Bp();
                        Gw();
                        throw th;
                    }
                }
                this.bTW = HJ.Bp();
                Gw();
            }

            /* access modifiers changed from: protected */
            @Override // com.google.a.ac
            public final ac.f Ay() {
                return k.bOJ.h(b.class, a.class);
            }

            public final boolean Fo() {
                return (this.bOT & 1) != 0;
            }

            private String Fp() {
                Object obj = this.bSm;
                if (obj instanceof String) {
                    return (String) obj;
                }
                g gVar = (g) obj;
                String yO = gVar.yO();
                if (gVar.yP()) {
                    this.bSm = yO;
                }
                return yO;
            }

            public final boolean Fq() {
                return (this.bOT & 2) != 0;
            }

            @Override // com.google.a.a, com.google.a.ax, com.google.a.ac
            public final boolean isInitialized() {
                byte b2 = this.bPe;
                if (b2 == 1) {
                    return true;
                }
                if (b2 == 0) {
                    return false;
                }
                if (!Fo()) {
                    this.bPe = 0;
                    return false;
                } else if (!Fq()) {
                    this.bPe = 0;
                    return false;
                } else {
                    this.bPe = 1;
                    return true;
                }
            }

            @Override // com.google.a.aw, com.google.a.a, com.google.a.ac
            public final void a(i iVar) {
                if ((this.bOT & 1) != 0) {
                    ac.a(iVar, 1, this.bSm);
                }
                if ((this.bOT & 2) != 0) {
                    iVar.r(2, this.bSn);
                }
                this.bTW.a(iVar);
            }

            @Override // com.google.a.aw, com.google.a.a, com.google.a.ac
            public final int yC() {
                int i2 = this.bNa;
                if (i2 != -1) {
                    return i2;
                }
                int i3 = 0;
                if ((this.bOT & 1) != 0) {
                    i3 = ac.d(1, this.bSm) + 0;
                }
                if ((this.bOT & 2) != 0) {
                    i3 += i.fR(2);
                }
                int yC = i3 + this.bTW.yC();
                this.bNa = yC;
                return yC;
            }

            @Override // com.google.a.a
            public final boolean equals(Object obj) {
                if (obj == this) {
                    return true;
                }
                if (!(obj instanceof b)) {
                    return super.equals(obj);
                }
                b bVar = (b) obj;
                if (Fo() != bVar.Fo()) {
                    return false;
                }
                if (Fo() && !Fp().equals(bVar.Fp())) {
                    return false;
                }
                if (Fq() != bVar.Fq()) {
                    return false;
                }
                if (!Fq() || this.bSn == bVar.bSn) {
                    return this.bTW.equals(bVar.bTW);
                }
                return false;
            }

            @Override // com.google.a.a
            public final int hashCode() {
                if (this.bNb != 0) {
                    return this.bNb;
                }
                int hashCode = k.bOI.hashCode() + com.tencent.mm.plugin.appbrand.jsapi.share.q.CTRL_INDEX;
                if (Fo()) {
                    hashCode = (((hashCode * 37) + 1) * 53) + Fp().hashCode();
                }
                if (Fq()) {
                    hashCode = (((hashCode * 37) + 2) * 53) + ae.bF(this.bSn);
                }
                int hashCode2 = (hashCode * 29) + this.bTW.hashCode();
                this.bNb = hashCode2;
                return hashCode2;
            }

            /* access modifiers changed from: private */
            /* renamed from: Fr */
            public a AN() {
                if (this == bSo) {
                    return new a((byte) 0);
                }
                return new a((byte) 0).b(this);
            }

            public static final class a extends ac.a<a> implements c {
                private int bOT;
                private Object bSm;
                private boolean bSn;

                /* synthetic */ a(byte b2) {
                    this();
                }

                /* synthetic */ a(ac.b bVar, byte b2) {
                    this(bVar);
                }

                /* access modifiers changed from: protected */
                @Override // com.google.a.ac.a
                public final ac.f Ay() {
                    return k.bOJ.h(b.class, a.class);
                }

                private a() {
                    this.bSm = "";
                    boolean z = ac.bVU;
                }

                private a(ac.b bVar) {
                    super(bVar);
                    this.bSm = "";
                    boolean z = ac.bVU;
                }

                @Override // com.google.a.az, com.google.a.ac.a, com.google.a.at.a
                public final l.a AS() {
                    return k.bOI;
                }

                /* access modifiers changed from: private */
                /* renamed from: Ft */
                public b Bp() {
                    b Fu = Bo();
                    if (Fu.isInitialized()) {
                        return Fu;
                    }
                    throw b((at) Fu);
                }

                /* access modifiers changed from: private */
                /* renamed from: Fu */
                public b Bo() {
                    int i2 = 0;
                    b bVar = new b(this, (byte) 0);
                    int i3 = this.bOT;
                    if ((i3 & 1) != 0) {
                        i2 = 1;
                    }
                    bVar.bSm = this.bSm;
                    if ((i3 & 2) != 0) {
                        bVar.bSn = this.bSn;
                        i2 |= 2;
                    }
                    bVar.bOT = i2;
                    Gy();
                    return bVar;
                }

                /* access modifiers changed from: private */
                /* renamed from: aa */
                public a f(l.f fVar, Object obj) {
                    return (a) super.f(fVar, obj);
                }

                /* access modifiers changed from: private */
                /* renamed from: ab */
                public a e(l.f fVar, Object obj) {
                    return (a) super.e(fVar, obj);
                }

                /* access modifiers changed from: private */
                /* renamed from: A */
                public a c(at atVar) {
                    if (atVar instanceof b) {
                        return b((b) atVar);
                    }
                    super.c(atVar);
                    return this;
                }

                public final a b(b bVar) {
                    if (bVar != b.Fs()) {
                        if (bVar.Fo()) {
                            this.bOT |= 1;
                            this.bSm = bVar.bSm;
                            onChanged();
                        }
                        if (bVar.Fq()) {
                            bD(bVar.bSn);
                        }
                        d(bVar.bTW);
                        onChanged();
                    }
                    return this;
                }

                @Override // com.google.a.ax, com.google.a.ac.a
                public final boolean isInitialized() {
                    boolean z;
                    boolean z2;
                    if ((this.bOT & 1) != 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (!z) {
                        return false;
                    }
                    if ((this.bOT & 2) != 0) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    return z2;
                }

                /* access modifiers changed from: private */
                /* JADX WARNING: Removed duplicated region for block: B:16:0x001e  */
                /* renamed from: B */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public com.google.a.k.ak.b.a c(com.google.a.h r4, com.google.a.r r5) {
                    /*
                        r3 = this;
                        r2 = 0
                        com.google.a.bj<com.google.a.k$ak$b> r0 = com.google.a.k.ak.b.bPg     // Catch:{ af -> 0x000f }
                        java.lang.Object r0 = r0.d(r4, r5)     // Catch:{ af -> 0x000f }
                        com.google.a.k$ak$b r0 = (com.google.a.k.ak.b) r0     // Catch:{ af -> 0x000f }
                        if (r0 == 0) goto L_0x000e
                        r3.b(r0)
                    L_0x000e:
                        return r3
                    L_0x000f:
                        r0 = move-exception
                        r1 = r0
                        com.google.a.aw r0 = r1.bXr     // Catch:{ all -> 0x0022 }
                        com.google.a.k$ak$b r0 = (com.google.a.k.ak.b) r0     // Catch:{ all -> 0x0022 }
                        java.io.IOException r1 = r1.GF()     // Catch:{ all -> 0x001a }
                        throw r1     // Catch:{ all -> 0x001a }
                    L_0x001a:
                        r1 = move-exception
                        r2 = r0
                    L_0x001c:
                        if (r2 == 0) goto L_0x0021
                        r3.b(r2)
                    L_0x0021:
                        throw r1
                    L_0x0022:
                        r0 = move-exception
                        r1 = r0
                        goto L_0x001c
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.google.a.k.ak.b.a.c(com.google.a.h, com.google.a.r):com.google.a.k$ak$b$a");
                }

                private a bD(boolean z) {
                    this.bOT |= 2;
                    this.bSn = z;
                    onChanged();
                    return this;
                }

                /* access modifiers changed from: private */
                /* renamed from: Y */
                public a f(cc ccVar) {
                    return (a) super.f(ccVar);
                }

                /* access modifiers changed from: private */
                /* renamed from: Z */
                public a d(cc ccVar) {
                    return (a) super.a(ccVar);
                }

                /* Return type fixed from 'com.google.a.ac$a' to match base method */
                @Override // com.google.a.ac.a
                public final /* bridge */ /* synthetic */ a Bl() {
                    return (a) super.yG();
                }

                @Override // com.google.a.a.AbstractC0085a, com.google.a.ac.a
                public final /* synthetic */ a.AbstractC0085a yE() {
                    return (a) super.yG();
                }

                @Override // com.google.a.ax
                public final /* synthetic */ aw AP() {
                    return b.Fs();
                }

                @Override // com.google.a.az
                public final /* synthetic */ at AQ() {
                    return b.Fs();
                }

                @Override // com.google.a.b.a, com.google.a.a.AbstractC0085a, com.google.a.ac.a
                public final /* synthetic */ b.a yG() {
                    return (a) super.yG();
                }

                @Override // com.google.a.b.a, com.google.a.a.AbstractC0085a, java.lang.Object, com.google.a.ac.a
                public final /* synthetic */ Object clone() {
                    return (a) super.yG();
                }
            }

            public static b Fs() {
                return bSo;
            }

            @Override // com.google.a.aw, com.google.a.ac
            public final bj<b> AK() {
                return bPg;
            }

            /* access modifiers changed from: protected */
            @Override // com.google.a.ac
            public final /* synthetic */ at.a a(ac.b bVar) {
                return new a(bVar, (byte) 0);
            }

            @Override // com.google.a.at
            public final /* synthetic */ at.a AM() {
                return bSo.AN();
            }

            @Override // com.google.a.aw
            public final /* synthetic */ aw.a AO() {
                return bSo.AN();
            }

            @Override // com.google.a.ax
            public final /* bridge */ /* synthetic */ aw AP() {
                return bSo;
            }

            @Override // com.google.a.az
            public final /* bridge */ /* synthetic */ at AQ() {
                return bSo;
            }
        }

        private int getNameCount() {
            return this.bSd.size();
        }

        public final boolean Fa() {
            return (this.bOT & 1) != 0;
        }

        private String Fb() {
            Object obj = this.bSe;
            if (obj instanceof String) {
                return (String) obj;
            }
            g gVar = (g) obj;
            String yO = gVar.yO();
            if (gVar.yP()) {
                this.bSe = yO;
            }
            return yO;
        }

        public final boolean Fc() {
            return (this.bOT & 2) != 0;
        }

        public final boolean Fd() {
            return (this.bOT & 4) != 0;
        }

        public final boolean Fe() {
            return (this.bOT & 8) != 0;
        }

        public final boolean Ff() {
            return (this.bOT & 16) != 0;
        }

        public final boolean Fg() {
            return (this.bOT & 32) != 0;
        }

        private String Fh() {
            Object obj = this.bSj;
            if (obj instanceof String) {
                return (String) obj;
            }
            g gVar = (g) obj;
            String yO = gVar.yO();
            if (gVar.yP()) {
                this.bSj = yO;
            }
            return yO;
        }

        @Override // com.google.a.a, com.google.a.ax, com.google.a.ac
        public final boolean isInitialized() {
            byte b2 = this.bPe;
            if (b2 == 1) {
                return true;
            }
            if (b2 == 0) {
                return false;
            }
            for (int i2 = 0; i2 < getNameCount(); i2++) {
                if (!this.bSd.get(i2).isInitialized()) {
                    this.bPe = 0;
                    return false;
                }
            }
            this.bPe = 1;
            return true;
        }

        @Override // com.google.a.aw, com.google.a.a, com.google.a.ac
        public final void a(i iVar) {
            for (int i2 = 0; i2 < this.bSd.size(); i2++) {
                iVar.a(2, this.bSd.get(i2));
            }
            if ((this.bOT & 1) != 0) {
                ac.a(iVar, 3, this.bSe);
            }
            if ((this.bOT & 2) != 0) {
                iVar.n(4, this.bSf);
            }
            if ((this.bOT & 4) != 0) {
                iVar.n(5, this.bSg);
            }
            if ((this.bOT & 8) != 0) {
                iVar.o(6, Double.doubleToRawLongBits(this.bSh));
            }
            if ((this.bOT & 16) != 0) {
                iVar.a(7, this.bSi);
            }
            if ((this.bOT & 32) != 0) {
                ac.a(iVar, 8, this.bSj);
            }
            this.bTW.a(iVar);
        }

        @Override // com.google.a.aw, com.google.a.a, com.google.a.ac
        public final int yC() {
            int i2 = this.bNa;
            if (i2 != -1) {
                return i2;
            }
            int i3 = 0;
            for (int i4 = 0; i4 < this.bSd.size(); i4++) {
                i3 += i.c(2, this.bSd.get(i4));
            }
            if ((this.bOT & 1) != 0) {
                i3 += ac.d(3, this.bSe);
            }
            if ((this.bOT & 2) != 0) {
                i3 += i.p(4, this.bSf);
            }
            if ((this.bOT & 4) != 0) {
                i3 += i.ay(this.bSg);
            }
            if ((this.bOT & 8) != 0) {
                i3 += i.zr();
            }
            if ((this.bOT & 16) != 0) {
                i3 += i.c(7, this.bSi);
            }
            if ((this.bOT & 32) != 0) {
                i3 += ac.d(8, this.bSj);
            }
            int yC = this.bTW.yC() + i3;
            this.bNa = yC;
            return yC;
        }

        @Override // com.google.a.a
        public final boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof ak)) {
                return super.equals(obj);
            }
            ak akVar = (ak) obj;
            if (!this.bSd.equals(akVar.bSd)) {
                return false;
            }
            if (Fa() != akVar.Fa()) {
                return false;
            }
            if (Fa() && !Fb().equals(akVar.Fb())) {
                return false;
            }
            if (Fc() != akVar.Fc()) {
                return false;
            }
            if (Fc() && this.bSf != akVar.bSf) {
                return false;
            }
            if (Fd() != akVar.Fd()) {
                return false;
            }
            if (Fd() && this.bSg != akVar.bSg) {
                return false;
            }
            if (Fe() != akVar.Fe()) {
                return false;
            }
            if (Fe() && Double.doubleToLongBits(this.bSh) != Double.doubleToLongBits(akVar.bSh)) {
                return false;
            }
            if (Ff() != akVar.Ff()) {
                return false;
            }
            if (Ff() && !this.bSi.equals(akVar.bSi)) {
                return false;
            }
            if (Fg() != akVar.Fg()) {
                return false;
            }
            if (!Fg() || Fh().equals(akVar.Fh())) {
                return this.bTW.equals(akVar.bTW);
            }
            return false;
        }

        @Override // com.google.a.a
        public final int hashCode() {
            if (this.bNb != 0) {
                return this.bNb;
            }
            int hashCode = k.bOG.hashCode() + com.tencent.mm.plugin.appbrand.jsapi.share.q.CTRL_INDEX;
            if (getNameCount() > 0) {
                hashCode = (((hashCode * 37) + 2) * 53) + this.bSd.hashCode();
            }
            if (Fa()) {
                hashCode = (((hashCode * 37) + 3) * 53) + Fb().hashCode();
            }
            if (Fc()) {
                hashCode = (((hashCode * 37) + 4) * 53) + ae.aF(this.bSf);
            }
            if (Fd()) {
                hashCode = (((hashCode * 37) + 5) * 53) + ae.aF(this.bSg);
            }
            if (Fe()) {
                hashCode = (((hashCode * 37) + 6) * 53) + ae.aF(Double.doubleToLongBits(this.bSh));
            }
            if (Ff()) {
                hashCode = (((hashCode * 37) + 7) * 53) + this.bSi.hashCode();
            }
            if (Fg()) {
                hashCode = (((hashCode * 37) + 8) * 53) + Fh().hashCode();
            }
            int hashCode2 = (hashCode * 29) + this.bTW.hashCode();
            this.bNb = hashCode2;
            return hashCode2;
        }

        /* access modifiers changed from: private */
        /* renamed from: Fi */
        public a AN() {
            if (this == bSk) {
                return new a((byte) 0);
            }
            return new a((byte) 0).d(this);
        }

        public static final class a extends ac.a<a> implements al {
            private int bOT;
            private List<b> bSd;
            private Object bSe;
            private long bSf;
            private long bSg;
            private double bSh;
            private g bSi;
            private Object bSj;
            private bq<b, b.a, c> bSl;

            /* synthetic */ a(byte b2) {
                this();
            }

            /* synthetic */ a(ac.b bVar, byte b2) {
                this(bVar);
            }

            /* access modifiers changed from: protected */
            @Override // com.google.a.ac.a
            public final ac.f Ay() {
                return k.bOH.h(ak.class, a.class);
            }

            private a() {
                this.bSd = Collections.emptyList();
                this.bSe = "";
                this.bSi = g.bNg;
                this.bSj = "";
                AR();
            }

            private a(ac.b bVar) {
                super(bVar);
                this.bSd = Collections.emptyList();
                this.bSe = "";
                this.bSi = g.bNg;
                this.bSj = "";
                AR();
            }

            private void AR() {
                if (ac.bVU) {
                    Fn();
                }
            }

            @Override // com.google.a.az, com.google.a.ac.a, com.google.a.at.a
            public final l.a AS() {
                return k.bOG;
            }

            /* access modifiers changed from: private */
            /* renamed from: Fk */
            public ak Bp() {
                ak Fl = Bo();
                if (Fl.isInitialized()) {
                    return Fl;
                }
                throw b(Fl);
            }

            /* access modifiers changed from: private */
            /* renamed from: Fl */
            public ak Bo() {
                int i2 = 0;
                ak akVar = new ak(this, (byte) 0);
                int i3 = this.bOT;
                if (this.bSl == null) {
                    if ((this.bOT & 1) != 0) {
                        this.bSd = Collections.unmodifiableList(this.bSd);
                        this.bOT &= -2;
                    }
                    akVar.bSd = this.bSd;
                } else {
                    akVar.bSd = this.bSl.build();
                }
                if ((i3 & 2) != 0) {
                    i2 = 1;
                }
                akVar.bSe = this.bSe;
                if ((i3 & 4) != 0) {
                    akVar.bSf = this.bSf;
                    i2 |= 2;
                }
                if ((i3 & 8) != 0) {
                    akVar.bSg = this.bSg;
                    i2 |= 4;
                }
                if ((i3 & 16) != 0) {
                    akVar.bSh = this.bSh;
                    i2 |= 8;
                }
                if ((i3 & 32) != 0) {
                    i2 |= 16;
                }
                akVar.bSi = this.bSi;
                if ((i3 & 64) != 0) {
                    i2 |= 32;
                }
                akVar.bSj = this.bSj;
                akVar.bOT = i2;
                Gy();
                return akVar;
            }

            /* access modifiers changed from: private */
            /* renamed from: Y */
            public a f(l.f fVar, Object obj) {
                return (a) super.f(fVar, obj);
            }

            /* access modifiers changed from: private */
            /* renamed from: Z */
            public a e(l.f fVar, Object obj) {
                return (a) super.e(fVar, obj);
            }

            /* access modifiers changed from: private */
            /* renamed from: z */
            public a c(at atVar) {
                if (atVar instanceof ak) {
                    return d((ak) atVar);
                }
                super.c(atVar);
                return this;
            }

            public final a d(ak akVar) {
                bq<b, b.a, c> bqVar = null;
                if (akVar != ak.Fj()) {
                    if (this.bSl == null) {
                        if (!akVar.bSd.isEmpty()) {
                            if (this.bSd.isEmpty()) {
                                this.bSd = akVar.bSd;
                                this.bOT &= -2;
                            } else {
                                Fm();
                                this.bSd.addAll(akVar.bSd);
                            }
                            onChanged();
                        }
                    } else if (!akVar.bSd.isEmpty()) {
                        if (this.bSl.isEmpty()) {
                            this.bSl.bYP = null;
                            this.bSl = null;
                            this.bSd = akVar.bSd;
                            this.bOT &= -2;
                            if (ac.bVU) {
                                bqVar = Fn();
                            }
                            this.bSl = bqVar;
                        } else {
                            this.bSl.a(akVar.bSd);
                        }
                    }
                    if (akVar.Fa()) {
                        this.bOT |= 2;
                        this.bSe = akVar.bSe;
                        onChanged();
                    }
                    if (akVar.Fc()) {
                        aD(akVar.bSf);
                    }
                    if (akVar.Fd()) {
                        aE(akVar.bSg);
                    }
                    if (akVar.Fe()) {
                        g(akVar.bSh);
                    }
                    if (akVar.Ff()) {
                        c(akVar.bSi);
                    }
                    if (akVar.Fg()) {
                        this.bOT |= 64;
                        this.bSj = akVar.bSj;
                        onChanged();
                    }
                    d(akVar.bTW);
                    onChanged();
                }
                return this;
            }

            @Override // com.google.a.ax, com.google.a.ac.a
            public final boolean isInitialized() {
                int count;
                b s;
                int i2 = 0;
                while (true) {
                    if (this.bSl == null) {
                        count = this.bSd.size();
                    } else {
                        count = this.bSl.getCount();
                    }
                    if (i2 >= count) {
                        return true;
                    }
                    if (this.bSl == null) {
                        s = this.bSd.get(i2);
                    } else {
                        s = this.bSl.s(i2, false);
                    }
                    if (!s.isInitialized()) {
                        return false;
                    }
                    i2++;
                }
            }

            /* access modifiers changed from: private */
            /* JADX WARNING: Removed duplicated region for block: B:16:0x001e  */
            /* renamed from: A */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public com.google.a.k.ak.a c(com.google.a.h r4, com.google.a.r r5) {
                /*
                    r3 = this;
                    r2 = 0
                    com.google.a.bj<com.google.a.k$ak> r0 = com.google.a.k.ak.bPg     // Catch:{ af -> 0x000f }
                    java.lang.Object r0 = r0.d(r4, r5)     // Catch:{ af -> 0x000f }
                    com.google.a.k$ak r0 = (com.google.a.k.ak) r0     // Catch:{ af -> 0x000f }
                    if (r0 == 0) goto L_0x000e
                    r3.d(r0)
                L_0x000e:
                    return r3
                L_0x000f:
                    r0 = move-exception
                    r1 = r0
                    com.google.a.aw r0 = r1.bXr     // Catch:{ all -> 0x0022 }
                    com.google.a.k$ak r0 = (com.google.a.k.ak) r0     // Catch:{ all -> 0x0022 }
                    java.io.IOException r1 = r1.GF()     // Catch:{ all -> 0x001a }
                    throw r1     // Catch:{ all -> 0x001a }
                L_0x001a:
                    r1 = move-exception
                    r2 = r0
                L_0x001c:
                    if (r2 == 0) goto L_0x0021
                    r3.d(r2)
                L_0x0021:
                    throw r1
                L_0x0022:
                    r0 = move-exception
                    r1 = r0
                    goto L_0x001c
                */
                throw new UnsupportedOperationException("Method not decompiled: com.google.a.k.ak.a.c(com.google.a.h, com.google.a.r):com.google.a.k$ak$a");
            }

            private void Fm() {
                if ((this.bOT & 1) == 0) {
                    this.bSd = new ArrayList(this.bSd);
                    this.bOT |= 1;
                }
            }

            private bq<b, b.a, c> Fn() {
                if (this.bSl == null) {
                    this.bSl = new bq<>(this.bSd, (this.bOT & 1) != 0, GA(), this.bWv);
                    this.bSd = null;
                }
                return this.bSl;
            }

            private a aD(long j2) {
                this.bOT |= 4;
                this.bSf = j2;
                onChanged();
                return this;
            }

            private a aE(long j2) {
                this.bOT |= 8;
                this.bSg = j2;
                onChanged();
                return this;
            }

            private a g(double d2) {
                this.bOT |= 16;
                this.bSh = d2;
                onChanged();
                return this;
            }

            private a c(g gVar) {
                if (gVar == null) {
                    throw new NullPointerException();
                }
                this.bOT |= 32;
                this.bSi = gVar;
                onChanged();
                return this;
            }

            /* access modifiers changed from: private */
            /* renamed from: W */
            public a f(cc ccVar) {
                return (a) super.f(ccVar);
            }

            /* access modifiers changed from: private */
            /* renamed from: X */
            public a d(cc ccVar) {
                return (a) super.a(ccVar);
            }

            /* Return type fixed from 'com.google.a.ac$a' to match base method */
            @Override // com.google.a.ac.a
            public final /* bridge */ /* synthetic */ a Bl() {
                return (a) super.yG();
            }

            @Override // com.google.a.a.AbstractC0085a, com.google.a.ac.a
            public final /* synthetic */ a.AbstractC0085a yE() {
                return (a) super.yG();
            }

            @Override // com.google.a.ax
            public final /* synthetic */ aw AP() {
                return ak.Fj();
            }

            @Override // com.google.a.az
            public final /* synthetic */ at AQ() {
                return ak.Fj();
            }

            @Override // com.google.a.b.a, com.google.a.a.AbstractC0085a, com.google.a.ac.a
            public final /* synthetic */ b.a yG() {
                return (a) super.yG();
            }

            @Override // com.google.a.b.a, com.google.a.a.AbstractC0085a, java.lang.Object, com.google.a.ac.a
            public final /* synthetic */ Object clone() {
                return (a) super.yG();
            }
        }

        public static ak Fj() {
            return bSk;
        }

        @Override // com.google.a.aw, com.google.a.ac
        public final bj<ak> AK() {
            return bPg;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.a.ac
        public final /* synthetic */ at.a a(ac.b bVar) {
            return new a(bVar, (byte) 0);
        }

        @Override // com.google.a.at
        public final /* synthetic */ at.a AM() {
            return bSk.AN();
        }

        @Override // com.google.a.aw
        public final /* synthetic */ aw.a AO() {
            return bSk.AN();
        }

        @Override // com.google.a.ax
        public final /* bridge */ /* synthetic */ aw AP() {
            return bSk;
        }

        @Override // com.google.a.az
        public final /* bridge */ /* synthetic */ at AQ() {
            return bSk;
        }
    }

    public static final class ai extends ac implements aj {
        @Deprecated
        public static final bj<ai> bPg = new c<ai>() {
            /* class com.google.a.k.ai.AnonymousClass1 */

            @Override // com.google.a.bj
            public final /* synthetic */ Object d(h hVar, r rVar) {
                return new ai(hVar, rVar, (byte) 0);
            }
        };
        private static final ai bRT = new ai();
        private byte bPe;
        private List<b> bRS;

        public interface c extends az {
        }

        /* synthetic */ ai(ac.a aVar, byte b2) {
            this(aVar);
        }

        /* synthetic */ ai(h hVar, r rVar, byte b2) {
            this(hVar, rVar);
        }

        private ai(ac.a<?> aVar) {
            super(aVar);
            this.bPe = -1;
        }

        private ai() {
            this.bPe = -1;
            this.bRS = Collections.emptyList();
        }

        @Override // com.google.a.az, com.google.a.ac
        public final cc Ax() {
            return this.bTW;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r3v3, resolved type: java.util.List<com.google.a.k$ai$b> */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARNING: Removed duplicated region for block: B:26:0x004a  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private ai(com.google.a.h r7, com.google.a.r r8) {
            /*
            // Method dump skipped, instructions count: 136
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.a.k.ai.<init>(com.google.a.h, com.google.a.r):void");
        }

        /* access modifiers changed from: protected */
        @Override // com.google.a.ac
        public final ac.f Ay() {
            return k.bOL.h(ai.class, a.class);
        }

        public static final class b extends ac implements c {
            @Deprecated
            public static final bj<b> bPg = new c<b>() {
                /* class com.google.a.k.ai.b.AnonymousClass1 */

                @Override // com.google.a.bj
                public final /* synthetic */ Object d(h hVar, r rVar) {
                    return new b(hVar, rVar, (byte) 0);
                }
            };
            private static final b bSc = new b();
            private int bOT;
            private byte bPe;
            private ae.d bRV;
            private int bRW;
            private ae.d bRX;
            private int bRY;
            private volatile Object bRZ;
            private volatile Object bSa;
            private ak bSb;

            /* synthetic */ b(ac.a aVar, byte b2) {
                this(aVar);
            }

            /* synthetic */ b(h hVar, r rVar, byte b2) {
                this(hVar, rVar);
            }

            private b(ac.a<?> aVar) {
                super(aVar);
                this.bRW = -1;
                this.bRY = -1;
                this.bPe = -1;
            }

            private b() {
                this.bRW = -1;
                this.bRY = -1;
                this.bPe = -1;
                this.bRV = ad.GE();
                this.bRX = ad.GE();
                this.bRZ = "";
                this.bSa = "";
                this.bSb = aj.bXM;
            }

            @Override // com.google.a.az, com.google.a.ac
            public final cc Ax() {
                return this.bTW;
            }

            /* JADX WARNING: Removed duplicated region for block: B:26:0x0048  */
            /* JADX WARNING: Removed duplicated region for block: B:29:0x0051  */
            /* JADX WARNING: Removed duplicated region for block: B:32:0x005a  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            private b(com.google.a.h r8, com.google.a.r r9) {
                /*
                // Method dump skipped, instructions count: 366
                */
                throw new UnsupportedOperationException("Method not decompiled: com.google.a.k.ai.b.<init>(com.google.a.h, com.google.a.r):void");
            }

            /* access modifiers changed from: protected */
            @Override // com.google.a.ac
            public final ac.f Ay() {
                return k.bON.h(b.class, a.class);
            }

            public final boolean EP() {
                return (this.bOT & 1) != 0;
            }

            private String EQ() {
                Object obj = this.bRZ;
                if (obj instanceof String) {
                    return (String) obj;
                }
                g gVar = (g) obj;
                String yO = gVar.yO();
                if (gVar.yP()) {
                    this.bRZ = yO;
                }
                return yO;
            }

            public final boolean ER() {
                return (this.bOT & 2) != 0;
            }

            private String ES() {
                Object obj = this.bSa;
                if (obj instanceof String) {
                    return (String) obj;
                }
                g gVar = (g) obj;
                String yO = gVar.yO();
                if (gVar.yP()) {
                    this.bSa = yO;
                }
                return yO;
            }

            @Override // com.google.a.a, com.google.a.ax, com.google.a.ac
            public final boolean isInitialized() {
                byte b2 = this.bPe;
                if (b2 == 1) {
                    return true;
                }
                if (b2 == 0) {
                    return false;
                }
                this.bPe = 1;
                return true;
            }

            @Override // com.google.a.aw, com.google.a.a, com.google.a.ac
            public final void a(i iVar) {
                yC();
                if (this.bRV.size() > 0) {
                    iVar.fL(10);
                    iVar.fL(this.bRW);
                }
                for (int i2 = 0; i2 < this.bRV.size(); i2++) {
                    iVar.fK(this.bRV.getInt(i2));
                }
                if (this.bRX.size() > 0) {
                    iVar.fL(18);
                    iVar.fL(this.bRY);
                }
                for (int i3 = 0; i3 < this.bRX.size(); i3++) {
                    iVar.fK(this.bRX.getInt(i3));
                }
                if ((this.bOT & 1) != 0) {
                    ac.a(iVar, 3, this.bRZ);
                }
                if ((this.bOT & 2) != 0) {
                    ac.a(iVar, 4, this.bSa);
                }
                for (int i4 = 0; i4 < this.bSb.size(); i4++) {
                    ac.a(iVar, 6, this.bSb.getRaw(i4));
                }
                this.bTW.a(iVar);
            }

            @Override // com.google.a.aw, com.google.a.a, com.google.a.ac
            public final int yC() {
                int i2 = this.bNa;
                if (i2 != -1) {
                    return i2;
                }
                int i3 = 0;
                for (int i4 = 0; i4 < this.bRV.size(); i4++) {
                    i3 += i.fT(this.bRV.getInt(i4));
                }
                int i5 = i3 + 0;
                if (!this.bRV.isEmpty()) {
                    i5 = i5 + 1 + i.fT(i3);
                }
                this.bRW = i3;
                int i6 = 0;
                for (int i7 = 0; i7 < this.bRX.size(); i7++) {
                    i6 += i.fT(this.bRX.getInt(i7));
                }
                int i8 = i5 + i6;
                if (!this.bRX.isEmpty()) {
                    i8 = i8 + 1 + i.fT(i6);
                }
                this.bRY = i6;
                if ((this.bOT & 1) != 0) {
                    i8 += ac.d(3, this.bRZ);
                }
                if ((this.bOT & 2) != 0) {
                    i8 += ac.d(4, this.bSa);
                }
                int i9 = 0;
                for (int i10 = 0; i10 < this.bSb.size(); i10++) {
                    i9 += ar(this.bSb.getRaw(i10));
                }
                int size = i8 + i9 + (this.bSb.size() * 1) + this.bTW.yC();
                this.bNa = size;
                return size;
            }

            @Override // com.google.a.a
            public final boolean equals(Object obj) {
                if (obj == this) {
                    return true;
                }
                if (!(obj instanceof b)) {
                    return super.equals(obj);
                }
                b bVar = (b) obj;
                if (!this.bRV.equals(bVar.bRV)) {
                    return false;
                }
                if (!this.bRX.equals(bVar.bRX)) {
                    return false;
                }
                if (EP() != bVar.EP()) {
                    return false;
                }
                if (EP() && !EQ().equals(bVar.EQ())) {
                    return false;
                }
                if (ER() != bVar.ER()) {
                    return false;
                }
                if (ER() && !ES().equals(bVar.ES())) {
                    return false;
                }
                if (!this.bSb.equals(bVar.bSb)) {
                    return false;
                }
                return this.bTW.equals(bVar.bTW);
            }

            @Override // com.google.a.a
            public final int hashCode() {
                if (this.bNb != 0) {
                    return this.bNb;
                }
                int hashCode = k.bOM.hashCode() + com.tencent.mm.plugin.appbrand.jsapi.share.q.CTRL_INDEX;
                if (this.bRV.size() > 0) {
                    hashCode = (((hashCode * 37) + 1) * 53) + this.bRV.hashCode();
                }
                if (this.bRX.size() > 0) {
                    hashCode = (((hashCode * 37) + 2) * 53) + this.bRX.hashCode();
                }
                if (EP()) {
                    hashCode = (((hashCode * 37) + 3) * 53) + EQ().hashCode();
                }
                if (ER()) {
                    hashCode = (((hashCode * 37) + 4) * 53) + ES().hashCode();
                }
                if (this.bSb.size() > 0) {
                    hashCode = (((hashCode * 37) + 6) * 53) + this.bSb.hashCode();
                }
                int hashCode2 = (hashCode * 29) + this.bTW.hashCode();
                this.bNb = hashCode2;
                return hashCode2;
            }

            /* access modifiers changed from: private */
            /* renamed from: ET */
            public a AN() {
                if (this == bSc) {
                    return new a((byte) 0);
                }
                return new a((byte) 0).f(this);
            }

            public static final class a extends ac.a<a> implements c {
                private int bOT;
                private ae.d bRV;
                private ae.d bRX;
                private Object bRZ;
                private Object bSa;
                private ak bSb;

                /* synthetic */ a(byte b2) {
                    this();
                }

                /* synthetic */ a(ac.b bVar, byte b2) {
                    this(bVar);
                }

                /* access modifiers changed from: protected */
                @Override // com.google.a.ac.a
                public final ac.f Ay() {
                    return k.bON.h(b.class, a.class);
                }

                private a() {
                    this.bRV = ac.Gv();
                    this.bRX = ac.Gv();
                    this.bRZ = "";
                    this.bSa = "";
                    this.bSb = aj.bXM;
                    boolean z = ac.bVU;
                }

                private a(ac.b bVar) {
                    super(bVar);
                    this.bRV = ac.Gv();
                    this.bRX = ac.Gv();
                    this.bRZ = "";
                    this.bSa = "";
                    this.bSb = aj.bXM;
                    boolean z = ac.bVU;
                }

                @Override // com.google.a.az, com.google.a.ac.a, com.google.a.at.a
                public final l.a AS() {
                    return k.bOM;
                }

                /* access modifiers changed from: private */
                /* renamed from: EV */
                public b Bp() {
                    b EW = Bo();
                    if (EW.isInitialized()) {
                        return EW;
                    }
                    throw b(EW);
                }

                /* access modifiers changed from: private */
                /* renamed from: EW */
                public b Bo() {
                    int i2 = 0;
                    b bVar = new b(this, (byte) 0);
                    int i3 = this.bOT;
                    if ((this.bOT & 1) != 0) {
                        this.bRV.yK();
                        this.bOT &= -2;
                    }
                    bVar.bRV = this.bRV;
                    if ((this.bOT & 2) != 0) {
                        this.bRX.yK();
                        this.bOT &= -3;
                    }
                    bVar.bRX = this.bRX;
                    if ((i3 & 4) != 0) {
                        i2 = 1;
                    }
                    bVar.bRZ = this.bRZ;
                    if ((i3 & 8) != 0) {
                        i2 |= 2;
                    }
                    bVar.bSa = this.bSa;
                    if ((this.bOT & 16) != 0) {
                        this.bSb = this.bSb.GR();
                        this.bOT &= -17;
                    }
                    bVar.bSb = this.bSb;
                    bVar.bOT = i2;
                    Gy();
                    return bVar;
                }

                /* access modifiers changed from: private */
                /* renamed from: W */
                public a f(l.f fVar, Object obj) {
                    return (a) super.f(fVar, obj);
                }

                /* access modifiers changed from: private */
                /* renamed from: X */
                public a e(l.f fVar, Object obj) {
                    return (a) super.e(fVar, obj);
                }

                /* access modifiers changed from: private */
                /* renamed from: y */
                public a c(at atVar) {
                    if (atVar instanceof b) {
                        return f((b) atVar);
                    }
                    super.c(atVar);
                    return this;
                }

                public final a f(b bVar) {
                    if (bVar != b.EU()) {
                        if (!bVar.bRV.isEmpty()) {
                            if (this.bRV.isEmpty()) {
                                this.bRV = bVar.bRV;
                                this.bOT &= -2;
                            } else {
                                EX();
                                this.bRV.addAll(bVar.bRV);
                            }
                            onChanged();
                        }
                        if (!bVar.bRX.isEmpty()) {
                            if (this.bRX.isEmpty()) {
                                this.bRX = bVar.bRX;
                                this.bOT &= -3;
                            } else {
                                EY();
                                this.bRX.addAll(bVar.bRX);
                            }
                            onChanged();
                        }
                        if (bVar.EP()) {
                            this.bOT |= 4;
                            this.bRZ = bVar.bRZ;
                            onChanged();
                        }
                        if (bVar.ER()) {
                            this.bOT |= 8;
                            this.bSa = bVar.bSa;
                            onChanged();
                        }
                        if (!bVar.bSb.isEmpty()) {
                            if (this.bSb.isEmpty()) {
                                this.bSb = bVar.bSb;
                                this.bOT &= -17;
                            } else {
                                EZ();
                                this.bSb.addAll(bVar.bSb);
                            }
                            onChanged();
                        }
                        d(bVar.bTW);
                        onChanged();
                    }
                    return this;
                }

                @Override // com.google.a.ax, com.google.a.ac.a
                public final boolean isInitialized() {
                    return true;
                }

                /* access modifiers changed from: private */
                /* JADX WARNING: Removed duplicated region for block: B:16:0x001e  */
                /* renamed from: z */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public com.google.a.k.ai.b.a c(com.google.a.h r4, com.google.a.r r5) {
                    /*
                        r3 = this;
                        r2 = 0
                        com.google.a.bj<com.google.a.k$ai$b> r0 = com.google.a.k.ai.b.bPg     // Catch:{ af -> 0x000f }
                        java.lang.Object r0 = r0.d(r4, r5)     // Catch:{ af -> 0x000f }
                        com.google.a.k$ai$b r0 = (com.google.a.k.ai.b) r0     // Catch:{ af -> 0x000f }
                        if (r0 == 0) goto L_0x000e
                        r3.f(r0)
                    L_0x000e:
                        return r3
                    L_0x000f:
                        r0 = move-exception
                        r1 = r0
                        com.google.a.aw r0 = r1.bXr     // Catch:{ all -> 0x0022 }
                        com.google.a.k$ai$b r0 = (com.google.a.k.ai.b) r0     // Catch:{ all -> 0x0022 }
                        java.io.IOException r1 = r1.GF()     // Catch:{ all -> 0x001a }
                        throw r1     // Catch:{ all -> 0x001a }
                    L_0x001a:
                        r1 = move-exception
                        r2 = r0
                    L_0x001c:
                        if (r2 == 0) goto L_0x0021
                        r3.f(r2)
                    L_0x0021:
                        throw r1
                    L_0x0022:
                        r0 = move-exception
                        r1 = r0
                        goto L_0x001c
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.google.a.k.ai.b.a.c(com.google.a.h, com.google.a.r):com.google.a.k$ai$b$a");
                }

                private void EX() {
                    if ((this.bOT & 1) == 0) {
                        this.bRV = ac.a(this.bRV);
                        this.bOT |= 1;
                    }
                }

                private void EY() {
                    if ((this.bOT & 2) == 0) {
                        this.bRX = ac.a(this.bRX);
                        this.bOT |= 2;
                    }
                }

                private void EZ() {
                    if ((this.bOT & 16) == 0) {
                        this.bSb = new aj(this.bSb);
                        this.bOT |= 16;
                    }
                }

                /* access modifiers changed from: private */
                /* renamed from: U */
                public a f(cc ccVar) {
                    return (a) super.f(ccVar);
                }

                /* access modifiers changed from: private */
                /* renamed from: V */
                public a d(cc ccVar) {
                    return (a) super.a(ccVar);
                }

                /* Return type fixed from 'com.google.a.ac$a' to match base method */
                @Override // com.google.a.ac.a
                public final /* bridge */ /* synthetic */ a Bl() {
                    return (a) super.yG();
                }

                @Override // com.google.a.a.AbstractC0085a, com.google.a.ac.a
                public final /* synthetic */ a.AbstractC0085a yE() {
                    return (a) super.yG();
                }

                @Override // com.google.a.ax
                public final /* synthetic */ aw AP() {
                    return b.EU();
                }

                @Override // com.google.a.az
                public final /* synthetic */ at AQ() {
                    return b.EU();
                }

                @Override // com.google.a.b.a, com.google.a.a.AbstractC0085a, com.google.a.ac.a
                public final /* synthetic */ b.a yG() {
                    return (a) super.yG();
                }

                @Override // com.google.a.b.a, com.google.a.a.AbstractC0085a, java.lang.Object, com.google.a.ac.a
                public final /* synthetic */ Object clone() {
                    return (a) super.yG();
                }
            }

            public static b EU() {
                return bSc;
            }

            @Override // com.google.a.aw, com.google.a.ac
            public final bj<b> AK() {
                return bPg;
            }

            /* access modifiers changed from: protected */
            @Override // com.google.a.ac
            public final /* synthetic */ at.a a(ac.b bVar) {
                return new a(bVar, (byte) 0);
            }

            @Override // com.google.a.at
            public final /* synthetic */ at.a AM() {
                return bSc.AN();
            }

            @Override // com.google.a.aw
            public final /* synthetic */ aw.a AO() {
                return bSc.AN();
            }

            @Override // com.google.a.ax
            public final /* bridge */ /* synthetic */ aw AP() {
                return bSc;
            }

            @Override // com.google.a.az
            public final /* bridge */ /* synthetic */ at AQ() {
                return bSc;
            }
        }

        @Override // com.google.a.a, com.google.a.ax, com.google.a.ac
        public final boolean isInitialized() {
            byte b2 = this.bPe;
            if (b2 == 1) {
                return true;
            }
            if (b2 == 0) {
                return false;
            }
            this.bPe = 1;
            return true;
        }

        @Override // com.google.a.aw, com.google.a.a, com.google.a.ac
        public final void a(i iVar) {
            for (int i2 = 0; i2 < this.bRS.size(); i2++) {
                iVar.a(1, this.bRS.get(i2));
            }
            this.bTW.a(iVar);
        }

        @Override // com.google.a.aw, com.google.a.a, com.google.a.ac
        public final int yC() {
            int i2 = this.bNa;
            if (i2 != -1) {
                return i2;
            }
            int i3 = 0;
            for (int i4 = 0; i4 < this.bRS.size(); i4++) {
                i3 += i.c(1, this.bRS.get(i4));
            }
            int yC = this.bTW.yC() + i3;
            this.bNa = yC;
            return yC;
        }

        @Override // com.google.a.a
        public final boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof ai)) {
                return super.equals(obj);
            }
            ai aiVar = (ai) obj;
            if (!this.bRS.equals(aiVar.bRS)) {
                return false;
            }
            return this.bTW.equals(aiVar.bTW);
        }

        @Override // com.google.a.a
        public final int hashCode() {
            if (this.bNb != 0) {
                return this.bNb;
            }
            int hashCode = k.bOK.hashCode() + com.tencent.mm.plugin.appbrand.jsapi.share.q.CTRL_INDEX;
            if (this.bRS.size() > 0) {
                hashCode = (((hashCode * 37) + 1) * 53) + this.bRS.hashCode();
            }
            int hashCode2 = (hashCode * 29) + this.bTW.hashCode();
            this.bNb = hashCode2;
            return hashCode2;
        }

        public static a b(ai aiVar) {
            return bRT.AN().d(aiVar);
        }

        /* renamed from: EJ */
        public final a AN() {
            if (this == bRT) {
                return new a((byte) 0);
            }
            return new a((byte) 0).d(this);
        }

        public static final class a extends ac.a<a> implements aj {
            private int bOT;
            private List<b> bRS;
            private bq<b, b.a, c> bRU;

            /* synthetic */ a(byte b2) {
                this();
            }

            /* synthetic */ a(ac.b bVar, byte b2) {
                this(bVar);
            }

            /* access modifiers changed from: protected */
            @Override // com.google.a.ac.a
            public final ac.f Ay() {
                return k.bOL.h(ai.class, a.class);
            }

            private a() {
                this.bRS = Collections.emptyList();
                AR();
            }

            private a(ac.b bVar) {
                super(bVar);
                this.bRS = Collections.emptyList();
                AR();
            }

            private void AR() {
                if (ac.bVU) {
                    EO();
                }
            }

            @Override // com.google.a.az, com.google.a.ac.a, com.google.a.at.a
            public final l.a AS() {
                return k.bOK;
            }

            /* access modifiers changed from: private */
            /* renamed from: EL */
            public ai Bp() {
                ai EM = Bo();
                if (EM.isInitialized()) {
                    return EM;
                }
                throw b(EM);
            }

            /* renamed from: EM */
            public final ai Bo() {
                ai aiVar = new ai(this, (byte) 0);
                if (this.bRU == null) {
                    if ((this.bOT & 1) != 0) {
                        this.bRS = Collections.unmodifiableList(this.bRS);
                        this.bOT &= -2;
                    }
                    aiVar.bRS = this.bRS;
                } else {
                    aiVar.bRS = this.bRU.build();
                }
                Gy();
                return aiVar;
            }

            /* access modifiers changed from: private */
            /* renamed from: U */
            public a f(l.f fVar, Object obj) {
                return (a) super.f(fVar, obj);
            }

            /* access modifiers changed from: private */
            /* renamed from: V */
            public a e(l.f fVar, Object obj) {
                return (a) super.e(fVar, obj);
            }

            /* access modifiers changed from: private */
            /* renamed from: x */
            public a c(at atVar) {
                if (atVar instanceof ai) {
                    return d((ai) atVar);
                }
                super.c(atVar);
                return this;
            }

            public final a d(ai aiVar) {
                bq<b, b.a, c> bqVar = null;
                if (aiVar != ai.EK()) {
                    if (this.bRU == null) {
                        if (!aiVar.bRS.isEmpty()) {
                            if (this.bRS.isEmpty()) {
                                this.bRS = aiVar.bRS;
                                this.bOT &= -2;
                            } else {
                                EN();
                                this.bRS.addAll(aiVar.bRS);
                            }
                            onChanged();
                        }
                    } else if (!aiVar.bRS.isEmpty()) {
                        if (this.bRU.isEmpty()) {
                            this.bRU.bYP = null;
                            this.bRU = null;
                            this.bRS = aiVar.bRS;
                            this.bOT &= -2;
                            if (ac.bVU) {
                                bqVar = EO();
                            }
                            this.bRU = bqVar;
                        } else {
                            this.bRU.a(aiVar.bRS);
                        }
                    }
                    d(aiVar.bTW);
                    onChanged();
                }
                return this;
            }

            @Override // com.google.a.ax, com.google.a.ac.a
            public final boolean isInitialized() {
                return true;
            }

            /* access modifiers changed from: private */
            /* JADX WARNING: Removed duplicated region for block: B:16:0x001e  */
            /* renamed from: y */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public com.google.a.k.ai.a c(com.google.a.h r4, com.google.a.r r5) {
                /*
                    r3 = this;
                    r2 = 0
                    com.google.a.bj<com.google.a.k$ai> r0 = com.google.a.k.ai.bPg     // Catch:{ af -> 0x000f }
                    java.lang.Object r0 = r0.d(r4, r5)     // Catch:{ af -> 0x000f }
                    com.google.a.k$ai r0 = (com.google.a.k.ai) r0     // Catch:{ af -> 0x000f }
                    if (r0 == 0) goto L_0x000e
                    r3.d(r0)
                L_0x000e:
                    return r3
                L_0x000f:
                    r0 = move-exception
                    r1 = r0
                    com.google.a.aw r0 = r1.bXr     // Catch:{ all -> 0x0022 }
                    com.google.a.k$ai r0 = (com.google.a.k.ai) r0     // Catch:{ all -> 0x0022 }
                    java.io.IOException r1 = r1.GF()     // Catch:{ all -> 0x001a }
                    throw r1     // Catch:{ all -> 0x001a }
                L_0x001a:
                    r1 = move-exception
                    r2 = r0
                L_0x001c:
                    if (r2 == 0) goto L_0x0021
                    r3.d(r2)
                L_0x0021:
                    throw r1
                L_0x0022:
                    r0 = move-exception
                    r1 = r0
                    goto L_0x001c
                */
                throw new UnsupportedOperationException("Method not decompiled: com.google.a.k.ai.a.c(com.google.a.h, com.google.a.r):com.google.a.k$ai$a");
            }

            private void EN() {
                if ((this.bOT & 1) == 0) {
                    this.bRS = new ArrayList(this.bRS);
                    this.bOT |= 1;
                }
            }

            private bq<b, b.a, c> EO() {
                if (this.bRU == null) {
                    this.bRU = new bq<>(this.bRS, (this.bOT & 1) != 0, GA(), this.bWv);
                    this.bRS = null;
                }
                return this.bRU;
            }

            /* access modifiers changed from: private */
            /* renamed from: S */
            public a f(cc ccVar) {
                return (a) super.f(ccVar);
            }

            /* access modifiers changed from: private */
            /* renamed from: T */
            public a d(cc ccVar) {
                return (a) super.a(ccVar);
            }

            /* Return type fixed from 'com.google.a.ac$a' to match base method */
            @Override // com.google.a.ac.a
            public final /* bridge */ /* synthetic */ a Bl() {
                return (a) super.yG();
            }

            @Override // com.google.a.a.AbstractC0085a, com.google.a.ac.a
            public final /* synthetic */ a.AbstractC0085a yE() {
                return (a) super.yG();
            }

            @Override // com.google.a.ax
            public final /* synthetic */ aw AP() {
                return ai.EK();
            }

            @Override // com.google.a.az
            public final /* synthetic */ at AQ() {
                return ai.EK();
            }

            @Override // com.google.a.b.a, com.google.a.a.AbstractC0085a, com.google.a.ac.a
            public final /* synthetic */ b.a yG() {
                return (a) super.yG();
            }

            @Override // com.google.a.b.a, com.google.a.a.AbstractC0085a, java.lang.Object, com.google.a.ac.a
            public final /* synthetic */ Object clone() {
                return (a) super.yG();
            }
        }

        public static ai EK() {
            return bRT;
        }

        @Override // com.google.a.aw, com.google.a.ac
        public final bj<ai> AK() {
            return bPg;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.a.ac
        public final /* synthetic */ at.a a(ac.b bVar) {
            return new a(bVar, (byte) 0);
        }

        @Override // com.google.a.at
        public final /* synthetic */ at.a AM() {
            return bRT.AN();
        }

        @Override // com.google.a.aw
        public final /* synthetic */ aw.a AO() {
            return bRT.AN();
        }

        @Override // com.google.a.ax
        public final /* bridge */ /* synthetic */ aw AP() {
            return bRT;
        }

        @Override // com.google.a.az
        public final /* bridge */ /* synthetic */ at AQ() {
            return bRT;
        }
    }

    static {
        l.g a2 = l.g.a(new String[]{"\n google/protobuf/descriptor.proto\u0012\u000fgoogle.protobuf\"G\n\u0011FileDescriptorSet\u00122\n\u0004file\u0018\u0001 \u0003(\u000b2$.google.protobuf.FileDescriptorProto\"Û\u0003\n\u0013FileDescriptorProto\u0012\f\n\u0004name\u0018\u0001 \u0001(\t\u0012\u000f\n\u0007package\u0018\u0002 \u0001(\t\u0012\u0012\n\ndependency\u0018\u0003 \u0003(\t\u0012\u0019\n\u0011public_dependency\u0018\n \u0003(\u0005\u0012\u0017\n\u000fweak_dependency\u0018\u000b \u0003(\u0005\u00126\n\fmessage_type\u0018\u0004 \u0003(\u000b2 .google.protobuf.DescriptorProto\u00127\n\tenum_type\u0018\u0005 \u0003(\u000b2$.google.protobuf.EnumDescriptorProto\u00128\n\u0007service\u0018\u0006 \u0003(\u000b2'.google.protobuf.ServiceDescriptorProto\u00128\n\textension\u0018\u0007 \u0003(\u000b2%.google.protobuf.FieldDescriptorProto\u0012-\n\u0007options\u0018\b \u0001(\u000b2\u001c.google.protobuf.FileOptions\u00129\n\u0010source_code_info\u0018\t \u0001(\u000b2\u001f.google.protobuf.SourceCodeInfo\u0012\u000e\n\u0006syntax\u0018\f \u0001(\t\"©\u0005\n\u000fDescriptorProto\u0012\f\n\u0004name\u0018\u0001 \u0001(\t\u00124\n\u0005field\u0018\u0002 \u0003(\u000b2%.google.protobuf.FieldDescriptorProto\u00128\n\textension\u0018\u0006 \u0003(\u000b2%.google.protobuf.FieldDescriptorProto\u00125\n\u000bnested_type\u0018\u0003 \u0003(\u000b2 .google.protobuf.DescriptorProto\u00127\n\tenum_type\u0018\u0004 \u0003(\u000b2$.google.protobuf.EnumDescriptorProto\u0012H\n\u000fextension_range\u0018\u0005 \u0003(\u000b2/.google.protobuf.DescriptorProto.ExtensionRange\u00129\n\noneof_decl\u0018\b \u0003(\u000b2%.google.protobuf.OneofDescriptorProto\u00120\n\u0007options\u0018\u0007 \u0001(\u000b2\u001f.google.protobuf.MessageOptions\u0012F\n\u000ereserved_range\u0018\t \u0003(\u000b2..google.protobuf.DescriptorProto.ReservedRange\u0012\u0015\n\rreserved_name\u0018\n \u0003(\t\u001ae\n\u000eExtensionRange\u0012\r\n\u0005start\u0018\u0001 \u0001(\u0005\u0012\u000b\n\u0003end\u0018\u0002 \u0001(\u0005\u00127\n\u0007options\u0018\u0003 \u0001(\u000b2&.google.protobuf.ExtensionRangeOptions\u001a+\n\rReservedRange\u0012\r\n\u0005start\u0018\u0001 \u0001(\u0005\u0012\u000b\n\u0003end\u0018\u0002 \u0001(\u0005\"g\n\u0015ExtensionRangeOptions\u0012C\n\u0014uninterpreted_option\u0018ç\u0007 \u0003(\u000b2$.google.protobuf.UninterpretedOption*\t\bè\u0007\u0010\u0002\"¼\u0005\n\u0014FieldDescriptorProto\u0012\f\n\u0004name\u0018\u0001 \u0001(\t\u0012\u000e\n\u0006number\u0018\u0003 \u0001(\u0005\u0012:\n\u0005label\u0018\u0004 \u0001(\u000e2+.google.protobuf.FieldDescriptorProto.Label\u00128\n\u0004type\u0018\u0005 \u0001(\u000e2*.google.protobuf.FieldDescriptorProto.Type\u0012\u0011\n\ttype_name\u0018\u0006 \u0001(\t\u0012\u0010\n\bextendee\u0018\u0002 \u0001(\t\u0012\u0015\n\rdefault_value\u0018\u0007 \u0001(\t\u0012\u0013\n\u000boneof_index\u0018\t \u0001(\u0005\u0012\u0011\n\tjson_name\u0018\n \u0001(\t\u0012.\n\u0007options\u0018\b \u0001(\u000b2\u001d.google.protobuf.FieldOptions\"¶\u0002\n\u0004Type\u0012\u000f\n\u000bTYPE_DOUBLE\u0010\u0001\u0012\u000e\n\nTYPE_FLOAT\u0010\u0002\u0012\u000e\n\nTYPE_INT64\u0010\u0003\u0012\u000f\n\u000bTYPE_UINT64\u0010\u0004\u0012\u000e\n\nTYPE_INT32\u0010\u0005\u0012\u0010\n\fTYPE_FIXED64\u0010\u0006\u0012\u0010\n\fTYPE_FIXED32\u0010\u0007\u0012\r\n\tTYPE_BOOL\u0010\b\u0012\u000f\n\u000bTYPE_STRING\u0010\t\u0012\u000e\n\nTYPE_GROUP\u0010\n\u0012\u0010\n\fTYPE_MESSAGE\u0010\u000b\u0012\u000e\n\nTYPE_BYTES\u0010\f\u0012\u000f\n\u000bTYPE_UINT32\u0010\r\u0012\r\n\tTYPE_ENUM\u0010\u000e\u0012\u0011\n\rTYPE_SFIXED32\u0010\u000f\u0012\u0011\n\rTYPE_SFIXED64\u0010\u0010\u0012\u000f\n\u000bTYPE_SINT32\u0010\u0011\u0012\u000f\n\u000bTYPE_SINT64\u0010\u0012\"C\n\u0005Label\u0012\u0012\n\u000eLABEL_OPTIONAL\u0010\u0001\u0012\u0012\n\u000eLABEL_REQUIRED\u0010\u0002\u0012\u0012\n\u000eLABEL_REPEATED\u0010\u0003\"T\n\u0014OneofDescriptorProto\u0012\f\n\u0004name\u0018\u0001 \u0001(\t\u0012.\n\u0007options\u0018\u0002 \u0001(\u000b2\u001d.google.protobuf.OneofOptions\"¤\u0002\n\u0013EnumDescriptorProto\u0012\f\n\u0004name\u0018\u0001 \u0001(\t\u00128\n\u0005value\u0018\u0002 \u0003(\u000b2).google.protobuf.EnumValueDescriptorProto\u0012-\n\u0007options\u0018\u0003 \u0001(\u000b2\u001c.google.protobuf.EnumOptions\u0012N\n\u000ereserved_range\u0018\u0004 \u0003(\u000b26.google.protobuf.EnumDescriptorProto.EnumReservedRange\u0012\u0015\n\rreserved_name\u0018\u0005 \u0003(\t\u001a/\n\u0011EnumReservedRange\u0012\r\n\u0005start\u0018\u0001 \u0001(\u0005\u0012\u000b\n\u0003end\u0018\u0002 \u0001(\u0005\"l\n\u0018EnumValueDescriptorProto\u0012\f\n\u0004name\u0018\u0001 \u0001(\t\u0012\u000e\n\u0006number\u0018\u0002 \u0001(\u0005\u00122\n\u0007options\u0018\u0003 \u0001(\u000b2!.google.protobuf.EnumValueOptions\"\u0001\n\u0016ServiceDescriptorProto\u0012\f\n\u0004name\u0018\u0001 \u0001(\t\u00126\n\u0006method\u0018\u0002 \u0003(\u000b2&.google.protobuf.MethodDescriptorProto\u00120\n\u0007options\u0018\u0003 \u0001(\u000b2\u001f.google.protobuf.ServiceOptions\"Á\u0001\n\u0015MethodDescriptorProto\u0012\f\n\u0004name\u0018\u0001 \u0001(\t\u0012\u0012\n\ninput_type\u0018\u0002 \u0001(\t\u0012\u0013\n\u000boutput_type\u0018\u0003 \u0001(\t\u0012/\n\u0007options\u0018\u0004 \u0001(\u000b2\u001e.google.protobuf.MethodOptions\u0012\u001f\n\u0010client_streaming\u0018\u0005 \u0001(\b:\u0005false\u0012\u001f\n\u0010server_streaming\u0018\u0006 \u0001(\b:\u0005false\"¦\u0006\n\u000bFileOptions\u0012\u0014\n\fjava_package\u0018\u0001 \u0001(\t\u0012\u001c\n\u0014java_outer_classname\u0018\b \u0001(\t\u0012\"\n\u0013java_multiple_files\u0018\n \u0001(\b:\u0005false\u0012)\n\u001djava_generate_equals_and_hash\u0018\u0014 \u0001(\bB\u0002\u0018\u0001\u0012%\n\u0016java_string_check_utf8\u0018\u001b \u0001(\b:\u0005false\u0012F\n\foptimize_for\u0018\t \u0001(\u000e2).google.protobuf.FileOptions.OptimizeMode:\u0005SPEED\u0012\u0012\n\ngo_package\u0018\u000b \u0001(\t\u0012\"\n\u0013cc_generic_services\u0018\u0010 \u0001(\b:\u0005false\u0012$\n\u0015java_generic_services\u0018\u0011 \u0001(\b:\u0005false\u0012\"\n\u0013py_generic_services\u0018\u0012 \u0001(\b:\u0005false\u0012#\n\u0014php_generic_services\u0018* \u0001(\b:\u0005false\u0012\u0019\n\ndeprecated\u0018\u0017 \u0001(\b:\u0005false\u0012\u001f\n\u0010cc_enable_arenas\u0018\u001f \u0001(\b:\u0005false\u0012\u0019\n\u0011objc_class_prefix\u0018$ \u0001(\t\u0012\u0018\n\u0010csharp_namespace\u0018% \u0001(\t\u0012\u0014\n\fswift_prefix\u0018' \u0001(\t\u0012\u0018\n\u0010php_class_prefix\u0018( \u0001(\t\u0012\u0015\n\rphp_namespace\u0018) \u0001(\t\u0012\u001e\n\u0016php_metadata_namespace\u0018, \u0001(\t\u0012\u0014\n\fruby_package\u0018- \u0001(\t\u0012C\n\u0014uninterpreted_option\u0018ç\u0007 \u0003(\u000b2$.google.protobuf.UninterpretedOption\":\n\fOptimizeMode\u0012\t\n\u0005SPEED\u0010\u0001\u0012\r\n\tCODE_SIZE\u0010\u0002\u0012\u0010\n\fLITE_RUNTIME\u0010\u0003*\t\bè\u0007\u0010\u0002J\u0004\b&\u0010'\"ò\u0001\n\u000eMessageOptions\u0012&\n\u0017message_set_wire_format\u0018\u0001 \u0001(\b:\u0005false\u0012.\n\u001fno_standard_descriptor_accessor\u0018\u0002 \u0001(\b:\u0005false\u0012\u0019\n\ndeprecated\u0018\u0003 \u0001(\b:\u0005false\u0012\u0011\n\tmap_entry\u0018\u0007 \u0001(\b\u0012C\n\u0014uninterpreted_option\u0018ç\u0007 \u0003(\u000b2$.google.protobuf.UninterpretedOption*\t\bè\u0007\u0010\u0002J\u0004\b\b\u0010\tJ\u0004\b\t\u0010\n\"\u0003\n\fFieldOptions\u0012:\n\u0005ctype\u0018\u0001 \u0001(\u000e2#.google.protobuf.FieldOptions.CType:\u0006STRING\u0012\u000e\n\u0006packed\u0018\u0002 \u0001(\b\u0012?\n\u0006jstype\u0018\u0006 \u0001(\u000e2$.google.protobuf.FieldOptions.JSType:\tJS_NORMAL\u0012\u0013\n\u0004lazy\u0018\u0005 \u0001(\b:\u0005false\u0012\u0019\n\ndeprecated\u0018\u0003 \u0001(\b:\u0005false\u0012\u0013\n\u0004weak\u0018\n \u0001(\b:\u0005false\u0012C\n\u0014uninterpreted_option\u0018ç\u0007 \u0003(\u000b2$.google.protobuf.UninterpretedOption\"/\n\u0005CType\u0012\n\n\u0006STRING\u0010\u0000\u0012\b\n\u0004CORD\u0010\u0001\u0012\u0010\n\fSTRING_PIECE\u0010\u0002\"5\n\u0006JSType\u0012\r\n\tJS_NORMAL\u0010\u0000\u0012\r\n\tJS_STRING\u0010\u0001\u0012\r\n\tJS_NUMBER\u0010\u0002*\t\bè\u0007\u0010\u0002J\u0004\b\u0004\u0010\u0005\"^\n\fOneofOptions\u0012C\n\u0014uninterpreted_option\u0018ç\u0007 \u0003(\u000b2$.google.protobuf.UninterpretedOption*\t\bè\u0007\u0010\u0002\"\u0001\n\u000bEnumOptions\u0012\u0013\n\u000ballow_alias\u0018\u0002 \u0001(\b\u0012\u0019\n\ndeprecated\u0018\u0003 \u0001(\b:\u0005false\u0012C\n\u0014uninterpreted_option\u0018ç\u0007 \u0003(\u000b2$.google.protobuf.UninterpretedOption*\t\bè\u0007\u0010\u0002J\u0004\b\u0005\u0010\u0006\"}\n\u0010EnumValueOptions\u0012\u0019\n\ndeprecated\u0018\u0001 \u0001(\b:\u0005false\u0012C\n\u0014uninterpreted_option\u0018ç\u0007 \u0003(\u000b2$.google.protobuf.UninterpretedOption*\t\bè\u0007\u0010\u0002\"{\n\u000eServiceOptions\u0012\u0019\n\ndeprecated\u0018! \u0001(\b:\u0005false\u0012C\n\u0014uninterpreted_option\u0018ç\u0007 \u0003(\u000b2$.google.protobuf.UninterpretedOption*\t\bè\u0007\u0010\u0002\"­\u0002\n\rMethodOptions\u0012\u0019\n\ndeprecated\u0018! \u0001(\b:\u0005false\u0012_\n\u0011idempotency_level\u0018\" \u0001(\u000e2/.google.protobuf.MethodOptions.IdempotencyLevel:\u0013IDEMPOTENCY_UNKNOWN\u0012C\n\u0014uninterpreted_option\u0018ç\u0007 \u0003(\u000b2$.google.protobuf.UninterpretedOption\"P\n\u0010IdempotencyLevel\u0012\u0017\n\u0013IDEMPOTENCY_UNKNOWN\u0010\u0000\u0012\u0013\n\u000fNO_SIDE_EFFECTS\u0010\u0001\u0012\u000e\n\nIDEMPOTENT\u0010\u0002*\t\bè\u0007\u0010\u0002\"\u0002\n\u0013UninterpretedOption\u0012;\n\u0004name\u0018\u0002 \u0003(\u000b2-.google.protobuf.UninterpretedOption.NamePart\u0012\u0018\n\u0010identifier_value\u0018\u0003 \u0001(\t\u0012\u001a\n\u0012positive_int_value\u0018\u0004 \u0001(\u0004\u0012\u001a\n\u0012negative_int_value\u0018\u0005 \u0001(\u0003\u0012\u0014\n\fdouble_value\u0018\u0006 \u0001(\u0001\u0012\u0014\n\fstring_value\u0018\u0007 \u0001(\f\u0012\u0017\n\u000faggregate_value\u0018\b \u0001(\t\u001a3\n\bNamePart\u0012\u0011\n\tname_part\u0018\u0001 \u0002(\t\u0012\u0014\n\fis_extension\u0018\u0002 \u0002(\b\"Õ\u0001\n\u000eSourceCodeInfo\u0012:\n\blocation\u0018\u0001 \u0003(\u000b2(.google.protobuf.SourceCodeInfo.Location\u001a\u0001\n\bLocation\u0012\u0010\n\u0004path\u0018\u0001 \u0003(\u0005B\u0002\u0010\u0001\u0012\u0010\n\u0004span\u0018\u0002 \u0003(\u0005B\u0002\u0010\u0001\u0012\u0018\n\u0010leading_comments\u0018\u0003 \u0001(\t\u0012\u0019\n\u0011trailing_comments\u0018\u0004 \u0001(\t\u0012!\n\u0019leading_detached_comments\u0018\u0006 \u0003(\t\"§\u0001\n\u0011GeneratedCodeInfo\u0012A\n\nannotation\u0018\u0001 \u0003(\u000b2-.google.protobuf.GeneratedCodeInfo.Annotation\u001aO\n\nAnnotation\u0012\u0010\n\u0004path\u0018\u0001 \u0003(\u0005B\u0002\u0010\u0001\u0012\u0013\n\u000bsource_file\u0018\u0002 \u0001(\t\u0012\r\n\u0005begin\u0018\u0003 \u0001(\u0005\u0012\u000b\n\u0003end\u0018\u0004 \u0001(\u0005B\u0001\n\u0013com.google.protobufB\u0010DescriptorProtosH\u0001Z>github.com/golang/protobuf/protoc-gen-go/descriptor;descriptorø\u0001\u0001¢\u0002\u0003GPBª\u0002\u001aGoogle.Protobuf.Reflection"}, new l.g[0]);
        bOS = a2;
        bNQ = a2.FP().get(0);
    }
}

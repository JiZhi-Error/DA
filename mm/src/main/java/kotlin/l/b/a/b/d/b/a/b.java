package kotlin.l.b.a.b.d.b.a;

import com.facebook.internal.ServerProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.l.b.a.b.b.an;
import kotlin.l.b.a.b.d.b.a.a;
import kotlin.l.b.a.b.d.b.p;
import kotlin.l.b.a.b.f.f;

public final class b implements p.c {
    private static final boolean TwB = ServerProtocol.DIALOG_RETURN_SCOPES_TRUE.equals(System.getProperty("kotlin.ignore.old.metadata"));
    private static final Map<kotlin.l.b.a.b.f.a, a.EnumC2293a> TwC;
    public int[] TwD = null;
    public a.EnumC2293a TwE = null;
    public kotlin.l.b.a.b.e.c.a.c Twn = null;
    public String[] Two = null;
    public String[] Twp = null;
    public String Twq = null;
    public int Twr = 0;
    public String packageName = null;
    public String[] strings = null;

    static {
        AppMethodBeat.i(58301);
        HashMap hashMap = new HashMap();
        TwC = hashMap;
        hashMap.put(kotlin.l.b.a.b.f.a.p(new kotlin.l.b.a.b.f.b("kotlin.jvm.internal.KotlinClass")), a.EnumC2293a.CLASS);
        TwC.put(kotlin.l.b.a.b.f.a.p(new kotlin.l.b.a.b.f.b("kotlin.jvm.internal.KotlinFileFacade")), a.EnumC2293a.FILE_FACADE);
        TwC.put(kotlin.l.b.a.b.f.a.p(new kotlin.l.b.a.b.f.b("kotlin.jvm.internal.KotlinMultifileClass")), a.EnumC2293a.MULTIFILE_CLASS);
        TwC.put(kotlin.l.b.a.b.f.a.p(new kotlin.l.b.a.b.f.b("kotlin.jvm.internal.KotlinMultifileClassPart")), a.EnumC2293a.MULTIFILE_CLASS_PART);
        TwC.put(kotlin.l.b.a.b.f.a.p(new kotlin.l.b.a.b.f.b("kotlin.jvm.internal.KotlinSyntheticClass")), a.EnumC2293a.SYNTHETIC_CLASS);
        AppMethodBeat.o(58301);
    }

    @Override // kotlin.l.b.a.b.d.b.p.c
    public final void Td() {
    }

    /* renamed from: kotlin.l.b.a.b.d.b.a.b$b  reason: collision with other inner class name */
    class C2295b implements p.a {
        private static /* synthetic */ void atM(int i2) {
            AppMethodBeat.i(58291);
            Object[] objArr = new Object[3];
            switch (i2) {
                case 1:
                    objArr[0] = "classLiteralValue";
                    break;
                case 2:
                case 3:
                case 6:
                default:
                    objArr[0] = "name";
                    break;
                case 4:
                    objArr[0] = "enumClassId";
                    break;
                case 5:
                    objArr[0] = "enumEntryName";
                    break;
                case 7:
                    objArr[0] = "classId";
                    break;
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/load/kotlin/header/ReadKotlinClassHeaderAnnotationVisitor$KotlinMetadataArgumentVisitor";
            switch (i2) {
                case 2:
                    objArr[2] = "visitArray";
                    break;
                case 3:
                case 4:
                case 5:
                    objArr[2] = "visitEnum";
                    break;
                case 6:
                case 7:
                    objArr[2] = "visitAnnotation";
                    break;
                default:
                    objArr[2] = "visitClassLiteral";
                    break;
            }
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
            AppMethodBeat.o(58291);
            throw illegalArgumentException;
        }

        private C2295b() {
        }

        /* synthetic */ C2295b(b bVar, byte b2) {
            this();
        }

        @Override // kotlin.l.b.a.b.d.b.p.a
        public final void a(f fVar, Object obj) {
            AppMethodBeat.i(58286);
            if (fVar == null) {
                AppMethodBeat.o(58286);
                return;
            }
            String sG = fVar.sG();
            if ("k".equals(sG)) {
                if (obj instanceof Integer) {
                    b.this.TwE = a.EnumC2293a.atR(((Integer) obj).intValue());
                    AppMethodBeat.o(58286);
                    return;
                }
            } else if ("mv".equals(sG)) {
                if (obj instanceof int[]) {
                    b.this.TwD = (int[]) obj;
                    AppMethodBeat.o(58286);
                    return;
                }
            } else if ("bv".equals(sG)) {
                if (obj instanceof int[]) {
                    b.this.Twn = new kotlin.l.b.a.b.e.c.a.c((int[]) obj);
                    AppMethodBeat.o(58286);
                    return;
                }
            } else if ("xs".equals(sG)) {
                if (obj instanceof String) {
                    b.this.Twq = (String) obj;
                    AppMethodBeat.o(58286);
                    return;
                }
            } else if ("xi".equals(sG)) {
                if (obj instanceof Integer) {
                    b.this.Twr = ((Integer) obj).intValue();
                    AppMethodBeat.o(58286);
                    return;
                }
            } else if ("pn".equals(sG) && (obj instanceof String)) {
                b.this.packageName = (String) obj;
            }
            AppMethodBeat.o(58286);
        }

        @Override // kotlin.l.b.a.b.d.b.p.a
        public final void a(f fVar, kotlin.l.b.a.b.j.b.f fVar2) {
            AppMethodBeat.i(58287);
            if (fVar == null) {
                atM(0);
            }
            if (fVar2 == null) {
                atM(1);
            }
            AppMethodBeat.o(58287);
        }

        @Override // kotlin.l.b.a.b.d.b.p.a
        public final p.b n(f fVar) {
            AppMethodBeat.i(58288);
            if (fVar == null) {
                atM(2);
            }
            String sG = fVar.sG();
            if ("d1".equals(sG)) {
                AnonymousClass1 r0 = new a() {
                    /* class kotlin.l.b.a.b.d.b.a.b.C2295b.AnonymousClass1 */

                    /* access modifiers changed from: protected */
                    @Override // kotlin.l.b.a.b.d.b.a.b.a
                    public final void ak(String[] strArr) {
                        AppMethodBeat.i(58284);
                        if (strArr == null) {
                            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "result", "kotlin/reflect/jvm/internal/impl/load/kotlin/header/ReadKotlinClassHeaderAnnotationVisitor$KotlinMetadataArgumentVisitor$1", "visitEnd"));
                            AppMethodBeat.o(58284);
                            throw illegalArgumentException;
                        }
                        b.this.Two = strArr;
                        AppMethodBeat.o(58284);
                    }
                };
                AppMethodBeat.o(58288);
                return r0;
            } else if ("d2".equals(sG)) {
                AnonymousClass2 r02 = new a() {
                    /* class kotlin.l.b.a.b.d.b.a.b.C2295b.AnonymousClass2 */

                    /* access modifiers changed from: protected */
                    @Override // kotlin.l.b.a.b.d.b.a.b.a
                    public final void ak(String[] strArr) {
                        AppMethodBeat.i(58285);
                        if (strArr == null) {
                            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "result", "kotlin/reflect/jvm/internal/impl/load/kotlin/header/ReadKotlinClassHeaderAnnotationVisitor$KotlinMetadataArgumentVisitor$2", "visitEnd"));
                            AppMethodBeat.o(58285);
                            throw illegalArgumentException;
                        }
                        b.this.strings = strArr;
                        AppMethodBeat.o(58285);
                    }
                };
                AppMethodBeat.o(58288);
                return r02;
            } else {
                AppMethodBeat.o(58288);
                return null;
            }
        }

        @Override // kotlin.l.b.a.b.d.b.p.a
        public final void a(f fVar, kotlin.l.b.a.b.f.a aVar, f fVar2) {
            AppMethodBeat.i(58289);
            if (fVar == null) {
                atM(3);
            }
            if (aVar == null) {
                atM(4);
            }
            if (fVar2 == null) {
                atM(5);
            }
            AppMethodBeat.o(58289);
        }

        @Override // kotlin.l.b.a.b.d.b.p.a
        public final p.a a(f fVar, kotlin.l.b.a.b.f.a aVar) {
            AppMethodBeat.i(58290);
            if (fVar == null) {
                atM(6);
            }
            if (aVar == null) {
                atM(7);
            }
            AppMethodBeat.o(58290);
            return null;
        }

        @Override // kotlin.l.b.a.b.d.b.p.a
        public final void Td() {
        }
    }

    class c implements p.a {
        private static /* synthetic */ void atM(int i2) {
            AppMethodBeat.i(58299);
            Object[] objArr = new Object[3];
            switch (i2) {
                case 1:
                    objArr[0] = "classLiteralValue";
                    break;
                case 2:
                case 3:
                case 6:
                default:
                    objArr[0] = "name";
                    break;
                case 4:
                    objArr[0] = "enumClassId";
                    break;
                case 5:
                    objArr[0] = "enumEntryName";
                    break;
                case 7:
                    objArr[0] = "classId";
                    break;
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/load/kotlin/header/ReadKotlinClassHeaderAnnotationVisitor$OldDeprecatedAnnotationArgumentVisitor";
            switch (i2) {
                case 2:
                    objArr[2] = "visitArray";
                    break;
                case 3:
                case 4:
                case 5:
                    objArr[2] = "visitEnum";
                    break;
                case 6:
                case 7:
                    objArr[2] = "visitAnnotation";
                    break;
                default:
                    objArr[2] = "visitClassLiteral";
                    break;
            }
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
            AppMethodBeat.o(58299);
            throw illegalArgumentException;
        }

        private c() {
        }

        /* synthetic */ c(b bVar, byte b2) {
            this();
        }

        @Override // kotlin.l.b.a.b.d.b.p.a
        public final void a(f fVar, Object obj) {
            AppMethodBeat.i(58294);
            if (fVar == null) {
                AppMethodBeat.o(58294);
                return;
            }
            String sG = fVar.sG();
            if ("version".equals(sG)) {
                if (obj instanceof int[]) {
                    b.this.TwD = (int[]) obj;
                    if (b.this.Twn == null) {
                        b.this.Twn = new kotlin.l.b.a.b.e.c.a.c((int[]) obj);
                        AppMethodBeat.o(58294);
                        return;
                    }
                }
            } else if ("multifileClassName".equals(sG)) {
                b.this.Twq = obj instanceof String ? (String) obj : null;
            }
            AppMethodBeat.o(58294);
        }

        @Override // kotlin.l.b.a.b.d.b.p.a
        public final void a(f fVar, kotlin.l.b.a.b.j.b.f fVar2) {
            AppMethodBeat.i(58295);
            if (fVar == null) {
                atM(0);
            }
            if (fVar2 == null) {
                atM(1);
            }
            AppMethodBeat.o(58295);
        }

        @Override // kotlin.l.b.a.b.d.b.p.a
        public final p.b n(f fVar) {
            AppMethodBeat.i(58296);
            if (fVar == null) {
                atM(2);
            }
            String sG = fVar.sG();
            if ("data".equals(sG) || "filePartClassNames".equals(sG)) {
                AnonymousClass1 r0 = new a() {
                    /* class kotlin.l.b.a.b.d.b.a.b.c.AnonymousClass1 */

                    /* access modifiers changed from: protected */
                    @Override // kotlin.l.b.a.b.d.b.a.b.a
                    public final void ak(String[] strArr) {
                        AppMethodBeat.i(58292);
                        if (strArr == null) {
                            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "data", "kotlin/reflect/jvm/internal/impl/load/kotlin/header/ReadKotlinClassHeaderAnnotationVisitor$OldDeprecatedAnnotationArgumentVisitor$1", "visitEnd"));
                            AppMethodBeat.o(58292);
                            throw illegalArgumentException;
                        }
                        b.this.Two = strArr;
                        AppMethodBeat.o(58292);
                    }
                };
                AppMethodBeat.o(58296);
                return r0;
            } else if ("strings".equals(sG)) {
                AnonymousClass2 r02 = new a() {
                    /* class kotlin.l.b.a.b.d.b.a.b.c.AnonymousClass2 */

                    /* access modifiers changed from: protected */
                    @Override // kotlin.l.b.a.b.d.b.a.b.a
                    public final void ak(String[] strArr) {
                        AppMethodBeat.i(58293);
                        if (strArr == null) {
                            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "data", "kotlin/reflect/jvm/internal/impl/load/kotlin/header/ReadKotlinClassHeaderAnnotationVisitor$OldDeprecatedAnnotationArgumentVisitor$2", "visitEnd"));
                            AppMethodBeat.o(58293);
                            throw illegalArgumentException;
                        }
                        b.this.strings = strArr;
                        AppMethodBeat.o(58293);
                    }
                };
                AppMethodBeat.o(58296);
                return r02;
            } else {
                AppMethodBeat.o(58296);
                return null;
            }
        }

        @Override // kotlin.l.b.a.b.d.b.p.a
        public final void a(f fVar, kotlin.l.b.a.b.f.a aVar, f fVar2) {
            AppMethodBeat.i(58297);
            if (fVar == null) {
                atM(3);
            }
            if (aVar == null) {
                atM(4);
            }
            if (fVar2 == null) {
                atM(5);
            }
            AppMethodBeat.o(58297);
        }

        @Override // kotlin.l.b.a.b.d.b.p.a
        public final p.a a(f fVar, kotlin.l.b.a.b.f.a aVar) {
            AppMethodBeat.i(58298);
            if (fVar == null) {
                atM(6);
            }
            if (aVar == null) {
                atM(7);
            }
            AppMethodBeat.o(58298);
            return null;
        }

        @Override // kotlin.l.b.a.b.d.b.p.a
        public final void Td() {
        }
    }

    static abstract class a implements p.b {
        private final List<String> TwF = new ArrayList();

        private static /* synthetic */ void atM(int i2) {
            Object[] objArr = new Object[3];
            switch (i2) {
                case 1:
                    objArr[0] = "enumEntryName";
                    break;
                case 2:
                    objArr[0] = "classLiteralValue";
                    break;
                default:
                    objArr[0] = "enumClassId";
                    break;
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/load/kotlin/header/ReadKotlinClassHeaderAnnotationVisitor$CollectStringArrayAnnotationVisitor";
            switch (i2) {
                case 2:
                    objArr[2] = "visitClassLiteral";
                    break;
                default:
                    objArr[2] = "visitEnum";
                    break;
            }
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        /* access modifiers changed from: protected */
        public abstract void ak(String[] strArr);

        @Override // kotlin.l.b.a.b.d.b.p.b
        public final void fr(Object obj) {
            if (obj instanceof String) {
                this.TwF.add((String) obj);
            }
        }

        @Override // kotlin.l.b.a.b.d.b.p.b
        public final void a(kotlin.l.b.a.b.f.a aVar, f fVar) {
            if (aVar == null) {
                atM(0);
            }
            if (fVar == null) {
                atM(1);
            }
        }

        @Override // kotlin.l.b.a.b.d.b.p.b
        public final void a(kotlin.l.b.a.b.j.b.f fVar) {
            if (fVar == null) {
                atM(2);
            }
        }

        @Override // kotlin.l.b.a.b.d.b.p.b
        public final void Td() {
            ak((String[]) this.TwF.toArray(new String[0]));
        }
    }

    @Override // kotlin.l.b.a.b.d.b.p.c
    public final p.a a(kotlin.l.b.a.b.f.a aVar, an anVar) {
        AppMethodBeat.i(58300);
        if (aVar == null) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "classId", "kotlin/reflect/jvm/internal/impl/load/kotlin/header/ReadKotlinClassHeaderAnnotationVisitor", "visitAnnotation"));
            AppMethodBeat.o(58300);
            throw illegalArgumentException;
        } else if (aVar.hJd().equals(kotlin.l.b.a.b.d.a.p.Tpj)) {
            C2295b bVar = new C2295b(this, (byte) 0);
            AppMethodBeat.o(58300);
            return bVar;
        } else if (TwB) {
            AppMethodBeat.o(58300);
            return null;
        } else if (this.TwE != null) {
            AppMethodBeat.o(58300);
            return null;
        } else {
            a.EnumC2293a aVar2 = TwC.get(aVar);
            if (aVar2 != null) {
                this.TwE = aVar2;
                c cVar = new c(this, (byte) 0);
                AppMethodBeat.o(58300);
                return cVar;
            }
            AppMethodBeat.o(58300);
            return null;
        }
    }
}

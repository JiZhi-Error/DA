package com.tencent.mm.plugin.appbrand.g.c;

import android.text.TextUtils;
import com.facebook.login.widget.ToolTipPopup;
import com.google.android.gms.stats.CodePackage;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.g.a.e;
import com.tencent.mm.plugin.appbrand.g.b.a;
import com.tencent.mm.plugin.appbrand.g.b.c;
import com.tencent.mm.plugin.appbrand.g.c.b;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import rx.d;
import rx.f.b;

public class h {
    static final /* synthetic */ boolean $assertionsDisabled = (!h.class.desiredAssertionStatus());
    private static final String TAG = h.class.getSimpleName();
    private boolean enabled;
    private b lla;
    private ReentrantReadWriteLock llb;
    private Lock llc;
    private e lld;
    private Pattern lle;
    private Set<String> llf;
    private int port;

    static {
        AppMethodBeat.i(159009);
        AppMethodBeat.o(159009);
    }

    /* synthetic */ h(byte b2) {
        this();
    }

    static /* synthetic */ String a(h hVar, String str) {
        AppMethodBeat.i(159008);
        String KB = hVar.KB(str);
        AppMethodBeat.o(159008);
        return KB;
    }

    /* access modifiers changed from: package-private */
    public static class a {
        private static h llh = new h((byte) 0);

        static {
            AppMethodBeat.i(158997);
            AppMethodBeat.o(158997);
        }
    }

    private h() {
        AppMethodBeat.i(158998);
        this.lla = new b();
        this.llb = new ReentrantReadWriteLock(true);
        this.llc = this.llb.writeLock();
        this.enabled = false;
        this.port = -1;
        this.llf = new HashSet();
        this.lle = Pattern.compile("uuid:([a-fA-F\\d]{8}(-[a-fA-F\\d]{4}){3}-[a-fA-F\\d]{12})");
        AppMethodBeat.o(158998);
    }

    public static h bBB() {
        AppMethodBeat.i(158999);
        h hVar = a.llh;
        AppMethodBeat.o(158999);
        return hVar;
    }

    public final boolean enable() {
        AppMethodBeat.i(159000);
        com.tencent.mm.plugin.appbrand.g.a.i(TAG, "mRouter is starting ...");
        this.port = i.bBD().port;
        try {
            if (!this.enabled) {
                this.lld = new e(new f("239.255.255.250"), g.bBz(), this, this.port);
                this.lld.start();
                this.enabled = true;
                AppMethodBeat.o(159000);
                return true;
            }
            AppMethodBeat.o(159000);
            return false;
        } catch (Exception e2) {
            com.tencent.mm.plugin.appbrand.g.a.a(TAG, e2, "");
            AppMethodBeat.o(159000);
            return false;
        }
    }

    public final boolean disable() {
        AppMethodBeat.i(159001);
        com.tencent.mm.plugin.appbrand.g.a.i(TAG, "mRouter is shutting down...");
        if (this.enabled) {
            this.llf.clear();
            this.lld.close();
            this.lla.clear();
            this.enabled = false;
            AppMethodBeat.o(159001);
            return true;
        }
        AppMethodBeat.o(159001);
        return false;
    }

    public final void gZ(boolean z) {
        AppMethodBeat.i(222905);
        com.tencent.mm.plugin.appbrand.g.a.h hVar = new com.tencent.mm.plugin.appbrand.g.a.h(z);
        if (!this.enabled) {
            com.tencent.mm.plugin.appbrand.g.a.e(TAG, "DLNA Router is not enable");
            AppMethodBeat.o(222905);
            return;
        }
        b bVar = this.lla;
        b.c cVar = new b.c(hVar);
        bVar.b(d.a((d.a) 
        /*  JADX ERROR: Method code generation error
            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0043: INVOKE  
              (r1v1 'bVar' rx.f.b)
              (wrap: rx.j : 0x003f: INVOKE  (r0v4 rx.j) = 
              (wrap: rx.d : 0x0031: INVOKE  (r0v3 rx.d) = 
              (wrap: rx.d : 0x002b: INVOKE  (r0v2 rx.d) = 
              (wrap: rx.d$a : ?: CAST (rx.d$a) (wrap: com.tencent.mm.plugin.appbrand.g.c.a$2 : 0x0028: CONSTRUCTOR  (r4v0 com.tencent.mm.plugin.appbrand.g.c.a$2) = 
              (wrap: com.tencent.mm.plugin.appbrand.g.c.a : 0x0022: IGET  (r0v1 com.tencent.mm.plugin.appbrand.g.c.a) = (r2v0 'cVar' com.tencent.mm.plugin.appbrand.g.c.b$c) com.tencent.mm.plugin.appbrand.g.c.b.c.lkB com.tencent.mm.plugin.appbrand.g.c.a)
              (wrap: com.tencent.mm.plugin.appbrand.g.a.d : 0x0024: IGET  (r3v0 com.tencent.mm.plugin.appbrand.g.a.d) = (r2v0 'cVar' com.tencent.mm.plugin.appbrand.g.c.b$c) com.tencent.mm.plugin.appbrand.g.c.b.c.lkA com.tencent.mm.plugin.appbrand.g.a.d)
             call: com.tencent.mm.plugin.appbrand.g.c.a.2.<init>(com.tencent.mm.plugin.appbrand.g.c.a, com.tencent.mm.plugin.appbrand.g.a.d):void type: CONSTRUCTOR))
             type: STATIC call: rx.d.a(rx.d$a):rx.d)
              (wrap: rx.d$c : ?: CAST (rx.d$c) (wrap: rx.d$c<T, T> : 0x002f: IGET  (r2v1 rx.d$c<T, T>) = (r2v0 'cVar' com.tencent.mm.plugin.appbrand.g.c.b$c) com.tencent.mm.plugin.appbrand.g.d.b.llt rx.d$c))
             type: VIRTUAL call: rx.d.a(rx.d$c):rx.d)
              (wrap: com.tencent.mm.plugin.appbrand.g.c.h$3 : 0x0037: CONSTRUCTOR  (r2v2 com.tencent.mm.plugin.appbrand.g.c.h$3) = (r6v0 'this' com.tencent.mm.plugin.appbrand.g.c.h A[IMMUTABLE_TYPE, THIS]) call: com.tencent.mm.plugin.appbrand.g.c.h.3.<init>(com.tencent.mm.plugin.appbrand.g.c.h):void type: CONSTRUCTOR)
              (wrap: com.tencent.mm.plugin.appbrand.g.c.h$4 : 0x003c: CONSTRUCTOR  (r3v1 com.tencent.mm.plugin.appbrand.g.c.h$4) = (r6v0 'this' com.tencent.mm.plugin.appbrand.g.c.h A[IMMUTABLE_TYPE, THIS]) call: com.tencent.mm.plugin.appbrand.g.c.h.4.<init>(com.tencent.mm.plugin.appbrand.g.c.h):void type: CONSTRUCTOR)
             type: VIRTUAL call: rx.d.a(rx.b.b, rx.b.b):rx.j)
             type: VIRTUAL call: rx.f.b.b(rx.j):void in method: com.tencent.mm.plugin.appbrand.g.c.h.gZ(boolean):void, file: classes8.dex
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:217)
            	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:110)
            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:56)
            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
            	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:244)
            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:237)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:342)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:264)
            	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
            	at java.util.ArrayList.forEach(ArrayList.java:1259)
            	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
            	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
            Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x003f: INVOKE  (r0v4 rx.j) = 
              (wrap: rx.d : 0x0031: INVOKE  (r0v3 rx.d) = 
              (wrap: rx.d : 0x002b: INVOKE  (r0v2 rx.d) = 
              (wrap: rx.d$a : ?: CAST (rx.d$a) (wrap: com.tencent.mm.plugin.appbrand.g.c.a$2 : 0x0028: CONSTRUCTOR  (r4v0 com.tencent.mm.plugin.appbrand.g.c.a$2) = 
              (wrap: com.tencent.mm.plugin.appbrand.g.c.a : 0x0022: IGET  (r0v1 com.tencent.mm.plugin.appbrand.g.c.a) = (r2v0 'cVar' com.tencent.mm.plugin.appbrand.g.c.b$c) com.tencent.mm.plugin.appbrand.g.c.b.c.lkB com.tencent.mm.plugin.appbrand.g.c.a)
              (wrap: com.tencent.mm.plugin.appbrand.g.a.d : 0x0024: IGET  (r3v0 com.tencent.mm.plugin.appbrand.g.a.d) = (r2v0 'cVar' com.tencent.mm.plugin.appbrand.g.c.b$c) com.tencent.mm.plugin.appbrand.g.c.b.c.lkA com.tencent.mm.plugin.appbrand.g.a.d)
             call: com.tencent.mm.plugin.appbrand.g.c.a.2.<init>(com.tencent.mm.plugin.appbrand.g.c.a, com.tencent.mm.plugin.appbrand.g.a.d):void type: CONSTRUCTOR))
             type: STATIC call: rx.d.a(rx.d$a):rx.d)
              (wrap: rx.d$c : ?: CAST (rx.d$c) (wrap: rx.d$c<T, T> : 0x002f: IGET  (r2v1 rx.d$c<T, T>) = (r2v0 'cVar' com.tencent.mm.plugin.appbrand.g.c.b$c) com.tencent.mm.plugin.appbrand.g.d.b.llt rx.d$c))
             type: VIRTUAL call: rx.d.a(rx.d$c):rx.d)
              (wrap: com.tencent.mm.plugin.appbrand.g.c.h$3 : 0x0037: CONSTRUCTOR  (r2v2 com.tencent.mm.plugin.appbrand.g.c.h$3) = (r6v0 'this' com.tencent.mm.plugin.appbrand.g.c.h A[IMMUTABLE_TYPE, THIS]) call: com.tencent.mm.plugin.appbrand.g.c.h.3.<init>(com.tencent.mm.plugin.appbrand.g.c.h):void type: CONSTRUCTOR)
              (wrap: com.tencent.mm.plugin.appbrand.g.c.h$4 : 0x003c: CONSTRUCTOR  (r3v1 com.tencent.mm.plugin.appbrand.g.c.h$4) = (r6v0 'this' com.tencent.mm.plugin.appbrand.g.c.h A[IMMUTABLE_TYPE, THIS]) call: com.tencent.mm.plugin.appbrand.g.c.h.4.<init>(com.tencent.mm.plugin.appbrand.g.c.h):void type: CONSTRUCTOR)
             type: VIRTUAL call: rx.d.a(rx.b.b, rx.b.b):rx.j in method: com.tencent.mm.plugin.appbrand.g.c.h.gZ(boolean):void, file: classes8.dex
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
            	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:806)
            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:746)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
            	... 18 more
            Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0031: INVOKE  (r0v3 rx.d) = 
              (wrap: rx.d : 0x002b: INVOKE  (r0v2 rx.d) = 
              (wrap: rx.d$a : ?: CAST (rx.d$a) (wrap: com.tencent.mm.plugin.appbrand.g.c.a$2 : 0x0028: CONSTRUCTOR  (r4v0 com.tencent.mm.plugin.appbrand.g.c.a$2) = 
              (wrap: com.tencent.mm.plugin.appbrand.g.c.a : 0x0022: IGET  (r0v1 com.tencent.mm.plugin.appbrand.g.c.a) = (r2v0 'cVar' com.tencent.mm.plugin.appbrand.g.c.b$c) com.tencent.mm.plugin.appbrand.g.c.b.c.lkB com.tencent.mm.plugin.appbrand.g.c.a)
              (wrap: com.tencent.mm.plugin.appbrand.g.a.d : 0x0024: IGET  (r3v0 com.tencent.mm.plugin.appbrand.g.a.d) = (r2v0 'cVar' com.tencent.mm.plugin.appbrand.g.c.b$c) com.tencent.mm.plugin.appbrand.g.c.b.c.lkA com.tencent.mm.plugin.appbrand.g.a.d)
             call: com.tencent.mm.plugin.appbrand.g.c.a.2.<init>(com.tencent.mm.plugin.appbrand.g.c.a, com.tencent.mm.plugin.appbrand.g.a.d):void type: CONSTRUCTOR))
             type: STATIC call: rx.d.a(rx.d$a):rx.d)
              (wrap: rx.d$c : ?: CAST (rx.d$c) (wrap: rx.d$c<T, T> : 0x002f: IGET  (r2v1 rx.d$c<T, T>) = (r2v0 'cVar' com.tencent.mm.plugin.appbrand.g.c.b$c) com.tencent.mm.plugin.appbrand.g.d.b.llt rx.d$c))
             type: VIRTUAL call: rx.d.a(rx.d$c):rx.d in method: com.tencent.mm.plugin.appbrand.g.c.h.gZ(boolean):void, file: classes8.dex
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
            	at jadx.core.codegen.InsnGen.addArgDot(InsnGen.java:87)
            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:715)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
            	... 24 more
            Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x002b: INVOKE  (r0v2 rx.d) = 
              (wrap: rx.d$a : ?: CAST (rx.d$a) (wrap: com.tencent.mm.plugin.appbrand.g.c.a$2 : 0x0028: CONSTRUCTOR  (r4v0 com.tencent.mm.plugin.appbrand.g.c.a$2) = 
              (wrap: com.tencent.mm.plugin.appbrand.g.c.a : 0x0022: IGET  (r0v1 com.tencent.mm.plugin.appbrand.g.c.a) = (r2v0 'cVar' com.tencent.mm.plugin.appbrand.g.c.b$c) com.tencent.mm.plugin.appbrand.g.c.b.c.lkB com.tencent.mm.plugin.appbrand.g.c.a)
              (wrap: com.tencent.mm.plugin.appbrand.g.a.d : 0x0024: IGET  (r3v0 com.tencent.mm.plugin.appbrand.g.a.d) = (r2v0 'cVar' com.tencent.mm.plugin.appbrand.g.c.b$c) com.tencent.mm.plugin.appbrand.g.c.b.c.lkA com.tencent.mm.plugin.appbrand.g.a.d)
             call: com.tencent.mm.plugin.appbrand.g.c.a.2.<init>(com.tencent.mm.plugin.appbrand.g.c.a, com.tencent.mm.plugin.appbrand.g.a.d):void type: CONSTRUCTOR))
             type: STATIC call: rx.d.a(rx.d$a):rx.d in method: com.tencent.mm.plugin.appbrand.g.c.h.gZ(boolean):void, file: classes8.dex
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
            	at jadx.core.codegen.InsnGen.addArgDot(InsnGen.java:87)
            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:715)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
            	... 30 more
            Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: ?: CAST (rx.d$a) (wrap: com.tencent.mm.plugin.appbrand.g.c.a$2 : 0x0028: CONSTRUCTOR  (r4v0 com.tencent.mm.plugin.appbrand.g.c.a$2) = 
              (wrap: com.tencent.mm.plugin.appbrand.g.c.a : 0x0022: IGET  (r0v1 com.tencent.mm.plugin.appbrand.g.c.a) = (r2v0 'cVar' com.tencent.mm.plugin.appbrand.g.c.b$c) com.tencent.mm.plugin.appbrand.g.c.b.c.lkB com.tencent.mm.plugin.appbrand.g.c.a)
              (wrap: com.tencent.mm.plugin.appbrand.g.a.d : 0x0024: IGET  (r3v0 com.tencent.mm.plugin.appbrand.g.a.d) = (r2v0 'cVar' com.tencent.mm.plugin.appbrand.g.c.b$c) com.tencent.mm.plugin.appbrand.g.c.b.c.lkA com.tencent.mm.plugin.appbrand.g.a.d)
             call: com.tencent.mm.plugin.appbrand.g.c.a.2.<init>(com.tencent.mm.plugin.appbrand.g.c.a, com.tencent.mm.plugin.appbrand.g.a.d):void type: CONSTRUCTOR) in method: com.tencent.mm.plugin.appbrand.g.c.h.gZ(boolean):void, file: classes8.dex
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
            	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:806)
            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:746)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
            	... 36 more
            Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0028: CONSTRUCTOR  (r4v0 com.tencent.mm.plugin.appbrand.g.c.a$2) = 
              (wrap: com.tencent.mm.plugin.appbrand.g.c.a : 0x0022: IGET  (r0v1 com.tencent.mm.plugin.appbrand.g.c.a) = (r2v0 'cVar' com.tencent.mm.plugin.appbrand.g.c.b$c) com.tencent.mm.plugin.appbrand.g.c.b.c.lkB com.tencent.mm.plugin.appbrand.g.c.a)
              (wrap: com.tencent.mm.plugin.appbrand.g.a.d : 0x0024: IGET  (r3v0 com.tencent.mm.plugin.appbrand.g.a.d) = (r2v0 'cVar' com.tencent.mm.plugin.appbrand.g.c.b$c) com.tencent.mm.plugin.appbrand.g.c.b.c.lkA com.tencent.mm.plugin.appbrand.g.a.d)
             call: com.tencent.mm.plugin.appbrand.g.c.a.2.<init>(com.tencent.mm.plugin.appbrand.g.c.a, com.tencent.mm.plugin.appbrand.g.a.d):void type: CONSTRUCTOR in method: com.tencent.mm.plugin.appbrand.g.c.h.gZ(boolean):void, file: classes8.dex
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:290)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
            	... 42 more
            Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.tencent.mm.plugin.appbrand.g.c.a, state: GENERATED_AND_UNLOADED
            	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
            	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
            	... 46 more
            */
        /*
            this = this;
            r5 = 222905(0x366b9, float:3.12356E-40)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r5)
            com.tencent.mm.plugin.appbrand.g.a.h r0 = new com.tencent.mm.plugin.appbrand.g.a.h
            r0.<init>(r7)
            boolean r1 = r6.enabled
            if (r1 != 0) goto L_0x001b
            java.lang.String r0 = com.tencent.mm.plugin.appbrand.g.c.h.TAG
            java.lang.String r1 = "DLNA Router is not enable"
            com.tencent.mm.plugin.appbrand.g.a.e(r0, r1)
            com.tencent.matrix.trace.core.AppMethodBeat.o(r5)
        L_0x001a:
            return
        L_0x001b:
            rx.f.b r1 = r6.lla
            com.tencent.mm.plugin.appbrand.g.c.b$c r2 = new com.tencent.mm.plugin.appbrand.g.c.b$c
            r2.<init>(r0)
            com.tencent.mm.plugin.appbrand.g.c.a r0 = r2.lkB
            com.tencent.mm.plugin.appbrand.g.a.d r3 = r2.lkA
            com.tencent.mm.plugin.appbrand.g.c.a$2 r4 = new com.tencent.mm.plugin.appbrand.g.c.a$2
            r4.<init>(r3)
            rx.d r0 = rx.d.a(r4)
            rx.d$c<T, T> r2 = r2.llt
            rx.d r0 = r0.a(r2)
            com.tencent.mm.plugin.appbrand.g.c.h$3 r2 = new com.tencent.mm.plugin.appbrand.g.c.h$3
            r2.<init>()
            com.tencent.mm.plugin.appbrand.g.c.h$4 r3 = new com.tencent.mm.plugin.appbrand.g.c.h$4
            r3.<init>()
            rx.j r0 = r0.a(r2, r3)
            r1.b(r0)
            com.tencent.matrix.trace.core.AppMethodBeat.o(r5)
            goto L_0x001a
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.g.c.h.gZ(boolean):void");
    }

    public final void a(final e eVar, final com.tencent.mm.plugin.appbrand.g.c.a.a aVar) {
        AppMethodBeat.i(159003);
        if (!this.enabled) {
            com.tencent.mm.plugin.appbrand.g.a.e(TAG, "DLNA Router is not enable");
            AppMethodBeat.o(159003);
            return;
        }
        this.lla.b(new b.C0582b(eVar).bBv().a(new rx.b.b<com.tencent.mm.plugin.appbrand.g.c.b.e>() {
            /* class com.tencent.mm.plugin.appbrand.g.c.h.AnonymousClass1 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // rx.b.b
            public final /* synthetic */ void cA(com.tencent.mm.plugin.appbrand.g.c.b.e eVar) {
                AppMethodBeat.i(158992);
                com.tencent.mm.plugin.appbrand.g.c.b.e eVar2 = eVar;
                com.tencent.mm.plugin.appbrand.g.a.i(h.TAG, "Send Tcp Custom:" + eVar.bBg() + " response: code=" + eVar2.responseCode);
                if (aVar != null) {
                    if (eVar2.responseCode == 200) {
                        aVar.b(eVar2);
                        AppMethodBeat.o(158992);
                        return;
                    }
                    aVar.a(eVar2);
                }
                AppMethodBeat.o(158992);
            }
        }, new rx.b.b<Throwable>() {
            /* class com.tencent.mm.plugin.appbrand.g.c.h.AnonymousClass2 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // rx.b.b
            public final /* synthetic */ void cA(Throwable th) {
                AppMethodBeat.i(158993);
                Throwable th2 = th;
                if (!(th2 == null || th2.getMessage() == null)) {
                    com.tencent.mm.plugin.appbrand.g.a.e(h.TAG, "sendTcpCustom fail: " + th2.getMessage());
                }
                if (aVar != null) {
                    aVar.a(null);
                }
                AppMethodBeat.o(158993);
            }
        }));
        AppMethodBeat.o(159003);
    }

    public final void a(final com.tencent.mm.plugin.appbrand.g.c.b.b bVar) {
        AppMethodBeat.i(159004);
        try {
            a(this.llc);
            if (this.enabled) {
                if (b(bVar)) {
                    this.lla.b(new b.a(bVar).bBv().a(new rx.b.b<com.tencent.mm.plugin.appbrand.g.b.b>() {
                        /* class com.tencent.mm.plugin.appbrand.g.c.h.AnonymousClass5 */

                        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                        @Override // rx.b.b
                        public final /* synthetic */ void cA(com.tencent.mm.plugin.appbrand.g.b.b bVar) {
                            boolean z;
                            int i2 = 0;
                            AppMethodBeat.i(158995);
                            com.tencent.mm.plugin.appbrand.g.b.b bVar2 = bVar;
                            if (bVar2 == null || bVar2.dGP == null || bVar2.ljP == null) {
                                AppMethodBeat.o(158995);
                                return;
                            }
                            h.this.llf.remove(bVar2.ljO);
                            c a2 = c.a(bVar2);
                            if (a2 != null) {
                                String a3 = h.a(h.this, bVar.get("USN"));
                                if (!TextUtils.isEmpty(a3)) {
                                    a2.bBo().uuid = a3;
                                    com.tencent.mm.plugin.appbrand.g.b.a bBl = com.tencent.mm.plugin.appbrand.g.b.a.bBl();
                                    if (!bBl.ljM) {
                                        if (bBl.ljN.containsKey(a3)) {
                                            c cVar = bBl.ljN.get(a3);
                                            if (cVar == null || !cVar.equals(a2)) {
                                                z = false;
                                            } else {
                                                AppMethodBeat.o(158995);
                                                return;
                                            }
                                        } else {
                                            z = true;
                                        }
                                        bBl.ljN.put(a3, a2);
                                        while (i2 < bBl.listeners.size()) {
                                            a.AbstractC0581a aVar = bBl.listeners.get(i2);
                                            if (aVar != null) {
                                                if (z) {
                                                    aVar.a(a2);
                                                } else {
                                                    aVar.c(a2);
                                                }
                                                i2++;
                                            } else {
                                                bBl.listeners.remove(i2);
                                            }
                                        }
                                    }
                                }
                            }
                            AppMethodBeat.o(158995);
                        }
                    }, new rx.b.b<Throwable>() {
                        /* class com.tencent.mm.plugin.appbrand.g.c.h.AnonymousClass6 */

                        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                        @Override // rx.b.b
                        public final /* synthetic */ void cA(Throwable th) {
                            AppMethodBeat.i(158996);
                            Throwable th2 = th;
                            h.this.llf.clear();
                            if (th2 == null || th2.getMessage() == null) {
                                com.tencent.mm.plugin.appbrand.g.a.e(h.TAG, "get mDevice info err");
                                AppMethodBeat.o(158996);
                                return;
                            }
                            com.tencent.mm.plugin.appbrand.g.a.e(h.TAG, "get mDevice info err:" + th2.getMessage());
                            AppMethodBeat.o(158996);
                        }
                    }));
                } else {
                    com.tencent.mm.plugin.appbrand.g.a.i(TAG, "parser fail");
                }
                this.llc.unlock();
                AppMethodBeat.o(159004);
            }
        } catch (Exception e2) {
            com.tencent.mm.plugin.appbrand.g.a.a(TAG, e2, "");
        } finally {
            this.llc.unlock();
            AppMethodBeat.o(159004);
        }
    }

    private boolean b(com.tencent.mm.plugin.appbrand.g.c.b.b bVar) {
        AppMethodBeat.i(159005);
        String str = bVar.get("NT");
        String str2 = bVar.get("ST");
        String str3 = bVar.get("NTS");
        String str4 = bVar.get("USN");
        String str5 = bVar.get(CodePackage.LOCATION);
        if (!"upnp:rootdevice".equals(str) && !"upnp:rootdevice".equals(str2)) {
            AppMethodBeat.o(159005);
            return false;
        } else if (this.llf.size() <= 0 || !this.llf.contains(str5)) {
            String KB = KB(str4);
            if (TextUtils.isEmpty(KB)) {
                AppMethodBeat.o(159005);
                return false;
            }
            com.tencent.mm.plugin.appbrand.g.b.a bBl = com.tencent.mm.plugin.appbrand.g.b.a.bBl();
            if ("ssdp:alive".equals(str3)) {
                c Yb = bBl.Yb(KB);
                if (Yb != null) {
                    if (!Yb.bBo().ljO.equals(str5)) {
                        bBl.remove(KB);
                        this.llf.add(str5);
                        AppMethodBeat.o(159005);
                        return true;
                    }
                    AppMethodBeat.o(159005);
                    return false;
                } else if (!TextUtils.isEmpty(str5)) {
                    this.llf.add(str5);
                    AppMethodBeat.o(159005);
                    return true;
                } else {
                    AppMethodBeat.o(159005);
                    return false;
                }
            } else if ("ssdp:byebye".equals(str3)) {
                if (bBl.contains(KB)) {
                    bBl.remove(KB);
                }
                AppMethodBeat.o(159005);
                return false;
            } else if (TextUtils.isEmpty(str5)) {
                com.tencent.mm.plugin.appbrand.g.a.e(TAG, "mDevice location is empty");
                AppMethodBeat.o(159005);
                return false;
            } else if (!bBl.contains(KB)) {
                AppMethodBeat.o(159005);
                return true;
            } else {
                AppMethodBeat.o(159005);
                return false;
            }
        } else {
            AppMethodBeat.o(159005);
            return false;
        }
    }

    private String KB(String str) {
        String str2 = null;
        AppMethodBeat.i(159006);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(159006);
        } else {
            Matcher matcher = this.lle.matcher(str);
            if (matcher.find()) {
                str2 = matcher.group(1);
            }
            if (str2 == null) {
                if ($assertionsDisabled || str != null) {
                    str2 = Yd(str);
                } else {
                    AssertionError assertionError = new AssertionError();
                    AppMethodBeat.o(159006);
                    throw assertionError;
                }
            }
            AppMethodBeat.o(159006);
        }
        return str2;
    }

    private static String Yd(String str) {
        AppMethodBeat.i(222906);
        com.tencent.mm.plugin.appbrand.g.a.e(TAG, "fallbackGetUuid: ".concat(String.valueOf(str)));
        if (str.startsWith("uuid:")) {
            String substring = str.substring(5);
            AppMethodBeat.o(222906);
            return substring;
        }
        AppMethodBeat.o(222906);
        return str;
    }

    private static void a(Lock lock) {
        AppMethodBeat.i(159007);
        try {
            if (!lock.tryLock(ToolTipPopup.DEFAULT_POPUP_DISPLAY_TIME, TimeUnit.MILLISECONDS)) {
                com.tencent.mm.plugin.appbrand.g.c.c.a aVar = new com.tencent.mm.plugin.appbrand.g.c.c.a("Router wasn't available exclusively after waiting 6000ms, lock failed: " + lock.getClass().getSimpleName());
                AppMethodBeat.o(159007);
                throw aVar;
            }
            AppMethodBeat.o(159007);
        } catch (InterruptedException e2) {
            com.tencent.mm.plugin.appbrand.g.c.c.a aVar2 = new com.tencent.mm.plugin.appbrand.g.c.c.a("Interruption while waiting for exclusive access: " + lock.getClass().getSimpleName(), e2);
            AppMethodBeat.o(159007);
            throw aVar2;
        }
    }
}

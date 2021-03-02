package com.tencent.mm.plugin.performance.elf;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import java.util.Random;
import org.json.JSONArray;
import org.json.JSONObject;

public final class b {
    public static long AUF = 1200000;
    public static final b AUL = new b();
    public static final C1573b AUM = new C1573b((byte) 0);
    public static final Runnable AUN = new a((byte) 0);
    public static final MMHandler AUg = new MMHandler(Looper.getMainLooper());
    public static boolean DEBUG = false;
    public boolean ded = false;

    static {
        AppMethodBeat.i(125000);
        AppMethodBeat.o(125000);
    }

    public static boolean bF(float f2) {
        AppMethodBeat.i(124999);
        String a2 = ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_android_process_hard_info, "");
        if (!TextUtils.isEmpty(a2)) {
            try {
                JSONArray jSONArray = new JSONObject(a2).getJSONArray("hard-open");
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    JSONObject jSONObject = jSONArray.getJSONObject(i2);
                    String string = jSONObject.getString("device-brand");
                    String string2 = jSONObject.getString("device-model");
                    int i3 = jSONObject.getInt("sdk-version");
                    String str = Build.BRAND + " " + Build.MODEL;
                    Log.i("MicroMsg.ProcessElf", "[checkHardOpen] name:%s model:%s version:%s | %s %s ", string, string2, Integer.valueOf(i3), str, Integer.valueOf(Build.VERSION.SDK_INT));
                    if (i3 <= Build.VERSION.SDK_INT && str.contains(string) && str.contains(string2)) {
                        AppMethodBeat.o(124999);
                        return true;
                    }
                }
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.ProcessElf", e2, "", new Object[0]);
            }
        } else {
            Log.i("MicroMsg.ProcessElf", "[checkHardOpen] json is Empty! just pass!");
        }
        int nextInt = new Random().nextInt(10000);
        boolean z = 10000.0f * f2 > ((float) nextInt);
        Log.i("MicroMsg.ProcessElf", "[checkHardOpen] rand:%s test:%s isEnable:%s", Float.valueOf(f2), Integer.valueOf(nextInt), Boolean.valueOf(z));
        AppMethodBeat.o(124999);
        return z;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: com.tencent.mm.plugin.performance.elf.b$b  reason: collision with other inner class name */
    public static final class C1573b extends BroadcastReceiver {
        private C1573b() {
        }

        /* synthetic */ C1573b(byte b2) {
            this();
        }

        public final void onReceive(final Context context, Intent intent) {
            boolean z;
            AppMethodBeat.i(124998);
            if ("ACTION_ELF_CHECK_RESPONSE".equals(intent.getAction())) {
                ElfCheckResponse elfCheckResponse = (ElfCheckResponse) intent.getParcelableExtra("MicroMsg.ElfCheckResponse");
                if (elfCheckResponse == null) {
                    Log.i("MicroMsg.ProcessElf", "[onReceive] response is null!");
                    AppMethodBeat.o(124998);
                    return;
                }
                if (!elfCheckResponse.ded) {
                    b.AUg.removeCallbacksAndMessages(null);
                }
                MMHandler mMHandler = b.AUg;
                if (!elfCheckResponse.ded || !elfCheckResponse.AUn || !elfCheckResponse.AUo) {
                    Log.w("MicroMsg.ElfCheckResponse", "can't call process[%s]", elfCheckResponse.processName);
                    z = false;
                } else {
                    mMHandler.postDelayed(
                    /*  JADX ERROR: Method code generation error
                        jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0050: INVOKE  
                          (r1v6 'mMHandler' com.tencent.mm.sdk.platformtools.MMHandler)
                          (wrap: com.tencent.mm.plugin.performance.elf.ElfCheckResponse$1 : 0x004b: CONSTRUCTOR  (r4v5 com.tencent.mm.plugin.performance.elf.ElfCheckResponse$1) = 
                          (r0v8 'elfCheckResponse' com.tencent.mm.plugin.performance.elf.ElfCheckResponse)
                          (r10v0 'context' android.content.Context)
                         call: com.tencent.mm.plugin.performance.elf.ElfCheckResponse.1.<init>(com.tencent.mm.plugin.performance.elf.ElfCheckResponse, android.content.Context):void type: CONSTRUCTOR)
                          (wrap: long : 0x004e: IGET  (r6v3 long) = (r0v8 'elfCheckResponse' com.tencent.mm.plugin.performance.elf.ElfCheckResponse) com.tencent.mm.plugin.performance.elf.ElfCheckResponse.AUr long)
                         type: VIRTUAL call: com.tencent.mm.sdk.platformtools.MMHandler.postDelayed(java.lang.Runnable, long):boolean in method: com.tencent.mm.plugin.performance.elf.b.b.onReceive(android.content.Context, android.content.Intent):void, file: classes4.dex
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:217)
                        	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:110)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:56)
                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                        	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:157)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                        	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:143)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
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
                        Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x004b: CONSTRUCTOR  (r4v5 com.tencent.mm.plugin.performance.elf.ElfCheckResponse$1) = 
                          (r0v8 'elfCheckResponse' com.tencent.mm.plugin.performance.elf.ElfCheckResponse)
                          (r10v0 'context' android.content.Context)
                         call: com.tencent.mm.plugin.performance.elf.ElfCheckResponse.1.<init>(com.tencent.mm.plugin.performance.elf.ElfCheckResponse, android.content.Context):void type: CONSTRUCTOR in method: com.tencent.mm.plugin.performance.elf.b.b.onReceive(android.content.Context, android.content.Intent):void, file: classes4.dex
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                        	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
                        	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
                        	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:806)
                        	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:746)
                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                        	... 30 more
                        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.tencent.mm.plugin.performance.elf.ElfCheckResponse, state: GENERATED_AND_UNLOADED
                        	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
                        	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                        	... 36 more
                        */
                    /*
                    // Method dump skipped, instructions count: 188
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.performance.elf.b.C1573b.onReceive(android.content.Context, android.content.Intent):void");
                }
            }

            static final class a implements Runnable {
                private a() {
                }

                /* synthetic */ a(byte b2) {
                    this();
                }

                public final void run() {
                    AppMethodBeat.i(124996);
                    Log.i("MicroMsg.ProcessElf", "send check broadcast!");
                    ElfCheckRequest elfCheckRequest = new ElfCheckRequest();
                    elfCheckRequest.dap = b.eCr();
                    Intent intent = new Intent("ACTION_ELF_CHECK");
                    intent.putExtra("MicroMsg.ElfCheckRequest", elfCheckRequest);
                    MMApplicationContext.getContext().sendBroadcast(intent);
                    b.AUg.postDelayed(this, b.eCr());
                    AppMethodBeat.o(124996);
                }
            }

            public static long eCr() {
                if (DEBUG) {
                    return 8000;
                }
                return AUF;
            }
        }

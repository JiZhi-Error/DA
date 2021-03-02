package com.tencent.mm.recoveryv2;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Pair;
import com.facebook.internal.ServerProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.recoveryv2.l;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicBoolean;

public interface g {
    g bT(String str, long j2);

    g bhB(String str);

    g de(String str, boolean z);

    g gL(String str, int i2);

    boolean getBoolean(String str, boolean z);

    int getInt(String str, int i2);

    long getLong(String str, long j2);

    String getString(String str, String str2);

    g guE();

    g guF();

    g guG();

    g mK(String str, String str2);

    public static class a implements g {
        final File NBF;
        final File NBG;
        private final AtomicBoolean NBH;
        private final Bundle mExtras;

        @Override // com.tencent.mm.recoveryv2.g
        public final /* synthetic */ g bT(String str, long j2) {
            AppMethodBeat.i(193796);
            a bU = bU(str, j2);
            AppMethodBeat.o(193796);
            return bU;
        }

        @Override // com.tencent.mm.recoveryv2.g
        public final /* synthetic */ g guE() {
            AppMethodBeat.i(193802);
            a guH = guH();
            AppMethodBeat.o(193802);
            return guH;
        }

        @Override // com.tencent.mm.recoveryv2.g
        public final /* synthetic */ g guF() {
            AppMethodBeat.i(193801);
            a guI = guI();
            AppMethodBeat.o(193801);
            return guI;
        }

        public a(Context context, String str) {
            this(new File(l.iU(context), str));
            AppMethodBeat.i(193784);
            AppMethodBeat.o(193784);
        }

        private a(File file) {
            AppMethodBeat.i(193785);
            this.mExtras = new Bundle();
            this.NBH = new AtomicBoolean();
            this.NBF = file;
            this.NBG = new File(this.NBF, "fast_persist_data");
            AppMethodBeat.o(193785);
        }

        private a guH() {
            AppMethodBeat.i(193786);
            try {
                File file = this.NBG;
                if (file == null) {
                    IOException iOException = new IOException("Dir is null.");
                    AppMethodBeat.o(193786);
                    throw iOException;
                }
                if (file.exists()) {
                    if (!file.isDirectory()) {
                        if (!l.b.M(file)) {
                            IOException iOException2 = new IOException("Fail to delete existing file, file = " + file.getAbsolutePath());
                            AppMethodBeat.o(193786);
                            throw iOException2;
                        }
                        file.mkdir();
                    }
                    this.NBH.set(true);
                    AppMethodBeat.o(193786);
                    return this;
                }
                file.mkdirs();
                if (!file.exists() || !file.isDirectory()) {
                    IOException iOException3 = new IOException("Fail to create dir, dir = " + file.getAbsolutePath());
                    AppMethodBeat.o(193786);
                    throw iOException3;
                }
                this.NBH.set(true);
                AppMethodBeat.o(193786);
                return this;
            } catch (Throwable th) {
                a.w("MicroMsg.recovery.fastPersist", "create persist dir fail", th);
            }
        }

        private a guI() {
            AppMethodBeat.i(193787);
            aTL();
            for (String str : this.mExtras.keySet()) {
                Object obj = this.mExtras.get(str);
                if (obj != null) {
                    Pair<String, File> bhC = bhC(str);
                    if (bhC != null) {
                        l.b.M((File) bhC.second);
                    }
                    try {
                        l.b.O(new File(this.NBG, ".FP__KEY__" + str + "__VALUE__" + obj));
                    } catch (Throwable th) {
                        a.w("MicroMsg.recovery.fastPersist", "create file pair store fail", th);
                    }
                }
            }
            AppMethodBeat.o(193787);
            return this;
        }

        private void aTL() {
            AppMethodBeat.i(193788);
            if (!this.NBH.get()) {
                IllegalStateException illegalStateException = new IllegalStateException("Persis#load() has not yet been called");
                AppMethodBeat.o(193788);
                throw illegalStateException;
            }
            AppMethodBeat.o(193788);
        }

        /*  JADX ERROR: StackOverflowError in pass: MarkFinallyVisitor
            java.lang.StackOverflowError
            	at jadx.core.dex.nodes.InsnNode.isSame(InsnNode.java:311)
            	at jadx.core.dex.instructions.InvokeNode.isSame(InvokeNode.java:77)
            	at jadx.core.dex.visitors.MarkFinallyVisitor.sameInsns(MarkFinallyVisitor.java:451)
            	at jadx.core.dex.visitors.MarkFinallyVisitor.compareBlocks(MarkFinallyVisitor.java:436)
            	at jadx.core.dex.visitors.MarkFinallyVisitor.checkBlocksTree(MarkFinallyVisitor.java:408)
            	at jadx.core.dex.visitors.MarkFinallyVisitor.checkBlocksTree(MarkFinallyVisitor.java:411)
            */
        private android.util.Pair<java.lang.String, java.io.File> bhC(java.lang.String r10) {
            /*
            // Method dump skipped, instructions count: 241
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.recoveryv2.g.a.bhC(java.lang.String):android.util.Pair");
        }

        @Override // com.tencent.mm.recoveryv2.g
        public final boolean getBoolean(String str, boolean z) {
            AppMethodBeat.i(193790);
            aTL();
            if (this.mExtras.containsKey(str)) {
                boolean z2 = this.mExtras.getBoolean(str);
                AppMethodBeat.o(193790);
                return z2;
            }
            Pair<String, File> bhC = bhC(str);
            if (bhC != null) {
                String str2 = (String) bhC.first;
                if (str2.equalsIgnoreCase(ServerProtocol.DIALOG_RETURN_SCOPES_TRUE) || str2.equalsIgnoreCase("false")) {
                    boolean parseBoolean = Boolean.parseBoolean(str2);
                    AppMethodBeat.o(193790);
                    return parseBoolean;
                }
            }
            AppMethodBeat.o(193790);
            return z;
        }

        @Override // com.tencent.mm.recoveryv2.g
        public final int getInt(String str, int i2) {
            AppMethodBeat.i(193791);
            int am = l.am(getLong(str, (long) i2), i2);
            AppMethodBeat.o(193791);
            return am;
        }

        @Override // com.tencent.mm.recoveryv2.g
        public final long getLong(String str, long j2) {
            AppMethodBeat.i(193792);
            aTL();
            if (this.mExtras.containsKey(str)) {
                long j3 = this.mExtras.getLong(str);
                AppMethodBeat.o(193792);
                return j3;
            }
            Pair<String, File> bhC = bhC(str);
            if (bhC != null) {
                String str2 = (String) bhC.first;
                if (l.isNumeric(str2)) {
                    try {
                        long parseLong = Long.parseLong(str2);
                        AppMethodBeat.o(193792);
                        return parseLong;
                    } catch (Throwable th) {
                    }
                }
            }
            AppMethodBeat.o(193792);
            return j2;
        }

        private a bU(String str, long j2) {
            AppMethodBeat.i(193793);
            this.mExtras.putLong(str, j2);
            AppMethodBeat.o(193793);
            return this;
        }

        @Override // com.tencent.mm.recoveryv2.g
        public final String getString(String str, String str2) {
            AppMethodBeat.i(193794);
            aTL();
            if (this.mExtras.containsKey(str)) {
                String string = this.mExtras.getString(str);
                AppMethodBeat.o(193794);
                return string;
            }
            Pair<String, File> bhC = bhC(str);
            if (bhC != null) {
                String str3 = (String) bhC.first;
                AppMethodBeat.o(193794);
                return str3;
            }
            AppMethodBeat.o(193794);
            return str2;
        }

        @Override // com.tencent.mm.recoveryv2.g
        public final /* synthetic */ g mK(String str, String str2) {
            AppMethodBeat.i(193795);
            this.mExtras.putString(str, str2);
            AppMethodBeat.o(193795);
            return this;
        }

        @Override // com.tencent.mm.recoveryv2.g
        public final /* synthetic */ g gL(String str, int i2) {
            AppMethodBeat.i(193797);
            a bU = bU(str, (long) i2);
            AppMethodBeat.o(193797);
            return bU;
        }

        @Override // com.tencent.mm.recoveryv2.g
        public final /* synthetic */ g de(String str, boolean z) {
            AppMethodBeat.i(193798);
            this.mExtras.putBoolean(str, z);
            AppMethodBeat.o(193798);
            return this;
        }

        @Override // com.tencent.mm.recoveryv2.g
        public final /* synthetic */ g bhB(String str) {
            AppMethodBeat.i(193799);
            aTL();
            this.mExtras.remove(str);
            Pair<String, File> bhC = bhC(str);
            if (bhC != null) {
                l.b.M((File) bhC.second);
            }
            AppMethodBeat.o(193799);
            return this;
        }

        @Override // com.tencent.mm.recoveryv2.g
        public final /* synthetic */ g guG() {
            AppMethodBeat.i(193800);
            a guI = guI();
            AppMethodBeat.o(193800);
            return guI;
        }
    }

    public static class b implements g {
        private final String NBI;
        private SharedPreferences NBJ;
        private final Context mContext;
        private final Bundle mExtras = new Bundle();

        @Override // com.tencent.mm.recoveryv2.g
        public final /* synthetic */ g bT(String str, long j2) {
            AppMethodBeat.i(193814);
            b bV = bV(str, j2);
            AppMethodBeat.o(193814);
            return bV;
        }

        @Override // com.tencent.mm.recoveryv2.g
        public final /* synthetic */ g guE() {
            AppMethodBeat.i(193820);
            b guJ = guJ();
            AppMethodBeat.o(193820);
            return guJ;
        }

        public b(Context context, String str) {
            AppMethodBeat.i(193803);
            this.mContext = context;
            this.NBI = str;
            AppMethodBeat.o(193803);
        }

        public final b guJ() {
            AppMethodBeat.i(193804);
            this.NBJ = this.mContext.getSharedPreferences(this.NBI, 4);
            AppMethodBeat.o(193804);
            return this;
        }

        private void guK() {
            AppMethodBeat.i(193805);
            if (this.NBJ == null) {
                IllegalStateException illegalStateException = new IllegalStateException("Persis#load() has not yet been called");
                AppMethodBeat.o(193805);
                throw illegalStateException;
            }
            AppMethodBeat.o(193805);
        }

        private SharedPreferences.Editor guL() {
            AppMethodBeat.i(193806);
            SharedPreferences.Editor edit = this.NBJ.edit();
            for (String str : this.mExtras.keySet()) {
                Object obj = this.mExtras.get(str);
                if (obj != null) {
                    String obj2 = obj.toString();
                    if (l.isNumeric(obj2)) {
                        try {
                            edit.putLong(str, Long.parseLong(obj2));
                        } catch (Throwable th) {
                        }
                    } else if (obj2.equalsIgnoreCase(ServerProtocol.DIALOG_RETURN_SCOPES_TRUE) || obj2.equalsIgnoreCase("false")) {
                        edit.putBoolean(str, Boolean.parseBoolean(obj2));
                    } else {
                        edit.putString(str, obj2);
                    }
                }
            }
            AppMethodBeat.o(193806);
            return edit;
        }

        @Override // com.tencent.mm.recoveryv2.g
        public final boolean getBoolean(String str, boolean z) {
            AppMethodBeat.i(193807);
            guK();
            if (this.mExtras.containsKey(str)) {
                boolean z2 = this.mExtras.getBoolean(str);
                AppMethodBeat.o(193807);
                return z2;
            }
            boolean z3 = this.NBJ.getBoolean(str, z);
            AppMethodBeat.o(193807);
            return z3;
        }

        @Override // com.tencent.mm.recoveryv2.g
        public final int getInt(String str, int i2) {
            AppMethodBeat.i(193808);
            int am = l.am(getLong(str, (long) i2), i2);
            AppMethodBeat.o(193808);
            return am;
        }

        @Override // com.tencent.mm.recoveryv2.g
        public final long getLong(String str, long j2) {
            AppMethodBeat.i(193809);
            guK();
            if (this.mExtras.containsKey(str)) {
                long j3 = this.mExtras.getLong(str);
                AppMethodBeat.o(193809);
                return j3;
            }
            long a2 = a(this.NBJ, str, j2);
            AppMethodBeat.o(193809);
            return a2;
        }

        private b bV(String str, long j2) {
            AppMethodBeat.i(193810);
            guK();
            this.mExtras.putLong(str, j2);
            AppMethodBeat.o(193810);
            return this;
        }

        @Override // com.tencent.mm.recoveryv2.g
        public final String getString(String str, String str2) {
            AppMethodBeat.i(193811);
            guK();
            if (this.mExtras.containsKey(str)) {
                String string = this.mExtras.getString(str);
                AppMethodBeat.o(193811);
                return string;
            }
            String string2 = this.NBJ.getString(str, str2);
            AppMethodBeat.o(193811);
            return string2;
        }

        private static long a(SharedPreferences sharedPreferences, String str, long j2) {
            AppMethodBeat.i(193812);
            if (!sharedPreferences.contains(str)) {
                AppMethodBeat.o(193812);
                return j2;
            }
            try {
                long j3 = sharedPreferences.getLong(str, j2);
                AppMethodBeat.o(193812);
                return j3;
            } catch (Throwable th) {
                AppMethodBeat.o(193812);
                return j2;
            }
        }

        @Override // com.tencent.mm.recoveryv2.g
        public final /* synthetic */ g mK(String str, String str2) {
            AppMethodBeat.i(193813);
            guK();
            this.mExtras.putString(str, str2);
            AppMethodBeat.o(193813);
            return this;
        }

        @Override // com.tencent.mm.recoveryv2.g
        public final /* synthetic */ g gL(String str, int i2) {
            AppMethodBeat.i(193815);
            b bV = bV(str, (long) i2);
            AppMethodBeat.o(193815);
            return bV;
        }

        @Override // com.tencent.mm.recoveryv2.g
        public final /* synthetic */ g de(String str, boolean z) {
            AppMethodBeat.i(193816);
            guK();
            this.mExtras.putBoolean(str, z);
            AppMethodBeat.o(193816);
            return this;
        }

        @Override // com.tencent.mm.recoveryv2.g
        public final /* synthetic */ g bhB(String str) {
            AppMethodBeat.i(193817);
            guK();
            this.mExtras.remove(str);
            this.NBJ.edit().remove(str).apply();
            AppMethodBeat.o(193817);
            return this;
        }

        @Override // com.tencent.mm.recoveryv2.g
        public final /* synthetic */ g guG() {
            AppMethodBeat.i(193818);
            guK();
            guL().apply();
            AppMethodBeat.o(193818);
            return this;
        }

        @Override // com.tencent.mm.recoveryv2.g
        @SuppressLint({"ApplySharedPref"})
        public final /* synthetic */ g guF() {
            AppMethodBeat.i(193819);
            guK();
            guL().commit();
            AppMethodBeat.o(193819);
            return this;
        }
    }
}
